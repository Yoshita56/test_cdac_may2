package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.fb.LocalPurchaseDeskFB;
import mms.transactions.controller.utl.LocalPurchaseDeskUTL;

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
public class LocalPurchaseDeskCNT extends GenericController
{
	public LocalPurchaseDeskCNT() 
    {
    	super(new LocalPurchaseDeskUTL(),"/transactions/LocalPurchaseDeskCNT");
    }
	/**
	 * Add method  
	 * is used to forward control to add page Controller
	 * with mode "ADD"
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
		String str="";
		generateToken(request);
		ActionForward acFwd = new ActionForward();
		LocalPurchaseDeskFB formBean = (LocalPurchaseDeskFB) _form;
		String[] Temp = request.getParameterValues("combo");
		formBean.setStrStoreId(Temp[0]);
		formBean.setStrReqTypeId(Temp[1]);
		formBean.setCombo(Temp);
		str=formBean.getComboValue();
	    acFwd.setPath("/mms/transactions/LocalPurchaseNewTransCNT.cnt?hmode=unspecified&strType="+Temp[1]+"&strStoreName="+str+"&storeId="+Temp[0]); 
	    acFwd.setContextRelative(true);
        return acFwd;
        
    }
	/**
	 * View method  
	 * is used to forward control to view page Controller
	 * with mode "PRINT"
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @returnLocalPurchaseTransCNT
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward PRINT(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		//System.out.println("reached to print.........");
		ActionForward acFwd = new ActionForward();
		request.setAttribute("Path","LocalPurchaseNewTransCNT.cnt");
		acFwd.setPath("/mms/transactions/LocalPurchaseNewTransCNT.cnt?hmode=PRINT");
	    acFwd.setContextRelative(true);
        return acFwd;
        
    }
	
		
	
	




}
