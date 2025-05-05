package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.StockReceiptRegisterRptDATA;
import mms.reports.controller.fb.StockReceiptRegisterRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class StockReceiptRegisterRptCNT extends DispatchAction{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.STORECMB(mapping, form, request, response);
		
	}
	
	public ActionForward STORECMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		

		String strTarget = "index";
		StockReceiptRegisterRptFB formBean = (StockReceiptRegisterRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockReceiptRegisterRptDATA.getStoreList(formBean,request, response);
		return mapping.findForward(strTarget);
	}
	
	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StockReceiptRegisterRptFB formBean = (StockReceiptRegisterRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		StockReceiptRegisterRptDATA.getItemCatList(formBean,request, response);
		return null;
	}
	
	public ActionForward ITEMCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StockReceiptRegisterRptFB formBean = (StockReceiptRegisterRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		StockReceiptRegisterRptDATA.getItemList(formBean,request, response);
		return null;
	}
	public ActionForward SUPPCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StockReceiptRegisterRptFB formBean = (StockReceiptRegisterRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		StockReceiptRegisterRptDATA.getSupplierList(formBean,request, response);
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
	
	public void SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StockReceiptRegisterRptFB formBean = (StockReceiptRegisterRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		StockReceiptRegisterRptDATA.showReport(formBean, request, response);
		
		
	}

	public ActionForward Back(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.STORECMB(mapping, form, request, response);
		
	}
}
