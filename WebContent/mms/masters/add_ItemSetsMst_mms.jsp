<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=utf-8>
<title>Item Sets Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="javaScript">

function showDetails(divId){
            document.getElementById(divId).style.display="block";                     
            document.getElementById('minus'+divId).style.display="block";
            document.getElementById('plus'+divId).style.display="none";
}

function hideDetails(divId){
			document.getElementById(divId).style.display="none";
            document.getElementById('minus'+divId).style.display="none";
            document.getElementById('plus'+divId).style.display="block";
}

function ajaxSubGroup()
{ 
   var mode ="SUBGROUPNAME";  
   var url="ItemSetsMstCNT.cnt?hmode=SUBGROUPNAME&groupName="+document.forms[0].strGroupName.value+"&itemcatId="+document.forms[0].strItemCatId.value;
   ajaxFunction(url,"1");
  
}
function ajaxGroup()
{ 
   var mode ="GROUPNAME";  
   var url="ItemSetsMstCNT.cnt?hmode=GROUPNAME&itemcatId="+document.forms[0].strItemCatId.value;
  
   ajaxFunction(url,"4");
}
function ajaxGenItemName(mode)
{ 
   var mode ="GENITEMNAME";  
   var url="ItemSetsMstCNT.cnt?hmode=GENITEMNAME&groupName="+document.forms[0].strGroupName.value+"&itemcatId="+document.forms[0].strItemCatId.value+"&subGroupName="+document.forms[0].strSubGroupName[document.forms[0].strSubGroupName.selectedIndex].value;
   ajaxFunction(url,"3");
}
function ajaxItemName(mode)
{
// alert("ajaxItemName");
// alert("document.forms[0].strSubGroupName.value"+document.forms[0].strSubGroupName.value);
// alert("document.forms[0].strItemCategoryNo.value"+document.forms[0].strItemCategoryNo.value); 
// alert("document.forms[0].strGroupName.value"+document.forms[0].strGroupName.value);  
 	var elementItemCatId=document.getElementsByName("strItemCatId")[0];
 	var elementGroupName=document.getElementsByName("strGroupName")[0];
	var mode ="ITEMNAME";
	//alert("Cat Id:"+elementItemCatId.value);
	//alert("Group Id:"+elementGroupName.value);
   var url="ItemSetsMstCNT.cnt?hmode=ITEMNAME&GenItemId="+document.forms[0].strGenItemId[document.forms[0].strGenItemId.selectedIndex].value+"&strItemCategoryNo="+elementItemCatId.value+"&strGroupId="+elementGroupName.value;
   
   ajaxFunction(url,"2");
}

