package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;
import mms.transactions.controller.data.IssueDeskTransDATA;
import mms.transactions.controller.fb.IssueDeskTransFB;
import mms.transactions.controller.utl.IssueDeskTransUTL;

/**
 * Developer : Anshul Jindal (To Continue)
 * Version : 1.0 Date : 02/Apr/2009
 * 
 */

/** (Changes)
 * Developer : Anshul Jindal Version : 1.1 Date : 11/June/2009
 * 
 */
/**
 * Developer : Balasubramaniam M Version : 1.0 Date : 01/Apr/2009
 * 
 */


public class IssueDeskTransCNT extends GenericController {

	public IssueDeskTransCNT() {
		super(new IssueDeskTransUTL(), "/transactions/IssueDeskTransCNT");
	}

	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return Thumbs.db
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward ISSUE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
         generateToken(request);
         
        System.out.println("IssueDeskTransCNT.ISSUE -- 31 ----[ ISSUE ]-----[ issue_issuedesk_mmstrans.jsp ,issuedesk_trans.js ]------");
         
		IssueDeskTransFB formBean = (IssueDeskTransFB) form;

		IssueDeskTransDATA.getIndentDetails(formBean, request);
		
		String strtarget = "issue";
		return mapping.findForward(strtarget);

	}
	
	/**
	 * APPROVALPRINT - gets the issue details view used for ajax.
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
	public ActionForward BEFOREISSUEPRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		IssueDeskTransFB formBean = (IssueDeskTransFB) form;
        System.out.println("-----------IssueDeskTransCNT . BEFOREISSUEPRINT [ Voucher ]--------------");
        IssueDeskTransDATA.indentAppPrint(request, response, formBean);

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
	public ActionForward ISSUEDTLSINIT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		IssueDeskTransFB formBean = (IssueDeskTransFB) form;
        System.out.println("-----------IssueDeskTransCNT . ISSUEDTLSINIT [ After Save Issue Voucher ]--------------");
        IssueDeskTransDATA.issueDtlsInit(request, response, formBean);

		return null;
	}
	
	/** 
	 * This method calls on click of A Bill No. (i.e hyperlink)
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
		////System.out.println("cnt GETPOPUP");
		IssueDeskTransFB formBean = (IssueDeskTransFB) form;
		IssueDeskTransDATA.getPopUp(request, response,formBean);
		return null;
	}

	/** This method calls if we again click  on a Bill No. (i.e hyperlink)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward GETPOPUPDATA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		IssueDeskTransFB formBean = (IssueDeskTransFB) form;
		IssueDeskTransDATA.getPopUpData(request, response,formBean);
		return null;
	}
	
	/** This method calls if we again click  on a Bill No. (i.e hyperlink)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward SAVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
          validateToken(request, response);
		IssueDeskTransFB formBean = (IssueDeskTransFB) form;
		IssueDeskTransDATA.insertData( formBean,request);
		return this.ISSUE(mapping, form, request, response);
	}
	
	public ActionForward BACK_TO_LISTPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
	{			
		System.out.println("-----------IssueDeskTransCNT . BACK_TO_LISTPAGE--------------");
		  
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/LPIssueDeskTransCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}

	

	/**
	 * This method is used to cancel the Process.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	/*	ActionForward acFwd = new ActionForward();
		acFwd.setPath("/startup/initPage.jsp");
		acFwd.setContextRelative(true);*/
	//	return acFwd;
	//	return this.LIST(mapping, form, request, response);
		
		System.out.println("-----------IssueDeskTransCNT . CANCELPAGE--------------");
		
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/LPIssueDeskTransCNT.cnt?hmode=RETURNTOMAINDESK");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	/**
	 * This method is used to FORWARD CONTROL ON  VIEW PAGE FOR TO BE ISSUE.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward VIEW1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
	{
	/*	ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/IssueViewDetailsCNT.cnt?hmode=init");
		acFwd.setContextRelative(true);
		return acFwd;*/
	
	IssueDeskTransFB formBean = (IssueDeskTransFB) form;

	IssueDeskTransDATA.getViewDetails1(formBean, request);
	
	String strtarget = "view1";
	return mapping.findForward(strtarget);
	}
	
	/**
	 * This method is used to FORWARD CONTROL ON  VIEW PAGE FOR ISSUED.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward VIEW2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		
	System.out.println("-----------IssueDeskTransCNT . VIEW2 [ view2_issuedesk_mmstrans.jsp , issuedesk_trans.js ]--------------");
	
	IssueDeskTransFB formBean = (IssueDeskTransFB) form;

	IssueDeskTransDATA.getViewDetails2(formBean, request);

	String strtarget = "view2";
	return mapping.findForward(strtarget);
	}
	
	/**
	 * STOCKDTLSINIT - gets the Item & Drug Stock Details view used for ajax.
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
	public ActionForward STOCKDTLSINIT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		IssueDeskTransFB formBean = (IssueDeskTransFB) form;
		
		 System.out.println("-----IssueDeskTransCNT.STOCKDTLSINIT ------");

		IssueDeskTransDATA.stockItemDtlsInit(request, response, formBean);

		return null;
	}
	
	
	
	public ActionForward CANCELTODESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	/*	ActionForward acFwd = new ActionForward();
		acFwd.setPath("/startup/initPage.jsp");
		acFwd.setContextRelative(true);*/
	//	return acFwd;
	//	return this.LIST(mapping, form, request, response);
		
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/LPIssueDeskTransCNT.cnt?hmode=RETURNTOMAINDESK");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	/**
	 * Cancel
	 * is used to forward control to Indent Desk
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward CANCELPAGE_NA(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		ActionForward acFwd = new ActionForward();		
		acFwd.setPath("/mms/transactions/IssueDeskTransCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	

}
