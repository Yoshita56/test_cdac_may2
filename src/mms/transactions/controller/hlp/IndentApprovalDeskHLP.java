package mms.transactions.controller.hlp;

import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.transactions.dao.IndentApprovalDeskDAO;
import mms.transactions.vo.IndentApprovalDeskVO;

public class IndentApprovalDeskHLP {
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
			sb.append("<table class='table'>");
			sb.append("<thead class='thead-dark'>");			
			sb.append("<tr>");
			sb.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</th>");
			sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Batch No</th>");
			//sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Avl Qty</td>");
			sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</th>");
			sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'><font size='2' color='red'>*</font>Approved Qty</th>");
			sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'><font size='2' color='red'>*</font>Unit Name</th>");
			sb.append("<th width='5%' style='font-weight:350 !important ;font-size: 16px !important;'>#</th>");
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
					sb.append("<table class='table'>");
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
					sb.append("<td width='20%' style='font-weight:350 !important ;font-size: 15px !important;'>");
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
					sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 15px !important;'>");
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

					sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 15px !important;'>");
					sb.append(strReqQty);
					sb.append("<input type='hidden' name ='strReqQty'  value='"
							+ strReqQty + "'>");
					sb.append("</td>");

					sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 15px !important;'>");
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
					sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 15px !important;' class='form-control' onchange='checkQtyWithoutUtility(\""
							+ i
							+ "\", \"strInsSancQty\", \"strInsUnitCombo\" , \""
							+ strInHandQty
							+ "\",\" Sanction Quantity should not be Greater than Available Quantity\");' >");
					sb.append("<select name='strInsUnitCombo' class='custom-select' id='strInsUnitCombo"
							+ i + "' >'" + unitCombo + "'</select>");
					sb.append("</td>");
					sb.append("<td width='5%' style='font-weight:350 !important ;font-size: 15px !important;'><a value='' style='cursor:pointer;'  onClick='openDivItem(this,"
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
				sb.append("<table class='table'>");
				sb.append("<tr>");
				sb.append("<td colspan='6'  style='font-weight:350 !important ;font-size: 15px !important;'>"
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
		WebRowSet ws1 = vo.getStrItemDetailsWs();  // PKG_MMS_VIEW.proc_get_indentitem_dtl [ Mode - 1]
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
								|| vo.getStrReqTypeId().equals("13")) 
						{
							strCrNo = ws1.getString(8);
							strPatName = ws1.getString(9);
							strEmpID = ws1.getString(10);
							/*
							 * AHIS_FUNCTION.GETCATEGORYNAME(A.HGNUM_PATIENT_CAT_CODE,A.GNUM_HOSPITAL_CODE) ||'^'||				     
						       INITCAP(HRGSTR_FNAME)||
						       DECODE(SIGN(LENGTH(TRIM(HRGSTR_MNAME))-0),1,' '||TRIM(INITCAP(HRGSTR_MNAME)))||
						       DECODE(SIGN(LENGTH(TRIM(HRGSTR_LNAME))-0),1,' '||
						       TRIM(INITCAP(HRGSTR_LNAME)))||' - '||AHIS_UTIL.AGE_SEX(HRGNUM_PUK::CHARACTER VARYING)||'[ '||HRGNUM_PUK||' ]' 
						       || '^' ||HRGNUM_IS_MLC||'^'||HRGNUM_ISNEWBORN ||'^'||HRGSTR_FATHER_NAME				       
						       ||'^'||NVL(HRGNUM_IS_DEAD,0)||'^'||nvl((select gstr_hospital_name from gblt_hospital_mst where gnum_hospital_code=a.gnum_hospital_code),'')
						       ||'^'||TO_CHAR(GDT_ENTRY_DATE,'DD-MON-YYYY HH24:MI:SS')||'^'||NVL(HRGSTR_EMG_CNTC,'')
						       ||'^'||DECODE(HRGNUM_ISNEWBORN,0,'NO','YES:MOTHER CR '||HRGNUM_MOTHER_PUK) 
						       
						       0 - General                                              Patient Category
						       1 - Gabru Jawan - 25 Yr/Male[ 279162100000665 ]          Patient Dtls
						       2 - 0                                                    HRGNUM_IS_MLC            
						       3 - 0                                                    HRGNUM_ISNEWBORN  
						       4 - Sdds                                                 HRGSTR_FATHER_NAME
						       5 - 0                                                    HRGNUM_IS_DEAD
						       6 - All India Institute of Medical Sciences, Nagpur      HOSP_NAME 
						       7 - 03-MAY-2021 18:11:02                                 ADDMISSION DATE
						       8 -                                                      HRGSTR_EMG_CNTC
						       9 - NO                                                   HRGNUM_ISNEWBORN 
							 * 
							 * */
							strEmpName = ws1.getString(11);
							/*
							 * 0 - Dept Name                                            
						       1 - Dept Unit Name                                       
						       2 - Ward Name                                                      
						       3 - Room No                                             
						       4 - Bed No                                               
						       5 - Patient Catg                                         
						       6 - Consultant Name                                       
						       7 - IS New Born                                          
						       8 - Bill Catg 
						       9 - Addmission No
						      10 - Admission Date 
							 * 
							 * */
							

						}
						if (vo.getStrReqTypeId().equals("10")) {
							strCrNo = ws1.getString(10);
							strPatName = ws1.getString(11);
							strEmpID = ws1.getString(12);
							/*
							 * AHIS_FUNCTION.GETCATEGORYNAME(A.HGNUM_PATIENT_CAT_CODE,A.GNUM_HOSPITAL_CODE) ||'^'||				     
						       INITCAP(HRGSTR_FNAME)||
						       DECODE(SIGN(LENGTH(TRIM(HRGSTR_MNAME))-0),1,' '||TRIM(INITCAP(HRGSTR_MNAME)))||
						       DECODE(SIGN(LENGTH(TRIM(HRGSTR_LNAME))-0),1,' '||
						       TRIM(INITCAP(HRGSTR_LNAME)))||' - '||AHIS_UTIL.AGE_SEX(HRGNUM_PUK::CHARACTER VARYING)||'[ '||HRGNUM_PUK||' ]' 
						       || '^' ||HRGNUM_IS_MLC||'^'||HRGNUM_ISNEWBORN ||'^'||HRGSTR_FATHER_NAME				       
						       ||'^'||NVL(HRGNUM_IS_DEAD,0)||'^'||nvl((select gstr_hospital_name from gblt_hospital_mst where gnum_hospital_code=a.gnum_hospital_code),'')
						       ||'^'||TO_CHAR(GDT_ENTRY_DATE,'DD-MON-YYYY HH24:MI:SS')||'^'||NVL(HRGSTR_EMG_CNTC,'')
						       ||'^'||DECODE(HRGNUM_ISNEWBORN,0,'NO','YES:MOTHER CR '||HRGNUM_MOTHER_PUK) 
							 * 
							 * */
							strEmpName = ws1.getString(13);
							/*
							 * 0 - Dept Name                                            
						       1 - Dept Unit Name                                       
						       2 - Ward Name                                                      
						       3 - Room No                                             
						       4 - Bed No                                               
						       5 - Patient Catg                                         
						       6 - Consultant Name                                       
						       7 - IS New Born                                          
						       8 - Bill Catg 
						       9 - Addmission No
						      10 - Admission Date 
							 * 
							 * */
							
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
						if (vo.getStrReqTypeId().equals("13")) 
						{
							if (k == 0) 
							{
								String strArr[]     = strEmpID.split("\\^");
								String strAddmArr[] = strEmpName.split("\\^");
								
								/*
								 * sb.
								 * append("<div class='container'><div class='row'><div class='col-sm-3'>CR NO</div><div class='col-sm-3'>"
								 * +sb.append(strCrNo)
								 * +"</div><div class='col-sm-3'>Patient Dtl</div><div class='col-sm-3'>"+sb.
								 * append(strArr[1])+"</div></div>");
								 */							
								  sb.append("<div class='container'>");
								  
								  sb.append("<div class='row'>");
								  sb.append("<div class='col-sm-3'>CR NO</div>");
								  sb.append("<div class='col-sm-3'>");
								  sb.append(strCrNo);
								  sb.append("</div>");
								  sb.append("<div class='col-sm-3'>Patient Dtl</div>");
								  sb.append("<div class='col-sm-3'>");
								  sb.append(strArr[1]);
								  sb.append("</div></div>");
								  
								  sb.append("<div class='row'>");
								  sb.append("<div class='col-sm-3'>Category</div>");
								  sb.append("<div class='col-sm-3'>");
								  sb.append(strArr[0]);
								  sb.append("</div>");
								  sb.append("<div class='col-sm-3'>Department Name</div>");
								  sb.append("<div class='col-sm-3'>");
								  sb.append(strAddmArr[0]);
								  sb.append("</div></div>");
				
								  sb.append("<div class='row'>");
								  sb.append("<div class='col-sm-3'>Unit Name</div>");
								  sb.append("<div class='col-sm-3'>");
								  sb.append(strAddmArr[1]);
								  sb.append("</div>");
								  sb.append("<div class='col-sm-3'>Ward Name</div>");
								  sb.append("<div class='col-sm-3'>");
								  sb.append(strAddmArr[2]);
								  sb.append("</div></div>");
								
								  sb.append("<div class='row'>");
								  sb.append("<div class='col-sm-3'>Room / Bed</div>");
								  sb.append("<div class='col-sm-3'>");
								  sb.append(strAddmArr[3] + " / " + strAddmArr[4]);
								  sb.append("</div>");
								  sb.append("<div class='col-sm-3'>Addmission Dtl</div>");
								  sb.append("<div class='col-sm-3'>");
								  sb.append(strAddmArr[9] + " [ " + strAddmArr[10] + " ]");
								  sb.append("</div></div>");
								  
								  
								/*
								 * sb.append("<table class='table'>"); sb.append(
								 * "<tr><td class='LABEL' width='25%' style='font-weight:350 !important ;font-size: 15px !important;'>CR NO</td>"
								 * );
								 * 
								 * sb.append(
								 * "<td class='CONTROL' width='25%'style='font-weight:350 !important ;font-size: 15px !important;'>"
								 * ); sb.append(strCrNo); sb.append("</td>");
								 * 
								 * sb.append(
								 * "<td class='LABEL' width='25%' style='font-weight:350 !important ;font-size: 15px !important;'>Patient Dtl</td>"
								 * ); sb.append(
								 * "<td class='CONTROL' width='25%' style='font-weight:350 !important ;font-size: 15px !important;'>"
								 * ); sb.append(strArr[1]); sb.append("</td></tr>");
								 * 
								 * sb.append(
								 * "<tr><td class='LABEL' width='25%' style='font-weight:350 !important ;font-size: 15px !important;'>Category</td>"
								 * ); sb.append(
								 * "<td class='CONTROL' width='25%' style='font-weight:350 !important ;font-size: 15px !important;'>"
								 * ); sb.append(strArr[0]); sb.append("</td>");
								 * 
								 * sb.append(
								 * "<td class='LABEL' width='25%' style='font-weight:350 !important ;font-size: 15px !important;'>Department Name</td>"
								 * ); sb.append(
								 * "<td class='CONTROL' width='25%' style='font-weight:350 !important ;font-size: 15px !important;'>"
								 * ); sb.append(strAddmArr[0]); sb.append("</td></tr>");
								 * 
								 * sb.append(
								 * "<tr><td class='LABEL' width='25%' style='font-weight:350 !important ;font-size: 15px !important;'>Unit Name</td>"
								 * ); sb.append(
								 * "<td class='CONTROL' width='25%' style='font-weight:350 !important ;font-size: 15px !important;'>"
								 * ); sb.append(strAddmArr[1]); sb.append("</td>"); sb.append(
								 * "<td class='LABEL' width='25%' style='font-weight:350 !important ;font-size: 15px !important;'>Ward Name</td>"
								 * ); sb.append(
								 * "<td class='CONTROL' width='25%' style='font-weight:350 !important ;font-size: 15px !important;'>"
								 * ); sb.append(strAddmArr[2]); sb.append("</td></tr>"); sb.append(
								 * "<tr><td class='LABEL' width='25%' style='font-weight:350 !important ;font-size: 15px !important;'>Room / Bed</td>"
								 * ); sb.append(
								 * "<td class='CONTROL' width='25%' style='font-weight:350 !important ;font-size: 15px !important;'>"
								 * ); sb.append(strAddmArr[3] + " / " + strAddmArr[4]); sb.append("</td>");
								 * sb.append(
								 * "<td class='LABEL' width='25%' style='font-weight:350 !important ;font-size: 15px !important;'>Addmission Dtl</td>"
								 * ); sb.append(
								 * "<td class='CONTROL' width='25%' style='font-weight:350 !important ;font-size: 15px !important;'>"
								 * ); sb.append(strAddmArr[9] + " [ " + strAddmArr[10] + " ]");
								 * sb.append("</td></tr>");
								 */
								 
								/*
								 * 0 - Dept Name                                            
							       1 - Dept Unit Name                                       
							       2 - Ward Name                                                      
							       3 - Room No                                             
							       4 - Bed No                                               
							       5 - Patient Catg                                         
							       6 - Consultant Name                                       
							       7 - IS New Born                                          
							       8 - Bill Catg 
							       9 - Addmission No
							      10 - Admission Date 
								 * 
								 * */
								
								/*
								   0 - General                                              Patient Category
							       1 - Gabru Jawan - 25 Yr/Male[ 279162100000665 ]          Patient Dtls
							       2 - 0                                                    HRGNUM_IS_MLC            
							       3 - 0                                                    HRGNUM_ISNEWBORN  
							       4 - Sdds                                                 HRGSTR_FATHER_NAME
							       5 - 0                                                    HRGNUM_IS_DEAD
							       6 - All India Institute of Medical Sciences, Nagpur      HOSP_NAME 
							       7 - 03-MAY-2021 18:11:02                                 ADDMISSION DATE
							       8 -                                                      HRGSTR_EMG_CNTC
							       9 - NO                                                   HRGNUM_ISNEWBORN 
								 * 
								 * */
							}
						} else {

							if (vo.getStrReqTypeId().equals("12")) {
								if (k == 0) {
								 	  sb.append("<div class='row'>");
									  sb.append("<div class='col-sm-3'>Emp ID</div>");
									  sb.append("<div class='col-sm-3'>");
									  sb.append(strEmpID);
									  sb.append("</div>");
									  sb.append("<div class='col-sm-3'>Emp Name</div>");
									  sb.append("<div class='col-sm-3'>");
									  sb.append(strEmpName);
									  sb.append("</div></div>");
									
									/*
									 * sb.
									 * append("<tr><td width='25%' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;'>Emp ID</td>"
									 * ); sb.
									 * append("<td width='25%' class='CONTROL' style='font-weight:350 !important ;font-size: 15px !important;'>"
									 * ); sb.append(strEmpID); sb.append("</td>"); sb.
									 * append("<td width='25%' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;'>Emp Name</td>"
									 * ); sb.
									 * append("<td width='25%' class='CONTROL' style='font-weight:350 !important ;font-size: 15px !important;'>"
									 * ); sb.append(strEmpName); sb.append("</td></tr>");
									 */
								}
							}
						}
						k++;
					}
					/* sb.append("</table>"); */ 
					 sb.append("</div>");

				} 
			}
			ws1.beforeFirst();

			sb.append("<table class='table'>");
			sb.append("<thead class='thead-dark'>");	
			sb.append("<tr>");
			sb.append("<th width='40%' style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</th>");
			sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Avl Qty</th>");
			sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</th>");
			sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'><font size='2' color='red'>*</font>Approved Qty</th>");
			sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'><font size='2' color='red'>*</font>Unit Name</th>");
			if(!vo.getStrItemCatgNo().equals("10"))
				sb.append("<th style='font-weight:350 !important ;font-size: 16px !important;'>Operation Details(In case of Special Item)</th>");
			sb.append("</tr>");
			sb.append("<thead>");
			sb.append("</table>");
			if (ws1 != null) 
			{
				String strItemName = null;
				String strAvlQty = "0";
				String strReqQty = null;
				String strUnitConvValue = null;
				String strRate = null;
				String strIssueQty = null;
				String strRetQty = null;
				String strLstRecevDate = null;
				String strLstRecevQty = null;
				String strLstRetQtyUnitId = null;
				String strApprovalRemarks = null;
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

				while (ws1.next()) 
				{
					if (vo.getStrReqTypeId().equals("10")) 
					{
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

					if (vo.getStrReqTypeId().equals("12")|| vo.getStrReqTypeId().equals("13")) 
					{
						strIssueQty 			= ws1.getString(1);
						strRetQty 				= ws1.getString(2);
						strItemName 			= ws1.getString(3);
						strAvlQty 				= ws1.getString(4);   // Issuing Store Stock
						strReqQty 				= ws1.getString(5);
						
						strRate 				= ws1.getString(7);
						strItemId 				= ws1.getString(12);
						strItemBrandId 			= ws1.getString(13);
						strProcIndentQty 		= ws1.getString(14);
						strProcIndentQtyUnit 	= ws1.getString(15);
						strProcSancQty 			= ws1.getString(16);
						strProcSancQtyUnitId 	= ws1.getString(17);
						strUnitConvValue        = ws1.getString(18);
						strApprovalRemarks      = ws1.getString(19);

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
					if (vo.getStrReqTypeId().equals("14")) 
					{
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
					
					sb.append("<input type='hidden' name ='strAvlQty'  value='"
							+ strAvlQty + "'>");
					sb.append("<input type='hidden' name ='strAjaxHiddenValue'  value='"
							+ strAjaxHiddenValue + "'>");
					sb.append("<input type='hidden' name ='strHiddenValue'  value='"
							+ strHiddenValue + "'>");
					sb.append("<input type='hidden' name ='strInsertHiddenValue'  value='"
							+ strInsertHiddenValue + "'>");
					
					sb.append("<table class='table'>");
					sb.append("<tr>");
					sb.append("<td width='40%' align='left' style='font-weight:350 !important ;font-size: 15px !important;'  >");					
					sb.append(strItemName);							
					sb.append("</td>");
					
					sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");					
					sb.append(strAvlQty);							
					sb.append("</td>");				
					
					sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
					sb.append(strReqQty);
					sb.append("<input type='hidden' name ='strReqQty'  value='"	+ strReqQty + "'>");
					sb.append("</td>");
					
					sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
					sb.append("<input type='text' class='form-control' name='strInsSancQty' value='"
							+ strReqQty.split(" ")[0]
							+ "' onkeypress='return validateData(event,7);'>");
					sb.append("</td>");
					
					sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
					sb.append("<select name='strInsUnitCombo' class='custom-select'>" + unitCombo
							+ "</select>");
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
				sb.append("</table>");

			}
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

	public static String getIssueItemDetails(IndentApprovalDeskVO vo) {
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
		System.out.println("-----(IndentApprovalDeskHLP . getIssueItemDetails)-------");
			
		sb.append("<table class='table'>");
			sb.append("<thead class='thead-dark' >");
				sb.append("<tr>");
					sb.append("<th width='35%' style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</th>");
					if(vo.getStrLastAppLevel().equals("0"))
		            {	
					    sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Avl Qty(Indent)</th>");
		            }
					else
					{
						sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Avl Qty(Issue)</th>");	
					}
					sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</th>");
					sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'><font size='2' color='red'>*</font>Approved Qty</th>");
					sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'><font size='2' color='red'>*</font>Unit Name</th>");
					//sb.append("<td width='10%' class='multiLabel'>Issue from Reserv Stock</td>");
					sb.append("<th width='5%'  style='font-weight:350 !important ;font-size: 16px !important;' >#</th>");
				sb.append("</tr>");
			sb.append("</thead>");
		sb.append("</table>");
			
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
						
						System.out.println("strAvlQtyRaising------"+strAvlQtyRaising);
						System.out.println("strAvlQtyReceving------"+strAvlQtyReceving);

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
					
				        sb.append("<table class='table'>");
					    sb.append("<tr>");
					    sb.append("<td width='35%' align='left' style='font-weight:350 !important ;font-size: 15px !important;'>");
						sb.append("<input type='hidden' name ='strAvlQty'             id ='strAvlQty"+i+"'  			value='"+ strAvlQtyRaising + "'>");
						sb.append("<input type='hidden' name ='strHiddenValue'        id ='strHiddenValue"+i+"'   		value='"+ strHiddenValue + "'>");
						sb.append("<input type='hidden' name ='strInsertHiddenValue'  id ='strInsertHiddenValue"+i+"'  	value='"+ strInsertHiddenValue + "'>");
						
						sb.append("<input type='hidden' name ='strHLPItemIdValue'  		id ='strHLPItemIdValue"+i+"'		value='"+ strItemId + "'>");
						sb.append("<input type='hidden' name ='strHLPStoreIdValue'  	id ='strHLPStoreIdValue"+i+"'		value='"+ vo.getStrStoreId() + "'>");
						sb.append("<input type='hidden' name ='strHLPToStoreIdValue'  	id ='strHLPToStoreIdValue"+i+"'		value='"+ vo.getStrToStoreId() + "'>");
						sb.append("<input type='hidden' name ='strHLPItemBrandIdValue'  id ='strHLPItemBrandIdValue"+i+"'	value='"+ strItemBrandId+ "'>");
						sb.append("<input type='hidden' name ='strHLPLastAppLevel'  	id ='strHLPLastAppLevel"+i+"'		value='"+ vo.getStrLastAppLevel() + "'>");
						
						
					/*sb.append("<a name='tarriff' value='' STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Item Details' onClick='callingPoPUp(this," + i + ",\"" + strHiddenValue + "\",\"" + vo.getStrReqTypeId() + "\");'>" + strItemName + "</a>");*/
					
					sb.append(strItemName);
					sb.append("</td>");
					
                    if(vo.getStrLastAppLevel().equals("0"))
                    {	
						/*
						  sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>"); 
						  sb.append(strAvlQtyRaising); 
						  sb.append("</td>");
						 */
                    	sb.append("<td width='15%' align='center' style='font-weight:350 !important; font-size: 15px !important;'>")
                    	  .append("<a href='javascript:void(0);' style='cursor:pointer;' onclick='generateFunc(this, " + i + ");' title='Click here to Enter'><font color='blue'>")
                    	  .append(strAvlQtyRaising)
                    	  .append("</font></a></td>");

                    }
                    else
                    {                    	
                    	sb.append("<td width='15%' align='center' style='font-weight:350 !important; font-size: 15px !important;'>")
	                  	  .append("<a href='javascript:void(0);' style='cursor:pointer;' onclick='generateFunc(this, " + i + ");' title='Click here to Enter'><font color='blue'>")
	                  	  .append(strAvlQtyReceving)
	                  	  .append("</font></a></td>");
                    }

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
					sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
					sb.append(strReqQty);
					sb.append("<input type='hidden' name ='strAvlQtyReceving'  id ='strAvlQtyReceving"+i+"'  value='"+ strAvlQtyReceving + "'>");
					sb.append("<input type='hidden' name ='strReqQty'  value='"+ strReqQty + "'>");
					sb.append("</td>");

					sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
					sb.append("<input type='text' class='form-control' name='strInsSancQty'  id='strInsSancQty"+i+"' value='"+strSancQty.split(" ")[0] + "'    onkeyup='return calculateCostOnChange("+i+",this);' onkeypress='return validateData(event,7);'>");
					sb.append("</td>");
					
					sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
					sb.append("<select name='strInsUnitCombo'  class='custom-select' id='strInsUnitCombo"+i+"' onchange='calUnitBaseCost("+i+",this);'>'" + unitCombo+ "'</select>");
					sb.append("</td>");

//					sb.append("<td width='10%' class='multiControl'>");
//					sb.append("<input type='checkbox' name='strIssueFrmReservStock' value='"+ strReservedFlg + "'>");
//					sb.append("</td>");
					
					sb.append("<td width='5%' align='center' style='font-weight:350 !important ;font-size: 15px !important;' ><a value='' style='cursor:pointer;'   onClick='openDivItem(this,"
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
					// sb.append("</table>");

					i++;
				}

				sb.append("</table>");

			} else {
				sb.append("<table class='table'>");
				sb.append("<tr>");
				sb.append("<td colspan='5'  align='center' style='font-weight:350 !important ;font-size: 15px !important;'>"
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
	
	public static String getIssueItemDetails_Bhatinda(IndentApprovalDeskVO vo) 
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
			System.out.println("-----(IndentApprovalDeskHLP . getIssueItemDetails_Bhatinda)-------");
			
			sb.append("<table class='table'>");
			sb.append("<thead class='thead-dark' >");
			sb.append("<tr>");
			sb.append("<th width='40%' style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</th>");
			if(vo.getStrLastAppLevel().equals("0"))
            {	
			    sb.append("<th width='10%' style='font-weight:350 !important ;font-size: 16px !important;'>Avl Qty(Indent)</th>");
            }
			else
			{
				sb.append("<th width='10%' style='font-weight:350 !important ;font-size: 16px !important;'>Avl Qty(Issue)</th>");	
			}
			sb.append("<th width='10%' style='font-weight:350 !important ;font-size: 16px !important;'>Prev Issue Qty </th>");			
			sb.append("<th width='10%' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</th>");
			sb.append("<th width='10%' style='font-weight:350 !important ;font-size: 16px !important;'><font size='2' color='red'>*</font>Approved Qty</th>");
			sb.append("<th width='10%' style='font-weight:350 !important ;font-size: 16px !important;'><font size='2' color='red'>*</font>Unit Name</th>");
			//sb.append("<td width='10%' class='multiLabel'>Issue from Reserv Stock</td>");
			sb.append("<th width=10%'  style='font-weight:350 !important ;font-size: 16px !important;' >#</th>");
			sb.append("</tr>");
			sb.append("</thead>");
			sb.append("</table>");
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
				String strPrevIssueQtyUnit = null;
				
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
						
						IndentApprovalDeskDAO.getLast_Issue_Qty_Of_Item_To_Indenter(vo,strItemBrandId);

						IndentApprovalDeskDAO.getUnitCombo(vo, strReqQtyUnit);

						IndentApprovalDeskDAO.getStockDtls(vo, strItemId,strItemBrandId);
						
						IndentApprovalDeskDAO.getStockDtlsTwo(vo, strItemId,strItemBrandId);
						
						strAvlQtyRaising  = vo.getStrStockDtlTwo();   // Indent Raising  Store Quantity  Added By Amit Kr 17-Aug-2011
                      
						strAvlQtyReceving = vo.getStrStockDtl();      // Indent Receiving Store Quantity
						
						System.out.println("strAvlQtyRaising------"+strAvlQtyRaising);
						System.out.println("strAvlQtyReceving------"+strAvlQtyReceving);
						
						/*
						  1. Issue No [ Date ]
						  2. Indenting Store Name
						  3. Issue By Store Name
						  4. Drug/Item Name
						  5. Batch No
						  6. Expiry Date
						  7. Rate With Unit
						  8. Issue Qty With Unit
						  9. Acknowledge Qty WithUnit
						 10. EDL Catg Flag
						 11. Issue By User Name
						 12. Remarks
						 13. Item Cost
						 14. Ack By Name
						 15. Supplier Name 
					    */
						if(vo.getLastIssueQtyWs().size()>0)
						{	
						   while(vo.getLastIssueQtyWs().next())
						   {
						   strPrevIssueQtyUnit = vo.getLastIssueQtyWs().getString(8);
						   }
						   
						}
						else
						{
							strPrevIssueQtyUnit = "0 No";
						}
						
						System.out.println("Prev Issue Qty------"+strPrevIssueQtyUnit);  // Last Issue Qty

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
					sb.append("<table class='table'>");

					sb.append("<tr>");
					sb.append("<td width='40%' align='left' style='font-weight:350 !important ;font-size: 15px !important;'>");
					sb.append("<input type='hidden' name ='strAvlQty'  value='"	+ strAvlQtyRaising + "'>");
					sb.append("<input type='hidden' name ='strHiddenValue'  value='"+ strHiddenValue + "'>");
					sb.append("<input type='hidden' name ='strInsertHiddenValue'  value='"+ strInsertHiddenValue + "'>");
					
					sb.append("<input type='hidden' name ='strHLPItemIdValue'  		id ='strHLPItemIdValue"+i+"'		value='"+ strItemId + "'>");
					sb.append("<input type='hidden' name ='strHLPStoreIdValue'  	id ='strHLPStoreIdValue"+i+"'		value='"+ vo.getStrStoreId() + "'>");
					sb.append("<input type='hidden' name ='strHLPToStoreIdValue'  	id ='strHLPToStoreIdValue"+i+"'		value='"+ vo.getStrToStoreId() + "'>");
					sb.append("<input type='hidden' name ='strHLPItemBrandIdValue'  id ='strHLPItemBrandIdValue"+i+"'	value='"+ strItemBrandId+ "'>");
					sb.append("<input type='hidden' name ='strHLPLastAppLevel'  	id ='strHLPLastAppLevel"+i+"'		value='"+ vo.getStrLastAppLevel() + "'>");
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
					if(vo.getStrLastAppLevel().equals("0"))
                    {	
						/*
						  sb.append("<td width='10%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>"); 
						  sb.append(strAvlQtyRaising); sb.append("</td>");
						 */
					 sb.append("<td width='10%' align='center' style='font-weight:350 !important; font-size: 15px !important;'>")
	               	  .append("<a href='javascript:void(0);' style='cursor:pointer;' onclick='generateFunc(this, " + i + ");' title='Click here to Enter'><font color='blue'>")
	               	  .append(strAvlQtyRaising)
	               	  .append("</font></a></td>");
                    }
                    else
                    {                    	
   					 sb.append("<td width='10%' align='center' style='font-weight:350 !important; font-size: 15px !important;'>")
	               	  .append("<a href='javascript:void(0);' style='cursor:pointer;' onclick='generateFunc(this, " + i + ");' title='Click here to Enter'><font color='blue'>")
	               	  .append(strAvlQtyReceving)
	               	  .append("</font></a></td>");
                    }

					sb.append("<td width='10%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
					sb.append(strPrevIssueQtyUnit);
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
					sb.append("<td width='10%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
					sb.append(strReqQty);
					sb.append("<input type='hidden' name ='strAvlQtyReceving'  id ='strAvlQtyReceving"+i+"'  value='"+ strAvlQtyReceving + "'>");
					sb.append("<input type='hidden' name ='strReqQty'  value='"+ strReqQty + "'>");
					sb.append("</td>");

					sb.append("<td width='10%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
					sb.append("<input type='text' class='form-control' name='strInsSancQty'  id='strInsSancQty"+i+"' value='"+strSancQty.split(" ")[0] + "'    onkeyup='return calculateCostOnChange("+i+",this);' onkeypress='return validateData(event,7);'>");
					sb.append("</td>");
					
					sb.append("<td width='10%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
					sb.append("<select name='strInsUnitCombo'  class='custom-select' id='strInsUnitCombo"+i+"' onchange='calUnitBaseCost("+i+",this);'>'" + unitCombo+ "'</select>");
					sb.append("</td>");

//					sb.append("<td width='10%' class='multiControl'>");
//					sb.append("<input type='checkbox' name='strIssueFrmReservStock' value='"+ strReservedFlg + "'>");
//					sb.append("</td>");
					
					sb.append("<td width='10%' align='center' style='font-weight:350 !important ;font-size: 15px !important;' ><a value='' style='cursor:pointer;'   onClick='openDivItem(this,"
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
					// sb.append("</table>");

					i++;
				}

				sb.append("</table>");

			} else {
				sb.append("<table class='table'>");
				sb.append("<tr>");
				sb.append("<td colspan='5'  align='center' style='font-weight:350 !important ;font-size: 15px !important;'>"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>"
						+ "</TD>");

				sb.append("</tr>");
				sb.append("</table>");

			}
			vo.setStrMultiRow(i + "");
		} catch (Exception e) 
		{
			e.printStackTrace();
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
				sb.append("<thead class='thead-dark'>");
				sb.append("<tr>");
				sb.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</th>");
				sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Batch No</th>");
			//	sb.append("<td width='15%' class='multiLabel'>Avl Qty</td>");
				sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</th>");
				sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'><font size='2' color='red'>*</font>Approved Qty</th>");
				sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'><font size='2' color='red'>*</font>Unit Name</th>");
				sb.append("<th width='5%' style='font-weight:350 !important ;font-size: 16px !important;'>#</th>");
				sb.append("</thead>");
				sb.append("</tr>");
			} else {
				sb.append("<tr>");
				sb.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</th>");
				//sb.append("<td width='20%' class='multiLabel'>Avl Qty</td>");
				
				if (vo.getStrReqTypeId().equals("83")) {
					sb.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty / (Approx Rate/Unit)</th>");
				}
				else
				{
					sb.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</th>");
				}
				
				sb.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'><font size='2' color='red'>*</font>Approved Qty</th>");
				sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'><font size='2' color='red'>*</font>Unit Name</th>");
				sb.append("<th width='5%' style='font-weight:350 !important ;font-size: 16px !important;'>#</th>");
				sb.append("</tr>");
				if (vo.getStrReqTypeId().equals("47")) {
					sb.append("<thead class='thead-dark'>");
					sb.append("<tr>");
					sb.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</th>");
					sb.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Batch No</th>");
					sb.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Accepted Qty</th>");
					sb.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>To Be Return Qty</th>");
					sb.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Cost</th>");
					sb.append("</thead>");
					sb.append("</tr>");
				}

			}
			sb.append("</table>");

			if (ws1 != null) 
			{
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
				while (ws1.next()) 
				{
					if (vo.getStrReqTypeId().equals("11")
							||vo.getStrReqTypeId().equals("86")
							
							|| vo.getStrReqTypeId().equals("80")
							|| vo.getStrReqTypeId().equals("81")
							|| vo.getStrReqTypeId().equals("85")
							|| vo.getStrReqTypeId().equals("84")
							|| vo.getStrReqTypeId().equals("83")|| vo.getStrReqTypeId().equals("90")) 
					{
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
					if (vo.getStrReqTypeId().equals("16")|| vo.getStrReqTypeId().equals("19")) 
					{
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

					if (vo.getStrReqTypeId().equals("15")|| vo.getStrReqTypeId().equals("82")) 
					{
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

					if (vo.getStrReqTypeId().equals("18")) 
					{
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
						strBatchNo = ws1.getString(6);
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
						sb.append("<td width='20%' align='left' style='font-weight:350 !important ;font-size: 15px !important;'>");
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
						sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
						sb.append(strBatchNo);
						sb.append("</td>");
//						sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 15px !important;'>");
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
						sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
						sb.append(strReqQty);
						sb.append("<input type='hidden' name ='strReqQty'  value='"
								+ strReqQty + "'>");
						sb.append("</td>");

						sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
						// sb.append("<input type='text'class='txtFldSmall' name='strInsSancQty' value='"+strProcSancQty+"' onkeypress='return validateData(event,7);'>");
						sb.append("<input type='text' class='form-control' name='strInsSancQty' id='strInsSancQty"
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
						sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;' onchange='checkQtyWithoutUtility(\""
								+ i
								+ "\", \"strInsSancQty\", \"strInsUnitCombo\" , \""
								+ strInHandQty
								+ "\",\" Sanction Quantity should not be Greater than Available Quantity\");' >");
						sb.append("<select name='strInsUnitCombo'  class='custom-select'  id='strInsUnitCombo"
								+ i + "' >'" + unitCombo + "'</select>");

						sb.append("</td>");
						sb.append("<td width='5%' align='center' style='font-weight:350 !important ;font-size: 15px !important;' ><a value='' style='cursor:pointer;'   onClick='openDivItem(this,"
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
						sb.append("<table class='table'>");
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
						sb.append("<td width='20%' style='font-weight:350 !important ;font-size: 15px !important;'>");
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
						sb.append("<td width='20%' style='font-weight:350 !important ;font-size: 15px !important;'>");
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

						sb.append("<td width='20%' style='font-weight:350 !important ;font-size: 15px !important;'>");
						if(vo.getStrReqTypeId().equals("83"))
						{
						sb.append("<input type='text'class='form-control' name='strInsSancQty' value='"
								+ strProcIndentQty
								+ "' onkeypress='return validateData(event,7);'>");
						}
						else
						{
							sb.append("<input type='text'class='form-control' name='strInsSancQty' value='"
									+strProcSancQty //+ strReqQty.split("\\.")[0]
									+ "' onkeypress='return validateData(event,7);'>");
							
						}
						sb.append("</td>");
						sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 15px !important;'>");
						sb.append("<select name='strInsUnitCombo' class='custom-select'>'"
								+ unitCombo + "'</select>");

						sb.append("</td>");
						sb.append("<td  width='5%' style='font-weight:350 !important ;font-size: 15px !important;'><a value='' style='cursor:pointer;' onClick='openDivItem(this,"
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
								sb.append("<td width='20%' style='font-weight:350 !important ;font-size: 15px !important;'>");
								sb.append("<a name='tarriff' value='' STYLE='cursor:pointer;cursor:pointer;color:blue' title='Get Item Details' onClick='callingPoPUp(this,"
										+ i
										+ ",\""
										+ strHiddenValue
										+ "\",\""
										+ vo.getStrReqTypeId()
										+ "\");'>"
										+ strItemName + "</a>");
								sb.append("</td>");
								sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 15px !important;'>");
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
								sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 15px !important;'>");
								sb.append(strReqQty);
								sb.append("</td>");

								sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 15px !important;'>");
								sb.append("<input type='text' class='form-control' name='strInsSancQty' id='strInsSancQty"
										+ i
										+ "' value='"
										+ strProcSancQty
										+ "' onkeypress='return validateData(event,7);'  onkeyup='checkQtyWithoutUtility(\""
										+ i
										+ "\", \"strInsSancQty\", \"strInsUnitCombo\" , \""
										+ strInHandQty
										+ "\",\"Sanction Quantity should not be Greater than Available Quantity\");'   >");

								sb.append("</td>");
								sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 15px !important;' onchange='checkQtyWithoutUtility(\""
										+ i
										+ "\", \"strInsSancQty\", \"strInsUnitCombo\" , \""
										+ strInHandQty
										+ "\",\" Sanction Quantity should not be Greater than Available Quantity\");' >");
								sb.append("<select name='strInsUnitCombo'  class='custom-select' id='strInsUnitCombo"
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
				sb.append("<table class='table'>");
				sb.append("<tr>");
				sb.append("<td colspan='6'  style='font-weight:350 !important ;font-size: 15px !important;'>"
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
			if (ws != null && ws.size() > 0) 
			{
				if (ws.next()) 
				{
					if (vo.getStrReqTypeId().equals("65")
							|| vo.getStrReqTypeId().equals("64")) 
					{
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

						sb.append("<table class='TABLEWIDTH' align='center'   border='0'  cellspacing ='1px'>");
						sb.append("<tr><td width='25%' class='LABEL'>Request Type Name</td>");
						sb.append("<td colspan='3' width='25%' class='CONTROL'> ");
						sb.append(strIndentType);
						sb.append("</td></tr>");

						sb.append("<tr>");

						if (vo.getStrReqTypeId().equals("64")) {
							sb.append("<td width='25%' class='LABEL'>Receving Store</td>");
						} else {
							sb.append("<td width='25%' class='LABEL'>Raising Store</td>");

						}

						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strStoreName);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Third Party Name</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strThirdPartyName);
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
						sb.append("<td width='25%' class='LABEL'></td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append("</td></tr>");
						sb.append("</table>");

					} 
					else 
					{

						System.out.println("-----(IndentApprovalDeskHLP . getIndentDetails)----Req_type---"+vo.getStrReqTypeId());
						
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
						
						sb.append("<div class='container'>");
						  
						  sb.append("<div class='row'>");
						  sb.append("<div class='col-sm-3'>Request Type Name</div>");
						  sb.append("<div class='col-sm-3'>");
						  sb.append(strIndentType);
						  sb.append("</div>");
						  sb.append("<div class='col-sm-3'>Item Category</div>");
						  sb.append("<div class='col-sm-3'>");
						  sb.append(strItemCatg);
						  sb.append("</div></div>");
						  
						  sb.append("<div class='row'>");
						  sb.append("<div class='col-sm-3'>Raising Store</div>");
						  sb.append("<div class='col-sm-3'>");
						  sb.append(strStoreName);
						  sb.append("</div>");
						  sb.append("<div class='col-sm-3'>Receiving Store</div>");
						  sb.append("<div class='col-sm-3'>");
						  sb.append(strToStore);
						  sb.append("</div></div>");
						  
						  sb.append("<div class='row'>");
						  sb.append("<div class='col-sm-3'>Req No</div>");
						  sb.append("<div class='col-sm-3'>");
						  sb.append(strReqNo);
						  sb.append("</div>");
						  sb.append("<div class='col-sm-3'>Req Date</div>");
						  sb.append("<div class='col-sm-3'>");
						  sb.append(strIndentDate);
						  sb.append("</div></div>"); 
						  
						  sb.append("<div class='row'>");
						  sb.append("<div class='col-sm-3'>Req Status</div>");
						  sb.append("<div class='col-sm-3'>");
						  sb.append(strUrgentFlag);
						  sb.append("</div>");
						  sb.append("<div class='col-sm-3'>Req Period</div>");
						  sb.append("<div class='col-sm-3'>");
						  sb.append(strIndentPeriod);
							if (!strIndentPeriodValue.equals("0")) {
								sb.append("/");
								sb.append(strIndentPeriodValue);
							}
						  sb.append("</div></div>"); 
						  
						  sb.append("<div class='row'>");
						  sb.append("<div class='col-sm-3'>Remarks</div>");
						  sb.append("<div class='col-sm-9'>");
						  sb.append(strRemarks);
						  sb.append("</div></div>"); 
						  
					   sb.append("</div>"); 

						  
						/*
						 * sb.append("<table class='table'>");
						 * 
						 * sb.
						 * append("<tr><td class='LABEL' width ='25%' style='font-weight:350 !important ;font-size: 15px !important;'>Request Type Name</td>"
						 * ); sb.
						 * append("<td  class='CONTROL'  width ='25%' style='font-weight:350 !important ;font-size: 15px !important;'> "
						 * ); sb.append(strIndentType); sb.append("</td>"); sb.
						 * append("<td class='LABEL'   width ='25%' style='font-weight:350 !important ;font-size: 15px !important;'>Item Category</td>"
						 * ); sb.
						 * append("<td class='CONTROL' width ='25%' style='font-weight:350 !important ;font-size: 15px !important;'>"
						 * ); sb.append(strItemCatg); sb.append("</td></tr>");
						 * 
						 * sb.
						 * append("<tr><td class='LABEL' width ='25%'  style='font-weight:350 !important ;font-size: 15px !important;'>Raising Store</td>"
						 * ); sb.
						 * append("<td class='CONTROL'  width ='25%' style='font-weight:350 !important ;font-size: 15px !important;'>"
						 * ); sb.append(strStoreName); sb.append("</td>"); sb.
						 * append("<td class='LABEL' width ='25%'  style='font-weight:350 !important ;font-size: 15px !important;'>Receiving Store</td>"
						 * ); sb.
						 * append("<td class='CONTROL' width ='25%'  style='font-weight:350 !important ;font-size: 15px !important;'>"
						 * ); sb.append(strToStore); sb.append("</td></tr>");
						 * 
						 * sb.
						 * append("<tr><td class='LABEL' width ='25%' style='font-weight:350 !important ;font-size: 15px !important;'>Req No</td>"
						 * ); sb.
						 * append("<td class='CONTROL' width ='25%' style='font-weight:350 !important ;font-size: 15px !important;'>"
						 * ); sb.append(strReqNo); sb.append("</td>"); sb.
						 * append("<td class='LABEL' width ='25%'  style='font-weight:350 !important ;font-size: 15px !important;'>Req Date</td>"
						 * ); sb.
						 * append("<td class='CONTROL' width ='25%' style='font-weight:350 !important ;font-size: 15px !important;'>"
						 * ); sb.append(strIndentDate); sb.append("</td></tr>");
						 * 
						 * sb.
						 * append("<tr><td class='LABEL' width ='25%' style='font-weight:350 !important ;font-size: 15px !important;'>Req Status</td>"
						 * ); sb.
						 * append("<td class='CONTROL' width='25%'  style='font-weight:350 !important ;font-size: 15px !important;' >"
						 * ); sb.append(strUrgentFlag); sb.append("</td>"); sb.
						 * append("<td class='LABEL' width='25%'  style='font-weight:350 !important ;font-size: 15px !important;'>Req Period</td>"
						 * ); sb.
						 * append("<td class='CONTROL' width='25%'  style='font-weight:350 !important ;font-size: 15px !important;'>"
						 * ); sb.append(strIndentPeriod); if (!strIndentPeriodValue.equals("0")) {
						 * sb.append("/"); sb.append(strIndentPeriodValue); } sb.append("</td></tr>");
						 * 
						 * sb.
						 * append("<tr><td class='LABEL' width='25%'  style='font-weight:350 !important ;font-size: 15px !important;'>Remarks</td>"
						 * ); sb.
						 * append("<td class='CONTROL' width='75%' style='font-weight:350 !important ;font-size: 15px !important;' colspan=3>"
						 * ); sb.append(strRemarks); sb.append("</td>"); sb.append("</td></tr>");
						 * sb.append("</table>");
						 */
						
						//sb.append("<td width='25%' class='LABEL'>Req Period</td>");
						//sb.append("<td width='25%' class='CONTROL'>");
						//sb.append(strIndentPeriod);
//						sb.append("<td width='25%' class='LABEL'></td>");
//						sb.append("<td width='25%' class='CONTROL'>");
//						sb.append("</td></tr>");
						
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
				/*sb.append("<table class='table'>");
				sb.append("<tr>");
				*/
				sb.append("<div class='errMsg' colspan='5' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>");

				/*
				 * sb.append("</tr>"); sb.append("</table>");
				 */

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
								|| vo.getStrReqTypeId().equals("13")) 
						{
							strCrNo = ws1.getString(8);
							strPatName = ws1.getString(9);
							strEmpID = ws1.getString(10);
							/*
							 * AHIS_FUNCTION.GETCATEGORYNAME(A.HGNUM_PATIENT_CAT_CODE,A.GNUM_HOSPITAL_CODE) ||'^'||				     
						       INITCAP(HRGSTR_FNAME)||
						       DECODE(SIGN(LENGTH(TRIM(HRGSTR_MNAME))-0),1,' '||TRIM(INITCAP(HRGSTR_MNAME)))||
						       DECODE(SIGN(LENGTH(TRIM(HRGSTR_LNAME))-0),1,' '||
						       TRIM(INITCAP(HRGSTR_LNAME)))||' - '||AHIS_UTIL.AGE_SEX(HRGNUM_PUK::CHARACTER VARYING)||'[ '||HRGNUM_PUK||' ]' 
						       || '^' ||HRGNUM_IS_MLC||'^'||HRGNUM_ISNEWBORN ||'^'||HRGSTR_FATHER_NAME				       
						       ||'^'||NVL(HRGNUM_IS_DEAD,0)||'^'||nvl((select gstr_hospital_name from gblt_hospital_mst where gnum_hospital_code=a.gnum_hospital_code),'')
						       ||'^'||TO_CHAR(GDT_ENTRY_DATE,'DD-MON-YYYY HH24:MI:SS')||'^'||NVL(HRGSTR_EMG_CNTC,'')
						       ||'^'||DECODE(HRGNUM_ISNEWBORN,0,'NO','YES:MOTHER CR '||HRGNUM_MOTHER_PUK) 
						       
						       0 - General                                              Patient Category
						       1 - Gabru Jawan - 25 Yr/Male[ 279162100000665 ]          Patient Dtls
						       2 - 0                                                    HRGNUM_IS_MLC            
						       3 - 0                                                    HRGNUM_ISNEWBORN  
						       4 - Sdds                                                 HRGSTR_FATHER_NAME
						       5 - 0                                                    HRGNUM_IS_DEAD
						       6 - All India Institute of Medical Sciences, Nagpur      HOSP_NAME 
						       7 - 03-MAY-2021 18:11:02                                 ADDMISSION DATE
						       8 -                                                      HRGSTR_EMG_CNTC
						       9 - NO                                                   HRGNUM_ISNEWBORN 
							 * 
							 * */
							strEmpName = ws1.getString(11);
							/*
							 * 0 - Dept Name                                            
						       1 - Dept Unit Name                                       
						       2 - Ward Name                                                      
						       3 - Room No                                             
						       4 - Bed No                                               
						       5 - Patient Catg                                         
						       6 - Consultant Name                                       
						       7 - IS New Born                                          
						       8 - Bill Catg 
						       9 - Addmission No
						      10 - Admission Date 
							 * 
							 * */
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

						if (!vo.getStrReqTypeId().equals("14")) 
						{
							if (!vo.getStrReqTypeId().equals("10")) 
							{
								if (k == 0) 
								{
									/*
									 * sb.
									 * append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC'  border='0'  cellspacing ='1px'>"
									 * ); String strArr[] = strEmpID.split("\\^"); String strAddmArr[] =
									 * strEmpName.split("\\^");
									 * 
									 * sb.append("<table class='table'>"); sb.
									 * append("<tr><td class='LABEL' width='25%' style='font-weight:350 !important ;font-size: 15px !important;'>CR NO</td>"
									 * ); sb.
									 * append("<td class='CONTROL' width='25%'   style='font-weight:350 !important ;font-size: 15px !important;'>"
									 * ); sb.append(strCrNo); sb.append("</td>"); sb.
									 * append("<td width='25%' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;'>Patient Dtl</td>"
									 * ); sb.
									 * append("<td width='25%' class='CONTROL' style='font-weight:350 !important ;font-size: 15px !important;'>"
									 * ); sb.append(strArr[1]); sb.append("</td></tr>");
									 * 
									 * sb.
									 * append("<tr><td width='25%' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;'>Category</td>"
									 * ); sb.
									 * append("<td width='25%' class='CONTROL' style='font-weight:350 !important ;font-size: 15px !important;'>"
									 * ); sb.append(strArr[0]); sb.append("</td>"); sb.
									 * append("<td width='25%' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;'>Department Name</td>"
									 * ); sb.
									 * append("<td width='25%' class='CONTROL' style='font-weight:350 !important ;font-size: 15px !important;'>"
									 * ); sb.append(strAddmArr[0]); sb.append("</td></tr>");
									 * 
									 * sb.
									 * append("<tr><td width='25%' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;'>Unit Name</td>"
									 * ); sb.
									 * append("<td width='25%' class='CONTROL' style='font-weight:350 !important ;font-size: 15px !important;'>"
									 * ); sb.append(strAddmArr[1]); sb.append("</td>"); sb.
									 * append("<td width='25%' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;'>Ward Name</td>"
									 * ); sb.
									 * append("<td width='25%' class='CONTROL' style='font-weight:350 !important ;font-size: 15px !important;'>"
									 * ); sb.append(strAddmArr[2]); sb.append("</td></tr>");
									 * 
									 * sb.
									 * append("<tr><td width='25%' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;'>Room / Bed</td>"
									 * ); sb.
									 * append("<td width='25%' class='CONTROL' style='font-weight:350 !important ;font-size: 15px !important;'> "
									 * ); sb.append(strAddmArr[3]+" / "+ strAddmArr[4] ); sb.append("</td>"); sb.
									 * append("<td width='25%' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;'>Admission Dtl</td>"
									 * ); sb.
									 * append("<td width='25%' class='CONTROL' style='font-weight:350 !important ;font-size: 15px !important;'>"
									 * ); sb.append(strAddmArr[9]+" [ "+ strAddmArr[10] +" ]");
									 * sb.append("</td></tr>");
									 */
									
									 sb.append("<div class='container'>");
										String strArr[]     = strEmpID.split("\\^");
										String strAddmArr[] = strEmpName.split("\\^");
									 
									  sb.append("<div class='row'>");
								      sb.append("<div class='col-sm-3'>CR NO</div>");
									  sb.append("<div class='col-sm-3'>");
									  sb.append(strCrNo);
									  sb.append("</div>");
									  sb.append("<div class='col-sm-3'>Patient Dtl</div>");
									  sb.append("<div class='col-sm-3'>");
										sb.append(strArr[1]);
									  sb.append("</div></div>");
									  
									  sb.append("<div class='row'>");
								      sb.append("<div class='col-sm-3'>Category</div>");
									  sb.append("<div class='col-sm-3'>");
										sb.append(strArr[0]);
									  sb.append("</div>");
									  sb.append("<div class='col-sm-3'>Department Name</div>");
									  sb.append("<div class='col-sm-3'>");
										sb.append(strAddmArr[0]);
									  sb.append("</div></div>");
									  
									  sb.append("<div class='row'>");
								      sb.append("<div class='col-sm-3'>Unit Name</div>");
									  sb.append("<div class='col-sm-3'>");
										sb.append(strAddmArr[1]);
									  sb.append("</div>");
									  sb.append("<div class='col-sm-3'>Ward Name</div>");
									  sb.append("<div class='col-sm-3'>");
										sb.append(strAddmArr[2]);
									  sb.append("</div></div>");
									  
									  sb.append("<div class='row'>");
								      sb.append("<div class='col-sm-3'>Room / Bed</div>");
									  sb.append("<div class='col-sm-3'>");
										sb.append(strAddmArr[3]+" / "+ strAddmArr[4] );
									  sb.append("</div>");
									  sb.append("<div class='col-sm-3'>Admission Dtl</div>");
									  sb.append("<div class='col-sm-3'>");
										sb.append(strAddmArr[9]+" [ "+ strAddmArr[10] +" ]");
									  sb.append("</div></div>");
									/*
									 * 0 - Dept Name                                            
								       1 - Dept Unit Name                                       
								       2 - Ward Name                                                      
								       3 - Room No                                             
								       4 - Bed No                                               
								       5 - Patient Catg                                         
								       6 - Consultant Name                                       
								       7 - IS New Born                                          
								       8 - Bill Catg 
								       9 - Addmission No
								      10 - Admission Date 
									 * 
									 * */
									
									/*
									   0 - General                                              Patient Category
								       1 - Gabru Jawan - 25 Yr/Male[ 279162100000665 ]          Patient Dtls
								       2 - 0                                                    HRGNUM_IS_MLC            
								       3 - 0                                                    HRGNUM_ISNEWBORN  
								       4 - Sdds                                                 HRGSTR_FATHER_NAME
								       5 - 0                                                    HRGNUM_IS_DEAD
								       6 - All India Institute of Medical Sciences, Nagpur      HOSP_NAME 
								       7 - 03-MAY-2021 18:11:02                                 ADDMISSION DATE
								       8 -                                                      HRGSTR_EMG_CNTC
								       9 - NO                                                   HRGNUM_ISNEWBORN 
									 * 
									 * */
									if (vo.getStrReqTypeId().equals("12")) {
										
										/*
										 * sb.
										 * append("<tr><td width='25%' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;'>Emp ID</td>"
										 * ); sb.
										 * append("<td width='25%' class='CONTROL' style='font-weight:350 !important ;font-size: 15px !important;'>"
										 * ); sb.append(strEmpID); sb.append("</td>"); sb.
										 * append("<td width='25%' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;'>Emp Name</td>"
										 * ); sb.
										 * append("<td width='25%' class='CONTROL' style='font-weight:350 !important ;font-size: 15px !important;'>"
										 * ); sb.append(strEmpName); sb.append("</td></tr>");
										 */
										
										 sb.append("<div class='row'>");
								         sb.append("<div class='col-sm-3'>Emp ID</div>");
									     sb.append("<div class='col-sm-3'>");
											sb.append(strEmpID);
									     sb.append("</div>");
									     sb.append("<div class='col-sm-3'>Emp Name</div>");
									     sb.append("<div class='col-sm-3'>");
											sb.append(strEmpName);
									     sb.append("</div></div>");
									}

								}
								k++;
							}
						}
					}
					/* sb.append("</table>"); */
				    sb.append("</div>");

				}
			}

			ws1.beforeFirst();

			sb.append("<table class='table'>");
			sb.append("<thead class='thead-dark'>");
			sb.append("<tr>");
			sb.append("<th width='40%' style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</th>");
			//sb.append("<td width='10%' class='multiLabel'>Avl Qty</td>");
			sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</th>");
			sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Sanction Qty</th>");
			sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Rate/Unit</th>");
			sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Remarks</th></tr></thead>");

			if (ws1 != null && ws1.size() > 0) 
			{
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
				while (ws1.next()) 
				{
					if (vo.getStrReqTypeId().equals("10")) 
					{
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
							|| vo.getStrReqTypeId().equals("13")) 
					{
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
					sb.append("<input type='hidden' name ='strHiddenValue'  value='"
							+ strHiddenValue + "'>");
					sb.append("<tr>");
					sb.append("<td width='40%' align='left' style='font-weight:350 !important ;font-size: 15px !important;'>");
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
					/*
					 * sb.append("<td width='10%' class='multiControl'>"); sb.append(strAvlQty);
					 * sb.append("</td>");
					 */
					sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
					sb.append(strReqQty);
					sb.append("</td>");

					sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
					sb.append(strSancQty);
					sb.append("</td>");
					sb.append("<td  width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
					sb.append(strRate);
					sb.append("</td>");
					sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;' ><a value='' style='cursor:pointer;' onClick='openDivItem(this,"
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
				sb.append("</table>");

			}

			else {
				sb.append("<table class='table'>");
				sb.append("<tr>");
				sb.append("<td colspan='6'  style='font-weight:350 !important ;font-size: 15px !important;' >"
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
	
	public static String getIndentDetailsReturnToSupplierViewPrint(IndentApprovalDeskVO vo)
	{
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
					sb.append("<table width='"+vo.getStrTableWidth()+"' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
					
					sb.append("<tr bgcolor='#cdc9c9'> ");					
					sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Request Type Name</b></font> ");
					sb.append("</td>");					
					sb.append("<td colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(strIndentType);
					sb.append("</b></font></td>");
					sb.append("</tr>");
					
					
					sb.append("<tr>");									
					sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Raising Store</b></font></td>");
					sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(strStoreName);
					sb.append("</b></font></td> ");										
					sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier Name</b></font></td>");
					sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(strSupplierName);
					sb.append("</b></font></td> ");								
					sb.append("</tr>");
					
					sb.append("<tr>");									
					sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return Req No</b></font></td>");
					sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(strReqNo);
					sb.append("</b></font></td> ");										
					sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return Req Date</b></font></td>");
					sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(strIndentDate);
					sb.append("</b></font></td> ");								
					sb.append("</tr>");
					
					sb.append("<tr>");									
					sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No</b></font></td>");
					sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(strPONo);
					sb.append("</b></font></td> ");										
					sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>PO Date</b></font></td>");
					sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(strPODate);
					sb.append("</b></font></td> ");								
					sb.append("</tr>");
					
					sb.append("<tr>");									
					sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>PO Type</b></font></td>");
					sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(strPOTypeId);
					sb.append("</b></font></td> ");										
					sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Delivery Date</b></font></td>");
					sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(strDeliveryDate);
					sb.append("</b></font></td> ");								
					sb.append("</tr>");					
					sb.append("</table>");

				}

			} else {
				sb.append("<table width='"+vo.getStrTableWidth()+"' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
				sb.append("<tr>");
				sb.append("<td colspan='5'  CLASS='multiControl' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>"
						+ "</TD>");

				sb.append("</tr>");
				sb.append("</table>");

			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentApprovalDeskHLP.getIndentDetailsReturnToSupplierViewPrint() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}
	
	public static String getItemDetailsViewPrint(IndentApprovalDeskVO vo) 
	{
		StringBuffer sb = new StringBuffer("");
		String strHiddenValue = "";
		WebRowSet ws1 = vo.getStrItemDetailsWs();
		String strRemarks = "";
		int i = 0;
		try {
			sb.append("<table width='"+vo.getStrTableWidth()+"' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
			if (vo.getStrReqTypeId().equals("65")
					|| vo.getStrReqTypeId().equals("19")
					|| vo.getStrReqTypeId().equals("16")
					|| vo.getStrReqTypeId().equals("18"))
			{
				
				
                sb.append("<tr bgcolor='#cdc9c9'> ");
				
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
				sb.append("</td>");
			
				sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No</b></font> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Req Qty</b></font>");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Approved Qty</b></font> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font> ");
				sb.append("</td> ");
				
				//sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks</b></font> ");
				//sb.append("</td> ");
				
				sb.append("</tr> ");
				
				
			}
			else 
			{
			
				
			    sb.append("<tr bgcolor='#cdc9c9'> ");
					
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
				sb.append("</td>");			
			
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Req Qty</b></font>");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Approved Qty</b></font> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font> ");
				sb.append("</td> ");
				
				//sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks</b></font> ");
				//sb.append("</td> ");
				
				sb.append("</tr> ");
			}

			if (ws1 != null) 
			{
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


				while (ws1.next()) 
				{
					if (vo.getStrReqTypeId().equals("47")) 
					{

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
							|| vo.getStrReqTypeId().equals("84")|| vo.getStrReqTypeId().equals("86")|| vo.getStrReqTypeId().equals("90")) 
					{
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
							|| vo.getStrReqTypeId().equals("19")) 
					{
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
							|| vo.getStrReqTypeId().equals("82")) 
					{
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

					if (vo.getStrReqTypeId().equals("18")) 
					{
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
					if (vo.getStrReqTypeId().equals("61")) 
					{
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

					if (vo.getStrReqTypeId().equals("65")) 
					{
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
							|| vo.getStrReqTypeId().equals("18")) 
					{
						
						sb.append("<tr> ");							
						
						sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
						sb.append(strItemName);
						sb.append("</font></td> ");
						
						sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
						sb.append(strBatchNo);
						sb.append("</font></td> ");
						
						sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
						sb.append(strReqQty);
						sb.append("</font></td> ");
						
						sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
						sb.append(strSancQty);
						sb.append("</font></td> ");
						
						sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
						sb.append(strRate);
						sb.append("</font></td> ");
						
						/*
						 * sb.
						 * append("<td align='left' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>"
						 * ); sb.append(strRemarks); sb.append("</b></font></td> ");
						 */
						
						sb.append("</tr> ");
						

						/*
						 * sb.
						 * append("<td class='multiControl' width='5%'><a value='' style='cursor:pointer;'  onClick='openDivItem(this,"
						 * + i +
						 * ");' title='Click here to Enter Remarks' style='cursor:pointer;'><font color='blue'>#</font></a>"
						 * ); sb.append("<div id='remarksId" + i +
						 * "' class='popup' style='display:none'>");
						 * sb.append("<table width='400' align='center'>");
						 * sb.append("<tr class='HEADER'><th align='left'>Remarks For " + strItemName +
						 * "</th>"); sb.
						 * append("<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'"
						 * ); sb.append(" onClick='closeDivItem(" + i +
						 * ");' title='Click Here To Close Popup'></th></tr>"); sb.append("</table>");
						 * sb.
						 * append("<table width='400' align='center' cellspacing='1px' cellpadding='1px'>"
						 * ); sb.append("<tr><td class='LABEL' width='25%'>Remarks</td>"); sb.
						 * append("<td class='CONTROL' width='75%'> <textarea  cols='20' rows='2' readOnly='readOnly' >"
						 * + strRemarks + "</textarea></td>"); sb.append("</tr>");
						 * sb.append("<tr class='FOOTER'><td colspan='2'></td></tr>");
						 * sb.append("</table>"); sb.append("</div></td></tr>");
						 */

					} 
					else 
					{
						
						
                        sb.append("<tr> ");	
						sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
						sb.append(strItemName);
						sb.append("</font></td> ");
						
						sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
						sb.append(strReqQty);
						sb.append("</font></td> ");
						
						
						sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
						sb.append(strSancQty);
						sb.append("</font></td> ");

						sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
						sb.append(strRate);
						sb.append("</font></td> ");
						
						/*
						 * sb.
						 * append("<td class='multiControl' width='5%'><a value=''  onClick='openDivItem(this,"
						 * + i +
						 * ");' title='Click here to View Remarks' style='cursor:pointer'><font color='blue'>#</font></a>"
						 * ); sb.append("<div id='remarksId" + i +
						 * "' class='popup' style='display:none'>");
						 * sb.append("<table width='400' align='center'>");
						 * sb.append("<tr class='HEADER'><th align='left'>Remarks For " + strItemName +
						 * "</th>"); sb.
						 * append("<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'"
						 * ); sb.append(" onClick='closeDivItem(" + i +
						 * ");' title='Click Here To Close Popup'></th></tr>"); sb.append("</table>");
						 * sb.
						 * append("<table width='400' align='center' cellspacing='1px' cellpadding='1px'>"
						 * ); sb.append("<tr><td class='LABEL' width='25%'>Remarks</td>"); sb.
						 * append("<td class='CONTROL' width='75%'> <textarea  cols='20' rows='2' readOnly='readOnly' >"
						 * + strRemarks + "</textarea></td>"); sb.append("</tr>");
						 * sb.append("<tr class='FOOTER'><td colspan='2'></td></tr>");
						 * sb.append("</table>"); sb.append("</div></td>");
						 */
						sb.append("</tr>");

					}
					i++;
				}
				sb.append("</table>");

			} else {
				sb.append("<table width='"+vo.getStrTableWidth()+"' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
				sb.append("<tr>");							
				
				sb.append("<td colspan='5' align='center' ><DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div></TD>");
				sb.append("</tr>");
				sb.append("</table>");

			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentApprovalDeskHLP.getItemDetailsViewPrint() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}
	
	public static String getItemDetailsView1Print(IndentApprovalDeskVO vo) 
	{
		StringBuffer sb = new StringBuffer("");
		String strHiddenValue = "";
		WebRowSet ws1 = vo.getStrItemDetailsWs();
		String strRemarks = "";
		int i = 0, k = 0 , j=1;
		
		try 
		{

			if (ws1 != null && ws1.size() > 0) 
			{
				String strCrNo = null;
				String strPatName = null;
				String strEmpID = null;
				String strEmpName = null;
				if (k == 0) 
				{
					sb.append("<table width='"+vo.getStrTableWidth()+"' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
					while (ws1.next())
					{
						if (vo.getStrReqTypeId().equals("14")) 
						{
							strCrNo = ws1.getString(10);
							strPatName = ws1.getString(11);
							strEmpID = ws1.getString(12);
							strEmpName = ws1.getString(13);
							strRemarks = ws1.getString(21);

						}
						if (vo.getStrReqTypeId().equals("12")
								|| vo.getStrReqTypeId().equals("13")) 
						{
							strCrNo = ws1.getString(8);
							strPatName = ws1.getString(9);
							strEmpID = ws1.getString(10);
							/*
							 * AHIS_FUNCTION.GETCATEGORYNAME(A.HGNUM_PATIENT_CAT_CODE,A.GNUM_HOSPITAL_CODE) ||'^'||				     
						       INITCAP(HRGSTR_FNAME)||
						       DECODE(SIGN(LENGTH(TRIM(HRGSTR_MNAME))-0),1,' '||TRIM(INITCAP(HRGSTR_MNAME)))||
						       DECODE(SIGN(LENGTH(TRIM(HRGSTR_LNAME))-0),1,' '||
						       TRIM(INITCAP(HRGSTR_LNAME)))||' - '||AHIS_UTIL.AGE_SEX(HRGNUM_PUK::CHARACTER VARYING)||'[ '||HRGNUM_PUK||' ]' 
						       || '^' ||HRGNUM_IS_MLC||'^'||HRGNUM_ISNEWBORN ||'^'||HRGSTR_FATHER_NAME				       
						       ||'^'||NVL(HRGNUM_IS_DEAD,0)||'^'||nvl((select gstr_hospital_name from gblt_hospital_mst where gnum_hospital_code=a.gnum_hospital_code),'')
						       ||'^'||TO_CHAR(GDT_ENTRY_DATE,'DD-MON-YYYY HH24:MI:SS')||'^'||NVL(HRGSTR_EMG_CNTC,'')
						       ||'^'||DECODE(HRGNUM_ISNEWBORN,0,'NO','YES:MOTHER CR '||HRGNUM_MOTHER_PUK) 
						       
						       0 - General                                              Patient Category
						       1 - Gabru Jawan - 25 Yr/Male[ 279162100000665 ]          Patient Dtls
						       2 - 0                                                    HRGNUM_IS_MLC            
						       3 - 0                                                    HRGNUM_ISNEWBORN  
						       4 - Sdds                                                 HRGSTR_FATHER_NAME
						       5 - 0                                                    HRGNUM_IS_DEAD
						       6 - All India Institute of Medical Sciences, Nagpur      HOSP_NAME 
						       7 - 03-MAY-2021 18:11:02                                 ADDMISSION DATE
						       8 -                                                      HRGSTR_EMG_CNTC
						       9 - NO                                                   HRGNUM_ISNEWBORN 
							 * 
							 * */
							strEmpName = ws1.getString(11);
							/*
							 * 0 - Dept Name                                            
						       1 - Dept Unit Name                                       
						       2 - Ward Name                                                      
						       3 - Room No                                             
						       4 - Bed No                                               
						       5 - Patient Catg                                         
						       6 - Consultant Name                                       
						       7 - IS New Born                                          
						       8 - Bill Catg 
						       9 - Addmission No
						      10 - Admission Date 
							 * 
							 * */
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

						if (!vo.getStrReqTypeId().equals("14")) 
						{
							if (!vo.getStrReqTypeId().equals("10")) 
							{
								if (k == 0) 
								{	
									
							
									String strArr[]     = strEmpID.split("\\^");
									String strAddmArr[] = strEmpName.split("\\^");								
									
									sb.append("<tr>");									
									sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>CR NO:</b></font></td>");
									sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
									sb.append(strCrNo);
									sb.append("</font></td> ");										
									sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Patient Dtl:</b></font></td>");
									sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
									sb.append(strArr[1]);
									sb.append("</font></td> ");								
									sb.append("</tr>");
									
									sb.append("<tr>");									
									sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Category:</b></font></td>");
									sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
									sb.append(strArr[0]);
									sb.append("</font></td> ");										
									sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Department Name:</b></font></td>");
									sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
									sb.append(strAddmArr[0]);
									sb.append("</font></td> ");								
									sb.append("</tr>");
									
									sb.append("<tr>");									
									sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Unit Name:</b></font></td>");
									sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
									sb.append(strAddmArr[1]);
									sb.append("</font></td> ");										
									sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Ward Name:</b></font></td>");
									sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
									sb.append(strAddmArr[2]);
									sb.append("</font></td> ");								
									sb.append("</tr>");		
									
									sb.append("<tr>");									
									sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Room / Bed:</b></font></td>");
									sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
									sb.append(strAddmArr[3]+" / "+ strAddmArr[4] );
									sb.append("</font></td> ");										
									sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Addmission Dtl:</b></font></td>");
									sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
									sb.append(strAddmArr[9]+" [ "+ strAddmArr[10] +" ]");
									sb.append("</font></td> ");								
									sb.append("</tr>");													
									/*
									 * 0 - Dept Name                                            
								       1 - Dept Unit Name                                       
								       2 - Ward Name                                                      
								       3 - Room No                                             
								       4 - Bed No                                               
								       5 - Patient Catg                                         
								       6 - Consultant Name                                       
								       7 - IS New Born                                          
								       8 - Bill Catg 
								       9 - Addmission No
								      10 - Admission Date 
									 * 
									 * */
									
									/*
									   0 - General                                              Patient Category
								       1 - Gabru Jawan - 25 Yr/Male[ 279162100000665 ]          Patient Dtls
								       2 - 0                                                    HRGNUM_IS_MLC            
								       3 - 0                                                    HRGNUM_ISNEWBORN  
								       4 - Sdds                                                 HRGSTR_FATHER_NAME
								       5 - 0                                                    HRGNUM_IS_DEAD
								       6 - All India Institute of Medical Sciences, Nagpur      HOSP_NAME 
								       7 - 03-MAY-2021 18:11:02                                 ADDMISSION DATE
								       8 -                                                      HRGSTR_EMG_CNTC
								       9 - NO                                                   HRGNUM_ISNEWBORN 
									 * 
									 * */
									if (vo.getStrReqTypeId().equals("12")) 
									{																				
										sb.append("<tr>");									
										sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Emp ID:</b></font></td>");
										sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
										sb.append(strEmpID );
										sb.append("</b></font></td> ");										
										sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Emp Name:</b></font></td>");
										sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
										sb.append(strEmpName);
										sb.append("</b></font></td> ");								
										sb.append("</tr>");				
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
			
			sb.append("<table width='"+vo.getStrTableWidth()+"' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
			
			sb.append("<tr bgcolor='#cdc9c9'> ");
			
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='45%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
			sb.append("</td>");
			/*
			sb.append("<td align='center' width='45%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Avl Qty</b></font> ");
			sb.append("</td>");
			*/

			sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Req Qty</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Sanction Qty</b></font>");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font> ");
			sb.append("</td> ");
			
			sb.append("</tr> ");
			
			if (ws1 != null && ws1.size() > 0) 
			{
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
				while (ws1.next()) 
				{
					if (vo.getStrReqTypeId().equals("10")) 
					{
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

					if (vo.getStrReqTypeId().equals("12")|| vo.getStrReqTypeId().equals("13")) 
					{
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
					if (vo.getStrReqTypeId().equals("14"))
					{
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
					
					
					sb.append("<tr> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(j);
					sb.append("</b></font></td> ");
					
					sb.append("<td align='left' width='45%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
					sb.append(strItemName);
					sb.append("</font></td> ");
					
					/*
					sb.append("<td align='left' width='45%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
					sb.append(strAvlQty);
					sb.append("</b></font></td> ");
					*/
					
					sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
					sb.append(strReqQty);
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
					sb.append(strSancQty);
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
					sb.append(strRate);
					sb.append("</font></td> ");									
					
					sb.append("</tr>");
					i++;
					j++;
				}
				sb.append("</table>");

			}

			else 
			{
				sb.append("<table width='"+vo.getStrTableWidth()+"' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
				sb.append("<tr>");								
				sb.append("<td align='center' colspan='6'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b> No Record Found </b></font></td> ");
				sb.append("</tr>");
				sb.append("</table>");

			}
			vo.setStrMultiRow(i + "");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			vo.setStrMsgString("IndentApprovalDeskHLP.getItemDetailsView1Print() --> "+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}
	
	
	public static String getIndentDetailsViewPrint(IndentApprovalDeskVO vo) 
	{

		StringBuffer sb = new StringBuffer("");

		try {
			WebRowSet ws = vo.getStrIndentDetailsWs();
			if (ws != null && ws.size() > 0) {
				if (ws.next()) {
					if (vo.getStrReqTypeId().equals("65")) 
					{
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

						sb.append("<table width='"+vo.getStrTableWidth()+"' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");

											
                        sb.append("<tr>");						
						sb.append("<td align='center' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><u>");
						sb.append(strIndentType);
						sb.append("</u></font></td>");
						sb.append("</tr>");
						
						sb.append("<tr>");									
						sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Raising Store:</b></font></td>");
						sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strStoreName);
						sb.append("</font></td> ");										
						sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Third Party Name:</b></font></td>");
						sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strThirdPartyName);
						sb.append("</font></td> ");								
						sb.append("</tr>");
						
						sb.append("<tr>");									
						sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Req No:</b></font></td>");
						sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strReqNo);
						sb.append("</font></td> ");										
						sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Req Date:</b></font></td>");
						sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strIndentDate);
						sb.append("</font></td> ");								
						sb.append("</tr>");
						
						sb.append("<tr>");									
						sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Category:</b></font></td>");
						sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strItemCatg);
						sb.append("</font></td> ");										
						sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
						sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						
						sb.append("</font></td> ");								
						sb.append("</tr>");						
						
						sb.append("</table>");
					} 
					else 
					{
						String strReqNo = ws.getString(1);
						String strStoreName = ws.getString(2);
						String strIndentDate = ws.getString(3);
						String strItemCatg = ws.getString(4);
						String strIndentType = ws.getString(5);
						String strToStore = ws.getString(6);
						// String strCommitteTypeId = ws.getString(12);
						
						String strAppRemarks = ws.getString(15);

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
						
						sb.append("<table width='"+vo.getStrTableWidth()+"' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");

						
						sb.append("<tr>");		
						
						sb.append("<td align='center' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><u>");
						sb.append(strIndentType);
						sb.append("</u></font></td>");
						sb.append("</tr>");
						
						sb.append("<tr>");									
						sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Store Name:</b></font></td>");
						sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strStoreName);
						sb.append("</font></td> ");										
						sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Category:</b></font></td>");
						sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strItemCatg);
						sb.append("</font></td> ");								
						sb.append("</tr>");
						
						sb.append("<tr>");									
						sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Indent No:</b></font></td>");
						sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strReqNo);
						sb.append("</font></td> ");										
						sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Indent Date:</b></font></td>");
						sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strIndentDate);
						sb.append("</font></td> ");								
						sb.append("</tr>");
						
						sb.append("<tr>");									
						sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Indent Type:</b></font></td>");
						sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strIndentType);
						sb.append("</font></td> ");										
						sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>To Store Name:</b></font></td>");
						sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strToStore);
						sb.append("</font></td> ");								
						sb.append("</tr>");
						
						sb.append("<tr>");									
						sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks:</b></font></td>");
						sb.append("<td align='left' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strAppRemarks);
						sb.append("</font></td> ");
						sb.append("</tr>");												
						
						if (vo.getStrReqTypeId().equals("16")) 
						{
							vo.setStrCommitteTypeCode(ws.getString(12));
							IndentApprovalDeskDAO
									.callingFunctionCommitteNameView(vo);
							if (!vo.getStrCommitteTypeName().equals("/")) 
							{
								/*
								 * sb.append("<tr>");
								 * sb.append("<td width='25%' class='LABEL'>CommitteType Name</td>");
								 * sb.append("<td width='25%' class='CONTROL'>");
								 * sb.append(vo.getStrCommitteTypeName()); sb.append("</td>");
								 * sb.append("<td width='25%' class='LABEL'></td>");
								 * sb.append("<td width='25%' class='CONTROL'>"); sb.append("</td>");
								 * sb.append("</tr>");
								 */
								
								sb.append("<tr>");									
								sb.append("<td align='right ' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>CommitteType Name</b></font></td>");
								sb.append("<td align='left' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
								sb.append(vo.getStrCommitteTypeName());
								sb.append("</b></font></td> ");
								sb.append("</tr>");		
							}
						}

						sb.append("</table>");

					}
				}
			} else {
				sb.append("<table width='"+vo.getStrTableWidth()+"' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
				sb.append("<tr>");
				sb.append("<td colspan='5'><DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div></TD>");
				sb.append("</tr>");
				sb.append("</table>");

			}
		} catch (Exception e) {
			vo.setStrMsgString("IndentApprovalDeskHLP.getIndentDetailsViewPrint() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}
	
	public static String getItemDetailsReturnFromSupplierPrint(IndentApprovalDeskVO vo) 
	{
		StringBuffer sb = new StringBuffer("");	
		WebRowSet ws1 = vo.getStrItemDetailsWs();

		int i = 0;
		try
		{
			sb.append("<table width='"+vo.getStrTableWidth()+"' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");

			if (vo.getStrReqTypeId().equals("47")) 
			{
				
				
				sb.append("<tr bgcolor='#cdc9c9'> ");
								
				sb.append("<td align='center' width='40%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
				sb.append("</td>");
			
				sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No</b></font> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Accp Qty</b></font>");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>To Be Return Qty</b></font> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font> ");
				sb.append("</td> ");
				
				sb.append("</tr> ");
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
				while (ws1.next())
				{
					if (vo.getStrReqTypeId().equals("47")) 
					{
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

						
						IndentApprovalDeskDAO.getUnitCombo(vo,
								strProcIndentQtyUnit);

					
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

					if (vo.getStrReqTypeId().equals("47")) 
					{
						
						sb.append("<tr>");					
						
						sb.append("<td align='left' width='40%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
						sb.append(strItemName);
						sb.append("</b></font></td> ");
						
						sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
						sb.append(strBatchNo);
						sb.append("</b></font></td> ");
						
						sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
						sb.append(strAcceptedQty);
						sb.append("</b></font></td> ");						
						
						sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
						sb.append(strReqQty);
						sb.append("</b></font></td> ");
						
						sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
						sb.append(strCost);
						sb.append("</b></font></td> ");			
						
						sb.append("</tr>");
					}

					i++;
				}
				sb.append("</table>");

			} 
			else 
			{
				sb.append("<table width='"+vo.getStrTableWidth()+"' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
				sb.append("<tr>");			
				
				sb.append("<td align='left' colspan='5'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b> NO RECORD FOUND FOR SELECTED INDENT NO.</b></font></td> ");			

				sb.append("</tr>");
				sb.append("</table>");

			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IndentApprovalDeskHLP.getItemDetailsReturnFromSupplierPrint() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}

		return sb.toString();
	}
	
	public static String getItemDetailsForReceiveFromThirdPartyPrint(IndentApprovalDeskVO vo) 
	{
		StringBuffer sb = null;

		final int LMIT_VAL = 10;
		int m = 0;
		WebRowSet ws = vo.getStrItemDetailsWs();

		try 
		{

			sb = new StringBuffer("");

			if (ws != null && ws.size() > 0) {

				ws.beforeFirst();

				int noOfRecords = ws.size();
				int layerNo = noOfRecords / LMIT_VAL;
				int reminder = noOfRecords % LMIT_VAL;
				int totalLayer = layerNo;

				if (reminder > 0)

					totalLayer = totalLayer + 1;

				sb.append("<table width='"+vo.getStrTableWidth()+"' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
				sb.append("<tr> ");
				sb.append("<td align='center' colspan='5'>Received Item Details");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("<tr>");
				sb.append("<td align='center' colspan='5'>&nbsp;");
				for (int i = 1; i <= totalLayer; i++) 
				{

					if (i == 1) 
					{
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
				
				sb.append("<tr bgcolor='#cdc9c9'> ");
				
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received No.</b></font> ");
				sb.append("</td>");
			
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Date</b></font> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Institute</b></font>");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty.</b></font> ");
				sb.append("</td> ");
				
				sb.append("</tr> ");
				
				sb.append("</table> ");

				for (int i = 1; i <= totalLayer; i++) 
				{

					if (i != totalLayer && totalLayer != 1) 
					{
						if (i == 1) {
							sb.append("<div id='tariffDivId" + i
									+ "' style='display:block'>");
						} else {
							sb.append("<div id='tariffDivId" + i
									+ "' style='display:none'>");
						}
						
						sb.append("<table width='"+vo.getStrTableWidth()+"' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
						for (int j = 0; j < LMIT_VAL; j++) 
						{
							ws.next();

							sb.append("<tr> ");							
							
							sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
							sb.append(ws.getString(1));
							sb.append("</b></font></td> ");
							
							sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
							sb.append(ws.getString(2));
							sb.append("</b></font></td> ");
							
							sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
							sb.append(ws.getString(3));
							sb.append("</b></font></td> ");
							
							sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
							sb.append(ws.getString(4));
							sb.append("</b></font></td> ");
							
							sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
							sb.append(ws.getString(5));
							sb.append("</b></font></td> ");
							/*
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
							*/
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
							/*
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
							*/
							
							sb.append("<tr> ");							
							
							sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
							sb.append(ws.getString(1));
							sb.append("</b></font></td> ");
							
							sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
							sb.append(ws.getString(2));
							sb.append("</b></font></td> ");
							
							sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
							sb.append(ws.getString(3));
							sb.append("</b></font></td> ");
							
							sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
							sb.append(ws.getString(4));
							sb.append("</b></font></td> ");
							
							sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
							sb.append(ws.getString(5));
							sb.append("</b></font></td> ");
							/*
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
							*/
							sb.append("</tr> ");

						}
						sb.append("</table>");
						sb.append("</div>");

					}
					m++;
				}

			} 
			else 
			{
				sb.append("<table width='"+vo.getStrTableWidth()+"' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
				
                sb.append("<tr bgcolor='#cdc9c9'> ");
				
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received No.</b></font> ");
				sb.append("</td>");
			
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Date</b></font> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Institute</b></font>");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty.</b></font> ");
				sb.append("</td> ");
				
				sb.append("</tr> ");
				sb.append("</table> ");

				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr><td  colspan='5' ><font color='red'>No Matching Record Found</font></td></tr>");
				sb.append("</table>");
			}

		} 
		catch (Exception e) 
		{

			 e.printStackTrace();
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
				sb.append("<thead class='thead-dark'>");
				sb.append("<tr>");
				sb.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</th>");
				sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Batch No</th>");
			//	sb.append("<td width='15%' class='multiLabel'>Avl Qty</td>");
				sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</th>");
				sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Approved Qty</th>");
				sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Rate/Unit</th>");
				sb.append("<th width='5%' style='font-weight:350 !important ;font-size: 16px !important;'>Remarks</th>");
				sb.append("</tr>");
				sb.append("<thead>"); 

			} else {
				sb.append("<thead class='thead-dark'>");
				sb.append("<tr>");
				sb.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</th>");
			//	sb.append("<td width='20%' class='multiLabel'>Available Qty</td>");
				sb.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</th>");
				sb.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Approved Qty</th>");
				sb.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Rate/Unit</th>");
				sb.append("<th width='5%' style='font-weight:350 !important ;font-size: 16px !important;'>Remarks</th>");
				sb.append("</tr>");
				sb.append("<thead>"); 

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
						sb.append("<tr>");
						sb.append("<td width='20%' align='left' style='font-weight:350 !important ;font-size: 15px !important;'>");
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
						sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
						sb.append(strBatchNo);
						sb.append("</td>");
//						sb.append("<td width='15%' style='font-weight:350 !important ;font-size: 15px !important;'>");
//						sb.append(strAvlQty);
//						sb.append("</td>");
						sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
						sb.append(strReqQty);
						sb.append("</td>");

						sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
						sb.append(strSancQty);
						sb.append("</td>");
						sb.append("<td  width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
						sb.append(strRate);
						sb.append("</td>");

						sb.append("<td width='5%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'><a value='' style='cursor:pointer;'  onClick='openDivItem(this,"
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
						sb.append("<tr class='FOOTER'><td colspan='2'></td></tr>");
						sb.append("</table>");
						sb.append("</div></td></tr>");

					} else {
						sb.append("<input type='hidden' name ='strHiddenValue'  value='"
								+ strHiddenValue + "'>");
						sb.append("<tr>");
						sb.append("<td width='20%' align='left' style='font-weight:350 !important ;font-size: 15px !important;'>");
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
						sb.append("<td width='20%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
						sb.append(strReqQty);
						sb.append("</td>");

						sb.append("<td width='20%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
						sb.append(strSancQty);
						sb.append("</td>");
						sb.append("<td  width='15%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'>");
						sb.append(strRate);
						sb.append("</td>");
						sb.append("</td>");
 
						sb.append("<td width='5%' align='center' style='font-weight:350 !important ;font-size: 15px !important;'><a value=''  onClick='openDivItem(this,"
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
						sb.append("<tr class='FOOTER'><td colspan='2'></td></tr>");
						sb.append("</table>");
						sb.append("</div></td>");
						sb.append("</tr>");

					}
					i++;
				}
				sb.append("</table>");

			} else {
				sb.append("<table class='table' >");
				sb.append("<tr>");
				sb.append("<td colspan='6'  style='font-weight:350 !important ;font-size: 15px !important;' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>"
						+ "</TD>");

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
					if (vo.getStrReqTypeId().equals("65")) 
					{
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
						
						
						/*
						 * sb.
						 * append("<table class='TABLEWIDTH' align='center' border='0'  cellspacing ='1px'>"
						 * ); sb.append("<tr><td width='25%' class='LABEL'>Request Type Name</td>");
						 * sb.append("<td colspan='3' width='25%' class='CONTROL'> ");
						 * sb.append(strIndentType); sb.append("</td></tr>");
						 * 
						 * sb.append("<tr><td width='25%' class='LABEL'>Raising Store</td>");
						 * sb.append("<td width='25%' class='CONTROL'>"); sb.append(strStoreName);
						 * sb.append("</td>");
						 * sb.append("<td width='25%' class='LABEL'>Third Party Name</td>");
						 * sb.append("<td width='25%' class='CONTROL'>"); sb.append(strThirdPartyName);
						 * sb.append("</td></tr>");
						 * 
						 * sb.append("<tr><td width='25%' class='LABEL'>Req No</td>");
						 * sb.append("<td width='25%' class='CONTROL'>"); sb.append(strReqNo);
						 * sb.append("</td>"); sb.append("<td width='25%' class='LABEL'>Req Date</td>");
						 * sb.append("<td width='25%' class='CONTROL'>"); sb.append(strIndentDate);
						 * sb.append("</td></tr>");
						 * 
						 * sb.append("<tr><td width='25%' class='LABEL'>Item Category</td>");
						 * sb.append("<td width='25%' class='CONTROL'>"); sb.append(strItemCatg);
						 * sb.append("</td>"); sb.append("<td width='25%' class='LABEL'></td>");
						 * sb.append("<td width='25%' class='CONTROL'>"); sb.append("</td></tr>");
						 * sb.append("</table>");
						 */
						
					 	  sb.append("<div class='container'>");
						  sb.append("<div class='row'>");
					      sb.append("<div class='col-sm-3'>Request Type Name</div>");
						  sb.append("<div class='col-sm-3' colspan='3'>");
						  sb.append(strIndentType);
						  sb.append("</div></div>");
						  
						  sb.append("<div class='row'>");
						  sb.append("<div class='col-sm-3'>Raising Store</div>");
						  sb.append("<div class='col-sm-3'>");
						  sb.append(strStoreName);
						  sb.append("</div>");
						  sb.append("<div class='col-sm-3'>Third Party Name</div>");
						  sb.append("<div class='col-sm-3'>");
						  sb.append(strThirdPartyName);
						  sb.append("</div></div>");
						  
						  sb.append("<div class='row'>");
						  sb.append("<div class='col-sm-3'>Req No</div>");
						  sb.append("<div class='col-sm-3'>");
						  sb.append(strReqNo);
						  sb.append("</div>");
						  sb.append("<div class='col-sm-3'>Req Date</div>");
						  sb.append("<div class='col-sm-3'>");
						  sb.append(strIndentDate);
						  sb.append("</div></div>");
						
						  sb.append("<div class='row'>");
						  sb.append("<div class='col-sm-3'>Item Category</div>");
						  sb.append("<div class='col-sm-3'>");
						  sb.append(strItemCatg);
						  sb.append("</div>");
						  sb.append("<div class='col-sm-3'></div>");
						  sb.append("<div class='col-sm-3'></div>");
						  sb.append("</div></div>");
		
					} 
					else 
					{
						String strReqNo = ws.getString(1);
						String strStoreName = ws.getString(2);
						String strIndentDate = ws.getString(3);
						String strItemCatg = ws.getString(4);
						String strIndentType = ws.getString(5);
						String strToStore = ws.getString(6);
						// String strCommitteTypeId = ws.getString(12);
						
						String strAppRemarks = ws.getString(15);

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
						/*
						 * sb.append("<table class='table'>");
						 * 
						 * if(vo.getStrItemCatgNo()!=null && vo.getStrItemCatgNo().equals("10")) sb.
						 * append("<tr><td width='25%' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;' >Store Name</td>"
						 * ); else sb.
						 * append("<tr><td width='25%' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;' >Store Name</td>"
						 * ); sb.
						 * append("<td width='25%' class='CONTROL' style='font-weight:350 !important ;font-size: 15px !important;'>"
						 * ); sb.append(strStoreName); sb.append("</td>"); sb.
						 * append("<td width='25%' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;'>Item Category</td>"
						 * ); sb.
						 * append("<td width='25%' class='CONTROL' style='font-weight:350 !important ;font-size: 15px !important;'>"
						 * ); sb.append(strItemCatg); sb.append("</td></tr>");
						 * 
						 * sb.
						 * append("<tr><td width='25%' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;'>Indent No</td>"
						 * ); sb.
						 * append("<td width='25%' class='CONTROL' style='font-weight:350 !important ;font-size: 15px !important;'>"
						 * ); sb.append(strReqNo); sb.append("</td>"); sb.
						 * append("<td width='25%' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;'>Indent Date</td>"
						 * ); sb.
						 * append("<td width='25%' class='CONTROL' style='font-weight:350 !important ;font-size: 15px !important;'>"
						 * ); sb.append(strIndentDate); sb.append("</td></tr>");
						 * 
						 * sb.
						 * append("<tr><td width='25%' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;'>Indent Type</td>"
						 * ); sb.
						 * append("<td width='25%' class='CONTROL' style='font-weight:350 !important ;font-size: 15px !important;'>"
						 * ); sb.append(strIndentType); sb.append("</td>");
						 * if(vo.getStrItemCatgNo()!=null && vo.getStrItemCatgNo().equals("10")) sb.
						 * append("<td width='25%' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;'>To Store Name</td>"
						 * ); else sb.
						 * append("<td width='25%' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;'>To Store Name</td>"
						 * ); sb.
						 * append("<td width='25%' class='CONTROL' style='font-weight:350 !important ;font-size: 15px !important;'>"
						 * ); sb.append(strToStore); sb.append("</td></tr>");
						 * 
						 * sb.
						 * append("<tr><td colspan='1' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;'>Remarks </td>"
						 * ); sb.
						 * append("<td colspan='3'     class='CONTROL' style='font-weight:350 !important ;font-size: 15px !important;'>"
						 * ); sb.append(strAppRemarks); sb.append("</td></tr>");
						 */
						
						  sb.append("<div class='container'>");
						  sb.append("<div class='row'>");
							if(vo.getStrItemCatgNo()!=null && vo.getStrItemCatgNo().equals("10"))
						  sb.append("<div class='col-sm-3'>Store Name</div>");
							else
					      sb.append("<div class='col-sm-3'>Store Name</div>");
						  sb.append("<div class='col-sm-3'>");
						  sb.append(strStoreName);
						  sb.append("</div>");
						  sb.append("<div class='col-sm-3'>Item Category</div>");
						  sb.append("<div class='col-sm-3'>");
						  sb.append(strItemCatg);
						  sb.append("</div></div>");
						
						  sb.append("<div class='row'>");
						  sb.append("<div class='col-sm-3'>Indent No</div>");
						  sb.append("<div class='col-sm-3'>");
						  sb.append(strReqNo);
						  sb.append("</div>");
						  sb.append("<div class='col-sm-3'>Indent Date</div>");
						  sb.append("<div class='col-sm-3'>");
						  sb.append(strIndentDate);
						  sb.append("</div></div>");
						  
						  sb.append("<div class='row'>");
						  sb.append("<div class='col-sm-3'>Indent Type</div>");
						  sb.append("<div class='col-sm-3'>");
						  sb.append(strIndentType);
						  sb.append("</div>");
						  	if(vo.getStrItemCatgNo()!=null && vo.getStrItemCatgNo().equals("10"))
						      sb.append("<div class='col-sm-3'>To Store Name</div>");
							else
							  sb.append("<div class='col-sm-3'>To Store Name</div>");
						  sb.append("<div class='col-sm-3'>");
						  sb.append(strToStore);
						  sb.append("</div></div>");
						
						  sb.append("<div class='row'>");
						  sb.append("<div class='col-sm-3'>Remarks</div>");
						  sb.append("<div class='col-sm-9'>");
						  sb.append(strAppRemarks);
						  sb.append("</div></div>");
						
						if (vo.getStrReqTypeId().equals("16")) {
							vo.setStrCommitteTypeCode(ws.getString(12));
							IndentApprovalDeskDAO
									.callingFunctionCommitteNameView(vo);
							if (!vo.getStrCommitteTypeName().equals("/")) {
								
								/*
								 * sb.append("<tr>"); sb.
								 * append("<td width='25%' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;' >CommitteType Name</td>"
								 * ); sb.
								 * append("<td width='25%' class='CONTROL' style='font-weight:350 !important ;font-size: 15px !important;'>"
								 * ); sb.append(vo.getStrCommitteTypeName()); sb.append("</td>"); sb.
								 * append("<td width='25%' class='LABEL' style='font-weight:350 !important ;font-size: 15px !important;'></td>"
								 * ); sb.
								 * append("<td width='25%' class='CONTROL' style='font-weight:350 !important ;font-size: 15px !important;'>"
								 * ); sb.append("</td>"); sb.append("</tr>");
								 */
								
								sb.append("<div class='row'>");
								sb.append("<div class='col-sm-3'>CommitteType Name</div>");
								sb.append("<div class='col-sm-3'>");
								sb.append(vo.getStrCommitteTypeName());
								sb.append("</div>");
								sb.append("<div class='col-sm-3'></div>");
								sb.append("<div class='col-sm-3'></div>");
								sb.append("</div>");
							}
						}
						/* sb.append("</table>"); */
						sb.append("</div>");

					}
				}
			} else {
				/*
				 * sb.append("<table class='table'>"); sb.append("<tr>"); sb.
				 * append("<td colspan='5'  style='font-weight:350 !important ;font-size: 15px !important;' >"
				 * +
				 * "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>"
				 * + "</TD>"); sb.append("</tr>"); sb.append("</table>");
				 */
				sb.append("<DIV class='errMsg' colspan='5' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>");
	;

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
