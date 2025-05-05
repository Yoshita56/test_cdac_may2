<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title></title>

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

<!-- JQuery -->
<script src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script src="/INVMGM/hisglobal/js/jquery.autocomplete.min.js"></script>

<!-- BS Library  -->
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap.css"
	rel="stylesheet" />
<link
	href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css"
	rel="stylesheet" />
<link
	href="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css"
	rel="stylesheet" type="text/css">
<link
	href="/INVMGM/hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css"
	rel="stylesheet">

<!-- JS Library  -->
<script type="text/javascript"
	src="/INVMGM/hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js""></script>
<script type="text/javascript"
	src="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>


<style type="text/css">
body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 14px;
	line-height: 1.42857143;
	color: rgba(0, 0, 0, 1);
	font-weight: 501;
}

.prescriptionTile {
	margin: 24px;
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
	top: -2.5em;
	right: 44px;
	line-height: 1.2em;
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

.subHeaders {
	font-weight: 500 !important;
	font-family: "Helvetica Neue", "Helvetica";
	font-size: 19px !important;
	padding-bottom: 0px !important;
	color: rgba(0, 0, 0, 1);
}
/* Add smooth transition effect to the arrow */
.arrow-icon {
    transition: transform 0.3s ease-in-out; /* smooth transition on transform */
}

/* Move the arrow down on hover */
#go-btn:hover .arrow-icon {
    transform: translateY(5px); /* Move the arrow down by 5px on hover */
}

/* Optional: Add a subtle hover effect for the button itself */
#go-btn:hover {
    cursor: pointer;
    opacity: 0.9; /* Optional effect for button */
}
</style>

