/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         StockSummaryDateWiseRptHLP.java
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

import mms.reports.controller.fb.StockSummaryDateWiseRptFB;
import mms.reports.vo.StockSummaryDateWiseRptVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StockSummaryDateWiseRptHLP.
 */
public class StockSummaryDateWiseRptHLP {

	/**
	 * Prints the zero stock drug list.
	 * 
	 * @param vo
	 *            the vo
	 * @param request 
	 * @return the string
	 * @throws Exception
	 *             the exception
	 */
	public static String printZeroStockDrugList(StockSummaryDateWiseRptVO vo, HttpServletRequest request)
			throws Exception {
		int storeSize = 0;
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

		String[] storeValue = null;
		int dataFlag = 0;
		DecimalFormat myFormatter = new DecimalFormat("0.00");

		String strPrevDistId = "";
		String strPrevDistName = "";
		String tempQty = "";
		String tempValue = "";
		String tempDistId = "";
		String prevBatch = "";
		int nColspan = 0;
		String strGroupName="";
		int groupCount=0;
		String strPrevGroupName="";
		double groupSubTotal=0.00;

		try {
			/*
			 * 1-Item Name 2-GroupName^Item Type Name 3-Expiry Date 4-Supp Name
			 * 5-Rate Unit 6-Store Name 7-Qty 8.Amt (without batch)/Rate in base
			 * (with batch) 9.Store Id 10. Batch No /* 1-Store Id 2-Store Name
			 * 3. District Id 4. District Name
			 */

			if (vo.getStrBatchWiseChkFlg().equals("1")) {
				tblWidth = 125;
				nTblWidth = 125;

				// fixed column = 100%
				width1 = 5;
				width2 = 30;
				width3 = 30;
				width4 = 20;
				//width5 = 5;
				
				width9 = 10;

				width10 = 8; // this is dynamic column
			} else {
				tblWidth = 90;
				nTblWidth = 90;

				width1 = 6;
				width2 = 40;
				width3 = 22;
				width4 = 16;
				width9 = 16;

				width10 = 10;
			}

			// table width that has to add in original table width should be as
			// follows, propTblWidth should be in integer not in double
			propTblWidth = (int) (tblWidth * width10) / 100;

			ws = vo.getStrHeaderWS(); // Header
			wsItem = vo.getStrDrugListWS(); // Stock on hand

			storeSize = ws.size();

			if (storeSize > 0) {
				while (ws.next()) {
					// district total if all option in store combo
					if (vo.getStrDistrictStoreId().equals("0")) {
						if (counter > 1
								&& !strPrevDistId.equals(ws.getString(3))) {
							nTblWidth += propTblWidth;
						}
					}

					nTblWidth += propTblWidth;

					strPrevDistId = ws.getString(3);
					counter++;
				}

				if (vo.getStrDistrictStoreId().equals("0") && counter > 0)
					nTblWidth += propTblWidth;

				if (vo.getStrDistrictId().equals("0"))
					nTblWidth += propTblWidth;

				strPrevDistId = "";
				counter = 0;
				ws.beforeFirst();

				// calculate table width/column width
				width1 = (width1 * tblWidth) / nTblWidth;
				width2 = (width2 * tblWidth) / nTblWidth;
				width3 = (width3 * tblWidth) / nTblWidth;
				width4 = (width4 * tblWidth) / nTblWidth;
				//width5 = (width5 * tblWidth) / nTblWidth;
				
				width9 = (width9 * tblWidth) / nTblWidth;
				width10 = (width10 * tblWidth) / nTblWidth;

				tblWidth = nTblWidth;

				storeValue = new String[storeSize];

				// make header
				brHeader.append("<div id='wrapper'><table id='mainTableRptId' width='100%' align='center' cellspacing='0px' cellpadding='1px' border=1>");
				brHeader.append("<tr id='tableHeaderId'>");
				brHeader.append("<th  style=\"width:" + width1 + "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>S.No.</strong></font></th>");				
				brHeader.append("<th  style=\"width:" + width1 + "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Drug Code</strong></font></th>");				
				brHeader.append("<th  style=\"width:" + width2 + "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Item Name</strong></font></th>");				
				brHeader.append("<th  style=\"width:" + width3 + "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Name</strong></font></th>");
				brHeader.append("<th  style=\"width:" + width4 + "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Item Type</strong></font></th>");
				nColspan = 5;

				// store header
				map = new HashMap<String, String>();
				String strStoreName = "";
				while (ws.next()) {
					storeValue[counter] = "--^--^" + ws.getString(3);
					map.put(ws.getString(1), String.valueOf(counter++));

					// district total if all option in store combo
					if (vo.getStrDistrictStoreId().equals("0")) {
						if (counter > 1&& !strPrevDistId.equals(ws.getString(3))) {
							brHeader.append("<th  style=\"width:"+ width10
									+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+ strPrevDistName
									+ " Total</strong></font></th>");
							nColspan = nColspan + 1;
						}
					}

					strStoreName = ws.getString(2);

					brHeader.append("<th  style=\"width:"+ width10	+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
							+ strStoreName + "<br> Stock (No.)/Val. (&#8377)<br>as on "+vo.getStrDate()+"</strong></font></th>");
					nColspan = nColspan + 1;

					strPrevDistId = ws.getString(3);
					strPrevDistName = ws.getString(4);
				}

				if (vo.getStrDistrictStoreId().equals("0") && counter > 0) {
					nColspan = nColspan + 1;
					brHeader.append("<th  style=\"width:"
							+ width10
							+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
							+ strPrevDistName + " Total (No.)</strong></font></th>");
				}

				if (vo.getStrDistrictId().equals("0")) {
					nColspan = nColspan + 1;
					brHeader.append("<th  style=\"width:"
							+ width10
							+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total (No.)</strong></font></th>");
				}

				nColspan = nColspan + 1;
				brHeader.append("<th  style=\"width:"
						+ width9
						+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Value (&#8377)</strong></font></th>");
				brHeader.append("</tr>");
				

				// body part
				if (wsItem.size() > 0) {
					while (wsItem.next()) {
						if (!prevItemName.equalsIgnoreCase(wsItem.getString(1) == null ? "NA": wsItem.getString(1))
								|| !prevBatch.equalsIgnoreCase(wsItem
										.getString(10) == null ? "NA" : wsItem
										.getString(10))) {

							// not in first time
							if (slNo > 0) {
								grandTotalQty = 0;
								grandTotalValue = 0.00;
								totalQty = 0;
								strPrevDistId = "";

								for (counter = 0; counter < storeSize; counter++) {
									tempQty = storeValue[counter].split("\\^")[0];
									tempValue = storeValue[counter]
											.split("\\^")[1];
									tempDistId = storeValue[counter]
											.split("\\^")[2];

									if (!strPrevDistId.equals(tempDistId)
											&& counter > 0
											&& vo.getStrDistrictStoreId().equals("0")) {
										br.append("<td  style=\"width:"+ width10
												+ "%;\" align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
												+ totalQty + "/"+tempValue+" </font></td>");
										totalQty = 0;
									}

									br.append("<td  style=\"width:"+ width10+ "%;\" align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
											+ tempQty + "/"+tempValue+"</font></td>");

									if (!tempQty.equals("--")) {
										grandTotalQty = grandTotalQty+ Integer.parseInt(tempQty);
										totalQty = totalQty+ Integer.parseInt(tempQty);

										if (vo.getStrBatchWiseChkFlg().equals("1"))
											grandTotalValue = grandTotalValue+ (Integer.parseInt(tempQty) * Double.parseDouble(tempValue));
										else
											grandTotalValue = grandTotalValue+ Double.parseDouble(tempValue);
									}

									strPrevDistId = tempDistId;
								}

								if (counter > 0&& vo.getStrDistrictStoreId().equals("0")){
									br.append("<td  style=\"width:"+ width10+ "%;\" align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
											+ totalQty + "</font></td>");
								}
									

								if (vo.getStrDistrictId().equals("0")){
									br.append("<td  style=\"width:"
											+ width10
											+ "%;\" align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
											+ grandTotalQty + "</font></td>");
								}
									

								br.append("<td  style=\"width:"
										+ width9
										+ "%;\" align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
										+ myFormatter.format(grandTotalValue)
										+ "</font></td>");
								br.append("</tr>");
								
								
								groupSubTotal+=grandTotalValue;
								
								
							
								
								if(!strGroupName.equals(wsItem.getString(2).split("\\^")[3].trim()))	
									{	
										
										br.append("<tr>");
										int colspan_count=6+storeSize;
										br.append("<td colspan='"+colspan_count+"' style='text-align:right;border: 1px solid lightgrey; width:"+ width1+"%;'>Total For "+strPrevGroupName+"</td>");
										/*br.append("<td  style=\"width:"+ width1+ "%;\" align='center'></td>");
										br.append("<td  style='text-align:left;border: 1px solid lightgrey; width:"+ width2+"%;'></td>");
									    br.append("<td  style=\"width:" + width3 + "%;\" align='center'></td>");
										br.append("<td  style=\"width:" + width4 + "%;\" align='center'></td>");
										for(int i=0;i<storeSize;i++)
										{
										br.append("<td  style=\"width:"+ width10 + "%;\" align='right'></td>");
										}
										br.append("<td style=\"width:"+ width10+ "%;\" align='center'>Total For "+strPrevGroupName+"</td>");*/									 
										br.append("<td style=\"width:"+ width9 + "%;\" align='right'>"+ myFormatter.format(groupSubTotal)+"</td>");										
										br.append("</tr>");	
										
										groupSubTotal=0.00;
										
									}
								
								
																 
							}												
							slNo++;
							
							

							// reset the array
							for (counter = 0; counter < storeSize; counter++) {
								storeValue[counter] = "--^--^"
										+ storeValue[counter].split("\\^")[2];
							}
							
							
														

							if(groupCount==0)
							{
								 strGroupName =wsItem.getString(2).split("\\^")[3].trim();
								 int colspan_count=7+storeSize;
								 br.append("<tr>");
								/* br.append("<td  colspan="+colspan_count+" style='text-align:left;border: 1px solid lightgrey;'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Group Name : <u>"
									).append(  wsItem.getString(2).split("\\^")[0] ).append( "</u></b></font></td>");					*/			 												
								br.append("<td colspan='1' style=\"width:"+ width1+ "%;\" align='center'></td>");
								br.append("<td colspan='1' style=\"width:"+ width1+ "%;\" align='center'></td>");
								 br.append("<td   colspan='1'style='text-align:left;border: 1px solid lightgrey; width:"+ width2+"%;'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Group Name : <u>"
									).append(  wsItem.getString(2).split("\\^")[0] ).append( "</u></b></font></td>");	
								 br.append("<td colspan='1' style=\"width:"+ width3+ "%;\" align='center'></td>");
								 br.append("<td colspan='1' style=\"width:"+ width4+ "%;\" align='center'></td>");									 
								 for(int i=0;i<storeSize;i++)
								 {
									 br.append("<td  style=\"width:"+ width10 + "%;\" align='right'></td>");
								 }
								 br.append("<td style=\"width:"+ width10+ "%;\" align='center'></td>");								 
								 br.append("<td style=\"width:"+ width9 + "%;\" align='center'></td>");
								 br.append("</tr>");
							}
							
							
							
							if(strGroupName.equals(wsItem.getString(2).split("\\^")[3].trim()))	
							{
								strPrevGroupName=wsItem.getString(2).split("\\^")[0].trim();									
								br.append("<tr>");
								br.append("<td  style=\"width:"
										+ width1
										+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
										+ slNo + "</font></td>");
								
								br.append("<td  style=\"width:"
										+ width1
										+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
										+ wsItem.getString(2).split("\\^")[2] + "</font></td>");
								
								br.append("<td  style=\"width:"
										+ width2
										+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
										+ wsItem.getString(1) + "</font></td>");
								br.append("<td  style=\"width:"
										+ width3
										+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
										+ wsItem.getString(2).split("\\^")[0]
										+ "</font></td>");
								br.append("<td  style=\"width:"
										+ width4
										+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
										+ wsItem.getString(2).split("\\^")[1]
										+ "</font></td>");

								if (vo.getStrBatchWiseChkFlg().equals("1")) {
									br.append("<td  style=\"width:"
											+ width5
											+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
											+ wsItem.getString(10) + "</font></td>");
									br.append("<td  style=\"width:"
											+ width6
											+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
											+ wsItem.getString(3) + "</font></td>");
									br.append("<td  style=\"width:"
											+ width7
											+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
											+ wsItem.getString(4) + "</font></td>");
									br.append("<td  style=\"width:"
											+ width8
											+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
											+ wsItem.getString(5) + "</font></td>");
								}

								keyValue = Integer.parseInt(map.get(wsItem.getString(9))==null?"0":map.get(wsItem.getString(9)));
								storeValue[keyValue] = wsItem.getString(7) + "^"
										+ wsItem.getString(8) + "^"
										+ storeValue[keyValue].split("\\^")[2];
							} 
														
							else {
								int colspan_count = 7 + storeSize;
								strGroupName = wsItem.getString(2).split("\\^")[3].trim();
								strPrevGroupName=wsItem.getString(2).split("\\^")[0].trim();								
							  	br.append("<tr>");
							    /*br.append("<td colspan='"+colspan_count+"' style='text-align:left;border: 1px solid lightgrey; width:"+ width1+"%;'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Group Name : <u>"
									).append(  wsItem.getString(2).split("\\^")[0] ).append( "</u></b></font></td>");*/
							    br.append("<td  style=\"width:"+ width1+ "%;\" align='center'></td>");
							    br.append("<td  style=\"width:"+ width1+ "%;\" align='center'></td>");
								br.append("<td   style='text-align:left;border: 1px solid lightgrey; width:"+ width2+"%;'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Group Name : <u>"
									).append(  wsItem.getString(2).split("\\^")[0] ).append( "</u></b></font></td>");
								br.append("<td  style=\"width:" + width3 + "%;\" align='center'></td>");
								br.append("<td  style=\"width:" + width4 + "%;\" align='center'></td>");
								 
								for(int i=0;i<storeSize;i++)
								 {
									 br.append("<td  style=\"width:"+ width10 + "%;\" align='right'></td>");
								 }
								br.append("<td style=\"width:"+ width10+ "%;\" align='center'></td>");
								 
								br.append("<td style=\"width:"+ width9 + "%;\" align='center'></td>");
								 
								br.append("</tr>");								
																
								br.append("<tr>");
								
								br.append("<td  style=\"width:"
										+ width1
										+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
										+ slNo + "</font></td>");
								
								br.append("<td  style=\"width:"
										+ width1
										+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
										+ wsItem.getString(2).split("\\^")[2] + "</font></td>");
								
								br.append("<td  style=\"width:"
										+ width2
										+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
										+ wsItem.getString(1) + "</font></td>");
								br.append("<td  style=\"width:"
										+ width3
										+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
										+ wsItem.getString(2).split("\\^")[0]
										+ "</font></td>");
								br.append("<td  style=\"width:"
										+ width4
										+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
										+ wsItem.getString(2).split("\\^")[1]
										+ "</font></td>");

								if (vo.getStrBatchWiseChkFlg().equals("1")) {
									br.append("<td  style=\"width:"
											+ width5
											+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
											+ wsItem.getString(10) + "</font></td>");
									br.append("<td  style=\"width:"
											+ width6
											+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
											+ wsItem.getString(3) + "</font></td>");
									br.append("<td  style=\"width:"
											+ width7
											+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
											+ wsItem.getString(4) + "</font></td>");
									br.append("<td  style=\"width:"
											+ width8
											+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
											+ wsItem.getString(5) + "</font></td>");
								}

								keyValue = Integer.parseInt(map.get(wsItem.getString(9))==null?"0":map.get(wsItem.getString(9)));
								storeValue[keyValue] = wsItem.getString(7) + "^"
										+ wsItem.getString(8) + "^"
										+ storeValue[keyValue].split("\\^")[2];
								
								
							}
																																								
							groupCount++;
							//groupSubTotal=0.00;
			
						} else {
							keyValue =Integer.parseInt(map.get(wsItem.getString(9))==null?"0":map.get(wsItem.getString(9)));
							storeValue[keyValue] = wsItem.getString(7) + "^"
									+ wsItem.getString(8) + "^"
									+ storeValue[keyValue].split("\\^")[2];
						}

						prevItemName = wsItem.getString(1) == null ? "NA"
								: wsItem.getString(1);
						prevBatch = wsItem.getString(10) == null ? "NA"
								: wsItem.getString(10);

						dataFlag++;
					}

					// last row
					if (dataFlag > 0) {
						grandTotalQty = 0;
						grandTotalValue = 0.00;
						totalQty = 0;
						strPrevDistId = "";

						for (counter = 0; counter < storeSize; counter++) {
							tempQty = storeValue[counter].split("\\^")[0];
							tempValue = storeValue[counter].split("\\^")[1];
							tempDistId = storeValue[counter].split("\\^")[2];
							

							if (!strPrevDistId.equals(tempDistId)
									&& counter > 0
									&& vo.getStrDistrictStoreId().equals("0")) {
								br.append("<td  style=\"width:"
										+ width10
										+ "%;\" align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
										+ totalQty + "/"+tempValue+" </font></td>");
								totalQty = 0;
							}

							br.append("<td  style=\"width:"
									+ width10
									+ "%;\" align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
									+ tempQty + "/"+tempValue+"</font></td>");

							if (!tempQty.equals("--")) {
								grandTotalQty = grandTotalQty
										+ Integer.parseInt(tempQty);
								totalQty = totalQty + Integer.parseInt(tempQty);

								if (vo.getStrBatchWiseChkFlg().equals("1"))
									grandTotalValue = grandTotalValue
											+ (Integer.parseInt(tempQty) * Double
													.parseDouble(tempValue));
								else
									grandTotalValue = grandTotalValue
											+ Double.parseDouble(tempValue);
							}

							strPrevDistId = tempDistId;
						}

						if (counter > 0
								&& vo.getStrDistrictStoreId().equals("0")){
							br.append("<td  style=\"width:"
									+ width10
									+ "%;\" align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
									+ totalQty + "</font></td>");
						}
							

						if (vo.getStrDistrictId().equals("0")){
							br.append("<td  style=\"width:"
									+ width10
									+ "%;\" align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
									+ grandTotalQty + "</font></td>");
						}
							

						br.append("<td  style=\"width:"
								+ width9
								+ "%;\" align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
								+ myFormatter.format(grandTotalValue)
								+ "</font></td>");
						br.append("</tr>");
						
						groupSubTotal+=grandTotalValue;
						
						
						
				 		int colspan_count=6+storeSize;
						br.append("<tr>");
						br.append("<td colspan='"+colspan_count+"' style='text-align:right;border: 1px solid lightgrey; width:"+ width1+"%;'>Total For "+strPrevGroupName+"</td>");
						/*br.append("<td  style=\"width:"+ width1+ "%;\" align='center'></td>");
						br.append("<td style='text-align:left;border: 1px solid lightgrey; width:"+ width2+"%;'></td>");
					    br.append("<td  style=\"width:" + width3 + "%;\" align='center'></td>");
						br.append("<td  style=\"width:" + width4 + "%;\" align='center'></td>");
						for(int i=0;i<storeSize;i++)
						{
						br.append("<td  style=\"width:"+ width10 + "%;\" align='right'></td>");
						}
						br.append("<td style=\"width:"+ width10+ "%;\" align='center'>Total For "+strPrevGroupName+"</td>");*/									 
						br.append("<td style=\"width:"+ width9 + "%;\" align='right'>"+ myFormatter.format(grandTotalValue)+"</td>");
						br.append("</tr>");
						groupSubTotal=0.00;
						
							 
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
					brHeader.append("<th  width='5%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>S.No.</strong></font></th>");
					brHeader.append("<th  width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Item Name</strong></font></th>");
					brHeader.append("<th  width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Name</strong></font></th>");
					brHeader.append("<th  width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Item Type</strong></font></th>");

					brHeader.append("<th  width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Batch No</strong></font></th>");
					brHeader.append("<th  width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Expiry Date</strong></font></th>");
					brHeader.append("<th  width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Supplier Name</strong></font></th>");
					brHeader.append("<th  width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Rate</strong></font></th>");

					brHeader.append("<th  width='5%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Stock qty</strong></font></th>");
					brHeader.append("<th  width='5%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total</strong></font></th>");
					brHeader.append("<th  width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Value (&#8377)</strong></font></th>");
				} else {
					nColspan = 7;
					brHeader.append("<th  width='5%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>S.No.</strong></font></th>");
					brHeader.append("<th  width='25%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Item Name</strong></font></th>");
					brHeader.append("<th  width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Name</strong></font></th>");
					brHeader.append("<th  width='15%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Item Type</strong></font></th>");
					brHeader.append("<th  width='15%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Stock qty</strong></font></th>");
					brHeader.append("<th  width='15%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total</strong></font></th>");
					brHeader.append("<th  width='15%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Value (&#8377)</strong></font></th>");
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
	 * @param vo
	 *            the vo
	 * @param tableHeader
	 *            the table header
	 * @param strDBHeader
	 *            the str db header
	 * @param formBean
	 *            the form bean
	 * @param strIndentItemList
	 *            the str indent item list
	 * @param request
	 *            the request
	 * @return the prints the indent details
	 */
	public static String getPrintIndentDetails(StockSummaryDateWiseRptVO vo,
			String tableHeader, String strDBHeader,
			StockSummaryDateWiseRptFB formBean, String strIndentItemList,
			HttpServletRequest request) {
		StringBuffer sb = new StringBuffer("");
		String[] tblHdrArr;
		ResourceBundle res = ResourceBundle
				.getBundle("hisglobal.hisconfig.hisReport");
		mms.qryHandler_mms.res = res;
		

		try {
			
			String currDate = "";
						
			tblHdrArr = strDBHeader.split("\\^");
			/*sb.append("<tr><td align='center'><div id='saveId' style='display : block'><div id='printid1' class='hidecontrol' style='float: left; width: 22%;' ><div id ='printImg'>");
			sb.append("<img style='cursor: pointer;' align='left' title='Save As Excel' src='../../hisglobal/images/excel1.png' onClick='document.getElementById(\"reportHeaderName\").style.color=\"black\";generateXLSCommon(event, \"indentItemListDivId\");document.getElementById(\"reportHeaderName\").style.color=\"white\";'/>");   
			sb.append("<br><img style='cursor: pointer; ' align='left' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='cancelPrintToDesk();' /></div>");
			sb.append("<br><p style='text-align:left'><font face='Verdana, Arial, Helvetica, sans-serif' size='2' style='text-align:left'><b>Report Date : </b>"
					+ currDate + "</font>");
			sb.append("<br><font face='Verdana, Arial, Helvetica, sans-serif' size='2' style='text-align:left'><b>User Name : </b>"
					+ formBean.getStrUserName() + "</font></p>");
			sb.append("</div>");
			sb.append("<div style='width: 62%; margin-left: 0%;'><table width='100%' cellspacing='0' cellpadding='0' border='0' align='center' id='mstHeaderTable' style='font-weight: bold; font-family: verdana;'><tbody>");
			sb.append("<tr><td width='100%' align='center' >");
			sb.append("<center><table>");
			sb.append("<tbody><tr><td style='text-align:center;'><img  align='absmiddle' src='/INVMGM/hisglobal/images/aiims_inv_header.png'/></td> ");

			sb.append("</tr></tbody></table></center>");
			sb.append("</td></tr>");
			
			
			sb.append("<tr id='reportDisplayHeaderRow'>");
			sb.append("<td id='reportDisplayHeaderData' width='100%' align='center' style='font-size:12px;text-align:center;'> <b>");
			sb.append(tableHeader);
			sb.append("</b></font><br><br>");
			sb.append("</td></tr></table></div></div>");
			sb.append("<br><table width='100%' cellspacing='0' cellpadding='0' border='0' align='center'><tr><td align='center'>"
					+ strIndentItemList + "</td></tr></table>");*/
			
			
			sb.append("<tr>");
			
			
			sb.append("<td width='70%' align='left'><div id='saveId' style='display : block'><div id='printid1' class='hidecontrol' style='float: left; width: 30%;' >");
			sb.append("<p style='text-align:left'><font face='Verdana, Arial, Helvetica, sans-serif' size='2' style='text-align:left'><b>"+"Report Date and Time : </b>"
					+ currDate + "</font>");
			sb.append("<br><font face='Verdana, Arial, Helvetica, sans-serif' size='2' style='text-align:left'><b>"+"User Name : </b>"
					+ request.getSession().getAttribute("UserFullName").toString() + "</font></p></td>");
			sb.append("<td width='30%' align='right'><div id ='printImg'><img style='cursor: pointer;' align='right' title='Save As Excel' src='../../hisglobal/images/excel1.png' onClick='document.getElementById(\"reportHeaderName\").style.color=\"black\";generateXLSCommon(event, \"indentItemListDivId\");document.getElementById(\"reportHeaderName\").style.color=\"white\";'/>");
			sb.append("<img style='cursor: pointer; ' align='right' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='cancelPrintToDesk();' /></div>");
			sb.append("</div></td></tr>");
			sb.append("<tr><td width='100%' align='center' colspan='2'><div style='width: 62%; margin-left: 0%;'><table width='100%' cellspacing='0' cellpadding='0' border='0' align='center' id='mstHeaderTable' style='font-weight: bold; font-family: verdana;'><tbody>");
			sb.append("<tr><td width='100%' align='center' >");
			sb.append("<img  align='center' src='/INVMGM/hisglobal/images/aiims_inv_header.png'/>");
			sb.append("</td></tr>");	
			sb.append("<tr id='reportDisplayHeaderRow'>");
			sb.append("<td id='reportDisplayHeaderData' width='100%' align='center' style='padding-left:20px;font-size:11px;' colspan='2'> <b>");
			sb.append(tableHeader);
			sb.append("</font><br><br>");
			sb.append("</td></tr></table></div></div>");
			sb.append("<br><tr><td width='100%'  colspan='2'><table width='100%' cellspacing='0' cellpadding='0' border='0' align='center'><tr><td align='center'>"
					+ strIndentItemList + "</td></tr></table>");

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("PurchaseOrderDtlRptHLP.getPrintIndentDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}

	
	public static String printZeroStockDrugList2(StockSummaryDateWiseRptVO vo, HttpServletRequest request)
	throws Exception {
	int storeSize = 0;
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
	
	String[] storeValue = null;
	int dataFlag = 0;
	DecimalFormat myFormatter = new DecimalFormat("0.00");
	
	String strPrevDistId = "";
	String strPrevDistName = "";
	String tempQty = "";
	String tempValue = "";
	String tempDistId = "";
	String prevBatch = "";
	int nColspan = 0;
	
	try {
		/*
		 * 1-Item Name 2-GroupName^Item Type Name 3-Expiry Date 4-Supp Name
		 * 5-Rate Unit 6-Store Name 7-Qty 8.Amt (without batch)/Rate in base
		 * (with batch) 9.Store Id 10. Batch No /* 1-Store Id 2-Store Name
		 * 3. District Id 4. District Name
		 */
	
		if (vo.getStrBatchWiseChkFlg().equals("1")) {
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
		} else {
			tblWidth = 90;
			nTblWidth = 90;
	
			width1 = 6;
			width2 = 40;
			width3 = 22;
			width4 = 16;
			width9 = 16;
	
			width10 = 10;
		}
	
		// table width that has to add in original table width should be as
		// follows, propTblWidth should be in integer not in double
		propTblWidth = (int) (tblWidth * width10) / 100;
	
		ws = vo.getStrHeaderWS(); // Header
		wsItem = vo.getStrDrugListWS(); // Stock on hand
	
		storeSize = ws.size();
	
		if (storeSize > 0) {
			while (ws.next()) {
				// district total if all option in store combo
				if (vo.getStrDistrictStoreId().equals("0")) {
					if (counter > 1
							&& !strPrevDistId.equals(ws.getString(3))) {
						nTblWidth += propTblWidth;
					}
				}
	
				nTblWidth += propTblWidth;
	
				strPrevDistId = ws.getString(3);
				counter++;
			}
	
			if (vo.getStrDistrictStoreId().equals("0") && counter > 0)
				nTblWidth += propTblWidth;
	
			if (vo.getStrDistrictId().equals("0"))
				nTblWidth += propTblWidth;
	
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
	
			storeValue = new String[storeSize];
	
			// make header
			brHeader.append("<div id='wrapper'><table id='mainTableRptId' width='100%' align='center' cellspacing='0px' cellpadding='1px' border=1>");
			brHeader.append("<tr id='tableHeaderId'>");
			brHeader.append("<th colspan='1' style=\"width:"
					+ width1
					+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>S.No.</strong></font></th>");
			
			brHeader.append("<th colspan='1' style=\"width:"
					+ width1
					+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Drug Code</strong></font></th>");
			
			brHeader.append("<th colspan='1' style=\"width:"
					+ width2
					+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Item Name</strong></font></th>");
			brHeader.append("<th colspan='1' style=\"width:"
					+ width3
					+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Name</strong></font></th>");
			brHeader.append("<th colspan='1' style=\"width:"
					+ width4
					+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Item Type</strong></font></th>");
			nColspan = 4;
	
			if (vo.getStrBatchWiseChkFlg().equals("1")) {
				brHeader.append("<th colspan='1' style=\"width:"
						+ width5
						+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Batch No.</strong></font></th>");
				brHeader.append("<th colspan='1' style=\"width:"
						+ width6
						+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Expiry Date</strong></font></th>");
				brHeader.append("<th colspan='1' style=\"width:"
						+ width7
						+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Supplier Name</strong></font></th>");
				brHeader.append("<th colspan='1' style=\"width:"
						+ width8
						+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Rate</strong></font></th>");
	
				nColspan = nColspan + 4;
			}
	
			// store header
			map = new HashMap<String, String>();
			String strStoreName = "";
			while (ws.next()) {
				storeValue[counter] = "--^--^" + ws.getString(3);
				map.put(ws.getString(1), String.valueOf(counter++));
	
				// district total if all option in store combo
				if (vo.getStrDistrictStoreId().equals("0")) {
					if (counter > 1
							&& !strPrevDistId.equals(ws.getString(3))) {
						brHeader.append("<th colspan='1' style=\"width:"
								+ width10
								+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
								+ strPrevDistName
								+ " Total</strong></font></th>");
						nColspan = nColspan + 1;
					}
				}
	
				strStoreName = ws.getString(2);
	
				brHeader.append("<th colspan='1' style=\"width:"
						+ width10
						+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
						+ strStoreName + " (No.)</strong></font></th>");
				nColspan = nColspan + 1;
	
				strPrevDistId = ws.getString(3);
				strPrevDistName = ws.getString(4);
			}
	
			if (vo.getStrDistrictStoreId().equals("0") && counter > 0) {
				nColspan = nColspan + 1;
				brHeader.append("<th colspan='1' style=\"width:"
						+ width10
						+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
						+ strPrevDistName + " Total (No.)</strong></font></th>");
			}
	
			if (vo.getStrDistrictId().equals("0")) {
				nColspan = nColspan + 1;
				brHeader.append("<th colspan='1' style=\"width:"
						+ width10
						+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total (No.)</strong></font></th>");
			}
	
			nColspan = nColspan + 1;
			brHeader.append("<th colspan='1' style=\"width:"
					+ width9
					+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Value (&#8377)</strong></font></th>");
			brHeader.append("</tr>");
	
			// body part
			if (wsItem.size() > 0) {
				while (wsItem.next()) {
					if (!prevItemName
							.equalsIgnoreCase(wsItem.getString(1) == null ? "NA"
									: wsItem.getString(1))
							|| !prevBatch.equalsIgnoreCase(wsItem
									.getString(10) == null ? "NA" : wsItem
									.getString(10))) {
	
						// not in first time
						if (slNo > 0) {
							grandTotalQty = 0;
							grandTotalValue = 0.00;
							totalQty = 0;
							strPrevDistId = "";
	
							for (counter = 0; counter < storeSize; counter++) {
								tempQty = storeValue[counter].split("\\^")[0];
								tempValue = storeValue[counter]
										.split("\\^")[1];
								tempDistId = storeValue[counter]
										.split("\\^")[2];
	
								if (!strPrevDistId.equals(tempDistId)
										&& counter > 0
										&& vo.getStrDistrictStoreId()
												.equals("0")) {
									br.append("<td colspan='1' style=\"width:"
											+ width10
											+ "%;\" align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
											+ totalQty + "</font></td>");
									totalQty = 0;
								}
	
								br.append("<td colspan='1' style=\"width:"
										+ width10
										+ "%;\" align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
										+ tempQty + "</font></td>");
	
								if (!tempQty.equals("--")) {
									grandTotalQty = grandTotalQty
											+ Integer.parseInt(tempQty);
									totalQty = totalQty
											+ Integer.parseInt(tempQty);
	
									if (vo.getStrBatchWiseChkFlg().equals(
											"1"))
										grandTotalValue = grandTotalValue
												+ (Integer
														.parseInt(tempQty) * Double
														.parseDouble(tempValue));
									else
										grandTotalValue = grandTotalValue
												+ Double.parseDouble(tempValue);
								}
	
								strPrevDistId = tempDistId;
							}
	
							if (counter > 0
									&& vo.getStrDistrictStoreId().equals(
											"0"))
								br.append("<td colspan='1' style=\"width:"
										+ width10
										+ "%;\" align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
										+ totalQty + "</font></td>");
	
							if (vo.getStrDistrictId().equals("0"))
								br.append("<td colspan='1' style=\"width:"
										+ width10
										+ "%;\" align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
										+ grandTotalQty + "</font></td>");
	
							br.append("<td colspan='1' style=\"width:"
									+ width9
									+ "%;\" align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
									+ myFormatter.format(grandTotalValue)
									+ "</font></td>");
							br.append("</tr>");
	
						}
	
						slNo++;
	
						// reset the array
						for (counter = 0; counter < storeSize; counter++) {
							storeValue[counter] = "--^--^"
									+ storeValue[counter].split("\\^")[2];
						}
	
						br.append("<tr>");
						br.append("<td colspan='1' style=\"width:"
								+ width1
								+ "%;\" align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
								+ slNo + "</font></td>");
						
						
						br.append("<td colspan='1' style=\"width:"
								+ width1
								+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
								+ wsItem.getString(2).split("\\^")[2] + "</font></td>");
						
						br.append("<td colspan='1' style=\"width:"
								+ width2
								+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
								+ wsItem.getString(1) + "</font></td>");
						br.append("<td colspan='1' style=\"width:"
								+ width3
								+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
								+ wsItem.getString(2).split("\\^")[0]
								+ "</font></td>");
						br.append("<td colspan='1' style=\"width:"
								+ width4
								+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
								+ wsItem.getString(2).split("\\^")[1]
								+ "</font></td>");
	
						if (vo.getStrBatchWiseChkFlg().equals("1")) {
							br.append("<td colspan='1' style=\"width:"
									+ width5
									+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
									+ wsItem.getString(10) + "</font></td>");
							br.append("<td colspan='1' style=\"width:"
									+ width6
									+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
									+ wsItem.getString(3) + "</font></td>");
							br.append("<td colspan='1' style=\"width:"
									+ width7
									+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
									+ wsItem.getString(4) + "</font></td>");
							br.append("<td colspan='1' style=\"width:"
									+ width8
									+ "%;\" align='left'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
									+ wsItem.getString(5) + "</font></td>");
						}
	
						keyValue = Integer.parseInt(map.get(wsItem.getString(9))==null?"0":map.get(wsItem.getString(9)));
						storeValue[keyValue] = wsItem.getString(7) + "^"
								+ wsItem.getString(8) + "^"
								+ storeValue[keyValue].split("\\^")[2];
					} else {
						keyValue =Integer.parseInt(map.get(wsItem.getString(9))==null?"0":map.get(wsItem.getString(9)));
						storeValue[keyValue] = wsItem.getString(7) + "^"
								+ wsItem.getString(8) + "^"
								+ storeValue[keyValue].split("\\^")[2];
					}
	
					prevItemName = wsItem.getString(1) == null ? "NA"
							: wsItem.getString(1);
					prevBatch = wsItem.getString(10) == null ? "NA"
							: wsItem.getString(10);
	
					dataFlag++;
				}
	
				// last row
				if (dataFlag > 0) {
					grandTotalQty = 0;
					grandTotalValue = 0.00;
					totalQty = 0;
					strPrevDistId = "";
	
					for (counter = 0; counter < storeSize; counter++) {
						tempQty = storeValue[counter].split("\\^")[0];
						tempValue = storeValue[counter].split("\\^")[1];
						tempDistId = storeValue[counter].split("\\^")[2];
	
						if (!strPrevDistId.equals(tempDistId)
								&& counter > 0
								&& vo.getStrDistrictStoreId().equals("0")) {
							br.append("<td colspan='1' style=\"width:"
									+ width10
									+ "%;\" align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
									+ totalQty + "</font></td>");
							totalQty = 0;
						}
	
						br.append("<td colspan='1' style=\"width:"
								+ width10
								+ "%;\" align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
								+ tempQty + "</font></td>");
	
						if (!tempQty.equals("--")) {
							grandTotalQty = grandTotalQty
									+ Integer.parseInt(tempQty);
							totalQty = totalQty + Integer.parseInt(tempQty);
	
							if (vo.getStrBatchWiseChkFlg().equals("1"))
								grandTotalValue = grandTotalValue
										+ (Integer.parseInt(tempQty) * Double
												.parseDouble(tempValue));
							else
								grandTotalValue = grandTotalValue
										+ Double.parseDouble(tempValue);
						}
	
						strPrevDistId = tempDistId;
					}
	
					if (counter > 0
							&& vo.getStrDistrictStoreId().equals("0"))
						br.append("<td colspan='1' style=\"width:"
								+ width10
								+ "%;\" align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
								+ totalQty + "</font></td>");
	
					if (vo.getStrDistrictId().equals("0"))
						br.append("<td colspan='1' style=\"width:"
								+ width10
								+ "%;\" align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
								+ grandTotalQty + "</font></td>");
	
					br.append("<td colspan='1' style=\"width:"
							+ width9
							+ "%;\" align='right'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
							+ myFormatter.format(grandTotalValue)
							+ "</font></td>");
					br.append("</tr>");
				}
	
			} else {
				br.append("<tr>");
				br.append("<td colspan='"
						+ nColspan
						+ "' width='100%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>No Data Found</strong></font></td>");
				br.append("</tr>");
			}
	
		} else {
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
	
				brHeader.append("<th colspan='1' width='5%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Stock Qty. (No.)</strong></font></th>");
				brHeader.append("<th colspan='1' width='5%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total (No.)</strong></font></th>");
				brHeader.append("<th colspan='1' width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Value (&#8377)</strong></font></th>");
			} else {
				nColspan = 7;
				brHeader.append("<th colspan='1' width='5%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>S.No.</strong></font></th>");
				brHeader.append("<th colspan='1' width='25%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Item Name</strong></font></th>");
				brHeader.append("<th colspan='1' width='10%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Name</strong></font></th>");
				brHeader.append("<th colspan='1' width='15%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Item Type</strong></font></th>");
				brHeader.append("<th colspan='1' width='15%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Stock Qty.</strong></font></th>");
				brHeader.append("<th colspan='1' width='15%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total (No.)</strong></font></th>");
				brHeader.append("<th colspan='1' width='15%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Value (&#8377)</strong></font></th>");
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

}
