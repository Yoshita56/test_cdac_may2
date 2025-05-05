package mms.transactions.controller.hlp;

import hisglobal.utility.HisUtil;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

public class OnlineTransferDetailTransHLP
{


	/**
	 * To get Details HLP
	 * 
	 * @param wrsData_p  the WebRowSet
	 */
	public static String getBatchDetailsTable(WebRowSet wrsData_p)	throws SQLException {
		
		StringBuffer sbTable = new StringBuffer(100);
		StringBuffer sbHeader = new StringBuffer(100);
		StringBuffer sbBody = new StringBuffer(100);
		int nWidth=25;
		int nColspan=6;
		int i =0;

		sbTable.append("<table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >"+"<tr>");
		sbTable.append("<tr>"+	"<td class=\"TITLE\" colspan=\"4\" >Batch Details</td>" + "</tr>");
		sbTable.append("</table>");
		
		/*
		 * Header Row:
		 */

		sbHeader.append("<table bgcolor='#6097BC'  class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >"+"<tr>");
		
		/*
		 * Header Row:
		 */

		sbHeader.append("</tr>");
		
		sbHeader.append("<td width='5%' colspan='1' class='multiRPTLabel'>#</td>");
		sbHeader.append("<td width='25%' colspan='1' class='multiRPTLabel'>Batch No</td>");
		sbHeader.append("<td width='10%' colspan='1' class='multiRPTLabel'>Expiry Date</td>");
		sbHeader.append("<td width='15%' colspan='1' class='multiRPTLabel'>Available Qty</td>");
		sbHeader.append("<td width='15%' colspan='1' class='multiRPTLabel'>Rate/Unit</td>");
		sbHeader.append("<td width='15%' colspan='1' class='multiRPTLabel'>Transfer Qty</td>");
		sbHeader.append("<td width='15%' colspan='1' class='multiRPTLabel'>Cost</td>");

		sbHeader.append("</tr>");
		
		
		

		if (wrsData_p != null && wrsData_p.size() > 0) {		
			/* Result Index */
			// BATCH_NO: 1
			// AVL_QTY: 2
			// RATE_PER_UNIT: 3
			// HSTNUM_SALEPRICE: 4
			// SALEPRICE_UNIT_NAME: 5
			// HSTNUM_SALEPRICE_UNITID: 6
			// INHAND_QTY_BASE: 7			
			// EXPIRY_DATE: 8
			
		
			
			while (wrsData_p.next()) {

				
				
				String strBatchNo = wrsData_p.getString("BATCH_NO");
				String strAvlQty = wrsData_p.getString("AVL_QTY");			
				String strRatePerUnit = wrsData_p.getString("RATE_PER_UNIT"); // Sale Price for 1 Qty
				
				String strSalePrice   = wrsData_p.getString("HSTNUM_SALEPRICE"); // Eg. 9.10
				String strSalePriceUnit   = wrsData_p.getString("SALEPRICE_UNIT_NAME"); // Eg. No,10*10  etc.
				String strSalePriceUnitId   = wrsData_p.getString("HSTNUM_SALEPRICE_UNITID"); // Eg. 6301 etc
				
				String strAvlQtyBase = wrsData_p.getString("INHAND_QTY_BASE"); 
				String strExpDate = wrsData_p.getString("EXPIRY_DATE");
				
				
				
				
				if (strBatchNo == null) {
					strBatchNo = "---";
				}
				if (strAvlQty == null) {
					strAvlQty = "---";
				}
				if (strRatePerUnit == null) {
					strRatePerUnit = "---";
				}
				if (strSalePrice == null) {
					strSalePrice = "---";
				}
				if (strSalePriceUnit == null) {
					strSalePriceUnit = "---";
				}
				if (strSalePriceUnitId == null) {
					strSalePriceUnitId = "---";
				}
				
				if (strExpDate == null) {
					strExpDate = "---";
				}
								
				
				/*
				 * Table Body
				 */
				
			

				sbBody.append("<tr>");
				sbBody.append("<td class=\"multiPOControl\" style=\"text-align:center;\">" + "<input type='checkbox' name='batchCheckbox' onclick='clickBatchChkBox("+i+")' >" + "</td>");		
				sbBody.append("<td class=\"multiPOControl\" style=\"text-align:left;\">" + strBatchNo + "</td>");
				sbBody.append("<td class=\"multiPOControl\" style=\"text-align:left;\">" + strExpDate + "</td>");
				sbBody.append("<td class=\"multiPOControl\" style=\"text-align:right;\">" + strAvlQty + "</td>");
				sbBody.append("<td class=\"multiPOControl\" style=\"text-align:right;\">" + strSalePrice+" / "+strSalePriceUnit + "</td>");
				sbBody.append("<td class=\"multiPOControl\" >" + "<div id='transferQtyDivId"+i+"' "+">" +"<input type='text' name='strTransferQty' size='10' maxlength='7' onkeypress='return validateData(event,5);' disabled='disabled' onblur='checkAvailQtyTwo("+i+")' "+" >"  + "</div></td>");
				sbBody.append("<td class=\"multiPOControl\" >" + "<div id='costDivId"+i+"' "+">" + "<input type='text' name='strCost' size='10' readonly='readonly' />" + "</div></td>");
				
				
				sbBody.append("<input type='hidden' name='checkboxFlag' value='0' >");
				
				sbBody.append("<input type='hidden' name='strBatchNo' value='"+strBatchNo+"' >");
				sbBody.append("<input type='hidden' name='strAvailableQty' value='"+strAvlQty+"' >");
				sbBody.append("<input type='hidden' name='strRatePerUnit' value='"+strRatePerUnit+"' >");	
				sbBody.append("<input type='hidden' name='strAvlQtyBase' value='"+strAvlQtyBase+"' >");
				
				
				sbBody.append("</tr>"); 
				
				i++;
			}
			
		
			
			
			
			sbBody.append("<tr>");	
			sbBody.append("</tr>");	
			sbBody.append("<tr>");		
			sbBody.append("<td colspan='6' class=\"LABEL\" ><b>Total Transferred Qty</b></td>");
			sbBody.append("<td colspan='1' class=\"CONTROL\">" + "<div id='totalTransferredQtyDivId' >" + "<input type='text' name='strTotalTransferredQty' class='txtFldMax' readonly='readonly' />" + "</td>");
			sbBody.append("</tr>");
			
			
			sbBody.append("<tr>");
			sbBody.append("<td colspan='6' class=\"LABEL\"><b>Total Transferred Cost</b></td>");
			sbBody.append("<td colspan='1' class=\"CONTROL\" style=\"text-align: right; color:red;\" >" + "<div id='totalTransferredCostDivId' >" + "<input type='text' class='txtFldMax' name='strTotalTransferredCost' readonly='readonly' />" + "</td>");
			sbBody.append("</tr>");
			
			sbBody.append("</table>"); 

		} 
		else 
		{
			sbBody.append("<tr>");
			sbBody.append("<td colspan=\""	+ nColspan	+ "\" class=\"multiPOControl\" style=\"text-align: center; color: red;\">No Data Found!</td>");
			sbBody.append("</tr></table>");
		}

		return sbTable.toString() + sbHeader.toString() + sbBody.toString();
	}
	
	


