<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>Issue To Employee</title>
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
<script language="Javascript" src="../js/issue_trans_emp.js"></script>

<script language="Javascript" src="../js/issueDetails_util.js"></script>

<script type="text/javascript">

</script>
</head>
<body onload="getReport();">


<html:form name="issueBean" action="/transactions/IssueEmployeeTransCNT"
	type="mms.transactions.controller.fb.IssueEmployeeTransFB">

	<div id="errMsg" class="errMsg"><bean:write name="issueEmpBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="issueEmpBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="issueEmpBean" property="strNormalMsg" /></div>


	
	<tag:tab tabLabel="Issue To Employee" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab>
	<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
	<tr class="HEADER"> 
	 <td colspan="4">Issue To Employee&gt;&gt;
    </td>
    </tr>
    </table>
	
	
	
	
	
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Store Name</td>
			<td width="25%" colspan="1" class="CONTROL">
				<select name="strStoreId" class="comboNormal" onchange="getItemCat();">
					<option value="0">SelectValue</option>
					<bean:write name="issueEmpBean" property="strStoreValues"
						filter="false" />
				</select>
			</td>

			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Item Category</td>
			<td width="25%" colspan="1" class="CONTROL">
				<div id="itemcatDivId">
					<select	name="strItemCat" class="comboNormal" >
					<bean:write name="issueEmpBean" property="itemCatValues"
						filter="false" />
				</select>
				</div>
			</td>			
		</tr>
		 <tr> 
      
    <tr>
			<td colspan="1" class="LABEL"><font color="red">*</font>Employee No</td>
			<td colspan="3" class="CONTROL"><input type="text"
				class="txtFldMax" style="text-transform: uppercase;" name="strEmployeeNo" onkeypress="return validateData(event,9)" maxlength="14">
		
   
    <input type="image" style="cursor:pointer;cursor:pointer" title="Issue Process" 
		    align="top" src ="../../hisglobal/images/Go.png" name="go" value="Go" 
		    onclick="return onGoButton();" onkeyup="goFuncOnEnter(event);">
  </td>   
  </tr>
	</table>




<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr class="FOOTER">
			<td colspan="4"><font color="red">*</font>Mandatory Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>

			<td align="center"><img
				style=" cursor: pointer"
				src="../../hisglobal/images/btn-clr.png" onClick="clearIssue();" title="Click to Clear Page">
			<img style=" cursor: pointer"
				src="../../hisglobal/images/btn-ccl.png" onClick="cancelIssue();" title="Click to cancel process">
			</td>

		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="storeName" value="${issueEmpBean.storeName}" />
	<input type="hidden" name="itemCatName" value="${issueEmpBean.itemCatName}" />
	<input type="hidden" name="empNo" value="${issueEmpBean.empNo}" />
	<input type="hidden" name="strId" value="${issueEmpBean.strId}" />
	<input type="hidden" name="itemCategory" value="${issueEmpBean.itemCategory}" />
<input type="hidden" name="strIssueNum" value="${issueEmpBean.strIssueNum}" />

<cmbPers:cmbPers />

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