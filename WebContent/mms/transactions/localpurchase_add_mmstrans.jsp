<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>



<html>
<head>
<meta charset=UTF-8">
<title>Local Purchase</title>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">


<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">



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

<body onLoad='onLoadFunction();'>
<html:form name="localPurchaseTransBean" 
           action="/transactions/LocalPurchaseTransCNT"	type="mms.transactions.controller.fb.LocalPurchaseTransFB">


	<div class="errMsg" id="errMsg"><bean:write
		name="localPurchaseTransBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="localPurchaseTransBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="localPurchaseTransBean" property="strMsg" /></div>

	<center><tag:tab tabLabel="Local Purchase"
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>

       <tr>
			<td width="50%" class="LABEL">Store</td>
			<td width="50%" class="CONTROL"><bean:write
				name="localPurchaseTransBean" property="strStoreName" filter="false" />
				</td>
			
		</tr>
		</table>
		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr>
			
			<td width="25%" class="LABEL">Group Name</td>
			<td width="25%" class="CONTROL">
				<div id="GroupNameDiv">
				    <bean:write name="localPurchaseTransBean" property="strGroupName" filter="false" />
				</div>  
				<div id="GroupNameCmbDiv" style="display:none;">
				   <select name="strGroupCmbId" class="comboMax" onChange="getSubGrpAndGenericItem();">
				      <bean:write name="localPurchaseTransBean" property="strGroupNameCombo" filter="false" />
			       </select>
				</div>  
			</td>
			<td class="LABEL" width="25%">Sub Group Name</td>
			<td class="CONTROL" width="25%">
			<div id="SubGroupNameDiv">
			  <select name="strSubGroupId" class="comboNormal" onChange="ajaxItemName('ITEMNAME');">
				  <bean:write name="localPurchaseTransBean" property="strSubGroupCombo" filter="false" />
			  </select>
			  </div>
			</td>
		</tr>


		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Generic
			Item/Drug Name</td>
			<td class="CONTROL" width="25%">
			<div id="ItemNameId"><select name="strItemId"
				class='comboMax' onChange="ajaxItemBrandName();">
				<bean:write name="localPurchaseTransBean"
					property="strItemNameCombo" filter="false" />
			</select></div>
			</td>

			<td class="LABEL" width="25%"><font color="red">*</font>Stock
			Status</td>
			<td class="CONTROL" width="25%">
			<div id="strStockStatusDiv">
				<select name="strStockStatus" class="comboNormal">
	
					<bean:write name="localPurchaseTransBean"
						property="strStockStatusValues" filter="false" />
	
				</select>
			</div>
			
			</td>
		</tr>


		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Drug/Item Name</td>
			<td class="CONTROL" width="25%">
			<div id="ItemBrandId"><select name="strItemBrandId"
				class='comboMax'>
				<%-- onchange="ajaxManufectureName('MANUFECTURENAME');">--%>
				<option value="0">Select Value</option>
			</select></div>
			</td>


			<td class="LABEL">
	        <div id="manfNotMandatoryDivId" style="display: none;">Manufacture</div>
			<div id="manfMandatoryDivId" style="display: block;"><font color="red">*</font>Manufacture</div>
            </td>
			<td width="25%" class="CONTROL">
			<div id="manufDivId"><select class="comboMax" name="strManufactureId">
				<option value='0'>Select Value</option>
			</select></div>
			</td>
		</tr>

		<tr>
			<td class="LABEL">Batch No.</td>

			<td class="CONTROL" width="25%">
			
			 
			    
			    <div id="ExistingBatchId">
			    <select name="strExistingBatchId"	class='comboNormal'  onchange="">
				<option value="0">Select Value</option>
			    </select></div>
			    
			    
			</td>

			<td class="LABEL">
			<div id="batchNoDivId">New Batch No.</div>
			<input type="hidden" name="isBatchReq" value="0"></td>

			<td class="CONTROL" width="25%">
			<input type="text"	name="strBatchNo" maxlength="30" class="txtFldMax"	onkeypress="return validateData(event,17);" />
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
			<td class="LABEL" width="25%"><font color="red">*</font>Manufacture Date</td>
			<td class="CONTROL" width="25%">
			
			  <div id="manufactDateTextDiv">
					<dateTag:date
						name="strManufactureDate"
						value=""></dateTag:date>
			 </div>			
			  <div id="manufactDateFieldDiv"></div>
			</td>

			<td class="LABEL">
			    <div id="expiryDateDivId">Expiry Date</div>	<input type="hidden" name="isExpirtReq" value="0">
			</td>

			<td class="CONTROL" width="25%">
			   <div id="expDateTextDiv">
			       <dateTag:date name="strExpiryDate" value=""></dateTag:date>
			   </div>
			    <div id="expDateFieldDiv"></div>
			</td>
		</tr>
		
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>InHand
			Qty.</td>

			<td class="CONTROL" width="25%"><input type="text"
				name="strInHandQuantity" maxlength="8" class="txtFldNormal" onBlur="ajaxExistingBatchInStock();"
				onkeypress="return validateData(event,5);" /></td>

			<td class="LABEL" width="25%"><font color="red">*</font>InHand
			Qty. Unit</td>
			<td class="CONTROL" width="25%">
			<div id="freeItemUnit"><select name="strInHandQuantityUnitID"
				class='comboNormal'>
				<option value="0">Select Value</option>
			</select></div>
			
			<div id="freeItemUnitField"></div>
			</td>
		</tr>
		</table>
		
	<div id="frreQty" style="display:none;">	
		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="LABEL" width="25%">Free Item/Drug Qty.</td>

			<td class="CONTROL" width="25%"><input type="text"
				name="strFreeItemQuantity" maxlength="8" class="txtFldNormal"
				onkeypress="return validateData(event,5);" /></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Free Item/Drug Qty. Unit</td>
			<td class="CONTROL" width="25%">
			<div id="freeItemUnitValue"><select name="strFreeItemQuantityUnitID"
				class='comboNormal'>
				<option value="0">Select Value</option>
			</select></div>
			</td>
		</tr>
		</table>
	</div>	
		
		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="LABEL" width="25%">Rack No</td>

			<td class="CONTROL" width="25%">
			 <div id="rackNoTextDiv">
			    <input type="text"
				name="strRackNumber" maxlength="8" class="txtFldMax"
				onkeypress="return validateData(event,3);" />
			</div>	
			<div id="rackNoFieldDiv"></div>	
				</td>

			<td class="CONTROL" width="25%"></td>
			<td class="CONTROL" width="25%">
			
			</td>
		</tr>
	
	
		<tr>
			<td colspan="4" class="TITLE" width="25%">
			Rate Details
			</td>
		</tr>
	<tr>
		<td class="LABEL" width="25%">Currency Code</td>
			<td class="CONTROL" width="25%"> 
			 <div id="currencyCodeTextDiv">
			  <select name="strCurrencyCode" class="comboNormal" onchange="isCurrencyMandatory(this);"> <bean:write name="localPurchaseTransBean" property="strCurrencyCodeValues" filter="false"/></select>  
			 </div>
			 <div id="currencyCodeFieldDiv"></div>
			</td>
	
		<td class="LABEL" width="25%"><div id="currencyDivId">Currency Value</div>
			<input type="hidden" name="isCurrencyReq" value="0">
			</td>

			<td class="CONTROL" colspan="1" width="25%"><input type="text"
				name="strCurrencyValue" maxlength="8" class="txtFldNormal" value="1" disabled="disabled"
				onkeypress="return validateData(event,7);" /></td>
	
	</tr>
		<tr>
		<td class="LABEL" width="25%"><font color="red">*</font>Purchase Rate/Unit
			</td>

			<td class="CONTROL" colspan="1" width="25%"><input type="text"
				name="strRate" maxlength="14" class="txtFldMax"
				onkeypress="return(numericWithTwoDecimalPlaces(this,',','.',event))" onBlur="calcIssueRate();" /></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Unit Name</td>
			<td class="CONTROL" width="25%">
			<div id="UnitRateID"><select name="strUnitRateID"
				class='comboNormal'>
				<option value="0">Select Value</option>
			</select></div>
			<div id="UnitRateFieldID"></div>
			
			</td>

		</tr>
		
		
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Issue Rate</td>
			<td class="CONTROL" width="25%"><input type="text"
				name="strSalePrice" maxlength="14" class="txtFldMax"
				onkeypress="return validateData(event,7);"  /></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Unit Name</td>
			<td class="CONTROL" width="25%">

			<div id="UnitRateID1"><select name="strUnitSaleID" class='comboNormal'>
				<option value="0">Select Value</option>
			</select></div>
			
			<div id="UnitRateFieldID1"></div>
			
			</td>
		</tr>

		<tr>
			<td colspan="4" class="TITLE" width="25%">P.O. Details
			</td>
		</tr>
	
		<tr>

			<td class="LABEL" width="25%">P.O. No.</td>
			<td class="CONTROL" width="25%">
			 <div id="poTextDiv">
			    <input type="text"	name="strPoNo" maxlength="25" class="txtFldMax"	onkeypress="return validateData(event,17);" />
			 </div>
			 <div id="poFieldDiv"></div>
			 
			</td>

			<td class="LABEL" width="25%">P.O.
			Date</td>
			<td class="CONTROL" width="25%">
			   <div id="poDateTextDiv">
			     <dateTag:date name="strPoDate"	
			     value=""></dateTag:date>
			   </div>
			   <div id="poDateFieldDiv"></div>
			</td>

		</tr>
		
		<tr>

			<td class="LABEL" width="25%">Bill No.</td>
			<td class="CONTROL" width="25%">
			  <div id="billTextDiv">
			   <input type="text" name="strBillNo" maxlength="25" class="txtFldMax" onkeypress="return validateData(event,17);" />
              </div>
              <div id="billFieldDiv"></div> 
             </td>
			<td class="LABEL" width="25%">Bill Date</td>
			<td class="CONTROL" width="25%">
			 <div id="billDateTextDiv">
			   <dateTag:date name="strBillDate"	
			   value=""></dateTag:date>
			 </div>
			 <div id="billDateFieldDiv"></div>
			</td>

		</tr>

