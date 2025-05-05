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
public class IndentTransCNT extends GenericController
{
	public IndentTransCNT() 
    {
		
    	super(new IndentTransUTL(),"/transactions/IndentTransCNT");
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
		//System.out.println("chk for value for indent");
		generateToken(request);
		ActionForward acFwd = new ActionForward();
		String[] Temp = request.getParameterValues("combo");
		String[] arr  = Temp[2].split("\\^");
	    String cmb  = arr[0];
	  
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
	    	System.out.println("-- IndentTransCNT.IndentTransADDCNT --");
	    	acFwd.setPath("/mms/transactions/IndentTransADDCNT.cnt?hmode=FIRSTDATA");
	    	//acFwd.setPath("/mms/transactions/IndentTransADDBSCNT.cnt?hmode=FIRSTDATA");
	    }
	    else
		if(cmb.equals("4") || cmb.equals("90")) // Indent For LP /Annual Purchase 
		{
			System.out.println("-- IndentTransCNT.AnnualPurchaseIndentCNT --");
		    acFwd.setPath("/mms/transactions/AnnualPurchaseIndentCNT.cnt?hmode=GO");
		}	
		else
		if(cmb.equals("5")) // Indent For LP(Staff) --Not used
		{
			System.out.println("-- IndentTransCNT.RequestForLPStaffCNT --");
			acFwd.setPath("/mms/transactions/RequestForLPStaffCNT.cnt?hmode=GO");
		}	
		else
		if(cmb.equals("6")||cmb.equals("86")) // Indent For LP(Patient) || Buy & Supply Indent
		{
			System.out.println("-- IndentTransCNT.RequestForLPPatientCNT --");
			acFwd.setPath("/mms/transactions/RequestForLPPatientCNT.cnt?hmode=GO");
		}
		else
		if(cmb.equals("7")) // Indent For LP(Dept) -Not in used
		{
			System.out.println("-- IndentTransCNT.RequestForLPDeptCNT --");
			acFwd.setPath("/mms/transactions/RequestForLPDeptCNT.cnt?hmode=GO");
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
			System.out.println("------------IndentTransCNT.ReturnRequestTransCNT.6----------------");
				acFwd.setPath("/mms/transactions/ReturnRequestTransCNT.cnt?hmode=GO");
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
//		String[] s = request.getParameterValues("chk");
//		for(int i=0;i<s.length;i++)
//		{
//			//System.out.println(" In Cnt Chk-->"+i+"==>>"+s[i]);			
//		}
		///hisglobal/initPage.jsp
		//System.out.println("reached to print.........");
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
	  
	    if(cmb.equals("4")) // Indent for BS (Dept)
	    {	
		   acFwd.setPath("/mms/transactions/IndentTransADDCNT.cnt?hmode=PLACEREGULARINDENT");
	    }
	    else
	    if(cmb.equals("86")) //  Indent for BS (Patient)
	    {
	       	
	    	acFwd.setPath("/mms/transactions/RequestForLPPatientCNT.cnt?hmode=PLACEREGULARINDENT");
	    }
		request.setAttribute("Path","IndentTransCNT.cnt");
        acFwd.setContextRelative(true);
        return acFwd;
        
    }



}
