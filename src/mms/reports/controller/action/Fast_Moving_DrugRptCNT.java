package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import mms.reports.controller.data.Fast_Moving_DrugRptDATA;
import mms.reports.controller.fb.Fast_Moving_DrugRptFB;
import mms.transactions.controller.data.ExportRecordsTransDATA;
import mms.transactions.controller.fb.ExportRecordsTransFB;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class Fast_Moving_DrugRptCNT extends DispatchAction {
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.INITVAL(mapping, form, request, response);
		
	}
	
	public ActionForward INITVAL(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
	throws HisException, SQLException {


String strTarget = "reportPage";
Fast_Moving_DrugRptFB formBean = (Fast_Moving_DrugRptFB) form;

//ListOfInstitutionsRptDATA.getInitializedValues(formBean,request, response);
return mapping.findForward(strTarget);
}

	


public void SHOWRPT(ActionMapping mapping, ActionForm form,
	HttpServletRequest request, HttpServletResponse response)
	throws HisException, SQLException {

	Fast_Moving_DrugRptFB formBean = (Fast_Moving_DrugRptFB) form;
formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
Fast_Moving_DrugRptDATA.showReport(formBean, request, response);


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