<script type="text/javascript">
function getItemCatCmb(){ 

	if(document.forms[0].strStoreId.value!=0){
		var url ="BillApprovalVerificationRptCNT.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
		//alert(url);
 		ajaxFunction(url,"4");
 	}else{
	document.forms[0].strItemCatId.value="0";
}
}
	
	function validateGo() {

		var hisValidator = new HISValidator("billApprovalBean");

		hisValidator.addValidation("strStoreId", "dontselect=0",
				"Select Store Name from Store Combo ");
		hisValidator.addValidation("strItemCatId", "dontselect=0",
				"Select Item Category From Item Category Combo");
		hisValidator.addValidation("strBillTypeId", "dontselect=0",
				"Select Bill Type From Bill Type Combo");
		hisValidator.addValidation("strSupplierId", "dontselect=0",
				"Select Supplier Type From Supplier Type Combo ");

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

		var retVal = hisValidator.validate();
		var dd = dateDiff(document.forms[0].strFromDate.value,
				document.forms[0].strToDate.value);
		// alert(dd);
		var dd2 = dd.split(' ')[0];
		/* if( dd2> 30)
		     {
		     alert("Time difference couldn't be more than 30 days");
		    retVal= false;
		     }*/

		hisValidator.clearAllValidations();

		if (retVal) {
			
		    document.getElementById("poCombobtnId").style.display = "none";

			/* document.forms[0].hmode.value = "SHOWRPT";
			document.forms[0].submit();  */

			document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
			document.forms[0].strBillTypeName.value = document.forms[0].strBillTypeId[document.forms[0].strBillTypeId.selectedIndex].text;

			console.log("document.forms[0].strStoreName.value-->"
					+ document.forms[0].strStoreName.value);
			console.log("document.forms[0].strBillTypeName.value-->"
					+ document.forms[0].strBillTypeName.value);

			var hmode = "POCOMBOPAGE";
			var url = "BillApprovalVerificationRptCNT.cnt?hmode="+hmode
					+ "&storeId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value
					+ "&storeName="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text
					+ "&strItemCatId="+document.forms[0].strItemCatId[document.forms[0].strItemCatId.selectedIndex].value
					+ "&strSupplierId="+document.forms[0].strSupplierId.value
					+ "&strBillTypeId="+document.forms[0].strBillTypeId.value
					+ "&startDate=" + document.forms[0].strFromDate.value
					+ "&endDate=" + document.forms[0].strToDate.value;

			//alert(url);
			/* document.forms[0].hmode.value = "POCOMBOPAGE";
			document.forms[0].submit(); */

			ajaxFunction(url, "2");

		} else {
			return false;
		}
	}
	
	function validateGen() {

		var hisValidator = new HISValidator("billApprovalBean");

		hisValidator.addValidation("strPoNoId", "dontselect=0",
				"Select Po No from Po No Combo ");

		var retVal = hisValidator.validate();
		
		hisValidator.clearAllValidations();

		if (retVal) {

			/* document.forms[0].hmode.value = "SHOWRPT";
			document.forms[0].submit();  */

			document.forms[0].strPoNoName.value = document.forms[0].strPoNoId[document.forms[0].strPoNoId.selectedIndex].text;

			console.log("document.forms[0].strPoNoId.value-->"+ document.forms[0].strPoNoId.value);
			/* document.getElementsByName("strStoreId")[0].disabled = false;
			document.getElementsByName("strItemCatId")[0].disabled = false;
			document.getElementsByName("strSupplierId")[0].disabled = false; */
			document.getElementsByName("strBillTypeId")[0].disabled = false;
			/* document.getElementsByName("strFromDate")[0].disabled = false;
			document.getElementsByName("strToDate")[0].disabled = false; */
			

			var hmode = "GET_PO_DETAILS";
			var url = "BillApprovalVerificationRptCNT.cnt?hmode="+hmode
					+ "&storeId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value
					+ "&storeName="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text
					+ "&strItemCatId="+document.forms[0].strItemCatId[document.forms[0].strItemCatId.selectedIndex].value
					+ "&strSupplierId="+document.forms[0].strSupplierId.value
					+ "&strBillTypeId="+document.forms[0].strBillTypeId.value
					+ "&strPoNoId="+document.forms[0].strPoNoId.value
					+ "&startDate=" + document.forms[0].strFromDate.value
					+ "&endDate=" + document.forms[0].strToDate.value;

			//alert(url);
			ajaxFunction(url, "3");

		} else {
			return false;
		}
	}
	
	//New toggle function to show/hide the PO Combo div
	function togglePOComboDiv(show) {
	    var poDiv = document.getElementById('POComboDiv');
	    poDiv.style.display = show ? 'block' : 'none';
	}
	
	function refreshSelectOptions() {
	    const select = document.getElementById('strPoNoId');
	    
	    // Reset the selected value to the default "Select PO No" option
	    select.value = '0'; // Assuming '0' is the value of the default option "Select PO No"

	    // Optionally, you can visually reset it to the default option by ensuring it is selected:
	    const defaultOption = select.querySelector('option[value="0"]');
	    if (defaultOption) {
	        defaultOption.selected = true;
	    }

	    // Enable the select field
	    select.disabled = false;
	}


	
	function getAjaxResponse(res, mode) {

		if (mode == "1") {
			var objVal = document.getElementById("patientCatDivId");
			objVal.innerHTML = "<select name ='strPatientCategory' class='custom-select' onChange=' ' >"
					+ res + "</select>";
		}

		if (mode == "2") {
			
			document.getElementsByName("strStoreId")[0].disabled = true;
			document.getElementsByName("strItemCatId")[0].disabled = true;
			document.getElementsByName("strSupplierId")[0].disabled = true;
			document.getElementsByName("strBillTypeId")[0].disabled = true;
			document.getElementsByName("strFromDate")[0].disabled = true;
			document.getElementsByName("strToDate")[0].disabled = true;
			
			/* document.forms[0].hmode.value = "POCOMBOPAGE";
			document.forms[0].submit();  */

			/* objVal = document.getElementById("POComboDiv");
			objVal.style.display = "block"; */

			/* document.getElementById("TriBtnDivId").style.display = "block";
			objVal.innerHTML = res; */
			
            togglePOComboDiv(true);  // Show the PO Combo div

            // Here, the `res` should contain the updated HTML content (new PO options)
            // For example, if `res` is a string with <option> elements, we insert it inside the select element
            var poComboSelect = document.getElementById("strPoNoId");
        	if(res=="")
			{
        		poComboSelect.innerHTML="";
			}
        	else
			{   
        		poComboSelect.innerHTML = res;  // This assumes the response contains valid <option> elements
			}

            // Optionally, you can set a default value or focus on the select element
            //poComboSelect.value = "0";  // Set to the default option (Select Value)
		}
		if (mode == "3") {
		    document.getElementsByName("strPoNoId")[0].disabled = true;
			objVal = document.getElementById("ReportDiv");
// 			alert("res"+res);

			objVal.style.display = "block";
			objVal.innerHTML = res; 
		}
		if(mode=="4"){ 
			var objVal= document.getElementById("itemCatDivId");
			objVal.innerHTML = "<select name ='strItemCatId' class='custom-select'>"+res+"</select>"; 		
		}	
	}

	function cancelPage() {
		document.forms[0].hmode.value = "CANCEL";
		document.forms[0].target = "_self";
		document.forms[0].submit();

	}

	function onLoadpage() {
		document.forms[0].strStoreId.value = "0";
		document.forms[0].strItemCatId.value = "0";
		document.forms[0].strSupplierId.value = "0";
		document.forms[0].strBillTypeId.value = "0";
		document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value;
		document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value;
	}

	function printReport() {
		document.getElementById("printRptId").style.display = "none";

		// Clone the content excluding the last column
		const contentToPrint = document.getElementById("ReportDiv")
				.cloneNode(true);
		const rows = contentToPrint.querySelectorAll('tr');

		/*  for (const row of rows) {
		     const lastCell = row.lastElementChild;
		     if (lastCell) {
		         row.removeChild(lastCell);
		     }
		 }
		 */
		const newWin = window.open('', '',
				'width=700,height=700,scrollbars=yes');
		newWin.document.write('<html><head>');
		newWin.document.write('<style type="text/css">');
		newWin.document.write('.hidecontrol { display: none; }');
		newWin.document.write('@media print {');
		newWin.document.write('  table {border-collapse: collapse; }');
		newWin.document.write('}');
		newWin.document.write('</style>');

		newWin.document.write('</head><body>');
		newWin.document.write(contentToPrint.outerHTML);
		newWin.document.write('</body></html>');

		newWin.document.close();

		newWin.onload = function() {
			newWin.print();
			newWin.close();
			document.getElementById("printRptId").style.display = "block";
		};
	}

	function controlToMainPage() {
		document.forms[0].hmode.value = "unspecified";
		document.forms[0].submit();
	}
