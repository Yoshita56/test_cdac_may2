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
<title>Dossier Item Master</title>
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
<html:form action="/masters/DossierItemMstCNT" name="DossierItemMasterBean"
	type="dossier.masters.controller.fb.DossierItemMstFB">

	<center>
	<div class="errMsg" id="errMsgId">
		<bean:write name="DossierItemMasterBean" property="strErr" />
	</div>
	<div class="warningMsg" id="warningMsgId">
		<bean:write name="DossierItemMasterBean" property="strWarning" />
	</div>
	<div class="normalMsg" id="normalMsg">
		 <bean:write name="DossierItemMasterBean" property="strMsg" />
	</div>
	<tag:tab tabLabel="Dossier Item Master" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">

	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4">Dossier Item Master&gt;&gt; View</td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<td colspan="2" class="LABEL" width="45%">Dossier Name</td>
			<td colspan="2" class="CONTROL" width="45%">
				<bean:write name="DossierItemMasterBean" property="strDossierName" filter="false" />
			</td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL" width="45%">Service Type Name</td>
			<td colspan="2" class="CONTROL" width="45%">
				<bean:write name="DossierItemMasterBean" property="strServiceTypeName" filter="false" />
			</td>
		</tr>
		<tr style="display:none;">
			<td colspan="2" class="LABEL" width="45%">Store Name</td>
			<td colspan="2" class="CONTROL" width="45%">
				<bean:write name="DossierItemMasterBean" property="strStoreName" filter="false" />
			</td>
		</tr>
		<%-- 
		<tr>
			<td colspan="2" class="LABEL" width="45%">Effective From</td>
			<td colspan="2" class="CONTROL" width="45%">
				<bean:write name="DossierItemMasterBean" property="strEffectiveFrom" filter="false" />
			</td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL" width="45%">Record Status</td>
			<td colspan="2" class="CONTROL" width="45%">
				<bean:write name="DossierItemMasterBean" property="strIsValid" filter="false" />
			</td>
		</tr>
		 --%>
	 </table>
	 <table class="TABLEWIDTH" align="center" cellspacing="0px">
		<tr class="HEADER">
			<td colspan="4">Item List</td>
		</tr>
	</table>
	
	<bean:write name="DossierItemMasterBean" property="strItemDataDiv" filter="false" />
	
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
	<input type="hidden" value="${DossierItemMasterBean.strChk1}" name="strChk" />
	
	<cmbPers:cmbPers />

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>