<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<meta charset=UTF-8">
<title>EMD Refund Details</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/emdRefundDtlTrans_mms.js"></script>

</head>
<body >
<html:form name="EmdRefundDtlBean" action="/transactions/EMDRefundDtlTransCNT" type="mms.transactions.controller.fb.EMDRefundDtlTransFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="EmdRefundDtlBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="EmdRefundDtlBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="EmdRefundDtlBean" property="strNormalMsg" /></div>
	


              	<tag:tab tabLabel="EMD Refund Details"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
              	</tag:tab>
              	
              	</center>
            
	<table class="TABLEWIDTH" align="center" cellspacing="1" >   
		<tr class="HEADER">
			<td colspan="6"></td>
		</tr>
		<tr>
			<td colspan="3" class="LABEL" width="50%">
				<font color="red">*</font>Supplier Name
			</td>
			<td colspan="3" class="CONTROL" width="50%">
				<select name="strSupplierId" class='comboNormal' onchange="getEmdDetails(this);">
					<bean:write name="EmdRefundDtlBean" property="strSupplierCombo" filter="false"/>
				</select>
			</td>
		</tr>
		
		<tr class="TITLE">
			<td colspan="6">EMD Details</td>
		</tr>
		<tr>
			<td width="5%" class="multiLabel">#</td>
			<td width="18%" class="multiLabel">Tender No</td>
			<td width="18%" class="multiLabel">Quotation No</td>
			<td width="12%" class="multiLabel">Receipt Date</td>
			<td width="18%" class="multiLabel">EMD Amount</td>
			<td width="26%" class="multiLabel">Remarks</td>
		</tr>
	</table>
		
		<div id="getEmdDetailId"></div>
		
	<table class="TABLEWIDTH" align="center" cellspacing="0" cellpadding="0">   
		<tr class="FOOTER">
			 <td colspan="6"><font size="2" color="red">*</font>Mandatory Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>
			<td align="center">
				<img style="cursor:pointer; " src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" />
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" onClick="clearDtl();" />
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" onClick="cancel();"/ >
			</td>
		</tr>
	</table>
<input type="hidden" name="hmode"/>


</html:form>
<tag:autoIndex></tag:autoIndex> 
</body>
</html>