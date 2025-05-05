/**
 * myAjaxFunction - used to get the response text of a ajax call in asynchornes
 * mode
 * 
 * @param {String}
 *            myurl - required url
 * 
 */
function myAjaxFunction(myurl) {

	var result = "";
	myurl = createFHashAjaxQuery(myurl);
	// checking browser
	if (navigator.userAgent.indexOf("Opera") >= 0) {
		alert("This example doesn't work in Opera");
		return;
	}
	if (navigator.userAgent.indexOf("MSIE") >= 0) {
		var strName = "Msxml2.XMLHTTP"
		if (navigator.appVersion.indexOf("MSIE 5.5") >= 0) {
			strName = "Microsoft.XMLHTTP"
		}
		try {
			objXmlHttp = new ActiveXObject(strName)
			objXmlHttp.onreadystatechange = function() {
				if (objXmlHttp.readyState == 4 || objXmlHttp.readyState == 200) {
					result = objXmlHttp.responseText;
				}

			}
		} catch (e) {
			alert("Error. Scripting for ActiveX might be disabled");
			return;
		}
	} else {
		if (navigator.userAgent.indexOf("Mozilla") >= 0) {
			objXmlHttp = new XMLHttpRequest();
			objXmlHttp.onload = function() {
				if (objXmlHttp.readyState == 4 || objXmlHttp.readyState == 200) {
					result = objXmlHttp.responseText;
				}

			}
			//objXmlHttp.onerror=sendMyReq
		}
	}

	objXmlHttp.open("GET", myurl, false)
	objXmlHttp.send(null)

	return result;

}


function searchInSelectedItemList(cmbBrandObj){
	
	var flag = false;
	
	 	
	for(var i = 0 ; i < cmbBrandObj[0].length ; i ++){
			
		if(cmbBrandObj[0].options[i].selected == true && searchInListBox("strSelectedItemList",
				cmbBrandObj[0].options[i].text)){
			
				alert("Selected Branded Item '"+cmbBrandObj[0].options[i].text+"' Already Exists");
			
			return true;
			
		}
				 
		
	}
		
	return flag;	
		
}



/**
 *  shift the brand items to the right hand side.
 * @param mode 1 >> Items without parameters
 * 			   2 >> Items with Stock Details
 * 			   3 >>
 * @return
 */
function shiftToRightLogic(mode) {

	var cmbItemObj = document.getElementsByName("strItemList");
	var cmbBrandObj = document.getElementsByName("strBrandedItemList");
	
	 
	
	//var val = cmbBrandObj[0][cmbBrandObj[0].selectedIndex].value;

	if (mode == 1 || mode == 3) {

		//cmbBrandObj[0][cmbBrandObj[0].selectedIndex].value = cmbItemObj[0][cmbItemObj[0].selectedIndex].value + "#" + val;

		if(cmbBrandObj[0][cmbBrandObj[0].selectedIndex] == null){
			alert("Branded Item Not Available");
			return false;
		}

		if ( !searchInSelectedItemList(cmbBrandObj)) {

			shiftToRight('strBrandedItemList', 'strSelectedItemList', 0);
		} else {

			return false;
		}

	 		
	} else {

	
		if(cmbBrandObj[0][cmbBrandObj[0].selectedIndex] == null){
			alert("Branded Item Not Available");
			return false;
		}
	

			if ( !searchInSelectedItemList(cmbBrandObj)) {

			shiftToRight('strBrandedItemList', 'strSelectedItemList', 0);

		} else {

			return false;
		}

	}

}



function selectItemsInPopup(e) 
{
 	
  try{
 	
 //	alert("inside searchItemsInPopup");
 
 	if(e.keyCode == 13){
 		
 		shiftToRightLogic(gblMode);
 		 
 		return;
 		
 	}
 		
  }catch(err){
  	alert(err);	
  }
}

 
/**
 * shifts the items to right hand side.
 * @param mode 1 >> Items without parameters
 * 			   2 >> Items with Stock Details
 * 			   3 >>
 * @return
 */
function itemShiftToRightLogics(mode) {

	var cmbItemObj = document.getElementsByName("strItemList");

	// alert("item : "+cmbItemObj[0][cmbItemObj[0].selectedIndex].value);

	
	if (cmbBrandObj[0][cmbBrandObj[0].selectedIndex] != null && !searchInListBox("strSelectedItemList",
			cmbItemObj[0][cmbItemObj[0].selectedIndex].text)) {

		shiftToRight("strItemList", "strSelectedItemList", 0);

	} else {

		alert("Selected Item Already Exists");
		return false;
	}

}

 
 /**
  * used to shift Items from Right (Selected) List to Left List
  * @param mode 1 >> Items without parameters
  * 			2 >> Items with Stock Details
  * 			3 >>
  * @return
  */
function shiftToLeftLogic(mode) {

	shiftToLeft("strBrandedItemList", "strSelectedItemList", 0);

	/*
	 * var cmbObj = document.getElementsByName("strSelectedItemList");
	 * 
	 * var val = cmbObj[0][cmbObj[0].selectedIndex].value;
	 * 
	 * if (mode == 1 || mode == 3) {
	 * 
	 * if (val.indexOf('#') == -1) {
	 * 
	 * shiftToLeft("strItemList", "strSelectedItemList", 0);
	 *  } else {
	 * 
	 * var temp = val.split("#");
	 * 
	 * cmbObj[0][cmbObj[0].selectedIndex].value = temp[1];
	 * 
	 * shiftToLeft("strBrandedItemList", "strSelectedItemList", 0);
	 *  }
	 *  } else if (mode == 2) {
	 * 
	 * shiftToLeft("strItemList", "strSelectedItemList", 0);
	 *  }
	 */

}

 
/**
 *  used to search a Record from a List Box 
 *  
 * @param e onkeyup event 
 * @param obj Text Box Object 
 * @param mode 0 : generic Item List Box
  * 		   1 : selected Item List Box 	
 * @return
 */
function searchList(e, obj, mode) {
	var ret;

	if (e.keyCode == 13) {
		if (mode == 0) {
			ret = searchInListBox("strSearchLeftList", obj.value);
		} else {
			ret = searchInListBox("strSelectedItemList", obj.value);
		}
		ret = !ret;
	}
	return ret;
}


/**
 * setSelectedIndexValue
 * @param {}  
 */
 function setSelectedIndexValue() {
 	
 	gblItemSelectedIndex = -1;
 	
 }


/**
 * searchItemsInPopup
 * @param {Object} e 
 * @param {Object} txtObj
 */
 
 var gblItemSelectedIndex = -1;
 
 function searchItemsInPopup(e , txtObj) {
 	
  try{
 	
 //	alert("inside searchItemsInPopup");
 
 	if(e.keyCode == 13){
 		
 		shiftToRightLogic(gblMode);
 		txtObj.value = "";
 		return;
 		
 	}
 		
 
 	
 	var searchMode = document.forms[0].strSearchLeftOption[document.forms[0].strSearchLeftOption.selectedIndex].value;
 	
  
 	 
 	
 	var value = txtObj.value;
 	var list_name = "strBrandedItemList";
 	
 	var searchType = 0;
 	
 	if(value.indexOf("%") == 0 ){
 		
 		if(value.length == 1)
 			gblItemSelectedIndex = -1;
 		
 		searchType = 1;
 		
 		value = value.substring(1);
 	}
 	
 	 
 	
 	if( value != "" )
	{ 
			
			//getting object
			lobj = document.getElementsByName(list_name);
			
		 
			
			
			if(lobj.length > 0)		//list box exists
			{
				
		 
			
				
			
			if(e.keyCode == 40){ // down arrow key code
				
				init = parseInt(gblItemSelectedIndex) + 1 ;	
				total = lobj[0].length;
				
				searchItemListValues(init , total , lobj , value , searchMode , searchType , 2 );
					
			}else if (e.keyCode == 38){ // up arrow key code 
				
				  			
				 init = parseInt(gblItemSelectedIndex) - 1 ;	
				 total = 0;
					
				searchItemListValues(init , total , lobj , value , searchMode , searchType , 3 );	
					
			}else{
				
				var init = 0;
				var total = lobj[0].length;
				
			 
				
				searchItemListValues(init , total , lobj , value , searchMode , searchType , 1 );
				
			}
			 				
			}// end of lobj.length if 
		
		 
		
	}
 	
  }catch(err){
  	alert(err);	
  }
  
  
 	
 }


/**
 * searchItemListValues
 * @param {String} init - for init value
 * @param {String} total - for total value
 * @param {Object} lobj -  list object value 
 * @param {String} searchMode -  1 - Search by Name, 2 - Search by Code and 3 - Search by Batch No.
 * @param {String} value - Search Value 
 * @param {String} searchType - 0 - Direct Search, 1 - Search with %
 * @param {String} mode -  1 - Normal , 2 - when down key pressed , 3 - when up key pressed
 */
 function searchItemListValues(init , total , lobj , value , searchMode , searchType , mode ) {
 	
 	var listValue ;
 		
 		
 		
 		
 	if(mode == 3)
 	{
 		
 		for(i = init ;i >= total;i -- )
 		{
					
					//alert("i :: "+i);
					
					if(searchMode == 1)
					{
						
							listValue = (lobj[0].options[i].text).toUpperCase();
						
					}
					else if(searchMode == 2)
					{							
						 var listTempVal = lobj[0].options[i].value.split('^');						 
						 if(gblMode == 1 || gblMode == 3)
						 {
						 	
						 	listValue = ( listTempVal[58] ).toUpperCase();
						 	
						 }
						 else 
						 if(gblMode == 2)
						 {
						 	
						 	listValue = ( listTempVal[13] ).toUpperCase();
						 	
						 }
						 else
						 {
						 	
						 	listValue = ( listTempVal[27] ).toUpperCase();
						 	
						 }
						
						 						
					}else {
						
						
						 var listTempVal = lobj[0].options[i].value.split('^');						 
						 if( gblMode == 3)
						 {
						 	
						 	listValue = ( listTempVal[36] ).toUpperCase();
						 	 
						 }
					 						 						
						
					}
					
				 
					 					
					if(searchType == 1){
							
						if (listValue.indexOf((value.toString()).toUpperCase()) >= 0){	//matched
						lobj[0].selectedIndex = i;
						retValue = true;
						
						setItemName(lobj[0]); 
						 
						gblItemSelectedIndex = i;
						
						break;
					}
						
					}else{
						 
					
						
						if (listValue.indexOf((value.toString()).toUpperCase()) == 0){	//matched
						lobj[0].selectedIndex = i;
						retValue = true;
						
						setItemName(lobj[0]); 

						gblItemSelectedIndex = i;						 					
						 						
						break;
					}
						
					}
					
					
				} // end of for 
 	
 		 		
 	}
 	else
 	{
 		
 		for(i = init ;i< total;i++){
					
					//alert("i :: "+i);
					
					if(searchMode == 1)
					{
						
							listValue = (lobj[0].options[i].text).toUpperCase();
						
					}
					else if(searchMode == 2)
					{								 
						var listTempVal = lobj[0].options[i].value.split('^');
						 
						 
						 if(gblMode == 1 || gblMode == 3){
						 	
						 	listValue = ( listTempVal[58] ).toUpperCase();
						 	
						 }else if(gblMode == 2){
						 							 	 					 	 						 	
						 	listValue = ( listTempVal[12] ).toUpperCase();
						 	
						 }else{
						 	
						 	listValue = ( listTempVal[27] ).toUpperCase();
						 	
						 }
						 
													
					}else {
						
						
						var listTempVal = lobj[0].options[i].value.split('^');
						 
						 
						 if(gblMode == 3){
						 	
						 	listValue = ( listTempVal[36] ).toUpperCase();
						 	 
						 }
						  	
					}
					
				 
					 					
					if(searchType == 1)
					{
						
						if (listValue.indexOf((value.toString()).toUpperCase()) >= 0){	//matched
						lobj[0].selectedIndex = i;
						retValue = true;
						
						setItemName(lobj[0]); 
						 
						gblItemSelectedIndex = i;
						
						break;
					}
						
					}
					else
					{						
						if (listValue.indexOf((value.toString()).toUpperCase()) == 0)
						{	//matched
						 lobj[0].selectedIndex = i;
						 retValue = true;
						 setItemName(lobj[0]); 
						 gblItemSelectedIndex = i;						 					
						 						
						 break;
					}
						
					}
					
					
				} // end of for 
 	
 		
 	}
 	 
 	
 }



 
