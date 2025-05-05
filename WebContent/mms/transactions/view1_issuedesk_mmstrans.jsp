
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
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>



<script language="Javascript" src="../js/issuedesk_trans.js"></script>

</head>
<body >
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
			<td class="LABEL" width="50%" colspan="2">Store Name11</td>
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
		</tr>
			<tr>
			<td class="LABEL" width="25%">Req. Status </td>
			<td  class="CONTROL" colspan="3"><bean:write name="issueDeskTransBean" property="strReqStatusName" /></td>
		</tr>
		</table>
		</div>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" border="0">
		<tr class="TITLE">
			<td colspan="4"><div id='' > Details</div></td>
		</tr>
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" border="0" bgcolor="black">
	  	 <tr>
		   <td class="multiLabel" width="33%"> Name</td>
		   <td class="multiLabel" width="33%">Avl. Qty.(Issuing Store)</td>
		   <td class="multiLabel" width="33%">Req.Qty/Sanc Qty.</td>
		 </tr>
		</table>
		<div id="itemDtlsDiv"><bean:write name="issueDeskTransBean" property="strViewItemDtls" filter="false"></bean:write></div>
		
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" border="0">
		
		<tr class="FOOTER">
			 <td colspan="4"></td>
		</tr>
	</table>
<!-- 	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			
<img style="cursor: pointer; " title="Click Here Go Back To Main Desk" 
src="../../hisglobal/images/back_tab.png" onClick="cancel();" />
			
			</td>
		</tr>
	</table>-->
	<br>
	<div align="center" id="">					 
					 	<a href="#" class="button" onclick="cancel();"><span class="cancel">Cancel</span></a>
					</div> 
	
<input type="hidden" name="hmode"/>
<input type="hidden" name="strStoreName" value="${issueDeskTransBean.strStoreName}"/>
<input type="hidden" name="strStoreId" value="${issueDeskTransBean.combo[0]}"/>
<input type="hidden" name="strIssueNo" value="${issueDeskTransBean.strIssueNo}"/>
<input type="hidden" name="strIndentNo" value="${issueDeskTransBean.strIndentNo}"/>
<input type="hidden" name="strIndentDate" value="${issueDeskTransBean.strIndentDate}"/>
<input type="hidden" name="strItemCategoryNo" value="${issueDeskTransBean.strItemCategoryNo}"/>
<input type="hidden" name="strRaisingStoreId" value="${issueDeskTransBean.strRaisingStoreId}"/>
<input type="hidden" name="strChk" value="${issueDeskTransBean.strChk}"/>

<cmbPers:cmbPers/>
</html:form>

<div class="popup" id="popup" style="display:none"></div>
<%-- <tag:autoIndex></tag:autoIndex> --%>
</body>
</html>