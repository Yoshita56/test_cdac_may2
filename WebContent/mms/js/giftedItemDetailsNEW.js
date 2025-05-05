var setColor = "red";
var defaultColor = "blue";

/**
 * changeViewMode
 * 
 * @param {Object}
 *            chkObj
 */
function changeViewMode(chkObj) 
{
	
	
		
		document.getElementById("giftedItemViewMode").style.display = "block";
		document.getElementById("printButton").style.display = "block";
		
		document.getElementById("giftedViewDetailsDivId").style.display = "none";
		

		document.getElementById("itemDetailsMode").style.display = "none";
		
		document.getElementById("btnpreview").style.display = "none";
/*
	} 
	else 
	{
		document.getElementById("printButton").style.display = "none";
		document.getElementById("giftedItemViewMode").style.display = "none";
		document.getElementById("itemDetailsMode").style.display = "block";
		document.getElementById("btnpreview").style.display = "none";
	}
	*/
}

function layerIndexNavigator(index, endVal) {

	hideAll(endVal);

	initObj = document.getElementsByName("linId");

	if (initObj.length > 0) {

		for ( var i = 0, len = initObj.length; i < len; i++) {

			initObj[i].style.color = defaultColor;
		}

	}

	obj = document.getElementById("linId" + index);
	if (obj != null)
		obj.style.color = setColor;

	document.getElementById("tariffDivId" + index).style.display = "block";
}

function hideAll(endVal) {

	for ( var i = 1; i <= endVal; i++) {
		document.getElementById("tariffDivId" + i).style.display = "none";
	}

}
function pageResetMethod()
{
	
	document.forms[0].reset();
	document.forms[0].strSalePrice.disabled = false;
	
}
function calcIssueRate()
{
	if(document.forms[0].strIssueRateConfigFlg.value=='1')
	{
	 	if(document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value!='0')
	 	{
			 	var         isseRate = parseFloat("0");
			 	var     purchaseRate = document.forms[0].strRate.value;
			 	var confgIsseRateVal = document.forms[0].strConfigIssueRate.value;
			 	
			 	var result1 = (Math.abs(purchaseRate) * confgIsseRateVal) / Math.pow(10, 2);
			 	var cost = roundValue(result1,2);
			 	document.forms[0].strSalePrice.value = cost;
			 	document.forms[0].strSalePrice.disabled = true;
			 	
	 	}
	 	else
	 	{
	 		document.forms[0].strRate.value='0';
	 		alert("Please Select Drug Name First!!!");
	 		return false;
	 	}
	}
	 	
}







/**
 * cancelViewPage
 */
function cancelViewPage() {

	document.forms[0].hmode.value = "INITPAGE";
	document.forms[0].submit();

}
/*function setReceivedDate()
{
	document.getElementsByName('strReceivedDate').value= Date();	
}*/
/**
 * getInventoryDtls
 */
function getInventoryDtls() {

	var hisValidator = new HISValidator("giftedItemDetailsTransBean");

	hisValidator.addValidation("strStoreId", "dontselect=0",
			"Please Select a Store");
	hisValidator.addValidation("strItemCategoryId", "dontselect=0",
			"Please Select a Category");

	hisValidator.addValidation("strGiftedBy", "req","Gifted By is a Mandatory Field");
	//hisValidator.addValidation("strAddress", "req",	"Address is a Mandatory Field");
	hisValidator.addValidation("strAddress", "maxlen=250",
			"Address cannot be more than 250 Characters");

	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

	if (retVal) {

		var catVal = document.forms[0].strItemCategoryId[document.forms[0].strItemCategoryId.selectedIndex].value
				.split('^')[0];

		document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
		document.forms[0].strItemCategoryName.value = document.forms[0].strItemCategoryId[document.forms[0].strItemCategoryId.selectedIndex].text;
		
		if (catVal == '10') {

			document.forms[0].hmode.value = "DRUGINVENTORY";
			document.forms[0].submit();

		} else {

			document.forms[0].hmode.value = "ITEMINVENTORY";
			document.forms[0].submit();

		}

	} else {

		return false;
	}

}

/**
 * getItemCategorys
 * 
 * @param {Object}
 *            strCombo
 */
function getItemCategorys(strCombo) {

	var hmode = "GETITEMCATLIST";
	var url = "GiftedItemDetailsTransCNTNEW.cnt?hmode=" + hmode + "&storeId="
			+ strCombo.value;

	ajaxFunction(url, "6");

}

function getFinYears() {

	var hmode = "GETFINYR";
	var url = "GiftedItemDetailsTransCNTNEW.cnt?hmode=" + hmode + "&storeId="
			+ document.forms[0].strStoreId.value;

	ajaxFunction(url, "9");

}

