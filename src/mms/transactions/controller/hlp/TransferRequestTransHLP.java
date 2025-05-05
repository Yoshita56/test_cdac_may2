/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         TransferApprovalTransHLP.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.hlp;

import java.text.DecimalFormat;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;

import hisglobal.utility.HisUtil;
import mms.transactions.controller.fb.TransferRequestTransFB;

/**
 * The Class TransferRequestTransHLP.
 */
public class TransferRequestTransHLP {

	/**
	 * Gets the drug batch details.
	 * 
	 * @param wb the wb
	 * @param formBean the form bean
	 * @param index the index
	 * @return the drug batch details
	 */
	public static String getDrugBatchDetails(WebRowSet wb, TransferRequestTransFB formBean, String index) {
		StringBuffer br = new StringBuffer("");
		String strApplyClass ="";
		try {
			br.append("<div class='line'><table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='0px' >");
			br.append("<tr>");
			br.append("<td colspan='5'>Batch Detail(s)</td>");
			br.append("</tr> </table> </div>");
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='0px' cellpadding='1px'>");
			br.append("<tr>");
			br.append("<td colspan='1' class='multiRPTLabel'>Batch No.</td>");
			br.append("<td colspan='1' class='multiRPTLabel'>Available Qty.</td>");
			br.append("<td colspan='1' class='multiRPTLabel'>Exp. Date</td>");
			br.append("<td colspan='1' class='multiRPTLabel'>Mfg Date</td>");
			br.append("<td colspan='1' class='multiRPTLabel'>Excess Qty.</td>");
			br.append("</tr>");

			if (wb.size() != 0) 
			{

				int nTmpI = 0;
				String hiddenValue = "";
				
				/*1.Drug Name
			     *2.Batch No
			     *3.Avl Qty
			     *4.Expiry Date
			     *5.Unit Name
			     *6.Manufactrer Name
			     *7.In Hand Qty Unit Id
			     *8.Avl Excess Qty
			     *9. Primary Key        
			     * */
				
				while (wb.next()) 
				{				
					
					if(wb.getString(8).equals("1")) 
					{
						strApplyClass = "Excess";						
					} 
					else 
					{
						strApplyClass = "multiPOControl";
						
					}
					
					hiddenValue =
							wb.getString(1) + "^" + wb.getString(2) + "^" + wb.getString(3) + "^" + wb.getString(4) + "^" + wb.getString(5) + "^"
									+ wb.getString(6) + "^" + wb.getString(7) + "^" + wb.getString(9);
					br.append("<tr>");
					br.append("<input type='hidden' name='strBatchHiddenValue' id='strBatchHiddenValue" + nTmpI + "' value='" + hiddenValue + "'>");
					br.append("<td colspan='1'       class='" + strApplyClass + "' style='text-align:left;'>");
					br.append(wb.getString(2));
					br.append("</td><td  colspan='1' class='" + strApplyClass + "' style='text-align:right;' >");
					br.append(wb.getString(3) + "  " + wb.getString(5));
					br.append("</td><td  colspan='1' class='" + strApplyClass + "'>");
					br.append(wb.getString(4));
					br.append("</td><td  colspan='1' class='" + strApplyClass + "'>");
					br.append(wb.getString(6));
					br.append("</td><td  colspan='1' class='" + strApplyClass + "'>");
					if(wb.getString(8).equals("0"))
					{
						br.append("<input type='text'	name='strExcessQty' maxlength='7' class='txtFldMin' onblur='checkExcessValue(this," + nTmpI
							+ ")'  onkeypress='return validateData(event,5);' />");
					}
					else
					{
						br.append("---<input type='hidden'	name='strExcessQty' maxlength='7' class='txtFldMin' readonly onkeypress='return validateData(event,5);' />");
					}
					br.append("</td>");
					br.append("</tr>");
					nTmpI++;
				}
				br.append("<tr class='FOOTER'>");
				br.append("<th align='right' colspan=5></th>");
				br.append("</tr>");

			} else {
				br.append("<tr>");
				br.append("<td colspan='5'  CLASS='multiControl' ><DIV class='errMsg' align='center'> "
						+ "NO RECORD FOUND FOR SELECTED TRANSFER NO </div></TD>");
				br.append("</tr>");
			}
			br.append("</table>");

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			formBean.setStrMsgString("TransferRequestTransHLP.getDrugBatchDetails() --> " + e.getMessage());
			formBean.setStrMsgType("1");
		}
		return br.toString();
	}

