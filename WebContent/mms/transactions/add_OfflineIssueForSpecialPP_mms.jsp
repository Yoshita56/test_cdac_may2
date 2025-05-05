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

<title>Insert Title Here</title>

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css"
	rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css"
	rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css"
	rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet"
	type="text/css">
<link
	href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css"
	rel="stylesheet" type="text/css">
	
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript"
	src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

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
<script language="Javascript" src="../js/itemparameterdetails_utilNEW.js"></script> 
<script language="JavaScript" src="../js/mms.js"></script>
<script language="JavaScript" src="../js/SpecilaOffLineIssue.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>


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
            .prescriptionTile {
				margin: 20px;
				border-bottom: 1px solid #d7d7d7;
				padding-bottom: 10px;
				padding: 1% 2% 0.5% 2%;
				background-color: #fff;
				transition: 0.5s;
				box-shadow: 0.5px 0.5px 10px 2px #b0acac;
				border-radius: .35rem;
				color: #666;
				color: rgba(75, 75, 75, 0.9);
				color: rgb(21, 21, 21);
			}
			.legend2 {
				position: absolute;
				top: 0.5em;
				right: 44px;
				line-height: 1.2em;
			}
			
			.table .thead-dark {
			  	color: #000 !important;
			  	border: none !important;
			  	background:linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;
			}
			.thead-dark th{
				background:none !important;
				border: none !important;
				padding:0.25rem;	
			}
</style>
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

<html:form action="/transactions/OffLineIssueForSpPPCNT.cnt"  name="offLineIssueForSpPPBean" type="mms.transactions.controller.fb.OffLineIssueForSpPPFB" method="post">
			<div class="errMsg"     id="errMsg"><bean:write name="offLineIssueForSpPPBean" property="strErr"/></div>
			<div class="warningMsg" id="warningMsg"><bean:write name="offLineIssueForSpPPBean" property="strWarning"/></div>
			<div class="normalMsg"  id="normalMsg"><bean:write name="offLineIssueForSpPPBean" property="strMsg"/></div>

