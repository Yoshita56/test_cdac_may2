<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
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
<title>Drug Inventory Modify</title>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">


<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" 
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
<html:form name="drugInventoryTransBean"
	action="/transactions/DrugInventoryTransCNT"
	type="mms.transactions.controller.fb.DrugInventoryTransFB">


	<div class="errMsg"><bean:write name="drugInventoryTransBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="drugInventoryTransBean"
		property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="drugInventoryTransBean" property="strMsg" /></div>

	<center><tag:tab tabLabel="Drug Inventory Modify1"
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
				name="drugInventoryTransBean" property="strStoreName" filter="false" />
			</td>
			<td width="25%" class="LABEL">Group Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="drugInventoryTransBean" property="strGroupName" filter="false" />
			</td>
		</tr>

		<tr>
			<td width="25%" class="LABEL">Sub Group Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="drugInventoryTransBean" property="strSubGroupName"
				filter="false" /></td>


			<td width="25%" class="LABEL">Generic Drug Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="drugInventoryTransBean" property="strItemName" filter="false" />
			</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Drug Name1</td>
			<td width="25%" class="CONTROL"><bean:write
				name="drugInventoryTransBean" property="strItemBrandName"
				filter="false" /></td>


			<td width="25%" class="LABEL">Manufacture Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="drugInventoryTransBean" property="strManufactureName"
				filter="false" /></td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL">Specification</td>
			<td colspan="2" class="CONTROL"><textarea rows="2" cols="40"
				name="strItemSpecification" readonly>
				<bean:write
				name="drugInventoryTransBean" property="strItemSpecification"
				filter="false" /></textarea></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Batch No <logic:empty
				name="drugInventoryTransBean" property="strBatchNo">
				<input type="hidden" name="isBatchReq" value="0">
			</logic:empty> <logic:notEmpty name="drugInventoryTransBean" property="strBatchNo">
				<input type="hidden" name="isBatchReq" value="1">
			</logic:notEmpty></td>
			<td width="25%" class="CONTROL"><bean:write
				name="drugInventoryTransBean" property="strBatchNo" filter="false" />
			</td>

			<td class="LABEL">
			<div id="expiryDateDivId">Expiry Date</div>

			<logic:empty name="drugInventoryTransBean" property="strExpiryDate">
				<input type="hidden" name="isExpirtReq" value="0">
			</logic:empty> <logic:notEmpty name="drugInventoryTransBean"
				property="strExpiryDate">
				<input type="hidden" name="isExpirtReq" value="1">
			</logic:notEmpty></td>

			<td class="CONTROL" width="25%"><dateTag:date
				name="strExpiryDate" value="${drugInventoryTransBean.strExpiryDate}"></dateTag:date>
			</td>
		</tr>
		<tr>
			<td class="LABEL" width="25%">Manufacture Date</td>
			<td class="CONTROL" width="25%"><dateTag:date
				name="strManufactureDate"
				value="${drugInventoryTransBean.strManufactureDate}"></dateTag:date></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Stock
			Status</td>
			<td class="CONTROL" width="25%"><select name="strStockStatus"
				class="comboNormal"  disabled="disabled">

				<bean:write name="drugInventoryTransBean"
					property="strStockStatusValues" filter="false" />

			</select></td>
		</tr>

		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>InHand
			Qty.</td>

			<td class="CONTROL" width="25%"><input type="text"
				name="strInHandQuantity" maxlength="8" class="txtFldMax"
				value="${drugInventoryTransBean.strInHandQuantity}"
				onkeypress="return validateData(event,5);" /></td>

			<td class="LABEL" width="25%"><font color="red">*</font>InHand
			Qty. Unit</td>
			<td class="CONTROL" width="25%"><select
				name="strInHandQuantityUnitID" class='comboNormal'>
				<bean:write name="drugInventoryTransBean"
					property="strInHandQuantityUnitValues" filter="false" />
			</select></td>
		</tr>
			</table>
		
	<div id="frreQty" style="display:none;">	
		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="LABEL" width="25%">Free Drug Qty.</td>

			<td class="CONTROL" width="25%"><input type="text"
				name="strFreeItemQuantity" maxlength="8" class="txtFldMax"
				value="${drugInventoryTransBean.strFreeItemQuantity}" onkeypress="return validateData(event,5);" /></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Free Drug Qty. Unit</td>
			<td class="CONTROL" width="25%">
			<select name="strFreeItemQuantityUnitID"
				class='comboNormal'>
				<bean:write name="drugInventoryTransBean"
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
				value="${drugInventoryTransBean.strRackNumber}"
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
				<bean:write name="drugInventoryTransBean"
					property="strCurrencyCodeValues" filter="false" />
			</select></td>

			<td class="LABEL" width="25%"><logic:equal
				name="drugInventoryTransBean" property="strCurrencyCode"
				value="${drugInventoryTransBean.strDefaultCurrencyCode}">
				<div id="currencyDivId">Currency Value</div>
				<input type="hidden" name="isCurrencyReq" value="0">
			</logic:equal> <logic:notEqual name="drugInventoryTransBean"
				property="strCurrencyCode"
				value="${drugInventoryTransBean.strDefaultCurrencyCode}">
				<div id="currencyDivId"><font color="red">*</font>Currency
				Value</div>
				<input type="hidden" name="isCurrencyReq" value="1">
			</logic:notEqual></td>

			<td class="CONTROL" width="25%"><logic:equal
				name="drugInventoryTransBean" property="strCurrencyCode"
				value="${drugInventoryTransBean.strDefaultCurrencyCode}">
				<input type="text" name="strCurrencyValue" maxlength="8"
					class="txtFldNormal" onkeypress="return validateData(event,7);"
					disabled="disabled"
					value="${drugInventoryTransBean.strCurrencyValue}" />
			</logic:equal> <logic:notEqual name="drugInventoryTransBean"
				property="strCurrencyCode"
				value="${drugInventoryTransBean.strDefaultCurrencyCode}">
				<input type="text" name="strCurrencyValue" maxlength="8"
					class="txtFldNormal" onkeypress="return validateData(event,7);"
					value="${drugInventoryTransBean.strCurrencyValue}" />
			</logic:notEqual></td>

		</tr>

		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Purchase Rate/Unit
			</td>

			<td class="CONTROL" colspan="1" width="25%"><input type="text"
				name="strRate" maxlength="14" class="txtFldMax"
				value="${drugInventoryTransBean.strRate}" onBlur="calcIssueRateOne();"
				onkeypress="return (numericWithTwoDecimalPlaces(this,',','.',event));" /></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Unit Name</td>
			<td class="CONTROL" width="25%"><select name="strUnitRateID" class='comboNormal' onchange="getIssueRateUnitCombo();">
				<bean:write name="drugInventoryTransBean"
					property="strRateUnitValues" filter="false" />
			</select></td>

		</tr>
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>M.R.P./Unit</td>

			<td class="CONTROL" width="25%"><input type="text"
				name="strSalePrice" maxlength="14" class="txtFldMax"
				value="${drugInventoryTransBean.strSalePrice}"
				onkeypress="return validateData(event,7);"  /></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Unit Name</td>
			<td class="CONTROL" width="25%"><select name="strUnitSaleID"
				class='comboNormal'>
				<bean:write name="drugInventoryTransBean"
					property="strSalesRateUnitValues" filter="false" />
			</select></td>


		</tr>

		<tr>
			<td colspan="4" class="TITLE" width="25%">P.O. Details</td>
		</tr>

		<tr>

			<td class="LABEL" width="25%">P.O. No.</td>
			<td class="CONTROL" width="25%"><input type="text"
				value="${drugInventoryTransBean.strPoNo}" name="strPoNo"
				maxlength="25" class="txtFldMax"
				onkeypress="return validateData(event,17);" /></td>

			<td class="LABEL" width="25%">P.O. Date</td>
			<td class="CONTROL" width="25%"><dateTag:date name="strPoDate"
				value="${drugInventoryTransBean.strPoDate}"></dateTag:date></td>

		</tr>

		<tr>

			<td class="LABEL" width="25%">Bill No.</td>
			<td class="CONTROL" width="25%"><input type="text"
				value="${drugInventoryTransBean.strBillNo}" name="strBillNo"
				maxlength="25" class="txtFldMax"
				onkeypress="return validateData(event,17);" /></td>

			<td class="LABEL" width="25%">Bill Date</td>
			<td class="CONTROL" width="25%"><dateTag:date name="strBillDate"
				value="${drugInventoryTransBean.strBillDate}"></dateTag:date></td>

		</tr>


		<tr>

			<td class="LABEL" width="25%"><font color="red">*</font>Received
			Date</td>
			<td class="CONTROL" width="25%"><dateTag:date
				name="strReceivedDate"
				value="${drugInventoryTransBean.strReceivedDate}"></dateTag:date></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Supplied
			By</td>
			<td class="CONTROL" width="25%"><select name="strSuppliedBy"
				class="comboMax">
				<bean:write name="drugInventoryTransBean"
					property="strSuppliedByValues" filter="false" />
			</select></td>

		</tr>

	</table>
	<input type="hidden" name="todayDate" id="todayDate"
		value="${drugInventoryTransBean.strCtDate}" />

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

			<td class="multiLabel" width="20%">Drug Name</td>
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

			<!-- <td align="center"><img style="cursor: pointer; " src="../../hisglobal/images/btn-add.png" onClick="addFreeItems();" /> -->
			<td align="center">
			<a href="#" class="button"	onclick="addFreeItems();"><span class="add">Add</span></a> 
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






	<!-- <table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr>

			<td align="center"><img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png"
				onClick="validatemodify();" title="Click to Save Record" /> <img
				style="cursor: pointer; "
				src="../../hisglobal/images/back_tab.png" onClick="cancel('LIST');"
				title="Click to Return On Desk" /></td>
		</tr>
	</table> -->
	<br>
	<div align="center" id="">					 
					 	<a href="#" class="button" id="submitId" onclick='validatemodify();'><span class="save">Save</span></a>
						<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
				</div>

	<input type="hidden" name="strStoreId" value="${drugInventoryTransBean.combo[0]}" />
	<input type="hidden" name="strStoreName" value="${drugInventoryTransBean.strStoreName}" />
	<input type="hidden" name="strGroupId"	value="${drugInventoryTransBean.combo[1]}" />
	<input type="hidden" name="strGroupName" value="${drugInventoryTransBean.strGroupName}" />
	<input type="hidden" name="strCtDate"	value="${drugInventoryTransBean.strCtDate}">
	<input type="hidden"  name="strExistingBatchDetails"  value="${drugInventoryTransBean.strExistingBatchDetails}">


	<input type="hidden" name="strDefaultCurrencyCode"	value="${drugInventoryTransBean.strDefaultCurrencyCode}">

	<input type="hidden" name="strChk"	value="${drugInventoryTransBean.strChk }">
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strManufactureId"	value="${drugInventoryTransBean.strManufactureId}" />
		
    <input type="hidden"  name="strConfigIssueRate"  value="${drugInventoryTransBean.strConfigIssueRate}">
	<input type="hidden"  name="strIssueRateConfigFlg"  value="${drugInventoryTransBean.strIssueRateConfigFlg}">
	<input type="hidden"  name="strRateOnLoad"  value="${drugInventoryTransBean.strRate}">
	
		
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