function UnitCombo()
{

	 var url;
	 var mode = 'UNITNAME';   
	 var strGenItemId = document.forms[0].strGenItemId;
	 if(strGenItemId!=null) {
		 strGenItemId=strGenItemId.value;
	 }
	 var strItemId = document.forms[0].strItemId.value;
	 var strItemCatId = document.forms[0].strItemCatId.value;
	 
	 url="ItemSetsMstCNT.cnt?hmode=UNITNAME&strGenItemId="+strGenItemId+"&strItemId="+strItemId+"&strItemCatId="+strItemCatId; 
	 ajaxFunction(url,"5");
}
function getAjaxResponse(res,mode){
				
				var objVal;
				var objVal2;
				if(mode=="1"){		
				var temp = res.split("##");		
					objVal= document.getElementById("SubGroupId");
					objVal.innerHTML = "<select name ='strSubGroupName' class='comboNormal' onChange = 'ajaxGenItemName(\"GENITEMNAME\")' >" + temp[0] + "</select>";
					
					objVal= document.getElementById("GenItemNameId");
					objVal.innerHTML = "<select name ='strGenItemId' class='comboNormal'  onChange = 'ajaxItemName(\"ITEMNAME\")' >" + temp[1] + "</select>";
					
					
					//alert("GenItemNameId");
					objVal= document.getElementById("GenItemNameId");
					objVal.innerHTML = "<select name ='strGenItemId' class='comboNormal'  onChange = 'ajaxItemName(\"ITEMNAME\")'  ><option title='Select Value' selected='selected' value='0'>Select Value</option></select>";
					
					//alert("ItemNameId");
					objVal= document.getElementById("ItemNameId");
					objVal.innerHTML = "<select name ='strItemId' class='comboNormal' onchange='UnitCombo();'><option title='Select Value' selected='selected' value='0'>Select Value</option></select>";
					
					//alert("UnitDivId");
					objVal= document.getElementById("UnitDivId"); 
					objVal.innerHTML = "<select name ='strUnitId' ><option title='Select Value' selected='selected' value='0'>Select Value</option></select>";
					
					ajaxGenItemName("GENITEMNAME");
					//ajaxItemName('ITEMNAME');
					
				}
				if(mode=="2"){	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
	        		if(temp1[0] == "ERROR"){
	         			err.innerHTML = temp1[1];	
	        			 }
					else{			
						objVal= document.getElementById("ItemNameId");
						objVal.innerHTML = "<select name ='strItemId' class='comboNormal' onchange='UnitCombo();'>" + res + "</select>";
						//UnitCombo();			
					}
	        		//alert("UnitDivId");
					objVal= document.getElementById("UnitDivId"); 
					objVal.innerHTML = "<select name ='strUnitId' ><option title='Select Value' selected='selected' value='0'>Select Value</option></select>";
					
					
					
				}
				if(mode=="3"){
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
	        		 if(temp1[0] == "ERROR"){
	         			err.innerHTML = temp1[1];	
	        			 }
					else{				
						objVal= document.getElementById("GenItemNameId");
						objVal.innerHTML = "<select name ='strGenItemId' class='comboNormal'  onChange = 'ajaxItemName(\"ITEMNAME\")'  >" + res + "</select>";
										
					}
	        		 
	        		//alert("ItemNameId");
					objVal= document.getElementById("ItemNameId");
					objVal.innerHTML = "<select name ='strItemId' class='comboNormal' onchange='UnitCombo();'><option title='Select Value' selected='selected' value='0'>Select Value</option></select>";
						
					//alert("UnitDivId");
					objVal= document.getElementById("UnitDivId"); 
					objVal.innerHTML = "<select name ='strUnitId' ><option title='Select Value' selected='selected' value='0'>Select Value</option></select>";
						
					ajaxItemName('ITEMNAME');
				}
				if(mode=="4"){	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
	        		 if(temp1[0] == "ERROR"){
	         			err.innerHTML = temp1[1];	
	        			 }
					else{			
						objVal= document.getElementById("GroupId");
						objVal.innerHTML = "<select name='strGroupName'	class='comboNormal' onChange='ajaxSubGroup();'>" + res + "</select>";
						//alert("SubGroupId");
						objVal= document.getElementById("SubGroupId");
						objVal.innerHTML = "<select name ='strSubGroupName' class='comboNormal' onChange = 'ajaxGenItemName(\"GENITEMNAME\")' ><option title='Select Value' selected='selected' value='0'>Select Value</option></select>";
						//alert("GenItemNameId");
						objVal= document.getElementById("GenItemNameId");
						objVal.innerHTML = "<select name ='strGenItemId' class='comboNormal'  onChange = 'ajaxItemName(\"ITEMNAME\")'  ><option title='Select Value' selected='selected' value='0'>Select Value</option></select>";
						
						//alert("ItemNameId");
						objVal= document.getElementById("ItemNameId");
						objVal.innerHTML = "<select name ='strItemId' class='comboNormal' onchange='UnitCombo();'><option title='Select Value' selected='selected' value='0'>Select Value</option></select>";
						
						//alert("UnitDivId");
						objVal= document.getElementById("UnitDivId"); 
						objVal.innerHTML = "<select name ='strUnitId' ><option title='Select Value' selected='selected' value='0'>Select Value</option></select>";
					}
				}
				if(mode=="5"){   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
	        		if(temp1[0] == "ERROR"){
	         			err.innerHTML = temp1[1];	
	        			 }
					else{
					objVal= document.getElementById("UnitDivId"); 
					objVal.innerHTML = "<select name ='strUnitId' >" + res + "</select>";
					}
				 }
				
}

