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
import mms.transactions.vo.TransferShortageApprovalTransVO;

/**
 * The Class TransferShortageApprovalTransHLP.
 */
public class TransferShortageApprovalTransHLP {

	/**
	 * Gets the drug details.
	 * 
	 * @param vo the vo
	 * @return the drug details
	 */
	public static String getDrugDetails(TransferShortageApprovalTransVO vo,HttpServletRequest request) {
		StringBuffer sb = new StringBuffer("");
		int count = 0;
		WebRowSet ws = null;
		String strPrimaryKey = "", strInsertHiddenValue ="", unitName="";
		String drugName = "", avlQty = "", sancQty="";
		String reqQty = "", unitId="";
		try {

			ws = vo.getWbTransferReqDtl();

			sb.append("<div class='line'><table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='0px'>");
			sb.append("<tr><td>Shortage Drugs Details</td></tr>");
			sb.append("</table></div>");
			sb.append("<div id='wrapper' style='width:95%;margin-left:2.5%;'>");
			sb.append("<table id='mainTableRptId' class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='0px'><tr id='tableHeaderId'>");
			sb.append("<th width='5%' class='multiRPTLabel'>S.No.");
			sb.append("</th><th width='35%' class='multiRPTLabel'>Drug Name ");
			sb.append("</th><th width='20%' class='multiRPTLabel'>Avl Qty");
			sb.append("</th><th width='20%' class='multiRPTLabel'>Req Qty");
			sb.append("</th><th width='20%' class='multiRPTLabel'>Sanc Qty");
			sb.append("</th></tr>");

			if (ws != null && ws.size() != 0) {

				while (ws.next()) {
					
					/**
					 * 1.Item Name 2.Avl Qty 3.Req Qty 4.Sanc. Qty. 5. Display Sanction Qty 6.Unit Name 7.Last approval Remarks
					 * 8.pk (STORE_ID^ITEM_ID^ITEMBRAND_ID) 9.unit Id
					 */
					drugName = (ws.getString(1) == null || ws.getString(1).equals("")) ? "---" : ws.getString(1);
					avlQty = (ws.getString(2) == null || ws.getString(2).equals("")) ? "0" : ws.getString(2);
					reqQty = (ws.getString(3) == null || ws.getString(3).equals("")) ? "0" : ws.getString(3);
					sancQty = ws.getString(5);
					unitName = (ws.getString(6) == null || ws.getString(6).equals("")) ? "-" : ws.getString(6);
					strPrimaryKey = ws.getString(8);
					unitId = ws.getString(9);
					strInsertHiddenValue = reqQty + "^" + unitId;
					
					sb.append("<tr>");
					sb.append("<input type='hidden' name ='strPrimaryKey'         value='" + strPrimaryKey + "'>");
					sb.append("<input type='hidden' name ='strInsertHiddenValue'  value='" + strInsertHiddenValue + "'>");
					sb.append("<input type='hidden' id='strAvailQty" + count + "'  name ='strAvailQty'  value='" + avlQty + "'>");
					sb.append("<input type='hidden' id='strReqQty" + count + "'  name ='strReqQty'  value='" + reqQty + "'>");					
					sb.append("<td width='5%' align='center'>");
					sb.append(count + 1);
					sb.append("</td><td width='35%' align='left'>");
					sb.append(drugName);
					sb.append("</td><td width='20%' align='right'>");
					sb.append(avlQty + " "+unitName);
					sb.append("</td><td width='20%' align='right'>");
					sb.append(reqQty+ " "+unitName);
					sb.append("</td><td width='20%' align='center'>");
					sb.append("<input type='text' name='strInsSancQty' id='strInsSancQty" + count + "' value='"+ sancQty +"' " +
							  "class='txtFldMin' style='text-align:right;' onkeypress='return validateData(event,5);'"
							+ " onkeyup='validateQty(this, \""	+ count + "\");'>");
					sb.append("</td></tr>");
					count++;
				}

			} else {
				sb.append("<tr>");
				sb.append("<td align='center' colspan='5'><font color='red'>");
				sb.append("No Record Found</font></td>");
				sb.append("</tr>");
			}
			sb.append("</table></div>");

		} catch (Exception e) {
			e.printStackTrace();
			new HisException("Transfer Order Details", "TransferShortageApprovalTransHLP.getTransferOrderDetails()-->", e.getMessage());
		}
		return sb.toString();
	}
	
