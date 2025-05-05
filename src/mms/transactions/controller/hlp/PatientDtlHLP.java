package mms.transactions.controller.hlp;

import javax.sql.rowset.WebRowSet;

import hisglobal.tools.hlp.GlobalVO;
import mms.MmsConfigUtil;
import mms.transactions.bo.PatientDtlBO;

public class PatientDtlHLP 
{
	public static String strTreamentCatCode="";
	public static String strAdmittedTreamentCatCode="";
	public static String strTreamentCatCodeGroup="";
	public static String strAdmittedTreamentCatCodeGroup="";
	//public static String strMobileNo="";
	public static String wardName="";
	public static String deptName="";

	public static String patientDtl(String strCrNo, boolean fAddress) throws Exception 
	{
		GlobalVO voObj = new GlobalVO();
		PatientDtlBO boObj = new PatientDtlBO();
		StringBuffer sb = new StringBuffer("");
		voObj.setStrValue1(strCrNo);
		String temp[] = null;
		String strPatientStatus = " ";
		WebRowSet ws = null;

		sb.append("");

		try 
		{
			System.out.println("-T-----PATIENT_DTL------- pkg_simple_view.PROC_HRGT_PATIENT_DTL [ Mode - 1 ] -------------");
			boObj.getPatientDetails(voObj);
			
			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());
			}

