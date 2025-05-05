<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

 
 
<html>
<head>
<meta charset=UTF-8">
<title>Help Desk View</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/HelpDesk_View_trans.js"></script>

</head>
<body>
<html:form name="HelpDeskTransBean" action="/transactions/HelpDeskCNT"
	type="mms.transactions.controller.fb.HelpDeskFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="HelpDeskTransBean" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="HelpDeskTransBean" property="strWarning"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="HelpDeskTransBean" property="strMsg"/></div>
	
</center>
		<tag:tab tabLabel="Help Desk View"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="4"></td>
	</tr>
		
   </table>
 
	<bean:write name="HelpDeskTransBean" property="strAcknowledgeDetails" filter="false"/>
	
	
	
	
	<div id="downloadDiv"></div>
	
	
	
	 <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
  		
		
		
  
  		<tr class="FOOTER">
			 <td colspan="4"></td>
		</tr>
		<tr>
			<td align="center" colspan="4">
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" title="Click to Return On Desk" onClick="cancelToDesk();" >
			</td>
		</tr>
	</table>

	 <div id="showButtonID" style="display:none;">	</div> 
	
<input type="hidden" name="hmode"/>

 <input type="hidden" name="strPath" value="${HelpDeskTransBean.strPath}">
 <!--<input type="hidden" name="strComboVal" value="${HelpDeskTransBean.strComboVal}"> -->
<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>