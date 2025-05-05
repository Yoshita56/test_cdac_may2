/**
 * 
 */
package mms.transactions.controller.hlp;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.MmsConfigUtil;
import mms.transactions.bo.IssueDeskTransBO;
import mms.transactions.controller.fb.IssueDeskTransFB;
import mms.transactions.dao.IssueDeskTransDAO;
import mms.transactions.vo.IssueDeskTransVO;

/**
 * Developer : Anshul Jindal Version : 1.1 Date : 11/June/2009 (Changes)
 * 
 */
/**
 * Developer : Anshul Jindal (To Continue) Version : 1.0 Date : 02/Apr/2009
 * 
 */

public class IssueDeskTransHLP {

	static int i = 0;

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

		IssueDeskTransBO bo = null;
		IssueDeskTransVO vo = null;
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
		int i = 0;

		try {
			hisutil = new HisUtil("mms", "IssueDeskTransHLP");
			bo = new IssueDeskTransBO();
			vo = new IssueDeskTransVO();

			vo.setStrHospitalCode(strHospitalCode);
			if (wb.size() != 0) {

				br.append(
						"<table class='TABLEWIDTH' bgcolor='#6097BC' align='center'cellpadding='1px' cellspacing='1px'>");

				while (wb.next()) {
					/*
					 * 1. Hidden Id 2. Genrec Name 3. Brand Name 4. Avl Qty 5. Bal Qty 6. Sanc Qty
					 * Unit ID 7. Unit Name 8. Sanc Qty - Issue Qty 9. Req / Sanc Qty 10. Reorder
					 * Flag 11. Unit Id 12. Rate 13. Batch No 14. Rec Store Avl Qty 15. Total No of
					 * batch 16. Drug Type 17. EDL_CATG
					 */
					strHiddenId = wb.getString(1); // item id^brand id
					// strItemName = wb.getString(2);
					strBrandName = wb.getString(3);
					strAvlQty = wb.getString(4);
					strBalQty = wb.getString(5);
					// System.out.println(strAvlQty);
					// System.out.println(strBalQty);
					if (wb.getString(6) == null) {
						strSancUnitId = "0";
					} else {
						strSancUnitId = wb.getString(6);
					}
					strSancUnitName = wb.getString(7);
					strBalQtyBaseVal = wb.getString(8);

					strReqSancQty = wb.getString(9);

					strCompSancUnit = wb.getString(11); // Adding in Change Request 28-July-2011
					strReceivingStoreAvlQty = wb.getString(14);
					strTotalNoOfBatch = wb.getString(15); // added by shalini on 14th Jan 2015 to provide multiple batch
															// selection on issue desk

					if (strBalQty.equals("0")) {
						strSancUnitName = " ";
					}

					if (Integer.parseInt(strTotalNoOfBatch) == 1) {
						// Item ID ^ ItemBrand Id ^ Batch No ^ StoreID
						vo.setStrSingleItemDtl(strHiddenId.split("\\^")[0] + "^" + strHiddenId.split("\\^")[1] + "^"
								+ wb.getString(13) + "^" + strIssueStoreID + "^" + strItemCategoryNo);
						bo.getSingleBatchItemDtl(vo);
					}
					if (Integer.parseInt(strTotalNoOfBatch) == 0) {
						// Item ID ^ ItemBrand Id ^ Batch No ^ StoreID
						vo.setStrSingleBatchDtlWs(null);
					}

					// Change Color for Re-Order Level
					// System.out.println("Inside Issue Desk Trans HLP:::::"+wb.getString(10));

					if (wb.getString(17).equals("1")) {
						strApplyClass = "Approved";
					} else {
						strApplyClass = "multiPOControl";
					}

					// strBalQty = HisUtil.getAmountWithDecimal(strBalQty, 2); // By Amit Kr Date
					// 23-Feb-2011
					//// System.out.println("strHiddenId-" + strHiddenId);
					//// System.out.println("strItemName-" + strItemName);
					//// System.out.println("strBrandName-" + strBrandName);
					//// System.out.println("strAvlQty-" + strAvlQty);
					//// System.out.println("strBalQty-" + strBalQty);
					//// System.out.println("strSancUnitId-" + strSancUnitId);
					//// System.out.println("strSancUnitName-" + strSancUnitName);
					//// System.out.println("strBalQtyBaseVal-" + strBalQtyBaseVal);
					//// System.out.println("strItemCategory-" + strItemCategoryNo);
					//// System.out.println("strRate-" + strRate);
					//// System.out.println("strRateUnitId-" + strRateUnitId);
					temp = strAvlQty.replace("^", "#").split("#");

					strAvlQty = temp[0];
					strAvlQtyWithUnitId = temp[1];
					strAvlQtyBaseVal = temp[2];
					// System.out.println(strAvlQty+" "+strAvlQtyWithUnitId+" "+strAvlQtyBaseVal);
					vo.setStrSancUnitId(strSancUnitId);
					// Calling BO Method
					bo.getUnitCombo(vo);

					if (vo.getStrMsgType().equals("1")) {
						throw new Exception(vo.getStrMsgString());
					}

					if (vo.getUnitComboWS() != null && vo.getUnitComboWS().size() > 0) {

						strUnitComboValues = hisutil.getOptionValue(vo.getUnitComboWS(), strCompSancUnit, "", true);
						vo.getUnitComboWS().beforeFirst(); // needed bcoz
															// sometimes it
															// gives invalid
															// cursor position
															// when there is
															// value in heap due
															// to loop

					} else {

						strUnitComboValues = "<option value='0'>Select Value</option>";
					}
					if (strBudgetFlg.equals("0")) {
						System.out.println("--- IssueDeskTransHLP -  A ---");

						br.append("<TR>");

						br.append("<TD WIDTH='25%' id='td1" + i + "' CLASS='" + strApplyClass + "'  >");
						br.append(" <input type='hidden' name='strItemDetailsChk' id='strItemDetailsChk" + i
								+ "' value= '" + strHiddenId + "^" + strItemCategoryNo + "^" + strRaisingStoreId
								+ "' /> ");
						br.append(" <input type='hidden' name='flag' id='flag" + i + "' value=" + "0" + " />");

						br.append(" <input type='hidden' name='reOrderFlag' id='reOrderFlag" + i + "' value="
								+ wb.getString(10) + " />");
						br.append(
								" <input type='hidden' name='strReceivingStoreAvlQtyChk' id='strReceivingStoreAvlQtyChk"
										+ i + "' value=" + strReceivingStoreAvlQty + " />");
						br.append(" <input type='hidden' name='strAvlQtyForChk' id='strAvlQtyForChk" + i + "' value="
								+ strAvlQty + " />");

						br.append(
								"<a STYLE='cursor:pointer;cursor:pointer;color:blue' title='Batch Wise Item Details' onClick='showPopUp(this,\""+ i + "\");'>" + strBrandName + "</a></TD>");

						br.append("<td width='5%' id='td16" + i + "' class='multiPOControl'>" + wb.getString(16)
								+ " </td>");
						br.append("<td width='5%' id='td17" + i + "' class='multiPOControl'>" + strReceivingStoreAvlQty
								+ " </td>");
						br.append("<TD WIDTH='5%' id='td2" + i + "' CLASS='multiPOControl'  >" + strAvlQty
								+ "<input type='hidden' name='strAvlQty' id='strAvlQty" + i + "' value='"
								+ strAvlQtyWithUnitId
								+ "' /><input type='hidden' name='strAvlQtyBaseVal' id='strAvlQtyBaseVal" + i
								+ "' value='" + strAvlQtyBaseVal + "' /></TD>");

						br.append("<input type='hidden' name='strBalQty' id='strBalQty" + i + "' value='" + strBalQty
								+ "' /><input type='hidden' name='strSancUnitId' id='strSancUnitId" + i + "' value='"
								+ strSancUnitId
								+ "' /> <input type='hidden' name='strBalQtyBaseVal' id='strBalQtyBaseVal" + i
								+ "' value='" + strBalQtyBaseVal + "' />");

						br.append("<TD WIDTH='10%' id='td3" + i + "' CLASS='multiPOControl'  >" + strReqSancQty
								+ "</TD>");

						br.append("<TD WIDTH='8%' id='td4" + i
								+ "' CLASS='multiPOControl' ><input type='text' autocomplete='off' maxlength='8' onkeypress='return validateData(event,5);' onkeyup='return QtyValidation("
								+ i + ");' name='strIssueQty' id='strIssueQty" + i
								+ "' class='txtFldMin' value='' > </TD>");

						br.append("<input type='hidden' name='strTotalBatch' id='strTotalBatch" + i + "' value='"
								+ strTotalNoOfBatch + "' />");

						br.append("<input type='hidden' name='strTotBatch' id='strTotBatch" + i + "' value='"
								+ strTotalNoOfBatch + "' />");

						if (Integer.parseInt(strTotalNoOfBatch) > 1) {
							System.out.println("--- IssueDeskTransHLP -  B ---");

							br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId" + i
									+ "' value='' />");

							br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId" + i
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
							br.append("<TD WIDTH='9%' id='td9" + i
									+ "' CLASS='multiPOControl'  ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
									+ i + "' value='' />" + "<div name='issueDrugDtl' id='issueDrugDtl" + i + "'></div>"
									+ " <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
									+ i + "\");' TITLE='Click Here For Item Preferences' >auto</TD>");
							br.append("<TD WIDTH='9%' id='td8" + i
									+ "' CLASS='multiPOControl' style=\"text-align:center;\" ><div name='expDrugDtl' id='expDrugDtl"
									+ i + "'></div></TD>");

						} else {
							if (vo.getStrSingleBatchDtlWs() != null && vo.getStrSingleBatchDtlWs().size() > 0) {

								if (vo.getStrSingleBatchDtlWs().next()) {
									System.out.println("--- IssueDeskTransHLP -  C ---");

									/*
									 * MMS_MST.get_item_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEM_ID),
									 * Mms_Mst.get_item_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEMBRAND_ID),
									 * HSTSTR_BATCH_NO, NVL(TO_CHAR(HSTDT_MANUF_DATE , ''DD-Mon-yyyy''),'''') ,
									 * NVL(TO_CHAR(HSTDT_EXPIRY_DATE, ''Mon/yyyy''),'''') , NVL(HSTNUM_RATE,0),
									 * Mms_Mst.get_stock_dtl() AS AVAL_QTY,
									 * MMS_MST.GET_SUPP_DTL(1,'||hosp_code||',HSTNUM_SUPPLIER_ID) as MANUF_NAME,
									 * NVL(HSTNUM_RATE,0)||''/''||Mms_Mst.getUnitName(GNUM_HOSPITAL_CODE,
									 * HSTNUM_RATE_UNITID) AS Rate_WTHUNIT, HSTNUM_PO_NO, HSTNUM_PROGRAMME_ID,
									 * NVL(MMS_MST.GET_PROGRAMME_NAME(1,GNUM_HOSPITAL_CODE,HSTNUM_PROGRAMME_ID),''--
									 * -''), HSTNUM_SUPPLIER_ID
									 */

									br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
											+ i + "' value='" + vo.getStrSingleBatchDtlWs().getString(13) + "' />");
									br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId" + i
											+ "' value='" + vo.getStrSingleBatchDtlWs().getString(11) + "' />");
									br.append("<input type='hidden' name='strTotBatch' id='strTotBatch" + i
											+ "' value='" + strTotalNoOfBatch + "' />");
									br.append("<input type='hidden' name='strStockRate'        id='strStockRate" + i
											+ "' value='" + vo.getStrSingleBatchDtlWs().getString(6) + "' />");
									br.append("<input type='hidden' name='strStockQty'         id='strStockQty" + i
											+ "' value='" + vo.getStrSingleBatchDtlWs().getString(7).split("\\^")[0]
											+ "' />");
									br.append(
											"<input type='hidden' name='strSingleStockRate'        id='strSingleStockRate"
													+ i + "' value='" + vo.getStrSingleBatchDtlWs().getString(9)
													+ "' />");

									br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch" + i
											+ "' value='" + vo.getStrSingleBatchDtlWs().getString(3) + "' />");
									br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry" + i
											+ "' value='" + vo.getStrSingleBatchDtlWs().getString(5) + "' />");
									br.append("<input type='hidden' name='strSingleMfgName'     id='strSingleMfgName"
											+ i + "' value='" + vo.getStrSingleBatchDtlWs().getString(8) + "' />");
									br.append("<input type='hidden' name='strProgrammeName'     id='strProgrammeName"
											+ i + "' value='" + vo.getStrSingleBatchDtlWs().getString(12) + "' />");
									br.append("<TD WIDTH='9%' id='td8" + i
											+ "' CLASS='multiPOControl' style=\"text-align:center;\" >"
											+ vo.getStrSingleBatchDtlWs().getString(3) + "</TD>");
									br.append("<TD WIDTH='9%'  id='td9" + i
											+ "' CLASS='multiPOControl' style=\"text-align:center;\"   >"
											+ ((vo.getStrSingleBatchDtlWs().getString(5) == null
													|| vo.getStrSingleBatchDtlWs().getString(5).equals("")) ? "NA"
															: vo.getStrSingleBatchDtlWs().getString(5))
											+ "</TD>");
								} else {

									System.out.println("--- IssueDeskTransHLP -  D ---");

									br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
											+ i + "' value='' />");
									br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId" + i
											+ "' value='' />");

									br.append("<input type='hidden' name='strTotBatch' id='strTotBatch" + i
											+ "' value='" + strTotalNoOfBatch + "' />");

