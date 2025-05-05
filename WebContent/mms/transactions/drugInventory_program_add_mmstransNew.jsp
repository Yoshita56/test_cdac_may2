<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html>
<head>
<meta charset=UTF-8">
<title>Drug Inventory</title>

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
<!-- <link href="../../hisglobal/bootstrap4.0_newgui/css/newlayout.css" rel="stylesheet" type="text/css"> -->

<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet" type="text/css">
<link href="../../mms/css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/transactionutil/js/master.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="Javascript" src="../../hisglobal/js/time.js"></script>
<script language="JavaScript" src="../js/drug_inventory_programmeNew.js"></script>
<script language="JavaScript" src="../js/item_OtherDtls_util.js"></script>
<!-- <script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script> -->

<script>
	$('.datepicker').each(function() {
		$(this).datepicker({
			modal : true,
			header : true,
			footer : true,
			format : 'dd-mmm-yyyy'
		});
	});
	var today = new Date();
	var arr = [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
			"Oct", "Nov", "Dec" ];
	var mmm = arr[today.getMonth()];
	var hrs = today.getHours();
	var dd = today.getDate() + "-" + mmm + "-" + today.getFullYear();
	$('.datepicker').val(dd);
</script>

<script type="text/javascript">
	$(function() {
		var itemList = [];
		$('#strMultiRowItemId option').each(function() {
			itemList.push({
				"value" : this.textContent,
				"data" : this.value.split("^")[0]
			});
		});

		$('#strSearchDrug').autocomplete({
			lookup : itemList,
			minChars : 3,
			onSelect : function(suggestion) {
				getDrugNameSelected(suggestion.data);
			}
		});

		$('#strSearchDrug').click(function() {
			$(this).val("");

		});
	});

	function getReport() {
		if (document.getElementById('printFlag').value == '1') {
			// 	  document.getElementById('popUpDiv1').style.display="";
			// 	  popup('popUpDiv1', '60', '80');

			$.ajax({
						url : "/INVMGM/mms/transactions/DrugInventoryWithProgramTransBSCNT.cnt?hmode=PRINTVOUCHER",
						type : "POST",
						cache : false,
						data : {
							totalBatchNumber : $("#totalBatchNumber").val(),
							strItemBrandId : $("#strItemBrandId").val(),
							strStoreId : $("#strStoreIdValue").val(),
							strStoreName : $("#strStoreName").val()

						},
						success : function(data) {
							//  alert("data=="+data);
							var itemParaObj = document
									.getElementById("itemsOtherDtlsDivId");

							//alert("data==1"+data);

							itemParaObj.innerHTML = data;

							popup('otherDtlspopUpDiv', '80', '80');

							//  document.getElementById("popUpDiv").innerHTML=data;

						},
						error : function(errorMsg, textstatus, errorthrown) {
							alert('stockValue' + errorMsg + "textstatus::"
									+ textstatus + "errorthrown::"
									+ errorthrown);
						}
					})

		}
	}
	function cancelToList() {

		document.forms[0].action = "/INVMGM/mms/transactions/DrugInventoryTransBSCNT.cnt?hmode=LISTPAGE1";
		document.forms[0].submit();

	}
	function printData() 
	{
		document.getElementById("printid1").style.display="none"; 
	    const contentToPrint = document.getElementById("itemsOtherDtlsDivId").cloneNode(true);
	    const newWin = window.open('', '', 'width=700,height=700,scrollbars=yes');
	    newWin.document.write('<html><head>');
	    newWin.document.write('<style type="text/css">');
	    newWin.document.write('.hidecontrol { display: none; }');
	    newWin.document.write('@media print {');
//	    newWin.document.write('  #toolbar { display: none; }');
//	    newWin.document.write('  body { margin: 0; padding: 0; }');
//	    newWin.document.write('  @page { margin: 4mm 3mm; size: A4 portrait; }');
//	    newWin.document.write('  table { table-layout: fixed; width: 100%; }');
	    newWin.document.write('  table {border-collapse: collapse; }');
//	    newWin.document.write('  table td { word-wrap: break-word; font-size: 12px; }');

	    // Define page break rules for the repeat-table class
//	     newWin.document.write('.repeat-table { page-break-before: always; }');

	    newWin.document.write('}');
	    newWin.document.write('</style>');
	    
	    newWin.document.write('</head><body>');
	    newWin.document.write(contentToPrint.outerHTML);
	    newWin.document.write('</body></html>');
	    newWin.document.close();
	    newWin.onload = function () {
	        newWin.print();
	        newWin.close();
	        document.getElementById("printid1").style.display="block"; 
	    };
	}
	function hideIssuePopup(){
		
		document.getElementById("itemsOtherDtlsDivId").innerHTML = "";
		
		hide_popup('popUpDiv');
	}
	function controlToMainPage()
	{	    
		document.forms[0].hmode.value="INSERT";
		document.forms[0].submit();
	}
	
