package mms.reports.controller.hlp;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import org.omg.CORBA.INTERNAL;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.MmsConfigUtil;
import mms.reports.controller.fb.IssueTrackRptFB;
import mms.reports.vo.IssueTrackRptVO;
import mms.transactions.vo.IssueDeskTransVO;

public class IssueTrackRptHLP {
	
	//report
	public static String getIssueTrackDetails(IssueTrackRptVO voObj) {
		StringBuffer sb = new StringBuffer("");

		WebRowSet ws = voObj.getWsBreakageDtlRpt();

		int i = 1;
		double totamt1 = 0.00;
		double totamt2 = 0.00;
		int Quantity1 = 0;
		int Quantity2 = 0;

		try {
			if (ws != null) {
//				sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
//						+ "<tr> " + " <td colspan='1'></td>" + " <td colspan='1'></td>"
//						+ " <td colspan='1'><br><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne(1);' /></div></td>");
//				sb.append("</tr>");

				sb.append("<tr> " + " <td colspan='1'></td>"
						+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></td>" + " <td colspan='1'></td>");
				sb.append("</tr></table>");

				sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + "<tr> "
						+ " <td colspan='3'></td>"
						+ " <td colspan='3'align='center' style='font-size:15px'><b>Issue Tracking Report</b></td>"
						+ " <td colspan='3'></td>");
				sb.append("</tr>");

				sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Store Name ::<b>"
						+ voObj.getStrStoreName() + "</b></font></td><td align='center' colspan='2'></td></tr>");

				sb.append(" <tr> <td align='center' colspan='3'></td>" + "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "From Date ::<b>"
						+ voObj.getStrStartDate() + "</b> To Date ::<b>" + voObj.getStrEndDate() + "</b></font></td>"
						+ "<td align='center' colspan='2'>"
						+ "<div id='printid1' class='hidecontrol' style='float:right'>" + "</td></tr>");

				// sb.append("<tr><div align='center'>[<font><span style='color:#f3bdbd;'><i
				// class='fas fa-certificate' ></i></span>Below 40%</font>] [<font><span
				// style='color:#ffd382;'><i class='fas fa-certificate' ></i></span>40% to
				// 70%</font>] [<font><span style='color:#91c091;'><i class='fas fa-certificate'
				// ></i></span>70% to 100%</font>]</div></tr> ");

				sb.append(
						" <tr> " + " <td colspan='1'></td>" + " <td colspan='1'></td>" + " <td colspan='1'><br></td>");
				sb.append("</tr>");

				sb.append("</table>");

				if (ws.size() != 0) {
					sb.append(
							"<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
					sb.append("<tr>");

					sb.append("<td width='10%' align='center'><b>S.No</b>");
					sb.append("</td>");

					sb.append("<td width='20%' align='center'><b>Store Name</b>");
					sb.append("</td>");
					
					sb.append("<td width='10%' align='center'><b>Supplier Receipt Count</b>");
					sb.append("</td>");
					
					sb.append("<td width='10%' align='center'><b>Issue Voucher Count</b>");
					sb.append("</td>");

					sb.append("<td width='15%' align='center'><b>Issue Voucher Amount</b>");
					sb.append("</td>");

					sb.append("<td width='10%' align='center'><b>Receive Voucher Count</b>");
					sb.append("</td>");

					sb.append("<td width='15%' align='center'><b>Receive Voucher Amount</b>");
					sb.append("</td>");

					sb.append("<td width='10%' align='center'><b>Percent (%)</b>");
					sb.append("</td>");

					sb.append("</tr>");

					while (ws.next()) {
						if (i == 0) {
							Quantity1 = Integer.parseInt(ws.getString(1));
							totamt1 = Double.parseDouble(ws.getString(3));

							Quantity2 = Integer.parseInt(ws.getString(2));
							totamt2 = Double.parseDouble(ws.getString(4));
						} else {
							Quantity1 = Quantity1 + Integer.parseInt(ws.getString(1));
							totamt1 = totamt1 + Double.parseDouble(ws.getString(3));

							Quantity2 = Quantity2 + Integer.parseInt(ws.getString(2));
							totamt2 = totamt2 + Double.parseDouble(ws.getString(4));

						}
						
						
						String strReqStoreId = ws.getString(7);
						sb.append("<input type='hidden' name='strReqStoreId' id='strReqStoreId" + i + "' value='"
								+ strReqStoreId + "' />");
						
						
						String value = ws.getString(5);
						String percentageString = value.substring(0, value.length() - 1); // Removed "%" at end
						int percentage = Integer.parseInt(percentageString);

						if (percentage >= 70) {
							sb.append("<tr style='background-color:#91c091;'>"); // green
						} else if (percentage >= 40) {
							sb.append("<tr style='background-color:#ffd382;'>"); // yellow
						} else if (percentage < 40) {
							sb.append("<tr style='background-color:#f3bdbd;'>"); // red
						} else {
							sb.append("<tr  style='background-color: white;'>");
						}
						
						// sb.append("<tr>");
						sb.append("<td  width='10%' align='center' ><b>");
						sb.append(i); // S.No
						sb.append("</b></td>");

						sb.append("<td  width='20%' align='center' >");
						sb.append(ws.getString(6)); // Store Name
						sb.append("</td>");
						
						sb.append("<td  width='10%' align='center' >");
						sb.append("<a style='color:blue;cursor: pointer;' onclick='getVoucher(" + i + ", 2);'>"
								+ 0);// Supplier Receipt Count
						sb.append("</td>");
						
						sb.append("<td  width='10%' align='center' >");
						sb.append("<a style='color:blue;cursor: pointer;' onclick='getVoucher(" + i + ", 2);'>"
								+ ws.getString(1));// Issue Voucher Count
						sb.append("</td>");

						sb.append("<td  width='15%' align='right'>");
						sb.append(ws.getString(3)); // Issue Voucher Amount
						sb.append("</td>");

						//sb.append("<td  width='15%' align='center'>");
						//sb.append(ws.getString(2)); // Receive Voucher Count
						//sb.append("</td>");
						
						sb.append("<td  width='10%' align='center' >");
						sb.append("<a style='color:blue;cursor: pointer;' onclick='getVoucher(" + i + ", 1);'>"
								+ ws.getString(2));// Receive Voucher Count
						sb.append("</td>");


						sb.append("<td  width='15%' align='right'>");
						sb.append(ws.getString(4)); // Receive Voucher Amount
						sb.append("</td>");

						sb.append("<td  width='15%' align='center'>");
						sb.append(ws.getString(5)); // Percent %
						sb.append("</td>");

						sb.append("</tr>");
						i++;
					}

					sb.append("<tr>");

					sb.append("<td  colspan='2' align='right'><b> Total : </b>");
					sb.append("</td>");
					
					sb.append("<td  colspan='1' align='center'>");
					sb.append(0);
					sb.append("</td>");
					
					sb.append("<td  colspan='1' align='center'>");
					sb.append(Quantity1);
					sb.append("</td>");

					sb.append("<td  colspan='1' align='right'>");
					sb.append(String.format("%.2f", totamt1));
					sb.append("</td>");

					sb.append("<td  colspan='1' align='center'>");
					sb.append(Quantity2);
					sb.append("</td>");

					sb.append("<td  colspan='1' align='right'>");
					sb.append(String.format("%.2f", totamt2));
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
	//voucher
	public static String getIndentDetailsPrint(IssueTrackRptVO voObj) {
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = voObj.getStrIndentDetailsWs();
		int i=1;
		try {
			String report_name = "Issue Tracking Report";
			if(voObj.getStrCmodeId()!=null && voObj.getStrCmodeId().equals("1")) {
				report_name+=" [ Receive ]";
			}
			else if(voObj.getStrCmodeId()!=null && voObj.getStrCmodeId().equals("2")) {
				report_name+=" [ Issue ]";
			}
			if (ws != null && ws.size() != 0) {
				
				sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");

//				sb.append("<tr> " + " <td colspan='1'></td>"
//						+ " <td colspan='1'></td>" 
//						+ " <td colspan='1'><div id='printImg' align='right'>"
//						+ "<img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne(1);' />"
//						//+ "<img style='cursor: pointer;'  text-align=right  title='Go Back' src='../../hisglobal/images/arrdouble-left.png' onClick='goBack();' />"
//						+ "</div></td>"
//						+ " </tr>");
				
				sb.append("<tr> " + " <td colspan='1'></td>"
						+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></td>" + " <td colspan='1'></td></tr>");
				
				sb.append("</table>");

				sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + "<tr> "
						+ " <td colspan='3'></td>"
						+ " <td colspan='3'align='center' style='font-size:15px'><b>"+report_name+"</b></td>"
						+ " <td colspan='3'></td>");
				sb.append("</tr>");

				sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Store Name ::<b>"
						+ voObj.getStrStoreName() + "</b></font></td><td align='center' colspan='2'></td></tr>");

				sb.append(" <tr> <td align='center' colspan='3'></td>" + "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "From Date ::<b>"
						+ voObj.getStrStartDate() + "</b> To Date ::<b>" + voObj.getStrEndDate() + "</b></font></td>"
						+ "<td align='center' colspan='2'>"
						+ "<div id='printid1' class='hidecontrol' style='float:right'>" + "</td></tr>");

				sb.append(
						" <tr> " + " <td colspan='1'></td>" + " <td colspan='1'></td>" + " <td colspan='1'><br></td>");
				sb.append("</tr>");

				sb.append("</table>");
				
				sb.append("<table width='100%' class='table' border='1px'>");
				sb.append("<thead >");
				sb.append("<tr>");
				sb.append(
						"<th width='10%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;'' >Issue <br> No</th>");
				sb.append(
						"<th width='5%'  style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;' >Passed <br> Days</th>");
				sb.append(
						"<th width='15%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;' >Indent <br> Store</th>");
				sb.append(
						"<th width='20%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;' >Indent No <br> [Indent Date]</th>");
				sb.append(
						"<th width='15%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;'' >Issuing <br> Store Name</th>");
				sb.append(
						"<th width='15%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;'' >Receive By</th>");
				sb.append(
						"<th width='10%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;'' >Issued By</th>");
				sb.append("</tr></thead>");
				sb.append("<tbody>");

				while (ws.next()) {
					/* RJ47
					 * DATA BASE Indexing 
					 * 1.Issue No  2.Pass days   3. Indent Store  4.Indent No Date   5.Issue store name  6.Receive by  7.Issued by 
					 * 8.Hidden ID [hstnum_issue_no @ HSTNUM_STORE_ID @ HSTNUM_INDENT_NO @ HSTNUM_REQ_STOREID]
					 */

//					String value = ws.getString(2);
//					double passcount = Double.parseDouble(value);
//					int passcountInt = (int) passcount;
//
//					if (passcountInt <= 2) {
//						sb.append("<tr style='background-color:#91c091;'>"); // green
//					} else if (passcountInt > 2 && passcountInt <= 7) {
//						sb.append("<tr style='background-color:#ffd382;'>"); // yellow
//					} else if (passcountInt > 7) {
//						sb.append("<tr style='background-color:#f3bdbd;'>"); // red
//					} else {
//						sb.append("<tr  style='background-color: white;'>");
//					}
					if(voObj.getStrCmodeId()!=null && voObj.getStrCmodeId().equals("2")) {
						if(ws.getString(6).toUpperCase().equals("pending".toUpperCase())) {
							sb.append("<tr style='background-color:#f3bdbd;'>");
						}
						else {
							sb.append("<tr style='background-color:#91c091;'>");
						}
					}
					else {
						sb.append("<tr>");
					}
					
					
					sb.append("<td width='15%' hidden>");
					sb.append("<input id='rowHiddenDetails"+i+"' value='"+ws.getString(8)+"'/>");
					sb.append("<input id='issueBy"+i+"' value='"+ws.getString(7)+"'/>");
					sb.append("<input id='receiveBy"+i+"' value='"+ws.getString(6)+"'/>");
					sb.append("</td>");
					// sb.append("<tr>");
					sb.append("<td  width='10%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append("<a style='color:blue;cursor: pointer;' onclick='getIndentDtlsForRow("+i+","+voObj.getStrCmodeId()+");'>");
					sb.append(ws.getString(1));
					sb.append("</a>");
					sb.append("</td>");
					sb.append("</td>");

					sb.append("<td width='5%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append(ws.getString(2));
					sb.append("</td>");

					sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append(ws.getString(3));
					sb.append("</td>");

					sb.append("<td width='20%' style='font-weight:350 !important; font-size: 14px !important;'>");
					sb.append(ws.getString(4).split("\\[")[0].trim());  // Display the Indent No
					sb.append("<br>");
					sb.append("[ " + ws.getString(4).split("\\[")[1].replace("]", "").trim() + " ]");  // Display the date with square brackets
					sb.append("</td>");

					sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append(ws.getString(5));
					sb.append("</td>");

					sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append(ws.getString(6));
					sb.append("</td>");

					sb.append("<td width='10%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append(ws.getString(7));
					sb.append("</td>");
					sb.append("</tr>");
					i++;
				}
			} else {
				sb.append("<tr>");
				sb.append("<td colspan='5' ><DIV class='errMsg' align='center'> NO MATCHING RECORD FOUND </div></td>");
				sb.append("</tr>");
			}
			sb.append("</tbody>");
			sb.append("</table>");
			if(voObj.getStrCmodeId()!=null && voObj.getStrCmodeId().equals("2")) {
				sb.append("<div id='legendsId' class='modal-footer' align='center'>"
						+ "<font>&nbsp;Acknowledge &nbsp; </font>"
						+ "[<font><span style='color:#f3bdbd;'><i class='fas fa-certificate' ></i></span>&nbsp;Pending </font>] "
						+ "[<font><span style='color:#91c091;'><i class='fas fa-certificate' ></i></span>&nbsp;Done </font>] "
						+ "</div>");
			}
			

		} catch (Exception e) {

			voObj.setStrMsgString("IssueTrackRptHLP.getIndentDetailsPrint() --> " + e.getMessage());
			voObj.setStrMsgType("1");
		}
		return sb.toString();
	}

	//old voucher style of printing 
	public static String getIssueDtlsInit(IssueTrackRptFB formBean, IssueTrackRptVO voObj) throws Exception {

		StringBuffer sb = new StringBuffer("");
		String strIssueBy = "";
		String strRecivedBy = "";
		String strPurchaseCost = "";
		String strRemarks = "";
		double cltamt = 0.00;
		double totalCost = 0.00;
		double cltamt1 = 0.00;
		double totalCostWithoutSC = 0.00;
		String strStoreName = "";
		String returnTo = "";
		int i = 1;
		String strItemTotCost = "0.00";
		String strItemTotCostWithOutSC = "0.00";
		String strBudgetUsed = "0.00";
		HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");

		ResourceBundle res = mms.qryHandler_mms.res;
		if (res == null) {
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}

		MmsConfigUtil mmscofigutil = new MmsConfigUtil(formBean.getStrHospitalCode());

		String configIssueRate = mmscofigutil.getStrConfigIssueRate();
		DecimalFormat myFormatter = new DecimalFormat("0.00");

		// WebRowSet ws = formBean.getWsIssueDetails();

		String strIssueDate = "";

		String strTableWidth = "825";

		try {
			HisUtil hisUtil = new HisUtil("Global", "ReportUtil");
			
			HospitalMstVO hospitalVO = hisUtil.getHospitalDetail(formBean.getStrHospitalCode());

			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			/*
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(hospitalVO.getHospitalName());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'><b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			sb.append(((hospitalVO.getAddress1() == "" || hospitalVO.getAddress1() == null) ? " "
					: (hospitalVO.getAddress1() + ","))
					+ ((hospitalVO.getAddress2() == "" || hospitalVO.getAddress2() == null) ? " "
							: (hospitalVO.getAddress2() + ","))
					+ ((hospitalVO.getCity() == "" || hospitalVO.getCity() == null) ? " "
							: (hospitalVO.getCity() + ","))
					+ ((hospitalVO.getPinCode() == "" || hospitalVO.getPinCode() == null) ? " "
							: (hospitalVO.getPinCode()))
					+ "");
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			*/
			sb.append("<tr> " + " <td colspan='1'></td>"
					+ " <td colspan='3'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></td><td colspan='1'></td>");
			sb.append("</tr></table>");
			
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			
			sb.append("</table> ");

			sb.append("<TABLE class='table table-striped' ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='").append(strTableWidth)
			.append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>Issue Track Details</b></font></td></tr></table> ");

			/*
			 * if (formBean.getStrStoreName().length() != 0) { if (!"3".equals("4")) {
			 * sb.append(
			 * "<TABLE class='table' ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='"
			 * ) .append(strTableWidth)
			 * .append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>("
			 * )
			 * .append(formBean.getStrStoreName()).append(")</b></font></td></tr></table>");
			 * } else { sb.
			 * append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='"
			 * ) .append(strTableWidth)
			 * .append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>Acknowledging Store : "
			 * )
			 * .append(formBean.getStrStoreName()).append("</b></font></td></tr></table>");
			 * }
			 * 
			 * }
			 */
			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
			sb.append(
					"<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(
					" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne(2);' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(
					" src='../../hisglobal/images/stop.png' onClick='hideIssuePopup(),cancelToDesk();' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			
			sb.append(" <br> ");
			sb.append("<table width='").append(strTableWidth)
					.append("' align='center' cellpadding='1px' cellspacing='1px'> ");

			if (!"3".equals("5") && !"3".equals("6")) {

				sb.append("<tr> ");

				sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(util.appendSpace("Issue No. :", 15, 0)).append("3").append("</b></font></td> ");

				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(util.appendSpace("Issue Date", 15, 0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(strIssueDate).append("</b></font></td> ");
				sb.append("</tr> ");

				if (!"0".equals("0")) {
					sb.append("<tr> ");
					sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
							.append(util.appendSpace("Request No. :", 15, 0)).append("3").append("</b></font></td> ");

					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
							.append(util.appendSpace("Request Date", 15, 0)).append(":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("3")
							.append("</b></font></td> ");
					sb.append("</tr> ");

				}

				sb.append("<tr> ");
				sb.append("<td width='50%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(util.appendSpace("Issue To. :", 15, 0)).append("3").append("</b></font></td> ");

				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(util.appendSpace("", 15, 0)).append("</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td> ");
				sb.append("</tr> ");

				sb.append("<tr><TD COLSPAN='4'>&nbsp;</td></tr>");

			}sb.append("</table> ");
			
			

			sb.append("<table width='").append(strTableWidth)
					.append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append(
					"<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue No</b></font> ");
			sb.append("</td>");

			sb.append(
					"<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Passed Days</font> ");
			sb.append("</td>");

			sb.append(
					"<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Indent Store</b></font> ");
			sb.append("</td> ");

			sb.append(
					"<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Indent No[Indent Date]</b></font>");
			sb.append("</td> ");

			sb.append(
					"<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Store Name</b></font> ");
			sb.append("</td> ");

			sb.append(
					"<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Receive By</b></font> ");
			sb.append("</td> ");

			sb.append(
					"<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued By</b></font>");
			sb.append("</td> ");

			sb.append("</tr> "); 

			/*
			 * if (ws != null && ws.size() > 0) { System.out.println("data size"+
			 * ws.size()); while (ws.next()) {
			 * 
			 * Total 33 Value Return In Case of ModeVal 8 (Which Call in Case of Off-Line
			 * Issue Voucher) 1.Issue No 2.Issue Date 3.Issue To 4.Issue By 5.Generic Name
			 * 6.Brand Name 7.Batch No 8.Expiry date 9.Issue rate 10.Issue Qty 11.Store Id
			 * 12.Item Id 13.Item Brand ID 14.Batch No 15.Expiry Date 16.Issue Rate 17.Issue
			 * Rate Unit Id 18.Issue Rate Base Unit Id 19.Issue Qty 20.Issue Qty Unit Id
			 * 21.Issue Qty Base Value 22.Item Sl No 23.Item SL No 24,Category Code 25.Issue
			 * Qty 26.Remarks 27.Final remarks 28.Received By 29.Cost 30.Total Avl Budget
			 * 31.Indent No 32.Indent Date 33.Purchase Rate With Unit e.g 101 No. 34.Purchae
			 * Code 35.Location 36.Balance Qty 37.hstnum_saleprice 38.hstnum_TAX
			 * 
			 * 
			 * NumberFormat formatter = new DecimalFormat("############.##");
			 * 
			 * 
			 * strStoreName = ws.getString(4); strRemarks = ws.getString(27); strRecivedBy =
			 * ws.getString(28); strItemTotCost = ws.getString(29);
			 * 
			 * strPurchaseCost = ws.getString(33); // With Unit Like e.g. 161 No.
			 * 
			 * strItemTotCost = formatter.format(new BigDecimal(ws.getString(29)));
			 * strItemTotCostWithOutSC = formatter.format(new BigDecimal(ws.getString(34)));
			 * 
			 * 
			 * 
			 * 
			 * cltamt1 = Double.parseDouble(strItemTotCostWithOutSC);
			 * 
			 * totalCostWithoutSC = totalCostWithoutSC + cltamt1; //Calculate Total Cost
			 * Without Service Charge
			 * 
			 * cltamt = Double.parseDouble(strItemTotCost);
			 * 
			 * totalCost = totalCost + cltamt; //Calculate Total Cost With Service Charge
			 * 
			 * sb.append("<tr> "); sb.
			 * append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"
			 * ); sb.append(i); sb.append("</b></font></td> ");
			 * 
			 * 
			 * sb.
			 * append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>"
			 * ); sb.append(ws.getString(6)); sb.append("</b></font></td> ");
			 * 
			 * sb.
			 * append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"
			 * ); sb.append(ws.getString(7)); sb.append("</font></td> "); sb.
			 * append("<td align='center' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >"
			 * ); sb.append(ws.getString(8));//debug sb.append("</font></td> "); sb.
			 * append("<td style=\"text-align:center;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >"
			 * ); sb.append(ws.getString(9)); sb.append("</font></td> ");
			 * 
			 * sb.
			 * append("<td style=\"text-align:center;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >"
			 * ); sb.append(ws.getString(38)); sb.append("</font></td> ");
			 * 
			 * 
			 * sb.
			 * append("<td style=\"text-align:center;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >"
			 * ); sb.append(ws.getString(10)); sb.append("</font></td> ");
			 * 
			 * if(!formBean.getStrModeVal().equals("3") &&
			 * !formBean.getStrModeVal().equals("5") ) {
			 * 
			 * 
			 * sb.
			 * append("<td style=\"text-align:right;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >"
			 * ); sb.append(myFormatter.format(new BigDecimal(strItemTotCost)));
			 * //myFormatter.format(Double.parseDouble(ws.getString(6)))
			 * sb.append("</font></td> "); } if(formBean.getStrModeVal().equals("5")) {
			 * 
			 * sb.
			 * append("<td style=\"text-align:right;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >"
			 * ); sb.append(myFormatter.format(new Float(ws.getString(10).split(" ")[0])*new
			 * Float(ws.getString(9).split("/")[0])));
			 * //myFormatter.format(Double.parseDouble(ws.getString(6)))
			 * sb.append("</font></td> "); } sb.append("</tr> "); i++;
			 * 
			 * }
			 * 
			 * if(!formBean.getStrModeVal().equals("3") &&
			 * !formBean.getStrModeVal().equals("5")) { NumberFormat formatter = new
			 * DecimalFormat("############.##");
			 * 
			 * String ServiceCharge ="";
			 * 
			 * String FinaltotalCost = formatter.format(new BigDecimal(totalCost));
			 * 
			 * sb.append("<tr>");
			 * sb.append("<td colspan='7' align='left'><hr size='2'></td>");
			 * sb.append("<td colspan='1' align='center'><hr size='2'></td>");
			 * 
			 * sb.append("</tr>");
			 * 
			 * sb.append("<tr>"); sb.
			 * append("<td colspan='7' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><div align='right'><b>TOTAL Rs.(Round)</b></div></font></td>"
			 * ); sb.
			 * append("<td colspan='1' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >"
			 * ); //sb.append(myFormatter.format(Double.parseDouble(FinaltotalCost)));
			 * sb.append(Math.round(Double.parseDouble(FinaltotalCost)));
			 * sb.append("</font></td>"); sb.append("</tr>");
			 * 
			 * sb.append("<tr>");
			 * sb.append("<td colspan='7' align='left'><hr size='2'></td>");
			 * sb.append("<td colspan='1' align='center'><hr size='2'></td>");
			 * 
			 * sb.append("</tr>");
			 * 
			 * 
			 * if(formBean.getStrModeVal().equals("2")) // To Show Issue Off-Line Voucher {
			 * 
			 * 
			 * String FinaltotalCostWithoutSc = formatter.format(new
			 * BigDecimal(totalCostWithoutSC)); if(configIssueRate.equals("") ||
			 * configIssueRate == null) configIssueRate = "0"; double IssueRatePercentage =
			 * Double.parseDouble(configIssueRate); double PurchaseCost =
			 * Double.parseDouble(strItemTotCost); double serviceCharge = totalCost -
			 * totalCostWithoutSC;
			 * 
			 * ServiceCharge = formatter.format(new BigDecimal(serviceCharge));
			 * 
			 * 
			 * double costWithServiceChag = totalCostWithoutSC + serviceCharge;
			 * 
			 * 
			 * 
			 * }
			 * 
			 * 
			 * }
			 * 
			 * 
			 * if(!formBean.getStrModeVal().equals("5") &&
			 * !formBean.getStrModeVal().equals("6")) {
			 * if(!formBean.getStrModeVal().equals("3")) {
			 * 
			 * sb.append("<tr> "); sb.
			 * append("<td colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received By:</font></td>"
			 * ); sb.
			 * append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif'>"
			 * ); sb.append(strRecivedBy.trim()); sb.append("</font></td>");
			 * sb.append("</tr> "); sb.append("<tr> "); sb.
			 * append("<td colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks:<b></font></td>"
			 * ); sb.
			 * append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif'>"
			 * );
			 * 
			 * 
			 * sb.append(strRemarks); sb.append("</font></td>"); sb.append("</tr> ");
			 * sb.append("<tr> "); if(formBean.getStrModeVal().equals("1")) { sb.
			 * append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>[ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;"
			 * +formBean.getStrUserName()
			 * +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> "
			 * ); sb.append("</tr> "); sb.append("<tr> "); sb.
			 * append("<td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>* In case of not issued items , kindly contact billing desk for refund.<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> "
			 * ); } else{ sb.
			 * append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>Issued By : "
			 * +formBean.getStrIssueTo().split("@")[1]+"<b>&nbsp;&nbsp;</font></td> "); }
			 * 
			 * sb.append("</tr> "); //sb.append("<tr> "); //sb.
			 * append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Issued By on Behalf of RMSCL<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> "
			 * ); //sb.append("</tr> ");
			 * 
			 * } else {
			 * 
			 * sb.append("<tr> "); sb.
			 * append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>"
			 * ); sb.
			 * append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>"
			 * ); sb.append(strRemarks); sb.append("<br></font></td>"); sb.append("</tr> ");
			 * sb.append("<tr> "); sb.
			 * append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> "
			 * ); sb.append("</tr> "); sb.append("<tr> "); sb.
			 * append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>("
			 * ).append(strRecivedBy).append( ")<b> &nbsp;&nbsp;</font></td> ");
			 * sb.append("</tr> ");
			 * 
			 * }
			 * 
			 * 
			 * } else {
			 * 
			 * sb.append("<tr> "); sb.
			 * append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Received By : "
			 * +formBean.getStrIssueTo().split("@")[1]+"<br><b> &nbsp;&nbsp;</font></td> ");
			 * sb.append("</tr> ");
			 * 
			 * } }
			 * 
			 * 
			 * else {
			 * 
			 * sb.append("<tr> "); sb
			 * .append("<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available/Requested Qty not available</b><br/><br/></font></td> "
			 * ); sb.append("</tr> ");
			 * 
			 * }
			 */

			sb.append("</table> ");

		} catch (Exception e) {

			e.printStackTrace();
			voObj.setStrMsgString("IssueTrackRptHLP.getIndentDetailsPrint() --> " + e.getMessage());
			throw e;
		} finally {
			mmscofigutil = null;
		}

		return sb.toString();
	}

	public static String getIssuedItemDetail(String strItemCategoryNo, String strHospitalCode, WebRowSet wb,
			String strStoreId, String strIssueNo,IssueTrackRptVO vo) throws SQLException {
		StringBuffer br = new StringBuffer();

		// IssueDeskTransBO bo = null;

		String strItemName = "";
		String strBatchSlNo = "";
		String strSancQty = "";
		String strIssuedQty = "";
		String strItemRemarks = "";

		String strRecievedBy = "";
		String strRemarks = "";
		String strIndentNo = "0";
		String strIndentDate = "";
		
		StringBuffer sb = new StringBuffer("");
		int i = 1;

		try {
			String report_name = "Issue Tracking Report";
			if(vo.getStrCmodeId()!=null && vo.getStrCmodeId().equals("1")) {
				report_name+=" [ Receive ]";
			}
			else if(vo.getStrCmodeId()!=null && vo.getStrCmodeId().equals("2")) {
				report_name+=" [ Issue ]";
			}
			// bo = new IssueDeskTransBO();
			WebRowSet ws = wb;
			vo.setStrHospitalCode(strHospitalCode);
			System.out.println("ws.size()::"+ws.size());
			sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
			sb.append("<tr> " + " <td colspan='1'></td>"
					+ " <td colspan='1'></td>" 
					+ " <td colspan='1'><div id='printImg' align='right' style='gap:8px'>"
					//+ "<img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne(1);' />"
					+ "<img style='cursor: pointer;'  text-align=right  title='Go Back' src='../../hisglobal/images/arrdouble-left.png' onClick='goBack(1);' />"
					+ "</div></td>"
					+ " </tr>");
			sb.append("<tr> " + " <td colspan='1'></td>"
					+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></td>" + " <td colspan='1'></td>");
			sb.append("</tr></table>");

			
			sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + "<tr> "
					+ " <td colspan='3'></td>"
					+ " <td colspan='3'align='center' style='font-size:15px'><b>"+report_name+"</b></td>"
					+ " <td colspan='3'></td>");
			sb.append("</tr>");

			sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Store Name ::<b>"
					+ vo.getStrStoreName() + "</b></font></td><td align='center' colspan='2'></td></tr>");

			sb.append(" <tr> <td align='center' colspan='3'></td>" + "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "From Date ::<b>"
					+ vo.getStrStartDate() + "</b> To Date ::<b>" + vo.getStrEndDate() + "</b></font></td>"
					+ "<td align='center' colspan='2'>"
					+ "<div id='printid1' class='hidecontrol' style='float:right'>" + "</td></tr>");
			
			sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Receiving Store ::<b>"
					+ vo.getStrRaisingStoreName() + "</b></font></td><td align='center' colspan='2'></td></tr>");
			
			sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Issue No ::<b>"
					+ vo.getStrIssueNo() + "</b></font></td><td align='center' colspan='2'></td></tr>");
			
			sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Indent No ::<b>"
					+ vo.getStrIndentNo() + "</b></font></td><td align='center' colspan='2'></td></tr>");
			
			sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Issue By ::<b>"
					+ vo.getStrIssuedBy() + "</b></font></td><td align='center' colspan='2'></td></tr>");
			
			sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Receive By ::<b>"
					+ vo.getStrReceivedBy() + "</b></font></td><td align='center' colspan='2'></td></tr>");
			
			sb.append(
					" <tr> " + " <td colspan='1'></td>" + " <td colspan='1'></td>" + " <td colspan='1'><br></td>");
			sb.append("</tr>");

			sb.append("</table>");
			sb.append("<input hidden id='hiddenId' value='"+vo.getStrStoreId()+"^"+vo.getStrReqStoreId()+"^"+vo.getStrIssueNo()+"^"+vo.getStrIndentNo()+"^"+vo.getStrReqStoreId()+"^"+vo.getStrStartDate()+"^"+vo.getStrEndDate()+"^"+vo.getStrCmodeId()
			+"^"+vo.getStrStoreName()+"^"+vo.getStrRaisingStoreName()+"^"+vo.getStrIssuedBy()+"^"+vo.getStrReceivedBy()+"^"+vo.getStrCategoryCode()
			+"^"+vo.getStrItemId()+"^"+vo.getStrItemBrandId()+"^"+vo.getStrBatchNo()+"'>");
			if (ws != null && ws.size() != 0) {
				
				
				
				sb.append("<table width='100%' class='table' border='1px'>");
				sb.append("<thead >");
				sb.append("<tr>");
				sb.append(
						"<th width='5%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;'' ><b>No.</th>");
				sb.append(
						"<th width='20%'  style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;' ><b>Item Name</th>");
				sb.append(
						"<th width='15%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;' ><b>Batch No</th>");
				sb.append(
						"<th width='15%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;' ><b>Expiry Date</th>");
				sb.append(
						"<th width='15%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;'' ><b>Rate wth Tax /\nUnit</th>");
				if(vo.getStrCmodeId().equals("1")) {
					sb.append(
							"<th width='10%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;'' ><b>Ack Qty</th>");
				}
				else{
					sb.append(
							"<th width='10%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;'' ><b>Issue Qty</th>");
				}
				
				sb.append(
						"<th width='10%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;'' ><b>Cost</th>");
				sb.append("</tr></thead>");
				sb.append("<tbody>");

				while (ws.next()) {
//					1.hstnum_issue_no,
//                  2.issue_date,
//                  3.hststr_recieve_by, 
//                  4.store_name,
//                  5.generic_item_name,
//					6.brand_item_name,
//                  7.BATCH_NO,
//                  8.issue_qty,
//                  9.rate,
//                  10.Req_store_name,
//                  11.ITEM_TYPE,
//                  12.HSTNUM_REQ_NO,
//					13.HSTNUM_REQ_STOREID,
//                  14.req_date,
//				    15.total_cost
//					16.expiry_date
//					17.issuedBy
//					18.recieve_qty
//					19.hidden_id  [ hstnum_issue_no @ HSTNUM_STORE_ID @ HSTNUM_INDENT_NO @ HSTNUM_REQ_STOREID @ hstnum_item_id @ hstnum_itembrand_id @ HSTSTR_BATCH_SL_NO @ sstnum_item_cat_no ]
					sb.append("<tr>");
					sb.append("<td hidden style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append("<input id='rowHiddenDetails"+i+"' value='"+ws.getString(19)+"'/>");
					sb.append("<input id='issueBy"+i+"' value='"+ws.getString(17)+"'/>");
					sb.append("<input id='receiveBy"+i+"' value='"+ws.getString(3)+"'/>");
					sb.append("<input id='reqStoreName"+i+"' value='"+ws.getString(10)+"'/>");
					sb.append("<input id='itemName"+i+"' value='"+ws.getString(6)+"'/>");
					sb.append("<input id='batchNo"+i+"' value='"+ws.getString(7)+"'/>");
					sb.append("</td>");
					sb.append("<td  width='5%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append(i);
					sb.append("</td>");
					sb.append("</td>");
					
					sb.append("<td width='20%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append(ws.getString(6));
					sb.append("</td>");
					
					if(vo.getStrCmodeId()!=null && vo.getStrCmodeId().equals("1")) {
						sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 14px !important;' >");
						sb.append("<a style='color:blue;cursor: pointer;' onclick='getIssueDtlForSubStore("+i+","+vo.getStrCmodeId()+");'>");
						sb.append(ws.getString(7));
					}
					else{
						sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 14px !important;' >");
						sb.append("<a>");
						sb.append(ws.getString(7));
					}
					sb.append("</a>");
					sb.append("</td>");


					sb.append("<td width='15%' style='font-weight:350 !important; font-size: 14px !important;'>");
					sb.append(ws.getString(16));
					sb.append("</td>");

					sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append(ws.getString(9));
					sb.append("</td>");

					sb.append("<td width='10%' style='font-weight:350 !important ;font-size: 14px !important;' >");					
					if(vo.getStrCmodeId()!=null && vo.getStrCmodeId().equals("1")) {
						sb.append(ws.getString(18));
					}
					else{
						sb.append(ws.getString(8));
					}
					sb.append("</td>");

					sb.append("<td width='10%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append(ws.getString(15));
					sb.append("</td>");
					sb.append("</tr>");
					i++;
				}
			} else {
				sb.append("<tr>");
				sb.append("<td colspan='5' ><DIV class='errMsg' align='center'> NO MATCHING RECORD FOUND </div></td>");
				sb.append("</tr>");
			}
			sb.append("</tbody>");
			sb.append("</table>");
			sb.append("<div class='modal-footer'></div>");
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IssueTrackRptHLP.getIssuedItemDetail() --> " + e.getMessage());
			return "ERROR";

		}

		return sb.toString();
	}
	
	public static String getItemCurrStockDtl(IssueTrackRptVO vo) throws SQLException {
		String strItemName = "";
		String strBatchSlNo = "";
		String strSancQty = "";
		String strIssuedQty = "";
		String strItemRemarks = "";

		String strRecievedBy = "";
		String strRemarks = "";
		String strIndentNo = "0";
		String strIndentDate = "";
		
		StringBuffer sb = new StringBuffer("");
		int i = 1;

		try {
			String report_name = "Current Stock Details [ for "+ vo.getStrRaisingStoreName() + " ]";
			
			
			WebRowSet ws = vo.getItemCurrStockWS();
			
			sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
		
			sb.append("<tr> <td colspan='9'></td></tr>");
			sb.append("<tr style='background-color: #fff7ee;height:42px;'> "
					+ " <td colspan='3'></td>"
					+ " <td colspan='3'align='center' style='font-size:15px'><b>"+report_name+"</b></td>"
					+ " <td colspan='3'></td>");
			sb.append("</tr>");

			
			sb.append(" <tr> " + " <td colspan='3'></td>" + " <td colspan='3'></td>" + " <td colspan='3'><br></td>");
			sb.append("</tr>");

			sb.append("</table>");
			if (ws != null && ws.size() != 0) {
				sb.append("<table width='100%' class='table' border='1px'>");
				sb.append("<thead >");
				sb.append("<tr>");
				
				sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;'' ><b>In-Hand Qty</b></th>");
				
				sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;'' ><b>Expiry Date</b></th>");
				
				sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;' ><b>Remaining <br> Exp. Days</b></th>");
				
				sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;'' ><b>Days Since<br> Last Issued</b></th>");
				
				sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;'' ><b>Rate</b></th>");
				
				sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;'' ><b>Total</b></th>");
				
				sb.append("</tr></thead>");
				sb.append("<tbody>");
				
				/* 
				 * 1.received_by, 
				 * 2.rate, 
				 * 3.received_date,
				 * 4.administrative_charges,
				 * 5.expiry_date, 
				 * 6.entry_date, 
				 * 7.sale_price, 
				 * 8.supplied_by,
				 * 9.inhand_qty ,
				 * 10.total_cost,
				 * 11.status,
				 * 12.last_movement_date,
				 * 13.remaining_expiry_days
				 */
				while (ws.next()) {
					int days = Integer.parseInt(ws.getString(13));
					if (days <= 30) {
						sb.append("<tr style='background-color:#91c091;'>"); // green
					} else if (days > 30 && days < 90 ) {
						sb.append("<tr style='background-color:#ffd382;'>"); // yellow
					} else {
						sb.append("<tr style='background-color:#f3bdbd;'>"); // red
					} 
					sb.append("<td  width='15%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append(ws.getString(9));
					sb.append("</td>");
					
					sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append(ws.getString(5));
					sb.append("</td>");
					

					sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append(ws.getString(13)); 
					sb.append("</td>");
					

					sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append(ws.getString(12));
					sb.append("</td>");

					sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append(ws.getString(7));
					sb.append("</td>");

					sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append(ws.getString(10));
					sb.append("</td>");
					sb.append("</tr>");
					i++;
				}
			} else {
				sb.append("<tbody>");
				sb.append("<tr>");
				sb.append("<td colspan='5' ><DIV class='errMsg' align='center'> CURRENT STOCK RECORD NOT FOUND </div></td>");
				sb.append("</tr>");
			}
			sb.append("</tbody>");
			sb.append("</table>");
			sb.append("<div id='legendsId' align='center'>"
					+ "<font>&nbsp;Expiry Days &nbsp; </font>"
					+ "[<font><span style='color:#91c091;'><i class='fas fa-certificate' ></i></span>&nbsp;Under 30 </font>] "
					+ "[<font><span style='color:#ffd382;'><i class='fas fa-certificate' ></i></span>&nbsp;Between 30 to 90 </font>] "
					+ "[<font><span style='color:#f3bdbd;'><i class='fas fa-certificate' ></i></span>&nbsp;Above 90 </font>]</div>");
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IssueTrackRptHLP.getItemCurrStockDtl() --> " + e.getMessage());
			return "ERROR";

		}

		return sb.toString();
	}
	
	public static String getIssueDtlForSubStore(IssueTrackRptVO vo,String currStockHLP) throws SQLException {
		String strItemName = "";
		String strBatchSlNo = "";
		String strSancQty = "";
		String strIssuedQty = "";
		String strItemRemarks = "";

		String strRecievedBy = "";
		String strRemarks = "";
		String strIndentNo = "0";
		String strIndentDate = "";
		
		StringBuffer sb = new StringBuffer("");
		int i = 1;

		try {
			String report_name = "Issue Tracking Report";
			
			System.out.println("report name : "+report_name);
			if(vo.getStrCmodeId()!=null && vo.getStrCmodeId().equals("1")) {
				report_name+=" [ Receive ]";
			}
			else if(vo.getStrCmodeId()!=null && vo.getStrCmodeId().equals("2")) {
				report_name+=" [ Issue ]";
			}
			// bo = new IssueDeskTransBO();getItemDetailsWS
			WebRowSet ws = vo.getItemDetailsWS();
			System.out.println("ws.size()11::"+ws.size());
			sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
			sb.append("<tr> " + " <td colspan='1'></td>"
					+ " <td colspan='1'></td>" 
					+ " <td colspan='1'><div id='printImg' align='right' style='gap:8px'>"
					//+ "<img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne(1);' />"
					+ "<img style='cursor: pointer;'  text-align=right  title='Go Back' src='../../hisglobal/images/arrdouble-left.png' onClick='goBack(2);' />"
					+ "</div></td>"
					+ " </tr>");
			sb.append("<tr> " + " <td colspan='1'></td>"
					+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></td>" + " <td colspan='1'></td>");
			sb.append("</tr></table>");

			
			sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + "<tr> "
					+ " <td colspan='3'></td>"
					+ " <td colspan='3'align='center' style='font-size:15px'><b>"+report_name+"</b></td>"
					+ " <td colspan='3'></td>");
			sb.append("</tr>");

			sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Store Name ::<b>"
					+ vo.getStrStoreName() + "</b></font></td><td align='center' colspan='2'></td></tr>");

			sb.append(" <tr> <td align='center' colspan='3'></td>" + "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "From Date ::<b>"
					+ vo.getStrStartDate() + "</b> To Date ::<b>" + vo.getStrEndDate() + "</b></font></td>"
					+ "<td align='center' colspan='2'>"
					+ "<div id='printid1' class='hidecontrol' style='float:right'>" + "</td></tr>");
			
			sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Receiving Store ::<b>"
					+ vo.getStrRaisingStoreName() + "</b></font></td><td align='center' colspan='2'></td></tr>");
			
			sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Issue No ::<b>"
					+ vo.getStrIssueNo() + "</b></font></td><td align='center' colspan='2'></td></tr>");
			
			sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Indent No ::<b>"
					+ vo.getStrIndentNo() + "</b></font></td><td align='center' colspan='2'></td></tr>");
			
			sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Issue By ::<b>"
					+ vo.getStrIssuedBy() + "</b></font></td><td align='center' colspan='2'></td></tr>");
			
			sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Receive By ::<b>"
					+ vo.getStrReceivedBy() + "</b></font></td><td align='center' colspan='2'></td></tr>");
			
			sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Item Name ::<b>"
					+ vo.getStrItemName() + "</b></font></td><td align='center' colspan='2'></td></tr>");
			
			sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Batch No. ::<b>"
					+ vo.getStrBatchNo() + "</b></font></td><td align='center' colspan='2'></td></tr>");
			
			sb.append(" <tr> " + " <td colspan='3'></td>" + " <td colspan='3'></td>" + " <td colspan='3'><br></td>");
			sb.append("</tr>");

			sb.append("</table>");
			
			sb.append("<input hidden id='hiddenId' value='"+vo.getStrStoreId()+"^"+vo.getStrReqStoreId()+"^"+vo.getStrIssueNo()+"^"+vo.getStrIndentNo()+"^"+vo.getStrReqStoreId()+"^"+vo.getStrStartDate()+"^"+vo.getStrEndDate()+"^"+vo.getStrCmodeId()
			+"^"+vo.getStrStoreName()+"^"+vo.getStrRaisingStoreName()+"^"+vo.getStrIssuedBy()+"^"+vo.getStrReceivedBy()+"^"+vo.getStrCategoryCode()
			+"^"+vo.getStrItemId()+"^"+vo.getStrItemBrandId()+"^"+vo.getStrBatchNo()+"'>");
			sb.append(currStockHLP);
			
			String tableHeader = "Item Issue Details [ by"+ vo.getStrRaisingStoreName() +" ]";
			if(vo.getStrCategoryCode().equals("10")) {
				tableHeader = "Drug Issue Details [ by " + vo.getStrRaisingStoreName() +" ]";
			}
			sb.append("<div class='modal-footer'></div>");
			sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
			sb.append("<tr style='background-color: #fff7ee; height:42px;'> "
					+ " <td colspan='3'></td>"
					+ " <td colspan='3'align='center' style='font-size:15px'><b>"+tableHeader+"</b></td>"
					+ " <td colspan='3'></td>");
			sb.append("</tr>");

			sb.append(" <tr> " + " <td colspan='3'></td>" + " <td colspan='3'></td>" + " <td colspan='3'><br></td>");
			sb.append("</tr>");
			if (ws != null && ws.size() != 0) {
				sb.append("<table width='100%' class='table' border='1px'>");
				sb.append("<thead >");
				sb.append("<tr>");
				sb.append("<th width='5%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;'' ><b>No.</b></th>");
				
				sb.append("<th width='20%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;'' ><b>Issue To</b></th>");
				
				sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;'' ><b>Issue Date</b></th>");
				
				sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;' ><b>Issue Qty</b></th>");
				
				sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;'' ><b>Rate</b></th>");
				
				sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 14px !important; white-space: nowrap;'' ><b>Cost</b></th>");
				
				sb.append("</tr></thead>");
				sb.append("<tbody>");
				
				/*  Case -1 When issue to someone 
				 * 1.ISSUE_STORE, 
				 * 2.cr_no, 
				 * 3.ISSUE_DATE,
				 * 4.INDENT_NO_DATE,
				 * 5.ITEM_NAME, 
				 * 6.BATCH_NO, 
				 * 7.RATE_UNIT, 
				 * 8.SANC_QTY,
				 * 9.ISSUE_QTY ,
				 * 10.COST_VAL,
				 * 11.SERVICE_TAX,
				 * 12.status
				 */
				while (ws.next()) {

					sb.append("<tr>");
					sb.append("<td  width='5%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append(i);
					sb.append("</td>");
					sb.append("</td>");
					
					sb.append("<td width='20%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append(ws.getString(2));
					sb.append("</td>");
					

					sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append(ws.getString(3));  //issue date / receive date
					sb.append("</td>");
					

					sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append(ws.getString(9));  //issue qty / in-hand qty
					sb.append("</td>");

					sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append(ws.getString(7));
					sb.append("</td>");

					sb.append("<td width='10%' style='font-weight:350 !important ;font-size: 14px !important;' >");
					sb.append(ws.getString(10));
					sb.append("</td>");
					sb.append("</tr>");
					i++;
				}
			} else {
				sb.append("<tbody>");
				sb.append("<tr>");
				sb.append("<td colspan='5' ><DIV class='errMsg' align='center'> NO MATCHING RECORD FOUND </div></td>");
				sb.append("</tr>");
			}
			sb.append("</tbody>");
			sb.append("</table>");
			sb.append("<div class='modal-footer' align='center'></div>");
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IssueTrackRptHLP.getIssueDtlForSubStore() --> " + e.getMessage());
			return "ERROR";

		}

		return sb.toString();
	}
}
