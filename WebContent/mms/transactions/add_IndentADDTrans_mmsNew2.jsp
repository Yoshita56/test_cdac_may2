<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<!-- 
/**
 * @author Amit Kumar
 * Date of Creation : 31/3/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
 -->
<html>
<head>
<meta charset=UTF-8">
<title>Indent For Issue</title>
<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">

<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet">
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script> 

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
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
<script language="JavaScript" src="../js/mms.js"></script>

<script language="JavaScript" src="../js/IndentTransADD.js"></script>
<style type="text/css">
.newhr{
    border-top: 3px solid rgb(6, 138, 255);
    margin-right: -16px;
margin-left: -16px;
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
	padding: 0.25rem;
	
}
</style>
<script type="text/javascript">

$(function() {

	var itemList = [];
	$('#strMultiRowItemId option').each(function() 
	{		
		itemList.push({
			"value" : this.textContent,
			"data" : this.value
		});		
		
	});	
	
	$('#strSearchDrug').autocomplete({
		lookup : itemList,
		minChars : 2,
		formatResult: function(suggestion, currentValue) 
		{
			//alert(suggestion.value.toLowerCase());
	        var color = suggestion.value.toLowerCase().includes('[avl]') ? 'green' : 'black';
	        return '<span style="color:' + color + ';">' + suggestion.value + '</span>';
	        //return '<span style="color:' + color + '; font-weight: normal; color: #3399ff;">' + suggestion.value + '</span>';
	    },
		onSelect : function(suggestion) 
		{
			document.getElementById("strItemCategory").disabled=true;
			document.getElementById("strToStoreCombo").disabled=true;
			getDrugNameSelected_off_Line(suggestion.data);
		}
	});

	$('#strSearchDrug').click(function() {
		$(this).val("");

	});
});


function getDrugNameSelected_off_Line(itemId) 
{
	// alert("-->>"+itemId);

	var totRow = parseInt(document.getElementsByName("rowLength1")[0].value, 10);
	var indxRow = parseInt(document.getElementsByName("rowIndex1")[0].value, 10);

	var rowBatch = document.getElementsByName("itemParamValue");
    /*
	0.45 DEXTROSE NORMAL SALINE 500ML [ 0 ] ^0.45 DEXTROSE NORMAL SALINE 500ML^0^103^22.22^Sanjeev Pharma Lts^2^0^0^0^/^/^/^/^/^0^0^0^No.^Indian
	#103^22.2200000000000000^0
	#10001569^10103106^101006^0^1^0^0^103^6301^22.22^6301^6301^0^2023-12-26 00:00:00^1010017^0^^^^2^6303^0^0^0^0^0^0^-^0.00^0^1^2^0^0^0^0^1^0^0^NA^NA^NA^0^IV FLUID"
	*/

	var len = rowBatch.length;

	var passBatch = itemId.split("#")[0];

	for (var j = 0; j < len; j++) 
	{
		var cBatch = rowBatch[j].value;

		if (passBatch == cBatch) 
		{
			alert("Duplicate Drug  [ " + rowBatch[j].value.split("^")[0] + " ]  not allowed !!");			
			document.getElementById("strSearchDrug").value = "";
			document.getElementById("strSearchDrug").focus();
			return false;
		}
	}

	addRows(new Array('strReqQty'), new Array('t', 't', 't', 't','t'),'1', '1', 'R');

	document.getElementById("itemParamValue1-" + (indxRow + 1)).value = itemId.split("#")[0];
	document.getElementById("itemCalcValue1-" + (indxRow + 1)).value = itemId.split("#")[1];
	document.getElementById("itemUserValue1-" + (indxRow + 1)).value = itemId.split("#")[2];	
	
	document.getElementById("strBrandName1-" + (indxRow + 1)).innerHTML = (itemId.split("#")[0]).split("^")[0];
	document.getElementById("strItemType1-" + (indxRow + 1)).innerHTML = (itemId.split("#")[2]).split("^")[43];
	document.getElementById("strAvlQty1-" + (indxRow + 1)).innerHTML = (itemId.split("#")[0]).split("^")[3];
	
	
	var searchId = 'strSearchDrug';
	document.getElementById(searchId).value = "";
	document.getElementById("strReqQty1-" + (indxRow + 1)).focus();
}


	function clearItemDiv()
	{
	 var itemParaObj = document.getElementById("id1");
          itemParaObj.innerHTML = ""; 	
	}
	
	function getItemSelectPopup()
	{
		
	     setItemDtlWithIssueQty();
	     var issueStore = document.forms[0].strToStoreCombo[document.forms[0].strToStoreCombo.selectedIndex].value; //document.forms[0].strToStoreCombo.value;
	     if(issueStore!=0)
	     {
		    var strModeVal 		= "1" ; 
	        var strItemCategory = document.forms[0].strItemCatNo.value ;
	        var strRequestType 	= document.forms[0].strIndentTypeId.value;
	        var strFromStoreId 	= document.forms[0].strStoreId.value;
	        var strUserInfo 	= document.forms[0].strToStoreCombo[document.forms[0].strToStoreCombo.selectedIndex].value;		
		    var strMultiRowCompArray     = new Array('itemParamValue','itemCalcValue','itemUserValue','strReqQty','strUnitName','strCost');
	
	        var strMultiRowCompTypeArray = new Array('t','t','t','t','s');
	
	            // for mode val 1
	             
	     //   var strMultiRowFetchDataArray  = new Array('1','4','8','9','0^strUnitName^invokeCheckQty');
	        var strMultiRowFetchDataArray  = new Array('1','66','4','0^strUnitName^invokeCheckQty');
	
			var layerIndex = "1";
			document.getElementById("strToStoreCombo").disabled=true;
			searchItems( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex , strUserInfo);
		    //searchItems( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex);
		 }
		 else
		 {
		   alert("Please Select Issuing Store Name");
		   return false;
		 }
			  
			    
	}		

    function invokeCheckQty(mode, index, unitObject)
	{ 
		       
		        // Pass '0' If User Dont Want to Compare Req Qty with Avalaible Quantity 
		        
		 		calculateCost(mode, 'strReqQty', 'strUnitName', 'strCost', index , 'strApproxAmt','0');
		 
			
	}	
	
	function changeUnitCmb(obj,index)
	{	    
       	document.getElementById("strCostDivId" + index).innerHTML = "0.00";
       	document.getElementById("strCost" + index).value = "0";
 
        calculateCost('1', 'strReqQty', 'strUnitName', 'strCost', index , 'strApproxAmt','0');  	
       	
	}
	
	
