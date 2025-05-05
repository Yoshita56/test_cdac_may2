 var setColor = "red"; 
 var defaultColor = "blue"; 
 
function getAjaxResponse(res,mode)
{
 	var objVal;

	if (mode == "1") {
	
		objVal = document.getElementById("ItemNameId");
		objVal.innerHTML = "<select name ='strItemId' class='comboMax' onChange = 'ajaxItemBrandName(\"ITEMBRANDNAME\")' >"
				+ res + "</select>";
	}
	if (mode == "2") {
	
		objVal = document.getElementById("ItemBrandId");
		objVal.innerHTML = "<select name ='strItemBrandId' class='comboMax' onChange='ajaxManufectureName(\"MANUFECTURENAME\");' >"
				+ res + "</select>";
		
		getItemMandatoryDtls('0');
		
	}
	
	if (mode == "3") {
	
		objVal = document.getElementById("UnitRateID");
		objVal.innerHTML = "<select name ='strUnitRateID' class='comboMin' onchange='getIssueRateUnitCombo();' disabled='disabled' >"
				+ res + "</select>";
		document.getElementById("UnitRateID1").innerHTML = "<select name ='strUnitSaleID'  disabled='disabled' class='comboMin'  onchange='return validateQty(\"strInHandQuantity\",\"strUnitSaleID\");' disabled='disabled' >"
				+ res + "</select>";
		document.getElementById("freeItemUnit").innerHTML = "<select name ='strInHandQuantityUnitID' disabled='disabled' class='comboMin' onchange='return validateQty(\"strInHandQuantity\",\"strInHandQuantityUnitID\");' >"
				+ res + "</select>";
	
	}
	
	else if (mode == "4") {
	
	var temp = res.split('^');
	if(document.forms[0].strItemCategoryNo.value == '10')
	{
		document.forms[0].isBatchReq.value = "1";
		document.getElementById("batchNoDivId").innerHTML = "<font color='red'>*</font>Batch No.";
	}
	else
	{
		document.forms[0].isBatchReq.value = "0";
		document.getElementById("batchNoDivId").innerHTML = "Batch No.";
	}
	//document.getElementById("batchNoDivId").innerHTML = "Batch No.";
	if(document.forms[0].strItemCategoryNo.value == '10')
	{
		document.forms[0].isExpirtReq.value = "1";
		document.getElementById("expiryDateDivId").innerHTML = "<font color='red'>*</font>Expiry Date";
	}
	else
	{
		document.forms[0].isExpirtReq.value = "0";
		document.getElementById("expiryDateDivId").innerHTML = "Expiry Date";
	}
	
	
	ajaxItemBrandName1('UNITNAMECOMBO');
		
	}
	if (mode == '5') {
	
		document.getElementById("manufDivId").innerHTML = "<select class='comboMax' name='strManufactureId' onchange='setWarrantyManfacturer(this);' >"
				+ res + "</select>";
		if(document.getElementById("warrantyManufDivId") != null)
		document.getElementById("warrantyManufDivId").innerHTML = "<select class='comboMax' name='strWarantyManufacturer' >"
				+ res + "</select>";
			getItemBrandDetails();
		}
	if (mode == "6") {
		objVal = document.getElementById("itemCategoryDivId");
		objVal.innerHTML = "<select name='strItemCategoryId' onchange='reSetViewDetails();' class='comboNormal'>"+res+"</select>";
		
		getFinYears();
	}
	
	if (mode == "7") {
		
		objVal = document.getElementById("ReplacementRpt");
		objVal.style.display = "block";
		
		var x = document.getElementById("FMid");
		x.style.display = "none";
		
		document.getElementById("viewCancelButtonDivId1").style.display = "block";
		objVal.innerHTML = res;
		   document.getElementById("StoreId").disabled = true;
		   document.getElementById("itemCategoryDivId").disabled = true;
		   document.getElementById("strFromDate").disabled = true; 
		   document.getElementById("strToDate").disabled = true;
	}
	if(mode=="100")
	{	
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
		{
	         err.innerHTML = temp1[1];	
	    }
	   else
	    {
	     	 objVal= document.getElementById("ItemId");
			 objVal.innerHTML = "<select name ='strItemId' class='comboNormal'>" + res + "</select>";
	    }
	 }
	if (mode == "21") {
		var itemStockObj = document.getElementById("voucherDivId");
		itemStockObj.innerHTML = res;
		popup('popUpDiv', '80', '60');
	}
}
 
