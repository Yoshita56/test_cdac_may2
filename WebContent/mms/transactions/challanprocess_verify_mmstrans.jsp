<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<!--  Developer : Balasubramaniam M
	  Version	: 1.0	 
	  Date 		: 12-Jun-2009
	  Module 	: Mms
	  Process	: Challan Process
-->

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>



<html>
<head>
<meta charset=UTF-8">
<title>Challan Verify</title>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">	


<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script language="Javascript" src="../js/challanprocess_mmstrans.js"></script>


<script language="JavaScript" src="../js/item_OtherDtls_util.js"></script>

<script language="Javascript" src="../js/itemparameterdetails_util.js"></script>

</head>

<body onLoad="calcIssueRateTwo();">
<html:form name="challanProcessBean"
	action="/transactions/ChallanProcessTransCNT"
	type="mms.transactions.controller.fb.ChallanProcessTransFB" enctype="multipart/form-data">

	<div class="errMsg" id="errMsg"><bean:write
		name="challanProcessBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="challanProcessBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="challanProcessBean" property="strMsg" /></div>

	<center><tag:tab tabLabel="Challan Process "
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>


	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		
	</table>
	
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">

	<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="poDtlsDivIdPlusId" align="left" style="display: block;">
			<img src="../../hisglobal/images/plus.gif"
				onClick="showView('poDtlsDivId' );"
				style="cursor: pointer; " /> P.O. Details </div>
			<div id="poDtlsDivIdMinusId" style="display: none;" align="left">
			<img src="../../hisglobal/images/minus.gif"
				onClick="hideView('poDtlsDivId');"
				style="cursor: pointer; " /> P.O. Details</div>
			</td>
		</tr>
</table>	
	
	<div id="poDtlsDivId" style="display:none">
		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td class="LABEL" width="25%">P.O. No.</td>
			<td class="CONTROL" width="25%"><bean:write name="challanProcessBean" property="strPoNoDisplay"/> </td>

			<td class="LABEL" width="25%">P.O. Date</td>
			<td class="CONTROL" width="25%"><bean:write name="challanProcessBean" property="strPoDate"/>
			</td>
		</tr>


		<tr>
			<td class="LABEL" width="25%">P.O. Type</td>
			<td class="CONTROL" width="25%"><bean:write name="challanProcessBean" property="strPoType"/></td>

			<td class="LABEL">Supplier Name</td>
			<td width="25%" class="CONTROL"><bean:write name="challanProcessBean" property="strSupplierName"/></td>
		</tr>

	<tr>
	
	<td class="LABEL" width="25%">Item Category</td>
			<td class="CONTROL" colspan="3" width="75%"><bean:write name="challanProcessBean" property="strItemCategoryName"/></td>
	
	</tr>

<tr>
			<td class="LABEL" width="25%">Currency Name</td>
			<td class="CONTROL" width="25%"><bean:write name="challanProcessBean" property="strCurrencyName"/></td>

			<td class="LABEL">Currency Value</td>
			<td width="25%" class="CONTROL"><bean:write name="challanProcessBean" property="strCurrencyValue"/></td>
		</tr>
		
</table>
</div>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">

	<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="challanDtlsDivIdPlusId" align="left" style="display: block;">
			<img src="../../hisglobal/images/plus.gif"
				onClick="showView('challanDtlsDivId' );"
				style="cursor: pointer; " /> Challan Details </div>
			<div id="challanDtlsDivIdMinusId" style="display: none;" align="left">
			<img src="../../hisglobal/images/minus.gif"
				onClick="hideView('challanDtlsDivId');"
				style="cursor: pointer; " /> Challan Details</div>
			</td>
		</tr>