/**
 * setItemStockParameters - function used to display the stock parameters present in the item & brand
 * 
 * for gblMode 1 >> Items without parameters (here there is no special details available)
 * 			   2 >> Items with Stock Details (value with stock details)
 * 			   3 >>
 * 
 * @param cmbObj value with appended item stock parameters.
 * @return
 */
function setItemStockParameters(cmbObj) {

	// alert(cmbObj.value);

	if (gblMode == '2') {

		var strVal = cmbObj.value.split('#');
		
		var temp0 = strVal[0].split('^');
		var temp1 = strVal[1].split('^');
		var temp2 = strVal[2].split('^');
		
		document.getElementById("stockParamSpecificationDivId").innerHTML = temp0[1];
		document.getElementById("stockParamLastRateUnitDivId").innerHTML = temp0[2];
		
		
	}

	if (gblMode == '3') {

		var strVal = cmbObj.value.split('#');
		
		var temp0 = strVal[0].split('^');
		var temp1 = strVal[1].split('^');
		var temp2 = strVal[2].split('^');
		
		document.getElementById("stockParamSpecificationDivId").innerHTML = temp0[1];
		document.getElementById("stockParamReOrderDivId").innerHTML = temp0[2];
		

		document.getElementById("purchaseStockInHandDivId").innerHTML = temp0[3];
		document.getElementById("purchaseBatchNoDivId").innerHTML = temp0[10];
		
		if(document.getElementById("purchaseSerialNoDivId") != null)
		document.getElementById("purchaseSerialNoDivId").innerHTML = temp0[14];
		
		document.getElementById("purchaseExpiryDateDivId").innerHTML = temp0[11];
		document.getElementById("purchaseStockStatusDivId").innerHTML = temp0[16];
				

		document.getElementById("purchaseParamPoNoDivId").innerHTML = temp2[12];
		document.getElementById("purchaseParamPoDateDivId").innerHTML = temp2[13];
		document.getElementById("purchaseParamReceivedQtyDivId").innerHTML = temp0[6];
		document.getElementById("purchaseParamRateUnitDivId").innerHTML = temp0[4];
		document.getElementById("purchaseParamSuppliedByDivId").innerHTML = temp0[5];
		
	}
	
	if (gblMode == '4') {

		var strVal = cmbObj.value.split('^');
		
		document.getElementById("stockParamInHandQtyDivId").innerHTML = strVal[1] + " " + strVal[3];
		document.getElementById("stockParamReOrderDivId").innerHTML = strVal[21] + " " + strVal[23];
	
		document.getElementById("purchaseParamPONoDivId").innerHTML = strVal[7];
		document.getElementById("purchaseParamPODateDivId").innerHTML = strVal[8];
		document.getElementById("purchaseParamRateUnitDivId").innerHTML = strVal[9] + "/" + strVal[11];
		document.getElementById("purchaseParamSuppliedByDivId").innerHTML = strVal[16];
		document.getElementById("purchaseParamLastRecQtyDivId").innerHTML = strVal[12] + " " + strVal[14];
	
	}
	

}
 
/**
 * setItemBrandParameters - function used to display the brand parameters
 * 
 * @param mode 1 >> Items without parameters
 * 			   2 >> Items with Stock Details
 * 			   3 >>
 * @param brandObj value with brand details for mode 1 values are available 
 * 
 * @return
 */
function setItemBrandParameters(mode, brandObj) {

	
	//document.getElementById("newItemAddInitDivId").style.display = "none" ;
		//document.forms[0].strHiddenGenericItemId.value = "";
	
	if (mode == '1') {

		var strVal = brandObj.value.split('#');
		
		var temp0 = strVal[0].split('^');
		var temp1 = strVal[1].split('^');
		var temp2 = strVal[2].split('^');
		
		document.getElementById("stockParamSpecificationDivId").innerHTML = temp0[1];
		document.getElementById("stockParamReOrderDivId").innerHTML = temp0[2];
		document.getElementById("stockParamInHandQtyDivId").innerHTML = temp0[3];
		 
		 
		 document.getElementById("purchaseParamPoNoDivId").innerHTML = temp2[12];
		document.getElementById("purchaseParamPoDateDivId").innerHTML = temp2[13];
		document.getElementById("purchaseParamReceivedQtyDivId").innerHTML = temp0[6];
		document.getElementById("purchaseParamRateUnitDivId").innerHTML = temp0[4];
		document.getElementById("purchaseParamSuppliedByDivId").innerHTML = temp0[5];
		
		
	}

}
/**
 * resetList - reset's the list created in the parent window.
 * @return
 */
function resetList() {

	var count = parseInt("1");

	do {
		var obj = document.getElementById("id" + count)

		if (obj != null) {
			obj.innerHTML = "";
			obj.style.display = "none";
			count++;

		} else {
			break;
		}

	} while (true)

}

// Global variables used in most of the functions.

var gblStrGroupIdForItemSearch = "0"; // Group Id present at Parent window.
var gblItemCategory = "0"; // Passed by user
var gblRequestType = "0"; // Passed by user
var gblFromStoreId = "0" // Passed by user
var gblMode = "0"; // Passed by user - determines which type of Item Search
// should be display.
var gblMultiRowCompArray = null; // Passed by user
var gblMultiRowCompTypeArray = null; // Passed by user
var gblMultiRowFetchDataArray = null; // Passed by user
var gblLayerIndex = ""; // Passed by user
var gblUserInfo = ""; // passed by user
/*
 * variable Add by Amit on Date 8/5/2009 to get user define function & user
 * define Argument
 */

var gblUserFunctionName = ""; // Passed by User
var gblUserArgument = ""; // Passed by User
var gblIsQuantified = "";
var gblUnitMode = "";

/**
 * searchItems - function used to create a popup using ajax to search Items.
 * 
 * @param {String}
 *            strMode - unique mode for the Item Search Popup 1 >> Items without
 *            parameters 2 >> Items with Stock Details 3 >>
 * @param {String}
 *            strItemCat - item category code
 * @param {String}
 *            strRequestType - Request Type
 * @param {String}
 *            fromStoreId - From Store Id
 * 
 * @param {Array}
 *            strMultiRowCompArray - multirow component array (same as multirow
 *            "new Array('strName','strGender')" )
 * @param {Array}
 *            strMultiRowCompTypeArray - multirow component type array (same as
 *            multirow "new Array('t','s')" )
 * 
 * @param {Array}
 *            strMultiRowFetchDataArray - user defined array which contains the
 *            index values to be fetched. Fetch data index will represented in
 *            multirow inside td tag create a div with id
 *            (id="itemParaId17#delIndex#") like this where "17" represents
 *            "fetch data index" 11^strUnitName represents the "fetch data
 *            index" 11 and a name which represents a unit combo should be
 *            created with the value available at 11 index
 * 
 * 				11^strUnitName^testFunction represents the "fetch data
 *            index" 11 and a name which represents a unit combo should be
 *            created with the value available at 11 index and invoke the testFunction on combo change event
 * 
 * test function must be declared in the following way
 * testFunction(mode, row_index, selected_obj)
 * 
 * e.g.new Array('17','18','11^strUnitName^testFunction')
 * 
 * @param {String} layerIndex - multirow index
 * 
 * @param {String} strUserInfo - content is optional and may be pass with '^' character
 * 
 * @param (String) strUnitMode 0 >> All Units , 1 >> Only Base Unit
 * 
 */
function searchItems(strMode, strItemCat, strRequestType, fromStoreId, strMultiRowCompArray, strMultiRowCompTypeArray,
		strMultiRowFetchDataArray, layerIndex,strUserInfo , strUnitMode) {
	
	var oldStoreId = gblFromStoreId;

	gblMode = strMode;
	gblItemCategory = strItemCat;
	gblRequestType = strRequestType;
	gblFromStoreId = fromStoreId;
	gblMultiRowCompArray = strMultiRowCompArray;
	gblMultiRowCompTypeArray = strMultiRowCompTypeArray;
	gblMultiRowFetchDataArray = strMultiRowFetchDataArray;
	gblLayerIndex = layerIndex;
	
	if(strUserInfo != undefined) {
	 
 		gblUserInfo = strUserInfo;
 	}else{
 		 
 		gblUserInfo = "0";
 	}
 	
 	if(strUnitMode != undefined) {
	 
 		gblUnitMode = strUnitMode;
 	}else{
 		 
 		gblUnitMode = "0";
 	}	
 	if(strUserInfo == undefined || strUserInfo == 'undefined' )
 		{
 		strUserInfo = '0';
 		}



 	
	var statusCode = 0;

	//var cmbObj = document.forms[0].strGroupIdForItemSearch;

	var itemParaObj = document.getElementById("searchItemsDtlsDivId");

	 //alert('3');

	/*if (gblStrGroupIdForItemSearch != "0") {

			if (gblStrGroupIdForItemSearch != cmbObj.value) {
 
 				document.getElementById("itemListDivId").innerHTML = "<select onkeydown='return onPressingEnter(this,event)' tabindex='1' name='strItemList' multiple='multiple' size='5' style='width: 100%;' onchange='getBrandItemList(\"1\" , this);'></select>";
 				document.getElementById("brandItemListDivId").innerHTML = "<select onkeydown='return onPressingEnter(this,event)' tabindex='1' name='strBrandedItemList' multiple='multiple' size='5' style='width: 100%;' onchange='setItemBrandParameters(\"1\" , this);'></select>";
 
			}  

		} 
		
		gblStrGroupIdForItemSearch = cmbObj.value;

*/ 
	
		if (itemParaObj.innerHTML == "" || oldStoreId != fromStoreId) {
			//alert(strUserInfo);
			// alert('4');
			var hmode = "SEARCHITEMINIT";
			var url = "MmsCNT.cnt?hmode=" + hmode + "&strMode=" + strMode
					+ "&strGroupId=0&strFromStoreId=" + fromStoreId + "&strRequestType="
					+ strRequestType +  "&strItemCategory=" + gblItemCategory + "&strUserInfo=" + strUserInfo;
			//alert("url :"+url);
			ajaxFunction2(url, "1", "getMyAjaxResponse");

		} else {
			// set for 1024 * 760 screen don't change this
			
			popup('popUpDiv', '30', '225');
			document.forms[0].strSearchLeftList.focus();
			
		}

	 

}

//Method Create by Amit Kr on 08/05/2009 to pass user function & argument  

/**
 * searchItems - function used to create a popup using a56resassjax to search Items.
 * 
 * @param {String}
 *            strMode - unique mode for the Item Search Popup 1 >> Items without
 *            parameters 2 >> Items with Stock Details 3 >>
 * @param {String}
 *            strItemCat - item category code
 * @param {String}
 *            strRequestType - Request Type
 * @param {String}
 *            fromStoreId - From Store Id
 * 
 * @param {Array}
 *            strMultiRowCompArray - multirow component array (same as multirow
 *            "new Array('strName','strGender')" )
 * @param {Array}
 *            strMultiRowCompTypeArray - multirow component type array (same as
 *            multirow "new Array('t','s')" )
 * 
 * @param {Array}
 *            strMultiRowFetchDataArray - user defined array which contains the
 *            index values to be fetched. Fetch data index will represented in
 *            multirow inside td tag create a div with id
 *            (id="itemParaId17#delIndex#") like this where "17" represents
 *            "fetch data index" 11^strUnitName represents the "fetch data
 *            index" 11 and a name which represents a unit combo should be
 *            created with the value available at 11 index
 * 
 * 				11^strUnitName^testFunction represents the "fetch data
 *            index" 11 and a name which represents a unit combo should be
 *            created with the value available at 11 index and invoke the testFunction on combo change event
 * 
 * test function must be declared in the following way
 * testFunction(mode, row_index, selected_obj)
 * 
 * e.g.new Array('17','18','11^strUnitName^testFunction')
 * 
 * @param (String)
 *            userFunctionName - Function Name Passed by User (Added on
 *            08/05/2009)
 * @param (String)
 *            userFunctionArgument - Function Argument Passed By User (Added on
 *            08/05/2009)
 * 
 *   @param (String) strUnitMode 0 >> All Units , 1 >> Only Base Unit
 */
