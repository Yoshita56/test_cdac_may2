package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.reports.controller.data.INJStoreIssueRptDATA;
import mms.reports.controller.fb.INJStoreIssueRptFB;

public class INJStoreIssueRptCNT extends CSRFGardTokenAction {
	
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
		INJStoreIssueRptFB formBean = (INJStoreIssueRptFB)form;
		INJStoreIssueRptDATA.initialGenAdd(formBean,request);	
		System.out.println("------------- INJStoreIssueRptCNT.unspecified ----[inj_issue_rpt.jsp,InjStoreIssue.js]----------------");
		String target = "injIssueRpt";
		return mapping.findForward(target);
	}
	
	/**
	 * This function is used to insert details into database
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	
	public ActionForward LPITEMNAME(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
			INJStoreIssueRptFB formBean = (INJStoreIssueRptFB)form;
			INJStoreIssueRptDATA.lpitemName(formBean, request, response);
			return null;
	}
	
	public ActionForward GOVIEWPAGE(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
			
		INJStoreIssueRptFB fb = (INJStoreIssueRptFB) form;
		INJStoreIssueRptDATA.getViewDtl(fb, request, response);
		return null;
	}	
}

