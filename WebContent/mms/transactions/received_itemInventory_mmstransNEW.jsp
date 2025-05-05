<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>



<html>
<head>
<meta charset=UTF-8">
<title>Item Inventory</title>

<!-- added 20 April 2020 -->
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css"
	rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css"
	rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css"
	rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet"
	type="text/css">
<link
	href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css"
	rel="stylesheet" type="text/css">

<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/receivedItemDetailsNEW.js"></script>
<script language="JavaScript" src="../js/item_OtherDtls_util.js"></script>
<script language="Javascript" src="../js/itemparameterdetails_util.js"></script>

<style type="text/css">
.col-sm-1half, .col-sm-8half, .col-sm-half {
	position: relative;
	min-height: 1px;
	padding-right: 15px;
	padding-left: 15px;
}

.custom-radio .custom-control-label::before {
	background-color: white; /* orange */
}

.col-md-1half, .col-md-8half, .col-md-half {
	position: relative;
	min-height: 1px;
	padding-right: 15px;
	padding-left: 15px;
}

@media ( min-width : 768px) {
	.col-sm-1half, .col-md-1half, .col-sm-8half {
		float: left;
	}
	.col-sm-1half, .col-md-1half {
		width: 12.495%;
	}
	.col-sm-half, .col-md-half {
		width: 4.165%;
	}
	.col-sm-2half, .col-sm-2half {
		width: 20.495%;
	}
}

.table {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-weight: 400;
	color: #212529;
}

textarea {
	width: 100%;
}

.table .thead-dark {
	color: #000 !important;
	border: none !important;
	background: linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156))
		!important;
}

.thead-dark th {
	background: none !important;
	border: none !important;
}

.panel-group .panel {
	border-radius: 0;
	box-shadow: none;
	border-color: #EEEEEE;
}

.panel-default>.panel-heading {
	padding: 0;
	border-radius: 0;
	color: #212121;
	background-color: #FAFAFA;
	border-color: #EEEEEE;
}

.panel-title {
	font-size: 14px;
}

.panel-title>a {
	display: block;
	padding: 15px;
	text-decoration: none;
}

.more-less {
	float: right;
	color: #212121;
}

.panel-default>.panel-heading+.panel-collapse>.panel-body {
	border-top-color: #EEEEEE;
}

body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 14px;
	line-height: 1.42857143;
	color: rgba(0, 0, 0, 1);
	font-weight: 501;
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
	top: -2.1em;
	right: 44px;
	line-height: 1.2em;
}

.subHeaders {
	font-weight: 500 !important;
	font-family: "Helvetica Neue", "Helvetica";
	font-size: 19px !important;
	padding-bottom: 0px !important;
	color: rgba(0, 0, 0, 1);
}

.btn-circle {
	width: 37px;
	height: 34px;
	text-align: center;
	padding: 6px 0;
	font-size: 12px;
	line-height: 1.428571429;
	border-radius: 17px;
	color: white;
	float: right;
}

.iround {
	color: white;
	font-size: 16px;
}
</style>

<script>
	function toggleIcon(e) {
		$(e.target).prev('.panel-heading').find(".more-less").toggleClass(
				'glyphicon-plus glyphicon-minus');
	}
	$('.panel-group').on('hidden.bs.collapse', toggleIcon);
	$('.panel-group').on('shown.bs.collapse', toggleIcon);
</script>

<script>
	function controlToMainPage() {
		document.forms[0].hmode.value = "unspecified";
		document.forms[0].submit();
	}
