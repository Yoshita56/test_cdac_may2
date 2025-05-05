<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Consumption Report</title>

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







<script language="Javascript"
	src="../../hisglobal/js/autocompleteItemSearch.js"></script>
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

		var hisValidator = new HISValidator("consumptionRpt");

		document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;

		hisValidator.addValidation("strStoreId", "dontselect=-1",
				"Please Select Store Name");
		hisValidator.addValidation("strItemCatNo", "dontselect=0",
				"Select Item Category From Item Category Combo");
		hisValidator.addValidation("strFromDate", "date",
				"From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date",
				"To Date is a mandatory field");
		hisValidator.addValidation("strToDate", "dtltet="
				+ document.forms[0].strCurrentDate.value,
				"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate", "dtgtet="
				+ document.forms[0].strFromDate.value,
				"Please Select To Date Greater Than Or Equal To From Date");

		var itmeLength = parseInt(document.forms[0].strRightItemIds.length);
		if (itmeLength > 0) {
			var itemBrandIds = [];
			$('#strRightItemIds option').each(function() {
				itemBrandIds.push($(this).val());
			});
			document.forms[0].strItemId.value = itemBrandIds;
		} else {
			document.forms[0].strItemId.value = "0";
		}

		var store = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
		document.forms[0].strStoreName.value = store;
		var cat = document.forms[0].strItemCatNo[document.forms[0].strItemCatNo.selectedIndex].text;
		document.forms[0].strCatName.value = cat;

		var retVal = hisValidator.validate();
		var dd = dateDiff(document.forms[0].strFromDate.value,
				document.forms[0].strToDate.value);
		//alert(dd);
		var dd2 = dd.split(' ')[0];
		if (dd2 > 90) {
			alert("Date difference couldn't be more than 90 days");
			retVal = false;
		}

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

	function getItemCatCmb() {

		if (document.forms[0].strStoreId.value != 0) {
			//document.getElementsByName("strWhetherConsolidated")[0].disabled=true;

			var url = "ConsumptionRptCNT.cnt?hmode=ITEMCATCMB&storeId="
					+ document.forms[0].strStoreId.value;
			ajaxFunction(url, "1");
		} else {
			//document.getElementsByName("strWhetherConsolidated")[0].disabled=false;
			document.forms[0].strItemCatNo.value = "0";
		}
	}
	function getItemCombo() {
		if (document.forms[0].strItemCatNo.value != 0) {
			//document.getElementsByName("strWhetherConsolidated")[0].disabled=true;

			var url = "ConsumptionRptCNT.cnt?hmode=ITEMCMB&storeId="
					+ document.forms[0].strStoreId.value + "&catId="
					+ document.forms[0].strItemCatNo.value;
			ajaxFunction(url, "2");
		} else {
			//document.getElementsByName("strWhetherConsolidated")[0].disabled=false;
			document.forms[0].strItemId.value = "0";
		}
	}
	function getSupplierCombo() {
		if (document.forms[0].strItemCatNo.value != 0) {
			//document.getElementsByName("strWhetherConsolidated")[0].disabled=true;

			var url = "ConsumptionRptCNT.cnt?hmode=SUPPCMB&catId="
					+ document.forms[0].strItemCatNo.value;
			ajaxFunction(url, "3");
		} else {
			//document.getElementsByName("strWhetherConsolidated")[0].disabled=false;
			document.forms[0].strSupplierId.value = "0";
		}
	}

	function LeftListTransfer() {
		//shiftToRightLimit("strLeftItemIds","strRightItemIds",1,25);
		// $('#strItemId').html($('#strLeftItemIds').html()); 
		// loadAutocompleteItems();          

		var ob1 = document.forms[0].strLeftItemIds.value;
		var ob = document.getElementById("strLeftItemIds");
		shiftToRight("strLeftItemIds", "strRightItemIds", 1);
	}

	function transferToLeft() {
		shiftToLeft("strLeftItemIds", "strRightItemIds", 1);
		$('#strItemId').html($('#strLeftItemIds').html());
		// loadAutocompleteItems();         
	}

	function getAjaxResponse(res, mode) {

		if (mode == "1") {

			var objVal = document.getElementById("itemCatDivId");
			objVal.innerHTML = "<select name ='strItemCatNo' onchange='getItemCombo();' class='browser-default custom-select'>"
					+ res + "</select>";

		}
		if (mode == "2") {

			var objVal = document.getElementById("itemDivId");
			objVal.innerHTML = "<select name ='strItemId' class='browser-default custom-select'>"
					+ res + "</select>";
			var objVal1 = document.getElementById("LeftItemIds");
			objVal1.innerHTML = "<select id='strLeftItemIds' class='browser-default custom-select' name='strLeftItemIds' size='10' multiple style='max-height: 180px;'	 onChange='showSelection(this);' >"
					+ res + "</select>";
			getSupplierCombo();

		}
		if (mode == "3") {

			var objVal = document.getElementById("suppDivId");
			objVal.innerHTML = "<select name ='strSupplierId' class='browser-default custom-select'>"
					+ res + "</select>";

		}

	}

	function cancelPage() {
		document.forms[0].hmode.value = "CANCEL";
		document.forms[0].target = "_self";
		document.forms[0].submit();

	}

	function onLoadPage() {

		document.forms[0].strStoreId.value = "0";
		document.forms[0].strItemCatNo.value = "0";
		document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value;
		document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value;

	}
	/*
	 function getDisplay (obj){

	 for(var i = 0 ; i < obj.length ; i++){
	
	 if(obj[i].checked){
	 obj = obj[i];
	 break;
	 }
	 }
	 document.forms[0].strStoreId.value=0;
	 document.forms[0].strItemCatNo.value=0;
	 }*/
