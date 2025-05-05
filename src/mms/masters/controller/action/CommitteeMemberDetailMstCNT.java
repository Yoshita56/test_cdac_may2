/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 20/Jan/2009
 *  
 */
/**
 * Developer : Anshul Jindal (Changes-add 3 combos and 2 from ajax)
 * Version : 1.0
 * Date : 22/May/2009
 *  
 */
package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.CommitteeMemberDetailMstDATA;
import mms.masters.controller.fb.CommitteeMemberDetailMstFB;
import hisglobal.presentation.CSRFGardTokenAction;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

// TODO: Auto-generated Javadoc
/**
 * The Class CommitteeMemberDetailMstCNT.
 */
public class CommitteeMemberDetailMstCNT extends CSRFGardTokenAction {
	//	
	/** The strtarget. */
	String strtarget;

	/**
	 * calls super class constructor.
	 */
	public CommitteeMemberDetailMstCNT() {
		// super(new
		// CommitteeMemberDetailMstUTL(),"/masters/CommitteeMemberDetailMstCNT");
	}

	/**
	 * *************************************************************************
	 * UNSPECIFIED*********************.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws SQLException the SQL exception
	 * @throws HisException the his exception
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException

	{
		generateToken(request);
		return this.ADD(mapping, form, request, response);
	}

	/**
	 * forwards control to the ADD page.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward ADD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
           generateToken(request);
		CommitteeMemberDetailMstFB fb = (CommitteeMemberDetailMstFB) form;

		CommitteeMemberDetailMstDATA.initialAdd(fb, request);
		strtarget = "add";
		return mapping.findForward(strtarget);

	}

	/**
	 * This Method give the Response of Ajax Function.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return ActionForward object with target
	 * 
	 * @throws HisException 	 * @throws SQLException 	 * @throws Exception the exception
	 */

	public ActionForward UNITVAL1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CommitteeMemberDetailMstFB fb = (CommitteeMemberDetailMstFB) form;
		CommitteeMemberDetailMstDATA.UNITVAL1(request, response, fb);
		return null;
	}

	/**
	 * This Method give the Response of Ajax Function.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return ActionForward object with target
	 * 
	 * @throws HisException 	 * @throws SQLException 	 * @throws Exception the exception
	 */

	public ActionForward UNITVAL2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CommitteeMemberDetailMstFB fb = (CommitteeMemberDetailMstFB) form;
		CommitteeMemberDetailMstDATA.UNITVAL2(request, response, fb);
		return null;
	}

	/**
	 * This Method give the Response of Ajax Function.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return ActionForward object with target
	 * 
	 * @throws HisException 	 * @throws SQLException 	 * @throws Exception the exception
	 */

	public ActionForward UNITVAL3(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CommitteeMemberDetailMstFB fb = (CommitteeMemberDetailMstFB) form;
		CommitteeMemberDetailMstDATA.UNITVAL3(request, response, fb);
		return null;
	}

	/**
	 * This Method give the Response of Ajax Function.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return ActionForward object with target
	 * 
	 * @throws HisException 	 * @throws SQLException 	 * @throws Exception the exception
	 */

	public ActionForward UNITVAL4(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CommitteeMemberDetailMstFB fb = (CommitteeMemberDetailMstFB) form;
		CommitteeMemberDetailMstDATA.UNITVAL4(request, response, fb);
		return null;
	}

	/**
	 * This Method give the Response of Ajax Function.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return ActionForward object with target
	 * 
	 * @throws HisException 	 * @throws SQLException 	 * @throws Exception the exception
	 */

	public ActionForward UNITVAL5(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CommitteeMemberDetailMstFB fb = (CommitteeMemberDetailMstFB) form;

		CommitteeMemberDetailMstDATA.UNITVAL5(request, response, fb);
		return null;
	}

	/**
	 * To add data.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws Exception the exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward SAVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
         validateToken(request, response);
		CommitteeMemberDetailMstFB fb = (CommitteeMemberDetailMstFB) form;

		CommitteeMemberDetailMstDATA.insertRecord(fb, request);

		return this.ADD(mapping, form, request, response);

	}

	/**
	 * To add data.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws Exception the exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward SAVE2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
           validateToken(request, response);
		CommitteeMemberDetailMstFB fb = (CommitteeMemberDetailMstFB) form;
		CommitteeMemberDetailMstDATA.insertRecord2(fb, request);

		return this.ADD(mapping, form, request, response);

	}

	/**
	 * forwards control to the modify page.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward MODIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
        generateToken(request);
		CommitteeMemberDetailMstFB fb = (CommitteeMemberDetailMstFB) form;
		CommitteeMemberDetailMstDATA.modifyRecord(fb, request);
		strtarget = "modify";
		return mapping.findForward(strtarget);
	}

	/**
	 * To modify data.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * @throws Exception 
	 */
	public ActionForward UPDATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
           validateToken(request, response);
		boolean retValue = false;

		CommitteeMemberDetailMstFB fb = (CommitteeMemberDetailMstFB) form;
		retValue = CommitteeMemberDetailMstDATA.updateRecord(fb, request);

		if (retValue)
			return this.ADD(mapping, form, request, response);
		else
			return this.MODIFY(mapping, form, request, response);
	}

	/**
	 * REQUESTTYPECOMBO called from ajax function for creating req type combo
	 * (by Anshul).
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws Exception the exception
	 */
	public ActionForward REQUESTTYPECOMBO(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, Exception {

		CommitteeMemberDetailMstFB fb = (CommitteeMemberDetailMstFB) form;
		CommitteeMemberDetailMstDATA.getReqTypeCombo(request, response, fb);

		return null;
	}
	
	/**
	 * EMPUSERIDCOMBO called from ajax function for creating Emp User ID combo
	 * On Basis of Emp id
	 * (by Amit Kr).
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws Exception the exception
	 */
	public ActionForward EMPUSERIDCOMBO(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, Exception {

		CommitteeMemberDetailMstFB fb = (CommitteeMemberDetailMstFB) form;
		CommitteeMemberDetailMstDATA.getEmpUserIdCombo(request, response, fb);

		return null;
	}


	/**
	 * REQUESTTYPECOMBO called from ajax function for creating committee type
	 * combo (by Anshul).
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws Exception the exception
	 */
	public ActionForward COMMTYPECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception {

		CommitteeMemberDetailMstFB fb = (CommitteeMemberDetailMstFB) form;
		CommitteeMemberDetailMstDATA.getCommTypeCombo(request, response, fb);

		return null;
	}
	
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
	    ActionForward acFwd = new ActionForward();
	   	acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}

}
