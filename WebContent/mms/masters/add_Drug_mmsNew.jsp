<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset=utf-8>
<title>Add Drug Master...</title>

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
	
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>

<script type="text/javascript">
function checkMandatoryDetails(obj){
	
	if(obj.value == 2 ){
		//manfNonMandatoryDivId
		document.getElementById("manfMandatoryDivId").style.display = "none";	
		document.getElementById("manfNonMandatoryDivId").style.display = "";
		
		document.getElementById("specMandatoryDivId").style.display = "none";	
		document.getElementById("specNonMandatoryDivId").style.display = "";
		
	}else{
	
		document.getElementById("manfMandatoryDivId").style.display = "";	
		document.getElementById("manfNonMandatoryDivId").style.display = "none";

		
		document.getElementById("specMandatoryDivId").style.display = "";	
		document.getElementById("specNonMandatoryDivId").style.display = "none";
	
	}

}



function setIsItemSachet()
{
	
	if(document.forms[0].strIsItemSachet.checked)
	{
		document.forms[0].strIsItemSachet.value="1";
	}
	else
	{
		document.forms[0].strIsItemSachet.value="0";
	}
	
}
	
function setIsQuantifiable()
{
	if(document.forms[0].strIsQuantifiable.checked)
	{
		document.forms[0].strIsQuantifiable.value="1";
		
	}
	else
	{
		document.forms[0].strIsQuantifiable.value="0";
	}
}
function setIsMisc()
{
	if(document.forms[0].strIsMisc.checked)
	{
		document.forms[0].strIsMisc.value="1";
		
	}
	else
	{
		document.forms[0].strIsMisc.value="0";
	}
}
function validate()
{
	var iChars = "!@#$%^&*()+=-[]\\\';,./{}|\":<>?";
	
	for (var i = 0; i < document.forms[0].strDrugName.value.length; i++) {
	    if (iChars.indexOf(document.forms[0].strDrugName.value.charAt(i)) != -1) {
	    alert ("Drug Name has special character(s). \nThese are not allowed.\n");
	    return false;
	        }
	    }
	for (var i = 0; i < document.forms[0].strSpecification.value.length; i++) {
	    if (iChars.indexOf(document.forms[0].strSpecification.value.charAt(i)) != -1) {
	    alert ("Specification has special character(s). \nThese are not allowed.\n");
	    return false;
	        }
	    }
	
	
	if( document.forms[0].strIssueRateConfigFlg.value=='1' && document.forms[0].strConfigIssueRate.value=='0')
	{
		  alert("Issue Rate always greater than 0");
		  return false;
	}
	
	var hisValidator = new HISValidator("drugBean");
	
	if(document.forms[0].strIsItemCodeRequired.value == '1'){
		 hisValidator.addValidation("strNewCPACode", "req", "Drug Code is a Mandatory Field" );
	}
	hisValidator.addValidation("strGenericItemId", "dontselect=0","Please Select Generic Drug");
	hisValidator.addValidation("strItemType", "dontselect=0","Please Select Drug Type");
    hisValidator.addValidation("strDrugName", "req", "Drug Name is a Mandatory Field" );
     
     
    
    //commnted by vikrant Date 13-July-2015
    if(!document.forms[0].strDrugType[1].checked){
   		
   			 hisValidator.addValidation("strManufacturerId", "dontselect=0","Please Select Manufacturer Name");
      }
      
   
    //hisValidator.addValidation("strDefaultRate", "req", "Default Rate is a Mandatory Field" );
    hisValidator.addValidation("strDefaultRate", "amount=11,2", "Default Rate should be in format 00000000000.00" ); 
    //hisValidator.addValidation("strUnit", "dontselect=0","Please Select Rate Unit");
    hisValidator.addValidation("strApprovedType", "dontselect=0","Please Select ApprovedType Type");
  //  hisValidator.addValidation("strIssueType ", "dontselect=0","Please Select Issue Type");
    
 //   hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
    if(!document.forms[0].strDrugType[1].checked){
    hisValidator.addValidation("strSpecification", "req","Specifications is a mandatory field");
    }

    //hisValidator.addValidation("strConfigIssueRate", "amount=3,2","Issue Cost should be in 000.00");
    hisValidator.addValidation("strSpecification", "maxlen=100", "Specifications should have less than or equal to 100 Characters" );
    if(document.forms[0].strEdlCat.checked){
   		//alert('1');
    	document.forms[0].strEdlCat.value='1';
 		}else{
 		document.forms[0].strEdlCat.value='0';
 	 		}
     var retVal = hisValidator.validate();
    hisValidator.clearAllValidations();
   
     if(retVal) 
	    {
	   		
	   		document.forms[0].strCPACode.value=document.getElementsByName("strPrevCPACode")[0].value+""+document.getElementsByName("strNewCPACode")[0].value;
	   		//alert(document.forms[0].strBatchNo.value);
	   		document.forms[0].hmode.value="INSERT";
	   		document.forms[0].submit();
	    }
}

