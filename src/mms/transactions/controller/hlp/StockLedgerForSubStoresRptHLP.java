/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         StockLedgerForSubStoresRptHLP.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.hlp;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import mms.reports.vo.StockLedgerForSubStoresRptVO;

/**
 * Developer : Vivek Aggarwal Version : 1.0 Date : 16-Mar-2012 Modification Date:
 * 
 */
public class StockLedgerForSubStoresRptHLP {
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
	public String getStockLedgerDtl(StockLedgerForSubStoresRptVO vo, HttpServletRequest request) throws Exception {
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
		long totIssueRecQty = 0L;

		String[] tempArr;
		String[] tempArr1;

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

				while (ws.next()) {
					if (!prevItemId.equals(ws.getString(4)) && counter > 0) {
						if ((sNo) % 2 == 0) {
							strCssClass = "multiRPTControl";
						} else {
							strCssClass = "multiRPTControl1";
						}

						strCheckHidValue = prevItemId + "^0^" + nOpeningBalanceActive + "^" + nOpeningBalanceQuar + "^" + nOpeningBalanceRej;
						nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
						nClosingBalanceQuar = nOpeningBalanceQuar + nRecQuar - nIssueQuar;
						nClosingBalanceRej = nOpeningBalanceRej + nRecRej - nIssueRej;

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
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceQuar
								+ "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceRej
								+ "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecActive + "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecQuar + "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecRej + "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueActive + "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueQuar + "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueRej + "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceActive
								+ "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceQuar
								+ "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceRej
								+ "</td>");

						totIssueRecQty = nRecActive + nRecQuar + nRecRej + nIssueActive + nIssueQuar + nIssueRej;
						br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");

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
						pageCounter++;
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
					counter++;
				}

				// last row
				if ((sNo) % 2 == 0) {
					strCssClass = "multiRPTControl";
				} else {
					strCssClass = "multiRPTControl1";
				}

				strCheckHidValue = prevItemId + "^0^" + nOpeningBalanceActive + "^" + nOpeningBalanceQuar + "^" + nOpeningBalanceRej;
				nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
				nClosingBalanceQuar = nOpeningBalanceQuar + nRecQuar - nIssueQuar;
				nClosingBalanceRej = nOpeningBalanceRej + nRecRej - nIssueRej;

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
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceQuar + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceRej + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecActive + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecQuar + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecRej + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueActive + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueQuar + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueRej + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceActive + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceQuar + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceRej + "</td>");

				totIssueRecQty = nRecActive + nRecQuar + nRecRej + nIssueActive + nIssueQuar + nIssueRej;
				br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");

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
				pageCounter = pageCounter + 1;

				if (pageSize == 1) {
					br.append("<tr bgcolor='#EFEFF7' id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
				} else {
					br.append("<tr bgcolor='#EFEFF7' id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
				}

				// br.append("<tr>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='2' width='35%'><b>Grand Total</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nOpeningBalanceTotActive
						+ "</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nOpeningBalanceTotQuar
						+ "</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nOpeningBalanceTotRej + "</b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nRecTotActive + "</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nRecTotQuar + "</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nRecTotRej + "</b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nIssueTotActive + "</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nIssueTotQuar + "</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nIssueTotRej + "</b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nClosingBalanceTotActive
						+ "</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nClosingBalanceTotQuar
						+ "</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nClosingBalanceTotRej + "</b></td>");
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
				brPagination.append("<table width='95%' align='center'   cellpadding='1px'>");
				brPagination.append("<tr><td colspan='14' class='TITLE'>Stock Ledger</td></tr>");
				brPagination.append("<tr><td colspan='14' align='center'><Strong>No Data Found</Strong></td></tr>");
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
	 * HSTSTR_TOTAL_ACTIVE_RECQTY, 77 HSTSTR_TOTAL_QUAR_RECQTY, 78 HSTSTR_TOTAL_REJ_RECQTY, 79 EXPIRY DATE, 80 BASE_RATE, 
	 * 81 HSTNUM_PROGRAMME_ID, 82 HSTNUM_PO_NO, 83 PROG_NAME
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
	public String getStockLedgerDtlBatch(StockLedgerForSubStoresRptVO vo, HttpServletRequest request) throws Exception {
		StringBuffer br = new StringBuffer(1000);
		StringBuffer brPagination = new StringBuffer(3000);

		WebRowSet ws = null;

		String prevItemId = "";
		String prevItemName = "";
		String prevBatch = "", prevProgId="", prevProgName="";
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

		long totIssueRecQty = 0L;

		String[] tempArr;
		String[] tempArr1;

		try {
			ws = vo.getWrsData();

			br.append(getHeader(2).toString());

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
					if ((!prevItemId.equals(ws.getString(4)) || !prevBatch.equals(ws.getString(7)) || !prevProgId.equals(ws.getString(81))) && counter > 0) {
						if ((sNo) % 2 == 0) {
							strCssClass = "multiRPTControl";
						} else {
							strCssClass = "multiRPTControl1";
						}

						strCheckHidValue =
								prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive + "^" + nOpeningBalanceQuar + "^" + nOpeningBalanceRej+"^"+prevProgId;
						nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
						nClosingBalanceQuar = nOpeningBalanceQuar + nRecQuar - nIssueQuar;
						nClosingBalanceRej = nOpeningBalanceRej + nRecRej - nIssueRej;

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

						br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='15%'>"
								+ "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' "
								+ "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");

						br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='8%'>" + prevBatch + "</td>");
						br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='7%'>" + prevProgName + "</td>");
						br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='7%'>" + prevExpiry + "</td>");
						
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceActive
								+ "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceQuar
								+ "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceRej
								+ "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecActive + "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecQuar + "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecRej + "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueActive + "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueQuar + "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueRej + "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceActive
								+ "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceQuar
								+ "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceRej
								+ "</td>");

						totIssueRecQty = nRecActive + nRecQuar + nRecRej + nIssueActive + nIssueQuar + nIssueRej;

						br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
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
						pageCounter++;
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
					prevExpiry = ws.getString(79);
					prevProgId =  ws.getString(81);
					prevProgName =  ws.getString(83);

					counter++;
				}

				// last row
				if ((sNo) % 2 == 0) {
					strCssClass = "multiRPTControl";
				} else {
					strCssClass = "multiRPTControl1";
				}

				strCheckHidValue = prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive + "^" + nOpeningBalanceQuar + "^" + nOpeningBalanceRej+"^"+prevProgId;
				nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
				nClosingBalanceQuar = nOpeningBalanceQuar + nRecQuar - nIssueQuar;
				nClosingBalanceRej = nOpeningBalanceRej + nRecRej - nIssueRej;

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

				br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='15%'>"
						+ "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' "
						+ "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");

				br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='8%'>" + prevBatch + "</td>");
				br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='7%'>" + prevProgName + "</td>");
				br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='7%'>" + prevExpiry + "</td>");				

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceActive + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceQuar + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceRej + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecActive + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecQuar + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecRej + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueActive + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueQuar + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueRej + "</td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceActive + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceQuar + "</td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceRej + "</td>");

