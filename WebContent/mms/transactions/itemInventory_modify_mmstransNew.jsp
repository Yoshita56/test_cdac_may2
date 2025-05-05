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
<title>Item Inventory</title>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">


<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>

<script language="JavaScript" src="../js/item_inventory_trans.js"></script>

<script language="JavaScript" src="../js/item_OtherDtls_util.js"></script>

<script language="Javascript" src="../js/itemparameterdetails_util.js"></script>

</head>

<body onload="initializeModifyPage();">
<html:form name="itemInventoryTransBean"
	action="/transactions/ItemInventoryTransCNT"
	type="mms.transactions.controller.fb.ItemInventoryTransFB">


	<div class="errMsg"><bean:write name="itemInventoryTransBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="itemInventoryTransBean"
		property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="itemInventoryTransBean" property="strMsg" /></div>

	<center><tag:tab tabLabel="Item Inventory "
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
				name="itemInventoryTransBean" property="strStoreName" filter="false" />
			</td>
			<td width="25%" class="LABEL">Item Category</td>
			<td width="25%" class="CONTROL"><bean:write
				name="itemInventoryTransBean" property="strItemCategoryName"
				filter="false" /></td>
		</tr>
		<tr>
			<td width="25%"   class="LABEL">Group Name</td>
			<td width="25%"   class="CONTROL"><bean:write
				name="itemInventoryTransBean" property="strGroupName" filter="false" />
			</td>
		
			<td width="25%" class="LABEL">Sub Group Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="itemInventoryTransBean" property="strSubGroupName"
				filter="false" /></td>
