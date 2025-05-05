/* Decompiler 412ms, total 3043ms, lines 1157 */
package dossier.transaction.controller.hlp;

import dossier.transaction.bo.LPIssueDeskTransBO;
import dossier.transaction.controller.fb.LPIssueDeskTransFB;
import dossier.transaction.vo.LPIssueDeskTransVO;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;

import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.qryHandler_mms;

public class LPIssueDeskTransHLP {
   static int i = 0;

   public static String getItemDetails(WebRowSet wb) throws SQLException {
      StringBuffer buff = null;

      try {
         buff = new StringBuffer();
         int count = 0;
         if (wb != null) {
            buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
            buff.append("<tr>");
            buff.append("<td class='multiLabel'>Item Name</td>");
            buff.append("<td class='multiLabel'>Sanction Qty.</td>");
            buff.append("</tr>");
            if (wb.size() == 0) {
               buff.append("<tr>");
               buff.append("<td class='multiControl' colspan='3'><font color='red'>No Record Found/Patient is not admitted</font></td>");
               buff.append("</tr>");
            } else {
               while(wb.next()) {
                  buff.append("<tr>");
                  buff.append("<td class='multiControl'>" + wb.getString(1) + "</td>");
                  StringBuilder var10001 = new StringBuilder("<td class='multiControl'><a  onclick='openSpecification(this,");
                  ++count;
                  buff.append(var10001.append(count).append(");' style='color:blue; cursor:pointer;' title='Click Here To View Detail' >").append(wb.getString(4)).append(" ").append(wb.getString(3)).append("</a>").toString());
                  buff.append("<input type='hidden' name='strItemDtl' id='strItemDtl" + count + "' value='" + wb.getString(2) + "@" + wb.getString(3) + "@" + wb.getString(5) + "'>");
                  buff.append("</td>");
                  buff.append("</tr>");
               }

               buff.append("</table>");
            }
         }
      } catch (Exception var5) {
         Exception _err = var5;

         try {
            _err.printStackTrace();
            throw new Exception("LPIssueDeskTransHLP---->getItemDetails" + _err.getMessage());
         } catch (Exception var4) {
         }
      }

      return buff.toString();
   }

