package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.InjAdministrationTransDATA;
import mms.transactions.controller.fb.InjAdministrationTransFB;

public class InjAdministrationTransCNT extends CSRFGardTokenAction 
{

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		generateToken(request);
		InjAdministrationTransFB formBean = (InjAdministrationTransFB) form;
		return this.INITVAL(mapping, formBean, request, response);
   }	
  
	public ActionForward INITVAL(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws HisException, SQLException 
   {		
		System.out.println(" ********* InjAdministrationTransCNT . INITVAL ********* [injAdmin_transNew.jsp , InjAdminTrans.js ]***[ Plz Check JavaScript function onGoButton() ] ********* ");
		
		generateToken(request);
		InjAdministrationTransFB formBean = (InjAdministrationTransFB) form;		
		formBean.setStrDoseFrqFlg("0");
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());			
		InjAdministrationTransDATA.getStoreDtls(formBean, request);			
		formBean.setStrCrNo(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
		formBean.setStrCRorLFwise("1");
		
		String target = "injAdmin_issue";
		
		return mapping.findForward(target);
	} 
    
   	public ActionForward INJ_ADMINISTRATION_WITHOUT_CR(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
    {
		System.out.println(" ********* InjAdministrationTransCNT.INJ_ADMINISTRATION_WITHOUT_CR *** [ Plz Check JavaScript function onGoButton() ] ********* ");
		
		generateToken(request);
		String target="";
		InjAdministrationTransFB formBean = (InjAdministrationTransFB) form;
		
		formBean.setStrCrNo(formBean.getCrNo());		
		
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());	
		System.out.println(" ****************************** B ************************************* ");
		
        System.out.println(" request.getParameter(strStoreId)----- "+request.getParameter("strId"));
        System.out.println(" request.getParameter(getStrCrNo)----- "+request.getParameter("crNo"));
   	    System.out.println(" formBean.getStrCrNo()           ----- "+formBean.getStrCrNo());
   	    System.out.println(" formBean.getStrRecommendDate()  ----- "+formBean.getStrRecommendDate());
   	    System.out.println(" formBean.getStrStatus()         ----- "+formBean.getStrStatus());
   	    System.out.println(" formBean.getStrTypeId()         ----- "+formBean.getStrTypeId());  
   	    System.out.println(" formBean.getCheckFlg()          ----- "+formBean.getCheckFlg());  
   	    
   	    System.out.println(" ******************************************************************* ");   	    
   	    formBean.setStrStoreId(request.getParameter("strId"));   	
   	    formBean.setStrStoreName(formBean.getStoreName());   
   		formBean.setStrStoreId(request.getParameter("strId"));		
		InjAdministrationTransDATA.getPatientTreatmentAdviceDetails(formBean, request, response);			
		formBean.setStrStoreId(formBean.getStrStoreId());				
		System.out.println(" ********* target => injAdmin_transGoNew.jsp [ InjAdminTrans.js ] ********* ");
	    target = "injAdmin_issue_GO";   
		return mapping.findForward(target);
			
		
	}
	
	public ActionForward INJ_ADMINISTRATION(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
     {
		System.out.println(" ********* InjAdministrationTransCNT.INJ_ADMINISTRATION *** [ Plz Check JavaScript function onGoButton() ] ********* ");
		
		generateToken(request);
		String target="";
		InjAdministrationTransFB formBean = (InjAdministrationTransFB) form;
		
		if(formBean.getNewreqflg().equalsIgnoreCase("1"))
		{
			formBean.setStrCrNo(formBean.getCrNo());
		}
		
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		
		System.out.println(" ****************************** A ************************************* ");
		
        System.out.println(" request.getParameter(strStoreId)----- "+request.getParameter("strId"));
        System.out.println(" request.getParameter(getStrCrNo)----- "+request.getParameter("crNo"));
   	    System.out.println(" formBean.getStrCrNo()           ----- "+formBean.getStrCrNo());
   	    System.out.println(" formBean.getStrRecommendDate()  ----- "+formBean.getStrRecommendDate());
   	    System.out.println(" formBean.getStrStatus()         ----- "+formBean.getStrStatus());
   	    System.out.println(" formBean.getStrTypeId()         ----- "+formBean.getStrTypeId());  
   	    System.out.println(" formBean.getCheckFlg()          ----- "+formBean.getCheckFlg());     
   	    System.out.println(" ******************************************************************* ");   	    
    	
    	formBean.setStrStoreId(request.getParameter("strId"));
    	
    	formBean.setStrStoreName(formBean.getStoreName());
    	
    	InjAdministrationTransDATA.getPatientStatus(formBean, request, response);
    	if(formBean.getStrInvalidCrFlag().equals("2"))
    	{
    		System.out.println(" *********In-Valid CR-[ target =  injAdmin_transNew.jsp ] ********* ");
    		InjAdministrationTransDATA.getStoreDtls(formBean, request);	
			formBean.setStrErrMsg(" In Valid PIN . Drug Dispensing Only For OPD Patient !!! ");	
			formBean.setStrCrNo(formBean.getStrHospitalCode());			
			return this.INITVAL(mapping,formBean,request,response);	
    	}
    	else
    	{	
    		formBean.setStrStoreId(request.getParameter("strId"));        
			InjAdministrationTransDATA.getPatientTreatmentAdviceDetails(formBean, request, response);			
			formBean.setStrStoreId(formBean.getStrStoreId());				
			System.out.println(" ********* target => injAdmin_transGoNew.jsp [ InjAdminTrans.js ] ********* ");
		    target = "injAdmin_issue_GO";   
    	}
		
		return mapping.findForward(target);
			
		
	}
	
	public ActionForward NEW_OPD_ISSUE_INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
   {
		System.out.println(" ********* InjAdministrationTransCNT.NEW_OPD_ISSUE_INSERT  ********* ");
		
		validateToken(request, response);
		InjAdministrationTransFB formBean = (InjAdministrationTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		InjAdministrationTransDATA.NEW_OPD_ISSUE_INSERT(formBean, request);			
		formBean.setPrintReq("1");
		if(formBean.getStrVisitDtl().equals("0"))
		{
			return this.INJ_ADMINISTRATION(mapping, form, request, response);
		}
		else
		{
			return this.INITVAL(mapping, form, request, response);
		}
		
	}
	
	//_This Prcoess is Used to Get After Issue POP-UP
	public ActionForward ISSUEDTLPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		System.out.println(" ********* InjAdministrationTransCNT.ISSUEDTLPOPUP  ********* ");
     
		InjAdministrationTransFB formBean = (InjAdministrationTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		InjAdministrationTransDATA.getIssuePopUp(formBean, request, response);
		
		return this.INITVAL(mapping, form, request, response);
	}
	
	//_jump control to view2 page to get issued details list 
	public ActionForward VIEWPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println(" ********* InjAdministrationTransCNT.VIEWPAGE ********* [ injAdmin_View2.jsp , InjAdminTrans.js] *********");
		
		String strTarget="view2";
		InjAdministrationTransFB formBean = (InjAdministrationTransFB) form;	
		generateToken(request);	
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		InjAdministrationTransDATA.getStoreDtlsView(formBean, request);
		InjAdministrationTransDATA.getAdministerModeCombo(formBean, request);
		return mapping.findForward(strTarget);
	}
	
	public ActionForward ISSUEDTLPOPUP_ORG(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		System.out.println(" ********* InjAdministrationTransCNT.ISSUEDTLPOPUP_ORG  ********* ");     
		InjAdministrationTransFB formBean = (InjAdministrationTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		InjAdministrationTransDATA.getIssuePopUp(formBean, request, response);
		return null;
	}
	
	//_issue no issue date == */
	public ActionForward PREVISSUEDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		System.out.println(" ********* InjAdministrationTransCNT.PREVISSUEDTL  ********* ");
		
		InjAdministrationTransFB formBean = (InjAdministrationTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		InjAdministrationTransDATA.getIssueDetails(formBean, request, response);
		return null;
	}	
		
	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
	    ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	/*
	 * To Get the Cancel Page
	 */
	
	public ActionForward GETCANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {	
		System.out.println(" ********* InjAdministrationTransCNT.GETCANCELPAGE  ********* ");
		
		InjAdministrationTransFB formBean = (InjAdministrationTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		InjAdministrationTransDATA.getStoreDtls(formBean, request);		
		String target = "cancelIssue";
		return mapping.findForward(target);
	} 
	
	/*
	 * To Get the Item Category Combo
	 */
	
	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println(" ********* InjAdministrationTransCNT.ITEMCATCMB  ********* ");
		InjAdministrationTransFB formBean = (InjAdministrationTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		InjAdministrationTransDATA.getItemCatDtls(formBean,request, response);
		
		return null;
	}
	
	public ActionForward GET_PAT_ACC_STATUS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println(" ********* InjAdministrationTransCNT.GET_PAT_ACC_STATUS  --[ After Go Click Check Account Status ]----- ");
		InjAdministrationTransFB formBean = (InjAdministrationTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		InjAdministrationTransDATA.GET_PAT_ACC_STATUS(formBean,request, response);
		
		return null;
	}

		
	public ActionForward REQUESTDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ********* InjAdministrationTransCNT.REQUESTDTLS  ********* ");
		
		InjAdministrationTransFB formBean = (InjAdministrationTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		InjAdministrationTransDATA.getRequestDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward UNITCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ********* InjAdministrationTransCNT.UNITCMB  ********* ");
		InjAdministrationTransFB formBean = (InjAdministrationTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		InjAdministrationTransDATA.getUnitDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward PRESCRIPEDBY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ********* InjAdministrationTransCNT.PRESCRIPEDBY  ********* ");
		
		InjAdministrationTransFB formBean = (InjAdministrationTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		InjAdministrationTransDATA.getPrescribedBy(formBean, request, response);
		return null;
	}
	
	public ActionForward ITEMDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ********* InjAdministrationTransCNT.ITEMDETAILS  ********* ");
		
		InjAdministrationTransFB formBean = (InjAdministrationTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		InjAdministrationTransDATA.getItemDetails(formBean, request, response);
		return null;
	}
			
	/**
	 * 
	 * Method is used to get View details after pressing GO button
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	
	public ActionForward GOVIEWPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println(" ********* InjAdministrationTransCNT.GOVIEWPAGE  ********* ");
			
		InjAdministrationTransFB fb = (InjAdministrationTransFB) form;
		InjAdministrationTransDATA.getViewDtl(fb, request, response);
		return null;
	}	
		
	public ActionForward ALREADYISSUEDRUG(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ********* InjAdministrationTransCNT.ALREADYISSUEDRUG  ********* ");
		
		InjAdministrationTransFB fb = (InjAdministrationTransFB) form;
		InjAdministrationTransDATA.getAlreadyIssueDrug(fb, request, response);
		return null;
	}
	
	

	public ActionForward PRESFORMDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ********* InjAdministrationTransCNT.PRESFORMDTLS  ********* ");
		InjAdministrationTransFB fb = (InjAdministrationTransFB) form;
		InjAdministrationTransDATA.getPresFormDtl(fb, request, response);
		return null;
	}
	
	public ActionForward GETPRESCDATA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ********* InjAdministrationTransCNT.GETPRESCDATA  ********* ");
		
		InjAdministrationTransFB formBean = (InjAdministrationTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		InjAdministrationTransDATA.getOnlineTreatmentDtl(formBean, request, response);
		return null;
	}
	
	public ActionForward saveInjAdministratedDtl_Ajax(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		System.out.println(" ------- InjAdministrationTransCNT . saveInjAdministratedDtl_Ajax  --------- ");
		
		InjAdministrationTransFB formBean = (InjAdministrationTransFB) form;
		//formBean.setStrChk(request.getParameter("chk"));
		InjAdministrationTransDATA.saveInjAdministratedDtl_Ajax(formBean, request, response);
		return null;
	}
	
	public ActionForward getInjAdministratedDtl_Ajax(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		System.out.println(" ------- InjAdministrationTransCNT . getInjAdministratedDtl_Ajax  --------- ");
		
		InjAdministrationTransFB formBean = (InjAdministrationTransFB) form;
		//formBean.setStrChk(request.getParameter("chk"));
		InjAdministrationTransDATA.getInjAdministratedDtl_Ajax(formBean, request, response);
		return null;
	}
	
	public ActionForward reloadAdministrationDtl_Ajax(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		System.out.println(" ------- InjAdministrationTransCNT . reloadAdministrationDtl_Ajax  --------- ");
		
		InjAdministrationTransFB formBean = (InjAdministrationTransFB) form;
		//formBean.setStrChk(request.getParameter("chk"));
		InjAdministrationTransDATA.reloadAdministrationDtl_Ajax(formBean, request, response);
		return null;
	}

}
