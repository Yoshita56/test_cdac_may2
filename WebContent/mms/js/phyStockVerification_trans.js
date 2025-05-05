
var parentObj;
 var indexPersist="";
function myAjaxFunction(myurl,mode,resFunctionName)
{
	
		
	userMode = mode;
	gblResFunctionName = resFunctionName;
	// checking browser 
	if (navigator.userAgent.indexOf("Opera")>=0){
		alert("This example doesn't work in Opera"); 
		return; 
	}

	if (navigator.userAgent.indexOf("MSIE")>=0) { 
		var strName="Msxml2.XMLHTTP"
		
		if (navigator.appVersion.indexOf("MSIE 5.5")>=0){
			strName="Microsoft.XMLHTTP"
		} 

		try { 
			objXmlHttp=new ActiveXObject(strName)
			objXmlHttp.onreadystatechange=sendReqUsingMyMethodName
		} 
		catch(e){ 
			alert("Error. Scripting for ActiveX might be disabled");
			return; 
		} 
	}
	else {
		if (navigator.userAgent.indexOf("Mozilla")>=0){
			objXmlHttp=new XMLHttpRequest();
			objXmlHttp.onload=sendReqUsingMyMethodName
			objXmlHttp.onerror=sendReqUsingMyMethodName
		}
	}

	objXmlHttp.open("GET",myurl,true)
	objXmlHttp.send(null)
} 



//internal function called from ajaxFunction() function
function sendReqUsingMyMethodName(){
		
	if (objXmlHttp.readyState==4 || objXmlHttp.readyState==200) {
		var res = objXmlHttp.responseText; 
		
		eval(gblResFunctionName + '(res' + "," + userMode + ")"); // evel is a keyword - it calls the function passed in it as argument.
		
	} 
}




function buttonLogicsOnStockUpdate(modeNo, mode , display)
{
	/*
   if(document.getElementById("comboid1").value !="0")
	{
				alert("Please Select Category");
				document.getElementById("comboid1").focus();
				return;
	}
*/

    var chkObj = document.getElementsByName("chk");
   	 var res ;
   	var count = parseInt("0");
   
   	for(var i=0; i<chkObj.length; i++) 
    {
   	 	
   	 				if(chkObj[i].checked)
   	 				{
   	 			
   	 					count = count + 1;
   	 			
   	 				}		
   	 		
   	}
   	if(count!=0 && count == '1') 
   	{
   	     res=prompt("ENTER REMARKS FOR Stock Update!!!!","");
         if(!res=="")
         {
           var conf = confirm("Are you sure !!!");
           if(conf == true)
           {
             var chkObj = document.getElementsByName("chk");  
             for(var i=0; i<chkObj.length; i++) 
   	 	     {
   	 	       if(chkObj[i].checked)
   	 		   {
   	 		       chkObj[i].value = chkObj[i].value+"^"+res;
   	 		   }		
   	 		 }
   	 		 add(mode);
           }
           else
           {
             return false;
           }
           
          }
          else
          {
           if(res=="")
           { 
            alert("Enter remarks for rejection");
           } 
          }
      }
      else
      {
           if(res=="")
           { 
            alert("Enter remarks for rejection");
           } 
           else
           {
             if(count>1)
             {
              alert("Please Select Single Record at a Time!!!");
             }
             else
             {
               alert("Please Select Record !!!!!");
             }
           } 
          return false;
      }
   	
			
}		

var gblModeVal = "";

/**
 * buttonLogicsOnClickVerify
 * @param {String} modeNo
 * @param {String} mode
 * @param {String} display
 */
 function buttonLogicsOnClickVerify(modeNo, mode , display) {
 	
 	gblModeVal = mode;
 	
 	if(document.forms[0].combo[0].value=="0"){
 		
 		alert("Please Select a Store");
 		document.forms[0].combo[0].focus();
 		return false;
 	}
 	
 	if(document.forms[0].combo[1].value=="0"){
 		
 		alert("Please Select an Item Category");
 		document.forms[0].combo[1].focus();
 		return false;
 	}
 	
 	document.forms[0].comboValue.value = document.forms[0].combo[0][document.forms[0].combo[0].selectedIndex].text +"^"+document.forms[0].combo[1][document.forms[0].combo[1].selectedIndex].text;
 	
 	var count = parseInt("0");
 	
 	 var chkObj = document.getElementsByName("chk");
   	 
   	if(chkObj.length > 0)    	 
   	for(var i=0; i<chkObj.length; i++) {
   	 	
   	 	if(chkObj[i].checked){
   	 			count = count + 1;
   	 	}		
   	 		
   	}
 	
 	 	
 	if (count > 1){
 		
 		alert("Please Select One Record");
 		return false;
 		
 	}
 	
 
 	if(count == 1){
 		
 		add(mode);
 		 	
 	}else{
 		
 		getPhysicalStockVerifyCount(document.forms[0].combo[1].value , document.forms[0].combo[0].value );
 		
 		
 	}
 	 	
   		return false;
 	
 }



