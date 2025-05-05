package mms.masters.controller.hlp;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugSafetyAlertMstHLP.
 */
public class DrugSafetyAlertMstHLP {

	/**
	 * Gets the process un process dtl1.
	 * 
	 * @param ws the ws
	 * @param ws2 the ws2
	 * 
	 * @return the process un process dtl1
	 */
	public static String getProcessUnProcessDtl1(WebRowSet ws, WebRowSet ws2) {

		StringBuffer sb = null;
		sb = new StringBuffer("");

		// int length = ws2.size() * 8;
		// // //System.out.println("length inside HLP:::"+length);
		// String[] strAddedData = new String[length];
		try {

			if ((ws != null && ws.size() != 0)) {
				sb
						.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
				sb.append("<tr><td width='25%' class='multiLabel'></td>");
				sb.append("<td width='25%' class='multiLabel'></td>");
				sb.append("<td width='25%' class='multiLabel'></td>");
				sb.append("<td width='25%' class='multiLabel'></td></tr>");

				String strData1 = null;
				String strData2 = null;
				String strData3 = null;
				String strData4 = null;
				String strData5 = null;
				String strData6 = null;
				String strData7 = null;
				String strData8 = null;

				String strData11 = null;
				String strData22 = null;
				String strData33 = null;
				String strData44 = null;
				String strData55 = null;
				String strData66 = null;
				String strData77 = null;
				String strData88 = null;
				while (ws2.next()) {
					strData11 = ws2.getString(1);
					// //
					// //System.out.println("ws2.getString(1)::"+ws2.getString(1));
					strData22 = ws2.getString(2);
					strData33 = ws2.getString(3);
					strData44 = ws2.getString(4);
					strData55 = ws2.getString(5);
					strData66 = ws2.getString(6);
					strData77 = ws2.getString(7);
					// //
					// //System.out.println("ws2.getString(8)::"+ws2.getString(8));
					strData88 = ws2.getString(8);

					if (strData11 == null || strData11.equals(""))
						strData11 = "-----";
					if (strData22 == null || strData22.equals(""))
						strData22 = "-----";
					if (strData33 == null || strData33.equals(""))
						strData33 = "-----";
					if (strData44 == null || strData44.equals(""))
						strData44 = "-----";
					if (strData55 == null || strData55.equals(""))
						strData55 = "-----";
					if (strData66 == null || strData66.equals(""))
						strData66 = "-----";
					if (strData77 == null || strData77.equals(""))
						strData77 = "-----";
					if (strData88 == null || strData88.equals(""))
						strData88 = "-----";

					while (ws.next()) {
						strData1 = ws.getString(1);
						strData2 = ws.getString(2);
						strData3 = ws.getString(3);
						strData4 = ws.getString(4);
						strData5 = ws.getString(5);
						strData6 = ws.getString(6);
						strData7 = ws.getString(7);
						strData8 = ws.getString(8);

						if (strData1 == null || strData1.equals(""))
							strData1 = "-----";
						if (strData2 == null || strData2.equals(""))
							strData2 = "-----";
						if (strData3 == null || strData3.equals(""))
							strData3 = "-----";
						if (strData4 == null || strData4.equals(""))
							strData4 = "-----";
						if (strData5 == null || strData5.equals(""))
							strData5 = "-----";
						if (strData6 == null || strData6.equals(""))
							strData6 = "-----";
						if (strData7 == null || strData7.equals(""))
							strData7 = "-----";
						if (strData8 == null || strData8.equals(""))
							strData8 = "-----";

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData1);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData1);
						// sb.append("<input name='strAddedData'
						// id='strAddedData' type='text' class='txtFldMax'
						// value=''>");
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2'>"
										).append( strData11 ).append( "</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData2);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData2);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' >"
										).append( strData22 ).append( "</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData3);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData3);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2'>"
										).append( strData33 ).append( "</textarea>");
						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData4);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData4);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' >"
										).append( strData44 ).append( "</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData5);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData5);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' >"
										).append( strData55 ).append( "</textarea>");
						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData6);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData6);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' >"
										).append( strData66 ).append( "</textarea>");
						sb.append("</td>");
						sb.append("</tr>");
						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData7);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData7);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' >"
										).append( strData77 ).append( "</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData8);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData8);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' >"
										).append( strData88 ).append( "</textarea>");
						sb.append("</td>");
						sb.append("</tr>");
					}

				}
				sb.append("</table>");
			}

			else {
				sb
						.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
				sb.append("<tr>");
				sb
						.append("<td colspan='7'  CLASS='multiControl' >"
								).append( "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED GROUP </div>"
								).append( "</TD>");

				sb.append("</tr>");
				sb.append("</table></div>");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * Gets the process un process dtl2.
	 * 
	 * @param ws the ws
	 * @param ws2 the ws2
	 * 
	 * @return the process un process dtl2
	 */
	public static String getProcessUnProcessDtl2(WebRowSet ws, WebRowSet ws2) {

		StringBuffer sb = null;
		sb = new StringBuffer("");

		// int length = ws2.size() * 8;
		// // //System.out.println("length inside HLP:::"+length);
		// String[] strAddedData = new String[length];
		try {

			if ((ws != null && ws.size() != 0)) {
				sb
						.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
				sb.append("<tr><td width='25%' class='multiLabel'></td>");
				sb.append("<td width='25%' class='multiLabel'></td>");
				sb.append("<td width='25%' class='multiLabel'></td>");
				sb.append("<td width='25%' class='multiLabel'></td></tr>");

				String strData1 = null;
				String strData2 = null;
				String strData3 = null;
				String strData4 = null;
				String strData5 = null;
				String strData6 = null;
				String strData7 = null;
				String strData8 = null;

				String strData11 = null;
				String strData22 = null;
				String strData33 = null;
				String strData44 = null;
				String strData55 = null;
				String strData66 = null;
				String strData77 = null;
				String strData88 = null;
				while (ws2.next()) {
					strData11 = ws2.getString(1);
					// //
					// //System.out.println("ws2.getString(1)::"+ws2.getString(1));
					strData22 = ws2.getString(2);
					strData33 = ws2.getString(3);
					strData44 = ws2.getString(4);
					strData55 = ws2.getString(5);
					strData66 = ws2.getString(6);
					strData77 = ws2.getString(7);
					// //
					// //System.out.println("ws2.getString(8)::"+ws2.getString(8));
					strData88 = ws2.getString(8);

					if (strData11 == null || strData11.equals(""))
						strData11 = "-----";
					if (strData22 == null || strData22.equals(""))
						strData22 = "-----";
					if (strData33 == null || strData33.equals(""))
						strData33 = "-----";
					if (strData44 == null || strData44.equals(""))
						strData44 = "-----";
					if (strData55 == null || strData55.equals(""))
						strData55 = "-----";
					if (strData66 == null || strData66.equals(""))
						strData66 = "-----";
					if (strData77 == null || strData77.equals(""))
						strData77 = "-----";
					if (strData88 == null || strData88.equals(""))
						strData88 = "-----";

					while (ws.next()) {
						strData1 = ws.getString(1);
						strData2 = ws.getString(2);
						strData3 = ws.getString(3);
						strData4 = ws.getString(4);
						strData5 = ws.getString(5);
						strData6 = ws.getString(6);
						strData7 = ws.getString(7);
						strData8 = ws.getString(8);

						if (strData1 == null || strData1.equals(""))
							strData1 = "-----";
						if (strData2 == null || strData2.equals(""))
							strData2 = "-----";
						if (strData3 == null || strData3.equals(""))
							strData3 = "-----";
						if (strData4 == null || strData4.equals(""))
							strData4 = "-----";
						if (strData5 == null || strData5.equals(""))
							strData5 = "-----";
						if (strData6 == null || strData6.equals(""))
							strData6 = "-----";
						if (strData7 == null || strData7.equals(""))
							strData7 = "-----";
						if (strData8 == null || strData8.equals(""))
							strData8 = "-----";

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData1);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData11);
						// sb.append("<input name='strAddedData'
						// id='strAddedData' type='text' class='txtFldMax'
						// value=''>");
						// sb.append("<textarea name='strAddedData' cols='10'
						// rows='2'>"+strData11+"</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData2);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData22);
						// sb.append("<textarea name='strAddedData' cols='10'
						// rows='2' >"+strData22+"</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData3);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData33);
						// sb.append("<textarea name='strAddedData' cols='10'
						// rows='2'>"+strData33+"</textarea>");
						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData4);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData44);
						// sb.append("<textarea name='strAddedData' cols='10'
						// rows='2' >"+strData44+"</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData5);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData55);
						// sb.append("<textarea name='strAddedData' cols='10'
						// rows='2' >"+strData55+"</textarea>");
						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData6);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData66);
						// sb.append("<textarea name='strAddedData' cols='10'
						// rows='2' >"+strData66+"</textarea>");
						sb.append("</td>");
						sb.append("</tr>");
						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData7);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData77);
						// sb.append("<textarea name='strAddedData' cols='10'
						// rows='2' >"+strData77+"</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData8);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData88);
						// sb.append("<textarea name='strAddedData' cols='10'
						// rows='2' >"+strData88+"</textarea>");
						sb.append("</td>");
						sb.append("</tr>");
					}

				}
				sb.append("</table>");
			}

			else {
				sb
						.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
				sb.append("<tr>");
				sb
						.append("<td colspan='7'  CLASS='multiControl' >"
								).append( "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED GROUP </div>"
								).append( "</TD>");

				sb.append("</tr>");
				sb.append("</table></div>");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	/**
	 * Gets the process un process dtl.
	 * 
	 * @param ws the ws
	 * 
	 * @return the process un process dtl
	 */
	public static String getProcessUnProcessDtl(WebRowSet ws) {

		StringBuffer sb = null;
		sb = new StringBuffer("");
		// int length = ws.size() * 8;
		// String[] strAddedData = new String[length];
		try {
			if ((ws != null && ws.size() != 0)) {
				sb
						.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='1px'>");
				sb.append("<tr><td width='25%' class='multiLabel'></td>");
				sb.append("<td width='25%' class='multiLabel'></td>");
				sb.append("<td width='25%' class='multiLabel'></td>");
				sb.append("<td width='25%' class='multiLabel'></td></tr>");

				String strData1 = null;
				String strData2 = null;
				String strData3 = null;
				String strData4 = null;
				String strData5 = null;
				String strData6 = null;
				String strData7 = null;
				String strData8 = null;
				for (int j = 0; ws.next(); j++) {
					strData1 = ws.getString(1);
					strData2 = ws.getString(2);
					strData3 = ws.getString(3);
					strData4 = ws.getString(4);
					strData5 = ws.getString(5);
					strData6 = ws.getString(6);
					strData7 = ws.getString(7);
					strData8 = ws.getString(8);

					if (strData1 == null || strData1.equals(""))
						strData1 = "-----";
					if (strData2 == null || strData2.equals(""))
						strData2 = "-----";
					if (strData3 == null || strData3.equals(""))
						strData3 = "-----";
					if (strData4 == null || strData4.equals(""))
						strData4 = "-----";
					if (strData5 == null || strData5.equals(""))
						strData5 = "-----";
					if (strData6 == null || strData6.equals(""))
						strData6 = "-----";
					if (strData7 == null || strData7.equals(""))
						strData7 = "-----";
					if (strData8 == null || strData8.equals(""))
						strData8 = "-----";

					sb.append("<tr>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData1);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData1);
					// sb.append("<input name='strAddedData' id='strAddedData'
					// type='text' class='txtFldMax' value=''>");
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'  maxlength='250' onkeypress='return validateData(event,4);'></textarea>");

					sb.append("</td>");

					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData2);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData2);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2' maxlength='250' onkeypress='return validateData(event,4);'></textarea>");
					sb.append("</td>");
					sb.append("</tr>");

					sb.append("<tr>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData3);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData3);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2' maxlength='250' onkeypress='return validateData(event,4);'></textarea>");
					sb.append("</td>");

					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData4);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData4);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2' maxlength='250' onkeypress='return validateData(event,4);'></textarea>");
					sb.append("</td>");
					sb.append("</tr>");

					sb.append("<tr>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData5);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData5);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2' maxlength='250' onkeypress='return validateData(event,4);'></textarea>");
					sb.append("</td>");

					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData6);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData6);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2' maxlength='250' onkeypress='return validateData(event,4);'></textarea>");
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData7);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData7);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2' maxlength='250' onkeypress='return validateData(event,4);'></textarea>");
					sb.append("</td>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData8);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData8);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2' maxlength='250' onkeypress='return validateData(event,4);'></textarea>");
					sb.append("</td>");
					sb.append("</tr>");
				}
				sb.append("</table>");
			} else {
				sb
						.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
				sb.append("<tr>");
				sb
						.append("<td colspan='7'  CLASS='multiControl' >"
								).append( "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED GROUP </div>"
								).append( "</TD>");

				sb.append("</tr>");
				sb.append("</table></div>");

			}
		} catch (Exception e) {

		}
		return sb.toString();
	}
}
