package mms.transactions.controller.hlp;

import hisglobal.utility.HisUtil;
import java.util.ResourceBundle;
import javax.sql.rowset.WebRowSet;
import mms.qryHandler_mms;
import mms.transactions.controller.fb.IndentTransADDFB;
import mms.transactions.vo.IndentTransADDVO;

public class IndentTransADDHLP {
   public static String getItemDetails1(IndentTransADDVO vo) {
      StringBuffer sb = new StringBuffer("");
      String strHiddenValue = "";
      WebRowSet ws1 = vo.getStrItemDetailsWs();
      String[] tmpqty = null;
      int i = 0;
      boolean var6 = false;

      try {
         sb.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC'  border='0' cellspacing ='1px'>");
         sb.append("<tr><input type='hidden' name='strBSReqNo' value='" + vo.getStrIndentNo() + "'>");
         sb.append("<td width='20%' class='multiLabel'>Item Name</td>");
         sb.append("<td width='20%' class='multiLabel'>Avalaible Qty</td>");
         sb.append("<td width='20%' class='multiLabel'>Req Qty</td>");
         sb.append("<td width='20%' class='multiLabel'>Approved Qty</td>");
         sb.append("<td width='20%' class='multiLabel'>Rate/Unit</td></tr>");
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
            String itemParamValue = null;

            for(String strUnitName = null; ws1.next(); ++i) {
               if (vo.getStrReqType().equals("12") || vo.getStrReqType().equals("13") || vo.getStrReqType().equals("86") || vo.getStrReqType().equals("11")) {
                  strIssueQty = ws1.getString(1);
                  strRetQty = ws1.getString(2);
                  strItemName = ws1.getString(3);
                  strAvlQty = ws1.getString(4);
                  strReqQty = ws1.getString(5);
                  strSancQty = ws1.getString(6);
                  strRate = ws1.getString(7);
                  strHiddenValue = strIssueQty + "^" + strRetQty + "^" + strItemName;
                  itemParamValue = ws1.getString(24);
                  strUnitName = ws1.getString(15);
               }

               if (strItemName == null || strItemName.equals("")) {
                  strItemName = "-----";
               }

               if (strAvlQty == null || strAvlQty.equals("")) {
                  strAvlQty = "-----";
               }

               if (strReqQty == null || strReqQty.equals("")) {
                  strReqQty = "-----";
               }

               if (strSancQty == null || strSancQty.equals("")) {
                  strSancQty = "-----";
               }

               if (strRate == null || strRate.equals("")) {
                  strRate = "-----";
               }

               sb.append("<input type='hidden' name ='strHiddenValue'  value='" + strHiddenValue + "'>");
               sb.append("<tr>");
               sb.append("<td width='20%' class='multiControl'><input type = 'hidden' name='itemParamValue' id='itemParamValue-" + i + "' value='" + itemParamValue + "'>");
               sb.append(strItemName);
               sb.append("</td>");
               sb.append("<td width='20%' class='multiControl'>");
               sb.append(strAvlQty);
               sb.append("</td>");
               sb.append("<td width='20%' class='multiControl'><input type='hidden' name='strReqQty' id='strReqQty" + i + "' value='" + strReqQty + "'> ");
               sb.append(strReqQty);
               sb.append("</td>");
               sb.append("<td width='20%' class='multiControl'><input type='hidden' name='strUnitName' id='strUnitName" + i + "' value='" + strUnitName + "'>");
               sb.append(strSancQty);
               sb.append("</td>");
               sb.append("<td  width='20%' class='multiControl'>");
               sb.append(strRate);
               sb.append("</td>");
               sb.append("</tr>");
            }

            sb.append("</table>");
            vo.setStrReqQty((String[])tmpqty);
         } else {
            sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
            sb.append("<tr>");
            sb.append("<td colspan='5'  CLASS='multiControl' ><DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div></TD>");
            sb.append("</tr>");
            sb.append("</table>");
         }
      } catch (Exception var19) {
         vo.setStrMsgString("IndentTransADDHLP.getItemDetails() --> " + var19.getMessage());
         vo.setStrMsgType("1");
      }

