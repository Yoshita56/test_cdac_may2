
 var setColor = "red"; 
 var defaultColor = "blue"; 

/**
 * changeViewMode
 * @param {Object} chkObj 
 */


	function onClearPage()
	{
//		document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value ;
//		document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value ;
		document.getElementById('StoreId').value = "0";
		document.getElementById('itemCategoryDivId').value = "0";
		document.getElementById('ItemId').value = "0";
		document.getElementById('InstituteId').value = "0";
		document.getElementById('SupplierDivId').value = "0";
		document.getElementById('strActId').value = "2";
	  	document.getElementsById("strPoNo").value="0";

		document.getElementsByName("strStoreId")[0].disabled=false;
      	document.getElementsByName("strItemCategoryId")[0].disabled=false;
      	document.getElementsByName("strInstituteId")[0].disabled=false;
      	document.getElementsByName("strSupplierId")[0].disabled=false;
      	document.getElementsByName("strItemId")[0].disabled=false;
      	document.getElementsByName("strActId")[0].disabled=false;
	  	document.getElementsByName("strPoNo")[0].disabled=false;

      	objVal = document.getElementById("LocalPurchaseMRN");
		objVal.style.display = "none";
		/*
		var x = document.getElementById("myDIV");
		var y = document.getElementById("myDIV1");
		x.style.display = "none";
		y.style.display = "none";
		*/
		document.getElementById("viewCancelButtonDivId1").style.display = "block";
		objVal.innerHTML = "";
      	
		
	}
	
 function setCombo()
 {
	 if(document.forms[0].strActId[document.forms[0].strActId.selectedIndex].value=="4")
	 {		 
		 document.getElementsByName("strItemId")[0].value ="0";
		 document.getElementsByName("strItemId")[0].disabled=true;
		 
	 }
	 else
	 {
		 document.getElementsByName("strItemId")[0].disabled=false;
	 }
	 
 }
 

 /**
  * getInventoryDtls 
  */
 function getInventoryDtls() 
  {
   	var hisValidator = new HISValidator("mrnAckReportBean");
//	hisValidator.addValidation("strStoreId", "dontselect=0","Please Select a Store");
//	hisValidator.addValidation("strItemCategoryId", "dontselect=0","Please Select a Category");
//  hisValidator.addValidation("strInstituteId", "dontselect=0","Please Select an Purchase Through");

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
	  	document.forms[0].strInstituteName.value = document.forms[0].strInstituteId[document.forms[0].strInstituteId.selectedIndex].text;
	  	document.forms[0].strSupplierName.value = document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].text;

	   	var hmode = "GOVIEWPAGE"; 
		var url = "MRNAckReportCNT.cnt?hmode="+hmode+
		
		"&storeId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+
		"&strCategoryId="+document.forms[0].strItemCategoryId[document.forms[0].strItemCategoryId.selectedIndex].value.split('^')[0]+
		
		"&strCategoryName="+document.forms[0].strItemCategoryId[document.forms[0].strItemCategoryId.selectedIndex].text+
		
		"&startDate="+document.forms[0].strFromDate.value+
		"&endDate="+document.forms[0].strToDate.value+
		
		"&storeName="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text+
		
		"&strItemId="+document.forms[0].strItemId[document.forms[0].strItemId.selectedIndex].value.split('^')[0]+
		"&strItemName="+document.forms[0].strItemId[document.forms[0].strItemId.selectedIndex].text+
		
		
		"&strInstituteId="+document.forms[0].strInstituteId[document.forms[0].strInstituteId.selectedIndex].value+
		"&strInstituteName="+document.forms[0].strInstituteId[document.forms[0].strInstituteId.selectedIndex].text+
		
		"&strSupplierId="+document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].value+
		"&strSupplierName="+document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].text+
		
		"&strActId="+document.forms[0].strActId[document.forms[0].strActId.selectedIndex].value+
		"&strPoNo="+document.forms[0].strPoNo.value;
		
		document.getElementsByName("strStoreId")[0].disabled=true;
	  	document.getElementsByName("strItemCategoryId")[0].disabled=true;
	  	document.getElementsByName("strInstituteId")[0].disabled=true;
	  	document.getElementsByName("strSupplierId")[0].disabled=true;
	  	document.getElementsByName("strItemId")[0].disabled=true;
	  	document.getElementsByName("strActId")[0].disabled=true;
	  	document.getElementsByName("strPoNo")[0].disabled=true;

	  	ajaxFunction(url,"7");
	
	  	}else {
	  		
    	document.getElementsByName("strStoreId")[0].disabled=false;
      	document.getElementsByName("strItemCategoryId")[0].disabled=false;
      	document.getElementsByName("strInstituteId")[0].disabled=false;
      	document.getElementsByName("strSupplierId")[0].disabled=false;
      	document.getElementsByName("strItemId")[0].disabled=false;
      	document.getElementsByName("strActId")[0].disabled=false;
      	document.getElementsByName("strPoNo")[0].disabled=false;

		return false;
		} 
  }
  
 function itemNameCombo()
 {

	var mode = "LPITEMNAME"; 
	var url = "MRNAckReportCNT.cnt?hmode="+mode+
	"&itemCat="+document.forms[0].strItemCategoryId[document.forms[0].strItemCategoryId.selectedIndex].value.split('^')[0];
//	alert("URL------------->"+url);
    ajaxFunction(url,"100");
 } 
 function getAjaxResponse(res,mode)
 {
 	
 	var objVal;

	
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
		objVal = document.getElementById("LocalPurchaseMRN");
		objVal.style.display = "block";
		var x = document.getElementById("myDIV");
		var y = document.getElementById("myDIV1");
		x.style.display = "none";
		y.style.display = "none";
		document.getElementById("viewCancelButtonDivId1").style.display = "block";
		objVal.innerHTML = res;
	}

