<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=UTF-8">
<title>Drug Inventory</title>


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
<!-- end -->

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

<style type="text/css">
/* .col-sm-1half, .col-sm-8half, .col-sm-half {
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
 */
.table {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-weight: 400;
	color: #212529;
}

textarea {
	width: 100%;
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
	function controlToMainPage() {
		document.forms[0].hmode.value = "unspecified";
		document.forms[0].submit();
	}

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

	<html:form name="receiveFromThirdPartyTransBean" action="/transactions/ReceiveFromThirdPartyTransCNTNEW" type="mms.transactions.controller.fb.ReceiveFromThirdPartyTransFB">

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
								onclick="cancelViewPage();">
								<i class="fas fa-times  iround" title="Cancel"></i>
							</button>

							<button type="button"
								class="float-right btn btn-secondary  mt-1 btn-circle"
								onclick="pageResetMethod();"
								style="background-color: royalblue;">
								<i class="fas fa-broom iround" title="Clear"></i>
							</button>

							<button type="button" id="submitId"
								class="float-right btn btn-success mt-1 btn-circle savebtn"
								name="patientAdmissionModiTransBean" tabindex='2'
								onclick='return validate1();'>
								<i class="fa fa-download fa-beat iround" title="Save"></i>
							</button>
						</div>
					</div>
				</div>

				<div class="container">
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

					<div class="row my-1">
						<div class="col-md-2 ">Remarks:</div>
						<div class="col-md-10" style="word-wrap: break-word; color: blue;">
							<bean:write name="receiveFromThirdPartyTransBean"
								property="strRemarks" filter="false" />
						</div>
					</div>

					<div class="row my-1">
						<div class="col-md-2">
							Group Name<font color='red'>*</font>
						</div>
						<div class="col-md-2">
							<select name="strGroupId" onchange="getSubGroupListDtls(this);"
								class="browser-default custom-select">
								<bean:write name="receiveFromThirdPartyTransBean"
									property="strGroupCombo" filter="false" />
							</select>
						</div>

						<div class="col-md-2">Sub Group Name</div>
						<div class="col-md-2" id="subGroupComboDivID">
							<select name="strSubGroupId"
								class="browser-default custom-select"
								onChange="ajaxItemName('ITEMNAME');">
								<option value="0">All</option>
							</select>
							<!-- <div id="subGroupComboDivID"></div> -->
						</div>
					</div>

					<div class="row my-1">
						<div class="col-md-2 ">
							Generic Drug Name<font color="red">*</font>
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
							Drug Name<font color="red">*</font>
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
						<div class="col-md-2">
							Stock Status<font color="red">*</font>
						</div>
						<div class="col-md-2">
							<div id="stockStatusComboDivId">
								<select name="strStockStatus"
									class="browser-default custom-select">
									<bean:write name="receiveFromThirdPartyTransBean"
										property="strStockStatusValues" filter="false" />
								</select>
							</div>
						</div>
					</div>

					<div class="row my-1">
						<div class="col-md-2">
							<div id="batchNoDivId">
								Batch No.<font color='red'>*</font>
							</div>
							<input type="hidden" name="isBatchReq" value="1">
						</div>
						<div class="col-md-2">
							<input type="text" name="strBatchNo" maxlength="30"
								class="form-control" onkeypress="return validateData(event,17);" />
						</div>

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

						<div class="col-md-2 ">Manufacture Date</div>
						<div class="col-md-2">
							<input name="strManufactureDate" id="datepicker2"
								class="form-control"
								value="${receiveFromThirdPartyTransBean.strCurrentDate}" />
						</div>
					</div>

					<div class="row my-1">
						<div class="col-md-2">
							<div id="expiryDateDivId">
								Expiry Date<font color='red'>*</font>
							</div>
							<input type="hidden" name="isExpirtReq" value="1">
						</div>
						<div class="col-md-2">
							<%-- <input  name="strExpiryDate" class="form-control datepicker" value="${receiveFromThirdPartyTransBean.strExpiryDate}"
					style="color: rgba(113, 111, 111, 0.87);"> --%>
							<input name="strExpiryDate" id="datepicker1" class="form-control"
								value="${receiveFromThirdPartyTransBean.strCurrentDate}" />
						</div>
						<div class="col-md-2">
							Received Quantity<font color="red">*</font>
						</div>
						<div class="col-md-2">
							<input type="text" name="strInHandQuantity" maxlength="8"
								class="form-control" onkeypress="return validateData(event,5);"
								value="1" />
						</div>
						<div class="col-md-2">
							Received Quantity Unit<font color="red">*</font>
						</div>
						<div class="col-md-2">
							<div id="freeItemUnit">
								<select name="strInHandQuantityUnitID"
									class='browser-default custom-select'>
									<option value="6301^1^0">No.</option>
								</select>
							</div>
						</div>
					</div>

					<div class="row my-1">
						<div class="col-md-2 ">Rack No</div>
						<div class="col-md-2">
							<input type="text" name="strRackNumber" maxlength="8"
								class="form-control" onkeypress="return validateData(event,3);" />
						</div>

						<div class="col-md-2">
							<div id="specNotMandatoryDivId" style="display: none;">Specification</div>
							<div id="specMandatoryDivId" style="display: block;">
								Specification<font color="red">*</font>
							</div>
						</div>
						<div class="col-md-6">
							<textarea class="form-control" rows="1" cols="40"
								name="strItemSpecification"></textarea>
						</div>
					</div>
				</div>
				<br>

				<div class="row ">
					<div class="subHeaders col-md-12">
						<i class="fas fa-tags" style="size: 4x; color: #28a745"></i>&nbsp;Rate
						Details
					</div>
				</div>

				<div class="container">
					<div class="row my-1">
						<div class="col-md-2 ">
							MRP<font color="red">*</font>
						</div>
						<div class="col-md-2">
							<input type="text" name="strMRPPrice" maxlength="14"
								class="form-control"
								onkeypress="return(numericWithTwoDecimalPlaces(this,',','.',event));" />
						</div>

						<div class="col-md-2">
							Received Date<font color="red">*</font>
						</div>
						<div class="col-md-2">
							<input name="strReceivedDate" id="datepicker3"
								class="form-control"
								value="${receiveFromThirdPartyTransBean.strReceivedDate}" />
						</div>

						<div class="col-md-2">
							Supplied By<font color="red">*</font>
						</div>
						<div class="col-md-2">
							<select name="strSuppliedBy"
								class="browser-default custom-select">
								<bean:write name="receiveFromThirdPartyTransBean"
									property="strSuppliedByValues" filter="false" />
							</select>
						</div>
					</div>

					<div class="row my-1">
						<div class="col-md-2">
							Rate/Unit<font color="red">*</font>
						</div>
						<div class="col-md-2">
							<input type="text" name="strRate" id="strRate"
								class="form-control" maxlength="14"
								onkeypress="return numericWithTwoDecimalPlaces(this,',','.',event);"
								oninput="calculateRateWithGst();" />
						</div>
						<div style="display: none;">
							<div class="col-md-2">
								Unit Name<font color="red">*</font>
							</div>
							<div class="col-md-2">
								<div id="UnitRateID">
									<select name="strUnitRateID" 
										class='browser-default custom-select'>
										<option value="6301^1^0">No.</option>
									</select>
								</div>
							</div>
						</div>
						<div class="col-md-2">
							GST(%)<font color="red">*</font>
						</div>
						<div class="col-md-2">
							<input type="text" name="strGstTax" id="strGstTax"
								class="form-control" maxlength="5" value="0"
								oninput="calculateRateWithGst();" />
						</div>
						<div class="col-md-2">
							Rate/Unit Incl.gst<font color="red">*</font>
						</div>
						<div class="col-md-2">
							<input type="text" id="strRatewithGst" name="strRatewithGst" 
								 maxlength="14" class="form-control" oninput="calculateRateWithGst();
								onkeypress="return numericWithTwoDecimalPlaces(this,',','.',event);"/>
						</div>
					</div>


					<div style="display: none;">
						<div class="col-md-2">
							Unit Name<font color="red">*</font>
						</div>
						<div class="col-md-2">
							<div id="UnitRateID">
								<select name="strUnitRatewithGstID" disabled="disabled"
									class='browser-default custom-select'>
									<option value="6301^1^0">No.</option>
								</select>
							</div>
						</div>
					</div>

					<div class="row my-1">
						<div class="col-md-2 ">
							Adm Tax(%)<font color="red">*</font>
						</div>
						<div class="col-md-2">
							<!-- <input type="text" name="strAdminTax" class="form-control" autocomplete="off" maxlength="5"/> -->
							<input id="strAdminTax" type="text" name="strAdminTax" class="form-control"
								autocomplete="off" maxlength="5" value="0"
								oninput="calculateRateWithGst();" />
						</div>

						<div class="col-md-2">
							Unit Name<font color="red">*</font>
						</div>
						<div class="col-md-2">
							<div id="UnitRateID1">
								<select name="strUnitSaleID" disabled="disabled"
									class='browser-default custom-select'>
									<option value="6301^1^0">No.</option>
								</select>
							</div>
						</div>

						<div class="col-md-2 ">
							Sale Rate<font color="red">*</font>
						</div>
						<div class="col-md-2">
							<input id="strSalePrice" type="text" name="strSalePrice" 
								maxlength="14" class="form-control" oninput="calculateRateWithGst();
								onkeypress="return (numericWithTwoDecimalPlaces(this,',','.',event));" />
						</div>
					</div>

				</div>

				<hr>

				<div class="row text-right">
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
					type="hidden" name="strConfigIssueRate"
					value="${receiveFromThirdPartyTransBean.strConfigIssueRate}">
				<input
					type="hidden" name="strIssueRateConfigFlg"
					value="${receiveFromThirdPartyTransBean.strIssueRateConfigFlg}"> <input
					type="hidden" name="strReceivedFromThirdPartyName"
					value="${receiveFromThirdPartyTransBean.strInstituteName}"> <input
					type="hidden" name="hmode" />
					
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

			</div>
		</div>

		<cmbPers:cmbPers />
	</html:form>

	<script type="text/javascript">
		$('#datepicker1').datepicker({
			modal : true,
			header : true,
			footer : true,
			format : 'dd-mmm-yyyy'
		});
		$('#datepicker2').datepicker({
			modal : true,
			header : true,
			footer : true,
			format : 'dd-mmm-yyyy'
		});
		$('#datepicker3').datepicker({
			modal : true,
			header : true,
			footer : true,
			format : 'dd-mmm-yyyy'
		});
		var today = new Date();
		var arr = [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
				"Sep", "Oct", "Nov", "Dec" ];
		var mmm = arr[today.getMonth()];
		var hrs = today.getHours();
		var dd = today.getDate() + "-" + mmm + "-" + today.getFullYear();
		$('#datepicker1').val(dd);
		$('#datepicker2').val(dd);
		$('#datepicker3').val(dd);
	</script>

	<jsp:include page="drugInventory_multirow_mmstrans.jsp"></jsp:include>
	<tag:autoIndex></tag:autoIndex>
</body>
</html>








