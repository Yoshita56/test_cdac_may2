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

<script language="JavaScript" src="../js/receivedItemDetails.js"></script>

<script language="JavaScript" src="../js/item_OtherDtls_util.js"></script>

<script language="Javascript" src="../js/itemparameterdetails_util.js"></script>


</head>

<body onload="InitialProcess();">
<html:form name="receiveFromThirdPartyTransBean"
	action="/transactions/ReceiveFromThirdPartyTransCNT"
	type="mms.transactions.controller.fb.ReceiveFromThirdPartyTransFB">


	<div class="errMsg" id="errMsg"><bean:write
		name="receiveFromThirdPartyTransBean" property="strErrMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="receiveFromThirdPartyTransBean" property="strWarningMsg" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="receiveFromThirdPartyTransBean" property="strNormalMsg"
		filter="false" /></div>

	<center><tag:tab tabLabel="Received From Third Party Details"
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
				name="receiveFromThirdPartyTransBean" property="strStoreName"
				filter="false" /></td>
			<td width="25%" class="LABEL">Item Category</td>
			<td width="25%" class="CONTROL"><bean:write
				name="receiveFromThirdPartyTransBean" property="strItemCategoryName"
				filter="false" /></td>
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">Institute</td>
			<td width="50%" colspan="2" class="CONTROL"><bean:write
				name="receiveFromThirdPartyTransBean" property="strInstituteName"
				filter="false" /></td>
		</tr>
        </table>
        
        <table class='TABLEWIDTH' align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td width="25" class="TITLE">
			<div id="plus" style="display: none"><img
				src="../../hisglobal/images/plus.gif" onclick="showinfo();"></div>
			<div id="minus" style="display: block"><img
				src="../../hisglobal/images/minus.gif" onclick="hideinfo();"></div>
			</td>
			<td colspan="4">Received Item Information</td>

		  </tr>
	   </table>
        <div id="demographicInfo" style="display:none" align="center">
             <bean:write name="receiveFromThirdPartyTransBean" property="strItemHlp" filter="false" />
        </div>
        <table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px"> 
		
		<tr>
			<td width="25%" class="LABEL">Remarks</td>
			<td width="25%" class="CONTROL"><bean:write
				name="receiveFromThirdPartyTransBean" property="strRemarks"
				filter="false" /></td>
			<td class="LABEL"><font color="red">*</font>Stock Status</td>
			<td class="CONTROL"><select name="strStockStatus"
				class="comboNormal">
				<bean:write name="receiveFromThirdPartyTransBean"
					property="strStockStatusValues" filter="false" />
			</select></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Group
			Name</td>
			<td class="CONTROL" width="25%"><select name="strGroupId"
				onchange="getSubGroupListDtls(this);" class="comboNormal">
				<bean:write name="receiveFromThirdPartyTransBean"
					property="strGroupCombo" filter="false" />
			</select></td>
			<td class="LABEL" width="25%">Sub Group Name</td>
			<td class="CONTROL" width="25%">
			<div id="subGroupComboDivID"><select name="strSubGroupId"
				class="comboNormal" onChange="ajaxItemName('ITEMNAME');">
				<option value="0">All</option>
			</select></div>
			</td>


		</tr>


		<tr>

			<td class="LABEL" width="25%"><font color="red">*</font>Generic
			Item Name</td>
			<td class="CONTROL" width="25%">
			<div id="ItemNameId"><select name="strItemId"
				class='comboNormal' onChange="ajaxItemBrandName('ITEMBRANDNAME')">
				<option value="0">Select Value</option>
			</select></div>
			</td>

			<td class="LABEL" width="25%"><font color="red">*</font>Item
			Name</td>
			<td class="CONTROL" width="25%">
			<div id="ItemBrandId"><select name="strItemBrandId"
				class='comboNormal'>
				<%-- onchange="ajaxManufectureName('MANUFECTURENAME');">--%>
				<option value="0">Select Value</option>
			</select></div>
			</td>

		</tr>


		<tr>

			<td class="LABEL">
<div id="manfNotMandatoryDivId" style="display: none;">Manufacture</div>
			<div id="manfMandatoryDivId" style="display: block;"><font color="red">*</font>Manufacture</div>				
			
