<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Supplier Payment Detail Report</title>
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

<script language="Javascript" src="../../mms/js/dwh_supplierPaymentDtail_rpt.js"></script>

</head>
<body >
<html:form action="/reports/SupplierPaymentDtailRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="supplierPaymentDtlTransFB" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="supplierPaymentDtlTransFB" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="supplierPaymentDtlTransFB" property="strWarningMsg"/></div>


	<table width='90%' align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4"><strong>SUPPLIER PAYMENT DETAIL REPORT</strong></td>
			
	</tr>
	</table>
			
	<table width='90%' align="center" cellspacing="1px" cellpadding="1px" > 	
	
		<tr>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Supplier Name</td>
			<td width="25%" colspan="1" class="CONTROL">
			<div id="strStoreDivId" >
				<select name="strSupplierId" class="comboMax" onChange="getPOCombo();">
					<bean:write name="supplierPaymentDtlTransFB" property="strManufactureCombo" filter="false"/>
				</select>
			</div>				
			</td>
			<td width="25%" colspan="1" class="LABEL">PO No</td>
			<td width="25%" colspan="1" class="CONTROL">
			<div id="strPODivId" >
				<select name="strPoNumber" class="comboNormal" >
					<option value="0">All</option>
				</select>
			</div>				
			</td>
		</tr>		
		
     </table>
	<table border="0" width='90%' align="center" cellspacing="1px" cellpadding="1px">

 
         <tr>
			<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>From Date</td>
			<td class="CONTROL" width="25%" colspan="1"><dateTag:date name="strFromDate" value="${supplierPaymentDtlTransFB.strCurrentDate}" /></td>
			<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>To Date</td>
			<td class="CONTROL" width="25%" colspan="1"><dateTag:date name="strToDate" value="${supplierPaymentDtlTransFB.strCurrentDate}" /></td>
		</tr>
		
		<tr>
			<td class="LABEL" colspan="4"><div align='center'><INPUT TYPE='CHECKBOX' NAME='rptType' id='rptTypeId' VALUE='1'>With PO Details</div></td>
		</tr>
				
	</table>
	

<table border="0" width='90%' align="center" cellspacing="1px" cellpadding="1px">
	
	<tr class="FOOTER">
			 <td colspan="4"><font color='red'>*</font>Mandatory Field </td>
		</tr>
		
		<tr>
		  
		  <td colspan="4"><div id='id' align='center'>
		  <img style="cursor: pointer" src="../../hisglobal/images/print_tab.gif" onClick="getSuppPerformanceDtlPrint();"/>
		  <img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="resetPage();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
		  </div></td>
		</tr>
		</table>
		
<div id="suppPerformanceDtlsHlpDivId" style="display:block;"></div>
	
	<input type="hidden" name="hmode"></input>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>