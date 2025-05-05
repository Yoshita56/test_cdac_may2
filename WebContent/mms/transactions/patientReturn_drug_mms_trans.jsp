<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>
<%@ taglib uri="/WEB-INF/patientDtl.tld" prefix="pDtl"%>

<!-- RJ47 -->

<html>
<head>
	<meta charset=UTF-8">
	
	<title>Return From Patient</title>
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
	
	<script language="Javascript" src="../js/patientReturn.js"></script>
    <script language="Javascript" src="../js/IssueDetailsUtil.js"></script>
    	
	<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
	<script language="Javascript" src="../js/ValidationCommonn.js"></script>
	
	<link rel="stylesheet" href="../../hisglobal/DataTables/css/jquery.dataTables.min.css">
	<script src="../../hisglobal/DataTables/js/jquery.dataTables.min.js"></script>

	<script type="text/javascript"  src="../../hisglobal/js/validation.js" ></script>

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
		border-bottom: none !important;
	}
</style>

    
</head>
<!-- checkMsg(); -->
<body onload="">

<html:form name="patientReturnBean" action="/transactions/PatientReturnTransCNT" type="mms.transactions.controller.fb.PatientReturnTransFB">

	<fieldset>
<!--TITLE_BTN-->	
		<legend class='legendHeader' id='nonPrintableLegend' style='color:black;'>Return From Patient</legend>
	<!-- <div class="col-sm-6" id="saveId"> -->

		<div class="legend2" id='btnComboId'>
			<button  type="button" class="float-right btn btn-danger mt-1 btn-circle " onClick="Backbtn();">
				<i class="fas fa-arrow-left iround" title="Back"></i>
			</button>
		
			<button type="button" class="float-right btn btn-secondary mt-1 btn-circle" style="background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" onclick="clearIssue();">
				<i class="fas fa-broom  iround" title="Clear"></i>
			</button>
										
			<button type="button" id="savebutton" class="float-right btn btn-success mt-1 btn-circle savebtn" tabindex='2' onclick="return validateListSave();">
				<i class="fa fa-save fa-beat iround" title="Save"></i>
			</button>
	  	</div> 
<!--TITLE_BTN-->
 
  		<div class="container-fluid">		
			<div class="viewport" id="nonPrintable">
				<div class="alert alert-danger  alert-dismissible fade show"  id="errID" style="display: none;"><bean:write name="patientReturnBean" property="strErrMsg" /></div>
				<div class="alert alert-warning  alert-dismissible fade show" id="wrnID" style="display: none;"><bean:write name="patientReturnBean" property="strWarningMsg" /></div>
				<div class="alert alert-success  alert-dismissible fade show" id="normalMsg" style="display: none;"><bean:write name="patientReturnBean" property="strNormalMsg" /></div>			
			</div>
			
			<%-- <pDtl:patDtlNew crNo="${patientReturnBean.crNo}" address="false"></pDtl:patDtlNew>
			
			<div id="strAdmDtl">
				<bean:write name="patientReturnBean" property="strAdmDtl" filter="false" />
			</div>
			 --%>
			<div class="prescriptionTile">
			
<!-- TILE STRIP START -->			
				<div class="row my-1" style="font-size:14px;">
					<div class="col-auto px-2">Store Name:</div>
					<div class="col-auto px-2">
						<label class="text-muted"><strong><bean:write
								name="patientReturnBean" property="storeName"
								filter="false" /></strong></label>
					</div>
					
					<div class="col-auto px-2">Item Category:</div>
					<div class="col-auto px-2">
						<label class="text-muted"><strong><bean:write
								name="patientReturnBean"
								property="itemCatName" filter="false" /></strong></label>
					</div>
					
					<div class="col-auto px-2">CR No:</div>
					<div class="col-auto px-2">
						<label class="text-muted"><strong><bean:write
								name="patientReturnBean"
								property="crNoHid" filter="false" /></strong></label>
					</div>
				</div>
<!-- TILE STRIP END -->

<!-- PATIENT DTL START-->
				<div id="allDivId" style="display: block;">
					<div class="row ">
						<div class="col-md-4 ">
							<input type='hidden' name='button1' value="0">
							<div id="plus1" style="display: block">
								<i class="fas fa-plus-circle" onClick="ftn11();"></i>&nbsp;<b>Patient
									Demographic Detail</b>
							</div>
							<div id="minus1" style="display: none">
								<i class="fas fa-minus-circle" onClick="ftn11();"></i>&nbsp;<b>Patient
									Demographic Detail</b>
							</div>
						</div>
					</div>
				</div>

				<div id="patientDetailsDivId" style="display: none;">
					<table class="table" align="center" cellspacing="1px">
						<tr>
							<bean:write name="patientReturnBean"
								property="strPatientDetail" filter="false" />
						</tr>
					</table>
				</div>