if (mode == "8") {


		objVal = document.getElementById("subGroupComboDivID");
		objVal.innerHTML = "<select name='strSubGroupId' class='comboMax' onChange='ajaxItemName(\"ITEMNAME\");'>"+res+"</select>";
				
		ajaxItemName("ITEMNAME");
		
	}


     if (mode == "9") 
     {
		objVal = document.getElementById("finYearDivId");
		objVal.innerHTML = res;
	}
	
	if (mode == "10")
	{
	    objVal = document.getElementById("giftedUpdateStockItemDivId");
		objVal.style.display = "none";
//	    objVal = document.getElementById("giftedNewItemDivId");
//		objVal.style.display = "block";
		document.getElementById("viewCancelButtonDivId").style.display = "block";
		objVal.innerHTML = res;
	}
	if (mode == "11") 
	{
//	    objVal = document.getElementById("giftedNewItemDivId");
//		objVal.style.display = "none";
		objVal = document.getElementById("giftedUpdateStockItemDivId");
		objVal.style.display = "block";
		document.getElementById("viewCancelButtonDivId").style.display = "block";
		objVal.innerHTML = res;
	}
	
	
	
	if (mode == '12') {
	
	
		 var brandDtls = res.split("^");
		 
		 document.forms[0].strRegFlag.value = brandDtls[0];

		document.forms[0].strConfigIssueRate.value = brandDtls[4].split("$$")[0];	
		//alert("brandDtls[4].split('$$')[1]"+brandDtls[4].split("$$")[1]);	
		 
		 if(brandDtls[0] == '2')
		 {
		 	
		 	document.getElementById("manfNotMandatoryDivId").style.display = "none";
		 	document.getElementById("manfMandatoryDivId").style.display = "block";
		 	
		 	document.getElementById("specNotMandatoryDivId").style.display = "none";
		 	document.getElementById("specMandatoryDivId").style.display = "block";
		 		 	
		 	document.forms[0].strManufactureId.selectedIndex = 0;	 	
		 	document.forms[0].strManufactureId.disabled = false; 	
		 	document.forms[0].strItemSpecification.value = "";	 	
		 	document.forms[0].strItemSpecification.disabled = false; 	
		 		 	
		 }
		 else
		 {
		 	
		 	document.getElementById("manfNotMandatoryDivId").style.display = "block";
		 	document.getElementById("manfMandatoryDivId").style.display = "none";
		 	
		 	document.getElementById("specNotMandatoryDivId").style.display = "block";
		 	document.getElementById("specMandatoryDivId").style.display = "none";
		 		 	
		 	document.forms[0].strManufactureId.value = brandDtls[3];	
		 	//document.forms[0].strManufactureId.disabled = true; 	
		 	document.forms[0].strItemSpecification.value = brandDtls[1];	 	
			document.forms[0].strItemSpecification.disabled = true; 			 			 	
		 }
		 
		 	//document.getElementById("stockStatusComboDivId").innerHTML ="<select name='strStockStatus' class='comboNormal'>"+ brandDtls[4].split("$$")[1] +"</select>"
	}

 }

 
 function changeViewMode(chkObj) 
 {
 	//document.forms[0].strStoreId.selectedIndex = 0;
 	//strItemCategoryId
  	//document.getElementById("itemCategoryDivId").innerHTML = "<select name='strItemCategoryId' class='comboMax'><option value='0'>Select Value</option></select>";
 	 	//alert(chkObj.value);
 	 	//alert(chkObj.value =='3');
 	if(chkObj.value =='3')
 	{
 		document.getElementById("giftedItemViewMode").style.display = "block";
 		document.getElementById("giftedViewDetailsDivId").style.display = "none";
 		document.getElementById("viewCancelButtonDivId").style.display = "none";
 		document.getElementById("itemDetailsMode").style.display = "none";

// 		document.getElementById("giftedNewItemDivId").style.display = "none";
 	//	document.getElementById("giftedUpdateStockItemDivId").style.display = "none";
 		
 		document.forms[0].strReceivedItemApprovedMode.checked = false;
        document.forms[0].strReceivedItemStockUpdateMode.checked = false;
        document.forms[0].strReceivedItemViewMode.checked = true;
        
 	}
 	else
 	{
 	   if(chkObj.value =='4')
 	   {
 		  document.getElementById("giftedItemViewMode").style.display = "none";
 		  document.getElementById("itemDetailsMode").style.display = "block";
 		  document.getElementById("viewCancelButtonDivId").style.display = "none";
 		  
 		  //getNewReceving(chkObj.value);
 		  
 		  document.forms[0].strReceivedItemApprovedMode.checked = true;
          document.forms[0].strReceivedItemStockUpdateMode.checked = false;
          document.forms[0].strReceivedItemViewMode.checked = false;
 		}
 		else
 		{
 		  document.getElementById("giftedItemViewMode").style.display = "none";
 		  document.getElementById("itemDetailsMode").style.display = "block";
 		  document.getElementById("viewCancelButtonDivId").style.display = "none";
 		  		  
 		  //getNewReceving(chkObj.value);
 		  document.forms[0].strReceivedItemApprovedMode.checked = false;
          document.forms[0].strReceivedItemStockUpdateMode.checked = true;
          document.forms[0].strReceivedItemViewMode.checked = false;
 		}
 	}
 	
 }
  /* Ajax function Not in Use */
  function getNewReceving(chkValue) 
  {
            var data = chkValue;
 			var hmode = "NEWRECEVING"; 
			var url = "MRNAckReportCNT.cnt?hmode="+hmode+"&storeId="+chkValue;
 			ajaxFunction(url,"10");
			
  }
 function InitialProcess()
 {
 
    document.getElementById("plus").style.display="none";
	document.getElementById("minus").style.display="block";
	document.getElementById("demographicInfo").style.display="block"; 
 
 } 
 
  /**
 *  function to show Received details on click of +sign
 */
