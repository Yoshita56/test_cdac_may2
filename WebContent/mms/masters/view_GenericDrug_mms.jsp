<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset="utf-8">
<title>Generic Drug</title>
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

<script type="text/javascript">
	
	
	function closeView()
	{
		window.close();
	}
</script>
</head>
<body onload="">
<html:form action="/masters/GenericDrugMstCNT" name="genericdrugBean"
	type="mms.masters.controller.fb.GenericDrugMstFB">


	<center>
	<div class="errMsg" id="errMsgId"><bean:write
		name="genericdrugBean" property="strErrMssgstring" /></div>
	<div class="warningMsg" id="warningMsgId"><bean:write
		name="genericdrugBean" property="strWarnMssgstring" /></div>
	<div class="normalMsg" id="normalMsgId"><bean:write
		name="genericdrugBean" property="strNormMssgstring" /></div>
	<tag:tab tabLabel="Generic Drug Master" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">

	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<tr class="HEADER">
			<td colspan="4" width="25%">Generic Drug Master&gt;&gt; view</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Group Name</td>
			<td class="CONTROL"><bean:write name="genericdrugBean"
				property="strGroupNameValue" filter="false" /></td>
			<td width="25%" class="LABEL">Sub Group Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="genericdrugBean" property="strSubGroupNameValue"
				filter="false" /></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">Consumable Type</td>
			<td class="CONTROL" width="25%"><bean:write
				name="genericdrugBean" property="strConsumableType"
				filter="false" /></td>
			<td width="25%" class="LABEL">Generic Drug Name</td>
			<td width="25%" class="CONTROL" colspan="3"><bean:write
				name="genericdrugBean" property="strDrugName" filter="false" /></td>
		</tr>

		<tr>
			<td class="LABEL" colspan="1" width="25%">Consent Required</td>
			<td class="CONTROL" colspan="1" width="25%"><bean:write
				name="genericdrugBean" property="strConsentReq" filter="false" /></td>
			<td class="LABEL" colspan="1" width="25%">Whether Drug is
			Narcotic Drug</td>
			<td class="CONTROL" colspan="" width="25%"><bean:write
				name="genericdrugBean" property="strIsItemNarcotic" filter="false" />

			</td>
		</tr>
		<tr style="border: 1px solid black">
			<td class="LABEL" rowspan="2" width="25%" style="vertical-align: top">Whether safe during
			pregnancy</td>
			<td class="CONTROL" rowspan="2"  width="25%"   style="vertical-align: top;"><bean:write
				name="genericdrugBean" property="strPregnancySafeFlag" filter="false" />
			
			</td>
			<td class="LABEL"  width="25%"  style="text-align: left; vertical-align: top">Trimester</td>
			<td class="CONTROL"  width="25%"  style="text-align: left; vertical-align: top">
					<bean:write
				name="genericdrugBean" property="strTrimester" filter="false" /></td>
		</tr>
		<tr style="border: 1px solid black">
			<td class="LABEL" width="25%" style="text-align: left; vertical-align: top">Effects
					on foetus:</td>
					<td class="CONTROL" width="25%" style="text-align: left; vertical-align: top">
					<bean:write
				name="genericdrugBean" property="strEffectsOnFoetus" filter="false" />
					</td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="itemManagePlusId" align="left" style="display: none;">
			<img src="../../hisglobal/images/plus.gif" onClick=""
				style="cursor: pointer; " /> Drug Managed By</div>
			<div id="itemManageMinusId" style="display: block;" align="left">

			Drug Managed By</div>
			</td>
		</tr>
	</table>
	<div id="itemManageDtlId" style="display: block">
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<tr>
			<td class="LABEL" colspan="1" width="25%">Batch No.</td>
			<td class="CONTROL" colspan="" width="25%"><bean:write
				name="genericdrugBean" property="strBatchNo" filter="false" /></td>
			<td class="LABEL" width="25%">Expiry Date</td>
			<td class="CONTROL" width="25%"><bean:write
				name="genericdrugBean" property="strExpiryDate" filter="false" /></td>

		</tr>

	</table>

	</div>
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="purchasePlusId" align="left" style="display: none;"><img
				src="../../hisglobal/images/plus.gif"
				onClick="view1('purchasePlusId','purchaseMinusId','purchaseId');"
				style="cursor: pointer; " /> Purchase/Inventory</div>
			<div id="purchaseMinusId" style="display: block;" align="left">

			Purchase/Inventory</div>
			</td>
		</tr>
	</table>
	<div id="purchaseId" style="display: block;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<tr>
			<td class="LABEL" colspan="1" width="25%">Purchase Lead Time</td>
			<td class="CONTROL" colspan="" width="25%"><bean:write
				name="genericdrugBean" property="strPurchaseLeadTime" filter="false" />


			</td>
			<td class="LABEL" colspan="1" width="25%">Time Format</td>
			<td class="CONTROL" colspan="1" width="25%"><bean:write
				name="genericdrugBean" property="strTimeFormat" filter="false" /> <%-- 
				** Inactivated on 28th May 2010, by Aritra
				** Reason: Time formatt not properly shown.
				<html:select property="strTimeFormat" name="genericdrugBean"  styleClass="comboNormal" disabled='true'>
					<html:option value="1"> Day</html:option>
					<html:option value="2"> Month</html:option>
				</html:select>
				--%></td>

		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">Inventory Unit</td>
			<td class="CONTROL" colspan="" width="25%"><bean:write
				name="genericdrugBean" property="strStockMaintain" filter="false" />

			</td>
			<td class="LABEL" colspan="3" width="25%"></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">Shelf Life</td>
			<td class="CONTROL" colspan="" width="25%"><bean:write
				name="genericdrugBean" property="strShelfLife" filter="false" /></td>
			<td class="LABEL" colspan="1" width="25%">Time Format</td>
			<td class="CONTROL" colspan="1" width="25%">
			<%--
				** Added on 28th May 2010, by Aritra
				** Reason: To show Time formatt properly.
				 
			--%>
			<bean:write
				name="genericdrugBean" property="strShelfTimeFormat" filter="false" />
			<%-- 
				** Inactivated on 28th May 2010, by Aritra
				** Reason: Time formatt not properly shown.
				
				<html:select property="strShelfTimeFormat"  styleClass="comboNormal" name="genericdrugBean"  disabled='true'>
					<html:option value="1"> Day</html:option>
					<html:option value="2"> Month</html:option>
					<html:option value="3">Year</html:option>
				</html:select>
				--%></td>
		</tr>

	</table>

	</div>
	<table cellspacing="1px" class="TABLEWIDTH" align="center"
		cellpadding="1px">
		<tr>
			<td class="LABEL" width="25%">Remarks</td>
			<td class="CONTROL" width="75%" colspan="3"><bean:write name="genericdrugBean" property="strRemarks"
				filter="false" /></td>

		</tr>
		<tr>

			<td class="LABEL" width="25%">Effective From</td>
			<td class="CONTROL" width="25%" colspan=""><bean:write
				name="genericdrugBean" property="strEffectiveFrom" filter="false" />
			</td>
			<td class="LABEL">Record Status</td>
			<td class="CONTROL"><bean:write name="genericdrugBean"
				property="strIsValid" filter="false" /></td>

		</tr>
	</table>
	
	<table cellspacing="1px" class="TABLEWIDTH" align="center"
		cellpadding="1px">
		<tr class="FOOTER">
			<td colspan="4" width="25%">&nbsp;</td>
		</tr>
	</table>
	
	
	<table class="TABLEWIDTH" align="center" cellspacing="1px">

		<tr>

			<td align="center" colspan="2" width="25%"><!-- <img
				src="../../hisglobal/images/btn-ccl.png" title="Cancel View"
				onClick="closeView();" style="cursor: pointer; "> -->
				<a href="#" class="button" onclick="closeView();"><span class="cancel">Cancel</span></a>
			</td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" value="${genericdrugBean.strCurrentDate}"
		name="strCurrentDate" />
	<input type="hidden" value="${genericdrugBean.strChk}" name="strChk" />


	<cmbPers:cmbPers />

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>