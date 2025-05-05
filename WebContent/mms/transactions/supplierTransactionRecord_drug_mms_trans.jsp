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
<!-- <RJ47-12-2024> -->
<title>Drug Inventory</title>
 
<!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"> 
 -->	 
	<link href="../../hisglobal/bootstrap_4.4.1/css/bootstrap.min.css" rel="stylesheet" type="text/css">  
 
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">

<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css"> <!-- datetimepicker -->

<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>

<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script  src="../../hisglobal/js/validationBootstrap.js"></script>
<script type="text/javascript" src="../../mms/bootstrap/js/bootstrap.min.js"></script>

<link 	rel="stylesheet" href="/INVMGM/mms/flexdatalist/jquery.flexdatalist.min.css">
<script src="/INVMGM/mms/flexdatalist/jquery.flexdatalist.min.js"></script> 

<!-- EXT-JS -->
<script language="JavaScript" src="../js/supplierTransactionRecord_mms_trans.js"></script>


<style type="text/css">
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
	padding: 1% 2% 0.5% 2%;
	background-color: #fff;
	transition: 0.5s;
	box-shadow: 0.5px 0.5px 10px 2px #b0acac;
	border-radius: .35rem;
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

.table {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-weight: 400;
	color: #212529;
	width: 100%;
	margin-bottom: 1rem;
	border-collapse: separate;
	border-spacing: 5px;
}

.table td, .table th {
	padding: 0.25rem;
	vertical-align: middle;
	text-align: center;
	border-top: none;
}

/* Header styles */
.table th {
	background-color: #0056b3bf;
	color: white;
	white-space: nowrap;
}

/* Input fields consistency */
input.form-control {
	height: 34px;
	padding: 0.375rem 0.75rem;
	font-size: 14px;
}

/* Dark theme header styles */
.table .thead-dark th {
	background: none !important;
	border: none !important;
	height: 34px;
}

.gj-textbox-md {
	border: 1;
	border-bottom: 1px solid rgba(0, 0, 0, .42);
	display: block;
	font-family: Helvetica, Arial, sans-serif;
	font-size: 16px;
	line-height: 16px;
	padding: 4px 0;
	margin: 0;
	width: 100%;
	background: 0 0;
	text-align: left;
	color: rgba(0, 0, 0, .87);
}
</style>
</head>

<body onload="chechMsg();">
<!-- <body onload="preloadDrugOptions()">-->
<html:form name="supplierTransactionRecordBean" action="/transactions/SupplierTransactionRecordCNT" type="mms.transactions.controller.fb.SupplierTransactionRecordFB">
<div class="container-fluid">
	<div class="prescriptionTile"> 
		
<%-- 	<div class="errMsg" id="errMsg" style="font-size: 16px;">
			<bean:write name="supplierTransactionRecordBean"
				property="strErrMsg" />
		</div>
		<div class="warningMsg" id="warningMsg" style="font-size: 16px;">
			<bean:write name="supplierTransactionRecordBean"
				property="strWarningMsg" />
		</div>
		<div class="normalMsg" id="normalMsg" style="font-size: 16px;">
			<bean:write name="supplierTransactionRecordBean"
				property="strNormalMsg" filter="false" />
		</div> 
	--%>
		
<%-- 

<div class="alert alert-danger  alert-dismissible fade show"  id="errID" style="display: none;"><bean:write name="supplierTransactionRecordBean" property="strErrMsg" /></div>
<div class="alert alert-warning  alert-dismissible fade show" id="wrnID" style="display: none;"><bean:write name="supplierTransactionRecordBean" property="strWarningMsg" /></div>
<div class="alert alert-success  alert-dismissible fade show" id="normalMsg" style="display: none;"><bean:write name="supplierTransactionRecordBean" property="strNormalMsg" /></div>			
		
--%>

<!--TITLE_BTN START-->
		<div class="row ">
			<div class="col-sm-6" style="text-align: initial;">
				<p class="subHeaders">
					<i class="fas fa-file-alt iround"
						style="font-size: 20px; color: #28a745" title=""></i>
					&nbsp;Local Purchase
				</p>
			</div>

			<div class="col-sm-6" id="">
				<div class="legend2" id='nonPrintableLegend2'>
					<button type="button"
						class="float-right btn btn-danger mt-1 btn-circle cancelbtn"
						onclick="cancelPage('CANCELTODESK');">
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
						name="supplierTransactionRecordBean" tabindex='2'
						onclick='validate1();'>
						<i class="fa fa-download fa-beat iround" title="Save"></i>
					</button>
				</div>
			</div>
		</div>
<!--TITLE_BTN END-->

<!-- ALERT BLOCK START--> 
		<div class="errMsg" id="errMsg" style="font-size: 16px; text-align:center;">
			<bean:write name="supplierTransactionRecordBean"
				property="strErrMsg" />
			</div>
			<div class="warningMsg" id="warningMsg" style="font-size: 16px; text-align:center;">
				<bean:write name="supplierTransactionRecordBean"
					property="strWarningMsg" />
			</div>
			<div class="normalMsg" id="normalMsg" style="font-size: 16px; text-align:center;">
				<bean:write name="supplierTransactionRecordBean"
					property="strNormalMsg" filter="false" />
		</div>
