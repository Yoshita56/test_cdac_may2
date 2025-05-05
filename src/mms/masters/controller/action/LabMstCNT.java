package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.LabMstDATA;
import mms.masters.controller.fb.LabMstFB;
import mms.masters.controller.utl.LabMstUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author:-	Adil Wasi   
 * Creation Date:- 07-Jan-2012 
 * Modifying Date:- 
 * Used For:-	
 * Team Lead By:-	
 * Module:- DWH(HIS Project)
 * 
 */

// TODO: Auto-generated Javadoc
/**
 * The Class LabMstCNT.
 */
public class LabMstCNT extends GenericController {
	
	/** The strtarget. */
	String strtarget;

	/**
	 * calls super class constructor.
	 */
	public LabMstCNT() {
		super(new LabMstUTL(), "/masters/LabMstCNT");
	}

	/**
	 * forwards control to the ADD page.
	 * 
	 * @param mapping_p the mapping
	 * @param form_p the form
	 * @param request_p the request
	 * @param response_p the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward ADD(ActionMapping mapping_p, ActionForm form_p,
			HttpServletRequest request_p, HttpServletResponse response_p)
			throws HisException, SQLException {

		LabMstFB fb = (LabMstFB) form_p;
		LabMstDATA.initializeAdd(fb, request_p);
		strtarget = "add";
		return mapping_p.findForward(strtarget);

	}

	/**
	 * To add data.
	 * 
	 * @param mapping_p the mapping
	 * @param form_p the form
	 * @param request_p the request
	 * @param response_p the response
	 * 
	 * @return the action forward
	 * 
	 * @throws Exception the exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward SAVE(ActionMapping mapping_p, ActionForm form_p,
			HttpServletRequest request_p, HttpServletResponse response_p)
			throws Exception, SQLException {

		LabMstFB fb = (LabMstFB) form_p;
		LabMstDATA.insertRecord(fb, request_p);
		return this.ADD(mapping_p, form_p, request_p, response_p);

	}

	/**
	 * forwards control to the modify page.
	 * 
	 * @param mapping_p the mapping
	 * @param form_p the form
	 * @param request_p the request
	 * @param response_p the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward MODIFY(ActionMapping mapping_p, ActionForm form_p,
			HttpServletRequest request_p, HttpServletResponse response_p)
			throws HisException, SQLException {

		LabMstFB fb = (LabMstFB) form_p;
		LabMstDATA.modifyRecord(fb, request_p);
		strtarget = "modify";
		return mapping_p.findForward(strtarget);
	}

	/**
	 * To Update data.
	 * 
	 * @param mapping_p the mapping
	 * @param form_p the form
	 * @param request_p the request
	 * @param response_p the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward UPDATE(ActionMapping mapping_p, ActionForm form_p,
			HttpServletRequest request_p, HttpServletResponse response_p)
			throws HisException, SQLException

	{
		boolean retValue = false;
		LabMstFB fb = (LabMstFB) form_p;
		retValue = LabMstDATA.updateRecord(fb, request_p);
		if (retValue)
			return this.LIST(mapping_p, form_p, request_p, response_p);
		else
			return this.MODIFY(mapping_p, form_p, request_p, response_p);
	}

	
	
}