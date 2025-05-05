package mms.reports.controller.hlp;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

public class QueryReportHLP {

	public static String getResults(WebRowSet ws, int fetchSize) throws Exception {

		StringBuffer sb = new StringBuffer("");

		try {

			ResultSetMetaData rsmd = ws.getMetaData();
			int colCount = rsmd.getColumnCount();

			int width = 100 / (colCount == 0 ? 1 : colCount);
			
			if(width<10)
				width=10;

			sb.append("<div id='wrapper'><table id='mainTableRptId' class='NEWTABLEWIDTH' align='left' border='0' cellspacing='1px'><tr  id='tableHeaderId'>");

			for (int i = 1; i <= colCount; i++) {

				String strColumnName = rsmd.getColumnName(i);

				sb.append("<th width='" + width + "%' >");
				sb.append(strColumnName);
				sb.append("</th>");

			}
			sb.append("</tr>");

			if (ws.size() > 0) {

				int x = 0;

				while (ws.next() && x < fetchSize) {

					sb.append("<tr>");

					for (int i = 1; i <= colCount; i++) {

						sb.append("<td class='multiControl' width='" + width
								+ "%' >");
						
						if(ws.getString(i)!=null)
						{
							sb.append(ws.getString(i));
						}
						else
						{
							sb.append("---");
						}
						
						sb.append("</td>");

					}

					sb.append("</tr>");

					x++;

				}

			} else {

				sb.append("<tr><td colspan='"
						+ colCount
						+ "'><font color='red'><b>No Records Available</b></font> </td></tr>");

			}

			sb.append("</table></div>");

		} catch (Exception e) {

			throw e;

		} finally {

			if (ws != null) {

				try {
					ws.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ws = null;

			}

		}

		return sb.toString();

	}

}