function setItemDtlWithIssueQty(){
	
		var itemWithIssueQty = document.getElementById("strItemDtlWithIssueQty");
		var  itemUserVal    = document.getElementsByName("itemUserValue");
	    //var issueQty    = document.getElementsByName("strIssueQty");
  		var reqQty      = document.getElementsByName("strReqQty");
  		var unitNameCmb = document.getElementsByName("strUnitName");
  		//var costObj     = document.getElementsByName("strCost");
		  
				
			if(itemUserVal.length > 1)
			{
				
				var tempIssueDtls ; 
				
				for(var i = 0 ; i < itemUserVal.length - 1 ; i++)
				{

															
					if(i == 0 )
					{
						
						tempIssueDtls = itemUserVal[i].value+"@@@@"+reqQty[i].value+"@@@@"+unitNameCmb[i].value;	
						
					}
					else
					{
					
						tempIssueDtls = tempIssueDtls+"$$$$"+itemUserVal[i].value+"@@@@"+reqQty[i].value+"@@@@"+unitNameCmb[i].value;
					
					}
				
				}
				
				itemWithIssueQty.value = tempIssueDtls;
				
				
			}else{
				itemWithIssueQty.value = "";
					
			}
				
		
	
	}


function hideBalQtyDetails(divId) {
	hide_popup_menu(divId);
}

/** This is the validate function for Breakage Item Details jsp file
 *  i.e:- add_BreakageItemDtlTrans_mms.jsp and 
 *  transfer control to the controller 'INSERT' method.  
 */
 
