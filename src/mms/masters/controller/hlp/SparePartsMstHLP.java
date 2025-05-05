package mms.masters.controller.hlp;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class SparePartsMstHLP.
 */
public class SparePartsMstHLP {
	
	/**
	 * Gets the spare parts details.
	 * 
	 * @param wb the wb
	 * 
	 * @return the spare parts details
	 */
	public static String getSparePartsDetails(WebRowSet wb) {
		/*
		 * StringBuffer sb = new StringBuffer(""); if (ws != null) {
		 * 
		 * try { if (ws.next()) {
		 * 
		 * String strSparePartsNameHLP = ws.getString(1); if
		 * (strSparePartsNameHLP == null) strSparePartsNameHLP = "";
		 * 
		 * sb.append("<table class='TABLEWIDTH' align='center'>"); sb.append("<tr>");
		 * sb.append("<td  class='multiControl' width='91%'>");
		 * sb.append(strSparePartsNameHLP); sb.append("</td>"); sb.append("<td  class='multiControl' width='9%'></td>");
		 * sb.append("<td colspan='3' width='25%' class='CONTROL'> ");
		 * 
		 * 
		 * 
		 * sb.append("</tr></table>");
		 *  }
		 *  }
		 */
		StringBuffer br = new StringBuffer();

		try {
			if (wb != null) {
				if (wb.size() != 0) {
					br.append("<table class='TABLEWIDTH' align='center'>");
					br.append("<tr> ");
					br
							.append("<td WIDTH='50%' align='center' class='multiLabel'>Spare Part Category</td>");
					br
							.append("<td WIDTH='50%' align='center' class='multiLabel'>Spare Part Item Name</td>");
					br.append("</tr> ");
					while (wb.next()) {
						br.append("<TR>");
						br.append("<TD WIDTH='50%' CLASS='multiControl'>"
								+ wb.getString(1) + "</TD>");
						br.append("<TD WIDTH='50%' CLASS='multiControl'>"
								+ wb.getString(2) + "</TD>");
						br.append("</TR>");
					}
					br.append("</tr> ");
					br.append("</table> ");

				}
			}
		} catch (SQLException e) {
			new HisException("STORE",
					"SparePartsMstHLP.getSparePartsDetails() -->", e
							.getMessage());
		}

		return br.toString();
	}

}