/**
 * getGiftedViewDetails
 */
function getGiftedViewDetails() {

	var hisValidator = new HISValidator("giftedItemDetailsTransBean");



	hisValidator.addValidation("strStoreId", "dontselect=0","Please Select a Store");
	hisValidator.addValidation("strItemCategoryId", "dontselect=0","Please Select a Category");

	


var diffdate = dateDiff1(document.forms[0].strFromDate.value,document.forms[0].strToDate.value); 
   // alert(diffdate);
     if(parseInt(diffdate)>365)
     {
        alert("Difference Between From Date and To Date Should not be greater than 365 days");
		return false;
	 }
    

var retVal = hisValidator.validate();
//	hisValidator.clearAllValidations();

	if (retVal) {
		var catVal = document.forms[0].strItemCategoryId[document.forms[0].strItemCategoryId.selectedIndex].value
		.split('^')[0];

		document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
		document.forms[0].strItemCategoryName.value = document.forms[0].strItemCategoryId[document.forms[0].strItemCategoryId.selectedIndex].text;

		
		var hmode = "GETGIFTITEMVIEWDTLS";
		var url = "GiftedItemDetailsTransCNTNEW.cnt?hmode="
				+ hmode
				+ "&storeId="
				+ document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value
				+ "&strCategoryId="
				+ document.forms[0].strItemCategoryId[document.forms[0].strItemCategoryId.selectedIndex].value.split('^')[0]
				+"&startDate="+document.forms[0].strFromDate.value+"&endDate="+document.forms[0].strToDate.value;

		ajaxFunction(url, "7");

	} else {
		return false;
	}

}