function searchItemsWithUserFunction(strMode, strItemCat, strRequestType, fromStoreId, strMultiRowCompArray,
		strMultiRowCompTypeArray, strMultiRowFetchDataArray, layerIndex,
		userFunctionName, userFunctionArgument ,strUserInfo , strUnitMode ) {

//alert("userFunctionName :: "+userFunctionName+" /-/ "+strMode+" /-/ "+strItemCat+strRequestType+" /-/ "+fromStoreId+" /-/ "+strMultiRowCompArray+" /-/ "+strMultiRowCompTypeArray+" /-/ "+strMultiRowFetchDataArray+" /-/ "+layerIndex+" /-/ "+layerIndex+userFunctionArgument+" /-/ "+strUserInfo+" /-/ "+strUnitMode);

var oldStoreId = gblFromStoreId;
var oldCateId = gblItemCategory;
	gblMode = strMode;
	gblItemCategory = strItemCat;
	gblRequestType = strRequestType;
	gblFromStoreId = fromStoreId;
	gblMultiRowCompArray = strMultiRowCompArray;
	gblMultiRowCompTypeArray = strMultiRowCompTypeArray;
	gblMultiRowFetchDataArray = strMultiRowFetchDataArray;
	gblLayerIndex = layerIndex;
	gblUserFunctionName = userFunctionName;
	gblUserArgument = userFunctionArgument;
	
	
	if(strUserInfo != undefined) {
		 
 		gblUserInfo = strUserInfo;
 	}else{
 		 		
 		gblUserInfo = "0";
 	}
 		
 	if(strUnitMode != undefined) {
	 
 		gblUnitMode = strUnitMode;
 	}else{
 		 
 		gblUnitMode = "0";
 	}		
 	if(strUserInfo == undefined)
 		{
 		strUserInfo = '0';
 		}
	var statusCode = 0;

	//var cmbObj = document.forms[0].strGroupIdForItemSearch;

	var itemParaObj = document.getElementById("searchItemsDtlsDivId");
	//alert("itemParaObj"+itemParaObj);
	 /*
		if (gblStrGroupIdForItemSearch != "0") {

			if (gblStrGroupIdForItemSearch != cmbObj.value) {
 
 				document.getElementById("itemListDivId").innerHTML = "<select onkeydown='return onPressingEnter(this,event)' tabindex='1' name='strItemList' multiple='multiple' size='5' style='width: 100%;' onchange='getBrandItemList(\"1\" , this);'></select>";
 				document.getElementById("brandItemListDivId").innerHTML = "<select onkeydown='return onPressingEnter(this,event)' tabindex='1' name='strBrandedItemList' multiple='multiple' size='5' style='width: 100%;' onchange='setItemBrandParameters(\"1\" , this);'></select>";
 
			}  

		} 
		
		gblStrGroupIdForItemSearch = cmbObj.value;
*/
		if (itemParaObj.innerHTML == "" || oldStoreId != fromStoreId || oldCateId != strItemCat) {
//			alert("SEARCHITEMINIT");
			var hmode = "SEARCHITEMINIT";
			var url = "MmsCNT.cnt?hmode=" + hmode + "&strMode=" + strMode
					+ "&strGroupId=0&strFromStoreId=" + fromStoreId + "&strRequestType="
					+ strRequestType +  "&strItemCategory=" + gblItemCategory+"&strUserInfo="+strUserInfo;
			
			ajaxFunction2(url, "1", "getMyAjaxResponse");



		} else {
			// set for 1024 * 760 screen don't change this

			popup('popUpDiv', '30', '225');
			document.forms[0].strSearchLeftList.focus();
		}

	 

}

/**
 * searchItems - function used to create a popup using a56resassjax to search Items.
 * 
 * @param {String}
 *            strMode - unique mode for the Item Search Popup 1 >> Items without
 *            parameters 2 >> Items with Stock Details 3 >>
 * @param {String}
 *            strItemCat - item category code
 * @param {String}
 *            strRequestType - Request Type
 * @param {String}
 *            fromStoreId - From Store Id
 * 
 * @param {Array}
 *            strMultiRowCompArray - multirow component array (same as multirow
 *            "new Array('strName','strGender')" )
 * @param {Array}
 *            strMultiRowCompTypeArray - multirow component type array (same as
 *            multirow "new Array('t','s')" )
 * 
 * @param {Array}
 *            strMultiRowFetchDataArray - user defined array which contains the
 *            index values to be fetched. Fetch data index will represented in
 *            multirow inside td tag create a div with id
 *            (id="itemParaId17#delIndex#") like this where "17" represents
 *            "fetch data index" 11^strUnitName represents the "fetch data
 *            index" 11 and a name which represents a unit combo should be
 *            created with the value available at 11 index
 * 
 * 				11^strUnitName^testFunction represents the "fetch data
 *            index" 11 and a name which represents a unit combo should be
 *            created with the value available at 11 index and invoke the testFunction on combo change event
 * 
 * test function must be declared in the following way
 * testFunction(mode, row_index, selected_obj)
 * 
 * e.g.new Array('17','18','11^strUnitName^testFunction')
 * 
 * @param (String)
 *            userFunctionName - Function Name Passed by User (Added on
 *            08/05/2009)
 * @param (String)
 *            userFunctionArgument - Function Argument Passed By User (Added on
 *            08/05/2009)
 * 
 *   @param (String) strUnitMode 0 >> All Units , 1 >> Only Base Unit
 */
function searchItemsWithUserFunction_ALLCatg(strMode, strItemCat, strRequestType, fromStoreId, strMultiRowCompArray,
		strMultiRowCompTypeArray, strMultiRowFetchDataArray, layerIndex,
		userFunctionName, userFunctionArgument ,strUserInfo , strUnitMode ) {

//alert("userFunctionName :: "+userFunctionName+" /-/ "+strMode+" /-/ "+strItemCat+strRequestType+" /-/ "+fromStoreId+" /-/ "+strMultiRowCompArray+" /-/ "+strMultiRowCompTypeArray+" /-/ "+strMultiRowFetchDataArray+" /-/ "+layerIndex+" /-/ "+layerIndex+userFunctionArgument+" /-/ "+strUserInfo+" /-/ "+strUnitMode);

var oldStoreId = gblFromStoreId;
var oldCateId = gblItemCategory;
	gblMode = strMode;
	gblItemCategory = strItemCat;
	gblRequestType = strRequestType;
	gblFromStoreId = fromStoreId;
	gblMultiRowCompArray = strMultiRowCompArray;
	gblMultiRowCompTypeArray = strMultiRowCompTypeArray;
	gblMultiRowFetchDataArray = strMultiRowFetchDataArray;
	gblLayerIndex = layerIndex;
	gblUserFunctionName = userFunctionName;
	gblUserArgument = userFunctionArgument;
	
	
	if(strUserInfo != undefined) {
		 
 		gblUserInfo = strUserInfo;
 	}else{
 		 		
 		gblUserInfo = "0";
 	}
 		
 	if(strUnitMode != undefined) {
	 
 		gblUnitMode = strUnitMode;
 	}else{
 		 
 		gblUnitMode = "0";
 	}		
 	if(strUserInfo == undefined)
 		{
 		strUserInfo = '0';
 		}
	var statusCode = 0;

	//var cmbObj = document.forms[0].strGroupIdForItemSearch;

	var itemParaObj = document.getElementById("searchItemsDtlsDivId");
	//alert("itemParaObj"+itemParaObj);
	 /*
		if (gblStrGroupIdForItemSearch != "0") {

			if (gblStrGroupIdForItemSearch != cmbObj.value) {
 
 				document.getElementById("itemListDivId").innerHTML = "<select onkeydown='return onPressingEnter(this,event)' tabindex='1' name='strItemList' multiple='multiple' size='5' style='width: 100%;' onchange='getBrandItemList(\"1\" , this);'></select>";
 				document.getElementById("brandItemListDivId").innerHTML = "<select onkeydown='return onPressingEnter(this,event)' tabindex='1' name='strBrandedItemList' multiple='multiple' size='5' style='width: 100%;' onchange='setItemBrandParameters(\"1\" , this);'></select>";
 
			}  

		} 
		
		gblStrGroupIdForItemSearch = cmbObj.value;
*/
		if (itemParaObj.innerHTML == "" || oldStoreId != fromStoreId || oldCateId != strItemCat) {
//			alert("SEARCHITEMINIT");
			var hmode = "SEARCHITEMINIT_WITHOUTCATG";
			var url = "MmsCNT.cnt?hmode=" + hmode + "&strMode=" + strMode
					+ "&strGroupId=0&strFromStoreId=" + fromStoreId + "&strRequestType="
					+ strRequestType +  "&strItemCategory=" + gblItemCategory+"&strUserInfo="+strUserInfo;
			
			ajaxFunction2(url, "8", "getMyAjaxResponse");



		} else {
			// set for 1024 * 760 screen don't change this

			popup('popUpDiv', '30', '225');
			document.forms[0].strSearchLeftList.focus();
		}

	 

}


/**
 * getSubGroupList
 * @param {String} grpObj 
 */
 function getSubGroupList(grpObj) {
 	 
 	gblStrGroupIdForItemSearch = grpObj.value;
 	
 	if(gblStrGroupIdForItemSearch == -1){
 		
 	 
 	 	document.getElementById("subGroupdivId").innerHTML = "<select name='strSubGroupIdForItemSearch' class='comboNormal' ><option value='0'>All</option></select>";
		document.getElementById("itemListDivId").innerHTML =  "<select name='strItemList' class='comboMax' ><option value='0'>All</option></select>";
			 
 		 document.getElementById("brandItemListDivId").innerHTML = "<select name='strBrandedItemList' multiple='multiple' size='12' style='width :100%'></select>";
 		 return false;
 		
 	}
 	
 	   document.getElementById("brandItemListDivId").innerHTML = "<select name='strBrandedItemList' multiple='multiple' size='12' style='width :100%'></select>";
 	
 	var hmode = "GETSUBGROUPLIST";
			var url = "MmsCNT.cnt?hmode=" + hmode + "&strMode=" + gblMode
					+ "&strGroupId="+gblStrGroupIdForItemSearch+"&strFromStoreId=" + gblFromStoreId + "&strRequestType="
					+ gblRequestType +  "&strItemCategory=" + gblItemCategory+"&strUserInfo="+gblUserInfo;
					
			ajaxFunction2(url, "6", "getMyAjaxResponse");
 	
 	
 }	
	


/**
 *  getItemList - call's ajax function to get item list 
 * @param {String} mode 1 >> Items without parameters
 * 					  2 >> Items with Stock Details
 * 					  3 >>
 */
function getItemList(mode) {

	gblMode = mode;

   document.getElementById("brandItemListDivId").innerHTML = "<select name='strBrandedItemList' multiple='multiple' size='12' style='width :100%'></select>";

	// alert("getItemList mode : "+mode);
	var subGrpId = document.forms[0].strSubGroupIdForItemSearch[document.forms[0].strSubGroupIdForItemSearch.selectedIndex].value;
	// var itemTypeId =
	// document.forms[0].strItemTypeForItemSearch[document.forms[0].strItemTypeForItemSearch.selectedIndex].value;

	var hmode = "GETITEMLIST";
	var url = "MmsCNT.cnt?hmode=" + hmode + "&strMode=" + gblMode + "&strGroupId="
			+ gblStrGroupIdForItemSearch + "&strSubGroupId=" + subGrpId + "&strRequestType="
			+ gblRequestType + "&strItemCatId=" + gblItemCategory + "&strFrmStoreId="
			+ gblFromStoreId +"&strUserInfo="+gblUserInfo;
	
	ajaxFunction2(url, "2", "getMyAjaxResponse");

}

var gblNewItemHighlight = "0";

/**
 *  getBrandItemList - call's ajax function to get brand list by item id
 * @param {String} mode 1 >> Items without parameters
 * 					  2 >> Items with Stock Details
 * 					  3 >> 
 * @param {Option Object}itemObj
 */
