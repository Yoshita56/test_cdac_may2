/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         StockOnHandRptHLP.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/


/**********************************************************
 Project:	   DWH_PHD_OPEN	
 File:         StockOnHandRptHLP.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.controller.hlp;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.reports.controller.fb.StockOnHandIgimsRptFB;
import mms.reports.controller.fb.StockOnHandRptFB_NEW;
import mms.reports.vo.StockOnHandIgimsRptVO;
import mms.reports.vo.StockOnHandRptVO_NEW;

public class StockOnHandIgimsRptHLP {

	
	public static String printVitalDrugList(StockOnHandIgimsRptVO vo) throws Exception {
		int programmeSize = 0;
		int counter = 0;
		int slNo = 0;
		int keyValue = 0;

		WebRowSet ws = null;
		WebRowSet wsItem = null;

		StringBuffer br = new StringBuffer(2000);
		StringBuffer brHeader = new StringBuffer(2000);

		HashMap<String, String> map = null;

		int tblWidth = 150;
		double intCellWidth = 7.14;
		double newCellWidth = 0.0;
		double calCellWidth = 0.0;

		double width1 = 3.33;
		double width2 = 6.67;
		double width3 = 5.33;
		double width4 = 10;
		double width5 = 6.67;
		double width6 = 16.67;
		double width7 = 10;
		double width8 = 3.33;
		double width9 = 6.67;
		double width10 = 6.67;
		double width11 = 4.67;
		double width12 = 6.67;
		double width13 = 6.67;
		double width14 = 6.67;

		String prevPONo = "";
		String[] prgValue = null;
		try {

			/*
			 * 1-Item Name 2-Group Name 3-Item Type 4-Batch No 5-Store Id 6-Store Name 7-In-Hand Qty 9-Exp Date 10-Supplier Name 11-Rate
			 */
			/*
			 * 1-Store Id 2-Store Name
			 */
			ws = vo.getStrHeaderWS(); // PO Header
			wsItem = vo.getStrDrugListWS(); // PO Details

			programmeSize = ws.size();
			if (programmeSize > 0) {
				// calculate table width/column width
				if (programmeSize == 1) {
					tblWidth = 150;
				} else {
					tblWidth = (programmeSize - 1) * 10 + 150;
				}

				newCellWidth = 100 / (programmeSize + 13);
				calCellWidth = (newCellWidth * 100) / intCellWidth;

				width1 = (width1 * calCellWidth) / 100;
				if ((int) width1 == 0) {
					width1 = 1;
				}

				width2 = (width2 * calCellWidth) / 100;
				if ((int) width2 == 0) {
					width2 = 1;
				}

				width3 = (width3 * calCellWidth) / 100;
				if ((int) width3 == 0) {
					width3 = 1;
				}

				width4 = (width4 * calCellWidth) / 100;
				if ((int) width4 == 0) {
					width4 = 1;
				}

				width5 = (width5 * calCellWidth) / 100;
				if ((int) width5 == 0) {
					width5 = 1;
				}

				width6 = (width6 * calCellWidth) / 100;
				if ((int) width6 == 0) {
					width6 = 1;
				}

				width7 = (width7 * calCellWidth) / 100;
				if ((int) width7 == 0) {
					width7 = 1;
				}

				width8 = (width8 * calCellWidth) / 100;
				if ((int) width8 == 0) {
					width8 = 1;
				}

				width9 = (width9 * calCellWidth) / 100;
				if ((int) width9 == 0) {
					width9 = 1;
				}

				width10 = (width10 * calCellWidth) / 100;
				if ((int) width10 == 0) {
					width10 = 1;
				}

				width11 = (width11 * calCellWidth) / 100;
				if ((int) width11 == 0) {
					width11 = 1;
				}

				width12 = (width12 * calCellWidth) / 100;
				if ((int) width12 == 0) {
					width12 = 1;
				}

				width13 = (width13 * calCellWidth) / 100;
				if ((int) width13 == 0) {
					width13 = 1;
				}

				width14 = (width14 * calCellWidth) / 100;
				if ((int) width14 == 0) {
					width14 = 1;
				}

				// make header
				brHeader.append("<table width='100%' align='center' cellspacing='0px' cellpadding='1px' border=1>");
				brHeader.append("<tr>");
				brHeader.append("<td colspan='1' width='" + (int) width1
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>S.No.</strong></font></td>");
				brHeader.append("<td colspan='1' width='" + (int) width2
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Item Name</strong></font></td>");
				brHeader.append("<td colspan='1' width='" + (int) width3
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Name</strong></font></td>");
				brHeader.append("<td colspan='1' width='" + (int) width4
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Item Type</strong></font></td>");
				brHeader.append("<td colspan='1' width='" + (int) width5
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Batch</strong></font></td>");
				brHeader.append("<td colspan='1' width='" + (int) width6
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Expiry Date</strong></font></td>");
				brHeader.append("<td colspan='1' width='" + (int) width7
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Supplier Name</strong></font></td>");
				brHeader.append("<td colspan='1' width='" + (int) width8
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Rate</strong></font></td>");

				// programme
				map = new HashMap<String, String>();
				while (ws.next()) {
					map.put(ws.getString(1), String.valueOf(counter++));
					brHeader.append("<td colspan='1' width='" + (int) width9
							+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + ws.getString(2)
							+ "</strong></font></td>");
				}
				// brHeader.append("<td colspan='1' width='" + (int)width10 +
				// "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total Qty</strong></font></td>");
				// brHeader.append("<td colspan='1' width='" + (int)width11 +
				// "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Rate</strong></font></td>");

				brHeader.append("</tr>");

				// body part
				prgValue = new String[programmeSize];
				while (wsItem.next()) {
					if (!prevPONo.equals(wsItem.getString(5))) {
						// not in first time
						if (slNo > 0) {
							for (counter = 0; counter < programmeSize; counter++) {
								br.append("<td colspan='1' width='" + (int) width9
										+ "%' style=\"text-align:center;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
										+ wsItem.getString(7) + "</font></td>");
							}

							// br.append("<td colspan='1' width='" +
							// (int)width10 +
							// "%' style=\"text-align:center;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
							// + poDtlArr[1] + "</font></td>");
							// br.append("<td colspan='1' width='" +
							// (int)width11 +
							// "%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
							// + poDtlArr[0] + "</font></td>");
							// br.append("<td colspan='1' width='" +
							// (int)width12 +
							// "%' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
							// + poDtlArr[3] + "</font></td>");

							// costArr = poDtlArr[4].split("\\^");
							// br.append("<td colspan='1' width='" +
							// (int)width13 +
							// "%' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
							// + costArr[0] + "</font></td>");
							// br.append("<td colspan='1' width='" +
							// (int)width14 +
							// "%' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
							// + costArr[1] + "</font></td>");

							br.append("</tr>");
						}

						slNo++;
						// reset the array
						for (counter = 0; counter < programmeSize; counter++) {
							prgValue[counter] = "0";
						}

						(wsItem.getString(10)).split("\\#");

						br.append("<tr>");
						br.append("<td colspan='1' width='" + (int) width1
								+ "%' style=\"text-align:center;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + slNo
								+ "</font></td>");
						br.append("<td colspan='1' width='" + (int) width2
								+ "%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(1)
								+ "</font></td>");
						br.append("<td colspan='1' width='" + (int) width3
								+ "%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(2)
								+ "</font></td>");
						br.append("<td colspan='1' width='" + (int) width4
								+ "%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(3)
								+ "</font></td>");
						br.append("<td colspan='1' width='" + (int) width5
								+ "%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(4)
								+ "</font></td>");
						br.append("<td colspan='1' width='" + (int) width6
								+ "%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(5)
								+ "</font></td>");
						br.append("<td colspan='1' width='" + (int) width7
								+ "%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(6)
								+ "</font></td>");
						br.append("<td colspan='1' width='" + (int) width8
								+ "%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(7)
								+ "</font></td>");

						keyValue = Integer.parseInt(map.get(wsItem.getString(5)));
						prgValue[keyValue] = wsItem.getString(7); // order qty

					} else {
						keyValue = Integer.parseInt(map.get(wsItem.getString(5)));
						prgValue[keyValue] = wsItem.getString(7); // order qty
					}

					prevPONo = wsItem.getString(5);
				}

				// last row
				for (counter = 0; counter < programmeSize; counter++) {
					br.append("<td colspan='1' width='" + (int) width9
							+ "%' style=\"text-align:center;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + wsItem.getString(7)
							+ "</font></td>");
				}

				// br.append("<td colspan='1' width='" + (int)width10 +
				// "%' style=\"text-align:center;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
				// + poDtlArr[1] + "</font></td>");
				// br.append("<td colspan='1' width='" + (int)width11 +
				// "%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
				// + poDtlArr[0] + "</font></td>");
				// br.append("<td colspan='1' width='" + (int)width12 +
				// "%' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
				// + poDtlArr[3] + "</font></td>");

				// costArr = poDtlArr[4].split("\\^");
				// br.append("<td colspan='1' width='" + (int)width13 +
				// "%' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
				// + costArr[0] + "</font></td>");
				// br.append("<td colspan='1' width='" + (int)width14 +
				// "%' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>"
				// + costArr[1] + "</font></td>");

				br.append("</tr>");
			} else {
				// if no data exists then make default header
				brHeader.append("<table width='100%' align='center' cellspacing='0px' cellpadding='1px' border=1>");
				brHeader.append("<tr>");
				brHeader.append("<td colspan='1' width='" + (int) width1
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>S.No.</strong></font></td>");
				brHeader.append("<td colspan='1' width='" + (int) width2
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>PO No.</strong></font></td>");
				brHeader.append("<td colspan='1' width='" + (int) width3
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>PO Date</strong></font></td>");
				brHeader.append("<td colspan='1' width='" + (int) width4
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Supplier Name</strong></font></td>");
				brHeader.append("<td colspan='1' width='" + (int) width5
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Tender No.</strong></font></td>");
				brHeader.append("<td colspan='1' width='" + (int) width6
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Drug Name</strong></font></td>");
				brHeader.append("<td colspan='1' width='" + (int) width7
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Mfg Name</strong></font></td>");
				brHeader.append("<td colspan='1' width='" + (int) width8
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Drug Code</strong></font></td>");
				brHeader.append("<td colspan='1' width='" + (int) width9
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Programme Name</strong></font></td>");
				brHeader.append("<td colspan='1' width='" + (int) width10
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total Qty</strong></font></td>");
				brHeader.append("<td colspan='1' width='" + (int) width11
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Rate</strong></font></td>");
				brHeader.append("<td colspan='1' width='"
						+ (int) width12
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total Price (INR) Exclusive of VAT/CST</strong></font></td>");
				brHeader.append("<td colspan='1' width='"
						+ (int) width13
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total CST/VAT Amt. (INR)</strong></font></td>");
				brHeader.append("<td colspan='1' width='"
						+ (int) width14
						+ "%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total Price (INR) Inclusive of VAT/CST</strong></font></td>");
				brHeader.append("</tr>");
				brHeader.append("<tr>");
				brHeader.append("<td colspan='14' width='100%' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>No Data Found</strong></font></td>");
				brHeader.append("</tr>");
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
		return (brHeader.append(br).toString() + "</table>");
	}
	
	public static String printReportRpt1(StockOnHandIgimsRptVO vo,String reportHeader, HttpServletRequest request) throws Exception
	{
		//WebRowSet wsItem = null;
		StringBuffer br = new StringBuffer(2000);
		
		WebRowSet ws1=null;
		
		int i=0;
		
		int count=0;
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		
		HisUtil util = new HisUtil("MMS Transactions", "IssueDetailRptHLP");

		//for count the total price and grand total
		try 
		{
				ws1 = vo.getStrStockInHandRptWS(); 
				//make header
				br.append("<div id='wrapper'>");
				
				br.append(
						"<table align='center'><tr><th colspan='16' style='width:10%;'  align='center'><font size='3' ><strong> "
								+ reportHeader + " For "+vo.getStrStoreName()+" As On "+""+"</strong></font></th></tr><br><br>");
				br.append("<tr><th colspan='1' style='width:10%;'  align='center'><font size='3' ></font></th></tr></table>");
				
				br.append("<table  width='100%'  align='center' cellspacing='0px' cellpadding='1px' border='1px'>");
			
				br.append("<tr id='tableHeaderId' style='background-color:#D3D3D3;'>");
				br.append("<th colspan='1' rowspan='2' height='30' style='width:5%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> S.No. </strong></font></th>");
				br.append("<th colspan='1' rowspan='2' height='30' style='width:10%; color:black'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Item Name </strong></font></th>");
				br.append("<th colspan='1' style='width:5%; color:black' align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Group Name </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:5%; color:black'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Item Type </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:5%; color:black'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong>Batch No.</strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:5%; color:black'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong>Exp. Date</strong></font></th>");
				
				br.append("<th colspan='4' height='30' style='width:32%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> DHO </strong></font></th>");
				br.append("<th colspan='4' height='30' style='width:20%; color:black'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> CS </strong></font></th>");
				br.append("<th colspan='2' height='30' style='width:10%; color:black' align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Total </strong></font></th>");
				br.append("</tr>");
				
				br.append("<tr id='tableHeaderId' style='background-color:#D3D3D3;'>");
				br.append("<th colspan='1' style='width:5%; color:black' align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong>  </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:5%; color:black'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong></strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:5%; color:black'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong></strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:5%; color:black'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong></strong></font></th>");
				
				br.append("<th colspan='1' height='30' style='width:8%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Qty Ready for Issue (Active) </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:8%; color:black'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Qty in ( Quarantine) </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:8%; color:black' align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Qty (InActive) </strong></font></th>");
				
				br.append("<th colspan='1' height='30' style='width:8%; color:black' align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Total Qty  </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:5%; color:black' align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Qty Ready for Issue (Active) </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:5%; color:black' align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Qty in ( Quarantine) </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:5%; color:black' align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Qty (InActive) </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:5%; color:black' align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Total Qty  </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:5%; color:black' align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Total Qty  </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:5%; color:black' align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Value (Rs.) </strong></font></th>");
				
				br.append("</tr>");
				
				System.out.println("First Table Data 1");
				
					if (ws1.size() > 0) 
					{				
		
					while (ws1.next()) 
					{
						
						br.append("<tr>");
					    br.append("<td colspan='1'  height='20' style=\"text-align:center; width:5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ (i+1) + "</font></td>");
					    br.append("<td colspan='1'  height='20' style=\"text-align:center;  width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(3) + "</font></td>");
					    br.append("<td colspan='1' height='20' style=\"text-align:center;  width:5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(2) + "</font></td>");
					    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(1) + "</font></td>");
					    br.append("<td colspan='1' height='20' style=\"text-align:center;  width:5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(12) + "</font></td>");
					    br.append("<td colspan='1' height='20' style=\"text-align:center;  width:5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(6) + "</font></td>");
					    
					    br.append("<td colspan='1'  height='20' style=\"text-align:center; width:8%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(13) + "</font></td>");
					    br.append("<td colspan='1'  height='20' style=\"text-align:center;  width:8%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(7) + "</font></td>");
					    br.append("<td colspan='1' height='20' style=\"text-align:center;  width:8%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(9) + "</font></td>");
					    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:8%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(10) + "</font></td>");
					    
					    br.append("<td colspan='1'  height='20' style=\"text-align:center; width:5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(13) + "</font></td>");
					    br.append("<td colspan='1'  height='20' style=\"text-align:center;  width:5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(7) + "</font></td>");
					    br.append("<td colspan='1' height='20' style=\"text-align:center;  width:5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(9) + "</font></td>");
					    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(10) + "</font></td>");
					    br.append("<td colspan='1' height='20' style=\"text-align:center;  width:5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(9) + "</font></td>");
					    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(10) + "</font></td>");
					      
					    br.append("</tr>");
						

						i++;
						count++;
						//preSubStoreName=curSubStoreName;
						
						}
					}
					else 
					{
					br.append("<tr>");
					br.append("<td colspan='16'   height='30' style=\"color: black; font-weight: bold;\" width='100%' align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong>No Data Found</strong></font></td>");
					br.append("</tr>");
				
					}
					br.append("</table><br><br>");
			} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ws1 != null) {
				ws1.close();
				ws1 = null;
			}

		}
		vo.setStrTableWidth(String.valueOf("100"));
		return (br.toString()+"</div>");
	}
	//RJ 
	public static String printBatchWiseZeroStockReportRpt(StockOnHandIgimsRptVO vo,String reportHeader, HttpServletRequest request,StockOnHandIgimsRptFB formBean) throws Exception {
		//WebRowSet wsItem = null;
		StringBuffer br = new StringBuffer(2000);
		
		WebRowSet ws1=null;
		
		int i=0;
		String curSubStoreName="";
		String preSubStoreName="";
		
		String curGroupName="";
		String preGroupName="";
		int count=0;
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		

		double totalCost = 0;
		double subGrpTotalInHandQty = 0;
		double subGroupTotalCost = 0;
			
		
		HisUtil util = new HisUtil("MMS Transactions", "IssueDetailRptHLP");
		try 
		{
				ws1 = vo.getStrStockInHandRptWS(); 
				br.append("<div id='wrapper' align='center'>");
				
				br.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
				
				br.append("<tr>");
				br.append("<td colspan='10'></td>");
				br.append("<td colspan='2' align='right'>");
				br.append("<div id='printImg' style='margin-right: 40px; margin-top: 10px;'>");
				br.append("<img style='cursor: pointer; margin-right: 10px;' title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' />");
				br.append("<img style='cursor: pointer;' title='Generate Excel' src='../../hisglobal/images/excel.png' onClick='generateXLSCommon(event, indentItemListDivId);' />");
				br.append("</div>");

				br.append("</td>");
				br.append("</tr>");
				
				br.append("<tr>");
				br.append("<td colspan='12' align='center'>");
				//br.append("<div><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div>");
				br.append("<div><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div>");
				br.append("<div style='font-size:16px;'><b>Stock In-Hand Report for Zero Stock</b></div>");
				br.append("</td>");
				br.append("</tr>");
				
				br.append("<tr>");
				br.append("<td colspan='12' align='center'>");
				br.append("<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>");
				br.append("For Store Name :: <b>" + vo.getStrStoreName() + "</b><br>");
				br.append("For Group :: <b>" + vo.getStrGroupName() + "</b><br>");
				br.append("For Type :: <b>" + vo.getStrDrugTypeName() + "</b><br>");
				br.append("Report Date & Time :: <b>" + formBean.getStrCurrentDate() + "</b><br>");
				br.append("By User :: <b>" + formBean.getStrUserName() + "</b>");
				br.append("</font>");
				br.append("</td>");
				br.append("</tr>");
				br.append("</table>");

				br.append("<table  width='100%'  align='center' cellspacing='0px' cellpadding='1px' border='1px'>");
			
				br.append("<tr id='tableHeaderId' style='background-color:#D3D3D3;'>");
				
				br.append("<th colspan='1' height='30' style='width: 5%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> S.No. </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:20%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Item Name </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black;'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Item Type</strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black;'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Batch No.</strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black;'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Exp. Date</strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:12%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Supplier Name </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width: 8%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Rate </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width: 8%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> MRP </strong></font></th>");

				br.append("<th colspan='1' height='30' style='width:10%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Qty(Total) </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Cost Value </strong></font></th>");
				br.append("</tr>");
				
				
					if (ws1.size() > 0) 
					{				
		
						while (ws1.next()) 
						{
							
							
								//groupTotalCose+=Double.parseDouble(ws1.getString("12"));
								curGroupName = ws1.getString(2);
								if((!preGroupName.equals(curGroupName))&& preGroupName !="" )
								{
									
									br.append("<tr bgcolor='#c0ded9' >");
									br.append("<td colspan='8' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Total :</strong></font></td>");
									br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
													+ (myFormatter.format(subGrpTotalInHandQty).split("\\.")[0]) + "</strong></font></td>");
									br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+ (myFormatter.format(subGroupTotalCost)) +"</strong></font></td>");
									
									br.append("</tr>");
										
									subGrpTotalInHandQty=0;
									subGroupTotalCost=0;
										
								}
								/*
								 * 1.Store Name
								 * 2.Group Name
								 * 3.Item Name
								 * 4.Batch No
								 * 5.Active Qty
								 * 6.Quarntine Qty
								 * 7.In-Active Qty
								 * 8.Total In-Hand
								 * 9.Rate With Unit
								 * 10.Expiry Date
								 * 11.Supplier Name
								 * 12.Cost Value 	
								 * 13. Item_Type
								 * 14.User Name Based on Seat Id						
								 * */
								
								subGroupTotalCost     += Double.parseDouble(ws1.getString(12));  // Cost
								subGrpTotalInHandQty  += Integer.parseInt(ws1.getString(5));  // Active Qty
								totalCost             += Double.parseDouble(ws1.getString(12));  // Cost
								
								if(!curGroupName.equals(preGroupName))
								{
									br.append("<tr>");
									br.append("<td colspan='10' style=\"text-align:left; width:5%;\"><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><b> "+curGroupName+ "</b></font></td>");
									br.append("</tr>");
								}
								//preGroupName=curGroupName;
								
								/*
								 * 1.Store Name
								 * 2.Group Name
								 * 3.Item Name
								 * 4.Batch No
								 * 5.Active Qty
								 * 6.Quarntine Qty
								 * 7.In-Active Qty
								 * 8.Total In-Hand
								 * 9.Rate With Unit
								 * 10.Expiry Date
								 * 11.Supplier Name
								 * 12.Cost Value 	
								 * 13. Item_Type
								 * 14.User Name Based on Seat Id	
								 * 15.MRP 					
								 * */
								
							br.append("<tr>");
						    br.append("<td colspan='1' height='20' style=\"text-align:center;   width: 5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ (i+1) + "</font></td>");
						    br.append("<td colspan='1' height='20' style=\"text-align:left;     width:20%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(3) + "</font></td>");
						    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(13) + "</font></td>");
						    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(4) + "</font></td>");
						    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(10) + "</font></td>");
						    br.append("<td colspan='1' height='20' style=\"text-align:left;     width:12%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(11) + "</font></td>");					    
						    br.append("<td colspan='1' height='20' style=\"text-align:center;   width: 8%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(9) + "</font></td>");
						    br.append("<td colspan='1' height='20' style=\"text-align:center;   width: 8%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(15) + "</font></td>");
						    
						    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(5) + "</font></td>");
						    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(12) + "</font></td>");
						    
						    br.append("</tr>");
							
				
							count++;
							i++;
							
							preGroupName=curGroupName;
							
					  }
					  br.append("<tr bgcolor='#c0ded9' >");
					  br.append("<td colspan='8' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Total :</strong></font></td>");
					  br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
									+ (myFormatter.format(subGrpTotalInHandQty).split("\\.")[0]) + "</strong></font></td>");
					  br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+ (myFormatter.format(subGroupTotalCost)) +"</strong></font></td>");
					
					  br.append("</tr>");
					}
					else 
					{
					br.append("<tr>");
					br.append("<td colspan='10'   height='30' style=\"color: black; font-weight: bold;\" width='100%' align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong>No Data Found</strong></font></td>");
					br.append("</tr>");
				
					}
					
					i=i++;
					for (count = 0; count <= i; count++) {
						if (count == i) {
							br.append("<tr>");
							br.append(
									"<td colspan='9' width='10%' height='50' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Grand Total :</strong></font></td>");
							br.append(
									"<td colspan='1' width='10%' height='50' align='center'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
											+ myFormatter.format(totalCost) + "</strong></font></td>");
							
							
			
							br.append("</tr>");
							
//							br.append("<tr>");
//							br.append(
//									"<td colspan='9' width='10%' height='50' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Grand Total (In Words) :</strong></font></td>");
//							br.append(
//									"<td colspan='1' width='10%' height='50' align='center'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
//											+ util.toInitCap(util.getAmountStr(myFormatter
//													.format(totalCost))) + "</strong></font></td>");
//							
//							br.append("</tr>");
							
							}
					}
					br.append("</table><br><br>");
			} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ws1 != null) {
				ws1.close();
				ws1 = null;
			}

		}
		vo.setStrTableWidth(String.valueOf("100"));
		return (br.toString()+"</div>");
	}
	
	public static String printBatchWiseReportRptNew(StockOnHandIgimsRptVO vo,String reportHeader, HttpServletRequest request,StockOnHandIgimsRptFB formBean) throws Exception {
		//WebRowSet wsItem = null;
		StringBuffer br = new StringBuffer(2000);
		
		WebRowSet ws1=null;
		
		int i=0;
		String curSubStoreName="";
		String preSubStoreName="";
		
		String curGroupName="";
		String preGroupName="";
		int count=0;
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		

		double totalCost = 0;
		double subGrpTotalInHandQty = 0;
		double subGroupTotalCost = 0;
			
		
		HisUtil util = new HisUtil("MMS Transactions", "IssueDetailRptHLP");
		try 
		{
				ws1 = vo.getStrStockInHandRptWS(); 
				//make header
				br.append("<div id='wrapper' align='center'>");
				
				br.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ " <tr> "
						+ " <td colspan='1'></td>"
						+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
						+ " <td colspan='1'></td>");
				br.append("</tr>");
				
				br.append(" <tr> "
				        + " <td colspan='1'></td>"
						+ " <td colspan='1'align='center'><b>Re-Order Level Report</b></td>"
						+ " <td colspan='1'></td>");
				br.append("</tr>");
				
				br.append(" <tr> "
				        + " <td colspan='1'></td>"
						+ " <td colspan='1'></td>"
						+ " <td colspan='1'><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/excel.png' onClick='generateXLSCommon(event, indentItemListDivId);' /></div></td>");
				br.append("</tr>");
				
				br.append("</table>");
				
				
				br.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Store Name ::<b>"+vo.getStrStoreName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 					
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Group ::<b>"+vo.getStrGroupName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Type ::<b>"+vo.getStrDrugTypeName()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "Report Date & Time  ::<b>"+formBean.getStrCurrentDate()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "By User  ::<b>"+formBean.getStrUserName()+"</b></font></td><td align='center' colspan='2'></td></tr>"+
											
						 "</table> <br>");
				
				br.append("<table  width='100%'  align='center' cellspacing='0px' cellpadding='1px' border='1px'>");
			
				br.append("<tr id='tableHeaderId' style='background-color:#D3D3D3;'>");
				
				br.append("<th colspan='1' height='30' style='width: 5%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> S.No. </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:20%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Item Name </strong></font></th>");
				//br.append("<th colspan='1' height='30' style='width:10%; color:black;'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Item Type</strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black;'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Batch No.</strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black;'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Exp. Date</strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:12%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Supplier Name </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width: 8%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Rate </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Qty </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Re-Order Level </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Cost Value </strong></font></th>");
				br.append("</tr>");
				
				
					if (ws1.size() > 0) 
					{				
		
						while (ws1.next()) 
						{
							
							
								//groupTotalCose+=Double.parseDouble(ws1.getString("12"));
								curGroupName = ws1.getString(2);
								if((!preGroupName.equals(curGroupName))&& preGroupName !="" )
								{
									
									br.append("<tr bgcolor='#c0ded9' >");
									br.append("<td colspan='7' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Total :</strong></font></td>");
									br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
													+ (myFormatter.format(subGrpTotalInHandQty).split("\\.")[0]) + "</strong></font></td>");
									br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+ (myFormatter.format(subGroupTotalCost)) +"</strong></font></td>");
									
									br.append("</tr>");
										
									subGrpTotalInHandQty=0;
									subGroupTotalCost=0;
										
								}
								/*
								 * 1.Store Name
								 * 2.Group Name
								 * 3.Item Name
								 * 4.Batch No
								 * 5.Active Qty
								 * 6.Quarntine Qty
								 * 7.In-Active Qty
								 * 8.Total In-Hand
								 * 9.Rate With Unit
								 * 10.Expiry Date
								 * 11.Supplier Name
								 * 12.Cost Value 	
								 * 13. Item_Type
								 * 14.User Name Based on Seat Id	
								 * 15.MIN_QTY					
								 * */
								
								subGroupTotalCost     += Double.parseDouble(ws1.getString(12));  // Cost
								subGrpTotalInHandQty  += Integer.parseInt(ws1.getString(5));  // Active Qty
								totalCost             += Double.parseDouble(ws1.getString(12));  // Cost
								
								if(!curGroupName.equals(preGroupName))
								{
									br.append("<tr>");
									br.append("<td colspan='9' style=\"text-align:left; width:5%;\"><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><b> "+curGroupName+ "</b></font></td>");
									br.append("</tr>");
								}
								//preGroupName=curGroupName;
								
								/*
								 * 1.Store Name
								 * 2.Group Name
								 * 3.Item Name
								 * 4.Batch No
								 * 5.Active Qty
								 * 6.Quarntine Qty
								 * 7.In-Active Qty
								 * 8.Total In-Hand
								 * 9.Rate With Unit
								 * 10.Expiry Date
								 * 11.Supplier Name
								 * 12.Cost Value 	
								 * 13. Item_Type
								 * 14.User Name Based on Seat Id
								 * 15.MIN_QTY						
								 * */
								
								if(Integer.parseInt(ws1.getString(15)) > Integer.parseInt(ws1.getString(5)))	
								{	
									br.append("<tr style='background-color:#fafda2;'>");
								    br.append("<td colspan='1' height='20' style=\"text-align:center;   width: 5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ (i+1) + "</font></td>");
								    br.append("<td colspan='1' height='20' style=\"text-align:left;     width:20%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(3) + "["+ ws1.getString(13)+"]</font></td>");
								    //br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(13) + "</font></td>");
								    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(4) + "</font></td>");
								    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(10) + "</font></td>");
								    br.append("<td colspan='1' height='20' style=\"text-align:left;     width:12%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(11) + "</font></td>");					    
								    br.append("<td colspan='1' height='20' style=\"text-align:center;   width: 8%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(9) + "</font></td>");
								    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(5) + "</font></td>");
								    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(15) + "</font></td>");
								    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(12) + "</font></td>");
								    br.append("</tr>");
								}
								else
								{
									br.append("<tr>");
								    br.append("<td colspan='1' height='20' style=\"text-align:center;   width: 5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ (i+1) + "</font></td>");
								    br.append("<td colspan='1' height='20' style=\"text-align:left;     width:20%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(3) + "["+ ws1.getString(13)+"]</font></td>");
								    //br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(13) + "</font></td>");
								    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(4) + "</font></td>");
								    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(10) + "</font></td>");
								    br.append("<td colspan='1' height='20' style=\"text-align:left;     width:12%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(11) + "</font></td>");					    
								    br.append("<td colspan='1' height='20' style=\"text-align:center;   width: 8%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(9) + "</font></td>");
								    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(5) + "</font></td>");
								    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(15) + "</font></td>");
								    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(12) + "</font></td>");
								    br.append("</tr>");
								}
							
				
							count++;
							i++;
							
							preGroupName=curGroupName;
							
					  }
					  br.append("<tr bgcolor='#c0ded9' >");
					  br.append("<td colspan='7' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Total :</strong></font></td>");
					  br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
									+ (myFormatter.format(subGrpTotalInHandQty).split("\\.")[0]) + "</strong></font></td>");
					  br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+ (myFormatter.format(subGroupTotalCost)) +"</strong></font></td>");
					
					  br.append("</tr>");
					}
					else 
					{
					br.append("<tr>");
					br.append("<td colspan='9'   height='30' style=\"color: black; font-weight: bold;\" width='100%' align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong>No Data Found</strong></font></td>");
					br.append("</tr>");
				
					}
					
					i=i++;
					for (count = 0; count <= i; count++) {
						if (count == i) {
							br.append("<tr>");
							br.append(
									"<td colspan='8' width='10%' height='50' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Grand Total :</strong></font></td>");
							br.append(
									"<td colspan='1' width='10%' height='50' align='center'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
											+ myFormatter.format(totalCost) + "</strong></font></td>");
			
							br.append("</tr>");
							
							
							}
					}
					br.append("</table><br><br>");
			} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ws1 != null) {
				ws1.close();
				ws1 = null;
			}

		}
		vo.setStrTableWidth(String.valueOf("100"));
		return (br.toString()+"</div>");
	}
	
	public static String printBatchWiseReportRptForMail(StockOnHandIgimsRptVO vo,String reportHeader, HttpServletRequest request,StockOnHandIgimsRptFB formBean) throws Exception {
		//WebRowSet wsItem = null;
		StringBuffer br = new StringBuffer(2000);
		
		WebRowSet ws1=null;
		
		int i=0;
		String curSubStoreName="";
		String preSubStoreName="";
		
		String curGroupName="";
		String preGroupName="";
		int count=0;
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		

		double totalCost = 0;
		double subGrpTotalInHandQty = 0;
		double subGroupTotalCost = 0;
			
		
		HisUtil util = new HisUtil("MMS Transactions", "IssueDetailRptHLP");
		try 
		{
				ws1 = vo.getStrStockInHandRptWS(); 
				//make header
				br.append("<div id='wrapper' align='center'>");
				
				br.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
								
				br.append(" <tr> "
				        + " <td colspan='1'></td>"
						+ " <td colspan='1'align='center'><b>Stock Below Re-Order Report</b></td>"
						+ " <td colspan='1'></td>");
				br.append("</tr>");		
				br.append("</table>");
				
				
				br.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"	
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "Report Date & Time  ::<b>"+formBean.getStrCurrentDate()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						+"</table> <br>");
				
				br.append("<table  width='100%'  align='center' cellspacing='0px' cellpadding='1px' border='1px'>");
			
				br.append("<tr id='tableHeaderId' style='background-color:#D3D3D3;'>");
				
				br.append("<th colspan='1' height='30' style='width: 5%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> S.No. </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:20%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Item Name </strong></font></th>");
				//br.append("<th colspan='1' height='30' style='width:10%; color:black;'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Item Type</strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black;'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Batch No.</strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black;'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Exp. Date</strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:12%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Supplier Name </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width: 8%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Rate </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Qty </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Re-Order Level </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Cost Value </strong></font></th>");
				br.append("</tr>");
				
				
					if (ws1.size() > 0) 
					{				
		
						while (ws1.next()) 
						{
							
							
								//groupTotalCose+=Double.parseDouble(ws1.getString("12"));
								curGroupName = ws1.getString(2);
								if((!preGroupName.equals(curGroupName))&& preGroupName !="" )
								{
									
									br.append("<tr bgcolor='#c0ded9' >");
									br.append("<td colspan='7' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Total :</strong></font></td>");
									br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
													+ (myFormatter.format(subGrpTotalInHandQty).split("\\.")[0]) + "</strong></font></td>");
									br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+ (myFormatter.format(subGroupTotalCost)) +"</strong></font></td>");
									
									br.append("</tr>");
										
									subGrpTotalInHandQty=0;
									subGroupTotalCost=0;
										
								}
								/*
								 * 1.Store Name
								 * 2.Group Name
								 * 3.Item Name
								 * 4.Batch No
								 * 5.Active Qty
								 * 6.Quarntine Qty
								 * 7.In-Active Qty
								 * 8.Total In-Hand
								 * 9.Rate With Unit
								 * 10.Expiry Date
								 * 11.Supplier Name
								 * 12.Cost Value 	
								 * 13. Item_Type
								 * 14.User Name Based on Seat Id	
								 * 15.MIN_QTY					
								 * */
								
								subGroupTotalCost     += Double.parseDouble(ws1.getString(12));  // Cost
								subGrpTotalInHandQty  += Integer.parseInt(ws1.getString(5));  // Active Qty
								totalCost             += Double.parseDouble(ws1.getString(12));  // Cost
								
								if(!curGroupName.equals(preGroupName))
								{
									br.append("<tr>");
									br.append("<td colspan='9' style=\"text-align:left; width:5%;\"><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><b> "+curGroupName+ "</b></font></td>");
									br.append("</tr>");
								}
								//preGroupName=curGroupName;
								
								/*
								 * 1.Store Name
								 * 2.Group Name
								 * 3.Item Name
								 * 4.Batch No
								 * 5.Active Qty
								 * 6.Quarntine Qty
								 * 7.In-Active Qty
								 * 8.Total In-Hand
								 * 9.Rate With Unit
								 * 10.Expiry Date
								 * 11.Supplier Name
								 * 12.Cost Value 	
								 * 13. Item_Type
								 * 14.User Name Based on Seat Id
								 * 15.MIN_QTY						
								 * */
							if(Integer.parseInt(ws1.getString(15)) > Integer.parseInt(ws1.getString(5)))	
							{	
								br.append("<tr style='background-color:#fafda2;'>");
							    br.append("<td colspan='1' height='20' style=\"text-align:center;   width: 5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ (i+1) + "</font></td>");
							    br.append("<td colspan='1' height='20' style=\"text-align:left;     width:20%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(3) + "["+ ws1.getString(13)+"]</font></td>");
							    //br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(13) + "</font></td>");
							    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(4) + "</font></td>");
							    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(10) + "</font></td>");
							    br.append("<td colspan='1' height='20' style=\"text-align:left;     width:12%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(11) + "</font></td>");					    
							    br.append("<td colspan='1' height='20' style=\"text-align:center;   width: 8%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(9) + "</font></td>");
							    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(5) + "</font></td>");
							    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(15) + "</font></td>");
							    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(12) + "</font></td>");
							    br.append("</tr>");
							}
							else
							{
								br.append("<tr>");
							    br.append("<td colspan='1' height='20' style=\"text-align:center;   width: 5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ (i+1) + "</font></td>");
							    br.append("<td colspan='1' height='20' style=\"text-align:left;     width:20%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(3) + "["+ ws1.getString(13)+"]</font></td>");
							    //br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(13) + "</font></td>");
							    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(4) + "</font></td>");
							    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(10) + "</font></td>");
							    br.append("<td colspan='1' height='20' style=\"text-align:left;     width:12%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(11) + "</font></td>");					    
							    br.append("<td colspan='1' height='20' style=\"text-align:center;   width: 8%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(9) + "</font></td>");
							    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(5) + "</font></td>");
							    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(15) + "</font></td>");
							    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(12) + "</font></td>");
							    br.append("</tr>");
							}
							
				
							count++;
							i++;
							
							preGroupName=curGroupName;
							
					  }
					  br.append("<tr bgcolor='#c0ded9' >");
					  br.append("<td colspan='7' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Total :</strong></font></td>");
					  br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
									+ (myFormatter.format(subGrpTotalInHandQty).split("\\.")[0]) + "</strong></font></td>");
					  br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+ (myFormatter.format(subGroupTotalCost)) +"</strong></font></td>");
					
					  br.append("</tr>");
					}
					else 
					{
					br.append("<tr>");
					br.append("<td colspan='9'   height='30' style=\"color: black; font-weight: bold;\" width='100%' align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong>No Data Found</strong></font></td>");
					br.append("</tr>");
				
					}
					
					i=i++;
					for (count = 0; count <= i; count++) {
						if (count == i) {
							br.append("<tr>");
							br.append(
									"<td colspan='8' width='10%' height='50' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Grand Total :</strong></font></td>");
							br.append(
									"<td colspan='1' width='10%' height='50' align='center'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
											+ myFormatter.format(totalCost) + "</strong></font></td>");
			
							br.append("</tr>");
							
							
							}
					}
					br.append("</table><br><br>");
			} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ws1 != null) {
				ws1.close();
				ws1 = null;
			}

		}
		vo.setStrTableWidth(String.valueOf("100"));
		return (br.toString()+"</div>");
	}
	
	public static String printWithOutBatchReport1(StockOnHandIgimsRptVO vo,String reportHeader, HttpServletRequest request ,StockOnHandIgimsRptFB formBean) throws Exception {
		//WebRowSet wsItem = null;
		StringBuffer br = new StringBuffer(2000);
		
		WebRowSet ws1=null;
		
		int i=0;
		
		String curGroupName="";
		String preGroupName="";
		int count=0;
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		

		double totalCost =0 ;	
		
		double subGrpTotalInHandQty = 0;
		double subGroupTotalCost = 0;		
		HisUtil util = null;

		//for count the total price and grand total
		try 
		{
			    util = new HisUtil("MMS Transactions", "IssueDetailRptHLP");
				ws1 = vo.getStrStockInHandRptWS();
				//make header
				br.append("<div id='wrapper'>");	
				
				br.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ " <tr> "
						+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
						//+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></td></tr>"
						);
				
				br.append(" <tr align='right'> "
						+ " <td colspan='12'>"
						+ "<div id='printImg' align='right'>"
						+ "<img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' />"
						+ "&nbsp;&nbsp;<img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/excel.png' "
						+ "onClick='generateXLSCommon(event, indentItemListDivId);' /></div></td></tr></table>");
						
				br.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"		
						+ "<tr><td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='3'>"
						+ "<b>"+" Stock In-Hand Report "+"</b>"
						+ "</font></td>"
						+ "</tr>"
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Store Name ::<b>"+vo.getStrStoreName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 					
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Group ::<b>"+vo.getStrGroupName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Type ::<b>"+vo.getStrDrugTypeName()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "Report Date & Time  ::<b>"+formBean.getStrCurrentDate()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "By User  ::<b>"+formBean.getStrUserName()+"</b></font></td><td align='center' colspan='2'></td></tr>"+
											
						 "</table> <br>");
								
				br.append("<table  width='100%'  align='center' cellspacing='0px' cellpadding='1px' border='1px'>");
			
				br.append("<tr id='tableHeaderId' style='background-color:#D3D3D3;'>");
				
				br.append("<th colspan='1' height='30' style='width:5%;  color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> S.No. </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:30%; color:black'   align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Item Name </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black'   align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Group Name </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Item Type</strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black'   align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Qty(Total) </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black'   align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Cost </strong></font></th>");
				br.append("</tr>");
				
				System.out.println("<----------------------- REPORT_4 --------------------------->");
				
					if (ws1.size() > 0) 
					{				
		
						while (ws1.next()) 
						{
							
							
							
								curGroupName = ws1.getString(2);                  // Group Name
								if((!preGroupName.equals(curGroupName))&& preGroupName !="" )
								{
									
									br.append("<tr bgcolor='#c0ded9' >");
									br.append("<td colspan='4' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Total :</strong></font></td>");
									br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
													+ (myFormatter.format(subGrpTotalInHandQty).split("\\.")[0]) + "</strong></font></td>");
									br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+ (myFormatter.format(subGroupTotalCost)) +"</strong></font></td>");
									
									br.append("</tr>");
										
									subGrpTotalInHandQty=0;
									subGroupTotalCost=0;
									
										
								}
								
								subGroupTotalCost     += Double.parseDouble(ws1.getString(9));  // Cost
								subGrpTotalInHandQty  += Integer.parseInt(ws1.getString(5));  // Active Qty
								totalCost             += Double.parseDouble(ws1.getString(9));  // Cost
								
								
								
								
								if(!curGroupName.equals(preGroupName))
								{
									br.append("<tr>");
									br.append("<td colspan='6' style=\"text-align:left; width:5%;\"><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><b> "+curGroupName+ "</b></font></td>");
									br.append("</tr>");
								}
								//preGroupName=curGroupName;
								
								
								/*
								 * 1.Store Name
								 * 2.Group Name
								 * 3.Item Type 
								 * 4.Item Name
								 * 5.Active Qty
								 * 6.Quarntine Qty
								 * 7.In-Active Qty
								 * 8.Total Qty
								 * 9.Cost value
								 * 10.User Name Based on Seat Id
								 * */
								
							br.append("<tr>");
						    br.append("<td colspan='1'  height='20' style=\"text-align:center;  width:5%;\"> <font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ (i+1) + "</font></td>");
						    br.append("<td colspan='1'  height='20' style=\"text-align:left;    width:30%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(4) + "</font></td>");
						    br.append("<td colspan='1'  height='20' style=\"text-align:center;  width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(2) + "</font></td>");
						    br.append("<td colspan='1'  height='20' style=\"text-align:center;  width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(3) + "</font></td>");
						    br.append("<td colspan='1'  height='20' style=\"text-align:right;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(8) + "</font></td>");
						    br.append("<td colspan='1'  height='20' style=\"text-align:right;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(9) + "</font></td>");
						    
						    br.append("</tr>");
							
							count++;
							i++;
							
							preGroupName=curGroupName;
							
							}
						br.append("<tr bgcolor='#c0ded9' >");
						br.append("<td colspan='4' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Total :</strong></font></td>");
						br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
										+ (myFormatter.format(subGrpTotalInHandQty).split("\\.")[0]) + "</strong></font></td>");
						br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+ (myFormatter.format(subGroupTotalCost)) +"</strong></font></td>");
						
						br.append("</tr>");
					}
					else 
					{
					br.append("<tr>");
					br.append("<td colspan='6'   height='30' style=\"color: black; font-weight: bold;\" width='100%' align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong>No Data Found</strong></font></td>");
					br.append("</tr>");
				
					}
					
					i=i++;
					for (count = 0; count <= i; count++)
					{
						if (count == i) 
						{
							br.append("<tr>");
							br.append(
									"<td colspan='5' width='10%' height='50' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total Grand Cost :</strong></font></td>");
							br.append(
									"<td colspan='1' width='10%' height='50' align='center'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
											+ myFormatter.format(totalCost) + "</strong></font></td>");
							
							
			
							br.append("</tr>");
							/*
							br.append("<tr>");
							br.append(
									"<td colspan='6' width='10%' height='50' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Grand Total (In Words) :</strong></font></td>");
							br.append(
									"<td colspan='1' width='10%' height='50' align='center'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
											+ util.toInitCap(util.getAmountStr(myFormatter
													.format(totalQty1))) + "</strong></font></td>");
							
							br.append("</tr>");
							*/
							
							}
					}
					br.append("</table><br><br>");
			} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ws1 != null) {
				ws1.close();
				ws1 = null;
			}

		}
		vo.setStrTableWidth(String.valueOf("100"));
		return (br.toString()+"</div>");
	}
	
	public static String getReportHeader(
			StockOnHandIgimsRptVO vo,
			StockOnHandIgimsRptFB formBean,  String strIndentItemList,
			HttpServletRequest request) {
		StringBuffer sb = new StringBuffer("");
		String[] tblHdrArr;
		
	
		try
		{

			sb.append("<table align='center' cellspacing='1px' cellpadding='1px' border='0'>"
					+ " <tr> <td width='8%' colspan='3'><div><img src='/HBIMS/hisglobal/images/aiims_inv_header.png' width='100' style='margin-left: 100%;float: left;'></div></td>"

					+ "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"
					+ "<b>"+"Stock In-Hand Report"+"</b>"
					+ "</font></td><td align='center' colspan='2'><div id='printImg'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' />"
					+ "<img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='generateXLSCommon(event, \"indentItemListDivId\") /></div></td></tr>" 
					
					+ " <tr><td align='center' colspan='3'></td> "
					+ "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "For Store Name ::<b>"+vo.getStrStoreName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 					
					
					+ " <tr><td align='center' colspan='3'></td> "
					+ "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "For Group ::<b>"+vo.getStrGroupName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
					
					
					+ " <tr><td align='center' colspan='3'></td> "
					+ "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "For Type ::<b>"+vo.getStrDrugTypeName()+"</b></font></td><td align='center' colspan='2'></td></tr>"
					
					+ " <tr><td align='center' colspan='3'></td> "
					+ "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "Report Date & Time  ::<b>"+formBean.getStrCurrentDate()+"</b></font></td><td align='center' colspan='2'></td></tr>"
					
					+ " <tr><td align='center' colspan='3'></td> "
					+ "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "By User  ::<b>"+formBean.getStrUserName()+"</b></font></td><td align='center' colspan='2'></td></tr>"+
					
				
										
					 "</table> <br>");
			sb.append("<br><table width='100%' cellspacing='0' cellpadding='0' border='0' align='center'><tr><td align='center'>"
					+ strIndentItemList + "</td></tr></table>");
			/*
			
			sb.append("<tr><td align='center'><div id='saveId' style='display : block'><div id='printid1' class='hidecontrol' style='float: left; width: 22%;' ><div id ='printImg'>");
			sb.append("<img style='cursor: pointer;' title='Save as Pdf' align='left' onclick='printDataOne();' src='../../hisglobal/images/printer_symbol.gif'  style='cursor: pointer; height:20px;'/>");
			
			sb.append("<br><img style='cursor: pointer; ' align='left' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='cancelPrintToDesk();' /></div>");
			sb.append("<br><p style='text-align:left'><font face='Verdana, Arial, Helvetica, sans-serif' size='2' style='text-align:left'><b>Report Date and Time : </b>"
					+ formBean.getStrCurrentDate() + "</font>");
			sb.append("<br><p style='text-align:left'><font face='Verdana, Arial, Helvetica, sans-serif' size='2' style='text-align:left'><b>User Name : </b>"
					+ formBean.getStrUserName() + "</font>");
			sb.append("</div>");
			sb.append("<div style='width: 100%; margin-left: 0%;'><table width='100%' cellspacing='0' cellpadding='0' border='0' align='center' id='mstHeaderTable' style='font-weight: bold; font-family: verdana;'><tbody>");
			sb.append("<tr><td width='100%' align='center' >");

			sb.append("<table align='center'>");
			sb.append("<tbody><tr><td style='text-align:right;'><div><img src='/HBIMS/hisglobal/images/logo.png' width='100' style='margin-left: 100%;float: left;'></div> </td>");
			

			sb.append("</tr></tbody></table>");
			sb.append("</td></tr>");
			
			
			sb.append("<tr><td style='text-align:center;font-size:12px' colspan='2'>Block No 14/1, Dr. Jivraj Mehta Bhawan, Sector-10, Gandhinagar -382010. </td></tr>");
			
			sb.append("<tr>");
			
			sb.append("<td style='text-align:center;font-size:12px' colspan='2'>Phone No , Fax No. </td></tr>");
			sb.append("<tr id='reportDisplayHeaderRow'>");
			sb.append("<td id='reportDisplayHeaderData' width='100%' align='center' style='padding-left:20px;font-size:11px;'> <b>");
		//	sb.append(tableHeader);
			sb.append("</font>");
			sb.append("</td></tr></tbody></table></div></div>");
			sb.append("<br><table width='100%' cellspacing='0' cellpadding='0' border='0' align='center'><tr><td align='center'>"
					+ strIndentItemList + "</td></tr></table>");
					*/

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("PurchaseOrderDtlRptHLP.getPrintIndentDetails() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}
	// Added by RJ for handling null & non numeric for below method printWithOutBatchReport()
	public static boolean isNumeric(String str) {
	    if (str == null) {
	        return false;
	    }
	    try {
	        Double.parseDouble(str);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	//RJ
	public static String printWithOutBatchZeroStockReport(StockOnHandIgimsRptVO vo,String reportHeader, HttpServletRequest request ,StockOnHandIgimsRptFB formBean) throws Exception {
		//WebRowSet wsItem = null;
		StringBuffer br = new StringBuffer(2000);
		
		WebRowSet ws1=null;
		
		int i=0;
		
		String curGroupName="";
		String preGroupName="";
		int count=0;
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		String strTableWidth = "825";

		double totalCost =0 ;	
		
		double subGrpTotalInHandQty = 0;
		double subGroupTotalCost = 0;		
		HisUtil util = null;

		//for count the total price and grand total
		try 
		{
			    util = new HisUtil("MMS Transactions", "IssueDetailRptHLP");
			    
			    
			    
				ws1 = vo.getStrStockInHandRptWS();
				
				
				HisUtil hisUtil=new HisUtil("Global","ReportUtil");
				HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(vo.getStrHospitalCode());
				Map require =new HashMap();
	             require.put("REQUEST", request);
	             require.put("FORMAT", "html");
	             require.put("HOSPCODE", vo.getStrHospitalCode());

				String strHeader=hisUtil.getHospitalHeaderMain(require); 
				//make header
				br.append("<div id='wrapper'>");	
				
				br.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
				
				br.append("<tr>");
				br.append("<td colspan='10'></td>");
				br.append("<td colspan='2' align='right'>");
				br.append("<div id='printImg' style='margin-right: 40px; margin-top: 10px;'>");
				br.append("<img style='cursor: pointer; margin-right: 10px;' title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' />");
				br.append("<img style='cursor: pointer;' title='Generate Excel' src='../../hisglobal/images/excel.png' onClick='generateXLSCommon(event, indentItemListDivId);' />");
				br.append("</div>");

				br.append("</td>");
				br.append("</tr>");
				
				br.append("<tr>");
				br.append("<td colspan='12' align='center'>");
				//br.append("<div><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div>");
				br.append("<div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div>");
				br.append("<div style='font-size:16px;'><b>Stock In-Hand Report for Zero Stock</b></div>");
				br.append("</td>");
				br.append("</tr>");
				
				br.append("<tr>");
				br.append("<td colspan='12' align='center'>");
				br.append("<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>");
				br.append("For Store Name :: <b>" + vo.getStrStoreName() + "</b><br>");
				br.append("For Group :: <b>" + vo.getStrGroupName() + "</b><br>");
				br.append("For Type :: <b>" + vo.getStrDrugTypeName() + "</b><br>");
				br.append("Report Date & Time :: <b>" + formBean.getStrCurrentDate() + "</b><br>");
				br.append("By User :: <b>" + formBean.getStrUserName() + "</b>");
				br.append("</font>");
				br.append("</td>");
				br.append("</tr>");
				br.append("</table>");
				
				br.append("<table  width='100%'  align='center' cellspacing='0px' cellpadding='1px' border='1px'>");
			
				br.append("<tr id='tableHeaderId' style='background-color:#D3D3D3;'>");
				
				br.append("<th colspan='1' height='30' style='width:5%;  color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> S.No. </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:30%; color:black'   align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Item Name </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black'   align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Group Name </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Item Type</strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black'   align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Qty(Total) </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black'   align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Cost </strong></font></th>");
				br.append("<th colspan='1' height='30' style='width:10%; color:black'   align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Mrp </strong></font></th>");

				br.append("</tr>");
				
				System.out.println("<----------------------- REPORT_4 --------------------------->");
				
					if (ws1.size() > 0) 
					{				
		
						while (ws1.next()) 
						{
							
							
							
								curGroupName = ws1.getString(2);                  // Group Name
								if((!preGroupName.equals(curGroupName))&& preGroupName !="" )
								{
									
									br.append("<tr bgcolor='#c0ded9' >");
									br.append("<td colspan='5' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Total :</strong></font></td>");
									br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
													+ (myFormatter.format(subGrpTotalInHandQty).split("\\.")[0]) + "</strong></font></td>");
									br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+ (myFormatter.format(subGroupTotalCost)) +"</strong></font></td>");
									
									br.append("</tr>");
										
									subGrpTotalInHandQty=0;
									subGroupTotalCost=0;
									
										
								}
								
								subGroupTotalCost     += Double.parseDouble(ws1.getString(9));  // Cost
								subGrpTotalInHandQty  += Integer.parseInt(ws1.getString(5));  // Active Qty
								totalCost             += Double.parseDouble(ws1.getString(9));  // Cost
								
								
								
								
								if(!curGroupName.equals(preGroupName))
								{
									br.append("<tr>");
									br.append("<td colspan='7' style=\"text-align:left; width:5%;\"><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><b> "+curGroupName+ "</b></font></td>");
									br.append("</tr>");
								}
								//preGroupName=curGroupName;
								
								
								/*
								 * 1.Store Name
								 * 2.Group Name
								 * 3.Item Type 
								 * 4.Item Name
								 * 5.Active Qty
								 * 6.Quarntine Qty
								 * 7.In-Active Qty
								 * 8.Total Qty
								 * 9.Cost value
								 * 10.User Name Based on Seat Id
								 * 11. MRP
								 * */
								
							br.append("<tr>");
						    br.append("<td colspan='1'  height='20' style=\"text-align:center;  width:5%;\"> <font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ (i+1) + "</font></td>");
						    br.append("<td colspan='1'  height='20' style=\"text-align:left;    width:30%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(4) + "</font></td>");
						    br.append("<td colspan='1'  height='20' style=\"text-align:center;  width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(2) + "</font></td>");
						    br.append("<td colspan='1'  height='20' style=\"text-align:center;  width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(3) + "</font></td>");
						    br.append("<td colspan='1'  height='20' style=\"text-align:right;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(8) + "</font></td>");
						    br.append("<td colspan='1'  height='20' style=\"text-align:right;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(9) + "</font></td>");
						    br.append("<td colspan='1'  height='20' style=\"text-align:right;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(11) + "</font></td>");

						    
						    br.append("</tr>");
							
							count++;
							i++;
							
							preGroupName=curGroupName;
							
							}
						br.append("<tr bgcolor='#c0ded9' >");
						br.append("<td colspan='5' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Total :</strong></font></td>");
						br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
										+ (myFormatter.format(subGrpTotalInHandQty).split("\\.")[0]) + "</strong></font></td>");
						br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+ (myFormatter.format(subGroupTotalCost)) +"</strong></font></td>");
						
						br.append("</tr>");
					}
					else 
					{
					br.append("<tr>");
					br.append("<td colspan='7'   height='30' style=\"color: black; font-weight: bold;\" width='100%' align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong>No Data Found</strong></font></td>");
					br.append("</tr>");
				
					}
					
					i=i++;
					for (count = 0; count <= i; count++)
					{
						if (count == i) 
						{
							br.append("<tr>");
							br.append(
									"<td colspan='6' width='10%' height='50' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total Grand Cost :</strong></font></td>");
							br.append(
									"<td colspan='1' width='10%' height='50' align='center'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
											+ myFormatter.format(totalCost) + "</strong></font></td>");
							
							
			
							br.append("</tr>");
							/*
							br.append("<tr>");
							br.append(
									"<td colspan='6' width='10%' height='50' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Grand Total (In Words) :</strong></font></td>");
							br.append(
									"<td colspan='1' width='10%' height='50' align='center'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
											+ util.toInitCap(util.getAmountStr(myFormatter
													.format(totalQty1))) + "</strong></font></td>");
							
							br.append("</tr>");
							*/
							
							}
					}
					br.append("</table><br><br>");
			} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ws1 != null) {
				ws1.close();
				ws1 = null;
			}

		}
		vo.setStrTableWidth(String.valueOf("100"));
		return (br.toString()+"</div>");
	}
	
	// BME&I
	public static String printWithOutBatchReport(StockOnHandIgimsRptVO vo,String reportHeader, HttpServletRequest request,StockOnHandIgimsRptFB formBean) throws Exception {
		//WebRowSet wsItem = null;
		StringBuffer br = new StringBuffer(2000);
		
		WebRowSet ws1=null;
		
		int i=0;
		String curSubStoreName="";
		String preSubStoreName="";
		
		String curGroupName="";
		String preGroupName="";
		int count=0;
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		

		double totalCost = 0;
		double subGrpTotalInHandQty = 0;
		double subGroupTotalCost = 0;
			
		
		HisUtil util = new HisUtil("MMS Transactions", "IssueDetailRptHLP");
		try 
		{
				ws1 = vo.getStrStockInHandRptWS(); 
				br.append("<div id='wrapper' align='center'>");
				
				br.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ " <tr> "
						//+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></td>"
						+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></td>");
						br.append("</tr>");
				
				br.append(" <tr> "
						+ " <td colspan='12' align='center' style='font-size:16px;'><b>Stock In-Hand Report</b></td>");
				br.append("</tr>");
				
				br.append(" <tr> "
						+ " <td colspan='12'><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' />&nbsp; &nbsp;<img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/excel.png' onClick='generateXLSCommon(event, indentItemListDivId);' /></div></td>");
				br.append("</tr>");
				
				br.append("</table>");
				
				br.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Store Name ::<b>"+vo.getStrStoreName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 					
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Group ::<b>"+vo.getStrGroupName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Drug Type ::<b>"+vo.getStrDrugTypeName()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "Report Date & Time  ::<b>"+formBean.getStrCurrentDate()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "By User  ::<b>"+formBean.getStrUserName()+"</b></font></td><td align='center' colspan='2'></td></tr>"+
											
						 "</table><br>");
				
				br.append("<table  width='100%'  align='center' cellspacing='0px' cellpadding='1px' border='1px'>");
					br.append("<tr id='tableHeaderId' style='background-color:#D3D3D3;'>");
						br.append("<th colspan='1' height='30' style='width: 5%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> S.No. </strong></font></th>");
						br.append("<th colspan='1' height='30' style='width: 8%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Invoice No</strong></font></th>");
						br.append("<th colspan='1' height='30' style='width: 8%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Invoice Date</strong></font></th>");
						br.append("<th colspan='1' height='30' style='width:20%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Item Name </strong></font></th>");
						br.append("<th colspan='1' height='30' style='width:10%; color:black;'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Item Type</strong></font></th>");
						br.append("<th colspan='1' height='30' style='width:10%; color:black;'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Batch No.</strong></font></th>");
						br.append("<th colspan='1' height='30' style='width:10%; color:black;'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Exp. Date</strong></font></th>");
						br.append("<th colspan='1' height='30' style='width:12%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Supplier Name </strong></font></th>");
						br.append("<th colspan='1' height='30' style='width: 8%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Rate </strong></font></th>");
						br.append("<th colspan='1' height='30' style='width: 8%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Rate(Inc gst)</strong></font></th>");
						br.append("<th colspan='1' height='30' style='width: 8%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Sale Rate</strong></font></th>");
						br.append("<th colspan='1' height='30' style='width:8%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Mrp </strong></font></th>");

						br.append("<th colspan='1' height='30' style='width:10%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Qty</strong></font></th>");
						br.append("<th colspan='1' height='30' style='width:10%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Total Value </strong></font></th>");

					br.append("</tr>");
				
				
					if (ws1.size() > 0) 
					{				
						while (ws1.next()) 
						{
								//groupTotalCose+=Double.parseDouble(ws1.getString("12"));
								curGroupName = ws1.getString(2);
								if((!preGroupName.equals(curGroupName))&& preGroupName !="" )
								{
									
									br.append("<tr bgcolor='#c0ded9' >");
									br.append("<td colspan='12' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Total :</strong></font></td>");
									br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
													+ (myFormatter.format(subGrpTotalInHandQty).split("\\.")[0]) + "</strong></font></td>");
									br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+ (myFormatter.format(subGroupTotalCost)) +"</strong></font></td>");
									
									br.append("</tr>");
										
									subGrpTotalInHandQty=0;
									subGroupTotalCost=0;
										
								}
								/*
							       1. Store Name
							       2. Grp Name
							       3. Item Name
							       4. Batch_no
							       5. Active Qty
							       6. Qrantine Qty
							       7. In Actvie Qty
							       8. Total In Hand
							       9. Tax
							      10. Rate Wth Unit
							      11. Purchae Price
							      12. Sale Price
							      13. Exp_date
							      14. Supp Name
							      15. Cost Value
							      16. Item type
							      17. User Name
							      18. Invoice No
							      19. Invoice Date
							      20. MRP 
							  */
								System.out.println("ws1.getString(4)--Batch--"+ws1.getString(4));
								System.out.println("ws1.getString(3)--Item name--"+ws1.getString(3));
								System.out.println("ws1.getString(16)--Item Type--"+ws1.getString(16));
								System.out.println("ws1.getString(5)--Qty--"+ws1.getString(5));
								System.out.println("ws1.getString(15)--Cost--"+ws1.getString(15));
								System.out.println("ws1.getString(14)----"+ws1.getString(14));
								System.out.println("ws1.getString(20)----"+ws1.getString(20)); 


								subGroupTotalCost += (ws1.getString(15) != null && isNumeric(ws1.getString(15))) ? Double.parseDouble(ws1.getString(15)) : 0.0;
							
//								subGroupTotalCost     += Double.parseDouble(ws1.getString(15));  // Cost
								subGrpTotalInHandQty  += Integer.parseInt(ws1.getString(5));     // Active Qty
//								totalCost             += Double.parseDouble(ws1.getString(15));  // Cost
								totalCost += (ws1.getString(15) != null && isNumeric(ws1.getString(15))) ? Double.parseDouble(ws1.getString(15)) : 0.0;

								if(!curGroupName.equals(preGroupName))
								{
									br.append("<tr>");
									br.append("<td colspan='9' style=\"text-align:left; width:5%;\"><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><b> "+curGroupName+ "</b></font></td>");
									br.append("</tr>");
								}
								//preGroupName=curGroupName;
								
							/*
						       1. Store Name
						       2. Grp Name
						       3. Item Name
						       4. Batch_no
						       5. Active Qty
						       6. Qrantine Qty
						       7. In Actvie Qty
						       8. Total In Hand
						       9. Tax
						      10. Rate Wth Unit
						      11. Purchae Price
						      12. Sale Price
						      13. Exp_date
						      14. Supp Name
						      15. Cost Value
						      16. Item type
						      17. User Name
						      18. Invoice No
						      19. Invoice Date
						  */
								
							br.append("<tr>");
							    br.append("<td colspan='1' height='20' style=\"text-align:center;   width: 5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ (i+1) + "</font></td>");
							    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(18) + "</font></td>"); // Invoice no  
							    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(19) + "</font></td>"); // Invoice date  
							    br.append("<td colspan='1' height='20' style=\"text-align:left;     width:20%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(3) + "</font></td>");  //Item Name 
							    //br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(16) + "</font></td>"); //Item type 
							   
							    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>");
							    br.append(ws1.getString(16) != null ? ws1.getString(16) : "-");
							    br.append("</font></td>"); // Item type
							    
							    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(4) + "</font></td>");  //btach 
							    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(13) + "</font></td>"); //Expiry date
							    br.append("<td colspan='1' height='20' style=\"text-align:left;     width:12%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(14) + "</font></td>"); //Supplier Name	

							    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(10) + "</font></td>");	 // rate 
							    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(11) + "</font></td>"); // rate with gst 
							    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(12) + "</font></td>"); // sale rate 
							    
							    br.append("<td colspan='1' height='20' style=\"text-align:left;     width:8%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>");
							    br.append(ws1.getString(20) != null ? ws1.getString(20) : "0");
							    br.append("</font></td>"); // MRP
							  
							    br.append("<td colspan='1' height='20' style=\"text-align:center;   width: 8%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(5) + "</font></td>");  //Qty
							    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(15) + "</font></td>"); // Total Amount 
						    br.append("</tr>");
				
							count++;
							i++;
							
							preGroupName=curGroupName;
							
					  }
					  br.append("<tr bgcolor='#c0ded9' >");
					  br.append("<td colspan=12' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Total :</strong></font></td>");
					  br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
									+ (myFormatter.format(subGrpTotalInHandQty).split("\\.")[0]) + "</strong></font></td>");
					  br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+ (myFormatter.format(subGroupTotalCost)) +"</strong></font></td>");
					
					  br.append("</tr>");
					}
					else 
					{
					br.append("<tr>");
					br.append("<td colspan='10'   height='30' style=\"color: black; font-weight: bold;\" width='100%' align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong>No Data Found</strong></font></td>");
					br.append("</tr>");
				
					}
					
					//i=i++;
					for (count = 0; count <= i; count++) {
						if (count == i) {
							br.append("<tr>");
								br.append("<td colspan='13' width='10%' height='50' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Grand Total :</strong></font></td>");
								br.append("<td colspan='1' width='10%' height='50' align='center'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
												+ myFormatter.format(totalCost) + "</strong></font></td>");
							br.append("</tr>");
							}
					}
					
					br.append("</table><br><br>");
			} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ws1 != null) {
				ws1.close();
				ws1 = null;
			}
		}
		vo.setStrTableWidth(String.valueOf("100"));
		return (br.toString()+"</div>");
	}
	
	public static String printWithOutBatchReport_NEW(StockOnHandIgimsRptVO vo,String reportHeader, HttpServletRequest request,StockOnHandIgimsRptFB formBean) throws Exception {
			//WebRowSet wsItem = null;
			StringBuffer br = new StringBuffer(2000);
			
			WebRowSet ws1=null;
			
			int i=0;
			String curSubStoreName="";
			String preSubStoreName="";
			
			String curGroupName="";
			String preGroupName="";
			int count=0;
			DecimalFormat myFormatter = new DecimalFormat("0.00");
			

			double totalCost = 0;
			double subGrpTotalInHandQty = 0;
			double subGroupTotalCost = 0;
				
			
			HisUtil util = new HisUtil("MMS Transactions", "IssueDetailRptHLP");
			try 
			{
					ws1 = vo.getStrStockInHandRptWS(); 
					br.append("<div id='wrapper' align='center'>");
					
					br.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
							+ " <tr> "
							//+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></td>"
							+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></td>");
							br.append("</tr>");
					
					br.append(" <tr> "
							+ " <td colspan='12' align='center' style='font-size:16px;'><b>Stock In-Hand Report</b></td>");
					br.append("</tr>");
					
					br.append(" <tr> "
					        + " <td colspan='1'></td>"
							+ " <td colspan='1'></td>"
							+ " <td colspan='1'><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' />&nbsp; &nbsp;<img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/excel.png' onClick='generateXLSCommon(event, indentItemListDivId);' /></div></td>");
					br.append("</tr>");
					
					br.append("</table>");
					
					
					br.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"						
							+ " <tr><td align='center' colspan='3'></td> "
							+ "<td align='center' colspan='3'>"
							+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
							+ "For Store Store Name ::<b>"+vo.getStrStoreName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 					
							
							+ " <tr><td align='center' colspan='3'></td> "
							+ "<td align='center' colspan='3'>"
							+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
							+ "For Group ::<b>"+vo.getStrGroupName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
							
							
							+ " <tr><td align='center' colspan='3'></td> "
							+ "<td align='center' colspan='3'>"
							+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
							+ "For Type ::<b>"+vo.getStrDrugTypeName()+"</b></font></td><td align='center' colspan='2'></td></tr>"
							
							+ " <tr><td align='center' colspan='3'></td> "
							+ "<td align='center' colspan='3'>"
							+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
							+ "Report Date & Time  ::<b>"+formBean.getStrCurrentDate()+"</b></font></td><td align='center' colspan='2'></td></tr>"
							
							+ " <tr><td align='center' colspan='3'></td> "
							+ "<td align='center' colspan='3'>"
							+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
							+ "By User  ::<b>"+formBean.getStrUserName()+"</b></font></td><td align='center' colspan='2'></td></tr>"+
												
							 "</table> <br>");
					
					br.append("<table  width='100%'  align='center' cellspacing='0px' cellpadding='1px' border='1px'>");
				
					br.append("<tr id='tableHeaderId' style='background-color:#D3D3D3;'>");
					
					br.append("<th colspan='1' height='30' style='width: 5%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> S.No. </strong></font></th>");
					br.append("<th colspan='1' height='30' style='width: 8%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Invoice No</strong></font></th>");
					br.append("<th colspan='1' height='30' style='width: 8%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Invoice Date</strong></font></th>");
					br.append("<th colspan='1' height='30' style='width:20%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Item Name </strong></font></th>");
					br.append("<th colspan='1' height='30' style='width:10%; color:black;'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Item Type</strong></font></th>");
					br.append("<th colspan='1' height='30' style='width:10%; color:black;'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Batch No.</strong></font></th>");
					br.append("<th colspan='1' height='30' style='width:10%; color:black;'	align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Exp. Date</strong></font></th>");
					br.append("<th colspan='1' height='30' style='width:12%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Supplier Name </strong></font></th>");
					br.append("<th colspan='1' height='30' style='width: 8%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Rate </strong></font></th>");
					br.append("<th colspan='1' height='30' style='width: 8%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Rate(Inc gst)</strong></font></th>");
					br.append("<th colspan='1' height='30' style='width: 8%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Sale Rate</strong></font></th>");
					br.append("<th colspan='1' height='30' style='width:10%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Qty</strong></font></th>");
					br.append("<th colspan='1' height='30' style='width:10%; color:black;'  align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong> Total Value </strong></font></th>");
					br.append("</tr>");
					
					
						if (ws1.size() > 0) 
						{				
			
							while (ws1.next()) 
							{
								
								
									//groupTotalCose+=Double.parseDouble(ws1.getString("12"));
									curGroupName = ws1.getString(2);
									if((!preGroupName.equals(curGroupName))&& preGroupName !="" )
									{
										
										br.append("<tr bgcolor='#c0ded9' >");
										br.append("<td colspan='11' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Total :</strong></font></td>");
										br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
														+ (myFormatter.format(subGrpTotalInHandQty).split("\\.")[0]) + "</strong></font></td>");
										br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+ (myFormatter.format(subGroupTotalCost)) +"</strong></font></td>");
										
										br.append("</tr>");
											
										subGrpTotalInHandQty=0;
										subGroupTotalCost=0;
											
									}
									/*
									 * 1.Store Name
									 * 2.Group Name
									 * 3.Item Name
									 * 4.Batch No
									 * 5.Active Qty
									 * 6.Quarntine Qty
									 * 7.In-Active Qty
									 * 8.Total In-Hand
									 * 9.Rate With Unit
									 * 10.Expiry Date
									 * 11.Supplier Name
									 * 12.Cost Value 	
									 * 13. Item_Type
									 * 14.User Name Based on Seat Id						
									 * */
									
									subGroupTotalCost     += Double.parseDouble(ws1.getString(14));  // Cost
									subGrpTotalInHandQty  += Integer.parseInt(ws1.getString(5));  // Active Qty
									totalCost             += Double.parseDouble(ws1.getString(14));  // Cost
									
									if(!curGroupName.equals(preGroupName))
									{
										br.append("<tr>");
										br.append("<td colspan='9' style=\"text-align:left; width:5%;\"><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><b> "+curGroupName+ "</b></font></td>");
										br.append("</tr>");
									}
									//preGroupName=curGroupName;
									
									/*
									 * 1.Store Name
									 * 2.Group Name
									 * 3.Item Name
									 * 4.Batch No
									 * 5.Active Qty
									 * 6.Quarntine Qty
									 * 7.In-Active Qty
									 * 8.Total In-Hand
									 * 9.Rate With Unit
									 * 10.Expiry Date
									 * 11.Supplier Name
									 * 12.Cost Value 	
									 * 13. Item_Type
									 * 14.User Name Based on Seat Id						
									 * */
									
								br.append("<tr>");
							    br.append("<td colspan='1' height='20' style=\"text-align:center;   width: 5%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ (i+1) + "</font></td>");
							    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(17) + "</font></td>"); // Invoice no  
							    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(18) + "</font></td>"); // Invoice date  
							    br.append("<td colspan='1' height='20' style=\"text-align:left;     width:20%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(3) + "</font></td>");  //Item Name 
							    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(15) + "</font></td>"); //Item type 
							    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(4) + "</font></td>");  //btach 
							    br.append("<td colspan='1' height='20' style=\"text-align:center;   width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(12) + "</font></td>"); //Expiry date
							    br.append("<td colspan='1' height='20' style=\"text-align:left;     width:12%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(13) + "</font></td>"); //Supplier Name				    
							    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(9) + "</font></td>");	 // rate 
							    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(10) + "</font></td>"); // rate with gst 
							    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(11) + "</font></td>"); // sale rate  
							    br.append("<td colspan='1' height='20' style=\"text-align:center;   width: 8%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(5) + "</font></td>");  //Qty
							    br.append("<td colspan='1' height='20' style=\"text-align:right;    width:10%;\"><font size='2' face='Verdana, Arial, Helvetica, sans-serif'>"+ ws1.getString(14) + "</font></td>"); // Total Amount 
							    br.append("</tr>");
								
					
								count++;
								i++;
								
								preGroupName=curGroupName;
								
						  }
						  br.append("<tr bgcolor='#c0ded9' >");
						  br.append("<td colspan=11' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Group Total :</strong></font></td>");
						  br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
										+ (myFormatter.format(subGrpTotalInHandQty).split("\\.")[0]) + "</strong></font></td>");
						  br.append("<td colspan='1' width='10%' height='20' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"+ (myFormatter.format(subGroupTotalCost)) +"</strong></font></td>");
						
						  br.append("</tr>");
						}
						else 
						{
						br.append("<tr>");
						br.append("<td colspan='9'   height='30' style=\"color: black; font-weight: bold;\" width='100%' align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif'><strong>No Data Found</strong></font></td>");
						br.append("</tr>");
					
						}
						
						i=i++;
						for (count = 0; count <= i; count++) {
							if (count == i) {
								br.append("<tr>");
								br.append(
										"<td colspan='12' width='10%' height='50' align='right'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>Grand Total :</strong></font></td>");
								br.append(
										"<td colspan='1' width='10%' height='50' align='center'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><strong>"
												+ myFormatter.format(totalCost) + "</strong></font></td>");
								
								
				
								br.append("</tr>");
								}
						}
						br.append("</table><br><br>");
				} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (ws1 != null) {
					ws1.close();
					ws1 = null;
				}

			}
			vo.setStrTableWidth(String.valueOf("100"));
			return (br.toString()+"</div>");
		}

}