	/**
	 * Gets the drug details.
	 * 
	 * @param wb the wb
	 * @param formBean the form bean
	 * @param request the request
	 * @return the drug details
	 */
	public static String getDrugDetails(WebRowSet wb, TransferRequestTransFB formBean, HttpServletRequest request) {
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

			br.append("<table width='400' border='0' bgcolor='#CC9966' cellspacing ='0' cellpGenerateing='1' >");
			br.append("<tr class='HEADER'>");
			br.append("<th align='right' colspan=4><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp Window'"
					+ " src='../../hisglobal/images/stop.png'");
			br.append("onClick='hideDrugDetails(\"" + drugDtlDivId + "\",\"" + index + "\");'></th>");
			br.append("</tr>");
			br.append("</table>");
			br.append("<table width='400' style='border-collapse: collapse;' border='0' cellspacing='0' cellpadding='1'>");
			br.append("<tr>");
			br.append("<td colspan='1' class='multiRPTLabel'>Batch No.</td>");
			br.append("<td colspan='1' class='multiRPTLabel'>Exp. Date</td>");
			br.append("<td colspan='1' class='multiRPTLabel'>Transfer Qty.</td>");
			br.append("<td colspan='1' class='multiRPTLabel'>Rec/Bkg Qty.</td>");
			br.append("</tr>");

			if (wb.size() != 0) {
				while (wb.next()) {
					br.append("<tr>");
					br.append("<td       colspan='1' class='multiPOControl'>");
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

			} else {
				br.append("<tr>");
				br.append("<td colspan='4'  CLASS='multiControl' ><DIV class='errMsg' align='center'>"
						+ " NO RECORD FOUND FOR SELECTED TRANSFER NO </div></TD>");
				br.append("</tr>");
			}
			br.append("</table>");

		} catch (Exception e) {
			formBean.setStrMsgString("TransferRequestTransHLP.getDrugDetails() --> " + e.getMessage());
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
	public static String getTransferDetails(TransferRequestTransFB formBean,HttpServletRequest request) {
		StringBuffer sb = new StringBuffer("");
		int count = 0;
		WebRowSet ws = null;

		try {

			ws = formBean.getWbTransferOrderDetail();

			sb.append("<table id='mainTableRptId' class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='0px' >");
			sb.append("<thead><tr>");
			sb.append("<tr id='tableHeaderId'>");
			//sb.append("<tr>");
			sb.append("<td>Transfer No");
			sb.append("</td><td>Transfer Date");
			sb.append("</td><td>Transfer Qty");
			sb.append("</td><td>Rec/Bkg Qty");
			sb.append("</td><td>Received  Date");
			sb.append("</td></tr>");
			sb.append("</thead><tbody>");
			if (ws != null && ws.size() != 0) {
				while (ws.next()) {
					String transNo = (ws.getString(1) == null || ws.getString(1).equals("")) ? "0" : ws.getString(1);
					String transDate = (ws.getString(2) == null || ws.getString(2).equals("")) ? "NA" : ws.getString(2);

					sb.append("<input type='hidden' name='strTransferNo' id='strTransferNo" + count + "' value='" + transNo + "'>");
					sb.append("<input type='hidden' name='strTransferStoreId' id='strTransferStoreId" + count + "' value='" + ws.getString(6) + "'>");
					sb.append("<tr>");
					sb.append("<td>");
					
					
				
					
					sb.append( transNo + " &nbsp;");
					
				
					sb.append("</td><td>");
					sb.append(transDate);
					sb.append("</td><td>");
					sb.append(ws.getString(3));
					sb.append("</td><td>");
					sb.append(ws.getString(5));
					sb.append("</td><td>");
					if (ws.getString(4) != "" || !ws.getString(4).equals("")) {
						sb.append(ws.getString(4));
					} else {
						sb.append("NA");
					}
					sb.append("</td></tr>");
					count++;
				}

			} else {
				sb.append("<tr>");
				sb.append("<td colspan='5' class='multiControl'><font color='red'>No Record Found</font></td>");
				sb.append("</tr>");
			}
			sb.append("</tbody>");
			sb.append("</table>");

		} catch (Exception e) {
			e.printStackTrace();
			new HisException("Transfer Order Details", "TransferRequestTransHLP.getTransferOrderDetails()-->", e.getMessage());
		}
		// System.out.println("sb"+sb);
		return sb.toString();
	}

	/**
	 * Gets the transfer order details.
	 * 
	 * @param formBean the form bean
	 * @return the transfer order details
	 */
	public static String getTransferOrderDetails(TransferRequestTransFB formBean,HttpServletRequest request) 
	{
		StringBuffer sb = new StringBuffer("");		
		WebRowSet ws = null;
		
		try {

			ws = formBean.getWbTransferOrderDetail();

			if (ws != null && ws.size() != 0) 
			{							
				sb.append("<table id='mainTableRptId' class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='0px' >");
			//	sb.append("<tbody style='display:table-row-group;'><tr>");	
				sb.append("<thead><tr>");
				sb.append("<tr id='tableHeaderId'>");
				sb.append("<td width='20%' class='multiRPTLabel'>Order No");
				sb.append("</td><td width='20%' class='multiRPTLabel'>Order Date");
				sb.append("</td><td width='20%' class='multiRPTLabel'>Order For");
				sb.append("</td><td width='10%' class='multiRPTLabel'>Order Qty");
				sb.append("</td><td width='15%' class='multiRPTLabel'>Transfer Qty");
				sb.append("</td><td width='15%' class='multiRPTLabel'>Ack/bkg_qty");
				sb.append("</td></tr>");
				//sb.append("</tbody>");
				sb.append("</thead><tbody>");

				
				/*
				 * 1- Order No 2- Order Date 3- Demand Store Name 4- Order Qty with Unit Size 5- Transfer Qty with Unit Size 6- Ack Qty
				 * with Unit Size 7-Hidden Value ReqNo||'^'||Transfer Store ID||'^'||Transfer Req No||'^'||Transfer Date ||'^'||Transfer
				 * remarks||'^'||Ack Date||'^'||ACK_REMARKS||'^'||STATUS||'^'||Demand Store ID
				 */
				while(ws.next()) 
				{
					sb.append("<tr>");					
					sb.append("<td width='20%' class='multiPOControl'>");
					sb.append(ws.getString(1));
					sb.append("</td><td width='20%' class='multiPOControl'>");
					sb.append(ws.getString(2));
					sb.append("</td><td width='20%' class='multiPOControl'>");
					sb.append(ws.getString(3));
					sb.append("</td><td width='10%' class='multiPOControl'>");
					sb.append(ws.getString(4));
					sb.append("</td><td width='15%' class='multiPOControl'>");
					sb.append(ws.getString(5));
					sb.append("</td><td width='15%' class='multiPOControl'>");
					sb.append(ws.getString(6));
					sb.append("</td></tr>");
				
			        sb.append("</tbody>");
		       }
				
				sb.append("</td>");
				sb.append("</tr>");
				sb.append("</tbody>");
				sb.append("</table>");
			} else {
				sb.append("<table id='mainTableRptId' class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='0px'>");
				sb.append("<tr>");
				sb.append("<thead><tr>");
				sb.append("<tr id='tableHeaderId'>");
				sb.append("<td width='20%' class='multiRPTLabel'>Order No");
				sb.append("</td><td width='20%' class='multiRPTLabel'>Order Date");
				sb.append("</td><td width='20%' class='multiRPTLabel'>Order For");
				sb.append("</td><td width='10%' class='multiRPTLabel'>Order Qty");
				sb.append("</td><td width='15%' class='multiRPTLabel'>Transfer Qty");
				sb.append("</td><td width='15%' class='multiRPTLabel'>Ack/bkg_qty");
				sb.append("</td></tr>");
				sb.append("<td class='multiControl' colspan='6'><font color='red'>No Order Found</font></td>");
				sb.append("</tr>");
				sb.append("</thead><tbody>");
				sb.append("</tbody>");
				sb.append("</table>");

			}

		} catch (Exception e) {
			e.printStackTrace();
			new HisException("Transfer Order Details", "TransferRequestTransHLP.getTransferOrderDetails()-->", e.getMessage());
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
	public static String getPrintScreenTwo(TransferRequestTransFB formBean, HttpServletRequest request) throws Exception {

		StringBuffer sb = new StringBuffer("");
		final int recPerPage = 50;
		final int pagePerBlock = 50;
		int count = 0;
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
				sb.append("<td width='50%' align='center'>");
				sb.append("<table align='center' width='").append(strTableWidth)
						.append("' border='0' cellspacing='0' cellpadding='0' height='69' style='border-collapse: collapse;'> ");

				sb.append("<tr>");
				sb.append("<td colspan='8' width='10%' align='center'><div  align='center'> <img align='absmiddle' src='http://" + request.getServerName() + ":"
						+ request.getServerPort() +  "Report'/></div></td> ");
				sb.append("<td width='80%' colspan='3' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
				
				sb.append("</td> ");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td width='10%' colspan='2'></td> ");
				sb.append("<td width='80%' colspan='3' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
				sb.append("Transfer Demand Request (Excess)");
				sb.append("</font></b></td><td width='10%' colspan='1'></td> ");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td width='10%' colspan='2'></td> ");
				sb.append("<td width='80%' colspan='3' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>").append(
						formBean.getStrStoreName());
				sb.append("</font></b></td><td width='10%' colspan='1'></td> ");
				sb.append("</tr>");
				sb.append("</table> ");
				sb.append(" <br> ");

				sb.append("<table border='0' width='").append(strTableWidth).append("' align='center' style='border-collapse: collapse;'> ");
				sb.append("<tr> ");
				sb.append("<td align='right'>");
				sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
				sb.append("<div id='printImg0' class='printImg'><img style='cursor: pointer; ' title='Print Page'  ");
				sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(2);' /> "
						+ " <img style='cursor: pointer; ' title='Save as Pdf' src='../../hisglobal/images/pdf.png' "
						+ " onClick='generatePdf(\"transferPrintDtlsDiv\", \"strDrugName\", \"strDrugTdId\");' /> "
						+ " <img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(1);' />");
				sb.append(" </div></div></div></td> ");
				sb.append(" </tr> ");
				sb.append(" </table> ");

				sb.append("<table width='").append(strTableWidth)
						.append("' align='center' cellpadding='1px' cellspacing='0px' style='border-collapse: collapse;'> ");
				sb.append("<tr>");
				sb.append("<td align='right' width='25%' class='LABEL' style='font-weight:bold'>Store Name:</td><td width='25%' class='CONTROL'>")
						.append(formBean.getStrStoreName()).append("</td>");
				sb.append("<td align='right' width='25%' class='LABEL' style='font-weight:bold'>Req Date :</td><td width='25%' class='CONTROL'>")
						.append(formBean.getStrRequestDateView()).append("</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td align='right' class='LABEL' style='font-weight:bold'>Group Name:</td><td class='CONTROL'>")
						.append(formBean.getStrGroupNameView()).append("</td>");
				sb.append("<td align='right' class='LABEL' style='font-weight:bold'>Sub Group Name :</td><td class='CONTROL'>")
						.append(formBean.getStrSubGroupNameView()).append("</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td align='right' class='LABEL' style='font-weight:bold'>Drug Name:</td><td class='CONTROL'>")
						.append(formBean.getStrItemNameView()).append("</td>");
				
				sb.append("<td align='right' class='LABEL' style='font-weight:bold'>Excess Qty:</td><td class='CONTROL'>")
				.append(formBean.getStrReqQtyWithUnitView()).append("</td>");			
				
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td align='right' class='LABEL' style='font-weight:bold'>Batch no:</td><td class='CONTROL'>")
				.append(formBean.getStrBatchNoView()).append("</td>");
				sb.append("<td align='right' class='LABEL' style='font-weight:bold'>Expiry:</td><td class='CONTROL'>")
						.append(formBean.getStrExpDateView()).append("</td>");
				sb.append("</tr>");
				
				sb.append(" </table> ");

				sb.append(" <br> ");
				sb.append("<table width='").append(strTableWidth)
						.append("' align='center' border='1px' cellpadding='1px' cellspacing='0px' style='border-collapse: collapse;'> ");
				sb.append("<tbody style='display:table-row-group;'> ");
				sb.append("<tr style='background-color:#cdc9c9'> ");				
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>Order No</b></font> ");
				sb.append("</td>");
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>Order Date</b></font> ");
				sb.append("</td> ");
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>Order To</b></font> ");
				sb.append("</td> ");
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>Order Qty</b></font> ");
				sb.append("</td> ");
				sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>Transfer Qty</b></font> ");
				sb.append("</td> ");
				sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>Ack/Bkg Qty</b> ");
				sb.append("</font></td> ");
				sb.append("</tr> ");
				sb.append("</tbody>");

				for (int i = 1; i <= totalLayer; i++) {
					if (i <= totalLayer) {

						if (i == 1) {
							sb.append("<tbody id='DivId").append(i).append("' style='display:table-row-group;'>");
						} else {
							sb.append("<tbody id='DivId").append(i).append("' style='display:none'>");
						}

						for (int j = 0; j < recPerPage; j++) {
							/*
							 * 1- Order No 2- Order Date 3- Demand Store Name 4- Order Qty with Unit Size 5- Transfer Qty with Unit Size 6- Ack Qty
							 * with Unit Size 7-Hidden Value ReqNo||'^'||Transfer Store ID||'^'||Transfer Req No||'^'||Transfer Date ||'^'||Transfer
							 * remarks||'^'||Ack Date||'^'||ACK_REMARKS||'^'||STATUS||'^'||Demand Store ID
							 */
							if (ws.next()) {
								sb.append("<tr>");
								sb.append("<td width='20%' align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>");
								sb.append(ws.getString(1));
								sb.append("</font></td><td width='20%' align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>");
								sb.append(ws.getString(2));
								sb.append("</font></td><td width='20%' align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>");
								sb.append(ws.getString(3));
								sb.append("</font></td><td width='10%' align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>");
								sb.append(ws.getString(4));
								sb.append("</font></td><td width='15%' align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>");
								sb.append(ws.getString(5));
								sb.append("</font></td><td width='15%' align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>");
								sb.append(ws.getString(6));
								sb.append("</font></td></tr>");
							} else {
								break;
							}
							count++;
						}
						sb.append("</tbody>");

					} else {
						sb.append("<tbody id='DivId").append(i).append("' style='display:none'>");

						for (int k = 0; k < reminder; k++) {
							ws.next();
							sb.append("<tr>");
							sb.append("<td width='5%' >");
							sb.append("<input type='hidden' name='strHiddenValue' id='strHiddenValue" + count + "' value='" + ws.getString(7) + "'>");
							sb.append("<input type='radio' name='strDOrderNo' onclick='disOldDatePrint(this," + count + ")' ></td>");
							sb.append("<td width='15%' align='center' ><td width='15%' >"
									+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>");
							sb.append(ws.getString(1));
							sb.append("</font></td><td width='20%' align='center' ><td width='15%' >"
									+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>");
							sb.append(ws.getString(2));
							sb.append("</font></td><td width='20%' align='center' ><td width='15%' >"
									+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>");
							sb.append(ws.getString(3));
							sb.append("</font></td><td width='10%' align='center' ><td width='15%' >"
									+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>");
							sb.append(ws.getString(4));
							sb.append("</font></td><td width='15%' align='center' ><td width='15%' >"
									+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>");
							sb.append(ws.getString(5));
							sb.append("</font></td><td width='15%' align='center' ><td width='15%' >"
									+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>");
							sb.append(ws.getString(6));
							sb.append("</font></td></tr>");
							count++;

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
				sb.append("<td colspan='4' width='10%' align='right'><div  align='right'> <img src='http://" + request.getServerName() + ":"
						+ request.getServerPort() + "VoucherReport'/></div></td> ");
				sb.append("<td width='80%' colspan='3' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
				
				sb.append("</td> ");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td width='10%' colspan='2'></td> ");
				sb.append("<td width='80%' colspan='4' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
				sb.append( "Transfer Demand Request (Excess)");
				sb.append("</font></b></td><td width='10%' colspan='1'></td> ");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td width='10%' colspan='2'></td> ");
				sb.append("<td width='80%' colspan='3' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>").append(
						formBean.getStrStoreName());
				sb.append("</font></b></td><td width='10%' colspan='1'></td> ");
				sb.append("</tr>");
				sb.append("</table><br/> ");

				sb.append("<table border='0' width='").append(strTableWidth).append("' align='center' style='border-collapse: collapse;'> ");
				sb.append("<tr> ");
				sb.append("<td align='right'>");
				sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
				sb.append("<div id='printImg0' class='printImg'><img style='cursor: pointer; ' title='Print Page'  ");
				sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(1);' /> "
						+ " <img style='cursor: pointer; ' title='Save as Pdf' src='../../hisglobal/images/pdf.png' "
						+ " onClick='generatePdf(\"transferPrintDtlsDivId\");' /> <img style='cursor: pointer; ' title='Get Back Report'  ");
				sb.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(1);' />"
						+ "<img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(1);' />");
				sb.append("</div></div></div> </td> ");
				sb.append(" </tr> ");
				sb.append(" </table> ");
				sb.append(" <br> ");

				sb.append("<table width='").append(strTableWidth)
						.append("' align='center' cellpadding='1px' cellspacing='0px' style='border-collapse: collapse;'> ");
				sb.append("<tr>");
				sb.append("<td align='right' width='25%' class='LABEL' style='font-weight:bold'>Store Name:</td><td width='25%' class='CONTROL'>")
						.append(formBean.getStrStoreName()).append("</td>");
				sb.append("<td align='right' width='25%' class='LABEL' style='font-weight:bold'>Req Date:</td><td width='25%' class='CONTROL'>")
						.append(formBean.getStrRequestDateView()).append("</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td align='right' class='LABEL' style='font-weight:bold'>Group Name:</td><td class='CONTROL'>")
						.append(formBean.getStrGroupNameView()).append("</td>");
				sb.append("<td align='right' class='LABEL' style='font-weight:bold'>Sub Group Name:</td><td class='CONTROL'>")
						.append(formBean.getStrSubGroupNameView()).append("</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td align='right' class='LABEL' style='font-weight:bold'>Drug/item_name(s):</td><td class='CONTROL'>")
						.append(formBean.getStrItemNameView()).append("</td>");
				sb.append("<td align='right' class='LABEL' style='font-weight:bold'>Batch:</td><td class='CONTROL'>")
						.append(formBean.getStrBatchNoView()).append("</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td align='right' class='LABEL' style='font-weight:bold'>Mfg Date:</td><td class='CONTROL'>")
						.append(formBean.getStrMfgDateView()).append("</td>");
				sb.append("<td align='right' class='LABEL' style='font-weight:bold'>Expiry:</td><td class='CONTROL'>")
						.append(formBean.getStrExpDateView()).append("</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td align='right' class='LABEL' style='font-weight:bold'>Approved By:</td><td class='CONTROL'>")
						.append(formBean.getStrApprovedByView()).append("</td>");
				sb.append("<td align='right' class='LABEL' style='font-weight:bold'>Approval Date:</td><td class='CONTROL'>")
						.append(formBean.getStrApprovedDateView()).append("</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td align='right' class='LABEL' style='font-weight:bold'>Status:</td><td class='CONTROL' colspan='3'>")
						.append(formBean.getStrApprovedStatusView()).append("</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td align='right' class='LABEL' style='font-weight:bold'>Remarks:</td><td class='CONTROL' colspan='3'>")
						.append(formBean.getStrRaisingRemarksView()).append("</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td align='right' class='LABEL' style='font-weight:bold'>Excess Qty:</td><td class='CONTROL'>")
						.append(formBean.getStrReqQtyWithUnitView()).append("</td>");
				sb.append("<td align='right' class='LABEL' style='font-weight:bold'>Approved Qty:</td><td class='CONTROL'>")
						.append(formBean.getStrApprovedQtyWithUnitView()).append("</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td align='right' class='LABEL' style='font-weight:bold'>Transfer Qty:</td><td class='CONTROL'>")
						.append(formBean.getStrRaisingAvlQtyWithUnitView()).append("</td>");
				sb.append("<td align='right' class='LABEL' style='font-weight:bold'>Ack Qty:</td><td class='CONTROL'>")
						.append(formBean.getStrAckQtyWithUnitView()).append("</td>");
				sb.append("</tr>");
				sb.append(" </table> ");

				sb.append(" <br> ");
				sb.append("<table width='").append(strTableWidth)
						.append("' align='center' border='1px' cellpadding='1px' cellspacing='0px' style='border-collapse: collapse;'> ");
				sb.append("<tr style='background-color:#cdc9c9'> ");
				sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>#</b></font> ");
				sb.append("</td>");
				sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>Order No</b></font> ");
				sb.append("</td>");
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>Order Date</b></font> ");
				sb.append("</td> ");
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>Order To</b></font> ");
				sb.append("</td> ");
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>Order Qty</b></font> ");
				sb.append("</td> ");
				sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>Transfer Qty</b></font> ");
				sb.append("</td> ");
				sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>Ack Qty</b>");
				sb.append("</font> </td> ");
				sb.append("</tr> ");
				sb.append("<tr>");
				sb.append("<td align='center' colspan='7' class='multiLabel' style='color:red;'>No Record Found</td>");
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
	public static String getTransferDetailsPrintScreen(TransferRequestTransFB formBean) {

		StringBuffer sb = new StringBuffer("");
		int count = 0;
		WebRowSet ws = null;
		String strTableWidth = "700";
		try {

			ws = formBean.getWbTransferOrderDetail();

			sb.append("<table width='").append(strTableWidth)
					.append("' align='center' border='1px' cellpadding='1px' cellspacing='0px' style='border-collapse: collapse;'> ");
			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td width='20%' ><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>Transfer No</b></font>");
			sb.append("</td><td width='20%' ><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>Transfer Date</b></font>");
			sb.append("</td><td width='20%' ><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>Transfer Qty.</b></font>");
			sb.append("</td><td width='20%' ><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>Received Qty.</b></font>");
			sb.append("</td><td width='20%' ><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>Received Date</b></font>");
			sb.append("</td></tr>");

			if (ws != null && ws.size() != 0) {
				while (ws.next()) {
					String transNo = (ws.getString(1) == null || ws.getString(1).equals("")) ? "0" : ws.getString(1);
					String transDate = (ws.getString(2) == null || ws.getString(2).equals("")) ? "NA" : ws.getString(2);

					sb.append("<input type='hidden' name='strTransferNo' id='strTransferNo" + count + "' value='" + transNo + "'>");
					sb.append("<input type='hidden' name='strTransferStoreId' id='strTransferStoreId" + count + "' value='" + ws.getString(6) + "'>");
					sb.append("<tr>");
					sb.append("<td width='20%' id='strDrugTdId" + count + "'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>");
					sb.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strDrugName' id='strDrugName" + count
							+ "' onClick='drugDtl(this,\"" + count + "\", \"2\");'>" + transNo + "</a>");
					sb.append("<div class='popup' id='drugDtlPrintId");
					sb.append(count);
					sb.append("' style='display:none'>");
					sb.append("</div>");
					sb.append("</font></td><td width='20%' ><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>");
					sb.append(transDate);
					sb.append("</font></td><td width='20%' ><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>");
					sb.append(ws.getString(3));
					sb.append("</font></td><td width='20%' ><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>");
					sb.append(ws.getString(5));
					sb.append("</font></td><td width='20%' ><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>");
					if (ws.getString(4) != "" || !ws.getString(4).equals("")) {
						sb.append(ws.getString(4));
					} else {
						sb.append("NA");
					}
					sb.append("</font></td></tr>");
					count++;
				}

			} else {

				sb.append("<tr > ");
				sb.append("<td colspan='5' class='multiControl'><font color='red'>No Record Found</font></td>");
				sb.append("</tr>");
			}

			sb.append("</table>");

		} catch (Exception e) {
			e.printStackTrace();
			new HisException("Transfer Order Details", "TransferRequestTransHLP.getTransferOrderDetails()-->", e.getMessage());
		}
		// System.out.println("sb"+sb);
		return sb.toString();
	}

}
