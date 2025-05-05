<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset=utf-8>
<title>Store Item mapping Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<script language="javaScript">

function validate1(){   
     
      var hisValidator = new HISValidator("StoreItemBean");
              
			hisValidator.addValidation("strGroupId", "dontselect=0","Please select a Group Name " );
			
            // Commented By Amit 23 - Dec - 2010 hisValidator.addValidation("strItemShortName", "req", "Drug Short Name is a Mandatory Field" );
            
            // hisValidator.addValidation("strItemId", "dontselect=0","Please select an Generic Drug Name " );
            if(document.forms[0].strItemId.value!='0')
            { 
               hisValidator.addValidation("strItemBrandId", "dontselect=0","Please select an Item Name " );
            }            
            if(document.forms[0].storeLevel.value=='1') 
            { 
               hisValidator.addValidation("strForeCast", "req", "ForeCast is a Mandatory Field" );
               hisValidator.addValidation("strForeCast", "numltet=100", "Forecast should be less than or equal to 100%" );
            }
            
            if(document.forms[0].storeLevel.value=='1') 
            { hisValidator.addValidation("strReservedQty", "req", "Reserved Qty is a Mandatory Field" );
            hisValidator.addValidation("strReservedQty", "numlt=100", "Reserved Qty should be less than 100%" );
            }
            
            hisValidator.addValidation("strToleranceLimit", "req", "Tolerance Limit is a Mandatory Field" );
            hisValidator.addValidation("strToleranceLimit", "numltet=100", "Tolerance Limit cannot be greater than 100%" );
           
            
            hisValidator.addValidation("strReorderQty", "req", "Reorder Level is a Mandatory Field" );
            hisValidator.addValidation("strMaxQty", "req", "Maximum Level is a Mandatory Field" );
            if(parseInt(document.forms[0].strMaxQty.value)<parseInt(document.forms[0].strReorderQty.value)){
             	alert("Maximum Level must be greater than Reorder Level");
             	return false;
             }
             hisValidator.addValidation("strMaxQty", "amount=9,2", "Maximum Level can be in decimal format(99999.99)" );
            hisValidator.addValidation("strReorderQty", "amount=9,2", "Reorder Level can be in decimal format(99999.99)" );
            hisValidator.addValidation("strEffectiveFrom", "req", "Effective from is a Mandatory Field" ); 
         //   hisValidator.addValidation("strLevelUnitId", "dontselect=0","Please select an Level unit " );
             
           //  hisValidator.addValidation("strReorderQty", "numltet=document.forms[0].strReservedQty.value", "Reorder Qty should be less than or equal to Reserved Qty" );
            
         	 hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" ); 
			 var retVal = hisValidator.validate(); 
    	
    	
          if(retVal){
          				 document.forms[0].hmode.value = "SAVE";
                        document.forms[0].submit();
            }else{
					return false;
				 }
    }

function BrandCombo()
{ 
	 var url;
	 var mode = 'BRANDNAME';   
	 var itemid = document.forms[0].strItemId.value;
	 if(itemid!='0')
	 {
	       var  objVal = document.getElementById("mandatory");
				objVal.innerHTML = "<font color='red'>*</font>Item Name";
	 }
	 else
	 {
	   var  objVal = document.getElementById("mandatory");
				objVal.innerHTML = "ItemName";
	 }
	 var temp = itemid.split('^');
	 url="StoreItemMstCNT.cnt?hmode=BRANDNAME&ItemId="+temp[0]+"&combo="+document.forms[0].strStoreId.value+"&CategoryNo="+document.forms[0].strCategoryNo.value;    
	 
	 ajaxFunction(url,"1");
}
function SubGroupCombo()
{	
	 var url;
	 var mode = 'SUBGROUPNAME';   
	 url="StoreItemMstCNT.cnt?hmode=SUBGROUPNAME&GroupId="+document.forms[0].strGroupId.value+"&CategoryNo="+document.forms[0].strCategoryNo.value+"&StoreId="+document.forms[0].strStoreId.value;     
	 
	 ajaxFunction(url,"2");
}

function ItemNameCombo()
{

	 var url;
	 var mode = 'ITEMNAME';   
	 url="StoreItemMstCNT.cnt?hmode=ITEMNAME&GroupId="+document.forms[0].strGroupId.value+
	 "&SubGroupId="+document.forms[0].strSubGroupId.value+"&StoreComboId="+document.forms[0].strStoreId.value+"&CategoryNo="+document.forms[0].strCategoryNo.value;     
	 ajaxFunction(url,"3");
}


function UnitCombo()
{

	 var url;
	 var mode = 'UNITCOMBO';   
	 var strItemId = document.forms[0].strItemId.value;
	
	
	if(strItemId == 0){
		
		document.forms[0].strLevelUnitId.value = 0;
				
				objVal= document.getElementById("UnitDivId"); 
				objVal.innerHTML = "/";
		
	}else{
		 url="StoreItemMstCNT.cnt?hmode=UNITCOMBO&strItemId="+strItemId; 
		 ajaxFunction(url,"4");
	 }
}

