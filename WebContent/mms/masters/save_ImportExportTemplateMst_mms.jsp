<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset="utf-8">
<title>Import Export Template Master</title>
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
     
            var hisValidator = new HISValidator("impexpTemplateMstBean");
            
          	  hisValidator.addValidation("strTemplate", "req", "Template Name is a Mandatory Field" );
          	                  
            var retVal = hisValidator.validate(); 

          if(retVal){
                 	   document.forms[0].hmode.value = "SAVEMAPPING";
                       document.forms[0].submit();
          }else{
             return false;
          }
}


function cancelPage(mode){
	
		document.forms[0].hmode.value = mode;
		document.forms[0].submit();
}

</script>
</head>
<body>
<html:form name="impexpTemplateMstBean"
	action="/masters/ImportExportTemplateMstCNT"
	type="mms.masters.controller.fb.ImportExportTemplateMstFB"  method="post" >

	<div id="errMsg" class="errMsg"><bean:write
		name="impexpTemplateMstBean" property="strErrorMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="impexpTemplateMstBean" property="strMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="impexpTemplateMstBean" property="strWarning" /></div>


	<tag:tab tabLabel="Import Export Template Master" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="2">Import Export Template Master&gt;&gt; Mapping</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Template
			Name</td>
			<td width="50%" class="CONTROL"><input type="text"
				size="75" name="strTemplate"
				onkeypress="return validateData(event,9);"></td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">Template Type</td>
			<td width="50%" class="CONTROL"><logic:equal
				name="impexpTemplateMstBean" property="strTemplateType" value="1">Import</logic:equal>
			<logic:equal name="impexpTemplateMstBean" property="strTemplateType"
				value="2">Export</logic:equal></td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">Procedure Name</td>
			<td width="50%" class="CONTROL"><bean:write
				name="impexpTemplateMstBean" property="strProcedure" filter="false" />
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">Excel File</td>
			<td class="CONTROL"><logic:empty name="impexpTemplateMstBean"
				property="strExcelFilePathName">---</logic:empty> <logic:notEmpty
				name="impexpTemplateMstBean" property="strExcelFilePathName">
				<bean:write name="impexpTemplateMstBean" property="strExcelFilePathName"
					filter="false" />
			</logic:notEmpty>
			
			
			</td>
		</tr>

	</table>

	<bean:write name="impexpTemplateMstBean" property="strMappingContents"
		filter="false" />

	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">

		<tr class="FOOTER">
			<td colspan="2"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>

			<td align="center"><img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" title="Save Record"
				onClick=" return validate1();" />  <img
				style="cursor: pointer; "
				src="../../hisglobal/images/btn-ccl.png" title="Cancel Process"
				onClick="cancelPage('CANCELPAGE');" /></td>
		</tr>
	</table>

	<input type="hidden" name="hmode" />
	<input type="hidden" name="strProcedure"
		value="${impexpTemplateMstBean.strProcedure }" />
	<input type="hidden" name="strExcelFilePathName" value="${impexpTemplateMstBean.strExcelFilePathName }"/>
	<input type="hidden" name="strTemplateType"
		value="${impexpTemplateMstBean.strTemplateType }" />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>