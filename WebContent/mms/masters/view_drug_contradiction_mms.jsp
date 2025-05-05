<%-- 
author 				: Niharika Srivastava
Date of Creation 	: 25-08-10
Process 			: Drug Contradiction Master
Module 				: MMS
TL 					: Mr. Ajay Kumar Gupta
Description			: View Page For Drug Contradiction master.  
 --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset="utf-8">
<title>Drug Contradiction Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
</head>
<body>
<html:form name="DrugContradictionBean"
	action="/masters/DrugContradictionMstCNT"
	type="mms.masters.controller.fb.DrugContradictionMstFB">
	<center>
	<div id="errMsg" class="errMsg"><bean:write
		name="DrugContradictionBean" property="strErr" /></div>
	<div class="warningMsg"><bean:write name="DrugContradictionBean"
		property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="DrugContradictionBean" property="strMsg" /></div>


	<tag:tab tabLabel="Drug Contradiction Master" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab></center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">

		<tr class="HEADER">
			<td colspan="2">Drug Contradiction Master &gt;&gt; View</td>
		</tr>

		<tr>
			<td class="LABEL">Drug Name</td>
			<td width="50%" class="CONTROL"><bean:write
				name="DrugContradictionBean" property="strDrugName" filter="false" /></td>

		</tr>
		<tr>
			<td colspan="4" class="TITLE">Contradicted Drugs</td>
		</tr>
		<tr>
			<td colspan="4" class="multiControl"><bean:write
				name="DrugContradictionBean" property="strContraDrugs"
				filter="false" /></td>
		</tr>
		<tr>
			<td class="LABEL" width="50%">Effective From</td>
			<td class="CONTROL"><bean:write name="DrugContradictionBean"
				property="strEffectiveFrom" filter="false" /></td>
		</tr>
		<tr>
			<td width="50%" class="LABEL" valign="top">Remarks</td>
			<td width="50%" class="CONTROL"><textarea name="strRemarks"
				cols="25" rows="2" disabled="disabled"><bean:write
				name="DrugContradictionBean" property="strRemarks" /></textarea></td>
		</tr>
		<tr>
			<td width="45%" class="LABEL">Record Status</td>
			<td width="45%" class="CONTROL"><bean:write
				name="DrugContradictionBean" property="strIsValid" filter="false" />

			</td>
		</tr>
		<tr class="FOOTER">
			<td colspan="2">&nbsp;</td>
		</tr>
	</table>

	<center><!-- <img src="../../hisglobal/images/btn-ccl.png"
		style="cursor: pointer" onClick="window.close();" />--><a href="#" class="button" onclick="window.close();"><span class="cancel">Cancel</span></a></center>

	<input type="hidden" name="chk" value="${DrugContradictionBean.chk}">
	<input type="hidden" name="hmode">
</html:form>
</body>
</html>