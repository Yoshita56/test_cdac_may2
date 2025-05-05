package mms.transactions.controller.hlp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.HisUtil;
import mms.transactions.controller.fb.GiftedItemDetailsTransFB;
import mms.transactions.vo.GiftedItemDetailsTransVO;

public class GiftedItemDetailsTransHLP {

	private static final String strColor = "red";
	private static final String defaultColor = "blue";
	
		
	
	public static String getGiftedItemsList_NEW(GiftedItemDetailsTransFB formBean) {

		StringBuffer sb = null;

		int i=0,j=1;

		WebRowSet ws = formBean.getWsGiftedItemList();
		String strHiddenValue = "";

		try {

			sb = new StringBuffer("");

			if (ws != null && ws.size() > 0) 
			{

				
				sb.append("<div class='row rowFLex reFlex'>");
			
				sb.append("<div class='subHeaders mb-0 mt-3' style='font-weight: 600;font-size:18px;text-align: left' colspan='10'>&nbsp;Gifted Item Details</div>");
				
				sb.append("<table class='table'>");
				sb.append("<thead class='thead-dark' align='center'>");
				sb.append("<tr> ");
				sb.append("<th  width='10%' style='font-weight:350 !important ;font-size: 16px !important;'>#");
				sb.append("</th> ");
				sb.append("<th  width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Transaction No. ");
				sb.append("</th> ");
				sb.append("<th  width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Gifted Date ");
				sb.append("</th> ");
				sb.append("<th  width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Gifted By ");
				sb.append("</th> ");
				sb.append("<th  width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Item Name ");
				sb.append("</th> ");
				sb.append("<th  width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Qty ");
				sb.append("</th> ");
				sb.append("<thead>");
				sb.append("</tr>  ");
				// sb.append("</table> ");

					while(ws.next())
					{	

						    /*
						     * 1.Gifted No
						     * 2.Gifted Date
						     * 3.Gifted By
						     * 4.Item Name
						     * 5.Gifted Qty
						     * 
						     * 
						     * */
							strHiddenValue = ws.getString(1) + "^" + ws.getString(2) + "^" + ws.getString(3)
									+ "^" + ws.getString(5) + "^" + ws.getString(4);
							sb.append("<tr> ");
							
							sb.append("<td width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' id='check" + i
									+ "'><input class='' type='radio' title='Print Debit Note' name='strdebitNote' value='"
									+ strHiddenValue + "' id='strdebitNote' onclick='onSelectRadioButton(\""
									+ strHiddenValue + "\",\"" + i + "\");'></td>");
									
							//sb.append("<td class='' width='5%'>").append(j);
							//sb.append("</td> ");

							sb.append("<td class='' align='center' style='font-weight:350 !important ;font-size: 16px !important;' width='15%'>").append(ws.getString(1));
							sb.append("</td> ");
							sb.append("<td class='' align='center' style='font-weight:350 !important ;font-size: 16px !important;' width='15%'>").append(ws.getString(2));
							sb.append("</td> ");
							sb.append("<td class='' align='left' style='font-weight:350 !important ;font-size: 16px !important;' width='20%'>").append(ws.getString(3));
							sb.append("</td> ");
							sb.append("<td class='' align='left' style='font-weight:350 !important ;font-size: 16px !important;' width='20%'>").append(ws.getString(4));
							sb.append("</td> ");
							sb.append("<td class='' align='center' style='font-weight:350 !important ;font-size: 16px !important;' width='20%'>").append(ws.getString(5));
							sb.append("</td> ");
							sb.append("</tr> ");
							
							i++;
							j++;
						
				}

			} else {
				sb.append("<div class='subHeaders mb-0 mt-3' style='font-weight: 600;font-size:18px;text-align: left' colspan='10'>&nbsp;Gifted Item Details</div>");
				
				sb.append("<table class='table'>");
				sb.append("<thead class='thead-dark' align='center'>");
				sb.append("<tr> ");
				sb.append("<th  width='5%' style='font-weight:350 !important ;font-size: 16px !important;'>#");
				sb.append("</th> ");
				sb.append("<th  width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Transaction No. ");
				sb.append("</th> ");
				sb.append("<th  width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Gifted Date ");
				sb.append("</th> ");
				sb.append("<th  width='25%' style='font-weight:350 !important ;font-size: 16px !important;'>Gifted By ");
				sb.append("</th> ");
				sb.append("<th  width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Item Name ");
				sb.append("</th> ");
				sb.append("<th  width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Qty ");
				sb.append("</th> ");
				sb.append("<thead>");
				sb.append("</tr>  ");

				sb.append("<tr><td align='center' colspan='6' style='font-weight:350 !important ;font-size: 16px !important;'><font color='red'>No Matching Record Found</font></td></tr>");
				sb.append("</table>");
				sb.append("</div>");
			}

		} catch (Exception e) {

		}

		return sb.toString();

	}

