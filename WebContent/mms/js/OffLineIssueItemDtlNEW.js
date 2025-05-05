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
					   	   //if(totalAvlBudget>totalIssueDrugCost)
					   	  // {
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
						                   	     					     
												  document.forms[0].hmode.value="SAVEEXISTINGDEMAND";						  
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
					   	 //  }
					   	//   else
						//   {
						   //   document.forms[0].strApproxAmtDiv.disabled=true;
						   	//  alert("Issue Drug Cost Can Not be Greater than Avalaible Budget!!!");
						   
						   //	 return false;
						 //  }
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
	//saveObj.style.display = "none"; 
		
		var hisValidator = new HISValidator("offlineIssueIndentBean");
		hisValidator.addValidation("strStoreName", "dontselect=0",	"Please select a value from Drug Warehouse Name Combo");
		hisValidator.addValidation("strItemCatgCombo", "dontselect=0",	"Please select a value from Item Category Combo");
		hisValidator.addValidation("strIndentingStoreID", "dontselect=0","Please select a value from Indent Drug Warehouse Name Combo");
		hisValidator.addValidation("strIndentIssueDate", "req","Issue Date is a Mandatory Field");
		
		//alert("1");
		if( document.forms[0].strIndentIssueDate.value != '' && document.forms[0].strApprovedDate.value!='' )
		{
			hisValidator.addValidation("strIndentIssueDate", "dtltet="+document.forms[0].strCurrentDate.value,"Issue Date should be Less than or equal to Current Date");
			hisValidator.addValidation("strIndentIssueDate", "dtgtet="+document.forms[0].strApprovedDate.value,"Issue Date should be Greater than or equal to Indent Date");		
		}
		
		
		hisValidator.addValidation("strIndentPeriodValue", "req","Indent Period is a Mandatory Field");
		hisValidator.addValidation("strIndentType", "dontselect=0","Please select a value from Indent Type Combo");
		
		hisValidator.addValidation("strIndentNo", "req","Indent No is a Mandatory Field");
		
		hisValidator.addValidation("strApprovedDate", "req","Indent Date is a Mandatory Field");
		hisValidator.addValidation("strApprovedDate", "dtltet="+document.forms[0].strCurrentDate.value,"Indent Date should be Less than or equal to Current Date");
		
		hisValidator.addValidation("strToStoreCombo", "dontselect=0","Please select a value from To Store Combo");
		var retVal = hisValidator.validate();
		hisValidator.clearAllValidations();
		    
		var itemParVal = document.getElementsByName("itemParamValue");
	//alert("2");
		if (retVal) 
		{
			if (document.getElementsByName("itemParamValue").length == "1") 
			{
				alert("Please Search Item Details");				
				//saveObj.style.display = '';
				return false;
			} 
			else 
			{
				hisValidator.addValidation("strReqQty", "req","Requested Quantity is a Mandatory Field");
				hisValidator.addValidation("strIssueQty", "req","Issue Quantity is a Mandatory Field");
				hisValidator.addValidation("strUnitName", "dontselect=0","Please select a value from Unit Name Combo");
				var retVal1 = hisValidator.validate();
				if (retVal1) 
				{
	
					var issueQty = document.getElementsByName("strIssueQty");
					var reqQty = document.getElementsByName("strReqQty");
					var perItemCost = document.getElementsByName("strCost");
					  //alert("3");
					
					//if (count == length - 1) 
					//{
						
						
						   var avalaibleBudget     = document.forms[0].strAvalaibleBudget.value;
						   var  totalAvlBudget     = parseFloat(avalaibleBudget);
						   					   
						   
						   var issueDrugCost       = document.forms[0].strNewDemandApproxAmtDivId.value;
						   var  totalIssueDrugCost = parseFloat(issueDrugCost);				   
						  //alert("4"+totalIssueDrugCost);
						  // if(totalIssueDrugCost > 0)
						  // {
						   	   //alert("totalAvlBudget::"+totalAvlBudget+"::totalIssueDrugCost:::"+totalIssueDrugCost);
						   	   //if(totalAvlBudget>totalIssueDrugCost)
						   	   //{
								//alert("5");
								if(document.forms[0].strApprovedBy.value!='0')
								{
								//alert("6");
								  	hisValidator.addValidation("strApprovalDate", "req","Approval Date is a Mandatory Field");
		                            hisValidator.addValidation("strApprovalDate", "dtltet="+document.forms[0].strIndentIssueDate.value,"Approval Date should be Less than or equal to Issue Date");
		                            hisValidator.addValidation("strApprovalDate", "dtgtet="+document.forms[0].strApprovedDate.value,"Approval Date should be Greater than or equal to Indent Date");
								  
									
								}
								if(document.forms[0].strVerifiedBy.value!='0')
								{
								//alert("7");
	 						    	hisValidator.addValidation("strVerifiedDate", "req","Verify Date is a Mandatory Field");
		                            hisValidator.addValidation("strVerifiedDate", "dtltet="+document.forms[0].strIndentIssueDate.value,"Verify Date should be Less than or equal to Issue Date");
		                            hisValidator.addValidation("strVerifiedDate", "dtgtet="+document.forms[0].strApprovedDate.value,"Verify Date should be Greater than or equal to Indent Date");
								    
									
								}
								
										
						        hisValidator.addValidation("strReceivedBy", "dontselect=0","Please select Receving Person Name");
								hisValidator.addValidation("strAprovedRemarks", "req","Approved Remarks is a Mandatory Field");
								hisValidator.addValidation("strAprovedRemarks", "maxlen=100","Approved Remarks should have less than or equal to 100 Characters");
								 var retVal2 = hisValidator.validate();
					
						            if (retVal2) 
						            {					   	 
										//alert("8");
										for ( var i = 0; i < issueQty.length - 1; i++) 
										{					
											 perItemCost[i].disabled=false;					
											
										}								
										
										  var conf = confirm("You Are Going To Save Records");
						                  if(conf == true)
						                  {
						                       //alert("9");
						                       var conf1 = confirm("Are you sure !!!");
						                       if(conf1 == true)
						                       {
						                          //alert("10");
						                          document.forms[0].hmode.value = "SAVENEWDEMAND";
	                                              document.forms[0].submit();
						                       }
						                      else
						                       {
						                       	 //alert("else 1");
						                       	 //saveObj.style.display = '';
						                         return false;
						                       }
						                   }
						                  else
						                   {
						                   		//alert("else 2");
						                   		 //saveObj.style.display = '';
						                         return false;
						                   }
						   	           
									   
						            }
						            else 
									{
									   //alert("else 3");
									   //saveObj.style.display = '';
									   return false;
								    }
						   	   //}
						   	  // else
							 //  {
							     
							  // 	 alert("Issue Drug Cost Can Not be Greater than Avalaible Budget!!!");
							  //   saveObj.style.display = '';
							   //	 return false;
							  // }
						   //}
						  // else
						  // {
						   	 
						   //	 alert("Issue Drug Cost Can Not be Zero!!!");
						   	 //saveObj.style.display = '';
						   //	 return false;
						  // }
						   
				/*		
					} 
					else 
					{
						alert("Please Enter Requested & Issue Item Qty!!!!");
						reqQty[0].focus();
						retVal = false;
					}
					* */
				} 
				else 
				{
					//alert("else 4");
					//saveObj.style.display = '';
					return false;
				}
	
			}
		}
		else
	    {
	      	//alert("else 5");
	      	//saveObj.style.display = '';
			return false;
	    }	
	}
    else
    {
      	//alert("else 6");
      	//saveObj.style.display = '';
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
			document.getElementById(costDiv.substring(0,12)+""+index).value = roundValue(total, 2);
			document.getElementById("strCost"+index).value = roundValue(total, 2);
			
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
		//alert(totCost);
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
			document.getElementById("strPendQtyCost"+index).value = roundValue(total, 2);
			
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
		var reqQty        = document.getElementById("strReqQty" + index).value;
		var temp          = document.getElementById("itemCalcValue" + index).value.split("^");
		var avlQtyBaseVal = temp[0];
       
		if (parseFloat(reqQty) < parseFloat(issueQty))
		{
			alert("Issue Quantity cannot be greater than Requested Quantity");
			document.getElementById("strIssueQty" + index).value = "0";
			 document.getElementById("strUnitName" + index).value = "0";
			calculateTotalCost(index);
			return false;
		}
		if (parseFloat(avlQtyBaseVal) < parseFloat(issueQty)) 
		{
			alert("Issue Quantity cannot be greater than Avalaible Quantity");
			document.getElementById("strIssueQty" + index).value = "0";
			 document.getElementById("strUnitName" + index).value = "0";
			calculateTotalCost(index);
			return false;
		}
        
	} 
	else 
	{
		if(document.getElementById("strUnitName" + index).value == "0") 
		{
			alert("Please Select Unit!!!");
			document.getElementById("strIssueQty" + index).value = "0";
		}
		
		calculateTotalCost(index);
		
		return false;
	}	 			
	calculateTotalCost(index);
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
			    	/*
			    	 * Logic to Preserved Value in Multi Row
			    	 * */
			    	
				       var chkObj      = document.getElementsByName("itemUserValue");
				       var unitObj     = document.getElementsByName("strUnitName");
				       var reqQtyObj   = document.getElementsByName("strReqQty");
				       var issueQtyObj = document.getElementsByName("strIssueQty");
				       var rateObj     = document.getElementsByName("itemCalcValue");
				       var newStr      = "";
				       var flag        = true;      
				       	 
				       	document.getElementById("strItemDtlWithIssueQty").value="";
				       	 
				        for(var nTmpI=0;nTmpI<chkObj.length-1;nTmpI++)
						{		
							//alert(flag);	
							if(flag)
							{	
								newStr = chkObj[nTmpI].value.split("^")[0]+"#"+chkObj[nTmpI].value.split("^")[1]+"#"+chkObj[nTmpI].value.split("^")[15]+"#"+chkObj[nTmpI].value.split("^")[32]+"#"+reqQtyObj[nTmpI].value+"#"+unitObj[nTmpI].value+"#"+issueQtyObj[nTmpI].value+"#"+rateObj[nTmpI].value.split("^")[1];
								//newStr = varTemp[0]+"#"+varTemp[1]+"#"+varTemp[15]+"#"+varTemp[32]+"#"+document.getElementById("strUnitName"+index).value+"#"+document.getElementById("strIssueQty"+index).value;
								flag = false;
							}
							else
							{
								newStr= newStr+"$$$$"+chkObj[nTmpI].value.split("^")[0]+"#"+chkObj[nTmpI].value.split("^")[1]+"#"+chkObj[nTmpI].value.split("^")[15]+"#"+chkObj[nTmpI].value.split("^")[32]+"#"+reqQtyObj[nTmpI].value+"#"+unitObj[nTmpI].value+"#"+issueQtyObj[nTmpI].value+"#"+rateObj[nTmpI].value.split("^")[1];
								//newStr= newStr+"$$$$"+varTemp[0]+"#"+varTemp[1]+"#"+varTemp[15]+"#"+varTemp[32]+"#"+document.getElementById("strUnitName"+index).value+"#"+document.getElementById("strIssueQty"+index).value;
							}		
									
													
							
						}
						//alert("After Adding this:::"+newStr);
						document.getElementById("strItemDtlWithIssueQty").value =  newStr;
			    	////////////////////////////////////////////////////////////
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
							
					
					document.getElementById("strCost"+index).value = roundValue(total, 2);
					
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
			document.getElementById("strCost"+index).value = roundValue(total, 2);
			
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
			//document.getElementById("strIssueQty" + index).value = "0";
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
		  // alert(thisImg.title);
		 	if (thisImg == null) 
		 	{
				alert("Cannot find this image object.");
			}
			if (thisImg.title == "Show") 
			{
				// Change Image Attribute
				//thisImg.src = "../../hisglobal/images/plus.gif";
				thisImg.class = "fas fa-minus-circle";
				
				document.getElementById("imgStockDetails").class="fas fa-minus-circle";
				thisImg.title = "Hide";
				document.getElementById("newDemandDivID").style.display='block';
				
				document.getElementById("existingDemandId").style.display="none";
	            //document.getElementById("newDemandId").style.display="none";
								
			}
			else
			{  
				//thisImg.src = "../../hisglobal/images/minus.gif";
				thisImg.class = "fas fa-plus-circle";
				document.getElementById("imgStockDetails").class="fas fa-plus-circle";
				thisImg.title = "Show";
				document.getElementById("newDemandDivID").style.display='none';
				document.getElementById("existingDemandId").style.display="block";
	            //document.getElementById("newDemandId").style.display="block";
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





/**
 * 
 */
function initPage() {
	document.forms[0].hmode.value = "FIRSTDATA";
	document.forms[0].submit();
}

function cancel() {
	showMenuFrame();
	document.getElementById("errMsg").innerHTML = "";
	document.forms[0].hmode.value = "CANCEL";
	document.forms[0].submit();
}

function getItemCategoryCombo() 
{
	if(document.forms[0].strIsView.value=='0')
	{
	   var objVal = document.getElementById("budgetIDTwo");
		   objVal.innerHTML = "";
	}	
	var temp =null;
	if(document.forms[0].strStoreName!=null) {
		temp = document.forms[0].strStoreName.value;
	}
	if(temp==null || temp=="" || temp=="0") {
		var objVal = document.getElementById("ItemCatg");
		objVal.innerHTML = "<select name = 'strItemCatgCombo' onchange='getIndentStoreCombo();' class='browser-default custom-select'><option value='0'>Select Value</option></select>";
		return;
	}
	var mode = "ItemCatgoryCombo";
	var url = "OfflineIssueIndentTransCNTNEW.cnt?hmode=" + mode + "&modName="
			+ temp;

	ajaxFunction(url, "2");
	
	var objVal1 = document.getElementById("IndentingStore");
	objVal1.innerHTML = "<select name = 'strIndentingStoreID' class='browser-default custom-select'><option value='0'>Select Value</option></select>";
    //document.getElementById("pendingDemandDivID").innerHTML="";
    document.getElementById("id1").innerHTML="";
    document.forms[0].strIndentNo.value="";
//    document.forms[0].strIndentPeriodValue.value="";
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
				var url = "OfflineIssueIndentTransCNTNEW.cnt?hmode=" + mode + "&modName="+hiddenVal+"&issueStoreName="+temp1+"&avlBudget="+document.forms[0].strAvalaibleBudget.value+"&budgetFlg="+document.forms[0].strBudgetFlg.value;
				
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
		objVal.innerHTML = "<select name = 'strApprovedBy'  class='browser-default custom-select'><option value='0'>Select Value</option></select>";
		return;
	}
	var mode = "ApprovedByCombo";
	var url = "OfflineIssueIndentTransCNTNEW.cnt?hmode=" + mode + "&modName=" + temp;
    ajaxFunction(url, "7");
}
function getIndentStoreCombo() 
{

	if(document.forms[0].strItemCatgCombo.value=="0")
   {
   		alert("Please select drug category.");
   		var objVal1 = document.getElementById("IndentingStore");
   	 	objVal1.innerHTML = "<select name = 'strIndentingStoreID' class='browser-default custom-select'><option value='0'>Select Value</option></select>";
   	 	//document.getElementById("pendingDemandDivID").innerHTML="";
   	 	document.getElementById("id1").innerHTML="";
   		document.forms[0].strIndentNo.value="";
//   		document.forms[0].strIndentPeriodValue.value="";
   		document.forms[0].strItemCatgCombo.focus();
   		return false;
   }
	if (document.forms[0].strIsView.value == '0') 
	{
		var temp = document.forms[0].strItemCatgCombo.value;
		var objValue = document.forms[0].strStoreName;
		var temp1 = objValue.options[objValue.selectedIndex].value;
		var mode = "IndentStoreCombo";
		var url = "OfflineIssueIndentTransCNTNEW.cnt?hmode=" + mode + "&modName="
				+ temp1 + "^" + temp;
		ajaxFunction(url, "1");
		
	}
	document.getElementById("id1").innerHTML="";
	document.forms[0].strIndentNo.value="";
//	document.forms[0].strIndentPeriodValue.value="";

}
function getPendingDemand() 
{
	
    var itemCatg;
    var objValue = document.forms[0].strStoreName;
    var objValue1 = document.forms[0].strIndentingStoreID;
    var objValue2 = document.forms[0].strItemCatgCombo;
  if(document.forms[0].strIsDemandActiveFlag.value=='1')
  {  
	if (document.forms[0].strIsView.value == '0') 
	{
	  if(objValue!='0')
	  {	
		
		var itemCatg = objValue2.options[objValue2.selectedIndex].value;
			
		var mainStore = objValue.options[objValue.selectedIndex].value;
				
		var indentingStore = objValue1.options[objValue1.selectedIndex].value;
		
		var mode = "PendingDemandDetails";
		var url = "OfflineIssueIndentTransCNTNEW.cnt?hmode=" + mode + "&modName="+ mainStore + "^" + itemCatg+"^"+indentingStore;
		
		ajaxFunction(url, "9");
	  }
	  
	}
  }
  else
  {
  	return false;
  }	

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
	var url = "OfflineIssueIndentTransCNTNEW.cnt?hmode=" + mode + "&modName="
			+ temp + "^" + temp1;
	ajaxFunction(url, "6");

}

