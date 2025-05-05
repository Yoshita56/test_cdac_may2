package billing;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

public class CashCollectionTransHLP {

	private static final String strColor = "red";
	private static final String defaultColor = "blue";

	/**
	 * returns the required Online Details View (HTML) in String format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return - required Online Details View
	 */
	public static String getOnLineDetailsView(CashCollectionTransVO voObj) {
		WebRowSet ws = voObj.getOnlineDetails();
		StringBuffer sb = new StringBuffer("");
		boolean flag = true;

		try {

			if (ws != null) {

				sb
						.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");

				while (ws.next()) {

					String strRequestNo = ws.getString(1);
					String strRequestDt = ws.getString(2);
					String strDeptCode = ws.getString(3);
					String strChargeTypeId = ws.getString(4);
					String strBServiceId = ws.getString(5);
					String strServiceId = ws.getString(6);
					String strGblReqNo = ws.getString(7);
					String strBillNo = ws.getString(8);
					String strPatCatCode = ws.getString(9);
					String strEpisodeCode = ws.getString(10);
					String strAdminNo = ws.getString(12);
					String strPatAccNo = ws.getString(13);
					String strApprovalId = ws.getString(14);
					String strHospServiceName = ws.getString(15);
					String strReqFor = ws.getString(16);
					String strDeptName = ws.getString(17);
					String strTreatCatName = ws.getString(18);
					String strReqType = ws.getString(19);
					String strHiddenValue = ws.getString(20);
					

					String temp[] = strHiddenValue.replace("^", "#").split("#");
					String strWardName = temp[16];

					String strRequestStatus = temp[21];
			//		String strDate = temp[22];
			//		String strEmpName = temp[23];
					String strRemarks = temp[24];
					
					if (strRequestNo == null)
						strRequestNo = "0";
					if (strRequestDt == null)
						strRequestDt = "";
					if (strDeptCode == null)
						strDeptCode = "0";
					if (strChargeTypeId == null)
						strChargeTypeId = "0";
					if (strBServiceId == null)
						strBServiceId = "0";
					if (strServiceId == null)
						strServiceId = "0";
					if (strGblReqNo == null)
						strGblReqNo = "0";
					if (strBillNo == null)
						strBillNo = "0";
					if (strPatCatCode == null)
						strPatCatCode = "0";
					if (strEpisodeCode == null)
						strEpisodeCode = "0";
					if (strAdminNo == null)
						strAdminNo = "";
					if (strPatAccNo == null)
						strPatAccNo = "";
					if (strApprovalId == null)
						strApprovalId = "0";
					if (strHospServiceName == null)
						strHospServiceName = "";
					if (strReqFor == null)
						strReqFor = "";
					if (strDeptName == null)
						strDeptName = "";
					if (strTreatCatName == null)
						strTreatCatName = "";
					if (strWardName == null)
						strWardName = "";

					sb.append("<tr>");
					
					if(strRequestStatus.equals("1")){
					
							if (flag) {
		
								voObj.setStrBillNo(strBillNo);
								voObj.setStrBillingService(strBServiceId);
								voObj.setStrRequestType(strReqType);
								voObj.setStrRequestNo(strRequestNo);
		
								
								sb
										.append("<td class='multiLabel' width='6%'><input type='radio' checked='checked' name='onLineDataRadio'");
		
								flag = false;
							} else {
								sb
										.append("<td class='multiLabel' width='6%'><input type='radio' name='onLineDataRadio'");
		
							}
							
							
							
							sb
									.append("onClick='setClientDetails(this,\"1\");' name='strOnLineData'");
							
							
							sb.append(" value='").append(strHiddenValue).append("' >");
							sb.append("</td>");
					

							sb.append("<td class='multiControl' width='20%'>"
									+ strRequestNo + "</td>");
							sb.append("<td class='multiControl' width='20%'>"
									+ strRequestDt + "</td>");
							sb.append("<td class='multiControl' width='20%'>"
									+ strDeptName + "/" + strWardName + "</td>");
							sb.append("<td class='multiControl' width='15%'>"
									+ strHospServiceName + "</td>");
							sb.append("<td class='multiControl' width='25%'>"
									+ strReqFor + "</td>");
							
					}else{
						
						sb
						.append("<td class='multiLabel' width='6%'>");
						sb.append("<img onkeypress='onPressingEnter(this,event)' style='cursor: pointer;' onmouseover='Tip(\""+strRemarks+"\",SHADOW,true)' onmouseout='UnTip()'  src='../../hisglobal/images/info.png' align='middle'>");

						sb.append("</td>");
						

						sb.append("<td class='multiControl' width='20%' style='color:red;'>"
								+ strRequestNo + "</td>");
						sb.append("<td class='multiControl' width='20%' style='color:red;'>"
								+ strRequestDt + "</td>");
						sb.append("<td class='multiControl' width='20%' style='color:red;'>"
								+ strDeptName + "/" + strWardName + "</td>");
						sb.append("<td class='multiControl' width='15%' style='color:red;'>"
								+ strHospServiceName + "</td>");
						sb.append("<td class='multiControl' width='25%' style='color:red;'>"
								+ strReqFor + "</td>");
						
					}
					
					sb.append("</tr>");
				}

				sb.append("</table>");
			} else {
				sb.append("");
			}

		} catch (SQLException e) {
			new HisException("Cash Collection Trans",
					"CashCollectionTransHLP.getOnLineDetailsView()-->", e
							.getMessage());
		}

		return sb.toString();
	}

	/**
	 * returns the required Online Client Details View (HTML) in String format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return - required Online Client Details View
	 */
	public static String getOnLineClientDetailsView(CashCollectionTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		WebRowSet wsClientDetails = voObj.getOnlineClientDetails();

		try {

			sb
					.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'> ");
			sb.append("<tr> ");
			sb.append("<td class='TITLE' width='20'> ");
			sb
					.append("<div id='plusonLineClientDtlId' ><img style='cursor: hand; cursor: pointer' ");
			sb
					.append("	src='../../hisglobal/images/plus.gif' name='plusonLineClientDtl' ");
			sb.append("align='middle'  ");
			sb
					.append("onclick='showCltDetails(\"onLineClientDtlId\");' /></div> ");
			sb
					.append("<div id='minusonLineClientDtlId' style='display: none'><img  style='cursor: hand; cursor: pointer'    ");
			sb
					.append("src='../../hisglobal/images/minus.gif' name='minusonLineClientDtl' ");
			// sb.append("width='10' height='10' ");
			sb
					.append("onclick='hideCltDetails(\"onLineClientDtlId\");'></div> ");
			sb.append("</td> ");
			sb.append("<td colspan='3' class='TITLE'>Client Details</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");

			sb.append("<div id='onLineClientDtlId' style='display: none'>");
			sb.append("<table class='TABLEWIDTH' align='center'>");

			if (wsClientDetails != null && wsClientDetails.size() > 0) {

				if (wsClientDetails.next()) {

					String strClientName = wsClientDetails.getString(3);
					String strClientType = wsClientDetails.getString(4);
					String strApprovalNo = wsClientDetails.getString(5);
					String strSancAmount = wsClientDetails.getString(7);
					String strBalanceAmount = wsClientDetails.getString(9);
					String strPaidByClient = wsClientDetails.getString(18)
							.replace("^", "#").split("#")[2];

					if (strClientName == null)
						strClientName = "";
					if (strClientType == null)
						strClientType = "";
					if (strSancAmount == null)
						strSancAmount = "";
					// if(strClientName == null) strClientName = "";
					if (strBalanceAmount == null)
						strBalanceAmount = "";
					if (strApprovalNo == null)
						strApprovalNo = "";

					voObj.setStrClientName(strClientName);
					voObj.setStrClientType(strClientType);
					voObj.setStrClientApprovalNo(strApprovalNo);
					voObj.setStrSancAmount(strSancAmount);
					voObj.setStrClientBalance(strBalanceAmount);

					sb.append("<tr>");
					sb
							.append("<td width='25%' class='LABEL'>Client Name<input type='hidden' name='strOnlineClientDetails' value='"
									+ strClientName
									+ "^"
									+ strClientType
									+ "^"
									+ strSancAmount
									+ "^"
									+ strBalanceAmount
									+ "^" + strApprovalNo + "^"+strPaidByClient+"'></td>");
					sb.append("<td width='25%' class='CONTROL'>"
							+ strClientName + "</td>");
					sb.append("<td width='25%' class='LABEL'>Client Type</td>");
					sb.append("<td width='25%' class='CONTROL'>"
							+ strClientType + "</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb
							.append("<td width='25%' class='LABEL'>Sanction Amount</td>");
					sb.append("<td width='25%' class='CONTROL'>"
							+ strSancAmount + "</td>");
					sb
							.append("<td width='25%' class='LABEL'>Approval No.</td>");
					sb.append("<td width='25%' class='CONTROL'>"
							+ strApprovalNo + "</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb
							.append("<td width='25%' class='LABEL'>Balance Amount</td>");
					sb.append("<td width='25%' class='CONTROL'>"
							+ strBalanceAmount + "</td>");
					sb
							.append("<td width='25%' class='LABEL'>Paid by Client</td>");
					sb.append("<td class='CONTROL'>" + strPaidByClient
							+ "</td>");
					sb.append("</tr>");
				}

				sb.append("</table>");
				sb.append("</div>");

			} else {
				sb = new StringBuffer("");
			}

		} catch (SQLException e) {
			new HisException("Cash Collection Trans",
					"CashCollectionTransHLP.getOnLineClientDetailsView()-->", e
							.getMessage());
		}

		return sb.toString();
	}

	/**
	 * returns the required Online Other Details View (HTML) in String format.
	 * 
	 * @param voObj
	 * @return
	 */
	public static String getOnlineOtherDetails(CashCollectionTransVO voObj) {

		String strAccNo = voObj.getStrAccountNo();
		String strTreatCat = voObj.getStrTreatmentCategory();

		StringBuffer sb = new StringBuffer("");

		if (!strAccNo.equals("0") && !strTreatCat.equals("")) {

			sb
					.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");

			sb.append("<tr>");

			sb.append("<td class='TITLE' width='20'> ");
			sb
					.append("<div id='plusonLineOtherDtlId' ><img  style='cursor: hand; cursor: pointer'    ");
			sb
					.append("src='../../hisglobal/images/plus.gif' name='plusonLineOtherDtl' ");
			sb.append("align='middle' ");
			sb
					.append("onclick='showCltDetails(\"onLineOtherDtlId\");' /></div> ");
			sb
					.append("<div id='minusonLineOtherDtlId' style='display: none'><img  style='cursor: hand; cursor: pointer'    ");
			sb
					.append("src='../../hisglobal/images/minus.gif' name='minusonLineOtherDtl' ");

			sb
					.append("onclick='hideCltDetails(\"onLineOtherDtlId\");'></div> ");
			sb.append("</td> ");
			sb.append("<td colspan='3' class='TITLE'>Other Details</td>");
			sb.append("</tr>");
			sb.append("</table>");

			sb.append("<div id='onLineOtherDtlId' style='display: none'>");
			sb.append("<table class='TABLEWIDTH' align='center'>");
			sb.append("<tr>");

			sb.append("<td width='25%' class='LABEL'>Account No.</td>");
			sb.append("<td width='25%' class='CONTROL'>" + strAccNo + "</td>");

			sb.append("<td width='25%' class='LABEL'>Treatment Category</td>");
			sb.append("<td width='25%' class='CONTROL'>" + strTreatCat
					+ "</td>");

			sb.append("</tr>");

			sb.append("</table>");
			sb.append("</div>");

		}

		return sb.toString();

	}

	/**
	 * returns the required Online Tariff Details View (HTML) in String format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return - required Online Tariff Details View
	 */
	public static String getOnLineTariffDetailsView(CashCollectionTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		int trfIndex = 0;

		WebRowSet wsTariffDetails = voObj.getOnlineTariffDetails();

		try {

			if (wsTariffDetails != null) {

				sb
						.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				sb.append("<tr>");
				sb.append("<td class='TITLE' colspan='8'>Tariff Detail</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td class='multiLabel'></td>");
				sb.append("<td class='multiLabel'>Tariff Name</td>");
				sb.append("<td class='multiLabel'>Rate/Unit</td>");
				sb
						.append("<td class='multiLabel'>Req Qty<input type='hidden' class='txtFldMin' name='strTotalTariffServiceTaxAmount' value='0' ></td>");
				sb
						.append("<td class='multiLabel'>Billed Qty<input type='hidden' class='txtFldMin' name='strTotalTariffDiscountAmount' value='0' ></td></td>");
				sb
						.append("<td class='multiLabel'>Unit<input type='hidden' class='txtFldMin' name='strTotalTariffActualAmount' value='0' ></td></td>");
				sb.append("<td class='multiLabel'>Discount Amt</td>");
				sb.append("<td class='multiLabel'>Net Tariff Amt</td>");
				sb.append("</tr>");

				while (wsTariffDetails.next()) {

					trfIndex = trfIndex + 1;

					String strGroupId = wsTariffDetails.getString(1);
					String strTariffId = wsTariffDetails.getString(2);
					String strChargeTypeId = wsTariffDetails.getString(3);
					String strGblTariffId = wsTariffDetails.getString(4);
					String strRateUnitId = wsTariffDetails.getString(5);
					String strApprovalId = wsTariffDetails.getString(6);
					// String strBserviceType = wsTariffDetails.getString(7);
					String strTariffName = wsTariffDetails.getString(7);

					// String strGroupName = wsTariffDetails.getString(9);
					String strUnitName = wsTariffDetails.getString(10);
					String strReqQty = wsTariffDetails.getString(11);
					String strBillQty = wsTariffDetails.getString(12);
					String strTariffRate = wsTariffDetails.getString(13);
					String strDisountUnit = wsTariffDetails.getString(14);
					String strDiscountType = wsTariffDetails.getString(15);
					String strQtyUnitName = wsTariffDetails.getString(18);
					String strQtyUnitId = wsTariffDetails.getString(19);
					String strIsPackage = wsTariffDetails.getString(20);
					String strServiceTax = wsTariffDetails.getString(21);
					String strPenelty = wsTariffDetails.getString(22);
					String strApprovalDtl = wsTariffDetails.getString(23);
					// String strQtyType = wsTariffDetails.getString(24);
					String strRateBaseVal = wsTariffDetails.getString(25);
					String strQtyBaseVal = wsTariffDetails.getString(26);
					String strNetCost = wsTariffDetails.getString(27);
					String strReceiptNo = wsTariffDetails.getString(28);
					String strActualRate = wsTariffDetails.getString(29);
					String strServiceId  = wsTariffDetails.getString(30);
					// String strDisountType =
					// wsTariffDetails.getString(15);

					if (strGroupId == null)
						strGroupId = "";
					if (strTariffId == null)
						strTariffId = "";
					if (strChargeTypeId == null)
						strChargeTypeId = "";
					if (strGblTariffId == null)
						strGblTariffId = "";
					if (strRateUnitId == null)
						strRateUnitId = "";
					if (strApprovalId == null)
						strApprovalId = "";
					if (strTariffName == null)
						strTariffName = "";
					if (strReqQty == null)
						strReqQty = "0";
					if (strBillQty == null)
						strBillQty = "0";
					if (strTariffRate == null)
						strTariffRate = "0";
					if (strDisountUnit == null)
						strDisountUnit = "0";
					if (strRateBaseVal == null)
						strRateBaseVal = "";
					if (strQtyBaseVal == null)
						strQtyBaseVal = "";

					String strHiddenVal = strTariffId + "^" + strReqQty + "*"
							+ strQtyBaseVal + "^" + strQtyUnitId + "^"
							+ strTariffRate + "^" + strRateUnitId + "^"
							+ strGroupId + "^" + strActualRate + "^"
							+ strServiceTax + "^" + strDisountUnit + "^"
							+ strDiscountType + "^" + strGblTariffId + "^"
							+ strApprovalId + "^" + strUnitName + "^"
							+ strRateBaseVal + "^" + strIsPackage + "^"
							+ strNetCost + "^" + strPenelty + "^" + "0^"
							+ strReceiptNo + "^" + strApprovalDtl+"^"+strServiceId;

					sb.append("<tr>");
					sb
							.append("<td class='multiControl'><input type='checkbox' name='strTariffDetailsId' value='");
					sb.append(strHiddenVal);

					sb.append("' onclick='setOnlineTariffDetails(this, \""
							+ trfIndex + "\")'></td>");
					sb
							.append("<td class='multiControl'><a name='strBillTariffName' id='strBillTariffName"
									+ trfIndex
									+ "' STYLE='CURSOR:POINTER; color:blue' value='"
									+ strHiddenVal
									+ "'  onClick='showTariffPopup(this,\""
									+ strHiddenVal
									+ "\");'>"
									+ strTariffName
									+ "</a><input type='hidden' class='txtFldMin' name='strTariffServiceTaxAmt' id='strTariffServiceTaxAmt"
									+ trfIndex
									+ "' value='' disabled='disabled'></td>");
					sb
							.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strTariffRate' id='strTariffRate"
									+ trfIndex
									+ "' value='"
									+ strTariffRate
									+ "' disabled='disabled'>"
									+ strTariffRate
									+ "/"
									+ strUnitName
									+ "<input type='hidden' class='txtFldMin' name='strTariffActualAmt' id='strTariffActualAmt"
									+ trfIndex
									+ "' value='0' disabled='disabled'></td>");
					sb
							.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strTariffReqQty' id='strTariffReqQty"
									+ trfIndex
									+ "' value='"
									+ strReqQty
									+ "' disabled='disabled'>"
									+ strReqQty
									+ "/" + strQtyUnitName + "</td>");
					sb
							.append("<td class='multiControl'><input type='text' class='txtFldMin' name='strTariffBilledQty' id='strTariffBilledQty"
									+ trfIndex
									+ "' onkeyup='setOnlineTariffDltsOnQtyChange(this, \""
									+ strHiddenVal
									+ "\", \""
									+ trfIndex
									+ "\");' value='0' disabled='disabled'></td>");

					sb.append("<td width='10%' class='multiControl'>");

					sb
							.append("<select class='comboMin'  onchange='setOnlineTariffDltsOnQtyUnitChange(this, \""
									+ strHiddenVal
									+ "\", \""
									+ trfIndex
									+ "\");'  name='strBillTariffUnit' id='strBillTariffUnit"
									+ trfIndex + "' disabled='disabled' > ");

					voObj.setStrOffLineTariffUnitTempId(strQtyUnitId);

					CashCollectionTransDAO.getOffLineTariffUnitList(voObj);

					if (voObj.getOfflineTariffUnit() != null
							&& voObj.getOfflineTariffUnit().size() > 0) {
						sb.append(new HisUtil("", "").getOptionValue(voObj
								.getOfflineTariffUnit(), strQtyUnitId + "^"
								+ strQtyBaseVal, "0^Select Value", false));
					} else {
						sb.append("<option value='0'>Select Value</option>");
					}

					sb.append("</select>");
					sb.append("</td>");

					sb
							.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strTariffDiscountAmt' id='strTariffDiscountAmt"
									+ trfIndex
									+ "' value='0' disabled='disabled'><div id='strTariffDiscountAmtDivId"
									+ trfIndex + "'>0.00</div></td>");
					sb
							.append("<td class='multiControl' style='font-weight:bold'><input type='hidden' class='txtFldMin' name='strTariffNetAmt' id='strTariffNetAmt"
									+ trfIndex
									+ "' value='0' disabled='disabled'><div id='strTariffNetAmtDivId"
									+ trfIndex + "'>0.00</div></td>");
					sb.append("</tr>");

				}
				sb.append("</table>");

			}
		} catch (Exception e) {
			new HisException("Cash Collection Trans",
					"CashCollectionTransHLP.getOnLineTariffDetailsView()-->", e
							.getMessage());
		}

