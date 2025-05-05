<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html>
<head>
<meta charset=UTF-8">
<style type="text/css">

            .pg-normal 
            {
                color: blue;
                font-weight: normal;
                text-decoration: none;
                cursor: pointer;
                
                
            }
            .pg-selected 
            {
                color: red;
                font-weight: bold;
                text-decoration: underline;
                cursor: pointer;
                
            }
            .pg-qualified 
            {
                color: green;
                font-weight: bold;
                text-decoration: underline;
                cursor: pointer;
                
            }
            </style>

<title>Insert Title Here</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../js/OfflineIssueDetails_util.js"></script> 
<script language="Javascript" src="../js/itemparameterdetails_util.js"></script> 
<script language="JavaScript" src="../js/mms.js"></script>
<script language="JavaScript" src="../js/OffLineIssueItemDtl.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>




<script type="text/javascript">

function OtherApprovedByfn()
{
	//alert(document.forms[0].strReceivedBy.value);
	if(document.forms[0].strReceivedBy.value == '1')
	{
		document.getElementById("ApprovedByOtherDiv").style.display='';	
	}else{
		document.getElementById("ApprovedByOtherDiv").style.display='none';
		}
	
}


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

		popup('popUpDiv1', '80', '60');

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
 		
 		hide_popup('popUpDiv1');
 		
 		 		
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
 		
 		
 		hide_popup('popUpDiv1');
 		
 		
 		
 		
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
 	 function cancelStockDetails() {
 	 	
 	 	var conf = confirm("Are you Sure, The Data(s) will be Reset");
 	 	
 	 	if(conf){
 	 			document.getElementById(gblUserHiddenFieldDivId).value = "";
 	 		
 	 		hide_popup('popUpDiv1');
 	 		
 	 	}else{
 	 		
 	 		hide_popup('popUpDiv1');
 	 		
 	 	}
 	 	
 	 }

   
   function CallFunc()
	{
			 var unitNameCmb = document.getElementsByName("strUnitName");
			 unitNameCmb[j].disable=true;
			 /*
			    for(var j=0;j<unitNameCmb.length;j++)
				{
					unitNameCmb[j].value = "0";
				}
	        */
	}
   /////////////////////////////////////////////////////////////////////////////////////////////////////

	
	function getItemSelectPopup()
	{
	   //document.getElementById("searchItemsDtlsDivId").innerHTML="";
	   setItemDtlWithIssueQty();
	   
	   var StoreCmb          = document.forms[0].strStoreName.value;
	   var ItemCatgCmb       = document.forms[0].strItemCatgCombo.value;
	   var IndentingStoreCmb = document.forms[0].strIndentingStoreID.value;
	  	   
	   if(StoreCmb!='0' && ItemCatgCmb!='0' && IndentingStoreCmb!='0')
       {	
	    var strModeVal 					= "3" ; 
		var strRequestType              = "17";
		var strItemCategory 			= ItemCatgCmb;
		var strFromStoreId 				= StoreCmb;
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strReqStoreAvlQty','strReqQty','strIssueQty');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t','t','t');
		var testFunction                = "setQtyDetails";
		var arg                         = " ";  
		
		var userInfo = IndentingStoreCmb;  // Here We Pass Indenting Store To find out Store Type If Type is 12 [MC] then Issue Quarntine Drugs also
		var unitMode = "1";  // only base unit  1 Means Only Base Unit Show 0 Means All Unit Show in Unit Combo
		
		var strMultiRowFetchDataArray 	= new Array('1','11','4','0^strUnitName^calUnitBaseCost');
		    
	    var layerIndex = "1";
		//alert(strItemCategory)
		//alert(strFromStoreId);
		//alert(strItemCategory);
        searchItemsWithUserFunction ( strModeVal , strItemCategory , strRequestType, StoreCmb, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg , userInfo , unitMode );
        
        
        
	  }
	  else
	   {
	   	   if(StoreCmb == 0)
	       {
	           alert("Please Select Store Name!!!! ");
	           StoreCmb.focus();
	       }
	       if(ItemCatgCmb == 0)
	       {
	           alert("Please Select Item Category!!!!");
	           ItemCatgCmb.focus();
	       }
	       if(IndentingStoreCmb == 0)
	       {
	           alert("Please Select Indenting Store!!!!");
	           IndentingStoreCmb.focus();
	       }
	    return false;
	 }
	}
	
	
	function setItemDtlWithIssueQty(){
	
		var itemWithIssueQty = document.getElementById("strItemDtlWithIssueQty");
		var  itemUserVal    = document.getElementsByName("itemUserValue");
	    var issueQty    = document.getElementsByName("strIssueQty");
  		var reqQty      = document.getElementsByName("strReqQty");
  		var unitNameCmb = document.getElementsByName("strUnitName");
  		var costObj     = document.getElementsByName("strCost");
		  
				
			if(itemUserVal.length > 1)
			{
				
				var tempIssueDtls ; 
				
				for(var i = 0 ; i < itemUserVal.length - 1 ; i++)
				{

															
					if(i == 0 )
					{
						
						tempIssueDtls = itemUserVal[i].value+"@@@@"+issueQty[i].value+"@@@@"+reqQty[i].value+"@@@@"+unitNameCmb[i].value+"@@@@"+costObj[i].value	
						
					}
					else
					{
					
						tempIssueDtls = tempIssueDtls+"$$$$"+itemUserVal[i].value+"@@@@"+issueQty[i].value+"@@@@"+reqQty[i].value+"@@@@"+unitNameCmb[i].value+"@@@@"+costObj[i].value
					
					}
				
				}
				
				itemWithIssueQty.value = tempIssueDtls;
				
				
			}else{
				itemWithIssueQty.value = "";
					
			}
				
		
	
	}
	
	
	function setQtyDetails()
	{
	
		var itemWithIssueQty = document.getElementById("strItemDtlWithIssueQty");
		var  itemUserVal    = document.getElementsByName("itemUserValue");
	    var issueQty    = document.getElementsByName("strIssueQty");
  		var reqQty      = document.getElementsByName("strReqQty");
  		var unitNameCmb = document.getElementsByName("strUnitName");
  		var costObj     = document.getElementsByName("strCost");
  		
  		if(reqQty.length > 1)
  			reqQty[0].focus();
  		
		
		if(itemWithIssueQty.value.length > 1)
		{
		
			var itemWithIssueQtyArray = itemWithIssueQty.value.split("$$$$");
			
				for(var i = 0 ; i < itemUserVal.length -1 ; i++){
				
					for(var j = 0 ; j < itemWithIssueQtyArray.length ; j ++){
				
								
							var newArrayTemp = itemWithIssueQtyArray[j].split('@@@@');
				
							if( itemUserVal[i].value == newArrayTemp[0] ){
							
								issueQty[i].value = newArrayTemp[1];
								reqQty[i].value = newArrayTemp[2];
								unitNameCmb[i].value = newArrayTemp[3];
								costObj[i].value = newArrayTemp[4];
							
							}
					
					}
							
				}
			
					itemWithIssueQty.value = "";
			
				var finalTotal = parseFloat("0");
			
				 for ( var i = 0; i <costObj.length - 1; i++)
					{		        					
		
						finalTotal = finalTotal + parseFloat(costObj[i].value);
			 		}		
			        finalTotal = roundValue(finalTotal, 2);
			        document.getElementById("strNewDemandApproxAmtDivId").value = finalTotal;
		            document.forms[0].strNewDemandFinalApproxAmt.value=finalTotal;
			
			
					
		} 
	
	}
	
