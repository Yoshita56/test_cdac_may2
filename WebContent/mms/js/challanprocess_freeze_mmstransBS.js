function getMultiRow(obj)
{
     	var noOfRow = document.forms[0].strNoOfMultiRow.value;
     	for(var i=0; i<noOfRow;i++)
     	{     		
     		addRows(new Array('strMultiRowBatchNo','strMultiRowReceiveQty','strMultiRowUnit'),new Array('t','t','s'),'1','1','R');     		
     	}
     	//document.getElementById("compileId").style.display="block"; 
}
function hideGroup(index)
{	
	if(document.getElementById("buttonVal"+index).value=='0')
	{
		document.getElementById("minusButtodId").style.display="block";
	    document.getElementById("plusButtodId").style.display="none";
	    document.getElementById("buttonVal"+index).value='1';
	    document.getElementById("receivedDrugDtl"+index).style.display="block";
	   
	}	
	else
	{		
		document.getElementById("receivedDrugDtl"+index).style.display="none";
		document.getElementById("minusButtodId").style.display="none";
	    document.getElementById("plusButtodId").style.display="block";
	    document.getElementById("buttonVal"+index).value='0';
	   
	    
	}
}
function compileDrug(index)
{
  	var batchNo             = document.getElementsByName("strMultiRowBatchNo");   
    var recevQty            = document.getElementsByName("strMultiRowReceiveQty"); 
    var unit                = document.getElementsByName("strMultiRowUnit"); 
    var len = recevQty.length;	
    var totQty  = 0;        
	var count = 0,j=0;	
	var flag=true;	
	var strStoreId;        
    for(var i=0;i<len-1;i++)
    {
       	if(batchNo[i].value!="" && recevQty[i].value!=""  &&  unit[i].value!="0")
      	{
      		count++;	
      		totQty = totQty +  parseInt(recevQty[i].value);          		        	
      	}		          	
    }
   
    if(count == (len-1))
    {
    	var balQty = document.getElementById("strReceivedItemHiddenDtl"+index).value.split("^")[2];
    	if(totQty >parseInt(balQty))
    	{
    	    alert("Total Received Quantity ["+ totQty +"] of All Batch Should not be greater than Balance Qty ["+balQty+"]");	
    	    for(var i=0;i<len-1;i++)
		    {   	
		      		recevQty[i].value ='';          		        	
		    }
		    return false;  		
    	}
    	else
    	{
		  document.getElementById("strNewReceivedQty"+index).value = 	totQty;
		  document.getElementById("receivedDrugDtl"+index).style.display="none";
		    flag=true;
			for(var i=0;i<len-1;i++)
			{
			 
					if(flag)
					{
						
						strStoreId = batchNo[i].value+"^"+recevQty[i].value+"^"+unit[i].value;											
						flag=false;
					} 
					else
					{
						strStoreId+= "#"+batchNo[i].value+"^"+recevQty[i].value+"^"+unit[i].value;
					
					}
					
			}
			document.getElementById("strReceivedItemMultiRowDtl"+index).value = strStoreId;
    	}              
   		
    }
    else
  	{
  		alert("Please Enter  Batch No , Drug Received Qty & Unit Name !!!!");
  		batchNo[0].focus();
	    retVal = false;
  	}
    
}

function getBatchCompareCmb(obj)
{
	
    var dLength = document.getElementsByName("strMultiRowBatchNo").length - 1;

	if(dLength>1)
	{
		    var relation_ship=document.getElementsByName("strMultiRowBatchNo");		
			for(var j=0;j<dLength;j++)
			{
				if(obj!=relation_ship[j])
				{	
					if((relation_ship[j].value == obj.value) && (relation_ship[j].value!='' && obj.value!=''))
					{
						alert("Cannot choose Same Batch again");	
						obj.value='';
						obj.focus();
					}								
				}
			}
	  }
			
}

