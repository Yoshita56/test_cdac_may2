package mms.reports.controller.hlp;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import mms.reports.vo.NewConsLedgerRptVO;

public class NewConsLedgerRptHLP {

	public static String generateReport(NewConsLedgerRptVO vo) {
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = vo.getReportDataWS();
		int i = 1;

		try {

			if (ws != null) {
				if (ws.size() != 0) {
					sb.append(
							"<div id='printRptId' align='right'><img style='cursor: pointer; margin-right :10px;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printReport();' /></div></td>");

					sb.append("<div class='d-flex justify-content-center align-items-center'>"
							// + " <div align='center'><img src='/INVMGM/hisglobal/images/" +
							// vo.getStrLogoName() + "'></div></div>");
							+ " <div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></div>");

					sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
							+ "<tr> " + " <td colspan='3'></td>"
							+ " <td colspan='3'align='center' style='font-size:15px'><b> Item Report (Month-wise)</b></td>"
							+ " <td colspan='3'></td>");
					sb.append("</tr>");

					sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
							+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Search Type ::<b>"
							+ "Store Wise" + "</b></font></td><td align='center' colspan='2'></td></tr>");

					sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
							+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Store Name ::<b>"
							+ vo.getStrStoreName() + "</b></font></td><td align='center' colspan='2'></td></tr>");

					sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
							+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Item Category ::<b>"
							+ vo.getStrItemName() + "</b></font></td><td align='center' colspan='2'></td></tr>");

					sb.append(" <tr> <td align='center' colspan='3'></td>" + "<td align='center' colspan='3'>"
							+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Month ::<b>"
							+ vo.getStrMonth() + "</b> Year Range ::<b>" + vo.getStrYear() + "</b></font></td>"
							+ "<td align='center' colspan='2'>"
							+ "<div id='printid1' class='hidecontrol' style='float:right'>" + "</td></tr>");

					sb.append(" <tr> " + " <td colspan='1'></td>" + " <td colspan='1'></td>"
							+ " <td colspan='1'><br></td>");
					sb.append("</tr>");

					sb.append("</table>");

					sb.append("<style>");
					sb.append(".greenBox{ border: 5px solid green; }");
					sb.append(
							".styled-table { border-collapse: collapse; margin: 25px 0; font-size: 0.9em; font-family: sans-serif; min-width: 400px; box-shadow: 0 0 20px rgba(0, 0, 0, 0.15) !important; }");
					sb.append(
							".styled-table thead tr { background-color: #009879; color: #ffffff; text-align: left; }");
					sb.append(".styled-table th, .styled-table td { padding: 12px 15px; }");
					sb.append(".styled-table tbody tr { border-bottom: 1px solid #dddddd; }");
					sb.append(".styled-table tbody tr:nth-of-type(even) { background-color: #f3f3f3; }");
					sb.append(".styled-table tbody tr:last-of-type { border-bottom: 2px solid #009879; }");
					sb.append("</style>");

					sb.append("<table class='styled-table' width:auto;'>");
					sb.append("<thead>");
					sb.append("<tr>");
					sb.append(
							"<th align='center' 	width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No</b></font>");
					sb.append("</th>");
					sb.append(
							"<th align='center' 	width='40%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font>");
					sb.append("</th>");

					sb.append(
							"<th align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Opening Balance</b></font>");
					sb.append("</th>");
					sb.append(
							"<th align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Recieved Quantity</b></font>");
					sb.append("</th>");
					sb.append(
							"<th align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Quantity</b></font>");
					sb.append("</th>");
					sb.append(
							"<th align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Closing Balance</b></font>");
					sb.append("</th>");
					sb.append("</tr>");
					sb.append("</thead>");

					/*
					 * // if(vo.getStrMonth()=="Select a month") // { // //
					 * /reports/stockledgerForSubStoresItemnew_mmsrpt.jsp --> take the help of these
					 * files // /reports/stockledgerForSubStoresItemnew_mmsrpt.jsp
					 * chkBoxClick(this,count); --> maybe an ajax function call
					 * 
					 * }
					 */

