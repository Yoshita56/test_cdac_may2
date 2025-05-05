/**********************************************************
 Project:	   INVMGM	
 File:         StockLedgerForSubStoresRptHLP.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.controller.hlp;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import hisglobal.utility.HisUtil;
import mms.reports.vo.StockLedgerForSubStoresRptItemNewVO;

/**
 * Developer : Vivek Aggarwal Version : 1.0 Date : 16-Mar-2012 Modification Date:
 * 
 */
public class StockLedgerForSubStoresRptItemNewHLP 
{
	
	/*
	 * Value Pass in Web Row Set 1 HSTNUM_MONTH, 2 HSTNUM_YEAR, 3 HSTNUM_STORE_ID, 4 HSTNUM_ITEMBRAND_ID, 5 STR_NAME, 6 ITEM_NAME, 7 BATCH_NO, 8
	 * HSTSTR_ACTIVE_OPBALANCE_QTY, 9 HSTSTR_QUAR_OPBALANCE_QTY, 10 HSTSTR_REJ_OPBALANCE_QTY, 11 HSTSTR_ISSUEQTY_DAY1, 12 HSTSTR_RECQTY_DAY1, 13
	 * HSTSTR_ISSUEQTY_DAY2, 14 HSTSTR_RECQTY_DAY2, 15 HSTSTR_ISSUEQTY_DAY3, 16 HSTSTR_RECQTY_DAY3, 17 HSTSTR_ISSUEQTY_DAY4, 18 HSTSTR_RECQTY_DAY4, 19
	 * HSTSTR_ISSUEQTY_DAY5, 20 HSTSTR_RECQTY_DAY5, 21 HSTSTR_ISSUEQTY_DAY6, 22 HSTSTR_RECQTY_DAY6, 23 HSTSTR_ISSUEQTY_DAY7, 24 HSTSTR_RECQTY_DAY7, 25
	 * HSTSTR_ISSUEQTY_DAY8, 26 HSTSTR_RECQTY_DAY8, 27 HSTSTR_ISSUEQTY_DAY9, 28 HSTSTR_RECQTY_DAY9, 29 HSTSTR_ISSUEQTY_DAY10, 30 HSTSTR_RECQTY_DAY10,
	 * 31 HSTSTR_ISSUEQTY_DAY11, 32 HSTSTR_RECQTY_DAY11, 33 HSTSTR_ISSUEQTY_DAY12, 34 HSTSTR_RECQTY_DAY12, 35 HSTSTR_ISSUEQTY_DAY13, 36
	 * HSTSTR_RECQTY_DAY13, 37 HSTSTR_ISSUEQTY_DAY14, 38 HSTSTR_RECQTY_DAY14, 39 HSTSTR_ISSUEQTY_DAY15, 40 HSTSTR_RECQTY_DAY15, 41
	 * HSTSTR_ISSUEQTY_DAY16, 42 HSTSTR_RECQTY_DAY16, 43 HSTSTR_ISSUEQTY_DAY17, 44 HSTSTR_RECQTY_DAY17, 45 HSTSTR_ISSUEQTY_DAY18, 46
	 * HSTSTR_RECQTY_DAY18, 47 HSTSTR_ISSUEQTY_DAY19, 48 HSTSTR_RECQTY_DAY19, 49 HSTSTR_ISSUEQTY_DAY20, 50 HSTSTR_RECQTY_DAY20, 51
	 * HSTSTR_ISSUEQTY_DAY21, 52 HSTSTR_RECQTY_DAY21, 53 HSTSTR_ISSUEQTY_DAY22, 54 HSTSTR_RECQTY_DAY22, 55 HSTSTR_ISSUEQTY_DAY23, 56
	 * HSTSTR_RECQTY_DAY23, 57 HSTSTR_ISSUEQTY_DAY24, 58 HSTSTR_RECQTY_DAY24, 59 HSTSTR_ISSUEQTY_DAY25, 60 HSTSTR_RECQTY_DAY25, 61
	 * HSTSTR_ISSUEQTY_DAY26, 62 HSTSTR_RECQTY_DAY26, 63 HSTSTR_ISSUEQTY_DAY27, 64 HSTSTR_RECQTY_DAY27, 65 HSTSTR_ISSUEQTY_DAY28, 66
	 * HSTSTR_RECQTY_DAY28, 67 HSTSTR_ISSUEQTY_DAY29, 68 HSTSTR_RECQTY_DAY29, 69 HSTSTR_ISSUEQTY_DAY30, 70 HSTSTR_RECQTY_DAY30, 71
	 * HSTSTR_ISSUEQTY_DAY31, 72 HSTSTR_RECQTY_DAY31, 73 HSTSTR_TOTAL_ACTIVE_ISSUEQTY, 74 HSTSTR_TOTAL_QUAR_ISSUEQTY, 75 HSTSTR_TOTAL_REJ_ISSUEQTY, 76
	 * HSTSTR_TOTAL_ACTIVE_RECQTY, 77 HSTSTR_TOTAL_QUAR_RECQTY, 78 HSTSTR_TOTAL_REJ_RECQTY 79 EXPIRY DATE
	 */
	/**
	 * Gets the stock ledger dtl.
	 * 
	 * @param vo the vo
	 * @param request 
	 * @return the stock ledger dtl
	 * @throws Exception the exception
	 */
	public String getStockLedgerDtl(StockLedgerForSubStoresRptItemNewVO vo, HttpServletRequest request) throws Exception {
		StringBuffer br = new StringBuffer(1000);
		StringBuffer brPagination = new StringBuffer(3000);

		WebRowSet ws = null;

		String prevItemId = "";
		String prevItemName = "";
		String strFromDate = "";
		String strToDate = "";
		String strCheckHidValue = "";

		final int REC_PER_PAGE = 100;
		String strCssClass = "multiRPTControl";

		int nFromDay = 0;
		int nToDay = 0;
		int nFromMonth = 0;
		int nToMonth = 0;
		int nFromYear = 0;
		int nToYear = 0;

		int counter = 0;
		int pageCounter = 0;
		int pageSize = 1;
		int sNo = 1;

		long nOpeningBalanceActive = 0L;
		long nClosingBalanceActive = 0L;
		long nIssueActive = 0L;
		long nRecActive = 0L;
		long nOpeningBalanceTotActive = 0L;
		long nClosingBalanceTotActive = 0L;
		long nIssueTotActive = 0L;
		long nRecTotActive = 0L;
		long totIssueRecQty = 0L;

		try {
			ws = vo.getWrsData();

			br.append(getHeader(1).toString());

			strFromDate = vo.getStrFromDate();
			strToDate = vo.getStrToDate();

			nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
			nToDay = Integer.parseInt(strToDate.split("\\-")[0]);

			nFromMonth = getMonthInNumbers(strFromDate.split("\\-")[1]);
			nToMonth = getMonthInNumbers(strToDate.split("\\-")[1]);

			nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
			nToYear = Integer.parseInt(strToDate.split("\\-")[2]);

			if (ws != null && ws.size() > 0) {

				while (ws.next()) 
				{
					/*
				    1.OP Date
					2.Store Id
					3.Brand Id
					4.Store Name
					5.Item Name
					6.Batch No
					7.Op Balance Qty
					8.Issue Qty
					9.Rec Qty
				   10.Exp_date
				   11.Rate
				   12.OP_Bal_Value
				   13.Issue_Value
				   14.Rec_Value	  
				*/
					
					if (!prevItemId.equals(ws.getString(3)) && counter > 0) 
					{
						if ((sNo) % 2 == 0) {
							strCssClass = "multiRPTControl";
						} else {
							strCssClass = "multiRPTControl1";
						}

						strCheckHidValue = prevItemId + "^0^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
						nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;

						if (pageCounter == REC_PER_PAGE) {
							pageSize++;
							pageCounter = 0;
						}

						if (pageSize == 1) {
							br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
						} else {
							br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
						}

						// br.append("<tr>");
						br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");

						br.append("<td class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");

						br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='30%'>"
								+ "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' "
								+ "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceActive
								+ "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecActive + "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueActive + "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceActive
								+ "</td>");

						totIssueRecQty = nRecActive +  nIssueActive ;
						br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");

						br.append("</tr>");

						// grand total
						nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;
						nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;
						nIssueTotActive = nIssueTotActive + nIssueActive;
						nRecTotActive = nRecTotActive + nRecActive;

						// reset
						nOpeningBalanceActive = 0L;
						nClosingBalanceActive = 0L;
						nIssueActive = 0L;
						nRecActive = 0L;
						pageCounter++;
						sNo++;
					}

						nOpeningBalanceActive = nOpeningBalanceActive + Long.parseLong(ws.getString(7));
						nIssueActive = nIssueActive + Long.parseLong(ws.getString(8));
						nRecActive = nRecActive + Long.parseLong(ws.getString(9));

					prevItemId = ws.getString(3);
					prevItemName = ws.getString(5);
					counter++;
				}

				// last row
				if ((sNo) % 2 == 0) {
					strCssClass = "multiRPTControl";
				} else {
					strCssClass = "multiRPTControl1";
				}

				strCheckHidValue = prevItemId + "^0^" + nOpeningBalanceActive + "^0^0";
				nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
				

				if (pageCounter == REC_PER_PAGE) {
					pageSize++;
					pageCounter = 0;
				}

				if (pageSize == 1) {
					br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
				} else {
					br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
				}

				// br.append("<tr>");
				br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");

				br.append("<td class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");

				br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='30%'>"
						+ "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' "
						+ "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceActive + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecActive + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueActive + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceActive + "</td>");

				totIssueRecQty = nRecActive + nIssueActive;
				br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");

				br.append("</tr>");

				// grand total
				nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;

				nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;

				nIssueTotActive = nIssueTotActive + nIssueActive;

				nRecTotActive = nRecTotActive + nRecActive;
				

				// grand total
				pageCounter = pageCounter + 1;

				if (pageSize == 1) {
					br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
				} else {
					br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
				}

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='2' width='35%'><b>Grand Total </b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nOpeningBalanceTotActive
						+ "</b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nRecTotActive + "</b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nIssueTotActive + "</b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nClosingBalanceTotActive
						+ "</b></td>");
				br.append("</tr>");

				brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
				brPagination.append("<tr><td colspan='14' class='TITLE' style='color:#000'>Stock Ledger </td></tr>");

				brPagination.append("<tr>");
				brPagination.append("<td class='LABEL' colspan='14'>");

				for (int i = 0; i < pageSize; i++) {
					if (i == 0) {
						brPagination.append("<a name='pg' id='pg" + (i + 1)
								+ "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-selected' title='Record Indexing'" + " onClick='GetIndex(\""
								+ (i + 1) + "\",\"" + REC_PER_PAGE + "\")'>" + String.valueOf(i + 1) + "</a>|&nbsp;");
					} else {
						brPagination.append("<a name='pg' id='pg" + (i + 1)
								+ "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing'" + " onClick='GetIndex(\""
								+ (i + 1) + "\",\"" + REC_PER_PAGE + "\")'>" + String.valueOf(i + 1) + "</a>|&nbsp;");
					}

				}
				brPagination.append("</td></tr>");
				brPagination.append(br);
				brPagination.append("</table>");

			} else {
				// no data found code here
				brPagination.append("<table width='95%' align='center' cellspacing='1px' cellpadding='1px'>");
				brPagination.append("<tr><td colspan='14' class='TITLE'>Stock Ledger</td></tr>");
				brPagination.append("<tr><td colspan='14' align='center'><Strong>Data Not Found</Strong></td></tr>");
				brPagination.append("</table>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("StockLedgerForSubStoresRptItemNewHLP.getStockLedgerDtl()->" + e.getMessage());
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}

		return brPagination.toString();

	}
	
	
	
	
	public StringBuffer getHeader_valuewise(int callType) 
	{
		StringBuffer brHeader = new StringBuffer(1000);

		// consolidated stock
		if (callType == 1) 
		{
			// 13 - Column
			brHeader.append("<tr>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='4%'>S. No.</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='30%'>Item Name</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Rate</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Batch No</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Exp Date</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Opening Balance</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Value</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Received Qty</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Value</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Issued Qty</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Value</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Closing Balance</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Value</td>");
			brHeader.append("</tr>");
			
		}
		if (callType == 2) 
		{
			brHeader.append("<tr>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>S. No.</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='31%'>Item Name</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Opening Balance</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Value</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Received Qty</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Value</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Issued Qty</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Value</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Closing Balance</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Value</td>");
			brHeader.append("</tr>");
		}
		if (callType == 3) 
		{
			brHeader.append("<tr bgcolor='#cdc9c9'>");
			brHeader.append("<td  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S. No.</b></font></td>");
			brHeader.append("<td  colspan='1' width='31%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font></td>");
			brHeader.append("<td  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Opening Balance</b></font></td>");
			brHeader.append("<td  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Value</b></font></td>");
			brHeader.append("<td  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty</b></font></td>");
			brHeader.append("<td  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Value</b></font></td>");
			brHeader.append("<td  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty</b></font></td>");
			brHeader.append("<td  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Value</b></font></td>");
			brHeader.append("<td  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Closing Balance</b></font></td>");
			brHeader.append("<td  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Value</b></font></td>");
			brHeader.append("</tr>");
		}
		
		if (callType == 6) 
		{
			// 13 - Column
			brHeader.append("<tr bgcolor='#cdc9c9'>");
			brHeader.append("<td  colspan='1' width='4%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S. No.</b></font></td>");
			brHeader.append("<td  colspan='1' width='30%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font></td>");
			brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate</b></font></td>");
			brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No</b></font></td>");
			brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font></td>");
			brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Opening Balance</b></font></td>");
			brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Value</b></font></td>");
			brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty</b></font></td>");
			brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Value</b></font></td>");
			brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty</b></font></td>");
			brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Value</b></font></td>");
			brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Closing Balance</b></font></td>");
			brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Value</b></font></td>");
			brHeader.append("</tr>");

		}
		

		return brHeader;
	}	
	/**
	 * Gets the stock ledger dtl.
	 * 
	 * @param vo the vo
	 * @param request 
	 * @return the stock ledger dtl
	 * @throws Exception the exception
	 */
	public String getStockLedgerDtl_ValueWise(StockLedgerForSubStoresRptItemNewVO vo, HttpServletRequest request) throws Exception {
		StringBuffer br = new StringBuffer(1000);
		StringBuffer brPagination = new StringBuffer(3000);

		WebRowSet ws = null;

		String prevItemId = "";
		String prevItemName = "";
		String strFromDate = "";
		String strToDate = "";
		String strCheckHidValue = "";

		final int REC_PER_PAGE = 100;
		String strCssClass = "multiRPTControl";

		int nFromDay = 0;
		int nToDay = 0;
		int nFromMonth = 0;
		int nToMonth = 0;
		int nFromYear = 0;
		int nToYear = 0;

		int counter = 0;
		int pageCounter = 0;
		int pageSize = 1;
		int sNo = 1;
         
		double nRate = 0L;
		
		long nOpeningBalanceActive = 0L;
		double nOpeningBalanceActiveValue = 0L;
		long nClosingBalanceActive = 0L;
		double nClosingBalanceActiveValue = 0L;
		long nIssueActive = 0L;
		double nIssueActiveValue = 0L;
		long nRecActive = 0L;
		double nRecActiveValue = 0L;
		long nOpeningBalanceTotActive = 0L;
		double nOpeningBalanceTotActiveValue = 0L;
		long nClosingBalanceTotActive = 0L;
		double nClosingBalanceTotActiveValue = 0L;
		long nIssueTotActive = 0L;
		double nIssueTotActiveValue = 0L;
		long nRecTotActive = 0L;
		double nRecTotActiveValue = 0L;
		long totIssueRecQty = 0L;
		double totIssueRecQtyValue = 0L;

		try {
			ws = vo.getWrsData();

			br.append(getHeader_valuewise(1).toString());

			strFromDate = vo.getStrFromDate();
			strToDate = vo.getStrToDate();

			nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
			nToDay = Integer.parseInt(strToDate.split("\\-")[0]);

			nFromMonth = getMonthInNumbers(strFromDate.split("\\-")[1]);
			nToMonth = getMonthInNumbers(strToDate.split("\\-")[1]);

			nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
			nToYear = Integer.parseInt(strToDate.split("\\-")[2]);
			
			DecimalFormat myFormatter = new DecimalFormat("0.00");

			if (ws != null && ws.size() > 0) {

				while (ws.next()) 
				{
					/*
				    1.OP Date
					2.Store Id
					3.Brand Id
					4.Store Name
					5.Item Name
					6.Batch No
					7.Op Balance Qty
					8.Issue Qty
					9.Rec Qty
				   10.Exp_date
				   11.Rate
				   12.OP_Bal_Value
				   13.Issue_Value
				   14.Rec_Value	  
				*/
					
					nRate = Double.parseDouble(ws.getString(11));
					
					if (!prevItemId.equals(ws.getString(3)) && counter > 0) 
					{
						if ((sNo) % 2 == 0) {
							strCssClass = "multiRPTControl";
						} else {
							strCssClass = "multiRPTControl1";
						}

						strCheckHidValue = prevItemId + "^0^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
						nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;

						if (pageCounter == REC_PER_PAGE) {
							pageSize++;
							pageCounter = 0;
						}

						if (pageSize == 1) {
							br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
						} else {
							br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
						}

						// br.append("<tr>");
						br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");

						br.append("<td class= " + strCssClass + " colspan='1' width='4%'>" + sNo + "</td>");

						br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='30%'>"
								+ "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' "
								+ "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");
						
						
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nRate
								+ "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nOpeningBalanceActive
								+ "</td>");
						
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nOpeningBalanceActiveValue
								+ "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nRecActive + "</td>");
						
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nRecActiveValue + "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nIssueActive + "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nIssueActiveValue + "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nClosingBalanceActive
								+ "</td>");
						
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nClosingBalanceActiveValue
								+ "</td>");

						totIssueRecQty = nRecActive +  nIssueActive ;
						
						
						br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");

						br.append("</tr>");

						// grand total
						nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;
						nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;
						nIssueTotActive = nIssueTotActive + nIssueActive;
						nRecTotActive = nRecTotActive + nRecActive;
						
						// grand total Value
						nOpeningBalanceTotActiveValue = nOpeningBalanceTotActiveValue + nOpeningBalanceActiveValue;
						nClosingBalanceTotActiveValue = nClosingBalanceTotActiveValue  + nClosingBalanceActiveValue;
						nIssueTotActiveValue = nIssueTotActiveValue + nIssueActiveValue;
						nRecTotActiveValue = nRecTotActiveValue + nRecActiveValue;

						// reset
						nOpeningBalanceActive = 0L;
						nClosingBalanceActive = 0L;
						nIssueActive = 0L;
						nRecActive = 0L;
						
						nOpeningBalanceActiveValue = 0L;
						nClosingBalanceActiveValue = 0L;
						nIssueActiveValue = 0L;
						nRecActiveValue = 0L;
						
						
						pageCounter++;
						sNo++;
					}

						nOpeningBalanceActive = nOpeningBalanceActive + Long.parseLong(ws.getString(7));
						nIssueActive = nIssueActive + Long.parseLong(ws.getString(8));
						nRecActive = nRecActive + Long.parseLong(ws.getString(9));
						
						// Batch Wise Value
						
						nOpeningBalanceActiveValue = nOpeningBalanceActiveValue + Double.parseDouble(ws.getString(12));
						nIssueActiveValue = nIssueActiveValue + Double.parseDouble(ws.getString(13));
						nRecActiveValue = nRecActiveValue + Double.parseDouble(ws.getString(14));

					prevItemId = ws.getString(3);
					prevItemName = ws.getString(5);
					       
