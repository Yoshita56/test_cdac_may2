<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=UTF-8">
<title>Physical Stock Verification View</title>

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
			<td colspan="4">Physical Stock Verification View</td>
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
	    
	 
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="0">
	<tr class="FOOTER">
               <td width="TABLEWIDTH" colspan="2" ></td>
    </tr>
    </table>
    
<div><div class="legends"><font size="2" color="red">*</font>Mandatory Field(s)</div>  
<div class="control_button"><table  class="TABLEWIDTH" align="center">
	<tr id="saveId">
	<td align="center"><div style="margin-left:20%">
				<a href="#" style="cursor:pointer;" title="Click to Return to Main Menu" class="button" onClick="cancelToDesk();"><span class="back">Back</span></a>				 
				</div></td>
	</tr>	  
</table></div>
</div>	         
    
	<input type="hidden" name="hmode"/>
	<input type="hidden" name="strPath" value="${physicalNewStockTransBean.strPath}">

	<cmbPers:cmbPers/>
	</html:form>
		<tag:autoIndex></tag:autoIndex>   
</body>
</html>