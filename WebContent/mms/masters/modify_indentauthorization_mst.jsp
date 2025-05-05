<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset="utf-8">
<title>Indent Authorization Master</title>
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
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="javaScript">



function validate1(){   
     
            var hisValidator = new HISValidator("indentAuthorizationBean");
            hisValidator.addValidation("strEmpId", "dontselect=0", "Please select a value from Employee Name" );
            hisValidator.addValidation("strLevel", "dontselect=0", "Please select a value from Level" );
            hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
            hisValidator.addValidation("strEffectiveFrom", "date","Effective From is a mandatory field");
		   // 	hisValidator.addValidation("strEffectiveFrom", "dtgtet=${indentAuthorizationBean.strCtDate}" , "Effective From should be Greater than or Equal to Current Date");
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
<body>
<html:form name="indentAuthorizationBean"
	action="/masters/IndentAuthorizationMstCNT"
	type="mms.masters.controller.fb.IndentAuthorizationMstFB">

	<div id="errMsg" class="errMsg"><bean:write
		name="indentAuthorizationBean" property="strErr" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="indentAuthorizationBean" property="strMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="indentAuthorizationBean" property="strWarning" /></div>


	<table class="TABLEWIDTH" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td width="100%"><tag:tab tabLabel="Indent Authorization Master"
				selectedTab="FIRST" align="center" width="100%">
			</tag:tab></td>
		</tr>
	</table>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4">Indent Authorization Master&gt;&gt; Modify</td>
		</tr>

		<tr>
			<td width="50%" class="LABEL">Drug Warehouse Name</td>
			<td width="50%" class="CONTROL"><bean:write
				name="indentAuthorizationBean" property="strStoreName"
				filter="false" />
		</tr>

		<tr>
			<td width="50%" class="LABEL">Drug Category Name</td>
			<td width="50%" class="CONTROL"><bean:write
				name="indentAuthorizationBean" property="strItemCategoryName"
				filter="false" /></td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">Authorization For</td>
			<td width="50%" class="CONTROL"><bean:write
				name="indentAuthorizationBean" property="strAuthorizationForName"
				filter="false" /></td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">Type</td>
			<td width="50%" class="CONTROL"><bean:write
				name="indentAuthorizationBean" property="strType" filter="false" />
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Authorization
			No Level</td>
			<td width="50%" class="CONTROL"><bean:write
				name="indentAuthorizationBean" property="strAuthorizationNo"
				filter="false" /></td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">Employee Name</td>
			<td width="50%" class="CONTROL"><html:select
				name="indentAuthorizationBean" property="strEmployeeId">
				<bean:write name="indentAuthorizationBean"
					property="strEmployeeNameValues" filter="false" />
			</html:select></td>

		</tr>
		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Level</td>
			<td width="50%" class="CONTROL"><html:select
				name="indentAuthorizationBean" property="strLevel1">
				<html:option value="1">1</html:option>
				<html:option value="2">2</html:option>
				<html:option value="3">3</html:option>
				<html:option value="4">4</html:option>
				<html:option value="5">5</html:option>
				<html:option value="6">6</html:option>
				<html:option value="7">7</html:option>
				<html:option value="8">8</html:option>
				<html:option value="9">9</html:option>
				<html:option value="10">10</html:option>

			</html:select></td>
		</tr>

		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Effective
			From</td>
			<td class="CONTROL"><date:date name="strEffectiveFrom"
				value="${indentAuthorizationBean.strEffectiveFrom}"></date:date></td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">Remarks</td>
			<td width="50%" class="CONTROL">
			<div align="left"><textarea name="strRemarks" cols="25"
				rows="2"><bean:write name="indentAuthorizationBean"
				property="strRemarks" /></textarea></div>
			</td>
		</tr>
		<tr>
			<td width="45%" class="LABEL">Record Status</td>
			<td width="45%" class="CONTROL"><html:radio
				name="indentAuthorizationBean" property="strIsValid" value="1">Active</html:radio>
			<html:radio name="indentAuthorizationBean" property="strIsValid"
				value="2">Inactive</html:radio></td>
		</tr>
		<tr class="FOOTER">
			<td colspan="8"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>

	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>

			<td align="center"><img style="cursor: pointer;"
				src="../../hisglobal/images/btn-sv.png" title="Save Record"
				onClick=" return validate1();" /> <img style="cursor: pointer;"
				src="../../hisglobal/images/btn-ccl.png" title="Cancel Process"
				onClick="cancel('LIST');" /></td>
		</tr>
	</table>


	<input type="hidden" name="hmode" />
	<input type="hidden" name="comboValue"
		value="${indentAuthorizationBean.strComboValue}" />
	<input type="hidden" name="indexId" />
	<input type="hidden" name="chk"
		value="${indentAuthorizationBean.strChk1 }">
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>