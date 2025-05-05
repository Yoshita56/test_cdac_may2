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


<html>
<head>
<meta charset=UTF-8">
<title>Issue To Patient Process</title>
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
<script language="Javascript" src="../js/issue_trans.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
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
</head>
<body onload="onCheckCategory();chkVisitDtl();getReport();">


<html:form name="issueBean" action="/transactions/IssueTransCNT"
	type="mms.transactions.controller.fb.IssueTransFB">

	<div id="errMsg" class="errMsg"><bean:write name="issueBean"
		property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="issueBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="issueBean" property="strNormalMsg" /></div>


	<logic:equal value="0" name="issueBean" property="strMode">

		<tag:tab tabLabel="Issue To Patient" selectedTab="FIRST"
			align="center" width="TABLEWIDTH">
		</tag:tab>
		<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4">Issue To Patient&gt;&gt;</td>
			</tr>
		</table>

	</logic:equal>

	<logic:equal value="1" name="issueBean" property="strMode">
		<tag:tab tabLabel="Issue To Staff" selectedTab="FIRST" align="center"
			width="TABLEWIDTH">
		</tag:tab>
		<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4">Issue To Staff&gt;&gt;</td>
			</tr>
		</table>
	</logic:equal>


	<logic:equal value="2" name="issueBean" property="strMode">
		<tag:tab tabLabel="Issue To Patient/Staff" selectedTab="FIRST"
			align="center" width="TABLEWIDTH">
		</tag:tab>
		<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4">Issue To Patient/Staff&gt;&gt;</td>
			</tr>

		</table>

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
	</table>
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
 
<div id="allDivId" style="display: block;">
	<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
		<tr>
			<td width="5%" class="TITLE" align="center"><img
				src="../../hisglobal/images/plus.gif" id="plus1"
				style="display: block; cursor: pointer" onClick="getPatDtl();">
			<img src="../../hisglobal/images/minus.gif" id="minus1"
				style="display: none; cursor: pointer" onClick="getPatDtl1();"></td>

			<td colspan="3" class="TITLE" align="left"><b>Patient
			Demographic Detail</b></td>
		</tr>
	</table>

	<div id="patientDetailsDivId" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<bean:write name="issueBean" property="strPatientDetails"
				filter="false" />
		</tr>
	</table>
	</div>
	
	<div id="diagDivId" style="display: block;">
	<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
		<tr>
			<td width="5%" class="TITLE" align="center"><img
				src="../../hisglobal/images/plus.gif" id="plus4"
				style="display: none; cursor: pointer" onClick="getPatDiagDtl();">
			<img src="../../hisglobal/images/minus.gif" id="minus4"
				style="display: block; cursor: pointer" onClick="getPatDiagDtl1();"></td>

			<td colspan="3" class="TITLE" align="left"><b>Patient
			Diagnosis Detail</b></td>
		</tr>
	</table>

	<div id="patientDiagDetailsDivId" style="display: block;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<bean:write name="issueBean" property="strPatientDiagDetails"
				filter="false" />
		</tr>
	</table>
	</div>

<div style=''>
 <table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
		<tr>
			<td width="5%" class="TITLE" align="center"><img
				src="../../hisglobal/images/plus.gif" id="plus3"
				style="display: block; cursor: pointer" onClick="getPatTrtDtl();">
			<img src="../../hisglobal/images/minus.gif" id="minus3"
				style="display: none; cursor: pointer" onClick="getPatTrtDtl1();"></td>

			<td colspan="3" class="TITLE" align="left"><b>Patient
			Treatment Detail</b></td>
		</tr>
	</table>
	<div id="patientTreatmentDetailsDivId" style="">
		<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
			<tr>
				<bean:write name="issueBean" property="strPatientTreatmentDtl"
					filter="false" />
			</tr>
		</table>		
	
	</div>

	<table class="TABLEWIDTH" align="center" cellspacing="1px">
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
	</table>

	<div id="issueDtlDivId"></div></div>



		<div id="reqDtlDivId" style="display: block;">
		<table class="TABLEWIDTH" align="center" cellspacing="1px"
			cellpadding="1px">

			<tr>
				<td class="TITLE" colspan="4">Request Details</td>
			</tr>

			<tr>
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
			</tr>
			<tr>
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

		</table>
		</div>
		<div id="itemDtlOffDivId" style="display: block">
		<table class="TABLEWIDTH" align="center" cellspacing="1px"
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
			
		</table>
		<table cellspacing="1px" class="TABLEWIDTH" align="center"
			cellpadding="0px" cellpadding="1px">

			<tr>
				<td class="multiLabel" width="20%">Item Name</td>
				<td class="multiLabel" width="15%">Batch No</td>
				<td class="multiLabel" width="15%">Avl Qty</td>
					<td class="multiLabel" width="15%"><font color="red">*</font>Cost/Unit</td>
				<td class="multiLabel" width="15%"><font color="red">*</font>Quantity</td>
				<td class="multiLabel" width="15%"><font color="red">*</font>Cost</td>
				<td class="multiLabel" width="5%">-</td>
			</tr>
		</table>

		<div id="id1"></div>
		
          <table cellspacing="1px" class="TABLEWIDTH" align="center"
			cellpadding="0px" cellpadding="1px">

			<tr>
				<td class="" width="85%" align="right"><font color="red"><b>Net Cost</b></font></td>
				<td class="" width="15%" align="right"><div id="strNetCost"></div></td>
				
			</tr>
		</table>
		
		<table cellspacing="1px" class="TABLEWIDTH" align="center"
			cellpadding="1px">
			<tr>
				<td colspan="5" bgcolor="black"></td>
			</tr>
			<tr class="FOOTER">
				<td colspan="5"></td>
			</tr>
		</table>
		</div>


	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
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
	</table>
</div>
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="FOOTER">
			<td colspan="4"><font color="red">*</font> Mandatory Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td align="center">
			<!--<img style=" cursor: pointer"
				src="../../hisglobal/images/btn-sv.png"
				onclick="return validateIssue();" /> <img
				style=" cursor: pointer"
				src="../../hisglobal/images/btn-clr.png" onClick="clearIssue();">
			<img style=" cursor: pointer"
				src="../../hisglobal/images/back_tab.png" onClick="controlToIssueToPatientPage();">-->
				<br>
				<a href="#" class="button" id="" onclick=' return validateIssue();'><span class="save">Save</span></a>
				<a href="#" class="button"	onclick="clearIssue();"><span class="clear">Clear</span></a> 
				<a href="#" class="button" onclick="controlToIssueToPatientPage();"><span class="cancel">Cancel</span></a>
			</td>

		</tr>
	</table>
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
	<div id="blanket" style="display: none;"></div>

	<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			<div id="searchItemsDtlsDivId" style="display: block;"></div>
			<div id="stockDtlsDivId" style="display: block;"></div>

			</td>
		</tr>
	</table>
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
	

</html:form>
<jsp:include page="issue_trans_search_row.jsp"></jsp:include>
	   
</body>
</html>