package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.StockLedgerRptDATA;
import mms.reports.controller.fb.StockLedgerRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * Developer : Vivek Aggarwal
 * Version : 1.0
 * Date : 16-Mar-2012
 * Modification Date: 
 *  
*/
public class StockLedgerRptCNT extends DispatchAction{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.STORECMB(mapping, form, request, response);
		
	}
	
	public ActionForward STORECMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		

		String strTarget = "index";
		StockLedgerRptFB formBean = (StockLedgerRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockLedgerRptDATA.getInitVal(formBean,request, response);
		return mapping.findForward(strTarget);
	}
	
	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StockLedgerRptFB formBean = (StockLedgerRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		StockLedgerRptDATA.getItemCatList(formBean,request, response);
		return null;
	}
	
	public ActionForward GROUPCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StockLedgerRptFB formBean = (StockLedgerRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		StockLedgerRptDATA.getGroupList(formBean,request, response);
		return null;
	}
	
	public ActionForward ITEMCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StockLedgerRptFB formBean = (StockLedgerRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		StockLedgerRptDATA.getItemList(formBean,request, response);
		return null;
	}
	
	
	/**
	 * Unspecified Method Use to Transfer the Control Over Action FIRSTDATA.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	public ActionForward getStockLedgerDtl(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		
		StockLedgerRptFB fb = (StockLedgerRptFB) form;
		StockLedgerRptDATA.getStockLedgerDtl(fb, request,response);
	   	return null;
	}
	
	
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
	    ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	
	/**
	 * To get View Details data.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws Exception the exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward GETVIEWPAGE(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
	{

		StockLedgerRptFB formBean = (StockLedgerRptFB) form;
		StockLedgerRptDATA.getStockLedgerDtlPopUp(formBean, request,response);
		return null;
		
		/*String target = "view";
		return mapping.findForward(target);*/
	}

	/**
	 * To get Detailed Stock Ledger Dtl
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws Exception the exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward getDetailedStockLedgerDtl(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
	{

		StockLedgerRptFB formBean = (StockLedgerRptFB) form;
		StockLedgerRptDATA.getDetailedStockLedger(formBean, request,response);
		return null;
		
//		String target = "view";
//		return mapping.findForward(target);
	}
	
	/**
	 * To get Detailed Stock Ledger Dtl
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws Exception the exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward printDetailedStockLedgerReport(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
	{

		StockLedgerRptFB formBean = (StockLedgerRptFB) form;
		StockLedgerRptDATA.getDetailedStockLedgerDtlPopUp(formBean, request,response);
		return null;
		
//		String target = "view";
//		return mapping.findForward(target);
	}
	
}
