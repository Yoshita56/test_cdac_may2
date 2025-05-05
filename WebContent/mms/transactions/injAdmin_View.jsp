<%@ page language="java" contentType="text/html;"	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>


<html>
<head>
<meta charset=UTF-8">
<title>Issue Process</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="Javascript" src="../js/stockDetails_util.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script>
<script language="Javascript" src="../js/issue_trans_go_withoutCrNo.js"></script>
<script language="JavaScript" src="../js/dateDifference.js"></script>

<script type="text/javascript">
// added by Neha Sharma 16th July 2013..
function controlToIssueToPatientPage()
{	    
	
		document.forms[0].hmode.value="INITVAL";
		document.forms[0].submit();
}

function cancelIssue1()
{
	//showMenuFrame();
	document.forms[0].hmode.value = "RETURNTOMAINDESK";
	document.forms[0].submit();
	//window.parent.closeTab();
}
function returnmode()
{
	//showMenuFrame();
	var store=document.forms[0].strStoreId.value;
	document.forms[0].strId.value=store;
	//alert(store);
	document.forms[0].strStoreId.value="";
	document.forms[0].hmode.value = "INITVAL";
	document.forms[0].submit();
	//window.parent.closeTab();
}
function addnewtab()
{
	//showMenuFrame();
	var store=document.forms[0].strStoreId.value;
	document.forms[0].strId.value=store;
	//alert(store);
	document.forms[0].strStoreId.value="";
	document.forms[0].newreqflg.value="1";
	document.forms[0].hmode.value = "INITVALGO";
	document.forms[0].submit();
	//window.parent.closeTab();
}
function setcombovalues()
{
	
	//document.forms[0].strStoreId.disabled=false;
	var store=document.forms[0].storeId.value;
	document.forms[0].strStoreId.value=store.split('^')[0];
	getItemCat();
	var catcode=document.forms[0].itemCategory.value;
	document.forms[0].strItemCat.value=catcode;
	
	if(document.forms[0].strflg.value == '1')
	{	//alert('outsideradio');
		getViewItemDtl();
	}else
		{//alert('insideradio');
		radioButton();
		}
	document.forms[0].strStoreId.disabled=true;
	document.forms[0].strItemCat.disabled=true;
	
}
function cancelToDesk()
{
	returnmode();
}

</script>
</head>
<body onLoad="checkMsg();setcombovalues();">


