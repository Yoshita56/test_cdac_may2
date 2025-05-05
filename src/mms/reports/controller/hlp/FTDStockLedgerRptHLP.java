package mms.reports.controller.hlp;

import hisglobal.utility.HisUtil;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;
import mms.reports.vo.FTDStockLedgerRptVO;

public class FTDStockLedgerRptHLP 
{
   public String getStockLedgerDtl(FTDStockLedgerRptVO vo, HttpServletRequest request) throws Exception 
   {
      StringBuffer br = new StringBuffer(1000);
      StringBuffer brPagination = new StringBuffer(3000);
      WebRowSet ws = null;
      String prevItemId = "";
      String prevItemName = "";
      String strFromDate = "";
      String strToDate = "";
      String strCheckHidValue = "";
      int REC_PER_PAGE = 0;
      String strCssClass = "multiRPTControl";
      int nFromDay = 0;
      int nToDay = 0;
      int nFromMonth = 0;
      int nToMonth = 0;
      int nFromYear = 0;
      int nToYear = 0;
      int counter = 0;
      int pageCounter = 0;
      int pageSize = 1;
      int sNo = 1;
      long nOpeningBalanceActive = 0L;
      long nClosingBalanceActive = 0L;
      long nIssueActive = 0L;
      long nRecActive = 0L;
      long nOpeningBalanceTotActive = 0L;
      long nClosingBalanceTotActive = 0L;
      long nIssueTotActive = 0L;
      long nRecTotActive = 0L;
      long totIssueRecQty = 0L;

      try {
         ws = vo.getWrsData();
         br.append(this.getHeader(1).toString());
         strFromDate = vo.getStrFromDate();
         strToDate = vo.getStrToDate();
          nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
          nToDay = Integer.parseInt(strToDate.split("\\-")[0]);
         this.getMonthInNumbers(strFromDate.split("\\-")[1]);
         this.getMonthInNumbers(strToDate.split("\\-")[1]);
          nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
          nToYear = Integer.parseInt(strToDate.split("\\-")[2]);
         if (ws != null && ws.size() > 0) {
            while(ws.next()) {
               if (!prevItemId.equals(ws.getString(3)) && counter > 0) {
                  if (sNo % 2 == 0) {
                     strCssClass = "multiRPTControl";
                  } else {
                     strCssClass = "multiRPTControl1";
                  }

                  strCheckHidValue = prevItemId + "^0^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
                  nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
                  if (pageCounter == 100) {
                     ++pageSize;
                     pageCounter = 0;
                  }

                  if (pageSize == 1) {
                     br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
                  } else {
                     br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
                  }

                  br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
                  br.append("<td class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");
                  br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='30%'>" + "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' " + "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceActive + "</td>");
                  totIssueRecQty = nRecActive + nIssueActive;
                  br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
                  br.append("</tr>");
                  nOpeningBalanceTotActive += nOpeningBalanceActive;
                  nClosingBalanceTotActive += nClosingBalanceActive;
                  nIssueTotActive += nIssueActive;
                  nRecTotActive += nRecActive;
                  nOpeningBalanceActive = 0L;
                  nClosingBalanceActive = 0L;
                  nIssueActive = 0L;
                  nRecActive = 0L;
                  ++pageCounter;
                  ++sNo;
               }

               nOpeningBalanceActive += Long.parseLong(ws.getString(7));
               nIssueActive += Long.parseLong(ws.getString(8));
               nRecActive += Long.parseLong(ws.getString(9));
               prevItemId = ws.getString(3);
               prevItemName = ws.getString(5);
               ++counter;
            }

            if (sNo % 2 == 0) {
               strCssClass = "multiRPTControl";
            } else {
               strCssClass = "multiRPTControl1";
            }

            strCheckHidValue = prevItemId + "^0^" + nOpeningBalanceActive + "^0^0";
            nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
            if (pageCounter == 100) {
               ++pageSize;
               pageCounter = 0;
            }

            if (pageSize == 1) {
               br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
            } else {
               br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
            }

            br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
            br.append("<td class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");
            br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='30%'>" + "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' " + "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceActive + "</td>");
            totIssueRecQty = nRecActive + nIssueActive;
            br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
            br.append("</tr>");
            nOpeningBalanceTotActive += nOpeningBalanceActive;
            nClosingBalanceTotActive += nClosingBalanceActive;
            nIssueTotActive += nIssueActive;
            nRecTotActive += nRecActive;
            ++pageCounter;
            if (pageSize == 1) {
               br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
            } else {
               br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
            }

            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='2' width='35%'><b>Grand Total </b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nOpeningBalanceTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nRecTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nIssueTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nClosingBalanceTotActive + "</b></td>");
            br.append("</tr>");
            brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
            brPagination.append("<tr><td colspan='14' class='TITLE' style='color:#000'>Stock Ledger </td></tr>");
            brPagination.append("<tr>");
            brPagination.append("<td class='LABEL' colspan='14'>");

            for(int i = 0; i < pageSize; ++i) {
               if (i == 0) {
                  brPagination.append("<a name='pg' id='pg" + (i + 1) + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-selected' title='Record Indexing'" + " onClick='GetIndex(\"" + (i + 1) + "\",\"" + 100 + "\")'>" + (i + 1) + "</a>|&nbsp;");
               } else {
                  brPagination.append("<a name='pg' id='pg" + (i + 1) + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing'" + " onClick='GetIndex(\"" + (i + 1) + "\",\"" + 100 + "\")'>" + (i + 1) + "</a>|&nbsp;");
               }
            }

            brPagination.append("</td></tr>");
            brPagination.append(br);
            brPagination.append("</table>");
         } else {
            brPagination.append("<table width='95%' align='center' cellspacing='1px' cellpadding='1px'>");
            brPagination.append("<tr><td colspan='14' class='TITLE'>Stock Ledger</td></tr>");
            brPagination.append("<tr><td colspan='14' align='center'><Strong>Data Not Found</Strong></td></tr>");
            brPagination.append("</table>");
         }
      } catch (Exception var45) {
         var45.printStackTrace();
         throw new Exception("FTDStockLedgerRptHLP.getStockLedgerDtl()->" + var45.getMessage());
      } finally {
         if (ws != null) {
            ws.close();
            ws = null;
         }

      }

      return brPagination.toString();
   }

   public StringBuffer getHeader_valuewise(int callType) 
   {
      StringBuffer brHeader = new StringBuffer(1000);
      if (callType == 1) 
      {
         brHeader.append("<tr>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='4%'>S. No.</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='30%'>Item Name</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Rate</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Batch No</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Exp Date</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Opening Balance</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Value</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Received Qty</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Value</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Issued Qty</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Value</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Closing Balance</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Value</td>");
         brHeader.append("</tr>");
      }

      if (callType == 2) {
         brHeader.append("<tr>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>S. No.</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='31%'>Item Name</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Opening Balance</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Value</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Received Qty</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Value</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Issued Qty</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Value</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Closing Balance</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Value</td>");
         brHeader.append("</tr>");
      }

      if (callType == 3) {
         brHeader.append("<tr bgcolor='#cdc9c9'>");
         brHeader.append("<td  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S. No.</b></font></td>");
         brHeader.append("<td  colspan='1' width='31%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font></td>");
         brHeader.append("<td  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Opening Balance</b></font></td>");
         brHeader.append("<td  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Value</b></font></td>");
         brHeader.append("<td  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty</b></font></td>");
         brHeader.append("<td  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Value</b></font></td>");
         brHeader.append("<td  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty</b></font></td>");
         brHeader.append("<td  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Value</b></font></td>");
         brHeader.append("<td  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Closing Balance</b></font></td>");
         brHeader.append("<td  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Value</b></font></td>");
         brHeader.append("</tr>");
      }

      if (callType == 6) {
         brHeader.append("<tr bgcolor='#cdc9c9'>");
         brHeader.append("<td  colspan='1' width='4%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S. No.</b></font></td>");
         brHeader.append("<td  colspan='1' width='30%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font></td>");
         brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate</b></font></td>");
         brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No</b></font></td>");
         brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font></td>");
         brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Opening Balance</b></font></td>");
         brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Value</b></font></td>");
         brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty</b></font></td>");
         brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Value</b></font></td>");
         brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty</b></font></td>");
         brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Value</b></font></td>");
         brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Closing Balance</b></font></td>");
         brHeader.append("<td  colspan='1' width='6%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Value</b></font></td>");
         brHeader.append("</tr>");
      }

      return brHeader;
   }

   public String getStockLedgerDtl_ValueWise(FTDStockLedgerRptVO vo, HttpServletRequest request) throws Exception 
   {
      StringBuffer br = new StringBuffer(1000);
      StringBuffer brPagination = new StringBuffer(3000);
      WebRowSet ws = null;
      String prevItemId = "";
      String prevItemName = "";
      String strFromDate = "";
      String strToDate = "";
      String strCheckHidValue = "";
      int REC_PER_PAGE = 0;
      String strCssClass = "multiRPTControl";
      int nFromDay = 0;
      int nToDay = 0;
      int nFromMonth = 0;
      int nToMonth = 0;
      int nFromYear = 0;
      int nToYear = 0;
      int counter = 0;
      int pageCounter = 0;
      int pageSize = 1;
      int sNo = 1;
      double nRate = 0.0D;
      long nOpeningBalanceActive = 0L;
      double nOpeningBalanceActiveValue = 0.0D;
      long nClosingBalanceActive = 0L;
      double nClosingBalanceActiveValue = 0.0D;
      long nIssueActive = 0L;
      double nIssueActiveValue = 0.0D;
      long nRecActive = 0L;
      double nRecActiveValue = 0.0D;
      long nOpeningBalanceTotActive = 0L;
      double nOpeningBalanceTotActiveValue = 0.0D;
      long nClosingBalanceTotActive = 0L;
      double nClosingBalanceTotActiveValue = 0.0D;
      long nIssueTotActive = 0L;
      double nIssueTotActiveValue = 0.0D;
      long nRecTotActive = 0L;
      double nRecTotActiveValue = 0.0D;
      long totIssueRecQty = 0L;
      double var59 = 0.0D;

      try {
         ws = vo.getWrsData();
         br.append(this.getHeader_valuewise(1).toString());
         strFromDate = vo.getStrFromDate();
         strToDate = vo.getStrToDate();
         nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
          nToDay = Integer.parseInt(strToDate.split("\\-")[0]);
         this.getMonthInNumbers(strFromDate.split("\\-")[1]);
         this.getMonthInNumbers(strToDate.split("\\-")[1]);
          nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
          nToYear = Integer.parseInt(strToDate.split("\\-")[2]);
         new DecimalFormat("0.00");
         if (ws != null && ws.size() > 0) {
            while(ws.next()) {
               nRate = Double.parseDouble(ws.getString(11));
               if (!prevItemId.equals(ws.getString(3)) && counter > 0) {
                  if (sNo % 2 == 0) {
                     strCssClass = "multiRPTControl";
                  } else {
                     strCssClass = "multiRPTControl1";
                  }

                  strCheckHidValue = prevItemId + "^0^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
                  nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
                  if (pageCounter == 100) {
                     ++pageSize;
                     pageCounter = 0;
                  }

                  if (pageSize == 1) {
                     br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
                  } else {
                     br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
                  }

                  br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
                  br.append("<td class= " + strCssClass + " colspan='1' width='4%'>" + sNo + "</td>");
                  br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='30%'>" + "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' " + "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nRate + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nOpeningBalanceActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nOpeningBalanceActiveValue + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nRecActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nRecActiveValue + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nIssueActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nIssueActiveValue + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nClosingBalanceActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nClosingBalanceActiveValue + "</td>");
                  totIssueRecQty = nRecActive + nIssueActive;
                  br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
                  br.append("</tr>");
                  nOpeningBalanceTotActive += nOpeningBalanceActive;
                  nClosingBalanceTotActive += nClosingBalanceActive;
                  nIssueTotActive += nIssueActive;
                  nRecTotActive += nRecActive;
                  nOpeningBalanceTotActiveValue += nOpeningBalanceActiveValue;
                  nClosingBalanceTotActiveValue += nClosingBalanceActiveValue;
                  nIssueTotActiveValue += nIssueActiveValue;
                  nRecTotActiveValue += nRecActiveValue;
                  nOpeningBalanceActive = 0L;
                  nClosingBalanceActive = 0L;
                  nIssueActive = 0L;
                  nRecActive = 0L;
                  nOpeningBalanceActiveValue = 0.0D;
                  nClosingBalanceActiveValue = 0.0D;
                  nIssueActiveValue = 0.0D;
                  nRecActiveValue = 0.0D;
                  ++pageCounter;
                  ++sNo;
               }

               nOpeningBalanceActive += Long.parseLong(ws.getString(7));
               nIssueActive += Long.parseLong(ws.getString(8));
               nRecActive += Long.parseLong(ws.getString(9));
               nOpeningBalanceActiveValue += Double.parseDouble(ws.getString(12));
               nIssueActiveValue += Double.parseDouble(ws.getString(13));
               nRecActiveValue += Double.parseDouble(ws.getString(14));
               prevItemId = ws.getString(3);
               prevItemName = ws.getString(5);
               ++counter;
            }

            if (sNo % 2 == 0) {
               strCssClass = "multiRPTControl";
            } else {
               strCssClass = "multiRPTControl1";
            }

            strCheckHidValue = prevItemId + "^0^" + nOpeningBalanceActive + "^0^0";
            nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
            nClosingBalanceActiveValue = nOpeningBalanceActiveValue + nRecActiveValue - nIssueActiveValue;
            if (pageCounter == 100) {
               ++pageSize;
               pageCounter = 0;
            }

            if (pageSize == 1) {
               br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
            } else {
               br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
            }

            br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
            br.append("<td class= " + strCssClass + " colspan='1' width='4%'>" + sNo + "</td>");
            br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='30%'>" + "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' " + "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nRate + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nOpeningBalanceActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nOpeningBalanceActiveValue + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nRecActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nRecActiveValue + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nIssueActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nIssueActiveValue + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nClosingBalanceActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='6%'>" + nClosingBalanceActiveValue + "</td>");
            totIssueRecQty = nRecActive + nIssueActive;
            br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
            br.append("</tr>");
            nOpeningBalanceTotActive += nOpeningBalanceActive;
            nClosingBalanceTotActive += nClosingBalanceActive;
            nIssueTotActive += nIssueActive;
            nRecTotActive += nRecActive;
            nOpeningBalanceTotActiveValue += nOpeningBalanceActiveValue;
            nClosingBalanceTotActiveValue += nClosingBalanceActiveValue;
            nIssueTotActiveValue += nIssueActiveValue;
            nRecTotActiveValue += nRecActiveValue;
            ++pageCounter;
            if (pageSize == 1) {
               br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
            } else {
               br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
            }

            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='2' ><b>Grand Total </b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + nOpeningBalanceTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + nOpeningBalanceTotActiveValue + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + nRecTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + nRecTotActiveValue + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + nIssueTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + nIssueTotActiveValue + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + nClosingBalanceTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + nClosingBalanceTotActiveValue + "</b></td>");
            br.append("</tr>");
            brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
            brPagination.append("<tr><td colspan='14' class='TITLE' style='color:#000'>Stock Ledger </td></tr>");
            brPagination.append("<tr>");
            brPagination.append("<td class='LABEL' colspan='14'>");

            for(int i = 0; i < pageSize; ++i) {
               if (i == 0) {
                  brPagination.append("<a name='pg' id='pg" + (i + 1) + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-selected' title='Record Indexing'" + " onClick='GetIndex(\"" + (i + 1) + "\",\"" + 100 + "\")'>" + (i + 1) + "</a>|&nbsp;");
               } else {
                  brPagination.append("<a name='pg' id='pg" + (i + 1) + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing'" + " onClick='GetIndex(\"" + (i + 1) + "\",\"" + 100 + "\")'>" + (i + 1) + "</a>|&nbsp;");
               }
            }

            brPagination.append("</td></tr>");
            brPagination.append(br);
            brPagination.append("</table>");
         } else {
            brPagination.append("<table width='95%' align='center' cellspacing='1px' cellpadding='1px'>");
            brPagination.append("<tr><td colspan='14' class='TITLE'>Stock Ledger</td></tr>");
            brPagination.append("<tr><td colspan='14' align='center'><Strong>Data Not Found</Strong></td></tr>");
            brPagination.append("</table>");
         }
      } catch (Exception var66) {
         var66.printStackTrace();
         throw new Exception("FTDStockLedgerRptHLP.getStockLedgerDtl()->" + var66.getMessage());
      } finally {
         if (ws != null) {
            ws.close();
            ws = null;
         }

      }

      return brPagination.toString();
   }

   public String getStockLedgerDtlBatch(FTDStockLedgerRptVO vo, HttpServletRequest request) throws Exception 
   {
      StringBuffer br = new StringBuffer(1000);
      StringBuffer brPagination = new StringBuffer(3000);
      WebRowSet ws = null;
      String prevItemId = "";
      String prevItemName = "";
      String prevBatch = "";
      String prevExpiry = "";
      String strFromDate = "";
      String strToDate = "";
      String strCheckHidValue = "";
      int REC_PER_PAGE = 0;
      String strCssClass = "multiRPTControl";
      int nFromDay = 0;
      int nToDay = 0;
      int nFromMonth = 0;
      int nToMonth = 0;
      int nFromYear = 0;
      int nToYear = 0;
      int counter = 0;
      int pageCounter = 0;
      int pageSize = 1;
      int sNo = 1;
      long nOpeningBalanceActive = 0L;
      long nClosingBalanceActive = 0L;
      long nIssueActive = 0L;
      long nRecActive = 0L;
      long nOpeningBalanceTotActive = 0L;
      long nClosingBalanceTotActive = 0L;
      long nIssueTotActive = 0L;
      long nRecTotActive = 0L;
      long totIssueRecQty = 0L;

      try 
      {
         System.out.println("------------- FTDStockLedgerRptHLP.getStockLedgerDtlBatch() --------------");
         
         ws = vo.getWrsData();
         br.append(this.getHeader(2).toString());
        
            strFromDate = vo.getStrFromDate();
              strToDate = vo.getStrToDate();
               nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
                 nToDay = Integer.parseInt(strToDate.split("\\-")[0]);
              nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
                nToYear = Integer.parseInt(strToDate.split("\\-")[2]);
         
                 this.getMonthInNumbers(strFromDate.split("\\-")[1]);
                 this.getMonthInNumbers(strToDate.split("\\-")[1]);
          
         if (ws != null && ws.size() > 0) 
         {
            while(true) 
            {
               if (!ws.next()) 
               {
                  if (sNo % 2 == 0) 
                  {
                     strCssClass = "multiRPTControl";
                  } 
                  else 
                  {
                     strCssClass = "multiRPTControl1";
                  }
                  
                  /*
                  1. Opeartion Date
                  2. Store Id
                  3. Brand Id
                  4. Store Name
                  5. Item name
                  6. Batch_No
                  7. Opening Balance
                  8. Issue Qty
                  9. Rec Qty
                 10. Expiry date
                 11. Rate
                 12. Opening Balance Value
                 13. Rec Value
                 14. Issue Value
                */
                  
                  strCheckHidValue = prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
                  nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
                  
                  if (pageCounter == 100) 
                  {
                     ++pageSize;
                     pageCounter = 0;
                  }

                  if (pageSize == 1) {
                     br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
                  } else {
                     br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
                  }

                  br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
                  br.append("<td class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");
                  br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='35%'>" + "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' " + "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");
                  br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='8%'>" + prevBatch + "</td>");
                  br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='7%'>" + prevExpiry + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nOpeningBalanceActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nRecActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nIssueActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nClosingBalanceActive + "</td>");
                 
                  totIssueRecQty = nRecActive + nIssueActive;
                  
                  br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
                  br.append("</tr>");
                  
                  //nOpeningBalanceTotActive += nOpeningBalanceActive;
                  nOpeningBalanceTotActive  = nOpeningBalanceActive;
                  nClosingBalanceTotActive += nClosingBalanceActive;
                           nIssueTotActive += nIssueActive;
                             nRecTotActive += nRecActive;
                             
                  ++pageCounter;
                  if (pageSize == 1) 
                  {
                     br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
                  } 
                  else 
                  {
                     br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
                  }

                  br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='4' width='35%'><b>Grand Total</b></td>");
                  br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + nOpeningBalanceTotActive + "</b></td>");
                  br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + nRecTotActive + "</b></td>");
                  br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + nIssueTotActive + "</b></td>");
                  br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + nClosingBalanceTotActive + "</b></td>");
                  br.append("</tr>");
                  brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
                  brPagination.append("<tr><td colspan='16' class='TITLE'> Stock Ledger</td></tr>");
                  brPagination.append("<tr>");
                  brPagination.append("<td class='LABEL' colspan='16'>");

                  for(int i = 0; i < pageSize; ++i) 
                  {
                     if (i == 0) 
                     {
                        brPagination.append("<a name='pg' id='pg" + (i + 1) + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-selected' title='Record Indexing'" + " onClick='GetIndex(\"" + (i + 1) + "\",\"" + 100 + "\")'>" + (i + 1) + "</a>|&nbsp;");
                     }
                     else 
                     {
                        brPagination.append("<a name='pg' id='pg" + (i + 1) + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing'" + " onClick='GetIndex(\"" + (i + 1) + "\",\"" + 100 + "\")'>" + (i + 1) + "</a>|&nbsp;");
                     }
                  }

                  brPagination.append("</td></tr>");
                  brPagination.append(br);
                  brPagination.append("</table>");
                  break;
               }

               if ((!prevItemId.equals(ws.getString(3)) || !prevBatch.equals(ws.getString(6))) && counter > 0) 
               {
                  if (sNo % 2 == 0) 
                  {
                     strCssClass = "multiRPTControl";
                  } 
                  else 
                  {
                     strCssClass = "multiRPTControl1";
                  }

                       strCheckHidValue = prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
                  nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
                  
                  if (pageCounter == 100) 
                  {
                     ++pageSize;
                     pageCounter = 0;
                  }

                  if (pageSize == 1) 
                  {
                     br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
                  } 
                  else 
                  {
                     br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
                  }

                  br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
                  br.append("<td class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");
                  br.append("<td style=\"text-align: left;\"  class= " + strCssClass + " colspan='1' width='35%'>" + "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' " + "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");
                  br.append("<td style=\"text-align: left;\"   class= " + strCssClass + " colspan='1' width='8%'>" + prevBatch + "</td>");
                  br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='7%'>" + prevExpiry + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceActive + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + nRecActive + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + nIssueActive + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceActive + "</td>");
                 
                  totIssueRecQty = nRecActive + nIssueActive;
                 
                  br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
                  br.append("</tr>");
                  
                 // nOpeningBalanceTotActive += nOpeningBalanceActive;
                  nOpeningBalanceTotActive  = nOpeningBalanceActive;
                  nClosingBalanceTotActive += nClosingBalanceActive;
                           nIssueTotActive += nIssueActive;
                             nRecTotActive += nRecActive;
                             
                  nOpeningBalanceActive = 0L;
                  nClosingBalanceActive = 0L;
                  nIssueActive = 0L;
                  nRecActive = 0L;
                  ++pageCounter;
                  ++sNo;
               }

             //  nOpeningBalanceActive += Long.parseLong(ws.getString(7));
               nOpeningBalanceActive  = Long.parseLong(ws.getString(7));
                        nIssueActive += Long.parseLong(ws.getString(8));
                          nRecActive += Long.parseLong(ws.getString(9));
                          
			               prevItemId = ws.getString(3);
			             prevItemName = ws.getString(5);
			                prevBatch = ws.getString(6);
			               prevExpiry = ws.getString(10);
			               
			               /*
			               1. Opeartion Date
			               2. Store Id
			               3. Brand Id
			               4. Store Name
			               5. Item name
			               6. Batch_No
			               7. Opening Balance
			               8. Issue Qty
			               9. Rec Qty
			              10. Expiry date
			              11. Rate
			              12. Opening Balance Value
			              13. Rec Value
			              14. Issue Value
			             */
               ++counter;
            }  // End While Loop
         } 
         else 
         {
            brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
            brPagination.append("<tr><td class='TITLE'> Stock Ledger</td></tr>");
            brPagination.append("<tr><td align='center'><Strong>Data Not Found</Strong></td></tr>");
            brPagination.append("</table>");
         }
      } catch (Exception var47) {
         var47.printStackTrace();
         throw new Exception("FTDStockLedgerRptHLP.getStockLedgerDtl()->" + var47.getMessage());
      } finally {
         if (ws != null) {
            ws.close();
            ws = null;
         }

      }

      return brPagination.toString();
   }