function generateIssueFunc(these, index) 
{	
	var strStoreId = document.getElementById("strHlpStoreId"+index).value;
	var strItemCategoryId = document.getElementById("strHlpItemCategoryId"+index).value; 
	var strFinancialStartYear = document.getElementById("strHlpFinancialStartYear"+index).value; 
	var strFinancialEndYear = document.getElementById("strHlpFinancialEndYear"+index).value; 
	var strDebitNoteNo = document.getElementById("strHlpDebitNoteNo"+index).value; 
	  
	var hmode = "VOUCHER"; 
	
	var url = "ReturnAcknowledgeRPTCNT.cnt?hmode="+hmode
				+"&strId="+strStoreId+
				"&strItemCatId="+strItemCategoryId+
				"&strFromDate="+strFinancialStartYear+
				"&strEndDate="+strFinancialEndYear+
				"&strDebitNoteNo="+strDebitNoteNo;
	
	//alert(url);
	/*var url = "ReturnAcknowledgeRPTCNT.cnt?hmode="+hmode
	+"&strId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+
	"&startDate="+document.forms[0].strFromDate.value+
	"&endDate="+document.forms[0].strToDate.value;*/
	ajaxFunction(url, "21");
}

function hideIssuePopup(){
	
	document.getElementById("voucherDivId").innerHTML = "";
	
	hide_popup('popUpDiv');
	
}

function getReportDtls() 
{
	 
 	var hisValidator = new HISValidator("ReturnAcknowledgeRptbean");

	var diffdate = dateDiff1(document.forms[0].strFromDate.value,document.forms[0].strToDate.value); 
	 
	 if(parseInt(diffdate)>365)
   {
      alert("Difference Between From Date and To Date Should not be greater than 365 days");
		return false;
	 }
	 
	var retVal = hisValidator.validate();

	if (retVal) {
		
	document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	document.forms[0].strItemCategoryName.value = document.forms[0].strItemCategoryId[document.forms[0].strItemCategoryId.selectedIndex].text;

 	var hmode = "GETRPTDTLS"; 
	var url = "ReturnAcknowledgeRPTCNT.cnt?hmode="+hmode+
	
	"&storeId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+
	"&storeName="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text+
	
	"&strCategoryId="+document.forms[0].strItemCategoryId[document.forms[0].strItemCategoryId.selectedIndex].value.split('^')[0]+
	"&strCategoryName="+document.forms[0].strItemCategoryId[document.forms[0].strItemCategoryId.selectedIndex].text+
	
	"&startDate="+document.forms[0].strFromDate.value+
	"&endDate="+document.forms[0].strToDate.value;

	//alert(url);		
	
	ajaxFunction(url,"7");
	
	  	} else {
			return false;
		} 
}

function controlToMainPage()
{	    
	document.forms[0].hmode.value="unspecified";
	document.forms[0].submit();
}

function printVoucher() 
{
	document.getElementById("printVoucrId").style.display="none"; 
    const contentToPrint = document.getElementById("voucherDivId").cloneNode(true);
    const newWin = window.open('', '', 'width=700,height=700,scrollbars=yes');
    newWin.document.write('<html><head>');
    newWin.document.write('<style type="text/css">');
    newWin.document.write('.hidecontrol { display: none; }');
    newWin.document.write('@media print {');
//    newWin.document.write('  #toolbar { display: none; }');
//    newWin.document.write('  body { margin: 0; padding: 0; }');
//    newWin.document.write('  @page { margin: 4mm 3mm; size: A4 portrait; }');
//    newWin.document.write('  table { table-layout: fixed; width: 100%; }');
    newWin.document.write('  table {border-collapse: collapse; }');
//    newWin.document.write('  table td { word-wrap: break-word; font-size: 12px; }');

    // Define page break rules for the repeat-table class
//     newWin.document.write('.repeat-table { page-break-before: always; }');

    newWin.document.write('}');
    newWin.document.write('</style>');
    
    newWin.document.write('</head><body>');
    newWin.document.write(contentToPrint.outerHTML);
    newWin.document.write('</body></html>');
    newWin.document.close();
    newWin.onload = function () {
        newWin.print();
        newWin.close();
        document.getElementById("printVoucrId").style.display="block"; 
    };
}

