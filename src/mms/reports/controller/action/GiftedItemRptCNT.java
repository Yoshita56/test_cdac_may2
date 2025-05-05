package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.reports.controller.data.GiftedItemRptDATA;
import mms.reports.controller.fb.GiftedItemRptFB;

public class GiftedItemRptCNT extends CSRFGardTokenAction {
	
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
		GiftedItemRptFB formBean = (GiftedItemRptFB)form;
		GiftedItemRptDATA.initialGenAdd(formBean,request);
//		System.out.println("<------------LocalPurchaseMRN_CNT.Purchase Through------------>"+formBean.getStrInstituteValues());
//		System.out.println("<------------LocalPurchaseMRN_CNT.Item Category------------>"+formBean.getStrItemCategoryCombo());
//		System.out.println("<------------LocalPurchaseMRN_CNT.Item Name------------>"+formBean.getlpItemName());
//		System.out.println("<------------LocalPurchaseMRN_CNT.Store Name------------>"+formBean.getStrStoreNameCombo());
//		System.out.println("<------------LocalPurchaseMRN_CNT.Supplier Name------------>"+formBean.getStrSupplierCombo());
		String target = "GiftedItemRpt";
		return mapping.findForward(target);
	}
	
	public ActionForward LPITEMNAME(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
			GiftedItemRptFB formBean = (GiftedItemRptFB)form;
			GiftedItemRptDATA.lpitemName(formBean, request, response);
			return null;
	}
	
	public ActionForward GOVIEWPAGE(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
			
		GiftedItemRptFB fb = (GiftedItemRptFB) form;
		GiftedItemRptDATA.getViewDtl(fb, request, response);
		return null;
	}	
}
