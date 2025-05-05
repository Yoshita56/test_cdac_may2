package mms.transactions.controller.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.google.gson.Gson;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;
import mms.transactions.controller.data.IssueDeskPrintTransDATA;
import mms.transactions.controller.fb.IssueDeskPrintTransFB;
import mms.transactions.controller.fb.MessageObjects;
import mms.transactions.controller.utl.IssueDeskPrintTransUTL;

//public class IssueDeskPrintTransCNT extends CSRFGardTokenAction
public class IssueDeskPrintTransCNT extends GenericController
{
   /*
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException 
	{
		generateToken(request);
		return this.LIST(mapping, form, request, response);

    }
    */
	
	
	  public IssueDeskPrintTransCNT() { 
		  super(new IssueDeskPrintTransUTL(),
	  "/transactions/IssueDeskPrintTransCNT"); 
		  }
	
	 

	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	
	  /*
	public ActionForward LIST(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
			throws HisException, SQLException
	{
		generateToken(request);
		String target = "list_page";		
		IssueDeskPrintTransFB formBean = (IssueDeskPrintTransFB) form;
		IssueDeskPrintTransDATA.getListPageCombo(formBean,request,response);		
		return mapping.findForward(target);
	}
	*/
	
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
		IssueDeskPrintTransFB formBean = (IssueDeskPrintTransFB) form;
		IssueDeskPrintTransDATA.getList_HLP(formBean,request,response);	
		return null; 
	}
	
	/**
	 * This method used to get Drug List for Indent Issue Transaction.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 * @throws IOException
	 */
   
	public ActionForward HLP_JSON(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException 
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try
		{
					
			ArrayList<MessageObjects> messagesData = null;			
			Gson gson = new Gson();
			IssueDeskPrintTransFB formBean = (IssueDeskPrintTransFB) form;
			messagesData = IssueDeskPrintTransDATA.getHLP_JSON(formBean, request, response);
			
			System.out.println("messagesData->>"+messagesData);
			String messages = gson.toJson(messagesData);
			System.out.println("messages->>"+messages);
			out.println("{\"Messages\":"+messages+"}");
			
		
		}
		catch (Exception ex)
		{
		out.println("Error: " + ex.getMessage());
		}
		finally
		{
		out.close();
		}
		
		
		return null;
	}
	
	
	public ActionForward  RETURNTOMAINDESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws HisException, SQLException 
	{
		
		return this.LIST(mapping, form, request, response);
	}
	
	
	public ActionForward ISSUEVIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		ActionForward acFwd = new ActionForward();
			    
	    System.out.println("-------------  IssueDeskPrintTransCNT . ISSUEVIEW  ----[view_IssueDeskIndentPrintTrans.jsp]----------");
	    	
		IssueDeskPrintTransFB formBean = (IssueDeskPrintTransFB) form;

		IssueDeskPrintTransDATA.getPatientIndentView(formBean, request);
		
		String strtarget = "viewIssue";
		return mapping.findForward(strtarget);
		

	}
	
	public ActionForward ISSUEDTLSINIT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		IssueDeskPrintTransFB formBean = (IssueDeskPrintTransFB) form;
        System.out.println("-----------IssueDeskPrintTransCNT . ISSUEDTLSINIT [ After Save Issue Voucher ]--------------");
        IssueDeskPrintTransDATA.getPatientIndentVoucher(request, response, formBean);

		return null;
	}
	
	public ActionForward INDENT_VIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
	
	    System.out.println("-------------  IssueDeskPrintTransCNT . INDENT_VIEW  -----[ view_IssueDeskPrintTrans.jsp ]---------");
		
		IssueDeskPrintTransFB formBean = (IssueDeskPrintTransFB) form;
		IssueDeskPrintTransDATA.indent_ViewDataBS(formBean, request);
		String strtarget = "viewIndent";
		return mapping.findForward(strtarget);
		

	}
	
	
	/**
	 * This method is used to cancel the Process.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	/**
	 * This method is used to FORWARD CONTROL ON A CNT FOR VIEW PAGE.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward VIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//System.out.println(" Inside 2");
		ActionForward acFwd = new ActionForward();
		
		 System.out.println("-------------  IssueDeskPrintTransCNT . VIEW  --------------");
		 
		 System.out.println("-------------  /mms/transactions/IssueViewDetailsCNT.cnt?hmode=init  --------------");
		 
		acFwd.setPath("/mms/transactions/IssueViewDetailsCNT.cnt?hmode=init");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public void PRINT(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		 System.out.println("-------------  IssueDeskPrintTransCNT . PRINT  --------------");
		IssueDeskPrintTransFB formBean = (IssueDeskPrintTransFB)_form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		IssueDeskPrintTransDATA.showReport(formBean, request, response);
		
        
    }
	
	


}