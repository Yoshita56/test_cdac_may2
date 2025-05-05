package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.ConsolidatedDistrictWiseBudgetDetailRptDATA;
/*import mms.reports.controller.data.AssetRegisterRptDATA;*/
import mms.reports.controller.fb.ConsolidatedDistrictWiseBudgetDetailRptFB;
/*import mms.reports.controller.fb.AssetRegisterRptFB;*/

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class ConsolidatedDistrictWiseBudgetDetailRptCNT extends DispatchAction {

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.INITVAL(mapping, form, request, response);
		
	}
	
	
	public ActionForward INITVAL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		

		String strTarget = "reportPage";
		ConsolidatedDistrictWiseBudgetDetailRptFB formBean = (ConsolidatedDistrictWiseBudgetDetailRptFB) form;
		
		ConsolidatedDistrictWiseBudgetDetailRptDATA.getInitializedValues(formBean,request, response);
		return mapping.findForward(strTarget);
	}
	
	
	
	public void SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ConsolidatedDistrictWiseBudgetDetailRptFB formBean = (ConsolidatedDistrictWiseBudgetDetailRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		ConsolidatedDistrictWiseBudgetDetailRptDATA.showReport(formBean, request, response);
		
		
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

