<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>
<%@ taglib uri="/WEB-INF/patientDtl.tld" prefix="pDtl"%>

<html>
<head>
<meta charset=UTF-8">
<title>Issue To Patient Process</title>

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css"   rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
	
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../js/issue_transNewBS.js"></script>
<script language="Javascript" src="../js/searchItems_utilBS.js"></script>
<script language="Javascript" src="../js/stockDetails_util.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script>
<script type="text/javascript">
function controlToIssueToPatientPage()
{	    
	//cancelIssue();
	//alert(document.getElementsByName("strId")[0].value);
		document.forms[0].hmode.value="INITVAL";
		document.forms[0].submit();
}
function getLfDetails()
{
	document.getElementById('lfDiv').style.display='block';
}

function closeLfDetails()
{
	document.getElementById('lfDiv').style.display='none';
}
</script>
<style>
        .example {
            page-break-after: always;
        }
    </style>
    
<style type="text/css">

.newhr{
   
    border-top: 3px solid rgb(6, 138, 255);
    margin-right: -16px;
margin-left: -16px;
}
.table th, .table td {
    padding: 0.15rem;
    text-align: left;
}
.custom-select[multiple], .custom-select[size]:not([size="1"]) {
    height: 220px;

}
.comboMin{
display: inline-block;
width: 100%;
height: calc(1.5em + 0.75rem + 2px);
padding: 0.375rem 1.75rem 0.375rem 0.75rem;
font-size: 0.8rem;
font-weight: 400;
line-height: 1.5;
color: #495057;
vertical-align: middle;
background: url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 4 5'%3e%3cpath fill='%23343a40' d='M2 0L0 2h4zm0 5L0 3h4z'/%3e%3c/svg%3e") no-repeat right 0.75rem center/8px 10px;
    background-color: rgba(0, 0, 0, 0);
background-color: #fff;
border: 1px solid #ced4da;
border-radius: 0.25rem;
-webkit-appearance: none;
-moz-appearance: none;
appearance: none;
}

</style>
</head>
<body onload="onCheckCategory();chkVisitDtl();getReport();">


<html:form name="issueBean" action="/transactions/IssueTransBSCNT"
	type="mms.transactions.controller.fb.IssueTransFB">
<fieldset>
	<legend class='legendHeader' id='nonPrintableLegend'>Issue To Patient</legend>
	<div class="legend2" id="saveId">
		
		<button id="cancelButton" type="button" class="btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="controlToIssueToPatientPage();">
		<div class="popupToast"><i class="fa fa-ban iround"  title="Cancel"></i><span class="popuptextToast">Cancel</span></div>
		</button>	
		<button type="button" class=" btn btn-secondary btn-circle" onclick="clearIssue();" style="background: #b9b9b9; border-color:#b9b9b9;margin-top: 0.25rem !important;">
		<img  src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 23px; color: #fff;">
		</button>	
				
	    <button  type="button" id="savebutton" class="btn btn-outline-success mt-1 btn-circle savebtn"  tabindex='2' id="" onclick=' return validateIssue();'  data-toggle="" data-target="#previewModal" >					
			<div class="popupToast"><i class="fa fa-save iround"  title="Save"></i> <span class="popuptextToast">Save</span></div>
		</button>												                 
  </div> 
	<div id="errMsg" class="errMsg"><bean:write name="issueBean"
		property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="issueBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="issueBean" property="strNormalMsg" /></div>
		<pDtl:patDtlNew crNo="${issueBean.crNo}" address="false"></pDtl:patDtlNew>