</table>	
	
	<div id="challanDtlsDivId" style="display:none">
		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td class="LABEL" width="25%">Challan No.</td>
			<td class="CONTROL" width="25%"><bean:write name="challanProcessBean" property="strChallanNo"/></td>

			<td class="LABEL" width="25%">Schedule No.</td>
			<td class="CONTROL" width="25%"><bean:write name="challanProcessBean" property="strScheduleNo"/>
			</td>
		</tr>


		<tr>
			<td class="LABEL" width="25%">Receive Date</td>
			<td class="CONTROL" width="25%"><bean:write name="challanProcessBean" property="strDeliveryDate"/></td>

			<td class="LABEL">Actual Delivery Date</td>
			<td width="25%" class="CONTROL"><bean:write name="challanProcessBean" property="strActualDeliveryDate"/></td>
		</tr>

<tr>
			<td class="LABEL" width="25%">Schedule Type</td>
			<td class="CONTROL" colspan="3" width="75%"><bean:write name="challanProcessBean" property="strScheduleType"/></td>
		</tr>
		
</table>
</div>


<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		
		<tr>
			<td class="LABEL" width="25%">Group Name</td>
			<td class="CONTROL" width="25%"><bean:write name="challanProcessBean" property="strGroupName"/></td>

			<td class="LABEL" width="25%">Sub Group Name</td>
			<td class="CONTROL" width="25%"><bean:write name="challanProcessBean" property="strSubGroupName"/>
			</td>
		</tr>


		<tr>
			<td class="LABEL" width="25%">Generic Name</td>
			<td class="CONTROL" width="25%"><bean:write name="challanProcessBean" property="strGenericItemName"/></td>

			<td class="LABEL">Item Name</td>
			<td width="25%" class="CONTROL"><bean:write name="challanProcessBean" property="strItemBrandName"/></td>
		</tr>

		<tr>
			<td class="LABEL" width="25%">Rate/Unit</td>
			<td class="CONTROL" colspan="3" width="25%"><bean:write name="challanProcessBean" property="strRateView"/></td>
		</tr>
				
		<tr>
			<td class="LABEL" width="25%">Manufacturer Name</td>
			<td class="CONTROL"  width="25%">
			
			<logic:equal name="challanProcessBean" property="strBalanceQuantityView" value="0">
			<select name="strManufacturerId"  class="comboMax"><bean:write name="challanProcessBean" property="strManufacturerValues" filter="false"/></select>
			</logic:equal>
			<logic:notEqual name="challanProcessBean" property="strBalanceQuantityView" value="0">
			<bean:write name="challanProcessBean" property="strManufacturerName"/>
			</logic:notEqual>
						
			</td>
			
			<td width="25%" class="LABEL"> <logic:empty
				name="challanProcessBean" property="strBatchNo">Batch No
				<input type="hidden" name="isBatchReq" value="0">
			</logic:empty> <logic:notEmpty name="challanProcessBean" property="strBatchNo">
				<input type="hidden" name="isBatchReq" value="1"><font color="red">*</font>Batch No
			</logic:notEmpty></td>
			<td class="CONTROL" width="25%"><input type="text" autocomplete = "off"
				name="strBatchNo" maxlength="30" class="txtFldMax"
				onkeypress="return validateData(event,17);" /></td>
		</tr>
		
		<tr>
			
			
			<td class="LABEL" width="25%"><font color="red">*</font>Manufacture Date</td>
			<td class="CONTROL"  width="25%"><dateTag:date name="strManufactureDate" value=""></dateTag:date></td>
			
			<td class="LABEL">
		
			<logic:empty name="challanProcessBean" property="strExpiryDate">
				<input type="hidden" name="isExpirtReq" value="0"><font color="red">*</font>Expiry Date
			</logic:empty>
			 <logic:notEmpty name="challanProcessBean" property="strExpiryDate">
				<input type="hidden" name="isExpirtReq" value="1">Expiry Date
			</logic:notEmpty></td>
			<td class="CONTROL"  width="25%"><dateTag:date name="strExpiryDate" value=""></dateTag:date> </td>
			
		</tr>
		<tr>
		<td class="LABEL" width="25%">Challan Receive Quantity</td>
			<td class="CONTROL" width="25%"><a style="color: blue; font-weight:bold; cursor: pointer;" onclick="getBalanceQtyDtls(this);"><bean:write name="challanProcessBean" property="strReceivedQuantityView"/></a></td>
	
		<td class="LABEL" width="25%">Verified Quantity</td>
			<td class="CONTROL" width="25%"><a style="color: blue; font-weight:bold; cursor: pointer;" onclick="getVerifiedQtyDtls(this);">
			<bean:write name="challanProcessBean" property="strVerifiedQuantityView"/>
			</a></td>
	
		</tr>
		
		<tr>
		    
		    <td class="LABEL" width="25%">Previous Excess Quantity</td>
			<td class="CONTROL" width="25%" ><bean:write name="challanProcessBean" property="strPreviousExcessQtyView"/></td>
			<td class="LABEL" width="25%"></td>
			  <td class="CONTROL" width="25%" ></td>
	
		</tr>
		
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Accepted Quantity</td>
		<td class="CONTROL" width="25%"><input type="text" autocomplete = "off"
				name="strAcceptedQuantity" maxlength="11" class="txtFldNormal"
				onkeypress="return validateData(event,5);"  onBlur="CalculateDrugCost();"  /></td>
			
			<td class="LABEL" width="25%"><font color="red">*</font>Unit Name</td>
			<td class="CONTROL" width="25%">
			<div id="accptedQtyUnitDivId"><select name="strAcceptedQuantityUnitId" onChange="calcIssueRate();"
				class='comboMin'>
			<bean:write name="challanProcessBean" property="strUnitValues" filter="false"/>
			</select></div>
			</td>
		</tr>
				
		<tr>
			<td class="LABEL" width="25%">Rejected Quantity</td>
		<td class="CONTROL" width="25%"><input type="text" value="0" autocomplete = "off"
				name="strRejectedQuantity" maxlength="11" class="txtFldNormal"
				onkeypress="return validateData(event,5);" /></td>
			
			<td class="LABEL" width="25%">Unit Name</td>
			<td class="CONTROL" width="25%">
			<div id="rejectedQtyUnitDivId"><select name="strRejectedQuantityUnitId"
				class='comboMin'>
				<bean:write name="challanProcessBean" property="strUnitValues" filter="false"/>
			</select></div>
			</td>
		</tr>
		<tr>
			<td class="LABEL" width="25%">Breakage Quantity</td>
		<td class="CONTROL" width="25%"><input type="text" value="0" autocomplete = "off"
				name="strBreakageQuantity" maxlength="11" class="txtFldNormal"
				onkeypress="return validateData(event,5);" /></td>
			
			<td class="LABEL" width="25%">Unit Name</td>
			<td class="CONTROL" width="25%">
			<div id="brakageQtyUnitDivId"><select name="strBreakageQuantityUnitId"
				class='comboMin'>
			<bean:write name="challanProcessBean" property="strUnitValues" filter="false"/>
			</select></div>
			</td>
		</tr>
			<tr>
			<td class="LABEL" width="25%">Excess Quantity</td>
		<td class="CONTROL" width="25%"><input type="text" value="0" autocomplete = "off"
				name="strExcessQty" maxlength="11" class="txtFldNormal"
				onkeypress="return validateData(event,5);" /></td>
			
			<td class="LABEL" width="25%">Unit Name</td>
			<td class="CONTROL" width="25%">
			<div id="rejectedQtyUnitDivId"><select name="strExcessQtyUnitId"
				class='comboMin'>
				<bean:write name="challanProcessBean" property="strUnitValues" filter="false"/>
			</select></div>
			</td>
		</tr>
		<tr>
			<td class="LABEL" width="25%">Rack No</td>

			<td class="CONTROL" width="25%">
				<input type="text" autocomplete = "off"
				name="strRackNumber"  class="txtFldMax"
				
				onkeypress="return validateData(event,3);" />
				</td>

			<td class="CONTROL" width="25%"></td>
			<td class="CONTROL" width="25%">
			
			</td>
		</tr>
		
	
		
