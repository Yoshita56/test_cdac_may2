package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;

import javax.sql.rowset.WebRowSet;

import mms.transactions.controller.fb.PhyStockVerificationTransFB;

public class PhyStockVerificationTransHLP {

	/*
	 * public static String getItemDetails(WebRowSet ws) { StringBuffer sBuffer
	 * = new StringBuffer("");
	 * 
	 * // StringBuffer sb=new StringBuffer(); // StringBuffer hyp=new
	 * StringBuffer();
	 * 
	 * 
	 * int start = 1; // int temp,count,ppr=10; final int REC_PER_PAGE = 10;
	 * final int PAGE_PER_BLOCK = 10;
	 * 
	 * int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1; int
	 * totalRecordsToManipulate = totalFetchRecord - 1;
	 * 
	 * 
	 * try {
	 * 
	 * 
	 * if(ws.size() != 0 || !ws.equals(null)) {
	 * 
	 * 
	 * int actualFetchRecord = ws.size();
	 * 
	 * if(totalFetchRecord != actualFetchRecord) { totalFetchRecord =
	 * actualFetchRecord; totalRecordsToManipulate = actualFetchRecord; }
	 * 
	 * int totalLayer = totalRecordsToManipulate / REC_PER_PAGE; int reminder =
	 * totalRecordsToManipulate % REC_PER_PAGE;
	 * 
	 * if (reminder > 0)
	 * 
	 * totalLayer = totalLayer + 1;
	 * 
	 * sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' >"
	 * );
	 * 
	 * sBuffer.append("<tr>"); sBuffer.append("<td class='LABEL'>");
	 * 
	 * for (int i = 1; i <= totalLayer; i++) { sBuffer.append(
	 * "<a STYLE='cursor:pointer;cursor:pointer;' color:'blue' onClick='GetIndex(\""
	 * +i+"\",\""+totalLayer+"\")'>" + (i+start-1) + "</a> &nbsp;"); }
	 * 
	 * sBuffer.append("</td>"); sBuffer.append("</tr>");
	 * sBuffer.append("</table>");
	 * 
	 * 
	 * sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' >"
	 * );
	 * 
	 * sBuffer.append("<tr>");
	 * 
	 * sBuffer.append("<td width='4%'  class='multiLabel'>#</td>");
	 * sBuffer.append(
	 * "<td width='15%' class='multiLabel'><div align='center'>Item Name</div></td>"
	 * ); sBuffer.append(
	 * "<td width='15%' class='multiLabel'><div align='center'>Stock In Hand</div></td>"
	 * ); sBuffer.append(
	 * "<td width='15%' class='multiLabel'><div align='center'>Rate/Unit</div></td>"
	 * ); sBuffer.append(
	 * "<td width='15%' class='multiLabel'><div align='center'>Counted Qty</div></td>"
	 * ); sBuffer.append(
	 * "<td width='12%' class='multiLabel'><div align='center'>Variance(+/-)</div></td>"
	 * ); sBuffer.append(
	 * "<td width='12%' class='multiLabel'><div align='center'>Variance Cost</div></td>"
	 * ); sBuffer.append("<td width='12%' class='multiLabel'>Status</td>");
	 * 
	 * sBuffer.append("</tr>"); sBuffer.append("</table>");
	 * 
	 * 
	 * for (int i = 1; i <= totalLayer; i++) { if (i < totalLayer) { if (i == 1)
	 * { sBuffer.append("<div id='DivId" +i+ "' style='display:block'>"); } else
	 * { sBuffer.append("<div id='DivId" +i+ "' style='display:none'>"); }
	 * 
	 * 
	 * sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' >"
	 * ); for (int j = 0; j < REC_PER_PAGE; j++) { ws.next();
	 * 
	 * String strItemName = ws.getString(1); String strStockInHand =
	 * ws.getString(2); String strRateUnit = ws.getString(3); String strStoreId
	 * = ws.getString(1); String strItemId = ws.getString(2); String
	 * strItemBrandId = ws.getString(3); String strUnitId = ws.getString(2);
	 * String strPhyStockNo = ws.getString(3);
	 * 
	 * String strChkItemValue =
	 * strStoreId+"^"+strItemId+"^"+strItemBrandId+"^"+strPhyStockNo
	 * +"^"+strUnitId+"^"+strItemName+"^"+strRateUnit+"^"+i;
	 * 
	 * if(strItemName == null || strItemName.equals("null") ||
	 * strItemName.equals(""))strItemName = "---"; if(strStockInHand == null ||
	 * strStockInHand.equals("null") || strStockInHand.equals("")
	 * )strStockInHand = "---"; if(strRateUnit == null ||
	 * strRateUnit.equals("null") || strRateUnit.equals(""))strRateUnit = "---";
	 * 
	 * 
	 * sBuffer.append("<tr>");
	 * 
	 * sBuffer.append(
	 * "<input type = 'hidden' name='strChkItemDtlTmp' id='strChkItemDtlTmp"
	 * +j+"' value='"+strChkItemValue+"' >");
	 * 
	 * sBuffer.append(
	 * "<td width='4%'  class='multiControl'><input type = 'checkbox' name='strChkItemDtl' id='strChkItemDtl"
	 * +i+"' value='"+strChkItemValue+"' onclick=''></td>");
	 * sBuffer.append("<td width='14%' class='multiControl'>"
	 * +strItemName+"</td>");
	 * sBuffer.append("<td width='14%' class='multiControl'>"
	 * +strStockInHand+"</td>");
	 * sBuffer.append("<td width='14%' class='multiControl'>"
	 * +strRateUnit+"</td>");
	 * sBuffer.append("<td width='14%' class='multiControl'><div id='plus"+j+
	 * "'><img src='../../hisglobal/images/plus.gif' style='cursor:pointer;cursor:pointer' onclick='onCounQtyAjax(\""
	 * +i+"\");'></div></td>");
	 * sBuffer.append("<td width='13%' class='multiControl'><div id='variance"
	 * +j+
	 * "'><input type='text' value='0' name='strVariance' class='txtFldMin'></div></td>"
	 * );
	 * sBuffer.append("<td width='12%' class='multiControl'><div id='varianceCost"
	 * +j+
	 * "'><input type='text' value='0' name='strVarianceCost' class='txtFldMin'></div></td>"
	 * );
	 * sBuffer.append("<td width='11%' class='multiControl'><div id='status"+j
	 * +"'></div></td>");
	 * 
	 * sBuffer.append("</tr>"); } sBuffer.append("</table>");
	 * sBuffer.append("</div>"); } else { sBuffer.append("<div id='DivId" + i+
	 * "' style='display:block'>");
	 * 
	 * sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' >"
	 * ); for (int k = 0; k < reminder; k++) { ws.next();
	 * 
	 * String strItemName = ws.getString(1); String strStockInHand =
	 * ws.getString(2); String strRateUnit = ws.getString(3); String strStoreId
	 * = ws.getString(1); String strItemId = ws.getString(2); String
	 * strItemBrandId = ws.getString(3); String strUnitId = ws.getString(2);
	 * String strPhyStockNo = ws.getString(3);
	 * 
	 * String strChkItemValue =
	 * strStoreId+"^"+strItemId+"^"+strItemBrandId+"^"+strPhyStockNo
	 * +"^"+strUnitId+"^"+strItemName+"^"+strRateUnit+"^"+i;
	 * 
	 * if(strItemName == null || strItemName.equals("null") ||
	 * strItemName.equals(""))strItemName = "---"; if(strStockInHand == null ||
	 * strStockInHand.equals("null") || strStockInHand.equals("")
	 * )strStockInHand = "---"; if(strRateUnit == null ||
	 * strRateUnit.equals("null") || strRateUnit.equals(""))strRateUnit = "---";
	 * 
	 * 
	 * sBuffer.append("<tr>");
	 * 
	 * sBuffer.append(
	 * "<input type = 'hidden' name='strChkItemDtlTmp' id='strChkItemDtlTmp"
	 * +k+"' value='"+strChkItemValue+"' >");
	 * 
	 * sBuffer.append(
	 * "<td width='4%'  class='multiControl'><input type = 'checkbox' name='strChkItemDtl' id='strChkItemDtl"
	 * +i+"' value='"+strChkItemValue+"' onclick=''></td>");
	 * sBuffer.append("<td width='14%' class='multiControl'>"
	 * +strItemName+"</td>");
	 * sBuffer.append("<td width='14%' class='multiControl'>"
	 * +strStockInHand+"</td>");
	 * sBuffer.append("<td width='14%' class='multiControl'>"
	 * +strRateUnit+"</td>");
	 * sBuffer.append("<td width='14%' class='multiControl'><div id='plus"+k+
	 * "'><img src='../../hisglobal/images/plus.gif' style='cursor:pointer;cursor:pointer' onclick='onCounQtyAjax(\""
	 * +i+"\");'></div></td>");
	 * sBuffer.append("<td width='13%' class='multiControl'><div id='variance"
	 * +k+
	 * "'><input type='text' value='0' name='strVariance' class='txtFldMin'></div></td>"
	 * );
	 * sBuffer.append("<td width='12%' class='multiControl'><div id='varianceCost"
	 * +k+
	 * "'><input type='text' value='0' name='strVarianceCost' class='txtFldMin'></div></td>"
	 * );
	 * sBuffer.append("<td width='11%' class='multiControl'><div id='status"+k
	 * +"'></div></td>");
	 * 
	 * sBuffer.append("</tr>"); } sBuffer.append("</table>");
	 * sBuffer.append("</div>"); } } } } catch(Exception e) {
	 * e.printStackTrace(); new
	 * HisException("Physical Stock Verification Transaction"
	 * ,"PhyStockVerificationTransHLP.getItemDetails()-->",e.getMessage()); }
	 * return sBuffer.toString(); }
	 */

