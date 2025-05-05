package mms.masters.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.CommitteeTypeMstDATA;
import mms.masters.controller.fb.CommitteeTypeMstFB;
import mms.masters.controller.utl.CommitteeTypeMstUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

// TODO: Auto-generated Javadoc
/**
 * The Class CommitteeTypeMstCNT.
 * 
 * @author Tanvi Sappal
 */

public class CommitteeTypeMstCNT extends GenericController {

	/** The strtarget. */
	String strtarget = "";

	/**
	 * calls super class constructor.
	 */
	public CommitteeTypeMstCNT() // Constructor for CommitteeTypeMstCNT
	{
		super(new CommitteeTypeMstUTL(), "/masters/CommitteeTypeMstCNT");
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
				generateToken(request);
		CommitteeTypeMstFB formBean = (CommitteeTypeMstFB) form;

		CommitteeTypeMstDATA.initialAdd(formBean, request);
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
				validateToken(request, response);
		CommitteeTypeMstFB formBean = (CommitteeTypeMstFB) form;
		CommitteeTypeMstDATA.insertRecord(formBean, request);

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
		CommitteeTypeMstFB formBean = (CommitteeTypeMstFB) form;
		CommitteeTypeMstDATA.modifyRecord(formBean, request);
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
	 * @throws Exception 
	 */
	public ActionForward UPDATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
         validateToken(request, response);
		boolean retValue = false;
		CommitteeTypeMstFB formBean = (CommitteeTypeMstFB) form;
		retValue = CommitteeTypeMstDATA.updateRecord(formBean, request);
		if (retValue)
			return this.LIST(mapping, form, request, response);
		else
			return this.MODIFY(mapping, form, request, response);
	}

}
