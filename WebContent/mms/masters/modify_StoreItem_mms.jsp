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
<meta charset="utf-8">
<title>Store Item Master Modify</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet"
 type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<script language="javaScript">

function validate1(){   


     
      var hisValidator = new HISValidator("StoreItemBean");
              
			
			//hisValidator.addValidation("strItemShortName", "req", "Drug Short Name is a Mandatory Field" );
            hisValidator.addValidation("strItemId", "dontselect=0","Please select an Item Name " );
            hisValidator.addValidation("strItemBrandId", "dontselect=0","Please select an Brand Name " );
            if(document.forms[0].storeLevel.value=='1') 
            { hisValidator.addValidation("strForeCast", "req", "ForeCast is a Mandatory Field" );
            hisValidator.addValidation("strForeCast", "numltet=100", "Forecast should be less than or equal to 100%" );
            }
            
            if(document.forms[0].storeLevel.value=='1') 
            { hisValidator.addValidation("strReservedQty", "req", "Reserved Qty is a Mandatory Field" );
            hisValidator.addValidation("strReservedQty", "numlt=100", "Reserved Qty should be less than 100%" );
            }
             hisValidator.addValidation("strToleranceLimit", "req", "Tolerance Limit is a Mandatory Field" );
            hisValidator.addValidation("strToleranceLimit", "numltet=100", "Tolerance Limit cannot be greater than 100%" );
           
            hisValidator.addValidation("strReorderQty", "req", "Reorder Level is a Mandatory Field" );
            hisValidator.addValidation("strReorderQty", "amount=9,2", "Reorder Level can be in decimal format(99999.99)" );
            hisValidator.addValidation("strMaxQty", "req", "Maximum Level is a Mandatory Field" );
            if(parseInt(document.forms[0].strMaxQty.value)<parseInt(document.forms[0].strReorderQty.value)){
             	alert("Maximum Level must be greater than Reorder Level");
             	return false;
             }
            hisValidator.addValidation("strMaxQty", "amount=9,2", "Maximum Level can be in decimal format(99999.99)" );
            hisValidator.addValidation("strEffectiveFrom", "req", "Effective from is a Mandatory Field" ); 
           // hisValidator.addValidation("strLevelUnitId", "dontselect=0","Please select an Level unit " );
             
        //    hisValidator.addValidation("strReorderQty", "numltet=document.forms[0].strReservedQty.value", "Reorder Qty should be less than or equal to Reserved Qty" );
            
         	 hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" ); 
			 var retVal = hisValidator.validate();  
			 hisValidator.clearAllValidations(); 
    
    	   if(retVal){
    	  
          				 document.forms[0].hmode.value = "UPDATE";
                        document.forms[0].submit();
            }else{
					return false;
				 }
    }

function BrandCombo()
{ 

	 var url;
	 var mode = 'BRANDNAME';   
	 url="StoreItemMstCNT.cnt?hmode=BRANDNAME&ItemId="+document.forms[0].strItemId.value+"&combo="+document.forms[0].strStoreId.value;
	  ajaxFunction(url,"1");
}
	
function getAjaxResponse(res,mode)
{
		var objVal;
	   if(mode=="1"){   
	
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
				else{
				objVal= document.getElementById("Brand");
				objVal.innerHTML = "<select class='comboNormal' name ='strItemBrandId' >" + res + "</select>";
				}
		 }
}

function firstOnLoad()
{

if(document.forms[0].IsIssuable.value == '1')
document.forms[0].strIssueableFlag.checked=true;

if(document.forms[0].IsReturnable.value == '1')
document.forms[0].strIsReturnable.checked=true;
}	
</script>

</head>
<body onLoad="firstOnLoad();">
<html:form name="StoreItemBean" action="/masters/StoreItemMstCNT"
	type="mms.masters.controller.fb.StoreItemMstFB">
	<html:hidden name ="StoreItemBean" property="strGroupId"></html:hidden>
	<html:hidden name ="StoreItemBean" property="strSubGroupId"></html:hidden>
	<!--<html:hidden name ="StoreItemBean" property="strItemId"></html:hidden>
	<html:hidden name ="StoreItemBean" property="strItemBrandId"></html:hidden>-->
