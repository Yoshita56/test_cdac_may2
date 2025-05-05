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
<title>Drug Transfer Excess Approval View</title>

<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" 	type="text/css">
<link href="../../hisglobal/css/dwh.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/js/jquery-3.3.1.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/jquery-ui.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/base64.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="JavaScript" src="../js/item_OtherDtls_util.js"></script>
<script language="JavaScript" src="../js/transferExcessApprovalTrans.js"></script>
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
<html:form name="transferExcessApprovalTransBean" action="/transactions/TransferExcessApprovalTransCNT" type="mms.transactions.controller.fb.TransferExcessApprovalTransFB" styleClass="formbg">
<input type='hidden' name='IMCS_TOKEN' value='<%=request.getSession().getAttribute("IMCS_TOKEN").toString().trim() %>'/>	

<center>
	<div class="errMsg"     id="errMsg"><bean:write    	    name="transferExcessApprovalTransBean" property="strErrMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write	name="transferExcessApprovalTransBean" property="strWarningMsg" /></div>
	<div class="normalMsg"  id="normalMsg"><bean:write   name="transferExcessApprovalTransBean" property="strNormalMsg" /></div>
</center>
<div  id ="Raising" style="display:block">
       <table class="TABLEWIDTH" align="center" cellspacing="0px" cellpadding="1">   
			 <tr class="HEADER">
				<td colspan="4"><bean:message key="label.common.Transfer_excess_approval"/> &gt;&gt; <bean:message key="label.common.Approve"/></td>
			 </tr>
		 </table>
	</div>
	<table class="TABLEWIDTH" align="center" cellspacing="0px" cellpadding="1">   
		      <bean:write name="transferExcessApprovalTransBean" property="strIndentDetails" filter="false" />
	</table>
	
	<bean:write name="transferExcessApprovalTransBean" property="strTransferOrderDetails"	filter="false" />		
	<bean:write name="transferExcessApprovalTransBean" property="strSetApprovedDetails"  filter="false" />

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
		<tr class="FOOTER">
			<td colspan="4" width="25%"></td>
		</tr>
	</table>
	
	
<div>		
	<div class="legends"><font size="2" color="red">*</font> <bean:message key="label.common.Mandatory_Field(s)"/></div>  
	<div class="control_button">
	  <table  class="TABLEWIDTH" align="center">
		<tr>
			<td align="center">
			  <div style="margin-left: 20%">	            	
				<a href="#" class="button" title="Click to Return On Desk"  onClick="cancel();"><span class="back"><bean:message key="label.common.Back"/></span></a>
		     </div>
		    </td>
		</tr>	  
	</table>
	</div>	
</div>
    <input type="hidden" name="strPath"  value="${transferExcessApprovalTransBean.strPath}">	
	<input type="hidden" name="hmode" />
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>