				totIssueRecQty = nRecActive + nRecQuar + nRecRej + nIssueActive + nIssueQuar + nIssueRej;
				br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");

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
				pageCounter = pageCounter + 1;

				if (pageSize == 1) {
					br.append("<tr bgcolor='#EFEFF7' id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
				} else {
					br.append("<tr bgcolor='#EFEFF7' id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
				}

				
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='5' width='35%'><b>Grand Total</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nOpeningBalanceTotActive
						+ "</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nOpeningBalanceTotQuar
						+ "</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nOpeningBalanceTotRej + "</b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nRecTotActive + "</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nRecTotQuar + "</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nRecTotRej + "</b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nIssueTotActive + "</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nIssueTotQuar + "</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nIssueTotRej + "</b></td>");

				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nClosingBalanceTotActive
						+ "</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nClosingBalanceTotQuar
						+ "</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nClosingBalanceTotRej + "</b></td>");
				br.append("</tr>");

				brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
				brPagination.append("<tr><td colspan='17' class='TITLE'>Stock Ledger</td></tr>");

				brPagination.append("<tr>");
				brPagination.append("<td class='LABEL' colspan='17'>");

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
				brPagination.append("<tr><td class='TITLE'>Stock Ledger</td></tr>");
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
	 * Gets the header.
	 * 
	 * @param callType the call type
	 * @return the header
	 */
	public StringBuffer getHeader(int callType) {
		StringBuffer brHeader = new StringBuffer(1000);

		// consolidated stock
		if (callType == 1) {
			brHeader.append("<tr>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>S. No.</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='30%'>Drug Name</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Opening Balance (No.)</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Received Qty. (No.)</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Issued Qty. (No.)</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Closing Balance (No.)</td>");
			brHeader.append("</tr>");

			brHeader.append("<tr>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='30%'></td>");

			// Opening Balance
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty. in Quarantine</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
			// Received Balance
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty. in Quarantine</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
			// Issued Balance
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty. in Quarantine</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
			// Closing Balance
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty. in Quarantine</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
			brHeader.append("</tr>");
		}

		// consolidated stock (batch wise)
		if (callType == 2) {
			brHeader.append("<tr>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>S. No.</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'>Drug Name</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Batch No.</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='7%'>Programme Name</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='7%'>Expiry Date</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Opening Balance (No.)</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Received Qty. (No.)</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Issued Qty. (No.)</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Closing Balance (No.)</td>");
			brHeader.append("</tr>");

			brHeader.append("<tr>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='7%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='7%'></td>");

			// Opening Balance
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty. in Quarantine</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
			// Received Balance
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty. in Quarantine</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
			// Issued Balance
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty. in Quarantine</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
			// Closing Balance
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty. in Quarantine</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
			brHeader.append("</tr>");
		}

		// detail as clicked on item name [with batch]
		if (callType == 3) {
			brHeader.append("<tr>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>S. No.</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'>Date</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='31%'>Particulars</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Received Qty. (No.)</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Issued Qty. (No.)</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='3' width='24%'>Balance (No.)</td>");
			brHeader.append("</tr>");

			brHeader.append("<tr>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='31%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'></td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'></td>");
			// Closing Balance
			brHeader.append("<td style='background-color: #EFEFF7; border-left: 1px solid #000000; color: #000000;"
					+ "font-family: Verdana,Arial,Helvetica,sans-serif;font-size: 10px;font-weight: bold;height: 12px; border-top:0px;"
					+ "text-align: center' colspan='1' width='8%'>Ready For Issue</td>");
			brHeader.append("<td style='background-color: #EFEFF7; border-left: 1px solid #000000; color: #000000;"
					+ "font-family: Verdana,Arial,Helvetica,sans-serif;font-size: 10px;font-weight: bold;height: 12px;border-top:0px;"
					+ "text-align: center' colspan='1' width='8%'>Qty. in Quarantine</td>");
			brHeader.append("<td style='background-color: #EFEFF7; border-left: 1px solid #000000; color: #000000;"
					+ "font-family: Verdana,Arial,Helvetica,sans-serif;font-size: 10px;font-weight: bold;height: 12px;border-top:0px;"
					+ "text-align: center' colspan='1' width='8%'>Rejected</td>");
			brHeader.append("</tr>");
		}

		// detail as clicked on item name [without batch]
		if (callType == 4) {
			brHeader.append("<tr>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>S. No.</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Date</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Batch No.</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Expiry</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'>Particulars</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Received Qty. (No.)</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Issued Qty. (No.)</td>");
			brHeader.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Balance (No.)</td>");
			brHeader.append("</tr>");

			brHeader.append("<tr>");
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
			brHeader.append("<td style='background-color: #EFEFF7; border-left: 1px solid #000000; color: #000000;"
					+ "font-family: Verdana,Arial,Helvetica,sans-serif;font-size: 10px;font-weight: bold;height: 12px;border-top:0px;"
					+ "text-align: center' colspan='1' width='5%'>Qty. in Quarantine</td>");
			brHeader.append("<td style='background-color: #EFEFF7; border-left: 1px solid #000000; color: #000000;"
					+ "font-family: Verdana,Arial,Helvetica,sans-serif;font-size: 10px;font-weight: bold;height: 12px;border-top:0px;"
					+ "text-align: center' colspan='1' width='5%'>Rejected</td>");
			brHeader.append("</tr>");
		}

		return brHeader;
	}

	/*
	 * 1 >> Trans Date 2 >> Particulars 3 >> Active issue 4 >> In-Active Issue 5 >> Quar Issue 6 >> Active Rec 7 >> In-Active Rec 8 >> Quar Rec 9 >>
	 * Store Name 10 >> Item Name 11 >> Batch No 12 >> Expiry Date,  13 BASE_RATE , 14 HSTNUM_PROGRAMME_ID, 15 HSTNUM_PO_NO, 16 PROG_NAME
	 */
	/**
	 * Gets the detailed stock ledger dtl.
	 * 
	 * @param vo the vo
	 * @param request 
	 * @return the detailed stock ledger dtl
	 * @throws Exception the exception
	 */
	public String getDetailedStockLedgerDtl(StockLedgerForSubStoresRptVO vo, HttpServletRequest request) throws Exception {
		StringBuffer br = new StringBuffer(1000);
		StringBuffer brPagination = new StringBuffer(3000);

		final int REC_PER_PAGE = 100;

		String strCssClass = "multiRPTControl3";
		String strStoreName = "";
		String strDrugName = "";
		String strExpiryDate = "", strProgName="";

		int sNo = 1;
		int pageSize = 1;
		int pageCounter = 0;
		int nColspan = 0;

		long nRecQty = 0L;
		long nIssueQty = 0L;

		long nBalanceActiveQty = 0L;
		long nBalanceQuarQty = 0L;
		long nBalanceRejQty = 0L;

		WebRowSet ws = null;
		String[] tempArr;
		String strRecString = "", strIssueString = "";
		try {

			String strHiddenParameter =
					vo.getStrDWHId() + "^" + vo.getStrItemBrandId() + "^" + vo.getStrFromDate() + "^" + vo.getStrToDate() + "^" + vo.getStrBatchNo()
							+ "^" + vo.getStrOpeningBalance() + "^" + vo.getStrStoreName() + "^" + vo.getStrDrugName() + "^" + vo.getStrBatchFlag()+"^0";

			tempArr = vo.getStrOpeningBalance().split("\\#");
			nBalanceActiveQty = Long.parseLong(tempArr[0].split("\\.")[0]);
			nBalanceQuarQty = Long.parseLong(tempArr[1].split("\\.")[0]);
			nBalanceRejQty = Long.parseLong(tempArr[2].split("\\.")[0]);

			if (vo.getStrBatchNo().equals("0")) {
				br.append(getHeader(4).toString());
				nColspan = 10;
			} else {
				br.append(getHeader(3).toString());
				nColspan = 9;
			}

			// opening balance data
			if (vo.getStrBatchNo().equals("0")) {
				br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
				br.append("<td class= " + strCssClass + " colspan='1' width='5%' style='text-align:center;'><b>" + sNo + "</b></td>");
				br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='10%'><b>" + vo.getStrFromDate()
						+ "</b></td>");
				br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");
				br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");
				br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='25%'><b>Opening Balance</b></td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'><b>" + nBalanceActiveQty + "</b></td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'><b>" + nBalanceQuarQty + "</b></td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'><b>" + nBalanceRejQty + "</b></td>");
				br.append("</tr>");
			} else {
				br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
				br.append("<td class= " + strCssClass + " colspan='1' width='5%' style='text-align:center;'><b>" + sNo + "</b></td>");
				br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='15%'><b>" + vo.getStrFromDate()
						+ "</b></td>");
				br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='31%'><b>Opening Balance</b></td>");
				br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");
				br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");

				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'><b>" + nBalanceActiveQty + "</b></td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'><b>" + nBalanceQuarQty + "</b></td>");
				br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'><b>" + nBalanceRejQty + "</b></td>");
				br.append("</tr>");
			}

			sNo++;
			pageCounter++;

			ws = vo.getWrsData();
			if (ws != null && ws.size() > 0) {
				while (ws.next()) {
					if ((sNo) % 2 == 0) {
						strCssClass = "multiRPTControl1";
					} else {
						strCssClass = "multiRPTControl3";
					}

					if (pageCounter == REC_PER_PAGE) {
						pageSize++;
						pageCounter = 0;
					}

					nRecQty = Long.parseLong(ws.getString(6)) + Long.parseLong(ws.getString(7)) + Long.parseLong(ws.getString(8));
					nIssueQty = Long.parseLong(ws.getString(3)) + Long.parseLong(ws.getString(4)) + Long.parseLong(ws.getString(5));

					if (nRecQty > 0) {
						if (Long.parseLong(ws.getString(6)) > 0) {
							strRecString = "(A)";
						} else if (Long.parseLong(ws.getString(7)) > 0) {
							strRecString = "(R)";
						} else if (Long.parseLong(ws.getString(8)) > 0) {
							strRecString = "(Q)";
						}
					} else {
						strRecString = "";
					}

					if (nIssueQty > 0) {
						if (Long.parseLong(ws.getString(3)) > 0) {
							strIssueString = "(A)";
						} else if (Long.parseLong(ws.getString(4)) > 0) {
							strIssueString = "(R)";
						} else if (Long.parseLong(ws.getString(5)) > 0) {
							strIssueString = "(Q)";
						}
					} else {
						strIssueString = "";
					}

					nBalanceActiveQty = nBalanceActiveQty + Long.parseLong(ws.getString(6)) - Long.parseLong(ws.getString(3));
					nBalanceQuarQty = nBalanceQuarQty + Long.parseLong(ws.getString(8)) - Long.parseLong(ws.getString(5));
					nBalanceRejQty = nBalanceRejQty + Long.parseLong(ws.getString(7)) - Long.parseLong(ws.getString(4));

					if (pageSize == 1) {
						br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
					} else {
						br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
					}

					br.append("<td class= " + strCssClass + " colspan='1' width='5%' style='text-align:center;'>" + sNo + "</td>");

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
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nBalanceQuarQty + "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nBalanceRejQty + "</td>");
					} else {
						br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='15%'>" + ws.getString(1) + "</td>");
						br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='31%'>" + ws.getString(2) + "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nRecQty + strRecString
								+ "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nIssueQty + strIssueString
								+ "</td>");

						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + nBalanceActiveQty + "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + nBalanceQuarQty + "</td>");
						br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + nBalanceRejQty + "</td>");
					}

					br.append("</tr>");

					if (sNo == 2) {
						strStoreName = ws.getString(9);
						strDrugName = ws.getString(10);
						strExpiryDate = ws.getString(12);
						strProgName = ws.getString(16);
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

				br.append("<td class= " + strCssClass + " colspan='1' width='5%' style='text-align:center;'><b>" + sNo + "</b></td>");

				if (vo.getStrBatchNo().equals("0")) {
					br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='10%'><b>" + vo.getStrToDate()
							+ "</b></td>");
					br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");
					br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");
					br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='25%'><b>Closing Balance</b></td>");
					br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'><b>" + nRecQty + "</b></td>");
					br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'><b>" + nIssueQty + "</b></td>");

					br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'><b>" + nBalanceActiveQty
							+ "</b></td>");
					br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'><b>" + nBalanceQuarQty
							+ "</b></td>");
					br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'><b>" + nBalanceRejQty + "</b></td>");
				} else {
					br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='15%'><b>" + vo.getStrToDate()
							+ "</b></td>");
					br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='31%'><b>Closing Balance</b></td>");
					br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'><b>" + nRecQty + "</b></td>");
					br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'><b>" + nIssueQty + "</b></td>");

					br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'><b>" + nBalanceActiveQty
							+ "</b></td>");
					br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'><b>" + nBalanceQuarQty
							+ "</b></td>");
					br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'><b>" + nBalanceRejQty + "</b></td>");
				}

				br.append("</tr>");
				br.append("<tr class='FOOTER'><td colspan='" + nColspan + "' >&nbsp;</td></tr>");

				// button here

				br.append("<tr><td colspan='" + nColspan + "'>");
				br.append("<div class='control_button' id='showButtonID'>");
				br.append("<table border='0' width='95%' align='center'   cellpadding='1px'>");
				br.append("<tr id='saveId'>");
				br.append("<td align='center'><div>");
				br.append("<a href='#' class='button' title='Print' onClick='printDetailedStockLedgerReport(this);' ><span class='print'>Print</span></a>");
				br.append("<a href='#' class='button' title='Cancel' onClick='window.close();' ><span class='cancel'>Cancel</span></a>");
				br.append("</div></td>");
				br.append("</tr>");
				br.append("</table>");
				br.append("</div>");
				br.append("</td></tr>");

				brPagination.append("<HTML><head><title>Stock Ledger</title><link href='../../hisglobal/css/dwh.css' rel='stylesheet' type='text/css'>"
						+ "<link href='../../hisglobal/css/control.css' rel='stylesheet' type='text/css'>"
						+ "<script language='Javascript' src='../../mms/js/stockledgerForSubStores_mmsrpt.js'>"
						+ "</script><style type='text/css'>.pg-normal{color: blue;font-weight: normal;text-decoration: none;cursor: pointer;}"
						+ ".pg-selected{color: red;font-weight: bold;text-decoration: underline;cursor: pointer;}"
						+ ".pg-qualified{color: green;font-weight: bold;text-decoration: underline;cursor: pointer;}"
						+ ".multiRPTControl1 {background-color: #D8D8D8;color: #000000;font-family: Verdana,Arial,Helvetica,sans-serif;"
						+ "font-size: 10px;font-style: normal;font-weight: normal;height: 12px;text-align: center;}" +

						"</style>" + "</head><body class='background'><form class='formbg'>");

				brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px'>");
				brPagination.append("<tr class='HEADER'><td colspan='4'>Stock Ledger Detail</td></tr>");
				brPagination.append("<tr><td class='multiRPTLabel' width='20%'>Store Name</td>");
				brPagination.append("<td class='multiRPTControl' width='30%'><div align='left'>" + strStoreName + "</div></td>");
				brPagination.append("<td class='multiRPTLabel' width='20%'>Drug Name</td>");
				brPagination.append("<td class='multiRPTControl' width='30%'><div align='left'>" + strDrugName + "</div></td>");
				brPagination.append("</tr>");

				
					brPagination.append("<tr><td class='multiRPTLabel' width='20%'>Batch No.</td>");
					brPagination.append("<td class='multiRPTControl' width='30%'><div align='left'>" + vo.getStrBatchNo() + "</div></td>");
					brPagination.append("<td class='multiRPTLabel' width='20%'>Expiry Date</td>");
					brPagination.append("<td class='multiRPTControl' width='30%'><div align='left'>" + strExpiryDate + "</div></td>");
					brPagination.append("</tr>");
					brPagination.append("<tr><td class='multiRPTLabel' width='20%'>Programme Name</td>");
					brPagination.append("<td class='multiRPTControl' colspan='3'><div align='left'>" + strProgName+ "</div></td>");					
					brPagination.append("</tr>");
				

				brPagination.append("<tr><td class='multiRPTLabel' width='20%'>From Date</td>");
				brPagination.append("<td class='multiRPTControl' width='30%'><div align='left'>" + vo.getStrFromDate() + "</div></td>");
				brPagination.append("<td class='multiRPTLabel' width='20%'>To Date</td>");
				brPagination.append("<td class='multiRPTControl' width='30%'><div align='left'>" + vo.getStrToDate() + "</div></td>");
				brPagination.append("</tr>");

				brPagination.append("</table>");

				brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1' >");
				brPagination.append("<tr class='FOOTER' style='text-align:left;'><td colspan='" + nColspan + "'>Drug Details</td></tr>");

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
				brPagination.append("<br>* (A)-Active");
				brPagination.append("<br>* (Q)-Quarantine");
				brPagination.append("<br>* (R)-Rejected");
				brPagination.append("</td>");
				brPagination.append("</tr>");
				brPagination.append("</table>");

				brPagination.append("<input type='hidden' name='selPageIndex' value='1'/>");
				brPagination.append("<input type='hidden' name='strHiddenParameter' value='" + strHiddenParameter + "'>");
				brPagination.append("</form></body></HTML>");

			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("StockLedgerForSubStoresRptHLP.getDetailedStockLedgerDtl()->" + e.getMessage());
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
		Long nIssueQtyQuarantine = 0L;
		Long nIssueQtyInActive = 0L;

		Long nRecQtyActive = 0L;
		Long nRecQtyQuarantine = 0L;
		Long nRecQtyInActive = 0L;

		Long nOpeningBalQtyActive = 0L;
		Long nOpeningBalQtyQuarantine = 0L;
		Long nOpeningBalQtyInActive = 0L;

		String strOpeningBalance = "0^0^0";
		String[] tempArr;

		try {
			nOpeningBalQtyActive = Long.parseLong(ws.getString(8));
			nOpeningBalQtyQuarantine = Long.parseLong(ws.getString(9));
			nOpeningBalQtyInActive = Long.parseLong(ws.getString(10));

			for (int x = 1; x < nDay; x++) {
				tempArr = ws.getString("HSTSTR_ISSUEQTY_DAY" + x).split("\\^");

				nIssueQtyActive = nIssueQtyActive + Long.parseLong(tempArr[0]);
				nIssueQtyQuarantine = nIssueQtyQuarantine + Long.parseLong(tempArr[1]);
				nIssueQtyInActive = nIssueQtyInActive + Long.parseLong(tempArr[2]);

				tempArr = ws.getString("HSTSTR_RECQTY_DAY" + x).split("\\^");

				nRecQtyActive = nRecQtyActive + Long.parseLong(tempArr[0]);
				nRecQtyQuarantine = nRecQtyQuarantine + Long.parseLong(tempArr[1]);
				nRecQtyInActive = nRecQtyInActive + Long.parseLong(tempArr[2]);
			}

			nOpeningBalQtyActive = nOpeningBalQtyActive + nRecQtyActive - nIssueQtyActive;
			nOpeningBalQtyQuarantine = nOpeningBalQtyQuarantine + nRecQtyQuarantine - nIssueQtyQuarantine;
			nOpeningBalQtyInActive = nOpeningBalQtyInActive + nRecQtyInActive - nIssueQtyInActive;

			strOpeningBalance = nOpeningBalQtyActive + "^" + nOpeningBalQtyQuarantine + "^" + nOpeningBalQtyInActive;
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
		Long nIssueQtyQuarantine = 0L;
		Long nIssueQtyInActive = 0L;

		Long nRecQtyActive = 0L;
		Long nRecQtyQuarantine = 0L;
		Long nRecQtyInActive = 0L;
		int nDay = 31;

		String[] tempArr;

		String strIssueRecQty = "0^0^0#0^0^0";

		try {
			// For Received / Issued Qty
			if (nFromMonth == Integer.parseInt(ws.getString(1)) && nFromYear == Integer.parseInt(ws.getString(2))) {
				if ((nFromMonth == nToMonth) && (nFromYear == nToYear)) {
					nDay = nToDay;
				}

				for (int x = nFromDay; x <= nDay; x++) {
					tempArr = ws.getString("HSTSTR_ISSUEQTY_DAY" + x).split("\\^");

					nIssueQtyActive = nIssueQtyActive + Long.parseLong(tempArr[0].split("\\.")[0]);
					nIssueQtyQuarantine = nIssueQtyQuarantine + Long.parseLong(tempArr[1].split("\\.")[0]);
					nIssueQtyInActive = nIssueQtyInActive + Long.parseLong(tempArr[2].split("\\.")[0]);

					tempArr = ws.getString("HSTSTR_RECQTY_DAY" + x).split("\\^");

					nRecQtyActive = nRecQtyActive + Long.parseLong(tempArr[0].split("\\.")[0]);
					nRecQtyQuarantine = nRecQtyQuarantine + Long.parseLong(tempArr[1].split("\\.")[0]);
					nRecQtyInActive = nRecQtyInActive + Long.parseLong(tempArr[2].split("\\.")[0]);
				}
			} else if (nToMonth == Integer.parseInt(ws.getString(1)) && nToYear == Integer.parseInt(ws.getString(2))) {
				for (int x = 1; x <= nToDay; x++) {
					tempArr = ws.getString("HSTSTR_ISSUEQTY_DAY" + x).split("\\^");

					nIssueQtyActive = nIssueQtyActive + Long.parseLong(tempArr[0].split("\\.")[0]);
					nIssueQtyQuarantine = nIssueQtyQuarantine + Long.parseLong(tempArr[1].split("\\.")[0]);
					nIssueQtyInActive = nIssueQtyInActive + Long.parseLong(tempArr[2].split("\\.")[0]);

					tempArr = ws.getString("HSTSTR_RECQTY_DAY" + x).split("\\^");

					nRecQtyActive = nRecQtyActive + Long.parseLong(tempArr[0].split("\\.")[0]);
					nRecQtyQuarantine = nRecQtyQuarantine + Long.parseLong(tempArr[1].split("\\.")[0]);
					nRecQtyInActive = nRecQtyInActive + Long.parseLong(tempArr[2].split("\\.")[0]);
				}
			} else {
				nIssueQtyActive = Long.parseLong(ws.getString(73));
				nIssueQtyQuarantine = Long.parseLong(ws.getString(74));
				nIssueQtyInActive = Long.parseLong(ws.getString(75));

				nRecQtyActive = Long.parseLong(ws.getString(76));
				nRecQtyQuarantine = Long.parseLong(ws.getString(77));
				nRecQtyInActive = Long.parseLong(ws.getString(78));
			}

			strIssueRecQty =
					nIssueQtyActive + "^" + nIssueQtyQuarantine + "^" + nIssueQtyInActive + "#" + nRecQtyActive + "^" + nRecQtyQuarantine + "^"
							+ nRecQtyInActive;
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
	public String getConsolidatedStockLedgerRpt(StockLedgerForSubStoresRptVO vo, HttpServletRequest request) throws Exception {
		
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
					"<HTML><HEAD><title>Stock Ledger</title><script language='JavaScript' src='../../hisglobal/jquery/3.6.0.min.js'></script><script language='Javascript' src='../../hisglobal/js/innerxhtml.js'></script>"
							+ "<script language='Javascript' src='../../mms/js/stockledgerForSubStores_mmsrpt.js'></script>"
							+ "<body><form action='/DWH_ANDHRA/mms/reports/StockLedgerForSubStoresRptCNT.cnt' method='post'><div id='consolidatedStockLedgerRptDivId'>"
							+ "" + "<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0''> ");
			try {
				br.append("<td colspan='1' width='100%' align='center'><div  align='center'> <img  src='/INVMGM/hisglobal/images/aiims_inv_header.png' /></div></td>");
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
			br.append("Store Name: " + vo.getStrStoreName() + "<br>");
			br.append("Drug Name: " + vo.getStrDrugName() + "<br>");
			br.append("</font></b></td><td colspan='1' width='10%'> ");
			br.append("</td> ");
			br.append("</tr> ");
			br.append("<tr> ");
			br.append("<td width='10%' colspan='1' ></td> ");
			br.append("<td width='80%' colspan='12'  align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
			br.append("Between: " + vo.getStrFromDate() + " And " + vo.getStrToDate());
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
					+ "<img style='cursor: pointer; ' title='Save as Pdf' src='../../hisglobal/images/pdf.png' onClick='generatePdf(\"consolidatedStockLedgerRptDivId\");' /> "
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

			br.append("<td style=\"text-align: center;\" colspan='3' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Opening Balance (No.)</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='3' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty. (No.)</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='3' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty. (No.)</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='3' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Closing Bal. (No.)</b></font></td>");
			br.append("</tr>");

			br.append("<tr bgcolor='#cdc9c9'> ");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");

			br.append("<td style=\"text-align: center;\" colspan='1' width='35%'><font  size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");

			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Ready for issue</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rejected</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty. in quarantine</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Ready for issue</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rejected</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty. in quarantine</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Ready for issue</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rejected</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty. in quarantine</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Ready for issue</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rejected</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty. in quarantine</b></font></td>");

			br.append("</tr>");

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
						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nOpeningBalanceQuar + "</font></td>");
						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nOpeningBalanceRej + "</font></td>");

						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nRecActive + "</font></td>");
						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nRecQuar + "</font></td>");
						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nRecRej + "</font></td>");

						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nIssueActive + "</font></td>");
						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nIssueQuar + "</font></td>");
						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nIssueRej + "</font></td>");

						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nClosingBalanceActive + "</font></td>");
						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nClosingBalanceQuar + "</font></td>");
						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nClosingBalanceRej + "</font></td>");

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
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nOpeningBalanceQuar + "</font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nOpeningBalanceRej + "</font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nRecActive + "</font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nRecQuar + "</font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nRecRej + "</font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nIssueActive + "</font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nIssueQuar + "</font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nIssueRej + "</font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nClosingBalanceActive + "</font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nClosingBalanceQuar + "</font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nClosingBalanceRej + "</font></td>");

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

				br.append("<tr>");
				br.append("<td style=\"text-align: right;\" colspan='2' width='35%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Grand total</b></font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nOpeningBalanceTotActive + "</b></font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nOpeningBalanceTotQuar + "</b></font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nOpeningBalanceTotRej + "</b></font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nRecTotActive + "</b></font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nRecTotQuar + "</b></font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nRecTotRej + "</b></font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nIssueTotActive + "</b></font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nIssueTotQuar + "</b></font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nIssueTotRej + "</b></font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nClosingBalanceTotActive + "</b></font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nClosingBalanceTotQuar + "</b></font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nClosingBalanceTotRej + "</b></font></td>");
				br.append("</tr>");

			} else {
				// no data found code here
				brPagination.append("<table width='95%' align='center'   cellpadding='1px'>");
				brPagination.append("<tr><td colspan='14' class='TITLE'>Stock Ledger </td></tr>");
				brPagination.append("<tr><td colspan='14' align='center'><Strong>No Data Found</Strong></td></tr>");
				brPagination.append("</table>");
			}

			br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			br.append("<tr><td colspan='15'><hr></td></tr>");
			br.append("<tr> ");
			br.append("<td colspan='15' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >***End of report***</font></td> ");
			br.append("</tr> ");
			br.append("</table><input type='hidden' name='hmode'/><input type='hidden' name='strHtmlCode' value='' /></form></body></HEAD></HTML>");

		} catch (Exception e) {

			// e.printStackTrace();

			throw e;
		}
		return br.toString();

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
	 * HSTSTR_TOTAL_ACTIVE_RECQTY, 77 HSTSTR_TOTAL_QUAR_RECQTY, 78 HSTSTR_TOTAL_REJ_RECQTY 79 EXPIRY DATE, 80 BASE_RATE, 
	 * 81 HSTNUM_PROGRAMME_ID, 82 HSTNUM_PO_NO, 83 PROG_NAME
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
	public String getConsolidatedStockLedgerRptBatch(StockLedgerForSubStoresRptVO vo, HttpServletRequest request) throws Exception {
		

		StringBuffer br = new StringBuffer(1000);

		WebRowSet ws = null;
		String strTableWidth = "100%";
		String prevItemId = "";
		String prevItemName = "";
		String prevBatch = "", prevProgId="", prevProgName="";
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
						strExpiryDate = ws.getString(79);
					}
					ws.beforeFirst();
				}
			}

			if (vo.getStrItemBrandId() == null || vo.getStrItemBrandId().equals("0")) {
				vo.setStrDrugName("All");
			}

			br.append(
					"<HTML><HEAD><title>Stock Ledger</title><script language='JavaScript' src='../../hisglobal/jquery/3.6.0.min.js'></script>"
							+ "<script language='Javascript' src='../../hisglobal/js/innerxhtml.js'></script>" 
							+ "<script language='Javascript' src='../../mms/js/stockledgerForSubStores_mmsrpt.js'></script>"
							+ "<body><form action='/DWH_ANDHRA/mms/reports/StockLedgerForSubStoresRptCNT.cnt' method='post'>" +
							"<div id='consolidatedBatchWiseStockLedgerRptDivId'>"
							+ "" + "<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0''> ");
			
			br.append("<td colspan='1' width='10%' align='center'><div  align='center'> <img src='/INVMGM/hisglobal/images/aiims_inv_header.png' /></div></td>");
			
		
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
			br.append("Drug Name  : " + strDrugName + "<br>");
			br.append("</font></b></td><td width='10%' colspan='1' > ");
			br.append("</td> ");
			br.append("</tr> ");

			if (!vo.getStrItemBrandId().equals("0")) {
				br.append("<tr> ");
				br.append("<td width='10%' colspan='1' ></td> ");
				br.append("<td width='80%' colspan='12' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
				br.append("Batch No.: " + strBatchNo + "<br>");
				br.append("Expiry Date: " + strExpiryDate + "<br>");
				br.append("</font></b></td><td width='10%' colspan='1' > ");
				br.append("</td> ");
				br.append("</tr> ");
			}

			br.append("<tr> ");
			br.append("<td width='10%' colspan='1' ></td> ");
			br.append("<td width='80%' colspan='12' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
			br.append("Between: " + vo.getStrFromDate() + " And " + vo.getStrToDate());
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
					+ "<img style='cursor: pointer; ' title='Save as Pdf' src='../../hisglobal/images/pdf.png' onClick='generatePdf(\"consolidatedBatchWiseStockLedgerRptDivId\");' /> "
					+ "<img style='cursor: pointer; ' title='Save as Excel' src='../../hisglobal/images/excel1.png' onClick='generateXLS(event,\"consolidatedBatchWiseStockLedgerRptDivId\");' /> "
					+ "<img style='cursor: pointer; ' title='Cancel Process'  ");
			br.append(" src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div>");
			br.append(" </td> ");
			br.append(" </tr> ");
			br.append(" </table> ");

			// Details
			br.append("<table cellspacing='0' border='1' cellpadding='0' width='").append(strTableWidth).append("' align='center'> ");
			br.append("<tr bgcolor='#cdc9c9'> ");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Programme Name</b></font></td>");
			br.append("<td style=\"text-align: center;\" style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='3' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Opening Balance (No.)</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='3' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty. (No.)</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='3' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty. (No.)</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='3' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Closing Bal. (No.)</b></font></td>");
			br.append("</tr>");

			br.append("<tr bgcolor='#cdc9c9'> ");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");

			// Opening Balance
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Ready for issue</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rejected</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty. in quarantine</b></font></td>");
			// Received Balance
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Ready for issue</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rejected</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty. in quarantine</b></font></td>");
			// Issued Balance
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Ready for issue</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rejected</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty. in quarantine</b></font></td>");
			// Closing Balance
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Ready for issue</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rejected</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty. in quarantine</b></font></td>");
			br.append("</tr>");

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
					if ((!prevItemId.equals(ws.getString(4)) || !prevBatch.equals(ws.getString(7)) || !prevProgId.equals(ws.getString(81))) && counter > 0) {
						nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
						nClosingBalanceQuar = nOpeningBalanceQuar + nRecQuar - nIssueQuar;
						nClosingBalanceRej = nOpeningBalanceRej + nRecRej - nIssueRej;

						br.append("<tr> ");
						br.append("<td colspan='1' width='5%' style=\"text-align: center;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + sNo
								+ "</b></font></td>");
						br.append("<td style=\"text-align: left;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ prevItemName + "</font></td>");
						br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ prevBatch + "</font></td>");
						br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ prevProgName + "</font></td>");
						br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ prevExpiry + "</font></td>");

						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nOpeningBalanceActive + "</font></td>");
						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nOpeningBalanceQuar + "</font></td>");
						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nOpeningBalanceRej + "</font></td>");

						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nRecActive + "</font></td>");
						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nRecQuar + "</font></td>");
						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nRecRej + "</font></td>");

						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nIssueActive + "</font></td>");
						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nIssueQuar + "</font></td>");
						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nIssueRej + "</font></td>");

						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nClosingBalanceActive + "</font></td>");
						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nClosingBalanceQuar + "</font></td>");
						br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nClosingBalanceRej + "</font></td>");

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
					prevExpiry = ws.getString(79);
					prevProgId =  ws.getString(81);
					prevProgName =  ws.getString(83);

					counter++;
				}

				// last row
				nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
				nClosingBalanceQuar = nOpeningBalanceQuar + nRecQuar - nIssueQuar;
				nClosingBalanceRej = nOpeningBalanceRej + nRecRej - nIssueRej;

				br.append("<tr> ");
				br.append("<td colspan='1' width='5%' style=\"text-align: center;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + sNo + "</font></td>");
				br.append("<td style=\"text-align: left;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ prevItemName + "</font></td>");
				br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ prevBatch + "</font></td>");
				br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ prevProgName + "</font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ prevExpiry + "</font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nOpeningBalanceActive + "</font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nOpeningBalanceQuar + "</font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nOpeningBalanceRej + "</font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nRecActive + "</font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nRecQuar + "</font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nRecRej + "</font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nIssueActive + "</font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nIssueQuar + "</font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nIssueRej + "</font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nClosingBalanceActive + "</font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nClosingBalanceQuar + "</font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
						+ nClosingBalanceRej + "</font></td>");

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
				br.append("<td style=\"text-align: right;\" colspan='5' width='35%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Grand total</b></font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nOpeningBalanceTotActive + "</b></font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nOpeningBalanceTotQuar + "</b></font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nOpeningBalanceTotRej + "</b></font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nRecTotActive + "</b></font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nRecTotQuar + "</b></font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nRecTotRej + "</b></font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nIssueTotActive + "</b></font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nIssueTotQuar + "</b></font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nIssueTotRej + "</b></font></td>");

				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nClosingBalanceTotActive + "</b></font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nClosingBalanceTotQuar + "</b></font></td>");
				br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nClosingBalanceTotRej + "</b></font></td>");
				br.append("</tr>");
			} else {
				// no data found code here
				br.append("<table width='95%' align='center'   cellpadding='1px'>");
				br.append("<tr><td class='TITLE'>Stock Ledger </td></tr>");
				br.append("<tr><td align='center'><Strong>No Data Found</Strong></td></tr>");
				br.append("</table>");
			}
			br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			br.append("<tr><td colspan='16'><hr></td></tr>");
			br.append("<tr> ");
			br.append("<td colspan='16' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >***End of report***</font></td> ");
			br.append("</tr> ");
			br.append("</table><input type='hidden' name='hmode'/><input type='hidden' name='strHtmlCode' value='' /></form></body></HEAD></HTML>");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("StockLedgerForSubStoresRptHLP.getStockLedgerDtl()->" + e.getMessage());
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
	public String getDetailedStockLedgerRpt(StockLedgerForSubStoresRptVO vo, HttpServletRequest request) throws Exception {
		

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
		WebRowSet ws = null;
		String[] tempArr;
		String col = "12";
		String strRecString = "", strIssueString = "", strProgName="";
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
						strProgName = ws.getString(16);
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
					"<HTML><HEAD><title>Stock Ledger</title><script language='JavaScript' src='../../hisglobal/jquery/3.6.0.min.js'></script>"
							+ "<script language='Javascript' src='../../hisglobal/js/innerxhtml.js'></script>" +
							  "<script language='Javascript' src='../../mms/js/stockledgerForSubStores_mmsrpt.js'></script>"							
							+ "<body><form action='/DWH_ANDHRA/mms/reports/StockLedgerForSubStoresRptCNT.cnt' method='post'><div id='detailedStockLedgerRptDivId'>"
							+ "" + "<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0''> ");
			try {
				br.append("<tr><td colspan='" + col	+ "' width='100%'  align='center'><div  align='center'> <img src='/INVMGM/hisglobal/images/aiims_inv_header.png' /></div></td>");
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
			br.append("Stock Ledger ");
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

			

			br.append("<tr> ");
			br.append("<td width='10%' colspan='1'></td> ");
			br.append("<td width='80%' colspan='" + col + "'align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
			br.append("Between: " + vo.getStrFromDate() + " And " + vo.getStrToDate());
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
					+ "<img style='cursor: pointer; ' title='Save as Pdf' src='../../hisglobal/images/pdf.png' onClick='generatePdf(\"detailedStockLedgerRptDivId\");' /> "
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
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry</b></font></td>");
				br.append("<td colspan='1' width='25%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Particulars</b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty. (No.)</b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty. (No.)</b></font></td>");
				br.append("<td colspan='3' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Balance (No.)</b></font></td>");
				br.append("</tr>");

				br.append("<tr bgcolor='#cdc9c9'> ");
				br.append("<td colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				br.append("<td colspan='1' width='25%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				// Closing Balance
				br.append("<td colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Ready for issue</b></font></td>");
				br.append("<td colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty. in quarantine</b></font></td>");
				br.append("<td colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rejected</b></font></td>");
				br.append("</tr>");

				nColspan = 10;
			} else {
				br.append("<tr bgcolor='#cdc9c9'> ");
				br.append("<td colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font></td>");
				br.append("<td colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Date</b></font></td>");
				br.append("<td colspan='1' width='31%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Particulars</b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty. (No.)</b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty. (No.)</b></font></td>");
				br.append("<td colspan='3' width='24%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Balance (No.)</b></font></td>");
				br.append("</tr>");

				br.append("<tr bgcolor='#cdc9c9'> ");
				br.append("<td colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				br.append("<td colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				br.append("<td colspan='1' width='31%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				// Closing Balance
				br.append("<td colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Ready for issue</b></font></td>");
				br.append("<td colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty. in quarantine</b></font></td>");
				br.append("<td colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rejected</b></font></td>");
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
				br.append("<td style=\"text-align: left;\"  colspan='1' width='25%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Opening Balance</font></b></td>");
				br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>--</font></b></td>");
				br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>--</font></b></td>");

				br.append("<td style=\"text-align: right;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nBalanceActiveQty + "</font></b></td>");
				br.append("<td style=\"text-align: right;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nBalanceQuarQty + "</font></b></td>");
				br.append("<td style=\"text-align: right;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nBalanceRejQty + "</font></b></td>");
				br.append("</tr>");
			} else {
				br.append("<tr>");
				br.append("<td style=\"text-align: center;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ sNo + "</font></b></td>");
				br.append("<td style=\"text-align: center;\"  colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ vo.getStrFromDate() + "</font></b></td>");
				br.append("<td style=\"text-align: left;\"  colspan='1' width='31%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Opening Balance</font></b></td>");
				br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>--</font></b></td>");
				br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>--</font></b></td>");

				br.append("<td style=\"text-align: right;\"  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nBalanceActiveQty + "</font></b></td>");
				br.append("<td style=\"text-align: right;\"  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nBalanceQuarQty + "</font></b></td>");
				br.append("<td style=\"text-align: right;\"  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ nBalanceRejQty + "</font></b></td>");
				br.append("</tr>");
			}

			sNo++;
			
			if (ws != null && ws.size() > 0) {
				while (ws.next()) {

					nRecQty = Long.parseLong(ws.getString(6)) + Long.parseLong(ws.getString(7)) + Long.parseLong(ws.getString(8));
					nIssueQty = Long.parseLong(ws.getString(3)) + Long.parseLong(ws.getString(4)) + Long.parseLong(ws.getString(5));

					if (nRecQty > 0) {
						if (Long.parseLong(ws.getString(6)) > 0) {
							strRecString = "(A)";
						} else if (Long.parseLong(ws.getString(7)) > 0) {
							strRecString = "(R)";
						} else if (Long.parseLong(ws.getString(8)) > 0) {
							strRecString = "(Q)";
						}
					} else {
						strRecString = "";
					}

					if (nIssueQty > 0) {
						if (Long.parseLong(ws.getString(3)) > 0) {
							strIssueString = "(A)";
						} else if (Long.parseLong(ws.getString(4)) > 0) {
							strIssueString = "(R)";
						} else if (Long.parseLong(ws.getString(5)) > 0) {
							strIssueString = "(Q)";
						}
					} else {
						strIssueString = "";
					}

					nBalanceActiveQty = nBalanceActiveQty + Long.parseLong(ws.getString(6)) - Long.parseLong(ws.getString(3));
					nBalanceQuarQty = nBalanceQuarQty + Long.parseLong(ws.getString(8)) - Long.parseLong(ws.getString(5));
					nBalanceRejQty = nBalanceRejQty + Long.parseLong(ws.getString(7)) - Long.parseLong(ws.getString(4));

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

						br.append("<td style=\"text-align: right;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nBalanceActiveQty + "</font></td>");
						br.append("<td style=\"text-align: right;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nBalanceQuarQty + "</font></td>");
						br.append("<td style=\"text-align: right;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nBalanceRejQty + "</font></td>");
					} else {
						br.append("<td style=\"text-align: center;\"  colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ ws.getString(1) + "</font></td>");
						br.append("<td style=\"text-align: left;\"  colspan='1' width='31%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ ws.getString(2) + "</font></td>");
						br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nRecQty + strRecString + "</font></td>");
						br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nIssueQty + strIssueString + "</font></td>");

						br.append("<td style=\"text-align: right;\"  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nBalanceActiveQty + "</font></td>");
						br.append("<td style=\"text-align: right;\"  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nBalanceQuarQty + "</font></td>");
						br.append("<td style=\"text-align: right;\"  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"
								+ nBalanceRejQty + "</font></td>");
					}

					br.append("</tr>");

					if (sNo == 2) {
						strStoreName = ws.getString(9);
						strDrugName = ws.getString(10);
						strExpiryDate = ws.getString(12);
						strProgName = ws.getString(16);						
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
					br.append("<td style=\"text-align: left;\"  colspan='1' width='25%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Closing Balance</font></b></td>");
					br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
							+ nRecQty + "</font></b></td>");
					br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
							+ nIssueQty + "</font></b></td>");

					br.append("<td style=\"text-align: right;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
							+ nBalanceActiveQty + "</font></b></td>");
					br.append("<td style=\"text-align: right;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
							+ nBalanceQuarQty + "</font></b></td>");
					br.append("<td style=\"text-align: right;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
							+ nBalanceRejQty + "</font></b></td>");
				} else {
					br.append("<td style=\"text-align: center;\"  colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
							+ vo.getStrToDate() + "</font></b></td>");
					br.append("<td style=\"text-align: left;\"  colspan='1' width='31%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Closing Balance</font></b></td>");
					br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
							+ nRecQty + "</font></b></td>");
					br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
							+ nIssueQty + "</font></b></td>");

					br.append("<td style=\"text-align: right;\"  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
							+ nBalanceActiveQty + "</font></b></td>");
					br.append("<td style=\"text-align: right;\"  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
							+ nBalanceQuarQty + "</font></b></td>");
					br.append("<td style=\"text-align: right;\"  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>"
							+ nBalanceRejQty + "</font></b></td>");
				}

				br.append("</tr>");
				br.append("<tr><td colspan='" + nColspan + "' class='TITLE'></td></tr>");

			}
			br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			br.append("<tr><td colspan='15'><hr></td></tr>");
			br.append("<tr> ");
			br.append("<td colspan='15' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >***End of report***</font></td> ");
			br.append("</tr> ");
			br.append("<tr>");
			br.append("<td><font size='2' color='BLUE'>");
			br.append("<br>* (A)-Active");
			br.append("<br>* (Q)-Quarantine");
			br.append("<br>* (R)-Rejected");
			br.append("</td>");
			br.append("</tr>");
			br.append("</table><input type='hidden' name='hmode'/><input type='hidden' name='strHtmlCode' value='' /></form></body></HEAD></HTML>");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("StockLedgerForSubStoresRptHLP.getDetailedStockLedgerDtl()->" + e.getMessage());
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}

		return br.toString();

	}

}
