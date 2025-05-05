package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.reports.controller.data.POWiseMaterialReceiptRptDATA;
import mms.reports.controller.fb.POWiseMaterialReceiptRptFB;


public class POWiseMaterialReceiptRptCNT extends CSRFGardTokenAction {
	
String strtarget = "";
	
	/**
	 * forwards control to the Page POWiseMaterialReceipt_mmsrpt.jsp
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
		POWiseMaterialReceiptRptFB formBean = (POWiseMaterialReceiptRptFB)form;
		System.out.println("<------POWiseMaterialReceiptRptCNT------>");
		POWiseMaterialReceiptRptDATA.initialGenAdd(formBean,request);
		String target = "showReport";
		return mapping.findForward(target);
	}
	
	public ActionForward LPITEMNAME(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
			POWiseMaterialReceiptRptFB formBean = (POWiseMaterialReceiptRptFB)form;
			POWiseMaterialReceiptRptDATA.lpitemName(formBean, request, response);
			return null;
	}
	
	public ActionForward GOVIEWPAGE(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
			
		POWiseMaterialReceiptRptFB fb = (POWiseMaterialReceiptRptFB) form;
		POWiseMaterialReceiptRptDATA.getViewDtl(fb, request, response);
		return null;
	}	
}
