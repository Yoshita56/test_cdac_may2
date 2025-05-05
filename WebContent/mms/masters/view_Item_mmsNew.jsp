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
<title>Item Master View</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>

<script type="text/javascript">
	/*
	function chkItemSachet(){
		
		
		if(document.getElementsByName('strSparePartFlag')[0].value == 1){
		
		
			document.getElementsByName('strSparePartFlag')[0].checked = true;
		
		}
		
		if(document.getElementsByName('strSetSachetFlag')[0].value == 1){
		
			document.getElementsByName('strSetSachetFlag')[0].checked = true;
		
		}
		if(document.getElementsByName('strIsQuantified')[0].value == 1){
		
			document.getElementsByName('strIsQuantified')[0].checked = true;
		
		}
		
	}

	
	function setIsItemSachet()
	{
		
		if(document.forms[0].strSetSachetFlag.checked)
		{
			document.forms[0].strSetSachetFlag.value="1";
		}
		else
		{
			document.forms[0].strSetSachetFlag.value="0";
		}
		
	}
		
	function setIsQuantifiable()
	{
		if(document.forms[0].strIsQuantified.checked)
		{
			document.forms[0].strIsQuantified.value="1";
		}
		else
		{
			document.forms[0].strIsQuantified.value="0";
		}
	}
	
	function setSparePart()
	{
		if(document.forms[0].strSparePartFlag.checked)
		{
			document.forms[0].strSparePartFlag.value="1";
		}
		else
		{
			document.forms[0].strSparePartFlag.value="0";
		}
	}
	 */
</script>
</head>
<%-- <body onload="chkItemSachet();"> --%>
<body>
<html:form action="/masters/ItemMstBSCNT" name="itemBean"
	type="mms.masters.controller.fb.ItemMstFB" ENCTYPE="multipart/form-data">


	<center>
	<div class="errMsg" id="errMsgId"><bean:write name="itemBean"
		property="strErrMssgstring" /></div>
	<div class="warningMsg" id="warningMsgId"><bean:write
		name="itemBean" property="strWarnMssgstring" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="itemBean"
		property="strNormMssgstring" /></div>
	<tag:tab tabLabel="Item Master" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">

	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4">Item Master&gt;&gt; View</td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<td width="25%" class="LABEL">Item Category</td>
			<td width="25%" class="CONTROL"><bean:write name="itemBean"
				property="strItemCatName" filter="false" /></td>

			<td width="25%" class="LABEL">Group Name</td>
			<td width="25%" class="CONTROL"><bean:write name="itemBean"
				property="strGroupName" filter="false" /></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Generic Item</td>
			<td width="25%" class="CONTROL"><bean:write name="itemBean"
				property="strGenItemName" filter="false" /></td>
			<td width="25%" class="LABEL"><%-- Item Type --%>Record Status</td>
			<td width="25%" class="CONTROL"><bean:write name="itemBean"
				property="strIsValid" filter="false" /></td>
		</tr>

		<tr>
			<td class="LABEL" width="25%" colspan="1">Item Type</td>
			<td class="CONTROL" width="25%" colspan="1"><bean:write
				name="itemBean" property="strItemTypeName" filter="false" /></td>
			<td class="LABEL" width="25%" colspan="1">Item Name</td>
			<td class="CONTROL" width="25%" colspan="1"><bean:write
				name="itemBean" property="strItemName" filter="false" /></td>
		</tr>
		<tr>
			<td class="LABEL">Item Class</td>
			<td class="CONTROL"><bean:write name="itemBean"
				property="strBrandReserveStatus" filter="false" /></td>
			<td class="LABEL">Manufacturer</td>
			<td class="CONTROL"><bean:write name="itemBean"
				property="strManufacturerName" filter="false" /></td>

		</tr>
		<tr>
			<td class="LABEL" width="25%" colspan="1">Rate</td>
			<td class="CONTROL" width="25%" colspan="1"><bean:write
				name="itemBean" property="strDefaultRate" filter="false" /></td>
			<td class="LABEL" width="25%" colspan="1">Rate Unit</td>
			<td class="CONTROL" width="25%" colspan="1"><bean:write
				name="itemBean" property="strRateUnitName" filter="false" /></td>
		</tr>
		
		<tr>
			<td class="LABEL" width="25%" colspan="1">Item Code</td>
			<td class="CONTROL" width="25%" colspan="3"><bean:write
				name="itemBean" property="strCPACode" filter="false" /></td>
			
		</tr>

		<tr class="HEADER">
			<td colspan="4">Item Parameter</td>
		</tr>

		<tr>
			<td class="LABEL" width="25%">Approved Type</td>
			<td class="CONTROL" width="25%"><bean:write name="itemBean"
				property="strApprovedTypeName" /></td>

			<td class="LABEL" width="25%">Issue Type</td>
			<td class="CONTROL" width="25%"><bean:write name="itemBean"
				property="strIssueType" />
		</tr>
		<tr>
			<td class="LABEL" width="25%">Item Make</td>
			<td class="CONTROL" width="25%"><bean:write name="itemBean"
				property="strItemMake" /></td>
			<td class="LABEL">Item is SparePart</td>
			<td class="CONTROL"><bean:write name="itemBean"
				property="strSparePartFlag" /></td>
		</tr>
		<tr>
			<td class="LABEL">Item is Set-Sachet</td>
			<td class="CONTROL"><bean:write name="itemBean"
				property="strSetSachetFlag" /></td>

			<td class="LABEL">Whether Item is Quantified</td>
			<td class="CONTROL"><bean:write name="itemBean"
				property="strIsQuantified" /></td>
		</tr>


		<tr>
			<td class="LABEL" colspan="2">Specification</td>
			<td class="CONTROL" colspan="2"><bean:write name="itemBean"
				property="strSpecification" /></td>
		</tr>

		<tr>
			<td class="LABEL" colspan="2">Effective From</td>
			<td class="CONTROL" colspan="2"><bean:write name="itemBean"
				property="strEffectiveFrom" filter="false" /></td>
		</tr>

		<tr>
			<td colspan="2" class="LABEL">Record Status</td>
			<td colspan="2" class="CONTROL"><bean:write name="itemBean"
				property="strIsValid" filter="false" /></td>
		</tr>

		<tr class="FOOTER">
			<td colspan="4" width="25%"></td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">

		<tr>

			<td align="center" colspan="2" width="25%">
			<!-- <img
				src="../../hisglobal/images/close_tab.png" onClick="window.close();"
				style="cursor: pointer;" title="Cancel Process"> -->
				<br>
				<a href="#" class="button" onclick="window.close();"><span class="cancel">Cancel</span></a>
				</td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" value="${itemBean.strChk}" name="strChk" />
	<input type="hidden" value="${itemBean.strItemCatName}"
		name="ItemCatName" />
	<input type="hidden" value="${itemBean.strGroupName}" name="GroupName" />
	<input type="hidden" value="${itemBean.strGenItemName}"
		name="GenItemName" />
	<input type="hidden" name="comboValue"
		value="${itemBean.strComboValues}" />
	<cmbPers:cmbPers />

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>