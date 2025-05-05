package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;

import mms.reports.controller.data.BreakageItemDATA;
import mms.reports.controller.fb.BreakageItemFB;

public class BreakageItemCNT extends CSRFGardTokenAction {
	
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
		BreakageItemFB formBean = (BreakageItemFB)form;
		BreakageItemDATA.initialGenAdd(formBean,request);
		System.out.println("<------------BreakageItemCNT.Purchase Through------------>"+formBean.getStrInstituteValues());
		System.out.println("<------------BreakageItemCNT.Item Category------------>"+formBean.getStrItemCategoryCombo());
		System.out.println("<------------BreakageItemCNT.Item Name------------>"+formBean.getlpItemName());
		System.out.println("<------------BreakageItemCNT.Store Name------------>"+formBean.getStrStoreNameCombo());
		System.out.println("<------------BreakageItemCNT.Supplier Name------------>"+formBean.getStrSupplierCombo());
		String target = "show";
		System.out.println(target);
		return mapping.findForward(target);
	}
	
	public ActionForward LPITEMNAME(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
			BreakageItemFB formBean = (BreakageItemFB)form;
			BreakageItemDATA.lpitemName(formBean, request, response);
			return null;
	}
	
	public ActionForward GOVIEWPAGE(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
			
		BreakageItemFB fb = (BreakageItemFB) form;
		BreakageItemDATA.getViewDtl(fb, request, response);
		return null;
	}	
}
