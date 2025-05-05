/**
* Author : Niharika Srivastava
* Module : MMS
* Description :  Java Script File For Serial No Generation Transaction
* Date of Creation : 14-Sep-10 
*/
	
	/**
	 * getItem Category Combo
	 * @param {Object} strStore 
	 */
 function getItemCategoryCombo(strStore) {
 		
 		
			var hmode = "GETITEMCATLIST"; 
			var url = "SerialNoGenerationTransCNT.cnt?hmode="+hmode+"&storeId="+strStore.value;
			
 			ajaxFunction(url,"1");
					
 }
	 /**
	 * getItem Category Combo In Reprint Page
	 * @param {Object} strStore
	 */
 function getItemCategoryComboRe(strStore) {
 		
			var hmode = "GETITEMCATLIST"; 
			var url = "SerialNoGenerationTransCNT.cnt?hmode="+hmode+"&storeId="+strStore.value;
			
 			ajaxFunction(url,"3");
					
 }
	 
 function getItemName(strItemCat){
	var hmode= "GETITEMNAMELIST";
 	 var temp = document.forms[0].strStoreId.value;
 	var url = "SerialNoGenerationTransCNT.cnt?hmode="+hmode+"&itemCat="+strItemCat.value+"&storeId="+temp;
 	alert(url);
 	ajaxFunction(url,"2");
 }
	 /**
	 * getItem Category Combo
	 *
	 */
 function getReportNameCombo() {
 			
 	if(document.getElementsByName("strStoreId")[0].value=="0"){
		alert("Please Select Store From Combo");
	}
	else if(document.getElementsByName("strItemCategoryId")[0].value=="0"){
		alert("Please Select Item Category From Combo");
	}
	else{
			var hmode = "GETREPORTNAME"; 
			var strStoreId = document.forms[0].strStoreId.value;
			var strItemCat = document.forms[0].strItemCategoryId.value;
			var strToDate = document.forms[0].strToDate.value;
			var strFromDate = document.forms[0].strFromDate.value;
			
			var url = "SerialNoGenerationTransCNT.cnt?hmode="+hmode+"&storeId="+strStoreId+"&itemCat="+strItemCat+"&from_date="+strFromDate+"&to_date="+strToDate;
			
 			ajaxFunction(url,"4");
		}			
 }
 function getAjaxResponse(res, mode) {
	
	var objVal;
	if (mode == "1") {
		alert(res);
		objVal = document.getElementById("itemCategoryDivId");
		objVal.innerHTML = "<select name='strItemCategoryId' onchange='getItemName(this);' class='comboNormal'>"+res+"</select>";
		
		}
	if (mode == "2") {
		alert(res);
		objVal = document.getElementById("itemNameDivId");
		objVal.innerHTML = "<select name='strItemName' onchange='getAvailQty()' class='comboNormal'>"+res+"</select>";
		
		}
		if (mode == "3") {
		objVal = document.getElementById("itemCategoryDivId");
		objVal.innerHTML = "<select name='strItemCategoryId' class='comboNormal'>"+res+"</select>";
		}
		
		if (mode == "4") {
		objVal = document.getElementById("reportNameDivId");
		objVal.innerHTML = "<select name='strReportName' class='comboNormal'>"+res+"</select>";
		}
		
	}
	/*
	* Function To View Reprint Page
	*/	
function getReprintPage()
{
	if(document.getElementsByName("strReprintChk")[0].checked){
		document.forms[0].hmode.value="REPRINTPAGE";
		document.forms[0].submit();
	}
}
	
	/*
	Function To Cancel Re-Print Page
	*/
function cancelRePrintPage(){
	document.forms[0].hmode.value="unspecified";
	document.forms[0].submit();
}
	
	/*
	Function To Cancel Re-Print Page
	*/
function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].submit();
}
	/* Function To Clear Page*/
	
function clearPage(){
	document.forms[0].reset();
	objVal = document.getElementById("avlqtyDivid");
	objVal.innerHTML = "";
}
	
	/*Get Available Quantity*/
	
function getAvailQty(){
	var temp=document.forms[0].strItemName.value;
	var temp1=temp.split('^');
	document.forms[0].strAvlQty.value = temp1[1];
	objVal = document.getElementById("avlqtyDivid");
	objVal.innerHTML = "&nbsp;"+temp1[1];
}

	/* Function To check Entered 
		Quantity For Serial No Generation*/
		
	function checkAvlQty(){
		if((document.forms[0].strQtyForSerial.value) > (document.forms[0].strAvlQty.value)){
			alert("Quantity For Serial No Can't Be Greater Than Available Quantity");
			document.forms[0].strQtyForSerial.value = "";
		}
	}