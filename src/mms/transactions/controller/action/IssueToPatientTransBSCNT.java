package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.IssueToPatientBSDATA;
import mms.transactions.controller.fb.IssueTransFB;



public class IssueToPatientTransBSCNT extends CSRFGardTokenAction {


	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		generateToken(request);
		IssueTransFB formBean = (IssueTransFB) form;
		return this.INITVAL(mapping, formBean, request, response);

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
	 * To Get the Store Combo
	 */
	
	public ActionForward INITVAL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {		
		System.out.println(" ------- IssueToPatientTransBSCNT.INITVAL  ----[issue_transNew.jsp ]---- ");
		
		generateToken(request);
		IssueTransFB formBean = (IssueTransFB) form;
		//formBean.setStrCrNoDefault("1");
		formBean.setStrDoseFrqFlg("0");
		
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		
		formBean.setStrStoreId(request.getParameter("strStoreId"));
		formBean.setStrId(request.getParameter("strStoreId"));		
		IssueToPatientBSDATA.getStoreDtls(formBean, request);
		IssueToPatientBSDATA.getDeptDetails(formBean, request);
		
		
		
		if(request.getParameter("patCrNo")!=null)
		{	
			System.out.println(" ------- IssueToPatientTransBSCNT.INITVAL  ---request.getParameter(patCrNo)--- "+request.getParameter("patCrNo"));
		    formBean.setStrCrNo(request.getParameter("patCrNo"));
		}
		else
		{
			System.out.println(" ------- IssueToPatientTransBSCNT.INITVAL  ---request.getSession().getAttribute(HOSPITAL_CODE)--- "+request.getParameter("patCrNo"));
			formBean.setStrCrNo(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		}
		//formBean.setStrCrNo("123123123");
		if(formBean.getStrCRorLFwise()==null || formBean.getStrCRorLFwise()=="")
		formBean.setStrCRorLFwise("1");
		formBean.setPrintReq("0");
		String target = "issue";
		return mapping.findForward(target);
	} 
	
	public ActionForward ISSUETOPATCOUNT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		generateToken(request);
		String target="";
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		
		
		
        System.out.println(" ------- IssueTransCNT.ISSUETOPATCOUNT  ----[issue_trans_goNew.jsp , issue_transBS.js]---- ");
        
        System.out.println(" request.getParameter(strStoreId)----- "+request.getParameter("strId"));
        System.out.println(" request.getParameter(getStrCrNo)----- "+request.getParameter("crNo"));                
    	System.out.println(" formBean.getStrCrNo()           ----- "+formBean.getStrCrNo());
		System.out.println(" formBean.getStrStoreId          ----- "+formBean.getStrStoreId());
		
        
		System.out.println(" ------- IssueTransDATA.getDiirecIssueInitData -(Drug Finder Combo)----- ");
		
		IssueToPatientBSDATA.getDiirecIssueInitData(formBean,request, response);
		
		
		try
		{
		    System.out.println(" ------- IssueTransCNT.issuetopatientcount  ---- > this.INITVALGO ");
		    this.INITVALGO(mapping, formBean, request, response);
		}
		catch(Exception e)
		{
			System.out.println(" ------- IssueTransCNT.issuetopatientcount  ---- > this.INITVAL ");
			this.INITVAL(mapping, formBean, request, response);
		}		
		System.out.println(" -C--After INITVALGO ---- target = issueGo --- ");
		target = "issueGo";	
		return mapping.findForward(target);
	}
	
    	
	public ActionForward INITVALGO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
    {
		System.out.println(" ------- IssueToPatientTransBSCNT.INITVALGO  ----[ issue_trans_goNew.jsp ]--- ");
		
		generateToken(request);
		String target="";
		IssueTransFB formBean = (IssueTransFB) form;
		if(formBean.getNewreqflg().equalsIgnoreCase("1"))
		{
			formBean.setStrCrNo(formBean.getCrNo());
		}
		
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		try
		{				
	        IssueToPatientBSDATA.getPatientDetails(formBean, request, response);
		}
		catch(Exception e)
		{
			System.out.println("--B-IN OUT---Err_Msg--"+formBean.getStrErrMsg());
			return this.INITVAL(mapping,formBean,request,response);
			
			
		}
	    formBean.setCrNo(formBean.getStrCrNo());
	    formBean.setStrStoreId(formBean.getStrStoreId());
	    formBean.setItemCategory(formBean.getStrItemCat());
		if(formBean.getStrInvalidCrFlag().equals("1") || formBean.getStrInvalidLFFlag().equals("1") || formBean.getStrInvalidLFFlag().equals("2"))
		{
			
			return this.INITVAL(mapping,formBean,request,response);
			
		}
		else
		{
			
			//IssueToPatientBSDATA.getOnlineReqDtl(formBean, request, response);
			IssueToPatientBSDATA.getDeptDetails(formBean, request);
			
			IssueToPatientBSDATA.getFrequencyDetails(formBean, request);
			IssueToPatientBSDATA.getDoseDetails(formBean, request);
			if(!formBean.getStrIssueMode().equals("0")){
			
				IssueToPatientBSDATA.getGroupDetails(formBean, request);
				
			}
			
			System.out.println(" ---B---- target = issueGo --- ");
		    target = "issueGo";   
			
			return mapping.findForward(target);
		}
	
	}
	
