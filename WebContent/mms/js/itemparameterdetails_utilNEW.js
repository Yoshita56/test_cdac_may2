
 
 
 // Global Parameters
 
 	var gblParentObj = "";
 	var gblIndex = "";
 	var gblDivId = "" ;
 	var gblItemCatCode = "";
 	var gblItemId = "";
 	var gblMode = "";
 
  /**
	 * showParameterDetails - Invokes Ajax Function and displays Popup 	 
	 * @param {object} parentObj - Button or Image Object
	 * @param {String} modeVal - 1 - Item Parameter Parent Add Screen Opens
	 * 							 2 - Item Parameter Parent Modify Screen Opens
	 * 							 3 - Item Parameter Parent View Screen Opens
	 * @param {String} itemCatCode - Item Category Code
	 */
function showPopup(parentObj , modeVal , itemCatCode , itemId){
	
		
	gblMode = modeVal;
	gblParentObj = parentObj;
	gblItemCatCode = itemCatCode;
	gblItemId = itemId;
	
	var itemParaObj = document.getElementById("itemParameterDtlDivId");
	
	if(modeVal == '1'){
		
			
			
		if(itemParaObj.innerHTML == ""){
		
			var hmode = "ITEMPARAMUTLINITNEW"; 
			var url = "MmsCNT.cnt?hmode="+hmode+"&strMode="+modeVal+"&strItemCatNo="+itemCatCode;
			
					
			ajaxFunction2(url,"1" , "itemParamAjaxResponse");
			
					
		}else{
			popup('popUpDivId','100','250');
			//display_popup_menu(gblParentObj,'itemParameterDtlDivId','200','');
		}
		
	}else if (modeVal == '2'){
		
	
	if(itemParaObj.innerHTML == ""){
	
			var hmode = "ITEMEXEPARAMDTL"; 
			var url = "MmsCNT.cnt?hmode="+hmode+"&strMode=3&strItemCatNo="+itemCatCode+"&strItemId="+itemId;
						
			
				ajaxFunction2(url,"3" , "itemParamAjaxResponse");
			
		}else{
			popup('popUpDivId','100','250');
			//display_popup_menu(gblParentObj,'itemParameterDtlDivId','200','');
		}
		
		
	}else if (modeVal == '3'){
		
		
		if(itemParaObj.innerHTML == ""){
		
			var hmode = "ITEMPARAMUTLDISPLAY"; 
			var url = "MmsCNT.cnt?hmode="+hmode+"&strMode=5&strItemId="+itemId;
			
				ajaxFunction2(url,"6" , "itemParamAjaxResponse");
			
		}else{
			popup('popUpDivId','100','150');
			
			//display_popup_menu(gblParentObj,'itemParameterDtlDivId','200','');
		}
		
	}
}


/**
 * getParentParamInModify
 * @param {type} param 
 */
 function getParentParamInModify() {
 	
 	var hmode = "ITEMPARAMUTLMODIFY"; 
			var url = "MmsCNT.cnt?hmode="+hmode+"&strMode=2&strItemCatNo="+gblItemCatCode;
			
 		ajaxFunction2(url,"4" , "itemParamAjaxResponse");
 }


 /**
	 * getAjaxResponse - Invoke by Ajax function 	 
	 * @param {String} res - Result of the Ajax Response
	 * @param {String} mode - mode of the response
	 */
function itemParamAjaxResponse(res,mode){
	
		if(mode == '1'){

		var itemParaObj = document.getElementById("itemParameterDtlDivId");
		
		itemParaObj.innerHTML = res;
			
			popup('popUpDivId','100','250');
			
			//display_popup_menu(gblParentObj,'itemParameterDtlDivId','','');
			
		}

	if(mode == '2'){

	 

		var itemParaObj = document.getElementById("ParameterId"+gblIndex);
		
 
		
		itemParaObj.innerHTML = res;
						
		}
		
		if(mode == '3'){

		var itemParaObj = document.getElementById("itemParameterDtlDivId"+gblIndex);
		
		itemParaObj.innerHTML = res;
			
			popup('popUpDivId','100','250');
						
		//display_popup_menu(gblParentObj,'itemParameterDtlDivId','200','');				
						
		getParentParamInModify();				
						
		}
		

	if(mode == '4'){

		var itemParaObj = document.getElementById("itemParameterSubDtlDivId");
		
		itemParaObj.innerHTML = res;
			
			itemParaObj.style.display = "block";
						
		}

		if(mode == '5'){

		var itemParaObj = document.getElementById("ParameterId"+gblIndex);
		
		itemParaObj.innerHTML = res;
						
												
		}

if(mode == '6'){

		var itemParaObj = document.getElementById("itemParameterDtlDivId");
		
		itemParaObj.innerHTML = res;
			
			popup('popUpDivId','100','150');
				
		//	display_popup_menu(gblParentObj,'itemParameterDtlDivId','','');
			
		}

if(mode == '7'){

	 
		var itemParaObj = document.getElementById("ParameterId"+gblIndex);
		
		
		
		itemParaObj.innerHTML = res;
						
						
						
		}

}



	
/**
	 * hidePopup - hide the popup
	 * 
	 */
