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
	if(parseInt(userLevel)=='1'||parseInt(userLevel)=='3')
		document.getElementById("storeTypeId").style.display = 'block';
	else	
		document.getElementById("storeTypeId").style.display = 'none';	
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


function DaysValidation()
{
		var sh1 = document.forms[0].strDays1.value; 
		var sh2 = document.forms[0].strDays2.value; 
		var sh3 = document.forms[0].strDays3.value; 
		var sh4 = document.forms[0].strDays4.value; 
		var sh5 = document.forms[0].strDays5.value; 
		var sh6 = document.forms[0].strDays6.value; 
		var vDays = 0;
		
		if(sh6.length>0 || sh6>0)
		{
		 	if(sh5.length==0 || sh5==0)
		 	{
		 		alert("Please Enter Day 5 before 6.");
		 		document.forms[0].strDays6.value="";
		 		document.forms[0].strDays5.focus();
		 		return;
		 	}
		 	else
		 	{
		 		if(parseInt(sh6)>365)
		 		{
		 			alert("Days 6 Must be less than 365 !!");
		 			document.forms[0].strDays6.value="";
		 			return;
		 		}
		 		else
	 		    {
		 			if(parseInt(sh5)>parseInt(sh6))
		 			{
		 				alert("Day 6 Must be Greater than Day 5.");
				 		document.forms[0].strDays6.value="";
				 		document.forms[0].strDays6.focus();
				 		return;
		 			}
	 		    }	
		 	}
		 	
		}	
		
		
		if(sh5.length>0 || sh5>0)
		{
		 	if(sh4.length==0 || sh4==0)
		 	{
		 		alert("Please Enter Day 4 before 5.");
		 		document.forms[0].strDays5.value="";
		 		document.forms[0].strDays6.value="";
		 		document.forms[0].strDays4.focus();
		 		return;
		 	}	
		 	else
		 	{
		 		if(parseInt(sh5)>365)
		 		{
		 			alert("Days 5 Must be less than 365 !!");
		 			document.forms[0].strDays5.value="";
		 			document.forms[0].strDays6.value="";
		 			document.forms[0].strDays5.focus();
		 			return;
		 		}
		 		else
	 		    {
		 			if(parseInt(sh4)>parseInt(sh5))
		 			{
		 				alert("Day 5 Must be Greater than Day 4.");
				 		document.forms[0].strDays5.value="";
				 		document.forms[0].strDays6.value="";
				 		document.forms[0].strDays5.focus();
				 		return;
		 			}
	 		    }	
		 	}
		 	 	
		 	 	 	
		}	
		
		if(sh4.length>0 || sh4>0)
		{
		 	if(sh3.length==0 || sh3==0)
		 	{
		 		alert("Please Enter Day 3 before 4.");
		 		document.forms[0].strDays4.value="";
		 		document.forms[0].strDays5.value="";
				document.forms[0].strDays6.value="";
		 		document.forms[0].strDays3.focus();
		 		return;
		 	}
		 	else
		 	{
		 		if(parseInt(sh4)>365)
		 		{
		 			alert("Days 4 Must be less than 365 !!");
		 			document.forms[0].strDays4.value="";
		 			document.forms[0].strDays5.value="";
				 	document.forms[0].strDays6.value="";
		 			document.forms[0].strDays4.focus();
		 			return;
		 		}
		 		else
	 		    {
		 			if(parseInt(sh3)>parseInt(sh4))
		 			{
		 				alert("Day 4 Must be Greater than Day 3.");
				 		document.forms[0].strDays4.value="";
				 		document.forms[0].strDays5.value="";
				 		document.forms[0].strDays6.value="";
				 		document.forms[0].strDays4.focus();
				 		return;
		 			}
	 		    }	
		 	}
	 			 		
		 	 			 	
		}	
			 
		if(sh3.length>0 || sh3>0)
		{
		 	if(sh2.length==0 || sh2==0)
		 	{
		 		alert("Please Enter Day 2 before 3.");
		 		document.forms[0].strDays3.value="";
		 		document.forms[0].strDays4.value="";
		 		document.forms[0].strDays5.value="";
		 		document.forms[0].strDays6.value="";
		 		document.forms[0].strDays2.focus();
		 		return;
		 	}
		 	else
		 	{
		 		if(parseInt(sh3)>365)
		 		{
		 			alert("Days 3 Must be less than 365 !!");
		 			document.forms[0].strDays3.value="";
		 			document.forms[0].strDays4.value="";
				 	document.forms[0].strDays5.value="";
				 	document.forms[0].strDays6.value="";
		 			document.forms[0].strDays3.focus();
		 			return;
		 		}
		 		else
	 		    {
		 			if(parseInt(sh2)>parseInt(sh3))
		 			{
		 				alert("Day 3 Must be Greater than Day 2.");
				 		document.forms[0].strDays3.value="";
				 		document.forms[0].strDays4.value="";
				 		document.forms[0].strDays5.value="";
				 		document.forms[0].strDays6.value="";
				 		document.forms[0].strDays3.focus();
				 		return;
		 			}
	 		    }	
		 	}
		 		 	
		 			 			 	
		 }
		 if(sh2.length>0 || sh2>0)
		 {
			 	if(sh1.length==0 || sh1==0)
			 	{
			 		alert("Please Enter Day 1 before 2.");
			 		document.forms[0].strDays2.value="";
			 		document.forms[0].strDays3.value="";
				 	document.forms[0].strDays4.value="";
				 	document.forms[0].strDays5.value="";
					document.forms[0].strDays6.value="";
			 		document.forms[0].strDays1.focus();
			 		return;
			 	}
			 	else
			 	{
			 		if(parseInt(sh2)>365)
			 		{
			 			alert("Days 2 Must be less than 365 !!");
			 			document.forms[0].strDays2.value="";
			 			document.forms[0].strDays3.value="";
			 			document.forms[0].strDays4.value="";
					 	document.forms[0].strDays5.value="";
					 	document.forms[0].strDays6.value="";
			 			document.forms[0].strDays2.focus();
			 			return;
			 		}
			 		else
		 		    {		 		    	
			 			if(parseInt(sh1)>parseInt(sh2))
			 			{
			 				alert("Day 2 Must be Greater than Day 1.");
			 				document.forms[0].strDays2.value="";
					 		document.forms[0].strDays3.value="";
					 		document.forms[0].strDays4.value="";
					 		document.forms[0].strDays5.value="";
					 		document.forms[0].strDays6.value="";
					 		document.forms[0].strDays2.focus();
					 		return;
			 			}
		 		    }	
			 	}			 					 	
			 				 	
			 			 	
		}
		if(sh1.length>0 || sh1>0)
		{
			 	
			 	if(sh1>365)
		 		{
		 			alert("Days 1 Must be less than 365 !!");
		 			document.forms[0].strDays1.value="";
		 			document.forms[0].strDays2.value="";
		 			document.forms[0].strDays3.value="";
				 	document.forms[0].strDays4.value="";
				 	document.forms[0].strDays5.value="";
				 	document.forms[0].strDays6.value="";
				 	document.forms[0].strDays1.focus();
		 			return;
		 		}			 				 	
			 		 			 	
		}
		var index="0";
		if(sh6.length>0 || sh6>0)
		{
			vDays = sh6;	
			index="6";		
		}	
		else
		{
			if(sh5.length>0 || sh5>0)
			{
				vDays = sh5;
				index="5";
			}	
			else
			{
				if(sh4.length>0 || sh4>0)
				{
					vDays = sh4;
					index="4";
				}	
				else
				{
					if(sh3.length>0 || sh3>0)
					{
						vDays = sh3;
						index="3";
					}	
					else
					{
						if(sh2.length>0 || sh2>0)
						{
							vDays = sh2;
							index="2";
						}	
						else
						{
							vDays = sh1;
							index="1";
						}		
					}	
				}	
			}	
		}			
		var dt = document.forms[0].strFromDate.value;
		var m = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];		
		var dp = dt.split("-");
		var newDt = new Date(dp[1] + " " + dp[0] + ", " + dp[2]);
		newDt.setDate(newDt.getDate() + parseInt(vDays)); // 40 days to add
		dt = newDt.getDate() + "-" + m[newDt.getMonth()] + "-" + newDt.getFullYear();
		if(compareDate(dt,document.forms[0].strCurrentDate.value).mode=="2")
		{
			alert("Enter Days"+index+"  Date [ "+dt+" ] Must be  Less than Current Date[ "+document.forms[0].strCurrentDate.value+" ]");
		  	document.getElementById("strDays"+index).value="";
		  	return false;
		}
		
}			 

 
function sumbitForm()
{
  if(document.getElementsByName("strIsDdwFlag")[0].value=='1')
  {
	    var len = parseInt(document.forms[0].strRightItemIds.length);
		if(len>0)
		{			
			var strTmpItemBrandId = [];
			var strStoreTypeName = [];
			$('#strRightItemIds option').each(function() { 
			    strTmpItemBrandId.push( $(this).val() );
			    strStoreTypeName.push( $(this).text() );
			});		
			
		    document.forms[0].strItemBrandId.value	=	strTmpItemBrandId;
		    document.forms[0].strStoreTypeNameList.value	=	strStoreTypeName;		    
		}
	    else
	    {
	      
	        alert("Please Select Store Type!!!");
	        document.getElementById("strLeftItemIds").focus();
	        return false;
	     } 
      
    }
    
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

	var hisValidator = new HISValidator("stockConsumptionDateWiseRpt");
	hisValidator.addValidation("strDate", "date","Date is a mandatory field");
	hisValidator.addValidation("strDays1", "req","Day 1 is a mandatory field");
	hisValidator.addValidation("strDate", "dtltet="+document.forms[0].strCurrentDate.value,"Please Select Date Less Than Current Date");
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	
	if(retVal)
	{
	    $('#mask').css('display','block');
		$('#dvLoading').css('display','block');
		$('#mask').fadeIn();
		$('#dvLoading').fadeIn();
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
				
				
		var url ="StockConsumptionDateWiseRptCNT.cnt?hmode=DWHTYPECMB&circleId="+document.forms[0].strCircleId.value;
		ajaxFunction(url,"6");			
					
		
	}    
	else
	{
		var url ="StockConsumptionDateWiseRptCNT.cnt?hmode=DISTRICTCMB&circleId="+document.forms[0].strCircleId.value;
		ajaxFunction(url,"2");	
	}

	

}	


