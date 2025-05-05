package mms.transactions.controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;
import mms.transactions.controller.data.DiscrepancyReportData;
import mms.transactions.controller.data.IndentSuperApprovalTransDATA;
import mms.transactions.controller.fb.IndentSuperApprovalTransFB;
import mms.transactions.controller.utl.IndentSuperApprovalTransUTL;

public class IndentSuperApprovalTransCNT extends GenericController
{
	public IndentSuperApprovalTransCNT() 
    {
    	super(new IndentSuperApprovalTransUTL(),"/transactions/IndentSuperApprovalTransCNT");
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
	public ActionForward APPROVAL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		generateToken(request);
		String strtarget = "";
		String path    = "";
	    IndentSuperApprovalTransFB formBean = (IndentSuperApprovalTransFB)form;
	    String strChk  = "";
	   
	    if(request.getParameter("strChk") == null)
		{
	    	
	    	strChk = request.getParameter("chk");
		}
	    else
	    {
	    	
	    	strChk = request.getParameter("strChk");
	    }	
	    
	    if(request.getParameter("cnt_page") == null)
		{
			path = request.getParameter("strPath");
		}
	    else
	    {
	    	path = "/mms"+request.getParameter("cnt_page")+".cnt";
	    }	
		formBean.setStrPath(path.trim());
	    formBean.setStrChk(strChk);
		String[] temp       = strChk.split("\\@");
		String[] temp1      = temp[5].split("\\$");
		String strReqTypeId = temp1[0];
		formBean.setStrReqTypeId(strReqTypeId);
		if(strReqTypeId.equals("64")||strReqTypeId.equals("47")||strReqTypeId.equals("61")||strReqTypeId.equals("65")||strReqTypeId.equals("15")||strReqTypeId.equals("16")||strReqTypeId.equals("17")||strReqTypeId.equals("18")||strReqTypeId.equals("10")||strReqTypeId.equals("11")||strReqTypeId.equals("12")||strReqTypeId.equals("13")||strReqTypeId.equals("14") || strReqTypeId.equals("19")||strReqTypeId.equals("80")||strReqTypeId.equals("81")||strReqTypeId.equals("82")||strReqTypeId.equals("86")||strReqTypeId.equals("85")||strReqTypeId.equals("84")||strReqTypeId.equals("83")||strReqTypeId.equals("90"))
		{
			System.out.println("------IndentSuperApprovalTranCNT.APPROVAL------- [ IndentSuperApproval_Trans_mms.jsp ] -------------");
			
			strtarget = "indentSuperApprovalDesk";
			IndentSuperApprovalTransDATA.ApprovedRecord(request, formBean);
		}
		
		return mapping.findForward(strtarget);
	 }
	/**
	 * View method  
	 * is used to forward control to view page Controller
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward VIEW(ActionMapping mapping
            ,ActionForm form
            ,HttpServletRequest request
            ,HttpServletResponse response)throws HisException, SQLException, IOException
   {
		generateToken(request);
     String strTarget = "";
     IndentSuperApprovalTransFB formBean = (IndentSuperApprovalTransFB) form;
        String   strChk     = request.getParameter("chk");
		String[] temp       = strChk.split("\\@");
		String[] temp1      = temp[5].split("\\$");
		String strReqTypeId = temp1[0];
		formBean.setStrReqTypeId(strReqTypeId);
		formBean.setStrChk(request.getParameter("chk"));
        String path = "/mms"+request.getParameter("cnt_page")+".cnt";
        formBean.setStrPath(path.trim());
        
        String[]      Temp = request.getParameterValues("combo"); // 0 - To Be Approved , 1- Approved , 2- Rejected
		String   appStatus = Temp[1];
	          
     if(strReqTypeId.equals("64")||strReqTypeId.equals("19")||strReqTypeId.equals("47")||strReqTypeId.equals("61")||strReqTypeId.equals("65")||strReqTypeId.equals("15")||strReqTypeId.equals("16")||strReqTypeId.equals("17")||strReqTypeId.equals("18")||strReqTypeId.equals("10")||strReqTypeId.equals("11")||strReqTypeId.equals("12")||strReqTypeId.equals("13")||strReqTypeId.equals("14")||strReqTypeId.equals("80")||strReqTypeId.equals("81")||strReqTypeId.equals("82")||strReqTypeId.equals("85")||strReqTypeId.equals("84")||strReqTypeId.equals("83")||strReqTypeId.equals("86")||strReqTypeId.equals("90"))
	 {
    	 if(appStatus.equals("0"))
    	 {
    		strTarget = "view";
     	    System.out.println("------IndentSuperApprovalTranCNT.APPROVAL------- [ IndentSuperApproval_View_Trans_mms.jsp ] -------------");
 			IndentSuperApprovalTransDATA.viewData(formBean,request);
    	 }	 
    	 else
    	 {	 
    	    strTarget = "appview";
    	    System.out.println("------IndentSuperApprovalTranCNT.APPROVAL------- [ IndentSuperApproval_AfterAppView_Trans_mms.jsp ] -------------");
			IndentSuperApprovalTransDATA.viewData(formBean,request);
    	 }
	 }	
     
     return mapping.findForward(strTarget);
    }
	
	/**
	 * This method is INSERT ON save button
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * 
	 */
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
        validateToken(request, response);
		IndentSuperApprovalTransFB formBean = (IndentSuperApprovalTransFB) form;
		String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
		formBean.setStrPath(path.trim());
		
