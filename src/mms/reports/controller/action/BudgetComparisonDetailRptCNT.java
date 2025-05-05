package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.BudgetComparisonDetailRptDATA;
import mms.reports.controller.fb.BudgetComparisonDetailRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class BudgetComparisonDetailRptCNT extends DispatchAction {

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.INITVAL(mapping, form, request, response);
		
	}
	
	
	public ActionForward INITVAL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		

		String strTarget = "reportPage";
		BudgetComparisonDetailRptFB formBean = (BudgetComparisonDetailRptFB) form;
		
		BudgetComparisonDetailRptDATA.getInitializedValues(formBean,request, response);
		return mapping.findForward(strTarget);
	}
	
	
	public ActionForward STORECMB(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws HisException, SQLException 
	{
		
		BudgetComparisonDetailRptFB formBean = (BudgetComparisonDetailRptFB) form;
		BudgetComparisonDetailRptDATA.getStoreList(formBean,request, response);
		return null;
	}
	
	
	
	public void SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		BudgetComparisonDetailRptFB formBean = (BudgetComparisonDetailRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		BudgetComparisonDetailRptDATA.showReport(formBean, request, response);
		
		
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

