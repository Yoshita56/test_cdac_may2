package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.GiftedItemDetailsTransDATA;
import mms.transactions.controller.data.ReceiveFromThirdPartyTransDATA;
import mms.transactions.controller.fb.GiftedItemDetailsTransFB;
import mms.transactions.controller.fb.ReceiveFromThirdPartyTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
/**
 * Developer : Tanvi Sappal
 * Version : 1.0
 * Date : 29/Jan/2009
 *  
*/
public class ReceiveFromThirdPartyTransCNT extends CSRFGardTokenAction {
	
String strtarget = "";
	
	/**
	 * forwards control to the Page giftedItemDetailsTrans_mms.jsp
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object with target
	 * @throws HisException
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		generateToken(request);
		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB)form;
		ReceiveFromThirdPartyTransDATA.initialGenAdd(formBean,request);
		String target = "add";
		return mapping.findForward(target);
	}
	
	
	public ActionForward INITPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		generateToken(request);
		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB)form;
		ReceiveFromThirdPartyTransDATA.initialGenAdd(formBean,request);
		formBean.setStrReceivedItemViewMode("0");
		String target = "add";
		return mapping.findForward(target);
	}
	

	public ActionForward GETITEMCATLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB)form;
		ReceiveFromThirdPartyTransDATA.getCategoryList(formBean, request, response);
		
		return null;
	}
	
	public ActionForward GETFINYR(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		GiftedItemDetailsTransFB formBean = (GiftedItemDetailsTransFB)form;
		GiftedItemDetailsTransDATA.getFinancialYear(formBean, request, response);
		
		return null;
	}
	
	/**
	 * By Amit Kumar
	 * Invoked by Ajax Functions and sets the required Item Brand Name Values.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	
	public ActionForward NEWRECEVING(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB)form;
		ReceiveFromThirdPartyTransDATA.getCategoryListTwo(formBean, request, response);
		
		return null;
	}
	/**
	 * By Amit Kumar
	 * Invoked by Ajax Functions and sets the required Item Brand Name Values.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	
	public ActionForward UPDATESTOCK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB)form;
		ReceiveFromThirdPartyTransDATA.getCategoryListThree(formBean, request, response);
		
		return null;
	}
	
	
	
	
	public ActionForward GETRECEIVEDITEMVIEWDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB)form;
		ReceiveFromThirdPartyTransDATA.getReceivedItemList(formBean, request, response);
		
		return null;
	}
	
	
	public ActionForward DRUGINVENTORY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ReceiveFromThirdPartyTransFB fb = (ReceiveFromThirdPartyTransFB) form;
		this.UPDATESTOCK(mapping, form, request, response); 
		ReceiveFromThirdPartyTransDATA.initialAdd(fb, request); // to display the Store
		strtarget = "druginventory";
		return mapping.findForward(strtarget);

	}
	
	public ActionForward ITEMINVENTORY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ReceiveFromThirdPartyTransFB fb = (ReceiveFromThirdPartyTransFB) form;
		this.UPDATESTOCK(mapping, form, request, response);    
		ReceiveFromThirdPartyTransDATA.initialAdd(fb, request); // to display the Store
		strtarget = "itemInventory";
		return mapping.findForward(strtarget);

	}

	
	public ActionForward SUBGRPLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB) form;
		ReceiveFromThirdPartyTransDATA.getSubGroupList(formBean, request, response);
		return null;
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
		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB) form;
		ReceiveFromThirdPartyTransDATA.itemName(formBean, request, response);
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
		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB) form;
		ReceiveFromThirdPartyTransDATA.itemBrandName(formBean, request, response);
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
		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB) form;
		ReceiveFromThirdPartyTransDATA.getBrandDetails(formBean, request, response);
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
		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB) form;
		ReceiveFromThirdPartyTransDATA.unitNameCombo(formBean, request, response);
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
		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB) form;

		ReceiveFromThirdPartyTransDATA.manufectuteName(formBean, request, response);

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
			throws HisException, Exception {

		validateToken(request, response);

		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());
		ReceiveFromThirdPartyTransDATA.insert(formBean);
		return this.INITPAGE(mapping, form, request, response);
	}
	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
		
	} 

	
}