			ws = voObj.getGblWs1();
			if (ws != null && ws.size() > 0) 
			{
				if (ws.next()) 
				{
					String strAgeAndSex = ws.getString(2);
					String strPatientName = ws.getString(3);
					String strFatherOrHusbandName = ws.getString(4);
					String strSpouseName = ws.getString(5);
					String strReligion = ws.getString(6);
					String strCategoryName = ws.getString(7);
					String strCategoryCode = ws.getString(8);
					strTreamentCatCode=strCategoryCode;
					String strAddress = ws.getString(9);
					String strMlcNo = ws.getString(10);
					String strHiddenValue = ws.getString(11); 
					String catGrp = ws.getString(13);
					String visitType = ws.getString(15).split("\\^")[0];
					String episodeCode = ws.getString(15).split("\\^")[1];
					if (strHiddenValue == null)
						strHiddenValue = "----";
					String[] id = strHiddenValue.split("\\^");
					String strEmailId = ws.getString(16);

					if (strAgeAndSex == null)
						strAgeAndSex = "----";
					if (strPatientName == null)
						strPatientName = "----";
					if (strFatherOrHusbandName == null)
						strFatherOrHusbandName = "----";
					if (strSpouseName == null)
						strSpouseName = "----";
					if (strReligion == null)
						strReligion = "----";
					if (strCategoryName == null)
						strCategoryName = "----";
					if (strCategoryCode == null)
						strCategoryCode = "----";
					if (strAddress == null)
						strAddress = "----";					
					if (strMlcNo == null)
						strMlcNo = "-----";
					sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
					sb.append("<tr><td width='25%' class='LABEL'>Name</td>");
					sb.append("<td colspan='3' width='75%' class='CONTROL'> ");
					sb.append(strPatientName);
					sb.append("</td></tr>");
					sb.append("<tr><td width='25%' class='LABEL'>Patient Category</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strCategoryName);
					sb.append("<input type='hidden' name='strCatgoryCode' value='"+ strCategoryCode + "'><input type='hidden' name='strCatGrp' value='"+ catGrp + "'><input type='hidden' name='strVisitType' value='"+ visitType + "'><input type='hidden' name='strEpisodeCode' value='"+ episodeCode + "'></td>");
					sb.append("<td width='25%' class='LABEL'>Age/Gender</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strAgeAndSex);
					sb.append("</td></tr>");
					sb.append("<tr><td width='25%' class='LABEL'>Father Name</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strFatherOrHusbandName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Spouse Name</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strSpouseName);
					sb.append("</td>");
					sb.append("</tr>");
					if (id[4].equals("1")) 
					{
						sb.append("<tr>");
						sb.append("<td width='25%' class='LABEL'>MLC NO</td>");
						sb.append("<td colspan='3' width='75%' class='CONTROL'>");
						sb.append("<font color='red'>");
						sb.append(strMlcNo);
						sb.append("</font>");
						sb.append("</td></tr>");
					}
					sb.append("<tr><td>");
					sb.append("<input type='hidden' name='strPatientDtlHidVal' value='"	+ strHiddenValue + "'></td></tr>");
					temp = strHiddenValue.replace("^", "#").split("#");
					strPatientStatus = temp[2];
					sb.append("</td></tr>");
					sb.append("<input type='hidden' name='strPatientStatus' id='strPatientStatus' value='"+ strPatientStatus + "'>");
					sb.append("<input type='hidden' name='strEmailId' id='strEmailId' value='"+ strEmailId + "'>");

					if (fAddress) 
					{
						sb.append("<tr>");
						sb.append("<td width='25%' class='LABEL'>Address</td>");
						sb.append("<td colspan='3' width='75%' class='CONTROL'>");
						sb.append(strAddress);
						sb.append("</td></tr>");
					}
					sb.append("</table>");
				}
			}
			else 
			{
				throw new Exception("Invalid CR. No.");
			}
		} 
		catch (Exception e) 
		{
			throw new Exception("PatientDtlHLP-->patientDtl-->"	+ e.getMessage());
		} 
		finally 
		{
			if (ws != null) 
			{
				ws.close();
				ws = null;
			}
		}
		return sb.toString();
	}
	
	
	
	public static String patientDtlNEW(String strCrNo, boolean fAddress) throws Exception 
	{
		GlobalVO voObj = new GlobalVO();
		PatientDtlBO boObj = new PatientDtlBO();
		StringBuffer sb = new StringBuffer("");
		voObj.setStrValue1(strCrNo);
		String temp[] = null;
		String strPatientStatus = " ";
		WebRowSet ws = null;

		sb.append("");

		try 
		{
			boObj.getPatientDetails(voObj);
			
			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());
			}

			ws = voObj.getGblWs1();
			if (ws != null && ws.size() > 0) 
			{
				if (ws.next()) 
				{
					String strAgeAndSex = ws.getString(2);
					String strPatientName = ws.getString(3);
					String strFatherOrHusbandName = ws.getString(4);
					String strSpouseName = ws.getString(5);
					String strReligion = ws.getString(6);
					String strCategoryName = ws.getString(7);
					String strCategoryCode = ws.getString(8);
					strTreamentCatCode=strCategoryCode;
					String strAddress = ws.getString(9);
					String strMlcNo = ws.getString(10);
					String strHiddenValue = ws.getString(11); 
					String catGrp = ws.getString(13);
					String visitType = ws.getString(15).split("\\^")[0];
					String episodeCode = ws.getString(15).split("\\^")[1];
					if (strHiddenValue == null)
						strHiddenValue = "----";
					String[] id = strHiddenValue.split("\\^");
					String strEmailId = ws.getString(16);

					if (strAgeAndSex == null)
						strAgeAndSex = "----";
					if (strPatientName == null)
						strPatientName = "----";
					if (strFatherOrHusbandName == null)
						strFatherOrHusbandName = "----";
					if (strSpouseName == null)
						strSpouseName = "----";
					if (strReligion == null)
						strReligion = "----";
					if (strCategoryName == null)
						strCategoryName = "----";
					if (strCategoryCode == null)
						strCategoryCode = "----";
					if (strAddress == null)
						strAddress = "----";					
					if (strMlcNo == null)
						strMlcNo = "-----";
					
					sb.append("<div>");
					sb.append("<div class='row rowFlex reFlex'>");
					sb.append("<div class='col-md-2 px-4'>Name");sb.append("</div>");
					sb.append("<div class='col-md-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");sb.append(strPatientName);sb.append("</div>");
					sb.append("<div class='col-md-2'>Patient Category");sb.append("</div>");
					sb.append("<div class='col-md-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");sb.append(strCategoryName);					sb.append("<input type='hidden' name='strCatgoryCode' value='"+ strCategoryCode + "'><input type='hidden' name='strCatGrp' value='"+ catGrp + "'><input type='hidden' name='strVisitType' value='"+ visitType + "'><input type='hidden' name='strEpisodeCode' value='"+ episodeCode + "'>");
					sb.append("</div>");
					sb.append("<div class='col-md-2'>Age/Gender");sb.append("</div>");
					sb.append("<div class='col-md-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");sb.append(strAgeAndSex);sb.append("</div>");
					sb.append("</div>");
					
					sb.append("<div class='row rowFlex reFlex'>");
					sb.append("<div class='col-md-2 px-4'>Father Name");sb.append("</div>");
					sb.append("<div class='col-md-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");sb.append(strFatherOrHusbandName);sb.append("</div>");
					sb.append("<div class='col-md-2'>Spouse Name");sb.append("</div>");
					sb.append("<div class='col-md-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");sb.append(strSpouseName);sb.append("</div>");
					
					
					
					
					if (id[4].equals("1")) 
					{
						sb.append("<div class='col-md-2'>MLC NO");sb.append("</div>");
						sb.append("<div class='col-md-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");sb.append(strMlcNo);sb.append("</div>");
						sb.append("</div>");
						
					}
					else
					{
						sb.append("</div>");
					}
					
					sb.append("<div class='row rowFlex reFlex'>");
					sb.append("<div class='col-md-12 px-4'>");
					sb.append("<input type='hidden' name='strPatientDtlHidVal' value='"	+ strHiddenValue + "'>");
					temp = strHiddenValue.replace("^", "#").split("#");
					strPatientStatus = temp[2];
					sb.append("</div>");
					sb.append("</div>");
					
					
					sb.append("<input type='hidden' name='strPatientStatus' id='strPatientStatus' value='"+ strPatientStatus + "'>");
					sb.append("<input type='hidden' name='strEmailId' id='strEmailId' value='"+ strEmailId + "'>");

					if (fAddress) 
					{
						sb.append("<div class='row rowFlex reFlex'>");
						sb.append("<div class='col-md-2  px-4'>Address");sb.append("</div>");
						sb.append("<div class='col-md-8' style='font-weight: 400;color: blue;word-wrap:break-word;'>");
						sb.append(strAddress);
						sb.append("</div>");
						sb.append("</div>");
						
					}
					
				}
			}
			else 
			{
				throw new Exception("Invalid CR. No.");
			}
			sb.append("</div>");
		} 
		catch (Exception e) 
		{
			throw new Exception("PatientDtlHLP-->patientDtl-->"	+ e.getMessage());
		} 
		finally 
		{
			if (ws != null) 
			{
				ws.close();
				ws = null;
			}
		}
		return sb.toString();
	}

	
	public static String patientDtlNEWBS(String strCrNo, boolean fAddress) throws Exception 
	{
		GlobalVO voObj = new GlobalVO();
		PatientDtlBO boObj = new PatientDtlBO();
		StringBuffer sb = new StringBuffer("");
		voObj.setStrValue1(strCrNo);
		String temp[] = null;
		String strPatientStatus = " ";
		WebRowSet ws = null;

		sb.append("");

		try 
		{
			boObj.getPatientDetails(voObj);
			
			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());
			}

			ws = voObj.getGblWs1();
			if (ws != null && ws.size() > 0) 
			{
				if (ws.next()) 
				{
					String strAgeAndSex = ws.getString(2);
					String strPatientName = ws.getString(3);
					String strFatherOrHusbandName = ws.getString(4);
					String strSpouseName = ws.getString(5);
					String strReligion = ws.getString(6);
					String strCategoryName = ws.getString(7);
					String strCategoryCode = ws.getString(8);
					strTreamentCatCode=strCategoryCode;
					String strAddress = ws.getString(9);
					String strMlcNo = ws.getString(10);
					String strHiddenValue = ws.getString(11); 
					String catGrp = ws.getString(13);
					String visitType = ws.getString(15).split("\\^")[0];
					String episodeCode = ws.getString(15).split("\\^")[1];
					if (strHiddenValue == null)
						strHiddenValue = "----";
					String[] id = strHiddenValue.split("\\^");
					String strEmailId = ws.getString(16);

					if (strAgeAndSex == null)
						strAgeAndSex = "----";
					if (strPatientName == null)
						strPatientName = "----";
					if (strFatherOrHusbandName == null)
						strFatherOrHusbandName = "----";
					if (strSpouseName == null)
						strSpouseName = "----";
					if (strReligion == null)
						strReligion = "----";
					if (strCategoryName == null)
						strCategoryName = "----";
					if (strCategoryCode == null)
						strCategoryCode = "----";
					if (strAddress == null)
						strAddress = "----";					
					if (strMlcNo == null)
						strMlcNo = "-----";
					
					sb.append("<div>");
					sb.append("<div class='row rowFlex reFlex'>");
					sb.append("<div class='col-sm-2'></div>");
					sb.append("<div class='col-sm-2'>Name");
					sb.append("</div>");
					sb.append("<div class='col-sm-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");
					sb.append(strPatientName);
					sb.append("</div>");
					sb.append("<div class='col-sm-2'>Patient Category");
					sb.append("</div>");
					sb.append("<div class='col-sm-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");
					sb.append(strCategoryName);			
					sb.append("<input type='hidden' name='strCatgoryCode' value='"+ strCategoryCode + "'><input type='hidden' name='strCatGrp' value='"+ catGrp + "'><input type='hidden' name='strVisitType' value='"+ visitType + "'><input type='hidden' name='strEpisodeCode' value='"+ episodeCode + "'>");
					sb.append("</div>");
					sb.append("<div class='col-sm-2'></div>");
					sb.append("</div>");
					
					sb.append("<div class='row rowFlex reFlex'>");
					sb.append("<div class='col-sm-2'></div>");
					sb.append("<div class='col-sm-2'>Age/Gender");
					sb.append("</div>");
					sb.append("<div class='col-sm-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");
					sb.append(strAgeAndSex);
					sb.append("</div>");
					
					sb.append("<div class='col-sm-2'>Father Name");sb.append("</div>");
					sb.append("<div class='col-sm-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");
					sb.append(strFatherOrHusbandName);sb.append("</div>");
					sb.append("</div>");
					sb.append("<div class='row rowFlex reFlex'>");
					sb.append("<div class='col-sm-2'></div>");
					sb.append("<div class='col-sm-2'>Spouse Name");
					sb.append("</div>");
					sb.append("<div class='col-sm-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");sb.append(strSpouseName);sb.append("</div>");
					
					
					
					
					if (id[4].equals("1")) 
					{
						sb.append("<div class='col-md-2'>MLC NO");sb.append("</div>");
						sb.append("<div class='col-md-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");sb.append(strMlcNo);sb.append("</div>");
						sb.append("</div>");
						
					}
					else
					{
						sb.append("</div>");
					}
					
					sb.append("<div class='row rowFlex reFlex'>");
					sb.append("<div class='col-md-12 px-4'>");
					sb.append("<input type='hidden' name='strPatientDtlHidVal' value='"	+ strHiddenValue + "'>");
					temp = strHiddenValue.replace("^", "#").split("#");
					strPatientStatus = temp[2];
					sb.append("</div>");
					sb.append("</div>");
					
					
					sb.append("<input type='hidden' name='strPatientStatus' id='strPatientStatus' value='"+ strPatientStatus + "'>");
					sb.append("<input type='hidden' name='strEmailId' id='strEmailId' value='"+ strEmailId + "'>");

					if (fAddress) 
					{
						sb.append("<div class='row rowFlex reFlex'>");
						sb.append("<div class='col-md-2'>");
						sb.append("</div>");
						sb.append("<div class='col-md-2'>Address");sb.append("</div>");
						sb.append("<div class='col-md-8' style='font-weight: 400;color: blue;word-wrap:break-word;'>");
						sb.append(strAddress);
						sb.append("</div>");
						sb.append("</div>");
						
					}
					
				}
			}
			else 
			{
				throw new Exception("Invalid CR. No.");
			}
			sb.append("</div>");
		} 
		catch (Exception e) 
		{
			throw new Exception("PatientDtlHLP-->patientDtl-->"	+ e.getMessage());
		} 
		finally 
		{
			if (ws != null) 
			{
				ws.close();
				ws = null;
			}
		}
		return sb.toString();
	}

	
	
	
	public static String patientDtlReturn(String strCrNo, boolean fAddress) throws Exception 
	{
		GlobalVO voObj = new GlobalVO();
		PatientDtlBO boObj = new PatientDtlBO();
		StringBuffer sb = new StringBuffer("");
		voObj.setStrValue1(strCrNo);
		String temp[] = null;
		String strPatientStatus = " ";
		WebRowSet ws = null;

		sb.append("");

		try 
		{
			boObj.getPatientDetails(voObj);
			
			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());
			}

			ws = voObj.getGblWs1();
			if (ws != null && ws.size() > 0) 
			{
				if (ws.next()) 
				{
					String strAgeAndSex = ws.getString(2);
					String strPatientName = ws.getString(3);
					String strFatherOrHusbandName = ws.getString(4);
					String strSpouseName = ws.getString(5);
					String strReligion = ws.getString(6);
					String strCategoryName = ws.getString(7);
					String strCategoryCode = ws.getString(8);
					strTreamentCatCode=strCategoryCode;
					String strAddress = ws.getString(9);
					String strMlcNo = ws.getString(10);
					String strHiddenValue = ws.getString(11); 
					String catGrp = ws.getString(13);
					String visitType = ws.getString(15).split("\\^")[0];
					String episodeCode = ws.getString(15).split("\\^")[1];
					if (strHiddenValue == null)
						strHiddenValue = "----";
					String[] id = strHiddenValue.split("\\^");
					String strEmailId = ws.getString(16);

					if (strAgeAndSex == null)
						strAgeAndSex = "----";
					if (strPatientName == null)
						strPatientName = "----";
					if (strFatherOrHusbandName == null)
						strFatherOrHusbandName = "----";
					if (strSpouseName == null)
						strSpouseName = "----";
					if (strReligion == null)
						strReligion = "----";
					if (strCategoryName == null)
						strCategoryName = "----";
					if (strCategoryCode == null)
						strCategoryCode = "----";
					if (strAddress == null)
						strAddress = "----";					
					if (strMlcNo == null)
						strMlcNo = "-----";
					sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
					sb.append("<tr><td width='25%' class='LABEL'>Name</td>");
					sb.append("<td colspan='3' width='75%' class='CONTROL'> ");
					sb.append(strPatientName);
					sb.append("</td></tr>");
					sb.append("<tr><td width='25%' class='LABEL'>Patient Category</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strCategoryName);
					sb.append("<input type='hidden' name='strCatgoryCode' value='"+ strCategoryCode + "'><input type='hidden' name='strCatGrp' value='"+ catGrp + "'><input type='hidden' name='strVisitType' value='"+ visitType + "'><input type='hidden' name='strEpisodeCode' value='"+ episodeCode + "'></td>");
					sb.append("<td width='25%' class='LABEL'>Age/Gender</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strAgeAndSex);
					sb.append("</td></tr>");
					sb.append("<tr><td width='25%' class='LABEL'>Father Name</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strFatherOrHusbandName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Spouse Name</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strSpouseName);
					sb.append("</td>");
					sb.append("</tr>");
					if (id[4].equals("1")) 
					{
						sb.append("<tr>");
						sb.append("<td width='25%' class='LABEL'>MLC NO</td>");
						sb.append("<td colspan='3' width='75%' class='CONTROL'>");
						sb.append("<font color='red'>");
						sb.append(strMlcNo);
						sb.append("</font>");
						sb.append("</td></tr>");
					}
					sb.append("<tr><td>");
					sb.append("<input type='hidden' name='strPatientDtlHidVal' value='"	+ strHiddenValue + "'></td></tr>");
					temp = strHiddenValue.replace("^", "#").split("#");
					strPatientStatus = temp[2];
					sb.append("</td></tr>");
					sb.append("<input type='hidden' name='strPatientStatus' id='strPatientStatus' value='"+ strPatientStatus + "'>");
					sb.append("<input type='hidden' name='strEmailId' id='strEmailId' value='"+ strEmailId + "'>");

					if (fAddress) 
					{
						sb.append("<tr>");
						sb.append("<td width='25%' class='LABEL'>Address</td>");
						sb.append("<td colspan='3' width='75%' class='CONTROL'>");
						sb.append(strAddress);
						sb.append("</td></tr>");
					}
					sb.append("</table>");
				}
			}
			else 
			{
				throw new Exception("Invalid CR. No.");
			}
		} 
		catch (Exception e) 
		{
			throw new Exception("PatientDtlHLP-->patientDtl-->"	+ e.getMessage());
		} 
		finally 
		{
			if (ws != null) 
			{
				ws.close();
				ws = null;
			}
		}
		return sb.toString();
	}

	private static String compactPatientDtl(String strCrNo, boolean fAddress) throws Exception 
	{
		WebRowSet ws = null;
		GlobalVO voObj = new GlobalVO();
		PatientDtlBO boObj = new PatientDtlBO();
		StringBuffer sb = new StringBuffer("");
		String categoryCode="";

		voObj.setStrValue1(strCrNo);
		sb.append("");

		try 
		{
			boObj.getPatientDetails(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());
			}

			ws = voObj.getGblWs1();

			if (ws != null && ws.size() > 0) 
			{
				if (ws.next()) 
				{
					String strHiddenValue = ws.getString(11); //strHiddenValue=DOB^GenderCode^PatStatusCode^CatCode^IsMLC^IsNewBorn^IDNo^FirstName^FatherName^NA^AGE_SEX^ISDEAD^CATGROUP^MOBILE_NO
					String[] id = strHiddenValue.split("\\^");//^ split not allowed so used \\^
					if(Integer.parseInt(ws.getString(14))>=0 || id[2].equals("2"))//2-Admitted .Expiry Check Only When Patient is in OPD
					{
						String strAgeAndSex = ws.getString(2);
						String strPatientName = ws.getString(3);
						String strFatherOrHusbandName = ws.getString(4);
						String strSpouseName = ws.getString(5);
						String strReligion = ws.getString(6);
						String strCategoryName = ws.getString(7);
						String strCategoryCode = ws.getString(8);
						categoryCode=ws.getString(8);
						strTreamentCatCode=categoryCode;
						strTreamentCatCodeGroup= ws.getString(13);
						String strAddress = ws.getString(9);
						String strMlcNo = ws.getString(10);
						String strMobileNo=id[13];
						
						
						String strPatStatus = "";
	
						//Old Status Codes(HRGT_PATIENT_DTL) 11-Admitted,12-OPD,13-Dead
						//New Status Codes(HRGT_PATIENT_DTL) 2-Admitted,3-OPD,1-Emg,Dead-New Column
						if (id[2].equals("2"))
							strPatStatus = "Admitted";
						if (id[2].equals("3"))
							strPatStatus = "OPD";
						if (id[2].equals("1"))
							strPatStatus = "Emergency";
						if (id[11].equals("1"))
							strPatStatus = "Dead";
						
						String strAgeInMonths = ws.getString(12);
						
						if (strAgeAndSex == null)
							strAgeAndSex = "----";
						if (strPatientName == null)
							strPatientName = "----";
						if (strFatherOrHusbandName == null)
							strFatherOrHusbandName = "----";
						if (strSpouseName == null)
							strSpouseName = "----";
						if (strReligion == null)
							strReligion = "----";
						if (strCategoryName == null)
							strCategoryName = "----";
						if (strCategoryCode == null)
							strCategoryCode = "----";
						if (strAddress == null)
							strAddress = "----";
						if (strMlcNo == null)
							strMlcNo = "-----";
	
						sb.append("<script type='text/javascript'>  ");
						sb.append(" function showPatDetails(divId){  ");
						sb.append(" document.getElementById(divId).style.display='block';  ");
						sb.append(" document.getElementById('minusId'+divId).style.display='block';  ");
						sb.append(" document.getElementById('plusId'+divId).style.display='none';	}  ");
	
						sb.append("  function hidePatDetails(divId){  ");
						sb.append(" document.getElementById(divId).style.display='none';  ");
						sb.append("	document.getElementById('minusId'+divId).style.display='none';  ");
						sb.append(" document.getElementById('plusId'+divId).style.display='block'; }  ");
						sb.append("	</script>  ");
	
						sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> <tr><td>");
						sb.append("<table width='100%' align='center' cellpadding='0' cellspacing='0'> ");
						sb.append("<tr> ");
						sb.append("<td width='20'> ");
						sb.append("<div id='plusIdonLineGblPatId' style='display:block' class='lineContinue2'> ");
						sb.append("<img src='../../hisglobal/images/plus.gif'  name='plusonLine' style='cursor:hand;cursor:pointer' align='middle' onclick='showPatDetails(\"onLineGblPatId\");' /></div> ");
						sb.append("<div id='minusIdonLineGblPatId' style='display:none' class='lineContinue2'><img src='../../hisglobal/images/minus.gif' style='cursor:hand;cursor:pointer' name='minusonLine' onclick='hidePatDetails(\"onLineGblPatId\");'></div> ");
						sb.append("</td> ");
						sb.append("<td colspan='2'><div class='lineContinue'><label class='DIVLABELCR_NEW'> &nbsp;Patient Name : ");
						if(strTreamentCatCodeGroup.equals("3"))
						    sb.append("<font color='red'>"+strPatientName+"</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Total Balance Limit : <font color='red'>"+ws.getString(20)+"</font>");
						else
							sb.append(strPatientName);
						sb.append("</label></div> </td> ");
						sb.append(" <td > <div align='right' class='lineContinue2'><label class='DIVLABELCR'>");
						sb.append("Status : " + strPatStatus + "&nbsp;");
						sb.append("</label> </div> </td> ");
						sb.append("</tr> ");
						sb.append("</table> ");
	
						sb.append(" </td> ");
						sb.append("</tr> ");
						sb.append("</table> ");
	
						sb.append("<div id='onLineGblPatId' style='display: none'>");
						sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
						sb.append("<tr><td width='25%' class='LABEL'>Patient Category</td>");
						sb.append("<td width='25%' class='CONTROL' id='strCategoryName'>");
						if(strTreamentCatCodeGroup.equals("3"))
							sb.append(strCategoryName+"[Organization:"+ws.getString(19)+"]"+"</td>");
						else
							sb.append(strCategoryName+"</td>");
						sb.append("<input type='hidden' name='strCatgoryCode' value='"+ strCategoryCode + "'><input type='hidden' name='strAgeInMonths' value='"+ strAgeInMonths + "'>");
						sb.append("<td width='25%' class='LABEL'>Age/Gender</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strAgeAndSex);
						sb.append("</td></tr>");
						sb.append("<tr><td width='25%' class='LABEL'>Father Name</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strFatherOrHusbandName);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Spouse Name</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strSpouseName);
						sb.append("</td>");
						sb.append("</tr>");
						
					
						if (id[4].equals("1")) 
						{
							sb.append("<tr>");
							sb.append("<td width='25%' class='LABEL'>MLC NO</td>");
							sb.append("<td colspan='3' width='75%' class='CONTROL'>");
							sb.append("<font color='red'>");
							sb.append(strMlcNo);
							sb.append("</font>");
							sb.append("</td></tr>");
						}
	
						sb.append("<input type='hidden' name='strPatientDtlHidVal' value='"	+ strHiddenValue + "'></td></tr>");
						sb.append("<input type='hidden' name='stravailpack' value='"	+ ws.getString(17) + "'></td></tr>");
						sb.append("<input type='hidden' name='stracc' value='"	+ ws.getString(18) + "'></td></tr>");
						//sb.append("<input type='hidden' name='strMobileNo' value='"	+ strMobileNo + "'></td></tr>");
						if (fAddress) 
						{
							sb.append("<tr>");
							sb.append("<td width='25%' class='LABEL'>Address</td>");
							sb.append("<td colspan='3' width='75%' class='CONTROL'>");
							sb.append(strAddress);
							sb.append("</td></tr>");
						}
						sb.append("</table>");
					}
					else
					{
						throw new Exception("Invalid CR. No./Category Expired");
					}
				}
			}
			else
			{				
				throw new Exception("Invalid CR. No.");	
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new Exception("PatientDtlHLP-->compactPatientDtl-->"+ e.getMessage());
		} 
		finally 
		{
			if (ws != null) 
			{
				ws.close();
				ws = null;
			}
		}

		return sb.toString();
	}

	private static String compactPatientDtlWithoutCatExpiryCheck(String strCrNo, boolean fAddress) throws Exception 
	{
		WebRowSet ws = null;
		GlobalVO voObj = new GlobalVO();
		PatientDtlBO boObj = new PatientDtlBO();
		StringBuffer sb = new StringBuffer("");
		String categoryCode="";

		voObj.setStrValue1(strCrNo);
		sb.append("");

		try 
		{
			boObj.getPatientDetailsWithoutCateXpiryCheck(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());
			}

			ws = voObj.getGblWs1();

			if (ws != null && ws.size() > 0) 
			{
				if (ws.next()) 
				{
					if(Integer.parseInt(ws.getString(14))>=0)
					{
						String strAgeAndSex = ws.getString(2);
						String strPatientName = ws.getString(3);
						String strFatherOrHusbandName = ws.getString(4);
						String strSpouseName = ws.getString(5);
						String strReligion = ws.getString(6);
						String strCategoryName = ws.getString(7);
						String strCategoryCode = ws.getString(8);
						categoryCode=ws.getString(8);
						strTreamentCatCode=categoryCode;
						strTreamentCatCodeGroup= ws.getString(13);
						String strAddress = ws.getString(9);
						String strMlcNo = ws.getString(10);
						String strHiddenValue = ws.getString(11); //strHiddenValue=DOB^GenderCode^PatStatusCode^CatCode^IsMLC^IsNewBorn^IDNo^FirstName^FatherName^NA^AGE_SEX^ISDEAD
						String[] id = strHiddenValue.split("\\^");//^ split not allowed so used \\^
						
						String strPatStatus = "";
	
						//Old Status Codes(HRGT_PATIENT_DTL) 11-Admitted,12-OPD,13-Dead
						//New Status Codes(HRGT_PATIENT_DTL) 2-Admitted,3-OPD,1-Emg,Dead-New Column
						if (id[2].equals("2"))
							strPatStatus = "Admitted"+" ("+ws.getString(15)+")";
						//System.out.println(ws.getString(16));
						if (id[2].equals("2") && !ws.getString(16).equals("0^0") )// PACKAGE AVAILED FOUND
						{
							String pkgDtls[]=ws.getString(16).replace("^","#").split("#");
							strPatStatus = "Admitted"+" ("+ws.getString(15)+") <a onclick=\"openPackageHLP('"+pkgDtls[0]+"')\" style='cursor:pointer;color:blue'>Package:"+pkgDtls[1]+"</a>";
						}
							
						if (id[2].equals("3"))
							strPatStatus = "OPD";
						if (id[11].equals("1"))
							strPatStatus = "Dead";
						
						String strAgeInMonths = ws.getString(12);
						
						if (strAgeAndSex == null)
							strAgeAndSex = "----";
						if (strPatientName == null)
							strPatientName = "----";
						if (strFatherOrHusbandName == null)
							strFatherOrHusbandName = "----";
						if (strSpouseName == null)
							strSpouseName = "----";
						if (strReligion == null)
							strReligion = "----";
						if (strCategoryName == null)
							strCategoryName = "----";
						if (strCategoryCode == null)
							strCategoryCode = "----";
						if (strAddress == null)
							strAddress = "----";
						if (strMlcNo == null)
							strMlcNo = "-----";
	
						sb.append("<script type='text/javascript'>  ");
						sb.append(" function showPatDetails(divId){  ");
						sb.append(" document.getElementById(divId).style.display='block';  ");
						sb.append(" document.getElementById('minusId'+divId).style.display='block';  ");
						sb.append(" document.getElementById('plusId'+divId).style.display='none';	document.getElementById('detailsdivid3').style.display='block'; }  ");
	
						sb.append("  function hidePatDetails(divId){  ");
						sb.append(" document.getElementById(divId).style.display='none';  ");
						sb.append("	document.getElementById('minusId'+divId).style.display='none';  ");
						sb.append(" document.getElementById('plusId'+divId).style.display='block'; document.getElementById('detailsdivid3').style.display='none'; }  ");
						sb.append("	</script>  ");
	
						sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> <tr><td>");
						sb.append("<table width='100%' align='center' cellpadding='0' cellspacing='0'> ");
						sb.append("<tr> ");
						sb.append("<td width='20'> ");
						sb.append("<div id='plusIdonLineGblPatId' style='display:block' class='lineContinue2'> ");
						sb.append("<img src='../../hisglobal/images/plus.gif'  name='plusonLine' style='cursor:hand;cursor:pointer' align='middle' onclick='showPatDetails(\"onLineGblPatId\");' /></div> ");
						sb.append("<div id='minusIdonLineGblPatId' style='display:none' class='lineContinue2'><img src='../../hisglobal/images/minus.gif' style='cursor:hand;cursor:pointer' name='minusonLine' onclick='hidePatDetails(\"onLineGblPatId\");'></div> ");
						sb.append("</td> ");
						sb.append("<td colspan='2'><div class='lineContinue'><label class='DIVLABELCR'>&nbsp;Patient Name (CR No.) : ");
						sb.append(strPatientName+" (" + ws.getString(1)+")");
						sb.append("</label></div> </td> ");
						sb.append(" <td > <div align='right' class='lineContinue2'><label class='DIVLABELCR'>");
						sb.append("Status : " + strPatStatus + "&nbsp;");
						sb.append("</label> </div> </td> ");
						sb.append("</tr> ");
						sb.append("</table> ");
	
						sb.append(" </td> ");
						sb.append("</tr> ");
						sb.append("</table> ");
	
						sb.append("<div id='onLineGblPatId' style='display: none'>");
						sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
						sb.append("<tr><td width='25%' class='LABEL'>Patient Category</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strCategoryName);
						sb.append("<input type='hidden' name='strCatgoryCode' value='"+ strCategoryCode + "'><input type='hidden' name='strAgeInMonths' value='"+ strAgeInMonths + "'></td>");
						sb.append("<td width='25%' class='LABEL'>Age/Gender</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strAgeAndSex);
						sb.append("</td></tr>");
						sb.append("<tr><td width='25%' class='LABEL'>Father Name</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strFatherOrHusbandName);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Spouse Name</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strSpouseName);
						sb.append("</td>");
						sb.append("</tr>");
					
						if (id[4].equals("1")) 
						{
							sb.append("<tr>");
							sb.append("<td width='25%' class='LABEL'>MLC NO</td>");
							sb.append("<td colspan='3' width='75%' class='CONTROL'>");
							sb.append("<font color='red'>");
							sb.append(strMlcNo);
							sb.append("</font>");
							sb.append("</td></tr>");
						}
	
						sb.append("<input type='hidden' name='strPatientDtlHidVal' value='"	+ strHiddenValue + "'></td></tr>");
						sb.append("<input type='hidden' name='strHiddenPuk' value='"	+ strCrNo + "'></td></tr>");
						
						if (fAddress) 
						{
							sb.append("<tr>");
							sb.append("<td width='25%' class='LABEL'>Address</td>");
							sb.append("<td colspan='3' width='75%' class='CONTROL'>");
							sb.append(strAddress);
							sb.append("</td></tr>");
						}
						sb.append("</table>");
					}
					else
					{
						throw new Exception("Invalid CR. No./Category Expired");
					}
				}
			}
			else
			{				
				throw new Exception("Invalid CR. No.");	
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new Exception("PatientDtlHLP-->compactPatientDtl-->"+ e.getMessage());
		} 
		finally 
		{
			if (ws != null) 
			{
				ws.close();
				ws = null;
			}
		}

		return sb.toString();
	}
	public static String admissionDtl(String strCrNo, String strHospitalCode) throws Exception 
	{
		WebRowSet ws = null;
		GlobalVO voObj = new GlobalVO();
		PatientDtlBO boObj = new PatientDtlBO();
		StringBuffer sb = new StringBuffer("");

		voObj.setStrValue1(strCrNo);
		voObj.setStrValue2(strHospitalCode);
		sb.append("");

		try 
		{
			System.out.println("<-------ADM_DTL------ pkg_ipd_view.PROC_HIPT_PATADMISSION_DTL [ Mode - 1 ] ------------->");
			boObj.getAdmissionDetails(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());
			}

			ws = voObj.getGblWs1();
			if (ws != null && ws.size() > 0) 
			{
				if (ws.next()) 
				{
					String strDeptName = ws.getString(1);
					String strUnitName = ws.getString(2);
					String strWardName = ws.getString(3);
					String strRoomName = ws.getString(4);
					String strBedName = ws.getString(5);
					String strTreatmentCategoryName = ws.getString(6);
					String strConsultantName = ws.getString(7);
					String strNewBornBabyFlag = ws.getString(8);
					String strHiddenValue = ws.getString(9);//strHiddenValue=ADMNO^EPCODE^VISITNO^ADMDATETIME^ADMADVNO^DEPTCODE^WARDCODE^ROOMCODE^BEDCODE^TREATCATCODE^ISNEWBORN^MOTHERADMNO^MLCNO^OCCUPID^BEDALLOCDATETIME^LENGTHOFSTAY

					if (strHiddenValue == null)
						strHiddenValue = "";
					
					String strTemp[] = strHiddenValue.replace("^", "#").split("#");

					String strAdmissionNo = strTemp[0];
					String strEpisodeCode = strTemp[1];
					String strAdmissionDate = strTemp[3];
					String strMotherAdmNo="";
					String strMLCNo = "";
					strAdmittedTreamentCatCode=strTemp[9];
					strAdmittedTreamentCatCodeGroup= ws.getString(10);
					if(strTemp.length>=12)
					{
						strMotherAdmNo = strTemp[11];
						strMLCNo = strTemp[12];
					}
					if (strDeptName == null)
						strDeptName = "";
					if (strUnitName == null)
						strUnitName = "";
					if (strWardName == null)
						strWardName = "";
					if (strRoomName == null)
						strRoomName = "";
					if (strBedName == null)
						strBedName = "";
					if (strTreatmentCategoryName == null)
						strTreatmentCategoryName = "";
					if (strConsultantName == null)
						strConsultantName = "";
					if (strNewBornBabyFlag == null)
						strNewBornBabyFlag = "";					
					if (strAdmissionNo == null)
						strAdmissionNo = "";
					if (strEpisodeCode == null)
						strEpisodeCode = "";
					if (strAdmissionDate == null)
						strAdmissionDate = "";
					if (strMotherAdmNo == null)
						strMotherAdmNo = "";
					if (strMLCNo == null)
						strMLCNo = "";
					sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
					sb.append("<tr><td width='25%' class='LABEL'>");
					sb.append("Adm No");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strAdmissionNo);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>");
					sb.append("Adm Date/Time");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strAdmissionDate);
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td width='25%' class='LABEL'>");
					sb.append("Dept / Unit");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strDeptName).append(" / ").append(strUnitName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>");
					sb.append("Ward / Room / Bed");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strWardName).append(" / ").append(strRoomName).append(" / ").append(strBedName);
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td width='25%' class='LABEL'>");
					sb.append("Treatment Category");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strTreatmentCategoryName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>");
					sb.append("Consultant Name");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strConsultantName);
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<input type='hidden' name='strAdmissionDtlHidVal' value='"+ strHiddenValue + "'>");
					sb.append("</td>");
					sb.append("</tr>");

					sb.append("</table>");
					wardName=strWardName;
					deptName=strDeptName;
				}
			}
		} 
		catch (Exception e) 
		{
			throw new Exception("PatientDtlHLP-->admissionDtl-->"+ e.getMessage());
		} 
		finally 
		{
			if (ws != null) 
			{
				ws.close();
				ws = null;
			}
		}

		return sb.toString();
	}

	
	public static String admissionDtlNEW(String strCrNo, String strHospitalCode) throws Exception 
	{
		WebRowSet ws = null;
		GlobalVO voObj = new GlobalVO();
		PatientDtlBO boObj = new PatientDtlBO();
		StringBuffer sb = new StringBuffer("");

		voObj.setStrValue1(strCrNo);
		voObj.setStrValue2(strHospitalCode);
		sb.append("");

		try 
		{
			boObj.getAdmissionDetails(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());
			}

			ws = voObj.getGblWs1();
			if (ws != null && ws.size() > 0) 
			{
				if (ws.next()) 
				{
					String strDeptName = ws.getString(1);
					String strUnitName = ws.getString(2);
					String strWardName = ws.getString(3);
					String strRoomName = ws.getString(4);
					String strBedName = ws.getString(5);
					String strTreatmentCategoryName = ws.getString(6);
					String strConsultantName = ws.getString(7);
					String strNewBornBabyFlag = ws.getString(8);
					String strHiddenValue = ws.getString(9);//strHiddenValue=ADMNO^EPCODE^VISITNO^ADMDATETIME^ADMADVNO^DEPTCODE^WARDCODE^ROOMCODE^BEDCODE^TREATCATCODE^ISNEWBORN^MOTHERADMNO^MLCNO^OCCUPID^BEDALLOCDATETIME^LENGTHOFSTAY

					if (strHiddenValue == null)
						strHiddenValue = "";
					
					String strTemp[] = strHiddenValue.replace("^", "#").split("#");

					String strAdmissionNo = strTemp[0];
					String strEpisodeCode = strTemp[1];
					String strAdmissionDate = strTemp[3];
					String strMotherAdmNo="";
					String strMLCNo = "";
					strAdmittedTreamentCatCode=strTemp[9];
					strAdmittedTreamentCatCodeGroup= ws.getString(10);
					if(strTemp.length>=12)
					{
						strMotherAdmNo = strTemp[11];
						strMLCNo = strTemp[12];
					}
					if (strDeptName == null)
						strDeptName = "";
					if (strUnitName == null)
						strUnitName = "";
					if (strWardName == null)
						strWardName = "";
					if (strRoomName == null)
						strRoomName = "";
					if (strBedName == null)
						strBedName = "";
					if (strTreatmentCategoryName == null)
						strTreatmentCategoryName = "";
					if (strConsultantName == null)
						strConsultantName = "";
					if (strNewBornBabyFlag == null)
						strNewBornBabyFlag = "";					
					if (strAdmissionNo == null)
						strAdmissionNo = "";
					if (strEpisodeCode == null)
						strEpisodeCode = "";
					if (strAdmissionDate == null)
						strAdmissionDate = "";
					if (strMotherAdmNo == null)
						strMotherAdmNo = "";
					if (strMLCNo == null)
						strMLCNo = "";
					
					sb.append("<div>");
					sb.append("<div class='row rowFlex reFlex'>");
					sb.append("<div class='col-md-2 px-4'>Adm No");sb.append("</div>");
					sb.append("<div class='col-md-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");sb.append(strAdmissionNo);sb.append("</div>");
					sb.append("<div class='col-md-2'>Adm Date/Time");sb.append("</div>");
					sb.append("<div class='col-md-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");sb.append(strAdmissionDate);
					sb.append("</div>");
					sb.append("<div class='col-md-2'>Dept / Unit");sb.append("</div>");
					sb.append("<div class='col-md-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");sb.append(strDeptName).append(" / ").append(strUnitName);sb.append("</div>");
					sb.append("</div>");
					
					sb.append("<div class='row rowFlex reFlex'>");
					sb.append("<div class='col-md-2 px-4'>Ward / Room / Bed");sb.append("</div>");
					sb.append("<div class='col-md-2' style='font-weight: 400;color: blue;word-wrap:break-word;''>");sb.append(strWardName).append(" / ").append(strRoomName).append(" / ").append(strBedName);sb.append("</div>");
					sb.append("<div class='col-md-2'>Treatment Category");sb.append("</div>");
					sb.append("<div class='col-md-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");sb.append(strTreatmentCategoryName);
					sb.append("</div>");
					sb.append("<div class='col-md-2'>Consultant Name");sb.append("</div>");
					sb.append("<div class='col-md-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");sb.append(strConsultantName);sb.append("</div>");
					sb.append("</div>");
					
					sb.append("<div class='row rowFlex reFlex'>");
					sb.append("<div class='col-md-12  px-4'>");
					sb.append("<input type='hidden' name='strAdmissionDtlHidVal' value='"+ strHiddenValue + "'>");
					sb.append("</div>");
					sb.append("</div>");
					
					sb.append("</div>");
					wardName=strWardName;
					deptName=strDeptName;
				}
			}
		} 
		catch (Exception e) 
		{
			throw new Exception("PatientDtlHLP-->admissionDtl-->"+ e.getMessage());
		} 
		finally 
		{
			if (ws != null) 
			{
				ws.close();
				ws = null;
			}
		}

		return sb.toString();
	}

	
	public static String admissionDtlNEWBS(String strCrNo, String strHospitalCode) throws Exception 
	{
		WebRowSet ws = null;
		GlobalVO voObj = new GlobalVO();
		PatientDtlBO boObj = new PatientDtlBO();
		StringBuffer sb = new StringBuffer("");

		voObj.setStrValue1(strCrNo);
		voObj.setStrValue2(strHospitalCode);
		sb.append("");

		try 
		{
			boObj.getAdmissionDetails(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());
			}

			ws = voObj.getGblWs1();
			if (ws != null && ws.size() > 0) 
			{
				if (ws.next()) 
				{
					String strDeptName = ws.getString(1);
					String strUnitName = ws.getString(2);
					String strWardName = ws.getString(3);
					String strRoomName = ws.getString(4);
					String strBedName = ws.getString(5);
					String strTreatmentCategoryName = ws.getString(6);
					String strConsultantName = ws.getString(7);
					String strNewBornBabyFlag = ws.getString(8);
					String strHiddenValue = ws.getString(9);//strHiddenValue=ADMNO^EPCODE^VISITNO^ADMDATETIME^ADMADVNO^DEPTCODE^WARDCODE^ROOMCODE^BEDCODE^TREATCATCODE^ISNEWBORN^MOTHERADMNO^MLCNO^OCCUPID^BEDALLOCDATETIME^LENGTHOFSTAY

					if (strHiddenValue == null)
						strHiddenValue = "";
					
					String strTemp[] = strHiddenValue.replace("^", "#").split("#");

					String strAdmissionNo = strTemp[0];
					String strEpisodeCode = strTemp[1];
					String strAdmissionDate = strTemp[3];
					String strMotherAdmNo="";
					String strMLCNo = "";
					strAdmittedTreamentCatCode=strTemp[9];
					strAdmittedTreamentCatCodeGroup= ws.getString(10);
					if(strTemp.length>=12)
					{
						strMotherAdmNo = strTemp[11];
						strMLCNo = strTemp[12];
					}
					if (strDeptName == null)
						strDeptName = "";
					if (strUnitName == null)
						strUnitName = "";
					if (strWardName == null)
						strWardName = "";
					if (strRoomName == null)
						strRoomName = "";
					if (strBedName == null)
						strBedName = "";
					if (strTreatmentCategoryName == null)
						strTreatmentCategoryName = "";
					if (strConsultantName == null)
						strConsultantName = "";
					if (strNewBornBabyFlag == null)
						strNewBornBabyFlag = "";					
					if (strAdmissionNo == null)
						strAdmissionNo = "";
					if (strEpisodeCode == null)
						strEpisodeCode = "";
					if (strAdmissionDate == null)
						strAdmissionDate = "";
					if (strMotherAdmNo == null)
						strMotherAdmNo = "";
					if (strMLCNo == null)
						strMLCNo = "";
					
					sb.append("<div>");
					sb.append("<div class='row rowFlex reFlex'>");
					sb.append("<div class='col-sm-2'>");sb.append("</div>");
					sb.append("<div class='col-sm-2'>Adm No");sb.append("</div>");
					sb.append("<div class='col-sm-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");sb.append(strAdmissionNo);sb.append("</div>");
					sb.append("<div class='col-sm-2'>Adm Date/Time");sb.append("</div>");
					sb.append("<div class='col-sm-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");sb.append(strAdmissionDate);
					sb.append("<div class='col-sm-2'>");sb.append("</div>");
					sb.append("</div>");
					sb.append("</div>");
					sb.append("<div class='row rowFlex reFlex'>");
					sb.append("<div class='col-sm-2'>");sb.append("</div>");
					sb.append("<div class='col-sm-2'>Dept / Unit");sb.append("</div>");
					sb.append("<div class='col-sm-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");sb.append(strDeptName).append(" / ").append(strUnitName);sb.append("</div>");
					
					
					
					sb.append("<div class='col-sm-2'>Ward / Room / Bed");sb.append("</div>");
					sb.append("<div class='col-sm-4' style='font-weight: 400;color: blue;word-wrap:break-word;''>");sb.append(strWardName).append(" / ").append(strRoomName).append(" / ").append(strBedName);sb.append("</div>");
					
					sb.append("</div>");
					sb.append("<div class='row rowFlex reFlex'>");
					sb.append("<div class='col-sm-2'>");sb.append("</div>");
					sb.append("<div class='col-sm-2'>Treatment Category");sb.append("</div>");
					
					sb.append("<div class='col-sm-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");sb.append(strTreatmentCategoryName);
					sb.append("</div>");
					sb.append("<div class='col-md-2'>Consultant Name");sb.append("</div>");
					sb.append("<div class='col-md-2' style='font-weight: 400;color: blue;word-wrap:break-word;'>");sb.append(strConsultantName);sb.append("</div>");
					sb.append("</div>");
					
					sb.append("<div class='row rowFlex reFlex'>");
					sb.append("<div class='col-md-12  px-4'>");
					sb.append("<input type='hidden' name='strAdmissionDtlHidVal' value='"+ strHiddenValue + "'>");
					sb.append("</div>");
					sb.append("</div>");
					
					sb.append("</div>");
					wardName=strWardName;
					deptName=strDeptName;
				}
			}
		} 
		catch (Exception e) 
		{
			throw new Exception("PatientDtlHLP-->admissionDtl-->"+ e.getMessage());
		} 
		finally 
		{
			if (ws != null) 
			{
				ws.close();
				ws = null;
			}
		}

		return sb.toString();
	}

	
	public static String admissionDtlReturn(String strCrNo, String strHospitalCode) throws Exception 
	{
		WebRowSet ws = null;
		GlobalVO voObj = new GlobalVO();
		PatientDtlBO boObj = new PatientDtlBO();
		StringBuffer sb = new StringBuffer("");

		voObj.setStrValue1(strCrNo);
		voObj.setStrValue2(strHospitalCode);
		sb.append("");

		try 
		{
			boObj.getAdmissionDetailsReturn(voObj);
			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());
			}

			ws = voObj.getGblWs1();
			if (ws != null && ws.size() > 0) 
			{
				if (ws.next()) 
				{
					String strDeptName = ws.getString(1);
					String strUnitName = ws.getString(2);
					String strWardName = ws.getString(3);
					String strRoomName = ws.getString(4);
					String strBedName = ws.getString(5);
					String strTreatmentCategoryName = ws.getString(6);
					String strConsultantName = ws.getString(7);
					String strNewBornBabyFlag = ws.getString(8);
					String strHiddenValue = ws.getString(9);//strHiddenValue=ADMNO^EPCODE^VISITNO^ADMDATETIME^ADMADVNO^DEPTCODE^WARDCODE^ROOMCODE^BEDCODE^TREATCATCODE^ISNEWBORN^MOTHERADMNO^MLCNO^OCCUPID^BEDALLOCDATETIME^LENGTHOFSTAY

					if (strHiddenValue == null)
						strHiddenValue = "";
					
					String strTemp[] = strHiddenValue.replace("^", "#").split("#");

					String strAdmissionNo = strTemp[0];
					String strEpisodeCode = strTemp[1];
					String strAdmissionDate = strTemp[3];
					String strMotherAdmNo="";
					String strMLCNo = "";
					strAdmittedTreamentCatCode=strTemp[9];
					strAdmittedTreamentCatCodeGroup= ws.getString(10);
					if(strTemp.length>=12)
					{
						strMotherAdmNo = strTemp[11];
						strMLCNo = strTemp[12];
					}
					if (strDeptName == null)
						strDeptName = "";
					if (strUnitName == null)
						strUnitName = "";
					if (strWardName == null)
						strWardName = "";
					if (strRoomName == null)
						strRoomName = "";
					if (strBedName == null)
						strBedName = "";
					if (strTreatmentCategoryName == null)
						strTreatmentCategoryName = "";
					if (strConsultantName == null)
						strConsultantName = "";
					if (strNewBornBabyFlag == null)
						strNewBornBabyFlag = "";					
					if (strAdmissionNo == null)
						strAdmissionNo = "";
					if (strEpisodeCode == null)
						strEpisodeCode = "";
					if (strAdmissionDate == null)
						strAdmissionDate = "";
					if (strMotherAdmNo == null)
						strMotherAdmNo = "";
					if (strMLCNo == null)
						strMLCNo = "";
					sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
					sb.append("<tr><td width='25%' class='LABEL'>");
					sb.append("Adm No");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strAdmissionNo);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>");
					sb.append("Adm Date/Time");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strAdmissionDate);
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td width='25%' class='LABEL'>");
					sb.append("Dept / Unit");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strDeptName).append(" / ").append(strUnitName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>");
					sb.append("Ward / Room / Bed");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strWardName).append(" / ").append(strRoomName).append(" / ").append(strBedName);
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td width='25%' class='LABEL'>");
					sb.append("Treatment Category");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strTreatmentCategoryName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>");
					sb.append("Consultant Name");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strConsultantName);
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<input type='hidden' name='strAdmissionDtlHidVal' value='"+ strHiddenValue + "'>");
					sb.append("</td>");
					sb.append("</tr>");

					sb.append("</table>");
					wardName=strWardName;
					deptName=strDeptName;
				}
			}
		} 
		catch (Exception e) 
		{
			throw new Exception("PatientDtlHLP-->admissionDtl-->"+ e.getMessage());
		} 
		finally 
		{
			if (ws != null) 
			{
				ws.close();
				ws = null;
			}
		}

		return sb.toString();
	}

	// //used
	public static String patientWithAdmissionDtl(String strCrNo,
			String strHospitalCode, boolean fAddress) throws Exception {

		StringBuffer sb = new StringBuffer("");

		try {
			sb.append(PatientDtlHLP.patientDtl(strCrNo, fAddress));
			sb.append(PatientDtlHLP.admissionDtl(strCrNo, strHospitalCode));
		} catch (Exception e) {
			sb.append("Invalid CrNo");
			throw new Exception("PatientDtlHLP-->patientWithAdmissionDtl-->"
					+ e.getMessage());
		}

		return sb.toString();
	}
	
	
	
	
	public static String patientWithAdmissionDtlNEW(String strCrNo,
			String strHospitalCode, boolean fAddress) throws Exception {

		StringBuffer sb = new StringBuffer("");

		try {
			sb.append(PatientDtlHLP.patientDtlNEW(strCrNo, fAddress));
			sb.append(PatientDtlHLP.admissionDtlNEW(strCrNo, strHospitalCode));
		} catch (Exception e) {
			sb.append("Invalid CrNo");
			throw new Exception("PatientDtlHLP-->patientWithAdmissionDtl-->"
					+ e.getMessage());
		}

		return sb.toString();
	}

	
	public static String patientWithAdmissionDtlReturn(String strCrNo,
			String strHospitalCode, boolean fAddress) throws Exception {

		StringBuffer sb = new StringBuffer("");

		try {
			sb.append(PatientDtlHLP.patientDtlReturn(strCrNo, fAddress));
			sb.append(PatientDtlHLP.admissionDtlReturn(strCrNo, strHospitalCode));
		} catch (Exception e) {
			sb.append("Invalid CrNo");
			throw new Exception("PatientDtlHLP-->patientWithAdmissionDtl-->"
					+ e.getMessage());
		}

		return sb.toString();
	}


	public static String compactPatientWithAdmissionDtl(String strCrNo,String strHospitalCode, boolean fAddress) throws Exception 
	{
		StringBuffer sb = new StringBuffer("");
		try 
		{
			sb.append(PatientDtlHLP.compactPatientDtl(strCrNo, fAddress));
			String str=PatientDtlHLP.admissionDtl(strCrNo, strHospitalCode);
			
			if(str!=null && !str.equals(""))
				sb.append(str+"</div>");//To check Whether Admission Details Found or Not--OFFLINE BILLING CASE MAY OR MAY NOT BE FOUND.ONLINE SHOULD BE FOUND.
			else
				sb.append("</div>");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new Exception("PatientDtlHLP-->compactPatientWithAdmissionDtl-->"+ e.getMessage());
		}
		return sb.toString();
	}

	public static String patientDtlBillRePrint(String strCrNo, boolean fAddress)
			throws Exception {
		WebRowSet ws = null;
		GlobalVO voObj = new GlobalVO();
		PatientDtlBO boObj = new PatientDtlBO();
		StringBuffer sb = new StringBuffer("");
		voObj.setStrValue1(strCrNo);

		sb.append("");

		try {
			boObj.getPatientDetails(voObj);
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}

			ws = voObj.getGblWs1();
			if (ws != null && ws.size() > 0) {
				if (ws.next()) {
					String strAgeAndSex = ws.getString(2);
					String strPatientName = ws.getString(3);
					String strFatherOrHusbandName = ws.getString(4);
					String strSpouseName = ws.getString(5);
					String strReligion = ws.getString(6);
					String strCategoryName = ws.getString(7);
					String strCategoryCode = ws.getString(8);
					String strAddress = ws.getString(9);
					String strMlcNo = ws.getString(10);
					String strHiddenValue = ws.getString(11); // Is MLC or Not
																// at 4th
																// Position
					String[] id = strHiddenValue.replace("^", "#").split("#");

					if (strAgeAndSex == null)
						strAgeAndSex = "----";
					if (strPatientName == null)
						strPatientName = "----";
					if (strFatherOrHusbandName == null)
						strFatherOrHusbandName = "----";
					if (strReligion == null)
						strReligion = "----";
					if (strCategoryName == null)
						strCategoryName = "----";
					if (strCategoryCode == null)
						strCategoryCode = "----";
					if (strAddress == null)
						strAddress = "----";
					if (strHiddenValue == null)
						strHiddenValue = "----";
					if (strMlcNo == null)
						strMlcNo = "-----";

					if (strSpouseName == null)
						strSpouseName = "-----";

					sb
							.append("<table width='100%' border='0' cellspacing='1px' align='center' ><tr><td width='25%' class='LABEL'>Name</td>");
					sb.append("<td colspan='3' width='25%' class='CONTROL'> ");
					sb.append(strPatientName);
					sb.append("</td></tr>");
					sb
							.append("<tr><td width='25%' class='LABEL'>Patient Category</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strCategoryName);
					sb
							.append("<input type='hidden' name='strCatgoryCode' value='"
									+ strCategoryCode + "'></td>");
					sb.append("<td width='25%' class='LABEL'>Age/Gender</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strAgeAndSex);
					sb.append("</td></tr>");
					sb
							.append("<tr><td width='25%' class='LABEL'>Father Name</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strFatherOrHusbandName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Spouse Name</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strSpouseName);
					if (id[4].equals("1")) {
						sb.append("<tr>");
						sb.append("<td width='25%' class='LABEL'>MLC NO</td>");
						sb
								.append("<td colspan='3' width='25%' class='CONTROL'>");
						sb.append("<font color='red'>");
						sb.append(strMlcNo);
						sb.append("</font>");
						sb.append("</td></tr>");
					}

					sb
							.append("<input type='hidden' name='strPatientDtlHidVal' value='"
									+ strHiddenValue + "'></td></tr>");
					if (fAddress) {
						sb.append("<tr>");
						sb.append("<td width='25%' class='LABEL'>Address</td>");
						sb
								.append("<td colspan='3' width='25%' class='CONTROL'>");
						sb.append(strAddress);
						sb.append("</td></tr>");
					}

					sb.append("</table>");
				}
			}
		} catch (Exception e) {
			throw new Exception("PatientDtlHLP-->admissionDtl-->"
					+ e.getMessage());
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}

		return sb.toString();
	}
	
	//added by shefali on 26-Aug-2014 for patient treatment detail in issu eto patient
	public static String patientTreatmentDtl(String strCrNo,String strHospitalCode)
	throws Exception 
	{
		GlobalVO voObj = new GlobalVO();
		PatientDtlBO boObj = new PatientDtlBO();
		StringBuffer str = new StringBuffer("");
		voObj.setStrValue1(strCrNo);
		voObj.setStrValue2(strHospitalCode);
		WebRowSet ws = null;
		
		str.append("");
		
		try 
		{
			System.out.println("<------TREATMENT_DTL------- pkg_simple_view.PROC_HRGT_PATIENT_TREATMENT_DTL [ Mode - 1 ] ------------->");
			
			boObj.getPatientTreatmentDetails(voObj);
			if (voObj.getStrMsgType().equals("1"))
			{
				throw new Exception(voObj.getStrMsgString());
			}
		
			ws = voObj.getGblWs2();
			
			//System.out.println("ws:: HLp"+ws.size());
			if (ws != null && ws.size() > 0)
			{
				/*
				 * str.append("<label>Treatment Details</label>");
				 */				
				str.append("<table width='100%'><tr>");
				str.append("<th align='left'   class='multiLabel' style='width:30%;text-align: center !important;'>Item Name</th>");
				str.append("<th align='center' class='multiLabel' style='width:20%'>Episode Date</th>");
				str.append("<th align='center' class='multiLabel' style='width:10%'>Department</th>");
				str.append("<th align='center' class='multiLabel' style='width:10%'>Issue Qty.</th>");
				str.append("<th align='center' class='multiLabel' style='width:5%'>Doses</th>");
				str.append("<th align='center' class='multiLabel' style='width:5%'>Frequency</th>");
				str.append("<th align='center' class='multiLabel' style='width:10%'>Start Date</th>");
				str.append("<th align='center' class='multiLabel' style='width:10%'>End Date</th>");
				str.append("</tr>");
				int strcount=0;
			    while (ws.next()) 
			    {
					String strdrugName = ws.getString(8);
					String strDoseName = ws.getString(10);
					String strFrequency = ws.getString(24);
					String strStartDate = ws.getString(13);
					String strEndDate = ws.getString(14);
					String strEpisodeDate = ws.getString(30);
					String strDeptName = ws.getString(31);
					String strIssueQty = ws.getString(26);
					String strRequredQty = ws.getString(27);
				
					if (strdrugName == null)
						strdrugName = "----";
					if (strDoseName == null)
						strDoseName = "----";
					if (strFrequency == null)
						strFrequency = "----";
					if (strStartDate == null)
						strStartDate = "----";
					if (strEndDate == null)
						strEndDate = "----";
				
					str.append("<tr>");
					str.append("<td align='left' class='multiControl' style='text-align: left !important;'>");
					str.append(strdrugName);
					
					str.append("</td><td align='center' class='multiControl' >");
					str.append(strEpisodeDate);
					
					str.append("</td><td align='center' class='multiControl'>");
					str.append(strDeptName);
					
					
					str.append("</td><td align='center' class='multiControl'>");
					str.append(strIssueQty);
					
					str.append("</td><td align='center' class='multiControl'>");
					str.append(strDoseName);
					str.append("</td><td align='center' class='multiControl'><i class='fas fa-tablets text-warning'></i>&nbsp;");
					str.append(strFrequency);
					str.append("</td><td align='center' class='multiControl'>");
					str.append(strStartDate);
					str.append("</td><td align='center' class='multiControl'>");
					str.append(strEndDate);
					str.append("</td>");
					str.append("</tr>");
					if(!strIssueQty.equalsIgnoreCase(strRequredQty))
						strcount++;
		
				}
			    //str.append("</br>");
				str.append("</table>");
				str.append("<input type='hidden' name='strTreatmentDtlCount' id='strTreatmentDtlCountId' value='"+strcount+"'>");
				
				// str.append("</br>");
			} 
			else 
			{
				str.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
				str.append("<tr><td align='center'  class='multiControl' ><font color='red'><b>No record Found In Treatment Details</b></font></td></tr></table>");
				str.append("<input type='hidden' name='strTreatmentDtlCount' id='strTreatmentDtlCountId' value='0'>");
				
			} 
		}
		catch (Exception e) 
		{
			throw new Exception("PatientDtlHLP-->patientTreatmentDtl-->"+ e.getMessage());
		} 
		finally
		{
			if (ws != null) 
			{
				ws.close();
				ws = null;
		  	}
		}
		return str.toString();
	}
	
	public static String patientTreatmentDtl_BS(String strCrNo,String strHospitalCode)
	throws Exception 
	{
		GlobalVO voObj = new GlobalVO();
		PatientDtlBO boObj = new PatientDtlBO();
		StringBuffer str = new StringBuffer("");
		voObj.setStrValue1(strCrNo);
		voObj.setStrValue2(strHospitalCode);
		WebRowSet ws = null;
		
		str.append("");
		
		try 
		{
			boObj.getPatientTreatmentDetails(voObj);
			if (voObj.getStrMsgType().equals("1"))
			{
				throw new Exception(voObj.getStrMsgString());
			}
		
			ws = voObj.getGblWs2();
			
			//System.out.println("ws:: HLp"+ws.size());
			if (ws != null && ws.size() > 0)
			{
				/*
				 * str.append("<label>Treatment Details</label>");
				 */				
				str.append("<table class='table'><thead>");
				str.append("<th align='center' style=\"width:20%\">Item Name</th>");
				str.append("<th align='center' style=\"width:15%\">Batch No</th>");
				str.append("<th align='center' style=\"width:15%\">Avl Qty</th>");
				str.append("<th align='center' style=\"width:15%\">Cost/Unit</th>");
				str.append("<th align='center' style=\"width:15%\">Quantity</th>");
				str.append("<th align='center' style=\"width:15%\">Cost</th>");
				str.append("<th align='center' style=\"width:5%\">-</th>");

				str.append("</thead>");
				
			    while (ws.next()) 
			    {
					String strdrugName = ws.getString(8);
					String strDoseName = ws.getString(10);
					String strFrequency = ws.getString(24);
					String strStartDate = ws.getString(13);
					String strEndDate = ws.getString(14);
				
					if (strdrugName == null)
						strdrugName = "----";
					if (strDoseName == null)
						strDoseName = "----";
					if (strFrequency == null)
						strFrequency = "----";
					if (strStartDate == null)
						strStartDate = "----";
					if (strEndDate == null)
						strEndDate = "----";
				
					str.append("<tbody>");
					str.append("<td align='center' style='width:20%; font-weight: 400; font-size: 0.8rem; color: #495057;'>");
					str.append(strdrugName);
					str.append("</td><td align='center' style='width:15%; font-weight: 400; font-size: 0.8rem; color: #495057;' >");
					str.append(strDoseName);
					str.append("</td><td align='center' style='width:15%; font-weight: 400; font-size: 0.8rem; color: #495057;' >");
					str.append(strFrequency);
					str.append("</td><td align='center' style='width:15%; font-weight: 400; font-size: 0.8rem; color: #495057;' >");
					str.append(strStartDate);
					str.append("</td><td align='center' style='width:15%; font-weight: 400; font-size: 0.8rem; color: #495057;' >");
					str.append("<input type=\"text\" name=\"strQtyText\"  style='width:50%;display:inline!important' class='form-control'  onblur=\"QtyValidation('#delIndex#');\" maxlength=\"5\" onkeypress=\"return validateData(event,5);\"  tabindex=\"1\"> <font style='display:inline'>No.</font>");
					str.append("</td><td align='center' style='width:15%; font-weight: 400; font-size: 0.8rem; color: #495057;' >");
					str.append("<input type=\"hidden\" name=\"strTotalCost\" id=\"strTotalCost#delIndex#\" class='txtFldMin'  >\r\n" + 
							"		<div id=\"strQuantityText#delIndex#\" style=\"display: block\">\r\n" + 
							"			<input type=\"text\" name=\"strTotalCostText\" id=\"strTotalCostText#delIndex#\" style='width:50%;display:inline!important' class='form-control'  onkeyup=\"\" maxlength=\"5\"    readonly/>\r\n" + 
							"		</div>");
					
					str.append("</td><td align='center' style='width:5%; font-weight: 400; font-size: 0.8rem; color: #495057;' >");
					str.append("<div id=\"strQuantityText#delIndex#\" style=\"display: block\">\r\n" + 
							"			<img style=\"cursor: pointer;height: 20px\" id='strDeleteButtonDivId' tabindex='2' src=\"../../hisglobal/images/Minus.png\" onclick=\"deleteRow('#delIndex#','1','0');\" title=\"Click here to Delete Item\">\r\n" + 
							"		</div>");
					str.append("</td>");
					str.append("</tbody>");
		
				}
			    str.append("</br>");
				str.append("</table>");
				 str.append("</br>");
			} 
			else 
			{
				str.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
				str.append("<tr><td align='center'><font color='red'><b>No record Found In Treatment Details</b></font></td></tr></table>");
			} 
		}
		catch (Exception e) 
		{
			throw new Exception("PatientDtlHLP-->patientTreatmentDtl-->"+ e.getMessage());
		} 
		finally
		{
			if (ws != null) 
			{
				ws.close();
				ws = null;
		  	}
		}
		return str.toString();
	}
	
	
	
	
	public static String compactPatientWithAdmissionDtlWithoutCatExpiryCheck(String strCrNo,String strHospitalCode, boolean fAddress) throws Exception 
	{
		StringBuffer sb = new StringBuffer("");
		try 
		{
			sb.append(PatientDtlHLP.compactPatientDtlWithoutCatExpiryCheck(strCrNo, fAddress));
			String str=PatientDtlHLP.admissionDtl(strCrNo, strHospitalCode);
			sb.append("</div>");
			/*if(str!=null && !str.equals(""))
				sb.append(str+"~1");*///To check Whether Admission Details Found or Not
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new Exception("PatientDtlHLP-->compactPatientWithAdmissionDtl-->"+ e.getMessage());
		}
		return sb.toString();
	}
	public static String admissionDtlRequestForLP(String strCrNo, String strHospitalCode,String balanceAmount,String AccountNo,String patType)
			throws Exception {

		WebRowSet ws = null;
		GlobalVO voObj = new GlobalVO();
		PatientDtlBO boObj = new PatientDtlBO();
		StringBuffer sb = new StringBuffer("");
		MmsConfigUtil mcu = null;
		voObj.setStrValue1(strCrNo);
		voObj.setStrValue2(strHospitalCode);
		sb.append(" ");

		try {
			mcu = new MmsConfigUtil(strHospitalCode);
			boObj.getAdmissionDetails(voObj);
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}

			ws = voObj.getGblWs1();
			if (ws != null && ws.size() > 0) {
				if (ws.next()) {

					String strDeptName = ws.getString(1);
					String strUnitName = ws.getString(2);
					String strWardName = ws.getString(3);
					String strRoomName = ws.getString(4);
					String strBedName = ws.getString(5);
					String strTreatmentCategoryName = ws.getString(6);
					String strConsultantName = ws.getString(7);
					String strNewBornBabyFlag = ws.getString(8);
					String strHiddenValue = ws.getString(9);

					String strTemp[] = strHiddenValue.replace("^", "#").split(
							"#");

					String strAdmissionNo = strTemp[0];
					String strEpisodeCode = strTemp[1];
					String strAdmissionDate = strTemp[3];
					String strMotherAdmNo = strTemp[11];
					String strMLCNo = strTemp[12];

					if (strDeptName == null)
						strDeptName = "";
					if (strUnitName == null)
						strUnitName = "";
					if (strWardName == null)
						strWardName = "";
					if (strRoomName == null)
						strRoomName = "";
					if (strBedName == null)
						strBedName = "";
					if (strTreatmentCategoryName == null)
						strTreatmentCategoryName = "";
					if (strConsultantName == null)
						strConsultantName = "";
					if (strNewBornBabyFlag == null)
						strNewBornBabyFlag = "";
					if (strHiddenValue == null)
						strHiddenValue = "";
					if (strAdmissionNo == null)
						strAdmissionNo = "";
					if (strEpisodeCode == null)
						strEpisodeCode = "";
					if (strAdmissionDate == null)
						strAdmissionDate = "";
					if (strMotherAdmNo == null)
						strMotherAdmNo = "";
					if (strMLCNo == null)
						strMLCNo = "";
					sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
					sb.append("<tr><td width='25%' class='LABEL'>");
					sb.append("Adm No");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strAdmissionNo);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>");
					sb.append("Adm Date/Time");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strAdmissionDate);
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td width='25%' class='LABEL'>");
					sb.append("Dept / Unit");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strDeptName).append(" / ").append(strUnitName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>");
					sb.append("Ward / Room / Bed");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strWardName).append(" / ").append(strRoomName)
							.append(" / ").append(strBedName);
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td width='25%' class='LABEL'>");
					sb.append("Treatment Category");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strTreatmentCategoryName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>");
					sb.append("Consultant Name");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strConsultantName);
					sb.append("</td>");
					sb.append("</tr>");
					if(mcu.getStrBillingIntegration().equals("1"))
					{
						sb.append("<tr>");
						sb.append("<td width='25%' class='LABEL'>");
						sb.append("Account Balance");
						sb.append("</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(balanceAmount);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>");
						sb.append("</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append("</td>");
						sb.append("</tr>");
					}
					
					sb.append("<tr>");
					sb.append("<input type='hidden' name='strAdmissionDtlHidVal' value='"+ strHiddenValue + "'>");
					sb.append("<input type='hidden' name='strBalanceAmount' value='"+ balanceAmount + "'>");
					sb.append("<input type='hidden' name='strPatAccountNo' value='"+ AccountNo + "'><input type='hidden' name='strPtType' value='0'>");
					sb.append("</td>");
					sb.append("</tr>");

					sb.append("</table>");
				}
			}
			else if(patType.equals("1"))
			{
				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
				sb.append("<tr><td width='100%' align='center'><input type='hidden' name='strPtType' value='1'> ");
				sb.append("<font color='red' size='3'>Patient is not Admitted/dead/gone for final bill settlement</font>");
				sb.append("</td></tr></table>");
			}
				
		} catch (Exception e) {
			throw new Exception("PatientDtlHLP-->admissionDtl-->"
					+ e.getMessage());
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}

		return sb.toString();
	}
	public static String admissionDtlView(String strCrNo, String strHospitalCode)
			throws Exception {

		WebRowSet ws = null;
		GlobalVO voObj = new GlobalVO();
		PatientDtlBO boObj = new PatientDtlBO();
		StringBuffer sb = new StringBuffer("");

		voObj.setStrValue1(strCrNo);
		voObj.setStrValue2(strHospitalCode);
		sb.append(" ");

		try {
			boObj.getAdmissionDetailsView(voObj);
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}

			ws = voObj.getGblWs1();
			if (ws != null && ws.size() > 0) {
				if (ws.next()) {

					String strDeptName = ws.getString(1);
					String strUnitName = ws.getString(2);
					String strWardName = ws.getString(3);
					String strRoomName = ws.getString(4);
					String strBedName = ws.getString(5);
					String strTreatmentCategoryName = ws.getString(6);
					String strConsultantName = ws.getString(7);
					String strNewBornBabyFlag = ws.getString(8);
					String strHiddenValue = ws.getString(9);

					String strTemp[] = strHiddenValue.replace("^", "#").split(
							"#");

					String strAdmissionNo = strTemp[0];
					String strEpisodeCode = strTemp[1];
					String strAdmissionDate = strTemp[3];
					String strMotherAdmNo = strTemp[11];
					String strMLCNo = strTemp[12];

					if (strDeptName == null)
						strDeptName = "";
					if (strUnitName == null)
						strUnitName = "";
					if (strWardName == null)
						strWardName = "";
					if (strRoomName == null)
						strRoomName = "";
					if (strBedName == null)
						strBedName = "";
					if (strTreatmentCategoryName == null)
						strTreatmentCategoryName = "";
					if (strConsultantName == null)
						strConsultantName = "";
					if (strNewBornBabyFlag == null)
						strNewBornBabyFlag = "";
					if (strHiddenValue == null)
						strHiddenValue = "";
					if (strAdmissionNo == null)
						strAdmissionNo = "";
					if (strEpisodeCode == null)
						strEpisodeCode = "";
					if (strAdmissionDate == null)
						strAdmissionDate = "";
					if (strMotherAdmNo == null)
						strMotherAdmNo = "";
					if (strMLCNo == null)
						strMLCNo = "";
					sb
							.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
					sb.append("<tr><td width='25%' class='LABEL'>");
					sb.append("Adm No");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strAdmissionNo);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>");
					sb.append("Adm Date/Time");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strAdmissionDate);
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td width='25%' class='LABEL'>");
					sb.append("Dept / Unit");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strDeptName).append(" / ").append(strUnitName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>");
					sb.append("Ward / Room / Bed");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strWardName).append(" / ").append(strRoomName)
							.append(" / ").append(strBedName);
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td width='25%' class='LABEL'>");
					sb.append("Treatment Category");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strTreatmentCategoryName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>");
					sb.append("Consultant Name");
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strConsultantName);
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb
							.append("<input type='hidden' name='strAdmissionDtlHidVal' value='"
									+ strHiddenValue + "'>");
					sb.append("</td>");
					sb.append("</tr>");

					sb.append("</table>");
				}
			}
		} catch (Exception e) {
			throw new Exception("PatientDtlHLP-->admissionDtl-->"
					+ e.getMessage());
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}

		return sb.toString();
	}
	public static String patientWithAdmissionDtlRequestForLP(String strCrNo,
			String strHospitalCode,String balanceAmount,String AccountNo, boolean fAddress,String patType) throws Exception {

		StringBuffer sb = new StringBuffer("");

		try {
			sb.append(PatientDtlHLP.patientDtl(strCrNo, fAddress));
			if(patType.equals("1") || !AccountNo.equals(""))
				sb.append(PatientDtlHLP.admissionDtlRequestForLP(strCrNo, strHospitalCode,balanceAmount,AccountNo,patType));
			else
				sb.append("<table><tr><td><input type='hidden' name='strPtType' value='0'></td></tr></table>");
		} catch (Exception e) {
			throw new Exception("PatientDtlHLP-->patientWithAdmissionDtl-->"
					+ e.getMessage());
		}

		return sb.toString();
	}
	//added by shalini on 12-Jan-2014 for patient treatment detail in indent desk
			public static String patientTreatmentDtlfrmIPD(WebRowSet ws,String strHospitalCode)
			throws Exception 
			{
				//GlobalVO voObj = new GlobalVO();
			//	PatientDtlBO boObj = new PatientDtlBO();
				StringBuffer str = new StringBuffer("");
				//voObj.setStrValue1(strCrNo);
			//	voObj.setStrValue2(strHospitalCode);
				//WebRowSet ws = null;
				Integer i = 0;
				str.append("");
				
				try 
				{
					//boObj.getPatientTreatmentDetails(voObj);
					//if (voObj.getStrMsgType().equals("1"))
				//	{
				//		throw new Exception(voObj.getStrMsgString());
				//	}
				
				//	ws = voObj.getTreatmentDetailWs();
					
					//System.out.println("ws:: HLp"+ws.size());
					if (ws != null && ws.size() > 0)
					{
						str.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
						str.append("<tr>");
						///str.append("<td width='20%' class='LABEL' style='text-align:center'>Drug Name</td>");
						//str.append("<td width='20%' class='LABEL' style='text-align:center'>Rate</td>");
						//str.append("<td width='20%' class='LABEL' style='text-align:center'>Req. Qty</td>");
						//str.append("<td width='20%' class='LABEL' style='text-align:center'>Unit</td>");
						//str.append("<td width='20%' class='LABEL' style='text-align:center'>End Date</td>");
						//str.append("</tr>");
						
					    while (ws.next()) 
					    {
							String strdrugName = ws.getString(1);
							String strRate = ws.getString(21);
							String strReqQty = ws.getString(20);
							String strUnit = ws.getString(5);
							String itemParamValue = ws.getString(22);
							String flag = "0";
							i++;
							if (strdrugName == null)
								strdrugName = "----";
							if (strRate == null)
								strRate = "----";
							if (strReqQty == null)
								strReqQty = "----";
  							if (strUnit == null)
								strUnit = "----";
							//if (strEndDate == null)
							//	strEndDate = "----";
							if(flag.equals("0"))
							{
								str.append("<tr>");
								str.append("<td width='28%' class='multiControl'>  ");
								if(itemParamValue.equals("-"))
									str.append("<font color='Orange'>***"+strdrugName+"</font>");
								else
									str.append(strdrugName);
//								str.append("</td><td width='20%' class='multiControl'>");
//								str.append(strRate);
								if(itemParamValue.equals("-"))
									str.append("</td><td width='17%' class='multiControl' style='display:none;'></td><td width='18%' class='multiControl'><input type='text' class='txtFldMin' disabled='true'  name='strReqQty' value='"+0+"'>");
								else
									str.append("</td><td width='17%' class='multiControl' style='display:none;'></td><td width='18%' class='multiControl'><input type='text' class='txtFldMin' autocomplete='off'  name='strReqQty' value='"+strReqQty+"'>");
								str.append("</td><td width='17%' class='multiControl'>");
								str.append("<select class='comboMin' name=strUnitName ><option value='6301^1.000^0'>"+ strUnit + "</option></select>");
								//str.append(strUnit);
								str.append("<input type='hidden' name = 'strUnitName' id= 'strUnitName' value = '6301^1.000^0'>");//value hardcoded bcz of no. as only unit in mms
								//str.append(strEndDate);
							}
							else
							{
								/*str.append("<tr>");
								str.append("<td width='28%' class='multiControl'><font color = 'red'>  ");
								//str.append(strdrugName);
								if(itemParamValue.equals("-"))
									str.append("<font color='Orange'>***"+strdrugName+"</font>");
								else
									str.append(strdrugName);
								str.append("</font></td><td width='20%' class='multiControl'><font color = 'red'>");
								str.append(strRate);
								if(itemParamValue.equals("-"))
									str.append("</font></td><td width='17%' class='multiControl' style='display:none;'></td><td width='18%' class='multiControl'><input type='text' class='txtFldMin' disabled='true'  name='strReqQty' value='"+0+"'>");
								else
								str.append("</font></td><td width='17%' class='multiControl' style='display:none;'></td><td width='18%' class='multiControl'><input type='text' class='txtFldMin'  name='strReqQty' value='"+strReqQty+"'>");
								//str.append(strReqQty);
								str.append("</td><td width='17%' class='multiControl'>");
								//str.append("<select name=strUnitName >"+ strUnit + "</select>");
								str.append("<select class='comboMin' name=strUnitName ><option value='6301^1.000^0'>"+ strUnit + "</option></select>");
								str.append("<input type='hidden' name = 'strUnitName' id= 'strUnitName' value = '6301^1.000^0'>");
								//str.append("</td><td width='20%' class='multiControl'>");
								//str.append(strEndDate);*/
							}
							str.append("<input type = 'hidden' name='itemParamValue' id='itemParamValue-"+i+"' value='"+itemParamValue+"'></td>");
							str.append("</tr>");
				
						}
					    //str.append("<tr><td colspan='4' width ='100'><font color = 'red'>Indent has already been placed for items shown in red</font></td></tr>");
						str.append("</table>");
					} 
					//else 
					//{
					//	str.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
					//	str.append("<tr><td class='multiControl' colspan='4'><font color='red'>No record Found</font></td></tr></table>");
					//} 
				}
				catch (Exception e) 
				{
					throw new Exception("PatientDtlHLP-->patientTreatmentDtl-->"+ e.getMessage());
				} 
				finally
				{
					if (ws != null) 
					{
						ws.close();
						ws = null;
				  	}
				}
				return str.toString();
			}
	//added by shalini to view admission details even if patient is not admitted
	public static String patientWithAdmissionDtlView(String strCrNo,
			String strHospitalCode, boolean fAddress) throws Exception {

		StringBuffer sb = new StringBuffer("");

		try {
			sb.append(PatientDtlHLP.patientDtl(strCrNo, fAddress));
			sb.append(PatientDtlHLP.admissionDtl(strCrNo, strHospitalCode));
		} catch (Exception e) {
			throw new Exception("PatientDtlHLP-->patientWithAdmissionDtl-->"
					+ e.getMessage());
		}

		return sb.toString();
	}
	
	public static String patientWithAdmissionDtlViewNew(String strCrNo,
			String strHospitalCode, boolean fAddress) throws Exception {

		StringBuffer sb = new StringBuffer("");

		try {
			sb.append(PatientDtlHLP.patientDtlNEWBS(strCrNo, fAddress));
			sb.append(PatientDtlHLP.admissionDtlNEWBS(strCrNo, strHospitalCode));
		} catch (Exception e) {
			throw new Exception("PatientDtlHLP-->patientWithAdmissionDtl-->"
					+ e.getMessage());
		}

		return sb.toString();
	}
	
}
