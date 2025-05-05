package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;

import mms.reports.controller.data.IndentWiseIssueRPTDATA;
import mms.reports.controller.fb.IndentWiseIssueRPTFB;

public class IndentWiseIssueRPTCNT extends CSRFGardTokenAction {
	
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
		IndentWiseIssueRPTFB formBean = (IndentWiseIssueRPTFB)form;
		IndentWiseIssueRPTDATA.initialGenAdd(formBean,request);
//		System.out.println("<------------LocalPurchaseMRN_CNT.Purchase Through------------>"+formBean.getStrInstituteValues());
//		System.out.println("<------------LocalPurchaseMRN_CNT.Item Category------------>"+formBean.getStrItemCategoryCombo());
//		System.out.println("<------------LocalPurchaseMRN_CNT.Item Name------------>"+formBean.getlpItemName());
//		System.out.println("<------------LocalPurchaseMRN_CNT.Store Name------------>"+formBean.getStrStoreNameCombo());
//		System.out.println("<------------LocalPurchaseMRN_CNT.Supplier Name------------>"+formBean.getStrSupplierCombo());
		
//		String target = "LocalPurchase";
		String target = "Acknowledge";
		return mapping.findForward(target);
	}
	
	public ActionForward LPITEMNAME(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
			IndentWiseIssueRPTFB formBean = (IndentWiseIssueRPTFB)form;
			IndentWiseIssueRPTDATA.lpitemName(formBean, request, response);
			return null;
	}
	
	public ActionForward GOVIEWPAGE(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
			
		IndentWiseIssueRPTFB fb = (IndentWiseIssueRPTFB) form;
		IndentWiseIssueRPTDATA.getViewDtl(fb, request, response);
		return null;
	}	
}