</script>

<style type="text/css">
body {
    font-family: Arial, sans-serif;
    font-size: 14px;
    line-height: 1.6;
    color: #333; /* Adjust color for better readability */
    font-weight: normal; /* Use 'normal' instead of '501' */
}
.legend2 {
	  position: absolute;
	  top: -2.85em;
	  right: 15px;
	  line-height: 1.2em;
}
.container {
    max-width: 100%; /* Allow container to adjust based on screen size */
    padding: 0 15px; /* Add padding for better spacing */
}
.form-control {
    color: #333; /* Adjust color for better readability */
}
.prescriptionTile {
    margin: 20px 0; /* Adjust margin for better spacing */
    border: 1px solid #ccc; /* Use a neutral border color */
    border-radius: 4px; /* Adjust border-radius for rounded corners */
    background-color: #f0f8ff; /* Faint light blue color */
    padding: 20px; /* Add padding for better spacing */
    transition: box-shadow 0.3s ease; /* Add transition for box-shadow */
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Use a subtle box-shadow */
    color: #333; /* Adjust color for better readability */
}
.subHeaders {
    font-weight: bold; /* Use 'bold' instead of '500' */
    font-size: 18px; /* Adjust font size for better readability */
    margin-bottom: 10px; /* Add margin for spacing */
}
.row {
    margin-bottom: 15px; /* Add margin for spacing */
}
.cancelbtn {
    padding: 8px 15px; /* Adjust padding for better button appearance */
    line-height: 1; /* Reset line-height */
    background-color: #d9534f; /* Use a more neutral button color */
    border: none; /* Remove border for cleaner appearance */
    border-radius: 4px; /* Adjust border-radius for rounded corners */
    color: #fff; /* Adjust color for better readability */
}

.btn-circle {
    width: 36px; /* Adjust width for better appearance */
    height: 36px; /* Adjust height for better appearance */
    padding: 6px 0; /* Adjust padding for better appearance */
    font-size: 14px; /* Adjust font size for better appearance */
    line-height: 1; /* Reset line-height */
    border-radius: 50%; /* Use a border-radius to create a circle */
    color: #fff; /* Adjust color for better readability */
}
.iround {
    font-size: 16px; /* Adjust font size for better appearance */
}