<!-- ALERT BLOCK END--> 


<!-- TITLE STRIP START -->
<div class="container" style="max-width: 100%;">
	<div class="row my-1">
	    <div class="col-auto px-2">Store Name:</div>
	    <div class="col-auto px-2">
	        <label class="text-muted"><bean:write name="supplierTransactionRecordBean"
	        		 property="strStoreName" filter="false" /></label>
	    </div>
	    <div class="col-auto px-2">Item Category:</div>
	    <div class="col-auto px-2">
	        <label class="text-muted"><bean:write name="supplierTransactionRecordBean"
					property="strItemCategoryName" filter="false" /></label>
	    </div>
	</div>
<!-- TITLE STRIP END -->
	
	<hr>
<!-- HEADER START -->
	<div class="row">
		<div class="col-sm-1 py-2">
			<label>Supplier<font color="red">*</font></label>
		</div>
		<div class="col-sm-3">
		    <select class="form-control browser-default custom-select" name="strSupplierId" id="supplierDropdown" onchange="">
		        <bean:write name="supplierTransactionRecordBean"
		                    property="strSupplierCombo" filter="false" />
		    </select>
		</div>
		

		<input type="hidden" name="strUcChk" value="0" checked="checked" style="margin-left: 10px;">
		<div class="col-sm-1 py-2">
			<label>Manufacturer</label>
		</div>
		<div class="col-sm-3">
			<select class="form-control browser-default custom-select" name="strManufacturerId">
				<bean:write name="supplierTransactionRecordBean"
					property="strSuppliedByValues" filter="false" />
			</select>
		</div>

		<div class="col-sm-1 py-2">
			<label>DM No.<font color="red">*</font></label>
		</div>
		
		<div class="col-sm-3">
		<input type="text" class="form-control"
	       onkeypress="return alphanumeric(event);" 
	       onkeyup="uppercase(this)" 
	       onblur="if (this.value === '') this.value = '0';" 
	       id="strDCNoId" name="strDCNo" autocomplete="off">
		</div>
	</div>
	
	<div class="row">
		<div class="col-sm-1 py-2">
			<label>PO No.<font color="red">*</font></label>
		</div>
		<div class="col-sm-3">
			<input type="text" class="form-control" id="strLpoNoId" 
		        onblur="if (this.value === '') this.value = '0';" 
				onkeypress="return alphanumeric(event);" 
				name="strLpoNo" onkeyup="uppercase(this)" autocomplete="off">
		</div>

		<div class="col-sm-1">
			<label>PO Date</label>
		</div>
		<div class="col-sm-3">
			 <input id="datepicker1" name="strPoDate" class="form-control" type="text" value="${supplierTransactionRecordBean.strCurrentDate}"> 
		</div>

		<div class="col-sm-1 py-2">
			<label>Challan\Indent Date<font color="red">*</font></label>
		</div>
		<div class="col-sm-3">
			 <input id="datepicker2" name="strChallanDate" class="form-control" type="text"  value="${supplierTransactionRecordBean.strCurrentDate}"> 			 
		</div>
	</div>

	<div class="row">
		<div class="col-sm-1 py-2">
			<label>Bill No<font color="red">*</font></label>
		</div>
		<div class="col-sm-3">
			<input type="text" class="form-control" onkeyup="uppercase(this)" 
				onkeypress="return alphanumeric(event);" id="strInvoiceNoId" 
				onblur="if (this.value === '') this.value = '0';" 
				name="strInvoiceNo" autocomplete="off">
		</div>
		<div class="col-sm-1 py-2">
			<label>Bill Date<font color="red">*</font></label>
		</div>
		<div class="col-sm-3">
			<input id="datepicker3" name="strInvoiceDate" class="form-control" type="text" value="${supplierTransactionRecordBean.strCurrentDate}">
			
		</div>

		<input type="hidden" name="strUcChk" value="0" checked="checked" style="margin-left: 10px;">
		
		<div class="col-sm-1 py-2">
			<label>Expected Delivery Date</label>
		</div>
		<div class="col-sm-3">
			 <input id="datepicker4" name="strExpDeliveryDate" class="form-control" type="text" value="${supplierTransactionRecordBean.strCurrentDate}" > 
		</div>
	</div>

	<div class="row">
		<div class="col-sm-1 py-2">
			<label>Purchase Through<font color="red">*</font></label>
		</div>
		<div class="col-sm-11">
			<select class="form-control browser-default custom-select" name="strInstituteId" id="InstituteId">
				<bean:write name="supplierTransactionRecordBean" 
					property="strInstituteCombo" filter="false" />
			</select>
		</div>
		<div class="col-sm-6"></div>
	</div>
<!-- HEADER END -->

</div>

<!-- HIDDEN DRUG LIST COMBO START -->
<div id="itemBrandDivId" style="display: none;">
	<select name="strMultiRowItemId" id="strMultiRowItemId"
		class="comboTooMax">
		<bean:write name="supplierTransactionRecordBean" property="strItemBrandCombo" filter="false" />
	</select>
