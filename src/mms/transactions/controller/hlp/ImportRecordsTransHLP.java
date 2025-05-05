package mms.transactions.controller.hlp;

import javax.sql.rowset.WebRowSet;

public class ImportRecordsTransHLP {

	public static String getTemplateDetails(WebRowSet ws, String strTemplateType)
			throws Exception {

		StringBuffer sb = new StringBuffer("");

		sb
				.append("<table border='0' class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
		sb.append("<tr class='TITLE'>");
		sb.append("<td colspan='4'>Parameter Mapping Details");
		sb.append("</td>");
		sb.append("</tr>");
		sb.append("<tr>");
		sb.append("<td class='multiLabel' width='30%'>Parameter Name");
		sb.append("</td>");
		sb.append("<td class='multiLabel' width='10%'>XLS Column Index");
		sb.append("</td>");
		sb.append("<td class='multiLabel' width='30%'>XLS Column Name");
		sb.append("</td>");
		sb.append("<td class='multiLabel' width='30%'>Constant Values");
		sb.append("</td>");
		sb.append("</tr>");

		try {

			if (ws != null && ws.size() > 0) {
				while (ws.next()) {

										
					sb.append("<tr>");
					sb.append("<td class='multiControl' width='30%' >");

					sb.append(ws.getString(1));

					sb.append("<input type='hidden' name='strParamName'  value='"+ws.getString(1)+"'></td>");
					sb.append("<td class='multiControl'  width='10%' >");
					sb.append(ws.getString(2));
					sb.append("<input type='hidden' name='strXlsColumnIndex'  value='"+ws.getString(2)+"'></td>");
					sb.append("<td class='multiControl'  width='30%' >");
					sb.append(ws.getString(3));
					sb.append("<input type='hidden' name='strXlsColumnName'  value='"+ws.getString(3)+"'></td>");
					sb.append("<td class='multiControl' width='30%' >");
					sb.append(ws.getString(4));
					sb.append("<input type='hidden' name='strConstantValue'  value='"+ws.getString(4)+"'></td>");
					sb.append("</tr>");

				}

				sb.append("</table>");

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

}
