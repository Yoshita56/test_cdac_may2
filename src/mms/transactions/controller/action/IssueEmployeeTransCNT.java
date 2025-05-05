package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.IssueEmployeeTransDATA;
import mms.transactions.controller.fb.IssueEmployeeTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class IssueEmployeeTransCNT extends DispatchAction{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		IssueEmployeeTransFB formBean = (IssueEmployeeTransFB) form;

		return this.INITVAL(mapping, formBean, request, response);
		
		
	}
	
	public ActionForward INITVAL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		IssueEmployeeTransFB formBean = (IssueEmployeeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		IssueEmployeeTransDATA.getStoreDtls(formBean, request);
		////System.out.println("err message"+formBean.getStrErrMsg());
		String target = "issueemp";
		return mapping.findForward(target);
	}
	
	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		IssueEmployeeTransFB formBean = (IssueEmployeeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		IssueEmployeeTransDATA.getItemCatDtls(formBean,request, response);
		
		return null;
	}
	
	public ActionForward INITVALGO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		IssueEmployeeTransFB formBean = (IssueEmployeeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueEmployeeTransDATA.getEmployeeDetails(formBean, request, response);
		if(formBean.getStrChkEmpExist().equals("0")){
			return this.INITVAL(mapping, formBean, request, response);
		}else{
		IssueEmployeeTransDATA.getPrescribedBy(formBean, request, response);
		IssueEmployeeTransDATA.getGroupDetails(formBean, request);
		
		String target = "issueempGo";
		return mapping.findForward(target);
		}
	}
	
	
	public ActionForward PRESCRIPEDBY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		IssueEmployeeTransFB formBean = (IssueEmployeeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueEmployeeTransDATA.getPrescribedBy(formBean, request, response);
		return null;
	}
	
	public ActionForward PREVISSUEDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		IssueEmployeeTransFB formBean = (IssueEmployeeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueEmployeeTransDATA.getIssueDetails(formBean, request, response);
		return null;
	}
	
	public ActionForward ISSUEDTLPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		IssueEmployeeTransFB formBean = (IssueEmployeeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueEmployeeTransDATA.getIssuePopUp(formBean, request, response);
		return null;
	}
	
	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
	    ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		IssueEmployeeTransFB formBean = (IssueEmployeeTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueEmployeeTransDATA.insert(formBean, request);
		
		return this.INITVAL(mapping, formBean, request, response);
	}

}
