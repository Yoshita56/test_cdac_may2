function cancelToDesk(){
	document.forms[0].hmode.value = "CANCELTODESK";
	document.forms[0].submit();
}
function cancelToDeskApproval()
{

	document.forms[0].hmode.value = "CANCELTOPOAPPROVALDESK";
	document.forms[0].submit();
}
function FuncTick(obj)
{ 
  if(obj.value == '1')
  {
    document.forms[0].strApproved.checked = true;
    document.forms[0].strRejected.checked = false;
  }
  else
  {
     document.forms[0].strRejected.checked = true;
     document.forms[0].strApproved.checked = false;
  }
  
}
function setApprovedQty(){
	var approvedQty=document.getElementsByName("strQrderQty");
	

	if(document.getElementsByName("strRejected")[0].checked){
		for(var i=0;i<approvedQty.length;i++){
			approvedQty[i].value="0";
		
		}
		
		document.getElementsByName("strPostatus")[0].value="2";//for reject
	}
	else
			document.getElementsByName("strPostatus")[0].value="1";
	
	//alert(ocument.getElementsByName("strPostatus")[0].value);
	
}

function resetCombo()
{
   document.getElementsByName("strItemCat")[0].value='0';	
   var itemParaObj1 = document.getElementById("divPOItemDtl");
   itemParaObj1.innerHTML ="<select name='strPOItemID' class='comboNormal'><option value='0'>Select Value</option></select>";
   var itemParaObj2 = document.getElementById("divPOTypeId");
   itemParaObj2.innerHTML ="<select name='strComboPOTypeId' class='comboNormal'><option value='0'>Select Value</option></select>";   
}
function pageResetMethod(mode)
{
	if(mode=='1')
	{
		  
		   document.forms[0].reset();
		   document.forms[0].strIndentPeriodValue.disabled = false;
           document.forms[0].strItemCat.disabled = false;
           document.forms[0].strComboPOTypeId.disabled = false;
           document.forms[0].strSupplierId.disabled = false;
           document.forms[0].strPOItemID.disabled = false; 
           document.getElementsByName("strItemCat")[0].value='0';	
           var itemParaObj1 = document.getElementById("divPOItemDtl");
		   itemParaObj1.innerHTML ="<select name='strPOItemID' class='comboNormal'><option value='0'>Select Value</option></select>";
		   var itemParaObj2 = document.getElementById("divPOTypeId");
		   itemParaObj2.innerHTML ="<select name='strComboPOTypeId' class='comboNormal'><option value='0'>Select Value</option></select>";
           document.getElementById("poRateDivId").style.display="none";
           objVal = document.getElementById("generateDynamicDiv");
           objVal.innerHTML=""; 
           //document.getElementById("strPORefrenceDate1").style.display="block";
           document.getElementById("poRefDateDiv").style.display="none";
           document.getElementById("poRefDateCalDiv").style.display="block";
               
           document.getElementById("totalPOCost").innerHTML = "0.00";
	       document.forms[0].strTotalPOCost.value = "0.00";
	       document.getElementById("imageDiv").style.display="block";		 
	       document.getElementById("contractedDeliveryDaysId").innerHTML = "";
	       document.getElementById("deliveryDaysID").innerHTML = "";
	         
	}
	if(mode=='2')
	{
		  
		   document.forms[0].strDDeliveryDays.value="";
		   document.forms[0].strDTenderNo.value="";
		   document.forms[0].strDTenderDate.value="";
		   document.forms[0].strDQuotationNo.value="";
		   document.forms[0].strDQuotationDate.value="";
		   
		   document.getElementsByName("strVerifiedBy")[0].value="0";
		   document.getElementById("totalPOCost").innerHTML = "0.00";
	       document.forms[0].strTotalPOCost.value = "0.00";
		   document.forms[0].strItemRate.disabled = false;
	       document.forms[0].strItemRateTax.disabled = false;
	       document.getElementsByName("strItemRateUnitId")[0].disabled = false;
		   document.forms[0].reset();
           document.forms[0].strPOItemID.disabled = false; 
           document.getElementById("poRateDivId").style.display="none";
           objVal = document.getElementById("generateDynamicDiv");
           objVal.innerHTML=""; 
           //document.getElementById("strPORefrenceDate1").style.display="block";
           
           //document.getElementById("poRefDateDiv").style.display="none";
           //document.getElementById("poRefDateCalDiv").style.display="blok";
           
           document.getElementById("imageDiv").style.display="block";	
            document.forms[0].strGoFlag.value='0';	   
            document.getElementById("deliveryDaysID").innerHTML = "";
	}     
	if(mode=='3')
	{		  
		   var hisValidator = new HISValidator("PODeskGenerateTransBean");
		   hisValidator.clearAllValidations(); 
		   document.forms[0].strIndentPeriodValue.disabled = false;
           document.forms[0].strItemCat.disabled = false;
           document.forms[0].strComboPOTypeId.disabled = false;
           document.forms[0].strSupplierId.disabled = false;
           document.forms[0].strPOItemID.disabled = false; 
           
           document.getElementsByName("strSupplierId")[0].value='0';
           document.getElementsByName("strItemCat")[0].value='0';	
           var itemParaObj1 = document.getElementById("divPOItemDtl");
		   itemParaObj1.innerHTML ="<select name='strPOItemID' class='comboNormal'><option value='0'>Select Value</option></select>";
		   var itemParaObj2 = document.getElementById("divPOTypeId");
		   itemParaObj2.innerHTML ="<select name='strComboPOTypeId' class='comboNormal'><option value='0'>Select Value</option></select>";
           document.getElementById("poRateDivId").style.display="none";
           objVal = document.getElementById("generateDynamicDiv");
           objVal.innerHTML="";            
	         
	}
 
}
function modify()
{	
	document.forms[0].strItemRate.disabled = false;
	document.forms[0].strItemRateTax.disabled = false;
	document.forms[0].strPOItemID.disabled = false; 
	document.getElementsByName("strItemRateUnitId")[0].disabled = false; 
	var hisValidator = new HISValidator("PODeskGenerateTransBean");
	hisValidator.addValidation("strPOItemID",        "dontselect=0", "Please Select Drug Name" );
	hisValidator.addValidation("strItemRate",        "req", "Please enter Item Rate" );
	hisValidator.addValidation("strItemRateUnitId",  "dontselect=0", "Please Select Rate Unit" );	
	hisValidator.addValidation("strItemRate",        "req", "Please enter Item Rate" );
	hisValidator.addValidation("strItemRateTax",     "req", "Please enter Item wise Tax" );
	hisValidator.addValidation("strItemManufacturerId","dontselect=0", "Please select Manufactrer" );	
	hisValidator.addValidation("strPoRefrenceNo","dontselect=0", "Please select PO Refrence No" );	
    hisValidator.addValidation("strPORefrenceDate",  "req", "Please Enter PO Reference Date." );       
	hisValidator.addValidation("strDPurchaseSource", "dontselect=0", "Please select Purchase Source" );
	hisValidator.addValidation("strDDeliveryDays",   "req", "Please enter Delivery Days");
	hisValidator.addValidation("strDDeliveryLocation","dontselect=0", "Please select Delivery Location" );
	hisValidator.addValidation("strDTenderNo",      "req", "Please Enter Tender No." );
    hisValidator.addValidation("strDTenderDate",    "req", "Please Enter Tender Date." );   
	hisValidator.addValidation("strVerifiedBy",     "dontselect=0", "Please select Verify By" );
	hisValidator.addValidation("strVerifiedDate",   "req", "Verified Date is Mandatory" );

		if(document.forms[0].strDTenderDate.value.length==11 && document.forms[0].strDQuotationDate.value.length==11)
			hisValidator.addValidation("strDTenderDate", "dtlt="+document.forms[0].strDQuotationDate.value, "Tender Date Must be Less then Quotation Date." );
	
		if(document.forms[0].strDQuotationDate.value.length==11)
		{
			//hisValidator.addValidation("strDQuotationDate", "dtlt="+document.forms[0].strDDeliveryDate.value, "Quotation Date Must be Less then Delivery Date." );
			hisValidator.addValidation("strDQuotationDate", "dtlt="+document.forms[0].strCurrentDate.value, "Quotation Date Must be Less then Current Date." );
		}
	
		if(document.forms[0].strDTenderDate.value.length==11)
		{
			//hisValidator.addValidation("strDTenderDate", "dtlt="+document.forms[0].strDDeliveryDate.value, "Tender Date Must be Less then Delivery Date." );
			hisValidator.addValidation("strDTenderDate", "dtlt="+document.forms[0].strCurrentDate.value, "Tender Date Must be Less then Current Date." );
		}
		//hisValidator.addValidation("strDDeliveryDate", "dtgtet="+document.forms[0].strCurrentDate.value, "Delivery Date Must be greater or equals to then Current Date." );
	hisValidator.addValidation("strDRemarks", "req"       , "Remarks is Mandatory" );
	hisValidator.addValidation("strDRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	if(retVal)
	{
	   if(document.forms[0].strGoFlag.value =='1')
	   {
	   		var orderQty = document.getElementsByName("strQrderQty");       	 	               
            var len = orderQty.length;		           
	        var count = 0,j=0;		
	          
	        for(var i=0;i<len;i++)
	        {
	           	if(orderQty[i].value=="" ||  orderQty[i].value=="0" ||  orderQty[i].value==0)
	          	{
	          		count++;		          		        	
	          	}		          	
	        }			       
	        if(len==count)
	        {
		       	alert("For all Stores Order Qty is zero\n\nPlease enter Ordered Quantity for a Store !!");
		       	orderQty[0].focus();
		       	return false;
	        }
	        else
	        {	
	  
				if(	confirm("You Are Going To Save Update Details of " +
						    "\n PO No :  " + document.forms[0].strPoRefrenceNo.value 
						   +"\n with PO Reference Date : "         + document.forms[0].strPORefrenceDate.value 
						   +" & PO Value : " + document.forms[0].strTotalPOCost.value
						  )
					)
				
				{
					if(confirm(" Are You Sure You Want to Save ?"))
					{				   
						 document.forms[0].hmode.value="UPDATEPO";
						 document.forms[0].submit();						
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
		   alert("Save not allowed  \n Please press GO button!!");
		   return false;
		}				   
	}

}



function validate1()
{	
    document.forms[0].strItemRate.disabled = false;
	document.forms[0].strItemRateTax.disabled = false;
	document.getElementsByName("strItemRateUnitId")[0].disabled = false;
	var hisValidator = new HISValidator("PODeskGenerateTransBean");
	hisValidator.addValidation("strPORefrenceDate",    "req", "Please Enter PO Reference Date." ); 
	hisValidator.addValidation("strItemCat",       "dontselect=0", "Please Select Item Category" );
	hisValidator.addValidation("strComboPOTypeId", "dontselect=0", "Please Select PO Type" );
	//hisValidator.addValidation("strSupplierId",    "dontselect=0", "Please Select Supplier" );
	hisValidator.addValidation("strPOItemID",      "dontselect=0", "Please Select Drug Name" );
	hisValidator.addValidation("strItemRate",          "req", "Please enter Item Rate" );
	hisValidator.addValidation("strItemRateUnitId",    "dontselect=0", "Please Select Rate Unit" );	
	hisValidator.addValidation("strItemRate",          "req", "Please enter Item Rate" );
	hisValidator.addValidation("strItemRateUnitId",    "req", "Please Select Rate Unit" );	
	if(document.forms[0].strItemRate.value=='0')
	{
		alert("Item Rate must be greater than Zero!!!");
		return false;
	}
	hisValidator.addValidation("strItemManufacturerId","dontselect=0", "Please Select Manufacturer Name" );
	hisValidator.addValidation("strItemRateTax",       "req", "Please enter Item wise Tax" );
	//hisValidator.addValidation("strItemManufacturerId","dontselect=0", "Please select Manufactrer Name" );
	//hisValidator.addValidation("strItemMake",              "dontselect=0", "Please select Item Make" );
	hisValidator.addValidation("strTotalQrderQty",     "req", "Please enter Order Quantity" );
    hisValidator.addValidation("strPoRefrenceNo",      "dontselect=0", "Please Select PO Reference No." );
	hisValidator.addValidation("strDPurchaseSource",   "dontselect=0", "Please select Purchase Source" );
	hisValidator.addValidation("strDDeliveryDays",     "req", "Please enter Delivery Days");
	hisValidator.addValidation("strDDeliveryLocation", "dontselect=0", "Please select Delivery Location" );
	//hisValidator.addValidation("strDOverAllTax",       "req", "Please enter Over all Tax" );
	
	hisValidator.addValidation("strDTenderNo",      "req", "Please Enter Tender No." );
    hisValidator.addValidation("strDTenderDate",    "req", "Please Enter Tender Date." );   
	
	hisValidator.addValidation("strVerifiedBy",        "dontselect=0", "Please select Verify By" );
	hisValidator.addValidation("strVerifiedDate",      "req", "Verified Date is Mandatory" );
	var  strDcomponentId  = document.getElementsByName("strDComponentId");
	var strDcomponentVal  = document.getElementsByName("strDComponentValue");
	
	for(var nTmpI = 0; nTmpI < strDcomponentId.length; nTmpI++)
	{
		strDcomponentId[nTmpI].disabled = false;
		strDcomponentVal[nTmpI].disabled = false;
		
	}
	
	//hisValidator.addValidation("strDDeliveryDays", "req", "Please Enter Delivery Days." );
	
	
		if(document.forms[0].strDTenderDate.value.length==11 && document.forms[0].strDQuotationDate.value.length==11)
		//alert("strDTenderDate::"+document.forms[0].strDTenderDate.value+"::strDQuotationDate::"+document.forms[0].strDQuotationDate.value);
		
			hisValidator.addValidation("strDTenderDate", "dtlt="+document.forms[0].strDQuotationDate.value, "Tender Date Must be Less then Quotation Date." );
	
		if(document.forms[0].strDQuotationDate.value.length==11)
		{
			//hisValidator.addValidation("strDQuotationDate", "dtlt="+document.forms[0].strDDeliveryDate.value, "Quotation Date Must be Less then Delivery Date." );
			hisValidator.addValidation("strDQuotationDate", "dtlt="+document.forms[0].strCurrentDate.value, "Quotation Date Must be Less then Current Date." );
		}
	
		if(document.forms[0].strDTenderDate.value.length==11)
		{
			//hisValidator.addValidation("strDTenderDate", "dtlt="+document.forms[0].strDDeliveryDate.value, "Tender Date Must be Less then Delivery Date." );
			hisValidator.addValidation("strDTenderDate", "dtlt="+document.forms[0].strCurrentDate.value, "Tender Date Must be Less then Current Date." );
		}
		//hisValidator.addValidation("strDDeliveryDate", "dtgtet="+document.forms[0].strCurrentDate.value, "Delivery Date Must be greater or equals to then Current Date." );
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	
	if(retVal)
	{
		           var retVal1 = false;	
		           var orderQty = document.getElementsByName("strQrderQty");       	 	               
		           var len = orderQty.length;		           
			       var count = 0,j=0;		
			          
			       for(var i=0;i<len;i++)
			       {
			           	if(orderQty[i].value=="" ||  orderQty[i].value=="0" ||  orderQty[i].value==0)
			          	{
			          		count++;		          		        	
			          	}		          	
			       }			       
			       if(len==count)
			       {
			       	retVal1 = true;
			       	alert("Please enter  Ordered Quantity!!");
			       	orderQty[0].focus();
			       	return false;
			       }			       
		            else
		            {  
			       	       
						   document.forms[0].strItemCat.disabled = false;
				           document.forms[0].strComboPOTypeId.disabled = false;
				           document.forms[0].strSupplierId.disabled = false;
				           document.forms[0].strPOItemID.disabled = false; 
				           document.forms[0].strIndentPeriodValue.disabled = false;
				           document.forms[0].strPOFinancialDtl.value = document.forms[0].strIndentPeriodValue[document.forms[0].strIndentPeriodValue.selectedIndex].text;
				           var contractedQty = parseInt(document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value.split("^")[10]);  
				           var totalOrderQty = parseInt(document.forms[0].strTotalQrderQty.value);
				            
				            if(document.forms[0].strTotalQrderQty.value!='0')
				            {
				            	if(totalOrderQty > contractedQty)
				            	{
				            		alert("Order Quantity is Greater than the Contracted Qty!!!");
				            	}
				            	
				            	
								if(	confirm("You Are Going To Save " +
										    "\n PO No :  " + document.forms[0].strPoRefrenceNo.value 
										   +"\n PO Reference Date : "         + document.forms[0].strPORefrenceDate.value 
										   +" With PO Value : " + document.forms[0].strTotalPOCost.value
										  )
									)
								
								{
									if(confirm(" Are You Sure You Want to Save ?"))
									{
									  
										document.forms[0].hmode.value="INSERTNEWPO";							
										document.forms[0].submit();
									}	
									
								}
								else
								{
									   document.forms[0].strItemCat.disabled = true;
							           document.forms[0].strComboPOTypeId.disabled = true;
							           document.forms[0].strSupplierId.disabled = true;
							           document.forms[0].strPOItemID.disabled = true; 
							           document.forms[0].strIndentPeriodValue.disabled = true; 
									return false;
								}	
				            }
				            else
				            {
				            	alert("Zero Total Order Quantity not Allowed!!");
				            	for(var nTmpI = 0; nTmpI < strDcomponentId.length; nTmpI++)
								{
									strDcomponentId[nTmpI].disabled = false;
									strDcomponentVal[nTmpI].disabled = false;
									
								}
				            	return false;
				            }				   
		            }
		
		
	}

}
function firstCallFunc()
{
      var poRateDivId = document.getElementById("poRateDivId");
	  poRateDivId.style.display="none";  
}
function notGreaterThanCent(_these)
{
	var nNum = _these.value;
	if(nNum>99)
		_these.value = _these.value.substr(0,2);		
	calPOCost();	
}

function calPOCost()
{
	var poCost = 0.00;
	var orderBaseValue = "0";
	var rateBaseValue = "0";
	
	var   totItemLen = document.getElementsByName("strOrdeCost").length;
	var itemWiseCost = document.getElementsByName("strOrdeCost");
	
	for(var i=0;i<totItemLen;i++)
	{
		
		poCost = poCost +  parseFloat(itemWiseCost[i].value);
		
	}
	
	//calculate overall tax
	var overallTax = trimAll(document.forms[0].strDOverAllTax.value);
	if(overallTax == "" || overallTax.length <= 0) overallTax = "0";
	
	if(overallTax != "0")
	{
		poCost = poCost + (poCost * parseFloat(overallTax))/100
	}
	else
	{
		poCost = poCost;		
	}
	
	poCost = roundValue(poCost,2);	
	
	document.getElementById("totalPOCost").innerHTML = roundValue(poCost,2);
	document.forms[0].strTotalPOCost.value = roundValue(poCost,2);
	//alert("After poCost::::"+poCost);
	
}

function POScheduleUtilityFunction(index,mode)
{
  var      scheduleOne   = document.getElementById("strScheduleOne"+index).value;
  var      scheduleTwo   = document.getElementById("strScheduleTwo"+index).value;
  var      scheduleThree = document.getElementById("strScheduleThree"+index).value;
  var      scheduleFour  = document.getElementById("strScheduleFour"+index).value;
  var      myArray       = document.getElementById("strSchedulePopUpHidValue"+index).value.split("#");
  //alert(document.getElementById("strSchedulePopUpHidValue"+index).value);
  if(mode=='1')
  {
  	   if(scheduleOne.length <= 0)  scheduleOne = 0;
  		
  	   if(scheduleOne < (parseInt(myArray[2],10)+parseInt(myArray[3],10)))
	   {
		 	alert("Schedule [I] Quantity Can't be Less than Total Supplied Quantity (Received + Rejected) :: "+(parseInt(myArray[2],10)+parseInt(myArray[3],10)));
		 	document.getElementById("strScheduleOne"+index).value = "0";
		 	document.getElementById("strScheduleTwo"+index).value = "0";
		    document.getElementById("strScheduleThree"+index).value = "0";
		    document.getElementById("strScheduleFour"+index).value = "0";
		    document.getElementById("strScheduleOne"+index).select();
		}
		else
		{
			if(scheduleOne == 0)
			{
				document.getElementById("strScheduleOne"+index).value = "0";
				document.getElementById("strScheduleTwo"+index).value = "0";
			    document.getElementById("strScheduleThree"+index).value = "0";
			    document.getElementById("strScheduleFour"+index).value = "0";
			}
		}	
  }
  
  if(mode=='2')
  {
  	if(scheduleTwo.length <= 0)  scheduleTwo = 0;
  	
  	if(scheduleTwo < (parseInt(myArray[6],10)+parseInt(myArray[7],10)))
	 {
	 	alert("Schedule [II] Quantity Can't be Less than Total Supplied Quantity (Received + Rejected) :: "+(parseInt(myArray[6],10)+parseInt(myArray[7],10)));
	 	document.getElementById("strScheduleTwo"+index).value = "0";
	    document.getElementById("strScheduleThree"+index).value = "0";
	    document.getElementById("strScheduleFour"+index).value = "0";
	    document.getElementById("strScheduleTwo"+index).focus();
	 }
	 else
	 {
	 	if(scheduleTwo == 0)
	 	{
	 		document.getElementById("strScheduleTwo"+index).value = "0";		   	  
		    document.getElementById("strScheduleThree"+index).value = "0";
		    document.getElementById("strScheduleFour"+index).value = "0";
	 	}
	 }
  }
  
  if(mode=='3')
  {
  	if(scheduleThree.length <= 0)  scheduleThree = 0;
  	
  	if(scheduleThree < (parseInt(myArray[10],10)+parseInt(myArray[11],10)))
	{
	 	alert("Schedule [III] Quantity Can't be Less than Total Supplied Quantity (Received + Rejected) :: "+(parseInt(myArray[10],10)+parseInt(myArray[11],10)));
	 	document.getElementById("strScheduleThree"+index).value = "0";
	    document.getElementById("strScheduleFour"+index).value = "0";
	    document.getElementById("strScheduleThree"+index).focus();
	}
	else
	{
		if(scheduleThree == 0)
	 	{
	 		document.getElementById("strScheduleThree"+index).value = "0";
		    document.getElementById("strScheduleFour"+index).value = "0";
	 	}
	}
  }
  
  if(mode=='4')
  {
  	if(scheduleFour.length <= 0)  scheduleFour = 0;
  	
  	if(scheduleFour < (parseInt(myArray[14],10)+parseInt(myArray[15],10)))
	 {
	 	alert("Schedule [IV] Quantity Can't be Less than Total Supplied Quantity (Received + Rejected) :: "+(parseInt(myArray[14],10)+parseInt(myArray[14],10)));
	 	document.getElementById("strScheduleFour"+index).value = "0";
	    document.getElementById("strScheduleFour"+index).focus();
	 }
	 else
	 {
	 	if(scheduleFour == 0)
	 	{
		    document.getElementById("strScheduleFour"+index).value = "0";
	 	}
	 }
  }
  
  POUtilityFunctionOne(index);
  
  	
}

function POUtilityFunctionOne(index)
{  
  var      scheduleOne   = document.getElementById("strScheduleOne"+index).value;
  var      scheduleTwo   = document.getElementById("strScheduleTwo"+index).value;
  var      scheduleThree = document.getElementById("strScheduleThree"+index).value;
  var      scheduleFour  = document.getElementById("strScheduleFour"+index).value;
  
	var scheduleOneVal ;
	var scheduleTwoVal ;
	var scheduleThreeVal ;
	var scheduleFourVal ;  

  if(scheduleOne.length <= 0)
  {
  	scheduleOneVal = 0;
  }
  else
  {
  	scheduleOneVal = scheduleOne;
  }
  if(scheduleTwo.length <= 0)
  {
  	scheduleTwoVal = 0;
  }
   else
  {
  	scheduleTwoVal = scheduleTwo;
  }
  
  if(scheduleThree.length <= 0)
  {
  	scheduleThreeVal = 0;
  }
   else
  {
  	scheduleThreeVal = scheduleThree;
  }
  if(scheduleFour.length <= 0)
  {
  	scheduleFourVal = 0;
  }
   else
  {
  	scheduleFourVal = scheduleFour;
  }
  var      totalOrderQty = parseInt(scheduleOneVal,10)+parseInt(scheduleTwoVal,10)+parseInt(scheduleThreeVal,10)+parseInt(scheduleFourVal,10);
  
  document.getElementById("strQrderQty"+index).value  =	totalOrderQty ;
   
  var  orderCostObj = document.getElementById("strOrdeCost"+index);
  var          rate = trimAll(document.forms[0].strItemRate.value);
  var           tax = trimAll(document.forms[0].strItemRateTax.value);
  var       totRate = trimAll(document.forms[0].strItemTotalRate.value);
  var      rateUnit = trimAll(document.forms[0].strItemRateUnitId.value);  
  var  totPOCostObj = document.getElementById("totalPOCost");
  var     hiddenVal = document.getElementById("strPODetailsHidValue"+index).value;
        //  Store Name (1)+ Demand Qty(2) + [PO_qty(3) # Tot_Issue_Qty(3)] +Tot_Issue Qty(4)+ [Active Qty(5) # Quarntine Qty(5)] + Re-Order Qty(6) + Order Qty(7) 
        //  Budget Avl(8) + DDW_ID(9)+All Sub Store(Consolidated)[10]
  var avlaibleBudget = parseFloat(hiddenVal.split("^")[7]);
  var totItemLen = document.getElementsByName("strQrderQty").length;
 
  var finalRate = 0.00;
  var    poCost = 0.00;
  var    totQty = 0;
    		
		var orderVal = "0"; 
		var rateVal = "0"; 
		var rateBaseValue = "0";
			
			
		orderVal = totalOrderQty;
			
			
		if(orderVal == "" || orderVal.length <= 0) 
		{
		   orderVal = "0";
		}
		 
		
		if(rateUnit != "0")
		{
			rateBaseValue = rateUnit.split("^")[1];
			rateVal = rate/rateBaseValue;
		}	
		 	
			
		if(rateBaseValue != "0")
		{
		    
		
		    if(tax == "" || tax.length <= 0) 		
			tax = "0";
		
			if(tax != "0")
			{
				 finalRate = parseFloat(rateVal) + (parseFloat(rateVal) *	parseFloat(tax))/100;
			}	
			else
			{
			     finalRate = parseFloat(rateVal);
			}
		}	
		orderCostObj.value = roundValue( (parseFloat(orderVal)* finalRate),2); 
		 // Total Cost
		/******************************************************************/
		    var poCost = 0.00;
		    var totQty = 0;
			var orderBaseValue = "0";
			var rateBaseValue = "0";
			
			var   totItemLen = document.getElementsByName("strOrdeCost").length;
			var itemWiseCost = document.getElementsByName("strOrdeCost");
			var orderValue = document.getElementsByName("strQrderQty");
			
			for(var i=0;i<totItemLen;i++)
			{				
				poCost = poCost +  parseFloat(itemWiseCost[i].value,10);
				totQty = totQty +  parseInt(orderValue[i].value);				
			}
			
			//calculate overall tax
			var overallTax = trimAll(document.forms[0].strDOverAllTax.value);
			if(overallTax == "" || overallTax.length <= 0) overallTax = "0";
			
			if(overallTax != "0")
			{
				poCost = poCost + (poCost * parseFloat(overallTax))/100
			}
			else
			{
				poCost = poCost;		
			}
			
			poCost = roundValue(poCost,2);	
			
			document.getElementById("totalPOCost").innerHTML = roundValue(poCost,2);
			document.forms[0].strTotalPOCost.value = roundValue(poCost,2);
				
				document.forms[0].strTotalQrderQty.value = totQty;
	
		/**************************************************************/	
}
function POUtilityFunction(index)
{
  var      orderObj = document.getElementsByName("strQrderQty");
  var  orderCostObj = document.getElementsByName("strOrdeCost");
  var          rate = trimAll(document.forms[0].strItemRate.value);
  var           tax = trimAll(document.forms[0].strItemRateTax.value);
  var       totRate = trimAll(document.forms[0].strItemTotalRate.value);
  var      rateUnit = trimAll(document.forms[0].strItemRateUnitId.value);  
  var  totPOCostObj = document.getElementById("totalPOCost");
  var     hiddenVal = document.getElementById("strPODetailsHidValue"+index).value;
 
	//  Store Name (1)+ Demand Qty(2) + [PO_qty(3) # Tot_Issue_Qty(3)] +Tot_Issue Qty(4)+ [Active Qty(5) # Quarntine Qty(5)] + Re-Order Qty(6) + Order Qty(7) 
	//  Budget Avl(8) + DDW_ID(9)+All Sub Store(Consolidated)[10]
  var avlaibleBudget = parseFloat(hiddenVal.split("^")[7]);
  var totItemLen = document.getElementsByName("strQrderQty").length;
  var finalRate = 0.00;
  var    poCost = 0.00;
  var    totQty = 0;
  
  for(var i=0;i<totItemLen;i++)
  {		
		var orderVal = 0.00; 
		var rateVal = 0.00; 
		var rateBaseValue = 0.00;
			//alert(orderVal);
			
		orderVal = trimAll(orderObj[i].value);			
		if(orderVal == "" || orderVal.length <= 0) 
		{
		   orderVal = 0.00;
		  // alert(orderVal);
		}
		
		else
		{
			orderVal = parseFloat(orderObj[i].value,10);
		}
		//alert(orderVal);
		if(rateUnit != "0" && rateUnit != "")
		{
			//alert(rate);
			//alert(rateUnit);
			rateBaseValue = parseFloat(rateUnit.split("^")[1]);
			//alert(rateBaseValue);
			rateVal = rate/rateBaseValue;
		}	
		else
		{
			rateVal = rate;
		}	
		//	alert("rateBaseValue"+rateBaseValue);
		if(rateBaseValue != 0.00)
		{
		    
		
		    if(tax == "" || tax.length <= 0) 		
			tax = 0.00;
		//alert(rateVal);
		//alert(tax);
			if(tax != 0.00)
			{
				 finalRate = parseFloat(rateVal) + (parseFloat(rateVal) *	parseFloat(tax))/100;
			}	
			else
			{
			     finalRate = parseFloat(rateVal);
			}
		}
		else
		{
		     finalRate = parseFloat(rateVal);
		}
	//	alert(rateVal);   
	//	        alert(orderVal)    ;
	//	alert(roundValue( (orderVal* finalRate),2));
		orderCostObj[i].value = roundValue( (orderVal* finalRate),2);  // Total Cost
		poCost = poCost +  parseFloat(orderCostObj[i].value);
		totQty = totQty +  parseInt(orderVal);	
		
	}
		/*
		  Change Color Logic
	                if(poCost > avlaibleBudget)
			        {
			            changeColor(index,1);
			        }
			        else
			        {
			            changeColor(index,2);
			        }
			        */	
	document.forms[0].strTotalQrderQty.value = totQty;
	//calculate overall tax
	var overallTax = trimAll(document.forms[0].strDOverAllTax.value);
	if(overallTax == "" || overallTax.length <= 0) overallTax = "0";
	
	if(overallTax != "0")
	{
		poCost = poCost + (poCost * parseFloat(overallTax))/100
	}
	
	poCost = roundValue(poCost,2);
	
	document.getElementById("totalPOCost").innerHTML = roundValue(poCost,2);
	document.forms[0].strTotalPOCost.value = roundValue(poCost,2);	
	
}
function resetDiv(mode)
{
  var obj1 = document.getElementsByName("strQrderQty");
  var obj2 = document.getElementsByName("strOrdeCost");
  var obj3 = document.getElementsByName("td10");  
  
   for(var i=0 ; i<obj3.length ; i++)
   {
     obj3[i].style.backgroundColor = ""; 
   }
         if(mode=='1')
	     {
	        
			    var  rateObj = trimAll(document.forms[0].strItemRate.value);
			    var   taxObj = trimAll(document.forms[0].strItemRateTax.value);
			    var  totRate = trimAll(document.forms[0].strItemTotalRate.value);
			    var rateUnit  = trimAll(document.forms[0].strItemRateUnitId.value);
			    var         rate = "0";    
			    var  rateUnitVal = "0"; 
				var  finalRate  = 0.00;
				 var         rateValue = 0; 
		         
					    if(rateObj=="0" || rateObj.length <=0)
					    {
					        rate = "0";
					    }
					    else
					    {		
						    rate = rateObj;
					    }
					    if(rateUnit!="0")
						{		 
						    rateUnitVal =   rateUnit.split('^')[1];  
						    rateValue = rate/rateUnitVal;  
						         
						}
						else
						{
						   rateUnitVal = "0";
						    rateValue = rate;
						}				        
				        
					    if(taxObj != "" && taxObj.length > 0)
					    {
					      
					    	finalRate = parseFloat(rateValue) + (parseFloat(rateValue) *	parseFloat(taxObj))/100;
					      
					    }
					    else
					    {
					        finalRate = parseFloat(rateValue);
					    }	    
					    
					      for(var i=0 ; i<obj1.length ; i++)
						  {		     
						        if(obj1[i].value == "" || obj1[i].value.length <= 0) 
								{
								   obj2[i].value = "0";  // Total Cost				           	
								}
								else
								{
								  obj2[i].value = roundValue( (parseFloat(obj1[i].value,10)* finalRate),2);  // Total Cost
								}
		 	       	
						  }
						  calPOCost();
						  calculateTotalQty();
				         document.forms[0].strItemTotalRate.value = finalRate;
		         
		          
	         
	      }
	      if(mode=='2')
	      {
	            var  rateObj  = trimAll(document.forms[0].strItemRate.value);
			    var   taxObj  = trimAll(document.forms[0].strItemRateTax.value);
			    var  totRate  = trimAll(document.forms[0].strItemTotalRate.value);
			    var rateUnit  = trimAll(document.forms[0].strItemRateUnitId.value);
			     var         rate = "0";    
			    var  rateUnitVal = "0"; 
				var  finalRate  = 0.00;
				 var         rateValue = "0"; 
		         
					     if(rateObj=="0" || rateObj.length <=0)
					    {
					        rate = "0";
					    }
					    else
					    {		
						    rate = rateObj;
					    }
					    if(rateUnit!="0")
						{		 
						    rateUnitVal =   rateUnit.split('^')[1];  
						    rateValue = rate/rateUnitVal;  
						         
						}
						else
						{
						   rateUnitVal = "0";
						    rateValue = rate;
						}			
				        
				        
					    if(taxObj != "" && taxObj.length > 0)
					    {
					    	finalRate = parseFloat(rateValue) + (parseFloat(rateValue) *	parseFloat(taxObj))/100;
					    }
					    else
					    {
					        finalRate = parseFloat(rateValue);
					    }	      
						  for(var i=0 ; i<obj1.length ; i++)
						  {		     
						        if(obj1[i].value == "" || obj1[i].value.length <= 0) 
								{
								   obj2[i].value = "0";  // Total Cost				           	
								}
								else
								{
								  obj2[i].value = roundValue( (parseFloat(obj1[i].value,10)* finalRate),2);  // Total Cost
								}
		 	       	
						  }
						  
						  
				   calPOCost();
				   calculateTotalQty();
		           document.forms[0].strItemTotalRate.value = finalRate;
	      }
      /*else
      {
         
         document.forms[0].strTotalPOCost.value = "0";
         document.getElementById("totalPOCost").innerHTML="0.00";
      }*/
}

function setValueItem(mode)
{
	if(mode=='2')
	{
		      //alert("PO Item ID:::"+document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value);
		      //    0             1            2        3                       4                5        6              7  
	          // ItemBrandID @ Item Id @ Supplier Id @ Rate @ Rate Unit ^ Rate Base value ^ 0 @ Tax @ Rate With Tax @ Delivery Day(s)
		     
	          //document.getElementById("contractedDeliveryDaysId").innerHTML = (document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('^')[11]; 	          
	          document.forms[0].strDDeliveryDays.value = (document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('@')[7].split(' ')[0];
	          document.forms[0].strItemRate.value = (document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('@')[3];
              document.forms[0].strItemRateTax.value = (document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('@')[5];
              
              document.getElementsByName("strItemManufacturerId")[0].value = (document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('@')[2];
              
              document.forms[0].strItemTotalRate.value = parseFloat((document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('@')[6])/parseInt( ((document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('@')[4]).split('^')[1]);
              document.getElementsByName("strItemRateUnitId")[0].value = (document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('@')[4];
            	          
	          document.forms[0].strItemRate.disabled = true;
	          document.forms[0].strItemRateTax.disabled = true;
	          document.getElementsByName("strItemRateUnitId")[0].disabled = true;
	}
	if(mode=='1')
	{
		    // alert("PO Item ID:::"+document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value);
		      //    0             1            2      3       4         5          6               7              8               9                 10                 11
	         // ItemBrandID ^ Order Qty ^ Item Id ^ Rate ^ Rate Unit ^ Tax ^ Rate Base value ^ Rate With Tax ^ Tender Date ^ Tender Number ^ Contracted Quantity ^ Delivery Day(s)
	        
	          document.getElementById("contractedDeliveryDaysId").innerHTML = (document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('^')[10]; 	          
	          document.getElementById("deliveryDaysID").innerHTML = (document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('^')[11];
	          document.getElementById("strDDeliveryDays").value = (document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('^')[11];
	          document.forms[0].strItemRate.value = (document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('^')[3];
              document.forms[0].strItemRateTax.value = (document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('^')[5];
              if((document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('^')[6]!='0')
              {
                document.forms[0].strItemTotalRate.value = parseFloat((document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('^')[7])/parseInt( ((document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('^')[6]));
              }
              else
              {
              	document.forms[0].strItemTotalRate.value = "0";
              }
              document.getElementsByName("strItemRateUnitId")[0].value = (document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('^')[4];
              document.forms[0].strDTenderNo.value =  document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value.split('^')[9];
              document.forms[0].strDTenderDate.value =  document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value.split('^')[8];
              document.getElementsByName("strItemRateUnitId")[0].value = (document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('^')[4]+"^"+(document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('^')[6]+"^0";
                           
	          document.forms[0].strItemRate.disabled = true;
	          document.forms[0].strItemRateTax.disabled = true;
	          document.getElementsByName("strItemRateUnitId")[0].disabled = true;
	          getComponentDetails();
	          
	}         
}

function calculateTotalQty()
{
    var       totQty = 0;
    var   totItemLen = document.getElementsByName("strQrderQty").length;
	var      itemQty = document.getElementsByName("strQrderQty");	
	for(var i = 0;i<totItemLen;i++)
	{
	   if(itemQty[i].value.length<=0)
	   {
		  totQty = totQty;
	   }
	   else
	   {
	      totQty = totQty +  parseFloat(itemQty[i].value);
	   }	
	}
	document.forms[0].strTotalQrderQty.value = totQty;
	
}
function getValueofOrderQty(index)
{
        var hiddenVal = document.getElementById("strPODetailsHidValue"+index).value;
        //  Store Name (1)+ Demand Qty(2) + [PO_qty(3) # Tot_Issue_Qty(3)] +Tot_Issue Qty(4)+ [Active Qty(5) # Quarntine Qty(5)] + Re-Order Qty(6) + Order Qty(7) 
        //  Budget Avl(8) + DDW_ID(9)+All Sub Store(Consolidated)[10]
        var        rateObj = trimAll(document.forms[0].strItemTotalRate.value);
        var         qtyObj = document.getElementById("strQrderQty"+""+index).value;
        var rateUnit  = trimAll(document.forms[0].strItemRateUnitId.value);
        if(document.forms[0].strItemRateUnitId.value!='0')
        {
          var qty_base_value = document.forms[0].strItemRateUnitId.value.split("^")[1];
        }
        else
        {
         var qty_base_value = '0';
        }
        var avlaibleBudget = parseFloat(hiddenVal.split("^")[7]);
        
        if(rateObj!='0' || rateObj.length>0)
        {          
           //alert("Rate:::"+rateObj+"::Qty::"+qtyObj+"::qty_base_value::"+qty_base_value+"::Avlaible Budget::"+avlaibleBudget);
           if(qty_base_value!='0')
           {	
               // if(qtyObj!='0')
               // {				
				    var qty    = qtyObj;
				    
				    var rate   = rateObj;
				    var total  = parseFloat("0.00");
				    
					if(isNaN(rate) || rate=="")
					{ 
					    rate = "0";
					}
					else
					{
					  if(rateUnit!="")
					  {
					     rate   = rateObj/rateUnit.split('^')[1];
					  }
					  else
					  {
					    rate    = rateObj;
					  } 
					
					}
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
			        document.getElementById("strOrdeCost"+index).value = roundValue(total, 2);
			        
			        /*
			        if(total > avlaibleBudget)
			        {
			            changeColor(index,1);
			        }
			        else
			        {
			            changeColor(index,2);
			        }
			        */
			        // Calculate Total PO Cost   
			        calPOCost();
			        calculateTotalQty();
			        
			        
			     //}
			    /* else
			     {
			            alert("Order Qty Must be Greater than ZERO!!!");
			            var total  = parseFloat("0.00");
						document.getElementById("strOrdeCost"+index).value = total;
						//document.getElementById("strQrderQty"+""+index).focus();
						return false;
			
			     }	*/
			 }
			 else
			 {
			            alert("Please Select Rate Unit!!!");
			            var total  = parseFloat("0.00");
						document.getElementById("strOrdeCost"+index).value = total;
						//document.getElementById("strItemRateUnitId").focus();
						return false;
			
			 }	
			 
		}
		else
		{
		            alert("Rate Must be Greater than ZERO!!!");
		            var total  = parseFloat("0.00");
					document.getElementById("strOrdeCost"+index).value = total;
					//document.forms[0].strItemRate.focus();
					return false;
		
		}				
	return true;
	
   
}
function changeColor(index,mode)
{
    if(mode=='1')
    {
	    if(document.forms[0].strReOrderFlgColor.value.length > 0)
	    {
	                var   colorOne = document.forms[0].strReOrderFlgColor.value;
			        var    noOfRow = document.getElementById("reOrderFlag"+index);
	        		document.getElementById("td10"+index).style.backgroundColor = colorOne; 
	        		document.getElementById("td20"+index).style.backgroundColor = colorOne;  
	        		document.getElementById("td30"+index).style.backgroundColor = colorOne;  
	        		document.getElementById("td40"+index).style.backgroundColor = colorOne;  
	        		document.getElementById("td50"+index).style.backgroundColor = colorOne;  
	        		document.getElementById("td60"+index).style.backgroundColor = colorOne;  
	        		document.getElementById("td70"+index).style.backgroundColor = colorOne;   
	        		document.getElementById("td80"+index).style.backgroundColor = colorOne;
	        		document.getElementById("td90"+index).style.backgroundColor = colorOne;  
	        		document.getElementById("td110"+index).style.backgroundColor = colorOne;  
	        		document.getElementById("td120"+index).style.backgroundColor = colorOne;   
	        		document.getElementById("td130"+index).style.backgroundColor = colorOne;  
	        		document.getElementById("td140"+index).style.backgroundColor = colorOne;  				
	        
	     }
    }
    else
    {
                    document.getElementById("td10"+index).style.backgroundColor = "#FFEBD5"; 
	        		document.getElementById("td20"+index).style.backgroundColor = "#F1ECE2";   
	        		document.getElementById("td30"+index).style.backgroundColor = "#F1ECE2";  
	        		document.getElementById("td40"+index).style.backgroundColor = "#F1ECE2";   
	        		document.getElementById("td50"+index).style.backgroundColor = "#F1ECE2";   
	        		document.getElementById("td60"+index).style.backgroundColor = "#F1ECE2";    
	        		document.getElementById("td70"+index).style.backgroundColor = "#F1ECE2";    
	        		document.getElementById("td80"+index).style.backgroundColor = "#F1ECE2";  
	        		document.getElementById("td90"+index).style.backgroundColor = "#F1ECE2";    
	        		document.getElementById("td110"+index).style.backgroundColor = "#F1ECE2";    
	        		document.getElementById("td120"+index).style.backgroundColor = "#F1ECE2";     
	        		document.getElementById("td130"+index).style.backgroundColor = "#F1ECE2";   
	        		document.getElementById("td140"+index).style.backgroundColor = "#F1ECE2"; 
    }   
}

function hideMenu()
{	
			if(parent.document.getElementById("fs2").cols == "0,*")
			{
				parent.document.getElementById("fs2").cols = "230,*";
				parent.document.getElementById("f7").contentDocument.getElementById("Image").src="../hisglobal/images/arrsingle-left.png";
			
			}
			else
			{
				
				parent.document.getElementById("f7").contentDocument.getElementById("Image").src="../hisglobal/images/arrsingle-left.png";
			}
			  
	}	

function getContractType()
{
	if(document.forms[0].strPOTypeId.value==22 || document.forms[0].strPOTypeId.value==87)
		return 10;
	if(document.forms[0].strPOTypeId.value==21 ||document.forms[0].strPOTypeId.value==25 ||document.forms[0].strPOTypeId.value==26 ||document.forms[0].strPOTypeId.value==27 || document.forms[0].strPOTypeId.value==23|| document.forms[0].strPOTypeId.value==28)
		return 11;
	else
		return '';
}

function getSupplierValues()
{
	if(document.forms[0].strItemCat.value!="0" && document.forms[0].strComboPOTypeId.value!="0")
	{		
		var        hmode = "GETSUPPLIERVALUES"; 
		var contractType = 11;
		var          url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strContractType="+contractType+"&strItemCat="+document.forms[0].strItemCat.value;		
		ajaxFunction(url,"1");
	}
	else
	{
		document.getElementById("divSupplier").innerHTML="<select name='strSupplierId'><option value='0'>Select Value</option></select>";
	}
}



function getPOTypeValues()
{
	if(document.forms[0].strItemCat.value!="0" && document.forms[0].strComboPOTypeId.value!="0")
	{		
		var        hmode = "GETSUPPLIERVALUES"; 
		var contractType = 11;
		var          url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strContractType="+contractType+"&strItemCat="+document.forms[0].strItemCat.value;		
		ajaxFunction(url,"1");
	}
	else
	{
		document.getElementById("divSupplier").innerHTML="<select name='strSupplierId'><option value='0'>Select Value</option></select>";
	}
}

function getPOTypeComboValues()
{	
	var hmode = "GETPOTYPEVALUES"; 
	var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strItemCat="+document.forms[0].strItemCat.value+"&strStoreId="+document.forms[0].strStoreId.value;
	ajaxFunction(url,"6");
}

function copyPotypeFromCombo()
{
	document.forms[0].strPOTypeId.value=document.forms[0].strComboPOTypeId.value.split("^")[0];
	try
	{
		document.forms[0].strPOGrantType.value=document.forms[0].strComboPOTypeId.value.split("^")[1];
	}
	catch(_Err)
	{
		
	}
}

function getComponentDetails()
{
	var hmode = "GETCOMPONENTDETAILS";
	var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strPOTypeId="+document.forms[0].strPOTypeId.value+"&strItemCat="+document.forms[0].strItemCat.value;
	ajaxFunction(url,"4");
}
function getPOItemList()
{
    var hisValidator = new HISValidator("PODeskGenerateTransBean");
	hisValidator.addValidation("strPORefrenceDate",    "req", "Please Enter PO Reference Date." ); 
	hisValidator.addValidation("strItemCat",       "dontselect=0", "Please Select Item Category" );
	//hisValidator.addValidation("strSupplierId", "dontselect=0", "Please Select Supplier Name" );	
	
     var retVal = hisValidator.validate();
	
	if(retVal)
	{
	 var hmode = "GETPOITEMLIST";
	 var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strPOTypeId="+document.forms[0].strPOTypeId.value+"&strItemCat="+document.forms[0].strItemCat.value+"&strPOStoreID="+document.forms[0].strStoreId.value+"&strIndentPeriodValue="+document.forms[0].strIndentPeriodValue[document.forms[0].strIndentPeriodValue.selectedIndex].text+"&supplierID="+document.forms[0].strSupplierId.value.split("^")[0]+"&poRefDate="+document.forms[0].strPORefrenceDate.value;
	 ajaxFunction(url,"5");
	 
   }
   else
   {
   	document.getElementsByName("strItemCat")[0].value ="0";
   	 return false;     
   }

}
function putDaynamicDiv(mode)
{
 if(mode=='1')
 {
   if(document.forms[0].strItemCat.value!='0')
   {
    if(document.forms[0].strComboPOTypeId.value!='0')
    {
      if(document.forms[0].strSupplierId.value!='0')
      {
        if(document.forms[0].strPOItemID.value!='0')
        {
           //alert("Rate:::"+document.forms[0].strItemRate.value+":::PO Date:::"+document.getElementsByName("strPORefrenceDate")[0].value);	
           if(document.forms[0].strItemRate.value!='0')
           {
        	   
            var divPOTypeId1 = document.getElementById("generateDynamicDiv");
		        divPOTypeId1.style.display="none";
		        divPOTypeId1.innerHTML = ""; 
		        
			    //document.getElementById("strPORefrenceDate1").style.display="none";  
			    document.getElementById("poRefDateDiv").style.display="block";
			    document.getElementById("poRefDateCalDiv").style.display="none";
			    document.getElementById("poRefDateDiv").innerHTML = document.getElementsByName("strPORefrenceDate")[0].value;  
	            
	            
	            document.forms[0].strItemCat.disabled = true;
	            document.forms[0].strComboPOTypeId.disabled = true;
	            document.forms[0].strSupplierId.disabled = true;
	            document.forms[0].strPOItemID.disabled = true; 
	            document.forms[0].strIndentPeriodValue.disabled = true;
	            document.forms[0].strItemRate.disabled = true;
		        document.forms[0].strItemRateTax.disabled = true;
		        document.getElementsByName("strItemRateUnitId")[0].disabled = true;
                var hisValidator = new HISValidator("PODeskGenerateTransBean");
	            hisValidator.addValidation("strPORefrenceDate",    "req", "Please Enter PO Reference Date." ); 
                var retVal = hisValidator.validate();
	
				if(retVal)
				{
	            
			        var hmode = "GETDWHPOHLP";
			        var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strSupplierId="+document.forms[0].strSupplierId.value+"&strPOItemID="+document.forms[0].strPOItemID.value+"&strComboPOTypeId="+document.forms[0].strComboPOTypeId.value+"&mode="+mode+"&strIndentPeriodValue="+document.forms[0].strIndentPeriodValue[document.forms[0].strIndentPeriodValue.selectedIndex].text+"&strStoreId="+document.forms[0].strStoreId.value;
				    ajaxFunction(url,"8");
				}
				else
				{
					progress_stop();
					return false;
				}
           }
           else
           {
           	  alert("Zero Item Rate is not allowed!!!");
           	  var divPOTypeId = document.getElementById("poRateDivId");
	          divPOTypeId.style.display="none";
           	  progress_stop();
			  return false;
           }	
		}
		else
		{
		   document.getElementById('showbar').style.visibility = 'hidden';
	       progress_stop();
		  document.forms[0].strPOItemID.focus();
		  alert("Please Select Drug Name!!!");
            var divPOTypeId = document.getElementById("generateDynamicDiv");
	            divPOTypeId.style.display="none";
	        var divPOTypeId = document.getElementById("poRateDivId");
	            divPOTypeId.style.display="none";
	        
          return false; 
		}   
	  }
	  else
		{
		  document.getElementById('showbar').style.visibility = 'hidden';
	       progress_stop();
		 // document.forms[0].strSupplierId.focus();
		 // alert("Please Select Supplier Name!!!");
          var divPOTypeId = document.getElementById("generateDynamicDiv");
	      divPOTypeId.style.display="none";
	        var divPOTypeId = document.getElementById("poRateDivId");
	       divPOTypeId.style.display="none";
	       
          return false; 
		}   
	 }
	 else
	 { 
	      document.getElementById('showbar').style.visibility = 'hidden';
	       progress_stop();
	      document.forms[0].strComboPOTypeId.focus(); 
		  alert("Please Select PO Type!!!");
          var divPOTypeId = document.getElementById("generateDynamicDiv");
	      divPOTypeId.style.display="none";
	       var divPOTypeId = document.getElementById("poRateDivId");
	       divPOTypeId.style.display="none";
	      
          return false; 
	 }   
   }
   else
   {
     document.getElementById('showbar').style.visibility = 'hidden';
	       progress_stop();
     document.forms[0].strItemCat.focus();
     alert("Please Select Category!!!");
      var divPOTypeId = document.getElementById("generateDynamicDiv");
	       divPOTypeId.style.display="none";
	         var divPOTypeId = document.getElementById("poRateDivId");
	       divPOTypeId.style.display="none";
	       
     return false;
   }
  }
  else
  {   
  	  var divPOTypeId1 = document.getElementById("generateDynamicDiv");
		      divPOTypeId1.style.display="none";
		      divPOTypeId1.innerHTML = ""; 
		     
		    // alert("strPOHiddenValue form"+document.forms[0].strPOHiddenValue.value);
		    // alert("strPOHiddenValue"+document.getElementsByName("strPOHiddenValue").value)
             var hmode = "GETDWHPOHLP2";	        
		     var   url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strSupplierId="+0+"&strPOItemID="+document.forms[0].strPOItemID.value+"&strPONo="+document.forms[0].strPONo.value+"&strPOHiddenValue="+document.forms[0].strPOHiddenValue.value+"&mode="+mode+"&strStoreId="+document.forms[0].strStoreId.value;
		     ajaxFunction(url,"88");
  
  }
}

function putDaynamicViewDiv()
{
	var divPOTypeId1 = document.getElementById("generateDynamicDiv");
		      divPOTypeId1.style.display="none";
		      divPOTypeId1.innerHTML = ""; 
		     
		     var mode = 2;             
             var hmode = "GETDWHPOHLP2";	        
		     var   url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strSupplierId="+0+"&strPOItemID="+document.forms[0].strPOItemID.value+"&strPONo="+document.forms[0].strPONo.value+"&strPOHiddenValue="+document.forms[0].strPOHiddenValue.value+"&mode="+mode+"&strStoreId="+document.forms[0].strStoreId.value;
		     ajaxFunction(url,"880");
}

function putDaynamicViewDivForViewPage()
{
	var divPOTypeId1 = document.getElementById("generateDynamicDiv");
		      divPOTypeId1.style.display="none";
		      divPOTypeId1.innerHTML = ""; 
		     
		     var mode = 2;             
             var hmode = "GETDWHPOHLP3";	        
		     var   url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strSupplierId="+0+"&strPOItemID="+document.forms[0].strPOItemID.value+"&strPONo="+document.forms[0].strPONo.value+"&strPOHiddenValue="+document.forms[0].strPOHiddenValue.value+"&mode="+mode+"&strStoreId="+document.forms[0].strStoreId.value;
		     ajaxFunction(url,"880");
}

function getUnitCombo()
{
  
	var hmode = "GETUNITVALUE";
	var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strPOItemID="+document.forms[0].strPOItemID.value;
	ajaxFunction(url,"9");
       
}

function getUnitCombo1()
{
     
	var hmode = "GETUNITVALUE1";
	var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strPOItemID="+document.forms[0].strPOItemID.value;
	ajaxFunction(url,"99");
       
}

function getAjaxResponse(_res,_mode)
{
	if(_res.split("####")[0] == "ERROR")
	{
		document.getElementById("errMsg").innerHTML=_res.split("####")[1];
	} 
	else 
	if(_mode == '1')
	{
		var itemParaObj = document.getElementById("divSupplier");
		itemParaObj.innerHTML = "<select name='strSupplierId' class='comboMax'>"+_res.split('$')[0]+"</select>";
		
	} 
	else 
	if(_mode == '2')
	{
		showDiv1('divPlusMinusRequestDtl')
		var itemParaObj = document.getElementById("divRequestDetails");
		itemParaObj.innerHTML = _res;
		disCheckAll();
	} 
	else 
	if(_mode == '3')
	{		
		
		var itemParaObj = document.getElementById("divRequestItemDetails");
		itemParaObj.innerHTML = _res;
		
		//getComponentDetails();
	} 
	else 
	if(_mode == '5')
	{		
		
		var itemParaObj = document.getElementById("divPOItemDtl");
		itemParaObj.innerHTML ="<select name='strPOItemID' class='comboMax' onChange='getUnitCombo();'>"+_res+"</select>";
		getPOTypeComboValues();
		
	}
	else if(_mode == '4')
	{
	   
		var itemParaObj = document.getElementById("divComponentDetails");
		itemParaObj.innerHTML = _res;
		
	} 
	else if(_mode == '6')
	{
		var divPOTypeId = document.getElementById("generateDynamicDiv");
	       divPOTypeId.style.display="none";
	        divPOTypeId.innerHTML ="";
		var divPOTypeId = document.getElementById("divPOTypeId");
		divPOTypeId.innerHTML = "<select name='strComboPOTypeId' class='comboMax' >"+_res+"</select>";
		
		//getPOItemList();
	}
	
	else if(_mode == '8')
	{			
	       
	       document.getElementById('showbar').style.visibility = 'hidden';
	       progress_stop();
	      	      	     
		      //10100001#10000001#1010016#90#6301^1^0#10#99
		      //var divPOTypeId = document.getElementById("poRateDivId");
	          //divPOTypeId.style.display="block";		      
		      var divPOTypeId1 = document.getElementById("generateDynamicDiv");
		      divPOTypeId1.style.display="block";
		      divPOTypeId1.innerHTML = _res.split('^^^')[0]; 
		      var divPOTypeId = document.getElementById("poRateDivId");
	          divPOTypeId.style.display="block";
	          document.getElementById("imageDiv").style.display="none";
		      
	         
		      
		     
		  
	}
	else if(_mode == '88')
	{			
	       
	       document.getElementById('showbar').style.visibility = 'hidden';
	       progress_stop();      
	          
	           var divPOTypeId1 = document.getElementById("generateDynamicDiv");
		      divPOTypeId1.innerHTML = _res.split('^^^')[0];
		      
		      var   taxObj = trimAll(document.forms[0].strDOverAllTax.value);		      
		      
		      var  finalRate  = 0.00;
		      
		        if(taxObj != "" && taxObj.length > 0)
			    {
			    	finalRate = parseFloat(_res.split('^^^')[2]) + (parseFloat(_res.split('^^^')[2]) *	parseFloat(taxObj))/100;		          
			    }
			    else
			    {
			        finalRate = parseFloat(_res.split('^^^')[2]);
			    }		            
		      document.getElementById("totalPOCost").innerHTML = finalRate;
		      document.forms[0].strTotalPOCost.value = finalRate;		     
		      divPOTypeId1.style.display="block";
		      
		      var divPOTypeId = document.getElementById("poRateDivId");
	          divPOTypeId.style.display="block";
	           
		     document.getElementById("imageDiv").style.display="none";
		     document.forms[0].strGoFlag.value='1';
		     document.forms[0].strPOItemID.disabled= true;		     
		      
		      
	       		  
	}
	/*
	 * This Mode is used in case of View PO
	 * */
	else if(_mode == '880')
	{			
	       
	       document.getElementById('showbar').style.visibility = 'hidden';
	       progress_stop();      
	          
	           var divPOTypeId1 = document.getElementById("generateDynamicDiv");
		      divPOTypeId1.innerHTML = _res.split('^^^')[0];
		      
		      var   taxObj = trimAll(document.forms[0].strDOverAllTax.value);		      
		      
		      var  finalRate  = 0.00;
		      
		        if(taxObj != "" && taxObj.length > 0)
			    {
			    	finalRate = parseFloat(_res.split('^^^')[2]) + (parseFloat(_res.split('^^^')[2]) *	parseFloat(taxObj))/100;		          
			    }
			    else
			    {
			        finalRate = parseFloat(_res.split('^^^')[2]);
			    }		            
		      document.getElementById("totalPOCost").innerHTML = finalRate;
		      document.forms[0].strTotalPOCost.value = finalRate;		     
		      divPOTypeId1.style.display="block";
		      
		      var divPOTypeId = document.getElementById("poRateDivId");
	          divPOTypeId.style.display="block";
	           
		     document.getElementById("imageDiv").style.display="none";
		     document.forms[0].strGoFlag.value='1';
		     document.forms[0].strPOItemID.disabled= true;		     
		      
		      
	       		  
	}
	
	else if(_mode == '9')
	{			
	      var divPOTypeId = document.getElementById("rateDivID");
	      divPOTypeId.innerHTML ="<select name='strItemRateUnitId' onChange='resetDiv(1);' class='comboNormal' readonly>"+_res+"</select>";
	      setValueItem(1);                
	      
		   
	}
	
	else if(_mode == '99')
	{				         
		      
	      var rateDivID = document.getElementById("rateDivID");
	      rateDivID.innerHTML ="<select name='strItemRateUnitId' onChange='resetDiv(2);' class='comboNormal' >"+_res+"</select>";
	       setValueItem(2);    
		   
	}
}

function callingPoPUpTwo(parent,i)
{  
       
        myArray = document.getElementById("strSchedulePopUpHidValue"+i).value.split("#");
       
        // Store Name (1)+ Demand Qty(2) + [PO_qty(3) # Tot_Issue_Qty(3)] +Tot_Issue Qty(4)+ [Active Qty(5) # Quarntine Qty(5)] + Re-Order Qty(6) +[Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [I] +  Budget Avl(8) + DDW_ID(9)+All Sub Store(Consolidated)[10] + Pipe Line Qty [11] + Location [12]
	    //                                                                                                                                         [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [II]
	 //                                                                                                                                            [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [III]
	 // 
 			
 		document.getElementById("SchedulePoPUpHeader").innerHTML = "PO Schedule Detail(s) ";	
	    
	    //alert("myArray[0]"+myArray[0]+":myArray[1]::"+myArray[1]+":myArray[2]::"+myArray[2]+":myArray[3]::"+myArray[3]);
	    //alert("myArray[4]"+myArray[4]+":myArray[5]::"+myArray[5]+":myArray[6]::"+myArray[6]+":myArray[7]::"+myArray[7]);
	    //alert("myArray[8]"+myArray[8]+":myArray[9]::"+myArray[9]+":myArray[10]::"+myArray[10]+":myArray[11]::"+myArray[11]);
	    //alert("myArray[12]"+myArray[12]+":myArray[13]::"+myArray[13]+":myArray[14]::"+myArray[14]+":myArray[15]::"+myArray[15]);
	    
	    var objVal1 = document.getElementById("21");
        
        objVal1.innerHTML = myArray[0]; 
        
                    
        var objVal2 = document.getElementById("22");
        
       
         
          objVal2.innerHTML = myArray[2]; 
        
        
        var objVal3 = document.getElementById("23");
        
        
         
          objVal3.innerHTML = myArray[3];  
        
        
        
        var objVal4 = document.getElementById("24");
        
         objVal4.innerHTML = parseInt(myArray[2])+parseInt(myArray[3]);  
         
         /******************************************************************/
         var objVal5 = document.getElementById("25");
        
        
         
          objVal5.innerHTML = myArray[4]; 
        
                    
        var objVal6 = document.getElementById("26");
        
        
         
          objVal6.innerHTML = myArray[6]; 
        
        
        var objVal7 = document.getElementById("27");
        
        
         
          objVal7.innerHTML = myArray[7];  
        
        
        
        var objVal8 = document.getElementById("28");
        
         objVal8.innerHTML = parseInt(myArray[6])+parseInt(myArray[7]);  
         /******************************************************************/
         
         var objVal9 = document.getElementById("29");
        
        
         
          objVal9.innerHTML = myArray[8]; 
        
                    
        var objVal10 = document.getElementById("30");
        
        
         
          objVal10.innerHTML = myArray[10]; 
       
        
        var objVal11 = document.getElementById("31");
        
        
         
        objVal11.innerHTML = myArray[11];  
        var objVal12 = document.getElementById("32");
        objVal12.innerHTML = parseInt(myArray[10])+parseInt(myArray[11]); 
         
          /******************************************************************/
         
         var objVal13 = document.getElementById("33");
        
        
         
        objVal13.innerHTML = myArray[12]; 
        
                    
       var objVal14 = document.getElementById("34");
       objVal14.innerHTML = myArray[14]; 
       var objVal15 = document.getElementById("35");
       objVal15.innerHTML = myArray[15];  
       var objVal16 = document.getElementById("36");
       objVal16.innerHTML = parseInt(myArray[14])+parseInt(myArray[15]); 
       display_popup_menu(parent,'ScheduleDtl','200','');
	
}



function callingPoPUp(parent,i)
{  
       // alert("Hidden value:::"+document.getElementById("strPODetailsHidValue"+i).value);
       myArray = document.getElementById("strPODetailsHidValue"+i).value.split("^");
       // Store Name (1)+ Demand Qty(2) + [PO_qty(3) # Tot_Issue_Qty(3)] +Tot_Issue Qty(4)+ [Active Qty(5) # Quarntine Qty(5)] + Re-Order Qty(6) + Order Qty(7) +  Budget Avl(8) + DDW_ID(9)+All Sub Store(Consolidated)[10] + Pipe Line Qty [11] + Location [12]
 	   document.getElementById("PoPUpHeader").innerHTML = myArray[0]+ " :::: "+document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].text+" ";	
	   var objVal100 = document.getElementById("100");
        if(myArray[1]!='null')
        {
         
          objVal100.innerHTML = myArray[1]; 
        }
        else
        {
          objVal100.innerHTML = "  ----";
        }             
        var objVal200 = document.getElementById("200");
        if(myArray[2].split("#")[0]!='null')
        {
         
          objVal200.innerHTML = myArray[2].split("#")[0]; 
        }
        else
        {
          objVal200.innerHTML = "  ----";
        }  
        var objVal300 = document.getElementById("300");
        
        if(myArray[2].split("#")[1]!= 'null')
        {
         
          objVal300.innerHTML = myArray[2].split("#")[1];  
        }
        else
        {
          objVal300.innerHTML = "----";
        } 
	   
	   
	   
	    var objVal1 = document.getElementById("1");
        if(myArray[3]!='null')
        {
         
          objVal1.innerHTML = myArray[3]; 
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }             
        var objVal2 = document.getElementById("2");
        if(myArray[10]!='null')
        {
        objVal2.innerHTML = myArray[10]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        var objVal3 = document.getElementById("3");
        
        if(myArray[4].split("#")[0]!= 'null')
        {
         
          objVal3.innerHTML = myArray[4].split("#")[0];  
        }
        else
        {
          objVal3.innerHTML = "----";
        } 
        var objVal4 = document.getElementById("4");
        if(myArray[4].split("#")[1]!= 'null')
        {
         objVal4.innerHTML = myArray[4].split("#")[1];  
        }
        else
        {
          objVal4.innerHTML = "----";
        } 
        var objVal5 = document.getElementById("5");
        
        if(myArray[9]!= 'null')
        {
          
          objVal5.innerHTML = myArray[9];  
        }
        else
        {
          objVal5.innerHTML = "----";
        } 
        
        var objVal6 = document.getElementById("6");
        if(myArray[5]!= 'null')
        {
          
          objVal6.innerHTML = myArray[5];  
        }
        else
        {
          objVal6.innerHTML = "----";
        } 
        display_popup_menu(parent,'PoDtl','200','');
	
}

function hideItemDetails(divId)
{
      hide_popup_menu(divId);
}


function setVlue(index)
{
	document.getElementById("ajaxFlg"+index).value='1';
}

function showDiv(_strDivId){
	//document.getElementById(_strDivId).style.display="block";
}

function hideDiv(_strDivId){
	//document.getElementById(_strDivId).style.display="none";
}

function showDiv1(_strDivId)
{
	document.getElementById(_strDivId).style.display="block";
}

function hideDiv1(_strDivId)
{
	document.getElementById(_strDivId).style.display="none";
}

function checkAll()
{
	try
	{
		if(document.forms[0].strCheckAll.checked==true)
		{
			var strCheckBox=document.getElementsByName("strCheckAll");
			for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++)
			{
				strCheckBox[nTmpI].checked=true;
				
		    }		    
		}
	}
	catch(_Err)
	{
	}

}


function approval()
{	
	//document.forms[0].strItemRate.disabled = false;
	//document.forms[0].strItemRateTax.disabled = false;
	//document.forms[0].strPOItemID.disabled = false; 
	//document.forms[0].strItemMake.disabled = false;
	document.getElementsByName("strOrderQtyUnitId")[0].disabled = false; 
	var hisValidator = new HISValidator("PODeskGenerateTransBean");
	//hisValidator.addValidation("strPOItemID",        "dontselect=0", "Please Select Drug Name" );
	//hisValidator.addValidation("strItemRate",        "req", "Please enter Item Rate" );
	//hisValidator.addValidation("strItemRateUnitId",  "dontselect=0", "Please Select Rate Unit" );	
	//hisValidator.addValidation("strItemRate",        "req", "Please enter Item Rate" );
	//hisValidator.addValidation("strItemRateTax",     "req", "Please enter Item wise Tax" );
	//hisValidator.addValidation("strItemManufacturerId","dontselect=0", "Please select Manufactrer" );	
	//hisValidator.addValidation("strPoRefrenceNo","dontselect=0", "Please select PO Refrence No" );	
  //  hisValidator.addValidation("strPORefrenceDate",  "req", "Please Enter PO Reference Date." );       
	//hisValidator.addValidation("strDPurchaseSource", "dontselect=0", "Please select Purchase Source" );
//	hisValidator.addValidation("strDDeliveryDays",   "req", "Please enter Delivery Days");
	//hisValidator.addValidation("strDDeliveryLocation","dontselect=0", "Please select Delivery Location" );
	//hisValidator.addValidation("strDTenderNo",      "req", "Please Enter Tender No." );
   // hisValidator.addValidation("strDTenderDate",    "req", "Please Enter Tender Date." );   
	hisValidator.addValidation("strVerifiedBy",     "dontselect=0", "Please select Approved By" );
	hisValidator.addValidation("strVerifiedDate",   "req", "Approval Date is Mandatory" );

		//if(document.forms[0].strDTenderDate.value.length==11 && document.forms[0].strDQuotationDate.value.length==11)
		//	hisValidator.addValidation("strDTenderDate", "dtlt="+document.forms[0].strDQuotationDate.value, "Tender Date Must be Less than Quotation Date." );
	
	//	if(document.forms[0].strDQuotationDate.value.length==11)
	//	{
			//hisValidator.addValidation("strDQuotationDate", "dtlt="+document.forms[0].strDDeliveryDate.value, "Quotation Date Must be Less than Delivery Date." );
		//	hisValidator.addValidation("strDQuotationDate", "dtlt="+document.forms[0].strCurrentDate.value, "Quotation Date Must be Less than Current Date." );
		//}
	
	//	if(document.forms[0].strDTenderDate.value.length==11)
	//	{
			//hisValidator.addValidation("strDTenderDate", "dtlt="+document.forms[0].strDDeliveryDate.value, "Tender Date Must be Less than Delivery Date." );
		//	hisValidator.addValidation("strDTenderDate", "dtlt="+document.forms[0].strCurrentDate.value, "Tender Date Must be Less than Current Date." );
		//}
		
		//if(document.forms[0].strNextPoDate.value!='')
	//	{
	//		hisValidator.addValidation("strNextPoDate", "dtgt="+document.forms[0].strCurrentDate.value, "Next PO Date Must be greater than Current Date." );
	//		hisValidator.addValidation("strNextPoDate", "dtgtet="+document.forms[0].strPODate.value, "Next PO Date Must be greater than PO Date." );
	//	}
		
		//hisValidator.addValidation("strDDeliveryDate", "dtgtet="+document.forms[0].strCurrentDate.value, "Delivery Date Must be greater or equals to than Current Date." );
	hisValidator.addValidation("strDRemarks", "req"       , "Remarks is Mandatory" );
	hisValidator.addValidation("strDRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	if(retVal)
	{
	   		var orderQty = document.getElementsByName("strQrderQty");       	 	               
            var len = orderQty.length;		           
	        var count = 0,j=0;		
	          
	        for(var i=0;i<len;i++)
	        {
	        	
	           	if(orderQty[i].value=="" ||  orderQty[i].value=="0" ||  orderQty[i].value==0)
	          	{
	          		count++;		          		        	
	          	}		          	
	        }			       
	        if(len==count)
	        {
		       	alert(" Order Qty is zero\n\nPlease enter Ordered Quantity !!");
		       	orderQty[0].focus();
		       	return false;
	        }
	        else
	        {	
	  
				if(	confirm("You Are Going To Save Approval Details of " +
						    "\n PO No :  " + document.forms[0].strPONo.value 
						  // +" & PO Value : " + document.forms[0].strTotalPOCost.value
						  )
					)
				
				{
					if(confirm(" Are You Sure You Want to Save ?"))
					{				   
						 document.forms[0].hmode.value="APPROVEDPO";
						 document.forms[0].submit();						
					}	
					
				}
				else
				{
					return false;
				}	
	        }
					   
	}

}




