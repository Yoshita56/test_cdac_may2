<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>



<html>
<head>
<meta charset=UTF-8">
<title>Issue Raising </title>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">


<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">


<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../js/mms.js"></script>

<script language="JavaScript" src="../js/HelpDesk_trans.js"></script>

<script language="JavaScript" src="../js/item_OtherDtls_util.js"></script>




</head>

<body>
<html:form name="HelpDeskTransBean"
	action="/transactions/HelpDeskCNT"
	type="mms.transactions.controller.fb.HelpDeskFB" method="post" enctype="multipart/form-data">


	<div class="errMsg"><bean:write name="HelpDeskTransBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="HelpDeskTransBean"
		property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="HelpDeskTransBean" property="strMsg" /></div>

	<center><tag:tab tabLabel="Issue Raising "
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Store Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="HelpDeskTransBean" property="strStoreName" filter="false" />
			</td>
			<td width="25%" class="LABEL">Issue Regarding</td>
			<td width="25%" class="CONTROL"><bean:write
				name="HelpDeskTransBean" property="strGroupName" filter="false" />
			</td>
		</tr>

</table>

<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		
		<tr>
		    <td width="25%" colspan="1" class="LABEL">Menu Name </td>
		    <td width="25%" colspan="1" class="CONTROL"><bean:write
				name="HelpDeskTransBean" property="strMenuName" filter="false" />
			</td>
		    
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Priority</td>
			<td width="25%" colspan="1" class="CONTROL">

			<div id="scheduleDivId"><select name="strpriority"
				class="comboNormal" ">
				<option value="0">Select Value</option>
				<option value="1">Normal</option>
				<option value="2">Low</option>
				<option value="3">High</option>
			</select></div>
			</td>

		</tr>
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
		<td width="15%" colspan="1" class="LABEL"><font color="red">*</font>Issue Subject</td>
		<td width="85%" colspan="3" class="CONTROL">
				<input class="txtFldMax2" type="text" maxlength='80' onkeypress="return validateData(event,3);"  onpaste="return false;" name="strprobsub" >
			</td>
		</tr>
		<tr>
			<td width="50%" colspan="1" class="LABEL"><font color="red">*</font>Issue Discription</td>
			<td width="50%" colspan="3" class="CONTROL">
			<textarea name="strprobdesc" rows="10" cols="50"></textarea>
			</td>
			</tr>
			<tr>
			
			
		<td width="50%" colspan="1" class="LABEL"><font color="red">*</font>Submitted By</td>
		<td width="50%" colspan="3" class="CONTROL">
				<input class="txtFldMax" type="text" maxlength='25' name="strsubmitby" >
			</td>
		</tr>
			
			</table>
			<jsp:include page="uploadFile.jsp"></jsp:include>
			
			<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
			
			
			<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		  </tr>
	</table>
		
		
	<input type="hidden" name="todayDate" id="todayDate"
		value="${HelpDeskTransBean.strCtDate}" />

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr>

			<td align="center">
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" onClick="savedata();" title="Click to Save Record" /> 
				<img style="cursor: pointer; " src="../../hisglobal/images/back_tab.png" onClick="cancel();"
				title="Click to Return On Desk" /></td>
		</tr>
	</table>

	<input type="hidden" name="strStoreId" value="${HelpDeskTransBean.combo[0]}" />
	<input type="hidden" name="strStoreName" value="${HelpDeskTransBean.strStoreName}" />
	<input type="hidden" name="strGroupId"	value="${HelpDeskTransBean.combo[1]}" />
	<input type="hidden" name="strGroupName" value="${HelpDeskTransBean.strGroupName}" />
	<input type="hidden" name="strCtDate"	value="${HelpDeskTransBean.strCtDate}"/>
	<input type="hidden" name="strCtDate"	value="${HelpDeskTransBean.strLocation}">
	<input type="hidden" name="strMenuName"	value="${HelpDeskTransBean.strMenuName}">
	


	

	<input type="hidden" name="strChk"	value="${HelpDeskTransBean.strChk }">
	<input type="hidden" name="hmode" />
		
	<cmbPers:cmbPers />


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



</html:form>

<tag:autoIndex></tag:autoIndex>   
</body>
</html>
