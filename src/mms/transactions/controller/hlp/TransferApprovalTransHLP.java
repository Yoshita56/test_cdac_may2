/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         TransferApprovalTransHLP.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.hlp;


import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import mms.transactions.vo.TransferApprovalTransVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TransferApprovalTransHLP.
 */
public class TransferApprovalTransHLP {

	/**
	 * Gets the demand request details.
	 * 
	 * @param ws the ws
	 * @return the demand request details
	 */
	public static String getDemandRequestDetails(WebRowSet ws, HttpServletRequest request) {
		StringBuffer sb = new StringBuffer("");
		int count = 0;
		String strFontColor = "";

		try {

			if (ws != null && ws.size() != 0) {
				// System.out.println("Hello1");

				sb.append("<div id='transferApproval' style='margin-left:2.5%' class='TABLEWIDTH' ><div id='wrapper' ><table id='mainTableRptId' align='center'cellpadding='1px' cellspacing='0px' bgcolor='#CC9966'>");
				sb.append("<thead><tr id='tableHeaderId'>");
				sb.append("<th width='5%'  >#</td>");
				sb.append("<th width='15%' >Store_Name</td>");
				sb.append("<th width='15%' >Demand_no</td>");
				sb.append("<th width='15%' >Demand_date</td>");
				sb.append("<th width='30%' >Drug/item_name(s)</td>");
				sb.append("<th width='10%' >Requested_qty</td>");
				sb.append("<th width='10%' >In-Hand Qty.</td>");
				sb.append("</tr>");
				sb.append("</thead><tbody>");

				while (ws.next()) {

					/**
					 * 1.DDW_NAME 2.REQUEST_NO 3.REQ_DATE 4.DRUG_NAME 5.REQ_QTY 6.STORE_ID 7.ITEMBRAND_ID 8.REQ_QTY_BASE_VALUE 9.TRANS_REQ_COUNT
					 * 10.AVL_QTY 11.UNIT_NAME 12.HSTNUM_SLNO
					 */

					if (ws.getString(9).equals("0")) {

						strFontColor = "#151AFB";

					} else {
						strFontColor = "#000000";

					}

					if (ws.getString(9).equals("0")) {
						sb.append("<tr >");
						sb.append("<td width='5%' align='center' style='color:" + strFontColor + "'>#</td>");

					} else {
						sb.append("<tr>");
						sb.append("<td width='5%' align='center' style='color:" + strFontColor
								+ "'><input type='radio' onclick='getTransferingDetails(this);' name='strDemandRequest' id='strDemandRequestRadioId"
								+ count + "' value='" + ws.getString(6) + "^" + ws.getString(7) + "^" + ws.getString(8) + "^" + ws.getString(2) + "^"
								+ ws.getString(12) + "'></td>");
					}

					sb.append("</td><td width='15%' style=\"text-align:left;color:" + strFontColor + "\">");
					sb.append(ws.getString(1));
					sb.append("</td><td width='15%' align='center'  style='color:" + strFontColor + "'>");
					sb.append(ws.getString(2));
					sb.append("</td><td width='15%' align='center'  style='color:" + strFontColor + "'>");
					sb.append(ws.getString(3));
					sb.append("</td><td width='30%' style=\"text-align:left;color:" + strFontColor + "\" >");
					sb.append(ws.getString(4));
					sb.append("</td><td width='10%' align='right'  style='color:" + strFontColor + "'>");
					sb.append(ws.getString(5) + " " + ws.getString(11));
					sb.append("</td>");

					sb.append("<td width='10%' align='right' style='color:" + strFontColor + "'>");
					sb.append(ws.getString(10) + " " + ws.getString(11));
					sb.append("</td>" );
					sb.append("<input type='hidden' name='hiddenDrugName' value='"+ws.getString(4)+"'/>");
					sb.append("</tr>");
					
					count++;
					
				}
				sb.append("</tbody>");
				sb.append("</table>");
				sb.append("</div></div>");

			} else {
				sb.append("<div id='transferApproval' style='margin-left:2.5%' class='TABLEWIDTH' ><div id='wrapper' ><table id='mainTableRptId' align='center'cellpadding='1px' cellspacing='0px' bgcolor='#CC9966'>");
				sb.append("<thead><tr id='tableHeaderId'>");
			//	sb.append("<tr id='tableHeaderId'>");
				sb.append("<th width='5%'  >#</td>");
				sb.append("<th width='15%' >Store_Name</td>");
				sb.append("<th width='15%' >Demand_no</td>");
				sb.append("<th width='15%' >Demand_date</td>");
				sb.append("<th width='30%' >Drug/item_name(s)</td>");
				sb.append("<th width='10%' >Requested_qty</td>");
				sb.append("<th width='10%' >In-Hand Qty.</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td colspan='6' align='center'><font color='red'>No_Record_Found</font></td>");
				sb.append("</tr>");
				sb.append("</thead><tbody>");
				sb.append("</tbody>");
				sb.append("</table>");
				sb.append("</div></div>");
			}

		} catch (Exception e) {
			e.printStackTrace();
			new HisException("Transfer Approval Details", "TransferApprovalTransHLP.getDemandRequestDetails()-->", e.getMessage());
		}

		return sb.toString();
	}