/*
	function calculateRateWithGst() {
	    var rate = parseFloat(document.getElementById("strRate").value);
	    var gstTax = parseFloat(document.getElementById("strGstTax").value);
	    var adminTax = parseFloat(document.getElementById("strAdminTax").value);

	    // Check if rate is NaN
	    if (isNaN(rate) || rate === 0) {
	        // If rate is NaN, reset the values of strRatewithGst and strSalePrice
	        document.getElementById("strRatewithGst").value = "";
	        document.getElementById("strSalePrice").value = "";
	        return; // Exit the function
	    }

	    // Check if gstTax and adminTax are 0 or not entered by the user
	    if ((isNaN(gstTax) || gstTax === 0) && (isNaN(adminTax) || adminTax === 0)) {
	        // Update strRatewithGst with the value from strRate
	        document.getElementById("strRatewithGst").value = rate;

	        // Update strSalePrice with the value from strRate
	        document.getElementById("strSalePrice").value = rate;
	    } else if ((isNaN(gstTax) || gstTax === 0) && (adminTax !== 0 || adminTax !== null)) {
	        // Update strRatewithGst with the value from strRate
	        document.getElementById("strRatewithGst").value = rate;

	        var rateWithGst = parseFloat(document.getElementById("strRatewithGst").value);
	        var adminTax = parseFloat(document.getElementById("strAdminTax").value);
	        var salePrice = rateWithGst + (rateWithGst * adminTax / 100);

	        // Set the value of strSalePrice field
	        document.getElementById("strSalePrice").value = salePrice.toFixed(2);
	    } else if ((isNaN(adminTax) || adminTax === 0) && (gstTax !== 0 || gstTax !== null)) {
	        // Calculate rate with gst tax
	        var rateWithGst = rate + (rate * gstTax / 100);

	        // Update strRatewithGst with the calculated value
	        document.getElementById("strRatewithGst").value = rateWithGst.toFixed(2);

	        // Set the value of strSalePrice field
	        document.getElementById("strSalePrice").value = rateWithGst.toFixed(2);
	    } else {
	        // Calculate rate with gst and admin tax
	        var rateWithGst = rate * (1 + gstTax / 100);

	        // Update strRatewithGst with the calculated value
	        document.getElementById("strRatewithGst").value = rateWithGst.toFixed(2);

	        var salePrice = rateWithGst + (rateWithGst * adminTax / 100);

	        // Set the value of strSalePrice field
	        document.getElementById("strSalePrice").value = salePrice.toFixed(2);
	    }
	}
*/
function calculateRateWithGst() {
    var rate = parseFloat(document.getElementById("strRate").value);
    var gstTax = parseFloat(document.getElementById("strGstTax").value);
    var adminTax = parseFloat(document.getElementById("strAdminTax").value);

    // Check if rate is NaN or empty
    if (isNaN(rate) || rate === 0 || rate.toString().trim() === "") {
        // If rate is NaN or empty, reset the values of strRatewithGst and strSalePrice
        document.getElementById("strRatewithGst").value = "";
        document.getElementById("strSalePrice").value = "";
        return; // Exit the function
    }

    // Check if gstTax and adminTax are not entered by the user
    if ((isNaN(gstTax) || gstTax === 0 || gstTax.toString().trim() === "") && 
        (isNaN(adminTax) || adminTax === 0 || adminTax.toString().trim() === "")) {
        // Update strRatewithGst & strSalePrice with the value from strRate
        document.getElementById("strRatewithGst").value = rate;
        document.getElementById("strSalePrice").value = rate;
    } else if ((isNaN(gstTax) || gstTax === 0 || gstTax.toString().trim() === "") && 
               (!isNaN(adminTax) && adminTax !== 0 && adminTax.toString().trim() !== "")) {
        // Update strRatewithGst with the value from strRate
        document.getElementById("strRatewithGst").value = rate;

        var rateWithGst = parseFloat(document.getElementById("strRatewithGst").value);
        var salePrice = rateWithGst + (rateWithGst * adminTax / 100);

        // Set the value of strSalePrice field
        document.getElementById("strSalePrice").value = salePrice.toFixed(2);
    } else if ((isNaN(adminTax) || adminTax === 0 || adminTax.toString().trim() === "") && 
               (!isNaN(gstTax) && gstTax !== 0 && gstTax.toString().trim() !== "")) {
        // Calculate rate with gst tax
        var rateWithGst = rate + (rate * gstTax / 100);

        // Update strRatewithGst with the calculated value
        document.getElementById("strRatewithGst").value = rateWithGst.toFixed(2);

        // Set the value of strSalePrice field
        document.getElementById("strSalePrice").value = rateWithGst.toFixed(2);
    } else {
        // Calculate rate with gst and admin tax
        var rateWithGst = rate * (1 + gstTax / 100);

        // Update strRatewithGst with the calculated value
        document.getElementById("strRatewithGst").value = rateWithGst.toFixed(2);

        var salePrice = rateWithGst + (rateWithGst * adminTax / 100);

        // Set the value of strSalePrice field
        document.getElementById("strSalePrice").value = salePrice.toFixed(2);
    }
}
</script>
</head>