function validate1(type) {
	// alert("type-"+type);
	document.forms[0].strSalePrice.disabled = false;
	var hisValidator = new HISValidator("giftedItemDetailsTransBean");

	hisValidator.addValidation("strStockStatus", "dontselect=0",
			"Please Select a Stock Status");
	hisValidator.addValidation("strGroupId", "dontselect=0","Please Select a Group Name");

	if (type == 'DRUG') {
		hisValidator.addValidation("strItemId", "dontselect=0",	"Please Select a Generic Drug Name");
		hisValidator.addValidation("strItemBrandId", "dontselect=0","Please Select a Drug Name");
	} else {
		hisValidator.addValidation("strItemId", "dontselect=0",	"Please Select a Generic Item Name");
		hisValidator.addValidation("strItemBrandId", "dontselect=0","Please Select an Item Name");
	}

	if (document.forms[0].strRegFlag.value != '2') {

		hisValidator.addValidation("strManufactureId", "dontselect=0",
				"Please Select a Manufacturer");
	}

	if (document.forms[0].isBatchReq != null
			&& document.forms[0].isBatchReq.value == '1') {

		hisValidator.addValidation("strBatchNo", "req",
				"Batch No. is a Mandatory Field");
	}

	if (document.forms[0].isExpirtReq != null
			&& document.forms[0].isExpirtReq.value == '1') {
		hisValidator.addValidation("strExpiryDate", "req",
				"Expiry Date is a Mandatory Field");
	}

	if (document.forms[0].strExpiryDate.value.length > 0
			&& document.forms[0].strManufactureDate.value.length > 0) {

		hisValidator.addValidation("strExpiryDate", "dtgt="
				+ document.forms[0].strManufactureDate.value,
				"Expiry Date should be Greater than Manufacture Date");

	}

	if (document.forms[0].strExpiryDate.value.length > 0
			&& document.forms[0].strReceivedDate.value.length > 0) {

		hisValidator.addValidation("strExpiryDate", "dtgt="
				+ document.forms[0].strReceivedDate.value,
				"Expiry Date should be greater than Current Date");

	}
	if (document.forms[0].strManufactureDate.value.length > 0
			&& document.forms[0].strCtDate.value.length > 0) {

		hisValidator.addValidation("strManufactureDate", "dtltet="
				+ document.forms[0].strCtDate.value,
				"Manufacturing Date should less than or equal to Current Date");

	}
		
	
	hisValidator.addValidation("strInHandQuantity", "req",
			"Gifted Quantity is a Mandatory Field");
	
	if (type == 'DRUG') {
	hisValidator.addValidation("strPONumber", "req","PO Number is a Mandatory Field In Case Of Drug's ");
	}
	
	if (document.forms[0].strRegFlag.value != '2') 
	{

		hisValidator.addValidation("strItemSpecification", "req",
				"Specification is a Mandatory Field");
	}

	if (document.forms[0].isCurrencyReq != null
			&& document.forms[0].isCurrencyReq.value == '1') {

		hisValidator.addValidation("strCurrencyValue", "req",
				"Currency Value is a Mandatory Field");

	}

	hisValidator.addValidation("strRate", "req", "Rate is a Mandatory Field");
	hisValidator.addValidation("strRate", "amount=11,2",
			"Rate format should be 00000.00");
	/*hisValidator.addValidation("strUnitRateID", "dontselect=0",	"Please Select a Rate Unit");*/

	hisValidator.addValidation("strSalePrice", "req",
			" Issue Rate is a Mandatory Field");
	hisValidator.addValidation("strSalePrice", "amount=11,2",
			"Issue Rate format should be 00000000000.00");
	/*hisValidator.addValidation("strUnitSaleID", "dontselect=0",
			"Please Select a Issue Rate Unit");*/

	hisValidator.addValidation("strReceivedDate", "req",
			"Received is a Mandatory Field");

	hisValidator.addValidation("strSuppliedBy", "dontselect=0",
			"Please Select a Supplied By");

	if (document.forms[0].strIsWarrantyDetails != null)
		if (document.forms[0].strIsWarrantyDetails.checked == true) {

			hisValidator.addValidation("strWarrantyDate", "req",
					"Warranty Date is a Mandatory Field");

			hisValidator.addValidation("strWarantyManufacturer",
					"dontselect=0", "Please Select a Manufacture");

			hisValidator.addValidation("strWarrantyUpTo", "req",
					"Warranty Upto is a Mandatory Field");
			hisValidator.addValidation("strWarrantyUpToUnit", "dontselect=0",
					"Please Select a Unit");

			hisValidator.addValidation("strWarrantyRemarks", "maxlen=100",
					"Remarks cannot be greater than 100 Characters");

		}

	if (document.forms[0].strIsInstallDetails != null)
		if (document.forms[0].strIsInstallDetails.checked == true) {

			hisValidator.addValidation("strInstallStartDate", "req",
					"Installation Start Date is a Mandatory Field");
			hisValidator.addValidation("strInstallEndDate", "req",
					"Installation End Date is a Mandatory Field");
			hisValidator.addValidation("strInstallStatus", "dontselect=0",
					"Please Select an Installation Status");

			hisValidator.addValidation("strInstallBy", "req",
					"Install By is a Mandatory Field");
			hisValidator.addValidation("strInstallerContactNo", "req",
					"Installer Contact No. is a Mandatory Field");
			hisValidator.addValidation("strInstallEndDate", "req",
					"Installation End Date is a Mandatory Field");

		}

	var retVal = hisValidator.validate();

	hisValidator.clearAllValidations();

	if (retVal) {
		
		document.forms[0].strManufactureId.disabled = false;
		document.forms[0].strItemSpecification.disabled = false;
		document.forms[0].strUnitSaleID.disabled = false;

		document.forms[0].hmode.value = "INSERT";
		document.forms[0].submit();
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
 * 
 * @param {String}
 *            divId
 */
function showView(divId) {

	document.getElementById(divId + "PlusId").style.display = "none";
	document.getElementById(divId + "MinusId").style.display = "block";

	document.getElementById(divId).style.display = "block";

}

/**
 * hideView
 * 
 * @param {String}
 *            divId
 */
function hideView(divId) {

	document.getElementById(divId + "PlusId").style.display = "block";
	document.getElementById(divId + "MinusId").style.display = "none";

	document.getElementById(divId).style.display = "none";

}

/**
 * showOrHideDetails
 * 
 * @param {Object}
 *            chkObj
 * @param {String}
 *            divId
 */
function showOrHideDetails(chkObj, divId) {

	if (chkObj.checked) {

		document.getElementById(divId).style.display = "block";

	} else {

		document.getElementById(divId).style.display = "none";
	}

}

/**
 * getSubGroupList
 * 
 * @param {Object}
 *            grpObj
 */
function getSubGroupListDtls(grpObj) {

	var mode = "SUBGRPLIST";

	var url = "GiftedItemDetailsTransCNTNEW.cnt?hmode=" + mode + "&GroupId="
			+ grpObj.value;

	ajaxFunction(url, "8");

}

function ajaxItemName(mode) {

	var mode = "ITEMNAME";

	var url = "GiftedItemDetailsTransCNTNEW.cnt?hmode="
			+ mode
			+ "&strSubGroupId="
			+ document.forms[0].strSubGroupId[document.forms[0].strSubGroupId.selectedIndex].value
			+ "&GroupId="
			+ document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value
			+ "&storeId=" + document.forms[0].strStoreId.value + "&catCode="
			+ document.forms[0].strItemCategoryNo.value;

	ajaxFunction(url, "1");

}

function ajaxItemBrandName1(mode) {
	var mode = "UNITNAMECOMBO";

	// alert("strore id"+document.forms[0].strItemName.value);
	var url = "GiftedItemDetailsTransCNTNEW.cnt?hmode=" + mode + "&strItemId="
			+ document.forms[0].strItemId.value + "&strCatCode="
			+ document.forms[0].strItemCategoryNo.value;
	ajaxFunction(url, "3");
}

function ajaxItemBrandName(mode) {
	var mode = "ITEMBRANDNAME";

	// alert("strore id"+document.forms[0].strItemName.value);
	var url = "GiftedItemDetailsTransCNTNEW.cnt?hmode=" + mode + "&strItemId="
			+ document.forms[0].strItemId.value + "&storeId="
			+ document.forms[0].strStoreId.value + "&strSubGroupId="
			+ document.forms[0].strSubGroupId.value + "&strGroupId="
			+ document.forms[0].strGroupId.value + "&strCatCode="
			+ document.forms[0].strItemCategoryNo.value;
	ajaxFunction(url, "2");

}

function isCurrencyMandatory(obj) {

	if (obj.value != document.forms[0].strDefaultCurrencyCode.value) {

		document.forms[0].isCurrencyReq.value = "1";
		document.forms[0].strCurrencyValue.disabled = false;
		document.getElementById("currencyDivId").innerHTML = "<font color='red'>*</font>Currency Value";

	} else {

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
	var url = "GiftedItemDetailsTransCNTNEW.cnt?hmode=MANUFECTURENAME&strItemBrandId="
			+ document.forms[0].strItemBrandId.value
			+ "&strCatCode="
			+ document.forms[0].strItemCategoryNo.value;

	ajaxFunction(url, "5");
}

function getItemBrandDetails() {

	if (document.forms[0].strItemBrandId.value != 0) {

		var mode = "BRANDDETAILS";
		var url = "GiftedItemDetailsTransCNTNEW.cnt?hmode="
				+ mode
				+ "&strItemBrandId="
				+ document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value;

		ajaxFunction(url, "10");

	} else {

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
		objVal.innerHTML = "<select name ='strItemId' class='browser-default custom-select' onChange = 'ajaxItemBrandName(\"ITEMBRANDNAME\")' >"
				+ res + "</select>";
	}
	if (mode == "2") {

		objVal = document.getElementById("ItemBrandId");
		objVal.innerHTML = "<select name ='strItemBrandId' class='browser-default custom-select' onChange='ajaxManufectureName(\"MANUFECTURENAME\");' >"
				+ res + "</select>";

		getItemMandatoryDtls('0');

	}

	if (mode == "3") {

		/*
		objVal = document.getElementById("UnitRateID");
		objVal.innerHTML = "<input type='text' value='No.' disabled='disabled' name ='strUnitRateID' class='form-control'>"
				+ res ;
		document.getElementById("UnitRateID1").innerHTML = "<input type='text' value='No.' disabled='disabled' name ='strUnitSaleID' class='form-control'>"
				+ res ;
		document.getElementById("freeItemUnit").innerHTML = "<input type='text' value='No.' disabled='disabled' name ='strInHandQuantityUnitID' class='form-control' >"
				+ res ;
				*/

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

		document.getElementById("manufDivId").innerHTML = "<select class='browser-default custom-select' name='strManufactureId' onchange='setWarrantyManfacturer(this);' >"
				+ res + "</select>";

		if (document.getElementById("warrantyManufDivId") != null)
			document.getElementById("warrantyManufDivId").innerHTML = "<select class='browser-default custom-select' name='strWarantyManufacturer' >"
					+ res + "</select>";

		getItemBrandDetails();

	}

	if (mode == "6") {

		objVal = document.getElementById("itemCategoryDivId");
		objVal.innerHTML = "<select name='strItemCategoryId' onchange='reSetViewDetails(this);' class='browser-default custom-select'>"
				+ res + "</select>";

		getFinYears();

	}

	if (mode == "7") {

		objVal = document.getElementById("giftedViewDetailsDivId");
		objVal.style.display = "block";
		//document.getElementById("viewCancelButtonDivId").style.display = "block";
		objVal.innerHTML = res;
	}

	if (mode == "8") {

		objVal = document.getElementById("subGroupComboDivID");
		objVal.innerHTML = "<select name='strSubGroupId' class='browser-default custom-select' onChange='ajaxItemName(\"ITEMNAME\");'>"
				+ res + "</select>";

		ajaxItemName("ITEMNAME");

	}

	if (mode == "9") {

		objVal = document.getElementById("finYearDivId");
		objVal.innerHTML = res;

	}

	if (mode == '10') 
	{

		var brandDtls = res.split("^");

//	alert("brandDtls[4].split('$$')[1]"+brandDtls[4].split("$$")[1]);

		document.forms[0].strRegFlag.value = brandDtls[0];
		document.forms[0].strConfigIssueRate.value = brandDtls[4].split("$$")[0];

		if (brandDtls[0] == '2') {

			document.getElementById("manfNotMandatoryDivId").style.display = "none";
			document.getElementById("manfMandatoryDivId").style.display = "block";

			document.getElementById("specNotMandatoryDivId").style.display = "none";
			document.getElementById("specMandatoryDivId").style.display = "block";

			document.forms[0].strManufactureId.selectedIndex = 0;
			document.forms[0].strManufactureId.disabled = false;
			document.forms[0].strItemSpecification.value = "";
			document.forms[0].strItemSpecification.disabled = false;

		} else {

			document.getElementById("manfNotMandatoryDivId").style.display = "block";
			document.getElementById("manfMandatoryDivId").style.display = "none";

			document.getElementById("specNotMandatoryDivId").style.display = "block";
			document.getElementById("specMandatoryDivId").style.display = "none";

			document.forms[0].strManufactureId.value = brandDtls[3];
//			document.forms[0].strManufactureId.disabled = true;
			document.forms[0].strItemSpecification.value = brandDtls[1];
			document.forms[0].strItemSpecification.disabled = true;
		}

		document.getElementById("stockStatusComboDivId").innerHTML ="<select name='strStockStatus' class='browser-default custom-select'>"+ brandDtls[4].split("$$")[1] +"</select>" 
		  
	}
	if(mode=="11")
    {
		
		var objVal = document.getElementById("voucherDivId");
		objVal.innerHTML = res;
		//alert(objVal.innerHTML);
		popup('popUpDiv1', '130', '200');
	//document.getElementById("debitNoteDiv").style.display='block';
    }

}

/**
 * checkForWarrantyDtls
 * 
 * @param {String}
 *            divId
 */
function checkForWarrantyDtls(divId) {

	if (document.forms[0].strIsWarrantyDetails != null)
		if (document.forms[0].strIsWarrantyDetails.checked == true) {

			document.getElementById(divId).style.display = "block";

		} else {

			document.getElementById(divId).style.display = "none";
		}
}

/**
 * checkFoInstallationDtls
 * 
 * @param {String}
 *            divId
 */
function checkFoInstallationDtls(divId) {

	if (document.forms[0].strIsInstallDetails != null)
		if (document.forms[0].strIsInstallDetails.checked == true) {

			document.getElementById(divId).style.display = "block";

		} else {

			document.getElementById(divId).style.display = "none";
		}
}

/**
 * setWarrantyManfacturer
 * 
 * @param {Object}
 *            comboObj
 */
function setWarrantyManfacturer(comboObj) {

	if (document.getElementsByName("strWarantyManufacturer").length > 0) {

		document.forms[0].strWarantyManufacturer.selectedIndex = comboObj.selectedIndex;

	}

}

/**
 * addFreeItems
 * 
 */
function addFreeItems() {

	var hisValidator = new HISValidator("giftedItemDetailsTransBean");

	hisValidator.addValidation("strItemId", "dontselect=0",
			"Please Select a Generic Item");
	hisValidator.addValidation("strItemBrandId", "dontselect=0","Please Select a Item");

	var retVal = hisValidator.validate();

	hisValidator.clearAllValidations();

	if (retVal) {

		var mode = "1";
		var isBatchReq = document.forms[0].isBatchReq.value;
		var isExpDtReq = document.forms[0].isExpirtReq.value;

		getItemOtherDetailsView(mode, isBatchReq, isExpDtReq, '1',
				"giftedItemDetailsTransBean");
	} else {

		return false;
	}

}

/**
 * addFreeItems
 * 
 */
function addPartItems() {

	var hisValidator = new HISValidator("giftedItemDetailsTransBean");

	hisValidator.addValidation("strItemId", "dontselect=0",
			"Please Select a Generic Item");
	hisValidator.addValidation("strItemBrandId", "dontselect=0","Please Select a Item");

	var retVal = hisValidator.validate();

	hisValidator.clearAllValidations();

	if (retVal) {

		var mode = "2";
		var isBatchReq = document.forms[0].isBatchReq.value;
		var isExpDtReq = document.forms[0].isExpirtReq.value;

		getItemOtherDetailsView(mode, isBatchReq, isExpDtReq, '2',
				"giftedItemDetailsTransBean");

	} else {

		return false;
	}

}

/**
 * checkForPopup
 * 
 * @param {Object}
 *            parentObject
 * @param {String}
 *            catNo
 */
function checkForPopup(parentObject, catNo, mode) {

	if (document.getElementById("itemParameterDtlDivId").innerHTML.length == 0) {

		if (mode == '1') {
			//alert();
			showPopup(parentObject, mode, catNo, '');

		} else if (mode == '2') {

			var itemVal = document.forms[0].strChk.value.split('@');

			showPopup(parentObject, mode, catNo, itemVal[2]);

		}

	} else {

		popup('popUpDivId', '100', '250');

	}

}

/**
 * validateQty - Qty validation.
 * 
 * @param {String}
 *            unitName
 * @param {String}
 *            qtyName
 */
function validateQty(qtyName, unitName) 
{

	//var unitObj = document.getElementsByName(unitName)[0];
	var qtyObj = document.getElementsByName(qtyName)[0];

	var qtyDeceimal = qtyObj.value;

	//var unitVal = unitObj.value.split('^')[2];

	if (qtyDeceimal.indexOf('.') > -1) {

		alert("Qty must be an Integer ");
		qtyObj.value = '0';
		qtyObj.focus();
		return false;
	}

	return true;
}

/**
 * reSetViewDetails
 * 
 * @param {}
 */
function reSetViewDetails(obj) {

	objVal = document.getElementById("giftedViewDetailsDivId");
	objVal.style.display = "none";
	var catgId = (obj.value).split("^")[0];
	//alert("catgId---"+catgId);
    if(catgId !="10")
    {
    	objVal = document.getElementById("giftedById");
		objVal.innerHTML = "<select name='strGiftedBy' class='browser-default custom-select'><option value='HSCC'>HSCC</option><option value='Other'>Other</option></select>";
    }
    else
    {
    	objVal = document.getElementById("giftedById");
		objVal.innerHTML = "<input type='text' class='form-control' placeholder='Supplier' name='strGiftedBy'  value ='Gifted By' maxlength='100' onkeypress='return validateData(event,4);'>";
    }

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

	 

function getIssueRateUnitCombo()
{
	          
		document.forms[0].strUnitSaleID.value=document.forms[0].strUnitRateID.value;
}	 





function get_MonthInt(str)
{
	var month = "0";
	
	switch(str.toUpperCase())
	{
		case "JAN":
			month = "1";
			break;
		case "FEB":
			month = "2";
			break;
		case "MAR":
			month = "3";
			break;
		case "APR":
			month = "4";
			break;
		case "MAY":
			month = "5";
			break;
		case "JUN":
			month = "6";
			break;
		case "JUL":
			month = "7";
			break;
		case "AUG":
			month = "8";
			break;
		case "SEP":
			month = "9";
			break;
		case "OCT":
			month = "10";
			break;
		case "NOV":
			month = "11";
			break;
		case "DEC":
			month = "12";
			break;
	}
	return month;
}
function Days_InMonth(mon, year) 
{
	var retVal;
	
	retVal = 31;
	if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {retVal = 30;}
	if (mon == 2) {retVal = days_InFebruary(year);}
   	return retVal;
}

//this is internal function that returns day in feb month for specified year
function days_InFebruary (year)
{
	return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
}
function get_Seperator(dtStr)
{
	var seprator = "";
	if (dtStr.indexOf("-") > -1)
		seprator = "-";
	else
	{
		if (dtStr.indexOf("/") > -1)
			seprator = "/";
		else
		{
			if (dtStr.indexOf(".") > -1)
				seprator = ".";
		}
	}	//endif
	return seprator;
}
function parse_Date(dtStr,seprator)
{
	var pos1,pos2,tempLen=0;
	var tempStr = "";
	var intDay = 0,intMon = 0,intYear = 0;
	var retValue = false;
	pos1 = dtStr.indexOf(seprator);
	pos2 = dtStr.indexOf(seprator,pos1+1);
	if(pos1 > 0 && pos2 > (pos1 + 1))
	{
		//day
		tempStr = dtStr.substring(0,pos1);
		tempLen = tempStr.length;
		if(tempLen > 0 && tempLen <=2)
		{
			intDay = parseInt(tempStr,'10');
			//month
			tempStr = dtStr.substring(pos1+1,pos2);
			tempLen = tempStr.length;
			if(tempLen > 0 && tempLen <= 3)
			{
				//format given as dd/mmm/yyyy
				if(tempLen == 3) tempStr = get_MonthInt(tempStr);	
				intMon = parseInt(tempStr,'10');
				if(intMon > 0) 
				{
					//year
					tempStr = dtStr.substring(pos2+1);
					tempLen = tempStr.length;
					if(tempLen == 4)
					{
						intYear = parseInt(tempStr,'10');
						if (intYear >= 1900 && intYear <= 9900)
						{
							if (intMon >= 1 && intMon <= 12)
							{
								if (intDay > 0 && intDay <= Days_InMonth(intMon, intYear))
									retValue = true;
							}
						}
					}
				}
			}
		}
	}
	
	return {cancelKey :retValue,day:intDay,month:intMon,year:intYear};
}
function compare_Date(frDate,toDate)
{
	var seprator1 = "", seprator2 = "";
	var retValue = false;
	var dtMode = 0;
	var retValues1,retValues2;
	if (frDate != "" && frDate != null && toDate != "" && toDate != null)
	{
		seprator1 = get_Seperator(frDate);		//function that returns seperator
		seprator2 = get_Seperator(toDate);		//function that returns seperator
		if (seprator1 != "" && frDate.length >= 8)
		{
			retValues1 = parse_Date(frDate,seprator1);
			if (seprator2 != "" && toDate.length >= 8 && retValues1.cancelKey == true)
			{
				retValues2 = parse_Date(toDate,seprator2);
				if(retValues2.cancelKey == true)
				{
					if(retValues1.year == retValues2.year)
					{
						if(retValues1.month == retValues2.month)
						{
							if(retValues1.day == retValues2.day)
								dtMode = 1;
							else
							{
								if(retValues1.day > retValues2.day)
									dtMode = 2;
								else
									dtMode = 0;
							}
						}
						else
						{
							if(retValues1.month > retValues2.month)
								dtMode = 2;
							else
								dtMode = 0;	
						}
					}
					else
					{
						if(retValues1.year > retValues2.year)
							dtMode = 2;
						else
							dtMode = 0;		
					}
					
					retValue = true;
				}
			}
		}
	}
	
	return {cancelKey :retValue,mode:dtMode};
} //end compareDate() function
function dateDiff1(date_1,date_2) 
{
	if(date_1==date_2)
	{
	//alert("same day");
	//var o=document.getElementById("daysOnLeave");
	//o.innerHTML="<font color='blue' weight='strong'>same day</font>";
	//document.forms[0].strDaysOnLeave.value=1;
	return 0;
	}
	var retVal=compare_Date(date_1,date_2);
	//alert("retVal.mode->"+retVal.mode);
	if(retVal.mode!=0)
	{
		alert("From Date should be less than To Date");
		return false;
	}		
	if(retVal.mode==0)
	{
		var ret=parse_Date(date_1,"-");
		var ret1=parse_Date(date_2,"-");
		var dt1=ret.month+"-"+ret.day+"-"+ret.year;
		var dt2=ret1.month+"-"+ret1.day+"-"+ret1.year;
		date1 = new Date();
		date2 = new Date();
		diff  = new Date();
		//alert("Valid From/in format DD-MM-YYYY->"+dt1);
		//alert("Valid To/in format DD-MM-YYYY->"+dt2);
		{ // Validates first date 
		var myDate1=new Array();
		myDate1=dt1.split("-");
		date1temp = new Date(myDate1[2],myDate1[0],myDate1[1]);
		date1.setTime(date1temp.getTime());
		}
		{ // Validates second date 
		var myDate2=new Array();
		myDate2=dt2.split("-");
		date2temp = new Date(myDate2[2],myDate2[0],myDate2[1]);
		//alert("date2temp.getTime()->"+date2temp.getTime());
		date2.setTime(date2temp.getTime());
		}
		// sets difference date to difference of first date and second date
		//alert("date1.getTime()->"+date1.getTime());
		diff.setTime(Math.abs(date1.getTime() - date2.getTime()));
		timediff = diff.getTime();
		//alert("timediff->"+timediff);
		weeks = Math.floor(timediff / (1000 * 60 * 60 * 24 * 7));
		timediff -= weeks * (1000 * 60 * 60 * 24 * 7);
		days = Math.floor(timediff / (1000 * 60 * 60 * 24)); 
		timediff -= days * (1000 * 60 * 60 * 24);
		days=parseInt(weeks)*7+days;
		//var diff = /*weeks + " weeks, " +*/ days + " days " ;
		diff=days;
		//alert("date diff->"+diff);
		//var o=document.getElementById("daysOnLeave");
		//o.innerHTML="<font color='blue' weight='strong'>"+diff+"</font>";
		//document.forms[0].strDaysOnLeave.value=diff;
		return diff;
	}
}

function dateDiff2(date_1,date_2) 
{
	if(date_1==date_2)
	{
	//alert("same day");
	//var o=document.getElementById("daysOnLeave");
	//o.innerHTML="<font color='blue' weight='strong'>same day</font>";
	//document.forms[0].strDaysOnLeave.value=1;
	return 0;
	}
	var retVal=compare_Date(date_1,date_2);
	//alert("retVal.mode->"+retVal.mode);
	if(retVal.mode!=0)
	{
		//alert("From Date should be less than To Date");
		return false;
	}		
	if(retVal.mode==0)
	{
		var ret=parse_Date(date_1,"-");
		var ret1=parse_Date(date_2,"-");
		var dt1=ret.month+"-"+ret.day+"-"+ret.year;
		var dt2=ret1.month+"-"+ret1.day+"-"+ret1.year;
		date1 = new Date();
		date2 = new Date();
		diff  = new Date();
		//alert("Valid From/in format DD-MM-YYYY->"+dt1);
		//alert("Valid To/in format DD-MM-YYYY->"+dt2);
		{ // Validates first date 
		var myDate1=new Array();
		myDate1=dt1.split("-");
		date1temp = new Date(myDate1[2],myDate1[0],myDate1[1]);
		date1.setTime(date1temp.getTime());
		}
		{ // Validates second date 
		var myDate2=new Array();
		myDate2=dt2.split("-");
		date2temp = new Date(myDate2[2],myDate2[0],myDate2[1]);
		//alert("date2temp.getTime()->"+date2temp.getTime());
		date2.setTime(date2temp.getTime());
		}
		// sets difference date to difference of first date and second date
		//alert("date1.getTime()->"+date1.getTime());
		diff.setTime(Math.abs(date1.getTime() - date2.getTime()));
		timediff = diff.getTime();
		//alert("timediff->"+timediff);
		weeks = Math.floor(timediff / (1000 * 60 * 60 * 24 * 7));
		timediff -= weeks * (1000 * 60 * 60 * 24 * 7);
		days = Math.floor(timediff / (1000 * 60 * 60 * 24)); 
		timediff -= days * (1000 * 60 * 60 * 24);
		days=parseInt(weeks)*7+days;
		//var diff = /*weeks + " weeks, " +*/ days + " days " ;
		diff=days;
		//alert("date diff->"+diff);
		//var o=document.getElementById("daysOnLeave");
		//o.innerHTML="<font color='blue' weight='strong'>"+diff+"</font>";
		//document.forms[0].strDaysOnLeave.value=diff;
		return diff;
	}
}
function onSelectRadioButton(strHiddenVal,index)
{		
  // var passValue = document.getElementById("strdebitNote"+index).value;
  //alert(strHiddenVal);
  document.forms[0].strHiddenValue.value  = strHiddenVal;
  //alert(document.forms[0].strHiddenValue.value);
   
   
	
}


function validate2()
{	
	    
		 if(document.forms[0].strHiddenValue.value=='0')
		 {
			alert('Please Select Transaction Number');
			return false;
		 }
	      
	      
	      var strTemp  = (document.forms[0].strHiddenValue.value).split("^");
		 
		  var transactionNumber  = strTemp[0];
		  var supplier           = strTemp[3];
		  var pono               = strTemp[4];
		  var voucherDate        = strTemp[1];
		  var mode="VOUCHERPRINT";
		  var url = "GiftedItemDetailsTransCNTNEW.cnt?hmode=" + mode 
		   +"&voucherDate="+voucherDate+"&transactionNumber="+transactionNumber+"&supplier="+supplier
		   +"&pono="+pono+"&itemCategoryName="+document.forms[0].strItemCategoryName.value;
		   ajaxFunction(url,"11");
		 		
}


function hideTransferPopup(mode)
{
         document.getElementById("voucherDivId").innerHTML = "";			
		  hide_popup('popUpDiv1');
}

function printDataForTransfer() 
{	
	newwin = window.open('', 'printwin',
	'left=100,top=100,width=700,height=700,scrollbars=yes');
newwin.document.write('<HTML><HEAD>');
//newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n')
newwin.document.write('<script>\n');
newwin.document.write('function chkstate(){ \n');
// newwin.document.write('if(document.readystate=="complete" ||
// document.readystate=="undefined"){\n');
newwin.document.write('window.close();\n');
// newwin.document.write('}\n');
// newwin.document.write('else{\n');
// newwin.document.write('setTimeout("chkstate()",2000)\n');
// newwin.document.write('}\n');
newwin.document.write('}\n');
newwin.document.write('function print_win(){\n');
newwin.document.write('window.print();\n');
newwin.document.write('chkstate();\n');
newwin.document.write('}\n');

newwin.document.write('<\/script>\n');
newwin.document.write('</HEAD>\n');
newwin.document.write('<BODY onload="print_win()">\n');
newwin.document.write(document.getElementById('voucherDivId').innerHTML);	
newwin.document.write('</BODY>\n');
newwin.document.write('</HTML>\n');
newwin.document.close();
//document.getElementById("strCrNo").focus();


}	
