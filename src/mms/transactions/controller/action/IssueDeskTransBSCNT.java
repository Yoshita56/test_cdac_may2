package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.IssueDeskTransBSDATA;
import mms.transactions.controller.fb.IssueDeskTransFB;
import mms.transactions.controller.utl.IssueDeskTransUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

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


public class IssueDeskTransBSCNT extends GenericController {

	public IssueDeskTransBSCNT() {
		super(new IssueDeskTransUTL(), "/transactions/IssueDeskTransBSCNT");
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
		IssueDeskTransFB formBean = (IssueDeskTransFB) form;

		IssueDeskTransBSDATA.getIndentDetails(formBean, request);
		
		String strtarget = "issue";
		return mapping.findForward(strtarget);

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
		IssueDeskTransBSDATA.getPopUp(request, response,formBean);
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
		IssueDeskTransBSDATA.getPopUpData(request, response,formBean);
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
		IssueDeskTransBSDATA.insertData( formBean,request);
		return this.ISSUE(mapping, form, request, response);
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
		
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/LPIssueDeskTransBSCNT.cnt?hmode=RETURNTOMAINDESK");
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

	IssueDeskTransBSDATA.getViewDetails1(formBean, request);
	
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
	
	IssueDeskTransFB formBean = (IssueDeskTransFB) form;

	IssueDeskTransBSDATA.getViewDetails2(formBean, request);
	
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

		IssueDeskTransBSDATA.stockItemDtlsInit(request, response, formBean);

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
		acFwd.setPath("/mms/transactions/LPIssueDeskTransBSCNT.cnt?hmode=RETURNTOMAINDESK");
		acFwd.setContextRelative(true);
		return acFwd;
	}

}