</div>
<!-- HIDDEN DRUG LIST COMBO END -->

<br>
    
<!-- TABLE START 16 COLUMNS-->
<div class="container" style="max-width: 100%;">    
<div style="overflow-x: auto; overflow-y: auto; max-height: 400px;">
    <table class="table text-uppercase" id="batchTable" 
		style="font-size: 0.85rem; width: 2400px; table-layout: auto;">
        <thead>
            <tr>
				<th style="width: 20%;">NAME</th>
				<th style="width: 10%;">BATCH NO</th>
				<!-- <th style="width: 15%;">Supplier</th>
           <td><input type="text" name="supplierName" class="form-control" value="${selectedSupplierName}" disabled /></td> 
           newRow.cells[2].querySelector("input").id = "supplierName" + rowIndex;
           -->
				<th style="width: 8%;">MFG DATE</th>
				<th style="width: 8%;">EXP DATE</th>
				<th style="width: 5%;">PACK SIZE</th>
				<th style="width: 5%;">PACKS NO</th>
				<th style="width: 8%;">RATE/UNIT</th>
				<th style="width: 8%;">QTY</th>
				<th style="width: 5%;">GST (%)</th>
				<th style="width: 8%;">RATE/UNIT(INCL TAX)</th>
				<th style="width: 5%;">ADM (%)</th>
				<th style="width: 8%;">SALE RATE/UNIT [ L ]</th>
				<th style="width: 8%;">TOTAL MARKET RATE [ K ]</th>
				<th style="width: 5%;">DIFFERENCE AMOUNT [ K-L ]</th>
				<th style="width: 8%;">TOTAL MRN [ K+M ]</th>
				<th>Actions</th>
				<!-- 
				<th style="width: 8%;">Sale Rate/Unit</th>
                <th style="width: 8%;">Difference Sign</th>
                           <th style="width: 8%;">Difference</th>
                           <th style="width: 8%;">Total MRN</th> 
                
                 <td>
			    	<select name="strDifferenceAmtSign" class="browser-default custom-select" onchange="updateTotals();">
			    		<option value="+">+</option>
			    		<option value="-">-</option>
			    	</select>
		    	</td>
		        <td><input type="text" name="strDifference" class="form-control" value="0" onchange="updateTotals();" /></td>
		        <td><input type="text" name="strTotalMRN" class="form-control" disabled /></td> 
		        
		         newRow.cells[12].querySelector("select").id = "strDifferenceAmtSign" + rowIndex;
    			 newRow.cells[13].querySelector("input").id = "strDifference" + rowIndex;
    		     newRow.cells[14].querySelector("input").id = "strTotalMRN" + rowIndex;
                -->
            	</tr>
       	</thead>
        <tbody>

        </tbody>
    </table>
</div>
</div>
<!-- TABLE END-->

<!-- HIDDEN INPUT VALUES START -->
	 <div>
		<input type="hidden" name="hmode" 
		       value="" /> 
		<input type="hidden" name="strStoreId" 
		       value="${supplierTransactionRecordBean.strStoreId}" /> 
		<input type="hidden" name="strItemCategoryId" 
		       value="${supplierTransactionRecordBean.strItemCategoryId}" /> 
	<%-- 	<input type="hidden" name="strItemCategoryNo" 
		       value="${supplierTransactionRecordBean.strItemCategoryNo}" /> 
		<input type="hidden" name="strInstituteId" 
		       value="${supplierTransactionRecordBean.strInstituteId}" /> 
		<input type="hidden" name="strRemarks" 
		       value="${supplierTransactionRecordBean.strRemarks}" /> 
		<input type="hidden" name="strCtDate" 
		       value="${supplierTransactionRecordBean.strCtDate}" /> 
		<input type="hidden" name="strDefaultCurrencyCode" 
		       value="${supplierTransactionRecordBean.strDefaultCurrencyCode}" /> 
		<input type="hidden" name="strRegFlag" 
		       value="" /> 
		<input type="hidden" name="strConfigIssueRate" 
		       value="${supplierTransactionRecordBean.strConfigIssueRate}" /> 
		<input type="hidden" name="strIssueRateConfigFlg" 
		       value="${supplierTransactionRecordBean.strIssueRateConfigFlg}" /> 
		<input type="hidden" name="strReceivedFromThirdPartyName" 
		       value="${supplierTransactionRecordBean.strInstituteName}" />  --%>
	</div>	
<!-- HIDDEN INPUT VALUES END -->		
	
		
	</div>
</div>

	<cmbPers:cmbPers />
	</html:form>


