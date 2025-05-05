package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.HelpDeskRptDATA;
import mms.reports.controller.fb.HelpDeskRptFB;
import mms.transactions.controller.data.HelpDeskDATA;
import mms.transactions.controller.fb.HelpDeskFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class HelpDeskRptCNT extends DispatchAction 
{	
	/**
	 * To display the Item Category Name on the Screen.
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
			throws HisException {
		String target = "reportPage";
		HelpDeskRptFB formBean = (HelpDeskRptFB)form;
		HelpDeskRptDATA.getInitializedValues(formBean,request,response);
		
		return mapping.findForward(target);
	}
	
	
	/**
	 * Unspecified Method Use to Transfer the Control Over Action FIRSTDATA.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	public ActionForward GETSCREENTWO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		//System.out.println("Entered");
		HelpDeskRptFB fb = (HelpDeskRptFB) form;
	    HelpDeskRptDATA.getScreenTwo(fb, request,response);
	   	return null;
	}
	
	/**
	 * Unspecified Method Use to Transfer the Control Over Action FIRSTDATA.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	public ActionForward GETPRINTSCREENTWO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		HelpDeskRptFB fb = (HelpDeskRptFB) form;
	    HelpDeskRptDATA.getPrintScreenTwo(fb, request,response);
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
	
	
	public ActionForward DOWNLOAD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		//System.out.println("Action Class Entered");
		String strTarget = "download";
		HelpDeskRptFB formBean = (HelpDeskRptFB) form;
		HelpDeskRptDATA.DownloadFile(formBean,request,response);
		
		return mapping.findForward(strTarget);
		
		//ActionForward acFwd = new ActionForward();
		//request.setAttribute("Path","HelpDeskCNT.cnt");
		//acFwd.setPath("/mms/transactions/HelpDeskDownloadFileCNT.cnt?hmode=DOWNLOAD");
		// acFwd.setContextRelative(true);
	       // return acFwd;
	}

}