	/**
	 * Gets the transfering details.
	 * 
	 * @param ws the ws
	 * @return the transfering details
	 */
	public static String getTransferingDetails(WebRowSet ws,HttpServletRequest request) {
		StringBuffer sb = new StringBuffer("");
		int count = 0;
		String bgClass = "", chkBoxStr = "", odQty = "";
		String strPrimaryKey = "";

		try {

			sb.append("<div class='line'><table>");
			sb.append("<tr >");
			sb.append("<td colspan='8' align='left'>Drug_Store_Transfering_Detail</td>");
			sb.append("</tr></table></div>");

			sb.append("<div id='wrapper1' style='width:95%;margin-left:2.5%;'><table id='mainTableRptId' class='NEWTABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px' bgcolor='#fff'>");
			sb.append("<thead><tr>");
			sb.append("<tr id='tableHeaderId1'>");
			sb.append("<th width='5%' >#</th>");
			sb.append("<th width='25%' >Store Name</th>");
			sb.append("<th width='10%' >Request No</th>");
			sb.append("<th width='10%' >Request Date</th>");
			sb.append("<th width='10%' >Batch</th>");
			sb.append("<th width='10%' >Expiry</th>");
			sb.append("<th width='10%' >Avl Qty</th>");
			sb.append("<th width='10%' >Bal Qty</th>");
			sb.append("<th width='10%' >Order Qty</th>");
			sb.append("</tr>");
			sb.append("</thead><tbody>");
			if (ws != null && ws.size() > 0) {

				while (ws.next()) {

					/**
					 * 1.DDW_NAME 2.REQUEST_NO 3.REQ_DATE 4.BAL_QTY 5.REQ_QTY 6.ORDER_QTY 7.STORE_ID 8.ITEMBRAND_ID 9.BAL_QTY_BASE_VALUE 10.BATCH_NO
					 * 11.EXPIRY_DATE 12.MANUF_DATE 13.UNIT_NAME 14.AVL_QTY 15.SLNO 16.PK
					 */
					strPrimaryKey = ws.getString(16);
					if (Integer.parseInt(ws.getString(14)) == 0) 
					{
						bgClass = "background-color: #faad07;";
						chkBoxStr = "";
						odQty = "--";
						strPrimaryKey = "";
					} 
					else 
					{
						bgClass = "";
						chkBoxStr =
								"<input type='checkbox' name='strTransferingDtls' id='strTransferingDtlsCheckId" + count + "' value='"
										+ ws.getString(7) + "^" + ws.getString(8) + "^" + ws.getString(9) + "^" + ws.getString(2) + "^"
										+ ws.getString(10) + "^" + ws.getString(11) + "^" + ws.getString(12) + "^" + ws.getString(15)
										+ "' onclick='return enableTransferQty(this , " + count + " );' />";
						odQty =
								"<input type='text' disabled='disabled' name='strTransferOrderQty' autocomplete='off' onkeypress='return validateData(event,5);' id='strTransferOrderQty"
										+ count + "' class='txtFldNormal' value='0' onkeyup='checkTransferTotalOrder(this , " + count + ");' />";
						strPrimaryKey = "<input type='hidden' name ='strPrimaryKey' id ='strPrimaryKey" + count + "'   disabled='disabled'      value='" + strPrimaryKey + "'>";
					}

					count = count + 1;

					sb.append("<tr style='" + bgClass + "'>");
					sb.append(strPrimaryKey);
					sb.append("<td width='5%' align='center'>");
					sb.append(chkBoxStr);
					sb.append("</td> <td width='25%'  style='text-align:left;'>");
					sb.append(ws.getString(1));
					sb.append("</td><td width='10%' align='center' >");
					sb.append(ws.getString(2));
					sb.append("</td><td width='10%' align='center' >");
					sb.append(ws.getString(3));
					sb.append("</td><td width='10%'  style='text-align:center;'>");
					sb.append(ws.getString(10));
					sb.append("</td><td width='10%' align='center' >");
					sb.append(ws.getString(11));
					sb.append("</td><td width='10%' align='right' >");
					sb.append(ws.getString(14) + " " + ws.getString(13));
					sb.append("</td><td width='10%' align='right' ><span style='color:blue;cursor: pointer;' onclick='displayPopupDtls(this , \""
							+ ws.getString(5) + " \" , \"" + ws.getString(6) + " \");' >");
					sb.append(ws.getString(4) + " " + ws.getString(13));
					sb.append("</span></td><td width='10%' >").append(odQty);
					sb.append("</td></tr>");
					
					sb.append("<input type='hidden' name='hiddenToStoreName' value='"+ws.getString(1)+"'/>");
					sb.append("<input type='hidden' name='hiddenDemanDate' value='"+ws.getString(3)+"'/>");
				}

				sb.append("<tr>");
				sb.append("<td colspan='8' class='multiRPTLabel' style='text-align:right;' >Total Order Qty. </td>");
				sb.append("<td colspan='1' class='multiPOControl'><div style='display:none;'><input type='text' class='txtFldMin' name='strTotalOrderQty' value='0'></div><div style='font-weight:bold' id='strTotalOrderQtyDivId'>0</div></td>");

			} else {

				sb.append("<tr>");
				sb.append("<td colspan='8' align='center'><font color='red'>No Record Found</font></td>");
				sb.append("</tr>");
			}
			sb.append("</tbody>");
			sb.append("</table></div>");

		} catch (Exception e) {
			e.printStackTrace();
			new HisException("Transfer Approval Details", "TransferApprovalTransHLP.getTransferingDetails()-->", e.getMessage());
		}

		return sb.toString();
	}

