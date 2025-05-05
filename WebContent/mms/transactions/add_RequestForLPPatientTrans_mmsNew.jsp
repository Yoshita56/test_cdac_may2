<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>
<!-- 
/**
 * @author Amit Kumar
 * Date of Creation : 31/4/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
 -->
<html>
<head>
<meta charset=UTF-8">
<title>Request for Patient</title>
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css"   rel="stylesheet" />
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
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/dropdown.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" 
type="text/css">


<script language="Javascript" src="../js/patientListing.js"></script>

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../js/searchItems_utilBS.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/newMultiRow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/dropdown.js"></script>

<script language="JavaScript" src="../js/mms.js"></script>


<script language="JavaScript" src="../../hisglobal/js/common.js"></script>

<script language="JavaScript" src="../js/RequestForLpPatient.js"></script>


<style type="text/css">

.newhr{
border-top: 3px solid rgb(6, 138, 255);
margin-right: -16px;
margin-left: -16px;
}
.table th, .table td {
padding: 0.15rem;
}
.custom-select[multiple], .custom-select[size]:not([size="1"]) {
height: 220px;
}
.comboMin{
display: inline-block;
width: 100%;
height: calc(1.5em + 0.75rem + 2px);
padding: 0.375rem 1.75rem 0.375rem 0.75rem;
font-size: 0.8rem;
font-weight: 400;
line-height: 1.5;
color: #495057;
vertical-align: middle;
background: url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 4 5'%3e%3cpath fill='%23343a40' d='M2 0L0 2h4zm0 5L0 3h4z'/%3e%3c/svg%3e") no-repeat right 0.75rem center/8px 10px;
background-color: rgba(0, 0, 0, 0);
background-color: #fff;
border: 1px solid #ced4da;
border-radius: 0.25rem;
-webkit-appearance: none;
-moz-appearance: none;
appearance: none;
}
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

.table .thead-dark {
  	color: #000 !important;
  	border: none !important;
  	background:linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;
}
.thead-dark th{
	background:none !important;
	border: none !important;
	text-align: center;
		
}

</style>

<script type="text/javascript">
var keyupTimer;
var searchMode1;
var parentObj1;
var eve1;
var vindex1;

/*
 * isAvailReq is a global variable declared and defined in mms.js. If the
 * comparison of required qty vs. available qty is required, then it is 
 * set to 1. Otherwise its value should be 0, as in this case.
 */
 
gblIsAvailReq=0;

function getIcdCodeValues1(searchMode , parentObj, eve , vindex)
{
   clearTimeout(keyupTimer);
   searchMode1=searchMode;
   parentObj1=parentObj;
   eve1=eve;
   vindex1=vindex;   
   // will activate when the user has stopped typing for 1 second
   keyupTimer = setTimeout("getIcdCodeValues2()",500); 
} 
function newRow()
{
	/*if(document.getElementById("dropdown1").style.display=="block")
	alert("Please Enter Data in Current Row");
	else*/	
	addRows(new Array('strProvisionDiagnosis','strIcdCode','strICD10CodeHidden'),new Array('t','t','t'),'2','1','R');
	setAutoCompleteOffForICD_Code();
}