   public String getStockLedgerDtl_ValueRpt(FTDStockLedgerRptVO vo, HttpServletRequest request) throws Exception {
      StringBuffer br = new StringBuffer(1000);
      StringBuffer brPagination = new StringBuffer(3000);
      WebRowSet ws = null;
      String prevItemId = "";
      String prevItemName = "";
      String prevRate = "";
      String strFromDate = "";
      String strToDate = "";
      String strCheckHidValue = "";
      int REC_PER_PAGE = 0;
      String strCssClass = "multiRPTControl";
      int nFromDay = 0;
      int nToDay = 0;
      int nFromMonth = 0;
      int nToMonth = 0;
      int nFromYear = 0;
      int nToYear = 0;
      int counter = 0;
      int pageCounter = 0;
      int pageSize = 1;
      int sNo = 1;
      double nOpeningBalanceActive = 0.0D;
      double nOpeningBalanceActiveValue = 0.0D;
      double nClosingBalanceActive = 0.0D;
      double nClosingBalanceActiveValue = 0.0D;
      double nIssueActive = 0.0D;
      double nIssueActiveValue = 0.0D;
      double nRecActive = 0.0D;
      double nRecActiveValue = 0.0D;
      double nOpeningBalanceTotActive = 0.0D;
      double nOpeningBalanceTotActiveValue = 0.0D;
      double nClosingBalanceTotActive = 0.0D;
      double nClosingBalanceTotActiveValue = 0.0D;
      double nIssueTotActive = 0.0D;
      double nIssueTotActiveValue = 0.0D;
      double nRecTotActive = 0.0D;
      double nRecTotActiveValue = 0.0D;
      double totIssueRecQty = 0.0D;
      NumberFormat formatter = new DecimalFormat("###############.##");
      String issueValue = "0.00";
      String recValue = "0.00";
      HisUtil hisutil = new HisUtil("billing", "PrintHLP");

      try 
      {
         ws = vo.getWrsData();
         br.append(this.getHeader_valuewise(2).toString());
         
	           strFromDate = vo.getStrFromDate();
	             strToDate = vo.getStrToDate();
	              nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
	                nToDay = Integer.parseInt(strToDate.split("\\-")[0]);	        
	             nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
	               nToYear = Integer.parseInt(strToDate.split("\\-")[2]);
	          
	          this.getMonthInNumbers(strFromDate.split("\\-")[1]);
	          this.getMonthInNumbers(strToDate.split("\\-")[1]);
         if (ws != null && ws.size() > 0) {
            while(ws.next()) {
               if (!prevItemId.equals(ws.getString(3)) && counter > 0) {
                  if (sNo % 2 == 0) {
                     strCssClass = "multiRPTControl";
                  } else {
                     strCssClass = "multiRPTControl1";
                  }

                  strCheckHidValue = prevItemId + "^0^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
                  nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
                  if (pageCounter == 100) {
                     ++pageSize;
                     pageCounter = 0;
                  }

                  if (pageSize == 1) {
                     br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
                  } else {
                     br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
                  }

                  br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
                  br.append("<td class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");
                  br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='31%'>" + "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' " + "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nOpeningBalanceActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nOpeningBalanceActiveValue) + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nRecActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nRecActiveValue) + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nIssueActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nIssueActiveValue) + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nClosingBalanceActive + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nClosingBalanceActive * Double.parseDouble(prevRate)) + "</td>");
                  totIssueRecQty = nRecActive + nIssueActive;
                  br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
                  br.append("</tr>");
                  
                  nOpeningBalanceTotActive 		+= nOpeningBalanceActive;
                  nClosingBalanceTotActive 		+= nClosingBalanceActive;
                  nIssueTotActive 		   		+= nIssueActive;
                  nRecTotActive 		   		+= nRecActive;
                  nOpeningBalanceTotActiveValue += nOpeningBalanceActiveValue;
                  nClosingBalanceTotActiveValue += nClosingBalanceActiveValue;
                  nIssueTotActiveValue 			+= nIssueActiveValue;
                  nRecTotActiveValue 			+= nRecActiveValue;
                  
                  
                  nOpeningBalanceActive 		= 0.0D;
                  nClosingBalanceActive 		= 0.0D;
                  nIssueActive 					= 0.0D;
                  nRecActive 					= 0.0D;
                  nOpeningBalanceActiveValue 	= 0.0D;
                  nClosingBalanceActiveValue 	= 0.0D;
                  nIssueActiveValue 			= 0.0D;
                  nRecActiveValue 				= 0.0D;
                  
                  ++pageCounter;
                  ++sNo;
               }

               nOpeningBalanceActive 		+= (double)Long.parseLong(ws.getString(7));
               nIssueActive 				+= (double)Long.parseLong(ws.getString(8));
               nRecActive 					+= (double)Long.parseLong(ws.getString(9));
               nOpeningBalanceActiveValue 	+= Double.parseDouble(ws.getString(12));
               
               issueValue 					= formatter.format(new BigDecimal(ws.getString(13)));
               recValue 					= formatter.format(new BigDecimal(ws.getString(14)));
               
               nIssueActiveValue 		   += Double.parseDouble(issueValue);
               nRecActiveValue 			   += Double.parseDouble(recValue);
               
               prevItemId 					= ws.getString(3);
               prevItemName 				= ws.getString(5);
               prevRate 					= ws.getString(11);
               String drugName 				= ws.getString(5);
               int strlength 				= ws.getString(5).length();
               String opdrugName = "";
               if (strlength > 30) {
                  opdrugName = hisutil.appendSpace(drugName.substring(0, 30), 45, 0) + hisutil.appendSpace("", 15, 0) + hisutil.appendSpace("", 10, 0) + hisutil.appendSpace("", 8, 0) + hisutil.appendSpace("", 10, 0) + " \n " + hisutil.appendSpace(drugName.substring(31, strlength), 46, 0);
               } else if (strlength > 100) {
                  opdrugName = hisutil.appendSpace(drugName.substring(0, 30), 46, 0) + hisutil.appendSpace("", 15, 0) + hisutil.appendSpace("", 10, 0) + hisutil.appendSpace("", 8, 0) + hisutil.appendSpace("", 10, 0) + " \n " + hisutil.appendSpace("", 5, 0) + hisutil.appendSpace(drugName.substring(31, 60), 46, 0) + hisutil.appendSpace("", 15, 0) + hisutil.appendSpace("", 10, 0) + hisutil.appendSpace("", 8, 0) + hisutil.appendSpace("", 10, 0) + " \n " + hisutil.appendSpace(drugName.substring(60, strlength), 46, 0);
               } else {
                  opdrugName = hisutil.appendSpace(drugName.substring(0, strlength), 46, 0);
               }

               prevItemName = opdrugName;
               ++counter;
            }

            if (sNo % 2 == 0) {
               strCssClass = "multiRPTControl";
            } else {
               strCssClass = "multiRPTControl1";
            }

            strCheckHidValue = prevItemId + "^0^" + nOpeningBalanceActive + "^0^0";
            nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
            nClosingBalanceActiveValue = nOpeningBalanceActiveValue + nRecActiveValue - nIssueActiveValue;
            if (pageCounter == 100) {
               ++pageSize;
               pageCounter = 0;
            }

            if (pageSize == 1) {
               br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
            } else {
               br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
            }

            br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
            br.append("<td class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");
            br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='31%'>" + "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' " + "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nOpeningBalanceActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nOpeningBalanceActiveValue) + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nRecActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nRecActiveValue) + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nIssueActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nIssueActiveValue) + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nClosingBalanceActive + "</td>");
            br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nClosingBalanceActive * Double.parseDouble(prevRate)) + "</td>");
            totIssueRecQty = nRecActive + nIssueActive;
            br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
            br.append("</tr>");
            
            nOpeningBalanceTotActive += nOpeningBalanceActive;
            nClosingBalanceTotActive += nClosingBalanceActive;
            nIssueTotActive 		 += nIssueActive;
            nRecTotActive 	         += nRecActive;
            double var10000 = nOpeningBalanceTotActiveValue + nOpeningBalanceActiveValue;
            var10000 = nClosingBalanceTotActiveValue + nClosingBalanceActiveValue;
            var10000 = nIssueTotActiveValue + nIssueActiveValue;
            var10000 = nRecTotActiveValue + nRecActiveValue;
            ++pageCounter;
            if (pageSize == 1) {
               br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
            } else {
               br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
            }

            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='2' width='31%'><b>Grand Total </b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='8%'><b>" + (int)nOpeningBalanceTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='8%'><b></b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='8%'><b>" + (int)nRecTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='8%'><b></b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='8%'><b>" + (int)nIssueTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='8%'><b></b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='8%'><b>" + (int)nClosingBalanceTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='8%'><b></b></td>");
            br.append("</tr>");
            brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
            brPagination.append("<tr><td colspan='10' class='TITLE' style='color:#000'>Stock Ledger </td></tr>");
            brPagination.append("<tr>");
            brPagination.append("<td class='LABEL' colspan='10'>");

            for(int i = 0; i < pageSize; ++i) {
               if (i == 0) {
                  brPagination.append("<a name='pg' id='pg" + (i + 1) + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-selected' title='Record Indexing'" + " onClick='GetIndex(\"" + (i + 1) + "\",\"" + 100 + "\")'>" + (i + 1) + "</a>|&nbsp;");
               } else {
                  brPagination.append("<a name='pg' id='pg" + (i + 1) + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing'" + " onClick='GetIndex(\"" + (i + 1) + "\",\"" + 100 + "\")'>" + (i + 1) + "</a>|&nbsp;");
               }
            }

            brPagination.append("</td></tr>");
            brPagination.append(br);
            brPagination.append("</table>");
         } else {
            brPagination.append("<table width='95%' align='center' cellspacing='1px' cellpadding='1px'>");
            brPagination.append("<tr><td colspan='10' class='TITLE'>Stock Ledger</td></tr>");
            brPagination.append("<tr><td colspan='10' align='center'><Strong>Data Not Found</Strong></td></tr>");
            brPagination.append("</table>");
         }
      } catch (Exception var68) {
         var68.printStackTrace();
         throw new Exception("FTDStockLedgerRptHLP.getStockLedgerDtl_ValueRpt()->" + var68.getMessage());
      } finally {
         if (ws != null) {
            ws.close();
            ws = null;
         }

      }

      return brPagination.toString();
   }

