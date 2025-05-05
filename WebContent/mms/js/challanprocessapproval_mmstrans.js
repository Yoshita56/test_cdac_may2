function calcIssueRateTwo()
	 {
	 	        document.forms[0].strSalePriceUnitId.disabled = true;
			 	var  isseRate = parseFloat("0");
			 	var  purchaseRate = document.forms[0].strRate.value;
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
			 		document.forms[0].strSalePrice.value = purchaseRate.split("/")[0];
			 		document.forms[0].strSalePrice.disabled = "false";
			 	}
	 	
	 	
	 }


	/**
	 * showItemDtls
	 * @param {Object} parentObj 
	 * @param {String} manfName
	 * @param {String} rateDtls
	 * @param {String} itemName
	 */
	 function showItemDtls(parentObj,manfName,rateDtls , itemName) {
	 	
	 	
	 	document.getElementById("itemDtlsTitleDivId").innerHTML = itemName+" - Item Details";
	 	document.getElementById("itemManufDivId").innerHTML = manfName;
	 	document.getElementById("itemRateDivId").innerHTML = rateDtls;
	 	
	 	display_popup_menu(parentObj, "itemDtlsDivId" , "","");
	 	
	 }
	 
	 
	 /**
	 * showBalQtyDtls
	 * @param {Object} parentObj 
	 * @param {String} ordQty
	 * @param {String} recQty
	 * @param {String} itemName
	 */
	 function showBalQtyDtls(parentObj,ordQty,recQty , itemName) {
	 	
	 	document.getElementById("balQtyTitleDivId").innerHTML = itemName+" -: Balance Qty.";
	 	document.getElementById("ordQtyDivId").innerHTML = ordQty;
	 	document.getElementById("recQtyDivId").innerHTML = recQty;
	 	
	 	display_popup_menu(parentObj, "balQtyDtlsDivId" , "","");
	 	
	 }
	 
	 
	 
	 
/**

	JS Function used in committetype
**/
function getMemberDtl(mode)
{
	var mode=mode
	var url="ChallanProcessTransCNT.cnt?hmode="+mode+"&committeType="+document.forms[0].strCommitteeType[document.forms[0].strCommitteeType.selectedIndex].value+"&itemCategNo="+document.forms[0].strItemCategoryId.value;
	ajaxFunction(url,"2");
}
	 
	 
	 /**
	  * getScheduleDtls
	  * @param {object} cmbObj 
	  */
	  function getScheduleDtls(cmbObj) {
	  	
	  	
	  	var mode = "GETSCHEDULEDTLS";

		var url = "ChallanProcessTransCNT.cnt?hmode=" + mode + "&strScheduleDtls="+cmbObj.value+"&strPoNo="+
								document.forms[0].strPoNo.value+"&strPoStoreId="+document.forms[0].strPoStoreId.value;
		ajaxFunction(url, "1");
	  	
	  }
	  
	  
	  
function getAjaxResponse(res, mode) {

	var err = document.getElementById("errMsg");
	var temp = res.split("####");
	if(temp[0] == "ERROR")
	{
		err.innerHTML = temp[1];
		return;
	}

	var objVal;
	if (mode == "1") {

		objVal = document.getElementById("scheduleDtlsDivId");
		objVal.innerHTML = res;
	}
					
	if(mode=="2"){				
	
		document.getElementById("memberDtlInner").innerHTML=res;	
		
	}

	if(mode=="3"){				
	
		document.getElementById("balQtyDtlsDivId").innerHTML=res;	
		display_popup_menu(gblParentObj, "balQtyDtlsDivId" , "","");
							
	}
	if(mode=="4")
	{					
		document.getElementById("receivedItemDtlsDivId").innerHTML=res;
		document.getElementById("verifiedItemDtlsDivId").style.display = "none";						
	}
	if(mode=="5")
	{					
		document.getElementById("verifiedItemDtlsDivId").innerHTML=res;	
		document.getElementById("verifiedItemDtlsDivId").style.display = "block";					
	}
}
	  
	  
	 
	 /**
	  * validation 
	  */
