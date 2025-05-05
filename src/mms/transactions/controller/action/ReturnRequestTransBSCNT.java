package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.ReturnRequestTransDATA;
import mms.transactions.controller.fb.ReturnRequestTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class ReturnRequestTransBSCNT extends DispatchAction
{
	String strtarget;

	/**
	 * Constructor of Class.
	 */
	public ReturnRequestTransBSCNT()
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
		
		System.out.println("----------------ReturnRequestTransBSCNT . GO----[ add_ReturnRequestTrans_mmsNew.jsp ]------------");
		String strTarget = "ReturnRequestTransJsp";
		ReturnRequestTransFB fb = (ReturnRequestTransFB) form;
		ReturnRequestTransDATA.GetData(fb, request);
	   
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
	public ActionForward GO_NEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		System.out.println("----------------ReturnRequestTransBSCNT . GO_NEW----[ add_ReturnRequestTrans_mmsNew.jsp ]------------");
		
		String strTarget = "ReturnRequestTransJsp";
		ReturnRequestTransFB fb = (ReturnRequestTransFB) form;
		ReturnRequestTransDATA.GetData_NEW(fb, request);
	   
		return mapping.findForward(strTarget);
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
	 */
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		ReturnRequestTransFB fb = (ReturnRequestTransFB) form;
		boolean retValue = false;	
	   	retValue = ReturnRequestTransDATA.INSERT(fb, request);
	      
	    if (retValue)
	    	return this.GO(mapping, form, request, response);
		else
			return this.GO(mapping, form, request, response);
	    

	}
	
	
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
		else
		{
			acFwd.setPath("/mms/transactions/IndentTransNEWCNT.cnt?hmode=LIST");
	        acFwd.setContextRelative(true);
		}
		return acFwd;
	}
}
