function CheckedFlg(obj,index)
{

  if(obj.checked)
  {	 
	document.getElementById("chkFlg"+index).value='1';
	document.getElementById("strCheckHidValue"+index).disabled=false;
	
  }
  else
  {
  	document.getElementById("chkFlg"+index).value='0';
  	document.getElementById("strCheckHidValue"+index).disabled=true;
  }
}

function cancelSampleForQCCheck() 
  {
 	            var hisValidator = new HISValidator("issueSampleForQcCheckTransFB");
   	hisValidator.addValidation("strStoreName", "dontselect=0",	"Please select a value from Drug Warehouse Name Combo");
	hisValidator.addValidation("strItemCatgCombo", "dontselect=0",	"Please select a value from Item Category Combo");
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	if (retVal) 
	{
    
		    var chkObj = document.getElementsByName("chkFlg");
		   	var len = chkObj.length;		
			var countChk = 0;			
			for ( var i = 0; i < len; i++)
			
				if (chkObj[i].value=='0')
			    {
					 countChk = countChk + 1;
			    } 			    
			if (countChk == len) 
			{
				alert("Please Select at least one record to cancel!!!");				
				return false;
			}
		         var res = prompt("ENTER REMARKS FOR CANCELATION!","");
		         if(!res=="")
		         {
			           var conf = confirm("You Are Going To Cancel  [ "  + (len - countChk) +"  ] Records" );
			           if(confirm(" Are You Sure ?"))
					   {
					   	    document.forms[0].strRemarks.value = res;
			                document.forms[0].hmode.value="CANCELRECORDS";							
							document.forms[0].submit();
			           }
			           else
			           {
			             return false;
			           }
		           
		          }
		          else
		          {
			           if(res=="")
			           { 
			            alert("Enter remarks for CANCELATION");
			           } 
		          }        
  	   	
	}else{
		
		return false;
	}
  	
  }

function GetIndex(index,endVal)  // Pagenation  One
{
	
	
	    for (var page = 1; page <= endVal; page++)       // For Loop To Put Normal CSS in All No
        {
          document.getElementById('pg'+page).className = 'pg-normal';
        }
	    var oldPageAnchor = document.getElementById('pg'+index);   // Apply CSS
        oldPageAnchor.className = 'pg-selected';
        
          for(var i = 1; i <= endVal ; i++)
		  {
			  document.getElementById("DivId"+i).style.display="none";
		  }
		  document.getElementById("DivId"+index).style.display="block";
		
			 
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
	  
	   var StoreCmb   = document.forms[0].strStoreName.value;
	   var ItemCatgCmb   = document.forms[0].strItemCatgCombo.value;
	   
	   if(StoreCmb!=0 && ItemCatgCmb!=0)
       {	
	    var strModeVal 					= "3" ; 
		var strRequestType              = "72";
		var strItemCategory 			= ItemCatgCmb;
		var strFromStoreId 				= StoreCmb;
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strIssueQty');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t','t');
		var testFunction                = "FunctionCalling";
		//var testFunction                = "CallFunc";
		var arg                         = " ";  
		
		var unitMode = "1";  // only base unit  1 Means Only Base Unit Show 0 Means All Unit Show in Unit Combo
		var passValue                   = "5^"+document.forms[0].strReIssueFlagChk.value;
		 
		
		var strMultiRowFetchDataArray 	= new Array('1','11','4','0^strUnitName');
		    
	    var layerIndex = "1";
        //searchItemsWithUserFunction ( strModeVal , strItemCategory , strRequestType, StoreCmb, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg,passValue);
        searchItemsWithUserFunction ( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg,passValue,unitMode);
        
        
        
	  }
	  else
	   {
	   	   if(StoreCmb == 0)
	       {
	           alert("Please Select Drug Warehouse Name!!!! ");
	           StoreCmb.focus();
	       }
	       if(ItemCatgCmb == 0)
	       {
	           alert("Please Select Drug Category!!!!");
	           ItemCatgCmb.focus();
	       }
	    return false;
	 }
	}

function FunctionCalling()
{
  var itemParVal = document.getElementsByName("itemParamValue");
  var issueQty = document.getElementsByName("strIssueQty");
  var reqQty = document.getElementsByName("strReqQty");
  var unitNameCmb = document.getElementsByName("strUnitName");
			
  
  for ( var i = 0; i < itemParVal.length - 1; i++) 
  {
      document.getElementsByName("strUnitName")[i].value='6301^1^0';
	 //issueQty[i].value = "0";	
	  //reqQty[i].value = "";
  }
  

}

function hidePopup() {

	hide_popup('popUpDiv');

}



////////

/**
 * This is the validate function for Off Line Issue Item Details jsp file i.e:-
 * add_OfflineIssueItemDtlTrans_mms.jsp and transfer control to the controller
 * 'INSERT' method.
 */

var parentPopup = "";
var indexglobal = "";

