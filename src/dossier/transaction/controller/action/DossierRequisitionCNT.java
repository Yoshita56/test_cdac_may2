package dossier.transaction.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import dossier.transaction.controller.data.DossierRequisitionDATA;
import dossier.transaction.controller.fb.DossierRequisitionFB;

public class DossierRequisitionCNT extends DispatchAction {
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		//System.out.println("Inside DossierRequisitionCNT Form");
		return this.NEW(mapping, form, request, response);
	}

	/**
	 * sets the view to Patient Listing View
	 * 
	 * @param mapping -object of ActionMapping
	 * @param form - object of ActionForm
	 * @param request - HttpServletRequest
	 * @param response - HttpServletResponse
	 * @return action forwards to the output view called "NEW"
	 */
	public ActionForward NEW(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		System.out.println("<<<------------DossierRequisitionCNT--After CR No Validation NEW---------------->>>");
		/*DoctorDeskFB formBean = (DoctorDeskFB) form;
		 * 
		DoctorDeskDATA.getInitailData(formBean ,request);*/
		System.out.println("servicetypeId-----"+request.getParameter("servicetypeId"));
		DossierRequisitionFB formBean = (DossierRequisitionFB) form;
		formBean.setStrSericeType(request.getParameter("servicetypeId"));
		return mapping.findForward("NEW");
	}
	public ActionForward NEW1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		System.out.println("<<<----------DossierRequisitionCNT----NEW1---------------->>>");
		
		DossierRequisitionFB formBean = (DossierRequisitionFB) form;
		formBean.setPrintReq("1");
		return mapping.findForward("NEW");
	}
	
	public ActionForward INITVALGO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
   {
		System.out.println("<<<----------DossierRequisitionCNT----On Go Click INITVALGO ALSO CALL FROM OT---------------->>>");
		generateToken(request);
		String target="";
		DossierRequisitionFB formBean = (DossierRequisitionFB) form;
		if(formBean.getNewreqflg().equalsIgnoreCase("1"))
		{
			formBean.setStrCrNo(formBean.getCrNo());
		}
		formBean.setPrintReq("0");
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
	    System.out.println("formBean.getStrCrNo()---->>>"+formBean.getStrCrNo());
	    System.out.println("formBean.getStrLFNo()---->>>"+formBean.getStrLFNo());
	    System.out.println("formBean.getRequestMode()---->>>"+formBean.getRequestMode());
	 
	    DossierRequisitionDATA.getPatientDetails(formBean, request, response);
		
	    System.out.println("formBean.getStrInvalidCrFlag()--->>>"+formBean.getStrInvalidCrFlag());
	    formBean.setCrNo(formBean.getStrCrNo());
		if(formBean.getStrInvalidCrFlag().equals("1") || formBean.getStrInvalidLFFlag().equals("1") )
		{
			
			return this.INITVAl(mapping, formBean, request, response);
			
		}
		else
		{
			DossierRequisitionDATA.getOnlineReqDtl(formBean, request, response);  // Pkg_Mms_View.Proc_Issue_Request_Dtls [Mode - 1]
			
			System.out.println("--------- Pkg_Mms_View.Proc_Issue_Request_Dtls [ Mode = 1]");	
			
			DossierRequisitionDATA.getDeptDetails(formBean, request);
			
			System.out.println("--------- pkg_dossier_view.proc_department [ Mode = 1]");
			
			//DossierRequisitionDATA.getUnitDetails1(formBean, request, response);
			DossierRequisitionDATA.getFrequencyDetails(formBean, request);			
			
			System.out.println("--------- Pkg_Mms_View.proc_frequency_dtl [ Mode = 1]");			
			
			
			DossierRequisitionDATA.getDoseDetails(formBean, request);
			
			System.out.println("--------- Pkg_Mms_View.proc_dosage_dtl [ Mode = 1]");
			System.out.println("--------- pkg_dossier_view.proc_service_name [ Mode = 2]");		
			
			DossierRequisitionDATA.getItemCatValues(formBean, request,response);
			
			System.out.println("--------- pkg_dossier_view.proc_item_category_list [ Mode = 1]");
			
			//DossierRequisitionDATA.getDossierValues(formBean, request,response);
			DossierRequisitionDATA.getOnlineTreatmentDtl(formBean, request, response);
			
			System.out.println("--------- pkg_mms_view.PROC_HRGT_PATIENT_TREATMENT_DTL_DRUGWISE [ Mode = 3]");
			
			
            /*
             * Updated By Amit Kumar on Date 18-Aug-2021
             * OT and Dossier Integration
             * Updted Procedure are 
             * a) ahis_operationtheatre.proc_ot_raisedoperationList();
             * b) ahis_operationtheatre.proc_ot_Dossier_Status();
             * 
             * */
			if(formBean.getRequestMode()!=null && formBean.getRequestMode().equals("OT") )
			{
				
				DossierRequisitionDATA.getOperationName(formBean, request, response);
				
				System.out.println("----OT----- ahis_operationtheatre.proc_ot_raisedoperationList()");				
				
				DossierRequisitionDATA.getDossierStatusString(formBean, request, response);
				
				System.out.println("----OT----- ahis_operationtheatre.proc_ot_Dossier_Status()");
				
				
				
				//DossierRequisitionDATA.getOTDossierId(formBean, request, response);
			}
			
			System.out.println("---------formBean.getStrBillingHiddenValue()"+formBean.getStrBillingHiddenValue());
			
			System.out.println("---------formBean.getStrBillingHiddenValue().split(\\^)[4].equals(2)--"+formBean.getStrBillingHiddenValue().split("\\^")[4]+" :: 2 Means OPD Patient");
			
			formBean.setStrDoseFrqFlg("0");
			System.out.println("---------formBean.getStrPatientType()---"+formBean.getStrPatientType());
			
			 if(formBean.getStrPatientType().equalsIgnoreCase("1"))
			{
				 if(!(formBean.getStrBillingHiddenValue().split("\\^")[4].equals("2")))
					{
						formBean.setStrErrMsg("Patient Not Admitted");
						target = "NEW";
					}else if(formBean.getStrBillingHiddenValue().split("\\^")[0].equals("0")){
						formBean.setStrErrMsg("Patient Account Not exits");
						target = "NEW";
						 System.out.println("---------Dossier_Requisition.jsp---");
					}
				 else
				 {
					 target = "GO";
					 System.out.println("---------dossier_trans_go.jsp---");
					 
					 
				 }	 
			}
		
			else{
				
				 if(formBean.getStrBillingHiddenValue().split("\\^")[4].equals("2")){
					 formBean.setStrErrMsg("Patient Admitted");
						target = "NEW"; 
				 }else{
					 target = "GOOPD";
					 System.out.println("---------dossier_trans_goipd.jsp---");
				 }
				
			}
			 
			 System.out.println("---------target---"+target);
				
			return mapping.findForward(target);
		}
		//return null;
	
	}
	
	public ActionForward GETDOSSIERITEMDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		System.out.println("<<<-------DossierRequisitionCNT-------GETDOSSIERITEMDTLS---------------->>>");
		DossierRequisitionFB formBean = (DossierRequisitionFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		DossierRequisitionDATA.getDossierItemDetails(formBean, request, response);
		return null;
	}
	public ActionForward GETDOSSIERITEMDTLSOPD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println("<<<------DossierRequisitionCNT--------GETDOSSIERITEMDTLSOPD---------------->>>");
		DossierRequisitionFB formBean = (DossierRequisitionFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		DossierRequisitionDATA.getDossierItemDetailsopd(formBean, request, response);
		return null;
	}
	public ActionForward GETSERVICEDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		System.out.println("<<<------DossierRequisitionCNT--------GETSERVICEDTLS---------------->>>");
		DossierRequisitionFB formBean = (DossierRequisitionFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		DossierRequisitionDATA.getServiceDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward GETDOSSIERNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println("<<<-----DossierRequisitionCNT---------GETDOSSIERNAME---------------->>>");
		DossierRequisitionFB formBean = (DossierRequisitionFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		DossierRequisitionDATA.getDossierDetails(formBean, request, response);
		return null;
	}
	
	
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
   {
     
		System.out.println("<<<------DossierRequisitionCNT--------INSERT---------------->>>");
		DossierRequisitionFB formBean = (DossierRequisitionFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		DossierRequisitionDATA.INSERT(formBean, request, response);
		//return mapping.findForward("GO");
		return this.NEW1(mapping, formBean, request, response);
	}
	
	
	// Added By Ranjit for Dossier OT Integration
	public ActionForward INSERTOT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
   {
		System.out.println("<<<----DossierRequisitionCNT---Insert Dossier Through OTListValidation () -------INSERTOT---------------->>>");
		DossierRequisitionFB formBean = (DossierRequisitionFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		DossierRequisitionDATA.INSERTOT(formBean, request, response);
		//return mapping.findForward("GO");
		//return this.NEW1(mapping, formBean, request, response);
		return null;
	}
	

	public ActionForward INSERTOPD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
   {
		System.out.println("<<<------DossierRequisitionCNT--------INSERTOPD---------------->>>");
		DossierRequisitionFB formBean = (DossierRequisitionFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		DossierRequisitionDATA.INSERTOPD(formBean, request, response);
		//return mapping.findForward("GO");
		return this.NEW1(mapping, formBean, request, response);
	}
	public ActionForward INITVAl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		System.out.println("<<<------DossierRequisitionCNT--------INITVAl---------------->>>");
		DossierRequisitionFB formBean = (DossierRequisitionFB) form;
	
		return mapping.findForward("NEW");
	}
	public ActionForward CANCELTODESK(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
	
			ActionForward acFwd = new ActionForward();
		 	acFwd.setPath("/dossier/transaction/DossierDeskTransCNT.cnt?hmode=RETURNTOMAINDESK");
	    	acFwd.setContextRelative(true);
	        return acFwd;
	        
		//DossierRequisitionFB formBean = (DossierRequisitionFB) form;
	
		//return mapping.findForward("NEW");
	}
	
	public ActionForward ISSUEDTLSINITONE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		System.out.println("<<<------DossierRequisitionCNT--------ISSUEDTLSINITONE----[ For  Voucher ]------------>>>");
		DossierRequisitionFB formBean = (DossierRequisitionFB) form;
		DossierRequisitionDATA.issueDtlsInit(request, response, formBean);
		return null;
	}
	
	// Added By Ranjit for Dossier OT Integration
	public ActionForward getOTDossierRadio(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		System.out.println("<<<-------DossierRequisitionCNT-----Get Dossier Name on Change of Operation Name--getOTDossierRadio----[ ahis_operationtheatre.proc_ot_Raised_dossier , ahis_operationtheatre.proc_GET_OT_dossier  ]------------>>>");
		
		DossierRequisitionFB formBean = (DossierRequisitionFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		DossierRequisitionDATA.getOTDossierId(formBean,request, response );
		return null;
	}
	
	// Added By Ranjit for Dossier OT Integration
public ActionForward rejectDossier(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
	System.out.println("<<<---------DossierRequisitionCNT-----rejectDossier---------------->>>");
	
		DossierRequisitionFB formBean = (DossierRequisitionFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		DossierRequisitionDATA.rejectDossier(formBean,request, response );
		return null;
	}

// Added By Ranjit for Dossier OT Integration
public ActionForward ajaxGetDossierStatusString(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	
	System.out.println("<<<--------DossierRequisitionCNT------ajaxGetDossierStatusString---------------->>>");
	
	DossierRequisitionFB formBean = (DossierRequisitionFB) form;
	formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
	
	
	DossierRequisitionDATA.ajaxGetDossierStatusString(formBean, request, response);
	
	return null;
}
	
	
		
	

}
