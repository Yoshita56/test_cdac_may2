<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset=utf-8>
<title>Approving Authority</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" 
type="text/css">
<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript"
	src="../../mms/js/approving_authority_mst.js"></script>

</head>
<body>
<html:form action="/masters/ApprovingAuthorityMstCNT"
	name="approvingAuthorityMstBean"
	type="mms.masters.controller.fb.ApprovingAuthorityMstFB">

	<center>
	<div id="errMsg" class="errMsg"><bean:write
		name="approvingAuthorityMstBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="approvingAuthorityMstBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="approvingAuthorityMstBean" property="strNormalMsg" /></div>


	<tag:tab tabLabel="Approving Authority" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab></center>

	<table class="TABLEWIDTH" align="center">
		<tr class="HEADER">
			<td colspan="2">Approving Authority&gt;&gt; Add</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">Approving Type</td>

			<td width="50%" class="CONTROL"><bean:write
				name="approvingAuthorityMstBean" property="strApprovingType" /></td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">Store Name</td>


			<td width="50%" class="CONTROL"><bean:write
				name="approvingAuthorityMstBean" property="strStoreName" /></td>
		</tr>

	</table>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px" style="border-collapse: collapse;">
		<tr>
			<td class="TITLE" width="50%">Approving Authority Details</td>
			<td class="TITLE" width="50%" style="text-align: right;"><input
				type="radio" name="strCommitteeFlag" id="nonCommitteeId" value="0" checked="checked"
				onchange="populateList(this);">Non-Committee&nbsp;&nbsp;<input type="radio"
				name="strCommitteeFlag" id="committeeId" value="1" onchange="populateList(this);">Committee</td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL"></td>
		</tr>
		<tr>

			<td class="CONTROL" style="text-align: center;"><input
				type="text" class="txtFldMax" style="width: 200px" name="searchVal"
				onkeyup="searchInList();" /></td>
			<td class="LABEL"></td>
		</tr>

	</table>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">

		<tr>
			<td colspan="3" class="LABEL">&nbsp;</td>
		</tr>
		<tr>
			<td class="CONTROL" width="47%">

			<div id="LeftUserDivId" align="center"><select
				name="strLUserName" size="8" multiple style="width: 280px">
				<bean:write name="approvingAuthorityMstBean" property="strUserList"
					filter="false" />
			</select></div>
			</td>
			<td width="6%" class="CONTROL">

			<center><img src="../../hisglobal/images/forward3.gif"
				width="35" height="31" onclick="LeftListTransfer();"></center>

			<center><img src="../../hisglobal/images/forwardward.gif"
				width="35" height="31" align="middle"
				onClick='shiftAllToRight("strLUserName","strUserName",1);'></center>

			<center><img src="../../hisglobal/images/backward.gif"
				width="35" height="31"
				onClick="shiftAllToLeft('strLUserName','strUserName',1);"></center>

			<center><img src="../../hisglobal/images/back3.gif"
				width="35" height="31"
				onClick='shiftToLeft("strLUserName","strUserName",1);'></center>
			</td>

			<td class="CONTROL" width="47%">
			<div id="RightUserDivId" align="center"><select name="strUserName" size="8"
				multiple style="width: 280px">
				<bean:write name="approvingAuthorityMstBean" property="strRUserList"
					filter="false" />
			</select></div>
			</td>
		</tr>
	</table>



	<table border="0" class="TABLEWIDTH" align="center">
		<tr>
			<td colspan="4" class="LABEL"></td>
		</tr>
		<tr>
			<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Effective
			Date</td>
			<td width="25%" class="CONTROL" colspan="1"><dateTag:date
				name="strEffectiveDate"
				value="${approvingAuthorityMstBean.strCtDate}"></dateTag:date></td>
			<td class="LABEL" width="25%" colspan="1">Remarks</td>
			<td width="25%" class="CONTROL" colspan="1"><textarea
				name="strRemarks" rows="2"></textarea></td>
		</tr>
	</table>

	<table border="0" class="TABLEWIDTH" align="center">
		<tr class="FOOTER">
			<td colspan="2"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>
<!-- 	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center"><img style="cursor: pointer;"
				src="../../hisglobal/images/btn-sv.png"
				onClick="return validate1();" /> <img style="cursor: pointer;"
				src="../../hisglobal/images/btn-clr.png"
				onClick="document.forms[0].reset();"> <img
				style="cursor: pointer;" src="../../hisglobal/images/btn-ccl.png"
				onClick="cancel('LIST');"></td>
		</tr>
	</table>-->
	<br>
	<div align="center" id=" ">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="document.forms[0].reset();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
				</div> 
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strApprovingTypeId"
		value="${approvingAuthorityMstBean.strApprovingTypeId}">
	<input type="hidden" name="strStoreId"
		value="${approvingAuthorityMstBean.strStoreId}">
	<input type="hidden" name="strStoreName"
		value="${approvingAuthorityMstBean.strStoreName}">
	<input type="hidden" name="strApprovingType"
		value="${approvingAuthorityMstBean.strApprovingType}">
	<input type="hidden" name="comboValue"
		value="${approvingAuthorityMstBean.comboValue}">
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>