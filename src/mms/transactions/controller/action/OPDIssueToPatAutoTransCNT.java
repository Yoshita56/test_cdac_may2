package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.OPDIssueToPatAutoTransDATA;
import mms.transactions.controller.fb.OPDIssueToPatAutoTransFB;


public class OPDIssueToPatAutoTransCNT extends CSRFGardTokenAction 
{

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		generateToken(request);
		OPDIssueToPatAutoTransFB formBean = (OPDIssueToPatAutoTransFB) form;
		return this.INITVAL(mapping, formBean, request, response);
   }	
	
   /*
    * Method In Use
    * */	
   public ActionForward INITVAL(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws HisException, SQLException 
   {		
		System.out.println(" ------- OPDIssueToPatAutoTransCNT . INITVAL  -----[OPDAutoTrans.jsp , OPDAutoOPDIssueToPatAutoTransBs.js ]--[ Plz Check JavaScript function onGoButton() ] -- ");
		
		generateToken(request);
		OPDIssueToPatAutoTransFB formBean = (OPDIssueToPatAutoTransFB) form;		
		formBean.setStrDoseFrqFlg("0");
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());			
		OPDIssueToPatAutoTransDATA.getStoreDtls(formBean, request);			
		formBean.setStrCrNo(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
		if(formBean.getStrCRorLFwise()==null || formBean.getStrCRorLFwise()=="")
		formBean.setStrCRorLFwise("1");
		
		String target = "opd_issue";
		
		return mapping.findForward(target);
	} 
	
	
	public ActionForward ISSUE_OPD_OFFLINE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
     {
		System.out.println(" ------- OPDIssueToPatAutoTransCNT.ISSUE_OPD_OFFLINE  ------[ OPDAutoIssueTransNew.jsp , OPDIssueToPatAutoTransBs.js]--[ Plz Check JavaScript function onGoButton() ]- ");
		
		generateToken(request);
		String target="";
		OPDIssueToPatAutoTransFB formBean = (OPDIssueToPatAutoTransFB) form;
		
		if(formBean.getNewreqflg().equalsIgnoreCase("1"))
		{
			formBean.setStrCrNo(formBean.getCrNo());
		}
		
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		System.out.println(" formBean.getStrStoreId          ----- "+formBean.getStrStoreId());
        System.out.println(" request.getParameter(strStoreId)----- "+request.getParameter("strId"));
        System.out.println(" request.getParameter(getStrCrNo)----- "+request.getParameter("crNo"));
    	System.out.println(" formBean.getStrCrNo()           ----- "+formBean.getStrCrNo());
    	
    	OPDIssueToPatAutoTransDATA.getPatientStatus(formBean, request, response);
    	if(formBean.getStrInvalidCrFlag().equals("2"))
    	{
    		System.out.println(" ------- In-Valid CR-[ target =  OPDAutoTrans.jsp ]-- ");
    		OPDIssueToPatAutoTransDATA.getStoreDtls(formBean, request);	
			formBean.setStrErrMsg(" In Valid CR No . Drug Dispensing Only For OPD Patient !!! ");	
			formBean.setStrCrNo(formBean.getStrHospitalCode());			
			return this.INITVAL(mapping,formBean,request,response);	
    	}
    	else
    	{	
			OPDIssueToPatAutoTransDATA.getDiirecIssueInitData(formBean,request, response);
			OPDIssueToPatAutoTransDATA.getPatientDetails(formBean, request, response);				
	    	formBean.setStrStoreId(formBean.getStrStoreId());		    	       	
			//OPDIssueToPatAutoTransDATA.getOnlineReqDtl(formBean, request, response);
			OPDIssueToPatAutoTransDATA.getDeptDetails(formBean, request);
			
			//OPDIssueToPatAutoTransDATA.getFrequencyDetails(formBean, request);
			//OPDIssueToPatAutoTransDATA.getDoseDetails(formBean, request);
			
			if(!formBean.getStrIssueMode().equals("0"))
			{
				OPDIssueToPatAutoTransDATA.getGroupDetails(formBean, request);
			}
			
			System.out.println(" ---B---- target => OPDAutoIssueTransNew.jsp --- ");
		    target = "opd_issueGo_offLine";   
    	}
		
		return mapping.findForward(target);
			
		
	}
	public ActionForward NEW_OPD_ISSUE_INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
   {
		System.out.println(" ------- OPDIssueToPatAutoTransCNT.NEW_OPD_ISSUE_INSERT  ------- ");
		
		validateToken(request, response);
		OPDIssueToPatAutoTransFB formBean = (OPDIssueToPatAutoTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		OPDIssueToPatAutoTransDATA.NEW_OPD_ISSUE_INSERT(formBean, request);			
		formBean.setPrintReq("1");
		if(formBean.getStrVisitDtl().equals("0"))
		{
			return this.ISSUE_OPD_OFFLINE(mapping, form, request, response);
		}
		else
		{
			return this.INITVAL(mapping, form, request, response);
		}
		
	}
	
	/*
	 * This Prcoess is Used to Get After Issue POP-UP
	 * 
	 * */
	public ActionForward ISSUEDTLPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		System.out.println(" ------- OPDIssueToPatAutoTransCNT.ISSUEDTLPOPUP  ------- ");
     
		OPDIssueToPatAutoTransFB formBean = (OPDIssueToPatAutoTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		OPDIssueToPatAutoTransDATA.getIssuePopUp(formBean, request, response);
		
		return this.INITVAL(mapping, form, request, response);
	}
	
	/**
	 * 
	 * forwards control to the View page of this  Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	// jump control to view2 page to get issued details list 
	public ActionForward VIEWPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println(" ------- OPDIssueToPatAutoTransCNT.VIEWPAGE  ----[ OPDAutoView_PreviousIssueOPD.jsp , OPDAutoOPDIssueToPatAutoTransBs.js]--- ");
		
		String strTarget="view2";
		OPDIssueToPatAutoTransFB formBean = (OPDIssueToPatAutoTransFB) form;
		//formBean.setStrflg("0");
		generateToken(request);
		//OPDIssueToPatAutoTransDATA.getMmsConfigFlags(formBean, request,	response);
		
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		//formBean.setStrCrNo(formBean.getStrCrNo());
				
		OPDIssueToPatAutoTransDATA.getStoreDtlsView(formBean, request);
		//formBean.setStrflg("1");
		return mapping.findForward(strTarget);
	}
	
	
	
	
	
	public ActionForward ISSUEDTLPOPUP_ORG(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		System.out.println(" ------- OPDIssueToPatAutoTransCNT.ISSUEDTLPOPUP_ORG  ------- ");     
		OPDIssueToPatAutoTransFB formBean = (OPDIssueToPatAutoTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		OPDIssueToPatAutoTransDATA.getIssuePopUp(formBean, request, response);
		return null;
	}
	
	/* == issue no issue date == */
	public ActionForward PREVISSUEDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		System.out.println(" ------- OPDIssueToPatAutoTransCNT.PREVISSUEDTL  ------- ");
		
		OPDIssueToPatAutoTransFB formBean = (OPDIssueToPatAutoTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		OPDIssueToPatAutoTransDATA.getIssueDetails(formBean, request, response);
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
		System.out.println(" ------- OPDIssueToPatAutoTransCNT.GETCANCELPAGE  ------- ");
		
		OPDIssueToPatAutoTransFB formBean = (OPDIssueToPatAutoTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		OPDIssueToPatAutoTransDATA.getStoreDtls(formBean, request);		
		String target = "cancelIssue";
		return mapping.findForward(target);
	} 
	
	/*
	 * To Get the Item Category Combo
	 */
	
	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println(" ------- OPDIssueToPatAutoTransCNT.ITEMCATCMB  ------- ");
		OPDIssueToPatAutoTransFB formBean = (OPDIssueToPatAutoTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		OPDIssueToPatAutoTransDATA.getItemCatDtls(formBean,request, response);
		
		return null;
	}
	
	public ActionForward GET_PAT_ACC_STATUS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println(" ------- OPDIssueToPatAutoTransCNT.GET_PAT_ACC_STATUS  --[ After Go Click Check Account Status ]----- ");
		OPDIssueToPatAutoTransFB formBean = (OPDIssueToPatAutoTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		OPDIssueToPatAutoTransDATA.GET_PAT_ACC_STATUS(formBean,request, response);
		
		return null;
	}

		
	public ActionForward REQUESTDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- OPDIssueToPatAutoTransCNT.REQUESTDTLS  ------- ");
		
		OPDIssueToPatAutoTransFB formBean = (OPDIssueToPatAutoTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		OPDIssueToPatAutoTransDATA.getRequestDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward UNITCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- OPDIssueToPatAutoTransCNT.UNITCMB  ------- ");
		OPDIssueToPatAutoTransFB formBean = (OPDIssueToPatAutoTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		OPDIssueToPatAutoTransDATA.getUnitDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward PRESCRIPEDBY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- OPDIssueToPatAutoTransCNT.PRESCRIPEDBY  ------- ");
		
		OPDIssueToPatAutoTransFB formBean = (OPDIssueToPatAutoTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		OPDIssueToPatAutoTransDATA.getPrescribedBy(formBean, request, response);
		return null;
	}
	
	public ActionForward ITEMDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- OPDIssueToPatAutoTransCNT.ITEMDETAILS  ------- ");
		
		OPDIssueToPatAutoTransFB formBean = (OPDIssueToPatAutoTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		OPDIssueToPatAutoTransDATA.getItemDetails(formBean, request, response);
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
		System.out.println(" ------- OPDIssueToPatAutoTransCNT.GOVIEWPAGE  ------- ");
			
		OPDIssueToPatAutoTransFB fb = (OPDIssueToPatAutoTransFB) form;
		OPDIssueToPatAutoTransDATA.getViewDtl(fb, request, response);
		return null;
	}	
	/**
	 * 
	 * Method is used to get issue item details after billing 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	
	public ActionForward ISSUEDTLSBILLED(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println(" ------- OPDIssueToPatAutoTransCNT.ISSUEDTLSBILLED  ------- ");
			
		OPDIssueToPatAutoTransFB fb = (OPDIssueToPatAutoTransFB) form;
		OPDIssueToPatAutoTransDATA.getBilledItemDtls(fb, request, response);
		return null;
	}
		
	public ActionForward TARIFFCHK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- OPDIssueToPatAutoTransCNT.TARIFFCHK  ------- ");
		
		OPDIssueToPatAutoTransFB fb = (OPDIssueToPatAutoTransFB) form;
		OPDIssueToPatAutoTransDATA.getTariffDtl(fb, request, response);
		return null;
	}
	
	public ActionForward ALREADYISSUEDRUG(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- OPDIssueToPatAutoTransCNT.ALREADYISSUEDRUG  ------- ");
		
		OPDIssueToPatAutoTransFB fb = (OPDIssueToPatAutoTransFB) form;
		OPDIssueToPatAutoTransDATA.getAlreadyIssueDrug(fb, request, response);
		return null;
	}
	
	public ActionForward GETREQTYPE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- OPDIssueToPatAutoTransCNT.GETREQTYPE  ------- ");
		
		OPDIssueToPatAutoTransFB fb = (OPDIssueToPatAutoTransFB) form;
		OPDIssueToPatAutoTransDATA.getReqType(fb, request, response);
		return null;
	}
	
		
	public ActionForward EPISODEDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- OPDIssueToPatAutoTransCNT.EPISODEDTLS  ------- ");
		
		OPDIssueToPatAutoTransFB fb = (OPDIssueToPatAutoTransFB) form;
		OPDIssueToPatAutoTransDATA.getEpisodeDtl(fb, request, response);
		return null;
	}

	public ActionForward PRESFORMDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- OPDIssueToPatAutoTransCNT.PRESFORMDTLS  ------- ");
		OPDIssueToPatAutoTransFB fb = (OPDIssueToPatAutoTransFB) form;
		OPDIssueToPatAutoTransDATA.getPresFormDtl(fb, request, response);
		return null;
	}
	
	public ActionForward GETPRESCDATA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- OPDIssueToPatAutoTransCNT.GETPRESCDATA  ------- ");
		
		OPDIssueToPatAutoTransFB formBean = (OPDIssueToPatAutoTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		OPDIssueToPatAutoTransDATA.getOnlineTreatmentDtl(formBean, request, response);
		return null;
	}
	
	
	public ActionForward STOCKDTLSINIT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		 OPDIssueToPatAutoTransFB formBean = (OPDIssueToPatAutoTransFB) form;		
		 System.out.println("-----OPDIssueToPatAutoTransCNT.STOCKDTLSINIT ------");
		 OPDIssueToPatAutoTransDATA.stockItemDtlsInit(request, response, formBean);
		 return null;
	}
	
	public ActionForward NA_ITEM_LIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		OPDIssueToPatAutoTransFB formBean = (OPDIssueToPatAutoTransFB) form;
		
		 System.out.println("-----OPDIssueToPatAutoTransCNT.NA_ITEM_LIST ------");

		 OPDIssueToPatAutoTransDATA.getNALIst(request, response, formBean);

		return null;
	}

	

}