function getBrandItemList(mode) 
{
 		var brandItemListObj = document.getElementById("brandItemListDivId");
		brandItemListObj.innerHTML = "<select name='strBrandedItemList'  multiple='multiple' size='12' style='width :100%' ></select>";
		document.getElementById("popUpItemNameDivId").innerHTML = "";
		document.getElementById("popUpItemLoadDivId").style.display="block";
		gblStrGroupIdForItemSearch = document.forms[0].strGroupIdForItemSearch[document.forms[0].strGroupIdForItemSearch.selectedIndex].value;
 		gblMode = mode;
		var subGrpId = 0;
		var ItemId = 0;
		document.forms[0].strHiddenGenericItemId.value = 0;
		var hmode = "GETITEMBRANDLIST";
		
		var url = "MmsCNT.cnt?hmode=" + hmode + "&strMode=" + mode + "&strGroupId="
			+ gblStrGroupIdForItemSearch + "&strSubGroupId=" + subGrpId + "&strItemId="
			+ ItemId + "&strRequestType=" + gblRequestType + "&strFrmStoreId="
			+ gblFromStoreId + "&strItemCatId=" + gblItemCategory +"&strUserInfo="+gblUserInfo;
	 //alert(url);
	 ajaxFunction2(url, "3", "getMyAjaxResponse");
}


/**
 * clearItemBrandDtls
 * @param {}  
 */
 function clearItemBrandDtls() {
 	
 		document.getElementById("brandItemListDivId").innerHTML = "<select  name='strBrandedItemList' multiple='multiple' size='12' style='width :100%' onchange='setItemBrandParameters(\""
					+ gblMode + "\" , this);'></select>";
 	
 }

 
 /**
  *  getBrandItemList - call's ajax function to get brand list by item id
  * @param {String} mode 1 >> Items without parameters
  * 					  2 >> Items with Stock Details
  * 					  3 >> 
  * @param {Option Object}itemObj
  */
 function getBrandItemList_ALLCatg(mode) 
 {
  		var brandItemListObj = document.getElementById("brandItemListDivId");
 		brandItemListObj.innerHTML = "<select name='strBrandedItemList'  multiple='multiple' size='12' style='width :100%' ></select>";
 		document.getElementById("popUpItemNameDivId").innerHTML = "";
 		document.getElementById("popUpItemLoadDivId").style.display="block";
 		gblStrGroupIdForItemSearch = document.forms[0].strGroupIdForItemSearch[document.forms[0].strGroupIdForItemSearch.selectedIndex].value;
  		gblMode = mode;
 		var subGrpId = 0;
 		var ItemId = 0;
 		document.forms[0].strHiddenGenericItemId.value = 0;
 		var hmode = "GETITEMBRANDLIST_ALLCatg";
 		
 		var url = "MmsCNT.cnt?hmode=" + hmode + "&strMode=" + mode + "&strGroupId="
 			+ gblStrGroupIdForItemSearch + "&strSubGroupId=" + subGrpId + "&strItemId="
 			+ ItemId + "&strRequestType=" + gblRequestType + "&strFrmStoreId="
 			+ gblFromStoreId + "&strItemCatId=" + gblItemCategory +"&strUserInfo="+gblUserInfo;
 	// alert(url);
 	 ajaxFunction2(url, "3", "getMyAjaxResponse");
 }

/**
 *  getMyAjaxResponse - invoked by util.js ajaxFunction2 
 * @param {String} res - required response result 
 * @param {String} mode - mode passed by the user in ajaxFunction
 */
function getMyAjaxResponse(res, mode) {

	//alert('ajax'+mode+"dfsff "+gblMode);
	// SEARCHITEMINIT called from searchItems Function
	if (mode == '1') {

		var itemParaObj = document.getElementById("searchItemsDtlsDivId");
        
		res = "<div class='ItemFinderMain'>"+res+"</div>";
		itemParaObj.innerHTML = res;
        //  alert(res);
		popup('popUpDiv', '30', '225');
		
		//document.forms[0].strSearchLeftList.focus();
			 
		if(gblRequestType == "32")
		{
			
			getBrandItemList(gblMode);
			
			
		}
	    if(gblRequestType == "54")
	    {
			//alert("54");
			getBrandItemList(gblMode);
			
			
		}

	}

	// GETITEMLIST called from getItemList function
	if (mode == '2') 
	{

		
		
		var itemListObj = document.getElementById("itemListDivId");
		 

		if (gblMode == '1') {

			itemListObj.innerHTML = "<select name='strItemList' class='comboMax' onchange='getBrandItemList("+gblMode+");'  >" + res + "</select>";
			 

		} else if (gblMode == '2') {

			itemListObj.innerHTML = "<select name='strItemList'class='comboMax' onchange='getBrandItemList("+gblMode+");setItemStockParameters(this);'> "
					+ res + "</select>";
			

		} else if (gblMode == '3') {

			itemListObj.innerHTML = "<select name='strItemList'class='comboMax' onchange='getBrandItemList("+gblMode+");' > " + res + "</select>";
	

		}
		
		else if (gblMode == '4') {

			itemListObj.innerHTML = "<select name='strItemList' class='comboMax' onchange='getBrandItemList("+gblMode+");' > " + res + "</select>";


		}
		else if (gblMode == '7') {

			itemListObj.innerHTML = "<select name='strItemList'class='comboMax' onchange='getBrandItemList("+gblMode+");' > " + res + "</select>";
	

		}
        document.forms[0].strSearchLeftList.focus();
		getBrandItemList(gblMode);

	}

	// GETITEMBRANDLIST called from getBrandItemList Function
	if (mode == '3') {

		//alert("res :: "+res);
		
		var brandItemListObj = document.getElementById("brandItemListDivId");

		if (gblMode == '1') 
		{

			brandItemListObj.innerHTML = "<select name='strBrandedItemList' onkeyup='selectItemsInPopup(event);' multiple='multiple' size='12' style='width :100%' onchange='setItemName(this);setItemBrandParameters(\""
					+ gblMode + "\" , this);'>" + res + "</select>";

		} else if (gblMode == '2') 
		{
            
			brandItemListObj.innerHTML = "<select name='strBrandedItemList' onkeyup='selectItemsInPopup(event);' multiple='multiple' size='12' style='width :100%' onchange='setItemName(this);setItemStockParameters(this);'> "
					+ res + "</select>";

		} else if (gblMode == '3') 
		{

			brandItemListObj.innerHTML = "<select name='strBrandedItemList' onkeyup='selectItemsInPopup(event);' multiple='multiple' size='12' style='width :100%' onchange='setItemName(this);setItemStockParameters(this);' > "
					+ res + "</select>";
		}else if (gblMode == '4') 
		{

			brandItemListObj.innerHTML = "<select name='strBrandedItemList' onkeyup='selectItemsInPopup(event);' multiple='multiple' size='12' style='width :100%' onchange='setItemName(this);setItemStockParameters(this);' > "
					+ res + "</select>";
		}
		else if (gblMode == '7') 
		{

			brandItemListObj.innerHTML = "<select name='strBrandedItemList' onkeyup='selectItemsInPopup(event);' multiple='multiple' size='12' style='width :100%' onchange='setItemName(this);setItemStockParameters(this);' > "
					+ res + "</select>";
		}
		else if (gblMode == '8') 
		{

			brandItemListObj.innerHTML = "<select name='strBrandedItemList' onkeyup='selectItemsInPopup(event);' multiple='multiple' size='12' style='width :100%' onchange='setItemName(this);setItemStockParameters(this);' > "
					+ res + "</select>";
		}

		if(gblNewItemHighlight == '1'){
			
			gblNewItemHighlight = "0";
			
			searchInListBox("strBrandedItemList" , document.getElementsByName("strNewItemName")[0].value);
						
	   }
	   
		document.getElementById("popUpItemLoadDivId").style.display="none";		
	    document.forms[0].strSearchLeftList.focus();
      
	}

// GETADDNEWITEM called from getAddNewItemScreen Function
if(mode == '4'){
	
		document.getElementById("newItemsAddPartDivId").innerHTML = res;
		
 		document.getElementById("itemSearchPartDivId").style.display = "none";
 		document.getElementById("newItemsAddPartDivId").style.display = "block";
	
}


// GETADDNEWITEM called from getAddNewItemScreen Function
if(mode == '5'){
	
		var err = "Error in the Process";
	
		if(res.length > 0){
			
				var temp = res.split("@@@@");
			
				if(temp.length > 1){
					
					err = temp[1];
														
				}
			
		
				document.getElementById("newItemErrorContentDivId").innerHTML = err;
 				document.getElementById("newItemErrorPartDivId").style.display = "block";
			
		}else{
			
			gblNewItemHighlight = "1";
				
 		document.getElementById("itemSearchPartDivId").style.display = "block";
 		document.getElementById("newItemsAddPartDivId").style.display = "none";
	
		getBrandItemList(gblMode , document.forms[0].strAddNewItemHiddenVal );
		
		}
	
		
}


if(mode == '6'){
	
		var temp = res.split("@@@@");
		
		document.getElementById("subGroupdivId").innerHTML = "<select name='strSubGroupIdForItemSearch' class='comboNormal' onchange='getItemList(\"" + gblMode + "\" , this);'>"+temp[0]+"</select>"
		
		if (gblMode == '2')
		{
			
			document.getElementById("itemListDivId").innerHTML =  "<select name='strItemList' class='comboMax' onchange='getBrandItemList("+gblMode+");setItemStockParameters(this);' >" + temp[1] + "</select>";
			
		}
		else
		{

		document.getElementById("itemListDivId").innerHTML =  "<select name='strItemList' class='comboMax' onchange='getBrandItemList("+gblMode+");' >" + temp[1] + "</select>";
			
		}
		 

		getBrandItemList(gblMode);		
	 
			
}

if (mode == '7') {

	alert("res :: "+res);
	
	var brandItemListObj = document.getElementById("brandItemListDivId");

	if (gblMode == '1') 
	{

		brandItemListObj.innerHTML = "<select name='strBrandedItemList' onkeyup='selectItemsInPopup(event);' multiple='multiple' size='12' style='width :100%' onchange='setItemName(this);setItemBrandParameters(\""
				+ gblMode + "\" , this);'>" + res + "</select>";

	} else if (gblMode == '2') 
	{
        
		brandItemListObj.innerHTML = "<select name='strBrandedItemList' onkeyup='selectItemsInPopup(event);' multiple='multiple' size='12' style='width :100%' onchange='setItemName(this);setItemStockParameters(this);'> "
				+ res + "</select>";

	} else if (gblMode == '7') 
	{

		brandItemListObj.innerHTML = "<select name='strBrandedItemList' onkeyup='selectItemsInPopup(event);' multiple='multiple' size='12' style='width :100%' onchange='setItemName(this);setItemStockParameters(this);' > "
				+ res + "</select>";
	}else if (gblMode == '4') 
	{

		brandItemListObj.innerHTML = "<select name='strBrandedItemList' onkeyup='selectItemsInPopup(event);' multiple='multiple' size='12' style='width :100%' onchange='setItemName(this);setItemStockParameters(this);' > "
				+ res + "</select>";
	}


	if(gblNewItemHighlight == '1'){
		
		gblNewItemHighlight = "0";
		
		searchInListBox("strBrandedItemList" , document.getElementsByName("strNewItemName")[0].value);
					
}
   
	document.getElementById("popUpItemLoadDivId").style.display="none";
	
  document.forms[0].strSearchLeftList.focus();
  
}

	if (mode == '8') 
	{
	
		    var itemParaObj = document.getElementById("searchItemsDtlsDivId");
	    
		    res = "<div class='ItemFinderMain'>"+res+"</div>";
		    itemParaObj.innerHTML = res;
	    //  alert(res);
		    popup('popUpDiv', '30', '225');	
		
			
			getBrandItemList_ALLCatg(gblMode);
			
		
	
	}

}

/**
 * hidePopup - hide the popup
 * 
 */
function hidePopup() {

	hide_popup('popUpDiv');

}


	/**
	 * setItemName
	 * @param {Object} itemObj 
	 */
	 function setItemName(itemObj) {
	 	
	 	document.getElementById("popUpItemNameDivId").innerHTML = "  "+itemObj[itemObj.selectedIndex].text;
	 	
	 }


/** 
 * createSelectedList - used to create the selected Item's List in parent window.
 *  gblLayerIndex used in the function Layer Index of Multirow 
 * 			(it fetch the rows to layer index 1 for id1 & 2 for id2)
 */
