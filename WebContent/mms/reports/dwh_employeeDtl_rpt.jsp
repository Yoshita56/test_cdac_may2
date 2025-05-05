<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>



<html>
<head>
<title>Employee Detail Report</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	

<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>	
<script type="text/javascript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/dwh_employeeDtl_rpt.js"></script>
<script language="JavaScript" src="../js/dateDifference.js"></script>
<script language="JavaScript">

function hideDrugDetails(divId) 
{
	hide_popup_menu(divId);
}


</script>

</head>
<body >
<html:form name="employeeDetailRptFB" action="/reports/EmployeeDetailRptCNT" type="mms.reports.controller.fb.EmployeeDetailRptFB">
	<div id="errMsg" class="errMsg"><bean:write name="employeeDetailRptFB" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="employeeDetailRptFB" property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="employeeDetailRptFB" property="strMsg" /></div>

	<tag:tab tabLabel="Employee Detail Report" selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>
              
              <table class="TABLEWIDTH" align="center" cellspacing="1px">   
	   	
	   		   	
		<tr class="HEADER">
			<td colspan="3" style="width: 760px"></td>
		</tr>
				
	    </table>
              
              
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	     
	     <tr>
			<td width="25%" colspan="2" class="LABEL">District Name</td>
			<td width="25%" colspan="2" class="CONTROL">
			   <select name="strDistrictId" class='comboMax' >
				<bean:write name="employeeDetailRptFB" property="strDistrictNameCombo" filter="false" />
					</select>			 
			</td>	
					
	   	</tr>
	   	
	   	 <tr>
			<td width="25%" colspan="2" class="LABEL">Designation Name</td>
			<td width="25%" colspan="2" class="CONTROL">
			   <select name="strDesignationId" class='comboMax' >
				<bean:write name="employeeDetailRptFB" property="strDesignationNameCombo" filter="false" />
					</select>			 
			</td>	
					
	   	</tr>
	   	
	   	
	   
	    <tr style="display: none;">
			<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>From Date</td>
			<td class="CONTROL" width="25%" colspan="1"><dateTag:date name="strFromDate" value="${employeeDetailRptFB.strCtDate}" /></td>
			<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>To Date</td>
			<td class="CONTROL" width="25%" colspan="1"><dateTag:date name="strToDate" value="${employeeDetailRptFB.strCtDate}" /></td>
		</tr>	 
	   </table>
	   	
	    <table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">

           <tr>
			<td width="50%" colspan="2" class="LABEL">
			Report Format
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<select name="strReportFormat"  onchange="">
			<option value="html">Html</option>
			<option value="pdf">Pdf</option></select>
			</td>
			
		</tr> 
		
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			Footer Required
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<html:checkbox property="strIsFooter" name="employeeDetailRptFB" value="1"></html:checkbox>
			</td>
			
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			User Remarks
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<input class="txtFldMax" type="text" name="strUserRemarks" >
			</td>
			
		</tr>
		 </table>
	   	
	    <table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		
	     <tr class="FOOTER">
			 <td colspan="4"><font color='red'>*</font>Mandatory Field </td>
		</tr>
		</table>
	<div id="showButtonID" style="display:block;"> 
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="validate1();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="clearViewPage();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table>
</div>
	
	
	
	
<input type="hidden" name="hmode"/>

<input type="hidden" name="strStoreName" value=""/>
<input type="hidden" name="strLabName" value=""/>
<input type="hidden" name="strStatus" value=""/>

</html:form>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>