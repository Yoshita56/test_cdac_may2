package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.DiscrepancyReportData;
import mms.transactions.controller.data.IndentApprovalDeskBSDATA;
import mms.transactions.controller.fb.IndentApprovalDeskFB;
import mms.transactions.controller.utl.IndentApprovalDeskUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 1/June/2009
 * Modif Date : 17/March /2010 
*/

public class IndentApprovalDeskBSCNT extends GenericController
{
	public IndentApprovalDeskBSCNT() 
    {
    	super(new IndentApprovalDeskUTL(),"/transactions/IndentApprovalDeskBSCNT");
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
	    IndentApprovalDeskFB formBean = (IndentApprovalDeskFB)form;
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
			strtarget = "indentApprovalDesk";
			IndentApprovalDeskBSDATA.ApprovedRecord(request, formBean);
		}
		else
		{	
			strtarget = "indentApprovalDeskPhysicalStockVerification";
			IndentApprovalDeskBSDATA.ApprovedRecord1(request, formBean);
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
     IndentApprovalDeskFB formBean = (IndentApprovalDeskFB) form;
        String   strChk     = request.getParameter("chk");
		String[] temp       = strChk.split("\\@");
		String[] temp1      = temp[5].split("\\$");
		String strReqTypeId = temp1[0];
		formBean.setStrReqTypeId(strReqTypeId);
		formBean.setStrChk(request.getParameter("chk"));
        String path = "/mms"+request.getParameter("cnt_page")+".cnt";
        formBean.setStrPath(path.trim());
        
     if(strReqTypeId.equals("64")||strReqTypeId.equals("19")||strReqTypeId.equals("47")||strReqTypeId.equals("61")||strReqTypeId.equals("65")||strReqTypeId.equals("15")||strReqTypeId.equals("16")||strReqTypeId.equals("17")||strReqTypeId.equals("18")||strReqTypeId.equals("10")||strReqTypeId.equals("11")||strReqTypeId.equals("12")||strReqTypeId.equals("13")||strReqTypeId.equals("14")||strReqTypeId.equals("80")||strReqTypeId.equals("81")||strReqTypeId.equals("82")||strReqTypeId.equals("85")||strReqTypeId.equals("84")||strReqTypeId.equals("83")||strReqTypeId.equals("86")||strReqTypeId.equals("90"))
	 {
    	    strTarget = "view";
			IndentApprovalDeskBSDATA.viewData(formBean,request);
	 }
	 else
	 {	
		    strTarget = "viewPhysicalStockVerification";
			IndentApprovalDeskBSDATA.viewDataPhysicalStockVerification(formBean,request);
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
		IndentApprovalDeskFB formBean = (IndentApprovalDeskFB) form;
		String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
		formBean.setStrPath(path.trim());
		
		boolean retValue = false;	
	   	retValue =  IndentApprovalDeskBSDATA.insertDetails(formBean, request);
	      
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
        
		IndentApprovalDeskFB formBean = (IndentApprovalDeskFB) form;
		String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
		formBean.setStrPath(path.trim());
		
		boolean retValue = false;	
	   	retValue =  IndentApprovalDeskBSDATA.insertDataPhysicalStockVerification(formBean,request);
	      
	    if (retValue)
	    	return this.CANCEL(mapping, form, request, response);
		else
			return this.APPROVAL(mapping, form, request, response);
		
		//IndentApprovalDeskBSDATA.insertDataPhysicalStockVerification(formBean,request);
		//return this.CANCEL(mapping, form, request, response);
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
		IndentApprovalDeskFB formBean = (IndentApprovalDeskFB) form;
		IndentApprovalDeskBSDATA.getBlockedItemDtl(formBean, request,response);
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
	
/*	public ActionForward CERTIFICATE(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException 
	{
		
		IndentApprovalDeskBSDATA.genCertificate(request, response);
		return null;

	}*/
}