</script>

</head>
<body onload="onLoadpage();">
	<%-- <html:form action="/reports/BillApprovalVerificationRptCNT" method="post">
 --%>
	<html:form name="billApprovalBean"
		action="/reports/BillApprovalVerificationRptCNT"
		type="mms.reports.controller.fb.BillApprovalVerificationRptFB">

		<div class="errMsg" id="errMsg">
			<bean:write name="billApprovalBean" property="strErrMsg" />
		</div>
		<div class="normalMsg" id="normalMsg">
			<bean:write name="billApprovalBean" property="strNormalMsg" />
		</div>
		<div class="warningMsg" id="warningMsg">
			<bean:write name="billApprovalBean" property="strWarningMsg" />
		</div>

		<div class="container-fluid">
			<div class="prescriptionTile">

<!--TITLE_BTN RJ47 START-->
				<div class="row ">
					<div class="col-sm-6" style="text-align: initial;">
						<p class="subHeaders">

							<i class="fas fa-file-alt iround"
								style="font-size: 20px; color: #28a745" title="Cancel"></i>
							&nbsp;Bill Approval Verification Report
						</p>
					</div>

					<div class="col-sm-6" id="TriBtnDivId">
						<div class="legend2" id='nonPrintableLegend2'>
							<button type="button"
								class="float-right btn btn-danger mt-1 btn-circle printbtn"
								onclick="cancelFunc();">
								<i class="fas fa-times iround" title="Cancel"></i>
							</button>
							<button type="button"
								class="float-right btn btn-secondary mt-1 btn-circle clearbtn"
								style="background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;"
								onClick="controlToMainPage();">
								<i class="fas fa-broom iround" title="Clear"></i>
							</button>

							<button type="button" id="generatebutton"
								class="float-right btn btn-success mt-1 btn-circle savebtn"
								tabindex='2' onclick='return validateGen();'>
								<i class="fa fa-save iround" title="Generate Report"></i>
							</button>
						</div>
					</div>
				</div>
<!--TITLE_BTN RJ47 END-->

