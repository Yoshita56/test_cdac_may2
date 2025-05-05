<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=UTF-8">
<title>Third Party Issue</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">		
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/thirdPartyIssue_trans.js"></script>
<script language="JavaScript" src="../js/searchItems_util.js"></script>
<script type="text/javascript">

</script>
</head>
<body >
<html:form name="thirdPartyIssueBean"
	action="/transactions/ThirdPartyIssueTransCNT"
	type="mms.transactions.controller.fb.ThirdPartyIssueTransFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="thirdPartyIssueBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="thirdPartyIssueBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="thirdPartyIssueBean" property="strNormalMsg" /></div>
	<tag:tab tabLabel="Third Party Issue" selectedTab="FIRST" align="center" width="TABLEWIDTH"> </tag:tab>
</center>
	

	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
	<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL">
				Store Name
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="thirdPartyIssueBean" property="strStoreName" filter="false" />
			</td>
		
			<td width="25%" colspan="1" class="LABEL">Req Date &amp; Time</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <font color="blue"><bean:write name="thirdPartyIssueBean" property="strCurrentDate" filter="false" /></font>
			</td>
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font size="1" color="red">*</font>
			Third Party Name
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<select name="strInstituteCode"  onchange="">
			<bean:write name="thirdPartyIssueBean" property="strInstituteValues" filter="false"/>
			</select>
			</td>
			
		</tr>
		
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font size="1" color="red">*</font>
			Item Category
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<select name="strItemCatNo"  onchange="getGroupCombo(this);">
			<bean:write name="thirdPartyIssueBean" property="strItemCatValues" filter="false"/>
			</select>
			</td>
			
		</tr>
		</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
		
		<tr class="TITLE">
			<td colspan="4"><div id='' align="right"><img style="cursor: pointer;height: 20px" id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"
 
										onclick='getItemSelectPopup();'>
			</div>
			</td>
			</tr>
			
			
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			<tr>
			<td width="16%" class="multiLabel">Item/Drug Name
			</td>
			<td width="16%" class="multiLabel">Batch/Serial No.
			</td>
			<td width="16%" class="multiLabel">Expiry Dt
			</td>
			<td width="16%" class="multiLabel">Avl Qty
			</td>
			<td width="16%" class="multiLabel"><font size="1" color="red">*</font>Req. Quantity
			</td>
			<td width="20%" class="multiLabel"><font size="1" color="red">*</font>Unit Name
			</td>
			</tr>
			
			</table>
			
			<div id="id1">
			</div>
			
			<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
					<td colspan="2" width="50%" class="LABEL">Remarks</td>
					<td colspan="2" width="50%" class="CONTROL">
			  		<textarea name="strRemarks" rows="2"></textarea>
    	 			</td>
			  </tr>
			
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" />
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" onClick="clearDtl('requestPage');" >
			<img  style="cursor: pointer; " src="../../hisglobal/images/back_tab.png" onClick="cancel1();" title='Click Here Go Back To Main Desk'>
		</td>
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" name="mode"/>
<input type="hidden" name="strCurrentDate" value="${thirdPartyIssueBean.strCurrentDate}"/>
<input type="hidden" name="strStoreId" value="${thirdPartyIssueBean.strStoreId}" />
<input type="hidden" name="strStoreTypeId" value="${thirdPartyIssueBean.strStoreTypeId}" />
<input type="hidden" name="comboValue" value="${thirdPartyIssueBean.strStoreName}">

<cmbPers:cmbPers />
<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="popUpDiv" style="display:none;">
<table bgcolor="white">
<tr>
<td>
<div id="searchItemsDtlsDivId" style="display:block;"></div>
</td>
</tr>
</table>
</div>


</html:form>
<jsp:include page="thirdPartySearchRow.jsp"></jsp:include>

<tag:autoIndex></tag:autoIndex>
</body>
</html>