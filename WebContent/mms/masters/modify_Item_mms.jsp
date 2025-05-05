<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset="utf-8">
<title>Insert Title Here</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>

<script language="JavaScript" src="../../hisglobal/js/util.js"></script>



<script type="text/javascript">

	function validate()
	{
		document.forms[0].strBatchNo.disabled = false;
		document.forms[0].strBatchNo.checked = true;
		document.forms[0].strBatchNo.value = "1";
		
		var hisValidator = new HISValidator("itemBean");
		
		if(document.forms[0].strIsItemCodeRequired.value == '1'){
			 hisValidator.addValidation("strNewCPACode", "req", "Item Code is a Mandatory Field" );
		}
		
	    hisValidator.addValidation("strItemTypeId", "dontselect=0","Please Select Item Type"); 
        hisValidator.addValidation("strItemName", "req", "Item Name is a Mandatory Field" );
      
      
        /* Manufacturer is not mandatory for non branded items. */
		if(document.getElementsByName("strBrandReserveFlag")[0].value!=2){
        	
        	hisValidator.addValidation("strManufacturerId", "dontselect=0", "Please Select Manufacturer" );
        }
       
        //hisValidator.addValidation("strDefaultRate", "req", "Default Rate is a Mandatory Field" );
        hisValidator.addValidation("strDefaultRate", "amount=9,2", "Default Rate should be in format 0000000.00" );
       // hisValidator.addValidation("strRateUnitId", "dontselect=0","Please Select Rate Unit");
        hisValidator.addValidation("strApprovedType", "dontselect=0","Please Select ApprovedType Type"); 
        hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
        
        hisValidator.addValidation("MAX_VALUE", "maxlen=6", "Maximum should have less than or equal to 6 Digit" );
        hisValidator.addValidation("MIN_VALUE", "maxlen=6", "Minimum should have less than or equal to 6 Digit" );
        
		/* Specification is not mandatory for non branded items. */
		//if(document.getElementsByName("strBrandReserveFlag")[0].value!=2){
        	
			hisValidator.addValidation("strSpecification", "req", "Specification Field is a Mandatory Field" );
       // }
        
        hisValidator.addValidation("strSpecification", "maxlen=4000", "Specifications should have less than or equal to 4000 Characters" ); 
        
        if(document.forms[0].strEclCat.checked == true){
       	 document.forms[0].strEclCat.value='1';
     	}else{
     		document.forms[0].strEclCat.value='0';
     	 }
        
       //RJ47 document.forms[0].strEclCat.value = document.forms[0].strEclCat.checked ? '1' : '0';

        var retVal = hisValidator.validate();
        hisValidator.clearAllValidations();
       
        if(retVal) 
		   {
		   
        	document.forms[0].MIN_VALUE = document.getElementsByName("MIN_VALUE").value;
			document.forms[0].MAX_VALUE = document.getElementsByName("MAX_VALUE").value;
			//document.forms[0].TEMP_SENS_FLAG = document.getElementsByName("TEMP_SENS_FLAG").value;
			document.forms[0].TEMP_SENS_FLAG ="0";
			document.forms[0].strEclCat = document.getElementsByName("strEclCat")[0].value;
	   	//	alert('document.forms[0].strEclCat');
			
			document.forms[0].hmode.value="UPDATE";
			document.forms[0].submit();
		   }
		   else{
               return false;
             }
	}
	function checkbox(){
		if(document.forms[0].strHidSparePartFlag.value == 1){
			document.forms[0].strSparePartFlag.checked = true;
		}
		if(document.forms[0].strHidSetSachetFlag.value == 1){
			document.forms[0].strSetSachetFlag.checked = true;
		}
		if(document.forms[0].strHidIsQuantified.value == 1){
			document.forms[0].strIsQuantified.checked = true;
		}
		//alert(document.getElementsByName('strIsMisc')[0].value);
		if(document.getElementsByName('strIsMisc')[0].value == 1){
			
			
			document.getElementsByName('strIsMisc')[0].checked = true;
		
		}
		if(document.forms[0].strSterilizationFlag.value == 1)
		{
			document.forms[0].strSterilizationFlag.checked = true;
			document.getElementById("life").style.display = "table-row";
		}
		else
		{
		    document.getElementById("life").style.display = "none";
		}
		if(document.getElementsByName("strUploadFileId")[0].value!="")
		{
		     document.getElementById("showUploadFileDtl").style.display = "block";
		}
		else
		{
		     document.getElementById("showUploadFileDtl").style.display = "none";
		}
	  	 
		
	}
	
	function showSterilizationLife()
	{
	  if(document.getElementsByName("strSterilizationFlag")[0].checked)
	  {
	     document.getElementById("life").style.display = "table-row";
	  }
	  else
	  {
	     document.getElementById("life").style.display = "none";
	  }
	    
	}
	
	function showFileUpload()
	{
	  if(document.getElementsByName("strUploadFlag")[0].checked)
	  {
	     document.getElementById("showUpload").style.display = "block";
	  }
	  else
	  {
	     document.getElementById("showUpload").style.display = "none";
	  }
	  	  
	}
	
	function onUploadedFileName()
	{
		document.forms[0].hmode.value="GETUPLOADEDFILE"; 
		document.forms[0].target = "_blank";
		document.forms[0].submit();

    }
	
	
	
	
	function checkMandatoryDetails()
	{
		document.forms[0].strBatchNo.checked = true;
		document.forms[0].strBatchNo.disabled = true;
		document.forms[0].strBatchNo.checked = true;
		document.forms[0].strBatchNo.value = "1";
		//alert("Hello!"+document.getElementsByName("combo")[2].value);
		//var obj = document.getElementsByName("combo")[3];
		var obj = document.getElementsByName("strBrandReserveFlag")[0];
		//alert("obj.value="+obj.value);
		if(obj.value == 2 ){
			
			document.getElementById("manfMandatoryDivId").style.display = "none";	
			document.getElementById("manfNonMandatoryDivId").style.display = "block";
			
			document.getElementById("specMandatoryDivId").style.display = "none";	
			document.getElementById("specNonMandatoryDivId").style.display = "block";
			
		}else{
			
			document.getElementById("manfMandatoryDivId").style.display = "block";	
			document.getElementById("manfNonMandatoryDivId").style.display = "none";
			
			document.getElementById("specMandatoryDivId").style.display = "block";	
			document.getElementById("specNonMandatoryDivId").style.display = "none";
		
		}
		
	
	}
	
	
	function view1(id1, id2, id3) {
		document.getElementById(id1).style.display = "none";
		document.getElementById(id2).style.display = "block";
		document.getElementById(id3).style.display = "block";
	}
	function view2(id1, id2, id3) {
		document.getElementById(id1).style.display = "block";
		document.getElementById(id2).style.display = "none";
		document.getElementById(id3).style.display = "none";
	}
	function setBatchExpiry() {
		document.forms[0].strBatchNo.checked = true;
		(document.forms[0].strExpiryDate.checked) = true;
	}

	function setBatchNo() {
		if (document.forms[0].strBatchNo.checked) {
			document.forms[0].strBatchNo.value = "1";
		} else {
			document.forms[0].strBatchNo.value = "0";
		}
	}
	function setExpiryDate() {
		if (document.forms[0].strExpiryDate.checked) {
			document.forms[0].strExpiryDate.value = "1";
			document.forms[0].strManufDate.checked=true;
			setManufDate();
		} else {
			document.forms[0].strExpiryDate.value = "0";
			document.forms[0].strManufDate.checked=false;
		}
	}
	function setManufDate() {
		if(document.forms[0].strExpiryDate.checked)
			{
				document.forms[0].strManufDate.checked=true;
				document.forms[0].strManufDate.value = "1";	
			}
		
		else if (document.forms[0].strManufDate.checked) {
			document.forms[0].strManufDate.value = "1";
			
		} else {
			document.forms[0].strManufDate.value = "0";
		}
	}
	
	
	function setIsItemSachet()
	{
		
		if(document.forms[0].strSetSachetFlag.checked)
		{
			document.forms[0].strSetSachetFlag.value="1";
		}
		else
		{
			document.forms[0].strSetSachetFlag.value="0";
		}
		
	}
		
	function setIsQuantifiable()
	{
		if(document.forms[0].strIsQuantified.checked)
		{
			document.forms[0].strIsQuantified.value="1";
			
		}
		else
		{
			document.forms[0].strIsQuantified.value="0";
		}
	}

	function setIsMisc()
	{
		//alert(document.forms[0].strIsMisc.value);
		if(document.forms[0].strIsMisc.checked)
		{
			document.forms[0].strIsMisc.value="1";
			
		}
		else
		{
			document.forms[0].strIsMisc.value="0";
		}
		//alert(document.forms[0].strIsMisc.value);
	}
	
	
	
	
