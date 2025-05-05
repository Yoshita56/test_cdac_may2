function ClearPage()
{
    document.forms[0].reset();
    document.getElementById("ExistingBatchId").innerHTML = "<select class='comboNormal' name='strExistingBatchId' onChange='enableNewBatch();'><option value='0'>Select Value</option></select>";
	
}


function validate1()
{
//alert("document.forms[0].strCtDate"+document.forms[0].strCtDate.value);
	var hisValidator = new HISValidator("drugInventoryTransBean");

	//hisValidator.addValidation("strItemId", "dontselect=0","Please Select a Generic Drug");
	//hisValidator.addValidation("strStockStatus", "dontselect=0","Please Select Stock Status");
	hisValidator.addValidation("strItemBrandId", "dontselect=0","Please Select a Drug");
	
	if(document.forms[0].strExistingBatchId.value=='0')
	{
		hisValidator.addValidation("strBatchNo", "req","New Batch No.  is a Mandatory Field");
	}
	else
	{
		hisValidator.addValidation("strBatchNo", "req","Existing Batch No is a Mandatory Field");
	}
	
	
	
	hisValidator.addValidation("strExpiryDate", "req","Expiry Date is a Mandatory Field");
	
   	
   	hisValidator.addValidation("strExpiryDate", "dtgt="+document.forms[0].strCtDate.value,"Expiry Date should be greater than Current Date");
	
	if(document.forms[0].strManufactureDate.value!='')
	{
		hisValidator.addValidation("strManufactureDate", "dtltet="+document.forms[0].strCtDate.value,"Mfg Date should be less than equal to Current Date");
		hisValidator.addValidation("strExpiryDate", "dtgt="+document.forms[0].strManufactureDate.value,"Expiry Date should be greater than Mfg Date");
	}

	var retVal = hisValidator.validate();
	
	//hisValidator.clearAllValidations();

	if (retVal) 
	{
		 document.forms[0].strBatchNo.disabled = false;
		
			document.forms[0].hmode.value = "DUMMYINSERT";
			document.forms[0].submit();
	} 
	else 
	{
		return false;
	}
}

function cancel(mode) {
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
	 	 



function ajaxItemName(mode) {

	var mode = "ITEMNAME";

	var url = "DrugInventoryTransCNT.cnt?hmode=ITEMNAME&strSubGroupId="
			+ document.forms[0].strSubGroupId.value + "&GroupId="
			+ document.forms[0].strGroupId.value + "&storeId="
			+ document.forms[0].strStoreId.value;

	ajaxFunction(url, "1");

}

function ajaxItemBrandName1() 
{
	var mode = "UNITNAMECOMBO";

	 
	var url = "DrugInventoryTransCNT.cnt?hmode=UNITNAMECOMBO&strItemId="+ document.forms[0].strItemId.value;
	
	ajaxFunction(url, "3");
}

function ajaxItemBrandName() {
	var mode = "ITEMBRANDNAME";

	
	var url = "DrugInventoryTransCNT.cnt?hmode=ITEMBRANDNAME&strItemId="
			+ document.forms[0].strItemId.value + "&storeId="
			+ document.forms[0].strStoreId.value+"&strSubGroupId="
				+ document.forms[0].strSubGroupId.value + "&strGroupId="
				+ document.forms[0].strGroupId.value;
			
		
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

		var url = "MmsCNT.cnt?hmode=" + mode + "&itemId="+ document.forms[0].strItemId.value;
		
		ajaxFunction(url, "4");

	} else {

		document.forms[0].isBatchReq.value = "0";
		document.getElementById("batchNoDivId").innerHTML = "Batch No.";

		document.forms[0].isExpirtReq.value = "0";
		document.getElementById("expiryDateDivId").innerHTML = "Expiry Date";

	}

}