function getIcdCodeValues2()
{
   var temp=vindex1.split("-")[1]-1;
   var tempId="strIcdCode2-"+temp;
   var diagnosisDescriptionId="strIcdCode2-"+vindex1.split("-")[1];
   var diagnosisCodeId="strProvisionDiagnosis2-"+vindex1.split("-")[1];
   if(vindex1.split("-")[1]-1=='0')
   {
   		getIcdCodeValues(searchMode1 , parentObj1, eve1 , vindex1);
   }
   else
   {  
	   if(document.getElementById(tempId)!=null && document.getElementById(tempId).value=="") {
	   		alert("Please Enter Data in Previous Row");
	   		
	   		document.getElementById(diagnosisDescriptionId).value="";
	   		document.getElementById(diagnosisCodeId).value="";
	   } else {
	   		getIcdCodeValues(searchMode1 , parentObj1, eve1 , vindex1);
	   }
   }
}
var tempCode = "";
var gblParentObj = "";
var gblIndex = "";
var child = null;
var popIndex = 0;
var gblCntrlObj = null;
function getIcdCodeValues(searchMode , parentObj , eve , vindex)
{	
	gblParentObj = parentObj;
	gblIndex = vindex;	
	var key;
	if(window.event)
		key = window.event.keyCode;
	else
	{
		if (eve)
			key = eve.which;		 
	}	
	tempCode = key;//single quotes
 		if(tempCode == 222)
 		{ 		
 			parentObj.value = parentObj.value.substring(0,parentObj.value.length-1);
 			return false;
 		}		
		var url="";
		var hmode="";		
		var searchContent = parentObj.value;
		if(parentObj.value.length>1)
		{
 			searchContent = parentObj.value.substring(0,1);
 		}
		if(searchContent.length == 1)
		{
		 	if(document.getElementsByName("strDiagnosisType")[0].checked && document.getElementsByName("strDiagnosisType")[0].value=="0")
		 	{	
				hmode = "ICDDIAGNOSIS"; 
				url = "/AHIMS/mms/transactions/RequestForLPPatientBSCNT.cnt?hmode="+hmode+"&strSearchMode="+searchMode+"&strSearchString="+searchContent;
			}
			if(document.getElementsByName("strDiagnosisType")[0].checked && document.getElementsByName("strDiagnosisType")[0].value=="1")
		 	{	
				hmode = "HOSITALPDIAGNOSIS";
				url = "/AHIMS/mms/transactions/RequestForLPPatientBSCNT.cnt?hmode="+hmode+"&strSearchMode="+searchMode+"&strSearchString="+searchContent;
			}
			if(document.getElementsByName("strDiagnosisType")[1]!=undefined)
			{
				if(document.getElementsByName("strDiagnosisType")[1].checked && document.getElementsByName("strDiagnosisType")[1].value=="0")
			 	{	
					hmode = "ICDDIAGNOSIS"; 
					url = "/AHIMS/mms/transactions/RequestForLPPatientBSCNT.cnt?hmode="+hmode+"&strSearchMode="+searchMode+"&strSearchString="+searchContent;
				}
				if(document.getElementsByName("strDiagnosisType")[0].checked && document.getElementsByName("strDiagnosisType")[0].value=="1")
			 	{	
					hmode = "HOSITALPDIAGNOSIS"; 
					url = "/AHIMS/mms/transactions/RequestForLPPatientBSCNT.cnt?hmode="+hmode+"&strSearchMode="+searchMode+"&strSearchString="+searchContent;
				}
			}		
			//alert("url :"+url);
			ajaxFunction(url,"2");
		}
		else
		{	
				if(document.getElementById("dropdown1").innerHTML.length <=0)
				{					
					var input = document.getElementById(parentObj.name+""+gblIndex).value;
					document.getElementById(parentObj.name+""+gblIndex).value = input.substring(0,input.length-1);
 					return false;					
				}		 	
		searchSel(eve,parentObj.name+""+vindex,'1',parentObj);		
	}	
}
function setIcdCodes(userValue , resultValue)
{

	 
	
		var resVals = resultValue.split('^');		
		document.getElementById("strProvisionDiagnosis"+userValue).value = resVals[0];
		document.getElementById("strIcdCode"+userValue).value = resVals[1];
		document.getElementById("strICD10CodeHidden"+userValue).value = resVals[0];
		clearTariffFullNameDiv();
		
}
	
	function invokeCheckQty(mode, index, unitObject)
	{
	    gblIsAvailReq = "0";	
	    if( checkQty(index,'strReqQty','strUnitName'))
		 {
		 
		 		calculateCost(mode, 'strReqQty', 'strUnitName', 'strCost', index , 'strApproxAmt','0');
		 }
			
	}	
	function getItemSelectPopup()
	{
		document.getElementById("strToStoreCombo").disabled=true;
	  if(document.getElementsByName("strCrNo")[0].value  == "" || document.getElementsByName("strCrNo")[0].value == null)
	  {
	             alert('please enter valid cr no...');
	             return false;
	  }
	  var ToStoreCmb   = document.forms[0].strToStoreCombo;
	  if(ToStoreCmb.value !=0)
       {	
	
	    var strModeVal 					= "1" ; 
		var strRequestType              = document.forms[0].strTmpReqType.value;
		var strItemCategory 			= document.forms[0].strTmpItemCatg.value; 
		//var strFromStoreId 				= document.forms[0].strTmpStoreName.value;//commented by shalini 
		var strFromStoreId 				= ToStoreCmb.value; //changed by shalini as tmp store is a virtual store and is having 0 inventory
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strReqQty','strUnitName','strCost');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t','s','t');
		var testFunction                = "CallFunc";
		var arg                         = " "; 	
		//var strMultiRowFetchDataArray 	= new Array('1','5','4','0^strUnitName^invokeCheckQty'); commented by shalini
		//var strMultiRowFetchDataArray 	= new Array('1','5','0^strUnitName^invokeCheckQty');//changed by shalini to remove avl qty
		var strMultiRowFetchDataArray 	= new Array('1','0^strUnitName^invokeCheckQty');//changed by shalini to remove rate unit
	
		  //  alert(strFromStoreId);
		  //  return false;
	    var layerIndex = "1";
	    var userInfo 	= document.forms[0].strToStoreCombo.value;
		var unitMode = "1";  // only base unit  1 Means Only Base Unit Show 0 Means All Unit Show in Unit Combo
	
        //searchItemsWithUserFunction ( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg);
        
        searchItemsWithUserFunction ( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg , userInfo , unitMode );
	  }
	  else
	   {
	   	       alert("Plz Select To Store Name !!!!");
	   	    	document.getElementById("strToStoreCombo").disabled=false;
	           ToStoreCmb.focus();
	            return false;
	    }
	 
	 }
	

    function changeMultiRows(obj)
    {
	    	var mulObj = document.getElementById("id1");
			mulObj.innerHTML = '';
			document.getElementsByName("rowIndex1")[0].value = 0;
			document.getElementsByName("rowLength1")[0].value = 0;	
			
			multiRowFunc();
	}
	function multiRowFunc(){
		if(document.forms[0].strDiagnosisType[0].checked == true){
			myFunc('1');	
		}else{
			myFunc('2');
		}
	}
	
	
	function myFunc(mode){
		if(mode == '1'){
			var hmode = "HOSITALPDIAGNOSIS"; 
			var url = "/AHIMS/ipd/transactions/RequestForLPPatientBSCNT.cnt?hmode="+hmode;
			ajaxFunction(url,"1");
		}else if(mode == '2'){
			var hmode = "ICDDIAGNOSIS"; 
			var url = "/AHIMS/ipd/transactions/RequestForLPPatientBSCNT.cnt?hmode="+hmode;
			ajaxFunction(url,"2");
		}
	}
	
 
 
 function CallFunc()
 {
	// alert(document.getElementsByName('itemParamValue')[0].value.split("^")[22]);
	 var itmlen=document.getElementsByName('itemParamValue').length;
	 var selItem=document.getElementsByName('rowLength1')[0].value;
	 var prevItem = (parseInt(itmlen) - parseInt(selItem)) - 1;
	// alert("prevItem"+prevItem);
	// alert("itmlen"+itmlen);
	// alert("selItem"+selItem);
	// alert("rowLength1"+document.getElementsByName('rowLength1')[0].value);
	 
	 for(var i = 0; i < prevItem ; i++ )
	 {
			 for(var j=prevItem; j < itmlen - 1 ;j++)
			 { 
				 //alert(document.getElementsByName('itemParamValue')[i].value.split("^")[22]);
				// alert(document.getElementsByName('itemParamValue')[j].value.split("^")[22]);
				// return false;
				 if(document.getElementsByName('itemParamValue')[i].value.split("^")[22] == document.getElementsByName('itemParamValue')[j].value.split("^")[22])
			 	 {
						alert(document.getElementsByName('itemParamValue')[j].value.split("^")[0] + "can't be added more than once");
						getItemSelectPopup();
						return false;
			 	 }	
			 }
 	 }
 }
 
 /*function getCount(parent, getChildrensChildren){
	    var relevantChildren = 0;
	    var children = parent.childNodes.length;
	    for(var i=0; i < children; i++){
	        if(parent.childNodes[i].nodeType != 3){
	            if(getChildrensChildren)
	                relevantChildren += getCount(parent.childNodes[i],true);
	            relevantChildren++;
	        }
	    }
	    return relevantChildren;
}*/
/*
	The function  setAutoCompleteOffForICD_Code will turn off the browser's auto 
	complete feature for icd code and description field. It is a non standard
	process with no guaranty to work properly. It is successfully tested on
	Firefox version 3.6.12 and IE 8.
	*/
 	function setAutoCompleteOffForICD_Code() {
		var i=0;
		icdCodeElement=document.getElementsByName("strIcdCode");
		provisionDiagnosisElement=document.getElementsByName("strProvisionDiagnosis");
		
		/*
		It is assumed that no of strIcdCode inputs and no of 
		strProvisionDiagnosis inputs are same.
		*/
		for (i=0;i<icdCodeElement.length;i++) {
			icdCodeElement[i].setAttribute("autocomplete", "off");
			provisionDiagnosisElement[i].setAttribute("autocomplete", "off");
		}
         
     }
	
	/*
	The function clearTariffFullNameDiv is used to clear the diagnosis full
	name from the display area at the bottom of the page. 
	*/
 	function clearTariffFullNameDiv() {
	 	var tariffFullNameDivElement;
	 	tariffFullNameDivElement = document.getElementById("tariffFullNameDiv");
	 	tariffFullNameDivElement.innerHTML="";
 	}
	
 	function showPatientListingWindowNew(mode , obj , userJsFuncName) 
 	 {
 	  	if(obj.value == "")
 	  	{
 	 				var hmode = "PATIENTLISTINGNew"; 
 					var url = "../transactions/IpdCNT.cnt?hmode="+hmode+"&patList="+mode+"&usrFuncName="+userJsFuncName;				
 				openPopUp(createFHashAjaxQuery(url),'700','220','1','',null);
 				
 				//$("#fetchRecordDivId").load(createFHashAjaxQuery(url));
 				//	$("#searchModel").modal("show");
 					
 					//var featuresList = "width=600,height=380,ALIGN=CENTER,left=300,top=300,scrollbars=yes";
 	               ///myWindow = window.open(url,'popupWindow',featuresList); 
 	 	}
 	 	else
 	 	{
 	 		alert("To Use Search Functionality Please Clear The CR No.");
 	 		obj.focus();
 	 	}
 	 }
 	
 	function showImg(obj)
 	{
 		 //alert("showImg");
 		//document.getElementsByName("strCrNo")[0].value = "";
 		initPage();
 		document.forms[0].strCrNo.disabled = false;
 		if(obj.value == "1")
 			document.getElementById("searchPatient1").style.display="";
 		else
 	 		document.getElementById("searchPatient1").style.display="none";
 	}
 	
 	function costReq()
 	{
 		console.log("-strTmpCrNo--"+document.getElementsByName("strTmpCrNo")[0].value);
 		console.log("-strTmpHospitalCode--"+document.getElementsByName("strTmpHospitalCode")[0].value);
 		if(document.getElementsByName("strTmpCrNo")[0].value!="")
 		{	
 		    document.getElementsByName("strCrNo")[0].value = document.getElementsByName("strTmpCrNo")[0].value;
 		}
 		else
 		{
 			document.getElementsByName("strCrNo")[0].value = document.getElementsByName("strTmpHospitalCode")[0].value;
 			
 		}
 			
 		if(document.getElementsByName("strCostRequired")[0].value=="1"){
 			document.getElementById("costDivReqId").style.display="block";
 			document.getElementById("costDivNotReqId").style.display="none";
 			document.getElementById("totalCostId").style.display="block";
 			
 		}else{
 			document.getElementById("costDivNotReqId").style.display="block";
 			document.getElementById("costDivReqId").style.display="none";
 			document.getElementById("totalCostId").style.display="none";
 		}
 	}
