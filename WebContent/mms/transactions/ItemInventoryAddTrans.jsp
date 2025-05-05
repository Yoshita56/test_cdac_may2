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
<title>Item Inventory</title>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>



<script type="text/javascript">
function cancel1(){
	document.forms[0].hmode.value="LIST";
	document.forms[0].submit();
}

function clearRecord(){
	document.forms[0].hmode.value="ADD";
	document.forms[0].submit();
}

function validate(){
	document.forms[0].hmode.value="INSERT";
	document.forms[0].submit();
}
function view1(id1,id2,id3){
	document.getElementById(id1).style.display="none";
	document.getElementById(id2).style.display="block";
	document.getElementById(id3).style.display="block";
}
function view2(id1,id2,id3)	{
	document.getElementById(id1).style.display="block";
	document.getElementById(id2).style.display="none";
	document.getElementById(id3).style.display="none";
}
function ajaxItemName(){  
//	alert(document.forms[0].strStoreID.value);
	document.getElementById("itemDepend").innerHTML = "";
	var url="ItemInventoryTransCNT.cnt?hmode=ITEMNAME&strSubGroupID="+document.forms[0].strSubGroupID.value;
	ajaxFunction(url,"1");
}
function ajaxItemBrandName(){
	//alert(document.forms[0].strItemID.value);
	var url="ItemInventoryTransCNT.cnt?hmode=ITEMBRANDNAME&strItemID="+document.forms[0].strItemID.value;
	ajaxFunction(url,"2");
}

function ajaxBatchExFlag(){
	//alert(document.forms[0].strItemID.value);
	var url="ItemInventoryTransCNT.cnt?hmode=BATCHANDEXDATE&strItemID="+document.forms[0].strItemID.value;
	ajaxFunction(url,"3");
}

function getManufacturerName(){
	//alert(document.forms[0].strItemID.value);
	var url="ItemInventoryTransCNT.cnt?hmode=MANUFACTURERNAME&strItemID="+document.forms[0].strItemID.value+"&strItemBrandID="+document.forms[0].strItemBrandID.value;
	ajaxFunction(url,"4");
}

function getManufecture(mode){
	document.forms[0].hmode.value=mode;
	document.forms[0].submit();
}

function getAjaxResponse(res,mode){
	var objVal;
	if(res.split("####")[0]=="ERROR"){
		objVal= document.getElementById("errMsg");
		objVal.innerHTML = res.split("####")[1]; 
	}else if(mode=="1"){
		objVal= document.getElementById("ItemID");
		objVal.innerHTML = "<select name ='strItemID' class='comboNormal' onChange = 'ajaxItemBrandName(\"ITEMBRANDNAME\")' >" + res + "</select>";				
	}else if(mode=="2"){
		objVal= document.getElementById("ItemBrandID");
		objVal.innerHTML = "<select name ='strItemBrandID' class='comboNormal' onChange='ajaxManufectureName(\"MANUFECTURENAME\")' >" + res + "</select>";
		ajaxBatchExFlag();				
	}else if(mode=="3"){
		objVal= document.getElementById("itemDepend");
		objVal.innerHTML = res;				
	}else if(mode=="4"){
		objVal= document.getElementById("itemDepend");
		objVal.innerHTML = "<select	name='strManufactureID' class='comboNormal'>"+res+"</select>";				
	}
}


</script>

</head>

