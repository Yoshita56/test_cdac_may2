<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>

<html>
<head>
<meta charset=utf-8>
<title>Store Setup</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>

<script type="text/javascript">

	
	function validate1(){	
	
		retVal = false;
		var hisValidator = new HISValidator("mmsConfigBean");
	
		hisValidator.addValidation("strLastIssuePatientStaffInDays", "req","Last Issue Details In Case of Patient/Staff is a Mandatory Field");
		hisValidator.addValidation("strLastIssuePatientStaffInDays", "numltet=366","Last Issue Details In Case of Patient/Staff should be lesser than or equal to 366 Days");
		hisValidator.addValidation("strLastIssueEmployeeInDays", "req","Last Issue Details In Case of Employee is a Mandatory Field");
		hisValidator.addValidation("strLastIssueEmployeeInDays", "numltet=366","Last Issue Details In Case of Employee should be lesser than or equal to 366 Days");
		
		hisValidator.addValidation("strOnlineIssueInDays", "req","Online Issue Details is a Mandatory Field");
		hisValidator.addValidation("strOnlineIssueInDays", "numltet=366","Online Issue Details should be lesser than or equal to 366 Days");
		
		
		
		hisValidator.addValidation("strAutoReturnRequest", "req","Auto Return Date In Case of LP is a Mandatory Field");
		hisValidator.addValidation("strAutoReturnRequest", "numltet=366","Auto Return Date In Case of LP should be lesser than or equal to 366 Days");


		hisValidator.addValidation("strStaffSalePrice", "req","Issue Rate (Staff) is a Mandatory Field");
		hisValidator.addValidation("strStaffSalePrice", "numltet=100","Issue Rate (Staff) Value cannot be greater than 100");
		hisValidator.addValidation("strStaffSalePrice", "amount=5,2","Issue Rate (Staff) must be in Valid Format 00.00");
		hisValidator.addValidation("strNormalSalePrice", "req","Issue Rate (Normal) is a Mandatory Field");
		hisValidator.addValidation("strNormalSalePrice", "numltet=100","Issue Rate (Normal) Value cannot be greater than 100");
		hisValidator.addValidation("strNormalSalePrice", "amount=5,2","Issue Rate (Normal) must be in Valid Format 00.00");


		retVal = hisValidator.validate(); 
		hisValidator.clearAllValidations();
		if(retVal){

			document.forms[0].selectedTab.value = "SAVEISSUEDTLS";
			document.forms[0].submit();

		}else{
		
		return false;
		}
		
	}


	function displayOnlineIssueDtls(radioObj){
	
		if(radioObj.value == '1'){
			
				document.forms[0].strOnlineIssueInDays.value = "0";
				document.getElementById("onlineIssueDtlsDivId").style.display = "none";
							
		}else{
		
			document.forms[0].strOnlineIssueInDays.value = document.forms[0].strTempOnlineIssueVal.value; 
			document.getElementById("onlineIssueDtlsDivId").style.display = "block";
		}
		
	}
	
	
	function checkOnlineIssueMode()
	{
	
		if(document.getElementsByName("strIssueMode")[1].checked == true )
		{
		
			document.forms[0].strOnlineIssueInDays.value = "0";
				document.getElementById("onlineIssueDtlsDivId").style.display = "none";
		
		}
		else
		{
		
			document.forms[0].strOnlineIssueInDays.value = document.forms[0].strTempOnlineIssueVal.value; 
			document.getElementById("onlineIssueDtlsDivId").style.display = "block";
			
		}
		
		if(document.forms[0].strDemandActiveFlg.value=="1")
		{
		   document.getElementById("demandActive").style.display="block";	
		   document.forms[0].strChkFlg.checked = true;	
		
		}
		else
		{
		   document.getElementById("demandActive").style.display="none";
		   document.forms[0].strChkFlg.checked = false;		
		}
		
		
		if(document.forms[0].strWithOutCrNoFlg.value=="1")
		{
		   document.getElementById("crNoConfigFlg").style.display="block";	
		   document.forms[0].strCrNoConfigChk.checked = true;	
		
		}
		else
		{
		   document.getElementById("crNoConfigFlg").style.display="none";
		   document.forms[0].strCrNoConfigChk.checked = false;		
		}
		
		if(document.forms[0].strDoseFrqFlg.value=="1")
		{
		  
		   document.forms[0].strDoseFrqChk.checked = true;	
		
		}
		else
		{
		   
		   document.forms[0].strDoseFrqChk.checked = false;		
		}
		
	}
	
	
