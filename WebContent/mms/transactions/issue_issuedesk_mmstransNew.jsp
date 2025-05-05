<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--
Developer : Anshul Jindal
  Version : 1.0 
  Date : 11/June/2009
   Module:MMS
  Unit:Issue Desk Transaction
    -->
    
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>

<html>
<head>
<meta charset=UTF-8">
<title>Issue Indent</title>

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

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script> 
<script language="Javascript" src="../js/itemparameterdetails_util.js"></script> 
<script language="Javascript" src="../js/issuedesk_trans.js"></script>
<script type="text/javascript">

/**
	  This function is used to set condition during change of name of reciever.
**/
function checkValCombo(){
	var recievedByName=document.forms[0].strReceivedComboBy[document.forms[0].strReceivedComboBy.selectedIndex].text;
	if(document.forms[0].strReceivedComboBy[document.forms[0].strReceivedComboBy.selectedIndex].text=='Other' ){
		
		document.getElementById("labelId").className="LABEL";
		document.getElementById("labelNameId").innerHTML="";
		document.getElementById("nameOtherFld").style.display="block";
		if(document.forms[0].strReceivedBy.readOnly)
			document.forms[0].strReceivedBy.readOnly=false;
		document.forms[0].strReceivedBy.value="";
		document.getElementById("labelNameId").innerHTML="<font color='red'>*</font>Name of the Receiver";
		document.forms[0].strReceivedBy.focus();
	
	}else if(document.forms[0].strReceivedComboBy.value!="0" && document.forms[0].strReceivedComboBy.value!="1"){
		
		document.getElementById("labelId").className="LABEL";
		
		document.getElementById("labelNameId").innerHTML="";
		document.getElementById("nameOtherFld").style.display="block";
		document.getElementById("labelNameId").innerHTML="Name of the Receiver";
		document.forms[0].strReceivedBy.value=recievedByName;
		if(!document.forms[0].strReceivedBy.readOnly)
			document.forms[0].strReceivedBy.readOnly=true;
		document.getElementsByName("strRemarks")[0].focus();
		
		
	}else{
		document.getElementById("labelId").className="CONTROL";
		document.getElementById("nameOtherFld").style.display="none";
		document.getElementById("labelNameId").innerHTML="";
	}
}

function hidePopup() {

	hide_popup('popUpDiv');

}
</script>

<style>
	.example {
		page-break-after: always;
	}
	 
	 textarea.form-control1 {
		height: 30px;
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
	    top: 0.5em;
	    right: 44px;
	    line-height: 1.2em;
	}
	.table .thead-dark {
	  	color: #000 !important;
	  	border: none !important;
	  	background:linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;
	}
	.thead-dark th{
		background:none !important;
		border: none !important;
		padding: 0.25rem;
	    text-align: center;	
	}	
</style>

</head>
<body   onload="getReport();">
<html:form name="issueDeskTransBean" action="/transactions/IssueDeskTransBSCNT" type="mms.transactions.controller.fb.IssueDeskTransFB">
		<div id="errMsg" class="errMsg">
			<bean:write name="issueDeskTransBean" property="strErr" />
		</div>
		<div class="warningMsg">
			<bean:write name="issueDeskTransBean" property="strWarning" />
		</div>
		<div id="normalMsg" class="normalMsg">
			<bean:write name="issueDeskTransBean" property="strNormalMsg" />
		</div>
		
