package dossier.transaction.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import dossier.transaction.controller.data.DossierSettlementDATA;
import dossier.transaction.controller.fb.DossierSettlementFB;

public class DossierSettlementCNT extends DispatchAction {
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws Exception
	{
		System.out.println("Inside DossierSettlementCNT Form");
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
				
		
		/*LPIssueDeskTransUTL
		 * hnum_dossier_req_id||'@'||gnum_hospital_code
              ||'@' ||hrgnum_puk  ||'@'||hnum_req_mode
              ||'@' || hnum_ref_req_id ||'@' ||hnum_servicetype_id
              ||'@' ||hnum_service_id  ||'@' ||hstr_service_name
              ||'@' || hnum_dossier_id ||'@'  ||hnum_dossier_status
              ||'@' ||hstr_entry_remark||'@' ||hstr_post_remark
              ||'@' || hnum_cancel_reason_id ||'@' || hstr_cancel_remark
              ||'@'  || gnum_isvalid ||'@' || gdt_entry_date ||'@'|| gnum_seat_id
              ||'@' || Nvl(a.hstnum_patient_type,0) ||'@'|| dossier_mst.Get_dossier_sort_name(hnum_dossier_id::numeric, gnum_hospital_code::numeric, hnum_servicetype_id::numeric)
		 * */
		
		System.out.println("<--------   LPIssueDeskTransCNT. SETTLEMENT --> DossierSettlementCNT.NEW() ---- [ Dossier_Settlement.jsp ON-LOAD  DossierRequisitionCNT.ISSUEDTLSINITONE() for Voucher ] ------->");
		System.out.println("<---------- DossierSettlementCNT.NEW()----------->"+request.getParameter("chk"));
		String strCrNo        = request.getParameter("chk").replace("@", "#").split("#")[2];
		String strServiceType = request.getParameter("chk").replace("@", "#").split("#")[5];
								
		System.out.println("Service Type--11 - OT , 12 - RADIOLOGY , 13 - SERVICE AREA --->>>"+strServiceType);
		DossierSettlementFB formBean = (DossierSettlementFB) form;
		formBean.setStrCrNo(strCrNo);
		formBean.setStrSericeType(strServiceType);
		return mapping.findForward("NEW");
	}
	
	
	
	
	
	public ActionForward NEW1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		DossierSettlementFB formBean = (DossierSettlementFB) form;
		formBean.setPrintReq("1");
		
		System.out.println("<----------DossierSettlementCNT .NEW1()----------->");
		