function validate2()
{      
	document.getElementById("strToStoreCombo").disabled=false;
	var saveObj = document.getElementById("saveId");
	//alert(document.forms[0].strIndentPeriod.value)
	if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	{
		saveObj.style.display = "none"; 
		
	//if(document.forms[0].strIndentPeriod.value == '0')
	//{
	//	alert("Please Select Indent Period!!!")
	//	return false;
	//}strIndentPeriod
	  var hisValidator = new HISValidator("indentTransADDBean");  
	 // hisValidator.addValidation("strIndentPeriod","dontselect=0","Indent Period is a Mandatory Field" );
	//  hisValidator.addValidation("strToStoreCombo","dontselect=0","Please select a value from To Store Combo" );
	  //hisValidator.addValidation("strGroupIdForItemSearch","dontselect=0","Please select a value from Group Name Combo" );
	  hisValidator.addValidation("strRemarks","req","Remarks is a Mandatory Field" );
	  hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	  var retVal = hisValidator.validate(); 
	  var itemParVal  = document.getElementsByName("itemParamValue");
      var reqQty  = document.getElementsByName("strReqQty");
      var myArray   = new Array();
      var myArray1  = new Array();
      var reqQtyVal="0";
      var count = parseInt("0");
      var avlBudget = parseFloat(document.forms[0].strAvalaibleBudget.value);
      //var orderCost = parseFloat(document.forms[0].strApproxAmt.value);
     if(retVal)
     {  	
    	 
    	 if(document.forms[0].strIndentPeriod.value == '0')
    	{
    		 alert("Indent Period is a Mandatory Field");
    		 saveObj.style.display = ""; 
    		 return false;
    	}
     
       if(itemParVal.length > 1)
       {
       for(var x=0;x<itemParVal.length-1;x++)
       {
          hisValidator.addValidation("strReqQty","req","Required Quantity is a Mandatory Field" );
	   
          var retVal1 = hisValidator.validate(); 
          if(retVal1)
          {
            myArray = itemParVal[x].value.split("^");           
            count = count +1;
                     
          } 
          else
	       {
	       	 saveObj.style.display = '';
		      return false;
           }  
           
        }
        if(count>0)
        {
        								
                  var conf = confirm("You Are Going To Save Records");
                  if(conf == true)
                  {
                       var conf1 = confirm("Are you sure !!!");
                       if(conf1 == true)
                       {
                    	   
                    	    document.forms[0].strItemCatNo.disabled = false;
 						    document.forms[0].hmode.value = "INSERT_NEW_FINDER_DATA";
						    document.forms[0].submit();
                       }
                      else
                       {
                       	 saveObj.style.display = '';
                         return false;
                          
                       }
                   }
                  else
                   {
                   	 saveObj.style.display = '';
                         return false;								                          
                   }    
        							                   
        }
        
        
       }
       else
	  { 
	      alert("Please Select Item from Search Utility!!!");
	       saveObj.style.display = '';
		  return false;
	  }
        
     }
     else
	 {
	 	 saveObj.style.display = '';
		  return false;
     } 
      
	}
	else
  	{
  	    saveObj.style.display = '';
		return false;
  	}   
      
	  
}

function QtyValidation_OffLine(index) 
{
	
	var textValue  = document.getElementById("strReqQty" + index).value;
    //alert(textValue.length);
	if (parseInt(textValue.length) > 0) 
	{
		document.getElementById("strSearchDrug").focus();
	}
	else
	{	    
	    alert("Please Enter Qunatity!!");		
	}	
}
function generatRemarks()
{
	var catgName    = document.forms[0].strItemCategory[document.forms[0].strItemCategory.selectedIndex].text;
	var toStoreName = document.forms[0].strToStoreCombo[document.forms[0].strToStoreCombo.selectedIndex].text;
	document.getElementById("strRemarks").value = " Indent will be Generated To Store "+toStoreName +" For Catg "+catgName;
	
	getItemDrugList();
	
}

</script>

</head>

<body onLoad="generatRemarks();">

<html:form action="/transactions/IndentTransADDBSCNT.cnt"
	name="indentTransADDBean"
	type="mms.transactions.controller.fb.IndentTransADDFB" method="post">

	<div class="errMsg" id="errMsg" style="font-size:16px"><bean:write
		name="indentTransADDBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg" style="font-size:16px"><bean:write
		name="indentTransADDBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg" style="font-size:16px"><bean:write
		name="indentTransADDBean" property="strMsg" /></div>

<%-- Change Request --%>

<%-- <div class="alert alert-danger  alert-dismissible fade show" id="errID" style="display: none;"><bean:write name="rateContractDtlBean" property="strErr" /></div>
	<div class="alert alert-success  alert-dismissible fade show" id="normalMsg" style="display: none;"><bean:write name="rateContractDtlBean" property="strMsg" /></div>
	<div class="alert alert-warning  alert-dismissible fade show" id="wrnID" style="display: none;"><bean:write name="rateContractDtlBean" property="strWarning" /></div>
