
 $(function() {	
 	loadAutocompleteItems();	
 	onBodyDisplay(); 	
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

function onBodyDisplay()
{
	var storeId = document.getElementsByName("strDistrictStoreId")[0].value;
	var strTypeObj = document.getElementById("storeTypeId");
	var isDdwFlag = document.getElementsByName("strIsDdwFlag")[0].value;
	
	var userLevel = document.forms[0].strUserLevel.value;
	if(parseInt(userLevel)< 4)
	{   
	    document.getElementById("circleTrId").style.display = "table-row";     
		document.getElementById("districtTrId").style.display = "table-row";  
		strTypeObj.style.display = 'block';  	
 	}
 	else
 	{
 		 if(isDdwFlag=='1')
	     	strTypeObj.style.display = 'block';     	
	     else
	     	strTypeObj.style.display = 'none';  
 	}     
}
 
function sumbitForm()
{
   
 
    
    var itmeLength = parseInt(document.forms[0].strRightItemFilterIds.length);
	if(itmeLength>0)
	{	
		var itemBrandIds = [];
		$('#strRightItemFilterIds option').each(function() { 
		    itemBrandIds.push( $(this).val() );
		});	
		document.forms[0].strItemId.value = 	itemBrandIds;	   
	}
				
	if(document.forms[0].strCircleId)
        document.forms[0].strCircleName.value = document.forms[0].strCircleId[document.forms[0].strCircleId.selectedIndex].text;	
	if(document.forms[0].strDistrictId)
		document.forms[0].strDistrictName.value = document.forms[0].strDistrictId[document.forms[0].strDistrictId.selectedIndex].text;			
	if(document.forms[0].strDistrictStoreId)
		document.forms[0].strStoreName.value = document.forms[0].strDistrictStoreId[document.forms[0].strDistrictStoreId.selectedIndex].text;			
	if(document.forms[0].strStoreTypeId)
		document.forms[0].strDistrictName1.value = document.forms[0].strStoreTypeId[document.forms[0].strStoreTypeId.selectedIndex].text;		

	var hisValidator = new HISValidator("stockOnHandDateWiseRpt");
	hisValidator.addValidation("strDate", "date","Date is a mandatory field");
	hisValidator.addValidation("strDate", "dtlt="+document.forms[0].strCurrentDate.value,"Please Select Date Less Than Current Date");
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	
	if(retVal)
	{
	     $('#mask').css('display','block');
	     $('#dvLoading').css('display','block');
		 $('#mask').fadeIn(10000);
		 $('#dvLoading').fadeIn(10000);
		document.forms[0].hmode.value = "SHOWHTMLREPORT";				
		document.forms[0].submit();		
	}		
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
				
				
		var url ="StockSummaryDateWiseRptCNT.cnt?hmode=DWHTYPECMB&circleId="+document.forms[0].strCircleId.value;
		ajaxFunction(url,"6");			
					
		
	}    
	else
	{
		var url ="StockSummaryDateWiseRptCNT.cnt?hmode=DISTRICTCMB&circleId="+document.forms[0].strCircleId.value;
		ajaxFunction(url,"2");	
	}

	

}	


function getStoreCmb()
{	      
		    
		    var strCircleId = document.forms[0].strCircleId.value;
		    var strDistrictId = document.forms[0].strDistrictId.value;
		    
		
			var url ="StockSummaryDateWiseRptCNT.cnt?hmode=STORECOMBO&strDistrictId="+strDistrictId+"&strCircleId="+strCircleId;
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
	    	   var url ="StockSummaryDateWiseRptCNT.cnt?hmode=DWHTYPECMB&strDistrictId="+strDistrictId+
			   "&strCircleId="+strCircleId+"&strDistrictStoreId="+strDistrictStoreId;
			 
	    	   ajaxFunction(url,"4");
	    	}
	    	else
	    	{
	    	   var url ="StockSummaryDateWiseRptCNT.cnt?hmode=DWHSUBTYPECMB&strDistrictId="+strDistrictId+
				"&strCircleId="+strCircleId+"&strDistrictStoreId="+strDistrictStoreId;
							
		    	ajaxFunction(url,"4");   
	    	   
	    	}    
     }	 
     else
     {
    	 var strDistrictStoreId = '0';    	 
    	 var url ="StockSummaryDateWiseRptCNT.cnt?hmode=DWHTYPECMB&strDistrictId="+strDistrictId+
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
     
      var url ="StockSummaryDateWiseRptCNT.cnt?hmode=SUBSTORECOMBO&strDistrictId="+strDistrictId+
			"&strCircleId="+strCircleId+"&strDistrictStoreId="+strDistrictStoreId+
			"&strStoreTypeId="+strStoreTypeId;
			
			

    ajaxFunction(url,"5");

}

