$(function() {	
		
 	    loadAutocompleteItems();
 		
 	
	   	strTypeObj.style.display = 'none';  
 	
 	
 });

function loadAutocompleteItems()
{
	$( "#strSearchDrug" ).keypress(function( event ) {
	if ( event.which == 13 ) {
		event.preventDefault();		
	}	
	});
	
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
	     getDrugNameSelectedInLeftBox(suggestion.data, "strLeftItemFilterIds");	     
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
	
	for (var i=0; i<sel.options.length; i++) {				
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
 
function validateVital()
{
	  // alert("Len---"+parseInt(document.forms[0].strRightItemFilterIds.length)); 
	    
    var itmeLength = parseInt(document.forms[0].strRightItemFilterIds.length);
	if(itmeLength>0)
	{	
		var itemBrandIds = [];
		$('#strRightItemFilterIds option').each(function() { 
		    itemBrandIds.push( $(this).val() );
		});	
		document.forms[0].strItemId.value = 	itemBrandIds;	   
	}
				
				

    $('#mask').css('display','block');
	$('#dvLoading').css('display','block');
	$('#mask').fadeIn();
	$('#dvLoading').fadeIn();
	
	
	document.forms[0].strStoreName.value       = document.forms[0].strDistrictStoreId[document.forms[0].strDistrictStoreId.selectedIndex].text;
	document.forms[0].strDrugClassName.value   = document.forms[0].strCatgId[document.forms[0].strCatgId.selectedIndex].text;
	document.forms[0].strStockStatusName.value = document.forms[0].strStatusId[document.forms[0].strStatusId.selectedIndex].text;
	
	
	document.forms[0].hmode.value = "SHOWLOCATIONSTOCKRPT";				
	document.forms[0].submit();	
				
		
}
function getDistrictCombo()
{
	
	if(document.getElementsByName("strCircleId")[0].value=='0')
	{
		
		
		var objVal1= document.getElementById("districtCmbDivId");
				objVal1.innerHTML = "<select name ='strDistrictId' class='comboNormal' onchange='getStoreCmb();'>"+
				"<option value='0'>All</option>"+
				"</select>";
				
		var objVal2= document.getElementById("strStoreDivId");
				objVal2.innerHTML = "<select name ='strDistrictStoreId' class='comboNormal' onchange='getStoreTypeCmb();'>"+
			   "<option value='0'>All</option>"+"</select>";
		
		var objVal3= document.getElementById("strLeftItemIds");
				objVal3.innerHTML = "";
				
		document.forms[0].strRightItemIds.value="";
				
				
		var url ="LocationWiseStockSummaryRptCNT.cnt?hmode=DWHTYPECMB&circleId="+document.forms[0].strCircleId.value;
		ajaxFunction(url,"6");			
					
		
	}    
	else
	{
		var url ="LocationWiseStockSummaryRptCNT.cnt?hmode=DISTRICTCMB&circleId="+document.forms[0].strCircleId.value;
		ajaxFunction(url,"2");	
	}

	

}	


function getStoreCmb()
{	      
		    
		    var strCircleId = document.forms[0].strCircleId.value;
		    var strDistrictId = document.forms[0].strDistrictId.value;
		    
		
			var url ="LocationWiseStockSummaryRptCNT.cnt?hmode=STORECOMBO&strDistrictId="+strDistrictId+"&strCircleId="+strCircleId;
			ajaxFunction(url,"3");	

}



function getStoreTypeCmb()
{

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
     if(document.forms[0].strDistrictStoreId)
     {
       
    	    var strDistrictStoreId = document.forms[0].strDistrictStoreId.value;
    	    if(strDistrictStoreId=="0")
    	    { 
	    	   var url ="LocationWiseStockSummaryRptCNT.cnt?hmode=DWHTYPECMB&strDistrictId="+strDistrictId+
			   "&strCircleId="+strCircleId+"&strDistrictStoreId="+strDistrictStoreId;
			 
	    	   ajaxFunction(url,"4");
	    	}
	    	else
	    	{
	    	   var url ="LocationWiseStockSummaryRptCNT.cnt?hmode=DWHSUBTYPECMB&strDistrictId="+strDistrictId+
				"&strCircleId="+strCircleId+"&strDistrictStoreId="+strDistrictStoreId;
							
		    	ajaxFunction(url,"4");   
	    	   
	    	}    
     }	 
     else
     {
    	 var strDistrictStoreId = '0';    	 
    	 var url ="LocationWiseStockSummaryRptCNT.cnt?hmode=DWHTYPECMB&strDistrictId="+strDistrictId+
		 "&strCircleId="+strCircleId+"&strDistrictStoreId="+strDistrictStoreId;	
    	 ajaxFunction(url,"4");   
     }
    
     
     
}

function getSubStoreCmb()
{


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
     
      var url ="LocationWiseStockSummaryRptCNT.cnt?hmode=SUBSTORECOMBO&strDistrictId="+strDistrictId+
			"&strCircleId="+strCircleId+"&strDistrictStoreId="+strDistrictStoreId+
			"&strStoreTypeId="+strStoreTypeId;
			
			

    ajaxFunction(url,"5");

}

function getLeftComboItems(alpha) 
{		
	document.getElementsByName("strAlphbet")[0].value = alpha;
	
	
	
	document.getElementById(document.forms[0].strSearchIndex.value).style.color="#a80080";
	document.getElementById(document.forms[0].strSearchIndex.value).style.fontSize = "11px";
	
	document.getElementById(alpha + "Id").style.color="red";
	document.getElementById(alpha + "Id").style.fontSize = "16px";
			
	document.forms[0].strSearchIndex.value = alpha + "Id";

	var url = "LocationWiseStockSummaryRptCNT.cnt?hmode=DRUGNAME&strAlphabet="+ alpha+"&strCatgId="+document.getElementsByName("strCatgId")[0].value;
	ajaxFunction(url, "7");
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
	if(mode=="3")
	{ 	     
			var objVal= document.getElementById("strStoreDivId");
			objVal.innerHTML = "<select name ='strDistrictStoreId' class='comboNormal' onchange='getStoreTypeCmb();'>"+res.split("$")[0]+"</select>";	
			var objVal= document.getElementById("storeTypeDivId");				
			objVal.innerHTML = "<select id='strLeftItemIds' name='strLeftItemIds' size='6' multiple style='width: 280px' >"+res.split("$")[1]+"</select>";
			document.getElementById("RightItemIds").innerHTML = "<select id='strRightItemIds' name='strRightItemIds' size='6' multiple style='width: 280px' ></select>";	
	}	
	
	if(mode=="4")
	{ 	    
	
			var objVal= document.getElementById("storeTypeDivId");				
			objVal.innerHTML = "<select id='strLeftItemIds' name='strLeftItemIds' size='6' multiple style='width: 280px' >"+res+"</select>";
						
			var strDistrictStoreId = document.forms[0].strDistrictStoreId.value;
				
			if(strDistrictStoreId!='0')
			{
				if(strDistrictStoreId.split("^")[2]=='1')
				{
					document.getElementsByName("strIsDdwFlag")[0].value='1';
					document.getElementById("storeTypeId").style.display = 'block';
				}
				else
				{
					document.getElementsByName("strIsDdwFlag")[0].value='0';
					document.getElementById("storeTypeId").style.display = 'none';
				}
		 	}
		 	else
		 	{
		 	       
		 	        document.getElementsByName("strIsDdwFlag")[0].value='0';
					document.getElementById("storeTypeId").style.display = 'block';
		 	}
		 	document.getElementById("RightItemIds").innerHTML = "<select id='strRightItemIds' name='strRightItemIds' size='6' multiple style='width: 280px' ></select>";		 	
	      	
	}	
		
	if(mode=="5"){			
		var objVal= document.getElementById("strSubStoreDivId");			
		objVal.innerHTML = "<select name ='strStoreId' class='comboNormal' onchange='getItemCatCmb();'>"+res+"</select>";	
	}	
	
	if(mode=="6")
	{ 	           
		var objVal= document.getElementById("storeTypeDivId");				
		objVal.innerHTML = "<select id='strLeftItemIds' name='strLeftItemIds' size='6' multiple style='width: 280px' >"+res+"</select>";
		document.getElementById("RightItemIds").innerHTML = "<select id='strRightItemIds' name='strRightItemIds' size='6' multiple style='width: 280px' ></select>";	
	}
	if(mode=="7")
	{ 	
	    //alert(res);           
		var objVal= document.getElementById("leftItemDivId");				
		objVal.innerHTML = "<select id='strLeftItemFilterIds' name='strLeftItemFilterIds' size='6' multiple style='width: 280px' onChange='showSelection(this);'>"+res+"</select>";
		document.getElementById("drugNameDivId").innerHTML = "<select id='strDrugName' name='strDrugName' class='comboNormal' >"+res+"</select>";
		loadAutocompleteItems();	
	}		
	
}	

	
function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();
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
	document.forms[0].strStoreId.value = "0";
	document.forms[0].strItemCatNo.value = "0";	
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
function setVitalDrugFlag(obj)
{
	if(obj.checked)	
	{
	   document.getElementById("normalRpt").style.display="none";
	   document.getElementById("htmlRpt").style.display="block";
	   //document.forms[0].strWhetherItemShown.checked = true;
	   //document.forms[0].strWhetherItemShown.disabled = true;
	}   
	else
	{
	   document.getElementById("normalRpt").style.display="block";
	   //document.getElementById("htmlRpt").style.display="none";	 
	   //document.forms[0].strWhetherItemShown.disabled = false;
	}
 	
   	
}

function  vitalRpt(obj,mode)
{
	if(obj.checked)	
	{
	   if(mode=='1')
	   {
	     document.forms[0].strBatchWiseChkFlg.value="1";
	   }	  
	}   
	else
	{
	   if(mode=='1')
	   {
	     document.forms[0].strBatchWiseChkFlg.value="0";
	   }	
	}
 	
   	
}


function setHtmlFlag(obj)
{
	if(obj.checked)	
	{	   
	   document.forms[0].strZeroVitalFlg.value = "1";
	   
	}   
	else
	{
	   document.forms[0].strZeroVitalFlg.value = "0";
	}	
   	
}

function LeftDrugTransfer()
{	
	var rightList =  $( "#strRightItemFilterIds option");
	var lenRight = parseInt(document.forms[0].strRightItemFilterIds.length);
	var lenLeft  = $("#strLeftItemFilterIds :selected").length;
	var leftCurr;
	var leftCurrName;
	var rightCurr;
			
	if(lenLeft > 0)
	{
		$( "#strLeftItemFilterIds option:selected" ).each(function() {
		    leftCurr = $( this ).val();
		    leftCurrName = $( this ).text();
		    
	    	for(var j=0; j<lenRight; j++)
			{						
			    rightCurr = rightList[j].value;
			    if ( leftCurr == rightCurr) 
			    {
			    	alert("Drug ["+leftCurrName+"] already existing in Right List will be removed automatically!!!");				
					$(this).removeAttr("selected");																								
				}									
			}		    		    
	    });
	    
	    shiftToRightLimit("strLeftItemFilterIds","strRightItemFilterIds",1,25);
	    $('#strDrugName').html($('#strLeftItemFilterIds').html()); 
	    loadAutocompleteItems();		 	
	}
	else
	{
		alert("Please select an item to move Right");		
		return false;
	}
	
	 
	
	
}

function transferToLeft()
{        
    shiftToLeft("strLeftItemFilterIds","strRightItemFilterIds",1);
    $('#strDrugName').html($('#strLeftItemFilterIds').html()); 
    loadAutocompleteItems();         
}