<div class="container-fluid">
	<div class="prescriptionTile">
		<div class='legendHeader my-2' id='nonPrintableLegend' style="font-weight:600;font-size: 22px;" >Issue Desk</div>
				
				<div class="legend2" id="saveId">
					<button id="cancelButton" type="button"
						class="float-right btn btn-danger mt-1 btn-circle cancelbtn"
						onclick="cancel();" style="border-radius: 50%; padding: 12px 12px"
						title="Cancel">
						<i class="fas fa-times fa-lg iround" title="Cancel"></i>
					</button>

					<!-- 	<button type="button" class=" btn btn-secondary btn-circle" onClick="document.forms[0].reset();clearPage();" style="background: #b9b9b9; border-color:#b9b9b9;margin-top: 0.25rem !important;">
					<img  src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 23px; color: #fff;">
					</button> -->

					<button type="button"
						class="float-right btn btn-secondary btn-circle"
						onclick="document.forms[0].reset();clearPage();"
						style="border-radius: 50%; padding: 12px 7px; background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;"
						title="Clear">
						<i class="fas fa-broom fa-lg iround" title="Clear"></i>
					</button>

					<button type="button" id="savebutton"
						class="float-right btn btn-success mt-1 btn-circle" tabindex='2' id="submitId"
						onClick="return validate1();" name="patientAdmissionModiTransBean"
						style="border-radius: 50%; padding: 12px 12px" data-toggle="" data-target="#previewModal">
						<i class="fa fa-save fa-lg iround" title="Save"></i>
					</button>
				</div> 
			  	<div class='popup' id='avalaibleBudgetDtlId' style="display: none">
					<table width='400' border="0" cellspacing="1" cellpadding="1">
						<tr class="HEADER">
							<td colspan='3'>Budget Details</td>
							<th align='right'><img style='cursor: pointer; '
								src='../../hisglobal/images/popUp_cancel.JPG' title='Click to Close Pop-Up'
								onClick="hideBalQtyDetails('avalaibleBudgetDtlId');"></th>
						</tr>
					</table>
					<table width='400' border="0" cellspacing="1" cellpadding="1">
						<tr>
							<td colspan="1" class='multiLabel'>Budget Allocated</td>
							<td colspan="1" class='multiLabel'>Budget Consumed</td>
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