function hidePopup(){
	
	hide_popup('popUpDivId');
	
	//hide_popup_menu('itemParameterDtlDivId');
}
 
  
  /**
   * hideParamPopup
   
   */
   function hideParamPopup() {
   	
   	hide_popup_menu("itemOtherDtlsDiv");
   	
   }
 
 
 
 /**
  * getParameterDtlsInViewMode
  * @param {type} param 
  */
  function getParameterDtlsInViewMode(divId , index , parentParamId){
  	
  	
  	gblIndex = index;
		gblDivId = divId;
		
		
			var val = parseInt(document.getElementById("strIsParamFetch"+index).value);
	
					
		if(val == 0){
		
	document.getElementById("strIsParamFetch"+index).value = '1';
		
	 
			
			var hmode = "ITEMPARAMDTLDISPLAYFORVIEW"; 
		
				var url = "MmsCNT.cnt?hmode="+hmode+"&strParentParamId="+parentParamId+"&strParentParamIndex="+index+"&strItemId="+gblItemId;
				
				//alert("url 7: "+url);
				
				
					ajaxFunction2(url,"7" , "itemParamAjaxResponse");
				
		 
				
				showParameterDetails(divId , index );	
		
		return false;
				
		 
		}
  	
  	
  }
 
  
 
 /**
  * fetchParameterDetails
  * @param {type} param 
  */
  function fetchParameterDetails(divId , index , parentParamId) {
  	 
  	
  	
		gblIndex = index;
		gblDivId = divId;
		
		
			var val = parseInt(document.getElementById("strIsParamFetch"+index).value);
	
					
		if(val == 0){
		
	document.getElementById("strIsParamFetch"+index).value = '1';
		
		if(gblMode == '3' ){
			
			var hmode = "ITEMPARAMDTLDISPLAY"; 
		
				var url = "MmsCNT.cnt?hmode="+hmode+"&strParentParamId="+parentParamId+"&strParentParamIndex="+index+"&strItemId="+gblItemId;
				
				//alert("url 7: "+url);
				
				
					ajaxFunction2(url,"7" , "itemParamAjaxResponse");
		
				showParameterDetails(divId , index );	
		
		return false;
				
		}
		
			
			
			if(document.getElementById("itemParameterSubDtlDivId") == null){	
			
				var hmode = "ITEMPARAMDTL"; 
		
				var url = "MmsCNT.cnt?hmode="+hmode+"&strParentParamId="+parentParamId+"&strParentParamIndex="+index;
				
				
					ajaxFunction2(url,"2" , "itemParamAjaxResponse");
			
			}else{
		
			var hmode = "ITEMPARAMDTLMODI"; 
		
				var url = "MmsCNT.cnt?hmode="+hmode+"&strParentParamId="+parentParamId+"&strParentParamIndex="+index+"&strItemId="+gblItemId;
				
								
				
					ajaxFunction2(url,"5" , "itemParamAjaxResponse");
		
						
	}
			
			
		}
			
				
			showParameterDetails(divId , index );	
		
  	
  }
 
 
	 /**
	 * showParameterDetails - shows the given divId by showing the minus image and hiding the plus image.
	 * 						  also checks the open status of the div part, based on the open status 	 
	 * @param {String} divId - div id which should be shown.
	 * @param {String} index - index of the Parent Parameter
	 * @param {String} parentParamId - Parent Parameter Id 
	 */
	function showParameterDetails(divId , index ){
		
		
		
		var openStatusObj = document.getElementsByName("strOpenStatus");
		var len = openStatusObj.length;
	//	var cancelRes = false;
		var count = parseInt("0");
		
				
		for(var i=0; i < len ; i++){
			
			if(openStatusObj[i].value != '0'){
				
				alert("Please Close the Existing Block to Open a New One");
				
				break;
				
				/*if(conf){
				cancel(divId,openStatusObj[i].value , '2');
				hideParameterDetails(divId , index);
				
				}else{
						cancelRes = true;
					break;
				} */
				
			} else{
				count = count + 1;
			}
						
		}
		
		if(len == 0 || len == count ){
		
					
		document.getElementById(divId).style.display="block";
		document.getElementById("strOpenStatus"+index).value = index;
		document.getElementById('minus'+ divId).style.display="block";
		document.getElementById('plus' + divId).style.display="none";
		}
	}
	
	
	
	/**
	 * hideParameterDetails - hide the given divId by hiding the minus image and showing the plus image.
	 * @param {String} divId - div id which should be shown.
	 * @param {String} index - div index
	 */
	function hideParameterDetails(divId , index){
		
		document.getElementById(divId + index).style.display="none";	
		document.getElementById("strOpenStatus"+index).value = 0;			
		document.getElementById('minus'+ divId + index).style.display="none";
		document.getElementById('plus'+ divId + index).style.display="block";
		
	}
	
	
	/**
	 * saveData
	 * @param {String} divId - div id which should be shown.
	 * 
	 */
	 function saveData(divId) {
	 	
	 
	 	var chkCount = parseInt("0");
	 	var paramChkObj = document.getElementsByName("strParamCheck");
	 	var len = paramChkObj.length;
	 	
	 	var statusObj = document.getElementsByName("strParamStatus");
	 	 
	 	 if(statusObj.length > 0){
	 	 	
	 	 	popup('popUpDivId','100','250');
	 	 	 return true;
	 	 }
	 	
	 	if( len > 0){
	 		
	 		for(var i = 0 ; i < len ; i ++) {
	 				 			
	 			if(paramChkObj[i].checked) {
	 					chkCount = chkCount + 1;
	 			}
	 		}
	 			 	
	 		if(chkCount == 0){
	 			alert("Atleast One Value Should be Entered");
	 			
	 			return false;
	 			
	 		}else{
	 			
	 			popup('popUpDivId','100','250');
	 			
	 		}
	 	
	 	}else{
	 		alert("Atleast One Value Should be Entered");
	 		return false;
	 	}
	
	 	 
	
	 return true;
		
	
	 	
	 } 
	
		
	
	/**
	 * ok
	 * @param {object} divId - div id which should be shown.
	 * @param {String} index 
	 * 
	 * returns - true - Atleast One check box has been checked and corresponding parameter value has been entered
	 * 			 false - Otherwise
	 * 
	 */
	 function ok(divId , index , mode) {
	 	
	 	 	
	 	if(mode == '1'){
	 	
	 	var count = parseInt("1");
	 	var checkCount = parseInt("0");
	 			do{
	 					 				
	 				var paramChkObj = document.getElementById("strParamCheck"+index +count);
	 				var paramObj = document.getElementById("strParamValue"+index +count);
	 				
	 				if(paramChkObj != null){
	 				if(paramChkObj.checked){
	 					checkCount = checkCount + 1;
	 					if(paramObj.value == ''){
	 						
	 						alert("Parameter Value is a Manadatory Field");
	 						paramObj.focus();
	 						
	 						return false;
	 					}	
	 					
	 				}
	 				}else {
	 					
	 					if(checkCount == 0){
	 						
	 						alert("Atleast One Value Should be Entered");
	 						return false;
	 					}
	 					
	 					break;
	 				}
	 				count = count + 1;
	 			}while(true);	 	
	 			
	 	}
	 		document.getElementById("patParamEntryDivId"+index).style.display = "block";	
	 			
	 			hideParameterDetails(divId , index);
	 			return true;
	 			
	 }
	
	
	/**
	 * cancel
	 *  @param {object} divId - div id which should be shown.
	 * 	@param {String} index - div index
	 * 	@param {String} mode - 1 - Cancel button event, 2 - plus button event
	 */
	 function cancel(divId , index , mode) {
	 	
	 	var conf = true;
	 	
	 	if(mode == '1'){
	 		if(findCheckStatus(index)){
	 		
	 			conf = confirm("Are your sure, Existing Data will Discard");
	 		}
	 	}
	 	
	 
	 	
	 	if(conf){
	 		var count = parseInt("1");
	 			do{
	 				var paramObj = document.getElementById("strParamValue"+index +count);
	 				var paramChkObj = document.getElementById("strParamCheck"+index +count);
	 				
	 				if(paramObj != null){
	 					paramObj.value = "";
	 					paramObj.disabled = true;
	 					paramChkObj.checked = false;
	 				}else{
	 					break;
	 				}
	 				count = count + 1;
	 			}while(true);	 	
	 			
	 			 			
	 	}
	 	
	 	if(conf){
	 		
	 		document.getElementById("patParamEntryDivId"+index).style.display = "none";	
	 		
	 		hideParameterDetails(divId , index);
	 	}
	 	 	
	 }
	
	
	/**
	 * activateParameter
	 * @param {Checkbox Object} chkObj 
	 * @param {var} parentIndex
	 * @param {var} index
	 */
	 function activateParameter(chkObj,parentIndex , index) {
	 	
	 	if(chkObj.checked == true){
	 		
	 		document.getElementById("strParamValue"+parentIndex+index).disabled = false;
	 		
	 	}else{
	 		document.getElementById("strParamValue"+parentIndex+index).value = "";
	 		document.getElementById("strParamValue"+parentIndex+index).disabled = true;
	 	}
	 	
	 } 
	 
	 /**
	  * activateParameterByCombo
	  * @param {Combo Object} chkObj 
	 * @param {var} parentIndex
	 * @param {var} index
	  */
	  function activateParameterByCombo(cmbObj,parentIndex , index) {
	  	
	  	if(cmbObj.value == '1'){
	  		document.getElementById("strParamValue"+parentIndex+index).disabled = false;
	  	}else{
	 		document.getElementById("strParamValue"+parentIndex+index).disabled = true;
	 	}
	  }
	 
	 
	 /**
	  * findCheckStatus
	  * @param {String} index - div index
	  * 
	  * returns - true : if any check box is selected, false : if no check box selected  
	  */
	  function findCheckStatus(index) {
	  	
	  	var result = false;
	  	var count = parseInt("1");
	 	do{
	 		var paramObj = document.getElementById("strParamCheck"+index +count);
	 		
	 		if(paramObj != null){
	 			
	 			if(paramObj.checked == true ) result = true;
	 			
	 		}else{
	 			return result;
	 		}
	 		
	 		count = count + 1;
	 	}while(true);
	 	
	 	return result;
	  }
	 
	 
	 



