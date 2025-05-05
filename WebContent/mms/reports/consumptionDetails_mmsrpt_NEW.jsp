<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Consumption Detail Report</title>
<!-- <link href="HBIMS/hisglobal/css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
 -->
<link href="../css/master.css" rel="stylesheet" type="text/css">
 <link href="../../hisglobal/css/dwh.css" rel="stylesheet" type="text/css"> 
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
 
<script language="JavaScript" src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/autocompleteItemSearch.js"></script>
<script language="Javascript" src="../js/stockConsumptionDateWise_mmsrpt.js"></script>
<script type="text/javascript"><!--
  
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


	var hisValidator = new HISValidator("ConsumptionDetailBean");
	
	//hisValidator.addValidation("strDistrictStoreId", "dontselect=-1"," Please Select Store Name ");
//	hisValidator.addValidation("strStoreId", "dontselect=0","Please Select Sub-Store Name");
//	hisValidator.addValidation("strItemCatNo", "dontselect=0","Please Select Item Category");
//	hisValidator.addValidation("strItemType", "dontselect=0","Please Select Drug Type ");
		//hisValidator.addValidation("strPoId", "dontselect=-1","Please Select Po No ");
	/*if(document.forms[0].strCurrentStock.checked == false)
		{
			hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
			hisValidator.addValidation("strDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select Date Less Than or Equal To Current Date");
	}*/			
	
	//var retVal = hisValidator.validate();strIsGroupWise
	/*if((document.forms[0].strIsGroupWise.value == 1 || document.forms[0].strIsItemWise.value == 1 ) && document.forms[0].strBatchNo.value == 1 )
	{
		alert("please select one");
		return false;
	}*/
	var retVal=hisValidator.validate();
	hisValidator.clearAllValidations();
	
		if(retVal){
			
			if(document.forms[0].strCircleId)
		document.forms[0].strCircleName.value = document.forms[0].strCircleId[document.forms[0].strCircleId.selectedIndex].text;
	
	if(document.forms[0].strDistrictId)
		document.forms[0].strDistrictName.value = document.forms[0].strDistrictId[document.forms[0].strDistrictId.selectedIndex].text;
		
	
	if(document.forms[0].strDistrictStoreId)
		document.forms[0].strStoreName.value = document.forms[0].strDistrictStoreId[document.forms[0].strDistrictStoreId.selectedIndex].text;
		
	if(document.forms[0].strStoreTypeId)
		document.forms[0].strStoreTypeName.value = document.forms[0].strStoreTypeId[document.forms[0].strStoreTypeId.selectedIndex].text;
	
	if(document.forms[0].strStoreId)
		document.forms[0].strSubStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;

			
	//$('#mask').css('display','block');
	//$('#dvLoading').css('display','block');
	//$('#mask').fadeIn();
	//$('#dvLoading').fadeIn();
		/*	document.forms[0].hmode.value = "SHOWRPT";
		
				if(document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html")
				{
					document.forms[0].target = "_self";
				}else{
					document.forms[0].target = "_blank";
				}
				document.forms[0].submit();
				}else{
			return false;*/
			document.forms[0].hmode.value = "SHOWHTMLREPORT";
			document.forms[0].submit();
			
		}
	}
	

	