									br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch" + i
											+ "' value='' />");
									br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry" + i
											+ "' value='' />");
									br.append("<input type='hidden' name='strSingleMfgName'    id='strSingleMfgName" + i
											+ "' value='' />");
									br.append("<input type='hidden' name='strProgrammeName'    id='strProgrammeName" + i
											+ "' value='' />");
									br.append("<input type='hidden' name='strSingleStockRate'  id='strSingleStockRate"
											+ i + "' value='' />");
									br.append("<input type='hidden' name='strStockQty'         id='strStockQty" + i
											+ "' value='' />");
									br.append("<input type='hidden' name='strStockRate'        id='strStockRate" + i
											+ "' value='' />");
									br.append("<TD WIDTH='8%' id='td8" + i
											+ "' CLASS='multiPOControl' style=\"text-align:center;\" >NA</TD>");
									br.append("<TD WIDTH='9%'  id='td9" + i
											+ "' CLASS='multiPOControl' style=\"text-align:center;\" >NA</TD>");
								}
								br.append(
										"<input type='hidden' name='strCheckBatchExists'        id='strCheckBatchExists"
												+ i + "' value='0' />");
								br.append("<input type='hidden' name='stockDtlsId' id='stockDtlsId" + i
										+ "' value='' />");

							} else {
								System.out.println("--- IssueDeskTransHLP -  E ---");

								br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId" + i
										+ "' value='' />");
								br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId" + i
										+ "' value='' />");

								br.append("<input type='hidden' name='strTotBatch' id='strTotBatch" + i + "' value='"
										+ strTotalNoOfBatch + "' />");

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
								br.append("<input type='hidden' name='stockDtlsId' id='stockDtlsId" + i
										+ "' value='' />");
								br.append("<TD WIDTH='9%' id='td8" + i
										+ "' CLASS='multiPOControl' style=\"text-align:center;\" >NA</TD>");
								br.append("<TD WIDTH='9%'  id='td9" + i
										+ "' CLASS='multiPOControl' style=\"text-align:center;\" >NA</TD>");
							}

							br.append(
									"<input type='hidden' disabled='disabled' class='txtFldNormal'  value='0.00' name='finalCostDivId' id='finalCostDivId"
											+ i + "' >");
							br.append("<input type='hidden' name='strFinalCost' id='strFinalCost" + i
									+ "' value='0.00' />");
						}

						System.out.println("--- IssueDeskTransHLP -  F ---");

						br.append("<TD WIDTH='7%' id='td5" + i
								+ "' CLASS='multiPOControl'  ><Select name='strIssueUnitId' onChange='return QtyValidation("
								+ i + ");' id='strIssueUnitId" + i + "' >" + strUnitComboValues + "</select></TD>");

						br.append("<TD WIDTH='10%' id='td6" + i + "' CLASS='multiPOControl'  >"
								+ "<textarea  class='txtFldMin' size = '100' maxlength='500' onkeypress='return validateData(event,9);' name='strItemRemarks' id='strItemRemarks"
								+ i + "' value='' ></textarea></TD>");

						/*
						 * br.append("<TD WIDTH='3%' id='td7" + i +
						 * "' CLASS='multiPOControl'  ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
						 * + i +
						 * "' value='' /> <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
						 * +i+ "\");' TITLE='Click Here For Item Preferences' >auto</TD>");
						 */
						if (strAvlQty.equals("0.00"))
							br.append("<TD WIDTH='10%' id='td8" + i + "' CLASS='multiControl'  >"
									+ "<input type='text' class='txtFldMin' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strBSQuantity' id='strBSQuantity"
									+ i + "' value='" + strReqSancQty.split(" ")[0] + "' ></TD>");
						else
							br.append("<TD WIDTH='10%' id='td8" + i + "' CLASS='multiControl'  >"
									+ "<input type='text' class='txtFldMin' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strBSQuantity' id='strBSQuantity"
									+ i + "' value='' ></TD>");

						br.append("</TR>");
						br.append("</div>");
						i++;

					} else {
						System.out.println("--- IssueDeskTransHLP -  G ---");
						br.append("<TR>");

						br.append("<TD WIDTH='25%' id='td1" + i
								+ "' CLASS='multiPOControl'  style=\"text-align:left;\">");
						br.append(" <input type='hidden' name='strItemDetailsChk' id='strItemDetailsChk" + i
								+ "' value= '" + strHiddenId + "^" + strItemCategoryNo + "^" + strRaisingStoreId
								+ "' /> ");
						br.append(" <input type='hidden' name='flag' id='flag" + i + "' value=" + "0" + " />");
						br.append(" <input type='hidden' name='strAvlQtyForChk' id='strAvlQtyForChk" + i + "' value="
								+ strAvlQty + " />");

						br.append(" <input type='hidden' name='reOrderFlag' id='reOrderFlag" + i + "' value="
								+ wb.getString(10) + " />");
						br.append(strBrandName + "</TD>");
						br.append("<td width='5%' id='td16" + i + "' class='multiPOControl'>" + wb.getString(16)
								+ " </td>");
						br.append("<td width='5%' id='td17" + i + "' class='multiPOControl'>" + strReceivingStoreAvlQty
								+ " </td>");
//						br.append("<a STYLE='cursor:pointer;cursor:pointer;color:blue' title='Batch Wise Item Details' onClick='showPopUp(this,\""
//										+ i + "\");'>" + strBrandName + "</a></TD>");

						br.append("<TD WIDTH='5%' id='td2" + i + "' CLASS='multiPOControl'  >" + strAvlQty + "/"
								+ strReceivingStoreAvlQty + "<input type='hidden' name='strAvlQty' id='strAvlQty" + i
								+ "' value='" + strAvlQtyWithUnitId
								+ "' /><input type='hidden' name='strAvlQtyBaseVal' id='strAvlQtyBaseVal" + i
								+ "' value='" + strAvlQtyBaseVal + "' /></TD>");

						br.append("<input type='hidden' name='strBalQty' id='strBalQty" + i + "' value='" + strBalQty
								+ "' /><input type='hidden' name='strSancUnitId' id='strSancUnitId" + i + "' value='"
								+ strSancUnitId
								+ "' /> <input type='hidden' name='strBalQtyBaseVal' id='strBalQtyBaseVal" + i
								+ "' value='" + strBalQtyBaseVal + "' />");

						br.append("<TD WIDTH='15%' id='td3" + i + "' CLASS='multiPOControl'  >" + strReqSancQty
								+ "</TD>");

						br.append("<TD WIDTH='10%' id='td4" + i
								+ "' CLASS='multiPOControl' ><input type='text' maxlength='8' onkeypress='return validateData(event,5);' onkeyup='return QtyValidation("
								+ i + ");' name='strIssueQty' id='strIssueQty" + i
								+ "' class='txtFldMin' value='' > </TD>");

						br.append("<TD WIDTH='9%' id='td7" + i
								+ "' CLASS='multiPOControl' ><input type='text' maxlength='8' onkeypress='return validateData(event,5);' onblur=' ' autocomplete='off' name='strIssueQty' "
								+ "id='strIssueQty" + i + "' class='txtFldMin' value='' > </TD>");

						br.append("<input type='hidden' name='strTotalBatch' id='strTotalBatch" + i + "' value='"
								+ strTotalNoOfBatch + "' />");

						br.append("<input type='hidden' name='strTotBatch' id='strTotBatch" + i + "' value='"
								+ strTotalNoOfBatch + "' />");

						if (Integer.parseInt(strTotalNoOfBatch) > 1) {
							System.out.println("--- IssueDeskTransHLP -  H---");

							br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId" + i
									+ "' value='' />");
							br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId" + i
									+ "' value='' />");
							br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch" + i
									+ "' value='' />");
							br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry" + i
									+ "' value='' />");
							br.append("<input type='hidden' name='strSingleMfgName'     id='strSingleMfgName" + i
									+ "' value='' />");
							br.append("<input type='hidden' name='strProgrammeName'     id='strProgrammeName" + i
									+ "' value='' />");
							br.append("<input type='hidden' name='strSingleStockRate'        id='strSingleStockRate" + i
									+ "' value='' />");
							br.append("<input type='hidden' name='strStockQty'        id='strStockQty" + i
									+ "' value='' />");
							br.append("<input type='hidden' name='strStockRate'        id='strStockRate" + i
									+ "' value='' />");
							br.append("<input type='hidden' name='strCheckBatchExists'        id='strCheckBatchExists"
									+ i + "' value='1' />");
							br.append("<TD WIDTH='9%' id='td9" + i
									+ "' CLASS='multiPOControl'  ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
									+ i + "' value='' />" + "<div name='issueDrugDtl' id='issueDrugDtl" + i + "'></div>"
									+ " <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
									+ i + "\");' TITLE='Click Here For Item Preferences' >auto</TD>");
							br.append("<TD WIDTH='9%' id='td8" + i
									+ "' CLASS='multiPOControl' style=\"text-align:center;\" ><div name='expDrugDtl' id='expDrugDtl"
									+ i + "'></div></TD>");
						} else {

							if (vo.getStrSingleBatchDtlWs().next()) {
								System.out.println("--- IssueDeskTransHLP -  I ---");

								/*
								 * MMS_MST.get_item_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEM_ID),
								 * Mms_Mst.get_item_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEMBRAND_ID),
								 * HSTSTR_BATCH_NO, NVL(TO_CHAR(HSTDT_MANUF_DATE , ''DD-Mon-yyyy''),'''') ,
								 * NVL(TO_CHAR(HSTDT_EXPIRY_DATE, ''Mon/yyyy''),'''') , NVL(HSTNUM_RATE,0),
								 * Mms_Mst.get_stock_dtl() AS AVAL_QTY,
								 * MMS_MST.GET_SUPP_DTL(1,'||hosp_code||',HSTNUM_SUPPLIER_ID) as MANUF_NAME,
								 * NVL(HSTNUM_RATE,0)||''/''||Mms_Mst.getUnitName(GNUM_HOSPITAL_CODE,
								 * HSTNUM_RATE_UNITID) AS Rate_WTHUNIT, HSTNUM_PO_NO, HSTNUM_PROGRAMME_ID,
								 * NVL(MMS_MST.GET_PROGRAMME_NAME(1,GNUM_HOSPITAL_CODE,HSTNUM_PROGRAMME_ID),''--
								 * -''), HSTNUM_SUPPLIER_ID
								 */

								br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(13) + "' />");
								br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(11) + "' />");
								br.append("<input type='hidden' name='strStockRate'        id='strStockRate" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(6) + "' />");
								br.append("<input type='hidden' name='strStockQty'         id='strStockQty" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(7).split("\\^")[0]
										+ "' />");
								br.append("<input type='hidden' name='strSingleStockRate'        id='strSingleStockRate"
										+ i + "' value='" + vo.getStrSingleBatchDtlWs().getString(9) + "' />");

								br.append("<input type='hidden' name='strTotBatch' id='strTotBatch" + i + "' value='"
										+ strTotalNoOfBatch + "' />");
								br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(3) + "' />");
								br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(5) + "' />");
								br.append("<input type='hidden' name='strSingleMfgName'     id='strSingleMfgName" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(8) + "' />");
								br.append("<input type='hidden' name='strProgrammeName'     id='strProgrammeName" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(12) + "' />");

								br.append("<TD WIDTH='9%' id='td8" + i
										+ "' CLASS='multiPOControl' style=\"text-align:center;\" >"
										+ vo.getStrSingleBatchDtlWs().getString(3) + "</TD>");
								br.append("<TD WIDTH='9%'  id='td9" + i
										+ "' CLASS='multiPOControl' style=\"text-align:center;\"   >"
										+ ((vo.getStrSingleBatchDtlWs().getString(5) == null
												|| vo.getStrSingleBatchDtlWs().getString(5).equals("")) ? "NA"
														: vo.getStrSingleBatchDtlWs().getString(5))
										+ "</TD>");
							} else {
								System.out.println("--- IssueDeskTransHLP -  J ---");

								br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId" + i
										+ "' value='' />");
								br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId" + i
										+ "' value='' />");
								br.append("<input type='hidden' name='strTotBatch' id='strTotBatch" + i + "' value='"
										+ strTotalNoOfBatch + "' />");
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
								br.append("<TD WIDTH='9%' id='td8" + i
										+ "' CLASS='multiPOControl' style=\"text-align:center;\" > </TD>");
								br.append("<TD WIDTH='9%'  id='td9" + i
										+ "' CLASS='multiPOControl' style=\"text-align:center;\" ></TD>");
							}
							br.append("<input type='hidden' name='strCheckBatchExists'        id='strCheckBatchExists"
									+ i + "' value='0' />");
							br.append("<input type='hidden' name='stockDtlsId' id='stockDtlsId" + i + "' value='' />");

						}

						br.append(
								"<input type='hidden' disabled='disabled' class='txtFldNormal'  value='0.00' name='finalCostDivId' id='finalCostDivId"
										+ i + "' >");
						br.append(
								"<input type='hidden' name='strFinalCost' id='strFinalCost" + i + "' value='0.00' />");

						br.append("<TD WIDTH='10%' id='td5" + i
								+ "' CLASS='multiPOControl'  ><Select name='strIssueUnitId' onChange='return QtyValidation("
								+ i + ");' id='strIssueUnitId" + i + "' >" + strUnitComboValues + "</select></TD>");

						/*
						 * br.append("<TD WIDTH='3%' id='td8" + i +
						 * "' CLASS='multiPOControl'  ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
						 * + i +
						 * "' value='' /> <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
						 * + i + "\");' TITLE='Click Here For Item Preferences' >auto</TD>");
						 */

						br.append("<TD WIDTH='10%' id='td7" + i
								+ "' CLASS='multiPOControl'><input type='text' disabled='disabled' class='txtFldNormal'  value='0.00' name='finalCostDivId' id='finalCostDivId"
								+ i + "' ></TD>");
						br.append(
								"<input type='hidden' name='strFinalCost' id='strFinalCost" + i + "' value='0.00' />");

						br.append("<TD WIDTH='10%' id='td6" + i + "' CLASS='multiControl'  >"
								+ "<input type='text' class='txtFldNormal' maxlength='100' onkeypress='return validateData(event,9);' name='strItemRemarks' id='strItemRemarks"
								+ i + "' value='' ></TD>");
						br.append("<TD WIDTH='10%' id='td8" + i + "' CLASS='multiControl'  >"
								+ "<input type='text' class='txtFldMin' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strBSQuantity' id='strBSQuantity"
								+ i + "' value='' ></TD>");

						br.append("</TR>");
						br.append("</div>");
						i++;
					}

				}

				br.append("</table> ");
			} else {
				br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<TR>");
				br.append("<TD  CLASS='multiPOControl' colspan='8'>" + "No Record Found" + "</TD>");
				br.append("</TR>");
				br.append("</table> ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}
		//// System.out.println("O/P String:::::"+br.toString());
		return br.toString();
	}

	public static String getItemDetails_Item(String strItemCategoryNo, String strHospitalCode, WebRowSet wb,
			String strRaisingStoreId, String strBudgetFlg, String strIssueStoreID) throws SQLException {
		StringBuffer br = new StringBuffer();

		IssueDeskTransBO bo = null;
		IssueDeskTransVO vo = null;
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
		int i = 0;

		try {
			hisutil = new HisUtil("mms", "IssueDeskTransHLP");
			bo = new IssueDeskTransBO();
			vo = new IssueDeskTransVO();

			vo.setStrHospitalCode(strHospitalCode);
			if (wb.size() != 0) {

				br.append(
						"<table class='TABLEWIDTH' bgcolor='#6097BC' align='center'cellpadding='1px' cellspacing='1px'>");

				while (wb.next()) {
					/*
					 * 1. Hidden Id 2. Genrec Name 3. Brand Name 4. Avl Qty 5. Bal Qty 6. Sanc Qty
					 * Unit ID 7. Unit Name 8. Sanc Qty - Issue Qty 9. Req / Sanc Qty 10. Reorder
					 * Flag 11. Unit Id 12. Rate 13. Batch No 14. Rec Store Avl Qty 15. Total No of
					 * batch
					 * 
					 */
					strHiddenId = wb.getString(1); // item id^brand id
					// strItemName = wb.getString(2);
					strBrandName = wb.getString(3);
					strAvlQty = wb.getString(4);
					strBalQty = wb.getString(5);
					// System.out.println(strAvlQty);
					// System.out.println(strBalQty);
					if (wb.getString(6) == null) {
						strSancUnitId = "0";
					} else {
						strSancUnitId = wb.getString(6);
					}
					strSancUnitName = wb.getString(7);
					strBalQtyBaseVal = wb.getString(8);

					strReqSancQty = wb.getString(9);

					strCompSancUnit = wb.getString(11); // Adding in Change Request 28-July-2011
					strReceivingStoreAvlQty = wb.getString(14);
					strTotalNoOfBatch = wb.getString(15); // added by shalini on 14th Jan 2015 to provide multiple batch
															// selection on issue desk

					if (strBalQty.equals("0")) {
						strSancUnitName = " ";
					}

					if (Integer.parseInt(strTotalNoOfBatch) == 1) { // Item ID ^ ItemBrand Id ^ Batch No ^ StoreID
						vo.setStrSingleItemDtl(strHiddenId.split("\\^")[0] + "^" + strHiddenId.split("\\^")[1] + "^"
								+ wb.getString(13) + "^" + strIssueStoreID + "^" + strItemCategoryNo);
						bo.getSingleBatchItemDtl(vo);
					}
					if (Integer.parseInt(strTotalNoOfBatch) == 0) { // Item ID ^ ItemBrand Id ^ Batch No ^ StoreID
						vo.setStrSingleBatchDtlWs(null);
					}

					/*
					 * Change Color for Re-Order Level
					 * //System.out.println("Inside Issue Desk Trans HLP:::::"+wb.getString(10));
					 * 
					 * if(wb.getString(10).equals("0")) { strApplyClass = "Approved"; } else {
					 * strApplyClass = "NotApproved"; }
					 */

					// strBalQty = HisUtil.getAmountWithDecimal(strBalQty, 2); // By Amit Kr Date
					// 23-Feb-2011
					//// System.out.println("strHiddenId-" + strHiddenId);
					//// System.out.println("strItemName-" + strItemName);
					//// System.out.println("strBrandName-" + strBrandName);
					//// System.out.println("strAvlQty-" + strAvlQty);
					//// System.out.println("strBalQty-" + strBalQty);
					//// System.out.println("strSancUnitId-" + strSancUnitId);
					//// System.out.println("strSancUnitName-" + strSancUnitName);
					//// System.out.println("strBalQtyBaseVal-" + strBalQtyBaseVal);
					//// System.out.println("strItemCategory-" + strItemCategoryNo);
					//// System.out.println("strRate-" + strRate);
					//// System.out.println("strRateUnitId-" + strRateUnitId);
					temp = strAvlQty.replace("^", "#").split("#");

					strAvlQty = temp[0];
					strAvlQtyWithUnitId = temp[1];
					strAvlQtyBaseVal = temp[2];
					// System.out.println(strAvlQty+" "+strAvlQtyWithUnitId+" "+strAvlQtyBaseVal);
					vo.setStrSancUnitId(strSancUnitId);
					// Calling BO Method
					bo.getUnitCombo(vo);

					if (vo.getStrMsgType().equals("1")) {
						throw new Exception(vo.getStrMsgString());
					}

					if (vo.getUnitComboWS() != null && vo.getUnitComboWS().size() > 0) {

						strUnitComboValues = hisutil.getOptionValue(vo.getUnitComboWS(), strCompSancUnit, "", true);
						vo.getUnitComboWS().beforeFirst(); // needed bcoz
															// sometimes it
															// gives invalid
															// cursor position
															// when there is
															// value in heap due
															// to loop

					} else {

						strUnitComboValues = "<option value='0'>Select Value</option>";
					}
					if (strBudgetFlg.equals("0")) {
						br.append("<TR>");

						//// System.out.println("strStoreId-" + strRaisingStoreId);
						/*
						 * br.append("<TR>"); br .append(" <input type='hidden' name='strItemDetailsChk'
						 * id='strItemDetailsChk" + i + "' onclick='ClickCheckBox(this,\"" + i +
						 * "\");' value= '" + strHiddenId + "^" + strItemCategoryNo + "^" + strStoreId +
						 * "' /> "); br.append(" <input type='hidden' name='flag' id='flag"+i+"'
						 * value=" + "0" + " >");
						 */

						br.append("<TD WIDTH='30%' id='td1" + i + "' CLASS='multiPOControl'  >");
						br.append(" <input type='hidden' name='strItemDetailsChk' id='strItemDetailsChk" + i
								+ "' value= '" + strHiddenId + "^" + strItemCategoryNo + "^" + strRaisingStoreId
								+ "' /> ");
						br.append(" <input type='hidden' name='flag' id='flag" + i + "' value=" + "0" + " />");

						br.append(" <input type='hidden' name='reOrderFlag' id='reOrderFlag" + i + "' value="
								+ wb.getString(10) + " />");
						br.append(" <input type='hidden' name='strAvlQtyForChk' id='strAvlQtyForChk" + i + "' value="
								+ strAvlQty + " />");

						br.append(
								"<a STYLE='cursor:pointer;cursor:pointer;color:blue' title='Batch Wise Item Details' onClick='showPopUp(this,\""
										+ i + "\");'>" + strBrandName + "</a></TD>");

						br.append("<TD WIDTH='10%' id='td2" + i + "' CLASS='multiPOControl'  >" + strAvlQty
								+ "<input type='hidden' name='strAvlQty' id='strAvlQty" + i + "' value='"
								+ strAvlQtyWithUnitId
								+ "' /><input type='hidden' name='strAvlQtyBaseVal' id='strAvlQtyBaseVal" + i
								+ "' value='" + strAvlQtyBaseVal + "' /></TD>");

						br.append("<input type='hidden' name='strBalQty' id='strBalQty" + i + "' value='" + strBalQty
								+ "' /><input type='hidden' name='strSancUnitId' id='strSancUnitId" + i + "' value='"
								+ strSancUnitId
								+ "' /> <input type='hidden' name='strBalQtyBaseVal' id='strBalQtyBaseVal" + i
								+ "' value='" + strBalQtyBaseVal + "' />");

						br.append("<TD WIDTH='10%' id='td3" + i + "' CLASS='multiPOControl'  >" + strReqSancQty
								+ "</TD>");

						br.append("<TD WIDTH='8%' id='td4" + i
								+ "' CLASS='multiPOControl' ><input type='text' autocomplete='off' maxlength='8' onkeypress='return validateData(event,5);' onkeyup='return QtyValidation("
								+ i + ");' name='strIssueQty' id='strIssueQty" + i
								+ "' class='txtFldMin' value='' > </TD>");

						br.append("<input type='hidden' name='strTotalBatch' id='strTotalBatch" + i + "' value='"
								+ strTotalNoOfBatch + "' />");

						br.append("<input type='hidden' name='strTotBatch' id='strTotBatch" + i + "' value='"
								+ strTotalNoOfBatch + "' />");

						if (Integer.parseInt(strTotalNoOfBatch) > 1) {
							br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId" + i
									+ "' value='' />");

							br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId" + i
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
							br.append("<input type='hidden' name='strFinalCost' id='strFinalCost" + i
									+ "' value='0.00' />");
							br.append("<TD WIDTH='9%' id='td9" + i
									+ "' CLASS='multiPOControl'  ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
									+ i + "' value='' />" + "<div name='issueDrugDtl' id='issueDrugDtl" + i + "'></div>"
									+ " <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
									+ i + "\");' TITLE='Click Here For Item Preferences' >auto</TD>");
							br.append("<TD WIDTH='9%' id='td8" + i
									+ "' CLASS='multiPOControl' style=\"text-align:center;\" ><div name='expDrugDtl' id='expDrugDtl"
									+ i + "'></div></TD>");

						} else {
							if (vo.getStrSingleBatchDtlWs() != null && vo.getStrSingleBatchDtlWs().size() > 0) {

								if (vo.getStrSingleBatchDtlWs().next()) {
									/*
									 * MMS_MST.get_item_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEM_ID),
									 * Mms_Mst.get_item_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEMBRAND_ID),
									 * HSTSTR_BATCH_NO, NVL(TO_CHAR(HSTDT_MANUF_DATE , ''DD-Mon-yyyy''),'''') ,
									 * NVL(TO_CHAR(HSTDT_EXPIRY_DATE, ''Mon/yyyy''),'''') , NVL(HSTNUM_RATE,0),
									 * Mms_Mst.get_stock_dtl() AS AVAL_QTY,
									 * MMS_MST.GET_SUPP_DTL(1,'||hosp_code||',HSTNUM_SUPPLIER_ID) as MANUF_NAME,
									 * NVL(HSTNUM_RATE,0)||''/''||Mms_Mst.getUnitName(GNUM_HOSPITAL_CODE,
									 * HSTNUM_RATE_UNITID) AS Rate_WTHUNIT, HSTNUM_PO_NO, HSTNUM_PROGRAMME_ID,
									 * NVL(MMS_MST.GET_PROGRAMME_NAME(1,GNUM_HOSPITAL_CODE,HSTNUM_PROGRAMME_ID),''--
									 * -''), HSTNUM_SUPPLIER_ID
									 */

									br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
											+ i + "' value='" + vo.getStrSingleBatchDtlWs().getString(13) + "' />");
									br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId" + i
											+ "' value='" + vo.getStrSingleBatchDtlWs().getString(11) + "' />");
									br.append("<input type='hidden' name='strTotBatch' id='strTotBatch" + i
											+ "' value='" + strTotalNoOfBatch + "' />");
									br.append("<input type='hidden' name='strStockRate'        id='strStockRate" + i
											+ "' value='" + vo.getStrSingleBatchDtlWs().getString(6) + "' />");
									br.append("<input type='hidden' name='strStockQty'         id='strStockQty" + i
											+ "' value='" + vo.getStrSingleBatchDtlWs().getString(7).split("\\^")[0]
											+ "' />");
									br.append(
											"<input type='hidden' name='strSingleStockRate'        id='strSingleStockRate"
													+ i + "' value='" + vo.getStrSingleBatchDtlWs().getString(9)
													+ "' />");

									br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch" + i
											+ "' value='" + vo.getStrSingleBatchDtlWs().getString(3) + "' />");
									br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry" + i
											+ "' value='" + vo.getStrSingleBatchDtlWs().getString(5) + "' />");
									br.append("<input type='hidden' name='strSingleMfgName'     id='strSingleMfgName"
											+ i + "' value='" + vo.getStrSingleBatchDtlWs().getString(8) + "' />");
									br.append("<input type='hidden' name='strProgrammeName'     id='strProgrammeName"
											+ i + "' value='" + vo.getStrSingleBatchDtlWs().getString(12) + "' />");
									br.append("<TD WIDTH='9%' id='td8" + i
											+ "' CLASS='multiPOControl' style=\"text-align:center;\" >"
											+ vo.getStrSingleBatchDtlWs().getString(3) + "</TD>");
									br.append("<TD WIDTH='9%'  id='td9" + i
											+ "' CLASS='multiPOControl' style=\"text-align:center;\"   >"
											+ ((vo.getStrSingleBatchDtlWs().getString(5) == null
													|| vo.getStrSingleBatchDtlWs().getString(5).equals("")) ? "NA"
															: vo.getStrSingleBatchDtlWs().getString(5))
											+ "</TD>");
								} else {

									br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
											+ i + "' value='' />");
									br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId" + i
											+ "' value='' />");

									br.append("<input type='hidden' name='strTotBatch' id='strTotBatch" + i
											+ "' value='" + strTotalNoOfBatch + "' />");

									br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch" + i
											+ "' value='' />");
									br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry" + i
											+ "' value='' />");
									br.append("<input type='hidden' name='strSingleMfgName'    id='strSingleMfgName" + i
											+ "' value='' />");
									br.append("<input type='hidden' name='strProgrammeName'    id='strProgrammeName" + i
											+ "' value='' />");
									br.append("<input type='hidden' name='strSingleStockRate'  id='strSingleStockRate"
											+ i + "' value='' />");
									br.append("<input type='hidden' name='strStockQty'         id='strStockQty" + i
											+ "' value='' />");
									br.append("<input type='hidden' name='strStockRate'        id='strStockRate" + i
											+ "' value='' />");
									br.append("<TD WIDTH='8%' id='td8" + i
											+ "' CLASS='multiPOControl' style=\"text-align:center;\" > </TD>");
									br.append("<TD WIDTH='9%'  id='td9" + i
											+ "' CLASS='multiPOControl' style=\"text-align:center;\" ></TD>");
								}
								br.append(
										"<input type='hidden' name='strCheckBatchExists'        id='strCheckBatchExists"
												+ i + "' value='0' />");
								br.append("<input type='hidden' name='stockDtlsId' id='stockDtlsId" + i
										+ "' value='' />");

							} else {

								br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId" + i
										+ "' value='' />");
								br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId" + i
										+ "' value='' />");

								br.append("<input type='hidden' name='strTotBatch' id='strTotBatch" + i + "' value='"
										+ strTotalNoOfBatch + "' />");

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
								br.append("<input type='hidden' name='stockDtlsId' id='stockDtlsId" + i
										+ "' value='' />");
								br.append("<TD WIDTH='9%' id='td8" + i
										+ "' CLASS='multiPOControl' style=\"text-align:center;\" >NA</TD>");
								br.append("<TD WIDTH='9%'  id='td9" + i
										+ "' CLASS='multiPOControl' style=\"text-align:center;\" >NA</TD>");
							}

							br.append(
									"<input type='hidden' disabled='disabled' class='txtFldNormal'  value='0.00' name='finalCostDivId' id='finalCostDivId"
											+ i + "' >");
							br.append("<input type='hidden' name='strFinalCost' id='strFinalCost" + i
									+ "' value='0.00' />");
						}
						br.append("<TD WIDTH='7%' id='td5" + i
								+ "' CLASS='multiPOControl'  ><Select name='strIssueUnitId' onChange='return QtyValidation("
								+ i + ");' id='strIssueUnitId" + i + "' >" + strUnitComboValues + "</select></TD>");

						br.append("<TD WIDTH='10%' id='td6" + i + "' CLASS='multiPOControl'  >"
								+ "<textarea  class='txtFldMin' size = '100' maxlength='500' onkeypress='return validateData(event,9);' name='strItemRemarks' id='strItemRemarks"
								+ i + "' value='' ></textarea></TD>");

						/*
						 * br.append("<TD WIDTH='3%' id='td7" + i +
						 * "' CLASS='multiPOControl'  ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
						 * + i +
						 * "' value='' /> <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
						 * +i+ "\");' TITLE='Click Here For Item Preferences' >auto</TD>");
						 */
						if (strAvlQty.equals("0.00"))
							br.append("<TD WIDTH='10%' id='td8" + i + "' CLASS='multiControl'  >"
									+ "<input type='text' class='txtFldMin' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strBSQuantity' id='strBSQuantity"
									+ i + "' value='" + strReqSancQty.split(" ")[0] + "' ></TD>");
						else
							br.append("<TD WIDTH='10%' id='td8" + i + "' CLASS='multiControl'  >"
									+ "<input type='text' class='txtFldMin' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strBSQuantity' id='strBSQuantity"
									+ i + "' value='' ></TD>");

						br.append("</TR>");
						br.append("</div>");
						i++;

					} else {
						br.append("<TR>");

						//// System.out.println("strStoreId-" + strRaisingStoreId);
						/*
						 * br.append("<TR>"); br .append(" <input type='hidden' name='strItemDetailsChk'
						 * id='strItemDetailsChk" + i + "' onclick='ClickCheckBox(this,\"" + i +
						 * "\");' value= '" + strHiddenId + "^" + strItemCategoryNo + "^" + strStoreId +
						 * "' /> "); br.append(" <input type='hidden' name='flag' id='flag"+i+"'
						 * value=" + "0" + " >");
						 */

						br.append("<TD WIDTH='28%' id='td1" + i
								+ "' CLASS='multiPOControl'  style=\"text-align:left;\">");
						br.append(" <input type='hidden' name='strItemDetailsChk' id='strItemDetailsChk" + i
								+ "' value= '" + strHiddenId + "^" + strItemCategoryNo + "^" + strRaisingStoreId
								+ "' /> ");
						br.append(" <input type='hidden' name='flag' id='flag" + i + "' value=" + "0" + " />");
						br.append(" <input type='hidden' name='strAvlQtyForChk' id='strAvlQtyForChk" + i + "' value="
								+ strAvlQty + " />");

						br.append(" <input type='hidden' name='reOrderFlag' id='reOrderFlag" + i + "' value="
								+ wb.getString(10) + " />");
						br.append(strBrandName + "</TD>");

//						br.append("<a STYLE='cursor:pointer;cursor:pointer;color:blue' title='Batch Wise Item Details' onClick='showPopUp(this,\""
//										+ i + "\");'>" + strBrandName + "</a></TD>");

						br.append("<TD WIDTH='13%' id='td2" + i + "' CLASS='multiPOControl'  >" + strAvlQty + "/"
								+ strReceivingStoreAvlQty + "<input type='hidden' name='strAvlQty' id='strAvlQty" + i
								+ "' value='" + strAvlQtyWithUnitId
								+ "' /><input type='hidden' name='strAvlQtyBaseVal' id='strAvlQtyBaseVal" + i
								+ "' value='" + strAvlQtyBaseVal + "' /></TD>");

						br.append("<input type='hidden' name='strBalQty' id='strBalQty" + i + "' value='" + strBalQty
								+ "' /><input type='hidden' name='strSancUnitId' id='strSancUnitId" + i + "' value='"
								+ strSancUnitId
								+ "' /> <input type='hidden' name='strBalQtyBaseVal' id='strBalQtyBaseVal" + i
								+ "' value='" + strBalQtyBaseVal + "' />");

						br.append("<TD WIDTH='15%' id='td3" + i + "' CLASS='multiPOControl'  >" + strReqSancQty
								+ "</TD>");

						br.append("<TD WIDTH='10%' id='td4" + i
								+ "' CLASS='multiPOControl' ><input type='text' maxlength='8' onkeypress='return validateData(event,5);' onkeyup='return QtyValidation("
								+ i + ");' name='strIssueQty' id='strIssueQty" + i
								+ "' class='txtFldMin' value='' > </TD>");

						br.append("<TD WIDTH='9%' id='td7" + i
								+ "' CLASS='multiPOControl' ><input type='text' maxlength='8' onkeypress='return validateData(event,5);' onblur=' ' autocomplete='off' name='strIssueQty' "
								+ "id='strIssueQty" + i + "' class='txtFldMin' value='' > </TD>");

						br.append("<input type='hidden' name='strTotalBatch' id='strTotalBatch" + i + "' value='"
								+ strTotalNoOfBatch + "' />");

						br.append("<input type='hidden' name='strTotBatch' id='strTotBatch" + i + "' value='"
								+ strTotalNoOfBatch + "' />");

						if (Integer.parseInt(strTotalNoOfBatch) > 1) {
							br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId" + i
									+ "' value='' />");
							br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId" + i
									+ "' value='' />");
							br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch" + i
									+ "' value='' />");
							br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry" + i
									+ "' value='' />");
							br.append("<input type='hidden' name='strSingleMfgName'     id='strSingleMfgName" + i
									+ "' value='' />");
							br.append("<input type='hidden' name='strProgrammeName'     id='strProgrammeName" + i
									+ "' value='' />");
							br.append("<input type='hidden' name='strSingleStockRate'        id='strSingleStockRate" + i
									+ "' value='' />");
							br.append("<input type='hidden' name='strStockQty'        id='strStockQty" + i
									+ "' value='' />");
							br.append("<input type='hidden' name='strStockRate'        id='strStockRate" + i
									+ "' value='' />");
							br.append("<input type='hidden' name='strCheckBatchExists'        id='strCheckBatchExists"
									+ i + "' value='1' />");
							br.append("<TD WIDTH='9%' id='td9" + i
									+ "' CLASS='multiPOControl'  ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
									+ i + "' value='' />" + "<div name='issueDrugDtl' id='issueDrugDtl" + i + "'></div>"
									+ " <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
									+ i + "\");' TITLE='Click Here For Item Preferences' >auto</TD>");
							br.append("<TD WIDTH='9%' id='td8" + i
									+ "' CLASS='multiPOControl' style=\"text-align:center;\" ><div name='expDrugDtl' id='expDrugDtl"
									+ i + "'></div></TD>");
						} else {

							if (vo.getStrSingleBatchDtlWs().next()) {

								/*
								 * MMS_MST.get_item_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEM_ID),
								 * Mms_Mst.get_item_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEMBRAND_ID),
								 * HSTSTR_BATCH_NO, NVL(TO_CHAR(HSTDT_MANUF_DATE , ''DD-Mon-yyyy''),'''') ,
								 * NVL(TO_CHAR(HSTDT_EXPIRY_DATE, ''Mon/yyyy''),'''') , NVL(HSTNUM_RATE,0),
								 * Mms_Mst.get_stock_dtl() AS AVAL_QTY,
								 * MMS_MST.GET_SUPP_DTL(1,'||hosp_code||',HSTNUM_SUPPLIER_ID) as MANUF_NAME,
								 * NVL(HSTNUM_RATE,0)||''/''||Mms_Mst.getUnitName(GNUM_HOSPITAL_CODE,
								 * HSTNUM_RATE_UNITID) AS Rate_WTHUNIT, HSTNUM_PO_NO, HSTNUM_PROGRAMME_ID,
								 * NVL(MMS_MST.GET_PROGRAMME_NAME(1,GNUM_HOSPITAL_CODE,HSTNUM_PROGRAMME_ID),''--
								 * -''), HSTNUM_SUPPLIER_ID
								 */

								br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(13) + "' />");
								br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(11) + "' />");
								br.append("<input type='hidden' name='strStockRate'        id='strStockRate" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(6) + "' />");
								br.append("<input type='hidden' name='strStockQty'         id='strStockQty" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(7).split("\\^")[0]
										+ "' />");
								br.append("<input type='hidden' name='strSingleStockRate'        id='strSingleStockRate"
										+ i + "' value='" + vo.getStrSingleBatchDtlWs().getString(9) + "' />");

								br.append("<input type='hidden' name='strTotBatch' id='strTotBatch" + i + "' value='"
										+ strTotalNoOfBatch + "' />");
								br.append("<input type='hidden' name='strSingleBatch'      id='strSingleBatch" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(3) + "' />");
								br.append("<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(5) + "' />");
								br.append("<input type='hidden' name='strSingleMfgName'     id='strSingleMfgName" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(8) + "' />");
								br.append("<input type='hidden' name='strProgrammeName'     id='strProgrammeName" + i
										+ "' value='" + vo.getStrSingleBatchDtlWs().getString(12) + "' />");

								br.append("<TD WIDTH='9%' id='td8" + i
										+ "' CLASS='multiPOControl' style=\"text-align:center;\" >"
										+ vo.getStrSingleBatchDtlWs().getString(3) + "</TD>");
								br.append("<TD WIDTH='9%'  id='td9" + i
										+ "' CLASS='multiPOControl' style=\"text-align:center;\"   >"
										+ ((vo.getStrSingleBatchDtlWs().getString(5) == null
												|| vo.getStrSingleBatchDtlWs().getString(5).equals("")) ? "NA"
														: vo.getStrSingleBatchDtlWs().getString(5))
										+ "</TD>");
							} else {
								br.append("<input type='hidden' name='strSingleManufId'      id='strSingleManufId" + i
										+ "' value='' />");
								br.append("<input type='hidden' name='strSingleProgId'      id='strSingleProgId" + i
										+ "' value='' />");
								br.append("<input type='hidden' name='strTotBatch' id='strTotBatch" + i + "' value='"
										+ strTotalNoOfBatch + "' />");
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
								br.append("<TD WIDTH='9%' id='td8" + i
										+ "' CLASS='multiPOControl' style=\"text-align:center;\" > </TD>");
								br.append("<TD WIDTH='9%'  id='td9" + i
										+ "' CLASS='multiPOControl' style=\"text-align:center;\" ></TD>");
							}
							br.append("<input type='hidden' name='strCheckBatchExists'        id='strCheckBatchExists"
									+ i + "' value='0' />");
							br.append("<input type='hidden' name='stockDtlsId' id='stockDtlsId" + i + "' value='' />");

						}

						br.append(
								"<input type='hidden' disabled='disabled' class='txtFldNormal'  value='0.00' name='finalCostDivId' id='finalCostDivId"
										+ i + "' >");
						br.append(
								"<input type='hidden' name='strFinalCost' id='strFinalCost" + i + "' value='0.00' />");

						br.append("<TD WIDTH='10%' id='td5" + i
								+ "' CLASS='multiPOControl'  ><Select name='strIssueUnitId' onChange='return QtyValidation("
								+ i + ");' id='strIssueUnitId" + i + "' >" + strUnitComboValues + "</select></TD>");

						/*
						 * br.append("<TD WIDTH='3%' id='td8" + i +
						 * "' CLASS='multiPOControl'  ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
						 * + i +
						 * "' value='' /> <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
						 * + i + "\");' TITLE='Click Here For Item Preferences' >auto</TD>");
						 */

						br.append("<TD WIDTH='10%' id='td7" + i
								+ "' CLASS='multiPOControl'><input type='text' disabled='disabled' class='txtFldNormal'  value='0.00' name='finalCostDivId' id='finalCostDivId"
								+ i + "' ></TD>");
						br.append(
								"<input type='hidden' name='strFinalCost' id='strFinalCost" + i + "' value='0.00' />");

						br.append("<TD WIDTH='10%' id='td6" + i + "' CLASS='multiControl'  >"
								+ "<input type='text' class='txtFldNormal' maxlength='100' onkeypress='return validateData(event,9);' name='strItemRemarks' id='strItemRemarks"
								+ i + "' value='' ></TD>");
						br.append("<TD WIDTH='10%' id='td8" + i + "' CLASS='multiControl'  >"
								+ "<input type='text' class='txtFldMin' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strBSQuantity' id='strBSQuantity"
								+ i + "' value='' ></TD>");

						br.append("</TR>");
						br.append("</div>");
						i++;
					}

				}

				br.append("</table> ");
			} else {
				br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<TR>");
				br.append("<TD  CLASS='multiPOControl' colspan='8'>" + "No Record Found" + "</TD>");
				br.append("</TR>");
				br.append("</table> ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}
		//// System.out.println("O/P String:::::"+br.toString());
		return br.toString();
	}

	public static String getItemDetails(String strItemCategoryNo, String strHospitalCode, WebRowSet wb,
			String strRaisingStoreId, String strBudgetFlg) throws SQLException {
		StringBuffer br = new StringBuffer();

		IssueDeskTransBO bo = null;
		IssueDeskTransVO vo = null;
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

		int i = 0;

		try {
			hisutil = new HisUtil("mms", "IssueDeskTransHLP");
			bo = new IssueDeskTransBO();
			vo = new IssueDeskTransVO();

			vo.setStrHospitalCode(strHospitalCode);
			if (wb.size() != 0) {

				br.append(
						"<table class='TABLEWIDTH' bgcolor='#6097BC' align='center'cellpadding='1px' cellspacing='1px'>");

				while (wb.next()) {
					/*
					 * 1. Hidden Id 2. Genrec Name 3. Brand Name 4. Avl Qty 5. Bal Qty 6. Sanc Qty
					 * Unit ID 7. Unit Name 8. Sanc Qty - Issue Qty 9. Req / Sanc Qty 10. Reorder
					 * Flag 11. Unit Id 12. Rate 13. Batch No 14. Rec Store Avl Qty
					 * 
					 */
					strHiddenId = wb.getString(1); // item id^brand id
					// strItemName = wb.getString(2);
					strBrandName = wb.getString(3);
					strAvlQty = wb.getString(4);
					strBalQty = wb.getString(5);
					// System.out.println(strAvlQty);
					// System.out.println(strBalQty);
					if (wb.getString(6) == null) {
						strSancUnitId = "0";
					} else {
						strSancUnitId = wb.getString(6);
					}
					strSancUnitName = wb.getString(7);
					strBalQtyBaseVal = wb.getString(8);

					strReqSancQty = wb.getString(9);

					strCompSancUnit = wb.getString(11); // Adding in Change Request 28-July-2011
					strReceivingStoreAvlQty = wb.getString(14);

					if (strBalQty.equals("0")) {
						strSancUnitName = " ";
					}

					/*
					 * Change Color for Re-Order Level
					 * //System.out.println("Inside Issue Desk Trans HLP:::::"+wb.getString(10));
					 * 
					 * if(wb.getString(10).equals("0")) { strApplyClass = "Approved"; } else {
					 * strApplyClass = "NotApproved"; }
					 */

					// strBalQty = HisUtil.getAmountWithDecimal(strBalQty, 2); // By Amit Kr Date
					// 23-Feb-2011
					//// System.out.println("strHiddenId-" + strHiddenId);
					//// System.out.println("strItemName-" + strItemName);
					//// System.out.println("strBrandName-" + strBrandName);
					//// System.out.println("strAvlQty-" + strAvlQty);
					//// System.out.println("strBalQty-" + strBalQty);
					//// System.out.println("strSancUnitId-" + strSancUnitId);
					//// System.out.println("strSancUnitName-" + strSancUnitName);
					//// System.out.println("strBalQtyBaseVal-" + strBalQtyBaseVal);
					//// System.out.println("strItemCategory-" + strItemCategoryNo);
					//// System.out.println("strRate-" + strRate);
					//// System.out.println("strRateUnitId-" + strRateUnitId);
					temp = strAvlQty.replace("^", "#").split("#");

					strAvlQty = temp[0];
					strAvlQtyWithUnitId = temp[1];
					strAvlQtyBaseVal = temp[2];
					// System.out.println(strAvlQty+" "+strAvlQtyWithUnitId+" "+strAvlQtyBaseVal);
					vo.setStrSancUnitId(strSancUnitId);
					// Calling BO Method
					bo.getUnitCombo(vo);

					if (vo.getStrMsgType().equals("1")) {
						throw new Exception(vo.getStrMsgString());
					}

					if (vo.getUnitComboWS() != null && vo.getUnitComboWS().size() > 0) {

						strUnitComboValues = hisutil.getOptionValue(vo.getUnitComboWS(), strCompSancUnit, "", true);
						vo.getUnitComboWS().beforeFirst(); // needed bcoz
															// sometimes it
															// gives invalid
															// cursor position
															// when there is
															// value in heap due
															// to loop

					} else {

						strUnitComboValues = "<option value='0'>Select Value</option>";
					}
					if (strBudgetFlg.equals("0")) {
						br.append("<TR>");

						//// System.out.println("strStoreId-" + strRaisingStoreId);
						/*
						 * br.append("<TR>"); br .append(" <input type='hidden' name='strItemDetailsChk'
						 * id='strItemDetailsChk" + i + "' onclick='ClickCheckBox(this,\"" + i +
						 * "\");' value= '" + strHiddenId + "^" + strItemCategoryNo + "^" + strStoreId +
						 * "' /> "); br.append(" <input type='hidden' name='flag' id='flag"+i+"'
						 * value=" + "0" + " >");
						 */

						br.append("<TD WIDTH='32%' id='td1" + i + "' CLASS='multiPOControl'  >");
						br.append(" <input type='hidden' name='strItemDetailsChk' id='strItemDetailsChk" + i
								+ "' value= '" + strHiddenId + "^" + strItemCategoryNo + "^" + strRaisingStoreId
								+ "' /> ");
						br.append(" <input type='hidden' name='flag' id='flag" + i + "' value=" + "0" + " />");

						br.append(" <input type='hidden' name='reOrderFlag' id='reOrderFlag" + i + "' value="
								+ wb.getString(10) + " />");
						br.append(" <input type='hidden' name='strAvlQtyForChk' id='strAvlQtyForChk" + i + "' value="
								+ strAvlQty + " />");

						br.append(
								"<a STYLE='cursor:pointer;cursor:pointer;color:blue' title='Batch Wise Item Details' onClick='showPopUp(this,\""
										+ i + "\");'>" + strBrandName + "</a></TD>");

						br.append("<td width='7%' id='td17" + i + "' class='multiPOControl'>" + strReceivingStoreAvlQty
								+ " </td>");

						br.append("<TD WIDTH='7%' id='td2" + i + "' CLASS='multiPOControl'  >" + strAvlQty
								+ "<input type='hidden' name='strAvlQty' id='strAvlQty" + i + "' value='"
								+ strAvlQtyWithUnitId
								+ "' /><input type='hidden' name='strAvlQtyBaseVal' id='strAvlQtyBaseVal" + i
								+ "' value='" + strAvlQtyBaseVal + "' /></TD>");

						br.append("<input type='hidden' name='strBalQty' id='strBalQty" + i + "' value='" + strBalQty
								+ "' /><input type='hidden' name='strSancUnitId' id='strSancUnitId" + i + "' value='"
								+ strSancUnitId
								+ "' /> <input type='hidden' name='strBalQtyBaseVal' id='strBalQtyBaseVal" + i
								+ "' value='" + strBalQtyBaseVal + "' />");

						br.append("<TD WIDTH='10%' id='td3" + i + "' CLASS='multiPOControl'  >" + strReqSancQty
								+ "</TD>");

						br.append("<TD WIDTH='10%' id='td4" + i
								+ "' CLASS='multiPOControl' ><input type='text' maxlength='8' onkeypress='return validateData(event,5);' onkeyup='return QtyValidation("
								+ i + ");' name='strIssueQty' id='strIssueQty" + i
								+ "' class='txtFldMin' value='' > </TD>");

						br.append("<TD WIDTH='10%' id='td5" + i
								+ "' CLASS='multiPOControl'  ><Select name='strIssueUnitId' onChange='return QtyValidation("
								+ i + ");' id='strIssueUnitId" + i + "' >" + strUnitComboValues + "</select></TD>");

						br.append("<TD WIDTH='10%' id='td6" + i + "' CLASS='multiPOControl'  >"
								+ "<textarea  class='txtFldMin' size = '100' maxlength='500' onkeypress='return validateData(event,9);' name='strItemRemarks' id='strItemRemarks"
								+ i + "' value='' ></textarea></TD>");

						br.append("<TD WIDTH='10%' id='td7" + i + "' CLASS='multiControl'  >"
								+ "<input type='text' class='txtFldMin' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strBSQuantity' id='strBSQuantity"
								+ i + "' value='' ></TD>");

						/*
						 * br.append("<TD WIDTH='3%' id='td7" + i +
						 * "' CLASS='multiPOControl'  ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
						 * + i +
						 * "' value='' /> <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
						 * +i+ "\");' TITLE='Click Here For Item Preferences' >#</TD>");
						 */

						br.append("</TR>");
						br.append("</div>");
						i++;
					} else {
						br.append("<TR>");

						//// System.out.println("strStoreId-" + strRaisingStoreId);
						/*
						 * br.append("<TR>"); br .append(" <input type='hidden' name='strItemDetailsChk'
						 * id='strItemDetailsChk" + i + "' onclick='ClickCheckBox(this,\"" + i +
						 * "\");' value= '" + strHiddenId + "^" + strItemCategoryNo + "^" + strStoreId +
						 * "' /> "); br.append(" <input type='hidden' name='flag' id='flag"+i+"'
						 * value=" + "0" + " >");
						 */

						br.append("<TD WIDTH='32%' id='td1" + i
								+ "' CLASS='multiPOControl'  style=\"text-align:left;\">");
						br.append(" <input type='hidden' name='strItemDetailsChk' id='strItemDetailsChk" + i
								+ "' value= '" + strHiddenId + "^" + strItemCategoryNo + "^" + strRaisingStoreId
								+ "' /> ");
						br.append(" <input type='hidden' name='flag' id='flag" + i + "' value=" + "0" + " />");
						br.append(" <input type='hidden' name='strAvlQtyForChk' id='strAvlQtyForChk" + i + "' value="
								+ strAvlQty + " />");

						br.append(" <input type='hidden' name='reOrderFlag' id='reOrderFlag" + i + "' value="
								+ wb.getString(10) + " />");
						br.append(strBrandName + "</TD>");

//						br.append("<a STYLE='cursor:pointer;cursor:pointer;color:blue' title='Batch Wise Item Details' onClick='showPopUp(this,\""
//										+ i + "\");'>" + strBrandName + "</a></TD>");

						br.append("<TD WIDTH='13%' id='td2" + i + "' CLASS='multiPOControl'  >" + strAvlQty + "/"
								+ strReceivingStoreAvlQty + "<input type='hidden' name='strAvlQty' id='strAvlQty" + i
								+ "' value='" + strAvlQtyWithUnitId
								+ "' /><input type='hidden' name='strAvlQtyBaseVal' id='strAvlQtyBaseVal" + i
								+ "' value='" + strAvlQtyBaseVal + "' /></TD>");

						br.append("<input type='hidden' name='strBalQty' id='strBalQty" + i + "' value='" + strBalQty
								+ "' /><input type='hidden' name='strSancUnitId' id='strSancUnitId" + i + "' value='"
								+ strSancUnitId
								+ "' /> <input type='hidden' name='strBalQtyBaseVal' id='strBalQtyBaseVal" + i
								+ "' value='" + strBalQtyBaseVal + "' />");

						br.append("<TD WIDTH='15%' id='td3" + i + "' CLASS='multiPOControl'  >" + strReqSancQty
								+ "</TD>");

						br.append("<TD WIDTH='10%' id='td4" + i
								+ "' CLASS='multiPOControl' ><input type='text' maxlength='8' onkeypress='return validateData(event,5);' onkeyup='return QtyValidation("
								+ i + ");' name='strIssueQty' id='strIssueQty" + i
								+ "' class='txtFldMin' value='' > </TD>");

						br.append("<TD WIDTH='10%' id='td5" + i
								+ "' CLASS='multiPOControl'  ><Select name='strIssueUnitId' onChange='return QtyValidation("
								+ i + ");' id='strIssueUnitId" + i + "' >" + strUnitComboValues + "</select></TD>");

						/*
						 * br.append("<TD WIDTH='3%' id='td8" + i +
						 * "' CLASS='multiPOControl'  ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
						 * + i +
						 * "' value='' /> <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
						 * + i + "\");' TITLE='Click Here For Item Preferences' >#</TD>");
						 */

						br.append("<TD WIDTH='10%' id='td7" + i
								+ "' CLASS='multiPOControl'><input type='text' disabled='disabled' class='txtFldNormal'  value='0.00' name='finalCostDivId' id='finalCostDivId"
								+ i + "' ></TD>");
						br.append(
								"<input type='hidden' name='strFinalCost' id='strFinalCost" + i + "' value='0.00' />");

						br.append("<TD WIDTH='10%' id='td6" + i + "' CLASS='multiControl'  >"
								+ "<input type='text' class='txtFldNormal' maxlength='100' onkeypress='return validateData(event,9);' name='strItemRemarks' id='strItemRemarks"
								+ i + "' value='' ></TD>");
						br.append("<TD WIDTH='10%' id='td7" + i + "' CLASS='multiControl'  >"
								+ "<input type='text' class='txtFldMin' maxlength='8' onkeypress='return validateData(event,5);' autocomplete='off' name='strBSQuantity' id='strBSQuantity"
								+ i + "' value='' ></TD>");

						br.append("</TR>");
						br.append("</div>");
						i++;
					}

				}

				br.append("</table> ");
			} else {
				br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<TR>");
				br.append("<TD  CLASS='multiPOControl' colspan='8'>" + "No Record Found" + "</TD>");
				br.append("</TR>");
				br.append("</table> ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}
		//// System.out.println("O/P String:::::"+br.toString());
		return br.toString();
	}

	/**
	 * This method is used to show item Details on view PAGE
	 * 
	 * @param wb
	 * @param strItemCategory
	 * @param strHospitalCode
	 * @return
	 */
	public static String getViewItemDetails(String strItemCategoryNo, String strHospitalCode, WebRowSet wb,
			String strStoreId) throws SQLException {
		StringBuffer br = new StringBuffer();

		IssueDeskTransBO bo = null;
		IssueDeskTransVO vo = null;
		// HisUtil hisutil = null;

		// String strUnitComboValues = "";

		String strHiddenId = ""; // item id^brand
		// id^strItemCategory^strStoreId
		// String strItemName = "";
		String strBrandName = "";
		String strAvlQty = "";
		String strBalQty = "";
		String strSancUnitId = "";
		String strUnitName = "";

		String[] temp = null;
		int i = 0;

		try {
			// hisutil = new HisUtil("mms", "IssueDeskTransHLP");
			bo = new IssueDeskTransBO();
			vo = new IssueDeskTransVO();

			vo.setStrHospitalCode(strHospitalCode);
			if (wb.size() != 0) {

				br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");

				while (wb.next()) {
					strHiddenId = wb.getString(1); // item id^brand id
					// strItemName = wb.getString(2);
					strBrandName = wb.getString(3);
					strAvlQty = wb.getString(4);
					//// System.out.println("strAvlQty"+strAvlQty);
					temp = strAvlQty.replace("@", "#").split("#");
					temp = temp[0].replace("^", "#").split("#");
					strBalQty = wb.getString(5);
					strSancUnitId = wb.getString(6);
					strUnitName = wb.getString(7);
					// ////System.out.println("strHiddenId-" + strHiddenId);
					// ////System.out.println("strItemCategory-" +
					// strItemCategoryNo);

					vo.setStrSancUnitId(strSancUnitId);

					bo.getUnitCombo(vo);

					if (vo.getStrMsgType().equals("1")) {
						throw new Exception(vo.getStrMsgString());
					}

					/*
					 * if (vo.getUnitComboWS() != null && vo.getUnitComboWS().size() > 0) {
					 * strUnitComboValues = hisutil.getOptionValue(vo .getUnitComboWS(), "",
					 * "0^Select Value", true); } else {
					 * 
					 * strUnitComboValues = "<option value='0'>Select Value</option>"; }
					 */

					/*
					 * br.append("<TR>"); br .append(" <input type='hidden' name='strItemDetailsChk'
					 * id='strItemDetailsChk" + i + "' onclick='ClickCheckBox(this,\"" + i +
					 * "\");' value= '" + strHiddenId + "^" + strItemCategoryNo + "^" + strStoreId +
					 * "' /> "); br.append(" <input type='hidden' name='flag' id='flag"+i+"'
					 * value=" + "0" + " >");
					 */

					br.append("<TD WIDTH='33%' CLASS='multiPOControl' >");
					br.append(" <input type='hidden' name='strItemDetailsChk' id='strItemDetailsChk" + i
							+ "' onclick='ClickCheckBox(this,\"" + i + "\");' value= '" + strHiddenId + "^"
							+ strItemCategoryNo + "^" + strStoreId + "' /> ");
					br.append(" <input type='hidden' name='flag' id='flag" + i + "' value=" + "0" + " >");

					br.append(
							"<a STYLE='cursor:pointer;cursor:pointer;color:blue' title='Batch Wise Item Details' onClick='showPopUp(this,\""
									+ i + "\");'>" + strBrandName + "</a></TD>");

					br.append("<TD WIDTH='33%' CLASS='multiPOControl' >" + temp[0] + "</TD>");
					br.append("<TD WIDTH='33%' CLASS='multiPOControl' >" + wb.getString(9) + "</TD>");
					br.append("</TR>");
					i++;
				}

				br.append("</table> ");
			} else {
				br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<TR>");
				br.append("<TD  CLASS='multiPOControl' colspan='3'>" + "No Record Found" + "</TD>");
				br.append("</TR>");
				br.append("</table> ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}

		return br.toString();
	}

	/**
	 * This method is used to show issued item Details on VIEW PAGE2
	 * 
	 * @param wb
	 * @param strItemCategory
	 * @param strHospitalCode
	 * @return
	 */
	public static String getIssuedItemDetail(String strItemCategoryNo, String strHospitalCode, WebRowSet wb,
			String strStoreId, String strIssueNo) throws SQLException {
		StringBuffer br = new StringBuffer();

		// IssueDeskTransBO bo = null;
		IssueDeskTransVO vo = null;

		String strItemName = "";
		String strBatchSlNo = "";
		String strSancQty = "";
		String strIssuedQty = "";
		String strItemRemarks = "";

		String strRecievedBy = "";
		String strRemarks = "";
		String strIndentNo = "0";
		String strIndentDate = "";

		int i = 0;

		try {

			// bo = new IssueDeskTransBO();
			vo = new IssueDeskTransVO();

			vo.setStrHospitalCode(strHospitalCode);
			if (wb.size() != 0) {

				br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<input type='hidden' name='strStoreId' id='strStoreId' value=" + strStoreId + " />");
				br.append("<input type='hidden' name='strIssueNo' id='strIssueNo' value=" + strIssueNo + " />");

				while (wb.next()) {
					strIndentNo = wb.getString(14);// 14
					strIndentDate = wb.getString(18);// 15
				}
				br.append("<input type='hidden' name='strIndentNo' id='strIndentNo' value=" + strIndentNo + " />");
				br.append(
						"<input type='hidden' name='strIndentDate' id='strIndentDate' value=" + strIndentDate + " />");

				wb.beforeFirst();

				while (wb.next()) {

					strItemName = wb.getString(7);
					strBatchSlNo = wb.getString(8);
					strIssuedQty = wb.getString(9);
					strSancQty = wb.getString(11);
					strItemRemarks = wb.getString(12);
					strRecievedBy = wb.getString(3);
					strRemarks = wb.getString(4);

					br.append("<TD WIDTH='20%' CLASS='multiPOControl' >" + strItemName + "</TD>");

					br.append("<TD WIDTH='20%' CLASS='multiPOControl' >" + strBatchSlNo + "</TD>");
					br.append("<TD WIDTH='20%' CLASS='multiPOControl' >" + strSancQty + "</TD>");

					br.append("<TD WIDTH='20%' CLASS='multiPOControl' >" + strIssuedQty + "</TD>");

					br.append("<TD WIDTH='20%' CLASS='multiPOControl' >" + strItemRemarks + "</TD>");

					br.append("</TR>");
					i++;
				}

				br.append("</table> ");
			} else {
				br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<TR>");
				br.append("<TD  CLASS='multiPOControl' colspan='5'>" + "No Record Found" + "</TD>");
				br.append("</TR>");
				br.append("</table> ");
			}
			if (strRecievedBy.equals("") || strRemarks.equals("")) {
				br.append("#" + "--" + "#" + "--");
			} else {
				br.append("#" + strRecievedBy + "#" + strRemarks);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}

		return br.toString();
	}

	/**
	 * This method is used to show a PopUp (ON CLICK OF AN ITEM NAME)
	 * 
	 * @param wb
	 * @param index
	 * @return
	 */
	public static String getPopUpInfo(WebRowSet wb, String index) {

		// String temp[] = null;
		StringBuffer br = null;
		StringBuffer br1 = null;
		String strItemName = "";
		String strBrandname = "";
		String strBatchNo = "";
		String strManufactDate = "";
		String strExpiryDate = "";
		String strInHandQty = "";
		String strAvlQty = "";

		try {
			br = new StringBuffer();
			br1 = new StringBuffer();

			br.append("<table width='500' cellpadding='0' cellspacing='0'>");

			br.append("<tr class='HEADER' align='left'><td>&nbsp;Batch Wise Item Details</td> ");
			br.append(
					"<td align='right'><img src='../../hisglobal/images/popUp_cancel.JPG' title='To Close PopUp Window' align='middle' onclick='hide_popup_menu(\"popup\");'> </td></tr>");

			br.append("</tr>");
			br.append("</table> ");

			br.append("<table width='500' align='left'>");

			br.append("<tr>");

			br.append("<td class='multiLabel' WIDTH='16%' align='CENTER'>Generic Item Name</td>");

			br.append("<td class='multiLabel' WIDTH='16%' align='CENTER'>Item Name</td>");

			br.append("<td class='multiLabel' WIDTH='16%' align='CENTER'>Batch No.</td>");

			br.append("<td class='multiLabel' WIDTH='20%' align='CENTER'>Manfactured Date</td>");

			br.append("<td class='multiLabel' WIDTH='16%' align='CENTER'>Expiry Date</td>");

			br.append("<td class='multiLabel' WIDTH='16%' align='CENTER'>Avl Qty</td>");

			br.append("</tr>");

			//// System.out.println("wb size" + wb.size());

			if (wb == null || wb.size() == 0) {
				//// System.out.println("wb size" + wb.size());
				br.append("<TR>");
				br.append("<TD colspan='6'  CLASS='multiPOControl' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND</div> " + "</TD>");

				br.append("</TR>");
			} else {
				while (wb.next())

				{
					strItemName = wb.getString(1);
					strBrandname = wb.getString(2);
					strBatchNo = wb.getString(3);
					strManufactDate = wb.getString(4);
					strExpiryDate = wb.getString(5);
					strInHandQty = wb.getString(6);
					String temp[] = strInHandQty.replace("^", "#").split("#");
					strAvlQty = temp[0];

					if (strItemName == null || strItemName.equals("null"))
						strItemName = "";
					if (strBrandname == null || strBrandname.equals("null"))
						strBrandname = "";
					if (strBatchNo == null || strBatchNo.equals("null"))
						strBatchNo = "";
					if (strManufactDate == null || strManufactDate.equals("null"))
						strManufactDate = "";
					if (strExpiryDate == null || strExpiryDate.equals("null"))
						strExpiryDate = "";
					if (strInHandQty == null || strInHandQty.equals("null"))
						strInHandQty = "";

					br.append("<TR>");

					br.append("<TD  WIDTH='16%' CLASS='multiPOControl'>" + strItemName + "</TD>");

					br.append("<TD WIDTH='16%' CLASS='multiPOControl'>" + strBrandname + "</TD>");

					br.append("<TD WIDTH='16%' CLASS='multiPOControl' >" + strBatchNo + "</TD>");

					br.append("<TD WIDTH='20%' CLASS='multiPOControl' >" + strManufactDate + "</TD>");

					br.append("<TD WIDTH='16%' CLASS='multiPOControl' >" + strExpiryDate + "</TD>");
					br.append("<TD WIDTH='16%' CLASS='multiPOControl' >" + strAvlQty + "</TD>");

					br.append("</TR>");

					br1.append(strItemName + "^" + strBrandname + "^" + strBatchNo + "^" + strManufactDate + "^"
							+ strExpiryDate + "^" + strInHandQty + "^");

					i++;
				}
			}
			br.append("</table>");
			br.append("@");
			br.append(br1);
			br.append("@");
			br.append(index);

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}
		//// System.out.println("br.toString()-" + br.toString());
		return br.toString();

	}

	/**
	 * This method is used to show a PopUp (ON CLICK OF A BILL NO. AGAIN)of Bill
	 * SERVICE DETAILS by using the WebRowSet
	 * 
	 * @param vo
	 * @return
	 */
	public static String getPopUpData(String strPopUpData) {

		StringBuffer br = null;
		String data = "";
		String temp[] = null;

		try {

			data = strPopUpData;

			temp = data.replace('^', '#').split("#");
			//// System.out.println("temp length-->" + temp.length);

			br = new StringBuffer();

			br.append("<table width='500' cellpadding='0' cellspacing='0'>");

			br.append("<tr class='HEADER' align='left'><td>&nbsp;Batch Wise Item Details</td> ");
			br.append(
					"<td align='right'><img src='../../hisglobal/images/popUp_cancel.JPG' align='middle' onclick='hide_popup_menu(\"popup\");'> </td></tr>");

			br.append("</tr>");
			br.append("</table> ");

			br.append("<table width='500' align='left'>");

			br.append("<tr>");

			br.append("<td class='multiLabel' WIDTH='16%' align='CENTER'>Item Name</td>");

			br.append("<td class='multiLabel' WIDTH='16%' align='CENTER'>Brand Name</td>");

			br.append("<td class='multiLabel' WIDTH='16%' align='CENTER'>Batch No.</td>");

			br.append("<td class='multiLabel' WIDTH='20%' align='CENTER'>Manfactured Date</td>");

			br.append("<td class='multiLabel' WIDTH='16%' align='CENTER'>Expiry Date</td>");

			br.append("<td class='multiLabel' WIDTH='16%' align='CENTER'>Avl Qty</td>");

			br.append("</tr>");
			if (temp.length > 1) {
				for (int j = 0; j <= (temp.length / 2); j = j + 6) {

					br.append("<TR>");

					br.append("<TD  WIDTH='16%' CLASS='multiPOControl'>" + temp[j + 0] + "</TD>");

					br.append("<TD WIDTH='16%' CLASS='multiPOControl'>" + temp[j + 1] + "</TD>");

					br.append("<TD WIDTH='16%' CLASS='multiPOControl' >" + temp[j + 2] + "</TD>");

					br.append("<TD WIDTH='20%' CLASS='multiPOControl' >" + temp[j + 3] + "</TD>");

					br.append("<TD WIDTH='16%' CLASS='multiPOControl' >" + temp[j + 4] + "</TD>");
					br.append("<TD WIDTH='16%' CLASS='multiPOControl' >" + temp[j + 5] + "</TD>");

					br.append("</TR>");
				}
			}

			br.append("</table>");

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}

		return br.toString();

	}

	/**
	 * Gets the stock item dtls init view.
	 * 
	 * @param formBean the form bean
	 * 
	 * @return the stock item dtls init view
	 * 
	 * @throws Exception the exception
	 */
	public static String getStockItemDtlsInitView(IssueDeskTransFB formBean) throws Exception {

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

		String strTableWidth = "800";
		// formBean.setUsrArg((String) request.getParameter("strMode").split("\\^")[1]);
		// This Variable is Used As Budget Avalaible Flag
		// Change By Amit Kumar 10-Aug-2011

		try {

			/*
			 * if(formBean.getStrHiddenVal().trim().length() > 1) strHiddenVal =
			 * formBean.getStrHiddenVal();
			 */

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
				sb.append("<td width='50%' class='CONTROL'>" + formBean.getStrIndentIssueQty() + " "
						+ formBean.getStrUnitName() + "<input type='hidden' class='txtFldNormal' ");
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
				sb.append("<td class='multiRPTLabel' width='9%'>Rack No");
				sb.append("</td> ");
//				if (!formBean.getStrItemCategoryId().equals("10")) 
//				{
//					sb.append("<td class='multiRPTLabel' width='14%'>Serial No. ");
//					sb.append("</td> ");
//				}
				sb.append("<td class='multiRPTLabel' width='14%'>Batch No. ");
				sb.append("</td> ");
				sb.append("<td class='multiRPTLabel' width='10%'>Expiry Date ");
				sb.append("</td> ");
//				sb.append("<td class='multiRPTLabel' width='14%'>Manufacturer ");
//				sb.append("</td> ");
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
						/*
						 * This part is added by Aritra on May 26, 2010. It will cause to produce
						 * distinct value for strStockDtlsChk checkbox, not appending with the value of
						 * previous check-box. *
						 */
						strChkVal = new StringBuffer();
						/* -- End of addtion on May 26, 2010 -- */

						/*
						 * 11. Store id, 12. Generic Item Id 13. Item Id 14. Stock Status Code 15. Batch
						 * No. 18. Expiry Date 19. Manufacture Date 20. Inhand Qty 21. Inhand Qty Unit
						 * Id 23. Rate 24. Rate Unit Id 37. Serial No. 38. Sale Price 39. Sale Price
						 * Unit Id
						 */

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

						String strRackNo = "-----";

						if (ws.getString(44) != null || ws.getString(44) != "") {
							strRackNo = ws.getString(44);
						}

						sb.append("<td class='multiPOControl' width='9%'>"); // Rack No::::
						sb.append(strRackNo);
						sb.append("</td> ");

//						if (!formBean.getStrItemCategoryId().equals("10")) 
//						{
//							sb.append("<td class='multiPOControl' width='14%'>");
//							sb.append(ws.getString(37));
//							sb.append("</td> ");
//						}

						sb.append("<td class='multiPOControl' width='14%'>");
						sb.append(ws.getString(15));
						sb.append("</td> ");
						sb.append("<td class='multiPOControl' width='10%'>");
						sb.append(strExpDate);
						sb.append("</td> ");
//						sb.append("<td class='multiPOControl' width='14%'>");
//
//						if (ws.getString(5) != null	&& !ws.getString(5).equals("null"))
//							
//							sb.append(ws.getString(5));
//
//						sb.append("</td> ");
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
									+ "' onkeypress='return validateData(event,7);' onkeyup='checkAvailQtyTwo(\""
									+ count
									+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\",\"strStockCostId\");' name='strAvailableQty' id='strAvailableQty"
									+ count + "'>");

						} else {

							sb.append(
									"<input type='text' autocomplete='off' class='txtFldMin' maxlength='7' disabled='disabled' onkeypress='return validateData(event,7);' onkeyup='checkAvailQty(\""
											+ count
											+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\");' name='strAvailableQty' id='strAvailableQty"
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
									+ count + "' onchange='checkAvailQty(\"" + count
									+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\");'>");

							vo.setStrUnitId(ws.getString(21));
							vo.setStrHospitalCode(formBean.getStrHospitalCode());
							IssueDeskTransDAO.getUnitList(vo);

							if (vo.getStrUnitListWs() != null && vo.getStrUnitListWs().size() > 0) {

								sb.append(util.getOptionValue(vo.getStrUnitListWs(), strTempUnitVal, "", true, true));

							} else {

								sb.append("<option value='0'>Select</option>");
							}

							sb.append("</select>");

						} else {

							sb.append(
									"<select name='strAvailableQtyUnit' disabled='disabled' class='comboMin' id='strAvailableQtyUnit"
											+ count + "' onchange='checkAvailQty(\"" + count
											+ "\",\"strAvailableQty\",\"strAvailableQtyUnit\");' >");

							vo.setStrUnitId(ws.getString(21));
							vo.setStrHospitalCode(formBean.getStrHospitalCode());
							IssueDeskTransDAO.getUnitList(vo);

							if (vo.getStrUnitListWs() != null && vo.getStrUnitListWs().size() > 0) {

								sb.append(
										util.getOptionValue(vo.getStrUnitListWs(), vo.getStrUnitId(), "", true, true));

							} else {

								sb.append("<option value='0'>Select</option>");
							}

							sb.append("</select>");

						}

						sb.append("</td> ");
						if (formBean.getUsrArg().equals("1")) // Means Budget Required
						{

							if (formBean.getStrItemCategoryId().equals("10")) {
								sb.append("<td class='multiPOControl' width='14%'>");
								if (flag) {
									sb.append("<input type='text' disabled='disabled' class='txtFldMin'  value='"
											+ strTempCost + "' name='strStockCost' id='strStockCost" + count + "' >");
									sb.append("<input type='hidden' value='" + strTempCost
											+ "' name='strCost' id='strCost" + count + "' >");
								} else {
									sb.append(
											"<input type='text' disabled='disabled' class='txtFldMin'  value='0.00' name='strStockCost' id='strStockCost"
													+ count + "' >");
									sb.append("<input type='hidden' value='0.00' name='strCost' id='strCost" + count
											+ "' >");
								}

							} else {

								sb.append("<td class='multiPOControl' width='14%'>");
								if (flag) {
									sb.append("<input type='text' disabled='disabled' class='txtFldMin'  value='"
											+ strTempCost + "' name='strStockCost' id='strStockCost" + count + "' >");
									sb.append("<input type='hidden' value='" + strTempCost
											+ "' name='strCost' id='strCost" + count + "' >");
								} else {
									sb.append(
											"<input type='text' disabled='disabled' class='txtFldMin'  value='0.00' name='strStockCost' id='strStockCost"
													+ count + "' >");
									sb.append("<input type='hidden' value='0.00' name='strCost' id='strCost" + count
											+ "' >");
								}

							}
							sb.append("</td> ");
						}

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
				if (formBean.getUsrArg().equals("1")) {
					sb.append("<table width='" + strTableWidth
							+ "' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb.append("<tr> ");
					sb.append("<td width='68%' class='LABEL'>Total:</td> ");
					sb.append("<td width='16%' class='CONTROL' style='color: red; font-weight: bold'> ");
					sb.append("<div id='strTotalQtyDivId' align='left'>0.00</div></td> ");
					sb.append(
							"<td width='12%' class='CONTROL' style='color: red; font-weight: bold;text-align:right;'> ");
					sb.append("<input type='text' name='strTotalCostDivId' class='txtFldNormal'  value='"
							+ strTempTotalCost + "'  disabled='disabled' id='strTotalCostDivId' >");
					sb.append("<input type='hidden' name='strApproxAmt' value='" + strTempTotalCost + "'></td> ");
					sb.append("</tr> ");
					sb.append("</table> ");
				}

				sb.append("<table width='" + strTableWidth + "' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr class='FOOTER'> ");
				sb.append("<td colspan='4'><font size='2' color='red'>*</font> Mandatory Fields  </td> ");
				sb.append("</tr> ");
				sb.append("</table> ");

				sb.append("<table border='0' width='" + strTableWidth + "' align='center'> ");
				sb.append("<tr> ");
				sb.append("<td align='center'><img style='cursor: pointer; ' ");
				sb.append(" src='../../hisglobal/images/btn-ok.png' ");
				sb.append(" onClick='return validatePopUp();' title='Save Record'/>  ");
				sb.append(" <img style='cursor: pointer; ' title='Cancel Process'  ");
				sb.append(" src='../../hisglobal/images/close_tab.png' onClick='cancelStockDetails(this,\""
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

	public static String getIssueDtlsInitView(IssueDeskTransFB formBean,IssueDeskTransVO vo ) throws Exception {

		StringBuffer sb = new StringBuffer("");
		String strIssueBy = "";
		String strRecivedBy = "";
		String strPurchaseCost = "";
		String strRemarks = "";
		/*
		 * String str2 = "76.39"; float f = Float.parseFloat(str2); String str = "5";
		 * Float f = new Float(str); double d = f.doubleValue();
		 * 
		 */
		double cltamt = 0.00;
		double totalCost = 0.00;

		double cltamt1 = 0.00;
		double totalCostWithoutSC = 0.00;

		String strStoreName = "";
		String returnTo = "", strApplyClass = "";
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

		WebRowSet ws = formBean.getWsIssueDetails();

		String strIssueDate = "";

		if (formBean.getStrIssueDate().length() > 2) {
			strIssueDate = formBean.getStrIssueDate();
		}

		String strTableWidth = "825";

		try {
			HisUtil hisUtil = new HisUtil("Global", "ReportUtil");
			HospitalMstVO hospitalVO = hisUtil.getHospitalDetail(formBean.getStrHospitalCode());

			// System.out.println("hospitalVO.getAddress1()"+hospitalVO.getHospitalName());
			// System.out.println("the ws length isa "+ws.getKeyColumns());

			// sb.append("<style>@media screen and (orientation: portrait) { #toolbar
			// {width: 100%;}}</style>");

			sb.append(
					"<style>@media screen and (orientation: landscape) { #toolbar {position: fixed; width: 2.65em; height: 100%; } p { margin-left: 2em;} li + li {margin-top: .5em;}}</style>");

		/*	sb.append("<table align='center' width='").append(strTableWidth)
					.append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append(
					"<tr><td width='8%'><div><img src='/INVMGM/hisglobal/images/logo.png' width='100' style='margin-left: 100%;float: left;'></div></td> ");
			sb.append(
					"<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");

			sb.append(hospitalVO.getHospitalName());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append(
					"<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
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
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append(
					"<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");

			sb.append("</font></b></td>"
					+ "<td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");  */
			
			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
			sb.append(
					"<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(
					" src='../../hisglobal/images/printer_symbol.gif' onClick='printData();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(
					" src='../../hisglobal/images/stop.png' onClick='cancelToDesk_View();' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			
			sb.append(" <br> ");
			
			sb.append("<table border='0' width='" + strTableWidth + "' align='center'> ");
			sb.append("<tr> "
			        + " <td>"
			        + "<div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div>"
			       // +"<div class='d-flex justify-content-center align-items-center'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></div>"
			        + "</td>");
			sb.append("</tr></table>");	
			
			if (formBean.getStrModeVal().equals("3")) {

				sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth)
						.append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Report For&nbsp;Third Party Issue Details</b></font></td></tr></table> ");

			} else if (formBean.getStrModeVal().equals("4")) {
				sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth)
						.append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Report For&nbsp;Acknowledge</b></font></td></tr></table> ");
			} else {
				if (!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6")) {
					sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
							.append(strTableWidth)
							.append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>Report For&nbsp;Issue Details</b></font></td></tr></table> ");
				} else {
					sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
							.append(strTableWidth)
							.append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Report For&nbsp;Return Details</b></font></td></tr></table> ");

				}

			}

			if (formBean.getStrStoreName().length() != 0) {
				if (!formBean.getStrModeVal().equals("4")) {
					sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
							.append(strTableWidth)
							.append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>(")
							.append(formBean.getStrStoreName()).append(")</b></font></td></tr></table>");
				} else {
					sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
							.append(strTableWidth)
							.append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>Acknowledging Store : ")
							.append(formBean.getStrStoreName()).append("</b></font></td></tr></table>");
				}

			}
			sb.append("<table width='").append(strTableWidth)
					.append("' align='center' cellpadding='1px' cellspacing='1px'> ");

			if (!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6")) {

				sb.append("<tr> ");

				sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(util.appendSpace("Issue No. :", 15, 0)).append(formBean.getStrIssueNo())
						.append("</b></font></td> ");

				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(util.appendSpace("Issue Date", 15, 0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(strIssueDate).append("</b></font></td> ");
				sb.append("</tr> ");

				if (!formBean.getStrIndentNo().equals("0")) {
					sb.append("<tr> ");
					sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
							.append(util.appendSpace("Request No. :", 15, 0)).append(formBean.getStrIndentNo())
							.append("</b></font></td> ");
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
							.append(util.appendSpace("Request Date", 15, 0)).append(":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
							.append(formBean.getStrIndentDate()).append("</b></font></td> ");
					sb.append("</tr> ");

				}
				if (!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("4")) {
					sb.append("<tr> ");
					sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
							.append(util.appendSpace("Issue To :", 15, 0))
							.append(formBean.getStrIssueTo().split("@")[0]).append("</b></font></td> ");
					if (!formBean.getStrModeVal().equals("2") && !formBean.getStrModeVal().equals("4")) {
						sb.append(
								"<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
								.append(util.appendSpace("CR No.:", 15, 0)).append("</b></font></td> ");
						sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
								.append(formBean.getStrCrno()).append("</b></font></td> ");
					}
					sb.append("</tr> ");

					sb.append("<tr><TD COLSPAN='4'>&nbsp;</td></tr>");
				} else {
					sb.append("<tr> ");
					if (!formBean.getStrModeVal().equals("4")) {
						sb.append(
								"<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
								.append(util.appendSpace("Issue To", 15, 0)).append(":</b></font></td> ");
						sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
								.append(formBean.getStrIssueTo().split("@")[0]).append("</b></font></td> ");

						sb.append(
								"<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
								.append(util.appendSpace("", 15, 0)).append("</b></font></td> ");
						sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
								.append("</b></font></td> ");
					} else {
						sb.append(
								"<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
								.append(util.appendSpace("Issuing Store :", 15, 0)).append(formBean.getStrOrgName())
								.append("</b></font></td> ");
						sb.append(
								"<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Indent Type : </b></font></td> ");
						sb.append(
								"<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue to Store</b></font></td> ");
					}

					sb.append("</tr> ");

					sb.append("<tr><TD COLSPAN='4'>&nbsp;</td></tr>");

				}
			} else {
				sb.append("<tr> ");

				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(util.appendSpace("Return No.", 15, 0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(formBean.getStrIssueNo()).append("</b></font></td> ");

				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(util.appendSpace("Return Date", 15, 0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(strIssueDate).append("</b></font></td> ");
				sb.append("</tr> ");

				if (formBean.getStrModeVal().equals("5") && formBean.getStrModeVal().equals("6")) {
					if (formBean.getStrReturnReqNo() != null && !formBean.getStrReturnReqNo().equals("")
							&& !formBean.getStrReturnReqNo().equals("0")) {
						sb.append("<tr> ");
						sb.append(
								"<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>&nbsp;")
								.append(util.appendSpace("Return Req. No.", 15, 0)).append(":</b></font></td> ");
						sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
								.append(formBean.getStrReturnReqNo()).append("</b></font></td> ");
						sb.append(
								"<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>&nbsp;")
								.append(util.appendSpace("Return Req. Date", 15, 0)).append(":</b></font></td> ");
						sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
								.append(formBean.getStrIndentDate()).append("</b></font></td> ");
						sb.append("</tr> ");
					}
				}

				if (ws != null && ws.size() > 0) {

					while (ws.next()) {
						returnTo = ws.getString(4);

					}
					ws.beforeFirst();
				}
				sb.append("<tr> ");
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(util.appendSpace("Return From", 15, 0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(formBean.getStrIssueTo().split("@")[0]).append("</b></font></td> ");
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
						.append(util.appendSpace("Return To", 15, 0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(returnTo)
						.append("</b></font></td> ");

				sb.append("</tr> ");

			}

			//sb.append("<tr><TD COLSPAN='4' align='left'><b>**[T/S] - Temprature Senstive </b></td></tr>");

			sb.append("</table> ");

			sb.append("<table width='").append(strTableWidth)
					.append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append(
					"<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
			sb.append("</td>");

			sb.append(
					"<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
			sb.append("</td>");

			sb.append(
					"<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch/Serial No.</b></font> ");
			sb.append("</td> ");
			sb.append(
					"<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font>");
			sb.append("</td> ");
			sb.append(
					"<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate wth Tax/Unit</b></font> ");
			sb.append("</td> ");
			if (!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6")) {
				if (formBean.getStrModeVal().equals("2")) {
					sb.append(
							"<td align='center' width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Sanc. Qty</b></font>");
					sb.append("</td> ");
				}
				sb.append(
						"<td align='center' width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font>");
				sb.append("</td> ");
				if (!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5")) {

					sb.append(
							"<td align='center' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font>");
					sb.append("</td> ");
				}
			} else {
				sb.append(
						"<td align='center' width='14%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return Qty</b></font> ");
				sb.append("</td> ");
				sb.append(
						"<td align='center' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font>");
				sb.append("</td> ");
			}
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) {

				while (ws.next()) {

					/*
					 * 1.Issue No 2.Issue Date 3.Issue To 4.Issue By Store Name
					 * 
					 */

					if (ws.getString(23).equals("1")) {
						strApplyClass = "#DCDCDC";
					} else {
						strApplyClass = "";
					}

					NumberFormat formatter = new DecimalFormat("############.##");

					if (formBean.getStrModeVal().equals("4")) {

						strIssueBy = ws.getString(28);
						strRecivedBy = ws.getString(27);
						strItemTotCost = ws.getString(30);
						strPurchaseCost = ws.getString(32);
						strItemTotCost = formatter.format(new BigDecimal(ws.getString(30)));

						if (ws.getString(33) == null || ws.getString(33).equals(""))
							strItemTotCostWithOutSC = "0";
						else
							strItemTotCostWithOutSC = formatter.format(new BigDecimal(ws.getString(33)));
					} else {
						if (formBean.getStrModeVal().equals("2")) {
							strStoreName = ws.getString(4);
							strRemarks = ws.getString(27);
							strRecivedBy = ws.getString(28);
							strItemTotCost = ws.getString(29);

							strPurchaseCost = ws.getString(33); // With Unit Like e.g. 161 No.

							strItemTotCost = formatter.format(new BigDecimal(ws.getString(29)));
							strItemTotCostWithOutSC = formatter.format(new BigDecimal(ws.getString(34)));
							// strBudgetUsed = formatter.format(new BigDecimal(ws.getString(35)));
						} else {
							if (formBean.getStrModeVal().equals("3")) {

								// strRemarks = ws.getString(25);
								// strRecivedBy = ws.getString(26);
							} else {
								if (formBean.getStrModeVal().equals("1") || formBean.getStrModeVal().equals("6")) {

									if (formBean.getStrModeVal().equals("1")) {
										strRemarks = ws.getString(26);
										strRecivedBy = ws.getString(25);
									}

									strItemTotCost = formatter.format(new BigDecimal(
											Double.parseDouble(formatter.format(new BigDecimal(ws.getString(16))))
													* Double.parseDouble(ws.getString(19))));
								}
							}
						}

					}

					cltamt1 = Double.parseDouble(strItemTotCostWithOutSC);

					totalCostWithoutSC = totalCostWithoutSC + cltamt1; // Calculate Total Cost Without Service Charge

					cltamt = Double.parseDouble(strItemTotCost);

					totalCost = totalCost + cltamt; // Calculate Total Cost With Service Charge

					sb.append("<tr bgcolor='" + strApplyClass + "'> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(i);
					sb.append("</b></font></td> ");

					sb.append(
							"<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
					sb.append(ws.getString(6));
					sb.append("</b></font></td> ");

					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(7));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(8));// debug
					sb.append("</font></td> ");
					sb.append(
							"<td style=\"text-align:center;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(9));
					sb.append("</font></td> ");
					if (formBean.getStrModeVal().equals("2")) {
						sb.append(
								"<td style=\"text-align:center;\" width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(37));
						sb.append("</font></td> ");
					}
					sb.append(
							"<td style=\"text-align:center;\" width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' style='font-weight: bold;'>");
					sb.append(ws.getString(10));
					sb.append("</font></td> ");
					if (!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5")) {

						sb.append("</font></td> ");
						sb.append(
								"<td style=\"text-align:right;\" width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(myFormatter.format(new BigDecimal(strItemTotCost)));
						// myFormatter.format(Double.parseDouble(ws.getString(6)))
						sb.append("</font></td> ");
					}
					if (formBean.getStrModeVal().equals("5")) {
						sb.append("</font></td> ");
						sb.append(
								"<td style=\"text-align:right;\" width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(myFormatter.format(
								new Float(ws.getString(10).split(" ")[0]) * new Float(ws.getString(9).split("/")[0])));
						// myFormatter.format(Double.parseDouble(ws.getString(6)))
						sb.append("</font></td> ");
					}
					sb.append("</tr> ");
					i++;

				}

				if (!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5")) {
					NumberFormat formatter = new DecimalFormat("############.##");

					String ServiceCharge = "";

					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));

					sb.append("<tr>");
					sb.append("<td colspan='6' align='left'><hr size='2'></td>");
					sb.append("<td colspan='2' align='center'><hr size='2'></td>");

					sb.append("</tr>");

					sb.append("<tr>");
					sb.append(
							"<td colspan='6' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><div align='right'><b>TOTAL Rs.(Round)</b></div></font></td>");
					sb.append(
							"<td colspan='2' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					// sb.append(myFormatter.format(Double.parseDouble(FinaltotalCost)));
					sb.append(Math.round(Double.parseDouble(FinaltotalCost)));
					sb.append("</font></td>");
					sb.append("</tr>");

					sb.append("<tr>");
					sb.append("<td colspan='6' align='left'><hr size='2'></td>");
					sb.append("<td colspan='2' align='center'><hr size='2'></td>");

					sb.append("</tr>");

					if (formBean.getStrModeVal().equals("2") || formBean.getStrModeVal().equals("4")) // To Show Issue
																										// Off-Line
																										// Voucher
					{

						/*
						 * Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line
						 * Issue Voucher) 1.Issue No 2.Issue Date 3.Issue To 4.Issue By 5.Generic Name
						 * 6.Brand Name 7.Batch No 8.Expiry date 9.Issue rate 10.Issue Qty 11.Store Id
						 * 12.Item Id 13.Item Brand ID 14.Batch No 15.Expiry Date 16.Issue Rate 17.Issue
						 * Rate Unit Id 18.Issue Rate Base Unit Id 19.Issue Qty 20.Issue Qty Unit Id
						 * 21.Issue Qty Base Value 22.Item Sl No 23.Item SL No 24,Category Code 25.Issue
						 * Qty 26.Remarks 27.Final remarks 28.Received By 29.Cost 30.Total Avl Budget
						 * 31.Indent No 32.Indent Date 33.Purchase Rate e.g 101 No. 34.Cost With Purchae
						 * Rate 35.Budget Used
						 */
						String FinaltotalCostWithoutSc = formatter.format(new BigDecimal(totalCostWithoutSC));
						if (configIssueRate.equals("") || configIssueRate == null)
							configIssueRate = "0";
						double IssueRatePercentage = Double.parseDouble(configIssueRate);

						double PurchaseCost = Double.parseDouble(strItemTotCost);

						double serviceCharge = totalCost - totalCostWithoutSC;

						ServiceCharge = formatter.format(new BigDecimal(serviceCharge));

						double costWithServiceChag = totalCostWithoutSC + serviceCharge;

					}

				}
				if (formBean.getStrModeVal().equals("4")) {

					sb.append("<tr> ");
					sb.append(
							"<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
					sb.append(
							"<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");
					sb.append(formBean.getStrFinalRemarks());
					sb.append("<br></font></td>");
					sb.append("</tr> ");

					sb.append("<tr> ");
					if (!formBean.getStrModeVal().equals("4")) {
						sb.append(
								"<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append(
								"<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Dispensed By<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("</tr> ");
						sb.append("<tr> ");
						// sb.append("<td colspan='4' align='left'><font face='Verdana, Arial,
						// Helvetica, sans-serif' ><br><br><b>(").append(strRecivedBy).append(")<br><b>
						// &nbsp;&nbsp;</font></td> ");
						sb.append(
								"<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>")
								.append("<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append(
								"<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>(")
								.append(strIssueBy).append(")<br><b> &nbsp;&nbsp;</font></td> ");
					} else {
						sb.append(
								"<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br>.</font></td> ");
						sb.append(
								"<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Acknowledged By :")
								.append(formBean.getStrUserName()).append("<br><b> &nbsp;&nbsp;</font></td> ");
					}
					sb.append("</tr> ");

				}

				else {

					if (!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6")) {
						if (!formBean.getStrModeVal().equals("3")) {

							sb.append("<tr> ");
							sb.append(
									"<td colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received By:</font></td>");
							sb.append(
									"<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif'>");
							sb.append(strRecivedBy.trim());
							sb.append("</font></td>");
							sb.append("</tr> ");
							sb.append("<tr> ");
							sb.append(
									"<td colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks:<b></font></td>");
							sb.append(
									"<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif'>");
							// System.out.println("check Params::"+formBean.getStrFinalRemarks());

							/*
							 * if(!formBean.getStrFinalRemarks().equals("")||!formBean.getStrFinalRemarks().
							 * equals(" ")||!formBean.getStrFinalRemarks().equals(null)) {
							 * sb.append(formBean.getStrFinalRemarks().trim()); } else {
							 * sb.append("--------"); }
							 */
							sb.append(strRemarks);
							sb.append("</font></td>");
							sb.append("</tr> ");
							sb.append("<tr> ");
							if (formBean.getStrModeVal().equals("1")) {
								sb.append(
										"<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>[ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;"
												+ formBean.getStrUserName()
												+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
								sb.append("<tr> ");
								sb.append(
										"<td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>* In case of not issued items , kindly contact billing desk for refund.<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
							} else {
								sb.append(
										"<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>Dispensed By : "
												+ formBean.getStrIssueTo().split("@")[1]
												+ "<b>&nbsp;&nbsp;</font></td> ");
							}
							sb.append("</tr> ");
							if (formBean.getStrModeVal().equals("2")) {
								sb.append("<tr> ");
								sb.append(
										"<td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>Verified By :<b>&nbsp;&nbsp;</font></td></tr> ");
								int lth = formBean.getStrApprovalRemarks().split("#").length;
								for (int q = 0; q < lth; q++)
									sb.append(
											"<tr><td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b> "
													+ (q + 1) + '.' + formBean.getStrApprovalRemarks().split("#")[q]
													+ "<b>&nbsp;&nbsp;</font></td></tr> ");
								// sb.append("</tr> ");
							}
							// sb.append("<tr> ");
							// sb.append("<td colspan='8' align='right'><font face='Verdana, Arial,
							// Helvetica, sans-serif' ><br><br><b>Issued By on Behalf of
							// RMSCL<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
							// sb.append("</tr> ");

						} else {
							if (formBean.getStrModeVal().equals("3")) {

								sb.append("<tr> ");
								sb.append(
										"<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
								sb.append(
										"<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");
								sb.append(strRemarks);
								sb.append("<br></font></td>");
								sb.append("</tr> ");
								sb.append("<tr> ");
								sb.append(
										"<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
								sb.append("<tr> ");
								sb.append(
										"<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>(")
										.append(strRecivedBy).append(")<b> &nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");

							} else {
								sb.append("<tr> ");
								sb.append(
										"<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
								sb.append(
										"<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");
								sb.append(strRemarks);
								sb.append("<br></font></td>");
								sb.append("</tr> ");
								sb.append("<tr> ");
								sb.append(
										"<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
								sb.append("<tr> ");
								sb.append(
										"<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>(")
										.append(strRecivedBy).append(")<b> &nbsp;&nbsp;</font></td> ");
								sb.append("</tr> ");
							}
						}

					} else {

						sb.append("<tr> ");
						sb.append(
								"<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Received By : "
										+ formBean.getStrIssueTo().split("@")[1] + "<br><b> &nbsp;&nbsp;</font></td> ");
						sb.append("</tr> ");

					}
				}

			} else {

				sb.append("<tr> ");
				sb.append(
						"<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available/Requested Qty not available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		} finally {
			mmscofigutil = null;
		}

		return sb.toString();
	}

	public static String getItemDetailsViewPrint(IssueDeskTransVO vo) {
		StringBuffer sb = new StringBuffer("");
		String strHiddenValue = "";
		WebRowSet ws1 = vo.getStrItemDetailsWs();
		String strRemarks = "";
		int i = 0;
		try {
			sb.append("<table width='" + vo.getStrTableWidth()
					+ "' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
			if (vo.getStrReqTypeId().equals("65") || vo.getStrReqTypeId().equals("19")
					|| vo.getStrReqTypeId().equals("16") || vo.getStrReqTypeId().equals("18")) {

				sb.append("<tr bgcolor='#cdc9c9'> ");

				sb.append(
						"<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
				sb.append("</td>");

				sb.append(
						"<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No</b></font> ");
				sb.append("</td> ");

				sb.append(
						"<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Req Qty</b></font>");
				sb.append("</td> ");

				sb.append(
						"<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Approved Qty</b></font> ");
				sb.append("</td> ");

				sb.append(
						"<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font> ");
				sb.append("</td> ");

				// sb.append("<td align='center' width='5%'><font face='Verdana, Arial,
				// Helvetica, sans-serif' ><b>Remarks</b></font> ");
				// sb.append("</td> ");

				sb.append("</tr> ");

			} else {

				sb.append("<tr bgcolor='#cdc9c9'> ");

				sb.append(
						"<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
				sb.append("</td>");

				sb.append(
						"<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Req Qty</b></font>");
				sb.append("</td> ");

				sb.append(
						"<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Approved Qty</b></font> ");
				sb.append("</td> ");

				sb.append(
						"<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font> ");
				sb.append("</td> ");

				// sb.append("<td align='center' width='5%'><font face='Verdana, Arial,
				// Helvetica, sans-serif' ><b>Remarks</b></font> ");
				// sb.append("</td> ");

				sb.append("</tr> ");
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
						 * strProcIndentQty = ws1.getString(11); strProcIndentQtyUnit =
						 * ws1.getString(12); strProcSancQty = ws1.getString(13); strProcSancQtyUnitId =
						 * ws1.getString(14);
						 */
						// strCost = ws1.getString(15);
						// strItemSlNo = ws1.getString(17);
						// strStockStatusCode = ws1.getString(18);
						strBatchNo = ws1.getString(19);
						// strInHandQty = ws1.getString(20);
						strHiddenValue = strRate + "^" + strManufactrerDate + "^" + strExpDate;

					}

					if (vo.getStrReqTypeId().equals("11") || vo.getStrReqTypeId().equals("80")
							|| vo.getStrReqTypeId().equals("81") || vo.getStrReqTypeId().equals("83")
							|| vo.getStrReqTypeId().equals("84") || vo.getStrReqTypeId().equals("86")
							|| vo.getStrReqTypeId().equals("90")) {
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
						strHiddenValue = strLstPoNo + "^" + strLstPODate + "^" + strLstRecDate + "^" + strLstSupplBy
								+ "^" + strLstYerConsump + "^" + strReOrderLevel + "^" + strLstRecQty;

					}
					if (vo.getStrReqTypeId().equals("16") || vo.getStrReqTypeId().equals("19")) {
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
						strHiddenValue = strLstPoNo + "^" + strLstPODate + "^" + strLstRecDate + "^" + strExpDate + "^"
								+ strLstSupplBy + "^" + strGrpName + "^" + strSubGrpName;
					}

					if (vo.getStrReqTypeId().equals("15") || vo.getStrReqTypeId().equals("82")) {
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
						strHiddenValue = strLstPoNo + "^" + strLstPODate + "^" + strLstRecDate + "^" + strLstSupplBy
								+ "^" + strGrpName + "^" + strSubGrpName;
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
						strHiddenValue = strLstPoNo + "^" + strLstPODate + "^" + strLstRecDate + "^" + strGrpName + "^"
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
						strHiddenValue = strIssueQty + "^" + strReOrderLevel + "^" + strLstIndentQty + "^"
								+ strLstIssueQty;
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

						strHiddenValue = strLstPoNo + "^" + strLstPODate + "^" + strLstRecQty + "^" + strLstRecDate
								+ "^" + strLstSupplBy;
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

						strHiddenValue = strRate + "^" + strExpDate + "^" + strBatchNo + "^" + strItemId + "^"
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

					if (vo.getStrReqTypeId().equals("65") || vo.getStrReqTypeId().equals("19")
							|| vo.getStrReqTypeId().equals("16") || vo.getStrReqTypeId().equals("18")) {

						sb.append("<tr> ");

						sb.append(
								"<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
						sb.append(strItemName);
						sb.append("</font></td> ");

						sb.append(
								"<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
						sb.append(strBatchNo);
						sb.append("</font></td> ");

						sb.append(
								"<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
						sb.append(strReqQty);
						sb.append("</font></td> ");

						sb.append(
								"<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
						sb.append(strSancQty);
						sb.append("</font></td> ");

						sb.append(
								"<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
						sb.append(strRate);
						sb.append("</font></td> ");

						sb.append("</tr> ");

					} else {

						sb.append("<tr> ");
						sb.append(
								"<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
						sb.append(strItemName);
						sb.append("</font></td> ");

						sb.append(
								"<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
						sb.append(strReqQty);
						sb.append("</font></td> ");

						sb.append(
								"<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
						sb.append(strSancQty);
						sb.append("</font></td> ");

						sb.append(
								"<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
						sb.append(strRate);
						sb.append("</font></td> ");

						sb.append("</tr>");

					}
					i++;
				}
				sb.append("</table>");

			} else {
				sb.append("<table width='" + vo.getStrTableWidth()
						+ "' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
				sb.append("<tr>");

				sb.append(
						"<td colspan='5' align='center' ><DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div></TD>");
				sb.append("</tr>");
				sb.append("</table>");

			}

		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IssueDeskTransHLP.getItemDetailsViewPrint() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}

	public static String getIndentDetailsViewPrint(IssueDeskTransVO vo) {

		StringBuffer sb = new StringBuffer("");

		try {
			WebRowSet ws = vo.getStrIndentDetailsWs();
			// System.out.println("---Indent Size--"+ws.size());

			if (ws != null && ws.size() > 0) {
				if (ws.next()) {

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

					HisUtil hisutil = new HisUtil("", "");

					sb.append("<table width='" + vo.getStrTableWidth()
							+ "' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");

					sb.append("<tr>");
					sb.append("<td align='center' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><u>");
					sb.append(
							" Generated Without Issue On Date : [ " + hisutil.getASDate("dd-MMM-yyyy HH-mm-SS") + " ]");
					sb.append("</u></font></td>");
					sb.append("</tr>");

					sb.append("<tr>");
					sb.append("<td align='center' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><u>");
					sb.append(strIndentType);
					sb.append("</u></font></td>");
					sb.append("</tr>");

					sb.append("<tr>");
					sb.append(
							"<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Store Name:</b></font></td>");
					sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strStoreName);
					sb.append("</font></td> ");
					sb.append(
							"<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Category:</b></font></td>");
					sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strItemCatg);
					sb.append("</font></td> ");
					sb.append("</tr>");

					sb.append("<tr>");
					sb.append(
							"<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Indent No:</b></font></td>");
					sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strReqNo);
					sb.append("</font></td> ");
					sb.append(
							"<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Indent Date:</b></font></td>");
					sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strIndentDate);
					sb.append("</font></td> ");
					sb.append("</tr>");

					sb.append("<tr>");
					sb.append(
							"<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Indent Type:</b></font></td>");
					sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strIndentType);
					sb.append("</font></td> ");
					sb.append(
							"<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>To Store Name:</b></font></td>");
					sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strToStore);
					sb.append("</font></td> ");
					sb.append("</tr>");

					sb.append("<tr>");
					sb.append(
							"<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks:</b></font></td>");
					sb.append("<td align='left' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strAppRemarks);
					sb.append("</font></td> ");
					sb.append("</tr>");

					sb.append("</table>");

				}
			} else {
				sb.append("<table width='" + vo.getStrTableWidth()
						+ "' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
				sb.append("<tr>");
				sb.append(
						"<td colspan='5'><DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div></TD>");
				sb.append("</tr>");
				sb.append("</table>");

			}
		} catch (Exception e) {
			e.printStackTrace();
			vo.setStrMsgString("IssueDeskTransHLP.getIndentDetailsViewPrint() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}

}