</script>
</head>
<body onload="checkbox(),checkMandatoryDetails();">
<html:form action="/masters/ItemMstCNT" name="itemBean"	type="mms.masters.controller.fb.ItemMstFB" >

	<center>
	<div class="errMsg" id="errMsgId"><bean:write name="itemBean"
		property="strErrMssgstring" /></div>
	<div class="warningMsg" id="warningMsgId"><bean:write
		name="itemBean" property="strWarnMssgstring" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="itemBean"
		property="strNormMssgstring" /></div>
	<tag:tab tabLabel="Item Master" selectedTab="FIRST" align="center"
		width="TABLEWIDTH" onlyTabIndexing="1">

	</tag:tab></center>
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4">Item Master&gt;&gt; Modify</td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<td width="25%" class="LABEL">Item Category</td>

			<td width="25%" class="CONTROL"><bean:write name="itemBean"
				property="strItemCatName" filter="false" /></td>
			<td width="25%" class="LABEL">Group Name</td>
			<td width="25%" class="CONTROL"><bean:write name="itemBean"
				property="strGroupName" filter="false" /></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Generic Item</td>
			<td width="25%"  class="CONTROL">
			<bean:write	name="itemBean" property="strGenericItem" filter="false" />
			</td>
			
			<td class="LABEL"   width="25%"><font color='red'>*</font>Consumable Type</td>
			<td class="CONTROL"  width="25%">
			    
			    <logic:equal value="1" property="strConsumableType" name="itemBean">
				<select name="strConsumableType" class="comboNormal" disabled>
					<option value="1" selected="selected"> Consumable</option>
					<option value="0"> Non-Consumable</option>
				</select>
				</logic:equal>
				
				<logic:equal value="0" property="strConsumableType" name="itemBean">
				<select name="strConsumableType" class="comboNormal" disabled>
					<option value="1"> Consumable</option>
					<option value="0"  selected="selected"> Non-Consumable</option>
				</select>
				</logic:equal>
			</td>
		</tr>
		
		
	</table>
	
		<table class="TABLEWIDTH" align="center" cellspacing="1px"
			cellpadding="1px">
			<tr>
	    <logic:equal value="1" name="itemBean" property="strIsItemCodeRequired">
				<td colspan="2" class="LABEL" width="25%">
				<div id='cpaCodeId'><font color="red">*</font>Item Code</div>
				</td>
				<td colspan="2" width="25%" class="CONTROL">
				<logic:equal value="0" name="itemBean" property="strPrevCPACode">
				<input type="text" name="strNewCPACode" maxlength="3" value="${itemBean.strNewCPACode}" onkeypress="return validateData(event,9);" class="txtFldNormal">
				</logic:equal>
				<logic:notEqual value="0" name="itemBean" property="strPrevCPACode">
				<bean:write	name="itemBean" property="strPrevCPACode" filter="false" />
				<input type="text" name="strNewCPACode" maxlength="3" value="${itemBean.strNewCPACode}" onkeypress="return validateData(event,9);" class="txtFldNormal">
				</logic:notEqual>
				</td>
		</logic:equal>
		<logic:equal value="0" name="itemBean" property="strIsItemCodeRequired">
		<td colspan="2" class="LABEL"  width="25%">
				<div id='cpaCodeId'>Item Code</div>
				</td>
				<td colspan="2" width="25%" class="CONTROL">
				<bean:write name="itemBean" property="strPrevCPACode" filter="false" />
					<input type="text" name="strNewCPACode" maxlength="3" value="${itemBean.strNewCPACode}" onkeypress="return validateData(event,9);" class="txtFldNormal">
				</td>
			</logic:equal>
			<td class="LABEL" width="25%" ><font color="red">*</font>Item Type</td>
			<td class="CONTROL" width="25%"><select
				name="strItemTypeId" class='comboNormal'>
				<bean:write name="itemBean" property="strItemTypeCombo"
					filter="false" />
			</select></td>
			</tr>
		</table>
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
			<tr> 
			<td class="LABEL" width="25%" ><font color="red">*</font>Item Name</td>
			<td class="CONTROL" width="25%" ><input type="text"
				name="strItemName" class='txtFldMax' 
				value="${itemBean.strItemName}" maxlength="250"
				onkeypress="return validateDataWithSpecialChars(event,18,'%:;-*,½');">
			</td>
			<td class="LABEL" width="25%" colspan="2">
			<div id="manfMandatoryDivId" style="display: block;"><font
				color="red">*</font>Manufacturer</div>
			<div id="manfNonMandatoryDivId" style="display: none;">Manufacturer</div>
			</td>
			<td class="CONTROL" width="25%" colspan="2"><select name="strManufacturerId"
				class='comboMax'>
				<bean:write name="itemBean" property="strManufacturerCombo"
					filter="false" />
			</select>
			</td>
			<td width="25%" class="LABEL"><font color="red">*</font>HSN Code</td>
			<td width="25%" class="CONTROL">
			<input type="text" value="${itemBean.strHSNCode}"	name="strHSNCode" maxlength="10" class="txtFld" style="width: 100px"	onkeypress="return validateData(event,7);" />
			</td>
		    </tr>
		</table>
		<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		
		<tr>
			<td class="LABEL" width="25%">Default Rate</td>
			<td class="CONTROL" width="25%">
			<input type="text" name="strDefaultRate" class='txtFldNormal'	value="${itemBean.strDefaultRate}" maxlength="9"	onkeypress="return validateData(event,7);"></td>
			<td class="LABEL" width="25%">Rate Unit</td>
			<td class="CONTROL" width="25%">
				<select name="strRateUnitId" class="comboNormal">
					<option value="${itemBean.strRateUnitId }">
						<bean:write name="itemBean" property="strRateUnitName"/>
					</option>
				</select>
		    <input type="hidden" name="strRateUnitId" value="${itemBean.strRateUnitId }">
		    </td>
		</tr>
		
		 </table>
		 
		 
		 <table class="TABLEWIDTH" align="center" cellspacing="1px">
			<tr>
				<td colspan="4" class="TITLE" width="25%">
					<div id="itemManagePlusId" align="left" style="display: none;">
						<img src="../../hisglobal/images/plus.gif"	onClick="view1('itemManagePlusId','itemManageMinusId','itemManageDtlId');"	style="cursor: pointer;" />
						 Item Managed By
					</div>
					<div id="itemManageMinusId" style="display: block;" align="left">
						<img src="../../hisglobal/images/minus.gif"	onClick="view2('itemManagePlusId','itemManageMinusId','itemManageDtlId');" style="cursor: pointer;" /> 
						Item Managed By
					</div>
				</td>
			</tr>
		</table>
		
		<div id="itemManageDtlId">
			<table class="TABLEWIDTH" align="center" cellspacing="1px"	cellpadding="0px">
				<tr>
					
					<td class="LABEL" colspan="1" width="15%">Serial No.</td>	
					<td class="CONTROL" colspan="" width="15%">	
					<logic:equal value="1" property="strBatchNo" name="itemBean">
					<input type="checkbox"	value="1"  name="strBatchNo" onclick="setBatchNo();" checked="checked"/>
					</logic:equal>
					
					<logic:notEqual value="1" property="strBatchNo" name="itemBean">
					<input type="checkbox"	value="0"  onclick="setBatchNo();" name="strBatchNo" />
					</logic:notEqual>
					
					</td>
					
				   <td class="LABEL" width="15%">Manuf. Date</td>
					<td class="CONTROL" width="15%">
					
					<logic:equal value="1" property="strManufDate" name="itemBean">
					<input type="checkbox"	value="1"  name="strManufDate" onclick="setManufDate();" checked="checked"/>
					</logic:equal>
					
					<logic:notEqual value="1" property="strManufDate" name="itemBean">
					<input type="checkbox"	value="0" onclick="setManufDate();" name="strManufDate"  />
					</logic:notEqual>
					</td>		
			
					<td class="LABEL" width="15%">Expiry Date</td>
					<td class="CONTROL" width="15%">
					
					<logic:equal value="1" property="strExpiryDate" name="itemBean">
					<input type="checkbox"	value="1"  name="strExpiryDate" onclick="setExpiryDate();" checked="checked"/>
					</logic:equal>
					
					<logic:notEqual value="1" property="strExpiryDate" name="itemBean">
					<input type="checkbox"	value="0" onclick="setExpiryDate();" name="strExpiryDate"  />
					</logic:notEqual>
					</td>
			
			
				</tr>
			</table>
		</div>
		
		 
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">

		<tr class="HEADER">
			<td colspan="4">Item Parameter</td>
		</tr>

		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Approved
			Type</td>
			<td class="CONTROL" width="25%">
				<select name="strApprovedType" class="comboNormal">
					<bean:write name="itemBean" property="strApprovedTypeOptions" filter="false"/>
				</select>
			</td>
			<td class="LABEL" width="25%"><font color="red">*</font>Issue
			Type</td>
			<td class="CONTROL" width="25%"><html:select property="strIssueType" styleClass="comboNormal"
				value="${itemBean.strIssueType }">
				<html:option value="1">Only to Patient</html:option>
				<html:option value="2">Only to Staff</html:option>
				<html:option value="3">Patient/Staff</html:option>
			</html:select></td>
		</tr>
		<tr>
			<td class="LABEL"><font color="red">*</font>Item Make</td>
			<td class="CONTROL"><html:select property="strItemMake" styleClass="comboNormal"
				value="${itemBean.strItemMake }">
				<html:option value="1">Indian</html:option>
				<html:option value="2">Foreign</html:option>
			</html:select></td>

			<td class="LABEL">Item is SparePart</td>
			<td class="CONTROL">
			<input name="strSparePartFlag"	type="checkbox" value="1"></td>
		</tr>
		
		
			
		<tr>
		<td class="LABEL" colspan="1" width="25%">Temp Sensitive</td>
			<td class="CONTROL" colspan="1" width="25%">
				<html:select
					property="TEMP_SENS_FLAG" name="itemBean">
					<html:option value="0">No</html:option>
					<html:option value="1">Yes</html:option>
				</html:select>
			</td>
		
		
			<td class="LABEL" width="25%" colspan="1"><b>MIN</b></td>
			<td class="CONTROL" width="25%" colspan="1">
				<input type="text"	name="MIN_VALUE" maxlength="6" value="${itemBean.MIN_VALUE}" class="txtFld" style="width: 100px" />
			</td>
			
			
		</tr>
		
		<tr>
		<td class="LABEL" width="25%" colspan="1">MAX</td>
		<td class="CONTROL" width="25%" colspan="1">   
			<input type="text"	name="MAX_VALUE" maxlength="6" value="${itemBean.MAX_VALUE}" class="txtFld" style="width: 100px" />
		</td>
		
		<td class="LABEL" colspan="1" width="25%">Whether Item is ECL Category</td>
		<td class="CONTROL" colspan="1" width="25%">

			<!-- <input type="checkbox" name="strEclCat" value="0" onClick=""> -->
			<logic:equal value="1" property="strEclCat" name="itemBean">
			    <input type="checkbox"	value="1"   onclick="" name="strEclCat" checked="checked"/>
			</logic:equal>
			
			<logic:notEqual value="1" property="strEclCat" name="itemBean">
			    <input type="checkbox"	value="0"    onclick="" name="strEclCat" />
			</logic:notEqual>

		</td>
		</tr>
		
		
		
		<tr style="display: none;">
			<td class="LABEL" colspan="1" width="25%" >Item Class</td>
			<td class="CONTROL" colspan="1" width="25%">
			
			<logic:equal value="0" property="strItemClass" name="itemBean">
			<select	name="strItemClass" class="comboNormal">
				<option value="0" selected="selected">Select Value</option>
				<option value="1">Consumables</option>
				<option value="2">Drugs</option>
				<option value="3">Misc.</option>
				<option value="4">Sutures</option>
			</select>
			</logic:equal>
			
			<logic:equal value="1" property="strItemClass" name="itemBean">
			<select	name="strItemClass" class="comboNormal">
				<option value="0">Select Value</option>
				<option value="1" selected="selected">Consumables</option>
				<option value="2">Drugs</option>
				<option value="3">Misc.</option>
				<option value="4">Sutures</option>
			</select>
			</logic:equal>
            
            <logic:equal value="2" property="strItemClass" name="itemBean">
			<select	name="strItemClass" class="comboNormal">
				<option value="0">Select Value</option>
				<option value="1">Consumables</option>
				<option value="2" selected="selected">Drugs</option>
				<option value="3">Misc.</option>
				<option value="4">Sutures</option>
			</select>
			</logic:equal>
            
            <logic:equal value="3" property="strItemClass" name="itemBean">
			<select	name="strItemClass" class="comboNormal">
				<option value="0">Select Value</option>
				<option value="1">Consumables</option>
				<option value="2">Drugs</option>
				<option value="3" selected="selected">Misc.</option>
				<option value="4">Sutures</option>
			</select>
			</logic:equal>
           
            <logic:equal value="4" property="strItemClass" name="itemBean">
			<select	name="strItemClass" class="comboNormal">
				<option value="0">Select Value</option>
				<option value="1">Consumables</option>
				<option value="2">Drugs</option>
				<option value="3">Misc.</option>
				<option value="4" selected="selected">Sutures</option>
			</select>
			</logic:equal>
            			
			
            </td>
			<td class="LABEL" colspan="1" width="25%"></td>
			<td class="CONTROL" colspan="1" width="25%" ></td>
		</tr>
		
		<tr>
			<td class="LABEL">Item is Set-Sachet</td>
			<td class="CONTROL">
			
			<logic:equal property="strSetSachetFlag" value="1" name="itemBean">
			<input type="checkbox" name="strSetSachetFlag"  value="1" onclick="setIsItemSachet();" checked="checked">
			</logic:equal>
			
			<logic:equal property="strSetSachetFlag" value="0" name="itemBean">
			<input type="checkbox" name="strSetSachetFlag"  value="0" onclick="setIsItemSachet();">
			</logic:equal>
			
			</td>

			<td class="LABEL">Whether Item is Quantified</td>
			<td class="CONTROL">
			
			<logic:equal property="strIsQuantified" value="1" name="itemBean">
			<input type="checkbox" name="strIsQuantified" value="1" onclick="setIsQuantifiable();" checked="checked">
			</logic:equal>
			
			<logic:equal property="strIsQuantified" value="0" name="itemBean">
			<input type="checkbox" name="strIsQuantified"  value="0" onclick="setIsQuantifiable();">
			</logic:equal>
			
			</td>
		</tr>
     
		</table>
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
         		<tr>
		   		<td width="25%" class="LABEL"> Whether Item req Sterilization</td>
				<td width="25%" class="CONTROL"> <input name="strSterilizationFlag" type="checkbox"	value="1" onClick="showSterilizationLife();"></td>
				<td class="LABEL" colspan="1" width="25%"  >Is Misc</td>
			<td class="CONTROL" colspan="1" width="25%"  >
			<logic:equal value="1" property="strIsMisc" name="itemBean">
			<input type="checkbox"	value="1"  name="strIsMisc"  onclick="setIsMisc();" checked="checked"/>
			</logic:equal>
			
			<logic:notEqual value="1" property="strIsMisc" name="itemBean">
			<input type="checkbox"	value="0"   onclick="setIsMisc();" name="strIsMisc" />
			</logic:notEqual></td>
				</tr>
				
				<tr id="life" style=display:none;>
				<td class="LABEL" width="25%">Sterilized Life</td>			
				<td class="CONTROL" width="25%"><input type="text" name="strSterilizationLife" class='txtFldNormal' value="${itemBean.strSterilizationLife}" maxlength="14" onkeypress="return validateData(event,7);">&nbsp;day(s)</td>
				<td class="LABEL"></td>
				<td class="CONTROL"></td>
		   		</tr>
		 </table>
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">


         <tr>
			<td width="25%" class="LABEL"><div id="specMandatoryDivId" 
				style="display: block;"><font color="red">*</font>Specification</div><div id="specNonMandatoryDivId" 
				style="display: none;">Specification</div></td>
			<td width="25%" class="CONTROL"><textarea name="strSpecification"
				rows="2" cols="16" ><bean:write
				name="itemBean" property="strSpecification" /></textarea></td>
			<!-- <td width="25%" class="LABEL">Whether Want to Upload Specification</td>
			<td width="25%" class="CONTROL"><input name="strUploadFlag" type="checkbox"	value="1" onClick="showFileUpload();"></td> -->
			
			<td width="25%" class="LABEL"></td>
			<td width="25%" class="CONTROL"></td>
		</tr>
	</table>		
	<div id="showUploadFileDtl" style="display:none">
		<%-- <table class="TABLEWIDTH" align="center" cellspacing="1px">	
			<tr>				
					<td class="LABEL" width="50%">Up-Loaded File for Item Specification</td>
					<td class="CONTROL" width="50%">
					<a style='cursor:pointer;cursor:pointer;color:blue' onClick='onUploadedFileName();'><bean:write
						name="itemBean" property="strUploadFileName" /></a>
					</td>
			</tr>
			</table> --%>
		</div>	
	
		<%-- <div id="showUpload" style="display:none">		
			<jsp:include page="uploadFile.jsp"></jsp:include>
		</div> --%>	
   
   <table class="TABLEWIDTH" align="center" cellspacing="1px">
   
     <tr>
     <td colspan="4" class="TITLE"></td>
        
     </tr>
   
   
          <tr>
            
			<td class="LABEL" colspan="2">Effective
			From</td>
			<td class="CONTROL" colspan="2"><bean:write name="itemBean" property="strEffectiveFrom" /></td>
		</tr>
   
   
		<tr>
			<td colspan="2" class="LABEL">Record Status</td>
			<td colspan="2" class="CONTROL"><html:radio name="itemBean"
				property="strIsValid" value="1">Active</html:radio> <html:radio
				name="itemBean" property="strIsValid" value="2">Inactive</html:radio></td>
		</tr>

		<tr class="FOOTER">
			<td colspan="4" width="25%"><font size="2" color="red">*</font>
			Mandatory Fields</td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellspacing="1px">

		<tr>

			<td align="center" colspan="2" width="25%">
			<!-- <img
				src="../../hisglobal/images/btn-sv.png" title="Save Record"
				onClick="return validate();" style="cursor: pointer;" /> <img
				src="../../hisglobal/images/btn-clr.png" title="Clear Content"
				onClick="document.forms[0].reset();" style="cursor: pointer;" /> <img
				src="../../hisglobal/images/btn-ccl.png" title="Cancel Process"
				onClick="cancel('LIST');" style="cursor: pointer;">-->
				
				<br>					 
				<a href="#" class="button" id="" onclick=' return validate();'><span class="save">Save</span></a>
				<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
				<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
				</td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />

	<input type="hidden" value="${itemBean.strChk}" name="strChk" />
	<input type="hidden" value="${itemBean.strItemCatName}"
		name="ItemCatName" />
	<input type="hidden" value="${itemBean.strGroupName}" name="GroupName" />

	<input type="hidden" name="comboValue"
		value="${itemBean.strComboValues}" />
	<input type="hidden" value="${itemBean.strItemCatNo}"
		name="strItemCatNo" />
	<input type="hidden" value="${itemBean.strGroupId}" name="strGroupId" />


	<input type="hidden" name="ManufacturerId"
		value="${itemBean.strManufacturerId}" />
	<input type="hidden" name="RateUnitId"
		value="${itemBean.strRateUnitId}" />
	<input type="hidden" name="strHidSparePartFlag"
		value="${itemBean.strSparePartFlag}" />
	<input type="hidden" name="strHidSetSachetFlag"
		value="${itemBean.strSetSachetFlag}" />
	<input type="hidden" name="strHidIsQuantified"
		value="${itemBean.strIsQuantified}" />
	<input type="hidden" value="${itemBean.strChk}" name="chk" />

	<input type="hidden" value="${itemBean.strIsItemCodeRequired}"
		name="strIsItemCodeRequired" />
		
		<%-- <input type="hidden" value="${itemBean.strUploadFileLocation}"
		name="strUploadFileLocation" /> --%>
		
			<input type="hidden" value="${itemBean.strUploadFileId}"
		name="strUploadFileId" />
		
		<input type="hidden" value="${itemBean.strGenericItemId}"	name="strGenericItemId" />


<input type="hidden" value="${itemBean.strUploadFileName}"
		name="strUploadFileName" />

	<input type="hidden" value="${itemBean.strPrevCPACode}"
		name="strPrevCPACode" />
	<input type="hidden" value="${itemBean.strBrandReserveFlag}"
		name="strBrandReserveFlag" />
	<input type="hidden" name="strEffectiveFrom" value="${itemBean.strEffectiveFrom}"/>
	
	
	<input type="hidden" name="TEMP_SENS_FLAG" value="${itemBean.TEMP_SENS_FLAG}"/>
	<input type="hidden" name="MIN_VALUE" value="${itemBean.MIN_VALUE}"/>
	<input type="hidden" name="MAX_VALUE" value="${itemBean.MAX_VALUE}"/>
	
	
	<cmbPers:cmbPers />

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>