function reSetDiv()
{
           var  objVal = document.getElementById("mandatory");
				objVal.innerHTML = "<font color='red'>*</font>Item Name";

}


function getAjaxResponse(res,mode)
{
		var objVal;
		var objVal2;
		
		if(mode=="5")
		{   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR")
        		 {
         			err.innerHTML = temp1[1];	
        		 }
				else
				{
				   objVal= document.getElementById("Brand");
				   objVal.innerHTML = "<select class='comboNormal' name ='strItemBrandId' >" + res + "</select>";
							
				}
		 }
	   if(mode=="1"){   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
				else{
				objVal= document.getElementById("Brand");
				objVal.innerHTML = "<select class='comboNormal' name ='strItemBrandId' >" + res + "</select>";
				
				UnitCombo();
				
				
				}
		 }
		  if(mode=="2")
		  {   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
				else{
				var temp = res.split("#");	
				
				objVal= document.getElementById("SubGroupDivId"); 
				objVal.innerHTML = "<select class='comboNormal' name ='strSubGroupId' onChange='ItemNameCombo();'>" + temp[0] + "</select>";
				
				objVal2= document.getElementById("ItemNameDivId");
				objVal2.innerHTML = "<select name ='strItemId' class='comboNormal' onchange='BrandCombo();' >" + temp[1] + "</select>";
				
				   objVal3= document.getElementById("Brand");
				   objVal3.innerHTML = "<select class='comboNormal' name ='strItemBrandId' >" + temp[2] + "</select>";
				}
		 }
		 if(mode=="3"){   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
				else{
				objVal= document.getElementById("ItemNameDivId"); 
				objVal.innerHTML = "<select name ='strItemId' class='comboNormal' onchange='BrandCombo();'>" + res + "</select>";
				}
		 }
		 if(mode=="4"){   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
				else{
				
				var vals = res.split("^");
				
				if(vals.length > 0){
				
				document.forms[0].strLevelUnitId.value = vals[0];
				
				objVal= document.getElementById("UnitDivId"); 
				objVal.innerHTML = vals[1];
				}else{
				
				document.forms[0].strLevelUnitId.value = 0;
				
				objVal= document.getElementById("UnitDivId"); 
				objVal.innerHTML = "/";
				
				}
				
				}
		 }
}

</script>

