package dossier.transaction.controller.hlp;

import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;

import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import dossier.transaction.bo.DossierDeskTransBO;
import dossier.transaction.controller.fb.DossierDeskTransFB;
import dossier.transaction.vo.DossierDeskTransVO;

public class DossierDeskTransHLP {
	static int i = 0;

	/**
	 * This method is used to show item Details on ISSUE PAGE
	 * 
	 * @param wb
	 * @param strItemCategory
	 * @param strHospitalCode
	 * @return
	 */
	public static String getItemDetails(WebRowSet wb) throws SQLException {
		StringBuffer buff = null;
		try {
			buff = new StringBuffer();

			int count = 0;

			if (wb != null) {
				buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				buff.append("<tr>");
				buff.append("<td class='multiLabel'>Item Name</td>");
				// buff.append("<td class='multiLabel'>Sanction Qty.</td>");
				buff.append("<td class='multiLabel'>Sanction Qty.</td>");
				buff.append("</tr>");
				if (wb.size() != 0) {
					while (wb.next()) {
						buff.append("<tr>");
						buff.append("<td class='multiControl'>"
								+ wb.getString(1) + "</td>");
						// buff.append("<td class='multiControl'>"+wb.getString(2)+" "+wb.getString(3)+"</td>");
						buff.append("<td class='multiControl'><a  onclick='openSpecification(this,"
								+ (++count)
								+ ");' style='color:blue; cursor:pointer;' title='Click Here To View Detail' >"
								+ wb.getString(4)
								+ " "
								+ wb.getString(3)
								+ "</a>");
						buff.append("<input type='hidden' name='strItemDtl' id='strItemDtl"
								+ count
								+ "' value='"
								+ wb.getString(2)
								+ "@"
								+ wb.getString(3)
								+ "@"
								+ wb.getString(5)
								+ "'>");
						buff.append("</td>");
						buff.append("</tr>");
					}
					buff.append("</table>");
				} else {
					buff.append("<tr>");
					buff.append("<td class='multiControl' colspan='3'><font color='red'>No Record Found/Patient is not admitted</font></td>");
					buff.append("</tr>");
				}
			}

		} catch (Exception _err) {
			try {
				_err.printStackTrace();
				throw new Exception("LPIssueDeskTransHLP---->getItemDetails"
						+ _err.getMessage());
			} catch (Exception e) {

			}
		}

		return buff.toString();
	}