/*
This function is no longer needed.
function chkPrevCPACode(){
	if(document.getElementsByName("strPrevCPACode")[0].value!=""){
		document.getElementById("cpaCodeId").innerHTML="<font color='red'>*</font>Drug Code";
		document.getElementById("CPAFINALID").style.display="block";
	}else{
			document.getElementById("cpaCodeId").innerHTML="Drug Code";
			document.getElementById("CPAFINALID").style.display="none";
			
	}
}
*/
function setMandatoryDivOnLoad() {
	document.forms[0].strBatchNo.checked = true;
	document.forms[0].strBatchNo.value = "1";
	document.forms[0].strExpiryDate.checked = true;
	document.forms[0].strExpiryDate.value = "1";
	var drugTypeOption = document.forms[0].strDrugType[1];
	var str=drugTypeOption.checked;
	
	if(str==true) {
		
		checkMandatoryDetails(drugTypeOption);
	}
}


function setCPACode(cmbObj)
{
   document.getElementById("errMsg").innerHTML="";
   document.getElementById("warningMsg").innerHTML="";
   document.getElementById("normalMsg").innerHTML="";
   
   
    var url ="DrugMstCNT.cnt?hmode=getStrMktUnitIdBasedOnItemId&genericItemId="+document.forms[0].strGenericItemId.value;
	 		ajaxFunction(url,"1");

	if(document.forms[0].strIsItemCodeRequired.value == '0') {
		
		var cpaObj = document.getElementById("CPAFINALID");
		
		if(cmbObj.value != '0'){
		 
		
			var temp = cmbObj.value.split('^')[2];
		
			if(temp ==null || temp=="" || temp=="0") {
				
				cpaObj.innerHTML = "<div class='row'>"+  
				   "<div class='col-sm-6'><label>Generic Code.Drug Code</label></div>"+
				   "<div class='col-sm-6'><input type='text' value='0' name='strNewCPACode' maxlength='20' onkeypress='return validateData(event,9);' class='form-control'></div> "+
				   "</div>";
				
			} else {
				
				cpaObj.innerHTML = "<div class='row'>"+  
				   "<div class='col-sm-6'><label>Generic Code.Drug Code</label></div>"+
				   "<div class='col-sm-6'>"+temp+"."+
				   "<input type='text' name='strNewCPACode' maxlength='20' value='0' onkeypress='return validateData(event,9);' form-control'></div> "+
				   "</div>";
				
			}
			
			cpaObj.style.display = "block";
		
		}else{
		
			cpaObj.innerHTML = "";
			cpaObj.style.display = "none";
		
		}
		
	} else {
		
		
		var cpaObj = document.getElementById("CPAFINALID");
		
		if(cmbObj.value != '0'){
		 
		
			var temp = cmbObj.value.split('^')[2];
			
			if(temp ==null || temp=="" || temp=="0") {
				
				cpaObj.innerHTML = "<div class='row'>"+  
				   "<div class='col-sm-6'><label>Generic Code.Drug Code</label></div>"+
				   "<div class='col-sm-6'><input type='text' value='0' name='strNewCPACode'maxlength='20' onkeypress='return validateData(event,9);' class='form-control'> </div>"+
				   "</div>";
				
			} else {
				
				cpaObj.innerHTML = "<div class='row'>"+  
				   "<div class='col-sm-6'><label>Generic Code.Drug Code</label></div>"+
				   "<div class='col-sm-2'>"+temp+"."+"</div>"+"<div class='col-sm-4'>"+
				   "<input type='text' name='strNewCPACode' maxlength='20' value='0'  onkeypress='return validateData(event,9);' class='form-control'> </div> "+
				   "</div>";
				
			}
		
			
			cpaObj.style.display = "block";
		
		}else{
		
			cpaObj.innerHTML = "";
			cpaObj.style.display = "none";
		
		}
		
	}
		

}	


function getAjaxResponse(res,mode){
	
	
	if(mode=="1"){ 
		
		
		
			var objVal= document.getElementById("unitDivId");
			objVal.innerHTML = "<select name ='strMktRateUnitId' class='form-control' onchange=''>"+res+"</select>";	
			
			
			/*added By vikrant for UNIT combo after discussion with priyesh sir*/
			var objval1=document.getElementById("unitDivId1");
			objval1.innerHTML="<select name='strRateUnitId' class='form-control'>"+res+"</select>";
		
	}	
	

}	
	


