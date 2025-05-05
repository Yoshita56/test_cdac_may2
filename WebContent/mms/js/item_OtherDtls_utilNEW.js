
	
	var gblLayerIndex = "";
	var gblFormBeanName = "";
	
	/**
	 * getItemOtherDetailsView
	 * @param {String} mode 
	 * @param {String} isBatchReq
	 * @param {String} isExpDtReq
	 */
	 function getItemOtherDetailsView(strMode , isBatchReq , isExpDtReq , layerIndex , formBeanName) {
	 	
	 	
	 		gblLayerIndex = layerIndex;
			gblFormBeanName = formBeanName;
	 	
	 		var hmode = "ITEMOTHERDTLSNEW";
			var url = "MmsCNT.cnt?hmode=" + hmode + "&strMode=" + strMode +"&strIsBatchReq="
										  +isBatchReq+"&strIsExpDtReq="+isExpDtReq;
			
			ajaxFunction2(url, "1", "getItemOtherDtlsAjaxResponse");
	 	
	 	
	 }
	 
	 
	 /**
	  * getGroupList
	  * @param {Object} itemCatObj 
	  */
	  function getGroupList(itemCatObj) {
	  	
	  	
	 		var hmode = "ITEMOTHERGROUPDTLS";
			var url = "MmsCNT.cnt?hmode=" + hmode + "&strItemCategory=" + itemCatObj.value;
			
			ajaxFunction2(url, "2", "getItemOtherDtlsAjaxResponse");
	 	
	  	
	  }
	 
	 
	  /**
	  * getSubGroupList
	  * @param {Object} groupObj 
	  */
	  function getSubGroupList(groupObj) {
	  	
	  	
	 		var hmode = "ITEMOTHERSUBGROUPDTLS";
			var url = "MmsCNT.cnt?hmode=" + hmode + "&strGroupId=" + groupObj.value;
			
			ajaxFunction2(url, "3", "getItemOtherDtlsAjaxResponse");
	 	
	  	
	  }
	 
	 
	 /**
	  * getGenItemList
	  */
	  function getGenItemList() {
	  	
	  	
	 		var hmode = "ITEMOTHERGENITEMDTLS";
	 		
	 		var strCategory = document.forms[0].strOtherItemCategory[document.forms[0].strOtherItemCategory.selectedIndex].value;
	 		var strGroupId = document.forms[0].strOtherItemGroup[document.forms[0].strOtherItemGroup.selectedIndex].value;
	 		var strSubGroupId = document.forms[0].strOtherGenericItem[document.forms[0].strOtherGenericItem.selectedIndex].value;
	 		
			var url = "MmsCNT.cnt?hmode=" + hmode + "&strSubGroupId=" + strSubGroupId +"&strCategory="+strCategory+"&strGroupId="+strGroupId;
			
			ajaxFunction2(url, "4", "getItemOtherDtlsAjaxResponse");
	 	
	  	
	  	
	  }
	 
	 
	 /**
	  * getItemList 
	  */
	  function getItemList() {
	  	
	  	var hmode = "ITEMOTHERITEMDTLS";
	 		
	 		var strCategory = document.forms[0].strOtherItemCategory[document.forms[0].strOtherItemCategory.selectedIndex].value;
	 		var strGroupId = document.forms[0].strOtherItemGroup[document.forms[0].strOtherItemGroup.selectedIndex].value;
	 		var strSubGroupId = document.forms[0].strOtherItemSubGroup[document.forms[0].strOtherItemSubGroup.selectedIndex].value;
	 		var strItemId 	  = document.forms[0].strOtherGenericItem[document.forms[0].strOtherGenericItem.selectedIndex].value;
	 		
			var url = "MmsCNT.cnt?hmode=" + hmode + "&strSubGroupId=" + strSubGroupId +"&strCategory="
										  +strCategory+"&strGroupId="+strGroupId+"&strItemId="+strItemId;
			
			
			ajaxFunction2(url, "5", "getItemOtherDtlsAjaxResponse");
	  	
	  }
	 
	 /**
	  * getUnitList
	   
	  */
	  function getUnitList() {
	  	
	  	var hmode = "GETOTHERITEMUNITCOMBO";
	  	
	  	var strItemId 	  = document.forms[0].strOtherGenericItem[document.forms[0].strOtherGenericItem.selectedIndex].value;
	  	var strCategory = document.forms[0].strOtherItemCategory[document.forms[0].strOtherItemCategory.selectedIndex].value;
	 		
			var url = "MmsCNT.cnt?hmode=" + hmode +"&strItemId="+strItemId+"&strCategoryNo="+strCategory;
			
				
			ajaxFunction2(url, "6", "getItemOtherDtlsAjaxResponse");
	  	
	  	
	  }
	 
	 
	 /**
	  * getManufacturerList 
	  */
	  function getManufacturerList() {
	  	
	  	var mode = "GETMANUFCOMBO";
	var url = "MmsCNT.cnt?hmode="+mode+"&strCatCode="+document.forms[0].strOtherItemCategory[document.forms[0].strOtherItemCategory.selectedIndex].value;


	ajaxFunction2(url, "8", "getItemOtherDtlsAjaxResponse");
	  	
	  }
	 
	 var gblLayerIndexVal = "1";
	 
	 function getOtherItemsModifyView(mode){
	 	
	 	gblLayerIndexVal = mode;
	 	
	 		var hmode = "GETOTHERITEMMODIVIEW";
	  	
	  		var strChkVal = document.forms[0].strChk.value.split('@');
	  		
	  		var strItemId 		= strChkVal[1];
	  		var strItemBrandId  = strChkVal[2];
	  		var strBatchNo		= strChkVal[3];
	  		
			var url = "MmsCNT.cnt?hmode=" + hmode +"&strItemId="+strItemId+"&strItemBrandId="
										  +strItemBrandId+"&strBatchNo="+strBatchNo+"&layerIndex="+mode+"&mode="+mode;
			
			ajaxFunction2(url, "7", "getItemOtherDtlsAjaxResponse");
	  		 	
	 }
	 
	 
	 
	 /**
	  * hideItemOtherDtlsView 
	  */
	  function hideItemOtherDtlsView() {
	  	
	  	hide_popup('otherDtlspopUpDiv');
	  	
	  }
	 
	
	 function getItemOtherDtlsAjaxResponse(res, mode) {

	
		if (mode == '1') {
	
			var itemParaObj = document.getElementById("itemsOtherDtlsDivId");
	
			itemParaObj.innerHTML = res;
	
			popup('otherDtlspopUpDiv', '80', '80');
	
		}
	 
	 if (mode == '2') {
	
			var itemParaObj = document.getElementById("otherItemGroupDivId");
	
			itemParaObj.innerHTML = "<select name='strOtherItemGroup' onchange='getSubGroupList(this);' class='browser-default custom-select'>"+res+"</select>";
		
			
		}
	 
	  if (mode == '3') {
	
			var itemParaObj = document.getElementById("otherItemSubGroupDivId");
	
			itemParaObj.innerHTML = "<select name='strOtherItemSubGroup' onchange='getGenItemList();' class='browser-default custom-select'>"+res+"</select>";
		
		getGenItemList();
		
		}
	 
	  if (mode == '4') {
	
			var itemParaObj = document.getElementById("otherGenItemDivId");
	
			itemParaObj.innerHTML = "<select name='strOtherGenericItem' onchange='getItemList();' class='browser-default custom-select'>"+res+"</select>";
		
		getManufacturerList();
		
		}
	 
	 if (mode == '5') {
	
			var itemParaObj = document.getElementById("otherItemDivId");
	
			itemParaObj.innerHTML = "<select name='strOtherItem' onchange='getUnitList();' class='browser-default custom-select'>"+res+"</select>";
		
		getUnitList();
		
		}
	 
	 
	  if (mode == '6') {
	
			var itemParaObj = document.getElementById("otherInHandQtyUnitDivId");
	
			itemParaObj.innerHTML = "<select name='strOtherInHandQuantityUnitID' class='browser-default custom-select'>"+res+"</select>";
		
		}
	 
	   if (mode == '7') {
	
			var resVal = res.split('@@');
	
			var itemParaObj = document.getElementById("id"+gblLayerIndexVal);
	
			itemParaObj.innerHTML = resVal[0];
		
			document.getElementsByName("rowIndex"+gblLayerIndexVal)[0].value = resVal[1];
			document.getElementsByName("rowLength"+gblLayerIndexVal)[0].value = resVal[1];
		
		}
	 
	 
	  if (mode == '8') {
	
		
			var itemParaObj = document.getElementById("itemOtherDtlsManufDivId");
	
		if(itemParaObj != null)
			itemParaObj.innerHTML = "<select name='strItemOtherDtlsManufactureId' class='browser-default custom-select'>"+res+"</select>";
		
		}
	 
	 }
	 
	 
	 
	 
	 
