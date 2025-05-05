<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=utf-8>
<title>Indent Type Master Add Page</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>

<script language="javaScript">

function validate1(){   
     
      var hisValidator = new HISValidator("IndentTypeBean");
              
			
            hisValidator.addValidation("strIndentTypeName", "req", "Indent Type Name is a Mandatory Field" );
            hisValidator.addValidation("strIndentTypeTime", "req", "Indent period is a Mandatory Field" );
           hisValidator.addValidation("strEffectiveFrom", "req", "Effective from is a Mandatory Field" ); 
           // 	hisValidator.addValidation("strEffectiveFrom", "dtgtet=${IndentTypeBean.strCtDate}" , "Effective From Date should be Greater than or Equal to Current Date");
			hisValidator.addValidation("strIndentTypeName", "maxlen=50", "Indent Type Name should have less than or equal to 50 Characters" );
			hisValidator.addValidation("strIndentTypeTime", "maxlen=3", "Time should have less than or equal to 3 Characters" );           	
			hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );



			
                     
            var retVal = hisValidator.validate(); 
    
    		if(retVal)
    		{
    		var time = parseInt(document.forms[0].strIndentTypeTime.value);
    		if(time>356)
    		{
    		alert('Time cannot be greater than 356');
    		retVal = false;
    		}
    		}
          if(retVal){
                      
      				   document.forms[0].hmode.value = "SAVE";
                        document.forms[0].submit();
            }else{

           return false;

          }
    }

</script>

</head>
<body onLoad="document.forms[0].strIndentTypeName.focus();">
<html:form name="IndentTypeBean" action="/masters/IndentTypeMstCNT"
	type="mms.masters.controller.fb.IndentTypeMstFB">
 <center>
	<div class="errMsg"><bean:write name="IndentTypeBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="IndentTypeBean"
		property="strWarning" /></div>
	<div id="normalMsg"  class="normalMsg"><bean:write name="IndentTypeBean"
		property="strMsg" /></div>

	<tag:tab tabLabel="Indent Type Master"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
			 </center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="2">Indent Type Master &gt;&gt; Add</td>
		</tr>


		<tr>
			<td class="LABEL">Store Type Name</td>
			<td width="50%" class="CONTROL"><bean:write
				name="IndentTypeBean" property="strStoreTypeName" filter="false" />

			</td>

		</tr>

		<tr>
			<td class="LABEL"><font color="red">*
			</font>Indent Type Name</td>
			<td width="50%" class="CONTROL"><input type="text"
				name="strIndentTypeName" maxlength="50" value=""
				onkeypress="return validateData(event,9);"></td>
		</tr>

		<tr>
			<td class="LABEL"><font color="red">*</font>Indent Type Time</td>
			<td width="50%" class="CONTROL"><input type="text"
				class="txtFldSmall" maxlength="3" name="strIndentTypeTime" value=""
				onkeypress="return validateData(event,5);"> (Enter 0 (zero) to raise Indent
			at Any Time)</td>
		</tr>
		<tr>
			<td class="LABEL"><font color="red">*</font>Indent Type Time
			Unit</td>
			<td width="50%" class="CONTROL"><select
				name="strIndentTypeTimeUnit">
				<option value="0">Day</option>
				<option value="1">Month</option>
				<option value="2">Year</option>
			</select></td>
		</tr>

		<tr>
			<td class="LABEL" width="50%">
			<div align="right"><font
				color="red">*</font> Effective From</div>
			</td>
			<td class="CONTROL"><dateTag:date name="strEffectiveFrom"
				value="${IndentTypeBean.strCtDate}"></dateTag:date></td>
		</tr>


		<tr>
			<td width="50%" class="LABEL" valign="top">Remarks if Any</td>
			<td width="50%" class="CONTROL"><textarea name="strRemarks"
				cols="25" rows="2"></textarea></td>
		</tr>


		<tr class="FOOTER">
			<td colspan="2"><font color="red">*</font>Mandatory
			Field</td>
		</tr>

		
	</table>

	
	<div align="center">
	<table CLASS="TABLEWIDTH">
		<tr>
			<td align="center"><img
				src="../../hisglobal/images/btn-sv.png"
				style="cursor: pointer; " title="Save Record"
				onClick=" return validate1();" /> <img
				src="../../hisglobal/images/btn-clr.png"
				style="cursor: pointer; " title="Reset Content"
				onClick="document.forms[0].reset(),document.forms[0].strIndentTypeName.focus();" /> <img
				src="../../hisglobal/images/btn-ccl.png"
				style="cursor: pointer; " title="Cancel Process"
				onClick="cancel('LIST');" /></td>
		</tr>
	</table>

	<input type="hidden" name="hmode"> <input type="hidden"
		name="strHospitalCode" value="${IndentTypeBean.strHospitalCode}">
	<input type="hidden" name="strStoreTypeId"
		value="${IndentTypeBean.combo[0]}"> 
	<input type="hidden" name="comboValue"
		value="${IndentTypeBean.strStoreTypeName}"></div>
	<cmbPers:cmbPers />
</html:form>

<tag:autoIndex></tag:autoIndex>
</body>
</html>

