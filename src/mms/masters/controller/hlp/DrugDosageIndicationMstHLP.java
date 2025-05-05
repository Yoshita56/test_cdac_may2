package mms.masters.controller.hlp;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugDosageIndicationMstHLP.
 */
public class DrugDosageIndicationMstHLP {
	
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

		// int length = ws2.size() * 25;
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
				String strData9 = null;
				String strData10 = null;
				String strData11 = null;
				String strData12 = null;
				String strData13 = null;
				String strData14 = null;
				String strData15 = null;
				String strData16 = null;
				String strData17 = null;
				String strData18 = null;
				String strData19 = null;
				String strData20 = null;
				String strData21 = null;
				String strData22 = null;
				String strData23 = null;
				String strData24 = null;
				String strData25 = null;

				String strData01 = null;
				String strData02 = null;
				String strData03 = null;
				String strData04 = null;
				String strData05 = null;
				String strData06 = null;
				String strData07 = null;
				String strData08 = null;
				String strData09 = null;
				String strData010 = null;
				String strData011 = null;
				String strData012 = null;
				String strData013 = null;
				String strData014 = null;
				String strData015 = null;
				String strData016 = null;
				String strData017 = null;
				String strData018 = null;
				String strData019 = null;
				String strData020 = null;
				String strData021 = null;
				String strData022 = null;
				String strData023 = null;
				String strData024 = null;
				String strData025 = null;