function validate1(){   
     
            var hisValidator = new HISValidator("ItemSetsMstBean");
            hisValidator.addValidation("strGroupName", "dontselect=0", "Please select a value from Group" );
             //hisValidator.addValidation("strGenItemId", "dontselect=0", "Please select a value from Generic Item Name" );
            hisValidator.addValidation("strItemId", "dontselect=0", "Please select a value from Item Name" );
           hisValidator.addValidation("strItemCatId", "dontselect=0", "Please select a value from Item Category" );
            hisValidator.addValidation("strItemQuantity", "req", "Item Quantity is Mandatory Field" );
            hisValidator.addValidation("strUnitId", "dontselect=0", "Please select a value from Unit" );
            hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
            hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
		    //hisValidator.addValidation("strEffectiveFrom", "dtgtet=${ItemSetsMstBean.strCtDate}" , "Effective Date should be Greater than or Equal to Current Date");
            var retVal = hisValidator.validate(); 
            hisValidator.clearAllValidations();

          if(retVal){
          
                       document.forms[0].hmode.value = "SAVE";
                       document.forms[0].submit();
          }else{
             return false;
          }
}

function view(){
	var obj = document.getElementById("itemId1");
	obj.style.display="block";
}


</script>
</head>
<body onLoad="document.forms[0].strGroupName.focus()">
<html:form name="ItemSetsMstBean" action="/masters/ItemSetsMstCNT"
	type="mms.masters.controller.fb.ItemSetsMstFB">
<center>
	<div id="errMsg" class="errMsg"><bean:write
		name="ItemSetsMstBean" property="strErrorMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="ItemSetsMstBean" property="strMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="ItemSetsMstBean" property="strWarning" /></div>


	<tag:tab tabLabel="Item Sets Master"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
