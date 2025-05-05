<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<!--  Developer : Santosh Chauhan
	  Version	: 1.0	 
	  Date 		: 07-Feb-2013
	  Module 	: Mms
	  Process	: Challan Process Approve
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
<title>Challan Detail >> Approval</title>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/mms.js"></script>

<script language="Javascript" src="../js/challanprocess_freeze_mmstrans.js"></script>


</head>

<body onload="">
<html:form name="challanProcessApprovalBean"
	action="/transactions/ChallanProcessApprovalTransCNT"
	type="mms.transactions.controller.fb.ChallanProcessApprovalTransFB" >
	
	<div class="errMsg" id="errMsg"><bean:write
		name="challanProcessApprovalBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="challanProcessApprovalBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="challanProcessApprovalBean" property="strMsg" /></div>
	
	<center><tag:tab tabLabel="Challan Detail >> Approval Process "
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>		
	</table>
	
	<bean:write name="challanProcessApprovalBean"
		property="strChallanHlpDtl" filter="false" />
		
	
	<bean:write name="challanProcessApprovalBean"
			property="strVerifiedItemHlpDtl" filter="false" />
			
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td width="50%" class="LABEL"><font size="2" color="red">*</font>Remarks</td>
			<td class="CONTROL" colspan="2"><textarea name="strRemarks"
				cols="20" rows="2" id="strRemarks"></textarea></td>
		</tr>
	</table>	

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr class="FOOTER">
			<td colspan="4" width="25%"><font size="2" color="red">*</font>
			Mandatory Fields</td>
		</tr>
	</table>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<!-- <tr>
		<td align="center"><img style="cursor: pointer;" src="../../hisglobal/images/btn-sv.png" onClick="return freezeChallan();" /> 
			<img style="cursor: pointer;" src="../../hisglobal/images/btn-clr.png" onClick="pageReset();" />
			<img style="cursor: pointer;" src="../../hisglobal/images/btn-ccl.png" onClick="cancelPage('LIST');" />
		</td>
		</tr> -->
	</table>
	<br>
	<div align="center" id=" ">					 
					 	<a href="#" class="button" id="submitId" onclick=' return freezeChallan();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="pageReset();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelPage('LIST');"><span class="cancel">Cancel</span></a>
					</div> 
	<input type="hidden" name="strPrevHiddenChallanValue" value="" />
	<input type="hidden" name="strPoDate" value="${challanProcessApprovalBean.strPoDate}" />
	<input type="hidden" name="strPoStoreId" value="${challanProcessApprovalBean.strPoStoreId}" />
	<input type="hidden" name="strSupplierInterfaceFlag" value="${challanProcessApprovalBean.strSupplierInterfaceFlag} }" />
	
	<input type="hidden" name="hmode" />
<cmbPers:cmbPers />
</html:form>

<tag:autoIndex></tag:autoIndex>

</body>
</html>








