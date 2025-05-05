<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Drug Warehouse Wise Supplier Delivery Detail</title>
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

<script language="Javascript" src="../../mms/js/dwh_drugWarehouseWiseSupplierDeliveryDetail_rpt.js"></script>


</head>
<body >
<html:form action="/reports/DrugWarehouseWiseSupplierDeliveryDetailRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="drugWarehouseWiseSupplierDeliveryDetailRptFB" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="drugWarehouseWiseSupplierDeliveryDetailRptFB" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="drugWarehouseWiseSupplierDeliveryDetailRptFB" property="strWarningMsg"/></div>


	<tag:tab tabLabel="Drug Warehouse Wise Supplier Delivery Detail" selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4">Drug Warehouse Wise Supplier Delivery Detail</td>
			
	</tr>
	</table>
			
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" > 	
	
	
	
	
	
<%-- Drug warehouse Name	 --%>		
		<tr>
			<td width="50%" colspan="2" class="LABEL">District Drug Warehouse Name</td>
			<td width="50%" colspan="2" class="CONTROL">
			<div id="strStoreDivId" >
				<select name="strStoreId" class="comboNormal" >
					<bean:write name="drugWarehouseWiseSupplierDeliveryDetailRptFB" property="strStoreValues" filter="false"/>
				</select>
			</div>				
			</td>
		</tr>
		

<%-- Supplier Name	 --%>		
		<tr>
			<td width="50%" colspan="2" class="LABEL">Supplier Name</td>
			<td width="50%" colspan="2" class="CONTROL">
			<div id="strStoreDivId" >
				<select name="strSupplierId" class="comboNormal" >
					<bean:write name="drugWarehouseWiseSupplierDeliveryDetailRptFB" property="strManufactureCombo" filter="false"/>
				</select>
			</div>				
			</td>
		</tr>		
		
	
		
         <tr>
			<td class="LABEL" colspan="2"><font color="red">*</font>From Date</td>
			<td class="CONTROL" colspan="2"><dateTag:date name="strFromDate" value="${drugWarehouseWiseSupplierDeliveryDetailRptFB.strCurrentDate}" /></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="2"><font color="red">*</font>To Date</td>
			<td class="CONTROL" colspan="2"><dateTag:date name="strToDate" value="${drugWarehouseWiseSupplierDeliveryDetailRptFB.strCurrentDate}" /></td>
		</tr>
		
		<tr>
			<td width="50%" colspan="2" class="LABEL">Batch No.</td>
			<td width="50%" colspan="2" class="CONTROL">
				<html:checkbox property="strBatchNo" name="drugWarehouseWiseSupplierDeliveryDetailRptFB" value="1" onclick="onClickBatch();">
				</html:checkbox>
			</td>

		</tr>
<%--	Financial Year --%>			
	<%--	
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Financial Year</td>
			<td width="50%" colspan="2" class="CONTROL">
				<html:text property="strStartFinancialYear" maxlength="4" size="4" name="drugWarehouseWiseSupplierDeliveryDetailRptFB" onkeypress="return validateData(event,5);" onkeyup="return setEndFinancialYear();" />-
				<html:text property="strEndFinancialYear" maxlength="4" size="4" name="drugWarehouseWiseSupplierDeliveryDetailRptFB" disabled="true" onkeypress="return validateData(event,5);" />
				
			</td>
		</tr>
		 --%>	
		
	
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
				<html:checkbox property="strIsFooter" name="drugWarehouseWiseSupplierDeliveryDetailRptFB" value="1" ></html:checkbox>
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
<input type="hidden" name="strEndFinancialYearTemp" value="${drugWarehouseWiseSupplierDeliveryDetailRptFB.strEndFinancialYearTemp}"/>
<input type="hidden" name="strCurrentDate" value="${drugWarehouseWiseSupplierDeliveryDetailRptFB.strCurrentDate}"/>

<input type="hidden" name="strStoreName" value="${drugWarehouseWiseSupplierDeliveryDetailRptFB.strStoreName}"/>


</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>