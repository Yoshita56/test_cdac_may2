<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<html>
<head>
<title>Budget Comparison Detail Report</title>
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

<script language="Javascript" src="../../mms/js/dwh_budgetComparisonDetail_rpt.js"></script>


</head>
<body onload="onLoadPage();">
<html:form action="/reports/BudgetComparisonDetailRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="budgetComparisonDetailRptFB" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="budgetComparisonDetailRptFB" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="budgetComparisonDetailRptFB" property="strWarningMsg"/></div>


	<tag:tab tabLabel="Budget Comparison Detail Report" selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4"></td>
			
	</tr>
	</table>
			
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" > 	
	
<%--	Drug warehouse Type	 --%>
		<logic:equal name="budgetComparisonDetailRptFB" property="strUserLevel" value="6">
		<tr>
			<td  width="50%" colspan="2" class="LABEL"><font color="red">*</font>Institute Type</td>
			<td  width="50%" colspan="2"  class="CONTROL">
			
			<select name="strDrugWarehouseTypeId" class="comboNormal" onchange="getDrugWarehouseName();">
				<bean:write name="budgetComparisonDetailRptFB" property="strDrugWarehouseTypeCmb" filter="false"/>
				</select>
			
			</td>
		</tr>
		</logic:equal>
		
<%--	Drug warehouse Name	 --%>		
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Drug Warehouse Name</td>
			<td width="50%" colspan="2" class="CONTROL">
			<div id="strStoreDivId" >
				<select name="strStoreId" class="comboNormal" >
					<bean:write name="budgetComparisonDetailRptFB" property="strStoreValues" filter="false"/>
					
				</select>
			</div>				
			</td>
		</tr>
	
	
<%--	Financial Year --%>		
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Financial Year</td>
			<td width="50%" colspan="2" class="CONTROL">
				<html:text property="strStartFinancialYear" maxlength="4" size="4" name="budgetComparisonDetailRptFB" onkeypress="return validateData(event,5);"  />-
				<html:text property="strEndFinancialYear" maxlength="4" size="4" name="budgetComparisonDetailRptFB" onkeypress="return validateData(event,5);" />
				
			</td>
		</tr>
		
	
		<tr>
			<td width="50%" colspan="2" class="LABEL">Report Format</td>
			<td width="50%" colspan="2" class="CONTROL">
				<select name="strReportFormat"  onchange="">
					<option value="html">Html</option>
					<option value="pdf">Pdf</option>
				</select>
			</td>
			
		</tr> 
		
		<tr>
			<td width="50%" colspan="2" class="LABEL">Footer Required</td>
			<td width="50%" colspan="2" class="CONTROL">
				<html:checkbox property="strIsFooter" name="budgetComparisonDetailRptFB" value="1"></html:checkbox>
			</td>
			
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">User Remarks</td>
			<td width="50%" colspan="2" class="CONTROL">
				<input class="txtFldMax" type="text" name="strUserRemarks" >
			</td>
			
		</tr>
		<tr class="FOOTER">
			 <td colspan="4"><font color='red'>*</font>Mandatory Field </td>
		</tr>
		
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="return validate();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" name="strEndFinancialYearTemp" value="${budgetComparisonDetailRptFB.strEndFinancialYearTemp}"/>
<input type="hidden" name="strStoreName" value="${budgetComparisonDetailRptFB.strStoreName}"/>

<input type="hidden" name="strUserLevel" value="${budgetComparisonDetailRptFB.strUserLevel}"/>

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>