					while (ws.next()) {

						String strItemBrand = ws.getString(2);
						sb.append("<tr>");
						sb.append(
								"<td   width='5%' align='left' ><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(i); // S.No
						sb.append("</font></td>");

						String brandID = ws.getString(3);
						sb.append(
								"<td  width='40%' align='left' ><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append("<a href=\"#\" onClick='itemNameClick(this,\"" + brandID + "\");'>" + ws.getString(2)
								+ "</a>"); // Item Name
						sb.append("</font></td>");

						sb.append("<td  width='10%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(4)); // Opening Balance
						sb.append("</font></td>");

						sb.append("<td  width='10%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(5)); // Issued Quantity
						sb.append("</font></td>");

						sb.append("<td  width='10%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(6)); // Recieved Quantity
						sb.append("</font></td>");

						sb.append("<td  width='10%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(7)); // Closing Balance
						sb.append("</font></td>");

						sb.append("</tr>");

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
			new HisException("Detailed Report", "NewConsLedgerRptHLP.generateReport()-->", e.getMessage());
		}
		// System.out.println("sb"+sb);
		return sb.toString();
	}

	public static String generateDetailedReport(NewConsLedgerRptVO vo) {
		// Code for report to be shown in pop-up

		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = vo.getReportDataWS();
		int i = 1;

		try {

			if (ws != null) {
				if (ws.size() != 0) {
					sb.append("<script>");
					sb.append("function printReport() {")
							.append("document.getElementById('printRptId').style.display = 'none';")
							.append("const contentToPrint = document.getElementById('AckReport').cloneNode(true);")
							.append("const newWin = window.open('', '', 'width=700,height=700,scrollbars=yes');")
							.append("newWin.document.write('<html><head>');")
							.append("newWin.document.write('<title>Issue Detail Report</title>');")
							.append("newWin.document.write('<style type=\"text/css\">") // Escaped double quotes
							.append(".hidecontrol { display: none; }").append("@media print {")
							.append(".styled-table th, .styled-table td{ padding: 12px 15px; }")
							.append(".styled-table{  border-collapse: collapse;  margin: 25px 0; font-size: 0.9em; font-family: sans-serif;  min-width: 400px; box-shadow: 0 0 20px rgba(0, 0, 0, 0.15); }")
							.append(".styled-table thead tr {background-color: #009879; color: #ffffff; text-align: left;}")
							.append("}").append("</style>');").append("newWin.document.write('</head><body>');")
							.append("newWin.document.write(contentToPrint.outerHTML);")
							.append("newWin.document.write('</body></html>');").append("newWin.document.close();")
							.append("newWin.onload = function () { newWin.print(); newWin.close(); document.getElementById('printRptId').style.display = 'block'; };")
							.append("}");

					sb.append("</script>");

					// sb.append("<div id='printRptId' align='right'><img style='cursor: pointer;
					// margin-right :10px;' text-align=right title='Print Page'
					// src='../../hisglobal/images/printer_symbol.gif' onClick='printReport();'
					// /></div>");

//					sb.append("<div class='d-flex justify-content-center align-items-center'>"
//					        //+ " <div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></div>");
//							+ " <div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></div>");

					sb.append(
							"<div id='printRptId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
					sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
					sb.append(
							" src='../../hisglobal/images/printer_symbol.gif' onClick='printReport();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
					sb.append(" src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div>");

					sb.append("<div id='AckReport'>");
					// table content to be printed

					sb.append("<style>");
					sb.append(".greenBox{ border: 5px solid green; }");
					sb.append(
							".styled-table { border-collapse: collapse; margin: 25px 0; font-size: 0.9em; font-family: sans-serif; min-width: 400px; box-shadow: 0 0 20px rgba(0, 0, 0, 0.15) !important; }");
					sb.append(
							".styled-table thead tr { background-color: #009879; color: #ffffff; text-align: left; }");
					sb.append(".styled-table th, .styled-table td { padding: 12px 15px; }");
					sb.append(".styled-table tbody tr { border-bottom: 1px solid #dddddd; }");
					sb.append(".styled-table tbody tr:nth-of-type(even) { background-color: #f3f3f3; }");
					sb.append(".styled-table tbody tr:last-of-type { border-bottom: 2px solid #009879; }");
					sb.append("</style>");

					sb.append(
							"<table class='greenBox' width='50%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
									+ "<tr> " + " <td colspan='3'></td>"
									+ " <td colspan='3'align='center' style='font-size:15px'><b> Item Report (Month-wise)</b></td>"
									+ " <td colspan='3'></td>");
					sb.append("</tr>");

					sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
							+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Search Type ::<b>"
							+ "Store Wise" + "</b></font></td><td align='center' colspan='2'></td></tr>");

					sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
							+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Store Name ::<b>"
							+ vo.getStrStoreName() + "</b></font></td><td align='center' colspan='2'></td></tr>");

					sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
							+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Item Category ::<b>"
							+ vo.getStrItemName() + "</b></font></td><td align='center' colspan='2'></td></tr>");

					sb.append(" <tr> <td align='center' colspan='3'></td>" + "<td align='center' colspan='3'>"
							+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Month ::<b>"
							+ vo.getStrMonth() + "</b> Year Range ::<b>" + vo.getStrYear() + "</b></font></td>"
							+ "<td align='center' colspan='2'>"
							+ "<div id='printid1' class='hidecontrol' style='float:right'>" + "</td></tr>");

					sb.append(" <tr> " + " <td colspan='1'></td>" + " <td colspan='1'></td>"
							+ " <td colspan='1'><br></td>");
					sb.append("</tr>");

					sb.append("</table>");

					sb.append("<table class='styled-table' style='font-size:11px;'>"); // align='center'
																						// cellpadding='1px'
																						// cellspacing='1px' bgcolor=''
																						// border='1px solid black'
																						// style='border-collapse:collapse;
																						// width:auto;
					sb.append("<thead>");
					sb.append("<tr>");
					sb.append(
							"<th align='left' 	width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No</b></font>");
					sb.append("</th>");
					sb.append(
							"<th align='left' 	width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Date & Time</b></font>");
					sb.append("</th>");
					sb.append(
							"<th align='left' 	width='40%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font>");
					sb.append("</th>");

					sb.append(
							"<th align='left' 	width='40%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Particulars</b></font>");
					sb.append("</th>");

					sb.append(
							"<th align='left' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Opening Balance</b></font>");
					sb.append("</th>");
					sb.append(
							"<th align='left' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Recieved Quantity</b></font>");
					sb.append("</th>");
					sb.append(
							"<th align='left' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Quantity</b></font>");
					sb.append("</th>");
					sb.append(
							"<th align='left'	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Closing Balance</b></font>");
					sb.append("</th>");
					sb.append("</tr>");
					sb.append("</thead>");

					/*
					 * // if(vo.getStrMonth()=="Select a month") // { // //
					 * /reports/stockledgerForSubStoresItemnew_mmsrpt.jsp --> take the help of these
					 * files // /reports/stockledgerForSubStoresItemnew_mmsrpt.jsp
					 * chkBoxClick(this,count); --> maybe an ajax function call
					 * 
					 * }
					 */

					while (ws.next()) {

						sb.append("<tr>");
						sb.append(
								"<td   width='5%' align='left' ><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(i); // S.No
						sb.append("</font></td>");

						String str = ws.getString(2); // getting time period from the table colmn
						String dateStr = str.substring(0, 11);

						// re-formatting the date from YYYY-MM-DD --> DD-MM-YYYY. Stored in variable s
						String s = "";
						int k = 10;
						for (int j = 10; j >= 0; j--) {
							char c = dateStr.charAt(j);

							if (c == '-') {
								s = s + dateStr.substring(j + 1, k) + "-";
								k = j;
								System.out.println(
										"date_str= " + dateStr + "  s so far= " + s + "  and k incremented= " + k);
							} else if (j == 0)
								s = s + dateStr.substring(j, k);
						}

						System.out.println(s);
						// StringBuffer date=new StringBuffer(dateStr);
						// date.reverse();
						sb.append("<td  width='20%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(s + " " + str.substring(12, str.length() - 2)); // Date/Duration by month
						sb.append("</font></td>");

						sb.append(
								"<td  width='30%' align='left' ><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(3));
						sb.append("</font></td>"); // Item Name

						sb.append(
								"<td  width='40%' align='left' ><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(5));
						sb.append("</font></td>"); // Particulars

						// sb.append(ws.getString(4)); // item brand ID

						sb.append("<td  width='10%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(6)); // Opening Balance
						sb.append("</font></td>");

						sb.append("<td  width='10%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(7)); // Issued Quantity
						sb.append("</font></td>");

						sb.append("<td  width='10%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(8)); // Recieved Quantity
						sb.append("</font></td>");

						sb.append("<td  width='10%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(9)); // Closing Balance
						sb.append("</font></td>");

						sb.append("</tr>");

						sb.append("</tr>");
						i++;

					}

					sb.append("</table>");

					sb.append("</div>");

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
			new HisException("Issue Detail Report", "NewConsLedgerRptHLP.generateDetailedReport()-->", e.getMessage());
		}
		// System.out.println("sb"+sb);
		return sb.toString();

		// return null;
	}

}