	/**
	 * To get Details HLP on view page
	 * 
	 * @param wrsData_p  the WebRowSet
	 */
	public static String getTransferDetailsTable(WebRowSet wrsData_p)	throws SQLException {
		
		StringBuffer sbTable = new StringBuffer(100);
		StringBuffer sbHeader = new StringBuffer(100);
		StringBuffer sbBody = new StringBuffer(100);
		int nWidth=25;
		int nColspan=6;
		int i =0;

		sbTable.append("<table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >"+"<tr>");
		sbTable.append("<tr>"+	"<td class=\"TITLE\" colspan=\"4\" >Transfer Details</td>" + "</tr>");
		sbTable.append("</table>");
		
		/*
		 * Header Row:
		 */

		sbHeader.append("<table bgcolor='#6097BC'  class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >"+"<tr>");
		
		/*
		 * Header Row:
		 */

		sbHeader.append("</tr>");
		
		sbHeader.append("<td width='5%' colspan='1' class='multiRPTLabel'>#</td>");
		sbHeader.append("<td width='15%' colspan='1' class='multiRPTLabel'>Transfer No</td>");
		sbHeader.append("<td width='20%' colspan='1' class='multiRPTLabel'>Transfer Date</td>");
		sbHeader.append("<td width='20%' colspan='1' class='multiRPTLabel'>Transfer To</td>");
		sbHeader.append("<td width='20%' colspan='1' class='multiRPTLabel'>Order No</td>");
		sbHeader.append("<td width='20%' colspan='1' class='multiRPTLabel'>Order Date</td>");

		sbHeader.append("</tr>");
		
		
		

		if (wrsData_p != null && wrsData_p.size() > 0) {		
			/*
			 * 1 HSTNUM_TRANSFER_NO
			 * 2 TRANS_DATE
			 * 3 TRANS_TO
			 * 4 ORDER_NO
			 * 5 ORDER_DATE
			 * 6 HSTNUM_TOSTORE_ID
			 */					
			
		
			
			while (wrsData_p.next()) {

				
				
				String strTransferNo = wrsData_p.getString("HSTNUM_TRANSFER_NO");
				String strTransferDate = wrsData_p.getString("TRANS_DATE");			
				String strTransferTo = wrsData_p.getString("TRANS_TO");
				String strOrderNo = wrsData_p.getString("ORDER_NO");			
				String strOrderDate = wrsData_p.getString("ORDER_DATE");
				String strToStoreId = wrsData_p.getString("HSTNUM_TOSTORE_ID");
				
				
				if (strTransferNo == null) {
					strTransferNo = "---";
				}
				if (strTransferDate == null) {
					strTransferDate = "---";
				}
				if (strTransferTo == null) {
					strTransferTo = "---";
				}
				if (strOrderNo == null) {
					strOrderNo = "---";
				}
				if (strOrderDate == null) {
					strOrderDate = "---";
				}
				
				
				/*
				 * Table Body
				 */
				
			

				sbBody.append("<tr>");
				sbBody.append("<td class=\"multiPOControl\" style=\"text-align:center;\">" + "<input type='radio' name='transferRadioButton' onclick='clickTransferDetailsRadioButton()' >" + "</td>");		
				sbBody.append("<td class=\"multiPOControl\" style=\"text-align:center;\">" + strTransferNo + "</td>");			
				sbBody.append("<td class=\"multiPOControl\" style=\"text-align:center;\">" + strTransferDate + "</td>");
				sbBody.append("<td class=\"multiPOControl\" style=\"text-align:left;\">" + strTransferTo + "</td>");
				sbBody.append("<td class=\"multiPOControl\" style=\"text-align:center;\">" + strOrderNo + "</td>");
				sbBody.append("<td class=\"multiPOControl\" style=\"text-align:center;\">" + strOrderDate + "</td>");
				sbBody.append("<input type='hidden' name='tempTransferNo' value='"+strTransferNo+"' >");
				sbBody.append("<input type='hidden' name='strTransferDate' value='"+strTransferDate+"' >");
				sbBody.append("<input type='hidden' name='strTransferTo' value='"+strTransferTo+"' >");		
				sbBody.append("<input type='hidden' name='strOrderNo' value='"+strOrderNo+"' >");		
				sbBody.append("<input type='hidden' name='strOrderDate' value='"+strOrderDate+"' >");		
				
				sbBody.append("<input type='hidden' name='strToStoreId' value='"+strToStoreId+"' >");
				//System.out.println("strTransferDate"+strTransferDate);
				
				sbBody.append("</tr>"); 
				
				i++;
			}
			
			
			sbBody.append("</table>"); 

		} 
		else 
		{
			sbBody.append("<tr>");
			sbBody.append("<td colspan=\""	+ nColspan	+ "\" class=\"multiPOControl\" style=\"text-align: center; color: red;\">No Data Found!</td>");
			sbBody.append("</tr></table>");
		}

		return sbTable.toString() + sbHeader.toString() + sbBody.toString();
	}
	
	
	
	

