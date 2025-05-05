package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.GiftedItemDetailsTransDATA;
import mms.transactions.controller.data.ReceiveFromThirdPartyTransDATA;
import mms.transactions.controller.fb.GiftedItemDetailsTransFB;
import mms.transactions.controller.fb.ReceiveFromThirdPartyTransFB;
/**
 * Developer : Tanvi Sappal
 * Version : 1.0
 * Date : 29/Jan/2009
 *  
*/
public class ReceiveFromThirdPartyTransCNTNEW extends CSRFGardTokenAction {
	
String strtarget = "";
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		generateToken(request);
		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.unspecified [ receivedItemDetailsTrans_mmsNEW.jsp ]-------------");
		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB)form;
		ReceiveFromThirdPartyTransDATA.initialGenAdd(formBean,request);
		String target = "add";
		return mapping.findForward(target);
	}
	
	public ActionForward INITPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		generateToken(request);
		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.INITPAGE [ receivedItemDetailsTrans_mmsNEW.jsp ]-------------");
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
	
	public ActionForward NEWRECEVING(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB)form;
		ReceiveFromThirdPartyTransDATA.getCategoryListTwoNEW(formBean, request, response);
		
		return null;
	}
	
	public ActionForward UPDATESTOCK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.UPDATESTOCK-------------");
		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB)form;
		ReceiveFromThirdPartyTransDATA.getCategoryListThreeNEW(formBean, request, response);
		
		return null;
	}
	
	public ActionForward DRUGINVENTORY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ReceiveFromThirdPartyTransFB fb = (ReceiveFromThirdPartyTransFB) form;
		this.UPDATESTOCK(mapping, form, request, response); 
		
		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.DRUGINVENTORY [ received_drugInventory_mmstransNEW.jsp ]-------------");
		
		ReceiveFromThirdPartyTransDATA.initialAdd(fb, request); // to display the Store
		strtarget = "druginventory";
		return mapping.findForward(strtarget);

	}
	
	public ActionForward ITEMINVENTORY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ReceiveFromThirdPartyTransFB fb = (ReceiveFromThirdPartyTransFB) form;
		this.UPDATESTOCK(mapping, form, request, response);    
		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.ITEMINVENTORY [ received_itemInventory_mmstransNEW.jsp ]-------------");
		
		ReceiveFromThirdPartyTransDATA.initialAdd(fb, request); // to display the Store
		strtarget = "itemInventory";
		return mapping.findForward(strtarget);

	}

	public ActionForward SUBGRPLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.SUBGRPLIST-------------");
		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB) form;
		ReceiveFromThirdPartyTransDATA.getSubGroupList(formBean, request, response);
		return null;
	}

	public ActionForward ITEMNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB) form;
		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.ITEMNAME-------------");
		ReceiveFromThirdPartyTransDATA.itemName(formBean, request, response);
		return null;
	}

	public ActionForward ITEMBRANDNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB) form;
		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.ITEMBRANDNAME-------------");
		ReceiveFromThirdPartyTransDATA.itemBrandName(formBean, request, response);
		return null;
	}
	
	public ActionForward BRANDDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.BRANDDETAILS-------------");
		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB) form;
		ReceiveFromThirdPartyTransDATA.getBrandDetails(formBean, request, response);
		return null;
	}

	public ActionForward UNITNAMECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB) form;
		ReceiveFromThirdPartyTransDATA.unitNameCombo(formBean, request, response);
		return null;
	}

	public ActionForward MANUFECTURENAME(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB) form;
		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.MANUFECTURENAME-------------");

		ReceiveFromThirdPartyTransDATA.manufectuteName(formBean, request, response);

		return null;

	}

	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception {

		validateToken(request, response);
		
		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.INSERT-------------");

		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
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
	
// To generate list view of previous received based on date selection from view page 
	public ActionForward GETRECEIVEDITEMVIEWDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		
		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.GETRECEIVEDITEMVIEWDTLS-------------");

		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB)form;
		ReceiveFromThirdPartyTransDATA.getReceivedItemList(formBean, request, response);
		
		return null;
	}
	
	public ActionForward VOUCHER_PRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		
		System.out.println(" ------- ReceiveFromThirdPartyTransCNTNEW.VOUCHER  ------- ");
		ReceiveFromThirdPartyTransFB formBean = (ReceiveFromThirdPartyTransFB) form;
		   
		ReceiveFromThirdPartyTransDATA.printVoucherDtl(formBean, request, response);
		return null;
	 }
}
