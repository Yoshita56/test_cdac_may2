package mms.transactions.controller.hlp;

import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

public class OfflineReturnTransHLP {
	static int i = 0;

	/**
	 * This method is used to show issued item Details on VIEW PAGE2
	 * 
	 * @param wb
	 * @param strItemCategory
	 * @param strHospitalCode
	 * @return
	 */
	public static String getReturnDetail(WebRowSet wb) throws SQLException {
		StringBuffer br = new StringBuffer();

		String strReturnDate = "";
		String strReturnNo = "";
		String strIndentingStore = "";
		String strIndentNo = "";
		String strIndentDate = "";
		String strReturnStoreId ="";

		int i = 0;

		try {
			br.append("<table class='TABLEWIDTH' align='center' cellpadding='1' cellspacing='1'>");
			br.append("<tr>");
			br.append("<td class='TITLE' colspan='2'>");
			br.append("<div id='' style='font-family: Arial, Helvetica, sans-serif;font-size:13px;'>&nbsp;Return Details</div>");
			br.append("</td></tr></table>");

			br.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' cellpadding='1px' cellspacing='1px'>");
			br.append("<tr>");
			br.append("<td class='multiLabel' WIDTH='15%' align='CENTER'>Return Date</td>");
			br.append("<td class='multiLabel' WIDTH='20%' align='CENTER'>Return No</td>");
			br.append("<td class='multiLabel' WIDTH='20%' align='CENTER'>Requesting Store</td>");
			br.append("<td class='multiLabel' WIDTH='20%' align='CENTER'>Request No</td>");
			br.append("<td class='multiLabel' WIDTH='15%' align='CENTER'>Request Date</td>");
			br.append("<td class='multiLabel' WIDTH='10%' align='CENTER'>#</td>");
			br.append("</tr>");

			if (wb.size() != 0) {

				while (wb.next()) {
					strReturnDate = wb.getString(2);
					strReturnNo = wb.getString(1);
					strIndentingStore = wb.getString(3);
					strIndentNo = wb.getString(4);
					strIndentDate = wb.getString(5);
					strReturnStoreId = wb.getString(6);

					br.append("<input type='hidden' name='strHlpReturnNo' id='strHlpReturnNo"
							+ i + "' value=" + strReturnNo + " />");
					br.append("<input type='hidden' name='strReturnStoreId' id='strReturnStoreId"
							+ i + "' value=" + strReturnStoreId + " />");
					br.append("<input type='hidden' name='strHlpIndentNo' id='strHlpIndentNo"
							+ i + "' value=" + strIndentNo + " />");
					br.append("<input type='hidden' name='strHlpIndentDate' id='strHlpIndentDate"
							+ i + "' value=" + strIndentDate + " />");
					br.append("<input type='hidden' name='strHlpReturnDate' id='strHlpReturnDate"
							+ i + "' value=" + strReturnDate + " />");

					br.append("<tr>");
					br.append("<td WIDTH='15%' CLASS='multiControl' >"
							+ strReturnDate + "</td>");
					br.append("<td WIDTH='20%' CLASS='multiControl' >");
					br.append("<input type='hidden' name='flag' id='flag" + i
							+ "' value=" + "0" + " />");
					br.append("<div class='popup' id='IssueItempopup' style='display: none'></div>");
					br.append("<input type='hidden' name='strIssueNo' id='strIssueNo"
							+ i + "' value=" + strReturnNo + " />");
					br.append("<a style='color:blue;font-family: Engravers MT,Helvetica,sans-serif;font-size:14px;' title='Issue No Item Details' onClick='showPopUp(this,\""
							+ i + "\");'>" + strReturnNo + "</a></td>");
					br.append("</td>");
					br.append("<td WIDTH='20%' CLASS='multiControl' >"
							+ strIndentingStore + "</td>");
					br.append("<td WIDTH='20%' CLASS='multiControl' >"
							+ strIndentNo + "</td>");
					br.append("<td WIDTH='15%' CLASS='multiControl' >"
							+ strIndentDate + "</td>");
					br.append("<td WIDTH='10%' CLASS='multiControl' ><img src='../../hisglobal/images/search_icon1.gif' onclick='generateIssueReportFunc(this,\""
							+ i
							+ "\");' style='cursor: pointer;' title='Print Return Item Details'></td>");

					br.append("</tr>");
					i++;
				}

				br.append("</table> ");
			} else {
				br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td  CLASS='multiControl' colspan='5'>"
						+ "No Record Found" + "</td>");
				br.append("</tr>");
				br.append("</table> ");
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
	public static String getPopUpInfo(WebRowSet wb, String index,
			String requestNo) {
		StringBuffer br = null;
		String strItemName = "";
		String strBatchNo = "";
		String strReqQty = "";
		String strIssueQty = "";

		try {
			br = new StringBuffer();

			br.append("<table width='400' align='center' cellpadding='1px' cellspacing='1px'>");
			br.append("<tr class='HEADER' align='left'><td style='color:blue;cursor:pointer;cursor:pointer;font-family: Arial, Helvetica, sans-serif;font-size:13px;'>Ret.No.&nbsp;"
					+ requestNo + "&nbsp;::::&nbsp;Details</td> ");
			br.append("<td align='right'><img style='cursor: pointer; '  src='../../hisglobal/images/popUp_cancel.JPG' title='To Close PopUp Window' align='middle' onclick='hide_popup_menu(\"IssueItempopup\");'> </td></tr>");
			br.append("</tr>");
			br.append("</table> ");

			br.append("<table width='400' align='center' bgcolor='black'  border='0'  cellspacing ='1px'>");
			br.append("<tr>");
			br.append("<td class='multiLabel' WIDTH='30%' >Item Name</td>");
			br.append("<td class='multiLabel' WIDTH='30%' >Batch No.</td>");
			br.append("<td class='multiLabel' WIDTH='20%' >Req Qty.</td>");
			br.append("<td class='multiLabel' WIDTH='20%' >Issued Qty.</td>");
			br.append("</tr>");
			br.append("</table> ");
			br.append("<table width='400' align='center' bgcolor='#6097BC'  border='0'  cellspacing ='1px'>");

			if (wb != null && wb.size() != 0) {
				while (wb.next())

				{
					strItemName = wb.getString(7);
					strBatchNo = wb.getString(8);
					strReqQty = wb.getString(9);
					strIssueQty = wb.getString(11);

					if (strItemName == null || strItemName.equals("null"))
						strItemName = "-----";
					if (strBatchNo == null || strBatchNo.equals("null"))
						strBatchNo = "----";
					if (strReqQty == null || strReqQty.equals("null"))
						strReqQty = "----";
					if (strIssueQty == null || strIssueQty.equals("null"))
						strIssueQty = "----";

					br.append("<tr>");
					br.append("<td WIDTH='30%' CLASS='multiControl' >"
							+ strItemName + "</td>");
					br.append("<td WIDTH='30%' CLASS='multiControl' >"
							+ strBatchNo + "</td>");
					br.append("<td WIDTH='20%' CLASS='multiControl' >"
							+ strReqQty + "</td>");
					br.append("<td WIDTH='20%' CLASS='multiControl' >"
							+ strIssueQty + "</td>");
					br.append("</tr>");
					i++;
				}
				br.append("</table>");
				br.append("<table width='400' align='center'  border='0'  cellspacing ='1px'>");
				br.append("<tr class='FOOTER'><td colspan='6'></td></tr>");
				br.append("</table>");
			} else {
				br.append("<tr>");
				br.append("<td colspan='6'  CLASS='multiControl' ><DIV class='errMsg' align='center'> NO RECORD FOUND</div></td>");
				br.append("</tr>");
				br.append("</table> ");
			}

			br.append("@");
			br.append(index);

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}

		return br.toString();

	}

}
