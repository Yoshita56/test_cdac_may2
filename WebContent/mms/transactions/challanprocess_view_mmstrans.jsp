<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<!--  Developer : Santosh Chauhan
	  Version	: 1.0	 
	  Date 		: 27-Feb-2013
	  Module 	: Mms
	  Process	: Challan Process View
-->

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=UTF-8">
<title>Challan View</title>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">	


<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script language="Javascript" src="../js/challanprocess_mmstrans.js"></script>

</head>

<body>
<html:form name="challanProcessBean"
	action="/transactions/ChallanProcessTransCNT"
	type="mms.transactions.controller.fb.ChallanProcessTransFB" enctype="multipart/form-data">
	
	<div class="errMsg" id="errMsg"><bean:write
		name="challanProcessBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="challanProcessBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="challanProcessBean" property="strMsg" /></div>
	
	<center><tag:tab tabLabel="Challan Detail >> View "
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>		
	</table>
	
	
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td class="LABEL" width="25%">Store Name</td>
			<td class="CONTROL" width="25%"><bean:write name="challanProcessBean" property="strStoreName"/> </td>

			<td class="LABEL" width="25%">P.O. No</td>
			<td class="CONTROL" width="25%"><bean:write name="challanProcessBean" property="strPoNoDisplay"/>
			</td>
		</tr>

		<tr>
			<td class="LABEL">Supplier Name</td>
			<td width="25%" class="CONTROL"><bean:write name="challanProcessBean" property="strSupplierName"/></td>
			<td class="LABEL" width="25%"></td>
			<td class="CONTROL" width="25%"></td>
		</tr>
			
	</table>
	
	
	<bean:write name="challanProcessBean"
		property="strChallanHlpDtl" filter="false" />
		
	<div id ="receivedItemDtlsDivId"></div>	
	
	<div id="verifiedItemDtlsDivId"></div>	
	
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr class="FOOTER">
			<td colspan="4" width="25%"><font size="2" color="red">*</font>
			Mandatory Fields</td>
		</tr>
	</table>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td align="center"><img style="cursor: pointer;"
				src="../../hisglobal/images/btn-ccl.png"
				onClick="cancelPage('LIST');" /></td>
		</tr>
	</table>
	
	<div id="blanket" style="display:none;"></div>
	<div class="popUpDiv" id="popUpDiv" style="display:none;">
	
	<table bgcolor="white">
	
	<tr>
	
	<td>
	
	 <div id="printDtlsDivId" style="display:block;"></div>
	
	</td>
	
	</tr>
	
	</table>

</div>	
	<input type="hidden" name="strPrevHiddenChallanValue" value="" />
	<input type="hidden" name="strPoNo" value="${challanProcessBean.strPoNo}" />
	<input type="hidden" name="strPoNoDisplay" value="${challanProcessBean.strPoNoDisplay}" />
	<input type="hidden"  name="strStoreName"  value="${challanProcessBean.strStoreName}">
	<input type="hidden"  name="strSupplierName"  value="${challanProcessBean.strSupplierName}">	
	<input type="hidden" name="hmode" />
	
<input type="hidden" value="${challanProcessBean.combo[0]}" name="combo" tabindex="1"/>	
<input type="hidden" value="${challanProcessBean.combo[1]}" name="combo" tabindex="1"/>	
<input type="hidden" value="${challanProcessBean.combo[2]}" name="combo" tabindex="1"/>	
	
<cmbPers:cmbPers />
</html:form>

<tag:autoIndex></tag:autoIndex>

</body>
</html>

