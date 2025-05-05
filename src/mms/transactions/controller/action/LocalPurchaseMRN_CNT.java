package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.LocalPurchaseMRN_DATA;
import mms.transactions.controller.fb.LocalPurchaseMRN_FB;

public class LocalPurchaseMRN_CNT extends CSRFGardTokenAction {
	
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
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		generateToken(request);
		LocalPurchaseMRN_FB formBean = (LocalPurchaseMRN_FB)form;
		LocalPurchaseMRN_DATA.initialGenAdd(formBean,request);

//		System.out.println("<------------LocalPurchaseMRN_CNT.Purchase Through------------>"+formBean.getStrInstituteValues());
//		System.out.println("<------------LocalPurchaseMRN_CNT.Item Category------------>"+formBean.getStrItemCategoryCombo());
//		System.out.println("<------------LocalPurchaseMRN_CNT.Item Name------------>"+formBean.getlpItemName());
//		System.out.println("<------------LocalPurchaseMRN_CNT.Store Name------------>"+formBean.getStrStoreNameCombo());
//		System.out.println("<------------LocalPurchaseMRN_CNT.Supplier Name------------>"+formBean.getStrSupplierCombo());
		String target = "LocalPurchase";
		return mapping.findForward(target);
	}
	 
	
	
	public ActionForward LPITEMNAME(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
			LocalPurchaseMRN_FB formBean = (LocalPurchaseMRN_FB)form;
			LocalPurchaseMRN_DATA.lpitemName(formBean, request, response);
			return null;
	}
	
	public ActionForward GROUPCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		LocalPurchaseMRN_FB formBean = (LocalPurchaseMRN_FB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		LocalPurchaseMRN_DATA.getGroupList(formBean, request, response);
		return null;
	}
	

	
	public ActionForward GOVIEWPAGE(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
			
		LocalPurchaseMRN_FB fb = (LocalPurchaseMRN_FB) form;
		LocalPurchaseMRN_DATA.getViewDtl(fb, request, response);
		return null;
	}	
}