	public ActionForward GET_PAT_LIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println(" ------- IssueToPatientTransBSCNT.GET_PAT_LIST  ------- ");
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBSDATA.GET_PAT_LIST(formBean,request, response);
		
		return null;
	}
	
		
	public ActionForward GETVIEWPAGE(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println(" ------- IssueToPatientTransBSCNT.GETVIEWPAGE  ----[issue_transNew_view.jsp ]--- ");		
		String strTarget="newView";		
		IssueTransFB formBean = (IssueTransFB) form;
		IssueToPatientBSDATA.initViewPageDtl(formBean,request);
		return mapping.findForward(strTarget);
	}
	
	
	//voucher 
		public ActionForward ISSUEDTLPOPUP(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException 
	    {
			System.out.println(" ------- IssueToPatientTransBSCNT.ISSUEDTLPOPUP  ------- ");
	     
			IssueTransFB formBean = (IssueTransFB) form;
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			IssueToPatientBSDATA.getIssuePopUp(formBean, request, response);
			return null;
		 }
		/*
		 * Used Function
		 * */
		public ActionForward NEW_IPD_ISSUE(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception 
	   {
			System.out.println(" ------- IssueToPatientTransBSCNT.NEW_IPD_ISSUE  ------- ");
			
			validateToken(request, response);
			IssueTransFB formBean = (IssueTransFB) form;
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			IssueToPatientBSDATA.NEW_IPD_ISSUE(formBean, request);	
			
			formBean.setPrintReq("1");
			
			System.out.println("--Issue_Num--"+formBean.getStrIssueNum());
			System.out.println("--Issue_Number--"+formBean.getStrIssueNumber());
			System.out.println("--STore_Id--"+formBean.getStrStoreId());
			System.out.println("--CR_No   --"+formBean.getStrCrNo());
			
			String strTarget="voucher";					
			return mapping.findForward(strTarget);
			
			
			
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
	// view page go button hit
	public ActionForward GETCRDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		IssueTransFB fb = (IssueTransFB) form;
		IssueToPatientBSDATA.getViewDtlNEW(fb, request, response);
		return null;
	}
	
	/*
	 * To Get the Cancel Page
	 */
	
	public ActionForward GETCANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {	
		System.out.println(" ------- IssueToPatientTransBSCNT.GETCANCELPAGE  ------- ");
		
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		IssueToPatientBSDATA.getStoreDtls(formBean, request);		
		String target = "cancelIssue";
		return mapping.findForward(target);
	} 
	
	/*
	 * To Get the Item Category Combo
	 */
	
	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println(" ------- IssueToPatientTransBSCNT.ITEMCATCMB  ------- ");
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		IssueToPatientBSDATA.getItemCatDtls(formBean,request, response);
		
		return null;
	}
	
	public ActionForward GET_PAT_ACC_STATUS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println(" ------- IssueToPatientTransBSCNT.GET_PAT_ACC_STATUS  --[ After Go Click Check Account Status ]----- ");
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		IssueToPatientBSDATA.GET_PAT_ACC_STATUS(formBean,request, response);
		
		return null;
	}
	
	public ActionForward STOCKDTLSINIT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		IssueTransFB formBean = (IssueTransFB) form;
		
		 System.out.println("-----IssueToPatientTransBSCNT.STOCKDTLSINIT ------");

		 IssueToPatientBSDATA.stockItemDtlsInit(request, response, formBean);

		return null;
	}
	
	public ActionForward NA_ITEM_LIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		IssueTransFB formBean = (IssueTransFB) form;
		
		 System.out.println("-----IssueToPatientTransBSCNT.NA_ITEM_LIST ------");

		 IssueToPatientBSDATA.getNALIst(request, response, formBean);

		return null;
	}
	
	
	
	
	
	public ActionForward INITCANCELGO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		    IssueTransFB formBean = (IssueTransFB) form;
		    formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		    formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		
		    IssueToPatientBSDATA.getCancelPatientDetails(formBean, request, response);		
			
			String target = "cancelGo";
			return mapping.findForward(target);
		
	
	}
	
	public ActionForward PREVISSUEDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		System.out.println(" ------- IssueToPatientTransBSCNT.PREVISSUEDTL  ------- ");
		
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBSDATA.getIssueDetails(formBean, request, response);
		return null;
	}
	
	
	public ActionForward REQUESTDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- IssueToPatientTransBSCNT.REQUESTDTLS  ------- ");
		
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBSDATA.getRequestDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward UNITCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- IssueToPatientTransBSCNT.UNITCMB  ------- ");
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBSDATA.getUnitDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward PRESCRIPEDBY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- IssueToPatientTransBSCNT.PRESCRIPEDBY  ------- ");
		
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBSDATA.getPrescribedBy(formBean, request, response);
		return null;
	}
	
	public ActionForward ITEMDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- IssueToPatientTransBSCNT.ITEMDETAILS  ------- ");
		
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBSDATA.getItemDetails(formBean, request, response);
		return null;
	}
	
		
	
	public ActionForward INSERTIPD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
   {
		System.out.println(" ------- IssueToPatientTransBSCNT.INSERTIPD  ------- ");
		
		validateToken(request, response);
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBSDATA.insertipd(formBean, request);			
	//	this.ISSUEDTLPOPUP(mapping,form,request,response);
		formBean.setPrintReq("1");
		if(formBean.getStrVisitDtl().equals("0"))
		{
			//ActionMapping mapping, ActionForm form,
			//HttpServletRequest request, HttpServletResponse response
			return this.INITVALGO(mapping, form, request, response);
		}
		else
		{
			return this.INITVAL(mapping, form, request, response);
		}
		
	}
	
	public ActionForward INSERTCANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		System.out.println(" ------- IssueToPatientTransBSCNT.INSERTCANCEL  ------- ");
		
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatientBSDATA.insertCancel(formBean, request);			
		if(formBean.getStrVisitDtl().equals("0"))
		{
			return this.INITCANCELGO(mapping, form, request, response);
		}
		else
		{
			return this.GETCANCELPAGE(mapping, form, request, response);
		}
		
	}
	
	
	/**
	 * ISSUEDTLSINIT - gets the issue details view used for ajax.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ISSUEDTLSINIT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		IssueTransFB formBean = (IssueTransFB) form;
		IssueToPatientBSDATA.issueDtlsInit(request, response, formBean);
		return null;
	}
	
	/**
	 * ISSUEDTLSINIT - gets the issue details view used for ajax.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ISSUEDTLSINITONE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println(" ------- IssueToPatientTransBSCNT.ISSUEDTLSINITONE  ------- ");
		
		IssueTransFB formBean = (IssueTransFB) form;
		IssueToPatientBSDATA.issueDtlsInit(request, response, formBean);
		return null;
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
	
	public ActionForward VIEWPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println(" ------- IssueToPatientTransBSCNT.VIEWPAGE  ------- ");
		
		String strTarget="view";
		IssueTransFB formBean = (IssueTransFB) form;
		//formBean.setStrflg("0");
		generateToken(request);
		IssueToPatientBSDATA.getMmsConfigFlags(formBean, request,	response);
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrCrNo(formBean.getStrCrNo());
				
		IssueToPatientBSDATA.getStoreDtlsView(formBean, request);
		//formBean.setStrflg("1");
		return mapping.findForward(strTarget);
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
		System.out.println(" ------- IssueToPatientTransBSCNT.GOVIEWPAGE  ------- ");
			
		IssueTransFB fb = (IssueTransFB) form;
		IssueToPatientBSDATA.getViewDtl(fb, request, response);
		return null;
	}
	
	public ActionForward RETURNTOMAINDESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println(" ------- IssueToPatientTransBSCNT.RETURNTOMAINDESK  ------- ");
		
		ActionForward acFwd = new ActionForward();
		String strPath = "";
		if(request.getParameter("strPath")!= null)
		{
			strPath = request.getParameter("strPath");
			acFwd.setPath(strPath);
	        acFwd.setContextRelative(true);
	        
		}
		return acFwd;
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
		System.out.println(" ------- IssueToPatientTransBSCNT.ISSUEDTLSBILLED  ------- ");
			
		IssueTransFB fb = (IssueTransFB) form;
		IssueToPatientBSDATA.getBilledItemDtls(fb, request, response);
		return null;
	}
	
	/**
	 * 
	 * Method is used to delete issue item details after billing 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	
	public ActionForward DELETEISSUEDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- IssueToPatientTransBSCNT.DELETEISSUEDETAILS  ------- ");
		IssueTransFB fb = (IssueTransFB) form;
		IssueToPatientBSDATA.deleteIssueDtls(fb, request, response);
		return null;
	}
	
	public ActionForward TARIFFCHK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- IssueToPatientTransBSCNT.TARIFFCHK  ------- ");
		
		IssueTransFB fb = (IssueTransFB) form;
		IssueToPatientBSDATA.getTariffDtl(fb, request, response);
		return null;
	}
	
	public ActionForward ALREADYISSUEDRUG(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- IssueToPatientTransBSCNT.ALREADYISSUEDRUG  ------- ");
		
		IssueTransFB fb = (IssueTransFB) form;
		IssueToPatientBSDATA.getAlreadyIssueDrug(fb, request, response);
		return null;
	}
	
	public ActionForward GETREQTYPE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- IssueToPatientTransBSCNT.GETREQTYPE  ------- ");
		
		IssueTransFB fb = (IssueTransFB) form;
		IssueToPatientBSDATA.getReqType(fb, request, response);
		return null;
	}
	
	
	

	public ActionForward EPISODEDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- IssueToPatientTransBSCNT.EPISODEDTLS  ------- ");
		
		IssueTransFB fb = (IssueTransFB) form;
		IssueToPatientBSDATA.getEpisodeDtl(fb, request, response);
		return null;
	}

	public ActionForward PRESFORMDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- IssueToPatientTransBSCNT.PRESFORMDTLS  ------- ");
		IssueTransFB fb = (IssueTransFB) form;
		IssueToPatientBSDATA.getPresFormDtl(fb, request, response);
		return null;
	}
	
	public ActionForward GETPRESCDATA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		System.out.println(" ------- IssueToPatientTransBSCNT.GETPRESCDATA  ------- ");
		
		IssueTransFB formBean = (IssueTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		IssueToPatientBSDATA.getOnlineTreatmentDtl(formBean, request, response);
		return null;
	}
	
	
	

}
