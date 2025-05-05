package mms.transactions.controller.hlp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import billing.BillConfigUtil;
import billing.PrintBO;
import billing.PrintVO;
import hisglobal.exceptions.HisException;
import hisglobal.tools.hlp.GlobalVO;
import hisglobal.utility.HisPrinter;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.transactions.bo.InjAdministrationTransBO;
import mms.transactions.controller.fb.InjAdministrationTransFB;
import mms.transactions.vo.InjAdministrationTransVO;
import mms.transactions.vo.IssueDeskTransVO;
import mms.transactions.vo.IssueTransOVO;

public class InjAdministrationTransHLP {

	public static int printLine = 0;
	public static final char FORMFEED = 12;
	public static int isServiceDiscountReq = 1;

	public static final char ESCAPECHAR = 27;
	public static final String BOLDON = ESCAPECHAR + "" + 'E';
	public static final String BOLDOFF = ESCAPECHAR + "" + 'F';

	public static String getIssueRptForDotMatrix(InjAdministrationTransFB formBean)
			throws SQLException, UnsupportedEncodingException {
		String rptContents = "";
		WebRowSet ws = formBean.getWsIssueDetails();
		int i = 1;
		if (ws != null && ws.size() > 0) {
			/*
			 * Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line
			 * Issue Voucher) 1.Hospital Name ^ DDC Name ^ Prescribe For ^ Issue No ^ Issued
			 * By Doctor ^ Date ^ PIN ^ Hindi Text 2.Drug Name 3.Batch No 4.Exp Date 5.Issue
			 * Qty
			 */
			rptContents = "\n";
			rptContents += "                             Testing Slip \n"
					+ "                          Government of Rajasthan\n"
					+ "                      Mukhyamantri Nishulk Dava Yojna\n";
			rptContents += "\n     Hospital      :" + MakeRptStr(formBean.getStrHospitalName(), 30) + " DDC      :"
					+ formBean.getStrStoreName() + " " + "\n     Presc For     :"
					+ MakeRptStr(formBean.getStrPatientName(), 30) + " Issue No.:" + formBean.getStrIssueNo()
					+ "\n     By Doctor     :" + MakeRptStr(formBean.getStrPrescribedBy(), 30) + " Date     :"
					+ formBean.getStrIssueDate() + "\n     PIN.        :" + MakeRptStr(formBean.getStrCrNo(), 30)
					+ "\t\n";

			rptContents += "   ---------------------------------------------------------------------------\n"
					+ "   S.No  Drug Name                             Batch No.   Exp Date  Issue Qty\n"
					+ "   ---------------------------------------------------------------------------\n";
			while (ws.next()) {
				rptContents += MakeRptStr(String.valueOf(i) + ".", 3) + "" + MakeTariffStr(ws.getString(2), 40, 5) + " "
						+ MakeRptStr(ws.getString(3), 8) + "  " + MakeRptStr(ws.getString(4), 10) + " "
						+ MakeRptStr(ws.getString(5), 4) + "\n";
				i++;
			}
			rptContents += "   ---------------------------------------------------------------------------\n";
			rptContents += formBean.getStrHindiText();

			// Form Feed
			rptContents += String.valueOf((char) 12);

		}
		return rptContents;

	}

	public static String MakeRptStr(String tempString, int len) {
		if (tempString.length() < len) {
			int len1 = tempString.length();
			for (int i = 0; i < (len - len1); i++)
				tempString += " ";
		}

		return tempString;
	}

	/******************************************************* end ****/
	public static String MakeTariffStr(String Tname, int len, int prevSpace) {
		String Tname1 = "";
		String Tname2 = "";
		int i = 0;
		int len1 = 0;

		if (Tname.trim().length() > len) {
			Tname1 = Tname.substring(0, len) + "\n";
			for (i = 0; i < prevSpace; i++)
				Tname1 += " ";

			Tname2 = "-" + Tname.substring(len);
			len1 = Tname2.length();
			if (len1 > len) {
				Tname2 = "-" + Tname.substring(len, len - 1);
				len1 = Tname2.length();
			}

			Tname1 += Tname2;
		} else {
			Tname1 = Tname;
			len1 = Tname1.length();
		}
		//
		for (i = 0; i < (len - len1); i++)
			Tname1 += " ";

		return Tname1;
	}