function hidePopup() {

	hide_popup('popUpDiv');

}
function setValue()
{
         document.forms[0].strDemandTypeFlg.value = '1'; 
 		 document.forms[0].strIsNormal.checked = true;
}

</script>

</head>

<body   onload="getReport();setValue();">

<html:form action="/transactions/OfflineIssueIndentTransCNT.cnt"  name="offlineIssueIndentBean" type="mms.transactions.controller.fb.OfflineIssueIndentTransFB" method="post">

    <div class="errMsg"     id="errMsg"><bean:write name="offlineIssueIndentBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="offlineIssueIndentBean" property="strWarning"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="offlineIssueIndentBean" property="strMsg"/></div>



<div class='popup' id='avalaibleBudgetDtlId' style="display: none">
		<table width='400' border="0" cellspacing="1" cellpadding="1">
			<tr class="HEADER">
				<td colspan='3'>Budget Details</td>
	
				<th align='right'><img style='cursor: pointer; '
					src='../../hisglobal/images/popUp_cancel.JPG' title='Click to Close Pop-Up'
					onClick="hideBalQtyDetails('avalaibleBudgetDtlId');"></th>
			</tr>
		</table>


		<table width='400' border="0" cellspacing="1" cellpadding="1">
	
			<tr>
				<td colspan="1" class='multiLabel'>Budget Allocated</td>
				<td colspan="1" class='multiLabel'>Budget Consumed</td>
	
			</tr>
			<tr>
				<td colspan="1" class='multiControl'>
				<div id='1'></div>
				</td>
				<td colspan="1" class='multiControl'>
				<div id='2'></div>
				</td>
	
			</tr>
		</table>
	</div>