      return sb.toString();
   }

   public static String certificateNA(IndentTransADDFB formBean, IndentTransADDVO vo) throws Exception {
      StringBuffer sb = new StringBuffer("");
      int i = 1;
      ResourceBundle res = null;
      WebRowSet ws = null;
      String strTableWidth = "825";
      String rem = "";

      try {
         res = qryHandler_mms.res;
         if (res == null) {
            res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
            qryHandler_mms.res = res;
         }

         ws = vo.getWsIndentDetails();
         HisUtil hisUtil = new HisUtil("Global", "ReportUtil");
         hisUtil.getHospitalDetail(formBean.getStrHospitalCode());
         sb.append("<table border='0' width='" + strTableWidth + "' align='center'> ");
         sb.append("<tr>  <td colspan='1'></td> <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td> <td colspan='1'></td>");
         sb.append("</tr></table>");
         sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
         sb.append("<tr> ");
         sb.append("<td width='8%'>&nbsp;</td> ");
         sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
         sb.append(" NA - Certificate For Selected Drugs ");
         sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
         sb.append("</tr> ");
         sb.append("</table> ");
         sb.append("<table border='0' width='" + strTableWidth + "' align='center'> ");
         sb.append("<tr> ");
         sb.append("<td align='right'>");
         sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
         sb.append("<img style='cursor: pointer; '  name='PrintPage' tabindex='1' title='Print Page'");
         sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();'/> <img style='cursor: pointer; ' title='Cancel Process'  ");
         sb.append(" src='../../hisglobal/images/stop.png' onClick='hidePopup();' /></div>");
         sb.append(" </td> ");
         sb.append(" </tr> ");
         sb.append(" </table> ");
         sb.append(" <br> ");
         sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
         sb.append("<tr> ");
         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Request No:</b></font></td> ");
         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(vo.getStrIndentNo()).append("</font></td> ");
         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Request Date:</b></font></td> ");
         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(vo.getStrIndentDate()).append("</font></td> ");
         sb.append("</tr> ");
         sb.append("<tr> ");
         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Issuing Store Name:</b></font></td> ");
         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(vo.getStrToStoreName()).append("</font></td> ");
         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Raising Department:</b></font></td> ");
         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(vo.getStrStoreName()).append("</font></td> ");
         sb.append("</tr> ");
         sb.append("<tr> ");
         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Indent Period :</b></font></td> ");
         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(vo.getStrIndentPeriodName()).append("</font></td> ");
         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Requet Type:</b></font></td> ");
         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(vo.getStrIndentTypeName()).append("</font></td> ");
         sb.append("</tr> ");
         sb.append("</table> ");
         sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
         sb.append("<tr>");
         sb.append("<td colspan='3' align='left'><hr size='2'></td>");
         sb.append("<td colspan='2' align='center'><hr size='2'></td>");
         sb.append("</tr>");
         sb.append("<tr bgcolor='#cdc9c9'> ");
         sb.append("<td align='center' width='10%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
         sb.append("</td>");
         sb.append("<td align='center' width='45%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
         sb.append("</td>");
         sb.append("<td align='right' width='15%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Catg</b></font>");
         sb.append("</td> ");
         sb.append("<td align='right' width='15%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Requested Qty</b></font>");
         sb.append("</td> ");
         sb.append("<td align='right' width='15%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font>");
         sb.append("</td> ");
         sb.append("</tr> ");
         sb.append("<tr>");
         sb.append("<td colspan='3' align='left'><hr size='2'></td>");
         sb.append("<td colspan='2' align='center'><hr size='2'></td>");
         sb.append("</tr>");
         if (ws != null && ws.size() > 0) {
            while(true) {
               if (!ws.next()) {
                  sb.append("<tr>");
                  sb.append("<td colspan='3' align='left'><hr size='2'></td>");
                  sb.append("<td colspan='2' align='center'><hr size='2'></td>");
                  sb.append("</tr>");
                  sb.append("<tr>");
                  sb.append("<td colspan='3' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks : </b></font>" + rem + "</td>");
                  sb.append("<td colspan='2' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Raised By : </b></font> " + vo.getStrIndentGenByName() + "</td>");
                  sb.append("</tr>");
                  sb.append("<tr>");
                  sb.append("<td colspan='3' align='left'></td>");
                  sb.append("<td colspan='2' align='center'></td>");
                  sb.append("</tr>");
                  break;
               }

               sb.append("<tr> ");
               sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
               sb.append(i + ".");
               sb.append("</font></td> ");
               sb.append("<td align='left' width='45%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
               sb.append(ws.getString(1));
               sb.append("</font></td> ");
               sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
               sb.append(ws.getString(13));
               sb.append("</font></td> ");
               sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
               sb.append(ws.getString(3));
               sb.append("</font></td> ");
               sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
               sb.append(" NA ");
               sb.append("</font></td> ");
               sb.append("</tr> ");
               ++i;
               rem = ws.getString(12);
            }
         } else {
            sb.append("<tr> ");
            sb.append("<td colspan='5' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
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
      } catch (Exception var12) {
         var12.printStackTrace();
         throw var12;
      } finally {
         if (ws != null) {
            ws.close();
            ws = null;
         }

      }

      return sb.toString();
   }

   public static String getIssueDtlsInitView(IndentTransADDFB formBean, IndentTransADDVO vo) throws Exception {
      StringBuffer sb = new StringBuffer("");
      int i = 1;
      ResourceBundle res = null;
      WebRowSet ws = null;
      String strTableWidth = "825";
      String rem = "";

      try {
         res = qryHandler_mms.res;
         if (res == null) {
            res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
            qryHandler_mms.res = res;
         }

         ws = vo.getWsIndentDetails();
         HisUtil hisUtil = new HisUtil("Global", "ReportUtil");
         hisUtil.getHospitalDetail(formBean.getStrHospitalCode());
         sb.append("<table border='0' width='" + strTableWidth + "' align='center'> ");
         sb.append("<tr>  <td colspan='1'></td> <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td> <td colspan='1'></td>");
         sb.append("</tr></table>");
         sb.append("<table border='0' width='" + strTableWidth + "' align='center'> ");
         sb.append("<tr> ");
         sb.append("<td align='right'>");
         sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
         sb.append("<img style='cursor: pointer; '  name='PrintPage' tabindex='1' title='Print Page'");
         sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();'/> <img style='cursor: pointer; ' title='Cancel Process'  ");
         sb.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopupOne();' /></div>");
         sb.append(" </td> ");
         sb.append(" </tr> ");
         sb.append(" </table> ");
         sb.append(" <br> ");
         sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
         sb.append("<tr> ");
         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Request No:</b></font></td> ");
         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(vo.getStrIndentNo()).append("</font></td> ");
         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Request Date:</b></font></td> ");
         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(vo.getStrIndentDate()).append("</font></td> ");
         sb.append("</tr> ");
         sb.append("<tr> ");
         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Issuing Store Name:</b></font></td> ");
         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(vo.getStrToStoreName()).append("</font></td> ");
         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Raising Department:</b></font></td> ");
         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(vo.getStrStoreName()).append("</font></td> ");
         sb.append("</tr> ");
         sb.append("<tr> ");
         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("Requet Type:</b></font></td> ");
         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' >").append(vo.getStrIndentTypeName()).append("</font></td> ");
         sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("</font></td> ");
         sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td> ");
         sb.append("</tr> ");
         sb.append("</table> ");
         sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");
         sb.append("<tr>");
         sb.append("<td colspan='3' align='left'><hr size='2'></td>");
         sb.append("<td colspan='2' align='center'><hr size='2'></td>");
         sb.append("</tr>");
         sb.append("<tr bgcolor='#cdc9c9'> ");
         sb.append("<td align='center' width='10%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
         sb.append("</td>");
         sb.append("<td align='center' width='45%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
         sb.append("</td>");
         sb.append("<td align='right' width='15%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Avl Qty</b></font>");
         sb.append("</td> ");
         sb.append("<td align='right' width='15%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Requested Qty</b></font>");
         sb.append("</td> ");
         sb.append("</tr> ");
         sb.append("<tr>");
         sb.append("<td colspan='3' align='left'><hr size='2'></td>");
         sb.append("<td colspan='2' align='center'><hr size='2'></td>");
         sb.append("</tr>");
         if (ws != null && ws.size() > 0) {
            while(true) {
               if (!ws.next()) {
                  sb.append("<tr>");
                  sb.append("<td colspan='3' align='left'><hr size='2'></td>");
                  sb.append("<td colspan='2' align='center'><hr size='2'></td>");
                  sb.append("</tr>");
                  sb.append("<tr>");
                  sb.append("<td colspan='3' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks : </b></font>" + rem + "</td>");
                  sb.append("<td colspan='2' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Raised By : </b></font> " + vo.getStrIndentGenByName() + "</td>");
                  sb.append("</tr>");
                  sb.append("<tr>");
                  sb.append("<td colspan='3' align='left'></td>");
                  sb.append("<td colspan='2' align='center'></td>");
                  sb.append("</tr>");
                  break;
               }

               sb.append("<tr> ");
               sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
               sb.append(i + ".");
               sb.append("</font></td> ");
               sb.append("<td align='left' width='45%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");
               sb.append(ws.getString(1));
               sb.append("</font></td> ");
               sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
               sb.append(ws.getString(2));
               sb.append("</font></td> ");
               sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
               sb.append(ws.getString(3));
               sb.append("</font></td> ");
               sb.append("</tr> ");
               ++i;
               rem = ws.getString(12);
            }
         } else {
            sb.append("<tr> ");
            sb.append("<td colspan='5' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
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
      } catch (Exception var12) {
         var12.printStackTrace();
         throw var12;
      } finally {
         if (ws != null) {
            ws.close();
            ws = null;
         }

      }

      return sb.toString();
   }
}