<div class="prescriptionTile"> 
	<logic:equal value="0" name="issueBean" property="strMode">

	<%-- 	<tag:tab tabLabel="Issue To Patient" selectedTab="FIRST"
			align="center" width="TABLEWIDTH">
		</tag:tab>
		<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4">Issue To Patient&gt;&gt;</td>
			</tr>
		</table> --%>

	</logic:equal>

	<logic:equal value="1" name="issueBean" property="strMode">
		<%-- <tag:tab tabLabel="Issue To Staff" selectedTab="FIRST" align="center"
			width="TABLEWIDTH">
		</tag:tab>
		<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4">Issue To Staff&gt;&gt;</td>
			</tr>
		</table> --%>
	</logic:equal>


	<logic:equal value="2" name="issueBean" property="strMode">
		<%-- <tag:tab tabLabel="Issue To Patient/Staff" selectedTab="FIRST"
			align="center" width="TABLEWIDTH">
		</tag:tab>
		<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4">Issue To Patient/Staff&gt;&gt;</td>
			</tr>

		</table> --%>

	</logic:equal>


	<div class='popup' id='balQtyDtlId' style="display: none">
	<table width='400' border="0" cellspacing="1" cellpadding="1">
		<tr class="HEADER">
			<td colspan='3'>Quantity Details</td>

			<th align='right'><img style='cursor: pointer; '
				src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideBalQtyDetails('balQtyDtlId');"></th>
		</tr>
	</table>


	<table width='400' border="0" cellspacing="1" cellpadding="1">

		<tr>
			<td colspan="1" class='multiLabel'>Req Qty</td>
			<td colspan="1" class='multiLabel'>Issue Qty</td>

		</tr>
		<tr>
			<td colspan="1" class='multiControl'>
			<div id='1'></div>
			</td>
			<td colspan="1" class='multiControl'>
			<div id='2'></div>
			</td>

		</tr>
	</table>
	</div>
<div class='row' style='line-height: 0.8'>
<div class='col-sm-2'></div>
<div class='col-sm-2'>
<label>Store Name</label>
</div>
<div class='col-sm-2' style='font-weight: 400; color: blue;' align="left">
<bean:write name="issueBean" property="storeName" filter="false" />
</div>
<div class='col-sm-2'>
<label>Item Category</label>
</div>
<div class='col-sm-2' style='font-weight: 400; color: blue;' align="left">
<bean:write name="issueBean" property="itemCatName" filter="false" />
</div>
<div class='col-sm-2'></div>
</div>

<div class='row' style='line-height: 0.8'>
<div class='col-sm-2'></div>
<div class='col-sm-2'>
<label>CR No.</label>
</div>
<div class='col-sm-2' style='font-weight: 400; color: blue;' align="left">
<bean:write name="issueBean" property="crNo" filter="false" /></div>
<div class='col-sm-2'>
<label>LF No.</label>
</div>
<div class='col-sm-2' style='font-weight: 400; color: blue;' align="left">
<a href="#" onclick='getLfDetails();'><bean:write name="issueBean"
				property="strLFAccountNo" filter="false" /></a>
				</div>
<div class='col-sm-2'></div>
</div>
<%-- 
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td width="25%" colspan="1" class="LABEL">Store Name</td>
			<td width="25%" colspan="1" class="CONTROL"><bean:write
				name="issueBean" property="storeName" filter="false" /></td>

			<td width="25%" colspan="1" class="LABEL">Item Category</td>
			<td width="25%" colspan="1" class="CONTROL"><bean:write
				name="issueBean" property="itemCatName" filter="false" /></td>
		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL">CR No.</td>
			<td width="25%" colspan="1" class="CONTROL"><bean:write name="issueBean"
				property="crNo" filter="false" /></td>
				
			<td width="25%" colspan="1" class="LABEL">LF No.</td>
			<td width="25%" colspan="1" class="CONTROL"><a href="#" onclick='getLfDetails();'><bean:write name="issueBean"
				property="strLFAccountNo" filter="false" /></a></td>
		</tr>
	</table> --%>
  <div id='lfDiv' style='display:none;'>
<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">

		<tr>
			<td colspan="3" width='75%'><div class='line'><label class='DIVLABEL'>Patient LF Account Details</label></div></td>
			<td colspan="1" width='25%'><div class='line'><label onclick='closeLfDetails();' class='DIVLABEL'><font color='red'>Hide LF Details</font></label></div></td>
		</tr>
	
		<tr>
			<td width="25%" colspan="1" class="LABEL">Account Opening Date</td>
			<td width="25%" colspan="1" class="CONTROL"><bean:write
				name="issueBean" property="strLFAccountOpenDate" filter="false" /></td>

			<td width="25%" colspan="1" class="LABEL">Current Balance</td>
			<td width="25%" colspan="1" class="CONTROL"><bean:write
				name="issueBean" property="strLFBalanceAmount" filter="false" /></td>
		</tr>
		
		<tr>

			<td width="25%" colspan="1" class="LABEL">LF Account Status</td>
			<td width="25%" colspan="3" class="CONTROL"><bean:write
				name="issueBean" property="strLFAccountStatus" filter="false" /></td>
		</tr>
		
	
	</table></div>
 <%-- 