</head>
<body onLoad="">
<html:form name="StoreItemBean" action="/masters/StoreItemMstCNT"
	type="mms.masters.controller.fb.StoreItemMstFB">
	<center>
	<div id="errMsg" class="errMsg"><bean:write name="StoreItemBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="StoreItemBean"
		property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="StoreItemBean" property="strMsg" /></div>


	<tag:tab tabLabel="Store Item mapping Master" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab></center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">

		<tr class="HEADER">
			<td colspan="2">Store Item mapping Master&gt;&gt; Add</td>
		</tr>

		<tr>
			<td class="LABEL" width="50%">Store Name</td>
			<td width="50%" class="CONTROL"><bean:write name="StoreItemBean"
				property="strStoreName" filter="false" /></td>

		</tr>
		<tr>
			<td class="LABEL" width="50%">Item Category</td>
			<td width="50%" class="CONTROL"><bean:write name="StoreItemBean"
				property="strItemCategoryName" filter="false" /></td>

		</tr>
		<tr>
			<td class="LABEL" width="50%"><font color="red">*</font>Group
			Name</td>
			<td width="50%" class="CONTROL"><html:select
				name="StoreItemBean" property="strGroupId"
				onchange="SubGroupCombo();">
				<bean:write name="StoreItemBean" property="strGroupNameCombo"
					filter="false" />
			</html:select></td>
		</tr>
		<tr>
			<td class="LABEL" width="50%">Sub Group Name</td>
			<td width="50%" class="CONTROL">
			<div id="SubGroupDivId"><Select name="strSubGroupId">
				<option value="0">Select Value</option>
			</Select></div>
			</td>
		</tr>
		<tr>
			<td class="LABEL" width="50%">Generic
			Item Name</td>
			<td width="50%" class="CONTROL">
			<div id="ItemNameDivId"><select class="comboNormal"  name="strItemId"
				onchange="BrandCombo();">
				<option value="0">Select Value</option>
			</select></div>
			</td>
		</tr>
		<tr>
			<td class="LABEL" width="50%"><div id='mandatory'>Item Name</div></td>
			<td width="50%" class="CONTROL">
			<div id="Brand"><select name="strItemBrandId"
				class="comboNormal">
				<option value="0">All Value</option>
			</select></div>
			</td>
		</tr>

		<tr>
			<td class="LABEL" width="50%"><font color="red">*</font>VED
			Category Unit</td>
			<td width="50%" class="CONTROL"><select name="strVEDCategory"
				class="comboMin">
				<option value="2">E</option>
				<option value="1">V</option>
				
				<option value="3">D</option>
			</select></td>
		</tr>
	</TABLE>

	<logic:equal name="StoreItemBean" property="strStoreLevel" value="1">
		<TABLE class="TABLEWIDTH" align="center" cellpadding="1px"
			cellspacing="1px">
			<tr>
				<td width="50%" class="LABEL"><font color="red">*</font>Fore
				Cast</td>
				<td width="50%" class="CONTROL"><input type="text"
					class="txtFldNormal" name="strForeCast" maxlength="3" value="10"
					onkeypress="return validateData(event,5);"><b> %</b></td>
			</tr>
		</TABLE>
	</logic:equal>

	<TABLE class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">

		
		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Reserved
			Qty</td>
			<td width="50%" class="CONTROL"><input type="text"
				class="txtFldNormal" name="strReservedQty" maxlength="2" value="2"
				onkeypress="return validateData(event,5);"><b> %</b></td>
		</tr>
		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Tolerance
			Limit</td>
			<td width="50%" class="CONTROL"><input type="text"
				class="txtFldNormal" name="strToleranceLimit" maxlength="3" value="10"
				onkeypress="return validateData(event,5);"><b> %</b></td>
		</tr>
	</TABLE>
	<TABLE class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td class="TITLE" colspan="2">Level Details</td>

		</tr>
		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Reorder
			Level</td>
			<td width="50%" class="CONTROL"><input type="text"
				name="strReorderQty" maxlength="10" value="10" class="txtFldNormal"
				onkeypress="return validateData(event,7);"></td>


		</tr>
		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Max
			Level</td>
			<td width="50%" class="CONTROL"><input type="text"
				name="strMaxQty" maxlength="11" value="1000" class="txtFldNormal"
				onkeypress="return validateData(event,7);"></td>
		</tr>
		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Max Indent Qty</td>
			<td width="50%" class="CONTROL"><input type="text"
				name="strMaxIndentQty" maxlength="11" value="1000" class="txtFldNormal"
				onkeypress="return validateData(event,7);"></td>
		</tr>
		<tr style="display: none;">
			<td class="LABEL" width="50%"><font color="red">*</font>Level
			Unit</td>
			<td width="50%" class="CONTROL">
			<div id="UnitDivId">/</div>
			<input type="hidden" name="strLevelUnitId" value=""></td>

		</tr>
		<tr>
			<td class="TITLE" colspan="2"></td>

		</tr>
	</table>
	<TABLE class="TABLEWIDTH" align="center" cellpadding="0px"
		cellspacing="1px">
		<tr>
			<td width="25%" class="LABEL">Is Issueable</td>
			<td width="25%" class="CONTROL"><input name="strIssueableFlag"
				type="checkbox" value="1" checked></td>
			<td width="25%" class="LABEL">Is Returnable</td>
			<td width="25%" class="CONTROL"><input name="strIsReturnable"
				type="checkbox" value="1"></td>
		</tr>

	</table>
	<TABLE class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">

		<tr>
			<td class="LABEL" width="50%">
			<div align="right"><font color="red">*</font>Effective From</div>
			</td>
			<td class="CONTROL"><dateTag:date name="strEffectiveFrom"
				value="${StoreItemBean.strCtDate}"></dateTag:date></td>
		</tr>


		<tr>
			<td width="50%" class="LABEL" valign="top">Remarks if Any</td>
			<td width="50%" class="CONTROL"><textarea name="strRemarks"
				cols="25" rows="2"></textarea></td>
		</tr>


		<tr class="FOOTER">
			<td colspan="2"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>

	</table>

<!-- 	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>

			<td align="center"><img style="cursor: pointer; "
				title="Save Record" src="../../hisglobal/images/btn-sv.png"
				onClick=" return validate1();" /> <img
				style="cursor: pointer; " title="Reset Content"
				src="../../hisglobal/images/btn-clr.png"
				onClick="document.forms[0].reset();" />
			<img style="cursor: pointer; " title="Cancel Process"
				src="../../hisglobal/images/btn-ccl.png"
				onClick="cancel('LIST');" /></td>
		</tr>
	</table> -->
	<br>
<div align="center" id=" ">					 
					 	<a href="#" class="button" id=" " onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="document.forms[0].reset();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
				</div>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strStoreId"
		value="${StoreItemBean.combo[0]}">

	<input type="hidden" name="strCategoryNo"
		value="${StoreItemBean.combo[1]}">

	<input type="hidden" name="storeLevel"
		value="${StoreItemBean.strStoreLevel}">

	<input type="hidden" name="comboValue"
		value="${StoreItemBean.strComboValue}">

	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>