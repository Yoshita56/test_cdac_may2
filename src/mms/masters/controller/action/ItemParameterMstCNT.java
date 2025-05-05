package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.ItemParameterMstDATA;
import mms.masters.controller.fb.ItemParameterMstFB;
import mms.masters.controller.utl.ItemParameterMstUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

// TODO: Auto-generated Javadoc
/**
 * Developer : Manas
 * Version : 1.0
 * Date : 7/Jan/2009
 */

/**
 * Developer : Anshul Jindal Version : 1.0 (Changes as changes in table i.e.
 * storetype id replaced by item category id) Date : 31/Jan/2009
 * 
 */
public class ItemParameterMstCNT extends GenericController {

	/** The strtarget. */
	String strtarget = "";

	/**
	 * calls super class constructor.
	 */

	public ItemParameterMstCNT() {
		super(new ItemParameterMstUTL(), "masters/ItemParameterMstCNT");
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
	 * @throws Exception the exception
	 * @throws SQLException the SQL exception
	 */

	public ActionForward ADD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		strtarget = "add";

		ItemParameterMstFB formBean = (ItemParameterMstFB) form;

		ItemParameterMstDATA.initialAdd(formBean, request);
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

		ItemParameterMstFB formBean = (ItemParameterMstFB) form;
		ItemParameterMstDATA.InsertRecord(formBean, request);
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
	 * @throws HisException 	 * @throws SQLException the SQL exception
	 * @throws Exception the exception
	 */

	public ActionForward MODIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		ItemParameterMstFB formBean = (ItemParameterMstFB) form;

		ItemParameterMstDATA.modifyRecord(formBean, request);

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
	 * @throws HisException 	 * @throws SQLException the SQL exception
	 * @throws Exception the exception
	 */

	public ActionForward UPDATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		{
			strtarget = "modify";
			ItemParameterMstFB formBean = (ItemParameterMstFB) form;

			boolean fRes = ItemParameterMstDATA.updateRecord(formBean, request);

			if (fRes)
				return this.LIST(mapping, form, request, response);
			else
				return mapping.findForward(strtarget);
		}
	}

}