function printReport() {
    document.getElementById("printRptId").style.display = "none";
    
    // Clone the content excluding the last column
    const contentToPrint = document.getElementById("ReplacementRpt").cloneNode(true);
    const rows = contentToPrint.querySelectorAll('tr');
    
    for (const row of rows) {
        const lastCell = row.lastElementChild;
        if (lastCell) {
            row.removeChild(lastCell);
        }
    }

    const newWin = window.open('', '', 'width=700,height=700,scrollbars=yes');
    newWin.document.write('<html><head>');
    newWin.document.write('<style type="text/css">');
    newWin.document.write('.hidecontrol { display: none; }');
    newWin.document.write('@media print {');
    newWin.document.write('  table {border-collapse: collapse; }');
    newWin.document.write('}');
    newWin.document.write('</style>');
    
    newWin.document.write('</head><body>');
    newWin.document.write(contentToPrint.outerHTML);
    newWin.document.write('</body></html>');
    
    newWin.document.close();
    
    newWin.onload = function () {
        newWin.print();
        newWin.close();
        document.getElementById("printRptId").style.display = "block";
    };
}


 function getItemCategorys(strCombo) {
 		
			var hmode = "GETITEMCATLIST"; 

			var url = "New_Report_For_Acknowledge.cnt?hmode="+hmode+"&storeId="+strCombo.value;
			
 			ajaxFunction(url,"6");
					
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
			 	
			 	if(parseFloat(purchaseRate) <= 0.00)
			 	{
			 		alert("Enter rate greater than 0");
			 		document.forms[0].strRate.value="";
			 		document.forms[0].strRate.focus();
			 		return false;
			 	}
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


function ajaxItemName(mode) {

	var mode = "ITEMNAME";

	var url = "LocalPurchaseMRN_CNT.cnt?hmode="+mode+"&strSubGroupId="
			+ document.forms[0].strSubGroupId[document.forms[0].strSubGroupId.selectedIndex].value + "&GroupId="
			+ document.forms[0].strItemId[document.forms[0].strItemId.selectedIndex].value + "&storeId="
			+ document.forms[0].strStoreId.value+"&catCode="+document.forms[0].strItemCategoryNo.value;
	
//	alert("URL: "+url);
	ajaxFunction(url, "1");

}

function ajaxItemBrandName1(mode) {
	var mode = "UNITNAMECOMBO";
	var url = "LocalPurchaseMRN_CNT.cnt?hmode="+mode+"&strItemId="
			+ document.forms[0].strItemId.value+"&itemCategNo="
			+ document.forms[0].strItemCategoryNo.value;
//	alert("URL: "+url);
	ajaxFunction(url, "3");
}

function ajaxItemBrandName(mode) {
	var mode = "ITEMBRANDNAME";

	var url = "LocalPurchaseMRN_CNT.cnt?hmode="+mode+"&strItemId="
			+ document.forms[0].strItemId.value + "&storeId="
			+ document.forms[0].strStoreId.value+"&strSubGroupId="
				+ document.forms[0].strSubGroupId.value + "&strItemId="
				+ document.forms[0].strItemId.value+"&strCatCode="+document.forms[0].strItemCategoryNo.value;
//	alert("URL: "+url);
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
		if(document.forms[0].strItemCategoryNo.value == '10')
			document.forms[0].isBatchReq.value = "1";
		else
			document.forms[0].isBatchReq.value = "0";
		//document.getElementById("batchNoDivId").innerHTML = "Batch No.";
		if(document.forms[0].strItemCategoryNo.value == '10')
			document.forms[0].isExpirtReq.value = "1";
		else
			document.forms[0].isExpirtReq.value = "0";
		//document.getElementById("expiryDateDivId").innerHTML = "Expiry Date";
		//alert("exp"+document.forms[0].isExpirtReq.value);
		//alert("batch"+document.forms[0].isBatchReq.value);
		
	}

}