function getLeftComboItems(alpha ) {		
	document.getElementsByName("strAlphbet")[0].value = alpha;
	
	document.getElementById(alpha + "Id").style.color="red";
	document.getElementById(alpha + "Id").style.fontSize = "16px";
	document.getElementById(document.forms[0].strSearchIndex.value).style.color="blue";
	document.getElementById(document.forms[0].strSearchIndex.value).style.fontSize = "11px";
	document.forms[0].strSearchIndex.value = alpha + "Id";

	var url = "StockSummaryDateWiseRptCNT.cnt?hmode=DRUGNAME&strAlphabet="+ alpha+"&catId="+document.forms[0].stritemCatNo.value;	
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
	
	if(mode=="4"){ 	    
			var objVal= document.getElementById("storeTypeDivId");	
			objVal.innerHTML = "<select name ='strStoreTypeId' class='comboMin' >"+res+"</select>";	
			
			//document.getElementsByName("strStoreTypeId")[0].value='1';
			
			var strDistrictStoreId = document.forms[0].strDistrictStoreId.value;
			//alert("strDistrictStoreId"+strDistrictStoreId);
			if(strDistrictStoreId.split("^")[1]=='13' || strDistrictStoreId.split("^")[1]=='14')
			{
				document.getElementsByName("strIsDdwFlag")[0].value='1';
			}
			else
			{
				document.getElementsByName("strIsDdwFlag")[0].value='0'
			}
			if(document.getElementsByName("strIsDdwFlag")[0].value=='1')
	      	{
	      		document.getElementById("storeTypeDivId").style.display = 'none';
		      	//document.getElementById("storeTypeTrId").style.display = 'none';
		      	//document.getElementById("drugWarehouseDivId").style.display = '';
	      	}
	      	else
	      	{
	      		document.getElementById("storeTypeDivId").style.display = 'block';
	      		//document.getElementById("storeTypeTrId").style.display = 'block';
		      	//document.getElementById("drugWarehouseDivId").style.display = 'none';
	      	}
	      	//getProgName();
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
		var objVal= document.getElementById("leftItemDivId");				
		objVal.innerHTML = "<select id='strLeftItemFilterIds' name='strLeftItemFilterIds' size='6' multiple style='width: 280px' onChange='showSelection(this);'>"+res+"</select>";
		document.getElementById("drugNameDivId").innerHTML = "<select id='strDrugName' name='strDrugName' class='comboNormal' >"+res+"</select>";
		loadAutocompleteItems();	
	}
	if(mode=="8")
	{ 	var objVal= document.getElementById("itemTypeDivId");				
		objVal.innerHTML = "<select name ='stritemCatNo' class='comboNormal' onchange='getItemName();'>"+res.split("^")[0]+"</select>";
		
		var objVal1= document.getElementById("leftItemDivId");				
		objVal1.innerHTML = "<select id='strLeftItemFilterIds' name='strLeftItemFilterIds' size='6' multiple style='width: 280px' onChange='showSelection(this);'>"+res.split("^")[1]+"</select>";
		document.getElementById("drugNameDivId").innerHTML = "<select id='strDrugName' name='strDrugName' class='comboNormal' >"+res.split("^")[1]+"</select>";
		loadAutocompleteItems();
		
	}
	if(mode=="9")
	{ 	
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

	document.forms[0].hmode.value="unspecified";
	document.forms[0].submit();
	
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
	     document.forms[0].strStockValWiseChkFlg.value="1";
	   }	   
	}   
	else
	{
	   if(mode=='1')
	   {
	     document.forms[0].strStockValWiseChkFlg.value="0";
	   }	
	} 
}
function getItemCat()
{
	var url ="StockSummaryDateWiseRptCNT.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreTypeId.value;
	ajaxFunction(url,"8");	
	
}

function getItemName()
{
	
	var url ="StockSummaryDateWiseRptCNT.cnt?hmode=ITEMNAME&storeId="+document.forms[0].strStoreTypeId.value+
	"&catId="+document.forms[0].stritemCatNo.value;
	ajaxFunction(url,"9");	
	
}

function validate2()
{
	var hisValidator = new HISValidator("stockOnHandDateWiseRpt");
	hisValidator.addValidation("strDate", "date","Date is a mandatory field");
	hisValidator.addValidation("strDate", "dtlt="+document.forms[0].strCurrentDate.value,"Please Select Date Less Than Current Date");
	if(document.forms[0].strStoreTypeId.value == -1)
	{
	alert("Please Select Store");
	return false;
	}
	if(document.forms[0].stritemCatNo.value == -1)
		{
		alert("Please Select Category");
		return false;
		}
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	if(retVal)
		{
		 
	
    var itmeLength = parseInt(document.forms[0].strRightItemFilterIds.length);
	if(itmeLength>0)
	{	
		var itemBrandIds = [];
		$('#strRightItemFilterIds option').each(function() { 
		    itemBrandIds.push( $(this).val() );
		});	
		document.forms[0].strItemId.value = 	itemBrandIds;	   
	}
	
	document.forms[0].hmode.value = "SHOWRPT";
	
	if(document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html")
	{
		document.forms[0].target = "_self";
	}else{
		document.forms[0].target = "_blank";
	}
document.forms[0].submit();
		}
	else
		{
		return false;
		}
}
