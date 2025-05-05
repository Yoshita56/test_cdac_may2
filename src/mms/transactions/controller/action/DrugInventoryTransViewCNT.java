package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.fb.DrugInventoryViewTransFB;
import mms.transactions.controller.utl.DrugInventoryTransViewUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * 
 * Developer : Amit Kr
 * Version : 1.0 
 * Date : 12-Jun-2009
 * 
 */
public class DrugInventoryTransViewCNT extends GenericController {

	String strtarget;

	/**
	 * calls super class constructor
	 */

	public DrugInventoryTransViewCNT() 
	{
		super(new DrugInventoryTransViewUTL(),"/transactions/DrugInventoryTransViewCNT");

	}
    
	/**
	 * forwards control to the ADD page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward ADD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		DrugInventoryViewTransFB fb = (DrugInventoryViewTransFB) form;

		
		// Type and Group Type
		// Name on next page
		// according to the selected
		
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		 String strTarget="";
		
		strtarget = "add";
		
		return mapping.findForward(strtarget);

	}
	

}
