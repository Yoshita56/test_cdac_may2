<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<html>
<head>
<meta charset=UTF-8">
<title>EMD Receiving Details</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../js/emdReceivingDtlTrans_mms.js"></script>

</head>
<body >
<html:form name="EmdReceivingDtlBean" action="/transactions/EMDReceivingDtlTransCNT" type="mms.transactions.controller.fb.EMDReceivingDtlTransFB">

<center>
	<div id="errMsg" class="errMsg"><bean:write name="EmdReceivingDtlBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="EmdReceivingDtlBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="EmdReceivingDtlBean" property="strNormalMsg" /></div>
	

	<tag:tab tabLabel="EMD Receiving Details"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>
</center>
	<table class="TABLEWIDTH" align="center">   
	<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		<tr>
					<td colspan="2" class="LABEL" width="50%">
					<font color="red">*</font>Supplier Name
					</td>
					<td colspan="2" class="CONTROL" width="50%">
					<select name="strSupplierName" class='comboNormal' onchange="">
						<bean:write name="EmdReceivingDtlBean" property="strSupplierCombo" filter="false"/>
					</select>
					</td>
				</tr>
				
				<tr>
					<td colspan="1" width="25%" class="LABEL"><font color="red">*</font>Tender No</td>
					<td colspan="1" width="25%" class="CONTROL"><input type="text"
						name="strTenderNo"  maxlength="25" class="txtFldMax"
						onkeypress="return validateData(event,9);"></td>
			  
					<td colspan="1" width="25%" class="LABEL"><font color="red">*</font>Quotation No</td>
					<td colspan="1" width="25%" class="CONTROL"><input type="text"
						name="strQuotationNo"  maxlength="25" class="txtFldMax"
						onkeypress="return validateData(event,9);"></td>
			    </tr>
			    
			    <tr>
					<td colspan="1" width="25%" class="LABEL">
					<font color="red">*</font>Receipt Date
					</td>
					<td colspan="1" width="25%" class ="CONTROL">
					<date:date name="strReceiptDate" value="${EmdReceivingDtlBean.strCtDate}"></date:date></td>
				
					<td colspan="1" width="25%" class="LABEL">
					<font color="red">*</font>EMD Amount</td>
					<td colspan="1" width="25%" class="CONTROL">
					<input type="text" name="strEmdAmount" class="txtFldNormal" maxlength="10"
						onkeypress="return validateData(event,7);">
						<select name="strEmdAmountType" class="comboNormal" >
						<bean:write name="EmdReceivingDtlBean" property="strEmdAmountTypeCombo" filter="false"/>
						</select>
						</td>
						
						
				</tr>
				
				<tr>
					<td colspan="2" class="LABEL" width="50%">
					<font color="red">*</font>Payment Mode
					</td>
					<td colspan="2" class="CONTROL" width="50%">
					<html:select property="strPaymentMode" name="EmdReceivingDtlBean" onchange="getDetails(this);" styleClass="comboNormal">
						<html:option value="0">Select Value</html:option>
						<html:option value="1">DD</html:option>
						<html:option value="2">Cheque</html:option>
						<html:option value="3">Cash</html:option>
					</html:select>
					</td>
				</tr>
				</table>
			 
			   <div id="inCaseChequeDD" style="display:none">
			    <table class="TABLEWIDTH" align="center" cellpadding="0" cellspacing="1">
			   <tr>
					<td colspan="1" width="25%" class="LABEL">
					<font color="red">*</font>Cheque/DD Date
					</td>
					<td colspan="1" width="25%" class ="CONTROL">
					<date:date name="strChequeDDDate" value="${EmdReceivingDtlBean.strCtDate}"></date:date></td>
				
					<td colspan="1" width="25%" class="LABEL">
					<font color="red">*</font>Cheque/DD No.</td>
					<td colspan="1" width="25%" class="CONTROL">
					<input type="text" name="strChequeDDNo"  maxlength="10" class="txtFldNormal"
						onkeypress="return validateData(event,5);">
					</td>
				</tr>

				<tr>
					<td colspan="1" width="25%" class="LABEL"><font color="red">*</font>Drawee Bank Name</td>
					<td colspan="1" width="25%" class="CONTROL"><input type="text"
						name="strDraweeBankName"  maxlength="50" class="txtFldNormal" onkeypress="return validateData(event,9);"></td>
			  
					<td colspan="1" width="25%" class="LABEL"><font color="red">*</font>Payable At</td>
					<td colspan="1" width="25%" class="CONTROL"><input type="text" class="txtFldNormal"
						name="strPayableAt"  maxlength="100" onkeypress="return validateData(event,9);"></td>
			    </tr>
				<tr>
					<td colspan="2" width="50%" class="LABEL"><font color="red">*</font>Cheque Validity</td>
					<td colspan="2" width="50%" class="CONTROL">
					<date:date name="strChequeValidity" value="${EmdReceivingDtlBean.strCtDate}"></date:date></td>
				</tr>



			   </table>
			   </div>
			   		   
			  <table class="TABLEWIDTH" align="center" cellpadding="0"
        		 cellspacing="0"> 
			   
			   <tr>
					<td colspan="2" width="50%" class="LABEL">Remarks</td>
					<td colspan="2" width="50%" class="CONTROL">
			  		<textarea name="strRemarks" rows="2"></textarea>
    	 			</td>
			  </tr>
			   
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" title="Save Record" onClick="return validate1();" />
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" title="Clear Content" onClick="clearDtl();" >
			<img  style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" onClick="cancel();" >
		</td>
		</tr>
	</table>
<input type="hidden" name="hmode"/>
</html:form>
<tag:autoIndex></tag:autoIndex> 
</body>
</html>