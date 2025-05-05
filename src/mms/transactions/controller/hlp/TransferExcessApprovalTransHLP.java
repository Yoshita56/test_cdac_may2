/**
 * 
 */
package mms.transactions.controller.hlp;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

/**
 * @author santoshsinghchauhan
 * @date Jul 23, 2014
 * @file TransferExcessApprovalTransHLP.java
 */

import hisglobal.exceptions.HisException;

import mms.transactions.vo.TransferExcessApprovalTransVO;

/**
 * The Class TransferExcessApprovalTransHLP.
 */
public class TransferExcessApprovalTransHLP {

	/**
	 * Gets the drug details.
	 * 
	 * @param vo the vo
	 * @return the drug details
	 */
	public static String getDrugDetails(TransferExcessApprovalTransVO vo, HttpServletRequest request) {
		StringBuffer sb = new StringBuffer("");
		int count = 0;
		WebRowSet ws = null;
		String drugName = "", batchNo = "", avlQty = "", reqQty = "", expDate="", sancQty="", unitName="";
		String strPrimaryKey = "", strInsertHiddenValue ="";

		try {

			ws = vo.getWbTransferRequestDtl();

			/**
			 * 1.Item name 2. Batch No. 3. Expiry Date 4. Avl Qty. 5.Req Qty. 7.Display Sanc Qty. 8.Unit Name 9.Last App remarks
			 * 10.PK(STORE_ID^ITEM_ID^ITEMBRAND_ID^BATCH_NO^10) 11.Unit Id
			 */
			sb.append("<div class='line'><table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='0px'>");
			sb.append("<tr><td> Excess_drugs_details </td></tr>");
			sb.append("</table></div>");
			sb.append("<div id='wrapper' style='width:95%;margin-left:2.5%;'>");
			sb.append("<table id='mainTableRptId' class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='0px'><tr id='tableHeaderId'>");
			sb.append("<th width='5%' class='multiRPTLabel'>S.No.");
			sb.append("</th><th width='35%' class='multiRPTLabel'>Drug_Name");
			sb.append("</th><th width='10%' class='multiRPTLabel'>Batch_No.");
			sb.append("</th><th width='10%' class='multiRPTLabel'>Expiry_Date");
			sb.append("</th><th width='10%' class='multiRPTLabel'>Available Qty");
			sb.append("</th><th width='15%' class='multiRPTLabel'>Requested Qty");
			sb.append("</th><th width='15%' class='multiRPTLabel'>Sanctioned Qty");
			sb.append("</th></tr>");

			if (ws != null && ws.size() != 0) {

				while (ws.next()) {

					drugName = (ws.getString(1) == null || ws.getString(1).equals("")) ? "---" : ws.getString(1);
					batchNo = (ws.getString(2) == null || ws.getString(2).equals("")) ? "---" : ws.getString(2);
					expDate = (ws.getString(3) == null || ws.getString(3).equals("")) ? "---" : ws.getString(3);
					avlQty = (ws.getString(4) == null || ws.getString(4).equals("")) ? "0" : ws.getString(4);
					reqQty = (ws.getString(5) == null || ws.getString(5).equals("")) ? "0" : ws.getString(5);
					sancQty = (ws.getString(7) == null || ws.getString(7).equals("")) ? "---" : ws.getString(7);
					unitName = (ws.getString(8) == null || ws.getString(8).equals("")) ? "-" : ws.getString(8);
					strPrimaryKey = ws.getString(10);
					strInsertHiddenValue = reqQty + "^" + ws.getString(11);
					
					System.out.println("sanc qty "+sancQty + " "+ws.getString(7));
					
					sb.append("<tr>");
					sb.append("<input type='hidden' name ='strPrimaryKey'         value='" + strPrimaryKey + "'>");
					sb.append("<input type='hidden' name ='strInsertHiddenValue'  value='" + strInsertHiddenValue + "'>");
					sb.append("<input type='hidden' id='strAvailQty" + count + "'  name ='strAvailQty'  value='" + avlQty + "'>");
					sb.append("<input type='hidden' id='strReqQty" + count + "'  name ='strReqQty'  value='" + reqQty + "'>");
					
					sb.append("<td width='5%' align='center'>");
					sb.append(count + 1);
					sb.append("</td><td width='35%' align='left'>");
					sb.append(drugName);
					sb.append("</td><td width='10%' align='center'>");
					sb.append(batchNo);
					sb.append("</td><td width='10%' align='center'>");
					sb.append(expDate);
					sb.append("</td><td width='10%' align='right'>");
					sb.append(avlQty + " " +unitName);
					sb.append("</td><td width='15%' align='right'>");
					sb.append(reqQty+ " " +unitName);
					sb.append("</td><td width='15%' align='center'>");
					sb.append("<input type='text' name='strInsSancQty' id='strInsSancQty" + count + "' value='"+ sancQty +"' " +
							  "class='txtFldMin' style='text-align:right;' onkeypress='return validateData(event,5);'"
							+ " onkeyup='validateQty(this, \""	+ count + "\");'>");					
					sb.append("</td></tr>");
					count++;
				}

			} else {
				sb.append("<tr>");
				sb.append("<td align='center' colspan='7'><font color='red'>");
				sb.append("No Record Found </font></td>");
				sb.append("</tr>");
			}
			sb.append("</table></div>");

		} catch (Exception e) {
			e.printStackTrace();
			new HisException("Transfer Order Details", "TransferExcessApprovalTransHLP.getTransferOrderDetails()-->", e.getMessage());
		}
		return sb.toString();
	}
	
