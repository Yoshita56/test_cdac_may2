<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>
<%@ taglib uri="/WEB-INF/patientDtl.tld" prefix="pDtl"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>

<html>
<head>
<meta charset="UTF-8">
<title>Template Design</title>

<!-- JS -->
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newlayout.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">

<script src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">

<script type="text/javascript"  src="../../hisglobal/js/validation.js" ></script>
<script type="text/javascript"  src="../js/ValidationCommonn.js" ></script>
<script type="text/javascript"  src="../../hisglobal/js/util.js" ></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<!-- EXT JS -->

<script type="text/javascript"  src="../js/patientReturn.js"></script>

<style>
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
.legendbtn {
  position: absolute;
  top: 0em;
  right: 44px;
  line-height: 1.2em;
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
.table th {
	background-color: #0056b3bf;
	color: white;
	white-space: nowrap;
}
.invoice-table thead th{
	background-color: #0056b3bf;
	color: white;
	white-space: nowrap;
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

function hideIssuePopup(){
	document.getElementById("issueDtlsDivId").innerHTML = "";
	hide_popup('popUpDiv');
}
</script>

</head>

<!-- <body onload="checkMsg();"> -->
<body onload="document.forms[0].strCrNo.focus();getReport();">
<!-- <body onload="getReport();"> -->

<html:form name="patientReturnBean" action="/transactions/PatientReturnTransCNT" type="mms.transactions.controller.fb.PatientReturnTransFB">

		<fieldset>
			<legend class='legendHeader' id='nonPrintableLegend'>Return From Patient</legend>
<!--TITLE_BTN-->	
			<div class="legendbtn" id=''>
				<button id="cancelButton" type="button"
					class="btn btn-outline-danger mt-1 btn-circle cancelbtn"
					onclick="cancelFunc();" title="Cancel">
					<div>
						<i class="fa fa-times iround" title="Cancel"></i>
					</div>
				</button>
				<button  type="button"
					class="btn btn-primary mt-1 btn-circle" 
					onclick="transferToViewPage();" title="Click Here To View Previous Issue">
					<div>
						<i class="fas fa-eye iround"
							title="Click Here To View Previous Issue"></i>
					</div>
				</button> 
			</div>
<!--TITLE_BTN-->	

			<div id="errID"
				class="alert alert-danger alert-dismissible fade show"
				style="display: none;">
				<bean:write name="patientReturnBean" property="strErrMsg" />
			</div>
			<div id="wrnID"
				class="alert alert-warning alert-dismissible fade show"
				style="display: none;">
				<bean:write name="patientReturnBean" property="strWarningMsg" />
			</div>
			<div id="normalMsg"
				class="alert alert-success alert-dismissible fade show"
				style="display: none;">
				<bean:write name="patientReturnBean" property="strNormalMsg" />
			</div>

			<div class="container-fluid">
				<div class="prescriptionTile">
				
					<div class="row">
						<div class="col-sm-1" align="right">
							<label><font color="red">*</font>Store Name</label>
						</div>
						<div class="col-sm-3">
							<select name="strStoreId" class='custom-select' onchange="getItemCatCmb();">
								<bean:write name="patientReturnBean" property="strStoreValues" filter="false" />
							</select>
						</div>


						<div class="col-sm-1" align="right">
							<label><font color="red">*</font>Category</label>
						</div>
						<div class="col-sm-3">
							<!-- 2nd time fil in using id value ajax --> 
							<div id="itemCatDivId">
								<select name="strItemCatId" id='strItemCatId' class="custom-select">
									<!-- bean:write 1st time fill in  -->
									<%-- <bean:write name="patientReturnBean" property="strItemCatValues"
										filter="false" /> --%>
									<option value="0">Select Value</option>
								</select>
							</div>
						</div>
						
						<div class="col-sm-1" align="right">
							<font color="red">*</font>CR No.
						</div>
						<div class="col-sm-3">
							<crNo:crNo value="${patientReturnBean.strCrNo}"
								js="onkeypress='return initGoFunc(event);'"></crNo:crNo>
						</div>
					</div>
					
					<hr>
					
					<div class="row align-items-center"
						style="margin:1% 1%;display: flex; position: relative;">
						<!-- Fields Mandatory Text -->
						<div
							style="position: absolute; right: 0; font-size: smaller; display: flex; align-items: center;">
							<i class="fas fa-asterisk" style="color: red;"></i>&nbsp;<span>Fields
								Mandatory</span>
						</div>

						<!-- GO Button -->
						<div class="col text-center">
							<a class="btn btn-sm btn-success" id="goBtnId" href="#"
								onclick="goFunc();" onkeyup="goFuncOnEnter(event);"
								style="font-size: 1rem;" aria-label="Go Button"> GO&nbsp;<i
								class="fas fa-angle-double-right"></i>
							</a>
						</div>
					</div>
				</div>
			</div>
	
			<div id="blanket" style="display:none;"></div>
			<div class="popUpDiv" id="popUpDiv" style="display:none;">
				<table bgcolor="white">
					<tr>
						<td>
							<div id="issueDtlsDivId" style="display:block;"></div>
						</td>
					</tr>
				</table>
			</div>
	
			<input type="hidden" name="mode" /> 
			<input type="hidden" name="hmode" />	
			<input type="hidden" name="strMode" value="${patientReturnBean.strMode}"> 
			
			<input type="hidden" name="storeName" value="${patientReturnBean.storeName}" />
			<input type="hidden" name="itemCatName" value="${patientReturnBean.itemCatName}" />
			
			<input type="hidden" name="storeHidId" value="${patientReturnBean.storeHidId}" />
			<input type="hidden" name="itemCatHidId" value="${patientReturnBean.itemCatHidId}" />
			<input type="hidden" name="crNoHid" value="${patientReturnBean.crNoHid}" />
			<input type="hidden" name="crNo" value="${patientReturnBean.crNo}" />
			<input type="hidden" name="strReturnNo" value="${patientReturnBean.strReturnNo}">

		</fieldset>
	</html:form>
	
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