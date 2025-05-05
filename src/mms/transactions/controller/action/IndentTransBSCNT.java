package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.IndentTransDATA;
import mms.transactions.controller.fb.IndentTransFB;
import mms.transactions.controller.utl.IndentTransUTL;

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
public class IndentTransBSCNT extends GenericController
{
	public IndentTransBSCNT() 
    {
    	super(new IndentTransUTL(),"/transactions/IndentTransBSCNT");
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
		String[] Temp   = request.getParameterValues("combo");  // 0 - Store Combo , 1 - Category , 2 - Request Type , 3 - Status 
		String[] arr    = Temp[2].split("\\^");
	    String cmb      = arr[0];
	    String reqType  = arr[1];
	    
	    System.out.println("----------- IndentTransBSCNT . ADD  ---------------");
	  
//	    if(cmb.equals("1")) // Indent for Purchase (Imported Items) -Not used
//	    {	
//		   acFwd.setPath("/mms/transactions/IndentForImportItemsCNT.cnt?hmode=INIT");
//	    }
//	    else
//	    if(cmb.equals("2")) // Indent for Condemnation -Not used
//	    {
//	       	
//	       acFwd.setPath("/mms/transactions/IndentDeskCondemnationReqTransCNT.cnt?hmode=FIRSTDATA");
//	    }
//	    else
//	    if(cmb.equals("8")) // Indent for Contigency --Not used
//	    {
//	    	acFwd.setPath("/mms/transactions/RequestForContigencyCNT.cnt?hmode=GO");
//	    }
//	    else
	    if(cmb.equals("3")) // Indent For Issue 
	    {
	    	System.out.println("--[3]--------- /mms/transactions/IndentTransADDBSCNT.cnt?hmode=FIRSTDATA  ---------------");
	    	acFwd.setPath("/mms/transactions/IndentTransADDBSCNT.cnt?hmode=FIRSTDATA");
	    }
	    else
		if(cmb.equals("4") || cmb.equals("90")) // Indent For LP /Annual Purchase 
		{
			System.out.println("--[4 || 90]--------- /mms/transactions/AnnualPurchaseIndentBSCNT.cnt?hmode=GO  ---------------");
		    acFwd.setPath("/mms/transactions/AnnualPurchaseIndentBSCNT.cnt?hmode=GO");
		}	
		else
		if(cmb.equals("5")) // Indent For LP(Staff) --Not used
		{
			System.out.println("--[5]--------- /mms/transactions/RequestForLPStaffBSCNT.cnt?hmode=GO  ---------------");
			acFwd.setPath("/mms/transactions/RequestForLPStaffBSCNT.cnt?hmode=GO");
		}	
		else
		if(cmb.equals("6")||cmb.equals("86")) // Indent For LP(Patient) || Buy & Supply Indent
		{
			System.out.println("--[6 || 86]--------- /mms/transactions/RequestForLPPatientBSCNT.cnt?hmode=GO  ---------------");
			acFwd.setPath("/mms/transactions/RequestForLPPatientBSCNT.cnt?hmode=GO");
		}
		else
		if(cmb.equals("7")) // Indent For LP(Dept) -Not in used
		{
			System.out.println("--[7]--------- /mms/transactions/RequestForLPDeptBSCNT.cnt?hmode=GO  ---------------");
				acFwd.setPath("/mms/transactions/RequestForLPDeptBSCNT.cnt?hmode=GO");
		}
//		else
//		if(cmb.equals("9")) // Local Purchase -Not in used
//		{
//				acFwd.setPath("/mms/transactions/IndentTransADDCNT.cnt?hmode=FIRSTDATA");
//		}	
//		else
//		if(cmb.equals("10")) // Annual Purchase -Not in used
//		{
//				acFwd.setPath("/mms/transactions/AnnualPurchaseIndentCNT.cnt?hmode=GO");
//		}
		else
		if(cmb.equals("12")) // Contigency Purchase(Return Request)-Not in used
		{
			System.out.println("--[12]--------- /mms/transactions/ReturnRequestTransBSCNT.cnt?hmode=GO  ---------------");
				acFwd.setPath("/mms/transactions/ReturnRequestTransBSCNT.cnt?hmode=GO");
		}	
		else
		if(reqType.equals("23")) // Indent For LP /Annual Purchase 
		{
			System.out.println("--[ 23 ]--------- NA Certificate Issue  ---------------");		   
	    	acFwd.setPath("/mms/transactions/IndentTransADDBSCNT.cnt?hmode=FIRSTDATA");
		}	
	   
//	    
//		else
//		if(cmb.equals("71")) // Condemnation Request (Non-Consumable Items) -Not in used
//		{
//					acFwd.setPath("/mms/transactions/CondemnationRequestForNonConsumTransCNT.cnt?hmode=FIRSTDATA");
//		}	
		//else
		//if(cmb.equals("86")) // Routine Purchase Used in DWH Demad Creation
		//{
		//			acFwd.setPath("/mms/transactions/RoutinePurchaseCNT.cnt?hmode=GO");
		//}	
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
		System.out.println("----------- IndentTransBSCNT . MODIFY  ---------------");
		
		System.out.println("----------- /mms/transactions/IndentViewTransBSCNT.cnt?hmode=MODIFY  ---------------");
		
		request.setAttribute("Path","IndentTransBSCNT.cnt");
		acFwd.setPath("/mms/transactions/IndentViewTransBSCNT.cnt?hmode=MODIFY");
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
		System.out.println("----------- IndentTransBSCNT . VIEW  ---------------");
		
		System.out.println("----------- /mms/transactions/IndentViewTransBSCNT.cnt?hmode=INDENTDATA  ---------------");
		
		ActionForward acFwd = new ActionForward();
		request.setAttribute("Path","IndentTransBSCNT.cnt");
		acFwd.setPath("/mms/transactions/IndentViewTransBSCNT.cnt?hmode=INDENTDATA");
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
		System.out.println("----------- IndentTransBSCNT . RETURN  ---------------");
		
		ActionForward acFwd = new ActionForward();
		request.setAttribute("Path","IndentTransCNT.cnt");
		
		System.out.println("----------- /mms/transactions/IndentReturnTransCNT.cnt?hmode=INDENTDATA  ---------------");
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
		System.out.println("----------- IndentTransBSCNT . PRINT  ---------------");
		
		System.out.println("----------- /mms/transactions/IndentPrintTransCNT.cnt?hmode=PRINT  ---------------");
		ActionForward acFwd = new ActionForward();
		request.setAttribute("Path","IndentTransCNT.cnt");
		acFwd.setPath("/mms/transactions/IndentPrintTransCNT.cnt?hmode=PRINT");
	    acFwd.setContextRelative(true);
        return acFwd;
        
    }
	
		
	/**
	 * is used to forward control to modify page
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward REMOVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
			boolean retValue = false;
			
			System.out.println("----------- IndentTransBSCNT . REMOVE  ---------------");
			
			IndentTransFB formBean = (IndentTransFB) form;
			formBean.setStrChk(request.getParameter("chk"));
			retValue = IndentTransDATA.CancelRecord(request, formBean);
			if (retValue)
			{	
				return this.LIST(mapping, form, request, response);
			}	
			else
			{	
				return this.LIST(mapping, form, request, response);
			}	
		
		
	}
	
	public ActionForward PLACEREGULARINDENT(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		ActionForward acFwd = new ActionForward();
		String[] Temp = request.getParameterValues("combo");
		String[] arr  = Temp[2].split("\\^");
	    String cmb  = arr[0];
	    
	    System.out.println("----------- IndentTransBSCNT . PLACEREGULARINDENT  ---------------");
	  
	    if(cmb.equals("4")) // Indent for BS (Dept)
	    {	
	       System.out.println("----------- /mms/transactions/IndentTransADDCNT.cnt?hmode=PLACEREGULARINDENT  ---------------");
	    	
		   acFwd.setPath("/mms/transactions/IndentTransADDCNT.cnt?hmode=PLACEREGULARINDENT");
	    }
	    else
	    if(cmb.equals("86")) //  Indent for BS (Patient)
	    {
	    	System.out.println("----------- /mms/transactions/RequestForLPPatientCNT.cnt?hmode=PLACEREGULARINDENT  ---------------");
	    	
	    	acFwd.setPath("/mms/transactions/RequestForLPPatientCNT.cnt?hmode=PLACEREGULARINDENT");
	    }
		request.setAttribute("Path","IndentTransCNT.cnt");
        acFwd.setContextRelative(true);
        return acFwd;
        
    }



}
