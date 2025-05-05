package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.PurchaseTypeMstDATA;

import mms.masters.controller.fb.PurchaseTypeMstFB;
import mms.masters.controller.utl.PurchaseTypeMstUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

// TODO: Auto-generated Javadoc
/**
 * The Class PurchaseTypeMstCNT.
 * 
 * @author Anshul Jindal
 */

public class PurchaseTypeMstCNT extends GenericController {
	
	/** The strtarget. */
	String strtarget = "";

	/**
	 * calls super class constructor.
	 */
	public PurchaseTypeMstCNT() // Constructor for PurchaseTypeMstCNT
	{
		super(new PurchaseTypeMstUTL(), "/masters/PurchaseTypeMstCNT");
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

		PurchaseTypeMstFB formBean = (PurchaseTypeMstFB) form;

		PurchaseTypeMstDATA.initialAdd(formBean, request);// to get CURRENT
															// DATE
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

		PurchaseTypeMstFB fb = (PurchaseTypeMstFB) form;
		PurchaseTypeMstDATA.insertRecord(fb, request);

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

		PurchaseTypeMstFB formBean = (PurchaseTypeMstFB) form;

		PurchaseTypeMstDATA.modifyRecord(formBean, request);
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
		boolean retValue = false;

		PurchaseTypeMstFB fb = (PurchaseTypeMstFB) form;
		retValue = PurchaseTypeMstDATA.updateRecord(fb, request);

		if (retValue)
			return this.LIST(mapping, form, request, response);
		else
			return this.MODIFY(mapping, form, request, response);
	}

}
