package mms.reports.controller.hlp;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.controller.fb.ReorderLevelBhuvRptFB;
import mms.reports.vo.ReorderLevelBhuvRptVO;

public class ReorderLevelBhuvRptHLP {

	public static String prinRpt(ReorderLevelBhuvRptVO vo,String
			 reportHeader, HttpServletRequest request,ReorderLevelBhuvRptFB formBean)
			  throws Exception {
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = vo.getStrStockInHandRptWS();

		int i = 1;

		try {

			if (ws != null) {
				 				

					sb.append("<table align='center' cellspacing='1px' cellpadding='1px' border='0'>" + " <tr> "
						+ "<td align='center' colspan='4'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='3'>" + "<b>"
						+ "Re-order Level Report" + "</b>" + "</font></td>"
						+   "</tr>"
						
						+ " <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Store Name ::<b>"
						+ vo.getStrStoreName() + "</b></font></td><td align='center' colspan='2'></td></tr>"

						+ " <tr><td align='center' colspan='3'></td> "
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
					
					sb.append("<td width='40%' align='center'><b>Drug/Item Name</b>");
					sb.append("</td>");
					
					sb.append("<td width='20%' align='center'><b>Last 30 Days Consump</b>");
					sb.append("</td>");

					sb.append("<td width='20%' align='center'><b>Re-order Level</b>");
					sb.append("</td>");
					
					sb.append("<td width='15%' align='center'><b>Stock</b>");
					sb.append("</td>");

					sb.append("</tr>");

					while (ws.next()) 
					{
						/*
		                1.ITEM_NAME
					    2.STORE_NAME
					    3.LAST_30DAYS_CONSUMPTION            
					    4.REORDERLEVEL  
					    5. Stock
					  */
						
						sb.append("<tr>");
						sb.append("<td  width='5%' align='center' ><b>");
						sb.append(i+".");
						sb.append("</b></td>");
			
						sb.append("<td  width='40%' align='left' >");
						sb.append(ws.getString(1));
						sb.append("</td>");
						
						sb.append("<td  width='20%' align='center'>");
						sb.append(ws.getString(3));
						sb.append("</td>");
						
						sb.append("<td  width='20%' align='center'>");
						sb.append(ws.getString(4));
						sb.append("</td>");
						
						sb.append("<td  width='15%' align='center'>");
						sb.append(ws.getString(5));
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


