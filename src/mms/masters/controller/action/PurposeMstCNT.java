package mms.masters.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;
import mms.masters.controller.data.PurposeMstDATA;
import mms.masters.controller.fb.PurposeMstFB;
import mms.masters.controller.utl.PruposeMstUTL;

// TODO: Auto-generated Javadoc
/**
 * The Class PurposeMstCNT.
 * 
 * @author Baisakhi Roy
 */
public class PurposeMstCNT extends GenericController {
	
	/** The strtarget. */
	String strtarget = "";

	/**
	 * calls super class constructor.
	 */
	public PurposeMstCNT() {
		super(new PruposeMstUTL(), "/masters/PurposeMstCNT");

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

		strtarget = "add";
		PurposeMstFB fb = (PurposeMstFB) form;
		PurposeMstDATA.initialAdd(fb);
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
		PurposeMstFB formBean = (PurposeMstFB) form;
		PurposeMstDATA.insertRecord(formBean, request);

		strtarget = "add";
		return mapping.findForward(strtarget);
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
		PurposeMstFB formBean = (PurposeMstFB) form;
		PurposeMstDATA.modifyRecord(formBean, request);

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
			throws HisException, SQLException {
		{
			boolean retValue = false;
			PurposeMstFB formBean = (PurposeMstFB) form;
			retValue = PurposeMstDATA.updateRecord(formBean, request);
			if (retValue)
				return this.LIST(mapping, form, request, response);
			else
				return this.MODIFY(mapping, form, request, response);
		}
	}

}
