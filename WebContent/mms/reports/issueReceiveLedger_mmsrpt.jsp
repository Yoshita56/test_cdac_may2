<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Issue Receive Ledger</title>

<script language="JavaScript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script language="Javascript" src="../../hisglobal/js/autocompleteItemSearch.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">


<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/dwh.css" rel="stylesheet" type="text/css"> 
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
 

<!-- BS Library  -->
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">

<!-- JS Library  -->
<style type="text/css">

body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 14px;
	line-height: 1.42857143;
	color: rgba(75, 75, 75, 0.7);
	font-weight: 501;
}

.table th, .table td {
	padding: 0.05rem;
}

.form-control {
	color: rgba(75, 75, 75, 0.7);
}

.table {
	width: 100%;
	margin-bottom: 1rem;
	color: rgba(75, 75, 75, 0.7);
}

.prescriptionTile {
	margin: 0.5% 0;
	border-bottom: 1px solid #d7d7d7;
	padding-bottom: 10px;
	padding: 1% 2% 0.5% 2%;
	background-color: #fff;
	transition: 0.5s;
	box-shadow: 0 0.5px 10px 2px #b0acac;
	border-radius: .25rem;
	color: rgba(75, 75, 75, 0.7);
}

.subHeaders {
	font-weight: 500 !important;
	font-family: "Helvetica Neue", "Helvetica";
	font-size: 19px !important;
	padding-bottom: 0px !important;
	color: rgba(75, 75, 75, 0.7);
}

.row {
	padding-bottom: 5px;
}

.legend2 {
	position: absolute;
	top: -2.5em;
	right: 44px;
	line-height: 1.2em;
}

.cancelbtn {
	padding: .175rem .35rem;
	line-height: 0.8;
	background-color: #d9534f;
}

.btn-circle {
	width: 37px;
	height: 34px;
	text-align: center;
	padding: 6px 0;
	font-size: 12px;
	line-height: 1.428571429;
	border-radius: 17px;
	color: white;
	float: right;
}

.iround {
	color: white;
	font-size: 16px;
}

.btn-outline-success {
	color: #28a745;
	border-color: #28a745;
	background-color: #28a745;
}
</style>

<script type="text/javascript">


  
$(function() {	
	loadAutocompleteItems();	
});

function loadAutocompleteItems()
{
	$('#strSearchDrug').val("");
	displaySelectedDrug("strDrugName");
	
	var itemList = [];			
	$('#strDrugName option').each(function() {
	    itemList.push({ "value" :this.textContent , "data" : this.value });
	});

	$('#strSearchDrug').autocomplete({
	   lookup: itemList,
	   minChars:3,
	   onSelect: function (suggestion) {        
	     getDrugNameSelected(suggestion.data, "strDrugName");
	     getDrugNameSelectedInLeftBox(suggestion.data, "strLeftItemIds");	     
	   }	    
	 });
	 
	 $('#strSearchDrug').click(function(){	 
	 	$(this).val("");
	 });		
}

function getDrugNameSelectedInLeftBox(itemId, selectId)
{	
	var flag = 0;
	var sel = document.getElementById(selectId);
	
	for (i=0; i<sel.options.length; i++) {				
		if ( sel.options[i].value == itemId) 
		{
			sel.selectedIndex = i;			
			flag = 1;
			break;
		}				
	}	
	if(flag == 0)
	{
		sel.selectedIndex=0;
		document.forms[0].strSearchDrug.value = "";
	}	 
	else
	{
		showSelection(sel);
	}   
	 
}
 