function validateExistingDemand() 
{
	var hisValidator = new HISValidator("offlineIssueIndentBean");
	hisValidator.addValidation("strStoreName", "dontselect=0",	"Please select a value from Drug Warehouse Name");
	hisValidator.addValidation("strItemCatgCombo", "dontselect=0",	"Please select Item Category");
	hisValidator.addValidation("strIndentingStoreID", "dontselect=0","Please select Indenting Drug Warehouse Name");
	
	

	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	if(retVal)
	{
		    var costObj = document.getElementsByName("strFinalCost");
		    var length = costObj.length;
			if (costObj.length == "0") 
			{
				alert("Please Select Existing Demand Item Details");
				return false;
		    }	
		    else
		    {
		    	hisValidator.addValidation("strIssueUnitId", "dontselect=0","Please select a value from Unit Name Combo");
			    var retVal1 = hisValidator.validate();
			
				if (retVal1) 
				{

					var  issueQty = document.getElementsByName("strIssueQty");
					var finalCost = document.getElementsByName("strFinalCost");
	
					
					var count = 0, j = 0;
					for ( var i = 0; i < length; i++) 
					{
						if (issueQty[i].value != "" && issueQty[i].value != "0") 
						{
							count++;
						}
						
					}
					if (count == length) 
					{
					   var avalaibleBudget = document.forms[0].strAvalaibleBudget.value;
					   var  totalAvlBudget = parseFloat(avalaibleBudget);
					   
					   
					   document.forms[0].strApproxAmtDiv.disabled=false;
					   var issueDrugCost   = document.forms[0].strApproxAmtDiv.value;
					   var  totalIssueDrugCost = parseFloat(issueDrugCost);				   
					  
					   if(issueDrugCost!='0.00')
					   {
					   	   if(totalAvlBudget>totalIssueDrugCost)
					   	   {
							hisValidator.addValidation("strReceivedBy", "dontselect=0","Please select Receving Person Name");
							hisValidator.addValidation("strAprovedRemarks", "req","Approved Remarks is a Mandatory Field");
							hisValidator.addValidation("strAprovedRemarks", "maxlen=100","Approved Remarks should have less than or equal to 100 Characters");
							 var retVal2 = hisValidator.validate();
				
					            if (retVal2) 
					            {							            	              										           
										              var conf = confirm("You Are Going To Save Records");
									                  if(conf == true)
									                  {
									                       var conf1 = confirm("Are you sure !!!");
									                       if(conf1 == true)
									                       {
									                          document.forms[0].hmode.value = "SAVEEXISTINGDEMAND";
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
					            
					            }
					            else 
								{
								   return false;
							    }
					   	   }
					   	   else
						   {
						      document.forms[0].strApproxAmtDiv.disabled=true;
						   	  alert("Issue Drug Cost Can Not be Greater than Avalaible Budget!!!");
						   
						   	 return false;
						   }
					   }
					   else
					   {
					   	 document.forms[0].strApproxAmtDiv.disabled=true;
					   	 alert("Issue Drug Cost Can Not be Zero!!!");
					   	 
					   	 return false;
					   }
					}
					else 
					{
						alert("Please Enter Issue Item Qty!!!!");
						var  issueQty = document.getElementsByName("strIssueQty");
						for ( var i = 0; i < length; i++) 
						{
							if ( issueQty[i].value == "" && issueQty[i].value == "0") 
							{
								count = i;
								
							}
							issueQty[count].focus();
						}
						
						retVal = false;
					}
				}
				else 
				{
				   return false;
			    }
		   	
	        }
      }
      else 
	  {
		return false;
	  }
}


function validateNewDemand() 
{
	var saveObj = document.getElementById("saveId");
	
		if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
		{
		saveObj.style.display = "none"; 
		
			var hisValidator = new HISValidator("issueSampleForQcCheckTransFB");
			hisValidator.addValidation("strStoreName", "dontselect=0",	"Please select a value from Drug Warehouse Name Combo");
			hisValidator.addValidation("strItemCatgCombo", "dontselect=0",	"Please select a value from Item Category Combo");
			hisValidator.addValidation("strIndentingStoreID", "dontselect=0","Please select a HQ Name");
			hisValidator.addValidation("strIssueDate", "req","Issue Date is a Mandatory Field");
			hisValidator.addValidation("strIssueDate", "dtltet="+document.forms[0].strCurrentDate.value,"Issue Date should be Less than or Equal to Current Date"); 		
			var retVal = hisValidator.validate();
			hisValidator.clearAllValidations();
			    
			var itemParVal = document.getElementsByName("itemParamValue");
		
			if (retVal) 
			{
				if (document.getElementsByName("itemParamValue").length == "1") 
				{
					alert("Please Search Item Details");
					//document.getElementsByName("strSearchItemButtonDivId")[0].focus();
					saveObj.style.display = '';
					return false;
				} 
				else 
				{
					hisValidator.addValidation("strUnitName", "dontselect=0","Please select a value from Unit Name Combo");
					var retVal1 = hisValidator.validate();
					if (retVal1) 
					{
		
						var issueQty = document.getElementsByName("strIssueQty");
						var length = issueQty.length;
						var count = 0, j = 0;
						for ( var i = 0; i < length - 1; i++) 
						{
							
							document.getElementsByName("strUnitName")[i].disabled=false;
							
							
							if (issueQty[i].value != "" && issueQty[i].value !=0) 
							{
								count++;
							}
						}
						if (count == length - 1) 
						{
									hisValidator.addValidation("strRemarks", "maxlen=100"," Remarks should have less than or equal to 100 Characters");
									 var retVal2 = hisValidator.validate();
									 if (retVal2) 
					                 {
												            var conf = confirm("You Are Going To Save Records");
											                  if(conf == true)
											                  {
											                       var conf1 = confirm("Are you sure !!!");
											                       if(conf1 == true)
											                       {
											                          document.forms[0].hmode.value = "SAVENEWDEMAND";
						                                              document.forms[0].submit();
											                       }
											                      else
											                       {
											                       	 saveObj.style.display = '';
											                         return false;
											                       }
											                   }
											                  else
											                   {
											                   		 saveObj.style.display = '';
											                         return false;
											                   }
					                 }
					                  else
					                   {
					                   		saveObj.style.display = '';
					                        return false;
					                   }
									 
						} 
						else 
						{
							alert("Please Enter Issue Quantity");
							issueQty[0].focus();
							saveObj.style.display = '';
							retVal = false;
						}
					} 
					else 
					{
						saveObj.style.display = '';
						return false;
					}
		
				}
			}
			else
			{
			    saveObj.style.display = '';
				return false;
			}	
		}
		else
		{
		    saveObj.style.display = '';
			return false;
		}		
}



// function called on click of # to view stock details popup
function callStockDetails(obj,index)
{

	if(document.getElementById("strIssueQty"+index).value=="")
	{
		alert("Please Enter Issue Quantity");
		document.getElementById("strIssueQty"+index).focus();
		
	}
	else if(document.getElementById("strIssueUnitId"+index).value=="0")
	{
		alert("Please Select Issue Quantity Unit");
		document.getElementById("strIssueUnitId"+index).focus();
		
	}
    else
    {

			var               hiddenVal =  document.getElementById("strItemDetailsChk"+index).value;
			//alert("hiddenVal-"+hiddenVal); // item id^brandid^RESERVED FLAG^GROUPID^SUBGROUP ID^CONSUMABLE FLAG
												// ^strItemCategory^strRaisingStoreId
			var                    temp = hiddenVal.split("^");
			var                 strMode = "1^"+document.forms[0].strBudgetFlg.value+"^"+index;
			var          strStockStatus = "";
			var            strGenItemId = temp[0];
			var               strItemId = temp[1];
			var             strIssueQty = document.getElementById("strIssueQty"+index).value;
			var       strIssueQtyUnitId = document.getElementById("strIssueUnitId"+index).value;
			var              strUnitObj = document.getElementById("strIssueUnitId"+index);
			var             strUnitName = strUnitObj[strUnitObj.selectedIndex].text;
			 
			var                   temp2 = strIssueQtyUnitId.split("^");
			var  strIssueQtyUnitBaseVal = parseFloat(temp2[1]);
			
			var              strCatCode = temp[6];
			var             strStoreObj = document.forms[0].strStoreName;
			var                 storeId = strStoreObj[strStoreObj.selectedIndex].value;
			var         strReservedFlag = temp[2];
		    var strUserHiddenFieldDivId = "stockDtlsId"+index;
			/*
				alert("strGenItemId-"+strGenItemId); 
				alert("strItemId-"+strItemId); 
				alert("strIssueQty-"+strIssueQty); 
				alert("strIssueQtyUnitBaseVal-"+strIssueQtyUnitBaseVal); 
				alert("storeId-"+storeId); 
				alert("strCatCode-"+strCatCode); 
				alert("strReservedFlag-"+strReservedFlag);
				alert("strUserHiddenFieldDivId-"+strUserHiddenFieldDivId);  
			*/
			
			getStockDtls(strMode, strStockStatus, strGenItemId, strItemId, strIssueQty, strIssueQtyUnitBaseVal, 
									storeId, strCatCode, strReservedFlag, strUnitName, strUserHiddenFieldDivId);
				
			}
}



function checkAvailQtyTwo(index,  qtyName, unitName,costDiv) 
{      
	  
	    var rateObj = document.getElementById("strRate"+""+index).value;
		var qtyObj  = document.getElementById("strAvailableQty"+""+index).value;
       					
			var qty    = qtyObj;	
			var rate   = rateObj;
		
			var total = parseFloat("0.00");
		
			if(isNaN(rate) || rate=="") rate = "0";
			if(isNaN(qty)  || qty=="") qty = "0";
			
			total = rate*qty;
			document.getElementById(costDiv.substring(0,12)+""+index).value = total;
			document.getElementById("strCost"+index).value = total;
			
				totalCost();
	return true;
}

function changeViewMode(chkObj)
{ 	
    if(chkObj.value =='1')
 	{ 	
 		 document.forms[0].strDemandTypeFlg.value = '1'; 
 		 document.forms[0].strIsNormal.checked = true;
 		 document.forms[0].strIsUrgent.checked = false;
 	}
 	if(chkObj.value =='2')
 	{ 		 
 		 
 		 document.forms[0].strDemandTypeFlg.value = '0'; 
        
         document.forms[0].strIsNormal.checked = false;
 		 document.forms[0].strIsUrgent.checked = true;
 	}
}



// function called on enter issue qty to check the validation of issue qty

function QtyValidation(index)
{
		if(document.getElementById("strIssueUnitId"+index).value!="0" && document.getElementById("strIssueQty"+index).value!="")
		{
			var issueQty = document.getElementById("strIssueQty"+index).value;
			var issueQtyUnit = document.getElementById("strIssueUnitId"+index).value;
			var temp = issueQtyUnit.split("^");
			var issueQtyUnitBaseVal = temp[1];
			var isDecimalAllow = temp[2];
			
			if (issueQty.indexOf('.') > -1 && temp[2] == '0') 
			{
			
						alert("Issue Quantity must be an Integer ");
						document.getElementById('strIssueQty'+index).value = "";
						document.getElementById('strIssueUnitId'+index).value = "0"
						return false;
						
			}
			
			var issueQtyUnitVal = parseFloat(issueQty)*parseFloat(issueQtyUnitBaseVal);
			var sancQtyBaseVal =  document.getElementById("strBalQtyBaseVal"+index).value;
			var avlQtyBaseVal = document.getElementById("strAvlQtyBaseVal"+index).value;;
				//alert("sancQtyBaseVal-"+sancQtyBaseVal);
				//alert("issueQtyUnitVal-"+issueQtyUnitVal); 
				//alert("avlQtyBaseVal-"+avlQtyBaseVal); 
			
				if(parseFloat(avlQtyBaseVal)<issueQtyUnitVal)
				{
					alert("Issue Quantity cannot be greater than Available Quantity");
					document.getElementById('strIssueUnitId'+index).value = "0";
					document.getElementById("strIssueQty"+index).value="0";
					return false;
				}
				if(parseFloat(sancQtyBaseVal)<issueQtyUnitVal)
				{
					alert("Issue Quantity cannot be greater than Sanction Quantity");
					document.getElementById('strIssueUnitId'+index).value = "0";
					document.getElementById("strIssueQty"+index).value="0";
					return false;
				}
			
		}
}


// function called on enter issue qty to check the validation of issue qty

function issueQtyValidationTwo(index) 
{
	if (document.getElementById("strUnitName" + index).value != "0"	&& document.getElementById("strPendIssueQty" + index).value != "") 
	{
		var issueQty      = document.getElementById("strPendIssueQty" + index).value;
		var issueQtyUnit  = document.getElementById("strUnitName" + index).value;
		var reqQty        = document.getElementById("strReqQty" + index).value;
		var avlQtyBaseVal = document.getElementById("strAvlQty" + index).value;
	    var rate          = document.getElementById("strRate" + index).value;
		
		if (parseFloat(reqQty) < issueQty) 
		{
			alert("Issue Quantity cannot be greater than Requested Quantity");
			//document.getElementById('strUnitName' + index).value = "0";
			document.getElementById("strPendIssueQty" + index).value = 0;
			calculateCostTwo(index);
			return false;
		}
		if (parseFloat(avlQtyBaseVal) < issueQty) 
		{
			alert("Issue Quantity cannot be greater than Avalaible Quantity");
			//document.getElementById('strUnitName' + index).value = "0"
			document.getElementById("strPendIssueQty" + index).value = 0;
			calculateCostTwo(index);
			return false;
		}

	} 
	else 
	{
		if(document.getElementById("strUnitName" + index).value == "0") 
		{
			alert("Please Select Unit!!!");
		}
		/*
		if(document.getElementById("strIssueQty" + index).value == "") {
			document.getElementById("strIssueQty" + index).value = 0;
		}
		*/
		
		return false;

	}
	calculateCostTwo(index);
}




/*
	Description >> This JS function is used to calculate tariff cost for a single tariff
	Return Value >> Returns Tariff Cost
*/
function calTariffCost(qty,qty_base_value,rate,rate_base_value,mode) 
{
	//initilize variavles
	var totCost = 0.0;
	
	//business logic
	if(rate_base_value > 0) 
	{		//if it is 0 then result will be infinite
		totCost = parseFloat((qty * qty_base_value) * (rate/rate_base_value));
		alert(totCost);
	}
	
	if(mode == 1) totCost = manipulateValue(0,totCost,1);
	
	//return value;
	return roundValue(totCost,2);
}


function calculateCostTwo(index) 
{      
	  
	    var rateObj = document.getElementById("strRate"+index).value;
		var qtyObj  = document.getElementById("strPendIssueQty"+index).value;
       					
			var qty    = qtyObj;	
			var rate   = rateObj;
		
			var total = parseFloat("0.00");
		
			if(isNaN(rate) || rate=="") rate = "0";
			if(isNaN(qty)  || qty=="") qty = "0";
			
			total = rate*qty;
			document.getElementById("strPendQtyCost"+index).value = total;
			
			totalCostTwo();
			
	return true;
}

function totalCostTwo()
{	   
       	    var costObj = document.getElementsByName("strPendQtyCost");
			var total = parseFloat("0.00");
					
		   	if (costObj.length > 0) 
			{
		        
				for ( var i = 0; i <costObj.length-1; i++)
				{		        	
					costObj[i].disabled=false;
					total = total + parseFloat(costObj[i].value);
					costObj[i].disabled=true;
		 		}
		
			}

	    total = roundValue(total, 2);
	    document.getElementById("strTotalPendCostDivId").disabled = false;
	    document.getElementById("strTotalPendCostDivId").value = total;
	     document.getElementById("strTotalPendCostDivId").disabled = true;
        document.forms[0].strApproxPendAmt.value=total;
       
}




// function called on enter issue qty to check the validation of issue qty

function issueQtyValidation(index) 
{
	if (document.getElementById("strUnitName" + index).value != "0"	&& document.getElementById("strIssueQty" + index).value != "") 
	{
		var issueQtyUnit  = document.getElementById("strUnitName" + index).value;
		var issueQty      = (document.getElementById("strIssueQty" + index).value)*(issueQtyUnit.split("^")[1]);
		var reqQty        = document.getElementById("strIssueQty" + index).value;
		var temp          = document.getElementById("itemCalcValue" + index).value.split("^");
		var avlQtyBaseVal = temp[0];
       
		if (parseFloat(reqQty) < parseFloat(issueQty))
		{
			alert("Issue Quantity cannot be greater than Requested Quantity");
			document.getElementById("strIssueQty" + index).value = "0";
			 document.getElementById("strUnitName" + index).value = "0";
			//calculateTotalCost(index);
			return false;
		}
		if (parseFloat(avlQtyBaseVal) < parseFloat(issueQty)) 
		{
			alert("Issue Quantity cannot be greater than Avalaible Quantity");
			document.getElementById("strIssueQty" + index).value = "0";
			 document.getElementById("strUnitName" + index).value = "0";
			//calculateTotalCost(index);
			return false;
		}

	} 
	else 
	{
		if(document.getElementById("strUnitName" + index).value == "0") 
		{
			alert("Please Select Unit!!!");
		}
			
		return false;

	}
	//calculateTotalCost(index);
}


function totalIssueCost()
{
       	    var costObj = document.getElementsByName("strFinalCost");
			var total = parseFloat("0.00");
			
		   	if (costObj.length > 0) 
			{
		        
				for ( var i = 0; i <costObj.length; i++)
				{		        					
					
					total = total + parseFloat(document.getElementById("strFinalCost"+i).value);
		 		}
		
			}

	    total = roundValue(total, 2);
	    document.getElementById("strApproxAmtDiv").disabled = false;
	    document.getElementById("strApproxAmtDiv").value = total;
	     document.getElementById("strApproxAmtDiv").disabled = true;
        document.forms[0].strFinalApproxAmtDiv.value=total;
       
}
function calUnitBaseCost(mode,index,selected_obj)
{
            
				    
		    var issueQtyUnit  = document.getElementById("strUnitName" + index).value;
		    var issueQty      = (document.getElementById("strIssueQty" + index).value)*(issueQtyUnit.split("^")[1]);
		   
		    var reqQty        = document.getElementById("strReqQty" + index).value;
		    var temp          = document.getElementById("itemCalcValue" + index).value.split("^");
		    var avlQtyBaseVal = temp[0];
		   if(document.getElementById("strUnitName" + index).value!='0')
		   {
		    if (parseFloat(reqQty) < parseFloat(issueQty))
		    {
			  alert("Issue Quantity cannot be greater than Requested Quantity");
			  document.getElementById("strIssueQty" + index).value = "0";
			   document.getElementById("strUnitName" + index).value = "0";
			  calculateTotalCost(index);
			  return false;
		    }
		    else
		    {
			    if (parseFloat(avlQtyBaseVal) < parseFloat(issueQty)) 
			    {
				  alert("Issue Quantity cannot be greater than Avalaible Quantity");
				  document.getElementById("strIssueQty" + index).value = "0";
				  document.getElementById("strUnitName" + index).value = "0";
				  calculateTotalCost(index);
				   return false;
			    }
			    else
			    {
			    	var  temp1          = document.getElementById("itemCalcValue" + index).value.split("^");
                    var  rateObj        = temp1[1];
	   
		            var  qtyObj         = document.getElementById("strIssueQty"+index).value;
		            var  qty_base_value = selected_obj.value.split("^")[1];
		            
		            var qty    = qtyObj;	
					var rate   = rateObj;
				
					var total = parseFloat("0.00");
				
					if(isNaN(rate) || rate=="") rate = "0";
					if(isNaN(qty)  || qty=="") qty = "0";
				    if(qty=='0')		
					{
					  qty_base_value = '0';	
					  total = parseFloat(qty * qty_base_value * rate);
					}
					else
					{
					  total = parseFloat(qty * qty_base_value * rate);
					} 			
							
					
					document.getElementById("strCost"+index).value = total;
					
					totalCostforNewDemand();
			    	
			    }
			    
		    }
		
		 }
		 else
		 {
		 	document.getElementById("strCost"+index).value = "0.00";
		 	totalCostforNewDemand();
		 }
       					
			
   
      
}




function calculateTotalCost(index) 
{      
	    var  temp1          = document.getElementById("itemCalcValue" + index).value.split("^");
        var  rateObj        = temp1[1];
	   
		var  qtyObj         = document.getElementById("strIssueQty"+index).value;
		var  qty_base_value = document.getElementById("strUnitName"+index).value.split("^")[1];
		
       					
			var qty    = qtyObj;	
			var rate   = rateObj;
		
			var total = parseFloat("0.00");
		
			if(isNaN(rate) || rate=="") rate = "0";
			if(isNaN(qty)  || qty=="") qty = "0";
			if(qty=='0')		
			{
			  qty_base_value = '0';	
			  total = parseFloat(qty * qty_base_value * rate);
			}
			else
			{
			  total = parseFloat(qty * qty_base_value * rate);	
			} 
			document.getElementById("strCost"+index).value = total;
			
			totalCostforNewDemand();
			
	return true;
}

function totalCostforNewDemand()
{	   
       	    var costObj = document.getElementsByName("strCost");
			var total = parseFloat("0.00");
			//alert(costObj.length);
		   	if (costObj.length > 0) 
			{
		       
				for ( var i = 0; i <costObj.length; i++)
				{		        	
						
					total = total + parseFloat(costObj[i].value);
		 		}
		
			}

	    total = roundValue(total, 2);
	    document.getElementById("strNewDemandApproxAmtDivId").value = total;
        document.forms[0].strNewDemandFinalApproxAmt.value=total;
       
}


function totalCost()
{	   
       	    var costObj = document.getElementsByName("strCost");
			var total = parseFloat("0.00");
			//alert(costObj.length);
		   	if (costObj.length > 0) 
			{
		       
				for ( var i = 1; i <costObj.length; i++)
				{		        	
						
					total = total + parseFloat(document.getElementById("strCost"+i).value);
		 		}
		
			}

	    total = roundValue(total, 2);
	    document.getElementById("strTotalCostDivId").value = total;
        document.forms[0].strApproxAmt.value=total;
       
}

/**
 * This Method is used for Avalaible Budget Pop-Up
 * Created By Amit Kumar 10-Aug-2011
 */


function avlBudgetDtl(obj) 
{

	parentPopUp = obj;

	var strBalQtyDetail = document.forms[0].strAvalaibleBudgetDtl.value;

	myArray = strBalQtyDetail.split("$$");

	var objVal1 = document.getElementById("1");

	if (myArray[0] != 'null' || myArray[0] != '') 
	{
		objVal1.innerHTML = myArray[0];
	} 
	else 
	{
		objVal1.innerHTML = "  ----";
	}

	var objVal2 = document.getElementById("2");

	if (myArray[1] != 'null') 
	{
		objVal2.innerHTML = myArray[1];
	} 
	else 
	{
		objVal2.innerHTML = "  ----";
	}

	display_popup_menu(parentPopUp, 'avalaibleBudgetDtlId', '300', '');

}





function hideBalQtyDetails(divId) {
	hide_popup_menu(divId);
}


function reqQtyValidation(index) 
{
	// if(document.getElementById("strIssueQty"+index).value >
	// document.getElementById("strReqQty"+index).value)
	document.getElementById("strIssueQty" + index).value = "0";
	
	if (document.getElementById("strUnitName" + index).value != "0" && document.getElementById("strReqQty" + index).value != "") 
	{

		/*
		var reqQty = document.getElementById("strReqQty" + index).value;
		var temp = document.getElementById("itemCalcValue" + index).value
				.split("^");
		var avlQtyBaseVal = temp[0];

		if (parseFloat(avlQtyBaseVal) < reqQty) 
		{
			alert("Request Quantity cannot be greater than Avalaible Quantity!!");
			//document.getElementById('strUnitName' + index).value = "0";
			document.getElementById('strReqQty' + index).value = "0";
			document.getElementById("strIssueQty" + index).value = "0";
			return false;
		}
		
        alert("Request Quantity cannot be greater than Avalaible Quantity!!");
        return false; 
       */
	} 
	else 
	{
	
		if (document.getElementById("strUnitName" + index).value == "0")
		{
			alert("Please Select Unit!!!");
			document.getElementById("strUnitName" + index).focus();
		}
		if (document.getElementById("strReqQty" + index).value != "")
		{
			document.getElementById("strReqQty" + index).value = "0";
			document.getElementById("strIssueQty" + index).value = "0";
		}

		return false;

	}
	calculateTotalCost(index);

}

function showOrHideStockDetails(thisImg)
{
	
	   var prevRcd   = document.getElementsByName("checkid");
       var myArray   = new Array();
       var myArray1  = new Array();
       var count     = parseInt("0");
       for(var x=0;x<prevRcd.length;x++)
       {               
             if(prevRcd[x].checked)
             {          	
             	count = count +1;
             }             
       }   
       
	   if(count=='0')
  	   {
		 	if (thisImg == null) 
		 	{
				alert("Cannot find this image object.");
			}
			if (thisImg.title == "Show") 
			{
				// Change Image Attribute
				thisImg.src = "../../hisglobal/images/plus.gif";
				thisImg.title = "Hide";
				document.getElementById("newDemandDivID").style.display='none';
				
				document.getElementById("existingDemandId").style.display="block";
	            document.getElementById("newDemandId").style.display="none";
								
			}
			else
			{  
				thisImg.src = "../../hisglobal/images/minus.gif";
				thisImg.title = "Show";
				document.getElementById("newDemandDivID").style.display='block';
				document.getElementById("existingDemandId").style.display="none";
	            document.getElementById("newDemandId").style.display="block";
			}
  	   }
  	   else
  	   {
  	   	 alert("Pending Demand in Processing!!!");
  	   	 return false;
  	   }		
 } 



function view1(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="none";
	document.getElementById(obj2).style.display="block";
	document.getElementById(obj3).style.display="block";
	document.getElementById("existingDemandId").style.display="block";
	document.getElementById("newDemandId").style.display="none";
}
function view2(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="block";
	document.getElementById(obj2).style.display="none";
	document.getElementById(obj3).style.display="none";
	document.getElementById("existingDemandId").style.display="none";
	document.getElementById("newDemandId").style.display="block";
}

function GetIndex(index,endVal)  // Pagenation  One
{
	
	    for (var page = 1; page <= endVal; page++)       // For Loop To Put Normal CSS in All No
        {
          document.getElementById('pg'+page).className = 'pg-normal';
        }
	    var oldPageAnchor = document.getElementById('pg'+index);   // Apply CSS
        oldPageAnchor.className = 'pg-selected';
        
          for(var i = 1; i <= endVal ; i++)
		  {
			  document.getElementById("DivId"+i).style.display="none";
		  }
		  document.getElementById("DivId"+index).style.display="block";
			 
}

function checkDemand()
{	
	if(document.forms[0].demandFlg.value=='1')
	{
		 document.getElementById("newDemandTab").style.display="none";
		 document.getElementById("newDemandDivID").style.display="none";
	}
	else
	{
		 document.getElementById("newDemandTab").style.display="block";
		 document.getElementById("newDemandDivID").style.display="block";
	}
	
}
function chkBoxClick(obj,index)
{	  
	
	    var objValue  = document.forms[0].strStoreName;
        var objValue1 = document.forms[0].strIndentingStoreID;

         document.forms[0].strTmpIssuingStoreId.value = objValue.options[objValue.selectedIndex].value;
				
		 document.forms[0].strTmpRaisingStoreId.value = objValue1.options[objValue1.selectedIndex].value;
	  
	  /* Value Pass in Mode Name
	    	    1. C.HSTNUM_REQ_NO 
	    	    2. C.HSTNUM_STORE_ID , 
	            3. C.GNUM_HOSPITAL_CODE,
	            4. count_urgent 
	            5. c.URGENT_FLG 
	            6. C.HSTNUM_REQ_NO 
	            7. C.REQ_DATE 
	            8. C.RAISING_STORE 
	            9. C.CATEGORY 
	            10.C.LST_ISSUE_DATE  
	    	 */    	
	    	 
	   var hiddenVal = document.getElementById("strCheckHidValue"+index).value; 
	   
	   document.forms[0].strTmpIndentNo.value = hiddenVal.split("^")[0];  	
	   document.forms[0].strTmpIndentDate.value = hiddenVal.split("^")[6]; 
	   
	   
	  
       var prevRcd   = document.getElementsByName("checkid");
       var myArray   = new Array();
       var myArray1  = new Array();
       var count     = parseInt("0");
       for(var x=0;x<prevRcd.length;x++)
       {               
             if(prevRcd[x].checked)
             {          	
             	count = count +1;
             }             
       }     
       if(count>'1')
       {
         	  for(var i = 0 ; i < prevRcd.length ; i++)
	           {
	            
	                 prevRcd[i].checked = false;
	              
	           }
	           alert("Please Select Single Demand!!!");
	           
		       return false;        
         	
       }
       else
       {
       	 
       	 
	       	 if(count=='1')
	         {
	         	    
				    document.getElementById("checkid"+index).value = '1';
				    document.getElementById("newDemandTab").style.display="none";
				    document.getElementById("newDemandDivID").style.display="none";
				    
				    
				    getPendingDemandDetails(index);
	         }
	         if(count=='0')
	         {
	         	     document.getElementById("checkid"+index).value = '0';
	         	     document.getElementById("pendingIndentDetailsID").innerHTML="";
	         	     document.getElementById("pendingIndentItemDetailsID").innerHTML="";
	         	     
	         	     document.getElementById("itemHeader").style.display="none";
	         	     document.getElementById("newDemandTab").style.display="block";
				  	 document.getElementById("newDemandDivID").style.display="block";
				  	 
				  	 
				  	 
	         	   	    
	         	
	         }
       	 
       	
       }
	
}




function cancel() {
	document.forms[0].hmode.value = "INITIALPAGE";
	document.forms[0].submit();
}

/**
 * 
 */
function initPage()
{
    document.getElementsByName("strStoreName")[0].value="0";
	document.forms[0].hmode.value = "FIRSTDATA";
	document.forms[0].submit();
}

function cancel() {
	document.getElementById("errMsg").innerHTML = "";
	document.forms[0].hmode.value = "CANCEL";
	document.forms[0].submit();
}

function getItemCategoryCombo() 
{
		
	var temp =null;
	if(document.forms[0].strStoreName!=null)
	 {
		temp = document.forms[0].strStoreName.value;
	}
	if(temp==null || temp=="" || temp=="0") 
	{
		var objVal = document.getElementById("ItemCatg");
		objVal.innerHTML = "<select name = 'strItemCatgCombo' onchange='getHQNameStoreCombo();' class='comboNormal'><option value='0'>Select Value</option></select>";
		return;
	}
	var mode = "ItemCatgoryCombo";
	var url = "IssueSampleForQcCheckTransCNT.cnt?hmode=" + mode + "&modName="+ temp;

	ajaxFunction(url, "2");
	
	var objVal1 = document.getElementById("IndentingStore");
	objVal1.innerHTML = "<select name = 'strIndentingStoreID' class='comboNormal'><option value='0'>Select Value</option></select>";
    document.getElementById("id1").innerHTML="";

}
function getPendingDemandDetails(index)
{
	 var hiddenVal = document.getElementById("strCheckHidValue"+index).value; 
	 var  objValue = document.forms[0].strStoreName;
     var     temp1 = objValue.options[objValue.selectedIndex].value;
	 	
	 if(document.forms[0].strIsDemandActiveFlag.value=='1')
     {  
			if (document.forms[0].strIsView.value == '0') 
			{
			  					
				var mode = "GetPendingIndentDetails";
				var url = "IssueSampleForQcCheckTransCNT.cnt?hmode=" + mode + "&modName="+hiddenVal+"&issueStoreName="+temp1+"&avlBudget="+document.forms[0].strAvalaibleBudget.value+"&budgetFlg="+document.forms[0].strBudgetFlg.value;
				
				ajaxFunction(url, "10");
			  
			  
			}
	  }
	  else
	  {
	  	return false;
	  }	
}

function getApprovedByCombo() 
{
	var temp =null;
	if(document.forms[0].strStoreName!=null) 
	{
		temp = document.forms[0].strStoreName.value;
	}
	if(temp==null || temp=="" || temp=="0") 
	{
		var objVal = document.getElementById("ApprovedBy");
		objVal.innerHTML = "<select name = 'strApprovedBy'  class='comboNormal'><option value='0'>Select Value</option></select>";
		return;
	}
	var mode = "ApprovedByCombo";
	var url = "IssueSampleForQcCheckTransCNT.cnt?hmode=" + mode + "&modName=" + temp;
    ajaxFunction(url, "7");
}
function getHQNameStoreCombo() 
{

	if(document.forms[0].strItemCatgCombo.value=="0")
   {
	
   	
   		alert("Please select drug category.");
   		var objVal1 = document.getElementById("IndentingStore");
   	 	objVal1.innerHTML = "<select name = 'strIndentingStoreID' class='comboNormal'><option value='0'>Select Value</option></select>";
   	 	//document.getElementById("pendingDemandDivID").innerHTML="";
   	 	document.getElementById("id1").innerHTML="";
//   		document.forms[0].strIndentNo.value="";
//   		document.forms[0].strIndentPeriodValue.value="";
   		document.forms[0].strItemCatgCombo.focus();
   		return false;
   }
//	if (document.forms[0].strIsView.value == '0') 
	{
	
		
		var temp = document.forms[0].strItemCatgCombo.value;
		var objValue = document.forms[0].strStoreName;
		var temp1 = objValue.options[objValue.selectedIndex].value;
		var mode = "HQNameStoreCombo";
		var url = "IssueSampleForQcCheckTransCNT.cnt?hmode=" + mode + "&modName="
				+ temp1 + "^" + temp;
		ajaxFunction(url, "1");
		
	}
	document.getElementById("id1").innerHTML="";
//	document.forms[0].strIndentNo.value="";
//	document.forms[0].strIndentPeriodValue.value="";

}


function getApprovedVerifyCombo()
{
			
	var objValue = document.forms[0].strStoreName;
	var temp = objValue.options[objValue.selectedIndex].value;

	var objValue1 = document.forms[0].strIndentingStoreID;
	var temp1 = objValue1.options[objValue1.selectedIndex].value;
	
    document.forms[0].strTmpIssuingStoreId.value = temp;
				
	document.forms[0].strTmpRaisingStoreId.value = temp1;
	

	var mode = "ApprovedVerifyCombo";
	var url = "IssueSampleForQcCheckTransCNT.cnt?hmode=" + mode + "&modName="
			+ temp + "^" + temp1;
	ajaxFunction(url, "6");

}

function getIndentStoreBudgetDetails() 
{
	
	var objValue = document.forms[0].strStoreName;
	var temp = objValue.options[objValue.selectedIndex].value;

	var objValue1 = document.forms[0].strIndentingStoreID;
	var temp1 = objValue1.options[objValue1.selectedIndex].value;

	var mode = "GetStoreBudget";
	var url = "IssueSampleForQcCheckTransCNT.cnt?hmode=" + mode + "&modName="
			+ temp + "^" + temp1;
	ajaxFunction(url, "8");

}

function getAjaxResponse(res, mode) {

	var err = document.getElementById("errMsg");
	var temp = res.split("####");
	if (temp[0] == "ERROR") {
		err.innerHTML = temp[1];
		return;
	}
	if (mode == "1") {
		var objVal1 = document.getElementById("IndentingStore");
		objVal1.innerHTML = "<select name = 'strIndentingStoreID' onchange='getApprovedVerifyCombo();' class='comboMax'>"
				+ res + "</select>";
				
			   	 
				
	}
	if (mode == "2") 
	{
		
		var objVal = document.getElementById("ItemCatg");
		objVal.innerHTML = "<select name = 'strItemCatgCombo' onchange='getHQNameStoreCombo();' class='comboMax'>"
				+ res + "</select>";
				
				
	}

	if (mode == "3") {
		var objVal = document.getElementById("ItemCatgViewId");
		objVal.innerHTML = "<select name = 'strItemCatgCombo' onchange='getGroupNameCombo();' class='comboMax'>"
				+ res
				+ "</select>"
				+ " <img src='../../hisglobal/images/Go.png'"
				+ "onClick='getViewItemDtl();' align='top' style='cursor: pointer; ' title='Click Here To View Breakage Item Details'>";
	}
	if (mode == "4") {

		var storeName = document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].text;
		var itemCategName = document.forms[0].strItemCatgCombo[document.forms[0].strItemCatgCombo.selectedIndex].text;

		document.getElementById("breakageItemDtlId").innerHTML = res;
		document.getElementById("breakageItemDtlId").style.display = "block";
		/*
		 * document.getElementById("ItemCatgViewId").style.display="none";
		 * document.getElementById("storeComboNameID").style.display="none";
		 * document.getElementById("storeComboID").innerHTML=storeName;
		 * document.getElementById("itemCategViewNameID").innerHTML=itemCategName;
		 * document.getElementById("storeComboNameID").style.display="block";
		 * document.getElementById("itemCategViewNameID").style.display="block";
		 */
	}
	if (mode == "5") {

		temp = res.split("@");
		i = temp[2];
		document.getElementById("IssueItempopup").innerHTML = temp[0];
		document.getElementById("IssueItempopup").style.display = "block";
		display_popup_menu(parentPopup, 'IssueItempopup', '', '');

	}
	if (mode == "6")
	{

		
		//document.getElementById("ApprovedBy").innerHTML = "<select name = 'strApprovedBy' class='comboNormal' >"
				//+ temp[0] + "</select>";
		
//		document.getElementById("VerifiedBy").innerHTML = "<select name = 'strVerifiedBy' class='comboMax'>"+ res + "</select>";
//		document.getElementById("ReceivedBy").innerHTML = "<select name = 'strReceivedBy' class='comboMax'>"+ res + "</select>";
				getIndentStoreBudgetDetails(); 
		

	}
	if (mode == "7") 
	{
		var objVal = document.getElementById("ApprovedBy");
		objVal.innerHTML = "<select name = 'strApprovedBy'  class='comboMax'>"+ res + "</select>";
	}
	if (mode == "8") 
	{
		
		temp = res.split("##");
		document.forms[0].strAvalaibleBudgetDtl.value=temp[1];
		document.forms[0].strAvalaibleBudget.value=temp[0];
		
	
	}
	if (mode == "9") 
	{
		getApprovedByCombo();
		var objVal = document.getElementById("pendingDemandDivID");
		objVal.innerHTML =  res;
	}
	
	if (mode == "10") 
	{
		
		temp = res.split("$$$$$$");
		
		document.getElementById("itemHeader").style.display="block";
		var objVal = document.getElementById("pendingIndentItemDetailsID");
		objVal.innerHTML =  temp[1];
		var objVal = document.getElementById("pendingIndentDetailsID");
		objVal.innerHTML =  temp[0];
	}
	
	
	
	
	
}
function hideDataDiv()
{
	    document.getElementById("breakageItemDtlId").innerHTML = "";
		document.getElementById("breakageItemDtlId").style.display = "none";
	
}
function getItemCategoryComboViewPage() {

	var temp = document.forms[0].strStoreName.value.split("^");
	var mode = "ItemCatgoryCombo";
	var url = "IssueSampleForQcCheckTransCNT.cnt?hmode=" + mode + "&modName="
			+ temp[0];
	ajaxFunction(url, "3");
}

function transferToViewPage() 
{
	if (document.getElementsByName("strViewChk")[0].checked) 
	{
		document.forms[0].hmode.value = "VIEWPAGE";
		document.forms[0].submit();
	}
}

function clearViewPage()
{
	document.forms[0].hmode.value = "VIEWPAGE";
	document.forms[0].submit();
}


function getViewItemDtl() 
{

	var hisValidator = new HISValidator("issueSampleForQcCheckTransFB");

	hisValidator.addValidation("strStoreName", "dontselect=0","Please Select a District Drug Warehouse Name");
	hisValidator.addValidation("strItemCatgCombo", "dontselect=0","Please Select a Drug Category");
	hisValidator.addValidation("strFromDate", "req","From Date is a Mandatory Field");
	hisValidator.addValidation("strToDate", "req","To Date is a Mandatory Field");
	
	//hisValidator.addValidation("strToDate", "dtgtet="+document.forms[0].strFromDate.value,"To Date should be Greater Than or Equal From Date");
		
	var retVal = hisValidator.validate();
	
	
	var diffdate = dateDiff1(document.forms[0].strFromDate.value,document.forms[0].strToDate.value); 
  
     if(parseInt(diffdate)>365)
     {
        alert("Difference Between From Date and To Date Should not be greater than 365 days");
		return false;
	 }

	if (retVal)
	{
	
		var temp = document.forms[0].strStoreName.value;
		
		var mode = "GOVIEWPAGE";
		var url = "IssueSampleForQcCheckTransCNT.cnt?hmode=" + mode + "&storeId="
				+ temp + "&itemCatNo="
				+ document.forms[0].strItemCatgCombo.value + "&fromDate="
				+ document.forms[0].strFromDate.value + "&ToDate="
				+ document.forms[0].strToDate.value+"&searchType="+document.forms[0].strSearchNameType.value;
		ajaxFunction(url, "4");
	}
	else
	{
		return false;
	}  
}


function showPopUp(obj, i) 
{
	indexglobal = i;
	parentPopup = obj;

	var mode = "GETPOPUP";
	var url = "IssueSampleForQcCheckTransCNT.cnt?hmode=" + mode + "&hiddenVal="
			+ document.getElementById('strHlpIssueNo' + i).value + "&index="
			+ i + "&storeId=" + document.forms[0].strStoreName.value
			+ "&itemCatNo=" + document.forms[0].strItemCatgCombo.value
			+ "&fromDate=" + document.forms[0].strFromDate.value + "&ToDate="
			+ document.forms[0].strToDate.value;
	// alert("url-"+url);
	ajaxFunction(url, "5");

}

// function to show report after save data
function getReport() {

//	var issueNo = document.forms[0].strTmpIssueNo.value;
//	var storeId = document.forms[0].strTmpStoreNo.value;
//	var IndentNo = document.forms[0].strTmpIndentNo.value;
//	var IndentDate = document.forms[0].strTmpIndentDate.value

//	if (issueNo != "0") {
	//	getIssueDtls('2', storeId, issueNo, IndentNo, IndentDate);
//	}
//	document.forms[0].strTmpIssueNo.value = "0";
}

function generateIssueReportFunc(obj, i) {
	indexglobal = i;
	parentPopup = obj;
	var issueNo = document.getElementById('strHlpIssueNo' + i).value;
	var storeId = document.forms[0].strStoreName.value;
	var IndentNo = document.getElementById('strHlpIndentNo' + i).value;
	var IndentDate = document.getElementById('strHlpIndentDate' + i).value
	// alert("IssueNo::"+issueNo+"::Store ID::"+storeId+"::Indent
	// No::"+IndentNo+"::Indent date::"+IndentDate);
	if (issueNo != "0") {
		getIssueDtls('2', storeId, issueNo, IndentNo, IndentDate);
	}

}



function setDefaultValue(elementQty) 
{
	if(elementQty.value=="") 
	{
		elementQty.value="0";
	}
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
	 

function drugDtl(obj,index) 
{
	parentPopUp = obj;

	var strBalQtyDetail = document.getElementById("strPrintLabelValue"+index).value;

	myArray = strBalQtyDetail.split("^");

	/*
	 * 1. HSTSTR_PO_NO, 
	 * 2. HSTDT_PO_DATE, 
	 * 3.  expiryDate,
	 * 4.  mfgDate,
	 * 5. HSTNUM_IS_REISSUE, 
    1.  receiveDate, 
	2.  storeName,
	3.  itemName,
	4.  batch no
	5.  mfgDate,
	6.  expiryDate,
	7.  issueQty,
	8.  HSTNUM_QC_ISSUE_NO, 
	9.  HSTNUM_ITEMBRAND_ID, 
	10.  HSTSTR_ITEM_SL_NO, 
	11. HSTNUM_STOCK_STATUS_CODE,
	12. HSTNUM_TOSTORE_ID, 
	13. HSTNUM_INHAND_QTY, 
	14. HSTNUM_INHANDQTY_UNITID, 
	15. HSTNUM_RATE, 
	16. HSTNUM_RATE_UNITID, 
	17. HSTNUM_SUPPLIER_ID, 
	18. HSTNUM_MFG_ID, 
	19. HSTSTR_PO_NO, 
	20. HSTDT_PO_DATE, 
	21. HSTDT_RECEIVE_DATE, 
	22. HSTNUM_IS_REISSUE, 
	23. GSTR_REMARKS, 
	24. HSTDT_FINANCIAL_START_DATE, 
	25. HSTDT_FINANCIAL_END_DATE, 
	26. GDT_ENTRY_DATE, 
	27. GNUM_SEATID, 
	28  GNUM_ISVALID
 */


	var objVal1 = document.getElementById("1");
	
	if (myArray[0] != 'null' || myArray[0] != '') 
	{
		objVal1.innerHTML = myArray[0];
	} 
	else 
	{
		objVal1.innerHTML = "  ----";
	}

	var objVal2 = document.getElementById("2");

	if (myArray[1] != 'null' || myArray[1] != '') 
	{
		objVal2.innerHTML = myArray[1];
	} 
	else 
	{
		objVal2.innerHTML = "  ----";
	}


    var objVal3 = document.getElementById("3");

	if (myArray[2] != 'null' || myArray[2] != '') 
	{
		objVal3.innerHTML = myArray[2];
	} 
	else 
	{
		objVal3.innerHTML = "  ----";
	}
	
	var objVal4 = document.getElementById("4");

	if (myArray[3] != 'null' || myArray[3] != '') 
	{
		objVal4.innerHTML = myArray[3];
	} 
	else 
	{
		objVal4.innerHTML = "  ----";
	}
	
	var objVal5 = document.getElementById("5");

	if (myArray[4] != 'null' || myArray[4] != '') 
	{
		objVal5.innerHTML = myArray[4];
	} 
	else 
	{
		objVal5.innerHTML = "  ----";
	}
     
     

	display_popup_menu(parentPopUp, 'drugDtlId', '300', '');

}
	 

function hideDrugDetails(divId) 
{
	hide_popup_menu(divId);
}



function setReIssueValue()
{
	   document.getElementById("searchItemsDtlsDivId").innerHTML="";    
	if(document.getElementsByName("strReIssueChk")[0].checked==true)
	{
		document.forms[0].strReIssueFlag.value='1';		
		document.forms[0].strReIssueFlagChk.value='1';		
	}
	else
	{
		document.forms[0].strReIssueFlag.value='0';		
		document.forms[0].strReIssueFlagChk.value='0';
	}
}