function showHideRate(obj)
{
  if(obj.checked)
  {
     document.getElementById("issueRate").style.display='';
     document.forms[0].strIssueRateConfigFlg.value="1";
     
    
  }
  else
  {
    document.getElementById("issueRate").style.display='none';
    document.forms[0].strIssueRateConfigFlg.value="0";
  }
}



// Function for Numeric(11,2)
function numericWithTwoDecimalPlaces(fld, milSep, decSep, e)
{
	var sep = 0;
	var key = '';
	var milSep="";
	var i = j = 0;
	var len = len2 = 0;
	var strCheck = '0123456789';
	var aux = aux2 = '';
	var whichCode = (window.Event) ? e.which : e.keyCode;
	//if (whichCode == 13) return true;  // Enter
	if (whichCode == 0)	return true; //tab-index
	//alert(whichCode);
	if (whichCode == 8) return true;  // Back-Space 
	key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		//len = fld.value.length;
		
		len=11;
		for(i = 0; i < len; i++)
		if ((fld.value.charAt(i) != '0') && (fld.value.charAt(i) != decSep)) break;
		aux = '';
		
		for(; i < len; i++)
		if (strCheck.indexOf(fld.value.charAt(i))!=-1) aux += fld.value.charAt(i);
		aux += key;
		len = aux.length;
		if (len == 0) fld.value = '';
		if (len == 1) fld.value = ''+ decSep + '' + aux;
		if (len == 2) fld.value = ''+ decSep + aux;
		if (len > 2) {
		aux2 = '';
		for (j = 0, i = len - 3; i >= 0; i--) {
		if (j == 3) {
		aux2 += milSep;
		j = 0;
	}
	aux2 += aux.charAt(i);
	j++;
	}
	fld.value = " ";
	len2 = aux2.length;
	for (i = len2 - 1; i >= 0; i--)
	fld.value += aux2.charAt(i);
	fld.value += decSep + aux.substr(len - 2, len);
	}
return false;
}	


function view1(id1,id2,id3)
{
	document.getElementById(id1).style.display="none";
	document.getElementById(id2).style.display="block";
	document.getElementById(id3).style.display="block";
}
function view2(id1,id2,id3)
{
	document.getElementById(id1).style.display="block";
	document.getElementById(id2).style.display="none";
	document.getElementById(id3).style.display="none";
}

function setBatchNo()
{
	if(document.forms[0].strBatchNo.checked)
	{
		document.forms[0].strBatchNo.value="1";
	}
	else
	{
		document.forms[0].strBatchNo.value="0";
	}
}
function setExpiryDate()
{
	if(document.forms[0].strExpiryDate.checked)
	{
		document.forms[0].strExpiryDate.value="1";
	}
	else
	{
		document.forms[0].strExpiryDate.value="0";
	}
}


</script>

<style type="text/css">
	/* .legendvs{
	    position: absolute;
	    right: 100px;
	    line-height: 1.2em;
	    top: 0.6em;
	 } */
    .prescriptionTile {
		margin: 20px;
		border-bottom: 1px solid #d7d7d7;
		padding-bottom: 10px;
		padding: 1% 2% 0.5% 2%;
		background-color: #fff;
		transition: 0.5s;
		box-shadow: 0.5px 0.5px 10px 2px #b0acac;
		border-radius: .35rem;
		color: #666;
		color: rgba(75, 75, 75, 0.9);
		color: rgb(21, 21, 21);
	}
	.legend2 {
	   position: absolute;
	   top: 0.5em;
	   right: 44px;
	   line-height: 1.2em;
	}
}
</style>
</head>
<body onload="setMandatoryDivOnLoad();">
<html:form action="/masters/DrugMstBSCNT" name="drugBean" type="mms.masters.controller.fb.DrugMstFB">