<CENTER>
	<div class="errMsg"><bean:write name="StoreItemBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="StoreItemBean"
		property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="StoreItemBean"
		property="strMsg" /></div>


	<tag:tab tabLabel="Store Item mapping Master"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab></CENTER>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">

		<tr class="HEADER">
			<td colspan="2">Store Item mapping Master&gt;&gt; Modify</td>
		</tr>

		<tr>
			<td class="LABEL">Store Name</td>
			<td width="50%" class="CONTROL"><bean:write name="StoreItemBean"
				property="strStoreName" filter="false" /></td>

		</tr>
		<tr>
			<td class="LABEL" width="50%">Item Category</td>
			<td width="50%" class="CONTROL"><bean:write name="StoreItemBean"
				property="strItemCategoryName" filter="false" /></td>

		</tr>
		<tr>
			<td class="LABEL">Group Name</td>
			<td width="50%" class="CONTROL"><bean:write name="StoreItemBean"
				property="strGroupName" filter="false" /></td>

		</tr>
		<tr>
			<td class="LABEL">Sub Group Name</td>
			<td width="50%" class="CONTROL"><bean:write name="StoreItemBean"
				property="strSubGroupName" filter="false" /></td>

		</tr>
		<tr>
			<td class="LABEL">Generic Item Name</td>
			<td width="50%" class="CONTROL"><bean:write name="StoreItemBean"
				property="strItemName" filter="false" /></td>
		</tr>
		<tr>
			<td class="LABEL">Item Name</td>
			<td width="50%" class="CONTROL"><bean:write name="StoreItemBean"
				property="strItemBrandName" filter="false" /></td>
		</tr>

		
		<tr>
			<td class="LABEL"><font color="red">*</font>VED Category Unit</td>
			<td width="50%" class="CONTROL"><html:select name="StoreItemBean" property="strVEDCategory" >
				<html:option value="1">V</html:option>
				<html:option value="2">E</html:option>
				<html:option value="3">D</html:option>
			</html:select></td>
		</tr>
	</TABLE>

	<logic:equal name="StoreItemBean" property="strStoreLevel" value="1">
		<TABLE class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			<tr>
				<td width="50%" class="LABEL"><font color="red">*</font>Fore
				Cast</td>
				<td width="50%" class="CONTROL"><input type="text" class="txtFldNormal"
					name="strForeCast" maxlength="3" value="${StoreItemBean.strForeCast}"
					onkeypress="return validateData(event,5);"><b> %</b></td>
			</tr>
		</TABLE>
	</logic:equal>

	<TABLE class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">

		<!--  <tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Min Qty
			</td>
			<td class="CONTROL" width="25%"><input type="text" class="txtFldNormal"
				name="strMinQty" maxlength="10" value="${StoreItemBean.strMinQty}"
				onkeypress="return validateData(event,7);"></td>
			<td class="LABEL" width="25%"><font color="red">*</font>Max Qty
			</td>
			<td class="CONTROL" width="25%"><input type="text" class="txtFldNormal"
				name="strMaxQty" maxlength="10" value="${StoreItemBean.strMaxQty}"
				onkeypress="return validateData(event,7);"></td>
		</tr>
		-->
		
		    <tr>
				<td width="50%" class="LABEL"><font color="red">*</font>Reserved
				Qty</td>
				<td width="50%" class="CONTROL"><input type="text" class="txtFldNormal"
					name="strReservedQty" maxlength="2" value="${StoreItemBean.strReservedQty}"
					onkeypress="return validateData(event,5);"><b> %</b></td>
			</tr>
				<tr>
				<td width="50%" class="LABEL"><font color="red">*</font>Tolerance Limit
				</td>
				<td width="50%" class="CONTROL"><input type="text" class="txtFldNormal"
					name="strToleranceLimit" maxlength="3" value="${StoreItemBean.strToleranceLimit}"
					onkeypress="return validateData(event,5);"><b> %</b></td>
			</tr>
	</TABLE>
		
	  <TABLE class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Reorder
			Level</td>
			<td width="50%" class="CONTROL"><input type="text" class="txtFldNormal"
				name="strReorderQty" maxlength="10" value="${StoreItemBean.strReorderQty}"
				onkeypress="return validateData(event,7);"></td>
			</tr>
			<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Max Level
			</td>
			<td width="50%" class="CONTROL"><input type="text" class="txtFldNormal"
				name="strMaxQty" maxlength="11" value="${StoreItemBean.strMaxQty}"
				onkeypress="return validateData(event,7);"></td>
			</tr>
			<tr>
			   <td width="50%" class="LABEL"><font color="red">*</font>Max Indent Qty</td>
			   <td width="50%" class="CONTROL"><input type="text"
				name="strMaxIndentQty" maxlength="11" value="${StoreItemBean.strMaxIndentQty}" class="txtFldNormal"
				onkeypress="return validateData(event,7);"></td>
		     </tr>
			
			<!--<tr>
			<td class="LABEL" width="50%" ><di<font color="red">*</font>Level Unit</td>
			<td width="50%" class="CONTROL">&nbsp; <bean:write name="StoreItemBean" property="strLevelUnitName" filter="false"/>  
			<input type="hidden" name="strLevelUnitId" value="${StoreItemBean.strLevelUnitId }">  </td>
		</tr>  -->
		</table>
		<TABLE class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td width="25%" class="LABEL">Is Issueable</td>
			<td width="25%" class="CONTROL"><input name="strIssueableFlag"
				type="checkbox" value="1"></td>
			<td width="25%" class="LABEL">Is Returnable</td>
			<td width="25%" class="CONTROL"><input name="strIsReturnable"
				type="checkbox" value="1"></td>
		</tr>

	</table>
	<TABLE class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">

		<tr>
			<td class="LABEL" width="50%">
			<div align="right"><font
				color="red">*</font>Effective From</div>
			</td>
			<td class="CONTROL"><bean:write name="StoreItemBean" property="strEffectiveFrom" /></td>
		</tr>


		<tr>
			<td width="50%" class="LABEL" valign="top">Remarks if Any</td>
			<td width="50%" class="CONTROL"><textarea name="strRemarks"
				cols="25" rows="2"><bean:write name="StoreItemBean" property="strRemarks"/></textarea></td>
		</tr>
 <tr >
    <td width ="45%" class ="LABEL">Record Status </td>
    <td width ="45%" class ="CONTROL" >
   <html:radio name="StoreItemBean" property="strIsValid" value="1">Active</html:radio>
    <html:radio name="StoreItemBean" property="strIsValid" value="2">Inactive</html:radio>
    
   </td>
    </tr>

		<tr class="FOOTER">
			<td colspan="2"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>

	</table>