function buttonLogicsOnClickCancel(modeNo, mode , display)
{
  /*
	if(document.getElementById("comboid1").value !="0")
	{
				alert("Please Select Category");
				document.getElementById("comboid1").focus();
				return;
	}
	*/
	var res ;
    var chkObj = document.getElementsByName("chk");
   	 
   	var count = parseInt("0");
   	 
   	for(var i=0; i<chkObj.length; i++) 
    {
   	 	
   	 				if(chkObj[i].checked)
   	 				{
   	 			
   	 					count = count + 1;
   	 			
   	 				}		
   	 		
   	}
   	if(count!=0 && count == '1') 
   	{
   	     res=prompt("ENTER REMARKS FOR CANCELATION!!!!!","");
         if(!res=="")
         {
           var conf = confirm("Are you sure !!!");
           if(conf == true)
           {
             var chkObj = document.getElementsByName("chk");  
             for(var i=0; i<chkObj.length; i++) 
   	 	     {
   	 	       if(chkObj[i].checked)
   	 		   {
   	 		       chkObj[i].value = chkObj[i].value+"^"+res;
   	 		   }		
   	 		 }
   	 		 add(mode);
           }
           else
           {
             return false;
           }
           
          }
          else
          {
           if(res=="")
           { 
            alert("Enter remarks for rejection");
           } 
          }
      }
      else
      {
           if(res=="")
           { 
            alert("Enter remarks for rejection");
           } 
           else
           {
             if(count>1)
             {
               alert("Please Select Single Record at a Time!!!");
             }  
             else
             {
               alert("Please Select Record !!!!!");
             }
           } 
          return false;
      }
   	
			
}		






function cancelPage(){
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
}

var setColor = "red";
var defaultColor = "blue";


 /**
  * fetchPatientList
  * @param {String} patListType 
  */
  function fetchPatientList(fromRows,blockSet) {
  	
  	 	var grpId = document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value;
  	 	
  	 	if(grpId != 0){
  	 		
  	 			var storeId = document.getElementsByName("combo")[0].value.split('^')[0];
  	  		
  				var mode="ITEMDTL";
   
  				var url="PhyStockVerificationTransCNT.cnt?hmode="+mode+"&groupId="+grpId+"&storeId="+storeId+"&fromRow="+fromRows+"&blockSet="+blockSet;
 	
				ajaxFunction2(url,"1","getPatientListDetailAjaxResponse");
  	
  	 		
  	 	}else{
  	 		
  	 		var objVal1 = document.getElementById("itemDetailsId");
				
				objVal1.style.display = "none";
				objVal1.innerHTML = "";
				 
  	 		
  	 	}
  	 	
  	
  	
  }
  
  /**
   * getPatientListDetailAjaxResponse
   * @param {String} res
   * @param {String} mode  
   */
   function getPatientListDetailAjaxResponse(res , mode) {
   	
   		var err = document.getElementById("errMsg");
      var temp = res.split("####");
   
       if(temp[0] == "ERROR")
	   {
          	err.innerHTML = temp[1];
          	return;
       } 
       
       if(mode=="1"){
		var objVal1 = document.getElementById("itemDetailsId");
		
       objVal1.style.display = "block";
        
        objVal1.innerHTML = res; 
     }
   	
   }


  function layerIndexNavigator(index,endVal){
		
			hideAll(endVal);
		
		initObj = document.getElementsByName("linId");
		
		if(initObj.length > 0){
			
			for(var i = 0 , len = initObj.length ; i < len ; i ++ ){
				
				initObj[i].style.color = defaultColor;
			}
			
	}
		
		obj = document.getElementById("linId"+index);
		if(obj != null) obj.style.color = setColor;
		
		document.getElementById("tariffDivId"+index).style.display="block";
	}
   
  /* function layerIndexNavigator(index,endVal){
		
			hideAll(endVal);
		
		document.getElementById("tariffDivId"+index).style.display="block";
	}
   */
   function hideAll(endVal){
	
		for(var i = 1; i <= endVal ; i++){
			document.getElementById("tariffDivId"+i).style.display="none";
		}
		
	}   
	



