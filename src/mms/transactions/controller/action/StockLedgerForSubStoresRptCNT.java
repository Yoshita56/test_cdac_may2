/**********************************************************
 Project:	   DWH_PHSC	
 File:         StockLedgerForSubStoresRptCNT.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.StockLedgerForSubStoresRptDATA;
import mms.reports.controller.fb.StockLedgerForSubStoresRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

// TODO: Auto-generated Javadoc
/**
 * Developer : Vivek Aggarwal Version : 1.0 Date : 16-Mar-2012 Modification
 * Date:
 * 
 */
public class StockLedgerForSubStoresRptCNT extends DispatchAction {

	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.STORECMB(mapping, form, request, response);

	}

	/**
	 * Storecmb.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward STORECMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		String strTarget = "index";
		StockLedgerForSubStoresRptFB formBean = (StockLedgerForSubStoresRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StockLedgerForSubStoresRptDATA.getInitVal(formBean, request, response);
		return mapping.findForward(strTarget);
	}

	/**
	 * Itemcatcmb.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		StockLedgerForSubStoresRptFB formBean = (StockLedgerForSubStoresRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		StockLedgerForSubStoresRptDATA.getItemCatList(formBean, request,
				response);
		return null;
	}

	/**
	 * Groupcmb.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward GROUPCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		StockLedgerForSubStoresRptFB formBean = (StockLedgerForSubStoresRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		StockLedgerForSubStoresRptDATA
				.getGroupList(formBean, request, response);
		return null;
	}

	/**
	 * Itemcmb.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward ITEMCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		StockLedgerForSubStoresRptFB formBean = (StockLedgerForSubStoresRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		StockLedgerForSubStoresRptDATA.getItemList(formBean, request, response);
		return null;
	}

	/**
	 * Unspecified Method Use to Transfer the Control Over Action FIRSTDATA.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the stock ledger dtl
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward getStockLedgerDtl(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException, IOException, ServletException {
		StockLedgerForSubStoresRptFB fb = (StockLedgerForSubStoresRptFB) form;
		StockLedgerForSubStoresRptDATA.getStockLedgerDtl(fb, request, response);
		return null;
	}

	/**
	 * Cancel.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 */
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}

	/**
	 * Drugname.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward DRUGNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		StockLedgerForSubStoresRptFB formBean = (StockLedgerForSubStoresRptFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StockLedgerForSubStoresRptDATA.getDrugList(formBean, request, response);
		return null;
	}

	/**
	 * To get View Details data.
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
	 * @throws Exception
	 *             the exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward getConsolidatedStockLedgerRpt(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception, SQLException {

		StockLedgerForSubStoresRptFB formBean = (StockLedgerForSubStoresRptFB) form;
		StockLedgerForSubStoresRptDATA.getConsolidatedStockLedgerReport(formBean,
				request, response);
		return null;

	}

	/**
	 * To get Detailed Stock Ledger Dtl.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws Exception
	 *             the exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward getDetailedStockLedgerDtl(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception, SQLException {

		StockLedgerForSubStoresRptFB formBean = (StockLedgerForSubStoresRptFB) form;
		StockLedgerForSubStoresRptDATA.getDetailedStockLedger(formBean, request, response);
		return null;

	}

	/**
	 * To get Detailed Stock Ledger Dtl.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws Exception
	 *             the exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward printDetailedStockLedgerReport(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception, SQLException {

		StockLedgerForSubStoresRptFB formBean = (StockLedgerForSubStoresRptFB) form;
		StockLedgerForSubStoresRptDATA.getDetailedStockLedgerDtlRpt(formBean,
				request, response);
		return null;
	}

	/**
	 * Generatepdf.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward generatePdf(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {
		StockLedgerForSubStoresRptFB fb = (StockLedgerForSubStoresRptFB) form;
		StockLedgerForSubStoresRptDATA.generatePdf(fb, request, response);
		return null;
	}
}
