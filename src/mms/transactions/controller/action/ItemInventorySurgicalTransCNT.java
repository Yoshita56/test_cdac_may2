package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.ItemInventorySurgicalTransDATA;
import mms.transactions.controller.fb.ItemInventorySurgicalTransFB;
import mms.transactions.controller.utl.ItemInventorySurgicalTransUTL;

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

public class ItemInventorySurgicalTransCNT extends GenericController {


	String strtarget;
	
	public ItemInventorySurgicalTransCNT() {
		super(new ItemInventorySurgicalTransUTL(), "/transactions/ItemInventorySurgicalTransCNT");
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

		ItemInventorySurgicalTransFB fb = (ItemInventorySurgicalTransFB) form;

		ItemInventorySurgicalTransDATA.initialAdd(fb, request); // to display the Store
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
		ItemInventorySurgicalTransFB formBean = (ItemInventorySurgicalTransFB) form;
		ItemInventorySurgicalTransDATA.itemName(formBean, request, response);
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
		ItemInventorySurgicalTransFB formBean = (ItemInventorySurgicalTransFB) form;
		ItemInventorySurgicalTransDATA.itemBrandName(formBean, request, response);
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
		ItemInventorySurgicalTransFB formBean = (ItemInventorySurgicalTransFB) form;
		ItemInventorySurgicalTransDATA.getBrandDetails(formBean, request, response);
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
		ItemInventorySurgicalTransFB formBean = (ItemInventorySurgicalTransFB) form;
		ItemInventorySurgicalTransDATA.unitNameCombo(formBean, request, response);
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
		ItemInventorySurgicalTransFB formBean = (ItemInventorySurgicalTransFB) form;

		ItemInventorySurgicalTransDATA.manufectuteName(formBean, request, response);

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

		ItemInventorySurgicalTransFB formBean = (ItemInventorySurgicalTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());
		ItemInventorySurgicalTransDATA.insert(formBean);
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

		ItemInventorySurgicalTransFB formBean = (ItemInventorySurgicalTransFB) form;

		formBean.setStrChk(request.getParameter("chk"));

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		ItemInventorySurgicalTransDATA.modify(formBean);

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
		ItemInventorySurgicalTransFB formBean = (ItemInventorySurgicalTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());

		retValue = ItemInventorySurgicalTransDATA.update(formBean);

		if (retValue)
			return this.LIST(mapping, form, request, response);
		else
			return this.MODIFY(mapping, formBean, request, response);
	}

	
	public ActionForward GETISMODIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ItemInventorySurgicalTransFB formBean = (ItemInventorySurgicalTransFB) form;
		ItemInventorySurgicalTransDATA.getIsModify(formBean, request, response);
		return null;
	}
	
	public ActionForward ADDNEW(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		ItemInventorySurgicalTransFB formBean = (ItemInventorySurgicalTransFB) _form;
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/ItemInventoryWithProgramSurgicalTransCNT.cnt?hmode=ADD&storeId="+formBean.getCombo()[0]+"&catId="+formBean.getCombo()[1]+"&groupId="+formBean.getCombo()[2]+"&storeName="+formBean.getComboValue());
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward NEWMODIFY(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		ItemInventorySurgicalTransFB formBean = (ItemInventorySurgicalTransFB) _form;
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/ItemInventoryWithProgramTransCNT.cnt?hmode=MODIFY&storeId="+formBean.getCombo()[0]+"&catId="+formBean.getCombo()[1]+"&groupId="+formBean.getCombo()[2]+"&concatVal="+formBean.getComboValue()+"^"+formBean.getCombo()[0]);
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
				ItemInventorySurgicalTransFB formBean = (ItemInventorySurgicalTransFB) form;
			return this.LIST(mapping, form, request, response);
				
	}
}
