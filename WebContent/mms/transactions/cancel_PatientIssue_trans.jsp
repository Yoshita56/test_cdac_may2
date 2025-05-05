<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>


<html>
<head>
<meta charset=UTF-8">
<title>Issue Cancel Process</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../js/cancel_IssueDrug_mmsTrans.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>

<script type="text/javascript">

</script>
</head>
<body onload="getReport();">

<html:form name="issueBean" action="/transactions/IssueTransCNT"
	type="mms.transactions.controller.fb.IssueTransFB">

	<div id="errMsg" class="errMsg"><bean:write name="issueBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="issueBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="issueBean" property="strNormalMsg" /></div>


	
	<tag:tab tabLabel="Issue Cancel" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab>
	<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
		<tr class="HEADER"> 
			 <td colspan="4"></td>
	
	<%-- Change Request		 --%>
	
			 <td align="right" >
			 	<span>
			     	<html:checkbox property="strWithoutCrNoCheckBox" name="issueBean" value="0" onclick="goToWithoutCrNoPage();">Without CR No.</html:checkbox>
		     	    <html:checkbox property="strCancelCheckBox"      name="issueBean" value="0" onclick="goToCancelPage();"      >Cancel Issue</html:checkbox>
		     	    <html:checkbox name="issueBean" property="strViewChk" onclick="transferToViewPage();" title="Click Here To View Off Line Issue Drug Detail">View</html:checkbox>
		     	</span>		 
		    </td>
	    </tr>
    </table>	
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>DDC Name</td>
			<td width="25%" colspan="1" class="CONTROL">
				<select name="strStoreId" class="comboMax" onchange="getItemCat();">
					<option value="0">Select Value</option>
					<bean:write name="issueBean" property="strStoreValues"
						filter="false" />
				</select>
			</td>

			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Drug Category</td>
			<td width="25%" colspan="1" class="CONTROL">
				<div id="itemcatDivId">
					<select	name="strItemCat" class="comboNormal" >
					<bean:write name="issueBean" property="strItemCatCombp"
						filter="false" />
				</select>
				</div>
			</td>			
		</tr>
		 <tr> 
    <td width="25%" class="LABEL"><font color="red">*</font>Issue No.</td>
    <td colspan="3" class="CONTROL">
    <input type="text" name="strIssueNo" value=""  maxlength="15" onkeypress="return validateData(event,4);">
    <input type="image" style="cursor:pointer;cursor:pointer" title="Issue Process"   align="top" src ="../../hisglobal/images/Go.png" name="go" value="Go" 
		    onclick="return onGoButton();" onkeyup="goFuncOnEnter(event);">
  </td>   
  </tr>
	</table>




<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr class="FOOTER">
			<td colspan="4"><font color="red">*</font> Mandatory Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>

			<td align="center"><img
				style=" cursor: pointer"
				src="../../hisglobal/images/btn-clr.png" onClick="clearIssue();" title="Click to Clear Page">
			<img style=" cursor: pointer"
				src="../../hisglobal/images/back_tab.png" onClick="cancelIssue();" title="Click to back ">
			</td>

		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="storeName" value="${issueBean.storeName}" />
	<input type="hidden" name="itemCatName" value="${issueBean.itemCatName}" />
	<input type="hidden" name="crNo" value="${issueBean.crNo}" />
	<input type="hidden" name="strId" value="${issueBean.strId}" />
	<input type="hidden" name="strConfCatCode" value="${issueBean.strConfCatCode}" />
	<input type="hidden" name="itemCategory" value="${issueBean.itemCategory}" />	
	<input type="hidden" name="strMode"   value="${issueBean.strMode}">
	<input type="hidden" name="strIssueMode"   value="${issueBean.strIssueMode}">
	<input type="hidden" name="strIssueNum" value="${issueBean.strIssueNum}" />
	<input type="hidden" name="strIssueNumber" value="${issueBean.strIssueNum}" />
	<input type="hidden" name="strVisitDtl" value="${issueBean.strVisitDtl}" />
	<input type="hidden" name="strDoseFrqFlg" value="${issueBean.strDoseFrqFlg}" />
	<input type="hidden" name="strReOrderFlgColor" value="${issueBean.strReOrderFlgColor}" />
<cmbPers:cmbPers/>	

<div id="blanket" style="display: none;"></div>
<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
						
				<div id="issueDtlsDivId" style="display: block;"></div>
		
			</td>
		</tr>
	</table>
	</div>
	
	
</html:form>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>