function getStoreCmb()
{	      
		    
		    var strCircleId = '0';
		    //alert(strCircleId);
		    var strDistrictId = '0';
		    //alert(strDistrictId);		
			var url ="StockConsumptionDateWiseRptCNT.cnt?hmode=STORECOMBO&strDistrictId="+strDistrictId+"&strCircleId="+strCircleId;
			ajaxFunction(url,"3");	

}



function getStoreTypeCmb()
{

	if(document.forms[0].strCircleId)
    var strCircleId = '0';
    else   
    var strCircleId = '0';
    
     if(document.forms[0].strDistrictId)
     {
    	 var strDistrictId = '0';
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
	    	   var url ="StockConsumptionDateWiseRptCNT.cnt?hmode=DWHTYPECMB&strDistrictId="+strDistrictId+
			   "&strCircleId="+strCircleId+"&strDistrictStoreId="+strDistrictStoreId;
			 
	    	   ajaxFunction(url,"4");
	    	}
	    	else
	    	{
	    	   var url ="StockConsumptionDateWiseRptCNT.cnt?hmode=DWHSUBTYPECMB&strDistrictId="+strDistrictId+
				"&strCircleId="+strCircleId+"&strDistrictStoreId="+strDistrictStoreId;
							
		    	ajaxFunction(url,"4");   
	    	   
	    	}    
     }	 
     else
     {
    	 var strDistrictStoreId = '0';    	 
    	 var url ="StockConsumptionDateWiseRptCNT.cnt?hmode=DWHTYPECMB&strDistrictId="+strDistrictId+
		 "&strCircleId="+strCircleId+"&strDistrictStoreId="+strDistrictStoreId;	
    	 ajaxFunction(url,"4");   
     }
    
     
     
}

