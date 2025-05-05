package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.PendingIndentStatusRecordRptDATA;
import mms.reports.controller.fb.PendingIndentStatusRecordRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class PendingIndentStatusRecordRptCNT extends DispatchAction {
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		return this.STORECMB(mapping, form, request, response);
	}
	
	public ActionForward STORECMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		String strTarget = "index";
		PendingIndentStatusRecordRptFB formBean = (PendingIndentStatusRecordRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		PendingIndentStatusRecordRptDATA.getStoreList(formBean,request, response);
		return mapping.findForward(strTarget);
	}
	
	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		PendingIndentStatusRecordRptFB formBean = (PendingIndentStatusRecordRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		PendingIndentStatusRecordRptDATA.getItemCatList(formBean,request, response);
		return null;
	}
	
	public ActionForward REQTYPECMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		PendingIndentStatusRecordRptFB formBean = (PendingIndentStatusRecordRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		PendingIndentStatusRecordRptDATA.getReqTypeList(formBean,request, response);
		return null;
	}
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
	    ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward Back(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.STORECMB(mapping, form, request, response);
	}
	
	/*	public ActionForward PARTIALISSUERPT(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException 
		{
			String strTarget = "partialIssue";
	   try
	   {
			PendingIndentStatusRecordRptFB formBean = (PendingIndentStatusRecordRptFB) form;
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			PendingIndentStatusRecordRptDATA.getPartialIssueDtls(formBean,request, response);
	   }
	   catch(Exception e)
	   {
		   e.printStackTrace();
	   }
			return mapping.findForward(strTarget);
		}*/
	
	
	public void SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		PendingIndentStatusRecordRptFB formBean = (PendingIndentStatusRecordRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		PendingIndentStatusRecordRptDATA.showReport(formBean, request, response);
	}

}
