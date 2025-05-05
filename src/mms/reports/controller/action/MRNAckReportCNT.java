package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.reports.controller.data.MRNAckReportDATA;
import mms.reports.controller.fb.MRNAckReportFB;


public class MRNAckReportCNT extends CSRFGardTokenAction {
	
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
		MRNAckReportFB formBean = (MRNAckReportFB)form;
		System.out.println("<------MRNAckReportCNT------>");
		MRNAckReportDATA.initialGenAdd(formBean,request);
		String target = "MrnAckReport";
		return mapping.findForward(target);
	}
	
	public ActionForward LPITEMNAME(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
			MRNAckReportFB formBean = (MRNAckReportFB)form;
			MRNAckReportDATA.lpitemName(formBean, request, response);
			return null;
	}
	
	public ActionForward GOVIEWPAGE(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
			
		MRNAckReportFB fb = (MRNAckReportFB) form;
		MRNAckReportDATA.getViewDtl(fb, request, response);
		return null;
	}	
}