</table>

<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		
		
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>M.R.P.</td>
		<td class="CONTROL" width="25%"><input type="text"
				name="strSalePrice" maxlength="14" class="txtFldNormal"
				onkeypress="return validateData(event,7);" /></td>
			
			<td class="LABEL" width="25%"><font color="red">*</font>Unit Name</td>
			<td class="CONTROL" width="25%">
			<div id="salePriceUnitDivId"><select name="strSalePriceUnitId"
				class='comboMin'>
				<bean:write name="challanProcessBean" property="strRateUnitValues" filter="false"/>
			</select></div>
			</td>
		</tr>
		
		</table>

<logic:equal name="challanProcessBean" property="strWarrantyFlag"
		value="1">

		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">

	<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="warrantyDtlsDivIdPlusId" align="left" style="display: block;">
			<img src="../../hisglobal/images/plus.gif"
				onClick="showView('warrantyDtlsDivId' );"
				style="cursor: pointer; " /> Warranty Details </div>
			<div id="warrantyDtlsDivIdMinusId" style="display: none;" align="left">
			<img src="../../hisglobal/images/minus.gif"
				onClick="hideView('warrantyDtlsDivId');"
				style="cursor: pointer; " /> Warranty Details</div>
			</td>
		</tr>
</table>	
	
	<div id="warrantyDtlsDivId" style="display:none">
		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		
			<tr>
				<td class="LABEL" width="25%"><font color="red">*</font>Warranty Date</td>
				<td class="CONTROL" width="25%"><dateTag:date
					name="strWarrantyDate" value="${challanProcessBean.strCtDate}"></dateTag:date></td>
				<td class="LABEL" width="25%"><font color="red">*</font>Manufacture</td>
				<td class="CONTROL" width="25%">
				<div id="warrantyManufDivId"><select
					name="strWarantyManufacturer" class="comboMax">
					<bean:write name="challanProcessBean" property="strManufacturerValues" filter="false"/>
				</select></div>
				</td>
			</tr>

			<tr>
				<td class="LABEL" width="25%"><font color="red">*</font>Warranty Upto</td>
				<td class="CONTROL" width="25%"><input type="text"
					name="strWarrantyUpTo" class="txtFldNormal" maxlength="3"
					onkeypress="return validateData(event, 5);"></td>
				<td class="LABEL" width="25%"><font color="red">*</font>Unit</td>
				<td class="CONTROL" width="25%">				<select
					name="strWarrantyUpToUnit" class="comboMin">
					<option value="0">Select Value</option>
					<option value="1">Day(s)</option>
					<option value="2">Month(s)</option>
					<option value="3">Year(s)</option>
				</select></td>
			</tr>
			</table>
		
			<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
			cellspacing="1px">
			<tr>
			<td class="LABEL" colspan="2">Remarks
			</td>
			<td class="CONTROL" colspan="2">
			<textarea rows="2" cols="25" name="strWarrantyRemarks"></textarea>
			</td>
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

	<logic:equal name="challanProcessBean" property="strInstallFlag" value="1">

		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">

	<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="installDtlsDivIdPlusId" align="left" style="display: block;">
			<img src="../../hisglobal/images/plus.gif"
				onClick="showView('installDtlsDivId' );"
				style="cursor: pointer; " /> Installation Details </div>
			<div id="installDtlsDivIdMinusId" style="display: none;" align="left">
			<img src="../../hisglobal/images/minus.gif"
				onClick="hideView('installDtlsDivId');"
				style="cursor: pointer; " /> Installation Details</div>
			</td>
		</tr>