</tr>
		<tr>

			<td width="25%" class="LABEL">Generic Item Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="itemInventoryTransBean" property="strItemName" filter="false" />
			</td>
		
			<td width="25%" class="LABEL">Item Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="itemInventoryTransBean" property="strItemBrandName"
				filter="false" /></td>

		</tr>
		<tr>
		<td width="25%" class="LABEL">Manufacture Name</td>
			<td width="75%" colspan="3" class="CONTROL"><bean:write
				name="itemInventoryTransBean" property="strManufactureName"
				filter="false" /></td>
		</tr>
		<tr>
		<td width="25%" class="LABEL">Specification</td>
			<td width="75%" colspan="3" class="CONTROL"><bean:write
				name="itemInventoryTransBean" property="strItemSpecification"
				filter="false" /></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><logic:empty
				name="itemInventoryTransBean" property="strBatchNo">Batch No
				<input type="hidden" name="isBatchReq" value="0">
			</logic:empty> <logic:notEmpty name="itemInventoryTransBean" property="strBatchNo"><font color="red">*</font>Batch No
				<input type="hidden" name="isBatchReq" value="1">
			</logic:notEmpty></td>
			<td width="25%" class="CONTROL"><bean:write
				name="itemInventoryTransBean" property="strBatchNo" filter="false" /> / <bean:write
				name="itemInventoryTransBean" property="strSerialNo" filter="false" />
			</td>

			<td class="LABEL">
		
			<logic:empty name="itemInventoryTransBean" property="strExpiryDate">
				<input type="hidden" name="isExpirtReq" value="0">Expiry Date
			</logic:empty> <logic:notEmpty name="itemInventoryTransBean"
				property="strExpiryDate">
				<input type="hidden" name="isExpirtReq" value="1"><font color="red">*</font>Expiry Date
			</logic:notEmpty></td>

			<td class="CONTROL" width="25%"><dateTag:date
				name="strExpiryDate" value="${itemInventoryTransBean.strExpiryDate}"></dateTag:date>
			</td>
		</tr>
		<tr>
			<td class="LABEL" width="25%">Manufacture Date</td>
			<td class="CONTROL" width="25%"><dateTag:date
				name="strManufactureDate"
				value="${itemInventoryTransBean.strManufactureDate}"></dateTag:date></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Stock
			Status</td>
			<td class="CONTROL" width="25%"><select name="strStockStatus"
				class="comboNormal">

				<bean:write name="itemInventoryTransBean"
					property="strStockStatusValues" filter="false" />

			</select></td>
		</tr>

		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>InHand
			Quantity</td>

			<td class="CONTROL" width="25%"><input type="text"
				name="strInHandQuantity" maxlength="8" class="txtFldNormal" onkeyup="return validateQty('strInHandQuantity','strInHandQuantityUnitID');"
				value="${itemInventoryTransBean.strInHandQuantity}"
				onkeypress="return validateData(event,7);" /></td>

			<td class="LABEL" width="25%"><font color="red">*</font>InHand
			Quantity Unit</td>
			<td class="CONTROL" width="25%"><select
				name="strInHandQuantityUnitID" class='comboNormal' onchange="return validateQty('strInHandQuantity','strInHandQuantityUnitID');" >
				<bean:write name="itemInventoryTransBean"
					property="strInHandQuantityUnitValues" filter="false" />
			</select></td>
		</tr>
		
		<tr>
			<td class="LABEL" width="25%">Free Item Qty.</td>

			<td class="CONTROL" width="25%"><input type="text"
				name="strFreeItemQuantity" maxlength="8" class="txtFldMin"
				value="${itemInventoryTransBean.strFreeItemQuantity}" onkeypress="return validateData(event,5);" /></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Free Item Qty. Unit</td>
			<td class="CONTROL" width="25%">
			<select name="strFreeItemQuantityUnitID"
				class='comboNormal'>
				<bean:write name="itemInventoryTransBean"
					property="strInHandQuantityUnitValues" filter="false" />
			</select>
			</td>
		</tr>
		
		<tr>
			<td colspan="4" class="TITLE" width="25%">Rate Details</td>
		</tr>
		<tr>
			<td class="LABEL" width="25%">Currency Code</td>
			<td class="CONTROL" width="25%"><select name="strCurrencyCode"
				class="comboNormal" onchange="isCurrencyMandatory(this);">
				<bean:write name="itemInventoryTransBean"
					property="strCurrencyCodeValues" filter="false" />
			</select></td>

			<td class="LABEL" width="25%"><logic:equal
				name="itemInventoryTransBean" property="strCurrencyCode"
				value="${itemInventoryTransBean.strDefaultCurrencyCode}">
				<div id="currencyDivId">Currency Value</div>
				<input type="hidden" name="isCurrencyReq" value="0">
			</logic:equal> <logic:notEqual name="itemInventoryTransBean"
				property="strCurrencyCode"
				value="${itemInventoryTransBean.strDefaultCurrencyCode}">
				<div id="currencyDivId"><font color="red">*</font>Currency
				Value</div>
				<input type="hidden" name="isCurrencyReq" value="1">
			</logic:notEqual></td>

			<td class="CONTROL" width="25%"><logic:equal
				name="itemInventoryTransBean" property="strCurrencyCode"
				value="${itemInventoryTransBean.strDefaultCurrencyCode}">
				<input type="text" name="strCurrencyValue" maxlength="8"
					class="txtFldNormal" onkeypress="return validateData(event,7);"
					disabled="disabled"
					value="${itemInventoryTransBean.strCurrencyValue}" />
			</logic:equal> <logic:notEqual name="itemInventoryTransBean"
				property="strCurrencyCode"
				value="${itemInventoryTransBean.strDefaultCurrencyCode}">
				<input type="text" name="strCurrencyValue" maxlength="8"
					class="txtFldNormal" onkeypress="return validateData(event,7);"
					value="${itemInventoryTransBean.strCurrencyValue}" />
			</logic:notEqual></td>

		</tr>

		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Rate/Unit
			</td>

			<td class="CONTROL" colspan="1" width="25%"><input type="text"
				name="strRate" maxlength="14" class="txtFldNormal" 
				value="${itemInventoryTransBean.strRate}"
				onkeypress="return validateData(event,7);" /></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Unit
			Name</td>
			<td class="CONTROL" width="25%"><select name="strUnitRateID" 
				class='comboNormal'>
				<bean:write name="itemInventoryTransBean"
					property="strRateUnitValues" filter="false" />
			</select></td>

		</tr>
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Issue Rate/Unit</td>

			<td class="CONTROL" width="25%"><input type="text"
				name="strSalePrice" maxlength="14" class="txtFldNormal" 
				value="${itemInventoryTransBean.strSalePrice}"
				onkeypress="return validateData(event,7);" /></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Unit
			Name</td>
			<td class="CONTROL" width="25%"><select name="strUnitSaleID" 
				class='comboNormal'>
				<bean:write name="itemInventoryTransBean" 
					property="strSalesRateUnitValues" filter="false" />
			</select></td>


		</tr>

		<tr>
			<td colspan="4" class="TITLE" width="25%">P.O. Details</td>
		</tr>

		<tr>

			<td class="LABEL" width="25%">P.O. No.</td>
			<td class="CONTROL" width="25%"><input type="text"
				value="${itemInventoryTransBean.strPoNo}" name="strPoNo"
				maxlength="11" class="txtFldMax"
				onkeypress="return validateData(event,5);" /></td>

			<td class="LABEL" width="25%">P.O.
			Date</td>
			<td class="CONTROL" width="25%"><dateTag:date name="strPoDate"
				value="${itemInventoryTransBean.strPoDate}"></dateTag:date></td>

		</tr>
	<tr>

			<td class="LABEL" width="25%">Bill No.</td>
			<td class="CONTROL" width="25%"><input type="text"
				name="strBillNo" maxlength="11" class="txtFldMax"
				onkeypress="return validateData(event,5);" value="${itemInventoryTransBean. strBillNo}"/></td>

			<td class="LABEL" width="25%">Bill Date</td>
			<td class="CONTROL" width="25%"><dateTag:date name="strBillDate"
				value="${itemInventoryTransBean. strBillDate}"></dateTag:date></td>

		</tr>
		<tr>

			<td class="LABEL" width="25%"><font color="red">*</font>Received
			Date</td>
			<td class="CONTROL" width="25%"><dateTag:date
				name="strReceivedDate"
				value="${itemInventoryTransBean.strReceivedDate}"></dateTag:date></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Supplied
			By</td>
			<td class="CONTROL" width="25%"><select name="strSuppliedBy"
				class="comboMax">
				<bean:write name="itemInventoryTransBean"
					property="strSuppliedByValues" filter="false" />
			</select></td>

		</tr>

	</table>

	<logic:equal name="itemInventoryTransBean" property="strWarrantyFlag"
		value="1">

		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
			cellspacing="1px">

			<tr>
				<td colspan="4" class="TITLE" width="25%"><html:checkbox
					property="strIsWarrantyDetails" name="itemInventoryTransBean"
					value="1" onclick="showOrHideDetails(this,'warrantyItemDtlsDivId');">Whether Warranty Details Required</html:checkbox>
				</td>
			</tr>
		</table>

