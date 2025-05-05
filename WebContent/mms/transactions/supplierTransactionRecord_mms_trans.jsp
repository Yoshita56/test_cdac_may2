<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<html>
<head>
<meta charset=UTF-8">
<title></title>
<!-- <RJ47-12-2024> -->

	<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">
	<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
	<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
	<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
	<link href="../../hisglobal/css/newlayout.css" rel="stylesheet" type="text/css">
	<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
	
	<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet">
	<link href="../css/master.css" rel="stylesheet" type="text/css">
	<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
	
	<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
	<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
	
	<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script> 
	<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
	<script language="Javascript" src="../../hisglobal/js/util.js"></script>
	<script language="Javascript" src="../js/mms.js"></script>
	<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
	<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
	<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
	<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
	
		
	<script language="Javascript" src="../js/searchItems_util.js"></script>
	<script language="Javascript" src="../js/stockDetails_util.js"></script>
	<script language="Javascript" src="../js/issueDetails_util.js"></script>
    <script language="Javascript" src="../js/IssueDetailsUtil.js"></script>
	
	
	<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
	<script language="Javascript" src="../js/ValidationCommonn.js"></script>
	
	<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
	<script  src="../../hisglobal/js/validationBootstrap.js"></script>
	
	<link rel="stylesheet" href="../../hisglobal/DataTables/css/jquery.dataTables.min.css">
	<script src="../../hisglobal/DataTables/js/jquery.dataTables.min.js"></script>
	

<!-- EXT JS -->
<script language="JavaScript" src="../js/supplierTransactionRecord_mms_trans.js"></script>

