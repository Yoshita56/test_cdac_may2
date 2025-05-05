package mms.transactions.controller.hlp;

import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.transactions.dao.IndentApprovalDeskDAO;
import mms.transactions.vo.IndentApprovalDeskVO;

public class IndentApprovalDeskBSHLP {
	private static final String strColor = "red";
	private static final String defaultColor = "blue";

	/**
	 * This method is used to Get Item details for Agenda Request
	 * 
	 * @param vo
	 * @return String
	 */
	public static String getAgendaItemDetails(IndentApprovalDeskVO vo) {
		StringBuffer sb = new StringBuffer("");
		String strHiddenValue = "";
		String strInsertHiddenValue = "";
		String strAjaxHiddenValue = "";
		String unitCombo = "";
		String comboVal = "0";
		HisUtil util = new HisUtil("MMS", "IndentApprovalDeskHLP");
		WebRowSet ws1 = vo.getStrItemDetailsWs();
		int i = 0;
		try {
			sb.append("<table class='TABLEWIDTH' align='center' bgcolor='black'  border='0' cellspacing ='1px'>");
			sb.append("<tr>");
			sb.append("<td width='20%' class='multiLabel'>Item Name</td>");
			sb.append("<td width='15%' class='multiLabel'>Avl Qty(Rasing Store)</td>");
			sb.append("<td width='15%' class='multiLabel'>Avl Qty(Receving Store)</td>");
			sb.append("<td width='15%' class='multiLabel'>Req Qty</td>");
			sb.append("<td width='15%' class='multiLabel'><font size='2' color='red'>*</font>Approved Qty</td>");
			sb.append("<td width='15%' class='multiLabel'><font size='2' color='red'>*</font>Unit Name</td>");
			sb.append("<td width='5%' class='multiLabel'>#</td>");
			sb.append("</tr>");

			if (ws1 != null) {
				String strItemName = null;
				String strAvlQty = "0";
				String strAvlQtyReceving = null;
				String strReqQty = null;
				// String strSancQty = null;
				String strRate = null;
				String strLstPoNo = null;
				String strLstPODate = null;
				String strLstRecQty = null;
				String strLstRecDate = null;
				String strLstSupplBy = null;
				String strSanctionQty = null;
				String strItemId = null;
				String strItemBrandId = null;
				String strProcSancQty = null;
				String strProcSancQtyUnitId = null;
				String strProcIndentQty = null;
				String strProcIndentQtyUnit = null;
				String strBatchNo = "0";
				String strItemSlNo = "0";
				String strStockStatusCode = "0";
				String strRasing = "0";
				String strReceving = "1";
				while (ws1.next()) {

					strLstPoNo = ws1.getString(1);
					strLstPODate = ws1.getString(2);
					strLstRecQty = ws1.getString(3);
					strLstRecDate = ws1.getString(4);
					strLstSupplBy = ws1.getString(5);
					strItemName = ws1.getString(6);
					strAvlQty = ws1.getString(7);
					strReqQty = ws1.getString(8);
					// strSancQty = ws1.getString(9);
					strRate = ws1.getString(10);
					strItemId = ws1.getString(11);
					strItemBrandId = ws1.getString(12);
					strProcIndentQty = ws1.getString(13);
					strProcIndentQtyUnit = ws1.getString(14);
					strProcSancQty = ws1.getString(15);
					strProcSancQtyUnitId = ws1.getString(16);

					strAjaxHiddenValue = strItemId + "@" + vo.getStrStoreId()
							+ "@" + strItemBrandId + "@" + vo.getStrReqNo()
							+ "@" + strBatchNo + "@" + strItemSlNo + "@"
							+ strStockStatusCode + "@" + vo.getStrToStoreId()
							+ "@" + vo.getStrReqTypeId();
					strInsertHiddenValue = strItemId + "@" + strItemBrandId
							+ "@" + strProcIndentQty + "@"
							+ strProcIndentQtyUnit + "@" + strProcSancQty + "@"
							+ strProcSancQtyUnitId;

					IndentApprovalDeskDAO
							.getUnitCombo(vo, strProcIndentQtyUnit);

					IndentApprovalDeskDAO.getStockDtls(vo, strItemId,
							strItemBrandId);

					strAvlQtyReceving = vo.getStrStockDtl();
					if (ws1.getString(17) == null
							|| ws1.getString(17).equals("")) {
						comboVal = "0";
					} else {

						comboVal = ws1.getString(17);
					}

					if (vo.getStrUnitComboWs() != null
							&& vo.getStrUnitComboWs().size() > 0) {
						unitCombo = util.getOptionValue(vo.getStrUnitComboWs(),
								comboVal, "0^Select Unit", false);
					} else {
						unitCombo = "<option value='0'>Select Unit</option>";
					}
					strHiddenValue = strLstPoNo + "^" + strLstPODate + "^"
							+ strLstRecQty + "^" + strLstRecDate + "^"
							+ strLstSupplBy;

					if (strItemName == null || strItemName.equals(""))
						strItemName = "-----";
					if (strAvlQty == null || strAvlQty.equals(""))
						strAvlQty = "-----";
					if (strReqQty == null || strReqQty.equals(""))
						strReqQty = "-----";
					if (strSanctionQty == null || strSanctionQty.equals(""))
						strSanctionQty = "0";
					if (strRate == null || strRate.equals(""))
						strRate = "-----";
					if (strBatchNo == null || strBatchNo.equals(""))
						strBatchNo = "-----";
					if (strAvlQtyReceving == null
							|| strAvlQtyReceving.equals(""))
						strAvlQtyReceving = "-----";

					sb.append("<input type='hidden' name ='strHiddenValue'  value='"
							+ strHiddenValue + "'>");
					sb.append("<input type='hidden' name ='strInsertHiddenValue'  value='"
							+ strInsertHiddenValue + "'>");
					sb.append("<input type='hidden' name ='strAvlQty'  value='"
							+ strAvlQty + "'>");
					sb.append("</table>");
					sb.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC'  border='0' cellspacing ='1px'>");
					sb.append("<tr>");

					sb.append("<td width='20%' class='multiControl'>");
					/*sb.append("<a name='tarriff' value='' STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Item Details' onClick='callingPoPUp(this,"
							+ i
							+ ",\""
							+ strHiddenValue
							+ "\",\""
							+ vo.getStrReqTypeId()
							+ "\");'>"
							+ strItemName
							+ "</a>");*/
					sb.append(strItemName);
					sb.append("</td>");
					sb.append("<td width='15%' class='multiControl'>");
					sb.append("<a name='tarriff' value='' STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Quantity Details' onClick='callingAjaxPoPUp(this,"
							+ i
							+ ",\""
							+ strRasing
							+ "\",\""
							+ strAjaxHiddenValue
							+ "\");'>"
							+ strAvlQty
							+ "</a>");

					sb.append("</td>");
					sb.append("<td width='15%' class='multiControl'>");
					sb.append("<a name='tarriff' value='' STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Quantity Details' onClick='callingAjaxPoPUp(this,"
							+ i
							+ ",\""
							+ strReceving
							+ "\",\""
							+ strAjaxHiddenValue
							+ "\");'>"
							+ strAvlQtyReceving
							+ "</a>");

					sb.append("</td>");
					sb.append("<td width='15%' class='multiControl'>");
					sb.append(strReqQty);
					sb.append("<input type='hidden' name ='strReqQty'  value='"
							+ strReqQty + "'>");
					sb.append("</td>");
					sb.append("<td width='15%' class='multiControl'>");
					sb.append("<input type='text'class='txtFldNormal' name='strInsSancQty' value='"
							+ strProcSancQty
							+ "' onkeypress='return validateData(event,7);'>");
					sb.append("</td>");
					sb.append("<td width='15%' class='multiControl'>");
					sb.append("<select name='strInsUnitCombo'>'" + unitCombo
							+ "'</select>");
					sb.append("</td>");
					sb.append("<td class='multiControl' width='5%'><a value='' style='cursor:pointer;'  onClick='openDivItem(this,"
							+ i
							+ ");' title='Click here to Enter Remarks' style='cursor:pointer;'><font color='blue'>#</font></a>");
					sb.append("<div id='remarksId" + i
							+ "' class='popup' style='display:none'>");
					sb.append("<table width='400' align='center'>");
					sb.append("<tr class='HEADER'><th align='left'>Remarks For "
							+ strItemName + "</th>");
					sb.append("<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'");
					sb.append(" onClick='closeDivItem("
							+ i
							+ ");' title='Click Here To Close Popup'></th></tr>");
					sb.append("</table>");
					sb.append("<table width='400' align='center' cellspacing='1px' cellpadding='1px'>");
					sb.append("<tr><td class='LABEL' width='50%'><div id='remarksLabelId"
							+ i + "'>Remarks</div></td>");
					sb.append("<td class='CONTROL' width='50%'><textarea name='strItemRemarks'></textarea></td>");
					sb.append("</tr>");
					sb.append("<tr class='FOOTER'><td colspan='2'></td></tr>");
					sb.append("<tr ><td colspan='2' class='CONTROL'><div align='center'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/btn-ok.png'");
					sb.append(" onClick='closeDivItem("
							+ i
							+ ");' title='Click Here To Save Remarks For Item'></div></td></tr>");
					sb.append("</table>");
					sb.append("</div></td>");
					sb.append("</tr>");
					i++;
				}

				sb.append("</table>");

			} else {
				sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
				sb.append("<tr>");
				sb.append("<td colspan='6'  CLASS='multiControl' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED REQUEST TYPE</div>"
						+ "</TD>");

				sb.append("</tr>");
				sb.append("</table>");

			}
			vo.setStrMultiRow(i + "");
		} catch (Exception e) {
			vo.setStrMsgString("IndentApprovalDeskHLP.getAgendaItemDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}

	/**
	 * This method is used to Get Item details for Issue To Third Party Request
	 * 
	 * @param vo
	 * @return String
	 */
	public static String getIssueToThirdPartyItemDetails(IndentApprovalDeskVO vo) {
		StringBuffer sb = new StringBuffer("");
		String strHiddenValue = "";
		String strInsertHiddenValue = "";
		String strAjaxHiddenValue = "";
		String unitCombo = "";
		// String strValue = "";
		String comboVal = "0";

		HisUtil util = new HisUtil("MMS", "IndentApprovalDeskHLP");
		WebRowSet ws1 = vo.getStrItemDetailsWs();
		int i = 0;
		try {
			sb.append("<table class='TABLEWIDTH' align='center' bgcolor='black' border='0' cellspacing ='1px'>");
			sb.append("<tr>");
			sb.append("<td width='20%' class='multiLabel'>Item Name</td>");
			sb.append("<td width='15%' class='multiLabel'>Batch No</td>");
			//sb.append("<td width='15%' class='multiLabel'>Avl Qty</td>");
			sb.append("<td width='15%' class='multiLabel'>Req Qty</td>");
			sb.append("<td width='15%' class='multiLabel'><font size='2' color='red'>*</font>Approved Qty</td>");
			sb.append("<td width='15%' class='multiLabel'><font size='2' color='red'>*</font>Unit Name</td>");
			sb.append("<td width='5%' class='multiLabel'>#</td>");
			sb.append("</tr>");
			sb.append("</table>");
			if (ws1 != null) {
				String strItemName = null;
				String strAvlQty = "0";
				String strInHandQty = "0";
				String strReqQty = null;
				// String strSancQty = null;
				String strExpDate = null;
				String strRate = null;

				String strRasing = "0";
				// String strReceving = "1";
				String strItemId = null;
				String strItemBrandId = null;
				String strProcSancQty = null;
				String strProcSancQtyUnitId = null;
				String strProcIndentQty = null;
				String strProcIndentQtyUnit = null;

				String strBatchNo = "0";
				String strItemSlNo = "0";
				String strStockStatusCode = "0";
				// System.out.println("ws1:::"+ws1.size());
				while (ws1.next()) {

					strExpDate = ws1.getString(1);
					strBatchNo = ws1.getString(2);
					strItemName = ws1.getString(3);

					strAvlQty = ws1.getString(4);
					strReqQty = ws1.getString(5);
					// strSancQty = ws1.getString(6);
					strRate = ws1.getString(7);

					strItemId = ws1.getString(8);
					strItemBrandId = ws1.getString(9);

					strProcIndentQty = ws1.getString(10);
					strProcIndentQtyUnit = ws1.getString(11);

					strProcSancQty = ws1.getString(12);
					strProcSancQtyUnitId = ws1.getString(13);

					strItemSlNo = ws1.getString(15);
					strStockStatusCode = ws1.getString(16);
					strBatchNo = ws1.getString(17);
					strInHandQty = ws1.getString(18);

					strAjaxHiddenValue = strItemId + "@" + vo.getStrStoreId()
							+ "@" + strItemBrandId + "@" + vo.getStrReqNo()
							+ "@" + strBatchNo + "@" + strItemSlNo + "@"
							+ strStockStatusCode + "@" + vo.getStrToStoreId()
							+ "@" + vo.getStrReqTypeId();
					strInsertHiddenValue = strItemId + "@" + strItemBrandId
							+ "@" + strProcIndentQty + "@"
							+ strProcIndentQtyUnit + "@" + strProcSancQty + "@"
							+ strProcSancQtyUnitId + "@" + ws1.getString(15)
							+ "@" + ws1.getString(16) + "@" + ws1.getString(17);

					IndentApprovalDeskDAO
							.getUnitCombo(vo, strProcIndentQtyUnit);

					if (ws1.getString(14) == null
							|| ws1.getString(14).equals("")) {
						comboVal = "0";
					} else {

						comboVal = ws1.getString(14);
					}

					if (vo.getStrUnitComboWs() != null
							&& vo.getStrUnitComboWs().size() > 0) {
						unitCombo = util.getOptionValue(vo.getStrUnitComboWs(),
								comboVal, "0^Select Unit", false);
					} else {
						unitCombo = "<option value='0'>Select Unit</option>";
					}

					if (strItemName == null || strItemName.equals(""))
						strItemName = "-----";
					if (strAvlQty == null || strAvlQty.equals(""))
						strAvlQty = "-----";
					if (strReqQty == null || strReqQty.equals(""))
						strReqQty = "-----";
					if (strProcSancQty == null || strProcSancQty.equals(""))
						strProcSancQty = "0";
					if (strRate == null || strRate.equals(""))
						strRate = "-----";
					if (strBatchNo == null || strBatchNo.equals(""))
						strBatchNo = "-----";

					strHiddenValue = strRate + "^" + strExpDate;
					sb.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC'  border='0' cellspacing ='1px'>");
					sb.append("<input type='hidden' name ='strItemSlNo'  value='"
							+ strItemSlNo + "'>");
					sb.append("<input type='hidden' name ='strStockStatusCode'  value='"
							+ strStockStatusCode + "'>");
					sb.append("<input type='hidden' name ='strBatchNo'  value='"
							+ strBatchNo + "'>");
					sb.append("<input type='hidden' name ='strInHandQty'  value='"
							+ strInHandQty + "'>");

					sb.append("<input type='hidden' name ='strInsertHiddenValue'  value='"
							+ strInsertHiddenValue + "'>");
					sb.append("<tr>");
					sb.append("<td width='20%' class='multiControl'>");
					/*/sb.append("<a name='tarriff' value='' STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Item Details' onClick='callingPoPUp(this,"
							+ i
							+ ",\""
							+ strHiddenValue
							+ "\",\""
							+ vo.getStrReqTypeId()
							+ "\");'>"
							+ strItemName
							+ "</a>");*/
					sb.append(strItemName);
					sb.append("</td>");
					sb.append("<td width='15%' class='multiControl'>");
					sb.append(strBatchNo);
					sb.append("</td>");

//					sb.append("<td width='15%' class='multiControl'>");
//					sb.append("<a name='tarriff' value='' STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Quantity Details' onClick='callingAjaxPoPUp(this,"
//							+ i
//							+ ",\""
//							+ strRasing
//							+ "\",\""
//							+ strAjaxHiddenValue
//							+ "\");'>"
//							+ strAvlQty
//							+ "</a>");
//
//					sb.append("</td>");

					sb.append("<td width='15%' class='multiControl'>");
					sb.append(strReqQty);
					sb.append("<input type='hidden' name ='strReqQty'  value='"
							+ strReqQty + "'>");
					sb.append("</td>");

					sb.append("<td width='15%' class='multiControl'>");
					sb.append("<input type='text'class='txtFldNormal' name='strInsSancQty' id='strInsSancQty"
							+ i
							+ "' value='"
							+ strProcSancQty
							+ "' onkeypress='return validateData(event,7);'  onkeyup='checkQtyWithoutUtility(\""
							+ i
							+ "\", \"strInsSancQty\", \"strInsUnitCombo\" , \""
							+ strInHandQty
							+ "\",\"Sanction Quantity should not be Greater than Available Quantity\");' >");
					sb.append("</td>");
					sb.append("<td width='15%' class='multiControl' onchange='checkQtyWithoutUtility(\""
							+ i
							+ "\", \"strInsSancQty\", \"strInsUnitCombo\" , \""
							+ strInHandQty
							+ "\",\" Sanction Quantity should not be Greater than Available Quantity\");' >");
					sb.append("<select name='strInsUnitCombo' id='strInsUnitCombo"
							+ i + "' >'" + unitCombo + "'</select>");
					sb.append("</td>");
					sb.append("<td class='multiControl' width='5%'><a value='' style='cursor:pointer;'  onClick='openDivItem(this,"
							+ i
							+ ");' title='Click here to Enter Remarks'><font color='blue'>#</font></a>");
					sb.append("<div id='remarksId" + i
							+ "' class='popup' style='display:none'>");
					sb.append("<table width='400' align='center'>");
					sb.append("<tr class='HEADER'><th align='left'>Remarks For "
							+ strItemName + "</th>");
					sb.append("<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'");
					sb.append(" onClick='closeDivItem("
							+ i
							+ ");' title='Click Here To Close Popup'></th></tr>");
					sb.append("</table>");
					sb.append("<table width='400' align='center' cellspacing='1px' cellpadding='1px'>");
					sb.append("<tr><td class='LABEL' width='50%'><div id='remarksLabelId"
							+ i + "'>Remarks</div></td>");
					sb.append("<td class='CONTROL' width='50%'><textarea name='strItemRemarks'></textarea></td>");
					sb.append("</tr>");
					sb.append("<tr class='FOOTER'><td colspan='2'></td></tr>");
					sb.append("<tr ><td colspan='2' class='CONTROL'><div align='center'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/btn-ok.png'");
					sb.append(" onClick='closeDivItem("
							+ i
							+ ");' title='Click Here To Save Remarks For Item'></div></td></tr>");
					sb.append("</table>");
					sb.append("</div></td>");
					sb.append("</tr>");

					i++;
				}

				sb.append("</table>");

			} else {
				sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
				sb.append("<tr>");
				sb.append("<td colspan='6'  CLASS='multiControl' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>"
						+ "</TD>");

				sb.append("</tr>");
				sb.append("</table>");

			}
			vo.setStrMultiRow(i + "");
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentApprovalDeskHLP.getIssueToThirdPartyItemDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}

		return sb.toString();

	}

	/**
	 * This method is used to Get Item details for
	 * LP(Staff),LP(Patient),LP(Department) and Inden for Contigenecy Request
	 * 
	 * @param vo
	 * @return String
	 */
	public static String getItemDetails1(IndentApprovalDeskVO vo) {
		StringBuffer sb = new StringBuffer("");
		String strHiddenValue = "";
		String strInsertHiddenValue = "";
		String strAjaxHiddenValue = "";
		String unitCombo = "";
		String comboVal = "0";
		HisUtil util = new HisUtil("MMS", "IndentApprovalDeskHLP");
		WebRowSet ws1 = vo.getStrItemDetailsWs();
		int i = 0, k = 0;
		try {
			if (ws1 != null) {
				String strCrNo = null;
				String strPatName = null;
				String strEmpID = null;
				String strEmpName = null;
				if (k == 0) {

					while (ws1.next()) {
						if (vo.getStrReqTypeId().equals("14")) {
							strCrNo = ws1.getString(10);
							strPatName = ws1.getString(11);
							strEmpID = ws1.getString(12);
							strEmpName = ws1.getString(13);
						}
						if (vo.getStrReqTypeId().equals("12")
								|| vo.getStrReqTypeId().equals("13")) {
							strCrNo = ws1.getString(8);
							strPatName = ws1.getString(9);
							strEmpID = ws1.getString(10);
							strEmpName = ws1.getString(11);

						}
						if (vo.getStrReqTypeId().equals("10")) {
							strCrNo = ws1.getString(10);
							strPatName = ws1.getString(11);
							strEmpID = ws1.getString(12);
							strEmpName = ws1.getString(13);
						}

						if (strCrNo == null || strCrNo.equals("")
								|| strCrNo.equals("0"))
							strCrNo = "-------";
						if (strPatName == null || strPatName.equals(""))
							strPatName = "-------";
						if (strEmpID == null || strEmpID.equals("")
								|| strEmpID.equals("0"))
							strEmpID = "-------";
						if (strEmpName == null || strEmpName.equals(""))
							strEmpName = "-------";
						if (vo.getStrReqTypeId().equals("13")) {
							if (k == 0) {
								sb.append("<table class='table' >");
								sb.append("<tr><td width='25%' align='right' style='font-weight:350 !important ;font-size: 16px !important;'>CR NO</td>");
								sb.append("<td width='25%' style='font-weight:350 !important ;font-size: 16px !important;'>");
								sb.append(strCrNo);
								sb.append("</td>");
								sb.append("<td width='25%' align='right' style='font-weight:350 !important ;font-size: 16px !important;'>Patient Name</td>");
								sb.append("<td width='25%' style='font-weight:350 !important ;font-size: 16px !important;'>");
								sb.append(strPatName);
								sb.append("</td></tr>");
							}
						} else {

							if (vo.getStrReqTypeId().equals("12")) {
								if (k == 0) {
									sb.append("<tr><td width='25%' align='right' style='font-weight:350 !important ;font-size: 16px !important;'>Emp ID</td>");
									sb.append("<td width='25%' style='font-weight:350 !important ;font-size: 16px !important;>");
									sb.append(strEmpID);
									sb.append("</td>");
									sb.append("<td width='25%' align='right' style='font-weight:350 !important ;font-size: 16px !important;'>Emp Name</td>");
									sb.append("<td width='25%' style='font-weight:350 !important ;font-size: 16px !important;>");
									sb.append(strEmpName);
									sb.append("</td></tr>");
								}
							}
						}
						k++;
					}
					sb.append("</table>");
				}
			}
			ws1.beforeFirst();

			sb.append("<table class='table'>");
			sb.append("<thead class='thead-dark'>");
			sb.append("<tr>");
			sb.append("<th width='30%' style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</th>");
			//sb.append("<td width='20%' class='multiLabel'>Avl Qty</td>");
			sb.append("<th width='20%'style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</th>");
			sb.append("<th width='25%'style='font-weight:350 !important ;font-size: 16px !important;'><font size='2' color='red'>*</font>Approved Qty</th>");
			sb.append("<th width='25%'style='font-weight:350 !important ;font-size: 16px !important;'><font size='2' color='red'>*</font>Unit Name</th>");
			if(!vo.getStrItemCatgNo().equals("10"))
				sb.append("<th width='25%'style='font-weight:350 !important ;font-size: 16px !important;'>Operation Details(In case of Special Item)</td>");
			sb.append("</tr>");
			sb.append("</thead>");

			if (ws1 != null) {
				String strItemName = null;
				String strAvlQty = "0";
				String strReqQty = null;
				// String strSancQty = null;
				String strRate = null;
				String strIssueQty = null;
				String strRetQty = null;
				String strLstRecevDate = null;
				String strLstRecevQty = null;
				String strLstRetQtyUnitId = null;
				// String strReqQtyUnit = null;
				String strSanctionQty = null;
				String strItemId = null;
				String strItemBrandId = null;
				String strProcSancQty = null;
				String strProcSancQtyUnitId = null;
				String strProcIndentQty = null;
				String strProcIndentQtyUnit = null;
				String strBatchNo = "0";
				String strItemSlNo = "0";
				String strStockStatusCode = "0";
				String strRasing = "0";
				// String strReceving = "1";

				while (ws1.next()) {
					if (vo.getStrReqTypeId().equals("10")) {
						strIssueQty = ws1.getString(1);
						strLstRecevQty = ws1.getString(2);
						strLstRecevDate = ws1.getString(3);
						strLstRetQtyUnitId = ws1.getString(4);
						strItemName = ws1.getString(5);
						strAvlQty = ws1.getString(6);
						strReqQty = ws1.getString(7);
						// strSancQty = ws1.getString(8);
						strRate = ws1.getString(9);
						// strReqQtyUnit = ws1.getString(10);
						strSanctionQty = ws1.getString(11);

						strItemId = ws1.getString(14);
						strItemBrandId = ws1.getString(15);

						strProcIndentQty = ws1.getString(16);
						strProcIndentQtyUnit = ws1.getString(17);

						strProcSancQty = ws1.getString(18);
						strProcSancQtyUnitId = ws1.getString(19);

						strAjaxHiddenValue = strItemId + "@"
								+ vo.getStrStoreId() + "@" + strItemBrandId
								+ "@" + vo.getStrReqNo() + "@" + strBatchNo
								+ "@" + strItemSlNo + "@" + strStockStatusCode
								+ "@" + vo.getStrToStoreId() + "@"
								+ vo.getStrReqTypeId();
						strInsertHiddenValue = strItemId + "@" + strItemBrandId
								+ "@" + strProcIndentQty + "@"
								+ strProcIndentQtyUnit + "@" + strProcSancQty
								+ "@" + strProcSancQtyUnitId;
						if (ws1.getString(20) == null
								|| ws1.getString(20).equals("")) {
							comboVal = "0";
						} else {
							comboVal = ws1.getString(20);
						}
						IndentApprovalDeskDAO.getUnitCombo(vo,
								strProcIndentQtyUnit);
						if (vo.getStrUnitComboWs() != null
								&& vo.getStrUnitComboWs().size() > 0) {
							unitCombo = util.getOptionValue(
									vo.getStrUnitComboWs(), comboVal,
									"", false);
						} else {
							unitCombo = "<option value='0'>Select Unit</option>";
						}

						strHiddenValue = strIssueQty + "^" + strLstRecevQty
								+ "^" + strLstRecevDate + "^"
								+ strLstRetQtyUnitId;
					}

					if (vo.getStrReqTypeId().equals("12")
							|| vo.getStrReqTypeId().equals("13")) {
						strIssueQty = ws1.getString(1);
						strRetQty = ws1.getString(2);
						strItemName = ws1.getString(3);
						strAvlQty = ws1.getString(4);
						strReqQty = ws1.getString(5);
						// strSancQty = ws1.getString(6);
						strRate = ws1.getString(7);

						// strReqQtyUnit = ws1.getString(8);
						// strSanctionQty = ws1.getString(9);

						strItemId = ws1.getString(12);
						strItemBrandId = ws1.getString(13);
						strProcIndentQty = ws1.getString(14);
						strProcIndentQtyUnit = ws1.getString(15);
						strProcSancQty = ws1.getString(16);
						strProcSancQtyUnitId = ws1.getString(17);

						strAjaxHiddenValue = strItemId + "@"
								+ vo.getStrStoreId() + "@" + strItemBrandId
								+ "@" + vo.getStrReqNo() + "@" + strBatchNo
								+ "@" + strItemSlNo + "@" + strStockStatusCode
								+ "@" + vo.getStrToStoreId() + "@"
								+ vo.getStrReqTypeId();
						strInsertHiddenValue = strItemId + "@" + strItemBrandId
								+ "@" + strProcIndentQty + "@"
								+ strProcIndentQtyUnit + "@" + strProcSancQty
								+ "@" + strProcSancQtyUnitId;

						IndentApprovalDeskDAO.getUnitCombo(vo,
								strProcIndentQtyUnit);

						if (ws1.getString(18) == null
								|| ws1.getString(18).equals("")) {
							comboVal = "0";
						} else {
							comboVal = ws1.getString(18);

						}

						if (vo.getStrUnitComboWs() != null
								&& vo.getStrUnitComboWs().size() > 0) {
							unitCombo = util.getOptionValue(
									vo.getStrUnitComboWs(), comboVal,
									"", false);
						} else {
							unitCombo = "<option value='0'>Select Unit</option>";
						}

						strHiddenValue = strIssueQty + "^" + strRetQty;

					}
					if (vo.getStrReqTypeId().equals("14")) {
						strIssueQty = ws1.getString(1);
						strLstRecevQty = ws1.getString(2);
						strLstRecevDate = ws1.getString(3);
						strLstRetQtyUnitId = ws1.getString(4);
						strItemName = ws1.getString(5);
						strAvlQty = ws1.getString(6);
						strReqQty = ws1.getString(7);
						// strSancQty = ws1.getString(8);
						strRate = ws1.getString(9);

						// strReqQtyUnit = ws1.getString(10);
						strSanctionQty = ws1.getString(11);

						strItemId = ws1.getString(14);
						strItemBrandId = ws1.getString(15);

						strProcIndentQty = ws1.getString(16);
						strProcIndentQtyUnit = ws1.getString(17);

						strProcSancQty = ws1.getString(18);
						strProcSancQtyUnitId = ws1.getString(19);

						strAjaxHiddenValue = strItemId + "@"
								+ vo.getStrStoreId() + "@" + strItemBrandId
								+ "@" + vo.getStrReqNo() + "@" + strBatchNo
								+ "@" + strItemSlNo + "@" + strStockStatusCode
								+ "@" + vo.getStrToStoreId() + "@"
								+ vo.getStrReqTypeId();
						strInsertHiddenValue = strItemId + "@" + strItemBrandId
								+ "@" + strProcIndentQty + "@"
								+ strProcIndentQtyUnit + "@" + strProcSancQty
								+ "@" + strProcSancQtyUnitId;

						IndentApprovalDeskDAO.getUnitCombo(vo,
								strProcIndentQtyUnit);

						if (ws1.getString(20) == null
								|| ws1.getString(20).equals("null")
								|| ws1.getString(20).equals("")) {
							comboVal = "0";

						} else {
							comboVal = ws1.getString(20);

						}

						if (vo.getStrUnitComboWs() != null
								&& vo.getStrUnitComboWs().size() > 0) {
							unitCombo = util.getOptionValue(
									vo.getStrUnitComboWs(), comboVal,
									"", false);
						} else {
							unitCombo = "<option value='0'>Select Unit</option>";
						}

						strHiddenValue = strIssueQty + "^" + strLstRecevQty
								+ "^" + strLstRecevDate + "^"
								+ strLstRetQtyUnitId;
					}

					if (strItemName == null || strItemName.equals(""))
						strItemName = "-----";
					if (strAvlQty == null || strAvlQty.equals(""))
						strAvlQty = "-----";
					if (strReqQty == null || strReqQty.equals(""))
						strReqQty = "-----";
					if (strSanctionQty == null || strSanctionQty.equals(""))
						strSanctionQty = "0";
					if (strRate == null || strRate.equals(""))
						strRate = "-----";
					sb.append("<tbody>");
					
					sb.append("<input type='hidden' name ='strAvlQty'  value='"
							+ strAvlQty + "'>");
					sb.append("<input type='hidden' name ='strAjaxHiddenValue'  value='"
							+ strAjaxHiddenValue + "'>");
					sb.append("<input type='hidden' name ='strHiddenValue'  value='"
							+ strHiddenValue + "'>");
					sb.append("<input type='hidden' name ='strInsertHiddenValue'  value='"
							+ strInsertHiddenValue + "'>");
					sb.append("<tr>");
					sb.append("<td width='30%' align='left' style='font-weight:350 !important ;font-size: 16px !important;'>");
					/*sb.append("<a name='tarriff' disabled='disabled'    value=''  STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Item Details'  onClick='callingPoPUp(this,"
							+ i
							+ ",\""
							+ strHiddenValue
							+ "\",\""
							+ vo.getStrReqTypeId()
							+ "\");'>"
							+ */
					sb.append(strItemName);
							/*+ "</a>");*/
					sb.append("</td>");
//					sb.append("<td width='20%' class='multiControl'>");
//					sb.append("<a name='tarriff' value='' STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Quantity Details' onClick='callingAjaxPoPUp(this,"
//							+ i
//							+ ",\""
//							+ strRasing
//							+ "\",\""
//							+ strAjaxHiddenValue
//							+ "\");'>"
//							+ strAvlQty
//							+ "</a>");
//					sb.append("</td>");
					sb.append("</td>");
					sb.append("<td width='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>");
					sb.append(strReqQty);
					sb.append("<input type='hidden' name ='strReqQty'  value='"
							+ strReqQty + "'>");
					sb.append("</td>");

					sb.append("<td width='25%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>");
					sb.append("<input type='text' class='form-control' name='strInsSancQty' value='"
							+ strReqQty.split(" ")[0]
							+ "' onkeypress='return validateData(event,7);'>");
					sb.append("</td>");
					sb.append("<td width='25%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>");
					sb.append("<select name='strInsUnitCombo'  class='form-control'>'" + unitCombo
							+ "'</select>");

					sb.append("</td>");
					if(!vo.getStrItemCatgNo().equals("10"))
					{
							sb.append("<td class='multiControl' width='25%'><a  value='' style='cursor:pointer;'  onClick='openDivItem(this,"
							+ i
							+ ");' title='Click here to Enter Operation Details' style='cursor:pointer;'><font color='blue'>#</font></a>");
							sb.append("<div id='remarksId" + i
									+ "' class='popup' style='display:none'>");
							sb.append("<table width='400' align='center'>");
							sb.append("<tr class='HEADER'><th align='left'>Operation Details "
									+ strItemName + "</th>");
							sb.append("<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'");
							sb.append(" onClick='closeDivItem("
									+ i
									+ ");' title='Click Here To Close Popup'></th></tr>");
							sb.append("</table>");
							sb.append("<table width='400' align='center' cellspacing='1px' cellpadding='1px'>");
							sb.append("<tr><td class='LABEL' width='50%'><div id='remarksLabelId"
									+ i + "'>Operation Name : </div></td>");
							sb.append("<td class='CONTROL' width='50%'><textarea name='strItemRemarks'></textarea></td>");
							sb.append("</tr>");
							sb.append("<tr class='FOOTER'><td colspan='2'></td></tr>");
							sb.append("<tr ><td colspan='2' class='CONTROL'><div align='center'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/btn-ok.png'");
							sb.append(" onClick='closeDivItem("
									+ i
									+ ");' title='Click Here To Save Operation'></div></td></tr>");
							sb.append("</table>");
							sb.append("</div></td>");
					}
					sb.append("</tr>");

					i++;
				}
				sb.append("</tbody>");

				sb.append("</table>");

			}/*
			 * else { sb.append(
			 * "<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>"
			 * ); sb.append("<tr>");
			 * sb.append("<td colspan='5'  CLASS='multiControl' >" +
			 * "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>"
			 * + "</TD>");
			 * 
			 * sb.append("</tr>"); sb.append("</table>");
			 * 
			 * }
			 */
			vo.setStrMultiRow(i + "");
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentApprovalDeskHLP.getItemDetails1() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}

	/**
	 * This method is used to Get Item details for Issue Indent Request
	 * 
	 * @param vo
	 * @return String
	 */

	public static String getIssueItemDetails(IndentApprovalDeskVO vo) 
	{
		StringBuffer sb = new StringBuffer("");
		String strHiddenValue = "";
		String strInsertHiddenValue = "";
		String strAjaxHiddenValue = "";
		String unitCombo = "";
		String comboVal = "0";
		HisUtil util = new HisUtil("MMS", "IndentApprovalDeskHLP");
		WebRowSet ws1 = vo.getStrItemDetailsWs();
		int i = 0;
		try 
		{
			sb.append("<table class='table'>");
			sb.append("<thead class='thead-dark'>");
			sb.append("<tr>");
			sb.append("<th width='25%' style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</th>");
			sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Avl Qty(Raising Store)</th>");
			sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'><font size='2' color='red'>*</font>Req Qty</th>");
			sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'><font size='2' color='red'>*</font>Approved Qty</th>");	
			sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'><font size='2' color='red'>*</font>Unit Name</th>");	
			sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>#</th>");
			sb.append("</tr>");
			sb.append("</thead>");
			/*
			sb.append("<table class='table' align='center' bgcolor='black' border='0' cellspacing ='1px'>");
			sb.append("<thead>");
			sb.append("<th>Item Name</th>");
			sb.append("<th>Avl Qty(Raising Store)</th>");
			//sb.append("<td width='13%' class='multiRPTLabel'>Avl Qty(Receiving Store)</td>");
			sb.append("<th>Req Qty</th>");
			sb.append("<th><font size='2' color='red'>*</font>Approved Qty</th>");
			sb.append("<th><font size='2' color='red'>*</font>Unit Name</th>");
			//sb.append("<td width='10%' class='multiLabel'>Issue from Reserv Stock</td>");
			sb.append("<th>#</th>");
			sb.append("</thead>");
			*/
			//sb.append("</table>");
			if (ws1 != null) 
			{
				String strItemName = null;
				String strAvlQty = "0";
				String strAvlQtyReceving = null;
				String strAvlQtyRaising = null;
				String strReqQty = null;
				String strSancQty = null;
				String strRate = null;
				String strIssueQty = null;
				String strReOrderLevel = null;
				String strLstIndentQty = null;
				String strLstIssueQty = null;
				String strReqQtyUnit = null;
				String strSanctionQty = null;

				String strBatchNo = "0";
				String strItemSlNo = "0";
				String strStockStatusCode = "0";
				// String strRasing = "0";
				String strReceving = "1";

				String strItemId = null;
				String strItemBrandId = null;
				String strReservedFlg = null;
				// String strProcSancQty = null;
				String strProcSancQtyUnitId = null;
				String strProcIndentQty = null;
				String strProcIndentQtyUnit = null;
				while (ws1.next()) 
				{
					if (vo.getStrReqTypeId().equals("17")) 
					{
						    strIssueQty = ws1.getString(1);
						strReOrderLevel = ws1.getString(2);
						strLstIndentQty = ws1.getString(3);
						 strLstIssueQty = ws1.getString(4);
						    strItemName = ws1.getString(5);
						      strAvlQty = ws1.getString(6);
						      strReqQty = ws1.getString(7);
						   strSancQty = ws1.getString(8);
						        strRate = ws1.getString(9);
						  strReqQtyUnit = ws1.getString(10);
						 strSanctionQty = ws1.getString(11); // Previous
						      strItemId = ws1.getString(12);
						 strItemBrandId = ws1.getString(13);
						 strReservedFlg = ws1.getString(14);
					  // strProcSancQty = strSanctionQty;
				   strProcSancQtyUnitId = ws1.getString(15); // Previous
					   strProcIndentQty = ws1.getString(16);
				   strProcIndentQtyUnit = strReqQtyUnit;

						strAjaxHiddenValue = strItemId + "@"
								+ vo.getStrStoreId() + "@" + strItemBrandId
								+ "@" + vo.getStrReqNo() + "@" + strBatchNo
								+ "@" + strItemSlNo + "@" + strStockStatusCode
								+ "@" + vo.getStrToStoreId() + "@"
								+ vo.getStrReqTypeId();
						strInsertHiddenValue = strItemId + "@" + strItemBrandId
								+ "@" + strProcIndentQty + "@"
								+ strProcIndentQtyUnit + "@" + strSanctionQty
								+ "@" + strProcSancQtyUnitId;

						IndentApprovalDeskDAO.getUnitCombo(vo, strReqQtyUnit);

						IndentApprovalDeskDAO.getStockDtls(vo, strItemId,strItemBrandId);
						
						IndentApprovalDeskDAO.getStockDtlsTwo(vo, strItemId,strItemBrandId);
						
						strAvlQtyRaising  = vo.getStrStockDtlTwo();   // Indent Raising  Store Quantity  Added By Amit Kr 17-Aug-2011
                      
						strAvlQtyReceving = vo.getStrStockDtl();      // Indent Receiving Store Quantity

						if (ws1.getString(17) == null || ws1.getString(17).equals(""))
						{
							comboVal = "0";
						} 
						else 
						{
							comboVal = ws1.getString(17);

						}

						if (vo.getStrUnitComboWs() != null	&& vo.getStrUnitComboWs().size() > 0)
						{
							unitCombo = util.getOptionValue(vo.getStrUnitComboWs(), comboVal,"", false);
						} 
						else 
						{
							unitCombo = "<option value='0'>Select Unit</option>";
						}
						strHiddenValue = strIssueQty + "^" + strReOrderLevel+ "^" + strLstIndentQty + "^" + strLstIssueQty;
					}

					if (strItemName == null || strItemName.equals(""))
						strItemName = "-----";
					if (strAvlQty == null || strAvlQty.equals(""))
						strAvlQty = "-----";
					if (strReqQty == null || strReqQty.equals(""))
						strReqQty = "-----";
					if (strSanctionQty == null || strSanctionQty.equals(""))
						strSanctionQty = "0";
					else
						strSanctionQty= strReqQty.substring(0,strReqQty.indexOf(" "));
					if (strRate == null || strRate.equals(""))
						strRate = "-----";
					if (strBatchNo == null || strBatchNo.equals(""))
						strBatchNo = "-----";
					if (strAvlQtyReceving == null|| strAvlQtyReceving.equals(""))
						strAvlQtyReceving = "-----";
				//	sb.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' border='0'  cellspacing ='1px'>");

					sb.append("<tbody>");					
					sb.append("<td width='25%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>");
					sb.append("<input type='hidden' name ='strAvlQty'  value='"	+ strAvlQtyRaising + "'>");
					sb.append("<input type='hidden' name ='strHiddenValue'  value='"
							+ strHiddenValue + "'>");
					sb.append("<input type='hidden' name ='strInsertHiddenValue'  value='"
							+ strInsertHiddenValue + "'>");
					/*sb.append("<a name='tarriff' value='' STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Item Details' onClick='callingPoPUp(this,"
							+ i
							+ ",\""
							+ strHiddenValue
							+ "\",\""
							+ vo.getStrReqTypeId()
							+ "\");'>"
							+ strItemName
							+ "</a>");*/
					sb.append(strItemName);
					sb.append("</td>");

					sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>");
					sb.append(strAvlQtyRaising);
					sb.append("</td>");

//					sb.append("<td width='13%' class='multiPOControl'>");
//					sb.append("<a name='tarriff' value='' STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Quantity Details' onClick='callingAjaxPoPUp(this,"
//							+ i
//							+ ",\""
//							+ strReceving
//							+ "\",\""
//							+ strAjaxHiddenValue
//							+ "\");'>"
//							+ strAvlQtyReceving
//							+ "</a>");
//
//					sb.append("</td>");
					sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>");
					sb.append(strReqQty);
					sb.append("<input type='hidden' name ='strAvlQtyReceving'  id ='strAvlQtyReceving"+i+"'  value='"+ strAvlQtyReceving + "'>");
					sb.append("<input type='hidden' name ='strReqQty'  value='"+ strReqQty + "'>");
					sb.append("</td>");

					sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>");
					sb.append("<input type='text'class='form-control form-control-sm' name='strInsSancQty'  id='strInsSancQty"+i+"' value='"+strSancQty.split(" ")[0] + "'    onkeyup='return calculateCostOnChange("+i+",this);' onkeypress='return validateData(event,7);'>");
					sb.append("</td>");
					sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>");
					sb.append("<select name='strInsUnitCombo'  class='form-control form-control-sm' id='strInsUnitCombo"+i+"' onchange='calUnitBaseCost("+i+",this);'>'" + unitCombo+ "'</select>");
					sb.append("</td>");

//					sb.append("<td width='10%' class='multiControl'>");
//					sb.append("<input type='checkbox' name='strIssueFrmReservStock' value='"+ strReservedFlg + "'>");
//					sb.append("</td>");
					
					sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'><a value='' style='cursor:pointer;'   onClick='openDivItem(this,"
							+ i
							+ ");' title='Click here to Enter Remarks'><font color='blue'>#</font></a>");
					sb.append("<div id='remarksId" + i
							+ "' class='popup' style='display:none'>");
					sb.append("<table width='600' align='center'>");
					sb.append("<tr><th align='left'>Remarks For "
							+ strItemName + "</th>");
					sb.append("<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'");
					sb.append(" onClick='closeDivItem("
							+ i
							+ ");' title='Click Here To Close Popup'></th></tbody>");
					sb.append("</table>");
					sb.append("<table width='600' align='center' cellspacing='1px' cellpadding='1px'>");
					sb.append("<div class='row'><div class='col-sm-4'><div id='remarksLabelId"
							+ i + "'><label>Remarks</label></div></div>");
					sb.append("<div class='col-sm-6'><textarea class='form-control' name='strItemRemarks'></textarea></div></div>");
					//sb.append("</tr>");
					//sb.append("<tr class='FOOTER'><td colspan='2'></td></tr>");
					sb.append("<tr><td colspan='2'><div align='center'><button type='button' class='btn btn-info btn-sm'");
					sb.append(" onClick='closeDivItem("
							+ i
							+ ");' title='Click Here To Save Remarks For Item'>OK</button></div></td></tr>");
					sb.append("</table>");
					sb.append("</div></td>");
					sb.append("</tr>");
					// sb.append("</table>");

					i++;
				}

				sb.append("</table>");

			} else {
				sb.append("<table class='table'>");				
				sb.append("<tr>");
				sb.append("<td width='100%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'> >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>"
						+ "</TD>");

				sb.append("</tr>");
				sb.append("</table>");

			}
			vo.setStrMultiRow(i + "");
		} catch (Exception e) {
			vo.setStrMsgString("IndentApprovalDeskHLP.getItemDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}

	public static String getItemDetailsReturnFromSupplier(
			IndentApprovalDeskVO vo) {
		StringBuffer sb = new StringBuffer("");
		String strHiddenValue = "";
		String strInsertHiddenValue = "";
		String strAjaxHiddenValue = "";
		// String unitCombo = "";
		// String comboVal = "";
		// String committeType = "";
		// HisUtil util = new HisUtil("MMS", "IndentApprovalDeskHLP");
		WebRowSet ws1 = vo.getStrItemDetailsWs();

		int i = 0;
		try {
			sb.append("<table class='TABLEWIDTH' align='center' bgcolor='black' border='0' cellspacing ='1px'>");

			if (vo.getStrReqTypeId().equals("47")) {
				sb.append("<tr>");
				sb.append("<td width='20%' class='multiLabel'>Item Name</td>");
				sb.append("<td width='20%' class='multiLabel'>Batch No</td>");
				sb.append("<td width='20%' class='multiLabel'>Accepted Qty</td>");
				sb.append("<td width='20%' class='multiLabel'>To Be Return Qty</td>");
				sb.append("<td width='20%' class='multiLabel'>Cost</td>");
				sb.append("</tr>");
			}
			sb.append("</table>");
			if (ws1 != null) {
				String strItemName = null;
				String strManufactrerDate = null;
				// String strCost= null;
				String strInHandQty = "0";
				String strAvlQty = "0";
				String strAvlQtyReceving = null;
				String strReqQty = null;
				// String strSancQty = null;
				String strRate = null;
				// String strIssueQty = null;
				// String strReOrderLevel = null;
				// String strLstIndentQty = null;
				// String strLstIssueQty = null;
				// String strLstYerConsump = null;
				// String strLstPoNo = null;
				// String strLstPODate = null;
				// String strLstRecQty = null;
				// String strLstRecDate = null;
				// String strLstSupplBy = null;
				String strExpDate = null;
				// String strGrpName = null;
				// String strSubGrpName = null;
				// String strReqQtyUnit = null;
				String strSanctionQty = null;
				String strItemId = null;
				String strItemBrandId = null;
				String strProcSancQty = null;
				String strProcSancQtyUnitId = null;
				String strProcIndentQty = null;
				String strProcIndentQtyUnit = null;
				String strBatchNo = "0";
				String strItemSlNo = "0";
				String strStockStatusCode = "0";
				String strAcceptedQty = null;
				// String strToBeReturnQty = null;
				String strCost = "0";

				// String strRasing = "0";
				// String strReceving = "1";
				while (ws1.next()) {
					if (vo.getStrReqTypeId().equals("47")) {
						strManufactrerDate = ws1.getString(1);
						strExpDate = ws1.getString(2);
						strBatchNo = ws1.getString(3);
						strItemName = ws1.getString(4);
						strAvlQty = ws1.getString(5);
						strReqQty = ws1.getString(6);
						// strSancQty = ws1.getString(7);
						strRate = ws1.getString(8);
						strItemId = ws1.getString(9);
						strItemBrandId = ws1.getString(10);
						strProcIndentQty = ws1.getString(11);
						strProcIndentQtyUnit = ws1.getString(12);
						strProcSancQty = ws1.getString(13);
						strProcSancQtyUnitId = ws1.getString(14);
						strCost = ws1.getString(15);

						strItemSlNo = ws1.getString(17);
						strStockStatusCode = ws1.getString(18);
						strBatchNo = ws1.getString(19);
						strInHandQty = ws1.getString(20);

						strAcceptedQty = ws1.getString(21);
						// strToBeReturnQty = ws1.getString(22);

						strInsertHiddenValue = strItemId + "@" + strItemBrandId
								+ "@" + strProcIndentQty + "@"
								+ strProcIndentQtyUnit + "@" + strProcSancQty
								+ "@" + strProcSancQtyUnitId + "@"
								+ ws1.getString(17) + "@" + ws1.getString(18)
								+ "@" + ws1.getString(19);
						strAjaxHiddenValue = strItemId + "@"
								+ vo.getStrStoreId() + "@" + strItemBrandId
								+ "@" + vo.getStrReqNo() + "@" + strBatchNo
								+ "@" + strItemSlNo + "@" + strStockStatusCode
								+ "@" + vo.getStrToStoreId() + "@"
								+ vo.getStrReqTypeId();
						strHiddenValue = strRate + "^" + strManufactrerDate
								+ "^" + strExpDate;

						IndentApprovalDeskDAO.getUnitCombo(vo,
								strProcIndentQtyUnit);

						/*
						 * if(ws1.getString(14)==null ||
						 * ws1.getString(14).equals("")) { comboVal = "0"; }
						 * else { comboVal = ws1.getString(14);
						 * 
						 * }
						 */

						/*
						 * if (vo.getStrUnitComboWs() != null &&
						 * vo.getStrUnitComboWs().size() > 0) { unitCombo =
						 * util.getOptionValue(vo.getStrUnitComboWs(),
						 * comboVal,"0^Select Unit", false); } else { unitCombo
						 * = "<option value='0'>Select Unit</option>"; }
						 */

					}

					if (strItemName == null || strItemName.equals(""))
						strItemName = "-----";
					if (strAvlQty == null || strAvlQty.equals(""))
						strAvlQty = "-----";
					if (strReqQty == null || strReqQty.equals(""))
						strReqQty = "-----";
					if (strSanctionQty == null || strSanctionQty.equals(""))
						strSanctionQty = "0";
					if (strRate == null || strRate.equals(""))
						strRate = "-----";
					if (strBatchNo == null || strBatchNo.equals(""))
						strBatchNo = "-----";
					if (strAvlQtyReceving == null
							|| strAvlQtyReceving.equals(""))
						strAvlQtyReceving = "-----";

					if (vo.getStrReqTypeId().equals("47")) {
						sb.append("<input type='hidden' name ='strInHandQty'  value='"
								+ strInHandQty + "'>");
						sb.append("<input type='hidden' name ='strItemSlNo'  value='"
								+ strItemSlNo + "'>");
						sb.append("<input type='hidden' name ='strStockStatusCode'  value='"
								+ strStockStatusCode + "'>");
						sb.append("<input type='hidden' name ='strBatchNo'  value='"
								+ strBatchNo + "'>");

						sb.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' border='0' cellspacing ='1px'>");
						sb.append("<input type='hidden' name ='strAjaxHiddenValue'  value='"
								+ strAjaxHiddenValue + "'>");
						sb.append("<input type='hidden' name ='strInsertHiddenValue'  value='"
								+ strInsertHiddenValue + "'>");
						sb.append("<input type='hidden' name ='strHiddenValue'  value='"
								+ strHiddenValue + "'>");
						sb.append("<tr>");
						sb.append("<td width='20%' class='multiControl'>");
						/*sb.append("<a name='tarriff' value='' STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Item Details' onClick='callingPoPUp(this,"
								+ i
								+ ",\""
								+ strHiddenValue
								+ "\",\""
								+ vo.getStrReqTypeId()
								+ "\");'>"
								+ strItemName
								+ "</a>");*/
						sb.append(strItemName);
						sb.append("</td>");
						sb.append("<td width='20%' class='multiControl'>");
						sb.append(strBatchNo);
						sb.append("</td>");
						sb.append("<td width='20%' class='multiControl'>");
						sb.append(strAcceptedQty);
						// sb.append("<a name='tarriff' value='' STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callingAjaxPoPUp(this,"+i+",\""+strRasing+"\",\""+strAjaxHiddenValue+"\");'>"+strAvlQty+"</a>");
						sb.append("</td>");
						sb.append("<td width='20%' class='multiControl'>");
						sb.append(strReqQty);
						sb.append("</td>");
						sb.append("<td width='20%' class='multiControl'>");
						sb.append(strCost);
						sb.append("</td>");
						sb.append("</tr>");
					}

					i++;
				}
				sb.append("</table>");

			} else {
				sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#6097BC' cellspacing ='1px'>");
				sb.append("<tr>");
				sb.append("<td colspan='5'  CLASS='multiControl' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>"
						+ "</TD>");

				sb.append("</tr>");
				sb.append("</table>");

			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentApprovalDeskHLP.getItemDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}

		return sb.toString();
	}

	/**
	 * This method is used to Get Item details for Indent for Condemnation ,
	 * Return request & Return to Supplier type of Request
	 * 
	 * @param vo
	 * @return String
	 */

	public static String getItemDetails(IndentApprovalDeskVO vo) {
		StringBuffer sb = new StringBuffer("");
		String strHiddenValue = "";
		String strInsertHiddenValue = "";
		String strAjaxHiddenValue = "";
		String unitCombo = "";
		String comboVal = "";
		// String committeType = "";
		HisUtil util = new HisUtil("MMS", "IndentApprovalDeskHLP");
		WebRowSet ws1 = vo.getStrItemDetailsWs();
		int i = 0;
		try {
			sb.append("<table class='table'>");
			if (vo.getStrReqTypeId().equals("16")
					|| vo.getStrReqTypeId().equals("18")
					|| vo.getStrReqTypeId().equals("19")) {
				sb.append("<thead class='thead-dark' align='center'>");
				sb.append("<tr>");
				sb.append("<th width='20%'  style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</th>");
				sb.append("<th width='25%' style='font-weight:350 !important ;font-size: 16px !important;'>Batch No</th>");
			//	sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Avl Qty</td>");
				sb.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</td>");
				sb.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'><font size='2' color='red'>*</font>Approved Qty</th>");
				sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'><font size='2' color='red'>*</font>Unit Name</th>");
				sb.append("<th width='5%' style='font-weight:350 !important ;font-size: 16px !important;'>#</th>");
				sb.append("</tr>");
			} else {
				sb.append("<tr>");
				sb.append("<td width='20%'  style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</td>");
				//sb.append("<td width='20%' class='multiLabel'>Avl Qty</td>");
				
				if (vo.getStrReqTypeId().equals("83")) {
					sb.append("<td width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty / (Approx Rate/Unit)</td>");
				}
				else
				{
					sb.append("<td width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</td>");
				}
				
				sb.append("<td width='20%' style='font-weight:350 !important ;font-size: 16px !important;'><font size='2' color='red'>*</font>Approved Qty</td>");
				sb.append("<td width='20%' style='font-weight:350 !important ;font-size: 16px !important;'><font size='2' color='red'>*</font>Unit Name</td>");
				sb.append("<td width='5%' style='font-weight:350 !important ;font-size: 16px !important;'>#</td>");
				sb.append("</tr>");
				if (vo.getStrReqTypeId().equals("47")) {
					sb.append("<tr>");
					sb.append("<td width='20%'style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</td>");
					sb.append("<td width='20%'style='font-weight:350 !important ;font-size: 16px !important;'>Batch No</td>");
					sb.append("<td width='20%'style='font-weight:350 !important ;font-size: 16px !important;'>Accepted Qty</td>");
					sb.append("<td width='20%'style='font-weight:350 !important ;font-size: 16px !important;'>To Be Return Qty</td>");
					sb.append("<td width='20%'style='font-weight:350 !important ;font-size: 16px !important;'>Cost</td>");

					sb.append("</tr>");
				}

			}
			sb.append("</table>");

			if (ws1 != null) {
				String strItemName = null;
				String strManufactrerDate = null;
				// String strCost= null;
				String strInHandQty = "0";
				String strAvlQty = "0";
				String strAvlQtyReceving = null;
				String strReqQty = null;
				// String strSancQty = null;
				String strRate = null;
				// String strIssueQty = null;
				String strReOrderLevel = null;
				// String strLstIndentQty = null;
				// String strLstIssueQty = null;
				String strLstYerConsump = null;
				String strLstPoNo = null;
				String strLstPODate = null;
				String strLstRecQty = null;
				String strLstRecDate = null;
				String strLstSupplBy = null;
				String strExpDate = null;
				String strGrpName = null;
				String strSubGrpName = null;
				// String strReqQtyUnit = null;
				String strSanctionQty = null;
				String strItemId = null;
				String strItemBrandId = null;
				String strProcSancQty = null;
				String strProcSancQtyUnitId = null;
				String strProcIndentQty = null;
				String strProcIndentQtyUnit = null;
				String strBatchNo = "0";
				String strItemSlNo = "0";
				String strStockStatusCode = "0";

				String strRasing = "0";
				// String strReceving = "1";
				while (ws1.next()) {
					if (vo.getStrReqTypeId().equals("11")
							||vo.getStrReqTypeId().equals("86")
							
							|| vo.getStrReqTypeId().equals("80")
							|| vo.getStrReqTypeId().equals("81")
							|| vo.getStrReqTypeId().equals("85")
							|| vo.getStrReqTypeId().equals("84")
							|| vo.getStrReqTypeId().equals("83")|| vo.getStrReqTypeId().equals("90")) {
						strLstPoNo = ws1.getString(1);
						strLstPODate = ws1.getString(2);
						strLstRecDate = ws1.getString(3);
						strLstSupplBy = ws1.getString(4);
						strLstYerConsump = ws1.getString(5);
						strReOrderLevel = ws1.getString(6);
						strLstRecQty = ws1.getString(7);

						strItemName = ws1.getString(8);
						strAvlQty = ws1.getString(9);
						strReqQty = ws1.getString(10);
						// strSancQty = ws1.getString(11);
						strRate = ws1.getString(12);

						strItemId = ws1.getString(13);
						strItemBrandId = ws1.getString(14);

						strProcIndentQty = ws1.getString(15);
						strProcIndentQtyUnit = ws1.getString(16);

						strProcSancQty = ws1.getString(17);
						strProcSancQtyUnitId = ws1.getString(18);

						// strReqQtyUnit = strProcIndentQtyUnit;
						strSanctionQty = strProcSancQty;

						strAjaxHiddenValue = strItemId + "@"
								+ vo.getStrStoreId() + "@" + strItemBrandId
								+ "@" + vo.getStrReqNo() + "@" + strBatchNo
								+ "@" + strItemSlNo + "@" + strStockStatusCode
								+ "@" + vo.getStrToStoreId() + "@"
								+ vo.getStrReqTypeId();
						strInsertHiddenValue = strItemId + "@" + strItemBrandId
								+ "@" + strProcIndentQty + "@"
								+ strProcIndentQtyUnit + "@" + strProcSancQty
								+ "@" + strProcSancQtyUnitId;

						IndentApprovalDeskDAO.getUnitCombo(vo,
								strProcIndentQtyUnit);

						if (ws1.getString(19) == null
								|| ws1.getString(19).equals("")) {
							comboVal = "0";
						} else {
							comboVal = ws1.getString(19);

						}

						if (vo.getStrUnitComboWs() != null
								&& vo.getStrUnitComboWs().size() > 0) {
							unitCombo = util.getOptionValue(
									vo.getStrUnitComboWs(), comboVal,
									"", false);
						} else {
							unitCombo = "<option value='0'>Select Unit</option>";
						}

						strHiddenValue = strLstPoNo + "^" + strLstPODate + "^"
								+ strLstRecDate + "^" + strLstSupplBy + "^"
								+ strLstYerConsump + "^" + strReOrderLevel
								+ "^" + strLstRecQty;

					}
					if (vo.getStrReqTypeId().equals("16")
							|| vo.getStrReqTypeId().equals("19")) {
						strLstPoNo = ws1.getString(1);
						strLstPODate = ws1.getString(2);
						strLstRecDate = ws1.getString(3);
						strExpDate = ws1.getString(4);
						strLstSupplBy = ws1.getString(5);
						strGrpName = ws1.getString(6);
						strSubGrpName = ws1.getString(7);
						strBatchNo = ws1.getString(8);

						strItemName = ws1.getString(9);
						strAvlQty = ws1.getString(10);
						strReqQty = ws1.getString(11);
						// strSancQty = ws1.getString(12);
						// System.out.println("Condemnation strBatchNo::::"+strBatchNo);
						strRate = ws1.getString(13);
						strItemId = ws1.getString(14);
						strItemBrandId = ws1.getString(15);
						strProcIndentQty = ws1.getString(16);
						strProcIndentQtyUnit = ws1.getString(17);
						strProcSancQty = ws1.getString(18);
						strProcSancQtyUnitId = ws1.getString(19);
						// System.out.println("Item Sl No Condemnation-->>"+ws1.getString(25));
						strItemSlNo = ws1.getString(25);
						strSanctionQty = strProcSancQty;

						strInsertHiddenValue = strItemId + "@" + strItemBrandId
								+ "@" + strProcIndentQty + "@"
								+ strProcIndentQtyUnit + "@" + strProcSancQty
								+ "@" + strProcSancQtyUnitId + "@"
								+ strStockStatusCode + "@" + strBatchNo + "@"
								+ strInHandQty;
						strAjaxHiddenValue = strItemId + "@"
								+ vo.getStrStoreId() + "@" + strItemBrandId
								+ "@" + vo.getStrReqNo() + "@" + strBatchNo
								+ "@" + strItemSlNo + "@" + strStockStatusCode
								+ "@" + vo.getStrToStoreId() + "@"
								+ vo.getStrReqTypeId();

						// strItemSlNo = ws1.getString(21);
						strStockStatusCode = ws1.getString(21);
						strBatchNo = ws1.getString(22);
						strInHandQty = ws1.getString(23);

						IndentApprovalDeskDAO.getUnitCombo(vo,
								strProcIndentQtyUnit);

						IndentApprovalDeskDAO.getStockDtls(vo, strItemId,
								strItemBrandId);

						if (ws1.getString(20) == null
								|| ws1.getString(20).equals("")) {
							comboVal = "0";
						} else {
							comboVal = ws1.getString(20);

						}

						if (vo.getStrUnitComboWs() != null
								&& vo.getStrUnitComboWs().size() > 0) {
							unitCombo = util.getOptionValue(
									vo.getStrUnitComboWs(), comboVal,
									"", false);
						} else {
							unitCombo = "<option value='0'>Select Unit</option>";
						}

						strHiddenValue = strLstPoNo + "^" + strLstPODate + "^"
								+ strLstRecDate + "^" + strExpDate + "^"
								+ strLstSupplBy + "^" + strGrpName + "^"
								+ strSubGrpName;
					}

					if (vo.getStrReqTypeId().equals("15")
							|| vo.getStrReqTypeId().equals("82")) {
						strLstPoNo = ws1.getString(1);
						strLstPODate = ws1.getString(2);
						strLstRecDate = ws1.getString(3);
						strLstSupplBy = ws1.getString(4);
						strGrpName = ws1.getString(5);
						strSubGrpName = ws1.getString(6);

						strItemName = ws1.getString(7);
						strAvlQty = ws1.getString(8);
						strReqQty = ws1.getString(9);
						// strSancQty = ws1.getString(10);
						strRate = ws1.getString(11);

						strItemId = ws1.getString(12);
						strItemBrandId = ws1.getString(13);
						strProcIndentQty = ws1.getString(14);
						strProcIndentQtyUnit = ws1.getString(15);
						strProcSancQty = ws1.getString(16);
						strProcSancQtyUnitId = ws1.getString(17);

						// strReqQtyUnit = strProcIndentQtyUnit;
						strSanctionQty = strProcSancQty;
						strAjaxHiddenValue = strItemId + "@"
								+ vo.getStrStoreId() + "@" + strItemBrandId
								+ "@" + vo.getStrReqNo() + "@" + strBatchNo
								+ "@" + strItemSlNo + "@" + strStockStatusCode
								+ "@" + vo.getStrToStoreId() + "@"
								+ vo.getStrReqTypeId();
						strInsertHiddenValue = strItemId + "@" + strItemBrandId
								+ "@" + strProcIndentQty + "@"
								+ strProcIndentQtyUnit + "@" + strProcSancQty
								+ "@" + strProcSancQtyUnitId;

						IndentApprovalDeskDAO.getUnitCombo(vo,
								strProcIndentQtyUnit);

						if (ws1.getString(18) == null
								|| ws1.getString(18).equals("")) {
							comboVal = "0";
						} else {
							comboVal = ws1.getString(18);

						}

						if (vo.getStrUnitComboWs() != null
								&& vo.getStrUnitComboWs().size() > 0) {
							unitCombo = util.getOptionValue(
									vo.getStrUnitComboWs(), ws1.getString(18),
									"", false);
						} else {
							unitCombo = "<option value='0'>Select Unit</option>";
						}

						strHiddenValue = strLstPoNo + "^" + strLstPODate + "^"
								+ strLstRecDate + "^" + strLstSupplBy + "^"
								+ strGrpName + "^" + strSubGrpName;
					}

					if (vo.getStrReqTypeId().equals("18")) {
						strLstPoNo = ws1.getString(1);
						strLstPODate = ws1.getString(2);
						strGrpName = ws1.getString(3);
						strSubGrpName = ws1.getString(4);
						strExpDate = ws1.getString(5);
						strBatchNo = ws1.getString(6);
						strItemName = ws1.getString(7);
						strAvlQty = ws1.getString(8);
						strReqQty = ws1.getString(9);
						// strSancQty = ws1.getString(10);
						strRate = ws1.getString(11);

						strItemId = ws1.getString(12);
						strItemBrandId = ws1.getString(13);
						strProcIndentQty = ws1.getString(14);
						strProcIndentQtyUnit = ws1.getString(15);
						strProcSancQty = ws1.getString(16);
						strProcSancQtyUnitId = ws1.getString(17);

						// strReqQtyUnit = strProcIndentQtyUnit;
						strSanctionQty = strProcSancQty;

						strAjaxHiddenValue = strItemId + "@"
								+ vo.getStrStoreId() + "@" + strItemBrandId
								+ "@" + vo.getStrReqNo() + "@" + strBatchNo
								+ "@" + strItemSlNo + "@" + strStockStatusCode
								+ "@" + vo.getStrToStoreId() + "@"
								+ vo.getStrReqTypeId();
						strInsertHiddenValue = strItemId + "@" + strItemBrandId
								+ "@" + strProcIndentQty + "@"
								+ strProcIndentQtyUnit + "@" + strProcSancQty
								+ "@" + strProcSancQtyUnitId + "@"
								+ ws1.getString(19) + "@" + ws1.getString(20)
								+ "@" + ws1.getString(21);

						IndentApprovalDeskDAO.getUnitCombo(vo,
								strProcIndentQtyUnit);

						if (ws1.getString(18) == null
								|| ws1.getString(18).equals("")) {
							comboVal = "0";
						} else {
							comboVal = ws1.getString(18);

						}

						// strItemSlNo = ws1.getString(19);
						strStockStatusCode = ws1.getString(19);
						strBatchNo = ws1.getString(20);
						strInHandQty = ws1.getString(21);

						if (vo.getStrUnitComboWs() != null
								&& vo.getStrUnitComboWs().size() > 0) {
							unitCombo = util.getOptionValue(
									vo.getStrUnitComboWs(), comboVal,
									"", false);
						} else {
							unitCombo = "<option value='0'>Select Unit</option>";
						}

						strHiddenValue = strLstPoNo + "^" + strLstPODate + "^"
								+ strLstRecDate + "^" + strGrpName + "^"
								+ strSubGrpName + "^" + strExpDate;
					}
					if (vo.getStrReqTypeId().equals("47")) {
						strManufactrerDate = ws1.getString(1);
						strExpDate = ws1.getString(2);
						strBatchNo = ws1.getString(3);
						strItemName = ws1.getString(4);
						strAvlQty = ws1.getString(5);
						strReqQty = ws1.getString(6);
						// strSancQty = ws1.getString(7);
						strRate = ws1.getString(8);
						strItemId = ws1.getString(9);
						strItemBrandId = ws1.getString(10);
						strProcIndentQty = ws1.getString(11);
						strProcIndentQtyUnit = ws1.getString(12);
						strProcSancQty = ws1.getString(13);
						strProcSancQtyUnitId = ws1.getString(14);
						// strCost = ws1.getString(15);

						strItemSlNo = ws1.getString(17);
						strStockStatusCode = ws1.getString(18);
						strBatchNo = ws1.getString(19);
						strInHandQty = ws1.getString(20);

						strInsertHiddenValue = strItemId + "@" + strItemBrandId
								+ "@" + strProcIndentQty + "@"
								+ strProcIndentQtyUnit + "@" + strProcSancQty
								+ "@" + strProcSancQtyUnitId + "@"
								+ ws1.getString(17) + "@" + ws1.getString(18)
								+ "@" + ws1.getString(19);
						strAjaxHiddenValue = strItemId + "@"
								+ vo.getStrStoreId() + "@" + strItemBrandId
								+ "@" + vo.getStrReqNo() + "@" + strBatchNo
								+ "@" + strItemSlNo + "@" + strStockStatusCode
								+ "@" + vo.getStrToStoreId() + "@"
								+ vo.getStrReqTypeId();
						strHiddenValue = strRate + "^" + strManufactrerDate
								+ "^" + strExpDate;

						IndentApprovalDeskDAO.getUnitCombo(vo,
								strProcIndentQtyUnit);

						if (ws1.getString(14) == null
								|| ws1.getString(14).equals("")) {
							comboVal = "0";
						} else {
							comboVal = ws1.getString(14);

						}

						if (vo.getStrUnitComboWs() != null
								&& vo.getStrUnitComboWs().size() > 0) {
							unitCombo = util.getOptionValue(
									vo.getStrUnitComboWs(), comboVal,
									"", false);
						} else {
							unitCombo = "<option value='0'>Select Unit</option>";
						}

					}

					if (strItemName == null || strItemName.equals(""))
						strItemName = "-----";
					if (strAvlQty == null || strAvlQty.equals(""))
						strAvlQty = "-----";
					if (strReqQty == null || strReqQty.equals(""))
						strReqQty = "-----";
					if (strSanctionQty == null || strSanctionQty.equals(""))
						strSanctionQty = "0";
					if (strRate == null || strRate.equals(""))
						strRate = "-----";
					if (strBatchNo == null || strBatchNo.equals(""))
						strBatchNo = "-----";
					if (strAvlQtyReceving == null
							|| strAvlQtyReceving.equals(""))
						strAvlQtyReceving = "-----";

					if (vo.getStrReqTypeId().equals("16")
							|| vo.getStrReqTypeId().equals("18")
							|| vo.getStrReqTypeId().equals("19")) {

						sb.append("<table class='table'>");
						sb.append("<input type='hidden' name ='strInHandQty'  value='"
								+ strInHandQty + "'>");
						sb.append("<input type='hidden' name ='strItemSlNo'  value='"
								+ strItemSlNo + "'>");
						sb.append("<input type='hidden' name ='strStockStatusCode'  value='"
								+ strStockStatusCode + "'>");
						sb.append("<input type='hidden' name ='strBatchNo'  value='"
								+ strBatchNo + "'>");

						sb.append("<input type='hidden' name ='strAjaxHiddenValue'  value='"
								+ strAjaxHiddenValue + "'>");
						sb.append("<input type='hidden' name ='strInsertHiddenValue'  value='"
								+ strInsertHiddenValue + "'>");
						sb.append("<input type='hidden' name ='strHiddenValue'  value='"
								+ strHiddenValue + "'>");
						sb.append("<tr>");
						sb.append("<td width='20%'style='font-weight:350 !important ;font-size: 16px !important;'>");
						/*sb.append("<a name='tarriff' value='' STYLE='cursor:pointer;' title='Get Item Details' onClick='callingPoPUp(this,"
								+ i
								+ ",\""
								+ strHiddenValue
								+ "\",\""
								+ vo.getStrReqTypeId()
								+ "\");'>"
								+ strItemName
								+ "</a>");*/
						sb.append(strItemName);
						sb.append("</td>");
						sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>");
						sb.append(strBatchNo);
						sb.append("</td>");
//						sb.append("<td width='15%' class='multiControl'>");
						// sb.append(strAvlQty);
//						sb.append("<a name='tarriff' value='' STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Quantity Details' onClick='callingAjaxPoPUp(this,"
//								+ i
//								+ ",\""
//								+ strRasing
//								+ "\",\""
//								+ strAjaxHiddenValue
//								+ "\");'>"
//								+ strAvlQty
//								+ "</a>");
//						sb.append("</td>");
						sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>");
						sb.append(strReqQty);
						sb.append("<input type='hidden' name ='strReqQty'  value='"
								+ strReqQty + "'>");
						sb.append("</td>");

						sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>");
						// sb.append("<input type='text'class='txtFldSmall' name='strInsSancQty' value='"+strProcSancQty+"' onkeypress='return validateData(event,7);'>");
						sb.append("<input type='text'class='form-control' name='strInsSancQty' id='strInsSancQty"
								+ i
								+ "' value='"
								+ strProcSancQty
								+ "' onkeypress='return validateData(event,7);'  onkeyup='checkQtyWithoutUtility(\""
								+ i
								+ "\", \"strInsSancQty\", \"strInsUnitCombo\" ,\""
								+ strInHandQty
								+ "\",\"Sanction Quantity should not be Greater than Available Quantity\");'   >");
						sb.append("</td>");
						// sb.append("<td width='20%' class='multiControl'>");
						// sb.append("<select name='strInsUnitCombo'>'"+unitCombo+"'</select>");
						sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 16px !important;' onchange='checkQtyWithoutUtility(\""
								+ i
								+ "\", \"strInsSancQty\", \"strInsUnitCombo\" , \""
								+ strInHandQty
								+ "\",\" Sanction Quantity should not be Greater than Available Quantity\");' >");
						sb.append("<select class='form-select' name='strInsUnitCombo' id='strInsUnitCombo" 
								+ i + "' >'" + unitCombo + "'</select>");

						sb.append("</td>");
						sb.append("<td style='font-weight:350 !important ;font-size: 16px !important;' width='5%'><a value='' style='cursor:pointer;'   onClick='openDivItem(this,"
								+ i
								+ ");' title='Click here to Enter Remarks'><font color='blue'  style='cursor:pointer;'>#</font></a>");
						sb.append("<div id='remarksId" + i
								+ "' class='popup' style='display:none'>");
						sb.append("<table width='400' align='center'>");
						sb.append("<tr class='HEADER' style='color:blue;font-family: Arial, Helvetica, sans-serif;font-size:13px;'><th align='left' >Remarks For "
								+ strItemName + "</th>");
						sb.append("<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'");
						sb.append(" onClick='closeDivItem("
								+ i
								+ ");' title='Click Here To Close Popup' ></th></tr>");
						sb.append("</table>");
						sb.append("<table width='400' align='center' cellspacing='1px' cellpadding='1px'>");
						sb.append("<tr><td class='LABEL' width='50%'><div id='remarksLabelId"
								+ i + "'>Remarks</div></td>");
						sb.append("<td class='CONTROL' width='50%'><textarea name='strItemRemarks'></textarea></td>");
						sb.append("</tr>");
						sb.append("<tr class='FOOTER'><td colspan='2'></td></tr>");
						sb.append("<tr ><td colspan='2' class='CONTROL'><div align='center'><img  style='cursor:pointer;' src='../../hisglobal/images/btn-ok.png'");
						sb.append(" onClick='closeDivItem("
								+ i
								+ ");' title='Click Here To Save Remarks For Item'></div></td></tr>");
						sb.append("</table>");
						sb.append("</div></td>");
						sb.append("</tr>");

					} else {
						sb.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' border='0' cellspacing ='1px'>");
						sb.append("<input type='hidden' name ='strInHandQty'  value='"
								+ strInHandQty + "'>");
						sb.append("<input type='hidden' name ='strItemSlNo'  value='"
								+ strItemSlNo + "'>");
						sb.append("<input type='hidden' name ='strStockStatusCode'  value='"
								+ strStockStatusCode + "'>");
						sb.append("<input type='hidden' name ='strBatchNo'  value='"
								+ strBatchNo + "'>");

						sb.append("<input type='hidden' name ='strInsertHiddenValue'  value='"
								+ strInsertHiddenValue + "'>");
						sb.append("<input type='hidden' name ='strAjaxHiddenValue'  value='"
								+ strAjaxHiddenValue + "'>");
						sb.append("<input type='hidden' name ='strHiddenValue'  value='"
								+ strHiddenValue + "'>");
						sb.append("<tr>");
						sb.append("<td width='20%' class='multiControl'>");
						//sb.append("<a name='tarriff' value='' STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Item Details'  onClick='callingPoPUp(this,"
						//		+ i
						//		+ ",\""
						//		+ strHiddenValue
						//		+ "\",\""
						//		+ vo.getStrReqTypeId()
						//		+ "\");'>"
						//		+ strItemName
						//		+ "</a>");
						sb.append(strItemName);
						sb.append("</td>");
//						sb.append("<td width='20%' class='multiControl'>");
//						sb.append("<a name='tarriff' value='' STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Quantity Details' onClick='callingAjaxPoPUp(this,"
//								+ i
//								+ ",\""
//								+ strRasing
//								+ "\",\""
//								+ strAjaxHiddenValue
//								+ "\");'>"
//								+ strAvlQty
//								+ "</a>");
//						sb.append("</td>");
						sb.append("<td width='20%' class='multiControl'>");
						if(vo.getStrReqTypeId().equals("83"))
						{
						sb.append(strReqQty+"/ ("+strRate+")");
						}else
						{
							sb.append(strReqQty);
						}
						sb.append("<input type='hidden' name ='strReqQty'  value='"
								+ strReqQty + "'>");
						sb.append("</td>");

						sb.append("<td width='20%' class='multiControl'>");
						if(vo.getStrReqTypeId().equals("83"))
						{
						sb.append("<input type='text'class='txtFldNormal' name='strInsSancQty' value='"
								+ strProcIndentQty
								+ "' onkeypress='return validateData(event,7);'>");
						}
						else
						{
							sb.append("<input type='text'class='txtFldNormal' name='strInsSancQty' value='"
									+strProcSancQty //+ strReqQty.split("\\.")[0]
									+ "' onkeypress='return validateData(event,7);'>");
							
						}
						sb.append("</td>");
						sb.append("<td width='15%' class='multiControl'>");
						sb.append("<select name='strInsUnitCombo'>'"
								+ unitCombo + "'</select>");

						sb.append("</td>");
						sb.append("<td class='multiControl' width='5%'><a value='' style='cursor:pointer;' onClick='openDivItem(this,"
								+ i
								+ ");' title='Click here to Enter Remarks'><font color='blue'>#</font></a>");
						sb.append("<div id='remarksId" + i
								+ "' class='popup' style='display:none'>");
						sb.append("<table width='400' align='center'>");
						sb.append("<tr class='HEADER'><th align='left'>Remarks For "
								+ strItemName + "</th>");
						sb.append("<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'");
						sb.append(" onClick='closeDivItem("
								+ i
								+ ");' title='Click Here To Close Popup'></th></tr>");
						sb.append("</table>");
						sb.append("<table width='400' align='center' cellspacing='1px' cellpadding='1px'>");
						sb.append("<tr><td class='LABEL' width='50%'><div id='remarksLabelId"
								+ i + "'>Remarks</div></td>");
						sb.append("<td class='CONTROL' width='50%'><textarea name='strItemRemarks'></textarea></td>");
						sb.append("</tr>");
						sb.append("<tr class='FOOTER'><td colspan='2'></td></tr>");
						sb.append("<tr ><td colspan='2' class='CONTROL'><div align='center'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/btn-ok.png'");
						sb.append(" onClick='closeDivItem("
								+ i
								+ ");' title='Click Here To Save Remarks For Item'></div></td></tr>");
						sb.append("</table>");
						sb.append("</div></td>");
						sb.append("</tr>");
						{
							if (vo.getStrReqTypeId().equals("47")) {
								sb.append("<input type='hidden' name ='strInHandQty'  value='"
										+ strInHandQty + "'>");
								sb.append("<input type='hidden' name ='strItemSlNo'  value='"
										+ strItemSlNo + "'>");
								sb.append("<input type='hidden' name ='strStockStatusCode'  value='"
										+ strStockStatusCode + "'>");
								sb.append("<input type='hidden' name ='strBatchNo'  value='"
										+ strBatchNo + "'>");

								sb.append("<input type='hidden' name ='strAjaxHiddenValue'  value='"
										+ strAjaxHiddenValue + "'>");
								sb.append("<input type='hidden' name ='strInsertHiddenValue'  value='"
										+ strInsertHiddenValue + "'>");
								sb.append("<input type='hidden' name ='strHiddenValue'  value='"
										+ strHiddenValue + "'>");
								sb.append("<tr>");
								sb.append("<td width='20%' class='multiControl'>");
								sb.append("<a name='tarriff' value='' STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Item Details' onClick='callingPoPUp(this,"
										+ i
										+ ",\""
										+ strHiddenValue
										+ "\",\""
										+ vo.getStrReqTypeId()
										+ "\");'>"
										+ strItemName + "</a>");
								sb.append("</td>");
								sb.append("<td width='15%' class='multiControl'>");
								sb.append(strBatchNo);
								sb.append("</td>");
//								sb.append("<td width='15%' class='multiControl'>");
//								sb.append("<a name='tarriff' value='' STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Qunatity Details' onClick='callingAjaxPoPUp(this,"
//										+ i
//										+ ",\""
//										+ strRasing
//										+ "\",\""
//										+ strAjaxHiddenValue
//										+ "\");'>"
//										+ strAvlQty + "</a>");
//								sb.append("</td>");
								sb.append("<td width='15%' class='multiControl'>");
								sb.append(strReqQty);
								sb.append("</td>");

								sb.append("<td width='15%' class='multiControl'>");
								sb.append("<input type='text'class='txtFldNormal' name='strInsSancQty' id='strInsSancQty"
										+ i
										+ "' value='"
										+ strProcSancQty
										+ "' onkeypress='return validateData(event,7);'  onkeyup='checkQtyWithoutUtility(\""
										+ i
										+ "\", \"strInsSancQty\", \"strInsUnitCombo\" , \""
										+ strInHandQty
										+ "\",\"Sanction Quantity should not be Greater than Available Quantity\");'   >");

								sb.append("</td>");
								sb.append("<td width='15%' class='multiControl' onchange='checkQtyWithoutUtility(\""
										+ i
										+ "\", \"strInsSancQty\", \"strInsUnitCombo\" , \""
										+ strInHandQty
										+ "\",\" Sanction Quantity should not be Greater than Available Quantity\");' >");
								sb.append("<select name='strInsUnitCombo' id='strInsUnitCombo"
										+ i + "' >'" + unitCombo + "'</select>");
								sb.append("</td>");

								sb.append("</tr>");
							}
						}
					}

					i++;
				}
				sb.append("</table>");

			} else {
				sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
				sb.append("<tr>");
				sb.append("<td colspan='6'  CLASS='multiControl' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>"
						+ "</TD>");

				sb.append("</tr>");
				sb.append("</table>");

			}
			vo.setStrMultiRow(i + "");
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentApprovalDeskHLP.getItemDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}

		return sb.toString();
	}

	/**
	 * This method is used to Get Indent Details for All request
	 * 
	 * @param vo
	 * @return String
	 */

	public static String getIndentDetailsForPhysicalStockVerification(
			IndentApprovalDeskVO vo) {

		StringBuffer sb = new StringBuffer("");

		try {
			WebRowSet ws = vo.getStrIndentDetailsWs();
			if (ws != null && ws.size() > 0) {
				if (ws.next()) {

					// String status = "";
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
					String strSupplName = ws.getString(12);

					if (strStoreName == null)
						strStoreName = "----";
					if (strItemCatg == null)
						strItemCatg = "----";
					if (strReqNo == null)
						strReqNo = "----";
					if (strIndentDate == null)
						strIndentDate = "----";
					if (strIndentType == null)
						strIndentType = "----";
					if (strToStore == null)
						strToStore = "----";
					if (strIndentStatus == null)
						strIndentStatus = "----";
					if (strIndentPeriod == null || strIndentPeriod.equals("0"))
						strIndentPeriod = "----";
					if (strApprovedBy == null)
						strApprovedBy = "----";
					if (strApprovedDate == null)
						strApprovedDate = "----";
					if (strApprovedlevel == null)
						strApprovedlevel = "----";
					if (strSupplName == null)
						strSupplName = "----";
					/*
					 * if(strIndentStatus.equals("1")) { status ="Uregnt"; }
					 * else { status ="Normal"; }
					 */
					sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");

					sb.append("<tr><td width='25%' class='LABEL'>Request Type Name</td>");
					sb.append("<td colspan='3' width='25%' class='CONTROL'> ");
					sb.append(strIndentType);
					sb.append("</td></tr>");

					sb.append("<tr><td width='25%' class='LABEL'>Raising Store</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strStoreName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Receiving Store</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strToStore);
					sb.append("</td></tr>");

					sb.append("<tr><td width='25%' class='LABEL'>Req No</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strReqNo);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Req Date</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strIndentDate);
					sb.append("</td></tr>");

					sb.append("<tr><td width='25%' class='LABEL'>Item Category</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strItemCatg);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Req Period</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strIndentPeriod);
					sb.append("</td></tr>");

					sb.append("</table>");
//					sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
//					sb.append("<tr>");
//					sb.append("<td width='5%' class='TITLE' align='center'><input type='hidden' name='button1' value='0'>");
//					sb.append("<img src='../../hisglobal/images/plus.gif'   id='plus1'  style='display:block;cursor:pointer' title='Open Approval Details' onClick='ftn11()'>");
//					sb.append("<img src='../../hisglobal/images/minus.gif'  id='minus1' style='display:none;cursor:pointer' title='Close Approval Details' onClick='ftn11()'></td>");
//					sb.append("<td colspan='3' class='TITLE' align='left'><b>Last Approval Details</b></td>");
//					sb.append("</tr>");
//					sb.append("</table>");
//
//					sb.append("<div id='LastApprovalDtl' style='display:none'>");
//					sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
//					sb.append("<tr><td width='25%' class='LABEL'>Approved By</td>");
//					sb.append("<td width='25%' class='CONTROL'>");
//					sb.append(strApprovedBy);
//					sb.append("</td>");
//					sb.append("<td width='25%' class='LABEL'>Approved Date</td>");
//					sb.append("<td width='25%' class='CONTROL'>");
//					sb.append(strApprovedDate);
//					sb.append("</td></tr>");
//
//					sb.append("<tr><td width='25%' class='LABEL'>Approval Level</td>");
//					sb.append("<td width='25%' class='CONTROL'>");
//					sb.append(strApprovedlevel);
//					sb.append("</td>");
//					sb.append("<td width='25%' class='LABEL'></td>");
//					sb.append("<td width='25%' class='CONTROL'>");
//					sb.append("</td></tr>");
//					sb.append("</table>");
//					sb.append("</div>");

				}

			} else {
				sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
				sb.append("<tr>");
				sb.append("<td colspan='5'  CLASS='multiControl' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>"
						+ "</TD>");

				sb.append("</tr>");
				sb.append("</table>");

			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentApprovalDeskHLP.getIndentDetailsForApproval() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}

	/**
	 * This method is used to Get Indent Details for All request
	 * 
	 * @param vo
	 * @return String
	 */

	public static String getItemDetailsForReceiveFromThirdParty(
			IndentApprovalDeskVO vo) {
		StringBuffer sb = null;

		final int LMIT_VAL = 10;
		int m = 0;
		WebRowSet ws = vo.getStrItemDetailsWs();

		try {

			sb = new StringBuffer("");

			if (ws != null && ws.size() > 0) {

				ws.beforeFirst();

				int noOfRecords = ws.size();
				int layerNo = noOfRecords / LMIT_VAL;
				int reminder = noOfRecords % LMIT_VAL;
				int totalLayer = layerNo;

				if (reminder > 0)

					totalLayer = totalLayer + 1;

				sb.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td class='TITLE' colspan='5'>&nbsp;Received Item Details");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("<tr>");
				sb.append("<td class='LABEL' colspan='5'>&nbsp;");
				for (int i = 1; i <= totalLayer; i++) {

					if (i == 1) {
						sb.append("<a STYLE='CURSOR:POINTER; color:" + strColor
								+ "' name='linId' id='linId" + i
								+ "' onClick='layerIndexNavigator(\"" + i
								+ "\",\"" + totalLayer + "\")'>" + i
								+ "</a> &nbsp;");
					} else {
						sb.append("<a STYLE='CURSOR:POINTER; color:"
								+ defaultColor + "' name='linId' id='linId" + i
								+ "' onClick='layerIndexNavigator(\"" + i
								+ "\",\"" + totalLayer + "\")'>" + i
								+ "</a> &nbsp;");
					}
				}
				sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr> ");
				sb.append("<td class='multiLabel' width='20%'>Received No. ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Received Date ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Institute");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Item Name ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Received Qty. ");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("</table> ");

				for (int i = 1; i <= totalLayer; i++) {

					if (i != totalLayer && totalLayer != 1) {
						if (i == 1) {
							sb.append("<div id='tariffDivId" + i
									+ "' style='display:block'>");
						} else {
							sb.append("<div id='tariffDivId" + i
									+ "' style='display:none'>");
						}
						sb.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center' cellpadding='1px' cellspacing='1px'> ");
						for (int j = 0; j < LMIT_VAL; j++) {
							ws.next();

							sb.append("<tr> ");
							sb.append("<td class='multiControl' width='20%'>")
									.append(ws.getString(1));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>")
									.append(ws.getString(2));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>")
									.append(ws.getString(3));
							sb.append("</td> ");
							sb.append("<td width='20%' class='multiControl'>");
							sb.append(
									"<a name='tarriff' value=''STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Item Details' onClick='callingPoPUpReceiveThirdParty(this,"
											+ m
											+ ",\""
											+ ws.getString(6)
											+ "\",\""
											+ ws.getString(7)
											+ "\",\""
											+ ws.getString(8)
											+ "\");'>").append(ws.getString(4));
							sb.append("</a>");
							sb.append("<td class='multiControl' width='20%'>")
									.append(ws.getString(5));
							sb.append("</td> ");
							sb.append("</tr> ");
						}
						sb.append("</table>");
						sb.append("</div>");

					} else {
						if (i == 1) {
							sb.append("<div id='tariffDivId" + i
									+ "' style='display:block'>");
						} else {
							sb.append("<div id='tariffDivId" + i
									+ "' style='display:none'>");
						}

						sb.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' cellpadding='1px' cellspacing='1px'> ");
						for (int k = 0; k < reminder; k++) {
							ws.next();
							sb.append("<tr> ");
							sb.append("<td class='multiControl' width='20%'>")
									.append(ws.getString(1));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>")
									.append(ws.getString(2));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>")
									.append(ws.getString(3));
							sb.append("</td> ");
							sb.append("<td width='20%' class='multiControl'>");
							sb.append(
									"<a name='tarriff' value=''STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Item Details' onClick='callingPoPUpReceiveThirdParty(this,"
											+ m
											+ ",\""
											+ ws.getString(6)
											+ "\",\""
											+ ws.getString(7)
											+ "\",\""
											+ ws.getString(8)
											+ "\");'>").append(ws.getString(4));
							sb.append("</a>");
							sb.append("<td class='multiControl' width='20%'>")
									.append(ws.getString(5));
							sb.append("</td> ");
							sb.append("</tr> ");

						}
						sb.append("</table>");
						sb.append("</div>");

					}
					m++;
				}

			} else {
				sb.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td class='TITLE' colspan='5'>&nbsp;Received Item Details");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("<tr> ");
				sb.append("<td class='multiLabel' width='20%'>Gifted No. ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Gifted Date ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Gifted By ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Item Name ");
				sb.append("</td> ");
				sb.append("<td class='multiLabel' width='20%'>Qty. ");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("</table> ");

				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr><td class='multiControl' colspan='5' ><font color='red'>No Matching Record Found</font></td></tr>");
				sb.append("</table>");
			}

		} catch (Exception e) {

		}

		return sb.toString();

	}

	/**
	 * This method is used to Get Indent Details for All request
	 * 
	 * @param vo
	 * @return String
	 */

	public static String getIndentDetailsViewForPhysicalStockVerification(
			IndentApprovalDeskVO vo) {

		StringBuffer sb = new StringBuffer("");

		try {
			WebRowSet ws = vo.getStrIndentDetailsWs();
			if (ws != null && ws.size() > 0) {
				if (ws.next()) {

					// String status = "";
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
					String strSupplName = ws.getString(12);

					if (strStoreName == null)
						strStoreName = "----";
					if (strItemCatg == null)
						strItemCatg = "----";
					if (strReqNo == null)
						strReqNo = "----";
					if (strIndentDate == null)
						strIndentDate = "----";
					if (strIndentType == null)
						strIndentType = "----";
					if (strToStore == null)
						strToStore = "----";
					if (strIndentStatus == null)
						strIndentStatus = "----";
					if (strIndentPeriod == null || strIndentPeriod.equals("0"))
						strIndentPeriod = "----";
					if (strApprovedBy == null)
						strApprovedBy = "----";
					if (strApprovedDate == null)
						strApprovedDate = "----";
					if (strApprovedlevel == null)
						strApprovedlevel = "----";
					if (strSupplName == null)
						strSupplName = "----";
					/*
					 * if(strIndentStatus.equals("1")) { status ="Uregnt"; }
					 * else { status ="Normal"; }
					 */
					sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");

					sb.append("<tr><td width='25%' class='LABEL'>Request Type Name</td>");
					sb.append("<td colspan='3' width='25%' class='CONTROL'> ");
					sb.append(strIndentType);
					sb.append("</td></tr>");

					sb.append("<tr><td width='25%' class='LABEL'>Raising Store</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strStoreName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Receiving Store</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strToStore);
					sb.append("</td></tr>");

					sb.append("<tr><td width='25%' class='LABEL'>Req No</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strReqNo);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Req Date</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strIndentDate);
					sb.append("</td></tr>");

					sb.append("<tr><td width='25%' class='LABEL'>Item Category</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strItemCatg);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Req Period</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strIndentPeriod);
					sb.append("</td></tr>");
				}

			} else {
				sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
				sb.append("<tr>");
				sb.append("<td colspan='5'  CLASS='multiControl' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>"
						+ "</TD>");

				sb.append("</tr>");
				sb.append("</table>");

			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentApprovalDeskHLP.getIndentDetailsForApproval() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}

	/**
	 * This method is used to Get Indent Details for All request
	 * 
	 * @param vo
	 * @return String
	 */

	public static String getIndentDetailsForApproval(IndentApprovalDeskVO vo) {

		StringBuffer sb = new StringBuffer("");

		try {
			WebRowSet ws = vo.getStrIndentDetailsWs();
			if (ws != null && ws.size() > 0) {
				if (ws.next()) {

					// String status = "";
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
					String strAgendaPeriodValue = ws.getString(13);

					if (strStoreName == null)
						strStoreName = "----";
					if (strItemCatg == null)
						strItemCatg = "----";
					if (strReqNo == null)
						strReqNo = "----";
					if (strIndentDate == null)
						strIndentDate = "----";
					if (strIndentType == null)
						strIndentType = "----";
					if (strToStore == null)
						strToStore = "----";
					if (strIndentStatus == null)
						strIndentStatus = "----";
					if (strIndentPeriod == null || strIndentPeriod.equals("0"))
						strIndentPeriod = "----";
					if (strAgendaPeriodValue == null
							|| strAgendaPeriodValue.equals("0"))
						strAgendaPeriodValue = "----";
					if (strApprovedBy == null)
						strApprovedBy = "----";
					if (strApprovedDate == null)
						strApprovedDate = "----";
					if (strApprovedlevel == null)
						strApprovedlevel = "----";

					/*
					 * if(strIndentStatus.equals("1")) { status ="Uregnt"; }
					 * else { status ="Normal"; }
					 */
					sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");

					sb.append("<tr><td width='25%' class='LABEL'>Request Type Name</td>");
					sb.append("<td colspan='3' width='25%' class='CONTROL'> ");
					sb.append(strIndentType);
					sb.append("</td></tr>");

					sb.append("<tr><td width='25%' class='LABEL'>Raising Store</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strStoreName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Receiving Store</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strToStore);
					sb.append("</td></tr>");

					sb.append("<tr><td width='25%' class='LABEL'>Req No</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strReqNo);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Req Date</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strIndentDate);
					sb.append("</td></tr>");

					sb.append("<tr><td width='25%' class='LABEL'>Item Category</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strItemCatg);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Req Period</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strIndentPeriod);
					if (!strAgendaPeriodValue.equals("0")) {
						sb.append("/");
						sb.append(strAgendaPeriodValue);

					}
					sb.append("</td></tr>");

					sb.append("</table>");
//					sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
//					sb.append("<tr>");
//					sb.append("<td width='5%' class='TITLE' align='center'><input type='hidden' name='button1' value='0'>");
//					sb.append("<img src='../../hisglobal/images/plus.gif'   id='plus1' title='Open Approval Details' style='display:block;cursor:pointer' onClick='ftn11()'>");
//					sb.append("<img src='../../hisglobal/images/minus.gif'  id='minus1' style='display:none;cursor:pointer' title='Close Approval Details' onClick='ftn11()'></td>");
//					sb.append("<td colspan='3' class='TITLE' align='left'><b>Last Approval Details</b></td>");
//					sb.append("</tr>");
//					sb.append("</table>");
//
//					sb.append("<div id='LastApprovalDtl' style='display:none'>");
//					sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
//					sb.append("<tr><td width='25%' class='LABEL'>Approved By</td>");
//					sb.append("<td width='25%' class='CONTROL'>");
//					sb.append(strApprovedBy);
//					sb.append("</td>");
//					sb.append("<td width='25%' class='LABEL'>Approved Date</td>");
//					sb.append("<td width='25%' class='CONTROL'>");
//					sb.append(strApprovedDate);
//					sb.append("</td></tr>");
//
//					sb.append("<tr><td width='25%' class='LABEL'>Approval Level</td>");
//					sb.append("<td width='25%' class='CONTROL'>");
//					sb.append(strApprovedlevel);
//					sb.append("</td>");
//					sb.append("<td width='25%' class='LABEL'></td>");
//					sb.append("<td width='25%' class='CONTROL'>");
//					sb.append("</td></tr>");
//					sb.append("</table>");
//					sb.append("</div>");

				}

			} else {
				sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
				sb.append("<tr>");
				sb.append("<td colspan='5'  CLASS='multiControl' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>"
						+ "</TD>");

				sb.append("</tr>");
				sb.append("</table>");

			}
		} catch (Exception e) {
			vo.setStrMsgString("IndentApprovalDeskHLP.getIndentDetailsForApproval() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}

	/**
	 * This method is used to Get Indent Details for Return To Supplier Request
	 * 
	 * @param vo
	 * @return String
	 */
	public static String getIndentDetailsReturnToSupplier(
			IndentApprovalDeskVO vo) {

		StringBuffer sb = new StringBuffer("");

		try {
			WebRowSet ws = vo.getStrIndentDetailsWs();
			if (ws != null && ws.size() > 0) {
				if (ws.next()) {

					// String status = "";
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
					String strReturnReson = ws.getString(12);
					String strPONo = ws.getString(13);
					String strPODate = ws.getString(14);
					String strPOTypeId = ws.getString(15);
					String strSupplierName = ws.getString(16);
					String strReturnFlag = ws.getString(17);
					String strDeliveryDate = ws.getString(18);
					vo.setStrDeliveryDate(strDeliveryDate);
					if (strStoreName == null)
						strStoreName = "----";
					if (strItemCatg == null)
						strItemCatg = "----";
					if (strReqNo == null)
						strReqNo = "----";
					if (strIndentDate == null)
						strIndentDate = "----";
					if (strIndentType == null)
						strIndentType = "----";
					if (strToStore == null)
						strToStore = "----";
					if (strIndentStatus == null)
						strIndentStatus = "----";
					if (strIndentPeriod == null || strIndentPeriod.equals("0"))
						strIndentPeriod = "----";
					if (strApprovedBy == null)
						strApprovedBy = "----";
					if (strApprovedDate == null)
						strApprovedDate = "----";
					if (strApprovedlevel == null)
						strApprovedlevel = "----";

					if (strReturnReson == null)
						strReturnReson = "----";

					if (strSupplierName == null)
						strSupplierName = "----";
					/*
					 * if(strIndentStatus.equals("1")) { status ="Uregnt"; }
					 * else { status ="Normal";
					 * 
					 * }
					 */
					sb.append("<table class='TABLEWIDTH'  align='center'  border='0'  cellspacing ='1px'>");
					sb.append("<input type='hidden' name ='strReturnFlag'  value='"
							+ strReturnFlag + "'>");
					sb.append("<input type='hidden' name ='strDeliveryDate'  value='"
							+ strDeliveryDate + "'>");

					sb.append("<tr><td width='25%' class='LABEL'>Request Type Name</td>");
					sb.append("<td colspan='3' width='25%' class='CONTROL'> ");
					sb.append(strIndentType);
					sb.append("</td></tr>");

					sb.append("<tr><td width='25%' class='LABEL'>Raising Store</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strStoreName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Supplier Name</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strSupplierName);
					sb.append("</td></tr>");

					sb.append("<tr><td width='25%' class='LABEL'>Return Req No</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strReqNo);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Return Req Date</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strIndentDate);
					sb.append("</td></tr>");

					sb.append("<tr><td width='25%' class='LABEL'>PO No</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strPONo);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>PO Date</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strPODate);
					sb.append("</td></tr>");

					sb.append("<tr><td width='25%' class='LABEL'>PO Type</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strPOTypeId);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'></td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append("</td></tr>");

					sb.append("</table>");
//					sb.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' border='0'  cellspacing ='1px'>");
//					sb.append("<tr>");
//					sb.append("<td width='5%' class='TITLE' align='center'><input type='hidden' name='button1' value='0'>");
//					sb.append("<img src='../../hisglobal/images/plus.gif'   id='plus1'  style='display:block;cursor:pointer' title='Open Approval Details' onClick='ftn11()'>");
//					sb.append("<img src='../../hisglobal/images/minus.gif'  id='minus1' style='display:none;cursor:pointer' title='Close Approval Details' onClick='ftn11()'></td>");
//					sb.append("<td colspan='3' class='TITLE' align='left'><b>Last Approval Details</b></td>");
//					sb.append("</tr>");
//					sb.append("</table>");
//
//					sb.append("<div id='LastApprovalDtl' style='display:none'>");
//					sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
//					sb.append("<tr><td width='25%' class='LABEL'>Approved By</td>");
//					sb.append("<td width='25%' class='CONTROL'>");
//					sb.append(strApprovedBy);
//					sb.append("</td>");
//					sb.append("<td width='25%' class='LABEL'>Approved Date</td>");
//					sb.append("<td width='25%' class='CONTROL'>");
//					sb.append(strApprovedDate);
//					sb.append("</td></tr>");
//
//					sb.append("<tr><td width='25%' class='LABEL'>Approval Level</td>");
//					sb.append("<td width='25%' class='CONTROL'>");
//					sb.append(strApprovedlevel);
//					sb.append("</td>");
//					sb.append("<td width='25%' class='LABEL'></td>");
//					sb.append("<td width='25%' class='CONTROL'>");
//					sb.append("</td></tr>");
//					sb.append("</table>");
//					sb.append("</div>");
				}

			} else {
				sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
				sb.append("<tr>");
				sb.append("<td colspan='5'  CLASS='multiControl' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>"
						+ "</TD>");

				sb.append("</tr>");
				sb.append("</table>");

			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentApprovalDeskHLP.getIndentDetailsReturnToSupplier() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}

	/**
	 * This method is used to Get Indent Details for Return To Supplier Request
	 * 
	 * @param vo
	 * @return String
	 */
	public static String getIndentDetailsReturnToSupplierView(
			IndentApprovalDeskVO vo) {

		StringBuffer sb = new StringBuffer("");

		try {
			WebRowSet ws = vo.getStrIndentDetailsWs();
			if (ws != null && ws.size() > 0) {
				if (ws.next()) {

					// String status = "";
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
					String strReturnReson = ws.getString(12);
					String strPONo = ws.getString(13);
					String strPODate = ws.getString(14);
					String strPOTypeId = ws.getString(15);
					String strSupplierName = ws.getString(16);
					String strReturnFlag = ws.getString(17);
					String strDeliveryDate = ws.getString(18);
					vo.setStrDeliveryDate(strDeliveryDate);
					if (strStoreName == null)
						strStoreName = "----";
					if (strItemCatg == null)
						strItemCatg = "----";
					if (strReqNo == null)
						strReqNo = "----";
					if (strIndentDate == null)
						strIndentDate = "----";
					if (strIndentType == null)
						strIndentType = "----";
					if (strToStore == null)
						strToStore = "----";
					if (strIndentStatus == null)
						strIndentStatus = "----";
					if (strIndentPeriod == null || strIndentPeriod.equals("0"))
						strIndentPeriod = "----";
					if (strApprovedBy == null)
						strApprovedBy = "----";
					if (strApprovedDate == null)
						strApprovedDate = "----";
					if (strApprovedlevel == null)
						strApprovedlevel = "----";

					if (strReturnReson == null)
						strReturnReson = "----";

					if (strSupplierName == null)
						strSupplierName = "----";
					/*
					 * if(strIndentStatus.equals("1")) { status ="Uregnt"; }
					 * else { status ="Normal";
					 * 
					 * }
					 */
					sb.append("<table class='TABLEWIDTH' align='center'   border='0'  cellspacing ='1px'>");
					sb.append("<input type='hidden' name ='strReturnFlag'  value='"
							+ strReturnFlag + "'>");
					sb.append("<input type='hidden' name ='strDeliveryDate'  value='"
							+ strDeliveryDate + "'>");

					sb.append("<tr><td width='25%' class='LABEL'>Request Type Name</td>");
					sb.append("<td colspan='3' width='25%' class='CONTROL'> ");
					sb.append(strIndentType);
					sb.append("</td></tr>");

					sb.append("<tr><td width='25%' class='LABEL'>Raising Store</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strStoreName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Supplier Name</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strSupplierName);
					sb.append("</td></tr>");

					sb.append("<tr><td width='25%' class='LABEL'>Return Req No</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strReqNo);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Return Req Date</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strIndentDate);
					sb.append("</td></tr>");

					sb.append("<tr><td width='25%' class='LABEL'>PO No</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strPONo);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>PO Date</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strPODate);
					sb.append("</td></tr>");

					sb.append("<tr><td width='25%' class='LABEL'>PO Type</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strPOTypeId);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Delivery Date</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strDeliveryDate);
					sb.append("</td></tr>");
					sb.append("</table>");

				}

			} else {
				sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
				sb.append("<tr>");
				sb.append("<td colspan='5'  CLASS='multiControl' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>"
						+ "</TD>");

				sb.append("</tr>");
				sb.append("</table>");

			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentApprovalDeskHLP.getIndentDetailsReturnToSupplier() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}

	/**
	 * This method is used to Get Indent Details for All request
	 * 
	 * @param vo
	 * @return String
	 */

	public static String getIndentDetails(IndentApprovalDeskVO vo) {

		StringBuffer sb = new StringBuffer("");

		try {
			WebRowSet ws = vo.getStrIndentDetailsWs();
			if (ws != null && ws.size() > 0) {
				if (ws.next()) {
					if (vo.getStrReqTypeId().equals("65")
							|| vo.getStrReqTypeId().equals("64")) {
						// String status = "";
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
						String strThirdPartyName = ws.getString(12);

						if (strStoreName == null)
							strStoreName = "----";
						if (strItemCatg == null)
							strItemCatg = "----";
						if (strReqNo == null)
							strReqNo = "----";
						if (strIndentDate == null)
							strIndentDate = "----";
						if (strIndentType == null)
							strIndentType = "----";
						if (strToStore == null)
							strToStore = "----";
						if (strIndentStatus == null)
							strIndentStatus = "----";
						if (strIndentPeriod == null
								|| strIndentPeriod.equals("0"))
							strIndentPeriod = "----";
						if (strApprovedBy == null)
							strApprovedBy = "----";
						if (strApprovedDate == null)
							strApprovedDate = "----";
						if (strApprovedlevel == null)
							strApprovedlevel = "----";

						if (strThirdPartyName == null)
							strThirdPartyName = "----";

						//sb.append("<table class='TABLEWIDTH' align='center'   border='0'  cellspacing ='1px'>");
						sb.append("<div class='row'><div class='col-sm-2'>Request Type Name</div>");
						sb.append("<div class='col-sm-2' style='font-weight: 400; '> ");
						sb.append(strIndentType);
						sb.append("</div>");

						//sb.append("<tr>");

						if (vo.getStrReqTypeId().equals("64")) {
							sb.append("<div class='col-sm-2'>Receving Store</div>");
						} else {
							sb.append("<div class='col-sm-2'>Raising Store</div>");

						}

						sb.append("<div class='col-sm-2' style='font-weight: 400; '>");
						sb.append(strStoreName);
						sb.append("</div>");
						sb.append("<div class='col-sm-2'>Third Party Name</div>");
						sb.append("<div class='col-sm-2' style='font-weight: 400; '>");
						sb.append(strThirdPartyName);
						sb.append("</div></div>");

						sb.append("<div class='row'><div class='col-sm-2'>Req No</div>");
						sb.append("<div class='col-sm-2' style='font-weight: 400; '>");
						sb.append(strReqNo);
						sb.append("</div>");
						sb.append("<div class='col-sm-2'>Req Date</div>");
						sb.append("<div class='col-sm-2' style='font-weight: 400; '>");
						sb.append(strIndentDate);
						sb.append("</div>");

						sb.append("<div class='col-sm-2'>Item Category</div>");
						sb.append("<div class='col-sm-2' style='font-weight: 400; '>");
						sb.append(strItemCatg);
						sb.append("</div>");
						//sb.append("<td width='25%' class='LABEL'></td>");
						//sb.append("<td width='25%' class='CONTROL'>");
						//sb.append("</td></tr>");
						//sb.append("</table>");
//						sb.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' border='0'  cellspacing ='1px'>");
//						sb.append("<tr>");
//						sb.append("<td width='5%' class='TITLE' align='center'><input type='hidden' name='button1' value='0'>");
//						sb.append("<img src='../../hisglobal/images/plus.gif'   id='plus1'  style='display:block;cursor:pointer' title='Open Approval Details' onClick='ftn11()'>");
//						sb.append("<img src='../../hisglobal/images/minus.gif'  id='minus1' style='display:none;cursor:pointer' title='Close Approval Details' onClick='ftn11()'></td>");
//						sb.append("<td colspan='3' class='TITLE' align='left'><b>Last Approval Details</b></td>");
//						sb.append("</tr>");
//						sb.append("</table>");
//
//						sb.append("<div id='LastApprovalDtl' style='display:none'>");
//						sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
//						sb.append("<tr><td width='25%' class='LABEL'>Approved By</td>");
//						sb.append("<td width='25%' class='CONTROL'>");
//						sb.append(strApprovedBy);
//						sb.append("</td>");
//						sb.append("<td width='25%' class='LABEL'>Approved Date</td>");
//						sb.append("<td width='25%' class='CONTROL'>");
//						sb.append(strApprovedDate);
//						sb.append("</td></tr>");
//
//						sb.append("<tr><td width='25%' class='LABEL'>Approval Level</td>");
//						sb.append("<td width='25%' class='CONTROL'>");
//						sb.append(strApprovedlevel);
//						sb.append("</td>");
//						sb.append("<td width='25%' class='LABEL'></td>");
//						sb.append("<td width='25%' class='CONTROL'>");
//						sb.append("</td></tr>");
//						sb.append("</table>");
//						sb.append("</div>");
					} else {

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
						String strUrgentFlag = ws.getString(14);
						String strRemarks = ws.getString(15);
						// String strReturnFlag = ws.getString(17);

						if (strStoreName == null)
							strStoreName = "----";
						if (strItemCatg == null)
							strItemCatg = "----";
						if (strReqNo == null)
							strReqNo = "----";
						if (strIndentDate == null)
							strIndentDate = "----";
						if (strIndentType == null)
							strIndentType = "----";
						if (strToStore == null)
							strToStore = "----";
						if (strIndentStatus == null)
							strIndentStatus = "----";
						if (strIndentPeriod == null
								|| strIndentPeriod.equals("0"))
							strIndentPeriod = "----";
						if (strApprovedBy == null)
							strApprovedBy = "----";
						if (strApprovedDate == null)
							strApprovedDate = "----";
						if (strApprovedlevel == null)
							strApprovedlevel = "----";

						if (strIndentPeriodValue == null
								|| strIndentPeriodValue.equals(""))
							strIndentPeriodValue = "----";

						if (strIndentStatus.equals("1")) {
							status = "Uregnt";
						} else {
							status = "Normal";
						}
						// sb.append("<input type='hidden' name ='strReturnFlag'  value='"+strReturnFlag+"'>");
						//sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
						sb.append("<div class='row'><div class='col-sm-2'>Request Type Name</div>");
						sb.append("<div class='col-sm-2' style='font-weight: 400; '>");
						sb.append(strIndentType);
						sb.append("</div>");
						sb.append("<div class='col-sm-2'>Item Category</div>");
						sb.append("<div class='col-sm-2' style='font-weight: 400; '>");
						sb.append(strItemCatg);
						
						sb.append("</div>");

						sb.append("<div class='col-sm-2'>Raising Store</div>");
						sb.append("<div class='col-sm-2' style='font-weight: 400; '>");
						sb.append(strStoreName);
						sb.append("</div></div>");
						sb.append("<div class='row'><div class='col-sm-2'>Receiving Store</div>");
						sb.append("<div class='col-sm-2' style='font-weight: 400; '>");
						sb.append(strToStore);
						sb.append("</div>");

						sb.append("<div class='col-sm-2'>Req No</div>");
						sb.append("<div class='col-sm-2' style='font-weight: 400; '>");
						sb.append(strReqNo);
						sb.append("</div>");
						sb.append("<div class='col-sm-2'>Req Date</div>");
						sb.append("<div class='col-sm-2' style='font-weight: 400; '>");
						sb.append(strIndentDate);
						sb.append("</div></div>");

						sb.append("<div class='row'><div class='col-sm-2'>Req Status</div>");
						sb.append("<div class='col-sm-2' style='font-weight: 400; '>");
						sb.append(strUrgentFlag);
						sb.append("</div>");
						sb.append("<div class='col-sm-2'>Req Period</div>");
						sb.append("<div class='col-sm-2' style='font-weight: 400; '>");
						sb.append(strIndentPeriod);
						if (!strIndentPeriodValue.equals("0")) {
							sb.append("/");
							sb.append(strIndentPeriodValue);
						}
						sb.append("</div>");
						sb.append("<div class='col-sm-2'>Remarks</div>");
						sb.append("<div class='col-sm-2' style='font-weight: 400; '>");
						sb.append(strRemarks);
						sb.append("</div>");
						//sb.append("<td width='25%' class='LABEL'>Req Period</td>");
						//sb.append("<td width='25%' class='CONTROL'>");
						//sb.append(strIndentPeriod);
						sb.append("</div>");

//						sb.append("<td width='25%' class='LABEL'></td>");
//						sb.append("<td width='25%' class='CONTROL'>");
//						sb.append("</td></tr>");
						//sb.append("</table>");
//						sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
//						sb.append("<tr>");
//						sb.append("<td width='5%' class='TITLE' align='center'><input type='hidden' name='button1' value='0'>");
//						sb.append("<img src='../../hisglobal/images/plus.gif'   id='plus1'  style='display:block;cursor:pointer' title='Open Approval Details' onClick='ftn11()'>");
//						sb.append("<img src='../../hisglobal/images/minus.gif'  id='minus1' style='display:none;cursor:pointer' title='Close Approval Details' onClick='ftn11()'></td>");
//						sb.append("<td colspan='3' class='TITLE' align='left'><b>Last Approval Details</b></td>");
//						sb.append("</tr>");
//						sb.append("</table>");
//
//						sb.append("<div id='LastApprovalDtl' style='display:none'>");
//						sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
//						sb.append("<tr><td width='25%' class='LABEL'>Approved By</td>");
//						sb.append("<td width='25%' class='CONTROL'>");
//						sb.append(strApprovedBy);
//						sb.append("</td>");
//						sb.append("<td width='25%' class='LABEL'>Approved Date</td>");
//						sb.append("<td width='25%' class='CONTROL'>");
//						sb.append(strApprovedDate);
//						sb.append("</td></tr>");
//
//						sb.append("<tr><td width='25%' class='LABEL'>Approval Level</td>");
//						sb.append("<td width='25%' class='CONTROL'>");
//						sb.append(strApprovedlevel);
//						sb.append("</td>");
//						sb.append("<td width='25%' class='LABEL'></td>");
//						sb.append("<td width='25%' class='CONTROL'>");
//						sb.append("</td></tr>");
//						sb.append("</table>");
//						sb.append("</div>");

					}

				}
			} else {
				sb.append("<table class='table' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
				sb.append("<tbody>");
				sb.append("<td colspan='5'>"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>"
						+ "</TD>");

				sb.append("</tbody>");
				sb.append("</table>");

			}
		} catch (Exception e) {

			vo.setStrMsgString("IndentApprovalDeskHLP.getIndentDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}

	/****************** View Method Start from Here ***********************/
	/**
	 * This method is used to Get Item Details for View Page
	 * 
	 * @param vo
	 * @return String
	 */
	public static String getItemDetailsView1(IndentApprovalDeskVO vo) {
		StringBuffer sb = new StringBuffer("");
		String strHiddenValue = "";
		WebRowSet ws1 = vo.getStrItemDetailsWs();
		String strRemarks = "";
		int i = 0, k = 0;
		try {

			if (ws1 != null && ws1.size() > 0) {
				String strCrNo = null;
				String strPatName = null;
				String strEmpID = null;
				String strEmpName = null;
				if (k == 0) {
					while (ws1.next())

					{

						if (vo.getStrReqTypeId().equals("14")) {
							strCrNo = ws1.getString(10);
							strPatName = ws1.getString(11);
							strEmpID = ws1.getString(12);
							strEmpName = ws1.getString(13);
							strRemarks = ws1.getString(21);

						}
						if (vo.getStrReqTypeId().equals("12")
								|| vo.getStrReqTypeId().equals("13")) {
							strCrNo = ws1.getString(8);
							strPatName = ws1.getString(9);
							strEmpID = ws1.getString(10);
							strEmpName = ws1.getString(11);
							strRemarks = ws1.getString(19);

						}
						if (vo.getStrReqTypeId().equals("13")) {
							strCrNo = ws1.getString(8);
							strPatName = ws1.getString(9);
							strEmpID = ws1.getString(10);
							strEmpName = ws1.getString(11);
							strRemarks = ws1.getString(19);

						}
						if (vo.getStrReqTypeId().equals("10")) {
							strCrNo = ws1.getString(10);
							strPatName = ws1.getString(11);
							strEmpID = ws1.getString(12);
							strEmpName = ws1.getString(13);
							strRemarks = ws1.getString(21);
						}

						if (strCrNo == null || strCrNo.equals("")
								|| strCrNo.equals("0"))
							strCrNo = "-------";
						if (strPatName == null || strPatName.equals(""))
							strPatName = "-------";
						if (strEmpID == null || strEmpID.equals("")
								|| strEmpID.equals("0"))
							strEmpID = "-------";
						if (strEmpName == null || strEmpName.equals(""))
							strEmpName = "-------";

						if (!vo.getStrReqTypeId().equals("14")) {
							if (!vo.getStrReqTypeId().equals("10")) {
								if (k == 0) {
									sb.append("<table class='table'>");
									sb.append("<tr><td  width='25%' align='right' style='font-weight:350 !important ;font-size: 16px !important;' >CR NO</td>");
									sb.append("<td width='25%' style='font-weight:350 !important ;font-size: 16px !important;'>");
									sb.append(strCrNo);
									sb.append("</td>");
									sb.append("<td width='25%' align='right' style='font-weight:350 !important ;font-size: 16px !important;'>Patient Name</td>");
									sb.append("<td width='25%' style='font-weight:350 !important ;font-size: 16px !important;'>");
									sb.append(strPatName);
									sb.append("</td></tr>");
									if (vo.getStrReqTypeId().equals("12")) {
										sb.append("<tr><td width='25%' align='right' style='font-weight:350 !important ;font-size: 16px !important;' >Emp ID</td>");
										sb.append("<td width='25%' style='font-weight:350 !important ;font-size: 16px !important;'>");
										sb.append(strEmpID);
										sb.append("</td>");
										sb.append("<td width='25%' align='right' style='font-weight:350 !important ;font-size: 16px !important;' >Emp Name</td>");
										sb.append("<td width='25%' style='font-weight:350 !important ;font-size: 16px !important;'>");
										sb.append(strEmpName);
										sb.append("</td></tr>");
									}

								}
								k++;
							}
						}
					}
					sb.append("</table>");
				}
			}

			ws1.beforeFirst();

			sb.append("<table class='table'>");
			sb.append("<thead class='thead-dark'>");
			sb.append("<tr>");
			sb.append("<th width='30%' align='right' style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</th>");
			//sb.append("<td width='20%' class='multiLabel'>Avl Qty</td>");
			sb.append("<th width='25%' align='right' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</th>");
			sb.append("<th width='25%' align='right' style='font-weight:350 !important ;font-size: 16px !important;' >Sanction Qty</th>");
			sb.append("<th width='10%' align='right' style='font-weight:350 !important ;font-size: 16px !important;' >Rate/Unit</th>");
			sb.append("<th width='10%' align='right' style='font-weight:350 !important ;font-size: 16px !important;' >Remarks</th></tr>");
			sb.append("</thead>");

			if (ws1 != null && ws1.size() > 0) {
				String strItemName = null;
				String strAvlQty = null;
				String strReqQty = null;
				String strSancQty = null;
				String strRate = null;
				String strIssueQty = null;
				String strRetQty = null;
				String strLstRecevDate = null;
				String strLstRecevQty = null;
				String strLstRetQtyUnitId = null;
				while (ws1.next()) {
					if (vo.getStrReqTypeId().equals("10")) {
						strIssueQty = ws1.getString(1);
						strLstRecevQty = ws1.getString(2);
						strLstRecevDate = ws1.getString(3);
						strLstRetQtyUnitId = ws1.getString(4);
						strItemName = ws1.getString(5);
						strAvlQty = ws1.getString(6);
						strReqQty = ws1.getString(7);
						strSancQty = ws1.getString(8);
						strRate = ws1.getString(9);
						strRemarks = ws1.getString(21);

						strHiddenValue = strIssueQty + "^" + strLstRecevQty
								+ "^" + strLstRecevDate + "^"
								+ strLstRetQtyUnitId;
					}

					if (vo.getStrReqTypeId().equals("12")
							|| vo.getStrReqTypeId().equals("13")) {
						strIssueQty = ws1.getString(1);
						strRetQty = ws1.getString(2);
						strItemName = ws1.getString(3);
						strAvlQty = ws1.getString(4);
						strReqQty = ws1.getString(5);
						strSancQty = ws1.getString(6);
						strRate = ws1.getString(7);
						strHiddenValue = strIssueQty + "^" + strRetQty;
						strRemarks = ws1.getString(19);

					}
					if (vo.getStrReqTypeId().equals("14")) {
						strIssueQty = ws1.getString(1);
						strLstRecevQty = ws1.getString(2);
						strLstRecevDate = ws1.getString(3);
						strLstRetQtyUnitId = ws1.getString(4);
						strItemName = ws1.getString(5);
						strAvlQty = ws1.getString(6);
						strReqQty = ws1.getString(7);
						strSancQty = ws1.getString(8);
						strRate = ws1.getString(9);
						strRemarks = ws1.getString(21);

						strHiddenValue = strIssueQty + "^" + strLstRecevQty
								+ "^" + strLstRecevDate + "^"
								+ strLstRetQtyUnitId;
					}

					if (strItemName == null || strItemName.equals(""))
						strItemName = "-----";
					if (strAvlQty == null || strAvlQty.equals(""))
						strAvlQty = "-----";
					if (strReqQty == null || strReqQty.equals(""))
						strReqQty = "-----";
					if (strSancQty == null || strSancQty.equals(""))
						strSancQty = "-----";
					if (strRate == null || strRate.equals(""))
						strRate = "-----";
					sb.append("<tbody>");
					sb.append("<input type='hidden' name ='strHiddenValue'  value='"
							+ strHiddenValue + "'>");
					sb.append("<tr>");
					sb.append("<td width='30%' align='left' style='font-weight:350 !important ;font-size: 16px !important;' >");
					sb.append("<a name='tarriff' value=''STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Item Details' onClick='callingPoPUp(this,"
							+ i
							+ ",\""
							+ strHiddenValue
							+ "\",\""
							+ vo.getStrReqTypeId()
							+ "\");'>"
							+ strItemName
							+ "</a>");
					sb.append("</td>");
//					sb.append("<td width='20%' class='multiControl'>");
//					sb.append(strAvlQty);
//					sb.append("</td>");
				
					sb.append("<td width='25%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>");
					sb.append(strReqQty);
					sb.append("</td>");

					sb.append("<td width='25%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>");
					sb.append(strSancQty);
					sb.append("</td>");
					
					sb.append("<td  width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>");
					sb.append(strRate);
					sb.append("</td>");
					
					sb.append("<td align='center' style='font-weight:350 !important ;font-size: 16px !important;' width='10%'><a value='' style='cursor:pointer;' onClick='openDivItem(this,"
							+ i
							+ ");' title='Click here to Enter Remarks' style='cursor:pointer;'><font color='blue'>#</font></a>");
					
					sb.append("<div id='remarksId" + i
							+ "' class='popup' style='display:none'>");
				
					sb.append("<table width='400' align='center'>");
					sb.append("<tr class='HEADER'><th align='left'>Remarks For "
							+ strItemName + "</th>");
					sb.append("<th align='right'><img  style='cursor:pointer;' src='../../hisglobal/images/popUp_cancel.JPG'");
					sb.append(" onClick='closeDivItem("
							+ i
							+ ");' title='Click Here To Close Popup'></th></tr>");
					sb.append("</table>");
					
					sb.append("<table width='400' align='center' cellspacing='1px' cellpadding='1px'>");
					sb.append("<tr><td class='LABEL' width='25%'>Remarks</td>");
					sb.append("<td class='CONTROL' width='75%'> <textarea  cols='20' rows='2' readOnly='readOnly' >"
							+ strRemarks + "</textarea></td>");
					sb.append("</tr>");
					sb.append("<tr class='FOOTER'><td colspan='2'></td></tr>");
					sb.append("</table>");
					
					sb.append("</div></td>");
					sb.append("</tr>");
					i++;
				}
				sb.append("</tbody>");
				sb.append("</table>");
			}

			else {
				sb.append("<table class='table'>");
				sb.append("<tr>");
				sb.append("<td colspan='6'  align='center' style='font-weight:350 !important ;font-size: 16px !important;' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>"
						+ "</TD>");

				sb.append("</tr>");
				sb.append("</table>");

			}
			vo.setStrMultiRow(i + "");
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentApprovalDeskHLP.getItemDetailsView1() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}

	/**
	 * This method is used to Get Item Details for view Page
	 * 
	 * @param vo
	 * @return String
	 */

	public static String getItemDetailsViewReturnToSupplier(
			IndentApprovalDeskVO vo) {
		StringBuffer sb = new StringBuffer("");
		String strHiddenValue = "";
		WebRowSet ws1 = vo.getStrItemDetailsWs();
		int i = 0;
		try {
			sb.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC'  border='0' cellspacing ='1px'>");

			sb.append("<tr>");
			sb.append("<td width='20%' class='multiLabel'>Item Name</td>");
		//	sb.append("<td width='20%' class='multiLabel'>Available Qty</td>");
			sb.append("<td width='20%' class='multiLabel'>Req Qty</td>");
			sb.append("<td width='20%' class='multiLabel'>Approved Qty</td>");
			sb.append("<td width='20%' class='multiLabel'>Rate/Unit</td>");
			sb.append("</tr>");

			if (ws1 != null) {
				String strItemName = null;
				String strAvlQty = null;
				String strReqQty = null;
				String strSancQty = null;
				String strRate = null;
				/*
				 * String strIssueQty = null; String strReOrderLevel = null;
				 * String strLstIndentQty = null; String strLstIssueQty = null;
				 * String strLstYerConsump = null; String strLstPoNo = null;
				 * String strLstPODate = null; String strLstRecQty = null;
				 * String strLstRecDate = null; String strLstSupplBy =null;
				 */
				String strExpDate = null;
				/*
				 * String strGrpName = null; String strSubGrpName = null;
				 */
				String strBatchNo = null;
				/*
				 * String strItemId = null; String strItemBrandId = null;
				 */
				String strManufactrerDate = null;

				/*
				 * String strProcSancQty = null; String strProcSancQtyUnitId =
				 * null; String strProcIndentQty = null; String
				 * strProcIndentQtyUnit = null; String strItemSlNo = null;
				 * String strStockStatusCode = null; String strInHandQty =null;
				 */

				while (ws1.next()) {
					if (vo.getStrReqTypeId().equals("47")) {

						strManufactrerDate = ws1.getString(1);
						strExpDate = ws1.getString(2);
						strBatchNo = ws1.getString(3);
						strItemName = ws1.getString(4);
						strAvlQty = ws1.getString(5);
						strReqQty = ws1.getString(6);
						// strSancQty = ws1.getString(7);
						strRate = ws1.getString(8);
						/*
						 * strItemId = ws1.getString(9); strItemBrandId =
						 * ws1.getString(10); strProcIndentQty =
						 * ws1.getString(11); strProcIndentQtyUnit =
						 * ws1.getString(12); strProcSancQty =
						 * ws1.getString(13); strProcSancQtyUnitId =
						 * ws1.getString(14); // strCost = ws1.getString(15);
						 * strItemSlNo = ws1.getString(17); strStockStatusCode =
						 * ws1.getString(18);
						 */
						strBatchNo = ws1.getString(19);
						// strInHandQty = ws1.getString(20);
						strHiddenValue = strRate + "^" + strManufactrerDate
								+ "^" + strExpDate;

					}

					if (strItemName == null || strItemName.equals(""))
						strItemName = "-----";
					if (strAvlQty == null || strAvlQty.equals(""))
						strAvlQty = "-----";
					if (strReqQty == null || strReqQty.equals(""))
						strReqQty = "-----";
					if (strSancQty == null || strSancQty.equals(""))
						strSancQty = "-----";
					if (strRate == null || strRate.equals(""))
						strRate = "-----";
					if (strBatchNo == null || strBatchNo.equals(""))
						strBatchNo = "-----";
					if (strExpDate == null || strExpDate.equals(""))
						strExpDate = "-----";

					if (vo.getStrReqTypeId().equals("47")) {

						sb.append("<input type='hidden' name ='strHiddenValue'  value='"
								+ strHiddenValue + "'>");
						sb.append("<tr>");
						sb.append("<td width='20%' class='multiControl'>");
						sb.append("<a name='tarriff' value='' STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Item Details' onClick='callingPoPUp(this,"
								+ i
								+ ",\""
								+ strHiddenValue
								+ "\",\""
								+ vo.getStrReqTypeId()
								+ "\");'>"
								+ strItemName
								+ "</a>");
						sb.append("</td>");
//						sb.append("<td width='20%' class='multiControl'>");
//						sb.append(strAvlQty);
//						sb.append("</td>");
						sb.append("<td width='20%' class='multiControl'>");
						sb.append(strReqQty);
						sb.append("</td>");

						sb.append("<td width='20%' class='multiControl'>");
						sb.append(strSancQty);
						sb.append("</td>");
						sb.append("<td  width='20%' class='multiControl'>");
						sb.append(strRate);
						sb.append("</td>");
						sb.append("</tr>");
					}
					i++;
				}
				sb.append("</table>");

			} else {
				sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
				sb.append("<tr>");
				sb.append("<td colspan='5'  CLASS='multiControl' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>"
						+ "</TD>");

				sb.append("</tr>");
				sb.append("</table>");

			}
		} catch (Exception e) {
			vo.setStrMsgString("IndentApprovalDeskHLP.getItemDetailsView() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}

	/**
	 * This method is used to Get Item Details for view Page
	 * 
	 * @param vo
	 * @return String
	 */

	public static String getItemDetailsView(IndentApprovalDeskVO vo) {
		StringBuffer sb = new StringBuffer("");
		String strHiddenValue = "";
		WebRowSet ws1 = vo.getStrItemDetailsWs();
		String strRemarks = "";
		int i = 0;
		try {
			sb.append("<table class='table'>");
			if (vo.getStrReqTypeId().equals("65")
					|| vo.getStrReqTypeId().equals("19")
					|| vo.getStrReqTypeId().equals("16")
					|| vo.getStrReqTypeId().equals("18")) {
				sb.append("<thead class='thead-dark' >");
				sb.append("<tr>");
				sb.append("<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</th>");
				sb.append("<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Batch No</th>");
			//	sb.append("<th width='15%' class='multiLabel'>Avl Qty</th>");
				sb.append("<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</th>");
				sb.append("<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Approved Qty</th>");
				sb.append("<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Rate/Unit</th>");
				sb.append("<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Remarks</th>");
				sb.append("</tr>");
				sb.append("</thead>");


			} else {
				sb.append("<thead class='thead-dark'>");
				sb.append("<tr>");
				sb.append("<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</th>");
			//	sb.append("<th width='20%' class='multiLabel'>Available Qty</th>");
				sb.append("<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</th>");
				sb.append("<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Approved Qty</th>");
				sb.append("<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Rate/Unit</th>");
				sb.append("<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Remarks</th>");
				sb.append("</tr>");
				sb.append("</thead>");
			}

			if (ws1 != null) {
				String strItemName = null;
				String strAvlQty = null;
				String strReqQty = null;
				String strSancQty = null;
				String strRate = null;
				String strIssueQty = null;
				String strReOrderLevel = null;
				String strLstIndentQty = null;
				String strLstIssueQty = null;
				String strLstYerConsump = null;
				String strLstPoNo = null;
				String strLstPODate = null;
				String strLstRecQty = null;
				String strLstRecDate = null;
				String strLstSupplBy = null;
				String strExpDate = null;
				String strGrpName = null;
				String strSubGrpName = null;
				String strBatchNo = null;
				String strItemId = null;
				String strItemBrandId = null;
				String strManufactrerDate = null;

				/*
				 * String strProcSancQty = null; String strProcSancQtyUnitId =
				 * null; String strProcIndentQty = null; String
				 * strProcIndentQtyUnit = null; String strItemSlNo = null;
				 * String strStockStatusCode = null; String strInHandQty =null;
				 */

				while (ws1.next()) {
					if (vo.getStrReqTypeId().equals("47")) {

						strManufactrerDate = ws1.getString(1);
						strExpDate = ws1.getString(2);
						strBatchNo = ws1.getString(3);
						strItemName = ws1.getString(4);
						strAvlQty = ws1.getString(5);
						strReqQty = ws1.getString(6);
						// strSancQty = ws1.getString(7);
						strRate = ws1.getString(8);
						strItemId = ws1.getString(9);
						strItemBrandId = ws1.getString(10);
						/*
						 * strProcIndentQty = ws1.getString(11);
						 * strProcIndentQtyUnit = ws1.getString(12);
						 * strProcSancQty = ws1.getString(13);
						 * strProcSancQtyUnitId = ws1.getString(14);
						 */
						// strCost = ws1.getString(15);
						// strItemSlNo = ws1.getString(17);
						// strStockStatusCode = ws1.getString(18);
						strBatchNo = ws1.getString(19);
						// strInHandQty = ws1.getString(20);
						strHiddenValue = strRate + "^" + strManufactrerDate
								+ "^" + strExpDate;

					}

					if (vo.getStrReqTypeId().equals("11")
							|| vo.getStrReqTypeId().equals("80")
							|| vo.getStrReqTypeId().equals("81")
							|| vo.getStrReqTypeId().equals("83")
							|| vo.getStrReqTypeId().equals("84")|| vo.getStrReqTypeId().equals("86")|| vo.getStrReqTypeId().equals("90")) {
						strLstPoNo = ws1.getString(1);
						strLstPODate = ws1.getString(2);
						strLstRecDate = ws1.getString(3);
						strLstSupplBy = ws1.getString(4);
						strLstYerConsump = ws1.getString(5);
						strReOrderLevel = ws1.getString(6);
						strLstRecQty = ws1.getString(7);

						strItemName = ws1.getString(8);
						strAvlQty = ws1.getString(9);
						strReqQty = ws1.getString(10);
						strSancQty = ws1.getString(11);
						strRate = ws1.getString(12);
						strRemarks = ws1.getString(20);
						strHiddenValue = strLstPoNo + "^" + strLstPODate + "^"
								+ strLstRecDate + "^" + strLstSupplBy + "^"
								+ strLstYerConsump + "^" + strReOrderLevel
								+ "^" + strLstRecQty;

					}
					if (vo.getStrReqTypeId().equals("16")
							|| vo.getStrReqTypeId().equals("19")) {
						strLstPoNo = ws1.getString(1);
						strLstPODate = ws1.getString(2);
						strLstRecDate = ws1.getString(3);
						strExpDate = ws1.getString(4);
						strLstSupplBy = ws1.getString(5);
						strGrpName = ws1.getString(6);
						strSubGrpName = ws1.getString(7);
						strBatchNo = ws1.getString(8);

						strItemName = ws1.getString(9);
						strAvlQty = ws1.getString(10);
						strReqQty = ws1.getString(11);
						strSancQty = ws1.getString(12);
						strRate = ws1.getString(13);
						strRemarks = ws1.getString(24);
						strHiddenValue = strLstPoNo + "^" + strLstPODate + "^"
								+ strLstRecDate + "^" + strExpDate + "^"
								+ strLstSupplBy + "^" + strGrpName + "^"
								+ strSubGrpName;
					}

					if (vo.getStrReqTypeId().equals("15")
							|| vo.getStrReqTypeId().equals("82")) {
						strLstPoNo = ws1.getString(1);
						strLstPODate = ws1.getString(2);
						strLstRecDate = ws1.getString(3);
						strLstSupplBy = ws1.getString(4);
						strGrpName = ws1.getString(5);
						strSubGrpName = ws1.getString(6);

						strItemName = ws1.getString(7);
						strAvlQty = ws1.getString(8);
						strReqQty = ws1.getString(9);
						strSancQty = ws1.getString(10);
						strRate = ws1.getString(11);
						strRemarks = ws1.getString(19);
						strHiddenValue = strLstPoNo + "^" + strLstPODate + "^"
								+ strLstRecDate + "^" + strLstSupplBy + "^"
								+ strGrpName + "^" + strSubGrpName;
					}

					if (vo.getStrReqTypeId().equals("18")) {
						strLstPoNo = ws1.getString(1);
						strLstPODate = ws1.getString(2);
						strGrpName = ws1.getString(3);
						strSubGrpName = ws1.getString(4);
						strExpDate = ws1.getString(5);
						strBatchNo = ws1.getString(6);
						strItemName = ws1.getString(7);
						strAvlQty = ws1.getString(8);
						strReqQty = ws1.getString(9);
						strSancQty = ws1.getString(10);
						strRate = ws1.getString(11);
						strRemarks = ws1.getString(23);
						strHiddenValue = strLstPoNo + "^" + strLstPODate + "^"
								+ strLstRecDate + "^" + strGrpName + "^"
								+ strSubGrpName + "^" + strExpDate;
					}
					if (vo.getStrReqTypeId().equals("17")) {
						strIssueQty = ws1.getString(1);
						strReOrderLevel = ws1.getString(2);
						strLstIndentQty = ws1.getString(3);
						strLstIssueQty = ws1.getString(4);
						strItemName = ws1.getString(5);
						strAvlQty = ws1.getString(6);
						strReqQty = ws1.getString(7);
						strSancQty = ws1.getString(11);
						strRate = ws1.getString(9);
						strRemarks = ws1.getString(18);
						strHiddenValue = strIssueQty + "^" + strReOrderLevel
								+ "^" + strLstIndentQty + "^" + strLstIssueQty;
					}
					if (vo.getStrReqTypeId().equals("61")) {
						strLstPoNo = ws1.getString(1);
						strLstPODate = ws1.getString(2);
						strLstRecQty = ws1.getString(3);
						strLstRecDate = ws1.getString(4);
						strLstSupplBy = ws1.getString(5);
						strItemName = ws1.getString(6);
						strAvlQty = ws1.getString(7);
						strReqQty = ws1.getString(8);
						strSancQty = ws1.getString(9);
						strRate = ws1.getString(10);
						strItemId = ws1.getString(11);
						strItemBrandId = ws1.getString(12);
						strRemarks = ws1.getString(18);
						// strProcIndentQty = ws1.getString(13);
						// strProcIndentQtyUnit = ws1.getString(14);
						// strProcSancQty = ws1.getString(15);
						// strProcSancQtyUnitId = ws1.getString(16);
						strHiddenValue = strLstPoNo + "^" + strLstPODate + "^"
								+ strLstRecQty + "^" + strLstRecDate + "^"
								+ strLstSupplBy;
					}

					if (vo.getStrReqTypeId().equals("65")) {
						strExpDate = ws1.getString(1);
						strBatchNo = ws1.getString(2);
						strItemName = ws1.getString(3);
						strAvlQty = ws1.getString(4);
						strReqQty = ws1.getString(5);
						strSancQty = ws1.getString(6);
						strRate = ws1.getString(7);

						strItemId = ws1.getString(8);
						strItemBrandId = ws1.getString(9);
						strRemarks = ws1.getString(18);

						// strProcIndentQty = ws1.getString(10);
						// strProcIndentQtyUnit = ws1.getString(11);

						// strProcSancQty = ws1.getString(12);
						// strProcSancQtyUnitId = ws1.getString(13);

						strHiddenValue = strRate + "^" + strExpDate + "^"
								+ strBatchNo + "^" + strItemId + "^"
								+ strItemBrandId;
					}

					if (strItemName == null || strItemName.equals(""))
						strItemName = "-----";
					if (strAvlQty == null || strAvlQty.equals(""))
						strAvlQty = "-----";
					if (strReqQty == null || strReqQty.equals(""))
						strReqQty = "-----";
					if (strSancQty == null || strSancQty.equals(""))
						strSancQty = "-----";
					if (strRate == null || strRate.equals(""))
						strRate = "-----";
					if (strBatchNo == null || strBatchNo.equals(""))
						strBatchNo = "-----";
					if (strExpDate == null || strExpDate.equals(""))
						strExpDate = "-----";

					if (vo.getStrReqTypeId().equals("65")
							|| vo.getStrReqTypeId().equals("19")
							|| vo.getStrReqTypeId().equals("16")
							|| vo.getStrReqTypeId().equals("18")) {

						sb.append("<input type='hidden' name ='strHiddenValue'  value='"
								+ strHiddenValue + "'>");
						sb.append("<tbody>");
						sb.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>");
						sb.append("<a name='tarriff' value='' STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Item Details' onClick='callingPoPUp(this,"
								+ i
								+ ",\""
								+ strHiddenValue
								+ "\",\""
								+ vo.getStrReqTypeId()
								+ "\");'>"
								+ strItemName
								+ "</a>");
						sb.append("</td>");
						sb.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>");
						sb.append(strBatchNo);
						sb.append("</td>");
//						sb.append("<td width='15%' class='multiControl'>");
//						sb.append(strAvlQty);
//						sb.append("</td>");
						sb.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>");
						sb.append(strReqQty);
						sb.append("</td>");

						sb.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>");
						sb.append(strSancQty);
						sb.append("</td>");
						sb.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>");
						sb.append(strRate);
						sb.append("</td>");

						sb.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;'><a value='' style='cursor:pointer;'  onClick='openDivItem(this,"
								+ i
								+ ");' title='Click here to Enter Remarks' style='cursor:pointer;'><font color='blue'>#</font></a>");
						sb.append("<div id='remarksId" + i
								+ "' class='popup' style='display:none'>");
						sb.append("<table width='400' align='center'>");
						sb.append("<tr class='HEADER'><th align='left'>Remarks For "
								+ strItemName + "</th>");
						sb.append("<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'");
						sb.append(" onClick='closeDivItem("
								+ i
								+ ");' title='Click Here To Close Popup'></th></tr>");
						sb.append("</table>");
						sb.append("<table width='400' align='center' cellspacing='1px' cellpadding='1px'>");
						sb.append("<tr><td class='LABEL' width='25%'>Remarks</td>");
						sb.append("<td class='CONTROL' width='75%'> <textarea  cols='20' rows='2' readOnly='readOnly' >"
								+ strRemarks + "</textarea></td>");
						sb.append("</tr>");
						//sb.append("<tr class='FOOTER'><td colspan='2'></td></tr>");
						sb.append("</table>");
						sb.append("</div></td></tbody>");

					} else {
						sb.append("<input type='hidden' name ='strHiddenValue'  value='"
								+ strHiddenValue + "'>");
						sb.append("<tbody>");
						sb.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>");
						sb.append("<a name='tarriff' value='' STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Item Details' onClick='callingPoPUp(this,"
								+ i
								+ ",\""
								+ strHiddenValue
								+ "\",\""
								+ vo.getStrReqTypeId()
								+ "\");'>"
								+ strItemName
								+ "</a>");
						sb.append("</td>");
//						sb.append("<td width='20%' class='multiControl'>");
//						sb.append(strAvlQty);
//						sb.append("</td>");
						sb.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>");
						sb.append(strReqQty);
						sb.append("</td>");

						sb.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>");
						sb.append(strSancQty);
						sb.append("</td>");
						sb.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>");
						sb.append(strRate);
						sb.append("</td>");
						sb.append("</td>");

						sb.append("<td scope='col' style='font-weight:350 !important ;font-size: 16px !important;'><a value=''  onClick='openDivItem(this,"
								+ i
								+ ");' title='Click here to View Remarks' style='cursor:pointer'><font color='blue'>#</font></a>");
						sb.append("<div id='remarksId" + i
								+ "' class='popup' style='display:none'>");
						sb.append("<table width='400' align='center'>");
						sb.append("<tr class='HEADER'><th align='left'>Remarks For "
								+ strItemName + "</th>");
						sb.append("<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'");
						sb.append(" onClick='closeDivItem("
								+ i
								+ ");' title='Click Here To Close Popup'></th></tr>");
						sb.append("</table>");
						sb.append("<table width='400' align='center' cellspacing='1px' cellpadding='1px'>");
						sb.append("<tr><td class='LABEL' width='25%'>Remarks</td>");
						sb.append("<td class='CONTROL' width='75%'> <textarea  cols='20' rows='2' readOnly='readOnly' >"
								+ strRemarks + "</textarea></td>");
						sb.append("</tr>");
						//sb.append("<tr class='FOOTER'><td colspan='2'></td></tr>");
						sb.append("</table>");
						sb.append("</div></td>");
						sb.append("</tbody>");

					}
					i++;
				}
				sb.append("</table>");

			} else {
				sb.append("<table class='table'>");
				sb.append("<tr>");
				sb.append("<td colspan='6'  scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>"
						+ "</td>");

				sb.append("</tr>");
				sb.append("</table>");

			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentApprovalDeskHLP.getItemDetailsView() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}

	public static String getIndentDetailsView(IndentApprovalDeskVO vo) {

		StringBuffer sb = new StringBuffer("");

		try {
			WebRowSet ws = vo.getStrIndentDetailsWs();
			if (ws != null && ws.size() > 0) {
				if (ws.next()) {
					if (vo.getStrReqTypeId().equals("65")) {
						// String status = "";
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
						String strThirdPartyName = ws.getString(12);

						if (strStoreName == null)
							strStoreName = "----";
						if (strItemCatg == null)
							strItemCatg = "----";
						if (strReqNo == null)
							strReqNo = "----";
						if (strIndentDate == null)
							strIndentDate = "----";
						if (strIndentType == null)
							strIndentType = "----";
						if (strToStore == null)
							strToStore = "----";
						if (strIndentStatus == null)
							strIndentStatus = "----";
						if (strIndentPeriod == null
								|| strIndentPeriod.equals("0"))
							strIndentPeriod = "----";
						if (strApprovedBy == null)
							strApprovedBy = "----";
						if (strApprovedDate == null)
							strApprovedDate = "----";
						if (strApprovedlevel == null)
							strApprovedlevel = "----";

						if (strThirdPartyName == null)
							strThirdPartyName = "----";
						/*
						 * if(strIndentStatus.equals("1")) { status ="Uregnt"; }
						 * else { status ="Normal"; }
						 */

						//sb.append("<table class='TABLEWIDTH' align='center' border='0'  cellspacing ='1px'>");

						sb.append("<div class='row'><div class='col-sm-2'>Request Type Name</div>");
						sb.append("<div style='font-weight: 400; ' class='col-sm-2'>");
						sb.append(strIndentType);
						sb.append("</div>");

						sb.append("<div class='col-sm-2'>Raising Store</div>");
						sb.append("<div style='font-weight: 400; ' class='col-sm-2'>");
						sb.append(strStoreName);
						sb.append("</div>");
						sb.append("<div class='col-sm-2'>Third Party Name</div>");
						sb.append("<div style='font-weight: 400; ' class='col-sm-2'>");
						sb.append(strThirdPartyName);
						sb.append("</div></div>");

						sb.append("<div class='row'><div class='col-sm-2'>Req No</div>");
						sb.append("<div style='font-weight: 400; ' class='col-sm-2'>");
						sb.append(strReqNo);
						sb.append("</div>");
						sb.append("<div class='col-sm-2'>Req Date</div>");
						sb.append("<div style='font-weight: 400; ' class='col-sm-2'>");
						sb.append(strIndentDate);
						sb.append("</div>");

						sb.append("<div class=''>Item Category</div>");
						sb.append("<div style='font-weight: 400; ' class='col-sm-2'>");
						sb.append(strItemCatg);
						sb.append("</div>");
						//sb.append("<td width='25%' class='LABEL'></td>");
						//sb.append("<td width='25%' class='CONTROL'>");
						sb.append("</div></div>");
						//sb.append("</table>");
					} else {
						String strReqNo = ws.getString(1);
						String strStoreName = ws.getString(2);
						String strIndentDate = ws.getString(3);
						String strItemCatg = ws.getString(4);
						String strIndentType = ws.getString(5);
						String strToStore = ws.getString(6);
						// String strCommitteTypeId = ws.getString(12);

						if (strStoreName == null)
							strStoreName = "----";
						if (strItemCatg == null)
							strItemCatg = "----";
						if (strReqNo == null)
							strReqNo = "----";
						if (strIndentDate == null)
							strIndentDate = "----";
						if (strIndentType == null)
							strIndentType = "----";
						if (strToStore == null)
							strToStore = "----";
						//sb.append("<table class='TABLEWIDTH' align='center'   border='0'  cellspacing ='1px'>");
						if(vo.getStrItemCatgNo()!=null && vo.getStrItemCatgNo().equals("10"))
							sb.append("<div class='row'><div class='col-sm-2'>Store Name</div>");
						else
							sb.append("<div class='row'><div class='col-sm-2'>Store Name</div>");
						sb.append("<div style='font-weight: 400; ' class='col-sm-2'>");
						sb.append(strStoreName);
						sb.append("</div>");
						sb.append("<div class='col-sm-2'>Item Category</div>");
						sb.append("<div style='font-weight: 400; ' class='col-sm-2'>");
						sb.append(strItemCatg);
						sb.append("</div>");
						sb.append("<div class='col-sm-2'>Indent No</div>");
						sb.append("<div style='font-weight: 400; ' class='col-sm-2'>");
						sb.append(strReqNo);
						sb.append("</div></div>");
						sb.append("<div class='row'><div class='col-sm-2'>Indent Date</div>");
						sb.append("<div style='font-weight: 400; ' class='col-sm-2'>");
						sb.append(strIndentDate);
						sb.append("</div>");
						sb.append("<div class='col-sm-2'>Indent Type</div>");
						sb.append("<div style='font-weight: 400; ' class='col-sm-2'>");
						sb.append(strIndentType);
						sb.append("</div>");
						if(vo.getStrItemCatgNo()!=null && vo.getStrItemCatgNo().equals("10"))
							sb.append("<div class='col-sm-2'>To Store Name</div>");
						else
							sb.append("<div class='col-sm-2'>To Store Name</div>");
						sb.append("<div style='font-weight: 400; ' class='col-sm-2'>");
						sb.append(strToStore);
						sb.append("</div></div>");
						if (vo.getStrReqTypeId().equals("16")) {
							vo.setStrCommitteTypeCode(ws.getString(12));
							IndentApprovalDeskDAO
									.callingFunctionCommitteNameView(vo);
							if (!vo.getStrCommitteTypeName().equals("/")) {
								sb.append("<div classs='row'>");
								sb.append("<div class='col-sm-2'>CommitteType Name</div>");
								sb.append("<div style='font-weight: 400; ' class='col-sm-2'>");
								sb.append(vo.getStrCommitteTypeName());
								sb.append("</div></div>");
								//sb.append("<td width='25%' class='LABEL'></td>");
								//sb.append("<td width='25%' class='CONTROL'>");
								//sb.append("</td>");
								//sb.append("</tr>");
							}
						}

						//sb.append("</table>");

					}
				}
			} else {
				sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
				sb.append("<tr>");
				sb.append("<td colspan='5'  CLASS='multiControl' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>"
						+ "</TD>");

				sb.append("</tr>");
				sb.append("</table>");

			}
		} catch (Exception e) {
			vo.setStrMsgString("IndentApprovalDeskHLP.getIndentDetailsView() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}

	public static String getBlockedItemDetails(IndentApprovalDeskVO vo,
			String strRasingReceving) {
		StringBuffer sb = new StringBuffer("");
		String strReservedQty = "";
		String strUnReservedQty = "";
		String[] temp = null;
		try {

			WebRowSet ws = vo.getStrBlockedItemDetailsWs();

			if (vo.getStrReqTypeId().equals("17")) {
				temp = vo.getStrReservUnReservQty().split("\\^");
				strReservedQty = temp[0] + " " + temp[2];
				strUnReservedQty = temp[1] + " " + temp[2];
			} else {
				strReservedQty = "------";
				strUnReservedQty = "-------";
			}
			/*
			 * if (strReservedQty == null) strReservedQty = "----"; if
			 * (strUnReservedQty == null) strUnReservedQty = "----";
			 */

			// ws.beforeFirst();
			sb.append("<table width='100%' align='center'  border='0' cellspacing ='1px'>");
			sb.append("<tr class='HEADER'>");
			sb.append("<th colspan='4' align='left'><div id='' style='color:blue;'>Blocked Item Details</div></th>");
			sb.append("<th align='right'><img  title='To Close PopUp Window' style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'	onClick=hideItemDetails('issueDtlId');></th>");
			sb.append("</tr>");
			sb.append("</table>");
			sb.append("<table width='100%'align='center' bgcolor='#6097BC'  border='0' cellspacing ='1px'>");
			sb.append("<tr>");
			if (vo.getStrReqTypeId().equals("17")) {
				sb.append("<td width='20%' class='multiLabel'>Reserved Qty</td>");
				sb.append("<td width='20%' class='multiControl'>");
				sb.append(strReservedQty);
				sb.append("</td>");
				sb.append("<td width='20%' class='multiLabel'>Un-Reserved Qty</td>");
				sb.append("<td width='20%' class='multiControl'>");
				sb.append(strUnReservedQty);
				sb.append("</td>");
				sb.append("</tr>");
			}
			sb.append("<tr>");
			sb.append("<td width='20%' class='multiLabel'>Blocked Qty</td>");
			sb.append("<td width='20%' colspan='3' class='multiControl'>");
			sb.append("<div id ='BlockQtyDiv'></div>");
			sb.append("</td>");
			sb.append("</tr>");

			sb.append("</table>");
			sb.append("<table width='100%' align='center' bgcolor='#6097BC'  border='0' cellspacing ='1px'>");
			sb.append("<tr class='TITLE'>");
			sb.append("<td colspan='4'><div id='' style='color:blue;font-family: Arial, Helvetica, sans-serif;font-size:13px;'>Item Details</div></td>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td width='20%' class='multiLabel'>Req No</td>");
			sb.append("<td width='20%' class='multiLabel'>Req Date</td>");
			sb.append("<td width='20%' class='multiLabel'>Item Category</td>");
			sb.append("<td width='20%' class='multiLabel'>Blocked Qty</td>");
			sb.append("</tr>");

			if (ws != null && ws.size() > 0) {
				for (int i = 0; ws.next(); i++) {

					String strReqNo = ws.getString(1);
					String strReqDate = ws.getString(2);
					String strItemCatgName = ws.getString(3);
					String strBlockedQtyUnit = ws.getString(4);
					String strBlockedQtyUnitInven = ws.getString(5);
					String strBlockedQtyAdd = ws.getString(6);

					if (strReqNo == null)
						strReqNo = "----";
					if (strReqDate == null)
						strReqDate = "----";
					if (strItemCatgName == null)
						strItemCatgName = "----";
					if (strBlockedQtyUnit == null)
						strBlockedQtyUnit = "----";
					if (strBlockedQtyUnitInven == null)
						strBlockedQtyUnitInven = "----";
					if (strBlockedQtyAdd == null)
						strBlockedQtyAdd = "0";

					sb.append("<input type='hidden' name ='strBlockedQtyAdd'  value='"
							+ strBlockedQtyAdd + "'>");
					sb.append("<tr>");
					sb.append("<td width='20%' class='multiControl'>");
					sb.append(strReqNo);
					sb.append("</td>");
					sb.append("<td width='20%' class='multiControl'>");
					sb.append(strReqDate);
					sb.append("</td>");

					sb.append("<td width='20%' class='multiControl'>");
					sb.append(strItemCatgName);
					sb.append("</td>");
					sb.append("<td  width='20%' class='multiControl'>");
					sb.append(strBlockedQtyUnitInven);
					sb.append("</td>");

				}
				sb.append("</tr>");
				sb.append("<tr class='FOOTER'>");
				sb.append("<td colspan='4'></td>");
				sb.append("</tr>");
				sb.append("</table>");
			} else {
				sb.append("<table width='100%' align='center'  border='0' cellspacing ='1px'>");
				sb.append("<tr>");
				sb.append("<td colspan='4'  CLASS='multiControl' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED ITEM. </div>"
						+ "</TD>");
				sb.append("</tr>");
				sb.append("<tr class='FOOTER'>");
				sb.append("<td colspan='4'></td>");
				sb.append("</tr>");
				sb.append("</table>");

			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentApprovalDeskHLP.getItemDetails() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}

		return sb.toString();
	}

}