<!-- <div class="viewport" id="nonPrintable"> -->
	<div class="container-fluid">
		<div class="prescriptionTile">
	       
			<div class='legendHeader'><i class="fas fa-file-alt" style="font-size: 26px;"></i>&nbsp;Special Purpose Issue</div>
							
			<div class="row " id="saveId">
				<div class="legend2" id='nonPrintableLegend2'>
					<button type="button" class="float-right btn btn-danger mt-1 btn-circle" style="border-radius:50%; padding:12px;" onclick="cancelFunc();">
						<i class="fas fa-times fa-lg iround" title="Cancel"></i>
					</button>
					
					<button  type="button" class="float-right btn btn-primary mt-1 btn-circle" name="offLineIssueForSpPPBean" property="strViewChk"  style="border-radius:50%; padding:12px;" onclick="transferToViewPage();" title="Click Here To View Off Line Issue Item Detail" >
						<i class="fas fa-eye iround"  title="View"></i>
					</button>
					
					<button type="button" class=" btn btn-secondary btn-circle" style="border-radius:50%; padding:12px 7px; background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" onclick="initPage();">
						<!-- <img src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 23px; color: #fff;"> -->
						<i class="fas fa-broom fa-lg iround" title="Clear"></i>
					</button>
					
					<button type="button" id="savebutton" class="float-right btn btn-success mt-1 btn-circle savebtn" name="patientAdmissionModiTransBean" tabindex='2'style="border-radius:50%; padding:12px;" onclick='return validateNewDemand();'>
						<i class="fa fa-download fa-beat iround" title="Save"></i>
					</button>
				</div>
			</div>

		<div class="container">
			<div class="row"  style="margin: 1% 12%">
				<div class="col-sm-2">Store Name:<font color="red">*</font></div>
				<div class="col-sm-4">
					 <select name="strStoreName" class="browser-default custom-select"   onChange="getItemCategoryCombo();">
	                        <bean:write name="offLineIssueForSpPPBean" property="strStoreName" filter="false"/>
	                 </select>
	            </div>
			                 
				<div class="col-sm-2">Item Category:<font color="red">*</font></div>
				<div class="col-sm-4" id="ItemCatg" >
				     <select class='browser-default custom-select' name='strItemCatgCombo' onchange='getIndentStoreCombo();'> 
			              <bean:write name="offLineIssueForSpPPBean" property="strItemCatgCombo" filter="false"/>  
			         </select>
			    </div>
			</div>

			<div class="row" style="margin: 1% 12%">
				<div class="col-sm-2 ">Special Store:<font color="red">*</font></div>
				<div class="col-sm-4" id="IndentingStore">
				     <select class='browser-default custom-select' name='strIndentingStoreID'> 
			              <bean:write name="offLineIssueForSpPPBean" property="strIndentingStoreID" filter="false"/><option value="0">Select Value</option>  
			         </select>
                </div>
               
			   <div class="col-sm-2">Issue Date:<font color="red">*</font></div>
				<div class="col-sm-4">
					<input  name="strIndentIssueDate" class="form-control datepicker" value="${offLineIssueForSpPPBean.strFromDate}" style="color: rgba(113, 111, 111, 0.87);">
				</div>
			</div>

			<!-- <div class='popup' id='avalaibleBudgetDtlId' style="display: none">
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
			</div> -->
			
			<br>
			<div id="pendingDemandDivID" ></div>
	
	    	<!-- <div id="newDemandDivID"> -->
	    	<div class="row" style="margin: 1% 12%">
	    		<div class="col-sm-2">Indent Status:<font color="red">*</font></div>
				<div class="col-sm-4">
					<input type="radio" name="strIsNormal" value="1" onClick="changeViewMode(this);" />Normal&nbsp;&nbsp;
					<input type="radio" name="strIsUrgent" value="2" onClick="changeViewMode(this);" />Urgent
				</div>
				
				<div class="col-sm-2">Indent Period:<font color="red">*</font></div>
				<div class="col-sm-4">
					<input type="text" class="form-control" readonly="readonly" name="strIndentPeriodValue" value="${offLineIssueForSpPPBean.strIndentPeriodValue }" onkeypress="return validateData(event,3);" maxlength="50">
				</div>
	    	</div>
				
			<div class="row" style="margin: 1% 12%">
	    		<div class="col-sm-2">Indent No:<font color="red">*</font></div>
				<div class="col-sm-4">
					<input type="text" class="form-control" name="strIndentNo"	onkeypress="return validateData(event,5);" maxlength="15">
				</div>
	
				<div class="col-sm-2">Indent Date:<font color="red">*</font></div>
				<div class="col-sm-4">
					<input  name="strApprovedDate" class="form-control datepicker" value="" style="color: rgba(113, 111, 111, 0.87);">
				</div>
	  		</div>
		   
			<div class="row" style="display:none;">
	    		<div class="col-sm-2 "><font color="red">*</font>Indent Type</div>
				<div class="col-sm-3"> 
					<select class='browser-default custom-select' name='strIndentType'>
						<bean:write name="offLineIssueForSpPPBean" property="strIndentPeriodCombo" filter="false" />
					</select>
				</div>
				<div class="col-sm-1"></div>
				<div class="col-sm-2"></div>
				<div class="col-sm-3"><div id="budgetIDTwo" style='display:none;'></div></div>
	    	</div>	
		
		</div>
			<hr>
      <!-- <div class="row">
	        	<div class="col-sm-12" align="center">
	        		<img style="cursor: pointer;height: 20px" title='Click Here To Search Items' height="20" align="middle" id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png" onclick='getItemSelectPopup();'>
	        	</div>
	        </div> -->
	        
	        <div class="row my-2">
                 <div class="col" align="right">
                     <button type="button" id="strSearchItemButtonDivId" class="btn btn-success" title="Click Here To Search Items" onClick="getItemSelectPopup();"> 
                           <span class="popuptextToast" >ItemFinder </span><i class="fas fa-thin fa-file-magnifying-glass"></i>
                     </button>
                 </div>
       		</div>
	        
	        <hr>
				
			<logic:equal value="0" name="offLineIssueForSpPPBean" property="strBudgetFlg">
				<div class="row">
				  <table class="table" >
						<thead class='thead-dark' align='center'>
							<tr>
							<th  scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Item/Drug Name</th>
							<th  scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Batch/SlNo</th>
							<th  scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Avl Qty</th>
							<th  scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</th>
							<th  scope='col' style='font-weight:350 !important ;font-size: 16px !important;'><font color='red'>*</font>Issue Qty</th>
							<th  scope='col' style='font-weight:350 !important ;font-size: 16px !important;'><font color='red'>*</font>Unit</th>
							</tr>
						</thead>
					</table>
				</div>
				
				<div class="row">
			       <div id="id1"></div>
			    </div>
	       </logic:equal>
       
	       	<logic:equal value="1" name="offLineIssueForSpPPBean" property="strBudgetFlg">
		       <div class="row">
			       <div class="col-sm-12">
				     <table class="table table-striped" >
						<thead class='thead-dark' align='center'>
							<tr>
								<th  scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Item/Drug Name</th>
								<th  scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Batch/SlNo</th>
								<th  scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Avl Qty</th>
								<th  scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>GST(%)</th>
								<th  scope='col' style='font-weight:350 !important ;font-size: 16px !important;'><font color='red'>*</font>Req Qty</th>
								<th  scope='col' style='font-weight:350 !important ;font-size: 16px !important;'><font color='red'>*</font>Issue Qty</th>
								<th  scope='col' style='font-weight:350 !important ;font-size: 16px !important;'><font color='red'>*</font>Unit</th>
								<th  scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Cost</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
					
				<div class="row">
					<div class="col-sm-12">
		      		  <div id="id1"></div>
		      		</div>
		      	</div>
			      
		        <div class="row">
		       		<div class="col-sm-10" align="right">
		      			Total Approx Cost(Rs):
		      		</div>
					<div class="col-sm-2">
			    		<input type="text" style="color: red; font-weight: bold"  class="form-control"  value="0.00" name="strNewDemandApproxAmtDivId" id="strNewDemandApproxAmtDivId" readonly>
						<input type="hidden" name="strNewDemandFinalApproxAmt">
				   </div>
			   </div>
			</logic:equal>
	       	<br>
	       	
			<div class="container">
				<div class='legendHeader'><i class="fas fa-thumbs-up" style="font-size:26px;"></i>&nbsp; Approval  &amp; Receive Details</div>
		       
		       	<div class="row" style="margin: 1% 12%">
		       		<div class="col-sm-2 ">Approved By:</div>
		       		<div class="col-sm-4"><div id="ApprovedBy" >
					    <select class='browser-default custom-select' name='strApprovedBy' > 
			            	<bean:write name="offLineIssueForSpPPBean" property="strApprovedBy" filter="false"/><option value="0">Select Value</option>  
				        </select>
				     </div> </div>
		
		       		<div class="col-sm-2">Approval Date:</div>
		       		<div class="col-sm-4">
		       			<input  name="strApprovalDate" class="form-control datepicker" value="${offLineIssueForSpPPBean.strApprovalDate}" style="color: rgba(113, 111, 111, 0.87);">
		       		</div>
		       	</div> 
		       	
		       	
		       	<div class="row" style="margin: 1% 12%">
		       		<div class="col-sm-2">Verified By:</div>
		       		<div class="col-sm-4" id="VerifiedBy">
					    <select class='browser-default custom-select' name='strVerifiedBy'> 
				            <bean:write name="offLineIssueForSpPPBean" property="strVerifiedBy" filter="false"/><option value="0">Select Value</option>  
				        </select>
		    		</div>
		    		 
		       		<div class="col-sm-2">Verified Date:</div>
		       		<div class="col-sm-4">
		       			<input  name="strVerifiedDate" class="form-control datepicker" value="${offLineIssueForSpPPBean.strVerifiedDate}" style="color: rgba(113, 111, 111, 0.87);">
		       		</div>
		       	</div>
		<!-- </div>  Here we End newDemandDivID	 -->	    
        
        	<div id="pendingIndentDetailsID"></div>
        
	        <div id="itemHeader" style="display:none;">
		        <logic:equal value="0" name="offLineIssueForSpPPBean" property="strBudgetFlg">
		        	<div class="row">
			        	<div class="col">
							<table class="table table-striped" >
								<thead class='thead-dark' align='center'>
									<tr>	
									<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Item/Drug Name</th>
									<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Avl. Qty.</th>
									<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty./Sanc Qty.</th>
									<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'><font  color="red">*</font>Issue Qty.</th>
									<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'><font  color="red">*</font>Unit</th>					
									<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;' title="Item/Drug Preferences">#</th>
								</tr>
								</thead>
							</table>
						</div>
					</div>
				</logic:equal>
				
				<logic:equal value="1" name="offLineIssueForSpPPBean" property="strBudgetFlg">
					<div class="row">
						<div class="col">
						<!-- bgcolor='#086fa6' align="center" cellpadding="1px" cellspacing="1px" -->
							<table class="table table-striped" >
								<thead class='thead-dark' align='center'>
									<tr>
										<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Item/Drug Name</td>
										<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>GST(%)</th>
										<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty./Sanc Qty.</th>
										<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'><font  color="red">*</font>Issue Qty.</th>
										<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'><font  color="red">*</font>Unit</th>
										<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Cost</th>				
										<th scope='col' style='font-weight:350 !important ;font-size: 16px !important;' title="Item/Drug Preferences">#</th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
				</logic:equal>
			</div>
        
	        <div id="pendingIndentItemDetailsID"></div>   
	        	              
	    	<br>
	    	
		    <div class="row" style="margin: 1% 12%">
		    	<div class="col-sm-2">Received By<font color='red'>*</font></div>
		    	<div class="col-sm-4" id="ReceivedBy" >
					  <select class='browser-default custom-select' name='strReceivedBy' onChange="OtherApprovedByfn();"> 
			               <option value="0">Select Value</option>  
			          </select>
				</div>
				
				<div class="col-sm-2">Approved Remarks<font color='red'>*</font></div>		
				<div class="col-sm-4">
					<textarea class="form-control" rows="1" style="height:38px;" name='strAprovedRemarks'></textarea>
				</div>	
	    	</div>
	    	
    	   <div class="row">
		        <div class="col" id="ApprovedByOtherDiv" style="display:none">
			    	<input type="text" class="form-control" name="strApprovedByOther"	onkeypress="return validateData(event,3);" maxlength="15">
			    </div>
		  </div>
   	   <hr>
	   <div class="row">
			<div class="col" align="right"><font size="2" color="red">*</font>Fields Mandatory</div>   
	   </div> 
      
		
	   <div id="existingDemandId" style="display:none;">
			<table  class="TABLEWIDTH" align="center">
			    <tr>
					<td align="center">
		                <img style="cursor:pointer;cursor:pointer" title="Click to Save Record" src="../../hisglobal/images/btn-sv.png"  onClick=" return validateExistingDemand();" />
		                <img style="cursor:pointer;cursor:pointer" title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="initPage();">
		                <img style="cursor:pointer;"              title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="cancel('LIST');" />
					</td>
				</tr>
			</table>	
		</div>
	
	  <input type="hidden" name="hmode"/>
      <input type="hidden" name="strCurrentDate" value="${offLineIssueForSpPPBean.strCurrentDate}"/>
      <input type="hidden" name="strIsView" value="0"/>
      <input type="hidden" name="strTmpStoreNo" value="${offLineIssueForSpPPBean.strTmpStoreNo}"/>
      <input type="hidden" name="strTmpIssueNo" value="${offLineIssueForSpPPBean.strIssueNo}"/>
	  <input type="hidden" name="strTmpIndentNo" />
	  <input type="hidden" name="strTmpIndentDate" />
	  <input type="hidden" name="strIndentDate" value="${offLineIssueForSpPPBean.strIndentDate}"/>
	  <input type="hidden" name="strReOrderFlgColor" value="${offLineIssueForSpPPBean.strReOrderFlgColor}"/>
	  <input type="hidden" name="strBudgetFlg" value="${offLineIssueForSpPPBean.strBudgetFlg}"/>
	  <input type="hidden" name="strDemandActivePrd" value="${offLineIssueForSpPPBean.strDemandActivePrd}"/>
	  <input type="hidden" name="strIsDemandActiveFlag" value="${offLineIssueForSpPPBean.strIsDemandActiveFlag}"/>
	  
	  <input type="hidden" name="strDemandTypeFlg" />
	  <input type="hidden" name="strTmpIssuingStoreId" />
	  <input type="hidden" name="strTmpRaisingStoreId" />
	  <input type="hidden" name="strAvalaibleBudgetDtl" value="${offLineIssueForSpPPBean.strAvalaibleBudgetDtl}"/>
      <input type="hidden" name="strAvalaibleBudget" value="${offLineIssueForSpPPBean.strAvalaibleBudget}"/>
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
   
       <!-- <div id="blanket" style="display:none;"></div> -->
	   <div class="popUpDiv" id="popUpDiv1" style="display:none;">
		   <table bgcolor="white">
		     <tr>
		      <td>
		          <div id="issueDtlsDivId"  style="display:block;"></div>
		          <div id="stockDtlsDivId"  style="display:block;"></div>
		          <div id="itemOtherDtlsDiv" style="display:block;"></div>
		       </td>
		     </tr>
		   </table>
	   </div>
        
	</div>
	</div>
	</div>
  
</html:form>

<jsp:include page="offLineIssueSPP_itemSearchRow.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex> 
 <script type="text/javascript">

$('.datepicker').each(function(){
    $(this).datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
});
var today=new Date();
var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
var mmm=arr[today.getMonth()];
var hrs=today.getHours();
var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
$('.datepicker').val(dd);

</script>
</body>
</html>