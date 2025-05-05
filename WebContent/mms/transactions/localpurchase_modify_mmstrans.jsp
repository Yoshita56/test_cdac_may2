<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>



<html>
<head>
<meta charset=UTF-8">
<title>Item/Drug Inventory</title>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">


<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">


<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>

<script language="JavaScript" src="../js/drug_inventory_trans.js"></script>

<script language="JavaScript" src="../js/item_OtherDtls_util.js"></script>


</head>

<body onLoad="calcIssueRateTwo();">
<html:form name="localPurchaseTransBean"
	action="/transactions/LocalPurchaseTransCNT"
	type="mms.transactions.controller.fb.LocalPurchaseTransFB">


	<div class="errMsg"><bean:write name="localPurchaseTransBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="localPurchaseTransBean"
		property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="localPurchaseTransBean" property="strMsg" /></div>

	<center><tag:tab tabLabel="Item/Drug Inventory "
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Store Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="localPurchaseTransBean" property="strStoreName" filter="false" />
			</td>
			<td width="25%" class="LABEL">Group Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="localPurchaseTransBean" property="strGroupName" filter="false" />
			</td>
		</tr>

		<tr>
			<td width="25%" class="LABEL">Sub Group Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="localPurchaseTransBean" property="strSubGroupName"
				filter="false" /></td>


			<td width="25%" class="LABEL">Generic Item/Drug Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="localPurchaseTransBean" property="strItemName" filter="false" />
			</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Item/Drug Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="localPurchaseTransBean" property="strItemBrandName"
				filter="false" /></td>


			<td width="25%" class="LABEL">Manufacture Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="localPurchaseTransBean" property="strManufactureName"
				filter="false" /></td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL">Specification</td>
			<td colspan="2" class="CONTROL"><textarea rows="2" cols="40"
				name="strItemSpecification" readonly>
				<bean:write
				name="localPurchaseTransBean" property="strItemSpecification"
				filter="false" /></textarea></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Batch No <logic:empty
				name="localPurchaseTransBean" property="strBatchNo">
				<input type="hidden" name="isBatchReq" value="0">
			</logic:empty> <logic:notEmpty name="localPurchaseTransBean" property="strBatchNo">
				<input type="hidden" name="isBatchReq" value="1">
			</logic:notEmpty></td>
			<td width="25%" class="CONTROL"><bean:write
				name="localPurchaseTransBean" property="strBatchNo" filter="false" />
			</td>

			<td class="LABEL">
			<div id="expiryDateDivId">Expiry Date</div>

			<logic:empty name="localPurchaseTransBean" property="strExpiryDate">
				<input type="hidden" name="isExpirtReq" value="0">
			</logic:empty> <logic:notEmpty name="localPurchaseTransBean"
				property="strExpiryDate">
				<input type="hidden" name="isExpirtReq" value="1">
			</logic:notEmpty></td>

			<td class="CONTROL" width="25%"><dateTag:date
				name="strExpiryDate" value="${localPurchaseTransBean.strExpiryDate}"></dateTag:date>
			</td>
		</tr>
		<tr>
			<td class="LABEL" width="25%">Manufacture Date</td>
			<td class="CONTROL" width="25%"><dateTag:date
				name="strManufactureDate"
				value="${localPurchaseTransBean.strManufactureDate}"></dateTag:date></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Stock
			Status</td>
			<td class="CONTROL" width="25%"><select name="strStockStatus"
				class="comboNormal"  disabled="disabled">

				<bean:write name="localPurchaseTransBean"
					property="strStockStatusValues" filter="false" />

			</select></td>
		</tr>

		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>InHand
			Qty.</td>

			<td class="CONTROL" width="25%"><input type="text"
				name="strInHandQuantity" maxlength="8" class="txtFldMax"
				value="${localPurchaseTransBean.strInHandQuantity}"
				onkeypress="return validateData(event,5);" /></td>

			<td class="LABEL" width="25%"><font color="red">*</font>InHand
			Qty. Unit</td>
			<td class="CONTROL" width="25%"><select
				name="strInHandQuantityUnitID" class='comboNormal'>
				<bean:write name="localPurchaseTransBean"
					property="strInHandQuantityUnitValues" filter="false" />
			</select></td>
		</tr>
			</table>
		
	<div id="frreQty" style="display:none;">	
		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="LABEL" width="25%">Free Item/Drug Qty.</td>

			<td class="CONTROL" width="25%"><input type="text"
				name="strFreeItemQuantity" maxlength="8" class="txtFldMax"
				value="${localPurchaseTransBean.strFreeItemQuantity}" onkeypress="return validateData(event,5);" /></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Free Item/Drug Qty. Unit</td>
			<td class="CONTROL" width="25%">
			<select name="strFreeItemQuantityUnitID"
				class='comboNormal'>
				<bean:write name="localPurchaseTransBean"
					property="strInHandQuantityUnitValues" filter="false" />
			</select>
			</td>
		</tr>
		</table>
	</div>	
		
		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
		
		<tr>
			<td class="LABEL" width="25%">Rack No</td>

			<td class="CONTROL" width="25%">
				<input type="text"
				name="strRackNumber"  class="txtFldMax"
				value="${localPurchaseTransBean.strRackNumber}"
				onkeypress="return validateData(event,3);" />
				</td>

			<td class="CONTROL" width="25%"></td>
			<td class="CONTROL" width="25%">
			
			</td>
		</tr>
		
		<tr>
			<td colspan="4" class="TITLE" width="25%">Rate Details</td>
		</tr>
		<tr>
			<td class="LABEL" width="25%">Currency Code</td>
			<td class="CONTROL" width="25%"><select name="strCurrencyCode"
				class="comboNormal" onchange="isCurrencyMandatory(this);">
				<bean:write name="localPurchaseTransBean"
					property="strCurrencyCodeValues" filter="false" />
			</select></td>

			<td class="LABEL" width="25%"><logic:equal
				name="localPurchaseTransBean" property="strCurrencyCode"
				value="${localPurchaseTransBean.strDefaultCurrencyCode}">
				<div id="currencyDivId">Currency Value</div>
				<input type="hidden" name="isCurrencyReq" value="0">
			</logic:equal> <logic:notEqual name="localPurchaseTransBean"
				property="strCurrencyCode"
				value="${localPurchaseTransBean.strDefaultCurrencyCode}">
				<div id="currencyDivId"><font color="red">*</font>Currency
				Value</div>
				<input type="hidden" name="isCurrencyReq" value="1">
			</logic:notEqual></td>

			<td class="CONTROL" width="25%"><logic:equal
				name="localPurchaseTransBean" property="strCurrencyCode"
				value="${localPurchaseTransBean.strDefaultCurrencyCode}">
				<input type="text" name="strCurrencyValue" maxlength="8"
					class="txtFldNormal" onkeypress="return validateData(event,7);"
					disabled="disabled"
					value="${localPurchaseTransBean.strCurrencyValue}" />
			</logic:equal> <logic:notEqual name="localPurchaseTransBean"
				property="strCurrencyCode"
				value="${localPurchaseTransBean.strDefaultCurrencyCode}">
				<input type="text" name="strCurrencyValue" maxlength="8"
					class="txtFldNormal" onkeypress="return validateData(event,7);"
					value="${localPurchaseTransBean.strCurrencyValue}" />
			</logic:notEqual></td>

		</tr>

		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Purchase Rate/Unit
			</td>

			<td class="CONTROL" colspan="1" width="25%"><input type="text"
				name="strRate" maxlength="14" class="txtFldMax"
				value="${localPurchaseTransBean.strRate}" onBlur="calcIssueRateOne();"
				onkeypress="return (numericWithTwoDecimalPlaces(this,',','.',event));" /></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Unit Name</td>
			<td class="CONTROL" width="25%"><select name="strUnitRateID" class='comboNormal' onchange="getIssueRateUnitCombo();">
				<bean:write name="localPurchaseTransBean"
					property="strRateUnitValues" filter="false" />
			</select></td>

		</tr>
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Issue Rate/Unit</td>

			<td class="CONTROL" width="25%"><input type="text"
				name="strSalePrice" maxlength="14" class="txtFldMax"
				value="${localPurchaseTransBean.strSalePrice}"
				onkeypress="return validateData(event,7);"  /></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Unit Name</td>
			<td class="CONTROL" width="25%"><select name="strUnitSaleID"
				class='comboNormal'>
				<bean:write name="localPurchaseTransBean"
					property="strSalesRateUnitValues" filter="false" />
			</select></td>


		</tr>

		<tr>
			<td colspan="4" class="TITLE" width="25%">P.O. Details</td>
		</tr>

		<tr>

			<td class="LABEL" width="25%">P.O. No.</td>
			<td class="CONTROL" width="25%"><input type="text"
				value="${localPurchaseTransBean.strPoNo}" name="strPoNo"
				maxlength="25" class="txtFldMax"
				onkeypress="return validateData(event,17);" /></td>

			<td class="LABEL" width="25%">P.O. Date</td>
			<td class="CONTROL" width="25%"><dateTag:date name="strPoDate"
				value="${localPurchaseTransBean.strPoDate}"></dateTag:date></td>

		</tr>

		<tr>

			<td class="LABEL" width="25%">Bill No.</td>
			<td class="CONTROL" width="25%"><input type="text"
				value="${localPurchaseTransBean.strBillNo}" name="strBillNo"
				maxlength="25" class="txtFldMax"
				onkeypress="return validateData(event,17);" /></td>

			<td class="LABEL" width="25%">Bill Date</td>
			<td class="CONTROL" width="25%"><dateTag:date name="strBillDate"
				value="${localPurchaseTransBean.strBillDate}"></dateTag:date></td>

		</tr>


		<tr>

			<td class="LABEL" width="25%"><font color="red">*</font>Received
			Date</td>
			<td class="CONTROL" width="25%"><dateTag:date
				name="strReceivedDate"
				value="${localPurchaseTransBean.strReceivedDate}"></dateTag:date></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Supplied
			By</td>
			<td class="CONTROL" width="25%"><select name="strSuppliedBy"
				class="comboMax">
				<bean:write name="localPurchaseTransBean"
					property="strSuppliedByValues" filter="false" />
			</select></td>

		</tr>

	</table>
	<input type="hidden" name="todayDate" id="todayDate"
		value="${localPurchaseTransBean.strCtDate}" />

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="freeItemDtlsDivIdPlusId" align="left"
				style="display: block;"><img
				src="../../hisglobal/images/plus.gif"
				onClick="getOtherItemsModifyView('1'),showView('freeItemDtlsDivId' );"
				style="cursor: pointer; " title="Show Details" /> Free
			Items</div>
			<div id="freeItemDtlsDivIdMinusId" style="display: none;"
				align="left"><img src="../../hisglobal/images/minus.gif"
				onClick="hideView('freeItemDtlsDivId');"
				style="cursor: pointer; " title="Hide Details" /> Free
			Items</div>
			</td>
		</tr>
	</table>



	<div id="freeItemDtlsDivId" style="display: none">

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr>

			<td class="multiLabel" width="20%">Item/Drug Name</td>
			<td class="multiLabel" width="20%">Batch No.</td>
			<td class="multiLabel" width="20%">Expiry Date</td>
			<td class="multiLabel" width="20%">Qty.</td>
			<td class="multiLabel" width="5%"></td>
		</tr>
	</table>
	<div id="id1"></div>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr>
			<td colspan="4" class="TITLE" width="25%"></td>
		</tr>

		<tr>

			<td align="center"><img style="cursor: pointer; "
				src="../../hisglobal/images/btn-add.png" onClick="addFreeItems();" />
			</td>
		</tr>

	</table>

	</div>



	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr class="FOOTER">
			<td colspan="4" width="25%"><font size="2" color="red">*</font>
			Mandatory Fields  , ['*'] Reserved/Branded Item</td>
		</tr>
	</table>






	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr>

			<td align="center"><img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png"
				onClick="validatemodify();" title="Click to Save Record" /> <img
				style="cursor: pointer; "
				src="../../hisglobal/images/back_tab.png" onClick="cancel('LIST');"
				title="Click to Return On Desk" /></td>
		</tr>
	</table>

	<input type="hidden" name="strStoreId" value="${localPurchaseTransBean.combo[0]}" />
	<input type="hidden" name="strStoreName" value="${localPurchaseTransBean.strStoreName}" />
	<input type="hidden" name="strGroupId"	value="${localPurchaseTransBean.combo[1]}" />
	<input type="hidden" name="strGroupName" value="${localPurchaseTransBean.strGroupName}" />
	<input type="hidden" name="strCtDate"	value="${localPurchaseTransBean.strCtDate}">
	<input type="hidden"  name="strExistingBatchDetails"  value="${localPurchaseTransBean.strExistingBatchDetails}">


	<input type="hidden" name="strDefaultCurrencyCode"	value="${localPurchaseTransBean.strDefaultCurrencyCode}">

	<input type="hidden" name="strChk"	value="${localPurchaseTransBean.strChk }">
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strManufactureId"	value="${localPurchaseTransBean.strManufactureId}" />
		
    <input type="hidden"  name="strConfigIssueRate"  value="${localPurchaseTransBean.strConfigIssueRate}">
	<input type="hidden"  name="strIssueRateConfigFlg"  value="${localPurchaseTransBean.strIssueRateConfigFlg}">
	<input type="hidden"  name="strRateOnLoad"  value="${localPurchaseTransBean.strRate}">
	
		
	<cmbPers:cmbPers />


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



</html:form>

<jsp:include page="drugInventory_multirow_mmstrans.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>
</body>
</html>
