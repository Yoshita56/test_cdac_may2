package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.DrugSafetyAlertMstDATA;
import mms.masters.controller.fb.DrugSafetyAlertMstFB;
import mms.masters.controller.utl.DrugSafetyAlertMstUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugSafetyAlertMstCNT.
 */
public class DrugSafetyAlertMstCNT extends GenericController {
	
	/** The strtarget. */
	String strtarget;

	/**
	 * calls super class constructor.
	 */
	public DrugSafetyAlertMstCNT() {
		super(new DrugSafetyAlertMstUTL(), "/masters/DrugSafetyAlertMstCNT");
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
		DrugSafetyAlertMstFB fb = (DrugSafetyAlertMstFB) form;
		DrugSafetyAlertMstDATA.initialAdd(fb, request); // to display the Store
														// Type

		strtarget = "add";
		return mapping.findForward(strtarget);

	}

	/**
	 * UNITVA l1.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws Exception the exception
	 */
	public ActionForward UNITVAL1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DrugSafetyAlertMstFB fb = (DrugSafetyAlertMstFB) form;
		DrugSafetyAlertMstDATA.UNITVAL1(request, response, fb);
		return null;
	}

	/*
	 * This Method give the Response of Ajax Function @param mapping @param form
	 * @param request @param response @return ActionForward object with target
	 * @throws HisException @throws SQLException
	 */

	/**
	 * UNITVA l2.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws Exception the exception
	 */
	public ActionForward UNITVAL2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DrugSafetyAlertMstFB fb = (DrugSafetyAlertMstFB) form;
		DrugSafetyAlertMstDATA.UNITVAL2(request, response, fb);
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
		DrugSafetyAlertMstFB fb = (DrugSafetyAlertMstFB) form;

		DrugSafetyAlertMstDATA.insertRecord(fb, request);

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
		DrugSafetyAlertMstFB fb = (DrugSafetyAlertMstFB) form;
		DrugSafetyAlertMstDATA.modifyRecord(fb, request);
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
	 * 
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward UPDATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception

	{
		validateToken(request, response);
		boolean retValue = false;
		DrugSafetyAlertMstFB fb = (DrugSafetyAlertMstFB) form;
		retValue = DrugSafetyAlertMstDATA.updateRecord(fb, request);
		if (retValue)
			return this.LIST(mapping, form, request, response);
		else
			return this.MODIFY(mapping, form, request, response);
	}

	/**
	 * View page.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws Exception the exception
	 */
	public ActionForward viewPage(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String target = "viewPage";

		DrugSafetyAlertMstFB fb = (DrugSafetyAlertMstFB) form;
		fb.setStrGetView("1");
		DrugSafetyAlertMstDATA.modifyRecord(fb, request);
		return mapping.findForward(target);
	}

}