function callPage1(form1,mode){
	
	cmbVal="";
	
	if((document.forms[0].combo[0].value == "0"))
	{
		alert("Please Select Drug Warehouse Name");
	}else{
	with(form1){
	if( mode == "INVENTORY" && document.forms[0].combo[0].value!="0" )
	{
			cmbVal =combo[0].options[combo[0].selectedIndex].text;
			comboValue.value = cmbVal;
	
	document.forms[0].hmode.value="INVENTORY";
	document.forms[0].submit();
			}
		}
	}
}


function getItemDetailHlp()
{ 
   var mode="ITEMDTL";
   
   var url="PhyStockVerificationTransCNT.cnt?hmode="+mode+"&groupId="+document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value;
   ajaxFunction(url,"1");
}

function getUnitCmbDtl(idVal){
	
	var objval = document.getElementById("strChkItemDtlTmp"+idVal);
		
		var chkBoxVal = objval.value.split('^');
		
		var strUnitValId = chkBoxVal[4];
	
   var mode="UNITCMB";
   
   var url="PhyStockVerificationTransCNT.cnt?hmode="+mode+"&unitId=2001";
      
   ajaxFunction(url,"4");
}


	function getItemBrandCmbDtl(idVal){
	
	var objval = document.getElementById("strChkItemDtlTmp"+idVal);
		
		var chkBoxVal = objval.value.split('^');
		
		var strItemValId = chkBoxVal[1];
	
	var mode="ITEMBRANDCMB";
   
    var url="PhyStockVerificationTransCNT.cnt?hmode="+mode+"&itemId=20100026";
     
   ajaxFunction(url,"5");
}


function getCountedItemDtl(obj){
		
	var mode="GETCOUNTEDITEMLIST";
   
    var url="PhyStockVerificationTransCNT.cnt?hmode="+mode+"&strStoreId="+document.forms[0].strStoreId.value+"&strPhyStockNo="+document.forms[0].strPhysicalStockNo.value+"&strGroupId="+obj.value;
          
   ajaxFunction(url,"6");
}



function getPhysicalStockVerifyCount(itemCat , storeId){
	
	
	var mode="GETPHYSTOCKVERIFIED";
   
    var url="PhyStockVerificationTransCNT.cnt?hmode="+mode+"&strItemCategoryId="+itemCat+"&strStoreId="+storeId;
     
   myAjaxFunction(url,"1" , "getMyPhyStockAjaxResponse");
}


	var gblIdVal = "";
function onCounQtyAjax(i){

	 if(document.getElementById("strChkItemDtl"+i).checked)
	 {

	gblIdVal = i;

	document.forms[0].strCurrentCountDtl.value = i;

        var objVal = document.getElementById("strChkItemDtl"+i).value;
   
   		var objval1 = document.getElementById("strChkItemDtlTmp"+i);
		var chkBoxVal = objval1.value.split('^');
		
		var storeId = chkBoxVal[0];
		var itemId = chkBoxVal[1];
		var groupId = document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value
	
		document.getElementById("itemNameId").innerHTML = chkBoxVal[5];
	
    
   var mode="COUNTEDDETAIL";
   var url="PhyStockVerificationTransCNT.cnt?hmode="+mode+"&storeId="+storeId+"&itemId="+itemId+"&grpId="+groupId+"&index="+i;
     
   ajaxFunction(url,"2");

	 }else{
	 	
	 	alert("First Select the Record Corresponding to + sign");
	 }

}