</table>	
	
	<div id="installDtlsDivId" style="display:none">
		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		
			<tr>
				<td class="LABEL" width="25%"><font color="red">*</font>Installation Start Date</td>
				<td class="CONTROL" width="25%"> <dateTag:date name="strInstallStartDate" value="${challanProcessBean.strCtDate}"></dateTag:date> </td>
				<td class="LABEL" width="25%"><font color="red">*</font>Installation End Date</td>
				<td class="CONTROL" width="25%"><dateTag:date name="strInstallEndDate" value="${challanProcessBean.strCtDate}"></dateTag:date>  </td>
			</tr>

			<tr>
				<td class="LABEL" width="25%"><font color="red">*</font>Installation Status</td>
				<td class="CONTROL" width="25%"> <select name="strInstallStatus" class="comboNormal">
				<option value='0'>Select Value</option>
				<option value='1'>Success</option>
				<option value='2'>Failure</option>
				</select> </td>
				<td class="LABEL" width="25%"><font color="red">*</font>Installed By</td>
				<td class="CONTROL" width="25%"> <input type="text" class="txtFldMax" name="strInstallBy" onkeypress="return validateData(event, 4);" maxlength="100"> </td>
			</tr>
			
			<tr>
				<td class="LABEL" width="25%"><font color="red">*</font>Installer Contact No.</td>
				<td class="CONTROL" width="25%"> <input type="text" name="strInstallerContactNo" onkeypress="return validateData(event, 2);" class="txtFldNormal" maxlength="10"> </td>
				<td class="LABEL" width="25%">Remarks</td>
				<td class="CONTROL" width="25%"><textarea rows="2" cols="25" name="strInstallRemarks" ></textarea> </td>
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
<div id="freeItemDtlsDivId" style="display: none">
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

		<tr>

			<td align="center"><img style="cursor: pointer; "
				src="../../hisglobal/images/btn-add.png" onClick="addFreeItems();" />
			</td>
		</tr>

	</table>

	</div>