</td>
			<td width="25%" class="CONTROL">
			<div id="manufDivId"><select class="comboMax"
				name="strManufactureId">
				<option value='0'>Select Value</option>
			</select></div>
			</td>
			<td class="LABEL">
			<div id="batchNoDivId">Batch No.</div>
			<input type="hidden" name="isBatchReq" value="0"></td>

			<td class="CONTROL" width="25%"><input type="text"
				name="strBatchNo" maxlength="30" class="txtFldMax"
				onkeypress="return validateData(event,17);" /></td>

		</tr>


		<tr>
			<td class="LABEL">
			<div id="expiryDateDivId">Expiry Date</div>
			<input type="hidden" name="isExpirtReq" value="0"></td>

			<td class="CONTROL" width="25%"><dateTag:date
				name="strExpiryDate" value=""></dateTag:date></td>
			<td class="LABEL" width="25%">Manufacture Date</td>
			<td class="CONTROL" width="25%"><dateTag:date
				name="strManufactureDate"
				value="${receiveFromThirdPartyTransBean.strCtDate}"></dateTag:date></td>

		</tr>

		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Received
			Quantity</td>

			<td class="CONTROL" width="25%"><input type="text"
				name="strInHandQuantity" maxlength="8" class="txtFldMin"
				onkeyup="return validateQty('strInHandQuantity','strInHandQuantityUnitID');"
				onkeypress="return validateData(event,7);" value="1" /></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Received
			Quantity Unit</td>
			<td class="CONTROL" width="25%">
			<div id="freeItemUnit"><select name="strInHandQuantityUnitID"
				onchange="return validateQty('strInHandQuantity','strInHandQuantityUnitID');"
				class='comboNormal'>
				<option value="0">Select Value</option>
			</select></div>
			</td>
		</tr>
