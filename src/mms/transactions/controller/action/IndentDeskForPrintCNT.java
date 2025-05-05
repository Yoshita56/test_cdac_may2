package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;
import mms.transactions.controller.utl.IndentDeskForPrintUTL;

/**
 * @author Amit Kumar
 * Date of Creation : 31/3/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
public class IndentDeskForPrintCNT extends GenericController
{
	public IndentDeskForPrintCNT() 
    {
		
    	super(new IndentDeskForPrintUTL(),"/transactions/IndentDeskForPrintCNT");
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
		request.setAttribute("Path","IndentDeskForPrintCNT.cnt");
		acFwd.setPath("/mms/transactions/IndentViewTransBSCNT.cnt?hmode=INDENTDATA");
        acFwd.setContextRelative(true);
        return acFwd;
        
    }
	
	



}
