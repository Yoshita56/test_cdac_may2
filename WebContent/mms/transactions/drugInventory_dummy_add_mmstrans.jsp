<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset=UTF-8">
<title>Drug Inventory</title>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">


<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">



<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>

<script language="JavaScript" src="../js/drug_inventory_dummy.js"></script>

<script language="JavaScript" src="../js/item_OtherDtls_util.js"></script>

</head>

<body>
<html:form name="drugInventoryTransBean"
	action="/transactions/DrugInventoryTransCNT"
	type="mms.transactions.controller.fb.DrugInventoryTransFB">


	<div class="errMsg" id="errMsg"><bean:write
		name="drugInventoryTransBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="drugInventoryTransBean" property="strWarning" /></div>

	<div class="normalMsg" id="normalMsg"><bean:write
		name="drugInventoryTransBean" property="strMsg" /></div>

	<center><tag:tab tabLabel="Drug Inventory "
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4">Drug Inventory&gt;&gt;Add1</td>
		</tr>

		<tr>
			<td width="50%" class="LABEL">Drug Warehouse</td>
			<td width="50%" class="CONTROL"><bean:write
				name="drugInventoryTransBean" property="strStoreName" filter="false" />
			</td>

		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">


		<tr>
			<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Drug
			Name</td>
			<td class="CONTROL" width="75%" colspan="3"><select
				name="strItemBrandId" class='comboTooMax'
				onChange='ajaxManufectureName(1);'>
				<bean:write name="drugInventoryTransBean"
					property="strItemBrandCombo" filter="false"></bean:write>
			</select></td>

		</tr>

		<tr>
			<td class="LABEL"><font color="red">*</font>Batch No.</td>

			<td class="CONTROL" width="25%">
			<div id="ExistingBatchId"><select name="strExistingBatchId"
				class='comboNormal' onchange="">
				<option value="0">Select Value</option>
			</select></div>
			</td>


			<td class="LABEL">
			<div id="newBatchDivId"><font color="red">*</font>New Batch No</div>
			<div id="oldBatchDivId" style="display: none;"><font
				color="red">*</font>Existing Batch No</div>

			</td>

			<td class="CONTROL" width="25%"><input type="text"
				name="strBatchNo" maxlength="30" class="txtFldMax"
				onkeypress="return validateData(event,17);" /></td>
		</tr>

		<tr>
			<td class="LABEL" width="25%">Mfg. Date</td>
			<td class="CONTROL" width="25%"><dateTag:date
				name="strManufactureDate"
				value="${drugInventoryTransBean.strCtDate}" value=""></dateTag:date>
			</td>

			<td class="LABEL"><font color="red">*</font>Expiry Date</td>

			<td class="CONTROL" width="25%"><dateTag:date
				name="strExpiryDate" value=""></dateTag:date></td>
		</tr>

		<tr>
			<td class="LABEL" width="25%">Qty</td>

			<td class="CONTROL" width="25%"><input type="text"
				name="strActiveQty" maxlength="8" class="txtFldNormal"
				onkeypress="return validateData(event,5);" /></td>

			<td class="LABEL" width="25%">Qty</td>

			<td class="CONTROL" width="25%"><input type="text"
				name="strQuarantineQty" value="0" maxlength="8" class="txtFldNormal"
				onkeypress="return validateData(event,5);" /></td>
		</tr>

		<tr>
			<td class="LABEL" width="25%">In-Active Qty</td>

			<td class="CONTROL" width="25%"><input type="text"
				name="strInActiveQty" value="0" maxlength="8" class="txtFldNormal"
				onkeypress="return validateData(event,5);" /></td>

			<td width="25%" class="CONTROL"></td>
			<td width="25%" class="CONTROL"></td>
		</tr>

		<tr style="display: none;">
			<td class="LABEL">Manufacturer</td>

			<td width="25%" class="CONTROL">
			<div id="manufDivId"><select class="comboMax"
				name="strManufactureId">
				<option value='0'>Select Value</option>
			</select></div>
			</td>

			<td class="LABEL" width="25%"></td>
			<td class="CONTROL" width="25%"></td>

		</tr>
	</table>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr class="FOOTER">
			<td colspan="4" width="25%"><font size="2" color="red">*</font>
			Mandatory Fields</td>
		</tr>
	</table>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr>

			<td align="center"><img style="cursor: pointer;"
				src="../../hisglobal/images/btn-sv.png" onClick="validate1();"
				title="Click to Save Record" /> <img style="cursor: pointer;"
				src="../../hisglobal/images/btn-clr.png" onClick="ClearPage();"
				title="Click to Clear Page" /> <img style="cursor: pointer;"
				src="../../hisglobal/images/back_tab.png" onClick="cancel('LIST');"
				title="Click to Return On Desk" /></td>
		</tr>



	</table>

	<input type="hidden" name="strStoreId"
		value="${drugInventoryTransBean.combo[0]}" />
	<input type="hidden" name="strStoreName"
		value="${drugInventoryTransBean.strStoreName}" />
	<input type="hidden" name="strGroupId"
		value="${drugInventoryTransBean.combo[1]}" />
	<input type="hidden" name="strGroupName"
		value="${drugInventoryTransBean.strGroupName}" />
	<input type="hidden" name="strCtDate"
		value="${drugInventoryTransBean.strCtDate}">

	<input type="hidden" name="strDefaultCurrencyCode"
		value="${drugInventoryTransBean.strDefaultCurrencyCode}">

	<input type="hidden" name="strRegFlag" value="" />

	<input type="hidden" name="hmode" />
	<input type="hidden" name="strExistingBatchFlg" value="1" />



	<div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="otherDtlspopUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			<div id="itemsOtherDtlsDivId" style="display: block;"></div>
			</td>
		</tr>
	</table>
	</div>



	<cmbPers:cmbPers />
</html:form>

<jsp:include page="drugInventory_multirow_mmstrans.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>
</body>
</html>
