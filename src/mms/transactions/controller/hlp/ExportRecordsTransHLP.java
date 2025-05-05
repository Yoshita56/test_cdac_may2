package mms.transactions.controller.hlp;

import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import mms.transactions.controller.fb.ExportRecordsTransFB;
import mms.transactions.dao.ExportRecordsTransDAO;

import org.apache.commons.lang.NumberUtils;

public class ExportRecordsTransHLP {

	/**
	 * returns String of required Export Details in HTML format
	 * 
	 * @param ws -
	 *            Required Contents in WebRowSet
	 * @param strHosptialCode -
	 *            hospital code
	 * @return String of required Export Details in HTML format
	 * @throws Exception
	 */
	public static String getTemplateDetails(WebRowSet ws, String strHosptialCode)
			throws Exception {

		StringBuffer sb = new StringBuffer("");

		StringBuffer sb2 = new StringBuffer("");

		boolean flag = true;

		sb.append("<table border='0' class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
		sb.append("<tr class='TITLE'>");
		sb.append("<td colspan='2'>Input Parameters ");
		sb.append("</td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td class='multiLabel' width='50%'>Parameter Name");
		sb.append("</td>");
		sb.append("<td class='multiLabel' width='50%'>Value");
		sb.append("</td>");
		sb.append("</tr>");
		sb2.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing='1px'>");
		sb2.append("<tr><td colspan='4' class='TITLE' width='25%'><div id='paramItemDtlsDivIdPlusId' align='left' style='display: block;'>");
		sb2.append("<img src='../../hisglobal/images/plus.gif'	onClick=showView('paramItemDtlsDivId'); style='cursor: pointer; ' />Export Parameter Details</div>");
		sb2.append("<div id='paramItemDtlsDivIdMinusId' style='display: none;' align='left'>");
		sb2.append("<img src='../../hisglobal/images/minus.gif' onClick=hideView('paramItemDtlsDivId'); style='cursor: pointer;' />Export Parameter Details</div>");
		sb2.append("</td>");
		sb2.append("</tr>");
		sb2.append("</table>");
		sb2.append("<div id='paramItemDtlsDivId' style='display: none;'>");
		sb2.append("<table border='0' class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
		sb2.append("<tr class='TITLE'>");
		sb2.append("<td colspan='4'>Export Parameters");
		sb2.append("</td>");
		sb2.append("</tr>");
		sb2.append("<tr>");
		sb2.append("<td class='multiLabel' width='10%'>");
		sb2.append("</td>");
		sb2.append("<td class='multiLabel' width='30%'>Column Index");
		sb2.append("</td>");
		sb2.append("<td class='multiLabel' width='40%'>Column Name");
		sb2.append("</td>");
		sb2.append("<td class='multiLabel' width='20%'>Grand Total");
		sb2.append("</td>");
		sb2.append("</tr>");

		int count = 0;

		try {

			if (ws != null && ws.size() > 0) {
				while (ws.next()) {

					count = count + 1;

					if (ws.getString(5).trim().equals("1")) {

						if (ws.getString(6).trim().equals("1")) {

							sb.append("<tr>");
							sb.append("<td class='multiControl' width='10%' >");
							sb.append(ws.getString(1));
							sb
									.append("<input type='hidden' name='strInParamName' value='"
											+ ws.getString(8) + "'>");
							
							sb
							.append("<input type='hidden' name='strArgName' value='"
									+ ws.getString(1) + "'></td>");
							
							sb.append("<td class='multiControl' width='30%' >");
							sb.append("");
							sb
									.append("<input type='text' class='txtFldMax' name='strInConstantValue' value=''></td>");
							sb.append("</tr>");

						} else if (ws.getString(6).trim().equals("2")) {

							sb.append("<tr>");
							sb.append("<td class='multiControl' width='40%' >");
							sb.append(ws.getString(1));
							sb
									.append("<input type='hidden' name='strInParamName' value='"
											+ ws.getString(8) + "'>");
							
							sb
							.append("<input type='hidden' name='strArgName' value='"
									+ ws.getString(1) + "'></td>");
							
							sb.append("<td class='multiControl' width='20%' >");

							if (ws.getString(7).toUpperCase().contains(
									"SELECT ")
									&& ws.getString(7).toUpperCase().contains(
											"FROM ")) {

								WebRowSet ws1 = ExportRecordsTransDAO
										.getResultSetForQuery(ws.getString(7),
												strHosptialCode);
								sb
										.append("<select name='strInConstantValue' class='comboMax'>");
								sb
										.append(new HisUtil(
												"ExportRecordsTransHLP",
												"ExportRecordsTransHLP.getTemplateDetails")
												.getOptionValue(ws1, "0",
														"0^Select Value", true));
								sb.append("</select>");
								sb.append("</tb>");

							} else {

								String content[] = ws.getString(7).split("#");

								sb
										.append("<select name='strInConstantValue' class='comboMax'>");
								for (int i = 0; i < content.length; i++) {

									String optionVals[] = content[i].replace(
											"^", "#").split("#");

									sb.append(
											"<option value='" + optionVals[0]
													+ "'>").append(
											optionVals[1]).append("</option>");

								}
								sb.append("</select>");
								sb.append("</tb>");
							}

							sb.append("</tr>");

						} else {

							// sb.append("<tr>");
							// sb.append("<td class='multiControl' width='50%'
							// >");
							// sb.append(ws.getString(1));
							sb
									.append("<input type='hidden' name='strInParamName' value='"
											+ ws.getString(8) + "'>");
							
							sb
							.append("<input type='hidden' name='strArgName' value='"
									+ ws.getString(1) + "'></td>");
							// sb.append("<td class='multiControl' width='50%'
							// >");
							// sb.append(ws.getString(4));
							sb
									.append("<input type='hidden' name='strInConstantValue' value='"
											+ ws.getString(4) + "'>"); // </td>");
							// sb.append("</tr>");
						}

					} else {

						if (flag) {

							sb.append("</table>");

							sb.append(sb2.toString());
							flag = false;

						}

						sb.append("<tr>");
						sb.append("<td class='multiControl' width='10%' >");

						sb
								.append("<input type='checkbox' name='strChkVal' checked='checked' onclick='enableValues(this, \""
										+ count + "\" );' >");

						sb
								.append("<input type='hidden' name='strOutParamName' id='strOutParamName"
										+ count
										+ "' value='"
										+ ws.getString(8)
										+ "'></td>");
						sb.append("<td class='multiControl'  width='10%' >");

						sb
								.append("<input type='text' name='strXlsColumnIndex' class='txtFldMin' maxlength='2' onkeypress='return validateData(event,5);' id='strXlsColumnIndex"
										+ count
										+ "' value='"
										+ ws.getString(2)
										+ "'></td>");
						sb.append("<td class='multiControl'  width='40%' >");
						sb.append(ws.getString(3));
						sb
								.append("<input type='hidden' name='strXlsColumnName' id='strXlsColumnName"
										+ count
										+ "' value='"
										+ ws.getString(3)
										+ "'></td>");
						sb.append("<td class='multiControl' width='40%' >");
						sb
								.append("<input type='checkbox' name='strIsGrandTotal' id='strIsGrandTotal"
										+ count
										+ "' value='1' onclick='changeGrandTotalStatus(this , \""
										+ count + "\")' >");

						sb
								.append("<input type='hidden' name='strGrandTotalStatus' id='strGrandTotalStatus"
										+ count + "' value='0'>");

						sb
								.append("<input type='hidden' name='strOutConstantValue' id='strOutConstantValue"
										+ count
										+ "' value='"
										+ ws.getString(4)
										+ "'> ");
						
						sb
						.append("<input type='hidden' name='strColumnWidth' id='strColumnWidth"
								+ count
								+ "' value='"
								+ ws.getString(9)
								+ "'> ");
						
						sb
						.append("<input type='hidden' name='strColumnWidthUnit' id='strColumnWidthUnit"
								+ count
								+ "' value='"
								+ ws.getString(10)
								+ "'> ");
						
						sb.append("</td>");
						sb.append("</tr>");

					}

				}

				sb.append("</table>");
				sb.append("</div>");

			} else {

				sb
						.append("<table border='0' class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
				sb.append("<tr>");
				sb
						.append("<td class='multiControl'  colspan='4' style='color:red'>No Detail(s) Available");
				sb.append("</td>");
				sb.append("</tr>");
				sb.append("</table>");

			}

		} catch (Exception e) {

			throw e;

		}

		return sb.toString();

	}

	/**
	 * Creates the Required Data's in HTML format and returns String
	 * 
	 * @param ws -
	 *            WebRowSet contains required contents
	 * @param strParamName -
	 *            Parameter Name's
	 * @param strXlsColumnName -
	 *            Column Header's
	 * @param strFooter -
	 *            Footer
	 * @param isGrandTotal -
	 *            whether the column should have total
	 * @param columnIndex -
	 *            Index of a column
	 * @return String of Required Export Data in HTML Format
	 * @throws Exception
	 */
	public static String exportHTML(String strReportName, WebRowSet ws, ExportRecordsTransFB formBean ) throws Exception {
 
		String[] strParamName = formBean.getStrOutParamName(); 
		String[] strXlsColumnName = formBean.getStrXlsColumnName(); 
		String strFooter = formBean.getStrFooter();
		String[] isGrandTotal = formBean.getStrGrandTotalStatus() ; 
		String[] columnIndex = formBean.getStrXlsColumnIndex();
		String[] strArgName = formBean.getStrArgName();
		String[] strArgValue = formBean.getStrInConstantValue();
		
		String strTableWidth = "100 %";
		
		String strIsBorderReq = formBean.getStrIsBorderReq();
		
		String[] strColumnWidth = formBean.getStrColumnWidth();
		String[] strColumnWidthUnit = formBean.getStrColumnWidthUnit();
		
		if(formBean.getStrTableWidth() != null && !formBean.getStrTableWidth().equals("null") && formBean.getStrTableWidth().trim().length() > 0 ){
			
			strTableWidth = formBean.getStrTableWidth();
			
			if(formBean.getStrTableWidthUnit() != null && !formBean.getStrTableWidthUnit().equals("0") ){
				
				if(formBean.getStrTableWidthUnit().equals("1")){
					
					strTableWidth = strTableWidth + "%";
				}else{
					
					strTableWidth = strTableWidth + "px";
					
				}
				 
				
			}
			
		}
		
		
		StringBuffer sb = null;
		String tempVal = "";
		String[] tempStr = null;

		String strUnitName[] = null;
		double strUnitTotal[] = null;
		
		if(isGrandTotal.length > 0){
			
			 strUnitName = new String[isGrandTotal.length];
			 strUnitTotal = new double[isGrandTotal.length];
			
		}
		

		boolean fUnitFlag = false;

		double[] dTotal = new double[strParamName.length];

		try {

			ResourceBundle res = mms.qryHandler_mms.res;
			if(res == null) 
			{
				res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
				mms.qryHandler_mms.res = res;
			}

			sb = new StringBuffer("");

			sb.append("<html><head><title></title></head><body>");
			sb.append("<table align='center' border='0' cellspacing='0px' cellpadding='0px' height='69' width='"+strTableWidth+"'> ");
			sb.append("<tr><td colspan='"+ strParamName.length 
							+ "' width='20%' align='right'><div align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Report Date and Time : "
							+ new SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
									.format(new Date())
							+ "</font></div></td></tr>");
			sb.append("<tr><td width='10%' align='left'><img src='../../hisglobal/images/Rmsc_Logo.png'></img></td><td colspan='"+ (strParamName.length - 1)
							+ "'  align='center'></td></tr>");
			sb.append("<tr><td colspan='"+ strParamName.length
							+ "'  align='center'><div align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
			sb.append(res.getString("REPORT_TITLE"));
			sb.append("</font></b></div></td>");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td colspan='"
							+ strParamName.length
							+ "' align='center'><div align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
			sb.append(res.getString("FULL_TITLE"));
			sb.append("</font></b></div></td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");

			sb.append("<td colspan='"
							+ strParamName.length
							+ "' align='center'><div align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
			sb.append(res.getString("CITY"));
			sb.append("</font></b></div></td></tr>");
			sb.append("</table> ");
			
			sb.append("<br/><table align='center' cellpadding='1px' cellspacing='1px' border='0' width='"+strTableWidth+"'>");

			sb.append("<tr>");
			sb.append("<td colspan='" + strParamName.length
					+ "' align='center'><div align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			sb.append(strReportName);
			sb.append("</font></b></div></td>");
			sb.append("</tr>");
			
			for(int j= 0; j < strArgName.length;j++)
			{
				
				if(!strArgName[j].trim().toUpperCase().equalsIgnoreCase("ERR") && !strArgName[j].trim().toUpperCase().equalsIgnoreCase("MODEVAL") && 
						!strArgName[j].trim().toUpperCase().equalsIgnoreCase("RESULTSET"))
				{
					tempStr = strArgValue[j].split("\\^");
					
					if(tempStr.length == 1)
						tempVal = tempStr[0];
					else
						tempVal = tempStr[1];
					
					sb.append("<tr>");
					sb.append("<td colspan='" + strParamName.length
							+ "' align='center'><div align='center'> <font face='Verdana, Arial, Helvetica, sans-serif' size='2'>");
					sb.append("<b>" + strArgName[j] + " : </b>" + tempVal);
					sb.append("</font></div></td>");
					sb.append("</tr>");
				}
			}
			
sb.append("</table> ");

if(strIsBorderReq.trim().equals("1")){
	
	sb
	.append("<br/><table align='center' cellpadding='1px' cellspacing='1px' style='border-collapse: collapse; empty-cells: show;' border='1px' width='"+strTableWidth+"'>");
	 
}else{
	
	sb
	.append("<br/><table align='center' cellpadding='1px' cellspacing='1px' border='0' width='"+strTableWidth+"'>");
}
 
			




			
		//	sb.append("<tr><td align='center' colspan='" + strParamName.length + "' ><br/> </td></tr>");
			sb.append("<tr>");
			sb.append("<td colspan='" + strParamName.length
					+ "' align='center' height='2px' bgcolor='#000000' ></td>");
			sb.append("</tr>");
			sb.append("<tr>");

			for (int i = 0; i < strXlsColumnName.length; i++) {

				String strColWidthVal = "20%";
				
				if(strColumnWidth[i] != null && !strColumnWidth[i].equals("null") && strColumnWidth[i].trim().length() > 0 ){
					
					strColWidthVal = strColumnWidth[i];
					
					if(strColumnWidthUnit[i] != null && !strColumnWidthUnit[i].equals("0") ){
						
						if(strColumnWidthUnit[i].equals("1")){
							
							strColWidthVal = strColWidthVal + "%";
						}else{
							
							strColWidthVal = strColWidthVal + "px";
							
						}
						 
						
					}
					
				}
				
				
				
				sb
						.append(
								"<td width='"+strColWidthVal+"' style='font:bold;' ><b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>")
						.append(
								strXlsColumnName[(Integer
										.parseInt(columnIndex[i]) - 1)])
						.append("</font></b></td>");

			}
			sb.append("</tr>");

			sb.append("<tr>");
			sb.append("<td colspan='" + strParamName.length
					+ "' align='center' height='2px' bgcolor='#000000' ></td>");
			sb.append("</tr>");

			if (ws != null && ws.size() > 0) {

				while (ws.next()) {
					 
					sb.append("<tr>");
					for (int i = 0; i < strParamName.length; i++) {

						String strColWidthVal = "20%";
						
						if(strColumnWidth[i] != null && strColumnWidth[i].trim().length() > 0 ){
							
							strColWidthVal = strColumnWidth[i];
							
							if(strColumnWidthUnit[i] != null && !strColumnWidthUnit[i].equals("0") ){
								
								if(strColumnWidthUnit[i].equals("1")){
									
									strColWidthVal = strColWidthVal + "%";
								}else{
									
									strColWidthVal = strColWidthVal + "px";
									
								}
								 
								
							}
							
						}
						
						
						
						String strParamValue = ws
								.getString(strParamName[(Integer
										.parseInt(columnIndex[i]) - 1)]);

						sb
								.append(
										"<td width='"+strColWidthVal+"' ><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>")
								.append(strParamValue).append("</font></td>");

						// Whether total is required
						if (Integer.parseInt(isGrandTotal[i]) == 1) {

							// whether value is numeric
							if (NumberUtils.isNumber(strParamValue)) {
								// if value is numeric find total
								dTotal[i] = dTotal[i]
										+ Double.parseDouble(strParamValue);

							} else {
								// if value is not numeric set the total as -1

								
								
								dTotal[i] = -1;
								
								
								if (strParamValue.trim().replace(" ", "#")
										.contains("#")) {

									String[] strVals = strParamValue.trim()
											.replace(" ", "#").split("#");

									if (strVals.length == 2) {

										if (NumberUtils.isNumber(strVals[0])
												&& !NumberUtils
														.isNumber(strVals[1])) {

											if (!fUnitFlag)strUnitName[i] = strVals[1];
												
									
												

											if (strUnitName[i]
													.equalsIgnoreCase(strVals[1])) {

												strUnitTotal[i] = strUnitTotal[i]
														+ Double.parseDouble(strVals[0]);

												dTotal[i] = strUnitTotal[i];

											}else{
												
												strUnitName[i] = "";
											}

										}

									}

								}

							}

						} else {
							// if total is not required set the value as -1
							dTotal[i] = -1;

						}

					}

					sb.append("</tr>");

					fUnitFlag = true;
					
				}

			} else {
				sb.append("<tr>");
				sb
						.append("<td colspan='"
								+ strParamName.length
								+ "' ><div align='center'><b><center>No Record(s) Available</center></b><div><br/></td>");
				sb.append("</tr>");
			}

			
			sb.append("<tr>");
			sb.append("<td colspan='" + strParamName.length
					+ "' align='center' height='2px' bgcolor='#000000' ></td>");
			sb.append("</tr>");

			sb.append("<tr>");

			boolean flag = false;

			for (int i = 0; i < isGrandTotal.length; i++) {
				
					if (Integer.valueOf(isGrandTotal[i]) == 1 && dTotal[i] > 0) {
 
						String strColWidthVal = "20%";
						
						if(strColumnWidth[i] != null && !strColumnWidth[i].equals("null") && strColumnWidth[i].trim().length() > 0 ){
							
							strColWidthVal = strColumnWidth[i];
							
							if(strColumnWidthUnit[i] != null && !strColumnWidthUnit[i].equals("0") ){
								
								if(strColumnWidthUnit[i].equals("1")){
									
									strColWidthVal = strColWidthVal + "%";
								}else{
									
									strColWidthVal = strColWidthVal + "px";
									
								}
								 
								
							}
							
						}
						
						
						
					sb
							.append(
									"<td width='"+strColWidthVal+"' ><b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>");
					
							sb.append(String.valueOf(dTotal[i]));
							
							
							if(strUnitName[i] != null){
								
								sb.append(" ").append(strUnitName[i]);
								
							}
							
							
							sb.append("</font></b></td>");

					flag = true;

				} else {

					String strColWidthVal = "20%";
					
					if(strColumnWidth[i] != null && !strColumnWidth[i].equals("null") && strColumnWidth[i].trim().length() > 0 ){
						
						strColWidthVal = strColumnWidth[i];
						
						if(strColumnWidthUnit[i] != null && !strColumnWidthUnit[i].equals("0") ){
							
							if(strColumnWidthUnit[i].equals("1")){
								
								strColWidthVal = strColWidthVal + "%";
							}else{
								
								strColWidthVal = strColWidthVal + "px";
								
							}
							 
							
						}
						
					}
					
					
					sb.append("<td width='"+strColWidthVal+"' align='center'> </td>");
				}

			}
			sb.append("</tr>");

			if (flag) {

				sb.append("<tr>");
				sb
						.append("<td colspan='"
								+ strParamName.length
								+ "' align='center' height='2px' bgcolor='#000000' ></td>");
				sb.append("</tr>");

			}
			
			sb.append("</table>");

			sb
			.append("<br/><table align='center' cellpadding='1px' cellspacing='1px' border='0' width='"+strTableWidth+"'>");
			
			sb.append("<tr>");
			sb.append("<td colspan='" + strParamName.length
					+ "' align='center'><div align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			sb.append(strFooter);
			sb.append("</font></b></div></td>");
			sb.append("</tr>");
			
			sb.append("</table></body></html>");

		} catch (Exception e) {

			throw e;

		}

		return sb.toString();

	}

	/*
	 * public static String exportPDF(WebRowSet ws, String[] strParamName,
	 * String[] strXlsColumnName , String strFooter) throws Exception {
	 * 
	 * StringBuffer sb = null;
	 * 
	 * try {
	 * 
	 * sb = new StringBuffer("");
	 * 
	 * sb.append("\n");
	 * 
	 * 
	 * for (int i = 0; i < strXlsColumnName.length; i++) {
	 * 
	 * sb.append("\t\t").append(strXlsColumnName[i]);
	 *  } sb.append("\n");
	 * 
	 * if (ws != null && ws.size() > 0) {
	 * 
	 * while (ws.next()) {
	 * 
	 * 
	 * for (int i = 0; i < strParamName.length; i++) {
	 * 
	 * sb.append("\t\t").append( ws.getString(strParamName[i])).append( "");
	 * 
	 *  } sb.append("\n");
	 * 
	 *  }
	 *  } else { sb.append("\n ").append("\t\t\t No Record(s) Found"); }
	 * 
	 * 
	 * sb.append("\n\n \t\t\t"+strFooter+"");
	 * 
	 *  } catch (Exception e) {
	 * 
	 * throw e;
	 *  }
	 * 
	 * return sb.toString();
	 *  }
	 */
}
