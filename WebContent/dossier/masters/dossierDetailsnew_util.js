
// global variable declarations 

var gblMode 			= "0";
var gblStockStatus 		= "0";
var gblGenItemId 		= "0";
var gblItemId 			= "0";
var gblIssueQty 		= "0";
var gblIssueQtyInBase 	= "0"; 
var gblCountedQtyName 	= "" ;
var gblVarianceQtyName  = "";
var gblVarianceCostName = "";
var gblStoreId 			= "0";
var gblCatCode 			= "0";
var gblReservedFlag		= "0";
var gblUserHiddenFieldDivId 	= "";
var gblIndexId = "";
var gblUserDefinedFuncName = "";
var gblUserDefinedArg = "";




/**
 * gets the stock details view 
 * 	
 * It will get the View and display by calling the ajax function.
 * 	
 * 
 * @param strMode - contains 2 Modes they are 
 * 					1. Retrieving Item Stock Qty Details
 * 					2. View Item Stock   	
 * @param strStockStatus - Item Stock Status
 * @param strGenItemId - Generic Item Id
 * @param strItemId - Item Id (Item Brand Id)
 * @param strIssueQty - Issue Quantity
 * @param strIssueQtyUnitBase - Issue Quantity Unit Base Value
 * @param strStoreId - From Store Id
 * @param strCatCode - Category Code.
 * @param strReservedFlag - Stock Reserved Flag
 * @param strUserHiddenFieldId - user hidden field where the details are set when the contents are saved.
 * 							  each Column is appended with ^ and each Row is appended with # e.g. (a1^a2^a3#b1^b2^b3) 
 *     In User Hidden Field the available values will be in the following Order after spliting with # and ^

 *    
                               * 0. Store id, 

                                     * 1. Generic Item Id 

                                     * 2. Item Id 

                                     * 3. Stock Status Code 

                                     * 4. Batch No.

                                     * 5. Expiry Date

                                     * 6. Manufacture Date

                                     * 7. Inhand Qty

                                     * 8. Inhand Qty Unit Id

                                     * 9. Rate

                                     * 10. Rate Unit Id

                                     * 11. Serial No.

                                     * 12. Sale Price

                                     * 13. Sale Price Unit Id
									* 14. Issue Qty
                                     * 15. Issue Qty Unit

 *

 */
