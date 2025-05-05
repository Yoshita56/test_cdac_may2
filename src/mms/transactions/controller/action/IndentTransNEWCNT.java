
package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.IndentTransDATA;
import mms.transactions.controller.fb.IndentTransFB;

/**
 * @author Amit Kumar
 * Date of Creation : 24/05/2023
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
public class IndentTransNEWCNT extends CSRFGardTokenAction
{
	/*
	public IndentTransNEWCNT() 
    {
    	super(new IndentTransUTL(),"/transactions/IndentTransNEWCNT");
    }
    */
	/**
	 * unspecified	
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
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException 
	{
		generateToken(request);
		return this.LIST(mapping, form, request, response);

    }
	
	/**
	 * LIST 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	
			
	public ActionForward LIST(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws HisException, SQLException
	{
		generateToken(request);
		System.out.println("-------------IndentTransNEWCNT . LIST -- [ listPage_central_IndentDesk.jsp  ]----------------");
		String target = "central_indent_list";		
		IndentTransFB formBean = (IndentTransFB) form;
		IndentTransDATA.getListPageCombo(formBean,request,response);		
		return mapping.findForward(target);
	}
	
	/**
	 * This method used to get Item Category Combo
	 * for Indent Issue Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward CATG_COMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		IndentTransFB formBean = (IndentTransFB) form;
		IndentTransDATA.ItemCatgoryCombo(request,response,formBean);
		return null;

	}
	
	/**
	 * This method used to get ReqTypeCombo Combo
	 * for Indent Issue Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward REQ_TYPE_COMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		IndentTransFB formBean = (IndentTransFB) form;
		IndentTransDATA.ReqTypeCombo(request,response,formBean);
		return null;

	}
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	
	public ActionForward GET_LIST_DATA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		IndentTransFB formBean = (IndentTransFB) form;
		IndentTransDATA.getList_HLP(formBean,request,response);	
		return null; 
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
	public ActionForward ADD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		generateToken(request);		
		IndentTransFB formBean = (IndentTransFB) form;
	    String cmb      = formBean.getStrRequestTypeId().split("\\^")[1];
	    /*
	    System.out.println("-----formBean.getStrReqTypeId()--"+formBean.getStrRequestTypeId());
	    System.out.println("-----formBean.getStrCrNo()--"+formBean.getStrCrNo());
	    System.out.println("-----formBean.getStrItemCatgNo()--"+formBean.getStrItemCatgNo());
	    System.out.println("----------- IndentTransNEWCNT . ADD  -------------Cmb--"+cmb);
	    */
	    ActionForward acFwd = new ActionForward();
	  
	    try
	    {

		    if(cmb.equals("17")) // Indent For Issue 
		    {
		    	System.out.println("--[17]--------- /mms/transactions/IndentTransADDBSCNT.cnt?hmode=INDENT_FOR_DEPT  ---------------");
		    	acFwd.setPath("/mms/transactions/IndentTransADDBSCNT.cnt?hmode=INDENT_FOR_DEPT");
		    }
		    else
			if(cmb.equals("90")) // Indent For LP /Annual Purchase 
			{
				System.out.println("--[90]--------- /mms/transactions/AnnualPurchaseIndentBSCNT.cnt?hmode=GO_NEW  ---------------");
			    acFwd.setPath("/mms/transactions/AnnualPurchaseIndentBSCNT.cnt?hmode=GO_NEW");
			}	
			else
			if(cmb.equals("5")) // Indent For LP(Staff) --Not used
			{
				System.out.println("--[5]--------- /mms/transactions/RequestForLPStaffBSCNT.cnt?hmode=GO  ---------------");
				acFwd.setPath("/mms/transactions/RequestForLPStaffBSCNT.cnt?hmode=GO");
			}	
			else
			if(cmb.equals("13")||cmb.equals("86")) // Indent For LP(Patient) || Buy & Supply Indent
			{
				//System.out.println("--[13 || 86]--------- /mms/transactions/RequestForLPPatientBSCNT.cnt?hmode=GO  ---------------");
				System.out.println("--[13 || 86]--------- /mms/transactions/IssueToPatIndentCNT.cnt?hmode=GO_NEW  ---------------");
				//acFwd.setPath("/mms/transactions/RequestForLPPatientBSCNT.cnt?hmode=GO");
				acFwd.setPath("/mms/transactions/IssueToPatIndentCNT.cnt?hmode=GO_NEW");
			}
			else
			if(cmb.equals("11")) // Indent For LP(Dept) -Not in used
			{
				System.out.println("--[11]--------- /mms/transactions/RequestForLPDeptBSCNT.cnt?hmode=GO_NEW  ---------------");
					acFwd.setPath("/mms/transactions/RequestForLPDeptBSCNT.cnt?hmode=GO_NEW");
			}
			else
			if(cmb.equals("18")) // Contigency Purchase(Return Request)-Not in used
			{
				System.out.println("--[18]--------- /mms/transactions/ReturnRequestTransBSCNT.cnt?hmode=GO_NEW  ---------------");
					acFwd.setPath("/mms/transactions/ReturnRequestTransBSCNT.cnt?hmode=GO_NEW");
			}	
			else
			if(cmb.equals("23")) // Indent For LP /Annual Purchase 
			{
				System.out.println("--[ 23 ]--------- NA Certificate Issue  ---------------");		   
		    	acFwd.setPath("/mms/transactions/IndentTransADDBSCNT.cnt?hmode=INDENT_FOR_DEPT");
			}		   
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	    acFwd.setContextRelative(true);
        return acFwd;
        
    }
	
	/**
	 * MODIFY method  
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
	 * RETURN method  
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
	 * PRINT method  
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
	 * REMOVE
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
	/**
	 * PLACEREGULARINDENT
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
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
