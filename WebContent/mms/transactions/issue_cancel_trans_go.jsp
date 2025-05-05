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
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
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
<script language="Javascript" src="../js/cancel_IssueDrug_mmsTrans.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="Javascript" src="../js/stockDetails_util.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>

<script type="text/javascript">

</script>
</head>
<body onload="getReport();">


<html:form name="issueBean" action="/transactions/IssueTransCNT"	
type="mms.transactions.controller.fb.IssueTransFB">

	<div id="errMsg" class="errMsg"><bean:write name="issueBean"
		property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="issueBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="issueBean" property="strNormalMsg" /></div>
	
		<tag:tab tabLabel="Issue Cancel" selectedTab="FIRST"
			align="center" width="TABLEWIDTH">
		</tag:tab>
		<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4"></td>
			</tr>

		</table>


	
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<bean:write name="issueBean" property="strPatientDetails"	
			filter="false" />
		</tr>
	</table>
	

	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">		
	   <tr class="TITLE">
				<td colspan="4"></td>
			</tr>
		<tr>
		    
			<td class="LABEL"   width="50%"><font color="red">*</font>Remarks</td>
			<td class="CONTROL" width="50%"><textarea name="strRemarks"	cols="25" rows="2" onkeypress="return validateData(event,9);"></textarea></td>
		</tr>
	</table>

	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="FOOTER">
			<td colspan="4">Mandatory Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td align="center"><img style=" cursor: pointer"
				src="../../hisglobal/images/btn-sv.png"
				onclick="return validateIssue();" /> 
			<img style=" cursor: pointer"
				src="../../hisglobal/images/btn-ccl.png" onClick="cancelIssue();">
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
	<input type="hidden" name="strIssueMode" value="${issueBean.strIssueMode}">
	<input type="hidden" name="strCtDate" value="${issueBean.strCtDate}" />
	<input type="hidden" name="strVisitDtl" value="${issueBean.strVisitDtl}" />
	<input type="hidden" name="strIssueNum" value="${issueBean.strIssueNum}" />
	<input type="hidden" name="isUpdateOpdDrugReq" value="" />
	<input type="hidden" name="strGlobalval" value="" />
	<input type="hidden" name="strDoseFrqFlg" value="${issueBean.strDoseFrqFlg}" />
	<input type="hidden" name="strReOrderFlgColor" value="${issueBean.strReOrderFlgColor}" />
	<input type="hidden" name="strOutOfStockFlag" value="${issueBean.strOutOfStockFlag}" />
	
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


</html:form>
<jsp:include page="issue_trans_search_row.jsp"></jsp:include>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>