<!-- PATIENT DTL END-->
				
				<br>
				
			</div>
<!-- ITEM ISSUED DTL START-->
			<div class="prescriptionTile">
<!-- 			<div id="patDtlHlp" align="center"> -->
				<div id="" align="center">
					<bean:write name="patientReturnBean" property="strIpdIssueDrugHLP" filter="false" />
				</div>
<!-- ITEM ISSUED DTL END-->
				
				<hr>
				
				<div class="row ">
					<div class="col-sm-2">Recommended By</div>
					<div class="col-sm-4">
						<select name="strRecommendedBy"
							class='custom-select'>
							<bean:write name="patientReturnBean"
								property="strRecommendNameCombo" filter="false" />
						</select>
					</div>
					<div class="col-sm-2">Recommend Date</div>
					<div class="col-sm-4">
						<input name="strRecommendDate" class="form-control datepicker"
							value="${patientReturnBean.strCtDate}"
							style="color: rgba(113, 111, 111, 0.87);" disabled >
					</div>
				</div>
				
				<div class="row">
					<div class="col-sm-2">Remarks</div>
					<div class="col-sm-10">
						<textarea class="form-control" name="strRemarks" rows="2"
							style="height: 38px"></textarea>
					</div>
				</div>
			</div> 

			</div>
			
			<input type="hidden" name="storeName" value="${patientReturnBean.storeName}" />
			<input type="hidden" name="storeHidId" value="${patientReturnBean.storeHidId}" />
			
			<input type="hidden" name="itemCatName" value="${patientReturnBean.itemCatName}" />
			<input type="hidden" name="itemCatHidId" value="${patientReturnBean.itemCatHidId}" />
			
			<input type="hidden" name="crNoHid" value="${patientReturnBean.crNoHid}" />	 
		
		
	<input type="hidden" name="hmode" value=""/>	
	<input type="hidden" name="strUpdateFlag" 			        value="" />	
	<input type="hidden" name="storeName" id="storeName"        value="${patientReturnBean.storeName}" />
	<input type="hidden" name="itemCatName"				        value="${patientReturnBean.itemCatName}" />
	<input type="hidden" name="strCrNo" 				        value="${patientReturnBean.strCrNo}" />		
	<input type="hidden" name="strId" 	 id="strId"		        value="${patientReturnBean.strId}" />
	<input type="hidden" name="strIssueNo" 				        value="${patientReturnBean.strIssueNo}" />
	<input type="hidden" name="strIssueDtl"				        value="${patientReturnBean.strIssueDtl}" />
	<input type="hidden" name="strIssueNum" 			        value="${patientReturnBean.strIssueNum}" />	
	<input type="hidden" name="checkFlg" id="checkFlg"			value="${patientReturnBean.checkFlg}"  />
	<input type="hidden" name="strSearchStr" id="strSearchStr"  value="${patientReturnBean.strSearchStr}"  />
	
	<input type="hidden" name="hospCode" 				value="${patientReturnBean.strHospitalCode}" />
	<input type="hidden" name="storeName" 				value="${patientReturnBean.storeName}" />
	<input type="hidden" name="itemCatName" 			value="${patientReturnBean.itemCatName}" />
	<input type="hidden" name="crNo" 					value="${patientReturnBean.crNo}" />
	<input type="hidden" name="strCrNo" 				value="${patientReturnBean.crNo}" />
	<input type="hidden" name="strId" 					value="${patientReturnBean.strId}" />
	<input type="hidden" name="itemCategory" 			value="${patientReturnBean.itemCategory}" />
	<input type="hidden" name="strConfCatCode" 			value="${patientReturnBean.strConfCatCode}" />
	<input type="hidden" name="strIssueMode"   			value="${patientReturnBean.strIssueMode}">
	<input type="hidden" name="strReturnDrugValidity"   value="${patientReturnBean.strReturnDrugValidity}">

	</fieldset>
</html:form>
	
	<script type="text/javascript">
		$(document).ready(function() {
	//	     	$('#data-table').DataTable(); 
			 	$('#data-table').DataTable({
			        paging: true, // Enable pagination
		            searching: true, // Enable search box
		            responsive: true // Make it mobile-friendly

			    });
		});
		
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