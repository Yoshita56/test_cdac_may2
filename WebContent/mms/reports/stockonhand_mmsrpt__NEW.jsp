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
<title>Stock In Hand Record</title>
<link href="../../hisglobal/css/dwh.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
 
<script language="JavaScript" src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/autocompleteItemSearch.js"></script>
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


	var hisValidator = new HISValidator("stockOnHandRPT");
	
	hisValidator.addValidation("strDistrictStoreId", "dontselect=-1"," Please Select Store Name ");
//	hisValidator.addValidation("strStoreId", "dontselect=0","Please Select Sub-Store Name");
//	hisValidator.addValidation("strItemCatNo", "dontselect=0","Please Select Item Category");
//	hisValidator.addValidation("strItemType", "dontselect=0","Please Select Drug Type ");
	if(document.forms[0].strCurrentStock.checked == false){
			hisValidator.addValidation("strDate", "date","To Date is a mandatory field");
			hisValidator.addValidation("strDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select Date Less Than or Equal To Current Date");
	}			
	
	var retVal = hisValidator.validate();
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
			document.forms[0].hmode.value = "SHOWRPT";
		
				if(document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html")
				{
					document.forms[0].target = "_self";
				}else{
					document.forms[0].target = "_blank";
				}
				document.forms[0].submit();
				}else{
			return false;
		}
	}
	

	