	/**
	 * Gets the transfering details modify.
	 * 
	 * @param ws the ws
	 * @return the transfering details modify
	 */
	public static String getTransferingDetailsModify(WebRowSet ws,HttpServletRequest request) {
		StringBuffer sb = new StringBuffer("");
		String strTotal = "0";
		int count = 0;
		String chkValueDis = "", bgClass = "", strPrimaryKey = "", strPrimaryKey1 = "", odQty = "";

		try {

			sb.append("<div class='line'><table>");
			sb.append("<tr >");
			sb.append("<td colspan='8' align='left'>Transferring Details</td>");
			sb.append("</tr></table></div>");
			sb.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='0px' >");
			sb.append("<tr>");
			sb.append("<td width='5%' class='multiLabel'>#</td>");
			sb.append("<td width='25%' class='multiLabel'>Store_Name</td>");
			sb.append("<td width='10%' class='multiLabel'>Request_no</td>");
			sb.append("<td width='10%' class='multiLabel'>Request_date</td>");
			sb.append("<td width='10%' class='multiLabel'>Batch_No.</td>");
			sb.append("<td width='10%' class='multiLabel'>Expiry_Date</td>");
			sb.append("<td width='10%' class='multiLabel'>Available_qty</td>");
			sb.append("<td width='10%' class='multiLabel'>Balance_qty</td>");
			sb.append("<td width='10%' class='multiLabel'>Order_qty</td>");
			sb.append("</tr>");

			if (ws != null && ws.size() > 0) {

				while (ws.next()) {
					/**
					 * 1.DDW_NAME 2.REQUEST_NO 3.REQ_DATE 4.BATCH_NO 5.EXPIRY_DATE 6.AVL_QTY 7.BAL_QTY 8.CURR_ORDER_QTY 9.REQ_QTY 10.TOT_ORDER_QTY
					 * 11.STORE_ID 12.ITEMBRAND_ID 13.SLNO 14.pkKey 15.Exp Flag
					 */

					count = count + 1;
					if (Integer.parseInt(ws.getString(6)) > 0 && Integer.parseInt(ws.getString(15)) > -1) {
						if (Integer.parseInt(ws.getString(8)) > 0) {
							chkValueDis =
									"<input type='checkbox' name='strTransferingDtls' checked='checked' id='strTransferingDtlsCheckId" + count
											+ "' value='' onclick='return enableTransferQtyModify(this , " + count + " );' />";
							strPrimaryKey = "<input type='hidden' name ='strPrimaryKey'   id ='strPrimaryKey" + count + "'       value='" + ws.getString(14) + "'>";
							strPrimaryKey1 = "<input type='hidden' name ='strPrimaryKey1' id ='strPrimaryKey1" + count + "'         value='" + ws.getString(16) + "'>";
							odQty =
									"<input type='text' name='strTransferOrderQty' autocomplete='off' onkeypress='return validateData(event,5);' id='strTransferOrderQty"+ count + "' class='txtFldMin' value='" + ws.getString(8)
											+ "' onkeyup='checkTransferTotalOrderModify(this , " + count + ");' />";
						} else {
							chkValueDis =
									"<input type='checkbox' name='strTransferingDtls' id='strTransferingDtlsCheckId" + count
											+ "' value='' onclick='return enableTransferQtyModify(this , " + count + " );' />";
							
							strPrimaryKey = "<input type='hidden'  disabled=true  name ='strPrimaryKey'   id ='strPrimaryKey" + count + "'       value='" + ws.getString(14) + "'>";
							strPrimaryKey1 = "<input type='hidden' disabled=true  name ='strPrimaryKey1' id ='strPrimaryKey1" + count + "'         value='" + ws.getString(16) + "'>";
							odQty =
									"<input type='text' name='strTransferOrderQty' disabled=true  autocomplete='off' onkeypress='return validateData(event,5);' id='strTransferOrderQty"
											+ count + "' class='txtFldMin' value='" + ws.getString(8)
											+ "' onkeyup='checkTransferTotalOrderModify(this , " + count + ");' />";
						}
						bgClass = "";
						
					} else {
						chkValueDis = "";
						bgClass = "background-color: #faad07;";
						strPrimaryKey = "";
						strPrimaryKey1 = "";
						odQty = "--";
					}

					strTotal = ws.getString(8);
					sb.append("<tr style='" + bgClass + "'>");
					sb.append("<input type='hidden' name='currItemBalQty' id ='currItemBalQty" + count + "'  value='" + ws.getString(7) + "'>");
					sb.append(strPrimaryKey);
					sb.append(strPrimaryKey1);
					sb.append("<td width='5%' class='multiControl' style='" + bgClass + "'>");
					sb.append(chkValueDis);
					sb.append("</td> <td width='25%' class='multiControl' style='" + bgClass + "'>");
					sb.append(ws.getString(1));
					sb.append("</td><td width='10%' class='multiControl' style='" + bgClass + "'>");
					sb.append(ws.getString(2));
					sb.append("</td><td width='10%' class='multiControl' style='" + bgClass + "'>");
					sb.append(ws.getString(3));
					sb.append("</td><td width='10%' class='multiControl' style='" + bgClass + "'>");
					sb.append(ws.getString(4));
					sb.append("</td><td width='10%' class='multiControl' style='" + bgClass + "'>");
					sb.append(ws.getString(5));
					sb.append("</td><td width='10%' class='multiControl' style='" + bgClass + "'>");
					sb.append(ws.getString(6));
					sb.append("</td><td width='10%' class='multiControl' style='" + bgClass + "'><span style='color:blue;cursor: pointer;'"
							+ " onclick='displayPopupDtlsModify(this , \"" + ws.getString(9) + " \" , \"" + ws.getString(10) + " \", \""
							+ ws.getString(8) + " \");' >");
					sb.append(ws.getString(7));
					sb.append("</span></td><td width='10%' class='multiControl' style='" + bgClass + "'>");
					sb.append(odQty);
					sb.append("</td></tr>");
				}

				sb.append("<tr>");
				sb.append("<td colspan='8' class='multiRPTLabel' style='text-align:right;'>Total Order Qty. </td>");
				sb.append("<td colspan='1' class='multiControl'><div style='display:none;'><input type='text' class='txtFldMin' name='strTotalOrderQty' value='"
						+ strTotal + "'></div><div style='font-weight:bold' id='strTotalOrderQtyDivId'>" + strTotal + "</div></td>");

			} else {
				sb.append("<tr>");
				sb.append("<td colspan='9' class='multiControl'><font color='red'>No Record Found</font></td>");
				sb.append("</tr>");
			}
			sb.append("</table>");

		} catch (Exception e) {
			e.printStackTrace();
			new HisException("Transfer Approval Details", "TransferApprovalTransHLP.getTransferingDetails()-->", e.getMessage());
		}

		return sb.toString();
	}