function createSelectedList() {

	//selectListRecords("strSelectedItemList");


hidePopup();

loading_msg();
toggle('blanket');

 
	var selectedItemsList = document.forms[0].strSelectedItemList;
	var selectedItemListLen = selectedItemsList.length;

	var itemHiddenParamDtls = document.getElementsByName("itemParamValue");
	var itemHiddenParamLength = itemHiddenParamDtls.length;

	var multrowIndex = parseInt(document.getElementsByName("rowIndex"
			+ gblLayerIndex)[0].value);

	var rowIndexArray = new Array(itemHiddenParamLength - 1);
	var arr2 = new Array(itemHiddenParamLength - 1);


	for ( var i = 0; i < itemHiddenParamLength - 1; i++) {

		arr2[i] = itemHiddenParamDtls[i].value;
	}

	if (itemHiddenParamLength > 1 || multrowIndex > 0) {

		var arr = new Array(selectedItemListLen);

		// start for
		for ( var ind = 0; ind < selectedItemListLen; ind++) {

			arr[ind] = "";

			// start inner for
			for ( var index2 = 0; index2 < itemHiddenParamLength - 1; index2++) {

				if (selectedItemsList[ind].value == itemHiddenParamDtls[index2].value) {

					arr[ind] = selectedItemsList[ind].value;

					arr2[index2] = "";

				}

			}

		}

		var delArray = new Array();
		var count2 = parseInt("1");
		var arrayCount = parseInt("0");

		do {

			var divVal = document.getElementById("id" + gblLayerIndex + "-"
					+ count2);

			if (divVal == null)
				break;

			if (divVal.innerHTML.length > 0) {

				delArray[arrayCount] = count2 - 1;

				arrayCount = arrayCount + 1;

			}

			count2 = count2 + 1;

		} while (true);

		for ( var ind2 = 0; ind2 < itemHiddenParamLength; ind2++) {

			if (arr2[ind2] != null && arr2[ind2] != "") {

				deleteRow(gblLayerIndex + "-" + (delArray[ind2] + 1), '1', '0');

			}

		}

		for ( var i = 0; i < selectedItemListLen; i++) 
		{

			if (arr[i] == "") 
			{

				var myrowIndex = parseInt(document.getElementsByName("rowIndex"+ gblLayerIndex)[0].value);

				addRows(gblMultiRowCompArray, gblMultiRowCompTypeArray,
						gblLayerIndex, '1', 'R');

				var selectedItemsListVals = selectedItemsList[i].value.replace(
						"#", "^").split("^");

				for ( var j = 0; j < gblMultiRowFetchDataArray.length; j++) {

					var tempVal = gblMultiRowFetchDataArray[j].split("^");


var val = selectedItemsList[i].value.split('#');
//alert(val+"--"+val.length);

 	// added for reordered level color on 06-Aug-2011

if (gblMode != '2') {

						  if( !( parseInt(val[1].split('^')[0]) >=  parseInt(val[1].split('^')[2]) )){
									 	
									 		
									 		if(document.forms[0].strReOrderFlgColor.value.length > 0){
											 
													var tdArray = document.getElementById("td1-"+(myrowIndex + 1)).getElementsByTagName('td');
										
														for(var index=0; index<tdArray.length; index++) {
											
															tdArray[index].style.backgroundColor = document.forms[0].strReOrderFlgColor.value;
											
														}
										 
												}
									 		
									 }
}		



					if (tempVal.length > 1) {

						var obj = document.getElementById("itemParaId"+ tempVal[0] + gblLayerIndex + "-"+ (myrowIndex + 1));

						
						
						var unitVal = "0";
						
							// added for reordered level color on 06-Aug-2011
						var reOrderLevel = "0";
					
							if (gblMode == '1') {
								
									 unitVal = val[2].split('^')[11];
							 
							}else if (gblMode == '2') {
								
									unitVal = val[2].split('^')[7];
								
							}else if (gblMode == '3' || gblMode == '7'){
							
									 unitVal = val[2].split('^')[10];
									  
						 
													 
								
							}else if (gblMode == '4'){
									 unitVal = val[2].split('^')[2];
							}
			  				
												
						var hmode = "GETUNITCOMBO";

						//if (selectedItemsListVals[(parseInt(gblMultiRowFetchDataArray[j]) - 1)] != null) {

						if(unitVal != "" && unitVal != "0")
						{	
							
							var url = "MmsCNT.cnt?hmode="
									+ hmode
									+ "&strUnitId="
									+ unitVal+"&strUnitMode="+gblUnitMode+"&itemCat="+gblItemCategory;
						} 
						else 
						{

							var url = "MmsCNT.cnt?hmode=" + hmode+ "&strUnitId=1&strUnitMode="+gblUnitMode;
						}
                       
				
						var res = myAjaxFunction(url);

						if (tempVal.length == 3) {

							obj.innerHTML = "<select class='comboMin' onchange='"
									+ tempVal[2]
									+ "("
									+ gblMode
									+ ","
									+ "\""
									+ gblLayerIndex
									+ "-"
									+ (myrowIndex + 1)
									+ "\",this);"
									+ "'  name='"
									+ tempVal[1]
									+ "' id='"
									+ tempVal[1]
									+ ""
									+ gblLayerIndex
									+ "-"
									+ (myrowIndex + 1)
									+ "'>" + res + "</select>";

						} else {

							obj.innerHTML = "<select class='comboMin' name='"
									+ tempVal[1] + "' id='" + tempVal[1] + ""
									+ gblLayerIndex + "-" + (myrowIndex + 1)
									+ "'>" + res + "</select>";

						}

					} 
					else 
					{
                       
						var obj = document.getElementById("itemParaId"
								+ gblMultiRowFetchDataArray[j] + gblLayerIndex
								+ "-" + (myrowIndex + 1));

						var fetchArrayIndex = (parseInt(gblMultiRowFetchDataArray[j]) - 1);

						if (selectedItemsListVals[fetchArrayIndex] != null) {

							if (fetchArrayIndex == '0') {

								var popupContent = "";

								if (gblMode == '1') {

									var reqValArry1 = selectedItemsList[i].value.split('#')[0].split('^');
									
									var reqValArry2 = selectedItemsList[i].value.split('#')[2].split('^');
									
									var lastPoNo 	= reqValArry2[12];
									var lastPoDate  = reqValArry2[13];
									
									var itemName = reqValArry1[0];
									var specification = reqValArry1[1];
									var lastRate	= reqValArry1[4];
									var suppliedBy 	= reqValArry1[5];
																		
										if(lastPoNo.length == 0) lastPoNo = "";								
										if(lastPoDate.length == 0) lastPoDate = "";																		
										if(itemName.length == 0) itemName = "";
										if(specification.length == 0) specification = "";
										if( lastRate.length == 0) lastRate = "";
										if(suppliedBy.length == 0) suppliedBy = "";								
																															
									popupContent = "<table width='500' cellspacing='0px' cellpadding='0px'><tr class='HEADER'><th colspan='3' align='left'>" +
											"&nbsp;"+itemName+" - Details</th><th align='right'><img style='color: blue; cursor: pointer;' src='../../hisglobal/images/popUp_cancel.JPG' onClick='hide_popup_menu(\"itemDetailsDivId"
										+ ""
										+ gblLayerIndex
										+ "-"
										+ (myrowIndex + 1)
										+ "\");'></th></tr></table><table width='500' cellspacing='1px' cellpadding='1px'>"
											+ "<tr>"
											+ "<td class='multiRPTLabel' width='25%'>Last P.O. No.</td><td class='multiPOControl' width='25%'>"+lastPoNo+"</td>"
											+ "<td class='multiRPTLabel' width='25%'>Last P.O. Date</td><td class='multiPOControl' width='25%'>"+lastPoDate+"</td>"
											+ "</tr>"
											+ "<tr>"
											+ "<td class='multiRPTLabel' width='25%'>Last Rate / Unit</td><td class='multiPOControl' width='25%'>"+lastRate+"</td>"
											+ "<td class='multiRPTLabel' width='25%'>Supplied By</td><td class='multiPOControl' width='25%'>"+suppliedBy+"</td>"
											+ "</tr>"
											+ "<tr>"
											+ "<td class='multiRPTLabel' width='25%'>Specification</td><td colspan='3' width='75%' class='multiPOControl'>"+specification+"</td>"
											+ "</tr></table><table width='500' cellspacing='1px' cellpadding='1px'><tr class='FOOTER'><td colspan='4'></td></tr></table>";

								} else if (gblMode == '2') {
									
									var reqValArry1 = selectedItemsList[i].value.split('#')[0].split('^');
																										
									var itemName = reqValArry1[0];
									var specification = reqValArry1[1];
									var lastRate	= reqValArry1[2];
															
											
										if(itemName.length == 0) itemName = "";
										if(specification.length == 0) specification = "";
										if(lastRate.length == 0) lastRate = "";
											
																																								
									popupContent = "<table width='500' cellspacing='0px' cellpadding='0px'><tr class='HEADER'><th colspan='3' align='left'>" +
											"&nbsp;"+itemName+" - Details</th><th align='right'><img style='color: blue; cursor: pointer;' src='../../hisglobal/images/popUp_cancel.JPG' onClick='hide_popup_menu(\"itemDetailsDivId"
										+ ""
										+ gblLayerIndex
										+ "-"
										+ (myrowIndex + 1)
										+ "\");'></th></tr></table><table width='500' cellspacing='1px' cellpadding='1px'>"
											+ "<tr>"
											+ "<td class='multiRPTLabel' width='50%'>Last Rate</td><td colspan='3' class='multiPOControl' width='50%'>"+lastRate+"</td>"
											+ "</tr>"
											+ "<tr>"
											+ "<td class='multiRPTLabel' width='25%'>Specification</td><td colspan='3' class='multiPOControl' width='75%'>"+specification+"</td>"
											+ "</tr></table><table width='500' cellspacing='1px' cellpadding='1px'><tr class='FOOTER'><td colspan='4'></td></tr></table>";

								} else if (gblMode == '3' || gblMode == '7') {

									var reqValArry1 = selectedItemsList[i].value.split('#')[0].split('^');
									
									 									
									var reqValArry2 = selectedItemsList[i].value.split('#')[2].split('^');
									
									var lastPoNo 	= reqValArry2[12];
									var lastPoDate  = reqValArry2[13];
										
									var itemName = reqValArry1[0];
									var specification = reqValArry1[1];
									var lastRate	= reqValArry1[4];
									var suppliedBy 	= reqValArry1[5];
									var manufacturer = reqValArry1[14];
																
										if(lastPoNo.length == 0) lastPoNo = "";								
										if(lastPoDate.length == 0) lastPoDate = "";																		
										if(itemName.length == 0) itemName = "";
										if(specification.length == 0) specification = "";
										if(lastRate.length == 0) lastRate = "";
										if(suppliedBy.length == 0) suppliedBy = "";					
										if(manufacturer.length == 0) manufacturer = "";					
																															
									popupContent = "<table width='500' cellspacing='0px' cellpadding='0px'><tr class='HEADER'><th colspan='3' align='left'>" +
											"&nbsp;"+itemName+" - Details</th><th align='right'><img style='color: blue; cursor: pointer;' src='../../hisglobal/images/popUp_cancel.JPG' onClick='hide_popup_menu(\"itemDetailsDivId"
										+ ""
										+ gblLayerIndex
										+ "-"
										+ (myrowIndex + 1)
										+ "\");'></th></tr></table><table width='500' cellspacing='1px' cellpadding='1px'>"
										
										    + "<tr>"
											+ "<td class='multiRPTLabel' width='25%'>Last Rate / Unit</td><td class='multiPOControl' width='25%'>"+lastRate+"</td>"
											+ "<td class='multiRPTLabel' width='25%'>Last P.O.No / Date</td><td class='multiPOControl' width='25%'>"+lastPoNo+"/"+lastPoDate+"</td>"
											+ "</tr>"	
											+ "<tr>"										
											+ "<td class='multiRPTLabel' width='25%'>Supplied By</td><td colspan='3' class='multiPOControl' width='75%'>"+suppliedBy+"</td>"
											+ "</tr>"	
											/* Commented By Amit 28-Feb-2012*/
											//+ "<tr>"  
											//+ "<td class='LABEL' width='25%'>Last Rate / Unit</td><td class='CONTROL' width='25%'>"+lastRate+"</td>"
											//+ "<td class='LABEL' width='25%'>Supplied By</td><td class='CONTROL' width='25%'>"+suppliedBy+"</td>"
											//+ "</tr>"
											+ "<tr>"
											+ "<td class='multiRPTLabel' width='25%'>Manufacturer</td><td colspan='3' class='multiPOControl' width='75%'>"+manufacturer+"</td>"
											+ "</tr>"
											//+ "<tr>"
											//+ "<td class='LABEL' width='25%'>Specification</td><td colspan='3' class='CONTROL' width='75%'>"+specification+"</td></tr>"
											+ "</table><table width='500' cellspacing='1px' cellpadding='1px'><tr class='FOOTER'><td colspan='4'></td></tr></table>";

								}
								
								else if (gblMode == '4') {

									var reqValArry1 = selectedItemsList[i].value.split('^') 
																		
									var lastPoNo 	= reqValArry1[7];
									var lastPoDate  = reqValArry1[8];
										
									var itemName = reqValArry1[0];
									var specification = reqValArry1[6];
									var lastRate	= reqValArry1[9];
									var suppliedBy 	= reqValArry1[16];
								
									if(lastPoNo.length == 0) lastPoNo = "";								
										if(lastPoDate.length == 0) lastPoDate = "";																		
										if(itemName.length == 0) itemName = "";
										if(specification.length == 0) specification = "";
										if(lastRate.length == 0) lastRate = "";
										if(suppliedBy.length == 0) suppliedBy = "";					
																				
																															
									popupContent = "<table width='500' cellspacing='0px' cellpadding='0px'><tr class='HEADER'><th colspan='3' align='left'>" +
											"&nbsp;"+itemName+" - Details</th><th align='right'><img style='color: blue; cursor: pointer;' src='../../hisglobal/images/popUp_cancel.JPG' onClick='hide_popup_menu(\"itemDetailsDivId"
										+ ""
										+ gblLayerIndex
										+ "-"
										+ (myrowIndex + 1)
										+ "\");'></th></tr></table><table width='400' cellspacing='1px' cellpadding='1px'>"
											+ "<tr>"
											+ "<td class='multiRPTLabel' width='25%'>Last P.O. No.</td><td class='multiPOControl' width='25%'>"+lastPoNo+"</td>"
											+ "<td class='multiRPTLabel' width='25%'>Last P.O. Date</td><td class='multiPOControl' width='25%'>"+lastPoDate+"</td>"
											+ "</tr>"
											+ "<tr>"
											+ "<td class='multiRPTLabel' width='25%'>Last Rate / Unit</td><td class='multiPOControl' width='25%'>"+lastRate+"</td>"
											+ "<td class='multiRPTLabel' width='25%'>Supplied By</td><td class='CONTROL' width='25%'>"+suppliedBy+"</td>"
											+ "</tr>"
											+ "<tr>"
											+ "<td class='multiRPTLabel' width='25%'>Specification</td><td colspan='3' class='multiPOControl' width='75%'>"+specification+"</td>"
											+ "</tr></table><table width='500' cellspacing='1px' cellpadding='1px'><tr class='FOOTER'><td colspan='4'></td></tr></table>";

								}
								

								obj.innerHTML = "<div class='popup' style='display:none' id='itemDetailsDivId"
										+ gblLayerIndex
										+ "-"
										+ (myrowIndex + 1)
										+ "'>"+popupContent+"</div><a style='color:blue;cursor: pointer;' onclick='display_popup_menu(this,\"itemDetailsDivId"
										+ ""
										+ gblLayerIndex
										+ "-"
										+ (myrowIndex + 1)
										+ "\",\"\",\"\");'>"
										+ selectedItemsListVals[fetchArrayIndex]
										+ "</a>";

							} else {
							
								if (obj.type == "text") {
									obj.value = selectedItemsListVals[fetchArrayIndex];
																		
								} else {
									obj.innerHTML = selectedItemsListVals[fetchArrayIndex];
								}
								
								 
							}

						} else {

							if (obj.type == "text") {
								obj.value = "";
							} else {
								obj.innerHTML = "/";
							}
							
							
						}

					}

				}

				var itemTempValArry = selectedItemsList[i].value.split('#');

				document.getElementById("itemParamValue" + gblLayerIndex + "-"
						+ (myrowIndex + 1)).value = selectedItemsList[i].value;

				document.getElementById("itemCalcValue" + gblLayerIndex + "-"
						+ (myrowIndex + 1)).value = itemTempValArry[1];

				document.getElementById("itemUserValue" + gblLayerIndex + "-"
						+ (myrowIndex + 1)).value = itemTempValArry[2];
						
						document.getElementById("itemUserValue" + gblLayerIndex + "-"
						+ (myrowIndex + 1)).disabled = true;

			}

		}

	} else {

		for ( var i = 0; i < selectedItemListLen; i++) {

			addRows(gblMultiRowCompArray, gblMultiRowCompTypeArray,
					gblLayerIndex, '1', 'R');

					
			var selectedItemsListVals = selectedItemsList[i].value.replace("#",
					"^").split("^");

			   //alert("selectedItemsListVals "+selectedItemsListVals);
			
			for ( var j = 0; j < gblMultiRowFetchDataArray.length; j++) {

				var tempVal = gblMultiRowFetchDataArray[j].split("^");

			  	var val = selectedItemsList[i].value.split('#');
			  	
						  // added for reordered level color on 06-Aug-2011
		/*		if (gblMode != '2') {		  
						  if( !( parseInt(val[1].split('^')[0]) >=  parseInt(val[1].split('^')[2]) )){
									 	
									 		
									 		if(document.forms[0].strReOrderFlgColor.value.length > 0){
											 
													var tdArray = document.getElementById("td1-"+(i + 1)).getElementsByTagName('td');
										
														for(var index=0; index<tdArray.length; index++) {
											
															tdArray[index].style.backgroundColor = document.forms[0].strReOrderFlgColor.value;
											
														}
										 
												}
									 		
									 }
}*/

				if (tempVal.length > 1) {

					var obj = document.getElementById("itemParaId" + tempVal[0]
							+ "" + gblLayerIndex + "-" + (i + 1));

								
					var hmode = "GETUNITCOMBO";

				
					
					var unitVal = "0";
					
						// added for reordered level color on 06-Aug-2011
					var reOrderLevel = "0";
					
					if (gblMode == '1') 
					{
						
					 unitVal = val[2].split('^')[11];
					 
					}
					else if (gblMode == '2') 
					{
						
							unitVal = val[2].split('^')[7];
						
						}
						else if (gblMode == '3' || gblMode == '7')
						{
						 unitVal = val[2].split('^')[10];
						 
						
									 		
						  
						 
						 
						}else if (gblMode == '4'){
						 unitVal = val[2].split('^')[2];
						}
					
											
		 			
					//if (selectedItemsListVals[(parseInt(gblMultiRowFetchDataArray[j]) - 1)] != null) {

					if(unitVal != "" && unitVal != "0"){	
							
							var url = "MmsCNT.cnt?hmode="
									+ hmode
									+ "&strUnitId="
									+ unitVal+"&strUnitMode="+gblUnitMode+"&itemCat="+gblItemCategory;
						} else {

							var url = "MmsCNT.cnt?hmode=" + hmode
									+ "&strUnitId=1&strUnitMode="+gblUnitMode;
						}
                   
					var res = myAjaxFunction(url);

					if (tempVal.length == 3) {

						obj.innerHTML = "<select class='comboMin' onchange='"
								+ tempVal[2] + "(" + gblMode + "," + "\""
								+ gblLayerIndex + "-" + (i + 1) + "\",this);"
								+ "' name='" + tempVal[1] + "' id='"
								+ tempVal[1] + "" + gblLayerIndex + "-"
								+ (i + 1) + "'>" + res + "</select>";

					} else {
						obj.innerHTML = "<select class='comboMin' name='"
								+ tempVal[1] + "' id='" + tempVal[1] + ""
								+ gblLayerIndex + "-" + (i + 1) + "'>" + res
								+ "</select>";

					}

				} else {

					var obj = document.getElementById("itemParaId"
							+ gblMultiRowFetchDataArray[j] + gblLayerIndex
							+ "-" + (i + 1));

					var fetchArrayIndex = (parseInt(gblMultiRowFetchDataArray[j]) - 1);

					if (selectedItemsListVals[fetchArrayIndex] != null) {

						if (fetchArrayIndex == '0') {

							var popupContent = "";

							if (gblMode == '1') {

								var reqValArry1 = selectedItemsList[i].value.split('#')[0].split('^');
								
								var reqValArry2 = selectedItemsList[i].value.split('#')[2].split('^');
								
								var lastPoNo 	= reqValArry2[12];
								var lastPoDate  = reqValArry2[13];
								
								var itemName = reqValArry1[0];
								var specification = reqValArry1[1];
								var lastRate	= reqValArry1[4];
								var suppliedBy 	= reqValArry1[5];
																
										if(lastPoNo.length == 0) lastPoNo = "";								
										if(lastPoDate.length == 0) lastPoDate = "";																		
										if(itemName.length == 0) itemName = "";
										if(specification.length == 0) specification = "";
										if( lastRate.length == 0) lastRate = "";
										if(suppliedBy.length == 0) suppliedBy = "";					
										
																
								popupContent = "<table width='500' cellspacing='0px' cellpadding='0px'><tr class='HEADER'><th colspan='3' align='left'>" +
										"&nbsp;"+itemName+" - Details</th><th align='right'><img style='color: blue; cursor: pointer;' src='../../hisglobal/images/popUp_cancel.JPG' onClick='hide_popup_menu(\"itemDetailsDivId"
									+ ""
									+ gblLayerIndex
									+ "-"
									+ (i + 1)
									+ "\");'></th></tr></table><table width='500' cellspacing='1px' cellpadding='1px'>"
										+ "<tr>"
										+ "<td class='multiRPTLabel' width='25%'>Last P.O. No.</td><td class='multiPOControl' width='25%'>"+lastPoNo+"</td>"
										+ "<td class='multiRPTLabel' width='25%'>Last P.O. Date</td><td class='multiPOControl' width='25%'>"+lastPoDate+"</td>"
										+ "</tr>"
										+ "<tr>"
										+ "<td class='multiRPTLabel' width='25%'>Last Rate / Unit</td><td class='multiPOControl' width='25%'>"+lastRate+"</td>"
										+ "<td class='multiRPTLabel' width='25%'>Supplied By</td><td class='CONTROL' width='25%'>"+suppliedBy+"</td>"
										+ "</tr>"
										+ "<tr>"
										+ "<td class='multiRPTLabel' width='25%'>Specification</td><td colspan='3' class='multiPOControl' width='75%'>"+specification+"</td>"
										+ "</tr></table><table width='500' cellspacing='1px' cellpadding='1px'><tr class='FOOTER'><td colspan='4'></td></tr></table>";

							} else if (gblMode == '2') {
								
								var reqValArry1 = selectedItemsList[i].value.split('#')[0].split('^');
																									
								var itemName = reqValArry1[0];
								var specification = reqValArry1[1];
								var lastRate	= reqValArry1[2];
							
							 			if(itemName.length == 0) itemName = "";
										if(specification.length == 0) specification = "";
										if( lastRate.length == 0) lastRate = "";
							    																
																
								popupContent = "<table width='500' cellspacing='0px' cellpadding='0px'><tr class='HEADER'><th colspan='3' align='left'>" +
										"&nbsp;"+itemName+" - Details</th><th align='right'><img style='color: blue; cursor: pointer;' src='../../hisglobal/images/popUp_cancel.JPG' onClick='hide_popup_menu(\"itemDetailsDivId"
									+ ""
									+ gblLayerIndex
									+ "-"
									+ (i + 1)
									+ "\");'></th></tr></table><table width='500' cellspacing='1px' cellpadding='1px'>"
										+ "<tr>"
										+ "<td class='multiRPTLabel' width='50%'>Last Rate</td><td colspan='3' class='multiPOControl' width='50%'>"+lastRate+"</td>"
										+ "</tr>"
										+ "<tr>"
										+ "<td class='multiRPTLabel' width='25%'>Specification</td><td colspan='3' class='multiPOControl' width='75%'>"+specification+"</td>"
										+ "</tr></table><table width='500' cellspacing='1px' cellpadding='1px'><tr class='FOOTER'><td colspan='4'></td></tr></table>";

							} else if (gblMode == '3' || gblMode == '7') {

								var reqValArry1 = selectedItemsList[i].value.split('#')[0].split('^');
								
								var reqValArry2 = selectedItemsList[i].value.split('#')[2].split('^');
								
								var lastPoNo 	= reqValArry2[12];
								var lastPoDate  = reqValArry2[13];
								
								var itemName = reqValArry1[0];
								var specification = reqValArry1[1];
								var lastRate	= reqValArry1[4];
								var suppliedBy 	= selectedItemsList[i].value.split('@')[1];
								var manufacturer = selectedItemsList[i].value.split('@')[1];
																
										if(lastPoNo.length == 0) lastPoNo = "";								
										if(lastPoDate.length == 0) lastPoDate = "";																		
										if(itemName.length == 0) itemName = "";
										if(specification.length == 0) specification = "";
										if(lastRate.length == 0) lastRate = "";
										if(suppliedBy.length == 0) suppliedBy = "";					
										if(manufacturer.length == 0) manufacturer = "";			
																							
																
								popupContent = "<table width='500' cellspacing='0px' cellpadding='0px'><tr class='HEADER'><th colspan='3' align='left'>" +
										"&nbsp;"+itemName+" - Details</th><th align='right'><img style='color: blue; cursor: pointer;' src='../../hisglobal/images/popUp_cancel.JPG' onClick='hide_popup_menu(\"itemDetailsDivId"
									+ ""
									+ gblLayerIndex
									+ "-"
									+ (i + 1)
									+ "\");'></th></tr></table><table width='500' cellspacing='1px' cellpadding='1px'>"
										   
										    + "<tr>"
											+ "<td class='multiRPTLabel' width='25%'>Last Rate / Unit</td><td class='multiPOControl' width='25%'>"+lastRate+"</td>"
											+ "<td class='multiRPTLabel' width='25%'>Last P.O.No / Date</td><td class='multiPOControl' width='25%'>"+lastPoNo+"/"+lastPoDate+"</td>"
											+ "</tr>"	
											+ "<tr>"										
											+ "<td class='multiRPTLabel' width='25%'>Supplied By</td><td colspan='3' class='multiPOControl' width='75%'>"+suppliedBy+"</td>"
											+ "</tr>"	
											/* Commented By Amit 28-Feb-2012*/
											//+ "<tr>"  
											//+ "<td class='LABEL' width='25%'>Last Rate / Unit</td><td class='CONTROL' width='25%'>"+lastRate+"</td>"
											//+ "<td class='LABEL' width='25%'>Supplied By</td><td class='CONTROL' width='25%'>"+suppliedBy+"</td>"
											//+ "</tr>"
											+ "<tr>"
											+ "<td class='multiRPTLabel' width='25%'>Manufacturer</td><td colspan='3' class='multiPOControl' width='75%'>"+manufacturer+"</td>"
											+ "</tr>"
											//+ "<tr>"
											//+ "<td class='LABEL' width='25%'>Specification</td><td colspan='3' class='CONTROL' width='75%'>"+specification+"</td></tr>"
											+ "</table><table width='500' cellspacing='1px' cellpadding='1px'><tr class='FOOTER'><td colspan='4'></td></tr></table>";

							}

							else if (gblMode == '4') {

									var reqValArry1 = selectedItemsList[i].value.split('^') 
																		
									var lastPoNo 	= reqValArry1[7];
									var lastPoDate  = reqValArry1[8];
										
									var itemName = reqValArry1[0];
									var specification = reqValArry1[6];
									var lastRate	= reqValArry1[9];
									var suppliedBy 	= reqValArry1[16];
								
									if(lastPoNo.length == 0) lastPoNo = "";								
										if(lastPoDate.length == 0) lastPoDate = "";																		
										if(itemName.length == 0) itemName = "";
										if(specification.length == 0) specification = "";
										if(lastRate.length == 0) lastRate = "";
										if(suppliedBy.length == 0) suppliedBy = "";					
											
																							
																															
									popupContent = "<table width='500' cellspacing='0px' cellpadding='0px'><tr class='HEADER'><th colspan='3' align='left'>" +
											"&nbsp;"+itemName+" - Details</th><th align='right'><img style='color: blue; cursor: pointer;' src='../../hisglobal/images/popUp_cancel.JPG' onClick='hide_popup_menu(\"itemDetailsDivId"
										+ ""
										+ gblLayerIndex
										+ "-"
										+ (i + 1)
										+ "\");'></th></tr></table><table width='500' cellspacing='1px' cellpadding='1px'>"
											+ "<tr>"
											+ "<td class='multiRPTLabel' width='25%'>Last P.O. No.</td><td class='multiPOControl' width='25%'>"+lastPoNo+"</td>"
											+ "<td class='multiRPTLabel' width='25%'>Last P.O. Date</td><td class='multiPOControl' width='25%'>"+lastPoDate+"</td>"
											+ "</tr>"
											+ "<tr>"
											+ "<td class='multiRPTLabel' width='25%'>Last Rate / Unit</td><td class='multiPOControl' width='25%'>"+lastRate+"</td>"
											+ "<td class='multiRPTLabel' width='25%'>Supplied By</td><td class='multiPOControl' width='25%'>"+suppliedBy+"</td>"
											+ "</tr>"
											+ "<tr>"
											+ "<td class='multiRPTLabel' width='25%'>Specification</td><td colspan='3' class='multiPOControl' width='75%'>"+specification+"</td>"
											+ "</tr></table><table width='500' cellspacing='1px' cellpadding='1px'><tr class='FOOTER'><td colspan='4'></td></tr></table>";

								}
								

							//alert(reqValArry1);
							obj.innerHTML = "<div class='popup' style='display:none' id='itemDetailsDivId"
									+ gblLayerIndex
									+ "-"
									+ (i + 1)
									+ "'>" +""+popupContent+"</div><a style='color:blue;cursor: pointer;' onclick='display_popup_menu(this,\"itemDetailsDivId"
									+ ""
									+ gblLayerIndex
									+ "-"
									+ (i + 1)
									+ "\",\"\",\"\");'>"
									+ selectedItemsListVals[fetchArrayIndex]
									+ "</a>";

						} else {

							if (obj.type == "text") {
								obj.value = selectedItemsListVals[fetchArrayIndex];
							} else {
								obj.innerHTML = selectedItemsListVals[fetchArrayIndex];
							}
 

						}

					} else {

						if (obj.type == "text") {
							obj.value = "";
						} else {
							obj.innerHTML = "/";
						}
												
					}

				}
			}

			var itemTempValArry = selectedItemsList[i].value.split('#');
	
			document.getElementById("itemParamValue" + gblLayerIndex + "-"+ (i + 1)).value = selectedItemsList[i].value;

			document.getElementById("itemCalcValue" + gblLayerIndex + "-"+ (i + 1)).value = itemTempValArry[1];

			document.getElementById("itemUserValue" + gblLayerIndex + "-"+ (i + 1)).value = itemTempValArry[2];

		document.getElementById("itemUserValue" + gblLayerIndex + "-"+ (i + 1)).disabled = true;

		}

	}

	var newItemParamLen = document.getElementsByName("itemParamValue").length;

	if (newItemParamLen > 1) {
		document.getElementById("id" + gblLayerIndex).style.display = "block";
	} else {
		document.getElementById("id" + gblLayerIndex).style.display = "none";
	}

	//hidePopup();
	
	document.getElementById("normalMsg").style.display="none";//hiding normal msg
	toggle('blanket');
	
	 
	//unSelectListRecords("strSelectedItemList");
	//unSelectListRecords("strItemList");
	//unSelectListRecords("strBrandedItemList");
 

	if (gblUserFunctionName != "" && gblUserFunctionName.length > 0) {
		if (gblUserArgument != "" && gblUserArgument.length > 0) // with user
		// argument
		{
			
		 			
			eval(gblUserFunctionName + "('" + gblUserArgument + "')");
		} else // without user argument
		{
			
			 			
			eval(gblUserFunctionName);
			
			
			if(gblUserFunctionName=="FunctionTechCalling")
			{
			   FunctionTechCalling();
			}  
		}
	}

}