function validation() {
	  	
	  	var errContent = document.getElementById("errMsg").innerHTML ;
	  	
	  	if(errContent.length > 0){
	  		
	  		alert("Process Cannot be Saved due to '"+errContent+"'");
	  		return false;
	  	}
	  	
	  	var hisValidator = new HISValidator("challanProcessBean");
	  	
	  	if(document.forms[0].strPoTypeId.value == '24'){
	  		
	  		hisValidator.addValidation("strAwbNo",  "req", "AWB No. is a Mandatory Field");
	  		hisValidator.addValidation("strBeNo",   "req", "BE No. is a Mandatory Field");
	  		hisValidator.addValidation("strBeDate", "req", "BE Date is a Mandatory Field");
	  		
	  	}
	  	
	  	//hisValidator.addValidation("strNoOfPackets", "req", "No. of Packets is a Mandatory Field");  Commented By Implementation Team
	  	
	  	
	  	hisValidator.addValidation("strSupplierReceiptNo",   "req", "Challan Receipt No. is a Mandatory Field");
	  	hisValidator.addValidation("strDeliveryMode",   "dontselect=0", "Please Select a Delivery Mode");  	  		  	
	  	hisValidator.addValidation("strReceivedQty" ,   "req" , "Received Quantity is a Mandatory Field");
	  	hisValidator.addValidation("strReceivedUnitId", "dontselect=0", "Please Select a Unit Name ");
 		hisValidator.addValidation("strScheduleNo", "dontselect=0", "Please Select a Schedule No.");
		hisValidator.addValidation("strReceivedComboBy","dontselect=0","Please Select a Value from Received By Combo" );
		hisValidator.addValidation("strReceivedBy", "req", "Name of the Receiver is a Mandatory Field");
		hisValidator.addValidation("strRemarks", "req", "Remarks is a Mandatory Field");
		hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks cannot contains more than 100 Characters");
		hisValidator.addValidation("strPackageWeight", "numltet=9999.99", "Weight cannot be more than 9999.99 kg");
		  	
	  	var retVal = hisValidator.validate();
	
		hisValidator.clearAllValidations();

		if (retVal) {
			document.forms[0].hmode.value = "INSERT";
			document.forms[0].submit();
		} else {
			return false;
		}
	  	
	  } 
	  
	  
	  /**
	   * verifyValidation 
	   */
	   function verifyValidation() 
	   {
	   	
	   	document.forms[0].strVerifyFlag.value = 0;
	   	
	   		var hisValidator = new HISValidator("challanProcessBean");
	   		   		
	   		   		
	   	if (document.forms[0].isBatchReq != null && document.forms[0].isBatchReq.value == '1') 
	   	{
		
			hisValidator.addValidation("strBatchNo", "req","Batch No. is a Mandatory Field");
		}
	//alert("isExpirtReq :"+document.forms[0].isExpirtReq.value);
		if (document.forms[0].isExpirtReq != null && document.forms[0].isExpirtReq.value == '1')
		{
				hisValidator.addValidation("strExpiryDate", "req","Expiry Date is a Mandatory Field");
				hisValidator.addValidation("strExpiryDate", "dtgtet="+document.forms[0].strManufactureDate.value, "Verified Date should be greater than or equal Manufacture Date." );
				hisValidator.addValidation("strExpiryDate", "dtgtet="+document.forms[0].strCurrentDate.value, "Verified Date Must be greater than or equal to Current Date.." );
		}
	   
	   	hisValidator.addValidation("strAcceptedQuantity", "req", "Accepted Quantity is a Mandatory Field");
	   	hisValidator.addValidation("strAcceptedQuantityUnitId", "dontselect=0", "Please Select a Accepted Quantity Unit");
	   	
	   	var rejQty = document.forms[0].strRejectedQuantity.value;
	   	
	   	if(rejQty.length == 0)rejQty = "0";
	   	
	   	var rejQtyVal = parseFloat(rejQty);
	   	
	   	if(rejQtyVal > 0)
	   	{
	   		
	   		hisValidator.addValidation("strRejectedQuantityUnitId", "dontselect=0", "Please Select a Rejected Quantity Unit");
	   	}
	   		
	   	var brkQty = document.forms[0].strBreakageQuantity.value;	   	
	   	if(brkQty.length == 0)brkQty = "0";	   	
	   	var brkQtyVal = parseFloat(brkQty);	   	
	   	if(brkQtyVal > 0)
	   	{
	   		
	   		hisValidator.addValidation("strBreakageQuantityUnitId", "dontselect=0", "Please Select a Breakage Quantity Unit");
	   	}	   		   	
	   	var excQty = document.forms[0].strExcessQty.value;
	   	
	   	if(excQty.length == 0)excQty = "0";
	   	
	   	var excQtyVal = parseFloat(excQty);
	   	
	   	if(excQtyVal > 0)
	   	{
	   		
	   		hisValidator.addValidation("strExcessQtyUnitId", "dontselect=0", "Please Select a Excess Quantity Unit");
	   	}
	   	
	   	var excessUnit = document.forms[0].strExcessQtyUnitId.value;
	   	var excessUnitBase = parseFloat("0"); 
	   	
	   	if(excessUnit.length > 1)
	   	{
	   		excessUnitBase = parseFloat(excessUnit.split('^')[1]);
	   	}
	   	excQtyVal = excQtyVal * excessUnitBase;
	   	
	   	
	   	
	   	var rejUnit = document.forms[0].strRejectedQuantityUnitId.value;
	   	var rejUnitBase = parseFloat("0"); 
	   	
	   	if(rejUnit.length > 1)
	   	{
	   		
	   		rejUnitBase = parseFloat(rejUnit.split('^')[1]);
	   		
	   	}
	   	
	   		var brkUnit = document.forms[0].strBreakageQuantityUnitId.value;
	   	var brkUnitBase = parseFloat("0"); 
	   	
	   	if(brkUnit.length > 1)
	   	{
	   		
	   		brkUnitBase = parseFloat(brkUnit.split('^')[1]);
	   		
	   	}
	   	
	   		var accUnit = document.forms[0].strAcceptedQuantityUnitId.value;
	   	var accUnitBase = parseFloat("0"); 
	   	
	   	if(accUnit.length > 1)
	   	{
	   		
	   		accUnitBase = parseFloat(accUnit.split('^')[1]);
	   		
	   	}
	   	
	   	
	   	var verfVal = parseFloat(document.forms[0].strVerifiedQuantityInBaseVal.value);
	   	var rejVal = rejQtyVal * rejUnitBase;
	   	var brkVal = brkQtyVal * brkUnitBase;
	   	var accVal = parseFloat(document.forms[0].strAcceptedQuantity.value) * accUnitBase;
	   	
	   	
	   		/************************New Condition Add wrf of CR 28-Feb-2013*********************/
		var balQtyVal = parseFloat(document.forms[0].strBalanceQuantity.value) * parseFloat(document.forms[0].strBalanceQuantityUnitBaseValue.value);   	
		     	if(excQtyVal > 0)
		   		{
		   			
		   			var sumVar1 = accVal + rejVal + brkVal;
		   			
		   			
		   			if(sumVar1 != (balQtyVal-verfVal) )
		   			{
		   				alert("Excess Qty Can't be greater than Zero!!!!");
		   				return false;
		   			}
		   		}
		   	
		   	/********************************************************************************/
		   	
	   	
	   	var totVerfVal = verfVal + accVal + rejVal + brkVal;
	    		   	
	   	var balQtyVal = parseFloat(document.forms[0].strBalanceQuantity.value) * parseFloat(document.forms[0].strBalanceQuantityUnitBaseValue.value);
	    	
	    	
	        if((accVal + verfVal) < balQtyVal)
		   	{
		   		if(excQtyVal > 0)
		   		{
		   			alert("Excess Qty can not be greater than zero if total accepted qty is less than balance qty !!");
		   			return false;
		   		}
		   	}
		   	
		   	if((accVal + verfVal) == balQtyVal)
		   	{
		   		if(rejVal > 0)
		   		{
		   			alert("Rejected Qty can not be greater than zero if total accepted qty is equal to balance qty, enter in excess qty !!");
		   			return false;
		   		}
		   		
		   		if(brkVal > 0)
		   		{
		   			alert("Breakage Qty can not be greater than zero if total accepted qty is equal to balance qty, enter in excess qty !!");
		   			return false;
		   		}
		   	}	
	    	
	    	
	   	if(totVerfVal > balQtyVal){
	   		
	   		alert("Sum of Verified, Accepted, Rejected and Breakage Quantity should not be Greater than Balance Quantity (Order)");
	   		return false;
	   	}
	   	
	   	
	   	//below line is commented by Adil Wasi.	Bug No:17494	   	
	   	//hisValidator.addValidation("strSalePrice", "req", "Sales Price is a Mandatory Field");
	   	
	   	hisValidator.addValidation("strSalePriceUnitId", "dontselect=0", "Please Select a Sales Price Unit");
	   			
	   	/*
	   	if(document.getElementsByName("strWarrantyDate").length > 0)
	   	{
	   		
	   			hisValidator.addValidation("strWarrantyDate", "req","Warranty Date is a Mandatory Field");
			
			hisValidator.addValidation("strWarantyManufacturer", "dontselect=0","Please Select a Manufacture");
			
			hisValidator.addValidation("strWarrantyUpTo", "req","Warranty Upto is a Mandatory Field");
			hisValidator.addValidation("strWarrantyUpToUnit", "dontselect=0","Please Select a Unit");
			
			hisValidator.addValidation("strWarrantyRemarks", "maxlen=100","Remarks cannot be greater than 100 Characters");
				   		
	   	}	
	   		
	   	if(document.getElementsByName("strInstallStartDate").length > 0){
	   		
		   	hisValidator.addValidation("strInstallStartDate", "req","Installation Start Date is a Mandatory Field");
			hisValidator.addValidation("strInstallEndDate", "req","Installation End Date is a Mandatory Field");
			hisValidator.addValidation("strInstallStatus", "dontselect=0","Please Select an Installation Status");
			
			hisValidator.addValidation("strInstallBy", "req","Install By is a Mandatory Field");
			hisValidator.addValidation("strInstallerContactNo", "req","Installer Contact No. is a Mandatory Field");hisValidator.addValidation("strInstallEndDate", "req","Installation End Date is a Mandatory Field");
			
		   	}
	   		*/	   		
	   	hisValidator.addValidation("strCommitteeType", "dontselect=0", "Please Select a Committee Type");	
	   	hisValidator.addValidation("strRemarks", "req", "Remarks is a Mandatory Field");
		hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks cannot contains more than 100 Characters");

	   	
	   		
		var retVal = hisValidator.validate();
	   	hisValidator.clearAllValidations();

		if (retVal) 
		{
			//alert("totVerfVal::"+totVerfVal+"::balQtyVal:::"+balQtyVal);
			if(totVerfVal != balQtyVal)
			{
				
				var flg = confirm("Whether All the Batch of the Selected Item(s) have been Received");
				if(flg) document.forms[0].strVerifyFlag.value = 1;
								
			}
			else
			{
				document.forms[0].strVerifyFlag.value = 1;
			}
			
			
			document.forms[0].hmode.value = "INSERTVERIFY";
			document.forms[0].submit();
		} else {
			return false;
		}
	  	
	   	
	   }
	  
	  
	  function checkQtyDtls(index, qtyName, unitName) 
	  {

		var unitObj = document.getElementById(unitName+""+index);
		var  qtyObj = document.getElementById(qtyName+""+index);

		
			var qtyDeceimal = qtyObj.value;

			var unitVal = unitObj.value.split('^')[2];

			if (qtyDeceimal.indexOf('.') > -1 && unitVal == '0') {

				alert("Qty must be an Integer ");
				qtyObj.value = '0';
								
				return false;
			}

		
	var itemDtlsObj =  document.getElementById("strItemDtls"+index);

	var balQty = itemDtlsObj.value.split('^')[2];
	var balQtyBaseUnitVal = itemDtlsObj.value.split('^')[10];

	var balQtyVal = parseInt(balQty) * parseInt(balQtyBaseUnitVal);


	var qty = "0";
	var unitBase = "0";

	if(qtyObj.value.length > 0) qty = parseInt(qtyObj.value,10);

	if(unitObj.value.length > 1) unitBase = unitObj.value.split('^')[1];
	
		
	var reqQtyVal = parseInt(qty) * parseInt(unitBase);
	
	
	if(reqQtyVal > balQtyVal){
		
		alert("Required Quantity Cannot be Greater than Balance Quantity");
		qtyObj.value = 0;
		unitObj.value = 0;
		return false;
	}

	return true;
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
	 * addFreeItems
	  
	 */
	 function addFreeItems() {
	 	
	 		var mode 		= "1";
	 		var isBatchReq  = document.forms[0].isBatchReq.value;
	 		var isExpDtReq  = document.forms[0].isExpirtReq.value;
	 	
	 	getItemOtherDetailsView(mode, isBatchReq , isExpDtReq , '1' , "challanProcessBean");
	 	
	 }
	


	/**
	 * addFreeItems
	  
	 */
	 function addPartItems() {
	 	
	 		var mode 		= "2";
	 		var isBatchReq  = document.forms[0].isBatchReq.value;
	 		var isExpDtReq  = document.forms[0].isExpirtReq.value;
	 	
	 	getItemOtherDetailsView(mode, isBatchReq , isExpDtReq , '2' , "challanProcessBean");
	 	
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
	 		
	 		var itemVal = document.forms[0].strGenericItemId.value;
	 		
	 		showPopup(parentObject , mode , catNo , itemVal[2]);
	 			
	 		}
	 			 		
	 		
	 		
	 	} else{
	 		
	 		popup('popUpDivId','100','250');
	 		
	 	}
	 	
	 	
	 }
		  
	  
	  
	  
