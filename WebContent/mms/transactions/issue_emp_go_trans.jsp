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
<title>Issue Process</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">

<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../js/issue_trans_emp.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="Javascript" src="../js/stockDetails_util.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script>
<script type="text/javascript">

</script>
</head>
<body>


<html:form name="issueEmpBean" action="/transactions/IssueEmployeeTransCNT"
	type="mms.transactions.controller.fb.IssueEmployeeTransFB">

	<div id="errMsg" class="errMsg"><bean:write name="issueEmpBean"
		property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="issueEmpBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="issueEmpBean" property="strNormalMsg" /></div>



		<tag:tab tabLabel="Issue To Employee" selectedTab="FIRST"
			align="center" width="TABLEWIDTH">
		</tag:tab>
		<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4">Issue To Employee&gt;&gt;</td>
			</tr>
		
		<tr>
			<td width="25%" colspan="1" class="LABEL">Store Name</td>
			<td width="25%" colspan="1" class="CONTROL"><bean:write
				name="issueEmpBean" property="storeName" filter="false" /></td>

			<td width="25%" colspan="1" class="LABEL">Item Category</td>
			<td width="25%" colspan="1" class="CONTROL"><bean:write
				name="issueEmpBean" property="itemCatName" filter="false" /></td>
		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL">Employee No.</td>
			<td colspan="3" class="CONTROL"><bean:write name="issueEmpBean"
				property="empNo" filter="false" /></td>
		</tr>
	</table>


	<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
		<tr>
			<td width="5%" class="TITLE" align="center"><img
				src="../../hisglobal/images/plus.gif" id="plus1"
				style="display: block; cursor: pointer" onClick="getPatDtl();">
			<img src="../../hisglobal/images/minus.gif" id="minus1"
				style="display: none; cursor: pointer" onClick="getPatDtl1();"></td>

			<td colspan="3" class="TITLE" align="left"><b><div id='' style='color:blue;'>Employee Detail</div></b></td>
		</tr>
	</table>

	<div id="patientDetailsDivId" style="display: none;">
	
		
			<bean:write name="issueEmpBean" property="strPatientDetails"
				filter="false" />
		
	
	</div>


	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<td width="5%" class="TITLE" align="center"><img
				src="../../hisglobal/images/plus.gif" id="plus2"
				style="display: block; cursor: pointer; "
				onClick="disPrevIssueDtl(),getPrevIssueDtl();"> <img
				src="../../hisglobal/images/minus.gif" id="minus2"
				style="display: none; cursor: pointer; "
				onClick="disPrevIssueDtl1();"></td>
			<td colspan="3" class="TITLE"><b><div id='' style='color:blue;'>Previous Issue Details</div></b></td>
		</tr>
	</table>

	<div id="issueDivId"></div>

	<div class='popup' id='issueDtlId' style='display: none'></div>


	<table class="TABLEWIDTH" align="center" cellspacing="1px"
			cellpadding="1px">

			<tr>
				<td class="TITLE" colspan="4"><div id='' style='color:blue;'>Request Details</div></td>
			</tr>

			
			<tr>
				<td width="25%" class="LABEL"><font color="red">*</font>Approved
				By</td>
				<td width="25%" class="CONTROL">
				<select name="strPrescribedBy" class="comboNormal" >
				<bean:write name="issueEmpBean" property="strConsultantValues"
						filter="false" />
						<option value="0">SelectValue</option>
						</select>
				</td>
				<td width="25%" class="LABEL"><font color="red">*</font>Approved
				Date</td>
				
				<td width="25%" class="CONTROL"><date:date name="strPrescriptionDate"
					value="${issueEmpBean.strCtDate}"></date:date></td>
			</tr>
			
		</table>
	
	
		
		<table class="TABLEWIDTH" align="center" cellspacing="1px"
			cellpadding="1px">
			<tr>
				<td class='TITLE' colspan='5'><div id='' align="right"><img style="cursor: pointer;height: 20px"
					id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"

					onclick='getItemSelectPopup();' name="searchName"
					title="Click here to Search Item"></div></td>
			</tr>
			
							
			
		</table>
		<table bgcolor='black' cellspacing="1px" class="TABLEWIDTH" align="center"
			cellpadding="0px" cellpadding="1px">

			<tr>
				<td class="multiLabel" width="30%">Item/Drug Name</td>
				<td class="multiLabel" width="20%">Batch No</td>
				<td class="multiLabel" width="10%">Avl Qty</td>
				<td class="multiLabel" width="10%"><font color="red">*</font>Req Qty</td>
				<td class="multiLabel" width="15%"><font color="red">*</font>Unit Name</td>
				<td class="multiLabel" width="15%">Cost</td>
			</tr>
		</table>

		<div id="id1"></div>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
       
        <tr> 
         <td width="85%" class="LABEL">Total Approx Cost(Rs):</td>
         <td width="15%" class="CONTROL" style="color: red; font-weight: bold"><div id='strApproxAmtDivId' align="center">0.00</div>
         <input type="hidden" name="strApproxAmt">
         </td>   
          </tr>
         
          </table>
		
		
		
		
		<table cellspacing="1px" class="TABLEWIDTH" align="center"
			cellpadding="1px">
			
			<tr class="FOOTER">
				<td colspan="5"></td>
			</tr>
		</table>
	
	
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td colspan="2" class="LABEL"><font color="red">*</font>Receive
			By</td>
			<td colspan="2" class="CONTROL"><input type="text" value="${issueEmpBean.strEmployeeName}"
				class="txtFldMax" name="strReceiveBy"></td>
		</tr>

		<tr>
			<td class="LABEL" colspan="2">Remarks</td>
			<td class="CONTROL" colspan="2"><textarea name="strRemarks" cols="25" rows="2" onkeypress="return validateData(event,9);"></textarea></td>
		</tr>
	</table>

	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="FOOTER">
			<td colspan="4"><font color="red">*</font> Mandatory Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td align="center"><img style=" cursor: pointer"
				src="../../hisglobal/images/btn-sv.png"
				onclick="return validateIssue();" title="Click to Save Record"/> <img
				style=" cursor: pointer"
				src="../../hisglobal/images/btn-clr.png" onClick="clearIssue();" title="Click to Clear Page">
			<img style=" cursor: pointer"
				src="../../hisglobal/images/btn-ccl.png" onClick="cancelIssue();" title="Click to cancel process">
			</td>

		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="storeName" value="${issueEmpBean.storeName}" />
	<input type="hidden" name="itemCatName"
		value="${issueEmpBean.itemCatName}" />
	<input type="hidden" name="empNo" value="${issueEmpBean.empNo}" />
	<input type="hidden" name="strId" value="${issueEmpBean.strId}" />
	<input type="hidden" name="itemCategory"
		value="${issueEmpBean.itemCategory}" />
	
	<input type="hidden" name="strIssueNo" value="${issueEmpBean.strIssueNo}" />
	<input type="hidden" name="strIssueDtl"
		value="${issueEmpBean.strIssueDtl}" />
	<input type="hidden" name="strCtDate" value="${issueEmpBean.strCtDate}" />
	<input type="hidden" name="strIssueNum" value="${issueEmpBean.strIssueNum}" />



	<cmbPers:cmbPers />
	<div id="blanket" style="display: none;"></div>

	<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			<div id="searchItemsDtlsDivId" style="display: block;"></div>
			
			
			</td>
		</tr>
	</table>
	</div>




</html:form>
<jsp:include page="issue_emp_go_search_row.jsp"></jsp:include>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>