<script>
//**********************D_R DOCUMENT READY********************** 
$(document).ready(function() {
	
	addRow();
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
	$('#datepicker4').datepicker({
		modal : true,
		header : true,
		footer : true,
		format : 'dd-mmm-yyyy'
	});
	var today = new Date();
	var arr = [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug","Sep", "Oct", "Nov", "Dec" ];
	var mmm = arr[today.getMonth()];
	//var hrs = today.getHours();
	var dd = today.getDate() + "-" + mmm + "-" + today.getFullYear();
	// var dd = document.forms[0].strCtDate.value; 03-JUNE for initial 0
	$('#datepicker1').val(dd);
	$('#datepicker2').val(dd);
	$('#datepicker3').val(dd);
	$('#datepicker4').val(dd);
});

function addRow() {
    const table = document.getElementById("batchTable"); // table's ID
    let rowIndex = table.rows.length; // Get the next row index
    console.log("rowIndex : " + rowIndex );

    //const newRow = table.insertRow(); // Insert a new row at the end of the table
    const newRow = table.insertRow(rowIndex); // Insert a new row before the total row
//     <input type="text" name="strSearchDrug" class="form-control" placeholder="Enter at least 3 characters" onfocus="drugNameFun(this);" onmouseenter="drugNameFun(this);" onblur="drugNameFun(this);">

  newRow.innerHTML = `
	    <td>
	        <input type="text" name="strSearchDrug" class="form-control" 
	        placeholder="Enter at least 3 characters" onfocus="drugNameFun(this);">
	    	<input type="hidden" name="strBrandIdTableArray" />
	        <input type="hidden" name="strItemsIdTableArray" />
        </td>
        <td><input type="text" name="strBatchNo" class="form-control" onkeyup="uppercase(this)" /></td>
        <td><input type="text" name="mfgDate" class="form-control" value="${supplierTransactionRecordBean.strCurrentDate}"/></td>
        <td><input type="text" name="expDate" class="form-control" value="${supplierTransactionRecordBean.strCurrentDate}" /></td>

        <td><input type="text" name="strPackSize" class="form-control" onkeypress="return validateData(event,5);"  onchange="calculateQty(this); updateDifference(this); calculateRates(this); updateTotals();" value="0"/></td>
        <td><input type="text" name="strPacksNo" class="form-control" onkeypress="return validateData(event,5);"  onchange="calculateQty(this); updateDifference(this); calculateRates(this); updateTotals();" value="0"/></td>

        <td><input type="text" name="strPuRate" class="form-control" onkeypress="return validateData(event,7);" oninput="calculateRates(this); updateTotals();" value="0" /></td>
        <td><input type="text" name="strPurQty" class="form-control" value="0" disabled/></td>
        <td><input type="text" name="strGst" class="form-control" 	 onkeypress="return validateData(event,7);" oninput="calculateRates(this); updateTotals();"  value="0"/></td>
        <td><input type="text" name="strPuRateWitTax" class="form-control" value="0"  disabled /></td>
        <td><input type="text" name="strAdm" class="form-control" onkeypress="return validateData(event,7);" oninput="calculateRates(this); updateTotals();" value="0" /></td>
        <td><input type="text" name="strCosttoPat" class="form-control" value="0" disabled /></td>
        
        <td><input type="text" name="strMarkCosttoPat" class="form-control" value="0" oninput="updateDifference(this); calculateRates(this);" /></td>
        <td><input type="text" name="strDifference" class="form-control" value="0" oninput="updateTotals();" disabled/></td>
        <td><input type="text" name="strTotalMRN" class="form-control" value="0" disabled /></td>

        <td>
            <button type="button" class="btn btn-success" onclick="addRow()" style="font-size: 0.6rem; padding: 0.25rem 0.5rem;">
                <i class="fa fa-plus"></i>
            </button>
            <button type="button" class="btn btn-danger" onclick="removeRow(this)" style="font-size: 0.6rem; padding: 0.25rem 0.5rem;">
                <i class="fa fa-minus"></i> 
            </button>
            </td> `;
            
    
    const inputs = newRow.cells[0].querySelectorAll("input");
    inputs[0].id = "strSearchDrug" 		  + rowIndex; // Search Drug field
    inputs[1].id = "strBrandIdTableArray" + rowIndex; // Hidden field for Brand ID
    inputs[2].id = "strItemsIdTableArray" + rowIndex; // Hidden field for Item ID
    
    newRow.cells[1].querySelector("input").id = "strBatchNo" 		+ rowIndex;
    
    newRow.cells[2].querySelector("input").id = "mfgDate" 			+ rowIndex;
    newRow.cells[3].querySelector("input").id = "expDate" 			+ rowIndex;
    
    newRow.cells[4].querySelector("input").id = "strPackSize" 		+ rowIndex;
    newRow.cells[5].querySelector("input").id = "strPacksNo" 		+ rowIndex;
    
    newRow.cells[6].querySelector("input").id = "strPuRate" 		+ rowIndex;
    newRow.cells[7].querySelector("input").id = "strPurQty" 		+ rowIndex;
    newRow.cells[8].querySelector("input").id = "strGst" 			+ rowIndex;
    newRow.cells[9].querySelector("input").id = "strPuRateWitTax" 	+ rowIndex;
    newRow.cells[10].querySelector("input").id = "strAdm" 			+ rowIndex;
	newRow.cells[11].querySelector("input").id = "strCosttoPat" 	+ rowIndex;

	newRow.cells[12].querySelector("input").id = "strMarkCosttoPat" + rowIndex;
	newRow.cells[13].querySelector("input").id = "strDifference" 	+ rowIndex;
	newRow.cells[14].querySelector("input").id = "strTotalMRN" 		+ rowIndex;

    initializeDatepickers_exp_mfgdate(rowIndex);
    //updateSupplierInAllRows();
  
	setTimeout(() => newRow.cells[0].querySelector("input").focus(), 0);
	//	this is alternative for setTimeout //requestAnimationFrame(() => newRow.cells[0].querySelector("input").focus());

	
	// Ensure the total row exists or add it
    ensureTotalRow(table);
    updateTotals();

}

function removeRow(button) {
    const tableBody = document.querySelector("#batchTable tbody");
    const rows = tableBody.querySelectorAll("tr");

    // Find the row to be removed and determine its index
    const row = button.closest('tr');
    const rowIndex = Array.from(rows).indexOf(row) + 1; // 1-based index for alerting
	console.log("removeRow :: rowIndex"+rowIndex)
    if (row) {
        row.remove();
        alert("1 Row Removed");
        updateTotals();
    } else {
        alert("Row not found.");
    }
}

function ensureTotalRow(table) {
    const rows = Array.from(table.rows);
    const totalRow = rows.find(row => row.getAttribute("data-total-row") === "true");

    // Remove the existing total row if it exists
    if (totalRow) {
        table.deleteRow(totalRow.rowIndex);
    }

    // Add a new total row at the bottom
    const newTotalRow = table.insertRow();
    newTotalRow.setAttribute("data-total-row", "true");
    newTotalRow.innerHTML = `
        <td colspan="12" class="text-right font-weight-bold">Total:</td>
        <td><input type="text" id="totalMarkCosttoPat" name="totalMarkCosttoPat" 	class="form-control" value="0" disabled /></td> 
        <td><input type="text" id="totalDifference"    name="totalDifference" 		class="form-control" value="0" disabled /></td>
        <td><input type="text" id="totalMRN"    	   name="totalMRN" 				class="form-control" value="0" disabled /></td> 
        `;
}

function updateTotals() {
    const table = document.getElementById("batchTable");
    const rows = table.rows;

    let totalMRN = 0;
    let totalDifference = 0;
    let totalMarkCosttoPatient = 0;

    // Loop through rows to sum values and apply difference calculations
    for (let i = 0; i < rows.length; i++) {
        if (rows[i].getAttribute("data-total-row") === "true") {
            continue; // Skip the total row
        }
        const markCosttoPatInput = rows[i].querySelector("input[name='strMarkCosttoPat']");
        const differenceInput = rows[i].querySelector("input[name='strDifference']");
        const totalMRNInput = rows[i].querySelector("input[name='strTotalMRN']");

        // Parse the input values or default to 0
        let markCosttoPatValue = parseFloat(markCosttoPatInput?.value) || 0;
        let differenceValue = parseFloat(differenceInput?.value) || 0;
        let rowMRN = parseFloat(totalMRNInput?.value) || 0;
       
    	totalMarkCosttoPatient += markCosttoPatValue;
    	totalDifference += differenceValue;
    	totalMRN += rowMRN;
    }

    // Update total MRN in the total row
    document.getElementById("totalMarkCosttoPat").value = totalMarkCosttoPatient.toFixed(2);
    document.getElementById("totalDifference").value = totalDifference.toFixed(2);
    document.getElementById("totalMRN").value = totalMRN.toFixed(2);

}

function updateDifference(inputElement) {
    const currentRow = inputElement.closest("tr");
    
    const totalMRNInput = parseFloat(currentRow.querySelector("input[name='strTotalMRN']").value) || 0;
    const totalMarketCostInput = parseFloat(currentRow.querySelector("input[name='strMarkCosttoPat']").value) || 0;
    const differenceField = currentRow.querySelector("input[name='strDifference']");

    // Check if the total market cost is greater than the total MRN
    if (totalMarketCostInput > totalMRNInput) {
        // Calculate the difference
        const difference = totalMarketCostInput - totalMRNInput;
        // Update the difference field
        differenceField.value = difference.toFixed(2);
    } else {
        // If the market cost is not greater, reset the difference field to 0.00
        differenceField.value = '0.00';
    }
}

function calculateQty(inputElement) {
    const currentRow = inputElement.closest("tr");
    
    // Get the input fields for pack size and pack number
    const strPackSizeInput = currentRow.querySelector("input[name='strPackSize']");
    const strPackNoInput = currentRow.querySelector("input[name='strPacksNo']");
    const qtyField = currentRow.querySelector("input[name='strPurQty']");

    // Parse the values or default to 0
    const packSize = parseFloat(strPackSizeInput.value) || 0;
    const packNo = parseFloat(strPackNoInput.value) || 0;

    // Calculate the total quantity
    const totalQty = packSize * packNo;

    // Update the quantity field
    qtyField.value = totalQty.toFixed(2);
}


function calculateRates(inputElement) {
    const currentRow = inputElement.closest('tr');
    
    const rateInput = currentRow.querySelector("input[name='strPuRate']");
    const qtyInput = currentRow.querySelector("input[name='strPurQty']");
    const gstInput = currentRow.querySelector("input[name='strGst']");
    const adminInput = currentRow.querySelector("input[name='strAdm']");
    const totalMRNInput = currentRow.querySelector("input[name='strTotalMRN']");
    const rateWithTaxInput = currentRow.querySelector("input[name='strPuRateWitTax']");
    const costToPatientInput = currentRow.querySelector("input[name='strCosttoPat']");
    const markCostToPatInput = currentRow.querySelector("input[name='strMarkCosttoPat']");

    // Parse the input values or default to 0
    const rate = parseFloat(rateInput.value) || 0;
    const quantity = parseFloat(qtyInput.value) || 0;
    const gstPercentage = parseFloat(gstInput.value) || 0;
    let adminPercentage = parseFloat(adminInput.value) || 0;

    let formattedRateWithTax = "0";
    let formattedCostToPatient = "0";
    let formattedTotalMRN = "0";

    if (rate > 0) {
        // Calculate rate with GST
        const rateWithTax = rate * (1 + gstPercentage / 100);
        formattedRateWithTax = rateWithTax.toFixed(2);
        console.log("Rate/Unit (incl. Tax): " + formattedRateWithTax);

        // Calculate the admin charge and cap it at 1000
        let adminCharge = (adminPercentage * rateWithTax) / 100;
        if (adminCharge > 1000) {
            adminCharge = 1000;
        }
        console.log("Capped Admin Charge: " + adminCharge.toFixed(2));

        // Calculate cost to patient
        const costToPatient = rateWithTax + adminCharge;
        formattedCostToPatient = costToPatient.toFixed(2);
        console.log("Cost to Patient: " + formattedCostToPatient);

        // Calculate total MRN
        const totalMRN = rateWithTax * quantity;
        formattedTotalMRN = totalMRN.toFixed(2);
    }

    // Update the calculated fields
    rateWithTaxInput.value = formattedRateWithTax;
    costToPatientInput.value = formattedCostToPatient;
    totalMRNInput.value = formattedTotalMRN;

    // Update totals for the table or form
    updateTotals();
}

function initializeDatepickers_exp_mfgdate(rowIndex) {
    // Manufacturing Date
    $('#mfgDate' + rowIndex).datepicker({
        modal: true,
        header: true,
        footer: true,
        format: 'dd-mmm-yyyy'
    });

    // Expiry Date
    $('#expDate' + rowIndex).datepicker({
        modal: true,
        header: true,
        footer: true,
        format: 'dd-mmm-yyyy'
    });

    // Set default date (current date)
    let today = new Date();
    let arr = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];

    // One year back from the current year
    let oneYearBack = new Date(today.getFullYear() - 1, today.getMonth(), today.getDate());
    let formattedDate_before_ctdt = oneYearBack.getDate() + "-" + arr[oneYearBack.getMonth()] + "-" + oneYearBack.getFullYear();

    // Two years ahead from the current year
    let twoYearAhead = new Date(today.getFullYear() + 2, today.getMonth(), today.getDate());
    let formattedDate_ahead_ctdt = twoYearAhead.getDate() + "-" + arr[twoYearAhead.getMonth()] + "-" + twoYearAhead.getFullYear();

    // Set values in the input fields
    $('#mfgDate' + rowIndex).val(formattedDate_before_ctdt);
    $('#expDate' + rowIndex).val(formattedDate_ahead_ctdt);
}


