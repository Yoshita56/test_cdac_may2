<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<!--  
 * Developer : Tanvi Sappal
 * Version : 1.0 
 * Date : 13/April/2009
 *  Module:MMS
 * Unit:Inspection Issue  
 -->
 


<html>
<head>
<meta charset=UTF-8">
<title>Bill Approval View</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/inspectiondesk_issue_trans_mms.js"></script>


</head>
<body>
<html:form name="inspectionDeskIssueBean" action="transactions/InspectionDeskIssueTransCNT"
	type="mms.transactions.controller.fb.InspectionDeskIssueTransFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="inspectionDeskIssueBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="inspectionDeskIssueBean" property="strWarningMsg"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="inspectionDeskIssueBean" property="strNormalMsg"/></div>
	

			<tag:tab tabLabel="Inspection Desk Issue"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>
</center>

<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="4"></td>
	</tr>
	
</table>



<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">

<tr>
	
    <td class="LABEL" width="25%">Request No</td>
    <td width="25%" class ="CONTROL">
    <bean:write name="inspectionDeskIssueBean" property="strRequestNo" filter="false" /></td>
    
    <td class="LABEL" width="25%">Request Date</td>
    <td width="25%" class ="CONTROL">
    <bean:write name="inspectionDeskIssueBean" property="strRequestDate" filter="false" />
     </td>      
  </tr>
	<tr>
	
    <td class="LABEL" width="25%">PO No</td>
    <td width="25%" class ="CONTROL">
    <bean:write name="inspectionDeskIssueBean" property="strPONo" filter="false" /></td>
    
    <td class="LABEL" width="25%">PO Date</td>
    <td width="25%" class ="CONTROL">
    <bean:write name="inspectionDeskIssueBean" property="strPODate" filter="false" />
     </td>      
  </tr>
  
  <tr>
   <td class="LABEL" width="25%">Supplier Name</td>
    <td width="25%" class ="CONTROL">
    <bean:write name="inspectionDeskIssueBean" property="strSupplierName" filter="false" />
     </td>
    <td class="LABEL" width="25%">Drug Category</td>
    <td width="25%" class ="CONTROL">
    <bean:write name="inspectionDeskIssueBean" property="strItemCategory" filter="false" />
     </td>
  </tr>
  
  <tr>
  		<td class="LABEL" width="25%">Committee Name</td>
    	<td width="25%" class ="CONTROL" colspan="3">
    	<bean:write name="inspectionDeskIssueBean" property="strCommitteeName" filter="false" />
    	 </td>
 	</tr> 
</table>



<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr><td class="TITLE" colspan="4">Drug Details</td></tr>
	
</table>

             <bean:write name="inspectionDeskIssueBean" property="strItemDetails" filter="false"/>
             


	 
		 <table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">
         <tr>
			<td width="50%" class="LABEL">Remarks</td>
			<td width="50%" class="CONTROL" colspan="3">
			  <div align="left">
        		<textarea name="strRemarks" rows="2"></textarea>
              </div>
			</td>
		</tr>
        
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	
	
		<tr>
			<td colspan="4" align="center">
			<br>
			<!-- <img style="cursor: pointer; " title="Save Record" src="../../hisglobal/images/btn-sv.png" onClick=" return validate1();" /> 
			<img style="cursor: pointer; " title="Clear Content"  src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset()" />
            <img style="cursor: pointer; " title="Cancel Process" src="../../hisglobal/images/btn-ccl.png" onClick="cancel();" /></td> -->
            <a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
			<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
			<a href="#" class="button" onclick="cancel();"><span class="cancel">Cancel</span></a>
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" name="strPath" value="${inspectionDeskIssueBean.strPath}"/>
<input type="hidden" name="strChkTemp" value="${inspectionDeskIssueBean.strChkTemp}"/>


</html:form>	
	<tag:autoIndex></tag:autoIndex>  
</body>
</html>