<tr>

			<td class="LABEL" width="25%"><font color="red">*</font>Received Date</td>
			<td class="CONTROL" width="25%">
		   	 <div id="receiveDateTextDiv">
			    <dateTag:date name="strReceivedDate" value=""></dateTag:date>
		     </div>
		     <div id="receiveDateFieldDiv"></div>
			</td>

			<td class="LABEL" width="25%"><font color="red">*</font>Supplied By</td>
			<td class="CONTROL" width="25%"> 
			
			 <div id="supplyByTextDiv">
			   <select name="strSuppliedBy" class="comboMax"> <bean:write name="localPurchaseTransBean" property="strSuppliedByValues" filter="false"/></select>  
			 </div>
			 <div id="supplyByFieldDiv"></div>
			 
			</td>

		</tr>



	</table>
	<div style="display:none"><dateTag:date name="todayDate"
				value="${localPurchaseTransBean.strCtDate}"></dateTag:date></div>
				
<logic:equal name="localPurchaseTransBean" property="strFreeItemFlag"	value="1">		<!-- Start Of Free Drug Div -->	
				
		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
		
			<tr>
					<td colspan="4" class="TITLE" width="25%">
					<div id="freeItemDtlsDivIdPlusId" align="left" style="display: block;">
					<img src="../../hisglobal/images/plus.gif"
						onClick="showView('freeItemDtlsDivId');"
						style="cursor: pointer; " /> Free Items </div>
					<div id="freeItemDtlsDivIdMinusId" style="display: none;" align="left">
					<img src="../../hisglobal/images/minus.gif"
						onClick="hideView('freeItemDtlsDivId');"
						style="cursor: pointer; " /> Free Items</div>
					</td>
				</tr>
		</table>
		
		
		
		<div id="freeItemDtlsDivId" style="display:none">   

		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
		<tr>
			
		<td class="multiLabel" width="20%">Item/Drug Name
		</td>
		<td class="multiLabel" width="20%">Batch No.
		</td>
		<td class="multiLabel" width="20%">Expiry Date
		</td>
		<td class="multiLabel" width="20%">Qty.
		</td>
		<td class="multiLabel" width="5%">
		</td>
		</tr>
		</table>
		<div id="id1"></div>
		
		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
				cellspacing="1px">
				
				<tr>
					<td colspan="4" class="TITLE" width="25%">
					</td>
				</tr>
					
						<tr>
		
					<td align="center"><img style="cursor: pointer; "
						src="../../hisglobal/images/btn-add.png" onClick="addFreeItems();" />
					</td>
				</tr>
		
			</table>
		
		   </div>	