<%-- 
<tag:tab tabLabel="Issue Desk"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab> --%>
			
				<div class='row'>
					<div class='col-sm-2'>
					<label>Store Name</label>
					</div>
					<div class='col-sm-2' style='font-weight: 400;'>
					<bean:write name="issueDeskTransBean" property="strStoreName" />
					</div>
				</div>
				
				<div class="row">
					<div class="col" style="font-size:20px;"><label>Request Details</label></div>
				</div>
			<div class="container">
				<div class='row' style="margin:1% 8%;">
					<div class='col-sm-3'>
						<label>Request No.</label>
					</div>
					
					<div class='col-sm-3' style='font-weight: 400;'>
						<bean:write name="issueDeskTransBean" property="strIndentNo" />
					</div>
					<div class='col-sm-3'>
						<label>Request Date</label>
					</div>
					<div class='col-sm-3' style='font-weight: 400;'>
						<bean:write name="issueDeskTransBean" property="strIndentDate" />
					</div>
					
				</div>

				<div class='row' style="margin:1% 8%;">
					<div class='col-sm-3'>
						<label>Item Category</label>
					</div>
					<div class='col-sm-3' style='font-weight: 400; '>
						<bean:write name="issueDeskTransBean" property="strItemCategory" />
					</div>
					
					<div class='col-sm-3'>
						<label>Raising Store</label>
					</div>
					<div class='col-sm-3' style='font-weight: 400; ' align="left">
						<bean:write name="issueDeskTransBean" property="strRaisingStoreName" />
					</div>
				</div>
				
				<div class='row' style="margin:1% 8%;">
					<div class='col-sm-3'>
						<label>Req. Status</label>
					</div>
					<div class='col-sm-3' style='font-weight: 400; ' align="left">
						<bean:write name="issueDeskTransBean" property="strReqStatusName" />
					</div>
					<div class='col-sm-3' style='display:none;' id="budgetIDOne">
						<label>Budget Avl.</label>
					</div>
					<div class='col-sm-3' style='font-weight: 400; color: blue;' align="left" id="budgetIDTwo">
						<a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='avlBudgetDtl(this);' TITLE='Click Here Get Budget Details' >			
						<bean:write name="issueDeskTransBean" property="strAvalaibleBudget" />
						</a>
					</div>
				</div>
				
				<div class='row' style="margin:1% 8%;">
					<div class='col-sm-3'>
						<label>Remarks from Indenting Store</label>
					</div>
					<div class='col-sm-3' style='font-weight: 400; ' >
						<bean:write name="issueDeskTransBean" property="strRemarksIndent" />
					</div>
					<div class='col-sm-3' >
						<label>Remarks from Last Approval</label>
					</div>
					<div class='col-sm-3' style='font-weight: 400; ' >
						<bean:write name="issueDeskTransBean" property="strRemarksApptwo" />
					</div>
				</div> 
			</div>
			
			<div class='row'>
				<div class='col' style="font-size:20px;"><label>Item Detail(s)</label></div>
			</div>

	<%-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" border="0" >

		<tr class="HEADER">
		
			<td colspan="4"></td>
		</tr>

		<tr>
			<td class="LABEL" width="50%" colspan="2">Store Name</td>
			<td width="50%" class="CONTROL" colspan="2"><bean:write name="issueDeskTransBean" property="strStoreName" /></td>

		</tr>
		<tr>
			
			 <td  colspan="4" class="TITLE" >
				<div id="PlusDivId" align="left" style="display:none;">
					<img src="../../hisglobal/images/plus.gif" title='Show Details'
									onClick="clickPlus();" style="cursor: pointer; "/>
						Request Details
					</div>
					<div id="MinusDivId" style="display:block;" align="left">
						<img src="../../hisglobal/images/minus.gif"  title='Hide Details'
								onClick="clickMinus();" style="cursor: pointer; "/>
								Request Details
					</div>
					</td>
		</tr>
			</table> --%>
			<%-- div id="ReqDtlsDiv">
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" border="0" style="">
		
		<tr>
				<td  class="LABEL">Request No.</td>
				<td  class="CONTROL"><bean:write name="issueDeskTransBean" property="strIndentNo" /></td>
					<td  class="LABEL">Request Date</td>
				<td  class="CONTROL"><bean:write name="issueDeskTransBean" property="strIndentDate" /></td>
			</tr>
			<tr>
					<td  class="LABEL">Item Category</td>
				<td  class="CONTROL"><bean:write name="issueDeskTransBean" property="strItemCategory" /></td>
					<td class="LABEL" >Raising Store</td>
			<td  class="CONTROL"><bean:write name="issueDeskTransBean" property="strRaisingStoreName" /></td>
		</tr>
			<tr>
			<td class="LABEL" >Req. Status </td>
			<td  class="CONTROL" ><bean:write name="issueDeskTransBean" property="strReqStatusName" /></td>
			<td class="LABEL" ><div style='display:none;' id="budgetIDOne">Budget Avl.</div></td>
			<td  class="CONTROL" >
			<div id="budgetIDTwo">
			   <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='avlBudgetDtl(this);' TITLE='Click Here Get Budget Details' >			
			<bean:write name="issueDeskTransBean" property="strAvalaibleBudget" /></a></div>
			</td>
		</tr>
		<tr>
			<td class="LABEL" >Remarks from Indenting Store</td>
			<td  class="CONTROL" ><bean:write name="issueDeskTransBean" property="strRemarksIndent" /></td>
			<td class="LABEL" >Remarks from Last Approval</td>
			<td  class="CONTROL" ><bean:write name="issueDeskTransBean" property="strRemarksApptwo" /></td>
		</tr>
		</table>
		</div>
		
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" border="0">
		<tr class="TITLE">
			<td colspan="4"><div id='' style="font-family: Arial, Helvetica, sans-serif;font-size:13px;">Item Detail(s)</div></td>
		</tr>
		</table>
		 --%>
		 <logic:equal value="0" name="issueDeskTransBean" property="strBudgetFlg">
			<logic:equal value="10" property='strItemCategoryNo' name='issueDeskTransBean'>
				<table class="table">
					<thead class="thead-dark" align="center">	
						<tr>	
							<th width='30%' style="font-weight:350 !important ;font-size: 16px !important;">Item Name</th>
							<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">Item Type</th>
							<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">Ind.Str Qty.</th>
							<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">Avl. Qty.</th>
							<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">Req.Qty/Sanc.Qty</th>
							<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;"><font  color="red">*</font>Issue Qty.</th>
							<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;"><font  color="red">*</font>Batch</th>
							<th width='7%' title="Exp. Date" style="font-weight:350 !important ;font-size: 16px !important;">Exp. Date</th>
							<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;"><font  color="red">*</font>Unit</th>
							<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">Remarks</th>
							<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">LP Qty</th>	
							<!--   <td width="4%" title="Item Preferences">#</td> -->
						</tr>
					</thead>
				</table>
			</logic:equal>
			
			<logic:notEqual value="10" property='strItemCategoryNo' name='issueDeskTransBean'>
				<table class="table">
				<thead class="thead-dark" align="center">	
					<tr>
						<th width='30%' style="font-weight:350 !important ;font-size: 16px !important;">Item Name</th>
						<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">Item Type</th>
						<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">Bal Qty.</th>
						<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">Avl. Qty.</th>
						<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">Req.Qty/Sanc.Qty</th>
						<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;"><font  color="red">*</font>Issue Qty.</th>
						<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;"><font  color="red">*</font>Batch</th>
						<th width='7%' title="Exp. Date" style="font-weight:350 !important ;font-size: 16px !important;">Exp. Date</th>
						<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;"><font  color="red">*</font>Unit</th>
						<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">Remarks</th>
						<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">LP Qty</th>	
						<!--   <td width="4%" title="Item Preferences">#</td> -->
					</tr>
				</thead>
				</table>
			</logic:notEqual>
			
			<div id="itemDtlsDiv"><bean:write name="issueDeskTransBean" property="strItemDtls" filter="false"></bean:write></div>
			<input type="hidden" value="0.00" name="strApproxAmtDivId" id="strApproxAmtDivId" >
			<input type="hidden" name="strFinalApproxAmt">
		</logic:equal>
		<logic:equal value="1" name="issueDeskTransBean" property="strBudgetFlg">
			<logic:equal value="10" property='strItemCategoryNo' name='issueDeskTransBean'>
				<table class="table">
				<thead>	
					<tr>	
					<th width='30%' style="font-weight:350 !important ;font-size: 16px !important;">Item Name</th>
					<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">Issue/Receiving Store Qty.</th>
					<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">Req.Qty/Sanc.Qty</th>
					<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;"><font  color="red">*</font>Issue Qty.</th>
					<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;"><font  color="red">*</font>Batch</th>
					<th width='7%' title="Exp. Date" style="font-weight:350 !important ;font-size: 16px !important;">Exp. Date</th>
					<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;"><font  color="red">*</font>Unit</th>
					<!--   <th width="4%" title="Item Preferences">#</th> -->				
					<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">Cost</th>	
					<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">Remarks</th>
					<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">LP Qty</th>				
					</tr>
				</thead>
				</table>
			</logic:equal>
			
			<logic:notEqual value="10" property='strItemCategoryNo' name='issueDeskTransBean'>
				<table class="table">
				<thead>	
				<tr>	
					<th width='30%' style="font-weight:350 !important ;font-size: 16px !important;">Item Name</th>
					<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">Issue/Receiving Store Qty.</th>
					<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">Req.Qty/Sanc.Qty</th>
					<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;"><font  color="red">*</font>Issue Qty.</th>
					<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;"><font  color="red">*</font>Batch</th>
					<th width='7%' title="Exp. Date" style="font-weight:350 !important ;font-size: 16px !important;" >Exp. Date</th>
					<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;"><font  color="red">*</font>Unit</th>
					<!--   <th width="4%" title="Item Preferences">#</th> -->				
					<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">Cost</th>	
					<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">Remarks</th>
					<th width='7%' style="font-weight:350 !important ;font-size: 16px !important;">LP Qty</th>			
				</tr>
				</thead>
				</table>
			</logic:notEqual>
			
			<div id="itemDtlsDiv"><bean:write name="issueDeskTransBean" property="strItemDtls" filter="false"></bean:write></div>		
		
			<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
				<tr>
					<td width="80%" class="LABEL">Total Approx Cost(Rs):</td>
					<td width="18%" class="CONTROL" style="color: red; font-weight: bold;text-align:left;">
		    	<!--<input type="text" style="color: red; font-weight: bold"  disabled="disabled" class="txtFldNormal"  value="0.00" name="strApproxAmtDivId" id="strApproxAmtDivId" >
					<input type="hidden" name="strFinalApproxAmt"></td>  -->	
				</tr>
			</table>
			
			<input type="hidden" value="0.00" name="strApproxAmtDivId" id="strApproxAmtDivId" >
			<input type="hidden" name="strFinalApproxAmt">
		</logic:equal>
