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

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
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
				url = "/AHIMS/mms/transactions/RequestForLPPatientCNT.cnt?hmode="+hmode+"&strSearchMode="+searchMode+"&strSearchString="+searchContent;
			}
			if(document.getElementsByName("strDiagnosisType")[0].checked && document.getElementsByName("strDiagnosisType")[0].value=="1")
		 	{	
				hmode = "HOSITALPDIAGNOSIS";
				url = "/AHIMS/mms/transactions/RequestForLPPatientCNT.cnt?hmode="+hmode+"&strSearchMode="+searchMode+"&strSearchString="+searchContent;
			}
			if(document.getElementsByName("strDiagnosisType")[1]!=undefined)
			{
				if(document.getElementsByName("strDiagnosisType")[1].checked && document.getElementsByName("strDiagnosisType")[1].value=="0")
			 	{	
					hmode = "ICDDIAGNOSIS"; 
					url = "/AHIMS/mms/transactions/RequestForLPPatientCNT.cnt?hmode="+hmode+"&strSearchMode="+searchMode+"&strSearchString="+searchContent;
				}
				if(document.getElementsByName("strDiagnosisType")[0].checked && document.getElementsByName("strDiagnosisType")[0].value=="1")
			 	{	
					hmode = "HOSITALPDIAGNOSIS"; 
					url = "/AHIMS/mms/transactions/RequestForLPPatientCNT.cnt?hmode="+hmode+"&strSearchMode="+searchMode+"&strSearchString="+searchContent;
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
			var url = "/AHIMS/ipd/transactions/RequestForLPPatientCNT.cnt?hmode="+hmode;
			ajaxFunction(url,"1");
		}else if(mode == '2'){
			var hmode = "ICDDIAGNOSIS"; 
			var url = "/AHIMS/ipd/transactions/RequestForLPPatientCNT.cnt?hmode="+hmode;
			ajaxFunction(url,"2");
		}
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
	
 	function showPatientListingWindow(mode , obj , userJsFuncName) 
 	 {
 	  	if(obj.value == "")
 	  	{
 	 				var hmode = "PATIENTLISTING"; 
 					var url = "../transactions/IpdCNT.cnt?hmode="+hmode+"&patList="+mode+"&usrFuncName="+userJsFuncName;				
 					openPopUp(createFHashAjaxQuery(url),'700','220','1','',null);
 					//var featuresList = "width=600,height=380,ALIGN=CENTER,left=300,top=300,scrollbars=yes";
 	               // myWindow = window.open(url,'popupWindow',featuresList); 
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
</script>




</head>

<body onload="return OnLoadFunction(),costReq();">
<script language="Javascript" src="../../hisglobal/js/wz_tooltip.js"></script>
<html:form action="/transactions/RequestForLPPatientCNT.cnt"
	name="requestForLpPatient"
	type="mms.transactions.controller.fb.RequestForLPPatientFB"
	method="post">

	<div class="errMsg" id="errMsg"><bean:write
		name="requestForLpPatient" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="requestForLpPatient" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="requestForLpPatient" property="strMsg" /></div>

	<center><tag:tab onlyTabIndexing="1" tabLabel="Request For Patient"
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>

		<tr>
			<td width="25%" class="LABEL">Store Name:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="requestForLpPatient" property="strStoreName" filter="false" /></td>

			<td width="25%" class="LABEL"><font color="red">*</font>Category:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="requestForLpPatient" property="strItemCatg" filter="false" />

			</td>




		</tr>
		<tr>
			<td width="25%" class="LABEL">Indent Date:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="requestForLpPatient" property="strReqDate" filter="false" /></td>

			<td width="25%" class="LABEL"><font color="red">*</font>Issuing Store:</td>
			<td width="25%" class="CONTROL"><select class='combomax' id='strToStoreCombo'
				name='strToStoreCombo'>
				<bean:write name="requestForLpPatient" property="strToStoreCombo"
					filter="false" />
			</select></td>

			
		</tr>

		<tr>

			<td class="LABEL" colspan="1"><div style='display:block'>Urgent:</div></td>
			<td class="CONTROL" colspan="1"><div style='display:block'><%--
		<b><input type='checkbox' name='strIsNormal' value="0" onClick="ftnTick()">No<input type='checkbox' name='strIsUrgent' value="0" onClick="ftnTick()">Yes</b> &nbsp;&nbsp;     
     --%><input type="radio" name="strIsNormal" value="1"
				checked="checked" />Normal &nbsp;&nbsp; <input type="radio"
				name="strIsNormal" value="0" />Urgent</div></td>

			<td width="25%" class="LABEL"><div id = "grantid" style="display:none">Grant Type:</div></td>
			<td width="25%" class="CONTROL"><div id = "granttypeid" style="display:none"><select class='comboNormal'
				name='strGrantType'>
				<bean:write name="requestForLpPatient" property="strGrantTypeCombo"
					filter="false" />
			</select></div></td>

		</tr>
		
		<tr>
			<td width="25%" class="LABEL">Indent Type:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="requestForLpPatient" property="strReqTypeName" filter="false" /></td>

			<td width="25%" class="LABEL" style="display:none">Patient Type</td>
			<td width="25%" class="CONTROL" style="display:none">
				<html:radio  property="patType" name="requestForLpPatient" value="1" onclick="showImg(this);">IPD</html:radio>
				<html:radio  property="patType" name="requestForLpPatient" value="2" onclick="showImg(this);" >OPD/EMG</html:radio>
			</td>

			
		</tr>

		<tr class="TITLE">
			<td colspan="4"></td>
		</tr>

	</table>
	<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>CR No.</td>
			<td colspan="3" class="CONTROL"><crNo:crNo
				value="${requestForLpPatient.strCrNo}"
				js=" onkeypress='return goRetFunc(event);'"></crNo:crNo><img
				style="cursor: pointer; cursor: hand;"
				src="../../hisglobal/images/viewDetails.gif"
				title="Click here for Patient Search" align="middle"
				name='searchPatient'
				id='searchPatient1'
				onclick="showPatientListingWindow('5',document.forms[0].strCrNo,'setSelectedCrNo');" />
				
				 <img src="../../hisglobal/images/Go.png" align="top"
				onclick="return goFunc();"
				style="cursor: pointer;">
				<!--<a href="#" class="button" id="go" onclick="return goFunc();"></a> -->
				
				</td>
		</tr>
	</table>

	<div id="All" style="display: none;">
	<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
		<tr>
			<td width="5%" class="TITLE" align="center"><input type='hidden'
				name='button1' value="0"> <img
				src="../../hisglobal/images/plus.gif" id="plus1"
				style="display: block; cursor: pointer" onClick="ftn11()"> <img
				src="../../hisglobal/images/minus.gif" id="minus1"
				style="display: none; cursor: pointer" onClick="ftn11()"></td>
			<td colspan="3" class="TITLE" align="left"><div id='' style='color: white;'><b>
			Patient Detail
			</b></div></td>
		</tr>
	</table>

	<div id="detailsdivid1" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<bean:write name="requestForLpPatient" property="strPatientDemDtl"
				filter="false" />
		</tr>
	</table>
	</div>
	
	<div id="diagdivid" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
	<tr class="TITLE">
			<td colspan="6"><div id='' style='color: white;'><b>Diagnosis Detail</b></div>
			</td>
		</tr>
		<tr>
			<bean:write name="requestForLpPatient" property="strPatientDiagDtl"
				filter="false" />
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
				style="cursor: pointer;"></td>
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
			<td width="23%" class="multiLabel">Drug/Item Name</td>
			<td width="20%" class="multiLabel">Rate/Unit</td>
			<td width="20%" class="multiLabel"><font size="2" color="red">*</font>Req
			Qty</td>
			<td width="20%" class="multiLabel"><font size="2" color="red">*</font>Unit
			Name</td>

			<td width="15%" class="multiLabel">Approx Cost</td>
		</tr>

	</table>
	</div>
	<div id="costDivNotReqId" style="display: none">

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="TITLE">
			<td colspan="6">
			<div id="it" align="right"><img style="cursor: pointer;height: 20px"
					id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"

					onclick='getItemSelectPopup();'></div>
			</td>
		</tr>
		<tr>
			<td width="50%" class="multiLabel">Drug/Item Name</td>
			<!--<td width="20%" class="multiLabel"><font size="2" color="aqua">*</font>Rate/Unit</td>  -->
			<td width="18%" class="multiLabel" style="display:none">Avl Qty(Receiving Store)</td>
			<td width="20%" class="multiLabel"><font size="2" color="red">*</font>Req
			Qty</td>
			<td width="30%" class="multiLabel"><font size="2" color="red">*</font>Unit
			Name</td>


		</tr>

	</table>
	</div>
	<div id="treatmentdtlsdivid" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<bean:write name="requestForLpPatient" property="strPatientTreatmentDtl"
				filter="false" />
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
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="TITLE">
			<td colspan="4"></td>
		</tr>
		<logic:equal value="13" name="requestForLpPatient" property="strTmpReqType" >
		<tr>
			<td width="50%" class="LABEL"><font color="red">Indent for Utility Generation?</font></td>
			<td width="50%" class="CONTROL"><div style='display:block'>
			<input type="radio" name="strIsUtilityIndent" value="1"/>Yes &nbsp;&nbsp; 
			<input type="radio" name="strIsUtilityIndent" value="0" checked/>No</div></td>
		</tr>
		</logic:equal>
		<tr>
			<td width="50%" class="LABEL">Raised By</td>
			<td width="50%" class="CONTROL"><select name="strRecmndBy"
				id="strRecmndBy" onChange="">
				<bean:write name="requestForLpPatient" property="strRecmndByCombo"
					filter="false" />
			</select></td>
		</tr>


		<tr>
			<td width="50%" class="LABEL">Remarks</td>
			<td class="CONTROL"><textarea name="strRemarks" cols="20"
				rows="2" id="strRemarks"></textarea></td>
		</tr>
		<tr class="FOOTER">
		<td colspan="4"><font size="2" color="red">*</font> Mandatory Fields<font size="2" color="orange">***</font>Item is not mapped</td>
		</tr>

<!-- 
		<tr class="FOOTER">
			<%--<td width='50%' align='left'><font color="Yellow" >Integration with e-Aushadhi : <logic:equal name="requestForLpPatient" property="strSCMIntegration" value="1">Yes</logic:equal><logic:notEqual name="requestForLpPatient" property="strSCMIntegration" value="1">No</logic:notEqual></font></td> --%>
			<td width='100%'><font size="2" color="red">*</font> Mandatory Fields<font size="2" color="aqua">*</font>Actual Rate May Vary<font size="2" color="orange">***</font>Item is not mapped</td>
		</tr>
	</table>
 -->
<div id="tariffNamePartDivId">
	<table class="TABLEWIDTH" align="center" cellpadding="0px" cellspacing="0px">
		<tr>
			<td width="15%" class="CONTROL" style="color: blue; font-weight: bold">
			<div id="tariffFullNameDiv"></div>
			</td>
		</tr>
	</table>
	</div>

	
	 <br>
	<div align="center" id="saveId">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="initPage();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelToDesk();"><span class="cancel">Cancel</span></a>
					</div> 

	<input type="hidden" name="hmode" />
	
	<input type="hidden" name="strTmpHospitalCode"     value="${requestForLpPatient.strHospitalCode}">
	<input type="hidden" name="strConfigCatCode"	   value="${requestForLpPatient.strConfigCatCode}">
	<input type="hidden" name="strStoreTypeId"		   value="${requestForLpPatient.strStoreTypeId}">
	<input type="hidden" name="strTmpStoreName" 	   value="${requestForLpPatient.strTmpStoreName}">
	<input type="hidden" name="strTmpCrNo"   		   value="${requestForLpPatient.strTmpCrNo}">
	<input type="hidden" name="strComboData"		   value="${requestForLpPatient.strComboData}">
	<input type="hidden" name="strTmpItemCatg"		   value="${requestForLpPatient.strTmpItemCatg}">
	<input type="hidden" name="strIndentTypeId"		   value="${requestForLpPatient.strTmpReqType}">
	<input type="hidden" name="strGoFlg"  		       value="${requestForLpPatient.strGoFlg}">
	<input type="hidden" name="strPath"   		       value="${requestForLpPatient.strPath}">
	<input type="hidden" name="strCostRequired"  	   value="${requestForLpPatient.strCostRequired}">		
	<input type="hidden" name="strPatAccountNo"  	   value="${requestForLpPatient.strPatAccountNo}">	
	<input type="hidden" name="strBalanceAmount"	   value="${requestForLpPatient.strBalanceAmount}">		
	<input type="hidden" name="strBillInt"   	       value="${requestForLpPatient.strBillInt}">
	<input type="hidden" name="strSCMInt"		       value="${requestForLpPatient.strSCMIntegration}">
    <input type="hidden" name="strBillingHiddenValue"  value="${requestForLpPatient.strBillingHiddenValue}">
    <input type="hidden" name="strTmpReqType"	       value="${requestForLpPatient.strTmpReqType}">
		
	<div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			<div id="searchItemsDtlsDivId" style="display: block;"></div>
			</td>
		</tr>
	</table>
	</div>

	<cmbPers:cmbPers />
</html:form>

<jsp:include page="mms_multirow_lpPatientICD.jsp"></jsp:include>
<jsp:include page="mms_dropdown_lpPatientICD.jsp"></jsp:include>
<jsp:include page="requestforLPPatient_OLD_itemSearchRow.jsp"></jsp:include>

<tag:autoIndex ></tag:autoIndex>


</body>
</html>