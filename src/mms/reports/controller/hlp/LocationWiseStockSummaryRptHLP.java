/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         LocationWiseStockSummaryRptHLP.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.controller.hlp;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import hisglobal.utility.HisUtil;
import mms.reports.controller.fb.LocationWiseStockSummaryRptFB;
import mms.reports.vo.LocationWiseStockSummaryRptVO;
/**
 * The Class LocationWiseStockSummaryRptHLP.
 */
public class LocationWiseStockSummaryRptHLP {

	/**
	 * Prints the stock drug list.
	 * 
	 * @param vo the vo
	 * @return the string
	 * @throws Exception the exception
	 */
	public static String printStockDrugList(LocationWiseStockSummaryRptVO vo,HttpServletRequest request) throws Exception 
	{
		int storeSize = 0;
		int initStoreSize = 0;
		int counter = 0;
		int slNo = 0;
		int keyValue = 0;
		WebRowSet ws = null;
		WebRowSet wsItem = null;

		StringBuffer br = new StringBuffer(2000);
		StringBuffer brHeader = new StringBuffer(2000);

		HashMap<String, String> map = null;

		int tblWidth = 100;
		int nTblWidth = 100;
		int propTblWidth = 10;

		double width1 = 0;
		double width2 = 0;
		double width3 = 0;
		double width4 = 0;
		double width5 = 0;
		double width6 = 0;
		double width7 = 0;
		double width8 = 0;
		double width9 = 0;
		double width10 = 10; // dynamic column

		String prevItemName = "";

		int totalQty = 0;
		int grandTotalQty = 0;
		double grandTotalValue = 0.00;
		double grandGrandTotalValue = 0.00;

		String[] storeValue = null;
		String[] storeValueTemp = null;
		int dataFlag = 0;
		DecimalFormat myFormatter = new DecimalFormat("0.00");

		String strPrevDistId = "";
		String tempQty = "";
		String tempValue = "";
		String tempDistId = "", pipeDisplay = "1";
		String prevBatch = "", currItemName = "", currBatch = "";

		int nColspan = 0;
		int pipeLineCounter = 0;

		try {
			/*
			 * 1-Item Name 2-GroupName^Item Type Name 3-Expiry Date 4-Supp Name 5-Rate Unit 6-Store Name 7-MAIN_STR_QTY 8-AMT 9-PIPELINEQTY^AMT
			 * 10.Store Id 11.Batch No /*HEADER 1-Store Id 2-Store Name 3. District Id 4. District Name 5. DDW FLAG
			 */

			ws = vo.getStrHeaderWS(); // Header
			wsItem = vo.getStrDrugListWS(); // Stock on hand

			storeSize = ws.size();
			initStoreSize = storeSize;

			if (storeSize > 0) 
			{
				storeValue = new String[initStoreSize];
				storeValueTemp = new String[initStoreSize];

				// calculate table width/column width
				if (vo.getStrBatchWiseChkFlg().equals("1")) 
				{
					tblWidth = 125;
					nTblWidth = 125;

					// fixed column = 100%
					width1 = 4;
					width2 = 26;
					width3 = 13;
					width4 = 8;
					width5 = 9;
					width6 = 8;
					width7 = 14;
					width8 = 8;
					width9 = 10;

					width10 = 8; // this is dynamic column
				} else 
				{
					tblWidth = 90;
					nTblWidth = 90;

					width1 = 6;
					width2 = 40;
					width3 = 22;
					width4 = 16;
					width9 = 16;

					width10 = 10;
				}

				// table width that has to add in original table width should be
				// as follows, propTblWidth should be in integer not in double
				propTblWidth = (int) (tblWidth * width10) / 100;

				while (ws.next()) 
				{
					

					if (counter > 1 && !strPrevDistId.equals(ws.getString(3))) {
						nTblWidth += propTblWidth;
					}

					nTblWidth += propTblWidth;

					strPrevDistId = ws.getString(3);
					counter++;
				}

				// if pipeDisplay ==true then display pipeline qty
				for (int k = 0; k < pipeLineCounter; k++) {
					nTblWidth += propTblWidth;
				}

				if (counter > 0) {
					nTblWidth += propTblWidth;
				}

				// if store = all then display grand total
				if (vo.getStrDistrictStoreId().equals("0")) {
					nTblWidth += propTblWidth;
				}

				strPrevDistId = "";
				counter = 0;
				ws.beforeFirst();

				// calculate table width/column width
				width1 = (width1 * tblWidth) / nTblWidth;
				width2 = (width2 * tblWidth) / nTblWidth;
				width3 = (width3 * tblWidth) / nTblWidth;
				width4 = (width4 * tblWidth) / nTblWidth;
				width5 = (width5 * tblWidth) / nTblWidth;
				width6 = (width6 * tblWidth) / nTblWidth;
				width7 = (width7 * tblWidth) / nTblWidth;
				width8 = (width8 * tblWidth) / nTblWidth;
				width9 = (width9 * tblWidth) / nTblWidth;
				width10 = (width10 * tblWidth) / nTblWidth;

				tblWidth = nTblWidth;

				// make header

				brHeader.append("<div id='wrapper'><table id='mainTableRptId' width='100%' align='center' cellspacing='0px' cellpadding='1px' border=1>");
				brHeader.append("<tr id='tableHeaderId' style='color:rgb(40,160,120);'>");
				brHeader.append("<th colspan='1' style='width:" + width1
						+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>S.No.</strong></font></th>");
				brHeader.append("<th colspan='1' style='width:" + width2
						+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Item Name</strong></font></th>");
				brHeader.append("<th colspan='1' style='width:" + width3
						+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Name</strong></font></th>");
				brHeader.append("<th colspan='1' style='width:" + width4
						+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Item Type</strong></font></th>");
				nColspan = 4;

				if (vo.getStrBatchWiseChkFlg().equals("1")) {
					brHeader.append("<th colspan='1' style='width:" + width5
							+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Batch No.</strong></font></th>");
					brHeader.append("<th colspan='1' style='width:"
							+ width6
							+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Expiry Date</strong></font></th>");
					brHeader.append("<th colspan='1' style='width:"
							+ width7
							+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Supplier Name</strong></font></th>");
					brHeader.append("<th colspan='1' style='width:" + width8
							+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Rate</strong></font></th>");

					nColspan = nColspan + 4;
				}

				// store header
				map = new HashMap<String, String>();
				String strStoreName = "";

				while (ws.next()) 
				{
					// qty^qtyValue^pipelineqty^pipelineqtyValue^districtid^pipeDisplay
					storeValue[counter] = "--^--^--^--^" + ws.getString(3) + "^" + pipeDisplay;
					storeValueTemp[counter] = "--^--^--^--^" + ws.getString(3) + "^" + pipeDisplay;
					
					// put store id
					
					map.put(ws.getString(1), String.valueOf(counter++));


					strStoreName = ws.getString(2);

					brHeader.append("<th colspan='1' style='width:" + width10
							+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + strStoreName
							+ " (No.)</strong></font></th>");
					nColspan = nColspan + 1;

					
					strPrevDistId = ws.getString(3);
					
					
				}

				/*if (counter > 0) 
				{
					nColspan = nColspan + 1;
					brHeader.append("<th colspan='1' style='width:" + width10
							+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + strPrevDistName
							+ " Total</strong></font></th>");
				}*/

				// if store = all then display grand total
				if (vo.getStrDistrictStoreId().equals("0")) 
				{
					brHeader.append("<th colspan='1' style='width:"
							+ width10
							+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Grand Total</strong></font></th>");
					nColspan = nColspan + 1;
				}
				else
				{
					brHeader.append("<th colspan='1' style='width:"
							+ width10
							+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Grand Total</strong></font></th>");
					nColspan = nColspan + 1;
				}

				nColspan = nColspan + 1;
				brHeader.append("<th colspan='1' style='width:" + width9
						+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Value ( &#8377; )</strong></font></th>");
				brHeader.append("</tr>");

				// body part
				if (wsItem.size() > 0) 
				{
					strPrevDistId = "";
					slNo = 0;

					while (wsItem.next()) {
						currItemName = wsItem.getString(1) == null ? "NA" : wsItem.getString(1);
						currBatch = wsItem.getString(10) == null ? "NA" : wsItem.getString(10);						

						if (!prevItemName.equalsIgnoreCase(currItemName.toString()) || !prevBatch.equalsIgnoreCase(currBatch)) {
							// not in first time
							if (slNo > 0) {
								grandTotalQty = 0;
								grandTotalValue = 0.00;
								totalQty = 0;
								strPrevDistId = "";
								for (int counter1 = 0; counter1 < initStoreSize; counter1++) {
									tempQty = storeValue[counter1].split("\\^")[0];
									
									tempValue = storeValue[counter1].split("\\^")[1];
									
									tempDistId = storeValue[counter1].split("\\^")[4];
									
									/*if (!strPrevDistId.equals(tempDistId) && counter1 > 0) {
										br.append("<td colspan='1' style=\"text-align:right; width:" + width10
												+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + totalQty + "</font></td>");
										totalQty = 0;
									}*/

									br.append("<td colspan='1' style=\"text-align:right; width:" + width10
											+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + tempQty + "</font></td>");
									
									if (!tempQty.equals("--")) {
										grandTotalQty = grandTotalQty + (Integer.parseInt(tempQty));// + Double.parseDouble(tempPipeQty));
										totalQty = totalQty + (Integer.parseInt(tempQty));// + Double.parseDouble(tempPipeQty));
										grandTotalValue = grandTotalValue + Double.parseDouble(tempValue);// + Double.parseDouble(tempPipeValue);
									}
									strPrevDistId = tempDistId;
									
									
									storeValue[counter1] = storeValueTemp[counter1];
									
								}

								/*if (counter > 0) {
									br.append("<td colspan='1' style=\"text-align:right; width:" + width10
											+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + totalQty + "</font></td>");
								}*/

								if (vo.getStrDistrictStoreId().equals("0")) {
									br.append("<td colspan='1' style=\"text-align:right; width:" + width10
											+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + grandTotalQty + "</font></td>");
								}else{
									br.append("<td colspan='1' style=\"text-align:right; width:" + width10
											+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + grandTotalQty + "</font></td>");
								}

								grandGrandTotalValue = grandGrandTotalValue + grandTotalValue;
								br.append("<td colspan='1' style=\"text-align:right; width:" + width9
										+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(grandTotalValue)
										+ "</font></td>");
								br.append("</tr>");

							}

							slNo++;

							
							br.append("<tr>");
							br.append("<td colspan='1' style=\"text-align:center; width:" + width1
									+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + slNo + "</font></td>");
							br.append("<td colspan='1' style=\"text-align:left; width:" + width2
									+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(1) + "</font></td>");
							br.append("<td colspan='1' style=\"text-align:left; width:" + width3
									+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(2).split("\\^")[0]
									+ "</font></td>");
							br.append("<td colspan='1' style=\"text-align:left; width:" + width4
									+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(2).split("\\^")[1]
									+ "</font></td>");

							if (vo.getStrBatchWiseChkFlg().equals("1")) {
								br.append("<td colspan='1' style=\"text-align:left; width:" + width5
										+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(10) + "</font></td>");
								br.append("<td colspan='1' style=\"text-align:left; width:" + width6
										+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(3) + "</font></td>");
								br.append("<td colspan='1' style=\"text-align:left; width:" + width7
										+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(4) + "</font></td>");
								br.append("<td colspan='1' style=\"text-align:left; width:" + width8
										+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(5) + "</font></td>");
							}
                            //System.out.println("wsItem.getString(9)--->>"+wsItem.getString(9)); 
                            //System.out.println("map.get(wsItem.getString(9))--->>"+map.get(wsItem.getString(9))); 
                            if(map.get(wsItem.getString(9))!=null)
                            {	
							   keyValue = Integer.parseInt(map.get(wsItem.getString(9)));
                            }
                            else
                            {
                               keyValue = 0;
                            }
							storeValue[keyValue] =wsItem.getString(7) + "^" + wsItem.getString(8) + "^--^--^"  
											+ storeValue[keyValue].split("\\^")[4] + "^" + storeValue[keyValue].split("\\^")[5];
						} else {
							keyValue = Integer.parseInt(map.get(wsItem.getString(9)));
							storeValue[keyValue] = 
									wsItem.getString(7) + "^" + wsItem.getString(8) + "^--^--^" 
											+ storeValue[keyValue].split("\\^")[4] + "^" + storeValue[keyValue].split("\\^")[5];
						}

						prevItemName = wsItem.getString(1) == null ? "NA" : wsItem.getString(1);
						prevBatch = wsItem.getString(10) == null ? "NA" : wsItem.getString(10);

						dataFlag++;
					}

					// last row
					if (dataFlag > 0) {
						grandTotalQty = 0;
						grandTotalValue = 0.00;
						totalQty = 0;
						strPrevDistId = "";

						for (int counter2 = 0; counter2 < initStoreSize; counter2++) {
							tempQty = storeValue[counter2].split("\\^")[0];
							tempValue = storeValue[counter2].split("\\^")[1];
							
							tempDistId = storeValue[counter2].split("\\^")[4];
							
							/*if (!strPrevDistId.equals(tempDistId) && counter2 > 0) {
								br.append("<td colspan='1' style=\"text-align:right; width:" + width10
										+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + totalQty + "</font></td>");
								totalQty = 0;
							}*/

							br.append("<td colspan='1' style=\"text-align:right; width:" + width10
									+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + tempQty + "</font></td>");
							// display pipeline qty if ddw
							
							
							
							if (!tempQty.equals("--")) {
								grandTotalQty = grandTotalQty + (Integer.parseInt(tempQty) );//+ Double.parseDouble(tempPipeQty));
								totalQty = totalQty + (Integer.parseInt(tempQty));// + Double.parseDouble(tempPipeQty));
								grandTotalValue = grandTotalValue + Double.parseDouble(tempValue);// + Double.parseDouble(tempPipeValue);
							}

							strPrevDistId = tempDistId;
						}						

						if (vo.getStrDistrictStoreId().equals("0")) 
						{
							br.append("<td colspan='1' style=\"text-align:right; width:" + width10
									+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + grandTotalQty + "</font></td>");
						}
						else
						{
							br.append("<td colspan='1' style=\"text-align:right; width:" + width10
									+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + grandTotalQty + "</font></td>");
						}
						System.out.println("grandTotalValue---"+grandTotalValue);

						grandGrandTotalValue = grandGrandTotalValue + grandTotalValue;
						br.append("<td colspan='1' style=\"text-align:right; width:" + width9
								+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(grandTotalValue)
								+ "</font></td>");
						br.append("</tr>");

						br.append("<tr>");
						br.append("<td colspan='" + (nColspan)
								+ "' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"
								+ myFormatter.format(grandGrandTotalValue) + "</b></font></td>");
						br.append("</tr>");

						hisglobal.utility.HisUtil util = new hisglobal.utility.HisUtil("", "");

						br.append("<tr>");
						br.append("<td colspan='" + nColspan
								+ "' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"
								+ util.getAmountStr(String.valueOf(myFormatter.format(grandGrandTotalValue))) + "</b></font></td>");
						br.append("</tr>");

					}

				} else {
					br.append("<tr>");
					br.append("<td colspan='"
							+ nColspan
							+ "' width='100%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>No Data Found</strong></font></td>");
					br.append("</tr>");
				}

			} 
			else {
				// if no data exists then make default header
				brHeader.append("<div id='wrapper'><table id='mainTableRptId' width='100%' align='center' cellspacing='0px' cellpadding='1px' border=1>");
				brHeader.append("<tr id='tableHeaderId'>");

				if (vo.getStrBatchWiseChkFlg().equals("1")) {
					nColspan = 11;
					brHeader.append("<th colspan='1' width='5%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>S.No.</strong></font></th>");
					brHeader.append("<th colspan='1' width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Item Name</strong></font></th>");
					brHeader.append("<th colspan='1' width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Name</strong></font></th>");
					brHeader.append("<th colspan='1' width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Item Type</strong></font></th>");

					brHeader.append("<th colspan='1' width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Batch No.</strong></font></th>");
					brHeader.append("<th colspan='1' width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Expiry Date</strong></font></th>");
					brHeader.append("<th colspan='1' width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Supplier Name</strong></font></th>");
					brHeader.append("<th colspan='1' width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Rate</strong></font></th>");

					brHeader.append("<th colspan='1' width='5%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Stock qty</strong></font></th>");
					brHeader.append("<th colspan='1' width='5%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total</strong></font></th>");
					brHeader.append("<th colspan='1' width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Value (rs.)</strong></font></th>");
				} else {
					nColspan = 7;
					brHeader.append("<th colspan='1' width='5%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>S.No.</strong></font></th>");
					brHeader.append("<th colspan='1' width='25%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Item Name</strong></font></th>");
					brHeader.append("<th colspan='1' width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Name</strong></font></th>");
					brHeader.append("<th colspan='1' width='15%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Item Type</strong></font></th>");
					brHeader.append("<th colspan='1' width='15%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Stock qty</strong></font></th>");
					brHeader.append("<th colspan='1' width='15%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total</strong></font></th>");
					brHeader.append("<th colspan='1' width='15%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Value (rs.)</strong></font></th>");
				}
				brHeader.append("</tr>");

				br.append("<tr>");
				br.append("<td colspan='"
						+ nColspan
						+ "' width='100%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>No Data Found</strong></font></td>");
				br.append("</tr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (wsItem != null) {
				wsItem.close();
				wsItem = null;
			}

			if (ws != null) {
				ws.close();
				ws = null;
			}
		}

		vo.setStrTableWidth(String.valueOf(tblWidth));
		return (brHeader.append(br).toString() + "</table></div>");
	}
	
	/**
	 * Prints the stock drug list.
	 * 
	 * @param vo the vo
	 * @return the string
	 * @throws Exception the exception
	 */
	public static String printStockDrugListBatch(LocationWiseStockSummaryRptVO vo,HttpServletRequest request) throws Exception {
		int storeSize = 0;
		int initStoreSize = 0;
		int counter = 0;
		int slNo = 0;
		int keyValue = 0;

		WebRowSet ws = null;
		WebRowSet wsItem = null;

		StringBuffer br = new StringBuffer(2000);
		StringBuffer brHeader = new StringBuffer(2000);

		HashMap<String, String> map = null;

		int tblWidth = 100;
		int nTblWidth = 100;
		int propTblWidth = 10;

		double width1 = 0;
		double width2 = 0;
		double width3 = 0;
		double width4 = 0;
		double width5 = 0;
		double width6 = 0;
		double width7 = 0;
		double width8 = 0;
		double width9 = 0;
		double width10 = 10; // dynamic column

		String prevItemName = "";

		long totalQty = 0;
		long grandTotalQty = 0;
		double grandTotalValue = 0.00;
		double grandGrandTotalValue = 0.00;

		String[] storeValue = null;
		int dataFlag = 0;
		DecimalFormat myFormatter = new DecimalFormat("0.00");

		String strPrevDistId = "";
		String strPrevDistName = "";
		String tempQty = "";
		String tempValue = "";
		String tempDistId = "", pipeDisplay = "1";
		String prevBatch = "", currItemName = "", currBatch = "";

		int nColspan = 0;
		int pipeLineCounter = 0;

		try {
			/*
			 * 1-Item Name 2-GroupName^Item Type Name 3-Expiry Date 4-Supp Name 5-Rate Unit 6-Store Name 7-MAIN_STR_QTY 8-AMT 9-PIPELINEQTY^AMT
			 * 10.Store Id 11.Batch No /*HEADER 1-Store Id 2-Store Name 3. District Id 4. District Name 5. DDW FLAG
			 */

			ws = vo.getStrHeaderWS(); // Header
			wsItem = vo.getStrDrugListWS(); // Stock on hand

			storeSize = ws.size();
			initStoreSize = storeSize;

			if (storeSize > 0) {
				storeValue = new String[initStoreSize];

				// calculate table width/column width
				if (vo.getStrBatchWiseChkFlg().equals("1")) 
				{
					tblWidth = 125;
					nTblWidth = 125;

					// fixed column = 100%
					width1 = 4;
					width2 = 26;
					width3 = 13;
					width4 = 8;
					width5 = 9;
					width6 = 8;
					width7 = 14;
					width8 = 8;
					width9 = 10;

					width10 = 8; // this is dynamic column
				} 
				else 
				{
					tblWidth = 95;
					nTblWidth = 95;

					width1 = 6;
					width2 = 40;
					width3 = 22;
					width4 = 16;
					width9 = 16;

					width10 = 8;
				}

				// table width that has to add in original table width should be
				// as follows, propTblWidth should be in integer not in double
				propTblWidth = (int) (tblWidth * width10) / 100;
				pipeDisplay = "0";
				while (ws.next()) {
					// tempStoreSize
					// ddw flag = 1 then pipeline qty has to display
					if (pipeDisplay.equals("1")) {
						if (ws.getString(5).equals("0")) {
							
							pipeLineCounter = 0;
						} else {
							pipeLineCounter++;
						}
					}

					if (counter > 1 && !strPrevDistId.equals(ws.getString(3))) {
						nTblWidth += propTblWidth;
					}

					nTblWidth += propTblWidth;

					strPrevDistId = ws.getString(3);
					counter++;
				}

				// if pipeDisplay ==true then display pipeline qty
				for (int k = 0; k < pipeLineCounter; k++) {
					nTblWidth += propTblWidth;
				}

				if (counter > 0) {
					nTblWidth += propTblWidth;
				}

				// if store = all then display grand total
				if (vo.getStrDistrictStoreId().equals("0")) {
					nTblWidth += propTblWidth;
				}

				strPrevDistId = "";
				counter = 0;
				ws.beforeFirst();

				// calculate table width/column width
				width1 = (width1 * tblWidth) / nTblWidth;
				width2 = (width2 * tblWidth) / nTblWidth;
				width3 = (width3 * tblWidth) / nTblWidth;
				width4 = (width4 * tblWidth) / nTblWidth;
				width5 = (width5 * tblWidth) / nTblWidth;
				width6 = (width6 * tblWidth) / nTblWidth;
				width7 = (width7 * tblWidth) / nTblWidth;
				width8 = (width8 * tblWidth) / nTblWidth;
				width9 = (width9 * tblWidth) / nTblWidth;
				width10 = (width10 * tblWidth) / nTblWidth;

				tblWidth = nTblWidth;

				// make header

				brHeader.append("<div id='wrapper'><table id='mainTableRptId' width='100%' align='center' cellspacing='0px' cellpadding='1px' border=1>");
				brHeader.append("<tr id='tableHeaderId'>");
				brHeader.append("<th colspan='1' style='width:" + width1
						+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>S.No.</strong></font></th>");
				brHeader.append("<th colspan='1' style='width:" + width2
						+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Drug Name</strong></font></th>");
				brHeader.append("<th colspan='1' style='width:" + width3
						+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Name</strong></font></th>");
				brHeader.append("<th colspan='1' style='width:" + width4
						+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Type</strong></font></th>");
				nColspan = 4;

				if (vo.getStrBatchWiseChkFlg().equals("1")) {
					brHeader.append("<th colspan='1' style='width:" + width5
							+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Batch No.</strong></font></th>");
					brHeader.append("<th colspan='1' style='width:"
							+ width6
							+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Expiry Date</strong></font></th>");
					brHeader.append("<th colspan='1' style='width:"
							+ width7
							+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Supplier Name</strong></font></th>");
					brHeader.append("<th colspan='1' style='width:" + width8
							+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Rate</strong></font></th>");

					nColspan = nColspan + 3;
				}

				// store header
				map = new HashMap<String, String>();
				String strStoreName = "";

				while (ws.next()) 
				{
					// qty^qtyValue^pipelineqty^pipelineqtyValue^districtid^pipeDisplay
					storeValue[counter] = "--^--^--^--^" + ws.getString(3) + "^" + pipeDisplay;
					// put store id
					map.put(ws.getString(1), String.valueOf(counter++));

					if (counter > 1 && !strPrevDistId.equals(ws.getString(3))) 
					{
						brHeader.append("<th colspan='1' style='width:" + width10
								+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total (No.)</strong></font></th>");
						nColspan = nColspan + 1;
					}

					strStoreName = ws.getString(2);

					brHeader.append("<th colspan='1' style='width:" + width10
							+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + strStoreName
							+ " (No.)</strong></font></th>");
					nColspan = nColspan + 1;

					// if pipeDisplay ==true then display pipeline qty
					if (pipeDisplay.equals("1")) 
					{
						brHeader.append("<th colspan='1' style='width:" + width10
								+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + strStoreName
								+ " Pipeline (No.)</strong></font></th>");
						nColspan = nColspan + 1;
					}

					strPrevDistId = ws.getString(3);
					strPrevDistName = ws.getString(4);
				}

				if (counter > 0) {
					nColspan = nColspan + 1;
					brHeader.append("<th colspan='1' style='width:" + width10
							+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong> Total (No.)</strong></font></th>");
				}

				// if store = all then display grand total
				if (vo.getStrDistrictStoreId().equals("0")) 
				{
					/*
					brHeader.append("<th colspan='1' style='width:"
							+ width10
							+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Grand Total (No.)</strong></font></th>");
					nColspan = nColspan + 1;
					*/
				}

				nColspan = nColspan + 1;
				//brHeader.append("<th colspan='1' style='width:" + width9
				//		+ "%;' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Value ( &#8377; )</strong></font></th>");
				brHeader.append("</tr>");

				// body part
				if (wsItem.size() > 0) {
					strPrevDistId = "";
					slNo = 0;

					while (wsItem.next()) 
					{
						currItemName = wsItem.getString(1) == null ? "NA" : wsItem.getString(1);
						currBatch = wsItem.getString(11) == null ? "NA" : wsItem.getString(11);

						if (!prevItemName.equalsIgnoreCase(currItemName.toString()) || !prevBatch.equalsIgnoreCase(currBatch)) 
						{
							// not in first time
							if (slNo > 0) 
							{
								grandTotalQty = 0;
								grandTotalValue = 0.00;
								totalQty = 0;
								strPrevDistId = "";

								for (counter = 0; counter < initStoreSize; counter++) 
								{
									tempQty = storeValue[counter].split("\\^")[0];
									tempValue = storeValue[counter].split("\\^")[1];
									tempDistId = storeValue[counter].split("\\^")[4];
									pipeDisplay = storeValue[counter].split("\\^")[5];

									if (!strPrevDistId.equals(tempDistId) && counter > 0) 
									{
										br.append("<td colspan='1' style=\"text-align:right; width:" + width10
												+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + totalQty + "</font></td>");
										totalQty = 0;
									}

									br.append("<td colspan='1' style=\"text-align:right; width:" + width10
											+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + tempQty + "</font></td>");
									// display pipeline qty if pipeDisplay = 1
									if (pipeDisplay.equals("1")) {
										
									} else {
									}
									if (!tempQty.equals("--")) 
									{
										grandTotalQty = grandTotalQty + (Long.parseLong(tempQty));
										totalQty = totalQty + (Long.parseLong(tempQty));
										grandTotalValue = grandTotalValue + Double.parseDouble(tempValue);
									}

									strPrevDistId = tempDistId;
								}

								if (counter > 0) 
								{
									br.append("<td colspan='1' style=\"text-align:right; width:" + width10
											+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + totalQty + "</font></td>");
								}

								if (vo.getStrDistrictStoreId().equals("0")) {
								}

								grandGrandTotalValue = grandGrandTotalValue + grandTotalValue;
								/*
								br.append("<td colspan='1' style=\"text-align:right; width:" + width9
										+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(grandTotalValue)
										+ "</font></td>");
								br.append("</tr>");
								*/

							}

							slNo++;

							// reset the array
							for (counter = 0; counter < initStoreSize; counter++) {
								storeValue[counter] =
										"--^--^--^--^" + storeValue[counter].split("\\^")[4] + "^" + storeValue[counter].split("\\^")[5];
							}

							br.append("<tr>");
							br.append("<td colspan='1' style=\"text-align:center; width:" + width1
									+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + slNo + "</font></td>");
							br.append("<td colspan='1' style=\"text-align:left; width:" + width2
									+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(1) + "</font></td>");
							br.append("<td colspan='1' style=\"text-align:left; width:" + width3
									+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(2).split("\\^")[0]
									+ "</font></td>");
							br.append("<td colspan='1' style=\"text-align:left; width:" + width4
									+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(2).split("\\^")[1]
									+ "</font></td>");

							if (vo.getStrBatchWiseChkFlg().equals("1")) {
								br.append("<td colspan='1' style=\"text-align:left; width:" + width5
										+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(11) + "</font></td>");
								br.append("<td colspan='1' style=\"text-align:center; width:" + width6
										+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(3) + "</font></td>");
								br.append("<td colspan='1' style=\"text-align:left; width:" + width7
										+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(4) + "</font></td>");
								br.append("<td colspan='1' style=\"text-align:right; width:" + width8
										+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(5) + "</font></td>");
							}

							keyValue = Integer.parseInt(map.get(wsItem.getString(10)));
							storeValue[keyValue] =
									wsItem.getString(7) + "^" + wsItem.getString(8) + "^" + wsItem.getString(9) + "^"
											+ storeValue[keyValue].split("\\^")[4] + "^" + storeValue[keyValue].split("\\^")[5];
						} else {
							keyValue = Integer.parseInt(map.get(wsItem.getString(10)));
							storeValue[keyValue] =
									wsItem.getString(7) + "^" + wsItem.getString(8) + "^" + wsItem.getString(9) + "^"
											+ storeValue[keyValue].split("\\^")[4] + "^" + storeValue[keyValue].split("\\^")[5];
						}

						prevItemName = wsItem.getString(1) == null ? "NA" : wsItem.getString(1);
						prevBatch = wsItem.getString(11) == null ? "NA" : wsItem.getString(11);

						dataFlag++;
					}

					// last row
					if (dataFlag > 0) {
						grandTotalQty = 0;
						grandTotalValue = 0.00;
						totalQty = 0;
						strPrevDistId = "";

						for (counter = 0; counter < initStoreSize; counter++) 
						{
							tempQty = storeValue[counter].split("\\^")[0];
							tempValue = storeValue[counter].split("\\^")[1];
							tempDistId = storeValue[counter].split("\\^")[4];
							pipeDisplay = storeValue[counter].split("\\^")[5];

							if (!strPrevDistId.equals(tempDistId) && counter > 0) {
								br.append("<td colspan='1' style=\"text-align:right; width:" + width10
										+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + totalQty + "</font></td>");
								totalQty = 0;
							}

							br.append("<td colspan='1' style=\"text-align:right; width:" + width10
									+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + tempQty + "</font></td>");
							// display pipeline qty if ddw
							if (pipeDisplay.equals("1")) {
								
							} else {
							}
							if (!tempQty.equals("--")) {
								grandTotalQty = grandTotalQty + (Long.parseLong(tempQty));
								totalQty = totalQty + (Long.parseLong(tempQty));
								grandTotalValue = grandTotalValue + Double.parseDouble(tempValue);
							}

							strPrevDistId = tempDistId;
						}

						if (counter > 0) {
							br.append("<td colspan='1' style=\"text-align:right; width:" + width10
									+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + totalQty + "</font></td>");
						}

						if (vo.getStrDistrictStoreId().equals("0")) {
//							
						}

						grandGrandTotalValue = grandGrandTotalValue + grandTotalValue;
						/*
						br.append("<td colspan='1' style=\"text-align:right; width:" + width9
								+ "%;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(grandTotalValue)
								+ "</font></td>");
								*/
						br.append("</tr>");
                        
						/*
						br.append("<tr>");
						br.append("<td colspan='" + (nColspan)
								+ "' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"
								+ myFormatter.format(grandGrandTotalValue) + "</b></font></td>");
						br.append("</tr>");
						

						hisglobal.utility.HisUtil util = new hisglobal.utility.HisUtil("", "");

						br.append("<tr>");
						br.append("<td colspan='" + nColspan
								+ "' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"
								+ util.getAmountStr(String.valueOf(myFormatter.format(grandGrandTotalValue))) + "</b></font></td>");
						br.append("</tr>");
						*/

					}

				} else {
					br.append("<tr>");
					br.append("<td colspan='"
							+ nColspan
							+ "' width='100%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>No_Data_Found</strong></font></td>");
					br.append("</tr>");
				}

			} else {
				// if no data exists then make default header
				brHeader.append("<div id='wrapper'><table id='mainTableRptId' width='100%' align='center' cellspacing='0px' cellpadding='1px' border=1>");
				brHeader.append("<tr id='tableHeaderId'>");

				if (vo.getStrBatchWiseChkFlg().equals("1")) {
					nColspan = 11;
					brHeader.append("<th colspan='1' width='5%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>.S.No.</strong></font></th>");
					brHeader.append("<th colspan='1' width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Drug Name</strong></font></th>");
					brHeader.append("<th colspan='1' width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Name</strong></font></th>");
					brHeader.append("<th colspan='1' width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Type</strong></font></th>");

					brHeader.append("<th colspan='1' width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>.Batch No</strong></font></th>");
					brHeader.append("<th colspan='1' width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Expiry Date</strong></font></th>");
					brHeader.append("<th colspan='1' width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Supplier Name</strong></font></th>");
					brHeader.append("<th colspan='1' width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Rate</strong></font></th>");

					brHeader.append("<th colspan='1' width='5%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Stock qty</strong></font></th>");
					brHeader.append("<th colspan='1' width='5%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total</strong></font></th>");
					brHeader.append("<th colspan='1' width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Value (rs.)</strong></font></th>");
				} else {
					nColspan = 7;
					brHeader.append("<th colspan='1' width='5%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>S.No.</strong></font></th>");
					brHeader.append("<th colspan='1' width='25%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Drug Name</strong></font></th>");
					brHeader.append("<th colspan='1' width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Name</strong></font></th>");
					brHeader.append("<th colspan='1' width='15%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Item_Type</strong></font></th>");
					brHeader.append("<th colspan='1' width='15%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Stock Qty</strong></font></th>");
					brHeader.append("<th colspan='1' width='15%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total</strong></font></th>");
					brHeader.append("<th colspan='1' width='15%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Value (rs.)</strong></font></th>");
				}
				brHeader.append("</tr>");

				br.append("<tr>");
				br.append("<td colspan='"
						+ nColspan
						+ "' width='100%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>No_Data_Found</strong></font></td>");
				br.append("</tr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (wsItem != null) {
				wsItem.close();
				wsItem = null;
			}

			if (ws != null) {
				ws.close();
				ws = null;
			}
		}

		vo.setStrTableWidth(String.valueOf(tblWidth));
		return (brHeader.append(br).toString() + "</table></div>");
	}

	/**
	 * Gets the prints the indent details.
	 * 
	 * @param vo the vo
	 * @param tableHeader the table header
	 * @param strDBHeader the str db header
	 * @param formBean the form bean
	 * @param strIndentItemList the str indent item list
	 * @param request the request
	 * @return the prints the indent details
	 */
	public static String getPrintIndentDetails(LocationWiseStockSummaryRptVO vo, String tableHeader, String strDBHeader,
			LocationWiseStockSummaryRptFB formBean, String strIndentItemList, HttpServletRequest request) {
		StringBuffer sb = new StringBuffer("");
		String[] tblHdrArr;
		ResourceBundle res = ResourceBundle.getBundle("hisglobal.hisconfig.hisReport");
		mms.qryHandler_mms.res = res;
		
		
		try {
			
			
			
			HisUtil hisutil = new HisUtil("mms", "DrugInventoryTransDATA");
			
			String currDate = hisutil.getASDate("dd-MMM-yyyy");
				
			tblHdrArr = strDBHeader.split("\\^");
			sb.append("<tr><td align='center'><div id='saveId' style='display : block'><div id='printid1' class='hidecontrol' style='float: left; width: 22%;' ><div id ='printImg'>");
			sb.append("<img style='cursor: pointer;' align='left' title='Save As Excel' src='../../hisglobal/images/excel1.png' onClick='document.getElementById(\"reportHeaderName\").style.color=\"black\";generateXLSCommon(event, \"indentItemListDivId\");document.getElementById(\"reportHeaderName\").style.color=\"white\";'/>");
			sb.append("<br><img style='cursor: pointer; ' align='left' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='cancelPrintToDesk();' /></div>");
			sb.append("<br><p style='text-align:left'><font face='Verdana, Arial, Helvetica, sans-serif' size='2' style='text-align:left'><b>Report Date & Time : </b>"
					+ currDate + "</font>");
			sb.append("<br><font face='Verdana, Arial, Helvetica, sans-serif' size='2' style='text-align:left'><b>User Name: </b>"
					+ formBean.getStrUserName() + "</font></p>");
			sb.append("</div>");
			sb.append("<div style='width: 62%; margin-left: 0%;'><table width='100%' cellspacing='0' cellpadding='0' border='0' align='center' id='mstHeaderTable' style='font-weight: bold; font-family: verdana;'><tbody>");
			sb.append("<tr><td width='100%' align='center' >");
			sb.append("<table width='100%'>");
			sb.append("<tbody><tr><td align='center' style='text-align:center;'>"
					//+ "<img src=' http://" + request.getServerName() + ":" + request.getServerPort() + "/INVMGM/hisglobal/images/report_header_withAddress.png'/>"
					+ "<img src='/INVMGM/hisglobal/images/aiims_inv_header.png'/>"
					+ "</td> ");
			

			sb.append("</tr></tbody></table>");
			sb.append("</td></tr>");
			sb.append("<tr>");
			if (!tblHdrArr[0].trim().equals("NA")) {
				sb.append("<td style='font-size:12px;text-align:center'>" + tblHdrArr[0] + "</td></tr>");
			} else {
				sb.append("<td style='font-size:12px;text-align:center'>" + res.getString("REPORT_ADDRESS") + "</td></tr>");
			}
			sb.append("</tr>");
			sb.append("<tr id='reportDisplayHeaderRow'>");
			sb.append("<td id='reportDisplayHeaderData' width='100%' align='center' style='padding-left:20px;font-size:11px;'> <div id='reportdata' style='font-size:12px;text-align:center;'><b>");
			sb.append(tableHeader);
			sb.append("</b><br><br></div></font>");
			sb.append("</td></tr></table></div></div>");
			sb.append("<br><table width='100%' cellspacing='0' cellpadding='0' border='0' align='center'><tr><td align='center'>" + strIndentItemList
					+ "</td></tr></table>");

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("PurchaseOrderDtlRptHLP.getPrintIndentDetails() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}

}