function loading_msg(){
	 var qh=80;
	 var qw=300;
	 var dh=0;
	 var dw=0;
	 
	   if(window.innerHeight){
	   	  dh=window.innerHeight;
	   	  dw=window.innerWidth;
	   }else {
	   	  dh=document.documentElement.clientHeight;
	   	  dw=document.documentElement.clientWidth;
	   }
	   
	 var tpos=parseInt((dh-qh)/2);
	 var lpos=parseInt((dw-qw)/2); 
	 var wt='<div id="qmvi_loading_div" style="top:'+tpos+'px;left:'+lpos+'px;height:'+qh+'px;width:'+qw+'px;position:absolute;text-align:center;font-family:Arial;text-decoration:none;font-weight:normal;font-size:13px;color:#00224A;background-color:#ffffff;border-width:1px;border-color:#828EA2;border-style:solid;">';
	 wt+='<div style="padding:20px;"><img src="../../hisglobal/images/loading.gif" width=16 height=16><br><br><font size="2" weight="bold">Fetching Details.Please Wait!</font></div>';
	 wt+='</div>';
	 
	 document.getElementById("normalMsg").innerHTML=wt;
	  document.getElementById("normalMsg").style.display = "block";
	 }


 /**
  * 
  * @param divId
  * @param divId1
  * @param divId2
  * @return
  */