function getItemCatCmb(){ 
	
		if(document.forms[0].strStoreId.value!=0)
		{
			var url ="StockOnHandRptCNT_NEW.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
	 		ajaxFunction(url,"1");
	 		
	 	}
	 	else
	 	{
			document.forms[0].strItemCatNo.value="0";
			document.forms[0].strGroupId.value="0";
    document.forms[0].strProgId.value='0';
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
    
		getProgName();
			
}	
function getGroupCmb(){ 

	if(document.forms[0].strItemCatNo.value!=0)
	{
		var url ="StockOnHandRptCNT_NEW.cnt?hmode=GROUPCMB&itemcat="+document.forms[0].strItemCatNo.value;
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
	    var url ="StockOnHandRptCNT_NEW_NEW.cnt?hmode=DRUGNAME&storeId="+document.forms[0].strStoreId.value+
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
	    var url ="StockOnHandRptCNT_NEW.cnt?hmode=DRUGNAME&storeId="+document.forms[0].strStoreId.value+
		         "&itemcat="+document.forms[0].strItemCatNo.value+
		         "&groupId="+document.forms[0].strGroupId.value+
		         "&itemType="+document.forms[0].strItemType.value+
	   			 "&statusId="+document.forms[0].strStatusId.value+
	   			 "&districtStoreId="+districtPresent;	    
	    
	   			  ajaxFunction(url,"7");
	   			  shiftAllToLeft('strLeftItemIds','strRightItemIds',1);
}

function getProgName()
{
		
	    var url ="StockOnHandRptCNT_NEW.cnt?hmode=PROGNAME&districtStoreId="+document.forms[0].strStoreId.value+
		         "&itemcat="+document.forms[0].strItemCatNo.value;
	    //alert("HI:"+url);
	   			  ajaxFunction(url,"8");
}				
  
  




function getStoreTypeCmb(){
   
     	var strDistrictStoreId = document.forms[0].strDistrictStoreId.value;
		//alert("in");
    	var url ="StockOnHandRptCNT_NEW.cnt?hmode=STORETYPECMB&strDistrictStoreId="+strDistrictStoreId;
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
     
var url ="StockOnHandRptCNT_NEW.cnt?hmode=SUBSTORECOMBO&strDistrictId="+strDistrictId+
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
			objVal.innerHTML = "<select name ='strItemCatNo' class='comboNormal' onchange='getGroupCmb();'>"+res+"</select>";
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
		 var temp= "<select name ='strGroupId' class='comboNormal' onchange='getDrugName();'>"+res+"</select><input type='checkbox' name='strIsGroupWise' value='1' checked='checked'>Group Wise Report";
			
					objVal.innerHTML = temp;
					
					getDrugName();
	}
	
	if(mode=="7")
	{ 
		
			var objVal= document.getElementById("LeftItemIds");
			objVal.innerHTML = "<select id='strLeftItemIds' name='strLeftItemIds' size='6' multiple style='width: 280px' onChange='showSelection(this);' >"+res+"</select>";
			
			
			var objVal1= document.getElementById("drugNameDivId");
			objVal1.innerHTML = "<select id='strDrugName' name='strDrugName' class='comboNormal'  >"+res+"</select>";
			loadAutocompleteItems();
			
			document.forms[0].strSearchDrug.value='';
			
			document.getElementById("txtFromLeftMutltiSelectCombo").innerHTML	=	'';
			document.getElementById("txtFromLeftMutltiSelectCombo").style.display='none';
					
	}
	
	if(mode=="8"){ 
			
			var objVal1= document.getElementById("progNameDivId");
			objVal1.innerHTML = "<select id='strProgId' name='strProgId' class='comboNormal'  >"+res+"</select>";
	getDrugName1();
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
<html:form action="/reports/StockOnHandRptCNT_NEW" method="post" styleClass="formbg">

	<div class="errMsg" id="errMsg"><bean:write name="stockOnHandRPT"
		property="strErrMsg" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="stockOnHandRPT" property="strNormalMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="stockOnHandRPT" property="strWarningMsg" /></div>


	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr class="HEADER">
			<td colspan="4" class='all-four-rounded-corners'>Stock In Hand Record</td>
		</tr>
		 
	<%-- <logic:lessThan property="strUserLevel" name="stockOnHandRPT" value="4" >
	
		<tr id="circleTrId" >
			<td class="LABEL" width="30%" colspan="1"><font color="red">*</font>Circle Name</td>
			<td class="CONTROL" width="70%" colspan="3">
			<div id="circleCmbDivId" align="left">
			<select	class='comboNormal' name="strCircleId" tabindex="1" onchange="getDistrictCombo();">
					<bean:write name="stockOnHandRPT" property="strCircleCombo" filter="false" />
			</select></div>
			</td>
		</tr>		
		
		<tr id="districtTrId" >
			<td width="30%" colspan="1" class="LABEL"><font color="red">*</font>District Name</td>
			<td width="70%" colspan="3" class="CONTROL">
			<div id="districtCmbDivId">
			 <select name="strDistrictId" class="comboNormal" onChange="getStoreCmb();">
				<bean:write name="stockOnHandRPT" property="strDistrictCombo"	filter="false" />
			</select></div>
			</td>
		</tr>
		
		
	</logic:lessThan> --%>
	
	<logic:lessThan property="strUserLevel" name="stockOnHandRPT" value="4" >
			
		<tr id="districtDrugWarehouseDivId" >
			<td width="30%" colspan="1" class="LABEL"><font color="red">*</font>District WareHouse Name</td>
			<td width="70%" colspan="3" class="CONTROL">
			<div id="strStoreDivId" >
				<select name="strDistrictStoreId" class="comboNormal" onchange="getStoreTypeCmb();">
					<bean:write name="stockOnHandRPT" property="strDistrictStoreValues" filter="false"/>
				</select>
			</div>				
			</td>
		</tr>		
			
				
		
		<tr id="storeTypeTrId">
			<td width="30%" colspan="1" class="LABEL">Store Type</td>
			<td width="70%" colspan="3" class="CONTROL">
			<div id="storeTypeDivId">					
			<select name="strStoreTypeId" class="comboNormal" onChange="getSubStoreCmb();">
				
				<bean:write name="stockOnHandRPT" property="strStoreTypeCombo" filter="false" />
			</select>
			</div>
			</td>
		</tr>
		</logic:lessThan>				
				
		<tr	id="drugWarehouseDivId">
			<td width="30%" colspan="1" class="LABEL"><font color="red">*</font>Store Name</td>
			<td width="70%" colspan="3" class="CONTROL">
			<div id="strSubStoreDivId" >
				<select name="strStoreId" class="comboNormal" onchange="getItemCatCmb();">
					<bean:write name="stockOnHandRPT" property="strStoreValues" filter="false" />
				</select>
			</div>	
			</td>
		</tr>
		    
	
	<tr>
			<td width="30%" colspan="1" class="LABEL"><font color="red">*</font>Drug Classification</td>
			<td width="70%" colspan="3" class="CONTROL">
			<div id="itemCatDivId">
			 <select name="strItemCatNo" class="comboNormal" onchange="getDrugName();">
				<bean:write name="stockOnHandRPT" property="strItemCatgCombo"	filter="false" />
			</select></div>
			</td>
	</tr>
	
	<tr>
			<td width="30%" colspan="1" class="LABEL"><font color="red">*</font>Programme Name</td>
			<td width="70%" colspan="3" class="CONTROL">
			<div id="progNameDivId">
			 <select name="strProgId" class="comboNormal" >
				<bean:write name="stockOnHandRPT" property="strProgCombo"	filter="false" />
			</select></div>
			</td>
	</tr>
			
		<tr>
			<td width="30%" colspan="1" class="LABEL">Group Name</td>
			<td width="70%" colspan="3" class="CONTROL">
				<div id="groupDivId">
					<select name="strGroupId"  class="comboNormal" onchange='getDrugName();'>
						<bean:write name="stockOnHandRPT" property="strGroupCombo"	filter="false" />
					</select>
				<input type='checkbox' name='strIsGroupWise' value='1' checked='checked'>Group Wise Report	
				</div>
				
			</td>		
		</tr>
		
		<tr>
			<td colspan="1" width="30%" class="LABEL"><font color="red">*</font>Drug Type</td>
			<td colspan="3" width="70%" class="CONTROL">
				<select name="strItemType" class="comboNormal" onchange="getDrugName();">
						<bean:write name="stockOnHandRPT" property="strItemTypeValues" filter="false" />
				</select>
				<input type='checkbox' name='strIsItemWise' value='1' checked='checked'>Item Type Wise Report	
			</td>			
		</tr>
		
		<tr>
			<td width="30%" colspan="1" class="LABEL">Status</td>
			<td width="70%" colspan="3" class="CONTROL">
			<div id="StatusDivId" >
				<select name="strStatusId" class="comboNormal" onchange="getDrugName();" >
					<option title="All" selected="selected" value="0">All</option>
					<option title="Active" value="10">Active(Ready For Issue)</option>
					<option title="Quarantine" value="15">Quarantine</option>
					<option title="InActive" value="11">InActive(NOSQ)</option>
				</select>
			</div>				
			</td>
		</tr>
		
		<tr>
			<td width="30%" colspan="1" class="LABEL">Search Item Name</td>
			<td width="70%"   class="CONTROL">
			<div id="drugNameDivId" style="display: none;">
				<select id="strDrugName" name="strDrugName" class="comboNormal" >
					<bean:write name="stockOnHandRPT" property="strDrugCombo"	filter="false" />
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
						<bean:write name="stockOnHandRPT" property="strLeftItemList" filter="false"/>
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
						<bean:write name="stockOnHandRPT" property="strRightItemList" filter="false"/>
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
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">	
		<tr>
			<td width="50%" colspan="2" class="LABEL">Batch No.</td>
			<td width="50%" colspan="2" class="CONTROL"><html:checkbox
				property="strBatchNo" name="stockOnHandRPT" value="1"
				onclick="onClickBatch();">
			</html:checkbox></td>

		</tr>
	</table>

	<div id="dateDivId" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<tr>
			<td class="LABEL" width="50%" colspan="1"><font color="red">*</font>Date</td>
			<td class="CONTROL" width="50%" colspan="2"><dateTag:date
				name="strDate" value="${stockOnHandRPT.strCurrentDate}" /></td>
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
				property="strIsFooter" name="stockOnHandRPT" value="1"></html:checkbox>
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
	<input type="hidden" name="strCurrentDate" value="${stockOnHandRPT.strCurrentDate}" />
	<input type="hidden" name="strCurrentStock" value="${stockOnHandRPT.strCurrentStock}" />
	



<input type="hidden" name="strCircleName" value="${stockOnHandRPT.strCircleName}"/>
<input type="hidden" name="strDistrictName" value="${stockOnHandRPT.strDistrictName}"/>
<input type="hidden" name="strStoreName" value="${stockOnHandRPT.strStoreName}"/>
<input type="hidden" name="strStoreTypeName" value="${stockOnHandRPT.strStoreTypeName}"/>
<input type="hidden" name="strSubStoreName" value="${stockOnHandRPT.strSubStoreName}"/>


<input type="hidden" name="strUserLevel" value="${stockOnHandRPT.strUserLevel}" />

<input type="hidden" name="strIsDdwFlag" value="${stockOnHandRPT.strIsDdwFlag}" />

<input type="hidden" name="strItemBrandId" value="${stockOnHandRPT.strItemBrandId}" />


</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>