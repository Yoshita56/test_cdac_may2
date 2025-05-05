package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.PatientReturnTransDATA;
import mms.transactions.controller.fb.PatientReturnTransFB;

public class PatientReturnTransCNT extends CSRFGardTokenAction 
{
	String target = "";

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		generateToken(request);
		
		PatientReturnTransFB formBean = (PatientReturnTransFB) form;
		// set 2 fields as flag value to flip according to requirement 
		PatientReturnTransDATA.getMmsConfigFlags(formBean, request, response);
		
		PatientReturnTransDATA.storeName(formBean, request);
		// after loading Store Name combo setting next upcoming sequence fields empty string 
		formBean.setStrCrNo("");
		target = "index";
		return mapping.findForward(target);
	}

	public ActionForward ITEMCATEGORY(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		PatientReturnTransFB formBean = (PatientReturnTransFB) form;
		PatientReturnTransDATA.itemCategory(formBean, request, response);
		return null;
	}
	
	public ActionForward GO(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		generateToken(request);
		PatientReturnTransFB formBean = (PatientReturnTransFB) form;
			//fetch patient demo dtls 
			boolean fRes = PatientReturnTransDATA.patientDetailNEW(formBean, request);
			System.out.println("-----patientDetailNEW >fRes---------" + fRes);
			if (fRes) {
				target = "listingPage";
				return mapping.findForward(target);
			} else {
				PatientReturnTransDATA.storeName(formBean, request);
				formBean.setStrCrNo("");
				target = "index";
				return mapping.findForward(target);
			}
	}
	
	public ActionForward INSERT_LIST(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		System.out.println("------------ PatientReturnTransCNTNEW .INSERT_LIST  ------------");		
		validateToken(request, response);
		PatientReturnTransFB formBean = (PatientReturnTransFB)form;
		PatientReturnTransDATA.insert_LIST(formBean,request);
		formBean.setFlagWithoutCrNo("0");
		return this.unspecified(mapping, form, request, response);
	}
	
	/* voucher */
	public ActionForward ISSUEDTLSINITNEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		PatientReturnTransFB formBean = (PatientReturnTransFB) form;
		
		System.out.println("---- PatientReturnTransCNTNEW . ISSUEDTLSINITNEW ----");
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		PatientReturnTransDATA.issueDtlsInitNEW_Voucher(request, response, formBean);

		return null;
	}
	
/*	public ActionForward validateIssueNumber(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		System.out.println("------------ PatientReturnTransCNTNEW .validateIssueNumber  ------------");

		PatientReturnTransFB formBean = (PatientReturnTransFB) form;
		if (PatientReturnTransDATA.validateIssueNumber(formBean, request, response)) {
			return withoutCrNo(mapping, form, request, response);
		} else {
			String target = "patientWithoutCrNo";
			return mapping.findForward(target);
		}
	}
	*/
	
	public ActionForward VIEWPAGE(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String strTarget = "view";
	
		PatientReturnTransFB fb = (PatientReturnTransFB) form;
		//PatientReturnTransDATA.initViewPageDtl(fb, request);
		PatientReturnTransDATA.storeName(fb, request);
		return mapping.findForward(strTarget);
	}
	
	public ActionForward GOVIEWPAGE(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		PatientReturnTransFB fb = (PatientReturnTransFB) form;
		PatientReturnTransDATA.getViewDtlNEW(fb, request, response);
		return null;
	}
	
	
	
	
}