function uppercase(input) {
    input.value = input.value.toUpperCase();
}
function alphanumeric(e) { 
	var k;
	document.all ? k = e.keyCode : k = e.which;
	//console.log(e.keyCode +'   ===  '+e.which);
	return ((k > 64 && k < 91) || (k > 96 && k < 123) || k == 8 || k == 32 || (k >= 48 && k <= 57) || k == 45 || k == 47);
}

/* 
function calculateRates(inputElement) {
    const currentRow = inputElement.closest('tr');
    
    const rateInput = currentRow.querySelector("input[name='strPuRate']");
    const qtyInput = currentRow.querySelector("input[name='strPurQty']");
    const gstInput = currentRow.querySelector("input[name='strGst']");
    const adminInput = currentRow.querySelector("input[name='strAdm']");
    const totalMRNInput = currentRow.querySelector("input[name='strTotalMRN']");
    const rateWithTaxInput = currentRow.querySelector("input[name='strPuRateWitTax']");
    const costToPatientInput = currentRow.querySelector("input[name='strCosttoPat']");

    // Parse the input values or default to 0
    const rate = parseFloat(rateInput.value) || 0;
    const quantity = parseFloat(qtyInput.value) || 0;
    const gstPercentage = parseFloat(gstInput.value) || 0;
    const adminPercentage = parseFloat(adminInput.value) || 0;

    // Alert if quantity is zero or negative
    if (quantity <= 0) {
        alert("Quantity should be greater than 0.");
        qtyInput.focus(); // Focus on the quantity input field for correction
        return; // Exit the function
    }

    let formattedRateWithTax = "0";
    let formattedCostToPatient = "0";
    let formattedTotalMRN = "0";

    if (rate > 0) {
        const rateWithTax = rate * (1 + gstPercentage / 100);
        formattedRateWithTax = rateWithTax.toFixed(2);

        console.log("Rate/Unit (incl. Tax): " + formattedRateWithTax);

        const costToPatient = rateWithTax * (1 + adminPercentage / 100);
        formattedCostToPatient = costToPatient.toFixed(2);

        console.log("Cost to Patient: " + formattedCostToPatient);

        const totalMRN = costToPatient * quantity;
        formattedTotalMRN = totalMRN.toFixed(2);
    }

    // Update the calculated fields
    rateWithTaxInput.value = formattedRateWithTax;
    costToPatientInput.value = formattedCostToPatient;
    totalMRNInput.value = formattedTotalMRN;

    // Update totals for the table or form
    updateTotals();
}
 */
 
