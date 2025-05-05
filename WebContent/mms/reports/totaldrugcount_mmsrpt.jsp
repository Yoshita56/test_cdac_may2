<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<html>
<head>
<title>Total Drug Count List</title>

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css"
	rel="stylesheet">
<link href=".../../css/newlayout.css" rel="stylesheet" type="text/css">
<link
	href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css"
	rel="stylesheet" type="text/css">

<script type="text/javascript"
	src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>


<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<style type="text/css">
body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 14px;
	line-height: 1.42857143;
	color: rgba(75, 75, 75, 0.7);
	font-weight: 501;
}

.table th, .table td {
	padding: 0.05rem;
}

.form-control {
	color: rgba(75, 75, 75, 0.7);
}

.table {
	width: 100%;
	margin-bottom: 1rem;
	color: rgba(75, 75, 75, 0.7);
}

.prescriptionTile {
	margin: 0.5% 0;
	border-bottom: 1px solid #d7d7d7;
	padding-bottom: 10px;
	padding: 1% 2% 0.5% 2%;
	background-color: #fff;
	transition: 0.5s;
	box-shadow: 0 0.5px 10px 2px #b0acac;
	border-radius: .25rem;
	color: rgba(75, 75, 75, 0.7);
}

.subHeaders {
	font-weight: 500 !important;
	font-family: "Helvetica Neue", "Helvetica";
	font-size: 19px !important;
	padding-bottom: 0px !important;
	color: rgba(75, 75, 75, 0.7);
}

.row {
	padding-bottom: 5px;
}

.legend2 {
	position: absolute;
	top: -2.5em;
	right: 44px;
	line-height: 1.2em;
}

