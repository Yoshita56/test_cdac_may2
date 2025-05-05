
 
 
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
		
			var hmode = "ITEMPARAMUTLINIT"; 
			var url = "MmsCNT.cnt?hmode="+hmode+"&strMode="+modeVal+"&strItemCatNo="+itemCatCode;
			ajaxFunction(url,"1");
			
		}else{
			display_popup_menu(gblParentObj,'itemParameterDtlDivId','200','');
		}
		
	}else if (modeVal == '2'){
		
	
	if(itemParaObj.innerHTML == ""){
	
			var hmode = "ITEMEXEPARAMDTL"; 
			var url = "MmsCNT.cnt?hmode="+hmode+"&strMode=3&strItemCatNo="+itemCatCode+"&strItemId="+itemId;
						
			ajaxFunction(url,"3");
			
		}else{
			display_popup_menu(gblParentObj,'itemParameterDtlDivId','200','');
		}
		
		
	}else if (modeVal == '3'){
		
		
		if(itemParaObj.innerHTML == ""){
		
			var hmode = "ITEMPARAMUTLDISPLAY"; 
			var url = "MmsCNT.cnt?hmode="+hmode+"&strMode=5&strItemId="+itemId;
			ajaxFunction(url,"6");
			
		}else{
			display_popup_menu(gblParentObj,'itemParameterDtlDivId','200','');
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
			ajaxFunction(url,"4");
 	
 }


 /**
	 * getAjaxResponse - Invoke by Ajax function 	 
	 * @param {String} res - Result of the Ajax Response
	 * @param {String} mode - mode of the response
	 */
function getAjaxResponse(res,mode){
	
	//alert("Res : "+res);
	
		if(mode == '1'){

		var itemParaObj = document.getElementById("itemParameterDtlDivId");
		
		itemParaObj.innerHTML = res;
			
			display_popup_menu(gblParentObj,'itemParameterDtlDivId','','');
			
		}

	if(mode == '2'){

		var itemParaObj = document.getElementById("ParameterId"+gblIndex);
		
		itemParaObj.innerHTML = res;
						
						
						
		}
		
		if(mode == '3'){

		var itemParaObj = document.getElementById("itemParameterDtlDivId"+gblIndex);
		
		itemParaObj.innerHTML = res;
						
		display_popup_menu(gblParentObj,'itemParameterDtlDivId','200','');				
						
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
			
			display_popup_menu(gblParentObj,'itemParameterDtlDivId','','');
			
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
	hide_popup_menu('itemParameterDtlDivId');
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
		
		if(gblMode == '3'){
			
			var hmode = "ITEMPARAMDTLDISPLAY"; 
		
				var url = "MmsCNT.cnt?hmode="+hmode+"&strParentParamId="+parentParamId+"&strParentParamIndex="+index+"&strItemId="+gblItemId;
				
				//alert("url 7: "+url);
				
				ajaxFunction(url,"7");
				
				showParameterDetails(divId , index );	
		
		return false;
				
		}
		
			
			
			if(document.getElementById("itemParameterSubDtlDivId") == null){	
			
				var hmode = "ITEMPARAMDTL"; 
		
				var url = "MmsCNT.cnt?hmode="+hmode+"&strParentParamId="+parentParamId+"&strParentParamIndex="+index;
				
				ajaxFunction(url,"2");
			
			}else{
		
			var hmode = "ITEMPARAMDTLMODI"; 
		
				var url = "MmsCNT.cnt?hmode="+hmode+"&strParentParamId="+parentParamId+"&strParentParamIndex="+index+"&strItemId="+gblItemId;
				
								
				ajaxFunction(url,"5");
		
						
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
		
		alert("index : "+index);
			
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
	 *  @param {String} divId - div id which should be shown.
	 */
	 function saveData(divId) {
	 	
	 	var chkCount = parseInt("0");
	 	var paramChkObj = document.getElementsByName("strParamCheck");
	 	var len = paramChkObj.length;
	 	
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
	 			
	 				hide_popup_menu(divId);
	 			
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
	 