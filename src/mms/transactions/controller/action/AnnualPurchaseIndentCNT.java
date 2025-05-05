package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.AnnualPurchaseIndentDATA;
import mms.transactions.controller.fb.AnnualPurchaseIndentFB;
/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 1/May/2009
 * Modif Date : / /2009 
*/

public class AnnualPurchaseIndentCNT extends CSRFGardTokenAction
{
	String strtarget;

	/**
	 * Constructor of Class.
	 */
	public AnnualPurchaseIndentCNT()
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
		generateToken(request);
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
		
		generateToken(request);
		String strTarget = "AnnualPurchaseIndentJsp";
		AnnualPurchaseIndentFB fb = (AnnualPurchaseIndentFB) form;
		AnnualPurchaseIndentDATA.GetData(fb, request);
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
		AnnualPurchaseIndentFB fb = (AnnualPurchaseIndentFB) form;
	  //  AnnualPurchaseIndentDATA.UNITVAL(fb, request,response);
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
		
	    AnnualPurchaseIndentFB fb = (AnnualPurchaseIndentFB) form;
	  //  AnnualPurchaseIndentDATA.UNITVAL1(fb, request,response);
	   	return null;
	}
	*/
	/**
	 * forwards control to the ADD page of Trasaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
        validateToken(request, response);
		AnnualPurchaseIndentFB fb = (AnnualPurchaseIndentFB) form;
		boolean retValue = false;	
	   	retValue =  AnnualPurchaseIndentDATA.INSERT(fb, request);
	      
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
