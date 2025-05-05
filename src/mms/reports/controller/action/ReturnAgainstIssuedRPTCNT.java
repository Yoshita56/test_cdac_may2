package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.reports.controller.data.ReturnAgainstIssuedRPTDATA;
import mms.reports.controller.fb.ReturnAgainstIssuedRPTFB;

public class ReturnAgainstIssuedRPTCNT extends CSRFGardTokenAction {
	
String strtarget = "";

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		generateToken(request);
		ReturnAgainstIssuedRPTFB formBean = (ReturnAgainstIssuedRPTFB)form;
		ReturnAgainstIssuedRPTDATA.initialGenAdd(formBean,request);
		String target = "index";
		return mapping.findForward(target);
	}
	//to get both the listing data of the return & issue 
	public ActionForward GETISSUERETURNDTLS(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	{
			
		ReturnAgainstIssuedRPTFB fb = (ReturnAgainstIssuedRPTFB) form;
		ReturnAgainstIssuedRPTDATA.getReturnAndIssueDtl(fb, request, response);
		return null;
	}	
	//to get the return voucher 
	public ActionForward RETURNDTLSVOUCHER(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		System.out.println("---- ReturnAgainstIssuedRPTCNT . RETURNDTLSVOUCHER ----");

		ReturnAgainstIssuedRPTFB formBean = (ReturnAgainstIssuedRPTFB) form;
		
		ReturnAgainstIssuedRPTDATA.getReturnVoucherDtl(formBean, request, response);

		return null;
	}

	//to get the issue voucher 
	public ActionForward ISSUEDTLSVOUCHER(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
    {
		System.out.println(" ------- ReturnAgainstIssuedRPTCNT.ISSUEDTLSVOUCHER  ------- ");
     
		ReturnAgainstIssuedRPTFB formBean = (ReturnAgainstIssuedRPTFB) form;
		
		//formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		//formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		ReturnAgainstIssuedRPTDATA.getIssueVoucherDtl(formBean, request, response);
		return null;
	 }

	
	
}
