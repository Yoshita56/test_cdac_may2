<%-- 
author 	: Niharika Srivastava
Date of Creation : 15-09-10
Process : Serial No Generation Transaction 
Module 	: MMS
TL 		: Mr. Ajay Kumar Gupta
Description : Reprint Page for Serial No Generation Transaction
 --%>
 
<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<html>
<head>
<meta charset=UTF-8">
<title>Serial No Generation Reprint</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../js/serialNoGeneration.js"></script>


</head>
<body>
<html:form name="serialNoGenerationBean"
	action="/transactions/SerialNoGenerationTransCNT"
	type="mms.transactions.controller.fb.SerialNoGenerationTransFB">
	
	<div id="errMsg" class="errMsg"><bean:write
		name="serialNoGenerationBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="serialNoGenerationBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="serialNoGenerationBean" property="strNormalMsg" /></div>

	<tag:tab tabLabel="Serial No Generation Re-Print" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4">Serial No Generation Re-print</td>
		</tr>
		
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Store
			Name</td>
			<td width="25%" class="CONTROL"><select name="strStoreId"
				class='comboNormal' onchange="getItemCategoryComboRe(this);">
			<bean:write name="serialNoGenerationBean" property="strStoreNameCombo" filter="false"/>
			</select></td>

			<td width="25%" class="LABEL"><font color="red">*</font>Item
			Category</td>
			<td width="25%" class="CONTROL"><div id="itemCategoryDivId"><select name="strItemCategoryId"
				class='comboNormal'>
			<bean:write name="serialNoGenerationBean" property="strItemCategoryCombo" filter="false"/>
			</select></div></td>
		</tr>
		<tr>
			<td class="LABEL" width="25%" ><font color="red">*</font>From Date</td>
			<td class="CONTROL" width="25%" ><dateTag:date name="strFromDate" value="${serialNoGenerationBean.strCurrentDate}" ></dateTag:date> </td>
		<td class="CONTROL" width="50%" colspan="2" ></td></tr>
		<tr>	
			<td class="LABEL" width="25%" ><font color="red">*</font>To Date</td>
			<td class="CONTROL" width="25%" colspan="1"><dateTag:date name="strToDate" value="${serialNoGenerationBean.strCurrentDate}" ></dateTag:date> 
			</td><td class="CONTROL" width="50%" colspan="2" >
				<div id="goDivId"><img style=" cursor: pointer"
					src="../../hisglobal/images/Go.png" title='Click Here For View Tender Details' align="top"
					onclick="getReportNameCombo();"></div>
			</td>
		</tr>

		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Report Name</td>
			<td width="25%" class="CONTROL"><div id="reportNameDivId"><select name="strReportName"
				class='comboNormal'>
			<option>Select value</option>
			</select></div></td>
			<td width="25%" class="CONTROL"></td><td width="25%" class="CONTROL"></td>
			</tr>

</table>
<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">

		<tr class="FOOTER">
			<td colspan="4"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>
			<td align="center">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-generate.png"
				onClick="return validate1();" title="Click to Save Record" />
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png"
				title="Click to cancel process" onClick="cancelRePrintPage();">
			<img style="cursor: pointer; " src="../../hisglobal/images/close_tab.png"
				title="Click to Close Page" onClick="cancelPage();">
				
				</td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />
</html:form>
</body>
</html>