<body>
<html:form name="itemInventoryTransBean"
	action="/transactions/ItemInventoryTransCNT"
	type="mms.transactions.controller.fb.ItemInventoryTransFB">


	<div class="errMsg" id="errMsg"><bean:write
		name="itemInventoryTransBean" property="strMsgString" /></div>
	<div class="warningMsg"><bean:write name="itemInventoryTransBean"
		property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="itemInventoryTransBean" property="strMsg" /></div>

	<center><tag:tab tabLabel="Item Inventory "
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="0px">
		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>


		<tr>
			<td width="25%" class="LABEL">Store Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="itemInventoryTransBean" property="strStoreName" filter="false" />
			<td width="25%" class="LABEL">Group Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="itemInventoryTransBean" property="strGroupName" filter="false" />
			</td>
		</tr>


		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Sub
			Group Name</td>
			<td class="CONTROL" width="25%"><select name="strSubGroupID"
				class="comboNormal" onChange="ajaxItemName();">
				<bean:write name="itemInventoryTransBean"
					property="strSubGroupValues" filter="false" />
				<option value="0">Select Value</option>
			</select></td>

			<td class="LABEL" width="25%"><font color="red">*</font>Item
			Name</td>
			<td class="CONTROL" width="25%">
			<div id="ItemID"><select name="strItemID" class='comboNormal'
				onChange="ajaxItemBrandName();">
				<option value="0">Select Value</option>
			</select></div>
			</td>
		</tr>


		<tr>
			<td class="LABEL" width="25%">Item Brand Name</td>
			<td class="CONTROL" width="25%">
			<div id="ItemBrandID"><select name="strItemBrandID"
				class='comboNormal' onchange="getManufacturerName()">
				<option value="0">Select Value</option>
			</select></div>
			</td>

			<td class="LABEL">Manufacture Name</td>
			<td width="50%" class="CONTROL"><select
				name="strManufactureID" class="comboNormal">
				<bean:write name="itemInventoryTransBean"
					property="strManufactureComboWS" filter="false" />
			</select></td>
		</tr>

		<tr>
			<td class="LABEL" width="25%">Manufacture
			Date</td>
			<td class="CONTROL" colspan="3" width="75%"><dateTag:date
				name="strManufactureDate"></dateTag:date></td>
		</tr>
		</table>
		<div id="itemDepend"></div>
		<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="0px">
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>InHand
			Quantity</td>
			<td class="CONTROL" colspan="1" width="25%"><input type="text"
				name="strInHandQty" class="txtFldMin"></td>
			<td class="LABEL" width="25%"><font color="red">*</font>Unit
			Name</td>

			<td class="CONTROL" width="25%""><select
				name="strInHandQtyUnitID" class='comboNormal'>
				<bean:write name="itemInventoryTransBean"
					property="strUnitNameValues" filter="false" />
			</select></td>
		</tr>
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Whether
			Item is Consumable</td>
			<td class="CONTROL" colspan="1" width="25%"><input
				type="checkbox" value="1" name="strConsumableFlag"></td>
			<td class="LABEL" width="25%"><font color="red">*</font>Item
			Category</td>

			<td class="CONTROL" width="25%""><select name="strCatNo"
				class='comboNormal'>
				<bean:write name="itemInventoryTransBean" property="strCatValues"
					filter="false" />
			</select></td>
		</tr>

	</table>


	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="0px">
		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="ratedetailsPlusID" align="left" style="display: block;">
			<img src="../../hisglobal/images/plus.gif"
				onClick="view1('ratedetailsPlusID','ratedetailsMinusID','ratedetailsID');"
				style="cursor: pointer; " /> Rate Details</div>
			<div id="ratedetailsMinusID" style="display: none;" align="left">
			<img src="../../hisglobal/images/minus.gif"
				onClick="view2('ratedetailsPlusID','ratedetailsMinusID','ratedetailsID');"
				style="cursor: pointer; " /> Rate Details</div>
			</td>
		</tr>
	</table>
	<div id="ratedetailsID" style="display: none">
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="0px">

		<tr>
		
			<td class="LABEL" width="25%"><font color="red">*</font>Rate/Unit
			</td>

			<td class="CONTROL" colspan="1" width="25%"><input type="text"
				name="strRate" maxlength="10" class="txtFldNormal" /></td>
			<td class="LABEL" width="25%"><font color="red">*</font>Unit
			Name</td>
			<td class="CONTROL" width="25%"><select name="strRateUnit"
				class='comboNormal'>
				<bean:write name="itemInventoryTransBean" property="strUnitNameValues"
					filter="false" />
			</select></td>
		</tr>


		<tr>
		<td class="LABEL" width="25%"><font color="red">*</font>Sale
			Price/Unit</td>
			<td class="CONTROL" width="25%"><input type="text"
				name="strSalePrice" maxlength="10" class="txtFldNormal" /></td>
			<td class="LABEL" width="25%"><font color="red">*</font>Unit
			Name</td>
			<td class="CONTROL" width="25%"><select name="strSalePriceUnit"
				class='comboNormal'>
				<bean:write name="itemInventoryTransBean" property="strUnitNameValues"
					filter="false" />
			</select></td>
		</tr>

	</table>
	</div>
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="0px">
		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="otherDetailPlusID" align="left" style="display: block;">
			<img src="../../hisglobal/images/plus.gif"
				onClick="view1('otherDetailPlusID','otherDetailMinusID','otherDetailID');"
				style="cursor: pointer; " /> Other Details</div>
			<div id="otherDetailMinusID" style="display: none;" align="left">
			<img src="../../hisglobal/images/minus.gif"
				onClick="view2('otherDetailPlusID','otherDetailMinusID','otherDetailID');"
				style="cursor: pointer; " /> Other Details</div>
			</td>
		</tr>
	</table>
	<div id="otherDetailID" style="display: none">
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="0px">



		<tr>
			<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>Item
			Status</td>
			<td class="CONTROL" colspan="1" width="25%"><html:select
				property="strItemStatus">
				<html:option value="1"> OK</html:option>
				<html:option value="2"> Under Inspection</html:option>
				<html:option value="3"> Rejected</html:option>
			</html:select></td>

			<td class="LABEL" width="25%"><font color="red">*</font>PO No</td>
			<td class="CONTROL" colspan="" width="25%"><input type="text"
				name="strPoNo" maxlength="3" class="txtFldMin" /></td>
		</tr>
	</table>
	</div>
	
	<table cellspacing="1px" class="TABLEWIDTH" align="center">
		<tr class="FOOTER">
			<td colspan="4" width="25%"><font size="2" color="red">*</font>
			Mandatory Fields</td>
		</tr>
	</table>
	<table  class="TABLEWIDTH" align="center" cellspacing="1px">
	
		<tr>

			<td align="center" colspan="2" width="25%">
			<img src="../../hisglobal/images/btn-sv.png" onClick="validate();" style="cursor: pointer; "/>
			<img src="../../hisglobal/images/btn-clr.png"
				onClick="clearRecord();" style="cursor: pointer; "/>
				<img src="../../hisglobal/images/back_tab.png" onClick ="cancel1();" style="cursor: pointer; ">
			</td>
		</tr>
	</table>

	<input type="hidden" name="strStoreID"
		value="${itemInventoryTransBean.combo[0]}" />
	<input type="hidden" name="strStoreName"
		value="${itemInventoryTransBean.strStoreName}" />
	<input type="hidden" name="strGroupID"
		value="${itemInventoryTransBean.combo[1]}" />	
	<input type="hidden" name="strGroupName"
		value="${itemInventoryTransBean.strGroupName}" />
	<input type="hidden" name="strItemFlag"
		value="${itemInventoryTransBean.strItemFlag}" />
	<input type="hidden" name="hmode" />
	<cmbPers:cmbPers />
	<div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="popUpDivID" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			<div id="itemParameterDtlDivID" style="display: block;"></div>
			</td>
		</tr>
	</table>
	</div>

</html:form>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>