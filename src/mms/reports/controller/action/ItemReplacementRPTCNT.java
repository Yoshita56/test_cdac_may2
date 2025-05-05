package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.reports.controller.data.ItemReplacementRPTDATA;
import mms.reports.controller.fb.ItemReplacementRPTFB;

public class ItemReplacementRPTCNT extends CSRFGardTokenAction {
	
String strtarget = "";

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		
		generateToken(request);
		
		ItemReplacementRPTFB formBean = (ItemReplacementRPTFB)form;
		ItemReplacementRPTDATA.initialGenAdd(formBean,request);
		String target = "index";
		return mapping.findForward(target);
	}
	
	public ActionForward GETRPTDTLS(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
		System.out.println("---- ItemReplacementRPTCNT . GETRPTDTLS ----");

		ItemReplacementRPTFB fb = (ItemReplacementRPTFB) form;
		ItemReplacementRPTDATA.getRptDtls(fb, request, response);
		return null;
	}
	
	public ActionForward VOUCHER(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
    {
		System.out.println(" ------- ItemReplacementRPTCNT.VOUCHER  ------- ");
     
		ItemReplacementRPTFB fb = (ItemReplacementRPTFB) form;
		
		ItemReplacementRPTDATA.printVoucherDtl(fb, request, response);
		return null;
	 }
}