</center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="8">Item Sets Master&gt;&gt; Add</td>
		</tr>

		<tr>
			<td colspan="4" width="50%" class="LABEL">Set Category Name</td>
			<td colspan="4" width="50%" class="CONTROL"><bean:write
				name="ItemSetsMstBean" property="strItemCategoryName" filter="false" />
		</tr>
		<tr>
			<td colspan="4" width="50%" class="LABEL">Generic Item Name</td>
			<td colspan="4" width="50%" class="CONTROL"><bean:write
				name="ItemSetsMstBean" property="strGenItemName" filter="false" /></td>
		</tr>
		<tr>
			<td colspan="4" width="50%" class="LABEL">Set Name</td>
			<td colspan="4" width="50%" class="CONTROL"><bean:write
				name="ItemSetsMstBean" property="strSetName" filter="false" /></td>
		</tr>
	</table>


	<div id="itemId" style="display: block;">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td class="multiLabel" width="5%">

			<div id="plusItemDivId" style="display: none"><img
				src="../../hisglobal/images/plus.gif" name="plusonLine"
				align="middle" onclick="showDetails('ItemDivId');" /></div>

			<div id="minusItemDivId" style="display: block;"><img
				src="../../hisglobal/images/minus.gif" name="minusonLine"
				onclick="hideDetails('ItemDivId');"></div>

			</td>


			<td colspan="7" width="95%" class="TITLE">Added Item Details</td>
		</tr>
	</table>
	</div>

	<div id="ItemDivId" style="display: block"><bean:write
		name="ItemSetsMstBean" property="strAddedItemDetails" filter="false" /></div>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="TITLE">
			<td colspan="8">Item Details</td>
		</tr>

		<tr>
			<td colspan="4" class="LABEL" width="50%"><font color="red">*</font>Item
			Category Name</td>
			<td colspan="4" class="CONTROL" width="50%"><select
				name="strItemCatId" class='comboNormal' onChange="ajaxGroup();">
				<bean:write name="ItemSetsMstBean" property="strItemCatCombo"
					filter="false" />

			</select></td>
		</tr>

		<tr>
			<td colspan="4" class="LABEL" width="50%"><font color="red">*</font>Group
			Name</td>
			<td colspan="4" class="CONTROL" width="50%"><div id="GroupId"><select name="strGroupName"
				class="comboNormal" onChange="ajaxSubGroup();">
				<option value="0">Select Value</option>
			</select></div></td>
		</tr>

		<tr>
			<td colspan="4" class="LABEL" width="50%">Sub Group Name</td>
			<td colspan="4" class="CONTROL" width="50%">
			<div id="SubGroupId"><select name="strSubGroupName"
				class="comboNormal" onChange="ajaxGenItemName('GENITEMNAME');">
				<option value="0">Select Value</option>
			</select></div>
			</td>
		</tr>
		<tr>
			<td colspan="4" class="LABEL" width="50%">Generic Item
			Name</td>
			<td colspan="4" class="CONTROL" width="50%">
			<div id="GenItemNameId"><select name="strGenItemId"
				class='comboNormal' onChange="ajaxItemName('ITEMNAME');">
				<option value="0">Select Value</option>
			</select></div>
			</td>
		</tr>
		<tr>
			<td colspan="4" class="LABEL" width="50%"><font color="red">*</font>Item
			Name</td>
			<td colspan="4" class="CONTROL" width="50%">
			<div id="ItemNameId"><select name="strItemId"
				class='comboNormal' onchange='UnitCombo();'>
				<option value="0">Select Value</option>
			</select></div>
			</td>
		</tr>

		<tr>
			<td colspan="4" class="LABEL"><font color="red">*</font>Item
			Quantity</td>
			<td colspan="4" width="50%" class="CONTROL"><input type="text"
				name="strItemQuantity" class='txtFldNormal' value="" maxlength="25"
				onkeypress="return validateData(event,5);"></td>
		</tr>
		<tr>
			<td colspan="4" class="LABEL" width="50%"><font color="red">*</font>Unit
			Name</td>
			<td colspan="4" class="CONTROL" width="50%"><div id="UnitDivId"><select
				name="strUnitId" class='comboNormal' >
				<option value="0">Select Value</option>
			</select></div></td>
		</tr>
		<tr>
			<td colspan="4" width="50%" class="LABEL"><font color="red">*</font>Effective
			From</td>
			<td colspan="4" class="CONTROL"><date:date
				name="strEffectiveFrom" value="${ItemSetsMstBean.strCtDate}"></date:date></td>
		</tr>
		<tr>
			<td colspan="4" width="50%" class="LABEL">Remarks</td>
			<td colspan="4" width="50%" class="CONTROL">
			<div align="left"><textarea name="strRemarks" rows="2"></textarea>
			</div>
			</td>
		</tr>

		<tr class="FOOTER">
			<td colspan="8"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>

			<td align="center"><img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" title="Save Record"
				onClick=" return validate1();" /> <img
				style="cursor: pointer; "
				src="../../hisglobal/images/btn-clr.png" title="Reset Content"
				onClick="document.forms[0].reset();" /> <img
				style="cursor: pointer; "
				src="../../hisglobal/images/btn-ccl.png" title="Cancel Process"
				onClick="cancel('LIST');" /></td>
		</tr>
	</table>

	
<input type="hidden" name="strItemCategoryNo"
		value="${ItemSetsMstBean.combo[0]}" />
	
<input type="hidden" name="strItemCategoryName"
		value="${ItemSetsMstBean.strItemCategoryName}" />
	<!--<input type="hidden" name="strSetId"
		value="${ItemSetsMstBean.combo[2]}" />
	--><!--<input type="hidden" name="strGenItemId"
		value="${ItemSetsMstBean.combo[1]}" />
	--><input type="hidden" name="strSetName"
		value="${ItemSetsMstBean.strSetName}" />
	<input type="hidden" name="strCtDate"
		value="${ItemSetsMstBean.strCtDate}" />
	<input type="hidden" name="combo"
		value="${ItemSetsMstBean.combo[0]}" />
	<input type="hidden" name="combo"
		value="${ItemSetsMstBean.combo[1]}" />
	<input type="hidden" name="combo"
		value="${ItemSetsMstBean.combo[2]}" />
	<input type="hidden" name="comboValue"
		value="${ItemSetsMstBean.strComboValues}" />
	<input type="hidden" name="hmode" />
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>