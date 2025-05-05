<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Debtor Register Report</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="Javascript" src="../../hisglobal/js/time.js"></script>

<script language="Javascript" src="../../mms/js/dwh_debotorRegister_rpt.js"></script>


</head>
<body >
<html:form action="/reports/DebtorRegisterRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="debtorRegisterRptFB" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="debtorRegisterRptFB" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="debtorRegisterRptFB" property="strWarningMsg"/></div>


	<tag:tab tabLabel="Debtor Register Report" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4"></td>
			
	</tr>
	</table>
			
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" > 	
	
		<tr>
			<td width="50%" colspan="2" class="LABEL">District Drug Warehouse Name</td>
			<td width="50%" colspan="2" class="CONTROL">
			<div id="strStoreDivId" >
				<select name="strStoreId" class="comboNormal" >
					<bean:write name="debtorRegisterRptFB" property="strStoreValues" filter="false"/>
				</select>
			</div>				
			</td>
		</tr>
		
		
	
		
		
     </table>
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">

 
         <tr>
			<td class="LABEL" colspan="1"><font color="red">*</font>From Date</td>
			<td class="CONTROL" colspan="1"><dateTag:date name="strFromDate" value="${debtorRegisterRptFB.strCurrentDate}" /></td>
			<td class="LABEL" colspan="1"><font color="red">*</font>To Date</td>
			<td class="CONTROL" colspan="1"><dateTag:date name="strToDate" value="${debtorRegisterRptFB.strCurrentDate}" /></td>
		</tr>
		<tr>
		  
		  <td class="CONTROL" colspan="4"><div id='id' align='center'><img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="genrateUnitList();" /></div></td>
		</tr>		
		

		<tr style="display: none;">
			<td width="50%" colspan="2" class="LABEL">Report Format</td>
			<td width="50%" colspan="2" class="CONTROL">
				<select name="strReportFormat"  onchange="">
					<option value="html">Html</option>
					<option value="pdf" selected="selected">Pdf</option>
				</select>
			</td>
			
		</tr> 
		
		<tr style="display: none;">
			<td width="50%" colspan="2" class="LABEL">Footer Required</td>
			<td width="50%" colspan="2" class="CONTROL">
				<html:checkbox property="strIsFooter" name="debtorRegisterRptFB" value="1"></html:checkbox>
			</td>
			
		</tr>
		<tr style="display: none;">
			<td width="50%" colspan="2" class="LABEL">User Remarks</td>
			<td width="50%" colspan="2" class="CONTROL">
				<input class="txtFldMax" type="text" name="strUserRemarks" >
			</td>
			
		</tr>
		
	</table>
	
	
	
	<div id="consolidatedPODetailDIV"></div>
	
	
	<div id="consolidatedChallanDetailDIV"></div>
	 
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
	
	<tr class="FOOTER">
			 <td colspan="4"><font color='red'>*</font>Mandatory Field </td>
		</tr>
		</table>
 	
  <div id="showButtonID" style="display:none;"> 	
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/print_tab.gif" onClick="return validate();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table>
  </div>
	
	
	
<input type="hidden" name="hmode"/>
<input type="hidden" name="strEndFinancialYearTemp" value="${debtorRegisterRptFB.strEndFinancialYearTemp}"/>
<input type="hidden" name="strCurrentDate" value="${debtorRegisterRptFB.strCurrentDate}"/>

<input type="hidden" name="strStoreName" value="${debtorRegisterRptFB.strStoreName}"/>
<input type="hidden" name="strProcRelatedValue" />


</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>