function getIndentStoreBudgetDetails() 
{
	
	var objValue = document.forms[0].strStoreName;
	var temp = objValue.options[objValue.selectedIndex].value;

	var objValue1 = document.forms[0].strIndentingStoreID;
	var temp1 = objValue1.options[objValue1.selectedIndex].value;
   if(document.forms[0].strIndentingStoreID.value!='0')
   {
	var mode = "GetStoreBudget";
	var url = "OfflineIssueIndentTransCNTNEW.cnt?hmode=" + mode + "&modName="
			+ temp + "^" + temp1;
	ajaxFunction(url, "8");
   }
   else
   {
   	alert("Please Select Indenting Store");
   	document.forms[0].strAvalaibleBudgetDtl.value="0";
	document.forms[0].strAvalaibleBudget.value="0";
	var objVal1 = document.getElementById("budgetIDTwo");
		objVal1.innerHTML = "0.00";
	
   	return false;
   }

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
		objVal1.innerHTML = "<select name = 'strIndentingStoreID' onchange='getApprovedVerifyCombo();' class='browser-default custom-select'>"
				+ res + "</select>";
				
			   	   getPendingDemand();
				
	}
	if (mode == "2") 
	{
		
		var objVal = document.getElementById("ItemCatg");
		objVal.innerHTML = "<select name = 'strItemCatgCombo' onchange='getIndentStoreCombo();' class='browser-default custom-select'>"
				+ res + "</select>";
				if(document.forms[0].strIsView.value=='0')
	            {
				   getPendingDemand();
	            }  
				
	}

	if (mode == "3") {
		var objVal = document.getElementById("ItemCatgViewId");
		objVal.innerHTML = "<select name = 'strItemCatgCombo' onchange='getGroupNameCombo();' class='browser-default custom-select'>"
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
		
		document.getElementById("VerifiedBy").innerHTML = "<select name = 'strVerifiedBy' class='browser-default custom-select'>"
				+ res + "</select>";
		document.getElementById("ReceivedBy").innerHTML = "<select name = 'strReceivedBy' class='browser-default custom-select' onChange='OtherApprovedByfn();'>"
				+ res + "</select>";
				getIndentStoreBudgetDetails(); 
		

	}
	if (mode == "7") 
	{
		var objVal = document.getElementById("ApprovedBy");
		objVal.innerHTML = "<select name = 'strApprovedBy'  class='browser-default custom-select'>"+ res + "</select>";
	}
	if (mode == "8") 
	{
		
		temp = res.split("@@@@");
		
		var objVal = document.getElementById("budgetIDTwo");
		objVal.innerHTML = "<a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='avlBudgetDtl(this);' TITLE='Click Here Get Budget Details' >"+ temp[0] + "</a>";
		document.forms[0].strAvalaibleBudgetDtl.value=temp[1];
		document.forms[0].strAvalaibleBudget.value=temp[0];
		getPendingDemand();
	
	}
	if (mode == "9") 
	{
		getApprovedByCombo();
		//var objVal = document.getElementById("pendingDemandDivID");
		//objVal.innerHTML =  res;
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
function getItemCategoryComboViewPage() {

	var temp = document.forms[0].strStoreName.value.split("^");
	var mode = "ItemCatgoryCombo";
	var url = "OfflineIssueIndentTransCNTNEW.cnt?hmode=" + mode + "&modName="
			+ temp[0];
	ajaxFunction(url, "3");
}

function transferToViewPage() {
	//if (document.getElementsByName("strViewChk")[0].checked) {
		document.forms[0].hmode.value = "VIEWPAGE";
		document.forms[0].submit();
	//}
}
function getViewItemDtl() {

	if (document.getElementsByName("strStoreName")[0].value == "0") {
		alert("Please Select Store From Combo");
	} else if (document.getElementsByName("strItemCatgCombo")[0].value == "0") {
		alert("Please Select Item Category From Combo");
	} else {
		var temp = document.forms[0].strStoreName.value;
		var mode = "GOVIEWPAGE";
		var url = "OfflineIssueIndentTransCNTNEW.cnt?hmode=" + mode + "&storeId="
				+ temp + "&itemCatNo="
				+ document.forms[0].strItemCatgCombo.value + "&fromDate="
				+ document.forms[0].strFromDate.value + "&ToDate="
				+ document.forms[0].strToDate.value;
		ajaxFunction(url, "4");
	}

}
function showPopUp(obj, i) 
{
	indexglobal = i;
	parentPopup = obj;

	var mode = "GETPOPUP";
	var url = "OfflineIssueIndentTransCNTNEW.cnt?hmode=" + mode + "&hiddenVal="
			+ document.getElementById('strHlpIssueNo' + i).value + "&index="
			+ i + "&storeId=" + document.forms[0].strStoreName.value
			+ "&itemCatNo=" + document.forms[0].strItemCatgCombo.value
			+ "&fromDate=" + document.forms[0].strFromDate.value + "&ToDate="
			+ document.forms[0].strToDate.value;
	// alert("url-"+url);
	ajaxFunction(url, "5");

}

// function to show report after save data
function getReport() 
{
    
	var issueNo = document.forms[0].strTmpIssueNo.value;
	var storeId = document.forms[0].strTmpStoreNo.value;
	var IndentNo = document.forms[0].strTmpIndentNo.value;
	var IndentDate = document.forms[0].strTmpIndentDate.value

	if (issueNo != "0") 
	{
		getIssueDtls('2', storeId, issueNo, IndentNo, IndentDate);
	}
	else
	{
		hideMenuFrame();
	}
	document.forms[0].strTmpIssueNo.value = "0";
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