	public static String getGiftedItemsList_OLD(GiftedItemDetailsTransFB formBean) {

		StringBuffer sb = null;

		final int LMIT_VAL = 10;

		WebRowSet ws = formBean.getWsGiftedItemList();

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

				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td class='TITLE' colspan='5'>&nbsp;Gifted Item Details");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("<tr>");
				sb.append("<td class='LABEL' colspan='5'>&nbsp;");
				for (int i = 1; i <= totalLayer; i++) {

					if (i == 1) {
						sb.append("<a STYLE='CURSOR:POINTER; color:" + strColor + "' name='linId' id='linId" + i
								+ "' onClick='layerIndexNavigator(\"" + i + "\",\"" + totalLayer + "\")'>" + i
								+ "</a> &nbsp;");
					} else {
						sb.append("<a STYLE='CURSOR:POINTER; color:" + defaultColor + "' name='linId' id='linId" + i
								+ "' onClick='layerIndexNavigator(\"" + i + "\",\"" + totalLayer + "\")'>" + i
								+ "</a> &nbsp;");
					}
				}
				sb.append("</td>");
				sb.append("</tr>");

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

				for (int i = 1; i <= totalLayer; i++) {

					if (i != totalLayer && totalLayer != 1) {
						if (i == 1) {
							sb.append("<div id='tariffDivId" + i + "' style='display:block'>");
						} else {
							sb.append("<div id='tariffDivId" + i + "' style='display:none'>");
						}
						sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
						for (int j = 0; j < LMIT_VAL; j++) {
							ws.next();

							sb.append("<tr> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(1));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(2));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(5));
							sb.append("</td> ");
							sb.append("</tr> ");
						}
						sb.append("</table>");
						sb.append("</div>");

					} else {
						if (i == 1) {
							sb.append("<div id='tariffDivId" + i + "' style='display:block'>");
						} else {
							sb.append("<div id='tariffDivId" + i + "' style='display:none'>");
						}

						sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
						for (int k = 0; k < reminder; k++) {
							ws.next();
							sb.append("<tr> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(1));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(2));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
							sb.append("</td> ");
							sb.append("<td class='multiControl' width='20%'>").append(ws.getString(5));
							sb.append("</td> ");
							sb.append("</tr> ");

						}
						sb.append("</table>");
						sb.append("</div>");

					}

				}

			} else {
				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td class='TITLE' colspan='5'>&nbsp;Gifted Item Details");
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
				sb.append(
						"<tr><td class='multiControl' colspan='5' ><font color='red'>No Matching Record Found</font></td></tr>");
				sb.append("</table>");
			}

		} catch (Exception e) {

		}

		return sb.toString();

	}