<html:form name="injAdminTransBean" action="/transactions/InjAdministrationTransCNT" type="mms.transactions.controller.fb.InjAdministrationTransFB">

	<div class="alert alert-danger  alert-dismissible fade show" id="errID" style="display: none;">
		<bean:write name="injAdminTransBean" property="strErrMsg" />
	</div>
	
	<div class="alert alert-warning  alert-dismissible fade show" id="wrnID" style="display: none;">
		<bean:write name="injAdminTransBean" property="strWarningMsg" />
	</div>
	<div class="alert alert-success  alert-dismissible fade show" id="normalMsg" style="display: none;">
		<bean:write name="injAdminTransBean" property="strNormalMsg" />
	</div>	
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
 			<tr class="FOOTER">
 			<td colspan="4" align="right">
 			<span><a href='#' onclick='addnewtab();' title="Raise New Request"><font style="" color="white"><u>New Request</u></font></a></span>
 			<div style="display: none;">
			<span>
     		    <html:radio property="strByCurrentAndDate"    name="injAdminTransBean" value="1" onclick="openViewPage(1);">Current Date</html:radio>
     		    <html:radio property="strByCurrentAndDate"    name="injAdminTransBean" value="2" onclick="openViewPage(2);">Back Date</html:radio>
     	      </span>
     	      <div>
			</td>
		</tr>
		<tr style="display: none;">
			<td  colspan="1" class="LABEL" ><font color="red">*</font>Store Name</td>
			<td  colspan="1" class="CONTROL">
				<select name="strStoreId" class="comboMax" onChange="getItemCat();">
					<bean:write name="injAdminTransBean" property="strStoreValues"
						filter="false" />
				</select>
			</td>

			<td  colspan="1" class="LABEL"><font color="red">*</font>Category</td>
			<td  colspan="1" class="CONTROL">
				<div id="itemcatDivId">
					<select	name="strItemCat" class="comboNormal" >
					<bean:write name="injAdminTransBean" property="strCatValues"
						filter="false" />
				</select>				
				</div>
			</td>			
		</tr>   
		</table> 
	   <div id="fromDate" style="display:none;"> 
		    <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
			<tr>
				<td class="LABEL" width="25%">Entry From Date</td>
					<td class="CONTROL" width="25%"><dateTag:date name="strFromDate" value="${injAdminTransBean.strCtDate}" ></dateTag:date> </td>
					<td class="LABEL" width="25%">Entry To Date</td>
					<td class="CONTROL" width="25%"><dateTag:date name="strToDate" value="${injAdminTransBean.strCtDate}" ></dateTag:date> </td>
		    </tr>
		    
		    </table> 
	    </div>
	    <table class="" align="center" cellpadding="1" cellspacing="1">
	    <tr style="display: none;">
			<td  align="center">
			    <!-- <img src="../../hisglobal/images/Go.png" onClick="getViewItemDtl();" title="Get Detial(s)" style="cursor: pointer;"/> -->
			    <a href="#" class="button" id="go" onclick="getViewItemDtl();"></a>
		    </td>
		</tr>
		<tr>
				
			    <td colspan="4"><div id="loadingId"></div>
		    </td>
		</tr>
	</table>
	
	 <table class='TABLEWIDTH' align='center' cellpadding='1' cellspacing='1'> 
			<tr style="display: none;">
			<td class='TITLE' colspan='2'>
			<div id='issueminusdiv' style='' ><img height='17px' width='17px' src='../../hisglobal/images/Minus.png' onclick='hideIssueDiv();' style='cursor: pointer;' title='Click to hide details'> Issue Details</div>
			<div id='issueplusdiv' style=''><img height='17px' width='17px' src='../../hisglobal/images/plus.png' onclick='showIssueDiv();' style='cursor: pointer;' title='Click to show item details'>Issue Details</div>
			</td></tr></table>
			
		<div id="breakageItemDtlId" style=""></div>
			
	<div id="issueItemDtlsDivId" style=""></div>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="FOOTER">
			<td colspan="4"></td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td align="center">
			<br> 
			<!--    <img style=" cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="controlToIssueToPatientPage();"> -->
			   <a href="#" class="button" onclick="cancelIssue1();"><span class="cancel">Cancel</span></a>
			   <a href="#" class="button" onclick="returnmode();"><span class="back">Back</span></a>
			  <!--   <a href="#" class="button" onclick="addnewtab();"><span class="back">New </span></a>-->
			</td>

		</tr>
	</table>
	<input type="hidden" name="hmode" />	
	<input type="hidden" name="strMode" value="${injAdminTransBean.strMode}">
	<input type="hidden" name="strCtDate" value="${injAdminTransBean.strCtDate}">
	<input type="hidden" name="strFlagVal" value="${injAdminTransBean.strFlagVal}">
	<input type='hidden' name='strHlpIssueNo' value='${injAdminTransBean.strHlpIssueNo}'> 
	<input type='hidden' name='strHiddenIssueNo' value='${injAdminTransBean.strHiddenIssueNo}'>
	<input type='hidden' name='storeId' value='${injAdminTransBean.strStoreId}'>
	<input type="hidden" name="crNo" value="${injAdminTransBean.strCrNo}" />
	<input type="hidden" name="itemCategory" value="${injAdminTransBean.itemCategory}" />	
	<input type="hidden" name="strId" value="${injAdminTransBean.strId}" />
	<input type="hidden" name="strflg" value="${injAdminTransBean.strflg}" />
	<input type="hidden" name="newreqflg" value="${injAdminTransBean.newreqflg}" />
	<input type="hidden" name="storeName" value="${injAdminTransBean.storeName}" />
	<input type="hidden" name="itemCatName" value="${injAdminTransBean.itemCatName}" />
	<input type="hidden" name="strPath" value="/mms/transactions/LPIssueDeskTransCNT.cnt" />
	

	<cmbPers:cmbPers />
	<div id="blanket" style="display: none;"></div>

	<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>			  
			   <div id="issueDtlsDivId"       style="display: block;"></div>			   
			</td>
		</tr>
	</table>
	</div>


</html:form>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>