<div id="allDivId" style="display: block;">
	
		<!-- <tr>
			<td width="5%" class="TITLE" align="center"><img
				src="../../hisglobal/images/plus.gif" id="plus1"
				style="display: block; cursor: pointer" onClick="getPatDtl();">
			<img src="../../hisglobal/images/minus.gif" id="minus1"
				style="display: none; cursor: pointer" onClick="getPatDtl1();"></td>

			<td colspan="3" class="TITLE" align="left"><b>Patient
			Demographic Detail</b></td>
		</tr> -->
	<div class='row'>
	<div class='col-sm-4'>
	<div class='row'>
	<div class='col-sm-1'>
	<button type="button" class="btn btn-info btn-sm" id="plus1"  style="display: block; cursor: pointer" onClick="getPatDtl();"><i class="fas fa-plus"></i></button>
	<button type="button" class="btn btn-info btn-sm" id="minus1" style="display: none; cursor: pointer" onClick="getPatDtl1();"><i class="fas fa-minus"></i></button>
	</div>
	<div class='col-sm-11 subHeaders' align="left">
	Patient Demographic Detail
	</div>
	</div>	
	</div>
	</div>
</div>
	<div id="patientDetailsDivId" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<bean:write name="issueBean" property="strPatientDetailsNew" filter="false" />
		</tr>
	</table>
	</div>
	 --%>
	<div id="diagDivId" style="display: block;">
	<!-- <table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
		<tr>
			<td width="5%" class="TITLE" align="center"><img
				src="../../hisglobal/images/plus.gif" id="plus4"
				style="display: none; cursor: pointer" onClick="getPatDiagDtl();">
			<img src="../../hisglobal/images/minus.gif" id="minus4"
				style="display: block; cursor: pointer" onClick="getPatDiagDtl1();"></td>

			<td colspan="3" class="TITLE" align="left"><b>Patient
			Diagnosis Detail</b></td>
		</tr> </table>-->
		
		<div class='row'>
	<div class='col-sm-4 subHeaders'>
	<!-- <div class='row'>
	<div class='col-sm-1'>
	<button type="button" class="btn btn-info btn-sm" id="plus4"  style="display: none; cursor: pointer" onClick="getPatDiagDtl();"><i class="fas fa-plus"></i></button>
	<button type="button" class="btn btn-info btn-sm" id="minus4" style="display: block; cursor: pointer" onClick="getPatDiagDtl1();"><i class="fas fa-minus"></i></button>
	</div> -->
	<!-- <div class='col-sm-11 subHeaders' align="left"> -->
	Diagnosis Detail
	<!-- </div> -->
	</div>	
	</div>

	
	

	<!-- <div id="patientDiagDetailsDivId" style="display: block;"> -->
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<bean:write name="issueBean" property="strPatientDiagDetails"
				filter="false" />
		</tr>
	</table>
	<!-- </div> -->

<!-- <div style=''> -->
 <!-- <table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
		<tr>
			<td width="5%" class="TITLE" align="center"><img
				src="../../hisglobal/images/plus.gif" id="plus3"
				style="display: block; cursor: pointer" onClick="getPatTrtDtl();">
			<img src="../../hisglobal/images/minus.gif" id="minus3"
				style="display: none; cursor: pointer" onClick="getPatTrtDtl1();"></td>

			<td colspan="3" class="TITLE" align="left"><b>Patient
			Treatment Detail</b></td>
		</tr>
	</table> -->
	
	<div class='row'>
	<div class='col-sm-4 subHeaders'>
	<!-- <div class='row'>
	<div class='col-sm-1'>
	<button type="button" class="btn btn-info btn-sm" id="plus3"  style="display: none; cursor: pointer" onClick="getPatTrtDtl();"><i class="fas fa-plus"></i></button>
	<button type="button" class="btn btn-info btn-sm" id="minus3" style="display: block; cursor: pointer" onClick="getPatTrtDtl1();"><i class="fas fa-minus"></i></button>
	</div>
	<div class='col-sm-11 subHeaders' align="left"> -->
	Treatment Detail
	</div>
	</div>	
	<!-- </div>
	</div> -->
	<!-- <div id="patientTreatmentDetailsDivId" style=""> -->
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<bean:write name="issueBean" property="strPatientTreatmentDtl"
				filter="false" />
		</tr>
	</table>
	<!-- </div> -->
