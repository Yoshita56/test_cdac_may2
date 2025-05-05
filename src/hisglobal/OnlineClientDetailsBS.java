package hisglobal;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import hisglobal.backutil.HisDAO;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.sql.rowset.WebRowSet;

import billing.BillConfigUtil;
import billing.BillingFB;
import billing.BillingVO;
import billing.BillingBO;

public class OnlineClientDetailsBS implements Tag 
{
	PageContext pageContext;
	private String crNo = "0";

	public String getCrNo() 
	{
		return crNo;
	}

	public void setCrNo(String crNo) 
	{
		this.crNo = crNo;
	}
	

	@Override
	public int doEndTag() throws JspException
	{
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException
	{
		HisUtil util=new HisUtil("Billing", "OnlineClientDetails");
		BillingVO voObj = null;
		WebRowSet ws = null;
		JspWriter jw = null;
		String strClientName="";
		String strEmployeeId=""; 
		String strEmployeeName="";
		String strRelationId="";
		String strRelationType="";
		String strCardValidity="";
		String strPayClientName="";
		String strClientType="";
		String strClientNo="";
		String strRelation="";
		String strLetterType="";
		String strCatGrp="1";
		try 
		{
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			Calendar c = Calendar.getInstance();
			String dt;
		  
		    c.setTime(sdf.parse(util.getASDate("dd-MMM-yyyy")));
			c.add(Calendar.DATE, 29);  // number of days to add
			dt = sdf.format(c.getTime());  // dt is now the valid upto date
			voObj = new BillingVO();
			jw = pageContext.getOut();
			ws = getOnlineCltDtlsWs(voObj);
			//System.out.println("ws.size :"+ws.size());
			if (ws!=null && ws.size()>0) 
			{
				try 
				{
					if (ws.next())
					{
					  strClientNo=ws.getString(1);
					  strClientName=ws.getString(2);
					  strClientType=ws.getString(3);
					  strCardValidity=ws.getString(4);
					  strEmployeeName=ws.getString(5);
					  strEmployeeId=ws.getString(6);
					  strRelationId=ws.getString(7);
					  strRelation=ws.getString(8);
					  strCatGrp=ws.getString(9);

					  if(strClientName == null) strClientName = "";
					  if(strEmployeeId == null) strEmployeeId = "";
					  if(strEmployeeName == null) strEmployeeName = "";
					  if(strRelationId == null) strRelationId = "";
					  if(strCardValidity == null) strCardValidity = "";
					  if(strClientType == null) strClientType = ""; 
					  if(strRelation == null) strRelation = "";
					  if(strCatGrp == null) strCatGrp = "3";
					  
					  String strHiddenOnlCltDtl=strClientNo;
					 
					
					  if(strCatGrp.equals("3"))//Credit With Letter Ex. CGHS, Client
					  {
						  jw.print("<div id='creditDtlMenu' style='display: none;' draggable='true' >");
						  jw.print("<div id='creditDtlMenuInner' style='display: block' draggable='true'>");
						  jw.print("<div class='row rowFlex reFlex'>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<label><font color='red'>*</font>Letter No./TG(Counter) No.</label>");
						  jw.print("</div>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<input type='text' id='strNewCreditLetterNoId' name='strNewCreditLetterNo' value= ''  class='form-control' maxlength='50'>");
						  jw.print("</div>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<label><font color='red'>*</font>Letter Type</label>");
						  jw.print("</div>");
						  jw.print("<div class='col-sm-3'>");
						  getCreditLetterTypes(voObj);
						  strLetterType=util.getOptionValue(voObj.getGblWs4(),"","",false);
						  jw.print("<select id='strNewCreditLetterTypeId' name='strNewCreditLetterType' class='browser-default custom-select'>"+strLetterType+"</select>");
						  jw.print("</div>");
						  jw.print("</div>");
						  
						  jw.print("<div class='row rowFlex reFlex'>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<label><font color='red'>*</font>Letter Date</label>");
						  jw.print("</div>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<input type='text' tabindex='1' class='form-control' maxlength='11' name='strNewCreditLetterDate' id='strNewCreditLetterDate' value='"+util.getASDate("dd-MMM-yyyy")+"' >"
							        + " <input type='checkbox' id='checkBoxDP' value=''>");				
						  jw.print("</div>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<label><font color='red'>*</font>Credit Limit</label>");
						  jw.print("</div>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<input type='text' id='strNewCreditLetterLimitId' name='strNewCreditLetterLimit' value='0.00' onkeypress='return validateData(event,7);' class='form-control' maxlength='7' onclick='focusSelect(this)' onblur='mergeLim()'>");
                          jw.print("</div>");
						  jw.print("</div>");
						  
						  jw.print("<div class='row rowFlex reFlex'>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<label><font color='red'>*</font>Client Name</label>");
						  jw.print("</div>");
						  jw.print("<div class='col-sm-3'>");
						  getClientName(voObj);
						  strPayClientName=util.getOptionValue(voObj.getGblWs2(),strClientNo,"",false);
						  jw.print("<select name='strPayClientName' id='strPayClientNameId' class='browser-default custom-select'>"+strPayClientName+"</select>");
					  	  jw.print("</div>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<label>Client Type</label>");
						  jw.print("</div>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<div id='clientTypeDiv'>");
						  jw.print(strClientType);
						  jw.print("</div>");
						  jw.print("</div>");
						  jw.print("</div>");
						  
						  jw.print("<div class='row rowFlex reFlex'>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<label>Combined Limit</label>");
						  jw.print("</div>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<input type='text' id='strNewCombLetterLimitId' name='strNewCombCreditLetterLimit' value= '0.00' onkeypress='return validateData(event,5);' class='form-control' maxlength='7' readonly>");
                          jw.print("</div>");
						  jw.print("<div class='col-sm-3' align='right'>");
						  jw.print("<input type='checkbox' id='merge' name='merge' value='0' onclick='addLimit(this);'>");
						  jw.print("</div>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<label>Add All Previous Letter Limits in Current/New Letter</label>");
						  jw.print("</div>");
						  jw.print("</div>");
						  
						  jw.print("<div class='row rowFlex reFlex' style='display:none'>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<label>Employee Name</label>");
						  jw.print("</div>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<input type='text' id='strEmployeeNameId' name='strEmployeeName' value= '"+ strEmployeeName+ "' onkeypress='return validateData(event,11);' maxlength='20' class='txtFldNormal'>");
                          jw.print("</div>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<label>Card No./Emp. ID</label>");
						  jw.print("</div>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<input type='text' id='strEmployeeId' name='strEmployeeId' value= '"+ strEmployeeId+ "' onkeypress='return validateData(event,9);' class='txtFldNormal'>");				  
						  jw.print("</div>");
						  jw.print("</div>");
						  
						  jw.print("<div class='row rowFlex reFlex' style='display:none'>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<label>Card Validity</label>");
						  jw.print("</div>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<input type='text' tabindex='1' class='txtFldDate' maxlength='11' name='strCardValidity' id='strCardValidity' value='"+util.getASDate("dd-MMM-yyyy")+"' >(dd-Mon-yyyy)</td>");
                          jw.print("</div>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<label>Relation with Patient</label>");
						  jw.print("</div>");
						  jw.print("<div class='col-sm-3'>");
						  getRelations(voObj);
							strRelationType=util.getOptionValue(voObj.getGblWs3(),strRelation,"0^Select Value",false);
							jw.print("<select name='strRalationId' id='strRalationId' class='comboNormal'>"+strRelationType+"</select>");
						  jw.print("</div>");
						  jw.print("</div>");
						 
						  
						  jw.print("<div class='row rowFlex reFlex' style='display:none'>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<label>Room Eligibility</label>");
						  jw.print("</div>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<input type='text' id='strRoomLimitId' name='strRoomLimit' value='0.00' onkeypress='return validateData(event,7);' class='txtFldNormal' maxlength='7' onclick='focusSelect(this)'></td></tr>");
                          jw.print("</div>");
						  jw.print("<div class='col-sm-3'><label>Letter Validity Date</label>");
						  jw.print("</div>");
						  jw.print("<div class='col-sm-3'>");
						  jw.print("<input type='text' tabindex='1' class='txtFldDate' maxlength='11' name='strNewCreditLetterValidDate' id='strNewCreditLetterValidDate' value='"+dt+"' >(dd-Mon-yyyy)</td>");
						  jw.print("</div>");
						  jw.print("</div>");
						  jw.print("<div class='row rowFlex reFlex'>");
						  jw.print("<div class='col-sm-12'>");
						  jw.print("<label><font size='2' color='red'>* Kindly don't enter ^ and # in Letter Number Field</font></label>");
						  jw.print("</div>");
						  jw.print("</div>");
						  
						 
						 /* jw.print("<table class='table' style='width:700px' ><tr class='HEADER'><th colspan='4' align='left'>&nbsp;Credit Details</th></tr>");
						  jw.print("<tr><td width='25%' class='LABEL' colspan='1'><font color='red'>*</font>Letter No./TG(Counter) No.</td>");
						  jw.print("<td width='25%' class='CONTROL' colspan='1'>");
						  jw.print("<input type='text' id='strNewCreditLetterNoId' name='strNewCreditLetterNo' value= ''  class='txtFldBig' maxlength='50'>");
						  jw.print("</td>");
						  jw.print("<td width='25%' class='LABEL' colspan='1'><font color='red'>*</font>Letter Type</td>");
						  getCreditLetterTypes(voObj);
						  strLetterType=util.getOptionValue(voObj.getGblWs4(),"","",false);
						  jw.print("<td><select id='strNewCreditLetterTypeId' name='strNewCreditLetterType' class='comboNormal'>"+strLetterType+"</select>");
						  jw.print("</td>");
						  jw.print("</tr>");
						  jw.print("<tr>");
						  jw.print("<td width='25%' class='LABEL' colspan='1'><font color='red'>*</font>Letter Date</td>");
						  jw.print("<td class='CONTROL'  width='25%' colspan='1'>");//+HisUtil.getDatePicker("strNewCreditLetterDate",util.getASDate("dd-MMM-yyyy"),false)+"</td>");
						  jw.print("<input type='text' tabindex='1' class='txtFldDate' maxlength='11' name='strNewCreditLetterDate' id='strNewCreditLetterDate' value='"+util.getASDate("dd-MMM-yyyy")+"' >"
						        + " <input type='checkbox' id='checkBoxDP' value=''><label id='dpImg' for='checkBoxDP'><img  style='margin:7px;' src='../../hisglobal/images/calendar-icon.gif'></label></td>");
						  jw.print("<td width='25%' class='LABEL' colspan='1'><font color='red'>*</font>Credit Limit</td>");
						  jw.print("<td width='25%' class='CONTROL' colspan='1'>");
						  jw.print("<input type='text' id='strNewCreditLetterLimitId' name='strNewCreditLetterLimit' value='0.00' onkeypress='return validateData(event,7);' class='txtFldNormal' maxlength='7' onclick='focusSelect(this)' onblur='mergeLim()'>");
						  jw.print("</td>");					  
						  jw.print("</tr>");
						  //jw.print("<table class='TABLEWIDTH' border='0' cellspacing='1px' align='center' >");
						  jw.print("<tr><td width='25%' class='LABEL' colspan='1'><font color='red'>*</font>Client Name</td>");
						  jw.print("<td width='25%' class='CONTROL' colspan='1'>");
						  
						  if(strClientID != null && strClientID != "")
						  {
							  jw.print(strClientID);
							  jw.print("<input type='hidden' name='strPayClientName' value= '"+ strClientID+ "'>");
						  }
						  else
						  {
							  getClientName(voObj);
							  strPayClientName=util.getOptionValue(voObj.getGblWs2(),strClientNo,"",false);
							  jw.print("<select name='strPayClientName' id='strPayClientNameId' class='comboNormal'>"+strPayClientName+"</select>");
						  //}
						  jw.print("</td>");
						  
						  jw.print("<td width='25%' class='LABEL' colspan='1'>Client Type</td>");
						  if(strClientType.equals("") || strClientType==null )
						  { 
								jw.print("<td width='25%' class='CONTROL'>");
								jw.print("<input type='text' id='strPayClientTypeName' name='strPayClientTypeName' value='' class='txtFldNormal'>");
						  }
						  else
						  {
							  jw.print("<td  width='25%' class='CONTROL' colspan='1'><div id='clientTypeDiv'>");
							  jw.print(strClientType);
							  jw.print("</div>");
						  //}
						  jw.print("</td></tr>");
						  
						  jw.print("<tr>");
						  jw.print("<td width='25%' class='LABEL' colspan='1' style='display:none;'>Letter Validity Date</td>");
						  jw.print("<td class='CONTROL'  width='25%' colspan='1' style='display:none;'>");//+HisUtil.getDatePicker("strNewCreditLetterDate",util.getASDate("dd-MMM-yyyy"),false)+"</td>");
						  jw.print("<input type='text' tabindex='1' class='txtFldDate' maxlength='11' name='strNewCreditLetterValidDate' id='strNewCreditLetterValidDate' value='"+dt+"' >(dd-Mon-yyyy)</td>");
						  jw.print("<td width='25%' class='LABEL' colspan='1'>Combined Limit</td>");
						  jw.print("<td width='25%' class='CONTROL' colspan='1'>");
						  jw.print("<input type='text' id='strNewCombLetterLimitId' name='strNewCombCreditLetterLimit' value= '0.00' onkeypress='return validateData(event,5);' class='txtFldNormal' maxlength='7' readonly>");
						  jw.print("</td>");
						  jw.print("<td width='25%' class='LABEL' colspan='1'>");
						  jw.print("<input type='checkbox' id='merge' name='merge' value='0' onclick='addLimit(this);'>");
						  jw.print("</td>");
						  jw.print("<td width='25%' class='CONTROL' colspan='3'><b>Add All Previous Letter Limits in Current/New Letter</b></td></tr>");*/
						  /*jw.print("<tr style='display:none;'><td width='25%' class='LABEL' colspan='1'>Employee Name</td>");
						  if(strEmployeeName.equals("")||strEmployeeName==null )
						  {
							  jw.print("<td width='25%' class='CONTROL' colspan='1'>");
							  jw.print("<input type='text' id='strEmployeeNameId' name='strEmployeeName' value= '"+ strEmployeeName+ "' onkeypress='return validateData(event,11);' maxlength='20' class='txtFldNormal'>");
						  }
						  else
						  {
							  jw.print("<td width='25%' class='CONTROL'><input type='hidden' name='strEmployeeName' value= '"+ strEmployeeName+ "'>");
							  jw.print(strEmployeeName);
						  }
						  jw.print("</td>");
						  jw.print("<td width='25%' class='LABEL' colspan='1'>Card No./Emp. ID</td>");
						  if(strEmployeeId.equals("")|| strEmployeeId==null)
						  {
							  jw.print("<td width='25%' class='CONTROL' colspan='1'>");
							  jw.print("<input type='text' id='strEmployeeId' name='strEmployeeId' value= '"+ strEmployeeId+ "' onkeypress='return validateData(event,9);' class='txtFldNormal'>");				  
						  }
						  else
						  {
							  jw.print("<td width='25%' class='CONTROL'><input type='hidden' name='strEmployeeId' value= '"+ strEmployeeId+ "'>");
							  jw.print(strEmployeeId);  
						  }
						  jw.print("</td></tr>");	
						  */
						  
						/*  jw.print("<tr style='display:none;'><td width='25%' class='LABEL' colspan='1'>Card Validity</td>");
						  if(strCardValidity.equals("")|| strCardValidity==null)
						  {
							  jw.print("<td class='CONTROL'  width='25%' colspan='1'>");//+HisUtil.getDatePicker("strCardValidity",strCardValidity,false)+"</td>");
							  jw.print("<input type='text' tabindex='1' class='txtFldDate' maxlength='11' name='strCardValidity' id='strCardValidity' value='"+util.getASDate("dd-MMM-yyyy")+"' >(dd-Mon-yyyy)</td>");
						  }
						  else
						  {
						     jw.print("<td width='25%' class='CONTROL'><input type='hidden' name='strCardValidity' value= '"+ strCardValidity+ "'>");
						     jw.print(strCardValidity);
						  }
						  jw.print("</td>");
						  
						  
						  jw.print("<td width='25%' class='LABEL' colspan='1'>Relation with Patient</td>");
						  jw.print("<td width='25%' class='CONTROL' colspan='1'>");
						  
						if(strRelationId != null && strRelationId != "") 
							  jw.print("<input type='hidden' name='strRalationId' value= '"+ strRelation+ "'>"+strRelationId);
						else
						{
							getRelations(voObj);
							strRelationType=util.getOptionValue(voObj.getGblWs3(),strRelation,"0^Select Value",false);
							jw.print("<select name='strRalationId' id='strRalationId' class='comboNormal'>"+strRelationType+"</select>");
						//}
						  jw.print("</td></tr>");*/
						 /* jw.print("<tr style='display:none;'>");
						  jw.print("<td width='25%' class='LABEL' colspan='1'>Room Eligibility(IP Only)</td>");
						  jw.print("<td width='75%' class='CONTROL' colspan='3'>");
						  jw.print("<input type='text' id='strRoomLimitId' name='strRoomLimit' value='0.00' onkeypress='return validateData(event,7);' class='txtFldNormal' maxlength='7' onclick='focusSelect(this)'></td></tr>");
						  jw.print("<tr>");
						  jw.print("<td width='25%' class='LABEL' colspan='1'>");
						  jw.print("<input type='checkbox' id='merge' name='merge' value='0' onclick='addLimit(this);'>");
						  jw.print("</td>");
						  jw.print("<td width='75%' class='CONTROL' colspan='3'><b>Add All Previous Letter Limits in Current/New Letter</b></td></tr>");
						  jw.print("<tr><td class='LABEL' colspan='3' align='left'><font size='2' color='red'>* Kindly don't enter ^ and # in Letter Number Field</font></td></tr>");
						  jw.print("</table>");*/
						  jw.print("<input type='hidden' name='strCatGrp' value='"+strCatGrp+"'>");
						  jw.print("<input type='hidden' name='strClientName' value='"+strClientName+"'>");
						  jw.print("<div class='lineContinue'>&nbsp;</div>");
						  jw.print("<center>");
						  jw.print("<table width='300' border='0' cellpadding='0' cellspacing='0'><tr><td><center>");
						  jw.print("<button type='button' class='btn btn-primary' onClick='return validateCreditDetailsBS(this);'>Ok</button>&nbsp;&nbsp;");
						  jw.print("<button type='button' class='btn btn-danger' tabindex='1' onClick=\"hideCreditDetailsBS('creditDtlMenu');\">Cancel</button>");
						  jw.print("</center></td></tr></table></center>");		
						  jw.print("</div></td></tr></table></div>");						  
					  }
					  else //Credit Without Letter Ex. Arogyashri, Project, FOR arogyashri letter will have value of tg number or counter number or card number
					  {
						  jw.print("<div class='popUpDiv' id='creditDtlMenu' style='display: none;' draggable='true' >");
						  jw.print("<table bgcolor='white'><tr><td><div class='popup' id='creditDtlMenuInner' style='display: block' draggable='true'>");
						  jw.print("<table class='table' style='width:700px'><tr class='HEADER'><th colspan='4' align='left'>&nbsp;Credit Details</th></tr>");
						  jw.print("<tr><td width='25%' class='LABEL' colspan='1'>Letter No./TG(Counter) No.</td>");
						  jw.print("<td width='25%' class='CONTROL' colspan='1'>");
						  jw.print("<input type='text' id='strNewCreditLetterNoId' name='strNewCreditLetterNo' value= ''  class='txtFldBig' maxlength='50'>");
						  jw.print("</td>");
						  jw.print("<td width='25%' class='LABEL' colspan='1'>Letter Type</td>");
						  getCreditLetterTypes(voObj);
						  strLetterType=util.getOptionValue(voObj.getGblWs4(),"","",false);
						  jw.print("<td><select id='strNewCreditLetterTypeId' name='strNewCreditLetterType' disabled class='comboNormal'>"+strLetterType+"</select>");
						  jw.print("</td>");
						  jw.print("</tr>");
						  jw.print("<tr>");
						  jw.print("<td width='25%' class='LABEL' colspan='1'>Letter Date</td>");
						  jw.print("<td class='CONTROL'  width='25%' colspan='1'>");//+HisUtil.getDatePicker("-",util.getASDate("dd-MMM-yyyy"),true)+"</td>");
						  jw.print("<input type='text' tabindex='1' class='txtFldDate' maxlength='11' name='strNewCreditLetterDate' id='strNewCreditLetterDate' value='"+util.getASDate("dd-MMM-yyyy")+"' >"
								  + " <input type='checkbox' id='checkBoxDP' value=''><label id='dpImg' for='checkBoxDP'><img style='margin:7px;' src='../../hisglobal/images/calendar-icon.gif'></label></td>");

						  jw.print("<td width='25%' class='LABEL' colspan='1'><font color='red'>*</font>Credit Limit</td>");
						  jw.print("<td width='25%' class='CONTROL' colspan='1'>");
						  jw.print("<input type='text' id='strNewCreditLetterLimitId' name='strNewCreditLetterLimit' value= '0.00' onkeypress='return validateData(event,5);' class='txtFldNormal' maxlength='7' onclick='focusSelect(this)' onblur='mergeLim()'>");
						  jw.print("</td>");					  
						  jw.print("</tr>");
						  //jw.print("<table class='TABLEWIDTH' border='0' cellspacing='1px' align='center' >");
						  jw.print("<tr><td width='25%' class='LABEL' colspan='1'><font color='red'>*</font>Client Name</td>");
						  jw.print("<td width='25%' class='CONTROL' colspan='1'>");
						  
						  /*if(strClientID != null && strClientID != "")
						  {
							  jw.print(strClientID);
							  jw.print("<input type='hidden' name='strPayClientName' value= '"+ strClientID+ "'>");
						  }
						  else
						  {*/
							  getClientName(voObj);
							  strPayClientName=util.getOptionValue(voObj.getGblWs2(),strClientNo,"",false);
							  jw.print("<select name='strPayClientName' id='strPayClientNameId' class='comboNormal'>"+strPayClientName+"</select>");
						  //}
						  jw.print("</td>");
						  
						  jw.print("<td width='25%' class='LABEL' colspan='1'>Client Type</td>");
						  /*if(strClientType.equals("") || strClientType==null )
						  { 
								jw.print("<td width='25%' class='CONTROL'>");
								jw.print("<input type='text' id='strPayClientTypeName' name='strPayClientTypeName' value='' class='txtFldNormal'>");
						  }
						  else
						  {*/
							  jw.print("<td  width='25%' class='CONTROL' colspan='1'><div id='clientTypeDiv'>");
							  jw.print(strClientType);
							  jw.print("</div>");
						  //}
						  jw.print("</td></tr>");
						  
						  jw.print("<tr>");
						  jw.print("<td width='25%' class='LABEL' colspan='1' style='display:none;'>Letter Validity Date</td>");
						  jw.print("<td class='CONTROL'  width='25%' colspan='1' style='display:none;'>");//+HisUtil.getDatePicker("strNewCreditLetterDate",util.getASDate("dd-MMM-yyyy"),false)+"</td>");
						  jw.print("<input type='text' tabindex='1' class='txtFldDate' maxlength='11' name='strNewCreditLetterValidDate' id='strNewCreditLetterValidDate' value='"+dt+"' >(dd-Mon-yyyy)</td>");
						  jw.print("<td width='25%' class='LABEL' colspan='1'>Combined Limit</td>");
						  jw.print("<td width='25%' class='CONTROL' colspan='1'>");
						  jw.print("<input type='text' id='strNewCombLetterLimitId' name='strNewCombCreditLetterLimit' value= '0.00' onkeypress='return validateData(event,5);' class='txtFldNormal' maxlength='7' readonly>");
						  jw.print("</td>");
						  jw.print("<td width='25%' class='LABEL' colspan='1'>");
						  jw.print("<input type='checkbox' id='merge' name='merge' value='0' onclick='addLimit(this);'>");
						  jw.print("</td>");
						  jw.print("<td width='25%' class='CONTROL' colspan='3'><b>Add All Previous Letter Limits in Current/New Letter</b></td></tr>");
						  
						  jw.print("<tr style='display:none;'><td width='25%' class='LABEL' colspan='1'>Employee Name</td>");
						  /*if(strEmployeeName.equals("")||strEmployeeName==null )
						  {*/
							  jw.print("<td width='25%' class='CONTROL' colspan='1'>");
							  jw.print("<input type='text' id='strEmployeeNameId' name='strEmployeeName' value= '"+ strEmployeeName+ "' onkeypress='return validateData(event,11);' maxlength='20' class='txtFldNormal'>");
						  /*}
						  else
						  {
							  jw.print("<td width='25%' class='CONTROL'><input type='hidden' name='strEmployeeName' value= '"+ strEmployeeName+ "'>");
							  jw.print(strEmployeeName);
						  }*/
						  jw.print("</td>");
						  jw.print("<td width='25%' class='LABEL' colspan='1'>Card No./Emp. ID</td>");
						  /*if(strEmployeeId.equals("")|| strEmployeeId==null)
						  {*/
							  jw.print("<td width='25%' class='CONTROL' colspan='1'>");
							  jw.print("<input type='text' id='strEmployeeId' name='strEmployeeId' value= '"+ strEmployeeId+ "' onkeypress='return validateData(event,9);' class='txtFldNormal'>");				  
						  /*}
						  else
						  {
							  jw.print("<td width='25%' class='CONTROL'><input type='hidden' name='strEmployeeId' value= '"+ strEmployeeId+ "'>");
							  jw.print(strEmployeeId);  
						  }*/
						  jw.print("</td></tr>");
						  
						  
						  jw.print("<tr style='display:none;'><td width='25%' class='LABEL' colspan='1'>Card Validity</td>");
						  /*if(strCardValidity.equals("")|| strCardValidity==null)
						  {*/
							  jw.print("<td class='CONTROL'  width='25%' colspan='1'>");//+HisUtil.getDatePicker("strCardValidity",strCardValidity,false)+"</td>");
							  jw.print("<input type='text' tabindex='1' class='txtFldDate' maxlength='11' name='strCardValidity' id='strCardValidity' value='"+util.getASDate("dd-MMM-yyyy")+"' >(dd-Mon-yyyy)</td>");
						  /*}
						  else
						  {
						     jw.print("<td width='25%' class='CONTROL'><input type='hidden' name='strCardValidity' value= '"+ strCardValidity+ "'>");
						     jw.print(strCardValidity);
						  }*/
						  jw.print("</td>");
						  
						  
						  jw.print("<td width='25%' class='LABEL' colspan='1'>Relation with Patient</td>");
						  jw.print("<td width='25%' class='CONTROL' colspan='1'>");
						  
						/*if(strRelationId != null && strRelationId != "") 
							  jw.print("<input type='hidden' name='strRalationId' value= '"+ strRelation+ "'>"+strRelationId);
						else
						{*/
							getRelations(voObj);
							strRelationType=util.getOptionValue(voObj.getGblWs3(),strRelation,"0^Select Value",false);
							jw.print("<select name='strRalationId' id='strRalationId' class='comboNormal'>"+strRelationType+"</select>");
						//}
						  jw.print("</td></tr>");
						  jw.print("<tr style='display:none;'>");
						  jw.print("<td width='25%' class='LABEL' colspan='1'>Room Eligibility(IP Only)</td>");
						  jw.print("<td width='75%' class='CONTROL' colspan='3'>");
						  jw.print("<input type='text' id='strRoomLimitId' name='strRoomLimit' value='0.00' onkeypress='return validateData(event,7);' class='txtFldNormal' maxlength='7' onclick='focusSelect(this)'></td></tr>");
						  /*jw.print("<tr>");
						  jw.print("<td width='25%' class='LABEL' colspan='1'>");
						  jw.print("<input type='checkbox' id='merge' name='merge' value='0' onclick='addLimit(this);'>");
						  jw.print("</td>");
						  jw.print("<td width='75%' class='CONTROL' colspan='3'><b>Add All Previous Letter Limits in Current/New Letter</b></td></tr>");*/
						  jw.print("<tr><td  class='LABEL' colspan='3' align='left'><font size='2' color='red'>* Kindly don't enter ^ and # in Letter Number Field</font></td></tr>");
						  jw.print("</table>");
						  jw.print("<input type='hidden' name='strCatGrp' value='"+strCatGrp+"'>");
						  jw.print("<input type='hidden' name='strClientName' value='"+strClientName+"'>");
						  jw.print("<div class='lineContinue'>&nbsp;</div>");
						  jw.print("<center>");
						  jw.print("<table width='300' border='0' cellpadding='0' cellspacing='0'><tr><td><center>");
						  jw.print("<img style='cursor: hand; cursor: pointer' src='../../hisglobal/images/ok.gif' tabindex='1' onClick='return validateCreditDetailsBS(this);'>&nbsp;");
						  jw.print("<img style='cursor: hand; cursor: pointer' src='../../hisglobal/images/btn-ccl.png' tabindex='1' onClick=\"hideCreditDetailsBS('creditDtlMenu');\">");
						  jw.print("</center></td></tr></table></center>");		
						  jw.print("</div></td></tr></table></div>");
					  }					  
				   }
				}
				catch (Exception e) 
				{
					new Exception(e.getMessage()); 
				}
			}
			else
			{
				String strHiddenOnlCltDtl="0";
				  
				
				  /*jw.print("<input type='hidden' name='strClientNo' value='"+strHiddenOnlCltDtl+"'>");
				  
				  getClientName(voObj);
				  jw.print("<table class='TABLEWIDTH' border='0' cellspacing='1px' align='center' >");
				  jw.print("<tr><td width='25%' class='LABEL'><font color='red'>*</font>Client Name</td>");
				  jw.print("<td width='25%' class='CONTROL'>");
				  strPayClientName=util.getOptionValue(voObj.getGblWs2(),"","0^Select Value",false);
					  jw.print("<select class='comboNormal' name='strPayClientName'>"+strPayClientName+"</select>");
				  jw.print("</td>");
				  
				  jw.print("<td width='25%' class='LABEL'>Client Type</td>");
				  jw.print("<td width='25%' class='CONTROL'>");
				  jw.print("<input type='text' id='strPayClientTypeName' name='strPayClientTypeName' value='' class='txtFldNormal'>");
				  jw.print("</td></tr>");
				  
				  
				  jw.print("<tr><td width='25%' class='LABEL'>Employee Name</td>");
				  jw.print("<td width='25%' class='CONTROL'>");
				  jw.print("<input type='text' id='strEmployeeName' name='strEmployeeName' value='' class='txtFldNormal'>");
				  
				  jw.print("</td>");
				  jw.print("<td width='25%' class='LABEL'>Employee ID</td>");
				  jw.print("<td width='25%' class='CONTROL'>");
				  jw.print("<input type='text' id='strEmployeeId' name='strEmployeeId' value='' class='txtFldNormal'>");				  
				  jw.print("</td></tr>");	
				  
				  
				  jw.print("<tr><td width='25%' class='LABEL'>Card Validity</td>");
				  jw.print("<td class='CONTROL' width='25%'>"+HisUtil.getDatePicker("strCardValidity",strCardValidity,false)+"</td>");
				  jw.print("</td>");
				  
				  getRelations(voObj);
				  jw.print("<td width='25%' class='LABEL'>Relation With Patient</td>");
				  jw.print("<td width='25%' class='combomin'>");
				  strRelationType=util.getOptionValue(voObj.getGblWs3(),"","0^Select Value",false);
				  jw.print("<select name='strRalationId' class='comboNormal'>"+strRelationType+"</select>");
				  jw.print("</td></tr>");
				  jw.print("</table>");*/
				
				//jw.print("<input type='hidden' name='strClientNo' value='"+strHiddenOnlCltDtl+"'>");
				  
				  jw.print("<div class='popUpDiv' id='creditDtlMenu' style='display: none;' draggable='true' >");
				  jw.print("<table bgcolor='white'><tr><td><div class='popup' id='creditDtlMenuInner' style='display: block' draggable='true'>");
				  jw.print("<table class='table' style='width:700px'><tr class='HEADER'><th colspan='4' align='left'>&nbsp;Credit Details</th></tr>");
				  jw.print("<tr><td width='25%' class='LABEL' colspan='1'><font color='red'>*</font>Letter No./TG(Counter) No.</td>");
				  jw.print("<td width='25%' class='CONTROL' colspan='1'>");
				  jw.print("<input type='text' id='strNewCreditLetterNoId' name='strNewCreditLetterNo' value= ''  class='txtFldBig' maxlength='50'>");
				  jw.print("</td>");
				  jw.print("<td width='25%' class='LABEL' colspan='1'><font color='red'>*</font>Letter Type</td>");
				  getCreditLetterTypes(voObj);
				  strLetterType=util.getOptionValue(voObj.getGblWs4(),"","",false);
				  jw.print("<td><select id='strNewCreditLetterTypeId' name='strNewCreditLetterType' class='comboNormal'>"+strLetterType+"</select>");
				  jw.print("</td>");
				  jw.print("</tr>");
				  jw.print("<tr>");
				  jw.print("<td width='25%' class='LABEL' colspan='1'><font color='red'>*</font>Letter Date</td>");
				  jw.print("<td class='CONTROL'  width='25%' colspan='1'>");
				  jw.print("<input type='text' tabindex='1' class='txtFldDate' maxlength='11' name='strNewCreditLetterDate' id='strNewCreditLetterDate' value='"+util.getASDate("dd-MMM-yyyy")+"' >"
					        + " <input type='checkbox' id='checkBoxDP' value=''><label id='dpImg' for='checkBoxDP'><img  style='margin:7px;' src='../../hisglobal/images/calendar-icon.gif'></label></td>");
				  jw.print("<td width='25%' class='LABEL' colspan='1'><font color='red'>*</font>Credit Limit</td>");
				  jw.print("<td width='25%' class='CONTROL' colspan='1'>");
				  jw.print("<input type='text' id='strNewCreditLetterLimitId' name='strNewCreditLetterLimit' value= '0.00' onkeypress='return validateData(event,5);' class='txtFldNormal' maxlength='7' onclick='focusSelect(this)' onblur='mergeLim()'>");
				  jw.print("</td>");					  
				  jw.print("</tr>");
				  //jw.print("<table class='TABLEWIDTH' border='0' cellspacing='1px' align='center' >");
				  jw.print("<tr><td width='25%' class='LABEL' colspan='1'><font color='red'>*</font>Client Name</td>");
				  jw.print("<td width='25%' class='CONTROL' colspan='1'>");
				  
				  /*if(strClientID != null && strClientID != "")
				  {
					  jw.print(strClientID);
					  jw.print("<input type='hidden' name='strPayClientName' value= '"+ strClientID+ "'>");
				  }
				  else
				  {*/
					  getClientName(voObj);
					  strPayClientName=util.getOptionValue(voObj.getGblWs2(),strClientNo,"",false);
					  jw.print("<select name='strPayClientName' id='strPayClientNameId' class='comboNormal'>"+strPayClientName+"</select>");
				  //}
				  jw.print("</td>");
				  
				  jw.print("<td width='25%' class='LABEL' colspan='1'>Client Type</td>");
				  /*if(strClientType.equals("") || strClientType==null )
				  { 
						jw.print("<td width='25%' class='CONTROL'>");
						jw.print("<input type='text' id='strPayClientTypeName' name='strPayClientTypeName' value='' class='txtFldNormal'>");
				  }
				  else
				  {*/
					  jw.print("<td  width='25%' class='CONTROL' colspan='1'><div id='clientTypeDiv'>");
					  jw.print(strClientType);
					  jw.print("</div>");
				  //}
				  jw.print("</td></tr>");
				  
				  jw.print("<tr>");
				  jw.print("<td width='25%' class='LABEL' colspan='1' style='display:none;'>Letter Validity Date</td>");
				  jw.print("<td class='CONTROL'  width='25%' colspan='1' style='display:none;'>");//+HisUtil.getDatePicker("strNewCreditLetterDate",util.getASDate("dd-MMM-yyyy"),false)+"</td>");
				  jw.print("<input type='text' tabindex='1' class='txtFldDate' maxlength='11' name='strNewCreditLetterValidDate' id='strNewCreditLetterValidDate' value='"+dt+"' >(dd-Mon-yyyy)</td>");
				  jw.print("<td width='25%' class='LABEL' colspan='1'>Combined Limit</td>");
				  jw.print("<td width='25%' class='CONTROL' colspan='1'>");
				  jw.print("<input type='text' id='strNewCombLetterLimitId' name='strNewCombCreditLetterLimit' value= '0.00' onkeypress='return validateData(event,5);' class='txtFldNormal' maxlength='7' readonly>");
				  jw.print("</td>");
				  jw.print("<td width='25%' class='LABEL' colspan='1'>");
				  jw.print("<input type='checkbox' id='merge' name='merge' value='0' onclick='addLimit(this);'>");
				  jw.print("</td>");
				  jw.print("<td width='25%' class='CONTROL' colspan='3'><b>Add All Previous Letter Limits in Current/New Letter</b></td></tr>");
				  
				  jw.print("<tr style='display:none;'><td width='25%' class='LABEL' colspan='1'>Employee Name</td>");
				  /*if(strEmployeeName.equals("")||strEmployeeName==null )
				  {*/
					  jw.print("<td width='25%' class='CONTROL' colspan='1'>");
					  jw.print("<input type='text' id='strEmployeeNameId' name='strEmployeeName' value= '"+ strEmployeeName+ "' onkeypress='return validateData(event,11);' maxlength='20' class='txtFldNormal'>");
				  /*}
				  else
				  {
					  jw.print("<td width='25%' class='CONTROL'><input type='hidden' name='strEmployeeName' value= '"+ strEmployeeName+ "'>");
					  jw.print(strEmployeeName);
				  }*/
				  jw.print("</td>");
				  jw.print("<td width='25%' class='LABEL' colspan='1'>Card No./Emp. ID</td>");
				  /*if(strEmployeeId.equals("")|| strEmployeeId==null)
				  {*/
					  jw.print("<td width='25%' class='CONTROL' colspan='1'>");
					  jw.print("<input type='text' id='strEmployeeId' name='strEmployeeId' value= '"+ strEmployeeId+ "' onkeypress='return validateData(event,9);' class='txtFldNormal'>");				  
				  /*}
				  else
				  {
					  jw.print("<td width='25%' class='CONTROL'><input type='hidden' name='strEmployeeId' value= '"+ strEmployeeId+ "'>");
					  jw.print(strEmployeeId);  
				  }*/
				  jw.print("</td></tr>");	
				  
				  
				  jw.print("<tr style='display:none;'><td width='25%' class='LABEL' colspan='1'>Card Validity</td>");
				  /*if(strCardValidity.equals("")|| strCardValidity==null)
				  {*/
					  jw.print("<td class='CONTROL'  width='25%' colspan='1'>");//+HisUtil.getDatePicker("strCardValidity",strCardValidity,false)+"</td>");
					  jw.print("<input type='text' tabindex='1' class='txtFldDate' maxlength='11' name='strCardValidity' id='strCardValidity' value='"+util.getASDate("dd-MMM-yyyy")+"' >(dd-Mon-yyyy)</td>");
				  /*}
				  else
				  {
				     jw.print("<td width='25%' class='CONTROL'><input type='hidden' name='strCardValidity' value= '"+ strCardValidity+ "'>");
				     jw.print(strCardValidity);
				  }*/
				  jw.print("</td>");
				  
				  
				  jw.print("<td width='25%' class='LABEL' colspan='1'>Relation with Patient</td>");
				  jw.print("<td width='25%' class='CONTROL' colspan='1'>");
				  
				/*if(strRelationId != null && strRelationId != "") 
					  jw.print("<input type='hidden' name='strRalationId' value= '"+ strRelation+ "'>"+strRelationId);
				else
				{*/
					getRelations(voObj);
					strRelationType=util.getOptionValue(voObj.getGblWs3(),strRelation,"0^Select Value",false);
					jw.print("<select name='strRalationId' id='strRalationId' class='comboNormal'>"+strRelationType+"</select>");
				//}
				  jw.print("</td></tr>");
				  jw.print("<tr style='display:none;'>");
				  jw.print("<td width='25%' class='LABEL' colspan='1'>Room Eligibility(IP Only)</td>");
				  jw.print("<td width='75%' class='CONTROL' colspan='3'>");
				  jw.print("<input type='text' id='strRoomLimitId' name='strRoomLimit' value='0.00' onkeypress='return validateData(event,7);' class='txtFldNormal' maxlength='7' onclick='focusSelect(this)'></td></tr>");
				  /*jw.print("<tr>");
				  jw.print("<td width='25%' class='LABEL' colspan='1'>");
				  jw.print("<input type='checkbox' id='merge' name='merge' value='0' onclick='addLimit(this);'>");
				  jw.print("</td>");
				  jw.print("<td width='75%' class='CONTROL' colspan='3'><b>Add All Previous Letter Limits in Current/New Letter</b></td></tr>");*/
				  jw.print("<tr><td  class='LABEL' colspan='3' align='left'><font size='2' color='red'>* Kindly don't enter ^ and # in Letter Number Field</font></td></tr>");
				  jw.print("</table>");
				  jw.print("<input type='hidden' name='strCatGrp' value='"+strCatGrp+"'>");
				  jw.print("<input type='hidden' name='strClientName' value='"+strClientName+"'>");
				  jw.print("<div class='lineContinue'>&nbsp;</div>");
				  jw.print("<center>");
				  jw.print("<table width='300' border='0' cellpadding='0' cellspacing='0'><tr><td><center>");
				  jw.print("<img style='cursor: hand; cursor: pointer' src='../../hisglobal/images/ok.gif' tabindex='1' onClick='return validateCreditDetailsBS(this);'>&nbsp;");
				  jw.print("<img style='cursor: hand; cursor: pointer' src='../../hisglobal/images/btn-ccl.png' tabindex='1' onClick=\"hideCreditDetailsBS('creditDtlMenu');\">");
				  jw.print("</center></td></tr></table></center>");		
				  jw.print("</div></td></tr></table></div>");
				
			}
		}
        catch (Exception e) 
		{
			e.printStackTrace();
			voObj.setStrMsgString("Error while getting Online Client Details");
			new HisException("IPD Transaction","OnlineClientDetails Tag.doStartTag() -->",e.getMessage());
		}
		finally
		{
			try
			{
				jw.print("<input type='hidden' name='strGlbErrMsgTLD' value='"+voObj.getStrMsgString()+"'>");
				ws.close();
			}
			catch(Exception e)
			{				
			}
			ws = null;
			voObj = null;
		}
		return EVAL_BODY_INCLUDE;
		
	}

	@Override
	public Tag getParent() {
		return null;
	}

	@Override
	public void release() {
		
	}


	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	public void setParent(Tag tag) {
		
		
	}
	
public WebRowSet getOnlineCltDtlsWs(BillingVO voObj)throws Exception{
		
		WebRowSet ws = null;
		BillingBO boObj = new BillingBO();
		if(!this.getCrNo().equals("")){
		voObj.setStrValue1(this.getCrNo());
		voObj.setStrValue2(pageContext.getSession().getAttribute("HOSPITAL_CODE").toString());
		boObj.getOnlineClientDetails(voObj);
		}
		else{
			ws = null;
		}
		ws = voObj.getGblWs1();
		return ws;
}

public void getClientName(BillingVO voObj)
{
	HisDAO daoObj = null;
	WebRowSet ws = null;

	String strProcName = "{call pkg_bill_view.proc_hblt_client_mst(?,?,?,?,?)}";
	int nProcIndex = 0;

	String strHospitalCode = pageContext.getSession().getAttribute("HOSPITAL_CODE").toString();

	String strErr = "";

	try {

		daoObj = new HisDAO("Billing","OnlineClientDetails");

		nProcIndex = daoObj.setProcedure(strProcName);

		daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
		daoObj.setProcInValue(nProcIndex, "hosp_code", strHospitalCode,2);
		daoObj.setProcInValue(nProcIndex, "client_no", "",3);
		daoObj.setProcOutValue(nProcIndex, "err", 1,4);
		daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2,5);
		daoObj.executeProcedureByPosition(nProcIndex);

		strErr = daoObj.getString(nProcIndex, "err");

		if (strErr == null)
			strErr = "";

		if (strErr.equals("")) {

			ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
			voObj.setGblWs2(ws);

		} else {
			throw new Exception(strErr);
		}
}
	
	catch (Exception e) {

		voObj.setStrMsgString("DAObilling.setOnlineClientDetails().getClientName --> "+ e.getMessage());
		voObj.setStrMsgType("1");

	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}

}

public static void getRelations(BillingVO vo) 
{
	WebRowSet ws = null;
	String proc_name = "";
	proc_name = "{call PKG_BILL_VIEW.proc_get_relations(?,?,?)}";
	HisDAO dao = null;
	int nprocIndex = 0;
	String strErr = "";
	
	try 
	{
		dao = new HisDAO("Billing","OnlineClientDetails");
		nprocIndex = dao.setProcedure(proc_name);
		
		dao.setProcInValue(nprocIndex, "modeval", "1",1);
		dao.setProcOutValue(nprocIndex, "err", 1,2);
		dao.setProcOutValue(nprocIndex, "resultset", 2,3);
		
		dao.executeProcedureByPosition(nprocIndex);
		strErr = dao.getString(nprocIndex, "err");
		
		if (strErr == null)
			strErr = "";
		ws = dao.getWebRowSet(nprocIndex, "resultset");
		vo.setGblWs3(ws);
	} 
	catch (Exception e) 
	{
		vo.setStrMsgString("OnlineClientDetails.getRelations() --> "+ e.getMessage());
		vo.setStrMsgType("1");
	} 
	finally 
	{
		if (dao != null) 
		{
			dao.free();
			dao = null;
		}
	}
	//return ws;
}

public void getCreditLetterTypes(BillingVO voObj)
{
	HisDAO daoObj = null;
	WebRowSet ws = null;

	String strProcName = "{call pkg_bill_view.proc_hrgt_credit_letter_type_sys(?,?,?,?)}";
	int nProcIndex = 0;

	//String strHospitalCode = pageContext.getSession().getAttribute("HOSPITAL_CODE").toString();

	String strErr = "";

	try 
	{
		daoObj = new HisDAO("Billing","OnlineClientDetails");
		nProcIndex = daoObj.setProcedure(strProcName);
		daoObj.setProcInValue(nProcIndex, "modeval", "1",1);
		daoObj.setProcInValue(nProcIndex, "hosp_code", BillConfigUtil.SUPER_HOSPITAL_CODE,2);
		daoObj.setProcOutValue(nProcIndex, "err", 1,3);
		daoObj.setProcOutValue(nProcIndex, "RESULTSET", 2,4);
		daoObj.executeProcedureByPosition(nProcIndex);

		strErr = daoObj.getString(nProcIndex, "err");

		if (strErr == null)
			strErr = "";

		if (strErr.equals("")) 
		{
			ws = daoObj.getWebRowSet(nProcIndex, "RESULTSET");
			voObj.setGblWs4(ws);
		} 
		else 
		{
			throw new Exception(strErr);
		}
	}	
	catch (Exception e) 
	{
		voObj.setStrMsgString("OnlineClientDetails.getCreditLetterTypes() --> "+ e.getMessage());
		voObj.setStrMsgType("1");
	} 
	finally 
	{
		if (daoObj != null) 
		{
			daoObj.free();
			daoObj = null;
		}
	}
}


}
