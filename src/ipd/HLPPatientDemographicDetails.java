package ipd;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

public class HLPPatientDemographicDetails {

	public static String getPatientDemographicDetails1(String strCrNo , boolean fAddress) {

		IpdVO voObj = new IpdVO();
		IpdBO boObj = new IpdBO();
		
		voObj.setStrValue1(strCrNo);
		
		boObj.getPatientDetails(voObj);
		
		WebRowSet ws = voObj.getGblWs1();
		
		System.out.println("HLPPatientDemographicDetails  WS_SIZE----"+ws.size());
		
		StringBuffer sb = new StringBuffer("");

		if (ws != null) {

			try {
				if (ws.next()) {

					String strAgeAndSex = ws.getString(2);
					String strPatientName = ws.getString(3);
					String strFatherOrHusbandName = ws.getString(4);
					String strReligion = ws.getString(5);
					String strCategoryName = ws.getString(6);
					String strCategoryCode = ws.getString(7);
					String strAddress = ws.getString(8);

					if (strAgeAndSex == null)
						strAgeAndSex = "";
					if (strPatientName == null)
						strPatientName = "";
					if (strFatherOrHusbandName == null)
						strFatherOrHusbandName = "";
					if (strReligion == null)
						strReligion = "";
					if (strCategoryName == null)
						strCategoryName = "";
					if (strCategoryCode == null)
						strCategoryCode = "";
					if (strAddress == null)
						strAddress = "";
					
					sb.append("<table width='TABLEWIDTH' align='center'>");
					sb.append("<tr><td width='25%' class='LABEL'>Name</td>");
					sb.append("<td colspan='3' width='25%' class='CONTROL'> ");
					sb.append(strPatientName);
					sb.append("</td></tr>");
					sb.append("<tr><td width='25%' class='LABEL'>Patient Category</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strCategoryName);
					sb.append("<input type='hidden' name='strCatgoryCode' value='"+strCategoryCode+"'></td>");
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
					if(fAddress){
						sb.append("<tr>");
						sb.append("<td width='25%' class='LABEL'>Address</td>");
						sb.append("<td colspan='3' class='CONTROL'>");
						sb.append(strAddress);
						sb.append("</td></tr>");
					}
					sb.append("</table>");
				}

			} catch (SQLException e) 
			{
				e.printStackTrace();
				new HisException(
						"IPD",
						"HLPPatientDemographicDetails.getPatientDemographicDetails1() -->",
						e.getMessage());
			}
		}

		return sb.toString();
	}

}