--%>	
<div class="container-fluid">
	<div class="prescriptionTile">	
	<fieldset>					
		<legend class="legendHeader" id='nonPrintableLegend'>Indent For Issue</legend>

		<div class="legend2" id='saveId'>
			<button type="button" class="float-right btn btn-danger mt-1 btn-circle" style="border-radius:50%; padding:12px;" onclick="cancel('CANCEL');">
				<i class="fas fa-times fa-lg iround" title="Cancel"></i>
			</button>
			<button type="button" class="float-right  btn btn-secondary btn-circle" style="border-radius:50%; padding:12px 11px; background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" onclick="initPage();">
				<i class="fas fa-broom iround" title="Clear"></i>
			</button>
			<button type="button" id="savebutton" class="float-right btn btn-success mt-1 btn-circle savebtn" name="requestForLpPatient" tabindex='2'style="border-radius:50%; padding:12px;" id="submitId" onclick='return validate2();'>
				<i class="fa fa-download fa-beat iround" title="Save"></i>
			</button>
		</div>
	
		<div class='popup' id='avalaibleBudgetDtlId' style="display: none">
			<table width='400' border="0" cellspacing="1" cellpadding="1">
				<tr class="HEADER">
					<td colspan='3'>Budget Details</td>
		
					<th align='right'><img style='cursor: pointer; '
				src='../../hisglobal/images/popUp_cancel.JPG' title='Click to Close Pop-Up'
				onClick="hideBalQtyDetails('avalaibleBudgetDtlId');"></th>
				</tr>
			</table>
		
		
			<table width='400' border="0" cellspacing="1" cellpadding="1">
				<tr>
					<td colspan="1" class='multiLabel'>Budget Allocated</td>
					<td colspan="1" class='multiLabel'>Budget Consumed</td>
				</tr>
				<tr>
					<td colspan="1" class='multiControl'>
						<div id='1'></div>
					</td>
					<td colspan="1" class='multiControl'>
						<div id='2'></div>
					</td>
				</tr>
			</table>
		</div>
<%-- Change Request End --%>
	<div class="container">
	   <div class="row my-1">
		  <div class="col-sm-2">Store Name:</div>
		  <div class="col-sm-4"><bean:write name="indentTransADDBean" property="strStoreNameFunc" filter="false" /></div>
		  <div class="col-sm-2">Indent Date:</div>
		  <div class="col-sm-4"><bean:write name="indentTransADDBean" property="strIndentDate" filter="false" /></div>
	   </div>

	   <div class="row my-1">
		 <div class="col-sm-2 "><label>Indent Type:</label></div>
		 <div class="col-sm-4"><bean:write name="indentTransADDBean" property="strIndentTypeFunc" filter="false" /></div>
		 <div class="col-sm-2">Item Category:<font color="red" size="2" >*</font></div>
		 <div class="col-sm-4">
		     <%-- <bean:write name="indentTransADDBean" property="strItemCategoryFunc" filter="false" /> --%>
			 <select class='browser-default custom-select' id="strItemCategory" name='strItemCategory' onChange="getItemDrugList();"> 
			     <bean:write name="indentTransADDBean" property="strItemCategoryCmb" filter="false" />
			 </select>
		 </div>
	   </div>
	
	    <div class="row my-1">
		 <div class="col-sm-2 "><label>Indent Status:</label></div>
		 <div class="col-sm-4"><input type="radio" name=isNormal value="1" checked="checked" />Normal&nbsp;&nbsp;<input type="radio" name="isNormal" value="0" />External/Urgent</div>
		 <div class="col-sm-2">Issuing Store:<font color="red">*</font></div>
		 <div class="col-sm-4"><select class='browser-default custom-select' id="strToStoreCombo" name='strToStoreCombo' onChange="getItemDrugList();"> <bean:write name="indentTransADDBean" property="strToStoreCombo" filter="false" /></select></div>
	    </div>
	    
	    <div class="row my-1">
		 <div class="col-sm-2 "><label>Indent Period:<font color="red" size="2" >*</font></label></div>
		 <div class="col-sm-2"><select class='browser-default custom-select' name='strIndentPeriod'> <bean:write name="indentTransADDBean" property="strIndentPeriodCombo" filter="false" /></select></div>
		 <div class="col-sm-8"></div>
	    </div>
	   </div>	    
<!--  	
	<div class="row">
		<div class="col" align="right">
			<button type="button" class="btn btn-info" id='strSearchItemButtonDivId' data-toggle="modal" data-target="#tariffDtlsModal" onclick='getItemSelectPopup();'/><i class="fas fa-search"></i></button>
		</div>
	</div>
-->	
	<div>
	    <input class='form-control' type="text" id="strSearchDrug" name="strSearchDrug" style="border:1px solid;" placeholder="Enter first 3 characters of Drug Name to Search" size="120%"/>
	</div>				
	<div id="drugComboId" style='display: none;'>							
		<select name="strMultiRowItemId"     id="strMultiRowItemId" class="form-control form-control-sm" >										       
		     <bean:write name="indentTransADDBean" property="strItemNameValues" filter="false" />
		</select> 
	</div>
	
