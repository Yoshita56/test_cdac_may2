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
<title>Dossier Item Brand Master View</title>
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

<script type="text/javascript">
	</script>
</head>
<%-- <body onload="chkItemSachet();"> --%>
<body>
<html:form action="/masters/DossierItemBrandMstCNT" name="DossierItemBrandMasterBean"
		type="dossier.masters.controller.fb.DossierItemBrandMstFB">

	<center>
	<div class="errMsg" id="errMsgId">
		<bean:write name="DossierItemBrandMasterBean" property="strErrMssgstring" />
	</div>
	<div class="warningMsg" id="warningMsgId">
		<bean:write name="DossierItemBrandMasterBean" property="strWarnMssgstring" />
	</div>
	<div class="normalMsg" id="normalMsg">
		 <bean:write name="DossierItemBrandMasterBean" property="strNormMssgstring" />
	</div>
	<tag:tab tabLabel="Item Master" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">

	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4">Dossier Item Brand Master&gt;&gt; View</td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<td colspan="2" class="LABEL" width="45%">Item Kit Name</td>
			<td colspan="2" class="CONTROL" width="45%">
				<bean:write name="DossierItemBrandMasterBean" property="strItemKitName" filter="false" />
			</td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL" width="45%">Item Kit Description</td>
			<td colspan="2" class="CONTROL" width="45%">
				<bean:write name="DossierItemBrandMasterBean" property="strItemKitDescription" filter="false" />
			</td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL" width="45%">Item Kit Rate(per day)</td>
			<td colspan="2" class="CONTROL" width="45%">
				<bean:write name="DossierItemBrandMasterBean" property="strItemKitRate" filter="false" />
			</td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL" width="45%">Department Name</td>
			<td colspan="2" class="CONTROL" width="45%">
				<bean:write name="DossierItemBrandMasterBean" property="strDeptName" filter="false" />
			</td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL" width="45%">Billing Mode</td>
			<td colspan="2" class="CONTROL" width="45%">
				<bean:write name="DossierItemBrandMasterBean" property="strBillingMode" filter="false" />
			</td>
		</tr>
		<%-- 
		<tr>
			<td colspan="2" class="LABEL" width="45%">Effective From</td>
			<td colspan="2" class="CONTROL" width="45%">
				<bean:write name="DossierItemBrandMasterBean" property="strEffectiveFrom" filter="false" />
			</td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL" width="45%">Record Status</td>
			<td colspan="2" class="CONTROL" width="45%">
				<bean:write name="DossierItemBrandMasterBean" property="strIsValid" filter="false" />
			</td>
		</tr> 
		--%>
	</table>
	
	<table class="TABLEWIDTH" align="center" cellspacing="0px">
		<tr class="HEADER">
			<td colspan="4">Item List</td>
		</tr>
	</table>
	
	<bean:write name="DossierItemBrandMasterBean" property="strItemDataDiv" filter="false" />
	
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

			<td align="center" colspan="2" width="25%">
				<img src="../../hisglobal/images/close_tab.png" onClick="window.close();"
				style="cursor: pointer;" title="Cancel Process">
			</td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" value="${DossierItemBrandMasterBean.strChk}" name="strChk" />
	<input type="hidden" value="${DossierItemBrandMasterBean.strItemCatName}" name="ItemCatName" />
	<input type="hidden" value="${DossierItemBrandMasterBean.strGroupName}" name="GroupName" />
	<input type="hidden" value="${DossierItemBrandMasterBean.strItemName}" name="ItemName" />
	<input type="hidden" name="comboValue" value="${DossierItemBrandMasterBean.strComboValues}" />
	<cmbPers:cmbPers />

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>