<br>
		<div class="container">
			<div class='row my-1' style="margin:1% 8%;">
				<div class='col-sm-2'>
					<label>Raise LP Indent</label>
				</div>
				<div class='col-sm-2'>
					<input type="radio" name="strBSIndent" onchange='chkradio(this);' value="1"  />&nbsp;&nbsp;<label>Yes</label> 
					<input type="radio" name="strBSIndent" onchange='chkradio(this);' value="0" checked/>&nbsp;&nbsp;<label>No</label> 
				</div>
				
				<div class='col-sm-2'>
					<label>Received By</label>
				</div>
				<div class='col-sm-2'>
				  	<select name="strReceivedComboBy" onchange="checkValCombo();" class="form-control">
				   		<bean:write name="issueDeskTransBean" property="strReceivedByOptionVal" filter="false"/>
					</select>
				</div>
				
				<div class='col-sm-2' id='labelId'>
					<div id='labelNameId'></div>
				</div>
				<div id="nameOtherFld" class='col-sm-2' style="display: none">
			    	<input type='text' class='form-control' name='strReceivedBy' value='' onkeypress='return validateData(event,16);' maxlength='50'>
			    </div>
			</div>	
			
			<div class='row my-1' style="margin:1% 8%;">
			    <div class='col-sm-2'>
					<label>Remarks</label>
				</div>
				<div class='col-sm-10'>
			  		<textarea class='form-control' name="strRemarks" rows="2" onkeypress="return validateData(event,9);"></textarea>
				</div>
			</div>
		</div>
				
		<%-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" border="0">
		<!-- <tr class="TITLE">
			<td colspan="4"></td>
		</tr> -->
		<tr >
    		<td width ="50%" class ="LABEL" valign="middle" colspan="2">Raise LP Indent</td>
    		<td width ="50%" class ="CONTROL" colspan="2">
					<input type="radio" name="strBSIndent" onchange='chkradio(this);' value="1"  />Yes &nbsp;&nbsp;
	 			 	<input type="radio" name="strBSIndent" onchange='chkradio(this);' value="0" checked/>No</td>
  		</tr>
		<tr>
           <td width ="25%%" class ="LABEL" valign="middle" ><font color="red">*</font>Received By</td>
           <td width ="25%" class ="CONTROL">
    
            <select name="strReceivedComboBy" onchange="checkValCombo();" class="comboNormal">
               	<bean:write name="issueDeskTransBean" property="strReceivedByOptionVal" filter="false"/>
               </select>
               
            </td>
            <td class="CONTROL"  id='labelId'>
            	<div id='labelNameId'></div>
   </td>
    <td class="CONTROL" >
            	<div id="nameOtherFld" style="display: none">
            		<input type='text' name='strReceivedBy' value='' onkeypress='return validateData(event,16);' maxlength='50'>
            	</div>
            </td>
  </tr>
			<tr >
    <td width ="50%" class ="LABEL" valign="middle" colspan="2">Remarks</td>
    <td width ="50%" class ="CONTROL" colspan="2">
    <textarea  name="strRemarks" cols="25" rows="2" onkeypress="return validateData(event,9);"></textarea></td>
  </tr>
		<tr class="FOOTER">
			 <td  colspan="4"><font id='manFld'>[ InHand Qty Less than Re-Order Level ]</font>&nbsp;&nbsp;&nbsp;<font  color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table> --%>
	<!-- <table border="0" class="TABLEWIDTH" align="center">
	<tr id="saveId">
	  <td align="center">
		<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" onClick=" return validate1();" title="Save Record"/> 
		<img style="cursor: pointer; " title="Clear Content" src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset();clearPage();" />
		<img style="cursor: pointer;" title="Click Here Go Back  To Main Desk" src="../../hisglobal/images/back_tab.png" onClick="cancel();" />
	  </td>
	</tr>
	</table> -->
	<!-- <br>
	<div align="center" id="saveId">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onClick="document.forms[0].reset();clearPage();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancel();"><span class="cancel">Cancel</span></a>
					</div>  -->
	
				<div id="blanket" style="display:none;"></div>
				
				<div class="popUpDiv" id="popUpDiv" style="display:none;">
					<table bgcolor="white">
						<tr>
							<td>
								<div id="stockDtlsDivId" style="display:block;"></div>
								<div id="itemOtherDtlsDiv" style="display:block;" class="popup" ></div>
								<div id="issueDtlsDivId" style="display:block;"></div>
							</td>
						</tr>
					</table>
				</div>

