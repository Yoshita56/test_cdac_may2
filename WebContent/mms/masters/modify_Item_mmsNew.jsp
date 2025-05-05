<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=utf-8>
<title>Item Brand Master</title>

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
	
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"	type="text/css">
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
		
		var iChars = "!@#$%^&*()+=-[]\\\';,./{}|\":<>?";
		
		for (var i = 0; i < document.forms[0].strItemName.value.length; i++) {
		    if (iChars.indexOf(document.forms[0].strItemName.value.charAt(i)) != -1) {
		    alert ("Item Name has special character(s). \nThese are not allowed.\n");
		    document.forms[0].strItemName.value="";
		    return false;
		        }
		    }
		for (var i = 0; i < document.forms[0].strSpecification.value.length; i++) {
		    if (iChars.indexOf(document.forms[0].strSpecification.value.charAt(i)) != -1) {
		    alert ("Specification has special character(s). \nThese are not allowed.\n");
		    document.forms[0].strSpecification.value="";
		    return false;
		        }
		    }
		
		document.forms[0].strBatchNo.disabled = false;
		document.forms[0].strBatchNo.value = "1";
		var hisValidator = new HISValidator("itemBean");
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

		if (!document.forms[0].strItemType[1].checked) {
			hisValidator.addValidation("strSpecification", "req","Specification Field is a Mandatory Field");
		}
		hisValidator.addValidation("strSpecification", "maxlen=4000","Specifications should have less than or equal to 4000 Characters");
		var retVal = hisValidator.validate();
		hisValidator.clearAllValidations();
		if (retVal) {
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
		var url="ItemMstBSCNT.cnt?hmode="+mode+"&value="+str;
		ajaxFunction(url,"1");
		
		if (document.forms[0].strIsItemCodeRequired.value == '0') {
			var cpaObj = document.getElementById("CPAFINALID");

			if (cmbObj.value != '0') {

				var temp = cmbObj.value.split('^')[2];

				if (temp == null || temp == "" || temp == "0") {
					 cpaObj.innerHTML = "<div class='row'>"
							+ "<div class='col-sm-6'>Item Code</div>"
							+ "<div class='col-sm-6'><input type='text' name='strNewCPACode' maxlength='3' onkeypress='return validateData(event,9);' class='form-control'></div>"
							+ "</div>"; 

				} else {
					 cpaObj.innerHTML = "<div class='row'>"
							+ "<div class='col-sm-6'>Item Code</div>"
								+ ""
							+ temp
							+ "."
							+ "<div class='col-sm-5' align='right'><input type='text' name='strNewCPACode' maxlength='3' onkeypress='return validateData(event,9);' class='form-control'><div>"
							+ "</div>";
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
					cpaObj.innerHTML = "<div class='row'>"
						+ "<div class='col-sm-6'>Item Code</div>"
						+ "<div class='col-sm-6'><input type='text' name='strNewCPACode' maxlength='3' onkeypress='return validateData(event,9);' class='form-control'></div>"
						+ "</div>"; 

				} else {
					cpaObj.innerHTML =+  "<div class='row'>"
					+ "<div class='col-sm-6'><font color='black'>Item Code</font></div>"
					+ ""
							+ temp
							+ "."
							+ "<div class='col-sm-5'><input type='text' name='strNewCPACode' maxlength='3' onkeypress='return validateData(event,9);' class='form-control'><div>"
							+ "</div>";

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

<style type="text/css">
.legendvs{
    position: absolute;
    right: 100px;
    line-height: 1.2em;
    top: 0.6em;
}
 .prescriptionTile {
		margin: 20px;
		border-bottom: 1px solid #d7d7d7;
		padding-bottom: 10px;
		padding: 1% 2% 0.5% 2%;
		background-color: #fff;
		transition: 0.5s;
		box-shadow: 0.5px 0.5px 10px 2px #b0acac;
		border-radius: .35rem;
		color: #666;
		color: rgba(75, 75, 75, 0.9);
		color: rgb(21, 21, 21);
	}
	.legend2 {
	   position: absolute;
	   top: 0.5em;
	   right: 44px;
	   line-height: 1.2em;
	}
</style>
</head>

<body onload="setMandatoryDivOnLoad();">
	<html:form action="/masters/ItemMstBSCNT" name="itemBean" type="mms.masters.controller.fb.ItemMstFB" enctype="multipart/form-data" >
			<div class="errMsg" id="errMsgId">
				<bean:write name="itemBean" property="strErrMssgstring" />
			</div>
			<div class="warningMsg" id="warningMsgId">
				<bean:write name="itemBean" property="strWarnMssgstring" />
			</div>
			<div class="normalMsg" id="normalMsg">
				<bean:write name="itemBean" property="strNormMssgstring" />
			</div>
			<%-- <tag:tab tabLabel="Item Master" selectedTab="FIRST" align="center"
				width="TABLEWIDTH" onlyTabIndexing="1">

			</tag:tab> --%>
<div class="container-fluid">
	<div class="prescriptionTile">
		<div class=" rowFlex reFlex" >
			<div class="legend2">
				<button type="button" class="float-right btn btn-danger cancelbtn my-1" style="border-radius:50%; padding:10px 12px;" onclick="cancel('LIST');">
					<i class="fas fa-times" title="Cancel"></i>
				</button>
				<button type="button" class="float-right btn btn-secondary my-1" onclick="document.forms[0].reset();" style="border-radius:50%; background: royalblue;padding:10px 9px;">
					<i class="fas fa-broom" title="Clear"></i>
				</button>
				<button type="button" id="submitId" class="float-right btn btn-success my-1" tabindex="2" onclick="return validate();" style="border-radius:50%; padding:10px 12px; background-color: #5cb85c;">
					<i class="fas fa-download iround" title="save"></i>
				</button> 
			</div> 
		</div>   

		<div class="row" align="left">
			<p class="subHeaders" style="margin-bottom: 0;">
				<i class="fas fa-university" style="font-size: 26px;">&nbsp;</i>
				Item Master
				<i class="fas fa-angle-double-right"></i>
				<label>Add</label>
			</p>
		</div>
		
		<div class="row" style="margin-bottom: 0! important; font-weight:600">
			<div class="col-sm-2">
			<label>Item Category:</label>
			</div>
			<div class="col-sm-2" align="left">
			 <bean:write name="itemBean"	property="strItemCatName" filter="false" />
			</div>
			
			<div class="col-sm-2">
			<label>Item Category:</label>
			</div>
			<div class="col-sm-2" align="left">
			<bean:write name="itemBean"	property="strGroupName" filter="false" />
			</div>
			<div class="col-sm-4"></div>
		</div>
		<hr>
		<div class="row">
			<div class="col" align="right">
				<html:radio name="itemBean"	property="strItemType" value="1" onclick="checkMandatoryDetails(this);">&nbsp;Branded</html:radio>&nbsp;
				<html:radio name="itemBean" property="strItemType" value="2" onclick="checkMandatoryDetails(this);">&nbsp;Non-Branded</html:radio>
			</div>
		</div>
		
	<div class="container">
		<div class="row my-1">
			<div class="col-sm-2">
				<font color="red">*</font><label>Generic Item</label>
			</div>
			<div class="col-sm-2">
				<select class="form-control" name="strGenItemId" id="strGenItemId"  onchange="setCPACode(this);">
				<bean:write name="itemBean" property="strGenItemValues" filter="false" />
				</select>
			</div>
			<div class="col-sm-2">
			<label><font color="red">*</font>Consumable Type</label>
			</div>
			<div class="col-sm-2">
			<html:text style="width: 100%; padding: 0.375rem 0.75rem;border: 1px solid #ced4da;border-radius: 0.25rem;" name="itemBean" 
			        styleId="strConsumableType" property="strConsumableType" value="" />
			</div>
			<div class="col-sm-4" id="CPAFINALID" style="display: none;"></div>
		</div>

		<div class="row my-1">
			<div class="col-sm-2">
			<font color="red">*</font><label>Item Type</label>
			</div>
			<div class="col-sm-2">
			<select	name="strItemTypeId" class='form-control'>
			<bean:write name="itemBean" property="strItemTypeCombo"	filter="false" />
			</select>
			</div>
			<div class="col-sm-2">
			<label><font color="red">*</font>Item Name</label>
			</div>
			<div class="col-sm-2">
			<input type="text" name="strItemName" maxlength="250" class="form-control"
			onkeypress="return validateDataWithSpecialChars(event,18,'%.:;+-/*,½');" />
			</div>
			<div class="col-sm-2">
			
			<label><font color="red">*</font>Manufacturer</label>
			</div>
			<div class="col-sm-2">
			<select	name="strManufacturerId" class='form-control'>
			<bean:write name="itemBean" property="strManufacturerCombo" filter="false" />
			</select>
			</div>
		</div>

		<div class="row my-1">
			<div class="col-sm-2">
			<font color="red">*</font><label>HSN Code</label>
			</div>
			
			<div class="col-sm-2">
			<input type="text"	name="strHSNCode" maxlength="10" class="form-control"
			onkeypress="return validateData(event,7);" />
			</div>
			
			<div class="col-sm-2">
			<label>Default Rate</label>
			</div>
			
			<div class="col-sm-2">
			<input type="text"	name="strDefaultRate" class='form-control'
			value="" maxlength="14"	onkeypress="return validateData(event,7);">
			</div>
			
			<div class="col-sm-2">
			<label>Rate Unit</label>
			</div>
			
			<div class="col-sm-2">
				<select name="strRateUnitId" class="form-control">
					<option value="${itemBean.strRateUnitId }"><bean:write name="itemBean" property="strRateUnitName"/></option>
				</select>
		<!-- <bean:write name="itemBean"	property="strRateUnitName" filter="false" />-->
		  		<input type="hidden" name="strRateUnitId" value="${itemBean.strRateUnitId }">
			</div>
		</div>
	</div>
	
 <!-- <div id="itemManagePlusId" align="left" style="display: none;">
 <p class="subHeaders" style="margin-bottom: 0;">
<img src="../../hisglobal/images/plus.gif"	onClick="view1('itemManagePlusId','itemManageMinusId','itemManageDtlId');"
							style="cursor: pointer;" />
<button type="button" class="btn btn-info" onClick="view1('itemManagePlusId','itemManageMinusId','itemManageDtlId');" style="cursor: pointer;">
<i class="fas fa-plus iround"></i>&nbsp;Item Managed By
</button>
</p>
</div>
<div id="itemManageMinusId" style="display: block;" align="left">
<p class="subHeaders" style="margin-bottom: 0;">
<img src="../../hisglobal/images/minus.gif" onClick="view2('itemManagePlusId','itemManageMinusId','itemManageDtlId');"
style="cursor: pointer;" />

<button type="button" class="btn btn-info" onClick="view2('itemManagePlusId','itemManageMinusId','itemManageDtlId');" style="cursor: pointer;">
<i class="fas fa-minus iround"></i>&nbsp;Item Managed By
</button>
</p>
</div> -->
<!-- <div id="itemManageDtlId"> -->
	<div class="row"  align="left" style="margin-bottom: 0! important; font-weight:600" >
		<p class="subHeaders mx-3">
		Item Managed By
		</p>
	</div>
	<hr>
<div class="container">
	<div class="row my-1">
		<div class="col-sm-2">
		<label>Serial No.</label>
		</div>
		<div class="col-sm-2 p-2" align="left">
			<html:checkbox property="strBatchNo" onclick="setBatchNo();" name="itemBean" ></html:checkbox>
		</div>
		<div class="col-sm-2">
			<label>Manuf. Date</label>
		</div>
		<div class="col-sm-2 p-2" align="left">
			<html:checkbox property="strManufDate" onclick="setManufDate();" name="itemBean"></html:checkbox>
		</div>
		<div class="col-sm-2">
			<label>Expiry Date</label>
		</div>
		<div class="col-sm-2 p-2" align="left">
			<html:checkbox property="strExpiryDate" onclick="setExpiryDate();" name="itemBean"></html:checkbox>
		</div>
	</div>
</div>

	
	<div class="row" align="left" style="margin-bottom: 0! important; font-weight:600">
		<p class="subHeaders mx-3">
		Item Parameter
		</p>
	</div>
	<hr>
<div class="container">
	<div class="row my-1">
		<div class="col-sm-2">
		<label><font color="red">*</font>Approved Type</label>
		</div>
		<div class="col-sm-2">
			<select name="strApprovedType" class="form-control">
			<bean:write name="itemBean" property="strApprovedTypeOptions" filter="false" />
			</select>
		</div>
		<div class="col-sm-2">
		<label><font color="red">*</font>Issue Type</label>			
		</div>
		<div class="col-sm-2">
			<select name="strIssueType" class='form-control'>
			<option value="1">Only to Patient</option>
			<option value="2">Only to Staff</option>
			<option value="3" selected>Patient/Staff</option>
			</select>
		</div>
		<div class="col-sm-2">
		
		<label><font color="red">*</font>Item Make</label>			
		</div>
		<div class="col-sm-2">
		<select name="strItemMake" class='form-control'>
		<option value="1">Indian</option>
		<option value="2">Foreign</option>
		</select>
		</div>
	</div>
	<div class="row my-1">
		<div class="col-sm-3">
		
		<label>Is Misc</label>
		</div>
		<div class="col-sm-1 p-2" align="left">
			<html:checkbox	property="strIsMisc" name="itemBean" onclick="setIsMisc();"></html:checkbox>
		</div>	
		<div class="col-sm-3">
		<label>Whether Item req Sterilization</label>
		</div>
		<div class="col-sm-1 p-2" align="left">
			<input	name="strSterilizationFlag" type="checkbox" value="1"	onClick="showSterilizationLife();">
		</div>
		<div class="col-sm-4" id="life" style="display: none;" >
			<div class="row">
			<div class="col-sm-6">
				<label>Sterilized Life</label>
			</div>
			<div class="col-sm-6">
				<input type="text"	name="strSterilizationLife" class='form-control' value="" maxlength="14" 
				onkeypress="return validateData(event,7);" placeholder="Day/s">	
			</div>
			</div>
		</div>		
	</div>

<!-- <div class="row" >
<div class="col-sm-3">

<label>Whether Item is SparePart</label>
</font>
</div>
<div class="col-sm-1">
<input name="strSparePartFlag" type="checkbox" value="1">
</div>
<div class="col-sm-3">

<label>Whether Item is Set-Sachet</label>
</font>
</div>
<div class="col-sm-1">
<input name="strSetSachetFlag"	type="checkbox" onclick="setIsItemSachet();">
</div>
<div class="col-sm-3">

<label>Whether Item is Non Quantifiable</label>
</font>
</div>
<div class="col-sm-1">
<input name="strIsQuantified" type="checkbox" onclick="setIsQuantifiable();">
</div>			
</div> -->

	<div class="row my-1" >
		<div class="col-sm-2">
		<div id="specMandatoryDivId" style="display: block;">
			<label><font color="red">*</font>Specification</label>
		</div>
		<div id="specNonMandatoryDivId" style="display: none;">
			<label><font color="red">*</font>Specification</label>
		</div>
		</div>
		
		<div class="col-sm-2">
			<textarea class="form-control" name="strSpecification" rows="1" cols="16" style="height:38px;"></textarea>
		</div>
		
		<div class="col-sm-3">
			<label>Whether Want to Upload Specification</label>
		</div>
		
		<div class="col-sm-1 p-2" align="left">
			<input name="strUploadFlag" type="checkbox" value="1" onClick="showFileUpload();">
		</div>
		<div class="col-sm-4" id="showUpload" style="display: none;">
		<jsp:include page="uploadFileNew.jsp"></jsp:include>
		</div>			
	</div>
	<div class="row">
		<div class="col-sm-2">
		<label>Effective From</label>
		</div>
		<div class="col-sm-2">
			<input class='form-control datepicker' name="strEffectiveFrom" value="${itemBean.strCurrentDate}">
		</div>
	</div>
</div>
	<hr>
	
	<div class="row">
	<div class='col-sm-9'>
	</div>
	<div class='col-sm-3' align="right">
	<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>
	<label>&nbsp;Mandatory Fields</label>
	</div>
	</div>


		<!-- <table class="TABLEWIDTH" align="center" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4">Item Master&gt;&gt; Add</td>
			</tr>
		</table> -->
		<%-- <table class="TABLEWIDTH" align="center" cellspacing="1px">
			<tr>
				<td colspan="2" class="LABEL"><html:radio name="itemBean"
						property="strItemType" value="1"
						onclick="checkMandatoryDetails(this);">Branded</html:radio> <html:radio
						name="itemBean" property="strItemType" value="2"
						onclick="checkMandatoryDetails(this);">Non-Branded</html:radio> <!--<html:radio name="itemBean" property="strItemType" value="3" onclick="checkMandatoryDetails(this);">Reserved</html:radio> -->
				</td>
			</tr>
	   </table> --%>
	  <%--  <table class="TABLEWIDTH" align="center" cellspacing="1px">
			<tr>
				<td class="LABEL" width="25%">Item Category</td>
				<td class="CONTROL" width="15%"><bean:write name="itemBean"	property="strItemCatName" filter="false" /></td>
			    <td class="LABEL" width="25%">Group Name</td>
				<td class="CONTROL" width="15%">
				<bean:write name="itemBean"	property="strGroupName" filter="false" /></td>
			</tr>
			
			
			<tr>
				<td class="LABEL" width="25%"><font color="red">*</font>Generic Item</td>
				<td class="CONTROL" width="15%"><select class="comboNormal"
					name="strGenItemId" id="strGenItemId"  onchange="setCPACode(this);">
						<bean:write name="itemBean" property="strGenItemValues" 
							filter="false" />
				</select></td>
				<td class="LABEL" width="25%"><font color='red'>*</font>Consumable Type</td>
				<td class="CONTROL" width="15%">	
					<html:text name="itemBean" styleId="strConsumableType" property="strConsumableType" value="" />
				</td>						
			</tr>
		</table> --%>
		<%-- <table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
			<tr>
				<td class="LABEL" width="25%"><font color="red">*</font>Item Type</td>
				<td class="CONTROL" width="15%" colspan="1">
				<select
					name="strItemTypeId" class='comboNormal'>
						<bean:write name="itemBean" property="strItemTypeCombo"
							filter="false" />
				</select>
				</td>
				<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Item Name</td>
				<td class="CONTROL" width="15%">
				<input type="text" name="strItemName"
					maxlength="250" class="txtFldMax" style="width: 100px"
					onkeypress="return validateDataWithSpecialChars(event,18,'%.:;+-/*,½');" />
					
	   		<input type="text" name="strItemName" class='txtFldMax' 
	   		value="" maxlength="250" onkeypress="return validateData(event,17);">
	   		</td>
			</tr>
		</table> --%>
		<%-- <table class="TABLEWIDTH" align="center" cellspacing="1px"
			cellpadding="1px">
			<tr>		
            <td class="LABEL" width="25%" colspan="1">Manufacturer</td>
		
				<td class="CONTROL" colspan="2" width="10%">
				<select
					name="strManufacturerId" class='comboMax'>
						<bean:write name="itemBean" property="strManufacturerCombo" filter="false" />
				</select>
		   </td>
		   
			<!-- <td width="25%" class="LABEL"><font color="red">*</font>HSN Code</td>
			<td width="25%" class="CONTROL">
			<input type="text"	name="strHSNCode" maxlength="10" class="txtFld" style="width: 100px"	onkeypress="return validateData(event,7);" />
			</td> -->
		
			</tr>
			<tr>
				<td class="LABEL" width="25%">Default Rate</td>
				<td class="CONTROL" width="15%">
				<input type="text"	name="strDefaultRate" class='txtFldNormal' value="" maxlength="14"	onkeypress="return validateData(event,7);"></td>
				<td class="LABEL" width="25%">Rate Unit</td>
				<td class="CONTROL" width="15%">
				<select name="strRateUnitId"	class="comboNormal">
						<option value="${itemBean.strRateUnitId }"><bean:write name="itemBean" property="strRateUnitName"/></option>
				</select>
					
					<!-- <bean:write name="itemBean"	property="strRateUnitName" filter="false" />-->
					  <input type="hidden" name="strRateUnitId" value="${itemBean.strRateUnitId }">
				</td>
			</tr>

		</table>
 --%>

		<!-- <table class="TABLEWIDTH" align="center" cellspacing="1px">
			<tr>
				<td colspan="4" class="TITLE" width="25%">
					<div id="itemManagePlusId" align="left" style="display: none;">
						<img src="../../hisglobal/images/plus.gif"
							onClick="view1('itemManagePlusId','itemManageMinusId','itemManageDtlId');"
							style="cursor: pointer;" /> Item Managed By
					</div>
					<div id="itemManageMinusId" style="display: block;" align="left">
						<img src="../../hisglobal/images/minus.gif"
							onClick="view2('itemManagePlusId','itemManageMinusId','itemManageDtlId');"
							style="cursor: pointer;" /> Item Managed By
					</div>
				</td>
			</tr>
		</table> -->
		<%-- <div id="itemManageDtlId">
		<div  class="row">
			<div class="col-sm-2">Serial No.</div>
				<div class="col-sm-2">	
					<html:checkbox property="strBatchNo" onclick="setBatchNo();" name="itemBean" ></html:checkbox>
					</div>
					
					<div class="col-sm-2">Manuf. Date</div>
					<div class="col-sm-2">
					<html:checkbox
							property="strManufDate" onclick="setManufDate();"
							name="itemBean"></html:checkbox></div>
							
						<div class="col-sm-2">	
					Expiry Date
					</div>
					<div class="col-sm-2">
					<html:checkbox
							property="strExpiryDate" onclick="setExpiryDate();"
							name="itemBean"></html:checkbox>
							</div>
		</div></div>
 --%>


		<table class="TABLEWIDTH" align="center" cellspacing="1px"
			cellpadding="1px">

			<!-- <tr class="HEADER">
				<td colspan="4">Item Parameter</td>
			</tr>
 -->
			<%-- <tr>
				<td class="LABEL" width="25%"><font color="red">*</font>Approved
					Type</td>
				<td class="CONTROL" width="25%"> <select name="strApprovedType"
					class="comboNormal">
						<bean:write name="itemBean" property="strApprovedTypeOptions"
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
			</tr> --%>
			<!-- <tr>
				<td class="LABEL"><font color="red">*</font>Item Make</td>
				<td class="CONTROL"><select name="strItemMake"
					class='comboNormal'>
						<option value="1">Indian</option>
						<option value="2">Foreign</option>
				</select></td>

				<td class="LABEL">Whether Item is SparePart</td>
				<td class="CONTROL"><input name="strSparePartFlag"
					type="checkbox" value="1"></td>
			</tr> -->
			<!-- <tr>
				<td class="LABEL">Whether Item is Set-Sachet</td>
				<td class="CONTROL">
				<input name="strSetSachetFlag"	type="checkbox" onclick="setIsItemSachet();">
				</td>

				<td class="LABEL">Whether Item is Non Quantifiable</td>
				<td class="CONTROL">
				<input name="strIsQuantified" type="checkbox" onclick="setIsQuantifiable();">
				</td>
			</tr> -->
			
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
		<%-- <table class="TABLEWIDTH" align="center" cellspacing="1px"	cellpadding="1px">
			<tr>
				<td class="LABEL" width="25%">Whether Item req Sterilization</td>
				<td class="CONTROL" width="25%">
				<input	name="strSterilizationFlag" type="checkbox" value="1"	onClick="showSterilizationLife();">
				</td>
				<td class="LABEL" colspan="1" width="25%"  >Is Misc</td>
			<td class="CONTROL" colspan="1" width="25%"  >
			<html:checkbox	property="strIsMisc" name="itemBean" onclick="setIsMisc();"></html:checkbox></td>
				
				
			</tr>
			<!-- <tr style="display: none;" id="life">
				<td class="LABEL">Sterilized Life</td>
				<td class="CONTROL">
				<input type="text"	name="strSterilizationLife" class='txtFldSmall' value="" maxlength="14" onkeypress="return validateData(event,7);">	&nbsp;day(s)</td>
				
				<td class="LABEL"></td>
				<td class="CONTROL"></td>
			</tr> -->
		</table> --%>
		<!-- <table class="TABLEWIDTH" align="center" cellspacing="1px"
			cellpadding="1px">

			<tr>
				<td width="25%" class="LABEL">
					<div id="specMandatoryDivId" style="display: block;">
						<font color="red">*</font>Specification
					</div>
					<div id="specNonMandatoryDivId" style="display: none;">Specification</div>
				</td>
				<td width="25%" class="CONTROL"> <textarea
						name="strSpecification" rows="2" cols="16"></textarea></td>
				<td width="25%" class="LABEL">Whether Want to Upload
					Specification</td>
				<td width="25%" class="CONTROL"> <input name="strUploadFlag"
					type="checkbox" value="1" onClick="showFileUpload();"> </td>
			</tr>
		</table> -->
		<%-- <div id="showUpload" style="display: none;"><jsp:include
				page="uploadFile.jsp"></jsp:include></div> --%>

		<%-- <table class="TABLEWIDTH" align="center" cellspacing="1px">

			<tr>
				<td colspan="2" class="LABEL" width="50%"><font color="red">*</font>Effective
					From</td>
				<td colspan="2" class="CONTROL" width="50%"><date:date
						name="strEffectiveFrom" value="${itemBean.strCurrentDate}"></date:date></td>
			</tr>

			<!-- <tr class="FOOTER">
				<td colspan="4"><font size="2" color="red">*</font> Mandatory
					Fields</td>
			</tr> -->
		</table>
 --%>



	<!-- 	<table class="TABLEWIDTH" align="center" cellspacing="1px">

			<tr>

				<td align="center" colspan="2" width="25%">
				<img
					src="../../hisglobal/images/btn-sv.png" title="Save Record"
					onClick=" return validate();" style="cursor: pointer;" /> <img
					src="../../hisglobal/images/btn-clr.png" title="Clear Content"
					onClick="document.forms[0].reset();" style="cursor: pointer;" /> <img
					src="../../hisglobal/images/btn-ccl.png" title="Cancel Process"
					onClick="cancel('LIST');" style="cursor: pointer;">
					
					<br>					 
						<a href="#" class="button" id="" onclick=' return validate();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
					</td>
			</tr>
		</table> -->
		<input type="hidden" name="hmode" />
		<input type="hidden" value="${itemBean.strCurrentDate}"
			name="strCurrentDate" />
		<input type="hidden" value="${itemBean.strItemCatName}"
			name="strItemCatName" />
		<input type="hidden" value="${itemBean.strGroupName}"
			name="strGroupName" />
		<input type="hidden" value="${itemBean.strItemCatNo}"
			name="strItemCatNo" />
		<input type="hidden" value="${itemBean.strGroupId}" name="strGroupId" />
		
		<input type="hidden" value="${itemBean.strIsItemCodeRequired}" name="strIsItemCodeRequired" />
		<input type="hidden" name="comboValue"
value="${itemBean.strComboValues}" />
			
		

		<cmbPers:cmbPers />
		</div>
		</div>
	</html:form>
	
	<script>
$('.datepicker').each(function(){
    $(this).datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
});
var today=new Date();
var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
var mmm=arr[today.getMonth()];
var hrs=today.getHours();
var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
$('.datepicker').val(dd);

</script>
</body>
</html>