		return sb.toString();
	}

	
	
	public static String getWithoutCrNoOnLineTariffDetailsView(CashCollectionTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		int trfIndex = 0;

		WebRowSet wsTariffDetails = voObj.getOnlineTariffDetails();

		try {

			if (wsTariffDetails != null) {

				sb
						.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				sb.append("<tr>");
				sb.append("<td class='TITLE' colspan='8'>Tariff Detail</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td class='multiLabel'></td>");
				sb.append("<td class='multiLabel'>Tariff Name</td>");
				sb
						.append("<td class='multiLabel'>Balance Qty.<input type='hidden' class='txtFldMin' name='strTotalTariffServiceTaxAmount' value='0' ></td>");
				sb
						.append("<td class='multiLabel'>Billed Qty.<input type='hidden' class='txtFldMin' name='strTotalTariffDiscountAmount' value='0' ></td></td>");
				sb
						.append("<td class='multiLabel'>Unit<input type='hidden' class='txtFldMin' name='strTotalTariffActualAmount' value='0' ></td></td>");
				sb.append("<td class='multiLabel'>Ser. Tax Amt.</td>");
				sb.append("<td class='multiLabel'>Discount Amt.</td>");
				sb.append("<td class='multiLabel'>Net Tariff Amt.</td>");
				sb.append("</tr>");

				while (wsTariffDetails.next()) {

					trfIndex = trfIndex + 1;

					String strGroupId = wsTariffDetails.getString(1);
					String strTariffId = wsTariffDetails.getString(2);
					String strChargeTypeId = wsTariffDetails.getString(3);
					String strGblTariffId = wsTariffDetails.getString(4);
					String strRateUnitId = wsTariffDetails.getString(5);
					String strApprovalId = wsTariffDetails.getString(6);
					// String strBserviceType = wsTariffDetails.getString(7);
					String strTariffName = wsTariffDetails.getString(7);

					// String strGroupName = wsTariffDetails.getString(9);
					String strUnitName = wsTariffDetails.getString(10);
					String strReqQty = wsTariffDetails.getString(11);
					String strBillQty = wsTariffDetails.getString(12);
					String strTariffRate = wsTariffDetails.getString(13);
					String strDisountUnit = wsTariffDetails.getString(14);
					String strDiscountType = wsTariffDetails.getString(15);
					String strQtyUnitName = wsTariffDetails.getString(18);
					String strQtyUnitId = wsTariffDetails.getString(19);
					String strIsPackage = wsTariffDetails.getString(20);
					String strServiceTax = wsTariffDetails.getString(21);
					String strPenelty = wsTariffDetails.getString(22);
					String strApprovalDtl = wsTariffDetails.getString(23);
					// String strQtyType = wsTariffDetails.getString(24);
					String strRateBaseVal = wsTariffDetails.getString(25);
					String strQtyBaseVal = wsTariffDetails.getString(26);
					String strNetCost = wsTariffDetails.getString(27);
					String strReceiptNo = wsTariffDetails.getString(28);
					String strActualRate = wsTariffDetails.getString(29);
					String strServiceId = wsTariffDetails.getString(30);
					// String strDisountType =
					// wsTariffDetails.getString(15);

					if (strGroupId == null)
						strGroupId = "";
					if (strTariffId == null)
						strTariffId = "";
					if (strChargeTypeId == null)
						strChargeTypeId = "";
					if (strGblTariffId == null)
						strGblTariffId = "";
					if (strRateUnitId == null)
						strRateUnitId = "";
					if (strApprovalId == null)
						strApprovalId = "";
					if (strTariffName == null)
						strTariffName = "";
					if (strReqQty == null)
						strReqQty = "0";
					if (strBillQty == null)
						strBillQty = "0";
					if (strTariffRate == null)
						strTariffRate = "0";
					if (strDisountUnit == null)
						strDisountUnit = "0";
					if (strRateBaseVal == null)
						strRateBaseVal = "";
					if (strQtyBaseVal == null)
						strQtyBaseVal = "";

					String strHiddenVal = strTariffId + "^" + strReqQty + "*"
							+ strQtyBaseVal + "^" + strQtyUnitId + "^"
							+ strTariffRate + "^" + strRateUnitId + "^"
							+ strGroupId + "^" + strActualRate + "^"
							+ strServiceTax + "^" + strDisountUnit + "^"
							+ strDiscountType + "^" + strGblTariffId + "^"
							+ strApprovalId + "^" + strUnitName + "^"
							+ strRateBaseVal + "^" + strIsPackage + "^"
							+ strNetCost + "^" + strPenelty + "^" + "0^"
							+ strReceiptNo + "^" + strApprovalDtl+"^"+strServiceId;

					sb.append("<tr>");
					sb
							.append("<td class='multiControl'><input type='checkbox' id='strTariffDetailsId"+trfIndex+"' name='strTariffDetailsId' value='");
					sb.append(strHiddenVal);

					sb.append("' onclick='setOnlineWithoutCrNoTariffDetails(this, \""
							+ trfIndex + "\")'></td>");
					sb
							.append("<td class='multiControl'>"
									+ strTariffName+"@"+ strTariffRate
									+ "/"
									+ strUnitName
									+ "<input type='hidden' class='txtFldMin' name='strTariffRate' id='strTariffRate"
							+ trfIndex
							+ "' value='"
							+ strTariffRate
							+ "' disabled='disabled'><input type='hidden' class='txtFldMin' name='strTariffActualAmt' id='strTariffActualAmt"
							+ trfIndex
							+ "' value='0' disabled='disabled'></td>");
					
					sb
							.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strTariffReqQty' id='strTariffReqQty"
									+ trfIndex
									+ "' value='"
									+ strReqQty
									+ "' disabled='disabled'>"
									+ strReqQty
									+ "/" + strQtyUnitName + "</td>");
					sb
							.append("<td class='multiControl'><input type='text' class='txtFldMin' name='strTariffBilledQty' id='strTariffBilledQty"
									+ trfIndex
									+ "' onkeyup='setOnlineWithoutCrNoTariffDltsOnQtyChange(this, \""
									+ strHiddenVal
									+ "\", \""
									+ trfIndex
									+ "\");' value='0' disabled='disabled'></td>");

					sb.append("<td width='10%' class='multiControl'>");

					sb
							.append("<select class='comboMin'  onchange='setOnlineWithoutCrNoTariffDltsOnQtyUnitChange(this, \""
									+ strHiddenVal
									+ "\", \""
									+ trfIndex
									+ "\");'  name='strBillTariffUnit' id='strBillTariffUnit"
									+ trfIndex + "' disabled='disabled' > ");

					voObj.setStrOffLineTariffUnitTempId(strQtyUnitId);

					CashCollectionTransDAO.getOffLineTariffUnitList(voObj);

					if (voObj.getOfflineTariffUnit() != null
							&& voObj.getOfflineTariffUnit().size() > 0) {
						sb.append(new HisUtil("", "").getOptionValue(voObj
								.getOfflineTariffUnit(), strQtyUnitId + "^"
								+ strQtyBaseVal, "0^Select Value", false));
					} else {
						sb.append("<option value='0'>Select Value</option>");
					}

					sb.append("</select>");
					sb.append("</td>");

					sb
					.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strTariffServiceTaxAmt' id='strTariffServiceTaxAmt"
							+ trfIndex
							+ "' value='0' disabled='disabled'><div id='strTariffServiceTaxAmtDivId"
							+ trfIndex + "'>0.00</div></td>");
					
					sb
							.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strTariffDiscountAmt' id='strTariffDiscountAmt"
									+ trfIndex
									+ "' value='0' disabled='disabled'><table align='center'><tr><td class='multiControl'><div id='strTariffDiscountAmtDivId"
									+ trfIndex + "'>0.00</div></td><td class='multiControl'><img name='tariffDiscountConf' id='tariffDiscountConf"+trfIndex+"'");
					sb
					.append("style='cursor: hand; cursor: pointer' src='../../hisglobal/images/plus.gif' onClick='getOnLineWithoutCrNoTariffDiscountDetails(\""+trfIndex+"\",this);'>");
					sb
					.append("<input type='hidden' name='strTariffDiscountConfigDetails' value='' id='strTariffDiscountConfigDetails"+trfIndex+"' disabled='disabled'></td></tr></table></td>");
					sb
							.append("<td class='multiControl' style='font-weight:bold'><input type='hidden' class='txtFldMin' name='strTariffNetAmt' id='strTariffNetAmt"
									+ trfIndex
									+ "' value='0' disabled='disabled'><div id='strTariffNetAmtDivId"
									+ trfIndex + "'>0.00</div></td>");
					sb.append("</tr>");

				}
				sb.append("</table>");

			}else{
				
				sb
				.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
		sb.append("<tr>");
		sb.append("<td class='multiControl' colspan='8' style='color:red;font-weight:bold'>No Tariff(s) Detail Available</td>");
		sb.append("</tr>");
		sb.append("</table>");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			
			new HisException("Cash Collection Trans",
					"CashCollectionTransHLP.getWithoutCrNoOnLineTariffDetailsView()-->", e
							.getMessage());
		}

		return sb.toString();
	}
	
	
	
	/**
	 * returns the required Online Tariff Details View (HTML) in String format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return - required Online Tariff Details View
	 */
	public static String getOnLineRefundTariffDetailsView(
			CashCollectionTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		WebRowSet wsTariffDetails = voObj.getOnlineTariffDetails();

		int count = 0;

		try {

			if (wsTariffDetails != null) {

				sb
						.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				sb.append("<tr>");
				sb.append("<td class='TITLE' colspan='7'>Tariff Detail</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td class='multiLabel'></td>");
				sb
						.append("<td class='multiLabel'>Tariff Name<input type='hidden' class='txtFldMin' name='strTotalTariffServiceTaxAmount' value='0' > <input type='hidden' class='txtFldMin' name='strTotalTariffActualAmount' value='0' > </td>");
				sb
						.append("<td class='multiLabel'>Refund Qty<input type='hidden' class='txtFldMin' name='strTotalTariffDiscountAmount' value='0' >  <input type='hidden' class='txtFldMin' name='strTotalTariffPenaltyAmount' value='0' ></td>");
				//sb.append("<td class='multiLabel'>Refund Qty </td>");
				//sb.append("<td class='multiLabel'>Unit </td>");
				sb.append("<td class='multiLabel'>Refund Cost (<img src='/AHIMS/hisglobal/images/INR.png'>)</td>");
				sb.append("</tr>");

				while (wsTariffDetails.next()) {

					count = count + 1;

					String strGroupId = wsTariffDetails.getString(1);
					String strTariffId = wsTariffDetails.getString(2);
					String strChargeTypeId = wsTariffDetails.getString(3);
					String strGblTariffId = wsTariffDetails.getString(4);
					String strRateUnitId = wsTariffDetails.getString(5);
					String strApprovalId = wsTariffDetails.getString(6);
					// String strBserviceType = wsTariffDetails.getString(7);
					String strTariffName = wsTariffDetails.getString(7);

					// String strGroupName = wsTariffDetails.getString(9);
					String strUnitName = wsTariffDetails.getString(10);
					String strReqQty = wsTariffDetails.getString(11);
					String strBillQty = wsTariffDetails.getString(12);
					String strTariffRate = wsTariffDetails.getString(13);
					String strDisountUnit = wsTariffDetails.getString(14);
					String strDiscountType = wsTariffDetails.getString(15);
				//	String strQtyUnitName = wsTariffDetails.getString(18);
					String strQtyUnitId = wsTariffDetails.getString(19);
					String strIsPackage = wsTariffDetails.getString(20);
					String strServiceTax = wsTariffDetails.getString(21);
					String strPenelty = wsTariffDetails.getString(22);
					String strApprovalDtl = wsTariffDetails.getString(23);
					// String strQtyType = wsTariffDetails.getString(24);
					String strRateBaseVal = wsTariffDetails.getString(25);
					String strQtyBaseVal = wsTariffDetails.getString(26);
					String strNetCost = wsTariffDetails.getString(27);
					String strReceiptNo = wsTariffDetails.getString(28);
					String strActualRate = wsTariffDetails.getString(29);
					// String strDisountType =
					// wsTariffDetails.getString(15);

					if (strGroupId == null)
						strGroupId = "";
					if (strTariffId == null)
						strTariffId = "";
					if (strChargeTypeId == null)
						strChargeTypeId = "";
					if (strGblTariffId == null)
						strGblTariffId = "";
					if (strRateUnitId == null)
						strRateUnitId = "";
					if (strApprovalId == null)
						strApprovalId = "";
					if (strTariffName == null)
						strTariffName = "";
					if (strReqQty == null)
						strReqQty = "0";
					if (strBillQty == null)
						strBillQty = "0";
					if (strTariffRate == null)
						strTariffRate = "0";
					if (strDisountUnit == null)
						strDisountUnit = "0";
					if (strRateBaseVal == null)
						strRateBaseVal = "";
					if (strQtyBaseVal == null)
						strQtyBaseVal = "";

					String strHiddenVal = strTariffId + "^" + strReqQty + "*"
							+ strQtyBaseVal + "^" + strQtyUnitId + "^"
							+ strTariffRate + "^" + strRateUnitId + "^"
							+ strGroupId + "^" + strActualRate + "^"
							+ strServiceTax + "^" + strDisountUnit + "^"
							+ strDiscountType + "^" + strGblTariffId + "^"
							+ strApprovalId + "^" + strUnitName + "^"
							+ strRateBaseVal + "^" + strIsPackage + "^"
							+ strNetCost + "^" + strPenelty + "^" + "0^"
							+ strReceiptNo + "^" + strApprovalDtl;

					sb.append("<tr>");
					sb
							.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strTariffPenaltyAmt' id='strTariffPenaltyAmt"
									+ count
									+ "' value='0' disabled='disabled'><input type='checkbox' name='strTariffRefundDetailsId' id='strTariffRefundDetailsId"
									+ count
									+ "' onclick='activateTariffRefundDtls(this,\""
									+ count + "\");'  value='");
					sb.append(strHiddenVal).append("^");

					sb.append("' onclick='setOnlineTariffDetails(this, \""
							+ count + "\")'></td>");
					sb
							.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strTariffServiceTaxAmt' id='strTariffServiceTaxAmt"
									+ count
									+ "'  value='0' disabled='disabled' > <a STYLE='CURSOR:POINTER; color:blue' onclick='showRefundTariffPopup(this,\""
									+ strHiddenVal
									+ "\");'>"
									+ strTariffName
									+ "</a>  <input disabled='disabled'  type='hidden' name='strRefundTariffDetails' id='strRefundTariffDetails"
									+ count
									+ "' value='"
									+ strHiddenVal
									+ "'/></td>");
					sb
							.append("<td class='multiControl'><input type='hidden' name='strTariffToBeRefundQty' id='strTariffToBeRefundQty"
									+ count
									+ "' disabled='disabled' class='txtFldNormal' value='"
									+ strReqQty
									+ "'>"
									+ strReqQty
									+ " "
									+ strUnitName
									+ "<input type='hidden' class='txtFldMin' name='strTariffActualAmt' id='strTariffActualAmt"
									+ count
									+ "' value='0' disabled='disabled'>  <input style='display:none' type='text' name='strTariffRefundQty' id='strTariffRefundQty"
									+ count
									+ "' disabled='disabled' class='txtFldNormal' value='0' onkeyup='calcRefundTariffAmount(\""
									+ count + "\")'>  <input type='hidden' class='txtFldMin' name='strTariffDiscountAmt' id='strTariffDiscountAmt"
									+ count
									+ "' value='0' disabled='disabled'>  <select style='display:none' name='strTariffRefundUnit' id='strTariffRefundUnit"
									+ count
									+ "' disabled='disabled' class='comboMin'>");
					voObj.setStrOffLineTariffUnitTempId(strQtyUnitId);

					CashCollectionTransDAO.getOffLineTariffUnitList(voObj);

					if (voObj.getOfflineTariffUnit() != null
							&& voObj.getOfflineTariffUnit().size() > 0) {
						sb.append(new HisUtil("", "").getOptionValue(voObj
								.getOfflineTariffUnit(), strQtyUnitId + "^"
								+ strQtyBaseVal, "0^Select Value", false));
					} else {
						sb.append("<option value='0'>Select Value</option>");
					}
					sb.append("</select>  </td>");
					//sb.append("<td class='multiControl'></td>");
					//sb.append("<td class='multiControl'></td>");
					sb
							.append("<td class='multiControl' style='font-weight: bold'><div id='strTariffRefundCostDivId"
									+ count
									+ "'>0.00</div><input type='hidden' name='strTariffRefundCost' id='strTariffRefundCost"
									+ count
									+ "' disabled='disabled' class='txtFldNormal' value='0.00' ></td>");
					sb.append("</tr>");

				}
				sb.append("</table>");

			}
		} catch (Exception e) {
			new HisException(
					"Cash Collection Trans",
					"CashCollectionTransHLP.getOnLineRefundTariffDetailsView()-->",
					e.getMessage());
		}

		return sb.toString();
	}

	public static String getOnLineRefundAdvanceView(CashCollectionTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		WebRowSet wsTariffDetails = voObj.getOnlineTariffDetails();

		try {

			if (wsTariffDetails != null) {

				sb
						.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				sb.append("<tr>");
				sb
						.append("<td class='TITLE' colspan='2'>Refund Advance Detail</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb
						.append("<td class='multiLabel' width='75%'>Tariff Name<input type='hidden' class='txtFldMin' name='strTotalTariffServiceTaxAmount' value='0' ></td>");

				sb
						.append("<td class='multiLabel'  width='25%'>Refund Cost (<img src='/AHIMS/hisglobal/images/INR.png'>)</td>");
				sb.append("</tr>");

				if (wsTariffDetails != null && wsTariffDetails.size() > 0) {
					while (wsTariffDetails.next()) {

						/*
						 * String strGroupId = wsTariffDetails.getString(1);
						 * String strTariffId = wsTariffDetails.getString(2);
						 * String strChargeTypeId =
						 * wsTariffDetails.getString(3); String strGblTariffId =
						 * wsTariffDetails.getString(4); String strRateUnitId =
						 * wsTariffDetails.getString(5); String strApprovalId =
						 * wsTariffDetails.getString(6); String strBserviceType =
						 * wsTariffDetails.getString(7);
						 */
						String strTariffName = wsTariffDetails.getString(7);
						String strPenelty = wsTariffDetails.getString(22);
						String strTariffRate = wsTariffDetails.getString(13);
						/*
						 * // String strGroupName =
						 * wsTariffDetails.getString(9); String strUnitName =
						 * wsTariffDetails.getString(10); String strReqQty =
						 * wsTariffDetails.getString(11); String strBillQty =
						 * wsTariffDetails.getString(12); String strTariffRate =
						 * wsTariffDetails.getString(13); String strDisountUnit =
						 * wsTariffDetails.getString(14); String strDiscountType =
						 * wsTariffDetails.getString(15); //String
						 * strQtyUnitName = wsTariffDetails.getString(18);
						 * String strQtyUnitId = wsTariffDetails.getString(19);
						 * String strIsPackage = wsTariffDetails.getString(20);
						 * String strServiceTax = wsTariffDetails.getString(21);
						 * 
						 * String strApprovalDtl =
						 * wsTariffDetails.getString(23); // String strQtyType =
						 * wsTariffDetails.getString(24); String strRateBaseVal =
						 * wsTariffDetails.getString(25); String strQtyBaseVal =
						 * wsTariffDetails.getString(26);
						 * 
						 * String strReceiptNo = wsTariffDetails.getString(28);
						 * String strActualRate = wsTariffDetails.getString(29); //
						 * String strDisountType = //
						 * wsTariffDetails.getString(15);
						 */
						if (strTariffName == null)
							strTariffName = "";
						if (strTariffRate == null)
							strTariffRate = "0.00";
						if (strPenelty == null)
							strPenelty = "0";

						float netAmt = Float.parseFloat(strTariffRate);
						float penelty = Float.parseFloat(strPenelty);
						float peneltyAmt = (netAmt * penelty) / (100 - penelty);

						strTariffRate = HisUtil.getAmountWithDecimal(strTariffRate, 2);
						
						sb.append("<tr>");
						sb
								.append("<td class='multiControl'><input type='hidden' name='strRefundAdvancePenelty' value='"
										+ strPenelty
										+ "'><input type='hidden' name='strTotalTariffPenaltyAmount' value='"
										+ peneltyAmt
										+ "'><a style='color:blue; cursor:pointer' onclick='showRefundAdvanceDtls(this , \""
										+ penelty
										+ "^"
										+ peneltyAmt
										+ "\");'>"
										+ strTariffName + "</a></td>");

						sb
								.append("<td class='multiControl' style='font-weight: bold'><div id='strTariffRefundCostDivId'>"
										+ strTariffRate
										+ "</div><input type='hidden' name='strTariffRefundCost' disabled='disabled' class='txtFldNormal' value='"
										+ strTariffRate + "' ></td>");
						sb.append("</tr>");

					}
					sb.append("</table>");

				} else {

					sb.append("<tr>");
					sb
							.append("<td class='CONTROL' colspan='2'>No Refund Advance Detail Available</td>");
					sb.append("</tr>");
					sb.append("</table>");
				}
			}
		} catch (Exception e) {
			new HisException(
					"Cash Collection Trans",
					"CashCollectionTransHLP.getOnLineRefundTariffDetailsView()-->",
					e.getMessage());
		}

		return sb.toString();
	}

	/**
	 * returns the required Online Part Payment Details View (HTML) in String
	 * format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return - required Online Part Payment Details View
	 */
	public static String getOnLinePartPaymentDetailsView(
			CashCollectionTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		WebRowSet wsTariffDetails = voObj.getOnlineTariffDetails();

		try {

			if (wsTariffDetails != null) {

				sb
						.append("<table class='TABLEWIDTH' align='center'  cellspacing='1px'>");
				sb.append("<tr>");
				sb
						.append("<td class='TITLE' colspan='2'>Part Payment Details</td>");
				sb.append("</tr>");

				if (wsTariffDetails.next()) {

					String strTariffRate = wsTariffDetails.getString(13);

					if (strTariffRate == null)
						strTariffRate = "0";

					sb.append("<tr>");
					sb
							.append("<td width='25%' class='LABELHIGHLITER'>Part Payment Amount</td>");
					sb.append("<td width='75%' class='CONTROL'>");
					sb
							.append("<input type='text' name='strPartPaymentAmount' readonly='readonly' class='txtFldNormal' value='");
					sb.append(strTariffRate);
					sb.append("'>");
					sb.append("</td>");
					sb.append("</tr>");
				}
				sb.append("</table>");
			}
		} catch (SQLException e) {
			new HisException(
					"Cash Collection Trans",
					"CashCollectionTransHLP.getOnLinePartPaymentClientDetailsView()-->",
					e.getMessage());
		}

		return sb.toString();
	}

	/**
	 * returns the required Online Advance Details View (HTML) in String format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return - required Online Advance Details View
	 */
	public static String getOnLineAdvanceDetailsView(CashCollectionTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		WebRowSet wsTariffDetails = voObj.getOnlineTariffDetails();

		try {

			sb
					.append("<table class='TABLEWIDTH' align='center'  cellspacing='1px'>");
			sb.append("<tr>");
			sb.append("<td class='TITLE' colspan='2'>Advance Details</td>");
			sb.append("</tr>");

			if (wsTariffDetails.next()) {

				String strTariffRate = wsTariffDetails.getString(13);

				if (strTariffRate == null)
					strTariffRate = "0";

				sb.append("<tr>");
				sb
						.append("<td width='25%' class='LABELHIGHLITER'>Advance Amount</td>");
				sb.append("<td width='75%' class='CONTROL'>");
				sb
						.append("<input type='text' name='strAdvanceAmount' readonly='readonly' class='txtFldNormal' value='");
				sb.append(strTariffRate);
				sb.append("'>");
				sb.append("</td>");
				sb.append("</tr>");
			}
			sb.append("</table>");

		} catch (SQLException e) {
			new HisException(
					"Cash Collection Trans",
					"CashCollectionTransHLP.getOnLinePartPaymentClientDetailsView()-->",
					e.getMessage());
		}

		return sb.toString();
	}

	/*public static String getOnLineThirdPartyAmountDtlView(String strBServiceId,
			String strMode) {

		StringBuffer sb = new StringBuffer("");

		if (strMode.equals("1")) {

			sb
					.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr> ");
			sb
					.append("<td width='60%' class='LABEL'>Max Benefit From Client (<img src='/AHIMS/hisglobal/images/INR.png'>)</td> ");
			sb.append("<td width='15%' class='CONTROL' > ");
			sb
					.append("<table><tr><td><input type='hidden' name='strOnlineMaxClientBenefitAmount' id='strOnlineMaxClientBenefitAmount' value='0.00'></td> ");
			sb
					.append("<td  class='CONTROL' style='font-weight: bold'><div id='onlineMaxClientBenefitDivId'>0.00</div> </td></tr></table>");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");

			if (strBServiceId.equals("21")) {

				sb
						.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb
						.append("<td width='60%' class='LABEL'>Discount Amount </td> ");
				sb
						.append("<td width='15%' class='CONTROL' style='font-weight: bold'> ");
				sb
						.append("<table><tr><td><input type='hidden' name='strOnlineDiscountAmount' id='strOnlineDiscountAmount' value='0.00'></td> ");
				sb
						.append("<td  class='CONTROL' style='font-weight: bold'><div id='onlineDiscountAmountDivId'>0.00</div> </td></tr></table>");
				sb.append("</td> ");
				sb.append("</tr> ");
				sb.append("</table> ");
				sb
						.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb
						.append("<td width='60%' class='LABEL'>Service Tax Amount</td> ");
				sb
						.append("<td width='15%' class='CONTROL' style='font-weight: bold'> ");
				sb
						.append("<table><tr><td><input type='hidden' name='strOnlineServiceTaxAmount' id='strOnlineServiceTaxAmount' value='0.00'></td> ");
				sb
						.append("<td  class='CONTROL' style='font-weight: bold'><div id='onlineServiceTaxAmountDivId'>0.00</div> </td></tr></table>");
				sb.append("</td> ");
				sb.append("</tr> ");
				sb.append("</table> ");

			}
			sb
					.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr> ");
			sb
					.append("<td width='60%' class='LABEL'>Net Payable Amount By Patient (<img src='/AHIMS/hisglobal/images/INR.png'>)</td> ");
			sb
					.append("<td width='15%' class='CONTROL' style='font-weight: bold'> ");
			sb
					.append("<table><tr><td><input type='hidden' name='strOnlinePatNetPayAmount' id='strOnlinePatNetPayAmount' value='0.00'></td> ");
			sb
					.append("<td  class='CONTROL' style='font-weight: bold'><div id='onlinePatNetPayDivId'>0.00</div> </td></tr></table>");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");

		} else {

			sb
					.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr> ");
			sb.append("<td width='60%' class='LABEL'>Discount Amount </td> ");
			sb
					.append("<td width='15%' class='CONTROL' style='font-weight: bold'> ");
			sb
					.append("<table><tr><td><input type='hidden' name='strOnlineDiscountAmount' id='strOnlineDiscountAmount' value='0.00'></td> ");
			sb
					.append("<td  class='CONTROL' style='font-weight: bold'><div id='onlineDiscountAmountDivId'>0.00</div> </td></tr></table>");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb
					.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr> ");
			sb.append("<td width='60%' class='LABEL'>Service Tax Amount</td> ");
			sb
					.append("<td width='15%' class='CONTROL' style='font-weight: bold'> ");
			sb
					.append("<table><tr><td><input type='hidden' name='strOnlineServiceTaxAmount' id='strOnlineServiceTaxAmount' value='0.00'></td> ");
			sb
					.append("<td  class='CONTROL' style='font-weight: bold'><div id='onlineServiceTaxAmountDivId'>0.00</div> </td></tr></table>");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");

		}

		return sb.toString();
	}
*/
	/*
	 * public static String getAccountHeader() {
	 * 
	 * StringBuffer sb = new StringBuffer("");
	 * 
	 * sb.append("<table class='TABLEWIDTH' align='center'> "); sb.append("<tr>
	 * "); sb.append("<td class='multiLabel' width='20'> "); sb.append("<div
	 * id='plusonLineAccId' ><img ");
	 * sb.append("src='../../hisglobal/images/plus.gif' name='plusonLine' ");
	 * sb.append("align='middle' width='10' height='10' ");
	 * sb.append("onclick='showCltDetails(\"onLineAccId\");' /></div> ");
	 * sb.append("<div id='minusonLineAccId' style='display: none'><img ");
	 * sb.append("src='../../hisglobal/images/minus.gif' name='minusonLine' ");
	 * sb.append("width='10' height='10' ");
	 * sb.append("onclick='hideCltDetails(\"onLineAccId\");'></div> ");
	 * sb.append("</td> "); sb.append("<td class='TITLE' colspan='3'>Account
	 * Detail</td> "); sb.append("</tr> "); sb.append("</table> ");
	 * 
	 * return sb.toString(); }
	 */

	/**
	 * returns the required Off-line Part Payment Details View (HTML) in String
	 * format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return - required Off-line Part Payment Details View
	 */
	public static String getOffLinePartPaymentDetailsView(
			CashCollectionTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		HisUtil util = new HisUtil("Cash Collection Trans",
				"CashCollectionTransHLP.getOffLinePartPaymentDetailsView()");

		String strApprovedBy = "";

		try {

			if (voObj.getOfflineApprovedByList() != null
					&& voObj.getOfflineApprovedByList().size() > 0) {

				voObj.getOfflineApprovedByList().beforeFirst();

				strApprovedBy = util.getOptionValue(voObj
						.getOfflineApprovedByList(), "0", "0^Select Value",
						false);
			} else {

				strApprovedBy = "<option value='0'>Select Value</option>";

			}

			String strRemarks = "";

			if (voObj.getOfflineRemarksList() != null
					&& voObj.getOfflineRemarksList().size() > 0) {

				voObj.getOfflineRemarksList().beforeFirst();

				strRemarks = util.getOptionValue(voObj.getOfflineRemarksList(),
						"", "", false);

				strRemarks = strRemarks + "<option value='0'>Others</option>";

			} else {

				strRemarks = "<option value='0' selected>Others</option>";

			}

			sb
					.append("<table class='TABLEWIDTH' align='center'  cellspacing='1px'>");
			sb.append("<tr> ");
			sb.append("<td class='TITLE'>Part Payment Details</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb
					.append("<table class='TABLEWIDTH' align='center'  cellspacing='1px'>");
			sb.append("<tr> ");
			sb
					.append("<td width='25%' class='LABEL'>Part Payment Amount:</td> ");

			if (!voObj.getStrOffLinePartPaymentAmount().equals("")) {

				sb
						.append("<td width='25%' class='CONTROL'><input type='hidden' name='strdummypartpayment' value='"
								+ voObj.getStrOffLinePartPaymentAmount()
								+ "'><input name='strPartpayment' tabindex='1' id='strPartpayment' type='text' class='txtFldMin' value='"
								+ voObj.getStrOffLinePartPaymentAmount()
								+ "' disabled='disabled' onkeyup='return setTotalRecAmt(this);' onkeypress='return validateData(event,7);'>&nbsp;Rs</td> ");
			} else {
				sb
						.append("<td width='25%' class='CONTROL'><input type='hidden' name='strdummypartpayment' value='0'><input name='strPartpayment' tabindex='1' id='strPartpayment' type='text' class='txtFldMin' value='0' disabled='disabled' onkeypress='return validateData(event,7);' onkeyup='return setTotalRecAmt(this);'>&nbsp;Rs</td> ");
			}

			sb.append("<td width='50%' class='LABEL' > ");
			sb.append("<div id='id11' style='display:block'> ");
			sb
					.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			sb.append("<tr>  ");
			sb.append("<td width='25%' class='LABEL'>Update:</td> ");
			sb
					.append("<td width='25%' class='CONTROL'><input type='checkbox' name='strChk_value' value='0' onClick='ftnTick();'></td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("</div>");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("<div id='combo' style='display:none'> ");
			sb
					.append("<table class='TABLEWIDTH' align='center'  cellspacing='1px'>");
			sb.append("<tr> ");
			sb
					.append("<td width='25%' class='LABEL'><font color='red'>*</font>Approval By</td> ");
			sb.append("<td width='75%' colspan='3' class='CONTROL'> ");
			sb.append("<select name='strApprovedByCombo' class='comboBig'> ");
			sb.append(strApprovedBy);
			sb.append("</select> ");
			sb.append("</td> ");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td width='25%'  class='LABEL'>Remarks</td> ");
			sb.append("<td width='75%' colspan='3' class='CONTROL'> ");
			sb
					.append("<select name='dr' class='comboNormal' onChange='groupComboPartPayment();'> ");
			sb.append(strRemarks);
			sb.append("</select> ");
			sb
					.append("<input name='strRemarksCombo2' type='text' class='txtFldMax' value='"
							+ voObj.getStrOffLineRemarks()
							+ "' disabled='disabled'></td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("</div> ");

		} catch (Exception e) {
			new HisException(
					"Cash Collection Trans",
					"CashCollectionTransHLP.getOffLinePartPaymentDetailsView()-->",
					e.getMessage());
		}

		return sb.toString();
	}

	/**
	 * returns the required Off-line Advance Details View (HTML) in String
	 * format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return - required Off-line Advance Details View
	 */
	public static String getOffLineAdvanceDetailsView(
			CashCollectionTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		HisUtil util = new HisUtil("Cash Collection Trans",
				"CashCollectionTransHLP.getOffLineAdvanceDetailsView()");

		String strApprovedBy = "";

		try {

			if (voObj.getOfflineApprovedByList() != null
					&& voObj.getOfflineApprovedByList().size() > 0) {

				voObj.getOfflineApprovedByList().beforeFirst();

				strApprovedBy = util.getOptionValue(voObj
						.getOfflineApprovedByList(), "0", "0^Select Value",
						false);
			} else {

				strApprovedBy = "<option value='0'>Select Value</option>";

			}

			String strRemarks = "";

			if (voObj.getOfflineRemarksList() != null
					&& voObj.getOfflineRemarksList().size() > 0) {

				voObj.getOfflineRemarksList().beforeFirst();

				strRemarks = util.getOptionValue(voObj.getOfflineRemarksList(),
						"", "", false);

				strRemarks = strRemarks + "<option value='0'>Others</option>";

			} else {

				strRemarks = "<option value='0' selected>Others</option>";

			}

			sb
					.append("<table class='TABLEWIDTH' align='center'  cellspacing='1px'>");
			sb.append("<tr> ");
			sb.append("<td class='TITLE'>Advance Details</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb
					.append("<table class='TABLEWIDTH' align='center'  cellspacing='1px'>");
			sb.append("<tr> ");
			sb.append("<td width='25%' class='LABEL'>Advance Amount:</td> ");

			if (!voObj.getStrOffLineAdvanceAmount().equals("")) {

				sb
						.append("<td width='25%' class='CONTROL'><input type='hidden' name='strdummypartpayment' value='"
								+ voObj.getStrOffLineAdvanceAmount()
								+ "'><input name='strPartpayment' tabindex='1'  id='strPartpayment' type='text' class='txtFldMin' value='"
								+ voObj.getStrOffLineAdvanceAmount()
								+ "' disabled='disabled' onkeyup='return setTotalRecAmt(this);' onkeypress='return validateData(event,7);' >&nbsp;Rs</td> ");

			} else {
				sb
						.append("<td width='25%' class='CONTROL'><input type='hidden' name='strdummypartpayment' value='0'><input name='strPartpayment' tabindex='1' id='strPartpayment' type='text' class='txtFldMin' value='0' disabled='disabled' onkeypress='return validateData(event,7);' onkeyup='return setTotalRecAmt(this);'>&nbsp;Rs</td> ");
			}

			sb.append("<td width='50%' class='LABEL' > ");
			sb.append("<div id='id11' style='display:block'> ");
			sb
					.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			sb.append("<tr>  ");
			sb.append("<td width='25%' class='LABEL'>Update:</td> ");
			sb
					.append("<td width='25%' class='CONTROL'><input type='checkbox' name='strChk_value' onClick='ftnTick();'></td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("</div>");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("<div id='combo' style='display:none'> ");
			sb
					.append("<table class='TABLEWIDTH' align='center'  cellspacing='1px'>");
			sb.append("<tr> ");
			sb
					.append("<td width='25%'  class='LABEL'><font color='red'>*</font>Approval By</td> ");
			sb.append("<td width='50%' colspan='3' class='CONTROL'> ");
			sb.append("<select name='strApprovedByCombo' class='comboBig'> ");
			sb.append(strApprovedBy);
			sb.append("</select> ");
			sb.append("</td> ");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td width='25%'  class='LABEL'>Remarks</td> ");
			sb.append("<td width='75%' colspan='3' class='CONTROL'> ");
			sb
					.append("<select name='dr' class='comboNormal' onChange='groupComboPartPayment();'> ");
			sb.append(strRemarks);
			sb.append("</select> ");
			sb
					.append("<input name='strRemarksCombo2' type='text' class='txtFldMax' value='"
							+ voObj.getStrOffLineRemarks()
							+ "' disabled='disabled'></td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("</div> ");

		} catch (Exception e) {
			new HisException("Cash Collection Trans",
					"CashCollectionTransHLP.getOffLineAdvanceDetailsView()-->",
					e.getMessage());
		}

		return sb.toString();
	}

	/**
	 * returns the required Online Client Details View (HTML) in String format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return - required Online Client Details View
	 */
	public static String getOffLineClientDetailsView(CashCollectionTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		WebRowSet wsClientDetails = voObj.getOfflineClientDetails();

		try {

			String strHidden = "";
			sb
					.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'> ");
			sb.append("<tr> ");
			sb.append("<td class='TITLE' width='20'> ");
			sb
					.append("<div id='plusoffLineClientDtlId' ><img  style='cursor: hand; cursor: pointer'    ");
			sb
					.append("	src='../../hisglobal/images/plus.gif' name='plusoffLineClientDtl' ");
			sb.append("align='middle'  ");
			sb
					.append("onclick='showCltDetails(\"offLineClientDtlId\");' /></div> ");
			sb
					.append("<div id='minusoffLineClientDtlId' style='display: none'><img  style='cursor: hand; cursor: pointer'    ");
			sb
					.append("src='../../hisglobal/images/minus.gif' name='minusoffLineClientDtl' ");
			// sb.append("width='10' height='10' ");
			sb
					.append("onclick='hideCltDetails(\"offLineClientDtlId\");'></div> ");
			sb.append("</td> ");
			sb.append("<td colspan='3' class='TITLE'>Client Details</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");

			sb.append("<div id='offLineClientDtlId' style='display: none'>");
			sb.append("<table class='TABLEWIDTH' align='center'>");

			if (wsClientDetails != null && wsClientDetails.size() > 0) {
				if (wsClientDetails.next()) {

					String strClientName = wsClientDetails.getString(3);
					String strClientType = wsClientDetails.getString(4);
					String strApprovalNo = wsClientDetails.getString(5);
					String strSancAmount = wsClientDetails.getString(7);
					String strBalanceAmount = wsClientDetails.getString(9);
					String strRequestType = wsClientDetails.getString(14);
					String strPaidByClient = wsClientDetails.getString(18)
							.replace("^", "#").split("#")[2];

					strHidden = wsClientDetails.getString(18);

					if (strClientName == null)
						strClientName = "";
					if (strClientType == null)
						strClientType = "";
					if (strSancAmount == null)
						strSancAmount = "";
					// if(strClientName == null) strClientName = "";
					if (strBalanceAmount == null)
						strBalanceAmount = "";
					if (strApprovalNo == null)
						strApprovalNo = "";
					if (strRequestType == null)
						strRequestType = "";

					voObj.setStrOfflineClientName(strClientName);
					voObj.setStrOffLineClientType(strClientType);
					voObj.setStrOffLineSancAmount(strSancAmount);
					voObj.setStrOffLineBalanceAmount(strBalanceAmount);
					voObj.setStrOffLineApprovalNo(strApprovalNo);

					sb.append("<tr>");
					sb
							.append("<td width='25%' class='LABEL'>Client Name<input type='hidden' name='strOfflineClientDetails' value='"
									+ strClientName
									+ "^"
									+ strClientType
									+ "^"
									+ strSancAmount
									+ "^"
									+ strBalanceAmount
									+ "^" + strApprovalNo + "^"+strPaidByClient+"'></td>");
					sb.append("<td width='25%' class='CONTROL'>"
							+ strClientName + "</td>");
					sb.append("<td width='25%' class='LABEL'>Client Type</td>");
					sb
							.append("<td width='25%' class='CONTROL'>"
									+ strClientType
									+ " <input type='hidden' name='strOffLineClientType' value='"
									+ strClientType + "'></td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb
							.append("<td width='25%' class='LABEL'>Sanction Amount</td>");
					sb
							.append("<td width='25%' class='CONTROL'>"
									+ strSancAmount
									+ " <input type='hidden' name='strOffLineSancAmount' value='"
									+ strSancAmount + "'></td>");
					sb
							.append("<td width='25%' class='LABEL'>Approval No.</td>");
					sb
							.append("<td width='25%' class='CONTROL'>"
									+ strApprovalNo
									+ " <input type='hidden' name='strOffLineApprovalNo' value='"
									+ strApprovalNo + "'></td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb
							.append("<td width='25%' class='LABEL'>Balance Amount</td>");
					sb
							.append("<td  width='25%' class='CONTROL'>"
									+ strBalanceAmount
									+ " <input type='hidden' name='strOffLineBalanceAmount' value='"
									+ strBalanceAmount
									+ "'> <input type='hidden' name='strOffLineClientDetailsHidden' value='"
									+ strHidden + "'> </td>");
					sb
							.append("<td class='LABEL' width='25%'>Paid by Client</td>");
					sb.append("<td class='CONTROL'>" + strPaidByClient
							+ "</td>");
					sb.append("</tr>");
				}

				sb.append("</table>");
				sb.append("</div>");

			} else {
				sb = new StringBuffer("");
			}

		} catch (SQLException e) {
			new HisException("Cash Collection Trans",
					"CashCollectionTransHLP.getonLineClientDetailsView()-->", e
							.getMessage());
		}

		return sb.toString();
	}

	public static String getOffLineOtherDetailsView(CashCollectionTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		String strAccNo = voObj.getStrOffLineAccountNo();

		if (strAccNo.length() > 1) {

			sb
					.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");

			sb.append("<tr>");

			sb.append("<td class='TITLE' width='20'> ");
			sb
					.append("<div id='plusoffLineOtherDtlId' ><img  style='cursor: hand; cursor: pointer'    ");
			sb
					.append("src='../../hisglobal/images/plus.gif' name='plusoffLineOtherDtl' ");
			sb.append("align='middle' ");
			sb
					.append("onclick='showCltDetails(\"offLineOtherDtlId\");' /></div> ");
			sb
					.append("<div id='minusoffLineOtherDtlId' style='display: none'><img  style='cursor: hand; cursor: pointer'    ");
			sb
					.append("src='../../hisglobal/images/minus.gif' name='minusoffLineOtherDtl' ");

			sb
					.append("onclick='hideCltDetails(\"offLineOtherDtlId\");'></div> ");
			sb.append("</td> ");
			sb.append("<td colspan='3' class='TITLE'>Other Details</td>");
			sb.append("</tr>");
			sb.append("</table>");

			sb.append("<div id='offLineOtherDtlId' style='display: none'>");
			sb
					.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			sb.append("<tr>");

			sb.append("<td width='50%' class='LABEL'>Account No.</td>");
			sb
					.append("<td width='50%' class='CONTROL'>"
							+ strAccNo
							+ " <input type='hidden' name='strOffLineAccountNo' value='"
							+ strAccNo + "'> </td>");

			sb.append("</tr>");

			sb.append("</table>");
			sb.append("</div>");

		}

		return sb.toString();
	}

	/*public static String getOffLineThirdPartyAmountDtlView() {

		StringBuffer sb = new StringBuffer("");

		sb
				.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
		sb.append("<tr> ");
		sb
				.append("<td width='60%' class='LABEL'>Max Benefit From Client (<img src='/AHIMS/hisglobal/images/INR.png'>)</td> ");
		sb
				.append("<td width='15%' class='CONTROL' style='font-weight: bold'> ");
		sb
				.append("<input type='hidden' name='strOfflineMaxClientBenefitAmount' id='strOfflineMaxClientBenefitAmount' value='0.00'> ");
		sb.append("<div id='offlineMaxClientBenefitDivId'>0.00</div> ");
		sb.append("</td> ");
		sb.append("</tr> ");
		sb.append("</table> ");
		sb
				.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
		sb.append("<tr> ");
		sb
				.append("<td width='60%' class='LABEL'>Net Payable Amount By Patient (<img src='/AHIMS/hisglobal/images/INR.png'>)</td> ");
		sb
				.append("<td width='15%' class='CONTROL' style='font-weight: bold'> ");
		sb
				.append("<input type='hidden' name='strOfflinePatNetPayAmount' id='strOfflinePatNetPayAmount' value='0.00'> ");
		sb.append("<div id='offlinePatNetPayDivId'>0.00</div> ");
		sb.append("</td> ");
		sb.append("</tr> ");
		sb.append("</table> ");

		return sb.toString();
	}*/

	/**
	 * returns the required Off-line Client Details View (HTML) in String
	 * format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return - required Online Client Details View
	 */
	public static String getOffLinePackageDetailsView(
			CashCollectionTransVO voObj) {

		StringBuffer sb = new StringBuffer("");
		String index = voObj.getStrOffLinePackageIndex();
		try {
			sb
					.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			sb.append("<tr>");
			sb.append("<td class='multiLabel' width='3%'> </td>");
			sb.append("<td class='multiLabel' width='18%'>Tariff Name</td>");
			sb.append("<td class='multiLabel' width='8%'>Rate/Unit</td>");
			sb
					.append("<td class='multiLabel' width='8%'>Package Quantity</td>");
			sb.append("<td class='multiLabel' width='8%'>Quantity</td>");
			sb.append("<td class='multiLabel' width='8%'>Each Unit</td>");
			sb.append("<td class='multiLabel' width='10%'>Net Amount</td>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb
					.append("<td class='multiControl'><input type='checkbox' name='pkgTariffChk"
							+ index + "'/>");
			sb.append("</td>");
			sb.append("<td class='multiControl'/>");
			sb.append("<td class='multiControl'/>");
			sb.append("<td class='multiControl'/>");
			sb.append("<td class='multiControl'/>");
			sb.append("<td class='multiControl'/>");
			sb.append("<td class='multiControl'/>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td colspan='6' class='LABEL'>Total </td>");
			sb.append("<td class='CONTROL'/>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td colspan='7' align='center'>");
			sb
					.append("<table border='0' width='100%' align='center' cellspacing='1px'>");
			sb.append("<tr>");
			sb
					.append("<td align='right'><img  style='cursor: hand; cursor: pointer'    src='../../hisglobal/images/add_tab.gif' onClick=''/></td>");
			sb
					.append("<td align='left'><img  style='cursor: hand; cursor: pointer'    src='../../hisglobal/images/btn-ccl.png' onClick='hidePkgDtls(\""
							+ index + "\");'/></td>");
			sb.append("</tr>");
			sb.append("</table>");
			sb.append("</td>");
			sb.append("</tr>");
			sb.append("</table>");

		} catch (Exception e) {
			new HisException("Cash Collection Trans",
					"CashCollectionTransHLP.getonTariffClientDetailsView()-->",
					e.getMessage());
		}

		return sb.toString();
	}

	/**
	 * returns the Required Off-Line Bill Details View (HTML) in String Format.
	 * 
	 * @param voObj -
	 *            Value Object.
	 * @return required Off-Line Bill Details View.
	 * @throws Exception
	 */
	public static String getBillDetails(CashCollectionTransVO voObj)
			throws Exception {

		WebRowSet billDetails = voObj.getOfflineBillList();
		StringBuffer sBuffer = new StringBuffer("");
		try {
			sBuffer
					.append("<table class='TABLEWIDTH' border='0' align='center' cellspacing='1px'>");
			sBuffer
					.append("<tr><td colspan='9' class='TITLE'>Bill Details</td></tr>");
			sBuffer.append("<tr><td width='5%' class='multiLabel'></td>");
			sBuffer.append("<td width='19%' class='multiLabel'>Bill No.</td>");
			sBuffer
					.append("<td width='19%' class='multiLabel'>Bill Date </td>");
			sBuffer.append("<td width='19%' class='multiLabel'>Bill Type</td>");
			sBuffer
					.append(" <td width='19%' class='multiLabel'>Bill Amount</td>");
			sBuffer.append("</tr>");
			sBuffer
					.append("<input type='hidden' name='xmlVal' id='xmlValId' value='"
							+ voObj.getStrOffLineRefundPenalty() + "'>");

			if (billDetails != null && billDetails.size() > 0) {

				int i = 0;

				while (billDetails.next()) {
					String billno = billDetails.getString(1);

					String temp[] = (billDetails.getString(6))
							.replace("^", "#").split("#");
					String bNo_HpSrv = billno + "^" + billDetails.getString(3)
							+ "^" + temp[4];
					String billdate = billDetails.getString(2);

					if (i == 0) {
						voObj.setStrOffLineBillNumber(billno);

						//voObj.setStrOffLineAccountNo(temp[4]);
					}

					sBuffer
							.append("<input type='hidden' name='billNo_Id' value='"
									+ bNo_HpSrv + "'>");
					sBuffer.append("<tr><td width='5%' class='multiLabel'> ");

					if (i == 0) {
						sBuffer
								.append("<input type='radio' name='strOfflineRefundBillDetails' value='"
										+ billDetails.getString(6)
										+ "' onClick='getBillTariffDtls(this);' checked='checked'> ");
					} else {
						sBuffer
								.append("<input type='radio' name='strOfflineRefundBillDetails' value='"
										+ billDetails.getString(6)
										+ "' onClick='getBillTariffDtls(this);'> ");
					}
					sBuffer.append("</td>");
					sBuffer.append("<td width='19%' class='multiControl'>");
					sBuffer.append(billno);
					sBuffer.append("</td>");
					sBuffer.append("<td width='19%' class='multiControl'>");
					sBuffer.append(billdate);
					sBuffer.append("</td>");
					/*
					 * sBuffer.append("<td width='19%' class='multiControl'>");
					 * sBuffer.append(billDetails.getString(3));
					 * sBuffer.append("</td>");
					 */
					sBuffer.append("<td width='19%' class='multiControl'>");
					sBuffer.append(billDetails.getString(4));
					sBuffer.append("</td>");
					sBuffer.append("<td width='19%' class='multiControl'>");
					sBuffer.append(billDetails.getString(5));
					sBuffer.append("</td></tr>");
					temp = null;
					i++;
				}
			} else {

				sBuffer
						.append("<tr><td colspan='9' class='multiControl' style='color:red;font-weight:bold'>No Refund Bills Available</td></tr>");
			}
			sBuffer.append("</table>");
		} catch (Exception e) {
			throw new Exception("Cash Collection Trans"
					+ "CashCollectionTransHLP.getBillDetails()-->"
					+ e.getMessage());
		}

		return sBuffer.toString();

	}

	/**
	 * returns Off-Line Tariff Details View (HTML) in String Format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return required Off-Line Tariff Details View.
	 * @throws Exception
	 */
	public static String getTariffDetails(CashCollectionTransVO voObj)
			throws Exception {
		StringBuffer sBuffer = new StringBuffer("");
		WebRowSet tariffDetails = voObj.getOfflineBillTariffList();
		try {
			HisUtil util = new HisUtil("", "");
			String app_id = "";
			String strUnitId = "";
			String strBaseUnitVal = "";
			int indxTrf = 1;
			sBuffer
					.append("<table class='TABLEWIDTH' border='0' align='center' cellspacing='1px'>");
			sBuffer
					.append("<tr><td colspan='9' class='TITLE'>Tariff Details</td></tr>");
			sBuffer.append("<tr><td width='5%' class='multiLabel'></td>");
			sBuffer
					.append("<td width='15%' class='multiLabel'>Tariff Name</td>");
			sBuffer
					.append("<td width='10%' class='multiLabel'>Balance Qty</td>");
			sBuffer
					.append("<td width='19%' class='multiLabel'>Refund Type</td>");
			sBuffer
					.append("<td width='14%' class='multiLabel'>Penalty (%)</td>");
			sBuffer
					.append(" <td width='10%' class='multiLabel'>Refund Qty</td>");
			sBuffer.append(" <td width='10%' class='multiLabel'>Unit</td>");
			sBuffer
					.append(" <td width='10%' class='multiLabel'>Refund Cost(in Rs)");
			sBuffer
					.append("<input type='hidden' name='strOfflineRefundTotalServiceTaxAmount' value='0' >");
			sBuffer
					.append("<input type='hidden' name='strOfflineRefundTotalDiscountAmount' value='0' >");
			sBuffer
					.append("<input type='hidden' name='strOfflineRefundTotalPenaltyAmount' value='0' >");
			sBuffer
					.append("<input type='hidden' name='strOfflineRefundTotalActualTariffAmount' value='0' >");
			sBuffer.append("</td>");
			sBuffer.append("</tr></table>");

			if (tariffDetails != null && tariffDetails.size() != 0) {

				while (tariffDetails.next()) {

					String TariffName = tariffDetails.getString(1);

					app_id = tariffDetails.getString(8) + "^"
							+ tariffDetails.getString(3);

					strUnitId = app_id.replace("^", "#").split("#")[4];

					strBaseUnitVal = app_id.replace("^", "#").split("#")[13];

					sBuffer
							.append("<table class='TABLEWIDTH' border='0' align='center' cellspacing='1px'>");
					sBuffer.append("<input type='hidden' name='lnkVal' value='"
							+ app_id + "'>");

					sBuffer
							.append("<tr><td width='5%' class='multiLabel'><input type='checkbox' name='strBillTariffVal'id='strBillTariffVal"
									+ indxTrf
									+ "' value='"
									+ app_id
									+ "' onClick='initBillTariff(this,\""
									+ indxTrf
									+ "\",\""
									+ tariffDetails.getString(2)
									+ "\");'></td>");
					sBuffer.append("<td width='15%' class='multiControl'>");

					sBuffer
							.append("<input type='hidden' name='strOfflineRefundServiceTaxAmount' id='strOfflineRefundServiceTaxAmount"
									+ indxTrf + "' value='0' >");
					sBuffer
							.append("<input type='hidden' name='strOfflineRefundDiscountAmount' id='strOfflineRefundDiscountAmount"
									+ indxTrf + "' value='0' >");
					sBuffer
							.append("<input type='hidden' name='strOfflineRefundPenaltyAmount' id='strOfflineRefundPenaltyAmount"
									+ indxTrf + "' value='0' >");
					sBuffer
							.append("<input type='hidden' name='strOfflineRefundActualTariffAmount' id='strOfflineRefundActualTariffAmount"
									+ indxTrf + "' value='0' >");

					sBuffer
							.append("<a name='strBillTariffName' id='strBillTariffName"
									+ indxTrf
									+ "' STYLE='CURSOR:POINTER; color:blue' value='"
									+ app_id
									+ "'  onClick='showTariffPopup(this,\""
									+ app_id + "\");'>" + TariffName + "</a>");
					sBuffer.append("</td>");
					sBuffer.append("<td width='10%' class='multiControl'>");
					sBuffer.append(tariffDetails.getString(2));
					sBuffer.append("</td>");
					sBuffer.append("<td width='19%' class='multiControl'>");

					sBuffer
							.append("<select class='comboNormal' name='strBillTariffPenaltyType' id='strBillTariffPenaltyType"
									+ indxTrf
									+ "' disabled='disabled' onChange='setPenalty(this,"
									+ indxTrf
									+ "),calcBillTariffRefundAmt(\""
									+ indxTrf
									+ "\",\""
									+ app_id
									+ "\");'><option value='1'>Hospital Choice</option><option value='2'>Patient Choice</option></select>");
					sBuffer.append("</td>");
					sBuffer.append("<td width='14%' class='multiControl'>");

					sBuffer
							.append("<input type='hidden' class='txtFldMin' name='strBillTariffPenalty' id='strBillTariffPenalty"
									+ indxTrf
									+ "' value='0' onkeypress='return validateData(event,5);' ><div id='strBillTariffPenaltyDivId"
									+ indxTrf + "'>0</div>");
					sBuffer.append("</td>");
					sBuffer.append("<td width='10%' class='multiControl'>");

					sBuffer
							.append("<input type='text' class='txtFldMin' name='strBillTariffRefund' id='strBillTariffRefund"
									+ indxTrf
									+ "' value='0' onkeypress='return validateData(event,5);'  disabled='disabled' onkeyup='calcBillTariffRefundAmt(\""
									+ indxTrf + "\",\"" + app_id + "\");'>");
					sBuffer.append("</td>");
					sBuffer.append("<td width='10%' class='multiControl'>");

					sBuffer
							.append("<select class='comboMin' name='strBillTariffUnit' id='strBillTariffUnit"
									+ indxTrf
									+ "' disabled='disabled' onChange='calcBillTariffRefundAmt(\""
									+ indxTrf + "\",\"" + app_id + "\");'> ");

					voObj.setStrOffLineTariffUnitTempId(strUnitId);

					CashCollectionTransDAO.getOffLineTariffUnitList(voObj);

					// System.out.println("unit Val : "+strUnitId);

					sBuffer.append(util.getOptionValue(voObj
							.getOfflineTariffUnit(), strUnitId + "^"
							+ strBaseUnitVal, "", false));

					sBuffer.append("</select>");
					sBuffer.append("</td>");
					sBuffer.append("<td width='10%' class='multiControl'>");

					sBuffer
							.append("<input type='hidden' class='txtFldMin' disabled='disabled' name='strBillTariffRefundAmount' id='strBillTariffRefundAmount"
									+ indxTrf
									+ "' value='0' style='font-weight: bold'><div id='strBillTariffRefundAmountDivId"
									+ indxTrf
									+ "' style='font-weight:bold'>0.00</div></td> ");

					indxTrf++;

				}
				sBuffer.append("</tr></table>");
			} else {

				sBuffer
						.append("<table class='TABLEWIDTH' border='0' align='center' cellspacing='1px'><tr><td colspan='9' class='multiControl' style='color:red;font-weight:bold'>No Tariff(s) Available</td></tr></table>");

			}

		} catch (Exception e) {

			throw new Exception("Cash Collection Trans"
					+ "CashCollectionTransHLP.getTariffDetails()-->"
					+ e.getMessage());
			
		}
		return sBuffer.toString();

	}

	
		
	
	/**
	 * returns Off-Line Bill Tariff Pop up Details View (HTML) in String Format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return required Off-Line Bill Tariff Pop up Details View
	 */
	public static String getPopUp(CashCollectionTransVO voObj) {
		StringBuffer sb = new StringBuffer("");
		String strValmode = voObj.getStrOffLineTariffDetailsHiddenValue();
		String temp = "";
		String val[] = strValmode.replace('^', '#').split("#");
		String strRatePerUnit = val[3] + "/" + val[12];

		try {
			if (strValmode != null) {
				if (val[9].equals("2")){
					
					temp = "Percentage";
				}else{
					
					temp = "Fixed";
				}
					

				sb
						.append("<table width='400' align='center' cellpadding='0' cellspacing='0'>");
				sb
						.append("<tr class='HEADER' align='left'><td>&nbsp;Refund Cost Calculation Details</td>");
				sb
						.append("<td align='right'><img  style='cursor: hand; cursor: pointer'    src='../../hisglobal/images/stop.png' align='middle' onclick='hide_popup_menu(\"offlineBillTariffPopupDetailsDivId\");'> </td></tr>");
				sb.append("</table> ");
				sb
						.append("<table width='400' align='center' cellspacing='1px'>");
				sb.append("<tr>");
				sb
						.append("<td class='multiLabel' width='20%'>Rate(Rs)/Unit</td>");
				sb.append("<td class='multiControl' width='20%'>"
						+ strRatePerUnit + "</td>");
				sb
						.append("<td class='multiLabel' width='20%'>Discount(Rs)</td>");
				sb.append("<td class='multiControl' width='20%'>" + val[8]
						+ "</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb
						.append("<td class='multiLabel' width='20%'>Discount Type</td>");
				sb.append("<td class='multiControl' width='20%'>" + temp
						+ "</td>");
				sb
						.append("<td class='multiLabel' width='20%'>Service Tax(%)</td>");
				sb.append("<td class='multiControl' width='20%'>" + val[7]
						+ "</td>");
				sb.append("</tr>");
				sb.append("</table>");
				sb.append("<table width='400' align='center'>");
				sb.append("<tr class='FOOTER'>");
				sb.append("<td colspan='3'>&nbsp;</td>");
				sb.append("</tr></table>");
			} else {
				sb.append("<table width='400' align='center'>");
				sb.append("<tr class='FOOTER'>");
				sb.append("<td colspan='3'>&nbsp;</td>");
				sb.append("</tr></table>");
			}
		} catch (Exception e) {
			new HisException("Cash Collection Trans",
					"CashCollectionTransHLP.getPopUpDtl()-->", e.getMessage());
		}

		return sb.toString();

	}

	public static String getRefundTariffPopUp(CashCollectionTransVO voObj) {
		StringBuffer sb = new StringBuffer("");

		String strValmode = voObj.getStrRefundTariffHiddenValue();

		String val[] = strValmode.replace('^', '#').split("#");

		String strRateUnit = val[3] + "/" + val[12];
		String strDiscountUnit = val[8];
		String strDiscountType = val[9];
		String strServiceTax = val[7];
		String strPenalty = val[16];

		if (strDiscountType.equals("2")) {
			strDiscountUnit = strDiscountUnit + " %";
		} else {
			strDiscountUnit = strDiscountUnit + " Fixed";
		}

		try {

			sb
					.append("<table width='400' align='center' cellpadding='0' cellspacing='0'>");
			sb
					.append("<tr class='HEADER' align='left'><td>&nbsp;Refund Cost Calculation Details</td>");
			sb
					.append("<td align='right'><img  style='cursor: hand; cursor: pointer'    src='../../hisglobal/images/stop.png' align='middle' onclick='hide_popup_menu(\"refundTariffPopupDetailsDivId\");'> </td></tr>");
			sb.append("</table> ");
			sb.append("<table width='400' align='center' cellspacing='1px'>");
			sb.append("<tr>");
			sb
					.append("<td class='multiLabel' width='25%'>Rate(Rs)/Unit</td><td class='multiControl'  width='25%'>"
							+ strRateUnit + "</td>");
			sb
					.append("<td class='multiLabel'  width='25%'>Discount/ Unit</td> <td class='multiControl'  width='25%'>"
							+ strDiscountUnit + "</td>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb
					.append("<td class='multiLabel'  width='25%'>Service Tax (%) </td> <td class='multiControl'  width='25%'>"
							+ strServiceTax + "</td>");
			sb
					.append("<td class='multiLabel'  width='25%'>Penalty (%)</td> <td class='multiControl'  width='25%'>"
							+ strPenalty + "</td>");
			sb.append("</tr>");
			sb.append("</table>");
			sb.append("<table width='400' align='center' cellspacing='1px'>");
			sb.append("<tr class='FOOTER'>");
			sb.append("<td colspan='3'>&nbsp;</td>");
			sb.append("</tr></table>");
		} catch (Exception e) {

			new HisException("Cash Collection Trans",
					"CashCollectionTransHLP.getPopUpDtl()-->", e.getMessage());
		}

		return sb.toString();

	}

	public static String getGuarantorDetails(CashCollectionTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		String strGaurantorVals = voObj.getStrGuarantorHiddenVal().trim();
		
		String[] strGaurantorVal = strGaurantorVals.replace("^", "#")
				.split("#");

		String strContact = strGaurantorVal[2];
		
		if(strContact.length() < 2){
			strContact = " ";
		}
		
		String strAge = strGaurantorVal[3] ;
		
		if(strGaurantorVal[3].equals("1")){
			
			strAge = strAge + " Day(s)";
			
		}else if(strGaurantorVal[3].equals("2")) {
			
			strAge = strAge + " Month(s)";
			
		}else{
			
			
			strAge = strAge + " Year(s)";
		}
		
		
		sb
				.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
		sb.append("<tr>");
		sb.append("<td colspan='4' class='TITLE'>Patient Details");
		sb.append("</td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb
				.append("<td width='25%' class='LABEL' >Patient Name</td>");
		sb
				.append("<td width='25%'  class='CONTROL'><input type='hidden' name='strGuarantorHiddenVal' value='"
						+ voObj.getStrGuarantorHiddenVal()
						+ "'>"
						+ strGaurantorVal[0] + "</td>");
		
		sb.append("<td width='25%' class='LABEL'>Contact No.</td>");
		sb.append("<td width='25%' class='CONTROL' >"
				+ strContact + "</td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td width='25%' class='LABEL'>Patient Address");

		sb.append("<input type='hidden' name='xmlVal' id='xmlValId' value='"
				+ voObj.getStrOffLineRefundPenalty() + "'></td>");

		sb.append("<td width='75%' colspan='3' class='CONTROL'>"
				+ strGaurantorVal[1] + "</td>");
		sb.append("</tr>");
		
	
		sb.append("<tr> ");
		sb.append("<td width='25%'  class='LABEL'><font color='red'>*</font>Referring Physician</td> ");
		sb.append("<td width='75%' colspan='3' class='CONTROL'>"+strGaurantorVal[5]+"<input type='hidden' class='txtFldMax' name='strReferringPhysician' value='"+strGaurantorVal[5]+"'> </td> ");
		sb.append("</tr> ");
		sb.append("<tr> ");
		sb.append("<td width='25%' class='LABEL' ><font color='red'>*</font>Age</td> ");
		sb.append("<td width='25%' class='CONTROL'> "+ strAge);
		
		sb.append("</td> ");
		sb.append("<td width='25%' class='LABEL' ><font color='red'>*</font>Gender</td> ");
		sb.append("<td width='25%' class='CONTROL' ><select name='strGender' class='comboMin' disabled='disabled'> ");
		sb.append(voObj.getStrGenderList());
		sb.append("</select> ");
		sb.append("</td> ");
		sb.append("</tr> ");
		
		
		sb.append("</table>");

		return sb.toString();
	}

	public static String getBillListingView(CashCollectionTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		WebRowSet ws = voObj.getBillSearchList();

		try {

			int start = Integer.parseInt(voObj.getStrBillFromRow());
			int actualBlockSet = Integer.parseInt(voObj.getStrBillCtBlockSet());

			final int REC_PER_PAGE = Integer.parseInt(voObj
					.getStrBillRowPerPage());
			final int PAGE_PER_BLOCK = 10;

			int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
			int totalRecordsToManipulate = totalFetchRecord - 1;

			int previous = 1;
			int next = 0;

			if (ws != null) {

				if (ws.size() != 0) {

					int actualFetchRecord = ws.size();

					if (actualBlockSet == 1)
						actualBlockSet = actualBlockSet + 1;

					next = ((actualBlockSet * PAGE_PER_BLOCK) - PAGE_PER_BLOCK) + 1;
					previous = (((actualBlockSet - 2) * PAGE_PER_BLOCK) - PAGE_PER_BLOCK) + 1;

					if (totalFetchRecord != actualFetchRecord) {

						totalFetchRecord = actualFetchRecord;
						totalRecordsToManipulate = actualFetchRecord;
						next = 0;

					}

					int totalLayer = totalRecordsToManipulate / REC_PER_PAGE;
					int reminder = totalRecordsToManipulate % REC_PER_PAGE;

					if (reminder > 0)
						totalLayer = totalLayer + 1;

					sb
							.append("<table width='100%'align='center' cellspacing='1px'>");

					sb.append("<tr>");
					sb.append("<td class='LABEL'>&nbsp;");

					if (start != 1) {
						sb
								.append("<a STYLE='CURSOR:POINTER'  onClick='fetchPatientList(\""
										+ previous
										+ "\",\""
										+ (actualBlockSet - 1)
										+ "\");'> <FONT COLOR='"
										+ strColor
										+ "'> &lt;&lt; Previous</FONT> </a> &nbsp;");

					}
					for (int i = 1; i <= totalLayer; i++) {

						if (i == 1) {
							sb.append("<a STYLE='CURSOR:POINTER; color:"
									+ strColor + "' name='linId' id='linId" + i
									+ "' onClick='layerIndexNavigator(\"" + i
									+ "\",\"" + totalLayer + "\")'>");
							sb.append((i + start - 1));

						} else {
							sb.append("<a STYLE='CURSOR:POINTER; color:"
									+ defaultColor + "' name='linId' id='linId"
									+ i + "' onClick='layerIndexNavigator(\""
									+ i + "\",\"" + totalLayer + "\")'>");
							sb.append((i + start - 1));
						}
						sb.append("</a> &nbsp;");
					}

					if (next > 0)
						sb
								.append("<a STYLE='CURSOR:POINTER' onClick='fetchPatientList(\""
										+ next
										+ "\",\""
										+ (actualBlockSet + 1)
										+ "\");'> <FONT COLOR='"
										+ strColor
										+ "'> Next &gt;&gt;</FONT></a>");

					sb.append("</td>");
					sb.append("</tr>");
					sb.append("</table>");

					/*
					 * sb .append("<table width='100%'align='center'
					 * cellspacing='1px'>");
					 * 
					 * sb.append("<tr>"); sb.append("<td class='LABEL'>&nbsp;");
					 * 
					 * if (start != 1) { sb.append("<a href='#'
					 * onClick='fetchBillList(\"" + previous + "\",\"" +
					 * (actualBlockSet - 1) + "\");'> &lt;&lt; Previous</a>
					 * &nbsp;"); } for (int i = 1; i <= totalLayer; i++) {
					 * sb.append("<a href='#' onClick='layerIndexNavigator(\"" +
					 * i + "\",\"" + totalLayer + "\")'>" + (i + start - 1) + "</a>
					 * &nbsp;"); }
					 * 
					 * if (next > 0) sb.append("<a href='#'
					 * onClick='fetchBillList(\"" + next + "\",\"" +
					 * (actualBlockSet + 1) + "\");'> Next &gt;&gt;</a>");
					 * 
					 * sb.append("</td>"); sb.append("</tr>"); sb.append("</table>");
					 */
					sb
							.append("<table width='100%'align='center' cellspacing='1px'>");

					sb.append("<tr>");
					sb.append("<td width='5%'class='multiLabel'>");
					sb.append("</td>");
					sb
							.append("<td width='23%'class='multiLabel'>Patient Name");
					sb.append("</td>");
					sb.append("<td width='18%'class='multiLabel'>Bill No.");
					sb.append("</td>");
					sb.append("<td width='18%'class='multiLabel'>Bill Date");
					sb.append("</td>");
					sb.append("<td width='18%'class='multiLabel'>Bill Amount");
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("</table>");

					for (int i = 1; i <= totalLayer; i++) {

						if (i < totalLayer
								|| (i == totalLayer && reminder == 0)) {
							if (i == 1) {
								sb.append("<div id='tariffDivId" + i
										+ "' style='display:block'>");
							} else {
								sb.append("<div id='tariffDivId" + i
										+ "' style='display:none'>");
							}

							sb
									.append("<table width='100%'align='center' cellspacing='1px'>");
							for (int j = 0; j < REC_PER_PAGE; j++) {
								ws.next();
								sb
										.append("<tr ><td class='multiLabel' width='5%'><input type='radio' name='strBillNo' value='");
								sb.append(ws.getString(2));
								sb.append("'></td>");
								sb
										.append("<td class='multiControl' width='23%'>");
								sb.append(ws.getString(1));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(2));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(3));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(4));
								sb.append("</td>");
								sb.append("</tr>");
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
							sb
									.append("<table width='100%'align='center' cellspacing='1px'>");
							for (int k = 0; k < reminder; k++) {
								ws.next();
								sb
										.append("<tr ><td class='multiLabel' width='5%'><input type='radio' name='strBillNo' value='");
								sb.append(ws.getString(2));
								sb.append("'></td>");
								sb
										.append("<td class='multiControl' width='23%'>");
								sb.append(ws.getString(1));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(2));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(3));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(4));
								sb.append("</td>");
								sb.append("</tr>");
							}
							sb.append("</table>");
							sb.append("</div>");

						}

					}

					sb.append("</td>");
					sb.append("</'tr>");

					sb.append("</table>");

				} else {
					sb
							.append("<table width='100%'align='center' cellspacing='1px'>");
					sb
							.append("<tr><td class='multiControl'><font color='red'>No Matching Record Found</font></td></tr>");
					sb.append("</table>");
				}

			} else {

				throw new Exception("Patient List WebRowSet is Null");

			}

		} catch (Exception e) {
			new HisException("Cash Collection Trans",
					"CashCollectionTransHLP.getPatientListingView()-->", e
							.getMessage());
		}

		return sb.toString();

	}

	public static String getOnLineReconcileTariffDetailsView(
			CashCollectionTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		String strTempQtyType = "";
		int trfIndex = 0;

		float fltTariffActAmt = 0;
		
		WebRowSet wsTariffDetails = voObj.getOnlineTariffDetails();

		try {

			sb
			.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
	sb.append("<tr>");
	sb.append("<td class='TITLE' colspan='9'>Tariff Detail</td>");
	sb.append("</tr>");
	sb.append("<tr>");
	sb.append("<td class='multiLabel'></td>");
	sb.append("<td class='multiLabel'>Tariff Name</td>");
	sb.append("<td class='multiLabel'>Reconcile Type<input type='hidden' class='txtFldMin' name='strTotalTariffActualAmount' value='0' ></td>");
	sb.append("<td class='multiLabel'>Rate/Unit<input type='hidden' class='txtFldMin' name='strTotalTariffDiscountAmount' value='0' ></td>");
	sb
			.append("<td class='multiLabel'>Req. Qty.<input type='hidden' class='txtFldMin' name='strTotalTariffServiceTaxAmount' value='0' ></td>");
/*	sb
			.append("<td class='multiLabel'>Billed Qty.</td></td>");
	sb
			.append("<td class='multiLabel'>Unit</td></td>");*/
	sb.append("<td class='multiLabel'>Discount Amt</td>");
	sb.append("<td class='multiLabel'>Net Tariff Amt</td>");
	sb.append("</tr>");

			sb.append("</tr>");

			if (wsTariffDetails != null && wsTariffDetails.size() > 0) {

				while (wsTariffDetails.next()) {

					trfIndex = trfIndex + 1;

					String strGroupId = wsTariffDetails.getString(1);
					String strTariffId = wsTariffDetails.getString(2);
					String strChargeTypeId = wsTariffDetails.getString(3);
					String strGblTariffId = wsTariffDetails.getString(4);
					String strRateUnitId = wsTariffDetails.getString(5);
					String strApprovalId = wsTariffDetails.getString(6);
					// String strBserviceType = wsTariffDetails.getString(7);
					String strTariffName = wsTariffDetails.getString(7);

					// String strGroupName = wsTariffDetails.getString(9);
					String strUnitName = wsTariffDetails.getString(10);
					String strReqQty = wsTariffDetails.getString(11);
					String strBillQty = wsTariffDetails.getString(12);
					String strTariffRate = wsTariffDetails.getString(13);
					String strDisountUnit = wsTariffDetails.getString(14);
					String strDiscountType = wsTariffDetails.getString(15);
					String strQtyUnitName = wsTariffDetails.getString(18);
					String strQtyUnitId = wsTariffDetails.getString(19);
					String strIsPackage = wsTariffDetails.getString(20);
					String strServiceTax = wsTariffDetails.getString(21);
					String strPenelty = wsTariffDetails.getString(22);
					String strApprovalDtl = wsTariffDetails.getString(23);
					String strQtyType = wsTariffDetails.getString(24);
					String strRateBaseVal = wsTariffDetails.getString(25);
					String strQtyBaseVal = wsTariffDetails.getString(26);
					String strNetCost = wsTariffDetails.getString(27);
					String strReceiptNo = wsTariffDetails.getString(28);
					String strActualRate = wsTariffDetails.getString(29);
					// String strDisountType =
					// wsTariffDetails.getString(15);

					if (strGroupId == null)
						strGroupId = "";
					if (strTariffId == null)
						strTariffId = "";
					if (strChargeTypeId == null)
						strChargeTypeId = "";
					if (strGblTariffId == null)
						strGblTariffId = "";
					if (strRateUnitId == null)
						strRateUnitId = "";
					if (strApprovalId == null)
						strApprovalId = "";
					if (strTariffName == null)
						strTariffName = "";
					if (strReqQty == null)
						strReqQty = "0";
					if (strBillQty == null)
						strBillQty = "0";
					if (strTariffRate == null)
						strTariffRate = "0";
					if (strDisountUnit == null)
						strDisountUnit = "0";
					if (strRateBaseVal == null)
						strRateBaseVal = "";
					if (strQtyBaseVal == null)
						strQtyBaseVal = "";

					if(strQtyType.equals("1")){
						strTempQtyType = "Services";
					}else{
						strTempQtyType = "Refund";
					}
					
					
					String strHiddenVal = strTariffId + "^" + strReqQty + "*"
							+ strQtyBaseVal + "^" + strQtyUnitId + "^"
							+ strTariffRate + "^" + strRateUnitId + "^"
							+ strGroupId + "^" + strActualRate + "^"
							+ strServiceTax + "^" + strDisountUnit + "^"
							+ strDiscountType + "^" + strGblTariffId + "^"
							+ strApprovalId + "^" + strUnitName + "^"
							+ strRateBaseVal + "^" + strIsPackage + "^"
							+ strNetCost + "^" + strPenelty + "^" + "0^"
							+ strReceiptNo + "^" + strApprovalDtl +"^"+strQtyType;


					fltTariffActAmt = Float.parseFloat(strTariffRate) * Float.parseFloat(strReqQty);
					
					
			sb.append("<tr>");
			sb
					.append("<td class='multiControl'><input type='checkbox' name='strTariffDetailsId' value='");
			sb.append(strHiddenVal);

			sb.append("' onclick='setOnlineReconcileTariffDetails(this, \""
					+ trfIndex + "\" , \""+strQtyType+"\")'></td>");
			sb
					.append("<td class='multiControl'><a name='strBillTariffName' id='strBillTariffName"
							+ trfIndex
							+ "' STYLE='CURSOR:POINTER; color:blue' value='"
							+ strHiddenVal
							+ "'  onClick='showTariffPopup(this,\""
							+ strHiddenVal
							+ "\");'>"
							+ strTariffName
							+ "</a><input type='hidden' class='txtFldMin' name='strTariffServiceTaxAmt' id='strTariffServiceTaxAmt"
							+ trfIndex
							+ "' value='' disabled='disabled'></td>");
			
			sb.append("<td class='multiControl'>"+strTempQtyType+"</td>");
			
			sb
					.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strTariffRate' id='strTariffRate"
							+ trfIndex
							+ "' value='"
							+ strTariffRate
							+ "' disabled='disabled'>"
							+ strTariffRate
							+ "/"
							+ strUnitName
							+ "<input type='hidden' class='txtFldMin' name='strTariffActualAmt' id='strTariffActualAmt"
							+ trfIndex
							+ "' value='"+fltTariffActAmt+"' disabled='disabled'></td>");
			sb
					.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strTariffReqQty' id='strTariffReqQty"
							+ trfIndex
							+ "' value='"
							+ strReqQty
							+ "' disabled='disabled'>"
							+ strReqQty
							+ "/" + strQtyUnitName + "</td>");
		/*	sb
					.append("<td class='multiControl'><input type='text' class='txtFldMin' name='strTariffBilledQty' id='strTariffBilledQty"
							+ trfIndex
							+ "' onkeyup='setOnlineReconcileTariffDltsOnQtyChange(this, \""
							+ strHiddenVal
							+ "\", \""
							+ trfIndex
							+ "\");' value='0' disabled='disabled'></td>");

			sb.append("<td width='10%' class='multiControl'>");

			sb
					.append("<select class='comboMin'  onchange='setOnlineReconcileTariffDltsOnQtyUnitChange(this, \""
							+ strHiddenVal
							+ "\", \""
							+ trfIndex
							+ "\");'  name='strBillTariffUnit' id='strBillTariffUnit"
							+ trfIndex + "' disabled='disabled' > ");

			voObj.setStrOffLineTariffUnitTempId(strQtyUnitId);

			CashCollectionTransDAO.getOffLineTariffUnitList(voObj);

			if (voObj.getOfflineTariffUnit() != null
					&& voObj.getOfflineTariffUnit().size() > 0) {
				sb.append(new HisUtil("", "").getOptionValue(voObj
						.getOfflineTariffUnit(), strQtyUnitId + "^"
						+ strQtyBaseVal, "0^Select Value", false));
			} else {
				sb.append("<option value='1701^1'>Select Value</option>");
			}

			sb.append("</select>");
			sb.append("</td>");*/

			sb
					.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strTariffDiscountAmt' id='strTariffDiscountAmt"
							+ trfIndex
							+ "' value='0' disabled='disabled'><div id='strTariffDiscountAmtDivId"
							+ trfIndex + "'>0.00</div></td>");
			sb
					.append("<td class='multiControl' style='font-weight:bold'><input type='hidden' class='txtFldMin' name='strTariffNetAmt' id='strTariffNetAmt"
							+ trfIndex
							+ "' value='0' disabled='disabled'><div id='strTariffNetAmtDivId"
							+ trfIndex + "'>0.00</div></td>");
			sb.append("</tr>");

		}
		sb.append("</table>");

	/*	sb
		.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'><tr>");
		
		sb.append("<td class='LABEL' colspan='4' width='50%'>Bill Type</td><td class='CONTROL' width='50%' colspan='3'><select name='strBillType' class='comboNormal'><option value='1'>Consolidated</option><option value='1'>Detailed</option></selected></td>");
		
		sb.append("</tr></table>");*/
		
		}
			
		} catch (Exception e) {
			new HisException(
					"Cash Collection Trans",
					"CashCollectionTransHLP.getOnLineReconcileTariffDetailsView()-->",
					e.getMessage());
		}

		return sb.toString();
	}

	/*public static String getOnLineReconcileTariffDetailsPopUp(
			CashCollectionTransVO voObj) {
		StringBuffer sb = new StringBuffer("");

		String strValmode = voObj.getStrOnLineReconcileTariffHiddenValue();

		String val[] = strValmode.replace('^', '#').split("#");

		String strTariffRatePerUnit = val[0];
		String strDisountUnit = val[1];
		String strServiceTax = val[3];
		if (val[2].equals("1")) {

			strDisountUnit = strDisountUnit + " Fixed";
		} else {
			strDisountUnit = strDisountUnit + " %";
		}

		try {

			sb
					.append("<table width='400' align='center' cellpadding='0' cellspacing='0'>");
			sb
					.append("<tr class='HEADER' align='left'><td>&nbsp;Refund Cost Calculation Details</td>");
			sb
					.append("<td align='right'><img  style='cursor: hand; cursor: pointer'    src='../../hisglobal/images/stop.png' align='middle' onclick='hide_popup_menu(\"reconcilTariffPopupDetailsDivId\");'> </td></tr>");
			sb.append("</table> ");
			sb.append("<table width='400' align='center' cellspacing='1px'>");
			sb.append("<tr>");
			sb.append("<td class='multiLabel' width='20%'>Rate(Rs)/Unit</td>");
			sb.append("<td class='multiControl' width='20%'>"
					+ strTariffRatePerUnit + "</td>");
			sb.append("<td class='multiLabel' width='20%'>Discount(Rs)</td>");
			sb.append("<td class='multiControl' width='20%'>" + strDisountUnit
					+ "</td>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td class='multiLabel' width='20%'>Service Tax(%)</td>");
			sb.append("<td class='multiControl' width='20%'>" + strServiceTax
					+ "</td>");
			sb.append("<td class='multiLabel' colspan='2' width='20%'></td>");
			sb.append("</tr>");
			
			sb.append("</table>");
			sb.append("<table width='400' align='center'>");
			sb.append("<tr class='FOOTER'>");
			sb.append("<td colspan='3'>&nbsp;</td>");
			sb.append("</tr></table>");
		} catch (Exception e) {

			new HisException(
					"Cash Collection Trans ",
					"CashCollectionTransHLP.getOnLineReconcileTariffDetailsPopUp()-->",
					e.getMessage());
		}

		return sb.toString();

	}
*/
	public static String getAdmissionCancellationDetails(
			CashCollectionTransVO voObj, String mode) {
		StringBuffer sb = new StringBuffer("");

		WebRowSet ws = null;

		try {

			ws = voObj.getAdmissionCancellationDetails();

			if (ws.next()) {

				String strAccountNo = ws.getString(1);
				String strReceivedAmt = ws.getString(2);
				String strExpenceAmt = ws.getString(3);
				String strRefundAmt = ws.getString(4);
				String strBillNo = ws.getString(7);

				sb
						.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				sb.append("<tr>");
				sb
						.append("<td colspan='4' class='TITLE'>Refund Advance Details</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb
						.append("<td class='LABEL' width='25%'>Received Amount (<img src='/AHIMS/hisglobal/images/INR.png'>)</td>");
				sb
						.append("<td class='CONTROL' width='25%' style='font-weight:bold'>"
								+ strReceivedAmt
								+ "<input type='hidden' name='strAdmissionCancellationReceivedAmount' value='"
								+ strReceivedAmt
								+ "'><input type='hidden' name='strBillNo' value='"
								+ strBillNo
								+ "'><input type='hidden' name='strRefundAdvancePaneltyAmt' value='0'></td>");
				sb
						.append("<td class='LABEL' width='25%'>Expense Amount (<img src='/AHIMS/hisglobal/images/INR.png'>)</td>");
				sb
						.append("<td class='CONTROL' width='25%' style='font-weight:bold'>"
								+ strExpenceAmt
								+ "<input type='hidden' name='strAdmissionCancellationExpenseAmount' value='"
								+ strExpenceAmt + "'></td>");
				sb.append("</tr>");
				sb.append("<tr>");
				if (mode.equals("2")) {
					sb.append("<td class='LABEL' width='25%'>Refund Type</td>");
					sb
							.append("<td class='CONTROL' width='25%'><select onchange='setAdmissionCancellationPenalty(this);' name='strAdmissionCancellationRefundType' ><option value='1'>Hospital Choice</option><option value='2'>Patient Choice</option></select></td>");
					sb.append("<td class='LABEL'  width='25%'>Penalty</td>");
					sb
							.append("<td class='CONTROL' width='25%' style='font-weight:bold'><input type='hidden' name='strAdmissionCancellationPenalty' value='0'><div id='strAdmissionCancellationPenaltyDivId'>0 %</div></td>");
				} else {
					sb.append("<td class='multiLabel'  width='25%'></td>");
					sb
							.append("<td class='CONTROL' width='25%' style='font-weight:bold'><input type='hidden' name='strAdmissionCancellationPenalty' value='0'><div id='strAdmissionCancellationPenaltyDivId'>0 %</div></td>");
					sb
							.append("<td class='CONTROL' colspan='3' width='20%'></td>");
				}
				sb.append("</tr>");
				sb.append("</table>");

				sb.append("^" + strRefundAmt + "^" + strAccountNo);

			}
		} catch (Exception e) {

			new HisException(
					"Cash Collection Trans ",
					"CashCollectionTransHLP.getAdmissionCancellationDetails()-->",
					e.getMessage());
		}

		return sb.toString();

	}

}
