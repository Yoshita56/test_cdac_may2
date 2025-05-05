package mms.transactions.controller.hlp;

import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

public class ItemTransferTransHLP {
	/**
	 * Gets the issue dtls init view.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the issue dtls init view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getTransferDetails(WebRowSet ws, String strDwhName,HttpServletRequest request)
			throws Exception {

		StringBuffer sb = new StringBuffer("");
		String strTransferNo = "";
		String strTransferDate = "";
		String strTransferTo = "";
		String strRemarks = "";
		String strReceivedBy = "";
		
		HttpServletRequest objRequest;

		double cltamt = 0.00;
		double totalCost = 0.00;

		int i = 1;
		String strItemTotCost = "0.00";
		HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");

		ResourceBundle res = mms.qryHandler_mms.res;
		if (res == null) {
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}

		String strTableWidth = "700";

		try {
			
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			//System.out.println("hospitalVO.getAddress1()"+hospitalVO.getHospitalName());
			//System.out.println("the ws length isa  "+ws.getKeyColumns());
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			//sb.append(res.getString("REPORT_TITLE"));
			sb.append(hospitalVO.getHospitalName());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			sb.append(((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()))+"");
			//sb.append(res.getString("FULL_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			//sb.append(hospitalVO.getCity());
			//sb.append(res.getString("CITY"));
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> Drug Transfer Voucher");
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");

			/*sb
					.append("<table align='center' width='")
					.append(strTableWidth)
					.append(
							"' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb
					.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("REPORT_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb
					.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("FULL_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb
					.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("CITY"));
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb
					.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> Drug Transfer Voucher");
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			//			
			// sb.append("<tr> ");
			// sb.append("<td width='8%'>&nbsp;</td> ");
			// sb.append("<td width='82%' align='center'> <b><font
			// face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			// sb.append(strDwhName);
			// sb.append("</font></b></td><td width='10%'>&nbsp; ");
			// sb.append("</td> ");
			// sb.append("</tr> ");

			sb.append("</table> ");*/

			sb
					.append(
							"<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
					.append(strTableWidth).append("'></table> ");
			sb
					.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb
					.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataForTransfer();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb
					.append(" src='../../hisglobal/images/stop.png' onClick='hideTransferPopup();' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");

			sb.append("<table width='").append(strTableWidth).append(
					"' align='center' cellpadding='1px' cellspacing='1px'> ");

			/*
			 * 1. Transfer No 2. Transfer Date 3. Transfer To 4. Issuing Store
			 * Name 5. Generic Name 6. Brand Name 7. Batch No 8. Expiry date 9.
			 * Transfer Qty 10. Store ID 11. Item id 12. Item Brand Id 13. Rate
			 * With Unit 14. Base Value 15. Trnasfer Qty 16. Transfer Qty Unit
			 * 17. Qty Base Value 18. Item Sl No 19. Item Sl No 20. Item Catg
			 * Code 21. Remarks 22. Receive By 23. Cost
			 */

			if (ws != null && ws.size() > 0) {

				while (ws.next()) {
					strTransferNo = ws.getString(1);
					strTransferDate = ws.getString(2);
					strTransferTo = ws.getString(3);
					strRemarks = ws.getString(21);
					strReceivedBy = ws.getString(22);

				}
				ws.beforeFirst();

				sb.append("<tr> ");

				sb
						.append(
								"<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(util.appendSpace("Transfer No.", 15, 0))
						.append(":</b></font></td> ");
				sb
						.append(
								"<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(strTransferNo).append("</b></font></td> ");

				sb
						.append(
								"<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(util.appendSpace("Transfer Date", 15, 0))
						.append(":</b></font></td> ");
				sb
						.append(
								"<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(strTransferDate).append("</b></font></td> ");
				sb.append("</tr> ");

				sb.append("<tr> ");

				sb
						.append(
								"<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(util.appendSpace("From Store", 15, 0)).append(
								":</b></font></td> ");
				sb
						.append(
								"<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(strDwhName).append("</b></font></td> ");

				sb
						.append(
								"<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(util.appendSpace("To Store", 15, 0)).append(
								":</b></font></td> ");
				sb
						.append(
								"<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(strTransferTo).append("</b></font></td> ");
				sb.append("</tr> ");

				sb
						.append("<table width='")
						.append(strTableWidth)
						.append(
								"' align='center' cellpadding='1px' cellspacing='1px'> ");

				sb.append("<tr bgcolor='#cdc9c9'> ");
				sb
						.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
				sb.append("</td>");

				sb
						.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font> ");
				sb.append("</td>");

				sb
						.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font> ");
				sb.append("</td> ");
				sb
						.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font>");
				sb.append("</td> ");
				sb
						.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font> ");
				sb.append("</td> ");
				sb
						.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Transfer Qty</b></font> ");
				sb.append("</td> ");
				sb
						.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font> ");
				sb.append("</td> ");

				sb.append("</tr> ");
				while (ws.next()) {
					NumberFormat formatter = new DecimalFormat(
							"############.##");
					strItemTotCost = formatter.format(new BigDecimal(ws
							.getString(23)));
					cltamt = Double.parseDouble(strItemTotCost);
					totalCost = totalCost + cltamt;
					sb.append("<tr> ");
					sb
							.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(i);
					sb.append("</font></td> ");

					sb
							.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(6));
					sb.append("</font></td> ");

					sb
							.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(7));
					sb.append("</font></td> ");
					sb
							.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(8));
					sb.append("</font></td> ");
					sb
							.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(13));
					sb.append("</font></td> ");
					sb
							.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(9));
					sb.append("</font></td> ");
					sb
							.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(23));
					sb.append("</font></td> ");

					sb.append("</tr> ");
					i++;

				}
				NumberFormat formatter = new DecimalFormat("############.##");

				String FinaltotalCost = formatter.format(new BigDecimal(
						totalCost));

				sb.append("<tr>");
				sb
						.append("<td colspan='6' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
				sb
						.append("<td colspan='1' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append(FinaltotalCost);
				sb.append("</font></td>");
				sb.append("</tr>");

				sb.append("<tr> ");
				sb
						.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
				sb
						.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");
				if (!strRemarks.equals("") || !strRemarks.equals(" ")
						|| !strRemarks.equals(null)) {
					sb.append(strRemarks);
				} else {
					sb.append("--------");
				}
				sb.append("<br></font></td>");
				sb.append("</tr> ");

				sb.append("<tr> ");
				sb
						.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb
						.append(
								"<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>(")
						.append(strReceivedBy).append(
								")<b> &nbsp;&nbsp;</font></td> ");
				sb.append("</tr> ");

			} else {

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