<hr>

   <div class="" id="offlineFinderId">			
			<br>
			<table class="table" >
					<thead class="thead-dark">
						<tr>
							<th  width='50%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Drug/Item Name</th>
							<th  width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Item Type</th>
							<th  width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Available Qty</th>							
							<th  width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'><font color="red">*</font>Quantity</th>
							<th  width='5%'  align='center' >#</th>
						</tr>
					</thead>
				<!-- <tbody><tr></tr></tbody> -->
			</table>
			<div id="id1" style="width:100%"></div>
	 </div>	
	 <!-- <table class="table" >
		<thead class='thead-dark' align='center'>
			<tr>
				<th  scope='col' width="40%" style='font-weight:350 !important ;font-size: 16px !important;'>Drug/Item Name</th>				
				<th  scope='col' width="15%" style='font-weight:350 !important ;font-size: 16px !important;'>Item Type</th>
				<th  scope='col' width="15%" style='font-weight:350 !important ;font-size: 16px !important;'>Available Qty</th>
				<th  scope='col' width="15%" style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</th>
				<th  scope='col' width="15%" style='font-weight:350 !important ;font-size: 16px !important;'><font color='red'>*</font>Unit</th>
			</tr>
		</thead>
	</table>
	
	<div id="id1" style='display:none;'></div>
	<div id="strApproxAmtDivId" style='display:none;' align="center">0.00</div> -->
		
	<div class="row">
		<div class="col-sm-2" align='center'><label>Remarks<font color="red" size="2" >*</font></label></div>
		<div class="col-sm-10"><textarea name="strRemarks" id="strRemarks" class="form-control" cols="20"  rows="2" id="strRemarks"  value="Indent Generation">Indent Generated</textarea></div>
	</div>
	
	

<hr>
	<div class="row rowFlex reFlex">
					        <div class="col-sm-10"></div>
					              <div class="col-sm-2" align="right"><i class="fa fa-asterisk" style="color: red;font-size: smaller;"></i>Fields Mandatory</div>				
				           </div>

					
	<input type="hidden" name="hmode" />

	<!-- <div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			     <div id="searchItemsDtlsDivId" style="display: block;"></div>
			     <div id="indentCreateDivId" style="display:block;"></div>
			</td>
		</tr>
	</table>
	</div> -->

	<input type="hidden" name="strStoreName"  value="${indentTransADDBean.strStoreName}">
	<input type="hidden" name="strReOrderFlgColor"  value="LIGHTPINK">
	<input type="hidden" name="strStoreId"
		value="${indentTransADDBean.strStoreId}">
	<input type="hidden" name="strStoreTypeId"
		value="${indentTransADDBean.strStoreTypeId}">
	<input type="hidden" name="strItemCatNo"
		value="${indentTransADDBean.strItemCatNo}">
	<input type="hidden" name="strIndentTypeId"
		value="${indentTransADDBean.strIndentTypeId}">
	<input type="hidden" name="strPath"
		value="${indentTransADDBean.strPath}">
	<input type="hidden" name="strCostRequired"
		value="${indentTransADDBean.strCostRequired}">
	<input type="hidden" name="indentNo" value="${indentTransADDBean.strIndentNo}">
	<input type="hidden" name="strAvalaibleBudgetDtl" value="${indentTransADDBean.strAvalaibleBudgetDtl}">
	<input type="hidden" name="strAvalaibleBudget" value="${indentTransADDBean.strAvalaibleBudget}">
	<input type="hidden" name="strRemainingBudget" value="${indentTransADDBean.strRemainingBudget}">
	<input type="hidden" name="search" value='<%=request.getParameter("search") %>' />
    <input type="hidden" name="blockNo" value='<%=request.getParameter("blockNo") %>' />
    <input type="hidden" name="prevNext" value='<%=request.getParameter("prevNext") %>' />
    <input type="hidden" name="rowNum" value='<%=request.getParameter("rowNum") %>'/>
    <input type="hidden" name="divisionId" value='<%=request.getParameter("divisionId") %>' />
    <input type="hidden" name="strItemDtlWithIssueQty" id="strItemDtlWithIssueQty" value="0"/>
		
	<div class='modal' id='tariffDtlsModal' tabindex='-1' role='dialog' aria-labelledby='tariffDtlsModalLabel' aria-hidden='true'>
		<div class='modal-dialog modal-lg'  role='document' style="max-width: 1000px;">
			<div class='modal-content animate-bottom'>
				<div class='modal-body' id=''>
                   <div id="searchItemsDtlsDivId" style="display:block;"></div>
				</div>
				<div class="modal-footer" style="padding: 0.5rem;display:flex; justify-content:center; ">
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
<jsp:include page="add_indent_trans_search_row.jsp"></jsp:include>



</body>
</html>