<!-- 	</div> -->

	<!-- <table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<td width="5%" class="TITLE" align="center">
			<img src="../../hisglobal/images/plus.gif" id="plus2" 
			style="display: block; cursor: pointer;"
				onClick="disPreviousIssueDtl(),getPrevIssueDtl();"> 
			<img src="../../hisglobal/images/minus.gif" id="minus2" 
			style="display: none; cursor: pointer;"
				onClick="disPreviousIssueDtl1();"></td>
			<td colspan="3" class="TITLE"><b>Previous Issue Details</b></td>
		</tr>
	</table> -->
<!-- <div class='row'>
	<div class='col-sm-4'>
	<div class='row'>
	<div class='col-sm-1'>
	<button type="button" class="btn btn-info btn-sm" id="plus2"  style="display: none; cursor: pointer" onClick="disPreviousIssueDtl(),getPrevIssueDtl();"><i class="fas fa-plus"></i></button>
	<button type="button" class="btn btn-info btn-sm" id="minus2" style="display: block; cursor: pointer" onClick="disPreviousIssueDtl1();"><i class="fas fa-minus"></i></button>
	</div>
	<div class='col-sm-11 subHeaders' align="left">
	Patient	Issue Details
	</div>
	</div>	
	</div>
	</div>
	<div id="issueDtlDivId"></div></div> -->
	</div>
	</div>