   public String getConsolidatedStockLedgerRpt_ValuePopUp(FTDStockLedgerRptVO vo, HttpServletRequest request) throws Exception {
      StringBuffer br = new StringBuffer(1000);
      StringBuffer brPagination = new StringBuffer(3000);
      WebRowSet ws = null;
      String strTableWidth = "100%";
      String prevItemId = "";
      String prevItemName = "";
      String prevRate = "";
      String strFromDate = "";
      String strToDate = "";
      String strCheckHidValue = "";
      String strCssClass = "";
      String strStoreName = "";
      int nFromDay = 0;
      int nToDay = 0;
      int nFromMonth = 0;
      int nToMonth = 0;
      int nFromYear = 0;
      int nToYear = 0;
      int counter = 0;
      int pageCounter = 0;
      int pageSize = 0;
      int sNo = 1;
      double nOpeningBalanceActive = 0.0D;
      double nOpeningBalanceActiveValue = 0.0D;
      double nClosingBalanceActive = 0.0D;
      double nClosingBalanceActiveValue = 0.0D;
      double nIssueActive = 0.0D;
      double nIssueActiveValue = 0.0D;
      double nRecActive = 0.0D;
      double nRecActiveValue = 0.0D;
      double nOpeningBalanceTotActive = 0.0D;
      double nOpeningBalanceTotActiveValue = 0.0D;
      double nClosingBalanceTotActive = 0.0D;
      double nClosingBalanceTotActiveValue = 0.0D;
      double nIssueTotActive = 0.0D;
      double nIssueTotActiveValue = 0.0D;
      double nRecTotActive = 0.0D;
      double nRecTotActiveValue = 0.0D;
      double totIssueRecQty = 0.0D;
      NumberFormat formatter = new DecimalFormat("###############.##");
      String issueValue = "0.00";
      String recValue = "0.00";
      HisUtil hisutil = new HisUtil("billing", "PrintHLP");

      try {
         System.out.println("----------- FTDStockLedgerRptHLP.getConsolidatedStockLedgerRpt_ValuePopUp -----------");
         ws = vo.getWrsData();
         br.append(this.getHeader_valuewise(3).toString());
         strFromDate = vo.getStrFromDate();
         strToDate = vo.getStrToDate();
          nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
          nToDay = Integer.parseInt(strToDate.split("\\-")[0]);
         this.getMonthInNumbers(strFromDate.split("\\-")[1]);
         this.getMonthInNumbers(strToDate.split("\\-")[1]);
          nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
          nToYear = Integer.parseInt(strToDate.split("\\-")[2]);
         if (ws != null && ws.size() > 0) {
            if (ws.next()) {
               strStoreName = ws.getString(4);
            }

            ws.beforeFirst();

            while(ws.next()) {
               if (!prevItemId.equals(ws.getString(3)) && counter > 0) {
                  if (sNo % 2 == 0) {
                     strCssClass = "";
                  } else {
                     strCssClass = "";
                  }

                  strCheckHidValue = prevItemId + "^0^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
                  nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
                  br.append("<tr id='tr'>");
                  br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
                  br.append("<td class= " + strCssClass + " colspan='1' style='text-align:center;' width='5%'>" + sNo + "</td>");
                  br.append("<td style=\"text-align: left;\"  class= " + strCssClass + "  colspan='1' width='31%'>" + prevItemName + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nOpeningBalanceActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nOpeningBalanceActiveValue) + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nRecActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nRecActiveValue) + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nIssueActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nIssueActiveValue) + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nClosingBalanceActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nClosingBalanceActive * Double.parseDouble(prevRate)) + "</td>");
                  totIssueRecQty = nRecActive + nIssueActive;
                  br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
                  br.append("</tr>");
                  nOpeningBalanceTotActive += nOpeningBalanceActive;
                  nClosingBalanceTotActive += nClosingBalanceActive;
                  nIssueTotActive += nIssueActive;
                  nRecTotActive += nRecActive;
                  nOpeningBalanceTotActiveValue += nOpeningBalanceActiveValue;
                  nClosingBalanceTotActiveValue += nClosingBalanceActiveValue;
                  nIssueTotActiveValue += nIssueActiveValue;
                  nRecTotActiveValue += nRecActiveValue;
                  nOpeningBalanceActive = 0.0D;
                  nClosingBalanceActive = 0.0D;
                  nIssueActive = 0.0D;
                  nRecActive = 0.0D;
                  nOpeningBalanceActiveValue = 0.0D;
                  nClosingBalanceActiveValue = 0.0D;
                  nIssueActiveValue = 0.0D;
                  nRecActiveValue = 0.0D;
                  ++pageCounter;
                  ++sNo;
               }

               nOpeningBalanceActive += (double)Long.parseLong(ws.getString(7));
               nIssueActive += (double)Long.parseLong(ws.getString(8));
               nRecActive += (double)Long.parseLong(ws.getString(9));
               nOpeningBalanceActiveValue += Double.parseDouble(ws.getString(12));
               issueValue = formatter.format(new BigDecimal(ws.getString(13)));
               recValue = formatter.format(new BigDecimal(ws.getString(14)));
               nIssueActiveValue += Double.parseDouble(issueValue);
               nRecActiveValue += Double.parseDouble(recValue);
               prevItemId = ws.getString(3);
               prevItemName = ws.getString(5);
               prevRate = ws.getString(11);
               String drugName = ws.getString(5);
               int strlength = ws.getString(5).length();
               String opdrugName = "";
               if (strlength > 30) {
                  opdrugName = hisutil.appendSpace(drugName.substring(0, 30), 45, 0) + hisutil.appendSpace("", 15, 0) + hisutil.appendSpace("", 10, 0) + hisutil.appendSpace("", 8, 0) + hisutil.appendSpace("", 10, 0) + " \n " + hisutil.appendSpace(drugName.substring(31, strlength), 46, 0);
               } else if (strlength > 100) {
                  opdrugName = hisutil.appendSpace(drugName.substring(0, 30), 46, 0) + hisutil.appendSpace("", 15, 0) + hisutil.appendSpace("", 10, 0) + hisutil.appendSpace("", 8, 0) + hisutil.appendSpace("", 10, 0) + " \n " + hisutil.appendSpace("", 5, 0) + hisutil.appendSpace(drugName.substring(31, 60), 46, 0) + hisutil.appendSpace("", 15, 0) + hisutil.appendSpace("", 10, 0) + hisutil.appendSpace("", 8, 0) + hisutil.appendSpace("", 10, 0) + " \n " + hisutil.appendSpace(drugName.substring(60, strlength), 46, 0);
               } else {
                  opdrugName = hisutil.appendSpace(drugName.substring(0, strlength), 46, 0);
               }