function validate1(){

var len = parseInt(document.forms[0].strRightItemIds.length);
	if(len>0)
	{
		var strTmpItemBrandId = "0"; 
		for(var i=0; i< len; i++)
		{
			if(i==0)
			{
				//alert(document.forms[0].strRightItemIds[i].value);
				strTmpItemBrandId = document.forms[0].strRightItemIds[i].value;
			}
			else	
			{
				strTmpItemBrandId	=	strTmpItemBrandId +","+ document.forms[0].strRightItemIds[i].value;
			}		
		}		
		
		
		document.forms[0].strItemBrandId.value	=	strTmpItemBrandId;
		//alert(document.forms[0].strItemBrandId.value);
	}


	var hisValidator = new HISValidator("issueReceiveLedgerRptBean");
	
	//hisValidator.addValidation("strDistrictStoreId", "dontselect=-1"," Please Select Store Name ");
//	hisValidator.addValidation("strStoreId", "dontselect=0","Please Select Sub-Store Name");
//	hisValidator.addValidation("strItemCatNo", "dontselect=0","Please Select Item Category");
//	hisValidator.addValidation("strItemType", "dontselect=0","Please Select Drug Type ");
	/*if(document.forms[0].strCurrentStock.checked == false){
			hisValidator.addValidation("strDate", "date","To Date is a mandatory field");
			hisValidator.addValidation("strDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select Date Less Than or Equal To Current Date");
	}	*/		
	
	//var retVal = hisValidator.validate();strIsGroupWise
	/*if((document.forms[0].strIsGroupWise.value == 1 || document.forms[0].strIsItemWise.value == 1 ) && document.forms[0].strBatchNo.value == 1 )
	{
		alert("please select one");
		return false;
	}*/
	var retVal=hisValidator.validate();
	hisValidator.clearAllValidations();
	
		if(retVal)
		{				
		      document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	          document.forms[0].strGroupName.value = document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].text;
	          document.forms[0].strDrugTypeName.value = document.forms[0].strItemType[document.forms[0].strItemType.selectedIndex].text;
	          document.forms[0].strItemCatgName.value = document.forms[0].strItemCatNo[document.forms[0].strItemCatNo.selectedIndex].text
			  document.forms[0].hmode.value = "SHOWRPT";
			  document.forms[0].submit();
				}else{
			return false;
		}
	}
	

	
function getItemCatCmb(){ 
		if(document.forms[0].strStoreId.value!=0)
		{
			
			var url ="IssueReceiveLedgerRptCNT.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
	 		ajaxFunction(url,"1");
	 		
	 	}
	 	else
	 	{
			document.forms[0].strItemCatNo.value="0";
			document.forms[0].strGroupId.value="0";
		   	document.forms[0].strItemType.value='0';
		    document.forms[0].strStatusId.value='0';
			//getDrugName();
			
		}
			document.forms[0].strItemCatNo.value="0";
			document.forms[0].strGroupId.value="0";
		    document.forms[0].strProgId.value='0';
		    document.forms[0].strItemType.value='0';
		    document.forms[0].strStatusId.value='0';
		    shiftAllToLeft('strLeftItemIds','strRightItemIds',1);			
}	
function getGroupCmb(){ 

	if(document.forms[0].strItemCatNo.value!=0)
	{
		var url ="IssueReceiveLedgerRptCNT.cnt?hmode=GROUPCMB&itemcat="+document.forms[0].strItemCatNo.value;
 		ajaxFunction(url,"6");
 	}
 	else
 	{
		document.forms[0].strGroupId.value="0";
	}
}	

function getDrugName1()
{
		if(document.forms[0].strDistrictStoreId)
		{
			var districtPresent=document.forms[0].strDistrictStoreId.value;
		}
		else{
		var districtPresent='0^0';
		}
		/* var url ="StockOnHandRptCNT_NEW_NEW.cnt?hmode=DRUGNAME&storeId="+document.forms[0].strStoreId.value+ */
				
				var url ="IssueReceiveLedgerRptCNT.cnt?hmode=DRUGNAME&storeId="+document.forms[0].strStoreId.value+
		         "&itemcat=0"+
		         "&groupId="+document.forms[0].strGroupId.value+
		         "&itemType="+document.forms[0].strItemType.value+
	   			 "&statusId="+document.forms[0].strStatusId.value+
	   			 "&districtStoreId="+districtPresent;	    
	    
	   			  ajaxFunction(url,"7");
}