<center>

<tag:tab tabLabel="Issue(Off Line)" selectedTab="FIRST" onlyTabIndexing="1" align="center" width="TABLEWIDTH">
	</tag:tab>
</center>




	<table class="TABLEWIDTH" align="center" cellspacing="1px">   
	   	
		<tr class="HEADER">

			<td colspan="4"></td>
			<td align="right"><span>
			<html:checkbox name="offlineIssueIndentBean" property="strViewChk" onclick="transferToViewPage();" title="Click Here To View Off Line Issue Item Detail"></html:checkbox></span>View</td>
		</tr>
				
	    </table>
	    
	    <table class="TABLEWIDTH" align="center" cellspacing="1px">
		

		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Store Name:</td>
			<td width="25%" class="CONTROL">
			
			     <select name="strStoreName" class="comboMax"   onChange="getItemCategoryCombo();">
                        <bean:write name="offlineIssueIndentBean" property="strStoreName" filter="false"/>
                 </select>
            </td>
			<td width="25%" class="LABEL"><font color="red">*</font>Item Category:</td>

			<td width="25%" class="CONTROL">
			
			<div id="ItemCatg" >
			     <select class='comboNormal' name='strItemCatgCombo' onchange='getIndentStoreCombo();'> 
		              <bean:write name="offlineIssueIndentBean" property="strItemCatgCombo" filter="false"/>  
		         </select>
		     </div>    
						
			  </td>
		    </tr>
		    <tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Indenting Store:</td>
			<td width="25%" class="CONTROL">
			
			
			<div id="IndentingStore">
			     <select class='comboMax' name='strIndentingStoreID'> 
		              <bean:write name="offlineIssueIndentBean" property="strIndentingStoreID" filter="false"/><option value="0">Select Value</option>  
		         </select>
            </div>
            </td>
			<td class="LABEL"  width="25%"><font color="red">*</font>Issue Date:</td>
			<td class="CONTROL" width="25%">			
       			<dateTag:date name="strIndentIssueDate"></dateTag:date>
       			
    		</td>
		</tr>
		
		</table>
		 <div id="pendingDemandDivID" ></div>
		 
	 <div id="newDemandTab" >
		<table class='TABLEWIDTH' align="center" cellspacing="1px" cellpadding="1px">
			 	<tr>
			 	<td colspan="1" width="5%" class="TITLE">
			 	
				<div id='' align='center'>	<img src="../../hisglobal/images/minus.gif" id='imgStockDetails' style="cursor: pointer;" 	onclick='showOrHideStockDetails(this)' title='Hide'></div>
				
				</td>
				<td colspan="3" width="95%" class="TITLE">New Demand</td></tr>
		</table>	
	</div>
    <div id="newDemandDivID" style="display:block;">
	  <table class="TABLEWIDTH" align="center" cellspacing="1px">
		 
		<tr>
		
		</tr>
		
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Indent
			Status:</td>
			<td width="25%" class="CONTROL"><input type="radio" name="strIsNormal" value="1" onClick="changeViewMode(this);" />Normal&nbsp;&nbsp;
			<input type="radio" name="strIsUrgent" value="2" onClick="changeViewMode(this);" />Urgent</td>

			<td width="25%" class="LABEL"><font color="red">*</font>Indent Period:</td>
			<td width="25%" class="CONTROL">
				<input type="text" class="txtFldMax" readonly="readonly" name="strIndentPeriodValue" value="${offlineIssueIndentBean.strIndentPeriodValue }"	onkeypress="return validateData(event,3);" maxlength="50">
			</td>
		</tr>

		<tr>
			<td class="LABEL"  width="25%"><font color="red">*</font>Indent No:</td>
			<td class="CONTROL" width="25%"><input type="text" class="txtFldMax" name="strIndentNo"	onkeypress="return validateData(event,5);" maxlength="15"></td>
            <td class="LABEL"  width="25%"><font color="red">*</font>Indent Date:</td>
			<td class="CONTROL" width="25%">
			
       			<dateTag:date name="strApprovedDate"  value=""></dateTag:date>
       				      			
			</td>


		</tr>
		
		<tr>
			<td class="LABEL"  width="25%"><font color="red">*</font>Indent Type</td>
			<td class="CONTROL" width="25%">
			    <select class='comboNormal' name='strIndentType'>
					<bean:write name="offlineIssueIndentBean" property="strIndentPeriodCombo" filter="false" />
				</select>
			
			</td>
            <td class="LABEL"  width="25%"><!--Budget Avalaible-->
            </td>
			<td class="CONTROL" width="25%">
			
       	     <div id="budgetIDTwo" style='display:none;'></div>
       				      			
			</td>


		</tr>
		
	</table>
	    
	    
        <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
        <tr class="TITLE">
			<td colspan="6"><div align="right" >
			<img   style="cursor: pointer;height: 20px" title='Click Here To Search Items' height="20" align="middle" id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png" onclick='getItemSelectPopup();'>
			</div>
			 </td>
		</tr>
        
          
	   </table> 
	  
		<logic:equal value="0" name="offlineIssueIndentBean" property="strBudgetFlg">
			<table class="TABLEWIDTH" bgcolor='#086fa6' align="center" cellpadding="1px" cellspacing="1px">
	   		
				<tr>
					<td  class="multiRPTLabel" width="25%">Item/Drug Name</td>
					<td  class="multiRPTLabel" width="18%" >Batch/SlNo</td>
					<td  class="multiRPTLabel" width="10%">Avl Qty</td>
					<td  class="multiRPTLabel" width="10%">Req Qty</td>
					<td  class="multiRPTLabel" width="12%"><font color='red'>*</font>Issue Qty</td>
					<td  class="multiRPTLabel" width="15%"><font color='red'>*</font>Unit</td>
						
				</tr>
				
				</table>
				
	       <div id="id1"></div>
       </logic:equal>
       
       <logic:equal value="1" name="offlineIssueIndentBean" property="strBudgetFlg">
       
       <table class="TABLEWIDTH" bgcolor='#086fa6' align="center" cellpadding="1px" cellspacing="1px">
	   		
				<tr>
					<td  class="multiRPTLabel" width="27%">Item/Drug Name</td>
					<td  class="multiRPTLabel" width="13%">Batch/SlNo</td>
					<td  class="multiRPTLabel" width="10%">Avl Qty</td>
					<td  class="multiRPTLabel" width="10%">Indenting Store Avl Qty</td>
					<td  class="multiRPTLabel" width="10%"><font color='red'>*</font>Req Qty</td>
					<td  class="multiRPTLabel" width="10%"><font color='red'>*</font>Issue Qty</td>
					<td  class="multiRPTLabel" width="10%"><font color='red'>*</font>Unit</td>
					<td  class="multiRPTLabel" width="10%">Cost</td>
						
				</tr>
				
				</table>
				
	       <div id="id1"></div>
       
       <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
				<tr>
					<td width="92%" class="LABEL">Total Approx Cost(Rs):</td>
					<td width="8%" class="CONTROL" style="color: red; font-weight: bold" align="center">
		    		<input type="text" style="color: red; font-weight: bold"  class="txtFldNormal"  value="0.00" name="strNewDemandApproxAmtDivId" id="strNewDemandApproxAmtDivId" readonly>
					<input type="hidden" name="strNewDemandFinalApproxAmt"></td><td width="4%" class="CONTROL"></td>
				</tr>
			</table>
					
		</logic:equal>
       
       <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1"> 
       		<tr>
       			<td class="TITLE" colspan="2">
       				<div id="">&nbsp; Approval  &amp; Receive Details</div>
       			</td>
       		</tr>
       	</table>
       	 <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1"> 	 
       	 
       	 
       	 <tr>
			<td width="25%" class="LABEL">Approved By:</td>
			<td width="25%" class="CONTROL">
			     
    		 <div id="ApprovedBy" >
			     <select class='comboNormal' name='strApprovedBy' > 
		              <bean:write name="offlineIssueIndentBean" property="strApprovedBy" filter="false"/><option value="0">Select Value</option>  
		         </select>
		     </div>   
    				
    		</td>

			<td width="25%" class="LABEL">Approval Date:</td>
			<td width="25%" class="CONTROL">
				<dateTag:date name="strApprovalDate"  value="${offlineIssueIndentBean.strApprovalDate}"></dateTag:date>
			</td>
		</tr>
        
        <tr>
			<td width="25%" class="LABEL">Verified By:</td>
			<td width="25%" class="CONTROL">
			         		
    		 <div id="VerifiedBy" >
			     <select class='comboNormal' name='strVerifiedBy'> 
		              <bean:write name="offlineIssueIndentBean" property="strVerifiedBy" filter="false"/><option value="0">Select Value</option>  
		         </select>
		     </div>   		
    				
    				
    				
    		</td>

			<td width="25%" class="LABEL">Verified Date:</td>
			<td width="25%" class="CONTROL">
				<dateTag:date name="strVerifiedDate"  value="${offlineIssueIndentBean.strVerifiedDate}"></dateTag:date>
			</td>
		</tr>
		
		</table>	        		
     </div>  <!-- Here we End newDemandDivID -->		    
        
        <div id="pendingIndentDetailsID"></div>
        <div id="itemHeader" style="display:none;">
	        <logic:equal value="0" name="offlineIssueIndentBean" property="strBudgetFlg">
				<table class="TABLEWIDTH" bgcolor='#086fa6' align="center" cellpadding="1px" cellspacing="1px">
				<tr>		
					<td class="multiRPTLabel" width="32%">Item/Drug Name</td>
					<td class="multiRPTLabel" width="10%">Avl. Qty.</td>
					<td class="multiRPTLabel" width="14%">Req Qty./Sanc Qty.</td>
					<td class="multiRPTLabel" width="10%"><font  color="red">*</font>Issue Qty.</td>
					<td class="multiRPTLabel" width="10%"><font  color="red">*</font>Unit</td>
					
					<td class="multiRPTLabel" width="4%" title="Item/Drug Preferences">#</td>
				</tr>
				</table>
				
			</logic:equal>
			<logic:equal value="1" name="offlineIssueIndentBean" property="strBudgetFlg">
				<table class="TABLEWIDTH" bgcolor='#086fa6' align="center" cellpadding="1px" cellspacing="1px">
				<tr>		
					<td class="multiRPTLabel" width="27%">Item/Drug Name</td>
					<td class="multiRPTLabel" width="7%">Avl. Qty.</td>
					<td class="multiRPTLabel" width="12%">Req Qty./Sanc Qty.</td>
					<td class="multiRPTLabel" width="10%"><font  color="red">*</font>Issue Qty.</td>
					<td class="multiRPTLabel" width="10%"><font  color="red">*</font>Unit</td>
					<td class="multiRPTLabel" width="10%">Cost</td>				
					<td class="multiRPTLabel" width="4%" title="Item/Drug Preferences">#</td>
				</tr>
				</table>
			</logic:equal>
		</div>
        <div id="pendingIndentItemDetailsID"></div>   
        	              
    
    
    <table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> 	
    <tr>
		<td colspan="4" class="TITLE"></td>
		</tr>
				<tr>
				<td class='LABEL' width='50%'><font color='red'>*</font>Received By</td>
				<td class='CONTROL'>
				 <div id="ReceivedBy" >
				  <select class='comboMax' name='strReceivedBy' onChange="OtherApprovedByfn();"> 
		               <option value="0">Select Value</option>  
		          </select>
		         </div>
		         <div id="ApprovedByOtherDiv" style="display:none">
		     <input type="text" class="txtFldMax" name="strApprovedByOther"	onkeypress="return validateData(event,3);" maxlength="15">
		     </div>
				</td>
				</tr>
				<tr>
				<td class='LABEL' width='50%'>
				<font color='red'>*</font>Approved Remarks</td>
				<td class='CONTROL'>
				<textarea name='strAprovedRemarks'></textarea>
				</td>
				</tr>
				</table>
    
    
       <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
          <tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		  </tr>
	   </table>
	
	
	 
	
	<div id="existingDemandId" style="display:none;">
	
		<table  class="TABLEWIDTH" align="center">
		  <tr>
				<td align="center">
		                <img style="cursor:pointer;cursor:pointer" title="Click to Save Record" src="../../hisglobal/images/btn-sv.png"  onClick=" return validateExistingDemand();" />
		                <img style="cursor:pointer;cursor:pointer" title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="initPage();">
		                <img style="cursor: pointer; " title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="cancel('LIST');" />
				</td>
			</tr>
		</table>	
	</div>
	<!-- 
   <div id="newDemandId" style="display:block;">
	<table  class="TABLEWIDTH" align="center">
	  <tr id="saveId">
			<td align="center">
	                <img style="cursor:pointer;cursor:pointer" title="Click to Save Record" src="../../hisglobal/images/btn-sv.png"  onClick=" return validateNewDemand();" />
	                <img style="cursor:pointer;cursor:pointer" title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="initPage();">
	                <img style="cursor: pointer; " title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" />
			</td>
		</tr>
	</table>	
	</div>-->
	<br>
    <div align="center" id="saveId">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validateNewDemand();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="initPage();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelFunc();"><span class="cancel">Cancel</span></a>
					</div> 
    <input type="hidden" name="hmode"/>
    
      <input type="hidden" name="strCurrentDate" value="${offlineIssueIndentBean.strCurrentDate}"/>
      <input type="hidden" name="strIsView" value="0"/>
      <input type="hidden" name="strTmpStoreNo" value="${offlineIssueIndentBean.strTmpStoreNo}"/>
      <input type="hidden" name="strTmpIssueNo" value="${offlineIssueIndentBean.strIssueNo}"/>
	  <input type="hidden" name="strTmpIndentNo" />
	  <input type="hidden" name="strTmpIndentDate" />
	  <input type="hidden" name="strIndentDate" value="${offlineIssueIndentBean.strIndentDate}"/>
	  <input type="hidden" name="strReOrderFlgColor" value="${offlineIssueIndentBean.strReOrderFlgColor}"/>
	  <input type="hidden" name="strBudgetFlg" value="${offlineIssueIndentBean.strBudgetFlg}"/>
	  <input type="hidden" name="strDemandActivePrd" value="${offlineIssueIndentBean.strDemandActivePrd}"/>
	  <input type="hidden" name="strIsDemandActiveFlag" value="${offlineIssueIndentBean.strIsDemandActiveFlag}"/>
	  
	  
	  
	   <input type="hidden" name="strDemandTypeFlg" />
	   <input type="hidden" name="strTmpIssuingStoreId" />
	    <input type="hidden" name="strTmpRaisingStoreId" />
	  <input type="hidden" name="strAvalaibleBudgetDtl" value="${offlineIssueIndentBean.strAvalaibleBudgetDtl}"/>
      <input type="hidden" name="strAvalaibleBudget" value="${offlineIssueIndentBean.strAvalaibleBudget}"/>
      <input type="hidden" name="strRemainingBudget" />
      <input type="hidden" name="strItemDtlWithIssueQty" id="strItemDtlWithIssueQty" value="0"/>
    
  <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         
          <div id="searchItemsDtlsDivId" style="display:block;"></div>
          
        
       </td>
     </tr>
    </table>
   </div>
   
   
   <div class="popUpDiv" id="popUpDiv1" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         
          
          <div id="issueDtlsDivId" style="display:block;"></div>
          <div id="stockDtlsDivId" style="display:block;"></div>
         <div id="itemOtherDtlsDiv" style="display:block;"></div>
        
       </td>
     </tr>
    </table>
   </div>
        
        
</html:form>

<jsp:include page="offLineIssueItem_itemSearchRow.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex> 
</body>
</html>