function ajaxManufectureName(mode) 
{
	 
        clearFormFields();

  if(document.forms[0].strItemBrandId.value!='0')
  {
   if(mode!='1')
   {
		var mode = "MANUFECTURENAME";
		var url = "DrugInventoryTransCNT.cnt?hmode=MANUFECTURENAME&strItemBrandId="
				+ document.forms[0].strItemBrandId.value + "&storeId="
				+ document.forms[0].strStoreId.value;
	
		ajaxFunction(url, "5");
	}
	else
	{
	    var mode = "MANUFECTURENAME";
		var url = "DrugInventoryTransCNT.cnt?hmode=MANUFECTURENAME&strItemBrandId="
				+ (document.forms[0].strItemBrandId.value).split('^')[1] + "&storeId="
				+ document.forms[0].strStoreId.value;
	    //alert(url);
		ajaxFunction(url, "55");
	}
  }
  else
  {
  	alert("Please Select Drug Name!!!");
  	return false;
  }	
}


function ajaxExistingBatchName(mode) 
{
  if(document.forms[0].strItemBrandId.value!='0')
  {	
	var mode = "EXISTINGBATCH";
	
	var url = "DrugInventoryTransCNT.cnt?hmode="+mode+"&strItemBrandId="+ document.forms[0].strItemBrandId.value + "&storeId="+ document.forms[0].strStoreId.value+ "&strItemId="+ document.forms[0].strItemId.value;
   
	ajaxFunction(url, "7");
  }	
}

function getSubGrpAndGenericItem()
{
	
		objVal = document.getElementById("ItemBrandId");
		objVal.innerHTML = "<select name ='strItemBrandId' class='comboNormal' onChange='ajaxManufectureName();' ><option value='0'>Select Value</option></select>";
	if(document.forms[0].strGroupCmbId[document.forms[0].strGroupCmbId.selectedIndex].value!='0')
	{
	   document.forms[0].strGroupId.value =	 document.forms[0].strGroupCmbId[document.forms[0].strGroupCmbId.selectedIndex].value;
	   var mode = "SUBGRPAJAX";
	   var url = "DrugInventoryTransCNT.cnt?hmode=SUBGRPAJAX&GroupId="+ document.forms[0].strGroupCmbId[document.forms[0].strGroupCmbId.selectedIndex].value + "&storeId="+ document.forms[0].strStoreId.value;
      
	   ajaxFunction(url, "9");
	   
	}
	else
	{
		alert("Please Select Group Name!!!");
		return false;
	}
}