@media (max-width: 768px) {
    .prescriptionTile {
        margin: 20px 0;
        padding: 15px;
    }
</style>

</head>
<body onload="OnLoadFunction();getReport();" class="background">

	<html:form name="drugInventoryProgramTransBean" styleClass="formbg"
		action="/transactions/DrugInventoryWithProgramTransBSCNT"
		type="mms.transactions.controller.fb.DrugInventoryWithProgramTransFB">

		<div class="errMsg" id="errMsg" style="font-size: 16px;">
			<bean:write name="drugInventoryProgramTransBean" property="strErr" />
		</div>
		<div class="warningMsg" id="warningMsg" style="font-size: 16px;">
			<bean:write name="drugInventoryProgramTransBean"
				property="strWarning" />
		</div>
		<div class="normalMsg" id="normalMsg" style="font-size: 16px;">
			<bean:write name="drugInventoryProgramTransBean" property="strMsg" />
		</div>

		<div class="container-fluid">
			<div class="prescriptionTile">
				<div class="row" id="">
					<div class="col-sm-6" style="text-align: initial;">
						<p class="subHeaders">
							<i class="fas fa-file-alt"
								style="font-size: 20px; color: #28a745"></i> &nbsp;Drug
							Inventory
						</p>
					</div>
					<div class="col-sm-6" id="">
						<div class="legend2" id='saveId'>
							<button type="button" id="cancelButton"
								class="float-right btn btn-danger mt-1 btn-circle cancelbtn"
								onClick="cancel('CANCELPAGE');" title="Cancel">
								<i class="fas fa-times iround" title="Cancel"></i>
							</button>

							<button type="button"
								class="float-right btn btn-secondary mt-1 btn-circle"
								style="background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;"
								onclick="ClearPage();">
								<i class="fas fa-broom  iround" title="Clear"></i>
							</button>

							<button type="button" id="savebutton"
								class="float-right btn btn-success mt-1 btn-circle savebtn"
								name="" tabindex='2' onclick='validateMultiRow();'>
								<i class="fa fa-save fa-beat iround" title="Save"></i>
							</button>
						</div>
					</div>
				</div>
				
				<div class="row text-center" style="color: red;">
					<div class="col-sm-12">
						<b><blink>Stock Quantity will not be added with the
								current stock. Only modification is Possible(if exists) for same
								batch</blink></b>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-2">
						<label>Store:</label> <span style="font-weight: 400; color: blue;">
							<bean:write name="drugInventoryProgramTransBean"
								property="strStoreName" filter="false" />
						</span>
					</div>

					<div class="col-sm-2" align="right">
						<label>Drug Name:</label>
					</div>

					<div class="col-sm-8">
						<div id="itemBrandDivId" style="display: none;">
							<select name="strMultiRowItemId" id="strMultiRowItemId"
								class="form-control form-control-sm">
								<bean:write name="drugInventoryProgramTransBean"
									property="strItemBrandCombo" filter="false" />
							</select>
						</div>
						<input type="text" class="form-control"
							placeholder="Enter at least 3 characters" id="strSearchDrug"
							name="strSearchDrug" size="120%" />
					</div>
				</div>

				<div class='row'>
					<div class='col-sm-2'>
						<label> Selected Drug Name </label>
					</div>
					<div class='col-sm-8' align="left">
						<div id="DrugNameId" style="font-weight: 401; color: blue;">
						</div>
					</div>

					<div class='col-sm-2'>
						<div class='row' style="display: none;">
							<div class='col-sm-7' >
								<label> No of Batch </label>
							</div>
							<div class='col-sm-5'>
								<input type='text' class='form-control' name='strNoOfMultiRow'
									id='strNoOfMultiRow' value='' maxlength='2'
									onkeypress='if(event.keyCode==13) return getMultiRow(this);'>
							</div>
						</div>
					</div>
				</div>

				<div style="width: 100%; overflow: auto;">
					<table width='100%' align="center" border="0" cellspacing="0"
						id='mstTable'>
						<tr>
							<td align='center'>
								<div id="id1"></div> 
							</td>
						</tr>
					</table>
				</div>
				
				<input type="hidden" name="strBatchExistInStockFlg"> 
				<input type="hidden" name="strBatchExistSuppBatchInStockFlg"> 
				<input type="hidden" name="strQcTypeFlg" value=""> 
				<input type="hidden" name="strBatchMandFlg" value="1"> 
				<input type="hidden" name="strExpMandFlg" value="1"> 
				<input type="hidden" name="strMfgMandFlg" value="1"> 
				<input type="hidden" name="strStoreIdValue" id="strStoreIdValue" value="${drugInventoryProgramTransBean.strStoreIdValue}" />
				<input type="hidden" name="strStoreId" id="strStoreId" value="${drugInventoryProgramTransBean.combo[0]}" /> 
				<input type="hidden" name="strStoreName" id="strStoreName" value="${drugInventoryProgramTransBean.strStoreName}" /> 
				<input type="hidden" name="strGroupId" value="${drugInventoryProgramTransBean.combo[1]}" /> 
				<input type="hidden" name="strGroupName" value="${drugInventoryProgramTransBean.strGroupName}" /> 
				<input type="hidden" name="strCtDate" value="${drugInventoryProgramTransBean.strCtDate}"> 
				<input type="hidden" name="strDefaultCurrencyCode" value="${drugInventoryProgramTransBean.strDefaultCurrencyCode}"> 
				<input type="hidden" name="strRegFlag" value="" /> 
				<input type="hidden" name="strSalePrice" value="" />  
				<input type="hidden" name="strDrugTotCost" id="strDrugTotCost"> 
				<input type="hidden" name="hmode" /> 
				<input type="hidden" name="strExistingBatchFlg" /> 
				<input type="hidden" name="strExistingBatchDetails"> 
				<input type="hidden" name="strConfigIssueRate" value="${drugInventoryProgramTransBean.strConfigIssueRate}"> 
				<input type="hidden" name="strIssueRateConfigFlg" value="${drugInventoryProgramTransBean.strIssueRateConfigFlg}"> 
				<input type="hidden" name="strIsDataSaveFlg" value="${drugInventoryProgramTransBean.strIsDataSaveFlg}"> 
				<input type="hidden" name="strSavedDrugName" value="${drugInventoryProgramTransBean.strSavedDrugName}"> 
				<input type="hidden" name="strSavedBatchName" value="${drugInventoryProgramTransBean.strSavedBatchName}"> 
				<input type="hidden" name="strStoreTypeFlag" value="${drugInventoryProgramTransBean.strStoreTypeFlag}"> 
				<input type="hidden" name="strSelDrugName" value=""> 
				<input type="hidden" name="printFlag" id="printFlag" value="${drugInventoryProgramTransBean.printFlag}" /> 
				<input type="hidden" name="totalBatchNumber" id="totalBatchNumber" value="${drugInventoryProgramTransBean.totalBatchNumber}"> 
				<input type="hidden" name="strItemBrandId" id="strItemBrandId" value="${drugInventoryProgramTransBean.strItemBrandId}">

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
	</html:form>
	
	<jsp:include page="drugInventory_program_multirow_mmstransNew.jsp"></jsp:include>
	

</body>

</html>