function addNewDtl()
{
	var hisValidator = new HISValidator("physicalStockVerificationBean");
  	hisValidator.addValidation("strItemBrandId", "dontselect=0","Select Brand Name From Brand Name Combo!!!");
    hisValidator.addValidation("strBatchSerialNo", "req","Enter Batch / Serial No!!!");
    hisValidator.addValidation("strCountedQuantity", "req","Enter Counted Qty!!!");
    hisValidator.addValidation("strUnitId", "dontselect=0","Select Unit Name From Unit Name Combo!!!");
    var retVal = hisValidator.validate();
      
      hisValidator.clearAllValidations();   
         
 	if(retVal){
	  
	  
	  
	  displayAddedDetails();
	    
	}else{
		
		return false;
	}
}


 /**
  * displayAddedDetails 
  */
  function displayAddedDetails() {
  	
  		var brandId 	= document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value;
  		var brandName 	= document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].text;
  		
  		var batchSlNo 	= document.forms[0].strBatchSerialNo.value;
  		var countedQty  = document.forms[0].strCountedQuantity.value;	
  		
  		var unitId 		= document.forms[0].strUnitId[document.forms[0].strUnitId.selectedIndex].value;
  		var unitName 	= document.forms[0].strUnitId[document.forms[0].strUnitId.selectedIndex].text;
  	
  	
  		var hiddenVal =  brandId+"^"+batchSlNo+"^"+0+"^"+unitId+"^"+countedQty+"^"+unitId;
  	  	
  		addRows(new Array('strChkCountedDtl'),new Array('c'),'1','1','R');
  		
  		var delIndex = "1-"+document.multirow.rowIndex1.value;
  		
  		
  		document.getElementById("strChkCountedDtl"+delIndex).value = hiddenVal;
  		document.getElementById("brandNameDivId"+delIndex).innerHTML = brandName;
  		document.getElementById("batchSlNoDivId"+delIndex).innerHTML = batchSlNo;
  		document.getElementById("inHandQtyDivId"+delIndex).innerHTML = "0 "+unitName;
  		document.getElementById("countQtyDivId"+delIndex).innerHTML = countedQty+" "+unitName;
  		  	 		
  	  	document.forms[0].strItemBrandId.selectedIndex = 0;
  	  	document.forms[0].strBatchSerialNo.value = "";	
  	  	document.forms[0].strCountedQuantity.value = "";
  	  	document.forms[0].strUnitId.selectedIndex = 0;
  	  		  		  		
  }


function getAjaxResponse(res,mode)
{
      var err = document.getElementById("errMsg");
      var temp = res.split("####");
   
       if(temp[0] == "ERROR"){
          	err.innerHTML = temp[1];
          	return;
       } 
       
       if(mode=="2"){
	       var objVal2 = document.getElementById("countedDtlID");
	       objVal2.innerHTML = res;
	       
	       getUnitCmbDtl(gblIdVal);
     	}
           
    if(mode=="4"){
       var objVal4 = document.getElementById("unitDivID");
       objVal4.innerHTML ="<select name='strUnitId' class='comboNormal'>"+res+"</select>";
      	getItemBrandCmbDtl(gblIdVal);
     }
     
      if(mode=="5"){
       var objVal5 = document.getElementById("brandDivId");
       objVal5.innerHTML ="<select name='strItemBrandId' class='comboNormal'>"+res+"</select>";
      
       popup('newdetailsdivid' , '120','200');
      
    }
     
         
       if(mode=="6"){
       var objVal5 = document.getElementById("countedItemDetails");
       objVal5.innerHTML =res;
            
    }   
      if(mode=="7")
     {			
		
		document.getElementById("batchWiseId").innerHTML=res
		display_popup_menu(parentObj,'batchWiseId','300','');
		
	 }
         
}

