package mms.reports.controller.hlp;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.reports.controller.fb.PendingIndentStatusRecordRptFB;
import mms.reports.vo.PendingIndentStatusRecordRptVO;

public class PendingIndentStatusRecordRptHLP {


	public static String getPartialIssueDtls(WebRowSet ws, String hosCode, PendingIndentStatusRecordRptVO VoObj)
			throws Exception {

		System.out.println(
				"--------------------- LocalPurchaseNewTransHLP.getPartialIssueDtls -------------------------------");
		System.out.println("VoObj.getStrCurrentDate="+VoObj.getStrCurrentDate());
		StringBuffer sb = new StringBuffer("");
		String strGroupByValue = "";

		BigDecimal totalIndentQty = new BigDecimal(BigInteger.ZERO, 2);
		BigDecimal indentQty = new BigDecimal(BigInteger.ZERO, 2);

		BigDecimal totalIssueQty = new BigDecimal(BigInteger.ZERO, 2);
		BigDecimal issueQty = new BigDecimal(BigInteger.ZERO, 2);

		BigDecimal totalAckQty = new BigDecimal(BigInteger.ZERO, 2);
		BigDecimal ackQty = new BigDecimal(BigInteger.ZERO, 2);
		
		int i = 1, count = 0;

		int Issued_Qty = 0;
		int Approved_Qty = 0;

		try {
			HisUtil hisUtil = new HisUtil("Global", "ReportUtil");
			HospitalMstVO hospitalVO = hisUtil.getHospitalDetail(hosCode);
			
			
	        sb.append("<div id='printRptId' align='right'>"
	        		+ "<img style='cursor: pointer; margin-right :10px;' text-align=right title='Print Page' "
	        		+ "src='../../hisglobal/images/printer_symbol.gif' "
	        		+ "onClick='printReport();' />"
	        		+ "<img style='cursor: pointer;' text-align=right title='Print Page' "
	        		+ "src='../../hisglobal/images/stop.png' "
	        		//+ "onClick='controlToMainPage();' />"
	                + "onclick=\"cancelPage('CANCELTODESK');\" />"
	        		+ "</div></td>");

			sb.append(
					"<table align='center' class='TABLEWIDTH' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append(
					"<tr align='center' ><td width='100%'><div><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' width='' style=''></div></td>");
			sb.append("</tr>");
			sb.append("</table> ");
			

			sb.append("<table align='center' class='TABLEWIDTH 'border='0' cellspacing='0' cellpadding='0' height='69' >");
			
			sb.append("<tr> <td align='center' colspan='3'></td>" + "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "From Date ::<b>"
					+ VoObj.getStrFromDate() + "</b> To Date ::<b>" + VoObj.getStrToDate() + "</b></font></td>");
			
			sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Generation Type ::<b>");
			if (VoObj.getStrRptType().equals("1")) {
				sb.append("Not Issued");
			} else if (VoObj.getStrRptType().equals("2")) {
				sb.append("Fully Issued");
			} else if (VoObj.getStrRptType().equals("3")) {
				sb.append("Partial Issued");
			} else {
				sb.append("--");
			}
			sb.append("</b></font></td><td align='center' colspan='2'></td></tr>");
			
			sb.append("<tr><td align='center' colspan='3'></td> "
							+ "<td align='center' colspan='3'>"
							+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"
							+ "Indenting Store Name ::<b>" + VoObj.getStrStoreName()
							+ "</b></font></td><td align='center' colspan='2'></td></tr>");

			sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Item Category ::<b>"
					+ VoObj.getStrCategoryName() + "</b></font></td><td align='center' colspan='2'></td></tr>");

			sb.append("<tr>" + "<td align='center' colspan='12'>"
			+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Report Date & Time  ::<b>"
			+ VoObj.getStrCurrentDate() + "</b></font></td></tr></table>");

			sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");

			if (ws != null && ws.size() > 0) {
				sb.append("<tr> ");
				sb.append(
						"<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue No [Date] </b></font>.</td>");
				sb.append(
						"<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Indent No / Date </b></font></td>");
				sb.append(
						"<td align='center' 	width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Name</b></font></td>");
				sb.append(
						"<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch </b></font></td>");
				sb.append(
						"<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Exp Date</b></font></td>");
				sb.append(
						"<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Approved/Issue Qty</b></font></td>");
				sb.append(
						"<td align='center' 	width='13%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Indenting Store</b></font></td>");
				sb.append(
						"<td align='center' 	width='13%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issuing Store</b></font></td>");
				sb.append("</tr> ");
				
				/*
				 * 1.ISSUE_NO_DATE
				 * 2.INDENT_NO_DATE
				 * 3.INDENT QTY
				 * 4.ISSUE_QTY
				 * 5.ACK_QTY
				 * 6.QTY_NOT_ACK
				 * 7.REC_ITEM_VALUE
				 * 8.REC_BY_STORE_NAME
				 * 9.REC_STORE_EMP_NAME
				 * 10.ISSUE_BY_STORE_NAME 
				 * 11.ITEM_NAME
				 * 12.BATCH_NO
				 * 13.EXP_DATE
				 * 14.RATE
				 * 15.EDL FLAG 0 - NO 1 -YES
				 * 
				 * */
				while (ws.next()) {
					
					if(i==0)
					{
						Approved_Qty = (int) Double.parseDouble(ws.getString(3));
						Issued_Qty = (int) Double.parseDouble(ws.getString(4));

					}
					else
					{
						Approved_Qty = (int) (Approved_Qty + Double.parseDouble(ws.getString(3)));
						Issued_Qty = (int) (Issued_Qty + Double.parseDouble(ws.getString(4)));
					}

					sb.append("</tr> ");
					sb.append("<td align='left'  width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(1));
					sb.append("</font></td> ");

					sb.append("<td align='left'  width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(2));
					sb.append("</font></td> ");

					sb.append("<td align='left'  width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(11));
					sb.append("</font></td> ");

					sb.append("<td align='center'   width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(12));
					sb.append("</font></td> ");
					sb.append("<td align='center'   width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(13));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='14%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(3) + " / " + ws.getString(4));
					sb.append("</font></td> ");

					sb.append("<td align='center' width='13%'><font face='Verdana, Arial, Helvetica, sans-serif' >"); // EXP_DATE
					sb.append(ws.getString(8));
					sb.append("</font></td> ");

					sb.append("<td align='center' width='13%'><font face='Verdana, Arial, Helvetica, sans-serif' >"); // EXP_DATE
					sb.append(ws.getString(10));
					sb.append("</font></td> ");

					sb.append("</tr> ");

					i++;
					count++;
				}
				sb.append("<tr>");
				
				sb.append("<td  colspan='5' align='right'><b> Total : </b>");
				sb.append("</td>");	
				
				sb.append("<td  colspan='1' align='center'>");
				sb.append(Approved_Qty+ " / " +Issued_Qty);								
				sb.append("</td>");		
			
				sb.append("</tr>");
				
			}else {

				sb.append("<tr> ");
				sb.append(
						"<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
				sb.append("</tr> ");
			}

			sb.append("</table> ");

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		} 
		return sb.toString();
	}

	public static String getIssuedDtls(PendingIndentStatusRecordRptVO VoObj,PendingIndentStatusRecordRptFB fb) {
		StringBuffer sb = new StringBuffer("");

		WebRowSet ws = VoObj.getStrIssueWs();
		System.out.println("HLP getStrIssueWs ws size"+ws.size());
		int i = 1;
//		double Available_Qty = 0.00;
		int Indent_Qty = 0;
		int Approved_Qty = 0;
		int Issued_Qty = 0;


		try {
			if (ws != null) {
				
		        sb.append("<div id='printRptId' align='right'><img style='cursor: pointer; margin-right :10px;' text-align=right title='Print Page' "
		        		+ "src='../../hisglobal/images/printer_symbol.gif' onClick='printReport();' />"
		        		+ "<img style='cursor: pointer;' text-align=right title='Cancel Page' src='../../hisglobal/images/stop.png' "
//		        		+ "onClick='controlToMainPage();' />"
		                + "onclick=\"cancelPage('CANCELTODESK');\" />"
		        		+ "</div>");
		        
		        sb.append("<table align='center' class='TABLEWIDTH' border='0' cellspacing='0' cellpadding='0' height='69'> ");
				sb.append("<tr> " + " <td colspan='1'></td>"
						+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
						// + " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/"
						// + voObj.getStrLogoName() + "'></div></td>"
						+ " <td colspan='1'></td></tr>");
				sb.append("</table>");

				sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
				
				sb.append(" <tr> <td align='center' colspan='3'></td>" + "<t+d align='center' colspan='3'>"
				+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "From Date ::<b>"
				+ VoObj.getStrFromDate() + "</b> To Date ::<b>" + VoObj.getStrToDate() + "</b></font></td>"
				+ "</tr>");
				
				sb.append("<tr><td align='center' colspan='3'></td> " +
						  "<td align='center' colspan='3'>" +
						  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
						  "Generation Type ::<b>");
						  if(VoObj.getStrRptType().equals("1")) {
							  sb.append("Not Issued");
						  }else if(VoObj.getStrRptType().equals("2")){
							  sb.append("Fully Issued");
						  }else if(VoObj.getStrRptType().equals("3")){
							  sb.append("Partial Issued");
						  }else {
							  sb.append("--");
						  }
			   sb.append("</b></font></td><td align='center' colspan='2'></td></tr>");
				
				sb.append("<tr>" + "<td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Indenting Store Name ::<b>"
						+ VoObj.getStrStoreName() + "</b></font></td><td align='center' colspan='2'></td></tr>"

						+ " <tr>" + "<td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Item Category ::<b>"
						+ VoObj.getStrCategoryName() + "</b></font></td><td align='center' colspan='2'></td></tr>"

						+ "<tr>" + "<td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Report Date & Time  ::<b>"
						+ fb.getStrCurrentDate() + "</b></font></td></tr>"
						
						+ " <tr>" + "<td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"
//						+ "By User  ::<b>"+voObj.getStrUserName()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						+ "</table> ");

				if (ws.size() != 0) {
					sb.append(
							"<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
					sb.append("<tr>");

					sb.append("<td width='2%' align='center'><b>S No.</b>");
					sb.append("</td>");
					
					if ("0".equals(VoObj.getStrStoreId()))  // Consolidated ALL case - Indenting Store Name
					{ 
						sb.append("<td width='15%' align='center'><b>Indenting Store</b>");
						sb.append("</td>");
					}
					
					sb.append("<td width='25%' align='center'><b>Item Name</b>");
					sb.append("</td>");
					
					sb.append("<td width='15%' align='center'><b>Issuing Store</b>");
					sb.append("</td>");

					sb.append("<td width='5%' align='center'><b>Available Qty</b>");
					sb.append("</td>");

					sb.append("<td width='5%' align='center'><b>Indent Qty</b>");
					sb.append("</td>");

					sb.append("<td width='5%' align='center'><b>Approved Qty</b>");
					sb.append("</td>");

					sb.append("<td width='5%' align='center'><b>Issued Qty</b>");
					sb.append("</td>");
					
					/*sb.append("<td width='10%' align='center'><b>Status</b>");
					sb.append("</td>");*/

					sb.append("</tr>");

					while (ws.next()) {
						
						if(i==0)
						{
//							Available_Qty = Integer.parseInt(ws.getString(4));
							Indent_Qty = (int) Double.parseDouble(ws.getString(6));
							Approved_Qty = (int) Double.parseDouble(ws.getString(7));
							Issued_Qty = (int) Double.parseDouble(ws.getString(8));

						}
						else
						{
//							Available_Qty = Available_Qty + Double.parseDouble(ws.getString(4));
							Indent_Qty = (int) (Indent_Qty + Double.parseDouble(ws.getString(6)));
							Approved_Qty = (int) (Approved_Qty + Double.parseDouble(ws.getString(7)));
							Issued_Qty = (int) (Issued_Qty + Double.parseDouble(ws.getString(8)));
						}

						sb.append("<tr>");

						sb.append("<td  width='2%' align='center' >");
						sb.append(i); // S No
						sb.append("</td>");

						if ("0".equals(VoObj.getStrStoreId())) {
							sb.append("<td  width='15%' align='left' >");
							sb.append(ws.getString(1)); // Consolidated ALL case - Indenting Store Name 
							sb.append("</td>");
						}

						sb.append("<td  width='25%' align='left' >");
						sb.append(ws.getString(4)); // Item Name
						sb.append("</td>");
						
						sb.append("<td  width='15%' align='left' >");
						sb.append(ws.getString(2));
						sb.append("</td>");
						
						sb.append("<td  width='5%' align='center' >");
//						sb.append(ws.getString(4)); // Available Qty
						int availableQty = (int) Double.parseDouble(ws.getString(5).trim());
						sb.append(availableQty);
						sb.append("</td>");
						
						sb.append("<td  width='5%' align='center'>");
//						sb.append(ws.getString(5)); // Indent Qty
						int indentQty = (int) Double.parseDouble(ws.getString(6).trim());
						sb.append(indentQty);
						
						sb.append("</td>");

						sb.append("<td  width='5%' align='center'>");
//						sb.append(ws.getString(6)); // Approved Qty
						int approvedQty = (int) Double.parseDouble(ws.getString(7).trim());
						sb.append(approvedQty);
						sb.append("</td>");
						
						sb.append("<td  width='5%' align='center'>");
//						sb.append(ws.getString(7)); // Issued Qty
						int issuedQty = (int) Double.parseDouble(ws.getString(8).trim());
						sb.append(issuedQty);
						sb.append("</td>");
						
						/*sb.append("<td  width='10%' align='center'>");
						sb.append(ws.getString(11)); // Status
						sb.append("</td>");*/

						sb.append("</tr>");
						i++;
					}
					
					sb.append("<tr>");
					if ("0".equals(VoObj.getStrStoreId())) {
					sb.append("<td  colspan='5' align='right'><b> Total : </b>");
					sb.append("</td>");	
					}else {
					sb.append("<td  colspan='4' align='right'><b> Total : </b>");
					sb.append("</td>");	
					}
					/*sb.append("<td  colspan='1' align='center'>");
					sb.append(Available_Qty);								
					sb.append("</td>");	*/
					
					sb.append("<td  colspan='1' align='center'>");
					sb.append(Indent_Qty);	
					sb.append("</td>");
					
					sb.append("<td  colspan='1' align='center'>");
					sb.append(Approved_Qty);								
					sb.append("</td>");		
				
					sb.append("<td  colspan='1' align='center'>");
					sb.append(Issued_Qty);								
					sb.append("</td>");	
					
					sb.append("</tr>");
					
					sb.append("</table>");
				} else {
					sb.append(
							"<table align='center' cellspacing='1px' bgcolor='white' cellpadding='1px' border='1px solid black' style='border-collapse:collapse;'>");
					sb.append("<td ><font color='red'>No Record Found</font></td>");
					sb.append("</tr>");
					sb.append("</table>");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			new HisException("Local Purchase Report", "BreakageItemDtlTransHLP.getBreakageDetails()-->",
					e.getMessage());
		}
		// System.out.println("sb"+sb);
		return sb.toString();
	}

	public static String getNotIssuedDtls(PendingIndentStatusRecordRptVO VoObj,PendingIndentStatusRecordRptFB fb) {
		StringBuffer sb = new StringBuffer("");

		WebRowSet ws = VoObj.getStrNotIssueWs();
		System.out.println("HLP getStrNotIssueWs ws size"+ws.size());
		int i = 1;
//		double Available_Qty = 0.00;
		int Indent_Qty = 0;
		int Approved_Qty = 0;
		int Issued_Qty = 0;


		try {
			if (ws != null) {
				
		        sb.append("<div id='printRptId' align='right'>"
		        		+ "<img style='cursor: pointer; margin-right :10px;' text-align=right title='Print Page' "
		        		+ "src='../../hisglobal/images/printer_symbol.gif' onClick='printReport();' />"
		        		+ "<img style='cursor: pointer;' text-align=right title='Cancel Page' "
		        		+ "src='../../hisglobal/images/stop.png' "
//		        		+ "onClick='controlToMainPage();' />"
		                + "onclick=\"cancelPage('CANCELTODESK');\" />"
		        		+ "</div>");

		        sb.append("<table align='center' class='TABLEWIDTH' border='0' cellspacing='0' cellpadding='0' height='69'> ");
				sb.append("<tr> " + " <td colspan='1'></td>"
						+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
						// + " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/"
						// + voObj.getStrLogoName() + "'></div></td>"
						+ " <td colspan='1'></td></tr>");
				sb.append("</table>");

				sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
				
				 sb.append(" <tr> <td align='center' colspan='3'></td>" + "<t+d align='center' colspan='3'>"
							+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "From Date ::<b>"
							+ VoObj.getStrFromDate() + "</b> To Date ::<b>" + VoObj.getStrToDate() + "</b></font></td>"
							+ "</tr> ");
				
				sb.append( "<tr><td align='center' colspan='3'></td> " +
						  "<td align='center' colspan='3'>" +
						  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
						  "Generation Type ::<b>");
						  if(VoObj.getStrRptType().equals("1")) {
							  sb.append("Not Issued");
						  }else if(VoObj.getStrRptType().equals("2")){
							  sb.append("Fully Issued");
						  }else if(VoObj.getStrRptType().equals("3")){
							  sb.append("Partial Issued");
						  }else {
							  sb.append("--");
						  }
				  sb.append("</b></font></td><td align='center' colspan='2'></td></tr>");

				  sb.append("<tr>" + "<td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Indenting Store Name ::<b>"
						+ VoObj.getStrStoreName() + "</b></font></td><td align='center' colspan='2'></td></tr>"
	
						+ " <tr>" + "<td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Item Category ::<b>"
						+ VoObj.getStrCategoryName() + "</b></font></td><td align='center' colspan='2'></td></tr>"
	
						+ "<tr>" + "<td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Report Date & Time  ::<b>"
						+ fb.getStrCurrentDate() + "</b></font></td></tr></table>");

				if (ws.size() != 0) {
					sb.append(
							"<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
					sb.append("<tr>");

					sb.append("<td width='2%' align='center'><b>S No.</b>");
					sb.append("</td>");

					if ("0".equals(VoObj.getStrStoreId()))  // Consolidated ALL case - Indenting Store Name
					{ 
						sb.append("<td width='15%' align='center'><b>Indenting Store</b>");
						sb.append("</td>");
					}
					
					sb.append("<td width='25%' align='center'><b>Item Name</b>");
					sb.append("</td>");
					
					sb.append("<td width='15%' align='center'><b>Issuing Store</b>");
					sb.append("</td>");

					sb.append("<td width='5%' align='center'><b>Available Qty</b>");
					sb.append("</td>");

					sb.append("<td width='5%' align='center'><b>Indent Qty</b>");
					sb.append("</td>");

					sb.append("<td width='5%' align='center'><b>Approved Qty</b>");
					sb.append("</td>");

					sb.append("<td width='5%' align='center'><b>Issued Qty</b>");
					sb.append("</td>");

					sb.append("</tr>");

					while (ws.next()) {
						
						if(i==0)
						{
//							Available_Qty = Integer.parseInt(ws.getString(4));
							Indent_Qty = (int) Double.parseDouble(ws.getString(6));
							Approved_Qty = (int) Double.parseDouble(ws.getString(7));
							Issued_Qty = (int) Double.parseDouble(ws.getString(8));

						}
						else
						{
//							Available_Qty = Available_Qty + Double.parseDouble(ws.getString(4));
							Indent_Qty = (int) (Indent_Qty + Double.parseDouble(ws.getString(6)));
							Approved_Qty = (int) (Approved_Qty + Double.parseDouble(ws.getString(7)));
							Issued_Qty = (int) (Issued_Qty + Double.parseDouble(ws.getString(8)));
						}

						sb.append("<tr>");

						sb.append("<td  width='10%' align='center' >");
						sb.append(i); // S No
						sb.append("</td>");


						if ("0".equals(VoObj.getStrStoreId())) {
							sb.append("<td  width='15%' align='left' >");
							sb.append(ws.getString(1)); // Consolidated ALL case - Indenting Store Name 
							sb.append("</td>");
						}
						
						
						sb.append("<td  width='10%' align='left' >");
						sb.append(ws.getString(4)); // Item Name
						sb.append("</td>");

						sb.append("<td  width='15%' align='left' >");
						sb.append(ws.getString(2)); // Consolidated ALL case - Issuing Store Name 
						sb.append("</td>");
						
						
						sb.append("<td  width='20%' align='center' >");
//						sb.append(ws.getString(4)); // Available Qty
						int availableQty = (int) Double.parseDouble(ws.getString(5).trim());
						sb.append(availableQty);
						
						sb.append("</td>");

						sb.append("<td  width='10%' align='center'>");
//						sb.append(ws.getString(5)); // Indent Qty
						int indentQty = (int) Double.parseDouble(ws.getString(6).trim());
						sb.append(indentQty);
						sb.append("</td>");

						sb.append("<td  width='5%' align='center'>");
//						sb.append(ws.getString(6)); // Approved Qty
						int approvedQty = (int) Double.parseDouble(ws.getString(7).trim());
						sb.append(approvedQty);
						sb.append("</td>");

						sb.append("<td  width='10%' align='center'>");
//						sb.append(ws.getString(7)); // Issued Qty
						int issuedQty = (int) Double.parseDouble(ws.getString(8).trim());
						sb.append(issuedQty);
						sb.append("</td>");

						sb.append("</tr>");
						i++;
					}
					
					sb.append("<tr>");
					
					
					
					if ("0".equals(VoObj.getStrStoreId())) {
						sb.append("<td  colspan='5' align='right'><b> Total : </b>");
						sb.append("</td>");	
						}else {
						sb.append("<td  colspan='4' align='right'><b> Total : </b>");
						sb.append("</td>");	
						}
//					sb.append("<td  colspan='1' align='center'>");
//					sb.append(Available_Qty);								
//					sb.append("</td>");	
					
					sb.append("<td  colspan='1' align='center'>");
					sb.append(Indent_Qty);								
					sb.append("</td>");
					
					sb.append("<td  colspan='1' align='center'>");
					sb.append(Approved_Qty);								
					sb.append("</td>");		
				
					sb.append("<td  colspan='1' align='center'>");
					sb.append(Issued_Qty);								
					sb.append("</td>");	
					
					sb.append("</tr>");
					
					sb.append("</table>");
				} else {
					sb.append(
							"<table align='center' cellspacing='1px' bgcolor='white' cellpadding='1px' border='1px solid black' style='border-collapse:collapse;'>");
					sb.append("<td ><font color='red'>No Record Found</font></td>");
					sb.append("</tr>");
					sb.append("</table>");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			new HisException("Local Purchase Report", "BreakageItemDtlTransHLP.getBreakageDetails()-->",
					e.getMessage());
		}
		// System.out.println("sb"+sb);
		return sb.toString();
	}

}
