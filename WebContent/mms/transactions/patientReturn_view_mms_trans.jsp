<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>

<html>
<head>
<meta charset=UTF-8">
<title></title>

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
	
	<script type="text/javascript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script> 
	<script type="text/javascript" src="../../hisglobal/masterutil/js/master.js"></script>
	<script type="text/javascript" src="../../hisglobal/js/util.js"></script>
	<script type="text/javascript" src="../js/mms.js"></script>
	<script type="text/javascript" src="../../hisglobal/js/newpopup.js"></script>
	<script type="text/javascript" src="../../hisglobal/js/popup.js"></script>
	<script type="text/javascript" src="../../hisglobal/js/multirow.js"></script>
	<script type="text/javascript" src="../../hisglobal/js/calendar.js"></script>
	
		
	<script type="text/javascript" src="../js/searchItems_util.js"></script>
	<script type="text/javascript" src="../js/stockDetails_util.js"></script>
	<script type="text/javascript" src="../js/issueDetails_util.js"></script>
    <script type="text/javascript" src="../js/IssueDetailsUtil.js"></script>
	
	
	<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
	<script type="text/javascript" src="../js/ValidationCommonn.js"></script>
	
	<script type="text/javascript" src="../../hisglobal/js/validation.js"></script>
	<script  src="../../hisglobal/js/validationBootstrap.js"></script>
	
	<link rel="stylesheet" href="../../hisglobal/DataTables/css/jquery.dataTables.min.css">
	<script src="../../hisglobal/DataTables/js/jquery.dataTables.min.js"></script>

	<!-- EXT JS -->
	<script type="text/javascript"  src="../js/patientReturn.js"></script>

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
	input.form-control {
		height: 34px;
		padding: 0.375rem 0.75rem;
		font-size: 14px;
	}		
</style>


</head>
<body>
<!-- RJ|47 -->
<html:form name="patientReturnBean" action="/transactions/PatientReturnTransCNT" type="mms.transactions.controller.fb.PatientReturnTransFB">
<div class="prescriptionTile">

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
			
<!--TITLE_BTN-->
			<div class="row ">
				<div class="col-sm-6" style="text-align: initial;">
					<p class="subHeaders">
						<i class="fas fa-file-alt iround"
							style="font-size: 20px; color: #28a745" title=""></i>
						&nbsp;Previous Records
					</p>
				</div>
						
				<div class="col-sm-6" id="">
					<div class="legend2" id='nonPrintableLegend2'>
					<button type="button"
						class="float-right btn btn-danger mt-1 btn-circle "
						onClick="Backbtn();">
						<i class="fas fa-arrow-left iround" title="Back"></i>
					</button>
				</div>
				</div>
			</div>
<!--TITLE_BTN-->

<!-- HEADER START -->
				<div class="row my-1" style="margin: 1% 5%">
					<div class="col-md-2" align="right">
						<font color="red">*</font>Store Name
					</div>
					<div class="col-md-4">
						<select name="strStoreId" class="browser-default custom-select"
							onChange="">
							<bean:write name="patientReturnBean" property="strStoreValues"
								filter="false" />
						</select>
					</div>

					<div class="col-md-2" align="right">
						<font color="red">*</font>CR No.
					</div>
					<div class="col-md-4">
						<crNo:crNo value="${patientReturnBean.strCrNo}"
							js="onkeypress='return initGoFunc(event);'">
						</crNo:crNo>
					</div>
				</div>

				<div class="row my-1" style="margin: 1% 5%">
					<div class="col-md-2" align="right">
						<font color="red">*</font>From Date
					</div>
					<div class="col-md-4">
						<input name="strFromDate" class="form-control datepicker"
							value="${returnFromTransBean.strFromDate}"
							style="color: rgba(113, 111, 111, 0.87);">
					</div>

					<div class="col-md-2" align="right">
						<font color="red">*</font>To Date
					</div>
					<div class="col-md-4">
						<input name="strToDate" class="form-control datepicker"
							value="${returnFromTransBean.strToDate}"
							style="color: rgba(113, 111, 111, 0.87);">
					</div>
				</div>
				<hr>

				<div class="row align-items-center"
					style="margin: 1% 1%; display: flex; position: relative;">
					<!-- Fields Mandatory Text -->
					<div
						style="position: absolute; right: 0; font-size: smaller; display: flex; align-items: center;">
						<i class="fas fa-asterisk" style="color: red;"></i>&nbsp;<span>Fields
							Mandatory</span>
					</div>

					<!-- GO Button -->
					<div class="col text-center">
						<a class="btn btn-sm btn-success" id="goBtnId" href="#"
							onclick="getViewItemDtl();" style="font-size: 1rem;"
							aria-label="Go Button"> GO&nbsp;<i
							class="fas fa-angle-double-right"></i>
						</a>
					</div>
				</div>
			</div>
			<!-- HEADER END -->
 
<!-- PREVIOUS TABLE START-->  
<div class="prescriptionTile" >
   <!-- a6f3bc52 -->
		<div style="display: flex; align-items: center; background-color: #d1d1ca52; padding: 0px; border-radius: 8px;">
			&nbsp;<p class="subHeaders"
				style="font-size: 24px; font-weight: bold; margin: 0;">
				Previous Return Records</p>&nbsp;
			<i class="fas fa-angle-double-right"
				style="font-size: 20px; color: #8a877d; margin-right: 8px;"></i>
		</div>
		 <div id="datatableId">
		 	<div id="returnDtlId"></div> 
		</div> 
</div>
<!-- PREVIOUS TABLE START-->  

   	  
 	   <div id="blanket" style="display:none;"></div>
	   <div class="popUpDiv" id="popUpDiv" style="display:none;">
		   <table class="table" style="background:white">
		     <tr>
		      <td>
		           <div id="issueDtlsDivId" style="display:block;"></div>
		       </td>
		     </tr>
		   </table>
	   </div>

			<!-- <div class="modal fade bd-example-modal-lg" id="issueDtlModal">
			<div class="modal-dialog modal-lg">
				<div class="modal-content" style="width: fit-content;"> 
						<div class="modal-header">
		    				<h4 class="modal-title text-left" style="color: black;">Issue Track Details</h4>
		         			 <div id='printImg' align="right" >
								<button type="button" class="btn btn-primary" onclick="printData_O()"><i class="fas fa-print" title="Print"></i></button>
								<button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fas fa-times" title="Cancel"></i></button>
							</div>
	       			 	</div>
	       			 	
						<div class="modal-body">
							<div id="issueDtlsDivId"></div>
	       				</div>
				</div>
			</div>
			</div> -->
	   
	   
	   <input type="hidden" name="hmode"/>
   	   <input type="hidden" name="strIsView" value="1"/>
<br>

</html:form>
		
 <script type="text/javascript">
	$(document).ready(function() {
//	     	$('#data-table').DataTable(); 
		 	$('#data-table').DataTable({
		        paging: false // Disable pagination
		    });
	}); 
 
 	$('.datepicker').each(function(){
	    $(this).datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
	});
	var today=new Date();
	var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
	var mmm=arr[today.getMonth()];
	var hrs=today.getHours();
	var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
	$('.datepicker').val(dd);
	

</script> 
<!-- RJ|47 -->

</body>
</html>