	public static String getGiftedItemsListNEW(GiftedItemDetailsTransFB formBean) {

		StringBuffer sb = null;

		final int LMIT_VAL = 10;

		WebRowSet ws = formBean.getWsGiftedItemList();

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

				sb.append("<div class='row rowFLex reFlex'>");
				sb.append("<table class='table table-striped' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append(
						"<td class='font-weight-bold' colspan='10' style='text-align: left;'>&nbsp;Gifted Item Details");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("<tr>");
				sb.append("<td class='LABEL' colspan='10'>&nbsp;");
				for (int i = 1; i <= totalLayer; i++) {

					if (i == 1) {
						sb.append("<a STYLE='CURSOR:POINTER; color:" + strColor + "' name='linId' id='linId" + i
								+ "' onClick='layerIndexNavigator(\"" + i + "\",\"" + totalLayer + "\")'>" + i
								+ "</a> &nbsp;");
					} else {
						sb.append("<a STYLE='CURSOR:POINTER; color:" + defaultColor + "' name='linId' id='linId" + i
								+ "' onClick='layerIndexNavigator(\"" + i + "\",\"" + totalLayer + "\")'>" + i
								+ "</a> &nbsp;");
					}
				}
				sb.append("</td>");
				sb.append("</tr>");

				sb.append("<tr> ");

				sb.append("<td class='font-weight-bold' width='5%'>#");

				sb.append("<td class='font-weight-bold' width='15%'>Transaction No. ");
				sb.append("</td> ");
				sb.append("<td class='font-weight-bold' width='15%'>Gifted Date ");
				sb.append("</td> ");
				sb.append("<td class='font-weight-bold' width='25%'>Gifted By ");
				sb.append("</td> ");
				sb.append("<td class='font-weight-bold' width='20%'>Supplied By ");
				sb.append("</td> ");
				sb.append("<td class='font-weight-bold' width='20%'>PO No. ");
				sb.append("</td> ");
				sb.append("</tr>  ");
				// sb.append("</table> ");

				for (int i = 1; i <= totalLayer; i++) {

					if (i != totalLayer && totalLayer != 1) {
						if (i == 1) {
							sb.append("<div id='tariffDivId" + i + "' style='display:block'>");
						} else {
							sb.append("<div id='tariffDivId" + i + "' style='display:none'>");
						}
						// sb.append("<table class='table table-striped' align='center'
						// cellpadding='1px' cellspacing='1px'> ");
						for (int j = 0; j < LMIT_VAL; j++) {
							ws.next();

							String strHiddenValue = ws.getString(1) + "^" + ws.getString(2) + "^" + ws.getString(3)
									+ "^" + ws.getString(5) + "^" + ws.getString(4);
							sb.append("<tr> ");
							sb.append("<td width='5%' id='check" + i
									+ "'><input class='form-control' type='radio' title='Print Debit Note' name='strdebitNote' value='"
									+ strHiddenValue + "' id='strdebitNote' onclick='onSelectRadioButton(\""
									+ strHiddenValue + "\",\"" + i + "\");'></td>");

							sb.append("<td class='' width='15%'>").append(ws.getString(1));
							sb.append("</td> ");
							sb.append("<td class='' width='15%'>").append(ws.getString(2));
							sb.append("</td> ");
							sb.append("<td class='' width='25%'>").append(ws.getString(3));
							sb.append("</td> ");
							sb.append("<td class='' width='20%'>").append(ws.getString(5));
							sb.append("</td> ");
							sb.append("<td class='' width='20%'>").append(ws.getString(4));
							sb.append("</td> ");
							sb.append("</tr> ");
						}
						// sb.append("</table>");
						sb.append("</div>");

					} else {
						if (i == 1) {
							sb.append("<div id='tariffDivId" + i + "' style='display:block'>");
						} else {
							sb.append("<div id='tariffDivId" + i + "' style='display:none'>");
						}

						// sb.append("<table class='table table-striped' align='center'
						// cellpadding='1px' cellspacing='1px'> ");
						for (int k = 0; k < reminder; k++) {
							ws.next();
							String strHiddenValue = ws.getString(1) + "^" + ws.getString(2) + "^" + ws.getString(3)
									+ "^" + ws.getString(5) + "^" + ws.getString(4);
							sb.append("<tr> ");
							sb.append("<td width='5%' id='check" + i
									+ "'><input class='form-control' type='radio' title='Print Debit Note' name='strdebitNote' value='"
									+ strHiddenValue + "' id='strdebitNote' onclick='onSelectRadioButton(\""
									+ strHiddenValue + "\",\"" + i + "\");'></td>");
							sb.append("<td class='' width='15%'>").append(ws.getString(1));
							sb.append("</td> ");
							sb.append("<td class='' width='15%'>").append(ws.getString(2));
							sb.append("</td> ");
							sb.append("<td class='' width='25%'>").append(ws.getString(3));
							sb.append("</td> ");
							sb.append("<td class='' width='20%'>").append(ws.getString(5));
							sb.append("</td> ");
							sb.append("<td class='' width='20%'>").append(ws.getString(4));
							sb.append("</td> ");
							sb.append("</tr> ");

						}
						sb.append("</table>");
						sb.append("</div>");

					}

				}

			} else {
				sb.append("<table class='table table-striped' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append(
						"<td class='font-weight-bold' style='text-align:left;' colspan='5'>&nbsp;Gifted Item Details");
				sb.append("</td> ");
				sb.append("</tr>  ");
				sb.append("<tr> ");
				sb.append("<td class='font-weight-bold' width='20%'>Gifted No. ");
				sb.append("</td> ");
				sb.append("<td class='font-weight-bold' width='20%'>Gifted Date ");
				sb.append("</td> ");
				sb.append("<td class='font-weight-bold' width='20%'>Gifted By ");
				sb.append("</td> ");
				sb.append("<td class='font-weight-bold' width='20%'>Supplied By ");
				sb.append("</td> ");
				sb.append("<td class='font-weight-bold' width='20%'>PO No.");
				sb.append("</td> ");
				sb.append("</tr>  ");
				// sb.append("</table> ");

				// sb.append("<table class='table' align='center' cellpadding='1px'
				// cellspacing='1px'> ");
				sb.append("<tr><td class='' colspan='5' ><font color='red'>No Matching Record Found</font></td></tr>");
				sb.append("</table>");
				sb.append("</div>");
			}

		} catch (Exception e) {

		}

		return sb.toString();

	}

	
	  public static String getvoucherPrintDetails(GiftedItemDetailsTransVO vo) 
	  {
	  double sum1=0; 
	  StringBuffer sb = new StringBuffer(""); 
	  String strReceivedQty = ""; 
	  String strOrderNo="" , strOrderDate=""; 
	  String supplierName =vo.getStrSuppliedBy(); 
	  String itemcat = vo.getStrItemCategoryId(); 
	  String pono = vo.getPono(); 
	  String receiveDate = vo.getStrReceivedDate(); 
	  HisUtil util = new HisUtil("mms", "getvoucherPrintDetails"); 
	  WebRowSet ws = null ;
	  String strTableWidth = "800"; 
	  String Remarks=""; 
	  int sno=1; 
	  try {
	  ResourceBundle res = mms.qryHandler_mms.res; 
	  if(res == null) 
	  { res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
	  mms.qryHandler_mms.res = res; } 
	  ws = vo.getWsGiftItemDetail(); 
	  if (ws != null && ws.size() > 0) 
	  { 
		      ws.next();
		      /*
			  sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			  sb.append("<tr><td width='8%'>&nbsp;</td> "); 
			  sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> "); 
			  sb.append(res.getString("REPORT_TITLE"));
			  sb.append("</font></b></td>");
			  Date d = new Date();
			  String date1=new SimpleDateFormat("dd-MMM-yyyy").format(d); 
				
			  sb.append("<td width='10%'><b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>"+date1+"</font></b></td> ");
			 
			  sb.append("</tr> "); 
			  sb.append("<tr> ");
			  sb.append("<td width='8%'>&nbsp;</td> "); 
			  sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> "); 
			  sb.append(res.getString("FULL_TITLE"));
			  sb.append("</font></b></td> <td width='8%'>&nbsp;</td> "); 
			  
			  sb.append("</tr> "); 
			  sb.append("<tr> ");
			  sb.append("<td width='8%'>&nbsp;</td> "); 
			  sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> "); 
			  sb.append(res.getString("CITY"));
			  sb.append("</font></b></td><td width='10%'>&nbsp; "); 
			  sb.append("</td> ");
			  sb.append("</tr> "); 
			  sb.append("<tr> ");
			  sb.append("<td width='8%'>&nbsp;</td> ");
			  
			  sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><u>Gifted Drug/Item Entry Voucher</u>");
			  
			  sb.append("</font></b></td><td width='10%'>&nbsp; "); sb.append("</td> ");
			  sb.append("</tr> "); 
			  sb.append("</table> ");
			  
			  //sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='").append(strTableWidth).append( "'></table> "); 
			  sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>"); 
			  sb.append("<img style='cursor: pointer; ' title='Print Page'  "); 
			  sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataForTransfer();' /> <img style='cursor: pointer; ' title='Cancel Process'  "); 
			  sb.append(" src='../../hisglobal/images/stop.png' onClick='hideTransferPopup();' /> </div></div>"); 
			  
			  
			  //1 hstnum_gifted_no 2 item_name 3 BATCH_NO
			  
			  //4 QTY 5 expiry date 6 rate 7 unit
			   */
		      
		        sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='"+strTableWidth+"'>");
				sb.append("<tr> ");
				
				sb.append("<td align='center' colspan='1'>");
				sb.append("</td>");
				
				sb.append("<td align='center' colspan='1'>");			
				sb.append("<img src='/INVMGM/hisglobal/images/aiims_inv_header.png' />");
				sb.append("</td>");
				
				sb.append("<td align='right' colspan='1'>");
				sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
				sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
				sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataForTransfer();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
				sb.append(" src='../../hisglobal/images/stop.png' onClick='hideTransferPopup();' /> </div></div>");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				
                sb.append("<tr> ");				
				sb.append("<td align='center' colspan='1'>");
				sb.append("</td>");				
				sb.append("<td align='center' colspan='1'>");			
				sb.append("<u>Gifted Drug/Item Entry Voucher</u>");
				sb.append("</td>");				
				sb.append("<td align='right' colspan='1'>");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append(" </table> ");
			  
	  }
	  sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
	  
	  ws.beforeFirst(); 
	  if (ws != null && ws.size() > 0) 
	  {
	  
	  
	  
		  if(ws.next()) 
		  { 
			  /*
			   * 1.Gifted No
			   * 2.Store Name
			   * 3.Item Name
			   * 4.Batch No
			   * 5.Gifted Qty
			   * 6.Exp Date
			   * 7.Gifted Date 
			   * 8.Rate
			   * 9.Cost To Patient
			   * 10.Rec By
			   * 11.Gifted By
			   * 
			   * */
			  
			  sb.append("<tr> "); 
			  sb.append("<td width='25%' align='LEFT' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' >").append("<b>Store Name</b>")
			  .append(" : "+ws.getString(2)+"</font></td> ");
		  
			  sb.append("<td width='40%' align='LEFT' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' >").append("<b>Transaction Number</b>")
			  .append(" : "+ws.getString(1)+"</font></td> ");
			  sb.append("<td width='35%' align='LEFT' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' >").append("<b>Supplier Name</b>").append(" : "+ws.getString(11)+"</font></td> ");
			  	  
			  sb.append("</tr> ");		  
			  sb.append("<tr> "); 		  
			  sb.append("<td width='25%' align='LEFT' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' >").append( util.appendSpace("<b>Category</b>",15,0)).append(" : "+itemcat+"</font></td> ");
			 
			     String sDate2=ws.getString(7).split(" ")[0];  
				 Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(sDate2); 
			  
			    sb.append("<td width='40%' align='LEFT' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' >"
			  ).append( util.appendSpace("<b>Received Date</b>",
			  15,0)).append(" : "+ new SimpleDateFormat("dd-MMM-yyyy").format(date2)+"</font></td> ");
			  
			  sb.append("<td width='35%' align='LEFT' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' >"
			  ).append("</font></td> ");
			  
			  sb.append("</tr> ");
			  
			  sb.append("</table>");
			  }
			  
			  
			  sb.append("<table width='").append(strTableWidth).
			  append("' align='center' cellpadding='1px' cellspacing='1px'> ");
			  sb.append("<tr>");
			  sb.append("<td colspan='8' align='center'><hr size='2' width='100%'></td>");
			  sb.append("</tr>");
			  
			  sb.append("<tr bgcolor='#cdc9c9'> "); 
			  
			  sb. append("<td  width='5%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>SNo.</b></font> "); 
			  sb.append("</td>");
			  
			  sb. append("<td  width='25%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>Item Name</b></font> "); 
			  sb.append("</td>");
			  
			  sb.append("<td width='5%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>Batch</b></font> "); 
			  sb.append("</td> "); 
			  sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty</b></font> "); 
			  sb.append("</td> "); 
			  sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font> "); 
			  sb.append("</td> ");	  
			  
			  sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Pur Rate/Unit (Incl Tax)</b></font> ");
			  sb.append("</td> ");
			  sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost To Patient</b></font> "); 
			  sb.append("</td> ");
			  sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total</b></font> ");
			  sb.append("</td> ");		  
			  sb.append("</tr> ");		  
			  sb.append("<tr>");
			  sb.append("<td colspan='10' align='center'><hr size='2' width='100%'></td>");
			  sb.append("</tr>");
		  
			  ws.beforeFirst(); 
			  while (ws.next()) 
			  { 
				  
				  /*
				   * 1.Gifted No
				   * 2.Store Name
				   * 3.Item Name
				   * 4.Batch No
				   * 5.Gifted Qty
				   * 6.Exp Date
				   * 7.Gifted Date 
				   * 8.Rate
				   * 9.Cost To Patient
				   * 10.Rec By
				   * 11.Gifted By
				   * 
				   * */
				  sb.append("<tr> "); 
				  
				  sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >"); 
				  sb.append(sno++); 
				  sb.append("</font></td> "); 
				  sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >"); 
				  sb.append(ws.getString(3)); 
				  sb.append("</font></td> "); 
				  sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >"); 
				  sb.append(ws.getString(4)); 
				  sb.append("</font></td> "); 
				  sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >"); 
				  sb.append(ws.getString(5)); 
				  sb.append("</font></td> "); 
				  sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"); 
				  if(!ws.getString(6).equals(""))
				  {
				     String sDate1=ws.getString(6).split(" ")[0];				  
					 Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1); 
					 sb.append( new SimpleDateFormat("dd-MMM-yyyy").format(date1)); 
					
				  }
				  else
				  {
					  sb.append("-"); 
				  }				  
				  sb.append("</font></td> "); 
				  sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"); 
				  sb.append(ws.getString(8)); 
				  sb.append("</font></td> "); 
				  sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"); 
				  sb.append(ws.getString(9)); 
				  sb.append("</font></td> ");
			  
			  
				  sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"); 
				  sum1=sum1+(Double.parseDouble(ws.getString(5))*Double.parseDouble(ws.getString(8))); 
				  sb.append(HisUtil.getAmountWithDecimal(sum1,2));
				  sb.append("</font></td> ");
				  
				  sb.append("</tr> ");
				  
				  sb.append("<tr>");
				  sb.append("<td colspan='10' align='center'><hr size='2' width='100%'></td>");
				  sb.append("</tr>");
				  
				  
				  sb.append("<tr> ");
				  sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >"); 
				  
				  sb.append("Received By: ");
				  sb.append("</font></td> ");
				  
				  sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >"); 
				  sb.append(ws.getString(10));
				  sb.append("</font></td> ");
				  
				  sb.append("</tr> ");
				  sb.append("<tr> ");
				  sb.append("</tr> ");
			  	  
			  } 
		  } 
	      else 
		  {
	    	    sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='"+strTableWidth+"'>");
				sb.append("<tr> ");
				
				sb.append("<td align='center' colspan='1'>");
				sb.append("</td>");
				
				sb.append("<td align='center' colspan='1'>");			
				sb.append("<img src='/INVMGM/hisglobal/images/aiims_inv_header.png' />");
				sb.append("</td>");
				
				sb.append("<td align='right' colspan='1'>");
				sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
				sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
				sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataForTransfer();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
				sb.append(" src='../../hisglobal/images/stop.png' onClick='hideTransferPopup();' /> </div></div>");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				
                sb.append("<tr> ");				
				sb.append("<td align='center' colspan='1'>");
				sb.append("</td>");				
				sb.append("<td align='center' colspan='1'>");			
				sb.append("<u>Gifted Drug/Item Entry Voucher</u>");
				sb.append("</td>");				
				sb.append("<td align='right' colspan='1'>");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append(" </table> "); 
			    sb.append("<tr> "); 
			    sb.append("<td colspan='11' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/>Details Not Available</font></td> "); 
			    sb.append("</tr> ");
		  
	       }
	  
	  
	  sb.append("</table> ");
	  
	  } catch (Exception e) {
	  
	  e.printStackTrace(); }
	  
	  return sb.toString(); }
	 
}
