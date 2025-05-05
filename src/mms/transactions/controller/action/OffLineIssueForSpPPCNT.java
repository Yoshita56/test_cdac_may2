package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.OffLineIssueForSpPPDATA;
import mms.transactions.controller.fb.OffLineIssueForSpPPFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

	public class OffLineIssueForSpPPCNT extends CSRFGardTokenAction
	{
	String strtarget;

	/**
	 * Constructor of Class.
	 */
	public OffLineIssueForSpPPCNT()
	{
		
	}
	 /***********************UNSPECIFIED**************************/
	/**
	 * Unspecified Method Use to Transfer the Control Over Action FIRSTDATA.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	public ActionForward unspecified(ActionMapping mapping,ActionForm form
			                        ,HttpServletRequest request
			                        ,HttpServletResponse response)throws HisException, SQLException
    {
		generateToken(request);
		return this.FIRSTDATA(mapping, form, request, response);
	}
	/**
	 * forwards control to the ADD page of Trasaction.& get
	 * all data which required to show over add page
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward FIRSTDATA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		 generateToken(request);
		OffLineIssueForSpPPFB fb = (OffLineIssueForSpPPFB) form;
		OffLineIssueForSpPPDATA.GetData(fb, request); 
		strtarget = "specialPPIssue";
		return mapping.findForward(strtarget);

	}
	/**
	 * This method used to get Item Category Combo
	 * for Indent Issue Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward PendingDemandDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		OffLineIssueForSpPPFB formBean = (OffLineIssueForSpPPFB) form;
		OffLineIssueForSpPPDATA.PendingDemandDetails(request,response,formBean);
		return null;

	}
	
	/**
	 * This method used to get Item Category Combo
	 * for Indent Issue Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward ItemCatgoryCombo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		OffLineIssueForSpPPFB formBean = (OffLineIssueForSpPPFB) form;
		OffLineIssueForSpPPDATA.ItemCatgoryCombo(request,response,formBean);
		return null;

	}
	
	
	/**
	 * This method used to get Approved By Combo
	 * for Indent Issue Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward ApprovedByCombo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		OffLineIssueForSpPPFB formBean = (OffLineIssueForSpPPFB) form;
		OffLineIssueForSpPPDATA.ApprovedByCombo(request,response,formBean);
		return null;

	}
	
	/**
	 * This method used to get Approved By Combo
	 * for Indent Issue Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward GetPendingIndentDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		OffLineIssueForSpPPFB formBean = (OffLineIssueForSpPPFB) form;
		OffLineIssueForSpPPDATA.getPendingIndentDetails(request,response,formBean);
		return null;

	}
	
	
	
	/**
	 * This method used to get Indent Store Combo
	 * for Indent Issue Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward IndentStoreCombo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		OffLineIssueForSpPPFB formBean = (OffLineIssueForSpPPFB) form;
		OffLineIssueForSpPPDATA.IndentingStoreCombo(request,response,formBean);
		return null;

	}
	
	/**
	 * This method used to get Approved and Verified By Combo
	 * for Indent Issue Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward ApprovedVerifyCombo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		OffLineIssueForSpPPFB formBean = (OffLineIssueForSpPPFB) form;
		OffLineIssueForSpPPDATA.ApprovedVerifyCombo(request,response,formBean);
		return null;

	}
	
	
	/**
	 * This method used to get Approved and Verified By Combo
	 * for Indent Issue Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward GetStoreBudget(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		OffLineIssueForSpPPFB formBean = (OffLineIssueForSpPPFB) form;
		OffLineIssueForSpPPDATA.GetStoreBudget(request,response,formBean);
		return null;

	}
	
	
	/**
	 * CANCEL method  
	 * forwards control to the LIST  page of Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
	    ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
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
		String strTarget="specialPPView";
		
		OffLineIssueForSpPPFB fb = (OffLineIssueForSpPPFB) form;
		OffLineIssueForSpPPDATA.initViewPageDtl(fb,request);
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
			
		OffLineIssueForSpPPFB fb = (OffLineIssueForSpPPFB) form;
		OffLineIssueForSpPPDATA.getViewDtlNEW(fb, request, response);
		return null;
	}
	/** 
	 * This method Issue Item Details. (i.e hyperlink)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward GETPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		//System.out.println("cnt GETPOPUP");
		OffLineIssueForSpPPFB formBean = (OffLineIssueForSpPPFB) form;
		OffLineIssueForSpPPDATA.getPopUp(request, response,formBean);
		return null;
	}
	/** This method use to SAVENEWDEMAND data
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward SAVENEWDEMAND(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		validateToken(request, response);
		OffLineIssueForSpPPFB formBean = (OffLineIssueForSpPPFB) form;
		System.out.println("------------- OffLineIssueForSpPPCNT . SAVENEWDEMAND -----------------");
		OffLineIssueForSpPPDATA.InsertOffLineforNewDemand( formBean,request);
		return this.FIRSTDATA(mapping, form, request, response);
	}
		
	/** This method use to SAVEEXISTINGDEMAND data
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward  SAVEEXISTINGDEMAND(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		validateToken(request, response);
		OffLineIssueForSpPPFB formBean = (OffLineIssueForSpPPFB) form;
		OffLineIssueForSpPPDATA.InsertOffLineforExistingDemand( formBean,request);
		return this.FIRSTDATA(mapping, form, request, response);
	}
	
	
	public ActionForward ISSUEDTLSINITNEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		OffLineIssueForSpPPFB formBean = (OffLineIssueForSpPPFB) form;
		
		System.out.println("----------- OffLineIssueForSpPPCNT . ISSUEDTLSINITNEW ----( Voucher )------");

		OffLineIssueForSpPPDATA.issueDtlsInitNEW(request, response, formBean);

		return null;
	}
	
	
}
