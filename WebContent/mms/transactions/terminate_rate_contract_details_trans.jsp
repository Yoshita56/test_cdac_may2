<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>


<html>
<head>
<meta charset=UTF-8">
<title>Rate Contract Details</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/rate_contract_trans.js"></script>

<script language="javaScript">

function validateTerminate(){   
     
      var hisValidator = new HISValidator("rateContractDtlBean"); 
              
	      
            hisValidator.addValidation("strTerminateDate", "req", "Terminate Date is a Mandatory Field" ); 
            hisValidator.addValidation("strTerminateDate", "dtltet=${rateContractDtlBean.strCtDate}" , "Terminate Date should not be greater than Current Date");  
            hisValidator.addValidation("strTerminateDate", "dtgtet=${rateContractDtlBean.strContractDate}" , "Terminate Date should not be less than Contract Date");
          //     hisValidator.addValidation("strTerminateDate", "dtgtet=${rateContractDtlBean.strContractFromDate}" , "Terminate Date should not be less than Contract From Date");
                hisValidator.addValidation("strTerminateDate", "dtltet=${rateContractDtlBean.strContractToDate}" , "Terminate Date should not be greater than Contract To Date"); 
            hisValidator.addValidation("strTerminateReason", "maxlen=100", "Reason should have less than or equal to 100 Characters" ); 
			 var retVal = hisValidator.validate(); 
    	
    	
          if(retVal){
          				 document.forms[0].hmode.value = "TERMINATECONTRACT"; 
                        document.forms[0].submit();
            }else{
					return false;
				 }
    }
</script>

</head>
<body onLoad="document.forms[0].strTerminateDate.focus();">
<html:form name="rateContractDtlBean" action="/transactions/RateContractDtlTransCNT"
	type="mms.transactions.controller.fb.RateContractDtlTransFB">
	<div id="errMsg" class="errMsg"><bean:write name="rateContractDtlBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="rateContractDtlBean"
		property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="rateContractDtlBean"
		property="strMsg" /></div>

<tag:tab tabLabel="Rate Contract Details"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">

		<tr class="HEADER">
			<td colspan="4">Rate Contract Details&gt;&gt; Terminate</td>
		</tr>

		<tr>
			<td class="LABEL" width="50%" colspan="2">Supplier Name</td>
			<td width="50%" class="CONTROL" colspan="2"><bean:write name="rateContractDtlBean"
				property="strSupplierName" filter="false" /></td>

		</tr>
		<tr>
				<td width="25%" class="LABEL">Tender No.</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean"
				property="strTenderNo" filter="false" /></td>
				
					<td width="25%" class="LABEL">Quotation No.</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean"
				property="strQuotationNo" filter="false" /></td>
			</tr>
			<tr>
			<td class="LABEL" width="50%" colspan="2">Contract Date</td>
			<td width="50%" class="CONTROL" colspan="2"><bean:write name="rateContractDtlBean"
				property="strContractDate" filter="false" /></td>

		</tr>
		<tr>
				<td width="25%" class="LABEL" >Contract From</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean"
				property="strContractFromDate" filter="false" /></td>
					<td width="25%" class="LABEL">Contract To</td>
				<td width="25%" class="CONTROL"><bean:write name="rateContractDtlBean"
				property="strContractToDate" filter="false" /></td>
			</tr>
			<tr>
				<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Terminate Date</td>
				<td width="50%" colspan="2" class="CONTROL"><dateTag:date name="strTerminateDate" value ="${rateContractDtlBean.strCtDate}"></dateTag:date>
				</td>
			</tr>
			
			<tr >
    <td width ="50%" class ="LABEL"valign="top" colspan="2">Reason</td>
    <td width ="50%" class ="CONTROL" colspan="2">
    <textarea  name="strTerminateReason" cols="25" rows="2" onkeypress="return validateData(event,9);"></textarea></td>
  </tr>
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
<!-- 	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img style="cursor: pointer; "
src="../../hisglobal/images/btn-sv.png"
onClick=" return validateTerminate();" /> <img
style="cursor: pointer; "
src="../../hisglobal/images/btn-clr.png"
onClick="document.forms[0].reset(),document.forms[0].strTerminateDate.focus();" />
<img style="cursor: pointer; "
src="../../hisglobal/images/btn-ccl.png" onClick="cancelPage();" />
			
			</td>
		</tr>
	</table>-->
			<br>
	<div align="center" id=" ">					 
					 	<a href="#" class="button" id="submitId" onclick='return validateTerminate();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="document.forms[0].reset(),document.forms[0].strTerminateDate.focus();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelPage();"><span class="cancel">Cancel</span></a>
					</div> 
<input type="hidden" name="chk" value="${rateContractDtlBean.strChk1 }"/>
<input type="hidden" name="strSupplierId"
		value="${rateContractDtlBean.combo[0]}">
<input type="hidden" name="hmode"/>
<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>