<logic:notEqual name="challanProcessBean" property="strItemCategoryId" value="10">
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="partItemDtlsDivIdPlusId" align="left"
				style="display: none;"><img
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

<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px" style="display: none;">

		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="paramItemDtlsDivIdPlusId" align="left"
				style="display: none;"><img
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
		cellspacing="1px" style="display: none;">

		<tr>
			<td colspan="4" class="TITLE" width="25%"></td>
		</tr>

		<tr>

			<td align="center" colspan="4"><img src="../../hisglobal/images/add_parameter.GIF" onclick="checkForPopup(this,document.forms[0].strItemCategoryId.value , '1')" style="cursor: pointer; ">
			</td>
		</tr>
<tr>
			<td colspan="4" class="TITLE" width="25%"></td>
		</tr>

	</table>

	</div>

</logic:notEqual>
	

		
		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px" style="display: none;">

		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="supplierItemDtlsDivIdPlusId" align="left"
				style="display:none;"><img
				src="../../hisglobal/images/plus.gif"
				onClick="showView('supplierItemDtlsDivId');"
				style="cursor: pointer; " /> Supplier Performance Detail</div>
			<div id="supplierItemDtlsDivIdMinusId" style="display:none;"
				align="left"><img src="../../hisglobal/images/minus.gif"
				onClick="hideView('supplierItemDtlsDivId');"
				style="cursor: pointer; " /> Supplier Performance Detail</div>
			</td>
		</tr>
	</table>
	
	<div id="supplierItemDtlsDivId" style="display:none;">
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
	        <tr style="display: none;">
				<td class="LABEL" width="50%"><div align="left">1.	Whether Medicines supplied with test report</div></td>
				<td class="CONTROL" width="50%"><input type="radio" name=isTestReport value="1"  onClick="ftnTickOne(1)" />Yes<input type="radio" name=isTestReport value="0" onClick="ftnTickOne(0)" />No</td>
			</tr>
			</table>
			<div id="showReportId" style="display:none;">
			<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"	cellspacing="1px">
			<tr>
				<td class="LABEL" width="50%"><div style="display:none;" align="left">1.	Test Report No. and Date <font color="red">*</font></div></td>
				<td class="CONTROL" width="50%"> <input type="text" class="txtFldMax" name="strReportNumber" id="strReportNumber" onkeypress="return validateData(event,16);" maxlength="25" value="Default">/<dateTag:date name="strReportDate" value="${challanProcessBean.strCtDate}"></dateTag:date>  </td>
			</tr>
            </table>
            </div>
			<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"	cellspacing="1px">
			<tr>
				<td class="LABEL" width="50%"><div style="display:none;" align="left">2.	Whether Medicines/packaging are in good condition</div></td>
				<td class="CONTROL" width="50%"><input type="radio" name="isGoodCond" value="1" onClick="ftnTickTwo(1)" />Yes<input type="radio" name="isGoodCond" value="0" onClick="ftnTickTwo(0)" />No</td>
			</tr>
			<tr>	
				<td class="LABEL" width="50%"><div style="display:none;" align="left">3.	Whether Rajasthan Govt. Supply Not for Sale & Logogram printed</div></td>
				<td class="CONTROL" width="50%"><input type="radio" name="isNotForSale" value="1" onClick="ftnTickThree(1)" />Yes<input type="radio" name="isNotForSale" value="0" onClick="ftnTickThree(0)" />No</td>
			</tr>
			
			<tr>
				<td class="LABEL" width="50%"><div  style="display:none;" align="left">4.	Brand Name not Written</div></td>
				<td class="CONTROL" width="50%"><input type="radio" name="isGenricName" value="1" onClick="ftnTickFour(1)" />Yes<input type="radio" name="isGenricName" value="0" onClick="ftnTickFour(0)" />No</td>
			</tr>
			<tr>	
				<td class="LABEL" width="50%"><div style="display:none;" align="left">5.	Price(MRP) not printed /Visible</div></td>
				
				<td class="CONTROL" width="50%"><input type="radio" name="isMRPPrint" value="1" onClick="ftnTickFive(1)" />Yes<input type="radio" name=isMRPPrint value="0" onClick="ftnTickFive(0)"/>No</td>
			</tr>
			<tr>
				<td class="LABEL" width="50%"><div style="display:none;" align="left">6.	Page No of Stock Register where entry has been made<font color="red">*</font></div></td>
				<td class="CONTROL" width="50%"><input value="01" type="text" class="txtFldMax" name="strPageNumber" onkeypress="return validateData(event,8);" maxlength="5"></td>
				
			</tr>
		</table>
		
		
		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">		
		<tr>
			<td class="LABEL" width="50%"><div align="left">7.	Remarks(if any)</div></td>
			<td class="CONTROL" width="50%">
				<textarea rows="2" cols="25" name="strRemarks"></textarea>
			</td>
			</tr>
		
		</table>
	</div>	
	
	
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
<tr>
		<td  class="LABEL" width="25%" >
					<font color="red">*</font>Committee Type  
		</td>
		<td class="CONTROL" width="25%">
			<select name="strCommitteeType" class="comboMax" onchange="getMemberDtl('COMMITEEMEMBERDTL');">
				<bean:write name="challanProcessBean" property="strCommitteeTypeValues" filter="false"/>
			</select>
		</td>
		<td  class="LABEL" width="25%" >
					Committee Member Dtl  
		</td>
		<td class="CONTROL" >
			<img src="../../hisglobal/images/plus.gif" 
									onClick="openDivPopu();" style="cursor: pointer; " title="Click Here To See Member Details"/>
		</td>
			
				
		</tr>
		</table>
	<jsp:include page="uploadFile.jsp"></jsp:include>
	
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

			<td align="center"><img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" onClick="return verifyValidation();" />
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-clr.png"
				onClick="pageResetMethod();" /> <img
				style="cursor: pointer; "
				src="../../hisglobal/images/back_tab.png"
				onClick="cancelPage('LIST');" /></td>
		</tr>



	</table>

	<input type="hidden" name="strStoreId" value="${challanProcessBean.strStoreId}" />
	
	<input type="hidden" name="strItemCategoryId" value="${challanProcessBean.strItemCategoryId}" />
		
 	<input type="hidden" name="strPoNo" value="${challanProcessBean.strPoNo}" />
 	
 		<input type="hidden" name="strPoDate" value="${challanProcessBean.strPoDate}" />
	
	<input type="hidden" name="strPoStoreId" value="${challanProcessBean.strPoStoreId}" />	
		
	<input type="hidden" name="strPoTypeId" value="${challanProcessBean.strPoTypeId}" />
		
	<input type="hidden" name="strPurchaseSourceId" value="${challanProcessBean.strPurchaseSourceId}" />
	
	<input type="hidden" name="strSupplierId" value="${challanProcessBean.strSupplierId}" />
			
	<input type="hidden" name="strCtDate" value="${challanProcessBean.strCtDate}">
	
	<input type="hidden" name="strPuk" value="${challanProcessBean.strPuk}">
	
	<input type="hidden" name="strEmployeeNo" value="${challanProcessBean.strEmployeeNo}">

	<input type="hidden" name="strCurrencyCode" value="${challanProcessBean.strCurrencyCode}">
	
	<input type="hidden" name="strCurrencyValue" value="${challanProcessBean.strCurrencyValue}">
	
	<input type="hidden" name="strChallanNo" value="${challanProcessBean.strChallanNo}">
		
	<input type="hidden" name="strScheduleNo" value="${challanProcessBean.strScheduleNo}">
								
	<input type="hidden" name="strReceiveDate" value="${challanProcessBean.strDeliveryDate}">
	
	<input type="hidden" name="strActualDeliveryDate" value="${challanProcessBean.strActualDeliveryDate}">
	
	<input type="hidden" name="strScheduleTypeId" value="${challanProcessBean.strScheduleTypeId}">
	
	<input type="hidden" name="strGroupId" value="${challanProcessBean.strGroupId}">
	
	<input type="hidden" name="strSubGroupId" value="${challanProcessBean.strSubGroupId}">
	
	<input type="hidden" name="strGenericItemId" value="${challanProcessBean.strGenericItemId}">
	
	<input type="hidden" name="strItemBrandId" value="${challanProcessBean.strItemBrandId}">
	
	<input type="hidden" name="strReceivedQuantity" value="${challanProcessBean.strReceivedQuantity}">
	
	<input type="hidden" name="strReceivedQuantityUnitId" value="${challanProcessBean.strReceivedQuantityUnitId}">
		
	<input type="hidden" name="strReceivedQuantityUnitBaseValue" value="${challanProcessBean.strReceivedQuantityUnitBaseValue}">	
		
	<input type="hidden" name="strRate" value="${challanProcessBean.strRate}">
			
	<input type="hidden" name="strRateUnit" value="${challanProcessBean.strRateUnit}">	
				
	<input type="hidden" name="strBalanceQuantity" value="${challanProcessBean.strBalanceQuantity}">
	
	<input type="hidden" name="strBalanceQuantityUnitId" value="${challanProcessBean.strBalanceQuantityUnitId}">
	
	<input type="hidden" name="strBalanceQuantityUnitBaseValue" value="${challanProcessBean.strBalanceQuantityUnitBaseValue}">
	
	<input type="hidden" name="strManufacturerId" value="${challanProcessBean.strManufacturerId}">
	
	<input type="hidden" name="strPreviousAcceptedQty" value="${challanProcessBean.strAcceptedQuantityView}">
	<input type="hidden" name="strPreviousRejectedQty" value="${challanProcessBean.strRejectedQuantityView}">
	<input type="hidden" name="strPreviousBreakageQty" value="${challanProcessBean.strBreakageQuantityView}">
	
	<input type="hidden" name="strVerifyFlag" value="${challanProcessBean.strVerifyFlag}">
	
	<input type="hidden" name="strVerifiedQuantityInBaseVal" value="${challanProcessBean.strVerifiedQuantityInBaseVal}">
	
	<input type="hidden" name="strWarrantyFlag" value="${challanProcessBean.strWarrantyFlag}">
	<input type="hidden" name="strInstallFlag" value="${challanProcessBean.strInstallFlag}">
	
	<input type="hidden" name="strItemBrandName" value="${challanProcessBean.strItemBrandName}">
	
	<input type="hidden"  name="strConfigIssueRate"  value="${challanProcessBean.strConfigIssueRate}">
	<input type="hidden"  name="strIssueRateConfigFlg"  value="${challanProcessBean.strIssueRateConfigFlg}">
	
	<input type="hidden"  name="strRateOnLoad"  value="${challanProcessBean.strRateView}">
	<input type="hidden"  name="strDummySalePrice"  value="${challanProcessBean.strDummySalePrice}">
	<input type="hidden" name="strTmpChkVal" value="${challanProcessBean.strTmpChkVal}">
	
	<input type="hidden"  name="strTmpStoreName"  value="${challanProcessBean.strTmpStoreName}">
	<input type="hidden" name="strTmpStoreId" value="${challanProcessBean.strTmpStoreId}">
	<input type="hidden"  name="strTmpPoNumber"  value="${challanProcessBean.strTmpPoNumber}">
	<input type="hidden" name="strTmpPoStoreId" value="${challanProcessBean.strTmpPoStoreId}">
	<input type="hidden" name="strRemainingQty" value="${challanProcessBean.strRemainingQty}">
	<input type="hidden" name="strQcTypeFlg" value="${challanProcessBean.strQcTypeFlg}">
	
	<input type="hidden" name="strTestReportFlg" value="${challanProcessBean.strTestReportFlg}">
    <input type="hidden" name="strMedicienCondFlg" value="${challanProcessBean.strMedicienCondFlg}">
    <input type="hidden" name="strGovtSupplyFlg" value="${challanProcessBean.strGovtSupplyFlg}">
    <input type="hidden" name="strMedicineTypeFlg" value="${challanProcessBean.strMedicineTypeFlg}">
    <input type="hidden" name="strMrpPrintedFlg" value="${challanProcessBean.strMrpPrintedFlg}">
    
     <input type="hidden" name="strSupplierPerformanceInfo" value="${challanProcessBean.strSupplierPerformanceInfo}">
     <input type="hidden" name="strSupplierPerformanceFlag" value="${challanProcessBean.strSupplierPerformanceFlag}">
     <input type="hidden"  name="strDrugTotCost" id="strDrugTotCost">
     <input type="hidden" name="strReceivedQuantityView" value="${challanProcessBean.strReceivedQuantityView}" />
    
	
	
	
	
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