function closeItemPopUp(divId)
{
 	hide_popup_menu(divId);
}

  
     
     /**
      * getMyAjaxResponse
      * @param {String} res
      * @param {String} mode
      */
      function getMyPhyStockAjaxResponse(res,mode) {
      	
      	 if(mode == "1"){
     	
     	var val = parseInt(res);
     	
     		if(val > 0){
     			alert("Physical Stock Verification Can not be done, \n Verification is Already in Process for Category "+document.forms[0].combo[1][document.forms[0].combo[1].selectedIndex].text);
 				return false;
 				
     		}else{
     			
     			add(gblModeVal);
     			
     		}
     		
     	
     }
      	
      }
     
     
 // function on save POP UP
     
 function onSave(){
   
   	var chkDtls = document.getElementsByName("strChkCountedDtl");
   	var delCount = parseInt("0");
   	
   	var totStockInHand = parseFloat("0");
   	var totCount = parseFloat("0");
      	
   	var currentCountId = document.forms[0].strCurrentCountDtl.value;
   	
   	var countValues =  document.getElementById("strChkItemDtlTmp"+currentCountId).value;
   	
   	
   	
   	var totRate    = parseFloat(countValues.split('^')[6]);
   	var baseUnitVal = parseFloat(countValues.split('^')[7]);
   	     	   	
   	for(var i=0, stop= chkDtls.length - 1; i<stop; i++) {
   		
   		if(chkDtls[i].checked){
   			
   			delCount = delCount + 1;
   			
   		}else{
   			if(countValues.length > 1){
   				
   				countValues = countValues + "@"+chkDtls[i].value;
   				
   			}else{
   				countValues = chkDtls[i].value;
   			}
   			   	  			   	
   			 totStockInHand = totStockInHand + parseFloat(chkDtls[i].value.split('^')[2]); 	
   			  totCount = totCount + parseFloat(chkDtls[i].value.split('^')[5]);   	
			   			   			
   		}
   		
   	}
 
   	
   	if(delCount == chkDtls.length){
   		
   		alert("Please Add Details");
   		return false;
   	}
   	
   	
   	var variance  = totCount - totStockInHand;
	var varianceCost = ((variance * totRate)/baseUnitVal);
   	 	
   	 	document.getElementById("strChkItemDtl"+currentCountId).value = countValues;
   				document.getElementById("plus"+currentCountId).innerHTML = totCount;
  			 	document.getElementById("variance"+currentCountId).innerHTML = variance;
   				document.getElementById("strVariance"+currentCountId).value = variance;
   				document.getElementById("varianceCost"+currentCountId).innerHTML = varianceCost;
  			 	document.getElementById("strVarianceCost"+currentCountId).value = varianceCost;
  			 	document.getElementById("status"+currentCountId).innerHTML = "Done";
   	 
   
	cancelButton();
}

 
 function cancelButton(){
	   hide_popup('newdetailsdivid');
   }


/**
 * resetItemStockDtls
 *  @param {checkbox Object} chkObj 
 * @param {String} index 
 */
 function resetItemStockDtls(chkObj, index) {
 	
 	if(chkObj.checked == false){
 		
 		var flg = confirm("Data will be Lost, Are you Sure?");		
 		if(flg){
 			
 			document.getElementById("strVariance"+index).disabled = false;
 		 	document.getElementById("strVarianceCost"+index).disabled = false;
 			
		 	document.getElementById("strChkItemDtl"+index).value = document.getElementById("strChkItemDtlTmp"+index).value;
		   	document.getElementById("plus"+index).innerHTML = "<img src='../../hisglobal/images/plus.gif' style='cursor:pointer;cursor:pointer' onclick='onCounQtyAjax(\""+index+"\");'>";
		   	document.getElementById("variance"+index).innerHTML = "0";
		   	document.getElementById("strVariance"+index).value = 0;
		   	document.getElementById("varianceCost"+index).innerHTML = "0.00";
		   	document.getElementById("strVarianceCost"+index).value = 0;
		   	document.getElementById("status"+index).innerHTML = "";
 			
 			resetMultiRow('1');
 			
 		}else{
 			
 			chkObj.checked = true;
 			
 		}
 		
 		
 	}else{
 		
 			document.getElementById("strVariance"+index).disabled = true;
 		 	document.getElementById("strVarianceCost"+index).disabled = true;
 	}
 	
 }


 
