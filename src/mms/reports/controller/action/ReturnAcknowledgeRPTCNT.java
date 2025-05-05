package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.reports.controller.data.ReturnAcknowledgeRPTDATA;
import mms.reports.controller.fb.ReturnAcknowledgeRPTFB;

public class ReturnAcknowledgeRPTCNT extends CSRFGardTokenAction {
	

/*	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		
		generateToken(request);
		
		ReturnAcknowledgeRPTFB formBean = (ReturnAcknowledgeRPTFB)form;
		ReturnAcknowledgeRPTDATA.initialGenAdd(formBean,request);
		String target = "index";
		return mapping.findForward(target);
	}
*/

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
	
		return this.INITDETAIL(mapping, form, request, response);
	}
	
	public ActionForward INITDETAIL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
	
		System.out.println("---------INITDETAIL---------"); 
		String target = "index";
		ReturnAcknowledgeRPTFB fb = (ReturnAcknowledgeRPTFB)form;
		ReturnAcknowledgeRPTDATA.initialGenAdd(fb, request);
		return mapping.findForward(target);
	}
	
	public ActionForward GETRPTDTLS(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("---- ReturnAcknowledgeRPTCNT . GETRPTDTLS ----");

		ReturnAcknowledgeRPTFB fb = (ReturnAcknowledgeRPTFB) form;
		ReturnAcknowledgeRPTDATA.getRptDtls(fb, request, response);
		return null;
	}

}