/*
function ensureTotalRow(table) {
    const rows = Array.from(table.rows);
    const totalRow = rows.find(row => row.getAttribute("data-total-row") === "true");

    // Remove the existing total row if it exists
    if (totalRow) {
        table.deleteRow(totalRow.rowIndex);
    }

    // Add a new total row at the bottom
    const newTotalRow = table.insertRow();
    newTotalRow.setAttribute("data-total-row", "true");
    newTotalRow.innerHTML = `
        <td colspan="13" 							class="text-right font-weight-bold">Total:</td>
        <td><input type="text" id="totalDifference" class="form-control" disabled /></td>
        <td><input type="text" id="totalMRN" 		class="form-control" disabled /></td> `;
}

function updateTotals() {
    const table = document.getElementById("batchTable");
    const rows = table.rows;

    let totalMRN = 0;
    let totalDifference = 0;

    // Loop through rows to sum values and apply difference calculations
    for (let i = 0; i < rows.length; i++) {
        if (rows[i].getAttribute("data-total-row") === "true") {
            continue; // Skip the total row
        }

        const totalMRNInput = rows[i].querySelector("input[name='strTotalMRN']");
        const differenceInput = rows[i].querySelector("input[name='strDifference']");
        const differenceSignSelect = rows[i].querySelector("select[name='strDifferenceAmtSign']");
        
        let rowMRN = parseFloat(totalMRNInput?.value) || 0;
        let differenceValue = parseFloat(differenceInput?.value) || 0;

        // Apply the difference based on the selected sign
        if (differenceSignSelect) {
            const sign = differenceSignSelect.value;
            if (sign === "+") {
                rowMRN += differenceValue;
            } else if (sign === "-") {
                rowMRN -= differenceValue;
            }
        }

    	totalDifference += differenceValue;
        totalMRN += rowMRN;
    }

    // Update total MRN in the total row
    document.getElementById("totalMRN").value = totalMRN.toFixed(2);
    document.getElementById("totalDifference").value = totalDifference.toFixed(2);
}
*/