// Function for Numeric(11,2)
function numericWithTwoDecimalPlaces(fld, milSep, decSep, e)
{
	var sep = 0;
	var key = '';
	var milSep="";
	var i = j = 0;
	var len = len2 = 0;
	var strCheck = '0123456789';
	var aux = aux2 = '';
	var whichCode = (window.Event) ? e.which : e.keyCode;
	//if (whichCode == 13) return true;  // Enter
	if (whichCode == 0)	return true; //tab-index
	//alert(whichCode);
	if (whichCode == 8) return true;  // Back-Space 
	key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		//len = fld.value.length;
		len=11;
		for(i = 0; i < len; i++)
		if ( (fld.value.charAt(i) != decSep)) break;
		aux = '';
	for(; i < len; i++)
	if (strCheck.indexOf(fld.value.charAt(i))!=-1) aux += fld.value.charAt(i);
	aux += key;
	len = aux.length;
	if (len == 0) fld.value = '';
	if (len == 1) fld.value = ''+ decSep + '' + aux;
	if (len == 2) fld.value = ''+ decSep + aux;
	if (len > 2) {
	aux2 = '';
	for (j = 0, i = len - 3; i >= 0; i--) {
	if (j == 3) {
	aux2 += milSep;
	j = 0;
}
aux2 += aux.charAt(i);
j++;
}
fld.value = " ";
len2 = aux2.length;
for (i = len2 - 1; i >= 0; i--)
fld.value += aux2.charAt(i);
fld.value += decSep + aux.substr(len - 2, len);
}
return false;
}	

	 