<tr>
		<td colspan="2" class="LABEL">
		<div id="specNotMandatoryDivId" style="display: none;">Specification</div>
			<div id="specMandatoryDivId" style="display: block;"><font color="red">*</font>Specification</div>	
		 
		</td>
		<td colspan="2" class="CONTROL"><textarea rows="2" cols="40" name="strItemSpecification"></textarea>
		</td>
		</tr>
		<tr>
			<td colspan="4" class="TITLE" width="25%">Rate Details</td>
		</tr>
		<tr>
			<td class="LABEL" width="25%">Currency Code</td>
			<td class="CONTROL" width="25%"><select name="strCurrencyCode"
				class="comboNormal" onchange="isCurrencyMandatory(this);">
				<bean:write name="receiveFromThirdPartyTransBean"
					property="strCurrencyCodeValues" filter="false" />
			</select></td>

			<td class="LABEL" width="25%">
			<div id="currencyDivId">Currency Value</div>
			<input type="hidden" name="isCurrencyReq" value="0"></td>

			<td class="CONTROL" colspan="1" width="25%"><input type="text"
				name="strCurrencyValue" maxlength="8" class="txtFldNormal"
				onkeypress="return validateData(event,7);" value="1"
				disabled="disabled" /></td>

		</tr>
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Rate/Unit
			</td>

			<td class="CONTROL" colspan="1" width="25%"><input type="text"
				name="strRate" maxlength="14" class="txtFldNormal"
				onkeypress="return validateData(event,7);" /></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Unit
			Name</td>
			<td class="CONTROL" width="25%">
			<div id="UnitRateID"><select name="strUnitRateID"
				class='comboNormal'>
				<option value="0">Select Value</option>
			</select></div>
			</td>

		</tr>
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Issue Rate/Unit (INR)</td>
			<td class="CONTROL" width="25%"><input type="text"
				name="strSalePrice" maxlength="14" class="txtFldNormal"
				onkeypress="return validateData(event,7);" /></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Unit
			Name</td>
			<td class="CONTROL" width="25%">

			<div id="UnitRateID1"><select name="strUnitSaleID"
				class='comboNormal'>
				<option value="0">Select Value</option>
			</select></div>

			</td>
		</tr>



		<tr>

			<td class="LABEL" width="25%"><font color="red">*</font>Received
			Date</td>
			<td class="CONTROL" width="25%"><dateTag:date
				name="strReceivedDate"
				value="${receiveFromThirdPartyTransBean.strCtDate}"></dateTag:date></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Supplied
			By</td>
			<td class="CONTROL" width="25%"><select name="strSuppliedBy"
				class="comboMax">
				<bean:write name="receiveFromThirdPartyTransBean"
					property="strSuppliedByValues" filter="false" />
			</select></td>

		</tr>



	</table>

	<logic:equal name="receiveFromThirdPartyTransBean"
		property="strWarrantyFlag" value="1">

		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
			cellspacing="1px">

			<tr>
				<td colspan="4" class="TITLE" width="25%"><html:checkbox
					property="strIsWarrantyDetails" name="receiveFromThirdPartyTransBean"
					value="1"
					onclick="showOrHideDetails(this,'warrantyItemDtlsDivId');">Whether Warranty Details Required</html:checkbox>
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
					name="strWarrantyDate"></dateTag:date></td>
				<td class="LABEL" width="25%"><font color="red">*</font>Manufacture</td>
				<td class="CONTROL" width="25%">
				<div id="warrantyManufDivId"><select
					name="strWarantyManufacturer" class="comboMax">
					<option value='0'>Select Value</select></div>
				</td>
			</tr>

			<tr>
				<td class="LABEL" width="25%"><font color="red">*</font>Warranty
				Upto</td>
				<td class="CONTROL" width="25%"><input type="text"
					name="strWarrantyUpTo" class="txtFldMin" maxlength="3"
					onkeypress="return validateData(event, 5);"></td>
				<td class="LABEL" width="25%"><font color="red">*</font>Unit</td>
				<td class="CONTROL" width="25%"><select
					name="strWarrantyUpToUnit" class="comboMin">
					<option value="0">Select Value</option>
					<option value="1">Day(s)</option>
					<option value="2">Month(s)</option>
					<option value="3">Year(s)</option>
				</select></td>
			</tr>
			<tr>
				<td class="LABEL" colspan="2">Remarks</td>
				<td class="CONTROL" colspan="2"><textarea rows="2" cols="25"
					name="strWarrantyRemarks"></textarea></td>
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

	<logic:equal name="receiveFromThirdPartyTransBean"
		property="strInstallFlag" value="1">

		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
			cellspacing="1px">

			<tr>
				<td colspan="4" class="TITLE" width="25%"><html:checkbox
					property="strIsInstallDetails" name="receiveFromThirdPartyTransBean"
					value="1" onclick="showOrHideDetails(this,'installItemDtlsDivId');">Whether Install Details Required</html:checkbox>
				</td>
			</tr>
		</table>



		<div id="installItemDtlsDivId" style="display: none">

		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
			cellspacing="1px">
			<tr>
				<td class="LABEL" width="25%"><font color="red">*</font>Installation
				Start Date</td>
				<td class="CONTROL" width="25%"><dateTag:date
					name="strInstallStartDate"></dateTag:date></td>
				<td class="LABEL" width="25%"><font color="red">*</font>Installation
				End Date</td>
				<td class="CONTROL" width="25%"><dateTag:date
					name="strInstallEndDate"></dateTag:date></td>
			</tr>

			<tr>
				<td class="LABEL" width="25%"><font color="red">*</font>Installation
				Status</td>
				<td class="CONTROL" width="25%"><select name="strInstallStatus"
					class="comboNormal">
					<option value='0'>Select Value</option>
					<option value='1'>Success</option>
					<option value='2'>Failure</option>
				</select></td>
				<td class="LABEL" width="25%"><font color="red">*</font>Installed
				By</td>
				<td class="CONTROL" width="25%"><input type="text"
					class="txtFldMax" name="strInstallBy"
					onkeypress="return validateData(event, 4);" maxlength="100">
				</td>
			</tr>

			<tr>
				<td class="LABEL" width="25%"><font color="red">*</font>Installer
				Contact No.</td>
				<td class="CONTROL" width="25%"><input type="text"
					name="strInstallerContactNo"
					onkeypress="return validateData(event, 2);" class="txtFldNormal"
					maxlength="10"></td>
				<td class="LABEL" width="25%">Remarks</td>
				<td class="CONTROL" width="25%"><textarea rows="2" cols="25"
					name="strInstallRemarks"></textarea></td>
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

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="freeItemDtlsDivIdPlusId" align="left"
				style="display: block;"><img
				src="../../hisglobal/images/plus.gif"
				onClick="showView('freeItemDtlsDivId');"
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
			<td class="multiLabel" width="5%"></td>
		</tr>
	</table>
	<div id="id1"></div>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr>
			<td colspan="4" class="TITLE" width="25%"></td>
		</tr>

		<tr align="center">

			<!-- <td align="center"><img style="cursor: pointer; " src="../../hisglobal/images/btn-add.png" onClick="addFreeItems();" /> -->
			<td align="center">
			<a href="#" class="button"	onclick="addFreeItems();"><span class="add">Add</span></a> 
			</td>
		</tr>

	</table>

	</div>


	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="partItemDtlsDivIdPlusId" align="left"
				style="display: block;"><img
				src="../../hisglobal/images/plus.gif"
				onClick="showView('partItemDtlsDivId');"
				style="cursor: pointer; " /> Part Items</div>
			<div id="partItemDtlsDivIdMinusId" style="display: none;"
				align="left"><img src="../../hisglobal/images/minus.gif"
				onClick="hideView('partItemDtlsDivId');"
				style="cursor: pointer; " /> Part Items</div>
			</td>
		</tr>
	</table>



	<div id="partItemDtlsDivId" style="display: none">

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr>

			<td class="multiLabel" width="20%">Item Name</td>
			<td class="multiLabel" width="20%">Batch No.</td>
			<td class="multiLabel" width="20%">Manufacturer</td>
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

		<tr align="center">

			<!-- <td align="center"><img style="cursor: pointer; "src="../../hisglobal/images/btn-add.png" onClick="addPartItems();" /> -->
			<td align="center">
			<a href="#" class="button"	onclick="addPartItems();"><span class="add">Add</span></a>
			</td>
		</tr>

	</table>

	</div>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

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

			<!-- <td align="center"><img
				src="../../hisglobal/images/add_parameter.GIF"
				onclick="checkForPopup(this,document.forms[0].strItemCategoryNo.value , '1')"
				style="cursor: pointer; "></td> -->
				<td align="center">
			<a href="#" class="button"	onclick="checkForPopup(this,document.forms[0].strItemCategoryNo.value , '1')"><span class="add">Add</span></a>
			</td>
		</tr>

	</table>

	</div>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">	


		<tr class="FOOTER">
			<td colspan="4" width="25%"><font size="2" color="red">*</font>
			Mandatory Fields</td>
		</tr>
	</table>
	<!-- <table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr>

			<td align="center"><img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" onClick="validate1();" />
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-clr.png"
				onClick="document.forms[0].reset();" /> <img
				style="cursor: pointer; "
				src="../../hisglobal/images/btn-ccl.png"
				onClick="cancelViewPage();" /></td>
		</tr>



	</table>-->
	<br>
	<div align="center" id="saveId">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="document.forms[0].reset();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelViewPage();"><span class="cancel">Cancel</span></a>
					</div> 

	<input type="hidden" name="strStoreId"
		value="${receiveFromThirdPartyTransBean.strStoreId}" />


	<input type="hidden" name="strItemCategoryNo"
		value="${receiveFromThirdPartyTransBean.strItemCategoryNo}" />



<input type="hidden" name="strInstituteId"
		value="${receiveFromThirdPartyTransBean.strInstituteId}" />

	<input type="hidden" name="strRemarks"
		value="${receiveFromThirdPartyTransBean.strRemarks}" />


	<input type="hidden" name="strCtDate"
		value="${receiveFromThirdPartyTransBean.strCtDate}">

	<input type="hidden" name="strDefaultCurrencyCode"
		value="${receiveFromThirdPartyTransBean.strDefaultCurrencyCode}">

<input type="hidden" name="strRegFlag" value="" />

<input type="hidden"  name="strIssueRateConfigFlg"  value="${receiveFromThirdPartyTransBean.strIssueRateConfigFlg}">

	<input type="hidden" name="hmode" />



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

	<div class="popUpDiv" id="popUpDivId" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			<div id="itemParameterDtlDivId" style="display: block;"></div>
			</td>
		</tr>
	</table>
	</div>

	<cmbPers:cmbPers />
</html:form>

<jsp:include page="itemInventory_multirow_mmstrans.jsp"></jsp:include>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>