function clearPage(mode){

	document.forms[0].selectedTab.value = mode ;
	document.forms[0].submit();
}

function showHideDemandPrd(obj)
{
  if(obj.checked)
  {
     document.getElementById("demandActive").style.display="block";
     document.forms[0].strDemandActiveFlg.value="1";
    
  }
  else
  {
    document.getElementById("demandActive").style.display="none";
    document.forms[0].strDemandActiveFlg.value="0";
  }
}


function showHideWithCrNo(obj)
{
  if(obj.checked)
  {
     document.getElementById("crNoConfigFlg").style.display="block";
     document.forms[0].strWithOutCrNoFlg.value="1";
    
  }
  else
  {
    document.getElementById("demandActive").style.display="none";
    document.forms[0].strWithOutCrNoFlg.value="0";
  }
}

function setValue(obj)
{
  if(obj.checked)
  {
     
     document.forms[0].strDoseFrqFlg.value="1";
    
  }
  else
  {
    
    document.forms[0].strDoseFrqFlg.value="0";
  }
}

	

</script>

</head>
<body onload="checkOnlineIssueMode();">
<html:form action="/masters/MmsConfigMstCNT" method="post" name="mmsConfigBean" type="mms.masters.controller.fb.MmsConfigMstFB" >
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="mmsConfigBean" property="strErrMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="mmsConfigBean" property="strNormalMsg" /></div>
	
	              
              <tag:tab tabList="${mmsConfigBean.lhm}" selectedTab="mmsissuedtls" align="center" width="TABLEWIDTH"></tag:tab>
              
    </center>
  <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="2">Store Setup &gt;&gt; Issue Process</td>
		</tr>
	</table>	
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="0px" style='display:none;'>
		<tr>
		   <td class="LABEL" width="50%">
		   <input type="checkbox" name="strChkFlg" value="0" onClick="showHideDemandPrd(this);">
		  <!-- 
		      <html:checkbox name="mmsConfigBean"  property="strIssueRateConfigFlg" value="1"></html:checkbox>
		   --> 
		</td>
		<td class="CONTROL" width="50%"><b>Whether keep the demand active in case of partial issue</b></td>
		</tr>
		</table>
	    <div id="demandActive" style="display:none;">
		  <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="0px">
			<tr>
			   <td class="LABEL" width="50%">Demand Active Period</td>
			    <td class="CONTROL" width="50%">
			  
			    <input type='text' name="strDemandActivePrd" value="${mmsConfigBean.strDemandActivePrd}" onkeypress="return validateData(event,5);" maxlength="3" class='txtFldNormal'><b>Day(s)</b>
			  
			 </td>  	
			</tr>		
		</table>
	 </div>
	 
	 <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="0px" style='display:none;'>
	    <tr>
		   <td class="LABEL" width="50%">
		   <input type="checkbox" name="strCrNoConfigChk" value="0" onClick="showHideWithCrNo(this);">
		 
		</td>
		<td class="CONTROL" width="50%"><b>Whether Without CR No. option Required</b></td>
		</tr>
		
	 </table>
	 
	 <div id="crNoConfigFlg" style="display:none;">
		  <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="0px">
			<tr>
			   <td class="LABEL" width="50%">Default Option</td>
			    <td width="50%" class="CONTROL">
		             <html:radio name="mmsConfigBean" property="strCrNoDefault"  value="0">With CR No.</html:radio>
		             <html:radio name="mmsConfigBean" property="strCrNoDefault"  value="1">With-Out CR No.</html:radio>
			   </td>	
			</tr>		
		</table>
	 </div>
	 
	 <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="0px" style='display:none;'>
	    <tr>
		   <td class="LABEL" width="50%">
		   <input type="checkbox" name="strDoseFrqChk" value="0" onClick="setValue(this);">
		 
		</td>
		<td class="CONTROL" width="50%"><b>Whether Dosage/Frequency/Days Information needs to capture</b></td>
		</tr>
		
		<tr>
			   <td class="LABEL" width="50%">Return Item Validity</td>
			    <td class="CONTROL" width="50%">
			  
			    <input type='text' name="strReturnDrugValidity" value="${mmsConfigBean.strReturnDrugValidity}" onkeypress="return validateData(event,5);" maxlength="2" class='txtFldNormal'><b>Day(s)</b>
			  
			 </td>  	
			</tr>		
	 </table>
	 
	 
	 
    <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="0px">	
    	
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Mode
			</td>
			<td width="50%" class="CONTROL">
		<html:radio name="mmsConfigBean" property="strIssueMode" onclick="displayOnlineIssueDtls(this);" value="0">Online</html:radio>
		<html:radio name="mmsConfigBean" property="strIssueMode" onclick="displayOnlineIssueDtls(this);" value="1">Off-line</html:radio>
		<html:radio name="mmsConfigBean" property="strIssueMode" onclick="displayOnlineIssueDtls(this);" value="2">Both</html:radio>
			</td>
		</tr>
		</table>
		
		<div id="onlineIssueDtlsDivId" style="display: none">
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">  
		<tr class="TITLE">
		<td colspan="2">Online Issue Details
		</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Online Issue In Days
			</td>
			<td width="50%" class="CONTROL">
			<input type="text" class="txtFldMin" name="strOnlineIssueInDays" value="${mmsConfigBean.strOnlineIssueInDays}" maxlength="3" onkeypress="return validateData(event,5);" > day(s)
			</td>
		</tr>
		</table>
		</div>
		
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
		<tr class="TITLE">
		<td colspan="2">Last Issue Details
		</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>In Case of Patient / Staff (Item)
			</td>
			<td width="50%" class="CONTROL">
			<input type="text" class="txtFldMin" name="strLastIssuePatientStaffInDays" value="${mmsConfigBean.strLastIssuePatientStaffInDays}" maxlength="3" onkeypress="return validateData(event,5);" > day(s)
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>In Case of Employee (Non-Consumable)
			</td>
			<td width="50%" class="CONTROL">
			<input type="text" class="txtFldMin" name="strLastIssueEmployeeInDays" value="${mmsConfigBean.strLastIssueEmployeeInDays}" maxlength="3" onkeypress="return validateData(event,5);" > day(s)
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Auto Return Request (In Case of LP)
			</td>
			<td width="50%" class="CONTROL">
			<input type="text" class="txtFldMin" name="strAutoReturnRequest" value="${mmsConfigBean.strAutoReturnRequest}" maxlength="3" onkeypress="return validateData(event,5);" > day(s)
			</td>
		</tr>
		
		</table>
	 
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" >
	   
		<tr class="TITLE">
		<td colspan="4">Sale Details
		</td>
		</tr>
		  
		  <tr>
			<td width="25%" class="LABEL">
			<font color="red">*</font>Issue Rate (Staff)
			</td>
			<td width="25%" class="CONTROL">
			<input type="text" class="txtFldMin" name="strStaffSalePrice" value="${mmsConfigBean.strStaffSalePrice}" maxlength="5" onkeypress="return validateData(event,7);" > % 
			</td>
			
			<td width="25%" class="CONTROL">
			of
			</td>
			<td width="25%" class="CONTROL">
			<html:select name="mmsConfigBean" property="strStaffSalePriceType">
			<html:option value="1">Purchase Price</html:option>
			<html:option value="2">Issue Rate</html:option>
			</html:select>
			</td>
			
		</tr>
		
		<tr>
			<td width="25%" class="LABEL">
			<font color="red">*</font>Issue Rate (Normal)
			</td>
			<td width="25%" class="CONTROL">
			<input type="text" class="txtFldMin" name="strNormalSalePrice" value="${mmsConfigBean.strNormalSalePrice}" maxlength="5" onkeypress="return validateData(event,7);" > %
			</td>
			
			<td width="25%" class="CONTROL">
			of
			</td>
			<td width="25%" class="CONTROL">
			<html:select name="mmsConfigBean" property="strNormalSalePriceType">
			<html:option value="1">Purchase Price</html:option>
			<html:option value="2">MRP</html:option>
			</html:select>
			</td>
			
		</tr>
		  </table>
	 
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" >
	
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	 
	<!-- <table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" />
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset();" >
			<img  style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" onClick="clearPage('CANCEL');" >
			</td>
		</tr>
	</table>-->
	<br>
	<div align="center" id=" ">					 
					 	<a href="#" class="button" id=" " onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="document.forms[0].reset();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="clearPage('CANCEL');"><span class="cancel">Cancel</span></a>
				</div>
<input 	type="hidden" name="selectedTab">
<input 	type="hidden" name="strTempOnlineIssueVal" value="${mmsConfigBean.strOnlineIssueInDays}">
<input  type="hidden" name="strDemandActiveFlg" value="${mmsConfigBean.strDemandActiveFlg}">
<input  type="hidden" name="strWithOutCrNoFlg" value="${mmsConfigBean.strWithOutCrNoFlg}">
<input  type="hidden" name="strDoseFrqFlg" value="${mmsConfigBean.strDoseFrqFlg}">


</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>