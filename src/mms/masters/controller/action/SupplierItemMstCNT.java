package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.SupplierItemMstDATA;
import mms.masters.controller.fb.SupplierItemMstFB;
import mms.masters.controller.utl.SupplierItemMstUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierItemMstCNT.
 * 
 * @developer Anshul Jindal
 */
public class SupplierItemMstCNT extends GenericController {

	/** The strtarget. */
	String strtarget;

	/**
	 * calls super class constructor.
	 */
	public SupplierItemMstCNT() {
		super(new SupplierItemMstUTL(), "masters/SupplierItemMstCNT");

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
		SupplierItemMstFB formBean = (SupplierItemMstFB) form;

		SupplierItemMstDATA.initialAdd(formBean, request);// to get CURRENT
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
		SupplierItemMstFB fb = (SupplierItemMstFB) form;
		SupplierItemMstDATA.insertRecord(fb, request);

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
		SupplierItemMstFB fb = (SupplierItemMstFB) form;
		SupplierItemMstDATA.modifyRecord(fb, request);
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

		SupplierItemMstFB fb = (SupplierItemMstFB) form;
		retValue = SupplierItemMstDATA.updateRecord(fb, request);

		if (retValue)
			return this.LIST(mapping, form, request, response);
		else
			return this.MODIFY(mapping, fb, request, response);

	}

	/**
	 * ITEMLIST called from ajax function for creating left item list.
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
	public ActionForward ITEMLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception {

		SupplierItemMstFB fb = (SupplierItemMstFB) form;
		SupplierItemMstDATA.getItemList(fb, request, response);

		return null;
	}
	/**
	 * getBrandName called from ajax function for creating combo for Brand NAME
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws Exception
	 */
	/*
	 * public ActionForward BRANDNAME(ActionMapping mapping, ActionForm form,
	 * HttpServletRequest request, HttpServletResponse response) throws
	 * HisException, Exception {
	 * 
	 * SupplierItemMstFB fb = (SupplierItemMstFB) form;
	 * SupplierItemMstDATA.getBrandName(fb, request, response);
	 * 
	 * return null; }
	 * 
	 *//**
		 * SUBGROUPNAME called from ajax function for creating combo for Sub
		 * Group Name
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 * @throws Exception
		 */
	/*
	 * public ActionForward SUBGROUPNAME(ActionMapping mapping, ActionForm form,
	 * HttpServletRequest request, HttpServletResponse response) throws
	 * HisException, Exception {
	 * 
	 * SupplierItemMstFB fb = (SupplierItemMstFB) form;
	 * SupplierItemMstDATA.getSubGroupCombo(fb, request, response);
	 * 
	 * return null; }
	 * 
	 *//**
		 * ITEMNAME called from ajax function for creating combo for Item Name
		 * according to Group Id & Sub Group Id
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 * @throws Exception
		 */
	/*
	 * public ActionForward ITEMNAME(ActionMapping mapping, ActionForm form,
	 * HttpServletRequest request, HttpServletResponse response) throws
	 * HisException, Exception {
	 * 
	 * SupplierItemMstFB fb = (SupplierItemMstFB) form;
	 * SupplierItemMstDATA.getItemNameCombo(fb, request, response);
	 * 
	 * return null; }
	 * 
	 *//**
		 * UNITNAME called from ajax function for creating combo for Unit Name
		 * according to inventory id
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 * @throws Exception
		 */
	/*
	 * public ActionForward UNITNAME(ActionMapping mapping, ActionForm form,
	 * HttpServletRequest request, HttpServletResponse response) throws
	 * HisException, SQLException { SupplierItemMstFB formBean =
	 * (SupplierItemMstFB) form; SupplierItemMstDATA.unitName(formBean, request,
	 * response); // For Unit Combo return null; }
	 */

}