<input type="hidden" name="hmode"/>
<input type="hidden" name="strStoreName" value="${issueDeskTransBean.strStoreName}"/>
<input type="hidden" name="strStoreId" value="${issueDeskTransBean.combo[0]}"/>
<input type="hidden" name="strIssueNo" value="${issueDeskTransBean.strIssueNo}"/>
<input type="hidden" name="strIndentNo" value="${issueDeskTransBean.strIndentNo}"/>
<input type="hidden" name="strIndentDate" value="${issueDeskTransBean.strIndentDate}"/>
<input type="hidden" name="strItemCategoryNo" value="${issueDeskTransBean.strItemCategoryNo}"/>
<input type="hidden" name="strRaisingStoreId" value="${issueDeskTransBean.strRaisingStoreId}"/>
<input type="hidden" name="strReOrderFlgColor" value="${issueDeskTransBean.strReOrderFlgColor}"/>
<input type="hidden" name="strBudgetFlg" value="${issueDeskTransBean.strBudgetFlg}"/>
<input type="hidden" name="strAvalaibleBudgetDtl" value="${issueDeskTransBean.strAvalaibleBudgetDtl}"/>
<input type="hidden" name="strChk" value="${issueDeskTransBean.strChk}"/>
<input type="hidden" name="strAvalaibleBudget" value="${issueDeskTransBean.strAvalaibleBudget}"/>
<input type="hidden" name="searchColumn" value='<%=request.getParameter("searchColumn") %>' />
<input type="hidden" name="search" value='<%=request.getParameter("search") %>' />
<input type="hidden" name="blockNo" value='<%=request.getParameter("blockNo") %>' />
<input type="hidden" name="prevNext" value='<%=request.getParameter("prevNext") %>' />
<input type="hidden" name="rowNum" value='<%=request.getParameter("rowNum") %>'/>
<input type="hidden" name="divisionId" value='<%=request.getParameter("divisionId") %>' />

<cmbPers:cmbPers/>
</div>
</div>

</html:form>

<div class="popup" id="popup" style="display: none"></div>
<%-- 	<tag:autoIndex></tag:autoIndex>   --%>
</body>
</html>