function getDrugName()
{
		if(document.forms[0].strDistrictStoreId)
		{
			var districtPresent=document.forms[0].strDistrictStoreId.value;
		}
		else{
		var districtPresent='0^0';
		}
		var url ="IssueReceiveLedgerRptCNT.cnt?hmode=DRUGNAME&storeId="+document.forms[0].strStoreId.value+
		         "&itemcat="+document.forms[0].strItemCatNo.value+
		         "&groupId="+document.forms[0].strGroupId.value+
		         "&itemType="+document.forms[0].strItemType.value+
	   			 "&statusId="+document.forms[0].strStatusId.value+
	   			 "&districtStoreId="+districtPresent;	    
	    
	   			  ajaxFunction(url,"7");
	   			 
	   			  shiftAllToLeft('strLeftItemIds','strRightItemIds',1);
}
function getDrugName3()
{
		if(document.forms[0].strDistrictStoreId)
		{
			var districtPresent=document.forms[0].strDistrictStoreId.value;
		}
		else{
		var districtPresent='0^0';
		}
	    var url ="IssueReceiveLedgerRptCNT.cnt?hmode=DRUGNAME1&storeId="+document.forms[0].strStoreId.value+
		         "&itemcat="+document.forms[0].strItemCatNo.value+
		         "&groupId="+document.forms[0].strGroupId.value+
		         "&itemType="+document.forms[0].strItemType.value+
	   			 "&statusId="+document.forms[0].strStatusId.value+
	   			 "&districtStoreId="+districtPresent;	    
	    
	   			  ajaxFunction(url,"9");
	   			  shiftAllToLeft('strLeftItemIds','strRightItemIds',1);
}
function getDrugName4()
{
		if(document.forms[0].strDistrictStoreId)
		{
			var districtPresent=document.forms[0].strDistrictStoreId.value;
		}
		else{
		var districtPresent='0^0';
		}
	    var url ="IssueReceiveLedgerRptCNT.cnt?hmode=DRUGNAME1&storeId="+document.forms[0].strStoreId.value+
		         "&itemcat="+document.forms[0].strItemCatNo.value+
		         "&groupId="+document.forms[0].strGroupId.value+
		         "&itemType="+document.forms[0].strItemType.value+
	   			 "&statusId="+document.forms[0].strStatusId.value+
	   			 "&districtStoreId="+districtPresent;	    
	    
	   			  ajaxFunction(url,"10");
	   			  shiftAllToLeft('strLeftItemIds','strRightItemIds',1);
}
function getStoreTypeCmb(){
   
     	var strDistrictStoreId = document.forms[0].strDistrictStoreId.value;
		//alert("in");
    	var url ="IssueReceiveLedgerRptCNT.cnt?hmode=STORETYPECMB&strDistrictStoreId="+strDistrictStoreId;
    	ajaxFunction(url,"4");
    	
    	
    	document.forms[0].strStoreTypeId.value='0';
    	document.forms[0].strStoreId.value='0';
    document.forms[0].strItemCatNo.value='0';
    document.forms[0].strProgId.value='0';
    document.forms[0].strGroupId.value='0';
    document.forms[0].strItemType.value='0';
    document.forms[0].strStatusId.value='0';
    //if(document.forms[0].strItemCatNo.value=='0')
    getDrugName1();
    shiftAllToLeft('strLeftItemIds','strRightItemIds',1);
    

//	document.getElementsByName("strWhetherConsolidatedDataForAllInstitutesOfDistrictDrugWarehouseCheckBox")[0].checked=false;

}


function getSubStoreCmb(){


 if(document.forms[0].strCircleId)
    var strCircleId = document.forms[0].strCircleId.value;
 else   
    var strCircleId = '0';
    
    if(document.forms[0].strDistrictId)
    {
    	 var strDistrictId = document.forms[0].strDistrictId.value;
    	
    }
    else
    {
    	var strDistrictId = '0';
    	
    }
    
    
     var strDistrictStoreId = document.forms[0].strDistrictStoreId.value;    
	 	 var strStoreTypeId = document.forms[0].strStoreTypeId.value; 		
     
var url ="IssueReceiveLedgerRptCNT.cnt?hmode=SUBSTORECOMBO&strDistrictId="+strDistrictId+
			"&strCircleId="+strCircleId+"&strDistrictStoreId="+strDistrictStoreId+
			"&strStoreTypeId="+strStoreTypeId;
			
			

    ajaxFunction(url,"5");
    
    document.forms[0].strItemCatNo.value='0';
    document.forms[0].strProgId.value='0';
    document.forms[0].strGroupId.value='0';
    document.forms[0].strItemType.value='0';
    document.forms[0].strStatusId.value='0';
    //if(document.forms[0].strItemCatNo.value=='0')
    //getDrugName1();
   
    shiftAllToLeft('strLeftItemIds','strRightItemIds',1);
    
}
  

