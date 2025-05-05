package billing;

import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

public class HLPPatientDemographicDetails {

	public static String getPatientDemographicDetails1(String strCrNo , boolean fAddress) 
	{
   
		BillingVO voObj = new BillingVO();
		BillingBO boObj = new BillingBO();
		
		voObj.setStrValue1(strCrNo);
		StringBuffer sb = new StringBuffer("");
		try 
		{
		  boObj.getPatientDetails(voObj);
	      WebRowSet ws = voObj.getGblWs1();
		  if(voObj.getStrMsgType().equals("0"))
		  {			
			if (ws != null) 
		    {
			 if (ws.next()) 
			  {
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
					
					sb.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px'>");
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
					if(fAddress)
					{
						sb.append("<tr>");
						sb.append("<td width='25%' class='LABEL'>Address</td>");
						sb.append("<td colspan='3' class='CONTROL'>");
						sb.append(strAddress);
						sb.append("</td></tr>");
					}
					sb.append("</table>");

				}
		      }
			   else
			   {
				   sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
					sb.append("<tr>");
					sb.append("<td colspan='5'  CLASS='multiControl' >"
							+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED CR NO </div>" + "</TD>");

					sb.append("</tr>");
					sb.append("</table></div>");
					
			   } 
		     }
		   else
		   {	  
			  String err = voObj.getStrMsgString();   
		      sb.append("ERROR####"+err);
		   } 
		      
			}
		    catch (SQLException e)
		    {
				
			}
		

		return sb.toString();
	}

}