<div class="prescriptionTile">
		<div id="reqDtlDivId" style="display: block;">
		<div class='row'>
		<div class='col-sm-4 subHeaders'>
		Request Details
		</div>
		</div>
		
		<div class='row'>
		<div class='col-sm-2'><label>Department</label>
		</div>
		<div class='col-sm-2'>
		<select id='dep' name="strDeptCode" class="form-control" onchange="getUnitCombo();">
		<bean:write name="issueBean" property="strDeptValues" filter="false" />
		</select>
		</div>
		<div class='col-sm-2'>
		<label>Unit</label>
		</div>
		<div class='col-sm-2'id="unitDivId"><select id='unit' name="strUnitCode" class="form-control" onchange="getConsultantCombo();">
		<option value="0">Select Value</option>
		<bean:write name="issueBean" property="strUnitValues" filter="false" />
		</select>
		</div>
		<div class='col-sm-2'>
		<label>Prescribed By</label>
		</div>
		<div class='col-sm-2' id="consultantDivId">
		<select name="strPrescribedBy" class="form-control">
		<option value="0">Select Value</option>
		</select>
		</div>		
		</div>
			<div class='row'>
		<div class='col-sm-2'>
		<label>Prescribed For</label></div>
		<div class='col-sm-2'>
		<input type="text" class="form-control" name="strPrescribedFor" maxlength="3" placeholder='Days'
					onkeypress="return validateData(event,5);">
		</div>
		<div class='col-sm-2'>
		<label>Prescription	Date</label>
		</div>
		<div class='col-sm-2'>
		<input class='form-control datepicker' name="strPrescriptionDate" value="${issueBean.strCtDate}">
		</div>
		<div class='col-sm-2'>
		<label>
		Prescription From
		</label>
		</div>
		<div class='col-sm-2'>
		<select	name="strPrescriptionFrom" class="form-control">
		<option value="2">Emergency</option>
		<option value="3">OPD</option>
		<option value="1">IPD</option>
		<option value="4">Special Clinic</option>
		</select>
		</div>		
		</div>
		<!-- <table class="TABLEWIDTH" align="center" cellspacing="1px"
			cellpadding="1px">

			 <tr>
				<td class="TITLE" colspan="4">Request Details</td>
			</tr>  -->

			<%-- <tr>
				<td class="LABEL" width="25%"><font color="red">*</font>Department</td>
				<td class="CONTROL" width="25%"><select id='dep' name="strDeptCode"
					class="comboNormal" onchange="getUnitCombo();">
					<bean:write name="issueBean" property="strDeptValues"
						filter="false" />
				</select></td>
				<td width="25%" class="LABEL"><font color="red">*</font>Unit</td>
				<td width="25%" class="CONTROL">
				<div id="unitDivId"><select id='unit' name="strUnitCode"
					class="comboNormal" onchange="getConsultantCombo();">
					<option value="0">Select Value</option>
					<bean:write name="issueBean" property="strUnitValues"
						filter="false" />
				</select></div>
				</td>
			</tr> --%>
			<%-- <tr>
				<td width="25%" class="LABEL">Prescribed
				By</td>
				<td width="25%" class="CONTROL">
				<div id="consultantDivId"><select name="strPrescribedBy"
					class="comboNormal">
					<option value="0">Select Value</option>
				</select></div>
				</td>
				<td width="25%" class="LABEL">Prescribed
				For</td>
				<td width="25%" class="CONTROL"><input type="text"
					class="txtFldMin" name="strPrescribedFor" maxlength="3"
					onkeypress="return validateData(event,5);">Days</td>

			</tr>
			<tr>
				<td width="25%" class="LABEL">Prescription
				Date</td>
				<td width="25%" class="CONTROL"><date:date name="strPrescriptionDate"
					value="${issueBean.strCtDate}"></date:date></td>

				<td width="25%" colspan="1" class="LABEL">Prescription
				From</td>
				<td width="25%" colspan="1" class="CONTROL"><select
					name="strPrescriptionFrom" class="comboNormal">
					<option value="2">Emergency</option>
					<option value="3">OPD</option>
					<option value="1">IPD</option>
					<option value="4">Special Clinic</option>
				</select></td>
			</tr>
 
		</table>--%>
		</div>
		<div id="itemDtlOffDivId" style="display: block">
		
		<!-- <table class="TABLEWIDTH" align="center" cellspacing="1px"
			cellpadding="1px">
			<tr>
				<td class='TITLE' colspan='5'><div align="right"><img style="cursor: pointer;height: 20px"
					id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"
					onclick='getItemSelectPopup();' name="searchName"
					title="Click here to Search Item"></div></td>
			</tr>
			<tr>
				<td colspan="5" bgcolor="black"></td>
			</tr>
			
		</table> -->
		<div class='row'>
		<div class='col-sm-10'></div>
		<div class='col-sm-2' align="right">
		<!-- <img style="cursor: pointer;height: 20px"
					id='strSearchItemButtonDivId' data-toggle="modal" data-target="#tariffDtlsModal" src="../../hisglobal/images/ItemFinder.png"
					onclick='getItemSelectPopup();' name="searchName"
					title="Click here to Search Item">	 -->
		<button type="button" class="btn btn-info btn-sm" id='strSearchItemButtonDivId' data-toggle="modal" data-target="#tariffDtlsModal" onclick='getItemSelectPopup();'>Item Finder</button>			
						</div>
		
		</div>
		<table cellspacing="1px" class="table"	cellpadding="0px" cellpadding="1px">

			<thead>
				<th width="45%" align="left">Item Name</th>
				<th width="10%" align="left">Batch No</th>
				<th width="10%" align="right">Avl Qty</th>
				<th width="10%" align="right"><font color="red">*</font>Cost/Unit</th>
				<th width="10%" align="right"><font color="red">*</font>Quantity</th>
				<th width="10%" align="right"><font color="red">*</font>Cost</th>
				<th width="5%">-</th>
			</thead>
		</table>

		<div id="id1"></div>
		<br>
		<div class='row'>
		<div class='col-sm-9'></div>
		<div class='col-sm-1'>
		<label><font color="red"><b>Net Cost</b></font></label>
		
		</div>
		<div class='col-sm-2' style='color: red;' id="strNetCost"></div>
		</div>
          <!-- <table cellspacing="1px" class="TABLEWIDTH" align="center"
			cellpadding="0px" cellpadding="1px">

			<tr>
				<td class="" width="85%" align="right"></td>
				<td class="" width="15%" align="right"><div id="strNetCost"></div></td>
				
			</tr>
		</table> -->
		
		<!-- <table cellspacing="1px" class="TABLEWIDTH" align="center"
			cellpadding="1px">
			<tr>
				<td colspan="5" bgcolor="black"></td>
			</tr>
			<tr class="FOOTER">
				<td colspan="5"></td>
			</tr>
		</table> -->
		</div>
