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
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
<!-- <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script> -->
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>


	
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
<style type="text/css">
.legendvs{
    position: absolute;
    right: 100px;
    line-height: 1.2em;
    top: 0.8em;
}
</style>
</head>
<body onload="checkOnlineIssueMode();">
<html:form action="/masters/MmsConfigMstBSCNT" method="post" name="mmsConfigBean" type="mms.masters.controller.fb.MmsConfigMstFB" >
<fieldset form="form1"><br>
<div class="prescriptionTile">
<div class="row rowFlex reFlex" >
<div class="legendvs">
<button  type="button" class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="clearPage('CANCEL');">
<i class="fas fa-ban iround"  title="Cancel"></i>
</button>
<button type="button" class=" btn btn-secondary btn-circle" onclick="document.forms[0].reset();" style="background: #b9b9b9; border-color:#b9b9b9;margin-top: 0.25rem !important;">
<img  src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 23px; color: #fff;">
</button>
<button  type="button" id="submitId" onclick=' return validate1();' class="float-right btn btn-outline-success mt-1 btn-circle" tabindex='2' style="background-color: #5cb85c;">					
<i class="fa fa-save iround"  title="Save" ></i>
</button> 							                 
  </div> 
</div>
<div class="row">

<p class="subHeaders" style="margin-bottom: 0;">
<i class="fas fa-university" style="font-size: 26px;"></i>
Store Setup
<i class="fas fa-angle-double-right"></i>
<label>&nbsp;Issue Process&nbsp;</label></p>
<div class="col-sm-3" align="center">
</div>
<div class="col-sm-4" align="center">
<label>
<font color="red">*</font>Select Mode</label></font>&nbsp;&nbsp;&nbsp;&nbsp;
<html:radio name="mmsConfigBean" property="strIssueMode" onclick="displayOnlineIssueDtls(this);" value="0">&nbsp;Online</html:radio>
<html:radio name="mmsConfigBean" property="strIssueMode" onclick="displayOnlineIssueDtls(this);" value="1">&nbsp;Off-line</html:radio>
<html:radio name="mmsConfigBean" property="strIssueMode" onclick="displayOnlineIssueDtls(this);" value="2">&nbsp;Both</html:radio>
</div>
</div>
<center>
	
    <tag:tabNew tabList="${mmsConfigBean.lhm}" selectedTab="mmsissuedtls" align="center" width="TABLEWIDTH"></tag:tabNew>         
    </center>
<div class="row">
<div class="col-sm-4">
  
</div>
<div class="col-sm-4">
<div id="errMsg" class="errMsg"><bean:write name="mmsConfigBean" property="strErrMsg" /></div>
<div id="normalMsg" class="normalMsg"><bean:write name="mmsConfigBean" property="strNormalMsg" /></div>
</div>
</div>
<div id="onlineIssueDtlsDivId" style="display: none">
<div class="row" align="left">
<p class="subHeaders" style="margin-bottom: 0;">
Online Issue Details
</p>
</div>
<div class="row">
<div class="col-sm-4">
<div class="row">
<div class="col-sm-8">
<label>
<font color="red">*</font>Online Issue In Days
</label>
</div>
<div class="col-sm-4  input-group">
<input type="text" class="form-control" name="strOnlineIssueInDays" 
value="${mmsConfigBean.strOnlineIssueInDays}" maxlength="3" onkeypress="return validateData(event,5);">
<input class="form-control" style="width: 42%;" placeholder="Day/s" readonly>
</div>
</div>
</div>
</div>
</div>


<div class="row" >
<p class="subHeaders" style="margin-bottom: 0;">
Last Issue Details
</p>
</div>
<div class="row">
<div class="col-sm-4">
<div class="row">
<div class="col-sm-8">
<label>
<font color="red">*</font>In Case of Patient / Staff (Item)
</label>
</div>
<div class="col-sm-4 input-group">
<input type="text" class="form-control" name="strLastIssuePatientStaffInDays" 
value="${mmsConfigBean.strLastIssuePatientStaffInDays}" maxlength="3" onkeypress="return validateData(event,5);" >
<input class="form-control" style="width: 42%;" placeholder="Day/s" readonly>
</div>
</div>
</div>

