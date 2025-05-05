<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
  <%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<!-- <link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->

<link href="/INVMGM/mms/css/master.css" rel="stylesheet" type="text/css">
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
<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
	

<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>

<script language="JavaScript" src="../js/BreakageItemDtlTrans.js"></script>
<script language="Javascript" src="../js/lpReturnReq.js"></script>
<script language="JavaScript" src="../js/lpReturnReq_Print.js"></script>
<script language="Javascript" src="/INVMGM/dossier/js/dossier_return_trans.js"></script>
<script language="Javascript" src="/INVMGM/dossier/js/dossierItems_util.js"></script>
<!-- <script language="Javascript" src="/INVMGM/dossier/js/dossierDetails_util.js"></script> -->
<!-- <script language="Javascript" src="/INVMGM/dossier/js/dossierissueDetails_util.js"></script> -->
<style type="text/css">
.multiControlRed {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-style: normal;
	font-weight: normal;
	color: #000000;
	background-color: #F5786B;
	height: 16px;
	text-align:center;
}</style>
<script type="text/javascript">
	function checkReturn()
	{
		if(document.getElementById("strReturnChk0").value > 0)
		{
				alert("Return Request already generated for the same patient!!!");
				cancelToDesk();
			}
	}


</script>

<script type="text/javascript">

function cancelDossier()
{
	document.forms[0].hmode.value="RETURNTOMAINDESK";
	document.forms[0].submit();
}


</script>

</head>
<body onload="checkReturn();">
<html:form action="/transaction/DossierDeskTransCNT"  name="DossierDeskBean" type="dossier.transaction.controller.fb.DossierDeskTransFB" method="post">

    <div class="errMsg"     id="errMsg"><bean:write name="DossierDeskBean" property="strErr"/></div>
	<%-- <div class="warningMsg" id="warningMsg"><bean:write name="DossierDeskBean" property="strWarning"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="DossierDeskBean" property="strMsg"/></div> --%>


<center>
<tag:tab tabLabel="Dossier Cancel" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab>
</center>
<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">

		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
</table>
<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">

		<tr class="HEADER" align="center">
			<p align="center"><bean:write name="DossierDeskBean" property="strWarning"/></p>
			<td colspan="4"></td>
		</tr>
</table>

<table class="TABLEWIDTH" cellspacing="1" cellpadding="1" border="0" align="center">
		<tbody><tr>

			<!-- <td align="center"><img
				style=" cursor: pointer"
				src="../../hisglobal/images/btn-clr.png" onClick="clearIssue();" title="Click to Clear Page">
			<img style=" cursor: pointer"
				src="../../hisglobal/images/btn-ccl.png" onClick="cancelIssue();" title="Click to cancel process">
			</td > -->
			
			<td align="center">
			<br>
			<!-- <a href="#" class="button" onclick="clearIssue();"><span class="clear">Clear</span></a> --> 
			<a href="#" class="button" onclick="cancelDossier();"><span class="cancel">Cancel</span></a>
			</td>
		</tr>
	</tbody></table>

		<input type="hidden" name="hmode"/>
		 <input type="hidden" name="strRequestTypeId" value="${DossierDeskBean.strRequestTypeId}"/>
	    <input type="hidden" name="strStoreId" value="${DossierDeskBean.strStoreId}"/>
	     <input type="hidden" name="strIssueDate" value="${DossierDeskBean.strIssueDate}"/>
	     <input type="hidden" name="strCrNo" value="${DossierDeskBean.strCrNo}"/>
	     <input type="hidden" name="strEmpNo" value="${DossierDeskBean.strEmpNo}"/>
	     <input type="hidden" name=strIssueNo value="${DossierDeskBean.strIssueNo}"/>
	     <input type="hidden" name="strItemCategNo" value="${DossierDeskBean.strItemCategNo}"/>
	      <input type="hidden" name="strRaisingReqTypeId" value="${DossierDeskBean.strRaisingReqTypeId}"/>
	     <input type="hidden" name="strIssueStoreId" value="${DossierDeskBean.strIssueStoreId}"/>
	     <input type="hidden" name="chk" value="${DossierDeskBean.strChk}"/>
	         <input type="hidden" name="strStoreName" value="${DossierDeskBean.strStoreName}"/>
	         <input type="hidden" name="strReturnNo" value="${DossierDeskBean.strReturnNo}"/>
	          <input type="hidden" name="strServicetype" value="${DossierDeskBean.strServicetype}"/>
	         <input type="hidden" name="strDossierId" value="${DossierDeskBean.strDossierId}"/>

	      
	    
	      
	      
<cmbPers:cmbPers/>
<div id="blanket" style="display: none;"></div>

	<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			<div id="searchItemsDtlsDivId" style="display: block;"></div>
			<div id="stockDtlsDivId" style="display: block;"></div>

			</td>
		</tr>
	</table>
	</div>
	
</html:form>


	
<jsp:include page="dossier_Return_req_trans_search_row.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>