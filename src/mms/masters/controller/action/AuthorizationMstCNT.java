package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.AuthorizationMstDATA;
import mms.masters.controller.fb.AuthorizationMstFB;
import mms.masters.controller.utl.AuthorizationMstUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorizationMstCNT.
 * 
 * @author manas
 */

public class AuthorizationMstCNT extends GenericController {

	/** The strtarget. */
	String strtarget = "";

	/**
	 * calls super class constructor.
	 */

	public AuthorizationMstCNT() {
		super(new AuthorizationMstUTL(), "masters/AuthorizationMstCNT");
	}

	/**
	 * Forwards Control to the ADD Page.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException 	 * @throws SQLException the SQL exception
	 * @throws Exception the exception
	 */
	public ActionForward ADD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		strtarget = "add";
		AuthorizationMstFB formBean = (AuthorizationMstFB) form;

		AuthorizationMstDATA.initialAdd(formBean, request);
		return mapping.findForward(strtarget);
	}

	/**
	 * To Save Data in Database & return Control Back to List Page.
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
		AuthorizationMstFB formBean = (AuthorizationMstFB) form;
		AuthorizationMstDATA.insertRecord(formBean, request);
		return this.ADD(mapping, formBean, request, response);
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

		AuthorizationMstFB formBean = (AuthorizationMstFB) form;

		AuthorizationMstDATA.modifyRecord(formBean, request);
		strtarget = "modify";
		return mapping.findForward(strtarget);
	}

	/**
	 * To Update data.
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
	public ActionForward UPDATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		boolean retValue = false;
		AuthorizationMstFB formBean = (AuthorizationMstFB) form;

		retValue = AuthorizationMstDATA.updateRecord(formBean, request);
		if (retValue)
			return this.LIST(mapping, form, request, response);
		else
			return this.MODIFY(mapping, form, request, response);
	}

}