<br>
<div class='row'>
<div class='col-sm-2'>
<label>Receive	By</label>
</div>
<div class='col-sm-2'>
<input type="text" class="form-control" name="strReceiveBy" onkeypress="return validateData(event,11);">
</div>
<div class='col-sm-2'>
<label>Remarks</label>
</div>
<div class='col-sm-6'>
<textarea name="strRemarks" class='form-control'	cols="25" rows="2" onkeypress="return validateData(event,9);"></textarea>
</div>
</div>

	<!-- <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr>
			<td colspan="2" class="LABEL"><font color="red">*</font>Receive	By</td>
			
			<td colspan="2" class="CONTROL"><input type="text"
				class="txtFldMax" name="strReceiveBy" onkeypress="return validateData(event,11);">

				</td>
		</tr>

		<tr>
			<td class="LABEL" colspan="2">Remarks</td>
			<td class="CONTROL" colspan="2"><textarea name="strRemarks"	cols="25" rows="2" onkeypress="return validateData(event,9);"></textarea></td>
		</tr>
	</table> -->

	<!-- <table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="FOOTER">
			<td colspan="4"><font color="red">*</font> Mandatory Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td align="center">
			<img style=" cursor: pointer"
				src="../../hisglobal/images/btn-sv.png"
				onclick="return validateIssue();" /> <img
				style=" cursor: pointer"
				src="../../hisglobal/images/btn-clr.png" onClick="clearIssue();">
			<img style=" cursor: pointer"
				src="../../hisglobal/images/back_tab.png" onClick="controlToIssueToPatientPage();">
				<br>
				<a href="#" class="button" id="" onclick=' return validateIssue();'><span class="save">Save</span></a>
				<a href="#" class="button"	onclick="clearIssue();"><span class="clear">Clear</span></a> 
				<a href="#" class="button" onclick="controlToIssueToPatientPage();"><span class="cancel">Cancel</span></a>
			</td>

		</tr>
	</table> -->
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strUpdateFlag" value="" />
	
	<input type="hidden" name="storeName" value="${issueBean.storeName}" />
	<input type="hidden" name="itemCatName"
		value="${issueBean.itemCatName}" />
	<input type="hidden" name="crNo" value="${issueBean.crNo}" />
	<input type="hidden" name="strId" value="${issueBean.strId}" />
	<input type="hidden" name="itemCategory"
		value="${issueBean.itemCategory}" />
	<input type="hidden" name="strConfCatCode"
		value="${issueBean.strConfCatCode}" />
	<input type="hidden" name="strIssueNo" value="${issueBean.strIssueNo}" />
	<input type="hidden" name="strIssueDtl"
		value="${issueBean.strIssueDtl}" />
	<input type="hidden" name="disFlag" value="${issueBean.disFlag}" />
	<input type="hidden" name="mode" value="${issueBean.strMode}" />
	<input type="hidden" name="strMode" value="${issueBean.strMode}">
	<input type="hidden" name="strIssueMode"
		value="${issueBean.strIssueMode}">
	<input type="hidden" name="strCtDate" value="${issueBean.strCtDate}" />
	<input type="hidden" name="strVisitDtl" value="${issueBean.strVisitDtl}" />
	<input type="hidden" name="strIssueNum" value="${issueBean.strIssueNum}" />
	<input type="hidden" name="isUpdateOpdDrugReq" value="" />
	<input type="hidden" name="strGlobalval" value="" />
	<input type="hidden" name="strErrMsg" value="${issueBean.strErrMsg}" />
		<input type="hidden" name="strBillingHiddenValue" value="${issueBean.strBillingHiddenValue}" />
	<input type="hidden" name="strTariff_Flag" value="1" />
	

	<cmbPers:cmbPers />
<!-- 	<div id="blanket" style="display: none;"></div>

	<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			<div id="searchItemsDtlsDivId" style="display: block;"></div>
			<div id="stockDtlsDivId" style="display: block;"></div>

			</td>
		</tr>
	</table>
	</div> -->
	
	
	<div class='modal' id='tariffDtlsModal' tabindex='-1' role='dialog' aria-labelledby='tariffDtlsModalLabel' aria-hidden='true'>
				<div class='modal-dialog modal-lg'  role='document' style="max-width: 1000px;">
					<div class='modal-content animate-bottom'>
						
						<div class='modal-body' id=''>
                             <div id="searchItemsDtlsDivId" style="display:block;"></div>
						</div>
						<div class="modal-footer" style="padding: 0.5rem;">
        <button type="button" class="btn btn-success" onkeypress='createSelectedList();'  onClick='createSelectedList();' data-dismiss="modal" style="padding: 0.175rem 0.75rem;">Ok</button>
        <button type='button' class='btn btn-danger' data-dismiss='modal' style="padding: 0.175rem 0.75rem;">Cancel</button>
      </div>
					</div>
				</div>
			</div>
<div class="popUpDiv" id="popUpDiv1" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
						
				<div id="issueDtlsDivId" style="display: block;"></div>
		
			</td>
		</tr>
	</table>
	</div>
	

</div>
</fieldset>
</html:form>
<jsp:include page="issue_trans_search_rowNewBS.jsp"></jsp:include>
<script>
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
<style>
.form-control-sm
{
width: 80px;
}
</style>   
</body>
</html>