function getAjaxResponse(res,mode){
	
	
	if(mode=="1"){ 
	
			var objVal= document.getElementById("itemCatDivId");
			objVal.innerHTML = "<select name ='strItemCatNo' class='browser-default custom-select' onchange='getGroupCmb();'>"+res+"</select>";
			getDrugName();		
	}	
	
	if(mode=="2"){			     
			
			var objVal= document.getElementById("districtCmbDivId");
			objVal.innerHTML = "<select name ='strDistrictId' class='browser-default custom-select' onchange='getStoreCmb();'>"+res+"</select>";	
	}

	if(mode=="4")
	{ 	    
	
			var objVal= document.getElementById("storeTypeDivId");	
			
			objVal.innerHTML = "<select name ='strStoreTypeId' class='browser-default custom-select' onchange='getSubStoreCmb();'>"+res+"</select>";	
			//getProgName();
	
	}	
		
	if(mode=="5"){
			
			var objVal= document.getElementById("strSubStoreDivId");			
			objVal.innerHTML = "<select name ='strStoreId' class='browser-default custom-select' onchange='getDrugName1();'>"+res+"</select>";	
	}	
	
	if(mode=="6")
	{ 
		 var objVal= document.getElementById("groupDivId");
		 var temp= "<select name ='strGroupId' class='browser-default custom-select' onchange='getDrugName3();'>"+res.split("^")[0]+"</select><input type='checkbox' name='strIsGroupWise' value='1' checked='false'>Batch Wise Report";

		 var objVal1= document.getElementById("itemDivId");
		 var temp1= "<select name ='strItemType' class='browser-default custom-select' onchange=' '>"+res.split("^")[1]+"</select><input type='hidden' name='strIsItemWise' value='1' >";

		objVal.innerHTML = temp;
		objVal1.innerHTML = temp1;
		getDrugName();
	}
	
	if(mode=="7")
	{ 
			var objVal= document.getElementById("LeftItemIds");
			objVal.innerHTML = "<select id='strLeftItemIds' name='strLeftItemIds' size='6' class='form-control' multiple style='max-height:120px' onChange='showSelection(this);' >"+res.split("^")[0] +"</select>";
		
			var objVal1= document.getElementById("drugNameDivId");
			objVal1.innerHTML = "<select id='strDrugName' name='strDrugName' class='browser-default custom-select'  >"+res.split("^")[0]+"</select>";
			loadAutocompleteItems();
			
			document.forms[0].strSearchDrug.value='';
			
					
	}
	
	if(mode=="8"){ 
			
			var objVal1= document.getElementById("progNameDivId");
			objVal1.innerHTML = "<select id='strProgId' name='strProgId' class='browser-default custom-select'  >"+res+"</select>";
	getDrugName1();
	}
	if(mode=="9")
	{ 
			var objVal= document.getElementById("LeftItemIds");
			objVal.innerHTML = "<select id='strLeftItemIds' name='strLeftItemIds' size='6' class='form-control' multiple style='max-height:120px' onChange='showSelection(this);' >"+res.split("^")[0] +"</select>";
			
			
			var objVal1= document.getElementById("drugNameDivId");
			objVal1.innerHTML = "<select id='strDrugName' name='strDrugName' class='browser-default custom-select'  >"+res.split("^")[0]+"</select>";
			loadAutocompleteItems();
			
			document.forms[0].strSearchDrug.value='';
			
			//document.getElementById("txtFromLeftMutltiSelectCombo").innerHTML	=	'';
			var objVal3= document.getElementById("itemDivId");
			 var temp1= "<select name ='strItemType' class='browser-default custom-select' onchange='getDrugName4();'>"+res.split("^")[2]+"</select><input type='hidden' name='strIsItemWise' value='1' >";
			 objVal3.innerHTML = temp1;
					
	}
	if(mode=="10")
	{ 
			var objVal= document.getElementById("LeftItemIds");
			objVal.innerHTML = "<select id='strLeftItemIds' name='strLeftItemIds' size='6' class='form-control' multiple style='max-height:120px' onChange='showSelection(this);' >"+res.split("^")[0] +"</select>";
			
			
			var objVal1= document.getElementById("drugNameDivId");
			objVal1.innerHTML = "<select id='strDrugName' name='strDrugName' class='browser-default custom-select'  >"+res.split("^")[0]+"</select>";
			loadAutocompleteItems();
			
			document.forms[0].strSearchDrug.value='';
			
		//	document.getElementById("txtFromLeftMutltiSelectCombo").innerHTML	=	'';
		//	document.getElementById("txtFromLeftMutltiSelectCombo").style.display='none';
		
					
	}
					
}	

	
function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}

