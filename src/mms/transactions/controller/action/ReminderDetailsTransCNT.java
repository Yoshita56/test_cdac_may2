package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.ReminderDetailsTransDATA;
import mms.transactions.controller.fb.ReminderDetailsTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class ReminderDetailsTransCNT extends DispatchAction {
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		ReminderDetailsTransFB formBean = (ReminderDetailsTransFB) form;
		
			return this.INITVAL(mapping, formBean, request, response);
		
	}
	
	public ActionForward INITVAL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		ReminderDetailsTransFB formBean = (ReminderDetailsTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		ReminderDetailsTransDATA.getStoreDtls(formBean);
		
		String target = "newindex";
		return mapping.findForward(target);
	}
	
	public ActionForward PONOCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ReminderDetailsTransFB formBean = (ReminderDetailsTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		ReminderDetailsTransDATA.getPONo(formBean,request, response);
		
		return null;
	}
	
	public ActionForward SCHEDULENO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ReminderDetailsTransFB formBean = (ReminderDetailsTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		ReminderDetailsTransDATA.getScheduleNo(formBean,request, response);
		
		return null;
	}
	
	public ActionForward PREVREMINDERDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ReminderDetailsTransFB formBean = (ReminderDetailsTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		ReminderDetailsTransDATA.getPrevReminderDtl(formBean,request, response);
		
		return null;
	}
	
	public ActionForward PODETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ReminderDetailsTransFB formBean = (ReminderDetailsTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		ReminderDetailsTransDATA.getPODetails(formBean,request, response);
		
		return null;
	}
	
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ReminderDetailsTransFB formBean = (ReminderDetailsTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		ReminderDetailsTransDATA.insert(formBean,request, response);
		
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

}
