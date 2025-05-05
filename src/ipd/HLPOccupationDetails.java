package ipd;

import hisglobal.utility.HisUtil;

import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

public class HLPOccupationDetails {

	/**
	 * returns the Occupation Details View
	 * 
	 * @param ws -
	 *            WebRowSet Object which contains Data related to Occupation
	 *            Details
	 * @param voObj -
	 *            Value Object
	 * @return Occupation Detail View with the following components
	 * 
	 * <code>
	 * 	</br>
	 * 				
	 * 	  S.No. 	Field Names		   Description			 </br>
	 * 	  -----		--------------	   --------------		 </br>					
	 * 		1.  	strOccEmpNo     --     Employee Number      </br>
	 * 		2. 		strOccEmpName   --	   Employee Name	   </br>
	 * 		3. 		strOccRelation  --    Relation			   </br>
	 * 		4. 		strOccIsDept    --   Is Dependent 	     </br>
	 * 		5. 		strOccIsGovtEmp --    Is Govt. Employee   </br>
	 * 		6. 		strOccBasic     --   Basic Pay		     </br>
	 * 		7. 		strOccDesc      --   Designation		 </br>
	 * 		8. 		strOccOrgType   --   Organization Type 	 </br>
	 * 		9. 		strOccOffName   --   Office Name		 </br>
	 * 		10.		strOccAdd1		--   Address Line 1		</br> 
	 * 		11.		strOccAdd2		--   Address Line 2			</br>
	 * 		12.		strOccCity		--   City 				 </br>
	 * 		13.		strOccState		--   State				 </br>
	 * 		14.		strOccOffPhNo	--   Phone Number		
	 * 	</code>
	 * 
	 */
	public static String getOccupationDetails(String strCrNo,String strCatCode, String strConfCatCode, String hospCode)	throws SQLException, Exception 
	{
		ResourceBundle resourceBundle=ResourceBundle.getBundle("ipd.adt_mandatory_info");
		HisUtil util = new HisUtil("IPD", "HLPOccupationDetails");
		IpdVO voObj = new IpdVO();
		IpdBO boObj = new IpdBO();
		voObj.setStrValue1(strCrNo);
		voObj.setStrValue2(strCatCode);
		voObj.setStrValue3(strConfCatCode);
		voObj.setStrHospCode(hospCode);
		boObj.getOccupationDetails(voObj);
		WebRowSet ws = null;
		ws = voObj.getGblWs1();//Employee Details
		StringBuffer sBuffer = new StringBuffer("");
		StringBuffer dependentDtls = new StringBuffer("");
		StringBuffer basicDtls = new StringBuffer("");
		StringBuffer orgDtls = new StringBuffer("");		
		String orgTypeValues = util.getOptionValue(voObj.getGblWs5(), "0","0^Select Value", false);
		String relationValues = util.getOptionValue(voObj.getGblWs2(), "0","0^Select Value", false);
		String stateValues = util.getOptionValue(voObj.getGblWs4(), String.valueOf(Integer.parseInt("0")), "0^Select Value", false);
		voObj.getGblWs2().beforeFirst();
		//voObj.getGblWs3().beforeFirst();
		voObj.getGblWs4().beforeFirst();
		voObj.getGblWs5().beforeFirst();
		boolean flag=false;
		sBuffer.append("<div><table  class='TABLEWIDTH' align='center' cellspacing='1px' >");				
		
		if (ws != null) 
		{
			try 
			{
				String strEmpNo="0";
				String strEmpName="";
				String strDesignation="0";
				String strBasic="0";
				String strOffName="";
				String strOffAdd1="";
				String strOffAdd2="";
				String strGovtEmp="0";
				String strRelation="0";
				String strOrgType="1";
				String strOffCity="";
				String strOffState="0";
				String strOffPhNo="";
				String strEmpType="0";
				try 
				{
					if (ws.next()) //Employee Details Found
					{
						strEmpNo = (ws.getString(1)==null?"0": ws.getString(1));
						strEmpName =  (ws.getString(2)==null?"": ws.getString(2));
						strDesignation =  (ws.getString(3)==null?"": ws.getString(3));
						strBasic = ws.getString(4);
						strOffName = (ws.getString(5)==null?"": ws.getString(5));
						strOffAdd1 =  (ws.getString(6)==null?"": ws.getString(6));
						strOffAdd2 =  (ws.getString(7)==null?"": ws.getString(7));
						strGovtEmp = ws.getString(8);
						strRelation = (ws.getString(9)==null?"0": ws.getString(9));
						strOrgType = ws.getString(10);
						strOffCity =  (ws.getString(11)==null?"": ws.getString(11));
						strOffState = ws.getString(12);
						strOffPhNo = (ws.getString(13)==null?"": ws.getString(13));
						strEmpType =  (ws.getString(14)==null?"0": ws.getString(14));
						flag=true;
					}
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				
				if(resourceBundle.getString("DEPENDENT_DETAILS_REQUIRED").equals("1"))
				{
					dependentDtls.append("<tr style='display:none'>");
					dependentDtls.append("<td width='25%' class='LABEL'>Employee Name</td>");
					dependentDtls.append("<td width='25%' class='CONTROL' colspan='3'><input type='hidden' name='strOccEmpNo' value='"+ strEmpNo + "'>");
					dependentDtls.append("<input type='text' name='strOccEmpName'  readonly='readonly' value='"+ strEmpName+ "' class='txtFldMax'> </td>");
					dependentDtls.append("</tr>");
					dependentDtls.append("<tr style='display:none;'>");					
					dependentDtls.append("<td width='25%' class='LABEL'>Is Dependent</td>");
					dependentDtls.append("<td width='25%' class='CONTROL'>");
					
					if (strRelation!=null && strRelation.equals("0")) 
					{
						dependentDtls.append("<select name='strOccIsDept' class='comboMin'><option value='0' selected>No</option><option value='1'>Yes</option></select>");
					} 
					else 
					{
						dependentDtls.append("<select name='strOccIsDept' class='comboMin'><option value='1' selected>Yes</option><option value='0'>No</option></select>");
					}
					dependentDtls.append("</td>");
					dependentDtls.append("<td width='25%' class='LABEL'><font color='red'>*</font>Relation</td>");
					dependentDtls.append("<td width='25%' class='CONTROL'><select name='strOccRelation' class='comboNormal'>");
					dependentDtls.append(relationValues);
					dependentDtls.append("</select> </td>");
					dependentDtls.append("</tr>");
				}
				
				if (strBasic == null)
					strBasic = "0";
				//basicDtls.append("<table  class='TABLEWIDTH' align='center' cellspacing='1px' >");
				basicDtls.append("<tr style='display:none;'>");
				basicDtls.append("<td width='25%' class='LABEL'>Is Govt. Employee</td>");
				basicDtls.append("<td width='25%' class='CONTROL'>");
				if (strGovtEmp.equals("1")) 
				{
					basicDtls.append("<input type='radio' name='strOccIsGovtEmp' value='1'  checked='checked'>Yes &nbsp;");
					basicDtls.append(" <input type='radio' name='strOccIsGovtEmp' value='0'>No");
				} 
				else 
				{
					basicDtls.append("<input type='radio' name='strOccIsGovtEmp' value='1' >Yes &nbsp;");
					basicDtls.append(" <input type='radio' name='strOccIsGovtEmp' checked='checked' value='0'>No");
				}
				basicDtls.append("</td>");
				basicDtls.append("<td width='25%' class='LABEL'>Monthly Income(<img src='/INVMGM/hisglobal/images/INR.png'>)</td>");
				basicDtls.append("<td width='25%' class='CONTROL'><input type='text' name='strOccBasic' value='"+strBasic+"' tabindex='2' class='txtFldNormal' onkeypress='return validateData(event,5);' maxlength='6'> </td>");
				basicDtls.append("</tr>");
				
				String displayTypeDesig="display:none;";
				String displayTypeOrg="display:none;";
				String displayTypeOffName="display:none;";
				String displayTypeNoneAll="";
				String displayTypeOffAddAll="";
				String displayTypeOffAdd1="display:none;";
				String displayTypeOffAdd2="display:none;";
				String displayTypeOffPhone="display:none;";
				
				
				if(resourceBundle.getString("DESIGNATION_AT_OCCUPATION_REQUIRED").equals("0") && resourceBundle.getString("ORGANIZATION_TYPE_AT_OCCUPATION_REQUIRED").equals("0"))
				{
					displayTypeNoneAll="display:none;";
				}
				if(resourceBundle.getString("DESIGNATION_AT_OCCUPATION_REQUIRED").equals("1"))
				{
					displayTypeDesig="";
				}
				if(resourceBundle.getString("ORGANIZATION_TYPE_AT_OCCUPATION_REQUIRED").equals("1"))
				{
					displayTypeOrg="";
				}
				if(resourceBundle.getString("OFFICE_NAME_AT_OCCUPATION_REQUIRED").equals("1"))
				{
					displayTypeOffName="";
				}
				if(resourceBundle.getString("OFFICE_ADDRESS1_AT_OCCUPATION_REQUIRED").equals("0") && resourceBundle.getString("OFFICE_ADDRESS2_AT_OCCUPATION_REQUIRED").equals("0"))
				{
					displayTypeOffAddAll="display:none;";
				}
				if(resourceBundle.getString("OFFICE_ADDRESS1_AT_OCCUPATION_REQUIRED").equals("1") )
				{
					displayTypeOffAdd1="";
				}
				if(resourceBundle.getString("OFFICE_ADDRESS2_AT_OCCUPATION_REQUIRED").equals("1"))
				{
					displayTypeOffAdd2="";
				}
				if(resourceBundle.getString("OFFICE_PHONE_NO_AT_OCCUPATION_REQUIRED").equals("1"))
				{
					displayTypeOffPhone="";
				}
					orgDtls.append("<tr id='des' style='"+displayTypeNoneAll+"'>");
					orgDtls.append("<td width='25%' class='LABEL'><div style='"+displayTypeOrg+"'>Organization Type</div></td>");
					orgDtls.append("<td width='25%' class='CONTROL'><div style='"+displayTypeOrg+"'><select name='strOccOrgType' class='comboMax'>");
					orgDtls.append(orgTypeValues);
					orgDtls.append("</select></div></td>");
					orgDtls.append("<td width='25%' class='LABEL'><div style=style='"+displayTypeDesig+"'>Designation</div></td>");
					orgDtls.append("<td width='25%' class='CONTROL'><div style=style='"+displayTypeDesig+"'><input type='text' name='strOccDesc' value='"+strDesignation+"'  class='txtFldNormal' maxlength='30'/></div></td>");						
					orgDtls.append("</tr>");
					orgDtls.append("<tr style='"+displayTypeOffName+"' id='ofc'>");
					orgDtls.append("<td width='25%' class='LABEL'>Office Name</td>");
					orgDtls.append("<td width='25%' class='CONTROL' colspan='3'><input type='text' name='strOccOffName' value='"+strOffName+"'  class='txtFldMax' onkeypress='return validateData(event,4);' maxlength='70'> </td>");
					orgDtls.append("</tr>");
				
					orgDtls.append("<tr style='"+displayTypeOffAddAll+"' id='ofcadd'>");
					orgDtls.append("<td width='25%' class='LABEL'><div style='"+displayTypeOffAdd1+"'>Office Address1</div></td>");
					orgDtls.append("<td width='25%' class='CONTROL'><div style='"+displayTypeOffAdd1+"'><input type='text' name='strOccAdd1' value='"+strOffAdd1+"'  class='txtFldMax' maxlength='50'></div></td>");
					orgDtls.append("<td width='25%' class='LABEL'><div style='"+displayTypeOffAdd2+"'>Office Address2</div></td>");
					orgDtls.append("<td width='25%' class='CONTROL' ><div style='"+displayTypeOffAdd2+"'><input type='text' name='strOccAdd2' value='"+strOffAdd2+"' class='txtFldMax' maxlength='50'></div></td>");
					orgDtls.append("</tr>");
				
					orgDtls.append("<tr style='"+displayTypeOffPhone+"' id='ofcph'>");
					orgDtls.append("<td width='25%' class='LABEL'>Office Phone No.</td>");
					orgDtls.append("<td width='25%' class='CONTROL' ><input type='text' name='strOccOffPhNo' value='"+strOffPhNo+"' maxlength='30' class='txtFldMax' onkeypress='return validateData(event,2);'></td>");
					orgDtls.append("<td width='25%' class='LABEL' colspan='2'></td>");
					orgDtls.append("</tr>");
				
				if (flag) //Emp Details Found
				{
					if (strEmpNo == null)
						strEmpNo = "";
					if (strEmpName == null)
						strEmpName = "";
					if (strDesignation == null)
						strDesignation = "";
					if (strBasic == null)
						strBasic = "0";
					if (strOffName == null)
						strOffName = "";
					if (strOffAdd1 == null)
						strOffAdd1 = "";
					if (strOffAdd2 == null)
						strOffAdd2 = "";
					if (strGovtEmp == null)
						strGovtEmp = "0";
					if (strRelation == null)
						strRelation = "0";
					if (strOrgType == null)
						strOrgType = "0";
					if (strOffCity == null)
						strOffCity = "";
					if (strOffState == null)
						strOffState = "0";
					if (strOffPhNo == null)
						strOffPhNo = "";
					if (strEmpType == null)
						strEmpType = "1";
					
					orgTypeValues = util.getOptionValue(voObj.getGblWs5(),strOrgType, "0^Select Value", false);
					relationValues = util.getOptionValue(voObj.getGblWs2(),strRelation, "0^Select Value", false);
					stateValues = util.getOptionValue(voObj.getGblWs4(), String.valueOf(Integer.parseInt(strOffState)),"0^Select Value", false);					
										
					
						sBuffer.append(dependentDtls);
						sBuffer.append(basicDtls);
						sBuffer.append(orgDtls);						
						sBuffer.append("</table></div>");
					
				} 
				else 
				{
					sBuffer.append(dependentDtls);
					sBuffer.append(basicDtls);
					sBuffer.append(orgDtls);				
					
					sBuffer.append("</table></div>");
				}
				if (voObj.getStrMsgType().equals("1")) {
					throw new Exception(voObj.getStrMsgString());
				}
			} 
			catch (SQLException e)
			{
				//e.printStackTrace();
				throw new SQLException("HLPOccupationDetails.getOccupationDetails() -->"	+ e.getMessage());
			} 
			catch (Exception e) 
			{
				throw new Exception(	"HLPOccupationDetails.getOccupationDetails() -->"+ e.getMessage());
			}
		} 
		//else {
	//		throw new SQLException(
	//				"HLPOccupationDetails.getOccupationDetails() --> No Data Found in Occupation Table");
	//	}
		return sBuffer.toString();
	}

	// in case of view

	public static String getOccupationDetailsView(String strCrNo,String strCatCode, String strConfCatCode, String hospCode) throws SQLException, Exception 
	{
		HisUtil util = new HisUtil("IPD", "HLPOccupationDetails");
		IpdVO voObj = new IpdVO();
		IpdBO boObj = new IpdBO();

		voObj.setStrValue1(strCrNo);
		voObj.setStrValue2(strCatCode);
		voObj.setStrValue3(strConfCatCode);
		voObj.setStrHospCode(hospCode);
		boObj.getOccupationDetails(voObj);

		WebRowSet ws = voObj.getGblWs1();

		StringBuffer sBuffer = new StringBuffer("");
		String orgTypeValues = util.getOptionValue(voObj.getGblWs5(), "0","0^Select Value", false);
		String relationValues = util.getOptionValue(voObj.getGblWs2(), "0", "",false);
		/*
		 * String descValues = util.getOptionValue(voObj.getGblWs3(), "0",
		 * "0^Select Value", false);
		 */
		String stateValues = util.getOptionValue(voObj.getGblWs4(), String.valueOf(Integer.parseInt("0")), "0^Select Value", false);

		voObj.getGblWs2().beforeFirst();
		//voObj.getGblWs3().beforeFirst();
		voObj.getGblWs4().beforeFirst();
		voObj.getGblWs5().beforeFirst();

		if (ws != null)
		{
			try 
			{
				if (ws.next()) 
				{
					String strEmpNo = ws.getString(1);
					String strEmpName = ws.getString(2);
					String strDesignation = ws.getString(3);
					String strBasic = ws.getString(4);
					String strOffName = ws.getString(5);
					String strOffAdd1 = ws.getString(6);
					String strOffAdd2 = ws.getString(7);
					String strGovtEmp = ws.getString(8);
					String strOffCity = ws.getString(11);
					String strOffState = ws.getString(12);
					String strOffPhNo = ws.getString(13);
					String strEmpType = ws.getString(14);
					String strRelation = ws.getString(15);
					String strOrgType = ws.getString(16);
					stateValues = ws.getString(17);

					if (strEmpNo == null)
						strEmpNo = "";
					if (strEmpName == null)
						strEmpName = "";
					if (strDesignation == null)
						strDesignation = " ";
					if (strBasic == null)
						strBasic = "";
					if (strOffName == null)
						strOffName = "";
					if (strOffAdd1 == null)
						strOffAdd1 = "";
					if (strOffAdd2 == null)
						strOffAdd2 = "";
					if (strGovtEmp == null)
						strGovtEmp = "0";
					if (strRelation == null)
						strRelation = "0";
					if (strOrgType == null)
						strOrgType = "0";
					if (strOffCity == null)
						strOffCity = "";
					if (strOffState == null)
						strOffState = "0";
					if (strOffPhNo == null)
						strOffPhNo = "";
					if (strEmpType == null)
						strEmpType = "0";

					if (strEmpType.equals("0")) {

						sBuffer.append("<table class ='TABLEWIDTH' align='center'>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='25%' class='LABEL'> Name</td>");
						sBuffer.append("<td width='25%' class='CONTROL' colspan='3'><input type='hidden' name='strOccEmpNo'  value='"+ strEmpNo + "'>");
						sBuffer.append(strEmpName + "</td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='25%' class='LABEL'>Relation</td>");
						sBuffer.append("<td width='25%' tabindex='1' class='CONTROL'>");
						sBuffer.append(strRelation);
						sBuffer.append("</td>");
						sBuffer.append("<td width='25%' class='LABEL'>Is Dependent</td>");
						sBuffer.append("<td width='25%' tabindex='1' class='CONTROL'>");
						if (strRelation.equals("0")) 
						{
							sBuffer.append("No");
						} 
						else 
						{
							sBuffer.append("Yes");
						}
						sBuffer.append("</td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='25%' class='LABEL'>Is Govt. Employee</td>");
						sBuffer.append("<td width='25%' class='CONTROL'>");
						if (strGovtEmp.equals("1")) 
						{
							sBuffer.append("Yes");

						} 
						else 
						{
							sBuffer.append("No");
						}
						sBuffer.append("</td>");
						sBuffer
								.append("<td width='25%' class='LABEL'>Basic/Income(Annual)</td>");
						sBuffer.append("<td width='25%' tabindex='1' class='CONTROL'>"+ strBasic + "</td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='25%' class='LABEL'>Designation</td>");
						sBuffer.append("<td width='25%' class='CONTROL'>"+ strDesignation + "</td>");
						sBuffer.append("<td width='25%' class='LABEL'>Organization Type</td>");
						sBuffer.append("<td width='25%' class='CONTROL'>");
						sBuffer.append(strOrgType);
						sBuffer.append("</td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='25%' class='LABEL'>Office Name</td>");
						sBuffer.append("<td width='25%' class='CONTROL' colspan='3'>"+ strOffName + "</td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='25%' class='LABEL'>Office Address1</td>");
						sBuffer.append("<td width='25%' class='CONTROL' colspan='3'>"+ strOffAdd1 + "</td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='25%' class='LABEL'>Office Address2</td>");
						sBuffer.append("<td width='25%' class='CONTROL' colspan='3'>"+ strOffAdd2 + "</td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='25%' class='LABEL'>City</td>");
						sBuffer.append("<td width='25%' tabindex='1' class='CONTROL'>"+ strOffCity + "</td>");
						sBuffer.append("<td width='25%' class='LABEL'>State</td>");
						sBuffer.append("<td width='25%' tabindex='1' class='CONTROL'>");
						sBuffer.append(stateValues);
						sBuffer.append("</td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='25%' class='LABEL'>Office Phone No.</td>");
						sBuffer.append("<td width='25%' class='CONTROL'>"+ strOffPhNo + "</td>");
						sBuffer.append("<td width='25%' class='LABEL' colspan='1'></td>");
						sBuffer.append("<td width='25%' class='CONTROL' colspan='1'></td>");
						sBuffer.append("</tr>");
						sBuffer.append("</table>");
					} 
					else 
					{
						sBuffer.append("<table class ='TABLEWIDTH' align='center'>");
						sBuffer.append("<tr><td colspan='4' class='TITLE'>Patient Occupation Details</td></tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='25%' class='LABEL'> Name</td>");
						sBuffer.append("<td width='25%' class='CONTROL' colspan='3'><input type='hidden' name='strOccEmpNo' value='"+ strEmpNo + "'>");
						sBuffer.append(strEmpName + "</td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='25%' class='LABEL'>Relation</td>");
						sBuffer.append("<td width='25%' tabindex='1' class='CONTROL'>");
						sBuffer.append(relationValues);
						sBuffer.append(" </td>");
						sBuffer.append("<td width='25%' class='LABEL'>Is Dependent</td>");
						sBuffer.append("<td width='25%'  tabindex='1' class='CONTROL'>");
						if (strRelation.equals("0")) 
						{
							sBuffer.append("<input type='hidden' name='strOccIsDept' value='1' readonly='readonly' >Yes ");
						} 
						else 
						{
							sBuffer.append(" <input type='hidden' name='strOccIsDept'  readonly='readonly' value='0'>No");
						}
						sBuffer.append("</td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='25%' class='LABEL'>Is Govt. Employee</td>");
						sBuffer.append("<td width='25%' class='CONTROL'>");
						if (strGovtEmp.equals("1")) 
						{
							sBuffer.append("<input type='hidden' name='strOccIsGovtEmp' value='1' readonly='readonly' >Yes ");
						} 
						else 
						{
							sBuffer.append(" <input type='hidden' name='strOccIsGovtEmp'  readonly='readonly' value='0'>No");
						}

						sBuffer.append("</td>");
						sBuffer.append("<td width='25%' class='LABEL'>Basic/Income(Annual)</td>");
						sBuffer.append("<td width='25%' tabindex='1' class='CONTROL'>"+ strBasic + " </td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='25%' class='LABEL'>Designation</td>");
						sBuffer.append("<td width='25%' tabindex='1' class='CONTROL'></td>");
						sBuffer.append("<td width='25%' class='LABEL'>Organization Type</td>");
						sBuffer.append("<td width='25%' class='CONTROL'><select name='strOccOrgType' class='comboMax' disabled ='disabled' disabled='disabled'>");
						sBuffer.append(orgTypeValues);
						sBuffer.append("</select></td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='25%' class='LABEL'>Office Name</td>");
						sBuffer.append("<td width='25%' class='CONTROL' colspan='3'><input type='text' disabled ='disabled' name='strOccOffName' value='"+ strOffName+ "' class='txtFldNormal' readonly='readonly'> </td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='25%' class='LABEL'>Office Address1</td>");
						sBuffer.append("<td width='25%' class='CONTROL' colspan='3'><input type='text' disabled ='disabled'  name='strOccAdd1' value='"+ strOffAdd1+ "' class='txtFldNormal' readonly='readonly'></td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='25%' class='LABEL'>Office Address2</td>");
						sBuffer.append("<td width='25%' class='CONTROL' colspan='3'><input type='text' disabled ='disabled'  name='strOccAdd2' value='"+ strOffAdd2+ "' class='txtFldNormal' readonly='readonly'></td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='25%' class='LABEL'>City</td>");
						sBuffer.append("<td width='25%'  tabindex='1' class='CONTROL'><input type='text' disabled ='disabled'   name='strOccCity' value='"+ strOffCity+ "' class='txtFldNormal' readonly='readonly'></td>");
						sBuffer.append("<td width='25%' class='LABEL'>State</td>");
						sBuffer.append("<td width='25%'  tabindex='1' class='CONTROL'><select name='strOccState' disabled ='disabled' class='comboNormal' disabled='disabled'>");
						sBuffer.append(stateValues);
						sBuffer.append("</select></td>");
						sBuffer.append("</tr>");
						sBuffer.append("<tr>");
						sBuffer.append("<td width='25%' class='LABEL'>Office Phone No.</td>");
						sBuffer.append("<td width='25%' class='CONTROL' ><input type='text'  name='strOccOffPhNo' value='"+ strOffPhNo+ "' class='txtFldNormal' readonly='readonly'></td>");
						sBuffer.append("<td width='25%' class='LABEL' colspan='1'></td>");
						sBuffer.append("<td width='25%' class='CONTROL' colspan='1'></td>");
						sBuffer.append("</tr>");
						sBuffer.append("</table>");
					}
				} 
				else 
				{
					sBuffer.append("<tr><td colspan='4' class='TITLE'>Patient Occupation Details</td></tr>");
					sBuffer.append("<tr>");
					sBuffer.append("<td width='25%' class='LABEL'> Name</td>");
					sBuffer.append("<td width='25%' class='CONTROL' colspan='3'>");
					sBuffer.append("<input type='text' disabled ='disabled' name='strOccEmpName' value='' class='txtFldBig' onkeypress='return validateData(event,4);' maxlength='40'> </td>");
					sBuffer.append("</tr>");
					sBuffer.append("<tr>");
					sBuffer.append("<td width='25%' class='LABEL'>Relation</td>");
					sBuffer.append("<td width='25%' class='CONTROL'><select name='strOccRelation' disabled ='disabled' class='comboNormal'>");
					sBuffer.append(relationValues);
					sBuffer.append("</select> </td>");
					sBuffer.append("<td width='25%' class='LABEL'>Is Dependent</td>");
					sBuffer.append("<td width='25%' class='CONTROL'>");

					/*
					 * if (strRelation.equals("0")) { sBuffer .append("<input
					 * type='hidden' name='strOccIsDept' value='1'
					 * readonly='readonly' >Yes ");
					 *  } else {
					 * 
					 * sBuffer .append(" <input type='hidden'
					 * name='strOccIsDept' readonly='readonly' value='0'>No"); }
					 */

					sBuffer.append("</td>");
					sBuffer.append("</tr>");
					sBuffer.append("<tr>");
					sBuffer.append("<td width='25%' class='LABEL'>Is Govt. Employee</td>");
					sBuffer.append("<td width='25%' class='CONTROL'>");
					sBuffer.append("</td>");
					sBuffer.append("<td width='25%' class='LABEL'>Basic/Income(Annual)</td>");
					sBuffer.append("<td width='25%' class='CONTROL'><input type='text' disabled ='disabled' name='strOccBasic' value='' class='txtFldNormal' onkeypress='return validateData(event,5);' maxlength='6'> </td>");
					sBuffer.append("</tr>");
					sBuffer.append("<tr>");
					sBuffer.append("<td width='25%' class='LABEL'>Designation</td>");
					sBuffer.append("<td width='25%' class='CONTROL'><input type='text' disabled ='disabled' name='strOccDesc' class='txtFldNormal' maxlength='30'/></td>");
					sBuffer.append("<td width='25%' class='LABEL'>Organization Type</td>");
					sBuffer.append("<td width='25%' class='CONTROL'><select name='strOccOrgType'  disabled ='disabled' class='comboMax'>");
					sBuffer.append(orgTypeValues);
					sBuffer.append("</select></td>");
					sBuffer.append("</tr>");
					sBuffer.append("<tr>");
					sBuffer.append("<td width='25%' class='LABEL'>Office Name</td>");
					sBuffer.append("<td width='25%' class='CONTROL' colspan='3'><input type='text' disabled ='disabled' name='strOccOffName' value='' class='txtFldBig' onkeypress='return validateData(event,4);' maxlength='70'> </td>");
					sBuffer.append("</tr>");
					sBuffer.append("<tr>");
					sBuffer.append("<td width='25%' class='LABEL'>Office Address1</td>");
					sBuffer.append("<td width='25%' class='CONTROL' colspan='3'><input disabled ='disabled' type='text' name='strOccAdd1' value='' class='txtFldBig' maxlength='50'></td>");
					sBuffer.append("</tr>");
					sBuffer.append("<tr>");
					sBuffer.append("<td width='25%' class='LABEL'>Office Address2</td>");
					sBuffer.append("<td width='25%' class='CONTROL' colspan='3'><input type='text' name='strOccAdd2' value='' disabled ='disabled' class='txtFldBig' maxlength='50'></td>");
					sBuffer.append("</tr>");
					sBuffer.append("<tr>");
					sBuffer.append("<td width='25%' class='LABEL'>City</td>");
					sBuffer.append("<td width='25%' class='CONTROL'><input type='text' name='strOccCity' value='' class='txtFldNormal'  disabled ='disabled' onkeypress='return validateData(event,4);' maxlength='50'></td>");
					sBuffer.append("<td width='25%' class='LABEL'>State</td>");
					sBuffer.append("<td width='25%' class='CONTROL'><select name='strOccState' disabled ='disabled' class='comboNormal'>");
					sBuffer.append(stateValues);
					sBuffer.append("</select></td>");
					sBuffer.append("</tr>");
					sBuffer.append("<tr>");
					sBuffer.append("<td width='25%' class='LABEL'>Office Phone No.</td>");
					sBuffer.append("<td width='25%' class='CONTROL'><input type='text' disabled ='disabled' name='strOccOffPhNo' value='' class='txtFldNormal'></td>");
					sBuffer.append("<td width='25%' class='LABEL' colspan='1'></td>");
					sBuffer.append("<td width='25%' class='CONTROL' colspan='1'></td>");
					sBuffer.append("</tr>");

				}
			} 
			catch (SQLException e) 
			{
				throw new SQLException("HLPOccupationDetails.getOccupationDetails() -->"+ e.getMessage());
			} 
			catch (Exception e) 
			{
				throw new Exception("HLPOccupationDetails.getOccupationDetails() -->"+ e.getMessage());
			}
		} 
		else 
		{
			throw new SQLException("HLPOccupationDetails.getOccupationDetails() --> No Data Found in Occupation Table");
		}

		// System.out.println("sBuffer.toString()=="+sBuffer.toString());
		return sBuffer.toString();
	}
	
	public static String getOccupationDetails_Bootstrap(String strCrNo,String strCatCode, String strConfCatCode, String hospCode)	throws SQLException, Exception 
	{
		ResourceBundle resourceBundle=ResourceBundle.getBundle("ipd.adt_mandatory_info");
		HisUtil util = new HisUtil("IPD", "HLPOccupationDetails");
		IpdVO voObj = new IpdVO();
		IpdBO boObj = new IpdBO();
		voObj.setStrValue1(strCrNo);
		voObj.setStrValue2(strCatCode);
		voObj.setStrValue3(strConfCatCode);
		voObj.setStrHospCode(hospCode);
		boObj.getOccupationDetails(voObj);
		WebRowSet ws = null;
		ws = voObj.getGblWs1();//Employee Details
		StringBuffer sBuffer = new StringBuffer("");
		StringBuffer dependentDtls = new StringBuffer("");
		StringBuffer basicDtls = new StringBuffer("");
		StringBuffer orgDtls = new StringBuffer("");		
		String orgTypeValues = util.getOptionValue(voObj.getGblWs5(), "0","0^Select Value", false);
		String relationValues = util.getOptionValue(voObj.getGblWs2(), "0","0^Select Value", false);
		String stateValues = util.getOptionValue(voObj.getGblWs4(), String.valueOf(Integer.parseInt("0")), "0^Select Value", false);
		voObj.getGblWs2().beforeFirst();
		//voObj.getGblWs3().beforeFirst();
		voObj.getGblWs4().beforeFirst();
		voObj.getGblWs5().beforeFirst();
		boolean flag=false;
		//sBuffer.append("<div><table  class='TABLEWIDTH' align='center' cellspacing='1px' >");	
		//sBuffer.append("<table id='' class='dislay' style='wodth:100%'>\n");
		
       /* sBuffer.append("<div class='container' style='max-width: 1171px;line-height: 0.5'>\n");
        sBuffer.append("<div id='accordion'>\n");
        sBuffer.append("<div class='col-md-12'>\n");
        sBuffer.append("<div class='card'>\n");  
        sBuffer.append("<div class='card-header' style='padding: .5rem 1.25rem;'><a class='card-link' data-toggle='collapse' href='#collapseOne'><i class='fas fa-angle-down rotate-icon' align='Right'></i></a></div>");
        sBuffer.append("<div id='collapseOne' class='collapse' data-parent='#accordion'>");

        sBuffer.append("<div class='card-body'>\n");
        */
		
		if (ws != null) 
		{
			try 
			{
				String strEmpNo="0";
				String strEmpName="";
				String strDesignation="0";
				String strBasic="0";
				String strOffName="";
				String strOffAdd1="";
				String strOffAdd2="";
				String strGovtEmp="0";
				String strRelation="0";
				String strOrgType="1";
				String strOffCity="";
				String strOffState="0";
				String strOffPhNo="";
				String strEmpType="0";
				try 
				{
					if (ws.next()) //Employee Details Found
					{
						strEmpNo = (ws.getString(1)==null?"0": ws.getString(1));
						strEmpName =  (ws.getString(2)==null?"": ws.getString(2));
						strDesignation =  (ws.getString(3)==null?"": ws.getString(3));
						strBasic = ws.getString(4);
						strOffName = (ws.getString(5)==null?"": ws.getString(5));
						strOffAdd1 =  (ws.getString(6)==null?"": ws.getString(6));
						strOffAdd2 =  (ws.getString(7)==null?"": ws.getString(7));
						strGovtEmp = ws.getString(8);
						strRelation = (ws.getString(9)==null?"0": ws.getString(9));
						strOrgType = ws.getString(10);
						strOffCity =  (ws.getString(11)==null?"": ws.getString(11));
						strOffState = ws.getString(12);
						strOffPhNo = (ws.getString(13)==null?"": ws.getString(13));
						strEmpType =  (ws.getString(14)==null?"0": ws.getString(14));
						flag=true;
					}
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				
				if(resourceBundle.getString("DEPENDENT_DETAILS_REQUIRED").equals("1"))
				{
					/*dependentDtls.append("<tr style='display:none'>");
					dependentDtls.append("<td width='25%' class='LABEL'>Employee Name</td>");
					dependentDtls.append("<td width='25%' class='CONTROL' colspan='3'><input type='hidden' name='strOccEmpNo' value='"+ strEmpNo + "'>");
					dependentDtls.append("<input type='text' name='strOccEmpName'  readonly='readonly' value='"+ strEmpName+ "' class='txtFldMax'> </td>");
					dependentDtls.append("</tr>");
					dependentDtls.append("<tr>");					
					dependentDtls.append("<td width='25%' class='LABEL'>Is Dependent</td>");
					dependentDtls.append("<td width='25%' class='CONTROL'>");
					
					if (strRelation!=null && strRelation.equals("0")) 
					{
						dependentDtls.append("<select name='strOccIsDept' class='comboMin'><option value='0' selected>No</option><option value='1'>Yes</option></select>");
					} 
					else 
					{
						dependentDtls.append("<select name='strOccIsDept' class='comboMin'><option value='1' selected>Yes</option><option value='0'>No</option></select>");
					}
					dependentDtls.append("</td>");
					dependentDtls.append("<td width='25%' class='LABEL'><font color='red'>*</font>Relation</td>");
					dependentDtls.append("<td width='25%' class='CONTROL'><select name='strOccRelation' class='comboNormal'>");
					dependentDtls.append(relationValues);
					dependentDtls.append("</select> </td>");
					dependentDtls.append("</tr>");*/
					
					 dependentDtls.append("<div class='row'>");
					 dependentDtls.append("<div class='col-sm-6'>");
					 dependentDtls.append("<label>Is Dependent</label>");
					 
					 if (strRelation!=null && strRelation.equals("0")) 
						{
							dependentDtls.append("<select id='inputState' class='browser-default custom-select'><option value='0' selected>No</option><option value='1'>Yes</option></select>");
						} 
					 else 
						{
							dependentDtls.append("<select id='inputState' class='browser-default custom-select'><option value='1' selected>Yes</option><option value='0'>No</option></select>");
						}
					 dependentDtls.append("</div>");
					 dependentDtls.append("<div class='col-sm-6'>");
					 dependentDtls.append("<label><font color='red'>*</font>Relation</label>");
					 dependentDtls.append("<select id='inputState' class='browser-default custom-select' >");
					 dependentDtls.append(relationValues);
					 dependentDtls.append("</select>");                
					 dependentDtls.append("</div>");
	                 dependentDtls.append("</div>");
					
				}
				
				if (strBasic == null)
					strBasic = "0";
				//basicDtls.append("<table  class='TABLEWIDTH' align='center' cellspacing='1px' >");
				/*basicDtls.append("<tr>");
				basicDtls.append("<td width='25%' class='LABEL'>Is Govt. Employee</td>");
				basicDtls.append("<td width='25%' class='CONTROL'>");
				if (strGovtEmp.equals("1")) 
				{
					basicDtls.append("<input type='radio' name='strOccIsGovtEmp' value='1'  checked='checked'>Yes &nbsp;");
					basicDtls.append(" <input type='radio' name='strOccIsGovtEmp' value='0'>No");
				} 
				else 
				{
					basicDtls.append("<input type='radio' name='strOccIsGovtEmp' value='1' >Yes &nbsp;");
					basicDtls.append(" <input type='radio' name='strOccIsGovtEmp' checked='checked' value='0'>No");
				}
				basicDtls.append("</td>");
				basicDtls.append("<td width='25%' class='LABEL'>Monthly Income(<img src='/INVMGM/hisglobal/images/INR.png'>)</td>");
				basicDtls.append("<td width='25%' class='CONTROL'><input type='text' name='strOccBasic' value='"+strBasic+"' tabindex='2' class='txtFldNormal' onkeypress='return validateData(event,5);' maxlength='6'> </td>");
				basicDtls.append("</tr>");
				*/
				
				
				 dependentDtls.append("<div class='row'>");
				 dependentDtls.append("<div class='col-sm-6'>");
				 dependentDtls.append("<label>Is Govt. Employee</label>");
				 
				 if (strRelation!=null && strRelation.equals("0")) 
					{
						dependentDtls.append("<select id='inputState' class='browser-default custom-select' ><option value='0' selected>No</option><option value='1'>Yes</option></select>");
					} 
				 else 
					{
						dependentDtls.append("<select id='inputState' class='browser-default custom-select'><option value='1' selected>Yes</option><option value='0'>No</option></select>");
					}
				 dependentDtls.append("</div>");
				 dependentDtls.append("<div class='col-sm-6'>");
				 dependentDtls.append("<label>Monthly Income</label>");
				 dependentDtls.append("<input type='text' class='form-control'>");
				 dependentDtls.append("</div>");
                 dependentDtls.append("</div>");
				
				
                 
                 
				String displayTypeDesig="display:none;";
				String displayTypeOrg="display:none;";
				String displayTypeOffName="display:none;";
				String displayTypeNoneAll="";
				String displayTypeOffAddAll="";
				String displayTypeOffAdd1="display:none;";
				String displayTypeOffAdd2="display:none;";
				String displayTypeOffPhone="display:none;";
				
				
				if(resourceBundle.getString("DESIGNATION_AT_OCCUPATION_REQUIRED").equals("0") && resourceBundle.getString("ORGANIZATION_TYPE_AT_OCCUPATION_REQUIRED").equals("0"))
				{
					displayTypeNoneAll="display:none;";
				}
				if(resourceBundle.getString("DESIGNATION_AT_OCCUPATION_REQUIRED").equals("1"))
				{
					displayTypeDesig="";
				}
				if(resourceBundle.getString("ORGANIZATION_TYPE_AT_OCCUPATION_REQUIRED").equals("1"))
				{
					displayTypeOrg="";
				}
				if(resourceBundle.getString("OFFICE_NAME_AT_OCCUPATION_REQUIRED").equals("1"))
				{
					displayTypeOffName="";
				}
				if(resourceBundle.getString("OFFICE_ADDRESS1_AT_OCCUPATION_REQUIRED").equals("0") && resourceBundle.getString("OFFICE_ADDRESS2_AT_OCCUPATION_REQUIRED").equals("0"))
				{
					displayTypeOffAddAll="display:none;";
				}
				if(resourceBundle.getString("OFFICE_ADDRESS1_AT_OCCUPATION_REQUIRED").equals("1"))
				{
					displayTypeOffAdd1="";
				}
				if(resourceBundle.getString("OFFICE_ADDRESS2_AT_OCCUPATION_REQUIRED").equals("1"))
				{
					displayTypeOffAdd2="";
				}
				if(resourceBundle.getString("OFFICE_PHONE_NO_AT_OCCUPATION_REQUIRED").equals("1"))
				{
					displayTypeOffPhone="";
				}
					
				orgDtls.append("<div class='row' style='"+displayTypeNoneAll+"'>");
				orgDtls.append("<div class='col-sm-6'>");
					//orgDtls.append("<tr id='des' style='"+displayTypeNoneAll+"'>");
					//orgDtls.append("<td width='25%' class='LABEL'><div style='"+displayTypeOrg+"'>Organization Type</div></td>");
				orgDtls.append("<label style='"+displayTypeOrg+"'>Organization Type</label>");
				orgDtls.append("</div>");
				orgDtls.append("<div class='col-sm-6'><select name='strOccOrgType' class='browser-default custom-select'  style='"+displayTypeOrg+"'>"+orgTypeValues+"</select></div>");
					//orgDtls.append("<td width='25%' class='CONTROL'><div style='"+displayTypeOrg+"'><select name='strOccOrgType' class='comboMax'>");
					//orgDtls.append(orgTypeValues);
					//orgDtls.append("</select></div></td>");
				orgDtls.append("<div class='col-sm-6'><label style='"+displayTypeDesig+"'>Designation</label></div>");
				orgDtls.append("<div class='col-sm-6'><input type='text' name='strOccDesc' value='"+strDesignation+"'  class='form-control' maxlength='30' style='"+displayTypeDesig+"'/></div>");
					//orgDtls.append("<td width='25%' class='LABEL'><div style=style='"+displayTypeDesig+"'>Designation</div></td>");
					//orgDtls.append("<td width='25%' class='CONTROL'><div style=style='"+displayTypeDesig+"'><input type='text' name='strOccDesc' value='"+strDesignation+"'  class='txtFldNormal' maxlength='30'/></div></td>");						
					//orgDtls.append("</tr>");
				orgDtls.append("</div>");
					/*orgDtls.append("<tr style='"+displayTypeOffName+"' id='ofc'>");
					orgDtls.append("<td width='25%' class='LABEL'>Office Name</td>");
					orgDtls.append("<td width='25%' class='CONTROL' colspan='3'><input type='text' name='strOccOffName' value='"+strOffName+"'  class='txtFldMax' onkeypress='return validateData(event,4);' maxlength='70'> </td>");
					orgDtls.append("</tr>");
				
					orgDtls.append("<tr style='"+displayTypeOffAddAll+"' id='ofcadd'>");
					orgDtls.append("<td width='25%' class='LABEL'><div style='"+displayTypeOffAdd1+"'>Office Address1</div></td>");
					orgDtls.append("<td width='25%' class='CONTROL'><div style='"+displayTypeOffAdd1+"'><input type='text' name='strOccAdd1' value='"+strOffAdd1+"'  class='txtFldMax' maxlength='50'></div></td>");
					orgDtls.append("<td width='25%' class='LABEL'><div style='"+displayTypeOffAdd2+"'>Office Address2</div></td>");
					orgDtls.append("<td width='25%' class='CONTROL' ><div style='"+displayTypeOffAdd2+"'><input type='text' name='strOccAdd2' value='"+strOffAdd2+"' class='txtFldMax' maxlength='50'></div></td>");
					orgDtls.append("</tr>");
					orgDtls.append("<tr style='"+displayTypeOffPhone+"' id='ofcph'>");
					orgDtls.append("<td width='25%' class='LABEL'>Office Phone No.</td>");
					orgDtls.append("<td width='25%' class='CONTROL' ><input type='text' name='strOccOffPhNo' value='"+strOffPhNo+"' maxlength='30' class='txtFldMax' onkeypress='return validateData(event,2);'></td>");
					orgDtls.append("<td width='25%' class='LABEL' colspan='2'></td>");
					orgDtls.append("</tr>");*/
				
				if (flag) //Emp Details Found
				{
					if (strEmpNo == null)
						strEmpNo = "";
					if (strEmpName == null)
						strEmpName = "";
					if (strDesignation == null)
						strDesignation = "";
					if (strBasic == null)
						strBasic = "0";
					if (strOffName == null)
						strOffName = "";
					if (strOffAdd1 == null)
						strOffAdd1 = "";
					if (strOffAdd2 == null)
						strOffAdd2 = "";
					if (strGovtEmp == null)
						strGovtEmp = "0";
					if (strRelation == null)
						strRelation = "0";
					if (strOrgType == null)
						strOrgType = "0";
					if (strOffCity == null)
						strOffCity = "";
					if (strOffState == null)
						strOffState = "0";
					if (strOffPhNo == null)
						strOffPhNo = "";
					if (strEmpType == null)
						strEmpType = "1";
					
					orgTypeValues = util.getOptionValue(voObj.getGblWs5(),strOrgType, "0^Select Value", false);
					relationValues = util.getOptionValue(voObj.getGblWs2(),strRelation, "0^Select Value", false);
					stateValues = util.getOptionValue(voObj.getGblWs4(), String.valueOf(Integer.parseInt(strOffState)),"0^Select Value", false);					
										
					
						sBuffer.append(dependentDtls);
						sBuffer.append(basicDtls);
						sBuffer.append(orgDtls);						
						//sBuffer.append("</table></div>");
					
				} 
				else 
				{
					sBuffer.append(dependentDtls);
					sBuffer.append(basicDtls);
					sBuffer.append(orgDtls);				
					
					//sBuffer.append("</table></div>");
					
					 	   //sBuffer.append("</form>\n");
						  //sBuffer.append("</div>\n");
						 //sBuffer.append("</div>\n");
						 /*sBuffer.append("</div>\n");
			             sBuffer.append("</div>\n");
			             sBuffer.append("</div>\n");
			             sBuffer.append("</div>\n");
						 sBuffer.append("</div>\n");
						 sBuffer.append("</div>\n");
*/

			             


				}
				if (voObj.getStrMsgType().equals("1")) {
					throw new Exception(voObj.getStrMsgString());
				}
			} 
			catch (SQLException e)
			{
				//e.printStackTrace();
				throw new SQLException("HLPOccupationDetails.getOccupationDetails() -->"	+ e.getMessage());
			} 
			catch (Exception e) 
			{
				throw new Exception(	"HLPOccupationDetails.getOccupationDetails() -->"+ e.getMessage());
			}
		} 
		//else {
	//		throw new SQLException(
	//				"HLPOccupationDetails.getOccupationDetails() --> No Data Found in Occupation Table");
	//	}
		return sBuffer.toString();
	}
	
	

}
