<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset=UTF-8">
<title>Reminder Details</title>
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
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/reminderDetailsTrans.js"></script>
<script type="text/javascript">

</script>
</head>
<body>


<html:form name="reminderDetailBean"
	action="/transactions/ReminderDetailsTransCNT"
	type="mms.transactions.controller.fb.ReminderDetailsTransFB">

	<div id="errMsg" class="errMsg"><bean:write
		name="reminderDetailBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="reminderDetailBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="reminderDetailBean" property="strNormalMsg" /></div>

	<tag:tab tabLabel="Reminder Details" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab>

	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="4"><html:radio
				property="strReminderType" value="1" onclick="onRadio(this);">Supplier</html:radio>
			<html:radio property="strReminderType" value="2"
				onclick="onRadio(this);">Purchase</html:radio></td>
		</tr>
	</table>

	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td width="15%" colspan="1" class="LABEL"><font color="red">*</font>Store
			Name</td>
			<td width="35%" colspan="1" class="CONTROL"><select
				name="strStoreId" class="comboNormal"
				onchange="getPONo(),onStoreCombo();">
				<bean:write name="reminderDetailBean" property="strStoreValues"
					filter="false" />
				
			</select></td>




			<td width="20%" colspan="1" class="LABEL"><font color="red">*</font>PO
			No</td>
			<td width="30%" colspan="1" class="CONTROL">
			<div id="poNoDivId"><select name="strPONo" 
				onchange="getScheduleNo();">
				<bean:write name="reminderDetailBean" property="strPoValues"
					filter="false" />
			</select></div>

			</td>


		</tr>
	</table>



	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td width="15%" colspan="1" class="LABEL">Schedule No</td>
			<td width="85%" colspan="3" class="CONTROL">

			<div id="scheduleDivId"><select name="strScheduleNo"
				class="comboNormal" onchange="resetDiv();">
				<option value="0">Select Value</option>
			</select></div>
			</td>

		</tr>
	</table>

	<div id="podetailsDivId" style="display: none;"></div>

	<div id="revRemDetButton" style="display: none;">

	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<td width="5%" class="TITLE" align="center"><img
				src="../../hisglobal/images/plus.gif" id="plus2"
				style="display: block; cursor: pointer; "
				onClick="disPrevReminderDtl(),getPrevReminderDtl();"> <img
				src="../../hisglobal/images/minus.gif" id="minus2"
				style="display: none; cursor: pointer; "
				onClick="disPrevReminderDtl1();"></td>
			<td colspan="3" class="TITLE" style='color:blue;'><b>Previous Reminder Details</b></td>
		</tr>
	</table>

	</div>
	<div id="prevReminderDivId" style="display: none;"></div>



	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="FOOTER">
			<td colspan="4"><font color="red">*</font> Mandatory Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>

			<td align="center"><img style=" cursor: pointer"
				src="../../hisglobal/images/btn-generate.png"
				onclick="return validate1();" /> <img
				style=" cursor: pointer"
				src="../../hisglobal/images/btn-clr.png" onClick="clearRem();">
			<img style=" cursor: pointer"
				src="../../hisglobal/images/btn-ccl.png" onClick="cancelRem();">
			</td>

		</tr>
	</table>
	<input type="hidden" name="hmode" />

</html:form>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>