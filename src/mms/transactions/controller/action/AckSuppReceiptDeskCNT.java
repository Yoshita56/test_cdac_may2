package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.fb.AckSuppReceiptDeskFB;
import mms.transactions.controller.utl.AckSuppReceiptDeskUTL;


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
public class AckSuppReceiptDeskCNT extends GenericController
{
	public AckSuppReceiptDeskCNT() 
    {
    	super(new AckSuppReceiptDeskUTL(),"/transactions/AckSuppReceiptDeskCNT");
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
		String str="";
		generateToken(request);
		ActionForward acFwd = new ActionForward();
		AckSuppReceiptDeskFB formBean = (AckSuppReceiptDeskFB) _form;
		String[] Temp = request.getParameterValues("combo");
		formBean.setStrStoreId(Temp[0]);
		formBean.setStrReqTypeId(Temp[1]);
		formBean.setCombo(Temp);
		str=formBean.getComboValue();
		System.out.println("-- AckSuppReceiptDeskCNT -> AckSuppReceiptCNT -> unspecified");
	    acFwd.setPath("/mms/transactions/AckSuppReceiptCNT.cnt?hmode=unspecified&strType="+Temp[1]+"&strStoreName="+str+"&storeId="+Temp[0]); 
	    acFwd.setContextRelative(true);
        return acFwd;
        
    }
	

	public ActionForward MODIFY(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		System.out.println("-- AckSuppReceiptDeskCNT -> AckSuppReceiptCNT -> MODIFY");
		
		ActionForward acFwd = new ActionForward();
		request.setAttribute("Path","AckSuppReceiptCNT.cnt");
		acFwd.setPath("/mms/transactions/AckSuppReceiptCNT.cnt?hmode=MODIFY");
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
	public ActionForward REJECT(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		System.out.println("-- AckSuppReceiptDeskCNT -> AckSuppReceiptCNT -> REJECT");
		
		String str="";
		generateToken(request);
		ActionForward acFwd = new ActionForward();
		AckSuppReceiptDeskFB formBean = (AckSuppReceiptDeskFB) _form;
		String[] Temp = request.getParameterValues("combo");
		formBean.setStrStoreId(Temp[0]);
		formBean.setStrReqTypeId(Temp[1]);
		formBean.setCombo(Temp);
		str=formBean.getComboValue();
	    acFwd.setPath("/mms/transactions/AckSuppReceiptCNT.cnt?hmode=REJECT&strType="+Temp[1]+"&strStoreName="+str+"&storeId="+Temp[0]); 
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
		System.out.println("-- AckSuppReceiptDeskCNT -> IndentViewTransCNT -> INDENTDATA");
		
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
	 * @returnLocalPurchaseTransCNT
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward PRINT(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		System.out.println("-- AckSuppReceiptDeskCNT -> AckSuppReceiptCNT -> PRINT");

		//System.out.println("reached to print.........");
		ActionForward acFwd = new ActionForward();
		request.setAttribute("Path","AckSuppReceiptCNT.cnt");
		acFwd.setPath("/mms/transactions/AckSuppReceiptCNT.cnt?hmode=PRINT");
	    acFwd.setContextRelative(true);
        return acFwd;
        
    }
	
		
	
	




}