function openDivPopu()
{
		if(document.getElementsByName("strCommitteeType")[0].value=="0")
   	 	{
   	 		alert("Please Select Committee Type")
   	 	}
 	 	else{
  			 popup('memberDtl' , '130','250');
  		}
}
function closePopUpDiv()
{
	hide_popup('memberDtl');
}
function clearData()
{
	var size=document.getElementsByName("strMemberRecommendation").length;
	if(size>1){
		for(var i=0;i<size;i++){
			document.getElementsByName("strMemberRecommendation")[i].value="";
		}
	}
	else{
		document.getElementsByName("strMemberRecommendation")[0].value="";
	}

}
	  
	  
	  
	/**
	 * getVerifiedQtyDtls
	  * @param {Object} parentObj 
	 */
	 function getVerifiedQtyDtls(parentObj) {
	 	
	 
	 	document.getElementById("verAccQtyDivId").innerHTML =  document.forms[0].strPreviousAcceptedQty.value + " + " +
	 															document.forms[0].strPreviousRejectedQty.value + " + " +
	 															document.forms[0].strPreviousBreakageQty.value ;
	 
	 	
	 	display_popup_menu(parentObj, "verifiedQtyDtlsDivId" , "250","");
	 	
	 }   
	  
	  var gblParentObj = "";
	 /**
	  * getBalanceQtyDtls
	  * @param {Object} parentObj 
	  */
	  function getBalanceQtyDtls(parentObj) {
	  	
	  	gblParentObj = parentObj;
	  	
	  	if(document.getElementById("balQtyDtlsDivId").innerHTML.length > 0){
	  		
	  	display_popup_menu(parentObj, "balQtyDtlsDivId" , "","");
	  		
	  	}else{
		  	var mode = "BALQTYDTLS";
	
			var url = "ChallanProcessTransCNT.cnt?hmode=" + mode + "&strPoNo="+ document.forms[0].strPoNo.value + 
																   "&strPoStoreId="+ document.forms[0].strPoStoreId.value +
																   "&strItemId="+ document.forms[0].strGenericItemId.value +
																   "&strItemBrandId="+ document.forms[0].strItemBrandId.value +
																   "&strScheduleNo="+ document.forms[0].strScheduleNo.value ;
																   
													   
																   
			ajaxFunction(url, "3");
	 }
 } 
 
