package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.StoreGroupMstDATA;
import mms.masters.controller.fb.StoreGroupMstFB;
import mms.masters.controller.utl.StoreGroupMstBSUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreGroupMstBSCNT.
 * 
 * @author Anshul Jindal
 */

public class StoreGroupMstBSCNT extends GenericController {

	/** The strtarget. */
	String strtarget;

	/**
	 * calls super class constructor.
	 */
	public StoreGroupMstBSCNT() {
		super(new StoreGroupMstBSUTL(), "/masters/StoreGroupMstBSCNT");

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
		StoreGroupMstFB fb = (StoreGroupMstFB) form;

		StoreGroupMstDATA.initialAdd(fb, request);
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
		StoreGroupMstFB fb = (StoreGroupMstFB) form;
		StoreGroupMstDATA.insertRecord(fb, request);

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
		StoreGroupMstFB fb = (StoreGroupMstFB) form;

		StoreGroupMstDATA.modifyRecord(fb, request);
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

		StoreGroupMstFB fb = (StoreGroupMstFB) form;
		retValue = StoreGroupMstDATA.updateRecord(fb, request);

		if (retValue)
			return this.LIST(mapping, form, request, response);
		else
			return this.MODIFY(mapping, form, request, response);
	}

}
