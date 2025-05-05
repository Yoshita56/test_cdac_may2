<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Budget Detail Report</title>
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

<script language="Javascript" src="../../mms/js/dwh_budgetDetail_rpt.js"></script>


</head>
<body >
<html:form action="/reports/BudgetDetailRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="budgetDetailRptFB" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="budgetDetailRptFB" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="budgetDetailRptFB" property="strWarningMsg"/></div>


	<tag:tab tabLabel="Budget Detail Report" selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4"></td>
			
	</tr>
	</table>
			
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" > 	
	
	<tr>
		<td width="50%" colspan="2" class="LABEL">
		
		<html:checkbox property="strWhetherToShowDataForNoBudgetAllocatedCheckBox" name="budgetDetailRptFB" value="1" onclick="" />
		
		</td>
		
		<td width="50%" colspan="2" class="CONTROL">Whether To Show Data For District For Which No Budget Allocated	</td>
	</tr>
	
	<tr>
		<td width="50%" colspan="2" class="LABEL">
		
		<html:checkbox property="strWhetherToShowNoOfBedsCheckBox" name="budgetDetailRptFB" value="1" onclick="" />
		
		</td>
		
		<td width="50%" colspan="2" class="CONTROL">Whether To Show Number Of Beds</td>
	</tr>
	
	
	
<%-- District Drug warehouse Name	 --%>		
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>District Drug Warehouse Name</td>
			<td width="50%" colspan="2" class="CONTROL">
			<div id="strStoreDivId" >
				<select name="strStoreId" class="comboNormal" >
					<bean:write name="budgetDetailRptFB" property="strStoreValues" filter="false"/>
				</select>
			</div>				
			</td>
		</tr>
		
	
	
<%--	Drug warehouse Type	 --%>

		<tr>
			<td  width="50%" colspan="2" class="LABEL">Institute Type</td>
			<td  width="50%" colspan="2"  class="CONTROL">
			
			<select name="strDrugWarehouseTypeId" class="comboNormal" >
				<bean:write name="budgetDetailRptFB" property="strDrugWarehouseTypeCmb" filter="false"/>
				</select>
			
			</td>
		</tr>
		
		<tr>
			<td class="LABEL" colspan="2"><font color="red">*</font>Financial Year</td>
			<td class="CONTROL" colspan="2">			
			    <html:select name="budgetDetailRptFB" property="strIndentPeriodValue" styleClass="comboNormal" >
	          	   <html:option value="strCurrentFinancialYear"> <bean:write name="budgetDetailRptFB" property="strCurrentFinancialYear" filter="false"/></html:option>
				   <html:option value="strNextFinancialYear"> <bean:write name="budgetDetailRptFB" property="strNextFinancialYear" filter="false"/></html:option>	          	
	            </html:select>			   
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
				<html:checkbox property="strIsFooter" name="budgetDetailRptFB" value="1"></html:checkbox>
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
<input type="hidden" name="strEndFinancialYearTemp" value="${budgetDetailRptFB.strEndFinancialYearTemp}"/>
<input type="hidden" name="strCurrentDate" value="${budgetDetailRptFB.strCurrentDate}"/>
<input type="hidden" name="strStoreName" value="${budgetDetailRptFB.strStoreName}"/>
<input type="hidden" name="strDwhStoreName" value="${budgetDetailRptFB.strDwhStoreName}"/>


<input type="hidden" name="strStartFinancialYear" />
<input type="hidden" name="strEndFinancialYear" />

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>