function onBodyDisplay(){
    var userLevel = document.forms[0].strUserLevel.value
    //alert(userLevel);
      
      if(document.getElementsByName("strIsDdwFlag")[0].value=='1')
      {
      	document.getElementById("storeTypeTrId").style.display = '';
      	document.getElementById("drugWarehouseDivId").style.display = '';
      }
      
      
    if(userLevel == "1" || userLevel == "2" || userLevel == "3"){   
        document.getElementById("circleTrId").style.display = "table-row";     
    	document.getElementById("districtTrId").style.display = "table-row";
    	document.getElementById("storeTypeTrId").style.display = "table-row";
    }
    
      

    if(document.forms[0].strCurrentStock1)
    {
    	if(document.forms[0].strCurrentStock1.value == "1"){
			document.forms[0].strCurrentStock1.checked = true;
			document.forms[0].strCurrentStock.value = 1;
		}
    
    }
    		
	document.forms[0].strStoreId.value = "0";
	document.forms[0].strItemCatNo.value="0";
	document.forms[0].strGroupId.value="0";
	document.getElementsByName("strStoreTypeId")[0].value='1';
}

function checkWhetherConsolidatedStockVisibility(){
    var userLevel = document.forms[0].strUserLevel.value
    var selectedCircle = document.forms[0].strCircleId[document.forms[0].strCircleId.selectedIndex].text
    var selectedDistrict = document.forms[0].strDistrictId[document.forms[0].strDistrictId.selectedIndex].text
    var selectedStoreType = document.forms[0].strStoreTypeId[document.forms[0].strStoreTypeId.selectedIndex].value
      
    if(userLevel == "1" || userLevel == "2" || userLevel == "3"){
        if(selectedCircle == "All" && selectedDistrict == "All" && selectedStoreType == "13"){
           document.getElementById("whetherConsolidatedStockTrId").style.display = "table-row"; 
        }
      
    }
}

function onDateDisplay(){

	if(document.getElementsByName("strCurrentStock1")[0].checked == true){
	
	document.getElementById("dateDivId").style.display = "none";
		document.forms[0].strCurrentStock.value = 1;
		 
		
	}else{
	document.getElementById("dateDivId").style.display = "block";
		document.forms[0].strCurrentStock.value = 0;
		
	 
	}
		
}

function onClickClear(){

	document.forms[0].reset();	
	document.forms[0].strDistrictStoreId.value = "0";
	document.forms[0].strStoreTypeId.value = "0";
	document.forms[0].strStoreId.value = "0";
	document.forms[0].strItemCatNo.value = "0";	

	document.forms[0].strGroupId.value = "0";	
	document.forms[0].strItemType.value = "0";		
	document.forms[0].strStatusId.value = "0";	
	document.forms[0].strDrugName.value = "0";	
	document.forms[0].strBatchNo.checked = false;

	document.getElementsByName("strStoreTypeId")[0].value='1';
	shiftAllToLeft('strLeftItemIds','strRightItemIds',1);
	//document.getElementsByName("strRightItemIds").length = 0;

	if(document.forms[0].strCurrentStock1)
	{
		if(document.forms[0].strCurrentStock1.checked == false){
			document.getElementById("dateDivId").style.display = "none";
			document.forms[0].strCurrentStock1.checked = true;
			document.forms[0].strCurrentStock.checked = 1;
			document.forms[0].strDate.value = document.forms[0].strCurrentDate.value;
		}
	}
	displaySelectedDrug();
	getDrugName();
	
}

