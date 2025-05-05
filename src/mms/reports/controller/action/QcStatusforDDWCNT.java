

package mms.reports.controller.action;

/*
Developed By: BrahmamVeluguri
Dated :13-Apr-2012

 */

import java.sql.SQLException;

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.QcStatusforDDWDATA;
import mms.reports.controller.fb.QcStatusforDDWFB;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


public class QcStatusforDDWCNT extends DispatchAction {
	/**
	 * To display DDW Name on the Screen.
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
		QcStatusforDDWFB formBean = (QcStatusforDDWFB)form;
		QcStatusforDDWDATA.getInitializedValues(formBean,request);
		
		return mapping.findForward(target);
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

		QcStatusforDDWFB formBean = (QcStatusforDDWFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		QcStatusforDDWDATA.showReport(formBean, request, response);
		
		
	}

}
