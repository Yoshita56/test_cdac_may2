  <%@ page language="java"contentType="text/html;" pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>Drug Transfer Approval  Approve</title>
<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/dwh.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet" type="text/css">


<script language="JavaScript" src="../../hisglobal/js/jquery-3.3.1.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/jquery-ui.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/base64.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="JavaScript" src="../js/item_OtherDtls_util.js"></script>
<script language="JavaScript" src="../js/transferShortageApproval.js"></script>
<script type="text/javascript">
  $(function() { 
  var divHeight=150;
	var initialHeight=716;
	var heightPer = (divHeight*100)/initialHeight; 
	 var newHeight = parseInt((window.innerHeight * heightPer)/100,10);	
		fixedHeaderTableTrans("wrapper", newHeight);		
  }); 
</script>
</head>
<body class="background">
<html:form name="transferShortageApprovalTransBean"
	action="/transactions/TransferShortageApprovalTransCNT"
	type="mms.transactions.controller.fb.TransferShortageApprovalTransFB" styleClass="formbg">
<input type='hidden' name='IMCS_TOKEN' value='<%=request.getSession().getAttribute("IMCS_TOKEN").toString().trim() %>'/>	

<center>
	<div class="errMsg"     id="errMsg"><bean:write    	    name="transferShortageApprovalTransBean" property="strErrMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write	name="transferShortageApprovalTransBean" property="strWarningMsg" /></div>
	<div class="normalMsg"  id="normalMsg"><bean:write   name="transferShortageApprovalTransBean" property="strNormalMsg" /></div>
</center>
<div  id ="Raising" style="display:block">
       <table class="TABLEWIDTH" align="center" cellspacing="0px" cellpadding="1">   
			 <tr class="HEADER">
				<td colspan="4"><bean:message key="label.common.Transfer_shortage_approval"/> &gt;&gt; <bean:message key="label.common.Approve"/></td>
			 </tr>
		 </table>
	</div>
	<table class="TABLEWIDTH" align="center" cellspacing="0px" cellpadding="1">   
		      <bean:write name="transferShortageApprovalTransBean" property="strIndentDetails" filter="false" />
		 </table>
	
	<bean:write name="transferShortageApprovalTransBean" property="strTransferOrderDetails"	filter="false" />
		
	<bean:write name="transferShortageApprovalTransBean" property="strSetApprovedDetails"  filter="false" /></br>
	
	<table class="TABLEWIDTH" align="center" cellspacing="0px" cellpadding="1"> 
	    <tr>
			<td class="LABEL" width="25%"><bean:message key="label.common.Approval_status"/></td>
			<td width="25%" class="CONTROL" colspan="3">
			<input type="radio" name="strApproved" value="1" checked="checked" onClick="FuncTick(this),setApprovedQty();"/>Approved
			<input type="radio" name="strRejected" value="2" onClick="FuncTick(this),setApprovedQty();"/>Rejected
			</td>
		</tr>
		</table>	
<table class="TABLEWIDTH" align="center" cellspacing="0px" cellpadding="1">
		<tr>
		<td width="50%" class="LABEL" ><div id="remarks">
		<bean:message key="label.common.remarks"/></div></td>
			<td width="50%" class="CONTROL" colspan="3"><textarea
				name="strRemarks" cols="25" rows="2"></textarea></td>
	   </tr>
	</table>
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr class="FOOTER">
			<td colspan="4" width="25%"></td>
		</tr>
	</table>
	
	
<div>		
<div class="legends"><font size="2" color="red">*</font> <bean:message key="label.common.Mandatory_Field(s)"/></div>  
<div class="control_button"><table  class="TABLEWIDTH" align="center">
	<tr>
	<td align="center"><div>
				<a href="#" class="button" title="Click to Save Record" onClick="validateSave();"><span class="save"><bean:message key="label.common.Save"/></span></a>
				<a href="#" class="button" title="Click to Clear Page" onclick="clearPage();"><span class="clear"><bean:message key="label.common.Clear"/></span></a>
				<a href="#" class="button" title="Click to Return On Desk"  onClick="cancel();"><span class="back"><bean:message key="label.common.Back"/></span></a>				 
				</div></td>
	</tr>	  
</table>
</div>	
</div>	

	<input type="hidden" name="strApprovalFlag" id="strApprovalFlag"    value="1">
	<input type="hidden" name="strReApprovalFlag"  value="0">
	<input type="hidden" name="strStoreId"	 value="${transferShortageApprovalTransBean.strStoreId}" />
	<input type="hidden" name="strStoreName" value="${transferShortageApprovalTransBean.strStoreName}" />
	<input type="hidden" name="strReqDate" value="${transferShortageApprovalTransBean.strReqDate}" />
	<input type="hidden" name="strCtDate"  value="${transferShortageApprovalTransBean.strCtDate}">
	<input type="hidden" name="strPath"  value="${transferShortageApprovalTransBean.strPath}">
    <input type="hidden" name="strChk"             value="${transferShortageApprovalTransBean.strChk}">
	<input type="hidden" name="hmode" />


	<cmbPers:cmbPers />
</html:form>
</body>
</html>