function showDetails(divId, divId1, divId2) {

	document.getElementById(divId).style.display = "block";

	document.getElementById('minus' + divId).style.display = "block";
	document.getElementById('plus' + divId).style.display = "none";

	if(document.getElementById(divId1) != null){
	
		document.getElementById(divId1).style.display = "none";

	document.getElementById('minus' + divId1).style.display = "none";
	document.getElementById('plus' + divId1).style.display = "block";
		
	}

	
	if(document.getElementById(divId2) != null){
		
		document.getElementById(divId2).style.display = "none";

	document.getElementById('minus' + divId2).style.display = "none";
	document.getElementById('plus' + divId2).style.display = "block";
		
	}
	

}

/**
 * 
 * @param divId
 * @return
 */
function hideDetails(divId) {

	document.getElementById(divId).style.display = "none";

	document.getElementById('minus' + divId).style.display = "none";
	document.getElementById('plus' + divId).style.display = "block";

}


/**
 * getAddNewItemScreen
 
 */
 function getAddNewItemScreen() {
 	 	 
 	 	 
 	 	 var genItem = document.forms[0].strItemList[document.forms[0].strItemList.selectedIndex].value;
 	 	 
 	 	 if(genItem == 0){
  
 	 		alert("Please Select a Generic Item");
 	 		document.forms[0].strItemList.focus();
 	 		document.forms[0].strNewItemCheck.checked = false;	
  	 		return false;
 	 		
 	 	}
 	 	 
 	 	 
 			document.forms[0].strNewItemCheck.checked = false;	
 	 	
 	 		var hmode = "GETADDNEWITEM";
			var url = "MmsCNT.cnt?hmode=" + hmode + "&strGenericItemDtls=" + genItem+"&strNewItemFlag="+document.forms[0].strNewItemFlag.value ;
			 			
			ajaxFunction2(url, "4", "getMyAjaxResponse");
 	 	
 }



