package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import mms.transactions.controller.fb.UtilityGenerationDeskFB;
import mms.transactions.controller.utl.UtilityGenerationDeskUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Amit Kumar
 * Date of Creation : 31/3/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
public class UtilityGenerationDeskCNT extends GenericController
{
	public UtilityGenerationDeskCNT() 
    {
    	super(new UtilityGenerationDeskUTL(),"/transactions/UtilityGenerationDeskCNT");
    }
	/**
	 * Add method  
	 * is used to forward control to add page Controller
	 * with mode "FIRSTDATA"
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward ADD(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		generateToken(request);
		ActionForward acFwd = new ActionForward();
	    acFwd.setPath("/mms/transactions/UtilityGenerationTransCNT.cnt?hmode=unspecified");
	    acFwd.setContextRelative(true);
        return acFwd;
        
    }
	
	/**
	 * Add method  
	 * is used to forward control to add page Controller
	 * with mode "FIRSTDATA"
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	/*public ActionForward MODIFY(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		ActionForward acFwd = new ActionForward();
		String[] Temp = request.getParameterValues("combo");
		String[] arr  = Temp[2].split("\\^");
	    String cmb  = arr[0];	  

		if(cmb.equals("86")) // Condemnation Request (Non-Consumable Items)
		{
					acFwd.setPath("/mms/transactions/RoutinePurchaseCNT.cnt?hmode=MODIFY");
		}	
	    acFwd.setContextRelative(true);
        return acFwd;
        
    }*/
	
	public ActionForward MODIFY(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		ActionForward acFwd = new ActionForward();
		request.setAttribute("Path","IndentTransCNT.cnt");
		acFwd.setPath("/mms/transactions/IndentViewTransCNT.cnt?hmode=MODIFY");
        acFwd.setContextRelative(true);
        return acFwd;
        
    }
	
	
	/**
	 * View method  
	 * is used to forward control to view page Controller
	 * with mode "INDENTDATA"
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward VIEW(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		ActionForward acFwd = new ActionForward();
		request.setAttribute("Path","IndentTransCNT.cnt");
		acFwd.setPath("/mms/transactions/IndentViewTransCNT.cnt?hmode=INDENTDATA");
        acFwd.setContextRelative(true);
        return acFwd;
        
    }
	
	/**
	 * View method  
	 * is used to forward control to view page Controller
	 * with mode "INDENTDATA"
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward RETURN(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		ActionForward acFwd = new ActionForward();
		request.setAttribute("Path","IndentTransCNT.cnt");
		acFwd.setPath("/mms/transactions/IndentReturnTransCNT.cnt?hmode=INDENTDATA");
	    acFwd.setContextRelative(true);
        return acFwd;
        
    }
	/**
	 * View method  
	 * is used to forward control to view page Controller
	 * with mode "INDENTDATA"
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward PRINT(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		//System.out.println("reached to print.........");
		ActionForward acFwd = new ActionForward();
		request.setAttribute("Path","IndentTransCNT.cnt");
		acFwd.setPath("/mms/transactions/UtilityGenerationTransCNT.cnt?hmode=PRINT");
	    acFwd.setContextRelative(true);
        return acFwd;
        
    }
	
		
	
	




}