</logic:equal>  <!--  End of Whole Free Drug Div -->

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<!--	<table cellspacing="1px" class="TABLEWIDTH" align="center">-->
		<tr class="FOOTER">
			<td colspan="4" width="25%"><font size="2" color="red">*</font>
			Mandatory Fields , ['*'] Reserved/Branded Item/Drug  </td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<!--	<table border="0" class="TABLEWIDTH" align="center">-->
			<tr>

			<td align="center"><img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" onClick="beforeSave();"  title="Click to Save Record"/>
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-clr.png"
				onClick="ClearPage();" title="Click to Clear Page" /> <img
				style="cursor: pointer; "
				src="../../hisglobal/images/back_tab.png"
				onClick="cancel('LIST');" title="Click to Return On Desk" /></td>
		</tr>



	</table>

	<input type="hidden" name="strStoreId"
		value="${localPurchaseTransBean.combo[0]}" />
	<input type="hidden" name="strStoreName"
		value="${localPurchaseTransBean.strStoreName}" />
	<input type="hidden" name="strGroupId"
		value="${localPurchaseTransBean.combo[1]}" />
	<input type="hidden" name="strGroupName"
		value="${localPurchaseTransBean.strGroupName}" />
	<input type="hidden" name="strCtDate"
		value="${localPurchaseTransBean.strCtDate}">

<input type="hidden" name="strDefaultCurrencyCode"
		value="${localPurchaseTransBean.strDefaultCurrencyCode}">
		
		<input type="hidden" name="strRegFlag" value="" />
		
	<input type="hidden" name="hmode" />
	<input type="hidden"  name="strExistingBatchDetails">
	<input type="hidden"  name="strExistingBatchFlg">
	<input type="hidden"  name="strConfigIssueRate" value="${localPurchaseTransBean.strConfigIssueRate}">
	<input type="hidden"  name="strIssueRateConfigFlg"  value="${localPurchaseTransBean.strIssueRateConfigFlg}">
	<input type="hidden"  name="strBatchExistInStockFlg"  value="${localPurchaseTransBean.strBatchExistInStockFlg}">
	<input type="hidden"  name="strQcTypeFlg"  value="${localPurchaseTransBean.strQcTypeFlg}">
	<input type="hidden"  name="strDrugTotCost" id="strDrugTotCost">



<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="otherDtlspopUpDiv" style="display:none;">
<table bgcolor="white">
<tr>
<td>
<div id="itemsOtherDtlsDivId" style="display:block;"></div>
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








