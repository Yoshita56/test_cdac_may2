/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         TransferDemandReqTransHLP.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;
import hisglobal.hisconfig.HisLanguageProperties;
import hisglobal.utility.HisUtil;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import mms.transactions.controller.fb.TransferDemandReqTransFB;

/**
 * The Class TransferDemandReqTransHLP.
 */
public class TransferDemandReqTransHLP {

	/**
	 * Gets the drug details.
	 * 
	 * @param wb the wb
	 * @param formBean the form bean
	 * @param request the request
	 * @return the drug details
	 */
	public static String getDrugDetails(WebRowSet wb, TransferDemandReqTransFB formBean, HttpServletRequest request) {
		StringBuffer br = new StringBuffer("");
		String drugDtlDivId = "";
		try {

			String index = request.getParameter("strTransferNo").split("\\^")[1];
			String mode = request.getParameter("mode");
			if (mode.equals("2")) {
				drugDtlDivId = "drugDtlPrintId";
			} else {
				drugDtlDivId = "drugDtlId";
			}

			if (wb.size() != 0) {

				br.append("<table width='450' style='border-collapse: collapse;' border='0' bgcolor='#CC9966' cellspacing ='0' cellpadding='1'>");
				br.append("<tr class='HEADER'>");
				br.append("<th align='right' colspan=4><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp Window' ");
				br.append("src='../../hisglobal/images/stop.png' onClick='hideDrugDetails(\"" + drugDtlDivId + "\",\"" + index + "\");'></th>");
				br.append("</tr>");
				br.append("</table>");
				br.append("<table width='450' style='border-collapse: collapse;' border='0' cellspacing='0' cellpadding='1'>");
				br.append("<tr>");
				br.append("<td colspan='1' class='multiRPTLabel' >Batch No.</td>");
				br.append("<td colspan='1' class='multiRPTLabel'>Exp. Date</td>");
				br.append("<td colspan='1' class='multiRPTLabel'>Transfer Qty.</td>");
				br.append("<td colspan='1' class='multiRPTLabel'>Rec/Bkg Qty.</td>");
				br.append("</tr>");
				while (wb.next()) {
					br.append("<tr>");
					br.append("<td colspan='1' class='multiPOControl'>");
					br.append(wb.getString(1));
					br.append("</td><td  colspan='1' class='multiPOControl'>");
					br.append(wb.getString(2));
					br.append("</td><td  colspan='1' class='multiPOControl'>");
					br.append(wb.getString(3));
					br.append("</td><td  colspan='1' class='multiPOControl'>");
					br.append(wb.getString(4));
					br.append("</td></tr>");
				}
				br.append("<tr class='FOOTER'>");
				br.append("<th align='right' colspan=4></th>");
				br.append("</tr>");
				br.append("</table>");
			} else {
				br.append("<tr>");
				br.append("<td colspan='4'  CLASS='multiControl' ><DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED TRANSFER NO ");
				br.append("</div></TD></tr>");
			}
		} catch (Exception e) {
			formBean.setStrMsgString("TransferDemandReqTransHLP.getDrugDetails() --> " + e.getMessage());
			formBean.setStrMsgType("1");
		}
		return br.toString();
	}