function getSubStoreCmb()
{


 if(document.forms[0].strCircleId)
    var strCircleId = '0';
 else   
    var strCircleId = '0';
    
    if(document.forms[0].strDistrictId)
    {
    	 var strDistrictId = '0';
    	
    }
    else
    {
    	var strDistrictId = '0';
    	
    }
      var strDistrictStoreId = document.forms[0].strDistrictStoreId.value;    
	 	 var strStoreTypeId = document.forms[0].strStoreTypeId.value; 		
     
      var url ="StockConsumptionDateWiseRptCNT.cnt?hmode=SUBSTORECOMBO&strDistrictId="+strDistrictId+
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

	var url = "StockConsumptionDateWiseRptCNT.cnt?hmode=DRUGNAME&strAlphabet="+ alpha;	
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
				 		if(strDistrictStoreId.split("^")[1]=='14'||strDistrictStoreId.split("^")[1]=='10')
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
			}
			else
			{
				document.getElementsByName("strIsDdwFlag")[0].value='0';
				document.getElementById("storeTypeId").style.display = 'none';
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
//	document.forms[0].target = "_self";
	document.forms[0].submit();

	//document.forms[0].reset();	
	//document.forms[0].strStoreId.value = "0";
	//document.forms[0].strItemCatNo.value = "0";	
	//if(document.forms[0].strCurrentStock1)
	//{
	//	if(document.forms[0].strCurrentStock1.checked == false){
	//		document.getElementById("dateDivId").style.display = "none";
		//	document.forms[0].strCurrentStock1.checked = true;
		//	document.forms[0].strCurrentStock.checked = 1;
		//	document.forms[0].strDate.value = document.forms[0].strCurrentDate.value;
		//}
	//}
	//displaySelectedDrug();
	
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