function validateAndAddItemOtherDtls(mode) {
	var hisValidator = new HISValidator(gblFormBeanName);

	hisValidator.addValidation("strOtherItemCategory", "dontselect=0","Please Select an Item Category");
	hisValidator.addValidation("strOtherItemGroup", "dontselect=0","Please Select a Group");

	hisValidator.addValidation("strOtherGenericItem", "dontselect=0","Please Select a Generic Item");
	hisValidator.addValidation("strOtherItem", "dontselect=0","Please Select a Item");

	if (document.forms[0].isOtherBatchReq != null && document.forms[0].isOtherBatchReq.value == '1') {
		
		hisValidator.addValidation("strOtherItemBatchNo", "req","Batch No. is a Mandatory Field");
	
	}

	if (document.forms[0].isOtherExpDtReq != null && document.forms[0].isOtherExpDtReq.value == '1') {
		hisValidator.addValidation("strOtherExpiryDate", "req","Expiry Date is a Mandatory Field");
		hisValidator.addValidation("strOtherExpiryDate", "date","Expiry Date must be a Date");
	}

if (document.forms[0].strOtherExpiryDate != null && document.forms[0].strOtherExpiryDate.length > 0) {
	
		hisValidator.addValidation("strOtherExpiryDate", "date","Expiry Date must be a Date");
	}

	if(document.forms[0].strOtherExpiryDate.value.length > 0 && document.forms[0].strOtherManufDate.value.length > 0){
	
		hisValidator.addValidation("strOtherManufDate", "date","Manufacture Date must be a Date");
		hisValidator.addValidation("strOtherExpiryDate", "dtgt="+document.forms[0].strOtherManufDate.value,"Expiry Date should be Greater than Manufacture Date");
	
	}


	hisValidator.addValidation("strOtherInHandQuantity", "req","In Hand Quantity is a Mandatory Field");
	hisValidator.addValidation("strOtherInHandQuantityUnitID", "dontselect=0","Please Select a In Hand Quantity Unit");


	if(mode == '2'){
		
		hisValidator.addValidation("strItemOtherDtlsComponentType", "dontselect=0","Please Select a Component Type");
		
		if(document.getElementsByName("strItemOtherDtlsWarrantyPeriod")[0].value.length > 0){
		hisValidator.addValidation("strItemOtherDtlsWarrantyUnit", "dontselect=0","Please Select a Warranty Unit");
		}
		hisValidator.addValidation("strItemOtherDtlsManufactureId", "dontselect=0","Please Select a Manufacturer");
	}
	

	var retVal = hisValidator.validate();
	
	hisValidator.clearAllValidations();

	if (retVal) {
		
		
		if(mode == '1'){
		
		addRows(new Array('strItemOtherDtls'), new Array('t'), gblLayerIndex , '1', 'R');
		
		var index = gblLayerIndex + "-" + document.getElementsByName("rowIndex"+gblLayerIndex)[0].value;
				
		var otherDtlsChkVal = document.forms[0].strOtherItemCategory[document.forms[0].strOtherItemCategory.selectedIndex].value + "^"
							+ document.forms[0].strOtherGenericItem[document.forms[0].strOtherGenericItem.selectedIndex].value + "^"
							+ document.forms[0].strOtherItem[document.forms[0].strOtherItem.selectedIndex].value +"^" 
							+ document.forms[0].strOtherItemBatchNo.value + "^"
							+ document.forms[0].strOtherExpiryDate.value + "^" 
							+ document.forms[0].strOtherManufDate.value + "^"
							+ document.forms[0].strOtherInHandQuantity.value + "^"
							+"No.";
				
		document.getElementById("strItemOtherDtls" + index).value = otherDtlsChkVal;
		document.getElementById("itemOtherNameDivId" + index).innerHTML = document.forms[0].strOtherItem[document.forms[0].strOtherItem.selectedIndex].text;
		document.getElementById("itemOtherBatchNoDivId" + index).innerHTML = document.forms[0].strOtherItemBatchNo.value;
		document.getElementById("itemOtherExpiryDateDivId" + index).innerHTML = document.forms[0].strOtherExpiryDate.value
		document.getElementById("itemOtherQtyDivId" + index).innerHTML = document.forms[0].strOtherInHandQuantity.value +" "+ "No.";
		
		}else{
			
			addRows(new Array('strItemPartDtls'), new Array('t'), gblLayerIndex , '1', 'R');
		
		var index = gblLayerIndex + "-" + document.getElementsByName("rowIndex"+gblLayerIndex)[0].value;
				
		var otherDtlsChkVal = document.forms[0].strOtherItemCategory[document.forms[0].strOtherItemCategory.selectedIndex].value + "^"
							+ document.forms[0].strOtherGenericItem[document.forms[0].strOtherGenericItem.selectedIndex].value + "^"
							+ document.forms[0].strOtherItem[document.forms[0].strOtherItem.selectedIndex].value +"^" 
							+ document.forms[0].strOtherItemBatchNo.value + "^"
							+ document.forms[0].strOtherExpiryDate.value + "^" 
							+ document.forms[0].strOtherManufDate.value + "^"
							+ document.forms[0].strOtherInHandQuantity.value + "^"
							+"No." +"^" 
							+ document.forms[0].strItemOtherDtlsManufactureId[document.forms[0].strItemOtherDtlsManufactureId.selectedIndex].value +"^"
							+ document.forms[0].strItemOtherDtlsComponentType[document.forms[0].strItemOtherDtlsComponentType.selectedIndex].value;
				
				
				if(document.getElementById("strItemOtherDtlsSeparateEntityId").checked){
					otherDtlsChkVal = otherDtlsChkVal + "^1";
				}else{
					otherDtlsChkVal = otherDtlsChkVal + "^0";
				}
				
				if(document.getElementById("strItemOtherDtlsWarrantyPeriodId").value.length > 0){
					otherDtlsChkVal = otherDtlsChkVal + "^"+document.getElementById("strItemOtherDtlsWarrantyPeriodId").value;
				}else{
					otherDtlsChkVal = otherDtlsChkVal + "^0";
				}
				
				otherDtlsChkVal = otherDtlsChkVal + "^"+document.getElementById("strItemOtherDtlsWarrantyUnitId")[document.getElementById("strItemOtherDtlsWarrantyUnitId").selectedIndex].value;
				
				
		document.getElementById("strItemPartDtls" + index).value = otherDtlsChkVal;
		document.getElementById("itemOtherTypeDivId" + index).innerHTML = document.forms[0].strItemOtherDtlsComponentType[document.forms[0].strItemOtherDtlsComponentType.selectedIndex].text;
		document.getElementById("itemOtherNameDivId" + index).innerHTML = document.forms[0].strOtherItem[document.forms[0].strOtherItem.selectedIndex].text;
		document.getElementById("itemOtherBatchNoDivId" + index).innerHTML = document.forms[0].strOtherItemBatchNo.value;
		document.getElementById("itemOtherManufacturerDivId" + index).innerHTML = document.forms[0].strItemOtherDtlsManufactureId[document.forms[0].strItemOtherDtlsManufactureId.selectedIndex].text;
		document.getElementById("itemOtherExpiryDateDivId" + index).innerHTML = document.forms[0].strOtherExpiryDate.value
		document.getElementById("itemOtherQtyDivId" + index).innerHTML = document.forms[0].strOtherInHandQuantity.value +" "+ "No.";
		
			
		}
		
		hideItemOtherDtlsView();
		
		
	} else {
		return false;
	}
}
	 
	
		 	
/**
 * validateOtherDtlsQty - Qty validation.
 * @param {String} unitName
 * @param {String} qtyName  
 */
function validateOtherDtlsQty(qtyName, unitName) {

	
		var unitObj = document.getElementsByName(unitName)[0];
		var qtyObj = document.getElementsByName(qtyName)[0];

		
			var qtyDeceimal = qtyObj.value;

			var unitVal = unitObj.value.split('^')[2];

			if (qtyDeceimal.indexOf('.') > -1 && unitVal == '0') {

				alert("Qty must be an Integer ");
				qtyObj.value = '0';
				qtyObj.focus();								
				return false;
			}


	return true;
}
	
 	 
	 
	 