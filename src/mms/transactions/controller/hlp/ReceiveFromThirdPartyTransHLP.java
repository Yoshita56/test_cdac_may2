package mms.transactions.controller.hlp;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.HisUtil;
import mms.transactions.controller.fb.ReceiveFromThirdPartyTransFB;
import mms.transactions.vo.ReceiveFromThirdPartyTransVO;

public class ReceiveFromThirdPartyTransHLP 
{

	private static final String strColor = "red";
	private static final String defaultColor = "blue";
	
	public static String getNewReceivedItemsList(ReceiveFromThirdPartyTransFB formBean) {

		StringBuffer sb = null;

		final int LMIT_VAL = 10;

		WebRowSet ws = formBean.getWsReceivedItemList();

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
					sb.append("<td class='TITLE' colspan='6'>&nbsp;Received Item Details");
					sb.append("</td> ");
					sb.append("</tr>  ");
					sb.append("<tr>");
					sb.append("<td class='LABEL' colspan='6'>&nbsp;");
					for (int i = 1; i <= totalLayer; i++) {

						if (i == 1) {
							sb.append("<a STYLE='CURSOR:POINTER; color:"
									+ strColor + "' name='linId' id='linId" + i
									+ "' onClick='layerIndexNavigator(\"" + i
									+ "\",\"" + totalLayer + "\")'>" + i
									+ "</a> &nbsp;");
						} else {
							sb.append("<a STYLE='CURSOR:POINTER; color:"
									+ defaultColor + "' name='linId' id='linId"
									+ i + "' onClick='layerIndexNavigator(\""
									+ i + "\",\"" + totalLayer + "\")'>" + i
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
					sb.append("<td class='multiLabel' width='10%'>Received Qty. ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='10%'>Status");
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
							sb
									.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
							for (int j = 0; j < LMIT_VAL; j++) {
								ws.next();

								sb.append("<tr> ");
								sb
										.append("<td class='multiControl' width='20%'>").append(ws.getString(1));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='20%'>").append(ws.getString(2));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='10%'>").append(ws.getString(5));
								sb.append("</td> ");
								if(ws.getString(6).equals("0"))
								{	
								  sb.append("<td class='multiControl' width='10%'>Active");
						          sb.append("</td> ");
								} 
								if(ws.getString(6).equals("40"))
								{	
								  sb.append("<td class='multiControl' width='10%'>Pending");
						          sb.append("</td> ");
								} 
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

							sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
							for (int k = 0; k < reminder; k++) {
								ws.next();
								sb.append("<tr> ");
								sb
										.append("<td class='multiControl' width='20%'>").append(ws.getString(1));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='20%'>").append(ws.getString(2));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='10%'>").append(ws.getString(5));
								sb.append("</td> ");
								if(ws.getString(6).equals("0"))
								{	
								  sb.append("<td class='multiControl' width='10%'>Active");
						          sb.append("</td> ");
								} 
								if(ws.getString(6).equals("40"))
								{	
								  sb.append("<td class='multiControl' width='10%'>Pending");
						          sb.append("</td> ");
								} 
								sb.append("</tr> ");

							}
							sb.append("</table>");
							sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
							sb.append("<tr> ");
							sb.append("<td class='TITLE' colspan='6'>");
							sb.append("</td> ");
							sb.append("</tr>  ");
							sb.append("</table>");
							sb.append("</div>");

						}

					}

				}
				else 
				{
					sb
					.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb.append("<tr> ");
					sb.append("<td class='TITLE' colspan='6'>&nbsp;Received Item Details");
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
					sb.append("<td class='multiLabel' width='10%'>Qty. ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='10%'>Status");
			        sb.append("</td> ");
					sb.append("</tr>  ");
					sb.append("</table> ");
					
					sb
							.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb
							.append("<tr><td class='multiControl' colspan='5' ><font color='red'>No Matching Record Found</font></td></tr>");
					sb.append("</table>");
					
				}

		
		} catch (Exception e) {

		} 
		return sb.toString();
	}

	public static String getNewReceivedItemsListNEW(ReceiveFromThirdPartyTransFB formBean) {

		StringBuffer sb = null;

		final int LMIT_VAL = 10;

		WebRowSet ws = formBean.getWsReceivedItemList();

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

					sb.append("<table class='table table-striped' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb.append("<tr> ");
					sb.append("<td class='float-left' colspan='6'>&nbsp;Received Item Details");
					sb.append("</td> ");
					sb.append("</tr>  ");
					sb.append("<tr>");
					sb.append("<td class='LABEL' colspan='6'>&nbsp;");
					for (int i = 1; i <= totalLayer; i++) {

						if (i == 1) {
							sb.append("<a STYLE='CURSOR:POINTER; color:"
									+ strColor + "' name='linId' id='linId" + i
									+ "' onClick='layerIndexNavigator(\"" + i
									+ "\",\"" + totalLayer + "\")'>" + i
									+ "</a> &nbsp;");
						} else {
							sb.append("<a STYLE='CURSOR:POINTER; color:"
									+ defaultColor + "' name='linId' id='linId"
									+ i + "' onClick='layerIndexNavigator(\""
									+ i + "\",\"" + totalLayer + "\")'>" + i
									+ "</a> &nbsp;");
						}
					}
					sb.append("</td>");
					sb.append("</tr>");

					sb.append("<tr> ");
					sb.append("<td class='' width='20%'>Received No. ");
					sb.append("</td> ");
					sb.append("<td class='' width='20%'>Received Date ");
					sb.append("</td> ");
					sb.append("<td class='' width='20%'>Institute");
					sb.append("</td> ");
					sb.append("<td class='' width='20%'>Item Name ");
					sb.append("</td> ");
					sb.append("<td class='' width='10%'>Received Qty. ");
					sb.append("</td> ");
					sb.append("<td class='' width='10%'>Status");
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
							sb
									.append("<table class='table table-striped' align='center' cellpadding='1px' cellspacing='1px'> ");
							for (int j = 0; j < LMIT_VAL; j++) {
								ws.next();

								sb.append("<tr> ");
								sb
										.append("<td class='' width='20%'>").append(ws.getString(1));
								sb.append("</td> ");
								sb
										.append("<td class='' width='20%'>").append(ws.getString(2));
								sb.append("</td> ");
								sb
										.append("<td class='' width='20%'>").append(ws.getString(3));
								sb.append("</td> ");
								sb
										.append("<td class='' width='20%'>").append(ws.getString(4));
								sb.append("</td> ");
								sb
										.append("<td class='' width='10%'>").append(ws.getString(5));
								sb.append("</td> ");
								if(ws.getString(6).equals("0"))
								{	
								  sb.append("<td class='' width='10%'>Active");
						          sb.append("</td> ");
								} 
								if(ws.getString(6).equals("40"))
								{	
								  sb.append("<td class='' width='10%'>Pending");
						          sb.append("</td> ");
								} 
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

							sb.append("<table class='table table-striped' align='center' cellpadding='1px' cellspacing='1px'> ");
							for (int k = 0; k < reminder; k++) {
								ws.next();
								sb.append("<tr> ");
								sb
										.append("<td class='' width='20%'>").append(ws.getString(1));
								sb.append("</td> ");
								sb
										.append("<td class='' width='20%'>").append(ws.getString(2));
								sb.append("</td> ");
								sb
										.append("<td class='' width='20%'>").append(ws.getString(3));
								sb.append("</td> ");
								sb
										.append("<td class='' width='20%'>").append(ws.getString(4));
								sb.append("</td> ");
								sb
										.append("<td class='' width='10%'>").append(ws.getString(5));
								sb.append("</td> ");
								if(ws.getString(6).equals("0"))
								{	
								  sb.append("<td class='' width='10%'>Active");
						          sb.append("</td> ");
								} 
								if(ws.getString(6).equals("40"))
								{	
								  sb.append("<td class='' width='10%'>Pending");
						          sb.append("</td> ");
								} 
								sb.append("</tr> ");

							}
							sb.append("</table>");
							sb.append("<table class='table table-striped' align='center' cellpadding='1px' cellspacing='1px'> ");
							sb.append("<tr> ");
							sb.append("<td class='TITLE' colspan='6'>");
							sb.append("</td> ");
							sb.append("</tr>  ");
							sb.append("</table>");
							sb.append("</div>");

						}

					}

				}
				else 
				{
					sb
					.append("<table class='table table-striped text-uppercase' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb.append("<tr> ");
					sb.append("<td class='' colspan='6'>&nbsp;Received Item Details");
					sb.append("</td> ");
					sb.append("</tr>  ");
					sb.append("<tr> ");
					sb.append("<td class='' width='20%' style='font-weight:bold;'>Gifted No. ");
					sb.append("</td> ");
					sb.append("<td class='' width='20%' style='font-weight:bold;'>Gifted Date ");
					sb.append("</td> ");
					sb.append("<td class='' width='20%' style='font-weight:bold;'>Gifted By ");
					sb.append("</td> ");
					sb.append("<td class='' width='20%' style='font-weight:bold;'>Item Name ");
					sb.append("</td> ");
					sb.append("<td class='' width='10%' style='font-weight:bold;'>Qty. ");
					sb.append("</td> ");
					sb.append("<td class='' width='10%' style='font-weight:bold;'>Status");
			        sb.append("</td> ");
					sb.append("</tr>  ");
					sb.append("</table> ");
					
					sb
							.append("<table class='table' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb
							.append("<tr><td class='' colspan='5' ><font color='red'>No Matching Record Found</font></td></tr>");
					sb.append("</table>");
					
				}

		
		} catch (Exception e) {

		} 

		return sb.toString();
	}
	
	public static String getUpdateReceivedItemsList(ReceiveFromThirdPartyTransFB formBean) {

		StringBuffer sb = null;

		final int LMIT_VAL = 10;

		WebRowSet ws = formBean.getWsReceivedItemList();

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
					sb.append("<td class='TITLE' colspan='6'>&nbsp;Received Item Details");
					sb.append("</td> ");
					sb.append("</tr>  ");
					sb.append("<tr>");
					sb.append("<td class='LABEL' colspan='6'>&nbsp;");
					for (int i = 1; i <= totalLayer; i++) {

						if (i == 1) {
							sb.append("<a STYLE='CURSOR:POINTER; color:"
									+ strColor + "' name='linId' id='linId" + i
									+ "' onClick='layerIndexNavigator(\"" + i
									+ "\",\"" + totalLayer + "\")'>" + i
									+ "</a> &nbsp;");
						} else {
							sb.append("<a STYLE='CURSOR:POINTER; color:"
									+ defaultColor + "' name='linId' id='linId"
									+ i + "' onClick='layerIndexNavigator(\""
									+ i + "\",\"" + totalLayer + "\")'>" + i
									+ "</a> &nbsp;");
						}
					}
					sb.append("</td>");
					sb.append("</tr>");

					sb.append("<tr> ");
					sb.append("<td class='multiLabel' width='10%'>#");
					sb.append("</td> ");					
					sb.append("<td class='multiLabel' width='15%'>Received No");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='15%'>Received Date ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Institute");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Item Name ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Received Qty");
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
							sb
									.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
							for (int j = 0; j < LMIT_VAL; j++) {
								ws.next();

								sb.append("<tr> ");
								
								sb.append("<td class='multiControl' width='10%'>");
								sb.append("<input type='radio'  name='strReceivedItemApprovedMode' value='1'/>");
						        sb.append("</td> ");
								
								sb
										.append("<td class='multiControl' width='15%'>").append(ws.getString(1));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='15%'>").append(ws.getString(2));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='20%'>").append(ws.getString(5));
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

							sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
							for (int k = 0; k < reminder; k++) {
								ws.next();
								sb.append("<tr> ");
								sb.append("<td class='multiControl' width='10%'>");
								sb.append("<input type='radio'  name='strReceivedItemApprovedMode' value='1'/>");
						        sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='15%'>").append(ws.getString(1));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='15%'>").append(ws.getString(2));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
								sb.append("</td> ");
								
								sb.append("<td class='multiControl' width='20%'>").append(ws.getString(5));
						        sb.append("</td> ");
																
								sb.append("</tr> ");

							}
							sb.append("</table>");
							sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
							sb.append("<tr> ");
							sb.append("<td class='TITLE' colspan='6'>");
							sb.append("</td> ");
							sb.append("</tr>  ");
							sb.append("</table>");
							sb.append("</div>");

						}

					}

				}
				else 
				{
					sb
					.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb.append("<tr> ");
					sb.append("<td class='TITLE' colspan='6'>&nbsp;Received Item Details");
					sb.append("</td> ");
					sb.append("</tr>  ");
					sb.append("<tr> ");
					sb.append("<td class='multiLabel' width='20%'>Gifted No. ");
					sb.append("</td> ");
					sb
							.append("<td class='multiLabel' width='20%'>Gifted Date ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Gifted By ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Item Name ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Qty. ");
					sb.append("</td> ");
					sb.append("</tr>  ");
					sb.append("</table> ");
					
					sb
							.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb
							.append("<tr><td class='multiControl' colspan='5' ><font color='red'>No Matching Record Found</font></td></tr>");
					sb.append("</table>");
				}

		
		} catch (Exception e) {

		} 
		return sb.toString();
	}

	public static String getUpdateReceivedItemsListNEW(ReceiveFromThirdPartyTransFB formBean) {

		StringBuffer sb = null;

		final int LMIT_VAL = 10;

		WebRowSet ws = formBean.getWsReceivedItemList();

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
					sb.append("<td class='TITLE' colspan='6'>&nbsp;Received Item Details");
					sb.append("</td> ");
					sb.append("</tr>  ");
					sb.append("<tr>");
					sb.append("<td class='LABEL' colspan='6'>&nbsp;");
					for (int i = 1; i <= totalLayer; i++) {

						if (i == 1) {
							sb.append("<a STYLE='CURSOR:POINTER; color:"
									+ strColor + "' name='linId' id='linId" + i
									+ "' onClick='layerIndexNavigator(\"" + i
									+ "\",\"" + totalLayer + "\")'>" + i
									+ "</a> &nbsp;");
						} else {
							sb.append("<a STYLE='CURSOR:POINTER; color:"
									+ defaultColor + "' name='linId' id='linId"
									+ i + "' onClick='layerIndexNavigator(\""
									+ i + "\",\"" + totalLayer + "\")'>" + i
									+ "</a> &nbsp;");
						}
					}
					sb.append("</td>");
					sb.append("</tr>");

					sb.append("<tr> ");
					sb.append("<td class='multiLabel' width='10%'>#");
					sb.append("</td> ");					
					sb.append("<td class='multiLabel' width='15%'>Received No");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='15%'>Received Date ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Institute");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Item Name ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Received Qty");
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
							sb
									.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
							for (int j = 0; j < LMIT_VAL; j++) {
								ws.next();

								sb.append("<tr> ");
								
								sb.append("<td class='multiControl' width='10%'>");
								sb.append("<input type='radio'  name='strReceivedItemApprovedMode' value='1'/>");
						        sb.append("</td> ");
								
								sb
										.append("<td class='multiControl' width='15%'>").append(ws.getString(1));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='15%'>").append(ws.getString(2));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='20%'>").append(ws.getString(5));
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

							sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
							for (int k = 0; k < reminder; k++) {
								ws.next();
								sb.append("<tr> ");
								sb.append("<td class='multiControl' width='10%'>");
								sb.append("<input type='radio'  name='strReceivedItemApprovedMode' value='1'/>");
						        sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='15%'>").append(ws.getString(1));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='15%'>").append(ws.getString(2));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
								sb.append("</td> ");
								sb
										.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
								sb.append("</td> ");
								
								sb.append("<td class='multiControl' width='20%'>").append(ws.getString(5));
						        sb.append("</td> ");
																
								sb.append("</tr> ");

							}
							sb.append("</table>");
							sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
							sb.append("<tr> ");
							sb.append("<td class='TITLE' colspan='6'>");
							sb.append("</td> ");
							sb.append("</tr>  ");
							sb.append("</table>");
							sb.append("</div>");

						}

					}

				}
				else 
				{
					sb
					.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb.append("<tr> ");
					sb.append("<td class='TITLE' colspan='6'>&nbsp;Received Item Details");
					sb.append("</td> ");
					sb.append("</tr>  ");
					sb.append("<tr> ");
					sb.append("<td class='multiLabel' width='20%'>Gifted No. ");
					sb.append("</td> ");
					sb
							.append("<td class='multiLabel' width='20%'>Gifted Date ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Gifted By ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Item Name ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Qty. ");
					sb.append("</td> ");
					sb.append("</tr>  ");
					sb.append("</table> ");
					
					sb
							.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb
							.append("<tr><td class='multiControl' colspan='5' ><font color='red'>No Matching Record Found</font></td></tr>");
					sb.append("</table>");
				}

		
		} catch (Exception e) {

		} 
		return sb.toString();
	}
	
	public static String getReceivedItemsListtest(ReceiveFromThirdPartyTransFB formBean) {

		StringBuffer sb = null;

		final int LMIT_VAL = 10;

		WebRowSet ws = formBean.getWsReceivedItemList();

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
					sb.append("<td class='TITLE' colspan='7'>&nbsp;Received Item Details");
					sb.append("</td> ");
					sb.append("</tr>  ");
					
					sb.append("<tr>");
					sb.append("<td class='LABEL' colspan='7'>&nbsp;");
					for (int i = 1; i <= totalLayer; i++) {

						if (i == 1) {
							sb.append("<a STYLE='CURSOR:POINTER; color:"+ strColor + "' name='linId' id='linId" + i
									+ "' onClick='layerIndexNavigator(\"" + i
									+ "\",\"" + totalLayer + "\")'>" + i
									+ "</a> &nbsp;");
						}
						else 
						{
							sb.append("<a STYLE='CURSOR:POINTER; color:"+ defaultColor + "' name='linId' id='linId"	+ i + "' onClick='layerIndexNavigator(\""
									+ i + "\",\"" + totalLayer + "\")'>" + i
									+ "</a> &nbsp;");
						}
					}
					sb.append("</td>");
					sb.append("</tr>");

					sb.append("<tr> ");
					sb.append("<td class='multiLabel' width='20%'>Received No. ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='10%'>Received Date ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Third Party Name");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Drug Name ");
					sb.append("</td> ");
					
					sb.append("<td class='multiLabel' width='10%'>Batch No. ");
					sb.append("</td> ");
					
					sb.append("<td class='multiLabel' width='10%'>Expiry Date ");
					sb.append("</td> ");
					
					sb.append("<td class='multiLabel' width='10%'>Received Qty. ");
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
							sb
									.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
							for (int j = 0; j < LMIT_VAL; j++) {
								ws.next();

								sb.append("<tr> ");
								sb.append("<td class='multiControl' width='20%'>").append(ws.getString(1));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='10%'>").append(ws.getString(2));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='10%'>").append(ws.getString(6));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='10%'>").append(ws.getString(8));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='10%'>").append(ws.getString(5));
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

							sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
							for (int k = 0; k < reminder; k++) {
								ws.next();
								sb.append("<tr> ");
								sb.append("<td class='multiControl' width='20%'>").append(ws.getString(1));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='10%'>").append(ws.getString(2));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='10%'>").append(ws.getString(6));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='10%'>").append(ws.getString(8));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='10%'>").append(ws.getString(5));
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
					sb.append("<td class='TITLE' colspan='7'>&nbsp;Received Item Details");
					sb.append("</td> ");
					sb.append("</tr>  ");
					sb.append("<tr> ");
					sb.append("<td class='multiLabel' width='20%'>Received No. ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Received Date ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Received By ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Drug Name ");
					sb.append("</td> ");
					
					sb.append("<td class='multiLabel' width='10%'>Batch No. ");
					sb.append("</td> ");
					
					sb.append("<td class='multiLabel' width='10%'>Expiry Date ");
					sb.append("</td> ");
					
					sb.append("<td class='multiLabel' width='20%'>Received Qty.");
					sb.append("</td> ");
					sb.append("</tr>  ");
					sb.append("</table> ");
					
					sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb.append("<tr><td class='multiControl' colspan='7' ><font color='red'>No Matching Record Found</font></td></tr>");
					sb.append("</table>");
				}

		
		} catch (Exception e) {

		} 
		return sb.toString();
	}

