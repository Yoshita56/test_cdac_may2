package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.fb.StoreHierarchyMstFB;
import mms.masters.controller.fb.StoreItemMstFB;
import mms.masters.controller.utl.StoreHierarchyMstUTL;
import mms.masters.controller.data.StoreHierarchyMstDATA;
import mms.masters.controller.data.StoreItemMstDATA;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreHierarchyMstCNT.
 * 
 * @author Anshul Jindal
 */
public class StoreHierarchyMstCNT extends GenericController {
	
	/** The strtarget. */
	String strtarget;

	/**
	 * calls super class constructor.
	 */
	public StoreHierarchyMstCNT() {
		super(new StoreHierarchyMstUTL(), "masters/StoreHierarchyMstCNT");

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
		StoreHierarchyMstFB formBean = (StoreHierarchyMstFB) form;

		StoreHierarchyMstDATA.initialAdd(formBean, request);// to get CURRENT
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
		validateToken(request, response);
		StoreHierarchyMstFB fb = (StoreHierarchyMstFB) form;
		StoreHierarchyMstDATA.insertRecord(fb, request);

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
		StoreHierarchyMstFB fb = (StoreHierarchyMstFB) form;

		StoreHierarchyMstDATA.modifyRecord(fb, request);
		strtarget = "modify";
		return mapping.findForward(strtarget);
	}

	/**
	 * To update data.
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

		StoreHierarchyMstFB fb = (StoreHierarchyMstFB) form;
		retValue = StoreHierarchyMstDATA.updateRecord(fb, request);
		if (retValue)
			return this.LIST(mapping, form, request, response);
		else
			return this.MODIFY(mapping, form, request, response);

	}
	
	/**
	 * ASSOCIATEDSTORE called from ajax function for creating unit combo according to
	 * inventory unit Id of selected generic item.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws Exception the exception
	 */
	public ActionForward ASSOCIATEDSTORE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception 
	{

		StoreHierarchyMstFB fb = (StoreHierarchyMstFB) form;
		StoreHierarchyMstDATA.getAssociatedStore(fb, request, response);

		return null;
	}

}