function CalculateDrugCost()
{
		           /**
			 		 * Calculate Total Cost of Item
			 		 */
			 		 //document.forms[0].strSalePrice.disabled = "false";
			 		 document.forms[0].strSalePriceUnitId.disabled = "false";			 		 
			 		 var  rateObj              = document.forms[0].strSalePrice.value;	   
			 		 var  rate_unit_base_value = document.forms[0].strSalePriceUnitId.value.split("^")[1];
					 var  qtyObj               = document.forms[0].strAcceptedQuantity.value;
					 var  qty_unit_base_value  = document.forms[0].strAcceptedQuantityUnitId.value.split("^")[1];	
					 //alert("qty:::"+qtyObj+"::Rate:::"+rateObj+"::rate_unit_base_value:::"+rate_unit_base_value+"::qty_unit_base_value::"+qty_unit_base_value);	
       				 if(document.forms[0].strSalePriceUnitId.value!='0' && document.forms[0].strAcceptedQuantityUnitId.value!='0')  
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
       				// document.forms[0].strSalePrice.disabled = "true";
			 		 document.forms[0].strSalePriceUnitId.disabled = "true";			       				 
			 		//NVL(HSTNUM_PURCHASE_RATE,''0'')/Mms_Mst.getUnitBaseValue(HSTNUM_RATE_UNITID,GNUM_HOSPITAL_CODE))*NVL( (HSTNUM_RECIEVED_QTY - HSTNUM_RETURNED_QTY)
			 		/**
			 		 * Total Cost Calculation End
			 		 */
}

     function calcIssueRateTwo()
	 {
	 	
	 	        /**
	 	         * Default Supplier Performance Detail Checked Value 
	 	         */
	 	         //HSTSTR_REPORT_NO||'^'||HSTDT_REPORT_DATE||'^'||HSTSTR_DRUG_CONDITION||'^'||
	 	         //HSTSTR_IS_QC_PRINTED||'^'||HSTSTR_IS_GENERIC||'^'||HSTSTR_IS_MRP_PRINTED
	 	         /*
	 	         if(document.forms[0].strSupplierPerformanceFlag.value>'0' ||document.forms[0].strSupplierPerformanceFlag.value=='1')
	 	         {
	 	         		 	         	
		 	         if(document.forms[0].strSupplierPerformanceInfo.value.split("^")[0]!='')
		 	         {
		 	         	document.forms[0].isTestReport[0].checked=true;
		 	         	document.forms[0].isTestReport[1].checked=false;
		 	         	document.forms[0].isTestReport[0].disabled = true;
		 	         	document.forms[0].isTestReport[1].disabled = true;
		 	         	 document.forms[0].strTestReportFlg.value='1';
		 	         	document.forms[0].strReportNumber.value = document.forms[0].strSupplierPerformanceInfo.value.split("^")[0];
		 	         	document.forms[0].strReportDate.value = document.forms[0].strSupplierPerformanceInfo.value.split("^")[1];
		 	         	document.forms[0].strReportNumber.disabled = true;
		 	         	document.forms[0].strReportDate.disabled = true;
		 	         }
		 	         else
		 	         {
		 	         	document.forms[0].isTestReport[1].checked=true;
		 	         	document.forms[0].isTestReport[0].checked=false;
		 	         	document.forms[0].isTestReport[0].disabled = true;
		 	         	document.forms[0].isTestReport[1].disabled = true;
		 	         	document.forms[0].strTestReportFlg.value='0';
		 	         	document.forms[0].strReportNumber.value = document.forms[0].strSupplierPerformanceInfo.value.split("^")[0];
		 	         	document.forms[0].strReportDate.value = document.forms[0].strSupplierPerformanceInfo.value.split("^")[1];
		 	         	document.forms[0].strReportNumber.disabled = true;
		 	         	document.forms[0].strReportDate.disabled = true;
		 	         }
		 	         if(document.forms[0].strSupplierPerformanceInfo.value.split("^")[2]!='1')
		 	         {
		 	            document.forms[0].isGoodCond[0].checked=false;
		 	            document.forms[0].isGoodCond[1].checked=true;
		 	            document.forms[0].strMedicienCondFlg.value='1';
		 	            document.forms[0].isGoodCond[0].disabled = true;
		 	            document.forms[0].isGoodCond[1].disabled = true;
		 	         }
		 	         else
		 	         {
		 	         	document.forms[0].isGoodCond[0].checked=true;
		 	            document.forms[0].isGoodCond[1].checked=false;
		 	            document.forms[0].strMedicienCondFlg.value='0';
		 	            document.forms[0].isGoodCond[0].disabled = true;
		 	            document.forms[0].isGoodCond[1].disabled = true;
		 	         	
		 	         }
		 	         if(document.forms[0].strSupplierPerformanceInfo.value.split("^")[2]!='1')
		 	         {
		 	            document.forms[0].isGoodCond[0].checked=false;
		 	            document.forms[0].isGoodCond[1].checked=true;
		 	            document.forms[0].strMedicienCondFlg.value='1';
		 	            document.forms[0].isGoodCond[0].disabled = true;
		 	            document.forms[0].isGoodCond[1].disabled = true;
		 	         }
		 	         else
		 	         {
		 	         	document.forms[0].isGoodCond[1].checked=false;
		 	            document.forms[0].isGoodCond[0].checked=true;
		 	            document.forms[0].strMedicienCondFlg.value='0';
		 	            document.forms[0].isGoodCond[0].disabled = true;
		 	            document.forms[0].isGoodCond[1].disabled = true;
		 	         }
		 	         if(document.forms[0].strSupplierPerformanceInfo.value.split("^")[3]!='1')
		 	         {
		 	            document.forms[0].isNotForSale[0].checked=false;
		 	            document.forms[0].isNotForSale[1].checked=true;
		 	            document.forms[0].strGovtSupplyFlg.value='1';
		 	            document.forms[0].isNotForSale[0].disabled = true;
		 	            document.forms[0].isNotForSale[1].disabled = true;
		 	         }
		 	         else
		 	         {
		 	         	document.forms[0].isNotForSale[1].checked=false;
		 	            document.forms[0].isNotForSale[0].checked=true;
		 	            document.forms[0].strGovtSupplyFlg.value='0';
		 	            document.forms[0].isNotForSale[0].disabled = true;
		 	            document.forms[0].isNotForSale[1].disabled = true;
		 	         }
		 	         if(document.forms[0].strSupplierPerformanceInfo.value.split("^")[4]!='1')
		 	         {
		 	            document.forms[0].isGenricName[0].checked=false;
		 	            document.forms[0].isGenricName[1].checked=true;
		 	            document.forms[0].strMedicineTypeFlg.value='1';
		 	            document.forms[0].isGenricName[0].disabled = true;
		 	            document.forms[0].isGenricName[1].disabled = true;
		 	         }
		 	         else
		 	         {
		 	         	document.forms[0].isGenricName[1].checked=false;
		 	            document.forms[0].isGenricName[0].checked=true;
		 	            document.forms[0].strMedicineTypeFlg.value='0';
		 	            document.forms[0].isGenricName[0].disabled = true;
		 	            document.forms[0].isGenricName[1].disabled = true;
		 	         	
		 	         }
		 	         if(document.forms[0].strSupplierPerformanceInfo.value.split("^")[5]!='1')
		 	         {
		 	            document.forms[0].isMRPPrint[0].checked=false;
		 	            document.forms[0].isMRPPrint[1].checked=true;
		 	            document.forms[0].strMrpPrintedFlg.value='1';
		 	            document.forms[0].isMRPPrint[0].disabled = true;
		 	            document.forms[0].isMRPPrint[1].disabled = true;
		 	         }
		 	         else
		 	         {
		 	         	document.forms[0].isMRPPrint[1].checked=false;
		 	            document.forms[0].isMRPPrint[0].checked=true;
		 	            document.forms[0].strMrpPrintedFlg.value='0';
		 	            document.forms[0].isMRPPrint[0].disabled = true;
		 	            document.forms[0].isMRPPrint[1].disabled = true;
		 	         }
		 	         
		 	         
	 	         }
	 	         else
	 	         {   */ 
	 	         
		 	         document.forms[0].isTestReport[0].checked=true;
		 	         document.forms[0].isGoodCond[0].checked=true;
		 	         document.forms[0].isNotForSale[0].checked=true;
		 	        
		 	         document.forms[0].isMRPPrint[0].checked=true;
		 	         
		 	         document.forms[0].strTestReportFlg.value='1';
					 document.forms[0].strMedicienCondFlg.value='1';
					 document.forms[0].strGovtSupplyFlg.value='1';
					 document.forms[0].strMedicineTypeFlg.value='1';
					 document.forms[0].strMrpPrintedFlg.value='1';
	 	         //}
	 	        document.forms[0].strSalePriceUnitId.disabled = true;
 	
			 	var         isseRate = parseFloat("0");
			 	var     purchaseRate = document.forms[0].strDummySalePrice.value;
			 	var confgIsseRateVal = document.forms[0].strConfigIssueRate.value;
			 	
			 		 	
			 	
			 	if(document.forms[0].strIssueRateConfigFlg.value=='1')
			 	{
			 		var result1 = (Math.abs(purchaseRate) * confgIsseRateVal) / Math.pow(10, 2);
			 	    var cost = roundValue(result1,2);
			 	    document.forms[0].strSalePrice.value = cost;
			 	    //alert("purchaseRate::::"+purchaseRate+"::confgIsseRateVal::"+confgIsseRateVal+"::Tota Cost:::"+cost);
			 	  //  document.forms[0].strSalePrice.disabled = "true";
			 		
			 		//document.forms[0].strSalePrice.disabled = "true";
			 		//document.forms[0].strSalePrice.value = purchaseRate.split("/")[0];
			 	}
			 	else
			 	{
			 		document.forms[0].strSalePrice.value = purchaseRate.split("/")[0];
			 	//	document.forms[0].strSalePrice.disabled = "false";
			 	}
			 	/*
			 	 * Item Make Value Get from HSTT_PO_ITEM_DTL with Index 33
			 	 * */
			 	if(document.forms[0].strItemMake.value==2)
			 	{
			 		 document.forms[0].isGenricName[0].checked=false;
			 		 document.forms[0].isGenricName[0].disabled=true;
			 		 document.forms[0].isGenricName[1].disabled=true;
			 		 document.forms[0].strMedicineTypeFlg.value='0';
			 		 
			 	}
			 	else
			 	{
			 		 document.forms[0].isGenricName[0].checked=true;
			 		 document.forms[0].isGenricName[0].disabled=false;
			 		 document.forms[0].isGenricName[0].disabled=false;
			 		// document.forms[0].strMedicineTypeFlg.value='1';
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
	 	
	 	document.getElementById("balQtyTitleDivId").innerHTML = itemName+" - Item Balance Qty.";
	 	document.getElementById("ordQtyDivId").innerHTML = ordQty;
	 	document.getElementById("recQtyDivId").innerHTML = recQty;
	 	
	 	display_popup_menu(parentObj, "balQtyDtlsDivId" , "","");
	 	
	 }
	 
	 
	  /**
	 * showOffLineBalQtyDtls
	 * @param {Object} parentObj 
	 * @param {String} ordQty
	 * @param {String} recQty
	 * @param {String} itemName
	 */
	 function showOffLineBalQtyDtls(parentObj,ordQty,recQty,itemName,rejectedQty,shortageQty,unitName)
	 {
	 	
	 	document.getElementById("offLineBalQtyTitleDivId").innerHTML = itemName+" - Drug Balance Qty Detail(s)";
	 	document.getElementById("offLineBalOrdQtyDivId").innerHTML   = ordQty;
	 	document.getElementById("offLineBalRecQtyDivId").innerHTML   = recQty;
	 	document.getElementById("offLineBalRejQtyDivId").innerHTML   = rejectedQty+" "+unitName;
	 	document.getElementById("offLineBalShortQtyDivId").innerHTML = shortageQty+" "+unitName;
	 	
	 	var intOrderQty    = parseInt(ordQty,10);
	 	var intRecQty      = parseInt(recQty,10);
	 	var intRejectedQty = parseInt(rejectedQty,10);
	 	var intShortageQty = parseInt(shortageQty,10);
	 	var finalBalQty    = intOrderQty -(intRecQty-intRejectedQty-intShortageQty);
	 	document.getElementById("offLineFianlBalQtyDivId").innerHTML = ordQty+"-("+intRecQty+"-"+intRejectedQty+"-"+intShortageQty+")="+finalBalQty+" "+unitName;

	 	
	 	display_popup_menu(parentObj, "offLineBalQtyDtlsDivId" ,"500","320");
	 	
	 }
	 
	 
	 
	 function calcIssueRate()
	 {
		if(document.forms[0].strIssueRateConfigFlg.value=='1')
		{
		 	
				 	var         isseRate = parseFloat("0");
				 	var     purchaseRate = document.forms[0].strRate.value;
				 	var confgIsseRateVal = document.forms[0].strConfigIssueRate.value;
				 	
				 	
				 	var result1 = (Math.abs(purchaseRate) * confgIsseRateVal) / Math.pow(10, 2);
				 	
				 	var cost = roundValue(result1,2);
				 	document.forms[0].strSalePrice.value = cost;
				 //	document.forms[0].strSalePrice.disabled = true;
				 	CalculateDrugCost();
				 	
		 	
		}
		 	
	 }

function pageResetMethod()
{
	
	document.forms[0].reset();
//	document.forms[0].strSalePrice.disabled = true;
	document.forms[0].strSalePrice.value = document.forms[0].strDummySalePrice.value;
	
	
}
function pageReset()
{
	document.forms[0].reset();
	
	document.getElementById("recpCalender").style.display="block";
	document.getElementById("supplierRecDate").style.display="none";
		  
	document.getElementById("calDate").style.display="block";
	document.getElementById("dateVal").style.display="none";
	
	objVal = document.getElementById("scheduleDtlsDivId");
	objVal.innerHTML = "";
	document.forms[0].strSupplierReceiptNo.disabled=false;
	 document.getElementById("goImageDiv").style.display="block"; 
	
}	 
/**

	JS Function used in committetype
**/
function getMemberDtl(mode)
{
	var mode=mode
	document.getElementsByName("strReportNumber")[0].focus();
	var url="ChallanProcessTransCNT.cnt?hmode="+mode+"&committeType="+document.forms[0].strCommitteeType[document.forms[0].strCommitteeType.selectedIndex].value+"&itemCategNo="+document.forms[0].strItemCategoryId.value;
	ajaxFunction(url,"2");
	document.getElementsByName("strReportNumber")[0].focus();
}
	 
	 
	 /**
	  * getScheduleDtls
	  * @param {object} cmbObj 
	  */
	  function getScheduleDtls(cmbObj) 
	  {
	  	
	  	
	  	var mode = "GETSCHEDULEDTLS";

		var url = "ChallanProcessTransCNT.cnt?hmode=" + mode + "&strScheduleDtls="+cmbObj.value+"&strPoNo="+
								document.forms[0].strPoNo.value+"&strPoStoreId="+document.forms[0].strPoStoreId.value;
		ajaxFunction(url, "1");
	  	
	  }
	function getScheduleDetails() 
	{			
		var hisValidator = new HISValidator("challanProcessBean");
		hisValidator.addValidation("strReceiveDate", "req", "Received Date a Mandatory Field");
		hisValidator.addValidation("strSupplierReceiptNo", "req", "Challan/Invoice No. a Mandatory Field");
		//alert("Ct Date::"+document.forms[0].strCtDate.value+"::Rece::"+document.forms[0].strSupplierReceiptDate.value);
	    hisValidator.addValidation("strSupplierReceiptDate", "req", "Challan/Invoice Date a Mandatory Field");
	    hisValidator.addValidation("strSupplierReceiptDate","dtltet="+document.forms[0].strCtDate.value,"Please Select Challan/Invoice Date Less Than or Equal To Current Date");
	  	hisValidator.addValidation("strReceiveDate", "dtgtet="+document.forms[0].strSupplierReceiptDate.value,"Received Date should be Greater Than or Equal Challan/Invoice Date");
	  	hisValidator.addValidation("strReceiveDate", "dtltet="+document.forms[0].strCtDate.value,"Received Date should be Less Than or Equal To Current Date");
		var retVal = hisValidator.validate();
		hisValidator.clearAllValidations();		
		if (retVal) 
		{
			//if(document.forms[0].strChallanCount.value=='0')
			//{
			 
			 
			 var mode = "SCHEDULEDTL";			 
			 var url = "ChallanProcessTransCNT.cnt?hmode="+mode+"&strPoNo="+document.forms[0].strPoNo.value+"&strPoStoreId="+document.forms[0].strPoStoreId.value+"&strReceiveDate="+document.forms[0].strReceiveDate.value+"&strStoreId="+document.forms[0].strStoreId.value;
			 //alert(url);
			 ajaxFunction(url, "4");
			//}
		} 
		else 
		{
			return false;
		}
	}
	
	 function getChallanVerifyDtlOne(obj) // Batch No ^ Expiry Date ^ Received Qty  [ Off-Line ]
	 {
	 	if(obj.value!='0')
	 	{
	 		 document.forms[0].strBatchNo.value = obj.value.split("^")[0];	 	
	 		 document.forms[0].strExpiryDate.value = obj.value.split("^")[1];	 		 
	 		 document.getElementById("receiveQtyOrg").style.display="none";
             document.getElementById("receiveQtyDup").style.display="block";
	 		 document.getElementById("receiveQtyDup").innerHTML = obj.value.split("^")[2]+" No."; 
	 		 document.forms[0].strRejectedQuantity.value="0";
	 	}
	 	else
	 	{
	 		 document.getElementById("receiveQtyOrg").style.display="block";
             document.getElementById("receiveQtyDup").style.display="none";
	 		 document.getElementById("receiveQtyDup").innerHTML = ""; 
	 		 document.forms[0].strBatchNo.value = "";	 	
	 		 document.forms[0].strExpiryDate.value = "";
	 	}
	 } 
	  function getChallanVerifyDtlTwo(obj) // Batch No ^ Accepted Qty ^ Bkg Qty ^ Excess Qty ^ Rejected Qty ^ Stock Page No ^ Remarks  [ On-Line ]
	 {
	 	if(obj.value!='0')
	 	{
	 		 document.forms[0].strBatchNo.value = obj.value.split("^")[0];	 	
	 		 document.forms[0].strExpiryDate.value = obj.value.split("^")[1];
	 		 document.forms[0].strReceivedQuantityView.value = obj.value.split("^")[2];
	 		 document.forms[0].strVerifiedQuantityView.value="0";
	 		 document.forms[0].strRejectedQuantity.value="0";
	 	}
	 	else
	 	{
	 		 document.forms[0].strBatchNo.value = "";	 	
	 		 document.forms[0].strExpiryDate.value = "";
	 	}
	 } 
	  
	  function getAjaxResponse(res, mode) 
	  {
			  	var err = document.getElementById("errMsg");
				var temp = res.split("####");
				if(temp[0] == "ERROR")
				{
					err.innerHTML = temp[1];
					return;
				}
				var objVal;
				if (mode == "1") 
				{
			        
					objVal = document.getElementById("scheduleDtlsDivId");
					objVal.innerHTML = res;
				}
					
				if(mode=="2")
				{				
				
					document.getElementById("memberDtlInner").innerHTML=res;	
					document.getElementsByName("strReportNumber")[0].focus();
					document.getElementsByName("strReportNumber")[0].focus();
					document.getElementById("strReportNumber").focus();	
					document.getElementsByName("strMemberRecommendation")[0].focus();
				}
		
				if(mode=="3")
				{				
				
					document.getElementById("balQtyDtlsDivId").innerHTML=res;	
					display_popup_menu(gblParentObj, "balQtyDtlsDivId" , "","");
										
				}
				if (mode == "4") 
				{
			        
					objVal = document.getElementById("scheduleDtlsDivId");
					objVal.innerHTML = res;
					document.getElementById("scheduleDtlsDivId").style.display="block"; 	
					
					document.getElementById("calDate").style.display="none";
		            document.getElementById("dateVal").style.display="block";
		            document.getElementById("dateVal").innerHTML=document.getElementsByName("strReceiveDate")[0].value;
					
					document.getElementById("recpCalender").style.display="none";
		            document.getElementById("supplierRecDate").style.display="block";
		            document.getElementById("supplierRecDate").innerHTML=document.getElementsByName("strSupplierReceiptDate")[0].value;
					document.forms[0].strSupplierReceiptNo.disabled=true;
					document.getElementById("goImageDiv").style.display="none"; 
										
				}
				
				if(mode=="5")
				{
					document.getElementById("suppliedDtlsDivId").innerHTML=res;
					getSuppliedItemDetails();					
				}
				if(mode=="6")
				{
					document.getElementById("suppliedItemDtlsDivId").innerHTML=res;					
				}
	  }
	  
	  
	 
	 /**
	  * validation 
	  */
	  function validationRec() 
	  {
	  	var errContent = document.getElementById("errMsg").innerHTML ;
	  	if(errContent.length > 0)
	  	{
	  		alert("Process Cannot be Saved due to '"+errContent+"'");
	  		return false;
	  	}
	  	var hisValidator = new HISValidator("challanProcessBean");
	  	if(document.forms[0].strPoTypeId.value == '24')
	  	{
	  		hisValidator.addValidation("strAwbNo", "req", "AWB No. is a Mandatory Field");
	  		hisValidator.addValidation("strBeNo", "req", "BE No. is a Mandatory Field");
	  		hisValidator.addValidation("strBeDate", "req", "BE Date is a Mandatory Field");
	  	}
	  	hisValidator.addValidation("strReceiveDate", "req", "Received Date a Mandatory Field");
	  	
	  	if(document.forms[0].strSupplierReceiptNo)
	  	hisValidator.addValidation("strSupplierReceiptNo", "req", "Challan/Invoice No. a Mandatory Field");
	  		  	
	  	hisValidator.addValidation("strSupplierReceiptDate", "req", "Challan/Invoice Date a Mandatory Field");
	  	if(document.getElementsByName("strSupplierReceiptDate")[0].value!="")
	  	{
	  		hisValidator.addValidation("strSupplierReceiptDate","dtltet="+document.forms[0].strCtDate.value,"Please Select Challan/Invoice Date Less Than or Equal To Current Date");
	  		hisValidator.addValidation("strReceiveDate", "dtgtet="+document.forms[0].strSupplierReceiptDate.value,"Received Date should be Greater Than or Equal Challan/Invoice Date");
	  		
	  	}
	   // alert("PO Date:::"+document.forms[0].strPourchaseOrderDate.value+"::Receipt Date::"+document.forms[0].strSupplierReceiptDate.value);
	    var poDate = document.forms[0].strPourchaseOrderDate.value;
	  	//hisValidator.addValidation("strSupplierReceiptDate","dtltet="+poDate,"Please Select Challan/Invoice Date Less Than or Equal To PO Date "+poDate);
	  	hisValidator.addValidation("strSupplierReceiptDate","dtgtet="+poDate+"", "Please Select Challan/Invoice Date Greater Than or Equal To PO Date"+poDate);
	  	
	  	hisValidator.addValidation("strNoOfPackets", "req", "No. of Packets is a Mandatory Field");
	  	
	  	if(document.forms[0].strDeliveryMode)
	  	hisValidator.addValidation("strDeliveryMode", "dontselect=0", "Please Select a Delivery Mode");
  	  		  	
  	  	if(document.forms[0].strNewReceivedQty)
	  	hisValidator.addValidation("strNewReceivedQty" , "req" , "Received Quantity is a Mandatory Field");
	  	
	  	//hisValidator.addValidation("strReceivedUnitId", "dontselect=0", "Please Select a Unit Name ");
 		//hisValidator.addValidation("strScheduleNo", "dontselect=0", "Please Select a Schedule No.");
				
		hisValidator.addValidation("strReceivedBy", "req", "Name of the Receiver is a Mandatory Field");
		
		hisValidator.addValidation("strReceivedComboBy","dontselect=0","Please Select a Value from Received By Combo" );
		
		if(document.forms[0].strDeliveryModeText)
		hisValidator.addValidation("strDeliveryModeText", "req", "Deliver Mode Name is a Mandatory Field");
		
		//hisValidator.addValidation("strRemarks", "req", "Remarks is a Mandatory Field");
		hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks cannot contains more than 100 Characters");
		hisValidator.addValidation("strPackageWeight", "numltet=9999.99", "Weight cannot be more than 9999.99 kg");
		  	
		  
		  	
	  	var retVal = hisValidator.validate();
	
		hisValidator.clearAllValidations();

		if (retVal) 
		{
			
			var count = 0;
		  	var len = document.getElementsByName("strNewReceivedQty").length;		  	
		  	for(var i = 0; i<len ; i++)
			{
				if(	parseInt(document.getElementsByName("strNewReceivedQty")[i].value)>0 )	
				count++;
			}
			
			
			if(count==0)
			{
				alert(" Received Qty for Atleast one of Item Name should be greater than 0");
				document.getElementsByName("strNewReceivedQty")[0].focus();
				return false;
			}
						
			           
			           var conf = confirm("You Are Going To Save Records");
					                  if(conf == true)
					                  {
					                       var conf1 = confirm("Are you sure !!!");
					                       if(conf1 == true)
					                       {
					                       	  document.forms[0].strDeliveryModeText.disabled = false;
					                       	  document.forms[0].strSupplierReceiptNo.disabled = false;
					                       	  
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
	  
	  
	  /**
	   * verifyValidation 
	   */
function verifyValidation() 
{
	   	
	   	document.forms[0].strVerifyFlag.value = 0;
	   //	document.forms[0].strSalePrice.disabled = false;
	   	
	   	var totReceivedQty = parseFloat(document.forms[0].strReceivedQuantity.value);
	   	var totVerifiedQty = parseFloat(document.forms[0].strVerifiedQuantityInBaseVal.value);
	  // 	alert("Received Qty"+totReceivedQty);
	  // 	alert("Verified Qty"+totVerifiedQty);
		
	   	if(totReceivedQty!=totVerifiedQty || totVerifiedQty>totReceivedQty)
	   	{
	   		var hisValidator = new HISValidator("challanProcessBean");
		   		   		
		   	if (document.forms[0].isBatchReq != null && document.forms[0].isBatchReq.value == '1') 
		   	{
			
				hisValidator.addValidation("strBatchNo", "req","Batch No. is a Mandatory Field");
			}
			
			hisValidator.addValidation("strManufactureDate", "req","Manufacture Date is a Mandatory Field");
			hisValidator.addValidation("strManufactureDate", "dtltet="+document.forms[0].strCtDate.value,"Manufacture Date should be Less than or Equal to Current Date"); 		
	
	
			//if (document.forms[0].isExpirtReq != null && document.forms[0].isExpirtReq.value == '1') 
			//{
					hisValidator.addValidation("strExpiryDate", "req","Expiry Date is a Mandatory Field");
					hisValidator.addValidation("strExpiryDate", "dtgtet="+document.forms[0].strCtDate.value,"Expiry Date should be Greater than or Equal to Current Date"); 		
					hisValidator.addValidation("strExpiryDate", "dtgt="+document.forms[0].strManufactureDate.value,"Expiry Date should be Greater than Manufacture Date"); 		
			//}
		    
		   	hisValidator.addValidation("strAcceptedQuantity", "req", "Accepted Quantity is a Mandatory Field");
		   	hisValidator.addValidation("strAcceptedQuantityUnitId", "dontselect=0", "Please Select a Accepted Quantity Unit");
		   	/* Commented wrf to CR 1-Jan-2013
		   	if(parseInt(document.forms[0].strAcceptedQuantity.value)==0 )
		   	{
		   		alert("Accepted Quantity should be greater than 0	");
		   		document.forms[0].strAcceptedQuantity.focus();
		   		return false;
		   		
		   	}*/
		   	
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
		   	
		   	/************************New Condition Add wrf of CR 1-Feb-2013*********************/
		   	
		     	if(excQtyVal > 0)
		   		{
		   			var recQty;
		   			var sumVar1 = accVal + rejVal + brkVal;
		   			var totalNoOfBatch   = parseInt(document.forms[0].strTotalNoOfBatch.value);
		   			var offLineOnLineFlg = parseInt(document.forms[0].strIsOnLineOffLineFlag.value);
		   			if(totalNoOfBatch>0 && offLineOnLineFlg == 0)
		   			{
		   				// Batch No ^ Expiry Date ^ Received Qty  [ Off-Line ]
		   			    recQty  = (document.forms[0].strOfflineBatchCmbId[document.forms[0].strOfflineBatchCmbId.selectedIndex].value).split("^")[2];
		   			}
		   			else
		   			{
		   				// Batch No ^ Accepted Qty ^ Bkg Qty ^ Excess Qty ^ Rejected Qty ^ Stock Page No ^ Remarks  [ On-Line ]
		   				recQty  = (document.forms[0].strOnlineBatchCmbId[document.forms[0].strOnlineBatchCmbId.selectedIndex].value).split("^")[1];
		   			}  
		   			if(sumVar1 == (parseInt(recQty)-verfVal))
		   			{
		   				alert("Excess Qty Can't be greater than Zero!!!!");
		   				return false;
		   			}
		   		}
		   	
		   	/********************************************************************************/
		   	
		   	
		   	var totVerfVal = verfVal + accVal + rejVal + brkVal;
		    var balQtyVal = parseFloat(document.forms[0].strReceivedQuantity.value) * parseFloat(document.forms[0].strReceivedQuantityUnitBaseValue.value);
		    
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
		   		
		   	if(totVerfVal > balQtyVal)
		   	{
		   		
		   		alert("Sum of Verified, Accepted, Rejected and Breakage Quantity should not be Greater than Receive Quantity "+balQtyVal+" No.");
		   		return false;
		   	}
		   
		   	hisValidator.addValidation("strSalePrice", "req", "Sales Price is a Mandatory Field");
		   	hisValidator.addValidation("strSalePriceUnitId", "dontselect=0", "Please Select a Sales Price Unit");
		   		
		   	if(document.getElementsByName("strWarrantyDate").length > 0)
		   	{
		   		
		   		hisValidator.addValidation("strWarrantyDate", "req","Warranty Date is a Mandatory Field");
				
				hisValidator.addValidation("strWarantyManufacturer", "dontselect=0","Please Select a Manufacture");
				
				hisValidator.addValidation("strWarrantyUpTo", "req","Warranty Upto is a Mandatory Field");
				hisValidator.addValidation("strWarrantyUpToUnit", "dontselect=0","Please Select a Unit");
				
				hisValidator.addValidation("strWarrantyRemarks", "maxlen=100","Remarks cannot be greater than 100 Characters");
					   		
		   	}	
		   		
		   	if(document.getElementsByName("strInstallStartDate").length > 0)
		   	{
		   		
			   	hisValidator.addValidation("strInstallStartDate", "req","Installation Start Date is a Mandatory Field");
				hisValidator.addValidation("strInstallEndDate", "req","Installation End Date is a Mandatory Field");
				hisValidator.addValidation("strInstallStatus", "dontselect=0","Please Select an Installation Status");
				
				hisValidator.addValidation("strInstallBy", "req","Install By is a Mandatory Field");
				hisValidator.addValidation("strInstallerContactNo", "req","Installer Contact No. is a Mandatory Field");
				hisValidator.addValidation("strInstallEndDate", "req","Installation End Date is a Mandatory Field");
				
		   	}
		   	//Validate Supplier Performance Details
		   
			   	hisValidator.addValidation("strReportNumber", "req","Report Number is a Mandatory Field");
				hisValidator.addValidation("strReportDate", "req","Report Date is a Mandatory Field");
				hisValidator.addValidation("strReportDate", "dtltet="+document.forms[0].strCtDate.value,"Report Date should be Less than or Equal to Current Date"); 		
				
			
		   
		   			   	
   	        hisValidator.addValidation("strPageNumber","req", "Page No. of Stock Register where entry has been made is a Mandatory Field" );
		   			   			   		
		   	hisValidator.addValidation("strCommitteeType", "dontselect=0", "Please Select a Committee Type");	
		   //	hisValidator.addValidation("strRemarks", "req", "Remarks is a Mandatory Field");
			hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks cannot contains more than 100 Characters");
	
		  
		   	var retVal = hisValidator.validate();
		
			hisValidator.clearAllValidations();
	
			if (retVal) 
			{
				 	if(document.getElementsByName("strPageNumber")[0].value==0)
			           {
			           		alert("Please Enter Page No. greater than 0 ");
			           		document.getElementsByName("strPageNumber")[0].focus();
			           		return false;
			           		
			           } 
				
				if(totVerfVal != balQtyVal)
				{
					
					var flg = confirm("Whether All the Batch of the Selected Item(s) have been Received");
					
						if(flg) document.forms[0].strVerifyFlag.value = 1;
									
				}
				else
				{
					
					document.forms[0].strVerifyFlag.value = 1;
				}
				
				
				if(	confirm("You Are Going To Save Challan Details. The drug details are as follows" +
					    "\n\n Drug Name :  " + document.forms[0].strItemBrandName.value 
					   +"\n Batch No : "         + document.forms[0].strBatchNo.value 
					   +"\nAccepted Quantity : " + document.forms[0].strAcceptedQuantity.value
					  )
				)
			
				{
					if(confirm(" Do You Want to Save ?"))
					{
					
							//document.forms[0].strSalePrice.disabled = false;
							document.forms[0].strSalePriceUnitId.disabled = false;
							document.forms[0].hmode.value = "INSERTVERIFY";
							document.forms[0].submit();
					}	
					
				}
					
				
				
			
			} else {
				return false;
			}
	   }
	   else
	   {
	   	  alert("No Item Remaining to Verify!!!");
	   	  return false;
	   }
	   	
	   }
	  
	  
	  function checkQtyDtls(index, qtyName, unitName) 
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
			//if(qtyObj.value==0)
			//{
			//	alert("Qty must be greater than Zero ");
				
			//	return false;
			//}

		
	var itemDtlsObj =  document.getElementById("strItemDtls"+index);

	var balQty = itemDtlsObj.value.split('^')[2];
	var balQtyBaseUnitVal = itemDtlsObj.value.split('^')[10];

	var balQtyVal = parseFloat(balQty) * parseFloat(balQtyBaseUnitVal);


	var qty = "0";
	var unitBase = "0";

	if(qtyObj.value.length > 0) qty = qtyObj.value;

	if(unitObj.value.length > 1) unitBase = unitObj.value.split('^')[1];
	
		
	var reqQtyVal = parseFloat(qty) * parseFloat(unitBase);
	
	
	
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


function ftnTickFive(mode)
{
  if(mode=='1')
  {
  	document.forms[0].strMrpPrintedFlg.value='1';
  	document.forms[0].isMRPPrint[0].checked=true;
  	document.forms[0].isMRPPrint[1].checked=false;
  }
  else
  {
  	document.forms[0].strMrpPrintedFlg.value='0';
  	document.forms[0].isMRPPrint[1].checked=true;
  	document.forms[0].isMRPPrint[0].checked=false;
  }
	
} 


function ftnTickFour(mode)
{
  if(mode=='1')
  {
  	document.forms[0].strMedicineTypeFlg.value='1';
  	document.forms[0].isGenricName[0].checked=true;
  	document.forms[0].isGenricName[1].checked=false;
  }
  else
  {
  	document.forms[0].strMedicineTypeFlg.value='0';
  	document.forms[0].isGenricName[1].checked=true;
  	document.forms[0].isGenricName[0].checked=false;
  }
	
} 


function ftnTickThree(mode)
{
  if(mode=='1')
  {
  	document.forms[0].strGovtSupplyFlg.value='1';
  	document.forms[0].isNotForSale[0].checked=true;
  	document.forms[0].isNotForSale[1].checked=false;
  }
  else
  {
  	document.forms[0].strGovtSupplyFlg.value='0';
  	document.forms[0].isNotForSale[1].checked=true;
  	document.forms[0].isNotForSale[0].checked=false;
  }
	
} 


function ftnTickTwo(mode)
{
  if(mode=='1')
  {
  	document.forms[0].strMedicienCondFlg.value='1';
  	document.forms[0].isGoodCond[0].checked=true;
  	document.forms[0].isGoodCond[1].checked=false;
  }
  else
  {
  	document.forms[0].strMedicienCondFlg.value='0';
  	document.forms[0].isGoodCond[1].checked=true;
  	document.forms[0].isGoodCond[0].checked=false;
  }
	
} 

function ftnTickOne(mode)
{
  if(mode=='1')
  {
  	document.getElementById("showReportId").style.display = "block";
  	document.forms[0].strTestReportFlg.value='1';
  	document.forms[0].isTestReport[0].checked=true;
  	document.forms[0].isTestReport[1].checked=false;
  }
  else
  {
  	document.getElementById("showReportId").style.display = "none";
  	document.forms[0].strTestReportFlg.value='0';
  	document.forms[0].isTestReport[1].checked=true;
  	document.forms[0].isTestReport[0].checked=false;
  }
	
} 

	  

	 /**
	  * showView
	  * @param {String} divId 
	  */
	  function showView(divId) 
	  {
	  	
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
   	 		alert("Please Select Committee Type");
   	 		document.getElementsByName("strReportNumber")[0].focus();
   	 	}
 	 	else
 	 	{
  		     document.getElementsByName("strReportNumber")[0].focus();
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
	  
function checkStatus()
{	
	var count = 0;
  	var len = document.getElementsByName("strCheckOne").length;		
  	var chkObj = document.getElementsByName("strCheckOne");	  	
  	for(var i = 0; i<len ; i++)
	{
		var passValue = document.getElementById("strHiddenChallanValue"+i).value;
		//10000008$10100008$Diclofenac Sodium and Paracetamol Tablets Diclofenac Sodium 50 mg + Paracetamol 500 mg$31JAN2014$31-Jan-2015$11^0^0^0^0^0^0^0^0^13$Active$99901106$99901134$1010077$101001$0$10281200018$1$31-Jan-2013$31-Jan-2013$null$0^1^0^0$asdasd$null$10$0$0$1
		var challanStatus = passValue.split("$")[6]
		if(challanStatus == "Active")
		{
			count++;	
		}				
	}	
	if(count==len && len > 0)
	{		
		for(var i = 0; i<len ; i++)
		{
			chkObj[i].checked=true;		
			selectRecord(this,i);							
		}
			
		totalSelectedRecord();
		
		for(var i = 0; i<len ; i++)
		{				
			chkObj[i].disabled = true;				
		}	
		document.getElementById("strCheckAll").checked=true; 
		document.getElementById("strCheckAll").disabled=true; 				
	}
	else
	{		
		for(var i = 0; i<len ; i++)
		{
		    var passValue = document.getElementById("strHiddenChallanValue"+i).value;
	        //10000008$10100008$Diclofenac Sodium and Paracetamol Tablets Diclofenac Sodium 50 mg + Paracetamol 500 mg$31JAN2014$31-Jan-2015$11^0^0^0^0^0^0^0^0^13$Active$99901106$99901134$1010077$101001$0$10281200018$1$31-Jan-2013$31-Jan-2013$null$0^1^0^0$asdasd$null$10$0$0$1
		    var challanStatus = passValue.split("$")[6]
			if(challanStatus == "Active")
			{				
				document.getElementById("check"+i).innerHTML = "<img src='../../hisglobal/images/delete_on.gif' title='Active' name='strCheckOne' id='strCheckOne"+i+"' style='cursor: pointer;'/>";	
			}		
		}	
		
	}
	
}
	  
	  
function freezeChallan()
 {
 	
 	
	var errContent = document.getElementById("errMsg").innerHTML ;
	if(errContent.length > 0)
	{
		alert("Process Cannot be Saved due to '"+errContent+"'");
		return false;
	}
	if(document.forms[0].strHiddenVerifiedChallanValue==null) return;
	
	var hisValidator = new HISValidator("challanProcessApprovalBean");

	
		var count = 0;
	  	var len = document.getElementsByName("strHiddenVerifiedChallanValue").length;		
	  	var chkObj =   document.getElementsByName("strHiddenVerifiedChallanValue");	
	  	
	  	count=len;
				
		if(count==0)
		{
			alert("No Record is there For Freeze !!");			
			return false;
		}
		else
		{
			hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks cannot contains more than 100 Characters");
			hisValidator.addValidation("strRemarks", "req", "Remarks is a Mandatory Field");
	  	
  			var retVal = hisValidator.validate();
			hisValidator.clearAllValidations();

			if (retVal) 
			{				
			    var conf = confirm("No changes are allowed after Approval. \nYou Are Going To FREEZE "+count+" Record(s) ");
			    if(conf == true){
	                var conf1 = confirm("Are you sure !!!");
	                if(conf1 == true){
	                    document.forms[0].hmode.value = "INSERTFREEZECHALLAN";
	                    document.forms[0].submit();
	                }
	                else{
	                	return false;
					}
			 	}
			 	else{
			 		return false;
				}  
			}
				
			else 
			{
				return false;
			}		
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

function totalSelectedRecord()
{ 	
	var len = document.getElementsByName("strCheckOne").length;		
	var chkObj =   document.getElementsByName("strCheckOne");	
	document.forms[0].strPrevHiddenChallanValue.value = "";
	var count = 0;
	for(var i = 0; i<len ; i++)
	{
		if(chkObj[i].checked)
		{ 
			count++;	
			if(count==1)	
			{	 
			     document.forms[0].strPrevHiddenChallanValue.value =  chkObj[i].value;
			}
			else
			{
				 document.forms[0].strPrevHiddenChallanValue.value =  chkObj[i].value+"@"+document.forms[0].strPrevHiddenChallanValue.value;
			}   
		}		
		  
	}    
}

function checkAll(){
	var check=document.getElementsByName("strCheckOne");
	var chkAllObj = document.getElementById("strCheckAll");   
	var count = 0;  	
	if(chkAllObj.checked)
	{		  
		for(i=0;i<check.length;i++)
		{
			var passValue = document.getElementById("strHiddenChallanValue"+i).value;
			var challanStatus = passValue.split("$")[6]				
			if((challanStatus != "Active") && (challanStatus != "Freezed"))
			{
				if(check[i].checked=true)
				{
					var passValue = document.getElementById("strHiddenChallanValue"+i).value;
					document.getElementById("strCheckOne"+i).value = passValue;	
					if(check[i].checked)
					{
						count++;
					}
						//passValue = document.getElementById("strHiddenChallanValue"+i).value;
					document.getElementById("strCheckOne"+i).value = passValue;	
					if(count==1)
					{						
					    document.forms[0].strPrevHiddenChallanValue.value =  check[i].value;					    
					}
					else
					{  
						document.forms[0].strPrevHiddenChallanValue.value =  check[i].value+"@"+document.forms[0].strPrevHiddenChallanValue.value;
					} 					
					
				}
				
			}	
									 						
		}	
	
	}
	else{
		document.forms[0].strPrevHiddenChallanValue.value = "";
		for(i=0;i<check.length;i++)
		{
			check[i].checked=false;
			check[i].value="";									
		}		
	}
		
}	
	  
	  
////*****By Vivek*****

function getSupplyDetails()
{
	var mode= 'getSupplyDetails';
	
	var url = "ChallanProcessTransCNT.cnt?hmode=" + mode + "&poNo="+ document.forms[0].strPoNo.value + 
																   "&poStoreId="+ document.forms[0].strPoStoreId.value +
																   "&storeId="+ document.forms[0].strStoreId.value +
																   "&challanNo="+ document.forms[0].strSupplierReceiptNo.value;
																   
													   
//		alert(url);														   
			ajaxFunction(url, "5");
	
}	  
	  
	  
function getSuppliedItemDetails()
{
	var mode= 'getSuppliedItemDetails';
	
	var url = "ChallanProcessTransCNT.cnt?hmode=" + mode + "&poNo="+ document.forms[0].strPoNo.value + 
																   "&poStoreId="+ document.forms[0].strPoStoreId.value +
																   "&storeId="+ document.forms[0].strStoreId.value +
																   "&challanNo="+ document.forms[0].strSupplierReceiptNo.value;
																   
													   
//		alert(url);														   
			ajaxFunction(url, "6");
	
}	  


 /**
	  * validation 
	  */
	  function validationRecOnline() 
	  {
	  	var errContent = document.getElementById("errMsg").innerHTML ;
	  	if(errContent.length > 0)
	  	{
	  		alert("Process Cannot be Saved due to '"+errContent+"'");
	  		return false;
	  	}
	  	var hisValidator = new HISValidator("challanProcessBean");
	  	if(document.forms[0].strPoTypeId.value == '24')
	  	{
	  		hisValidator.addValidation("strAwbNo", "req", "AWB No. is a Mandatory Field");
	  		hisValidator.addValidation("strBeNo", "req", "BE No. is a Mandatory Field");
	  		hisValidator.addValidation("strBeDate", "req", "BE Date is a Mandatory Field");
	  	}
	  	hisValidator.addValidation("strReceiveDate", "req", "Received Date a Mandatory Field");
	  	
	  	if(document.forms[0].strSupplierReceiptNo)
	  	hisValidator.addValidation("strSupplierReceiptNo", "req", "Challan/Invoice No. a Mandatory Field");
	  		  	
	  	hisValidator.addValidation("strSupplierReceiptDate", "req", "Challan/Invoice Date a Mandatory Field");
	  	if(document.getElementsByName("strSupplierReceiptDate")[0].value!="")
	  	{
	  		hisValidator.addValidation("strSupplierReceiptDate","dtltet="+document.forms[0].strCtDate.value,"Please Select Challan/Invoice Date Less Than or Equal To Current Date");
	  		hisValidator.addValidation("strReceiveDate", "dtgtet="+document.forms[0].strSupplierReceiptDate.value,"Received Date should be Greater Than or Equal Challan/Invoice Date");
	  		
	  	}
	   // alert("PO Date:::"+document.forms[0].strPourchaseOrderDate.value+"::Receipt Date::"+document.forms[0].strSupplierReceiptDate.value);
	    var poDate = document.forms[0].strPourchaseOrderDate.value;
	  	//hisValidator.addValidation("strSupplierReceiptDate","dtltet="+poDate,"Please Select Challan/Invoice Date Less Than or Equal To PO Date "+poDate);
	  	hisValidator.addValidation("strSupplierReceiptDate","dtgtet="+poDate+"", "Please Select Challan/Invoice Date Greater Than or Equal To PO Date"+poDate);
	  	
	  	hisValidator.addValidation("strNoOfPackets", "req", "No. of Packets is a Mandatory Field");
	  	
	  	
  	  		  	
  	  	if(document.forms[0].strNewReceivedQty)
	  	hisValidator.addValidation("strNewReceivedQty" , "req" , "Received Quantity is a Mandatory Field");
	  	
	  	//hisValidator.addValidation("strReceivedUnitId", "dontselect=0", "Please Select a Unit Name ");
 		//hisValidator.addValidation("strScheduleNo", "dontselect=0", "Please Select a Schedule No.");
				
		hisValidator.addValidation("strReceivedBy", "req", "Name of the Receiver is a Mandatory Field");
		
		hisValidator.addValidation("strReceivedComboBy","dontselect=0","Please Select a Value from Received By Combo" );
		
		if(document.forms[0].strDeliveryModeText)
		hisValidator.addValidation("strDeliveryModeText", "req", "Deliver Mode Name is a Mandatory Field");
		
		//hisValidator.addValidation("strRemarks", "req", "Remarks is a Mandatory Field");
		hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks cannot contains more than 100 Characters");
		hisValidator.addValidation("strPackageWeight", "numltet=9999.99", "Weight cannot be more than 9999.99 kg");
		  	
		  
		  	
	  	var retVal = hisValidator.validate();
	
		hisValidator.clearAllValidations();

		if (retVal) 
		{
			
			/*
			var count = 0;
		  	var len = document.getElementsByName("strNewReceivedQty").length;		  	
		  	for(var i = 0; i<len ; i++)
			{
				if(	parseInt(document.getElementsByName("strNewReceivedQty")[i].value)>0 )	
				count++;
			}
			
			
			if(count==0)
			{
				alert(" Received Qty for Atleast one of Item Name should be greater than 0");
				document.getElementsByName("strNewReceivedQty")[0].focus();
				return false;
			}
						
			      */     
			           var conf = confirm("You Are Going To Save Records");
					                  if(conf == true)
					                  {
					                       var conf1 = confirm("Are you sure !!!");
					                       if(conf1 == true)
					                       {
//					                       	  document.forms[0].strDeliveryModeText.disabled = false;
//					                       	  document.forms[0].strSupplierReceiptNo.disabled = false;
					                       	  
					                          document.forms[0].hmode.value = "INSERTONLINECHALLAN";
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
	  function checkMsg() {
			var err=document.getElementById("errMsg");
			var nor=document.getElementById("normalMsg");
			var warn=document.getElementById("warningMsg");
			
			if (err.innerHTML != "") {
				
				err.innerHTML="<i class='fas fa-exclamation-triangle'></i>"+"&nbsp;&nbsp;&nbsp;<strong>Error!</strong>&nbsp;&nbsp;"+err.innerHTML+"<button type='button' class='close' data-dismiss='alert'>&times;</button>";
				err.style.display = "";
				
			}
			if (nor.innerHTML != "") {
				nor.innerHTML="<i class='far fa-check-circle'></i>"+"&nbsp;&nbsp;&nbsp;<strong>Success!</strong>&nbsp;&nbsp;"+nor.innerHTML+"<button type='button' class='close' data-dismiss='alert'>&times;</button>";
				nor.style.display = "";
			}
			if (warn.innerHTML != "") {
				warn.innerHTML="<i class='fas fa-bell'></i>"+"&nbsp;&nbsp;&nbsp;<strong>Warning!</strong>&nbsp;&nbsp;"+warn.innerHTML+"<button type='button' class='close' data-dismiss='alert'>&times;</button>";
				warn.style.display = "";
			}
			

}