<div id="warrantyItemDtlsDivId" style="display: none">
<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
			cellspacing="1px">
			<tr>
				<td class="LABEL" width="25%"><font color="red">*</font>Warranty
				Date</td>
				<td class="CONTROL" width="25%"><dateTag:date
					name="strWarrantyDate" value="${itemInventoryTransBean.strWarrantyDate}"></dateTag:date></td>
				<td class="LABEL" width="25%"><font color="red">*</font>Manufacturer</td>
				<td class="CONTROL" width="25%">
				<div id="warrantyManufDivId"><select
					name="strWarantyManufacturer" class="comboMax">
				<bean:write name="itemInventoryTransBean" property="strManufactureCombo" filter="false"/>
				</select></div>
				</td>
			</tr>

			<tr>
				<td class="LABEL" width="25%"><font color="red">*</font>Warranty
				Upto</td>
				<td class="CONTROL" width="25%"><input type="text"
					name="strWarrantyUpTo" class="txtFldMin" value="${itemInventoryTransBean.strWarrantyUpTo}" maxlength="3"
					onkeypress="return validateData(event, 5);"></td>
				<td class="LABEL" width="25%"><font color="red">*</font>Unit</td>
				<td class="CONTROL" width="25%"><html:select
					name="itemInventoryTransBean" styleClass="comboMin"
					property="strWarrantyUpToUnit">
					<html:option value="0">Select Value</html:option>
					<html:option value="1">Day(s)</html:option>
					<html:option value="2">Month(s)</html:option>
					<html:option value="3">Year(s)</html:option>
				</html:select></td>
			</tr>
			<tr>
				<td class="LABEL" colspan="2">Remarks</td>
				<td class="CONTROL" colspan="2"><textarea rows="2" cols="25"
					name="strWarrantyRemarks"><bean:write name="itemInventoryTransBean" property="strWarrantyRemarks"/> </textarea></td>
			</tr>

		</table>
		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
			cellspacing="1px">

			<tr>
				<td colspan="4" class="TITLE" width="25%"></td>
			</tr>
		</table>

		</div>		


	</logic:equal>


	<logic:equal name="itemInventoryTransBean" property="strInstallFlag"
		value="1">

		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
			cellspacing="1px">

			<tr>
				<td colspan="4" class="TITLE" width="25%">
				<html:checkbox property="strIsInstallDetails" name="itemInventoryTransBean" value="1" onclick="showOrHideDetails(this,'installItemDtlsDivId');">Whether Install Details Required</html:checkbox> 
				</td>
			</tr>
		</table>



		<div id="installItemDtlsDivId" style="display: none">

		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
			cellspacing="1px">
			<tr>
				<td class="LABEL" width="25%">Installation Start Date</td>
				<td class="CONTROL" width="25%"> <dateTag:date name="strInstallStartDate" value="${itemInventoryTransBean.strInstallStartDate}"></dateTag:date> </td>
				<td class="LABEL" width="25%">Installation End Date</td>
				<td class="CONTROL" width="25%"><dateTag:date name="strInstallEndDate" value="${itemInventoryTransBean.strInstallEndDate}"></dateTag:date>  </td>
			</tr>

			<tr>
				<td class="LABEL" width="25%">Installation Status</td>
				<td class="CONTROL" width="25%"> <html:select property="strInstallStatus" name="itemInventoryTransBean" styleClass="comboNormal">
				<html:option value='0'>Select Value</html:option>
				<html:option value='1'>Success</html:option>
				<html:option value='2'>Failure</html:option>
				</html:select> </td>
				<td class="LABEL" width="25%">Installed By</td>
				<td class="CONTROL" width="25%"> <input type="text" class="txtFldMax" name="strInstallBy" maxlength="100" value="${itemInventoryTransBean.strInstallBy}"> </td>
			</tr>
			
			<tr>
				<td class="LABEL" width="25%">Installer Contact No.</td>
				<td class="CONTROL" width="25%"> <input type="text" name="strInstallerContactNo" class="txtFldNormal" maxlength="10" value="${itemInventoryTransBean.strInstallerContactNo}"> </td>
				<td class="LABEL" width="25%">Remarks</td>
				<td class="CONTROL" width="25%"><textarea rows="2" cols="25" name="strInstallRemarks" ><bean:write property="strInstallRemarks" name="itemInventoryTransBean" filter="false"/></textarea> </td>
			</tr>

		</table>

		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
			cellspacing="1px">

			<tr>
				<td colspan="4" class="TITLE" width="25%"></td>
			</tr>
		</table>

		</div>

	</logic:equal>

	<%--
	Free Item will not be treated in this way, any more.
	Suggested by: Amit Kumar
	Changed by: Aritra 
	--%>
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px" style="display: none;" >

		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="freeItemDtlsDivIdPlusId" align="left"
				style="display: block;"><img
				src="../../hisglobal/images/plus.gif"
				onClick="getOtherItemsModifyView('1'),showView('freeItemDtlsDivId');"
				style="cursor: pointer; " /> Free Items</div>
			<div id="freeItemDtlsDivIdMinusId" style="display: none;"
				align="left"><img src="../../hisglobal/images/minus.gif"
				onClick="hideView('freeItemDtlsDivId');"
				style="cursor: pointer; " /> Free Items</div>
			</td>
		</tr>
	</table>



	<div id="freeItemDtlsDivId" style="display: none">

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr>

			<td class="multiLabel" width="20%">Item Name</td>
			<td class="multiLabel" width="20%">Batch No.</td>
			<td class="multiLabel" width="20%">Expiry Date</td>
			<td class="multiLabel" width="20%">Qty.</td>
			<td class="multiLabel" width="5%">&nbsp;&nbsp;</td>
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

	<%--
	Component Item will not be treated in this way, any more.
	Suggested by: Amit Kumar
	Changed by: Aritra 
	--%>
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px" style="display: none;">

		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="partItemDtlsDivIdPlusId" align="left"
				style="display: block;"><img
				src="../../hisglobal/images/plus.gif"
				onClick="getOtherItemsModifyView('2'),showView('partItemDtlsDivId');"
				style="cursor: pointer; " /> Component Items</div>
			<div id="partItemDtlsDivIdMinusId" style="display: none;"
				align="left"><img src="../../hisglobal/images/minus.gif"
				onClick="hideView('partItemDtlsDivId');"
				style="cursor: pointer; " /> Component Items <br/> </div>
			</td>
		</tr>
	</table>



	<div id="partItemDtlsDivId" style="display: none">

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr>

			<td class="multiLabel" width="15%">Component Type</td>
			<td class="multiLabel" width="15%">Item Name</td>
			<td class="multiLabel" width="15%">Batch No.</td>
			<td class="multiLabel" width="15%">Manufacturer</td>
			<td class="multiLabel" width="15%">Expiry Date</td>
			<td class="multiLabel" width="20%">Qty.</td>
			<td class="multiLabel" width="5%">&nbsp;&nbsp;</td>
		</tr>
	</table>
	<div id="id2"></div>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr>
			<td colspan="4" class="TITLE" width="25%"></td>
		</tr>
		<tr>

			<td align="center"><img style="cursor: pointer; "
				src="../../hisglobal/images/btn-add.png" onClick="addPartItems();" />
			</td>
		</tr>

	</table>

	</div>