function GetIndex(index,endVal)
{
		  for(var i = 1; i <= endVal ; i++)
		  {
			  document.getElementById("DivId"+i).style.display="none";
		  }
		  document.getElementById("DivId"+index).style.display="block";
}    



	 /**
	  * showView
	  * @param {String} divId 
	  */
	  function showView(divId) {
	  	
	  	document.getElementById(divId+"PlusId").style.display = "none";
	  	document.getElementById(divId+"MinusId").style.display = "block";
	  	
	  	document.getElementById(divId).style.display = "block";
	  	
	  }
	 	 
	 	 
	 /**
	  * hideView
	  * @param {String} divId 
	  */
	  function hideView(divId) {
	  	
	  	document.getElementById(divId+"PlusId").style.display = "block";
	  	document.getElementById(divId+"MinusId").style.display = "none";
	  	
	  	document.getElementById(divId).style.display = "none";
	  	
	  }	 
	 

	/**
	 * getCountedItemBatchDetails
	 * @param {String} genItemId
	 * @param {String} itemId
	 * @param {String} index   
	 */
	 function getCountedItemBatchDetails(obj,genItemId ,itemId , index) {
	 	
	 	 document.getElementById("searchItemsDtlsDivId").style.display = "none";
	 	  document.getElementById("stockDtlsDivId").style.display = "block";
	 	  
	 	  parentObj=obj;
	 	 var  strId=document.forms[0].strStoreId.value;
	 	  var strStockNo=document.forms[0].strPhysicalStockNo.value;
	 	  var mode="BATCHWISEDTL";
	 	 var url="PhyStockVerificationTransCNT.cnt?hmode="+mode+"&strId="+strId+"&stockNo="+strStockNo+"&itemId="+genItemId+"&itemBrandId="+itemId;
  		ajaxFunction(url,"7");	 
  		
		/*	getStockDtls("3", "0", genItemId, itemId, "", "", 
						document.forms[0].strStoreId.value, document.getElementsByName("strItemCategoryId")[0].value, "0", "", "strCountedItemBatchDtls"+index);*/
				
	 	
	 }
	 
	
	  function getToBeCountedItemBatchDetails(index) 
	  {
	 	
	 		 var countedValue="";
	 		 var tempArray;
	 		document.getElementById("searchItemsDtlsDivId").style.display = "none";
	 		document.getElementById("stockDtlsDivId").style.display = "block";
	 		indexPersist=index;
	 	 	var genItemId = document.getElementById("itemParamValue"+index).value.split('^')[17];
	 	 	var itemId = document.getElementById("itemParamValue"+index).value.split('^')[18];
	 	 	//  This Method is in stockDetails.js 
	 	 	//function getPhyVerifyStockDtls(strMode, strStockStatus, strGenItemId, strItemId, 
			//strStoreId, strCatCode, strReservedFlag, strUnitName ,strUserHiddenFieldId , strUserDefinedFuncName , strUserDefinedArg) {
	 	 	var strMode = "3^"+"0"+"^"+index;
	 	 	
	 	 	getPhyVerifyStockDtls
	 	 	(
	 	 	   strMode,
	 	 	   "0",
	 	 	    genItemId, 
	 	 	    itemId,
				document.forms[0].strStoreId.value, 
				document.getElementsByName("strItemCategoryId")[0].value, 
				"0", 
				"", 
				"strToBeCountedItemBatchDtls"+index , 
				"calculatedCountedValues" , ""+index+""
			);
	 }
	 
	   var gblCost=0.00;
	   var localCountedItem="";
	  /**
	   * calculatedCountedValues
	   * @param {String} index 
	   */
	   function calculatedCountedValues(index) {
	   	
	    var countedQty=0; 
	    var avalQty="";	
	    var avalQtyBaseVal="";
	    var rate;
	    var itemParamValue="";
	    var variance;
	    var varianceCost="";
	    var tolerancelimit;
	    var countedCondition;
	    var varianceCostLength;
	    var unitName="";
	    var countedValue="";
	   	var varianceTotal=0.00;
	   	var varianceCostTotal=0.00;
	   	 var avalQtyInBaseVal="";
	    countedValue=document.getElementById("strToBeCountedItemBatchDtls"+index).value;
	   
	   	itemParamValue=document.getElementById("itemParamValue"+index).value;
	   	var strStockDtlsChk=document.getElementsByName("strStockDtlsChk");
		tempArray=itemParamValue.split("^");
		avalQty=tempArray[1];
		avalQtyBaseVal=tempArray[4];
		unitName=tempArray[3];
		tolerancelimit=tempArray[5];
		
		
		for(var i=0;i<strStockDtlsChk.length;i++){
			
				var tempArray1=strStockDtlsChk[i].value.split("^");
				var avalQty=tempArray1[14]*tempArray1[16];
				rate=tempArray1[15];
				var temp=document.getElementsByName("strAvailableQtyUnit")[i].value.split("^");
				var countedQty=parseFloat(document.getElementsByName("strAvailableQty")[i].value)*parseFloat(temp[1]);
				variance=manipulateValue(parseFloat(countedQty),parseFloat(avalQty),1);
				varianceCost=parseFloat(variance)*parseFloat(rate);
				varianceTotal=roundValue(manipulateValue(varianceTotal,parseFloat(variance),0),2);
				varianceCostTotal=roundValue(manipulateValue(varianceCostTotal,parseFloat(varianceCost),0),2);
			
		}
		tempArray=countedValue.split("#");
		countedQty=0.00;
		for(var i=0;i<tempArray.length;i++){
			var tempArray1=tempArray[i].split("^");
			avalQty=tempArray1[14]*tempArray1[16];
			
			var countUnitQty=parseFloat(tempArray1[17]);
			var countBaseQty=parseFloat(tempArray1[19]);
			var countValInBase=countUnitQty*countBaseQty;
			
			countedQty=parseFloat(countedQty)+countValInBase;
			//countedQty=manipulateValue(countedQty,countValInBase,0);
		
			countedQty=roundValue(countedQty,2);
			
		}
		
		itemParamValue=document.getElementById("itemParamValue"+index).value;
		
	   	tempArray=itemParamValue.split("^");
		avalQty=tempArray[1];
		avalQtyBaseVal=tempArray[4];
		unitName=tempArray[3];
		tolerancelimit=tempArray[5];
		
		document.getElementById("itemParaId2"+index).innerHTML=tempArray[1]+" "+unitName;
		
		document.getElementById("itemParaId6"+index).innerHTML=tempArray[5]+" %";
		countedQty=parseFloat(countedQty)/parseFloat(avalQtyBaseVal);
		varianceTotal=parseFloat(varianceTotal)/parseFloat(avalQtyBaseVal);
		avalQtyInBaseVal=parseFloat(avalQty)*parseFloat(avalQtyBaseVal);
		var avalQtyInBaseValTolerance=(avalQtyInBaseVal*tolerancelimit)/100;
		countedCondition=avalQtyInBaseVal-avalQtyInBaseValTolerance;
		if(parseFloat(countedCondition)>parseFloat(countedQty)){
			
			document.getElementById("strCountedDivId"+index).innerHTML="<font color='red'>"+countedQty+" "+unitName+"</font>";
		}else{
			document.getElementById("strCountedDivId"+index).innerHTML=countedQty+" "+unitName;
		}
		if(isNaN(document.getElementById("strVarianceCost"+index).value)){
			document.getElementById("strVarianceCost"+index).value="0.00";
		}
		varianceCostLength=document.getElementsByName("strVarianceCost").length;
	
		
		document.getElementById("strCountedQty"+index).value=countedQty;
   		document.getElementById("strVarianceDivId"+index).innerHTML=varianceTotal+" "+unitName;
   		document.getElementById("strVarianceQty"+index).value=varianceTotal;
   		document.getElementById("strVarianceCostDivId"+index).innerHTML=varianceCostTotal;
   		document.getElementById("strVarianceCost"+index).value=varianceCostTotal;
   		
   		gblCost=0.00;
   		
   		for(var i=0;i<varianceCostLength-1;i++){
			if(isNaN(document.getElementsByName("strVarianceCost")[i].value)){
			document.getElementsByName("strVarianceCost")[i].value="0.00"
			}
			gblCost=roundValue(manipulateValue(gblCost,parseFloat(document.getElementsByName("strVarianceCost")[i].value),0),2);
		}
   		document.getElementById("strVarianceNetCostDivId").innerHTML=gblCost;
   	 	document.getElementsByName("strVarianceNetCost")[0].value=gblCost;	
   }
	  
	  
 function cancelPhyStockStockDetails(){
 	var varianceCostLength;
 	var gblCost=0.00;
	
	
	document.getElementById("strCountedQty"+indexPersist).value="0.00";
	document.getElementById("strCountedDivId"+indexPersist).innerHTML="0.00";
	document.getElementById("strVarianceDivId"+indexPersist).innerHTML="0.00";
	document.getElementById("strVarianceQty"+indexPersist).value="0.00";
	document.getElementById("strVarianceCost"+indexPersist).value="0.00";
	document.getElementById("strVarianceCostDivId"+indexPersist).innerHTML="0.00";
	
	
	varianceCostLength=document.getElementsByName("strVarianceCost").length;
	
	for(var i=0;i<varianceCostLength-1;i++){
			if(isNaN(document.getElementsByName("strVarianceCost")[i].value)){
			document.getElementsByName("strVarianceCost")[i].value="0.00"
			}
			gblCost=roundValue(manipulateValue(gblCost,parseFloat(document.getElementsByName("strVarianceCost")[i].value),0),2);
		}
	document.getElementById("strVarianceNetCostDivId").innerHTML=gblCost;
 	document.getElementsByName("strVarianceNetCost")[0].value=gblCost;	
}
	  
	 function getItemSelectPopup()
	{
	 
	 document.getElementById("stockDtlsDivId").style.display = "none";
	  document.getElementById("searchItemsDtlsDivId").style.display = "block";
	 	 	
	    var strModeVal 					= "4" ; 
		var strRequestType              = "69";
		var strItemCategory 			= document.getElementsByName("strItemCategoryId")[0].value;
		var strFromStoreId 				= document.forms[0].strStoreId.value;
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strCountedQty','strVarianceQty','strVarianceCost' , 'strToBeCountedItemBatchDtls');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t','t','t', 't');
		var testFunction                = "testFunc";
		var arg                         = "0";  
		
		var userVal = document.forms[0].strPhysicalStockNo.value;
		
		var strMultiRowFetchDataArray 	= new Array('1','2','6' );
		    
	    var layerIndex = "1";
	

        searchItems( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex , userVal);
       
             
	  }
	  function validate1(){
	  
	   	var length=document.getElementsByName("strCountedQty").length;
	  	var flag=true;
	 	if(document.getElementsByName("itemParamValue").length>1){
	  		if(length==1){
	  			if(document.getElementsByName("strCountedQty")[0].value=="0.00"){
	  				flag=false;
	  			}else{
	  				flag=true;
	  			}
	  		}else{
	  			 	for(var i=0;i<length;i++){
	  			 		if(document.getElementsByName("strCountedQty")[i].value=="0.00"){
	  			 			flag=false
	  			 		}else{
	  			 				flag=true;
	  			 				break;
	  			 		}
	  			 	}
	  		}
	  		if(flag==false)
	  		{
	  			alert('Please Enter Counted Quantity');
	  		}
	  		else
	  		{
	  			                                    var conf = confirm("You Are Going To Save Records" );
							                       if(confirm(" Are You Sure ?"))
												   {
														 document.forms[0].hmode.value = "SAVE";
                                                         document.forms[0].submit();
										           }
										           else
										           {
										             return false;
										           } 
					 
	  		}
	 	}else{
	 				
	 				  var conf = confirm("You Are Going To Save Records" );
							                       if(confirm(" Are You Sure ?"))
												   {
														 document.forms[0].hmode.value = "SAVE";
                                                         document.forms[0].submit();
										           }
										           else
										           {
										             return false;
										           } 
	 	}
	  
	  	
	  }