				while (ws2.next()) {
					strData01 = ws2.getString(1);
					strData02 = ws2.getString(2);
					strData03 = ws2.getString(3);
					strData04 = ws2.getString(4);
					strData05 = ws2.getString(5);
					strData06 = ws2.getString(6);
					strData07 = ws2.getString(7);
					strData08 = ws2.getString(8);
					strData09 = ws2.getString(9);
					strData010 = ws2.getString(10);
					strData011 = ws2.getString(11);
					strData012 = ws2.getString(12);
					strData013 = ws2.getString(13);
					strData014 = ws2.getString(14);
					strData015 = ws2.getString(15);
					strData016 = ws2.getString(16);
					strData017 = ws2.getString(17);
					strData018 = ws2.getString(18);
					strData019 = ws2.getString(19);
					strData020 = ws2.getString(20);
					strData021 = ws2.getString(21);
					strData022 = ws2.getString(22);
					strData023 = ws2.getString(23);
					strData024 = ws2.getString(24);
					strData025 = ws2.getString(25);

					if (strData01 == null || strData01.equals(""))
						strData01 = "-----";
					if (strData02 == null || strData02.equals(""))
						strData02 = "-----";
					if (strData03 == null || strData03.equals(""))
						strData03 = "-----";
					if (strData04 == null || strData04.equals(""))
						strData04 = "-----";
					if (strData05 == null || strData05.equals(""))
						strData05 = "-----";
					if (strData06 == null || strData06.equals(""))
						strData06 = "-----";
					if (strData07 == null || strData07.equals(""))
						strData07 = "-----";
					if (strData08 == null || strData08.equals(""))
						strData08 = "-----";

					if (strData09 == null || strData09.equals(""))
						strData09 = "-----";
					if (strData010 == null || strData010.equals(""))
						strData010 = "-----";
					if (strData011 == null || strData011.equals(""))
						strData011 = "-----";
					if (strData012 == null || strData012.equals(""))
						strData012 = "-----";
					if (strData013 == null || strData013.equals(""))
						strData013 = "-----";
					if (strData014 == null || strData014.equals(""))
						strData014 = "-----";
					if (strData015 == null || strData015.equals(""))
						strData015 = "-----";
					if (strData016 == null || strData016.equals(""))
						strData016 = "-----";

					if (strData017 == null || strData017.equals(""))
						strData017 = "-----";
					if (strData018 == null || strData018.equals(""))
						strData018 = "-----";
					if (strData019 == null || strData019.equals(""))
						strData019 = "-----";
					if (strData020 == null || strData020.equals(""))
						strData020 = "-----";
					if (strData021 == null || strData021.equals(""))
						strData021 = "-----";
					if (strData022 == null || strData022.equals(""))
						strData022 = "-----";
					if (strData023 == null || strData023.equals(""))
						strData023 = "-----";
					if (strData024 == null || strData024.equals(""))
						strData024 = "-----";
					if (strData025 == null || strData025.equals(""))
						strData025 = "-----";
					while (ws.next()) {
						strData1 = ws.getString(1);
						strData2 = ws.getString(2);
						strData3 = ws.getString(3);
						strData4 = ws.getString(4);
						strData5 = ws.getString(5);
						strData6 = ws.getString(6);
						strData7 = ws.getString(7);
						strData8 = ws.getString(8);
						strData9 = ws.getString(9);
						strData10 = ws.getString(10);
						strData11 = ws.getString(11);
						strData12 = ws.getString(12);
						strData13 = ws.getString(13);
						strData14 = ws.getString(14);
						strData15 = ws.getString(15);
						strData16 = ws.getString(16);
						strData17 = ws.getString(17);
						strData18 = ws.getString(18);
						strData19 = ws.getString(19);
						strData20 = ws.getString(20);
						strData21 = ws.getString(21);
						strData22 = ws.getString(22);
						strData23 = ws.getString(23);
						strData24 = ws.getString(24);
						strData25 = ws.getString(25);

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
								.append("<textarea name='strAddedData' cols='20' rows='2' maxlength='250' onkeypress='return validateData(event,4);'>"
										+ strData01 + "</textarea>");
						sb.append("</td>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData2);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData2);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' maxlength='250' onkeypress='return validateData(event,4);'>"
										+ strData02 + "</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData3);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData3);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' maxlength='250'  onkeypress='return validateData(event,4);'>"
										+ strData03 + "</textarea>");
						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData4);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData4);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' maxlength='250'  onkeypress='return validateData(event,4);'>"
										+ strData04 + "</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData5);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData5);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2'maxlength='250'  onkeypress='return validateData(event,4);' >"
										+ strData05 + "</textarea>");
						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData6);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData6);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2'maxlength='250'  onkeypress='return validateData(event,4);'>"
										+ strData06 + "</textarea>");
						sb.append("</td>");
						sb.append("</tr>");
						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData7);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData7);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2'maxlength='250'  onkeypress='return validateData(event,4);' >"
										+ strData07 + "</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData8);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData8);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2'maxlength='250'  onkeypress='return validateData(event,4);'>"
										+ strData08 + "</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData9);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData7);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' maxlength='250'  onkeypress='return validateData(event,4);'>"
										+ strData09 + "</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData10);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData8);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' maxlength='250'  onkeypress='return validateData(event,4);' >"
										+ strData010 + "</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData11);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData7);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' maxlength='250'  onkeypress='return validateData(event,4);'>"
										+ strData011 + "</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData12);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData8);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' maxlength='250'  onkeypress='return validateData(event,4);' >"
										+ strData012 + "</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData13);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData7);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2'maxlength='250'  onkeypress='return validateData(event,4);'>"
										+ strData013 + "</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData14);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData8);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' maxlength='250'  onkeypress='return validateData(event,4);'>"
										+ strData014 + "</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData15);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData7);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' maxlength='250'  onkeypress='return validateData(event,4);'>"
										+ strData015 + "</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData16);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData8);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2'maxlength='250'  onkeypress='return validateData(event,4);' >"
										+ strData016 + "</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData17);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData7);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' maxlength='250'  onkeypress='return validateData(event,4);'>"
										+ strData017 + "</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData18);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData8);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' maxlength='250'  onkeypress='return validateData(event,4);'>"
										+ strData018 + "</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData19);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData7);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' maxlength='250'  onkeypress='return validateData(event,4);'>"
										+ strData019 + "</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData20);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData8);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' maxlength='250'  onkeypress='return validateData(event,4);' >"
										+ strData020 + "</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData21);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData7);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' maxlength='250'  onkeypress='return validateData(event,4);'>"
										+ strData021 + "</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData22);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData8);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' maxlength='250'  onkeypress='return validateData(event,4);' >"
										+ strData022 + "</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData23);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData7);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' maxlength='250'  onkeypress='return validateData(event,4);'>"
										+ strData023 + "</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData24);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData8);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' maxlength='250' onkeypress='return validateData(event,4);'>"
										+ strData024 + "</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData25);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData7);
						sb
								.append("<textarea name='strAddedData' cols='20' rows='2' maxlength='250' onkeypress='return validateData(event,4);'>"
										+ strData025 + "</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");

						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData8);
						// sb.append("<textarea name='strAddedData' cols='20'
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
								+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED GROUP </div>"
								+ "</TD>");

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

		// int length = ws2.size() * 25;
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
				String strData9 = null;
				String strData10 = null;
				String strData11 = null;
				String strData12 = null;
				String strData13 = null;
				String strData14 = null;
				String strData15 = null;
				String strData16 = null;
				String strData17 = null;
				String strData18 = null;
				String strData19 = null;
				String strData20 = null;
				String strData21 = null;
				String strData22 = null;
				String strData23 = null;
				String strData24 = null;
				String strData25 = null;

				String strData01 = null;
				String strData02 = null;
				String strData03 = null;
				String strData04 = null;
				String strData05 = null;
				String strData06 = null;
				String strData07 = null;
				String strData08 = null;
				String strData09 = null;
				String strData010 = null;
				String strData011 = null;
				String strData012 = null;
				String strData013 = null;
				String strData014 = null;
				String strData015 = null;
				String strData016 = null;
				String strData017 = null;
				String strData018 = null;
				String strData019 = null;
				String strData020 = null;
				String strData021 = null;
				String strData022 = null;
				String strData023 = null;
				String strData024 = null;
				String strData025 = null;

				while (ws2.next()) {
					strData01 = ws2.getString(1);
					strData02 = ws2.getString(2);
					strData03 = ws2.getString(3);
					strData04 = ws2.getString(4);
					strData05 = ws2.getString(5);
					strData06 = ws2.getString(6);
					strData07 = ws2.getString(7);
					strData08 = ws2.getString(8);
					strData09 = ws2.getString(9);
					strData010 = ws2.getString(10);
					strData011 = ws2.getString(11);
					strData012 = ws2.getString(12);
					strData013 = ws2.getString(13);
					strData014 = ws2.getString(14);
					strData015 = ws2.getString(15);
					strData016 = ws2.getString(16);
					strData017 = ws2.getString(17);
					strData018 = ws2.getString(18);
					strData019 = ws2.getString(19);
					strData020 = ws2.getString(20);
					strData021 = ws2.getString(21);
					strData022 = ws2.getString(22);
					strData023 = ws2.getString(23);
					strData024 = ws2.getString(24);
					strData025 = ws2.getString(25);

					if (strData01 == null || strData01.equals(""))
						strData01 = "-----";
					if (strData02 == null || strData02.equals(""))
						strData02 = "-----";
					if (strData03 == null || strData03.equals(""))
						strData03 = "-----";
					if (strData04 == null || strData04.equals(""))
						strData04 = "-----";
					if (strData05 == null || strData05.equals(""))
						strData05 = "-----";
					if (strData06 == null || strData06.equals(""))
						strData06 = "-----";
					if (strData07 == null || strData07.equals(""))
						strData07 = "-----";
					if (strData08 == null || strData08.equals(""))
						strData08 = "-----";

					if (strData09 == null || strData09.equals(""))
						strData09 = "-----";
					if (strData010 == null || strData010.equals(""))
						strData010 = "-----";
					if (strData011 == null || strData011.equals(""))
						strData011 = "-----";
					if (strData012 == null || strData012.equals(""))
						strData012 = "-----";
					if (strData013 == null || strData013.equals(""))
						strData013 = "-----";
					if (strData014 == null || strData014.equals(""))
						strData014 = "-----";
					if (strData015 == null || strData015.equals(""))
						strData015 = "-----";
					if (strData016 == null || strData016.equals(""))
						strData016 = "-----";

					if (strData017 == null || strData017.equals(""))
						strData017 = "-----";
					if (strData018 == null || strData018.equals(""))
						strData018 = "-----";
					if (strData019 == null || strData019.equals(""))
						strData019 = "-----";
					if (strData020 == null || strData020.equals(""))
						strData020 = "-----";
					if (strData021 == null || strData021.equals(""))
						strData021 = "-----";
					if (strData022 == null || strData022.equals(""))
						strData022 = "-----";
					if (strData023 == null || strData023.equals(""))
						strData023 = "-----";
					if (strData024 == null || strData024.equals(""))
						strData024 = "-----";
					if (strData025 == null || strData025.equals(""))
						strData025 = "-----";
					while (ws.next()) {
						strData1 = ws.getString(1);
						strData2 = ws.getString(2);
						strData3 = ws.getString(3);
						strData4 = ws.getString(4);
						strData5 = ws.getString(5);
						strData6 = ws.getString(6);
						strData7 = ws.getString(7);
						strData8 = ws.getString(8);
						strData9 = ws.getString(9);
						strData10 = ws.getString(10);
						strData11 = ws.getString(11);
						strData12 = ws.getString(12);
						strData13 = ws.getString(13);
						strData14 = ws.getString(14);
						strData15 = ws.getString(15);
						strData16 = ws.getString(16);
						strData17 = ws.getString(17);
						strData18 = ws.getString(18);
						strData19 = ws.getString(19);
						strData20 = ws.getString(20);
						strData21 = ws.getString(21);
						strData22 = ws.getString(22);
						strData23 = ws.getString(23);
						strData24 = ws.getString(24);
						strData25 = ws.getString(25);

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
						sb.append(strData01);
						// sb.append("<input name='strAddedData'
						// id='strAddedData' type='text' class='txtFldMax'
						// value=''>");
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2'>"+strData01+"</textarea>");
						sb.append("</td>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData2);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData02);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData02+"</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData3);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData03);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2'>"+strData03+"</textarea>");
						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData4);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData04);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData04+"</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData5);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData05);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData05+"</textarea>");
						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData6);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData06);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData06+"</textarea>");
						sb.append("</td>");
						sb.append("</tr>");
						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData7);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData07);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData07+"</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData8);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData08);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData08+"</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData9);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData09);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData09+"</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData10);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData010);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData010+"</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData11);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData011);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData011+"</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData12);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData012);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData012+"</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData13);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData013);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData013+"</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData14);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData014);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData014+"</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData15);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData015);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData015+"</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData16);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData016);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData016+"</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData17);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData017);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData017+"</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData18);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData018);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData018+"</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData19);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData019);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData019+"</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData20);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData020);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData020+"</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData21);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData021);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData021+"</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData22);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData022);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData022+"</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData23);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData023);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData023+"</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData24);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData024);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData024+"</textarea>");
						sb.append("</td>");
						sb.append("</tr>");

						sb.append("<tr>");
						sb.append("<td class='LABEL' width='25%'>");
						sb.append(strData25);
						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						sb.append(strData025);
						// sb.append("<textarea name='strAddedData' cols='20'
						// rows='2' >"+strData025+"</textarea>");

						sb.append("</td>");

						sb.append("<td class='LABEL' width='25%'>");

						sb.append("</td>");
						sb.append("<td class='multiControl' width='25%'>");
						// sb.append(strData8);
						// sb.append("<textarea name='strAddedData' cols='20'
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
								+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED GROUP </div>"
								+ "</TD>");

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
				String strData9 = null;
				String strData10 = null;
				String strData11 = null;
				String strData12 = null;
				String strData13 = null;
				String strData14 = null;
				String strData15 = null;
				String strData16 = null;
				String strData17 = null;
				String strData18 = null;
				String strData19 = null;
				String strData20 = null;
				String strData21 = null;
				String strData22 = null;
				String strData23 = null;
				String strData24 = null;
				String strData25 = null;
				while (ws.next()) {
					strData1 = ws.getString(1);
					strData2 = ws.getString(2);
					strData3 = ws.getString(3);
					strData4 = ws.getString(4);
					strData5 = ws.getString(5);
					strData6 = ws.getString(6);
					strData7 = ws.getString(7);
					strData8 = ws.getString(8);
					strData9 = ws.getString(9);
					strData10 = ws.getString(10);
					strData11 = ws.getString(11);
					strData12 = ws.getString(12);
					strData13 = ws.getString(13);
					strData14 = ws.getString(14);
					strData15 = ws.getString(15);
					strData16 = ws.getString(16);
					strData17 = ws.getString(17);
					strData18 = ws.getString(18);
					strData19 = ws.getString(19);
					strData20 = ws.getString(20);
					strData21 = ws.getString(21);
					strData22 = ws.getString(22);
					strData23 = ws.getString(23);
					strData24 = ws.getString(24);
					strData25 = ws.getString(25);

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
					if (strData9 == null || strData9.equals(""))
						strData9 = "-----";
					if (strData10 == null || strData10.equals(""))
						strData10 = "-----";
					if (strData11 == null || strData11.equals(""))
						strData11 = "-----";
					if (strData12 == null || strData12.equals(""))
						strData12 = "-----";
					if (strData13 == null || strData13.equals(""))
						strData13 = "-----";
					if (strData14 == null || strData14.equals(""))
						strData14 = "-----";
					if (strData15 == null || strData15.equals(""))
						strData15 = "-----";
					if (strData16 == null || strData16.equals(""))
						strData16 = "-----";
					if (strData17 == null || strData17.equals(""))
						strData17 = "-----";
					if (strData18 == null || strData18.equals(""))
						strData18 = "-----";
					if (strData19 == null || strData19.equals(""))
						strData19 = "-----";
					if (strData20 == null || strData20.equals(""))
						strData20 = "-----";
					if (strData21 == null || strData21.equals(""))
						strData21 = "-----";
					if (strData22 == null || strData22.equals(""))
						strData22 = "-----";
					if (strData23 == null || strData23.equals(""))
						strData23 = "-----";
					if (strData24 == null || strData24.equals(""))
						strData25 = "-----";

					sb.append("<tr>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData1);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData1);
					// sb.append("<input name='strAddedData' id='strAddedData'
					// type='text' class='txtFldMax' value=''>");
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");

					sb.append("</td>");

					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData2);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData2);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");
					sb.append("</tr>");

					sb.append("<tr>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData3);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData3);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");

					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData4);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData4);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");
					sb.append("</tr>");

					sb.append("<tr>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData5);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData5);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");

					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData6);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData6);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData7);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData7);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData8);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData8);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");
					sb.append("</tr>");

					sb.append("<tr>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData9);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData5);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");

					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData10);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData6);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData11);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData7);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData12);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData8);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData13);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData5);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");

					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData14);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData6);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData15);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData7);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData16);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData8);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData17);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData5);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");

					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData18);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData6);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData19);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData7);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData20);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData8);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData21);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData5);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");

					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData22);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData6);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData23);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData7);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData24);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData8);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td class='LABEL' width='25%'>");
					sb.append(strData25);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData7);
					sb
							.append("<textarea name='strAddedData' cols='25' rows='2'></textarea>");
					sb.append("</td>");
					sb.append("<td class='LABEL' width='25%'>");
					// sb.append(strData8);
					sb.append("</td>");
					sb.append("<td class='multiControl' width='25%'>");
					// sb.append(strData8);
					// sb.append("<textarea name='strAddedData' cols='25'
					// rows='2'></textarea>");
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
								+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED GROUP </div>"
								+ "</TD>");

				sb.append("</tr>");
				sb.append("</table></div>");

			}
		} catch (Exception e) {

		}
		return sb.toString();
	}
}
