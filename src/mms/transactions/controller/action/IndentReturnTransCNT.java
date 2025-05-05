package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.IndentReturnTransDATA;
import mms.transactions.controller.fb.IndentReturnTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class IndentReturnTransCNT extends DispatchAction
{
	/**
	 * INDENTDATA Method Use to Transfer the Control Over Action IndentData.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 * @throws IOException 
	 */ 
	public ActionForward INDENTDATA(ActionMapping mapping
			                        ,ActionForm form
			                        ,HttpServletRequest request
			                        ,HttpServletResponse response)throws HisException, SQLException, IOException
    {
		String strTarget = "returnFinalRequest";
		IndentReturnTransFB formBean = (IndentReturnTransFB) form;
		formBean.setStrChk(request.getParameter("chk"));
    	String path = "/mms"+request.getParameter("cnt_page")+".cnt";
		formBean.setStrPath(path.trim());
		if(formBean.getStrGoFlag().equals("0"))
		{	
		   IndentReturnTransDATA.viewData(formBean,request);
		   return mapping.findForward(strTarget);
		}
		else
		{			
			formBean.setStrPath(request.getParameter("strPath"));
			IndentReturnTransDATA.viewData1(formBean,request);
			return mapping.findForward(strTarget);
		}
		
	}
		/**
	 * forwards control to the ADD page of Trasaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 * @throws IOException 
	 */
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException 
	{
      	IndentReturnTransFB fb = (IndentReturnTransFB) form;
	    //IndentReturnTransDATA.INSERT(fb, request); 
	    //return this.INDENTDATA(mapping, form, request, response);
	    
	    boolean retValue = false;	
	   	retValue =  IndentReturnTransDATA.INSERT(fb, request);
	      
	    if (retValue)
	    	return this.CANCEL(mapping, form, request, response);
		else
			return this.INDENTDATA(mapping, form, request, response);
	    
	    
	}
		
	/**
	 * CANCEL 
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
//	public ActionForward CANCEL(ActionMapping _mapping, ActionForm _form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws HisException, SQLException 
//	{
//		ActionForward acFwd = new ActionForward();
//		acFwd.setPath(request.getParameter("strPath"));
//        acFwd.setContextRelative(true);
//        return acFwd;
//        
//    }
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		ActionForward acFwd = new ActionForward();
		String strPath = "";
		if(request.getParameter("strPath")!= null)
		{
			strPath = request.getParameter("strPath").concat("?hmode=CANCEL");
			acFwd.setPath(strPath);
	        acFwd.setContextRelative(true);
	        
		}
		return acFwd;
	}

}