<style type="text/css">
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
	.highlight-icon {
	  	color: #1400ff; 
	}
	
	.highlight-icon:hover {
	 	color: #f00; 
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
	/* .popUpDiv{
	    display: block;
	  	font-size: 12px !important;
	  	top: 20%;
	  	left: 25%;
	  	background-color:white;
	}  */
	 .invoice-table-header{
	  width: 100%;
	  font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	  font-weight: 400;
	  font-size: 14px;
	  color: #212529;
	  border-collapse: collapse;
	  margin-botton:none;
	  border-spacing: none;
	  
	}
	.invoice-table-header-dtls {
	  font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	  font-weight: 400;
	  color: #212529;
	  width: 100%;
	  border-collapse: separate;
  	}
	.invoice-table {
	    width: 100%;
	    border-collapse: collapse;
	    font-family: Arial, sans-serif;
	    font-size: 12px;
	}
	
	.invoice-table th, .invoice-table td {
	    border: 1px solid #ccc; /* Border for the table cells */
	    padding: 8px;
	    text-align: center;
	}
	
	.invoice-table th {
	    background-color: #f2f2f2;
	    font-weight: bold;
	}
	
	.invoice-table td {
	    text-align: left;
	}
	
	.invoice-table tr:nth-child(even) {
	    background-color: #f9f9f9;
	}
	
	/* Remove borders from other tables if any */
	.no-border-table th, .no-border-table td {
	    border: none;
	}

</style>

<script>
 
 function printData() {
	    document.getElementById("printImg").style.display = "none"; 
	    
	    const contentToPrint = document.getElementById("issueDtlsDivId").cloneNode(true);
	    const newWin = window.open('', '', 'width=700,height=700,scrollbars=yes');
	    newWin.document.write('<html><head>');
	    
	    newWin.document.write('<style type="text/css">');
		    newWin.document.write('body, .invoice-table {');
		    newWin.document.write('  font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;');
		    newWin.document.write('  font-size: 11px;'); // Adjust font size for readability
		    newWin.document.write('  margin: 0;'); // Remove margins
		    newWin.document.write('  padding: 0;'); // Remove padding
		    newWin.document.write('  line-height: 1;'); // Remove line spacing 
		    newWin.document.write('  box-sizing: border-box;'); // Ensure full utilization of page width/height
		    newWin.document.write('}');
	
		    // A4 page layout styling
		    newWin.document.write('@media print {');
		    newWin.document.write('  @page {');
		    newWin.document.write('    size: A4 portrait;'); // Ensure A4 landscape
		    newWin.document.write('    margin: 6mm 5mm;'); 
		    newWin.document.write('  }');
		    newWin.document.write('  body {');
		    newWin.document.write('    margin: 0;'); 
		    newWin.document.write('    padding: 0;');
		    newWin.document.write('  }');
		    
		    newWin.document.write('  .invoice-table-header-dtls {');
		    newWin.document.write('    margin: 0 auto;');
		    newWin.document.write('    font-size: 12px;');
		    newWin.document.write('  }');
		    
		    newWin.document.write('  .invoice-table {');
		    newWin.document.write('    width: 100%;');
		    newWin.document.write('    table-layout: auto;'); 
		    newWin.document.write('    border-collapse: collapse;');
		    newWin.document.write('    border: 1px solid black;');
		    newWin.document.write('    page-break-inside: auto;'); 
		    newWin.document.write('  }');
		    
		    newWin.document.write('  .invoice-table th, .invoice-table td {');
		    newWin.document.write('    padding: 7px;'); 
		    newWin.document.write('    text-align: center;');
		    newWin.document.write('    word-wrap: break-word;'); 
		    newWin.document.write('    border: 1px solid black;');
		    newWin.document.write('    font-size: 11px;'); 
		    newWin.document.write('  }');
		    
		    newWin.document.write('  .invoice-table tr {');
		    newWin.document.write('    page-break-inside: avoid;'); 
		    newWin.document.write('  }');
	    newWin.document.write('</style>');
	    
	    newWin.document.write('</head><body>');
	    newWin.document.write(contentToPrint.outerHTML);
	    newWin.document.write('</body></html>');
	    newWin.document.close();
	    
	    newWin.onload = function () {
	        newWin.print();
	        newWin.close();
	        document.getElementById("printImg").style.display = "block"; 
	    };
	}

function printData_org_old() 
{
	document.getElementById("printImg").style.display="none"; 
    const contentToPrint = document.getElementById("issueDtlsDivId").cloneNode(true);
    const newWin = window.open('', '', 'width=700,height=700,scrollbars=yes');
    newWin.document.write('<html><head>');
    newWin.document.write('<style type="text/css">');
    newWin.document.write('.hidecontrol { display: none; }');
    newWin.document.write('@media print {');
//    newWin.document.write('  #toolbar { display: none; }');
//    newWin.document.write('  body { margin: 0; padding: 0; }');
//    newWin.document.write('  @page { margin: 4mm 3mm; size: A4 portrait; }');
//    newWin.document.write('  table { table-layout: fixed; width: 100%; }');
    newWin.document.write('  table {border-collapse: collapse; }');
//    newWin.document.write('  table td { word-wrap: break-word; font-size: 12px; }');

    // Define page break rules for the repeat-table class
//     newWin.document.write('.repeat-table { page-break-before: always; }');

    newWin.document.write('}');
    newWin.document.write('</style>');
    
    newWin.document.write('</head><body>');
    newWin.document.write(contentToPrint.outerHTML);
    newWin.document.write('</body></html>');
    newWin.document.close();
    newWin.onload = function () {
        newWin.print();
        newWin.close();
        document.getElementById("printImg").style.display="block"; 
    };
}

function hideIssuePopup(){
	document.getElementById("issueDtlsDivId").innerHTML = "";
	hide_popup('popUpDiv');
}
</script>

</head>
<body >
<!-- <body onload="getDataTableOnSelection();">   -->
<html:form name="supplierTransactionRecordBean" action="/transactions/SupplierTransactionRecordCNT" type="mms.transactions.controller.fb.SupplierTransactionRecordFB">
	<div class="prescriptionTile">
		 
	
	<!--TITLE_BTN-->
			<div class="row ">
				<div class="col-sm-6" style="text-align: initial;">
					<p class="subHeaders">
						<i class="fas fa-file-alt iround"
							style="font-size: 20px; color: #28a745" title=""></i>
						&nbsp;Supplier Receipt 
					</p>
				</div>
						
				<div class="col-sm-6" id="">
					<div class="legend2" id='nonPrintableLegend2'>
						<button id="cancelforreceivepage" style="display:block;" type="button" class="float-right btn btn-danger mt-1 btn-circle cancelbtn" 
							onclick="cancelFunc();">
							<i class="fas fa-times iround" title="Cancel"></i>
						</button>
						
						<!-- <button id='pbtn' type="button" class="float-right btn btn-primary mt-1 btn-circle printbtn" property="strReceivedItemViewMode" name="supplierTransactionRecordBean" title="View" value="3" 
							onclick="changeViewMode(this);">
							<i class="fas fa-eye iround"  title="View"></i>
						</button> -->
						
						<button type="button" id="saveid" class="float-right btn btn-success mt-1 btn-circle savebtn" tabindex='2' 
							onclick='return getInventoryDtls();'>
							<i class="fas fa-arrow-right iround" title="Click Here To Generate"></i>
						</button>
						
					</div>
				</div>
			</div>
	<!--TITLE_BTN-->
	
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
	
			<div class="row">
				<div class="col-sm-2 py-2" style='text-align: right;'>
					<label><font color="red">*</font>Store Name:</label>
				</div>
				
				<div class="col-sm-3" style='margin-right: 6%;'>
					<select name="strStoreId" class='custom-select'>
						<bean:write name="supplierTransactionRecordBean" property="strStoreNameCombo" filter="false" />
					</select> 
				</div>

				<div class="col-sm-2 py-2" style='text-align: right;'>
					<label><font color="red">*</font>Category :</label>
				</div>
				
				<div class="col-sm-3">
					<div id="itemCategoryDivId">
						<select name="strItemCategoryId" class='custom-select' onchange="getDataTableOnSelection(this);"> 
							<bean:write name="supplierTransactionRecordBean" property="strItemCategoryCombo" filter="false" />
						</select>
					</div>
			
				</div>
			</div>
	</div>
	
	<div class="prescriptionTile" >
			<div style="display: flex; align-items: center; background-color: #d1d1ca52; padding: 0px; border-radius: 8px;">
				&nbsp;<p class="subHeaders"
					style="font-size: 24px; font-weight: bold; margin: 0;">
					Previous Records Display</p>&nbsp;
				<i class="fas fa-angle-double-right"
					style="font-size: 20px; color: #8a877d; margin-right: 8px;"></i>
			</div>
			
			<table class="table" id="data-table" ></table> 
	</div>
	
	  <div id="blanket" style="display:none;"></div>
	   <div class="popUpDiv" id="popUpDiv" style="display:none;font-size:12px !important;">
		   <!-- <table>
		     <tr>
		      <td> -->
		          <div class='bg-white' id="issueDtlsDivId"></div> 
		     <!--   </td>
		     </tr>
		   </table> -->
	   </div>
<br>

<input type="hidden" name="hmode"/>

<input type="hidden" name="strStoreName" value=""/>
<input type="hidden" name="strItemCategoryName" value=""/>
<input type="hidden" name="strItemCategoryHiddenId" value=""/>

<input type="hidden" name="strStatus" value=""/>
<input type="hidden"  name="strConfigIssueRate"  value="">
<input type="hidden"  name="strPkey"  value="">
<input type="hidden" name="strCurrentDate" value="${supplierTransactionRecordBean.strCurrentDate}" />

</html:form>


<script type="text/javascript">
/* $(document).ready(function() {
    $('#data-table').DataTable();
}); */

$('.datepicker').each(function(){
    $(this).datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
});
var today=new Date();
var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
var mmm=arr[today.getMonth()];
var hrs=today.getHours();
//var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();

var dd = document.fomrs[0].strCtDate.value;
$('.datepicker').val(dd);


function controlToMainPage()
{	    
	document.forms[0].hmode.value="unspecified";
	document.forms[0].submit();
}
</script>


<!-- <RJ47-12-2024> -->
</body>
</html>