	public static String getItemDetails(WebRowSet ws, String strFromRow,
			String strBlockSet, String strRecPerPage) {

		String strColor = "red";
		String defaultColor = "red";

		StringBuffer sb = new StringBuffer("");

		try {

			int start = Integer.parseInt(strFromRow);
			int actualBlockSet = Integer.parseInt(strBlockSet);

			final int REC_PER_PAGE = Integer.parseInt(strRecPerPage);
			final int PAGE_PER_BLOCK = 10;

			int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
			int totalRecordsToManipulate = totalFetchRecord - 1;

			int previous = 1;
			int next = 0;

			if (ws != null && ws.size() > 0) {

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

				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");

				sb.append("<tr>");
				sb.append("<td class='LABEL'>&nbsp;");

				if (start != 1) {
					sb.append("<a STYLE='CURSOR:POINTER'  onClick='fetchPatientList(\""
							+ previous
							+ "\",\""
							+ (actualBlockSet - 1)
							+ "\");'> <FONT COLOR='"
							+ strColor
							+ "'> &lt;&lt; Previous</FONT> </a> &nbsp;");

				}
				for (int i = 1; i <= totalLayer; i++) {

					if (i == 1) {
						sb.append("<a STYLE='CURSOR:POINTER; color:" + strColor
								+ "' name='linId' id='linId" + i
								+ "' onClick='layerIndexNavigator(\"" + i
								+ "\",\"" + totalLayer + "\")'>");
						sb.append((i + start - 1));

					} else {
						sb.append("<a STYLE='CURSOR:POINTER; color:"
								+ defaultColor + "' name='linId' id='linId" + i
								+ "' onClick='layerIndexNavigator(\"" + i
								+ "\",\"" + totalLayer + "\")'>");
						sb.append((i + start - 1));
					}
					sb.append("</a> &nbsp;");
				}

				if (next > 0)
					sb.append("<a STYLE='CURSOR:POINTER' onClick='fetchPatientList(\""
							+ next
							+ "\",\""
							+ (actualBlockSet + 1)
							+ "\");'> <FONT COLOR='"
							+ strColor
							+ "'> Next &gt;&gt;</FONT></a>");

				sb.append("</td>");
				sb.append("</tr>");
				sb.append("</table>");

				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' >");

				sb.append("<tr>");

				sb.append("<td width='4%'  class='multiLabel'>#</td>");
				sb.append("<td width='15%' class='multiLabel'><div align='center'>Item Name</div></td>");
				sb.append("<td width='15%' class='multiLabel'><div align='center'>Stock In Hand</div></td>");
				sb.append("<td width='15%' class='multiLabel'><div align='center'>Rate/Unit</div></td>");
				sb.append("<td width='15%' class='multiLabel'><div align='center'>Counted Qty</div></td>");
				sb.append("<td width='12%' class='multiLabel'><div align='center'>Variance (+/-)</div></td>");
				sb.append("<td width='12%' class='multiLabel'><div align='center'>Variance Cost</div></td>");
				sb.append("<td width='12%' class='multiLabel'>Status</td>");

				sb.append("</tr>");
				sb.append("</table>");

				for (int i = 1; i <= totalLayer; i++) {

					if (i < totalLayer || (i == totalLayer && reminder == 0)) {
						if (i == 1) {
							sb.append("<div id='tariffDivId" + i
									+ "' style='display:block'>");
						} else {
							sb.append("<div id='tariffDivId" + i
									+ "' style='display:none'>");
						}

						sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
						for (int j = 0; j < REC_PER_PAGE; j++) {
							ws.next();

							String strStoreId = ws.getString(1);
							String strPhyStockNo = ws.getString(2);
							String strItemId = ws.getString(3);
							String strItemName = ws.getString(4);
							String strItemBrandId = ws.getString(5);
							String strRateUnit = ws.getString(8);
							String strUnitId = ws.getString(9);
							String strBaseUnitVal = ws.getString(10);
							String strStockInHand = ws.getString(11);

							String strChkItemValue = strStoreId + "^"
									+ strItemId + "^" + strItemBrandId + "^"
									+ strPhyStockNo + "^" + strUnitId + "^"
									+ strItemName + "^" + strRateUnit + "^"
									+ strBaseUnitVal + "^" + i;

							if (strItemName == null
									|| strItemName.equals("null")
									|| strItemName.equals(""))
								strItemName = "---";
							if (strStockInHand == null
									|| strStockInHand.equals("null")
									|| strStockInHand.equals(""))
								strStockInHand = "---";
							if (strRateUnit == null
									|| strRateUnit.equals("null")
									|| strRateUnit.equals(""))
								strRateUnit = "---";

							sb.append("<tr>");

							sb.append("<input type = 'hidden' name='strChkItemDtlTmp' id='strChkItemDtlTmp"
									+ i + "' value='" + strChkItemValue + "' >");

							sb.append("<td width='4%'  class='multiControl'><input type = 'checkbox' name='strChkItemDtl' id='strChkItemDtl"
									+ i
									+ "' value='"
									+ strChkItemValue
									+ "' onclick='resetItemStockDtls(this, \""
									+ i + "\");'></td>");
							sb.append("<td width='15%' class='multiControl'>"
									+ strItemName + "</td>");
							sb.append("<td width='15%' class='multiControl'>"
									+ strStockInHand + "</td>");
							sb.append("<td width='15%' class='multiControl'>"
									+ strRateUnit + "</td>");
							sb.append("<td width='15%' class='multiControl'><div id='plus"
									+ i
									+ "'><img src='../../hisglobal/images/plus.gif' style='cursor:pointer;cursor:pointer' onclick='onCounQtyAjax(\""
									+ i + "\");'></div></td>");
							sb.append("<td width='12%' class='multiControl'><input type='hidden' value='0' name='strVariance' id='strVariance"
									+ i
									+ "' class='txtFldMin'><div id='variance"
									+ i + "'>0</div></td>");
							sb.append("<td width='12%' class='multiControl'><input type='hidden' value='0' name='strVarianceCost' id='strVarianceCost"
									+ i
									+ "' class='txtFldMin'><div id='varianceCost"
									+ i + "'>0.00</div></td>");
							sb.append("<td width='12%' class='multiControl'><b><div id='status"
									+ i + "'></div></b></td>");

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
						sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
						for (int k = 0; k < reminder; k++) {
							ws.next();

							String strStoreId = ws.getString(1);
							String strPhyStockNo = ws.getString(2);
							String strItemId = ws.getString(3);
							String strItemName = ws.getString(4);
							String strItemBrandId = ws.getString(5);
							String strRateUnit = ws.getString(8);
							String strUnitId = ws.getString(9);
							String strBaseUnitVal = ws.getString(10);
							String strStockInHand = ws.getString(11);
							String strUnitName = ws.getString(12);

							String strChkItemValue = strStoreId + "^"
									+ strItemId + "^" + strItemBrandId + "^"
									+ strPhyStockNo + "^" + strUnitId + "^"
									+ strItemName + "^" + strRateUnit + "^"
									+ strBaseUnitVal + "^" + i;

							if (strItemName == null
									|| strItemName.equals("null")
									|| strItemName.equals(""))
								strItemName = "---";
							if (strStockInHand == null
									|| strStockInHand.equals("null")
									|| strStockInHand.equals(""))
								strStockInHand = "---";
							if (strRateUnit == null
									|| strRateUnit.equals("null")
									|| strRateUnit.equals(""))
								strRateUnit = "---";
							if (strUnitName == null
									|| strUnitName.equals("null")
									|| strUnitName.equals(""))
								strUnitName = "---";

							sb.append("<tr>");

							sb.append("<input type = 'hidden' name='strChkItemDtlTmp' id='strChkItemDtlTmp"
									+ i + "' value='" + strChkItemValue + "' >");

							sb.append("<td width='4%'  class='multiControl'><input type = 'checkbox' name='strChkItemDtl' id='strChkItemDtl"
									+ i
									+ "' value='"
									+ strChkItemValue
									+ "' onclick='resetItemStockDtls(this, \""
									+ i + "\");'></td>");
							sb.append("<td width='15%' class='multiControl'>"
									+ strItemName + "</td>");
							sb.append("<td width='15%' class='multiControl'>"
									+ strStockInHand + "</td>");
							sb.append("<td width='15%' class='multiControl'>"
									+ strRateUnit + "/" + strUnitName + "</td>");
							sb.append("<td width='15%' class='multiControl'><div id='plus"
									+ i
									+ "'><img src='../../hisglobal/images/plus.gif' style='cursor:pointer;cursor:pointer' onclick='onCounQtyAjax(\""
									+ i + "\");'></div></td>");
							sb.append("<td width='12%' class='multiControl'><input type='hidden' value='0' name='strVariance' id='strVariance"
									+ i
									+ "' class='txtFldMin'><div id='variance"
									+ i + "'>0</div></td>");
							sb.append("<td width='12%' class='multiControl'><input type='hidden' value='0' name='strVarianceCost' id='strVarianceCost"
									+ i
									+ "' class='txtFldMin'><div id='varianceCost"
									+ i + "'>0.00</div></td>");
							sb.append("<td width='12%' class='multiControl'><b><div id='status"
									+ i + "'></div></b></td>");

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
				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				sb.append("<tr><td class='multiControl'><font color='red'>No Record Found</font></td></tr>");
				sb.append("</table>");
			}

		} catch (Exception e) {
			new HisException("Global Patient Listing",
					"billing.HLPBilling.getPatientListingView()-->",
					e.getMessage());
		}

		return sb.toString();

	}

	public static String getPreviousDTL(WebRowSet ws, String index) {
		String strBrandName = null;
		String strBatchSlNo = null;
		String strStockInHand = null;
		String strCountedQty = null;

		String strHidden = null;

		StringBuffer sb = new StringBuffer("");

		try {

			sb.append("<table width='500' align='center' border='0' cellpadding='1px' cellspacing ='1px'>");
			sb.append("<tr ><td colspan='5' class='TITLE'>Previous Details&gt;&gt;</td></tr>");
			sb.append("<tr><td width='10%' class='multiLabel'>Delete</td>");
			sb.append("<td width='25%' class='multiLabel'>Brand Name</td>");
			sb.append("<td width='25%' class='multiLabel'>Batch/SlNo</td>");
			sb.append("<td width='20%' class='multiLabel'>Stock In Hand</td>");
			sb.append("<td width='20%' class='multiLabel'>Counted Qty</td>");
			sb.append("</tr>");

			if (ws != null && ws.size() > 0) {
				for (int i = 0; ws.next(); i++) {

					strHidden = ws.getString(1);
					strBrandName = ws.getString(2);
					strBatchSlNo = ws.getString(3);
					strStockInHand = ws.getString(4);
					strCountedQty = ws.getString(5);

					if (strBrandName == null || strBrandName.equals(""))
						strBrandName = "-----";
					if (strBatchSlNo == null || strBatchSlNo.equals(""))
						strBatchSlNo = "-----";
					if (strStockInHand == null || strStockInHand.equals(""))
						strStockInHand = "-----";
					if (strCountedQty == null || strCountedQty.equals(""))
						strCountedQty = "-----";

					sb.append("<input type='hidden' name='countedQty' id='countedQty"
							+ i + "' value='" + strCountedQty + "'>");
					sb.append("<input type='hidden' name='stockInHand' id='stockInHand"
							+ i + "' value='" + strStockInHand + "'>");
					sb.append("<input type='hidden' name='flag' id='flag" + i
							+ "' value='" + strHidden + "'>");
					sb.append("<input type='hidden' name='strChkCountedDtlTmp' id='strChkCountedDtlTmp"
							+ i + "' value='" + strHidden + "'>");
					sb.append("<tr>");
					sb.append("<td width='10%' class='multiControl'><b>");
					sb.append("<input type='checkbox' name='strChkCountedDtl' id='strChkCountedDtl"
							+ i + "'  value='" + strHidden + "'>");
					sb.append("</b></td>");
					sb.append("<td width='25%' class='multiControl'>");
					sb.append(strBrandName);
					sb.append("</td>");
					sb.append("<td width='25%' class='multiControl'>");
					sb.append(strBatchSlNo);
					sb.append("</td>");
					sb.append("<td width='20%' class='multiControl'>");
					sb.append(strStockInHand);
					sb.append("</td>");
					sb.append("<td width='20%' class='multiControl'>");
					sb.append(strCountedQty);
					sb.append("</td>");

					sb.append("</tr></table>");
				}

			} else {

				sb.append("<table width='500' align='center' border='0' cellpadding='1px' cellspacing ='1px'>");
				sb.append("<tr ><td colspan='5' class='multiControl'><font style='color:red'>No Previous Record Available</red></td></tr>");
				sb.append("</table>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}

		return sb.toString();
	}

	public static String getCountedItemDetails(WebRowSet ws,
			String strRecPerPage) {

		String strColor = "red";
		String defaultColor = "red";

		StringBuffer sb = new StringBuffer("");

		try {

			final int REC_PER_PAGE = Integer.parseInt(strRecPerPage);
			final int PAGE_PER_BLOCK = 10;

			int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
			int totalRecordsToManipulate = totalFetchRecord;

			if (ws != null && ws.size() > 0) {

				int actualFetchRecord = ws.size();

				if (totalFetchRecord != actualFetchRecord) {

					totalFetchRecord = actualFetchRecord;
					totalRecordsToManipulate = actualFetchRecord;

				}

				int totalLayer = totalRecordsToManipulate / REC_PER_PAGE;
				int reminder = totalRecordsToManipulate % REC_PER_PAGE;

				if (reminder > 0)
					totalLayer = totalLayer + 1;

				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");

				sb.append("<tr>");
				sb.append("<td class='LABEL'>&nbsp;");

				for (int i = 1; i <= totalLayer; i++) {

					if (i == 1) {
						sb.append("<a STYLE='CURSOR:POINTER; color:" + strColor
								+ "' name='linId' id='linId" + i
								+ "' onClick='layerIndexNavigator(\"" + i
								+ "\",\"" + totalLayer + "\")'>");
						sb.append((i));

					} else {
						sb.append("<a STYLE='CURSOR:POINTER; color:"
								+ defaultColor + "' name='linId' id='linId" + i
								+ "' onClick='layerIndexNavigator(\"" + i
								+ "\",\"" + totalLayer + "\")'>");
						sb.append((i));
					}
					sb.append("</a> &nbsp;");
				}

				sb.append("</td>");
				sb.append("</tr>");
				sb.append("</table>");

				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' >");

				sb.append("<tr>");

				sb.append("<td class='multiLabel' width='15%'>");
				sb.append("</td>");
				sb.append("<td class='multiLabel' width='20%'>Item");
				sb.append("</td>");
				sb.append("<td class='multiLabel' width='10%'>Avl. Qty.");
				sb.append("</td>");
				sb.append("<td class='multiLabel' width='10%'>Tolerance Limit");
				sb.append("</td>");
				sb.append("<td class='multiLabel' width='10%'>Counted Qty.");
				sb.append("</td>");
				sb.append("<td class='multiLabel' width='10%'>Variance");
				sb.append("</td>");
				sb.append("<td class='multiLabel' width='15%'>Variance Cost");
				sb.append("</td>");
				sb.append("<td class='multiLabel' width='10%'>Batch Details");
				sb.append("</td>");

				sb.append("</tr>");
				sb.append("</table>");

				for (int i = 1; i <= totalLayer; i++) {

					if (i < totalLayer || (i == totalLayer && reminder == 0)) {
						if (i == 1) {
							sb.append("<div id='tariffDivId" + i
									+ "' style='display:block'>");
						} else {
							sb.append("<div id='tariffDivId" + i
									+ "' style='display:none'>");
						}

						sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
						for (int j = 0; j < REC_PER_PAGE; j++) {
							ws.next();

							String strItemName = ws.getString(1);
							String strAvlQty = ws.getString(2);
							String strToleranceLimit = ws.getString(6);
							String strCountedQty = ws.getString(7);
							String strVariance = ws.getString(11);
							String strVarianceCost = ws.getString(15);

							String strGenericItemId = ws.getString(16);
							String strItemId = ws.getString(17);

							/*
							 * ItemId^brandId^InhandQty^InhandQtyUnit^
							 * InHandQtyInBaseVal^
							 * ToleranceLimit^CountedQty^CountedQtyUnit
							 * ^CountedQtyInBaseVal^
							 * VarientQty^VarientQtyUnit^VarientQtyInBaseVal
							 * ^VarientCost
							 */

							String strHiddenVal = ws.getString(16) + "^"
									+ ws.getString(17) + "^" + ws.getString(3)
									+ "^" + ws.getString(4) + "^"
									+ ws.getString(5) + "^" + ws.getString(6)
									+ "^" + ws.getString(8) + "^"
									+ ws.getString(9) + "^" + ws.getString(10)
									+ "^" + ws.getString(12) + "^"
									+ ws.getString(13) + "^" + ws.getString(14)
									+ "^" + ws.getString(15);

							if (strItemName == null
									|| strItemName.equals("null")
									|| strItemName.equals(""))
								strItemName = "---";
							if (strAvlQty == null || strAvlQty.equals("null")
									|| strAvlQty.trim().equals(""))
								strAvlQty = "---";
							if (strToleranceLimit == null
									|| strToleranceLimit.equals("null")
									|| strToleranceLimit.equals(""))
								strToleranceLimit = "---";
							if (strCountedQty == null
									|| strCountedQty.equals("null")
									|| strCountedQty.trim().equals(""))
								strCountedQty = "---";
							if (strVariance == null
									|| strVariance.equals("null")
									|| strVariance.trim().equals(""))
								strVariance = "---";
							if (strVarianceCost == null
									|| strVarianceCost.equals("null")
									|| strVarianceCost.trim().equals(""))
								strVarianceCost = "---";

							sb.append("<tr>");

							sb.append("<td class='multiControl' width='15%'> <select class='comboMin' name='strCountedDtls' id='strCountedDtls"
									+ i
									+ ""
									+ j
									+ "'><option value='0'>Select Value</option><option value='2'>Cancel</option></select>");
							sb.append("</td>");
							sb.append("<td class='multiControl' width='20%'>")
									.append(strItemName);
							sb.append("<input type='hidden' name='strCountedItemDtls' id='strCountedItemDtls"
									+ i
									+ ""
									+ j
									+ "' value='"
									+ strHiddenVal
									+ "'></td>");
							sb.append("<td class='multiControl' width='10%'>")
									.append(strAvlQty);
							sb.append("</td>");
							sb.append("<td class='multiControl' width='10%'>")
									.append(strToleranceLimit).append(" %");
							sb.append("</td>");
							sb.append(
									"<td class='multiControl' width='10%'><div id='countedQtyDivId"
											+ i + "" + j + "'>")
									.append(strCountedQty).append("<div>");
							sb.append("</td>");
							sb.append(
									"<td class='multiControl' width='10%'><div id='varianceQtyDivId"
											+ i + "" + j + "'>")
									.append(strVariance).append("<div>");
							sb.append("</td>");
							sb.append(
									"<td class='multiControl' width='15%'><div id='varianceCostDivId"
											+ i + "" + j + "'>")
									.append(strVarianceCost).append("<div>");
							sb.append("<input type='hidden' name='strVarianceCost' id='strVarianceCost"
									+ i
									+ ""
									+ j
									+ "' value='"
									+ strVarianceCost + "'></td>");
							sb.append("<td class='multiControl' width='10%'><img style='cursor:pointer;' src='../../hisglobal/images/viewDetails.gif' onclick='getCountedItemBatchDetails(this,\""
									+ strGenericItemId
									+ "\" , \""
									+ strItemId
									+ "\" , \"" + i + "" + j + "\");' >");
							sb.append("<input type='hidden' name='strCountedItemBatchDtls' id='strCountedItemBatchDtls"
									+ i + "" + j + "' value=''></td>");
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
						sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
						for (int k = 0; k < reminder; k++) {
							ws.next();

							String strItemName = ws.getString(1);
							String strAvlQty = ws.getString(2);
							String strToleranceLimit = ws.getString(6);
							String strCountedQty = ws.getString(7);
							String strVariance = ws.getString(11);
							String strVarianceCost = ws.getString(15);

							String strGenericItemId = ws.getString(16);
							String strItemId = ws.getString(17);

							/*
							 * ItemId^brandId^InhandQty^InhandQtyUnit^
							 * InHandQtyInBaseVal^
							 * ToleranceLimit^CountedQty^CountedQtyUnit
							 * ^CountedQtyInBaseVal^
							 * VarientQty^VarientQtyUnit^VarientQtyInBaseVal
							 * ^VarientCost
							 */

							String strHiddenVal = ws.getString(16) + "^"
									+ ws.getString(17) + "^" + ws.getString(3)
									+ "^" + ws.getString(4) + "^"
									+ ws.getString(5) + "^" + ws.getString(6)
									+ "^" + ws.getString(8) + "^"
									+ ws.getString(9) + "^" + ws.getString(10)
									+ "^" + ws.getString(12) + "^"
									+ ws.getString(13) + "^" + ws.getString(14)
									+ "^" + ws.getString(15);

							if (strItemName == null
									|| strItemName.equals("null")
									|| strItemName.equals(""))
								strItemName = "---";
							if (strAvlQty == null || strAvlQty.equals("null")
									|| strAvlQty.trim().equals(""))
								strAvlQty = "---";
							if (strToleranceLimit == null
									|| strToleranceLimit.equals("null")
									|| strToleranceLimit.equals(""))
								strToleranceLimit = "---";
							if (strCountedQty == null
									|| strCountedQty.equals("null")
									|| strCountedQty.trim().equals(""))
								strCountedQty = "---";
							if (strVariance == null
									|| strVariance.equals("null")
									|| strVariance.trim().equals(""))
								strVariance = "---";
							if (strVarianceCost == null
									|| strVarianceCost.equals("null")
									|| strVarianceCost.trim().equals(""))
								strVarianceCost = "---";

							sb.append("<tr>");

							sb.append("<td class='multiControl' width='15%'> <select class='comboMin' name='strCountedDtls' id='strCountedDtls"
									+ i
									+ ""
									+ k
									+ "'><option value='0'>Select Value</option><option value='1'>Cancel</option></select>");
							sb.append("</td>");
							sb.append("<td class='multiControl' width='20%'>")
									.append(strItemName);
							sb.append("<input type='hidden' name='strCountedItemDtls' id='strCountedItemDtls"
									+ i
									+ ""
									+ k
									+ "' value='"
									+ strHiddenVal
									+ "'></td>");
							sb.append("<td class='multiControl' width='10%'>")
									.append(strAvlQty);
							sb.append("</td>");
							sb.append("<td class='multiControl' width='10%'>")
									.append(strToleranceLimit).append(" %");
							sb.append("</td>");
							sb.append(
									"<td class='multiControl' width='10%'><div id='countedQtyDivId"
											+ i + "" + k + "'>")
									.append(strCountedQty).append("<div>");
							sb.append("</td>");
							sb.append(
									"<td class='multiControl' width='10%'><div id='varianceQtyDivId"
											+ i + "" + k + "'>")
									.append(strVariance).append("<div>");
							sb.append("</td>");
							sb.append(
									"<td class='multiControl' width='15%'><div id='varianceCostDivId"
											+ i + "" + k + "'>")
									.append(strVarianceCost).append("<div>");
							sb.append("<input type='hidden' name='strVarianceCost' id='strVarianceCost"
									+ i
									+ ""
									+ k
									+ "' value='"
									+ strVarianceCost + "'></td>");
							sb.append("<td class='multiControl' width='10%'><img style='cursor:pointer;' src='../../hisglobal/images/viewDetails.gif' onclick='getCountedItemBatchDetails(this,\""
									+ strGenericItemId
									+ "\" , \""
									+ strItemId
									+ "\" , \"" + i + "" + k + "\");' >");
							sb.append("<input type='hidden' name='strCountedItemBatchDtls' id='strCountedItemBatchDtls"
									+ i + "" + k + "' value=''></td>");
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
				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				sb.append("<tr><td class='multiControl'><font color='red'>No Record Found</font></td></tr>");
				sb.append("</table>");
			}

		} catch (Exception e) {
			e.printStackTrace();
			new HisException("Global Patient Listing",
					"billing.HLPBilling.getPatientListingView()-->",
					e.getMessage());
		}

		return sb.toString();

	}

	public static String createMemberDetails(
			PhyStockVerificationTransFB _PhyStockVerificationTransFB) {
		StringBuffer br = new StringBuffer();
		WebRowSet wb1 = null;
		int count = 0;
		try {
			wb1 = _PhyStockVerificationTransFB.getCommitteMemberWS();
			// System.out.println("wb1"+wb1.size());
			br.append("<table width='400'>\n");
			br.append("<tr class='HEADER'>\n");
			br.append("<td colspan='2'>Committee Member Details</td>");
			br.append("</tr>\n");
			br.append("<tr>\n");
			br.append("<td class='multiLabel'>\n");
			br.append("Committe Member Name");
			br.append("</td>");
			br.append("<td class='multiLabel'>\n");
			br.append("Recommendation");
			br.append("</td>");
			br.append("</tr>\n");

			if (wb1 != null && wb1.size() != 0) {

				while (wb1.next()) {
					br.append("<tr>\n");
					br.append("<td class='multiControl'>\n");
					br.append("<input type='hidden' name='strCommitteeMemberHidden' value='"
							+ wb1.getString(1)
							+ "' id='strCommitteeMemberHiddenId="
							+ (++count)
							+ "'/>");
					br.append(wb1.getString(2) + "</td>");
					br.append("<td class='multiControl'>\n");
					br.append("<textarea rows='2' cols='15' name='strMemberRecommendation'></textarea>");
					br.append("</td>");
					br.append("</tr>\n");
				}
			} else {
				br.append("<tr>\n");
				br.append("<td class='multiControl' colspan='2'>\n");
				br.append("No Record Found");
				br.append("</tr>\n");
			}

			br.append("<tr class='FOOTER'>");
			br.append("<td colspan='2' align ='center'></td>");
			br.append("</tr>");
			br.append("<tr>\n");
			br.append("<td  colspan='2' align='center'>\n");
			br.append("<img src='../../hisglobal/images/btn-ok.png' 	onClick='closePopUpDiv();' style='cursor: pointer;' title='Click Here To Save Remarks'>&nbsp;");
			br.append("<img src='../../hisglobal/images/btn-clr.png' onClick='clearData();' style='cursor: pointer;' title='Click Here To Clear Data'>&nbsp;");
			br.append("<img src='../../hisglobal/images/close_tab.png' onClick='closePopUpDiv();' style='cursor: pointer;' title='Click Here To Close Popup'>");
			br.append("</tr>\n");
			br.append("</table>");

		} catch (Exception e) {
			try {

				throw new Exception(
						"SampleRegisterTransHLP.PhyStockVerificationTransHLP--->"
								+ e.getMessage());
			} catch (Exception e1) {
			}
		} finally {
			wb1 = null;

		}
		return br.toString();
	}

}
