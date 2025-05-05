<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset="utf-8">
<title>Purpose Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="javaScript">

function validate1(){   
     
            var hisValidator = new HISValidator("purposeBean");
            hisValidator.addValidation("strPurpose", "req", "Purpose is a Mandatory Field" );
            hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
            //hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
		
            var retVal = hisValidator.validate(); 

          if(retVal){
                 	   document.forms[0].hmode.value = "UPDATE";
                       document.forms[0].submit();
          }else{
             return false;
          }
}


</script>
</head>
<body onLoad="document.forms[0].strPurpose.focus();">
<html:form name="purposeBean" action="/masters/PurposeMstCNT"
	type="mms.masters.controller.fb.PurposeMstFB">

<center>
	<div class="errMsg"><bean:write name="purposeBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="purposeBean"
		property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="purposeBean" property="strMsg" /></div>


	<tag:tab tabLabel="Purpose Master"
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="2">Purpose Master&gt;&gt; Modify</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Purpose</td>
			<td width="50%" class="CONTROL"><input type="text"
				name="strPurpose" class="txtFldMax"
				maxlength="50" value="${purposeBean.strPurpose}">
			</td>
		</tr>



		<tr>
			<td class="LABEL" width="50%"><font color="red">*</font>Effective
			From</td>
			<td class="CONTROL"><bean:write name="purposeBean" property="strEffectiveFrom" /></td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">Remarks</td>
			<td width="50%" class="CONTROL">
			<div align="left"><textarea name="strRemarks" rows="2"><bean:write
				name="purposeBean" property="strRemarks" /></textarea></div>
			</td>
		</tr>
		<tr>
			<td width="45%" class="LABEL">Record Status</td>
			<td width="45%" class="CONTROL"><html:radio
				name="purposeBean" property="strIsValid" value="1">Active</html:radio>
			<html:radio name="purposeBean" property="strIsValid" value="2">Inactive</html:radio>

			</td>
		</tr>



		<tr class="FOOTER">
			<td colspan="2"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>

			<td align="center"><img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" title="Save Record" onClick="validate1();" />
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-ccl.png" title="Cancel Process"
				onClick="cancel('LIST');" /></td>
		</tr>
	</table>
	<input type="hidden" name="chk" value="${purposeBean.chk[0] }">
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strEffectiveFrom"
				value="${purposeBean.strEffectiveFrom}">
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>

</body>
</html>