<!-- HEADER RJ47 START -->
				<div class="container">
					<div class="row" style="margin: 1% 12%;">
						<div class="col-sm-2">
							<label>Store Name<font color="red">*</font></label>
						</div>
						<div class="col-sm-4">
							<select name="strStoreId" class='custom-select' onchange="getItemCatCmb();">
								<bean:write name="billApprovalBean" property="strStoreValues"
									filter="false" />
							</select>
						</div>


						<div class="col-sm-2">
							<label>Category<font color="red">*</font></label>
						</div>
						<div class="col-sm-4">
						<div id="itemCatDivId">
						
							<select name="strItemCatId" class="custom-select">
								<bean:write name="billApprovalBean" property="strItemCatValues"
									filter="false" />
								<option value="0">Select Value</option>
							</select>
							</div>
						</div>
					</div>


					<div class="row" style="margin: 1% 12%;">
						<div class="col-sm-2">
							<label>Supplier<font color="red">*</font></label>
						</div>
						<div class="col-sm-4">
							<select class="custom-select" name="strSupplierId" onchange="">
								<bean:write name="billApprovalBean" property="strSupplierCombo"
									filter="false" />
							</select>
						</div>

						<div class="col-sm-2">
							<label>Bill Type<font color="red">*</font></label>
						</div>
						<div class="col-sm-4">
							<select class="custom-select" name="strBillTypeId" onchange="">
								<bean:write name="billApprovalBean" property="strBillTypeCombo"
									filter="false" />
							</select>
							<!-- <select name="billApprovalBean"  class="custom-select">
							<option value="0">Select Value</option>
							<option value="10">BULK PO INVOICE</option>
							<option value="11">LOCAL PO INVOICE</option>					
							<option value="12">SUPPLIER RECEIPT</option>					
						</select>  -->
						</div>
					</div>

					<div class="row" id="fromToDateDivId" style="margin: 1% 12%;">
						<div class="col-sm-2">
							<label>From Date<font color="red">*</font></label>
						</div>
						<div class="col-sm-4">
							<input class="form-control" name="strFromDate"
								id='datepicker1'>
						</div>
						<div class="col-sm-2">
							<label>To Date<font color="red">*</font></label>
						</div>
						<div class="col-sm-4">
							<input class="form-control" name="strToDate"
								id='datepicker2'>
						</div>
					</div>
					
					<hr>
					<div id="poCombobtnId" class="row"  style="margin: 1% 14%;">
                  		<div class="col" align="center" 
              					style="display:flex; justify-content:center;">
	                      <button type="button" id="gobutton" 
	                      		class="btn btn-success btn-sm mt-1" 
	                      		title="Click to Generate Report" onclick="validateGo();"> 
	                              <div id="go-btn" class="popupToast" style="color: #fff;">
	                                  <span class="popuptextToast">GO </span>
	                                  <i class="fas fa-angle-double-down arrow-icon"></i>
	                              </div>
	                      </button>
                  		</div>
            		</div>
				</div>
<!-- HEADER RJ47 END -->

<!-- HIDDEN PONO COMBO RJ47 START -->
				<div align="center" id="POComboDiv" style="display: none;">
					<div class="container">
						<div class="row" style="margin: 1% 14%;">
							<div class="col-sm-2">
								<label for="strPoNoId" class="text-muted">Select PO No</label>
							</div>
							
							<div class="col-sm-4 px-4 mx-2">
								<select name="strPoNoId" id="strPoNoId" class='custom-select'>
									<!-- <option value="0">Select Value</option> -->
									<%-- <bean:write name="billApprovalBean" property="strPoNoCombo"
									filter="false" /> --%>
								</select>
							</div>

							<div>
								<a onclick="refreshSelectOptions()" style="cursor: pointer;"
									title="Refresh PO No"> <img height="28px" width="28px"
									alt="Refresh" src="../../hisglobal/images/reload.png">
								</a>
							</div>

						</div>
					</div>
				</div>
<!-- HIDDEN PONO COMBO RJ47 END -->
<hr>
<!--REPORT RJ47 START-->
			<div align="center" id="ReportDiv" style="display:none;"></div>
<!--REPORT RJ47 END-->
				
			</div>
		</div>


		<input type="hidden" name="hmode" />
		<input type="hidden" name="strCurrentDate"
			value="${billApprovalBean.strCurrentDate}" />

		<input type="hidden" name="strStoreName" value="" />
		<input type="hidden" name="strBillTypeName" value="" />
		<input type="hidden" name="strPoNoName" value="" />
	
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
		var today = new Date();
		var arr = [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
				"Sep", "Oct", "Nov", "Dec" ];
		var mmm = arr[today.getMonth()];
		var hrs = today.getHours();
		var dd = today.getDate() + "-" + mmm + "-" + today.getFullYear();
		$('#datepicker1').val(dd);
		$('#datepicker2').val(dd); 
		
		/* $(document).ready(function() {
		    // Initialize datepickers with today's date
		    $('#datepicker1, #datepicker2').datepicker({
		        format: 'dd-M-yyyy',
		        autoclose: true
		    });

		    // Set today's date by default
		    var today = new Date();
		    var todayStr = today.getDate() + '-' + (today.getMonth() + 1) + '-' + today.getFullYear();
		    $('#datepicker1').val(todayStr);
		    $('#datepicker2').val(todayStr);
		}); */

		
	</script>
	
	<tag:autoIndex></tag:autoIndex>
</body>
</html>