	/**
	 * This method is used to show issued item Details on VIEW PAGE2
	 * 
	 * @param wb
	 * @param strItemCategory
	 * @param strHospitalCode
	 * @return
	 */
	public static String getIssuedDetail(WebRowSet wb) throws SQLException {
		StringBuffer br = new StringBuffer();

		String strIssueDate = "";
		String strIssueNo = "";
		String strIndentingStore = "";
		String strIndentNo = "";
		String strIndentDate = "";

		int i = 0;

		try {

			br.append(
					"<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' cellpadding='1px' cellspacing='1px'>");
			br.append("<tr>");
			br.append("<td class='multiRPTLabel' WIDTH='10%' align='CENTER'>#</td>");
			br.append("<td class='multiRPTLabel' WIDTH='15%' align='CENTER'>Issue Date</td>");
			br.append("<td class='multiRPTLabel' WIDTH='10%' align='CENTER'>Issue No</td>");
			br.append("<td class='multiRPTLabel' WIDTH='20%' align='CENTER'>Issuing Store</td>");
			br.append("<td class='multiRPTLabel' WIDTH='15%' align='CENTER'>PIN</td>");
			br.append("<td class='multiRPTLabel' WIDTH='20%' align='CENTER'>Patient Name</td>");
			// br.append("<td class='multiRPTLabel' WIDTH='10%' align='CENTER'>#</td>");
			br.append("</tr>");

			if (wb.size() != 0) {

				while (wb.next()) {
					strIssueDate = wb.getString(2);
					strIssueNo = wb.getString(1);
					strIndentingStore = wb.getString(3);
					strIndentNo = wb.getString(4);
					strIndentDate = wb.getString(5);
					br.append("<input type='hidden' name='strHlpIssueNo' id='strHlpIssueNo" + i + "' value="
							+ strIssueNo + " />");
					br.append("<input type='hidden' name='strHlpIndentNo' id='strHlpIndentNo" + i + "' value="
							+ strIndentNo + " />");
					br.append("<input type='hidden' name='strHlpIndentDate' id='strHlpIndentDate" + i + "' value="
							+ strIndentDate + " />");
					br.append("<input type='hidden' name='strHlpCrNo' id='strHlpCrNo" + i + "' value=" + wb.getString(6)
							+ " />");
					br.append("<input type='hidden' name='strHlpPatientName' id='strHlpPatientName" + i + "' value="
							+ wb.getString(7) + " />");

					br.append("<tr id='roww" + i + "'>");
					if (wb.isFirst())
						br.append("<td WIDTH='10%' CLASS='multiPOControl' ><div name='plus' id='plusdiv" + i
								+ "'><input type='radio' name='gender' checked onclick='validateIssue(\"" + i
								+ "\");' style='cursor: pointer;' title='Click to show item details'></div></td>");
					else
						br.append("<td WIDTH='10%' CLASS='multiPOControl' ><div name='plus' id='plusdiv" + i
								+ "'><input type='radio' name='gender'   onclick='validateIssue(\"" + i
								+ "\");' style='cursor: pointer;' title='Click to show item details'></div></td>");
					br.append("<td WIDTH='15%' CLASS='multiPOControl' >" + strIssueDate + "</td>");
					br.append("<td WIDTH='20%' CLASS='multiPOControl' >");
					br.append("<input type='hidden' name='flag' id='flag" + i + "' value=" + "0" + " />");
					br.append("<div class='popup' id='IssueItempopup' style='display: none'></div>");
					br.append(strIssueNo);
					br.append("</td>");
					br.append("<td WIDTH='10%' CLASS='multiPOControl' >" + strIndentingStore + "</td>");
					br.append("<td WIDTH='15%' CLASS='multiPOControl' >" + wb.getString(6) + "</td>");
					br.append("<td WIDTH='20%' CLASS='multiPOControl' >" + wb.getString(7) + "</td>");
					// br.append("<td WIDTH='10%' CLASS='multiPOControl' ><a href='#'
					// onclick='addnewtab();'>New Request</a> </td>");
					// br.append("<td WIDTH='10%' CLASS='multiPOControl' ><img height='20px'
					// width='30px' src='../../hisglobal/transactionutil/images/IssueOnDesk.png'
					// onclick='validateIssue(\""+ i + "\");' style='cursor: pointer;' title='Click
					// to Issue'><img src='../../hisglobal/images/search_icon1.gif'
					// onclick='generateIssueReportFunc(this,\""+ i + "\");' style='cursor:
					// pointer;' title='Print Issue Item Details'></td>");
					// br.append("<td WIDTH='10%' CLASS='multiPOControl' ><div name='plus'
					// id='plusdiv"+i+"'><img height='20px' width='20px'
					// src='../../hisglobal/images/plus.png' onclick='validateIssue(\""+ i + "\");'
					// style='cursor: pointer;' title='Click to show item details'><img
					// height='20px' width='20px' src='../../hisglobal/images/delete_on.gif'
					// onclick='deleteIssue(\""+ i + "\");' style='cursor: pointer;' title='Click to
					// delete issue req'></div></td>");

					br.append("</tr>");
					i++;
				}

				br.append("</table> ");
			} else {
				br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td  CLASS='multiControl' colspan='5'>" + "No Record Found" + "</td>");
				br.append("</tr>");
				br.append("</table> ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}

		return br.toString();
	}

	public static String getIssuePopUp(String strHospCode, String strStoreId, String strIssueNo) throws IOException {
		/* Creating VO & BO Object Here */
		InjAdministrationTransVO vo = new InjAdministrationTransVO();
		InjAdministrationTransBO bo = new InjAdministrationTransBO();

		/* Declaring Variable */
		StringBuffer sb = new StringBuffer("");
		String strItemName = "";
		String strIssueQtyUnit = "";
		String strRateUnit = "";
		String strCost = "";
		WebRowSet ws = null;

		/* Setting Value in vo Object */
		vo.setStrStoreId(strStoreId);
		vo.setStrHospitalCode(strHospCode);
		vo.setStrIssueNo(strIssueNo);

		/* Calling BO Method */
		bo.getIssueDtlPopUp(vo);

		ws = vo.getStrIssueDtlPopUpWs();

		sb.append("<table width='500' align='center' border='0' cellpadding ='1px' cellspacing ='1px'>");
		sb.append("<tr class='HEADER'><td colspan='3'>Issue Item Details</td>");
		sb.append(
				"<th align='right' ><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp Window' src='../../hisglobal/images/popUp_cancel.JPG' onClick=hideIssueDetails('popUpDiv1');hideIssueDetails('blanket');>");
		sb.append("</th>");
		sb.append("</tr>");
		sb.append("</table>");
		sb.append(
				"<table width='500' align='center' border='0' cellpadding ='1px' cellspacing ='1px' bgcolor='#086fa6'>");
		sb.append("<tr>");
		sb.append("<td width='45%' class='multiRPTLabel'><font color='white'>Drug Name</font></td>");
		sb.append("<td width='15%' class='multiRPTLabel'>Issue/Return Qty</td>");
		sb.append("<td width='25%' class='multiRPTLabel'>Rate/Unit</td>");
		sb.append("<td width='15%' class='multiRPTLabel'>Cost</td>");
		sb.append("</tr>");
		sb.append("</table>");
		sb.append(
				"<table width='500' align='center' border='0' cellpadding ='1px' cellspacing ='1px' bgcolor='#bdd9f0'>");
		try {

			if (ws != null && ws.size() != 0) {
				while (ws.next()) {

					strItemName = ws.getString(1).trim();
					strIssueQtyUnit = ws.getString(2).trim();
					strRateUnit = ws.getString(3).trim();
					strCost = ws.getString(4).trim();

					if (strItemName == null || strItemName.equals(""))
						strItemName = "-----";
					if (strIssueQtyUnit == null || strIssueQtyUnit.equals(""))
						strIssueQtyUnit = "-----";
					if (strRateUnit == null || strRateUnit.equals(""))
						strRateUnit = "-----";
					if (strCost == null || strCost.equals(""))
						strCost = "-----";

					sb.append("<tr>");
					sb.append("<td align='left' width='45%' class='multiPOControl'>");
					sb.append(strItemName);
					sb.append("</td>");
					sb.append("<td width='15%' class='multiPOControl'>");
					sb.append(strIssueQtyUnit);
					sb.append("</td>");
					sb.append("<td width='25%' class='multiPOControl'>");
					sb.append(strRateUnit);
					sb.append("</td>");
					sb.append("<td width='15%' class='multiPOControl'>");
					sb.append(strCost);
					sb.append("</td>");
					sb.append("</tr>");

				}
			} else {
				sb.append(
						"<tr><td colspan='4' class='multiControl'><font color='red'>No Matching Record Found</font></td></tr>");

			}

		} catch (SQLException e) {

			throw new HisException("Issue Transaction", "InjAdministrationTransHLP .getIssuePopUp() -->",
					e.getMessage());
		}

		sb.append("</table>");

		return sb.toString();
	}

	public static String getRequestDetails(WebRowSet ws) {

		StringBuffer sb = new StringBuffer("");

		try {

			if (ws != null && ws.size() > 0) {
				if (ws.next()) {

					String strDeptName = ws.getString(1);
					String strUnitName = ws.getString(2);
					String strPrescribedBy = ws.getString(3);
					String strPrescriptionFor = ws.getString(4);
					String strPrescriptionDate = ws.getString(5);
					String strPrescriptionFrom = ws.getString(9);

					String strDeptId = ws.getString(6);
					String strUnitId = ws.getString(7);
					String strConsultantId = ws.getString(8);
					String strEpisodeCode = ws.getString(10);
					String strVisitNo = ws.getString(11);
					String strWardCode = ws.getString(12);
					String strAdmissionNo = ws.getString(13);
					String strEmployeeNo = ws.getString(14);
					String strVisitTypeId = ws.getString(15);
					String strReqDate = ws.getString(16);

					String strHidReqVal = strDeptId + "^" + strUnitId + "^" + strConsultantId + "^" + strPrescribedBy
							+ "^" + strPrescriptionFor + "^" + strPrescriptionFrom + "^" + strEpisodeCode + "^"
							+ strVisitNo + "^" + strWardCode + "^" + strAdmissionNo + "^" + strEmployeeNo + "^"
							+ strVisitTypeId + "^" + strReqDate;

					if (strDeptName == null)
						strDeptName = "----";
					if (strUnitName == null)
						strUnitName = "----";
					if (strPrescribedBy == null)
						strPrescribedBy = "----";
					if (strPrescriptionFor == null)
						strPrescriptionFor = "----";
					if (strPrescriptionDate == null)
						strPrescriptionDate = "----";
					if (strPrescriptionFrom == null)
						strPrescriptionFrom = "----";

					sb.append("<input type='hidden' name ='strHidReqVal'  value='" + strHidReqVal + "'>");

					sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px' >");
					sb.append("<input type='hidden' name='strReqDate' id='strReqDate' value='" + strPrescriptionDate
							+ "'>");
					sb.append("<tr><td class='TITLE' colspan='4'>Request Details</td></tr>");
					sb.append("<tr><td width='25%'  class='LABEL'>Department</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strDeptName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Unit</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strUnitName);
					sb.append("</td></tr>");
					sb.append("<tr><td width='25%' class='LABEL'>Prescribed By</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strPrescribedBy);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Prescription For</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strPrescriptionFor);
					sb.append("</td></tr>");
					sb.append("<tr><td width='25%' class='LABEL'>Prescription Date</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strPrescriptionDate);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Prescription From</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strPrescriptionFrom);
					sb.append("</td></tr>");
					sb.append("</table>");

				}
			} else {

				sb.append("<TR>");
				sb.append("<TD WIDTH='25%' CLASS='multiControl' colspan='5'><font color = 'red'>" + "No Record Found"
						+ "</font></TD>");
				sb.append("</TR>");

			}
		} catch (Exception e) {

			throw new HisException("Issue Transaction", "InjAdministrationTransHLP.getRequestDetails()-->",
					e.getMessage());
		}
		return sb.toString();
	}

	public static String getItemDetails(String hosCode, WebRowSet wb) throws SQLException {
		StringBuffer br = new StringBuffer();

		// InjAdministrationTransBO bo = null;
		InjAdministrationTransVO vo = null;
		// HisUtil hisutil = null;

		// String strUnitValues = "";
		int i = 0;

		try {
			// hisutil = new HisUtil("mms", "InjAdministrationTransHLP");
			// bo = new InjAdministrationTransBO();
			vo = new InjAdministrationTransVO();

			br.append("<div id = 'itemDetailDivId' style='display:none'>");
			br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px' >");
			br.append("<tr><td class='TITLE' colspan='7'>Item Details(Online)</td></tr>");
			br.append("</table> ");
			br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px' bgcolor='#6097BC'>");
			br.append("<tr><td width='15%' class='multiLabel'>Item Name</td>");
			br.append("<td width='13%' class='multiLabel'>Avl Qty</td>");
			br.append("<td width='12%' class='multiLabel'>Balance Qty</td>");
			br.append("<td width='15%' class='multiLabel'>Dosage</td>");
			br.append("<td width='15%' class='multiLabel'>Frequency</td>");
			br.append("<td width='15%' class='multiLabel'>Days</td>");
			br.append("<td width='15%' class='multiLabel'>Quantity</td></tr>");

			if (wb != null && wb.size() > 0) {

				while (wb.next()) {

					String strItemName = wb.getString(1);
					String strAvlQty = wb.getString(2);
					String strBalQty = wb.getString(3);
					String strReqQty = wb.getString(4);
					String strReqQtyUnitId = wb.getString(5);
					String strIssueQty = wb.getString(6);
					// String strIssueQtyUnitId = wb.getString(7);
					String strGenItemId = wb.getString(8);
					String strItemBrandId = wb.getString(9);
					String strIssueQtyBaseVal = wb.getString(10);
					String strGroupId = wb.getString(11);
					String strSubGroupId = wb.getString(12);
					String strBalanceQty = wb.getString(13);

					String strDosageName = wb.getString(17);
					String strFrequencyName = wb.getString(18);
					String strDays = wb.getString(19);
					String strQuantity = wb.getString(20);

					String strHiddenDosageFreq = wb.getString(15) + "^" + wb.getString(16) + "^" + strDays + "^"
							+ strQuantity;

					String strHidVal = strIssueQtyBaseVal + "^" + strGenItemId + "^" + strItemBrandId + "^" + strBalQty
							+ "^" + strGroupId + "^" + strSubGroupId + "^" + strReqQtyUnitId + "^" + strBalanceQty;

					String strBalQtyDtl = strReqQty + "^" + strIssueQty;

					String[] temp = strAvlQty.replace('@', '#').split("#");

					String[] strAvailableQty = temp[0].split("\\^");
					String[] strUnitId = temp[1].split("\\^");
					vo.setStrIssueUnitId(strUnitId[0]);

					br.append(
							"<input type='hidden' name='strAvlQty' id='strAvlQty" + i + "' value='" + strAvlQty + "'>");
					br.append("<input type='hidden' name='strHidValue' id='strHidValue" + i + "' value='" + strHidVal
							+ "'>");
					br.append("<input type='hidden' name='strBalQtyDtl' id='strBalQtyDtl" + i + "' value="
							+ strBalQtyDtl + " >");
					br.append("<input type='hidden' name='strHiddenDosageFreq' id='strHiddenDosageFreq" + i
							+ "' value='" + strHiddenDosageFreq + "'>");
					br.append("<TR>");

					br.append("<TD WIDTH='15%' colspan='1' CLASS='multiControl' >" + strItemName + "</TD>");
					br.append("<TD WIDTH='13%' colspan='1' CLASS='multiControl' >" + strAvailableQty[0] + "</TD>");
					br.append("<TD WIDTH='12%' colspan='1' CLASS='multiControl' ><a name='strBalQty' id='strBalQty" + i
							+ "' STYLE='CURSOR:POINTER;color:blue' onClick='balQtyDtl(this,\"" + i + "\");'>"
							+ strBalQty + "</a></TD>");

					br.append("<TD WIDTH='15%' colspan='1' CLASS='multiControl' >" + strDosageName + "</TD>");
					br.append("<TD WIDTH='15%' colspan='1' CLASS='multiControl' >" + strFrequencyName + "</TD>");
					br.append("<TD WIDTH='15%' colspan='1' CLASS='multiControl' >" + strDays + "</TD>");
					br.append("<TD WIDTH='15%' colspan='1' CLASS='multiControl' >" + strQuantity + " No. </TD>");

					br.append("</TR>");
					i++;
				}

				br.append("</table> ");
				br.append("</div> ");
			} else {
				br.append("<div id = 'itemDetailDivId' style='display:none'>");
				br.append("<TR>");
				br.append("<TD WIDTH='25%' CLASS='multiControl' colspan='6'><font color = 'red'>" + "No Record Found"
						+ "</font></TD>");
				br.append("</TR>");
				br.append("</div> ");
			}

		} catch (Exception e) {

			throw new HisException("Issue Transaction", "InjAdministrationTransHLP .getItemDetails() -->",
					e.getMessage());

		}

		return br.toString();
	}

	public static String getIssueDetails(WebRowSet ws) throws SQLException {
		StringBuffer sb = new StringBuffer();

		int i = 0;

		try {

			if (ws != null && ws.size() > 0) {
				sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");

				while (ws.next()) {

					String strIssueNo = ws.getString(1);
					String strIssueDate = ws.getString(2);
					String strIssueSoreID = ws.getString(3);
					if (strIssueNo == null)
						strIssueNo = "----";
					if (strIssueDate == null)
						strIssueDate = "----";

					sb.append("<input type='hidden' name='strIssueNo' id='strIssueNo" + i + "' value=" + strIssueNo
							+ " >");
					sb.append("<input type='hidden' name='strIssueSoreID' id='strIssueSoreID" + i + "' value="
							+ strIssueSoreID + " >");
					sb.append("<tr><td width='50%' colspan ='2'  class='LABEL'>IssueNo. / IssueDate</td>");
					sb.append(
							"<td width='50%' colspan ='2' class='CONTROL'><a name='strIssueDtl' id='strIssueDtl' STYLE='CURSOR:POINTER;color:blue' onClick='getIssuePopUp(this, \""
									+ i + "\" );'>");
					sb.append(strIssueNo + "/" + strIssueDate);
					sb.append("</td></tr>");

					i++;
				}

				sb.append("</table>");
			} else {
				sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
				sb.append("<TR>");
				sb.append("<TD WIDTH='25%' CLASS='multiControl' colspan='4'><font color = 'red'>" + "No Record Found"
						+ "</font></TD>");
				sb.append("</TR>");
				sb.append("</table>");

			}
		} catch (Exception e) {

			throw new HisException("Issue Transaction", "InjAdministrationTransHLP .getIssueDetails() -->",
					e.getMessage());

		}

		return sb.toString();
	}

	public static String getBilledItemDtls(InjAdministrationTransVO vo) throws SQLException {
		StringBuffer br = new StringBuffer();
		WebRowSet wb = vo.getStrBilledItemDetailWs();

		String strIssueDate = "";
		String strIssueNo = "";
		String strIndentingStore = "";
		String strIndentNo = "";
		String strIndentDate = "";
		float tot = 0;

		int i = 0;

		try {
			br.append("<table class='TABLEWIDTH' align='center' cellpadding='1' cellspacing='1'>");
			br.append("<tr>");
			br.append("<td class='TITLE' colspan='2'><div id='minusdiv' style=''>");
			if (wb.size() != 0) {
				wb.next();
				br.append("&nbsp;Billed Item Details against Receipt no. "
						+ wb.getString(8).replace("^", "#").split("#")[0] + " & Issue No : " + wb.getString(1)
						+ "</div>");
			} else
				br.append("&nbsp;Billed Item Details </div>");

			br.append("</td></tr></table>");

			br.append(
					"<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' cellpadding='1px' cellspacing='1px'>");
			br.append("<tr>");
			br.append("<td class='multiRPTLabel' WIDTH='35%' align='CENTER'>Item Name</td>");
			br.append("<td class='multiRPTLabel' WIDTH='20%' align='CENTER'>Billed Qty</td>");
			br.append("<td class='multiRPTLabel' WIDTH='20%' align='CENTER'>Batch/Serial No.</td>");
			br.append("<td class='multiRPTLabel' WIDTH='20%' align='CENTER'>M.R.P.</td>");
			br.append("</tr>");
			wb.beforeFirst();
			if (wb.size() != 0) {

				while (wb.next()) {
					strIssueDate = wb.getString(2);
					strIssueNo = wb.getString(1);
					strIndentingStore = wb.getString(3);
					strIndentNo = wb.getString(4);
					strIndentDate = wb.getString(5);
					br.append("<input type='hidden' name='strHlpIssueNo' id='strHlpIssueNo" + i + "' value="
							+ strIssueNo + " />");
					br.append("<input type='hidden' name='strHlpIndentNo' id='strHlpIndentNo" + i + "' value="
							+ strIndentNo + " />");
					br.append("<input type='hidden' name='strHlpIndentDate' id='strHlpIndentDate" + i + "' value="
							+ strIndentDate + " />");
					br.append("<input type='hidden' name='strHlpCrNo' id='strHlpCrNo" + i + "' value=" + wb.getString(6)
							+ " />");
					br.append("<input type='hidden' name='strHlpPatientName' id='strHlpPatientName" + i + "' value="
							+ wb.getString(7) + " />");
					br.append("<input type='hidden' name='strHlpBillDtl' id='strHlpBillDtl" + i + "' value="
							+ wb.getString(8) + " />");

					br.append("<tr>");
					br.append("<td WIDTH='25%' CLASS='multiPOControl' >" + wb.getString(9) + "</td>");
					br.append("<td WIDTH='20%' CLASS='multiPOControl' >"
							+ wb.getString(8).replace("^", "#").split("#")[1] + "</td>");
					br.append("<td WIDTH='20%' CLASS='multiPOControl' >" + wb.getString(10) + "</td>");
					br.append("<td WIDTH='20%' CLASS='multiPOControl' >" + wb.getString(11) + "</td>");

					br.append("</tr>");
					i++;
					tot += Float.parseFloat(wb.getString(8).replace("^", "#").split("#")[1].split(" ")[0])
							* Float.parseFloat(wb.getString(11).split("/")[0]);
				}
				br.append("<tr>");
				br.append("<td colspan='4' CLASS='multiPOControl' ><div align='right'><b> Total Cost : " + tot
						+ "</b></div></td>");
				br.append("</tr>");
				br.append("<tr>");
				br.append(
						"<td colspan='4' CLASS='multiPOControl' ><div align='right'><a href='#' class='button' onclick='save();'><span class='issue'><div align='center'>Issue</div></span></a></div></td>");
				br.append("</tr>");
				br.append("</table> ");
			} else {
				br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td  CLASS='multiControl' colspan='5'>" + "No Record Found" + "</td>");
				br.append("</tr>");
				br.append("</table> ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}

		return br.toString();
	}

	/*
	 * replace with below HLP method getIssueDetailsBS >>
	 * getPreviousIssueDetails==Issue no & date
	 */
	public static String getIssueDetailsBS(WebRowSet ws) throws SQLException {
		StringBuffer sb = new StringBuffer();

		int i = 0, j = 1;

		try {

			if (ws != null && ws.size() > 0) {
				sb.append("<div class='row'>");

				sb.append(
						"<div class='col-sm-1'><i class='fas fa-angle-double-left' onclick='nxtChunk(\"prev\")'></i></div>");
				sb.append("<div class='col-sm-10' id='chunks'>");

				while (ws.next()) {

					if (i == 0) {
						sb.append("<div class='row'  id='0-chunk' >");
					}
					if (i == (3 * j)) {
						sb.append("<div class='row'  id='" + j + "-chunk' style='display:none;'>");
						j++;
					}

					/*
					 * if(i>0) { if(3%(i)==0) { if(j>1)
					 * sb.append("<div class='row'  id='"+j+"-chunk' style='display:none;'>"); }
					 * }else sb.append("<div class='row'  id='1-chunk' >");
					 */

					sb.append("<div class='col-sm-4'>");
					String strIssueNo = ws.getString(1);
					String strIssueDate = ws.getString(2);
					String strIssueSoreID = ws.getString(3);
					if (strIssueNo == null)
						strIssueNo = "----";
					if (strIssueDate == null)
						strIssueDate = "----";

					sb.append("<input type='hidden' name='strIssueNo' id='strIssueNo" + i + "' value=" + strIssueNo
							+ " >");
					sb.append("<input type='hidden' name='strIssueSoreID' id='strIssueSoreID" + i + "' value="
							+ strIssueSoreID + " >");
					sb.append(
							"<p align='center'><i class='fa fa-folder fa-2x' style='color:blue' onclick='callIssuePop(this)'></i></p>");
					sb.append(
							"<a name='strIssueDtl' id='strIssueDtl' STYLE='CURSOR:POINTER;color:rgba(75,75,75, 0.7)' onClick='getIssuePopUp(this, \""
									+ i + "\" );'><p align='center'>");
					sb.append(strIssueNo + "</p><p align='center'>" + strIssueDate);
					sb.append("</p></a>");
					sb.append("</div>");

					/*
					 * if(i>0) { if(3%(i)==0) { if(j>1) sb.append("</div>"); j++; }} else
					 * sb.append("</div>");
					 */
					// if(ws.size()>=((3*j)-1))
					if (i == ((3 * j) - 1)) {
						sb.append("</div>");

					} else {
						if (i == (ws.size() - 1))
							sb.append("</div>");
					}

					i++;

				}
				sb.append(
						"</div><div class='col-sm-1'><i class='fas fa-angle-double-right' onclick='nxtChunk(\"nxt\")'></i></div>");

				sb.append("</div>");
			} else {
				sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
				sb.append("<TR>");
				sb.append("<TD WIDTH='25%' align='center' colspan='4'><font color = 'red'>" + "No Record Found"
						+ "</font></TD>");
				sb.append("</TR>");
				sb.append("</table>");

			}
		} catch (Exception e) {
			e.printStackTrace();
			;
			throw new HisException("Issue Transaction", "InjAdministrationTransHLP .getIssueDetails() -->",
					e.getMessage());

		}

		return sb.toString();
	}

	/* == new added for printing Issue no & date == */
	public static String getPreviousIssueDetails(InjAdministrationTransVO vo, WebRowSet ws) {
		StringBuffer sb = new StringBuffer("");

		/*
		 *  1.ISSUE_DATE, 
		 *  2.ISSUE _TO
		 *  3.STORE_NAME,
		 *  4.BRAND_ITEM_NAME,  
		 *  5.BATCH_NO,
		 *  6.EXPIRY_DATE,
		 *  7.ISSUE_BY,
		 *  8.ADMINISTER_MODE, 
		 *  9.ADMINISTER_TYPE,
		 *  10.Doses
		 */
		WebRowSet ws1 = vo.getStrIssueDetailWs();
		int i = 1;

		try {
			HttpServletRequest request=null;
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(vo.getStrHospitalCode());
			Map require =new HashMap();
		    require.put("REQUEST", request);
		    require.put("FORMAT", "html");
		    require.put("HOSPCODE", vo.getStrHospitalCode());

			String strHeader=hisUtil.getHospitalHeaderMain(require); 
			System.out.println("------strHeader.toString()-----"+strHeader.toString());
			sb.append("<br>");
			sb.append("<table align='center' border='0' cellspacing='0' cellpadding='0' height='10'> ");
			sb.append(
					"<tr><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printData12(2);' /></div></td>");
			sb.append("</tr>");
			sb.append(strHeader.toString());
			sb.append("</table> ");
			sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
			
			sb.append("</table>");	
			sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + 
					"<tr> "
					+ " <td colspan='3'></td>"
					+ " <td colspan='3'align='center' style='font-size:15px'><b>Previous Issued Details</b></td>"
					+ " <td colspan='3'></td>");
			sb.append("</tr>");
			
			sb.append("<tr>"
					+ "<td align='center' colspan='12'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "For Store Name ::<b>"+vo.getStrStoreName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
				);
			
			sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Date ::<b>"
					+ vo.getStrFromDate() + "</b>  to  <b>"
					+ vo.getStrToDate() + "</b></font></td><td align='center' colspan='2'></td></tr>");
			
			/*
			 * sb.append(" <tr><td align='center' colspan='3'></td> " +
			 * "<td align='center' colspan='3'>" +
			 * "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
			 * "For Patient ::<b>" + vo.getStrPatientName() +
			 * "</b></font></td><td align='center' colspan='2'></td></tr>");
			 */
			sb.append(" <tr> "
			        + " <td colspan='3'></td>"
					+ " <td colspan='3'></td>"
					+ " <td colspan='3'><br></td>");
			sb.append("</tr>");
			
			sb.append("</table>");
			

			sb.append("<div class='row'>");
			sb.append("<div class='col-md-12'>");
			sb.append("<table class='table text-uppercase' align='center'  border='1px' cellpadding='0px' cellspacing='0px'>");
			sb.append("<thead class='thead-dark'>");
//			sb.append("<thead >");
			sb.append("<tr>");
			sb.append(
					"<th width='5%'  style='font-weight:350 !important ;font-size: 14px !important;text-align:center;'><b>S.No</b></th>");
			sb.append(
					"<th width='15%' style='font-weight:350 !important ;font-size: 14px !important;text-align:center;'><b> Issue To /<br> Issue Date </b></th>");
//			sb.append(
//					"<th  width='10%' style='font-weight:350 !important ;font-size: 16px !important;text-align:center;'><b>Issue To</b></th>");
			sb.append(
					"<th  width='25%' style='font-weight:350 !important ;font-size: 14px !important;text-align:center;'><b>Item Name</b></th>");
			sb.append(
					"<th  width='10%' style='font-weight:350 !important ;font-size: 14px !important;text-align:center;'><b>Batch No</b></th>");
			sb.append(
					"<th  width='5%' style='font-weight:350 !important ;font-size: 14px !important;text-align:center;'><b>Admn Mode</b></th>");
			sb.append(
					"<th  width='5%' style='font-weight:350 !important ;font-size: 14px !important;text-align:center;'><b>Admn Type</b></th>");
			sb.append(
					"<th  width='5%' style='font-weight:350 !important ;font-size: 14px !important;text-align:center;'><b>Expiry Date</b></th>");
			sb.append(
					"<th  width='15%' style='font-weight:350 !important ;font-size: 14px !important;text-align:center;'><b>Doses</b></th>");
			sb.append(
					"<th  width='15%' style='font-weight:350 !important ;font-size: 14px !important;text-align:center;'><b>Issue By</b></th>");
			sb.append("</tr>");
			sb.append("</thead>");

			/*
			 * String strIssueNo = ws1.getString(1); String strIssueDate = ws1.getString(2);
			 * String strIssueStoreID = ws1.getString(3);
			 * 
			 * if (strIssueNo == null) strIssueNo = "----"; if (strIssueDate == null)
			 * strIssueDate = "----";
			 * 
			 * 
			 */

			if (ws1.size() != 0) {
				while (ws1.next()) {
					
					
					/*   pkg_mms_view2.proc_hrgt_patient_inj_advice_dtl [ Mode - 2]
			    
	                    
					  */
					/* 
					 * pkg_mms_view2.proc_hrgt_patient_inj_advice_dtl [ Mode - 3]
					 * 
					 *  1.ISSUE_DATE, 
					 *  2.ISSUE _TO
					 *  3.STORE_NAME,
					 *  4.BRAND_ITEM_NAME,  
					 *  5.BATCH_NO,
					 *  6.EXPIRY_DATE,
					 *  7.ISSUE_BY,
					 *  8.ADMINISTER_MODE, 
					 *  9.ADMINISTER_TYPE,
					 *  10.Doses
					 */
	    			
						
						sb.append("<tr>");	
						
						sb.append("<td   style='width:5%;font-weight: 400; font-size: 0.8rem; text-align:center;color:black;'>");
						sb.append(i);			
						sb.append("</td>");
						
						sb.append("<td   style='width:15%;font-weight: 400; font-size: 0.8rem; text-align:left;color:black;'>");
						sb.append(ws.getString(2));			
						sb.append(" /<br>");
						sb.append(ws.getString(1));
						sb.append("</td>");
					/*
					 * sb.
					 * append("<td   style='width:10%;font-weight: 400; font-size: 0.8rem; text-align:left;color:black;'>"
					 * ); sb.append(ws.getString(2));
					 */		
						sb.append("</td>");
						sb.append("<td   style='width:25%;font-weight: 400; font-size: 0.8rem; color:black;text-align:left;'>");
						sb.append(ws.getString(4));			
						sb.append("</td>");
						
						sb.append("<td   style='width:10%;font-weight: 400; font-size: 0.8rem; color: black;text-align:left;'>");
						sb.append(ws.getString(5));													
						sb.append("</td>");
						
						String admnType = "";
						if(ws.getString(9).equals("10")) {
							admnType = "Whole";
						}
						else if(ws.getString(9).equals("11")) {
							admnType = "Partial";
						}
						
						sb.append("<td   style='width:5%;font-weight: 400; font-size: 0.8rem; color: black;text-align:left;'>");
						sb.append(ws.getString(8));
						//sb.append(" / <br>");
						//sb.append(admnType);
						sb.append("</td>");
						
					 
					  sb.append("<td   style='width:5%;font-weight: 400; font-size: 0.8rem; color: black;text-align:left;'>"); 
					  sb.append(admnType); 
					  sb.append("</td>");
		
						sb.append("<td   style='width:5%;font-weight: 400; font-size: 0.8rem; color: black;text-align:center;'>");
						sb.append(ws.getString(6));			
						sb.append("</td>");
						
						sb.append("<td   style='width:15%;font-weight: 400; font-size: 0.8rem; color: black;text-align:left;'>");
						sb.append(ws.getString(10));													
						sb.append("</td>");
						
						sb.append("<td   style='width:15%;font-weight: 400; font-size: 0.8rem; color: black;text-align:left;'>");
						sb.append(ws.getString(7));			
						sb.append("</td>");
						
															
						sb.append("</tr>");
					i++;
				}

				sb.append("</table> ");
				sb.append("</div>");
				sb.append("</div>");
			} else {
				sb.append("<div class='row'>");
				sb.append("<div class='col-md-12'>");
				sb.append("<table class='table' style='font-weight:350 !important ;font-size: 16px !important;'>");
				sb.append("<tr>");
				sb.append(
						"<td colspan='5' align='center' style='font-weight:350 !important ;font-size: 16px !important;color:red;'>"
								+ "No Record Found" + "</td>");
				sb.append("</tr>");
				sb.append("</table> ");
				sb.append("</div>");
				sb.append("</div>");
				sb.append("</div>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			new HisException("Local Purchase Report", "BreakageItemDtlTransHLP.getBreakageDetails()-->",
					e.getMessage());
		}
		// System.out.println("sb"+sb);
		return sb.toString();
	}

	public static String getIssuedDetailNEW(WebRowSet wb) throws SQLException {
		StringBuffer br = new StringBuffer();
		String strIssueDate = "";
		String strIssueNo = "";
		String strIndentingStore = "";
		String strIndentNo = "";
		String strIndentDate = "";

		int i = 0;

		try {
			br.append("<div class='row'>");
			br.append("<table class='table'>");
			br.append("<tr>");
			br.append("<td colspan='2'>");
			br.append(
					"<div id='' style='font-weight:350 !important ;font-size: 16px !important;'>&nbsp;Issue Details </div>");
			br.append("</td></tr></table>");
			br.append("</div>");

			br.append("<div class='row'>");
			br.append("<div class='col-md-12'>");
			br.append("<table class='table text-uppercase' align='center'>");
			br.append("<tr>");
			br.append("<thead class='thead-dark'>");
			br.append(
					"<td WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Drug Name</td>");
			br.append(
					"<td  WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Issue/Return Qty</td>");
			br.append(
					"<td  WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Rate/Unit</td>");
			br.append(
					"<td  WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Cost</td>");
			br.append("</thead>");
			br.append("</tr>");

			if (wb.size() != 0) {

				while (wb.next()) {
					strIssueDate = wb.getString(2);
					strIssueNo = wb.getString(1);
					strIndentingStore = wb.getString(3);
					strIndentNo = wb.getString(4);
					strIndentDate = wb.getString(5);

					br.append("<input type='hidden' name='strHlpIssueNo' id='strHlpIssueNo" + i + "' value="
							+ strIssueNo + " />");
					br.append("<input type='hidden' name='strHlpIndentNo' id='strHlpIndentNo" + i + "' value="
							+ strIndentNo + " />");
					br.append("<input type='hidden' name='strHlpIndentDate' id='strHlpIndentDate" + i + "' value="
							+ strIndentDate + " />");

					br.append("<tr>");
					br.append(
							"<td WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"
									+ strIssueDate + "</td>");
					br.append("<td WIDTH='20%' align='center'>");
					br.append("<input type='hidden' name='flag' id='flag" + i + "' value=" + "0" + " />");
					br.append("<div class='popup' id='IssueItempopup' style='display: none'></div>");
					br.append(
							"<a align='center' style='cursor:pointer;color:blue;font-weight:350 !important ;font-size:16px;' title='Issue No Item Details' onClick='showPopUp(this,\""
									+ i + "\");'>" + strIssueNo + "</a></td>");
					br.append("</td>");
					br.append(
							"<td WIDTH='20%' align='left'   style='font-weight:350 !important ;font-size: 16px !important;' >"
									+ strIndentingStore + "</td>");
					br.append(
							"<td WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' >"
									+ strIndentNo + "</td>");
					br.append(
							"<td WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' >"
									+ strIndentDate + "</td>");
					br.append(
							"<td WIDTH='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' ><img src='../../hisglobal/images/search_icon1.gif' onclick='generateIssueReportFunc(this,\""
									+ i + "\");' style='cursor: pointer;' title='Print Issue Item Details'></td>");
					br.append("</tr>");
					i++;
				}

				br.append("</table> ");
				br.append("</div>");
				br.append("</div>");
			} else {
				br.append("<div class='row'>");
				br.append("<div class='col-md-12'>");
				br.append("<table class='table' style='font-weight:350 !important ;font-size: 16px !important;'>");
				br.append("<tr>");
				br.append(
						"<td colspan='5' align='center' style='font-weight:350 !important ;font-size: 16px !important;color:red;'>"
								+ "No Record Found" + "</td>");
				br.append("</tr>");
				br.append("</table> ");
				br.append("</div>");
				br.append("</div>");
				br.append("</div>");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
		return br.toString();
	}

	public static String getIssuePopUpBS(String strHospCode, String strStoreId, String strIssueNo, String strCrNo)
			throws IOException {
		/* Creating VO & BO Object Here */
		InjAdministrationTransVO vo = new InjAdministrationTransVO();
		InjAdministrationTransBO bo = new InjAdministrationTransBO();

		/* Declaring Variable */
		StringBuffer sb = new StringBuffer("");
		String strItemName = "";
		String strIssueQtyUnit = "";
		String strRateUnit = "";
		String strCost = "";
		WebRowSet ws = null;

		/* Setting Value in vo Object */
		vo.setStrStoreId(strStoreId);
		vo.setStrHospitalCode(strHospCode);
		vo.setStrIssueNo(strIssueNo);

		/* Calling BO Method */
		bo.getIssueDtlPopUp(vo);

		ws = vo.getStrIssueDtlPopUpWs();

		sb.append("<div>Issued Item Details</div>");
		sb.append("<table width='100%' class='table' border='1px'>");
		sb.append("<thead>");
		sb.append("<tr>");
		sb.append("<th scope='col' style='text-align:center' >Drug Name</th>");
		sb.append("<th scope='col' style='text-align:center'>Issue/Return Qty</th>");
		sb.append("<th scope='col' style='text-align:center'>Rate/Unit</th>");
		sb.append("<th scope='col' style='text-align:center'>Cost</th>");
		sb.append("</tr></thead>");
		sb.append("<tbody>");
		try {

			if (ws != null && ws.size() != 0) {
				while (ws.next()) {

					strItemName = ws.getString(1).trim();
					strIssueQtyUnit = ws.getString(2).trim();
					strRateUnit = ws.getString(3).trim();
					strCost = ws.getString(4).trim();

					if (strItemName == null || strItemName.equals(""))
						strItemName = "-----";
					if (strIssueQtyUnit == null || strIssueQtyUnit.equals(""))
						strIssueQtyUnit = "-----";
					if (strRateUnit == null || strRateUnit.equals(""))
						strRateUnit = "-----";
					if (strCost == null || strCost.equals(""))
						strCost = "-----";

					sb.append("<tr>");
					sb.append("<td  width='45%' style='text-align:left'>");
					sb.append(strItemName);
					sb.append("</td>");
					sb.append("<td  width='15%' style='text-align:center'>");
					sb.append(strIssueQtyUnit);
					sb.append("</td>");
					sb.append("<td width='25%' style='text-align:center'>");
					sb.append(strRateUnit);
					sb.append("</td>");
					sb.append("<td width='15%' style='text-align:center'>");
					sb.append(strCost);
					sb.append("</td>");
					sb.append("</tr>");

				}
				sb.append("</tbody>");
			}

			else {
				sb.append("<tr><td><font color='red'>No Matching Record Found</font></td></tr>");

			}

		} catch (SQLException e) {

			throw new HisException("Issue Transaction", "InjAdministrationTransHLP .getIssuePopUp() -->",
					e.getMessage());
		}

		sb.append("</table>");

		return sb.toString();
	}

	public static String getOnlineTreatmentDtls(WebRowSet ws, InjAdministrationTransFB formBean) throws Exception {
		StringBuffer str = new StringBuffer("");
		int i = 1;
		int count = 0;
		int counts = 1;
		String brandId = "";
		GlobalVO voObj = new GlobalVO();
		WebRowSet ws1 = null;
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		voObj.setStrValue1(formBean.getStrCrNo());
		voObj.setStrValue2(formBean.getStrHospitalCode());

		voObj.setStrValue3(formBean.getStrStoreId().split("\\^")[0]);
		try {

			/*
			 * if (voObj.getStrMsgType().equals("1")) { throw new
			 * Exception(voObj.getStrMsgString()); }
			 */
			// PatientDtlBO boObj = new PatientDtlBO();
			// boObj.getPatientTreatmentDetails1(voObj);
			// ws1 = voObj.getGblWs2();

			// ws1 = voObj.getGblWs3();

			if (ws != null && ws.size() > 0) {
				str.append("<table class='table'>");
				str.append("<thead><th style='text-align:left; width:32%;'>Item Name</th>");
				str.append("<th style='text-align:left; width:15%;'>Batch No</th>");
				str.append("<th style='text-align:center;width:10%;'>Available Qty</th>");
				str.append("<th style='text-align:center;width:15%;'>Req Qty</th>");
				str.append("<th  style=\"width:10%\"><font color=\"red\">*</font>Quantity</th>");
				str.append("<th  style=\"width:8%\"><font color=\"red\">*</font>Cost</th>");
				str.append("<th  style=\"width:10%\">-</th>");
				str.append("</thead>");
				str.append("<tbody>");
				while (ws.next()) {
					str.append("<tr>");
					String itemParamValue = ws.getString(1);
					String strdrugName = ws.getString(2);
					String strRate = (itemParamValue.split("#")[1]).split("\\^")[1];
					String strDoseName = "";
					String strFrequency = "";
					String strStartDate = "";
					String strEndDate = "";
					String strAvalqty = ws.getString(1).split("\\^")[3];
					String strReqqty = ws.getString(3);
					String strBatchNo = ws.getString(1).split("\\^")[10];

					if (strdrugName == null)
						strdrugName = "----";
					if (strDoseName == null)
						strDoseName = "----";
					if (strFrequency == null)
						strFrequency = "----";
					if (strStartDate == null)
						strStartDate = "----";
					if (strEndDate == null)
						strEndDate = "----";

					brandId = ws.getString(4);

					if (map.containsKey(brandId)) {
						if (map.get(brandId) >= 0) {
							int a = map.get(brandId) - Integer.parseInt(strAvalqty);
							if (a >= 0)
								map.put(brandId, -1);
							else
								map.put(brandId, a);
						}
					} else {
						if (Integer.parseInt(strReqqty) - Integer.parseInt(strAvalqty) <= 0)
							map.put(brandId, 0);
						else
							map.put(brandId, Integer.parseInt(strReqqty) - Integer.parseInt(strAvalqty));

					}
					// str.append("<table class='table'>");

					// System.out.println(map);
					if (map.containsKey(brandId)) {
						if (map.get(brandId) <= 0) {
							str.append("<td style='text-align:left; '>  ");
							str.append("<input type='hidden' name='itemParamValue' id='itemParamValue1-" + i
									+ "' value='" + itemParamValue + "'>");
							str.append("<input type='hidden' name='itemUserValue' id='itemUserValue1-" + i + "' value='"
									+ itemParamValue.split("#")[2] + "'>");

							str.append("<input type='hidden' name='itemCalcValue' id='itemCalcValue1-" + i + "' value='"
									+ itemParamValue.split("#")[1] + "'>");

							str.append(strdrugName);

							str.append("</td><td style='text-align:left;  '>");
							str.append(strBatchNo);

							str.append("</td><td style='text-align:center; '>");
							str.append(strAvalqty.replace("&", "<br>"));

							str.append("</td><td style='text-align:center; '>");
							str.append(strReqqty);
							// str.append("<td WIDTH='10%' CLASS='multiControl' ><input type='text'
							// autocomplete='off' maxlength='15' onkeypress='return validateData(event,5);'
							// id='strQtyText1-"+ i + "' onblur='return QtyValidation('1-"+i+"');'
							// name='strQtyText' class='txtFldMin' value='' > </td>");
							if (Float.parseFloat(strAvalqty.replace("&", "<br>")) > Float.parseFloat(strReqqty))
								str.append(
										"<td style=''><div style='display: block;'><input type='number' autocomplete='off' min='1'  onkeypress='return validateData(event,5);' id='strQtyTreatText1-"
												+ i + "' onblur='QtyTreatValidation(\"1-" + i
												+ "\");'  name='strQtyText' class='form-control' value=" + strReqqty
												+ " ></div></td>");
							else
								str.append(
										"<td style=''><div style='display: block;'><input type='number' autocomplete='off' min='1'  onkeypress='return validateData(event,5);' id='strQtyTreatText1-"
												+ i + "' onblur='QtyTreatValidation(\"1-" + i
												+ "\");'  name='strQtyText' class='form-control' value='' ></div></td>");

							// str.append("</td width='10%' class='multiControl'>");

							str.append("<td style=''>");
							DecimalFormat df = new DecimalFormat("0.00");
							Double totalCost = Double.parseDouble(strReqqty) * Double.parseDouble(strRate);
							str.append("<input name='strTotalCost' id='strTotalCost1-" + i
									+ "'  class='form-control' type='hidden'>");
							str.append("<div id='strQuantityTreatText1-" + i + "'  style='display: block;'>");
							str.append("<input name='strTotalTreatCostText' id='strTotalTreatCostText1-" + i
									+ "' class='form-control' value=" + df.format(totalCost)
									+ " maxlength='5'  readonly='' type='text'>");
							str.append("</div></td>");

							str.append("<td>");
							// str.append("<div id='strQuantityText1-"+i+"' align='center' style='display:
							// block;'>");
							// str.append("<img style='cursor: pointer;height: 20px'
							// id='strDeleteButtonDivId' tabindex='1' src='../../hisglobal/images/Minus.png'
							// onclick='deleteRow('1-"+i+"','1','0');' title='Click here to Delete Item'
							// onkeypress='onPressingEnter(this,event)'>");
							// str.append("</div></td>");
							str.append("</td></tr>");
							i++;
							count++;
							counts++;
							brandId = ws.getString(4);

							Integer strReqqty1 = Integer.parseInt(strReqqty) - Integer.parseInt(strAvalqty);
							if (strReqqty1 <= 0)
								map.put(brandId, 0);

						}
					}

				}
				str.append("</tbody>");
				str.append("</table>");
				str.append("</div>");
			} else {
				str.append("<table class='table'>");
				str.append("<thead><th style='text-align:left; width:32%;'>Item Name</th>");
				str.append("<th style='text-align:left; width:15%;'>Batch No</th>");
				str.append("<th style='text-align:center;width:10%;'>Available Qty</th>");
				str.append("<th style='text-align:center;width:15%;'>Req Qty</th>");
				str.append("<th  style=\"width:10%\"><font color=\"red\">*</font>Quantity</th>");
				str.append("<th  style=\"width:8%\"><font color=\"red\">*</font>Cost</th>");
				str.append("<th  style=\"width:10%\">-</th>");
				str.append("</thead>");
				str.append(
						"<tr><td colspan='8'><font color='red'><b>No Prescribed Data Found/Items Already Issued</b></font></td></tr></table>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("PatientDtlHLP-->patientTreatmentDtl-->" + e.getMessage());
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}
		return str.toString();
	}

	/* ============= >> RJ47 */

	public static String getAfterSaveVoucher(InjAdministrationTransVO vo, String mode) throws Exception {
		StringBuffer sb = new StringBuffer("");
		int i = 1;
		ResourceBundle res = null;
		WebRowSet ws = null;
		WebRowSet ws1 = null;
		String strTableWidth = "825";

		try {

			sb.append("<table  width='825' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + " <tr> "
					+ " <td colspan='1'></td>"
					+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName()
					+ "' ></div></td>");
			if (mode.equals("1")) {
				sb.append(
						"<td colspan='1'><td colspan='1'><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printData_O();' /><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/stop.png' onClick='cancelToMainPage(1);' /></div></td>");
			} else {
				if (mode.equals("2")) {
					sb.append(
							"<td colspan='1'><td colspan='1'><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printData_O();' /><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/stop.png' onClick='cancelToMainPage(2);' /></div></td>");
				} else {
					sb.append("<td colspan='1'><td colspan='1'><div id='printImg' align='right'></div></td>");
				}
			}
			sb.append("</tr>");

			sb.append("</table>");

			sb.append("<table width='").append(strTableWidth)
					.append("' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr>");
			sb.append(
					"<td width='100%' align='center' colspan='5'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Invoice</b></font></td> ");

			/*
			 * 0 NVL(HIPNUM_ADMNO, '0') 1 ^ NVL(HRGNUM_EPISODE_CODE, '0') 2 ^
			 * NVL(HRGNUM_VISIT_NO,'0') 3 ^ NVL(TO_CHAR(HIPDT_ADMDATETIME,'DD-Mon-YYYY
			 * HH24:MI:SS'),' ') 4 ^ NVL(HIPNUM_ADM_ADVNO,'0') 5 ^ NVL(GNUM_DEPT_CODE,'000')
			 * 6 ^ NVL(HIPNUM_WARD_CODE,'0') 7 ^ NVL(HIPNUM_ROOM_CODE,'0') 8 ^
			 * NVL(HIPNUM_BED_CODE,'0') 9 ^ NVL(HIPNUM_TREAT_CATEG_CODE,'0') 10 ^
			 * NVL(HIPNUM_ISNEWBORN,'0') 11 ^ NVL(HIPNUM_MOTHADMNO,'0') 12 ^
			 * NVL(HRGNUM_MLC_NO,'0') 13 ^ NVL(HIPNUM_OCCUP_ID,'0') 14 ^
			 * NVL(TO_CHAR(HIPDT_BEDALLOC_DATETIME,'DD-Mon-YYYY HH24:MI:SS'),' ') 15 ^
			 * NVL(HIPNUM_LENGTHOFSTAY,'0')) 16 ^ NVL(GNUM_DEPTUNIT_CODE,'00000') 17 ^
			 * hblnum_pataccount_status
			 */

			/*
			 * vo.getStrPatientDtlHidVal() HRGDT_DOB || ''^'' ||GNUM_GENDER_CODE
			 * ||''^''||HGNUM_PAT_STATUS_CODE || ''^''|| HGNUM_PATIENT_CAT_CODE || ''^''
			 * ||HRGNUM_IS_MLC ||''^''||HRGNUM_ISNEWBORN || ''^''|| HRGNUM_ID_NO
			 */
			// By Vivek
			sb.append("</tr>");
			sb.append("<tr> ");
			sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>")
					.append("PIN:</b></font></td> ");
			sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>")
					.append(vo.getStrPuk()).append("</font></td> ");
			sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>")
					.append("Issue Store:</b></font></td> ");
			sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif'  size='1'>"
					+ vo.getStrStoreName() + "</font></td> ");
			sb.append("</tr>");

			sb.append("<tr> ");
			sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>")
					.append("Invoice No:</b></font></td> ");
			sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif'  size='1'>")
					.append(vo.getStrIssueNumber()).append("</font></td> ");
			sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>")
					.append("Invoice Date:</b></font></td> ");
			sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif'  size='1'>")
					.append(vo.getStrIssueDate()).append("</font></td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<table width='").append(strTableWidth)
					.append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
			sb.append("<tr>");
			sb.append("<td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif'  size='1'>");
			sb.append(vo.getStrPatientDtl());
			sb.append("</font></td> ");
			sb.append("</tr> ");
			sb.append("</table>");

			sb.append("<table width='").append(strTableWidth)
					.append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
			sb.append("<tr>");
			sb.append("<td colspan='9' align='left'><hr size='1'></td>");
			sb.append("</tr>");
			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append(
					"<td align='center' width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>SL</b></font> ");
			sb.append("</td>");
			sb.append(
					"<td align='center' width='39%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>Product</b></font> ");
			sb.append("</td>");
			sb.append(
					"<td align='center' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>Batch No.</b></font> ");
			sb.append("</td> ");
			sb.append(
					"<td align='center' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>Expiry</b></font>");
			sb.append("</td> ");
			sb.append(
					"<td align='right'  width='8%'><font  face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>Qty</b></font>");
			sb.append("</td> ");
			sb.append(
					"<td align='right'  width='8%'><font  face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>MRP</b></font>");
			sb.append("</td> ");
			sb.append(
					"<td align='right'  width='8%'><font  face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>Rate</b></font>");
			sb.append("</td> ");
			sb.append(
					"<td align='right'  width='8%'><font  face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>DIS(%)</b></font>");
			sb.append("</td> ");
			sb.append(
					"<td align='right'  width='8%'><font  face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>Cost</b></font>");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("<tr>");
			sb.append("<td colspan='9' align='left'><hr size='1'></td>");

			sb.append("</tr>");
			float NetAmount = 0.0F;
			String rem = "";
			String user = "";
			double dis, amount, markedprice, salePrice, per;
			ws = vo.getWsIssueDetails();

			if (ws != null && ws.size() > 0) {

				while (ws.next()) {
					/*
					 * 1. Issue No 2. Issue Date 3. Pat Name 4. Store Name 5. Generic Name 6. Brnad
					 * Name 7. BATCH 8. EXP Date 9. Rate / Unit 10. Issue Qty Wth Unit 11. Store Id
					 * 12. Item Id 13. Brand Id 14. BATCH 15. Exp Date 16. Rate 17. Rate Unit Id 18.
					 * Rate Base Value 19. Base Vale 20. Issue Qty Unit Id 21. Qty Base Value 22. Sl
					 * Npo 23. NVL 24. Catg Code 25. Bal Qty 26. NVL 27. Remarks 28. Rec By 29.
					 * HSTNUM_TOTAL_COST 30. Budget 31. NVL 32. Issue Date 33. MRP of Drug 34. Total
					 * Purchase Cost 35. PIN 36. Issue By User Name 37. Order By 38. Hosp Name 39.
					 * HSTSTR_LOCATION
					 */

					vo.setStrUserName(ws.getString(36));
					/*
					 * Discount = Marked Price Selling Price And Discount Percentage =
					 * (Discount/Marked price) x 100
					 */
					markedprice = Double.parseDouble(ws.getString(33));
					salePrice = Double.parseDouble(ws.getString(16));
					dis = markedprice - salePrice;
					per = (dis / markedprice) * 100;

					sb.append("<tr> ");
					sb.append(
							"<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>");
					sb.append(i + ".");
					sb.append("</font></td> ");
					sb.append(
							"<td align='left' width='39%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
					sb.append(ws.getString(6));
					sb.append("</font></td> ");
					sb.append(
							"<td align='center' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
					sb.append(ws.getString(7));
					sb.append("</font></td> ");
					sb.append(
							"<td align='center' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>");
					sb.append(ws.getString(8));
					sb.append("</font></td> ");
					sb.append(
							"<td style=\"text-align:right;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>");
					sb.append(ws.getString(10));
					sb.append("</font></td> ");
					sb.append(
							"<td style=\"text-align:right;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>");
					sb.append(ws.getString(33));
					sb.append("</font></td> ");
					sb.append(
							"<td style=\"text-align:right;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>");
					sb.append(ws.getString(16));
					sb.append("</font></td> ");
					sb.append(
							"<td style=\"text-align:right;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>");
					sb.append(Math.round(per));
					sb.append("</font></td> ");
					sb.append(
							"<td style=\"text-align:right;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>");
					sb.append(ws.getString(29));
					sb.append("</font></td> ");
					sb.append("</tr> ");
					NetAmount = NetAmount + Float.parseFloat(ws.getString(29));
					i++;

				}

				sb.append("<tr>");
				sb.append("<td colspan='9' align='left'><hr size='1'></td>");
				sb.append("</tr>");

				sb.append("<tr>");
				sb.append(
						"<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><b>GRAND TOTAL</b></font></td>");
				sb.append(
						"<td colspan='1' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>");
				sb.append(Math.round(NetAmount));

				sb.append("</font></td>");
				sb.append("</tr>");

				sb.append("<tr>");
				sb.append("<td colspan='9' align='left'><hr size='1'></td>");
				sb.append("</tr>");

				sb.append("<tr>");
				sb.append(
						"<td colspan='4' align='left'><u><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>Terms & Conditions</font></td>");
				sb.append(
						"<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>FOR I.G.I.M.S CENTRAL PHARMACY</font></td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append(
						"<td colspan='5' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>Un-used Medicine must be returned before discharge</font></td>");
				sb.append("<td colspan='4' align='center'></td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append(
						"<td colspan='3' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>User:"
								+ vo.getStrUserName() + "</font></td>");
				sb.append("<td colspan='3' align='left'>User Sign</td>");
				sb.append(
						"<td colspan='3' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Authorised Signatory</font></td>");
				sb.append("</tr>");

			} else {
				sb.append("<tr> ");
				sb.append(
						"<td colspan='9' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>No Reocrd</b><br/><br/></font></td> ");
				sb.append("</tr> ");
			}

			sb.append("</table> ");
			sb.append("<table align='center' width='").append(strTableWidth)
					.append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr>");
			sb.append("<td width='10%'></td>");
			sb.append(
					"<td width='80%' align='center'><b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("</table>");
		} catch (Exception var16) {
			var16.printStackTrace();
			throw var16;
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}

		}

		return sb.toString();
	}

	public static boolean getIssuePopUpForDotMatrix_ORG(String strHospCode, String strStoreId, String strIssueNo,
			String strCrNo, HttpServletRequest request) throws Exception {
		/* Creating VO & BO Object Here */
		InjAdministrationTransVO vo = new InjAdministrationTransVO();
		InjAdministrationTransBO bo = new InjAdministrationTransBO();
		StringBuffer contents = new StringBuffer("");
		HisUtil hisutil = new HisUtil("billing", "PrintHLP");
		boolean content = false;
		int k = 0;
		try {

			/* Declaring Variable */
			String rptContents = "";
			String strItemName = "";
			String strIssueQtyUnit = "";
			String strRateUnit = "";
			String strCost = "";
			String strAgeAndSex = "";
			String strPatientName = "";
			String strFatherOrHusbandName = "";
			String strSpouseName = "";
			String strReligion = "";
			String strCategoryName = "";
			String strCategoryCode = "";
			String strAddress = "";
			String strMlcNo = "";
			String strHiddenValue = "";
			String catGrp = "";
			String visitType = "";
			String episodeCode = "";
			String strEmailId = "";
			String contactNo = "";

			String pat_net_amt = "";
			String unit_net_amt = "";
			String strUserName = "";
			float NetAmount = 0.0F;

			/* Setting Value in vo Object */
			vo.setStrStoreId(strStoreId);
			vo.setStrHospitalCode(strHospCode);
			vo.setStrIssueNo(strIssueNo);
			vo.setStrCrNo(strCrNo);
			/* Calling BO Method */
			bo.getImgHeader(vo);
			bo.getDupDotMatrixVoucher(vo); // pkg_mms_view.Proc_Emp_Issue_Detail [ Mode - 3 ]
											// pkg_simple_view.PROC_HRGT_PATIENT_DTL [ Mode - 1 ]
			if (vo.getStrMsgType().equals("1")) {
				try {
					throw new Exception(vo.getStrMsgString());

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			WebRowSet ws = vo.getGblWs1();
			if (ws != null && ws.size() > 0) {
				if (ws.next()) {
					strAgeAndSex = ws.getString(2);
					strPatientName = ws.getString(3);
					strFatherOrHusbandName = ws.getString(4);
					strSpouseName = ws.getString(5);
					strReligion = ws.getString(6);
					strCategoryName = ws.getString(7);
					strCategoryCode = ws.getString(8);
					strAddress = ws.getString(9);
					strMlcNo = ws.getString(10);
					strHiddenValue = ws.getString(11);
					catGrp = ws.getString(13);
					visitType = ws.getString(15).split("\\^")[0];
					episodeCode = ws.getString(15).split("\\^")[1];
					if (strHiddenValue == null)
						strHiddenValue = "----";
					String[] id = strHiddenValue.split("\\^");
					strEmailId = ws.getString(16);
					contactNo = "";
					if (strHiddenValue != null) {
						contactNo = id[13];
					}

					if (strAgeAndSex == null)
						strAgeAndSex = "----";
					if (strPatientName == null)
						strPatientName = "----";
					if (strFatherOrHusbandName == null)
						strFatherOrHusbandName = "----";
					if (strSpouseName == null)
						strSpouseName = "----";
					if (strReligion == null)
						strReligion = "----";
					if (strCategoryName == null)
						strCategoryName = "----";
					if (strCategoryCode == null)
						strCategoryCode = "----";
					if (strAddress == null)
						strAddress = "----";
					if (strMlcNo == null)
						strMlcNo = "-----";

				}
			}

			while (vo.getWsIssueDetails().next()) {
				vo.setStrIssueDate(vo.getWsIssueDetails().getString(2));
				vo.setStrStoreName(vo.getWsIssueDetails().getString(4));
				if (k == 0) {
					strUserName = vo.getWsIssueDetails().getString(36);
					unit_net_amt = vo.getWsIssueDetails().getString(40);
				}
				NetAmount = NetAmount + Float.parseFloat(vo.getWsIssueDetails().getString(40));
				k++;
			}
			vo.getWsIssueDetails().beforeFirst();

			/*
			 * 1. Issue No 2. Issue Date 3. Pat Name 4. Store Name 5. Generic Name 6. Brnad
			 * Name 7. BATCH 8. EXP Date 9. Rate / Unit 10. Issue Qty Wth Unit 11. Store Id
			 * 12. Item Id 13. Brand Id 14. BATCH 15. Exp Date 16. Rate 17. Rate Unit Id 18.
			 * Rate Base Value 19. Issue Qty 20. Issue Qty Unit Id 21. Qty Base Value 22. Sl
			 * Npo 23. NVL 24. Catg Code 25. Bal Qty 26. NVL 27. Remarks 28. Rec By 29.
			 * HSTNUM_TOTAL_COST 30. Budget 31. NVL 32. Issue Date 33. MRP of Drug 34. Total
			 * Purchase Cost 35. PIN 36. Issue By User Name 37. Order By 38. Hosp Name 39.
			 * HSTSTR_LOCATION 40. ITEM_VALUE
			 */
			contents.append(
					hisutil.appendSpace("[", 40, 1).toUpperCase() + hisutil.appendSpace(" RECEIPT]", 54, 0) + "\n");
			printLine++;

			contents.append(hisutil.appendSpace(" PIN.", 10, 0) + ": "
					+ hisutil.appendSpace(vo.getStrCrNo().toUpperCase(), 20, 0));// 10+20=30+2
			contents.append(
					hisutil.appendSpace("DATE&TIME", 10, 0) + ": " + hisutil.appendSpace(vo.getStrIssueDate(), 21, 0));// 10+21=31+2
			contents.append(
					hisutil.appendSpace("ISSUE No.", 10, 0) + ": " + hisutil.appendSpace(vo.getStrIssueNo(), 20, 0));// 10+20=30+2
			contents.append("\n");
			printLine++;
			printLine++;

			contents.append(hisutil.appendSpace(" NAME", 10, 0) + ": "
					+ hisutil.appendSpace(hisutil.breakString(strPatientName, 20, "~").get(0).toUpperCase(), 20, 0));
			contents.append(hisutil.appendSpace("Mobile No", 10, 0) + ": " + hisutil.appendSpace(contactNo, 21, 0));
			contents.append(hisutil.appendSpace(" ", 10, 0) + " " + hisutil.appendSpace(" ", 20, 0));

			contents.append("\n");
			printLine++;
			printLine++;

			contents.append(hisutil.appendSpace(" CATEGORY", 10, 0) + ": "
					+ hisutil.appendSpace(hisutil.breakString(strCategoryName, 20, "~").get(0).toUpperCase(), 20, 0));
			contents.append(hisutil.appendSpace("AGE/SEX", 10, 0) + ": "
					+ hisutil.appendSpace(strAgeAndSex.toUpperCase(), 21, 0));
			contents.append(hisutil.appendSpace("ISSUE BY.", 10, 0) + ": " + hisutil
					.appendSpace(hisutil.breakString(vo.getStrStoreName(), 20, "~").get(0).toUpperCase(), 20, 0));
			// contents.append(hisutil.appendSpace("SERVICE", 10, 0)+ ": "+
			// hisutil.appendSpace(hisutil.breakString(serv_type, 19,
			// "~").get(0).toUpperCase(), 20, 0));
			contents.append("\n");
			printLine++;
			printLine++;

			/*
			 * contents.append(hisutil.appendSpace(" SERVICE", 10, 0)+ ": "+
			 * hisutil.appendSpace(serv_type.toUpperCase(), 20, 0));
			 * contents.append(hisutil.appendSpace("DEPARTMENT", 10, 0)+ ": "+
			 * hisutil.appendSpace(hisutil.breakString(dept, 53, "~").get(0).toUpperCase(),
			 * 53, 0)); contents.append("\n"); printLine++; printLine++;
			 */

			contents.append(
					"-----------------------------------------------------------------------------------------------");
			contents.append("\n");
			printLine++;
			contents.append(hisutil.appendSpace("S.No.", 5, 0));
			contents.append(hisutil.appendSpace("ITEM NAME", 50, 0));
			contents.append(hisutil.appendSpace("BATCH", 10, 0));
			contents.append(hisutil.appendSpace("RATE(Rs.)", 10, 0));
			contents.append(hisutil.appendSpace("QTY.", 10, 0));
			contents.append(hisutil.appendSpace("AMOUNT(Rs.)", 10, 0));
			contents.append("\n");
			printLine++;

			contents.append(
					"-----------------------------------------------------------------------------------------------");
			contents.append("\n");
			printLine++;

			int i = 1;

			while (vo.getWsIssueDetails().next()) {
				int strlength = vo.getWsIssueDetails().getString(6).length();
				String drugName = vo.getWsIssueDetails().getString(6);
				String opdrugName = "";

				opdrugName = drugName;
				// System.out.println("DRUG_NAME-B-"+opdrugName);
				contents.append("\n");
				printLine++;
				contents.append(hisutil.appendSpace(String.valueOf(i), 5, 0));
				contents.append(hisutil.appendSpace(opdrugName, 50, 0));
				// contents.append(opdrugName.replaceAll("^\\s+", " "));
				contents.append(hisutil.appendSpace(vo.getWsIssueDetails().getString(7), 10, 0));
				contents.append(hisutil.appendSpace(String.valueOf(vo.getWsIssueDetails().getString(16)), 10, 0));
				contents.append(hisutil.appendSpace(vo.getWsIssueDetails().getString(19), 10, 0));
				contents.append(hisutil.appendSpace(vo.getWsIssueDetails().getString(40), 10, 0));
				contents.append("\n");
				printLine++;

				// hisutil.appendSpace(hisutil.breakString(patient_name[0], 20,
				// "~").get(0).toUpperCase(), 20, 0)

				i++;
			}
			contents.append(
					"-----------------------------------------------------------------------------------------------");
			contents.append("\n");
			printLine++;

			contents.append(hisutil.appendSpace("", 79, 1) + hisutil.appendSpace("---------------", 15, 1));
			contents.append("\n");
			printLine++;

			contents.append(hisutil.appendSpace("TOTAL AMOUNT ", 79, 1)
					+ hisutil.appendSpace(String.format("%1$,.2f", NetAmount), 5, 1));
			contents.append("\n");
			printLine++;
			contents.append(hisutil.appendSpace("", 79, 1) + hisutil.appendSpace("---------------", 15, 1));
			contents.append("\n");
			printLine++;

			contents.append(hisutil.appendSpace("BILLED AMT ", 79, 1)
					+ hisutil.appendSpace(String.format("%1$,.2f", NetAmount), 5, 1));
			contents.append("\n");
			printLine++;

			contents.append(hisutil.appendSpace("COLLECTED AMT ", 79, 1)
					+ hisutil.appendSpace(String.format("%1$,.2f", NetAmount), 5, 1));
			contents.append("\n");
			printLine++;

			contents.append(hisutil.appendSpace("RUPEES (IN WORD) : " + hisutil.getAmountStr(String.valueOf(NetAmount)),
					94, 0));
			contents.append("\n");
			printLine++;
			printLine++;

			String contents3 = new String();

			contents3 = "\n \n " + hisutil.appendSpace(strUserName + " (" + strUserName + ")", 79, 1);
			contents3 += "\n";
			printLine++;
			contents3 += hisutil.appendSpace("AUTHORISED SIGNATORY", 79, 1);
			contents3 += "\n";
			printLine++;

			contents.append(contents3);

			content = PrintContents("1", "1", contents.toString(), request);
			System.out.println("Duplicate  Services------->\n" + contents.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Billing  PrintHLP.OPD_SERVICES() -->" + e.getMessage());
		} finally {
			vo = null;
			bo = null;
			hisutil = null;

		}

		return content;

	}

	public static boolean getIssuePopUpForDotMatrix_OLD(String strHospCode, String strStoreId, String strIssueNo,
			String strCrNo, HttpServletRequest request) throws Exception {
		/* Creating VO & BO Object Here */
		InjAdministrationTransVO vo = new InjAdministrationTransVO();
		InjAdministrationTransBO bo = new InjAdministrationTransBO();
		StringBuffer contents = new StringBuffer("");
		HisUtil hisutil = new HisUtil("billing", "PrintHLP");
		boolean content = false;
		int k = 0;
		try {

			/* Declaring Variable */
			String rptContents = "";
			String strItemName = "";
			String strIssueQtyUnit = "";
			String strRateUnit = "";
			String strCost = "";
			String strAgeAndSex = "";
			String strPatientName = "";
			String strFatherOrHusbandName = "";
			String strSpouseName = "";
			String strReligion = "";
			String strCategoryName = "";
			String strCategoryCode = "";
			String strAddress = "";
			String strMlcNo = "";
			String strHiddenValue = "";
			String catGrp = "";
			String visitType = "";
			String episodeCode = "";
			String strEmailId = "";
			String contactNo = "";

			String pat_net_amt = "";
			String unit_net_amt = "";
			String strUserName = "";
			float NetAmount = 0.0F;

			System.out.println("------- InjAdministrationTransDATA.getIssuePopUpForDotMatrix  -------");
			System.out.println(
					"------- pkg_mms_view.Proc_Emp_Issue_Detail    [ Mode - 3 ] , pkg_simple_view.PROC_HRGT_PATIENT_DTL [ Mode - 1 ]  -------");

			/* Setting Value in vo Object */
			vo.setStrStoreId(strStoreId);
			vo.setStrHospitalCode(strHospCode);
			vo.setStrIssueNo(strIssueNo);
			vo.setStrCrNo(strCrNo);
			/* Calling BO Method */
			bo.getImgHeader(vo);
			bo.getDupDotMatrixVoucher(vo); // pkg_mms_view.Proc_Emp_Issue_Detail [ Mode - 3 ]
											// pkg_simple_view.PROC_HRGT_PATIENT_DTL [ Mode - 1 ]
			if (vo.getStrMsgType().equals("1")) {
				try {
					throw new Exception(vo.getStrMsgString());

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			WebRowSet ws = vo.getGblWs1();
			if (ws != null && ws.size() > 0) {
				if (ws.next()) {
					strAgeAndSex = ws.getString(2);
					strPatientName = ws.getString(3);
					strFatherOrHusbandName = ws.getString(4);
					strSpouseName = ws.getString(5);
					strReligion = ws.getString(6);
					strCategoryName = ws.getString(7);
					strCategoryCode = ws.getString(8);
					strAddress = ws.getString(9);
					strMlcNo = ws.getString(10);
					strHiddenValue = ws.getString(11);
					catGrp = ws.getString(13);
					visitType = ws.getString(15).split("\\^")[0];
					episodeCode = ws.getString(15).split("\\^")[1];
					if (strHiddenValue == null)
						strHiddenValue = "----";
					String[] id = strHiddenValue.split("\\^");
					strEmailId = ws.getString(16);
					contactNo = "";
					if (strHiddenValue != null) {
						contactNo = id[13];
					}

					if (strAgeAndSex == null)
						strAgeAndSex = "----";
					if (strPatientName == null)
						strPatientName = "----";
					if (strFatherOrHusbandName == null)
						strFatherOrHusbandName = "----";
					if (strSpouseName == null)
						strSpouseName = "----";
					if (strReligion == null)
						strReligion = "----";
					if (strCategoryName == null)
						strCategoryName = "----";
					if (strCategoryCode == null)
						strCategoryCode = "----";
					if (strAddress == null)
						strAddress = "----";
					if (strMlcNo == null)
						strMlcNo = "-----";

				}
			}
			while (vo.getWsIssueDetails().next()) {
				vo.setStrIssueDate(vo.getWsIssueDetails().getString(2));
				vo.setStrStoreName(vo.getWsIssueDetails().getString(4));
				if (k == 0) {
					strUserName = vo.getWsIssueDetails().getString(36);
					unit_net_amt = vo.getWsIssueDetails().getString(40);
				}
				NetAmount = NetAmount + Float.parseFloat(vo.getWsIssueDetails().getString(40));
				k++;
			}
			vo.getWsIssueDetails().beforeFirst();

			/*
			 * 1. Issue No 2. Issue Date 3. Pat Name 4. Store Name 5. Generic Name 6. Brnad
			 * Name 7. BATCH 8. EXP Date 9. Rate / Unit 10. Issue Qty Wth Unit 11. Store Id
			 * 12. Item Id 13. Brand Id 14. BATCH 15. Exp Date 16. Rate 17. Rate Unit Id 18.
			 * Rate Base Value 19. Issue Qty 20. Issue Qty Unit Id 21. Qty Base Value 22. Sl
			 * Npo 23. NVL 24. Catg Code 25. Bal Qty 26. NVL 27. Remarks 28. Rec By 29.
			 * HSTNUM_TOTAL_COST 30. Budget 31. NVL 32. Issue Date 33. MRP of Drug 34. Total
			 * Purchase Cost 35. PIN 36. Issue By User Name 37. Order By 38. Hosp Name 39.
			 * HSTSTR_LOCATION 40. ITEM_VALUE 41. Doses 42. Frequency 43. Dept Name 44.
			 * Instruction 45. Doc Name 46. Diagonisis 47. Printer Flag
			 */

			contents.append(
					"<table width='78%' style='font-size: 110.5%;color: rgb(33, 37, 41);' align='center' cellpadding='1px' cellspacing='1px'> ");
			contents.append("<tr>");
			contents.append(
					"<td width='100%' align='center' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><u>RECEIPT</u></font></td> ");
			contents.append("</tr>");
			/*************************************************
			 * 1
			 *******************************************************************/
//				contents.append("<tr> ");	
//				contents.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Patient [ PIN.]:</b></font></td> ");
//
//				contents.append("<td width='75%' align='left' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' >200008240000930</font></td> ");			
//						
//				contents.append("</tr> ");
			/**************************************************
			 * 2
			 *****************************************************************/

			contents.append("<tr> ");
			contents.append("<td width='25%' align='right'><font face='Courier, monospace' >")
					.append("PIN:</font></td> ");
			contents.append("<td width='25%' align='left'><font face='Courier, monospace' >")
					.append(vo.getStrCrNo().toUpperCase()).append("</font></td> ");
			contents.append("<td width='25%' align='right'><font face='Courier, monospace' >")
					.append("DATE&TIME</font></td> ");
			contents.append("<td width='25%' align='left'><font face='Courier, monospace' >")
					.append(vo.getStrIssueDate()).append("</font></td> ");
			contents.append("</tr> ");

			contents.append("<tr> ");
			contents.append("<td width='25%' align='right'><font face='Courier, monospace' >")
					.append("Name:</font></td> ");
			contents.append("<td width='25%' align='left'><font face='Courier, monospace' >")
					.append(hisutil.breakString(strPatientName, 20, "~").get(0).toUpperCase()).append("</font></td> ");
			contents.append("<td width='25%' align='right'><font face='Courier, monospace' >")
					.append("Issue No:</font></td> ");
			contents.append("<td width='25%' align='left'><font face='Courier, monospace' >").append(vo.getStrIssueNo())
					.append("</font></td> ");
			contents.append("</tr> ");

			contents.append("<tr> ");
			contents.append("<td width='25%' align='right'><font face='Courier, monospace' >")
					.append("Category:</font></td> ");
			contents.append("<td width='25%' align='left'><font face='Courier, monospace' >").append(strCategoryName)
					.append("</font></td> ");
			contents.append("<td width='25%' align='right'><font face='Courier, monospace' >")
					.append("Age/Sex:</font></td> ");
			contents.append("<td width='25%' align='left'><font face='Courier, monospace' >")
					.append(hisutil.breakString(strAgeAndSex, 20, "~").get(0).toUpperCase()).append("</font></td> ");
			contents.append("</tr> ");

			contents.append("<tr> ");
			contents.append("<td width='25%' align='right'><font face='Courier, monospace' >")
					.append("Issue By:</font></td> ");
			contents.append("<td width='25%' align='left'><font face='Courier, monospace' >")
					.append(hisutil.breakString(vo.getStrStoreName(), 30, "~").get(0).toUpperCase())
					.append("</font></td> ");
			contents.append("<td width='25%' align='right'><font face='Courier, monospace' >").append("</font></td> ");
			contents.append("<td width='25%' align='left'><font face='Courier, monospace' >").append("")
					.append("</font></td> ");
			contents.append("</tr> ");

			/********************************************************************************************************************/
			contents.append("</table> ");

			int i = 1;
			contents.append("<div class='receipt-container'>");
			contents.append("<div class='billing-details'>");

			contents.append(
					"<table width='100%' style='font-size: 110.5%;color: rgb(33, 37, 41);' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
			contents.append("<tr>");
			contents.append("<td colspan='8' align='center'><hr size='1'></td>");
			contents.append("</tr>");
			contents.append("<tr bgcolor=''> ");
			contents.append(
					"<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >S.No.</font> ");
			contents.append("</td>");
			contents.append(
					"<td style=\"text-align:center;\"  width='30%'><font face='Courier, monospace' >ITEM Name</font> ");
			contents.append("</td>");
			contents.append(
					"<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >FREQ</font>");
			contents.append("</td> ");
			contents.append(
					"<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >DOSAGE</font>");
			contents.append("</td> ");
			contents.append(
					"<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >BATCH</font>");
			contents.append("</td> ");
			contents.append(
					"<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >RATE(Rs.)</font>");
			contents.append("</td> ");
			contents.append(
					"<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >QTY.</font>");
			contents.append("</td> ");
			contents.append(
					"<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >AMOUNT(Rs.)</font>");
			contents.append("</td> ");
			contents.append("</tr> ");
			contents.append("<tr>");
			contents.append("<td colspan='8' align='center'><hr size='1'></td>");
			contents.append("</tr>");
			contents.append("</table> ");

			contents.append(
					"<table width='100%' style='font-size: 110.5%;color: rgb(33, 37, 41);' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");

			while (vo.getWsIssueDetails().next()) {

				contents.append("<tr bgcolor=''> ");
				contents.append("<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >"
						+ String.valueOf(i) + "</font> ");
				contents.append("</td>");
				contents.append("<td style=\"text-align:left;\"  width='30%'><font face='Courier, monospace' >"
						+ hisutil.breakString(vo.getWsIssueDetails().getString(6), 50, "~").get(0).toUpperCase()
						+ "</font> ");
				contents.append("</td>");
				contents.append("<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >"
						+ vo.getWsIssueDetails().getString(42) + "</font>");
				contents.append("</td> ");
				contents.append("<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >"
						+ vo.getWsIssueDetails().getString(41) + "</font>");
				contents.append("</td> ");
				contents.append("<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >"
						+ vo.getWsIssueDetails().getString(7) + "</font>");
				contents.append("</td> ");
				contents.append("<td style=\"text-align:right;\"  width='10%'><font face='Courier, monospace' >"
						+ String.valueOf(vo.getWsIssueDetails().getString(16)) + "</font>");
				contents.append("</td> ");
				contents.append("<td style=\"text-align:right;\"  width='10%'><font face='Courier, monospace' >"
						+ vo.getWsIssueDetails().getString(19) + "</font>");
				contents.append("</td> ");
				contents.append("<td style=\"text-align:right;\"  width='10%'><font face='Courier, monospace' >"
						+ vo.getWsIssueDetails().getString(40) + "</font>");
				contents.append("</td> ");
				contents.append("</tr> ");

				i++;
			}

			contents.append("</table> ");
			contents.append(
					"<table width='100%' style='font-size: 110.5%;color: rgb(33, 37, 41);' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
			contents.append("<tr>");
			contents.append("<td colspan='8' align='center'><hr size='1'></td>");
			contents.append("</tr>");
			contents.append("</table> ");

			contents.append(
					"<table width='100%' style='font-size: 110.5%;color: rgb(33, 37, 41);' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
			contents.append("<tr>");
			contents.append("<td  align='right' width='80%'><font face='Courier, monospace' >TOTAL</font></td> ");
			contents.append("<td  align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"
					+ String.format("%1$,.2f", NetAmount) + "</font></td> ");
			contents.append("</tr>");
			contents.append("</table> ");

			contents.append(
					"<table width='100%' style='font-size: 110.5%;color: rgb(33, 37, 41);' align='center' cellpadding='1px' cellspacing='1px'> ");
			contents.append("<tr> ");
			contents.append("<td  align='left'><font face='Courier, monospace' >")
					.append("RUPEES (IN WORD) : " + hisutil.getAmountStr(String.valueOf(NetAmount)) + "</font></td>");
			contents.append("</tr><tr> ");
			contents.append("<td  align='right'><font face='Courier, monospace' >")
					.append(strUserName + " (" + strUserName + ")");
			contents.append("</tr> ");
			contents.append("</tr><tr> ");
			contents.append("<td  align='right'><font face='Courier, monospace' >").append("AUTHORISED SIGNATORY")
					.append("</font></td> ");
			contents.append("</tr> ");
			contents.append("</table> ");

			contents.append("</div>");
			contents.append("</div>");

			content = PrintContents("1", "1", contents.toString(), request);
			// System.out.println("Duplicate Services------->\n" + contents.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Billing  PrintHLP.OPD_SERVICES() -->" + e.getMessage());
		} finally {
			vo = null;
			bo = null;
			hisutil = null;

		}

		return content;

	}

	public static boolean getIssuePopUpForDotMatrix(String strHospCode, String strStoreId, String strIssueNo,
			String strCrNo, HttpServletRequest request) throws Exception {
		/* Creating VO & BO Object Here */
		InjAdministrationTransVO vo = new InjAdministrationTransVO();
		InjAdministrationTransBO bo = new InjAdministrationTransBO();
		StringBuffer contents = new StringBuffer("");
		HisUtil hisutil = new HisUtil("billing", "PrintHLP");
		boolean content = false;
		int k = 0;
		try {

			/* Declaring Variable */
			String rptContents = "";
			String strItemName = "";
			String strIssueQtyUnit = "";
			String strRateUnit = "";
			String strCost = "";
			String strAgeAndSex = "";
			String strPatientName = "";
			String strFatherOrHusbandName = "";
			String strSpouseName = "";
			String strReligion = "";
			String strCategoryName = "";
			String strCategoryCode = "";
			String strAddress = "";
			String strMlcNo = "";
			String strHiddenValue = "";
			String catGrp = "";
			String visitType = "";
			String episodeCode = "";
			String strEmailId = "";
			String contactNo = "";

			String pat_net_amt = "";
			String unit_net_amt = "";
			String strUserName = "";
			float NetAmount = 0.0F;

			System.out.println("------- InjAdministrationTransDATA.getIssuePopUpForDotMatrix  -------");
			System.out.println(
					"------- pkg_mms_view.Proc_Emp_Issue_Detail    [ Mode - 3 ] , pkg_simple_view.PROC_HRGT_PATIENT_DTL [ Mode - 1 ]  -------");

			/* Setting Value in vo Object */
			vo.setStrStoreId(strStoreId);
			vo.setStrHospitalCode(strHospCode);
			vo.setStrIssueNo(strIssueNo);
			vo.setStrCrNo(strCrNo);
			/* Calling BO Method */
			bo.getImgHeader(vo);
			bo.getDupDotMatrixVoucher(vo); // pkg_mms_view.Proc_Emp_Issue_Detail [ Mode - 3 ]
											// pkg_simple_view.PROC_HRGT_PATIENT_DTL [ Mode - 1 ]
			if (vo.getStrMsgType().equals("1")) {
				try {
					throw new Exception(vo.getStrMsgString());

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			WebRowSet ws = vo.getGblWs1();
			if (ws != null && ws.size() > 0) {
				if (ws.next()) {
					strAgeAndSex = ws.getString(2);
					strPatientName = ws.getString(3);
					strFatherOrHusbandName = ws.getString(4);
					strSpouseName = ws.getString(5);
					strReligion = ws.getString(6);
					strCategoryName = ws.getString(7);
					strCategoryCode = ws.getString(8);
					strAddress = ws.getString(9);
					strMlcNo = ws.getString(10);
					strHiddenValue = ws.getString(11);
					catGrp = ws.getString(13);
					visitType = ws.getString(15).split("\\^")[0];
					episodeCode = ws.getString(15).split("\\^")[1];
					if (strHiddenValue == null)
						strHiddenValue = "----";
					String[] id = strHiddenValue.split("\\^");
					strEmailId = ws.getString(16);
					contactNo = "";
					if (strHiddenValue != null) {
						contactNo = id[13];
					}

					if (strAgeAndSex == null)
						strAgeAndSex = "----";
					if (strPatientName == null)
						strPatientName = "----";
					if (strFatherOrHusbandName == null)
						strFatherOrHusbandName = "----";
					if (strSpouseName == null)
						strSpouseName = "----";
					if (strReligion == null)
						strReligion = "----";
					if (strCategoryName == null)
						strCategoryName = "----";
					if (strCategoryCode == null)
						strCategoryCode = "----";
					if (strAddress == null)
						strAddress = "----";
					if (strMlcNo == null)
						strMlcNo = "-----";

				}
			}
			while (vo.getWsIssueDetails().next()) {
				vo.setStrIssueDate(vo.getWsIssueDetails().getString(2));
				vo.setStrStoreName(vo.getWsIssueDetails().getString(4));
				if (k == 0) {
					strUserName = vo.getWsIssueDetails().getString(36);
					unit_net_amt = vo.getWsIssueDetails().getString(40);
				}
				NetAmount = NetAmount + Float.parseFloat(vo.getWsIssueDetails().getString(40));
				k++;
			}
			vo.getWsIssueDetails().beforeFirst();

			/*
			 * 1. Issue No 2. Issue Date 3. Pat Name 4. Store Name 5. Generic Name 6. Brnad
			 * Name 7. BATCH 8. EXP Date 9. Rate / Unit 10. Issue Qty Wth Unit 11. Store Id
			 * 12. Item Id 13. Brand Id 14. BATCH 15. Exp Date 16. Rate 17. Rate Unit Id 18.
			 * Rate Base Value 19. Issue Qty 20. Issue Qty Unit Id 21. Qty Base Value 22. Sl
			 * Npo 23. NVL 24. Catg Code 25. Bal Qty 26. NVL 27. Remarks 28. Rec By 29.
			 * HSTNUM_TOTAL_COST 30. Budget 31. NVL 32. Issue Date 33. MRP of Drug 34. Total
			 * Purchase Cost 35. PIN 36. Issue By User Name 37. Order By 38. Hosp Name 39.
			 * HSTSTR_LOCATION 40. ITEM_VALUE 41. Doses 42. Frequency 43. Dept Name 44.
			 * Instruction 45. Doc Name 46. Diagonisis 47. Printer Flag
			 */

			contents.append(
					"<table width='78%' style='font-size: 110.5%;color: rgb(33, 37, 41);' align='center' cellpadding='1px' cellspacing='1px'> ");
			contents.append("<tr>");
			contents.append(
					"<td width='100%' align='center' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><u>RECEIPT</u></font></td> ");
			contents.append("</tr>");
			/*************************************************
			 * 1
			 *******************************************************************/
//				contents.append("<tr> ");	
//				contents.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Patient [ PIN.]:</b></font></td> ");
//
//				contents.append("<td width='75%' align='left' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' >200008240000930</font></td> ");			
//						
//				contents.append("</tr> ");
			/**************************************************
			 * 2
			 *****************************************************************/

			contents.append("<tr> ");
			contents.append("<td width='25%' align='right'><font face='Courier, monospace' >")
					.append("PIN:</font></td> ");
			contents.append("<td width='25%' align='left'><font face='Courier, monospace' >")
					.append(vo.getStrCrNo().toUpperCase()).append("</font></td> ");
			contents.append("<td width='25%' align='right'><font face='Courier, monospace' >")
					.append("DATE&TIME</font></td> ");
			contents.append("<td width='25%' align='left'><font face='Courier, monospace' >")
					.append(vo.getStrIssueDate()).append("</font></td> ");
			contents.append("</tr> ");

			contents.append("<tr> ");
			contents.append("<td width='25%' align='right'><font face='Courier, monospace' >")
					.append("Name:</font></td> ");
			contents.append("<td width='25%' align='left'><font face='Courier, monospace' >")
					.append(hisutil.breakString(strPatientName, 20, "~").get(0).toUpperCase()).append("</font></td> ");
			contents.append("<td width='25%' align='right'><font face='Courier, monospace' >")
					.append("Issue No:</font></td> ");
			contents.append("<td width='25%' align='left'><font face='Courier, monospace' >").append(vo.getStrIssueNo())
					.append("</font></td> ");
			contents.append("</tr> ");

			contents.append("<tr> ");
			contents.append("<td width='25%' align='right'><font face='Courier, monospace' >")
					.append("Category:</font></td> ");
			contents.append("<td width='25%' align='left'><font face='Courier, monospace' >").append(strCategoryName)
					.append("</font></td> ");
			contents.append("<td width='25%' align='right'><font face='Courier, monospace' >")
					.append("Age/Sex:</font></td> ");
			contents.append("<td width='25%' align='left'><font face='Courier, monospace' >")
					.append(hisutil.breakString(strAgeAndSex, 20, "~").get(0).toUpperCase()).append("</font></td> ");
			contents.append("</tr> ");

			contents.append("<tr> ");
			contents.append("<td width='25%' align='right'><font face='Courier, monospace' >")
					.append("Issue By:</font></td> ");
			contents.append("<td width='25%' align='left'><font face='Courier, monospace' >")
					.append(hisutil.breakString(vo.getStrStoreName(), 30, "~").get(0).toUpperCase())
					.append("</font></td> ");
			contents.append("<td width='25%' align='right'><font face='Courier, monospace' >").append("</font></td> ");
			contents.append("<td width='25%' align='left'><font face='Courier, monospace' >").append("")
					.append("</font></td> ");
			contents.append("</tr> ");

			/********************************************************************************************************************/
			contents.append("</table> ");

			int i = 1;
			contents.append("<div class='receipt-container'>");
			contents.append("<div class='billing-details'>");

			contents.append(
					"<table width='100%' style='font-size: 110.5%;color: rgb(33, 37, 41);' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
			contents.append("<tr>");
			contents.append("<td colspan='8' align='center'><hr size='1'></td>");
			contents.append("</tr>");
			contents.append("<tr bgcolor=''> ");
			contents.append(
					"<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >S.No.</font> ");
			contents.append("</td>");
			contents.append(
					"<td style=\"text-align:center;\"  width='30%'><font face='Courier, monospace' >ITEM Name</font> ");
			contents.append("</td>");
			contents.append(
					"<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >FREQ</font>");
			contents.append("</td> ");
			contents.append(
					"<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >DOSAGE</font>");
			contents.append("</td> ");
			contents.append(
					"<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >BATCH</font>");
			contents.append("</td> ");
			contents.append(
					"<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >RATE(Rs.)</font>");
			contents.append("</td> ");
			contents.append(
					"<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >QTY.</font>");
			contents.append("</td> ");
			contents.append(
					"<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >AMOUNT(Rs.)</font>");
			contents.append("</td> ");
			contents.append("</tr> ");
			contents.append("<tr>");
			contents.append("<td colspan='8' align='center'><hr size='1'></td>");
			contents.append("</tr>");
			contents.append("</table> ");

			contents.append(
					"<table width='100%' style='font-size: 110.5%;color: rgb(33, 37, 41);' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");

			while (vo.getWsIssueDetails().next()) {

				contents.append("<tr bgcolor=''> ");
				contents.append("<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >"
						+ String.valueOf(i) + "</font> ");
				contents.append("</td>");
				contents.append("<td style=\"text-align:left;\"  width='30%'><font face='Courier, monospace' >"
						+ hisutil.breakString(vo.getWsIssueDetails().getString(6), 50, "~").get(0).toUpperCase()
						+ "</font> ");
				contents.append("</td>");
				contents.append("<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >"
						+ vo.getWsIssueDetails().getString(42) + "</font>");
				contents.append("</td> ");
				contents.append("<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >"
						+ vo.getWsIssueDetails().getString(41) + "</font>");
				contents.append("</td> ");
				contents.append("<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >"
						+ vo.getWsIssueDetails().getString(7) + "</font>");
				contents.append("</td> ");
				contents.append("<td style=\"text-align:right;\"  width='10%'><font face='Courier, monospace' >"
						+ String.valueOf(vo.getWsIssueDetails().getString(16)) + "</font>");
				contents.append("</td> ");
				contents.append("<td style=\"text-align:right;\"  width='10%'><font face='Courier, monospace' >"
						+ vo.getWsIssueDetails().getString(19) + "</font>");
				contents.append("</td> ");
				contents.append("<td style=\"text-align:right;\"  width='10%'><font face='Courier, monospace' >"
						+ vo.getWsIssueDetails().getString(40) + "</font>");
				contents.append("</td> ");
				contents.append("</tr> ");

				i++;
			}

			contents.append("</table> ");
			contents.append(
					"<table width='100%' style='font-size: 110.5%;color: rgb(33, 37, 41);' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
			contents.append("<tr>");
			contents.append("<td colspan='8' align='center'><hr size='1'></td>");
			contents.append("</tr>");
			contents.append("</table> ");

			contents.append(
					"<table width='100%' style='font-size: 110.5%;color: rgb(33, 37, 41);' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
			contents.append("<tr>");
			contents.append("<td  align='right' width='80%'><font face='Courier, monospace' >TOTAL</font></td> ");
			contents.append("<td  align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"
					+ String.format("%1$,.2f", NetAmount) + "</font></td> ");
			contents.append("</tr>");
			contents.append("</table> ");

			contents.append(
					"<table width='100%' style='font-size: 110.5%;color: rgb(33, 37, 41);' align='center' cellpadding='1px' cellspacing='1px'> ");
			contents.append("<tr> ");
			contents.append("<td  align='left'><font face='Courier, monospace' >")
					.append("RUPEES (IN WORD) : " + hisutil.getAmountStr(String.valueOf(NetAmount)) + "</font></td>");
			contents.append("</tr><tr> ");
			contents.append("<td  align='right'><font face='Courier, monospace' >")
					.append(strUserName + " (" + strUserName + ")");
			contents.append("</tr> ");
			contents.append("</tr><tr> ");
			contents.append("<td  align='right'><font face='Courier, monospace' >").append("AUTHORISED SIGNATORY")
					.append("</font></td> ");
			contents.append("</tr> ");
			contents.append("</table> ");

			contents.append("</div>");
			contents.append("</div>");

			content = PrintContents("1", "1", contents.toString(), request);
			// System.out.println("Duplicate Services------->\n" + contents.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Billing  PrintHLP.OPD_SERVICES() -->" + e.getMessage());
		} finally {
			vo = null;
			bo = null;
			hisutil = null;

		}

		return content;

	}

	public static boolean getIssuePopUpForDotMatrix_V1(String strHospCode, String strStoreId, String strIssueNo,
			String strCrNo, HttpServletRequest request) throws Exception {
		/* Creating VO & BO Object Here */
		InjAdministrationTransVO vo = new InjAdministrationTransVO();
		InjAdministrationTransBO bo = new InjAdministrationTransBO();
		StringBuffer contents = new StringBuffer("");
		HisUtil hisutil = new HisUtil("billing", "PrintHLP");
		boolean content = false;
		int k = 0, j = 1;
		try {

			/* Declaring Variable */
			String rptContents = "";
			String strItemName = "";
			String strIssueQtyUnit = "";
			String strRateUnit = "";
			String strCost = "";
			String strAgeAndSex = "";
			String strPatientName = "";
			String strFatherOrHusbandName = "";
			String strSpouseName = "";
			String strReligion = "";
			String strCategoryName = "";
			String strCategoryCode = "";
			String strAddress = "";
			String strMlcNo = "";
			String strHiddenValue = "";
			String catGrp = "";
			String visitType = "";
			String episodeCode = "";
			String strEmailId = "";
			String contactNo = "";

			String pat_net_amt = "";
			String unit_net_amt = "";
			String strUserName = "";
			float NetAmount = 0.0F;
			String curGroupName = "";
			String preGroupName = "";

			System.out.println("------- InjAdministrationTransDATA.getIssuePopUpForDotMatrix_V1  -------");
			System.out.println(
					"------- pkg_mms_view.Proc_Emp_Issue_Detail    [ Mode - 3 ] , pkg_simple_view.PROC_HRGT_PATIENT_DTL [ Mode - 1 ]  -------");

			/* Setting Value in vo Object */
			vo.setStrStoreId(strStoreId);
			vo.setStrHospitalCode(strHospCode);
			vo.setStrIssueNo(strIssueNo);
			vo.setStrCrNo(strCrNo);
			/* Calling BO Method */
			// bo.getImgHeader(vo);
			bo.getDupDotMatrixVoucher(vo); // pkg_mms_view.Proc_Emp_Issue_Detail [ Mode - 3 ]
											// pkg_simple_view.PROC_HRGT_PATIENT_DTL [ Mode - 1 ]
			if (vo.getStrMsgType().equals("1")) {
				try {
					throw new Exception(vo.getStrMsgString());

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			WebRowSet ws = vo.getGblWs1();
			if (ws != null && ws.size() > 0) {
				if (ws.next()) {
					strAgeAndSex = ws.getString(2);
					strPatientName = ws.getString(3);
					strFatherOrHusbandName = ws.getString(4);
					strSpouseName = ws.getString(5);
					strReligion = ws.getString(6);
					strCategoryName = ws.getString(7);
					strCategoryCode = ws.getString(8);
					strAddress = ws.getString(9);
					strMlcNo = ws.getString(10);
					strHiddenValue = ws.getString(11);
					catGrp = ws.getString(13);
					visitType = ws.getString(15).split("\\^")[0];
					episodeCode = ws.getString(15).split("\\^")[1];
					if (strHiddenValue == null)
						strHiddenValue = "----";
					String[] id = strHiddenValue.split("\\^");
					strEmailId = ws.getString(16);
					contactNo = "";
					if (strHiddenValue != null) {
						contactNo = id[13];
					}

					if (strAgeAndSex == null)
						strAgeAndSex = "----";
					if (strPatientName == null)
						strPatientName = "----";
					if (strFatherOrHusbandName == null)
						strFatherOrHusbandName = "----";
					if (strSpouseName == null)
						strSpouseName = "----";
					if (strReligion == null)
						strReligion = "----";
					if (strCategoryName == null)
						strCategoryName = "----";
					if (strCategoryCode == null)
						strCategoryCode = "----";
					if (strAddress == null)
						strAddress = "----";
					if (strMlcNo == null)
						strMlcNo = "-----";

				}
			}
			while (vo.getWsIssueDetails().next()) {
				vo.setStrIssueDate(vo.getWsIssueDetails().getString(2));
				vo.setStrStoreName(vo.getWsIssueDetails().getString(4));
				if (k == 0) {
					strUserName = vo.getWsIssueDetails().getString(36);
					unit_net_amt = vo.getWsIssueDetails().getString(40);
				}
				NetAmount = NetAmount + Float.parseFloat(vo.getWsIssueDetails().getString(40));
				k++;
			}
			vo.getWsIssueDetails().beforeFirst();

			contents.append("<div class='receipt-container'>");
			contents.append("<div class='billing-details'>");

			contents.append(
					"<table width='100%' style='font-size: 110.5%;color: rgb(33, 37, 41);' align='center' cellpadding='1px' cellspacing='1px'> ");
			contents.append("<tr>");
			contents.append(
					"<td  align='center' colspan='6'><font face='Verdana, Arial, Helvetica, sans-serif' ><u>Pharmacy Dispense</u></font></td> ");
			contents.append("</tr>");
			contents.append("</table> ");
			contents.append(
					"<table width='100%' style='font-size: 110.5%;color: rgb(33, 37, 41);' align='center' cellpadding='1px' cellspacing='1px'> ");

			contents.append("<tr> ");
			contents.append("<td colspan='1' align='right'><font face='Courier, monospace' >")
					.append("Name:</font></td> ");
			contents.append("<td colspan='2' align='left'><font face='Courier, monospace' >")
					.append(hisutil.breakString(strPatientName, 20, "~").get(0).toUpperCase()).append("</font></td> ");
			contents.append("<td colspan='1' align='right'><font face='Courier, monospace' >")
					.append("PIN:</font></td> ");
			contents.append("<td colspan='2' align='left'><font face='Courier, monospace' >").append(vo.getStrCrNo())
					.append("</font>");
			contents.append("</td> ");
			contents.append("</tr> ");

			contents.append("<tr> ");
			contents.append("<td colspan='1' align='right'><font face='Courier, monospace' ></font></td> ");
			contents.append("<td colspan='2' align='left'><font face='Courier, monospace' >")
					.append(hisutil.breakString(strAgeAndSex, 20, "~").get(0).toUpperCase()).append("</font></td> ");
			contents.append("<td colspan='1' align='right'><font face='Courier, monospace' ></font></td> ");
			contents.append("<td colspan='2' align='left'><font face='Courier, monospace' >")
					.append(hisutil.breakString(vo.getStrIssueDate(), 20, "~").get(0).toUpperCase())
					.append("</font></td> ");

			contents.append("</tr> ");

			/********************************************************************************************************************/
			contents.append("</table> ");

			int i = 1;

			while (vo.getWsIssueDetails().next()) {
				/*
				 * 1. Issue No 2. Issue Date 3. Pat Name 4. Store Name 5. Generic Name 6. Brnad
				 * Name 7. BATCH 8. EXP Date 9. Rate / Unit 10. Issue Qty Wth Unit 11. Store Id
				 * 12. Item Id 13. Brand Id 14. BATCH 15. Exp Date 16. Rate 17. Rate Unit Id 18.
				 * Rate Base Value 19. Issue Qty 20. Issue Qty Unit Id 21. Qty Base Value 22. Sl
				 * Npo 23. NVL 24. Catg Code 25. Bal Qty 26. NVL 27. Remarks 28. Rec By 29.
				 * HSTNUM_TOTAL_COST 30. Budget 31. NVL 32. Issue Date 33. MRP of Drug 34. Total
				 * Purchase Cost 35. PIN 36. Issue By User Name 37. Order By 38. Hosp Name 39.
				 * HSTSTR_LOCATION 40. ITEM_VALUE 41. Doses 42. Frequency 43. Dept Name 44.
				 * Instruction 45. Doc Name 46. Diagonisis 47. Printer Flag 48. INVEST_DTL
				 */
				// curGroupName = vo.getWsIssueDetails().getString(43);
				curGroupName = vo.getWsIssueDetails().getString(43) == null ? "-"
						: vo.getWsIssueDetails().getString(43);

				if (!curGroupName.equals(preGroupName)) {
					contents.append(
							"<table width='100%' style='font-size: 110.5%;color: rgb(33, 37, 41);' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
					contents.append("<tr>");
					contents.append(
							"<td colspan='6' align='center'><hr size='1' style='color: #131313; background-color: #0b0a0a;'></td>");
					contents.append("</tr>");
					contents.append("</table> ");

					contents.append(
							"<table width='100%' style='font-size: 110.5%;color: rgb(33, 37, 41);' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
					contents.append("<tr> ");
					contents.append("<td colspan='1'  align='right'><font face='Courier, monospace' >")
							.append("Department:</font></td> ");
					contents.append("<td colspan='2'  align='left'><font face='Courier, monospace' >")
							.append(vo.getWsIssueDetails().getString(43).toUpperCase()).append("</font></td> ");
					contents.append("<td colspan='1'  align='right'><font face='Courier, monospace' >")
							.append("Doctor Name:</font></td> ");
					contents.append("<td colspan='2'  align='left'><font face='Courier, monospace' >")
							.append(vo.getWsIssueDetails().getString(45).toUpperCase()).append("</font></td> ");
					contents.append("</tr> ");
					contents.append("</table> ");

					contents.append(
							"<table width='100%' style='font-size: 110.5%;color: rgb(33, 37, 41);' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
					contents.append("<tr> ");
					contents.append("<td width='25%' align='right'><font face='Courier, monospace' >")
							.append("Provisional Diagnosis:</font></td> ");
					contents.append("<td width='75%' align='left'><font face='Courier, monospace' >")
							.append(vo.getWsIssueDetails().getString(46).toUpperCase()).append("</font></td> ");
					contents.append("</tr> ");
					contents.append("<tr> ");
					contents.append("<td width='25%' align='right'><font face='Courier, monospace' >")
							.append("Investigation:</font></td> ");
					contents.append("<td width='75%' align='left'><font face='Courier, monospace' >")
							.append(vo.getWsIssueDetails().getString(48).toUpperCase()).append("</font></td> ");
					contents.append("</tr> ");
					contents.append("</table> ");

					contents.append(
							"<table width='100%' style='font-size: 110.5%;color: rgb(33, 37, 41);' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
					contents.append("<tr>");
					contents.append(
							"<td colspan='6' align='center'><hr size='1' style='color: #131313; background-color: #0b0a0a;'></td>");
					contents.append("</tr>");
					contents.append("<tr bgcolor=''> ");
					contents.append(
							"<td style=\"text-align:center;\"     width='10%'><font face='Courier, monospace' >S.No.</font> ");
					contents.append("</td>");
					contents.append(
							"<td style=\"text-align:center;\"     width='40%'><font face='Courier, monospace' >Drug Name</font> ");
					contents.append("</td>");
					// contents.append("<td style=\"text-align:center;\" width='8%'><font
					// face='Courier, monospace' >FREQ</font>");
					// contents.append("</td> ");
					contents.append(
							"<td style=\"text-align:center;\"     width='14%'><font face='Courier, monospace' >Dosage</font>");
					contents.append("</td> ");
					contents.append(
							"<td style=\"text-align:center;\"     width='8%'><font face='Courier, monospace' >Qty</font>");
					contents.append("</td> ");
					contents.append(
							"<td style=\"text-align:center;\"     width='10%'><font face='Courier, monospace' >Exp.Date</font>");
					contents.append("</td> ");
					contents.append(
							"<td style=\"text-align:center;\"     width='18%'><font face='Courier, monospace' >Instruction</font>");
					contents.append("</td> ");
					contents.append("</tr> ");
					contents.append("<tr>");
					contents.append(
							"<td colspan='6' align='center'><hr size='1' style='color: #131313; background-color: #0b0a0a;'></td>");
					contents.append("</tr>");
					contents.append("</table> ");
					contents.append(
							"<table width='100%' style='font-size: 110.5%;color: rgb(33, 37, 41);' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
					j++;

				}
				contents.append("<tr bgcolor=''> ");
				contents.append("<td style=\"text-align:center;\"  width='10%'><font face='Courier, monospace' >"
						+ String.valueOf(i) + "</font> ");
				contents.append("</td>");
				contents.append("<td style=\"text-align:left;\"    width='40%'><font face='Courier, monospace' >"
						+ hisutil.breakString(vo.getWsIssueDetails().getString(6), 50, "~").get(0).toUpperCase()
						+ "</font> ");
				contents.append("</td>");
				// contents.append("<td style=\"text-align:left;\" width='8%'><font
				// face='Courier, monospace' >"+vo.getWsIssueDetails().getString(42)+"</font>");
				// contents.append("</td> ");
				contents.append("<td style=\"text-align:left;\"    width='14%'><font face='Courier, monospace' >"
						+ vo.getWsIssueDetails().getString(41) + "</font>");
				contents.append("</td> ");
				contents.append("<td style=\"text-align:center;\"  width='8%'><font face='Courier, monospace' >"
						+ vo.getWsIssueDetails().getString(19) + "</font>");
				contents.append("</td> ");
				contents.append("<td style=\"text-align:left;\"    width='10%'><font face='Courier, monospace' >"
						+ vo.getWsIssueDetails().getString(8) + "</font>");
				contents.append("</td> ");
				contents.append("<td style=\"text-align:left;\"    width='18%'><font face='Courier, monospace' >"
						+ vo.getWsIssueDetails().getString(44) + "</font>");
				contents.append("</td> ");
				contents.append("</tr> ");

				i++;

				preGroupName = curGroupName;
			}

			contents.append("</table> ");
			contents.append(
					"<table width='100%' style='font-size: 110.5%;color: rgb(33, 37, 41);' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
			contents.append("<tr>");
			contents.append(
					"<td colspan='6' align='center'><hr size='1' style='color: #131313; background-color: #0b0a0a;'></td>");
			contents.append("</tr>");
			// contents.append("</table> ");
			// contents.append("<table width='100%' style='font-size: 110.5%;color: rgb(33,
			// 37, 41);' align='center' cellpadding='1px' cellspacing='1px'> ");
			// contents.append("<tr> ");
			// contents.append("<td colspan='6' align='right'><font face='Courier,
			// monospace' >").append(strUserName);
			// contents.append("</tr> ");
			contents.append("</tr>");
			/*
			 * contents.append("<tr> "); contents.
			 * append("<td colspan='6' align='right'><font face='Courier, monospace' >").
			 * append("AUTHORISED SIGNATORY").append( "</font></td> ");
			 * contents.append("</tr> ");
			 */
			contents.append("</table> ");

			contents.append("</div>");
			contents.append("</div>");

			content = PrintContents("1", "1", contents.toString(), request);
			// System.out.println("Duplicate Services------->\n" + contents.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Billing  PrintHLP.OPD_SERVICES() -->" + e.getMessage());
		} finally {
			vo = null;
			bo = null;
			hisutil = null;

		}

		return content;

	}

	public static String divideCharacter(String input) {
		int lineLength = 30;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length(); i += lineLength) {
			sb.append(input.substring(i, Math.min(input.length(), i + lineLength)));
			sb.append("<br>");
		}
		String output = sb.toString();
		return output;
	}

	/**
	 * OPD_SERVICES(vo) -- > This Method is Used to get Print Type in OPD_SERVICES
	 * Case
	 * 
	 * @throws Exception
	 */
	public static boolean OPD_SERVICES(String strBillNo, String strBServiceId, String strHospitalCode,
			String strReceiptNo, HttpServletRequest request, Map tariffPrintMap, String strIsDirectMode,
			int isDuplicateBill, String isCreditBill, String printCopyType) throws Exception {

		System.out.println("------billing.OPD_SERVICES.findPrintType------");
		System.out.println("strBServiceId------>" + strBServiceId);
		System.out.println("strBillNo------>" + strBillNo);
		System.out.println("strBServiceId------>" + strBServiceId);
		System.out.println("strHospitalCode------>" + strHospitalCode);
		System.out.println("isDuplicateBill------>" + isDuplicateBill);
		System.out.println("isDuplicateBill------>" + isDuplicateBill);
		System.out.println("------------------------------------------");

		if (strBillNo == null && strBillNo.length() != 10) {
			throw new Exception("PrintHLP.Consolidated()--> Receipt No. Cannot be Blank or Invalid");
		}
		if (strBServiceId == null && strBServiceId.length() != 2) {
			throw new Exception("PrintHLP.Consolidated()--> Receipt Service Id Cannot be Blank or Invalid");
		}
		if (strHospitalCode == null && strHospitalCode.length() != 3) {
			throw new Exception("PrintHLP.Consolidated()--> Hospital Code Cannot be Blank or Invalid");
		}

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;
		WebRowSet ws = null, ws1 = null;
		StringBuffer contents = new StringBuffer("");
		String bill_date = null;
		String bill_no = null;
		String[] patient_name = null;
		String patient_category = null;
		String Crno = null;
		String pat_net_amt = null;
		String strHidden = null;
		String exp_amt = null;
		String clt_net_amt = null;
		String dept = null;
		String strHospDtl = null;
		BillConfigUtil billConfigUtil = null;
		String strIsCreditCat = "0"; // 0 no 1 yes credit category..
		String strClientName = "---";
		// Map clNoPrintMap=null;
		String patTotAmt = "0.00";
		String clientTotAmt = "0.00";
		String tempStr = "";
		String serv_type = "";
		String creditno = "---";
		String paymentdtls = "";
		String argtscat = "0"; // 0 no 1 yes category..
		String staffcat = "0";
		String PaymentModeName = "";
		String paymentMode = "";
		String paymentmode = "0";

		String BillType = "";
		String Mobile = "";
		boolean content = false;
		double concessionAmt = 0.00;

		try {
			billConfigUtil = new BillConfigUtil(strHospitalCode);

			voObj = new PrintVO();
			boObj = new PrintBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrReceiptNo(strReceiptNo);
			voObj.setStrBillNo(strBillNo);
			voObj.setStrHospCode(strHospitalCode);

			// strIsDirectMode=1 Cash Collecton Offline
			// strIsDirectMode=0 Cash Collecton Online
			if (strIsDirectMode == "1") {
				boObj.OPD_SERVICES_DIRECT(voObj);
			} else {
				boObj.OPD_SERVICES(voObj);
			}

			BillConfigUtil brt = new BillConfigUtil(strHospitalCode);
			String Footer = brt.getBillFormatFooter();

			if (strIsDirectMode == "1") {
				ws = voObj.getGblWs1();// a flield with name 'creditCat'=1 indicates it s a credit category..
			} else {
				ws = voObj.getGblWs1();
				ws1 = voObj.getGblWs2();// fields related to credit category are received..
			}

			for (int k = 0; ws.next(); k++) {
				bill_no = ws.getString(1);
				bill_date = ws.getString(2);
				patient_name = ws.getString(3).replace("^", "#").split("#");
				patient_category = ws.getString(4);
				Crno = ws.getString(5);
				exp_amt = HisUtil.getAmountWithDecimal(ws.getString(6), 2);
				pat_net_amt = HisUtil.getAmountWithDecimal(ws.getString(7), 2);
				clt_net_amt = HisUtil.getAmountWithDecimal(ws.getString(8), 2);
				strHidden = ws.getString(9);
				serv_type = ws.getString(10);
				dept = ws.getString(11);
				strHospDtl = ws.getString(14);
				strIsCreditCat = ws.getString(15);// 1 yes its credit cat..
				strClientName = ws.getString(16).equals("") ? "---" : ws.getString(16);// 1 yes its credit cat..
				creditno = ws.getString(17).equals("0") ? "---" : ws.getString(17);
				paymentdtls = ws.getString(18);// .equals("")?"---":ws.getString(18);
				argtscat = ws.getString(19);// 1 yes its cat..
				staffcat = ws.getString(21);
				paymentmode = ws.getString(22);

				double cltamt = Double.parseDouble(clt_net_amt);

				if (isDuplicateBill == 1) {
					contents.append(hisutil.appendSpace("DUPLICATE--", 40, 1)
							+ hisutil.appendSpace(printCopyType.toUpperCase(), 54, 0));
					contents.append("\n");
					printLine++;
					printLine++;
				}
				contents.append(hisutil.appendSpace("[" + BillType, 40, 1).toUpperCase()
						+ hisutil.appendSpace(" RECEIPT]", 54, 0) + "\n");
				printLine++;

				contents.append(
						hisutil.appendSpace(" PIN.", 10, 0) + ": " + hisutil.appendSpace(Crno.toUpperCase(), 20, 0));// 10+20=30+2
				contents.append(hisutil.appendSpace("DATE&TIME", 10, 0) + ": " + hisutil.appendSpace(bill_date, 21, 0));// 10+21=31+2
				contents.append(hisutil.appendSpace("BILL No.", 10, 0) + ": " + hisutil.appendSpace(bill_no, 20, 0));// 10+20=30+2
				contents.append("\n");
				printLine++;
				printLine++;

				contents.append(hisutil.appendSpace(" NAME", 10, 0) + ": " + hisutil
						.appendSpace(hisutil.breakString(patient_name[0], 20, "~").get(0).toUpperCase(), 20, 0));
				contents.append(hisutil.appendSpace("Mobile No", 10, 0) + ": " + hisutil.appendSpace(Mobile, 21, 0));
				contents.append(hisutil.appendSpace(" ", 10, 0) + " " + hisutil.appendSpace(" ", 20, 0));

				contents.append("\n");
				printLine++;
				printLine++;

				contents.append(hisutil.appendSpace(" CATEGORY", 10, 0) + ": " + hisutil
						.appendSpace(hisutil.breakString(patient_category, 20, "~").get(0).toUpperCase(), 20, 0));
				contents.append(hisutil.appendSpace("AGE/SEX", 10, 0) + ": "
						+ hisutil.appendSpace(patient_name[1].toUpperCase(), 21, 0));
				contents.append(hisutil.appendSpace("ORG.", 10, 0) + ": "
						+ hisutil.appendSpace(hisutil.breakString(strClientName, 20, "~").get(0).toUpperCase(), 20, 0));
				// contents.append(hisutil.appendSpace("SERVICE", 10, 0)+ ": "+
				// hisutil.appendSpace(hisutil.breakString(serv_type, 19,
				// "~").get(0).toUpperCase(), 20, 0));
				contents.append("\n");
				printLine++;
				printLine++;

				// contents.append(MakeClientDtlStr(strHidden));
				contents.append(hisutil.appendSpace(" SERVICE", 10, 0) + ": "
						+ hisutil.appendSpace(serv_type.toUpperCase(), 20, 0));
				contents.append(hisutil.appendSpace("DEPARTMENT", 10, 0) + ": "
						+ hisutil.appendSpace(hisutil.breakString(dept, 53, "~").get(0).toUpperCase(), 53, 0));
				contents.append("\n");
				printLine++;
				printLine++;

				contents.append(
						"----------------------------------------------------------------------------------------------");
				contents.append("\n");
				printLine++;
				contents.append(hisutil.appendSpace("S.No.", 6, 0));
				contents.append(hisutil.appendSpace("PROCEDURE/INVESTIGATION/SERVICE NAME", 40, 0));
				contents.append(hisutil.appendSpace("LOCATION", 15, 0));
				contents.append(hisutil.appendSpace("RATE(Rs.)", 10, 0));
				contents.append(hisutil.appendSpace("QTY.", 8, 0));
				contents.append(hisutil.appendSpace("AMOUNT(Rs.)", 15, 0));
				contents.append("\n");
				printLine++;

				contents.append(
						"----------------------------------------------------------------------------------------------");
				contents.append("\n");
				printLine++;

				// /iterating printMap for printing tariff based on group

				// concessionAmt=iterateMapForPrinting(tariffPrintMap, contents, brt);

				if (cltamt > 0) {
					contents.append(hisutil.appendSpace("EXPENSE AMT   : ", 67, 1) + hisutil.appendSpace(exp_amt, 12, 1)
							+ "\n");
					printLine++;
					contents.append(hisutil.appendSpace("PAID BY THIRD PARTY   : ", 68, 1)
							+ hisutil.appendSpace(clt_net_amt, 12, 1) + "\n");
					printLine++;
					contents.append(hisutil.appendSpace("PAID BY PATIENT   : ", 67, 1)
							+ hisutil.appendSpace(pat_net_amt, 12, 1) + "\n");
					printLine++;
				} else {
					contents.append(hisutil.appendSpace("---------------", 93, 1));
					contents.append("\n");
					printLine++;
					// contents.append(hisutil.appendSpace("TOTAL AMOUNT ",74, 1)+
					// hisutil.appendSpace(exp_amt, 8, 1));
					contents.append(
							hisutil.appendSpace("TOTAL AMOUNT ", 84, 1) + hisutil.appendSpace(pat_net_amt, 10, 1));
					contents.append("\n");
					printLine++;
					contents.append(hisutil.appendSpace("---------------", 93, 1));
					contents.append("\n");
					printLine++;
				}

				contents.append("\n");
				printLine++;

				// contents.append(hisutil.appendSpace("BILLED AMT ",74, 1)+
				// hisutil.appendSpace(exp_amt, 7, 1));
				if (!staffcat.equals("1"))
					contents.append(hisutil.appendSpace("BILLED AMT ", 74, 1) + hisutil.appendSpace(pat_net_amt, 7, 1));
				else
					contents.append(hisutil.appendSpace("TOTAL CHARGES ", 74, 1)
							+ hisutil.appendSpace(Double.toString(Math.abs(concessionAmt)), 7, 1));
				contents.append("\n");
				printLine++;

				contents.append(hisutil.appendSpace("EXEMPTION/CONCESSION AMT ", 74, 1)
						+ hisutil.appendSpace(Double.toString(concessionAmt), 7, 1));
				contents.append("\n");
				printLine++;
				// contents.append(hisutil.appendSpace("COLLECTED AMT ",74, 1)+
				// hisutil.appendSpace(exp_amt, 7, 1));
				contents.append(hisutil.appendSpace("COLLECTED AMT ", 74, 1) + hisutil.appendSpace(pat_net_amt, 7, 1));
				contents.append("\n");
				printLine++;

				contents.append(hisutil.appendSpace("RUPEES (IN WORD) : " + hisutil.getAmountStr(pat_net_amt), 94, 0));
				contents.append("\n");
				printLine++;
				printLine++;

			} // Ist For Loop
			contents.append(hisutil.appendSpace("NOTE : AMOUNT,PATIENT SHARE AND CREDIT SHARE ARE IN RS.", 94, 0));
			contents.append("\n");
			printLine++;
			printLine++;

			contents.append(hisutil.appendSpace("MODE OF PAYMENT: " + paymentmode, 94, 0));
			contents.append("\n");
			printLine++;
			contents.append(hisutil.appendSpace(
					"PAYMENT DETAILS:" + hisutil.breakString(paymentdtls, 77, "~").get(0).toUpperCase(), 94, 0));
			contents.append("\n");
			printLine++;

			/*
			 * contents.append(hisutil.appendSpace("(U): URGENT TARIFF SURCHARGE("
			 * +billConfigUtil.getStrUrgTrfSur()+"% EXTRA CHARGES)",94, 0));
			 * contents.append("\n"); printLine++;
			 */

			if (argtscat.equals("1") && Double.parseDouble(clientTotAmt) > 0.00) {
				if (Double.parseDouble(patTotAmt) == 0.00) {
					contents.append("<b>");
					contents.append(hisutil.appendSpace("NO AMOUNT IS COLLECTED - CASHLESS SCHEME", 94, 0));
					contents.append("</b>");
					contents.append("\n");
					printLine++;
				}
				if (Double.parseDouble(patTotAmt) > 0.00) {
					contents.append("<b>");
					contents.append(hisutil.appendSpace(
							"NO AMOUNT IS COLLECTED (LIMIT- Rs." + clientTotAmt + ") - CASHLESS SCHEME", 94, 0));
					contents.append("</b>");
					contents.append("\n");
					printLine++;
				}
			}

			if (strBillNo.startsWith("5")) {
				contents.append(Footer(Footer, request, brt.getBillDisclaimerWithoutCrNo()));
			} else {
				contents.append(Footer(Footer, request, brt.getBillDisclaimerServices()));
			}

			strIsDirectMode = "0";

			content = PrintContents(strBServiceId, "1", contents.toString(), request);
			System.out.println("Opd Services------->" + contents.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Billing  PrintHLP.OPD_SERVICES() -->" + e.getMessage());
		} finally {
			voObj = null;
			boObj = null;
			hisutil = null;
			billConfigUtil = null;
		}

		return content;
	}

	/**
	 * Footer(String ConCatVal) -- > This Method is Used to get Client Detail String
	 * If we pass Client Detail in Concat Format
	 * like:-Header1^Header2^Header3^Header4
	 */
	public static String Footer(String Footer, HttpServletRequest request, String strDisclaimer) throws Exception {
		String contents3 = new String();
		String F1 = null;
		String disclaimer = null;

		PrintVO voObj = null;
		PrintBO boObj = null;
		HisUtil hisutil = null;

		String strCounterName = "";
		String strUserName = "";

		if (Footer.equals("") || Footer.equals("-") || Footer.equals("0")) {
			F1 = "";
		} else {
			F1 = Footer;
		}

		if (strDisclaimer.equals("") || strDisclaimer.equals("-") || strDisclaimer.equals("0")) {
			disclaimer = "";
		} else {
			disclaimer = strDisclaimer;
		}
		try {

			voObj = new PrintVO();
			boObj = new PrintBO();
			hisutil = new HisUtil("billing", "PrintHLP");

			voObj.setStrIpAddress(request.getSession().getAttribute("IP_ADDR").toString());
			voObj.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			voObj.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			boObj.getCounterAndUserName(voObj);

			if (voObj.getStrCounterAndUserName().next()) {
				String strTemp[] = voObj.getStrCounterAndUserName().getString(1).replace("^", "#").split("#");
				strCounterName = strTemp[0].toUpperCase();
				strUserName = strTemp[1].toUpperCase();
			}
		} catch (Exception e) {
			throw e;
		}

		contents3 = "\n \n " + hisutil.appendSpace(strUserName + " (" + strCounterName + ")", 79, 1);
		contents3 += "\n";
		printLine++;
		contents3 += hisutil.appendSpace("AUTHORISED SIGNATORY", 79, 1);
		contents3 += "\n";
		printLine++;

		if (F1.trim().length() > 0) {
			contents3 += hisutil.appendSpace(F1, 94, 0);
			// "\n " + ;
			printLine++;
		}
		if (disclaimer.trim().length() > 0) {
			contents3 += "\n                    " + disclaimer;
			printLine++;
		}

		return contents3;
	}

	public static synchronized boolean PrintContents(String bServiceId, String receiptType, String contents,
			HttpServletRequest request) throws Exception {
		contents += FORMFEED;
		HisPrinter hisPrinter = null;

		try {
			hisPrinter = new HisPrinter();
			hisPrinter.printFile(contents, "Billing", request);
		} catch (Exception e) {
			throw new Exception("PrintHLP.PrintContents()-->" + e.getMessage());
		} finally {
			hisPrinter = null;
		}

		return true;
	}

	/********************************************************************************************************************/

	/**
	 * This method is used to show item Details on ISSUE PAGE
	 * 
	 * @param wb
	 * @param strItemCategory
	 * @param strHospitalCode
	 * @return
	 */
	public static String getItemDetails_Drug(String strItemCategoryNo, String strHospitalCode, WebRowSet wb,
			String strRaisingStoreId, String strBudgetFlg, String strIssueStoreID) throws SQLException {
		StringBuffer br = new StringBuffer();

		InjAdministrationTransVO vo = null;
		InjAdministrationTransBO bo = null;

		HisUtil hisutil = null;

		String strUnitComboValues = "";

		String strHiddenId = ""; // item id^brandid^RESERVED FLAG^GROUPID^SUBGROUP ID^CONSUMABLE FLAG
									// ^strItemCategory^strRaisingStoreId
		// String strItemName = "";
		String strBrandName = "";
		String strAvlQty = "";
		String strAvlQtyWithUnitId = "";
		String strAvlQtyBaseVal = "";
		String strBalQty = "";
		String strSancUnitId = "";
		String strSancUnitName = "";
		String strBalQtyBaseVal = "";
		String strReqSancQty;
		// String strRateBaseVal = "";
		// String strRate = "";
		// String strRateUnitId = "";
		String[] temp = null;
		String strReOrderFlg;
		String strApplyClass;
		String strCompSancUnit;
		String strReceivingStoreAvlQty = "";
		String strTotalNoOfBatch = "";
		String strCost = "0.00";
		String strFrequencyName = "";
		String strDoses = "";
		String strfrequency = "";
		int i = 0;
		String curGroupName = "";
		String preGroupName = "";
		String strDeptPKey = "";

		try {
			hisutil = new HisUtil("mms", "InjAdministrationTransHLP");

			bo = new InjAdministrationTransBO();
			vo = new InjAdministrationTransVO();
			vo.setStrHospitalCode(strHospitalCode);
			if (wb.size() != 0) {

				// br.append("<table class='TABLEWIDTH' bgcolor='#6097BC'
				// align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<table class='table'>");
				br.append("<thead>");
				br.append("<tr>");
				br.append("<th  style='width:20%;text-align: center !important;'><b>Item Name</b></th>");
//					br.append("<th  style='width:8%;text-align: center !important;'><b>Doses</b></th>");
				// br.append("<th style='width:8%'><b>Indent Store Qty</b></th>");
				br.append("<th  style='width:8%;text-align: center !important;'><b>Doses</b></th>");
				br.append("<th  style='width:8%;text-align: center !important;'><b>Frequency</b></th>");
				br.append("<th  style='width:8%'><b>Avl Qty</b></th>");
				br.append("<th  style='width:8%'><b>Req Qty</b></th>");
				br.append("<th  style='width:8%'><b>Issue Qty</b></th>");
				br.append("<th  style='width:16%'><b>Batch</b></th>");
				br.append("<th  style='width:16%'><b>Exp Date</b></th>");
				br.append("<th  style='width:8%'><b>Cost</b></th>");
				// br.append("<th style='text-align:center;'
				// style='width:8%'><b>Remarks</b></th>");
				// br.append("<th style='text-align:center;' style='width:8%'><b>LP
				// Qty</b></th>");

				br.append("</tr>");
				br.append("</thead>");

				while (wb.next()) {
					/*
					 * 1. P_Key [ HSTNUM_ITEM_ID||'^'||HSTNUM_ITEMBRAND_ID||' ^ 0 ^ 0^0^0' ] 2.
					 * Generic Name 3. Brand Name 4. Avl Qty 5. Balance Qtty 6. Unit Id 7. Unit Name
					 * 8. Requestd Qty 9. Requested / Sanction Qty 10. Re-Order 11. Unit Id 6301 ^ 1
					 * ^ 0 12. 0 Null Value 13. Batch 14. Rec Store Avl Qty 15. Total No Of Batch
					 * 16. Drug Type 17. EDL Catg 18. Sale Price 19. Frequency 20. Department Name
					 * 21. Dosase Name 22. Dept Code ^ Episode Code
					 */

					strHiddenId = wb.getString(1); // item id ^ brand id ^ 0 ^ 0 ^ 0 ^ 0
					strBrandName = wb.getString(3);// +" [ "+wb.getString(19)+" ] ";
					strAvlQty = wb.getString(4);
					strBalQty = wb.getString(5);
					if (wb.getString(6) == null) {
						strSancUnitId = "0";
					} else {
						strSancUnitId = wb.getString(6);
					}
					strSancUnitName = wb.getString(7);
					strBalQtyBaseVal = wb.getString(8);

					strReqSancQty = wb.getString(8);

					strCompSancUnit = wb.getString(11); // Adding in Change Request 28-July-2011
					strReceivingStoreAvlQty = wb.getString(14);
					strTotalNoOfBatch = wb.getString(15);
					strFrequencyName = wb.getString(19);
					strDoses = wb.getString(21);
					strfrequency = wb.getString(19);
					strDeptPKey = wb.getString(22);

					if (strBalQty.equals("0")) {
						strSancUnitName = " ";
					}

					System.out.println("- strHiddenId [item id ^ brand id ^ 0 ^ 0 ^ 0 ^ 0] -- " + strHiddenId);
					System.out.println("--- strTotalNoOfBatch-" + strTotalNoOfBatch);

					if (Integer.parseInt(strTotalNoOfBatch) == 1) {

						strItemCategoryNo = strHiddenId.split("\\^")[1].substring(0, 2);

						// System.out.println("-- CATG_NO -"+strItemCategoryNo);

						// Item ID ^ ItemBrand Id ^ Batch No ^ StoreID ^ Catg NO
						vo.setStrSingleItemDtl(strHiddenId.split("\\^")[0] + "^" + strHiddenId.split("\\^")[1] + "^"
								+ wb.getString(13) + "^" + strIssueStoreID + "^" + strItemCategoryNo);

						/*
						 * System.out.
						 * println("-- Single Batch Dtl -Pkg_Mms_View.proc_itemStock_dtl [ Mode - 7 ]-"
						 * +strHiddenId.split("\\^")[0] + "^" + strHiddenId.split("\\^")[1] + "^" +
						 * wb.getString(13) + "^" + strIssueStoreID + "^" + strItemCategoryNo);
						 */

						bo.getSingleBatchItemDtl(vo);

						// Pkg_Mms_View.proc_itemStock_dtl [ Mode - 7 ]

						/*
						 * 1.Generic Name 2.Brand Name 3.Batch No 4.Mfg Date 5.Exp Date 6.Rate 7.Avl Qty
						 * 8.Mfg Name 9.Rate With Unit 10.PO No 11. Prg Id 12. NA 13. Supp Id
						 * 
						 */

					}
					if (Integer.parseInt(strTotalNoOfBatch) == 0) {
						// Item ID ^ ItemBrand Id ^ Batch No ^ StoreID
						vo.setStrSingleBatchDtlWs(null);
					}

					if (wb.getString(17).equals("1")) {
						strApplyClass = "width:32%;text-align: center !important;";
					} else {
						strApplyClass = "width:32%;text-align: center !important;";
					}
					temp = strAvlQty.replace("^", "#").split("#");

					strAvlQty = temp[0];
					strAvlQtyWithUnitId = temp[1];
					strAvlQtyBaseVal = temp[2];

					vo.setStrSancUnitId(strSancUnitId);

					strUnitComboValues = "<option value='6301'>No</option>";

					// System.out.println("--- InjAdministrationTransHLP - A ---");

					// curGroupName = wb.getString(20);
					curGroupName = wb.getString(20) == null ? "-" : wb.getString(20);

					if (!curGroupName.equals(preGroupName)) {
						br.append("<tr>");
						br.append(
								"<td colspan='7' style='text-align:left; width:5%;color:#0000FF;'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'><b><u>"
										+ curGroupName + "</u></b></font></td>");
						br.append("</tr>");
					}

					br.append("<tr>");

					br.append(" <input type='hidden' name='strDeptPKey' id='strDeptPKey" + i + "' value= '"
							+ strDeptPKey + "' /> ");

					br.append("<td  id='td1" + i
							+ "'  style='width:20%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:left;'  >");
					br.append(" <input type='hidden' name='strItemDetailsChk' id='strItemDetailsChk" + i + "' value= '"
							+ strHiddenId + "^" + strItemCategoryNo + "^" + strRaisingStoreId + "' /> ");
					br.append(" <input type='hidden' name='flag' id='flag" + i + "' value=" + "0" + " />");

					br.append(" <input type='hidden' name='reOrderFlag' id='reOrderFlag" + i + "' value="
							+ wb.getString(10) + " />");
					br.append(" <input type='hidden' name='strReceivingStoreAvlQtyChk' id='strReceivingStoreAvlQtyChk"
							+ i + "' value=" + strReceivingStoreAvlQty + " />");
					br.append(" <input type='hidden' name='strAvlQtyForChk' id='strAvlQtyForChk" + i + "' value="
							+ strAvlQty + " /><b>");

					br.append(strBrandName);
					br.append("</b></td>");

					br.append("<td WIDTH='8%' id='td2" + i
							+ "'  style='width:8%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;' >"
							+ strDoses + "");
					br.append("</td>");

					br.append("<td WIDTH='8%' id='td2" + i
							+ "'  style='width:8%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;' >"
							+ strfrequency + "");
					br.append("</td>");

					br.append("<td WIDTH='5%' id='td2" + i
							+ "'  style='width:8%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;' >"
							+ strAvlQty + "<input type='hidden' name='strAvlQty' id='strAvlQty" + i + "' value='"
							+ strAvlQtyWithUnitId
							+ "' /><input type='hidden' name='strAvlQtyBaseVal' id='strAvlQtyBaseVal" + i + "' value='"
							+ strAvlQtyBaseVal + "' />");
					br.append("</td>");

					br.append("<input type='hidden' name='strBalQty' id='strBalQty" + i + "' value='" + strBalQty
							+ "' /><input type='hidden' name='strSancUnitId' id='strSancUnitId" + i + "' value='"
							+ strSancUnitId + "' /> <input type='hidden' name='strBalQtyBaseVal' id='strBalQtyBaseVal"
							+ i + "' value='" + strBalQtyBaseVal + "' />");

					br.append("<td  id='td3" + i
							+ "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;'  >"
							+ strReqSancQty + "");
					br.append("</td>");

					if (Integer.parseInt(strTotalNoOfBatch) == 1) {
						if (Integer.parseInt(strAvlQty) < Integer.parseInt(strReqSancQty)) {

							br.append("<td  id='td4" + i
									+ "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;' >"
									+ "<input type='text' autocomplete='off' maxlength='8' onkeypress='return validateData(event,5);' onkeyup='return QtyValidation("
									+ i + ");' name='strIssueQty' id='strIssueQty" + i
									+ "' class='form-control' value='" + strAvlQty + "'  >");
							br.append("</td>");
						} else {
							br.append("<td  id='td4" + i
									+ "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;' >"
									+ "<input type='text' autocomplete='off' maxlength='8' onkeypress='return validateData(event,5);' onkeyup='return QtyValidation("
									+ i + ");' name='strIssueQty' id='strIssueQty" + i
									+ "' class='form-control' value='" + strReqSancQty + "'  >");
							br.append("</td>");
						}
					} else {
						if (Integer.parseInt(strAvlQty) < Integer.parseInt(strReqSancQty)) {

							br.append("<td  id='td4" + i
									+ "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;' >"
									+ "<input type='text' autocomplete='off' maxlength='8' onkeypress='return validateData(event,5);' onkeyup='return QtyValidation("
									+ i + ");' name='strIssueQty' id='strIssueQty" + i
									+ "' class='form-control' value='" + strAvlQty + "'  >");
							br.append("</td>");
						} else {
							br.append("<td  id='td4" + i
									+ "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;' >"
									+ "<input type='text' autocomplete='off' maxlength='8' onkeypress='return validateData(event,5);' onkeyup='return QtyValidation("
									+ i + ");' name='strIssueQty' id='strIssueQty" + i
									+ "' class='form-control' value='" + strReqSancQty + "'   >");
							br.append("</td>");
						}
					}

					br.append("<input type='hidden' name='strTotalBatch' id='strTotalBatch" + i + "' value='"
							+ strTotalNoOfBatch + "' />");

					br.append("<input type='hidden' name='strTotBatch' id='strTotBatch" + i + "' value='"
							+ strTotalNoOfBatch + "' />");

					if (Integer.parseInt(strTotalNoOfBatch) > 1) {
						// System.out.println("--- InjAdministrationTransHLP - B ---");

						br.append("<input type='hidden' name='strSingleManufId'    id='strSingleManufId" + i
								+ "' value='' />");
						br.append("<input type='hidden' name='strSingleProgId'     id='strSingleProgId" + i
								+ "' value='' />");
						br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch" + i
								+ "' value='' />");
						br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry" + i
								+ "' value='' />");
						br.append("<input type='hidden' name='strSingleMfgName'    id='strSingleMfgName" + i
								+ "' value='' />");
						br.append("<input type='hidden' name='strProgrammeName'    id='strProgrammeName" + i
								+ "' value='' />");
						br.append("<input type='hidden' name='strSingleStockRate'  id='strSingleStockRate" + i
								+ "' value='' />");
						br.append("<input type='hidden' name='strStockQty'         id='strStockQty" + i
								+ "' value='' />");
						br.append("<input type='hidden' name='strStockRate'        id='strStockRate" + i
								+ "' value='' />");
						br.append("<input type='hidden' name='strCheckBatchExists' id='strCheckBatchExists" + i
								+ "' value='1' />");
						br.append("<input type='hidden' name='strSingleMfgDate'    id='strSingleMfgDate" + i
								+ "' value='' />");

						br.append("<td id='td9" + i
								+ "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;'  ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
								+ i + "' value='' />" + "<div name='issueDrugDtl' id='issueDrugDtl" + i + "'></div>"
								+ " <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callIpdIssueStockDetails(this,\""
								+ i + "\");' TITLE='Click Here For Item Preferences' >AUTO</td>");

						br.append(
								"<TD style='width:8%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;' id='td8"
										+ i + "' style='" + strApplyClass + "' ><div name='expDrugDtl' id='expDrugDtl"
										+ i + "'></div></td>");

					} else {
						if (vo.getStrSingleBatchDtlWs() != null && vo.getStrSingleBatchDtlWs().size() > 0) {

							if (vo.getStrSingleBatchDtlWs().next()) {
								/*
								 * 1.Generic Name 2.Brand Name 3.Batch No 4.Mfg Date 5.Exp Date 6.Sale Price
								 * 7.Avl Qty 8.Mfg Name 9.Rate With Unit 10.PO No 11. Prg Id 12. NA 13. Supp Id
								 */
								// System.out.println("--- InjAdministrationTransHLP - C ---");

								br.append("<input type='hidden' name='strSingleMfgDate'      id='strSingleMfgDate" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(4) + "' />");
								br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(5) + "' />");
								br.append("<input type='hidden' name='strStockRate'        id='strStockRate" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(6) + "' />");
								br.append("<input type='hidden' name='strStockQty'         id='strStockQty" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(7).split("\\^")[0]
										+ "' />");

								br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(13) + "' />");
								br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(11) + "' />");
								br.append("<input type='hidden' name='strTotBatch' id='strTotBatch" + i + "' value='"
										+ strTotalNoOfBatch + "' />");
								br.append("<input type='hidden' name='strSingleStockRate'        id='strSingleStockRate"
										+ i + "' value='" + vo.getStrSingleBatchDtlWs().getString(9) + "' />");
								br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(3) + "' />");
								br.append("<input type='hidden' name='strSingleMfgName'     id='strSingleMfgName" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(8) + "' />");
								br.append("<input type='hidden' name='strProgrammeName'     id='strProgrammeName" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(12) + "' />");
								br.append("<input type='hidden' name='strCheckBatchExists' id='strCheckBatchExists" + i
										+ "' value='0' />");
								br.append("<input type='hidden' name='stockDtlsId' id='stockDtlsId" + i
										+ "' value='' />");
								br.append("<td  id='td8" + i
										+ "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;' >"
										+ vo.getStrSingleBatchDtlWs().getString(3) + "</td>");

								br.append("<td  id='td9" + i
										+ "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;'   >"
										+ ((vo.getStrSingleBatchDtlWs().getString(5) == null
												|| vo.getStrSingleBatchDtlWs().getString(5).equals("")) ? "NA"
														: vo.getStrSingleBatchDtlWs().getString(5))
										+ "</td>");
							}

						} else {
							// System.out.println("--- InjAdministrationTransHLP - G --[ When BATCH Not
							// Avaliable ]--");

							br.append("<input type='hidden' name='strSingleMfgDate'      id='strSingleMfgDate" + i
									+ "' value='-' />");
							br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry" + i
									+ "' value='-' />");
							br.append("<input type='hidden' name='strStockRate'        id='strStockRate" + i
									+ "' value='0' />");
							br.append("<input type='hidden' name='strStockQty'         id='strStockQty" + i
									+ "' value='0' />");

							br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId" + i
									+ "' value='-' />");
							br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId" + i
									+ "' value='-' />");
							br.append("<input type='hidden' name='strTotBatch' id='strTotBatch" + i + "' value='0' />");
							br.append("<input type='hidden' name='strSingleStockRate'        id='strSingleStockRate" + i
									+ "' value='0' />");
							br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch" + i
									+ "' value='0' />");
							br.append("<input type='hidden' name='strSingleMfgName'     id='strSingleMfgName" + i
									+ "' value='-' />");
							br.append("<input type='hidden' name='strProgrammeName'     id='strProgrammeName" + i
									+ "' value='-' />");
							br.append("<input type='hidden' name='strCheckBatchExists' id='strCheckBatchExists" + i
									+ "' value='0' />");
							br.append("<input type='hidden' name='stockDtlsId' id='stockDtlsId" + i + "' value='' />");
							br.append("<td  id='td8" + i
									+ "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;' >No Batch</td>");

							br.append("<td  id='td9" + i
									+ "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;'   >-</td>");
						}
						br.append(
								"<input type='hidden' disabled='disabled' class=''  value='0.00' name='finalCostDivId' id='finalCostDivId"
										+ i + "' >");
						br.append(
								"<input type='hidden' name='strFinalCost' id='strFinalCost" + i + "' value='0.00' />");
					}

					// System.out.println("--- InjAdministrationTransHLP - F ---");

					br.append(
							"<input type='hidden' class='form-control' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strIssueUnitId' id='strIssueUnitId"
									+ i + "' value='6301' >");

					br.append(
							"<input type='hidden' class='form-control' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strItemRemarks' id='strItemRemarks"
									+ i + "' value='NA' >");

					br.append(
							"<input type='hidden' class='form-control' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strBSQuantity' id='strBSQuantity"
									+ i + "' value='" + strReqSancQty.split(" ")[0] + "' >");
					if (Integer.parseInt(strTotalNoOfBatch) == 1) {
						br.append("<td id='td8" + i
								+ "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;'  >"
								+ "<div name='issu" + "CostDiv' id='issueCostDiv" + i + "'>"
								+ Math.round((Double.parseDouble(strReqSancQty) * Double.parseDouble(wb.getString(18))))
								+ "</div>");
					} else {
						br.append("<td id='td8" + i
								+ "' style='width:8%;font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;'  >"
								+ "<div name='issu" + "CostDiv' id='issueCostDiv" + i + "'>0.00</div>");

					}

					br.append("</td>");

					br.append("</tr>");
					br.append("</div>");
					i++;

					preGroupName = curGroupName;

				} // Most External Loop END Here

				br.append("</table> ");
			} else {
				/*
				 * br.append("<table class='table'>"); br.append("<thead>"); br.append("<tr>");
				 * br.append("<th align='center' ><b>Item Name</b></th>");
				 * br.append("<th align='center' ><b>Avl Qty</b></th>");
				 * br.append("<th align='center' ><b>Req Qty</b></th>");
				 * br.append("<th align='center' ><b>Issue Qty</b></th>");
				 * br.append("<th align='center' ><b>Batch</b></th>");
				 * br.append("<th align='center' ><b>Exp Date</b></th>");
				 * br.append("<th align='center' ><b>Cost</b></th>"); br.append("</tr>");
				 * br.append("</thead>"); br.
				 * append("<tr><td align='center'  style='text-align:center;><font color='black'><b>No Record Found </b></font></td></tr>"
				 * ); br.append("</table>");
				 */
				br.append("<table class='table'>");
				br.append("<thead>");
				br.append("<tr>");
				br.append(
						"<th style='text-align:center;' style='width:20%;text-align: center !important;'><b>Item Name [ Freq ]</b></th>");
				br.append(
						"<th style='text-align:center;' style='width:8%;text-align: center !important;'><b>Doses</b></th>");
				br.append(
						"<th style='text-align:center;' style='width:8%;text-align: center !important;'><b>Frequency</b></th>");
				br.append("<th style='text-align:center;' style='width:8%'><b>Avl Qty</b></th>");
				br.append("<th style='text-align:center;' style='width:8%'><b>Req Qty</b></th>");
				br.append("<th style='text-align:center;' style='width:8%'><b>Issue Qty</b></th>");
				br.append("<th style='text-align:center;' style='width:16%'><b>Batch</b></th>");
				br.append("<th style='text-align:center;' style='width:16%'><b>Exp Date</b></th>");
				br.append("<th style='text-align:center;' style='width:8%'><b>Cost</b></th>");
				br.append("</tr>");
				br.append("</tr>");
				br.append("</thead>");
				br.append(
						"<tr><td align='center'  style='text-align:center;><font color='black'><b>No Record Found </b></font></td></tr>");
				br.append("</thead>");

			}

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}
		//// System.out.println("O/P String:::::"+br.toString());
		return br.toString();
	}

	public static String getStockItemDtlsInitView(InjAdministrationTransFB formBean) throws Exception {

		StringBuffer sb = new StringBuffer("");

		WebRowSet ws = formBean.getWsStockDetails();
		HisUtil util = new HisUtil("IssueDeskTrans Stock Detail Util", "IssueDeskTransHLP");
		IssueDeskTransVO vo = new IssueDeskTransVO();
		int count = 0;

		boolean flag = false;

		String strHiddenVal = "0";
		String[] strHiddenValList = null;
		String[] strTemp = null;
		String[] strChkList = null;
		String[] strQtyList = null;
		String[] strUnitList = null;

		String[] strHiddenCost = null;
		String[] strHiddenTotalCost = null;

		String strTempQtyVal = "";
		String strTempUnitVal = "";
		String strTempCost = "0.00";
		String strTempTotalCost = "0.00";
		String strTableWidth = "100%";
		try {

			StringBuffer strChkVal = new StringBuffer("");
			if (formBean.getStrModeVal().equals("1")) {

				sb.append("<table width='" + strTableWidth + "' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr class='HEADER'> ");
				sb.append("<input type='hidden' name='strIndex' id='strIndex' value='" + formBean.getStrIndex() + "'>");
				sb.append("<input type='hidden' name='strParentIndex' id='strParentIndex" + count + "' value='"
						+ formBean.getStrParentIndex() + "'>");
				if (formBean.getStrItemCategoryId().equals("10")) {

					sb.append("<td colspan='4'>Drug Stock Detail(s) </td> ");

				} else {
					sb.append("<td colspan='4'>Item Stock Detail(s) </td> ");
				}
				sb.append("</tr> ");
				sb.append("<tr> ");
				if (formBean.getStrItemCategoryId().equals("10")) {

					sb.append("<td width='50%' class='LABEL'>Drug Name</td> ");

				} else {
					sb.append("<td width='50%' class='LABEL'>Item Name</td> ");
				}

				sb.append("<td width='50%' class='CONTROL'>" + formBean.getStrItemName() + "</td> ");
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td width='50%' class='LABEL'>Issue Qty.</td> ");
				sb.append("<td width='50%' class='CONTROL'>" + formBean.getStrIndentIssueQty()
						+ " No <input type='hidden' class='txtFldNormal' ");
				sb.append("name='strItemIssueQty' value='" + formBean.getStrIndentIssueQty()
						+ "'><input type='hidden' class='txtFldNormal' ");
				sb.append("name='strItemIssueQtyBaseVal' value='" + formBean.getStrIssueQtyInBase() + "'></td> ");

				sb.append("</tr> ");
				sb.append("</table> ");

				sb.append("<table width='" + strTableWidth + "' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr class='TITLE'> ");
				if (!formBean.getStrItemCategoryId().equals("10")) {
					sb.append("<td colspan='10'>Item Detail(s)</td> ");
				} else {
					sb.append("<td colspan='10'>Drug Detail(s)</td> ");
				}
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td class='multiRPTLabel' width='5%'>#");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='14%'>Batch No. ");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='10%'>Expiry Date ");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='10%'>Avl. Qty. ");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='7%'>Rate/Unit");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='12%'><font color='red'>*</font>Issue Qty. ");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='8%'><font color='red'>*</font>Unit ");
				sb.append("</td> ");
				if (formBean.getUsrArg().equals("1")) // Means Budget Required
				{
					sb.append("<td class='multiRPTLabel' width='14%'>Cost");
					sb.append("</td> ");
				}
				sb.append("</tr> ");

				// System.out.println("----IssueDeskHLP . getStockItemDtlsInitView
				// ---SIZE--"+ws.size());

				if (ws != null && ws.size() > 0) {

					while (ws.next()) {
						strChkVal = new StringBuffer();
						String strExpDate = "";
						if (ws.getString(18) != null && ws.getString(18).length() > 10) {
							strExpDate = ws.getString(18);
						}
						if (formBean.getStrItemCategoryId().equals("10")) {

							strChkVal.append(ws.getString(11)).append("^").append(ws.getString(12)).append("^")
									.append(ws.getString(13)).append("^").append(ws.getString(15)).append("^")
									.append(ws.getString(14)).append("^0").append("^").append(strExpDate).append("^")
									.append(ws.getString(19)).append("^").append(ws.getString(20)).append("^")
									.append(ws.getString(21)).append("^").append(ws.getString(23)).append("^")
									.append(ws.getString(24)).append("^").append(ws.getString(38)).append("^")
									.append(ws.getString(39));
						} else {

							strChkVal.append(ws.getString(11)).append("^").append(ws.getString(12)).append("^")
									.append(ws.getString(13)).append("^").append(ws.getString(15)).append("^")
									.append(ws.getString(14)).append("^").append(ws.getString(37)).append("^")
									.append(strExpDate).append("^").append(ws.getString(19)).append("^")
									.append(ws.getString(20)).append("^").append(ws.getString(21)).append("^")
									.append(ws.getString(23)).append("^").append(ws.getString(24)).append("^")
									.append(ws.getString(38)).append("^").append(ws.getString(39));

						}
						count = count + 1;
						sb.append("<tr>");
						strHiddenVal = formBean.getStrHiddenVal();
						if (strHiddenVal.length() > 1) {
							strHiddenValList = strHiddenVal.split("@");
							strChkList = new String[strHiddenValList.length];
							strQtyList = new String[strHiddenValList.length];
							strUnitList = new String[strHiddenValList.length];
							strHiddenTotalCost = new String[strHiddenValList.length];
							strHiddenCost = new String[strHiddenValList.length];
							//// System.out.println("length::::::"+strHiddenValList.length);
							for (int i = 0, stopI = strHiddenValList.length; i < stopI; i++) {
								// //System.out.println("Hidden val:::"+strHiddenValList[i]);
								strTemp = strHiddenValList[i].replace("^", "#").split("#");
								strChkList[i] = new StringBuffer(strTemp[0]).append("^").append(strTemp[1]).append("^")
										.append(strTemp[2]).append("^").append(strTemp[3]).append("^")
										.append(strTemp[4]).append("^").append(strTemp[5]).append("^")
										.append(strTemp[6]).append("^").append(strTemp[7]).append("^")
										.append(strTemp[8]).append("^").append(strTemp[9]).append("^")
										.append(strTemp[10]).append("^").append(strTemp[11]).append("^")
										.append(strTemp[12]).append("^").append(strTemp[13]).toString();

								strQtyList[i] = strTemp[14];
								strUnitList[i] = strTemp[15];
								strHiddenCost[i] = strTemp[18];
								strHiddenTotalCost[i] = strTemp[19];
							}
						}

						if (strChkList != null) {

							for (int i = 0, stopI = strChkList.length; i < stopI; i++) {
								String content = strChkList[i];

								if (content.equalsIgnoreCase(strChkVal.toString())) {
									flag = true;
									strTempQtyVal = strQtyList[i];
									strTempUnitVal = strUnitList[i];

									strTempCost = strHiddenCost[i];
									strTempTotalCost = strHiddenTotalCost[i];

								}

							}

						}
						if (flag) {
							sb.append(
									"<td class='multiPOControl' width='5%'><input type='checkbox' name='strStockDtlsChk' id='strStockDtlsChk"
											+ count + "' checked='checked'  value='" + strChkVal.toString()
											+ "' onclick='checkStockDetails(this,\"" + count + "\");'> ");

						} else {

							sb.append(
									"<td class='multiPOControl' width='5%'><input type='checkbox' name='strStockDtlsChk' id='strStockDtlsChk"
											+ count + "' value='" + strChkVal.toString()
											+ "' onclick='checkStockDetails(this,\"" + count + "\");'> ");

						}
						sb.append("</td> ");
						sb.append("<td class='multiPOControl' width='14%'>");
						sb.append(ws.getString(15));
						sb.append("</td> ");
						sb.append("<td class='multiPOControl' width='10%'>");
						sb.append(strExpDate);
						sb.append("</td> ");
						sb.append("<td class='multiPOControl' width='10%'>");
						sb.append(ws.getString(9).split("\\ ")[0]);
						sb.append("</td> ");
						sb.append("<td class='multiPOControl' width='7%'>");
						sb.append(ws.getString(23) + "/" + ws.getString(9).split("\\ ")[1]);

						sb.append("<input type='hidden' name='strAvlDrugBatch'    id='strAvlDrugBatch" + count
								+ "'    value='" + ws.getString(15) + "'>");
						sb.append("<input type='hidden' name='strDrugBatchAvlQty' id='strDrugBatchAvlQty" + count
								+ "' value='" + ws.getString(9).split("\\ ")[0] + "'>");
						sb.append("<input type='hidden' name='strRate'            id='strRate" + count
								+ "'            value='" + ws.getString(23) + "'>");
						sb.append("<input type='hidden' name='strRate'            id='strPurchaseRate" + count
								+ "'    value='" + ws.getString(23) + "'>");
						sb.append("</td> ");

						sb.append("<td class='multiPOControl' width='12%'>");

						if (flag) {
							// Method in issueDesk_trans.js File
							sb.append("<input type='text' autocomplete='off' class='txtFldMin' maxlength='7' value='"
									+ strTempQtyVal
									+ "' onkeypress='return validateData(event,7);' onkeyup='checkAvailQtyIpdIssue(\""
									+ count
									+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\",\"strStockCostId\");' name='strAvailableQty' style='height:20px;' id='strAvailableQty"
									+ count + "'>");

						} else {

							sb.append(
									"<input type='text' autocomplete='off' class='txtFldMin' maxlength='7' disabled='disabled' onkeypress='return validateData(event,7);' onkeyup='checkAvailQtyIpdIssue(\""
											+ count
											+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\");' name='strAvailableQty' style='height:20px;' id='strAvailableQty"
											+ count + "'>");

						}

						sb.append("</td> ");

						sb.append("<td class='multiPOControl' width='8%'>");
						sb.append("<input type='hidden' name='strDrugDtls'         id='strDrugDtls" + (count - 1)
								+ "'  value='" + ws.getString(15) + "'>");
						sb.append("<input type='hidden' name='strExpDtls'          id='strExpDtls" + (count - 1)
								+ "'  value='" + strExpDate + "'>");
						sb.append("<input type='hidden' name='strMrpDtls'          id='strMrpDtls" + (count - 1)
								+ "'  value='" + ws.getString(23) + "'>");

						if (flag) {

							sb.append("<select name='strAvailableQtyUnit' class='comboMin' id='strAvailableQtyUnit"
									+ count + "' onchange='checkAvailQtyIpdIssue(\"" + count
									+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\");'>");

							sb.append("<option value='6301^1^0'>No</option>");

							sb.append("</select>");

						} else {

							sb.append(
									"<select name='strAvailableQtyUnit' disabled='disabled' class='comboMin' id='strAvailableQtyUnit"
											+ count + "' onchange='checkAvailQtyIpdIssue(\"" + count
											+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\");' >");

							sb.append("<option value='6301^1^0'>No</option>");

							sb.append("</select>");

						}
						sb.append("<input type='hidden' name='strBatchCost'    id='strBatchCost" + count
								+ "'    value='0'>");
						sb.append("</td> ");
						sb.append("</tr> ");

						flag = false;

						strTempQtyVal = "";
						strTempUnitVal = "0";
					}

				} else {

					sb.append("<tr> ");
					sb.append(
							"<td colspan='8' class='multiPOControl'><font color='red'><b>Details Not Available</b></font></td> ");
					sb.append("</tr> ");

				}

				sb.append("</table> ");

				sb.append("<input type='hidden' name='strApproxAmt' value='0'></td> ");

				sb.append("<table width='" + strTableWidth + "' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr class='FOOTER'> ");
				sb.append("<td colspan='4'><font size='2' color='red'>*</font> Mandatory Fields  </td> ");
				sb.append("</tr> ");
				sb.append("</table> ");

				sb.append("<table border='0' width='" + strTableWidth + "' align='center'> ");
				sb.append("<tr> ");
				sb.append("<td align='center'><img style='cursor: pointer; ' ");
				sb.append(" src='../../hisglobal/images/btn-ok.png' ");
				sb.append(" onClick='return validateIssueStockPopUp();' title='Save Record'/>  ");
				sb.append(" <img style='cursor: pointer; ' title='Cancel Process'  ");
				sb.append(" src='../../hisglobal/images/close_tab.png' onClick='cancelStockIpdIssueDtls(this,\""
						+ (count - 1) + "\");' /> ");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append(" </table> ");

			}

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}

		return sb.toString();
	}

	public static String patientInjectioAdministrationDtl(String strItemCategoryNo, String strHospitalCode,
			WebRowSet ws, String strRaisingStoreId, String strBudgetFlg, String strIssueStoreID, String strAdmnModeCombo) throws Exception {
		StringBuffer str = new StringBuffer("");
		str.append("");
		String prevDrugName = "";
		
		try {

			if (ws != null && ws.size() > 0) {
				
				str.append("<table class='table' id='data-table'>");
				str.append("<thead>");
				str.append("<tr>");
				str.append("<th  style='width:15%;text-align: center;color: black; font-weight: 400; font-size: 0.9rem;'><b>Patient Info</b></th>");
				str.append("<th  style='width:20%;text-align: center;color: black; font-weight: 400; font-size: 0.9rem;'><b>Item Name</b></th>");
				str.append("<th  style='width:10%;text-align: center;color: black; font-weight: 400; font-size: 0.9rem;'><b>Adv Date /<br>Dept /<br> Adv By</b></th>");
				str.append("<th  style='width:5%;text-align: center;color: black; font-weight: 400; font-size: 0.9rem;'><b>Admin<br> Mode</b></th>");
				str.append("<th  style='width:8%;text-align: center;color: black; font-weight: 400; font-size: 0.9rem;'><b>Administer Type</b></th>");
				str.append("<th  style='width:8%;color: black; font-weight: 400; font-size: 0.9rem;'><b>Qty<br>Advised/<br>Issued</b></th>");
				str.append("<th  style='width:12%;color: black; font-weight: 400; font-size: 0.9rem;'><b>Batch</b></th>");
				str.append("<th  style='width:0%;color: black; font-weight: 400; font-size: 0.9rem;' hidden><b>Qty<br>Administered</b></th>");
				str.append("<th  style='width:12%;color: black; font-weight: 400; font-size: 0.9rem;' ><b>Dosage</b></th>");
				str.append("<th  style='width:10%;color: black; font-weight: 400; font-size: 0.9rem;'><b>Actions</b></th>");
				str.append("</tr>");
				str.append("</thead>");

				Integer i = 1, k = 0, totalQty = 0;

				while (ws.next()) {
					/*
					 * PKG_MMS_VIEW2-proc_hrgt_patient_inj_advice_dtl [ Mode - 1]
					 * 
					 * 1.Hidden Id [ Item_Id ^ Brand_Id] 
					 * 2.Brand Name 
					 * 3.Req Qty 
					 * 4.Item Type
					 * 5.Frequency Name 
					 * 6.Dept Name 
					 * 7.Dosage Name 
					 * 8.Dept_code ^ Episode Code 
					 * 9.Stock Combo { BrandId ^ Batch No ^ In Hand Qty ^ Sale Price ^ Exp Date }
					 * 10.Advice By 
					 * 11.Advice Date 
					 * 12.Shivendra ( 25 Yr/Male ) <br> [ 939112400014286 ] @
					 * 8778755457" 
					 * 13. Issue Qty 
					 * 14. BATCH_COUNT 
					 * 15. INJ_STATUS CASE WHEN
					 * TRUNC(ENTRY_DATE) < TRUNC(SYSDATE) AND BATCH_COUNT > 0 THEN ''PENDING'' WHEN
					 * TRUNC(ENTRY_DATE) = TRUNC(SYSDATE) AND BATCH_COUNT > 0 THEN ''ADMINISTER''
					 * WHEN TRUNC(ENTRY_DATE) = TRUNC(SYSDATE) AND BATCH_COUNT = 0 THEN ''NA'' WHEN
					 * TRUNC(ENTRY_DATE) < TRUNC(SYSDATE) AND BATCH_COUNT = 0 THEN ''NA'' WHEN
					 * ISSUE_QTY = REQ_QTY THEN ''ADMINISTERED'' END AS INJ_STATUS 16.CR_NO
					 */

	
					str.append("<tr>");
					
					str.append("<input type='hidden' name='itemParamValue' id='itemParamValue" + i + "' value='"
							+ ws.getString(1) + "^" + ws.getString(16) + "'>");
					str.append("<input type='hidden' name='remainQty'      id='remainQty" + i + "'      value='"
							+ (Integer.parseInt(ws.getString(3)) - Integer.parseInt(ws.getString(13))) + "'>");
					str.append("<input type='hidden' name='patientNameAge' id='patientNameAge" + i + "' value='"
							+ ws.getString(12).split("\\<br>")[0] + "'>");
					str.append("<input type='hidden' name='administerType' id='administerType" + i + "' value='10'>");
					str.append("<input type='hidden' name='batchCount' id='batchCount" + i + "' value='"+ws.getString(14)+"'>");

					str.append(
							"<td id='patName"+i+"'  style='width:15%;font-weight: 400; font-size: 0.8rem; color: blue;text-align:left;'>");
					str.append(ws.getString(12).replace("@", "<br> Mob: "));
					str.append("</td>");
					str.append(
							"<td id='injName"+i+"'  style='width:20%;font-weight: 400; font-size: 0.8rem; color:black;text-align:left;'>");
					str.append(ws.getString(2));
					str.append("</td>");

					str.append(
							"<td   style='width:10%;font-weight: 400; font-size: 0.8rem; color: black;text-align:left;'>");
					str.append(ws.getString(11) + "<br>" + ws.getString(6) + "<br>" + ws.getString(10));
					str.append("</td>");
					str.append("<td   style='width:5%;font-weight: 400; font-size: 0.8rem; color: black;text-align:center;'>");
					if(!ws.getString(15).equals("ADMINISTERED")) {
						
						//str.append(ws.getString(4));
						str.append("<select class='form-control form-control-sm' name='administerMode' id='administerMode"+i+"'  >");
						str.append(strAdmnModeCombo);
						str.append("</select>");
						
					}
					str.append("</td>");
					
					str.append("<td style='width:8%;font-weight: 400; font-size: 0.8rem; color: black;text-align:center;'>");
					if(!ws.getString(15).equals("ADMINISTERED")) {
						str.append("<div style='display: flex;justify-content: center;'><input type='radio' value='10' name='admType"+ i +"' onclick='changeAdmType(this," + i + ")'  checked> <div style='font-weight: 400; font-size: 0.8rem; color: black;'> Whole</div></div>");
						str.append("<br><div style='display: flex;justify-content: center;'><input type='radio' value='11' name='admType"+ i +"' onclick='changeAdmType(this," + i + ")'  > <div style='font-weight: 400; font-size: 0.8rem; color: black;'> Partial</div></div>");
						
					}
					str.append("</td>");
					
					str.append("<td   style='width:8%;font-weight: 400; font-size: 0.8rem; color: black;text-align:center;'>");
					if(!ws.getString(15).equals("ADMINISTERED")) {
						str.append(ws.getString(3) + " / " + ws.getString(13));
					}
					str.append("</td>");

					//batch combo
					String cmbValue = ws.getString(9).split("value='")[1].split("'")[0];
					str.append("<td   style='width:12%;font-weight: 400; font-size: 0.8rem; color: black;text-align:center;'>");
					if(!ws.getString(15).equals("ADMINISTERED") && !ws.getString(15).equals("NA")) {
						str.append("<select name='strMultiRowBatch' id='strMultiRowBatch" + i
								+ "' class='form-control form-control-sm' onchange='getBrandDtls(this,\"" + i + "\");'>");
						str.append(ws.getString(9));
						str.append("</select>");
						
						
						if(ws.getString(14).equals("1") && cmbValue.split("\\^").length>1) {
							str.append("<table id='strMultiRowBatchTableForSingleCmb" + i + "' >");
							str.append("<tr>");
							str.append("<td style='font-weight: 600;  color: #767272;text-align:center; padding:8px 0px;'>Qty :- </td>");
							str.append("<td style='font-weight: 400; font-size: 0.8rem; color: #da3737;text-align:center; padding:8px 6px;'>"+cmbValue.split("\\^")[2]+"</td>");
							str.append("</tr>");
							str.append("</table>");
							str.append("<input type='hidden' name='selectedBatchDetails'      id='selectedBatchDetails" + i
									+ "'      value='"+cmbValue+"'>");
						}
						else {
							str.append("<table id='strMultiRowBatchTable" + i + "' style='display:none'>");
							str.append("<tr>");
							str.append("<td style='font-weight: 600;  color: #767272;text-align:center; padding:8px 0px;'>Qty :- </td>");
							str.append("<td id='strMultiRowBatchAvlQtyVal" + i
									+ "' style='font-weight: 400; font-size: 0.8rem; color: #da3737;text-align:center; padding:8px 6px;'></td>");
							str.append("</tr>");
							str.append("</table>");
							str.append("<input type='hidden' name='selectedBatchDetails'      id='selectedBatchDetails" + i
									+ "'      value=''>");
						}
						
					}

					str.append("</td>");
					
					//batch combo end

					if (ws.getString(15).equals("ADMINISTERED")) {
						str.append("<td hidden id='td4" + i
								+ "' style='font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;' >"
								+ "<input type='text' autocomplete='off' maxlength='8' onkeypress='return validateData(event,5);' onkeyup='return QtyValidation("
								+ i + ");' name='strIssueQty' id='strIssueQty" + i + "' class='form-control' value='1' >");
						str.append("</td>");
					} else {
						str.append("<td hidden id='td4" + i
								+ "' style='font-weight: 400; font-size: 0.8rem; color: #495057;text-align:center;' >"
								+ "<input type='text' autocomplete='off' maxlength='8' onkeypress='return validateData(event,5);' onkeyup='return QtyValidation("
								+ i + ");' name='strIssueQty' id='strIssueQty" + i + "' class='form-control' value='1'  >");
						str.append("</td>");
					}
					
					
					str.append("<td   style='width:5%;font-weight: 500; font-size: 0.8rem; color: black;text-align:center;' >");
					if(!ws.getString(15).equals("ADMINISTERED") || ws.getString(15).equals("NA")) {
						if(ws.getString(14).equals("1") && cmbValue.split("\\^").length>1) {
							//String cmbValue = ws.getString(9).split("value='")[1].split("'")[0];
							
							if(ws.getString(15).equals("ADMINISTER")) {
								str.append("<div id='strDoses" + i + "' style='padding: 6px 0px;' >"+ws.getString(7)+"</div>");
								str.append("<div id='batchExpDtlId" + i + "' style='color:red;'>"
										+ cmbValue.split("\\^")[1] +"<br>["+cmbValue.split("\\^")[4]+"]"
										+ "</div>");
							}
							
							
						}
						else {
							if(ws.getString(15).equals("ADMINISTER") || ws.getString(15).equals("NA")) {
								str.append("<div id='strDoses" + i + "'style='padding: 6px 0px;'>"+ws.getString(7)+"</div><div id='batchExpDtlId" + i + "' style='color:red;'></div>");
							}
							//str.append("<input class='form-control' type='text' autocomplete='off' id='strDoses"+i+"' style='display:none'><div id='batchExpDtlId" + i + "' style='color:red;'></div>");
						}
					}
					str.append("</td>");
					

					str.append("<td   style='width:10%;font-weight: 400; font-size: 0.8rem; color: black;text-align:center;'>");
					/*
					 * CASE WHEN TRUNC(ENTRY_DATE) < TRUNC(SYSDATE) AND BATCH_COUNT > 0 THEN
					 * ''PENDING'' WHEN TRUNC(ENTRY_DATE) = TRUNC(SYSDATE) AND BATCH_COUNT > 0 THEN
					 * ''ADMINISTER'' WHEN TRUNC(ENTRY_DATE) = TRUNC(SYSDATE) AND BATCH_COUNT = 0
					 * THEN ''NA'' WHEN TRUNC(ENTRY_DATE) < TRUNC(SYSDATE) AND BATCH_COUNT = 0 THEN
					 * ''NA'' WHEN ISSUE_QTY = REQ_QTY THEN ''ADMINISTERED'' END AS INJ_STATUS
					 */
					if (ws.getString(15).equals("PENDING")) {
						//pending button
						/*
						 * str.append(
						 * "<img height='32px' width='32px' src='../../hisglobal/images/letter-p-Indigo.png' onClick='handlePendingBtn("
						 * + i + ");' style='cursor: pointer;' title='Panding'>");
						 */
						
						//pending text lable 
						/*
						 * str.append(
						 * "<div style='cursor: pointer;cursor: pointer; color: #ff4545; display: flex; padding: 4px; justify-content: center; border-radius: 4px; font-size: 14px; font-weight: bold; box-shadow: 1px 1px #888;' title='Pending'>PENDING</div>"
						 * );
						 */
					}
					if (ws.getString(15).equals("NA")) {
						/*
						 * str.append(
						 * "<img height='32px' width='32px' src='../../hisglobal/images/letter-na.png' style='cursor: pointer;' title='Not Applicable'>"
						 * );
						 */
						str.append("<div style=' color: #d15959; display: flex; padding: 4px; "
								+ "justify-content: center; border-radius: 4px; font-size: 14px; font-weight: bold; "
								+ " title='Not Applicable'>N/A</div>");
						
					}
					if (ws.getString(15).equals("ADMINISTER")) {
						str.append(
								"<img height='32px' width='32px' src='../../hisglobal/images/letter-p.png' onClick='handlePendingBtn("
										+ i + ");' style='cursor: pointer;' title='PENDING'>");
						
						if(Double.parseDouble(ws.getString(13))>0) {
							 str.append(
									  "<img height='32px' width='32px' src='../../hisglobal/images/letter-a.png' onClick='handleAdministratedBtn("
									  + i + ");' style='cursor: pointer;' title='ADMINISTERED'>");
						}
					}
					if (ws.getString(15).equals("ADMINISTERED")) {
						
						  str.append(
						  "<img height='32px' width='32px' src='../../hisglobal/images/letter-a.png' onClick='handleAdministratedBtn("
						  + i + ");' style='cursor: pointer;' title='ADMINISTERED'>");
						 
						/*
						str.append("<div style='cursor: pointer; color: #4263c5; display: flex; padding: 4px; "
								+ "justify-content: center; border-radius: 4px; font-size: 14px; font-weight: bold; "
								+ "text-decoration: underline' onClick='handleAdministratedBtn("+i+");' title='ADMINISTERED'>ADMINISTERED</div>");
						*/
					}
					str.append("</td>");
					str.append("</tr>");

					i++;
				}

			} else {

				str.append(
						"<tr><td align='center'  class='multiControl' align='center'><font color='red' ><b>No record Found In Treatment Details</b></font></td></tr></table>");
				str.append("</table>");

			}
			str.append("</table>");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("PatientDtlHLP-->patientInjectioAdministrationDtl-->" + e.getMessage());
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}
		return str.toString();
	}

	public static String patientInjectioAdministratedDtl(InjAdministrationTransVO vo, String strItemCategoryNo,
			String strHospitalCode, WebRowSet ws, String strRaisingStoreId, String strBudgetFlg, String strIssueStoreID)
			throws Exception {
		StringBuffer str = new StringBuffer("");
		str.append("");
		String prevDrugName = "";
		HttpServletRequest request=null;

		try {
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(vo.getStrHospitalCode());
			Map require =new HashMap();
		    require.put("REQUEST", request);
		    require.put("FORMAT", "html");
		    require.put("HOSPCODE", vo.getStrHospitalCode());

			String strHeader=hisUtil.getHospitalHeaderMain(require); 
			System.out.println("------strHeader.toString()-----"+strHeader.toString());
			
			
			
			String issueTo = "";
			String crNo = "";
			String brandName = "";
			if(ws.next()){
				issueTo=ws.getString(2);
				crNo=ws.getString(11);
				brandName=ws.getString(4);
				ws.previous();
			}
			str.append("<table align='center' border='0' cellspacing='0' cellpadding='0' height='10'> ");
			str.append(
					"<tr><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printData12(1);' /></div>");
			str.append("</tr>");
			str.append(strHeader);
			str.append("</table> ");
			if (ws != null && ws.size() > 0) {
//						System.out.println("ws size---->"+ws.size());
				str.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ "<tr> "
						+ " <td colspan='6'align='center' style='font-size:15px'><b><u>Injection Administration Details</u></b></td>");
				str.append("</tr>");
				str.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Store Name ::<b>"
						+ vo.getStrStoreName() + "</b></font></td><td align='center' colspan='2'></td></tr>");
				str.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Date ::<b>"
						+ vo.getStrCurrentDate() + "</b></font></td><td align='center' colspan='2'></td></tr>");
				str.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Issue To ::<b>"
						+ issueTo +" [ " + crNo + " ] </b></font></td><td align='center' colspan='2'></td></tr>");
				str.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Brand Name ::<b>"
						+ brandName +"</b></font></td><td align='center' colspan='2'></td></tr>");
				str.append("</table>");
				str.append(
						"<table class='table' width='100%' align='center' cellspacing='1px' cellpadding='1px' border='1' style='margin-top: 24px;'>");

				str.append("<thead>");
				str.append("<tr>");
				str.append("<th  style='width:5%;text-align: center;color: black;'><b>Sr No</b></th>");
				str.append("<th  style='width:10%;text-align: center;color: black;'><b>Issue Date</b></th>");
				//str.append("<th  style='width:25%;text-align: center;color: black;'><b>Brand Name</b></th>");
				str.append("<th  style='width:20%;text-align: center;color: black;'><b>Batch No.</b></th>");
				str.append("<th  style='width:10%;text-align: center;color: black;'><b>Admn Mode</b></th>");
				str.append("<th  style='width:10%;text-align: center;color: black;'><b>Admn Type</b></th>");
				str.append("<th  style='width:10%;text-align: center;color: black;'><b>Expiry Date</b></th>");
				str.append("<th  style='width:15%;text-align: center;color: black;'><b>Doses</b></th>");
				str.append("<th  style='width:20%;text-align: center;color: black;'><b>Issue By</b></th>");
				str.append("</tr>");
				str.append("</thead>");

				Integer i = 1, k = 0, totalQty = 0;

				while (ws.next()) {
					/*
					 * pkg_mms_view2.proc_hrgt_patient_inj_advice_dtl [ Mode - 2]
					 * 
					 * 
					 * 1.ISSUE_DATE 
					 * 2.ISSUE_TO 
					 * 3.STORE_NAME 
					 * 4.BRAND_ITEM_NAME 
					 * 5.BATCH_NO
					 * 6.EXPIRY_DATE 
					 * 7.SEAT_ID
					 * 8.ADMINSTER_MODE
					 * 9.ADMINSTER_TYPE
					 * 10.Doses
					 * 11.CR_NO
					 */

					str.append("<tr>");

					str.append(
							"<td   style='width:5%;font-weight: 400; font-size: 0.8rem; text-align:center;color:black;'>");
					str.append(i);
					str.append("</td>");

					str.append(
							"<td   style='width:10%;font-weight: 400; font-size: 0.8rem; text-align:center;color:black;'>");
					str.append(ws.getString(1));
					str.append("</td>");
					//str.append(
					//		"<td   style='width:25%;font-weight: 400; font-size: 0.8rem; color:black;text-align:center;'>");
					//str.append(ws.getString(4));
					//str.append("</td>");

					str.append(
							"<td   style='width:20%;font-weight: 400; font-size: 0.8rem; color: black;text-align:center;'>");
					str.append(ws.getString(5));
					str.append("</td>");
					
					String admnType = "";
					if(ws.getString(9).equals("10")) {
						admnType = "Whole";
					}
					else if(ws.getString(9).equals("11")) {
						admnType = "Partial";
					}
					
					str.append(
							"<td   style='width:10%;font-weight: 400; font-size: 0.8rem; color: black;text-align:center;'>");
					str.append(ws.getString(8));
					//str.append(" /<br>");
					//str.append(admnType);
					str.append("</td>");
					
				
					
					  str.append("<td   style='width:10%;font-weight: 400; font-size: 0.8rem; color: black;text-align:center;'>"); 
					  str.append(admnType); 
					  str.append("</td>");
					
					
					str.append(
							"<td   style='width:10%;font-weight: 400; font-size: 0.8rem; color: black;text-align:center;'>");
					str.append(ws.getString(6));
					str.append("</td>");
					
					str.append(
							"<td   style='width:15%;font-weight: 400; font-size: 0.8rem; color: black;text-align:center;'>");
					str.append(ws.getString(10));
					str.append("</td>");
					
					str.append(
							"<td   style='width:20%;font-weight: 400; font-size: 0.8rem; color: black;text-align:center;'>");
					str.append(ws.getString(7));
					str.append("</td>");

					str.append("</tr>");

					i++;
				}

			} else {

				str.append("<table class='table' width='100%' align='center'><tr><td align='center'><font color='red'><b>No record Found In Treatment Details</b></font></td></tr>");
			}
			str.append("</table>");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("PatientDtlHLP-->patientInjectioAdministratedDtl-->" + e.getMessage());
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}
		return str.toString();
	}

}
