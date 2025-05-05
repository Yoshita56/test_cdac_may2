package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.CondemnationRegisterViewTransDATA;
import mms.transactions.controller.fb.CondemnationRegisterViewTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class CondemnationRegisterViewTransCNT extends  DispatchAction  {
	
	/*
	 * Developer : Kapil Khurana
	 * Version : 1.0 
	 * Date : 02/April/2009
	 *  Module:MMS
	 * Unit:Bill Approval View  
	*/
	/**
	 * Unspecified Method Use to Transfer the Control Over Action viewData.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
		throws Exception, SQLException 
		{
			
			return CONDEMNATIONREGISTERVIEW(mapping,form,request,response);
		}
	
	
	public ActionForward CONDEMNATIONREGISTERVIEW(ActionMapping mapping
			                        ,ActionForm form
			                        ,HttpServletRequest request
	                              ,HttpServletResponse response)throws HisException, SQLException
    {
		String strTarget = "index";
		String path = "/mms"+request.getParameter("cnt_page")+".cnt";
		CondemnationRegisterViewTransFB formBean = (CondemnationRegisterViewTransFB) form;
		formBean.setStrPath(path);
		CondemnationRegisterViewTransDATA.viewData(formBean,request);
		
		return mapping.findForward(strTarget);
	}
	
	public ActionForward CONDEMNATIONREQVIEW(ActionMapping mapping
            ,ActionForm form
            ,HttpServletRequest request
          ,HttpServletResponse response)throws HisException, SQLException
          {
			String strTarget = "view";
			String path = "/mms"+request.getParameter("cnt_page")+".cnt";
			CondemnationRegisterViewTransFB formBean = (CondemnationRegisterViewTransFB) form;
			formBean.setStrPath(path);
			CondemnationRegisterViewTransDATA.viewReqData(formBean, request);
			
			return mapping.findForward(strTarget);
          }
	/*
	 * 
	 */
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		
		ActionForward afd=new ActionForward();
		afd.setPath(request.getParameter("strPath"));
		afd.setContextRelative(true);
		return afd; 
	}
}