<div class="container-fluid">
	<div class="prescriptionTile">
		<div class="row" >
			<div class="legend2">
				<button type="button" class="float-right btn btn-danger cancelbtn my-1" style="border-radius:50%; padding:10px 12px;" onclick="cancel('LIST');">
					<i class="fas fa-times" title="Cancel"></i>
				</button>
				<button type="button" class="float-right btn btn-secondary my-1" onclick="document.forms[0].reset();" style="border-radius:50%; background: royalblue;padding:10px 9px;">
					<i class="fas fa-broom" title="Clear"></i>
					<!-- <img src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 22px; color: #fff;"> -->
				</button>
				<button type="button" id="submitId" class="float-right btn btn-success my-1" tabindex="2" onclick="return validate();" style="border-radius:50%; padding:10px 12px; background-color: #5cb85c;">
					<i class="fas fa-save iround" title="save"></i>
				</button> 	
			</div>	
		</div>   
	
		<div class="errMsg" id="errMsg"><bean:write name="drugBean" property="strErrMsg" /></div>
		<div class="warningMsg" id="warningMsg"><bean:write name="drugBean" property="strWarningMsg" /></div>
		<div class="normalMsg" id="normalMsg"><bean:write name="drugBean" property="strNormalMsg" /></div>
	
		<%-- <tag:tab tabLabel="Drug Master" selectedTab="FIRST" align="center"
			width="TABLEWIDTH" onlyTabIndexing="1">
		</tag:tab> --%>
	
		<div class="row">	
			<p class="subHeaders" style="margin-bottom: 0;">
				<i class="fas fa-university" style="font-size: 26px;">&nbsp;</i>Drug Master
				<i class="fas fa-angle-double-right"></i><label>Add</label>
			</p>
		</div>
				
		<div class="row" style=" display: flex;justify-content: center;font-weight: 600">	
			<label>Group Name:</label>
			<div>
				&nbsp;<bean:write name="drugBean" property="strGroupName" filter="false" />
			</div>
		</div>
		<br>
		
	<div class="container">
	
	<div class="row">	
		<%-- <div class="row">
		<div class="col-sm-4">
		<label>Group Name:</label>
		</div>
		<div class="col-sm-8" align="left" style="font-weight: 400">
		<bean:write name="drugBean" property="strGroupName" filter="false" />
		</div>
		</div> --%>
		<div class="col-sm-2">
			<label><font color="red">*</font>Generic Drug Name</label>
		</div>
		<div class="col-sm-2">
		 <select class="form-control" name="strGenericItemId" onchange="setCPACode(this);">
			<bean:write name="drugBean" property="strGenericItemValues" filter="false" />
		 </select>
		</div>
		
		<div class="col-sm-4">
			<div class="row">
				<div class="col-sm-12" id="CPAFINALID" style="display: none;"></div>
			</div>
		</div>
		
		<div class="col-sm-4" align="right">
			<html:radio name="drugBean" property="strDrugType" value="1" onclick="checkMandatoryDetails(this);">Branded</html:radio>
			<html:radio	name="drugBean" property="strDrugType" value="2" onclick="checkMandatoryDetails(this);">Non-Branded</html:radio>
		</div>
	</div>
		
	<div class="row my-1">
	<div class="col-sm-2">
	<label><font color="red">*</font>Drug Type</label>
	</div>
	<div class="col-sm-2">
		<select	name="strItemType" class="form-control">
			<bean:write name="drugBean" property="strItemTypeValues" filter="false" />
		</select>
	</div>
	
	<div class="col-sm-2">
	<label><font color="red">*</font>Drug Name</label>
	</div>
	<div class="col-sm-2">
	<input type="text"	name="strDrugName" maxlength="250" class="form-control"
	onkeypress="return validateDataWithSpecialChars(event,18,'%.:;+-/*,½');" />
	</div>
	<div class="col-sm-2">
	<div id="manfMandatoryDivId" style=""><label><font color="red">*</font>Manufacturer</label>
	</div>
	<div id="manfNonMandatoryDivId" style="display: none;">
	<label><font color="red">*</font>Manufacturer
	</label></div>
	</div>
	<div class="col-sm-2">
	<select name="strManufacturerId" class="form-control">
	<bean:write name="drugBean" property="strManufacturerVal" filter="false" />
	</select>
	</div>
	</div>
		
	<div class="row my-1">
	<div class="col-sm-2">
	
	<label><font color="red">*</font>HSN Code.</label>
	</div>
	<div class="col-sm-2">
	<input type="text"	name="strHSNCode" maxlength="10" class="form-control"
		onkeypress="return validateData(event,7);" />
	</div>
	<div class="col-sm-2">
	
	<label><font color="red">*</font>Default Rate</label>
	</div>
	<div class="col-sm-2">
	<input type="text"	name="strDefaultRate" value="0" class="form-control" 
	maxlength="14"	onkeypress="return validateData(event,7);" />
	</div>
	<div class="col-sm-2">
	
	<label><font color="red">*</font>Rate/Unit</label>
	</div>
	<div class="col-sm-2" id="unitDivId1">
	<select name="strRateUnitId" class="form-control">
	<option value="0">Select Value</option>
	</select>
	</div>
	<input type="hidden" name="strRateUnitId"	value="${drugBean.strRateUnitId }">
	</div>
		
		<!-- <div id="itemManagePlusId" align="left" style="display: none;">
		 <p class="subHeaders" style="margin-bottom: 0;">
		<button type="button" class="btn btn-info" onClick="view1('itemManagePlusId','itemManageMinusId','itemManageDtlId');" style="cursor: pointer;">
		<i class="fas fa-plus iround"></i>&nbsp;Drug Managed By</button>
		</p>
		</div>
		<div id="itemManageMinusId" style="display: block;" align="left">
		<p class="subHeaders" style="margin-bottom: 0;">
		<button type="button" class="btn btn-info" onClick="view2('itemManagePlusId','itemManageMinusId','itemManageDtlId');" style="cursor: pointer;">
		<i class="fas fa-minus iround"></i>&nbsp;Drug Managed By
		</button>
		</p>
		</div> -->
	<hr>
	<div class="row">	
		<div class="col-sm-4">
			<p class="subHeaders" style="margin-bottom: 0;">
			Drug Managed By
		</p>
		</div>
	
		<div class="col-sm-2">
			<label>Batch No.</label>
		</div>
		<div class="col-sm-2 p-2" >
			<html:checkbox	property="strBatchNo" onclick="setBatchNo();" name="drugBean" ></html:checkbox>
		</div>
		<div class="col-sm-2">
			<label>Expiry Date</label>
		</div>
		<div class="col-sm-2 p-2" >
			<html:checkbox	property="strExpiryDate" onclick="setExpiryDate();"	name="drugBean" ></html:checkbox>
		</div>
	</div>
	<hr>	
	
	<div class="row">	
		<div class="col">
			<p class="subHeaders" style="margin-bottom: 0;">
			Drug Parameter</p>
		</div>
	</div>
		
		<div class="row my-1">
		<div class="col-sm-2">
		<label><font color="red">*</font>Approved Type</label>
		</div>
		<div class="col-sm-2">
		<select	name="strApprovedType" class="form-control">
		<bean:write name="drugBean" property="strApprovedTypeOptions" filter="false" />
		</select>
		</div>
		<div class="col-sm-2">
		<label><font color="red">*</font>Drug Make</label>
		</div>
		<div class="col-sm-2">
		<select  property="strItemMake" class="form-control" name="drugBean">
		<option value="1">Indian</option>
		<option value="2">Foriegn</option>
		</select>
		</div>
		<div class="col-sm-2">
		<label><font color="red">*</font>Drug Class
		</label>
		</div>
		<div class="col-sm-2">
		<select	name="strDrugClass" class="form-control">
		<bean:write name="drugBean" property="strDrugClass" filter="false" />				
		</select>
		</div>
		</div>
		
		
		<div class="row my-1">
			<div class="col-sm-3">
				<label>Whether Issue Rate Is Configurable</label>
			</div>
			<div class="col-sm-1 p-2" align="right">
				<input type="checkbox" name="strChkFlg" value="0" onClick="showHideRate(this);">
			</div>	
		
			<div class="col-sm-4">
				<div class="row" id="issueRate" style="display:none;">
				<div class="col-sm-6">
				<label>Issue Rate</label>
				</div>
				<div class="col-sm-6">
				<input type='text' name="strConfigIssueRate" <%-- value="${drugBean.strConfigIssueRate}"  --%> 
				onkeypress="return validateData(event,7);" maxlength="5"  placeholder="% of Purchase Rate" class='form-control'>			  
				</div>
				<!-- <div class="col-sm-5" align="left">
				
				<label>% of Purchase Rate</label>
				</font>
				</div> -->
				</div>
		   </div>
		   
		   <div class="col-sm-2">
			<div id="specMandatoryDivId" style="display: block;">
			<label><font color="red">*</font>
			Specification</label>
			</div>
			<div id="specNonMandatoryDivId" style="display: none;">
			<label><font color="red">*</font>
			Specification</label>
		   </div>
		   </div>
		   
		  <div class="col-sm-2">
			<textarea class="form-control" name="strSpecification" rows="1" cols="16" style="height:38px;"></textarea>
		  </div>
		  </div>
		
		<div class="row my-2">
		<div class="col-sm-1">
			<label>Is Misc</label>
		</div>
		
		<div class="col-sm-1 p-2">
			<html:checkbox	property="strIsMisc" name="drugBean" onclick="setIsMisc();"></html:checkbox>
		</div>	
		
		<div class="col-sm-2">
		<label>Whether Drug is Sachet</label>
		</div>
		<div class="col-sm-1 p-2">
		<html:checkbox property="strIsItemSachet" onclick="setIsItemSachet();"	name="drugBean"></html:checkbox>
		</div>
		<div class="col-sm-3" >
		
		<label>Whether Drug is Non-Quantifiable</label>
		</div>
		<div class="col-sm-1 p-2">
		<html:checkbox	property="strIsQuantifiable" name="drugBean" onclick="setIsQuantifiable();"></html:checkbox>
		</div>
		<div class="col-sm-3">
		<div class="row">
		<div class="col-sm-10">
		
		<label>Whether Drug is EDL Category</label>
		</div>
		<div class="col-sm-1 p-2">
		<input type="checkbox" name="strEdlCat" value="0" onClick="">
		</div>
	</div>
	</div>
	</div>
	</div>
		<hr>
			 
		<div class="row text-right">
	    	<div class="col">
	    		<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>&nbsp;Fields Mandatory
	    	</div>
		</div>
		

	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<!-- <tr class="HEADER">
			<td colspan="4">Drug Master11 &gt;&gt; Add</td>
		</tr> -->
		<%-- <tr>
			<td colspan="4" class="LABEL">
			<html:radio name="drugBean"
				property="strDrugType" value="1"
				onclick="checkMandatoryDetails(this);">Branded</html:radio> <html:radio
				name="drugBean" property="strDrugType" value="2"
				onclick="checkMandatoryDetails(this);">Non-Branded</html:radio> 
				
				<!-- commented by vikrant after discussion with priyesh sir -->
				<!--   <html:radio	name="drugBean" property="strDrugType" value="3" onclick="checkMandatoryDetails(this);" style="display : none;">Reserved</html:radio>-->
				</td></tr>  --%>
		<!-- <tr>
			<td colspan="2" class="LABEL">Category</td>
			<td colspan="2" width="25%" class="CONTROL">Drug Category</td>

		</tr> -->
	
		<%-- <tr>
			<td colspan="2" class="LABEL">Group Name</td>
			<td colspan="2" width="50%" class="CONTROL"> <bean:write
				name="drugBean" property="strGroupName" filter="false" /> </td>

		</tr> --%>

		<%-- <tr>
			<td colspan="2" class="LABEL"><font color="red">*</font>Generic	Drug Name</td>
			<td colspan="2" width="50%" class="CONTROL">
			<select class="comboNormal" name="strGenericItemId" onchange="setCPACode(this);">
				<bean:write name="drugBean" property="strGenericItemValues" filter="false" />
			</select> </td>

		</tr> --%>
	</table>
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<%-- <tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Drug Type</td>
			<td width="50%" class="CONTROL">
			<select
				name="strItemType" class="comboNormal">
				<bean:write name="drugBean" property="strItemTypeValues"
					filter="false" />

			</select> </td>
		</tr> --%>
		
		
		
		<!-- <tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Drug Name</td>
			<td width="50%" class="CONTROL">
			<input type="text"	name="strDrugName" maxlength="250" class="txtFldMax" style="width: 300px"	onkeypress="return validateDataWithSpecialChars(event,18,'%.:;+-/*,½');" />
			</td>
		</tr> -->
		<%-- <tr>
			<td width="50%" class="LABEL">
			<div id="manfMandatoryDivId" style=""><font color="red">*</font>Manufacturer</div>
			<div id="manfNonMandatoryDivId" style="display: none;">Manufacturer</div>
			</td>
			<td width="50%" class="CONTROL">
			<select name="strManufacturerId" class="comboMax">
				<bean:write name="drugBean" property="strManufacturerVal" filter="false" />
			</select>
			</td>
		</tr> --%>
		<!-- <tr>
			<td width="50%" class="LABEL">HSN Code</td>
			<td width="50%" class="CONTROL">
			<input type="text"	name="strHSNCode" maxlength="10" class="txtFld" style="width: 100px"	onkeypress="return validateData(event,7);" />
			</td>
		</tr> -->
	</table>
	<div >
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<!-- <tr>
			<td colspan="1" width="25%" class="LABEL">Default Rate</td>
			<td colspan="1" width="25%" class="CONTROL">
			<input type="text"	name="strDefaultRate" value="0" class="txtFldNormal" maxlength="14"	onkeypress="return validateData(event,7);" /></td>
			<td colspan="1" width="25%" class="LABEL"><font color="red">*</font>Rate/Unit</td>
			<td colspan="1" width="25%" class="CONTROL">
		  	commented as combo was needed after discussion with priyesh sir
		  	<bean:write	name="drugBean" property="strRateUnitName" filter="false" />
		  	<div id="unitDivId1">
		    <select name="strRateUnitId" class="comboMax">
				<option value="0">Select Value</option>
			</select>
			</div>
			 <input type="hidden" name="strRateUnitId"	value="${drugBean.strRateUnitId }">
			</td>
			
		</tr> -->

		</table>
	</div>


