<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<%-- 
/**
 * @author Vivek Aggarwal
 * Date of Creation : 1-June-2011
 * Date of Modification :  3-June-2011 
 * Version : 
 * Module  : DWH
 */
 --%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>State Master Modify Page</title>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>

<script language="Javascript" src="../../mms/js/dwh_state_mst.js"></script>
</head>



<body>
<html:form name="stateMstBean" action="/masters/StateMstCNT" type="mms.masters.controller.fb.StateMstFB">

	<div id="strErrMsg" class="errMsg"><bean:write name="stateMstBean" property="strErrMsg" /></div>
	<div class="warningMsg"><bean:write name="stateMstBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="stateMstBean" property="strNormalMsg" /></div>

	<tag:tab tabLabel="State Master" selectedTab="FIRST" align="center" width="TABLEWIDTH" onlyTabIndexing="1">
	</tag:tab>

	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="2">State Master&gt;&gt;Modify</td>
		</tr>
		
<!-- Country -->
		<tr>
			<td class="LABEL"><font color="red">*</font>Country</td>
			<td width="50%" class="CONTROL">
				<input type="text" name="strCountryName" disabled="disabled" value="${stateMstBean.strCountryName}" maxlength="250" onkeypress="return validateData(event,18);">
			</td>
		</tr>

<!-- State Name-->
		<tr>
			<td class="LABEL"><font color="red">*</font>State Name</td>
			<td width="50%" class="CONTROL">
				<input type="text" name="strStateName" value="${stateMstBean.strStateName}" maxlength="40" onkeypress="return validateData(event,18);">
			</td>
		</tr>
		
<!-- State Short Name-->
		<tr>
			<td class="LABEL"><font color="red">*</font>State Short Name</td>
			<td width="50%" class="CONTROL">
			<input type="text"	name="strStateShortName" value="${stateMstBean.strStateShortName}" maxlength="3" onkeypress="return validateData(event,18);"></td>
		</tr>

<!-- Record Status -->
		
			<tr>
				<td class="LABEL"><font color="red">*</font>Record Status</td>
	
				<td class="CONTROL" colspan="2">
					<html:radio name="stateMstBean" property="strIsValid" value="1">Active</html:radio>
	    			<html:radio name="stateMstBean" property="strIsValid" value="2">Inactive</html:radio>
				</td>
			</tr>
		
		
			<tr class="FOOTER">
				<td colspan="2"><font size="2" color="red">*</font> Mandatory Fields</td>
			</tr>
	</table>

	<table CLASS="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td align="center">
				<img src="../../hisglobal/images/btn-sv.png" style="cursor: pointer;" title="Save Record" onClick="validate1('Modify');" />
				<img src="../../hisglobal/images/btn-clr.png" style="cursor: pointer;" title="Reset Content" onClick="document.forms[0].reset(),clearMsg('MODIFY')" ;/> 
				<img src="../../hisglobal/images/btn-ccl.png" style="cursor: pointer;" title="Cancel Process" onClick="cancel('LIST');" />
			</td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />

	<input type="hidden" name="chk" value="${stateMstBean.chk[0] }">
	<input type="hidden" name="comboValue" value="${stateMstBean.strStateName}">
	

	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>