               prevItemName = opdrugName;
               ++counter;
            }

            if (sNo % 2 == 0) {
               strCssClass = "";
            } else {
               strCssClass = "";
            }

            strCheckHidValue = prevItemId + "^0^" + nOpeningBalanceActive + "^0^0";
            nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
            nClosingBalanceActiveValue = nOpeningBalanceActiveValue + nRecActiveValue - nIssueActiveValue;
            br.append("<tr id='tr'>");
            br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
            br.append("<td class= " + strCssClass + " colspan='1' style='text-align: right;' width='5%'>" + sNo + "</td>");
            br.append("<td style=\"text-align: left;\"  class= " + strCssClass + "  colspan='1' width='30%'>" + prevItemName + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nOpeningBalanceActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nOpeningBalanceActiveValue) + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nRecActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nRecActiveValue) + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nIssueActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nIssueActiveValue) + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + (int)nClosingBalanceActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + String.format("%1$,.2f", nClosingBalanceActive * Double.parseDouble(prevRate)) + "</td>");
            totIssueRecQty = nRecActive + nIssueActive;
            br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
            br.append("</tr>");
            nOpeningBalanceTotActive += nOpeningBalanceActive;
            nClosingBalanceTotActive += nClosingBalanceActive;
            nIssueTotActive += nIssueActive;
            nRecTotActive += nRecActive;
            nOpeningBalanceTotActiveValue += nOpeningBalanceActiveValue;
            double var10000 = nClosingBalanceTotActiveValue + nClosingBalanceActiveValue;
            nIssueTotActiveValue += nIssueActiveValue;
            nRecTotActiveValue += nRecActiveValue;
            br.append("<tr bgcolor='' id='tr'>");
            br.append("<td style='text-align: right;padding: 1%;' class='' colspan='2' ><b>Grand Total</b></td>");
            br.append("<td style=\"text-align: right;\" class='' colspan='1' ><b>" + (int)nOpeningBalanceTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + String.format("%1$,.2f", nOpeningBalanceTotActiveValue) + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='' colspan='1' ><b>" + (int)nRecTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + String.format("%1$,.2f", nRecTotActiveValue) + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='' colspan='1' ><b>" + (int)nIssueTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + String.format("%1$,.2f", nIssueTotActiveValue) + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='' colspan='1' ><b>" + (int)nClosingBalanceTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='' colspan='1' ><b></b></td>");
            br.append("</tr>");
            brPagination.append("<HTML><HEAD><script language='Javascript' src='../../mms/js/stockledgerFTD_mmsrpt.js'></script><script language='JavaScript' src='../../hisglobal/jquery/3.6.0.min.js'></script><script language='Javascript' src='../../hisglobal/js/innerxhtml.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.16.9/xlsx.full.min.js'></script><body><form action='/INVMGM/mms/reports/FTDStockLedgerRptCNT.cnt' method='post'><div id='consolidatedBatchWiseStockLedgerRptDivId'>");
            brPagination.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
            brPagination.append("<tr> ");
            brPagination.append("<td align='right'>");
            brPagination.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'> <div id='printImg'>");
            brPagination.append("<img style='cursor: pointer; ' title='Print Page'  ");
            brPagination.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printThis();' /> <img style='cursor: pointer; ' title='Save as Excel' src='../../hisglobal/images/excel1.png' onClick='generateXLS(event,\"consolidatedBatchWiseStockLedgerRptDivId\");' /><img style='cursor: pointer; ' title='Cancel Process'  ");
            brPagination.append(" src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div>");
            brPagination.append(" </td> ");
            brPagination.append(" </tr> ");
            brPagination.append(" </table> ");
            brPagination.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' id='table' cellpadding='0'> ");
            brPagination.append("<tr><td width='10%' colspan='1'  align='right'><div  align='right'></div></td> ");
            brPagination.append("<td width='80%'     colspan='9' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
            brPagination.append("Stock Ledger");
            brPagination.append("</font></b></td><td colspan='1' width='10%'></td> ");
            brPagination.append("</tr> ");
            brPagination.append("<tr> ");
            brPagination.append("<td width='10%' colspan='1'></td> ");
            brPagination.append("<td width='80%' colspan='9' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
            brPagination.append("Store Name : " + strStoreName + "<br>");
            brPagination.append("</font></b></td><td width='10%' colspan='1'> ");
            brPagination.append("</td> ");
            brPagination.append("</tr> ");
            brPagination.append("<tr> ");
            brPagination.append("<td width='10%' colspan='1' ></td> ");
            brPagination.append("<td width='80%' colspan='9' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
            brPagination.append("Between : " + vo.getStrFromDate() + " And  " + vo.getStrToDate());
            brPagination.append("</font></b></td><td width='10%' colspan='1' > ");
            brPagination.append("</td> ");
            brPagination.append("</tr> ");
            brPagination.append("</table> ");
            brPagination.append("<table align='center' width='").append(strTableWidth).append("' border='1' cellspacing='0' id='table1' cellpadding='0''> ");
            brPagination.append(br);
            brPagination.append("</table></div></HEAD></HTML>");
         } else {
            brPagination.append("<table width='95%' align='center' cellspacing='1px' cellpadding='1px'>");
            brPagination.append("<tr><td colspan='10' class='TITLE'>Stock Ledger</td></tr>");
            brPagination.append("<tr><td colspan='10' align='center'><Strong>No Data Found</Strong></td></tr>");
            brPagination.append("</table>");
         }
      } catch (Exception var69) {
         var69.printStackTrace();
         throw new Exception("FTDStockLedgerRptHLP.getStockLedgerDtl()->" + var69.getMessage());
      } finally {
         if (ws != null) {
            ws.close();
            ws = null;
         }

      }

      return brPagination.toString();
   }

   public String getStockLedgerDtlBatch_ValueWiseRpt(FTDStockLedgerRptVO vo, HttpServletRequest request) throws Exception {
      StringBuffer br = new StringBuffer(1000);
      StringBuffer brPagination = new StringBuffer(3000);
      WebRowSet ws = null;
      String prevItemId = "";
      String prevItemName = "";
      String prevBatch = "";
      String prevExpiry = "";
      String prevRate = "";
      String strFromDate = "";
      String strToDate = "";
      String strCheckHidValue = "";
      int REC_PER_PAGE = 0;
      String strCssClass = "multiRPTControl";
      int nFromDay = 0;
      int nToDay = 0;
      int nFromMonth = 0;
      int nToMonth = 0;
      int nFromYear = 0;
      int nToYear = 0;
      int counter = 0;
      int pageCounter = 0;
      int pageSize = 1;
      int sNo = 1;
      double nOpeningBalanceActive = 0.0D;
      double nOpeningBalanceActiveValue = 0.0D;
      double nClosingBalanceActive = 0.0D;
      double nClosingBalanceActiveValue = 0.0D;
      double nIssueActive = 0.0D;
      double nIssueActiveValue = 0.0D;
      double nRecActive = 0.0D;
      double nRecActiveValue = 0.0D;
      double nOpeningBalanceTotActive = 0.0D;
      double nOpeningBalanceTotActiveValue = 0.0D;
      double nClosingBalanceTotActive = 0.0D;
      double nClosingBalanceTotActiveValue = 0.0D;
      double nIssueTotActive = 0.0D;
      double nIssueTotActiveValue = 0.0D;
      double nRecTotActive = 0.0D;
      double nRecTotActiveValue = 0.0D;
      double totIssueRecQty = 0.0D;
      NumberFormat formatter = new DecimalFormat("###############.##");
      String issueValue = "0.00";
      String recValue = "0.00";
      HisUtil hisutil = new HisUtil("billing", "PrintHLP");

      try {
         System.out.println("------------- StockLedgerForSubStoresRptItemNew.getStockLedgerDtlBatch_ValueWiseRpt() --------------");
         ws = vo.getWrsData();
         br.append(this.getHeader_valuewise(1).toString());
         strFromDate = vo.getStrFromDate();
         strToDate = vo.getStrToDate();
          nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
          nToDay = Integer.parseInt(strToDate.split("\\-")[0]);
         this.getMonthInNumbers(strFromDate.split("\\-")[1]);
         this.getMonthInNumbers(strToDate.split("\\-")[1]);
          nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
          nToYear = Integer.parseInt(strToDate.split("\\-")[2]);
         if (ws != null && ws.size() > 0) {
            while(true) {
               if (!ws.next()) {
                  if (sNo % 2 == 0) {
                     strCssClass = "multiRPTControl";
                  } else {
                     strCssClass = "multiRPTControl1";
                  }

                  strCheckHidValue = prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
                  nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
                  nClosingBalanceActiveValue = nOpeningBalanceActiveValue + nRecActiveValue - nIssueActiveValue;
                  if (pageCounter == 100) {
                     ++pageSize;
                     pageCounter = 0;
                  }

                  if (pageSize == 1) {
                     br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
                  } else {
                     br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
                  }

                  br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
                  br.append("<td class= " + strCssClass + " colspan='1' width='4%'>" + sNo + "</td>");
                  br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='30%'>" + "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' " + "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");
                  br.append("<td style=\"text-align: left;\"   class= " + strCssClass + " colspan='1' width='6%'>" + prevRate + "</td>");
                  br.append("<td style=\"text-align: left;\"   class= " + strCssClass + " colspan='1' width='6%'>" + prevBatch + "</td>");
                  br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='6%'>" + prevExpiry + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + (int)nOpeningBalanceActive + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + String.format("%1$,.2f", nOpeningBalanceActiveValue) + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + (int)nRecActive + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + String.format("%1$,.2f", nRecActiveValue) + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + (int)nIssueActive + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + String.format("%1$,.2f", nIssueActiveValue) + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + (int)nClosingBalanceActive + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + String.format("%1$,.2f", nClosingBalanceActive * Double.parseDouble(prevRate)) + "</td>");
                  totIssueRecQty = nRecActive + nIssueActive;
                  br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
                  br.append("</tr>");
                  nOpeningBalanceTotActive += nOpeningBalanceActive;
                  nClosingBalanceTotActive += nClosingBalanceActive;
                  nIssueTotActive += nIssueActive;
                  nRecTotActive += nRecActive;
                  double var10000 = nOpeningBalanceTotActiveValue + nOpeningBalanceActiveValue;
                  var10000 = nClosingBalanceTotActiveValue + nClosingBalanceActiveValue;
                  var10000 = nIssueTotActiveValue + nIssueActiveValue;
                  var10000 = nRecTotActiveValue + nRecActiveValue;
                  ++pageCounter;
                  if (pageSize == 1) {
                     br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
                  } else {
                     br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
                  }

                  br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='5' ><b>Grand Total</b></td>");
                  br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + (int)nOpeningBalanceTotActive + "</b></td>");
                  br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b></b></td>");
                  br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + (int)nRecTotActive + "</b></td>");
                  br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b></b></td>");
                  br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + (int)nIssueTotActive + "</b></td>");
                  br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b></b></td>");
                  br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b>" + (int)nClosingBalanceTotActive + "</b></td>");
                  br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' ><b></b></td>");
                  br.append("</tr>");
                  brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
                  brPagination.append("<tr><td colspan='13' class='TITLE'> Stock Ledger</td></tr>");
                  brPagination.append("<tr>");
                  brPagination.append("<td class='LABEL' colspan='13'>");

                  for(int i = 0; i < pageSize; ++i) {
                     if (i == 0) {
                        brPagination.append("<a name='pg' id='pg" + (i + 1) + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-selected' title='Record Indexing'" + " onClick='GetIndex(\"" + (i + 1) + "\",\"" + 100 + "\")'>" + (i + 1) + "</a>|&nbsp;");
                     } else {
                        brPagination.append("<a name='pg' id='pg" + (i + 1) + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing'" + " onClick='GetIndex(\"" + (i + 1) + "\",\"" + 100 + "\")'>" + (i + 1) + "</a>|&nbsp;");
                     }
                  }

                  brPagination.append("</td></tr>");
                  brPagination.append(br);
                  brPagination.append("</table>");
                  break;
               }

               if ((!prevItemId.equals(ws.getString(3)) || !prevBatch.equals(ws.getString(6))) && counter > 0) {
                  if (sNo % 2 == 0) {
                     strCssClass = "multiRPTControl";
                  } else {
                     strCssClass = "multiRPTControl1";
                  }

                  strCheckHidValue = prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
                  nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
                  if (pageCounter == 100) {
                     ++pageSize;
                     pageCounter = 0;
                  }

                  if (pageSize == 1) {
                     br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
                  } else {
                     br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
                  }

                  br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
                  br.append("<td class= " + strCssClass + " colspan='1' width='4%'>" + sNo + "</td>");
                  br.append("<td style=\"text-align: left;\"  class= " + strCssClass + " colspan='1' width='30%'>" + "<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid" + sNo + "' value='0' " + "onClick='chkBoxClick(this,\"" + sNo + "\");'>" + prevItemName + "</a></td>");
                  br.append("<td style=\"text-align: left;\"   class= " + strCssClass + " colspan='1' width='6%'>" + prevRate + "</td>");
                  br.append("<td style=\"text-align: left;\"   class= " + strCssClass + " colspan='1' width='6%'>" + prevBatch + "</td>");
                  br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='6%'>" + prevExpiry + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + (int)nOpeningBalanceActive + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + String.format("%1$,.2f", nOpeningBalanceActiveValue) + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + (int)nRecActive + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + String.format("%1$,.2f", nRecActiveValue) + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + (int)nIssueActive + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + String.format("%1$,.2f", nIssueActiveValue) + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + (int)nClosingBalanceActive + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='6%'>" + String.format("%1$,.2f", nClosingBalanceActive * Double.parseDouble(prevRate)) + "</td>");
                  totIssueRecQty = nRecActive + nIssueActive;
                  br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
                  br.append("</tr>");
                  nOpeningBalanceTotActive += nOpeningBalanceActive;
                  nClosingBalanceTotActive += nClosingBalanceActive;
                  nIssueTotActive += nIssueActive;
                  nRecTotActive += nRecActive;
                  nOpeningBalanceTotActiveValue += nOpeningBalanceActiveValue;
                  nClosingBalanceTotActiveValue += nClosingBalanceActiveValue;
                  nIssueTotActiveValue += nIssueActiveValue;
                  nRecTotActiveValue += nRecActiveValue;
                  nOpeningBalanceActive = 0.0D;
                  nClosingBalanceActive = 0.0D;
                  nIssueActive = 0.0D;
                  nRecActive = 0.0D;
                  nOpeningBalanceActiveValue = 0.0D;
                  nClosingBalanceActiveValue = 0.0D;
                  nIssueActiveValue = 0.0D;
                  nRecActiveValue = 0.0D;
                  ++pageCounter;
                  ++sNo;
               }

               nOpeningBalanceActive += (double)Long.parseLong(ws.getString(7));
               nIssueActive += (double)Long.parseLong(ws.getString(8));
               nRecActive += (double)Long.parseLong(ws.getString(9));
               nOpeningBalanceActiveValue += Double.parseDouble(ws.getString(12));
               issueValue = formatter.format(new BigDecimal(ws.getString(14)));
               recValue = formatter.format(new BigDecimal(ws.getString(13)));
               nIssueActiveValue += Double.parseDouble(issueValue);
               nRecActiveValue += Double.parseDouble(recValue);
               prevItemId = ws.getString(3);
               prevItemName = ws.getString(5);
               prevBatch = ws.getString(6);
               prevExpiry = ws.getString(10);
               prevRate = ws.getString(11);
               String drugName = ws.getString(5);
               int strlength = ws.getString(5).length();
               String opdrugName = "";
               if (strlength > 30) {
                  opdrugName = hisutil.appendSpace(drugName.substring(0, 30), 45, 0) + hisutil.appendSpace("", 15, 0) + hisutil.appendSpace("", 10, 0) + hisutil.appendSpace("", 8, 0) + hisutil.appendSpace("", 10, 0) + " \n " + hisutil.appendSpace(drugName.substring(31, strlength), 46, 0);
               } else if (strlength > 100) {
                  opdrugName = hisutil.appendSpace(drugName.substring(0, 30), 46, 0) + hisutil.appendSpace("", 15, 0) + hisutil.appendSpace("", 10, 0) + hisutil.appendSpace("", 8, 0) + hisutil.appendSpace("", 10, 0) + " \n " + hisutil.appendSpace("", 5, 0) + hisutil.appendSpace(drugName.substring(31, 60), 46, 0) + hisutil.appendSpace("", 15, 0) + hisutil.appendSpace("", 10, 0) + hisutil.appendSpace("", 8, 0) + hisutil.appendSpace("", 10, 0) + " \n " + hisutil.appendSpace(drugName.substring(60, strlength), 46, 0);
               } else {
                  opdrugName = hisutil.appendSpace(drugName.substring(0, strlength), 46, 0);
               }

               prevItemName = opdrugName;
               ++counter;
            }
         } else {
            brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
            brPagination.append("<tr><td class='TITLE'> Stock Ledger</td></tr>");
            brPagination.append("<tr><td align='center'><Strong>Data Not Found</Strong></td></tr>");
            brPagination.append("</table>");
         }
      } catch (Exception var70) {
         var70.printStackTrace();
         throw new Exception("FTDStockLedgerRptHLP.getStockLedgerDtl()->" + var70.getMessage());
      } finally {
         if (ws != null) {
            ws.close();
            ws = null;
         }

      }

      return brPagination.toString();
   }

   public String getConsolidatedStockLedgerRptBatch_ValuePopUp(FTDStockLedgerRptVO vo, HttpServletRequest request) throws Exception {
      StringBuffer br = new StringBuffer(1000);
      StringBuffer brPagination = new StringBuffer(3000);
      WebRowSet ws = null;
      String prevItemId = "";
      String prevItemName = "";
      String prevBatch = "";
      String prevExpiry = "";
      String prevRate = "";
      String strFromDate = "";
      String strToDate = "";
      String strCheckHidValue = "";
      int REC_PER_PAGE = 0;
      String strCssClass = "multiRPTControl";
      int nFromDay = 0;
      int nToDay = 0;
      int nFromMonth = 0;
      int nToMonth = 0;
      int nFromYear = 0;
      int nToYear = 0;
      int counter = 0;
      int pageCounter = 0;
      int pageSize = 0;
      int sNo = 1;
      double nOpeningBalanceActive = 0.0D;
      double nOpeningBalanceActiveValue = 0.0D;
      double nClosingBalanceActive = 0.0D;
      double nClosingBalanceActiveValue = 0.0D;
      double nIssueActive = 0.0D;
      double nIssueActiveValue = 0.0D;
      double nRecActive = 0.0D;
      double nRecActiveValue = 0.0D;
      double nOpeningBalanceTotActive = 0.0D;
      double nOpeningBalanceTotActiveValue = 0.0D;
      double nClosingBalanceTotActive = 0.0D;
      double nClosingBalanceTotActiveValue = 0.0D;
      double nIssueTotActive = 0.0D;
      double nIssueTotActiveValue = 0.0D;
      double nRecTotActive = 0.0D;
      double nRecTotActiveValue = 0.0D;
      double totIssueRecQty = 0.0D;
      double totIssueRecQtyValue = 0.0D;
      String issueValue = "0.00";
      String recValue = "0.00";
      String strTableWidth = "95%";
      String strStoreName = "";
      NumberFormat formatter = new DecimalFormat("###############.##");
      HisUtil hisutil = new HisUtil("MMS", "FTDStockLedgerRptHLP");

      try {
         System.out.println("------------- FTDStockLedgerRptHLP.getConsolidatedStockLedgerRptBatch_ValuePopUp() --------------");
         ws = vo.getWrsData();
         br.append(this.getHeader_valuewise(6).toString());
         strFromDate = vo.getStrFromDate();
         strToDate = vo.getStrToDate();
          nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
          nToDay = Integer.parseInt(strToDate.split("\\-")[0]);
         this.getMonthInNumbers(strFromDate.split("\\-")[1]);
         this.getMonthInNumbers(strToDate.split("\\-")[1]);
          nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
          nToYear = Integer.parseInt(strToDate.split("\\-")[2]);
         if (ws != null && ws.size() > 0) {
            if (ws.next()) {
               strStoreName = ws.getString(4);
            }

            ws.beforeFirst();

            while(ws.next()) {
               if ((!prevItemId.equals(ws.getString(3)) || !prevBatch.equals(ws.getString(6))) && counter > 0) {
                  if (sNo % 2 == 0) {
                     strCssClass = "";
                  } else {
                     strCssClass = "";
                  }

                  strCheckHidValue = prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
                  nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
                  br.append("<tr id='tr'>");
                  br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
                  br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");
                  br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='35%'>" + prevItemName + "</td>");
                  br.append("<td style=\"text-align: left;\"   class= " + strCssClass + " colspan='1' width='5%'>" + prevRate + "</td>");
                  br.append("<td style=\"text-align: left;\"   class= " + strCssClass + " colspan='1' width='5%'>" + prevBatch + "</td>");
                  br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='5%'>" + prevExpiry + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + (int)nOpeningBalanceActive + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + String.format("%1$,.2f", nOpeningBalanceActiveValue) + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + (int)nRecActive + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + String.format("%1$,.2f", nRecActiveValue) + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + (int)nIssueActive + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + String.format("%1$,.2f", nIssueActiveValue) + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + (int)nClosingBalanceActive + "</td>");
                  br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + String.format("%1$,.2f", nClosingBalanceActive * Double.parseDouble(prevRate)) + "</td>");
                  totIssueRecQty = nRecActive + nIssueActive;
                  br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
                  br.append("</tr>");
                  nOpeningBalanceTotActive += nOpeningBalanceActive;
                  nClosingBalanceTotActive += nClosingBalanceActive;
                  nIssueTotActive += nIssueActive;
                  nRecTotActive += nRecActive;
                  nOpeningBalanceTotActiveValue += nOpeningBalanceActiveValue;
                  nClosingBalanceTotActiveValue += nClosingBalanceActiveValue;
                  nIssueTotActiveValue += nIssueActiveValue;
                  nRecTotActiveValue += nRecActiveValue;
                  nOpeningBalanceActive = 0.0D;
                  nClosingBalanceActive = 0.0D;
                  nIssueActive = 0.0D;
                  nRecActive = 0.0D;
                  nOpeningBalanceActiveValue = 0.0D;
                  nClosingBalanceActiveValue = 0.0D;
                  nIssueActiveValue = 0.0D;
                  nRecActiveValue = 0.0D;
                  ++pageCounter;
                  ++sNo;
               }

               nOpeningBalanceActive += (double)Long.parseLong(ws.getString(7));
               nIssueActive += (double)Long.parseLong(ws.getString(8));
               nRecActive += (double)Long.parseLong(ws.getString(9));
               nOpeningBalanceActiveValue += Double.parseDouble(ws.getString(12));
               issueValue = formatter.format(new BigDecimal(ws.getString(14)));
               recValue = formatter.format(new BigDecimal(ws.getString(13)));
               nIssueActiveValue += Double.parseDouble(issueValue);
               nRecActiveValue += Double.parseDouble(recValue);
               prevItemId = ws.getString(3);
               prevItemName = ws.getString(5);
               prevBatch = ws.getString(6);
               prevExpiry = ws.getString(10);
               prevRate = ws.getString(11);
               String drugName = ws.getString(5);
               int strlength = ws.getString(5).length();
               String opdrugName = "";
               if (strlength > 30) {
                  opdrugName = hisutil.appendSpace(drugName.substring(0, 30), 45, 0) + hisutil.appendSpace("", 15, 0) + hisutil.appendSpace("", 10, 0) + hisutil.appendSpace("", 8, 0) + hisutil.appendSpace("", 10, 0) + " \n " + hisutil.appendSpace(drugName.substring(31, strlength), 46, 0);
               } else if (strlength > 100) {
                  opdrugName = hisutil.appendSpace(drugName.substring(0, 30), 46, 0) + hisutil.appendSpace("", 15, 0) + hisutil.appendSpace("", 10, 0) + hisutil.appendSpace("", 8, 0) + hisutil.appendSpace("", 10, 0) + " \n " + hisutil.appendSpace("", 5, 0) + hisutil.appendSpace(drugName.substring(31, 60), 46, 0) + hisutil.appendSpace("", 15, 0) + hisutil.appendSpace("", 10, 0) + hisutil.appendSpace("", 8, 0) + hisutil.appendSpace("", 10, 0) + " \n " + hisutil.appendSpace(drugName.substring(60, strlength), 46, 0);
               } else {
                  opdrugName = hisutil.appendSpace(drugName.substring(0, strlength), 46, 0);
               }

               prevItemName = opdrugName;
               ++counter;
            }

            if (sNo % 2 == 0) {
               strCssClass = "";
            } else {
               strCssClass = "";
            }

            strCheckHidValue = prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
            nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
            nClosingBalanceActiveValue = nOpeningBalanceActiveValue + nRecActiveValue - nIssueActiveValue;
            br.append("<tr id='tr'>");
            br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
            br.append("<td class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");
            br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='35%'>" + prevItemName + "</td>");
            br.append("<td style=\"text-align: left;\"   class= " + strCssClass + " colspan='1' width='5%'>" + prevRate + "</td>");
            br.append("<td style=\"text-align: left;\"   class= " + strCssClass + " colspan='1' width='5%'>" + prevBatch + "</td>");
            br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='5%'>" + prevExpiry + "</td>");
            br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + (int)nOpeningBalanceActive + "</td>");
            br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + String.format("%1$,.2f", nOpeningBalanceActiveValue) + "</td>");
            br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + (int)nRecActive + "</td>");
            br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + String.format("%1$,.2f", nRecActiveValue) + "</td>");
            br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + (int)nIssueActive + "</td>");
            br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + String.format("%1$,.2f", nIssueActiveValue) + "</td>");
            br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + (int)nClosingBalanceActive + "</td>");
            br.append("<td style=\"text-align: right;\"  class= " + strCssClass + " colspan='1' width='5%'>" + String.format("%1$,.2f", nClosingBalanceActive * Double.parseDouble(prevRate)) + "</td>");
            totIssueRecQty = nRecActive + nIssueActive;
            br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
            br.append("</tr>");
            nOpeningBalanceTotActive += nOpeningBalanceActive;
            nClosingBalanceTotActive += nClosingBalanceActive;
            nIssueTotActive += nIssueActive;
            nRecTotActive += nRecActive;
            nOpeningBalanceTotActiveValue += nOpeningBalanceActiveValue;
            double var10000 = nClosingBalanceTotActiveValue + nClosingBalanceActiveValue;
            nIssueTotActiveValue += nIssueActiveValue;
            nRecTotActiveValue += nRecActiveValue;
            br.append("<tr bgcolor='' id='tr'>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='5' width='35%'><b>Grand Total</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + (int)nOpeningBalanceTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + String.format("%1$,.2f", nOpeningBalanceTotActiveValue) + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + (int)nRecTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + String.format("%1$,.2f", nRecTotActiveValue) + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + (int)nIssueTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + String.format("%1$,.2f", nIssueTotActiveValue) + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>" + (int)nClosingBalanceTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b></b></td>");
            br.append("</tr>");
            brPagination.append("<HTML><HEAD><script language='Javascript' src='../../mms/js/stockledgerFTD_mmsrpt.js'></script><script language='JavaScript' src='../../hisglobal/jquery/3.6.0.min.js'></script><script language='Javascript' src='../../hisglobal/js/innerxhtml.js'></script><body><form action='/INVMGM/mms/reports/FTDStockLedgerRptCNT.cnt' method='post'><div id='consolidatedBatchWiseStockLedgerRptDivId'>");
            brPagination.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
            brPagination.append("<tr> ");
            brPagination.append("<td align='right'>");
            brPagination.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'> <div id='printImg'>");
            brPagination.append("<img style='cursor: pointer; ' title='Print Page'  ");
            brPagination.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printThis();' /> <img style='cursor: pointer; ' title='Save as Excel' src='../../hisglobal/images/excel1.png' onClick='generateXLS(event,\"consolidatedBatchWiseStockLedgerRptDivId\");' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
            brPagination.append(" src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div>");
            brPagination.append(" </td> ");
            brPagination.append(" </tr> ");
            brPagination.append(" </table> ");
            brPagination.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0'> ");
            brPagination.append("<tr><td width='10%' colspan='1'  align='right'><div  align='right'></div></td> ");
            brPagination.append("<td width='80%' colspan='12' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
            brPagination.append("Stock Ledger ");
            brPagination.append("</font></b></td><td colspan='1' width='10%'></td> ");
            brPagination.append("</tr> ");
            brPagination.append("<tr> ");
            brPagination.append("<td width='10%' colspan='1'></td> ");
            brPagination.append("<td width='80%' colspan='12' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
            brPagination.append("Store Name : " + strStoreName + "<br>");
            brPagination.append("</font></b></td><td width='10%' colspan='1'> ");
            brPagination.append("</td> ");
            brPagination.append("</tr> ");
            brPagination.append("<tr> ");
            brPagination.append("<td width='10%' colspan='1' ></td> ");
            brPagination.append("<td width='80%' colspan='12' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
            brPagination.append("Between : " + vo.getStrFromDate() + " And " + vo.getStrToDate());
            brPagination.append("</font></b></td><td width='10%' colspan='1' > ");
            brPagination.append("</td> ");
            brPagination.append("</tr> ");
            brPagination.append("</table> ");
            brPagination.append("<table align='center' width='").append(strTableWidth).append("' border='1' cellspacing='0' cellpadding='0''> ");
            brPagination.append(br);
            brPagination.append("</table></div></HEAD></HTML>");
         } else {
            brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
            brPagination.append("<tr><td class='TITLE'>Stock Ledger</td></tr>");
            brPagination.append("<tr><td align='center'><Strong>No Data Found</Strong></td></tr>");
            brPagination.append("</table>");
         }
      } catch (Exception var74) {
         var74.printStackTrace();
         throw new Exception("FTDStockLedgerRptHLP.getConsolidatedStockLedgerRptBatch()->" + var74.getMessage());
      } finally {
         if (ws != null) {
            ws.close();
            ws = null;
         }

      }

      return brPagination.toString();
   }

   public StringBuffer getHeader(int callType) {
      StringBuffer brHeader = new StringBuffer(1000);
      if (callType == 1) {
         brHeader.append("<tr>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>S. No.</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='30%'>Item Name</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'>Opening Balance</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'>Received Qty</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'>Issued Qty</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'>Closing Balance</td>");
         brHeader.append("</tr>");
      }

      if (callType == 2) {
         brHeader.append("<tr>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>S. No.</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='35%'>Item Name</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Batch No</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='7%'>Expiry Date</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Opening Balance</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Received Qty</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Issued Qty</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Closing Balance</td>");
         brHeader.append("</tr>");
      }

      if (callType == 3) {
         brHeader.append("<tr>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>S. No.</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='35%'>Date</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='31%'>Particulars</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Received Qty</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Issued Qty</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Balance</td>");
         brHeader.append("</tr>");
      }

      if (callType == 4) {
         brHeader.append("<tr>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>S. No.</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Date</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Batch No</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Expiry</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'>Particulars</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Received Qty</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Issued Qty</td>");
         brHeader.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'>Closing Bal</td>");
         brHeader.append("</tr>");
      }

      if (callType == 5) {
         brHeader.append("<tr bgcolor='#cdc9c9' >");
         brHeader.append("<td CLASS='' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S. No.</b></font></td>");
         brHeader.append("<td CLASS='' colspan='1' width='30%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font></td>");
         brHeader.append("<td CLASS='' colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Opening Balance</b></font></td>");
         brHeader.append("<td CLASS='' colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty</b></font></td>");
         brHeader.append("<td CLASS='' colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty</b></font></td>");
         brHeader.append("<td CLASS='' colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Closing Balance</b></font></td>");
         brHeader.append("</tr>");
      }

      if (callType == 6) {
         brHeader.append("<tr bgcolor='#cdc9c9'>");
         brHeader.append("<td  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S. No.</b></font></td>");
         brHeader.append("<td  colspan='1' width='35%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font></td>");
         brHeader.append("<td  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No</b></font></td>");
         brHeader.append("<td  colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font></td>");
         brHeader.append("<td  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Opening Balance</b></font></td>");
         brHeader.append("<td  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty</b></font></td>");
         brHeader.append("<td  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty</b></font></td>");
         brHeader.append("<td  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Closing Balance</b></font></td>");
         brHeader.append("</tr>");
      }

      return brHeader;
   }

   public String getDetailedStockLedgerDtl(FTDStockLedgerRptVO vo, HttpServletRequest request) throws Exception {
      StringBuffer br = new StringBuffer(1000);
      StringBuffer brPagination = new StringBuffer(3000);
      int REC_PER_PAGE = 0;
      String strCssClass = "multiRPTControl3";
      String strStoreName = "";
      String strDrugName = "";
      String strExpiryDate = "";
      int sNo = 1;
      int pageSize = 1;
      int pageCounter = 0;
      int nColspan = 0;
      long nRecQty = 0L;
      long nIssueQty = 0L;
      long nBalanceActiveQty = 0L;
      WebRowSet ws = null;
      String strRecString = "";
      String strIssueString = "";

      try 
      {
         System.out.println("------------- FTDStockLedgerRptHLP.getDetailedStockLedgerDtl() --------------");
         String strHiddenParameter = vo.getStrDWHId() + "^" + vo.getStrItemBrandId() + "^" + vo.getStrFromDate() + "^" + vo.getStrToDate() + "^" + vo.getStrBatchNo() + "^" + vo.getStrOpeningBalance() + "^" + vo.getStrStoreName() + "^" + vo.getStrDrugName() + "^" + vo.getStrBatchFlag();
         
         String[] tempArr = vo.getStrOpeningBalance().split("\\#");
      
         System.out.println("vo.getStrFromDate()---" + vo.getStrFromDate());
         System.out.println("vo.getStrToDate()---" + vo.getStrToDate());
         System.out.println("vo.setStrJobInitialDate()---" + vo.getStrJobInitialDate());
         System.out.println("vo.getStrBatchNo()---" + vo.getStrBatchNo());
         System.out.println("Activ # Quarantine # In-Active---" + vo.getStrOpeningBalance());
         
         nBalanceActiveQty = Long.parseLong(tempArr[0].split("\\.")[0]);
        //byte nColspan;
         if (vo.getStrBatchNo().equals("0")) 
         {
            br.append(this.getHeader(4).toString());
            nColspan = 8;
         } 
         else 
         {
            br.append(this.getHeader(3).toString());
            nColspan = 8;
         }

         if (vo.getStrBatchNo().equals("0")) 
         {
            br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
            br.append("<td class= " + strCssClass + " colspan='1' width='5%'><b>" + sNo + "</b></td>");
            br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='10%'><b>" + vo.getStrFromDate() + "</b></td>");
            br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");
            br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'><b>" + nBalanceActiveQty + "</b></td>");
            br.append("</tr>");
         } 
         else 
         {
            br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
            br.append("<td class= " + strCssClass + " colspan='1' width='5%'><b>" + sNo + "</b></td>");
            br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='15%'><b>" + vo.getStrFromDate() + "</b></td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'><b>" + nBalanceActiveQty + "</b></td>");
            br.append("</tr>");
         }

         sNo = sNo + 1;
         pageCounter = pageCounter + 1;
         
         ws = vo.getWrsData();   // Web-Row Set Assign here 
         
         if (ws != null && ws.size() > 0) 
         {
            while(ws.next()) 
            {
               if (sNo % 2 == 0) 
               {
                  strCssClass = "multiRPTControl1";
               } 
               else 
               {
                  strCssClass = "multiRPTControl3";
               }

               if (pageCounter == 1000) 
               {
                  ++pageSize;
                  pageCounter = 0;
               }

               nRecQty = Long.parseLong(ws.getString(6)) + Long.parseLong(ws.getString(7)) + Long.parseLong(ws.getString(8));
               nIssueQty = Long.parseLong(ws.getString(3)) + Long.parseLong(ws.getString(4)) + Long.parseLong(ws.getString(5));
               if (nRecQty > 0L) 
               {
                  Long.parseLong(ws.getString(6));
               } 
               else 
               {
                  strRecString = "";
               }

               if (nIssueQty > 0L) 
               {
                  Long.parseLong(ws.getString(3));
               } 
               else 
               {
                  strIssueString = "";
               }

               nBalanceActiveQty = nBalanceActiveQty + Long.parseLong(ws.getString(6)) - Long.parseLong(ws.getString(3));
               if (pageSize == 1) 
               {
                  br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
               } 
               else 
               {
                  br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
               }

               br.append("<td class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");
               if (vo.getStrBatchNo().equals("0")) 
               {
                  br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='10%'>" + ws.getString(1) + "</td>");
                  br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='10%'>" + ws.getString(11) + "</td>");
                  br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='10%'>" + ws.getString(12) + "</td>");
                  br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='25%'>" + ws.getString(2) + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nRecQty + strRecString + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nIssueQty + strIssueString + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nBalanceActiveQty + "</td>");
               } 
               else 
               {
                  br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='15%'>" + ws.getString(1) + "</td>");
                  br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='31%'>" + ws.getString(2) + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nRecQty + strRecString + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nIssueQty + strIssueString + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'>" + nBalanceActiveQty + "</td>");
               }

               br.append("</tr>");
               if (sNo == 2) {
                  strStoreName = ws.getString(9);
                  strDrugName = ws.getString(10);
                  strExpiryDate = ws.getString(12);
               }

               ++pageCounter;
               ++sNo;
            }

            if (pageSize == 1) {
               br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
            } else {
               br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
            }

            br.append("<td class= " + strCssClass + " colspan='1' width='5%'><b>" + sNo + "</b></td>");
            if (vo.getStrBatchNo().equals("0")) {
               br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='10%'><b>" + vo.getStrToDate() + "</b></td>");
               br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");
               br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");
               br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='25%'><b>Closing Balance</b></td>");
               br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>--</td>");
               br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>--</td>");
               br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'><b>" + nBalanceActiveQty + "</b></td>");
            } else {
               br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='15%'><b>" + vo.getStrToDate() + "</b></td>");
               br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='31%'><b>Closing Balance</b></td>");
               br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");
               br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'><b>--</b></td>");
               br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='8%'><b>" + nBalanceActiveQty + "</b></td>");
            }

            br.append("</tr>");
            br.append("<tr class='FOOTER' style='text-align:left;background: linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;'><td colspan='" + nColspan + "' >&nbsp;</td></tr>");
            br.append("<tr><td colspan='" + nColspan + "'>");
            br.append("<div class='control_button' id='showButtonID'>");
            br.append("<table border='0' width='95%' align='center' cellspacing='1px' cellpadding='1px'>");
            br.append("<tr id='saveId'>");
            br.append("<td align='center'><div>");
            br.append("<a href='#' class='button' title='Print' onClick='printItemDetailedStockLedgerReport(this);' ><span class='print'>Print</span></a>");
            br.append("<a href='#' class='button' title='Cancel' onClick='window.close();' ><span class='cancel'>Cancel</span></a>");
            br.append("</div></td>");
            br.append("</tr>");
            br.append("</table>");
            br.append("</div>");
            br.append("</td></tr>");
            brPagination.append("<HTML><head><link href='../../hisglobal/css/dwh.css' rel='stylesheet' type='text/css'><link href='../../hisglobal/css/control.css' rel='stylesheet' type='text/css'><script language='Javascript' src='../../mms/js/stockledgerFTD_mmsrpt.js'></script><style type='text/css'>.pg-normal{color: blue;font-weight: normal;text-decoration: none;cursor: pointer;}.pg-selected{color: red;font-weight: bold;text-decoration: underline;cursor: pointer;}.pg-qualified{color: green;font-weight: bold;text-decoration: underline;cursor: pointer;}.multiRPTControl1 {background-color: #D8D8D8;color: #000000;font-family: Verdana,Arial,Helvetica,sans-serif;font-size: 10px;font-style: normal;font-weight: normal;height: 12px;text-align: center;}</style></head><body class='background'><form class='formbg'>");
            brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px'>");
            brPagination.append("<tr class='HEADER' style='background: linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;'><td colspan='4'> Stock Ledger Detail </td></tr>");
            brPagination.append("<tr><td class='multiRPTLabel' width='20%'>Store Name</td>");
            brPagination.append("<td class='multiRPTControl' width='30%'><div align='left'>" + strStoreName + "</div></td>");
            brPagination.append("<td class='multiRPTLabel' width='20%'>Item Name</td>");
            brPagination.append("<td class='multiRPTControl' width='30%'><div align='left'>" + strDrugName + "</div></td>");
            brPagination.append("</tr>");
            if (!vo.getStrBatchNo().equals("0")) {
               brPagination.append("<tr><td class='multiRPTLabel' width='20%'> Batch No</td>");
               brPagination.append("<td class='multiRPTControl' width='30%'><div align='left'>" + vo.getStrBatchNo() + "</div></td>");
               brPagination.append("<td class='multiRPTLabel' width='20%'>Expiry Date</td>");
               brPagination.append("<td class='multiRPTControl' width='30%'><div align='left'>" + strExpiryDate + "</div></td>");
               brPagination.append("</tr>");
            }

            brPagination.append("<tr><td class='multiRPTLabel' width='20%'>From Date</td>");
            brPagination.append("<td class='multiRPTControl' width='30%'><div align='left'>" + vo.getStrFromDate() + "</div></td>");
            brPagination.append("<td class='multiRPTLabel' width='20%'>To Date</td>");
            brPagination.append("<td class='multiRPTControl' width='30%'><div align='left'>" + vo.getStrToDate() + "</div></td>");
            brPagination.append("</tr>");
            brPagination.append("</table>");
            brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1' >");
            brPagination.append("<tr class='FOOTER' style='text-align:left;background: linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;'><td colspan='" + nColspan + "'>Item Details</td></tr>");
            brPagination.append("<tr>");
            brPagination.append("<td class='LABEL' colspan='" + nColspan + "'>");

            for(int i = 0; i < pageSize; ++i) {
               if (i == 0) {
                  brPagination.append("<a name='pg' id='pg" + (i + 1) + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-selected' title='Record Indexing'" + " onClick='GetIndex(\"" + (i + 1) + "\",\"" + 1000 + "\")'>" + (i + 1) + "</a>|&nbsp;");
               } else {
                  brPagination.append("<a name='pg' id='pg" + (i + 1) + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing'" + " onClick='GetIndex(\"" + (i + 1) + "\",\"" + 1000 + "\")'>" + (i + 1) + "</a>|&nbsp;");
               }
            }

            brPagination.append("</td></tr>");
            brPagination.append(br);
            brPagination.append("</table>");
            brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='0' >");
            brPagination.append("<tr >");
            brPagination.append("<td><font size='2' color='BLUE'>");
            brPagination.append("</td>");
            brPagination.append("</tr>");
            brPagination.append("</table>");
            brPagination.append("<input type='hidden' name='selPageIndex' value='1'/>");
            brPagination.append("<input type='hidden' name='strHiddenParameter' value='" + strHiddenParameter + "'>");
            brPagination.append("</form></body></HTML>");
         }
      } catch (Exception var29) {
         var29.printStackTrace();
         throw new Exception("FTDStockLedgerRptHLP.getDetailedStockLedgerDtl()->" + var29.getMessage());
      } finally {
         if (ws != null) {
            ws.close();
            ws = null;
         }

      }

      return brPagination.toString();
   }

   public String getDetailedStockLedgerDtl_NEW(FTDStockLedgerRptVO vo, HttpServletRequest request) throws Exception {
      StringBuffer br = new StringBuffer(1000);
      StringBuffer brPagination = new StringBuffer(3000);
      WebRowSet ws = null;
      String prevItemId = "";
      String prevItemName = "";
      String prevBatch = "";
      String prevExpiry = "";
      String prevTransDate = "";
      String prevParticulars = "";
      String strFromDate = "";
      String strToDate = "";
      String strCheckHidValue = "";
      int REC_PER_PAGE = 0;
      String strCssClass = "multiRPTControl";
      int nFromDay = 0;
      int nToDay = 0;
      int nFromMonth = 0;
      int nToMonth = 0;
      int nFromYear = 0;
      int nToYear = 0;
      int counter = 0;
      int pageCounter = 0;
      int pageSize = 1;
      int sNo = 1;
      long nOpeningBalanceActive = 0L;
      long nClosingBalanceActive = 0L;
      long nIssueActive = 0L;
      long nIssueQuar = 0L;
      long nIssueRej = 0L;
      long nRecActive = 0L;
      long nRecQuar = 0L;
      long nRecRej = 0L;
      long nOpeningBalanceTotActive = 0L;
      long nClosingBalanceTotActive = 0L;
      long nIssueTotActive = 0L;
      long nRecTotActive = 0L;
      long totIssueRecQty = 0L;

      try {
         ws = vo.getWrsData();
         br.append(this.getHeader(4).toString());
         strFromDate = vo.getStrFromDate();
         strToDate = vo.getStrToDate();
          nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
          nToDay = Integer.parseInt(strToDate.split("\\-")[0]);
         this.getMonthInNumbers(strFromDate.split("\\-")[1]);
         this.getMonthInNumbers(strToDate.split("\\-")[1]);
          nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
          nToYear = Integer.parseInt(strToDate.split("\\-")[2]);
         if (ws != null && ws.size() > 0) {
            while(ws.next()) {
               if (!prevBatch.equals(ws.getString(11)) && counter > 0) {
                  if (sNo % 2 == 0) {
                     strCssClass = "multiRPTControl1";
                  } else {
                     strCssClass = "multiRPTControl3";
                  }

                  strCheckHidValue = prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive;
                  nClosingBalanceActive = nRecActive - nIssueActive;
                  if (pageCounter == 1000) {
                     ++pageSize;
                     pageCounter = 0;
                  }

                  if (pageSize == 1) {
                     br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
                  } else {
                     br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
                  }

                  br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
                  br.append("<td class= " + strCssClass + " colspan='1'   width='5%'>" + sNo + "</td>");
                  br.append("<td style=\"text-align: center;\"  class= " + strCssClass + " colspan='1' width='10%'>" + prevTransDate + "</td>");
                  br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='8%'>" + prevBatch + "</td>");
                  br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='7%'>" + prevExpiry + "</td>");
                  br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='7%'>" + prevParticulars + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceActive + "</td>");
                  totIssueRecQty = nRecActive + nRecQuar + nRecRej + nIssueActive + nIssueQuar + nIssueRej;
                  br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
                  br.append("</tr>");
                  nOpeningBalanceTotActive += nOpeningBalanceActive;
                  nClosingBalanceTotActive += nClosingBalanceActive;
                  nIssueTotActive += nIssueActive;
                  nRecTotActive += nRecActive;
                  System.out.println("-----------------" + prevItemName + "----------A-----------" + prevBatch + "-----------------");
                  System.out.println("nOpeningBalanceTotActive-----" + nOpeningBalanceTotActive);
                  System.out.println("nOpeningBalanceTotActive-----" + nOpeningBalanceTotActive);
                  System.out.println("nClosingBalanceTotActive-----" + nClosingBalanceTotActive);
                  System.out.println("nIssueTotActive-----" + nIssueTotActive);
                  System.out.println("nRecTotActive-----" + nRecTotActive);
                  System.out.println("-------------------------------------------------------");
                  nOpeningBalanceActive = 0L;
                  nClosingBalanceActive = 0L;
                  nIssueActive = 0L;
                  nIssueQuar = 0L;
                  nIssueRej = 0L;
                  nRecActive = 0L;
                  nRecQuar = 0L;
                  nRecRej = 0L;
                  ++pageCounter;
                  ++sNo;
               }

               if (nFromYear == Integer.parseInt(ws.getString(14).split("\\-")[2])) 
               {
                  String[] tempArr = vo.getStrOpeningBalance().split("\\#");
                  //System.out.println("nOpeningBalanceActive-----" + tempArr[0].split("\\.")[0]);
               }

               nIssueActive = nIssueActive + Long.parseLong(ws.getString(3)) + Long.parseLong(ws.getString(4)) + Long.parseLong(ws.getString(5));
               nRecActive = nRecActive + Long.parseLong(ws.getString(6)) + Long.parseLong(ws.getString(7)) + Long.parseLong(ws.getString(8));
               prevItemId = ws.getString(15);
               prevItemName = ws.getString(10);
               prevBatch = ws.getString(11);
               prevExpiry = ws.getString(12);
               prevTransDate = ws.getString(1);
               prevParticulars = ws.getString(2);
               ++counter;
            }

            if (sNo % 2 == 0) {
               strCssClass = "multiRPTControl1";
            } else {
               strCssClass = "multiRPTControl3";
            }

            strCheckHidValue = prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive;
            nClosingBalanceActive = nRecActive - nIssueActive;
            if (pageCounter == 1000) {
               ++pageSize;
               pageCounter = 0;
            }

            if (pageSize == 1) {
               br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
            } else {
               br.append("<tr id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
            }

            br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
            br.append("<td class= " + strCssClass + " colspan='1'   width='5%'>" + sNo + "</td>");
            br.append("<td style=\"text-align: center;\"  class= " + strCssClass + " colspan='1' width='10%'>" + prevTransDate + "</td>");
            br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='8%'>" + prevBatch + "</td>");
            br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='7%'>" + prevExpiry + "</td>");
            br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='7%'>" + prevParticulars + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceActive + "</td>");
            totIssueRecQty = nRecActive + nRecQuar + nRecRej + nIssueActive + nIssueQuar + nIssueRej;
            br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
            br.append("</tr>");
            nOpeningBalanceTotActive += nOpeningBalanceActive;
            nClosingBalanceTotActive += nClosingBalanceActive;
            nIssueTotActive += nIssueActive;
            nRecTotActive += nRecActive;
            System.out.println("-----------------" + prevItemName + "----------B----------" + prevBatch + "-----------------");
            System.out.println("nOpeningBalanceTotActive-----" + nOpeningBalanceTotActive);
            System.out.println("nClosingBalanceTotActive-----" + nClosingBalanceTotActive);
            System.out.println("nIssueTotActive-----" + nIssueTotActive);
            System.out.println("nRecTotActive-----" + nRecTotActive);
            System.out.println("-------------------------------------------------------");
            ++pageCounter;
            if (pageSize == 1) {
               br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "'>");
            } else {
               br.append("<tr bgcolor='#CC9966' id='tr" + pageSize + "-" + (pageCounter + 1) + "' style=\"display:none;\">");
            }

            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='4' width='35%'><b>Grand Total</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nOpeningBalanceTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nRecTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nIssueTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><b>" + nClosingBalanceTotActive + "</b></td>");
            br.append("</tr>");
            brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
            brPagination.append("<tr><td colspan='16' class='TITLE'>Stock Ledger</td></tr>");
            brPagination.append("<tr>");
            brPagination.append("<td class='LABEL' colspan='16'>");

            for(int i = 0; i < pageSize; ++i) {
               if (i == 0) {
                  brPagination.append("<a name='pg' id='pg" + (i + 1) + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-selected' title='Record Indexing'" + " onClick='GetIndex(\"" + (i + 1) + "\",\"" + 1000 + "\")'>" + (i + 1) + "</a>|&nbsp;");
               } else {
                  brPagination.append("<a name='pg' id='pg" + (i + 1) + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing'" + " onClick='GetIndex(\"" + (i + 1) + "\",\"" + 1000 + "\")'>" + (i + 1) + "</a>|&nbsp;");
               }
            }

            brPagination.append("</td></tr>");
            brPagination.append(br);
            brPagination.append("</table>");
         } else {
            brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
            brPagination.append("<tr><td class='TITLE'>Stock Ledger </td></tr>");
            brPagination.append("<tr><td align='center'><Strong>No Data Found</Strong></td></tr>");
            brPagination.append("</table>");
         }
      } catch (Exception var59) {
         var59.printStackTrace();
         throw new Exception("FTDStockLedgerRptHLP.getStockLedgerDtl()->" + var59.getMessage());
      } finally {
         if (ws != null) {
            ws.close();
            ws = null;
         }

      }

      return brPagination.toString();
   }

   public String getOpeningBalance(WebRowSet ws, int nDay) {
      Long nIssueQtyActive = 0L;
      Long nRecQtyActive = 0L;
      Long nOpeningBalQtyActive = 0L;
      String strOpeningBalance = "0^0^0";

      try {
         nOpeningBalQtyActive = Long.parseLong(ws.getString(7));
         nIssueQtyActive = nIssueQtyActive + Long.parseLong(ws.getString(8));
         nRecQtyActive = nRecQtyActive + Long.parseLong(ws.getString(9));
         nOpeningBalQtyActive = nOpeningBalQtyActive + nRecQtyActive - nIssueQtyActive;
         strOpeningBalance = nOpeningBalQtyActive + "^" + "0" + "^" + "0";
      } catch (Exception var8) {
         var8.printStackTrace();
      }

      return strOpeningBalance;
   }

   public String getReceivedAndIssuedQty(WebRowSet ws, int nFromDay, int nFromMonth, int nFromYear, int nToDay, int nToMonth, int nToYear) {
      Long nIssueQtyActive = 0L;
      Long nRecQtyActive = 0L;
      String strIssueRecQty = "0^0^0#0^0^0";

      try {
         nIssueQtyActive = nIssueQtyActive + Long.parseLong(ws.getString(8));
         nRecQtyActive = nRecQtyActive + Long.parseLong(ws.getString(9));
         strIssueRecQty = nIssueQtyActive + "^" + "0" + "^" + "0" + "#" + nRecQtyActive + "^" + "0" + "^" + "0";
      } catch (Exception var12) {
         var12.printStackTrace();
      }

      return strIssueRecQty;
   }

   public int getMonthInNumbers(String strMonth) {
      int nMonth = 0;
      if (strMonth.equalsIgnoreCase("Jan")) {
         nMonth = 1;
      } else if (strMonth.equalsIgnoreCase("Feb")) {
         nMonth = 2;
      } else if (strMonth.equalsIgnoreCase("Mar")) {
         nMonth = 3;
      } else if (strMonth.equalsIgnoreCase("Apr")) {
         nMonth = 4;
      } else if (strMonth.equalsIgnoreCase("May")) {
         nMonth = 5;
      } else if (strMonth.equalsIgnoreCase("Jun")) {
         nMonth = 6;
      } else if (strMonth.equalsIgnoreCase("Jul")) {
         nMonth = 7;
      } else if (strMonth.equalsIgnoreCase("Aug")) {
         nMonth = 8;
      } else if (strMonth.equalsIgnoreCase("Sep")) {
         nMonth = 9;
      } else if (strMonth.equalsIgnoreCase("Oct")) {
         nMonth = 10;
      } else if (strMonth.equalsIgnoreCase("Nov")) {
         nMonth = 11;
      } else if (strMonth.equalsIgnoreCase("Dec")) {
         nMonth = 12;
      }

      return nMonth;
   }

   public String getConsolidatedStockLedgerRpt(FTDStockLedgerRptVO vo, HttpServletRequest request) throws Exception {
      StringBuffer br = new StringBuffer(1000);
      StringBuffer brPagination = new StringBuffer(3000);
      WebRowSet ws = null;
      String strTableWidth = "100%";
      String prevItemId = "";
      String prevItemName = "";
      String strFromDate = "";
      String strToDate = "";
      String strCheckHidValue = "";
      String strCssClass = "";
      String strStoreName = "";
      int nFromDay = 0;
      int nToDay = 0;
      int nFromMonth = 0;
      int nToMonth = 0;
      int nFromYear = 0;
      int nToYear = 0;
      int counter = 0;
      int pageCounter = 0;
      int pageSize = 0;
      int sNo = 1;
      long nOpeningBalanceActive = 0L;
      long nClosingBalanceActive = 0L;
      long nIssueActive = 0L;
      long nRecActive = 0L;
      long nOpeningBalanceTotActive = 0L;
      long nClosingBalanceTotActive = 0L;
      long nIssueTotActive = 0L;
      long nRecTotActive = 0L;
      long totIssueRecQty = 0L;

      try {
         System.out.println("----------- FTDStockLedgerRptHLP.getConsolidatedStockLedgerRpt -----------");
         ws = vo.getWrsData();
         br.append(this.getHeader(5).toString());
         strFromDate = vo.getStrFromDate();
         strToDate = vo.getStrToDate();
          nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
          nToDay = Integer.parseInt(strToDate.split("\\-")[0]);
         this.getMonthInNumbers(strFromDate.split("\\-")[1]);
         this.getMonthInNumbers(strToDate.split("\\-")[1]);
          nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
          nToYear = Integer.parseInt(strToDate.split("\\-")[2]);
         if (ws != null && ws.size() > 0) {
            if (ws.next()) {
               strStoreName = ws.getString(4);
            }

            ws.beforeFirst();

            while(ws.next()) {
               if (!prevItemId.equals(ws.getString(3)) && counter > 0) {
                  if (sNo % 2 == 0) {
                     strCssClass = "";
                  } else {
                     strCssClass = "";
                  }

                  strCheckHidValue = prevItemId + "^0^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
                  nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
                  br.append("<tr id='tr'>");
                  br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
                  br.append("<td class= " + strCssClass + " colspan='1' style='text-align: right;' width='5%'>" + sNo + "</td>");
                  br.append("<td style=\"text-align: left;\"  class= " + strCssClass + "  colspan='1' width='30%'>" + prevItemName + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceActive + "</td>");
                  totIssueRecQty = nRecActive + nIssueActive;
                  br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
                  br.append("</tr>");
                  nOpeningBalanceTotActive += nOpeningBalanceActive;
                  nClosingBalanceTotActive += nClosingBalanceActive;
                  nIssueTotActive += nIssueActive;
                  nRecTotActive += nRecActive;
                  nOpeningBalanceActive = 0L;
                  nClosingBalanceActive = 0L;
                  nIssueActive = 0L;
                  nRecActive = 0L;
                  ++pageCounter;
                  ++sNo;
               }

               nOpeningBalanceActive += Long.parseLong(ws.getString(7));
               nIssueActive += Long.parseLong(ws.getString(8));
               nRecActive += Long.parseLong(ws.getString(9));
               prevItemId = ws.getString(3);
               prevItemName = ws.getString(5);
               ++counter;
            }

            if (sNo % 2 == 0) {
               strCssClass = "";
            } else {
               strCssClass = "";
            }

            strCheckHidValue = prevItemId + "^0^" + nOpeningBalanceActive + "^0^0";
            nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
            br.append("<tr id='tr'>");
            br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
            br.append("<td class= " + strCssClass + " colspan='1' style='text-align: right;' width='5%'>" + sNo + "</td>");
            br.append("<td style=\"text-align: left;\"  class= " + strCssClass + "  colspan='1' width='30%'>" + prevItemName + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceActive + "</td>");
            totIssueRecQty = nRecActive + nIssueActive;
            br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
            br.append("</tr>");
            nOpeningBalanceTotActive += nOpeningBalanceActive;
            nClosingBalanceTotActive += nClosingBalanceActive;
            nIssueTotActive += nIssueActive;
            nRecTotActive += nRecActive;
            br.append("<tr bgcolor='' id='tr'>");
            br.append("<td style=\"text-align: right;\" class='' colspan='2' width='35%'><b>Grand Total</b></td>");
            br.append("<td style=\"text-align: right;\" class='' colspan='1' width='5%'><b>" + nOpeningBalanceTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='' colspan='1' width='5%'><b>" + nRecTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='' colspan='1' width='5%'><b>" + nIssueTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\" class='' colspan='1' width='5%'><b>" + nClosingBalanceTotActive + "</b></td>");
            br.append("</tr>");
            brPagination.append("<HTML><HEAD><script language='Javascript' src='../../mms/js/stockledgerFTD_mmsrpt.js'></script><script language='JavaScript' src='../../hisglobal/jquery/3.6.0.min.js'></script><script language='Javascript' src='../../hisglobal/js/innerxhtml.js'></script><script src='https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.16.9/xlsx.full.min.js'></script><body><form action='/INVMGM/mms/reports/FTDStockLedgerRptCNT.cnt' method='post'><div id='consolidatedBatchWiseStockLedgerRptDivId'>");
            brPagination.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
            brPagination.append("<tr> ");
            brPagination.append("<td align='right'>");
            brPagination.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'> <div id='printImg'>");
            brPagination.append("<img style='cursor: pointer; ' title='Print Page'  ");
            brPagination.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printThis();' /> <img style='cursor: pointer; ' title='Save as Excel' src='../../hisglobal/images/excel1.png' onClick='generateXLS1();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
            brPagination.append(" src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div>");
            brPagination.append(" </td> ");
            brPagination.append(" </tr> ");
            brPagination.append(" </table> ");
            brPagination.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' id='table' cellpadding='0'> ");
            brPagination.append("<tr><td width='10%' colspan='1'  align='right'><div  align='right'></div></td> ");
            brPagination.append("<td width='80%' colspan='12' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
            brPagination.append("Stock Ledger");
            brPagination.append("</font></b></td><td colspan='1' width='10%'></td> ");
            brPagination.append("</tr> ");
            brPagination.append("<tr> ");
            brPagination.append("<td width='10%' colspan='1'></td> ");
            brPagination.append("<td width='80%' colspan='12' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
            brPagination.append("Store Name : " + strStoreName + "<br>");
            brPagination.append("</font></b></td><td width='10%' colspan='1'> ");
            brPagination.append("</td> ");
            brPagination.append("</tr> ");
            brPagination.append("<tr> ");
            brPagination.append("<td width='10%' colspan='1' ></td> ");
            brPagination.append("<td width='80%' colspan='12' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
            brPagination.append("Between : " + vo.getStrFromDate() + " And  " + vo.getStrToDate());
            brPagination.append("</font></b></td><td width='10%' colspan='1' > ");
            brPagination.append("</td> ");
            brPagination.append("</tr> ");
            brPagination.append("</table> ");
            brPagination.append("<table align='center' width='").append(strTableWidth).append("' border='1' cellspacing='0' id='table1' cellpadding='0''> ");
            brPagination.append(br);
            brPagination.append("</table></div></HEAD></HTML>");
         } else {
            brPagination.append("<table width='95%' align='center' cellspacing='1px' cellpadding='1px'>");
            brPagination.append("<tr><td colspan='14' class='TITLE'>Stock Ledger</td></tr>");
            brPagination.append("<tr><td colspan='14' align='center'><Strong>No Data Found</Strong></td></tr>");
            brPagination.append("</table>");
         }
      } catch (Exception var46) {
         var46.printStackTrace();
         throw new Exception("FTDStockLedgerRptHLP.getStockLedgerDtl()->" + var46.getMessage());
      } finally {
         if (ws != null) {
            ws.close();
            ws = null;
         }

      }

      return brPagination.toString();
   }

   public String getConsolidatedStockLedgerRpt_OLD(FTDStockLedgerRptVO vo, HttpServletRequest request) throws Exception {
      String strTableWidth = "100%";
      StringBuffer br = new StringBuffer(1000);
      StringBuffer brPagination = new StringBuffer(3000);
      WebRowSet ws = null;
      String prevItemId = "";
      String prevItemName = "";
      String strFromDate = "";
      String strToDate = "";
      int nFromDay = 0;
      int nToDay = 0;
      int nFromMonth = 0;
      int nToMonth = 0;
      int nFromYear = 0;
      int nToYear = 0;
      int counter = 0;
      int sNo = 1;
      long nOpeningBalanceActive = 0L;
      long nOpeningBalanceQuar = 0L;
      long nOpeningBalanceRej = 0L;
      long nClosingBalanceActive = 0L;
      long nClosingBalanceQuar = 0L;
      long nClosingBalanceRej = 0L;
      long nIssueActive = 0L;
      long nIssueQuar = 0L;
      long nIssueRej = 0L;
      long nRecActive = 0L;
      long nRecQuar = 0L;
      long nRecRej = 0L;
      long nOpeningBalanceTotActive = 0L;
      long nOpeningBalanceTotQuar = 0L;
      long nOpeningBalanceTotRej = 0L;
      long nClosingBalanceTotActive = 0L;
      long nClosingBalanceTotQuar = 0L;
      long nClosingBalanceTotRej = 0L;
      long nIssueTotActive = 0L;
      long nIssueTotQuar = 0L;
      long nIssueTotRej = 0L;
      long nRecTotActive = 0L;
      long nRecTotQuar = 0L;
      long nRecTotRej = 0L;

      try {
         ws = vo.getWrsData();
         if (vo.getStrItemBrandId() != null && !vo.getStrItemBrandId().equals("0")) {
            if (ws != null && ws.size() > 0 && ws.next()) {
               vo.setStrDrugName(ws.getString(6));
            }

            ws.beforeFirst();
         } else {
            vo.setStrDrugName("All");
         }

         br.append("<HTML><HEAD><script language='Javascript' src='../../mms/js/stockledgerFTD_mmsrpt.js'></script><script language='JavaScript' src='../../hisglobal/jquery/3.6.0.min.js'></script><script language='Javascript' src='../../hisglobal/js/innerxhtml.js'></script><body><form action='/INVMGM/mms/reports/FTDStockLedgerRptCNT.cnt' method='post'><div id='consolidatedStockLedgerRptDivId'><table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0''> ");

         try {
            br.append("<td colspan='1' width='10%' align='center'><div  align='center'> <img  align='absmiddle' src='http://" + request.getServerName() + ":" + request.getServerPort() + " Voucher Report '/></div></td> ");
         } catch (Exception var70) {
            var70.printStackTrace();
         }

         br.append("</tr> ");
         br.append("</table> ");
         br.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0'> ");
         br.append("<tr><td width='10%' colspan='1'  align='right'><div  align='right'></div></td> ");
         br.append("<td width='80%' colspan='12' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
         br.append("Stock Ledger");
         br.append("</font></b></td><td colspan='1' width='10%'></td> ");
         br.append("</tr> ");
         br.append("<tr> ");
         br.append("<td width='10%' colspan='1' align='right'><div  align='right'></div></td> ");
         br.append("<td width='80%' colspan='12' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
         br.append("Store Name " + vo.getStrStoreName() + "<br>");
         br.append("Drug Name: " + vo.getStrDrugName() + "<br>");
         br.append("</font></b></td><td colspan='1' width='10%'> ");
         br.append("</td> ");
         br.append("</tr> ");
         br.append("<tr> ");
         br.append("<td width='10%' colspan='1' ></td> ");
         br.append("<td width='80%' colspan='12'  align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
         br.append("Between : " + vo.getStrFromDate() + " And " + vo.getStrToDate());
         br.append("</font></b></td><td colspan='1' width='10%'> ");
         br.append("</td> ");
         br.append("</tr> ");
         br.append("</table> ");
         br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
         br.append("<tr> ");
         br.append("<td align='right'>");
         br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'> <div id='printImg'>");
         br.append("<img style='cursor: pointer; ' title='Print Page'  ");
         br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printThis();' /> <img style='cursor: pointer; ' title='Save as Excel' src='../../hisglobal/images/excel1.png' onClick='generateXLS(event,\"consolidatedStockLedgerRptDivId\");' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
         br.append(" src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div>");
         br.append(" </td> ");
         br.append(" </tr> ");
         br.append(" </table> ");
         br.append("<table cellspacing='0' border='1' cellpadding='0' width='").append(strTableWidth).append("' align='center'> ");
         br.append("<tr bgcolor='#cdc9c9'> ");
         br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font></td>");
         br.append("<td style=\"text-align: center;\" colspan='1' width='35%'><font  size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font></td>");
         br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Opening Balance </b></font></td>");
         br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty </b></font></td>");
         br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty</b></font></td>");
         br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Closing Balance</b></font></td>");
         br.append("</tr>");
         strFromDate = vo.getStrFromDate();
         strToDate = vo.getStrToDate();
          nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
          nToDay = Integer.parseInt(strToDate.split("\\-")[0]);
          nFromMonth = this.getMonthInNumbers(strFromDate.split("\\-")[1]);
          nToMonth = this.getMonthInNumbers(strToDate.split("\\-")[1]);
          nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
          nToYear = Integer.parseInt(strToDate.split("\\-")[2]);
         if (ws != null && ws.size() > 0) {
            while(ws.next()) {
               if (!prevItemId.equals(ws.getString(4)) && counter > 0) {
                  nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
                  nClosingBalanceQuar = nOpeningBalanceQuar + nRecQuar - nIssueQuar;
                  nClosingBalanceRej = nOpeningBalanceRej + nRecRej - nIssueRej;
                  br.append("<tr>");
                  br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + sNo + "</font></td>");
                  br.append("<td style=\"text-align: left;\" colspan='1' width='30%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + prevItemName + "</font></td>");
                  br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nOpeningBalanceActive + "</font></td>");
                  br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nRecActive + "</font></td>");
                  br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nIssueActive + "</font></td>");
                  br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nClosingBalanceActive + "</font></td>");
                  br.append("</tr>");
                  nOpeningBalanceTotActive += nOpeningBalanceActive;
                  nOpeningBalanceTotQuar += nOpeningBalanceQuar;
                  nOpeningBalanceTotRej += nOpeningBalanceRej;
                  nClosingBalanceTotActive += nClosingBalanceActive;
                  nClosingBalanceTotQuar += nClosingBalanceQuar;
                  nClosingBalanceTotRej += nClosingBalanceRej;
                  nIssueTotActive += nIssueActive;
                  nIssueTotQuar += nIssueQuar;
                  nIssueTotRej += nIssueRej;
                  nRecTotActive += nRecActive;
                  nRecTotQuar += nRecQuar;
                  nRecTotRej += nRecRej;
                  nOpeningBalanceActive = 0L;
                  nOpeningBalanceQuar = 0L;
                  nOpeningBalanceRej = 0L;
                  nClosingBalanceActive = 0L;
                  nClosingBalanceQuar = 0L;
                  nClosingBalanceRej = 0L;
                  nIssueActive = 0L;
                  nIssueQuar = 0L;
                  nIssueRej = 0L;
                  nRecActive = 0L;
                  nRecQuar = 0L;
                  nRecRej = 0L;
                  ++sNo;
               }

               String[] tempArr;
               if (nFromMonth == Integer.parseInt(ws.getString(1)) && nFromYear == Integer.parseInt(ws.getString(2))) {
                  tempArr = this.getOpeningBalance(ws, nFromDay).split("\\^");
                  nOpeningBalanceActive += Long.parseLong(tempArr[0].split("\\.")[0]);
                  nOpeningBalanceQuar += Long.parseLong(tempArr[1].split("\\.")[0]);
                  nOpeningBalanceRej += Long.parseLong(tempArr[2].split("\\.")[0]);
               }

               tempArr = this.getReceivedAndIssuedQty(ws, nFromDay, nFromMonth, nFromYear, nToDay, nToMonth, nToYear).split("\\#");
               String[] tempArr1 = tempArr[0].split("\\^");
               nIssueActive += Long.parseLong(tempArr1[0].split("\\.")[0]);
               nIssueQuar += Long.parseLong(tempArr1[1].split("\\.")[0]);
               nIssueRej += Long.parseLong(tempArr1[2].split("\\.")[0]);
               tempArr1 = tempArr[1].split("\\^");
               nRecActive += Long.parseLong(tempArr1[0].split("\\.")[0]);
               nRecQuar += Long.parseLong(tempArr1[1].split("\\.")[0]);
               nRecRej += Long.parseLong(tempArr1[2].split("\\.")[0]);
               prevItemId = ws.getString(4);
               prevItemName = ws.getString(6);
               ws.getString(7);
               ++counter;
            }

            nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
            nClosingBalanceQuar = nOpeningBalanceQuar + nRecQuar - nIssueQuar;
            nClosingBalanceRej = nOpeningBalanceRej + nRecRej - nIssueRej;
            br.append("<tr>");
            br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + sNo + "</font></td>");
            br.append("<td style=\"text-align: left;\" colspan='1' width='30%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + prevItemName + "</font></td>");
            br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nOpeningBalanceActive + "</font></td>");
            br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nRecActive + "</font></td>");
            br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nIssueActive + "</font></td>");
            br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nClosingBalanceActive + "</font></td>");
            br.append("</tr>");
            br.append("<tr>");
            br.append("<td style=\"text-align: right;\" colspan='2' width='35%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Grand Total</b></font></td>");
            br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + nOpeningBalanceTotActive + "</b></font></td>");
            br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + nRecTotActive + "</b></font></td>");
            br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + nIssueTotActive + "</b></font></td>");
            br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + nClosingBalanceTotActive + "</b></font></td>");
            br.append("</tr>");
         } else {
            brPagination.append("<table width='95%' align='center' cellspacing='1px' cellpadding='1px'>");
            brPagination.append("<tr><td colspan='14' class='TITLE'>Stock Ledger</td></tr>");
            brPagination.append("<tr><td colspan='14' align='center'><Strong>No Data Found</Strong></td></tr>");
            brPagination.append("</table>");
         }

         br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
         br.append("<tr><td colspan='15'><hr></td></tr>");
         br.append("<tr> ");
         br.append("<td colspan='15' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >***End Of Report***</font></td> ");
         br.append("</tr> ");
         br.append("</table><input type='hidden' name='hmode'/><input type='hidden' name='strHtmlCode' value='' /></form></body></HEAD></HTML>");
      } catch (Exception var71) {
         throw var71;
      }

      return br.toString();
   }

   public String getConsolidatedStockLedgerRptBatch(FTDStockLedgerRptVO vo, HttpServletRequest request) throws Exception {
      StringBuffer br = new StringBuffer(1000);
      StringBuffer brPagination = new StringBuffer(3000);
      WebRowSet ws = null;
      String prevItemId = "";
      String prevItemName = "";
      String prevBatch = "";
      String prevExpiry = "";
      String strFromDate = "";
      String strToDate = "";
      String strCheckHidValue = "";
      int REC_PER_PAGE = 0;
      String strCssClass = "multiRPTControl";
      int nFromDay = 0;
      int nToDay = 0;
      int nFromMonth = 0;
      int nToMonth = 0;
      int nFromYear = 0;
      int nToYear = 0;
      int counter = 0;
      int pageCounter = 0;
      int pageSize = 0;
      int sNo = 1;
      long nOpeningBalanceActive = 0L;
      long nClosingBalanceActive = 0L;
      long nIssueActive = 0L;
      long nRecActive = 0L;
      long nOpeningBalanceTotActive = 0L;
      long nClosingBalanceTotActive = 0L;
      long nIssueTotActive = 0L;
      long nRecTotActive = 0L;
      long totIssueRecQty = 0L;
      String strTableWidth = "100%";
      String strStoreName = "";

      try {
         System.out.println("------------- FTDStockLedgerRptHLP.getConsolidatedStockLedgerRptBatch() --------------");
         ws = vo.getWrsData();
         br.append(this.getHeader(6).toString());
         strFromDate = vo.getStrFromDate();
         strToDate = vo.getStrToDate();
          nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
          nToDay = Integer.parseInt(strToDate.split("\\-")[0]);
         this.getMonthInNumbers(strFromDate.split("\\-")[1]);
         this.getMonthInNumbers(strToDate.split("\\-")[1]);
          nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
          nToYear = Integer.parseInt(strToDate.split("\\-")[2]);
         if (ws != null && ws.size() > 0) {
            if (ws.next()) {
               strStoreName = ws.getString(4);
            }

            ws.beforeFirst();

            while(ws.next()) {
               if ((!prevItemId.equals(ws.getString(3)) || !prevBatch.equals(ws.getString(6))) && counter > 0) {
                  if (sNo % 2 == 0) {
                     strCssClass = "";
                  } else {
                     strCssClass = "";
                  }

                  strCheckHidValue = prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
                  nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
                  br.append("<tr id='tr'>");
                  br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
                  br.append("<td class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");
                  br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='35%'>" + prevItemName + "</td>");
                  br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='8%'>" + prevBatch + "</td>");
                  br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='7%'>" + prevExpiry + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nOpeningBalanceActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nRecActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nIssueActive + "</td>");
                  br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='5%'>" + nClosingBalanceActive + "</td>");
                  totIssueRecQty = nRecActive + nIssueActive;
                  br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
                  br.append("</tr>");
                  
                  //nOpeningBalanceTotActive += nOpeningBalanceActive;
                  nOpeningBalanceTotActive = nOpeningBalanceActive;
                  nClosingBalanceTotActive += nClosingBalanceActive;
                  nIssueTotActive += nIssueActive;
                  nRecTotActive += nRecActive;
                  nOpeningBalanceActive = 0L;
                  nClosingBalanceActive = 0L;
                  nIssueActive = 0L;
                  nRecActive = 0L;
                  
                  ++pageCounter;
                  ++sNo;
               }
               
               /*
               1. Opeartion Date
               2. Store Id
               3. Brand Id
               4. Store Name
               5. Item name
               6. Batch_No
               7. Opening Balance
               8. Issue Qty
               9. Rec Qty
              10. Expiry date
              11. Rate
              12. Opening Balance Value
              13. Rec Value
              14. Issue Value
             */

               //nOpeningBalanceActive += Long.parseLong(ws.getString(7));
               nOpeningBalanceActive = Long.parseLong(ws.getString(7));
               nIssueActive += Long.parseLong(ws.getString(8));
               nRecActive += Long.parseLong(ws.getString(9));
               prevItemId = ws.getString(3);
               prevItemName = ws.getString(5);
               prevBatch = ws.getString(6);
               prevExpiry = ws.getString(10);
               ++counter;
            }

            if (sNo % 2 == 0) {
               strCssClass = "";
            } else {
               strCssClass = "";
            }

            strCheckHidValue = prevItemId + "^" + prevBatch + "^" + nOpeningBalanceActive + "^" + "0" + "^" + "0";
            nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
            br.append("<tr id='tr'>");
            br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue" + sNo + "' value='" + strCheckHidValue + "'>");
            br.append("<td class= " + strCssClass + " colspan='1' width='5%'>" + sNo + "</td>");
            br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='35%'>" + prevItemName + "</td>");
            br.append("<td style=\"text-align: left;\" class= " + strCssClass + " colspan='1' width='8%'>" + prevBatch + "</td>");
            br.append("<td style=\"text-align: center;\" class= " + strCssClass + " colspan='1' width='7%'>" + prevExpiry + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nOpeningBalanceActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nRecActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nIssueActive + "</td>");
            br.append("<td style=\"text-align: right;\" class= " + strCssClass + " colspan='1' width='10%'>" + nClosingBalanceActive + "</td>");
            totIssueRecQty = nRecActive + nIssueActive;
            br.append("<input type='hidden' name='totIssueRecQty' id='totIssueRecQty" + sNo + "' value='" + totIssueRecQty + "'>");
            br.append("</tr>");
            
            //nOpeningBalanceTotActive += nOpeningBalanceActive;
            nOpeningBalanceTotActive = nOpeningBalanceActive;
            nClosingBalanceTotActive += nClosingBalanceActive;
            nIssueTotActive += nIssueActive;
            nRecTotActive += nRecActive;
            
            br.append("<tr bgcolor='' id='tr'>");
            br.append("<td style=\"text-align: right;\"  colspan='4' width='35%'><b>Grand Total</b></td>");
            br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><b>" + nOpeningBalanceTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><b>" + nRecTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><b>" + nIssueTotActive + "</b></td>");
            br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><b>" + nClosingBalanceTotActive + "</b></td>");
            br.append("</tr>");
            brPagination.append("<HTML><HEAD><script language='Javascript' src='../../mms/js/stockledgerFTD_mmsrpt.js'></script><script language='JavaScript' src='../../hisglobal/jquery/3.6.0.min.js'></script><script language='Javascript' src='../../hisglobal/js/innerxhtml.js'></script><body><form action='/INVMGM/mms/reports/FTDStockLedgerRptCNT.cnt' method='post'><div id='consolidatedBatchWiseStockLedgerRptDivId'>");
            brPagination.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
            brPagination.append("<tr> ");
            brPagination.append("<td align='right'>");
            brPagination.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'> <div id='printImg'>");
            brPagination.append("<img style='cursor: pointer; ' title='Print Page'  ");
            brPagination.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printThis();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
            brPagination.append(" src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div>");
            brPagination.append(" </td> ");
            brPagination.append(" </tr> ");
            brPagination.append(" </table> ");
            brPagination.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0'> ");
            brPagination.append("<tr><td width='10%' colspan='1'  align='right'><div  align='right'></div></td> ");
            brPagination.append("<td width='80%' colspan='12' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
            brPagination.append("Stock Ledger ");
            brPagination.append("</font></b></td><td colspan='1' width='10%'></td> ");
            brPagination.append("</tr> ");
            brPagination.append("<tr> ");
            brPagination.append("<td width='10%' colspan='1'></td> ");
            brPagination.append("<td width='80%' colspan='12' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
            brPagination.append("Store Name : " + strStoreName + "<br>");
            brPagination.append("</font></b></td><td width='10%' colspan='1'> ");
            brPagination.append("</td> ");
            brPagination.append("</tr> ");
            brPagination.append("<tr> ");
            brPagination.append("<td width='10%' colspan='1' ></td> ");
            brPagination.append("<td width='80%' colspan='12' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
            brPagination.append("Between : " + vo.getStrFromDate() + " And " + vo.getStrToDate());
            brPagination.append("</font></b></td><td width='10%' colspan='1' > ");
            brPagination.append("</td> ");
            brPagination.append("</tr> ");
            brPagination.append("</table> ");
            brPagination.append("<table align='center' width='").append(strTableWidth).append("' border='1' cellspacing='0' cellpadding='0''> ");
            brPagination.append(br);
            brPagination.append("</table></div></HEAD></HTML>");
         } else {
            brPagination.append("<table width='95%' align='center' cellspacing='0px' cellpadding='1px' border='1'>");
            brPagination.append("<tr><td class='TITLE'>Stock Ledger</td></tr>");
            brPagination.append("<tr><td align='center'><Strong>No Data Found</Strong></td></tr>");
            brPagination.append("</table>");
         }
      } catch (Exception var49) {
         var49.printStackTrace();
         throw new Exception("FTDStockLedgerRptHLP.getConsolidatedStockLedgerRptBatch()->" + var49.getMessage());
      } finally {
         if (ws != null) {
            ws.close();
            ws = null;
         }

      }

      return brPagination.toString();
   }

   public String getConsolidatedStockLedgerRptBatch_OLD(FTDStockLedgerRptVO vo, HttpServletRequest request) throws Exception {
      StringBuffer br = new StringBuffer(1000);
      WebRowSet ws = null;
      String strTableWidth = "100%";
      String prevItemId = "";
      String prevItemName = "";
      String prevBatch = "";
      String prevExpiry = "";
      String strFromDate = "";
      String strToDate = "";
      int nFromDay = 0;
      int nToDay = 0;
      int nFromMonth = 0;
      int nToMonth = 0;
      int nFromYear = 0;
      int nToYear = 0;
      int counter = 0;
      int sNo = 1;
      long nOpeningBalanceActive = 0L;
      long nOpeningBalanceQuar = 0L;
      long nOpeningBalanceRej = 0L;
      long nClosingBalanceActive = 0L;
      long nClosingBalanceQuar = 0L;
      long nClosingBalanceRej = 0L;
      long nIssueActive = 0L;
      long nIssueQuar = 0L;
      long nIssueRej = 0L;
      long nRecActive = 0L;
      long nRecQuar = 0L;
      long nRecRej = 0L;
      long nOpeningBalanceTotActive = 0L;
      long nOpeningBalanceTotQuar = 0L;
      long nOpeningBalanceTotRej = 0L;
      long nClosingBalanceTotActive = 0L;
      long nClosingBalanceTotQuar = 0L;
      long nClosingBalanceTotRej = 0L;
      long nIssueTotActive = 0L;
      long nIssueTotQuar = 0L;
      long nIssueTotRej = 0L;
      long nRecTotActive = 0L;
      long nRecTotQuar = 0L;
      long nRecTotRej = 0L;
      String strStoreName = "";
      String strDrugName = "";
      String strExpiryDate = "";
      String strBatchNo = "";

      try {
         ws = vo.getWrsData();
         if (sNo == 1 && ws != null && ws.size() > 0) {
            if (ws.next()) {
               strStoreName = ws.getString(5);
               strDrugName = ws.getString(6);
               strBatchNo = ws.getString(7);
               strExpiryDate = ws.getString(10);
            }

            ws.beforeFirst();
         }

         if (vo.getStrItemBrandId() == null || vo.getStrItemBrandId().equals("0")) {
            vo.setStrDrugName("All");
         }

         br.append("<HTML><HEAD><script language='Javascript' src='../../mms/js/stockledgerFTD_mmsrpt.js'></script><script language='JavaScript' src='../../hisglobal/jquery/3.6.0.min.js'></script><script language='Javascript' src='../../hisglobal/js/innerxhtml.js'></script><body><form action='/INVMGM/mms/reports/FTDStockLedgerRptCNT.cnt' method='post'><div id='consolidatedBatchWiseStockLedgerRptDivId'><table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0''> ");

         try {
            br.append("<td colspan='1' width='10%' align='center'><div  align='center'> <img  align='absmiddle' src='http://" + request.getServerName() + ":" + request.getServerPort() + " Voucher Report'/></div></td>");
         } catch (Exception var79) {
            var79.printStackTrace();
         }

         br.append("</tr> ");
         br.append("</table> ");
         br.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0'> ");
         br.append("<tr><td width='10%' colspan='1'  align='right'><div  align='right'></div></td> ");
         br.append("<td width='80%' colspan='12' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
         br.append("Stock Ledger ");
         br.append("</font></b></td><td colspan='1' width='10%'></td> ");
         br.append("</tr> ");
         br.append("<tr> ");
         br.append("<td width='10%' colspan='1' ></td> ");
         br.append("<td width='80%' colspan='12'  align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
         br.append("Store Name: " + strStoreName + "<br>");
         br.append("Drug  Name: " + strDrugName + "<br>");
         br.append("</font></b></td><td width='10%' colspan='1' > ");
         br.append("</td> ");
         br.append("</tr> ");
         if (!vo.getStrItemBrandId().equals("0")) {
            br.append("<tr> ");
            br.append("<td width='10%' colspan='1' ></td> ");
            br.append("<td width='80%' colspan='12' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
            br.append("Batch No : " + strBatchNo + "<br>");
            br.append("Expiry Date : " + strExpiryDate + "<br>");
            br.append("</font></b></td><td width='10%' colspan='1' > ");
            br.append("</td> ");
            br.append("</tr> ");
         }

         br.append("<tr> ");
         br.append("<td width='10%' colspan='1' ></td> ");
         br.append("<td width='80%' colspan='12' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
         br.append("Between : " + vo.getStrFromDate() + " And " + vo.getStrToDate());
         br.append("</font></b></td><td width='10%' colspan='1' > ");
         br.append("</td> ");
         br.append("</tr> ");
         br.append("</table> ");
         br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
         br.append("<tr> ");
         br.append("<td align='right'>");
         br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'> <div id='printImg'>");
         br.append("<img style='cursor: pointer; ' title='Print Page'  ");
         br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printThis();' /> <img style='cursor: pointer; ' title='Save as Excel' src='../../hisglobal/images/excel1.png' onClick='generateXLS(event,\"consolidatedBatchWiseStockLedgerRptDivId\");' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
         br.append(" src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div>");
         br.append(" </td> ");
         br.append(" </tr> ");
         br.append(" </table> ");
         br.append("<table cellspacing='0' border='1' cellpadding='0' width='").append(strTableWidth).append("' align='center'> ");
         br.append("<tr bgcolor='#cdc9c9'> ");
         br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font></td>");
         br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font></td>");
         br.append("<td style=\"text-align: center;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No</b></font></td>");
         br.append("<td style=\"text-align: center;\" style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font></td>");
         br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Opening Balance</b></font></td>");
         br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty </b></font></td>");
         br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty</b></font></td>");
         br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Closing Balance</b></font></td>");
         br.append("</tr>");
         strFromDate = vo.getStrFromDate();
         strToDate = vo.getStrToDate();
          nFromDay = Integer.parseInt(strFromDate.split("\\-")[0]);
          nToDay = Integer.parseInt(strToDate.split("\\-")[0]);
          nFromMonth = this.getMonthInNumbers(strFromDate.split("\\-")[1]);
          nToMonth = this.getMonthInNumbers(strToDate.split("\\-")[1]);
          nFromYear = Integer.parseInt(strFromDate.split("\\-")[2]);
          nToYear = Integer.parseInt(strToDate.split("\\-")[2]);
         if (ws != null && ws.size() > 0) {
            while(true) {
               if (!ws.next()) {
                  nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
                  nClosingBalanceQuar = nOpeningBalanceQuar + nRecQuar - nIssueQuar;
                  nClosingBalanceRej = nOpeningBalanceRej + nRecRej - nIssueRej;
                  br.append("<tr> ");
                  br.append("<td colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + sNo + "</font></td>");
                  br.append("<td style=\"text-align: left;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + prevItemName + "</font></td>");
                  br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + prevBatch + "</font></td>");
                  br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + prevExpiry + "</font></td>");
                  br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nOpeningBalanceActive + "</font></td>");
                  br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nRecActive + "</font></td>");
                  br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nIssueActive + "</font></td>");
                  br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nClosingBalanceActive + "</font></td>");
                  br.append("</tr>");
                  nOpeningBalanceTotActive += nOpeningBalanceActive;
                  long var10000 = nOpeningBalanceTotQuar + nOpeningBalanceQuar;
                  var10000 = nOpeningBalanceTotRej + nOpeningBalanceRej;
                  nClosingBalanceTotActive += nClosingBalanceActive;
                  var10000 = nClosingBalanceTotQuar + nClosingBalanceQuar;
                  var10000 = nClosingBalanceTotRej + nClosingBalanceRej;
                  nIssueTotActive += nIssueActive;
                  var10000 = nIssueTotQuar + nIssueQuar;
                  var10000 = nIssueTotRej + nIssueRej;
                  nRecTotActive += nRecActive;
                  var10000 = nRecTotQuar + nRecQuar;
                  var10000 = nRecTotRej + nRecRej;
                  br.append("<tr bgcolor='#cdc9c9'> ");
                  br.append("<td style=\"text-align: right;\" colspan='4' width='35%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b> Grand Total</b></font></td>");
                  br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + nOpeningBalanceTotActive + "</b></font></td>");
                  br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + nRecTotActive + "</b></font></td>");
                  br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + nIssueTotActive + "</b></font></td>");
                  br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + nClosingBalanceTotActive + "</b></font></td>");
                  br.append("</tr>");
                  break;
               }

               if ((!prevItemId.equals(ws.getString(4)) || !prevBatch.equals(ws.getString(7))) && counter > 0) {
                  nClosingBalanceActive = nOpeningBalanceActive + nRecActive - nIssueActive;
                  nClosingBalanceQuar = nOpeningBalanceQuar + nRecQuar - nIssueQuar;
                  nClosingBalanceRej = nOpeningBalanceRej + nRecRej - nIssueRej;
                  br.append("<tr> ");
                  br.append("<td colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + sNo + "</b></font></td>");
                  br.append("<td style=\"text-align: left;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + prevItemName + "</font></td>");
                  br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + prevBatch + "</font></td>");
                  br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + prevExpiry + "</font></td>");
                  br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nOpeningBalanceActive + "</font></td>");
                  br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nRecActive + "</font></td>");
                  br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nIssueActive + "</font></td>");
                  br.append("<td style=\"text-align: right;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nClosingBalanceActive + "</font></td>");
                  br.append("</tr>");
                  nOpeningBalanceTotActive += nOpeningBalanceActive;
                  nOpeningBalanceTotQuar += nOpeningBalanceQuar;
                  nOpeningBalanceTotRej += nOpeningBalanceRej;
                  nClosingBalanceTotActive += nClosingBalanceActive;
                  nClosingBalanceTotQuar += nClosingBalanceQuar;
                  nClosingBalanceTotRej += nClosingBalanceRej;
                  nIssueTotActive += nIssueActive;
                  nIssueTotQuar += nIssueQuar;
                  nIssueTotRej += nIssueRej;
                  nRecTotActive += nRecActive;
                  nRecTotQuar += nRecQuar;
                  nRecTotRej += nRecRej;
                  nOpeningBalanceActive = 0L;
                  nOpeningBalanceQuar = 0L;
                  nOpeningBalanceRej = 0L;
                  nClosingBalanceActive = 0L;
                  nClosingBalanceQuar = 0L;
                  nClosingBalanceRej = 0L;
                  nIssueActive = 0L;
                  nIssueQuar = 0L;
                  nIssueRej = 0L;
                  nRecActive = 0L;
                  nRecQuar = 0L;
                  nRecRej = 0L;
                  ++sNo;
               }

               String[] tempArr;
               if (nFromMonth == Integer.parseInt(ws.getString(1)) && nFromYear == Integer.parseInt(ws.getString(2))) {
                  tempArr = this.getOpeningBalance(ws, nFromDay).split("\\^");
                  nOpeningBalanceActive += Long.parseLong(tempArr[0].split("\\.")[0]);
                  nOpeningBalanceQuar += Long.parseLong(tempArr[1].split("\\.")[0]);
                  nOpeningBalanceRej += Long.parseLong(tempArr[2].split("\\.")[0]);
               }

               tempArr = this.getReceivedAndIssuedQty(ws, nFromDay, nFromMonth, nFromYear, nToDay, nToMonth, nToYear).split("\\#");
               String[] tempArr1 = tempArr[0].split("\\^");
               nIssueActive += Long.parseLong(tempArr1[0].split("\\.")[0]);
               nIssueQuar += Long.parseLong(tempArr1[1].split("\\.")[0]);
               nIssueRej += Long.parseLong(tempArr1[2].split("\\.")[0]);
               tempArr1 = tempArr[1].split("\\^");
               nRecActive += Long.parseLong(tempArr1[0].split("\\.")[0]);
               nRecQuar += Long.parseLong(tempArr1[1].split("\\.")[0]);
               nRecRej += Long.parseLong(tempArr1[2].split("\\.")[0]);
               prevItemId = ws.getString(4);
               prevItemName = ws.getString(6);
               prevBatch = ws.getString(7);
               prevExpiry = ws.getString(10);
               ++counter;
            }
         } else {
            br.append("<table width='95%' align='center' cellspacing='1px' cellpadding='1px'>");
            br.append("<tr><td class='TITLE'> Stock Ledger</td></tr>");
            br.append("<tr><td align='center'><Strong>No Data Found</Strong></td></tr>");
            br.append("</table>");
         }

         br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
         br.append("<tr><td colspan='15'><hr></td></tr>");
         br.append("<tr> ");
         br.append("<td colspan='15' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >***End Of Report***</font></td> ");
         br.append("</tr> ");
         br.append("</table><input type='hidden' name='hmode'/><input type='hidden' name='strHtmlCode' value='' /></form></body></HEAD></HTML>");
      } catch (Exception var80) {
         var80.printStackTrace();
         throw new Exception("FTDStockLedgerRptHLP.getStockLedgerDtl()->" + var80.getMessage());
      } finally {
         if (ws != null) {
            ws.close();
            ws = null;
         }

      }

      return br.toString();
   }

   public String getDetailedStockLedgerRpt(FTDStockLedgerRptVO vo, HttpServletRequest request) throws Exception {
      StringBuffer br = new StringBuffer(1000);
      String strStoreName = "";
      String strDrugName = "";
      String strExpiryDate = "";
      String strTableWidth = "100%";
      int sNo = 1;
      int nColspan = 0;
      long nRecQty = 0L;
      long nIssueQty = 0L;
      long nBalanceActiveQty = 0L;
      long nBalanceQuarQty = 0L;
      long nBalanceRejQty = 0L;
      long nBalanceQty = 0L;
      double rate = 0.0D;
      WebRowSet ws = null;
      String col = "10";
      String strRecString = "";
      String strIssueString = "";

      try {
         String[] tempArr = vo.getStrOpeningBalance().split("\\#");
         nBalanceActiveQty = Long.parseLong(tempArr[0].split("\\.")[0]);
         nBalanceQuarQty = Long.parseLong(tempArr[1].split("\\.")[0]);
         nBalanceRejQty = Long.parseLong(tempArr[2].split("\\.")[0]);
         ws = vo.getWrsData();
         if (sNo == 1 && ws != null && ws.size() > 0 && ws.next()) {
            strStoreName = ws.getString(9);
            strDrugName = ws.getString(10);
            strExpiryDate = ws.getString(12);
            rate = Double.parseDouble(ws.getString(13));
            ws.beforeFirst();
         }

         if (vo.getStrItemBrandId() == null || vo.getStrItemBrandId().equals("0")) {
            vo.setStrDrugName("All");
         }

         if (!vo.getStrBatchFlag().equals("0")) {
            col = "6";
         }

         br.append("<HTML><HEAD><script language='Javascript' src='../../mms/js/stockledgerFTD_mmsrpt.js'></script><script language='JavaScript' src='../../hisglobal/jquery/3.6.0.min.js'></script><script language='Javascript' src='../../hisglobal/js/innerxhtml.js'></script><body><form action='/INVMGM/mms/reports/FTDStockLedgerRptCNT.cnt' method='post'><div id='detailedStockLedgerRptDivId'><table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0''> ");

         try {
            br.append("<tr><td colspan='" + col + "' width='100%'  align='center'><div  align='center'> <img  align='absmiddle' src='http://" + request.getServerName() + ":" + request.getServerPort() + " Voucher Report'/></div></td> ");
         } catch (Exception var34) {
            var34.printStackTrace();
         }

         br.append("</tr> ");
         br.append("</table> ");
         br.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0'> ");
         br.append("<tr><td width='10%' colspan='1'  align='right'><div  align='right'></div></td> ");
         br.append("<td width='80%' colspan='" + col + "' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
         br.append(" Stock Ledger ");
         br.append("</font></b></td><td colspan='1' width='10%'></td> ");
         br.append("</tr> ");
         br.append("<tr> ");
         br.append("<td width='10%' colspan='1'></td> ");
         br.append("<td width='80%' colspan='" + col + "' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
         br.append("Store Name : " + strStoreName + "<br>");
         br.append("Drug Name : " + strDrugName + "<br>");
         br.append("</font></b></td><td width='10%' colspan='1'> ");
         br.append("</td> ");
         br.append("</tr> ");
         if (!vo.getStrBatchNo().equals("0")) {
            br.append("<tr> ");
            br.append("<td width='10%' colspan='1'></td> ");
            br.append("<td width='80%' colspan='" + col + "' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
            br.append("Batch No : " + vo.getStrBatchNo() + "<br>");
            br.append("Expiry Date: " + strExpiryDate + "<br>");
            br.append("</font></b></td><td width='10%' colspan='1'> ");
            br.append("</td> ");
            br.append("</tr> ");
         }

         br.append("<tr> ");
         br.append("<td width='10%' colspan='1'></td> ");
         br.append("<td width='80%' colspan='" + col + "'align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
         br.append("Between : " + vo.getStrFromDate() + " And  " + vo.getStrToDate());
         br.append("</font></b></td><td width='10%' colspan='1'> ");
         br.append("</td> ");
         br.append("</tr> ");
         br.append("</table> ");
         br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
         br.append("<tr> ");
         br.append("<td align='right'>");
         br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'> <div id='printImg'>");
         br.append("<img style='cursor: pointer; ' title='Print Page'  ");
         br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printThis();' /> <img style='cursor: pointer; ' title='Save as Excel' src='../../hisglobal/images/excel1.png' onClick='generateXLS(event,\"detailedStockLedgerRptDivId\");' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
         br.append(" src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div>");
         br.append(" </td> ");
         br.append(" </tr> ");
         br.append(" </table> ");
         br.append("<table cellspacing='0' border='1' cellpadding='0' width='").append(strTableWidth).append("' align='center'> ");
        // byte nColspan;
         if (vo.getStrBatchNo().equals("0")) {
            br.append("<tr bgcolor='#cdc9c9'> ");
            br.append("<td colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font></td>");
            br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Date</b></font></td>");
            br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No</b></font></td>");
            br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font></td>");
            br.append("<td colspan='1' width='25%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Particulars</b></font></td>");
            br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty</b></font></td>");
            br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b> Issued Qty</b></font></td>");
            br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Balance</b></font></td>");
            br.append("</tr>");
            nColspan = 10;
         } else {
            br.append("<tr bgcolor='#cdc9c9'> ");
            br.append("<td colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font></td>");
            br.append("<td colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Date</b></font></td>");
            br.append("<td colspan='1' width='35%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Particulars</b></font></td>");
            br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty</b></font></td>");
            br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty</b></font></td>");
            br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Balance</b></font></td>");
            br.append("</tr>");
            br.append("<tr bgcolor='#cdc9c9'> ");
            br.append("<td colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
            br.append("<td colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
            br.append("<td colspan='1' width='35%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
            br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
            br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
            br.append("<td colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b> Ready For Issue </b></font></td>");
            br.append("</tr>");
            nColspan = 8;
         }

         if (vo.getStrBatchNo().equals("0")) {
            br.append("<tr>");
            br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + sNo + "</font></b></td>");
            br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + vo.getStrFromDate() + "</font></b></td>");
            br.append("<td style=\"text-align: left;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>--</font></b></td>");
            br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>--</font></b></td>");
            br.append("<td style=\"text-align: left;\"  colspan='1' width='25%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b> Opening Balance </font></b></td>");
            br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>--</font></b></td>");
            br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>--</font></b></td>");
            br.append("<td style=\"text-align: right;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + nBalanceActiveQty + "</font></b></td>");
            br.append("</tr>");
         } else {
            br.append("<tr>");
            br.append("<td style=\"text-align: center;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + sNo + "</font></b></td>");
            br.append("<td style=\"text-align: center;\"  colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + vo.getStrFromDate() + "</font></b></td>");
            br.append("<td style=\"text-align: left;\"  colspan='1' width='35%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b> Opening Balance</font></b></td>");
            br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>--</font></b></td>");
            br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>--</font></b></td>");
            br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + nBalanceActiveQty + "</font></b></td>");
            br.append("</tr>");
         }

         sNo = sNo + 1;
         if (ws != null && ws.size() > 0) {
            for(; ws.next(); ++sNo) {
               nRecQty = Long.parseLong(ws.getString(6)) + Long.parseLong(ws.getString(7)) + Long.parseLong(ws.getString(8));
               nIssueQty = Long.parseLong(ws.getString(3)) + Long.parseLong(ws.getString(4)) + Long.parseLong(ws.getString(5));
               if (nRecQty > 0L) {
                  Long.parseLong(ws.getString(6));
               } else {
                  strRecString = "";
               }

               if (nIssueQty > 0L) {
                  Long.parseLong(ws.getString(3));
               } else {
                  strIssueString = "";
               }

               nBalanceActiveQty = nBalanceActiveQty + Long.parseLong(ws.getString(6)) - Long.parseLong(ws.getString(3));
               nBalanceQuarQty = nBalanceQuarQty + Long.parseLong(ws.getString(8)) - Long.parseLong(ws.getString(5));
               nBalanceRejQty = nBalanceRejQty + Long.parseLong(ws.getString(7)) - Long.parseLong(ws.getString(4));
               nBalanceQty = nBalanceActiveQty + nBalanceQuarQty + nBalanceRejQty;
               br.append("<tr>");
               br.append("<td  style=\"text-align: center;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + sNo + "</font></td>");
               if (vo.getStrBatchNo().equals("0")) {
                  br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(1) + "</font></td>");
                  br.append("<td style=\"text-align: left;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(11) + "</font></td>");
                  br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(12) + "</font></td>");
                  br.append("<td style=\"text-align: left;\"  colspan='1' width='25%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(2) + "</font></td>");
                  br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nRecQty + strRecString + "</font></td>");
                  br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nIssueQty + strIssueString + "</font></td>");
                  br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nBalanceActiveQty + "</font></td>");
               } else {
                  br.append("<td style=\"text-align: center;\"  colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(1) + "</font></td>");
                  br.append("<td style=\"text-align: left;\"  colspan='1' width='35%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(2) + "</font></td>");
                  br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nRecQty + strRecString + "</font></td>");
                  br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nIssueQty + strIssueString + "</font></td>");
                  br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + nBalanceActiveQty + "</font></td>");
               }

               br.append("</tr>");
               if (sNo == 2) {
                  strStoreName = ws.getString(9);
                  strDrugName = ws.getString(10);
                  strExpiryDate = ws.getString(12);
               }
            }

            br.append("<tr>");
            br.append("<td  style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + sNo + "</font></b></td>");
            if (vo.getStrBatchNo().equals("0")) {
               br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + vo.getStrToDate() + "</font></b></td>");
               br.append("<td style=\"text-align: left;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>--</font></b></td>");
               br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>--</font></b></td>");
               br.append("<td style=\"text-align: left;\"  colspan='1' width='25%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b> Closing Balance</font></b></td>");
               br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + nRecQty + "</font></b></td>");
               br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + nIssueQty + "</font></b></td>");
               br.append("<td style=\"text-align: right;\"  colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + nBalanceActiveQty + "</font></b></td>");
            } else {
               br.append("<td style=\"text-align: center;\"  colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + vo.getStrToDate() + "</font></b></td>");
               br.append("<td style=\"text-align: left;\"  colspan='1' width='35%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Closing Balance</font></b></td>");
               br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + nRecQty + "</font></b></td>");
               br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + nIssueQty + "</font></b></td>");
               br.append("<td style=\"text-align: right;\"  colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + nBalanceActiveQty + "</font></b></td>");
            }

            br.append("</tr>");
            br.append("<tr><td colspan='" + nColspan + "' class='TITLE'></td></tr>");
         }

         br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
         br.append("<tr><td colspan='15'><hr></td></tr>");
         br.append("<tr> ");
         br.append("<td colspan='12' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >***End Of Report***</font></td> ");
         br.append("</tr> ");
         br.append("<tr>");
         br.append("<td><font size='2' color='BLUE'>");
         br.append("</td>");
         br.append("</tr>");
         br.append("</table><input type='hidden' name='hmode'/><input type='hidden' name='strHtmlCode' value='' /></form></body></HEAD></HTML>");
      } catch (Exception var35) {
         var35.printStackTrace();
         throw new Exception("FTDStockLedgerRptHLP.getDetailedStockLedgerDtl()->" + var35.getMessage());
      } finally {
         if (ws != null) {
            ws.close();
            ws = null;
         }

      }

      return br.toString();
   }
}