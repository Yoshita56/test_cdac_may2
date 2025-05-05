package mms.reports.controller.hlp;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import mms.reports.controller.fb.IssueReceiveLedgerRptFB;
import mms.reports.vo.IssueReceiveLedgerRptVO;

public class IssueReceiveLedgerRptHLP {

	public static String prinRpt(IssueReceiveLedgerRptVO vo,String
			 reportHeader, HttpServletRequest request,IssueReceiveLedgerRptFB formBean)
			  throws Exception {
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = vo.getStrStockInHandRptWS();

		int i = 1;

		try {

			if (ws != null) {
				 				

					sb.append("<table align='center' cellspacing='1px' cellpadding='1px' border='0'>" + " <tr> "
						+ "<td align='center' colspan='4'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='3'>" + "<b>"
						+ "Issue Receive Ledger Report" + "</b>" + "</font></td>"
						+   "</tr>"
						
						+ " <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Store ::<b>"
						+ vo.getStrStoreName() + "</b></font></td><td align='center' colspan='2'></td></tr>");
					
					if(vo.getStrReportTypeId().equals("1")) {
						sb.append(" <tr><td align='center' colspan='3'></td> "
								+"<td align='center' colspan='3'>"
								+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + " For Date ::<b>"
								+formBean.getStrSelectedDate()+ "</b></font></td><td align='center' colspan='2'></td></tr>");
					}
					else {
						sb.append(" <tr><td align='center' colspan='3'></td> "
								+"<td align='center' colspan='3'>"
								+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + " For Month ::<b>"
								+vo.getStrReportMonthName()+ "</b></font></td><td align='center' colspan='2'></td></tr>");
						
						sb.append(" <tr><td align='center' colspan='3'></td> "
								+"<td align='center' colspan='3'>"
								+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + " For Year ::<b>"
								+vo.getStrFYId()+ "</b></font></td><td align='center' colspan='2'></td></tr>");
					}
					
					sb.append(" <tr><td align='center' colspan='3'></td> "
						+"<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Report Date & Time ::<b>"
						+formBean.getStrCurrentDate()+ "</b></font></td><td align='center' colspan='2'></td></tr>" +
						"</table> ");
				if (ws.size() != 0) 
				{
					
					sb.append(
							"<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
					sb.append("<tr>");
					
					sb.append("<td width='5%' align='center'><b>S No.</b>");
					sb.append("</td>");
					
					sb.append("<td width='35%' align='center'><b>Drug/Item Name</b>");
					sb.append("</td>");
					
					sb.append("<td width='15%' align='center'><b>Transactions Count</b>");
					sb.append("</td>");

					sb.append("<td width='15%' align='center'><b>Issue</b>");
					sb.append("</td>");
					
					sb.append("<td width='15%' align='center'><b>Receive</b>");
					sb.append("</td>");
					
					sb.append("<td width='15%' align='center'><b>In-Hand Qty</b>");
					sb.append("</td>");

					sb.append("</tr>");

					while (ws.next()) 
					{
						/*
		                1.year,
						2.month,
						3.month_name,
						4.item_name,
						5.total_transactions,
						6.total_issued,
						7.total_received,
						8.total_consumed,
						9.avg_rate,
						10.total_stock_in_hand,
						11.inhand_qty,
						12.hidden_id  [hstnum_store_id^hstnum_item_id^hstnum_itembrand_id]
						*/
						
						sb.append("<tr>");
						sb.append("<input type='hidden' name='hiddenValueId' id='strCheckHidValue" + i + "' value='" + ws.getString(12) + "'>");
						sb.append("<td  width='5%' align='center' ><b>");
						sb.append(i+".");
						sb.append("</b></td>");
			
						sb.append("<td  width='35%' align='left' >");
						sb.append(ws.getString(4));
						sb.append("</td>");
						
						sb.append("<td  width='15%' align='center'>");
						sb.append(ws.getString(5));
						sb.append("</td>");
						
						sb.append("<td  width='15%' align='center'>");
						sb.append(ws.getString(6));
						sb.append("</td>");
						
						sb.append("<td  width='15%' align='center'>");
						sb.append(ws.getString(7));
						sb.append("</td>");
						
						sb.append("<td  width='15%' align='center'>");
						sb.append(ws.getString(10));
						sb.append("</td>");
						
						sb.append("</tr>");
						i++;
					}

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
			new HisException("Reorder Level Report", "ReorderLevelBhuvRptHLP.prinRpt()-->", e.getMessage());
		}
		return sb.toString();
	}
}