	public static String getIndentDetails(TransferShortageApprovalTransVO vo,HttpServletRequest request) {

		StringBuffer sb = new StringBuffer("");

		try {
			WebRowSet ws = vo.getStrIndentDetailsWs();
			if (ws != null && ws.size() > 0) {
				if (ws.next()) 
				{
						String status = "";
						String strReqNo = ws.getString(1);
						String strStoreName = ws.getString(2);
						String strIndentDate = ws.getString(3);
						String strItemCatg = ws.getString(4);
						String strIndentType = ws.getString(5);
						String strToStore = ws.getString(6);
						String strIndentStatus = ws.getString(7);
						String strIndentPeriod = ws.getString(8);
						String strApprovedBy = ws.getString(9);
						String strApprovedDate = ws.getString(10);
						String strApprovedlevel = ws.getString(11);
						String strIndentPeriodValue = ws.getString(13);
						String strReqTypeId = ws.getString(14);
						String strReqStatus = ws.getString(15);

						if (strStoreName == null) {
							strStoreName = "----";
						}
						if (strItemCatg == null) {
							strItemCatg = "----";
						}
						if (strReqNo == null) {
							strReqNo = "----";
						}
						if (strIndentDate == null) {
							strIndentDate = "----";
						}
						if (strIndentType == null) {
							strIndentType = "----";
						}
						if (strToStore == null) {
							strToStore = "----";
						}
						if (strIndentStatus == null) {
							strIndentStatus = "----";
						}
						if (strIndentPeriod == null || strIndentPeriod.equals("0")) {
							strIndentPeriod = "----";
						}
						if (strApprovedBy == null) {
							strApprovedBy = "----";
						}
						if (strApprovedDate == null) {
							strApprovedDate = "----";
						}
						if (strApprovedlevel == null) {
							strApprovedlevel = "----";
						}

						if (strIndentPeriodValue == null || strIndentPeriodValue.equals("")) {
							strIndentPeriodValue = "----";
						}

						if (strIndentStatus.equals("1")) {
							status = "Uregnt";
						} else {
							status = "Normal";
						}
						if(strReqStatus.equals("Rejected")){
							vo.setStrApprovalFlag("2");
						}
						
						sb.append("<input type='hidden' name ='strReqApprovalFlg'  value='" + strIndentStatus + "'>");
						sb.append("<input type='hidden' name ='strReqTypeId'  value='"+strReqTypeId+"'>");
						sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='0px'>");
						sb.append("<tr>");
						sb.append("<td width='25%' class='LABEL'>Req type</td>");
						sb.append("<td width='25%' class='CONTROL'> ");
						sb.append(strIndentType);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Catg</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strItemCatg);
						sb.append("</td>");						
						sb.append("</tr>");

						sb.append("<tr><td width='25%' class='LABEL'>Requesting Store</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strStoreName);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Req Status</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(status);
						sb.append("</td></tr>");

						sb.append("<tr><td width='25%' class='LABEL'>Req No</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strReqNo);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Req Date</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strIndentDate);
						sb.append("</td></tr>");

						sb.append("<tr><td width='25%' class='LABEL'>Status</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strReqStatus);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'></td>");
						sb.append("<td width='25%' class='CONTROL'>");											
						sb.append("</td></tr>");						
						sb.append("</table>");

					

				}
			} else {
				sb.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='0px'>");
				sb.append("<tr>");
				sb.append("<td colspan='4'  CLASS='multiControl' >"
						+ "<DIV class='errMsg' align='center'> No record Found </div>" + "</TD>");
				sb.append("</tr>");
				sb.append("</table>");

			}
		} catch (Exception e) {

			vo.setStrMsgString("TransferShortageApprovalTransHLP.getIndentDetails() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}
	
	public static String shortageItemDtlView(TransferShortageApprovalTransVO vo, HttpServletRequest request) {
		StringBuffer sb = new StringBuffer("");
		int count = 0;
		WebRowSet ws = null;
		String unitName="";
		String drugName = "", avlQty = "", sancQty="";
		String reqQty = "";
		try {

			ws = vo.getWbTransferReqDtl();

			sb.append("<div class='line'><table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='0px'>");
			sb.append("<tr><td> Shortage Details</td></tr>");
			sb.append("</table></div>");
			sb.append("<div id='wrapper' style='width:95%;margin-left:2.5%;'>");
			sb.append("<table id='mainTableRptId' class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='0px'><tr id='tableHeaderId'>");
			sb.append("<th width='5%' class='multiRPTLabel'>S.No.");
			sb.append("</th><th width='35%' class='multiRPTLabel'>Drug Name");
			sb.append("</th><th width='20%' class='multiRPTLabel'>Avl Qty");
			sb.append("</th><th width='20%' class='multiRPTLabel'>Req Qty");
			sb.append("</th><th width='20%' class='multiRPTLabel'>Sanc Qty");
			sb.append("</th></tr>");

			if (ws != null && ws.size() != 0) {

				while (ws.next()) {
					
					/**
					 * 1.Item Name 2.Avl Qty 3.Req Qty 4.Sanc. Qty. 5. Display Sanction Qty 6.Unit Name 7.Last approval Remarks
					 * 8.pk (STORE_ID^ITEM_ID^ITEMBRAND_ID) 9.unit Id
					 */
					drugName = (ws.getString(1) == null || ws.getString(1).equals("")) ? "---" : ws.getString(1);
					avlQty = (ws.getString(2) == null || ws.getString(2).equals("")) ? "0" : ws.getString(2);
					reqQty = (ws.getString(3) == null || ws.getString(3).equals("")) ? "0" : ws.getString(3);
					sancQty = (ws.getString(4) == null || ws.getString(4).equals("")) ? "0" : (ws.getString(4)+" "+ws.getString(6));
					unitName = (ws.getString(6) == null || ws.getString(6).equals("")) ? "-" : ws.getString(6);					
					
					sb.append("<tr>");									
					sb.append("<td width='5%' align='center'>");
					sb.append(count + 1);
					sb.append("</td><td width='35%' align='left'>");
					sb.append(drugName);
					sb.append("</td><td width='20%' align='right'>");
					sb.append(avlQty + " "+unitName);
					sb.append("</td><td width='20%' align='right'>");
					sb.append(reqQty+ " "+unitName);
					sb.append("</td><td width='20%' align='right'>");
					sb.append(sancQty);					
					sb.append("</td></tr>");
					count++;
				}

			} else {
				sb.append("<tr>");
				sb.append("<td align='center' colspan='5'><font color='red'>");
				sb.append("No record Found</font></td>");
				sb.append("</tr>");
			}
			sb.append("</table></div>");

		} catch (Exception e) {
			e.printStackTrace();
			new HisException("Transfer Order Details", "TransferShortageApprovalTransHLP.shortageItemDtlView()-->", e.getMessage());
		}
		return sb.toString();		
	}

}
