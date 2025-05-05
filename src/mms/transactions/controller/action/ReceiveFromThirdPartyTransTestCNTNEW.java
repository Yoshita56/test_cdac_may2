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
import mms.transactions.controller.fb.GiftedItemDetailsTransFB;

import mms.transactions.controller.data.ReceiveFromThirdPartyTransTestDATA;
import mms.transactions.controller.fb.ReceiveFromThirdPartyTransTestFB;

public class ReceiveFromThirdPartyTransTestCNTNEW extends CSRFGardTokenAction {
	
String strtarget = "";
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		generateToken(request);
		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.unspecified [ receivedItemDetailsTrans_mmsNEW.jsp ]-------------");
		ReceiveFromThirdPartyTransTestFB formBean = (ReceiveFromThirdPartyTransTestFB)form;
		ReceiveFromThirdPartyTransTestDATA.initialGenAdd(formBean,request);
		String target = "add";
		return mapping.findForward(target);
	}
	
	public ActionForward INITPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		generateToken(request);
		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.INITPAGE [ receivedItemDetailsTrans_mmsNEW.jsp ]-------------");
		ReceiveFromThirdPartyTransTestFB formBean = (ReceiveFromThirdPartyTransTestFB)form;
		ReceiveFromThirdPartyTransTestDATA.initialGenAdd(formBean,request);
		formBean.setStrReceivedItemViewMode("0");
		String target = "add";
		return mapping.findForward(target);
	}
	
	public ActionForward GETITEMCATLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		ReceiveFromThirdPartyTransTestFB formBean = (ReceiveFromThirdPartyTransTestFB)form;
		ReceiveFromThirdPartyTransTestDATA.getCategoryList(formBean, request, response);
		
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

		ReceiveFromThirdPartyTransTestFB formBean = (ReceiveFromThirdPartyTransTestFB)form;
		ReceiveFromThirdPartyTransTestDATA.getCategoryListTwoNEW(formBean, request, response);
		
		return null;
	}
	
	public ActionForward UPDATESTOCK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.UPDATESTOCK-------------");
		ReceiveFromThirdPartyTransTestFB formBean = (ReceiveFromThirdPartyTransTestFB)form;
		ReceiveFromThirdPartyTransTestDATA.getCategoryListThreeNEW(formBean, request, response);
		
		return null;
	}
	
	public ActionForward DRUGINVENTORY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ReceiveFromThirdPartyTransTestFB fb = (ReceiveFromThirdPartyTransTestFB) form;
		this.UPDATESTOCK(mapping, form, request, response); 
		
		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.DRUGINVENTORY [ received_drugInventory_mmstransNEW.jsp ]-------------");
		
		ReceiveFromThirdPartyTransTestDATA.initialAdd(fb, request); // to display the Store
		strtarget = "druginventory";
		return mapping.findForward(strtarget);

	}
	
	public ActionForward ITEMINVENTORY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ReceiveFromThirdPartyTransTestFB fb = (ReceiveFromThirdPartyTransTestFB) form;
		this.UPDATESTOCK(mapping, form, request, response);    
		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.ITEMINVENTORY [ received_itemInventory_mmstransNEW.jsp ]-------------");
		
		ReceiveFromThirdPartyTransTestDATA.initialAdd(fb, request); // to display the Store
		strtarget = "itemInventory";
		return mapping.findForward(strtarget);

	}

	public ActionForward SUBGRPLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.SUBGRPLIST-------------");
		ReceiveFromThirdPartyTransTestFB formBean = (ReceiveFromThirdPartyTransTestFB) form;
		ReceiveFromThirdPartyTransTestDATA.getSubGroupList(formBean, request, response);
		return null;
	}

	public ActionForward ITEMNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ReceiveFromThirdPartyTransTestFB formBean = (ReceiveFromThirdPartyTransTestFB) form;
		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.ITEMNAME-------------");
		ReceiveFromThirdPartyTransTestDATA.itemName(formBean, request, response);
		return null;
	}

	public ActionForward ITEMBRANDNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ReceiveFromThirdPartyTransTestFB formBean = (ReceiveFromThirdPartyTransTestFB) form;
		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.ITEMBRANDNAME-------------");
		ReceiveFromThirdPartyTransTestDATA.itemBrandName(formBean, request, response);
		return null;
	}
	
	public ActionForward BRANDDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.BRANDDETAILS-------------");
		ReceiveFromThirdPartyTransTestFB formBean = (ReceiveFromThirdPartyTransTestFB) form;
		ReceiveFromThirdPartyTransTestDATA.getBrandDetails(formBean, request, response);
		return null;
	}

	public ActionForward UNITNAMECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ReceiveFromThirdPartyTransTestFB formBean = (ReceiveFromThirdPartyTransTestFB) form;
		ReceiveFromThirdPartyTransTestDATA.unitNameCombo(formBean, request, response);
		return null;
	}

	public ActionForward MANUFECTURENAME(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		ReceiveFromThirdPartyTransTestFB formBean = (ReceiveFromThirdPartyTransTestFB) form;
		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.MANUFECTURENAME-------------");

		ReceiveFromThirdPartyTransTestDATA.manufectuteName(formBean, request, response);

		return null;

	}

	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception {

		validateToken(request, response);
		
		System.out.println("------------ReceiveFromThirdPartyTransCNTNEW.INSERT-------------");

		ReceiveFromThirdPartyTransTestFB formBean = (ReceiveFromThirdPartyTransTestFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		ReceiveFromThirdPartyTransTestDATA.insert(formBean);
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

		ReceiveFromThirdPartyTransTestFB formBean = (ReceiveFromThirdPartyTransTestFB)form;
		ReceiveFromThirdPartyTransTestDATA.getReceivedItemList(formBean, request, response);
		
		return null;
	}
	
	public ActionForward VOUCHER_PRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		
		System.out.println(" ------- ReceiveFromThirdPartyTransCNTNEW.VOUCHER  ------- ");
		ReceiveFromThirdPartyTransTestFB formBean = (ReceiveFromThirdPartyTransTestFB) form;
		   
		ReceiveFromThirdPartyTransTestDATA.printVoucherDtl(formBean, request, response);
		return null;
	 }
}