function getStockDtls(strMode, strStockStatus, strGenItemId, strItemId, strIssueQty, strIssueQtyUnitBase, 
						strStoreId, strCatCode, strReservedFlag, strUnitName ,strUserHiddenFieldId) {

	gblMode 			= strMode;
	gblStockStatus 		= strStockStatus;
	gblGenItemId 		= strGenItemId;
	gblItemId 			= strItemId;
	gblIssueQty 		= strIssueQty;
	gblIssueQtyInBase 	= strIssueQtyUnitBase; 
	gblStoreId 			= strStoreId;
	gblCatCode 			= strCatCode;
	gblReservedFlag		= strReservedFlag;	
	gblUserHiddenFieldDivId 	= strUserHiddenFieldId;
	
	
// div id is a hardcoded value.
	var itemStockObj = document.getElementById("stockDtlsDivId");
	
	//if (itemStockObj.innerHTML == "") {

		var hmode = "STOCKDTLSINIT";
		
		/*
		* This line is inactivated by Aritra on 28-May-2010.
		* Reason: it replaces only first occurence of # with @. But the requirement
		* was to replace all occurence of # with @.
		*/
		//var hidVal = document.getElementById(strUserHiddenFieldId).value.replace("#" , "@");
		
		/*
		* This line is inactivated by Aritra on 28-May-2010.
		* Reason: it replaces all occurence of # with @. Reqular expression is used.
		* Code Refference: http://www.w3schools.com/jsref/jsref_replace.asp
		*/
		var hidVal = document.getElementById(strUserHiddenFieldId).value.replace(/#/g , "@");

		var url = "MmsCNT.cnt?hmode=" + hmode + "&strMode=" + strMode+"&strStockStatus="+
					strStockStatus +"&strGenItemId="+strGenItemId+"&strItemId="+strItemId+
					"&strIssueQty="+strIssueQty+"&strIssueQtyInBase="+strIssueQtyUnitBase+
					"&strStoreId="+strStoreId+"&strCatCode="+strCatCode+"&strReservedFlag="+strReservedFlag+"&strHiddenFieldVal="+hidVal+"&strUnitName="+strUnitName;
			
		
		ajaxFunction2(url, "1", "getStockDtlsAjaxResponse");

	/*} else {
		// set for 1024 * 760 screen don't change this
		popup('popUpDiv', '80', '60');
	}*/

}




/**
 * gets the stock details view 
 * 	
 * It will get the View and display by calling the ajax function.
 * 	
 * 
 * @param strMode - contains 2 Modes they are 
 * 					1. Retrieving Item Stock Qty Details
 * 					2. View Item Stock   	
 * @param strStockStatus - Item Stock Status
 * @param strGenItemId - Generic Item Id
 * @param strItemId - Item Id (Item Brand Id)
 * @param strStoreId - From Store Id
 * @param strCatCode - Category Code.
 * @param strReservedFlag - Stock Reserved Flag
 * @param strUserHiddenFieldId - user hidden field where the details are set when the contents are saved.
 * 							  each Column is appended with ^ and each Row is appended with # e.g. (a1^a2^a3#b1^b2^b3) 
 *     In User Hidden Field the available values will be in the following Order after spliting with # and ^

 *    
                               * 0. Store id, 

                                     * 1. Generic Item Id 

                                     * 2. Item Id 

                                     * 3. Stock Status Code 

                                     * 4. Batch No.

                                     * 5. Expiry Date

                                     * 6. Manufacture Date

                                     * 7. Inhand Qty

                                     * 8. Inhand Qty Unit Id

                                     * 9. Rate

                                     * 10. Rate Unit Id

                                     * 11. Serial No.

                                     * 12. Sale Price

                                     * 13. Sale Price Unit Id
									* 14. Issue Qty
                                     * 15. Issue Qty Unit

 *

 */
function getPhyVerifyStockDtls(strMode, strStockStatus, strGenItemId, strItemId, 
						strStoreId, strCatCode, strReservedFlag, strUnitName ,strUserHiddenFieldId , strUserDefinedFuncName , strUserDefinedArg) {

	gblMode 			= strMode;
	gblStockStatus 		= strStockStatus;
	gblGenItemId 		= strGenItemId;
	gblItemId 			= strItemId;
	gblStoreId 			= strStoreId;
	gblCatCode 			= strCatCode;
	gblReservedFlag		= strReservedFlag;	
	gblUserHiddenFieldDivId 	= strUserHiddenFieldId;
	gblUserDefinedFuncName = strUserDefinedFuncName;
	gblUserDefinedArg = strUserDefinedArg;
	
// div id is a hardcoded value.
	var itemStockObj = document.getElementById("stockDtlsDivId");
	
	//if (itemStockObj.innerHTML == "") {

		var hmode = "STOCKDTLSINIT";
		
			var temp = document.getElementById(strUserHiddenFieldId).value.split("#");
			
			var hidVal = document.getElementById(strUserHiddenFieldId).value;
			
			for(var i = 0; i < temp.length; i++){
		
			 hidVal = hidVal.replace("#" , "@");
			
			}
					
		var url = "MmsCNT.cnt?hmode=" + hmode + "&strMode=" + strMode+"&strStockStatus="+
					strStockStatus +"&strGenItemId="+strGenItemId+"&strItemId="+strItemId+
					"&strStoreId="+strStoreId+"&strCatCode="+strCatCode+"&strReservedFlag="+strReservedFlag+"&strHiddenFieldVal="+hidVal+"&strUnitName="+strUnitName;
			
		
		ajaxFunction2(url, "1", "getStockDtlsAjaxResponse");

	/*} else {
		// set for 1024 * 760 screen don't change this
		popup('popUpDiv', '80', '60');
	}*/

}



/**
 * Customized ajax response function for stock details
 * @param res - result 
 * @param mode - mode
 * @return
 */
function getStockDtlsAjaxResponse(res, mode) {

	//STOCKDTLSINIT
	if (mode == '1') {

		var itemStockObj = document.getElementById("stockDtlsDivId");

		itemStockObj.innerHTML = res;

		popup('popUpDiv', '80', '60');

	}
	
	
	if(mode == '2'){
		
		var itemStockObj = document.getElementById("itemOtherDtlsDiv");

		itemStockObj.innerHTML = res;

		display_popup_menu( gblOtherDtlsParentObj , "itemOtherDtlsDiv" , "200", "200");

	}
	

}

/**
 * enable or disable the qty field based on the check click & unclick event.
 * @param obj
 * @param index
 * @return
 */
function checkStockDetails(obj, index) 
{
	
	if(obj.checked)
	{
		
		document.getElementById("strAvailableQty"+index).disabled = false;
		document.getElementById("strAvailableQtyUnit"+index).disabled = false;
		
	}
	else
	{
		
		document.getElementById("strAvailableQtyUnit"+index).disabled = false;
		
		document.getElementById("strAvailableQty"+index).value = "0";
		document.getElementById("strAvailableQty"+index).disabled = true;
		
		
		document.getElementById("strAvailableQtyUnit"+index).selectedIndex = 0;
		document.getElementById("strAvailableQtyUnit"+index).disabled = true;
  
        document.getElementById("strStockCost"+index).disabled = false;
		document.getElementById("strCost"+index).disabled = false;
    
		document.getElementById("strStockCost"+index).value = "0.00";
		document.getElementById("strCost"+index).value = "0.00";
		
		document.getElementById("strStockCost"+index).disabled = true;
		document.getElementById("strCost"+index).disabled = true;
		totalCost();
		
		
	}
	
}



/**
 * checkAvailQty - Qty validation.
 * @param {String} unitName
 * @param {String} qtyName  
 */
function checkAvailQty(index,  qtyName, unitName) 
{
		var unitObj = document.getElementById(unitName+""+index);
		var qtyObj = document.getElementById(qtyName+""+index);
        
		
			var qtyDeceimal = qtyObj.value;

			var unitVal = unitObj.value.split('^')[2];

			if (qtyDeceimal.indexOf('.') > -1 && unitVal == '0') 
			{
				alert("Qty must be an Integer ");
				qtyObj.value = '0';
   			    return false;
			}
		
	return true;
}

/**
  * validate the stock details popup contents
  * @return true - if validation is success.
  * 		false - if validation failure.
  */
 	function validatePopUp() 
 	{
		
 		var chkObj = document.getElementsByName("strStockDtlsChk");
 		var count = parseInt("0");
 		var qtyValue = parseFloat("0");
 		var chkValue = "";
 		var costObj   ="";
 		var totalCost ="";
 		var index = document.forms[0].strIndex.value;
 		for ( var i = 0; i < chkObj.length; i++)
        {
			
 			if(chkObj[i].checked)
 			{
 				
 				count = count + 1;
 				
 				var qtyObj    = document.getElementById("strAvailableQty"+(i+1));
 				var unitObj   = document.getElementById("strAvailableQtyUnit"+(i+1));
 				// Here we Check Condition Either Budget Flag is On or Off
 				if(document.forms[0].strBudgetFlg.value=='1')
 				{
 				  costObj   = document.getElementById("strCost"+(i+1)).value;
 				  totalCost = document.forms[0].strApproxAmt.value;
 				  
 				  document.getElementById("finalCostDivId"+index).disabled  = false;	
 				 
 				  document.getElementById("finalCostDivId"+index).value  = 	totalCost;	
 				  document.getElementById("strFinalCost"+index).value  = 	totalCost;	
 				   document.getElementById("finalCostDivId"+index).disabled  = true;	
 				  
 				  
 				}
 				else
 				{
 					costObj   = "0";
 				    totalCost = "0";
 				    //document.getElementById("finalCostDivId"+index).disabled  = false;
 				    //document.getElementById("finalCostDivId"+index).value  = '0.00';
 				    //document.getElementById("strFinalCost"+index).value    = '0.00';	
 				    //document.getElementById("finalCostDivId"+index).disabled  = true;
 				}
 				 				
 				if(qtyObj.value.length < 1)
 				{
 					
 					alert("Please Enter the Quantity");
 					qtyObj.focus();
 					if(document.forms[0].strBudgetFlg.value=='1')
 				    {
 					 document.getElementById("finalCostDivId"+index).disabled  = false;
 					 document.getElementById("finalCostDivId"+index).value  ='0.00';
 					 document.getElementById("strFinalCost"+index).value    = '0.00';	
 					 document.getElementById("finalCostDivId"+index).disabled  = true;
 				    } 
 					
 					return false;
 				}
 				else
 				{
 					
 					
 					if(count == 1)
 					{
 						
 						chkValue = chkObj[i].value +"^"+qtyObj.value+"^"+unitObj.value+"^"+costObj+"^"+totalCost;
 						
 					}
 					else
 					{
 						
 						chkValue = chkValue +"#" + chkObj[i].value +"^"+qtyObj.value+"^"+unitObj.value+"^"+costObj+"^"+totalCost;
 						
 					}
 					
 					var unitBaseVal = unitObj.value.split('^')[1];
 					
 					qtyValue = qtyValue + (parseFloat(qtyObj.value) * parseFloat(unitBaseVal))
 					
 				}
 				
 			}
		}
 		

 		if(count > 0)
 		{
 			
 			var issueQty 	 = parseFloat(document.forms[0].strItemIssueQty.value);
 			
 			var issueBaseVal = parseFloat(document.forms[0].strItemIssueQtyBaseVal.value);
 			
 			var issueVal = issueQty * issueBaseVal;
 			
 			
 			if(qtyValue != issueVal)
 			{
 				// Here we Check Condition Either Budget Flag is On or Off
 				if(document.forms[0].strBudgetFlg.value=='1')
 				{
	 				var costObj = document.getElementsByName("strCost");
					var total = parseFloat("0.00");
				   	if (costObj.length > 0) 
					{
				        
						for ( var i = 1; i <costObj.length; i++)
						{		        					
							document.getElementById("strCost"+i).value="0.00";
							document.getElementById("strStockCost"+i).value="0.00";
							document.getElementById("strTotalCostDivId").innerHTML = "0.00";
							document.getElementById("strAvailableQty"+i).value="0";
							
							
				 		}
				
					}
					document.getElementById("finalCostDivId"+index).disabled  = false;
	 				document.getElementById("finalCostDivId"+index).value  ='0.00';	
	 				document.getElementById("strFinalCost"+index).value    = '0.00';
	 				document.getElementById("finalCostDivId"+index).disabled  = true;
	 				totalIssueCost();
 				}
 				
 				
 				
 				alert("Quantity Total should be Equal to Issue Quantity");

				document.getElementById("strTotalCostDivId").value = '0.00';

 				return false;
 			}
 			
 		}
 		else
 		{
 			
 			alert("Please Select Atleast One Record");
 			if(document.forms[0].strBudgetFlg.value=='1')
 			{
	 			document.getElementById("finalCostDivId"+index).value  ='0.00';	
	 			document.getElementById("strFinalCost"+index).value    = '0.00';
 			}		
 			return false;
 		}
 		if(document.forms[0].strBudgetFlg.value=='1')
 		{
        /* This Method is Used to Calculate Total Approx Issue Cost(Rs.)   */
           totalIssueCost();
 		}  
 		document.getElementById(gblUserHiddenFieldDivId).value = chkValue;
 		
 		hide_popup('popUpDiv');
 		
 		 		
 		return true;
	}

 	
 	/**
 	 * validatePhyStockPopUp
 	  
 	 */
 	 function validatePhyStockPopUp() {
 	 	
 	 	var chkObj = document.getElementsByName("strStockDtlsChk");
 		var count = parseInt("0");
 		var qtyValue = parseFloat("0");
 		var chkValue = "";
 		
 		for ( var i = 0; i < chkObj.length; i++) {
			
 			if(chkObj[i].checked){
 				
 				count = count + 1;
 				
 				var qtyObj  = document.getElementById("strAvailableQty"+(i+1));
 				var unitObj = document.getElementById("strAvailableQtyUnit"+(i+1));
 				
 				if(qtyObj.value.length < 1){
 					
 					alert("Please Enter the Quantity");
 					qtyObj.focus();
 					
 					return false;
 				}else{
 					
 					
 					if(count == 1){
 						
 						chkValue = chkObj[i].value +"^"+qtyObj.value+"^"+unitObj.value;
 						
 					}else{
 						
 						chkValue = chkValue +"#" + chkObj[i].value +"^"+qtyObj.value+"^"+unitObj.value;
 						
 					}
 					
 					var unitBaseVal = unitObj.value.split('^')[1];
 					
 					qtyValue = qtyValue + (parseFloat(qtyObj.value) * parseFloat(unitBaseVal))
 					
 				}
 				
 				
 				
 			}
		}
 		
 	 		
		if(count == 0){
 			 			
 			alert("Please Select Atleast One Record");
 			return false;
 		}
 		document.getElementById(gblUserHiddenFieldDivId).value = chkValue;
 		
 		
 		hide_popup('popUpDiv');
 		
 		
 		
 		
 		if (gblUserDefinedFuncName != "" && gblUserDefinedFuncName.length > 0) {
		if (gblUserDefinedArg != "" && gblUserDefinedArg.length > 0) // with user
		// argument
		{
			eval(gblUserDefinedFuncName + "('" + gblUserDefinedArg + "')");
		} else // without user argument
		{
			eval(gblUserDefinedFuncName);
		}
	}
 		
 		
 		return true;
 	 	
 	 	
 	 }
 	
 	
 	 
 	
 	
 	// global variable for popup position 
 	var gblOtherDtlsParentObj = "";
 	
 	/**
 	 * display's the item detail popup 
 	 * @param viewMode
 	 * @param parentObj
 	 * @param itemVals
 	 * @return
 	 */
 	function showItemOtherDetailsPopup(viewMode,parentObj,itemVals) {
		
 		gblOtherDtlsParentObj = parentObj;
 		
 		var hmode = "FREEITEMDTLS";
 		
 		if(viewMode == '1'){
 			
 			hmode = "FREEITEMDTLS";
 			
 		}else if(viewMode == '2'){
 			
 			hmode = "PARTITEMDTLS";
 			
 		}else if(viewMode == '3'){
 			
 			hmode = "ITEMPARAMDTLS";
 			
 		}else if(viewMode == '4'){
 			
 			hmode = "WARRANTYDTLS";
 		}
 		
 		
 		var temp = itemVals.split('^');
 		
 		
		var url = "MmsCNT.cnt?hmode=" + hmode  +"&strGenItemId="+ temp[1] +"&strItemId="+ temp[2] +"&strBatchSlNo="+ temp[3];

	
		ajaxFunction2(url, "2", "getStockDtlsAjaxResponse");
 		
 		
	}
 	
 	/**
 	 * cancelStockDetails 
 	 */
 	 /**
 	 * cancelStockDetails 
 	 */
 	 function cancelStockDetails(obj, index) 
 	 {
 	 	
 	 	var conf = confirm("Are you Sure, The Data(s) will be Reset");
 	 	
 	 	if(conf)
 	 	{
 	 			document.getElementById(gblUserHiddenFieldDivId).value = ""; 	 			
 	 			
 	 			 //document.getElementById("finalCostDivId"+index).value = '0.00';
 	 			 
			 	//document.getElementsByName("finalCostDivId")[index].value = '0.00';	 			
 	 			// var len = document.getElementsByName("strIssueQty").legth;
 	 			  var chkObj = document.getElementsByName("strIssueQty");
                  var chkObj1 = document.getElementsByName("strIssueUnitId");
	              var len = chkObj.length;
	              
					for(i=0;i<len;i++)
					{			
									
						  	chkObj[i].disabled = false;	
						  	chkObj1[i].disabled = false;	
						  	chkObj[i].value = "";	
						  						
					}
						
				  
 	 			 // document.getElementsByName("finalCostDivId")[0].value = '0.00';
 	 			//document.getElementsByName("strIssueQty")[index].disabled=false;	
 	 			//document.getElementsByName("strIssueUnitId")[index].disabled=false;	
 	 			hide_popup('popUpDiv');
 	 		
 	 	}
 	 	else
 	 	{
 	 		
 	 		//hide_popup('popUpDiv');
 	 		
 	 	}
 	 	
 	 }

