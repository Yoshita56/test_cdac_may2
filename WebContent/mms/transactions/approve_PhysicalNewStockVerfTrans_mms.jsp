<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=UTF-8">
<title>Approval View</title>


<link href="../../hisglobal/css/dwh.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/innerxhtml.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script language="JavaScript" src="../js/NewPhysicalStockDtl.js"></script>
<script>
$(function() 
{
	var divHeight=200;
	var initialHeight=716;
	var heightPer = (divHeight*100)/initialHeight; 
    var newHeight = parseInt((window.innerHeight * heightPer)/100,10);		
	fixedHeaderTableTrans("phyStockDiscVerifiedItemDtls",newHeight,"wrapper","tableHeaderId");
	fixedHeaderTableTransCustomize("phyStockNonDiscVerifiedItemDtls",newHeight, "wrapper1","tableHeaderId1");
});
</script>

	
</head>
<body class="background" >
<html:form name="physicalNewStockTransBean"
	action="/transactions/PhysicalNewStockVerfTransCNT"
	type="mms.transactions.controller.fb.PhysicalNewStockVerfTransFB" styleClass="formbg">
	
<center>
   <div class="errMsg"     id="errMsg"><bean:write name="physicalNewStockTransBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="physicalNewStockTransBean" property="strWarning"/></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="physicalNewStockTransBean" property="strMsgSaved"/></div>
	
</center>

	     <table class="TABLEWIDTH" align="center" cellspacing="0" cellpadding="1">   
		 <tr class="HEADER">
			<td colspan="4">Physical Stock Verification Approval</td>
		 </tr>
		 </table>
		 <bean:write name="physicalNewStockTransBean" property="strIndentDetails"	        filter="false" />	
		 <div id="phyStockDiscVerifiedItemDtls">	 
		   <bean:write name="physicalNewStockTransBean" property="strDiscItemDetails"			filter="false" />
		 </div>		
		 <br>
		 <div id="phyStockNonDiscVerifiedItemDtls">
		    <bean:write name="physicalNewStockTransBean" property="strNonDiscItemDetails"	    filter="false" />
		 </div>		
		 <bean:write name="physicalNewStockTransBean" property="strSetApprovedDetails" 		filter="false" />
	    
	 
	<table class="TABLEWIDTH" align="center" cellspacing="0px" cellpadding="1"> 
		    <tr>
				<td class="LABEL" width="25%">Approval_status</td>
				<td width="25%" class="CONTROL" colspan="3">
				<input type="radio" name="strApproved" value="1" checked="checked" onClick="FuncTick(this);"/>Approved 
				<input type="radio" name="strRejected" value="2" onClick="FuncTick(this);"/>Rejected
				</td>
			</tr>
		</table>
		
		<table class="TABLEWIDTH" align="center" cellspacing="0px" cellpadding="1">
			<tr>
				<td width="50%" class="LABEL" ><div id="remarks">remarks</div></td>
				<td width="50%" class="CONTROL" colspan="3">
				  <textarea	name="strRemarks" cols="25" rows="2"></textarea>
				</td>
		   </tr>
	   </table>
	 	
	   <table  class="TABLEWIDTH" align="center">
		 <tr class="FOOTER">
	         <td width="TABLEWIDTH" colspan="2" ></td>
	     </tr>
	   </table>			

<div>
<div class="legends"><font size="2" color="red">*</font> Mandatory_Field(s)</div>  
	<div class="control_button">
		<table  class="TABLEWIDTH" align="center">
			<tr id="saveId">
			  <td align="center">
			    <div >
					<a href="#" style="cursor:pointer;" title="Click to Save Record" class="button" onClick="validateApproval();"><span class="verify">Verify</span></a>
					<a href="#" style="cursor:pointer;" title="Click to Clear Page" class="button" onclick="initPage1();"><span class="clear">Clear</span></a>
					<a href="#" style="cursor:pointer;" title="Click Here Go Back To Main Desk" class="button" onClick="cancelToDesk();"><span class="back">Back</span></a>				 
				</div>
			  </td>
			</tr>	  
		</table>
	</div>
</div>	           		
    
	<input type="hidden" name="hmode"/>
	<input type="hidden" name="strApprovalFlag"    value="${physicalNewStockTransBean.strApprovalFlag}">
	<input type="hidden" name="strReApprovalFlag"  value="${physicalNewStockTransBean.strReApprovalFlag}">		
	<input type="hidden" name="strLevelType"       value="${physicalNewStockTransBean.strLevelType}">
	<input type="hidden" name="strReqTypeId"       value="${physicalNewStockTransBean.strReqTypeId}">
	<input type="hidden" name="strPath"            value="${physicalNewStockTransBean.strPath}">
	<input type="hidden" name="strChk"             value="${physicalNewStockTransBean.strChk}">

	<cmbPers:cmbPers/>
	</html:form>
		<tag:autoIndex></tag:autoIndex>   
</body>
</html>