</script>




</head>

<body onload="return OnLoadFunction(),costReq();">
<script language="Javascript" src="../../hisglobal/js/wz_tooltip.js"></script>
<html:form action="/transactions/RequestForLPPatientBSCNT.cnt"
	name="requestForLpPatient"
	type="mms.transactions.controller.fb.RequestForLPPatientFB"
	method="post">

	<div class="errMsg" id="errMsg" style="font-size:16px;"><bean:write
		name="requestForLpPatient" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg" style="font-size:16px;"><bean:write
		name="requestForLpPatient" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg" style="font-size:16px;"><bean:write
		name="requestForLpPatient" property="strMsg" /></div>
	
	<%-- <div class="alert alert-danger  alert-dismissible fade show" id="errID" style="display: none;"><bean:write name="rateContractDtlBean" property="strErr" /></div>
				<div class="alert alert-success  alert-dismissible fade show" id="normalMsg" style="display: none;"><bean:write name="rateContractDtlBean" property="strMsg" /></div>
				<div class="alert alert-warning  alert-dismissible fade show" id="wrnID" style="display: none;"><bean:write name="rateContractDtlBean" property="strWarning" /></div>
			 --%>	
<div class="container-fluid">
	<div class="prescriptionTile">	
	<fieldset>		
		 <legend style="width:auto; margin-bottom: 0px;font-size: 1.5rem;font-weight: 400;margin-left:10px;color: #666;" id='nonPrintableLegend'> Request For Patient</legend>
		  		<div class="legend2" id='nonPrintableLegend2'>
					<button type="button" class="float-right btn btn-danger mt-1 btn-circle" style="border-radius:50%; padding:12px 14px;" onclick="cancelToDesk();">
						<i class="fas fa-times iround" title="Cancel"></i>
					</button>
					<button type="button" class="float-right  btn btn-secondary btn-circle" style="border-radius:50%; padding:12px 11px; background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" onclick="initPage();">
						<i class="fas fa-broom iround" title="Clear"></i>
					</button>
					<button type="button" id="savebutton" class="float-right btn btn-success mt-1 btn-circle savebtn" name="requestForLpPatient" tabindex='2'style="border-radius:50%; padding:12px;" id="submitId" onclick='return validate1();'>
						<i class="fa fa-download fa-beat iround" title="Save"></i>
					</button>
				</div>
	
				<div id="detailsdivid1" style="display: none;">
					<div class='row' style="margin-top: 10px;">
						<div class='col-sm-12' align="center">
							<bean:write name="requestForLpPatient" property="strPatientDemDtl" filter="false" />
						</div>
					</div>
			    </div>
		    <div class="container">
				 <div class="row my-1">
				 	  <!-- <div class="col-sm-2">Store Name:<font color="red">*</font></div> -->
					  <div class="col-sm-2">Store Name:</div>
					  <div class="col-sm-4"><bean:write name="requestForLpPatient" property="strStoreName" filter="false" /></div>
					  <div class="col-sm-2">Category:</div>
					  <div class="col-sm-4">
					  	<bean:write name="requestForLpPatient" property="strItemCatg" filter="false" />
				  	  </div>
				 </div>

			     <div class="row my-1">
					 <div class="col-sm-2">Indent Date:</div>
					 <div class="col-sm-4"><bean:write name="requestForLpPatient" property="strReqDate" filter="false" /></div>
					 <div class="col-sm-2">Issuing Store:</div>
					 <div class="col-sm-4"><select class='browser-default custom-select' id='strToStoreCombo' name='strToStoreCombo'><bean:write name="requestForLpPatient" property="strToStoreCombo" filter="false" /></select></div>
			     </div>

			    <div class="row my-1">
					<div class="col-sm-2">Urgent:</div>
					<div class="col-sm-4"><div style='display:block'><input type="radio" name="strIsNormal" value="1" checked="checked" />Normal &nbsp;&nbsp; <input type="radio" name="strIsNormal" value="0" />Urgent</div></div>
					<div class="col-sm-2">Indent Type:</div>
					<div class="col-sm-4"><bean:write name="requestForLpPatient" property="strReqTypeName" filter="false" /></div>
			    </div>

				<table class="TABLEWIDTH" align="center" cellspacing="1px">
					<tr>
						<td width="25%" class="LABEL" style="display: none;"><div id = "grantid" style="display:none">Grant Type:</div></td>
						<td width="25%" class="CONTROL" style="display: none;"><div id = "granttypeid" style="display:none">
						<select class='comboNormal' name='strGrantType'>
							<bean:write name="requestForLpPatient" property="strGrantTypeCombo"
								filter="false" />
						</select></div></td>
					</tr>
					<tr>
						<td width="25%" class="LABEL" style="display:none">Patient Type</td>
						<td width="25%" class="CONTROL" style="display:none">
							<html:radio  property="patType" name="requestForLpPatient" value="1" onclick="showImg(this);">IPD</html:radio>
							<html:radio  property="patType" name="requestForLpPatient" value="2" onclick="showImg(this);" >OPD/EMG</html:radio>
						</td>
					</tr>
				</table>
	
				<div class="row my-1">
					<div class="col-sm-2"><label>CR No</label></div>
					<div class="col-sm-4">
						<crNo:crNo value="${requestForLpPatient.strCrNo}" js=" onkeypress='return goRetFunc(event);'"></crNo:crNo>
					</div>
					<div class="col-sm-2 p-2">
						<span class="fas fa-search" style="cursor: pointer; cursor: hand;"
							title="Click here for Patient Search" name="searchPatient"
							id='searchPatient1' 						
							onclick="showPatientListingWindowNew('5',document.forms[0].strCrNo,'setSelectedCrNo');">
						</span>
					</div>
				</div>
			</div>
				<div class="row my-2">	
					<div class="col" align="center"> 
						<a href="#" class="btn btn-sm btn-success" name="go"
							onclick="return goFunc();" style="font-size: 1rem;"> GO&nbsp;
							<i class="fas fa-angle-double-right"></i>
						</a>
					</div>
				</div>
				<hr>
				
			<div id="All" style="display: none;">
				<!-- <div class="row">
				<input type='hidden'
							name='button1' value="0"> <i
							class="fas fa-plus-circle" id="plus1"
							style="display: block; cursor: pointer;padding: 3px;" onClick="ftn11()"></i> <i
							class="fas fa-minus-circle" id="minus1"
							style="display: none; cursor: pointer;padding: 3px;" onClick="ftn11()"></i><p class="subHeaders" style="margin-bottom: 0;">Patient Detail</p>
							
				</div> -->
				
				<!-- <table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
					<tr>
						<td width="5%" class="TITLE" align="center"></td>
						<td colspan="3" class="TITLE" align="left"><div id='' style='color: white;'><b>
						Patient Detail
						</b></div></td>
					</tr>
				</table> -->
			<div id="detailsdivid1" style="display: none;">
				<table class="TABLEWIDTH" align="center" cellspacing="1px">
					<tr>
						<bean:write name="requestForLpPatient" property="strPatientDemDtl" filter="false" />
					</tr>
				</table>
			</div>
		
			<div id="diagdivid" style="display: none;">
				<p class="subHeaders">Diagnosis Detail</p>
					<table class="table" >
						<tr>
							<bean:write name="requestForLpPatient" property="strPatientDiagDtl" filter="false" />
						</tr>
					</table>
			</div>
			<div style="display:none">
				<table class="TABLEWIDTH" align="center" cellspacing="1px"
					cellpadding="0px">
					<tr>
						<td colspan="3" class="TITLE" width="96%">
							<div id="pd" style="color: blue;">Provisional Diagnosis</div>
						</td>
						<td width="4%" class="multiLabel"><img
							src="../../hisglobal/images/plus.gif"
							style=" pointer: hand"
							onclick="newRow();"
							style="cursor: pointer;">
						</td>
					</tr>
				</table>
				
				<table class="TABLEWIDTH" align="center" cellspacing="1px"
					cellpadding="0px">
					<tr>
						<td colspan="2" class="TITLE">
						<div id='hospitalDiagnosisId' style='display: none; color: blue;'><html:radio
							name="requestForLpPatient" property="strDiagnosisType" value="1"
							onclick="changeMultiRows();">Hospital Diagnosis </html:radio>&nbsp;&nbsp;</div>
						</td>
						<td colspan="2" class="TITLE">
						<div id='icdDiagnosisId' style="display: none; color: blue;"><html:radio
							name="requestForLpPatient" property="strDiagnosisType" value="0"
							onclick="changeMultiRows();">ICD10 Diagnosis</html:radio></div>
						</td>
					</tr>
				</table>
			</div>
		<div id="id2"></div>
		</div>

		<div id="costDivReqId" style="display: none">
			<table class="TABLEWIDTH" align="center" cellpadding="1px"
				cellspacing="1px">
				<tr class="TITLE">
					<td colspan="6">
					<div id="t" align="right"><img style="cursor: pointer;height: 20px"
							id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"
							onclick='getItemSelectPopup();'></div>
					</td>
				</tr>
				<tr>
					<td width="23%" style='font-weight:350 !important ;font-size: 16px !important;'>Drug/Item Name</td>
					<td width="20%" style='font-weight:350 !important ;font-size: 16px !important;'>Rate/Unit</td>
					<td width="20%" style='font-weight:350 !important ;font-size: 16px !important;'><font size="2" color="red">*</font>Req
					Qty</td>
					<td width="20%" style='font-weight:350 !important ;font-size: 16px !important;'><font size="2" color="red">*</font>Unit
					Name</td>
					<td width="15%"style='font-weight:350 !important ;font-size: 16px !important;'>Approx Cost</td>
				</tr>
			</table>
		</div>
		
		<div id="costDivNotReqId" style="display: none">
	        <div class="row">
				<div class="col my-1" align="right">
					<button type="button" class="btn btn-success btn-sm" id='strSearchItemButtonDivId' data-toggle="modal" data-target="#tariffDtlsModal" onclick='getItemSelectPopup();'/><i class="fas fa-search"></i>&nbsp;Item Finder</button>
				</div>
			</div>
		<hr>
			 <table class="table" >
				<thead class='thead-dark' align='center'>
					<tr>
					<th width="40%" style='font-weight:350 !important ;font-size: 16px !important;'>Drug/Item Name</th>
					<!--<th width="20%" class="multiLabel"><font size="2" color="aqua">*</font>Rate/Unit</th>  -->
					<th width="20%" style='font-weight:350 !important ;font-size: 16px !important; display:none;'>Avl Qty (Receiving Store)</th>
					<th width="20%" style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</th>
					<th width="20%" style='font-weight:350 !important ;font-size: 16px !important;'><font color='red'>*</font>Unit Name</th>
					</tr>
				</thead>
			</table>
		</div>
	
		<div id="treatmentdtlsdivid" style="display: none;">
			<table class="TABLEWIDTH" align="center" cellspacing="1px">
				<tr>
					<bean:write name="requestForLpPatient" property="strPatientTreatmentDtl" filter="false" />
				</tr>
			</table>
		</div>
		<div id="id1"></div>
		
		<div id="totalCostId" style="display: none">
			<table class="TABLEWIDTH" align="center" cellpadding="1"
				cellspacing="1">
				<tr>
					<td width="85%" class="LABEL">
						<div id="ta" style="color: blue;">Total Approx Cost(Rs):</div>
					</td>
					<td width="15%" class="CONTROL" style="color: red; font-weight: bold">
						<div id='strApproxAmtDivId' align="center">0.00</div>
					<input type="hidden" name="strApproxAmt"></td>
				</tr>
			</table>
		</div>
	<div class="container">
		<div class="row" style='margin-top: 10px;'>
			<logic:equal value="13" name="requestForLpPatient" property="strTmpReqType" >
				<div class="col-sm-3">
					<label>
						<font color="red">Indent for Utility Generation?</font>
					</label>
				</div>
				<div class="col-sm-3">
					<input type="radio" name="strIsUtilityIndent" value="1"/>Yes &nbsp;&nbsp; 
					<input type="radio" name="strIsUtilityIndent" value="0" checked/>No
				</div>
			</logic:equal>
					
			<div class="col-sm-3"><label>Raised By</label></div>
			<div class="col-sm-3">
				<select name="strRecmndBy" id="strRecmndBy" onChange=""  class="browser-default custom-select">
					<bean:write name="requestForLpPatient" property="strRecmndByCombo" filter="false" />
				</select>
			</div>
		</div>
		
		<div class="row my-2">
			<div class="col-sm-3"><label>Remarks</label></div>
			<div class="col-sm-9"><textarea name="strRemarks" cols="20" class="form-control" rows="2" id="strRemarks"></textarea></div>
		</div>
	</div>
			
	<hr>
		<div class="row">
	          <div class="col" align="right"><i class="fa fa-asterisk" style="color: red;font-size: smaller;"></i>Fields Mandatory</div>				
	    </div>
	
		<div id="tariffNamePartDivId">
			<table class="TABLEWIDTH" align="center" cellpadding="0px" cellspacing="0px">
				<tr>
					<td width="15%">
						<div id="tariffFullNameDiv"></div>
					</td>
				</tr>
			</table>
		</div>

	<!-- <table class="TABLEWIDTH" align="center">
		<tr>
			<td align="center"><img style="cursor: pointer; "
				title="Click to Save Record"
				src="../../hisglobal/images/btn-sv.png"
				onClick=" return validate1();" /> <img
				style="cursor: pointer; " title="Click to Clear Page"
				src="../../hisglobal/images/btn-clr.png" name="clearImg"
				onclick="initPage();"> <img
				style="cursor: pointer; "
				title="Click to Return Main Menu"
				src="../../hisglobal/images/btn-ccl.png"
				onClick="cancelToDesk();" /></td>
		</tr>
	</table>
	 -->
	
	<input type="hidden" name="hmode" />
	
	<input type="hidden" name="strTmpHospitalCode"
		value="${requestForLpPatient.strHospitalCode}">
		
	<input type="hidden" name="strConfigCatCode"
		value="${requestForLpPatient.strConfigCatCode}">
	<input type="hidden" name="strStoreTypeId"
		value="${requestForLpPatient.strStoreTypeId}">
	<input type="hidden" name="strTmpStoreName"
		value="${requestForLpPatient.strTmpStoreName}">
	<input type="hidden" name="strTmpCrNo"
		value="${requestForLpPatient.strTmpCrNo}">

	<input type="hidden" name="strComboData"
		value="${requestForLpPatient.strComboData}">

	<input type="hidden" name="strTmpItemCatg"
		value="${requestForLpPatient.strTmpItemCatg}">
	<input type="hidden" name="strTmpReqType"
		value="${requestForLpPatient.strTmpReqType}">
	<input type="hidden" name="strGoFlg"
		value="${requestForLpPatient.strGoFlg}">
	<input type="hidden" name="strPath"
		value="${requestForLpPatient.strPath}">
	<input type="hidden" name="strCostRequired"
		value="${requestForLpPatient.strCostRequired}">
		
	<input type="hidden" name="strPatAccountNo"
		value="${requestForLpPatient.strPatAccountNo}">	
	<input type="hidden" name="strBalanceAmount"
		value="${requestForLpPatient.strBalanceAmount}">	
		
	<input type="hidden" name="strBillInt"
	value="${requestForLpPatient.strBillInt}">
	
	<input type="hidden" name="strSCMInt"
	value="${requestForLpPatient.strSCMIntegration}">

	<input type="hidden" name="strBillingHiddenValue"
	value="${requestForLpPatient.strBillingHiddenValue}">
		
	<!-- <div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			<div id="searchItemsDtlsDivId" style="display: block;"></div>
			</td>
		</tr>
	</table>
	</div> -->