<%--
	Component Item will not be treated in this way, any more.
	Suggested by: Amit Kumar
	Changed by: Aritra 
	--%>
<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px" style="display: none;">

		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="paramItemDtlsDivIdPlusId" align="left"
				style="display: block;"><img
				src="../../hisglobal/images/plus.gif"
				onClick="showView('paramItemDtlsDivId');"
				style="cursor: pointer; " /> Parameter Details</div>
			<div id="paramItemDtlsDivIdMinusId" style="display: none;"
				align="left"><img src="../../hisglobal/images/minus.gif"
				onClick="hideView('paramItemDtlsDivId');"
				style="cursor: pointer; " /> Parameter Details</div>
			</td>
		</tr>
	</table>



	<div id="paramItemDtlsDivId" style="display: none">

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr>
			<td colspan="4" class="TITLE" width="25%"></td>
		</tr>

		<tr>

			<td align="center"><img src="../../hisglobal/images/add_parameter.GIF" onclick="checkForPopup(this,document.forms[0].strItemCategoryNo.value , '2')" style="cursor: pointer; ">
			</td>
		</tr>

	</table>

	</div>


	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr class="FOOTER">
			<td><font size="2" color="red">*</font>
			Mandatory Fields  , ['*'] Reserved/Branded Item</td>
		</tr>
	</table>

	<!-- <table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr>

			<td align="center"><img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png"
				onClick="validatemodify();" title="Click to Save Record"/> <img
				style="cursor: pointer; "
				src="../../hisglobal/images/back_tab.png"
				onClick="cancelPage('LIST');" title="Click to Return On Desk"/></td>
		</tr>
	</table>-->
	<br>
	<div align="center" id=" ">					 
					 	<a href="#" class="button" id=" " onclick='validatemodify();'><span class="save">Save</span></a>
						<a href="#" class="button" onclick="cancelPage('LIST');"><span class="cancel">Cancel</span></a>
				</div> 
    
	<input type="hidden" name="strStoreId"
		value="${itemInventoryTransBean.combo[0]}" />
	<input type="hidden" name="strStoreName"
		value="${itemInventoryTransBean.strStoreName}" />
	<input type="hidden" name="strGroupId"
		value="${itemInventoryTransBean.combo[1]}" />
	<input type="hidden" name="strGroupName"
		value="${itemInventoryTransBean.strGroupName}" />
	<input type="hidden" name="strCtDate"
		value="${itemInventoryTransBean.strCtDate}">

<input type="hidden" name="strSerialNo"
		value="${itemInventoryTransBean.strSerialNo}">

	<input type="hidden" name="strItemCategoryNo"
		value="${itemInventoryTransBean.strItemCategoryNo}" />
	<input type="hidden" name="strItemCategoryName"
		value="${itemInventoryTransBean.strItemCategoryName}" />

	<input type="hidden" name="strDefaultCurrencyCode"
		value="${itemInventoryTransBean.strDefaultCurrencyCode}">

	<input type="hidden" name="strChk"
		value="${itemInventoryTransBean.strChk }">
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strItemSpecification"
		value="${itemInventoryTransBean.strItemSpecification }">
	<input type="hidden" name="strManufactureId"
		value="${itemInventoryTransBean.strManufactureId }">
		
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

<div class="popUpDiv" id="popUpDivId" style="display:none;">
<table bgcolor="white">
<tr>
<td>
<div id="itemParameterDtlDivId" style="display:block;"></div>
</td>
</tr>
</table>
</div>


</html:form>

<jsp:include page="itemInventory_multirow_mmstrans.jsp"></jsp:include>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>