<!-- 	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>

			<td align="center"><img style="cursor: pointer; " title="Save Record"
				src="../../hisglobal/images/btn-sv.png"
				onClick=" return validate1();" /> 
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" 
				onClick="cancel('LIST');" /></td>
		</tr>
	</table>-->
	<br>
<div align="center" id="">					 
					 	<a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
				</div>
	<input type="hidden" name="hmode" />
	 <input type="hidden" name="chk" value="${StoreItemBean.strChk1 }">
	<input type="hidden" name="strStoreId"
		value="${StoreItemBean.combo[0]}">
		
	<input type="hidden" name="storeLevel"
		value="${StoreItemBean.strStoreLevel}"> 
		
	<input type="hidden" name="strStoreName"
		value="${StoreItemBean.strStoreName}">
		
	<input type="hidden" name="IsIssuable"
		value="${StoreItemBean.strIssueableFlag}">
		
	<input type="hidden" name="IsReturnable"
		value="${StoreItemBean.strIsReturnable}">
	
	<input type="hidden" name="comboValue"
		value="${StoreItemBean.strComboValue}">
		
		<input type="hidden" name="strItemShortName"	value="${StoreItemBean.strItemShortName}">
		
		<input type="hidden" name="strCategoryNo"
		value="${StoreItemBean.strCategoryNo}"> 
	<input type="hidden" name="strEffectiveFrom"
				value="${StoreItemBean.strEffectiveFrom}">
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>