<div class='modal' id='tariffDtlsModal' tabindex='-1' role='dialog' aria-labelledby='tariffDtlsModalLabel' aria-hidden='true'>
	<div class='modal-dialog modal-lg'  role='document' style="max-width: 1000px;">
		<div class='modal-content animate-bottom'>
			<div class='modal-body' id=''>
                <div id="searchItemsDtlsDivId" style="display:block;"></div>
			</div>
			<div class="modal-footer" style="padding: 0.5rem;display:flex;justify-content:center">
		        <button type="button" class="btn btn-success" onkeypress='createSelectedList();'  onClick='createSelectedList();' data-dismiss="modal" style="padding: 0.175rem 0.75rem;">Ok</button>
		        <button type='button' class='btn btn-danger' data-dismiss='modal' style="padding: 0.175rem 0.75rem;">Cancel</button>
	       </div>
		</div>
	</div>
</div>
			<cmbPers:cmbPers />
			</fieldset>
		</div>
	</div>
</html:form>

<jsp:include page="mms_multirow_lpPatientICD.jsp"></jsp:include>
<jsp:include page="mms_dropdown_lpPatientICD.jsp"></jsp:include>
<jsp:include page="requestforLPPatient_itemSearchRow.jsp"></jsp:include>

<tag:autoIndex ></tag:autoIndex>

<div class="modal fade" id="searchModel"    tabindex="-1" role="dialog" aria-labelledby="validateModalLabel" aria-hidden="true">
  <div class="modal-dialog "  role="document">
    <div class="modal-content">
    <div class="modal-header" >
	 <h4 class="modal-title" >Preview & Verify</h4>
		<button type="button" class="close" data-dismiss="modal">×</button></div>
      <div class="modal-body"  id="fetchRecordDivId" >
      </div>
      <div class="modal-footer" >
        <button  type="button" class="btn btn-success"  tabindex='1' onclick="submit()">OK & Save</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>