function selectRecord(obj,index)
{  
   var passValue = document.getElementById("strHiddenChallanValue"+index).value;
   var chkObj = document.getElementById("strCheckOne"+index);
   
   if(chkObj.checked)
   {
   		chkObj.value = passValue;   		
   }
   else
   {
   		chkObj.value="";
   }  
}
	  
function fetchReceivedItemDetail(obj,index)
{		  	
  	var mode = "FETCHRECEIVEDITEMETAIL";
     
    var itemDetails = document.getElementById("strHiddenChallanValue"+index).value;
    var storeId = itemDetails.split('$')[0];   
    var poNo = itemDetails.split('$')[2];
    var challanNo = itemDetails.split('$')[3];
    
	var url = "ChallanProcessTransCNT.cnt?hmode=" + mode + "&strPoNo="+ poNo + "&strChallanNo="+ challanNo+ "&strStoreId="+ storeId ;
															   
	ajaxFunction(url, "4");	
}



function fetchVerifiedItemDetail(obj,index)
{		  	
  	var mode = "FETCHVERIFIEDITEMETAIL";
     //11-Dec-2012$06-Mar-2013$---$Ciprofloxacin I/V$Aspirin Soluble Tab$11 No.$11 No.$0 No.$0 No.$0 No.$Active$6301$6301$0$1$1$101012$ANALGESICS AND ANTIINFLAMMATORY DRUGS (NSAIDS)$0$null
     /*1. REC_DATE
      *2. CANCEL_DATE 
      *3. FREEZ_DATE
      *4. ITEM_NAME 
      *5. GEN_ITEM_NAME
      *6. REC_QTY 
      *7. BAL_QTY 
      *8. ACCQTY 
      *9. REJQTY 
      *10.BRKQTY 
      *11.STATUS 
      *12.NVL(HSTNUM_RECIEVED_QTY_UNITID,0) 
      *13.NVL(HSTNUM_BALQTY_UNITID,0) 
      *14.NVL(HSTNUM_EXCESSQTY_UNITID,0) 
      *15.RECQTY_BASE_VAL 
      *16.BAL_BASE_VAL 
      *17.HSTNUM_GROUP_ID 
      *18.GRP_NAME 
      *19.HSTNUM_SUBGROUP_ID 
      *20.SUBGRP_NAME 
      *21.HSTNUM_STORE_ID
      *22.HSTNUM_PO_STORE_ID
      *23.HSTNUM_PO_NO
      *24.HSTNUM_CHALLAN_NO
      *25.HSTNUM_ITEM_ID
      *26.HSTNUM_ITEMBRAND_ID*/
      
      //Challan No, Item Id, Item Brand Id
    var itemDetails = document.getElementById("strHiddenReceivedItems"+index).value;
    var storeId = itemDetails.split('$')[20];   
    var poNo = itemDetails.split('$')[22];
    var challanNo = itemDetails.split('$')[23];
    var itemId = itemDetails.split('$')[24];
    var itemBrandId = itemDetails.split('$')[25];
    
	var url = "ChallanProcessTransCNT.cnt?hmode=" + mode + "&strPoNo="+ poNo + "&strChallanNo="+ challanNo+ "&strStoreId="+ storeId+ "&strItemId="+ itemId+ "&strItemBrandId="+ itemBrandId ;
															   
	ajaxFunction(url, "5");	
}