		return mapping.findForward("NEW");
	}
	
	public ActionForward INITVALGO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
   {
		
		generateToken(request);
		System.out.println("<----------DossierSettlementCNT.INITVALGO()---[ dossier_settlement_trans_go.jsp ]-------->");
		String target="";
		DossierSettlementFB formBean = (DossierSettlementFB) form;
		if(formBean.getNewreqflg().equalsIgnoreCase("1"))
		{
			formBean.setStrCrNo(formBean.getCrNo());
		}
		formBean.setPrintReq("0");
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
	    //System.out.println("formBean.getStrCrNo()>>>"+formBean.getStrCrNo());
	    //System.out.println("formBean.getStrLFNo()>>>"+formBean.getStrLFNo());
	
	    DossierSettlementDATA.getPatientDetails(formBean, request, response);
		 //System.out.println("formBean.getStrCrNo()>>>"+formBean.getStrCrNo());
	    formBean.setCrNo(formBean.getStrCrNo());
		if(formBean.getStrInvalidCrFlag().equals("1") || formBean.getStrInvalidLFFlag().equals("1") )
		{
			
			return this.INITVAl(mapping, formBean, request, response);
			
		}
		else
		{
			DossierSettlementDATA.getOnlineReqDtl(formBean, request, response);
			
			target = "GO";
			
				
			return mapping.findForward(target);
		}
		
	
	}
	
	public ActionForward GETDOSSIERITEMDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		System.out.println("<----------DossierSettlementCNT.GETDOSSIERITEMDTLS()---[ Get Item Dtls At Time of Dossier Settelment ]-------->");
		
		DossierSettlementFB formBean = (DossierSettlementFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		DossierSettlementDATA.getDossierItemDetails(formBean, request, response);
		return null;
	}
	public ActionForward GETDOSSIERITEMDTLSOPD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		DossierSettlementFB formBean = (DossierSettlementFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		DossierSettlementDATA.getDossierItemDetailsopd(formBean, request, response);
		return null;
	}
	public ActionForward GETSERVICEDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		DossierSettlementFB formBean = (DossierSettlementFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		DossierSettlementDATA.getServiceDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward GETDOSSIERNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		DossierSettlementFB formBean = (DossierSettlementFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		DossierSettlementDATA.getDossierDetails(formBean, request, response);
		return null;
	}
	
	
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
   {
		System.out.println("<----------DossierSettlementCNT.INSERT()----------->");
		DossierSettlementFB formBean = (DossierSettlementFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		DossierSettlementDATA.INSERT(formBean, request, response);
		//return mapping.findForward("GO");
		return this.NEW1(mapping, formBean, request, response);
	}
	
	public ActionForward SETTELMENTVOUCHER(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		System.out.println("<<<------DossierSettlementCNT--------SETTELMENTVOUCHER----[ For Settelemnt Voucher ]------------>>>");
		DossierSettlementFB formBean = (DossierSettlementFB) form;
		DossierSettlementDATA.issueDtlsInit(request, response, formBean);
		return null;
	}
	
	
	// Added By Ranjit for Dossier OT Integration
	public ActionForward INSERTOT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
   {
     
		DossierSettlementFB formBean = (DossierSettlementFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		DossierSettlementDATA.INSERTOT(formBean, request, response);
		//return mapping.findForward("GO");
		//return this.NEW1(mapping, formBean, request, response);
		return null;
	}
	

	public ActionForward INSERTOPD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
   {
     
		DossierSettlementFB formBean = (DossierSettlementFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		DossierSettlementDATA.INSERTOPD(formBean, request, response);
		//return mapping.findForward("GO");
		return this.NEW1(mapping, formBean, request, response);
	}
	public ActionForward INITVAl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
	
		DossierSettlementFB formBean = (DossierSettlementFB) form;
	
		return mapping.findForward("NEW");
	}
	public ActionForward CANCELTODESK(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
	
			ActionForward acFwd = new ActionForward();
		 	//acFwd.setPath("/dossier/transaction/DossierDeskTransCNT.cnt?hmode=RETURNTOMAINDESK");
		 	acFwd.setPath("/dossier/transaction/LPIssueDeskTransCNT.cnt?hmode=RETURNTOMAINDESK");
		 	
		 	
	    	acFwd.setContextRelative(true);
	        return acFwd;
	        
		//DossierSettlementFB formBean = (DossierSettlementFB) form;
	
		//return mapping.findForward("NEW");
	}
	
	public ActionForward ISSUEDTLSINITONE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		DossierSettlementFB formBean = (DossierSettlementFB) form;
		DossierSettlementDATA.issueDtlsInit(request, response, formBean);
		return null;
	}
	
	// Added By Ranjit for Dossier OT Integration
	public ActionForward getOTDossierRadio(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		DossierSettlementFB formBean = (DossierSettlementFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		DossierSettlementDATA.getOTDossierId(formBean,request, response );
		return null;
	}
	
	// Added By Ranjit for Dossier OT Integration
public ActionForward rejectDossier(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		DossierSettlementFB formBean = (DossierSettlementFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		DossierSettlementDATA.rejectDossier(formBean,request, response );
		return null;
	}

// Added By Ranjit for Dossier OT Integration
public ActionForward ajaxGetDossierStatusString(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
	
	DossierSettlementFB formBean = (DossierSettlementFB) form;
	formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
	
	
	DossierSettlementDATA.ajaxGetDossierStatusString(formBean, request, response);
	
	return null;
}
	
	
		
	

}