	/**
	 * 
	 * @param ws
	 * @return
	 */

	public static String getOrderDetails(TransferApprovalTransVO vo,HttpServletRequest request) {
		StringBuffer sb = new StringBuffer("");
		int balQty = 0;
		int count = 0;
		WebRowSet ws = null;

		try {
			ws = vo.getWsOrderDetails();

			if (ws != null && ws.size() > 0) {

				if (ws.next()) {

					/**
					 * 1.HSTNUM_ORDER_NO 2.ORDER_DATE 3.RAISING_DDW 4.DEMAND_REQUEST_NO 5.TRANS_DDW 6.TRANS_REQUEST_NO 7.GRP_NAME 8.DRUG_NAME
					 * 9.ORDER_QTY 10.TRANS_QTY 11.ACK_QTY 12.ORDER_REMARKS 13.SUB_GROUP_NAME 14.DEMAND_DATE(REQUEST_DATE^SANCTION_QTY^APPROVED_QTY
					 * 15.TRANS_STORE_ID 16.ITEMBRAND_ID 17.HSTNUM_DEMAND_STORE_ID 18.BATCH_NO 19.MANUF_DATE 20.Exp date 21.UNIT_NAME
					 */
					String[] strDetails = ws.getString(14).replace("^", "#").split("#");
					balQty = Integer.parseInt(strDetails[1]) - Integer.parseInt(strDetails[2]) + Integer.parseInt(ws.getString(9));
					count = count + 1;
					sb.append("<tr>");
					sb.append("<td width='25%' class='LABEL'>Store_Name</td>");
					sb.append("<td width='25%' class='CONTROL'>" + ws.getString(3) + "</td>");
					sb.append("<td width='25%' class='LABEL'>Order No</td>");
					sb.append("<td width='25%' class='CONTROL'>" + ws.getString(1) + "</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td width='25%' class='LABEL'>Order Date</td>");
					sb.append("<td width='25%' class='CONTROL'>" + ws.getString(2) + "</td>");
					sb.append("<td width='25%' class='LABEL'>Store Name</td>");
					sb.append("<td width='25%' class='CONTROL'>" + ws.getString(5) + "</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td width='25%' class='LABEL'>Demand No</td>");
					sb.append("<td width='25%' class='CONTROL'>" + ws.getString(4) + "</td>");
					sb.append("<td width='25%' class='LABEL'>Demand Date</td>");
					sb.append("<td width='25%' class='CONTROL'>" + strDetails[0] + "</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td width='25%' class='LABEL'>Demand Qty.(A)</td>");
					sb.append("<td width='25%' class='CONTROL'>" + strDetails[1] + " " + ws.getString(21) + "</td>");
					sb.append("<td width='25%' class='LABEL'>Order Qty.(B)</td>");
					sb.append("<td width='25%' class='CONTROL'>" + strDetails[2] + " " + ws.getString(21) + "</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td width='25%' class='LABEL'>Current Order Qty.(C)</td>");
					sb.append("<td width='25%' class='CONTROL'>" + ws.getString(9) + " " + ws.getString(21) + "</td>");
					sb.append("<td width='25%' class='LABEL'>Balacne Qty (A-B+C)</td>");
					sb.append("<td width='25%' class='CONTROL'>" + balQty + " " + ws.getString(21) + "</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td width='25%' class='LABEL'>Drug Name</td>");
					sb.append("<td width='75%' colspan='3' class='CONTROL'>" + ws.getString(8) + "</td>");
					sb.append("</tr>");
					sb.append("<input type='hidden' name ='strBalQty' value='" + balQty + "'>");
					vo.setStrRequestNo(ws.getString(4));
					vo.setStrTransRequestNo(ws.getString(6));
					vo.setStrDrugName(ws.getString(8));
					vo.setStrOrderQty(ws.getString(9));
					vo.setStrDemandDate(strDetails[0]);
					vo.setStrDemandQty(strDetails[1]);
					vo.setStrOrderedQty(strDetails[2]);
					vo.setStrBalanceQty(strDetails[2]);
					vo.setStrTransStoreId(ws.getString(15));
					vo.setStrItemBrandId(ws.getString(16));
					vo.setStrStoreId(ws.getString(17));
				}

			} else {
				sb.append("<tr>");
				sb.append("<td colspan='9' class='multiControl'><font color='red'>No Order Found</font></td>");
				sb.append("</tr>");
			}

		} catch (Exception e) {
			e.printStackTrace();
			new HisException("Transfer Approval Details", "TransferApprovalTransHLP.getTransferingDetails()-->", e.getMessage());
		}

		return sb.toString();
	}

}