		boolean retValue = false;	
	   	retValue =  IndentSuperApprovalTransDATA.insertDetails(formBean, request);
	      
	    if (retValue)
	    	return this.CANCEL(mapping, form, request, response);
		else
			return this.APPROVAL(mapping, form, request, response);
		
	}
   
	
	/**
	 * This method is INSERT IN save button
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * 
	 */
	public ActionForward INSERTPHYSICALSTOCK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
        
		IndentSuperApprovalTransFB formBean = (IndentSuperApprovalTransFB) form;
		String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
		formBean.setStrPath(path.trim());
		
		boolean retValue = false;	
	   	retValue =  IndentSuperApprovalTransDATA.insertDataPhysicalStockVerification(formBean,request);
	      
	    if (retValue)
	    	return this.CANCEL(mapping, form, request, response);
		else
			return this.APPROVAL(mapping, form, request, response);
		
		//IndentSuperApprovalTransDATA.insertDataPhysicalStockVerification(formBean,request);
		//return this.CANCEL(mapping, form, request, response);
	}
	
	/**
	 * APPROVALPRINT - gets the issue details view used for ajax.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward APPROVALPRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		IndentSuperApprovalTransFB formBean = (IndentSuperApprovalTransFB) form;
        System.out.println("-----------IndentSuperApprovalTranCNT . APPROVALPRINT [ Approval Voucher ]--------------");
        IndentSuperApprovalTransDATA.indentAppPrint(request, response, formBean);

		return null;
	}
	
	/**
	 * To get Blocked Item Details on the basis of
	 *  HSTNUM_ITEM_ID,HSTNUM_STORE_ID,HSTNUM_ITEMBRAND_ID
        HSTNUM_TRANS_NO,HSTSTR_BATCH_SL_NO,HSTSTR_ITEM_SL_NO 
        HSTNUM_STOCK_STATUS_CODE,GNUM_HOSPITAL_CODE       
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return   
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward BLOCKEDITEMDTL(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException 
	{
		IndentSuperApprovalTransFB formBean = (IndentSuperApprovalTransFB) form;
		IndentSuperApprovalTransDATA.getBlockedItemDtl(formBean, request,response);
		return null;

	}
	
	
	public ActionForward NONDISCREPANCYREPORT(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException 
	{
		DiscrepancyReportData.getNonDiscrepancyReport(request, response);
		return null;

	}
	
	
	public ActionForward BATCHWISEDTL(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException 
	{
		
		DiscrepancyReportData.getBatchWiseDtl(request, response);
		return null;

	}
	
	public ActionForward CANCELTODESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
	{	
		
		return this.CANCEL(mapping, form, request, response);
	}
}