function onClickBatch(){

		if(document.forms[0].strBatchNo.checked){
		
			document.forms[0].strBatchNo.value = "1";
		
		}else if(document.forms[0].strBatchNo.checked == false){
		
			document.forms[0].strBatchNo.value = "0";		
		}
}


function LeftListTransfer()
{
	var ob1=document.forms[0].strLeftItemIds.value;
	var ob=document.getElementById("LeftItemIds");
	shiftToRight("strLeftItemIds","strRightItemIds",1);
}

function showSelection(obj)
{
	 var selectedItems ;
	 var count =0;
	 for (var i = 0; i < obj.options.length; i++)
	 {
	 	if (obj.options[ i ].selected) 
	 	{	 		
 				selectedItems	= obj.options[ i ].text; 			
	 	}
	 } 
	 
	 
	// document.getElementById("txtFromLeftMutltiSelectCombo").style.display='';
	// document.getElementById("txtFromLeftMutltiSelectCombo").innerHTML = selectedItems;  
}
function getCombo(obj)
{
   var reportType = obj.value;
   
   if(reportType=="1")
   {
	   document.getElementById("dateRowId").style.display="flex";
	   document.getElementById("monthRowId").style.display="none";
	   document.getElementById("dateDivId").style.display="block";
	   document.getElementById("monthCmbDivId").style.display="none";
	   document.getElementById("monthCmbDivId1").style.display="none";
	   document.getElementById("monthCmbDivId2").style.display="none";
   }
   else
   {
	   document.getElementById("monthRowId").style.display="flex";
	   document.getElementById("dateRowId").style.display="none";
	   document.getElementById("dateDivId").style.display="none";
	   document.getElementById("monthCmbDivId").style.display="block";
	   document.getElementById("monthCmbDivId1").style.display="block";
	   document.getElementById("monthCmbDivId2").style.display="block";
   }
	
}
</script>
</head>
<body class="background" onload="getDrugName();">
<div id="mask"></div>
<div id="dvLoading"></div>