					counter++;
				}

				// last row
				if ((sNo) % 2 == 0) {
					strCssClass = "multiRPTControl";
				} else {
					strCssClass = "multiRPTControl1";
				}

				strCheckHidValue = prevItemId + "^0^" + nOpeningBalanceActive + "^0^0";
				nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
				
				nClosingBalanceActiveValue = nOpeningBalanceActiveValue + nRecActiveValue - nIssueActiveValue;
				
				

				if (pageCounter == REC_PER_PAGE) {
					pageSize++;
					pageCounter = 0;
				}

				if (pageSize == 1) {
					br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
				} else {
					br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
				}

				// br.append("<tr>");
				br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");

				br.append("<td class= " + strCssClass + " colspan='1' width='4%'>" + sNo + "</td>");

				br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='30%'>"
						+ "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' "
						+ "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");
				
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nRate	+ "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nOpeningBalanceActive
						+ "</td>");
				
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nOpeningBalanceActiveValue
						+ "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nRecActive + "</td>");
				
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nRecActiveValue + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nIssueActive + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nIssueActiveValue + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nClosingBalanceActive
						+ "</td>");
				
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nClosingBalanceActiveValue
						+ "</td>");

				totIssueRecQty = nRecActive + nIssueActive;
				br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");

				br.append("</tr>");

				// grand total
				nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;

				nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;

				nIssueTotActive = nIssueTotActive + nIssueActive;

				nRecTotActive = nRecTotActive + nRecActive;
				
				
				// grand total Value
				nOpeningBalanceTotActiveValue = nOpeningBalanceTotActiveValue + nOpeningBalanceActiveValue;

				nClosingBalanceTotActiveValue = nClosingBalanceTotActiveValue + nClosingBalanceActiveValue;

				nIssueTotActiveValue = nIssueTotActiveValue + nIssueActiveValue;

				nRecTotActiveValue = nRecTotActiveValue + nRecActiveValue;
				

				// grand total
				pageCounter = pageCounter + 1;

				if (pageSize == 1) {
					br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
				} else {
					br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
				}

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='2' ><b>Grand Total </b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + nOpeningBalanceTotActive
						+ "</b></td>");
				
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + nOpeningBalanceTotActiveValue
						+ "</b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + nRecTotActive + "</b></td>");
				
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + nRecTotActiveValue + "</b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + nIssueTotActive + "</b></td>");
				
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + nIssueTotActiveValue + "</b></td>");


				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + nClosingBalanceTotActive
						+ "</b></td>");
				
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + nClosingBalanceTotActiveValue + "</b></td>");
				
				br.append("</tr>");				
				
				
				brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
				brPagination.append("<tr><td colspan='14' class='TITLE' style='color:#000'>Stock Ledger </td></tr>");

				brPagination.append("<tr>");
				brPagination.append("<td class='LABEL' colspan='14'>");

				for (int i = 0; i < pageSize; i++) {
					if (i == 0) {
						brPagination.append("<a name='pg' id='pg" + (i + 1)
								+ "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-selected' title='Record Indexing'" + " onClick='GetIndex(\""
								+ (i + 1) + "\",\"" + REC_PER_PAGE + "\")'>" + String.valueOf(i + 1) + "</a>|&nbsp;");
					} else {
						brPagination.append("<a name='pg' id='pg" + (i + 1)
								+ "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing'" + " onClick='GetIndex(\""
								+ (i + 1) + "\",\"" + REC_PER_PAGE + "\")'>" + String.valueOf(i + 1) + "</a>|&nbsp;");
					}

				}
				brPagination.append("</td></tr>");
				brPagination.append(br);
				brPagination.append("</table>");

			} else {
				// no data found code here
				brPagination.append("<table width='95%' align='center' cellspacing='1px' cellpadding='1px'>");
				brPagination.append("<tr><td colspan='14' class='TITLE'>Stock Ledger</td></tr>");
				brPagination.append("<tr><td colspan='14' align='center'><Strong>Data Not Found</Strong></td></tr>");
				brPagination.append("</table>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("StockLedgerForSubStoresRptItemNewHLP.getStockLedgerDtl()->" + e.getMessage());
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}

		return brPagination.toString();

	}

	/*
	 * Value Pass in Web Row Set 1 HSTNUM_MONTH, 2 HSTNUM_YEAR, 3 HSTNUM_STORE_ID, 4 HSTNUM_ITEMBRAND_ID, 5 STR_NAME, 6 ITEM_NAME, 7 BATCH_NO, 8
	 * HSTSTR_ACTIVE_OPBALANCE_QTY, 9 HSTSTR_QUAR_OPBALANCE_QTY, 10 HSTSTR_REJ_OPBALANCE_QTY, 11 HSTSTR_ISSUEQTY_DAY1, 12 HSTSTR_RECQTY_DAY1, 13
	 * HSTSTR_ISSUEQTY_DAY2, 14 HSTSTR_RECQTY_DAY2, 15 HSTSTR_ISSUEQTY_DAY3, 16 HSTSTR_RECQTY_DAY3, 17 HSTSTR_ISSUEQTY_DAY4, 18 HSTSTR_RECQTY_DAY4, 19
	 * HSTSTR_ISSUEQTY_DAY5, 20 HSTSTR_RECQTY_DAY5, 21 HSTSTR_ISSUEQTY_DAY6, 22 HSTSTR_RECQTY_DAY6, 23 HSTSTR_ISSUEQTY_DAY7, 24 HSTSTR_RECQTY_DAY7, 25
	 * HSTSTR_ISSUEQTY_DAY8, 26 HSTSTR_RECQTY_DAY8, 27 HSTSTR_ISSUEQTY_DAY9, 28 HSTSTR_RECQTY_DAY9, 29 HSTSTR_ISSUEQTY_DAY10, 30 HSTSTR_RECQTY_DAY10,
	 * 31 HSTSTR_ISSUEQTY_DAY11, 32 HSTSTR_RECQTY_DAY11, 33 HSTSTR_ISSUEQTY_DAY12, 34 HSTSTR_RECQTY_DAY12, 35 HSTSTR_ISSUEQTY_DAY13, 36
	 * HSTSTR_RECQTY_DAY13, 37 HSTSTR_ISSUEQTY_DAY14, 38 HSTSTR_RECQTY_DAY14, 39 HSTSTR_ISSUEQTY_DAY15, 40 HSTSTR_RECQTY_DAY15, 41
	 * HSTSTR_ISSUEQTY_DAY16, 42 HSTSTR_RECQTY_DAY16, 43 HSTSTR_ISSUEQTY_DAY17, 44 HSTSTR_RECQTY_DAY17, 45 HSTSTR_ISSUEQTY_DAY18, 46
	 * HSTSTR_RECQTY_DAY18, 47 HSTSTR_ISSUEQTY_DAY19, 48 HSTSTR_RECQTY_DAY19, 49 HSTSTR_ISSUEQTY_DAY20, 50 HSTSTR_RECQTY_DAY20, 51
	 * HSTSTR_ISSUEQTY_DAY21, 52 HSTSTR_RECQTY_DAY21, 53 HSTSTR_ISSUEQTY_DAY22, 54 HSTSTR_RECQTY_DAY22, 55 HSTSTR_ISSUEQTY_DAY23, 56
	 * HSTSTR_RECQTY_DAY23, 57 HSTSTR_ISSUEQTY_DAY24, 58 HSTSTR_RECQTY_DAY24, 59 HSTSTR_ISSUEQTY_DAY25, 60 HSTSTR_RECQTY_DAY25, 61
	 * HSTSTR_ISSUEQTY_DAY26, 62 HSTSTR_RECQTY_DAY26, 63 HSTSTR_ISSUEQTY_DAY27, 64 HSTSTR_RECQTY_DAY27, 65 HSTSTR_ISSUEQTY_DAY28, 66
	 * HSTSTR_RECQTY_DAY28, 67 HSTSTR_ISSUEQTY_DAY29, 68 HSTSTR_RECQTY_DAY29, 69 HSTSTR_ISSUEQTY_DAY30, 70 HSTSTR_RECQTY_DAY30, 71
	 * HSTSTR_ISSUEQTY_DAY31, 72 HSTSTR_RECQTY_DAY31, 73 HSTSTR_TOTAL_ACTIVE_ISSUEQTY, 74 HSTSTR_TOTAL_QUAR_ISSUEQTY, 75 HSTSTR_TOTAL_REJ_ISSUEQTY, 76
	 * HSTSTR_TOTAL_ACTIVE_RECQTY, 77 HSTSTR_TOTAL_QUAR_RECQTY, 78 HSTSTR_TOTAL_REJ_RECQTY 79 EXPIRY DATE
	 */
	// batch wise
	/**
	 * Gets the stock ledger dtl batch.
	 * 
	 * @param vo the vo
	 * @param request 
	 * @return the stock ledger dtl batch
	 * @throws Exception the exception
	 */
	public String getStockLedgerDtlBatch(StockLedgerForSubStoresRptItemNewVO vo, HttpServletRequest request) throws Exception {
		StringBuffer br = new StringBuffer(1000);
		StringBuffer brPagination = new StringBuffer(3000);

		WebRowSet ws = null;

		String prevItemId = "";
		String prevItemName = "";
		String prevBatch = "";
		String prevExpiry = "";

		String strFromDate = "";
		String strToDate = "";
		String strCheckHidValue = "";

		final int REC_PER_PAGE = 100;
		String strCssClass = "multiRPTControl";

		int nFromDay = 0;
		int nToDay = 0;
		int nFromMonth = 0;
		int nToMonth = 0;
		int nFromYear = 0;
		int nToYear = 0;

		int counter = 0;
		int pageCounter = 0;
		int pageSize = 1;
		int sNo = 1;

		long nOpeningBalanceActive = 0L;

		long nClosingBalanceActive = 0L;

		long nIssueActive = 0L;

		long nRecActive = 0L;

		long nOpeningBalanceTotActive = 0L;

		long nClosingBalanceTotActive = 0L;

		long nIssueTotActive = 0L;
		
		long nRecTotActive = 0L;

		long totIssueRecQty = 0L;

		try 
		{
			
			System.out.println("------------- StockLedgerForSubStoresRptItemNew.getStockLedgerDtlBatch() --------------");
			ws = vo.getWrsData();

			br.append(getHeader(2).toString());
			
			

			strFromDate = vo.getStrFromDate();
			strToDate 	= vo.getStrToDate();

			nFromDay 	= Integer.parseInt(strFromDate.split("\\-")[0]);
			nToDay 		= Integer.parseInt(strToDate.split("\\-")[0]);

			nFromMonth 	= getMonthInNumbers(strFromDate.split("\\-")[1]);
			nToMonth 	= getMonthInNumbers(strToDate.split("\\-")[1]);

			nFromYear 	= Integer.parseInt(strFromDate.split("\\-")[2]);
			nToYear		= Integer.parseInt(strToDate.split("\\-")[2]);

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
					if ((!prevItemId.equals(ws.getString(3)) || !prevBatch.equals(ws.getString(6))) && counter > 0) 
					{					
						if ((sNo) % 2 == 0) 
						{
							strCssClass = "multiRPTControl";
						} 
						else 
						{
							strCssClass = "multiRPTControl1";
						}

						strCheckHidValue =
								prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
						nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;

						if (pageCounter == REC_PER_PAGE) {
							pageSize++;
							pageCounter = 0;
						}

						if (pageSize == 1) {
							br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
						} else {
							br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
						}

						// br.append("<tr>");
						br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");

						br.append("<td class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");

						br.append("<td style=\"text-align: left;\"  class= " + strCssClass + " colspan='1' width='35%'>"
								+ "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' "
								+ "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");

						br.append("<td style=\"text-align: left;\"   class= " + strCssClass + " colspan='1' width='8%'>" + prevBatch + "</td>");
						br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='7%'>" + prevExpiry + "</td>");

						br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceActive
								+ "</td>");						

						br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + nRecActive + "</td>");

						br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + nIssueActive + "</td>");

						br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceActive
								+ "</td>");

						totIssueRecQty = nRecActive  + nIssueActive;

						br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
						br.append("</tr>");

						// grand total
						nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;
						
						nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;

						nIssueTotActive = nIssueTotActive + nIssueActive;

						nRecTotActive = nRecTotActive + nRecActive;

						// reset
						nOpeningBalanceActive = 0L;
						nClosingBalanceActive = 0L;
						nIssueActive = 0L;
						nRecActive = 0L;
						pageCounter++;
						sNo++;
					}

					nOpeningBalanceActive = nOpeningBalanceActive + Long.parseLong(ws.getString(7));
					nIssueActive = nIssueActive + Long.parseLong(ws.getString(8));
					nRecActive = nRecActive + Long.parseLong(ws.getString(9));

					prevItemId = ws.getString(3);
					prevItemName = ws.getString(5);
					prevBatch = ws.getString(6);
					prevExpiry = ws.getString(10);

					counter++;
				}

				// last row
				if ((sNo) % 2 == 0) {
					strCssClass = "multiRPTControl";
				} else {
					strCssClass = "multiRPTControl1";
				}

				strCheckHidValue = prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
				nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;

				if (pageCounter == REC_PER_PAGE) {
					pageSize++;
					pageCounter = 0;
				}

				if (pageSize == 1) {
					br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
				} else {
					br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
				}

				// br.append("<tr>");
				br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");

				br.append("<td class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");

				br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='35%'>"
						+ "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' "
						+ "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");

				br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='8%'>" + prevBatch + "</td>");
				br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='7%'>" + prevExpiry + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nOpeningBalanceActive + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nRecActive + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nIssueActive + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nClosingBalanceActive + "</td>");

				totIssueRecQty = nRecActive + nIssueActive;
				br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");

				br.append("</tr>");

				// grand total
				nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;

				nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;

				nIssueTotActive = nIssueTotActive + nIssueActive;

				nRecTotActive = nRecTotActive + nRecActive;

				// grand total
				pageCounter = pageCounter + 1;

				if (pageSize == 1) {
					br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
				} else {
					br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
				}

				// br.append("<tr>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='4' width='35%'><b>Grand Total</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + nOpeningBalanceTotActive
						+ "</b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + nRecTotActive + "</b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + nIssueTotActive + "</b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + nClosingBalanceTotActive
						+ "</b></td>");
				br.append("</tr>");

				brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
				brPagination.append("<tr><td colspan='16' class='TITLE'> Stock Ledger</td></tr>");

				brPagination.append("<tr>");
				brPagination.append("<td class='LABEL' colspan='16'>");

				for (int i = 0; i < pageSize; i++) {
					if (i == 0) {
						brPagination.append("<a name='pg' id='pg" + (i + 1)
								+ "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-selected' title='Record Indexing'" + " onClick='GetIndex(\""
								+ (i + 1) + "\",\"" + REC_PER_PAGE + "\")'>" + String.valueOf(i + 1) + "</a>|&nbsp;");
					} else {
						brPagination.append("<a name='pg' id='pg" + (i + 1)
								+ "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing'" + " onClick='GetIndex(\""
								+ (i + 1) + "\",\"" + REC_PER_PAGE + "\")'>" + String.valueOf(i + 1) + "</a>|&nbsp;");
					}

				}
				brPagination.append("</td></tr>");
				brPagination.append(br);
				brPagination.append("</table>");

			} else {
				// no data found code here
				brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
				brPagination.append("<tr><td class='TITLE'> Stock Ledger</td></tr>");
				brPagination.append("<tr><td align='center'><Strong>Data Not Found</Strong></td></tr>");
				brPagination.append("</table>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("StockLedgerForSubStoresRptItemNewHLP.getStockLedgerDtl()->" + e.getMessage());
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}

		return brPagination.toString();

	}
	
	/**
	 * Gets the stock ledger dtl.
	 * 
	 * @param vo the vo
	 * @param request 
	 * @return the stock ledger dtl
	 * @throws Exception the exception
	 */
	public String getStockLedgerDtl_ValueRpt(StockLedgerForSubStoresRptItemNewVO vo, HttpServletRequest request) throws Exception {
		StringBuffer br = new StringBuffer(1000);
		StringBuffer brPagination = new StringBuffer(3000);

		WebRowSet ws = null;

		String prevItemId = "";
		String prevItemName = "";
		String prevRate = "";
		String strFromDate = "";
		String strToDate = "";
		String strCheckHidValue = "";		

		final int REC_PER_PAGE = 100;
		String strCssClass = "multiRPTControl";

		int nFromDay = 0;
		int nToDay = 0;
		int nFromMonth = 0;
		int nToMonth = 0;
		int nFromYear = 0;
		int nToYear = 0;

		int counter = 0;
		int pageCounter = 0;
		int pageSize = 1;
		int sNo = 1;
        /*
		long nOpeningBalanceActive = 0L;
		long nClosingBalanceActive = 0L;
		long nIssueActive = 0L;
		long nRecActive = 0L;
		long nOpeningBalanceTotActive = 0L;
		long nClosingBalanceTotActive = 0L;
		long nIssueTotActive = 0L;
		long nRecTotActive = 0L;
		long totIssueRecQty = 0L;
		*/
		
		
        double nOpeningBalanceActive = 0L;
		
		double nOpeningBalanceActiveValue  = 0.00;

		double nClosingBalanceActive = 0L;
		
		double nClosingBalanceActiveValue  = 0.00;

		double nIssueActive = 0L;
		
		double nIssueActiveValue  = 0.00;

		double nRecActive = 0L;
		
		double nRecActiveValue  = 0.00;

		double nOpeningBalanceTotActive = 0L;
		
		double nOpeningBalanceTotActiveValue  = 0.00;

		double nClosingBalanceTotActive = 0L;
		
		double nClosingBalanceTotActiveValue  = 0.00;

		double nIssueTotActive = 0L;
		
		double nIssueTotActiveValue  = 0.00;
		
		double nRecTotActive = 0L;
		
		double nRecTotActiveValue  = 0.00;

		double totIssueRecQty = 0L;
		
		NumberFormat  formatter = new DecimalFormat("###############.##"); 
		String       issueValue ="0.00";
		String         recValue ="0.00";		
		HisUtil 		hisutil = new HisUtil("billing", "PrintHLP");

		try 
		{
			ws = vo.getWrsData();

			br.append(getHeader_valuewise(2).toString());

			strFromDate = vo.getStrFromDate();
			strToDate = vo.getStrToDate();

			nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
			nToDay = Integer.parseInt(strToDate.split("\\-")[0]);

			nFromMonth = getMonthInNumbers(strFromDate.split("\\-")[1]);
			nToMonth = getMonthInNumbers(strToDate.split("\\-")[1]);

			nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
			nToYear = Integer.parseInt(strToDate.split("\\-")[2]);

			if (ws != null && ws.size() > 0) {

				while (ws.next()) 
				{
					/*
				    1.OP Date
					2.Store Id
					3.Brand Id
					4.Store Name
					5.Item Name
					6.Batch No
					7.Op Balance Qty
					8.Issue Qty
					9.Rec Qty
				   10.Exp_date
				   11.Rate
				   12.OP_Bal_Value
				   13.Issue_Value
				   14.Rec_Value	  
				*/
					
					if (!prevItemId.equals(ws.getString(3)) && counter > 0) 
					{
						if ((sNo) % 2 == 0) {
							strCssClass = "multiRPTControl";
						} else {
							strCssClass = "multiRPTControl1";
						}

						strCheckHidValue = prevItemId + "^0^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
						nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;

						if (pageCounter == REC_PER_PAGE) {
							pageSize++;
							pageCounter = 0;
						}

						if (pageSize == 1) {
							br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
						} else {
							br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
						}

						// br.append("<tr>");
						br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");

						br.append("<td class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");

						br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='31%'>"
								+ "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' "
								+ "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nOpeningBalanceActive + "</td>");
						
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", (nOpeningBalanceActiveValue))+ "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nRecActive + "</td>");
						
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", (nRecActiveValue)) + "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nIssueActive + "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", (nIssueActiveValue)) + "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nClosingBalanceActive+ "</td>");
												
						br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", (nClosingBalanceActive*Double.parseDouble(prevRate)))
						+ "</td>");

						totIssueRecQty = nRecActive +  nIssueActive ;
						br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");

						br.append("</tr>");
                        /*
						// grand total
						nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;
						nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;
						nIssueTotActive = nIssueTotActive + nIssueActive;
						nRecTotActive = nRecTotActive + nRecActive;

						// reset
						nOpeningBalanceActive = 0L;
						nClosingBalanceActive = 0L;
						nIssueActive = 0L;
						nRecActive = 0L;
						*/
						
						// grand total Qty
						nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;
						
						nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;

						nIssueTotActive = nIssueTotActive + nIssueActive;

						nRecTotActive = nRecTotActive + nRecActive;
						
						// grand total of Value
						nOpeningBalanceTotActiveValue = nOpeningBalanceTotActiveValue + nOpeningBalanceActiveValue;
						
						nClosingBalanceTotActiveValue = nClosingBalanceTotActiveValue + nClosingBalanceActiveValue;

						nIssueTotActiveValue = nIssueTotActiveValue + nIssueActiveValue;

						nRecTotActiveValue = nRecTotActiveValue + nRecActiveValue;
						
						// reset
						nOpeningBalanceActive = 0L;
						nClosingBalanceActive = 0L;
						nIssueActive = 0L;
						nRecActive = 0L;
						//Re-Set
						nOpeningBalanceActiveValue = 0L;
						nClosingBalanceActiveValue = 0L;
						nIssueActiveValue = 0L;
						nRecActiveValue = 0L;
						
						
						pageCounter++;
						sNo++;
					}

						nOpeningBalanceActive = nOpeningBalanceActive + Long.parseLong(ws.getString(7));
						nIssueActive = nIssueActive + Long.parseLong(ws.getString(8));
						nRecActive = nRecActive + Long.parseLong(ws.getString(9));
						
						
						// grand total Value
						nOpeningBalanceActiveValue = nOpeningBalanceActiveValue + Double.parseDouble(ws.getString(12));					
						issueValue  =  formatter.format(new BigDecimal(ws.getString(13)));  
						recValue	=  formatter.format(new BigDecimal(ws.getString(14)));  						
						nIssueActiveValue = nIssueActiveValue + Double.parseDouble(issueValue);
						nRecActiveValue = nRecActiveValue + Double.parseDouble(recValue);


					prevItemId = ws.getString(3);
					prevItemName = ws.getString(5);
					prevRate   = ws.getString(11);
					
					
					String drugName = ws.getString(5);
					int strlength=  ws.getString(5).length();
					String opdrugName = "";
					
					if(strlength> 30)
					{
						
						opdrugName = hisutil.appendSpace(drugName.substring(0,30),45,0)
						            +hisutil.appendSpace("",15,0)
						            +hisutil.appendSpace("",10,0)
						            +hisutil.appendSpace("",8,0)
						            +hisutil.appendSpace("",10,0)
						    +" \n "+hisutil.appendSpace(drugName.substring(31,strlength),46,0);
					}
					else
					{
						if(strlength> 100)
						{
							opdrugName = hisutil.appendSpace(drugName.substring(0,30),46,0)
						            +hisutil.appendSpace("",15,0)
						            +hisutil.appendSpace("",10,0)
						            +hisutil.appendSpace("",8,0)
						            +hisutil.appendSpace("",10,0)				            
						            +" \n "+hisutil.appendSpace("",5,0)
								    +hisutil.appendSpace(drugName.substring(31,60),46,0)
						            +hisutil.appendSpace("",15,0)
						            +hisutil.appendSpace("",10,0)
						            +hisutil.appendSpace("",8,0)
						            +hisutil.appendSpace("",10,0)					            
						            +" \n "+hisutil.appendSpace(drugName.substring(60,strlength),46,0);
						}	
						else
						{
						 opdrugName = hisutil.appendSpace(drugName.substring(0,strlength),46,0);
						}
					}
					
					prevItemName = opdrugName;
					
					
					counter++;
				}

				// last row
				if ((sNo) % 2 == 0) {
					strCssClass = "multiRPTControl";
				} else {
					strCssClass = "multiRPTControl1";
				}

				strCheckHidValue = prevItemId + "^0^" + nOpeningBalanceActive + "^0^0";
				nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
				nClosingBalanceActiveValue = nOpeningBalanceActiveValue + nRecActiveValue - nIssueActiveValue;
				

				if (pageCounter == REC_PER_PAGE) {
					pageSize++;
					pageCounter = 0;
				}

				if (pageSize == 1) {
					br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
				} else {
					br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
				}

				// br.append("<tr>");
				br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");

				br.append("<td class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");

				br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='31%'>"
						+ "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' "
						+ "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nOpeningBalanceActive + "</td>");
				
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", (nOpeningBalanceActiveValue))+ "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nRecActive + "</td>");
				
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", (nRecActiveValue)) + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nIssueActive + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", (nIssueActiveValue)) + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nClosingBalanceActive+ "</td>");
										
				br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", (nClosingBalanceActive*Double.parseDouble(prevRate)))
				+ "</td>");

				totIssueRecQty = nRecActive + nIssueActive;
				br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");

				br.append("</tr>");

		
				// grand total
				nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;

				nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;

				nIssueTotActive = nIssueTotActive + nIssueActive;

				nRecTotActive = nRecTotActive + nRecActive;
				
				// grand total of Value
				nOpeningBalanceTotActiveValue = nOpeningBalanceTotActiveValue + nOpeningBalanceActiveValue;

				nClosingBalanceTotActiveValue = nClosingBalanceTotActiveValue + nClosingBalanceActiveValue;

				nIssueTotActiveValue = nIssueTotActiveValue + nIssueActiveValue;

				nRecTotActiveValue = nRecTotActiveValue + nRecActiveValue;
				
								

				// grand total
				pageCounter = pageCounter + 1;

				if (pageSize == 1) {
					br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
				} else {
					br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
				}

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='2' width='31%'><b>Grand Total </b></td>");
				
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='8%'><b>" + (int)nOpeningBalanceTotActive+ "</b></td>");
				
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='8%'><b></b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='8%'><b>" + (int)nRecTotActive + "</b></td>");
				
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='8%'><b></b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='8%'><b>" + (int)nIssueTotActive + "</b></td>");
				
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='8%'><b></b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='8%'><b>" + (int)nClosingBalanceTotActive+ "</b></td>");
				
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='8%'><b></b></td>");
				
				br.append("</tr>");

				brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
				brPagination.append("<tr><td colspan='10' class='TITLE' style='color:#000'>Stock Ledger </td></tr>");

				brPagination.append("<tr>");
				brPagination.append("<td class='LABEL' colspan='10'>");

				for (int i = 0; i < pageSize; i++) {
					if (i == 0) {
						brPagination.append("<a name='pg' id='pg" + (i + 1)
								+ "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-selected' title='Record Indexing'" + " onClick='GetIndex(\""
								+ (i + 1) + "\",\"" + REC_PER_PAGE + "\")'>" + String.valueOf(i + 1) + "</a>|&nbsp;");
					} else {
						brPagination.append("<a name='pg' id='pg" + (i + 1)
								+ "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing'" + " onClick='GetIndex(\""
								+ (i + 1) + "\",\"" + REC_PER_PAGE + "\")'>" + String.valueOf(i + 1) + "</a>|&nbsp;");
					}

				}
				brPagination.append("</td></tr>");
				brPagination.append(br);
				brPagination.append("</table>");

			} else {
				// no data found code here
				brPagination.append("<table width='95%' align='center' cellspacing='1px' cellpadding='1px'>");
				brPagination.append("<tr><td colspan='10' class='TITLE'>Stock Ledger</td></tr>");
				brPagination.append("<tr><td colspan='10' align='center'><Strong>Data Not Found</Strong></td></tr>");
				brPagination.append("</table>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("StockLedgerForSubStoresRptItemNewHLP.getStockLedgerDtl_ValueRpt()->" + e.getMessage());
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}

		return brPagination.toString();

	}
	
	
	public String getConsolidatedStockLedgerRpt_ValuePopUp(StockLedgerForSubStoresRptItemNewVO vo, HttpServletRequest request) throws Exception 
	{
		StringBuffer br = new StringBuffer(1000);
		StringBuffer brPagination = new StringBuffer(3000);

		WebRowSet ws = null;
		String strTableWidth = "100%";

		String prevItemId = "";
		String prevItemName = "";
		String prevRate = "";
		String strFromDate = "";
		String strToDate = "";
		String strCheckHidValue = "";

		//final int REC_PER_PAGE = 100;
		String strCssClass = "",strStoreName="";

		int nFromDay = 0;
		int nToDay = 0;
		int nFromMonth = 0;
		int nToMonth = 0;
		int nFromYear = 0;
		int nToYear = 0;

		int counter = 0;
		int pageCounter = 0;
		int pageSize = 1;
		int sNo = 1;
		/*

		long nOpeningBalanceActive = 0L;
		long nClosingBalanceActive = 0L;
		long nIssueActive = 0L;
		long nRecActive = 0L;
		long nOpeningBalanceTotActive = 0L;
		long nClosingBalanceTotActive = 0L;
		long nIssueTotActive = 0L;
		long nRecTotActive = 0L;
		long totIssueRecQty = 0L;
		*/
		
        double nOpeningBalanceActive = 0L;
		
		double nOpeningBalanceActiveValue  = 0.00;

		double nClosingBalanceActive = 0L;
		
		double nClosingBalanceActiveValue  = 0.00;

		double nIssueActive = 0L;
		
		double nIssueActiveValue  = 0.00;

		double nRecActive = 0L;
		
		double nRecActiveValue  = 0.00;

		double nOpeningBalanceTotActive = 0L;
		
		double nOpeningBalanceTotActiveValue  = 0.00;

		double nClosingBalanceTotActive = 0L;
		
		double nClosingBalanceTotActiveValue  = 0.00;

		double nIssueTotActive = 0L;
		
		double nIssueTotActiveValue  = 0.00;
		
		double nRecTotActive = 0L;
		
		double nRecTotActiveValue  = 0.00;

		double totIssueRecQty = 0L;
		
		NumberFormat  formatter = new DecimalFormat("###############.##"); 
		String       issueValue ="0.00";
		String         recValue ="0.00";		
		HisUtil 		hisutil = new HisUtil("billing", "PrintHLP");

		try 
		{
			System.out.println("----------- StockLedgerForSubStoresRptItemNewHLP.getConsolidatedStockLedgerRpt_ValuePopUp -----------");
			
			ws = vo.getWrsData();

			br.append(getHeader_valuewise(3).toString());

			strFromDate = vo.getStrFromDate();
			strToDate = vo.getStrToDate();

			nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
			nToDay = Integer.parseInt(strToDate.split("\\-")[0]);

			nFromMonth = getMonthInNumbers(strFromDate.split("\\-")[1]);
			nToMonth = getMonthInNumbers(strToDate.split("\\-")[1]);

			nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
			nToYear = Integer.parseInt(strToDate.split("\\-")[2]);

			if (ws != null && ws.size() > 0) 
			{
				if (ws.next()) 
				{
					strStoreName = ws.getString(4);						
				}
				ws.beforeFirst();

				while (ws.next()) 
				{
					if (!prevItemId.equals(ws.getString(3)) && counter > 0) 
					{
						if ((sNo) % 2 == 0) {
							strCssClass = "";
						} else {
							strCssClass = "";
						}

						strCheckHidValue = prevItemId + "^0^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
						nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;

																
						br.append("<tr id='tr'>");
						
						// br.append("<tr>");
						br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");

						br.append("<td class= " + strCssClass + " colspan='1' style='text-align:center;' width='5%'>" + sNo + "</td>");

						br.append("<td style=\"text-align: left;\"  class= " + strCssClass + "  colspan='1' width='31%'>" + prevItemName + "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nOpeningBalanceActive + "</td>");
						
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nOpeningBalanceActiveValue) + "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nRecActive + "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nRecActiveValue) + "</td>");
						
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nIssueActive + "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nIssueActiveValue) + "</td>");
						
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nClosingBalanceActive + "</td>");
						
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", (nClosingBalanceActive*Double.parseDouble(prevRate)))
						+ "</td>");

						totIssueRecQty = nRecActive + nIssueActive;
						br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");

						br.append("</tr>");
                        /*
						// grand total
						nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;
						nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;
						nIssueTotActive = nIssueTotActive + nIssueActive;
						nRecTotActive = nRecTotActive + nRecActive;

						// reset
						nOpeningBalanceActive = 0L;
						nClosingBalanceActive = 0L;
						nIssueActive = 0L;
						nRecActive = 0L;
						*/
						
						// grand total Qty
						nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;
						
						nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;

						nIssueTotActive = nIssueTotActive + nIssueActive;

						nRecTotActive = nRecTotActive + nRecActive;
						
						// grand total of Value
						nOpeningBalanceTotActiveValue = nOpeningBalanceTotActiveValue + nOpeningBalanceActiveValue;
						
						nClosingBalanceTotActiveValue = nClosingBalanceTotActiveValue + nClosingBalanceActiveValue;

						nIssueTotActiveValue = nIssueTotActiveValue + nIssueActiveValue;

						nRecTotActiveValue = nRecTotActiveValue + nRecActiveValue;
						
						// reset
						nOpeningBalanceActive = 0L;
						nClosingBalanceActive = 0L;
						nIssueActive = 0L;
						nRecActive = 0L;
						//Re-Set
						nOpeningBalanceActiveValue = 0L;
						nClosingBalanceActiveValue = 0L;
						nIssueActiveValue = 0L;
						nRecActiveValue = 0L;
						
						
						pageCounter++;
						sNo++;
					}
					nOpeningBalanceActive = nOpeningBalanceActive + Long.parseLong(ws.getString(7));
					nIssueActive = nIssueActive + Long.parseLong(ws.getString(8));
					nRecActive = nRecActive + Long.parseLong(ws.getString(9));
					
					
					// grand total Value
					nOpeningBalanceActiveValue = nOpeningBalanceActiveValue + Double.parseDouble(ws.getString(12));					
					issueValue  =  formatter.format(new BigDecimal(ws.getString(13)));  
					recValue	=  formatter.format(new BigDecimal(ws.getString(14)));  						
					nIssueActiveValue = nIssueActiveValue + Double.parseDouble(issueValue);
					nRecActiveValue = nRecActiveValue + Double.parseDouble(recValue);


				prevItemId = ws.getString(3);
				prevItemName = ws.getString(5);
				prevRate   = ws.getString(11);
				
				
				String drugName = ws.getString(5);
				int strlength=  ws.getString(5).length();
				String opdrugName = "";
				
				if(strlength> 30)
				{
					
					opdrugName = hisutil.appendSpace(drugName.substring(0,30),45,0)
					            +hisutil.appendSpace("",15,0)
					            +hisutil.appendSpace("",10,0)
					            +hisutil.appendSpace("",8,0)
					            +hisutil.appendSpace("",10,0)
					    +" \n "+hisutil.appendSpace(drugName.substring(31,strlength),46,0);
				}
				else
				{
					if(strlength> 100)
					{
						opdrugName = hisutil.appendSpace(drugName.substring(0,30),46,0)
					            +hisutil.appendSpace("",15,0)
					            +hisutil.appendSpace("",10,0)
					            +hisutil.appendSpace("",8,0)
					            +hisutil.appendSpace("",10,0)				            
					            +" \n "+hisutil.appendSpace("",5,0)
							    +hisutil.appendSpace(drugName.substring(31,60),46,0)
					            +hisutil.appendSpace("",15,0)
					            +hisutil.appendSpace("",10,0)
					            +hisutil.appendSpace("",8,0)
					            +hisutil.appendSpace("",10,0)					            
					            +" \n "+hisutil.appendSpace(drugName.substring(60,strlength),46,0);
					}	
					else
					{
					 opdrugName = hisutil.appendSpace(drugName.substring(0,strlength),46,0);
					}
				}
				
				prevItemName = opdrugName;
				
				
					counter++;
				}

				// last row
				if ((sNo) % 2 == 0) {
					strCssClass = "";
				} else {
					strCssClass = "";
				}

				strCheckHidValue           = prevItemId + "^0^" + nOpeningBalanceActive + "^0^0";
				nClosingBalanceActive      = nOpeningBalanceActive + nRecActive - nIssueActive;
				nClosingBalanceActiveValue = nOpeningBalanceActiveValue + nRecActiveValue - nIssueActiveValue;
				

				br.append("<tr id='tr'>");
				
				// br.append("<tr>");
				br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");

				br.append("<td class= " + strCssClass + " colspan='1' style='text-align: right;' width='5%'>" + sNo + "</td>");

				br.append("<td style=\"text-align: left;\"  class= " + strCssClass + "  colspan='1' width='30%'>" + prevItemName + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nOpeningBalanceActive + "</td>");
				
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nOpeningBalanceActiveValue) + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nRecActive + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nRecActiveValue) + "</td>");
				
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nIssueActive + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nIssueActiveValue) + "</td>");
				
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nClosingBalanceActive + "</td>");
				
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", (nClosingBalanceActive*Double.parseDouble(prevRate)))
				+ "</td>");
				
				
				totIssueRecQty = nRecActive + nIssueActive;
				br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");

				br.append("</tr>");

				// grand total
				nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;

				nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;

				nIssueTotActive = nIssueTotActive + nIssueActive;

				nRecTotActive = nRecTotActive + nRecActive;
				
				// grand total of Value
				nOpeningBalanceTotActiveValue = nOpeningBalanceTotActiveValue + nOpeningBalanceActiveValue;

				nClosingBalanceTotActiveValue = nClosingBalanceTotActiveValue + nClosingBalanceActiveValue;

				nIssueTotActiveValue = nIssueTotActiveValue + nIssueActiveValue;

				nRecTotActiveValue = nRecTotActiveValue + nRecActiveValue;
				
				
				br.append("<tr bgcolor='' id='tr'>");			
				
				br.append("<td style='text-align: right;padding: 1%;' class='' colspan='2' ><b>Grand Total</b></td>");				
				br.append("<td style=\"text-align: right;\" class='' colspan='1' ><b>" + (int)nOpeningBalanceTotActive
						+ "</b></td>");
				
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + String.format("%1$,.2f", nOpeningBalanceTotActiveValue)+"</b></td>");
				//br.append("<td style=\"text-align: right;\" class='' colspan='1' ><b></b></td>");

				br.append("<td style=\"text-align: right;\" class='' colspan='1' ><b>" + (int)nRecTotActive + "</b></td>");
				
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + String.format("%1$,.2f", nRecTotActiveValue) + "</b></td>");
				//br.append("<td style=\"text-align: right;\" class='' colspan='1' ><b></b></td>");

				br.append("<td style=\"text-align: right;\" class='' colspan='1' ><b>" + (int)nIssueTotActive + "</b></td>");
				
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + String.format("%1$,.2f", nIssueTotActiveValue) + "</b></td>");
				//br.append("<td style=\"text-align: right;\" class='' colspan='1' ><b></b></td>");

				br.append("<td style=\"text-align: right;\" class='' colspan='1' ><b>" + (int)nClosingBalanceTotActive
						+ "</b></td>");
				
				//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + String.format("%1$,.2f", nClosingBalanceTotActiveValue)+ "</b></td>");
				br.append("<td style=\"text-align: right;\" class='' colspan='1' ><b></b></td>");
				
				br.append("</tr>");
				
				
				brPagination.append(
						"<HTML><HEAD><script language='Javascript' src='../../mms/js/stockledgerForSubStores_mmsrpt.js'></script><script language='JavaScript' src='../../hisglobal/jquery/3.6.0.min.js'></script>"
								+ "<script language='Javascript' src='../../hisglobal/js/innerxhtml.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.16.9/xlsx.full.min.js'></script>"
								+ "<body><form action='/INVMGM/mms/reports/StockLedgerForSubStoresRptItemNewCNT.cnt' method='post'><div id='consolidatedBatchWiseStockLedgerRptDivId'>");
				
				brPagination.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
				brPagination.append("<tr> ");
				brPagination.append("<td align='right'>");
				brPagination.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'> <div id='printImg'>");
				brPagination.append("<img style='cursor: pointer; ' title='Print Page'  ");
				brPagination.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printThis();' /> "					
						+ "<img style='cursor: pointer; ' title='Save as Excel' src='../../hisglobal/images/excel1.png' onClick='generateXLS(event,\"consolidatedBatchWiseStockLedgerRptDivId\");' />"
						+ "<img style='cursor: pointer; ' title='Cancel Process'  ");
				
				
				brPagination.append(" src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div>");
				
				brPagination.append(" </td> ");
				brPagination.append(" </tr> ");
				brPagination.append(" </table> ");
				
				brPagination.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' id='table' cellpadding='0'> ");
				brPagination.append("<tr><td width='10%' colspan='1'  align='right'><div  align='right'></div></td> ");
				brPagination.append("<td width='80%'     colspan='9' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
				brPagination.append("Stock Ledger");
				brPagination.append("</font></b></td><td colspan='1' width='10%'></td> ");
				brPagination.append("</tr> ");
				
				brPagination.append("<tr> ");
				brPagination.append("<td width='10%' colspan='1'></td> ");
				brPagination.append("<td width='80%' colspan='9' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
				brPagination.append("Store Name : " + strStoreName + "<br>");
				brPagination.append("</font></b></td><td width='10%' colspan='1'> ");
				brPagination.append("</td> ");
				brPagination.append("</tr> ");
				
				brPagination.append("<tr> ");
				brPagination.append("<td width='10%' colspan='1' ></td> ");
				brPagination.append("<td width='80%' colspan='9' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
				brPagination.append("Between : " + vo.getStrFromDate() + " And  " + vo.getStrToDate());
				brPagination.append("</font></b></td><td width='10%' colspan='1' > ");
				brPagination.append("</td> ");
				brPagination.append("</tr> ");
				brPagination.append("</table> ");				
				brPagination.append( "<table align='center' width='").append(strTableWidth).append("' border='1' cellspacing='0' id='table1' cellpadding='0''> ");
				brPagination.append(br);
				brPagination.append("</table></div></HEAD></HTML>");
				

			} else {
				// no data found code here
				brPagination.append("<table width='95%' align='center' cellspacing='1px' cellpadding='1px'>");
				brPagination.append("<tr><td colspan='10' class='TITLE'>Stock Ledger</td></tr>");
				brPagination.append("<tr><td colspan='10' align='center'><Strong>No Data Found</Strong></td></tr>");
				brPagination.append("</table>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("StockLedgerForSubStoresRptItemNewHLP.getStockLedgerDtl()->" + e.getMessage());
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}

		return brPagination.toString();

	}
	
	public String getStockLedgerDtlBatch_ValueWiseRpt(StockLedgerForSubStoresRptItemNewVO vo, HttpServletRequest request) throws Exception {
		StringBuffer br = new StringBuffer(1000);
		StringBuffer brPagination = new StringBuffer(3000);

		WebRowSet ws = null;

		String prevItemId = "";
		String prevItemName = "";
		String prevBatch = "";
		String prevExpiry = "";
		String prevRate = "";

		String strFromDate = "";
		String strToDate = "";
		String strCheckHidValue = "";

		final int REC_PER_PAGE = 100;
		String strCssClass = "multiRPTControl";

		int nFromDay = 0;
		int nToDay = 0;
		int nFromMonth = 0;
		int nToMonth = 0;
		int nFromYear = 0;
		int nToYear = 0;

		int counter = 0;
		int pageCounter = 0;
		int pageSize = 1;
		int sNo = 1;
		
		
		double nOpeningBalanceActive = 0L;
		
		double nOpeningBalanceActiveValue  = 0.00;

		double nClosingBalanceActive = 0L;
		
		double nClosingBalanceActiveValue  = 0.00;

		double nIssueActive = 0L;
		
		double nIssueActiveValue  = 0.00;

		double nRecActive = 0L;
		
		double nRecActiveValue  = 0.00;

		double nOpeningBalanceTotActive = 0L;
		
		double nOpeningBalanceTotActiveValue  = 0.00;

		double nClosingBalanceTotActive = 0L;
		
		double nClosingBalanceTotActiveValue  = 0.00;

		double nIssueTotActive = 0L;
		
		double nIssueTotActiveValue  = 0.00;
		
		double nRecTotActive = 0L;
		
		double nRecTotActiveValue  = 0.00;

		double totIssueRecQty = 0L;
				
		
		NumberFormat formatter = new DecimalFormat("###############.##"); 
		String issueValue ="0.00";
		String recValue   ="0.00";
		
		HisUtil 		hisutil = new HisUtil("billing", "PrintHLP");

		try 
		{
			
			System.out.println("------------- StockLedgerForSubStoresRptItemNew.getStockLedgerDtlBatch_ValueWiseRpt() --------------");
			ws = vo.getWrsData();

			br.append(getHeader_valuewise(1).toString());
			
			/*
			    1.OP Date
				2.Store Id
				3.Brand Id
				4.Store Name
				5.Item Name
				6.Batch No
				7.Op Balance Qty
				8.Issue Qty
				9.Rec Qty
			   10.Exp_date
			   11.Rate
			   12.OP_Bal_Value
			   13.Rec_Value
			   14.Issue_Value	  
		    */

			strFromDate = vo.getStrFromDate();
			strToDate 	= vo.getStrToDate();

			nFromDay 	= Integer.parseInt(strFromDate.split("\\-")[0]);
			nToDay 		= Integer.parseInt(strToDate.split("\\-")[0]);

			nFromMonth 	= getMonthInNumbers(strFromDate.split("\\-")[1]);
			nToMonth 	= getMonthInNumbers(strToDate.split("\\-")[1]);

			nFromYear 	= Integer.parseInt(strFromDate.split("\\-")[2]);
			nToYear		= Integer.parseInt(strToDate.split("\\-")[2]);

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
					if ((!prevItemId.equals(ws.getString(3)) || !prevBatch.equals(ws.getString(6))) && counter > 0) 
					{					
						if ((sNo) % 2 == 0) 
						{
							strCssClass = "multiRPTControl";
						} 
						else 
						{
							strCssClass = "multiRPTControl1";
						}

						strCheckHidValue =
								prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
						nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;

						if (pageCounter == REC_PER_PAGE) {
							pageSize++;
							pageCounter = 0;
						}

						if (pageSize == 1) {
							br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
						} else {
							br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
						}

						// br.append("<tr>");
						br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");

						br.append("<td class= " + strCssClass + " colspan='1' width='4%'>" + sNo + "</td>");

						br.append("<td style=\"text-align: left;\"  class= " + strCssClass + " colspan='1' width='30%'>"
								+ "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' "
								+ "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");
						
						
						br.append("<td style=\"text-align: left;\"   class= " + strCssClass + " colspan='1' width='6%'>" + prevRate + "</td>");
						br.append("<td style=\"text-align: left;\"   class= " + strCssClass + " colspan='1' width='6%'>" + prevBatch + "</td>");
						br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='6%'>" + prevExpiry + "</td>");

						br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + (int)nOpeningBalanceActive
								+ "</td>");	
						
						br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + String.format("%1$,.2f", nOpeningBalanceActiveValue)
								+ "</td>");	

						br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + (int)nRecActive + "</td>");
						
						br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + String.format("%1$,.2f", nRecActiveValue) + "</td>");

						br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + (int)nIssueActive + "</td>");
						
						br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + String.format("%1$,.2f", nIssueActiveValue) + "</td>");

						br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + (int)nClosingBalanceActive
								+ "</td>");
						
						br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + String.format("%1$,.2f", (nClosingBalanceActive*Double.parseDouble(prevRate)))
								+ "</td>");
						
						//System.out.println("-A--"+nClosingBalanceActive+"*"+prevRate+"----"+String.format("%1$,.2f", (nClosingBalanceActive*Double.parseDouble(prevRate))));

						totIssueRecQty = nRecActive  + nIssueActive;

						br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
						br.append("</tr>");

						// grand total Qty
						nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;
						
						nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;

						nIssueTotActive = nIssueTotActive + nIssueActive;

						nRecTotActive = nRecTotActive + nRecActive;
						
						// grand total of Value
						nOpeningBalanceTotActiveValue = nOpeningBalanceTotActiveValue + nOpeningBalanceActiveValue;
						
						nClosingBalanceTotActiveValue = nClosingBalanceTotActiveValue + nClosingBalanceActiveValue;

						nIssueTotActiveValue = nIssueTotActiveValue + nIssueActiveValue;

						nRecTotActiveValue = nRecTotActiveValue + nRecActiveValue;

						// reset
						nOpeningBalanceActive = 0L;
						nClosingBalanceActive = 0L;
						nIssueActive = 0L;
						nRecActive = 0L;
						//Re-Set
						nOpeningBalanceActiveValue = 0L;
						nClosingBalanceActiveValue = 0L;
						nIssueActiveValue = 0L;
						nRecActiveValue = 0L;
						
						pageCounter++;
						sNo++;
					}
					// grand total Qty
					nOpeningBalanceActive = nOpeningBalanceActive + Long.parseLong(ws.getString(7));
					nIssueActive = nIssueActive + Long.parseLong(ws.getString(8));
					nRecActive = nRecActive + Long.parseLong(ws.getString(9));
					
					// grand total Value
					nOpeningBalanceActiveValue = nOpeningBalanceActiveValue + Double.parseDouble(ws.getString(12));
					//nIssueActiveValue = nIssueActiveValue + Double.parseDouble(ws.getString(13));
					//nRecActiveValue = nRecActiveValue + Double.parseDouble(ws.getString(14));
					
					issueValue  =  formatter.format(new BigDecimal(ws.getString(14)));  
					recValue	=  formatter.format(new BigDecimal(ws.getString(13)));  
					
					nIssueActiveValue = nIssueActiveValue + Double.parseDouble(issueValue);
					nRecActiveValue = nRecActiveValue + Double.parseDouble(recValue);

					prevItemId = ws.getString(3);
					prevItemName = ws.getString(5);
					prevBatch = ws.getString(6);
					prevExpiry = ws.getString(10);
					prevRate   = ws.getString(11);
					
					
					String drugName = ws.getString(5);
					int strlength=  ws.getString(5).length();
					String opdrugName = "";
					
					if(strlength> 30)
					{
						
						opdrugName = hisutil.appendSpace(drugName.substring(0,30),45,0)
						            +hisutil.appendSpace("",15,0)
						            +hisutil.appendSpace("",10,0)
						            +hisutil.appendSpace("",8,0)
						            +hisutil.appendSpace("",10,0)
						    +" \n "+hisutil.appendSpace(drugName.substring(31,strlength),46,0);
					}
					else
					{
						if(strlength> 100)
						{
							opdrugName = hisutil.appendSpace(drugName.substring(0,30),46,0)
						            +hisutil.appendSpace("",15,0)
						            +hisutil.appendSpace("",10,0)
						            +hisutil.appendSpace("",8,0)
						            +hisutil.appendSpace("",10,0)				            
						            +" \n "+hisutil.appendSpace("",5,0)
								    +hisutil.appendSpace(drugName.substring(31,60),46,0)
						            +hisutil.appendSpace("",15,0)
						            +hisutil.appendSpace("",10,0)
						            +hisutil.appendSpace("",8,0)
						            +hisutil.appendSpace("",10,0)					            
						            +" \n "+hisutil.appendSpace(drugName.substring(60,strlength),46,0);
						}	
						else
						{
						 opdrugName = hisutil.appendSpace(drugName.substring(0,strlength),46,0);
						}
					}
					
					prevItemName = opdrugName;

					counter++;
				}

				// last row
				if ((sNo) % 2 == 0) {
					strCssClass = "multiRPTControl";
				} else {
					strCssClass = "multiRPTControl1";
				}

				strCheckHidValue = prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
				nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
				
				nClosingBalanceActiveValue = nOpeningBalanceActiveValue + nRecActiveValue - nIssueActiveValue;

				if (pageCounter == REC_PER_PAGE) {
					pageSize++;
					pageCounter = 0;
				}

				if (pageSize == 1) {
					br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
				} else {
					br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
				}

				// br.append("<tr>");
				br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");

				br.append("<td class= " + strCssClass + " colspan='1' width='4%'>" + sNo + "</td>");

				br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='30%'>"
						+ "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' "
						+ "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");
				
				br.append("<td style=\"text-align: left;\"   class= " + strCssClass + " colspan='1' width='6%'>" + prevRate + "</td>");
				br.append("<td style=\"text-align: left;\"   class= " + strCssClass + " colspan='1' width='6%'>" + prevBatch + "</td>");
				br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='6%'>" + prevExpiry + "</td>");

				br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + (int)nOpeningBalanceActive
						+ "</td>");	
				
				br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + String.format("%1$,.2f", nOpeningBalanceActiveValue)
						+ "</td>");	

				br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + (int)nRecActive + "</td>");
				
				br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + String.format("%1$,.2f", nRecActiveValue) + "</td>");

				br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + (int)nIssueActive + "</td>");
				
				br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + String.format("%1$,.2f", nIssueActiveValue) + "</td>");

				br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + (int)nClosingBalanceActive
						+ "</td>");
				
				br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + String.format("%1$,.2f",(nClosingBalanceActive*Double.parseDouble(prevRate)))
						+ "</td>");
				
				
				
				//System.out.println("-B--"+nClosingBalanceActive+"*"+prevRate+"----"+(nClosingBalanceActive*Double.parseDouble(prevRate)));
				
				totIssueRecQty = nRecActive + nIssueActive;
				br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");

				br.append("</tr>");

				// grand total
				nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;

				nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;

				nIssueTotActive = nIssueTotActive + nIssueActive;

				nRecTotActive = nRecTotActive + nRecActive;
				
				// grand total of Value
				nOpeningBalanceTotActiveValue = nOpeningBalanceTotActiveValue + nOpeningBalanceActiveValue;

				nClosingBalanceTotActiveValue = nClosingBalanceTotActiveValue + nClosingBalanceActiveValue;

				nIssueTotActiveValue = nIssueTotActiveValue + nIssueActiveValue;

				nRecTotActiveValue = nRecTotActiveValue + nRecActiveValue;
				
				

				// grand total
				pageCounter = pageCounter + 1;

				if (pageSize == 1) {
					br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
				} else {
					br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
				}

				// br.append("<tr>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='5' ><b>Grand Total</b></td>");				
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + (int)nOpeningBalanceTotActive
						+ "</b></td>");
				
				//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + String.format("%1$,.2f", nOpeningBalanceTotActiveValue)+"</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b></b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + (int)nRecTotActive + "</b></td>");
				
				//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + String.format("%1$,.2f", nIssueTotActiveValue) + "</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b></b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + (int)nIssueTotActive + "</b></td>");
				
				//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + String.format("%1$,.2f", nRecTotActiveValue) + "</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b></b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + (int)nClosingBalanceTotActive
						+ "</b></td>");
				
				//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + String.format("%1$,.2f", nClosingBalanceTotActiveValue)+ "</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b></b></td>");
				
				br.append("</tr>");

				brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
				brPagination.append("<tr><td colspan='13' class='TITLE'> Stock Ledger</td></tr>");

				brPagination.append("<tr>");
				brPagination.append("<td class='LABEL' colspan='13'>");

				for (int i = 0; i < pageSize; i++) {
					if (i == 0) {
						brPagination.append("<a name='pg' id='pg" + (i + 1)
								+ "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-selected' title='Record Indexing'" + " onClick='GetIndex(\""
								+ (i + 1) + "\",\"" + REC_PER_PAGE + "\")'>" + String.valueOf(i + 1) + "</a>|&nbsp;");
					} else {
						brPagination.append("<a name='pg' id='pg" + (i + 1)
								+ "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing'" + " onClick='GetIndex(\""
								+ (i + 1) + "\",\"" + REC_PER_PAGE + "\")'>" + String.valueOf(i + 1) + "</a>|&nbsp;");
					}

				}
				brPagination.append("</td></tr>");
				brPagination.append(br);
				brPagination.append("</table>");

			} else {
				// no data found code here
				brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
				brPagination.append("<tr><td class='TITLE'> Stock Ledger</td></tr>");
				brPagination.append("<tr><td align='center'><Strong>Data Not Found</Strong></td></tr>");
				brPagination.append("</table>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("StockLedgerForSubStoresRptItemNewHLP.getStockLedgerDtl()->" + e.getMessage());
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}

		return brPagination.toString();

	}
	
	public String getConsolidatedStockLedgerRptBatch_ValuePopUp(StockLedgerForSubStoresRptItemNewVO vo, HttpServletRequest request) throws Exception {
		StringBuffer br = new StringBuffer(1000);
		StringBuffer brPagination = new StringBuffer(3000);

		WebRowSet ws = null;

		String prevItemId = "";
		String prevItemName = "";
		String prevBatch = "";
		String prevExpiry = "";
		String prevRate = "";

		String strFromDate = "";
		String strToDate = "";
		String strCheckHidValue = "";

		final int REC_PER_PAGE = 100;
		String strCssClass = "multiRPTControl";

		int nFromDay = 0;
		int nToDay = 0;
		int nFromMonth = 0;
		int nToMonth = 0;
		int nFromYear = 0;
		int nToYear = 0;

		int counter = 0;
		int pageCounter = 0;
		int pageSize = 1;
		int sNo = 1;

		double nOpeningBalanceActive = 0L;
		
		double nOpeningBalanceActiveValue = 0L;

		double nClosingBalanceActive = 0L;
		
		double nClosingBalanceActiveValue = 0L;
		
		double nIssueActive = 0L;
		
		double nIssueActiveValue = 0L;

		double nRecActive = 0L;
		
		double nRecActiveValue = 0L;

		double nOpeningBalanceTotActive = 0L;
		
		double nOpeningBalanceTotActiveValue = 0L;

		double nClosingBalanceTotActive = 0L;
		
		double nClosingBalanceTotActiveValue = 0L;

		double nIssueTotActive = 0L;
		
		double nIssueTotActiveValue = 0L;
		
		double nRecTotActive = 0L;
		
		double nRecTotActiveValue = 0L;

		double totIssueRecQty = 0L;
		
		double totIssueRecQtyValue = 0L;
		
		
		
		String issueValue ="0.00";
		String recValue   ="0.00";
		
		String strTableWidth = "95%",strStoreName="";
		NumberFormat formatter = new DecimalFormat("###############.##");  
		HisUtil 		hisutil = new HisUtil("MMS", "StockLedgerForSubStoresRptItemNewHLP");

		try 
		{
			
			System.out.println("------------- StockLedgerForSubStoresRptItemNewHLP.getConsolidatedStockLedgerRptBatch_ValuePopUp() --------------");
			ws = vo.getWrsData();

			br.append(getHeader_valuewise(6).toString());

			strFromDate = vo.getStrFromDate();
			strToDate = vo.getStrToDate();

			nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
			nToDay = Integer.parseInt(strToDate.split("\\-")[0]);

			nFromMonth = getMonthInNumbers(strFromDate.split("\\-")[1]);
			nToMonth = getMonthInNumbers(strToDate.split("\\-")[1]);

			nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
			nToYear = Integer.parseInt(strToDate.split("\\-")[2]);

			if (ws != null && ws.size() > 0) 
			{
								
			
				if (ws.next()) 
				{
					strStoreName = ws.getString(4);						
				}
				ws.beforeFirst();
				

				while (ws.next()) 
				{
					/*
				    1.OP Date
					2.Store Id
					3.Brand Id
					4.Store Name
					5.Item Name
					6.Batch No
					7.Op Balance Qty
					8.Issue Qty
					9.Rec Qty
				   10.Exp_date
				   11.Rate
				   12.OP_Bal_Value
				   13.Rec_Value
				   14.Issue_Value	  
			    */
					
					if ((!prevItemId.equals(ws.getString(3)) || !prevBatch.equals(ws.getString(6))) && counter > 0) 
					{
						if ((sNo) % 2 == 0) 
						{
							strCssClass = "";
						} 
						else 
						{
							strCssClass = "";
						}

						strCheckHidValue =	prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
						nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;

						
						br.append("<tr id='tr'>");
						
						// br.append("<tr>");
						br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");

						br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");

						br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='35%'>" + prevItemName + "</td>");

						br.append("<td style=\"text-align: left;\"   class= " + strCssClass + " colspan='1' width='5%'>" + prevRate + "</td>");
						br.append("<td style=\"text-align: left;\"   class= " + strCssClass + " colspan='1' width='5%'>" + prevBatch + "</td>");
						br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='5%'>" + prevExpiry + "</td>");

						br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + (int)nOpeningBalanceActive
								+ "</td>");	
						
						br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + String.format("%1$,.2f", nOpeningBalanceActiveValue)
								+ "</td>");	

						br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + (int)nRecActive + "</td>");
						
						br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + String.format("%1$,.2f", nRecActiveValue) + "</td>");

						br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + (int)nIssueActive + "</td>");
						
						br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + String.format("%1$,.2f", nIssueActiveValue) + "</td>");

						br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + (int)nClosingBalanceActive
								+ "</td>");
						
						br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + String.format("%1$,.2f", (nClosingBalanceActive*Double.parseDouble(prevRate)))
								+ "</td>");
						

						totIssueRecQty = nRecActive  + nIssueActive;

						br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
						br.append("</tr>");

						// grand total
						nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;
						
						nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;

						nIssueTotActive = nIssueTotActive + nIssueActive;

						nRecTotActive = nRecTotActive + nRecActive;
						
						// grand total  Value
						nOpeningBalanceTotActiveValue = nOpeningBalanceTotActiveValue + nOpeningBalanceActiveValue;
						
						nClosingBalanceTotActiveValue = nClosingBalanceTotActiveValue + nClosingBalanceActiveValue;

						nIssueTotActiveValue = nIssueTotActiveValue + nIssueActiveValue;

						nRecTotActiveValue = nRecTotActiveValue + nRecActiveValue;

						// reset
						nOpeningBalanceActive = 0L;
						nClosingBalanceActive = 0L;
						nIssueActive = 0L;
						nRecActive = 0L;
						// reset value 
						nOpeningBalanceActiveValue = 0L;
						nClosingBalanceActiveValue = 0L;
						nIssueActiveValue = 0L;
						nRecActiveValue = 0L;
						
						pageCounter++;
						sNo++;
					}										
					// grand total Qty
					nOpeningBalanceActive = nOpeningBalanceActive + Long.parseLong(ws.getString(7));
					nIssueActive = nIssueActive + Long.parseLong(ws.getString(8));
					nRecActive = nRecActive + Long.parseLong(ws.getString(9));
					
					// grand total Value
					nOpeningBalanceActiveValue = nOpeningBalanceActiveValue + Double.parseDouble(ws.getString(12));
					
					//nIssueActiveValue = nIssueActiveValue + Double.parseDouble(ws.getString(13));
					//nRecActiveValue = nRecActiveValue + Double.parseDouble(ws.getString(14));
					
					issueValue  =  formatter.format(new BigDecimal(ws.getString(14)));  
					recValue	=  formatter.format(new BigDecimal(ws.getString(13)));  
					
					nIssueActiveValue = nIssueActiveValue + Double.parseDouble(issueValue);
					nRecActiveValue = nRecActiveValue + Double.parseDouble(recValue);
					

					prevItemId = ws.getString(3);
					prevItemName = ws.getString(5);
					prevBatch = ws.getString(6);
					prevExpiry = ws.getString(10);
					prevRate  = ws.getString(11);
					
					String drugName = ws.getString(5);
					int strlength=  ws.getString(5).length();
					String opdrugName = "";
					
					if(strlength> 30)
					{
						
						opdrugName = hisutil.appendSpace(drugName.substring(0,30),45,0)
						            +hisutil.appendSpace("",15,0)
						            +hisutil.appendSpace("",10,0)
						            +hisutil.appendSpace("",8,0)
						            +hisutil.appendSpace("",10,0)
						    +" \n "+hisutil.appendSpace(drugName.substring(31,strlength),46,0);
					}
					else
					{
						if(strlength> 100)
						{
							opdrugName = hisutil.appendSpace(drugName.substring(0,30),46,0)
						            +hisutil.appendSpace("",15,0)
						            +hisutil.appendSpace("",10,0)
						            +hisutil.appendSpace("",8,0)
						            +hisutil.appendSpace("",10,0)				            
						            +" \n "+hisutil.appendSpace("",5,0)
								    +hisutil.appendSpace(drugName.substring(31,60),46,0)
						            +hisutil.appendSpace("",15,0)
						            +hisutil.appendSpace("",10,0)
						            +hisutil.appendSpace("",8,0)
						            +hisutil.appendSpace("",10,0)					            
						            +" \n "+hisutil.appendSpace(drugName.substring(60,strlength),46,0);
						}	
						else
						{
						 opdrugName = hisutil.appendSpace(drugName.substring(0,strlength),46,0);
						}
					}
					
					prevItemName = opdrugName;
										
					counter++;
				}

				// last row
				if ((sNo) % 2 == 0) {
					strCssClass = "";
				} else {
					strCssClass = "";
				}

				strCheckHidValue = prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
				nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
				nClosingBalanceActiveValue = nOpeningBalanceActiveValue + nRecActiveValue - nIssueActiveValue;

				
				br.append("<tr id='tr'>");
				
				// br.append("<tr>");
				br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
				br.append("<td class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");
				br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='35%'>"+ prevItemName + "</td>");
				
				br.append("<td style=\"text-align: left;\"   class= " + strCssClass + " colspan='1' width='5%'>" + prevRate + "</td>");
				br.append("<td style=\"text-align: left;\"   class= " + strCssClass + " colspan='1' width='5%'>" + prevBatch + "</td>");
				br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='5%'>" + prevExpiry + "</td>");

				br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + (int)nOpeningBalanceActive
						+ "</td>");	
				
				br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + String.format("%1$,.2f", nOpeningBalanceActiveValue)
						+ "</td>");	

				br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + (int)nRecActive + "</td>");
				
				br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + String.format("%1$,.2f", nRecActiveValue) + "</td>");

				br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + (int)nIssueActive + "</td>");
				
				br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + String.format("%1$,.2f", nIssueActiveValue) + "</td>");

				br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + (int)nClosingBalanceActive
						+ "</td>");
				
				br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + String.format("%1$,.2f", (nClosingBalanceActive*Double.parseDouble(prevRate)))
						+ "</td>");
				
				
				totIssueRecQty = nRecActive + nIssueActive;
				br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");

				br.append("</tr>");

				// grand total
				nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;

				nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;

				nIssueTotActive = nIssueTotActive + nIssueActive;

				nRecTotActive = nRecTotActive + nRecActive;
				
				// grand total Values
				nOpeningBalanceTotActiveValue = nOpeningBalanceTotActiveValue + nOpeningBalanceActiveValue;

				nClosingBalanceTotActiveValue = nClosingBalanceTotActiveValue + nClosingBalanceActiveValue;

				nIssueTotActiveValue = nIssueTotActiveValue + nIssueActiveValue;

				nRecTotActiveValue = nRecTotActiveValue + nRecActiveValue;
				
				/*
				br.append("<tr bgcolor='' id='tr'>");
				br.append("<td style=\"text-align: right;\"  colspan='4' width='35%'><b>Grand Total</b></td>");
				br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><b>" + nOpeningBalanceTotActive	+ "</b></td>");	
				br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><b>" + nRecTotActive + "</b></td>");	
				br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><b>" + nIssueTotActive + "</b></td>");
				br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><b>" + nClosingBalanceTotActive	+ "</b></td>");
				br.append("</tr>");
				*/
				
				br.append("<tr bgcolor='' id='tr'>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='5' width='35%'><b>Grand Total</b></td>");				
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + (int)nOpeningBalanceTotActive
						+ "</b></td>");
				
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + String.format("%1$,.2f", nOpeningBalanceTotActiveValue)
						+ "</b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + (int)nRecTotActive + "</b></td>");
				
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + String.format("%1$,.2f", nRecTotActiveValue) + "</b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + (int)nIssueTotActive + "</b></td>");
				
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + String.format("%1$,.2f", nIssueTotActiveValue) + "</b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + (int)nClosingBalanceTotActive
						+ "</b></td>");
				
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b></b></td>");
				
				br.append("</tr>");
				
				
				
				
				brPagination.append(
						"<HTML><HEAD><script language='Javascript' src='../../mms/js/stockledgerForSubStores_mmsrpt.js'></script><script language='JavaScript' src='../../hisglobal/jquery/3.6.0.min.js'></script>"
								+ "<script language='Javascript' src='../../hisglobal/js/innerxhtml.js'></script>"
								+ "<body><form action='/INVMGM/mms/reports/StockLedgerForSubStoresRptItemNewCNT.cnt' method='post'><div id='consolidatedBatchWiseStockLedgerRptDivId'>");
				
				brPagination.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
				brPagination.append("<tr> ");
				brPagination.append("<td align='right'>");
				brPagination.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'> <div id='printImg'>");
				brPagination.append("<img style='cursor: pointer; ' title='Print Page'  ");
				brPagination.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printThis();' /> "					
						+ "<img style='cursor: pointer; ' title='Save as Excel' src='../../hisglobal/images/excel1.png' onClick='generateXLS(event,\"consolidatedBatchWiseStockLedgerRptDivId\");' /> "
						+ "<img style='cursor: pointer; ' title='Cancel Process'  ");
				brPagination.append(" src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div>");
				brPagination.append(" </td> ");
				brPagination.append(" </tr> ");
				brPagination.append(" </table> ");
				
				brPagination.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0'> ");
				brPagination.append("<tr><td width='10%' colspan='1'  align='right'><div  align='right'></div></td> ");
				brPagination.append("<td width='80%' colspan='12' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
				brPagination.append("Stock Ledger ");
				brPagination.append("</font></b></td><td colspan='1' width='10%'></td> ");
				brPagination.append("</tr> ");
				
				brPagination.append("<tr> ");
				brPagination.append("<td width='10%' colspan='1'></td> ");
				brPagination.append("<td width='80%' colspan='" + 12 + "' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
				brPagination.append("Store Name : " + strStoreName + "<br>");
				brPagination.append("</font></b></td><td width='10%' colspan='1'> ");
				brPagination.append("</td> ");
				brPagination.append("</tr> ");
				
				brPagination.append("<tr> ");
				brPagination.append("<td width='10%' colspan='1' ></td> ");
				brPagination.append("<td width='80%' colspan='12' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
				brPagination.append("Between : " + vo.getStrFromDate() + " And " + vo.getStrToDate());
				brPagination.append("</font></b></td><td width='10%' colspan='1' > ");
				brPagination.append("</td> ");
				brPagination.append("</tr> ");
				brPagination.append("</table> ");
				
				brPagination.append( "<table align='center' width='").append(strTableWidth).append("' border='1' cellspacing='0' cellpadding='0''> ");

				//brPagination.append("<tr>");
				//brPagination.append("<td class='LABEL' colspan='16'>");
				
				//brPagination.append("</td></tr>");
				brPagination.append(br);
				brPagination.append("</table></div></HEAD></HTML>");

			} else {
				// no data found code here
				brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
				brPagination.append("<tr><td class='TITLE'>Stock Ledger</td></tr>");
				brPagination.append("<tr><td align='center'><Strong>No Data Found</Strong></td></tr>");
				brPagination.append("</table>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("StockLedgerForSubStoresRptItemNewHLP.getConsolidatedStockLedgerRptBatch()->" + e.getMessage());
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}

		return brPagination.toString();

	}

	/**
	 * Gets the header.
	 * 
	 * @param callType the call type
	 * @return the header
	 */
	public StringBuffer getHeader(int callType) 
	{
		StringBuffer brHeader = new StringBuffer(1000);

		// consolidated stock
		if (callType == 1) 
		{
			brHeader.append("<tr>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>S. No.</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='30%'>Item Name</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'>Opening Balance</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'>Received Qty</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'>Issued Qty</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'>Closing Balance</td>");
			brHeader.append("</tr>");

			/*brHeader.append("<tr>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='30%'></td>");

			// Opening Balance
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
			//brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty in Quarantine</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
			// Received Balance
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
			//brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty in Quarantine</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
			// Issued Balance
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
			//brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty in Quarantine</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
			// Closing Balance
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
			//brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty in Quarantine</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
			brHeader.append("</tr>");*/
		}

		// consolidated stock (batch wise)
		if (callType == 2) {
			brHeader.append("<tr>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>S. No.</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='35%'>Item Name</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Batch No</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='7%'>Expiry Date</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Opening Balance</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Received Qty</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Issued Qty</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Closing Balance</td>");
			brHeader.append("</tr>");

			/*brHeader.append("<tr>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='7%'></td>");

			// Opening Balance
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
			//brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty in Quarantine</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
			// Received Balance
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
			//brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty in Quarantine</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
			// Issued Balance
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
			//brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty in Quarantine</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
			// Closing Balance
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
			//brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty in Quarantine</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
			brHeader.append("</tr>");*/
		}

		// detail as clicked on item name [with batch]
		if (callType == 3) {
			brHeader.append("<tr>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>S. No.</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='35%'>Date</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='31%'>Particulars</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Received Qty</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Issued Qty</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Balance</td>");
			brHeader.append("</tr>");

		/*	brHeader.append("<tr>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='31%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'></td>");
			// Closing Balance
			brHeader.append("<td style='background-color: #EFEFF7; border-left: 1px solid #000000; color: #000000;"
					+ "font-family: Verdana,Arial,Helvetica,sans-serif;font-size: 10px;font-weight: bold;height: 12px; border-top:0px;"
					+ "text-align: center' colspan='1' width='8%'>Ready For Issue</td>");
			//brHeader.append("<td style='background-color: #EFEFF7; border-left: 1px solid #000000; color: #000000;"
			//		+ "font-family: Verdana,Arial,Helvetica,sans-serif;font-size: 10px;font-weight: bold;height: 12px;border-top:0px;"
			//		+ "text-align: center' colspan='1' width='8%'>Qty in Quarantine</td>");
			brHeader.append("<td style='background-color: #EFEFF7; border-left: 1px solid #000000; color: #000000;"
					+ "font-family: Verdana,Arial,Helvetica,sans-serif;font-size: 10px;font-weight: bold;height: 12px;border-top:0px;"
					+ "text-align: center' colspan='1' width='8%'>Rejected</td>");
			brHeader.append("</tr>");*/
		}

		// detail as clicked on item name [without batch]
		if (callType == 4) {
			brHeader.append("<tr>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>S. No.</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Date</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Batch No</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Expiry</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'>Particulars</td>");
			//brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'>Op Bal</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Received Qty</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Issued Qty</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'>Closing Bal</td>");
			brHeader.append("</tr>");

			/*brHeader.append("<tr>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'></td>");
			// Closing Balance
			brHeader.append("<td style='background-color: #EFEFF7; border-left: 1px solid #000000; color: #000000;"
					+ "font-family: Verdana,Arial,Helvetica,sans-serif;font-size: 10px;font-weight: bold;height: 12px;border-top:0px;"
					+ "text-align: center' colspan='1' width='5%'>Ready For Issue</td>");
			//brHeader.append("<td style='background-color: #EFEFF7; border-left: 1px solid #000000; color: #000000;"
			//		+ "font-family: Verdana,Arial,Helvetica,sans-serif;font-size: 10px;font-weight: bold;height: 12px;border-top:0px;"
			//		+ "text-align: center' colspan='1' width='5%'>Qty in Quarantine</td>");
			brHeader.append("<td style='background-color: #EFEFF7; border-left: 1px solid #000000; color: #000000;"
					+ "font-family: Verdana,Arial,Helvetica,sans-serif;font-size: 10px;font-weight: bold;height: 12px;border-top:0px;"
					+ "text-align: center' colspan='1' width='5%'>Rejected</td>");
			brHeader.append("</tr>");*/
		}
		
		if (callType == 5) {
			brHeader.append("<tr bgcolor='#cdc9c9' >");
			brHeader.append("<td CLASS='' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S. No.</b></font></td>");
			brHeader.append("<td CLASS='' colspan='1' width='30%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font></td>");
			brHeader.append("<td CLASS='' colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Opening Balance</b></font></td>");
			brHeader.append("<td CLASS='' colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty</b></font></td>");
			brHeader.append("<td CLASS='' colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty</b></font></td>");
			brHeader.append("<td CLASS='' colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Closing Balance</b></font></td>");
			brHeader.append("</tr>");
			
		}
		
		if (callType == 6) {
			brHeader.append("<tr bgcolor='#cdc9c9'>");
			brHeader.append("<td  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S. No.</b></font></td>");
			brHeader.append("<td  colspan='1' width='35%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font></td>");
			brHeader.append("<td  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No</b></font></td>");
			brHeader.append("<td  colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font></td>");
			brHeader.append("<td  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Opening Balance</b></font></td>");
			brHeader.append("<td  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty</b></font></td>");
			brHeader.append("<td  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty</b></font></td>");
			brHeader.append("<td  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Closing Balance</b></font></td>");
			brHeader.append("</tr>");

		}

		return brHeader;
	}

	/*
	 * 1 >> Trans Date 2 >> Particulars 3 >> Active issue 4 >> In-Active Issue 5 >> Quar Issue 6 >> Active Rec 7 >> In-Active Rec 8 >> Quar Rec 9 >>
	 * Store Name 10 >> Item Name 11 >> Batch No 12 >> Expiry Date
	 */
	/**
	 * Gets the detailed stock ledger dtl.
	 * 
	 * @param vo the vo
	 * @param request 
	 * @return the detailed stock ledger dtl
	 * @throws Exception the exception
	 */
	public String getDetailedStockLedgerDtl(StockLedgerForSubStoresRptItemNewVO vo, HttpServletRequest request) throws Exception {
		StringBuffer br = new StringBuffer(1000);
		StringBuffer brPagination = new StringBuffer(3000);

		final int REC_PER_PAGE = 1000;

		String strCssClass = "multiRPTControl3";
		String strStoreName = "";
		String strDrugName = "";
		String strExpiryDate = "";

		int sNo = 1;
		int pageSize = 1;
		int pageCounter = 0;
		int nColspan = 0;

		long nRecQty = 0L;
		long nIssueQty = 0L;

		long nBalanceActiveQty = 0L;

		WebRowSet ws = null;
		String[] tempArr;
		String strRecString = "", strIssueString = "";
		try 
		{

			System.out.println("------------- StockLedgerForSubStoresRptItemNew.getDetailedStockLedgerDtl() --------------");
			
			String strHiddenParameter =	vo.getStrDWHId() + "^" + vo.getStrItemBrandId() + "^" + vo.getStrFromDate() + "^" + vo.getStrToDate() + "^" + vo.getStrBatchNo()
							+ "^" + vo.getStrOpeningBalance() + "^" + vo.getStrStoreName() + "^" + vo.getStrDrugName() + "^" + vo.getStrBatchFlag();

			tempArr = vo.getStrOpeningBalance().split("\\#");
			nBalanceActiveQty = Long.parseLong(tempArr[0].split("\\.")[0]);

			if (vo.getStrBatchNo().equals("0")) 
			{
				br.append(getHeader(4).toString());
				nColspan = 8;
			} 
			else 
			{
				br.append(getHeader(3).toString());
				nColspan = 8;
			}

			// opening balance data
			if (vo.getStrBatchNo().equals("0")) 
			{
				br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
				br.append("<td class= " + strCssClass + " colspan='1' width='5%'><b>" + sNo + "</b></td>");
				br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='10%'><b>" + vo.getStrFromDate()
						+ "</b></td>");
				br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");
				br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");
				//br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='25%'><b>"+HisLanguageProperties.getValue(request, "label.common.Opening_balance")+"</b></td>");
				//br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");
				//br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'><b>" + nBalanceActiveQty + "</b></td>");
				//br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'><b>" + nBalanceQuarQty + "</b></td>");
				//br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'><b>" + nBalanceRejQty + "</b></td>");
				br.append("</tr>");
			} 
			else 
			{
				br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
				br.append("<td class= " + strCssClass + " colspan='1' width='5%'><b>" + sNo + "</b></td>");
				br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='15%'><b>" + vo.getStrFromDate()
						+ "</b></td>");
				//br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='10%'><b>"+HisLanguageProperties.getValue(request, "label.common.Opening_balance")+"</b></td>");
				//br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");
				//br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'><b>" + nBalanceActiveQty + "</b></td>");
				//br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'><b>" + nBalanceQuarQty + "</b></td>");
				//br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'><b>" + nBalanceRejQty + "</b></td>");
				br.append("</tr>");
			}

			sNo++;
			pageCounter++;

			ws = vo.getWrsData();
			if (ws != null && ws.size() > 0) 
			{
				/*
				 * 1.Trans Date
				 * 2.Particulars
				 * 3.Active Issue
				 * 4.In-Active Issue
				 * 5.Quar_Issue
				 * 6.Active_Rece
				 * 7.In-Active Rece
				 * 8.Quar Rece
				 * 9.Store Name
				 * 10.Item Name
				 * 11.Batch No
				 * 12.Exp Date
				 * 13.Rate
				 * */
				while (ws.next()) 
				{
					if ((sNo) % 2 == 0) 
					{
						strCssClass = "multiRPTControl1";
					} else 
					{
						strCssClass = "multiRPTControl3";
					}

					if (pageCounter == REC_PER_PAGE) 
					{
						pageSize++;
						pageCounter = 0;
					}

					nRecQty   = Long.parseLong(ws.getString(6)) + Long.parseLong(ws.getString(7)) + Long.parseLong(ws.getString(8));
					nIssueQty = Long.parseLong(ws.getString(3)) + Long.parseLong(ws.getString(4)) + Long.parseLong(ws.getString(5));

					if (nRecQty > 0) 
					{
						if (Long.parseLong(ws.getString(6)) > 0) 
						{
						//	strRecString = "(A)";
						} //else if (Long.parseLong(ws.getString(7)) > 0) {
						//	strRecString = "(R)";
						//}// else if (Long.parseLong(ws.getString(8)) > 0) {
						//	strRecString = "(Q)";
						//}
					} else {
						strRecString = "";
					}

					if (nIssueQty > 0) {
						if (Long.parseLong(ws.getString(3)) > 0) {
							//strIssueString = "(A)";
						} //else if (Long.parseLong(ws.getString(4)) > 0) {
							//strIssueString = "(R)";
						//} //else if (Long.parseLong(ws.getString(5)) > 0) {
							//strIssueString = "(Q)";
						//}
					} else {
						strIssueString = "";
					}

					nBalanceActiveQty = nBalanceActiveQty + Long.parseLong(ws.getString(6)) - Long.parseLong(ws.getString(3));					

					if (pageSize == 1) {
						br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
					} else {
						br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
					}

					br.append("<td class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");

					if (vo.getStrBatchNo().equals("0")) {
						br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='10%'>" + ws.getString(1) + "</td>");
						br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='10%'>" + ws.getString(11) + "</td>");
						br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='10%'>" + ws.getString(12)
								+ "</td>");
						br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='25%'>" + ws.getString(2) + "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nRecQty + strRecString
								+ "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nIssueQty + strIssueString
								+ "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nBalanceActiveQty + "</td>");
						//br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nBalanceQuarQty + "</td>");
						//br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nBalanceRejQty + "</td>");
					} else {
						br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='15%'>" + ws.getString(1) + "</td>");
						br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='31%'>" + ws.getString(2) + "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nRecQty + strRecString
								+ "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nIssueQty + strIssueString
								+ "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + nBalanceActiveQty + "</td>");
					//	br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + nBalanceQuarQty + "</td>");
						//br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + nBalanceRejQty + "</td>");
					}

					br.append("</tr>");

					if (sNo == 2) {
						strStoreName = ws.getString(9);
						strDrugName = ws.getString(10);
						strExpiryDate = ws.getString(12);
					}

					pageCounter++;
					sNo++;
				}

				// Closing balance data
				if (pageSize == 1) {
					br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
				} else {
					br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
				}

				br.append("<td class= " + strCssClass + " colspan='1' width='5%'><b>" + sNo + "</b></td>");

				if (vo.getStrBatchNo().equals("0")) {
					br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='10%'><b>" + vo.getStrToDate()
							+ "</b></td>");
					br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");
					br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");
					br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='25%'><b>Closing Balance</b></td>");
					br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>--</td>");
					br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>--</td>");

					br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'><b>"+nBalanceActiveQty+"</b></td>");
					//br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'><b>" + nBalanceQuarQty
					//		+ "</b></td>");
					//br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'><b>" + nBalanceRejQty + "</b></td>");
				} else {
					br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='15%'><b>" + vo.getStrToDate()
							+ "</b></td>");
					br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='31%'><b>Closing Balance</b></td>");
					br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");
					br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");

					br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'><b>" + nBalanceActiveQty
							+ "</b></td>");
				//	br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'><b>" + nBalanceQuarQty
				//			+ "</b></td>");
				//	br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'><b>" + nBalanceRejQty + "</b></td>");
				}

				br.append("</tr>");
				br.append("<tr class='FOOTER' style='text-align:left;background: linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;\'><td colspan='" + nColspan + "' >&nbsp;</td></tr>");

				// button here

				br.append("<tr><td colspan='" + nColspan + "'>");
				br.append("<div class='control_button' id='showButtonID'>");
				br.append("<table border='0' width='95%' align='center' cellspacing='1px' cellpadding='1px'>");
				br.append("<tr id='saveId'>");
				br.append("<td align='center'><div>");
				br.append("<a href='#' class='button' title='Print' onClick='printItemDetailedStockLedgerReport(this);' ><span class='print'>Print</span></a>");
				br.append("<a href='#' class='button' title='Cancel' onClick='window.close();' ><span class='cancel'>Cancel</span></a>");
				br.append("</div></td>");
				br.append("</tr>");
				br.append("</table>");
				br.append("</div>");
				br.append("</td></tr>");

				brPagination.append("<HTML><head><link href='../../hisglobal/css/dwh.css' rel='stylesheet' type='text/css'>"
						+ "<link href='../../hisglobal/css/control.css' rel='stylesheet' type='text/css'>"
						+ "<script language='Javascript' src='../../mms/js/stockledgerForSubStoresnew_mmsrpt.js'>"
						+ "</script><style type='text/css'>.pg-normal{color: blue;font-weight: normal;text-decoration: none;cursor: pointer;}"
						+ ".pg-selected{color: red;font-weight: bold;text-decoration: underline;cursor: pointer;}"
						+ ".pg-qualified{color: green;font-weight: bold;text-decoration: underline;cursor: pointer;}"
						+ ".multiRPTControl1 {background-color: #D8D8D8;color: #000000;font-family: Verdana,Arial,Helvetica,sans-serif;"
						+ "font-size: 10px;font-style: normal;font-weight: normal;height: 12px;text-align: center;}" +

						"</style>" + "</head><body class='background'><form class='formbg'>");

				brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px'>");
				brPagination.append("<tr class='HEADER' style='background: linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;'><td colspan='4'> Stock Ledger Detail </td></tr>");
				brPagination.append("<tr><td class='multiRPTLabel' width='20%'>Store Name</td>");
				brPagination.append("<td class='multiRPTControl' width='30%'><div align='left'>" + strStoreName + "</div></td>");
				brPagination.append("<td class='multiRPTLabel' width='20%'>Item Name</td>");
				brPagination.append("<td class='multiRPTControl' width='30%'><div align='left'>" + strDrugName + "</div></td>");
				brPagination.append("</tr>");

				if (!vo.getStrBatchNo().equals("0")) {
					brPagination.append("<tr><td class='multiRPTLabel' width='20%'> Batch No</td>");
					brPagination.append("<td class='multiRPTControl' width='30%'><div align='left'>" + vo.getStrBatchNo() + "</div></td>");
					brPagination.append("<td class='multiRPTLabel' width='20%'>Expiry Date</td>");
					brPagination.append("<td class='multiRPTControl' width='30%'><div align='left'>" + strExpiryDate + "</div></td>");
					brPagination.append("</tr>");
				}

				brPagination.append("<tr><td class='multiRPTLabel' width='20%'>From Date</td>");
				brPagination.append("<td class='multiRPTControl' width='30%'><div align='left'>" + vo.getStrFromDate() + "</div></td>");
				brPagination.append("<td class='multiRPTLabel' width='20%'>To Date</td>");
				brPagination.append("<td class='multiRPTControl' width='30%'><div align='left'>" + vo.getStrToDate() + "</div></td>");
				brPagination.append("</tr>");

				brPagination.append("</table>");

				brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1' >");
				brPagination.append("<tr class='FOOTER' style='text-align:left;background: linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;'><td colspan='" + nColspan + "'>Item Details</td></tr>");

				brPagination.append("<tr>");
				brPagination.append("<td class='LABEL' colspan='" + nColspan + "'>");

				for (int i = 0; i < pageSize; i++) {
					if (i == 0) {
						brPagination.append("<a name='pg' id='pg" + (i + 1)
								+ "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-selected' title='Record Indexing'" + " onClick='GetIndex(\""
								+ (i + 1) + "\",\"" + REC_PER_PAGE + "\")'>" + String.valueOf(i + 1) + "</a>|&nbsp;");
					} else {
						brPagination.append("<a name='pg' id='pg" + (i + 1)
								+ "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing'" + " onClick='GetIndex(\""
								+ (i + 1) + "\",\"" + REC_PER_PAGE + "\")'>" + String.valueOf(i + 1) + "</a>|&nbsp;");
					}

				}
				brPagination.append("</td></tr>");
				brPagination.append(br);

				brPagination.append("</table>");

				brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='0' >");
				brPagination.append("<tr >");
				brPagination.append("<td><font size='2' color='BLUE'>");
				//brPagination.append("<br>* (A)-Active");
				//brPagination.append("<br>* (Q)-Quarantine");
				//brPagination.append("<br>* (R)-Rejected");
				brPagination.append("</td>");
				brPagination.append("</tr>");
				brPagination.append("</table>");

				brPagination.append("<input type='hidden' name='selPageIndex' value='1'/>");
				brPagination.append("<input type='hidden' name='strHiddenParameter' value='" + strHiddenParameter + "'>");
				brPagination.append("</form></body></HTML>");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("StockLedgerForSubStoresRptItemNewHLP.getDetailedStockLedgerDtl()->" + e.getMessage());
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}

		return brPagination.toString();

	}
	
	/*
	 * 1 >> Trans Date 2 >> Particulars 3 >> Active issue 4 >> In-Active Issue 5 >> Quar Issue 6 >> Active Rec 7 >> In-Active Rec 8 >> Quar Rec 9 >>
	 * Store Name 10 >> Item Name 11 >> Batch No 12 >> Expiry Date
	 */
	/**
	 * Gets the detailed stock ledger dtl.
	 * 
	 * @param vo the vo
	 * @param request 
	 * @return the detailed stock ledger dtl
	 * @throws Exception the exception
	 */
	public String getDetailedStockLedgerDtl_NEW(StockLedgerForSubStoresRptItemNewVO vo, HttpServletRequest request) throws Exception 
	{
		StringBuffer br = new StringBuffer(1000);
		StringBuffer brPagination = new StringBuffer(3000);

		WebRowSet ws = null;

		String prevItemId = "";
		String prevItemName = "";
		String prevBatch = "";
		String prevExpiry = "",prevTransDate="",prevParticulars="";

		String strFromDate = "";
		String strToDate = "";
		String strCheckHidValue = "";

		final int REC_PER_PAGE = 1000;
		String strCssClass = "multiRPTControl";

		int nFromDay = 0;
		int nToDay = 0;
		int nFromMonth = 0;
		int nToMonth = 0;
		int nFromYear = 0;
		int nToYear = 0;

		int counter = 0;
		int pageCounter = 0;
		int pageSize = 1;
		int sNo = 1;

		long nOpeningBalanceActive = 0L;
		

		long nClosingBalanceActive = 0L;
		

		long nIssueActive = 0L;
		long nIssueQuar = 0L;
		long nIssueRej = 0L;

		long nRecActive = 0L;
		long nRecQuar = 0L;
		long nRecRej = 0L;

		long nOpeningBalanceTotActive = 0L;
		

		long nClosingBalanceTotActive = 0L;
		

		long nIssueTotActive = 0L;
		

		long nRecTotActive = 0L;
		

		long totIssueRecQty = 0L;

		String[] tempArr;
		String[] tempArr1;

		try {
			ws = vo.getWrsData();

			
			br.append(getHeader(4).toString());
			

			strFromDate = vo.getStrFromDate();
			strToDate = vo.getStrToDate();

			nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
			nToDay = Integer.parseInt(strToDate.split("\\-")[0]);

			nFromMonth = getMonthInNumbers(strFromDate.split("\\-")[1]);
			nToMonth = getMonthInNumbers(strToDate.split("\\-")[1]);

			nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
			nToYear = Integer.parseInt(strToDate.split("\\-")[2]);

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
					
					
					//if ((!prevTransDate.equals(ws.getString(1)) || !prevBatch.equals(ws.getString(11))) && counter > 0) 
					if ((!prevBatch.equals(ws.getString(11))) && counter > 0)
					{
						if ((sNo) % 2 == 0) 
						{
							strCssClass = "multiRPTControl1";
						} else 
						{
							strCssClass = "multiRPTControl3";
						}

						strCheckHidValue      =	prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive ;
						nClosingBalanceActive = nRecActive - nIssueActive;
						

						if (pageCounter == REC_PER_PAGE) 
						{
							pageSize++;
							pageCounter = 0;
						}

						if (pageSize == 1) {
							br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
						} else {
							br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
						}

						// br.append("<tr>");
						br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");

						br.append("<td class= " + strCssClass + " colspan='1'   width='5%'>" + sNo + "</td>");
						br.append("<td style=\"text-align: center;\"  class= " + strCssClass + " colspan='1' width='10%'>" + prevTransDate + "</td>");						

						br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='8%'>" + prevBatch + "</td>");
						
						br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='7%'>" + prevExpiry + "</td>");
						
						br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='7%'>" + prevParticulars + "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceActive+ "</td>");						

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecActive + "</td>");
						

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueActive + "</td>");
						

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceActive	+ "</td>");
						

						totIssueRecQty = nRecActive + nRecQuar + nRecRej + nIssueActive + nIssueQuar + nIssueRej;

						br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
						br.append("</tr>");

						// grand total
						nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;
						

						nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;
						

						nIssueTotActive = nIssueTotActive + nIssueActive;
						
						nRecTotActive = nRecTotActive + nRecActive;
						
						System.out.println("-----------------"+prevItemName+"----------A-----------"+prevBatch+"-----------------");
						System.out.println("nOpeningBalanceTotActive-----"+nOpeningBalanceTotActive);
						
						System.out.println("nOpeningBalanceTotActive-----"+nOpeningBalanceTotActive);
						System.out.println("nClosingBalanceTotActive-----"+nClosingBalanceTotActive);
						System.out.println("nIssueTotActive-----"+nIssueTotActive);
						System.out.println("nRecTotActive-----"+nRecTotActive);
						System.out.println("-------------------------------------------------------");

						// reset
						nOpeningBalanceActive = 0L;						
						nClosingBalanceActive = 0L;						
						nIssueActive = 0L;
						nIssueQuar = 0L;
						nIssueRej = 0L;
						nRecActive = 0L;
						nRecQuar = 0L;
						nRecRej = 0L;
						pageCounter++;
						sNo++;
					}
					
					//System.out.println("nFromMonth-----"+nFromMonth);
					//System.out.println("nFromYear-----"+nFromYear);
					
					//System.out.println("ws.getString(14).split(\\-)[1]-----"+ws.getString(14).split("\\-")[1]);

					if (nFromYear == Integer.parseInt(ws.getString(14).split("\\-")[2])) 					
					{
						
						tempArr = vo.getStrOpeningBalance().split("\\#");
						//nOpeningBalanceActive = Long.parseLong(tempArr[0].split("\\.")[0]);
						
						System.out.println("nOpeningBalanceActive-----"+tempArr[0].split("\\.")[0]);
						
					}

					
					
					nIssueActive = nIssueActive + Long.parseLong(ws.getString(3)) + Long.parseLong(ws.getString(4)) + Long.parseLong(ws.getString(5));
					
					

					nRecActive = nRecActive + Long.parseLong(ws.getString(6)) + Long.parseLong(ws.getString(7)) + Long.parseLong(ws.getString(8));
					
					
					/*
					 * 1.Trans Date
					 * 2.Particulars
					 * 3.Active Issue
					 * 4.In-Active Issue
					 * 5.Quar_Issue
					 * 6.Active_Rece
					 * 7.In-Active Rece
					 * 8.Quar Rece
					 * 9.Store Name
					 * 10.Item Name
					 * 11.Batch No
					 * 12.Exp Date
					 * 13.Rate
					 * 14.Trans Date [ 01-02-2021]
					 * 15.Brand Id
					 * */

					prevItemId = ws.getString(15);
					prevItemName = ws.getString(10);
					prevBatch = ws.getString(11);
					prevExpiry = ws.getString(12);
					prevTransDate = ws.getString(1);
					prevParticulars = ws.getString(2);

					counter++;
				}

				// last row
				if ((sNo) % 2 == 0) 
				{
					strCssClass = "multiRPTControl1";
				} else 
				{
					strCssClass = "multiRPTControl3";
				}

				strCheckHidValue = prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive;
				
				
				
				nClosingBalanceActive =  nRecActive - nIssueActive;
				

				if (pageCounter == REC_PER_PAGE) {
					pageSize++;
					pageCounter = 0;
				}

				if (pageSize == 1) {
					br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
				} else {
					br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
				}

				// br.append("<tr>");
				br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");

				br.append("<td class= " + strCssClass + " colspan='1'   width='5%'>" + sNo + "</td>");
				br.append("<td style=\"text-align: center;\"  class= " + strCssClass + " colspan='1' width='10%'>" + prevTransDate + "</td>");						

				br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='8%'>" + prevBatch + "</td>");
				
				br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='7%'>" + prevExpiry + "</td>");
				
				br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='7%'>" + prevParticulars + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceActive+ "</td>");						

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecActive + "</td>");
				

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueActive + "</td>");
				

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceActive+ "</td>");
				
				
				totIssueRecQty = nRecActive + nRecQuar + nRecRej + nIssueActive + nIssueQuar + nIssueRej;
				br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");

				br.append("</tr>");

				// grand total
				nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;
				

				nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;
				
				nIssueTotActive          = nIssueTotActive + nIssueActive;
				

				nRecTotActive            = nRecTotActive + nRecActive;
				
				System.out.println("-----------------"+prevItemName+"----------B----------"+prevBatch+"-----------------");
				System.out.println("nOpeningBalanceTotActive-----"+nOpeningBalanceTotActive);
				System.out.println("nClosingBalanceTotActive-----"+nClosingBalanceTotActive);
				System.out.println("nIssueTotActive-----"+nIssueTotActive);
				System.out.println("nRecTotActive-----"+nRecTotActive);
				System.out.println("-------------------------------------------------------");
				

				// grand total
				pageCounter = pageCounter + 1;

				if (pageSize == 1) {
					br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
				} else {
					br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
				}

				// br.append("<tr>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='4' width='35%'><b>Grand Total</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nOpeningBalanceTotActive
						+ "</b></td>");
				

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nRecTotActive + "</b></td>");
				

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nIssueTotActive + "</b></td>");
				

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nClosingBalanceTotActive
						+ "</b></td>");
				
				br.append("</tr>");

				brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
				brPagination.append("<tr><td colspan='16' class='TITLE'>Stock Ledger</td></tr>");

				brPagination.append("<tr>");
				brPagination.append("<td class='LABEL' colspan='16'>");

				for (int i = 0; i < pageSize; i++) {
					if (i == 0) {
						brPagination.append("<a name='pg' id='pg" + (i + 1)
								+ "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-selected' title='Record Indexing'" + " onClick='GetIndex(\""
								+ (i + 1) + "\",\"" + REC_PER_PAGE + "\")'>" + String.valueOf(i + 1) + "</a>|&nbsp;");
					} else {
						brPagination.append("<a name='pg' id='pg" + (i + 1)
								+ "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing'" + " onClick='GetIndex(\""
								+ (i + 1) + "\",\"" + REC_PER_PAGE + "\")'>" + String.valueOf(i + 1) + "</a>|&nbsp;");
					}

				}
				brPagination.append("</td></tr>");
				brPagination.append(br);
				brPagination.append("</table>");

			} else {
				// no data found code here
				brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
				brPagination.append("<tr><td class='TITLE'>Stock Ledger </td></tr>");
				brPagination.append("<tr><td align='center'><Strong>No Data Found</Strong></td></tr>");
				brPagination.append("</table>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("StockLedgerForSubStoresRptHLP.getStockLedgerDtl()->" + e.getMessage());
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}

		return brPagination.toString();

	}

	/**
	 * Gets the opening balance.
	 * 
	 * @param ws the ws
	 * @param nDay the n day
	 * @return the opening balance
	 */
	public String getOpeningBalance(WebRowSet ws, int nDay) {
		Long nIssueQtyActive = 0L;
		Long nRecQtyActive = 0L;
		Long nOpeningBalQtyActive = 0L;

		String strOpeningBalance = "0^0^0";

		try {
			nOpeningBalQtyActive = Long.parseLong(ws.getString(7));

				nIssueQtyActive = nIssueQtyActive + Long.parseLong(ws.getString(8));
				nRecQtyActive = nRecQtyActive + Long.parseLong(ws.getString(9));

			nOpeningBalQtyActive = nOpeningBalQtyActive + nRecQtyActive - nIssueQtyActive;

			strOpeningBalance = nOpeningBalQtyActive + "^" + "0" + "^" + "0";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return strOpeningBalance;

	}

	/**
	 * Gets the received and issued qty.
	 * 
	 * @param ws the ws
	 * @param nFromDay the n from day
	 * @param nFromMonth the n from month
	 * @param nFromYear the n from year
	 * @param nToDay the n to day
	 * @param nToMonth the n to month
	 * @param nToYear the n to year
	 * @return the received and issued qty
	 */
	public String getReceivedAndIssuedQty(WebRowSet ws, int nFromDay, int nFromMonth, int nFromYear, int nToDay, int nToMonth, int nToYear) {
		Long nIssueQtyActive = 0L;

		Long nRecQtyActive = 0L;

		String strIssueRecQty = "0^0^0#0^0^0";

		try {
			// For Received / Issued Qty
					nIssueQtyActive = nIssueQtyActive + Long.parseLong(ws.getString(8));
					nRecQtyActive = nRecQtyActive + Long.parseLong(ws.getString(9));
				

			strIssueRecQty =
					nIssueQtyActive + "^" + "0" + "^" + "0" + "#" + nRecQtyActive + "^" + "0" + "^"	+ "0";
		} catch (Exception e) {
			e.printStackTrace();
		}

		return strIssueRecQty;
	}

	/**
	 * Gets the month in numbers.
	 * 
	 * @param strMonth the str month
	 * @return the month in numbers
	 */
	public int getMonthInNumbers(String strMonth) {
		int nMonth = 0;

		if (strMonth.equalsIgnoreCase("Jan")) {
			nMonth = 1;
		} else if (strMonth.equalsIgnoreCase("Feb")) {
			nMonth = 2;
		} else if (strMonth.equalsIgnoreCase("Mar")) {
			nMonth = 3;
		} else if (strMonth.equalsIgnoreCase("Apr")) {
			nMonth = 4;
		} else if (strMonth.equalsIgnoreCase("May")) {
			nMonth = 5;
		} else if (strMonth.equalsIgnoreCase("Jun")) {
			nMonth = 6;
		} else if (strMonth.equalsIgnoreCase("Jul")) {
			nMonth = 7;
		} else if (strMonth.equalsIgnoreCase("Aug")) {
			nMonth = 8;
		} else if (strMonth.equalsIgnoreCase("Sep")) {
			nMonth = 9;
		} else if (strMonth.equalsIgnoreCase("Oct")) {
			nMonth = 10;
		} else if (strMonth.equalsIgnoreCase("Nov")) {
			nMonth = 11;
		} else if (strMonth.equalsIgnoreCase("Dec")) {
			nMonth = 12;
		}

		return nMonth;
	}
	
	public String getConsolidatedStockLedgerRpt(StockLedgerForSubStoresRptItemNewVO vo, HttpServletRequest request) throws Exception {
		StringBuffer br = new StringBuffer(1000);
		StringBuffer brPagination = new StringBuffer(3000);

		WebRowSet ws = null;
		String strTableWidth = "100%";

		String prevItemId = "";
		String prevItemName = "";
		String strFromDate = "";
		String strToDate = "";
		String strCheckHidValue = "";

		//final int REC_PER_PAGE = 100;
		String strCssClass = "",strStoreName="";

		int nFromDay = 0;
		int nToDay = 0;
		int nFromMonth = 0;
		int nToMonth = 0;
		int nFromYear = 0;
		int nToYear = 0;

		int counter = 0;
		int pageCounter = 0;
		int pageSize = 1;
		int sNo = 1;

		long nOpeningBalanceActive = 0L;
		long nClosingBalanceActive = 0L;
		long nIssueActive = 0L;
		long nRecActive = 0L;
		long nOpeningBalanceTotActive = 0L;
		long nClosingBalanceTotActive = 0L;
		long nIssueTotActive = 0L;
		long nRecTotActive = 0L;
		long totIssueRecQty = 0L;

		try 
		{
			System.out.println("----------- StockLedgerForSubStoresRptItemNewHLP.getConsolidatedStockLedgerRpt -----------");
			
			ws = vo.getWrsData();

			br.append(getHeader(5).toString());

			strFromDate = vo.getStrFromDate();
			strToDate = vo.getStrToDate();

			nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
			nToDay = Integer.parseInt(strToDate.split("\\-")[0]);

			nFromMonth = getMonthInNumbers(strFromDate.split("\\-")[1]);
			nToMonth = getMonthInNumbers(strToDate.split("\\-")[1]);

			nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
			nToYear = Integer.parseInt(strToDate.split("\\-")[2]);

			if (ws != null && ws.size() > 0) 
			{
				if (ws.next()) 
				{
					strStoreName = ws.getString(4);						
				}
				ws.beforeFirst();

				while (ws.next()) 
				{
					if (!prevItemId.equals(ws.getString(3)) && counter > 0) 
					{
						if ((sNo) % 2 == 0) {
							strCssClass = "";
						} else {
							strCssClass = "";
						}

						strCheckHidValue = prevItemId + "^0^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
						nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;

																
						br.append("<tr id='tr'>");
						
						// br.append("<tr>");
						br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");

						br.append("<td class= " + strCssClass + " colspan='1' style='text-align: right;' width='5%'>" + sNo + "</td>");

						br.append("<td style=\"text-align: left;\"  class= " + strCssClass + "  colspan='1' width='30%'>" + prevItemName + "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceActive + "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecActive + "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueActive + "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceActive + "</td>");

						totIssueRecQty = nRecActive + nIssueActive;
						br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");

						br.append("</tr>");

						// grand total
						nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;
						nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;
						nIssueTotActive = nIssueTotActive + nIssueActive;
						nRecTotActive = nRecTotActive + nRecActive;

						// reset
						nOpeningBalanceActive = 0L;
						nClosingBalanceActive = 0L;
						nIssueActive = 0L;
						nRecActive = 0L;
						pageCounter++;
						sNo++;
					}

						nOpeningBalanceActive = nOpeningBalanceActive + Long.parseLong(ws.getString(7));
						nIssueActive = nIssueActive + Long.parseLong(ws.getString(8));
						nRecActive = nRecActive + Long.parseLong(ws.getString(9));

					prevItemId = ws.getString(3);
					prevItemName = ws.getString(5);
					counter++;
				}

				// last row
				if ((sNo) % 2 == 0) {
					strCssClass = "";
				} else {
					strCssClass = "";
				}

				strCheckHidValue = prevItemId + "^0^" + nOpeningBalanceActive + "^0^0";
				nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
				

				br.append("<tr id='tr'>");
				
				// br.append("<tr>");
				br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");

				br.append("<td class= " + strCssClass + " colspan='1' style='text-align: right;' width='5%'>" + sNo + "</td>");

				br.append("<td style=\"text-align: left;\"  class= " + strCssClass + "  colspan='1' width='30%'>" + prevItemName + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceActive + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecActive + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueActive + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceActive + "</td>");

				totIssueRecQty = nRecActive + nIssueActive;
				br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");

				br.append("</tr>");

				// grand total
				nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;

				nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;

				nIssueTotActive = nIssueTotActive + nIssueActive;

				nRecTotActive = nRecTotActive + nRecActive;
				


				
				br.append("<tr bgcolor='' id='tr'>");
				

				// br.append("<tr>");
				br.append("<td style=\"text-align: right;\" class='' colspan='2' width='35%'><b>Grand Total</b></td>");
				br.append("<td style=\"text-align: right;\" class='' colspan='1' width='5%'><b>" + nOpeningBalanceTotActive
						+ "</b></td>");

				br.append("<td style=\"text-align: right;\" class='' colspan='1' width='5%'><b>" + nRecTotActive + "</b></td>");
				br.append("<td style=\"text-align: right;\" class='' colspan='1' width='5%'><b>" + nIssueTotActive + "</b></td>");
				br.append("<td style=\"text-align: right;\" class='' colspan='1' width='5%'><b>" + nClosingBalanceTotActive
						+ "</b></td>");
				br.append("</tr>");
				
				
				brPagination.append(
						"<HTML><HEAD><script language='Javascript' src='../../mms/js/stockledgerForSubStores_mmsrpt.js'></script><script language='JavaScript' src='../../hisglobal/jquery/3.6.0.min.js'></script>"
								+ "<script language='Javascript' src='../../hisglobal/js/innerxhtml.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.16.9/xlsx.full.min.js'></script>"
								+ "<body><form action='/INVMGM/mms/reports/StockLedgerForSubStoresRptItemNewCNT.cnt' method='post'><div id='consolidatedBatchWiseStockLedgerRptDivId'>");
				
				brPagination.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
				brPagination.append("<tr> ");
				brPagination.append("<td align='right'>");
				brPagination.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'> <div id='printImg'>");
				brPagination.append("<img style='cursor: pointer; ' title='Print Page'  ");
				brPagination.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printThis();' /> "					
						+ "<img style='cursor: pointer; ' title='Save as Excel' src='../../hisglobal/images/excel1.png' onClick='generateXLS1();' /> "
						+ "<img style='cursor: pointer; ' title='Cancel Process'  ");
				
				
				brPagination.append(" src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div>");
				
				brPagination.append(" </td> ");
				brPagination.append(" </tr> ");
				brPagination.append(" </table> ");
				
				brPagination.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' id='table' cellpadding='0'> ");
				brPagination.append("<tr><td width='10%' colspan='1'  align='right'><div  align='right'></div></td> ");
				brPagination.append("<td width='80%' colspan='12' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
				brPagination.append("Stock Ledger");
				brPagination.append("</font></b></td><td colspan='1' width='10%'></td> ");
				brPagination.append("</tr> ");
				
				brPagination.append("<tr> ");
				brPagination.append("<td width='10%' colspan='1'></td> ");
				brPagination.append("<td width='80%' colspan='" + 12 + "' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
				brPagination.append("Store Name : " + strStoreName + "<br>");
				brPagination.append("</font></b></td><td width='10%' colspan='1'> ");
				brPagination.append("</td> ");
				brPagination.append("</tr> ");
				
				brPagination.append("<tr> ");
				brPagination.append("<td width='10%' colspan='1' ></td> ");
				brPagination.append("<td width='80%' colspan='12' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
				brPagination.append("Between : " + vo.getStrFromDate() + " And  " + vo.getStrToDate());
				brPagination.append("</font></b></td><td width='10%' colspan='1' > ");
				brPagination.append("</td> ");
				brPagination.append("</tr> ");
				brPagination.append("</table> ");
				
				brPagination.append( "<table align='center' width='").append(strTableWidth).append("' border='1' cellspacing='0' id='table1' cellpadding='0''> ");

				//brPagination.append("<tr>");
				//brPagination.append("<td class='LABEL' colspan='16'>");
				
				//brPagination.append("</td></tr>");
				brPagination.append(br);
				brPagination.append("</table></div></HEAD></HTML>");
				/*
				brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
				brPagination.append("<tr><td colspan='14' class='TITLE' style='color:#000'>Stock Ledger </td></tr>");
				brPagination.append("<tr>");
				brPagination.append("<td class='LABEL' colspan='14'>");				
				brPagination.append("</td></tr>");
				brPagination.append(br);
				brPagination.append("</table>");
				*/

			} else {
				// no data found code here
				brPagination.append("<table width='95%' align='center' cellspacing='1px' cellpadding='1px'>");
				brPagination.append("<tr><td colspan='14' class='TITLE'>Stock Ledger</td></tr>");
				brPagination.append("<tr><td colspan='14' align='center'><Strong>No Data Found</Strong></td></tr>");
				brPagination.append("</table>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("StockLedgerForSubStoresRptItemNewHLP.getStockLedgerDtl()->" + e.getMessage());
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}

		return brPagination.toString();

	}

	/*
	 * Value Pass in Web Row Set 1 HSTNUM_MONTH, 2 HSTNUM_YEAR, 3 HSTNUM_STORE_ID, 4 HSTNUM_ITEMBRAND_ID, 5 STR_NAME, 6 ITEM_NAME, 7 BATCH_NO, 8
	 * HSTSTR_ACTIVE_OPBALANCE_QTY, 9 HSTSTR_QUAR_OPBALANCE_QTY, 10 HSTSTR_REJ_OPBALANCE_QTY, 11 HSTSTR_ISSUEQTY_DAY1, 12 HSTSTR_RECQTY_DAY1, 13
	 * HSTSTR_ISSUEQTY_DAY2, 14 HSTSTR_RECQTY_DAY2, 15 HSTSTR_ISSUEQTY_DAY3, 16 HSTSTR_RECQTY_DAY3, 17 HSTSTR_ISSUEQTY_DAY4, 18 HSTSTR_RECQTY_DAY4, 19
	 * HSTSTR_ISSUEQTY_DAY5, 20 HSTSTR_RECQTY_DAY5, 21 HSTSTR_ISSUEQTY_DAY6, 22 HSTSTR_RECQTY_DAY6, 23 HSTSTR_ISSUEQTY_DAY7, 24 HSTSTR_RECQTY_DAY7, 25
	 * HSTSTR_ISSUEQTY_DAY8, 26 HSTSTR_RECQTY_DAY8, 27 HSTSTR_ISSUEQTY_DAY9, 28 HSTSTR_RECQTY_DAY9, 29 HSTSTR_ISSUEQTY_DAY10, 30 HSTSTR_RECQTY_DAY10,
	 * 31 HSTSTR_ISSUEQTY_DAY11, 32 HSTSTR_RECQTY_DAY11, 33 HSTSTR_ISSUEQTY_DAY12, 34 HSTSTR_RECQTY_DAY12, 35 HSTSTR_ISSUEQTY_DAY13, 36
	 * HSTSTR_RECQTY_DAY13, 37 HSTSTR_ISSUEQTY_DAY14, 38 HSTSTR_RECQTY_DAY14, 39 HSTSTR_ISSUEQTY_DAY15, 40 HSTSTR_RECQTY_DAY15, 41
	 * HSTSTR_ISSUEQTY_DAY16, 42 HSTSTR_RECQTY_DAY16, 43 HSTSTR_ISSUEQTY_DAY17, 44 HSTSTR_RECQTY_DAY17, 45 HSTSTR_ISSUEQTY_DAY18, 46
	 * HSTSTR_RECQTY_DAY18, 47 HSTSTR_ISSUEQTY_DAY19, 48 HSTSTR_RECQTY_DAY19, 49 HSTSTR_ISSUEQTY_DAY20, 50 HSTSTR_RECQTY_DAY20, 51
	 * HSTSTR_ISSUEQTY_DAY21, 52 HSTSTR_RECQTY_DAY21, 53 HSTSTR_ISSUEQTY_DAY22, 54 HSTSTR_RECQTY_DAY22, 55 HSTSTR_ISSUEQTY_DAY23, 56
	 * HSTSTR_RECQTY_DAY23, 57 HSTSTR_ISSUEQTY_DAY24, 58 HSTSTR_RECQTY_DAY24, 59 HSTSTR_ISSUEQTY_DAY25, 60 HSTSTR_RECQTY_DAY25, 61
	 * HSTSTR_ISSUEQTY_DAY26, 62 HSTSTR_RECQTY_DAY26, 63 HSTSTR_ISSUEQTY_DAY27, 64 HSTSTR_RECQTY_DAY27, 65 HSTSTR_ISSUEQTY_DAY28, 66
	 * HSTSTR_RECQTY_DAY28, 67 HSTSTR_ISSUEQTY_DAY29, 68 HSTSTR_RECQTY_DAY29, 69 HSTSTR_ISSUEQTY_DAY30, 70 HSTSTR_RECQTY_DAY30, 71
	 * HSTSTR_ISSUEQTY_DAY31, 72 HSTSTR_RECQTY_DAY31, 73 HSTSTR_TOTAL_ACTIVE_ISSUEQTY, 74 HSTSTR_TOTAL_QUAR_ISSUEQTY, 75 HSTSTR_TOTAL_REJ_ISSUEQTY, 76
	 * HSTSTR_TOTAL_ACTIVE_RECQTY, 77 HSTSTR_TOTAL_QUAR_RECQTY, 78 HSTSTR_TOTAL_REJ_RECQTY 79 EXPIRY DATE
	 */
	// To get Consolidated Stock Ledger Report
	/**
	 * Gets the consolidated stock ledger rpt.
	 * 
	 * @param vo the vo
	 * @param request the request
	 * @return the consolidated stock ledger rpt
	 * @throws Exception the exception
	 */
	public String getConsolidatedStockLedgerRpt_OLD(StockLedgerForSubStoresRptItemNewVO vo, HttpServletRequest request) throws Exception {
		
		String strTableWidth = "100%";
		StringBuffer br = new StringBuffer(1000);
		StringBuffer brPagination = new StringBuffer(3000);

		WebRowSet ws = null;

		String prevItemId = "";
		String prevItemName = "";
		String strFromDate = "";
		String strToDate = "";

		int nFromDay = 0;
		int nToDay = 0;
		int nFromMonth = 0;
		int nToMonth = 0;
		int nFromYear = 0;
		int nToYear = 0;

		int counter = 0;
		int sNo = 1;

		long nOpeningBalanceActive = 0L;
		long nOpeningBalanceQuar = 0L;
		long nOpeningBalanceRej = 0L;

		long nClosingBalanceActive = 0L;
		long nClosingBalanceQuar = 0L;
		long nClosingBalanceRej = 0L;

		long nIssueActive = 0L;
		long nIssueQuar = 0L;
		long nIssueRej = 0L;

		long nRecActive = 0L;
		long nRecQuar = 0L;
		long nRecRej = 0L;

		long nOpeningBalanceTotActive = 0L;
		long nOpeningBalanceTotQuar = 0L;
		long nOpeningBalanceTotRej = 0L;

		long nClosingBalanceTotActive = 0L;
		long nClosingBalanceTotQuar = 0L;
		long nClosingBalanceTotRej = 0L;

		long nIssueTotActive = 0L;
		long nIssueTotQuar = 0L;
		long nIssueTotRej = 0L;

		long nRecTotActive = 0L;
		long nRecTotQuar = 0L;
		long nRecTotRej = 0L;

		String[] tempArr;
		String[] tempArr1;
		try {

			ws = vo.getWrsData();

			if (vo.getStrItemBrandId() == null || vo.getStrItemBrandId().equals("0")) {
				vo.setStrDrugName("All");
			} else {

				if (ws != null && ws.size() > 0) {
					if (ws.next()) {
						vo.setStrDrugName(ws.getString(6));
					}
				}
				ws.beforeFirst();
			}

			br.append(
					"<HTML><HEAD><script language='Javascript' src='../../mms/js/stockledgerForSubStores_mmsrpt.js'></script><script language='JavaScript' src='../../hisglobal/jquery/3.6.0.min.js'></script>"
							+ "<script language='Javascript' src='../../hisglobal/js/innerxhtml.js'></script>"
							+ "<body><form action='/INVMGM/mms/reports/StockLedgerForSubStoresRptItemNewCNT.cnt' method='post'><div id='consolidatedStockLedgerRptDivId'>"
							+ "" + "<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0''> ");
			try {
				br.append("<td colspan='1' width='10%' align='center'><div  align='center'> <img  align='absmiddle' src='http://" + request.getServerName() + ":"
					+ request.getServerPort() + " Voucher Report '/></div></td> ");
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			br.append("</tr> ");
			br.append("</table> ");
			br.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0'> ");
			br.append("<tr><td width='10%' colspan='1'  align='right'><div  align='right'></div></td> ");
			br.append("<td width='80%' colspan='12' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
			br.append("Stock Ledger");
			br.append("</font></b></td><td colspan='1' width='10%'></td> ");
			br.append("</tr> ");

			br.append("<tr> ");
			br.append("<td width='10%' colspan='1' align='right'><div  align='right'></div></td> ");
			br.append("<td width='80%' colspan='12' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
			br.append("Store Name " + vo.getStrStoreName() + "<br>");
			br.append("Drug Name: " + vo.getStrDrugName() + "<br>");
			br.append("</font></b></td><td colspan='1' width='10%'> ");
			br.append("</td> ");
			br.append("</tr> ");
			br.append("<tr> ");
			br.append("<td width='10%' colspan='1' ></td> ");
			br.append("<td width='80%' colspan='12'  align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
			br.append("Between : " + vo.getStrFromDate() + " And " + vo.getStrToDate());
			br.append("</font></b></td><td colspan='1' width='10%'> ");
			br.append("</td> ");
			br.append("</tr> ");
			br.append("</table> ");

			br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			br.append("<tr> ");
			br.append("<td align='right'>");
			br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'> <div id='printImg'>");
			br.append("<img style='cursor: pointer; ' title='Print Page'  ");
			br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printThis();' /> "
					//+ "<img style='cursor: pointer; ' title='Save as Pdf' src='../../hisglobal/images/pdf.jpg' onClick='generatePdf(\"consolidatedStockLedgerRptDivId\");' /> "
					+ "<img style='cursor: pointer; ' title='Save as Excel' src='../../hisglobal/images/excel1.png' onClick='generateXLS(event,\"consolidatedStockLedgerRptDivId\");' /> "
					+ "<img style='cursor: pointer; ' title='Cancel Process'  ");
			br.append(" src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div>");
			br.append(" </td> ");
			br.append(" </tr> ");
			br.append(" </table> ");

			br.append("<table cellspacing='0' border='1' cellpadding='0' width='").append(strTableWidth).append("' align='center'> ");
			br.append("<tr bgcolor='#cdc9c9'> ");

			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font></td>");

			br.append("<td style=\"text-align: center;\" colspan='1' width='35%'><font  size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font></td>");

			br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Opening Balance </b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty </b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Closing Balance</b></font></td>");
			br.append("</tr>");

			/*br.append("<tr bgcolor='#cdc9c9'> ");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");

			br.append("<td style=\"text-align: center;\" colspan='1' width='35%'><font  size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");

			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Ready_for_issue")+"</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Rejected")+"</b></font></td>");
			//br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Qty_in_quarantine")+"</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Ready_for_issue")+"</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Rejected")+"</b></font></td>");
			//br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Qty_in_quarantine")+"</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Ready_for_issue")+"</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Rejected")+"</b></font></td>");
			//br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Qty_in_quarantine")+"</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Ready_for_issue")+"</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Rejected")+"</b></font></td>");
			//br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Qty_in_quarantine")+"</b></font></td>");

			br.append("</tr>");*/

			// br.append(getHeader(1).toString());

			strFromDate = vo.getStrFromDate();
			strToDate = vo.getStrToDate();

			nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
			nToDay = Integer.parseInt(strToDate.split("\\-")[0]);

			nFromMonth = getMonthInNumbers(strFromDate.split("\\-")[1]);
			nToMonth = getMonthInNumbers(strToDate.split("\\-")[1]);

			nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
			nToYear = Integer.parseInt(strToDate.split("\\-")[2]);

			if (ws != null && ws.size() > 0) {

				while (ws.next()) {
					if (!prevItemId.equals(ws.getString(4)) && counter > 0) {

						nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
						nClosingBalanceQuar = nOpeningBalanceQuar + nRecQuar - nIssueQuar;
						nClosingBalanceRej = nOpeningBalanceRej + nRecRej - nIssueRej;

						br.append("<tr>");
						br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ sNo + "</font></td>");
						br.append("<td style=\"text-align: left;\" colspan='1' width='30%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ prevItemName + "</font></td>");

						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nOpeningBalanceActive + "</font></td>");
						//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						//		+ nOpeningBalanceQuar + "</font></td>");
						//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						//		+ nOpeningBalanceRej + "</font></td>");

						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nRecActive + "</font></td>");
						//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						//		+ nRecQuar + "</font></td>");
						///br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						//		+ nRecRej + "</font></td>");

						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nIssueActive + "</font></td>");
						//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						//		+ nIssueQuar + "</font></td>");
						//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						//		+ nIssueRej + "</font></td>");

						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nClosingBalanceActive + "</font></td>");
						//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						//		+ nClosingBalanceQuar + "</font></td>");
						//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						//		+ nClosingBalanceRej + "</font></td>");

						br.append("</tr>");

						// grand total
						nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;
						nOpeningBalanceTotQuar = nOpeningBalanceTotQuar + nOpeningBalanceQuar;
						nOpeningBalanceTotRej = nOpeningBalanceTotRej + nOpeningBalanceRej;

						nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;
						nClosingBalanceTotQuar = nClosingBalanceTotQuar + nClosingBalanceQuar;
						nClosingBalanceTotRej = nClosingBalanceTotRej + nClosingBalanceRej;

						nIssueTotActive = nIssueTotActive + nIssueActive;
						nIssueTotQuar = nIssueTotQuar + nIssueQuar;
						nIssueTotRej = nIssueTotRej + nIssueRej;

						nRecTotActive = nRecTotActive + nRecActive;
						nRecTotQuar = nRecTotQuar + nRecQuar;
						nRecTotRej = nRecTotRej + nRecRej;

						// reset
						nOpeningBalanceActive = 0L;
						nOpeningBalanceQuar = 0L;
						nOpeningBalanceRej = 0L;
						nClosingBalanceActive = 0L;
						nClosingBalanceQuar = 0L;
						nClosingBalanceRej = 0L;
						nIssueActive = 0L;
						nIssueQuar = 0L;
						nIssueRej = 0L;
						nRecActive = 0L;
						nRecQuar = 0L;
						nRecRej = 0L;
						sNo++;
					}

					if (nFromMonth == Integer.parseInt(ws.getString(1)) && nFromYear == Integer.parseInt(ws.getString(2))) {
						tempArr = getOpeningBalance(ws, nFromDay).split("\\^");
						nOpeningBalanceActive = nOpeningBalanceActive + Long.parseLong(tempArr[0].split("\\.")[0]);
						nOpeningBalanceQuar = nOpeningBalanceQuar + Long.parseLong(tempArr[1].split("\\.")[0]);
						nOpeningBalanceRej = nOpeningBalanceRej + Long.parseLong(tempArr[2].split("\\.")[0]);
					}

					tempArr = getReceivedAndIssuedQty(ws, nFromDay, nFromMonth, nFromYear, nToDay, nToMonth, nToYear).split("\\#");
					tempArr1 = tempArr[0].split("\\^");

					nIssueActive = nIssueActive + Long.parseLong(tempArr1[0].split("\\.")[0]);
					nIssueQuar = nIssueQuar + Long.parseLong(tempArr1[1].split("\\.")[0]);
					nIssueRej = nIssueRej + Long.parseLong(tempArr1[2].split("\\.")[0]);

					tempArr1 = tempArr[1].split("\\^");

					nRecActive = nRecActive + Long.parseLong(tempArr1[0].split("\\.")[0]);
					nRecQuar = nRecQuar + Long.parseLong(tempArr1[1].split("\\.")[0]);
					nRecRej = nRecRej + Long.parseLong(tempArr1[2].split("\\.")[0]);

					prevItemId = ws.getString(4);
					prevItemName = ws.getString(6);
					ws.getString(7);

					counter++;
				}

				nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
				nClosingBalanceQuar = nOpeningBalanceQuar + nRecQuar - nIssueQuar;
				nClosingBalanceRej = nOpeningBalanceRej + nRecRej - nIssueRej;

				br.append("<tr>");

				br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ sNo + "</font></td>");

				br.append("<td style=\"text-align: left;\" colspan='1' width='30%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ prevItemName + "</font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nOpeningBalanceActive + "</font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
				//		+ nOpeningBalanceQuar + "</font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
				//		+ nOpeningBalanceRej + "</font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nRecActive + "</font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
				//		+ nRecQuar + "</font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
				//		+ nRecRej + "</font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nIssueActive + "</font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
				//		+ nIssueQuar + "</font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
				//		+ nIssueRej + "</font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nClosingBalanceActive + "</font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
				//		+ nClosingBalanceQuar + "</font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
				//		+ nClosingBalanceRej + "</font></td>");

				br.append("</tr>");

				// grand total

				br.append("<tr>");
				br.append("<td style=\"text-align: right;\" colspan='2' width='35%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Grand Total</b></font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nOpeningBalanceTotActive + "</b></font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
				//		+ nOpeningBalanceTotQuar + "</b></font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
				//		+ nOpeningBalanceTotRej + "</b></font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nRecTotActive + "</b></font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
				//		+ nRecTotQuar + "</b></font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
				//		+ nRecTotRej + "</b></font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nIssueTotActive + "</b></font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
				//		+ nIssueTotQuar + "</b></font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
				//		+ nIssueTotRej + "</b></font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nClosingBalanceTotActive + "</b></font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
				//		+ nClosingBalanceTotQuar + "</b></font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
				//		+ nClosingBalanceTotRej + "</b></font></td>");
				br.append("</tr>");

			} else {
				// no data found code here
				brPagination.append("<table width='95%' align='center' cellspacing='1px' cellpadding='1px'>");
				brPagination.append("<tr><td colspan='14' class='TITLE'>Stock Ledger</td></tr>");
				brPagination.append("<tr><td colspan='14' align='center'><Strong>No Data Found</Strong></td></tr>");
				brPagination.append("</table>");
			}

			br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			br.append("<tr><td colspan='15'><hr></td></tr>");
			br.append("<tr> ");
			br.append("<td colspan='15' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >***End Of Report***</font></td> ");
			br.append("</tr> ");
			br.append("</table><input type='hidden' name='hmode'/><input type='hidden' name='strHtmlCode' value='' /></form></body></HEAD></HTML>");

		} catch (Exception e) {

			// e.printStackTrace();

			throw e;
		}
		return br.toString();

	}
	public String getConsolidatedStockLedgerRptBatch(StockLedgerForSubStoresRptItemNewVO vo, HttpServletRequest request) throws Exception {
		StringBuffer br = new StringBuffer(1000);
		StringBuffer brPagination = new StringBuffer(3000);

		WebRowSet ws = null;

		String prevItemId = "";
		String prevItemName = "";
		String prevBatch = "";
		String prevExpiry = "";

		String strFromDate = "";
		String strToDate = "";
		String strCheckHidValue = "";

		final int REC_PER_PAGE = 100;
		String strCssClass = "multiRPTControl";

		int nFromDay = 0;
		int nToDay = 0;
		int nFromMonth = 0;
		int nToMonth = 0;
		int nFromYear = 0;
		int nToYear = 0;

		int counter = 0;
		int pageCounter = 0;
		int pageSize = 1;
		int sNo = 1;

		long nOpeningBalanceActive = 0L;

		long nClosingBalanceActive = 0L;

		long nIssueActive = 0L;

		long nRecActive = 0L;

		long nOpeningBalanceTotActive = 0L;

		long nClosingBalanceTotActive = 0L;

		long nIssueTotActive = 0L;
		
		long nRecTotActive = 0L;

		long totIssueRecQty = 0L;
		String strTableWidth = "100%",strStoreName="";

		try 
		{
			
			System.out.println("------------- StockLedgerForSubStoresRptItemNewHLP.getConsolidatedStockLedgerRptBatch() --------------");
			ws = vo.getWrsData();

			br.append(getHeader(6).toString());

			strFromDate = vo.getStrFromDate();
			strToDate = vo.getStrToDate();

			nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
			nToDay = Integer.parseInt(strToDate.split("\\-")[0]);

			nFromMonth = getMonthInNumbers(strFromDate.split("\\-")[1]);
			nToMonth = getMonthInNumbers(strToDate.split("\\-")[1]);

			nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
			nToYear = Integer.parseInt(strToDate.split("\\-")[2]);

			if (ws != null && ws.size() > 0) 
			{
								
			
				if (ws.next()) 
				{
					strStoreName = ws.getString(4);						
				}
				ws.beforeFirst();
				

				while (ws.next()) 
				{
					if ((!prevItemId.equals(ws.getString(3)) || !prevBatch.equals(ws.getString(6))) && counter > 0) 
					{
						if ((sNo) % 2 == 0) 
						{
							strCssClass = "";
						} 
						else 
						{
							strCssClass = "";
						}

						strCheckHidValue =	prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
						nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;

						
						br.append("<tr id='tr'>");
						
						// br.append("<tr>");
						br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");

						br.append("<td class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");

						br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='35%'>" + prevItemName + "</td>");

						br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='8%'>" + prevBatch + "</td>");
						br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='7%'>" + prevExpiry + "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceActive
								+ "</td>");					
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecActive + "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueActive + "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceActive
								+ "</td>");

						totIssueRecQty = nRecActive  + nIssueActive;

						br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
						br.append("</tr>");

						// grand total
						nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;
						
						nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;

						nIssueTotActive = nIssueTotActive + nIssueActive;

						nRecTotActive = nRecTotActive + nRecActive;

						// reset
						nOpeningBalanceActive = 0L;
						nClosingBalanceActive = 0L;
						nIssueActive = 0L;
						nRecActive = 0L;
						pageCounter++;
						sNo++;
					}

					nOpeningBalanceActive = nOpeningBalanceActive + Long.parseLong(ws.getString(7));
					nIssueActive = nIssueActive + Long.parseLong(ws.getString(8));
					nRecActive = nRecActive + Long.parseLong(ws.getString(9));

					prevItemId = ws.getString(3);
					prevItemName = ws.getString(5);
					prevBatch = ws.getString(6);
					prevExpiry = ws.getString(10);

					counter++;
				}

				// last row
				if ((sNo) % 2 == 0) {
					strCssClass = "";
				} else {
					strCssClass = "";
				}

				strCheckHidValue = prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
				nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;

				
				br.append("<tr id='tr'>");
				
				// br.append("<tr>");
				br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
				br.append("<td class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");
				br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='35%'>"+ prevItemName + "</td>");
				br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='8%'>" + prevBatch + "</td>");
				br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='7%'>" + prevExpiry + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nOpeningBalanceActive + "</td>");			
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nRecActive + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nIssueActive + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nClosingBalanceActive + "</td>");

				totIssueRecQty = nRecActive + nIssueActive;
				br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");

				br.append("</tr>");

				// grand total
				nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;

				nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;

				nIssueTotActive = nIssueTotActive + nIssueActive;

				nRecTotActive = nRecTotActive + nRecActive;
				
				
				br.append("<tr bgcolor='' id='tr'>");
				br.append("<td style=\"text-align: right;\"  colspan='4' width='35%'><b>Grand Total</b></td>");
				br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><b>" + nOpeningBalanceTotActive	+ "</b></td>");	
				br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><b>" + nRecTotActive + "</b></td>");	
				br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><b>" + nIssueTotActive + "</b></td>");
				br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><b>" + nClosingBalanceTotActive	+ "</b></td>");
				br.append("</tr>");
				
				
				
				
				brPagination.append(
						"<HTML><HEAD><script language='Javascript' src='../../mms/js/stockledgerForSubStores_mmsrpt.js'></script><script language='JavaScript' src='../../hisglobal/jquery/3.6.0.min.js'></script>"
								+ "<script language='Javascript' src='../../hisglobal/js/innerxhtml.js'></script>"
								+ "<body><form action='/INVMGM/mms/reports/StockLedgerForSubStoresRptItemNewCNT.cnt' method='post'><div id='consolidatedBatchWiseStockLedgerRptDivId'>");
				
				brPagination.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
				brPagination.append("<tr> ");
				brPagination.append("<td align='right'>");
				brPagination.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'> <div id='printImg'>");
				brPagination.append("<img style='cursor: pointer; ' title='Print Page'  ");
				brPagination.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printThis();' /> "					
						//+ "<img style='cursor: pointer; ' title='Save as Excel' src='../../hisglobal/images/excel1.png' onClick='generateXLS(event,\"consolidatedBatchWiseStockLedgerRptDivId\");' /> "
						+ "<img style='cursor: pointer; ' title='Cancel Process'  ");
				brPagination.append(" src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div>");
				brPagination.append(" </td> ");
				brPagination.append(" </tr> ");
				brPagination.append(" </table> ");
				
				brPagination.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0'> ");
				brPagination.append("<tr><td width='10%' colspan='1'  align='right'><div  align='right'></div></td> ");
				brPagination.append("<td width='80%' colspan='12' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
				brPagination.append("Stock Ledger ");
				brPagination.append("</font></b></td><td colspan='1' width='10%'></td> ");
				brPagination.append("</tr> ");
				
				brPagination.append("<tr> ");
				brPagination.append("<td width='10%' colspan='1'></td> ");
				brPagination.append("<td width='80%' colspan='" + 12 + "' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
				brPagination.append("Store Name : " + strStoreName + "<br>");
				brPagination.append("</font></b></td><td width='10%' colspan='1'> ");
				brPagination.append("</td> ");
				brPagination.append("</tr> ");
				
				brPagination.append("<tr> ");
				brPagination.append("<td width='10%' colspan='1' ></td> ");
				brPagination.append("<td width='80%' colspan='12' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
				brPagination.append("Between : " + vo.getStrFromDate() + " And " + vo.getStrToDate());
				brPagination.append("</font></b></td><td width='10%' colspan='1' > ");
				brPagination.append("</td> ");
				brPagination.append("</tr> ");
				brPagination.append("</table> ");
				
				brPagination.append( "<table align='center' width='").append(strTableWidth).append("' border='1' cellspacing='0' cellpadding='0''> ");

				//brPagination.append("<tr>");
				//brPagination.append("<td class='LABEL' colspan='16'>");
				
				//brPagination.append("</td></tr>");
				brPagination.append(br);
				brPagination.append("</table></div></HEAD></HTML>");

			} else {
				// no data found code here
				brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
				brPagination.append("<tr><td class='TITLE'>Stock Ledger</td></tr>");
				brPagination.append("<tr><td align='center'><Strong>No Data Found</Strong></td></tr>");
				brPagination.append("</table>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("StockLedgerForSubStoresRptItemNewHLP.getConsolidatedStockLedgerRptBatch()->" + e.getMessage());
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}

		return brPagination.toString();

	}
	
	


	/*
	 * Value Pass in Web Row Set 1 HSTNUM_MONTH, 2 HSTNUM_YEAR, 3 HSTNUM_STORE_ID, 4 HSTNUM_ITEMBRAND_ID, 5 STR_NAME, 6 ITEM_NAME, 7 BATCH_NO, 8
	 * HSTSTR_ACTIVE_OPBALANCE_QTY, 9 HSTSTR_QUAR_OPBALANCE_QTY, 10 HSTSTR_REJ_OPBALANCE_QTY, 11 HSTSTR_ISSUEQTY_DAY1, 12 HSTSTR_RECQTY_DAY1, 13
	 * HSTSTR_ISSUEQTY_DAY2, 14 HSTSTR_RECQTY_DAY2, 15 HSTSTR_ISSUEQTY_DAY3, 16 HSTSTR_RECQTY_DAY3, 17 HSTSTR_ISSUEQTY_DAY4, 18 HSTSTR_RECQTY_DAY4, 19
	 * HSTSTR_ISSUEQTY_DAY5, 20 HSTSTR_RECQTY_DAY5, 21 HSTSTR_ISSUEQTY_DAY6, 22 HSTSTR_RECQTY_DAY6, 23 HSTSTR_ISSUEQTY_DAY7, 24 HSTSTR_RECQTY_DAY7, 25
	 * HSTSTR_ISSUEQTY_DAY8, 26 HSTSTR_RECQTY_DAY8, 27 HSTSTR_ISSUEQTY_DAY9, 28 HSTSTR_RECQTY_DAY9, 29 HSTSTR_ISSUEQTY_DAY10, 30 HSTSTR_RECQTY_DAY10,
	 * 31 HSTSTR_ISSUEQTY_DAY11, 32 HSTSTR_RECQTY_DAY11, 33 HSTSTR_ISSUEQTY_DAY12, 34 HSTSTR_RECQTY_DAY12, 35 HSTSTR_ISSUEQTY_DAY13, 36
	 * HSTSTR_RECQTY_DAY13, 37 HSTSTR_ISSUEQTY_DAY14, 38 HSTSTR_RECQTY_DAY14, 39 HSTSTR_ISSUEQTY_DAY15, 40 HSTSTR_RECQTY_DAY15, 41
	 * HSTSTR_ISSUEQTY_DAY16, 42 HSTSTR_RECQTY_DAY16, 43 HSTSTR_ISSUEQTY_DAY17, 44 HSTSTR_RECQTY_DAY17, 45 HSTSTR_ISSUEQTY_DAY18, 46
	 * HSTSTR_RECQTY_DAY18, 47 HSTSTR_ISSUEQTY_DAY19, 48 HSTSTR_RECQTY_DAY19, 49 HSTSTR_ISSUEQTY_DAY20, 50 HSTSTR_RECQTY_DAY20, 51
	 * HSTSTR_ISSUEQTY_DAY21, 52 HSTSTR_RECQTY_DAY21, 53 HSTSTR_ISSUEQTY_DAY22, 54 HSTSTR_RECQTY_DAY22, 55 HSTSTR_ISSUEQTY_DAY23, 56
	 * HSTSTR_RECQTY_DAY23, 57 HSTSTR_ISSUEQTY_DAY24, 58 HSTSTR_RECQTY_DAY24, 59 HSTSTR_ISSUEQTY_DAY25, 60 HSTSTR_RECQTY_DAY25, 61
	 * HSTSTR_ISSUEQTY_DAY26, 62 HSTSTR_RECQTY_DAY26, 63 HSTSTR_ISSUEQTY_DAY27, 64 HSTSTR_RECQTY_DAY27, 65 HSTSTR_ISSUEQTY_DAY28, 66
	 * HSTSTR_RECQTY_DAY28, 67 HSTSTR_ISSUEQTY_DAY29, 68 HSTSTR_RECQTY_DAY29, 69 HSTSTR_ISSUEQTY_DAY30, 70 HSTSTR_RECQTY_DAY30, 71
	 * HSTSTR_ISSUEQTY_DAY31, 72 HSTSTR_RECQTY_DAY31, 73 HSTSTR_TOTAL_ACTIVE_ISSUEQTY, 74 HSTSTR_TOTAL_QUAR_ISSUEQTY, 75 HSTSTR_TOTAL_REJ_ISSUEQTY, 76
	 * HSTSTR_TOTAL_ACTIVE_RECQTY, 77 HSTSTR_TOTAL_QUAR_RECQTY, 78 HSTSTR_TOTAL_REJ_RECQTY 79 EXPIRY DATE
	 */
	// To get Consolidated Stock Ledger Rpt Batch wise
	/**
	 * Gets the consolidated stock ledger rpt batch.
	 * 
	 * @param vo the vo
	 * @param request the request
	 * @return the consolidated stock ledger rpt batch
	 * @throws Exception the exception
	 */
	public String getConsolidatedStockLedgerRptBatch_OLD(StockLedgerForSubStoresRptItemNewVO vo, HttpServletRequest request) throws Exception {
		

		StringBuffer br = new StringBuffer(1000);

		WebRowSet ws = null;
		String strTableWidth = "100%";
		String prevItemId = "";
		String prevItemName = "";
		String prevBatch = "";
		String prevExpiry = "";

		String strFromDate = "";
		String strToDate = "";

		int nFromDay = 0;
		int nToDay = 0;
		int nFromMonth = 0;
		int nToMonth = 0;
		int nFromYear = 0;
		int nToYear = 0;

		int counter = 0;
		int sNo = 1;

		long nOpeningBalanceActive = 0L;
		long nOpeningBalanceQuar = 0L;
		long nOpeningBalanceRej = 0L;

		long nClosingBalanceActive = 0L;
		long nClosingBalanceQuar = 0L;
		long nClosingBalanceRej = 0L;

		long nIssueActive = 0L;
		long nIssueQuar = 0L;
		long nIssueRej = 0L;

		long nRecActive = 0L;
		long nRecQuar = 0L;
		long nRecRej = 0L;

		long nOpeningBalanceTotActive = 0L;
		long nOpeningBalanceTotQuar = 0L;
		long nOpeningBalanceTotRej = 0L;

		long nClosingBalanceTotActive = 0L;
		long nClosingBalanceTotQuar = 0L;
		long nClosingBalanceTotRej = 0L;

		long nIssueTotActive = 0L;
		long nIssueTotQuar = 0L;
		long nIssueTotRej = 0L;

		long nRecTotActive = 0L;
		long nRecTotQuar = 0L;
		long nRecTotRej = 0L;

		String[] tempArr;
		String[] tempArr1;
		String strStoreName = "";
		String strDrugName = "";
		String strExpiryDate = "";
		String strBatchNo = "";
		try {
			ws = vo.getWrsData();

			if (sNo == 1) {
				if (ws != null && ws.size() > 0) {
					if (ws.next()) {
						strStoreName = ws.getString(5);
						strDrugName = ws.getString(6);
						strBatchNo = ws.getString(7);
						strExpiryDate = ws.getString(10);
					}
					ws.beforeFirst();
				}
			}

			if (vo.getStrItemBrandId() == null || vo.getStrItemBrandId().equals("0")) {
				vo.setStrDrugName("All");
			}

			br.append(
					"<HTML><HEAD><script language='Javascript' src='../../mms/js/stockledgerForSubStores_mmsrpt.js'></script><script language='JavaScript' src='../../hisglobal/jquery/3.6.0.min.js'></script>"
							+ "<script language='Javascript' src='../../hisglobal/js/innerxhtml.js'></script>"
							+ "<body><form action='/INVMGM/mms/reports/StockLedgerForSubStoresRptItemNewCNT.cnt' method='post'><div id='consolidatedBatchWiseStockLedgerRptDivId'>"
							+ "" + "<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0''> ");
			try {
				br.append("<td colspan='1' width='10%' align='center'><div  align='center'> <img  align='absmiddle' src='http://" + request.getServerName() + ":"
						+ request.getServerPort() + " Voucher Report'/></div></td>");
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		
			br.append("</tr> ");
			br.append("</table> ");
			br.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0'> ");
			br.append("<tr><td width='10%' colspan='1'  align='right'><div  align='right'></div></td> ");
			br.append("<td width='80%' colspan='12' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
			br.append("Stock Ledger ");
			br.append("</font></b></td><td colspan='1' width='10%'></td> ");
			br.append("</tr> ");

			br.append("<tr> ");
			br.append("<td width='10%' colspan='1' ></td> ");
			br.append("<td width='80%' colspan='12'  align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
			br.append("Store Name: " + strStoreName + "<br>");
			br.append("Drug  Name: " + strDrugName + "<br>");
			br.append("</font></b></td><td width='10%' colspan='1' > ");
			br.append("</td> ");
			br.append("</tr> ");

			if (!vo.getStrItemBrandId().equals("0")) {
				br.append("<tr> ");
				br.append("<td width='10%' colspan='1' ></td> ");
				br.append("<td width='80%' colspan='12' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
				br.append("Batch No : " + strBatchNo + "<br>");
				br.append("Expiry Date : " + strExpiryDate + "<br>");
				br.append("</font></b></td><td width='10%' colspan='1' > ");
				br.append("</td> ");
				br.append("</tr> ");
			}

			br.append("<tr> ");
			br.append("<td width='10%' colspan='1' ></td> ");
			br.append("<td width='80%' colspan='12' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
			br.append("Between : " + vo.getStrFromDate() + " And " + vo.getStrToDate());
			br.append("</font></b></td><td width='10%' colspan='1' > ");
			br.append("</td> ");
			br.append("</tr> ");
			br.append("</table> ");

			br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			br.append("<tr> ");
			br.append("<td align='right'>");
			br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'> <div id='printImg'>");
			br.append("<img style='cursor: pointer; ' title='Print Page'  ");
			br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printThis();' /> "
					//+ "<img style='cursor: pointer; ' title='Save as Pdf' src='../../hisglobal/images/pdf.jpg' onClick='generatePdf(\"consolidatedBatchWiseStockLedgerRptDivId\");' /> "
					+ "<img style='cursor: pointer; ' title='Save as Excel' src='../../hisglobal/images/excel1.png' onClick='generateXLS(event,\"consolidatedBatchWiseStockLedgerRptDivId\");' /> "
					+ "<img style='cursor: pointer; ' title='Cancel Process'  ");
			br.append(" src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div>");
			br.append(" </td> ");
			br.append(" </tr> ");
			br.append(" </table> ");

			// Details
			br.append("<table cellspacing='0' border='1' cellpadding='0' width='").append(strTableWidth).append("' align='center'> ");
			br.append("<tr bgcolor='#cdc9c9'> ");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No</b></font></td>");
			br.append("<td style=\"text-align: center;\" style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Opening Balance</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty </b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Closing Balance</b></font></td>");
			br.append("</tr>");

			/*br.append("<tr bgcolor='#cdc9c9'> ");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");

			// Opening Balance
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Ready_for_issue")+"</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Rejected")+"</b></font></td>");
			//br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Qty_in_quarantine")+"</b></font></td>");
			// Received Balance
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Ready_for_issue")+"</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Rejected")+"</b></font></td>");
			//br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Qty_in_quarantine")+"</b></font></td>");
			// Issued Balance
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Ready_for_issue")+"</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Rejected")+"</b></font></td>");
			//br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Qty_in_quarantine")+"</b></font></td>");
			// Closing Balance
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Ready_for_issue")+"</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Rejected")+"</b></font></td>");
			//br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Qty_in_quarantine")+"</b></font></td>");
			br.append("</tr>");*/

			strFromDate = vo.getStrFromDate();
			strToDate = vo.getStrToDate();

			nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
			nToDay = Integer.parseInt(strToDate.split("\\-")[0]);

			nFromMonth = getMonthInNumbers(strFromDate.split("\\-")[1]);
			nToMonth = getMonthInNumbers(strToDate.split("\\-")[1]);

			nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
			nToYear = Integer.parseInt(strToDate.split("\\-")[2]);

			if (ws != null && ws.size() > 0) {

				while (ws.next()) {
					if ((!prevItemId.equals(ws.getString(4)) || !prevBatch.equals(ws.getString(7))) && counter > 0) {
						nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
						nClosingBalanceQuar = nOpeningBalanceQuar + nRecQuar - nIssueQuar;
						nClosingBalanceRej = nOpeningBalanceRej + nRecRej - nIssueRej;

						br.append("<tr> ");
						br.append("<td colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + sNo
								+ "</b></font></td>");
						br.append("<td style=\"text-align: left;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ prevItemName + "</font></td>");
						br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ prevBatch + "</font></td>");
						br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ prevExpiry + "</font></td>");

						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nOpeningBalanceActive + "</font></td>");
					//	br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
					//			+ nOpeningBalanceQuar + "</font></td>");
						//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						//		+ nOpeningBalanceRej + "</font></td>");

						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nRecActive + "</font></td>");
					//	br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
					//			+ nRecQuar + "</font></td>");
						//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						//		+ nRecRej + "</font></td>");

						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nIssueActive + "</font></td>");
					//	br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
					//			+ nIssueQuar + "</font></td>");
					//	br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
					//			+ nIssueRej + "</font></td>");

						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nClosingBalanceActive + "</font></td>");
						//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						//		+ nClosingBalanceQuar + "</font></td>");
					//	br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
					//			+ nClosingBalanceRej + "</font></td>");

						br.append("</tr>");

						// grand total
						nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;
						nOpeningBalanceTotQuar = nOpeningBalanceTotQuar + nOpeningBalanceQuar;
						nOpeningBalanceTotRej = nOpeningBalanceTotRej + nOpeningBalanceRej;

						nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;
						nClosingBalanceTotQuar = nClosingBalanceTotQuar + nClosingBalanceQuar;
						nClosingBalanceTotRej = nClosingBalanceTotRej + nClosingBalanceRej;

						nIssueTotActive = nIssueTotActive + nIssueActive;
						nIssueTotQuar = nIssueTotQuar + nIssueQuar;
						nIssueTotRej = nIssueTotRej + nIssueRej;

						nRecTotActive = nRecTotActive + nRecActive;
						nRecTotQuar = nRecTotQuar + nRecQuar;
						nRecTotRej = nRecTotRej + nRecRej;

						// reset
						nOpeningBalanceActive = 0L;
						nOpeningBalanceQuar = 0L;
						nOpeningBalanceRej = 0L;
						nClosingBalanceActive = 0L;
						nClosingBalanceQuar = 0L;
						nClosingBalanceRej = 0L;
						nIssueActive = 0L;
						nIssueQuar = 0L;
						nIssueRej = 0L;
						nRecActive = 0L;
						nRecQuar = 0L;
						nRecRej = 0L;
						sNo++;
					}

					if (nFromMonth == Integer.parseInt(ws.getString(1)) && nFromYear == Integer.parseInt(ws.getString(2))) {
						tempArr = getOpeningBalance(ws, nFromDay).split("\\^");
						nOpeningBalanceActive = nOpeningBalanceActive + Long.parseLong(tempArr[0].split("\\.")[0]);
						nOpeningBalanceQuar = nOpeningBalanceQuar + Long.parseLong(tempArr[1].split("\\.")[0]);
						nOpeningBalanceRej = nOpeningBalanceRej + Long.parseLong(tempArr[2].split("\\.")[0]);
					}

					tempArr = getReceivedAndIssuedQty(ws, nFromDay, nFromMonth, nFromYear, nToDay, nToMonth, nToYear).split("\\#");
					tempArr1 = tempArr[0].split("\\^");

					nIssueActive = nIssueActive + Long.parseLong(tempArr1[0].split("\\.")[0]);
					nIssueQuar = nIssueQuar + Long.parseLong(tempArr1[1].split("\\.")[0]);
					nIssueRej = nIssueRej + Long.parseLong(tempArr1[2].split("\\.")[0]);

					tempArr1 = tempArr[1].split("\\^");

					nRecActive = nRecActive + Long.parseLong(tempArr1[0].split("\\.")[0]);
					nRecQuar = nRecQuar + Long.parseLong(tempArr1[1].split("\\.")[0]);
					nRecRej = nRecRej + Long.parseLong(tempArr1[2].split("\\.")[0]);

					prevItemId = ws.getString(4);
					prevItemName = ws.getString(6);
					prevBatch = ws.getString(7);
					prevExpiry = ws.getString(10);

					counter++;
				}

				// last row
				nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
				nClosingBalanceQuar = nOpeningBalanceQuar + nRecQuar - nIssueQuar;
				nClosingBalanceRej = nOpeningBalanceRej + nRecRej - nIssueRej;

				br.append("<tr> ");
				br.append("<td colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + sNo + "</font></td>");
				br.append("<td style=\"text-align: left;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ prevItemName + "</font></td>");
				br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ prevBatch + "</font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ prevExpiry + "</font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nOpeningBalanceActive + "</font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
				//		+ nOpeningBalanceQuar + "</font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
				//		+ nOpeningBalanceRej + "</font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nRecActive + "</font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
				//		+ nRecQuar + "</font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
				//		+ nRecRej + "</font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nIssueActive + "</font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
				//		+ nIssueQuar + "</font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
				//		+ nIssueRej + "</font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nClosingBalanceActive + "</font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
			///			+ nClosingBalanceQuar + "</font></td>");
			//	br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
				//		+ nClosingBalanceRej + "</font></td>");

				br.append("</tr>");

				// grand total
				nOpeningBalanceTotActive = nOpeningBalanceTotActive + nOpeningBalanceActive;
				nOpeningBalanceTotQuar = nOpeningBalanceTotQuar + nOpeningBalanceQuar;
				nOpeningBalanceTotRej = nOpeningBalanceTotRej + nOpeningBalanceRej;

				nClosingBalanceTotActive = nClosingBalanceTotActive + nClosingBalanceActive;
				nClosingBalanceTotQuar = nClosingBalanceTotQuar + nClosingBalanceQuar;
				nClosingBalanceTotRej = nClosingBalanceTotRej + nClosingBalanceRej;

				nIssueTotActive = nIssueTotActive + nIssueActive;
				nIssueTotQuar = nIssueTotQuar + nIssueQuar;
				nIssueTotRej = nIssueTotRej + nIssueRej;

				nRecTotActive = nRecTotActive + nRecActive;
				nRecTotQuar = nRecTotQuar + nRecQuar;
				nRecTotRej = nRecTotRej + nRecRej;

				// grand total
				br.append("<tr bgcolor='#cdc9c9'> ");
				br.append("<td style=\"text-align: right;\" colspan='4' width='35%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b> Grand Total</b></font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nOpeningBalanceTotActive + "</b></font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
				//		+ nOpeningBalanceTotQuar + "</b></font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
				//		+ nOpeningBalanceTotRej + "</b></font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nRecTotActive + "</b></font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
				//		+ nRecTotQuar + "</b></font></td>");
			//	br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
			//			+ nRecTotRej + "</b></font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nIssueTotActive + "</b></font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
				//		+ nIssueTotQuar + "</b></font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
				//		+ nIssueTotRej + "</b></font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nClosingBalanceTotActive + "</b></font></td>");
				//br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
				//		+ nClosingBalanceTotQuar + "</b></font></td>");
			//	br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
				//		+ nClosingBalanceTotRej + "</b></font></td>");
				br.append("</tr>");
			} else {
				// no data found code here
				br.append("<table width='95%' align='center' cellspacing='1px' cellpadding='1px'>");
				br.append("<tr><td class='TITLE'> Stock Ledger</td></tr>");
				br.append("<tr><td align='center'><Strong>No Data Found</Strong></td></tr>");
				br.append("</table>");
			}
			br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			br.append("<tr><td colspan='15'><hr></td></tr>");
			br.append("<tr> ");
			br.append("<td colspan='15' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >***End Of Report***</font></td> ");
			br.append("</tr> ");
			br.append("</table><input type='hidden' name='hmode'/><input type='hidden' name='strHtmlCode' value='' /></form></body></HEAD></HTML>");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("StockLedgerForSubStoresRptItemNewHLP.getStockLedgerDtl()->" + e.getMessage());
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}

		return br.toString();

	}

	/*
	 * 1 >> Trans Date 2 >> Particulars 3 >> Active issue 4 >> In-Active Issue 5 >> Quar Issue 6 >> Active Rec 7 >> In-Active Rec 8 >> Quar Rec 9 >>
	 * Store Name 10 >> Item Name 11 >> Batch No 12 >> Expiry Date
	 */
	// To get Report for Detailed Stock Ledger
	/**
	 * Gets the detailed stock ledger rpt.
	 * 
	 * @param vo the vo
	 * @param request the request
	 * @return the detailed stock ledger rpt
	 * @throws Exception the exception
	 */
	public String getDetailedStockLedgerRpt(StockLedgerForSubStoresRptItemNewVO vo, HttpServletRequest request) throws Exception {
		

		StringBuffer br = new StringBuffer(1000);

		String strStoreName = "";
		String strDrugName = "";
		String strExpiryDate = "";
		String strTableWidth = "100%";
		int sNo = 1;
		int nColspan = 0;

		long nRecQty = 0L;
		long nIssueQty = 0L;

		long nBalanceActiveQty = 0L;
		long nBalanceQuarQty = 0L;
		long nBalanceRejQty = 0L;
		long nBalanceQty = 0L;
		double rate = 0.0;
		WebRowSet ws = null;
		String[] tempArr;
		String col = "10";
		String strRecString = "", strIssueString = "";
		try {

			tempArr = vo.getStrOpeningBalance().split("\\#");
			nBalanceActiveQty = Long.parseLong(tempArr[0].split("\\.")[0]);
			nBalanceQuarQty = Long.parseLong(tempArr[1].split("\\.")[0]);
			nBalanceRejQty = Long.parseLong(tempArr[2].split("\\.")[0]);

			ws = vo.getWrsData();

			if (sNo == 1) {
				if (ws != null && ws.size() > 0) {
					if (ws.next()) {
						strStoreName = ws.getString(9);
						strDrugName = ws.getString(10);
						strExpiryDate = ws.getString(12);
						rate = Double.parseDouble((ws.getString(13)));
						ws.beforeFirst();
					}
				}
			}

			if (vo.getStrItemBrandId() == null || vo.getStrItemBrandId().equals("0")) {
				vo.setStrDrugName("All");
			}

			if (!vo.getStrBatchFlag().equals("0")) {
				col = "6";
			}

			br.append(
					"<HTML><HEAD><script language='Javascript' src='../../mms/js/stockledgerForSubStores_mmsrpt.js'></script><script language='JavaScript' src='../../hisglobal/jquery/3.6.0.min.js'></script>"
							+ "<script language='Javascript' src='../../hisglobal/js/innerxhtml.js'></script>"
							+ "<body><form action='/HBIMS/mms/reports/StockLedgerForSubStoresRptItemNewCNT.cnt' method='post'><div id='detailedStockLedgerRptDivId'>"
							+ "" + "<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0''> ");
			try {
				br.append("<tr><td colspan='" + col	+ "' width='100%'  align='center'><div  align='center'> <img  align='absmiddle' src='http://" + request.getServerName() + ":"
					+ request.getServerPort() + " Voucher Report'/></div></td> ");
			} catch (Exception e) {
				e.printStackTrace();
				
			}
//			br.append("<td width='10%' colspan='" + col
//					+ "' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
			br.append("</tr> ");
			br.append("</table> ");
			br.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0'> ");
			br.append("<tr><td width='10%' colspan='1'  align='right'><div  align='right'></div></td> ");
			br.append("<td width='80%' colspan='" + col + "' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
			br.append(" Stock Ledger ");
			br.append("</font></b></td><td colspan='1' width='10%'></td> ");
			br.append("</tr> ");

			br.append("<tr> ");
			br.append("<td width='10%' colspan='1'></td> ");
			br.append("<td width='80%' colspan='" + col + "' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
			br.append("Store Name : " + strStoreName + "<br>");
			br.append("Drug Name : " + strDrugName + "<br>");
			br.append("</font></b></td><td width='10%' colspan='1'> ");
			br.append("</td> ");
			br.append("</tr> ");

			if (!vo.getStrBatchNo().equals("0")) {
				br.append("<tr> ");
				br.append("<td width='10%' colspan='1'></td> ");
				br.append("<td width='80%' colspan='" + col + "' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
				br.append("Batch No : " + vo.getStrBatchNo() + "<br>");
				br.append("Expiry Date: " + strExpiryDate + "<br>");
				br.append("</font></b></td><td width='10%' colspan='1'> ");
				br.append("</td> ");
				br.append("</tr> ");
			}

			br.append("<tr> ");
			br.append("<td width='10%' colspan='1'></td> ");
			br.append("<td width='80%' colspan='" + col + "'align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
			br.append("Between : " + vo.getStrFromDate() + " And  " + vo.getStrToDate());
			br.append("</font></b></td><td width='10%' colspan='1'> ");
			br.append("</td> ");
			br.append("</tr> ");
			br.append("</table> ");

			br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			br.append("<tr> ");
			br.append("<td align='right'>");
			br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'> <div id='printImg'>");
			br.append("<img style='cursor: pointer; ' title='Print Page'  ");
			br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printThis();' /> "
					//+ "<img style='cursor: pointer; ' title='Save as Pdf' src='../../hisglobal/images/pdf.jpg' onClick='generatePdf(\"detailedStockLedgerRptDivId\");' /> "
					+ "<img style='cursor: pointer; ' title='Save as Excel' src='../../hisglobal/images/excel1.png' onClick='generateXLS(event,\"detailedStockLedgerRptDivId\");' /> "
					+ "<img style='cursor: pointer; ' title='Cancel Process'  ");
			br.append(" src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div>");
			br.append(" </td> ");
			br.append(" </tr> ");
			br.append(" </table> ");

			br.append("<table cellspacing='0' border='1' cellpadding='0' width='").append(strTableWidth).append("' align='center'> ");
			if (vo.getStrBatchNo().equals("0")) {
				br.append("<tr bgcolor='#cdc9c9'> ");
				br.append("<td colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Date</b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No</b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font></td>");
				br.append("<td colspan='1' width='25%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Particulars</b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty</b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b> Issued Qty</b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Balance</b></font></td>");
				br.append("</tr>");

				/*br.append("<tr bgcolor='#cdc9c9'> ");
				br.append("<td colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				br.append("<td colspan='1' width='25%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				// Closing Balance
				br.append("<td colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Ready_for_issue")+"</b></font></td>");
				//br.append("<td colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Qty_in_quarantine")+"</b></font></td>");
				br.append("<td colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Rejected")+"</b></font></td>");
				br.append("</tr>");*/

				nColspan = 10;
			} else {
				br.append("<tr bgcolor='#cdc9c9'> ");
				br.append("<td colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font></td>");
				br.append("<td colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Date</b></font></td>");
				br.append("<td colspan='1' width='35%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Particulars</b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty</b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty</b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Balance</b></font></td>");
				br.append("</tr>");

				br.append("<tr bgcolor='#cdc9c9'> ");
				br.append("<td colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				br.append("<td colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				br.append("<td colspan='1' width='35%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				// Closing Balance
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b> Ready For Issue </b></font></td>");
				//br.append("<td colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Qty_in_quarantine")+"</b></font></td>");
				//br.append("<td colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisLanguageProperties.getValue(request, "label.common.Rejected")+"</b></font></td>");
				br.append("</tr>");

				nColspan = 8;
			}

			// opening balance data
			if (vo.getStrBatchNo().equals("0")) {
				br.append("<tr>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ sNo + "</font></b></td>");

				br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ vo.getStrFromDate() + "</font></b></td>");
				br.append("<td style=\"text-align: left;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>--</font></b></td>");
				br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>--</font></b></td>");
				br.append("<td style=\"text-align: left;\"  colspan='1' width='25%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b> Opening Balance </font></b></td>");
				br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>--</font></b></td>");
				br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>--</font></b></td>");

				br.append("<td style=\"text-align: right;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nBalanceActiveQty + "</font></b></td>");
				//br.append("<td style=\"text-align: right;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
				//		+ nBalanceQuarQty + "</font></b></td>");
				//br.append("<td style=\"text-align: right;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
				//		+ nBalanceRejQty + "</font></b></td>");
				br.append("</tr>");
			} else {
				br.append("<tr>");
				br.append("<td style=\"text-align: center;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ sNo + "</font></b></td>");
				br.append("<td style=\"text-align: center;\"  colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ vo.getStrFromDate() + "</font></b></td>");
				br.append("<td style=\"text-align: left;\"  colspan='1' width='35%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b> Opening Balance</font></b></td>");
				br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>--</font></b></td>");
				br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>--</font></b></td>");

				br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nBalanceActiveQty + "</font></b></td>");
				//br.append("<td style=\"text-align: right;\"  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
				//		+ nBalanceQuarQty + "</font></b></td>");
			//	br.append("<td style=\"text-align: right;\"  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
			//			+ nBalanceRejQty + "</font></b></td>");
				br.append("</tr>");
			}

			sNo++;
			
			if (ws != null && ws.size() > 0) {
				while (ws.next()) {

					nRecQty = Long.parseLong(ws.getString(6)) + Long.parseLong(ws.getString(7)) + Long.parseLong(ws.getString(8));
					nIssueQty = Long.parseLong(ws.getString(3)) + Long.parseLong(ws.getString(4)) + Long.parseLong(ws.getString(5));

					if (nRecQty > 0) {
						if (Long.parseLong(ws.getString(6)) > 0) {
							//strRecString = "(A)";
						} //else if (Long.parseLong(ws.getString(7)) > 0) {
						//	strRecString = "(R)";
						//} //else if (Long.parseLong(ws.getString(8)) > 0) {
							//strRecString = "(Q)";
						//}
					} else {
						strRecString = "";
					}

					if (nIssueQty > 0) {
						if (Long.parseLong(ws.getString(3)) > 0) {
						//	strIssueString = "(A)";
						}// else if (Long.parseLong(ws.getString(4)) > 0) {
						//	strIssueString = "(R)";
						//} //else if (Long.parseLong(ws.getString(5)) > 0) {
							//strIssueString = "(Q)";
						//}
					} else {
						strIssueString = "";
					}

					nBalanceActiveQty = nBalanceActiveQty + Long.parseLong(ws.getString(6)) - Long.parseLong(ws.getString(3));
					nBalanceQuarQty = nBalanceQuarQty + Long.parseLong(ws.getString(8)) - Long.parseLong(ws.getString(5));
					nBalanceRejQty = nBalanceRejQty + Long.parseLong(ws.getString(7)) - Long.parseLong(ws.getString(4));

					nBalanceQty = nBalanceActiveQty + nBalanceQuarQty + nBalanceRejQty;

					br.append("<tr>");

					br.append("<td  style=\"text-align: center;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
							+ sNo + "</font></td>");

					if (vo.getStrBatchNo().equals("0")) {

						br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ ws.getString(1) + "</font></td>");
						br.append("<td style=\"text-align: left;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ ws.getString(11) + "</font></td>");
						br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ ws.getString(12) + "</font></td>");
						br.append("<td style=\"text-align: left;\"  colspan='1' width='25%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ ws.getString(2) + "</font></td>");
						br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nRecQty + strRecString + "</font></td>");
						br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nIssueQty + strIssueString + "</font></td>");

						br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nBalanceActiveQty + "</font></td>");
						//br.append("<td style=\"text-align: right;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						//		+ nBalanceQuarQty + "</font></td>");
						//br.append("<td style=\"text-align: right;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						//		+ nBalanceRejQty + "</font></td>");
					} else {
						br.append("<td style=\"text-align: center;\"  colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ ws.getString(1) + "</font></td>");
						br.append("<td style=\"text-align: left;\"  colspan='1' width='35%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ ws.getString(2) + "</font></td>");
						br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nRecQty + strRecString + "</font></td>");
						br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nIssueQty + strIssueString + "</font></td>");

						br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nBalanceActiveQty + "</font></td>");
						//br.append("<td style=\"text-align: right;\"  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						//		+ nBalanceQuarQty + "</font></td>");
						//br.append("<td style=\"text-align: right;\"  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						//		+ nBalanceRejQty + "</font></td>");
					}

					br.append("</tr>");

					if (sNo == 2) {
						strStoreName = ws.getString(9);
						strDrugName = ws.getString(10);
						strExpiryDate = ws.getString(12);
					}

					sNo++;
				}

				// Closing balance data
				br.append("<tr>");
				br.append("<td  style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ sNo + "</font></b></td>");

				if (vo.getStrBatchNo().equals("0")) {
					br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
							+ vo.getStrToDate() + "</font></b></td>");
					br.append("<td style=\"text-align: left;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>--</font></b></td>");
					br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>--</font></b></td>");
					br.append("<td style=\"text-align: left;\"  colspan='1' width='25%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b> Closing Balance</font></b></td>");
					br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
							+ nRecQty + "</font></b></td>");
					br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
							+ nIssueQty + "</font></b></td>");

					br.append("<td style=\"text-align: right;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
							+ nBalanceActiveQty + "</font></b></td>");
					//br.append("<td style=\"text-align: right;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
					//		+ nBalanceQuarQty + "</font></b></td>");
					//br.append("<td style=\"text-align: right;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
					//		+ nBalanceRejQty + "</font></b></td>");
				} else {
					br.append("<td style=\"text-align: center;\"  colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
							+ vo.getStrToDate() + "</font></b></td>");
					br.append("<td style=\"text-align: left;\"  colspan='1' width='35%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Closing Balance</font></b></td>");
					br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
							+ nRecQty + "</font></b></td>");
					br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
							+ nIssueQty + "</font></b></td>");

					br.append("<td style=\"text-align: right;\"  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
							+ nBalanceActiveQty + "</font></b></td>");
					//br.append("<td style=\"text-align: right;\"  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
					//		+ nBalanceQuarQty + "</font></b></td>");
				//	br.append("<td style=\"text-align: right;\"  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
				//			+ nBalanceRejQty + "</font></b></td>");
				}

				br.append("</tr>");
				br.append("<tr><td colspan='" + nColspan + "' class='TITLE'></td></tr>");

			}
			br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			br.append("<tr><td colspan='15'><hr></td></tr>");
			br.append("<tr> ");
			br.append("<td colspan='12' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >***End Of Report***</font></td> ");
			br.append("</tr> ");
			br.append("<tr>");
			br.append("<td><font size='2' color='BLUE'>");
			//br.append("<br>* (A)-Active");
			//br.append("<br>* (Q)-Quarantine");
			//br.append("<br>* (R)-Rejected");
			br.append("</td>");
			br.append("</tr>");
			br.append("</table><input type='hidden' name='hmode'/><input type='hidden' name='strHtmlCode' value='' /></form></body></HEAD></HTML>");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("StockLedgerForSubStoresRptItemNewHLP.getDetailedStockLedgerDtl()->" + e.getMessage());
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}

		return br.toString();

	}

}