function getItemBrandDetails() {
	
	if(document.forms[0].strItemBrandId.value != 0){	
			
			var mode = "BRANDDETAILS";
			var url = "LocalPurchaseMRN_CNT.cnt?hmode="+mode+"&strItemBrandId="
					+ document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value ;
										
			ajaxFunction(url, "12");
	
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




function ajaxManufectureName(mode) {
	var mode = "MANUFECTURENAME";
	var url = "LocalPurchaseMRN_CNT.cnt?hmode=MANUFECTURENAME&strItemBrandId="
			+ document.forms[0].strItemBrandId.value +"&strCatCode="+document.forms[0].strItemCategoryNo.value;


	ajaxFunction(url, "5");
}
function getManufecture(mode) {
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();
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
 * setWarrantyManfacturer
 * @param {Object} comboObj 
 */
 function setWarrantyManfacturer(comboObj) {
 	
 	if(document.getElementsByName("strWarantyManufacturer").length > 0){
 		
 		document.forms[0].strWarantyManufacturer.selectedIndex = comboObj.selectedIndex;
 		
 	}
 	
 }




	/**
	 * addFreeItems
	  
	 */
	 function addFreeItems() {
	 	
	 	var hisValidator = new HISValidator("LocalPurchaseMRNbean");
	 	
	 		hisValidator.addValidation("strItemId", "dontselect=0","Please Select a Generic Item");
			hisValidator.addValidation("strItemBrandId", "dontselect=0","Please Select a Item");
	
		var retVal = hisValidator.validate();
	
		hisValidator.clearAllValidations();

	if (retVal) {
	
	 	
	 		var mode 		= "1";
	 		var isBatchReq  = document.forms[0].isBatchReq.value;
	 		var isExpDtReq  = document.forms[0].isExpirtReq.value;
	 	
	 	getItemOtherDetailsView(mode, isBatchReq , isExpDtReq , '1' , "LocalPurchaseMRNbean");
	}else{
		
		return false;
	}
	 	
	 }
	


	/**
	 * addFreeItems
	  
	 */
	 function addPartItems() {
	 	
	 	var hisValidator = new HISValidator("LocalPurchaseMRNbean");
	 	
	 		hisValidator.addValidation("strItemId", "dontselect=0","Please Select a Generic Item");
			hisValidator.addValidation("strItemBrandId", "dontselect=0","Please Select a Item");
	
		var retVal = hisValidator.validate();
	
		hisValidator.clearAllValidations();

	if (retVal) {
	 	
	 		var mode 		= "2";
	 		var isBatchReq  = document.forms[0].isBatchReq.value;
	 		var isExpDtReq  = document.forms[0].isExpirtReq.value;
	 	
	 	getItemOtherDetailsView(mode, isBatchReq , isExpDtReq , '2' , "LocalPurchaseMRNbean");
	 	
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
function validateQty(qtyName, unitName) 
{

	
		var unitObj = document.getElementsByName(unitName)[0];
		var qtyObj = document.getElementsByName(qtyName)[0];

		
			var qtyDeceimal = qtyObj.value;

			var unitVal = unitObj.value.split('^')[2];

			/*if (qtyDeceimal.indexOf('.') > -1 && unitVal == '0') {

				alert("Qty must be an Integer ");
				qtyObj.value = '0';
				qtyObj.focus();								
				return false;
          }*/


	return true;
}
	
	
	/**
	 * reSetViewDetails
	 * @param {}  
	 */
	 function reSetViewDetails() {
	 	
	 	objVal = document.getElementById("giftedViewDetailsDivId");
		objVal.style.display = "none";
		document.getElementById("viewCancelButtonDivId").style.display = "none";
	 	
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
		if ((fld.value.charAt(i) != decSep)) break;
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
		return;
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