	/**
	 * This method is used to show item Details on ISSUE PAGE
	 * 
	 * @param wb
	 * @param strItemCategory
	 * @param strHospitalCode
	 * @return
	 */
	public static String getIssueItemDetails(WebRowSet wb, String strCostReq,
			String strIssueStoreID, String hosCode, String strRaisingStoreId,
			String lpReqNo, DossierDeskTransVO voObj) throws SQLException {
		StringBuffer buff = null;
		Double itemFinalCost = 0.0;
		DossierDeskTransVO vo = null;
		DossierDeskTransBO bo = null;
		try {
			vo = new DossierDeskTransVO();
			bo = new DossierDeskTransBO();
			buff = new StringBuffer();
			String strRate = "";
			String strRateUnit = "";
			String strManuFacturingDate = "";
			String strExpiryDate = "";
			String strInHandQty = "";
			String strRateBaseValue = "";
			String strItemId = "";
			String strItemBrandId = "";
			String strBatchSlNo = "";
			String strIssueQty = "";
			String strIssueUnitId = "";
			String strItemName = "";
			String strUnitName = "";
			String hiddenParam = "";
			String avlQty = "";
			String temp[] = null;
			Double itemCost = 0.00;
			String strTotalNoOfBatch = "";
			String strMRP;
			String strItemCat;
			String strHiddenId = ""; // item id^brandid^RESERVED
										// FLAG^GROUPID^SUBGROUP ID^CONSUMABLE
										// FLAG^strItemCategory^strRaisingStoreId
			String TariffFlag = "0";
			WebRowSet brandWs = null;
			int i = 0;

			if (wb != null) {

				buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				buff.append("<tr>");
				buff.append("<td width='20%' class='multiLabel' align='left'>Item Name</td>");
				// buff.append("<td class='multiLabel'>Batch/Sl.no.</td>");
				// buff.append("<td class='multiLabel'>Expiry Date</td>");
				buff.append("<td width='10%' class='multiLabel' align='left'>Available Qty</td>");
				buff.append("<td width='10%' class='multiLabel' align='left'>Request Qty</td>");
				// buff.append("<td class='multiLabel'>Rate/Unit</td>");
				buff.append("<td width='10%' class='multiLabel' align='left'>Issue Qty</td>");
				// buff.append("<td width='10%' class='multiLabel' align='left'>Batch</td>");
				// buff.append("<td width='10%' class='multiLabel' align='left'>Expiry</td>");
				// buff.append("<td width='10%' class='multiLabel' align='left'>M.R.P.</td>");
				/*
				 * if(lpReqNo.equals("0")) buff.append(
				 * "<td width='10%' class='multiLabel' align='left'>LP Qty</td>"
				 * );
				 */
				// buff.append("<td width='10%' class='multiLabel' align='left'>Remarks</td>");
				// if(strCostReq.equals("1"))
				// buff.append("<td class='multiLabel'>Item Cost</td>");
				buff.append("</tr>");
				if (wb.size() != 0) {

					while (wb.next()) {

						i++;
						// temp=wb.getString(6).replace('^', '#').split("#");
						// strRate=temp[0];
						// strRateUnit=temp[1];
						// strManuFacturingDate=temp[2];
						// strExpiryDate=temp[3];
						// strInHandQty=temp[4];
						// strRateBaseValue=temp[5];
						// avlQty=temp[6];
						strItemId = wb.getString(1);
						strItemBrandId = wb.getString(2);
						avlQty = wb.getString(6);
						strBatchSlNo = wb.getString(9);
						strIssueQty = wb.getString(3);
						strIssueUnitId = wb.getString(4);
						strItemName = wb.getString(7);
						strUnitName = wb.getString(5);
						strHiddenId = wb.getString(1) + "^" + wb.getString(2); // item
																				// id^brand
																				// id
						// strTotalNoOfBatch = wb.getString(8);
						strMRP = wb.getString(11) == null ? "0" : wb
								.getString(11);
						strItemCat = wb.getString(12) == null ? "0" : wb
								.getString(12);
						// if(lpReqNo.equals("0"))
						TariffFlag = "1";// wb.getString(12);
						vo.setStrHospitalCode(hosCode);
						voObj.setStrItemId(strItemId);
						if (Float.parseFloat(avlQty) < Float
								.parseFloat(strIssueQty)) {
							bo.getBrandDetails(voObj);
							brandWs = voObj.getBrandDtlWs();
						}

						// if (Integer.parseInt(strTotalNoOfBatch) <= 1) { //
						// Item ID ^ ItemBrand Id ^ Batch No ^ StoreID
						// vo.setStrSingleItemDtl(strHiddenId.split("\\^")[0]+
						// "^" + strHiddenId.split("\\^")[1] + "^"+
						// wb.getString(9) + "^" + strIssueStoreID);
						// bo.getSingleBatchItemDtl(vo);
						// }
						// itemCost=(Double.parseDouble(strRate)/Double.parseDouble(strRateBaseValue))*Double.parseDouble(strInHandQty);

						hiddenParam = strItemId + "@" + strItemBrandId + "@"
								+ strIssueQty + "@" + strIssueUnitId + "@"
								+ avlQty + "@" + strBatchSlNo + "@" + strMRP
								+ "@" + strItemCat;
						if (!strRate.equals("0") && !strRateUnit.equals("0")
								&& !strManuFacturingDate.equals("0")
								&& !strInHandQty.equals("0")
								&& !avlQty.equals("0")) {
							buff.append("<tr>");
							buff.append("<td width='30%' class='multiControl'><div id='itmNm"
									+ i
									+ "'> "
									+ strItemName
									+ " </div><input type='hidden' id='strItemParamValue"
									+ i
									+ "' name='strItemParamValue' value='"
									+ hiddenParam + "' /></td>");
							// buff.append("<td class='multiControl'>"+strBatchSlNo+"</td>");
							// buff.append("<td class='multiControl'><font color='red'>"+strExpiryDate+"</font></td>");
							if ((Float.parseFloat(avlQty) >= Float
									.parseFloat(strIssueQty))
									|| (brandWs.size() == 0))
								buff.append("<td width='10%' class='multiControl' align='left'><input type='hidden' name='brandHiddenVal' id = 'brandHiddenVal"
										+ i
										+ ""
										+ 1
										+ "' value='"
										+ 0
										+ "^"
										+ 0
										+ "^"
										+ 0
										+ "^"
										+ 0
										+ "^"
										+ 0
										+ "^"
										+ 0
										+ "' > <div id='availQty"
										+ i
										+ "'>" + avlQty + "</div></td>");
							else if ((brandWs.size() == 1)) {
								brandWs.next();
								buff.append("<td width='10%' class='multiControl' align='left'><input type='hidden' name='brandHiddenVal' id = 'brandHiddenVal"
										+ i
										+ ""
										+ 1
										+ "' value='"
										+ brandWs.getString(1)
										+ "^"
										+ brandWs.getString(2)
										+ "^"
										+ brandWs.getString(3)
										+ "^"
										+ brandWs.getString(4)
										+ "^"
										+ brandWs.getString(5)
										+ "^"
										+ brandWs.getString(6)
										+ "' > <div id='availQty"
										+ i
										+ "'>"
										+ avlQty + "</div></td>");
							} else {
								buff.append("<TD WIDTH='10%' id='td99"
										+ i
										+ "' CLASS='multiPOControl'  ><input type='hidden' name='brandDtlsId' id='brandDtlsId"
										+ i
										+ "' value='' >"
										+ "<div name='brandDtl' id='brandDtl"
										+ i
										+ "'></div>"
										+ "<div id='availQty"
										+ i
										+ "'><a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callBrandDetails(\""
										+ i
										+ "\");' TITLE='Click Here For other brand names available in store' ><div 'autodiv"
										+ i + "'>auto</div></a></div>");

								buff.append("<div id = 'divBrandDtlId"
										+ i
										+ "' class='popup' style='display: none; left:500px; top:210px;' >");
								buff.append("<table width='500' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");

								if (brandWs.size() != 0) {
									buff.append("<tr class='HEADER' ><td colspan=7 align='left'>Item Name : "
											+ strItemName
											+ " with sanctioned qty. : "
											+ strIssueQty + " </td></tr> ");
									buff.append("<tr class='HEADER'>");

									// buff.append("</tr>");
									// buff.append("</table>");
									// buff.append("<table width='700' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
									// buff.append("<tr>");
									buff.append("<td width='70%' class='multiLabel'><div align='left'> Alternate Items</div>");
									buff.append("</td><td width='20%' class='multiLabel'>Avl. Qty");

									buff.append("</td><td width='5%' class='multiLabel'>#");
									buff.append("</td>");
									buff.append("<th align='right' colspan=7><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp Window' src='../../hisglobal/images/popUp_cancel.JPG'");
									buff.append(" onClick='hide_popup_menu(\"divBrandDtlId"
											+ i + "");
									// buff.append(nTmpI);
									buff.append("\");'></th></tr>");
									buff.append("</table>");
									buff.append("<table width='500' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
									int j = 0;
									while (brandWs.next()) {
										j++;
										if (j == 1) {
											buff.append("<tr>");
											buff.append("<td width='50%' class='multiControl'><input type='hidden' name='brandHiddenVal' id = 'brandHiddenVal"
													+ i
													+ ""
													+ j
													+ "' value='"
													+ brandWs.getString(1)
													+ "^"
													+ brandWs.getString(2)
													+ "^"
													+ brandWs.getString(3)
													+ "^"
													+ brandWs.getString(4)
													+ "^"
													+ brandWs.getString(5)
													+ "^"
													+ brandWs.getString(6)
													+ "' > ");
											buff.append("<div align='left'>"
													+ brandWs.getString(4)
													+ "</div> ");
											buff.append("</td><td width='20%' class='multiControl'>");
											buff.append(brandWs.getString(3));
											buff.append("</td><td width='10%' class='multiLabel'><input type='radio' onclick='setItemDtl("
													+ i
													+ ","
													+ i
													+ ""
													+ j
													+ ")' name='strBrandDtlsChk' id='strBrandDtlsChk"
													+ i + "' > ");
											buff.append("</td></tr>");
										} else {
											// if(Float.parseFloat(brandWs.getString(3))
											// >= Float.parseFloat(strIssueQty))
											// {
											buff.append("<tr>");
											buff.append("<td width='50%' class='multiControl'><input type='hidden' name='brandHiddenVal' id = 'brandHiddenVal"
													+ i
													+ ""
													+ j
													+ "' value='"
													+ brandWs.getString(1)
													+ "^"
													+ brandWs.getString(2)
													+ "^"
													+ brandWs.getString(3)
													+ "^"
													+ brandWs.getString(4)
													+ "^"
													+ brandWs.getString(5)
													+ "^"
													+ brandWs.getString(6)
													+ "' > ");
											buff.append("<div align='left'>"
													+ brandWs.getString(4)
													+ "</div> ");
											buff.append("</td><td width='20%' class='multiControl'>");
											buff.append(brandWs.getString(3));
											buff.append("</td><td width='10%' class='multiLabel'><input type='radio' onclick='setItemDtl("
													+ i
													+ ","
													+ i
													+ ""
													+ j
													+ ")' name='strBrandDtlsChk' id='strBrandDtlsChk"
													+ i + "' > ");
											buff.append("</td></tr>");
											// }
										}

									}
								} else {
									// buff.append("<div id = 'divBrandDtlId"+i+"' class='popup' style='display: none; left:500px; top:170px;'>");
									// buff.append("<table width='300' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
									buff.append("<tr class='HEADER'>");
									buff.append("<th align='right' colspan=4><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp Window' src='../../hisglobal/images/popUp_cancel.JPG'");
									buff.append("onClick='hide_popup_menu(\"divBrandDtlId"
											+ i + "");
									// buff.append(nTmpI);
									buff.append("\");'></th>");
									buff.append("</tr>");
									buff.append("</table>");
									buff.append("<table width='300' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
									buff.append("<tr>");
									buff.append("<td colspan='3'  CLASS='multiControl' ><DIV class='errMsg' align='center'>No Record Found</div></TD>");
									buff.append("</tr>");

								}
								// buff.append("<tr><td class='multiControl' colspan='7' align='center' ><img style='cursor: pointer;' src='../../hisglobal/images/ok.gif' onClick='closePopUpDiv(this,"+i+");' /></td></tr>");
								buff.append("<tr class='HEADER'><td colspan='7' align='left' ><font color='white'>Items marked with * are non branded</font></td></tr>");
								buff.append("</table>");
								buff.append("</div>");
							}
							buff.append("</td>");
							buff.append("<td width='10%' width='10%' class='multiControl' align='left'>"
									+ strIssueQty + " " + strUnitName + "</td>");
							// buff.append("<td class='multiControl'>"+strRate+"/ "+strUnitName+"</td>");
							if (lpReqNo.equals("0"))
								if (Integer.parseInt(TariffFlag) > 0)
									buff.append("<td width='10%' class='multiControl' align='left'><input type='text' class='txtFldNormal' id='strIssueQuantity"
											+ i
											+ "' name='strIssueQuantity' value='"
											+ (Double.parseDouble(strIssueQty
													.split(" ")[0]) <= Double
													.parseDouble(avlQty
															.split(" ")[0]) ? strIssueQty
													.split(" ")[0] : "")
											+ "' onkeypress='return validateData(event,7);' onkeyup='QtyValidation("
											+ i + ")'></td>");
								else
									buff.append("<td width='10%' class='multiControl' align='left'><input type='text' disabled=true class='txtFldNormal' id='strIssueQuantity"
											+ i
											+ "' name='strIssueQuantity' value='0.00' onkeypress='return validateData(event,7);' onkeyup='QtyValidation("
											+ i + ")'></td>");
							else
								buff.append("<td width='10%' class='multiControl' align='left'><input type='text' class='txtFldNormal' id='strIssueQuantity"
										+ i
										+ "' name='strIssueQuantity' value='"
										+ (Double.parseDouble(strIssueQty
												.split(" ")[0]) <= Double
												.parseDouble(avlQty.split(" ")[0]) ? strIssueQty
												.split(" ")[0] : "")
										+ "' onkeypress='return validateData(event,7);' onkeyup='QtyValidation("
										+ i + ")'></td>");
							// if(strCostReq.equals("1"))
							// buff.append("<td class='multiControl'>"+HisUtil.getAmountWithDecimal(itemCost,
							// 2)+"</td>");
							/*
							 * buff.append(
							 * "<input type='hidden' name='strTotalBatch' id='strTotalBatch"
							 * + i + "' value='" + strTotalNoOfBatch + "' />");
							 * 
							 * buff.append(
							 * "<input type='hidden' name='strTotBatch' id='strTotBatch"
							 * + i + "' value='" + strTotalNoOfBatch + "' />");
							 * 
							 * buff.append(
							 * " <input type='hidden' name='strAvlQtyForChk' id='strAvlQtyForChk"
							 * + i + "' value=" + avlQty + " />");
							 * 
							 * buff.append(
							 * " <input type='hidden' name='strIssueUnitId' id='strIssueUnitId"
							 * + i + "' value='6301^0^1' />");
							 * 
							 * buff.append(
							 * " <input type='hidden' name='strItemDetailsChk' id='strItemDetailsChk"
							 * + i + "' value= '" + strHiddenId + "^" +
							 * strItemBrandId.substring(0,2) + "^" +
							 * strRaisingStoreId + "' /> ");
							 * 
							 * if (Integer.parseInt(strTotalNoOfBatch) > 1) {
							 * buff.append(
							 * "<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
							 * + i + "' value='' />");
							 * 
							 * 
							 * buff.append(
							 * "<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strSingleBatch'      id='strSingleBatch"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strSingleMfgName'    id='strSingleMfgName"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strProgrammeName'    id='strProgrammeName"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strSingleStockRate'  id='strSingleStockRate"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strStockQty'         id='strStockQty"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strStockRate'        id='strStockRate"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strCheckBatchExists' id='strCheckBatchExists"
							 * + i + "' value='1' />");
							 * buff.append("<TD WIDTH='9%' id='td9" + i +
							 * "' CLASS='multiPOControl'  ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
							 * + i + "' value='' />" +
							 * "<div name='issueDrugDtl' id='issueDrugDtl" + i +
							 * "'></div>" +
							 * " <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
							 * + i +
							 * "\");' TITLE='Click Here For Item Preferences' >auto</TD>"
							 * );
							 * 
							 * buff.append("<TD WIDTH='9%' id='td8" + i +
							 * "' CLASS='multiPOControl' style=\"text-align:center;\" ><div name='expDrugDtl' id='expDrugDtl"
							 * + i + "'></div></TD>");
							 * buff.append("<TD WIDTH='9%' id='td10" + i +
							 * "' CLASS='multiPOControl' style=\"text-align:center;\" ><div name='mrpDtl' id='mrpDtl"
							 * + i + "'></div></TD>");
							 * 
							 * } else {
							 * 
							 * if (vo.getStrSingleBatchDtlWs().next()) {
							 * 
							 * 
							 * buff.append(
							 * "<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
							 * + i + "' value='" +
							 * vo.getStrSingleBatchDtlWs().getString(13) +
							 * "' />"); buff.append(
							 * "<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
							 * + i + "' value='" +
							 * vo.getStrSingleBatchDtlWs().getString(11) +
							 * "' />"); buff.append(
							 * "<input type='hidden' name='strTotBatch' id='strTotBatch"
							 * + i + "' value='" + strTotalNoOfBatch + "' />");
							 * buff.append(
							 * "<input type='hidden' name='strStockRate'        id='strStockRate"
							 * + i+ "' value='"+
							 * vo.getStrSingleBatchDtlWs().getString(6)+
							 * "' />"); buff.append(
							 * "<input type='hidden' name='strStockQty'         id='strStockQty"
							 * + i+ "' value='"+
							 * vo.getStrSingleBatchDtlWs().getString
							 * (7).split("\\^")[0] + "' />"); buff.append(
							 * "<input type='hidden' name='strSingleStockRate'        id='strSingleStockRate"
							 * + i+ "' value='"+
							 * vo.getStrSingleBatchDtlWs().getString(9)+
							 * "' />");
							 * 
							 * 
							 * 
							 * buff.append(
							 * "<input type='hidden' name='strSingleBatch'      id='strSingleBatch"
							 * + i + "' value='" +
							 * vo.getStrSingleBatchDtlWs().getString(3) +
							 * "' />"); buff.append(
							 * "<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"
							 * + i + "' value='" +
							 * vo.getStrSingleBatchDtlWs().getString(5) +
							 * "' />"); buff.append(
							 * "<input type='hidden' name='strSingleMfgName'     id='strSingleMfgName"
							 * + i + "' value='" +
							 * vo.getStrSingleBatchDtlWs().getString(8) +
							 * "' />"); buff.append(
							 * "<input type='hidden' name='strProgrammeName'     id='strProgrammeName"
							 * + i + "' value='" +
							 * vo.getStrSingleBatchDtlWs().getString(12) +
							 * "' />"); buff.append("<TD WIDTH='9%' id='td8" + i
							 * +
							 * "' CLASS='multiPOControl' style=\"text-align:center;\" >"
							 * + vo.getStrSingleBatchDtlWs().getString(3) +
							 * "</TD>"); buff.append("<TD WIDTH='9%'  id='td9" +
							 * i +
							 * "' CLASS='multiPOControl' style=\"text-align:center;\"   >"
							 * + ((vo.getStrSingleBatchDtlWs() .getString(5) ==
							 * null || vo .getStrSingleBatchDtlWs()
							 * .getString(5).equals("")) ? "NA" :
							 * vo.getStrSingleBatchDtlWs() .getString(5)) +
							 * "</TD>"); buff.append(
							 * "<td width='10%' id='td10' class='multiPOControl' align='center'>"
							 * +strMRP+"</td>"); } else {
							 * 
							 * 
							 * buff.append(
							 * "<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
							 * + i + "' value='' />");
							 * 
							 * buff.append(
							 * "<input type='hidden' name='strTotBatch' id='strTotBatch"
							 * + i + "' value='" + strTotalNoOfBatch + "' />");
							 * 
							 * buff.append(
							 * "<input type='hidden' name='strSingleBatch'      id='strSingleBatch"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strSingleMfgName'    id='strSingleMfgName"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strProgrammeName'    id='strProgrammeName"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strSingleStockRate'  id='strSingleStockRate"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strStockQty'         id='strStockQty"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strStockRate'        id='strStockRate"
							 * + i + "' value='' />");
							 * buff.append("<TD WIDTH='9%' id='td8" + i +
							 * "' CLASS='multiPOControl' style=\"text-align:center;\" > </TD>"
							 * ); buff.append("<TD WIDTH='9%'  id='td9" + i +
							 * "' CLASS='multiPOControl' style=\"text-align:center;\" ></TD>"
							 * ); buff.append("<TD WIDTH='9%'  id='td10" + i +
							 * "' CLASS='multiPOControl' style=\"text-align:center;\" ></TD>"
							 * );
							 * 
							 * } buff.append(
							 * "<input type='hidden' name='strCheckBatchExists'        id='strCheckBatchExists"
							 * + i + "' value='0' />"); buff.append(
							 * "<input type='hidden' name='stockDtlsId' id='stockDtlsId"
							 * + i + "' value='' />");
							 * 
							 * }
							 * 
							 * buff.append(
							 * "<input type='hidden' disabled='disabled' class='txtFldNormal'  value='0.00' name='finalCostDivId' id='finalCostDivId"
							 * + i + "' >"); buff.append(
							 * "<input type='hidden' name='strFinalCost' id='strFinalCost"
							 * + i + "' value='0.00' />");
							 */
							// buff.append("<td width='10%' class='multiControl' align='left'></td>");
							/*
							 * if(lpReqNo.equals("0")) buff.append(
							 * "<td width='10%' class='multiControl' align='left'><input type='text' autocomplete='off' class='txtFldNormal' id='strBSQuantity"
							 * +i+
							 * "' name='strBSQuantity' value='' onkeypress='return validateData(event,7);' onkeyup='QtyValidation("
							 * +i+")'></td>");
							 */

							// buff.append("<td class='multiControl' id='td9"
							// + i
							// +
							// "'  width='5%'><a value='' style='cursor:pointer;'   onClick='openDivItem(this,"
							// + i
							// +
							// ");' title='Click here to Enter Remarks'><font color='blue'  style='cursor:pointer;'>#</font></a>");
							// buff.append("<div id='remarksId" + i
							// + "' class='popup' style='display:none'>");
							// buff.append("<table width='400' align='center'>");
							// buff.append("<tr class='HEADER' style='font-family: Arial, Helvetica, sans-serif;font-size:13px;'><th align='left' >Remarks For "
							// + strItemName + "</th>");
							// buff.append("<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/stop.png'");
							// buff.append(" onClick='closeDivItem("
							// + i
							// +
							// ");' title='Click Here To Close Popup' ></th></tr>");
							// buff.append("</table>");
							// buff.append("<table width='400' align='center' cellspacing='0px' cellpadding='1px'>");
							// buff.append("<tr><td class='LABEL' width='50%'><div id='remarksLabelId"
							// + i + "'>Remarks</div></td>");
							// buff.append("<td class='CONTROL' width='50%'><textarea name='strItemRemarks' id='strItemRemarks"
							// + i + "'></textarea></td>");
							// buff.append("</tr>");
							// buff.append("<tr class='FOOTER'><td colspan='2'></td></tr>");
							// buff.append("<tr ><td colspan='2' class='CONTROL'>");
							// buff.append("<div><div class='legends'></div>");
							// buff.append("<div class='control_button'><table border='0' width='100%' align='center'> ");
							// buff.append("<tr> ");
							// buff.append("<td align='center'><div><a href='#' class='button'  title='Click Here To Save Remarks For Item' onClick='closeDivItem("
							// + i + ");'><span class='ok'>Ok</span></a>");
							// buff.append("<div></td> ");
							// buff.append(" </tr> ");
							// buff.append(" </table></div></div> ");
							// buff.append("</td></tr>");
							// buff.append("</table>");
							// buff.append("</div></td>");
							// buff.append("</tr>");
							//
							// buff.append("</TR>");
							// buff.append("</div>");

							buff.append("</tr>");
							// itemFinalCost+=itemCost;
						} else {
							buff.append("<tr>");
							buff.append("<td width='30%' class='multiControl'>"
									+ strItemName
									+ "<input type='hidden' id='strItemParamValue"
									+ i + "' name='strItemParamValue' value='"
									+ hiddenParam + "' /></td>");
							// buff.append("<td class='multiControl'>"+strBatchSlNo+"</td>");
							// buff.append("<td class='multiControl'><font color='red'>"+strExpiryDate+"</font></td>");
							buff.append("<td width='10%' class='multiControl' align='left'>"
									+ avlQty + "</td>");
							buff.append("<td width='10%' class='multiControl' align='left'>"
									+ strIssueQty + " " + strUnitName + "</td>");
							// buff.append("<td class='multiControl'>"+strRate+"/ "+strUnitName+"</td>");
							System.out.println(Double.parseDouble(avlQty
									.split(" ")[0]));
							buff.append("<td width='10%' class='multiControl' align='left'><input type='text' class='txtFldNormal' id='strIssueQuantity"
									+ i
									+ "' name='strIssueQuantity' value='"
									+ (Double.parseDouble(avlQty.split(" ")[0]) != 0.0 ? avlQty
											.split(" ")[0] : "0.00")
									+ "' onkeypress='return validateData(event,7);' onkeyup='QtyValidation("
									+ i + ")'></td>");
							// if(strCostReq.equals("1"))
							// buff.append("<td class='multiControl'>"+HisUtil.getAmountWithDecimal(itemCost,
							// 2)+"</td>");
							/*
							 * buff.append(
							 * "<input type='hidden' name='strTotalBatch' id='strTotalBatch"
							 * + i + "' value='" + strTotalNoOfBatch + "' />");
							 * 
							 * buff.append(
							 * "<input type='hidden' name='strTotBatch' id='strTotBatch"
							 * + i + "' value='" + strTotalNoOfBatch + "' />");
							 * 
							 * if (Integer.parseInt(strTotalNoOfBatch) > 1) {
							 * buff.append(
							 * "<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
							 * + i + "' value='' />");
							 * 
							 * 
							 * buff.append(
							 * "<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strSingleBatch'      id='strSingleBatch"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strSingleMfgName'    id='strSingleMfgName"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strProgrammeName'    id='strProgrammeName"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strSingleStockRate'  id='strSingleStockRate"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strStockQty'         id='strStockQty"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strStockRate'        id='strStockRate"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strCheckBatchExists' id='strCheckBatchExists"
							 * + i + "' value='1' />");
							 * buff.append("<TD WIDTH='9%' id='td9" + i +
							 * "' CLASS='multiPOControl'  ><input type='hidden' name='stockDtlsId' id='stockDtlsId"
							 * + i + "' value='' />" +
							 * "<div name='issueDrugDtl' id='issueDrugDtl" + i +
							 * "'></div>" +
							 * " <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callStockDetails(this,\""
							 * + i +
							 * "\");' TITLE='Click Here For Item Preferences' >auto</TD>"
							 * );
							 * 
							 * buff.append("<TD WIDTH='9%' id='td8" + i +
							 * "' CLASS='multiPOControl' style=\"text-align:center;\" ><div name='expDrugDtl' id='expDrugDtl"
							 * + i + "'></div></TD>");
							 * buff.append("<TD WIDTH='9%' id='td10" + i +
							 * "' CLASS='multiPOControl' style=\"text-align:center;\" ><div name='mrpDtl' id='mrpDtl"
							 * + i + "'></div></TD>");
							 * 
							 * } else {
							 * 
							 * if (vo.getStrSingleBatchDtlWs().next()) {
							 * 
							 * 
							 * buff.append(
							 * "<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
							 * + i + "' value='" +
							 * vo.getStrSingleBatchDtlWs().getString(13) +
							 * "' />"); buff.append(
							 * "<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
							 * + i + "' value='" +
							 * vo.getStrSingleBatchDtlWs().getString(11) +
							 * "' />"); buff.append(
							 * "<input type='hidden' name='strTotBatch' id='strTotBatch"
							 * + i + "' value='" + strTotalNoOfBatch + "' />");
							 * buff.append(
							 * "<input type='hidden' name='strStockRate'        id='strStockRate"
							 * + i+ "' value='"+
							 * vo.getStrSingleBatchDtlWs().getString(6)+
							 * "' />"); buff.append(
							 * "<input type='hidden' name='strStockQty'         id='strStockQty"
							 * + i+ "' value='"+
							 * vo.getStrSingleBatchDtlWs().getString
							 * (7).split("\\^")[0] + "' />"); buff.append(
							 * "<input type='hidden' name='strSingleStockRate'        id='strSingleStockRate"
							 * + i+ "' value='"+
							 * vo.getStrSingleBatchDtlWs().getString(9)+
							 * "' />");
							 * 
							 * 
							 * 
							 * buff.append(
							 * "<input type='hidden' name='strSingleBatch'      id='strSingleBatch"
							 * + i + "' value='" +
							 * vo.getStrSingleBatchDtlWs().getString(3) +
							 * "' />"); buff.append(
							 * "<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"
							 * + i + "' value='" +
							 * vo.getStrSingleBatchDtlWs().getString(5) +
							 * "' />"); buff.append(
							 * "<input type='hidden' name='strSingleMfgName'     id='strSingleMfgName"
							 * + i + "' value='" +
							 * vo.getStrSingleBatchDtlWs().getString(8) +
							 * "' />"); buff.append(
							 * "<input type='hidden' name='strProgrammeName'     id='strProgrammeName"
							 * + i + "' value='" +
							 * vo.getStrSingleBatchDtlWs().getString(12) +
							 * "' />"); buff.append("<TD WIDTH='9%' id='td8" + i
							 * +
							 * "' CLASS='multiPOControl' style=\"text-align:center;\" >"
							 * + vo.getStrSingleBatchDtlWs().getString(3) +
							 * "</TD>"); buff.append("<TD WIDTH='9%'  id='td9" +
							 * i +
							 * "' CLASS='multiPOControl' style=\"text-align:center;\"   >"
							 * + ((vo.getStrSingleBatchDtlWs() .getString(5) ==
							 * null || vo .getStrSingleBatchDtlWs()
							 * .getString(5).equals("")) ? "NA" :
							 * vo.getStrSingleBatchDtlWs() .getString(5)) +
							 * "</TD>"); buff.append(
							 * "<td width='10%' id='td10' class='multiControl' align='center'>"
							 * +strMRP+"</td>"); } else {
							 * 
							 * 
							 * buff.append(
							 * "<input type='hidden' name='strSingleManufId'      id='strSingleManufId"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strSingleProgId'      id='strSingleProgId"
							 * + i + "' value='' />");
							 * 
							 * buff.append(
							 * "<input type='hidden' name='strTotBatch' id='strTotBatch"
							 * + i + "' value='" + strTotalNoOfBatch + "' />");
							 * 
							 * buff.append(
							 * "<input type='hidden' name='strSingleBatch'      id='strSingleBatch"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strSingleExpiry'     id='strSingleExpiry"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strSingleMfgName'    id='strSingleMfgName"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strProgrammeName'    id='strProgrammeName"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strSingleStockRate'  id='strSingleStockRate"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strStockQty'         id='strStockQty"
							 * + i + "' value='' />"); buff.append(
							 * "<input type='hidden' name='strStockRate'        id='strStockRate"
							 * + i + "' value='' />");
							 * buff.append("<TD WIDTH='9%' id='td8" + i +
							 * "' CLASS='multiPOControl' style=\"text-align:center;\" > </TD>"
							 * ); buff.append("<TD WIDTH='9%'  id='td9" + i +
							 * "' CLASS='multiPOControl' style=\"text-align:center;\" ></TD>"
							 * ); buff.append("<TD WIDTH='9%'  id='td10" + i +
							 * "' CLASS='multiPOControl' style=\"text-align:center;\" ></TD>"
							 * ); } buff.append(
							 * "<input type='hidden' name='strCheckBatchExists'        id='strCheckBatchExists"
							 * + i + "' value='0' />"); buff.append(
							 * "<input type='hidden' name='stockDtlsId' id='stockDtlsId"
							 * + i + "' value='' />");
							 * 
							 * }
							 * 
							 * buff.append(
							 * "<input type='hidden' disabled='disabled' class='txtFldNormal'  value='0.00' name='finalCostDivId' id='finalCostDivId"
							 * + i + "' >"); buff.append(
							 * "<input type='hidden' name='strFinalCost' id='strFinalCost"
							 * + i + "' value='0.00' />");
							 */
							// buff.append("<td width='10%' class='multiControl' align='left'></td>");
							/*
							 * if(lpReqNo.equals("0")) buff.append(
							 * "<td width='10%' class='multiControl' align='left'><input type='text' class='txtFldNormal' id='strBSQuantity"
							 * +i+
							 * "' name='strBSQuantity' value='' onkeypress='return validateData(event,7);' onkeyup='QtyValidation("
							 * +i+")'></td>");
							 */
							// buff.append("<td class='multiControl' id='td9"
							// + i
							// +
							// "'  width='5%'><a value='' style='cursor:pointer;'   onClick='openDivItem(this,"
							// + i
							// +
							// ");' title='Click here to Enter Remarks'><font color='blue'  style='cursor:pointer;'>#</font></a>");
							// buff.append("<div id='remarksId" + i
							// + "' class='popup' style='display:none'>");
							// buff.append("<table width='400' align='center'>");
							// buff.append("<tr class='HEADER' style='font-family: Arial, Helvetica, sans-serif;font-size:13px;'><th align='left' >Remarks For "
							// + strItemName + "</th>");
							// buff.append("<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/stop.png'");
							// buff.append(" onClick='closeDivItem("
							// + i
							// +
							// ");' title='Click Here To Close Popup' ></th></tr>");
							// buff.append("</table>");
							// buff.append("<table width='400' align='center' cellspacing='0px' cellpadding='1px'>");
							// buff.append("<tr><td class='LABEL' width='50%'><div id='remarksLabelId"
							// + i + "'>Remarks</div></td>");
							// buff.append("<td class='CONTROL' width='50%'><textarea name='strItemRemarks' id='strItemRemarks"
							// + i + "'></textarea></td>");
							// buff.append("</tr>");
							// buff.append("<tr class='FOOTER'><td colspan='2'></td></tr>");
							// buff.append("<tr ><td colspan='2' class='CONTROL'>");
							// buff.append("<div><div class='legends'></div>");
							// buff.append("<div class='control_button'><table border='0' width='100%' align='center'> ");
							// buff.append("<tr> ");
							// buff.append("<td align='center'><div><a href='#' class='button'  title='Click Here To Save Remarks For Item' onClick='closeDivItem("
							// + i + ");'><span class='ok'>Ok</span></a>");
							// buff.append("<div></td> ");
							// buff.append(" </tr> ");
							// buff.append(" </table></div></div> ");
							// buff.append("</td></tr>");
							// buff.append("</table>");
							// buff.append("</div></td>");
							// buff.append("</tr>");
							//
							// buff.append("</TR>");
							// buff.append("</div>");

							buff.append("</tr>");

						}

					}

					buff.append("</table>");

					if (strCostReq.equals("1")) {
						buff.append("<div>");
					} else {
						buff.append("<div style='display:none'>");
					}
					buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
					buff.append("<tr>");
					buff.append("<td bgcolor='black' colspan='6'></td>");
					buff.append("</tr>");
					buff.append("<tr>");
					buff.append("<td class='multiControl' colspan='5' width='88%'><div align='right'><b>TOTAL COST</b></div></td>");
					buff.append("<td class='multiControl' colspan='1' width='12%'><input type='hidden' name='strFinalCosttt' value='"
							+ itemFinalCost
							+ "'/>"
							+ "<font color='red'><b>Rs."
							+ Math.round(itemFinalCost) + "</b></font></td>");
					buff.append("</tr>");
					buff.append("<tr>");
					buff.append("<td bgcolor='black' colspan='6'></td>");
					buff.append("</tr>");
					buff.append("</table>");
					buff.append("</div>");
				} else {

					buff.append("<tr>");
					if (strCostReq.equals("1")) {
						buff.append("<td class='multiControl' colspan='6'><font color='red'>No Record Found/Patient is not admitted</font></td>");
					} else {
						buff.append("<td class='multiControl' colspan='5'><font color='red'>No Record Found/Patient is not admitted</font></td>");
					}
					buff.append("</tr>");
					buff.append("</table>");
				}
			}
			// else
			//
			// {
			// buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
			// buff.append("<tr>");
			// buff.append("<td class='multiLabel'>Patient is not Admitted</td></tr></table>");
			// }

		} catch (Exception _err) {
			try {
				throw new Exception(
						"LPIssueDeskTransHLP---->getIssueItemDetails"
								+ _err.getMessage());
			} catch (Exception e) {

			}
		}

		return buff.toString();
	}

	/**
	 * This function is used to create view page (issue mode)
	 * 
	 * @param _LPIssueDeskTransFB
	 * @return
	 */
	public static String initViewForIssueAddPage(
			DossierDeskTransFB _LPIssueDeskTransFB) {
		StringBuffer buff = null;
		MmsConfigUtil mcu = null;
		try {
			mcu = new MmsConfigUtil(_LPIssueDeskTransFB.getStrHospitalCode());
			buff = new StringBuffer(500);
			// if(_LPIssueDeskTransFB.getStrRaisingReqTypeId().equals("35")){

			buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
			buff.append("<tr>");
			buff.append("<td class='LABEL' width='25%'>C.R No.</td>");
			buff.append("<td class='CONTROL' width='25%'>"
					+ _LPIssueDeskTransFB.getStrCrNo() + "</td>");
			buff.append("<td class='LABEL' width='25%'>Request No.</td>");
			buff.append("<td class='CONTROL' width='25%'>"
					+ _LPIssueDeskTransFB.getStrLpRequestNo() + "</td>");
			buff.append("</tr>");
			/*
			 * if(_LPIssueDeskTransFB.getStrBSReqNo() != null &&
			 * !_LPIssueDeskTransFB.getStrBSReqNo().equals("0")) {
			 * buff.append("<tr>");
			 * buff.append("<td class='LABEL' width='25%'>LP Request No.</td>");
			 * buff.append("<td class='CONTROL' width='25%' colspan='3'>"+
			 * _LPIssueDeskTransFB.getStrBSReqNo()+"</td>"); //
			 * buff.append("<td class='LABEL' width='25%'>Request Date</td>");
			 * //
			 * buff.append("<td class='CONTROL' width='25%'>"+_LPIssueDeskTransFB
			 * .getStrRequestDate()+"</td>"); buff.append("</tr>"); }
			 */
			// buff.append("<tr>");
			// //buff.append("<td class='LABEL' width='25%'>Request Type</td>");
			// //buff.append("<td class='CONTROL' width='25%' colspan='3'>Patient</td>");
			// buff.append("</tr>");
			if (mcu.getStrBillingIntegration().equals("1")) {
				buff.append("<tr>");
				buff.append("<td class='LABEL' width='25%'>Account No.</td>");
				buff.append("<td class='CONTROL' width='25%'>"
						+ _LPIssueDeskTransFB.getStrPatAccountNo() + "</td>");
				buff.append("<td class='LABEL' width='25%'>Account Balance</td>");
				buff.append("<td class='CONTROL' width='25%'>"
						+ _LPIssueDeskTransFB.getStrBillingHiddenValue().split(
								"\\^")[1] + "</td>");
				buff.append("</tr>");
			}
			buff.append("<input type='hidden' name='strBillingInt' value='"
					+ mcu.getStrBillingIntegration() + "'>");
			buff.append("<input type='hidden' name='strPatAccountNo' value='"
					+ _LPIssueDeskTransFB.getStrPatAccountNo() + "'>");
			buff.append("</table>");
			// }
			// else
			// if(_LPIssueDeskTransFB.getStrRaisingReqTypeId().equals("12")){
			//
			// buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
			//
			// buff.append("<tr>");
			// buff.append("<td class='LABEL' width='25%'>C.R No.</td>");
			// buff.append("<td class='CONTROL' width='25%'>"+_LPIssueDeskTransFB.getStrCrNo()+"</td>");
			// buff.append("<td class='LABEL' width='25%'>Emp. No.</td>");
			// buff.append("<td class='CONTROL' width='25%'>"+_LPIssueDeskTransFB.getStrEmpNo()+"</td>");
			// buff.append("</tr>");
			// buff.append("<tr>");
			// buff.append("<td class='LABEL' width='25%'>Request No.</td>");
			// buff.append("<td class='CONTROL' width='25%'>"+_LPIssueDeskTransFB.getStrLpRequestNo()+"</td>");
			// //
			// buff.append("<td class='LABEL' width='25%'>Request Date</td>");
			// //
			// buff.append("<td class='CONTROL' width='25%'>"+_LPIssueDeskTransFB.getStrRequestDate()+"</td>");
			// buff.append("</tr>");
			// // buff.append("<tr>");
			// //
			// buff.append("<td class='LABEL' width='25%'>Request Type</td>");
			// //
			// buff.append("<td class='CONTROL' width='25%' colspan='3'>Staff</td>");
			// // buff.append("</tr>");
			// buff.append("</table>");
			// }
			// else{
			// buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
			// buff.append("<tr>");
			// buff.append("<td class='LABEL' width='25%'>Store Name</td>");
			// buff.append("<td class='CONTROL' width='25%'>"+_LPIssueDeskTransFB.getStrStoreName()+"</td>");
			// buff.append("<td class='LABEL' width='25%'>Dept/Ward</td>");
			// buff.append("<td class='CONTROL' width='25%'>"+_LPIssueDeskTransFB.getStrDeptName()+"</td>");
			// buff.append("</tr>");
			// buff.append("<tr>");
			// buff.append("<td class='LABEL' width='25%'>Request No.</td>");
			// buff.append("<td class='CONTROL' width='25%'>"+_LPIssueDeskTransFB.getStrLpRequestNo()+"</td>");
			// buff.append("<td class='LABEL' width='25%'>Request Date</td>");
			// buff.append("<td class='CONTROL' width='25%'>"+_LPIssueDeskTransFB.getStrRequestDate()+"</td>");
			// buff.append("</tr>");
			// buff.append("<tr>");
			// buff.append("<td class='LABEL' width='25%'>Request Type</td>");
			// buff.append("<td class='CONTROL' width='25%' colspan='3'>Department</td>");
			// buff.append("</tr>");
			// buff.append("</table>");
			// }

			return buff.toString();

		} catch (Exception _err) {
			try {
				throw new Exception(
						"LPIssueDeskTransHLP-->initViewForIssueAddPage"
								+ _err.getMessage());
			} catch (Exception e) {
			}
		}

		return buff.toString();
	}

	/**
	 * This function is used to create issued item detail part for return page
	 * 
	 * @param _LPIssueDeskTransFB
	 * @return
	 */
	public static String getIssuedItemDetails(WebRowSet wb, String hosp_code,
			String strCostReq) throws SQLException {

		StringBuffer buff = null;
		Double itemFinalCost = 0.0;
		DossierDeskTransVO vo = null;
		DossierDeskTransBO bo = null;
		String strReturnUnitCombo = "";

		HisUtil hisutil = null;
		try {
			buff = new StringBuffer();
			int i = 0;
			vo = new DossierDeskTransVO();
			bo = new DossierDeskTransBO();

			hisutil = new HisUtil("MMS", "LPIssueDeskTransHLP");

			String temp[] = null;

			if (wb != null) 
			{
				buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				buff.append("<tr>");
				buff.append("<td class='multiLabel' >Item Name</td>");
				buff.append("<td class='multiLabel' >Batch/Sl.no.</td>");
				buff.append("<td class='multiLabel' >Expiry Date</td>");
				buff.append("<td class='multiLabel' >Balance Qty</td>");
				buff.append("<td class='multiLabel' >Return Qty.</td>");
				buff.append("<td class='multiLabel' >Unit</td>");
				if (strCostReq.equals("1"))
					buff.append("<td class='multiLabel' >Cost</td>");
				buff.append("</tr>");
				if (wb.size() != 0) 
				{

					while (wb.next()) 
					{

						temp = wb.getString(1).replace('@', '#').split("#");
						vo.setStrStoreName(temp[15]);
						vo.setStrHospitalCode(hosp_code);
						vo.setStrBalanceQtUnitId(temp[1]);
						bo.getUnitCombo(vo);

						if (vo.getUnitComboWs() != null	&& vo.getUnitComboWs().size() > 0) 
						{
							strReturnUnitCombo = hisutil.getOptionValue(vo.getUnitComboWs(), "", "", true);
						} 
						else 
						{
							strReturnUnitCombo = "<option value='0'>Select Value</option>";
						}

						//System.out.println(wb.getString(8));

						if (!(wb.getString(8).equals("-1") || wb.getString(8).equals("0"))) 
						{
							buff.append("<tr>");
							buff.append("<td class='multiControl' >"
									+ wb.getString(2)
									+ "<input type='hidden' name='strItemParamValue' id='strItemParamValue"
									+ i
									+ "' value='"
									+ wb.getString(1)
									+ "' /><input type='hidden' name='strReturnChk' id='strReturnChk"
									+ i + "' value='" + wb.getString(9)
									+ "' /></td>");
							buff.append("<td class='multiControl' >"
									+ wb.getString(3) + "</td>");
							buff.append("<td class='multiControl' ><font color='red'>"
									+ (wb.getString(6).equals(" ") ? "NA" : wb
											.getString(6)) + "</font></td>");
							buff.append("<td class='multiControl' ><a  onclick='openSpecification(this,"
									+ (i)
									+ ");' style='color:blue; cursor:pointer;' title='Click Here To View Balance Detail' >"
									+ wb.getString(4)
									+ " "
									+ wb.getString(5)
									+ "</a>");
							buff.append("<input type='hidden' name='strItemDtl' id='strItemDtl"
									+ i
									+ "' value='"
									+ wb.getString(4)
									+ "@"
									+ wb.getString(5)
									+ "@"
									+ wb.getString(7)
									+ "'>"
									+ "<input type='hidden' name='strBalanceQty' id='strBalanceQty"
									+ i
									+ "' value='"
									+ wb.getString(4)
									+ "' />" + "</td>");
							buff.append("<td class='multiControl' ><input type='text' autocomplete='off' name='strReturnQty' id='strReturnQty"
									+ i
									+ "' value='0' class='txtFldSmall'  maxlength='8' onkeypress='return validateData(event,7);', onkeyup='quantityUnitValue("
									+ i + ");'></td>");
							buff.append("<td class='multiControl' ><input type='hidden' name='itemCost' id='itemCost"
									+ i
									+ "' value=''><select name='strUnit' id='strUnit"
									+ i
									+ "' onchange='quantityUnitValue("
									+ i
									+ ");' >"
									+ strReturnUnitCombo
									+ "</select>");
							if (!strCostReq.equals("1"))
								buff.append("<div id='itemCostId" + i
										+ "' style='display:none'>0.00</div>");
							buff.append("</td>");
							if (strCostReq.equals("1"))
								buff.append("<td class='multiControl' >"
										+ "<div id='itemCostId" + i
										+ "'>0.00</div></td>");
							buff.append("</tr>");
						} 
						else 
						{
							buff.append("<tr>");
							buff.append("<td class='multiControlRed' >"
									+ wb.getString(2) + "</td>");
							buff.append("<td class='multiControlRed' >"
									+ wb.getString(3) + "</td>");
							buff.append("<td class='multiControlRed' >"
									+ wb.getString(6) + "</td>");
							buff.append("<td class='multiControlRed' >"
									+ wb.getString(4)
									+ " "
									+ wb.getString(5)
									+ "<input type='hidden' name='strBalanceQty' id='strBalanceQty"
									+ i + "' value='" + wb.getString(4)
									+ "' />" + "</td>");
							// buff.append("<td class='multiControlRed' >"+wb.getString(7)+" "+wb.getString(5)+"</td>");
							buff.append("<td class='multiControlRed' ><input type='text' name='strReturnQty'  id='strReturnQty"
									+ i + "'></td>");
							// buff.append("<td class='multiControlRed' >-</td>");
							buff.append("<td class='multiControlRed' >"
									+ wb.getString(5) + "</td>");
							if (strCostReq.equals("1"))
								buff.append("<td class='multiControlRed' >-</td>");
							buff.append("</tr>");
						}

						// if(wb.getString(8).equals("-1") ||
						// wb.getString(8).equals("0")){
						i++;
						// }
					}
					buff.append("</table>");
					if (strCostReq.equals("1"))
						buff.append("<div id='totalCostDivId'>");
					else
						buff.append("<div id='totalCostDivId' style='display:none'>");
					buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
					buff.append("<tr>");
					buff.append("<td bgcolor='black' colspan='7'></td>");
					buff.append("</tr>");
					buff.append("<tr>");
					buff.append("<td class='multiControl' width='90%' ><div align='right'><b>TOTAL COST</b></div></td>");
					buff.append("<td class='multiControl' width='10%'><div id='finalCostId'><font color='red'><b>Rs 0.00</b></font></div><input type='hidden' name='strFinalCost' value='"
							+ itemFinalCost + "'/>" + "</td>");
					buff.append("</tr>");
					buff.append("<tr>");
					buff.append("<td bgcolor='black' colspan='7'></td>");
					buff.append("</tr>");
					buff.append("</table>");
					buff.append("</div>");

				} else {
					buff.append("<tr>");
					if (strCostReq.equals("1"))
						buff.append("<td class='multiControl' colspan='7'><font color='red'><b>No Record Found</b></font></td>");
					else
						buff.append("<td class='multiControl' colspan='6'><font color='red'><b>No Record Found</b></font></td>");
					buff.append("</tr>");
					buff.append("</table>");
				}
			}

		} catch (Exception _err) {
			try {
				_err.printStackTrace();
				throw new Exception(
						"LPIssueDeskTransHLP---->getIssuedItemDetails"
								+ _err.getMessage());
			} catch (Exception e) {

			}
		}

		return buff.toString();
	}

	/**
	 * This function used to create view page for return mode
	 * 
	 * @param wb
	 * @param hosp_code
	 * @return
	 * @throws SQLException
	 */
	public static String getIssuedItemDetailsForReturnView(WebRowSet wb,
			String hosp_code) throws SQLException {
		StringBuffer buff = null;

		try {
			buff = new StringBuffer();
			int i = 0;
			float tot = 0;

			if (wb != null) {
				buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				buff.append("<tr>");
				buff.append("<td class='multiLabel' width='35%'>Item Name</td>");
				buff.append("<td class='multiLabel' width='10%'>Batch/Sl.no.</td>");
				buff.append("<td class='multiLabel' width='10%'>M.R.P</td>");
				buff.append("<td class='multiLabel' width='15%'>Expiry Date</td>");
				buff.append("<td class='multiLabel' width='10%'>Issued Qty</td>");
				buff.append("<td class='multiLabel' width='10%'>Return Qty.</td>");
				buff.append("<td class='multiLabel' width='10%'>Cost</td>");

				buff.append("</tr>");
				if (wb.size() != 0) {

					while (wb.next()) {

						String temp[] = wb.getString(1).replace('@', '#')
								.split("#");
						if (wb.getString(8).equals("-1")
								|| wb.getString(8).equals("0")) {
							buff.append("<tr>");
							buff.append("<td class='multiControl' width='35%'>"
									+ wb.getString(2)
									+ "<input type='hidden' name='strItemParamValue' id='strItemParamValue"
									+ i + "' value='" + wb.getString(1)
									+ "' /></td>");
							buff.append("<td class='multiControl' width='10%'>"
									+ wb.getString(3) + "</td>");
							buff.append("<td class='multiControl' width='10%'>"
									+ temp[10] + "/" + wb.getString(5)
									+ "</td>");
							buff.append("<td class='multiControl' width='15%'><font color='red'>"
									+ wb.getString(6) + "</font></td>");

							buff.append("<td class='multiControl' width='10%'>"
									+ temp[0] + " " + wb.getString(5) + "</a>");
							buff.append("<input type='hidden' name='strItemDtl' id='strItemDtl"
									+ i
									+ "' value='"
									+ wb.getString(4)
									+ "@"
									+ wb.getString(5)
									+ "@"
									+ wb.getString(7)
									+ "'>"
									+ "<input type='hidden' name='strBalanceQty' id='strBalanceQty"
									+ i
									+ "' value='"
									+ wb.getString(4)
									+ "' />" + "</td>");
							buff.append("<td class='multiControl' width='10%'>"
									+ wb.getString(7) + " " + wb.getString(5)
									+ "</td>");

							buff.append("<td class='multiControl' width='10%'>"
									+ Math.round((Float.parseFloat(wb
											.getString(4)) * Float
											.parseFloat(temp[10])) * 100.0)
									/ 100.0 + "</td>");
							buff.append("</tr>");
							tot += Math
									.round((Float.parseFloat(wb.getString(4)) * Float
											.parseFloat(temp[10])) * 100.0) / 100.0;
						} else {
							buff.append("<tr>");
							buff.append("<td class='multiControl' width='35%'>"
									+ wb.getString(2) + "</td>");
							buff.append("<td class='multiControl' width='10%'>"
									+ wb.getString(3) + "</td>");
							buff.append("<td class='multiControl' width='10%'>"
									+ temp[10] + "/" + wb.getString(5)
									+ "</td>");
							buff.append("<td class='multiControl' width='15%'>"
									+ wb.getString(6) + "</td>");
							buff.append("<td class='multiControl' width='10%'>"
									+ temp[0]
									+ " "
									+ wb.getString(5)
									+ "<input type='hidden' name='strBalanceQty' id='strBalanceQty"
									+ i + "' value='" + wb.getString(4)
									+ "' />" + "</td>");
							buff.append("<td class='multiControl' width='10%'>"
									+ wb.getString(7) + " " + wb.getString(5)
									+ "</td>");
							buff.append("<td class='multiControl' width='10%'>"
									+ Math.round((Float.parseFloat(wb
											.getString(4)) * Float
											.parseFloat(temp[10])) * 100.0)
									/ 100.0 + "</td>");
							buff.append("</tr>");
							tot += Math
									.round((Float.parseFloat(wb.getString(4)) * Float
											.parseFloat(temp[10])) * 100.0) / 100.0;
						}

						if (wb.getString(8).equals("-1")
								|| wb.getString(8).equals("0")) {
							i++;
						}
					}
					buff.append("<tr>");
					// buff.append("<td class='multiControl' colspan='6'><div align='right'><b>Total Cost</b></div></td>");
					buff.append("<td class='multiControl' colspan='7'><div align='right'>Total Cost  :  "
							+ tot + "</div></td>");
					buff.append("</tr>");

					buff.append("</table>");
				} else {
					buff.append("<tr>");
					buff.append("<td class='multiControl' colspan='6'><font color='red'>No Record Found</font></td>");
					buff.append("</tr>");
				}
			}

		} catch (Exception _err) {
			try {
				_err.printStackTrace();
				throw new Exception(
						"LPIssueDeskTransHLP---->getIssuedItemDetails"
								+ _err.getMessage());
			} catch (Exception e) {

			}
		}

		return buff.toString();
	}

	public static String getIssueDtlsInitView(DossierDeskTransFB formBean)
			throws Exception {

		StringBuffer sb = new StringBuffer("");
		int i = 1;

		ResourceBundle res = null;
		WebRowSet ws = null;

		String strTableWidth = "825";

		try {
			res = mms.qryHandler_mms.res;
			if (res == null) {
				res = ResourceBundle
						.getBundle("hisglobal.hisconfig.hisProperties");
				mms.qryHandler_mms.res = res;
			}

			ws = formBean.getWsIssueDetails();

			HisUtil hisUtil = new HisUtil("Global", "ReportUtil");
			HospitalMstVO hospitalVO = hisUtil.getHospitalDetail(formBean.getStrHospitalCode());
			
			//System.out.println("hospitalVO.getAddress1()"+ hospitalVO.getHospitalName());
			//System.out.println("the ws length isa  " + ws.getKeyColumns());
			
			
			sb.append("<table align='center' width='")
					.append(strTableWidth)
					.append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			// sb.append(res.getString("REPORT_TITLE"));
			sb.append(hospitalVO.getHospitalName());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			sb.append(((hospitalVO.getAddress1() == "" || hospitalVO
					.getAddress1() == null) ? " "
					: (hospitalVO.getAddress1() + ","))
					+ ((hospitalVO.getAddress2() == "" || hospitalVO
							.getAddress2() == null) ? " " : (hospitalVO
							.getAddress2() + ","))
					+ ((hospitalVO.getCity() == "" || hospitalVO.getCity() == null) ? " "
							: (hospitalVO.getCity() + ","))
					+ ((hospitalVO.getPinCode() == "" || hospitalVO
							.getPinCode() == null) ? " " : (hospitalVO
							.getPinCode())) + "");
			// sb.append(res.getString("FULL_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			// sb.append(hospitalVO.getCity());
			// sb.append(res.getString("CITY"));
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");

			
			sb.append("<table border='0' width='" + strTableWidth
					+ "' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; '  name='PrintPage' tabindex='1' title='Print Page'");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne(1);'/> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopupOne();' /></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			sb.append(" <br> ");

			sb.append("<table width='")
					.append(strTableWidth)
					.append("' align='center' cellpadding='1px' cellspacing='1px'> ");

			sb.append("<tr>");
			sb.append("<td width='100%' align='center' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Dossier Issue Voucher</b></font></td> ");
			sb.append("</tr>");
			
			/************************************************* 1 *******************************************************************/
			sb.append("<tr> ");
			sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Patient:</b></font></td> ");
			// sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(formBean.getStrIssueNo())
			// .append("</b></font></td> ");
			sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >"
					+ formBean.getStrPatientName() + "</font></td> ");

			sb.append(
					"<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
					.append("Store Name:</b></font></td> ");
			sb.append(
					"<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >")
					.append(formBean.getStrStoreName()).append("</font></td> ");
			sb.append("</tr> ");
			/************************************************** 2 *****************************************************************/

			sb.append("<tr> ");
			
			sb.append(
					"<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
					.append("Requst No:</b></font></td> ");
			sb.append(
					"<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >")
					.append(formBean.getStrIssueNo()).append("</font></td> ");

			sb.append(
					"<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
					.append("Issue Date:</b></font></td> ");
			sb.append(
					"<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >")
					.append(formBean.getStrIssueDate()).append("</font></td> ");

			sb.append("</tr> ");
			/************************************************** 3 ******************************************************************/
			
			sb.append("<tr> ");

			sb.append(
					"<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>")
					.append("CR No:</b></font></td> ");
			sb.append(
					"<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >")
					.append(formBean.getStrCrNo()).append("</font></td> ");
			
			sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td> ");
			sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td> ");
			

			sb.append("</tr> ");
			/********************************************************************************************************************/
			sb.append("</table> ");

			sb.append("<table width='")
					.append(strTableWidth)
					.append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
			sb.append("<tr>");
			sb.append("<td colspan='3' align='left'><hr size='2'></td>");
			sb.append("<td colspan='2' align='center'><hr size='2'></td>");
			sb.append("</tr>");
			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='10%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
			sb.append("</td>");			
			sb.append("<td align='center' width='45%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font> ");
			sb.append("</td>");			
			sb.append("<td align='right'  width='15%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font>");
			sb.append("</td> ");
			sb.append("<td align='right'  width='15%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate(Rs.)</b></font>");
			sb.append("</td> ");
			sb.append("<td align='right'  width='15%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost(Rs.)</b></font>");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("<tr>");
			sb.append("<td colspan='4' align='left'><hr size='2'></td>");
			sb.append("<td colspan='4' align='center'><hr size='2'></td>");
			sb.append("</tr>");
			// System.out.println("In HLP Size is::::::"+ws.size());
			float NetAmount = 0;
			if (ws != null && ws.size() > 0) {

				while (ws.next()) 
				{

					/*
					  PKG_DOSSIER_VIEW.Proc_Emp_Issue_Detail ::--1--
					  1.Item Name
					  2.Brand_Id
					  3.decode(nvl(hnum_isbrought_bypatient,0),1,'Yes',0,'No')
					  4.Rate
					  5.Qty
					  6.Total Rate
					  7.Catg Name
					  8.Service Type (OT,Radiology etc)
					  9.Dossier Name
					  10.Patient Name
					  11.Issue No
					  12.Issue Date
					  13.PUK_NO
					  14.Issuing Store Name
					  15.Issue By
					  16.Remarks
					  17.Dept_Name
					  18.Service
					  19.hgnum_pat_status_code,1,'EMG',2,'IPD',3,'OPD'
					  20.Patient Type
					  21.Batch No
					  22.Consultant Name
					  23.Extra Item Flg			
					  
					 */	
					sb.append("<tr> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(i + ".");
					sb.append("</font></td> ");					
					sb.append("<td align='left' width='45%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
					sb.append(ws.getString(1));
					sb.append("</font></td> ");					
					sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(5));
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(4));
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(6));
					sb.append("</font></td> ");
					sb.append("</tr> ");
					NetAmount = NetAmount + Float.parseFloat(ws.getString(6));
					i++;

				}

				sb.append("<tr>");
				sb.append("<td colspan='3' align='left'><hr size='2'></td>");
				sb.append("<td colspan='2' align='center'><hr size='2'></td>");
				sb.append("</tr>");

				sb.append("<tr>");
				sb.append("<td colspan='3' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>TOTAL (Rs.)</b></font></td>");
				sb.append("<td colspan='2' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append(HisUtil.getAmountWithDecimal(NetAmount, 2));//
				// s myFormatter.format(Double.parseDouble(FinaltotalCost)));
				sb.append("</font></td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td colspan='3' align='left'></td>");
				sb.append("<td colspan='2' align='center'></td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td colspan='3' align='left'></td>");
				sb.append("<td colspan='2' align='center'></td>");
				sb.append("</tr>");


			} else {

				sb.append("<tr> ");
				sb.append("<td colspan='5' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}
			sb.append("</table> ");
			sb.append("<table align='center' width='")
					.append(strTableWidth)
					.append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr>");
			sb.append("<td width='10%'></td>");
			sb.append("<td width='80%' align='center'><b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
			// sb.append(formBean.getStrHindiText());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("</table>");

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}

		}

		return sb.toString();
	}

	public static String getIssuedItemDetailsForIssueView(WebRowSet wb,
			String hosp_code, String strCostReq) throws SQLException {

		StringBuffer buff = null;
		Double itemFinalCost = 0.0;
		DossierDeskTransVO vo = null;
		DossierDeskTransBO bo = null;
		String strReturnUnitCombo = "";

		HisUtil hisutil = null;
		try {
			buff = new StringBuffer();
			int i = 0;
			vo = new DossierDeskTransVO();
			bo = new DossierDeskTransBO();

			hisutil = new HisUtil("MMS", "LPIssueDeskTransHLP");

			String temp[] = null;

			if (wb != null) {
				buff.append("<table class='TABLEWIDTH' cellspacing='1px' cellpadding='0px' align='center'>");
				buff.append("<tbody>");

				if (wb.size() != 0) {
					while (wb.next()) {
						buff.append("<tr>");
						i++;
						buff.append("<input type='hidden' name='strItemParamValue' id='strItemParamValue"
								+ i
								+ "' value='"
								+ wb.getString(6)
								+ "@"
								+ wb.getString(7)
								+ "@"
								+ wb.getString(9)
								+ "' />");
						buff.append("<td class='multiControl' width='23%'>"
								+ wb.getString(1) + "</td>");
						buff.append("<td class='multiControl' width='8%'>"
								+ wb.getString(11) + "</td>");
						buff.append("<td class='multiControl' width='8%'>"
								+ wb.getString(2) + "</td>");
						buff.append("<td class='multiControl' width='8%'>"
								+ wb.getString(10) + "</td>");
						// buff.append("<td class='multiControl' width='8%'>"+wb.getString(4)+"</td>");
						buff.append("<td class='multiControl' width='8%'>"
								+ wb.getString(3) + "</td>");
						buff.append("<td class='multiControl' width='8%'>"
								+ wb.getString(5) + "</td>");

						buff.append("</tr>");
					}
				} else {
					buff.append("<tr>");
					buff.append("<td class='multiControl' colspan='7'><font color='red'><b>No Record Found</b></font></td>");
					buff.append("</tr>");
				}
				buff.append("</tbody>");
				buff.append("</table>");

			}

		} catch (Exception _err) {
			try {
				_err.printStackTrace();
				throw new Exception(
						"LPIssueDeskTransHLP---->getIssuedItemDetailsForIssueView"
								+ _err.getMessage());
			} catch (Exception e) {

			}
		}

		return buff.toString();
	}

	public static String getIssuedItemDetailsForReturnView(WebRowSet wb,
			String hosp_code, String strCostReq) throws SQLException {

		StringBuffer buff = null;
		Double itemFinalCost = 0.0;
		DossierDeskTransVO vo = null;
		DossierDeskTransBO bo = null;
		String strReturnUnitCombo = "";

		HisUtil hisutil = null;
		try {
			buff = new StringBuffer();
			int i = 0;
			vo = new DossierDeskTransVO();
			bo = new DossierDeskTransBO();

			hisutil = new HisUtil("MMS", "LPIssueDeskTransHLP");

			String temp[] = null;

			if (wb != null) {
				buff.append("<table class='TABLEWIDTH' cellspacing='1px' cellpadding='0px' align='center'>");
				buff.append("<tbody>");

				if (wb.size() != 0) {
					while (wb.next()) {
						buff.append("<tr>");
						i++;
						buff.append("<input type='hidden' name='strItemParamValue' id='strItemParamValue"
								+ i + "' value='" + wb.getString(1) + "' />");
						buff.append("<td class='multiControl' width='23%'>"
								+ wb.getString(2) + "</td>");
						buff.append("<td class='multiControl' width='8%'>"
								+ wb.getString(3) + "</td>");
						buff.append("<td class='multiControl' width='8%'>"
								+ wb.getString(6) + "</td>");
						buff.append("<td class='multiControl' width='8%'>"
								+ wb.getString(4) + "" + wb.getString(5)
								+ "</td>");
						buff.append("<td class='multiControl' width='8%'>"
								+ wb.getString(7) + "</td>");
						buff.append("<td class='multiControl' width='8%'>No.</td>");

						buff.append("</tr>");
					}
				} else {
					buff.append("<tr>");
					buff.append("<td class='multiControl' colspan='7'><font color='red'><b>No Record Found</b></font></td>");
					buff.append("</tr>");
				}
				buff.append("</tbody>");
				buff.append("</table>");

			}

		} catch (Exception _err) {
			try {
				_err.printStackTrace();
				throw new Exception(
						"LPIssueDeskTransHLP---->getIssuedItemDetailsForReturnView"
								+ _err.getMessage());
			} catch (Exception e) {

			}
		}

		return buff.toString();
	}
}