/*
function updateTotals() {
    const table = document.getElementById("batchTable");
    const rows = table.rows;
    let totalPuRateWithTax = 0;
    let totalCostToPatient = 0;
    let totalMRN = 0;


    // Loop through rows to sum values
    for (let i = 0; i < rows.length; i++) {
        if (rows[i].getAttribute("data-total-row") === "true") {
            continue; // Skip the total row
        }

        const puRateWithTaxInput = rows[i].querySelector("input[name='strPuRateWitTax']");
        const costToPatientInput = rows[i].querySelector("input[name='strCosttoPat']");
        const totalMRNInput      = rows[i].querySelector("input[name='strTotalMRN']");

        totalPuRateWithTax += parseFloat(puRateWithTaxInput?.value) || 0;
        totalCostToPatient += parseFloat(costToPatientInput?.value) || 0;
        totalMRN 		   += parseFloat(totalMRNInput?.value) || 0;
    }
    // Update total inputs
    document.getElementById("totalPuRateWithTax").value = totalPuRateWithTax.toFixed(2);
    document.getElementById("totalCostToPatient").value = totalCostToPatient.toFixed(2);
    document.getElementById("totalMRN").value = totalMRN.toFixed(2);
}
*/


/* let selectedSupplierName = "";

function updateSupplierName(selectElement) {
    selectedSupplierName = selectElement.options[selectElement.selectedIndex].text;
    
    // Update all existing rows with the new supplier name
    updateSupplierInAllRows();
} */



/* function updateSupplierInAllRows() {
    const table = document.getElementById("batchTable");
    for (let i = 1; i < table.rows.length; i++) {
        let supplierField = table.rows[i].cells[2].querySelector("input[name='supplierName']");
        if (supplierField) {
            supplierField.value = selectedSupplierName;
        }
    }
} */