function getItemBrandDetails() {
	
	if(document.forms[0].strItemBrandId.value != 0){	
			
			var mode = "BRANDDETAILS";
			var url = "DrugInventoryTransCNT.cnt?hmode="+mode+"&strItemBrandId="
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

function getGroupName()
{
	if (document.forms[0].strItemId.value != '0') 
	{
		var mode = "GETGROUPNAME";
		var url = "DrugInventoryTransCNT.cnt?hmode="+mode+ "&strItemId="+ document.forms[0].strItemId.value;
							
		ajaxFunction(url, "10");

	}
	else 
	{
       alert("Please Select Generic Drug Name!!!");
       document.forms[0].strItemId.focus();
       return false;	
	}
}

function ajaxExistingBatchInStock() 
{
  if(document.forms[0].strExistingBatchId.value=='0' &&  document.forms[0].strBatchNo.value!='')
  {	
	var mode = "EXISTINGBATCHINSTCOK";
	
	var url = "DrugInventoryTransCNT.cnt?hmode="+mode+"&strItemBrandId="+ document.forms[0].strItemBrandId.value + "&storeId="+ document.forms[0].strStoreId.value+ "&strItemId="+ document.forms[0].strItemId.value+"&strGroupId="+ document.forms[0].strGroupId.value+"&strBatchNo="+ document.forms[0].strBatchNo.value;
   
	ajaxFunction(url, "11");
  }	
}

function getManufecture(mode) {
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();
}

function BatchName() 
{
  if(document.forms[0].strItemBrandId.value!='0')
  {	
	var mode = "EXISTINGBATCH";
	
	var url = "DrugInventoryTransCNT.cnt?hmode="+mode
	+"&strItemBrandId="+ (document.forms[0].strItemBrandId.value) 
	+ "&storeId="+ document.forms[0].strStoreId.value
	+ "&strItemId=0";
   
	ajaxFunction(url, "77");
  }	
}

function enable()
{
clearFormFields();

    if(document.forms[0].strExistingBatchId.value!='0')
    {
 
 	   var batchVal = document.forms[0].strExistingBatchId.value; // batch#activeQty#quarantineQty#inActiveQty#expiryDate#mfgDate
        document.forms[0].strBatchNo.disabled = true;
        
        document.forms[0].strBatchNo.value = batchVal.split("#")[0];
        document.forms[0].strActiveQty.value = batchVal.split("#")[1];
        document.forms[0].strQuarantineQty.value = batchVal.split("#")[2];
        document.forms[0].strInActiveQty.value = batchVal.split("#")[3];
        document.forms[0].strExpiryDate.value = batchVal.split("#")[4];
        document.forms[0].strManufactureDate.value = batchVal.split("#")[5];
        
        document.forms[0].strExistingBatchFlg.value = '0';
        
        document.getElementById("newBatchDivId").style.display = 'none';       
        document.getElementById("oldBatchDivId").style.display = '';
         
    }
    else
    {
       document.forms[0].strBatchNo.disabled = false;
       document.forms[0].strBatchNo.value ='';
       document.forms[0].strExistingBatchFlg.value = '1';
       
       document.getElementById("newBatchDivId").style.display = '';       
       document.getElementById("oldBatchDivId").style.display = 'none';
    }  

}
function getAjaxResponse(res, mode) {

	var objVal;
	if (mode == "1") {

		objVal = document.getElementById("ItemNameId");
		objVal.innerHTML = "<select name ='strItemId' class='comboMax' onChange = 'ajaxItemBrandName()' >"
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
		objVal.innerHTML = "<select name ='strUnitRateID' class='comboNormal' onChange='getIssueRateUnitCombo();' >"
				+ res + "</select>";
		document.getElementById("UnitRateID1").innerHTML = "<select name ='strUnitSaleID' class='comboNormal' onChange='' disabled='disabled' >"
				+ res + "</select>";
		document.getElementById("freeItemUnit").innerHTML = "<select name ='strInHandQuantityUnitID' class='comboNormal' onChange='CalculateDrugCost();' >"
				+ res + "</select>";
			
		document.getElementById("freeItemUnitValue").innerHTML = "<select name ='strFreeItemQuantityUnitID' class='comboNormal' onChange='' >"
				+ res + "</select>";		
	}

	else if (mode == "4") 
	{
       
		var temp = res.split('^');

		document.forms[0].isBatchReq.value = temp[0];

		if (temp[0] == '1') 
		{

			document.getElementById("batchNoDivId").innerHTML = "<font color='red'>*</font>Batch No.";
		} 
		else 
		{

			document.getElementById("batchNoDivId").innerHTML = "Batch No.";
		}

		document.forms[0].isExpirtReq.value = temp[2];

		if (temp[2] == '1') 
		{

			document.getElementById("expiryDateDivId").innerHTML = "<font color='red'>*</font>Expiry Date";
		} 
		else 
		{

			document.getElementById("expiryDateDivId").innerHTML = "Expiry Date";
		}
       
		ajaxItemBrandName1();
       	
		
	}

	if (mode == '5')
	{

		document.getElementById("manufDivId").innerHTML = "<select class='comboMax' name='strManufactureId' >"+ res + "</select>";

        getItemBrandDetails();

	}
	
	if (mode == '55')
	{

		document.getElementById("manufDivId").innerHTML = "<select class='comboMax' name='strManufactureId' >"+ res + "</select>";

        BatchName();

	}
	
	if (mode == '77')
	{
		document.getElementById("ExistingBatchId").innerHTML = "<select class='comboNormal' name='strExistingBatchId' onChange='enable();'>"+ res + "</select>";
             
	}
	if (mode == '6') 
	{
	
	     document.forms[0].strSalePrice.disabled = "false";
         document.forms[0].strRate.value ='0';
		 var brandDtls = res.split("^");
		 document.forms[0].strRegFlag.value = brandDtls[0];
		 document.forms[0].strConfigIssueRate.value = brandDtls[4];
		 document.forms[0].strQcTypeFlg.value=brandDtls[5];
		 //alert(document.forms[0].strQcTypeFlg.value);
		 if(document.forms[0].strQcTypeFlg.value=='0')
		 {
		 	document.getElementById("strStockStatusDiv").innerHTML ="<select name='strStockStatus' class='comboNormal'>" +
		 			                                                   "<option title='Select Value' value='0'>Select Value</option>" +
		 			                                                   "<option title='Installation Pending' value='14'>Installation Pending</option>" +
		 			                                                   "<option title='Breakage' value='12'>Breakage</option>" +
		 			                                                   "<option title='Condemned' value='13'>Condemned</option>" +
		 			                                                   "<option title='Active' selected='selected' value='10'>Active</option>" +
		 			                                                   "<option title='In-Active' value='11'>In-Active</option></select>";
		 } 		 			                                                   
		 else
		 {
		 	document.getElementById("strStockStatusDiv").innerHTML ="<select name='strStockStatus' class='comboNormal'>" +
		 			                                                   "<option title='Select Value' value='0'>Select Value</option>" +
		 			                                                   "<option title='Installation Pending' value='14'>Installation Pending</option>" +
		 			                                                   "<option title='Breakage' value='12'>Breakage</option>" +
		 			                                                   "<option title='Condemned' value='13'>Condemned</option>" +
		 			                                                   "<option title='Active' selected='selected' value='10'>Active</option>" +
		 			                                                   "<option title='In-Active' value='11'>In-Active</option>" +
		 			                                                   "<option title='Quadrate' value='15'>Quadrate</option></select>";
		 }
		 
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
		 	
		 		 	
		 }else{
		 	
		 	document.getElementById("manfNotMandatoryDivId").style.display = "block";
		 	document.getElementById("manfMandatoryDivId").style.display = "none";
		 	
		 	document.getElementById("specNotMandatoryDivId").style.display = "block";
		 	document.getElementById("specMandatoryDivId").style.display = "none";
		 		 	
		 	document.forms[0].strManufactureId.value = brandDtls[3];	
		 	document.forms[0].strManufactureId.disabled = true; 	
		 	document.forms[0].strItemSpecification.value = brandDtls[1];	 	
			document.forms[0].strItemSpecification.disabled = true; 			 			 	
		 }
		 ajaxExistingBatchName('EXISTINGBATCH');
	}
	
	if (mode == '7')
	{

		document.getElementById("ExistingBatchId").innerHTML = "<select class='comboNormal' name='strExistingBatchId' onChange='enableNewBatch();'>"+ res + "</select>";
        if(document.forms[0].combo[1].value=='0')
	    {
          getGroupName();
	    }  
       
	}
	if (mode == '8')
	{
		     //   1              2          3            4            5                 6             7            8             9
		     // Store Name + Grp Name +Sub Grp Name + Item name + Item Brand Name + Supplier Name + Batch No +  Expiry Date + Manu Factrer Date
			 //   10            11                        12                 13       14              15               16          17                  
			 // In Hand Qty + In Hand Qty Unit Name + In Hand Qty Unit ID + Rate + Rate Unit Name + Rate Unit Id + Sale Price + Sale Price Unit Name + 
		 	 //    18               19      20          21               22              23            24              25              26                    
			 // Sale Price Unit + Po No + Po Date + Supplied by Id + Received Date + Currency Id +  Currency Value + Invoice No + Invoice Date +
			 //     27               28              29
			 // Specefication  + Manufactrere Id + Rack No
			 
			 
		document.forms[0].strExistingBatchFlg.value = '1';
	    document.forms[0].strExistingBatchDetails.value = res;
		var tmp = res.split("^");
		
		document.forms[0].strStockStatus.disabled = true;
		document.getElementById("manufactDateTextDiv").style.display = "none";
		document.getElementById("manufactDateFieldDiv").innerHTML = tmp[8];
		
		document.forms[0].strInHandQuantity.value = tmp[9];		
		
		document.forms[0].strRate.value = tmp[12];
		document.forms[0].strSalePrice.value = tmp[15];
		document.forms[0].strRate.disabled = "true";
				
		
		document.getElementById("expDateTextDiv").style.display = "none";
		document.getElementById("expDateFieldDiv").innerHTML =tmp[7];
		
		
		document.getElementById("freeItemUnit").style.display = "none";
		document.getElementById("freeItemUnitField").innerHTML =tmp[10];
		
		document.getElementById("rackNoTextDiv").style.display = "none";
		document.getElementById("rackNoFieldDiv").innerHTML =tmp[28];
		
		document.forms[0].strCurrencyCode.disabled = true;
		
		document.getElementById("UnitRateID").style.display = "none";
		document.getElementById("UnitRateFieldID").innerHTML =tmp[13];
		
		document.getElementById("UnitRateID1").style.display = "none";
		document.getElementById("UnitRateFieldID1").innerHTML =tmp[13];
		
		document.getElementById("poTextDiv").style.display = "none";
		document.getElementById("poFieldDiv").innerHTML =tmp[18];
		
		document.getElementById("poDateTextDiv").style.display = "none";
		document.getElementById("poDateFieldDiv").innerHTML =tmp[19];
		
		
		document.getElementById("billTextDiv").style.display = "none";
		document.getElementById("billFieldDiv").innerHTML =tmp[24];

		document.getElementById("billDateTextDiv").style.display = "none";
		document.getElementById("billDateFieldDiv").innerHTML =tmp[25];
		
		document.getElementById("receiveDateTextDiv").style.display = "none";
		document.getElementById("receiveDateFieldDiv").innerHTML =tmp[21];
		
		document.getElementById("supplyByTextDiv").style.display = "none";
		document.getElementById("supplyByFieldDiv").innerHTML =tmp[5];

		
		
		
		
	}
	if (mode == '9')
	{
        var tmp = res.split("@@");
		objVal = document.getElementById("SubGroupNameDiv");
		objVal.innerHTML = "<select name ='strSubGroupId' class='comboMax'   onChange = 'ajaxItemName(\"ITEMNAME\")' >"	+ tmp[0] + "</select>";
	
        objVal1 = document.getElementById("ItemNameId");
		objVal1.innerHTML = "<select name ='strItemId' class='comboMax' onChange='ajaxItemBrandName();' >" + tmp[1] + "</select>";

	}
	
	if (mode == '10')
	{
        var tmp = res.split("@@");
		document.forms[0].strGroupId.value = tmp[0];
		document.forms[0].strGroupName.value = tmp[1];
	}
	
	if (mode == '11')
	{
		
       	document.forms[0].strBatchExistInStockFlg.value = res;
       	
       	/**
			 		 * Calculate Total Cost of Item
			 		 */
			 		 
			 		 var  rateObj              = document.forms[0].strRate.value;	   
			 		 var  rate_unit_base_value = document.forms[0].strUnitRateID.value.split("^")[1];
					 var  qtyObj               = document.forms[0].strInHandQuantity.value;
					 var  qty_unit_base_value  = document.forms[0].strInHandQuantityUnitID.value.split("^")[1];	
					 //alert("qty:::"+qtyObj+"::Rate:::"+rateObj+"::rate_unit_base_value:::"+rate_unit_base_value+"::qty_unit_base_value::"+qty_unit_base_value);	
       				 if(document.forms[0].strUnitRateID.value!='0' && document.forms[0].strInHandQuantityUnitID.value!='0')  
       				 {  				
						 
						 var total = parseFloat("0.00");
						 var qty = parseFloat("0.00");
						 var rate = parseFloat("0.00");
						 
						  qty    = qtyObj;	
						  rate   = rateObj;
								 
					
						 if(isNaN(rate) || rate=="") rate = "0";
						 if(isNaN(qty)  || qty=="") qty = "0";
						 if(qty=='0')		
						 {
						  qty_unit_base_value  = '0';	
						  rate_unit_base_value = '0'; 
						  total = parseFloat(qty * qty_unit_base_value * rate);
						 }
						 else
						 {
						   total = parseFloat(qty * qty_unit_base_value * (rate /rate_unit_base_value));
						 } 
						 document.getElementById("strDrugTotCost").value = roundValue(total,2);
						 //alert("IInd Case::::"+roundValue(total,2));
       				 }       				 
			 		//NVL(HSTNUM_PURCHASE_RATE,''0'')/Mms_Mst.getUnitBaseValue(HSTNUM_RATE_UNITID,GNUM_HOSPITAL_CODE))*NVL( (HSTNUM_RECIEVED_QTY - HSTNUM_RETURNED_QTY)
			 		/**
			 		 * Total Cost Calculation End
			 		 */
		
	}
	
	
}
function CalculateDrugCost()
{
		           /**
			 		 * Calculate Total Cost of Item
			 		 */
			 		 
			 		 var  rateObj              = document.forms[0].strRate.value;	   
			 		 var  rate_unit_base_value = document.forms[0].strUnitRateID.value.split("^")[1];
					 var  qtyObj               = document.forms[0].strInHandQuantity.value;
					 var  qty_unit_base_value  = document.forms[0].strInHandQuantityUnitID.value.split("^")[1];	
					 //alert("qty:::"+qtyObj+"::Rate:::"+rateObj+"::rate_unit_base_value:::"+rate_unit_base_value+"::qty_unit_base_value::"+qty_unit_base_value);	
       				 if(document.forms[0].strUnitRateID.value!='0' && document.forms[0].strInHandQuantityUnitID.value!='0')  
       				 {  				
						 
						 var total = parseFloat("0.00");
						 var qty = parseFloat("0.00");
						 var rate = parseFloat("0.00");
						 
						  qty    = qtyObj;	
						  rate   = rateObj;
								 
					
						 if(isNaN(rate) || rate=="") rate = "0";
						 if(isNaN(qty)  || qty=="") qty = "0";
						 if(qty=='0')		
						 {
						  qty_unit_base_value  = '0';	
						  rate_unit_base_value = '0'; 
						  total = parseFloat(qty * qty_unit_base_value * rate);
						 }
						 else
						 {
						   total = parseFloat(qty * qty_unit_base_value * (rate /rate_unit_base_value));
						 } 
						 document.getElementById("strDrugTotCost").value = roundValue(total,2);
						//alert("IInd Case::::"+roundValue(total,2));
       				 }       				 
			 		//NVL(HSTNUM_PURCHASE_RATE,''0'')/Mms_Mst.getUnitBaseValue(HSTNUM_RATE_UNITID,GNUM_HOSPITAL_CODE))*NVL( (HSTNUM_RECIEVED_QTY - HSTNUM_RETURNED_QTY)
			 		/**
			 		 * Total Cost Calculation End
			 		 */
}
function enableNewBatch()
{
	 
		if(document.forms[0].strExistingBatchId.value=='0')
        {
        	document.forms[0].strExistingBatchFlg.value = '0';
        	document.forms[0].strBatchNo.value = '';
        	document.forms[0].strBatchNo.disabled = false;
        	document.forms[0].strStockStatus.disabled = false;
        	
        	document.getElementById("manufactDateTextDiv").style.display = "block";
			document.getElementById("manufactDateFieldDiv").innerHTML = "";
			
			document.getElementById("expDateTextDiv").style.display = "block";
			document.getElementById("expDateFieldDiv").innerHTML ="";
			
			document.forms[0].strInHandQuantity.value = "0.00";		
		
		    document.forms[0].strRate.value = "0.00";
		    document.forms[0].strSalePrice.value = "0.00";
		    document.forms[0].strRate.disabled = false;
			
			document.getElementById("freeItemUnit").style.display = "block";
			document.getElementById("freeItemUnitField").innerHTML ="";
			
			document.getElementById("rackNoTextDiv").style.display = "block";
			document.getElementById("rackNoFieldDiv").innerHTML ="";
			
			document.forms[0].strCurrencyCode.disabled = false;
			
			document.getElementById("UnitRateID").style.display= "block";
			document.getElementById("UnitRateFieldID").innerHTML ="";
			
			document.getElementById("UnitRateID1").style.display = "block";
			document.getElementById("UnitRateFieldID1").innerHTML ="";
			
			document.getElementById("poTextDiv").style.display= "block";
			document.getElementById("poFieldDiv").innerHTML ="";
			
			document.getElementById("poDateTextDiv").style.display = "block";
			document.getElementById("poDateFieldDiv").innerHTML ="";
			
			
			document.getElementById("billTextDiv").style.display = "block";
			document.getElementById("billFieldDiv").innerHTML ="";
	
			document.getElementById("billDateTextDiv").style.display = "block";
			document.getElementById("billDateFieldDiv").innerHTML ="";
			
			document.getElementById("receiveDateTextDiv").style.display = "block";
			document.getElementById("receiveDateFieldDiv").innerHTML ="";
			
			document.getElementById("supplyByTextDiv").style.display = "block";
			document.getElementById("supplyByFieldDiv").innerHTML = "";
        }
        else
        {
        	document.forms[0].strBatchNo.disabled = true;
        	document.forms[0].strBatchNo.value = document.forms[0].strExistingBatchId[document.forms[0].strExistingBatchId.selectedIndex].text;
        	ajaxExistingBatchDtl(); 
        	
        }
	
}
function ajaxExistingBatchDtl() 
{
	var mode = "EXISTINGBATCHDTL";
	var url = "DrugInventoryTransCNT.cnt?hmode="+mode+"&strItemBrandId="+ document.forms[0].strItemBrandId.value + "&storeId="+ document.forms[0].strStoreId.value+ "&strItemId="+ document.forms[0].strItemId.value+ "&strExistingBatchId="+ document.forms[0].strExistingBatchId.value;
	ajaxFunction(url, "8");
}




	/**
	 * addFreeItems
	  
	 */
	 function addFreeItems() {
	 	
	 		var mode 		= "1";
	 		var isBatchReq  = document.forms[0].isBatchReq.value;
	 		var isExpDtReq  = document.forms[0].isExpirtReq.value;
	 	
	 	getItemOtherDetailsView(mode, isBatchReq , isExpDtReq , '1' , "drugInventoryTransBean");
	 	
	 }
	 
	 
	 function calcIssueRate()
	 {
	 	if(document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value!='0')
	 	{
			 	var         isseRate = parseFloat("0");
			 	var     purchaseRate = document.forms[0].strRate.value;
			 	var confgIsseRateVal = document.forms[0].strConfigIssueRate.value;
			 	
			 	
			 	if(document.forms[0].strIssueRateConfigFlg.value=='1')
			 	{
			 		var result1 = (Math.abs(purchaseRate) * confgIsseRateVal) / Math.pow(10, 2);
			 	    var cost = roundValue(result1,2);
			 	
			 	    document.forms[0].strSalePrice.value = cost;
			 		document.forms[0].strSalePrice.disabled = "true";
			 		CalculateDrugCost();
			 					 					 		
			 	}
			 	else
			 	{
			 		document.forms[0].strSalePrice.value = purchaseRate;
			 		document.forms[0].strSalePrice.disabled = "false";
			 		CalculateDrugCost();
			 	}
	 	}
	 	else
	 	{
	 		alert("Please Select Drug Name First!!!");
	 		return false;
	 	}
	 	
	 }
	
	
	function calcIssueRateOne()
	 {

	 	
			 	var         isseRate = parseFloat("0");
			 	var     purchaseRate = document.forms[0].strRate.value;
			 	var confgIsseRateVal = document.forms[0].strConfigIssueRate.value;
			 	
			 	if(document.forms[0].strIssueRateConfigFlg.value=='1')
			 	{
			 		var result1 = (Math.abs(purchaseRate) * confgIsseRateVal) / Math.pow(10, 2);
			 	    var cost = roundValue(result1,2);
			 	    document.forms[0].strSalePrice.value = cost;
			 		document.forms[0].strSalePrice.disabled = "true";
			 	}
			 	else
			 	{
			 		document.forms[0].strSalePrice.value = purchaseRate;
			 		document.forms[0].strSalePrice.disabled = "false";
			 	}
	 	
	 	
	 }

	 function calcIssueRateTwo()
	 {
	 	        
	 	        document.forms[0].strUnitSaleID.disabled = true;
 	
			 	var         isseRate = parseFloat("0");
			 	var     purchaseRate = document.forms[0].strRateOnLoad.value;
			 	var confgIsseRateVal = document.forms[0].strConfigIssueRate.value;
			 	
			 		 	
			 	//var result1 = (Math.abs(purchaseRate) * confgIsseRateVal) / Math.pow(10, 2);
			 	//alert("Final Result:::"+result1);
			 	//var cost = roundValue(result1,2);
			 	//document.forms[0].strSalePrice.value = cost;
			 	if(document.forms[0].strIssueRateConfigFlg.value=='1')
			 	{
			 		document.forms[0].strSalePrice.disabled = "true";
			 	}
			 	else
			 	{
			 		document.forms[0].strSalePrice.value = purchaseRate;
			 		document.forms[0].strSalePrice.disabled = "false";
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
		/**
			 		 * Calculate Total Cost of Item
			 		 */
			 		 
			 		 var  rateObj              = document.forms[0].strRate.value;	   
			 		 var  rate_unit_base_value = document.forms[0].strUnitRateID.value.split("^")[1];
					 var  qtyObj               = document.forms[0].strInHandQuantity.value;
					 var  qty_unit_base_value  = document.forms[0].strInHandQuantityUnitID.value.split("^")[1];	
					 //alert("qty:::"+qtyObj+"::Rate:::"+rateObj+"::rate_unit_base_value:::"+rate_unit_base_value+"::qty_unit_base_value::"+qty_unit_base_value);	
       				 if(rate_unit_base_value!='0' && qty_unit_base_value!='0')  
       				 {  				
						 
						 var total = parseFloat("0.00");
						 var qty = parseFloat("0.00");
						 var rate = parseFloat("0.00");
						 
						  qty    = qtyObj;	
						  rate   = rateObj;
								 
					
						 if(isNaN(rate) || rate=="") rate = "0";
						 if(isNaN(qty)  || qty=="") qty = "0";
						 if(qty=='0')		
						 {
						  qty_unit_base_value  = '0';	
						  rate_unit_base_value = '0'; 
						  total = parseFloat(qty * qty_unit_base_value * rate);
						 }
						 else
						 {
						   total = parseFloat(qty * qty_unit_base_value * (rate /rate_unit_base_value));
						 } 
						 document.getElementById("strDrugTotCost").value =  roundValue(total,2);
						 //alert(roundValue(total,2));
       				 }
       				 else
       				 {
       				 	alert("Please Select In-Hand Quantity\Purchase Rate Unit");
       				 	return false;
       				 }
			 		//NVL(HSTNUM_PURCHASE_RATE,''0'')/Mms_Mst.getUnitBaseValue(HSTNUM_RATE_UNITID,GNUM_HOSPITAL_CODE))*NVL( (HSTNUM_RECIEVED_QTY - HSTNUM_RETURNED_QTY)
			 		/**
			 		 * Total Cost Calculation End
			 		 */
}

function clearFormFields()
{

		document.forms[0].strBatchNo.value = '';
        document.forms[0].strActiveQty.value = '';
        document.forms[0].strQuarantineQty.value = '';
        document.forms[0].strInActiveQty.value = '';
        document.forms[0].strExpiryDate.value = '';
        document.forms[0].strManufactureDate.value = '';
}        
        