<html:form action="/reports/IssueReceiveLedgerRptCNT" method="post" styleClass="formbg">
		
		<div class="errMsg" id="errMsg" style="font-size:18px;"><bean:write name="issueReceiveLedgerRptBean" property="strErrMsg" /></div>
		<div class="normalMsg" id="normalMsg" style="font-size:18px;"><bean:write name="issueReceiveLedgerRptBean" property="strNormalMsg" /></div>
		<div class="warningMsg" id="warningMsg" style="font-size:18px;"><bean:write name="issueReceiveLedgerRptBean" property="strWarningMsg" /></div>
	<br>
		<div class="container" style="max-width: 1290px">
				<div class="prescriptionTile col-sm-12" align="center">
					
					<div class="row">
						<div class="col-sm-6" style="text-align: initial;">
							<p class="subHeaders">
								<i class="fas fa-file-alt iround" style="font-size: 20px; color: #28a745" title="Cancel"></i>
								&nbsp; Issue Receive Ledger Report
							</p>
						</div>
						
						<div class="col-sm-6">
							<div class="legend2" id='nonPrintableLegend2'>
								<button type="button"
									class="float-right btn btn-danger mt-1 btn-circle cancelbtn"
									onclick="window.parent.closeTab();">
									<i class="fas fa-times iround" title="Cancel"></i>
								</button>
								
								<button type="button" class=" btn btn-secondary btn-circle"
									onclick="onClickClear();"
									style="background: royalblue;margin-top: 0.25rem !important;">
									<i class="fas fa-broom iround" title="Clear"></i>
								</button>

								<button type="button" id="saveid"
									class="float-right btn btn-success mt-1 btn-circle savebtn"
									tabindex='2' onclick='return validate1();'>
									<i class="fas fa-download iround" title="Save"></i>
								</button>
						   </div>
						</div>
					</div>

					<div class="row">
						<div class="col-sm-3">
							<label>Store Name<font color="red">*</font></label>
						</div>
						<div class="col-sm-3">
							<div id="strSubStoreDivId">
								<select name="strStoreId" class="custom-select"
									onchange="getItemCatCmb();">
									<bean:write name="issueReceiveLedgerRptBean" property="strStoreValues" filter="false" />
								</select>
							</div>
						</div>
						<div class="col-sm-3" >
							<label>Item Category<font color="red">*</font></label>
						</div>
						<div class="col-sm-3" align="left" >
							<div id="itemCatDivId">
								<select name="strItemCatNo" class="custom-select"
									onchange="getDrugName();">
									<bean:write name="issueReceiveLedgerRptBean" property="strItemCatgCombo"  filter="false" /> 
									<!--  
									<option value="10">Drug</option>
									<option value="0">Other</option>
									-->
								</select>
							</div>
						</div>
					</div>
					
					<div class="row" hidden>
						<div class="col-sm-3">
							<label>Group Name<font color="red">*</font></label>
						</div>
						<div class="col-sm-3">
							<div id="groupDivId">
								<select name="strGroupId" class="custom-select" onchange=' '>
									<bean:write name="issueReceiveLedgerRptBean" property="strGroupCombo" filter="false" />
									<option value="0">All</option>
								</select>
							</div>
						</div>
						
						<div class="col-sm-3" >
							<label>Drug Type<font color="red">*</font></label>
						</div>
						<div class="col-sm-3" align="left" >
							<div id="itemDivId">
								<select name="strItemType" class="custom-select" onchange=" ">
									<bean:write name="issueReceiveLedgerRptBean" property="strItemTypeValues" filter="false" />
									<option value="0">All</option>
								</select>
								<input type='hidden' name='strIsItemWise' value='1' >
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-sm-3">
							<label>Search Item Name</label>
						</div>
						
						<div class="col-sm-3">
							<div id="drugNameDivId" style="display: none;">
								<select id="strDrugName" name="strDrugName" class="browser-default custom-select">
									<bean:write name="issueReceiveLedgerRptBean" property="strDrugCombo" filter="false" />
								</select>
							</div>
							<div id="DrugNameId" style="display: none;"></div>
							<input type="text" id="strSearchDrug" class="form-control" name="strSearchDrug" size="80%" />
						</div>
						
						<div class="col-sm-3 "><label>Type of Report<font color="red">*</font></label></div>
						<div class="col-sm-3" >
							<select name="strReportTypeId"  class="custom-select" onChange="getCombo(this);">
							    <option Value="1">Date Wise</option>
							    <option Value="2">Month Wise</option>
						    </select>		
						</div>
						
					</div>
					<div class="row" id="dateRowId">
						<div class="col-sm-3 "><label>Date<font color="red">*</font></label></div>
						<div class="col-sm-3" >
							<div id="dateDivId">				
								<input name="strSelectedDate" id="strSelectedDate" class="form-control datepicker" value="${IndentWiseIssueRPTbean.strCurrentDate}" />		
								<%-- <input type="date" class="form-control" name="strSelectedDate" id='datepicker' value="${issueReceiveLedgerRptBean.strCurrentDate}"> --%>
							</div>
						</div>
						<div class="col-sm-6 "></div>
					</div>
					<div class="row" id="monthRowId" style="display:none;">	
				
						<div class="col-sm-3 "><label>Month<font color="red">*</font></label></div>
						  <div class="col-sm-3" >	
							 <div id="monthCmbDivId" style="display:none;">
													
								<select name="strReportMonthId"  id="strReportMonthId" class="custom-select" onChange="">
								    <option Value="1">JAN</option>
								    <option Value="2">FEB</option>
								    <option Value="3">MAR</option>
								    <option Value="4">APR</option>
								    <option Value="5">MAY</option>
								    <option Value="6">JUN</option>
								    <option Value="7">JUL</option>
								    <option Value="8">AUG</option>
								    <option Value="9">SEP</option>
								    <option Value="10">OCT</option>
								    <option Value="11">NOV</option>
								    <option Value="12">DEC</option>
								    
							    </select>		
							
						      </div>
						</div>	
						
						 <div class="col-sm-3 "><div id="monthCmbDivId1" style="display:none;">Year</div></div>
						 <div class="col-sm-3">
									<div id="monthCmbDivId2" style="display:none;">
										<select name="strFYId" class="browser-default custom-select"  onchange="">
											<%-- <bean:write name="issueReceiveLedgerRptBean" property="strFYCombo" filter="false" /> --%>
											<option Value="2024">2024</option>
										    <option Value="2025">2025</option>
										    <option Value="2026">2026</option>
										</select>
									</div>
						</div>
									
					</div>
					<div class="line">
						<table class="NEWTABLEWIDTH" cellspacing="1px" cellpadding="1px" align="center">
							<tbody>
								<tr>
									<td width="95%">Item name</td>
								</tr>
							</tbody>
						</table>
					</div>
					
					<div class="row">
						<div class="col-sm-5">
							<div id="LeftItemIds" align="right">
								<select id="strLeftItemIds" name="strLeftItemIds"
									class="form-control" size="6" multiple=""
									style="max-height: 120px" onChange='showSelection(this);'>
									<bean:write name="issueReceiveLedgerRptBean" property="strLeftItemList" filter="false" />
								</select>
							</div>
						</div>
						
						<div class="col-sm-2">
							<br>
								<div>
									<img src="../../hisglobal/images/forward3.gif" width="30" height="21" onclick="LeftListTransfer();">
								</div>
							<br>
							<div>
								<img src="../../hisglobal/images/back3.gif" width="30" height="21" onclick="shiftToLeft('strLeftItemIds','strRightItemIds',1);"/>
							</div>
						</div>
						
						<div class="col-sm-5">
							<div id="RightItemIds" align="left">
								<select name="strRightItemIds" size="6" multiple=""
									class="form-control" style="max-height: 120px">
									<bean:write name="issueReceiveLedgerRptBean" property="strRightItemList" filter="false" />
								</select>
							</div>
						</div>
					</div>

					<div id="dateDivId" style="display: none;">
						<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
							<tr>
								<td class="LABEL" width="50%" colspan="1"><font color="red">*</font>Date</td>
								<td class="CONTROL" width="50%" colspan="2"><dateTag:date name="strDate" value="${issueReceiveLedgerRptBean.strCurrentDate}" /></td>
							</tr>
						</table>
					</div>

					<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px"  style="display: none;">
						<tr>
							<td width="50%" colspan="2" class="LABEL">Footer Required</td>
							<td width="50%" colspan="1" class="CONTROL">
								<html:checkbox property="strIsFooter" name="issueReceiveLedgerRptBean" value="1"></html:checkbox>
							</td>
						</tr>
					</table>
