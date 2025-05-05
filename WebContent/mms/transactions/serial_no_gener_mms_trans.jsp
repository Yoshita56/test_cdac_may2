<%-- 
author 	: Niharika Srivastava
Date of Creation : 15-09-10
Process : Serial No Generation Transaction 
Module 	: MMS
TL 		: Mr. Ajay Kumar Gupta
Description : Initial Page for Serial No Generation Transaction
 --%>

<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<html>
<head>
<meta charset=UTF-8">
<title>Serial No Generation</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../js/serialNoGeneration.js"></script>

</head>
<body>
<html:form name="serialNoGenerationBean"
	action="/transactions/SerialNoGenerationTransCNT"
	type="mms.transactions.controller.fb.SerialNoGenerationTransFB">
	<div id="errMsg" class="errMsg"><bean:write
		name="serialNoGenerationBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="serialNoGenerationBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="serialNoGenerationBean" property="strNormalMsg" /></div>

	<tag:tab tabLabel="Serial No Generation" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab>
	
	<table class="TABLEWIDTH" align="center" cellspacing="0px" cellpadding="0px">
		<tr class="HEADER">
			<td colspan="3" width="90%">Serial No Generation</td>
			<td colspan="1" width="10%"><html:checkbox name="serialNoGenerationBean"
				property="strReprintChk" value="1" onclick="getReprintPage();" title="Click Here To Re-Print Serial No. Details">Re-Print</html:checkbox>&nbsp;
			</td>
		</tr>
	</table>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">	
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Store
			Name</td>
			<td width="25%" class="CONTROL"><select name="strStoreId"
				class='comboNormal' onchange="getItemCategoryCombo(this);">
				<bean:write name="serialNoGenerationBean" property="strStoreNameCombo" filter="false"/>
			</select></td>

			<td width="25%" class="LABEL"><font color="red">*</font>Item
			Category</td>
			<td width="25%" class="CONTROL"><div id="itemCategoryDivId"><select name="strItemCategoryId"
				class='comboNormal'>
				<bean:write name="serialNoGenerationBean" property="strItemCategoryCombo" filter="false"/>
			</select></div></td>
		</tr>

		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Item
			Name</td>
			<td width="25%" class="CONTROL"><div id="itemNameDivId"><select name="strItemName"
				class='comboNormal'>
				<option value="0">Select Value</option>
			</select></div></td>

			<td width="25%" class="LABEL">Avl Qty.</td>
			<td width="25%" class="CONTROL"><div id="avlqtyDivid"></div></td>
		</tr>

	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">

		<tr class="TITLE">
			<td colspan="4">Serial No Details</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Qty For Serial No</td>
			<td width="25%" class="CONTROL"><input type="text"
				class='txtFldMax' name="strQtyForSerial" value="" maxlength="5"
				onkeypress="return validateData(event,7);" onkeyup="checkAvlQty();"></td>

			<td width="25%" class="LABEL"><font color="red">*</font>Prefix</td>
			<td width="25%" class="CONTROL"><input type="text"
				class='txtFldMax' name="strPrefix" value="" maxlength="20"
				onkeypress="return validateData(event,4);"></td>
		</tr>
		
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Report Name</td>
			<td width="25%" class="CONTROL"><input type="text"
				class='txtFldMax' name="strReportName" value="" maxlength="100"
				onkeypress="return validateData(event,4);"></td>
			<td width="25%" class="CONTROL"></td><td width="25%" class="CONTROL"></td>
		</tr>
	</table>

	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">

		<tr class="FOOTER">
			<td colspan="4"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>
			<td align="center">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-generate.png"
				onClick="return validate1();" title="Click to Save Record" />
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png"
				title="Click to Clear Page" onClick="clearPage();">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png"
				title="Click to cancel process" onClick="cancelPage();"></td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input name = "strAvlQty" type="hidden" value="">
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>