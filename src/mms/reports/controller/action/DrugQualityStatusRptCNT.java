package mms.reports.controller.action;

import java.sql.SQLException;

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.ConsumptionValueSummaryRptDATA;
import mms.reports.controller.data.DrugQualityStatusRptDATA;
import mms.reports.controller.fb.ConsumptionValueSummaryRptFB;
import mms.reports.controller.fb.DrugQualityStatusRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class DrugQualityStatusRptCNT extends DispatchAction
{
	/**
	 * To display the  on the Screen.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object with target
	 * @throws HisException
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		String target = "reportPage";
		DrugQualityStatusRptFB formBean = (DrugQualityStatusRptFB)form;
		DrugQualityStatusRptDATA.getInitializedValues(formBean,request);
		
		return mapping.findForward(target);
	}
	
	/**
	 * To display the Item Name on the Screen.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object with target
	 * @throws HisException
	 */
	public ActionForward GETDRUGLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		
		DrugQualityStatusRptFB formBean = (DrugQualityStatusRptFB)form;
		DrugQualityStatusRptDATA.getDrugNameCmb(formBean, request, response);
		
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

		DrugQualityStatusRptFB formBean = (DrugQualityStatusRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		DrugQualityStatusRptDATA.showReport(formBean, request, response);
		
		
	}
	
}
