<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset="utf-8">
<title>Dossier Master</title>
<link href="/INVMGM/mms/css/master.css" rel="stylesheet" type="text/css">
<link href="/INVMGM/hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="/INVMGM/hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="/INVMGM/dossier/masters/DossierMaster.js"></script>

<script type="text/javascript">

</script>
</head>
<%-- <body onload="chkItemSachet();"> --%>
<body>
<html:form action="/masters/DossierMstCNT" name="DossierMasterBean"
	type="dossier.masters.controller.fb.DossierMstFB">

	<center>
	<div class="errMsg" id="errMsgId">
		<bean:write name="DossierMasterBean" property="strErrMssgstring" />
	</div>
	<div class="warningMsg" id="warningMsgId">
		<bean:write name="DossierMasterBean" property="strWarnMssgstring" />
	</div>
	<div class="normalMsg" id="normalMsg">
		 <bean:write name="DossierMasterBean" property="strNormMssgstring" />
	</div>
	<tag:tab tabLabel="Item Master" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">

	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4">Dossier Master&gt;&gt; View</td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<td colspan="2" class="LABEL" width="45%">Dossier Name</td>
			<td colspan="2" class="CONTROL" width="45%">
				<bean:write name="DossierMasterBean" property="strDossierName" filter="false" />
			</td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL" width="45%">Dossier Description</td>
			<td colspan="2" class="CONTROL" width="45%">
				<bean:write name="DossierMasterBean" property="strDossierDescription" filter="false" />
			</td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL" width="45%">Service Type Name</td>
			<td colspan="2" class="CONTROL" width="45%">
				<bean:write name="DossierMasterBean" property="strServiceTypeName" filter="false" />
			</td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL" width="45%">Dossier Total Cost</td>
			<td colspan="2" class="CONTROL" width="45%">
				<bean:write name="DossierMasterBean" property="strDossierTotalCost" filter="false" />
			</td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL" width="45%">Effective From</td>
			<td colspan="2" class="CONTROL" width="45%">
				<bean:write name="DossierMasterBean" property="strCurrentDate" filter="false" />
			</td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL" width="45%">Billing Mode</td>
			<td colspan="2" class="CONTROL" width="45%">
				<bean:write name="DossierMasterBean" property="strBillingMode" filter="false" />
			</td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL" width="45%">Record Status</td>
			<td colspan="2" class="CONTROL" width="45%">
				<bean:write name="DossierMasterBean" property="strIsValid" filter="false" />
			</td>
		</tr>
	</table>
	 <table class="TABLEWIDTH" align="center" cellspacing="0px">
		<tr class="HEADER">
			<td colspan="4">Department Mapped With Dossier</td>
		</tr>
	</table>
	
	<bean:write name="DossierMasterBean" property="strDeptDataDiv" filter="false" />
	
	<table cellspacing="0px" class="TABLEWIDTH" align="center" cellpadding="0px">
		<tr>
			<td colspan="5" bgcolor=""></td>
		</tr>
		<tr class="FOOTER">
			<td colspan="5"></td>
		</tr>
	</table>
	
	
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">

		<tr>
			<td colspan="2" width="50%" align="right">
				<a href="#" class="button" id="" onclick="window.print();" tabindex="1"><span class="print">Print</span></a>
			</td>
			<td align="left" colspan="2" width="50%">
				<img src="../../hisglobal/images/close_tab.png" onClick="window.close();"
				style="cursor: pointer;" title="Cancel Process">
			</td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" value="${DossierMasterBean.strChk}" name="strChk" />
	<input type="hidden" value="${DossierMasterBean.strDepartmentName}" name="strDepartmentName" />
	<input type="hidden" value="${DossierMasterBean.strServiceTypeName}" name="strServiceTypeName" />
	<cmbPers:cmbPers />

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>