<div class="popUpDiv" id="popUpDivId" style="display:none;">
<table bgcolor="white">
<tr>
<td>
<div id="itemParameterDtlDivId" style="display:block;"></div>
</td>
</tr>
</table>
</div>


<div class="popUpDiv" id="memberDtl" style="display:none;">
<table bgcolor="white">
<tr>
<td>
<div id="memberDtlInner" style="display:block;"></div>
</td>
</tr>
</table>
</div>


<div class="popup" id="verifiedQtyDtlsDivId" style="display: none">
	<table width='450' cellpadding="0" cellspacing="0">
		<tr class='HEADER'>
			<td  align="left">
			Verified Qty. Details
			</td>
			<td align="right"><img
				src="../../hisglobal/images/popUp_cancel.JPG"
				style=" cursor: pointer" align="middle"
				onclick="hide_popup_menu('verifiedQtyDtlsDivId');"></td>
		</tr>
	</table>
	<table width='450' cellpadding="1px" cellspacing="1px">
		<tr>
			<td width="200" class="LABEL">Accepted Qty. + Rejected Qty. + Breakage Qty.</td>
			<td width="200" class="CONTROL" >
			<div id='verAccQtyDivId'></div>
			</td>
		</tr>
		<tr class='FOOTER'><td colspan="2">
		</td>
		</tr>
	</table>
	</div>

<div class="popup" id="balQtyDtlsDivId" style="display: none"></div>

<cmbPers:cmbPers />	
<input type="hidden" value="${challanProcessBean.combo[0]}" name="combo" tabindex="1"/>	
<input type="hidden" value="${challanProcessBean.combo[1]}" name="combo" tabindex="1"/>	
<input type="hidden" value="${challanProcessBean.combo[2]}" name="combo" tabindex="1"/>	

</html:form>
<jsp:include page="challanprocess_multirow_mmstrans.jsp"></jsp:include>

<tag:autoIndex></tag:autoIndex>

</body>
</html>








