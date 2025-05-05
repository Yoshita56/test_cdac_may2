/* This flag tracks whether getOtherItemsModifyViewOnLoad invoked or not.*/
var gblGetOtherItemsModifyViewOnLoadInvokeFlag=0;
function validate1() {
	var hisValidator = new HISValidator("itemInventoryTransBean");

	hisValidator.addValidation("strItemId", "dontselect=0","Please Select a Generic Item");
	hisValidator.addValidation("strItemBrandId", "dontselect=0","Please Select a Item");

	if(document.forms[0].strRegFlag.value != '2'){
		
			hisValidator.addValidation("strManufactureId", "dontselect=0","Please Select a Manufacturer");
	}

	if (document.forms[0].isBatchReq != null && document.forms[0].isBatchReq.value == '1') {
		
		hisValidator.addValidation("strBatchNo", "req","Batch No. is a Mandatory Field");
	}

	if (document.forms[0].isExpirtReq != null && document.forms[0].isExpirtReq.value == '1') {
		hisValidator.addValidation("strExpiryDate", "req","Expiry Date is a Mandatory Field");
	}

if(document.forms[0].strExpiryDate.value.length > 0 && document.forms[0].strManufactureDate.value.length > 0){
	
	hisValidator.addValidation("strExpiryDate", "dtgt="+document.forms[0].strManufactureDate.value,"Expiry Date should be Greater than Manufacture Date");
	
}




hisValidator.addValidation("strInHandQuantity", "req","In Hand Quantity is a Mandatory Field");
hisValidator.addValidation("strInHandQuantityUnitID", "dontselect=0","Please Select a In Hand Quantity Unit");

	if(document.forms[0].strRegFlag.value != '2'){
		
		hisValidator.addValidation("strItemSpecification", "req","Specification is a Mandatory Field");
	}

hisValidator.addValidation("strItemSpecification", "maxlen=2000","Specification cannot be greater than 2000 Characters");




if (document.forms[0].isCurrencyReq != null
		&& document.forms[0].isCurrencyReq.value == '1') {

	hisValidator.addValidation("strCurrencyValue", "req","Currency Value is a Mandatory Field");
	
}


hisValidator.addValidation("strRate", "req", "Rate is a Mandatory Field");
hisValidator.addValidation("strRate", "amount=11,2","Rate format should be 000000000.00");
hisValidator.addValidation("strUnitRateID", "dontselect=0","Please Select a Rate Unit");

hisValidator.addValidation("strSalePrice", "req"," Issue Rate is a Mandatory Field");
hisValidator.addValidation("strSalePrice", "amount=11,2","Issue Rate format should be 000000000.00");
hisValidator.addValidation("strUnitSaleID", "dontselect=0","Please Select a Issue Rate Unit");

/*hisValidator.addValidation("strPoNo", "req", "Po No is a Mandatory Field");
hisValidator.addValidation("strPoNo", "minlen=10","P.O. No. should be a 10 Digit Number");

hisValidator.addValidation("strPoDate", "req","P.O. Date is a Mandatory Field");*/

hisValidator.addValidation("strReceivedDate", "req","Received is a Mandatory Field");

if(document.forms[0].strPoDate.value!="") {
	hisValidator.addValidation("strReceivedDate", "dtgtet="+document.forms[0].strPoDate.value,"Received Date should be Greater than or Equal to P.O. Date");
}


hisValidator.addValidation("strSuppliedBy", "dontselect=0","Please Select a Supplied By");

	if(document.forms[0].strIsWarrantyDetails != null)
	if(document.forms[0].strIsWarrantyDetails.checked == true){
			
			
			
			hisValidator.addValidation("strWarrantyDate", "req","Warranty Date is a Mandatory Field");
			
			hisValidator.addValidation("strWarantyManufacturer", "dontselect=0","Please Select a Manufacture");
			
			hisValidator.addValidation("strWarrantyUpTo", "req","Warranty Upto is a Mandatory Field");
			hisValidator.addValidation("strWarrantyUpToUnit", "dontselect=0","Please Select a Unit");
			
			hisValidator.addValidation("strWarrantyRemarks", "maxlen=100","Remarks cannot be greater than 100 Characters");
			
			
	}

if(document.forms[0].strIsInstallDetails != null)
	if(document.forms[0].strIsInstallDetails.checked == true){
		
		hisValidator.addValidation("strInstallStartDate", "req","Installation Start Date is a Mandatory Field");
		hisValidator.addValidation("strInstallEndDate", "req","Installation End Date is a Mandatory Field");
		hisValidator.addValidation("strInstallStatus", "dontselect=0","Please Select an Installation Status");
		
		hisValidator.addValidation("strInstallBy", "req","Install By is a Mandatory Field");
		hisValidator.addValidation("strInstallerContactNo", "req","Installer Contact No. is a Mandatory Field");hisValidator.addValidation("strInstallEndDate", "req","Installation End Date is a Mandatory Field");
				
	}


	var retVal = hisValidator.validate();
	
	hisValidator.clearAllValidations();

	if (retVal) 
	{
	
	               var conf = confirm("You Are Going To Save Records");
								                  if(conf == true)
								                  {
								                       var conf1 = confirm("Are you sure !!!");
								                       if(conf1 == true)
								                       {
								 						    document.forms[0].hmode.value = "INSERT";
														    document.forms[0].submit();
								                       }
								                      else
								                       {
								                         return false;
								                       }
								                   }
								                  else
								                   {
								                         return false;
								                   }        
		 	
	} else {
		return false;
	}
}
function cancelPage(mode) {
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();
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
  * showOrHideDetails
  * @param {Object} chkObj
  * @param {String} divId  
  */
  function showOrHideDetails(chkObj , divId) {
  	
  		if(chkObj.checked){
  			
  			document.getElementById(divId).style.display = "block";
  			
  		}else{
  			
  			document.getElementById(divId).style.display = "none";
  		}
  	
  }

function ajaxItemName(mode) {

	var mode = "ITEMNAME";

	var url = "ItemInventoryTransCNT.cnt?hmode=ITEMNAME&strSubGroupId="
			+ document.forms[0].strSubGroupId.value + "&GroupId="
			+ document.forms[0].strGroupId.value + "&storeId="
			+ document.forms[0].strStoreId.value+"&strCatCode="+document.forms[0].strItemCategoryNo.value;
			
	ajaxFunction(url, "1");

}

function ajaxItemBrandName1(mode) {
	var mode = "UNITNAMECOMBO";

	// alert("strore id"+document.forms[0].strItemName.value);
	var url = "ItemInventoryTransCNT.cnt?hmode=UNITNAMECOMBO&strItemId="
			+ document.forms[0].strItemId.value;
	ajaxFunction(url, "3");
}

function ajaxItemBrandName(mode) {
	var mode = "ITEMBRANDNAME";

	// alert("strore id"+document.forms[0].strItemName.value);
	var url = "ItemInventoryTransCNT.cnt?hmode=ITEMBRANDNAME&strItemId="
			+ document.forms[0].strItemId.value + "&storeId="
			+ document.forms[0].strStoreId.value+"&strSubGroupId="
				+ document.forms[0].strSubGroupId.value + "&strGroupId="
				+ document.forms[0].strGroupId.value+"&strCatCode="+document.forms[0].strItemCategoryNo.value;
	ajaxFunction(url, "2");

}


function isCurrencyMandatory(obj) {
	
	
	if(obj.value != document.forms[0].strDefaultCurrencyCode.value){
		
		document.forms[0].isCurrencyReq.value = "1";
		document.forms[0].strCurrencyValue.disabled = false;
		document.getElementById("currencyDivId").innerHTML = "<font color='red'>*</font>Currency Value";
		
		
	}else{
		
		document.forms[0].isCurrencyReq.value = "0";
		document.forms[0].strCurrencyValue.disabled = true;
		document.getElementById("currencyDivId").innerHTML = "Currency Value";
	
		
	}
	
	
}

function getItemMandatoryDtls(index) {

	if (document.forms[0].strItemId.value != '0') {

		var mode = "GETITEMMANDATORYDTLS";

		var url = "MmsCNT.cnt?hmode=" + mode + "&itemId="
				+ document.forms[0].strItemId.value;
		ajaxFunction(url, "4");

	} else {

		document.forms[0].isBatchReq.value = "0";
		document.getElementById("batchNoDivId").innerHTML = "Batch No.";

		document.forms[0].isExpirtReq.value = "0";
		document.getElementById("expiryDateDivId").innerHTML = "Expiry Date";

	}

}

function ajaxManufectureName(mode) {
	var mode = "MANUFECTURENAME";
	var url = "ItemInventoryTransCNT.cnt?hmode=MANUFECTURENAME&strItemBrandId="
			+ document.forms[0].strItemBrandId.value +"&strCatCode="+document.forms[0].strItemCategoryNo.value;


	ajaxFunction(url, "5");
}


function getItemBrandDetails() {
	
	if(document.forms[0].strItemBrandId.value != 0){	
			
			var mode = "BRANDDETAILS";
			var url = "ItemInventoryTransCNT.cnt?hmode="+mode+"&strItemBrandId="
					+ document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value ;
										
			ajaxFunction(url, "6");
	
		}else{
		
				document.getElementById("manfNotMandatoryDivId").style.display = "none";
			 	document.getElementById("manfMandatoryDivId").style.display = "block";
			 	
			 	document.getElementById("specNotMandatoryDivId").style.display = "none";
			 	document.getElementById("specMandatoryDivId").style.display = "block";
			 		 	
			 	document.forms[0].strManufactureId.selectedIndex = 0;	 	
			 	document.forms[0].strManufactureId.disabled = false; 	
			 	document.forms[0].strItemSpecification.value = "";	 	
			 	document.forms[0].strItemSpecification.disabled = false; 	
		}
}


function getManufecture(mode) {
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();
}

function getAjaxResponse(res, mode) {

	var objVal;
	if (mode == "1") {

		objVal = document.getElementById("ItemNameId");
		objVal.innerHTML = "<select name ='strItemId' class='comboNormal' onChange = 'ajaxItemBrandName(\"ITEMBRANDNAME\")' >"
				+ res + "</select>";
	}
	if (mode == "2") {

		objVal = document.getElementById("ItemBrandId");
		objVal.innerHTML = "<select name ='strItemBrandId' class='comboNormal' onChange='ajaxManufectureName(\"MANUFECTURENAME\");' >"
				+ res + "</select>";
		
		getItemMandatoryDtls('0');
		
	}

	if (mode == "3") {

		objVal = document.getElementById("UnitRateID");
		objVal.innerHTML = "<select name ='strUnitRateID' class='comboNormal' onchange='return validateQty(\"strRate\",\"strUnitRateID\");' >"
				+ res + "</select>";
		document.getElementById("UnitRateID1").innerHTML = "<select name ='strUnitSaleID' class='comboNormal' onchange='return validateQty(\"strSalePrice\",\"strUnitSaleID\");' >"
				+ res + "</select>";
		document.getElementById("freeItemUnit").innerHTML = "<select name ='strInHandQuantityUnitID' class='comboNormal' onchange='return validateQty(\"strInHandQuantity\",\"strInHandQuantityUnitID\");' >"
				+ res + "</select>";
        document.getElementById("freeItemUnitValue").innerHTML = "<select name ='strFreeItemQuantityUnitID' class='comboNormal' onChange='' >"
				+ res + "</select>";	

	}

	else if (mode == "4") {

		var temp = res.split('^');

		document.forms[0].isBatchReq.value = temp[0];

		if (temp[0] == '1') {

			document.getElementById("batchNoDivId").innerHTML = "<font color='red'>*</font>Batch No.";
		} else {

			document.getElementById("batchNoDivId").innerHTML = "Batch No.";
		}

		document.forms[0].isExpirtReq.value = temp[2];

		if (temp[2] == '1') {

			document.getElementById("expiryDateDivId").innerHTML = "<font color='red'>*</font>Expiry Date";
		} else {

			document.getElementById("expiryDateDivId").innerHTML = "Expiry Date";
		}

		ajaxItemBrandName1('UNITNAMECOMBO');
		
	}

	if (mode == '5') {
	
		document.getElementById("manufDivId").innerHTML = "<select class='comboNormal' name='strManufactureId' onchange='setWarrantyManfacturer(this);' >"
				+ res + "</select>";

		if(document.getElementById("warrantyManufDivId") != null)
		document.getElementById("warrantyManufDivId").innerHTML = "<select class='comboNormal' name='strWarantyManufacturer' >"
				+ res + "</select>";

		getItemBrandDetails();

	}
	
	if (mode == '6') {
	
	
		 var brandDtls = res.split("^");
		 
		 document.forms[0].strRegFlag.value = brandDtls[0];
		 document.forms[0].strConfigIssueRate.value = brandDtls[4];
		 
		 if(brandDtls[0] == '2'){
		 	
		 	document.getElementById("manfNotMandatoryDivId").style.display = "none";
		 	document.getElementById("manfMandatoryDivId").style.display = "block";
		 	
		 	document.getElementById("specNotMandatoryDivId").style.display = "none";
		 	document.getElementById("specMandatoryDivId").style.display = "block";
		 		 	
		 	document.forms[0].strManufactureId.selectedIndex = 0;	 	
		 	document.forms[0].strManufactureId.disabled = false; 	
		 	document.forms[0].strItemSpecification.value = "";	 	
		 	document.forms[0].strItemSpecification.disabled = false; 	
		 		 	
		 }else{
		 	
		 	document.getElementById("manfNotMandatoryDivId").style.display = "block";
		 	document.getElementById("manfMandatoryDivId").style.display = "none";
		 	
		 	document.getElementById("specNotMandatoryDivId").style.display = "block";
		 	document.getElementById("specMandatoryDivId").style.display = "none";
		 		 	
		 	document.forms[0].strManufactureId.value = brandDtls[3];	
		 	//document.forms[0].strManufactureId.disabled = true; 	
		 	document.forms[0].strItemSpecification.value = brandDtls[1];	 	
			document.forms[0].strItemSpecification.disabled = true; 			 			 	
		 }
		 
	} else if(mode == '7') {
		
	} else if(mode == '8') {
		
	}
	

}

/**
 * checkForWarrantyDtls
 * @param {String} divId 
 */
 function checkForWarrantyDtls(divId) {
 	
 	if(document.forms[0].strIsWarrantyDetails != null)
 	if(document.forms[0].strIsWarrantyDetails.checked == true){
  			
  			document.getElementById(divId).style.display = "block";
  			
  		}else{
  			
  			document.getElementById(divId).style.display = "none";
  		}
 }


/**
 * checkFoInstallationDtls
 * @param {String} divId 
 */
 function checkFoInstallationDtls(divId) {
 	
 	if(document.forms[0].strIsInstallDetails != null)
 	if(document.forms[0].strIsInstallDetails.checked == true){
  			
  			document.getElementById(divId).style.display = "block";
  			
  		}else{
  			
  			document.getElementById(divId).style.display = "none";
  		}
 }

/**
 * checkForSerialNo
 */
 function checkForSerialNo() {
 	
 		var srNo = document.forms[0].strSerialNo.value;
 	
 		if(srNo.length > 1){
 			
 			document.forms[0].strInHandQuantityUnitID.disabled = true;
 			
 		}
 	
 }



/**
 * setWarrantyManfacturer
 * @param {Object} comboObj 
 */
 function setWarrantyManfacturer(comboObj) {
 	
 	if(document.getElementsByName("strWarantyManufacturer").length > 0){
 		
 		document.forms[0].strWarantyManufacturer.selectedIndex = comboObj.selectedIndex;
 		
 	}
 	
 }

function validatemodify() {

	

	var hisValidator = new HISValidator("itemInventoryTransBean");

	if (document.forms[0].isExpirtReq != null && document.forms[0].isExpirtReq.value == '1') {
		hisValidator.addValidation("strExpiryDate", "req","Expiry Date is a Mandatory Field");
	}

if(document.forms[0].strExpiryDate.value.length > 0 && document.forms[0].strManufactureDate.value.length > 0){
	
	hisValidator.addValidation("strExpiryDate", "dtgt="+document.forms[0].strManufactureDate.value,"Expiry Date should be Greater than Manufacture Date");
	
}

hisValidator.addValidation("strInHandQuantity", "req","In Hand Quantity is a Mandatory Field");
hisValidator.addValidation("strInHandQuantityUnitID", "dontselect=0","Please Select a In Hand Quantity Unit");

var srNo = document.forms[0].strSerialNo.value;
 	
 		if(srNo.length > 1){
 			
 			var val = document.forms[0].strInHandQuantity.value;
 			
 			if(val == "" || val.length == 0) val = "0";
 			
 			val = parseInt(val);
 			
 			if(val > 1){
 				
 				 alert("In Hand Quantity Cannot be Greater than 1");
 				 
 				 return false;
 			}
 		}





if (document.forms[0].isCurrencyReq != null
		&& document.forms[0].isCurrencyReq.value == '1') {

	hisValidator.addValidation("strCurrencyValue", "req","Currency Value is a Mandatory Field");
	
}


hisValidator.addValidation("strRate", "req", "Rate is a Mandatory Field");
hisValidator.addValidation("strRate", "amount=11,2","Rate format could be 000000000.00");
hisValidator.addValidation("strUnitRateID", "dontselect=0","Please Select a Rate Unit");

hisValidator.addValidation("strSalePrice", "req"," Issue Rate is a Mandatory Field");
hisValidator.addValidation("strSalePrice", "amount=11,2","Issue Rate format could be 000000000.00");
hisValidator.addValidation("strUnitSaleID", "dontselect=0","Please Select a Issue Rate Unit");

/*hisValidator.addValidation("strPoNo", "req", "Po No is a Mandatory Field");
hisValidator.addValidation("strPoNo", "minlen=10","P.O. No. should be a 10 Digit Number");

hisValidator.addValidation("strPoDate", "req","P.O. Date is a Mandatory Field");*/

hisValidator.addValidation("strReceivedDate", "req","Received is a Mandatory Field");

if(document.forms[0].strPoDate.value!="" && document.forms[0].strReceivedDate.value!="") {
	hisValidator.addValidation("strReceivedDate", "dtgtet="+document.forms[0].strPoDate.value,"Received Date should be Greater than or Equal to P.O. Date");
}


hisValidator.addValidation("strSuppliedBy", "dontselect=0","Please Select a Supplied By");


	if(document.forms[0].strIsWarrantyDetails != null)
	if(document.forms[0].strIsWarrantyDetails.checked == true){
			
			
			
			hisValidator.addValidation("strWarrantyDate", "req","Warranty Date is a Mandatory Field");
			
			hisValidator.addValidation("strWarantyManufacturer", "dontselect=0","Please Select a Manufacture");
			
			hisValidator.addValidation("strWarrantyUpTo", "req","Warranty Upto is a Mandatory Field");
			hisValidator.addValidation("strWarrantyUpToUnit", "dontselect=0","Please Select a Unit");
			
			hisValidator.addValidation("strWarrantyRemarks", "maxlen=100","Remarks cannot be greater than 100 Characters");
						
	}


if(document.forms[0].strIsInstallDetails != null)
	if(document.forms[0].strIsInstallDetails.checked == true){
		
		hisValidator.addValidation("strInstallStartDate", "req","Installation Start Date is a Mandatory Field");
		hisValidator.addValidation("strInstallEndDate", "req","Installation End Date is a Mandatory Field");
		hisValidator.addValidation("strInstallStatus", "dontselect=0","Please Select an Installation Status");
		
		hisValidator.addValidation("strInstallBy", "req","Install By is a Mandatory Field");
		hisValidator.addValidation("strInstallerContactNo", "req","Installer Contact No. is a Mandatory Field");hisValidator.addValidation("strInstallEndDate", "req","Installation End Date is a Mandatory Field");
				
	}


	var retVal = hisValidator.validate();
	
	hisValidator.clearAllValidations();

	if (retVal) {
		
			document.forms[0].strInHandQuantityUnitID.disabled = false;
		
		var parValObj = document.getElementsByName("strParamValue");
		
		for(var index=0; index<parValObj.length; index++) {
			
			document.forms[0].strParamValue[index].disabled = false;
			
		}
		
              var conf = confirm("You Are Going To Save Records");
              if(conf == true)
              {
                   var conf1 = confirm("Are you sure !!!");
                   if(conf1 == true)
                   {
					    document.forms[0].hmode.value = "UPDATE";
					    document.forms[0].submit();
                   }
                  else
                   {
                     return false;
                   }
               }
              else
               {
                     return false;
               }        
		
		
		
		
	} else {
		return false;
	}
}


	/**
	 * addFreeItems
	  
	 */
	 function addFreeItems() {
	 	
	 	var hisValidator = new HISValidator("itemInventoryTransBean");
	 	
	 		hisValidator.addValidation("strItemId", "dontselect=0","Please Select a Generic Item");
			hisValidator.addValidation("strItemBrandId", "dontselect=0","Please Select a Item");
	
		var retVal = hisValidator.validate();
	
		hisValidator.clearAllValidations();

	if (retVal) {
	
	 	
	 		var mode 		= "1";
	 		var isBatchReq  = document.forms[0].isBatchReq.value;
	 		var isExpDtReq  = document.forms[0].isExpirtReq.value;
	 	
	 	getItemOtherDetailsView(mode, isBatchReq , isExpDtReq , '1' , "itemInventoryTransBean");
	}else{
		
		return false;
	}
	 	
	 }
	


	/**
	 * addFreeItems
	  
	 */
	 function addPartItems() {
	 	
	 	var hisValidator = new HISValidator("itemInventoryTransBean");
	 	
	 		hisValidator.addValidation("strItemId", "dontselect=0","Please Select a Generic Item");
			hisValidator.addValidation("strItemBrandId", "dontselect=0","Please Select a Item");
	
		var retVal = hisValidator.validate();
	
		hisValidator.clearAllValidations();

	if (retVal) {
	 	
	 		var mode 		= "2";
	 		var isBatchReq  = document.forms[0].isBatchReq.value;
	 		var isExpDtReq  = document.forms[0].isExpirtReq.value;
	 	
	 	getItemOtherDetailsView(mode, isBatchReq , isExpDtReq , '2' , "itemInventoryTransBean");
	 	
	 	}else{
		
		return false;
	}
	 	
	 }
	
	
	/**
	 * checkForPopup
	 * @param {Object} parentObject 
	 * @param {String} catNo
	 */
	 function checkForPopup(parentObject , catNo , mode) {
	 	
	 	if(document.getElementById("itemParameterDtlDivId").innerHTML.length == 0){
	 		
	 		if(mode == '1'){
	 			
	 			showPopup(parentObject , mode , catNo , '');
	 			
	 		}else if (mode == '2'){
	 		
	 		var itemVal = document.forms[0].strChk.value.split('@');
	 		
	 		showPopup(parentObject , mode , catNo , itemVal[2]);
	 			
	 		}
	 			 		
	 		
	 		
	 	} else{
	 		
	 		popup('popUpDivId','100','250');
	 		
	 	}
	 	
	 	
	 }
	
	
	
/**
 * validateQty - Qty validation.
 * @param {String} unitName
 * @param {String} qtyName  
 */
function validateQty(qtyName, unitName) {

	
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


function initializeModifyPage() {

	checkForWarrantyDtls('warrantyItemDtlsDivId');
	checkFoInstallationDtls('installItemDtlsDivId');
	checkForSerialNo();

	
	/* To show free item details.*/
	/*
	 * No more required.
	 * Suggested by: Amit Kumar
	 * Changed by: Aritra
	 */
	/*
	getOtherItemsModifyViewOnLoad('1');
	showView('freeItemDtlsDivId');
	*/
	

	
	
	

}

function getOtherItemsModifyViewOnLoad(mode){
 	
 	gblLayerIndexVal = mode;
 	++gblGetOtherItemsModifyViewOnLoadInvokeFlag;
 	
 		var hmode = "GETOTHERITEMMODIVIEW";
  	
  		var strChkVal = document.forms[0].strChk.value.split('@');
  		
  		var strItemId 		= strChkVal[1];
  		var strItemBrandId  = strChkVal[2];
  		var strBatchNo		= strChkVal[3];
  		
		var url = "MmsCNT.cnt?hmode=" + hmode +"&strItemId="+strItemId+"&strItemBrandId="
									  +strItemBrandId+"&strBatchNo="+strBatchNo+"&layerIndex="+mode+"&mode="+mode;
		
		ajaxFunction2(url, "7", "getItemOtherDtlsAjaxResponseOnload");
  		 	
 }

function getItemOtherDtlsAjaxResponseOnload(res, mode) {

	
	if (mode == '7') {

		var resVal = res.split('@@');

		var itemParaObj = document.getElementById("id"+gblLayerIndexVal);

		itemParaObj.innerHTML = resVal[0];
	
		document.getElementsByName("rowIndex"+gblLayerIndexVal)[0].value = resVal[1];
		document.getElementsByName("rowLength"+gblLayerIndexVal)[0].value = resVal[1];
		
		/* To show component details.*/
		if(gblGetOtherItemsModifyViewOnLoadInvokeFlag==1) {
			getOtherItemsModifyView('2');
			showView('partItemDtlsDivId');
			
			/* reseting gblGetOtherItemsModifyViewOnLoadInvokeFlag */
			gblGetOtherItemsModifyViewOnLoadInvokeFlag=0;
		}
		
	
	}
	
 
 
}
	
	
	