package mms.masters.controller.action;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.GatePassTypeMstDATA;
import mms.masters.controller.fb.GatePassTypeMstFB;
import mms.masters.controller.utl.GatePassTypeMstUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

// TODO: Auto-generated Javadoc
/**
 * The Class GatePassTypeMstCNT.
 */
public class GatePassTypeMstCNT extends GenericController {

	/** The strtarget. */
	String strtarget = "";

	/**
	 * calls super class constructor.
	 */
	public GatePassTypeMstCNT() // Constructor for GatePassTypeMstCNT
	{
		super(new GatePassTypeMstUTL(), "/masters/GatePassTypeMstCNT");
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
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward ADD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		GatePassTypeMstFB formBean = (GatePassTypeMstFB) form;
		GatePassTypeMstDATA.initialAdd(formBean, request);
		strtarget = "add";
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
		GatePassTypeMstFB formBean = (GatePassTypeMstFB) form;
		GatePassTypeMstDATA.insertRecord(formBean, request);

		strtarget = "add";
		return mapping.findForward(strtarget);
	}

	/**
	 * Forwards control to the Modify Page.
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
		GatePassTypeMstFB formBean = (GatePassTypeMstFB) form;
		GatePassTypeMstDATA.modifyRecord(formBean, request);

		strtarget = "modify";
		return mapping.findForward(strtarget);
	}

	/**
	 * After Modification, Data is update and save into the database and return
	 * back to the list page.
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
		{
			boolean retValue = false;
			GatePassTypeMstFB formBean = (GatePassTypeMstFB) form;
			retValue = GatePassTypeMstDATA.updateRecord(formBean, request);
			if (retValue)
				return this.LIST(mapping, form, request, response);
			else
				return this.MODIFY(mapping, form, request, response);
		}
	}

}