	/**
	 * To get Details HLP on view page
	 * 
	 * @param wrsData_p  the WebRowSet
	 */
	public static String getItemDetailsTable(WebRowSet wrsData_p)	throws SQLException {
		
		StringBuffer sbTable = new StringBuffer(100);
		StringBuffer sbHeader = new StringBuffer(100);
		StringBuffer sbBody = new StringBuffer(100);
		int nWidth=25;
		int nColspan=6;
		int i =0;

		sbTable.append("<table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >"+"<tr>");
		sbTable.append("<tr>"+	"<td class=\"TITLE\" colspan=\"4\" >Item Details</td>" + "</tr>");
		sbTable.append("</table>");
		
		/*
		 * Header Row:
		 */

		sbHeader.append("<table bgcolor='#6097BC'  class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >"+"<tr>");
		
		/*
		 * Header Row:
		 */

		sbHeader.append("</tr>");
		sbHeader.append("<td width='45%' colspan='1' class='multiRPTLabel'>Item Name</td>");
		sbHeader.append("<td width='15%' colspan='1' class='multiRPTLabel'>Batch No</td>");
		sbHeader.append("<td width='10%' colspan='1' class='multiRPTLabel'> Expiry</td>");
		sbHeader.append("<td width='10%' colspan='1' class='multiRPTLabel'>Transfer Qty</td>");
		sbHeader.append("<td width='10%' colspan='1' class='multiRPTLabel'>Rec Qty</td>");
		sbHeader.append("<td width='10%' colspan='1' class='multiRPTLabel'>Cost</td>");
		sbHeader.append("</tr>");
		
		
		

		if (wrsData_p != null && wrsData_p.size() > 0) 
		{		
			/*
			 * 1 BATCH_NO
			 * 2 EXPIRY_DATE
			 * 3 TRANS_QTY
			 * 4 REC_QTY
			 * 5 DRUG_NAME
			 * 6 NET_COST
			 */					
			
		
			
			while (wrsData_p.next()) 
			{

				
				String strBatchNo = wrsData_p.getString("BATCH_NO");
				String strExpiryDate = wrsData_p.getString("EXPIRY_DATE");			
				String strTransferQty = wrsData_p.getString("TRANS_QTY");
				String strRecQty = wrsData_p.getString("REC_QTY");			
				String strDrugName = wrsData_p.getString("DRUG_NAME");
				String strCost = wrsData_p.getString("NET_COST");
				
				
				if (strBatchNo == null) {
					strBatchNo = "---";
				}
				if (strExpiryDate == null) {
					strExpiryDate = "---";
				}
				if (strTransferQty == null) {
					strTransferQty = "---";
				}
				if (strRecQty == null) {
					strRecQty = "---";
				}
				if (strDrugName == null) {
					strDrugName = "---";
				}
				if (strCost == null) {
					strCost = "---";
				}
				
				
				/*
				 * Table Body
				 */
				
			

				sbBody.append("<tr>");
				sbBody.append("<td class=\"multiPOControl\" style=\"text-align: left;\">" + strDrugName + "</td>");
				sbBody.append("<td class=\"multiPOControl\" style=\"text-align:left;\">" + strBatchNo + "</td>");			
				sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">" + strExpiryDate + "</td>");
				sbBody.append("<td class=\"multiPOControl\" style=\"text-align: right;\">" + strTransferQty + "</td>");
				sbBody.append("<td class=\"multiPOControl\" style=\"text-align: right;\">" + strRecQty + "</td>");
				sbBody.append("<td class=\"multiPOControl\" style=\"text-align: right;\">" + strCost + "</td>");
				sbBody.append("<input type='hidden' name='strBatchNo' value='"+strBatchNo+"' >");
				sbBody.append("<input type='hidden' name='strAvailableQty' value='"+strExpiryDate+"' >");
				sbBody.append("<input type='hidden' name='strTransferQty' value='"+strTransferQty+"' >");		
				sbBody.append("<input type='hidden' name='strTransferQty' value='"+strRecQty+"' >");		
				sbBody.append("<input type='hidden' name='strTransferQty' value='"+strDrugName+"' >");		
				
				sbBody.append("<input type='hidden' name='strToStoreId' value='"+strCost+"' >");
				
				
				sbBody.append("</tr>"); 
				
				i++;
			}
			
			
			sbBody.append("</table>"); 
			

		} 
		else 
		{
			sbBody.append("<tr>");
			sbBody.append("<td colspan=\""	+ nColspan	+ "\" class=\"multiPOControl\" style=\"text-align: center; color: red;\">No Data Found!</td>");
			sbBody.append("</tr></table>");
		}

