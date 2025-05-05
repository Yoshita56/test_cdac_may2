package mms.reports.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import hisglobal.exceptions.HisException;
import mms.reports.controller.data.LPCStatusRptDATA;
import mms.reports.controller.fb.LPCStatusRptFB;

public class LPCStatusRptCNT extends DispatchAction {
	
String strtarget = "";
	
	/**
	 * forwards control to the Page LPCStatus_mmsrpt.jsp
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
		String target = "Acknowledge";
		return mapping.findForward(target);
	}
	
	
	
	public ActionForward GOVIEWPAGE(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
			
		LPCStatusRptFB fb = (LPCStatusRptFB) form;
		LPCStatusRptDATA.getViewDtl(fb, request, response);
		return null;
	}	
}