function chkUserDefinedFunc(these){
	var checkCount=0;
	var storeId="";
	var itemCateg="";
	var recordStatus="";
	var check=document.getElementsByName("chk");
	
	storeId=document.getElementsByName("combo")[0].value;
	itemCateg=document.getElementsByName("combo")[1].value;
	recordStatus=document.getElementsByName("combo")[2].value;
	for(i=0;i<check.length;i++){
		if(check[i].checked==true){
			checkCount++;
			//alert(check[i].value);
			temp=check[i].value;
			approved=temp.split("@");
		}			
	}
	if(checkCount==0){
			disableButton("Review");
			disableButton("Stock Update");
			disableButton("Cancel");
			disableButton("View");
			
	}
	if(checkCount>0 && storeId!="0" && itemCateg!="0")
	 	enableButton("View");
	if(checkCount>0 && storeId!="0" && itemCateg!="0" && recordStatus=="0"){
		
		enableButton("Review");
		enableButton("Cancel");
		
	}else if(checkCount>0 && storeId!="0" && itemCateg!="0" && recordStatus=="3"){
		
		enableButton("Stock Update");
	}
}
	  
function buttonLogicsOnClickReview(){
	document.forms[0].comboValue.value=document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text+"@"+
										document.forms[0].combo[1].options[document.forms[0].combo[1].selectedIndex].text;
	document.forms[0].hmode.value="REVIEW";
	document.forms[0].submit();
}	 
function buttonLogicsOnClickView(){
	document.forms[0].comboValue.value=document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text+"@"+
										document.forms[0].combo[1].options[document.forms[0].combo[1].selectedIndex].text;
	document.forms[0].hmode.value="VIEW";
	document.forms[0].submit();
}	 

function validateCancel()
{
	var flag=false;
	var res=prompt("ENTER REMARKS FOR CANCELATION!","");
	if(res!="")
	{
		flag=confirm("Are you sure to cancel");
		if(flag)
		{
			document.forms[0].comboValue.value=res;
			document.forms[0].hmode.value="CANCELSTOCK";
			document.forms[0].submit();
		}
	}
}
function updateStock()
{
	var flag=false;
	var res=prompt("Enter Remarks For Stock Update","");
	if(res!="")
	{
		flag=confirm("Are You Sure to Upadte the Stock");
		if(flag)
		{
			document.forms[0].comboValue.value=res;
			document.forms[0].hmode.value="UPDATESTOCK";
			document.forms[0].submit();
		}
	}
}
	 