		return sbTable.toString() + sbHeader.toString() + sbBody.toString();
	}
	
	
	
	/**
	 * voucher Print
	 */
	public static String getTransferDetails(WebRowSet ws, String strDwhName) throws Exception {

		StringBuffer sb = new StringBuffer("");
		String strTransferNo = "";
		String strTransferDate = "";
		String strTransferFrom = "";
		String strTransferTo = "";
		
		String strRemarks="";
		String strReceivedBy ="";
		
		String strOrderNo="" , strOrderDate="",strDemandNo="",strDemandDate="",strTransferredBy="";
	
		double cltamt  = 0.00;
		double totalCost = 0.00;
		
		int i=1;
		String strItemTotCost="0.00";
		HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}

		

		String strTableWidth = "700";

		try 
		{

			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("REPORT_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("FULL_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("CITY"));
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> Drug Transfer Voucher");
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
//			
//			sb.append("<tr> ");
//			sb.append("<td width='8%'>&nbsp;</td> ");
//			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
//			sb.append(strDwhName);
//			sb.append("</font></b></td><td width='10%'>&nbsp; ");
//			sb.append("</td> ");
//			sb.append("</tr> ");
			
			sb.append("</table> ");
						
			
			
			sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='").append(strTableWidth).append(
			"'></table> ");
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataForTransfer();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(" src='../../hisglobal/images/stop.png' onClick='hideTransferPopup();' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			
            sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");

            /*
             1. Transfer No
             2. Transfer Date
             3. Transfer To
             4. Issuing Store Name
             5. Generic Name
             6. Brand Name
             7. Batch No
             8. Expiry date
             9. Transfer Qty
             10. Store ID
             11. Item id
             12. Item Brand Id
             13. Rate With Unit
             14. Base Value
             15. Trnasfer Qty
             16. Transfer Qty Unit
             17. Qty Base Value
             18. Item Sl No
             19. Item Sl No
             20. Item Catg Code
             21. Remarks
             22. Receive By
             23. Cost
             * */
            
            
           
            if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
					 strTransferNo = ws.getString(1);
					 strTransferDate = ws.getString(2);
					 strTransferTo = ws.getString(3);
					 strTransferFrom = ws.getString(4);
					 strRemarks = ws.getString(21);
					 strReceivedBy = ws.getString(22);
					 
					 strOrderNo =  ws.getString("ORDER_NO");
					 strOrderDate = ws.getString("ORDER_DATE");
				     strDemandNo = ws.getString("DEMAND_REQ_NO");
					 strDemandDate =  ws.getString("DEMAND_DATE");
					 strTransferredBy = ws.getString("TRANSFER_BY");  
	                          
					
				}
				ws.beforeFirst();
				
			
			    sb.append("<tr> ");
	
				sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Transfer No.", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strTransferNo)
						.append("</b></font></td> ");
	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Transfer Date", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strTransferDate).append(
						"</b></font></td> ");
				sb.append("</tr> ");
				
				
				sb.append("<tr> ");
				
				sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("From DWH.", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strTransferFrom)
						.append("</b></font></td> ");
	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("To DWH.", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strTransferTo).append(
						"</b></font></td> ");
				sb.append("</tr> ");
				
                sb.append("<tr> ");
				
				sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Order No.", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strOrderNo)
						.append("</b></font></td> ");
	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Order Date.", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strOrderDate).append(
						"</b></font></td> ");
				sb.append("</tr> ");
				
                sb.append("<tr> ");
				
				sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Demand No.", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strDemandNo)
						.append("</b></font></td> ");
	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Demand Date.", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strDemandDate).append(
						"</b></font></td> ");
				sb.append("</tr> ");
											
			
			sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");

			sb.append("<tr>");		
			sb.append("<td colspan='7' align='center'><hr size='2' width='100%'></td>");
			sb.append("</tr>");
			
			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font> ");
			sb.append("</td>");

			
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font> ");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font>");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font> ");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Transfer Qty</b></font> ");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font> ");
			sb.append("</td> ");
			
			sb.append("</tr> ");
			
			sb.append("<tr>");		
			sb.append("<td colspan='7' align='center'><hr size='2' width='100%'></td>");
			sb.append("</tr>");
				while (ws.next()) 
				{
					NumberFormat formatter = new DecimalFormat("############.##");  
					strItemTotCost = formatter.format(new BigDecimal(ws.getString(23)));  
					cltamt  = Double.parseDouble(strItemTotCost);
					totalCost = totalCost + cltamt;
					sb.append("<tr> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(i);
					sb.append("</font></td> ");
					
					
					sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(6));
					sb.append("</font></td> ");

					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(7));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(8));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(13));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(9));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(23));
					sb.append("</font></td> ");
					
					sb.append("</tr> ");
					i++;
								
				 }
					NumberFormat formatter = new DecimalFormat("############.##");  
				    
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
					
					sb.append("<tr>");
					sb.append("<td colspan='4' align='center'></td>");					
					sb.append("<td colspan='3' align='center'><hr size='2' width='100%'></td>");
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='6' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
					sb.append("<td colspan='1' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(FinaltotalCost);				
					sb.append("</font></td>");
					sb.append("</tr>");	
					
					
					sb.append("<tr>");
					sb.append("<td colspan='4' align='center'></td>");					
					sb.append("<td colspan='3' align='center'><hr size='2' width='100%'></td>");
					sb.append("</tr>");
					
					/*sb.append("<tr> "); 
					sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
					sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");
					
					
					if(!strRemarks.equals("")||!strRemarks.equals(" ")||!strRemarks.equals(null))
					{
					    sb.append(strRemarks);
					} 
					else
					{
						sb.append("--------");	
					}	
					sb.append("<br></font></td>");
			        sb.append("</tr> ");*/
					
					
					sb.append("<tr> ");
					sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Transferred By<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
					sb.append("</tr> ");
					sb.append("<tr> ");
					sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>(").append(strTransferredBy).append(
									")<b> &nbsp;&nbsp;</font></td> ");
					sb.append("</tr> ");

			} 
			else 
			{

				sb.append("<tr> ");
				sb
						.append("<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}

		return sb.toString();
	}
}


