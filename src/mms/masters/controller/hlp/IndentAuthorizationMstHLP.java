package mms.masters.controller.hlp;

import javax.sql.rowset.WebRowSet;

// TODO: Auto-generated Javadoc
/**
 * The Class IndentAuthorizationMstHLP.
 */
public class IndentAuthorizationMstHLP {
	
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
				br.append("<table class='TABLEWIDTH' align='center'>");
				br.append("<tr> ");
				br
						.append("<td WIDTH='50%' class='multiLabel'>Employee Name</td>");
				br.append("<td WIDTH='50%' class='multiLabel'>Level</td>");

				br.append("</tr> ");
				if (wb.size() != 0) {

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

				} else {
					br
							.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
					br.append("<TR>");
					br
							.append("<TD WIDTH='25%' CLASS='multiControl' colspan='6'>"
									+ "No Record Found" + "</TD>");
					br.append("</TR>");
					br.append("</table> ");
				}
			}
		} catch (Exception e) {

		}
		return br.toString();
	}
}
