package mms.masters.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import mms.masters.controller.data.SupplierGradeMstDATA;
import mms.masters.controller.fb.SupplierGradeMstFB;
import mms.masters.controller.utl.SupplierGradeMstUTL;
import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierGradeMstCNT.
 * 
 * @author Tanvi Sappal
 */

public class SupplierGradeMstCNT extends GenericController {
	
	/** The strtarget. */
	String strtarget = "";

	/**
	 * calls super class constructor.
	 */
	public SupplierGradeMstCNT() // Constructor for SupplierGradeMstCNT
	{
		super(new SupplierGradeMstUTL(), "/masters/SupplierGradeMstCNT");
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

		SupplierGradeMstFB formBean = (SupplierGradeMstFB) form;
		SupplierGradeMstDATA.initialAdd(formBean, request);
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
		SupplierGradeMstFB formBean = (SupplierGradeMstFB) form;
		SupplierGradeMstDATA.insertRecord(formBean, request);

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
		SupplierGradeMstFB formBean = (SupplierGradeMstFB) form;
		SupplierGradeMstDATA.modifyRecord(formBean, request);

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
			SupplierGradeMstFB formBean = (SupplierGradeMstFB) form;
			retValue = SupplierGradeMstDATA.updateRecord(formBean, request);
			if (retValue)
				return this.LIST(mapping, form, request, response);
			else
				return this.MODIFY(mapping, form, request, response);
		}
	}

}
