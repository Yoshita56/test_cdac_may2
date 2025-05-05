<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>



<html>
<head>
<meta charset=UTF-8">
<title>Drug Inventory</title>

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet">
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationBootstrap.js"></script>















<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">


<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">


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
<html:form name="drugInventoryTransBean"
	action="/transactions/DrugInventoryTransBSCNT"
	type="mms.transactions.controller.fb.DrugInventoryTransFB">


	<div class="errMsg" id="errMsg"><bean:write
		name="drugInventoryTransBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="drugInventoryTransBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="drugInventoryTransBean" property="strMsg" /></div>

	<center><tag:tab tabLabel="Drug Inventory1"
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
		<tr class="HEADER">
			<td width='100%' colspan='4'></td>
		</tr>
        <tr>
			<td width="50%" class="LABEL">Store Name</td>
			<td width="50%" class="CONTROL"><bean:write name="drugInventoryTransBean" property="strStoreName" filter="false" /></td>
		</tr>
	</table>
		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
		<tr>			
			<td width="25%" class="LABEL" >Group Name</td>
			<td width="25%" class="CONTROL" >
				<div id="GroupNameDiv">
				    <bean:write name="drugInventoryTransBean" property="strGroupName" filter="false" />
				</div>  
				<div id="GroupNameCmbDiv" style="display:none;">
				   <select name="strGroupCmbId" class="comboNormal" onChange="getSubGrpAndGenericItem();">
				      <bean:write name="drugInventoryTransBean" property="strGroupNameCombo" filter="false" />
			       </select>
				</div>  
			</td>
			<td class="LABEL" width="25%" >Sub Group Name</td>
			<td class="CONTROL" width="25%" >
			<div id="SubGroupNameDiv">
			  <select name="strSubGroupId" class="comboNormal" onChange="ajaxItemName('ITEMNAME');">
				  <bean:write name="drugInventoryTransBean" property="strSubGroupCombo" filter="false" />
			  </select>
			  </div>
			</td>
		</tr>


		<tr>
			<td class="LABEL" width="25%" ><font color="red">*</font>Generic
			Drug Name</td>
			<td class="CONTROL" width="25%" >
			<div id="ItemNameId"><select name="strItemId"
				class='comboNormal' onChange="ajaxItemBrandName();">
				<bean:write name="drugInventoryTransBean"
					property="strItemNameCombo" filter="false" />
			</select></div>
			</td>

			<td class="LABEL" width="25%" ><font color="red">*</font>Stock
			Status</td>
			<td class="CONTROL" width="25%" >
			<div id="strStockStatusDiv">
				<select name="strStockStatus" class="comboNormal">
	
					<bean:write name="drugInventoryTransBean"
						property="strStockStatusValues" filter="false" />
	
				</select>
			</div>
			
			</td>
		</tr>


		<tr>
			<td class="LABEL" width="25%" ><font color="red">*</font>Drug
			Name</td>
			<td class="CONTROL" width="25%" >
			<div id="ItemBrandId">
			<select name="strItemBrandId" class='comboNormal'>				
				<option value="0">Select Value</option>
			</select></div>
			</td>
			<td class="LABEL" width="25%" >
	        <div id="manfNotMandatoryDivId" style="display: block;">Manufacture</div>
			<div id="manfMandatoryDivId" style="display: none;"><font color="red">*</font>Manufacture</div>
            </td>
			<td width="25%" class="CONTROL" >
			<div id="manufDivId"><select class="comboNormal" name="strManufactureId">
				<option value='0'>Select Value</option>
			</select></div>
			</td>
		</tr>
		<tr>		
			<td class="LABEL" width="25%" >Batch No.</td>
			<td class="CONTROL" width="25%" >			    
			    <div id="ExistingBatchId">
			    <select name="strExistingBatchId"	class='comboNormal'  onchange="">
				<option value="0">Select Value</option>
			    </select></div>			    
			</td>
			<td class="LABEL" width="25%" >
			<div id="batchNoDivId">New Batch No.</div>
			<input type="hidden" name="isBatchReq" value="0"></td>
			<td class="CONTROL" width="25%" >
			<input type="text" autocomplete='off'	name="strBatchNo" maxlength="30" class="txtFldMax"	onkeypress="return validateData(event,8);" />
			</td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL" width='50%'>
			<div id="specNotMandatoryDivId" style="display: none;">Specification</div>
				<div id="specMandatoryDivId" style="display: block;"><font color="red">*</font>Specification</div>			 
			</td>
			<td colspan="2" class="CONTROL" width='50%'><textarea rows="2" cols="30" name="strItemSpecification"></textarea>
			</td>
		</tr>

		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Manufacture Date</td>
			<td class="CONTROL" width="25%" >			
			  <div id="manufactDateTextDiv">
					<dateTag:date name="strManufactureDate" value=""></dateTag:date>
			 </div>			
			  <div id="manufactDateFieldDiv"></div>
			</td>
			<td class="LABEL" width='25%'>
			    <div id="expiryDateDivId">Expiry Date</div>	<input type="hidden" name="isExpirtReq" value="1">
			</td>

			<td class="CONTROL" width="25%">
			   <div id="expDateTextDiv">
			       <dateTag:date name="strExpiryDate" value=""></dateTag:date>
			   </div>
			    <div id="expDateFieldDiv"></div>
			</td>
		</tr>		
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>InHand Quantity</td>

			<td class="CONTROL" width="25%"><input type="text" autocomplete='off'
				name="strInHandQuantity" maxlength="8" class="txtFldNormal" onBlur="ajaxExistingBatchInStock();"
				onkeypress="return validateData(event,5);" /></td>

			<td class="LABEL" width="25%"><font color="red">*</font>InHand Quantity Unit</td>
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
			<td class="LABEL" width="25%">Free Drug Quantity</td>

			<td class="CONTROL" width="25%"><input type="text" autocomplete='off'
				name="strFreeItemQuantity" maxlength="8" class="txtFldNormal"
				onkeypress="return validateData(event,5);" /></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Free Drug Quantity Unit</td>
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
			<td class="LABEL" width="25%" ><font color="red">*</font>Rack No.</td>
			<td class="CONTROL" width="25%" >
			 <div id="rackNoTextDiv">
			 <input type="text" name="strRackNumber" autocomplete='off' maxlength="8" class="txtFldMax" onkeypress="return validateData(event,3);" />
			</div>	
			<div id="rackNoFieldDiv"></div>	
			</td>
			<td class="CONTROL" width="25%" ></td>
			<td class="CONTROL" width="25%" ></td>
		</tr>
		<tr>
			<td colspan="4" class="TITLE" width="100%">Rate Details</td>
		</tr>
		<tr>
		<td class="LABEL" width="25%">Currency Code</td>
			<td class="CONTROL" width="25%"> 
			 <div id="currencyCodeTextDiv">
			  <select name="strCurrencyCode" class="comboNormal" onchange="isCurrencyMandatory(this);"> <bean:write name="drugInventoryTransBean" property="strCurrencyCodeValues" filter="false"/></select>  
			 </div>
			 <div id="currencyCodeFieldDiv"></div>
			</td>	
			<td class="LABEL" width="25%"><div id="currencyDivId">Currency Value</div>
			<input type="hidden" name="isCurrencyReq" value="0">
			</td>
			<td class="CONTROL" colspan="1" width="25%"><input type="text" autocomplete='off'
				name="strCurrencyValue" maxlength="8" class="txtFldNormal" value="1" disabled="disabled"
				onkeypress="return validateData(event,7);" /></td>
	
		</tr>
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Purchase Rate/Unit</td>
			<td class="CONTROL" colspan="1" width="25%">
			<input type="text" autocomplete='off' name="strRate" maxlength="14" class="txtFldMax"
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
			<td class="LABEL" width="25%"><font color="red">*</font>M.R.P</td>
			<td class="CONTROL" width="25%"><input type="text"  autocomplete='off'
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
			<td class="LABEL" width="25%">  <font color="red">*</font>P.O. No.</td>
			<td class="CONTROL" width="25%">
			 <div id="poTextDiv">
			    <input type="text" autocomplete='off'	name="strPoNo" maxlength="11" class="txtFldMax"	onkeypress="return validateData(event,7);" />
			 </div>
			 <div id="poFieldDiv"></div>			 
			</td>
			<td class="LABEL" width="25%">  <font color="red">*</font>P.O. Date</td>
			<td class="CONTROL" width="25%">
			   <div id="poDateTextDiv">
			     <dateTag:date name="strPoDate"	
			     value=""></dateTag:date>
			   </div>
			   <div id="poDateFieldDiv"></div>
			</td>
		</tr>		
		<tr>
			<td class="LABEL" width="25%">  <font color="red">*</font>Bill No.</td>
			<td class="CONTROL" width="25%">
			  <div id="billTextDiv">
			   <input type="text" autocomplete='off' name="strBillNo" maxlength="11" class="txtFldMax" onkeypress="return validateData(event,7);" />
              </div>
              <div id="billFieldDiv"></div> 
             </td>           
			<td class="LABEL" width="25%">  <font color="red">*</font>Bill Date</td>
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
			   <select name="strSuppliedBy" class="comboNormal"> <bean:write name="drugInventoryTransBean" property="strSuppliedByValues" filter="false"/></select>  
			 </div>
			 <div id="supplyByFieldDiv"></div>			 
			</td>
		</tr>
	</table>
	
	<div style="display:none">
	<dateTag:date name="todayDate" value="${drugInventoryTransBean.strCtDate}"></dateTag:date></div>
				
		<logic:equal name="drugInventoryTransBean" property="strFreeItemFlag" value="1">				
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
			<td class="multiLabel" width="20%">Drug Name</td>
			<td class="multiLabel" width="20%">Batch No.</td>
			<td class="multiLabel" width="20%">Expiry Date</td>
			<td class="multiLabel" width="20%">Quantity</td>
			<td class="multiLabel" width="5%"></td>
		</tr>
		</table>
		
		<div id="id1"></div>		
			<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
				<tr>
					<td colspan="4" class="TITLE" width="25%">
					</td>
				</tr>
				<tr>
					<td align="center">
					<img style="cursor: pointer; " src="../../hisglobal/images/btn-add.png" onClick="addFreeItems();" />
					</td>
				</tr>		
			</table>		
		 </div>
	</logic:equal>  

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">

		
		<tr class="FOOTER">
			<td colspan="4" width="25%"><font size="2" color="red">*</font>
			Mandatory Fields , ['*'] Reserved/Branded Drug  </td>
		</tr>
	</table>