<body onload="InitialProcess();">
	<html:form name="receiveFromThirdPartyTransBean"
		action="/transactions/ReceiveFromThirdPartyTransCNTNEW"
		type="mms.transactions.controller.fb.ReceiveFromThirdPartyTransFB">

		<div class="errMsg" id="errMsg" style="font-size: 16px;">
			<bean:write name="receiveFromThirdPartyTransBean"
				property="strErrMsg" />
		</div>
		<div class="warningMsg" id="warningMsg" style="font-size: 16px;">
			<bean:write name="receiveFromThirdPartyTransBean"
				property="strWarningMsg" />
		</div>
		<div class="normalMsg" id="normalMsg" style="font-size: 16px;">
			<bean:write name="receiveFromThirdPartyTransBean"
				property="strNormalMsg" filter="false" />
		</div>

		<div class="container-fluid">
			<div class="prescriptionTile">

				<div class="row ">
					<div class="col-sm-6" style="text-align: initial;">
						<p class="subHeaders">
							<i class="fas fa-file-alt iround"
								style="font-size: 20px; color: #28a745" title=""></i>
							&nbsp;Received From Third Party Details
						</p>
					</div>

					<div class="col-sm-6" id="">
						<div class="legend2" id='nonPrintableLegend2'>
							<button type="button"
								class="float-right btn btn-danger mt-1 btn-circle cancelbtn"
								onclick="cancelFunc();">
								<i class="fas fa-times  iround" title="Cancel"></i>
							</button>

							<button type="button"
								class="float-right btn btn-secondary  mt-1 btn-circle"
								onclick="document.forms[0].reset();"
								style="background-color: royalblue;">
								<i class="fas fa-broom  iround" title="Clear"></i>
							</button>

							<button type="button" id="submitId"
								class="float-right btn btn-success mt-1 btn-circle savebtn"
								name="patientAdmissionModiTransBean" tabindex='2'
								onclick='return validate1();'>
								<i class="fa fa-download fa-beat  iround" title="Save"></i>
							</button>
						</div>
					</div>
				</div>


				<!-- 		<div class="row ">
				<div class="legend2" id='nonPrintableLegend2'>
					<button type="button"
						class="float-right btn btn-danger mt-1 btn-circle cancelbtn"
						onclick="cancelFunc();" style="border-radius:50%; padding:12px 12px;">
						<i class="fas fa-times fa-lg" title="Cancel"></i>
					</button>
					
					<button type="button" class="float-right btn btn-secondary btn-circle"
						onclick="document.forms[0].reset();"
						style="border-radius:50%; padding:12px 7px; background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" >
						<i class="fas fa-broom fa-lg iround" title="Clear"></i>
					</button>
					
					<button type="button" id="submitId" class="float-right btn btn-success mt-1 btn-circle savebtn" name="patientAdmissionModiTransBean" tabindex='2'style="border-radius:50%; padding:12px;" onclick='return validate1();'>
						<i class="fa fa-download fa-beat iround" title="Save"></i>
					</button>
				</div>
			</div>
			
			<div class="row ">
				<div class="col-sm-5">
					<p class="subHeaders">
							<i class="fas fa-file-alt iround" title="Cancel"></i>
						&nbsp;Received From Third Party Details
					</p>
				</div>
			</div> -->

				<div class="row my-1">
					<div class="col-md-2 ">Store Name</div>
					<div class="col-md-2">
						<label style="color: blue;"><bean:write
								name="receiveFromThirdPartyTransBean" property="strStoreName"
								filter="false" /></label>
					</div>
					<div class="col-md-2">Item Category</div>
					<div class="col-md-2">
						<label style="color: blue;"><bean:write
								name="receiveFromThirdPartyTransBean"
								property="strItemCategoryName" filter="false" /></label>
					</div>
					<div class="col-md-2">Institute</div>
					<div class="col-md-2">
						<label style="color: blue;"><bean:write
								name="receiveFromThirdPartyTransBean"
								property="strInstituteName" filter="false" /></label>
					</div>
				</div>

				<div class="row my-1 " style="display: none">
					<div class="col-md-4">
						<div id="plus" style="display: none">
							<i class="fas fa-plus-circle" onclick="showinfo();"></i>&nbsp;Received
							Item Information
						</div>
						<div id="minus" style="display: block">
							<i class="fas fa-minus-circle" onclick="hideinfo();"></i>&nbsp;Received
							Item Information
						</div>
					</div>
				</div>

				<div class="row my-1 " style="display: none">
					<div class="col-md-12">
						<div id="demographicInfo" style="display: none" align="center">
							<bean:write name="receiveFromThirdPartyTransBean"
								property="strItemHlp" filter="false" />
						</div>
					</div>
				</div>

				<div class="row my-1 ">
					<div class="col-md-2 ">Remarks:</div>
					<div class="col-md-2" style="color: blue; word-wrap: break-word;">
						<bean:write name="receiveFromThirdPartyTransBean"
							property="strRemarks" filter="false" />
					</div>
					<div class="col-md-2">
						Stock Status<font color="red">*</font>
					</div>
					<div class="col-md-2">
						<select name="strStockStatus"
							class="browser-default custom-select">
							<bean:write name="receiveFromThirdPartyTransBean"
								property="strStockStatusValues" filter="false" />
						</select>
					</div>
					<div class="col-md-2">
						Group Name<font color="red">*</font>
					</div>
					<div class="col-md-2">
						<select name="strGroupId" onchange="getSubGroupListDtls(this);"
							class="browser-default custom-select">
							<bean:write name="receiveFromThirdPartyTransBean"
								property="strGroupCombo" filter="false" />
						</select>
					</div>
				</div>

				<div class="row my-1 ">
					<div class="col-md-2 ">Sub Group Name</div>
					<div class="col-md-2">
						<div id="subGroupComboDivID">
							<select name="strSubGroupId"
								class="browser-default custom-select"
								onChange="ajaxItemName('ITEMNAME');">
								<option value="0">All</option>
							</select>
						</div>
					</div>

					<div class="col-md-2">
						Generic Item Name<font color="red">*</font>
					</div>
					<div class="col-md-2">
						<div id="ItemNameId">
							<select name="strItemId" class='browser-default custom-select'
								onChange="ajaxItemBrandName('ITEMBRANDNAME')">
								<option value="0">All</option>
							</select>
						</div>
					</div>
					<div class="col-md-2">
						Item Name<font color="red">*</font>
					</div>
					<div class="col-md-2">
						<div id="ItemBrandId">
							<select name="strItemBrandId"
								class='browser-default custom-select'
								onchange="ajaxManufectureName('MANUFECTURENAME');">
								<bean:write name="receiveFromThirdPartyTransBean"
									property="strItemBrandCombo" filter="false" />
							</select>
						</div>
					</div>
				</div>

				<div class="row my-1 ">
					<div class="col-md-2 ">
						<div id="manfNotMandatoryDivId" style="display: none;">Manufacture</div>
						<div id="manfMandatoryDivId" style="display: block;">
							Manufacture<font color="red">*</font>
						</div>
					</div>
					<div class="col-md-2">
						<div id="manufDivId">
							<select class="browser-default custom-select"
								name="strManufactureId">
								<option value='0'>Select Value</option>
							</select>
						</div>
					</div>
					<div class="col-md-2">
						<div id="batchNoDivId">Batch No.</div>
						<input type="hidden" name="isBatchReq" value="0">
					</div>
					<div class="col-md-2">
						<input type="text" name="strBatchNo" maxlength="30"
							class=" form-control" onkeypress="return validateData(event,17);" />
					</div>
					<div class="col-md-2">
						<div id="expiryDateDivId">Expiry Date</div>
						<input type="hidden" name="isExpirtReq" value="0">
					</div>
					<div class="col-md-2">
						<input name="strExpiryDate" class="form-control datepicker"
							value="${receiveFromThirdPartyTransBean.strExpiryDate}"
							style="color: rgba(113, 111, 111, 0.87);">
					</div>
				</div>

				<div class="row my-1 ">
					<div class="col-md-2 ">Manufacture Date</div>
					<div class="col-md-2 ">
						<input name="strManufactureDate" class="form-control datepicker"
							value="${receiveFromThirdPartyTransBean.strCtDate}"
							style="color: rgba(113, 111, 111, 0.87);">
					</div>
					<div class="col-md-2">
						Received Quantity<font color="red">*</font>
					</div>
					<div class="col-md-2">
						<input type="text" name="strInHandQuantity" maxlength="8"
							class=" form-control"
							onkeyup="return validateQty('strInHandQuantity','strInHandQuantityUnitID');"
							onkeypress="return validateData(event,7);" value="1" />
					</div>
					<div class="col-md-2">
						Received Quantity Unit<font color="red">*</font>
					</div>
					<div class="col-md-2">
						<div id="freeItemUnit">
							<select name="strInHandQuantityUnitID"
								onchange="return validateQty('strInHandQuantity','strInHandQuantityUnitID');"
								class='browser-default custom-select'>
								<option value="6301^1^0">No.</option>
							</select>
						</div>
					</div>
				</div>

				<div class="row my-1 ">
					<div class="col-md-2">
						<div id="specNotMandatoryDivId" style="display: none;">Specification</div>
						<div id="specMandatoryDivId" style="display: block;">
							Specification<font color="red">*</font>
						</div>
					</div>
					<div class="col-md-10">
						<textarea class="form-control" name="strItemSpecification"
							rows="2" cols="40"></textarea>
					</div>
				</div>
				<br>
				<div class="row my-1 ">
					<div class="col-md-12">
						<i class="fas fa-tags" style="size: 4x; color: #28a745"></i>&nbsp;Rate
						Details
					</div>
				</div>

				<div class="row my-1 ">
					<%-- <div class="col-md-2 ">Currency Code</div>
					<div class="col-md-2">
						<select name="strCurrencyCode"
							class="browser-default custom-select"
							onchange="isCurrencyMandatory(this);">
							<bean:write name="receiveFromThirdPartyTransBean"
								property="strCurrencyCodeValues" filter="false" />
						</select>
					</div>
					<div class="col-md-2">
						<div id="currencyDivId">Currency Value</div>
						<input type="hidden" name="isCurrencyReq" value="0">
					</div>
					<div class="col-md-2">
						<input type="text" name="strCurrencyValue" maxlength="8"
							class="form-control" onkeypress="return validateData(event,7);"
							value="1" disabled="disabled" />
					</div>
 					--%>
					<div class="col-md-2 ">
						MRP<font color="red">*</font>
					</div>
					<div class="col-md-2">
						<input type="text" name="strMRPPrice" maxlength="14"
							class="form-control"
							onkeypress="return(numericWithTwoDecimalPlaces(this,',','.',event));" />
					</div>
					
					<div class="col-md-2 ">
						Received Date<font color="red">*</font>
					</div>
					<div class="col-md-2">
						<input name="strReceivedDate" class="form-control datepicker"
							value="${receiveFromThirdPartyTransBean.strReceivedDate}"
							style="color: rgba(113, 111, 111, 0.87);">
					</div>

					<div class="col-md-2">
						Supplied By<font color="red">*</font>
					</div>
					<div class="col-md-2">
						<select name="strSuppliedBy" class="browser-default custom-select">
							<bean:write name="receiveFromThirdPartyTransBean"
								property="strSuppliedByValues" filter="false" />
						</select>
					</div>
				</div>

				<div class="row my-1 ">
					<div class="col-md-2">
						Rate/Unit<font color="red">*</font>
					</div>
					<div class="col-md-2">
						<!-- <input type="text" name="strRate" maxlength="14"
							class="form-control"
							onkeypress="return(numericWithTwoDecimalPlaces(this,',','.',event));" /> -->
						<input type="text" name="strRate" id="strRate" class="form-control" maxlength="14" onkeypress="return(numericWithTwoDecimalPlaces(this,',','.',event));" oninput="calculateRateWithGst();" />
						
					</div>
					<div style="display:none;">	
						<div class="col-md-2 ">
							Unit Name<font color="red">*</font>
						</div>
						<div class="col-sm-2">
							<div id="UnitRateID">
								<select name="strUnitRateID"
									class='browser-default custom-select'>
									<option value="6301^1^0">No.</option>
								</select>
							</div>
						</div>
					</div>
				
					<div class="col-md-2 ">
						GST(%)<font color="red">*</font>
					</div>
					<div class="col-md-2">
						<!-- <input type="text" name="strGstTax" class="form-control"
							maxlength="5" onchange=" " /> -->
						<input type="text" name="strGstTax" id="strGstTax" class="form-control" maxlength="5" value="0" oninput="calculateRateWithGst();" />
					</div>
					
					<div class="col-md-2 ">
						Rate/Unit Incl.gst<font color="red">*</font>
					</div>

					<div class="col-md-2">
						<!-- <input type="text" name="strRatewithGst" maxlength="14"
							class="form-control"
							onkeypress="return(numericWithTwoDecimalPlaces(this,',','.',event));"
							onBlur="calcIssueRate();" /> -->
						<input type="text" name="strRatewithGst" id="strRatewithGst"  disabled="disabled" maxlength="14" class="form-control"	onkeypress="return(numericWithTwoDecimalPlaces(this,',','.',event));" onBlur="calcIssueRate();" />
					</div>
				</div>

				<div class="row my-1">
					<div style="display:none;">	
						<div class="col-md-2">
							Unit Name<font color="red">*</font>
						</div>
						<div class="col-md-2">
							<div id="UnitRateID">
								<select name="strUnitRateID" disabled="disabled"
									class='browser-default custom-select'>
									<option value="6301^1^0">No.</option>
								</select>
							</div>
						</div>
					</div>
				</div>

				<div class="row my-1 ">
					<div class="col-md-2 ">
						Adm Tax(%)<font color="red">*</font>
					</div>
					<div class="col-md-2">
						<!-- <input type="text" name="strAdminTax" class="form-control"
							autocomplete="off" maxlength="5" /> -->
						<input id="strAdminTax" type="text" name="strAdminTax" class="form-control" autocomplete="off" maxlength="5" value="0" oninput="calculateRateWithGst();" />
					</div>
					
					<div class="col-md-2">
						Unit Name<font color="red">*</font>
					</div>
					<div class="col-md-2">
						<div id="UnitRateID1">
							<select name="strUnitSaleID"
								class='browser-default custom-select'>
								<option value="6301^1^0">No.</option>
							</select>
						</div>
					</div>
					
					<div class="col-md-2 ">
						Sale Rate<font color="red">*</font>
					</div>
					<div class="col-md-2">
						<!-- <input type="text" name="strSalePrice" maxlength="14"
							class="form-control"
							onkeypress="return(numericWithTwoDecimalPlaces(this,',','.',event));" /> -->
						<input id="strSalePrice" type="text" name="strSalePrice" disabled="disabled" maxlength="14" class="form-control"	onkeypress="return(numericWithTwoDecimalPlaces(this,',','.',event));" />
					</div>
				</div>

			<%-- 	<div class="row my-1 ">
					<div class="col-md-2 ">
						Received Date<font color="red">*</font>
					</div>
					<div class="col-md-2">
						<input name="strReceivedDate" class="form-control datepicker"
							value="${receiveFromThirdPartyTransBean.strReceivedDate}"
							style="color: rgba(113, 111, 111, 0.87);">
					</div>

					<div class="col-md-2">
						Supplied By<font color="red">*</font>
					</div>
					<div class="col-md-2">
						<select name="strSuppliedBy" class="browser-default custom-select">
							<bean:write name="receiveFromThirdPartyTransBean"
								property="strSuppliedByValues" filter="false" />
						</select>
					</div>
				</div> --%>

				<logic:equal name="receiveFromThirdPartyTransBean"
					property="strWarrantyFlag" value="9">
					<div class="row my-1 ">
						<div class="col-md-4 ">
							<html:checkbox property="strIsWarrantyDetails"
								name="receiveFromThirdPartyTransBean" value="1"
								onclick="showOrHideDetails(this,'warrantyItemDtlsDivId');">&nbsp;Whether Warranty Details Required</html:checkbox>
						</div>
					</div>

					<div id="warrantyItemDtlsDivId" style="display: none">
						<div class="row my-1 ">
							<div class="col-md-2 ">
								Warranty Date<font color="red">*</font>
							</div>
							<div class="col-md-2">
								<input name=strWarrantyDate class="form-control datepicker"
									value="${receiveFromThirdPartyTransBean.strWarrantyDate}"
									style="color: rgba(113, 111, 111, 0.87);">
							</div>
							<div class="col-md-2">
								Manufacture<font color="red">*</font>
							</div>
							<div class="col-md-2">
								<div id="warrantyManufDivId">
									<select name="strWarantyManufacturer"
										class="browser-default custom-select">
										<option value='0'>Select Value
									</select>
								</div>
							</div>
							<div class="col-md-2">
								Warranty Upto<font color="red">*</font>
							</div>
							<div class="col-md-2">
								<input type="text" name="strWarrantyUpTo" class="form-control"
									maxlength="3" onkeypress="return validateData(event, 5);">
							</div>
						</div>
						<div class="row my-1 ">
							<div class="col-md-2 ">
								Unit<font color="red">*</font>
							</div>
							<div class="col-md-2">
								<select name="strWarrantyUpToUnit"
									class="browser-default custom-select">
									<option value="0">Select Value</option>
									<option value="1">Day(s)</option>
									<option value="2">Month(s)</option>
									<option value="3">Year(s)</option>
								</select>
							</div>
							<div class="col-md-2">Remarks</div>
							<div class="col-md-6">
								<textarea class="form-control" rows="2" cols="25"
									name="strWarrantyRemarks"></textarea>
							</div>

						</div>
					</div>
				</logic:equal>

				<logic:equal name="receiveFromThirdPartyTransBean"
					property="strInstallFlag" value="9">
					<div class="row my-1 ">
						<div class="col-md-4 ">
							<html:checkbox property="strIsInstallDetails"
								name="receiveFromThirdPartyTransBean" value="1"
								onclick="showOrHideDetails(this,'installItemDtlsDivId');">&nbsp;Whether Install Details Required</html:checkbox>
						</div>
					</div>

					<div id="installItemDtlsDivId" style="display: none">
						<div class="row my-1 ">
							<div class="col-md-2 ">
								Installation Start Date<font color="red">*</font>
							</div>
							<div class="col-md-2">
								<input name="strInstallStartDate"
									class="form-control datepicker"
									value="${receiveFromThirdPartyTransBean.strInstallStartDate}"
									style="color: rgba(113, 111, 111, 0.87);">
							</div>
							<div class="col-md-2">
								Installation End Date<font color="red">*</font>
							</div>
							<div class="col-md-2">
								<input name="strInstallEndDate" class="form-control datepicker"
									value="${receiveFromThirdPartyTransBean.strInstallEndDate}"
									style="color: rgba(113, 111, 111, 0.87);">
							</div>
							<div class="col-md-2">
								Installation Status<font color="red">*</font>
							</div>
							<div class="col-md-2">
								<select name="strInstallStatus"
									class="browser-default custom-select">
									<option value='0'>Select Value</option>
									<option value='1'>Success</option>
									<option value='2'>Failure</option>
								</select>
							</div>
						</div>
						<div class="row my-1 ">
							<div class="col-md-2 ">
								Installed By<font color="red">*</font>
							</div>
							<div class="col-md-2">
								<input type="text" class="form-control" name="strInstallBy"
									onkeypress="return validateData(event, 4);" maxlength="100">
							</div>
							<div class="col-md-2">
								Installer Contact No.<font color="red">*</font>
							</div>
							<div class="col-md-2">
								<input type="text" name="strInstallerContactNo"
									onkeypress="return validateData(event, 2);"
									class="form-control" maxlength="10">
							</div>
							<div class="col-md-2">Remarks</div>
							<div class="col-md-2">
								<textarea class="form-control" rows="2" cols="25"
									name="strInstallRemarks"></textarea>
							</div>
						</div>

					</div>
				</logic:equal>

				<div class="row my-1" style="display: none">
					<div class="col-md-4 px-3">
						<div id="freeItemDtlsDivIdPlusId" align="left"
							style="display: block;">
							<i class="fas fa-plus-circle"
								onClick="showView('freeItemDtlsDivId');"
								style="cursor: pointer;"></i>&nbsp;Free Items
						</div>
						<div id="freeItemDtlsDivIdMinusId" style="display: none;"
							align="left">
							<i class="fas fa-minus-circle"
								onClick="hideView('freeItemDtlsDivId');"
								style="cursor: pointer;"></i>&nbsp;Free Items
						</div>
					</div>
					<div class="col-md-4">
						<div id="partItemDtlsDivIdPlusId" align="left"
							style="display: block;">
							<i class="fas fa-plus-circle"
								onClick="showView('partItemDtlsDivId');"
								style="cursor: pointer;"></i>&nbsp; Part Items
						</div>
						<div id="partItemDtlsDivIdMinusId" style="display: none;"
							align="left">
							<i class="fas fa-minus-circle"
								onClick="hideView('partItemDtlsDivId');"
								style="cursor: pointer;"></i>&nbsp; Part Items
						</div>
					</div>

					<div class="col-md-4">
						<div id="paramItemDtlsDivIdPlusId" align="left"
							style="display: block;">
							<i class="fas fa-plus-circle"
								onClick="showView('paramItemDtlsDivId');"
								style="cursor: pointer;"></i>&nbsp;Parameter Details
						</div>
						<div id="paramItemDtlsDivIdMinusId" style="display: none;"
							align="left">
							<i class="fas fa-minus-circle"
								onClick="hideView('paramItemDtlsDivId');"
								style="cursor: pointer;"></i>&nbsp;Parameter Details
						</div>
					</div>

				</div>

				<!-- -------------------------------------------------------------------------------------------------- -->
				<div id="freeItemDtlsDivId" style="display: none">
					<table class="table text-uppercase">
						<thead class='thead-dark' align='center'>
							<tr>
								<th scope='col'
									style='font-weight: 350 !important; font-size: 16px !important;'>Item
									Name</th>
								<th scope='col'
									style='font-weight: 350 !important; font-size: 16px !important;'>Batch
									No.</th>
								<th scope='col'
									style='font-weight: 350 !important; font-size: 16px !important;'>Expiry
									Date</th>
								<th scope='col'
									style='font-weight: 350 !important; font-size: 16px !important;'>Qty</th>
								<th align="center">
									<button type="button" class="float-right btn btn-info mt-1"
										title="Add" onclick="addFreeItems();"
										style="padding: .175rem .35rem; line-height: 0.8">
										<i class="fas fa-plus-square"></i>
									</button>
								</th>
							</tr>
						</thead>
					</table>

					<div id="id1"></div>
				</div>

				<div id="partItemDtlsDivId" style="display: none">
					<table class="table  text-uppercase">
						<thead class='thead-dark ' align='center'>
							<tr>
								<th scope='col'
									style='font-weight: 350 !important; font-size: 16px !important;'>Item
									Name</th>
								<th scope='col'
									style='font-weight: 350 !important; font-size: 16px !important;'>Batch
									No.</th>
								<th scope='col'
									style='font-weight: 350 !important; font-size: 16px !important;'>Manufacturer</th>
								<th scope='col'
									style='font-weight: 350 !important; font-size: 16px !important;'>Expiry
									Date</th>
								<th scope='col'
									style='font-weight: 350 !important; font-size: 16px !important;'>Qty</th>
								<th scope='col'
									style='font-weight: 350 !important; font-size: 16px !important;'>&nbsp;&nbsp;</th>
								<th align="center">
									<button type="button" class="float-right btn btn-info mt-1"
										title="Add" onclick="addPartItems();"
										style="padding: .175rem .35rem; line-height: 0.8">
										<i class="fas fa-plus-square"></i>
									</button>
								</th>
							</tr>
						</thead>
					</table>
					<div id="id2"></div>
				</div>

				<div id="paramItemDtlsDivId" style="display: none">
					<table class="table  text-uppercase" align="center" border="0"
						cellpadding="1px" cellspacing="1px">
						<tr>
							<td colspan="4" class="" width="25%"></td>
						</tr>
						<tr>
							<!-- <td align="center"><img
					src="../../hisglobal/images/add_parameter.GIF"
					onclick="checkForPopup(this,document.forms[0].strItemCategoryNo.value , '1')"
					style="cursor: pointer; "></td> -->
							<td align="center">
								<button type="button" class="float-right btn btn-info mt-1"
									title="Add"
									onclick="checkForPopup(this,document.forms[0].strItemCategoryNo.value , '1')"
									style="padding: .175rem .35rem; line-height: 0.8">
									<i class="fas fa-plus-square"></i>
								</button> <!-- <a href="#" class="button"	><span class="add">Add</span></a> -->
							</td>
						</tr>
					</table>
				</div>
				<hr>
				<div class="row  text-right">
					<div class="col-md-12">
						<font size="2" color="red">*</font>Mandatory Fields
					</div>
				</div>
				<input type="hidden" name="strStoreId"
					value="${receiveFromThirdPartyTransBean.strStoreId}" /> <input
					type="hidden" name="strItemCategoryNo"
					value="${receiveFromThirdPartyTransBean.strItemCategoryNo}" /> <input
					type="hidden" name="strInstituteId"
					value="${receiveFromThirdPartyTransBean.strInstituteId}" /> <input
					type="hidden" name="strRemarks"
					value="${receiveFromThirdPartyTransBean.strRemarks}" /> <input
					type="hidden" name="strCtDate"
					value="${receiveFromThirdPartyTransBean.strCtDate}"> <input
					type="hidden" name="strDefaultCurrencyCode"
					value="${receiveFromThirdPartyTransBean.strDefaultCurrencyCode}">
				<input type="hidden" name="strRegFlag" value="" /> <input
					type="hidden" name="strIssueRateConfigFlg"
					value="${receiveFromThirdPartyTransBean.strIssueRateConfigFlg}">
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

				<div class="popUpDiv" id="popUpDivId" style="display: none;">
					<table bgcolor="white">
						<tr>
							<td>
								<div id="itemParameterDtlDivId" style="display: block;"></div>
							</td>
						</tr>
					</table>
				</div>

				<cmbPers:cmbPers />
			</div>
		</div>

	</html:form>

	<jsp:include page="itemInventory_multirow_mmstransNEW.jsp"></jsp:include>
	<tag:autoIndex></tag:autoIndex>
	<script type="text/javascript">
		$('.datepicker').each(function() {
			$(this).datepicker({
				modal : true,
				header : true,
				footer : true,
				format : 'dd-mmm-yyyy'
			});
		});
		var today = new Date();
		var arr = [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
				"Sep", "Oct", "Nov", "Dec" ];
		var mmm = arr[today.getMonth()];
		var hrs = today.getHours();
		var dd = today.getDate() + "-" + mmm + "-" + today.getFullYear();
		$('.datepicker').val(dd);
	</script>
</body>
</html>








