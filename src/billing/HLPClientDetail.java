package billing;
import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

public class HLPClientDetail
{
	public static String getClientDetails(WebRowSet ws) {

		StringBuffer sb = new StringBuffer("");

		if (ws != null) {

			try {
				if (ws.next())
				{

					String strAgeAndSex = ws.getString(2);
					String strPatientName = ws.getString(3);
					String strFatherOrHusbandName = ws.getString(4);
					String strReligion = ws.getString(5);
					String strCategoryCode = ws.getString(6);

					if (strAgeAndSex == null)
						strAgeAndSex = "";
					if (strPatientName == null)
						strPatientName = "";
					if (strFatherOrHusbandName == null)
						strFatherOrHusbandName = "";
					if (strReligion == null)
						strReligion = "";
					if (strCategoryCode == null)
						strCategoryCode = "";
					
					sb.append("<table width='TABLEWIDTH' align='center'>");
					sb.append("<tr><td width='25%' class='LABEL'>Name</td>");
					sb.append("<td colspan='3' width='25%' class='CONTROL'> ");
					sb.append(strPatientName);
					sb.append("</td></tr>");
					sb.append("<tr><td width='25%' class='LABEL'>Patient Category</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strCategoryCode);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Age/Sex</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strAgeAndSex);
					sb.append("</td></tr>");
					sb.append("<tr><td width='25%' class='LABEL'>Father/Husband Name</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strFatherOrHusbandName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Religion</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strReligion);
					sb.append("</td></tr>");
					sb.append("</table>");

				}

			} catch (SQLException e) {
				new HisException(
						"BILLING",
						"HLPClientDetail.getClientDetailDetails() -->",
						e.getMessage());
			}
		}

		return sb.toString();
	}

	
}