/*	ORG
	public static String getReceivedItemsList(ReceiveFromThirdPartyTransFB formBean) {

		StringBuffer sb = null;

		final int LMIT_VAL = 10;

		WebRowSet ws = formBean.getWsReceivedItemList();

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
					sb.append("<td class='TITLE' colspan='7'>&nbsp;Received Item Details");
					sb.append("</td> ");
					sb.append("</tr>  ");
					
					sb.append("<tr>");
					sb.append("<td class='LABEL' colspan='7'>&nbsp;");
					for (int i = 1; i <= totalLayer; i++) {

						if (i == 1) {
							sb.append("<a STYLE='CURSOR:POINTER; color:"+ strColor + "' name='linId' id='linId" + i
									+ "' onClick='layerIndexNavigator(\"" + i
									+ "\",\"" + totalLayer + "\")'>" + i
									+ "</a> &nbsp;");
						}
						else 
						{
							sb.append("<a STYLE='CURSOR:POINTER; color:"+ defaultColor + "' name='linId' id='linId"	+ i + "' onClick='layerIndexNavigator(\""
									+ i + "\",\"" + totalLayer + "\")'>" + i
									+ "</a> &nbsp;");
						}
					}
					sb.append("</td>");
					sb.append("</tr>");

					sb.append("<tr> ");
					sb.append("<td class='multiLabel' width='20%'>Received No. ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='10%'>Received Date ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Third Party Name");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Drug Name ");
					sb.append("</td> ");
					
					sb.append("<td class='multiLabel' width='10%'>Batch No. ");
					sb.append("</td> ");
					
					sb.append("<td class='multiLabel' width='10%'>Expiry Date ");
					sb.append("</td> ");
					
					sb.append("<td class='multiLabel' width='10%'>Received Qty. ");
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
							sb
									.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
							for (int j = 0; j < LMIT_VAL; j++) {
								ws.next();

								sb.append("<tr> ");
								sb.append("<td class='multiControl' width='20%'>").append(ws.getString(1));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='10%'>").append(ws.getString(2));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='10%'>").append(ws.getString(6));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='10%'>").append(ws.getString(8));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='10%'>").append(ws.getString(5));
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

							sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
							for (int k = 0; k < reminder; k++) {
								ws.next();
								sb.append("<tr> ");
								sb.append("<td class='multiControl' width='20%'>").append(ws.getString(1));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='10%'>").append(ws.getString(2));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='20%'>").append(ws.getString(3));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='20%'>").append(ws.getString(4));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='10%'>").append(ws.getString(6));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='10%'>").append(ws.getString(8));
								sb.append("</td> ");
								sb.append("<td class='multiControl' width='10%'>").append(ws.getString(5));
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
					sb.append("<td class='TITLE' colspan='7'>&nbsp;Received Item Details");
					sb.append("</td> ");
					sb.append("</tr>  ");
					sb.append("<tr> ");
					sb.append("<td class='multiLabel' width='20%'>Received No. ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Received Date ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Received By ");
					sb.append("</td> ");
					sb.append("<td class='multiLabel' width='20%'>Drug Name ");
					sb.append("</td> ");
					
					sb.append("<td class='multiLabel' width='10%'>Batch No. ");
					sb.append("</td> ");
					
					sb.append("<td class='multiLabel' width='10%'>Expiry Date ");
					sb.append("</td> ");
					
					sb.append("<td class='multiLabel' width='20%'>Received Qty.");
					sb.append("</td> ");
					sb.append("</tr>  ");
					sb.append("</table> ");
					
					sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb.append("<tr><td class='multiControl' colspan='7' ><font color='red'>No Matching Record Found</font></td></tr>");
					sb.append("</table>");
				}

		
		} catch (Exception e) {

		} 

		return sb.toString();

	}
*/
	
	public static String getReceivedItemsList(ReceiveFromThirdPartyTransFB formBean, ReceiveFromThirdPartyTransVO vo) {
	    StringBuffer sb = new StringBuffer();

	    WebRowSet ws = formBean.getWsReceivedItemList();
	    String strStoreId = "";
	    String strStoreName = "";

	    String strItemCategoryId = "";
	    String strItemCategoryNo = "";

	    String strFinancialStartYear = "";
	    String strFinancialEndYear = "";
	    String strReceivedNo = ""; // Initialize outside the loop

	    try {
	        if (ws != null && ws.size() > 0) {
	            ws.beforeFirst();
	            sb.append("<div id='wrapper'>");
	            sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
	            
	            sb.append("<tr>");
	            sb.append("<td colspan='12' align='left' style='font-size:18px;font-weight:normal;'>Received Item Details</td>");
	            sb.append("</tr>");
	            
	            sb.append("</table>");

	            sb.append("<div id='tariffDivId1' style='display:block'>"); 
	            sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='1px'>");
	            sb.append("<tr>");
	            sb.append("<th style='width:5%;'>S.No.</th>");
	            sb.append("<th style='width:10%;'>Received No.</th>");
	            sb.append("<th style='width:15%;'>Received Date</th>");
	            sb.append("<th style='width:20%;'>Third Party Name</th>");
	            sb.append("<th style='width:20%;'>Drug Name</th>");
	            sb.append("<th style='width:10%;'>Batch No.</th>");
	            sb.append("<th style='width:10%;'>Expiry Date</th>");
	            sb.append("<th style='width:10%;'>Received Qty.</th>");
	            sb.append("<th style='width:5%;'>#</th>");
	            sb.append("</tr>");

	            int i = 1;
	            while (ws.next()) {
	                strReceivedNo = ws.getString(1); 

	                   strStoreId            = vo.getStrStoreId();
	                   strStoreName          = vo.getStrStoreName();
					   strItemCategoryId     = vo.getStrItemCategoryId();
					   strItemCategoryNo     = vo.getStrItemCategoryNo();

					   strFinancialStartYear = vo.getStrFinancialStartYear();
					   strFinancialEndYear   = vo.getStrFinancialEndYear();
	 						
					   sb.append("<input type='hidden' name='strHlpStoreId'    id='strHlpStoreId"    +i+ "'  value=" + strStoreId + " />");
//					   sb.append("<input type='hidden' name='strHlpStoreName'    id='strHlpStoreName"    +i+ "'  value=" + strStoreName + " />");
					   sb.append("<input type='hidden' name='strHlpStoreName' id='strHlpStoreName" + i + "' value=\"" + strStoreName + "\" />");

					   sb.append("<input type='hidden' name='strHlpItemCategoryNo'    id='strHlpItemCategoryNo" +i+ "'  value=" + strItemCategoryNo + " />");

					   sb.append("<input type='hidden' name='strHlpFinancialStartYear'    id='strHlpFinancialStartYear" +i+ "'  value=" + strFinancialStartYear + " />");
					   sb.append("<input type='hidden' name='strHlpFinancialEndYear'    id='strHlpFinancialEndYear" +i+ "'  value=" + strFinancialEndYear + " />");
					   sb.append("<input type='hidden' name='strHlpReceivedNo'    id='strHlpReceivedNo" +i+ "'  value=" + strReceivedNo + " />");
	                
	                sb.append("<tr>");
	                sb.append("<td>").append(i).append("</td>");
	                sb.append("<td>").append(ws.getString(1)).append("</td>");
	                sb.append("<td>").append(ws.getString(2)).append("</td>");
	                sb.append("<td>").append(ws.getString(3)).append("</td>");
	                sb.append("<td>").append(ws.getString(4)).append("</td>");
	                sb.append("<td>").append(ws.getString(6)).append("</td>");
	                sb.append("<td>").append(ws.getString(8)).append("</td>");
	                sb.append("<td>").append(ws.getString(5)).append("</td>");
	                sb.append("<td><i class='fa fa-search highlight-icon' onclick='generateIssueFunc(this,").append(i).append(");'  style='cursor: pointer;' title='Print Details'></i></td>");
	                sb.append("</tr>");
	                i++;
	            }
	            sb.append("</table>");
	            sb.append("</div>");

	            sb.append("</div>"); // End of wrapper
	        } else {
	            sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
	            sb.append("<tr><td colspan='8'><b>Received Item Details</b></td></tr>");
	            sb.append("</table>");
	            sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='1px'>");
	            sb.append("<tr>");
	            sb.append("<th style='width:5%;'>S.No.</th>");
	            sb.append("<th style='width:10%;'>Received No.</th>");
	            sb.append("<th style='width:15%;'>Received Date</th>");
	            sb.append("<th style='width:20%;'>Third Party Name</th>");
	            sb.append("<th style='width:20%;'>Drug Name</th>");
	            sb.append("<th style='width:10%;'>Batch No.</th>");
	            sb.append("<th style='width:10%;'>Expiry Date</th>");
	            sb.append("<th style='width:10%;'>Received Qty.</th>");
	            sb.append("<th style='width:5%;'>#</th>");
	            sb.append("</tr>");
	            sb.append("<tr><td colspan='9' style='text-align:center;'><b>No Matching Record Found</b></td></tr>");
	            sb.append("</table>");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return sb.toString();
	}
	
	//RJ
	public static String getvoucherPrintDetails(ReceiveFromThirdPartyTransFB fb, ReceiveFromThirdPartyTransVO vo) {
	    double sum1 = 0;
	    StringBuffer sb = new StringBuffer("");
	    HisUtil util = new HisUtil("mms", "getvoucherPrintDetails");
	    WebRowSet ws = null;
	    String strTableWidth = "700";
	    String Remarks = "";
	    int sno = 1;
	    double totamt = 0.0;
	    
	    try {
	    	sb.append("<table width='850' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
		    	sb.append("<tr>");
		    	sb.append("<td colspan='1' align='center'>");
		    	sb.append("<img src='/INVMGM/hisglobal/images/aiims_inv_header.png' >");
		    	sb.append("</td>");
		    	sb.append("<td colspan='1' align='right'>");
		    	sb.append("<div id='printVoucrId'>");
		    	sb.append("<img style='cursor: pointer; margin-right: 10px;' title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printVoucher();' />");
		    	sb.append("<img style='cursor: pointer;' title='Cancel' src='../../hisglobal/images/stop.png' onClick='hideIssuePopup();' />");
		    	sb.append("</div>");
		    	sb.append("</td>");
		    	sb.append("</tr>");
	    	
	    	/*
	    	sb.append("<div style='width: 100%; text-align: center; margin-bottom: 10px;'>");
	    	sb.append("<h6 style='font-family: Verdana, Arial, Helvetica, sans-serif;'>Third Party Received Voucher</h6>");
	    	sb.append("</div>");
	        */
	    	    sb.append("<tr>");
	            sb.append("<td colspan='12' align='center' style='font-size:18px;font-weight:normal;'>Third Party Received Voucher</td>");
	            sb.append("</tr>");
		    	sb.append("</table>");

	        ws = vo.getWsReceivedItemListIndividual();
	       
	        if (ws != null && ws.size() > 0) {
	            while (ws.next()) {
	        		 Remarks=ws.getString(18);

	            		sb.append("<table align='center' cellpadding='1px' cellspacing='1px'>");
		            		sb.append("<tr>");
				                sb.append("<td width='25%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif'>");
				                sb.append(util.appendSpace("<b>Store Name</b>", 15, 0)).append(" : ").append(vo.getStrStoreName()).append("</font></td>");
		
				                sb.append("<td width='25%' align='center' ><font face='Verdana, Arial, Helvetica, sans-serif'>");
				                sb.append(util.appendSpace("<b>Item Category</b>", 15, 0)).append(" : ").append(vo.getStrItemCategoryNo()).append("</font></td>");
				                sb.append("</tr>");
				                
				                sb.append("<tr>");
				                sb.append("<td width='25%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif'>");
				                sb.append(util.appendSpace("<b>Receive No</b>", 15, 0)).append(" : ").append(ws.getString(1)).append("</font></td>");
		
				                sb.append("<td width='25%' align='center' ><font face='Verdana, Arial, Helvetica, sans-serif'>");
				                sb.append(util.appendSpace("<b>Receive Date</b>", 15, 0)).append(" : ").append(ws.getString(2)).append("</font></td>");
				                sb.append("</tr>");
				                
				                sb.append("<tr>");
				                sb.append("<td width='25%' align='center' ><font face='Verdana, Arial, Helvetica, sans-serif'>");
				                sb.append(util.appendSpace("<b>Print Date</b>", 15, 0)).append(" : ").append(fb.getStrCurrentDate()).append("</font></td>");
			                
				                sb.append("<td width='25%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif'>");
				                sb.append(util.appendSpace("<b>User Name</b>", 15, 0)).append(" : ").append(ws.getString(14)).append("</font></td>");
				                
				                sb.append("</tr>");
				            sb.append("</table> ");
	            			}

		            sb.append("<table class='table' align='center' style='border-collapse: collapse; border: 1px solid;'>");
		            sb.append("<tr bgcolor='#cdc9c9'> ");
			            sb.append("<td  align='center'width='3%'  style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>S.No.</b></font></td>");
			            sb.append("<td align='center' width='20%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>Third Party Name</b></font></td>");
			            sb.append("<td align='center' width='18%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font></td> ");
			            sb.append("<td align='center' width='10%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch</b></font></td>  ");
			            sb.append("<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font></td>  ");
			            sb.append("<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty</b></font></td>  ");
			            sb.append("<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate</b></font></td>  ");
			          //  sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Gst</b></font></td>  ");
			          //  sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Adm(tax)</b></font></td>  ");
			            sb.append("<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate(Inc.Gst)</b></font></td>  ");
			            sb.append("<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Sale Rate</b></font></td>  ");
			            sb.append("<td align='center' width='12%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total</b></font></td>  ");
		            sb.append("</tr> ");

	            ws.beforeFirst();
	            while (ws.next()) {
	            	
	            	  sb.append("<tr>");
	                  sb.append("<td align='center' width='3%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>").append(sno++).append("</font></td>");
	                  sb.append("<td align='left'   width='20%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>").append(ws.getString(3)).append("</font></td>"); //Third Party Name
	                  sb.append("<td align='left'   width='18%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>").append(ws.getString(4)).append("</font></td>");//Drug
	                  sb.append("<td align='center' width='10%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>").append(ws.getString(6)).append("</font></td>");//Batch
	                  sb.append("<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>").append(ws.getString(8)).append("</font></td>");//Expiry
	                  sb.append("<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>").append(ws.getString(5)).append("</font></td>");//Received qty 
			          sb.append("<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(ws.getString(10)).append("</font></td>");//Rate
//	                  sb.append("<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>").append(ws.getString(15)).append("</font></td>");//Gst
//	                  sb.append("<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>").append(ws.getString(16)).append("</font></td>");//Admin Tax
	                  sb.append("<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>").append(ws.getString(11)).append("</font></td>");//Rate with gst 
	                  sb.append("<td align='center' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>").append(ws.getString(12)).append("</font></td>");//Sale Rate 
	                  sb.append("<td align='center' width='12%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif'>").append(ws.getString(13)).append("</font></td>");//Total
	                  sb.append("</tr>");
	                  
	                  totamt += Double.parseDouble(ws.getString(13)); 
	            }
	            
	            sb.append("<tr>");
					sb.append("<td  colspan='9' align='right' style='border-collapse: collapse; border: 1px solid;'><b> TOTAL</b></td>");
					sb.append("<td  colspan='1'> "+ String.format("%.2f", totamt)+"</td>");
				sb.append("</tr>");
				
				sb.append("<tr>");					
					sb.append("<td colspan='12' style='text-align: left; border-collapse: collapse; border: 1px solid;'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks:</b> "+Remarks+"</b></font></td> ");
				sb.append("</tr> ");
	            
		        sb.append("</table> ");
	        }else {
	        	// If no data
	            sb.append("<tr> ");
	            sb.append("<td colspan='12' rowspan='2' align='center' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/>Details Not Available</font></td> ");
	            sb.append("</tr> ");
		        sb.append("</table> ");
	        }


	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return sb.toString();
	}
}