	public static String getIndentDetails(TransferExcessApprovalTransVO vo,HttpServletRequest request) {

		StringBuffer sb = new StringBuffer("");

		try {
			WebRowSet ws = vo.getStrIndentDetailsWs();
			if (ws != null && ws.size() > 0) {
				if (ws.next()) 
				{
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
						} else {
						}
						if(strReqStatus.equals("Rejected")){
							vo.setStrApprovalFlag("2");
						}
						sb.append("<input type='hidden' name ='strReqApprovalFlg'  value='" + strIndentStatus + "'>");
						sb.append("<input type='hidden' name ='strReqTypeId'  value='"+strReqTypeId+"'>");
						sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='0px'>");
						sb.append("<tr>");
						sb.append("<td width='25%' class='LABEL'>Req Type Name</td>");
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
						sb.append("<td width='25%' class='LABEL'>Req No</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strReqNo);
						sb.append("</td></tr>");

						sb.append("<tr><td width='25%' class='LABEL'>Req Date</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strIndentDate);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Status</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strReqStatus);
						sb.append("</td></tr>");
												
						sb.append("</table>");

				}
			} else {
				sb.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='0px'>");
				sb.append("<tr>");
				sb.append("<td colspan='4'  CLASS='multiControl' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>" + "</TD>");
				sb.append("</tr>");
				sb.append("</table>");

			}
		} catch (Exception e) {

			vo.setStrMsgString("TransferExcessApprovalTransHLP.getIndentDetails() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}
	
	public static String excessItemDtlView(TransferExcessApprovalTransVO vo,HttpServletRequest request) {
		StringBuffer sb = new StringBuffer("");
		int count = 0;
		WebRowSet ws = null;
		String drugName = "", batchNo = "", avlQty = "", reqQty = "", expDate="", sancQty="", unitName="";
		try {

			ws = vo.getWbTransferRequestDtl();

			/**
			 * 1.Item name 2. Batch No. 3. Expiry Date 4. Avl Qty. 5.Req Qty. 7.Display Sanc Qty. 8.Unit Name 9.Last App remarks
			 * 10.PK(STORE_ID^ITEM_ID^ITEMBRAND_ID^BATCH_NO^10) 11.Unit Id
			 */
			sb.append("<div class='line'><table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='0px'>");
			sb.append("<tr><td>Excess_drugs_details </td></tr>");
			sb.append("</table></div>");
			sb.append("<div id='wrapper' style='width:95%;margin-left:2.5%;'>");
			sb.append("<table id='mainTableRptId' class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='0px'><tr id='tableHeaderId'>");
			sb.append("</th><th width='35%' class='multiRPTLabel'>Drug Name");
			sb.append("</th><th width='10%' class='multiRPTLabel'>Batch");
			sb.append("</th><th width='10%' class='multiRPTLabel'>Expiry");
			sb.append("</th><th width='10%' class='multiRPTLabel'>Avl Qty");
			sb.append("</th><th width='15%' class='multiRPTLabel'>Req Qty");
			sb.append("</th><th width='15%' class='multiRPTLabel'>Sanc Qty");
			sb.append("</th></tr>");

			if (ws != null && ws.size() != 0) {

				while (ws.next()) {

					drugName = (ws.getString(1) == null || ws.getString(1).equals("")) ? "---" : ws.getString(1);
					batchNo = (ws.getString(2) == null || ws.getString(2).equals("")) ? "---" : ws.getString(2);
					expDate = (ws.getString(3) == null || ws.getString(3).equals("")) ? "---" : ws.getString(3);
					avlQty = (ws.getString(4) == null || ws.getString(4).equals("")) ? "0" : ws.getString(4);
					reqQty = (ws.getString(5) == null || ws.getString(5).equals("")) ? "0" : ws.getString(5);
					unitName = (ws.getString(8) == null || ws.getString(8).equals("")) ? "-" : ws.getString(8);
					sancQty = (ws.getString(6) == null || ws.getString(6).equals("")) ? "---" : (ws.getString(6)+" "+unitName);	
					System.out.println("sanc qty "+sancQty + " "+ws.getString(6));
					
					sb.append("<tr>");				
					
					sb.append("<td width='5%' align='center'>");
					sb.append(count + 1);
					sb.append("</td><td width='35%' align='left'>");
					sb.append(drugName);
					sb.append("</td><td width='10%' align='center'>");
					sb.append(batchNo);
					sb.append("</td><td width='10%' align='center'>");
					sb.append(expDate);
					sb.append("</td><td width='10%' align='right'>");
					sb.append(avlQty + " " +unitName);
					sb.append("</td><td width='15%' align='right'>");
					sb.append(reqQty+ " " +unitName);
					sb.append("</td><td width='15%' align='right'>");
					sb.append(sancQty);										
					sb.append("</td></tr>");
					count++;
				}

			} else {
				sb.append("<tr>");
				sb.append("<td align='center' colspan='7'><font color='red'>");
				sb.append("No Record Found</font></td>");
				sb.append("</tr>");
			}
			sb.append("</table></div>");

		} catch (Exception e) {
			e.printStackTrace();
			new HisException("Transfer Order Details", "TransferExcessApprovalTransHLP.getTransferOrderDetails()-->", e.getMessage());
		}
		return sb.toString();
	}

}