<hr>
					<div class="row">
						<div class="col-sm-12" align="right" >
							<font color='red'>*</font>Fields Mandatory 
						</div>
					</div>
	
					<input type="hidden" name="hmode" />
					<!--change-->
					<input type="hidden" name="strStatusId" value="10"/>
					<!--/change-->
					
					<input type="hidden" name="strCurrentDate" value="${issueReceiveLedgerRptBean.strCurrentDate}" />
					<input type="hidden" name="strCurrentStock" value="${issueReceiveLedgerRptBean.strCurrentStock}" />
					<input type="hidden" name="strSeatId" value="${issueReceiveLedgerRptBean.strSeatId}" />
					<input type="hidden" name="strStoreName" value=""/>
					<input type="hidden" name="strGroupName" value=""/>
					<input type="hidden" name="strDrugTypeName"  value=""/>
					<input type="hidden" name="strItemCatgName"  value=""/>
					<input type="hidden" name="strIsDdwFlag" value="${issueReceiveLedgerRptBean.strIsDdwFlag}" />
					<input type="hidden" name="strItemBrandId" value="${issueReceiveLedgerRptBean.strItemBrandId}" />
					</div>
				</div>
</html:form>
<script type="text/javascript">
		var today = new Date();
	    //document.getElementById("datepicker").value = today.getFullYear() + '-' + ('0' + (today.getMonth() + 1)).slice(-2) + '-' + ('0' + today.getDate()).slice(-2);
		
	    //console.log("datepicker -- "+document.getElementById("datepicker").value);
		 $('#strSelectedDate').datepicker({
			modal : true,
			header : true,
			footer : true,
			format : 'dd-mmm-yyyy'
		});
		var today = new Date();
		var arr = [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug",
				"Sep", "Oct", "Nov", "Dec" ];
		var mmm = arr[today.getMonth()];
		var hrs = today.getHours();
		var dd = today.getDate() + "-" + mmm + "-" + today.getFullYear();
		$('#strSelectedDate').val(dd); 
		
		
	</script>

<tag:autoIndex></tag:autoIndex>

</body>
</html>
