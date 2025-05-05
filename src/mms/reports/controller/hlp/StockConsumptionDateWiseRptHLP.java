/**********************************************************
 Project:	   DWH_PHD_OPEN	
 File:         StockConsumptionDateWiseRptHLP.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.controller.hlp;

import hisglobal.hisconfig.HisLanguageProperties;
import hisglobal.utility.HisUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import mms.reports.controller.fb.ConsumptionDetailRptFB_NEW;
import mms.reports.vo.ConsumptionDetailRptVO_NEW;

// TODO: Auto-generated Javadoc
/**
 * The Class StockConsumptionDateWiseRptHLP.
 */
public class StockConsumptionDateWiseRptHLP {

	/** The ws item. */
	WebRowSet wsItem = null;

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
	public String printZeroStockDrugList(ConsumptionDetailRptVO_NEW vo, HttpServletRequest request)
			throws Exception {
		int daySize = 0;
		int counter = 0;
		int slNo = 0;
		int i = 0;
		int recordCount = 0;

		StringBuffer br = new StringBuffer(2000);
		StringBuffer brHeader = new StringBuffer(2000);
		String htmlStr = "";

		int tblWidth = 100;
		int width1 = 5;
		int width2 = 62;
		int width3 = 10;
		int width4 = 15;
		int width5 = 8;

		String prevStoreName = "";
		String prevItemName = "";
		String strFuncValue = "";

		long totalQty = 0L;
		int dataFlag = 0;
		int nColspan = 0;

		int range1 = 0;
		int range2 = 0;
		int range3 = 0;

		String[] tempStr = null;
		String[] consValue = null;

		List<String> dayList = null;

		try {
			/*
			 * 1-Month 2-Year 3-Store Name 4-Item Name 5-Total Active Qty
			 * 6-Total Quar Qty 7-Total Rej Qty 8.Issue Qty [1..31]
			 */

			wsItem = vo.getStrDrugListWS(); // PKG_MMS_RPT.Rptm_consumption_dtl_new
			//System.out.println("wsitem"+wsItem);								// [Mode =1]
			strFuncValue = vo.getStrFuncValue(); // Mms_Mst.get_daterange_consumption_rpt[Mode
			//System.out.println("funvalue"+strFuncValue);										// =1]

			tempStr = strFuncValue.split("\\#");
			daySize = tempStr.length;
			//System.out.println("daysize"+daySize);
			if (wsItem.size() > 0 && daySize > 0) 
			{
				dayList = new ArrayList<String>(1);

				// calculate table width/column width
				i = ((width5 * daySize) - width5);
				width2 = width2 - i;

				consValue = new String[daySize];

				nColspan = 4;
				// make header
				brHeader.append("<div id='wrapper'><table id='mainTableRptId' width='100%' align='center' cellspacing='0px' cellpadding='1px' border=1>");
				brHeader.append("<tr id='tableHeaderId'>");
				brHeader.append("<th colspan='1' width='"
						+ (int) width1
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+"S.NO."+"</strong></font></th>");
				brHeader.append("<th colspan='1' width='"
						+ (int) width2
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+"Item_Name"+"</strong></font></th>");
				brHeader.append("<th colspan='1' width='"
						+ (int) width3
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+"Total"+" Qty.</strong></font></th>");
				brHeader.append("<th colspan='1' width='"
						+ (int) width4
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+"Location"+"</strong></font></th>");

				for (i = 0; i < daySize; i++) 
				{
					dayList.add(tempStr[i]);
					brHeader.append("<th colspan='1' width='"
							+ (int) width5
							+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
							+ tempStr[i].split("\\^")[0]
							+ "</strong></font></th>");
					nColspan++;
				}

				brHeader.append("</tr>");

				// body part
				while (wsItem.next()) 
				{
					if (!prevItemName
							.equalsIgnoreCase(wsItem.getString(4) == null ? "NA"
									: wsItem.getString(4))
							|| !prevStoreName.equalsIgnoreCase(wsItem
									.getString(3) == null ? "NA" : wsItem
									.getString(3))) {
						// not in first time
						if (slNo > 0) 
						{
							totalQty = 0;
							for (counter = 0; counter < daySize; counter++)
							{
								//System.out.println("dfg"+consValue[counter]);
								totalQty += Long.parseLong(consValue[counter]);
							}
							if (totalQty > 0) {
								htmlStr += "<td colspan='1' width='"
										+ width3
										+ "%' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
										+ String.valueOf(totalQty)
										+ "</font></th>";
								htmlStr += "<td colspan='1' width='"
										+ width4
										+ "%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
										+ prevStoreName + "</font></th>";

								for (counter = 0; counter < daySize; counter++)
									htmlStr += "<td colspan='1' width='"
											+ width5
											+ "%' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
											+ consValue[counter]
											+ "</font></th>";

								htmlStr += "</tr>";

								br.append(htmlStr);
								recordCount = 1;
							}
						}
						
						slNo++;

						// reset the array
						for (counter = 0; counter < daySize; counter++)
							consValue[counter] = "0";

						htmlStr = "<tr>";
						htmlStr += "<td colspan='1' width='"
								+ width1
								+ "%' style=\"text-align:center;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
								+ slNo + "</font></td>";
						htmlStr += "<td colspan='1' width='"
								+ width2
								+ "%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
								+ wsItem.getString(4) + "</font></td>";
					}
                   
					for (counter = 0; counter < daySize; counter++) 
					{
						// 0-30^dd[start)^mm(start)^yyyy(start)^dd[end)^mm(end)^yyyy(end)
						tempStr = ((String) dayList.get(counter)).split("\\^");						

						if (!wsItem.getString(1).equals("10")
								&& !wsItem.getString(1).equals("11")
								&& !wsItem.getString(1).equals("12"))
							range1 = Integer.parseInt(wsItem.getString(2) + "0"
									+ wsItem.getString(1)); // yyyymm
						else
							range1 = Integer.parseInt(wsItem.getString(2)
									+ wsItem.getString(1)); // yyyymm

						// used as comparision
						if (!tempStr[2].equals("10")
								&& !tempStr[2].equals("11")
								&& !tempStr[2].equals("12"))
							range2 = Integer.parseInt(tempStr[3] + "0"
									+ tempStr[2]); // yyyymm
						else
							range2 = Integer.parseInt(tempStr[3] + tempStr[2]);

						if (!tempStr[5].equals("10")
								&& !tempStr[5].equals("11")
								&& !tempStr[5].equals("12"))
							range3 = Integer.parseInt(tempStr[6] + "0"
									+ tempStr[5]);
						else
							range3 = Integer.parseInt(tempStr[6] + tempStr[5]);
						
						if (range1 >= range2 && range1 <= range3)
						{
							
							consValue[counter] = String.valueOf(Long
									.parseLong(consValue[counter])
									+ getIssuedQty(
											Integer.parseInt(tempStr[1]),
											Integer.parseInt(tempStr[2]),
											Integer.parseInt(tempStr[3]),
											Integer.parseInt(tempStr[4]),
											Integer.parseInt(tempStr[5]),
											Integer.parseInt(tempStr[6])));	
							
						;

						}	
					}

					prevItemName = wsItem.getString(4) == null ? "NA" : wsItem
							.getString(4);
					prevStoreName = wsItem.getString(3) == null ? "NA" : wsItem
							.getString(3);

					dataFlag++;
					
				}
               
				// last row
				if (dataFlag > 0) 
				{
					totalQty = 0;
					for (counter = 0; counter < daySize; counter++)
						totalQty += Long.parseLong(consValue[counter]);
					
					if (totalQty > 0) {
						htmlStr += "<td colspan='1' width='"
								+ width3
								+ "%' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
								+ String.valueOf(totalQty) + "</font></td>";
						htmlStr += "<td colspan='1' width='"
								+ width4
								+ "%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
								+ prevStoreName + "</font></td>";

						for (counter = 0; counter < daySize; counter++)
							htmlStr += "<td colspan='1' width='"
									+ width5
									+ "%' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
									+ consValue[counter] + "</font></td>";

						htmlStr += "</tr>";

						br.append(htmlStr);
						recordCount = 1;
					}
					
				}
				//System.out.println("recordCount"+recordCount);
				if (recordCount == 0) 
				{
					br.append("<tr>");
					br.append("<td colspan='"
							+ nColspan
							+ "' width='100%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+"No_Data_Found"+"</strong></font></td>");
					br.append("</tr>");
				}
			} 
			else 
			{
				// if no data exists then make default header
				brHeader.append("<div id='wrapper'><table id='mainTableRptId' width='100%' align='center' cellspacing='0px' cellpadding='1px' border=1>");
				brHeader.append("<tr id='tableHeaderId'>");
				brHeader.append("<th colspan='1' width='"
						+ (int) width1
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+"S.No."+"</strong></font></th>");
				brHeader.append("<th colspan='1' width='"
						+ (int) width2
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+"Item_Name"+"</strong></font></th>");
				brHeader.append("<th colspan='1' width='"
						+ (int) width3
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+"Total_qty"+"</strong></font></th>");
				brHeader.append("<th colspan='1' width='"
						+ (int) width4
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+"Location"+"</strong></font></th>");
				brHeader.append("</tr>");

				br.append("<tr>");
				br.append("<td colspan='4' width='100%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+"No_Data_Found"+"</strong></font></td>");
				br.append("</tr>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (wsItem != null) {
				wsItem.close();
				wsItem = null;
			}

			if (dayList != null)
				dayList = null;
		}

		vo.setStrTableWidth(String.valueOf(tblWidth));
		return (brHeader.append(br).toString() + "</table></div>");
	}

	/**
	 * Gets the issued qty.
	 * 
	 * @param nFromDay
	 *            the n from day
	 * @param nFromMonth
	 *            the n from month
	 * @param nFromYear
	 *            the n from year
	 * @param nToDay
	 *            the n to day
	 * @param nToMonth
	 *            the n to month
	 * @param nToYear
	 *            the n to year
	 * @return the issued qty
	 */
	public long getIssuedQty(int nFromDay, int nFromMonth, int nFromYear,
			int nToDay, int nToMonth, int nToYear) {
		Long nIssueQtyActive = 0L;
		int nDay = 31;

		try {
			// For Issued Qty
			if (nFromMonth == Integer.parseInt(wsItem.getString(1))
					&& nFromYear == Integer.parseInt(wsItem.getString(2))) {
				if ((nFromMonth == nToMonth) && (nFromYear == nToYear))
					nDay = nToDay;

				
				for (int x = nFromDay; x <= nDay; x++) {
					nIssueQtyActive = nIssueQtyActive
							+ Long.parseLong(wsItem.getString("HSTNUM_CONS_QTY"
									+ x));
				}
			} else if (nToMonth == Integer.parseInt(wsItem.getString(1))
					&& nToYear == Integer.parseInt(wsItem.getString(2))) {
				
				for (int x = 1; x <= nToDay; x++) {
					nIssueQtyActive = nIssueQtyActive
							+ Long.parseLong(wsItem.getString("HSTNUM_CONS_QTY"
									+ x));
				}
			} else {
				 nIssueQtyActive = Long.parseLong(wsItem.getString(5));
				 
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return nIssueQtyActive;
	}

	/**
	 * Gets the prints the indent details.
	 * 
	 * @param vo
	 *            the vo
	 * @param formBean
	 *            the form bean
	 * @param tableHeader
	 *            the table header
	 * @param strDBHeader
	 *            the str db header
	 * @param strIndentItemList
	 *            the str indent item list
	 * @param request
	 *            the request
	 * @return the prints the indent details
	 */
	public static String getPrintIndentDetails(
			ConsumptionDetailRptVO_NEW vo,
			ConsumptionDetailRptFB_NEW formBean, String tableHeader,
			String strDBHeader, String strIndentItemList,
			HttpServletRequest request) {
		StringBuffer sb = new StringBuffer("");
		String[] tblHdrArr;
		String printDate="";
		HisUtil util=new HisUtil("mms","getPrintIndentDetails");
		try
		{
		printDate=util.getDSDate("DD-MM-YYYY HH24:MI");
		}
		catch(Exception e)
		{
			
		}
		ResourceBundle res = ResourceBundle
				.getBundle("hisglobal.hisconfig.hisReport");
		mms.qryHandler_mms.res = res;

		try {

			tblHdrArr = strDBHeader.split("\\^");	
			String tableHeader1="avc";   //tableHeader.substring(0,tableHeader.indexOf("Store"));
			String tableHeader2="sdfsd";//tableHeader.substring(tableHeader.indexOf("Store"),tableHeader.indexOf("On"));
			String tableHeader3="sfsd";//tableHeader.substring(tableHeader.indexOf("On"));
			sb.append("<table border='0' style='width:100%;' align='center'>");
			sb.append("<tr> ");
			sb.append("<td width='45%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' >Print Date and Time : ");
			sb.append(printDate);	
			sb.append("<br>");
			sb.append("<font face='Verdana, Arial, Helvetica, sans-serif' >UserName : ");
			sb.append("username");//formBean.getStrUserName());
			sb.append("</td>");
			sb.append("<td width='55%' align='right'>");
			sb.append("<div id='saveId' style='display : block'><div id='printid1' class='hidecontrol' style='float: right; width: 22%;' ><div id ='printImg'>");
			sb.append("<img style='cursor: pointer; ' align='right' title='Save as Pdf' src='../../hisglobal/images/pdf.png' onClick='generatePdfCommon(\"indentItemListDivId\");' />");
			sb.append("<img style='cursor: pointer;' align='right' title='Save As Excel' src='../../hisglobal/images/excel1.png' onClick='document.getElementById(\"reportHeaderName\").style.color=\"black\";generateXLSCommon(event, \"indentItemListDivId\");document.getElementById(\"reportHeaderName\").style.color=\"white\";'/>");
			sb.append("<img style='cursor: pointer; ' align='right' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='cancelPrintToDesk();' /></div></div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			sb.append("</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>");
			sb.append("</tr>");		
			
			sb.append("<tr><td></td><td></td><td></td><td></td>");
			sb.append("<td>");
			sb.append("<table align='center' style='width:100%;' border='0' cellspacing='0' cellpadding='0'' style='font-weight: bold; font-family: verdana;'>");
			sb.append("<tr><td></td><td></td><td></td><td></td><td></td> ");
			sb.append("<tr><td></td><td></td><td></td><td></td><td width='100%' align='center'>");
			sb.append("<img src='/INVMGM/hisglobal/images/aiims_inv_header.png'/>");
			sb.append("<br><br></td></td></tr>");
			sb.append("</table> ");
			

			sb.append("<tr><td align='right'>");
			
			
			sb.append("<div style='width: 80%; margin-left: 0%;'><table width='100%' cellspacing='0' cellpadding='0' border='0' align='center' id='mstHeaderTable' style='font-weight: bold; font-family: verdana;'><tbody>");
			sb.append("<tr><td width='100%' colspan='3' align='center' >");
			
			sb.append("</td></tr>");
			sb.append("<tr>");
			if (!tblHdrArr[0].trim().equals("NA")) {
				sb.append("<td style='font-size:12px;text-align:center'>"
						+ tblHdrArr[0] + "</td></tr>");
			} else {
				sb.append("<td style='font-size:12px;text-align:center'>"
						+ res.getString("REPORT_ADDRESS") + "</td></tr>");
			}
			sb.append("</tr>");
			sb.append("<tr id='reportDisplayHeaderRow'>");
			sb.append("<td id='reportDisplayHeaderData' width='100%' align='center' style='padding-left:20px;font-size:11px;'> <b>");
			sb.append(tableHeader1);
			sb.append("<br>");
			sb.append(tableHeader2);
			sb.append("<br>");
			sb.append(tableHeader3);
			sb.append("</font>");
			sb.append("</td></tr>");
			sb.append("</table></div>");
			sb.append("<br><table width='100%' cellspacing='0' cellpadding='0' border='0' align='center'><tr><td align='center'>"+ strIndentItemList + "</td></tr></table>");
			

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("StockConsumptionDateWiseRptHLP.getPrintIndentDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}

}