function printPage(index)
{
	//alert("print");
	 var itemDetails = document.getElementById("strHiddenReceivedItems"+index).value;
	    var storeId = itemDetails.split('$')[20];   
	    var challanNo = itemDetails.split('$')[23];
	//alert(storeId);
	//alert(challanNo);
	var itemStockObj = document.getElementById("printDtlsDivId");
	if (itemStockObj.innerHTML == "") {

		var hmode = "PRINT";
		var url = "ChallanProcessTransCNT.cnt?hmode=" + hmode
				+ "&strStoreId=" + storeId + "&strChallanNo=" + challanNo;
		//	alert(url);	
		ajaxFunction2(url, "1", "getPRINTAjaxResponse");

	} else {
		// set for 1024 * 760 screen don't change this
		popup('popUpDiv', '80', '60');
	}



}

function printDataOne(mode) 
{
	newwin = window.open('', 'printwin',
			'left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
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
	if(mode=='1')
	{
	  newwin.document.write(document.getElementById('printDtlsDivId').innerHTML);	  
	}
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();
	 //document.getElementById("strCrNo").focus();

}

function getPRINTAjaxResponse(res, mode) {

	//STOCKDTLSINIT
	if (mode == '1') {

		var itemStockObj = document.getElementById("printDtlsDivId");

		itemStockObj.innerHTML = res;

		popup('popUpDiv', '80', '60');

	}

}

	  
	  