<!-- 	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
			<table border="0" class="TABLEWIDTH" align="center">
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



	</table> -->
	<br>
	<div align="center" id="">					 
					 	<a href="#" class="button" id="submitId" onclick='beforeSave();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="ClearPage();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
					</div> 

	<input type="hidden" name="strStoreId" value="${drugInventoryTransBean.combo[0]}" />
	<input type="hidden" name="strStoreName" value="${drugInventoryTransBean.strStoreName}" />
	<input type="hidden" name="strGroupId" value="${drugInventoryTransBean.combo[1]}" />
	<input type="hidden" name="strGroupName" value="${drugInventoryTransBean.strGroupName}" />
	<input type="hidden" name="strCtDate" value="${drugInventoryTransBean.strCtDate}">
	<input type="hidden" name="strDefaultCurrencyCode" value="${drugInventoryTransBean.strDefaultCurrencyCode}">
	<input type="hidden" name="strRegFlag" value="" />		
	<input type="hidden" name="hmode" />
	<input type="hidden"  name="strExistingBatchDetails">
	<input type="hidden"  name="strExistingBatchFlg">
	<input type="hidden"  name="strConfigIssueRate" value="${drugInventoryTransBean.strConfigIssueRate}">
	<input type="hidden"  name="strIssueRateConfigFlg"  value="${drugInventoryTransBean.strIssueRateConfigFlg}">
	<input type="hidden"  name="strBatchExistInStockFlg"  value="${drugInventoryTransBean.strBatchExistInStockFlg}">
	<input type="hidden"  name="strQcTypeFlg"  value="${drugInventoryTransBean.strQcTypeFlg}">
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