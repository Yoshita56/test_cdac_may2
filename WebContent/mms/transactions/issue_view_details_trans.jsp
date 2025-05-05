<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=UTF-8">
<title>Issue Details View</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/popup.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/issue_view_details.js"></script>

</head>
<body >
<html:form name="issueViewDetailsBean" action="/transactions/IssueViewDetailsCNT"
	type="mms.transactions.controller.fb.IssueViewDetailsFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="issueViewDetailsBean" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="issueViewDetailsBean" property="strWarning"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="issueViewDetailsBean" property="strMsg"/></div>
	
</center>
	<tag:tab tabLabel="Issue Details View"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>
<div class='popup' id='approvedDtl' style="display:none">
	<table width='400' border="0" cellspacing ="1" cellpadding="1">
		<tr class="HEADER"> 
			
			<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('approvedDtl');"></th>
	    </tr>
	 </table>   
	 <table width='400' border="0" cellspacing ="1" cellpadding="1"  bgcolor='#6097BC'>
		<tr>
			<td colspan="1" class='multiLabel' >Approved By</td>
			<td colspan="1" class='multiLabel'>Approved Date</td>
			<td colspan="1" class='multiLabel'>Sanctioned Qty</td>
			
		</tr>
		<tr>
			<td colspan="1" class='multiControl'><div id ='1'></div></td>
			<td colspan="1" class='multiControl'><div id ='2'></div></td>
			<td colspan="1" class='multiControl'><div id ='3'></div></td>
		  
		</tr>
        </table>
	</div>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="4"></td>
	</tr>
	
	<tr>
		<td class="LABEL" width="25%" colspan="1">Issue No</td>
    	<td width="25%" class ="CONTROL" colspan="1">
    	<bean:write name="issueViewDetailsBean" property="strIssueNo" filter="false" /></td>
    	
    	<td class="LABEL" width="25%" >Issue Date</td>
       	 <td class="CONTROL" width="25%" >
       	 <bean:write name="issueViewDetailsBean" property="strIssueDate" filter="false" />
</td>
 
	</tr>
		
		
<tr>
    <td class="LABEL" width="25%" colspan="1">Issuing Store</td>
    <td width="25%" class ="CONTROL" colspan="1">
    <bean:write name="issueViewDetailsBean" property="strIssuingStore" filter="false" /></td>
    
   <td class="LABEL" width="25%" colspan="1">Ack Status</td>
    <td width="25%" class ="CONTROL" colspan="1">
    <bean:write name="issueViewDetailsBean" property="strAckStatus" filter="false" />
     </td>
       
  </tr>
  <tr>
		<td class="LABEL" width="25%" colspan="1">Indent No</td>
    	<td width="25%" class ="CONTROL" colspan="1">
    	<bean:write name="issueViewDetailsBean" property="strIndentNo" filter="false"/>
    	 </td>
    	<td class="LABEL" width="25%" >Indent Date</td>
       	 <td class="CONTROL" width="25%" >
       	 <bean:write name="issueViewDetailsBean" property="strIndentDate" filter="false" />
       	 
       	 </td>
 	</tr>
  <tr>
    <td class="LABEL" width="25%" colspan="1">Indent Type</td>
    <td width="25%" class ="CONTROL" colspan="1">
    <bean:write name="issueViewDetailsBean" property="strIndentType" filter="false" />
     </td>
   <td class="LABEL" width="25%" colspan="1">Drug Category</td>
    <td width="25%" class ="CONTROL" colspan="1">
    <bean:write name="issueViewDetailsBean" property="strItemCategory" filter="false" /> </td>
       
  </tr>
   <tr>
    <td class="LABEL" width="25%" colspan="2">Raising Store</td>
    <td width="25%" class ="CONTROL" colspan="2">
     <bean:write name="issueViewDetailsBean" property="strRaisingStore" filter="false" /></td>
   
  </tr>
   
	
  
   </table>
   <table class="TABLEWIDTH" align="center"cellpadding="1" cellspacing="1">
   <tr>
   <td colspan="6" class="TITLE">Drug Details</td>
   </tr>
   </table>
   <table class="TABLEWIDTH" align="center"cellpadding="1" cellspacing="1" bgcolor='black'>
   <tr>
	   <td class='multiLabel' width='20%'>Drug Name</td>
	   <td class='multiLabel' width='20%'>Brand Name</td>
	   <td class='multiLabel' width='15%'>Rate Unit</td>
	   <td class='multiLabel' width='15%'>Req Qty</td>
	   <td class='multiLabel' width='15%'>Approve Qty</td>
	   <td class='multiLabel' width='15%'>Issue Qty</td>
     </tr>
     <tr>
     
   </table>

	 <bean:write name="issueViewDetailsBean" property="strItemDetails" filter="false" />
	 
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr class="HEADER">
			<td  ></td>
	</tr>
		
		<tr>

			<td align="center">
			<img  style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" onClick="cancel();" >
		</td>
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<cmbPers:cmbPers/>
</html:form>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>