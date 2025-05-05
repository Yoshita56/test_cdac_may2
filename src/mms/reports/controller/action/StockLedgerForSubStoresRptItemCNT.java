/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         StockLedgerForSubStoresRptCNT.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.StockLedgerForSubStoresRptItemDATA;
import mms.reports.controller.fb.StockLedgerForSubStoresRptItemFB;

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
public class StockLedgerForSubStoresRptItemCNT extends DispatchAction {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts.actions.DispatchAction#unspecified(org.apache.struts
	 * .action.ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
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
		StockLedgerForSubStoresRptItemFB formBean = (StockLedgerForSubStoresRptItemFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		StockLedgerForSubStoresRptItemDATA.getInitVal(formBean, request, response);
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

		StockLedgerForSubStoresRptItemFB formBean = (StockLedgerForSubStoresRptItemFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		StockLedgerForSubStoresRptItemDATA.getItemCatList(formBean, request,
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

		StockLedgerForSubStoresRptItemFB formBean = (StockLedgerForSubStoresRptItemFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		StockLedgerForSubStoresRptItemDATA
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

		StockLedgerForSubStoresRptItemFB formBean = (StockLedgerForSubStoresRptItemFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		StockLedgerForSubStoresRptItemDATA.getItemList(formBean, request, response);
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
		StockLedgerForSubStoresRptItemFB fb = (StockLedgerForSubStoresRptItemFB) form;
		StockLedgerForSubStoresRptItemDATA.getStockLedgerDtl(fb, request, response);
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

		StockLedgerForSubStoresRptItemFB formBean = (StockLedgerForSubStoresRptItemFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		StockLedgerForSubStoresRptItemDATA.getDrugList(formBean, request, response);
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

		StockLedgerForSubStoresRptItemFB formBean = (StockLedgerForSubStoresRptItemFB) form;
		StockLedgerForSubStoresRptItemDATA.getConsolidatedStockLedgerReport(formBean,
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

		StockLedgerForSubStoresRptItemFB formBean = (StockLedgerForSubStoresRptItemFB) form;
		StockLedgerForSubStoresRptItemDATA.getDetailedStockLedger(formBean,
				request, response);
		return null;

		// String target = "view";
		// return mapping.findForward(target);
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

		StockLedgerForSubStoresRptItemFB formBean = (StockLedgerForSubStoresRptItemFB) form;
		StockLedgerForSubStoresRptItemDATA.getDetailedStockLedgerDtlRpt(formBean,
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
		StockLedgerForSubStoresRptItemFB fb = (StockLedgerForSubStoresRptItemFB) form;
		StockLedgerForSubStoresRptItemDATA.generatePdf(fb, request, response);
		return null;
	}
}