</script>
</head>
<body onload="onLoadPage();">
	<html:form action="/reports/ConsumptionRptCNT" method="post">

		<div class="errMsg" id="errMsg">
			<bean:write name="consumptionRpt" property="strErrMsg" />
		</div>
		<div class="normalMsg" id="normalMsg">
			<bean:write name="consumptionRpt" property="strNormalMsg" />
		</div>
		<div class="warningMsg" id="warningMsg">
			<bean:write name="consumptionRpt" property="strWarningMsg" />
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
								&nbsp;Consumption Report
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
							<label>Store</label>
						</div>
						<div class="col-sm-3">
							<select name="strStoreId" class="browser-default custom-select"
								onchange="getItemCatCmb();">
								<bean:write name="consumptionRpt" property="strStoreValues"
									filter="false" />
							</select>
						</div>
						<div class="col-sm-3">
							<label><font color="red">*</font>Category</label>
						</div>
						<div class="col-sm-3">
							<div id="itemCatDivId">
								<select name="strItemCatNo"
									class="browser-default custom-select"
									onchange="getItemCombo();">
									<bean:write name="consumptionRpt" property="strCatVal"
										filter="false" />

								</select>
							</div>
						</div>
					</div>
                   <hr style="border-top: 3px solid rgb(9, 133, 242);margin-bottom: 0.5rem;margin-top: 0.5rem	;">
					<div class="row">
						<div class="col-sm-5">
							<div id="LeftItemIds" align="left">
								<select id="strLeftItemIds" name="strLeftItemIds" style='max-height: 180px;'
									class="form-control" size="10" multiple
									onChange='showSelection(this);'>
									<bean:write name="consumptionRpt" property="strLeftItemList"
										filter="false" />
								</select>
							</div>
						</div>
						<div class="col-sm-2">
							<div style='display: inline;'>
								<br />
								<br />
								<br /> <img src="../../hisglobal/images/forward3.gif" width="30"
									height="21" onclick="LeftListTransfer();">
								<center>
									<img src="../../hisglobal/images/forwardward.gif" width="30"
										height="21" style="display: none;" align="middle"
										onClick="shiftAllToRight('strLeftItemIds','strRightItemIds',1);" />
								</center>
								<br /> <img src="../../hisglobal/images/backward.gif" width="30"
									height="21" style="display: none;"
									onClick="shiftAllToLeft('strLeftItemIds','strRightItemIds',1);">

								<img src="../../hisglobal/images/back3.gif" width="30"
									height="21" onclick="transferToLeft();" />
							</div>
						</div>
						<div class="col-sm-5">
							<div id="RightItemIds" align="left" style='display: inline;'>
								<bean:write name="consumptionRpt" property="strRightItemList"
									filter="false" />
								<select id="strRightItemIds" class="form-control" style='max-height: 180px;'
									name="strRightItemIds" size="10" multiple>
								</select>
							</div>
						</div>
					</div>

                  <hr style="border-top: 3px solid rgb(9, 133, 242);margin-bottom: 0.5rem;margin-top: 0.5rem;">
					<div class="row">
						<div class="col-sm-3">
							<label><font color="red">*</font>Till Date</label>
						</div>
						<div class="col-sm-3">
							<input  class="form-control" id='datepicker' name="strToDate">
							
						</div>
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
					</div>


					<table class="TABLEWIDTH" align="center" cellspacing="1px"
						cellpadding="1px">

						<tr style="display: none;">
							<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Item</td>
							<td width="50%" colspan="2" class="CONTROL">
								<div id="itemDivId">
									<select name="strItemId" class="comboNormal">
										<option value="0">All</option>
									</select>
								</div>
							</td>
						</tr>
						<tr style="display: none;">
							<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Supplier</td>
							<td width="50%" colspan="2" class="CONTROL">
								<div id="suppDivId">
									<select name="strSupplierId" class="comboNormal">
										<option value="0">All</option>
									</select>
								</div>
							</td>
						</tr>
						<tr style="display: none;">
							<td class="LABEL" colspan="2"><font color="red">*</font>From
								Date</td>
							<td class="CONTROL" colspan="2"><dateTag:date
									name="strFromDate" value="${consumptionRpt.strCurrentDate}" /></td>
						</tr>


						<tr style="display: none;">
							<td class="LABEL" colspan="2"><font color="red">*</font>PO
								Type</td>
							<td class="CONTROL" colspan="2"><input type="radio"
								name="strPOType" value="1" checked />Bulk PO<input type="radio"
								name="strPOType" value="2" />Local PO(online)<input
								type="radio" name="strPOType" value="3" />Local PO(offline)</td>
						</tr>

						<tr style="display: none;">
							<td class="LABEL" colspan="2"><font color="red">*</font>Item
								Type</td>
							<td class="CONTROL" colspan="2"><input type="radio"
								name="strItemType" value="0" checked />Unit<input type="radio"
								name="strItemType" value="1" />Misc.</td>
						</tr>



						<!--<tr>
			<td width="50%" colspan="2" class="LABEL">
			Footer Required
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<html:checkbox property="strIsFooter" name="consumptionRpt" value="1"></html:checkbox>
			</td>
			
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			User Remarks
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<input class="txtFldMax" type="text" name="strUserRemarks" >
			</td>
			
		</tr>  -->

					</table>

					<hr>

					<div class="row">
						<div class="col-sm-12" align="right" style="color: #ffa654">Opening balance as on
							1st April of Current Financial Year or Stock Ledger Initiation
							Date whichever is later</div>
					</div>
					<!-- <table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="return validate();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table>-->


					<input type="hidden" name="hmode" /> <input type="hidden"
						name="strCurrentDate" value="${consumptionRpt.strCurrentDate}" />
					<input type="hidden" name="strStoreName"
						value="${consumptionRpt.strStoreName}" /> <input type="hidden"
						name="strCatName" value="${consumptionRpt.strCatName}" />
				</div>
			</div>
		</div>

	</html:form>
	<tag:autoIndex></tag:autoIndex>

	<script type="text/javascript">
	$('#datepicker').datepicker({uiLibrary: 'bootstrap4',modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
	$('#datepicker1').datepicker({uiLibrary: 'bootstrap4',modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
	var today=new Date();
	var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
	var mmm=arr[today.getMonth()];
	var hrs=today.getHours();
	var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
	$('#datepicker1').val(dd);
	$('#datepicker').val(dd);
	</script>  
</body>
</html>	