/**
 * resetNewItemDetails
 */
 function resetNewItemDetails() {
 	
 	document.getElementById("newItemErrorContentDivId").innerHTML = "";
 				document.getElementById("newItemErrorPartDivId").style.display = "none";
 	
	 document.forms[0].strNewItemName.value = "";
	 document.forms[0].strNewItemType.selectedIndex = 0;
	 document.forms[0].strNewItemMake.selectedIndex = 0;
	 document.forms[0].strNewItemManufacturer.selectedIndex = 0;
	 document.getElementsByName("strNewItemIsQuantifiable")[0].checked = false;
	 document.getElementsByName("strNewItemIsSetSachet")[0].checked = false;
	 document.forms[0].strNewItemSpecification.value = "";
	 document.forms[0].strNewItemShortName.value = "";
	 document.forms[0].strNewItemReorderLevel.value = "";
	 document.forms[0].strNewItemMaxLevel.value = "";
	 document.forms[0].strNewItemLevelUnit.selectedIndex = 0;
	  	
 }

	
	/**
	 * saveNewItemDetails
	 */
	 function saveNewItemDetails() {
	 	
	 	 var newItemFlag = document.forms[0].strNewItemFlag.value;
	 	
	 	
	 	 if(newItemFlag == 2){
	 	 	
	 	 	  var hisValidator = new HISValidator(document.forms[0].name);
              			
           hisValidator.addValidation("strNewItemName", "req", "Item Name is a Mandatory Field" );
	 	 	var retVal = hisValidator.validate(); 
    	
    	
          if(retVal){
          	
          	
          					var itemName = document.forms[0].strNewItemName.value;
          					var defaultUnitId = document.forms[0].strDefaultUnitId.value;
          				 	var itemDtls = "";     
          				 	          				  	
          				  	if(gblMode == 2){
          				  		
          				  		 itemDtls = document.forms[0].strNewItemName.value + "^0^0#0#0^0^0^0^0^0^0^"+defaultUnitId+"^0^0";
          				  		
          				  		          				  		 			
          				  		
          				  	}else if (gblMode == 4){
          				  		
          				  		 itemDtls = document.forms[0].strNewItemName.value + "^0^"+defaultUnitId+"^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0";
          				  		 			
          				  		
          				  		
          				  	}else{
          				  		
          				  		 itemDtls = document.forms[0].strNewItemName.value + "^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0"+
          				  		 			"#"+
          				  		 			"0^0^0^"+
          				  		 			"#"+
          				  		 			"0^0^0^0^0^0^0^"+defaultUnitId+"^0^0^"+defaultUnitId+"^"+defaultUnitId+"^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0^0" ;
          				  		 			          				  		
          				  	}
          				  	 
							  var elOptNew = document.createElement('option');
							  elOptNew.text = itemName;
							  elOptNew.value = itemDtls;
							  var elSel = document.getElementsByName('strSelectedItemList')[0];
							
							  try {
							    elSel.add(elOptNew, null); // standards compliant; doesn't work in IE
							  }
							  catch(ex) {
							  								  	
							    elSel.add(elOptNew); // IE only
							  }
							 
          				  	  elSel.selectedIndex = elSel.length - 1 ;
          				  	
          				  	
          				  	
          				  		gblNewItemHighlight = "1";
				
 								document.getElementById("itemSearchPartDivId").style.display = "block";
 								document.getElementById("newItemsAddPartDivId").style.display = "none";
          				  	
          	
          }
	 	 	
	 	 }else{
	 	 		 	 	
	 	 	
	 	 		 var hisValidator = new HISValidator(document.forms[0].name);
              			
           hisValidator.addValidation("strNewItemName", "req", "Item Name is a Mandatory Field" );
    		hisValidator.addValidation("strNewItemType", "dontselect=0","Please select an Item Type " );
    		hisValidator.addValidation("strNewItemMake", "dontselect=0","Please select an Item Make " );
    		hisValidator.addValidation("strNewItemManufacturer", "dontselect=0","Please select a Manufacturer " );
    		hisValidator.addValidation("strNewItemSpecification", "maxlen=100","Specification cannot be greater than 100 Characters " );
    		if(document.forms[0].strAddNewItemHiddenVal.value.split("^")[4] == '1'){
    		
    			hisValidator.addValidation("strNewItemShortName", "req", "Item Short Name is a Mandatory Field" );
    			hisValidator.addValidation("strNewItemReorderLevel", "req", "Re-order Level is a Mandatory Field" );
    			hisValidator.addValidation("strNewItemMaxLevel", "req", "Max Level is a Mandatory Field" );
    			hisValidator.addValidation("strNewItemLevelUnit", "dontselect=0","Please select an Level Unit " );
    		}
    		
    	      	
    	 var retVal = hisValidator.validate(); 
    	
    	
          if(retVal){
          				 
          				 
          				 var strShortName = "0";
          				 var strReorderLevel = "0";
          				 var strMaxLevel = "0";
          				 var strLevelUnit = "0";
          				 var strUnitName = "";
          				 
          				 
          				 if(document.forms[0].strAddNewItemHiddenVal.value.split("^")[4] == '1'){
	          				 strShortName = document.forms[0].strNewItemShortName.value;
	          				 strReorderLevel =  document.forms[0].strNewItemReorderLevel.value;
	          				 strMaxLevel =  document.forms[0].strNewItemMaxLevel.value;
	          				 strLevelUnit = document.forms[0].strNewItemLevelUnit[document.forms[0].strNewItemLevelUnit.selectedIndex].value;
	          				 strUnitName = document.forms[0].strNewItemLevelUnit[document.forms[0].strNewItemLevelUnit.selectedIndex].text;
	          			}
          				 
          				 
          				 var isQuantify = '0';
          				 var isSetSatch = '0';
          				 
          				 if(document.getElementsByName("strNewItemIsQuantifiable")[0].checked == true)
          				 	isQuantify = '1'; 
          				 
          				  if(document.getElementsByName("strNewItemIsSetSachet")[0].checked == true)
          				 	isSetSatch = '1'; 
          				 
          				
          				 
          				 
          				 	
          				 	
          				var hmode = "SAVENEWITEMDTLS";
				var url = "MmsCNT.cnt?hmode=" + hmode + "&strGenericItemDtls=" + document.forms[0].strAddNewItemHiddenVal.value 
							+"&strNewItemName="+document.forms[0].strNewItemName.value
							+"&strNewItemType="+document.forms[0].strNewItemType[document.forms[0].strNewItemType.selectedIndex].value
							+"&strNewItemMake="+document.forms[0].strNewItemMake[document.forms[0].strNewItemMake.selectedIndex].value
							+"&strNewItemManufacturer="+document.forms[0].strNewItemManufacturer[document.forms[0].strNewItemManufacturer.selectedIndex].value
							+"&strNewItemSpecification="+document.forms[0].strNewItemSpecification.value
							+"&strNewItemShortName="+strShortName
							+"&strNewItemReorderLevel="+strReorderLevel
							+"&strNewItemMaxLevel="+strMaxLevel
							+"&strNewItemLevelUnit="+strLevelUnit
							+"&isQuantify="+isQuantify+"&isSetSatch="+isSetSatch+"&strStoreId="+gblFromStoreId+"&strGroupId="+gblStrGroupIdForItemSearch;
						
							ajaxFunction2(url, "5", "getMyAjaxResponse");
          				 	
          				 
          				     				 
          				 
            }else{
					return false;
				 }
	 	 		
	 	 	
	 	 	
	 	 	
	 	 	
	 	 }
	 	 
	 }


/**
 * cancelAddNewItemPopup
 *   
 */
 function cancelAddNewItemPopup() {
 	
 		var conf = confirm("Are you Sure, You want to Cancel the Process");
 	
 		if(conf){
 			
 		document.getElementById("newItemsAddPartDivId").innerHTML = "";
		
 		document.getElementById("itemSearchPartDivId").style.display = "block";
 		document.getElementById("newItemsAddPartDivId").style.display = "none";
 			
 		}else{
 			
 			return false;
 		}
 	
 		
 	
 }
	
		


/*
 function createSelectedList(index) {


 selectListRecords("strSelectedItemList");

 var selectedItemsList = document.forms[0].strSelectedItemList;
 var selectedItemListLen = selectedItemsList.length;

 var itemHiddenParamDtls = document.getElementsByName("itemParamValue");
 var itemHiddenParamLength = itemHiddenParamDtls.length;

 var rowIndexArray = new Array(itemHiddenParamLength - 1);

 var arr2 = new Array(itemHiddenParamLength - 1);

 for(var i = 0 ; i < itemHiddenParamLength - 1; i++){

 arr2[i] = itemHiddenParamDtls[i].value;
 }


 if(itemHiddenParamLength > 1){


 var arr = new Array(selectedItemListLen);


 for(var ind=0; ind<selectedItemListLen; ind++) {

 arr[ind] = "";

 for(var index2=0; index2<itemHiddenParamLength - 1; index2++) {

 if(selectedItemsList[ind].value == itemHiddenParamDtls[index2].value){

 arr[ind] = selectedItemsList[ind].value;

 arr2[index2] = "";


 }

 }	

 }	



 var delArray = new Array();
 var count2 = parseInt("1");
 var arrayCount = parseInt("0");
 do{

 var divVal = document.getElementById("id"+index+"-"+count2);	

 if(divVal == null) break;

 if(divVal.innerHTML.length > 0){

 delArray[arrayCount] = count2 - 1;

 arrayCount = arrayCount + 1;

 }

 count2 = count2 + 1;

 }while(true);


 for(var ind2=0; ind2<itemHiddenParamLength; ind2++) {

 if(arr2[ind2] != null && arr2[ind2] != ""){

 deleteRow(index+"-"+(delArray[ind2] + 1),'1','0');

 }

 }




 for(var i = 0 ; i < selectedItemListLen ; i++){


 if(arr[i] == ""){


 addRows(new Array('itemParamValue','strGender','strQty'),new Array('t','s','t'),index,'1','R');

 initializeData(index , i , selectedItemsList , 1);


 }

 }

 }else{


 for(var i = 0, len = selectedItemsList.length; i< len ; i++){

 var itemListVal = selectedItemsList[i].value;
 var itemListValArr = itemListVal.split("@");


 addRows(new Array('itemParamValue','strGender','strQty'),new Array('t','s','t'),index,'1','R');			

 initializeData(index , i , selectedItemsList , 0)


 }
 }




 //descDivObj.style.display = "block";


 document.getElementById("id1").style.display = "block";

 hidePopup();

 unSelectListRecords("strSelectedItemList");

 } 
 */

/*
 * function initializeData(index , i, selectedItemsList , mode) {
 * 
 * var innerDivObj = "";
 * 
 * 
 * if(mode == 1){
 * 
 * var myrowIndex =
 * parseInt(document.getElementsByName("rowIndex"+index)[0].value);
 * 
 * innerDivObj = document.getElementById("id"+index+"-"+myrowIndex
 * ).getElementsByTagName("div");
 * 
 * }else{
 * 
 * innerDivObj = document.getElementById("id"+index+"-"+(i +
 * 1)).getElementsByTagName("div"); }
 * 
 * var itemListVal = selectedItemsList[i].value; var itemListValArr =
 * itemListVal.split("@");
 * 
 * document.getElementsByName("itemParamValue")[i].value = itemListVal;
 * 
 * for(var j = 0, len1 = innerDivObj.length; j< len1 ; j++){
 * 
 * var sourceInnerDivId = innerDivObj[j].id; var itemParamIndex =
 * sourceInnerDivId.charAt(sourceInnerDivId.length - 1);
 * 
 * if(itemListValArr[itemParamIndex] != undefined){
 * 
 * innerDivObj[j].innerHTML = itemListValArr[itemParamIndex];
 * 
 * }else{
 * 
 * innerDivObj[j].innerHTML = ""; } } }
 * 
 */

/**
 * cancelPopupLogic
 * 
 */

/*
 * function cancelPopupLogic() {
 * 
 * hidePopup();
 * 
 * selectListRecords("strItemList");
 * 
 * var selectedItemsList1 = document.forms[0].strItemList;
 * 
 * unSelectListRecords("strItemList");
 * 
 * var itemHiddenParamDtls = document.getElementsByName("itemParamValue");
 * 
 * 
 * for(var i=0 ; i<selectedItemsList1.length; i++) {
 * 
 * for(var j=0 , len2 = itemHiddenParamDtls.length - 1 ; j<len2; j++) {
 * 
 * if(selectedItemsList1[i].value == itemHiddenParamDtls[j].value){
 * 
 * selectedItemsList1[i].selected = true;
 * shiftToLeft("strSelectedItemList","strItemList",1); } } }
 * 
 * 
 * 
 * selectListRecords("strSelectedItemList");
 * 
 * var selectedItemsList2 = document.forms[0].strSelectedItemList;
 * 
 * unSelectListRecords("strSelectedItemList");
 * 
 * var flg = false;
 * 
 * for(var i=0 ; i<selectedItemsList2.length; i++) {
 * 
 * 
 * flg = false;
 * 
 * for(var j=0 , len2 = itemHiddenParamDtls.length - 1 ; j<len2; j++) {
 * 
 * if(selectedItemsList2[i].value == itemHiddenParamDtls[j].value){
 * 
 * flg = true; } }
 * 
 * if(!flg){
 * 
 * selectedItemsList2[i].selected = true;
 * shiftToLeft("strItemList","strSelectedItemList",1);
 * 
 * i = i-1; } }
 * 
 * unSelectListRecords("strItemList");
 * unSelectListRecords("strSelectedItemList"); }
 */