	/**
	 * Gets the transfer details.
	 * 
	 * @param formBean the form bean
	 * @return the transfer details
	 */
	public static String getTransferDetails(TransferDemandReqTransFB formBean) {
		StringBuffer sb = new StringBuffer("");
		int count = 0;
		WebRowSet ws = null;

		try {

			ws = formBean.getWbTransferOrderDetail();

			sb.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='0px'>");
			sb.append("<tr>");
			sb.append("<td width='20%' class='multiRPTLabel' >Transfer No.");
			sb.append("</td><td width='20%' class='multiRPTLabel' >Transfer Date");
			sb.append("</td><td width='20%' class='multiRPTLabel' >Transfer Qty.");
			sb.append("</td><td width='20%' class='multiRPTLabel' >Rec/Bkg  Qty.");
			sb.append("</td><td width='20%' class='multiRPTLabel' >Received Date");
			sb.append("</td></tr>");

			if (ws != null && ws.size() != 0) {
				/*
				 * 1- Transfer No 2- Transfer Date 3- Transfer Qty with Unit Size 4- Recived Date 5- Recived Qty with Unit Size 6- Store ID
				 */

				while (ws.next()) {

					String transNo = (ws.getString(1) == null || ws.getString(1).equals("")) ? "0" : ws.getString(1);
					String transDate = (ws.getString(2) == null || ws.getString(2).equals("")) ? "NA" : ws.getString(2);
					String transQty = (ws.getString(3) == null || ws.getString(3).equals("")) ? "NA" : ws.getString(3);
					String recvdDate = (ws.getString(4) == null || ws.getString(4).equals("")) ? "NA" : ws.getString(4);
					String recvdQty = (ws.getString(5) == null || ws.getString(5).equals("")) ? "NA" : ws.getString(5);

					sb.append("<input type='hidden' name='strTransferNo' id='strTransferNo" + count + "' value='" + transNo + "'>");
					sb.append("<input type='hidden' name='strTransferStoreId' id='strTransferStoreId" + count + "' value='" + ws.getString(6) + "'>");
					sb.append("<tr>");
					sb.append("<td width='20%' class='multiPOControl' style='font-face:Verdana, Arial, Helvetica, sans-serif; font-size:11px;'>");
					sb.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strDrugName' id='strDrugName" + count
							+ "' onClick='drugDtl(this,\"" + count + "\");'>" + transNo + "</a> &nbsp;");
					sb.append("<div class='popup' id='drugDtlId" + count + "' style='display:none'></div>");
					sb.append("</td><td width='20%' class='multiPOControl' >");
					sb.append(transDate);
					sb.append("</td><td width='20%' class='multiPOControl' >");
					sb.append(transQty);
					sb.append("</td><td width='20%' class='multiPOControl' >");
					sb.append(recvdQty);
					sb.append("</td><td width='20%' class='multiPOControl' >");
					sb.append(recvdDate);
					sb.append("</td></tr>");
					count++;
				}

			} else {
				sb.append("<tr>");
				sb.append("<td colspan='5' class='multiControl'><font color='red'  >No Record Found</font></td>");
				sb.append("</tr>");
			}
			sb.append("</table>");

		} catch (Exception e) {
			e.printStackTrace();
			new HisException("Transfer Order Details", "TransferDemandReqTransHLP.getTransferOrderDetails()-->", e.getMessage());
		}
		return sb.toString();
	}

	/**
	 * Gets the transfer order details.
	 * 
	 * @param formBean the form bean
	 * @return the transfer order details
	 */
	public static String getTransferOrderDetails(TransferDemandReqTransFB formBean,HttpServletRequest request) {
		StringBuffer sb = new StringBuffer("");
		
		WebRowSet ws = null;
		try 
		{
			ws = formBean.getWbTransferOrderDetail();
			if (ws != null && ws.size() > 0) 
			{
				sb.append("<table id='mainTableRptId' class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='0px' >");
				//sb.append("<tbody style='display:table-row-group;'><tr>");
				sb.append("<thead><tr>");
				sb.append("<tr id='tableHeaderId'>");
				sb.append("<td width='10%' class='multiRPTLabel' >"+HisLanguageProperties.getValue(request,"label.common.Order_no" ));
				sb.append("</td><td width='10%' class='multiRPTLabel' >"+HisLanguageProperties.getValue(request,"label.common.Order_date" ));
				sb.append("</td><td width='20%' class='multiRPTLabel' >"+HisLanguageProperties.getValue(request,"label.common.Order_to" ));
				sb.append("</td><td width='10%' class='multiRPTLabel' >"+HisLanguageProperties.getValue(request,"label.common.Batch" ));
				sb.append("</td><td width='10%' class='multiRPTLabel' >"+HisLanguageProperties.getValue(request,"label.common.Expiry"));
				sb.append("</td><td width='10%' class='multiRPTLabel' >"+HisLanguageProperties.getValue(request,"label.common.Order_qty" ));
				sb.append("</td><td width='15%' class='multiRPTLabel' >"+HisLanguageProperties.getValue(request,"label.common.Transfer_qty" ));
				sb.append("</td><td width='15%' class='multiRPTLabel' >"+HisLanguageProperties.getValue(request,"label.common.Rec/Bkg_qty" ));
				sb.append("</td></tr>");
				sb.append("</thead><tbody>");
				//sb.append("</tbody>");

				
				/*
				 * 1- Order No 2- Order Date 3- Order To 4- Order Qty 5- Transfer Qty  6- Ack Qty
				 * with Unit Size 7-Hidden Value [ ReqNo ^ Transfer Store ID ^ Transfer Req No ^ Transfer Date^Transfer
				 * remarks^Ack Date^ACK_REMARKS^STATUS^Demand Store ID^Order Sl No ] 8-Expiry Date , 9-Batch No 
				 */
				while (ws.next()) 
				{
					sb.append("<tr>");
					sb.append("<td width='20%' class='multiPOControl' style='font-weight:normal; font-size:11px;'>");
					sb.append(ws.getString(1));
					sb.append("</td><td width='20%' class='multiPOControl' style='font-weight:normal; font-size:11px;'>");
					sb.append(ws.getString(2));
					sb.append("</td><td width='20%' class='multiPOControl' style='font-weight:normal; font-size:11px;text-align:left;'>");
					sb.append(ws.getString(3));
					sb.append("</td>");
					
					sb.append("<td width='10%' class='multiPOControl' style='font-weight:normal; font-size:11px;'>");
					sb.append(ws.getString(9));
					sb.append("</td>");
					sb.append("<td width='10%' class='multiPOControl' style='font-weight:normal; font-size:11px;'>");
					sb.append(ws.getString(8));
					sb.append("</td>");
					
					sb.append("<td width='10%' class='multiPOControl' style='font-weight:normal; font-size:11px;'>");
					sb.append(ws.getString(4));
					sb.append("</td>");
					sb.append("<td width='15%' class='multiPOControl' style='font-weight:normal; font-size:11px;'>");
					sb.append(ws.getString(5));
					sb.append("</td><td width='15%' class='multiPOControl' style='font-weight:normal; font-size:11px;'>");
					sb.append(ws.getString(6));
					sb.append("</td></tr>");
				} 
			
			

				sb.append("</td>");
				sb.append("</tr>");
				sb.append("</tbody>");
				sb.append("</table>");
			} 
			else 
			{
				sb.append("<table id='mainTableRptId' class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='0px' >");
				//sb.append("<tbody style='display:table-row-group;'><tr>");
				sb.append("<thead><tr>");
				sb.append("<tr id='tableHeaderId'>");
				sb.append("<td width='10%' class='multiRPTLabel' >"+HisLanguageProperties.getValue(request,"label.common.Order_no" ));
				sb.append("<td width='10%' class='multiRPTLabel' >"+HisLanguageProperties.getValue(request,"label.common.Order_no" ));
				sb.append("</td><td width='10%' class='multiRPTLabel' >"+HisLanguageProperties.getValue(request,"label.common.Order_date" ));
				sb.append("</td><td width='20%' class='multiRPTLabel' >"+HisLanguageProperties.getValue(request,"label.common.Order_to" ));
				sb.append("</td><td width='10%' class='multiRPTLabel' >"+HisLanguageProperties.getValue(request,"label.common.Batch" ));
				sb.append("</td><td width='10%' class='multiRPTLabel' >"+HisLanguageProperties.getValue(request,"label.common.Expiry"));
				sb.append("</td><td width='10%' class='multiRPTLabel' >"+HisLanguageProperties.getValue(request,"label.common.Order_qty" ));
				sb.append("</td><td width='15%' class='multiRPTLabel' >"+HisLanguageProperties.getValue(request,"label.common.Transfer_qty" ));
				sb.append("</td><td width='15%' class='multiRPTLabel' >"+HisLanguageProperties.getValue(request,"label.common.Rec/Bkg_qty" ));
				sb.append("</td></tr>");
				//sb.append("</tbody>");
				sb.append("<tr>");
				sb.append("<td class='multiControl' colspan='7'><font color='red'>"+HisLanguageProperties.getValue(request,"label.common.No_Record_Found" )+"</font></td>");
				sb.append("</tr>");
				sb.append("</thead><tbody>");
				sb.append("</tbody>");
				sb.append("</table>");
			}

		} catch (Exception e) {
			e.printStackTrace();
			new HisException("Transfer Order Details", "TransferDemandReqTransHLP.getTransferOrderDetails()-->", e.getMessage());
		}
		// System.out.println("sb"+sb);
		return sb.toString();
	}

	/**
	 * Gets the prints the screen two.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @return the prints the screen two
	 * @throws Exception the exception
	 */
	public static String getPrintScreenTwo(TransferDemandReqTransFB formBean, HttpServletRequest request) throws Exception {

		StringBuffer sb = new StringBuffer("");
		final int recPerPage = 50;
		final int pagePerBlock = 50;
		WebRowSet ws = null;
		int totalFetchRecord = (recPerPage * pagePerBlock) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;

		new HisUtil("mms", "getPrintScreenTwo");

		String strTableWidth = "700";
		new DecimalFormat("0.00");

		try {
			ws = formBean.getWbTransferOrderDetail();
			if (ws != null && ws.size() > 0) {
				int actualFetchRecord = ws.size();

				if (totalFetchRecord != actualFetchRecord) {
					totalFetchRecord = actualFetchRecord;
					totalRecordsToManipulate = actualFetchRecord;
				}
				int totalLayer = totalRecordsToManipulate / recPerPage;
				int reminder = totalRecordsToManipulate % recPerPage;
				if (reminder > 0) {
					totalLayer = totalLayer + 1;
				}

				sb.append("<input type='hidden' name='TotalLayer'  value='").append(totalLayer).append("'>");
				sb.append("<input type='hidden' name='RecordShowOnPage'  value='").append(recPerPage).append("'>");
				sb.append("<td width='50%' align='center'> <b> ");
				sb.append("<table align='center' width='").append(strTableWidth)
						.append("' border='0' cellspacing='0' cellpadding='0' height='69' style='border-collapse: collapse;'> ");
				sb.append("<tr>");
				sb.append("<td colspan='8' width='10%' align='center'><div  align='center'> <img align ='absmiddle' src='http://" + request.getServerName() + ":"
						+ request.getServerPort() + HisLanguageProperties.getValue(request,"imageHeader.common.VoucherReport")+"'/></div></td> ");
				sb.append("<td width='80%' colspan='3' align='center' style='font-family:Verdana,Arial,Helvetica,sans-serif;font-size:12px;'><b>");
				
				sb.append("</td> ");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td width='10%' colspan='2'></td> ");
				sb.append("<td width='80%' colspan='3' align='center' style='font-family:Verdana,Arial,Helvetica,sans-serif;font-size:12px;'><b>");
				sb.append(HisLanguageProperties.getValue(request,"label.common.Transfer_Demand_Request(Short)"));
				sb.append("</font></b></td><td width='10%' colspan='1'></td> ");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td width='10%' colspan='2'></td> ");
				sb.append(
						"<td width='80%' colspan='3' align='center' style='font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 12px;'> <b>")
						.append(formBean.getStrStoreName());
				sb.append("</font></b></td><td width='10%' colspan='1'></td> ");
				sb.append("</tr>");
				sb.append("</table> ");

				sb.append("<table border='0' width='").append(strTableWidth).append("' align='center' style='border-collapse: collapse;'> ");
				sb.append("<tr> ");
				sb.append("<td align='right'>");
//				sb.append("<div id='saveId' style='display:block'><div id='printid1' class='hidecontrol' align='right'>");
//				sb.append("<div id='printImg0' class='printImg'><img style='cursor: pointer; ' title='Print Page'  ");
//				sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(2);' /> "
//						+ "<img style='cursor: pointer; ' title='Save as Pdf' src='../../hisglobal/images/pdf.png' "
//						+ "onClick='generatePdf(\"transferPrintDtlsDiv\", \"strDrugName\", \"strDrugTdId\");' /> "
//						+ "<img style='cursor: pointer; ' title='Save as Excel' src='../../hisglobal/images/excel1.png'"
//						+ " onClick='generateXLS(event,\"transferPrintDtlsDiv\");' /> <img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(1);' />");
//				sb.append("</div></div></div></td> ");
				
				sb.append("<div id='saveId' style='display:block'><div id='printid1' class='hidecontrol' align='right'>");
				sb.append("<div id='printImg0' class='printImg'><img style='cursor: pointer; ' title='Print Page'  ");
				sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(2);' /> "
						+ "<img style='cursor: pointer; ' title='Save as Pdf' src='../../hisglobal/images/pdf.png' "
						+ "onClick='generatePdf(\"transferPrintDtlsDiv\", \"strDrugName\", \"strDrugTdId\");' /> "
						+ "<img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(1);' />");
				sb.append("</div></div></div></td> ");
				sb.append(" </tr> ");
				sb.append(" </table> ");
				sb.append(" <br> ");
				sb.append("<table width='").append(strTableWidth)
						.append("' align='center' cellpadding='1px' cellspacing='0px' style='border-collapse: collapse;'> ");
				sb.append("<tr>");
				sb.append(
						"<td align='right' width='25%' class='LABEL' style='font-weight:bold; font-size:11px;'>"+HisLanguageProperties.getValue(request,"label.common.Store_Name" )+":</td>"
								+ "<td width='25%' class='CONTROL' style='font-weight:normal; font-size:12px;'>")
						.append(formBean.getStrStoreNameView()).append("</td>");
				sb.append(
						"<td align='right' width='25%' class='LABEL' style='font-weight:bold; font-size:11px;'>"+HisLanguageProperties.getValue(request,"label.common.Request_date" )+":</td>"
								+ "<td width='25%' class='CONTROL' style='font-weight:normal; font-size:12px;'>")
						.append(formBean.getStrRequestDateView()).append("</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append(
						"<td align='right' class='LABEL' style='font-weight:bold; font-size:11px;'>"+HisLanguageProperties.getValue(request,"label.common.Group_Name" )+":</td>"
								+ "<td class='CONTROL' style='font-weight:normal; font-size:12px;'>").append(formBean.getStrGroupNameView())
						.append("</td>");
				sb.append(
						"<td align='right' class='LABEL' style='font-weight:bold; font-size:11px;'>"+HisLanguageProperties.getValue(request,"label.common.Sub_Group_Name" )+":</td>"
								+ "<td class='CONTROL' style='font-weight:normal; font-size:12px;'>").append(formBean.getStrSubGroupNameView())
						.append("</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append(
						"<td align='right' class='LABEL' style='font-weight:bold; font-size:11px;' >"+HisLanguageProperties.getValue(request,"label.common.Drug_Name" )+":</td>"
								+ "<td class='CONTROL' colspan='3' style='font-weight:normal; font-size:12px;'>")
						.append(formBean.getStrItemNameView()).append("</td>");
				sb.append("</tr>");				
				sb.append("<tr>");
				sb.append(
						"<td align='right' class='LABEL' style='font-weight:bold; font-size:11px;'>"+HisLanguageProperties.getValue(request,"label.common.Demanded_qty" )+":</td>"
								+ "<td class='CONTROL' style='font-weight:normal; font-size:12px;'>").append(formBean.getStrReqQtyWithUnitView())
						.append("</td>");
				sb.append(
						"<td align='right' class='LABEL' style='font-weight:bold; font-size:11px;'></td>"
								+ "<td class='CONTROL' style='font-weight:normal; font-size:12px;'></td>");
				sb.append("</tr>");				
				sb.append(" </table> ");

				sb.append("<table width='").append(strTableWidth)
						.append("' align='center' border='1px' style='border-collapse: collapse;' cellpadding='1px' cellspacing='0px'> ");
				sb.append("<tbody style='display:table-row-group;'>");
				sb.append("<tr style='background-color:#cdc9c9'> ");
				
				sb.append("<td align='center' width='15%' style='font-family:Verdana,Arial,Helvetica,sans-serif;font-size:11px;'><b>"+HisLanguageProperties.getValue(request,"label.common.Order_no" )+"</b>");
				sb.append("</td>");
				sb.append("<td align='center' width='15%' style='font-family:Verdana,Arial,Helvetica,sans-serif;font-size:11px;'><b>"+HisLanguageProperties.getValue(request,"label.common.Order_date" )+"</b> ");
				sb.append("</td> ");
				sb.append("<td align='center' width='20%' style='font-family:Verdana,Arial,Helvetica,sans-serif;font-size:11px;'><b>"+HisLanguageProperties.getValue(request,"label.common.Order_to" )+"</b>");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='10%' style='font-family:Verdana,Arial,Helvetica,sans-serif;font-size:11px;'><b>"+HisLanguageProperties.getValue(request,"label.common.Batch" )+"</b> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='10%' style='font-family:Verdana,Arial,Helvetica,sans-serif;font-size:11px;'><b>"+HisLanguageProperties.getValue(request,"label.common.Expiry" )+"</b> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='10%' style='font-family:Verdana,Arial,Helvetica,sans-serif;font-size:11px;'><b>"+HisLanguageProperties.getValue(request,"label.common.Order_qty" )+"</b> ");
				sb.append("</td> ");
				sb.append("<td align='center' width='10%' style='font-family:Verdana,Arial,Helvetica,sans-serif;font-size:11px;'><b>"+HisLanguageProperties.getValue(request,"label.common.Transfer_qty" )+"</b> ");
				sb.append("</b></td> ");
				sb.append("<td align='center' width='10%' style='font-family:Verdana,Arial,Helvetica,sans-serif;font-size:11px;'><b>");
				sb.append(""+HisLanguageProperties.getValue(request,"label.common.Ack/bkg_qty" )+"</b></td> ");
				sb.append("</tr> ");
				sb.append("</tbody>");

				for (int i = 1; i <= totalLayer; i++) {
					if (i <= totalLayer) {

						if (i == 1) {
							sb.append("<tbody id='DivId").append(i).append("' style='display:table-row-group;' width='").append(strTableWidth)
									.append("'>");
						} else {
							sb.append("<tbody id='DivId").append(i).append("' style='display:none' width='").append(strTableWidth).append("'>");
						}

						for (int j = 0; j < recPerPage; j++) {
							/*
							 * 1- Order No 2- Order Date 3- Demand Store Name 4- Order Qty with Unit Size 5- Transfer Qty with Unit Size 6- Ack Qty
							 * with Unit Size 7-Hidden Value ReqNo||'^'||Transfer Store ID||'^'||Transfer Req No||'^'||Transfer Date ||'^'||Transfer
							 * remarks||'^'||Ack Date||'^'||ACK_REMARKS||'^'||STATUS||'^'||Demand Store ID ] 8-Expiry Date , 9-Batch No
							 */
							if (ws.next()) {
								sb.append("<tr>");
								sb.append("<td width='15%' class='multiPOControl' style='font-weight:normal; font-size:11px;'>");
								sb.append(ws.getString(1));
								sb.append("</td><td width='15%' class='multiPOControl' style='font-weight:normal; font-size:11px;'>");
								sb.append(ws.getString(2));
								sb.append("</td><td width='20%' class='multiPOControl' style='font-weight:normal; font-size:11px;text-align:left;' >");
								sb.append(ws.getString(3));
								sb.append("</td>");
								
								sb.append("<td width='10%' class='multiPOControl' style='font-weight:normal; font-size:11px;'>");
								sb.append(ws.getString(9));
								sb.append("</td>");
								sb.append("<td width='10%' class='multiPOControl' style='font-weight:normal; font-size:11px;'>");
								sb.append(ws.getString(8));
								sb.append("</td>");
								
								sb.append("<td width='10%' class='multiPOControl' style='font-weight:normal; font-size:11px;'>");
								sb.append(ws.getString(4));
								sb.append("</td>");
								sb.append("<td width='10%' class='multiPOControl' style='font-weight:normal; font-size:11px;'>");
								sb.append(ws.getString(5));
								sb.append("</td><td width='10%' class='multiPOControl' style='font-weight:normal; font-size:11px;'>");
								sb.append(ws.getString(6));
								sb.append("</td></tr>");
							} else {
								break;
							}
						}
						sb.append("</tbody>");

					} else {
						sb.append("<tbody id='DivId").append(i).append("' style='display:none'>");
						for (int k = 0; k < reminder; k++) {
							ws.next();
							sb.append("<tr>");
							sb.append("<td width='15%' class='multiPOControl' style='font-weight:normal; font-size:11px;'>");
							sb.append(ws.getString(1));
							sb.append("</td><td width='15%' class='multiPOControl' style='font-weight:normal; font-size:11px;'>");
							sb.append(ws.getString(2));
							sb.append("</td><td width='20%' class='multiPOControl' style='font-weight:normal; font-size:11px;text-align:left;' >");
							sb.append(ws.getString(3));
							sb.append("</td>");
							
							sb.append("<td width='10%' class='multiPOControl' style='font-weight:normal; font-size:11px;'>");
							sb.append(ws.getString(9));
							sb.append("</td>");
							sb.append("<td width='10%' class='multiPOControl' style='font-weight:normal; font-size:11px;'>");
							sb.append(ws.getString(8));
							sb.append("</td>");
							
							sb.append("<td width='10%' class='multiPOControl' style='font-weight:normal; font-size:11px;'>");
							sb.append(ws.getString(4));
							sb.append("</td>");
							sb.append("<td width='10%' class='multiPOControl' style='font-weight:normal; font-size:11px;'>");
							sb.append(ws.getString(5));
							sb.append("</td><td width='10%' class='multiPOControl' style='font-weight:normal; font-size:11px;'>");
							sb.append(ws.getString(6));
							sb.append("</td></tr>");

						}
						sb.append("</tbody>");
					}
				}
				sb.append("</td>");
				sb.append("</tr>");
				sb.append("</table>");
			} else {
				sb.append("<table align='center' width='").append(strTableWidth)
						.append("' border='0' cellspacing='0' cellpadding='0' height='69' style='border-collapse: collapse;'> ");
				sb.append("<tr>");
				sb.append("<td colspan='3' width='10%' align='right'><div  align='right'> <img src='http://" + request.getServerName() + ":"
						+ request.getServerPort() + HisLanguageProperties.getValue(request,"imageHeader.common.VoucherReport" )+"'/></div></td> ");
				sb.append("<td width='80%' colspan='3' align='center' style='font-family:Verdana,Arial,Helvetica,sans-serif;font-size:12px;'><b>");
				
				sb.append("</b></td> <td width='10%' colspan='1'></td> ");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td width='10%' colspan='2'></td> ");
				sb.append("<td width='80%' colspan='3' align='center' style='font-family:Verdana,Arial,Helvetica,sans-serif;font-size:12px;'><b>");
				sb.append(HisLanguageProperties.getValue(request,"label.common.Transfer_Demand_Request(Short)"));
				sb.append("</b></td><td width='10%' colspan='1'></td> ");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td width='10%' colspan='2'></td> ");
				sb.append(
						"<td width='80%' colspan='3' align='center' style='font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 12px;'> <b>")
						.append(formBean.getStrStoreName());
				sb.append("</b></td><td width='10%' colspan='1'></td> ");
				sb.append("</tr>");
				sb.append("</table> ");
				sb.append("<table border='0' width='").append(strTableWidth).append("' align='center' style='border-collapse: collapse;'> ");
				sb.append("<tr> ");
				sb.append("<td align='right'>");
				sb.append("<div id='saveId' style='display:block'><div id='printid1' class='hidecontrol' align='right'>");
				sb.append("<div id='printImg0' class='printImg'><img style='cursor: pointer; ' title='Print Page'  ");
				sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(1);' /> "
						+ "<img style='cursor: pointer; ' title='Save as Pdf' src='../../hisglobal/images/pdf.png' "
						+ "onClick='generatePdf(\"transferPrintDtlsDivId\");' /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(1);' />");
				sb.append("</div></div></div></td> ");
				sb.append(" </tr> ");
				sb.append(" </table> ");

				sb.append("<table width='").append(strTableWidth)
						.append("' align='center' cellpadding='1px' cellspacing='0px' style='border-collapse: collapse;'> ");
				sb.append("<tr>");
				sb.append(
						"<td align='right' width='25%' class='LABEL' style='font-weight:bold; font-size:11px;'>"+HisLanguageProperties.getValue(request,"label.common.Store_Name" )+":</td>"
								+ "<td width='25%' class='CONTROL' style='font-weight:normal; font-size:12px;'>")
						.append(formBean.getStrStoreNameView()).append("</td>");
				sb.append(
						"<td align='right' width='25%' class='LABEL' style='font-weight:bold; font-size:11px;'>"+HisLanguageProperties.getValue(request,"label.common.Request_date" )+":</td>"
								+ "<td width='25%' class='CONTROL' style='font-weight:normal; font-size:12px;'>")
						.append(formBean.getStrRequestDateView()).append("</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append(
						"<td align='right' class='LABEL' style='font-weight:bold; font-size:11px;'>"+HisLanguageProperties.getValue(request,"label.common.Group_Name" )+":</td>"
								+ "<td class='CONTROL' style='font-weight:normal; font-size:12px;'>").append(formBean.getStrGroupNameView())
						.append("</td>");
				sb.append(
						"<td align='right' class='LABEL' style='font-weight:bold; font-size:11px;'>"+HisLanguageProperties.getValue(request,"label.common.Sub_Group_Name" )+":</td>"
								+ "<td class='CONTROL' style='font-weight:normal; font-size:12px;'>").append(formBean.getStrSubGroupNameView())
						.append("</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append(
						"<td align='right' class='LABEL' style='font-weight:bold; font-size:11px;'>"+HisLanguageProperties.getValue(request,"label.common.Drug_Name" )+":</td>"
								+ "<td class='CONTROL' style='font-weight:normal; font-size:12px;' colspan='3'>")
						.append(formBean.getStrItemNameView()).append("</td>");
				sb.append("</tr>");				
				sb.append("<tr>");
				sb.append(
						"<td align='right' class='LABEL' style='font-weight:bold; font-size:11px;'>"+HisLanguageProperties.getValue(request,"label.common.Demanded_qty" )+":</td>"
								+ "<td class='CONTROL' style='font-weight:normal; font-size:12px;'>").append(formBean.getStrReqQtyWithUnitView())
						.append("</td>");
				sb.append(
						"<td align='right' class='LABEL' style='font-weight:bold; font-size:11px;'></td>"
								+ "<td class='CONTROL' style='font-weight:normal; font-size:12px;'></td>");
				sb.append("</tr>");				
				sb.append(" </table> ");
				sb.append(" <br> ");

				sb.append("<table width='").append(strTableWidth)
						.append("' align='center' border='1px' cellpadding='1px' cellspacing='0px' style='border-collapse: collapse;'> ");
				sb.append("<tr style='background-color:#cdc9c9'> ");
				
				sb.append("<td align='center' width='25%' style='font-family:Verdana,Arial,Helvetica,sans-serif;font-size:11px;'><b>"+HisLanguageProperties.getValue(request,"label.common.Order_no" )+"</b>");
				sb.append("</td>");
				sb.append("<td align='center' width='20%' style='font-family:Verdana,Arial,Helvetica,sans-serif;font-size:11px;'><b>"+HisLanguageProperties.getValue(request,"label.common.Order_date" )+"</b>");
				sb.append("</td> ");
				sb.append("<td align='center' width='20%' style='font-family:Verdana,Arial,Helvetica,sans-serif;font-size:11px;'><b>"+HisLanguageProperties.getValue(request,"label.common.Order_to" )+"</b>");
				sb.append("</td> ");
				sb.append("<td align='center' width='10%' style='font-family:Verdana,Arial,Helvetica,sans-serif;font-size:11px;'><b>"+HisLanguageProperties.getValue(request,"label.common.Order_qty" )+"</b>");
				sb.append("</td> ");
				sb.append("<td align='center' width='10%' style='font-family:Verdana,Arial,Helvetica,sans-serif;font-size:11px;'>");
				sb.append("<b>Transfer Qty.</b></td> ");
				sb.append("<td align='center' width='15%' style='font-family:Verdana, Arial, Helvetica, sans-serif; font-size:11px;'>");
				sb.append("<b>Ack/Bkg Qty.</b></td> ");
				sb.append("</tr> ");
				sb.append("<tr>");
				sb.append("<td align='center' colspan='6' class='multiLabel' style='color:red;font-family:Verdana,Arial,Helvetica,sans-serif;"
						+ "font-size:11px;'>No Record Found</td>");
				sb.append("</tr>");
				sb.append("</table>");
			}

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}

		return sb.toString();
	}

	/**
	 * Gets the transfer details print screen.
	 * 
	 * @param formBean the form bean
	 * @return the transfer details print screen
	 */
	public static String getTransferDetailsPrintScreen(TransferDemandReqTransFB formBean) {

		StringBuffer sb = new StringBuffer("");
		int count = 0;
		WebRowSet ws = null;
		String strTableWidth = "700";
		try {

			ws = formBean.getWbTransferOrderDetail();
			sb.append("<table width='").append(strTableWidth)
					.append("' align='center' border='1px' cellpadding='1px' cellspacing='0px' style='border-collapse: collapse;'> ");
			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td width='20%' style='font-family:Verdana, Arial, Helvetica, sans-serif; font-size:11px;'><b>Transfer No.</b>");
			sb.append("</td><td width='20%' style='font-family:Verdana, Arial, Helvetica, sans-serif; font-size:11px;'><b>Transfer Date</b>");
			sb.append("</td><td width='20%' style='font-family:Verdana, Arial, Helvetica, sans-serif; font-size:11px;'><b>Transfer Qty.</b>");
			sb.append("</td><td width='20%' style='font-family:Verdana, Arial, Helvetica, sans-serif; font-size:11px;'><b>Rec/Bkg Qty.</b>");
			sb.append("</td><td width='20%' style='font-family:Verdana, Arial, Helvetica, sans-serif; font-size:11px;'><b>Received Date</b>");
			sb.append("</td></tr>");

			if (ws != null && ws.size() != 0) {
				while (ws.next()) {
					String transNo = (ws.getString(1) == null || ws.getString(1).equals("")) ? "0" : ws.getString(1);
					String transDate = (ws.getString(2) == null || ws.getString(2).equals("")) ? "NA" : ws.getString(2);

					sb.append("<input type='hidden' name='strTransferNo' id='strTransferNo" + count + "' value='" + transNo + "'>");
					sb.append("<input type='hidden' name='strTransferStoreId' id='strTransferStoreId" + count + "' value='" + ws.getString(6) + "'>");
					sb.append("<tr>");
					sb.append("<td width='20%' id='strDrugTdId" + count
							+ "' style='font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 11px;'>");
					sb.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strDrugName' id='strDrugName" + count
							+ "' onClick='drugDtl(this,\"" + count + "\", \"2\");'>" + transNo + "</a>");
					sb.append("<div class='popup' id='drugDtlPrintId" + count + "");
					sb.append("' style='display:none'>");
					sb.append("</div>");
					sb.append("</td><td width='20%' style='font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 11px;'>");
					sb.append(transDate);
					sb.append("</td><td width='20%' style='font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 11px;'>");
					sb.append(ws.getString(3));
					sb.append("</td><td width='20%' style='font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 11px;'>");
					sb.append(ws.getString(5));
					sb.append("</td><td width='20%' style='font-family: Verdana, Arial, Helvetica, sans-serif;font-size: 11px;'>");
					if (ws.getString(4) != "" || !ws.getString(4).equals("")) {
						sb.append(ws.getString(4));
					} else {
						sb.append("NA");
					}
					sb.append("</b></font></td></tr>");
					count++;
				}

			} else {

				sb.append("<tr > ");
				sb.append("<td colspan='5' class='multiControl' style='font-family: Verdana, Arial, Helvetica, sans-serif;"
						+ "font-size: 12px;'><font color='red'>No Record Found</td>");
				sb.append("</tr>");
			}
			sb.append("</table>");

		} catch (Exception e) {
			e.printStackTrace();
			new HisException("Transfer Order Details", "TransferDemandReqTransHLP.getTransferDetailsPrintScreen()-->", e.getMessage());
		}
		// System.out.println("sb"+sb);
		return sb.toString();
	}

}
