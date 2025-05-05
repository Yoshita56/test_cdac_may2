package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.reports.controller.data.AcknowledgeReceiptPORptDATA;
import mms.reports.controller.fb.AcknowledgeReceiptPORptFB;

public class AcknowledgeReceiptPORptCNT extends CSRFGardTokenAction {
	
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
		AcknowledgeReceiptPORptFB formBean = (AcknowledgeReceiptPORptFB)form;
		AcknowledgeReceiptPORptDATA.initialGenAdd(formBean,request);
//		System.out.println("<------------AcknowledgeReceiptPORptCNT.Purchase Through------------>"+formBean.getStrInstituteValues());
//		System.out.println("<------------AcknowledgeReceiptPORptCNT.Item Category------------>"+formBean.getStrItemCategoryCombo());
//		System.out.println("<------------AcknowledgeReceiptPORptCNT.Item Name------------>"+formBean.getlpItemName());
//		System.out.println("<------------AcknowledgeReceiptPORptCNT.Store Name------------>"+formBean.getStrStoreNameCombo());
//		System.out.println("<------------AcknowledgeReceiptPORptCNT.Supplier Name------------>"+formBean.getStrSupplierCombo());
		String target = "show";
		return mapping.findForward(target);
	}
	
	public ActionForward LPITEMNAME(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
			AcknowledgeReceiptPORptFB formBean = (AcknowledgeReceiptPORptFB)form;
			AcknowledgeReceiptPORptDATA.lpitemName(formBean, request, response);
			return null;
	}
	
	public ActionForward GOVIEWPAGE(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
			
		AcknowledgeReceiptPORptFB fb = (AcknowledgeReceiptPORptFB) form;
		AcknowledgeReceiptPORptDATA.getViewDtl(fb, request, response);
		return null;
	}	
}
