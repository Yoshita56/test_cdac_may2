package mms.masters.controller.action;

import mms.masters.controller.data.ComponentMstDATA;
import mms.masters.controller.fb.ComponentMstFB;
import mms.masters.controller.utl.ComponentMstUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

// TODO: Auto-generated Javadoc
/**
 * The Class ComponentMstCNT.
 * 
 * @author manas
 */
public class ComponentMstCNT extends GenericController {

	/** The strtarget. */
	String strtarget = "";

	/**
	 * calls super class constructor.
	 */
	public ComponentMstCNT() {
		super(new ComponentMstUTL(), "/masters/ComponentMstCNT");
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
		strtarget = "add";
		ComponentMstFB fb = (ComponentMstFB) form;
		ComponentMstDATA.initialAdd(fb, request);
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
		ComponentMstFB fb = (ComponentMstFB) form;
		ComponentMstDATA.insertRecord(fb, request);

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
		ComponentMstFB fb = (ComponentMstFB) form;
		ComponentMstDATA.modifyRecord(fb, request);
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

		ComponentMstFB fb = (ComponentMstFB) form;
		retValue = ComponentMstDATA.updateRecord(fb, request);

		if (retValue)
			return this.LIST(mapping, form, request, response);
		else
			return this.MODIFY(mapping, form, request, response);
	}

}
