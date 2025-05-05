<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>
<!-- 
/**
 * @author Amit Kumar
 * Date of Creation : 05/5/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
 -->
<html>
<head>
<meta charset=UTF-8">
<title>Routine Purchase</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">

<style type="text/css">

            .pg-normal 
            {
                color: blue;
                font-weight: normal;
                text-decoration: none;
                cursor: pointer;
                
                
            }
            .pg-selected 
            {
                color: red;
                font-weight: bold;
                text-decoration: underline;
                cursor: pointer;
                
            }
            .pg-qualified 
            {
                color: green;
                font-weight: bold;
                text-decoration: underline;
                cursor: pointer;
                
            }
            </style>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>

<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/mms.js"></script>
<script language="JavaScript" src="../js/RoutinePurchaseWithItem.js"></script>

</head>
<body onload="OnLoadFunction();">

<html:form action="/transactions/RoutinePurchaseCNT.cnt"  name="requestForRoutinePurchase"  type="mms.transactions.controller.fb.RoutinePurchaseFB" method="post">

	<div class="errMsg" id="errMsg">
	     <bean:write 	name="requestForRoutinePurchase" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg">
	     <bean:write	name="requestForRoutinePurchase" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg">
	     <bean:write    name="requestForRoutinePurchase" property="strMsg" /></div>

	<center>
	   <tag:tab tabLabel="Routine Purchase"  selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>
	</center>
    
    <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">  
         <tr class="HEADER">
			<td colspan="4"></td>
		</tr>
	</table>
		<table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
		      <bean:write name="requestForRoutinePurchase" property="strIndentDetails"	filter="false" />
		</table>
		
	
	<bean:write		name="requestForRoutinePurchase" property="strIndentItemList" filter="false" />

	
	

	
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="TITLE">
			<td colspan="6"></td>
		</tr>
		<tr>
			<td colspan="3" class="LABEL">Remarks(If Any)</td>
			<td class="CONTROL" colspan="3"><textarea name="strRemarks" cols="20"
				rows="2" id="strRemarks"></textarea></td>
		</tr>


		<tr class="FOOTER">
			<td colspan="6"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>

      

	<table class="TABLEWIDTH" align="center">
		<tr>
			<td align="center"><img style="cursor: pointer; "
				title="Click to Save Record"
				src="../../hisglobal/images/btn-sv.png"
				onClick=" return validateModify();" /> <img
				style="cursor: pointer; " title="Click to Clear Page"
				src="../../hisglobal/images/btn-clr.png" name="clearImg"
				onclick="initPage();"> <img
				style="cursor: pointer; "
				title="Click to Return Main Menu"
				src="../../hisglobal/images/back_tab.png" onClick="cancelToDesk();" />
			</td>
		</tr>
	</table>

	<input type="hidden" name="hmode" />

	<input type="hidden" name="strStoreTypeId"
		value="${requestForLpStaff.strStoreTypeId}">
	<input type="hidden" name="strTmpStoreName"
		value="${requestForRoutinePurchase.strTmpStoreName}">
	<input type="hidden" name="strTmpCrNo"
		value="${requestForRoutinePurchase.strTmpCrNo}">
	<input type="hidden" name="strTmpToStore"
		value="${requestForRoutinePurchase.strTmpToStore}">
	<input type="hidden" name="strTmpGrantType"
		value="${requestForRoutinePurchase.strTmpGrantType}">
	<input type="hidden" name="strTmpItemCatg"
		value="${requestForRoutinePurchase.strTmpItemCatg}">
	<input type="hidden" name="strTmpReqType"
		value="${requestForRoutinePurchase.strTmpReqType}">
	<input type="hidden" name="strGoFlg"
		value="${requestForRoutinePurchase.strGoFlg}">
	<input type="hidden" name="strPath"
		value="${requestForRoutinePurchase.strPath}">
	<input type="hidden" name="strCostRequired"
		value="${requestForRoutinePurchase.strCostRequired}">
		<input type="hidden" name="strItemDtlWithIssueQty" id="strItemDtlWithIssueQty" value="0"/>
		<input type="hidden" name="strChkTmp"	value="${requestForRoutinePurchase.strChkTmp}">
		<input type="hidden" name="strTmpIndentDate"	value="${requestForRoutinePurchase.strIndentDate}">


	<div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			<div id="searchItemsDtlsDivId" style="display: block;"></div>
			</td>
		</tr>
	</table>
	</div>
	<cmbPers:cmbPers />
</html:form>

<tag:autoIndex></tag:autoIndex>
</body>
</html>