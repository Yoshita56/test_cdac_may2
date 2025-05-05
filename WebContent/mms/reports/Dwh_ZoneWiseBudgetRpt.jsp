<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Zone Wise Budget Detail Report</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
	
<style type="text/css">

            .pg-normal 
            {
                color: blue;
                font-weight: normal;
                text-decoration: none;
                cursor: pointer;
                
                
            }
            .pg-selected 
            {
                color: red;
                font-weight: bold;
                text-decoration: underline;
                cursor: pointer;
                
            }
            .pg-qualified 
            {
                color: green;
                font-weight: bold;
                text-decoration: underline;
                cursor: pointer;
                
            }
            </style>

<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="Javascript" src="../../hisglobal/js/time.js"></script>

<script language="Javascript" src="../../mms/js/Dwh_ZoneWiseBudgetRpt.js"></script>

</head>
<body >
<html:form action="/reports/Dwh_ZoneWiseBudgetRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="Dwh_ZoneWiseBudgetRptFB" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="Dwh_ZoneWiseBudgetRptFB" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="Dwh_ZoneWiseBudgetRptFB" property="strWarningMsg"/></div>


	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4"><strong>ZONE WISE BUDGET DETAIL REPORT</strong></td>
			
	</tr>
	</table>
			
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" > 	
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Financial Year</td>
			<td width="50%" colspan="2" class="CONTROL">
				<html:text property="strStartFinancialYear" maxlength="4" size="4" name="Dwh_ZoneWiseBudgetRptFB" onkeypress="return validateData(event,5);" onkeyup="return setEndFinancialYear();" />-
				<html:text property="strEndFinancialYear" maxlength="4" size="4" name="Dwh_ZoneWiseBudgetRptFB" disabled="true" onkeypress="return validateData(event,5);" />
				
			</td>
		</tr>
		
		
		<tr>
			<td width="50%" colspan="2" class="LABEL">Report Format</td>
			<td width="50%" colspan="2" class="CONTROL">
				<select name="strReportFormat"  onchange="">
					<option value="html">Html</option>
					
				</select>
			</td>
			
		</tr> 
		
		<tr>
			<td width="50%" colspan="2" class="LABEL">Footer Required</td>
			<td width="50%" colspan="2" class="CONTROL">
				<html:checkbox property="strIsFooter" name="Dwh_ZoneWiseBudgetRptFB" value="1"></html:checkbox>
			</td>
			
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">User Remarks</td>
			<td width="50%" colspan="2" class="CONTROL">
				<input class="txtFldMax" type="text" name="strUserRemarks" >
			</td>
			
		</tr>
		
		
	</table>
	
	

<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
	
	<tr class="FOOTER">
			 <td colspan="4"><font color='red'>*</font>Mandatory Field </td>
		</tr>
		
		<tr>
		  
		  <td colspan="4"><div id='id' align='center'>
		  <img style="cursor: pointer" src="../../hisglobal/images/print_tab.gif" onClick="getZoneWiseBudgetDtlPrint();"/>
		  <img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="resetPage();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
		  </div></td>
		</tr>
		</table>
		

	
	<input type="hidden" name="hmode"></input>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>