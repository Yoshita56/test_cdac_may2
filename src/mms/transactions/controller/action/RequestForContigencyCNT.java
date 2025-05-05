package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.RequestForContigencyDATA;
import mms.transactions.controller.fb.RequestForContigencyFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class RequestForContigencyCNT extends DispatchAction{
	String strtarget;

	/**
	 * Constructor of Class.
	 */
	public RequestForContigencyCNT()
	{
		
	}
	
	 /***********************UNSPECIFIED**************************/
	 
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
	public ActionForward unspecified(ActionMapping mapping
			                        ,ActionForm form
			                        ,HttpServletRequest request
			                        ,HttpServletResponse response)throws HisException, SQLException
    {
		return this.GO(mapping, form, request, response);
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
	public ActionForward GO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		
		
		String strTarget = "RequestForContigencyJsp";
		RequestForContigencyFB fb = (RequestForContigencyFB) form;
		RequestForContigencyDATA.GetData(fb, request);
	    
		return mapping.findForward(strTarget);
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
	/*public ActionForward UNITVAL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		RequestForContigencyFB fb = (RequestForContigencyFB) form;
	  //  RequestForContigencyDATA.UNITVAL(fb, request,response);
	   	return null;
	}*/
	
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
	/*public ActionForward UNITVAL1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		
	    RequestForContigencyFB fb = (RequestForContigencyFB) form;
	  //  RequestForContigencyDATA.UNITVAL1(fb, request,response);
	   	return null;
	}*/
	
	/**
	 * forwards control to the ADD page of Trasaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		RequestForContigencyFB fb = (RequestForContigencyFB) form;
		boolean retValue = false;	
	   	retValue = RequestForContigencyDATA.INSERT(fb, request);
	      
	    if (retValue)
	    	return this.GO(mapping, form, request, response);
		else
			return this.GO(mapping, form, request, response);
	   

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