function getItemCatCmb(){ 
	
		if(document.forms[0].strStoreId.value!=0)
		{
			
			var url ="ConsumptionDetailRptCNT_NEW.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
	 		ajaxFunction(url,"1");
	 		
	 	}
	 	else
	 	{
			document.forms[0].strItemCatNo.value="0";
			//document.forms[0].strGroupId.value="0";
		   	document.forms[0].strItemType.value='0';
		    document.forms[0].strStatusId.value='0';
			//getDrugName();
			
		}
			document.forms[0].strItemCatNo.value="0";
			//document.forms[0].strGroupId.value="0";
		    document.forms[0].strProgId.value='0';
		    document.forms[0].strItemType.value='0';
		    document.forms[0].strStatusId.value='0';
		    shiftAllToLeft('strLeftItemIds','strRightItemIds',1);			
}	
function getGroupCmb(){ 

	if(document.forms[0].strItemCatNo.value!=0)
	{
		var url ="ConsumptionDetailRptCNT_NEW.cnt?hmode=GROUPCMB&itemcat="+document.forms[0].strItemCatNo.value;
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
	    var url ="ConsumptionDetailRptCNT_NEW.cnt?hmode=DRUGNAME&storeId="+document.forms[0].strStoreId.value+
		         "&itemcat=0"+
		         "&groupId="+0+
		         "&itemType="+0+
	   			 "&statusId="+0+
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
		var url ="ConsumptionDetailRptCNT_NEW.cnt?hmode=DRUGNAME&storeId="+document.forms[0].strStoreId.value+
		         "&itemcat="+document.forms[0].strItemCatNo.value+
		         "&groupId="+0+
		         "&itemType="+0+
	   			 "&statusId="+0+
	   			 "&districtStoreId="+0;	    
	    
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
	    var url ="ConsumptionDetailRptCNT_NEW.cnt?hmode=DRUGNAME1&storeId="+document.forms[0].strStoreId.value+
		         "&itemcat="+document.forms[0].strItemCatNo.value+
		         "&groupId="+0+
		         "&itemType="+0+
	   			 "&statusId="+0+
	   			 "&districtStoreId="+0;	    
	    
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
	    var url ="ConsumptionDetailRptCNT_NEW.cnt?hmode=DRUGNAME1&storeId="+document.forms[0].strStoreId.value+
		         "&itemcat="+document.forms[0].strItemCatNo.value+
		         "&groupId="+0+
		         "&itemType="+0+
	   			 "&statusId="+0+
	   			 "&districtStoreId="+districtPresent;	    
	    
	   			  ajaxFunction(url,"10");
	   			  shiftAllToLeft('strLeftItemIds','strRightItemIds',1);
}
function getStoreTypeCmb(){
   
     	var strDistrictStoreId = document.forms[0].strDistrictStoreId.value;
		//alert("in");
    	var url ="ConsumptionDetailRptCNT_NEW.cnt?hmode=STORETYPECMB&strDistrictStoreId="+strDistrictStoreId;
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
     
var url ="ConsumptionDetailRptCNT_NEW.cnt?hmode=SUBSTORECOMBO&strDistrictId="+strDistrictId+
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
function reportType()
{
	 var url ="ConsolidatedChallanCNT_NEW.cnt?hmode=POCOMBO&storeId="+document.forms[0].strStoreId.value+
    "&itemcat="+document.forms[0].strItemCatNo.value+
    "&fromDate="+document.forms[0].strFromDate.value+
    "&toDate="+document.forms[0].strToDate.value+
    "&potype="+document.forms[0].strPoType.value;
	 ajaxFunction(url,"11");

}

function getAjaxResponse(res,mode){
	
	
	if(mode=="1"){ 
	
			var objVal= document.getElementById("itemCatDivId");
			objVal.innerHTML = "<select name ='strItemCatNo' class='comboNormal' onchange='getDrugName();'>"+res+"</select>";
			getDrugName();		
	}	
	
	if(mode=="2"){			     
			
			var objVal= document.getElementById("districtCmbDivId");
			objVal.innerHTML = "<select name ='strDistrictId' class='comboNormal' onchange='getStoreCmb();'>"+res+"</select>";	
	}

	if(mode=="4")
	{ 	    
	
			var objVal= document.getElementById("storeTypeDivId");	
			
			objVal.innerHTML = "<select name ='strStoreTypeId' class='comboNormal' onchange='getSubStoreCmb();'>"+res+"</select>";	
			//getProgName();
	
	}	
		
	if(mode=="5"){
			
			var objVal= document.getElementById("strSubStoreDivId");			
			objVal.innerHTML = "<select name ='strStoreId' class='comboNormal' onchange='getDrugName1();'>"+res+"</select>";	
	}	
	
	if(mode=="6")
	{ 
		 var objVal= document.getElementById("groupDivId");
		 var temp= "<select name ='strGroupId' class='comboNormal' onchange='getDrugName3();'>"+res.split("^")[0]+"</select><input type='checkbox' name='strIsGroupWise' value='1' checked='checked'>Group Wise Report";

		 var objVal1= document.getElementById("itemDivId");
		 var temp1= "<select name ='strItemType' class='comboNormal' onchange=' '>"+res.split("^")[1]+"</select><input type='checkbox' name='strIsItemWise' value='1' checked='checked'>Item Wise Report";

		objVal.innerHTML = temp;
		objVal1.innerHTML = temp1;
		getDrugName();
	}
	
	if(mode=="7")
	{ 
		
			var objVal= document.getElementById("LeftItemIds");
			objVal.innerHTML = "<select id='strLeftItemIds' name='strLeftItemIds' size='6' multiple style='width: 280px' onChange='showSelection(this);' >"+res.split("^")[0] +"</select>";
			
			
			var objVal1= document.getElementById("drugNameDivId");
			objVal1.innerHTML = "<select id='strDrugName' name='strDrugName' class='comboNormal'  >"+res.split("^")[0]+"</select>";
			loadAutocompleteItems();
			
			document.forms[0].strSearchDrug.value='';
			
			document.getElementById("txtFromLeftMutltiSelectCombo").innerHTML	=	'';
			document.getElementById("txtFromLeftMutltiSelectCombo").style.display='none';

			/* var objVal2= document.getElementById("groupDivId");
			 var temp= "<select name ='strGroupId' class='comboNormal' onchange='getDrugName();'>"+res.split("^")[1]+"</select><input type='checkbox' name='strIsGroupWise' value='1' checked='checked'>Group Wise Report";

			 var objVal3= document.getElementById("itemDivId");
			 var temp1= "<select name ='strItemType' class='comboNormal' onchange='getDrugName();'>"+res.split("^")[2]+"</select><input type='checkbox' name='strIsItemWise' value='1' checked='checked'>Item Wise Report";
			 objVal2.innerHTML = temp;
			 objVal3.innerHTML = temp1;*/
					
	}
	
	if(mode=="8"){ 
			
			var objVal1= document.getElementById("progNameDivId");
			objVal1.innerHTML = "<select id='strProgId' name='strProgId' class='comboNormal'  >"+res+"</select>";
	getDrugName1();
	}
	if(mode=="9")
	{ 
			var objVal= document.getElementById("LeftItemIds");
			objVal.innerHTML = "<select id='strLeftItemIds' name='strLeftItemIds' size='6' multiple style='width: 280px' onChange='showSelection(this);' >"+res.split("^")[0] +"</select>";
			
			
			var objVal1= document.getElementById("drugNameDivId");
			objVal1.innerHTML = "<select id='strDrugName' name='strDrugName' class='comboNormal'  >"+res.split("^")[0]+"</select>";
			loadAutocompleteItems();
			
			document.forms[0].strSearchDrug.value='';
			
			document.getElementById("txtFromLeftMutltiSelectCombo").innerHTML	=	'';
			document.getElementById("txtFromLeftMutltiSelectCombo").style.display='none';
			var objVal3= document.getElementById("itemDivId");
			 var temp1= "<select name ='strItemType' class='comboNormal' onchange='getDrugName4();'>"+res.split("^")[2]+"</select><input type='checkbox' name='strIsItemWise' value='1' checked='checked'>Item Wise Report";
			 objVal3.innerHTML = temp1;
					
	}
	if(mode=="10")
	{ 
			var objVal= document.getElementById("LeftItemIds");
			objVal.innerHTML = "<select id='strLeftItemIds' name='strLeftItemIds' size='6' multiple style='width: 280px' onChange='showSelection(this);' >"+res.split("^")[0] +"</select>";
			
			
			var objVal1= document.getElementById("drugNameDivId");
			objVal1.innerHTML = "<select id='strDrugName' name='strDrugName' class='comboNormal'  >"+res.split("^")[0]+"</select>";
			loadAutocompleteItems();
			
			document.forms[0].strSearchDrug.value='';
			
			document.getElementById("txtFromLeftMutltiSelectCombo").innerHTML	=	'';
			document.getElementById("txtFromLeftMutltiSelectCombo").style.display='none';
			
					
	}

	if(mode=="11")
	{		var objVal= document.getElementById("poDivId");
			objVal.innerHTML = "<select name ='strPoId' class='comboNormal' onchange=' '>"+res+"</select>";
			
			
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
	 
	 
	 document.getElementById("txtFromLeftMutltiSelectCombo").style.display='';
	 document.getElementById("txtFromLeftMutltiSelectCombo").innerHTML = selectedItems;  
}

--></script>
</head>
<body class="background" onload="getDrugName();">
<div id="mask"></div>
<div id="dvLoading"></div>
<html:form action="/reports/ConsumptionDetailRptCNT_NEW" method="post" styleClass="formbg">

	<div class="errMsg" id="errMsg"><bean:write name="ConsumptionDetailBean"
		property="strErrMsg" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="ConsumptionDetailBean" property="strNormalMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="ConsumptionDetailBean" property="strWarningMsg" /></div>


	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr class="HEADER">
			<td colspan="4" class='all-four-rounded-corners'>Consumption Detail Report</td>
		</tr>
		
	<!-- 	<tr>
			<td class="LABEL" colspan="4">
				<input type="radio" name="strPoType" value="1" onclick="setValueChk(this);" checked="checked">Annual PO 
				<input type="radio" name="strPoType" value="2"  onclick="setValueChk(this);">Local PO
				<input type="radio" name="strPoType" value="0"  onclick="setValueChk(this);">All PO
				</td>
		</tr> -->
		<!-- <tr>
		<td class="LABEL" colspan="4">
		<input type="checkbox"
				name="strsupplierchk" value="1" checked="checked" />Supplier Wise Report
		</td>
		</tr> -->
		 
				
				
		<tr	id="drugWarehouseDivId">
			<td width="30%" colspan="1" class="LABEL"><font color="red">*</font>Store Name</td>
			<td width="70%" colspan="3" class="CONTROL">
			<div id="strSubStoreDivId" >
				<select name="strStoreId" class="comboNormal" onchange="getItemCatCmb();">
					<bean:write name="ConsumptionDetailBean" property="strStoreValues" filter="false" />
				</select>
			</div>	
			</td>
		</tr>
		    
	
	 <tr>
			<td width="30%" colspan="1" class="LABEL"><font color="red">*</font>Item Category</td>
			<td width="70%" colspan="3" class="CONTROL">
			<div id="itemCatDivId">
			 <select name="strItemCatNo" class="comboNormal" onchange="getDrugName();">
				<bean:write name="ConsumptionDetailBean" property="strItemCatgCombo"	filter="false" />
				<option value="0">All</option>
			</select></div>
			</td>
	</tr>
	
	<tr style="height: 35px;">
				<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>From Date</td>
				<td class="CONTROL" width="20%" colspan="1"><dateTag:date name="strFromDate"
					value="${ConsumptionDetailBean.strCurrentDate}" /></td>
	</tr>
	<!-- <tr style="height: 35px;">
				<td class="LABEL" width="50%" colspan="1"><font color="red">*</font>To Date</td>
				<td class="CONTROL" width="50%" ><dateTag:date name="strToDate"
					value="${ConsumptionDetailBean.strCurrentDate}" /> -->
				
					<!-- <img src="../../hisglobal/images/Go.png"  onClick="reportType();" title="Get Detial(s)" />
					</td> -->
					
		     </tr>	
	
	<!-- <tr	id=" ">
			<td width="30%" colspan="1" class="LABEL"><font color="red">*</font>Po No</td>
			<td width="70%" colspan="3" class="CONTROL">
			<div id="poDivId" >
				<select name="strPoId" class="comboNormal" onchange=" ">
					<bean:write name="ConsumptionDetailBean" property="strPoValues" filter="false" />
					<option value="-1">Select Value</option>
				</select>
			</div>	
			</td>
		</tr>
		 -->
		
		
	
			<tr>				
			<td colspan="4" class="LABEL">
			    <div id="daysID" align="center">
			    	<font color="red">*</font>Day 1 : <input type="text" name="strDays1" id="strDays1" value="" maxlength="3" 
			    	onkeypress='return validateData(event,5);' onBlur="DaysValidation();" class="txtFldMin" > Day 2 :
			    	<input type="text" name="strDays2" id="strDays2" value="" maxlength="3" 
			    	onkeypress='return validateData(event,5);' onBlur="DaysValidation();" class="txtFldMin" > Day 3 :
			    	<input type="text" name="strDays3" id="strDays3" value="" maxlength="3" 
			    	onkeypress='return validateData(event,5);' onBlur="DaysValidation();" class="txtFldMin" > Day 4 :
			    	<input type="text" name="strDays4" id="strDays4" value="" maxlength="3" 
			    	onkeypress='return validateData(event,5);' onBlur="DaysValidation();" class="txtFldMin" >Day 5 :
			    	<input type="text" name="strDays5" id="strDays5" value="" maxlength="3" 
			    	onkeypress='return validateData(event,5);' onBlur="DaysValidation();" class="txtFldMin" >Day 6 :
			    	<input type="text" name="strDays6" id="strDays6" value="" maxlength="3" 
			    	onkeypress='return validateData(event,5);' onBlur="DaysValidation();" class="txtFldMin" >
			   </div>
			</td>		
		</tr>	
	  
		
		
		
	
	
		<tr>
			<td width="30%" colspan="1" class="LABEL">Search Item Name</td>
			<td width="70%"   class="CONTROL">
			<div id="drugNameDivId" style="display: none;">
				<select id="strDrugName" name="strDrugName" class="comboNormal" >
					<bean:write name="ConsumptionDetailBean" property="strDrugCombo"	filter="false" />
				</select>
			</div>
			<div id="DrugNameId" style="display: none;" ></div>
			
			<input type="text" id="strSearchDrug" name="strSearchDrug" size="100%"/>
			</td>			 
		</tr>
		
	</table>
	
		<div class="line">
			<table class='NEWTABLEWIDTH' align="center" cellspacing="1px" cellpadding="1px">
				<tr><td  width="95%"><font color="red">*</font>Item Name</td></tr>
			</table>		            	
		</div>	
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		
		<tr>
  			<td class="CONTROL" colspan="2">  			 
				<div id="LeftItemIds" align="right">
					<select id="strLeftItemIds" name="strLeftItemIds" size="6" multiple="" style="width: 280px" onChange='showSelection(this);' >
						<bean:write name="ConsumptionDetailBean" property="strLeftItemList" filter="false"/>
					</select>
				</div>				
			</td>
			<td width="6%" class="CONTROL" colspan="2">			
				<center>
					<img src="../../hisglobal/images/forward3.gif" width="30" height="21" onclick ="LeftListTransfer();"></center>
				<center>
			<img src="../../hisglobal/images/forwardward.gif" width="30" height="21" style="display: none;"
				align="middle" onClick="shiftAllToRight('strLeftItemIds','strRightItemIds',1);"/></center>
			<br/>
			<center>				
			<img src="../../hisglobal/images/backward.gif" width="30" height="21" style="display: none;"
				onClick="shiftAllToLeft('strLeftItemIds','strRightItemIds',1);"></center>
			<center>
				<img src="../../hisglobal/images/back3.gif" width="30" height="21" 
					onclick="shiftToLeft('strLeftItemIds','strRightItemIds',1);"/>
			</center>
			</td>			
			<td colspan="2" class="CONTROL">
				<div id="RightItemIds" align="left">
					<select name="strRightItemIds" size="6" multiple="" style="width: 280px">
						<bean:write name="ConsumptionDetailBean" property="strRightItemList" filter="false"/>
					</select>
				</div>
			</td>		
		</tr>		
		</table>
		
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			<tr><td class="CONTROL" colspan="4"><div id="txtFromLeftMutltiSelectCombo" style="display:none;  color:blue;font-weight:bold "></div></td></tr>
		</table>
		<div class="line"><table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
		<tr>
			<td colspan="4">Other Details</td>
		</tr>		
		</table>
	</div>
		

	<div id="dateDivId" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<tr>
			<td class="LABEL" width="50%" colspan="1"><font color="red">*</font>Date</td>
			<td class="CONTROL" width="50%" colspan="2"><dateTag:date
				name="strDate" value="${ConsumptionDetailBean.strCurrentDate}" /></td>
		</tr>
	</table>
	</div>

	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<tr>
			<td width="50%" colspan="2" class="LABEL">Report Format</td>
			<td width="50%" colspan="1" class="CONTROL"><select
				name="strReportFormat" onchange="">
				<option value="html">Html</option>
				<option value="pdf">Pdf</option>
				<option value="xls">Excel</option>
			</select></td>

		</tr>

		<tr>
			<td width="50%" colspan="2" class="LABEL">Footer Required</td>
			<td width="50%" colspan="1" class="CONTROL"><html:checkbox
				property="strIsFooter" name="ConsumptionDetailBean" value="1"></html:checkbox>
			</td>

		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">User Remarks</td>
			<td width="50%" colspan="1" class="CONTROL"><input
				class="txtFldMax" type="text" name="strUserRemarks"></td>

		</tr>
		<tr class="FOOTER">
			<td colspan="4" class='all-four-rounded-corners'></td>
		</tr>
	</table>
	
	<div><div class="legends"><font size="2" color="red">*</font> Mandatory Fields</div>
	<div class="control_button">
	<table  class="TABLEWIDTH" align="center">
	<tr>
	<td align="center"><div>
				<a href="#" class="button" onClick="return validate1();"><span class="generate">Generate</span></a>
				<a href="#" class="button" onClick="onClickClear();"><span class="clear">Clear</span></a>
				<a href="#" class="button" onClick="cancelPage();"><span class="cancel">Cancel</span></a>				 
				</div></td>
	</tr>	  
	</table>
	</div></div>	
	
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strCurrentDate" value="${ConsumptionDetailBean.strCurrentDate}" />
	<input type="hidden" name="strCurrentStock" value="${ConsumptionDetailBean.strCurrentStock}" />
	
<input type="hidden" name="strCircleName" value="${ConsumptionDetailBean.strCircleName}"/>
<input type="hidden" name="strDistrictName" value="${ConsumptionDetailBean.strDistrictName}"/>
<input type="hidden" name="strStoreName" value="${ConsumptionDetailBean.strStoreName}"/>
<input type="hidden" name="strStoreTypeName" value="${ConsumptionDetailBean.strStoreTypeName}"/>
<input type="hidden" name="strSubStoreName" value="${ConsumptionDetailBean.strSubStoreName}"/>
<input type="hidden" name="fromDate" value="${ConsumptionDetailBean.fromDate}"/>
	<input type="hidden" name="toDate" value="${ConsumptionDetailBean.toDate}"/>

<input type="hidden" name="strUserLevel" value="${ConsumptionDetailBean.strUserLevel}" />

<input type="hidden" name="strIsDdwFlag" value="${ConsumptionDetailBean.strIsDdwFlag}" />

<input type="hidden" name="strItemBrandId" value="${ConsumptionDetailBean.strItemBrandId}" />


</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>