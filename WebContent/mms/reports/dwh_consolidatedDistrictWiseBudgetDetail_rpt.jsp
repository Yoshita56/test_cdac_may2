<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Consolidated District Wise Budget Detail Report</title>
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


<script type="text/javascript">

function validate(){

	var hisValidator = new HISValidator("consolidatedDistrictWiseBudgetDetailRptFB");

		hisValidator.addValidation("strStartFinancialYear", "req","Start Financial Year is a mandatory field");

//		hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
//		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
//		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
//		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

if(retVal)
{
		var strStartFinancialYear =document.getElementsByName("strStartFinancialYear")[0].value.split("");
		var strEndFinancialYear =document.getElementsByName("strEndFinancialYear")[0].value.split("");
		

		if(strStartFinancialYear.length!=4 || strEndFinancialYear.length!=4)
		{
			alert("Start Financial Year and End Financial Year should be of 4 digit length");
			return false;
		}

	document.forms[0].strEndFinancialYear.disabled=false;
	
	document.forms[0].strEndFinancialYearTemp.value = document.forms[0].strEndFinancialYear.value;
		
	document.forms[0].strEndFinancialYear.disabled=true;
	
	
		document.forms[0].hmode.value = "SHOWRPT";
		
			if(document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html")
			{
				document.forms[0].target = "_self";
			}else{
				document.forms[0].target = "_blank";
			}
		document.forms[0].submit();
		}else{
			return false;
		}
	}

	

function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}

function setEndFinancialYear()
{
	document.forms[0].strEndFinancialYear.value=parseInt(document.forms[0].strStartFinancialYear.value)+parseInt("1"); 
}


</script>
</head>
<body >
<html:form action="/reports/ConsolidatedDistrictWiseBudgetDetailRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="consolidatedDistrictWiseBudgetDetailRptFB" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="consolidatedDistrictWiseBudgetDetailRptFB" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="consolidatedDistrictWiseBudgetDetailRptFB" property="strWarningMsg"/></div>


	<tag:tab tabLabel="Consolidated District Wise Budget Detail Report" selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4">Consolidated District Wise Budget Detail Report</td>
			<!--  
			  <td align="right" >
		     	<span>
		     		<html:checkbox property="strWhetherToShowDataForNoBudgetAllocatedCheckBox" name="consolidatedDistrictWiseBudgetDetailRptFB" value="1" onclick="">Whether to show Data for which no budget allocated</html:checkbox>
		     	</span>
		     </td>	
			-->
		</tr>
	</table>
			
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" > 	
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Financial Year</td>
			<td width="50%" colspan="2" class="CONTROL">
				<html:text property="strStartFinancialYear" maxlength="4" size="4" name="consolidatedDistrictWiseBudgetDetailRptFB" onkeypress="return validateData(event,5);" onkeyup="return setEndFinancialYear();" />-
				<html:text property="strEndFinancialYear" maxlength="4" size="4" name="consolidatedDistrictWiseBudgetDetailRptFB" disabled="true" onkeypress="return validateData(event,5);" />
				
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
				<html:checkbox property="strIsFooter" name="consolidatedDistrictWiseBudgetDetailRptFB" value="1"></html:checkbox>
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
<input type="hidden" name="strCurrentDate" value="${consolidatedDistrictWiseBudgetDetailRptFB.strCurrentDate}"/>
<input type="hidden" name="strEndFinancialYearTemp" value="${consolidatedDistrictWiseBudgetDetailRptFB.strEndFinancialYearTemp}"/>



</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>