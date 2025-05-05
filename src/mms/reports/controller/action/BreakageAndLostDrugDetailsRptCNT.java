package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import hisglobal.exceptions.HisException;
import mms.reports.controller.data.BreakageAndLostDrugDetailsRptDATA;
import mms.reports.controller.fb.BreakageAndLostDrugDetailsRptFB;

public class BreakageAndLostDrugDetailsRptCNT extends DispatchAction {

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.INITVAL(mapping, form, request, response);
		
	}
	
	public ActionForward INITVAL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		System.out.println("---------BreakageAndLostDrugDetailsRptCNT.INITVAL----- [ dwh_breakageAndLostDrugDetails_rpt.jsp ]----");
		
		String strTarget = "reportPage";
		BreakageAndLostDrugDetailsRptFB formBean = (BreakageAndLostDrugDetailsRptFB) form;
		
		BreakageAndLostDrugDetailsRptDATA.setInitializedValues(formBean,request, response);
		return mapping.findForward(strTarget);
	}
	
	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		BreakageAndLostDrugDetailsRptFB formBean = (BreakageAndLostDrugDetailsRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		BreakageAndLostDrugDetailsRptDATA.getItemCatList(formBean,request, response);
		return null;
	}
	
	/*public ActionForward STORECMB(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws HisException, SQLException 
	{
		
		BreakageAndLostDrugDetailsRptFB formBean = (BreakageAndLostDrugDetailsRptFB) form;
		BreakageAndLostDrugDetailsRptDATA.getStoreList(formBean,request, response);
		return null;
	}*/
	
/*	public void SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		BreakageAndLostDrugDetailsRptFB formBean = (BreakageAndLostDrugDetailsRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		BreakageAndLostDrugDetailsRptDATA.showReport(formBean, request, response);
		
	}
	*/
	public void SHOWRPTNEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		BreakageAndLostDrugDetailsRptFB formBean = (BreakageAndLostDrugDetailsRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		BreakageAndLostDrugDetailsRptDATA.showReportNew(formBean, request, response);
	}
	
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
	    ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
}

