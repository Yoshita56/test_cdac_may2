<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>



<html>
<head>
<meta charset=utf-8>
<title>Item Brand Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>

<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>


<script type="text/javascript">
	function view3(id1, id2, id3) {
		document.getElementById(id1).style.display = "none";
		document.getElementById(id2).style.display = "block";
		document.getElementById(id3).style.display = "block";
	}
	function view4(id1, id2, id3) {
		document.getElementById(id1).style.display = "block";
		document.getElementById(id2).style.display = "none";
		document.getElementById(id3).style.display = "none";
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
	function setSlNo() {
		if (document.forms[0].strSerialNo.checked == true
				&& document.forms[0].strConsumableType.value == '1') {
			alert("Sl. No. cannot be selected for consumable Items");
			document.forms[0].strSerialNo.checked = false;
		}

		if (document.forms[0].strSerialNo.checked) {
			document.forms[0].strSerialNo.value = "1";
		} else {
			document.forms[0].strSerialNo.value = "0";
		}

	}

	function showSterilizationLife() {
		if (document.getElementsByName("strSterilizationFlag")[0].checked) {
			document.getElementById("life").style.display = "table-row";
		} else {
			document.getElementById("life").style.display = "none";
		}

	}

	function showFileUpload() {
		if (document.getElementsByName("strUploadFlag")[0].checked) {
			document.getElementById("showUpload").style.display = "block";
		} else {
			document.getElementById("showUpload").style.display = "none";
		}

	}

	function checkMandatoryDetails(obj) {

		if (obj.value == 2) {

			document.getElementById("manfMandatoryDivId").style.display = "none";
			document.getElementById("manfNonMandatoryDivId").style.display = "block";

			document.getElementById("specMandatoryDivId").style.display = "none";
			document.getElementById("specNonMandatoryDivId").style.display = "block";

		} else {

			document.getElementById("manfMandatoryDivId").style.display = "block";
			document.getElementById("manfNonMandatoryDivId").style.display = "none";

			document.getElementById("specMandatoryDivId").style.display = "block";
			document.getElementById("specNonMandatoryDivId").style.display = "none";

		}

	}

	function validate() {
// 		document.forms[0].strBatchNo.disabled = false;
// 		document.forms[0].strBatchNo.value = "1";
		var hisValidator = new HISValidator("ItemMstForBMEDFB");
		document.getElementsByName("strConsumableType")[0].disabled = false;
		hisValidator.addValidation("strGenItemId", "dontselect=0","Please Select Generic Item ");
		hisValidator.addValidation("strItemName", "req","Item Name is a Mandatory Field");

		if (document.forms[0].strIsItemCodeRequired.value == '1') {
			hisValidator.addValidation("strNewCPACode", "req","Item Code is a Mandatory Field");
		}

		/*if (!document.forms[0].strItemType[1].checked) {

			hisValidator.addValidation("strManufacturerId", "dontselect=0",	"Please Select Manufacturer");
		}*/

		//hisValidator.addValidation("strDefaultRate", "req", "Default Rate is a Mandatory Field" );
		hisValidator.addValidation("strDefaultRate", "amount=11,2","Default Rate should be in format 0000000.00");
		//  hisValidator.addValidation("strRateUnitId", "dontselect=0","Please Select Rate Unit");
		hisValidator.addValidation("strApprovedType", "dontselect=0","Please Select ApprovedType Type");
		hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
        
	    hisValidator.addValidation("MAX_VALUE", "maxlen=6", "Maximum should have less than or equal to 6 Digit" );
	    hisValidator.addValidation("MIN_VALUE", "maxlen=6", "Minimum should have less than or equal to 6 Digit" );
		
		
		if (!document.forms[0].strItemType[1].checked) {
			hisValidator.addValidation("strSpecification", "req","Specification Field is a Mandatory Field");
		}
		hisValidator.addValidation("strSpecification", "maxlen=4000","Specifications should have less than or equal to 4000 Characters");
		var retVal = hisValidator.validate();
		hisValidator.clearAllValidations();
		if (retVal) {
// 			document.forms[0].strCPACode.value=document.getElementsByName("TEMP_SENS_FLAG").value+""+document.getElementsByName("MIN_VALUE").value+""+document.getElementsByName("MAX_VALUE").value;
			document.forms[0].MIN_VALUE = document.getElementsByName("MIN_VALUE").value;
			document.forms[0].MAX_VALUE = document.getElementsByName("MAX_VALUE").value;
			document.forms[0].TEMP_SENS_FLAG = document.getElementsByName("TEMP_SENS_FLAG").value;
			document.forms[0].hmode.value = "INSERT";
			document.forms[0].submit();
		}
	}
	
	
	function checkForPopup(parObj, these,catNo){
		
		if(document.forms[0].strCatNo.value !="0" ){
		
			if(these.checked==false && catNo=="#" && document.getElementById("itemParameterDtlDivId").innerHTML==""){
			
				if(confirm("Are You Sure to Delete Parameters Values!")){
				
					document.getElementById("modifyParamShow").style.display="none";
					document.getElementById("itemParameterDtlDivId").innerHTML="";
					
				}else{
					these.checked=true;
				}
					
					
			}else if(catNo=="#"){
				document.getElementById("modifyParamShow").style.display="block";
			} else{
				
				showPopup(parObj , '1' , document.forms[0].strCatNo.value , '');
			}
				
		}else{
			alert("Please Select Item Category Before");
			these.checked=false;
		}
		
	}

	function setMandatoryDivOnLoad() {
		document.forms[0].strBatchNo.checked = true;
		document.forms[0].strBatchNo.disabled = true;
		document.forms[0].strBatchNo.checked = true;
		document.forms[0].strBatchNo.value = "1";
		var itemTypeOption = document.forms[0].strItemType[1];
		var str = itemTypeOption.checked;

		if (str == true) {

			checkMandatoryDetails(itemTypeOption);
		}
	}

	function setCPACode(cmbObj)
	 {
		var value=document.getElementById("strGenItemId");
		for(var i=0;i<value.length;i++)
		{
			if(value[i].selected==true)
				{
				   str=value[i].value+"^"+value[i].text;
				}
		}
	
		var mode="ConsumeCombo";
		var url="ItemMstForBMEDCNT.cnt?hmode="+mode+"&value="+str;
		ajaxFunction(url,"1");
		
		if (document.forms[0].strIsItemCodeRequired.value == '0') {
			var cpaObj = document.getElementById("CPAFINALID");

			if (cmbObj.value != '0') {

				var temp = cmbObj.value.split('^')[2];

				if (temp == null || temp == "" || temp == "0") {
					cpaObj.innerHTML = "<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>"
							+ "<tr><td colspan='2' width='31%' class='LABEL'>Item Code</td>"
							+ "<td colspan='2' width='16%' class='CONTROL'><input type='text' name='strNewCPACode' maxlength='3' onkeypress='return validateData(event,9);' class='txtFldNormal'> "
							+ "</td><td></td></tr></table>";

				} else {
					cpaObj.innerHTML = "<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>"
							+ "<tr><td colspan='2' width='10%' class='LABEL'>Item Code</td>"
								+ "<td colspan='2' width='6%' class='CONTROL'>"
							+ temp
							+ "."
							+ "<input type='text' name='strNewCPACode' maxlength='3' onkeypress='return validateData(event,9);' class='txtFldNormal'> "
							+ "</td></tr></table>";

				}

				cpaObj.style.display = "block";

			} else {

				cpaObj.innerHTML = "";
				cpaObj.style.display = "none";

			}
		} else {

			var cpaObj = document.getElementById("CPAFINALID");

			if (cmbObj.value != '0') {

				var temp = cmbObj.value.split('^')[2];

				if (temp == null || temp == "" || temp == "0") {
					cpaObj.innerHTML = "<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>"
							+ "<tr><td colspan='2' width='31%' class='LABEL'><font color='red'>*</font>Item Code</td>"
							+ "<td colspan='2' width=15%' class='CONTROL'><input type='text' name='strNewCPACode' maxlength='3' onkeypress='return validateData(event,9);' class='txtFldNormal'> "
							+ "</td><td></td></tr></table>";

				} else {
					cpaObj.innerHTML = "<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>"
							+ "<tr><td colspan='2' class='LABEL'><font color='red'>*</font>Item Code</td>"
							+ "<td colspan='2' width='50%' class='CONTROL'>"
							+ temp
							+ "."
							+ "<input type='text' name='strNewCPACode' maxlength='3' onkeypress='return validateData(event,9);' class='txtFldNormal'> "
							+ "</td></tr></table>";

				}

				cpaObj.style.display = "block";

			} else {

				cpaObj.innerHTML = "";
				cpaObj.style.display = "none";

			}

		}

	}


	function getAjaxResponse(res,mode)
	{
		if(mode=="1")
		{  
		    document.getElementById("strConsumableType").value=res
			document.getElementById("strConsumableType").disabled="true"; 
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

	function setIsMisc()
	{
		if(document.forms[0].strIsMisc.checked)
		{
			document.forms[0].strIsMisc.value="1";
			
		}
		else
		{
			document.forms[0].strIsMisc.value="0";
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

	
	
</script>
</head>
<body onload="setMandatoryDivOnLoad();">
	<html:form action="/masters/ItemMstForBMEDCNT" name="ItemMstForBMEDFB"
		type="mms.masters.controller.fb.ItemMstForBMEDFB"
		>


		<center>
			<div class="errMsg" id="errMsgId">
				<bean:write name="ItemMstForBMEDFB" property="strErrMssgstring" />
			</div>
			<div class="warningMsg" id="warningMsgId">
				<bean:write name="ItemMstForBMEDFB" property="strWarnMssgstring" />
			</div>
			<div class="normalMsg" id="normalMsg">
				<bean:write name="ItemMstForBMEDFB" property="strNormMssgstring" />
			</div>
			<tag:tab tabLabel="Item Master" selectedTab="FIRST" align="center"
				width="TABLEWIDTH" onlyTabIndexing="1">

			</tag:tab>


		</center>

		<table class="TABLEWIDTH" align="center" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4">Item Master&gt;&gt; Add</td>
			</tr>
		</table>
		<table class="TABLEWIDTH" align="center" cellspacing="1px">
			<tr>
				<td colspan="2" class="LABEL"><html:radio name="ItemMstForBMEDFB"
						property="strItemType" value="1"
						onclick="checkMandatoryDetails(this);">Branded</html:radio> <html:radio
						name="ItemMstForBMEDFB" property="strItemType" value="2"
						onclick="checkMandatoryDetails(this);">Non-Branded</html:radio> <!--<html:radio name="ItemMstForBMEDFB" property="strItemType" value="3" onclick="checkMandatoryDetails(this);">Reserved</html:radio> -->
				</td>
			</tr>
	   </table>
	   <table class="TABLEWIDTH" align="center" cellspacing="1px">
			<tr>
				<td class="LABEL" width="25%">Item Category</td>
				<td class="CONTROL" width="15%"><bean:write name="ItemMstForBMEDFB"	property="strItemCatName" filter="false" /></td>
			    <td class="LABEL" width="25%">Group Name</td>
				<td class="CONTROL" width="15%">
				<bean:write name="ItemMstForBMEDFB"	property="strGroupName" filter="false" /></td>
			</tr>
			
			
			<tr>
				<td class="LABEL" width="25%"><font color="red">*</font>Generic Item</td>
				<td class="CONTROL" width="15%"><select class="comboNormal"
					name="strGenItemId" id="strGenItemId"  onchange="setCPACode(this);">
						<bean:write name="ItemMstForBMEDFB" property="strGenItemValues" 
							filter="false" />
				</select></td>
				<td class="LABEL" width="25%"><font color='red'>*</font>Consumable Type</td>
				<td class="CONTROL" width="15%">	
					<html:text name="ItemMstForBMEDFB" styleId="strConsumableType" property="strConsumableType" value="" />
				</td>						
			</tr>
		</table>
		<div id="CPAFINALID" style="display: none;"></div>
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
			<tr>
				<td class="LABEL" width="25%"><font color="red">*</font>Item Type</td>
				<td class="CONTROL" width="15%" colspan="1">
				
				<select
					name="strItemTypeId" class='comboNormal'>
						<bean:write name="ItemMstForBMEDFB" property="strItemTypeCombo"
							filter="false" />
				</select>
				
				
				
				</td>
				<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Item Name</td>
				<td class="CONTROL" width="15%"><input type="text" name="strItemName"
					maxlength="250" class="txtFldMax" style="width: 100px"
					onkeypress="return validateDataWithSpecialChars(event,18,'%.:;+-/*,½');" />
					<%--
	   		<input type="text" name="strItemName" class='txtFldMax' 
	   		value="" maxlength="250" onkeypress="return validateData(event,17);">
	   		 --%></td>
			</tr>
		</table>
		<table class="TABLEWIDTH" align="center" cellspacing="1px"
			cellpadding="1px">
			<tr>		
            <td class="LABEL" width="25%" colspan="1">Manufacturer</td>
		
				<td class="CONTROL" colspan="2" width="10%"><select
					name="strManufacturerId" class='comboMax'>
						<bean:write name="ItemMstForBMEDFB" property="strManufacturerCombo" filter="false" />
				</select>
		   </td>
		   
			<td width="25%" class="LABEL"><font color="red">*</font>HSN Code</td>
			<td width="25%" class="CONTROL">
			<input type="text"	name="strHSNCode" maxlength="10" class="txtFld" style="width: 100px"	onkeypress="return validateData(event,7);" />
			</td>
		
			</tr>
			<tr>
				<td class="LABEL" width="25%">Default Rate</td>
				<td class="CONTROL" width="15%">
				<input type="text"	name="strDefaultRate" class='txtFldNormal' value="" maxlength="14"	onkeypress="return validateData(event,7);"></td>
				<td class="LABEL" width="25%">Rate Unit</td>
				<td class="CONTROL" width="15%">
				<select name="strRateUnitId"	class="comboNormal">
						<option value="${ItemMstForBMEDFB.strRateUnitId }"><bean:write name="ItemMstForBMEDFB" property="strRateUnitName"/></option>
				</select>
					
					<!-- <bean:write name="ItemMstForBMEDFB"	property="strRateUnitName" filter="false" />-->
					  <input type="hidden" name="strRateUnitId" value="${ItemMstForBMEDFB.strRateUnitId }">
				</td>
			</tr>

		</table>


<!-- 		<table class="TABLEWIDTH" align="center" cellspacing="1px"> -->
<!-- 			<tr> -->
<!-- 				<td colspan="4" class="TITLE" width="25%"> -->
<!-- 					<div id="itemManagePlusId1" align="left" style="display: none;"> -->
<!-- 						<img src="../../hisglobal/images/plus.gif" -->
<!-- 							onClick="view3('itemManagePlusId1','itemManageMinusId1','itemManageDtlId1');" -->
<!-- 							style="cursor: pointer;" /> Item Managed By -->
<!-- 					</div> -->
<!-- 					<div id="itemManageMinusId1" style="display: block;" align="left"> -->
<!-- 						<img src="../../hisglobal/images/minus.gif" -->
<!-- 							onClick="view4('itemManagePlusId1','itemManageMinusId1','itemManageDtlId1');" -->
<!-- 							style="cursor: pointer;" /> Item Managed By -->
<!-- 					</div> -->
<!-- 				</td> -->
<!-- 			</tr> -->
<!-- 		</table> -->
		
<!-- 		<div id="itemManageDtlId1"> -->
<!-- 			<table class="TABLEWIDTH" align="center" cellspacing="1px"	cellpadding="0px"> -->
<!-- 				<tr> -->
<!-- 					<td class="LABEL" colspan="1" width="15%">Serial No.</td> -->
<%-- 					<td class="CONTROL" colspan="" width="15%"><html:checkbox --%>
<%-- 							property="strBatchNo" onclick="setBatchNo();" name="ItemMstForBMEDFB" ></html:checkbox> --%>

<!-- 					</td> -->
					
<!-- 					<td class="LABEL" width="15%">Manuf. Date</td> -->
<%-- 					<td class="CONTROL" width="15%"><html:checkbox --%>
<%-- 							property="strManufDate" onclick="setManufDate();" --%>
<%-- 							name="ItemMstForBMEDFB"></html:checkbox></td> --%>
							
<!-- 					<td class="LABEL" width="15%">Expiry Date</td> -->
<%-- 					<td class="CONTROL" width="15%"><html:checkbox --%>
<%-- 							property="strExpiryDate" onclick="setExpiryDate();" --%>
<%-- 							name="ItemMstForBMEDFB"></html:checkbox></td> --%>

<!-- 				</tr> -->
			
				
<!-- 			</table> -->

<!-- 		</div> -->



	<table class="TABLEWIDTH" align="center" cellspacing="1px">
			<tr>
				<td colspan="4" class="TITLE" width="25%">
					<div id="itemManagePlusId" align="left" style="display: none;">
						<img src="../../hisglobal/images/plus.gif"
							onClick="view1('itemManagePlusId','itemManageMinusId','itemManageDtlId');"
							style="cursor: pointer;" /> Item Warranty
					</div>
					<div id="itemManageMinusId" style="display: block;" align="left">
						<img src="../../hisglobal/images/minus.gif"
							onClick="view2('itemManagePlusId','itemManageMinusId','itemManageDtlId');"
							style="cursor: pointer;" /> Item Warranty
					</div>
				</td>
			</tr>
		</table>
		
		
		<div id="itemManageDtlId">
			<table class="TABLEWIDTH" align="center" cellspacing="1px"	cellpadding="0px">
				<tr>
					<td class="LABEL" colspan="1" width="15%">*Serial No</td>
					<td width="25%" class="CONTROL" >
						<div id="warrantyStartDateDiv">
							<input type="text" class="TEXT_FIELD_SMALL" name="strSerialNo" 
								value="" onkeypress="return validateDataWithSpecialChars(event,18,'%.:;+-/*,½');">
						</div>
					</td>
					
					<td class="LABEL" width="15%">*MAC Number</td>
					<td width="25%" class="CONTROL">
					<div id="warrantyUpToDiv">
						<input type="text" class="TEXT_FIELD_SMALL" name="MACNo" maxlength="3"
						value="" onkeypress="return validateData(event,5);">
					</div></td>
							
					<td class="LABEL" width="15%">*Location</td>
					<td width="25%" class="CONTROL">
					<div id="routineFreqUnitDiv">
					<input type="text" class="TEXT_FIELD_SMALL" name="strloc"
						value="">
					</div></td>
				</tr>

				<tr>
					<td class="LABEL" colspan="1" width="15%">Warranty Date</td>
					<td width="25%" class="CONTROL"><div id="warrantyStartDateDiv">
					<dateTag:date name="strWarrantyStartDate" value=""></dateTag:date></div></td>
					
					<td class="LABEL" width="15%">Warranty UpTo </td>
					<td width="25%" class="CONTROL">
					<div id="warrantyUpToDiv">
						<input type="text" class="TEXT_FIELD_SMALL" name="strWarrantyUpTo" maxlength="3"
						value="" onkeypress="return validateData(event,5);">
					</div></td>
							
					<td class="LABEL" width="15%">*Unit</td>
					<td width="25%" class="CONTROL"><div id="routineFreqUnitDiv">
					<select name="strUnitId" class="COMBO_NORMAL" >
<%-- 						<bean:write name="" property="" filter="false" /> --%>

						<option>1</option>
						<option>2</option>
						<option>3</option>
					</select></div></td>
				</tr>
			</table>
		</div>



		<table class="TABLEWIDTH" align="center" cellspacing="1px"
			cellpadding="1px">

			<tr class="HEADER">
				<td colspan="4">Item Parameter</td>
			</tr>

			<tr>
				<td class="LABEL" width="25%"><font color="red">*</font>Approved
					Type</td>
				<td class="CONTROL" width="25%"><select name="strApprovedType"
					class="comboNormal">
						<bean:write name="ItemMstForBMEDFB" property="strApprovedTypeOptions"
							filter="false" />
				</select></td>

				<td class="LABEL" width="25%"><font color="red">*</font>Issue
					Type</td>
				<td class="CONTROL" width="25%"><select name="strIssueType"
					class='comboNormal'>
						<option value="1">Only to Patient</option>
						<option value="2">Only to Staff</option>
						<option value="3" selected>Patient/Staff</option>
				</select></td>
			</tr>
			<tr>
				<td class="LABEL"><font color="red">*</font>Item Make</td>
				<td class="CONTROL"><select name="strItemMake"
					class='comboNormal'>
						<option value="1">Indian</option>
						<option value="2">Foreign</option>
				</select></td>

				<td class="LABEL">Whether Item is SparePart</td>
				<td class="CONTROL"><input name="strSparePartFlag"
					type="checkbox" value="1"></td>
			</tr>
			
		<tr>
		<td class="LABEL" colspan="1" width="25%">Temp Sensitive</td>
			<td class="CONTROL" colspan="1" width="25%">
				<html:select
					property="TEMP_SENS_FLAG" name="ItemMstForBMEDFB">
					<html:option value="0">No</html:option>
					<html:option value="1">Yes</html:option>
				</html:select>
			</td>
		
		
			<td class="LABEL" width="25%" colspan="1"><b>MIN</b></td>
			<td class="CONTROL" width="25%" colspan="1">
				<input type="text"	name="MIN_VALUE" maxlength="10" class="txtFld" style="width: 100px" />
			</td>
			
			
		</tr>
		<tr>
		<td class="LABEL" width="25%" colspan="1">MAX</td>
		<td class="CONTROL" width="25%" colspan="1">   
			<input type="text"	name="MAX_VALUE" maxlength="10" class="txtFld" style="width: 100px" />
		</td>
		
		<td class="LABEL" colspan="1" width="25%"></td>
		<td class="CONTROL" colspan="1" width="25%">
		
		</td>
		
		</td>
		</tr>
			<tr>
				<td class="LABEL">Whether Item is Set-Sachet</td>
				<td class="CONTROL">
				<input name="strSetSachetFlag"	type="checkbox" onclick="setIsItemSachet();">
				</td>

				<td class="LABEL">Whether Item is Non Quantifiable</td>
				<td class="CONTROL">
				<input name="strIsQuantified" type="checkbox" onclick="setIsQuantifiable();">
				</td>
			</tr>
			
			<tr style="display: none;">
			<td class="LABEL" colspan="1" width="25%" >Item Class</td>
			<td class="CONTROL" colspan="1" width="25%">
			<select	name="strItemClass" class="comboNormal">
				<option value="0">Select Value</option>
				<option value="1">Consumables</option>
				<option value="2">Drugs</option>
				<option value="3">Misc.</option>
				<option value="3">Sutures</option>
			</select>
            </td>
			<td class="LABEL" colspan="1" width="25%"></td>
			<td class="CONTROL" colspan="1" width="25%" ></td>
		</tr>
		</table>
		<table class="TABLEWIDTH" align="center" cellspacing="1px"	cellpadding="1px">
			<tr>
				<td class="LABEL" width="25%">Whether Item req Sterilization</td>
				<td class="CONTROL" width="25%">
				<input	name="strSterilizationFlag" type="checkbox" value="1"	onClick="showSterilizationLife();">
				</td>
				<td class="LABEL" colspan="1" width="25%"  >Is Misc</td>
			<td class="CONTROL" colspan="1" width="25%"  >
			<html:checkbox	property="strIsMisc" name="ItemMstForBMEDFB" onclick="setIsMisc();"></html:checkbox></td>
				
				
			</tr>
			<tr style="display: none;" id="life">
				<td class="LABEL">Sterilized Life</td>
				<td class="CONTROL">
				<input type="text"	name="strSterilizationLife" class='txtFldSmall' value="" maxlength="14" onkeypress="return validateData(event,7);">	&nbsp;day(s)</td>
				
				<td class="LABEL"></td>
				<td class="CONTROL"></td>
			</tr>
		</table>
		<table class="TABLEWIDTH" align="center" cellspacing="1px"
			cellpadding="1px">

			<tr>
				<td width="25%" class="LABEL">
					<div id="specMandatoryDivId" style="display: block;">
						<font color="red">*</font>Specification
					</div>
					<div id="specNonMandatoryDivId" style="display: none;">Specification</div>
				</td>
				<td width="25%" class="CONTROL"><textarea
						name="strSpecification" rows="2" cols="16"></textarea></td>
				<td width="25%" class="LABEL"></td>
				<td width="25%" class="CONTROL"></td>
				<!-- <td width="25%" class="LABEL">Whether Want to Upload
					Specification</td>
				<td width="25%" class="CONTROL"><input name="strUploadFlag"
					type="checkbox" value="1" onClick="showFileUpload();"></td> -->
			</tr>
		</table>
		<div id="showUpload" style="display: none;">
		
		     <%-- <jsp:include  page="uploadFile.jsp"></jsp:include> --%>
				
		</div>

<!-- 		<table class="TABLEWIDTH" align="center" cellspacing="1px"> -->

<!-- 			<tr> -->
<!-- 				<td colspan="2" class="LABEL" width="50%"><font color="red">*</font>Effective -->
<!-- 					From</td> -->
<!-- 				<td colspan="2" class="CONTROL" width="50%"> -->
<%-- 				<date:date name="strWarrantyStartDate" value="${ItemMstForBMEDFB.strCurrentDate}"></date:date></td> --%>
			
			
			
<!-- 			</tr> -->

<!-- 			<tr class="FOOTER"> -->
<!-- 				<td colspan="4"><font size="2" color="red">*</font> Mandatory -->
<!-- 					Fields</td> -->
<!-- 			</tr> -->
<!-- 		</table> -->


		<table class="TABLEWIDTH" align="center" cellspacing="1px">

			<tr>
				<td colspan="2" class="LABEL" width="50%"><font color="red">*</font>Effective
					From</td>
				<td colspan="2" class="CONTROL" width="50%"><date:date
						name="strEffectiveFrom" value="${ItemMstForBMEDFB.strCurrentDate}"></date:date></td>
			</tr>

			<tr class="FOOTER">
				<td colspan="4"><font size="2" color="red">*</font> Mandatory
					Fields</td>
			</tr>
		</table>




		<table class="TABLEWIDTH" align="center" cellspacing="1px">

			<tr>

				<td align="center" colspan="2" width="25%">
				<!-- <img
					src="../../hisglobal/images/btn-sv.png" title="Save Record"
					onClick=" return validate();" style="cursor: pointer;" /> <img
					src="../../hisglobal/images/btn-clr.png" title="Clear Content"
					onClick="document.forms[0].reset();" style="cursor: pointer;" /> <img
					src="../../hisglobal/images/btn-ccl.png" title="Cancel Process"
					onClick="cancel('LIST');" style="cursor: pointer;">
					 -->
					<br>					 
						<a href="#" class="button" id="" onclick=' return validate();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
					</td>
			</tr>
		</table>
		<input type="hidden" name="hmode" />
		<input type="hidden" value="${ItemMstForBMEDFB.strCurrentDate}"
			name="strCurrentDate" />
		<input type="hidden" value="${ItemMstForBMEDFB.strItemCatName}"
			name="strItemCatName" />
		<input type="hidden" value="${ItemMstForBMEDFB.strGroupName}"
			name="strGroupName" />
		<input type="hidden" value="${ItemMstForBMEDFB.strItemCatNo}"
			name="strItemCatNo" />
		<input type="hidden" value="${ItemMstForBMEDFB.strGroupId}" name="strGroupId" />
		<input type="hidden" value="${ItemMstForBMEDFB.strIsItemCodeRequired}"
			name="strIsItemCodeRequired" />
		<input type="hidden" name="comboValue"
			value="${ItemMstForBMEDFB.strComboValues}" />


		
		
		<cmbPers:cmbPers />
	</html:form>
	<tag:autoIndex></tag:autoIndex>
</body>
</html>