<!-- Added by vikrant after discussion with priyesh sir -->

    <!--  <table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="itemManagePlusId" align="left" style="display: none;">
			<img src="../../hisglobal/images/plus.gif"	onClick="view1('itemManagePlusId','itemManageMinusId','itemManageDtlId');"	style="cursor: pointer; " />Drug Managed By</div>
			<div id="itemManageMinusId" style="display: block;" align="left">
			<img src="../../hisglobal/images/minus.gif"	onClick="view2('itemManagePlusId','itemManageMinusId','itemManageDtlId');" style="cursor: pointer; " /> Drug Managed By</div>
			</td>
		</tr>
	  </table> -->
	
	<%-- <div id="itemManageDtlId">
	<table class="TABLEWIDTH" align="center" cellspacing="1px"	cellpadding="0px">
		<tr>
			<td class="LABEL" colspan="1" width="25%">Batch No.</td>
			<td class="CONTROL" colspan="" width="25%">
			<html:checkbox	property="strBatchNo" onclick="setBatchNo();" name="drugBean" ></html:checkbox>
			</td>
			<td class="LABEL" width="25%">Expiry Date</td>
			<td class="CONTROL" width="25%">
			<html:checkbox	property="strExpiryDate" onclick="setExpiryDate();"	name="drugBean" ></html:checkbox>
			</td>
		</tr>
	 </table>
	 </div> --%>

    

   <table class="TABLEWIDTH" align="center" cellspacing="1px"	cellpadding="0px">
		<!-- <tr>
			<td colspan="4" class="TITLE" width="25%">Drug Parameter</td>
		</tr> -->

		<%-- <tr>
			<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>Approved Type</td>
			<td class="CONTROL" colspan="1" width="25%">
			<select	name="strApprovedType" class="comboNormal">
				<bean:write name="drugBean" property="strApprovedTypeOptions" filter="false" />
			</select></td>
			<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>Drug Make</td>
			<td class="CONTROL" width="25%" colspan="1" > <html:select
				property="strItemMake" name="drugBean">
				<html:option value="1">Indian</html:option>
				<html:option value="2">Foriegn</html:option>
			</html:select></td>
			
		</tr> --%>
		<%-- <tr>
			<td class="LABEL" colspan="1" width="25%" style="display:none;"><font color="red">*</font>Issue Type</td>
			<td class="CONTROL" colspan="1" width="25%">
				<html:select property="strIssueType" name="drugBean" style="display:none;">
					<bean:write name="drugBean" property="strIssueTypeComboOptions" filter="false" />
				</html:select>
			</td>
			<td class="LABEL" colspan="1" width="25%" style="display:none;" ><font color="red" >*</font>QC Type</td>
			<td class="CONTROL" width="25%" colspan="1" style="display:none;" >
			<html:select property="strQCType" name="drugBean">
				<html:option value="0">Non-Mandatory</html:option>
				<html:option value="1">Mandatory</html:option>
				<html:option value="2">Desirable</html:option> 
			</html:select>
			</td>
			
			
		</tr> --%>
		
		<tr>
			<!--
			currently commented after discusison with priyesh sir
			for future scope
			
			<td class="LABEL" colspan="1" width="25%" >Drug Classification</td>
			<td class="CONTROL" colspan="1" width="25%">
			<select	name="strDrugClassification" class="comboNormal">
				<option value="0">Select Value</option>
				<option value="1">V</option>
				<option value="2">E</option>
				<option value="3">D</option>
			</select>
            </td>-->
            
            
			<%-- <td class="LABEL" colspan="1" width="25%">Drug Class</td>
			<td class="CONTROL" colspan="1" width="25%"  >
			<select	name="strDrugClass" class="comboNormal">
			 <bean:write name="drugBean" property="strDrugClass" filter="false" />
				
			</select>
			</td> --%>
			
			<%-- <td class="LABEL" colspan="1" width="25%"  >Is Misc</td>
			<td class="CONTROL" colspan="1" width="25%"  >
			<html:checkbox	property="strIsMisc" name="drugBean" onclick="setIsMisc();"></html:checkbox></td> --%>
		</tr>
		<%-- 
		<tr>
			<td class="LABEL" colspan="1" width="25%" >Whether Drug is Sachet</td>
			<td class="CONTROL" colspan="1" width="25%">
			<html:checkbox property="strIsItemSachet" onclick="setIsItemSachet();"	name="drugBean"></html:checkbox></td>
			<td class="LABEL" colspan="1" width="25%"  >Whether Drug is Non-Quantifiable</td>
			<td class="CONTROL" colspan="1" width="25%"  >
			<html:checkbox	property="strIsQuantifiable" name="drugBean" onclick="setIsQuantifiable();"></html:checkbox></td>
		</tr> --%>

	</table>
	
	
	<!-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="0px">
		<tr>
		<td class="LABEL" width="25%" colspan="1"><b>Whether Issue Rate Is Configurable</b></td>
		<td class="CONTROL" width="25%" colspan="1">
		   <input type="checkbox" name="strChkFlg" value="0" onClick="showHideRate(this);">
		</td>
		<td class="LABEL" colspan="1" width="25%">Whether Drug is EDL Category</td>
		<td class="CONTROL" colspan="1" width="25%">
		<input type="checkbox" name="strEdlCat" value="0" onClick="">
		</td>
		</tr>
		</table> -->
	
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="0px">
				<%-- <tr id="issueRate" style="display:none;">
				   <td class="LABEL" width="25%" colspan="1" >Issue Rate</td>
				    <td class="CONTROL" width="75%" colspan="3" >			  
				    	<input type='text' name="strConfigIssueRate" value="${drugBean.strConfigIssueRate}"  onkeypress="return validateData(event,7);" maxlength="5" class='txtFldNormal'><b>% of Purchase Rate</b>				  
				 	</td>			 			 
				</tr>	 --%>
				
				
				<tr style="display:none;">
					<td class="LABEL" width="25%" colspan="1" >MRP</td>
				    <td class="CONTROL" width="20%" colspan="1" >			  
				    	<input type='text' name="strMktRate"   onkeypress="return(numericWithTwoDecimalPlaces(this,',','.',event));" >
				    					  <b>/</b>
				 	</td>
				 	
				 	<td class="CONTROL" width="55%" colspan="2" >
				 		<div id="unitDivId">			  
					    	<select name="strMktRateUnitId" >
					    		<option value="0">Select Value</option>
					    	</select>				    				
				    	</div>				  
				 	</td>  
				</tr>	
		</table>
  
	
	<table cellspacing="1px" cellpadding="1px" class="TABLEWIDTH"
		align="center">
		<tr>
			<!-- <td class="LABEL" colspan="1" width="25%">
			<div id="specMandatoryDivId" style="display: block;"><font
				color="red">*</font>Specification</div>
			<div id="specNonMandatoryDivId" style="display: none;">Specification</div>
			</td>
			<td class="CONTROL" width="25%" colspan="1"><textarea rows="2"
				cols="20" name="strSpecification"></textarea></td> -->
			<td class="LABEL" colspan="1" width="25%" style="display:none;"><font color="red">*</font>Effective
			From</td>
			<td class="CONTROL" width="25%" colspan="1"  style="display:none;"><dateTag:date
				name="strEffectiveFrom" value="${drugBean.strCurrentDate}"></dateTag:date>
			</td>
		</tr>
	</table>
	<!-- <table cellspacing="1px" cellpadding="1px" class="TABLEWIDTH"
		align="center">
		<tr class="FOOTER">
			<td colspan="4" width="25%"><font size="2" color="red">*</font>
			Mandatory Fields</td>
		</tr>
	</table> -->
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">

		<tr>

			<td align="center" colspan="2" width="25%"><!-- <img
				src="../../hisglobal/images/btn-sv.png" title="Save Record"
				onClick="return validate();" style="cursor: pointer;" /> <img
				src="../../hisglobal/images/btn-clr.png"
				onClick="document.forms[0].reset();" style="cursor: pointer;"
				title="Clear Content" /> <img
				src="../../hisglobal/images/btn-ccl.png" onClick="cancel('LIST');"
				style="cursor: pointer;" title="Cancel Process">-->
				<br>					 
				<!-- <a href="#" class="button" id="" onclick=' return validate();'><span class="save">Save</span></a>
				<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
				<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a> -->
				
				</td>
		</tr>
	</table>
		
		<input type="hidden" name="hmode" />
		<input type="hidden" value="${drugBean.strCPACode}"	name="strPrevCPACode" />
		<input type="hidden" value="${drugBean.strCurrentDate}"	name="strCurrentDate" />
		<input type="hidden" value="${drugBean.strGroupId}" name="strGroupId" />
		<input type="hidden" value="${drugBean.strComboValue}"	name="strComboValue" />
		<input type="hidden" value="${drugBean.strIsItemCodeRequired}" name="strIsItemCodeRequired" />
		<input type="hidden" value="" name="strCPACode" value="0" />
		<input type="hidden" name="strIssueRateConfigFlg" value="0">
	<cmbPers:cmbPers />
	</div>
	</div>

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>