.cancelbtn {
	padding: .175rem .35rem;
	line-height: 0.8;
	background-color: #d9534f;
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

.btn-outline-success {
	color: #28a745;
	border-color: #28a745;
	background-color: #28a745;
}
</style>



<script type="text/javascript">
	function validate() {

		var hisValidator = new HISValidator("totaldrugcountRpt");
		if (document.getElementsByName("strDistrictFlag")[0].value == '2') {
			hisValidator.addValidation("strStoreId", "dontselect=-1",
					"Select Drug Warehouse/Sub-Store Name");
			document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
		} else {
			hisValidator.addValidation("strDistrictStoreId", "dontselect=-1",
					"Select District Drug Warehouse Name ");
			document.forms[0].strStoreName.value = document.forms[0].strDistrictStoreId[document.forms[0].strDistrictStoreId.selectedIndex].text;
		}

		if (document.getElementsByName("strExpNonExpiryFlag")[0].value == '20') {
			if (document.getElementsByName("strDateDaysFlag")[0].value == '22') {
				hisValidator.addValidation("strDueDate", "date",
						"Near Expiry Date is a mandatory field");
				// Not required           hisValidator.addValidation("strDueDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select Due Date Less Than or Equal To Current Date");
			} else {
				hisValidator.addValidation("strExpiryDays", "req",
						"Near Expiry Day(s) is a Mandatory Field");
			}
		}
		hisValidator.addValidation("strItemCatNo", "dontselect=0",
				"Select Item Category From Item Category Combo");
		hisValidator.addValidation("strDueDate", "date",
				"From Date is a mandatory field");

		var retVal = hisValidator.validate();
		hisValidator.clearAllValidations();
		if (retVal) {

			document.forms[0].hmode.value = "SHOWRPT";

			if (document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html") {
				document.forms[0].target = "_self";
			} else {
				document.forms[0].target = "_blank";
			}
			document.forms[0].submit();
		} else {
			return false;
		}
	}

	function cancelPage() {
		document.forms[0].hmode.value = "CANCEL";
		document.forms[0].target = "_self";
		document.forms[0].submit();

	}
	function getItemCatCmb() {

		if (document.forms[0].strStoreId.value != 0) {
			var url = "TotalDrugCountRptCNT.cnt?hmode=ITEMCATCMB&storeId="
					+ document.forms[0].strStoreId.value;
			ajaxFunction(url, "1");
		} else {
			document.forms[0].strItemCatNo.value = "0";
		}
	}

	function getAjaxResponse(res, mode) {

		if (mode == "1") {

			var objVal = document.getElementById("itemCatDivId");
			objVal.innerHTML = "<select name ='strItemCatNo' class='browser-default custom-select'>"
					+ res + "</select>";

		}
		if (mode == "2") {

			var objVal = document.getElementById("itemCatDivId");
			objVal.innerHTML = "<select name ='strItemCatNo' class='browser-default custom-select' >"
					+ res + "</select>";

		}

	}

	function onLoadPage() {

		if (document.forms[0].strUserLevel.value == '6') {
			document.forms[0].strStoreId.value = "0";
		} else {
			document.forms[0].strStoreId.value = "-1";
		}

		document.forms[0].strItemCatNo.value = "0";
		document.forms[0].strDueDate.value = document.forms[0].strCurrentDate.value;
		document.getElementsByName("expired")[0].checked = true;
		document.getElementsByName("nearExpiry")[0].checked = false;

		document.getElementsByName("strExpiryDays")[0].checked = true;
		document.getElementsByName("strExpiryDate")[0].checked = false;

		document.forms[0].strDueDate.value = document.forms[0].strCurrentDate.value;
		document.getElementsByName("strExpNonExpiryFlag")[0].value = "10";// Expired

	}

	function setValueChk(chkObj) {

		if (chkObj.value == '1') {
			document.getElementsByName("nearExpiry")[0].checked = false;
			document.getElementById("nearExpDiv").style.display = "none";
			document.getElementById("expDaysDiv").style.display = "none";
			document.getElementById("expDateDiv").style.display = "none";

			document.getElementsByName("strUserRemarks")[0].value = "";
			document.getElementsByName("strItemCatNo")[0].value = "0";
			document.getElementsByName("strStoreId")[0].value = "0";
			document.forms[0].strDueDate.value = document.forms[0].strCurrentDate.value;
			document.getElementsByName("strExpNonExpiryFlag")[0].value = "10";// Expired

		}
		if (chkObj.value == '2') {
			document.getElementsByName("expired")[0].checked = false;
			document.getElementById("nearExpDiv").style.display = "block";
			document.getElementById("expDaysDiv").style.display = "block";
			document.getElementById("expDateDiv").style.display = "none";

			document.getElementsByName("strUserRemarks")[0].value = "";
			document.getElementsByName("strItemCatNo")[0].value = "0";
			document.getElementsByName("strStoreId")[0].value = "0";
			document.forms[0].strDueDate.value = document.forms[0].strCurrentDate.value;
			document.getElementsByName("strExpNonExpiryFlag")[0].value = "20";//  Near Expiry

		}
	}

	function setExpiryChk(chkObj) {

		if (chkObj.value == '11') {
			document.getElementsByName("strExpiryDays")[0].checked = true;
			document.getElementsByName("strExpiryDate")[0].checked = false;
			document.getElementById("expDaysDiv").style.display = "block";
			document.getElementById("expDateDiv").style.display = "none";
			document.getElementsByName("strExpiryDays")[0].value = "11";
			document.getElementsByName("strDateDaysFlag")[0].value = "11"; // Due Date

		}
		if (chkObj.value == '22') {
			document.getElementsByName("strExpiryDays")[0].checked = false;
			document.getElementsByName("strExpiryDate")[0].checked = true;
			document.getElementById("expDaysDiv").style.display = "none";
			document.getElementById("expDateDiv").style.display = "block";
			document.getElementsByName("strExpiryDate")[0].value = "22";
			document.getElementsByName("strDateDaysFlag")[0].value = "22"; // Due Days	

			document.forms[0].strDueDate.value = document.forms[0].strCurrentDate.value;

		}
	}

	function getItemCatCmb() {

		if (document
				.getElementsByName("whetherConsolidatedStockForAllInstitutseOfDistrictDrugWarehouse")[0].checked == true) {

			if (document.forms[0].strDistrictStoreId.value != 0) {
				var url = "TotalDrugCountRptCNT.cnt?hmode=ITEMCATCMB&storeId="
						+ document.forms[0].strDistrictStoreId.value;
				ajaxFunction(url, "2");

			}

		} else {
			if (document.forms[0].strStoreId.value != 0) {
				var url = "TotalDrugCountRptCNT.cnt?hmode=ITEMCATCMB&storeId="
						+ document.forms[0].strStoreId.value;
				ajaxFunction(url, "2");

			}

		}

	}

	function setDistrictDrugWarehouseCombo() {
		document.getElementsByName("strItemCatNo")[0].value = "0";

		if (document
				.getElementsByName("whetherConsolidatedStockForAllInstitutseOfDistrictDrugWarehouse")[0].checked == true) {
			document.getElementById("drugWarehouseDivId").style.display = 'none';

			document.getElementById("districtDrugWarehouseDivId").style.display = '';
			document.getElementsByName("strDistrictFlag")[0].value = '1';

		} else {
			document.getElementById("drugWarehouseDivId").style.display = '';

			document.getElementById("districtDrugWarehouseDivId").style.display = 'none';
			document.getElementsByName("strDistrictFlag")[0].value = '2';

		}

	}
</script>
</head>
<body onload="onLoadPage();">
	<html:form action="/reports/TotalDrugCountRptCNT" method="post">

		<div class="errMsg" id="errMsg">
			<bean:write name="totaldrugcountRpt" property="strErrMsg" />
		</div>
		<div class="normalMsg" id="normalMsg">
			<bean:write name="totaldrugcountRpt" property="strNormalMsg" />
		</div>
		<div class="warningMsg" id="warningMsg">
			<bean:write name="totaldrugcountRpt" property="strWarningMsg" />
		</div>





		<br>
		<div class="container">
			<div class="row">
				<div class="prescriptionTile col-sm-12" align="center">


					<div class="row rowFlex reFlex">
						<div class="col-sm-7" style="text-align: initial;">
							<p class="subHeaders">

								<i class="fas fa-file-alt iround"
									style="font-size: 20px; color: #28a745" title="Cancel"></i>
								&nbsp;Total Drug Count Report
							</p>
							<!-- <button  type="button" class="btn btn-outline-success mt-1  savebtn" onclick="cancelFunc();">
		                                        <i class="fas fa-file-alt iround"  title="Cancel"></i>
	                                      </button> -->
						</div>
						<div class="col-sm-5">
							<div class="legend2" id='nonPrintableLegend2'>
								<button type="button"
									class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn"
									onclick="cancelFunc();">
									<i class="fas fa-ban iround" title="Cancel"></i>
								</button>
								<button type="button" class=" btn btn-secondary btn-circle"
									onclick="document.forms[0].reset();"
									style="background: #b9b9b9; border-color: #b9b9b9; margin-top: 0.25rem !important;">
									<img src="/HIS/hisglobal/images/clear3.png" title="Clear"
										style="width: 23px; color: #fff;">
								</button>

								<button type="button" id="saveid"
									class="float-right btn btn-outline-success mt-1 btn-circle savebtn"
									tabindex='2' onclick='return validate();'>
									<i class="fas fa-download iround" title="Save"></i>
								</button>


							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-sm-3">
							<label><font color="red">*</font>Store Name</label>
						</div>
						<div class="col-sm-3">
							<select name="strStoreId" class="browser-default custom-select"
								onchange="">
								<bean:write name="totaldrugcountRpt" property="strStoreValues"
									filter="false" />
							</select>
						</div>
						<div class="col-sm-3">
							<label><font color="red">*</font>Category</label>
						</div>
						<div class="col-sm-3">
							<div id="itemCatDivId">
								<logic:equal name="totaldrugcountRpt" property="strUserLevel"
									value="6">
									<select name="strItemCatNo"
										class="browser-default custom-select">
										<option value="0">Select Value</option>
										<option value="10">Drug</option>
									</select>
								</logic:equal>

								<logic:notEqual name="totaldrugcountRpt" property="strUserLevel"
									value="6">
									<select name="strItemCatNo"
										class="browser-default custom-select">
										<option value="0">Select Value</option>
										<option value="10">Drug</option>
									</select>
								</logic:notEqual>

							</div>
						</div>
					</div>



					<table class="TABLEWIDTH" align="center" cellspacing="1px"
						cellpadding="1px">


						<tr style="display: none";>
							<td colspan="2" class="LABEL" width="50%" align="right"><input
								type="checkbox"
								name="whetherConsolidatedStockForAllInstitutseOfDistrictDrugWarehouse"
								value="1" onclick="setDistrictDrugWarehouseCombo();" /></td>


							<td colspan="2" class="CONTROL" width="50%" align="right">
								Whether Consolidated Stock For All Institutes Of District Drug
								Warehouse</td>
						</tr>


					</table>
					<div id="districtDrugWarehouseDivId" style="display: none;">
						<table class="TABLEWIDTH" align="center" cellspacing="1px"
							cellpadding="1px">
							<tr>
								<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>District
									Drug Warehouse Name</td>
								<td width="50%" colspan="2" class="CONTROL"><select
									name="strDistrictStoreId" class="comboMax"
									onchange="getItemCatCmb();">
										<bean:write name="totaldrugcountRpt"
											property="strDistrictStoreValues" filter="false" />
								</select></td>
							</tr>
						</table>
					</div>

					<div id="nearExpDiv" style="display: none;">
						<table class="TABLEWIDTH" align="center" cellspacing="1px"
							cellpadding="1px">
							<tr>
								<td class="LABEL" width="50%">Near Expiry In</td>
								<td class="CONTROL" width="25%"><input type="radio"
									name="strExpiryDays" value="11" onclick="setExpiryChk(this);">Day(s)
								</td>
								<td class="CONTROL" width="25%"><input type="radio"
									name="strExpiryDate" value="22" onclick="setExpiryChk(this);">Date


								</td>
							</tr>
						</table>
					</div>

					<div id="expDaysDiv" style="display: none;">

						<table class="TABLEWIDTH" align="center" cellspacing="1px"
							cellpadding="1px">
							<tr>
								<td width="50%" class="LABEL"></td>

								<td width="25%" class="CONTROL"><input class="txtFldNormal"
									type="text" name="strFrmExpiryDays"
									onkeypress="return validateData(event,5);" maxlength="3">
								</td>

								<td width="25%" class="CONTROL"></td>
							</tr>
						</table>
					</div>
					<div id="expDateDiv" style="display: none;">

						<table class="TABLEWIDTH" align="center" cellspacing="1px"
							cellpadding="1px">
							<tr>
								<td width="50%" class="LABEL"></td>

								<td width="50%" class="CONTROL"><dateTag:date
										name="strDueDate" value="${totaldrugcountRpt.strCurrentDate}" />
								</td>


							</tr>
						</table>
					</div>

					<div class="row">
						<div class="col-sm-3">
							<label>Report Format</label>
						</div>
						<div class="col-sm-3">
							<select name="strReportFormat" onchange=""
								class="browser-default custom-select">
								<option value="html">Html</option>
								<option value="pdf">Pdf</option>
								<option value="xls">Excel</option>
							</select>
						</div>
						<div class="col-sm-3">
							<label>User Remarks</label>
						</div>
						<div class="col-sm-3">
							<input class="form-control" type="text" name="strUserRemarks">
						</div>
					</div>

					<table class="TABLEWIDTH" align="center" cellspacing="1px"
						cellpadding="1px">
						<tr style="display: none;">
							<td width="50%" colspan="2" class="LABEL">Footer Required</td>
							<td width="50%" colspan="2" class="CONTROL"><html:checkbox
									property="strIsFooter" name="totaldrugcountRpt" value="1"></html:checkbox>
							</td>
						</tr>

					</table>

					<hr>
					<div class="row">
						<div class="col-sm-12" align="right" >
							<font color='red'>*</font>Mandatory Field
						</div>
					</div>
					<!--<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="return validate();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table>-->
					
					<!-- <div align="center" id="">					 
					 	<a href="#" class="button" id="" onclick=' return validate();'><span class="generate">Generate</span></a>
						<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelFunc();"><span class="cancel">Cancel</span></a>
				</div> -->
					<input type="hidden" name="hmode" /> <input type="hidden"
						name="strDistrictFlag" value="2" /> <input type="hidden"
						name="strExpNonExpiryFlag" /> <input type="hidden"
						name="strDateDaysFlag" /> <input type="hidden"
						name="strStoreName" /> <input type="hidden" name="strCurrentDate"
						value="${totaldrugcountRpt.strCurrentDate}" /> <input
						type="hidden" name="strUserLevel"
						value="${totaldrugcountRpt.strUserLevel}" />

				</div>
			</div>
		</div>
	</html:form>
	<tag:autoIndex></tag:autoIndex>
</body>
</html>