

<!--
Developer : Anshul Jindal
  Version : 1.0 
  Date : 11/June/2009
   Module:MMS
  Unit:Issue Desk Transaction
    -->
    
<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>


<html>
<head>
<meta charset=UTF-8">
<title>Issue Indent</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/newpopup.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../js/issueDetails_util.js"></script>
<script language="Javascript" src="../js/issuedesk_trans.js"></script>

</head>
<body>
<html:form name="issueDeskTransBean" action="/transactions/IssueDeskTransCNT"
	type="mms.transactions.controller.fb.IssueDeskTransFB">
<center>
	<div id="errMsg" class="errMsg"><bean:write name="issueDeskTransBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="issueDeskTransBean"
		property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="issueDeskTransBean"
		property="strNormalMsg" /></div>


	<tag:tab tabLabel="Issue Desk"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
			</center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" border="0">

		<tr class="HEADER">
		
			<td colspan="4"></td>
		</tr>

			<tr>
				<td class="LABEL" width="50%" colspan="2">Issuing Store Name</td>
				<td width="50%" class="CONTROL" colspan="2"><bean:write name="issueDeskTransBean" property="strStoreName" /></td>
	
			</tr>
			
			<tr>
				<td  colspan="4" class="TITLE" width="25%">
					<div id="PlusDivId" align="left" style="display:none;">
						<img src="../../hisglobal/images/plus.gif" 
										onClick="clickPlus();" style="cursor: pointer; "/>
							Request Details
						</div>
						<div id="MinusDivId" style="display:block;" align="left">
							<img src="../../hisglobal/images/minus.gif" 
									onClick="clickMinus();" style="cursor: pointer; "/>
									Request Details
						</div>
				</td>
			</tr>		
		</table>
		
		<div id="ReqDtlsDiv">
			<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" border="0">
				
				<tr>
						<td width="25%" class="LABEL">Request No.</td>
						<td width="25%" class="CONTROL"><bean:write name="issueDeskTransBean" property="strIndentNo" /></td>
							<td width="25%" class="LABEL">Request Date</td>
						<td width="25%" class="CONTROL"><bean:write name="issueDeskTransBean" property="strIndentDate" /></td>
					</tr>
					<tr>
							<td width="25%" class="LABEL"> Category</td>
						<td width="25%" class="CONTROL"><bean:write name="issueDeskTransBean" property="strItemCategory" /></td>
							<td class="LABEL" width="25%">Raising Store</td>
					<td width="25%" class="CONTROL"><bean:write name="issueDeskTransBean" property="strRaisingStoreName" /></td>
				
			</table>
		</div>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" border="0">
		
		<tr class="TITLE">
			<td colspan="4"><div id='' > Details</div></td>
		</tr>
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" border="0" bgcolor="black">
		<tr>
		
			<td class="multiRPTLabel" width="20%"> Name</td>
			<td class="multiRPTLabel" width="20%">Batch/Sl No.</td>
			<td class="multiRPTLabel" width="20%">Sanc Qty.</td>
			<td class="multiRPTLabel" width="20%">Issued Qty</td>
			<td class="multiRPTLabel" width="20%">Remarks</td>
	
		</tr>
		</table>
		<div id="itemDtlsDiv"><bean:write name="issueDeskTransBean" property="strIssuedItemDtls" filter="false"></bean:write></div>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" border="0">
		<tr >
    <td width ="50%" class ="LABEL" valign="middle" colspan="2">Received By</td>
    <td width ="50%" class ="CONTROL" colspan="2"><bean:write name="issueDeskTransBean" property="strReceivedBy" /></td>
  </tr>
			<tr >
    <td width ="50%" class ="LABEL" valign="middle" colspan="2">Remarks</td>
    <td width ="50%" class ="CONTROL" colspan="2"><bean:write name="issueDeskTransBean" property="strRemarks" /></td>
  </tr>
		<tr class="FOOTER">
			 <td colspan="4"> </td>
		</tr>
	</table>
	<!-- 
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			
<img style="cursor: pointer" src="../../hisglobal/images/print_tab.gif" onClick="getReport();" />
<img style="cursor: pointer; " title="Click Here Go Back To Main Desk " 
src="../../hisglobal/images/back_tab.png" onClick="cancel();" />
			
			</td>
		</tr>
	</table> -->
	<br>
	<div align="center" id="saveId">					 
					 	<a href="#" class="button" id="submitId" onclick='getReport();'><span class="print">Print</span></a>
						<a href="#" class="button" onclick="cancel();"><span class="cancel">Cancel</span></a>
					</div> 
	
	
<div id="blanket" style="display:none;"></div>
	<div class="popUpDiv" id="popUpDiv" style="display:none;">
	
	<table bgcolor="white">
	
	<tr>
	
	<td>
	
	<div id="stockDtlsDivId" style="display:block;"></div>
	<div id="itemOtherDtlsDiv" style="display:block;" class="popup" ></div>
	 <div id="issueDtlsDivId" style="display:block;"></div>
	
	</td>
	
	</tr>
	
	</table>

</div>	
<input type="hidden" name="hmode"/>
 <input type="hidden" name="strErr" value=""/>

<cmbPers:cmbPers/>
</html:form>

<div class="popup" id="popup" style="display: none"></div>
<tag:autoIndex></tag:autoIndex>
</body>
</html>