package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import hisglobal.exceptions.HisException;
import mms.reports.controller.data.SaleReportCategoryDATA;
import mms.reports.controller.fb.SaleReportCategoryFB;

public class SaleReportCategoryCNT extends DispatchAction {

	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception, SQLException {

		return this.STORECMB(mapping, form, request, response);
	}

	public ActionForward STORECMB(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		String strTarget = "index";
		SaleReportCategoryFB formBean = (SaleReportCategoryFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		SaleReportCategoryDATA.getStoreList(formBean, request, response);
		return mapping.findForward(strTarget);
	}

	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		SaleReportCategoryFB formBean = (SaleReportCategoryFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		SaleReportCategoryDATA.getItemCatList(formBean, request, response);
		return null;
	}

	public ActionForward CANCEL(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}

	public ActionForward BACK(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception, SQLException {

		return this.STORECMB(mapping, form, request, response);

	}
	
	public void SHOWRPT(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		SaleReportCategoryFB formBean = (SaleReportCategoryFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		SaleReportCategoryDATA.showReport(formBean, request, response);
	}
	

}
