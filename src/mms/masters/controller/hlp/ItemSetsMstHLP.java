package mms.masters.controller.hlp;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemSetsMstHLP.
 */
public class ItemSetsMstHLP {
	
	/**
	 * Gets the added item details.
	 * 
	 * @param wb the wb
	 * 
	 * @return the added item details
	 */
	public static String getAddedItemDetails(WebRowSet wb) {
		StringBuffer br = new StringBuffer();

		try {
			if (wb != null) {
				if (wb.size() != 0) {
					br.append("<table class='TABLEWIDTH' align='center'>");
					br.append("<tr> ");
					br
							.append("<td WIDTH='25%' class='multiLabel'>Drug Category </td>");
					br
							.append("<td WIDTH='25%' class='multiLabel'>Generic Drug Name</td>");
					br
							.append("<td WIDTH='25%' class='multiLabel'>Drug Name</td>");
					br
							.append("<td WIDTH='25%' class='multiLabel'>Drug Quantity</td>");
					br
							.append("<td WIDTH='25%' class='multiLabel'>Effective From</td>");

					br.append("</tr> ");
					while (wb.next()) {
						br.append("<TR>");
						br.append("<TD WIDTH='25%' CLASS='multiControl'>"
								+ wb.getString(1) + "</TD>");
						br.append("<TD WIDTH='25%' CLASS='multiControl'>"
								+ wb.getString(2) + "</TD>");
						br.append("<TD WIDTH='25%' CLASS='multiControl'>"
								+ wb.getString(3) + "</TD>");
						br.append("<TD WIDTH='25%' CLASS='multiControl'>"
								+ wb.getString(4) + "</TD>");
						br.append("<TD WIDTH='25%' CLASS='multiControl'>"
								+ wb.getString(5) + "</TD>");
						br.append("</TR>");
					}
					br.append("</tr> ");
					br.append("</table> ");

				}
			}
		} catch (Exception e) {

		}
		return br.toString();
	}
}
