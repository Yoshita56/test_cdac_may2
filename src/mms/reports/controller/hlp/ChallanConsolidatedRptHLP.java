/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         ChallanConsolidatedRptHLP.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.controller.hlp;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;


import mms.reports.vo.ChallanConsolidatedRptVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ChallanConsolidatedRptHLP.
 */
public class ChallanConsolidatedRptHLP {

	/**
	 * Gets the challan process dtl pop up.
	 * 
	 * @param vo the vo
	 * @param strReportHeader the str report header
	 * @param strDBHeader the str db header
	 * @param request the request
	 * @return the challan process dtl pop up
	 * @throws Exception the exception
	 */
	public static String
			getChallanProcessDtlPopUp(ChallanConsolidatedRptVO vo, String strReportHeader, String strDBHeader, HttpServletRequest request, String strStoreTypeName, String strDistrictStoreName)
					throws Exception {
		StringBuffer br = new StringBuffer();
		ResourceBundle res = ResourceBundle
				.getBundle("hisglobal.hisconfig.hisReport");
		
		mms.qryHandler_mms.res = res;
		int count = 0;
		WebRowSet ws = null;
		int i = 1;
		int width1 = 3;
		int width2 = 7;
		int width3 = 8;
		int width4 = 7;
		int width5 = 17;
		int width6 = 6;
		int width7 = 5;
		int width8 = 4;
		int width9 = 7;
		int width10 = 6;
		int width11 = 6;
		int width12 = 4;
		int width13 = 4;
		int width14 = 4;
		int width15 = 4;
		int width16 = 4;
		int width17 = 4;

		try {
			
			String date_time="";
			ws = vo.getStrChallanDtlWS();

			/*br.append("<HTML><HEAD><title>Consolidated Challan Report</title><link href=\"../../hisglobal/css/dwh.css\" rel=\"stylesheet\" type=\"text/css\">");
			br.append("<link href=\"../../hisglobal/css/control.css\" rel=\"stylesheet\" type=\"text/css\">");
			br.append("<link href=\"../../hisglobal/DataTables/datatables.min.css\" rel=\"stylesheet\" type=\"text/css\">");			
						
			br.append("<script language='Javascript' src='../../mms/js/dwh_consolidated_challan_rpt.js'></script>");
			br.append("<script language='Javascript' src='../../hisglobal/js/innerxhtml.js'></script>");
			br.append("<script language='Javascript' src='../../hisglobal/js/commonFunctions.js'></script>");
			br.append("<script language='Javascript' src='../../hisglobal/js/fixedHeaderReport.js'></script>");
			
			br.append("</HEAD><body><div id='mask' style='display:block;'></div><div id='dvLoading' style='display:block;'></div>");
			br.append("<form action='/DWH_ANDHRA/mms/reports/ChallanConsolidatedRptCNT.cnt' method='post'>");*/
			//br.append("<div id='consChallanDtlDivId'>");

			br.append("<table id='conso_challan_table' width='100%' border='0' cellspacing='0' cellpadding='0'>");
			/*br.append("<tr>");
			br.append("<td width='50%'>");
			br.append("<table align='center' width='100%' border='0' cellspacing='0' cellpadding='0'> ");
			br.append("<tr>");
			br.append("<td width='100%' align='right'> <b><font size='2' face='Times New Roman'> ");   //Verdana, Arial, Helvetica, sans-serif
			br.append("User Name : " + vo.getStrUserName());
			br.append("</font></b></td> ");
			br.append("</tr>");
			br.append("</table> ");
			br.append("</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>");
			br.append("</tr>");*/			

			br.append("<tr><td></td><td></td><td></td><td></td>");
			br.append("<td>");
			br.append("<table align='center' width='100%' border='0' cellspacing='0' cellpadding='0'' style='font-weight: bold; font-family: verdana;'>");
			br.append("<thead><tr><th></th></tr></thead><tbody>");
			br.append("<tr>");
			br.append("<td width='25%' align='left' valign='top'> <b><font size='2' face='Times New Roman'>");   //Verdana, Arial, Helvetica, sans-serif
			br.append("User Name : " + vo.getStrUserName()+ "<br>Report Date and Time : "+date_time);
			br.append("</font></b></td> ");
			br.append("<td width='50%' align='center'>");
			//br.append("<img align='absmiddle' src='http://" + request.getServerName() + ":" + request.getServerPort()+ "/DWH_ANDHRA/hisglobal/images/report_header_withAddress.png'/>");  //</div>
			br.append("<img align='absmiddle' src='/INVMGM/hisglobal/images/aiims_inv_header.png'/>");  //</div>
			br.append("<br><br></td>");
			br.append("<td align='right' width='25%' valign='top'>");
			br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'><div id='printImg'>");
			br.append("<img style='cursor: pointer; ' title='Print Page'  ");
			br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printThis();' />");
			br.append("<img style='cursor: pointer; ' title='Save as Pdf' src='../../hisglobal/images/pdf.png' onClick='generatePdfCommon(\"consChallanDtlDivIdOuter\");' />");
			br.append("<img style='cursor: pointer; ' title='Save as Excel' src='../../hisglobal/images/excel1.png' onClick='generateXLSCommon(event,\"consChallanDtlDivIdOuter\");' />");
			br.append("<img style='cursor: pointer; ' title='Cancel Process' src='../../hisglobal/images/stop.png' onClick='cancelPrintToDesk();' /> </div></div></div>");
			br.append("<br></td> ");
			br.append("</tr>");
		    br.append("</tbody>");
			br.append("</table></td>");			
			br.append("<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>");			
			br.append("</tr>");
			
			br.append("<tr><td></td><td></td><td></td><td></td>");
			br.append("<td>");
			br.append("<table align='center' width='1500' border='0' cellspacing='0' cellpadding='0'> ");
			br.append("<tr>");
			br.append("<td width='100%' align='center' style='padding-left:25px'> <b><font size='3' face='Verdana, Arial, Helvetica, sans-serif'> ");
			br.append("Consolidated Challan Report");
			br.append("</font></b><br><br></td> ");
			br.append("</tr> ");
			/*br.append("<tr>");
			br.append("<td width='100%' align='center' style='padding-left:25px'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
			br.append("Store Type: " +strStoreTypeName);  
			br.append("</font></b></td> ");
			br.append("</tr> ");
			br.append("<tr>");
			br.append("<td width='100%' align='center' style='padding-left:25px'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
			br.append("Store Name: " +strDistrictStoreName);  
			br.append("</font></b></td> ");
			br.append("</tr> ");*/
			br.append("</table></td>");
			br.append("<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>");
			br.append("</tr>");

			br.append("<tr><td colspan='17'>");
			br.append("<table align='center' width='1500' border='0' cellspacing='0' cellpadding='0'> ");
			br.append("<tr id='reportDisplayHeaderRow'> ");
			br.append("<td id='reportDisplayHeaderData' width='100%' colspan='17' align='center' style='padding-left:25px'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
			br.append("<div id='reportheader' style='text-align:center;'>");
			br.append(strReportHeader);
			br.append("</div></font></b><br><br></td> ");
			br.append("</tr> ");
			br.append("</table> ");
			br.append("</td></tr>");
           
			/*br.append("<tr>");
			br.append("<td colspan='17'>");
			br.append("<table border='0' width='1500' align='center'> ");
			br.append("<tr> ");
			br.append("<td align='right'>");
			br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'><div id='printImg'>");
			br.append("<img style='cursor: pointer; ' title='Print Page'  ");
			br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printThis();' />");
			br.append("<img style='cursor: pointer; ' title='Save as Pdf' src='../../hisglobal/images/pdf.png' onClick='generatePdfCommon(\"consChallanDtlDivId\");' />");
			br.append("<img style='cursor: pointer; ' title='Save as Excel' src='../../hisglobal/images/excel1.png' onClick='generateXLSCommon(event,\"consChallanDtlDivId\");' />");
			br.append("<img style='cursor: pointer; ' title='Cancel Process' src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div></div>");
			br.append("<br></td> ");
			br.append("</tr> ");
			br.append("</table> ");
			br.append("</td>");
			//br.append("</td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td>");
			br.append("</tr>");*/

			br.append("<tr><td colspan='17'>");
			br.append("<div id='wrapper' style='width:1500;'><table id='mainTableRptId' width='1250' border='0' align='center'   cellpadding='1px'>");
			// header
			if (!vo.getStrSupplierWiseRptFlg().equals("1")) {
				width2 = 10;
				width3 = 8;
			} else {
				width2 = 18;
				width3 = 0;
			}
			br.append("<thead>");
		    br.append("<tr id='tableHeaderId'> ");
			br.append("<th style=\"text-align: center;\" colspan='1' width='" + width1
					+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.<b></font></th>\n");
			br.append("<th style=\"text-align: center;\" colspan='1' width='" + width2
					+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name<b></font></th>\n");
			if (!vo.getStrSupplierWiseRptFlg().equals("1")) {
				br.append("<th style=\"text-align: center;\" colspan='1' width='" + width3
						+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier Name<b></font></th>\n");
			}
			br.append("<th style=\"text-align: left;\" colspan='1' width='" + width4
					+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Tender No.<b></font></th>\n");
			br.append("<th style=\"text-align: center;\" colspan='1' width='" + width5
					+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No.<b></font></th>");
			br.append("<th style=\"text-align: center;\" colspan='1' width='" + width6
					+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>PO Date<b></font></th>\n");
			br.append("<th style=\"text-align: center;\" colspan='1' width='" + width7
					+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Location<b></font></th>\n");
			br.append("<th style=\"text-align: center;\" colspan='1' width='" + width8
					+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>PO Qty. (No.)<b></font></th>\n");
			br.append("<th style=\"text-align: center;\" colspan='1' width='" + width9
					+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Challan No.<b></font></th>\n");
			br.append("<th style=\"text-align: center;\" colspan='1' width='" + width10
					+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Challan Freeze Date<b></font></th>\n");
			br.append("<th style=\"text-align: center;\" colspan='1' width='" + width11
					+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Material Received Date<b></font></th>\n");
			br.append("<th style=\"text-align: center;\" colspan='1' width='" + width12
					+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rec. Qty. of Challan (No.)<b></font></th>\n");
			br.append("<th style=\"text-align: center;\" colspan='1' width='" + width13
					+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Acc. Qty. (No.)<b></font></th>\n");
			br.append("<th style=\"text-align: center;\" colspan='1' width='" + width14
					+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Bal. Qty. (No.)<b></font></th>\n");
			br.append("<th style=\"text-align: center;\" colspan='1' width='" + width15
					+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Breakage Qty. (No.)<b></font></th>\n");
			br.append("<th style=\"text-align: center;\" colspan='1' width='" + width16
					+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Excess Qty. (No.)<b></font></th>\n");
			br.append("<th style=\"text-align: center;\" colspan='1' width='" + width17
					+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rejected Qty (No.)<b></font></th>\n");
			br.append("</tr></thead>");
			br.append("<tbody>");

			if (ws != null) 
			{
				if (ws.size() != 0) 
				{
					while (ws.next()) 
					{

						/*
						 * 1.Item Name 2.Supplier Name 3.Po_dtl [Tender No^Po No] 4.Po Date 5.Consignee Store Name 6.PO_QTY (Order Qty) 7.CHALLAN_DTL
						 * FirstChallan[Challan No^Freeze Date^Received Date^Received Qty^Accepted Qty^Breakage Qty^Excess Qty^Rejected Qty]
						 * #SecondChallan[Challan No^Freeze Date^Received Date^Received Qty^Accepted Qty^Breakage Qty^Excess Qty^Rejected Qty] and so
						 * on
						 */

						
						br.append("<tr> ");
						br.append("<td style=\"text-align: center;\" colspan='1' width='" + width1
								+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + (i++) + "</font></td>\n");
						br.append("<td style=\"text-align: left;\" colspan='1'   width='" + width2
								+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(1) + "</font></td>\n");
						if (!vo.getStrSupplierWiseRptFlg().equals("1")) {
							br.append("<td style=\"text-align: left;\" colspan='1'   width='" + width3
									+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(2) + "</font></td>\n");
						}
						br.append("<td style=\"text-align: left;\" colspan='1' width='" + width4
								+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(3).split("\\^")[0]
								+ "</font></td>\n");
						br.append("<td style=\"text-align: left;\" colspan='1'   width='" + width5
								+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(3).split("\\^")[1]
								+ "</font></td>\n");
						br.append("<td style=\"text-align: center;\" colspan='1' width='" + width6
								+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(4) + "</font></td>\n");
						br.append("<td style=\"text-align: left;\" colspan='1'  width='" + width7
								+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(5) + "</font></td>\n");
						br.append("<td style=\"text-align: right;\" colspan='1'   width='" + width8
								+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(6) + "</font></td>\n");

						String challanDtl[] = ws.getString(7).split("#");
						int balanceQty = 0;
						for (int j = 0; j < challanDtl.length; j++) 
						{

							if (j != 0) {
								br.append("<tr> ");
								br.append("<td style=\"text-align: center;\" colspan='1' width='" + width1
										+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + (i++) + "</font></td>\n");
								br.append("<td style=\"text-align: left;\" colspan='1'   width='" + width2
										+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(1) + "</font></td>\n");
								if (!vo.getStrSupplierWiseRptFlg().equals("1")) {
									br.append("<td style=\"text-align: left;\" colspan='1'   width='" + width3
											+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(2)
											+ "</font></td>\n");
								}
								br.append("<td style=\"text-align: left;\" colspan='1' width='" + width4
										+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(3).split("\\^")[0]
										+ "</font></td>\n");
								br.append("<td style=\"text-align: left;\" colspan='1'   width='" + width5
										+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(3).split("\\^")[1]
										+ "</font></td>\n");
								br.append("<td style=\"text-align: center;\" colspan='1' width='" + width6
										+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(4) + "</font></td>\n");
								br.append("<td style=\"text-align: left;\" colspan='1'  width='" + width7
										+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(5) + "</font></td>\n");
								br.append("<td style=\"text-align: right;\" colspan='1'   width='" + width8
										+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(6) + "</font></td>\n");
							}
							if (challanDtl[j].split("\\^")[4].equals("--")) {
								balanceQty = Integer.parseInt(ws.getString(6));
							} else {
								if (j == 0) {
									balanceQty = Integer.parseInt(ws.getString(6)) - Integer.parseInt(challanDtl[j].split("\\^")[4]);
								} else {
									balanceQty = balanceQty - Integer.parseInt(challanDtl[j].split("\\^")[4]);
								}
							}

							br.append("<td style=\"text-align: left;\" colspan='1'   width='" + width9
									+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + challanDtl[j].split("\\^")[0]
									+ "</font></td>\n");
							br.append("<td style=\"text-align: center;\" colspan='1'   width='" + width10
									+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + challanDtl[j].split("\\^")[1]
									+ "</font></td>\n");
							br.append("<td style=\"text-align: center;\" colspan='1'   width='" + width11
									+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + challanDtl[j].split("\\^")[2]
									+ "</font></td>\n");
							br.append("<td style=\"text-align: right;\" colspan='1'  width='" + width12
									+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + challanDtl[j].split("\\^")[3]
									+ "</font></td>\n");
							br.append("<td style=\"text-align: right;\" colspan='1'  width='" + width13
									+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + challanDtl[j].split("\\^")[4]
									+ "</font></td>\n");
							br.append("<td style=\"text-align: right;\" colspan='1'  width='" + width14
									+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + balanceQty + "</font></td>\n");
							br.append("<td style=\"text-align: right;\" colspan='1'   width='" + width15
									+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + challanDtl[j].split("\\^")[5]
									+ "</font></td>\n");
							br.append("<td style=\"text-align: right;\" colspan='1'   width='" + width16
									+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + challanDtl[j].split("\\^")[6]
									+ "</font></td>\n");
							br.append("<td style=\"text-align: right;\" colspan='1'  width='" + width17
									+ "%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + challanDtl[j].split("\\^")[7]
									+ "</font></td>\n");

						}

						br.append("</tr>");
						count++;

					}

					if (ws != null) {
						ws.close();
						ws = null;
					}
				} // ws.size <> 0
				else {
					br.append("<tr><td colspan='17'></td></tr>");
					br.append("<tr>");
					br.append("<td colspan='17'><b><div id='id' align='center'>No Data Found</div></b></td>");
					br.append("</tr>");

				}
			} else {
				br.append("<tr>");
				br.append("<td colspan='17'><b><div id='id' align='center'>No Data Found</div></b></td>");
				br.append("</tr>");

			}
		}// try
		catch (Exception e) {
			e.printStackTrace();

			br.append("<tr>");
			br.append("<td colspan='17'><b><div id='id' align='center'>No Data Found</div></b></td>");
			br.append("</tr>");	
			br.append("</td></tr>");
			br.append("</tbody></table>");
			br.append("</div>");
			br.append("</div>");
			/*br.append("<input type='hidden' name='hmode'/><input type='hidden' name='strHtmlCode' value='' />");
			br.append("</form></body></HTML>");*/

			if (ws != null) {
				ws.close();
				ws = null;
			}

			throw new Exception("ChallanConsolidatedRptVO.getChallanProcessDtl()->" + e.getMessage());
		}

		
		br.append("</tbody></table>");
		//br.append("</div>");
		br.append("</td></tr></tbody></table>");
		/*br.append("<input type='hidden' name='hmode'/><input type='hidden' name='strHtmlCode' value='' />");
		br.append("</form></body></HTML>");*/

		return br.toString();

	}

	/**
	 * Gets the prints the indent details.
	 * 
	 * @param vo the vo
	 * @param tableHeader the table header
	 * @param strDBHeader the str db header
	 * @param request 
	 * @return the prints the indent details
	 */
	public static String getPrintIndentDetails(ChallanConsolidatedRptVO vo, String tableHeader, String strDBHeader, HttpServletRequest request) {
		StringBuffer sb = new StringBuffer("");
		String[] tblHdrArr;
		ResourceBundle res = ResourceBundle.getBundle("hisglobal.hisconfig.hisReport");
		mms.qryHandler_mms.res = res;

		try {
			tblHdrArr = strDBHeader.split("\\^");
			sb.append("<table width='100%' cellspacing='0' cellpadding='0' border='0' align='center' id='mstHeaderTable' style='font-weight: bold; font-family: verdana;'><tbody>");
			sb.append("<tr><td width='100%' align='center' >");
			sb.append("<table>");
			//sb.append("<tbody><tr><td style='text-align:right;' rowspan='3'><img width='70' height='55px' align='absmiddle' src='../../hisglobal/images/report_header_withAddress.png'></td>");
			sb.append("<tbody><tr><td style='text-align:right;' rowspan='3'><img width='70' height='55px' align='absmiddle' src='/INVMGM/hisglobal/images/aiims_inv_header.png'></td>");
			if (!tblHdrArr[0].trim().equals("NA")) {
				sb.append("<td style='padding-left:20px;font-size:14px;'>" + tblHdrArr[0] + "</td></tr>");
			} else {
				sb.append("<td style='padding-left:20px;font-size:14px;'>" + res.getString("REPORT_HEADER_A") + "</td></tr>");
			}
			if (!tblHdrArr[1].trim().equals("NA")) {
				sb.append("<tr><td style='padding-left:10px;font-size:14px;'>" + tblHdrArr[1] + "</td></tr>");
			} else {
				sb.append("<tr><td style='padding-left:10px;font-size:14px;'>" + res.getString("REPORT_HEADER_B") + "</td></tr>");
			}
			if (!tblHdrArr[2].trim().equals("NA")) {
				sb.append("<tr><td style='font-size:14px;'>" + tblHdrArr[2] + "</td></tr>");
			} else {
				sb.append("<tr><td style='font-size:14px;'>" + res.getString("REPORT_HEADER_C") + "</td></tr>");
			}
			sb.append("</tbody></table>");
			sb.append("</td></tr>");
			sb.append("<tr>");
			sb.append("<td style='font-size:14px;text-align:center'>" + res.getString("REPORT_ADDRESS") + "</td>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td style='text-align:center;font-size:14px' colspan='2'>Phone No , Fax No.</td></tr>");
			sb.append("<tr>");
			sb.append("<td width='100%' align='center' style='padding-left:20px;font-size:12px;'> <b>");
			sb.append(tableHeader);
			sb.append("</font>");
			sb.append("</td></tr>");
			sb.append("</tbody></table>");

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("PurchaseOrderDtlRptHLP.getPrintIndentDetails() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}
}