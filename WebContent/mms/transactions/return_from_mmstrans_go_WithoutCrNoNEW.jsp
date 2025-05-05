<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>


<html>
<head>
<meta charset=UTF-8">
<title>Return Process</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/advanceRequestTrans.js"></script>
<script language="Javascript" src="../js/returnFrom_mmsTrans_go_WithoutCrNo.js"></script>


<script language="Javascript" src="../js/mms.js"></script>
<script type="text/javascript">

</script>
</head>

<body >
<html:form action="/transactions/ReturnFromTransCNT.cnt" name="duplicateIssueToPatientVoucherTransBean" type="mms.transactions.controller.fb.ReturnFromTransFB" method="post">
	<div class="errMsg" id="errMsg"><bean:write name="duplicateIssueToPatientVoucherTransBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="duplicateIssueToPatientVoucherTransBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="duplicateIssueToPatientVoucherTransBean" property="strMsg" /></div>


	<logic:equal value="0" name="duplicateIssueToPatientVoucherTransBean" property="strMode" >
	<tag:tab tabLabel="Return From Patient" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab>
	<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
	<tr class="HEADER"> 
	 <td colspan="4">
    </td>
    </tr>
    </table>
	</logic:equal>
	
	<logic:equal value="1" name="duplicateIssueToPatientVoucherTransBean" property="strMode" >
	<tag:tab tabLabel="Return From Staff" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab>
	<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
	<tr class="HEADER"> 
	 <td colspan="4"></td>
    </tr>
    </table>
	</logic:equal>
	
	
	<logic:equal value="2" name="duplicateIssueToPatientVoucherTransBean" property="strMode" >
	<tag:tab tabLabel="Return From Patient/Staff" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab>
	<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
	<tr class="HEADER"> 
	 <td colspan="4">Return From Patient/Staff&gt;&gt;
    </td>
    </tr>
    </table>
	</logic:equal>

	
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Search By</td>
			<td width="50%" colspan="2" class="CONTROL">
				<html:select name="duplicateIssueToPatientVoucherTransBean"	property="strSearchByPatientNameOrCrNo">
					<html:option value="1">CR No.</html:option>
					<html:option value="2">Patient Name</html:option>
				</html:select>
			
				<html:text property="strPatNameOrCrNo" name="duplicateIssueToPatientVoucherTransBean" />				
				
			 </td>
 			<td width="25%" colspan="1" class="CONTROL"> </td>
						
		</tr>
		
		 <tr> 
			    <td width="25%" class="LABEL"><font color="red">*</font>From Date</td>
					<td width="25%" class="CONTROL">
						<dateTag:date name="strFromDate"	value="${duplicateIssueToPatientVoucherTransBean.strCtDate}"></dateTag:date>
					</td>
			  
		 
		    <td width="25%" class="LABEL"><font color="red">*</font>To Date</td>
				<td width="25%" class="CONTROL">
				<dateTag:date name="strToDate"	value="${duplicateIssueToPatientVoucherTransBean.strCtDate}"></dateTag:date>
			</td>
		   	   
		  </tr>
		  
		  <tr> 
		  <td colspan="4" class="CONTROL">
		  	<div align="center">
			  <input type="image" style="cursor: pointer; " title="Return Process" align="top"
					src="../../hisglobal/images/btn-search.png" name="search" value="Search"
					onclick="return getIssueDetailsBasedOnPatientNameOrCrNo();" onkeypress="if(event.keyCode==13) getIssueDetailsBasedOnPatientNameOrCrNo();">
			</div>		
		 </td>
		  </tr>
	</table>
	
<!--	-->
	
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
			<tr>
				<td class="TITLE" >Issue Details</td>
			</tr>
 
		</table>
		
			<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1" >
				<bean:write name="duplicateIssueToPatientVoucherTransBean" property="strEnteredIssueDetailsTable" filter="false"/>
		</table>	
<!--	-->

			<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
				<tr class="FOOTER">
					<td colspan="4"><font color="red">*</font> Mandatory Fields</td>
				</tr>
			</table>
			
			<table border="0" class="TABLEWIDTH" align="center" cellpadding="1"
				cellspacing="1">
				<tr>
					<td align="center">
					   <!--  <img style=" cursor: pointer" src="../../hisglobal/images/btn-sv.png" onclick="return validate1();" /> 
						<img style=" cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="clearIssue();">
					    <img style=" cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancel();">
					     -->
					    <br>
					    <a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
							<a href="#" class="button"	onclick="clearIssue()"><span class="clear">Clear</span></a> 
							<a href="#" class="button" onclick="cancel();"><span class="cancel">Cancel</span></a>
					</td>
		
				</tr>
			</table>
			
	<input type="hidden" name="hmode" />
	<input type="hidden" name="storeName" value="${duplicateIssueToPatientVoucherTransBean.storeName}" />
	<input type="hidden" name="itemCatName" value="${duplicateIssueToPatientVoucherTransBean.itemCatName}" />
	<input type="hidden" name="crNo" value="${duplicateIssueToPatientVoucherTransBean.crNo}" />
	<input type="hidden" name="strCrNo" value="${duplicateIssueToPatientVoucherTransBean.crNo}" />
	<input type="hidden" name="strId" value="${duplicateIssueToPatientVoucherTransBean.strId}" />
	<input type="hidden" name="itemCategory" value="${duplicateIssueToPatientVoucherTransBean.itemCategory}" />
	<input type="hidden" name="strConfCatCode" value="${duplicateIssueToPatientVoucherTransBean.strConfCatCode}" />
	<input type="hidden" name="mode" value="${duplicateIssueToPatientVoucherTransBean.strMode}" />
	<input type="hidden" name="strMode"   value="${duplicateIssueToPatientVoucherTransBean.strMode}">
	<input type="hidden" name="strIssueMode"   value="${duplicateIssueToPatientVoucherTransBean.strIssueMode}">
	<input type="hidden" name="strReturnDrugValidity"   value="${duplicateIssueToPatientVoucherTransBean.strReturnDrugValidity}">
	<input type="hidden" name="strIssueNumber"   value="${duplicateIssueToPatientVoucherTransBean.strIssueNumber}">

	<input type="hidden" name="flagWithoutCrNo"   value="${duplicateIssueToPatientVoucherTransBean.flagWithoutCrNo}">
	
	
		<input type="hidden" name="strCtDate"   value="${duplicateIssueToPatientVoucherTransBean.strCtDate}">
	

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>