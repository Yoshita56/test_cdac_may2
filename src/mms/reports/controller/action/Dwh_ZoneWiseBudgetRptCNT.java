package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.Dwh_ZoneWiseBudgetRptDATA;
import mms.reports.controller.fb.Dwh_ZoneWiseBudgetRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


public class Dwh_ZoneWiseBudgetRptCNT extends DispatchAction {

	
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		String target = "initialPage";
		Dwh_ZoneWiseBudgetRptFB formBean = (Dwh_ZoneWiseBudgetRptFB)form;
		Dwh_ZoneWiseBudgetRptDATA.getInitializedValues(formBean,request,response);
		
		return mapping.findForward(target);
	}
	
	
	public ActionForward GETZONEWISEBUDGETDTLPRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		Dwh_ZoneWiseBudgetRptFB fb = (Dwh_ZoneWiseBudgetRptFB) form;
	    Dwh_ZoneWiseBudgetRptDATA.getZoneWiseBudgetDtlPrint(fb, request,response);
	   	return null;
	}

	/** This method is used to cancel the Item Location.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response)
			 {
			  ActionForward acFwd = new ActionForward();
			  acFwd.setPath("/hisglobal/initPage.jsp");
			  acFwd.setContextRelative(true);
			  return acFwd;
			 }
	
}
