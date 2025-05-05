package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.StoreItemMstDATA;
import mms.masters.controller.fb.StoreItemMstFB;
import mms.masters.controller.utl.StoreItemMstUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreItemMstCNT.
 * 
 * @author Anshul Jindal
 */

/**
 * Developer : Anshul Jindal Version : 1.2 Modify Date : 8/July/2009
 * 
 */
/**
 * Developer : Tanvi Sappal
 * Version : 1.1
 * Modify Date : 13/May/2009
 * 
 */

/**
 * Developer : Anshul Jindal Version : 1.0 Modify Date : 21/May/2009
 * 
 */
public class StoreItemMstCNTNEW extends GenericController {

	/** The strtarget. */
	String strtarget;

	/**
	 * calls super class constructor.
	 */
	public StoreItemMstCNTNEW() {
		super(new StoreItemMstUTL(), "masters/StoreItemMstCNTNEW");

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
		StoreItemMstFB formBean = (StoreItemMstFB) form;

		StoreItemMstDATA.initialAdd(formBean, request);// to get CURRENT DATE
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
		StoreItemMstFB fb = (StoreItemMstFB) form;
		StoreItemMstDATA.insertRecord(fb, request);

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
		StoreItemMstFB fb = (StoreItemMstFB) form;
		StoreItemMstDATA.modifyRecord(fb, request);
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

		StoreItemMstFB fb = (StoreItemMstFB) form;
		retValue = StoreItemMstDATA.updateRecord(fb, request);

		if (retValue)
			return this.LIST(mapping, form, request, response);
		else
			return this.MODIFY(mapping, fb, request, response);

	}

	/**
	 * getBrandName called from ajax function for creating combo for Brand NAME.
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
	public ActionForward BRANDNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception {

		StoreItemMstFB fb = (StoreItemMstFB) form;
		StoreItemMstDATA.getBrandName(fb, request, response);

		return null;
	}

	/**
	 * SUBGROUPNAME called from ajax function for creating combo for Sub Group
	 * Name.
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
	public ActionForward SUBGROUPNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception {

		StoreItemMstFB fb = (StoreItemMstFB) form;
		StoreItemMstDATA.getSubGroupCombo(fb, request, response);

		return null;
	}

	/**
	 * ITEMNAME called from ajax function for creating combo for Item Name
	 * according to Group Id & Sub Group Id.
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
	public ActionForward ITEMNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception {

		StoreItemMstFB fb = (StoreItemMstFB) form;
		StoreItemMstDATA.getItemNameCombo(fb, request, response);

		return null;
	}
	/**
	 * UNITCOMBO called from ajax function for creating unit combo according to
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
	public ActionForward UNITCOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception {

		StoreItemMstFB fb = (StoreItemMstFB) form;
		StoreItemMstDATA.getUnitCombo(fb, request, response);

		return null;
	}

	/**
	 * forwards control to the BATCHUPDATE page.
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
	public ActionForward BATCHUPDATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StoreItemMstFB formBean = (StoreItemMstFB) form;

		StoreItemMstDATA.BatchUpdateStoreCombo(formBean, request);// to get
																	// CURRENT
																	// DATE
		strtarget = "batchUpdate";
		return mapping.findForward(strtarget);

	}

}
