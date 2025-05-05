package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.DrugDosageIndicationMstDATA;
import mms.masters.controller.fb.DrugDosageIndicationMstFB;
import mms.masters.controller.utl.DrugDosageIndicationMstUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugDosageIndicationMstCNT.
 */
public class DrugDosageIndicationMstCNT extends GenericController {

	/** The strtarget. */
	String strtarget;

	/**
	 * calls super class constructor.
	 */
	public DrugDosageIndicationMstCNT() {
		super(new DrugDosageIndicationMstUTL(),
				"/masters/DrugDosageIndicationMstCNT");
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
		DrugDosageIndicationMstFB fb = (DrugDosageIndicationMstFB) form;

		DrugDosageIndicationMstDATA.initialAdd(fb, request); // to display
																// the Store
																// Type
		// Name on next page
		// according to the selected

		strtarget = "add";
		return mapping.findForward(strtarget);

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
		DrugDosageIndicationMstFB fb = (DrugDosageIndicationMstFB) form;
		DrugDosageIndicationMstDATA.insertRecord(fb, request);
		return this.ADD(mapping, form, request, response);

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

		DrugDosageIndicationMstFB fb = (DrugDosageIndicationMstFB) form;
		DrugDosageIndicationMstDATA.UNITVAL1(request, response, fb);
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

		DrugDosageIndicationMstFB fb = (DrugDosageIndicationMstFB) form;
		DrugDosageIndicationMstDATA.UNITVAL2(request, response, fb);
		return null;
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
		DrugDosageIndicationMstFB fb = (DrugDosageIndicationMstFB) form;
		DrugDosageIndicationMstDATA.modifyRecord(fb, request);
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
			throws Exception

	{
		validateToken(request, response);
		boolean retValue = false;
		DrugDosageIndicationMstFB fb = (DrugDosageIndicationMstFB) form;
		retValue = DrugDosageIndicationMstDATA.updateRecord(fb, request);
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

		DrugDosageIndicationMstFB fb = (DrugDosageIndicationMstFB) form;
		fb.setStrGetView("1");

		DrugDosageIndicationMstDATA.modifyRecord(fb, request);
		return mapping.findForward(target);
	}

}
