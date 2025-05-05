package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.ApplicationErrorLogDetailRptDATA;
import mms.reports.controller.fb.ApplicationErrorLogDetailRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class ApplicationErrorLogDetailRptCNT extends DispatchAction {
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.init(mapping, form, request, response);
		
	}
	
	/** This method is used to forward the request on first jsp page
	 * And calls the methods getInitialValues() which is define in PendingListAgendaRptDATA java file. AND LIST VALUES to display combos 
	 * on first page. 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * 
	 */
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException 
	{
		String strTarget = "reportPage";
		ApplicationErrorLogDetailRptFB formBean = (ApplicationErrorLogDetailRptFB) form;
		ApplicationErrorLogDetailRptDATA.getInit(formBean,request);
				
		return mapping.findForward(strTarget);
	}
	

	public void SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ApplicationErrorLogDetailRptFB formBean = (ApplicationErrorLogDetailRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		ApplicationErrorLogDetailRptDATA.showReport(formBean, request, response);
		
		
	}
	
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
	    ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	public ActionForward SHOWSERVERLOG(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String strTarget = "serverLog";
		
		ApplicationErrorLogDetailRptFB formBean = (ApplicationErrorLogDetailRptFB) form;
		ApplicationErrorLogDetailRptDATA.showServerLog(formBean, request, response);
		
		return mapping.findForward(strTarget);
		
	}
	public ActionForward VIEWHISPATH(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String strTarget = "serverLog";
		
		ApplicationErrorLogDetailRptFB formBean = (ApplicationErrorLogDetailRptFB) form;
		ApplicationErrorLogDetailRptDATA.viewHisPath(formBean, request, response);
		
		return mapping.findForward(strTarget);		
	}
	
	public ActionForward CHECKFTPCONNECTION(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException, SQLException 
	{
		String strTarget = "serverTrace";
		
		ApplicationErrorLogDetailRptFB formBean = (ApplicationErrorLogDetailRptFB) form;
		ApplicationErrorLogDetailRptDATA.checkFTP(formBean, request, response);
		ApplicationErrorLogDetailRptDATA.getInit(formBean,request);
		
		return mapping.findForward(strTarget);		
	}
	public ActionForward VIEWSTANDALONE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String strTarget = "serverLog";
		
		ApplicationErrorLogDetailRptFB formBean = (ApplicationErrorLogDetailRptFB) form;
		ApplicationErrorLogDetailRptDATA.viewStandalone(formBean, request, response);
		
		return mapping.findForward(strTarget);		
	}
	public ActionForward VIEWWAR(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String strTarget = "serverLog";
		
		ApplicationErrorLogDetailRptFB formBean = (ApplicationErrorLogDetailRptFB) form;
		ApplicationErrorLogDetailRptDATA.viewWAR(formBean, request, response);
		
		return mapping.findForward(strTarget);		
	}
	public ActionForward VIEWJAR(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String strTarget = "serverLog";
		
		ApplicationErrorLogDetailRptFB formBean = (ApplicationErrorLogDetailRptFB) form;
		ApplicationErrorLogDetailRptDATA.viewJAR(formBean, request, response);
		
		return mapping.findForward(strTarget);		
	}
	public ActionForward VIEWMODULE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String strTarget = "serverLog";
		
		ApplicationErrorLogDetailRptFB formBean = (ApplicationErrorLogDetailRptFB) form;
		ApplicationErrorLogDetailRptDATA.viewModule(formBean, request, response);
		
		return mapping.findForward(strTarget);		
	}
	public ActionForward VIEWTRIGGER(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String strTarget = "serverLog";
		
		ApplicationErrorLogDetailRptFB formBean = (ApplicationErrorLogDetailRptFB) form;
		ApplicationErrorLogDetailRptDATA.viewHisPath(formBean, request, response);
		
		return mapping.findForward(strTarget);		
	}
	public ActionForward VIEWFTPFILES(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String strTarget = "serverLog";
		
		ApplicationErrorLogDetailRptFB formBean = (ApplicationErrorLogDetailRptFB) form;
		ApplicationErrorLogDetailRptDATA.viewFtpFiles(formBean, request, response);
		
		return mapping.findForward(strTarget);		
	}
	public ActionForward SERVERTRACE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException 
	{
		String strTarget = "serverTrace";
		ApplicationErrorLogDetailRptFB formBean = (ApplicationErrorLogDetailRptFB) form;
		ApplicationErrorLogDetailRptDATA.getInit(formBean,request);
				
		return mapping.findForward(strTarget);
	}
	public ActionForward GETDBDATA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException 
	{
		ApplicationErrorLogDetailRptFB formBean = (ApplicationErrorLogDetailRptFB) form;
		ApplicationErrorLogDetailRptDATA.getDBData(formBean,request,response);
				
		return null;
	}
	

}