function showinfo(){
	document.getElementById("plus").style.display="none";
	document.getElementById("minus").style.display="block";
	document.getElementById("demographicInfo").style.display="block";
}

/**
 *  function to hide Received details on click of -sign 
 */
function hideinfo(){
	document.getElementById("plus").style.display="block";
	document.getElementById("minus").style.display="none";
	document.getElementById("demographicInfo").style.display="none";
}

function pageResetMethod()
{
	
	document.forms[0].reset();
	document.forms[0].strSalePrice.disabled = false;
	
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
   
   function hideAll(endVal){
	
		for(var i = 1; i <= endVal ; i++){
			document.getElementById("tariffDivId"+i).style.display="none";
		}
		
	}   
	
 
 /**
  * cancelViewPage 
  */
  function cancelViewPage() {
  	
  	//document.forms[0].hmode.value = "INITPAGE";
  //	document.forms[0].submit();
  	//document.forms[0].hmode.value = "CANCELPAGE";
  	//document.forms[0].submit();
  	 window.parent.closeTab();
	 
  	
  }
 
 
 
 function getFinYears() {
 		
			var hmode = "GETFINYR"; 
			var url = "GiftedItemDetailsTransCNT.cnt?hmode="+hmode+"&storeId="+document.forms[0].strStoreId.value;
			
 			ajaxFunction(url,"9");
			
 }
 
 function onClearButton(){
	 	//alert("chk2");
	 	document.getElementById("StoreId").disabled = false;
		document.getElementById("itemCategoryDivId").disabled = false;
		document.getElementById("InstituteId").disabled = false;
	 	document.forms[0].strStoreId.value = "10201100";
	 	document.forms[0].strItemCategoryId.value = "10^0^0";
	 	//document.forms[0].strInstituteId.value = "0";
	 	document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value;
	 	document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value;
	 	}
 
 
 
 
  function printDataOne() 
  {
	  var x = document.getElementById("printImg");
	  x.style.display = "none";
		
  	newwin = window.open('', 'printwin','left=100,top=100,width=700,height=700,scrollbars=yes');
  	newwin.document.write('<HTML><HEAD>');
  	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
  	newwin.document
  			.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n')
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
  	newwin.document.write(document.getElementById('LocalPurchaseMRN').innerHTML);
  	newwin.document.write('</BODY>\n');
  	newwin.document.write('</HTML>\n');
  	newwin.document.close();
	  var x = document.getElementById("printImg");
	  x.style.display = "block";

  }
 
/**
 * getItemCategorys
 * @param {Object} strCombo 
 */
 function getItemCategorys(strCombo) {
 		
			var hmode = "GETITEMCATLIST"; 
			var url = "MRNAckReportCNT.cnt?hmode="+hmode+"&storeId="+strCombo.value;
			
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
 
 
 
 
 
 function validate1() {
	 alert("1");
	var hisValidator = new HISValidator("mrnAckReportBean");
   document.forms[0].strSalePrice.disabled = false;

hisValidator.addValidation("strStockStatus", "dontselect=0","Please Select a Stock Status");
hisValidator.addValidation("strItemId", "dontselect=0","Please Select a Group Name");


	hisValidator.addValidation("strItemId", "dontselect=0","Please Select a Generic Item");
	hisValidator.addValidation("strItemBrandId", "dontselect=0","Please Select a Drug Name");



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


hisValidator.addValidation("strInHandQuantity", "req","Received Quantity is a Mandatory Field");
hisValidator.addValidation("strInHandQuantityUnitID", "dontselect=0","Please Select a Received Quantity Unit");


if(document.forms[0].strRegFlag.value != '2'){
		
		hisValidator.addValidation("strItemSpecification", "req","Specification is a Mandatory Field");
	}

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

hisValidator.addValidation("strReceivedDate", "req","Received Date is a Mandatory Field");


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
		if(parseFloat(document.forms[0].strRate.value) <= 0.00)
	 	{
	 		alert("Enter rate greater than 0");
	 		document.forms[0].strRate.value="";
	 		document.forms[0].strRate.focus();
	 		return false;
	 	}
		
		if(parseFloat(document.forms[0].strSalePrice.value) <= 0.00)
	 	{
	 		alert("Enter Issue rate greater than 0");
	 		document.forms[0].strSalePrice.value="";
	 		document.forms[0].strSalePrice.focus();
	 		return false;
	 	}
          var conf = confirm("You Are Going To Save Records");
          if(conf == true)
          {
               var conf1 = confirm("Are you sure !!!");
               if(conf1 == true)
               {
                        document.forms[0].strManufactureId.disabled = false; 		 	
						document.forms[0].strItemSpecification.disabled = false; 
						document.forms[0].strUnitSaleID.disabled = false;
						document.forms[0].strUnitRateID.disabled = false;
						document.forms[0].strInHandQuantityUnitID.disabled = false;
						
						
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

/**
 * getSubGroupList
 * @param {Object} grpObj 
 */
 function getSubGroupListDtls(grpObj) {
 	
 	var mode = "SUBGRPLIST";

	var url = "MRNAckReportCNT.cnt?hmode="+mode+"&ItemId="
			+ grpObj.value ;

	ajaxFunction(url, "8");
 	
 }

function ajaxItemName(mode) {

	var mode = "ITEMNAME";

	var url = "MRNAckReportCNT.cnt?hmode="+mode+"&strSubGroupId="
			+ document.forms[0].strSubGroupId[document.forms[0].strSubGroupId.selectedIndex].value + "&GroupId="
			+ document.forms[0].strItemId[document.forms[0].strItemId.selectedIndex].value + "&storeId="
			+ document.forms[0].strStoreId.value+"&catCode="+document.forms[0].strItemCategoryNo.value;
	
//	alert("URL: "+url);
	ajaxFunction(url, "1");

}

function ajaxItemBrandName1(mode) {
	var mode = "UNITNAMECOMBO";

	// alert("strore id"+document.forms[0].strItemName.value);
	var url = "MRNAckReportCNT.cnt?hmode="+mode+"&strItemId="
			+ document.forms[0].strItemId.value+"&itemCategNo="
			+ document.forms[0].strItemCategoryNo.value;
//	alert("URL: "+url);
	ajaxFunction(url, "3");
}

function ajaxItemBrandName(mode) {
	var mode = "ITEMBRANDNAME";

	// alert("strore id"+document.forms[0].strItemName.value);
	var url = "MRNAckReportCNT.cnt?hmode="+mode+"&strItemId="
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
			var url = "MRNAckReportCNT.cnt?hmode="+mode+"&strItemBrandId="
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
	var url = "MRNAckReportCNT.cnt?hmode=MANUFECTURENAME&strItemBrandId="
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
	 	
	 	var hisValidator = new HISValidator("mrnAckReportBean");
	 	
	 		hisValidator.addValidation("strItemId", "dontselect=0","Please Select a Generic Item");
			hisValidator.addValidation("strItemBrandId", "dontselect=0","Please Select a Item");
	
		var retVal = hisValidator.validate();
	
		hisValidator.clearAllValidations();

	if (retVal) {
	
	 	
	 		var mode 		= "1";
	 		var isBatchReq  = document.forms[0].isBatchReq.value;
	 		var isExpDtReq  = document.forms[0].isExpirtReq.value;
	 	
	 	getItemOtherDetailsView(mode, isBatchReq , isExpDtReq , '1' , "mrnAckReportBean");
	}else{
		
		return false;
	}
	 	
	 }
	


	/**
	 * addFreeItems
	  
	 */
	 function addPartItems() {
	 	
	 	var hisValidator = new HISValidator("mrnAckReportBean");
	 	
	 		hisValidator.addValidation("strItemId", "dontselect=0","Please Select a Generic Item");
			hisValidator.addValidation("strItemBrandId", "dontselect=0","Please Select a Item");
	
		var retVal = hisValidator.validate();
	
		hisValidator.clearAllValidations();

	if (retVal) {
	 	
	 		var mode 		= "2";
	 		var isBatchReq  = document.forms[0].isBatchReq.value;
	 		var isExpDtReq  = document.forms[0].isExpirtReq.value;
	 	
	 	getItemOtherDetailsView(mode, isBatchReq , isExpDtReq , '2' , "mrnAckReportBean");
	 	
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