<div class="col-sm-4">
<div class="row">
<div class="col-sm-8">
<label>
Case of Employee(Non-Consumable)
</label>
</div>
<div class="col-sm-4 input-group">
<input type="text" class="form-control" name="strLastIssueEmployeeInDays" 
value="${mmsConfigBean.strLastIssueEmployeeInDays}" maxlength="3" onkeypress="return validateData(event,5);" >
<input class="form-control" style="width: 42%;" placeholder="Day/s" readonly>
</div>
</div>
</div>
<div class="col-sm-4">
<div class="row">
<div class="col-sm-8">
<label>
<font color="red">*</font>Auto Return Request(In Case of LP)
</label>
</div>
<div class="col-sm-4 input-group">
<input type="text" class="form-control"  name="strAutoReturnRequest" 
value="${mmsConfigBean.strAutoReturnRequest}" maxlength="3" onkeypress="return validateData(event,5);" >
<input class="form-control" style="width: 42%;" placeholder="Day/s" readonly>
</div>
</div>
</div>
</div>
<div class="row" align="left">
<p class="subHeaders" style="margin-bottom: 0;">
Sale Details
</p>
</div>
<div class="row">
<div class="col-sm-4">
<div class="row">
<div class="col-sm-6">
<label>
<font color="red">*</font>Issue Rate (Staff)
</label>
</div>
<div class="col-sm-6 input-group">
<input type="text" class="form-control" name="strStaffSalePrice" placeholder="%" 
value="${mmsConfigBean.strStaffSalePrice}" maxlength="5" onkeypress="return validateData(event,7);" >
<select name="mmsConfigBean" property="strStaffSalePriceType" style="width: 50%;" class="form-control">
<option value="1">Purchase Price</option>
<option value="2">Issue Rate</option>
</select>
</div>
</div>
</div>
<div class="col-sm-4">
<div class="row">
<div class="col-sm-6">
<label>
<font color="red">*</font>Issue Rate (Normal)
</label>
</div>
<div class="col-sm-6 input-group">
<input type="text" class="form-control" name="strNormalSalePrice" placeholder="%"
value="${mmsConfigBean.strNormalSalePrice}" maxlength="5" onkeypress="return validateData(event,7);" >
<select name="mmsConfigBean" property="strNormalSalePriceType" style="width: 50%;" class="form-control">
<option value="1">Purchase Price</option>
<option value="2">MRP</option>
</select>	
</div>
</div>
</div>
</div>
<hr>
<div class="row">
<div class='col-sm-9'>
</div>
<div class='col-sm-3' align="right">
<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>
<label>&nbsp;Mandatory Fields</label>
</div>
</div>









  <!-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="2">Store Setup &gt;&gt; Issue Process</td>
		</tr>
	</table>	 -->
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
	 
	 
	 
   <%--  <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="0px">	
    	
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
		</table> --%>
		
		<%-- <div id="onlineIssueDtlsDivId" style="display: none">
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
		</div> --%>
		
		<%-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
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
		
		</table> --%>
	 
	<%-- <table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" >
	   
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
	  --%>
	<!-- <table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" >
	
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	  -->
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
					 <!-- 	<a href="#" class="button" id=" " onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="document.forms[0].reset();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="clearPage('CANCEL');"><span class="cancel">Cancel</span></a> -->
				</div>
<input 	type="hidden" name="selectedTab">
<input 	type="hidden" name="strTempOnlineIssueVal" value="${mmsConfigBean.strOnlineIssueInDays}">
<input  type="hidden" name="strDemandActiveFlg" value="${mmsConfigBean.strDemandActiveFlg}">
<input  type="hidden" name="strWithOutCrNoFlg" value="${mmsConfigBean.strWithOutCrNoFlg}">
<input  type="hidden" name="strDoseFrqFlg" value="${mmsConfigBean.strDoseFrqFlg}">

</div>
</fieldset>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>