   public static String getIssueItemDetails(WebRowSet wb, String strCostReq, String strIssueStoreID, String hosCode, String strRaisingStoreId, String lpReqNo, LPIssueDeskTransVO voObj) throws SQLException {
      StringBuffer buff = null;
      Double itemFinalCost = 0.0D;
      LPIssueDeskTransVO vo = null;
      LPIssueDeskTransBO bo = null;

      try {
         vo = new LPIssueDeskTransVO();
         bo = new LPIssueDeskTransBO();
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
         String strItemType = "";
         String avlQty = "";
         String[] temp = null;
         Double itemCost = 0.0D;
         String strTotalNoOfBatch = "";
         String strHiddenId = "";
         String TariffFlag = "0";
         String strBillNo = "0";
         WebRowSet brandWs = null;
         int i = 0;
         if (wb != null) {
            buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
            buff.append("<tr>");
            buff.append("<td width='20%' class='multiLabel' align='left'>Item Name</td>");
            buff.append("<td width='10%' class='multiLabel' align='left'>Item Type</td>");
            buff.append("<td width='10%' class='multiLabel' align='left'>Available Qty</td>");
            buff.append("<td width='10%' class='multiLabel' align='left'>Request Qty</td>");
            buff.append("<td width='10%' class='multiLabel' align='left'>Issue Qty</td>");
            buff.append("</tr>");
            if (wb.size() == 0) {
               buff.append("<tr>");
               if (strCostReq.equals("1")) {
                  buff.append("<td class='multiControl' colspan='6'><font color='red'>No Record Found/Patient is not admitted/Brought by patient</font></td>");
               } else {
                  buff.append("<td class='multiControl' colspan='5'><font color='red'>No Record Found/Patient is not admitted/Brought by Patient</font></td>");
               }

               buff.append("</tr>");
               buff.append("</table>");
            } 
            else 
            {
               while(wb.next()) 
               {
                  ++i;
		                  strItemId 		= wb.getString(1);
		                  strItemBrandId 	= wb.getString(2);
		                  avlQty 			= wb.getString(6);
		                  strBatchSlNo 		= wb.getString(9);
		                  strIssueQty 		= wb.getString(3);
		                  strIssueUnitId 	= wb.getString(4);
		                  strItemName 		= wb.getString(7);
		                  strUnitName 		= wb.getString(5);
		                  (new StringBuilder(String.valueOf(wb.getString(1)))).append("^").append(wb.getString(2)).toString();
		                  String strMRP 	= wb.getString(11) == null ? "0" : wb.getString(11);
		                  String strItemCat = wb.getString(12) == null ? "0" : wb.getString(12);
		                  strItemType 		= wb.getString(13) == null ? "0" : wb.getString(13);
		                  TariffFlag        = "1";
		                  vo.setStrHospitalCode(hosCode);
		                  voObj.setStrItemId(strItemId);
		                  if (voObj.getStrPatientType().equalsIgnoreCase("2")) {
		                     strBillNo = wb.getString(14) == null ? "0" : wb.getString(14);
		                  }
		
		                  if (Float.parseFloat(avlQty) < Float.parseFloat(strIssueQty)) {
		                     bo.getBrandDetails(voObj);
		                     brandWs = voObj.getBrandDtlWs();
		                  }

                  hiddenParam = strItemId + "@" + strItemBrandId + "@" + strIssueQty + "@" + strIssueUnitId + "@" + avlQty + "@" + strBatchSlNo + "@" + strMRP + "@" + strItemCat;
                  if (!strRate.equals("0") && !strRateUnit.equals("0") && !strManuFacturingDate.equals("0") && !strInHandQty.equals("0") && !avlQty.equals("0")) {
                     buff.append("<tr>");
                     buff.append("<td width='30%' class='multiControl'><div id='itmNm" + i + "'> " + strItemName + " </div><input type='hidden' id='strItemParamValue" + i + "' name='strItemParamValue' value='" + hiddenParam + "' /></td>");
                     buff.append("<input type='hidden' id='strBillNo" + i + "' name='strBillNo' value='" + strBillNo + "' />");
                     buff.append("<td width='10%' class='multiControl' align='left'>" + strItemType + "</td>");
                     if (Float.parseFloat(avlQty) < Float.parseFloat(strIssueQty) && brandWs.size() != 0) {
                        if (brandWs.size() == 1) {
                           brandWs.next();
                           buff.append("<td width='10%' class='multiControl' align='left'><input type='hidden' name='brandHiddenVal' id = 'brandHiddenVal" + i + 1 + "' value='" + brandWs.getString(1) + "^" + brandWs.getString(2) + "^" + brandWs.getString(3) + "^" + brandWs.getString(4) + "^" + brandWs.getString(5) + "^" + brandWs.getString(6) + "' > <div id='availQty" + i + "'>" + avlQty + "</div></td>");
                        } else {
                           buff.append("<TD WIDTH='10%' id='td99" + i + "' CLASS='multiPOControl'  ><input type='hidden' name='brandDtlsId' id='brandDtlsId" + i + "' value='' >" + "<div name='brandDtl' id='brandDtl" + i + "'></div>" + "<div id='availQty" + i + "'><a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callBrandDetails(\"" + i + "\");' TITLE='Click Here For other brand names available in store' ><div 'autodiv" + i + "'>auto</div></a></div>");
                           buff.append("<div id = 'divBrandDtlId" + i + "' class='popup' style='display: none; left:500px; top:210px;' >");
                           buff.append("<table width='500' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
                           if (brandWs.size() != 0) {
                              buff.append("<tr class='HEADER' ><td colspan=7 align='left'>Item Name : " + strItemName + " with sanctioned qty. : " + strIssueQty + " </td></tr> ");
                              buff.append("<tr class='HEADER'>");
                              buff.append("<td width='70%' class='multiLabel'><div align='left'> Alternate Items</div>");
                              buff.append("</td><td width='20%' class='multiLabel'>Avl. Qty");
                              buff.append("</td><td width='5%' class='multiLabel'>#");
                              buff.append("</td>");
                              buff.append("<th align='right' colspan=7><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp Window' src='../../hisglobal/images/popUp_cancel.JPG'");
                              buff.append(" onClick='hide_popup_menu(\"divBrandDtlId" + i);
                              buff.append("\");'></th></tr>");
                              buff.append("</table>");
                              buff.append("<table width='500' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
                              int j = 0;

                              while(brandWs.next()) {
                                 ++j;
                                 if (j == 1) {
                                    buff.append("<tr>");
                                    buff.append("<td width='50%' class='multiControl'><input type='hidden' name='brandHiddenVal' id = 'brandHiddenVal" + i + j + "' value='" + brandWs.getString(1) + "^" + brandWs.getString(2) + "^" + brandWs.getString(3) + "^" + brandWs.getString(4) + "^" + brandWs.getString(5) + "^" + brandWs.getString(6) + "' > ");
                                    buff.append("<div align='left'>" + brandWs.getString(4) + "</div> ");
                                    buff.append("</td><td width='20%' class='multiControl'>");
                                    buff.append(brandWs.getString(3));
                                    buff.append("</td><td width='10%' class='multiLabel'><input type='radio' onclick='setItemDtl(" + i + "," + i + j + ")' name='strBrandDtlsChk' id='strBrandDtlsChk" + i + "' > ");
                                    buff.append("</td></tr>");
                                 } else {
                                    buff.append("<tr>");
                                    buff.append("<td width='50%' class='multiControl'><input type='hidden' name='brandHiddenVal' id = 'brandHiddenVal" + i + j + "' value='" + brandWs.getString(1) + "^" + brandWs.getString(2) + "^" + brandWs.getString(3) + "^" + brandWs.getString(4) + "^" + brandWs.getString(5) + "^" + brandWs.getString(6) + "' > ");
                                    buff.append("<div align='left'>" + brandWs.getString(4) + "</div> ");
                                    buff.append("</td><td width='20%' class='multiControl'>");
                                    buff.append(brandWs.getString(3));
                                    buff.append("</td><td width='10%' class='multiLabel'><input type='radio' onclick='setItemDtl(" + i + "," + i + j + ")' name='strBrandDtlsChk' id='strBrandDtlsChk" + i + "' > ");
                                    buff.append("</td></tr>");
                                 }
                              }
                           } else {
                              buff.append("<tr class='HEADER'>");
                              buff.append("<th align='right' colspan=4><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp Window' src='../../hisglobal/images/popUp_cancel.JPG'");
                              buff.append("onClick='hide_popup_menu(\"divBrandDtlId" + i);
                              buff.append("\");'></th>");
                              buff.append("</tr>");
                              buff.append("</table>");
                              buff.append("<table width='300' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
                              buff.append("<tr>");
                              buff.append("<td colspan='3'  CLASS='multiControl' ><DIV class='errMsg' align='center'>No Record Found</div></TD>");
                              buff.append("</tr>");
                           }

                           buff.append("<tr class='HEADER'><td colspan='7' align='left' ><font color='white'>Items marked with * are non branded</font></td></tr>");
                           buff.append("</table>");
                           buff.append("</div>");
                        }
                     } else {
                        buff.append("<td width='10%' class='multiControl' align='left'><input type='hidden' name='brandHiddenVal' id = 'brandHiddenVal" + i + 1 + "' value='" + 0 + "^" + 0 + "^" + 0 + "^" + 0 + "^" + 0 + "^" + 0 + "' > <div id='availQty" + i + "'>" + avlQty + "</div></td>");
                     }

                     buff.append("</td>");
                     buff.append("<td width='10%' width='10%' class='multiControl' align='left'>" + strIssueQty + " " + strUnitName + "</td>");
                     if (lpReqNo.equals("0")) {
                        if (Integer.parseInt(TariffFlag) > 0) {
                           buff.append("<td width='10%' class='multiControl' align='left'><input type='text' class='txtFldNormal' id='strIssueQuantity" + i + "' name='strIssueQuantity' value='" + (Double.parseDouble(strIssueQty.split(" ")[0]) <= Double.parseDouble(avlQty.split(" ")[0]) ? strIssueQty.split(" ")[0] : "") + "' onkeypress='return validateData(event,7);' onkeyup='QtyValidation(" + i + ")'></td>");
                        } else {
                           buff.append("<td width='10%' class='multiControl' align='left'><input type='text' disabled=true class='txtFldNormal' readonly id='strIssueQuantity" + i + "' name='strIssueQuantity' value='0' onkeypress='return validateData(event,7);' onkeyup='QtyValidation(" + i + ")'></td>");
                        }
                     } else {
                        buff.append("<td width='10%' class='multiControl' align='left'><input type='text' class='txtFldNormal' id='strIssueQuantity" + i + "' name='strIssueQuantity' value='" + (Double.parseDouble(strIssueQty.split(" ")[0]) <= Double.parseDouble(avlQty.split(" ")[0]) ? strIssueQty.split(" ")[0] : "") + "' onkeypress='return validateData(event,7);' onkeyup='QtyValidation(" + i + ")'></td>");
                     }

                     buff.append("</tr>");
                  } else {
                     buff.append("<tr>");
                     buff.append("<td width='30%' class='multiControl'>" + strItemName + "<input type='hidden' id='strItemParamValue" + i + "' name='strItemParamValue' value='" + hiddenParam + "' /></td>");
                     buff.append("<td width='10%' class='multiControl' align='left'>" + strItemType + "</td>");
                     buff.append("<td width='10%' class='multiControl' align='left'>" + avlQty + "</td>");
                     buff.append("<td width='10%' class='multiControl' align='left'>" + strIssueQty + " " + strUnitName + "</td>");
                     System.out.println(Double.parseDouble(avlQty.split(" ")[0]));
                     buff.append("<td width='10%' class='multiControl' align='left'><input type='text' class='txtFldNormal' readonly id='strIssueQuantity" + i + "' name='strIssueQuantity' value='" + (Double.parseDouble(avlQty.split(" ")[0]) != 0.0D ? avlQty.split(" ")[0] : "0") + "' onkeypress='return validateData(event,7);' onkeyup='QtyValidation(" + i + ")'></td>");
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
               buff.append("<td class='multiControl' colspan='1' width='12%'><input type='hidden' name='strFinalCosttt' value='" + itemFinalCost + "'/>" + "<font color='red'><b>Rs." + Math.round(itemFinalCost) + "</b></font></td>");
               buff.append("</tr>");
               buff.append("<tr>");
               buff.append("<td bgcolor='black' colspan='6'></td>");
               buff.append("</tr>");
               buff.append("</table>");
               buff.append("</div>");
            }
         }
      } catch (Exception var39) {
         Exception _err = var39;

         try {
            _err.printStackTrace();
            throw new Exception("LPIssueDeskTransHLP---->getIssueItemDetails" + _err.getMessage());
         } catch (Exception var38) {
            var38.printStackTrace();
         }
      }

      return buff.toString();
   }

   public static String initViewForIssueAddPage(LPIssueDeskTransFB _LPIssueDeskTransFB) {
      StringBuffer buff = null;
      MmsConfigUtil mcu = null;

      try {
         mcu = new MmsConfigUtil(_LPIssueDeskTransFB.getStrHospitalCode());
         buff = new StringBuffer(500);
         buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
         buff.append("<tr>");
         buff.append("<td class='LABEL' width='25%'>C.R No.</td>");
         buff.append("<td class='CONTROL' width='25%'>" + _LPIssueDeskTransFB.getStrCrNo() + "</td>");
         buff.append("<td class='LABEL' width='25%'>Request No.</td>");
         buff.append("<td class='CONTROL' width='25%'>" + _LPIssueDeskTransFB.getStrLpRequestNo() + "</td>");
         buff.append("</tr>");
         if (_LPIssueDeskTransFB.getStrPatientType().equalsIgnoreCase("1") && mcu.getStrBillingIntegration().equals("1")) {
            buff.append("<tr>");
            buff.append("<td class='LABEL' width='25%'>Account No.</td>");
            buff.append("<td class='CONTROL' width='25%'>" + _LPIssueDeskTransFB.getStrBillingHiddenValue().split("\\^")[0] + "</td>");
            buff.append("<td class='LABEL' width='25%'>Account Balance</td>");
            buff.append("<td class='CONTROL' width='25%'>" + _LPIssueDeskTransFB.getStrBillingHiddenValue().split("\\^")[1] + "</td>");
            buff.append("</tr>");
         }

         buff.append("<input type='hidden' name='strBillingInt' value='" + mcu.getStrBillingIntegration() + "'>");
         buff.append("<input type='hidden' name='strPatAccountNo' value='" + _LPIssueDeskTransFB.getStrBillingHiddenValue().split("\\^")[0] + "'>");
         buff.append("</table>");
         return buff.toString();
      } catch (Exception var6) {
         Exception _err = var6;

         try {
            throw new Exception("LPIssueDeskTransHLP-->initViewForIssueAddPage" + _err.getMessage());
         } catch (Exception var5) {
            return buff.toString();
         }
      }
   }

   public static String getIssuedItemDetails(WebRowSet wb, String hosp_code, String strCostReq, LPIssueDeskTransVO vo) throws SQLException {
      StringBuffer buff = null;
      Double itemFinalCost = 0.0D;
      LPIssueDeskTransBO bo = null;
      String strReturnUnitCombo = "";
      HisUtil hisutil = null;

      try {
         buff = new StringBuffer();
         int i = 0;
         bo = new LPIssueDeskTransBO();
         hisutil = new HisUtil("MMS", "LPIssueDeskTransHLP");
         String[] temp = null;
         if (wb != null) {
            buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
            buff.append("<tr>");
            buff.append("<td class='multiLabel' >Item Name</td>");
            buff.append("<td class='multiLabel' >Batch/Sl.no.</td>");
            buff.append("<td class='multiLabel' >Expiry Date</td>");
            buff.append("<td class='multiLabel' >Balance Qty</td>");
            buff.append("<td class='multiLabel' >Return Qty.</td>");
            buff.append("<td class='multiLabel' >Unit</td>");
            if (strCostReq.equals("1")) {
               buff.append("<td class='multiLabel' >Cost</td>");
            }

            buff.append("</tr>");
            if (wb.size() == 0) {
               buff.append("<tr>");
               if (strCostReq.equals("1")) {
                  buff.append("<td class='multiControl' colspan='7'><font color='red'><b>No Record Found/Patient is not admitted/Brought by Patient</b></font></td>");
               } else {
                  buff.append("<td class='multiControl' colspan='6'><font color='red'><b>No Record Found/Patient is not admitted/Brought by Patient</b></font></td>");
               }

               buff.append("</tr>");
               buff.append("</table>");
            } else {
               while(true) {
                  if (!wb.next()) {
                     buff.append("</table>");
                     if (strCostReq.equals("1")) {
                        buff.append("<div id='totalCostDivId'>");
                     } else {
                        buff.append("<div id='totalCostDivId' style='display:none'>");
                     }

                     buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
                     buff.append("<tr>");
                     buff.append("<td bgcolor='black' colspan='7'></td>");
                     buff.append("</tr>");
                     buff.append("<tr>");
                     buff.append("<td class='multiControl' width='90%' ><div align='right'><b>TOTAL COST</b></div></td>");
                     buff.append("<td class='multiControl' width='10%'><div id='finalCostId'><font color='red'><b>Rs 0.00</b></font></div><input type='hidden' name='strFinalCost' value='" + itemFinalCost + "'/>" + "</td>");
                     buff.append("</tr>");
                     buff.append("<tr>");
                     buff.append("<td bgcolor='black' colspan='7'></td>");
                     buff.append("</tr>");
                     buff.append("</table>");
                     buff.append("</div>");
                     break;
                  }

                  temp = wb.getString(1).replace('@', '#').split("#");
                  vo.setStrHospitalCode(hosp_code);
                  vo.setStrBalanceQtUnitId(temp[1]);
                  bo.getUnitCombo(vo);
                  if (vo.getUnitComboWs() != null && vo.getUnitComboWs().size() > 0) {
                     strReturnUnitCombo = hisutil.getOptionValue(vo.getUnitComboWs(), "", "", true);
                  } else {
                     strReturnUnitCombo = "<option value='0'>Select Value</option>";
                  }

                  System.out.println(wb.getString(8));
                  if (!wb.getString(8).equals("-1") && !wb.getString(8).equals("0")) {
                     buff.append("<tr>");
                     buff.append("<td class='multiControl' >" + wb.getString(2) + "<input type='hidden' name='strItemParamValue' id='strItemParamValue" + i + "' value='" + wb.getString(1) + "' /></td>");
                     buff.append("<td class='multiControl' >" + wb.getString(3) + "</td>");
                     buff.append("<td class='multiControl' ><font color='red'>" + (wb.getString(6).equals(" ") ? "NA" : wb.getString(6)) + "</font></td>");
                     buff.append("<td class='multiControl' ><a  onclick='openSpecification(this," + i + ");' style='color:blue; cursor:pointer;' title='Click Here To View Balance Detail' >" + wb.getString(4) + " " + wb.getString(5) + "</a>");
                     buff.append("<input type='hidden' name='strItemDtl' id='strItemDtl" + i + "' value='" + wb.getString(4) + "@" + wb.getString(5) + "@" + wb.getString(7) + "'>" + "<input type='hidden' name='strBalanceQty' id='strBalanceQty" + i + "' value='" + wb.getString(4) + "' />" + "</td>");
                     buff.append("<td class='multiControl' ><input type='text' autocomplete='off' name='strReturnQty' id='strReturnQty" + i + "' value='" + wb.getString(7) + "' class='txtFldSmall'  maxlength='8' onkeypress='return validateData(event,7);', onkeyup='quantityUnitValue(" + i + ");'></td>");
                     buff.append("<td class='multiControl' ><input type='hidden' name='itemCost' id='itemCost" + i + "' value=''><select name='strUnit' id='strUnit" + i + "' onchange='quantityUnitValue(" + i + ");' >" + strReturnUnitCombo + "</select>");
                     if (!strCostReq.equals("1")) {
                        buff.append("<div id='itemCostId" + i + "' style='display:none'>0.00</div>");
                     }

                     buff.append("</td>");
                     if (strCostReq.equals("1")) {
                        buff.append("<td class='multiControl' ><div id='itemCostId" + i + "'>0.00</div></td>");
                     }

                     buff.append("</tr>");
                  } else {
                     buff.append("<tr>");
                     buff.append("<td class='multiControlRed' >" + wb.getString(2) + "</td>");
                     buff.append("<td class='multiControlRed' >" + wb.getString(3) + "</td>");
                     buff.append("<td class='multiControlRed' >" + wb.getString(6) + "</td>");
                     buff.append("<td class='multiControlRed' >" + wb.getString(4) + " " + wb.getString(5) + "<input type='hidden' name='strBalanceQty' id='strBalanceQty" + i + "' value='" + wb.getString(4) + "' />" + "</td>");
                     buff.append("<td class='multiControlRed' ><input type='text' name='strReturnQty'  id='strReturnQty" + i + "'></td>");
                     buff.append("<td class='multiControlRed' >" + wb.getString(5) + "</td>");
                     if (strCostReq.equals("1")) {
                        buff.append("<td class='multiControlRed' >-</td>");
                     }

                     buff.append("</tr>");
                  }

                  ++i;
                  vo.setStrSettlementFlag(wb.getString(9));
               }
            }
         }
      } catch (Exception var12) {
         Exception _err = var12;

         try {
            _err.printStackTrace();
            throw new Exception("LPIssueDeskTransHLP---->getIssuedItemDetails" + _err.getMessage());
         } catch (Exception var11) {
         }
      }

      return buff.toString();
   }

   public static String getIssuedItemDetailsForReturnView(WebRowSet wb, String hosp_code) throws SQLException {
      StringBuffer buff = null;

      try {
         buff = new StringBuffer();
         int i = 0;
         float tot = 0.0F;
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
            if (wb.size() == 0) {
               buff.append("<tr>");
               buff.append("<td class='multiControl' colspan='6'><font color='red'>No Record Found</font></td>");
               buff.append("</tr>");
            } else {
               while(true) {
                  do {
                     if (!wb.next()) {
                        buff.append("<tr>");
                        buff.append("<td class='multiControl' colspan='7'><div align='right'>Total Cost  :  " + tot + "</div></td>");
                        buff.append("</tr>");
                        buff.append("</table>");
                        return buff.toString();
                     }

                     String[] temp = wb.getString(1).replace('@', '#').split("#");
                     if (!wb.getString(8).equals("-1") && !wb.getString(8).equals("0")) {
                        buff.append("<tr>");
                        buff.append("<td class='multiControl' width='35%'>" + wb.getString(2) + "</td>");
                        buff.append("<td class='multiControl' width='10%'>" + wb.getString(3) + "</td>");
                        buff.append("<td class='multiControl' width='10%'>" + temp[10] + "/" + wb.getString(5) + "</td>");
                        buff.append("<td class='multiControl' width='15%'>" + wb.getString(6) + "</td>");
                        buff.append("<td class='multiControl' width='10%'>" + temp[0] + " " + wb.getString(5) + "<input type='hidden' name='strBalanceQty' id='strBalanceQty" + i + "' value='" + wb.getString(4) + "' />" + "</td>");
                        buff.append("<td class='multiControl' width='10%'>" + wb.getString(7) + " " + wb.getString(5) + "</td>");
                        buff.append("<td class='multiControl' width='10%'>" + (double)Math.round((double)(Float.parseFloat(wb.getString(4)) * Float.parseFloat(temp[10])) * 100.0D) / 100.0D + "</td>");
                        buff.append("</tr>");
                        tot = (float)((double)tot + (double)Math.round((double)(Float.parseFloat(wb.getString(4)) * Float.parseFloat(temp[10])) * 100.0D) / 100.0D);
                     } else {
                        buff.append("<tr>");
                        buff.append("<td class='multiControl' width='35%'>" + wb.getString(2) + "<input type='hidden' name='strItemParamValue' id='strItemParamValue" + i + "' value='" + wb.getString(1) + "' /></td>");
                        buff.append("<td class='multiControl' width='10%'>" + wb.getString(3) + "</td>");
                        buff.append("<td class='multiControl' width='10%'>" + temp[10] + "/" + wb.getString(5) + "</td>");
                        buff.append("<td class='multiControl' width='15%'><font color='red'>" + wb.getString(6) + "</font></td>");
                        buff.append("<td class='multiControl' width='10%'>" + temp[0] + " " + wb.getString(5) + "</a>");
                        buff.append("<input type='hidden' name='strItemDtl' id='strItemDtl" + i + "' value='" + wb.getString(4) + "@" + wb.getString(5) + "@" + wb.getString(7) + "'>" + "<input type='hidden' name='strBalanceQty' id='strBalanceQty" + i + "' value='" + wb.getString(4) + "' />" + "</td>");
                        buff.append("<td class='multiControl' width='10%'>" + wb.getString(7) + " " + wb.getString(5) + "</td>");
                        buff.append("<td class='multiControl' width='10%'>" + (double)Math.round((double)(Float.parseFloat(wb.getString(4)) * Float.parseFloat(temp[10])) * 100.0D) / 100.0D + "</td>");
                        buff.append("</tr>");
                        tot = (float)((double)tot + (double)Math.round((double)(Float.parseFloat(wb.getString(4)) * Float.parseFloat(temp[10])) * 100.0D) / 100.0D);
                     }
                  } while(!wb.getString(8).equals("-1") && !wb.getString(8).equals("0"));

                  ++i;
               }
            }
         }
      } catch (Exception var7) {
         Exception _err = var7;

         try {
            _err.printStackTrace();
            throw new Exception("LPIssueDeskTransHLP---->getIssuedItemDetails" + _err.getMessage());
         } catch (Exception var6) {
         }
      }

      return buff.toString();
   }

   public static String getIssueDtlsInitView(LPIssueDeskTransFB formBean) throws Exception {
	      StringBuffer sb = new StringBuffer("");
	      int i = 1;
	      ResourceBundle res = null;
	      WebRowSet ws = null;
	      WebRowSet ws1 = null;
	      String strTableWidth = "825";

	      try {
	         res = qryHandler_mms.res;
	         if (res == null) {
	            res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
	            qryHandler_mms.res = res;
	         }

	         ws = formBean.getWsIssueDetails();
	         HisUtil hisUtil = new HisUtil("Global", "ReportUtil");
	         HospitalMstVO hospitalVO = hisUtil.getHospitalDetail(formBean.getStrHospitalCode());
	         
	         
	         System.out.println("hospitalVO.getAddress1()" + hospitalVO.getHospitalName());
	         //System.out.println("HLP Size---  " + ws.size());
	         
	         
	         sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
	         sb.append("<tr><td width='8%'>&nbsp;</td> ");
	         sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
	         sb.append(hospitalVO.getHospitalName());
	         sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
	         sb.append("</tr> ");
	         sb.append("<tr> ");
	         sb.append("<td width='8%'>&nbsp;</td> ");
	         sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
	         sb.append((hospitalVO.getAddress1() != "" && hospitalVO.getAddress1() != null ? hospitalVO.getAddress1() + "," : " ") + (hospitalVO.getAddress2() != "" && hospitalVO.getAddress2() != null ? hospitalVO.getAddress2() + "," : " ") + (hospitalVO.getCity() != "" && hospitalVO.getCity() != null ? hospitalVO.getCity() + "," : " ") + (hospitalVO.getPinCode() != "" && hospitalVO.getPinCode() != null ? hospitalVO.getPinCode() : " "));
	         sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
	         sb.append("</tr> ");
	         sb.append("<tr> ");
	         sb.append("<td width='8%'>&nbsp;</td> ");
	         sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
	         sb.append("</font></b></td><td width='10%'>&nbsp; ");
	         sb.append("</td> ");
	         sb.append("</tr> ");
	         sb.append("</table> ");
	         sb.append("<table border='0' width='" + strTableWidth + "' align='center'> ");
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
	         sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
	         sb.append("<tr>");
	         if (!formBean.getStrMode().equals("4")) {
	            sb.append("<td width='100%' align='center' colspan='5'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Dossier Issue Voucher</b></font></td> ");
	         } else {
	            sb.append("<td width='100%' align='center' colspan='5'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Dossier Return Request Voucher</b></font></td> ");
	         }

	         sb.append("</tr>");
	         sb.append("<tr>");
	         sb.append("<td width='100%' align='center' colspan='5'>.</td> ");
	         sb.append("</tr>");
	         sb.append("<tr> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("CR No:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrCrNo()).append("</font></td> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Patient Name :</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >" + formBean.getStrPatientName() + "</font></td> ");
	         sb.append("<tr> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Issue No:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrIssueNo()).append("</font></td> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Issue Date:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrIssueDate()).append("</font></td> ");
	         sb.append("</tr> ");
	         sb.append("<tr> ");
	         if (!formBean.getStrMode().equals("4")) {
	            sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Issuing Store :</b></font></td> ");
	         } else {
	            sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Returning Store :</b></font></td> ");
	         }

	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrStoreName()).append("</font></td> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Raising Dept.:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrDeptName()).append("</font></td> ");
	         sb.append("</tr> ");
	         sb.append("</tr> ");
	         sb.append("<tr> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Dossier Name:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrDossierName()).append("</font></td> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Service Name:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrServiceName()).append("</font></td> ");
	         sb.append("</tr> ");
	         sb.append("<tr> ");
	         if (!formBean.getStrMode().equals("4")) {
	            sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Dossier Req No.:</b></font></td> ");
	            sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrBSReqNo()).append("</font></td> ");
	            sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ></td> ");
	            sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ></td> ");
	            sb.append("</tr> ");
	         }

	         sb.append("</table> ");
	         sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
	         sb.append("<tr>");
	         sb.append("<td colspan='4' align='left'><hr size='2'></td>");
	         sb.append("<td colspan='3' align='center'><hr size='2'></td>");
	         sb.append("</tr>");
	         sb.append("<tr bgcolor='#cdc9c9'> ");
	         sb.append("<td align='center' width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
	         sb.append("</td>");
	         sb.append("<td align='center' width='50%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
	         sb.append("</td>");
	         sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font> ");
	         sb.append("</td> ");
	         sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font>");
	         sb.append("</td> ");
	         if (!formBean.getStrMode().equals("4")) {
	            sb.append("<td align='right' width='8%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font>");
	         } else {
	            sb.append("<td align='right' width='8%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Return Qty</b></font>");
	         }

	         sb.append("</td> ");
	         sb.append("<td align='right'  width='8%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Dossier Rate(Rs.)</b></font>");
	         sb.append("</td> ");
	         sb.append("<td align='right'  width='9%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Dossier Cost(Rs.)</b></font>");
	         sb.append("</td> ");
	         sb.append("</tr> ");
	         sb.append("<tr>");
	         sb.append("<td colspan='4' align='left'><hr size='2'></td>");
	         sb.append("<td colspan='3' align='center'><hr size='2'></td>");
	         sb.append("</tr>");
	         float NetAmount = 0.0F;
	         String rem = "";
	         String user = "";
	         if (ws != null && ws.size() > 0) 
	         {
	            while(true) 
	            {
	               if (!ws.next()) {
	                  sb.append("<tr>");
	                  sb.append("<td colspan='4' align='left'><hr size='2'></td>");
	                  sb.append("<td colspan='3' align='center'><hr size='2'></td>");
	                  sb.append("</tr>");
	                  sb.append("<tr>");
	                  sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Return Dossier Cost (Rs.)</b></font></td>");
	                  sb.append("<td colspan='2' style='font-weight: bold' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	                  sb.append(HisUtil.getAmountWithDecimal((double)NetAmount, 2));
	                  sb.append("</font></td>");
	                  sb.append("</tr>");
	                  sb.append("<br><br><tr>");
	                  sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks </b></font>" + rem + "</td>");
	                  sb.append("<td colspan='3' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	                  
	                  if (!formBean.getStrMode().equals("4")) 
	                  {
	                	  sb.append("<b>Issue Request By : </b></font>" + user.split("-")[0] + "</td>");
	      	          } 
	                  else 
	                  {
	                	  sb.append("<b>Return Request By : </b></font>" + user.split("-")[0] + "</td>");
	      	          }
	                  
	                  
	                  sb.append("</tr>");
	                  sb.append("<tr>");
	                  sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >.</font></td>");
	                  sb.append("<td colspan='2' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	                  sb.append("</font></td>");
	                  sb.append("</tr>");
	                  sb.append("<br><br><tr> ");
	                  sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Additional Items :-<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
	                  sb.append("</tr> ");
	                  sb.append("<tr> ");
	                  sb.append("<td align='center' width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
	                  sb.append("</td>");
	                  sb.append("<td align='center' width='35%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
	                  sb.append("</td>");
	                  sb.append("<td align='right' width='7%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b>");
	                  sb.append("</td> ");
	                  sb.append("<td align='right' width='7%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font>");
	                  sb.append("</td> ");
	                  //sb.append("<td align='right' width='8%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Return Qty</b></font>");
	                  //sb.append("</td> ");
	                  sb.append("<td align='right' width='23%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Time</b></font>");
	                  sb.append("</td> ");
	                  sb.append("<td align='right'  width='15%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b> Dossier Rate(Rs.)</b></font>");
	                  sb.append("</td> ");
	                  sb.append("<td align='right'  width='15%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b> Dossier Cost(Rs.)</b></font>");
	                  sb.append("</td> ");
	                  sb.append("</tr> ");
	                  sb.append("<tr>");
	                  if (formBean.getStrMode().equals("4")) {
	                     i = 0;
	                     ws1 = formBean.getWsExtraIssueDetails();
	                     if (ws1 != null && ws1.size() > 0) {
	                        while(ws1.next()) {
	                           String[] tmp = ws1.getString(2).split("@");
	                           sb.append("<tr> ");
	                           StringBuilder var10001 = new StringBuilder("<td align='center' width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' >");
	                           ++i;
	                           sb.append(var10001.append(i).append("</font> ").toString());
	                           sb.append("</td>");
	                           sb.append("<td align='center' width='50%'><font face='Verdana, Arial, Helvetica, sans-serif' >" + ws1.getString(1) + "</font> ");
	                           sb.append("</td>");
	                           sb.append("<td align='right' width='7%'><font  face='Verdana, Arial, Helvetica, sans-serif' >" + ws1.getString(2).split("@")[0] + "</font>");
	                           sb.append("</td> ");
	                           sb.append("<td align='right' width='7%'><font  face='Verdana, Arial, Helvetica, sans-serif' >" + ws1.getString(3) + "</font>");
	                           sb.append("</td> ");
	                           //sb.append("<td align='right' width='8%'><font  face='Verdana, Arial, Helvetica, sans-serif' >" + ws1.getString(2).split("@")[2] + "</font>");
	                           //sb.append("</td> ");
	                           sb.append("<td align='right' width='23%'><font  face='Verdana, Arial, Helvetica, sans-serif' >" + ws1.getString(4) + "</font>");
	                           sb.append("</td> ");
	                           sb.append("<td align='right'  width='15%'><font  face='Verdana, Arial, Helvetica, sans-serif' >" + ws1.getString(2).split("@")[1] + "</font>");
	                           sb.append("</td> ");
	                           sb.append("<td align='right'  width='15%'><font  face='Verdana, Arial, Helvetica, sans-serif' >" + (double)Math.round(Double.parseDouble(tmp[1]) * Double.parseDouble(ws1.getString(3)) * 100.0D) / 100.0D + "</font>");
	                           sb.append("</td> ");
	                           sb.append("</tr> ");
	                        }
	                     }
	                  }

	                  sb.append("</tr>");
	                  break;
	               }

	               sb.append("<tr> ");
	               sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	               sb.append(i + ".");
	               sb.append("</font></td> ");
	               sb.append("<td align='left' width='50%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
	               if (ws.getString(1).equals("0")) {
	                  sb.append(".");
	               } else {
	                  sb.append(ws.getString(1));
	               }

	               sb.append("</font></td> ");
	               sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	               if (ws.getString(15).equals("-")) {
	                  sb.append("No Item to Return");
	               } else {
	                  sb.append(ws.getString(15));
	               }

	               sb.append("</font></td> ");
	               if (!formBean.getStrMode().equals("4")) {
	                  sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	                  sb.append(ws.getString(22));
	                  sb.append("</font></td> ");
	               } else {
	                  sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >.");
	                  sb.append("</font></td> ");
	               }

	               sb.append("<td style=\"text-align:right;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	               if (ws.getString(5).equals("0")) {
	                  sb.append(".");
	               } else {
	                  sb.append(Math.round(Double.parseDouble(ws.getString(5))));
	               }

	               sb.append("</font></td> ");
	               sb.append("<td style=\"text-align:right;\" width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	               if (ws.getString(4).equals("0")) {
	                  sb.append(".");
	               } else {
	                  sb.append(ws.getString(4));
	               }

	               sb.append("</font></td> ");
	               sb.append("<td style=\"text-align:right;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	               if (ws.getString(6).equals("0")) {
	                  sb.append(".");
	               } else {
	                  sb.append(ws.getString(6));
	               }

	               sb.append("</font></td> ");
	               sb.append("</tr> ");
	               NetAmount += Float.parseFloat(ws.getString(6));
	               ++i;
	               rem = ws.getString(16);
	               user = ws.getString(20);
	            }
	         } else {
	            sb.append("<tr> ");
	            sb.append("<td colspan='7' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>No item to Return</b><br/><br/></font></td> ");
	            sb.append("</tr> ");
	         }

	         sb.append("</table> ");
	         sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
	         sb.append("<tr>");
	         sb.append("<td width='10%'></td>");
	         sb.append("<td width='80%' align='center'><b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
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
   
   public static String settelmentVoucher(LPIssueDeskTransFB formBean) throws Exception 
   {
	      StringBuffer sb = new StringBuffer("");
	      int i = 1;
	      ResourceBundle res = null;
	      WebRowSet ws = null;
	      WebRowSet ws1 = null;
	      String strTableWidth = "825";

	      try {
	         res = qryHandler_mms.res;
	         if (res == null) {
	            res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
	            qryHandler_mms.res = res;
	         }

	         ws = formBean.getWsIssueDetails();
	         HisUtil hisUtil = new HisUtil("Global", "ReportUtil");
	         HospitalMstVO hospitalVO = hisUtil.getHospitalDetail(formBean.getStrHospitalCode());
	         
	         
	         System.out.println("hospitalVO.getAddress1()" + hospitalVO.getHospitalName());
	         //System.out.println("HLP Size---  " + ws.size());
	         
	         
	         sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
	         sb.append("<tr><td width='8%'>&nbsp;</td> ");
	         sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
	         sb.append(hospitalVO.getHospitalName());
	         sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
	         sb.append("</tr> ");
	         sb.append("<tr> ");
	         sb.append("<td width='8%'>&nbsp;</td> ");
	         sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
	         sb.append((hospitalVO.getAddress1() != "" && hospitalVO.getAddress1() != null ? hospitalVO.getAddress1() + "," : " ") + (hospitalVO.getAddress2() != "" && hospitalVO.getAddress2() != null ? hospitalVO.getAddress2() + "," : " ") + (hospitalVO.getCity() != "" && hospitalVO.getCity() != null ? hospitalVO.getCity() + "," : " ") + (hospitalVO.getPinCode() != "" && hospitalVO.getPinCode() != null ? hospitalVO.getPinCode() : " "));
	         sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
	         sb.append("</tr> ");
	         sb.append("<tr> ");
	         sb.append("<td width='8%'>&nbsp;</td> ");
	         sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
	         sb.append("</font></b></td><td width='10%'>&nbsp; ");
	         sb.append("</td> ");
	         sb.append("</tr> ");
	         sb.append("</table> ");
	         sb.append("<table border='0' width='" + strTableWidth + "' align='center'> ");
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
	         sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
	         sb.append("<tr>");
	         sb.append("<td width='100%' align='center' colspan='5'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Dossier Settelment Voucher</b></font></td> ");
	        

	         sb.append("</tr>");
	         sb.append("<tr>");
	         sb.append("<td width='100%' align='center' colspan='5'>.</td> ");
	         sb.append("</tr>");
	         sb.append("<tr> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("CR No:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrCrNo()).append("</font></td> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Patient Name :</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >" + formBean.getStrPatientName() + "</font></td> ");
	         sb.append("<tr> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Issue No:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrIssueNo()).append("</font></td> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Issue Date:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrIssueDate()).append("</font></td> ");
	         sb.append("</tr> ");
	         sb.append("<tr> ");	         
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Store :</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrStoreName()).append("</font></td> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Raising Dept.:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrDeptName()).append("</font></td> ");
	         sb.append("</tr> ");
	         sb.append("</tr> ");
	         sb.append("<tr> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Dossier Name:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrDossierName()).append("</font></td> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Service Name:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrServiceName()).append("</font></td> ");
	         sb.append("</tr> ");
	       
	         
	         sb.append("<tr> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Settele By:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrSetteledByName()).append("</font></td> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Settele On Date:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrSetteledOnDate()).append("</font></td> ");
	         sb.append("</tr> ");
	         
	         sb.append("<tr> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Dossier Req No.:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrBSReqNo()).append("</font></td> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ></td> ");
	         sb.append("</tr> ");
	         	        	         
	         sb.append("</table> ");
	         sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
	         sb.append("<tr>");
	         sb.append("<td colspan='4' align='left'><hr size='2'></td>");
	         sb.append("<td colspan='3' align='center'><hr size='2'></td>");
	         sb.append("</tr>");
	         sb.append("<tr bgcolor='#cdc9c9'> ");
	         sb.append("<td align='center' width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
	         sb.append("</td>");
	         sb.append("<td align='center' width='50%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
	         sb.append("</td>");
	         sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font> ");
	         sb.append("</td> ");
	         sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font>");
	         sb.append("</td> ");        
	         sb.append("<td align='right' width='8%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font>");
	         sb.append("</td> ");
	         sb.append("<td align='right'  width='8%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Dossier Rate(Rs.)</b></font>");
	         sb.append("</td> ");
	         sb.append("<td align='right'  width='9%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Dossier Cost(Rs.)</b></font>");
	         sb.append("</td> ");
	         sb.append("</tr> ");
	         sb.append("<tr>");
	         sb.append("<td colspan='4' align='left'><hr size='2'></td>");
	         sb.append("<td colspan='3' align='center'><hr size='2'></td>");
	         sb.append("</tr>");
	         float NetAmount = 0.0F;
	         String rem = "";
	         String user = "";
	         if (ws != null && ws.size() > 0) 
	         {
	            while(true) 
	            {
	               if (!ws.next()) 
	               {
	                  sb.append("<tr>");
	                  sb.append("<td colspan='4' align='left'><hr size='2'></td>");
	                  sb.append("<td colspan='3' align='center'><hr size='2'></td>");
	                  sb.append("</tr>");
	                  sb.append("<tr>");
	                  sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Dossier Cost (Rs.)</b></font></td>");
	                  sb.append("<td colspan='2' style='font-weight: bold' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	                  sb.append(HisUtil.getAmountWithDecimal((double)NetAmount, 2));
	                  sb.append("</font></td>");
	                  sb.append("</tr>");
	                  sb.append("<br><br><tr>");
	                  sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks </b></font>" + rem + "</td>");
	                  sb.append("<td colspan='3' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	                  sb.append("<b>Settle By : </b></font>" + user.split("-")[0] + "</td>");
	                  sb.append("</tr>");
	                  sb.append("<tr>");
	                  sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >.</font></td>");
	                  sb.append("<td colspan='2' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	                  sb.append("</font></td>");
	                  sb.append("</tr>");
	                  /*sb.append("<br><br><tr> ");
	                  sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Additional Items :-<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
	                  sb.append("</tr> ");
	                  sb.append("<tr> ");
	                  sb.append("<td align='center' width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
	                  sb.append("</td>");
	                  sb.append("<td align='center' width='35%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
	                  sb.append("</td>");
	                  sb.append("<td align='right' width='7%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b>");
	                  sb.append("</td> ");
	                  sb.append("<td align='right' width='7%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font>");
	                  sb.append("</td> ");	                 
	                  sb.append("<td align='right' width='23%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Time</b></font>");
	                  sb.append("</td> ");
	                  sb.append("<td align='right'  width='15%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b> Dossier Rate(Rs.)</b></font>");
	                  sb.append("</td> ");
	                  sb.append("<td align='right'  width='15%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b> Dossier Cost(Rs.)</b></font>");
	                  sb.append("</td> ");
	                  sb.append("</tr> ");
	                  sb.append("<tr>");	                  

	                  sb.append("</tr>");*/
	                  break;
	               }

	               sb.append("<tr> ");
	               sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	               sb.append(i + ".");
	               sb.append("</font></td> ");
	               sb.append("<td align='left' width='50%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
	               if (ws.getString(1).equals("0")) {
	                  sb.append(".");
	               } else {
	                  sb.append(ws.getString(1));
	               }

	               sb.append("</font></td> ");
	               sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	               if (ws.getString(15).equals("-")) {
	                  sb.append("No Item to Return");
	               } else {
	                  sb.append(ws.getString(15));
	               }

	               sb.append("</font></td> ");
	               if (!formBean.getStrMode().equals("4")) {
	                  sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	                  sb.append(ws.getString(22));
	                  sb.append("</font></td> ");
	               } else {
	                  sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >.");
	                  sb.append("</font></td> ");
	               }

	               sb.append("<td style=\"text-align:right;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	               if (ws.getString(5).equals("0")) {
	                  sb.append(".");
	               } else {
	                  sb.append(Math.round(Double.parseDouble(ws.getString(5))));
	               }

	               sb.append("</font></td> ");
	               sb.append("<td style=\"text-align:right;\" width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	               if (ws.getString(4).equals("0")) {
	                  sb.append(".");
	               } else {
	                  sb.append(ws.getString(4));
	               }

	               sb.append("</font></td> ");
	               sb.append("<td style=\"text-align:right;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	               if (ws.getString(6).equals("0")) {
	                  sb.append(".");
	               } else {
	                  sb.append(ws.getString(6));
	               }

	               sb.append("</font></td> ");
	               sb.append("</tr> ");
	               NetAmount += Float.parseFloat(ws.getString(6));
	               ++i;
	               rem = ws.getString(16);
	               user = ws.getString(20);
	            }
	         } else {
	            sb.append("<tr> ");
	            sb.append("<td colspan='7' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>No item</b><br/><br/></font></td> ");
	            sb.append("</tr> ");
	         }

	         sb.append("</table> ");
	         sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
	         sb.append("<tr>");
	         sb.append("<td width='10%'></td>");
	         sb.append("<td width='80%' align='center'><b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
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
   
   public static String getAddItemView(LPIssueDeskTransFB formBean) throws Exception {
	      StringBuffer sb = new StringBuffer("");
	      int i = 1; 
	     
	      WebRowSet ws1 = null;
	      String strTableWidth = "825";

	      try 
	      {
	        
	         HisUtil hisUtil = new HisUtil("Global", "ReportUtil");
	         HospitalMstVO hospitalVO = hisUtil.getHospitalDetail(formBean.getStrHospitalCode());
	         
	         /*
	            1.Issue No
	            2.Issue Date
	            3.Req No
	            4.Req Date
	            5.Patient Name
	            6.Issuing Store Name
	            7.DeptName_Unit Name
	           */
	         
	         //System.out.println("hospitalVO.getAddress1()" + hospitalVO.getHospitalName());	         
	         sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
	         sb.append("<tr><td width='8%'>&nbsp;</td> ");
	         sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
	         sb.append(hospitalVO.getHospitalName());
	         sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
	         sb.append("</tr> ");
	         sb.append("<tr> ");
	         sb.append("<td width='8%'>&nbsp;</td> ");
	         sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
	         sb.append((hospitalVO.getAddress1() != "" && hospitalVO.getAddress1() != null ? hospitalVO.getAddress1() + "," : " ") + (hospitalVO.getAddress2() != "" && hospitalVO.getAddress2() != null ? hospitalVO.getAddress2() + "," : " ") + (hospitalVO.getCity() != "" && hospitalVO.getCity() != null ? hospitalVO.getCity() + "," : " ") + (hospitalVO.getPinCode() != "" && hospitalVO.getPinCode() != null ? hospitalVO.getPinCode() : " "));
	         sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
	         sb.append("</tr> ");
	         sb.append("<tr> ");
	         sb.append("<td width='8%'>&nbsp;</td> ");
	         sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
	         sb.append("</font></b></td><td width='10%'>&nbsp; ");
	         sb.append("</td> ");
	         sb.append("</tr> ");
	         sb.append("</table> ");
	      
	         sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
	         sb.append("<tr>");	         
	         sb.append("<td width='100%' align='center' colspan='5'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Dossier Additional Item Details</b></font></td> ");
	         sb.append("</tr>");
	         sb.append("<tr>");
	         sb.append("<td width='100%' align='center' colspan='5'>.</td> ");
	         sb.append("</tr>");
	         sb.append("<tr> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Issue No:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrIssueNo()).append("</font></td> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Date :</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >" + formBean.getStrIssueDate() + "</font></td> ");
	         sb.append("</tr>");
	         sb.append("<tr> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Req No:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrReqStatusName()).append("</font></td> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Req Date :</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >" + formBean.getStrRequestDate() + "</font></td> ");
	         sb.append("</tr>");
	         sb.append("<tr> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("CR No:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrCrNo()).append("</font></td> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Patient Name :</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >" + formBean.getStrPatientName() + "</font></td> ");
	         sb.append("</tr>");
	         sb.append("<tr> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Issuing Store:</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(formBean.getStrStoreName()).append("</font></td> ");
	         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Dept/Unit :</b></font></td> ");
	         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >" + formBean.getStrDeptName() + "</font></td> ");
	         sb.append("</tr>");
	         sb.append("</table> ");
	         sb.append("<table border='0' width='" + strTableWidth + "' align='center'> ");
	         sb.append("<tr> ");
	         sb.append("<td align='right'>");
	         sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
	         sb.append("<img style='cursor: pointer; '  name='PrintPage' tabindex='1' title='Print Page'");
	         sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne(1);'/> <img style='cursor: pointer; ' title='Cancel Process'  ");
	         sb.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopupOne();' /></div>");
	         sb.append(" </td> ");
	         sb.append(" </tr> ");
	         sb.append(" </table> ");
	         
	         
	         /*****************************************************   Additional Items :-   ********************************************************/
	         
	         sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
	         sb.append("<tr>");
	         sb.append("<td colspan='4' align='left'><hr size='2'></td>");
	         sb.append("<td colspan='3' align='center'><hr size='2'></td>");
	         sb.append("</tr>");
	         sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Additional Items :-<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
	         sb.append("</tr> ");
	         sb.append("<tr> ");
	         sb.append("<td align='center' width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
	         sb.append("</td>");
	         sb.append("<td align='center' width='35%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
	         sb.append("</td>");
	         sb.append("<td align='right' width='7%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b>");
	         sb.append("</td> ");
	         sb.append("<td align='right' width='7%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font>");
	         sb.append("</td> ");
	         sb.append("<td align='right' width='8%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Return Qty</b></font>");
	         sb.append("</td> ");
	         sb.append("<td align='right' width='23%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Time</b></font>");
	         sb.append("</td> ");
	         sb.append("<td align='right'  width='15%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b> Dossier Rate(Rs.)</b></font>");
	         sb.append("</td> ");
	         sb.append("<td align='right'  width='15%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b> Dossier Cost(Rs.)</b></font>");
	         sb.append("</td> ");
	         sb.append("</tr> ");
	         sb.append("<tr>");
	         if (formBean.getStrMode().equals("4")) 
	         {
	            i = 0;
	            System.out.println("In HLP Extra Item . Size of --------"+formBean.getWsExtraIssueDetails().size());
	            ws1 = formBean.getWsExtraIssueDetails();
	            
	            if (ws1 != null && ws1.size() > 0) 
	            {
	               while(ws1.next()) 
	               {
	                  String[] tmp = ws1.getString(2).split("@");
	                  sb.append("<tr> ");
	                  StringBuilder var10001 = new StringBuilder("<td align='center' width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' >");
	                  ++i;
	                  sb.append(var10001.append(i).append("</font> ").toString());
	                  sb.append("</td>");
	                  sb.append("<td align='center' width='50%'><font face='Verdana, Arial, Helvetica, sans-serif' >" + ws1.getString(1) + "</font> ");
	                  sb.append("</td>");
	                  sb.append("<td align='right' width='7%'><font  face='Verdana, Arial, Helvetica, sans-serif' >" + ws1.getString(2).split("@")[0] + "</font>");
	                  sb.append("</td> ");
	                  sb.append("<td align='right' width='7%'><font  face='Verdana, Arial, Helvetica, sans-serif' >" + ws1.getString(3) + "</font>");
	                  sb.append("</td> ");
	                  sb.append("<td align='right' width='8%'><font  face='Verdana, Arial, Helvetica, sans-serif' >" + ws1.getString(2).split("@")[2] + "</font>");
	                  sb.append("</td> ");
	                  sb.append("<td align='right' width='23%'><font  face='Verdana, Arial, Helvetica, sans-serif' >" + ws1.getString(4) + "</font>");
	                  sb.append("</td> ");
	                  sb.append("<td align='right'  width='15%'><font  face='Verdana, Arial, Helvetica, sans-serif' >" + ws1.getString(2).split("@")[1] + "</font>");
	                  sb.append("</td> ");
	                  sb.append("<td align='right'  width='15%'><font  face='Verdana, Arial, Helvetica, sans-serif' >" + (double)Math.round(Double.parseDouble(tmp[1]) * Double.parseDouble(ws1.getString(3)) * 100.0D) / 100.0D + "</font>");
	                  sb.append("</td> ");
	                  sb.append("</tr> ");
	               }
	            }
	         }

	         sb.append("</tr>");
	         sb.append("</table> ");
	         
	         sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
	         sb.append("<tr>");
	         sb.append("<td width='10%'></td>");
	         sb.append("<td width='80%' align='center'><b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
	         sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
	         sb.append("</tr> ");
	         sb.append("</table>");
	      } catch (Exception var16) {
	         var16.printStackTrace();
	         throw var16;
	      } finally {
	         if (ws1 != null) {
	            ws1.close();
	            ws1 = null;
	         }

	      }

	      return sb.toString();
	   }

   public static String getIssueItemDetailsForIssueView(WebRowSet wb, String strCostReq, String strIssueStoreID, String hosCode, String strRaisingStoreId, String lpReqNo, LPIssueDeskTransVO voObj) throws SQLException {
      StringBuffer buff = null;
      Double itemFinalCost = 0.0D;
      LPIssueDeskTransVO vo = null;
      LPIssueDeskTransBO bo = null;

      try {
         vo = new LPIssueDeskTransVO();
         bo = new LPIssueDeskTransBO();
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
         String strItemType = "";
         String avlQty = "";
         String[] temp = null;
         Double itemCost = 0.0D;
         String strTotalNoOfBatch = "";
         String strHiddenId = "";
         String TariffFlag = "0";
         String strBillNo = "0";
         WebRowSet brandWs = null;
         int i = 0;
         if (wb != null) {
            buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
            buff.append("<tr>");
            buff.append("<td width='20%' class='multiLabel' align='left'>Item Name</td>");
            buff.append("<td width='10%' class='multiLabel' align='left'>Item Type</td>");
            buff.append("<td width='10%' class='multiLabel' align='left'>Available Qty</td>");
            buff.append("<td width='10%' class='multiLabel' align='left'>Request Qty</td>");
            buff.append("<td width='10%' class='multiLabel' align='left'>Issue Qty</td>");
            buff.append("</tr>");
            if (wb.size() == 0) {
               buff.append("<tr>");
               if (strCostReq.equals("1")) {
                  buff.append("<td class='multiControl' colspan='6'><font color='red'>No Record Found/Patient is not admitted</font></td>");
               } else {
                  buff.append("<td class='multiControl' colspan='5'><font color='red'>No Record Found/Patient is not admitted</font></td>");
               }

               buff.append("</tr>");
               buff.append("</table>");
            } else {
               while(wb.next()) {
                  ++i;
                  strItemId = wb.getString(1);
                  strItemBrandId = wb.getString(2);
                  avlQty = wb.getString(6);
                  strBatchSlNo = wb.getString(9);
                  strIssueQty = wb.getString(3);
                  strIssueUnitId = wb.getString(4);
                  strItemName = wb.getString(7);
                  strUnitName = wb.getString(5);
                  (new StringBuilder(String.valueOf(wb.getString(1)))).append("^").append(wb.getString(2)).toString();
                  String strMRP = wb.getString(11) == null ? "0" : wb.getString(11);
                  String strItemCat = wb.getString(12) == null ? "0" : wb.getString(12);
                  strItemType = wb.getString(13) == null ? "0" : wb.getString(13);
                  TariffFlag = "1";
                  vo.setStrHospitalCode(hosCode);
                  voObj.setStrItemId(strItemId);
                  if (voObj.getStrPatientType().equalsIgnoreCase("2")) {
                     strBillNo = wb.getString(14) == null ? "0" : wb.getString(14);
                  }

                  if (Float.parseFloat(avlQty) < Float.parseFloat(strIssueQty)) {
                     bo.getBrandDetails(voObj);
                     brandWs = voObj.getBrandDtlWs();
                  }

                  hiddenParam = strItemId + "@" + strItemBrandId + "@" + strIssueQty + "@" + strIssueUnitId + "@" + avlQty + "@" + strBatchSlNo + "@" + strMRP + "@" + strItemCat;
                  if (!strRate.equals("0") && !strRateUnit.equals("0") && !strManuFacturingDate.equals("0") && !strInHandQty.equals("0") && !avlQty.equals("0")) {
                     buff.append("<tr>");
                     buff.append("<td width='30%' class='multiControl'><div id='itmNm" + i + "'> " + strItemName + " </div><input type='hidden' id='strItemParamValue" + i + "' name='strItemParamValue' value='" + hiddenParam + "' /></td>");
                     buff.append("<input type='hidden' id='strBillNo" + i + "' name='strBillNo' value='" + strBillNo + "' />");
                     buff.append("<td width='10%' class='multiControl' align='left'>" + strItemType + "</td>");
                     if (Float.parseFloat(avlQty) < Float.parseFloat(strIssueQty) && brandWs.size() != 0) {
                        if (brandWs.size() == 1) {
                           brandWs.next();
                           buff.append("<td width='10%' class='multiControl' align='left'><input type='hidden' name='brandHiddenVal' id = 'brandHiddenVal" + i + 1 + "' value='" + brandWs.getString(1) + "^" + brandWs.getString(2) + "^" + brandWs.getString(3) + "^" + brandWs.getString(4) + "^" + brandWs.getString(5) + "^" + brandWs.getString(6) + "' > <div id='availQty" + i + "'>" + avlQty + "</div></td>");
                        } else {
                           buff.append("<TD WIDTH='10%' id='td99" + i + "' CLASS='multiPOControl'  ><input type='hidden' name='brandDtlsId' id='brandDtlsId" + i + "' value='' >" + "<div name='brandDtl' id='brandDtl" + i + "'></div>" + "<div id='availQty" + i + "'><a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='callBrandDetails(\"" + i + "\");' TITLE='Click Here For other brand names available in store' ><div 'autodiv" + i + "'>auto</div></a></div>");
                           buff.append("<div id = 'divBrandDtlId" + i + "' class='popup' style='display: none; left:500px; top:210px;' >");
                           buff.append("<table width='500' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
                           if (brandWs.size() != 0) {
                              buff.append("<tr class='HEADER' ><td colspan=7 align='left'>Item Name : " + strItemName + " with sanctioned qty. : " + strIssueQty + " </td></tr> ");
                              buff.append("<tr class='HEADER'>");
                              buff.append("<td width='70%' class='multiLabel'><div align='left'> Alternate Items</div>");
                              buff.append("</td><td width='20%' class='multiLabel'>Avl. Qty");
                              buff.append("</td><td width='5%' class='multiLabel'>#");
                              buff.append("</td>");
                              buff.append("<th align='right' colspan=7><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp Window' src='../../hisglobal/images/popUp_cancel.JPG'");
                              buff.append(" onClick='hide_popup_menu(\"divBrandDtlId" + i);
                              buff.append("\");'></th></tr>");
                              buff.append("</table>");
                              buff.append("<table width='500' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
                              int j = 0;

                              while(brandWs.next()) {
                                 ++j;
                                 if (j == 1) {
                                    buff.append("<tr>");
                                    buff.append("<td width='50%' class='multiControl'><input type='hidden' name='brandHiddenVal' id = 'brandHiddenVal" + i + j + "' value='" + brandWs.getString(1) + "^" + brandWs.getString(2) + "^" + brandWs.getString(3) + "^" + brandWs.getString(4) + "^" + brandWs.getString(5) + "^" + brandWs.getString(6) + "' > ");
                                    buff.append("<div align='left'>" + brandWs.getString(4) + "</div> ");
                                    buff.append("</td><td width='20%' class='multiControl'>");
                                    buff.append(brandWs.getString(3));
                                    buff.append("</td><td width='10%' class='multiLabel'><input type='radio' onclick='setItemDtl(" + i + "," + i + j + ")' name='strBrandDtlsChk' id='strBrandDtlsChk" + i + "' > ");
                                    buff.append("</td></tr>");
                                 } else {
                                    buff.append("<tr>");
                                    buff.append("<td width='50%' class='multiControl'><input type='hidden' name='brandHiddenVal' id = 'brandHiddenVal" + i + j + "' value='" + brandWs.getString(1) + "^" + brandWs.getString(2) + "^" + brandWs.getString(3) + "^" + brandWs.getString(4) + "^" + brandWs.getString(5) + "^" + brandWs.getString(6) + "' > ");
                                    buff.append("<div align='left'>" + brandWs.getString(4) + "</div> ");
                                    buff.append("</td><td width='20%' class='multiControl'>");
                                    buff.append(brandWs.getString(3));
                                    buff.append("</td><td width='10%' class='multiLabel'><input type='radio' onclick='setItemDtl(" + i + "," + i + j + ")' name='strBrandDtlsChk' id='strBrandDtlsChk" + i + "' > ");
                                    buff.append("</td></tr>");
                                 }
                              }
                           } else {
                              buff.append("<tr class='HEADER'>");
                              buff.append("<th align='right' colspan=4><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp Window' src='../../hisglobal/images/popUp_cancel.JPG'");
                              buff.append("onClick='hide_popup_menu(\"divBrandDtlId" + i);
                              buff.append("\");'></th>");
                              buff.append("</tr>");
                              buff.append("</table>");
                              buff.append("<table width='300' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
                              buff.append("<tr>");
                              buff.append("<td colspan='3'  CLASS='multiControl' ><DIV class='errMsg' align='center'>No Record Found</div></TD>");
                              buff.append("</tr>");
                           }

                           buff.append("<tr class='HEADER'><td colspan='7' align='left' ><font color='white'>Items marked with * are non branded</font></td></tr>");
                           buff.append("</table>");
                           buff.append("</div>");
                        }
                     } else {
                        buff.append("<td width='10%' class='multiControl' align='left'><input type='hidden' name='brandHiddenVal' id = 'brandHiddenVal" + i + 1 + "' value='" + 0 + "^" + 0 + "^" + 0 + "^" + 0 + "^" + 0 + "^" + 0 + "' > <div id='availQty" + i + "'>" + avlQty + "</div></td>");
                     }

                     buff.append("</td>");
                     buff.append("<td width='10%' width='10%' class='multiControl' align='left'>" + strIssueQty + " " + strUnitName + "</td>");
                     if (lpReqNo.equals("0")) {
                        if (Integer.parseInt(TariffFlag) > 0) {
                           buff.append("<td width='10%' class='multiControl' align='left'><input type='hidden' class='txtFldNormal' id='strIssueQuantity" + i + "' name='strIssueQuantity' value='" + (Double.parseDouble(strIssueQty.split(" ")[0]) <= Double.parseDouble(avlQty.split(" ")[0]) ? strIssueQty.split(" ")[0] : "") + "'>");
                           buff.append(Double.parseDouble(strIssueQty.split(" ")[0]) <= Double.parseDouble(avlQty.split(" ")[0]) ? strIssueQty.split(" ")[0] : "");
                           buff.append("</td>");
                        } else {
                           buff.append("<td width='10%' class='multiControl' align='left'><input type='hidden' disabled=true class='txtFldNormal' readonly id='strIssueQuantity" + i + "' name='strIssueQuantity' value='0'>");
                           buff.append("0");
                           buff.append("</td>");
                        }
                     } else {
                        buff.append("<td width='10%' class='multiControl' align='left'><input type='hidden' class='txtFldNormal' id='strIssueQuantity" + i + "' name='strIssueQuantity' value='" + (Double.parseDouble(strIssueQty.split(" ")[0]) <= Double.parseDouble(avlQty.split(" ")[0]) ? strIssueQty.split(" ")[0] : "") + "'></td>");
                        buff.append(Double.parseDouble(strIssueQty.split(" ")[0]) <= Double.parseDouble(avlQty.split(" ")[0]) ? strIssueQty.split(" ")[0] : "");
                        buff.append("</td>");
                     }

                     buff.append("</tr>");
                  } else {
                     buff.append("<tr>");
                     buff.append("<td width='30%' class='multiControl'>" + strItemName + "<input type='hidden' id='strItemParamValue" + i + "' name='strItemParamValue' value='" + hiddenParam + "' /></td>");
                     buff.append("<td width='10%' class='multiControl' align='left'>" + strItemType + "</td>");
                     buff.append("<td width='10%' class='multiControl' align='left'>" + avlQty + "</td>");
                     buff.append("<td width='10%' class='multiControl' align='left'>" + strIssueQty + " " + strUnitName + "</td>");
                     System.out.println(Double.parseDouble(avlQty.split(" ")[0]));
                     buff.append("<td width='10%' class='multiControl' align='left'><input type='hidden' class='txtFldNormal' readonly id='strIssueQuantity" + i + "' name='strIssueQuantity' value='" + (Double.parseDouble(avlQty.split(" ")[0]) != 0.0D ? avlQty.split(" ")[0] : "0") + "' onkeypress='return validateData(event,7);' onkeyup='QtyValidation(" + i + ")'>");
                     buff.append(Double.parseDouble(avlQty.split(" ")[0]) != 0.0D ? avlQty.split(" ")[0] : "0");
                     buff.append("</td>");
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
               buff.append("<td class='multiControl' colspan='1' width='12%'><input type='hidden' name='strFinalCosttt' value='" + itemFinalCost + "'/>" + "<font color='red'><b>Rs." + Math.round(itemFinalCost) + "</b></font></td>");
               buff.append("</tr>");
               buff.append("<tr>");
               buff.append("<td bgcolor='black' colspan='6'></td>");
               buff.append("</tr>");
               buff.append("</table>");
               buff.append("</div>");
            }
         }
      } catch (Exception var39) {
         Exception _err = var39;

         try {
            _err.printStackTrace();
            throw new Exception("LPIssueDeskTransHLP---->getIssueItemDetails" + _err.getMessage());
         } catch (Exception var38) {
            var38.printStackTrace();
         }
      }

      return buff.toString();
   }

   public static String getIssuedItemDetailsForReturnView(WebRowSet wb, String hosp_code, String strCostReq) throws SQLException {
      StringBuffer buff = null;
      Double itemFinalCost = 0.0D;
      LPIssueDeskTransVO vo = null;
      LPIssueDeskTransBO bo = null;
      String strReturnUnitCombo = "";
      HisUtil hisutil = null;

      try {
         buff = new StringBuffer();
         int i = 0;
         vo = new LPIssueDeskTransVO();
         bo = new LPIssueDeskTransBO();
         hisutil = new HisUtil("MMS", "LPIssueDeskTransHLP");
         String[] temp = null;
         if (wb != null) {
            buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
            buff.append("<tr>");
            buff.append("<td class='multiLabel' >Item Name</td>");
            buff.append("<td class='multiLabel' >Batch/Sl.no.</td>");
            buff.append("<td class='multiLabel' >Expiry Date</td>");
            buff.append("<td class='multiLabel' >Balance Qty</td>");
            buff.append("<td class='multiLabel' >Return Qty.</td>");
            buff.append("<td class='multiLabel' >Unit</td>");
            if (strCostReq.equals("1")) {
               buff.append("<td class='multiLabel' >Cost</td>");
            }

            buff.append("</tr>");
            if (wb.size() == 0) {
               buff.append("<tr>");
               if (strCostReq.equals("1")) {
                  buff.append("<td class='multiControl' colspan='7'><font color='red'><b>No Record Found/Patient is not admitted</b></font></td>");
               } else {
                  buff.append("<td class='multiControl' colspan='6'><font color='red'><b>No Record Found/Patient is not admitted</b></font></td>");
               }

               buff.append("</tr>");
               buff.append("</table>");
            } else {
               while(true) {
                  if (!wb.next()) {
                     buff.append("</table>");
                     if (strCostReq.equals("1")) {
                        buff.append("<div id='totalCostDivId'>");
                     } else {
                        buff.append("<div id='totalCostDivId' style='display:none'>");
                     }

                     buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
                     buff.append("<tr>");
                     buff.append("<td bgcolor='black' colspan='7'></td>");
                     buff.append("</tr>");
                     buff.append("<tr>");
                     buff.append("<td class='multiControl' width='90%' ><div align='right'><b>TOTAL COST</b></div></td>");
                     buff.append("<td class='multiControl' width='10%'><div id='finalCostId'><font color='red'><b>Rs 0.00</b></font></div><input type='hidden' name='strFinalCost' value='" + itemFinalCost + "'/>" + "</td>");
                     buff.append("</tr>");
                     buff.append("<tr>");
                     buff.append("<td bgcolor='black' colspan='7'></td>");
                     buff.append("</tr>");
                     buff.append("</table>");
                     buff.append("</div>");
                     break;
                  }

                  temp = wb.getString(1).replace('@', '#').split("#");
                  vo.setStrHospitalCode(hosp_code);
                  vo.setStrBalanceQtUnitId(temp[1]);
                  bo.getUnitCombo(vo);
                  if (vo.getUnitComboWs() != null && vo.getUnitComboWs().size() > 0) {
                     hisutil.getOptionValue(vo.getUnitComboWs(), "", "", true);
                  } else {
                     strReturnUnitCombo = "<option value='0'>Select Value</option>";
                  }

                  System.out.println(wb.getString(8));
                  if (!wb.getString(8).equals("-1") && !wb.getString(8).equals("0")) {
                     buff.append("<tr>");
                     buff.append("<td class='multiControl' >" + wb.getString(2) + "<input type='hidden' name='strItemParamValue' id='strItemParamValue" + i + "' value='" + wb.getString(1) + "' /></td>");
                     buff.append("<td class='multiControl' >" + wb.getString(3) + "</td>");
                     buff.append("<td class='multiControl' ><font color='red'>" + (wb.getString(6).equals(" ") ? "NA" : wb.getString(6)) + "</font></td>");
                     buff.append("<td class='multiControl' ><a  onclick='openSpecification(this," + i + ");' style='color:blue; cursor:pointer;' title='Click Here To View Balance Detail' >" + wb.getString(4) + " " + wb.getString(5) + "</a>");
                     buff.append("<input type='hidden' name='strItemDtl' id='strItemDtl" + i + "' value='" + wb.getString(4) + "@" + wb.getString(5) + "@" + wb.getString(7) + "'>" + "<input type='hidden' name='strBalanceQty' id='strBalanceQty" + i + "' value='" + wb.getString(4) + "' />" + "</td>");
                     buff.append("<td class='multiControl' >" + wb.getString(7) + "<input type='hidden' autocomplete='off' name='strReturnQty' id='strReturnQty" + i + "' value='" + wb.getString(7) + "' class='txtFldSmall'  maxlength='8' onkeypress='return validateData(event,7);', onkeyup='quantityUnitValue(" + i + ");'></td>");
                     buff.append("<td class='multiControl' ><input type='hidden' name='itemCost' id='itemCost" + i + "' value=''>No.");
                     if (!strCostReq.equals("1")) {
                        buff.append("<div id='itemCostId" + i + "' style='display:none'>0.00</div>");
                     }

                     buff.append("</td>");
                     if (strCostReq.equals("1")) {
                        buff.append("<td class='multiControl' ><div id='itemCostId" + i + "'>0.00</div></td>");
                     }

                     buff.append("</tr>");
                  } else {
                     buff.append("<tr>");
                     buff.append("<td class='multiControlRed' >" + wb.getString(2) + "</td>");
                     buff.append("<td class='multiControlRed' >" + wb.getString(3) + "</td>");
                     buff.append("<td class='multiControlRed' >" + wb.getString(6) + "</td>");
                     buff.append("<td class='multiControlRed' >" + wb.getString(4) + " " + wb.getString(5) + "<input type='hidden' name='strBalanceQty' id='strBalanceQty" + i + "' value='" + wb.getString(4) + "' />" + "</td>");
                     buff.append("<td class='multiControlRed' >" + wb.getString(5) + "<input type='hidden' name='strReturnQty'  id='strReturnQty" + i + "'></td>");
                     buff.append("<td class='multiControlRed' >" + wb.getString(5) + "</td>");
                     if (strCostReq.equals("1")) {
                        buff.append("<td class='multiControlRed' >-</td>");
                     }

                     buff.append("</tr>");
                  }

                  ++i;
               }
            }
         }
      } catch (Exception var12) {
         Exception _err = var12;

         try {
            _err.printStackTrace();
            throw new Exception("LPIssueDeskTransHLP---->getIssuedItemDetails" + _err.getMessage());
         } catch (Exception var11) {
         }
      }

      return buff.toString();
   }
   
   
   public static String getIssueItemDetailsForSettelmentView(WebRowSet wb, String strCostReq, String strIssueStoreID, String hosCode, String strRaisingStoreId, String lpReqNo, LPIssueDeskTransVO voObj) throws SQLException {
	      StringBuffer buff = null;
	     

	      try 
	      {
	        
	         buff = new StringBuffer();	        
	         int i = 0;
	         if (wb != null) 
	         {
	            buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
	            buff.append("<tr>");
	            buff.append("<td width='20%' class='multiLabel' align='left'>Item Name</td>");
	            buff.append("<td width='15%' class='multiLabel' align='left'>Batch</td>");
	            buff.append("<td width='15%' class='multiLabel' align='left'>Exp Date</td>");
	            buff.append("<td width='15%' class='multiLabel' align='left'>Issue Qty</td>");
	            buff.append("<td width='15%' class='multiLabel' align='left'>Rate</td>");
	            buff.append("<td width='15%' class='multiLabel' align='left'>Cost</td>");
	            buff.append("</tr>");
	            if (wb.size() == 0) 
	            {
	               buff.append("<tr>");
	               if (strCostReq.equals("1")) 
	               {
	                  buff.append("<td class='multiControl' colspan='6'><font color='red'>No Record Found/Patient is not admitted</font></td>");
	               } 
	               else 
	               {
	                  buff.append("<td class='multiControl' colspan='6'><font color='red'>No Record Found/Patient is not admitted</font></td>");
	               }

	               buff.append("</tr>");
	               buff.append("</table>");
	            } 
	            else 
	            {
	               buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");	
	               while(wb.next()) 
	               {
	                     ++i;
	                     /*
	                      * 1.Item Name
	                      * 2.Brand Id
	                      * 3 0
	                      * 4.Rate
	                      * 5.Issue Qty
	                      * 6.Cost
	                      * 15.BATCH
	                      * 22.EXP DATE
	                      * */
	                  
	                     buff.append("<tr>");
	                     buff.append("<td width='20%' class='multiControl' align='left'>" + wb.getString(1) + "</td>");
	                     buff.append("<td width='15%' class='multiControl' align='center'>" + wb.getString(15) + "</td>");
	                     buff.append("<td width='15%' class='multiControl' align='center'>" + wb.getString(22) + "</td>");
	                     buff.append("<td width='15%' class='multiControl' align='center'>" + wb.getString(5)+ "</td>");
	                     buff.append("<td width='15%' class='multiControl' align='right'>" + wb.getString(4)+ "</td>");	
	                     buff.append("<td width='15%' class='multiControl' align='right'>" + wb.getString(6)+ "</td>");		                    
	                     buff.append("</tr>");
	                 
	               }

	               buff.append("</table>");
	              
	              /* buff.append("<div>");             

	               buff.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
	               buff.append("<tr>");
	               buff.append("<td bgcolor='black' colspan='6'></td>");
	               buff.append("</tr>");
	               buff.append("<tr>");
	               buff.append("<td class='multiControl' colspan='5' width='88%'><div align='right'><b>TOTAL COST</b></div></td>");
	               buff.append("<td class='multiControl' colspan='1' width='12%'><input type='hidden' name='strFinalCosttt' value='" + itemFinalCost + "'/>" + "<font color='red'><b>Rs." + Math.round(itemFinalCost) + "</b></font></td>");
	               buff.append("</tr>");
	               buff.append("<tr>");
	               buff.append("<td bgcolor='black' colspan='6'></td>");
	               buff.append("</tr>");
	               buff.append("</table>");
	               buff.append("</div>");*/
	            }
	         }
	      } catch (Exception var39) {
	         Exception _err = var39;

	         try {
	            _err.printStackTrace();
	            throw new Exception("LPIssueDeskTransHLP---->getIssueItemDetails" + _err.getMessage());
	         } catch (Exception var38) {
	            var38.printStackTrace();
	         }
	      }

	      return buff.toString();
	   }
}