package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.ItemInventoryTransDATA;
import mms.transactions.controller.fb.ItemInventoryTransFB;
import mms.transactions.controller.utl.ItemInventoryTransUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Developer : Pankaj
 * Version : 1.0
 * Date : 28/Jan/2009
 *  
*/

/**( ADD PAGE NOT WORKING,WRONG VALUES ARE USED FOR INSRTION(SL NO. HARD CODED), MODIFY/UPDATE WAS NOT WORKING AND SUBGROUP SHOULD NOT BE MANDATORY ON ADD)
 * Developer : Anshul Jindal ( TO CONTINUE AND CORRECTIONS )
 * Version : 1.0 Date : 21/Apr/2009
 * 
 */

public class ItemInventoryTransBSCNT extends GenericController {


	String strtarget;
	
	public ItemInventoryTransBSCNT() {
		super(new ItemInventoryTransUTL(), "/transactions/ItemInventoryTransBSCNT");
	}

	/**
	 * forwards control to the ADD page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward ADD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ItemInventoryTransFB fb = (ItemInventoryTransFB) form;

		ItemInventoryTransDATA.initialAdd(fb, request); // to display the Store
		// Type and Group Type
		// Name on next page
		// according to the selected
		strtarget = "add";
		return mapping.findForward(strtarget);

	}

	/**
	 * Invoked by Ajax Functions and sets the required Item Name Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward ITEMNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ItemInventoryTransFB formBean = (ItemInventoryTransFB) form;
		ItemInventoryTransDATA.itemName(formBean, request, response);
		return null;
	}

	/**
	 * Invoked by Ajax Functions and sets the required Item Brand Name Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward ITEMBRANDNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ItemInventoryTransFB formBean = (ItemInventoryTransFB) form;
		ItemInventoryTransDATA.itemBrandName(formBean, request, response);
		return null;
	}

	/**
	 * Invoked by Ajax Functions and sets the required Item Brand Details.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward BRANDDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ItemInventoryTransFB formBean = (ItemInventoryTransFB) form;
		ItemInventoryTransDATA.getBrandDetails(formBean, request, response);
		return null;
	}
	
	
	
	/**
	 * Invoked by Ajax Functions and sets the required Unit Name Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward UNITNAMECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ItemInventoryTransFB formBean = (ItemInventoryTransFB) form;
		ItemInventoryTransDATA.unitNameCombo(formBean, request, response);
		return null;
	}

	/**
	 * used for manufacture name combo
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward MANUFECTURENAME(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		ItemInventoryTransFB formBean = (ItemInventoryTransFB) form;

		ItemInventoryTransDATA.manufectuteName(formBean, request, response);

		return null;

	}

	/**
	 * To add data.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 * @throws SQLException
	 */

	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		saveToken(request);

		ItemInventoryTransFB formBean = (ItemInventoryTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());
		ItemInventoryTransDATA.insert(formBean);
		return this.ADD(mapping, form, request, response);
	}

	/**
	 * forwards control to the modify page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward MODIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ItemInventoryTransFB formBean = (ItemInventoryTransFB) form;

		formBean.setStrChk(request.getParameter("chk"));

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		ItemInventoryTransDATA.modify(formBean);

		strtarget = "modify";
		return mapping.findForward(strtarget);
	}

	/**
	 * To modify data.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward UPDATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		saveToken(request);
		boolean retValue = false;
		ItemInventoryTransFB formBean = (ItemInventoryTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		retValue = ItemInventoryTransDATA.update(formBean);

		if (retValue)
			return this.LIST(mapping, form, request, response);
		else
			return this.MODIFY(mapping, formBean, request, response);
	}

	
	public ActionForward GETISMODIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ItemInventoryTransFB formBean = (ItemInventoryTransFB) form;
		ItemInventoryTransDATA.getIsModify(formBean, request, response);
		return null;
	}
	
	public ActionForward ADDNEW(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		ItemInventoryTransFB formBean = (ItemInventoryTransFB) _form;
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/ItemInventoryWithProgramTransBSCNT.cnt?hmode=ADD&storeId="+formBean.getCombo()[0]+"&catId="+formBean.getCombo()[1]+"&groupId="+formBean.getCombo()[2]+"&storeName="+formBean.getComboValue());
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward NEWMODIFY(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		ItemInventoryTransFB formBean = (ItemInventoryTransFB) _form;
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/ItemInventoryWithProgramTransBSCNT.cnt?hmode=MODIFY&storeId="+formBean.getCombo()[0]+"&catId="+formBean.getCombo()[1]+"&groupId="+formBean.getCombo()[2]+"&concatVal="+formBean.getComboValue()+"^"+formBean.getCombo()[0]);
		acFwd.setContextRelative(true);
		return acFwd;
	}


	public ActionForward CANCELPAGE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	public ActionForward LISTPAGE1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
				ItemInventoryTransFB formBean = (ItemInventoryTransFB) form;
			return this.LIST(mapping, form, request, response);
				
	}
}