/* function ensureTotalRow(table) {
// Check if the total row already exists
const lastRow = table.rows[table.rows.length - 1];
if (lastRow && lastRow.getAttribute("data-total-row") === "true") {
    return;
}

// Add the total row
const totalRow = table.insertRow();
totalRow.setAttribute("data-total-row", "true");
totalRow.innerHTML = `
    <td colspan="8" class="text-right font-weight-bold">Total:</td>
    <td><input type="text" id="totalPuRateWithTax" class="form-control" disabled /></td>
    <td></td>
    <td><input type="text" id="totalCostToPatient" class="form-control" disabled /></td>
    <td></td>`;
} */

// original
/*
function calculateRates_pu(inputElement) {
    const currentRow = inputElement.closest('tr');
    
    const rateInput = currentRow.querySelector("input[name='strPuRate']");
    const qtyInput = currentRow.querySelector("input[name='strPurQty']");
    const gstInput = currentRow.querySelector("input[name='strGst']");
    const adminInput = currentRow.querySelector("input[name='strAdm']");
    
    const rate  = parseFloat(rateInput.value) || 0; // Default to 0 if not a number
    const quantity   = parseFloat(qtyInput.value) || 0; // Default to 0 if not a number
    const gstPercentage = parseFloat(gstInput.value) || 0; // Default to 0 if not a number
    const adminPercentage = parseFloat(adminInput.value) || 0; // Default to 0 if not a number

 // Alert if quantity is zero or negative
    if (quantity <= 0) {
        alert("Quantity should be greater than 0.");
        qtyInput.focus(); // Focus on the quantity input field for correction
        return; // Exit the function, as calculation is not possible
    }
    
    let formattedRateWithTax = "0"; // Default value
    let formattedCostToPatient = "0"; // Default value

    if (rate > 0) {
        const rateWithTax = rate * (1 + gstPercentage / 100) * quantity;
        formattedRateWithTax = (rateWithTax).toFixed(2); // Multiply by quantity and format to 2 decimal places
	       
	       console.log("Rate/Unit (incl. Tax): " + rateWithTax.toFixed(2));
	       console.log("Total Rate (incl. Tax, Quantity Applied): " + formattedRateWithTax);
        
        const costToPatient = rateWithTax * (1 + adminPercentage / 100);
        formattedCostToPatient = costToPatient.toFixed(2); // Format to 2 decimal places
        console.log("Cost to Patient: " + formattedCostToPatient);
    }

    const rateWithTaxInput = currentRow.querySelector("input[name='strPuRateWitTax']");
    const costToPatientInput = currentRow.querySelector("input[name='strCosttoPat']");
    
    rateWithTaxInput.value = formattedRateWithTax;
    costToPatientInput.value = formattedCostToPatient;

    updateTotals();

}
*/




/* function removeRow(button) {
     const tableBody = document.querySelector("#batchTable tbody"); // Get the table body
     const rows = tableBody.querySelectorAll("tr");
    
	// Find the row to be removed and determine its index
	const row = button.closest('tr');
    const rowIndex = Array.from(rows).indexOf(row) + 1; // +1 for 1-based indexing

    row.remove();

    alert("1 Row Removed" );
} */

//Global array to store selected item values
/* 
function removeRow(button) {
    // Get the table row containing the "Remove" button
    const row = button.closest('tr');
    const table = document.getElementById("batchTable");
    const rows = table.getElementsByTagName("tr");

    // Find the index of the row
    const rowIndex = Array.from(rows).indexOf(row) + 1; // +1 to convert to 1-based index

    // Get the item brand ID and item ID from the current row
    const itemBrandInput = row.querySelector('input[name="strBrandIdTableArray"]');
    const itemIdInput = row.querySelector('input[name="strItemsIdTableArray"]');

    const itemBrand = itemBrandInput ? itemBrandInput.value : null;
    const itemId = itemIdInput ? itemIdInput.value : null;

    // Remove the item from the selectedValuesArray
    removeItemFromArray(itemBrand, itemId);

    // Remove the row from the table
    row.remove();

    // Display a confirmation message
    alert("1 Row Removed");
} */

/* 
function removeItemFromArray(itemBrand, itemId) {
    // Filter out the item that matches the given itemBrand and itemId from selectedValuesArray
    selectedValuesArray = selectedValuesArray.filter(item => {
        const parts = item.split("$");
        const brandId = parts[0]; // Brand ID from the array item
        const id = parts[1]; // Item ID from the array item

        // Keep items that do not match the current itemBrand and itemId
        return !(brandId === itemBrand && id === itemId);
    });

    // Update the hidden inputs on the page with the new array values
    updateHiddenInputs();
}

function updateHiddenInputs() {
    // Extract the updated brandId and itemId from selectedValuesArray
    const brandIdArray = selectedValuesArray.map(item => item.split("$")[0]);
    const itemIdArray = selectedValuesArray.map(item => item.split("$")[1]);

    // Find and update the hidden input elements for strBrandId and strItemsId
    const brandIdInput = document.getElementById('strBrandId');
    const itemIdInput = document.getElementById('strItemsId');

    if (brandIdInput) {
        brandIdInput.value = JSON.stringify(brandIdArray);
    }
    if (itemIdInput) {
        itemIdInput.value = JSON.stringify(itemIdArray);
    } 

}*/
</script>

<!-- <RJ47-12-2024> -->
</body>
</html>








