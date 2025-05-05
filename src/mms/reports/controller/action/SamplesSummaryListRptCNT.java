/**
 * 
 */
package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.SamplesSummaryListRptDATA;
import mms.reports.controller.fb.SamplesSummaryListRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * Developer:Anshul Jindal
 * Creation Date: 17-07-2009 Modifying Date:-
 * Used For:-MMS Reports
 * Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class SamplesSummaryListRptCNT extends DispatchAction{ 

	/* (non-Javadoc)
	 * @see org.apache.struts.actions.DispatchAction#unspecified
	 * (org.apache.struts.action.ActionMapping,
	 *  org.apache.struts.action.ActionForm, 
	 *  javax.servlet.http.HttpServletRequest, 
	 *  javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		SamplesSummaryListRptFB formBean = (SamplesSummaryListRptFB) form;
		SamplesSummaryListRptDATA.getInitialDtl(formBean,request);
			
		String target = "index";
		return mapping.findForward(target);
		
	}
	
	public ActionForward SUPPLIERANDTENDER(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		SamplesSummaryListRptFB formBean = (SamplesSummaryListRptFB) form;
		SamplesSummaryListRptDATA.getSupplierAndTenderValues(formBean,request,response);
			
		
		return null;
		
	}
	
	public void SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		SamplesSummaryListRptFB formBean = (SamplesSummaryListRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		SamplesSummaryListRptDATA.showReport(formBean, request, response);
		
		
	}
	
	/**
	 * Cancel
	 * is used to forward control to Indent Desk
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward CANCEL(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}

	
}
