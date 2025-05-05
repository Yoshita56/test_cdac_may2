var totalContractedQty;
/*
function totalRowQty(prgIndex, delIndex, obj) 
{
	var i = 0;
	var unitConvVal = "0";
	var unitConvVal1 = "0";
	var prgSize = document.forms[0].strProgrammeSize.value;
	var value = "0";
	var totalValue = 0;
	var programmBalanceQty = 0;
	var recQtyObj;
	var recQty = 0;
	var unitObj;
    var prgObj = document.getElementsByName("strMultiRowProgrammeDtl");
    var strMultiBatch = document.getElementsByName("strMultiRowBatchNo");
    
    
	if (document.getElementById("strMultiRowUnit" + delIndex).value != '0')
		unitConvVal = document.getElementById("strMultiRowUnit" + delIndex).value
				.split("^")[1];

	value = (document.getElementById("strMultiRowReceivedQty" + prgIndex
			+ delIndex)).value;
	if (value.length <= 0)
		value = "0";

	recQty = parseInt(value, 10) * unitConvVal;

	if (recQty > 0) 
	{
		document.getElementById("strMultiRowReceivedQtyDiv" + prgIndex+ delIndex).innerHTML = "=" + recQty;
		document.getElementById("strMultiRowReceivedQtyDiv" + prgIndex+ delIndex).style.color = "green";
	} 
	else
	{
		document.getElementById("strMultiRowReceivedQtyDiv" + prgIndex+ delIndex).innerHTML = "";
    }
	recQtyObj = document.getElementsByName("strMultiRowReceivedQty" + prgIndex);
	unitObj = document.getElementsByName("strMultiRowUnit");

	for (i = 0; i < recQtyObj.length - 1; i++) 
	{
		unitConvVal1 = 0;
		if (unitObj[i].value != "0")
			unitConvVal1 = unitObj[i].value.split("^")[1];

		value = recQtyObj[i].value;
		if (value.length <= 0)
			value = "0";

		totalValue = totalValue + (parseInt(value, 10) * unitConvVal1);
	}

	programmBalanceQty = document.getElementById("strPopUpBalanceQtyDtl"+ prgIndex).value.split("^")[4];

    var mulLength = 0;
    var mulTotalQty = 0;
    if(document.getElementsByName("strHiddenValue")!=null)
    {
    	var objVal = document.getElementsByName("strHiddenValue");
    	 mulLength = document.getElementsByName("strHiddenValue").length;
    	for (k = 0; k < mulLength; k++) 
	    {	       	
           mulTotalQty = mulTotalQty +  objVal[k].value.split("^")[10];
	    }
    }

	if (totalValue > parseInt(programmBalanceQty, 10))
	{
		alert("Total Programme Quantity Can't be Greater than Programme Balance [ "	+ programmBalanceQty + " ] Quantity!!!");
		document.getElementById("strMultiRowReceivedQtyDiv" + prgIndex
				+ delIndex).innerHTML = "";
		obj.value = "0";
		setTimeout(function() 
		{
			obj.focus();
		}, 0);
	}
	
	
	if ( (parseInt(totalValue,10) + parseInt(mulTotalQty,10)) > parseInt(programmBalanceQty, 10))
	{
		//alert("Total value-->>"+parseInt(totalValue,10));
		//alert("Total Added Qty-->>"+parseInt(mulTotalQty,10));
		//alert("Total Programme Quantity ( Programme + Delivery )[ "+(parseInt(totalValue,10) + parseInt(mulTotalQty,10))+" ] Can't be Greater than Programme Balance Qty [ "	+ programmBalanceQty + " ] Quantity!!!");
		
		document.getElementById("strMultiRowReceivedQtyDiv" + prgIndex+ delIndex).innerHTML = "";
		obj.value = "0";
		setTimeout(function() 
		{
			obj.focus();
		}, 0);
	}
	

	totalValue = 0;
	var pktSize ;
	var totalPktSize=0;
	for (i = 1; i <= prgSize; i++) 
	{
		value = (document.getElementById("strMultiRowReceivedQty" + i+ delIndex)).value;
		pktSize = (document.getElementById("strMultiRowPartQty" + i+ delIndex)).value;
		
		if (value.length <= 0)
			value = "0";

		totalValue = totalValue + (parseInt(value, 10) * unitConvVal);
		totalPktSize = totalPktSize +parseInt(pktSize, 10);
	}
	
	
	for (i = 0; i < prgObj.length - 1; i++) 
	{
		for (j = 0; j < prgSize; j++) 
		{
			prgValue = document.getElementsByName("strMultiRowReceivedQty"+ (j + 1))[i].value;
			   prgId = document.getElementById("strProgrammeId"+ (j + 1)).value;

			if (prgValue.length == 0)
				prgValue = "0";

			if (j == 0)
				prgDtl = prgId + "@" + prgValue;
			else
				prgDtl = prgDtl + "#" + prgId + "@" + prgValue;
		}

		prgObj[i].value = prgDtl;
		if (trimAll(strMultiBatch[i].value).length == 0)
		{
			//strMultiBatch[i].value = 'NA';
		}	
	}
    document.getElementById("strMultiRowTotalPktSize"+ delIndex).value = totalPktSize;
	document.getElementById("strMultiRowTotalQtyDiv" + delIndex).innerHTML = totalValue;
	document.getElementById("strMultiRowTotalQtyDiv" + delIndex).style.color = "red";
	document.getElementById("strMultiRowTotalQty" + delIndex).value = totalValue;
	
	
	var totObj = document.getElementById("strMultiRowTotalDiv"+delIndex);
	
	if(totObj != null){
		
		var totValue = document.getElementById("strMultiRowTotalDiv"+delIndex).innerHTML;
		
		if(totValue.length > 0){
			
			if(totalValue > parseInt(totValue)){
				
				alert("Total Programme Quantity Can't be Greater than Received Total [ "
						+ totValue + " ] Quantity!!!");
				
				obj.value = "0";
				setTimeout(function() {
					obj.focus();
				}, 0);
				 
			} 
			
		}else{
			
			alert("Received Total Qty. is 0 ");
			return false;
			
		}
		
		
		
		
	}
	
	
}*/



function totalRowQty(prgIndex, delIndex, obj) 
{

	var i = 0;
	var unitConvVal = "0";
	var unitConvVal1 = "0";
	var prgSize = document.forms[0].strProgrammeSize.value;
	var value = "0";
	var totalValue = 0;
	var programmBalanceQty = 0;
	var recQtyObj;
	var recQty = 0;
	var unitObj;
    
    /*
	if (document.getElementById("strMultiRowUnit" + delIndex).value != '0')
		unitConvVal = document.getElementById("strMultiRowUnit" + delIndex).value
				.split("^")[1];
    */
    var noOfCarton  = (document.getElementById("strMultiRowNoOfCarton" + delIndex).value);
    unitConvVal = document.getElementsByName("strUnitId")[0].value.split("^")[1]
	value = (document.getElementById("strMultiRowReceivedQty" + prgIndex+ delIndex)).value;
	if (value.length <= 0)
		value = "0";
             // Enter Qty   * Unit Conversion *  No of Carton
	recQty = (parseInt(value, 10) * unitConvVal)* parseInt(noOfCarton,10);
	

	if (recQty > 0) 
	{
		document.getElementById("strMultiRowReceivedQtyDiv" + prgIndex
				+ delIndex).innerHTML = "=" + recQty;
		document.getElementById("strMultiRowReceivedQtyDiv" + prgIndex
				+ delIndex).style.color = "green";
	}
	else
	{
		document.getElementById("strMultiRowReceivedQtyDiv" + prgIndex
				+ delIndex).innerHTML = "";
	}
	recQtyObj = document.getElementsByName("strMultiRowReceivedQty" + prgIndex);
	//unitObj = document.getElementsByName("strMultiRowUnit");

	for (i = 0; i < recQtyObj.length - 1; i++) 
	{
		//unitConvVal1 = 0;
		
		//if (unitObj[i].value != "0")
			//unitConvVal1 = unitObj[i].value.split("^")[1];

		value = recQtyObj[i].value;
		if (value.length <= 0)
			value = "0";

		totalValue = totalValue + ((parseInt(value, 10) * unitConvVal)*parseInt(noOfCarton,10));
		//totalValue = totalValue + (parseInt(value, 10));
	}

	programmBalanceQty = document.getElementById("strPopUpBalanceQtyDtl"+ prgIndex).value.split("^")[4];

	if (totalValue > parseInt(programmBalanceQty, 10)) 
	{
		alert("Total Programme Quantity ( No of Carton  * Prog Qty * Unit Conversion Vale) [" + totalValue + "] Can't be Greater than Programme Balance [ "	+ programmBalanceQty + " ] Quantity!!!");
		document.getElementById("strMultiRowReceivedQtyDiv" + prgIndex+ delIndex).innerHTML = "";
		obj.value = "0";
		setTimeout(function() 
		{
			obj.focus();
		}, 0);
	}

	totalValue = 0;
	for (i = 1; i <= prgSize; i++) 
	{
		value = (document.getElementById("strMultiRowReceivedQty" + i
				+ delIndex)).value;
		if (value.length <= 0)
			value = "0";

		totalValue = totalValue + ((parseInt(value, 10) * unitConvVal)*parseInt(noOfCarton,10));
		//totalValue = totalValue + (parseInt(value, 10));
	}

	document.getElementById("strMultiRowTotalQtyDiv" + delIndex).innerHTML = totalValue;
	document.getElementById("strMultiRowTotalQtyDiv" + delIndex).style.color = "red";
	document.getElementById("strMultiRowTotalQty" + delIndex).value = totalValue;
	
	
	var totObj = document.getElementById("strMultiRowTotalDiv"+delIndex);
	
	if(totObj != null){
		
		var totValue = document.getElementById("strMultiRowTotalDiv"+delIndex).innerHTML;
		
		if(totValue.length > 0){
			
			if(totalValue > parseInt(totValue)){
				
				alert("Total Programme Quantity Can't be Greater than Received Total [ "
						+ totValue + " ] Quantity!!!");
				
				obj.value = "0";
				setTimeout(function() {
					obj.focus();
				}, 0);
				 
			} 
			
		}else{
			
			alert("Received Total Qty. is 0 ");
			return false;
			
		}
		
		
		
		
	}
	
	
}
function checkDuplicateBatchNo(obj) 
{
	var batchNo = obj.value;
	var allBatchObj;
	var i = 0;
	var batchCount = 0;

	if (trimAll(batchNo).length > 0) {
		allBatchObj = document.getElementsByName("strMultiRowBatchNo");

		for (i = 0; i < allBatchObj.length; i++) {
			if (allBatchObj[i].value == batchNo)
				batchCount++;


			if (batchCount > 1) {
				//alert(allBatchObj[i].value);
				if(allBatchObj[i].value != 0)
					{
					alert("Batch No already exists !!");
					alert("Batch No already exists !!");
					var r = confirm("Are you sure to Continue with Same Batch : '"+allBatchObj[i].value+"'");
					if (r == false) {
						allBatchObj[i].value = "";
						}
					
					else
						
						{
						break;
						
						}
					allBatchObj[i].focus();
					break;
					}
			}
		}
	}
}



function checkDuplicateCartonSize(delIndex, obj ) 

{
	var cartonSize = obj.value;
	var allCartonSizeObj;
	var i = 0;
	var cartonSizeCount = 0;
	
//	alert('hemant::::'+delIndex);
	
	
	//alert(document.getElementById("strMultiRowBatchNo"+delIndex).value);

	if (trimAll(cartonSize).length > 0) {
		allCartonSizeObj = document.getElementsByName("strMultiRowCartonSize");

		for (i = 0; i < allCartonSizeObj.length; i++) {
			if (allCartonSizeObj[i].value == cartonSize)
				cartonSizeCount++;

			if (cartonSizeCount > 1) {
							
				
				alert("Carton Size already exists !!");
				var r = confirm("Are you sure to continue this Carton Size with Batch : '"+document.getElementById("strMultiRowBatchNo"+delIndex).value+"'");
				if (r == false) {
					allCartonSizeObj[i].value = "0";
					}
				
				
				
				
				allCartonSizeObj[i].focus();
				break;
			}
		}
	}

}

// used in challan >> receive to check the duplicate batch no
function checkDuplicateCartonNo(obj) 
{
	var batchNo = obj.value;
	var allBatchObj;
	var i = 0;
	var batchCount = 0;

	if (trimAll(batchNo).length > 0) 
	{
		allBatchObj = document.getElementsByName("strMultiRowCartonNo");

		for (i = 0; i < allBatchObj.length; i++) 
		{
			if (allBatchObj[i].value == batchNo)
				batchCount++;

			if (batchCount > 1) 
			{
				alert("Carton No already exists !!");
				allBatchObj[i].value = "";
				allBatchObj[i].focus();
				break;
			}
		}
	}

} 

// challan receive >> Carton Size Change
function resetProgRowQty(delIndex, obj) 
{
	
	var rowTotalObj = document.getElementsByName("strMultiRowTotalQty");
	var prgSize = document.forms[0].strProgrammeSize.value;
	var conf = confirm("All value will be Reset after change Carton Size!!!");

	if (conf == true) 
	{
		
		var cartonSize = obj.value;
		var allBatchObj;
		var i = 0;
		var batchCount = 0;
	
		if (obj.value != 0) 
		{
		   if(document.forms[0].strCartonGene.value == '1')
		   {	
				allBatchObj = document.getElementsByName("strMultiRowCartonSize");
		
				for (i = 0; i < allBatchObj.length; i++) 
				{
					if (allBatchObj[i].value == cartonSize)
						batchCount++;
		
					//if (batchCount > 1) 
				//	{
					//	alert("Carton Size already exists !!"); 
					//	allBatchObj[i].value = "";
					//	allBatchObj[i].focus();
					//	break;
					//}
			    } 
	            document.getElementById("strMultiRowCartonSize" + delIndex).value = obj.value;
				for (j = 1; j <= prgSize; j++) 
				{
					document.getElementById("strMultiRowReceivedQty" + j + ""+ delIndex).value = "0";
					document.getElementById("strMultiRowReceivedQtyDiv" + j + delIndex).innerHTML = "";		
				}
				document.getElementById("strMultiRowTotalQty" + delIndex).value = "0";
				document.getElementById("strMultiRowTotalQtyDiv" + delIndex).innerHTML = "0";
		   }
		   else
		   {
		   	            document.getElementById("strMultiRowCartonSize" + delIndex).value = obj.value;	
						for (j = 1; j <= prgSize; j++) 
						{
							document.getElementById("strMultiRowReceivedQty" + j + ""+ delIndex).value = "0";
							document.getElementById("strMultiRowReceivedQtyDiv" + j + delIndex).innerHTML = "";
				
						}
						document.getElementById("strMultiRowTotalQty" + delIndex).value = "0";
						document.getElementById("strMultiRowTotalQtyDiv" + delIndex).innerHTML = "0";
		   }
		}
	} 
	else 
	{
		obj.value = document.getElementById("strMultiRowCartonSize" + delIndex).value;
	}
	if(obj.value !='0')
	{
		var noOfCarton = document.getElementById("strMultiRowNoOfCarton" + delIndex).value;
		var tot = (obj.value.split("^")[2] * noOfCarton);
        document.getElementById("strMultiRowNoOfCartonDiv" + delIndex).innerHTML = "Appx.Capacity ="+tot;
        document.getElementById("strMultiRowNoOfCartonDiv" + delIndex).style.color = "red";
       
	}  	
	
	 checkDuplicateCartonSize(delIndex, obj ) ;
 
}

// challan receive >> unit change
function setBatchDtl(delIndex, obj) 
{
	if(obj.value=='0' || obj.value=='1')
	{
		document.getElementById("strMultiRowBatchNo" + delIndex).value = "";
		document.getElementById("strMultiRowManufacterDate" + delIndex).value = "";
		document.getElementById("strMultiRowExpireDate" + delIndex).value = "";
		
	}
	else
	{
		
		document.getElementById("strMultiRowBatchNo" + delIndex).value = obj.value.split("^")[0];
		document.getElementById("strMultiRowManufacterDate" + delIndex).value = obj.value.split("^")[2];
		document.getElementById("strMultiRowExpireDate" + delIndex).value = obj.value.split("^")[1];
	}
	
}


function IsValidDate(myDate) 
{
	var filter = /^([012]?\d|3[01])-([Jj][Aa][Nn]|[Ff][Ee][bB]|[Mm][Aa][Rr]|[Aa][Pp][Rr]|[Mm][Aa][Yy]|[Jj][Uu][Nn]|[Jj][u]l|[aA][Uu][gG]|[Ss][eE][pP]|[oO][Cc][Tt]|[Nn][oO][Vv]|[Dd][Ee][Cc])-(19|20)\d\d$/
	return filter.test(myDate);
}

function checkDateFormat(obj, mode) 
{
	if (trimAll(obj.value).length > 0) 
	{
		var isValid = IsValidDate(obj.value);
		if (isValid) 
		{
			if (mode == '2') 
			{
			    
				
			}
			
		} else {
			alert('Incorrect format Please follow [dd-Mon-yyyy] format');
			obj.value = '';
			return false;
		}
	}
}

function getMultiRow(obj) 
{
	var count=0;
	var itemArr = (document.forms[0].strDrugBrandId.value).split("^");
	var totRow = 0;

	// batch no is non-mandatory
	if (itemArr[3] == "0") 
	{
		totRow = parseInt(document.getElementsByName("rowLength1")[0].value, 10);
		totRow = totRow + parseInt(obj.value, 10);

		if (totRow > 1) 
		{
			alert("Batch No is not mandatory for the selected item !!\n\nOnly one row is allowed");
			return;
		}
	}

	var prgSize = parseInt(document.forms[0].strProgrammeSize.value, 10);
	var strField = new Array(prgSize + 6);
	var strFieldType = new Array(prgSize + 6);

    //strField[0] = "strMultiRowChk";    
	strField[0] = "strMultiRowBatchNo";
	strField[1] = "strMultiRowExpireDate";
	strField[2] = "strMultiRowManufacterDate";
	strField[3] = "strMultiRowCartonSize";
	strField[4] = "strMultiRowCartonNo";
	strField[5] = "strMultiRowNoOfCarton";	

    //strFieldType[0] = "c";
	strFieldType[0] = "t";
	strFieldType[1] = "d";
	strFieldType[2] = "d";
	strFieldType[3] = "s";
	strFieldType[4] = "t";
	strFieldType[5] = "t";

	for ( var i = 0; i < prgSize; i++) 
	{
		strField[6 + parseInt(i, 10)] = "strMultiRowReceivedQty" + (i + 1);
		strFieldType[6 + parseInt(i, 10)] = "t";
	}

	strField[i + 6] = "strMultiRowTotalQty";
	strFieldType[i + 6] = "t";

	for ( var i = 0; i < obj.value; i++) 
	{
		 count++;
		addRows(strField, strFieldType, '1', '1', 'R');
				
	}	
	for ( var j = 0; j < document.getElementsByName("strMultiRowCartonNo").length; j++) 
	{	
		
		document.getElementsByName("strStaticIndex")[j].value=j;
			
		
			
			if(document.getElementsByName("strCartonGene")[0].value=="1")  // 1-Auto ,2 - Mannual
			{
				document.getElementsByName("strMultiRowCartonNo")[j].disabled=true;	
				//document.getElementsByName("strMultiRowCartonSize")[j].disabled=true;			
			}
			else
			{
				document.getElementsByName("strMultiRowCartonNo")[j].disabled=false;
				document.getElementsByName("strMultiRowNoOfCarton")[j].disabled=true;		
			}
		
		
	}	

	
	
	 /*if (document.getElementsByName("strChk")[0].value.split("@")[6]=="1")
	 {
		var url = "SupplierDeskInterfaceTransCNT.cnt?hmode=BATCHDTL&pono="+ document.forms[0].strPONo.value+ "&objValue="
				+ count;
		// alert(url);
		ajaxFunction(url, "20");
		
	 }*/
}

function deleteMultiRow(index)
{
		deleteRow(index, 1, 0);
		for ( var j = 0; j < document.getElementsByName("strMultiRowCartonNo").length; j++) 
	    {	
		  document.getElementsByName("strStaticIndex")[j].value=j;
		}
}


var count = 0;
function toCart() 
{ 
	var totalFlag = 0;
	var strBatchExdateFlag = document.forms[0].strBatchExdateFlag.value;
	var strExdateFlag = strBatchExdateFlag.split("^")[1];
	//alert('hemant:::::::'+strExdateFlag);
	var hisValidator = new HISValidator("supplierDeskTransBean");
	
	hisValidator.addValidation("strMultiRowBatchNo", "req","Please Enter Batch No.");
	hisValidator.addValidation("strMultiRowManufacterDate", "req","Please Enter Mfg. Date");
	if(strExdateFlag == 1)
		{
	hisValidator.addValidation("strMultiRowExpireDate", "req","Please Enter Exp. Date");
		}
	hisValidator.addValidation("strMultiRowCartonSize", "dontselect=0","Please select Carton Size");
	hisValidator.addValidation("strMultiRowNoOfCarton", "req","Please Enter No of Carton");
	
	var retVal1 = hisValidator.validate();

	if (retVal1) 
	{
	    
	    var strMfgDate     = document.getElementsByName("strMultiRowManufacterDate");
		var strExpiryDate  = document.getElementsByName("strMultiRowExpireDate");
		var strMultiBatch  = document.getElementsByName("strMultiRowBatchNo");
		var strMultiTotal  = document.getElementsByName("strMultiRowTotalQty");
		
		var strRowCartonNo = document.getElementsByName("strMultiRowCartonNo");
		var strCartonSize  = document.getElementsByName("strMultiRowCartonSize");
		var strNoOfCarton  = document.getElementsByName("strMultiRowNoOfCarton");
				
		
		if(document.getElementById("rejectedBatchDivId").innerHTML!='[--]')
		{		
			
			var rejectedBatch = new Array();
			var noofbatch = new Array();
			rejectedBatch = document.getElementById("rejectedBatchDivId").innerHTML.split(",");
			var batchLennew = document.getElementsByName("strMultiRowBatchNo").length;
			//noofbatch = strMultiBatch.length - 1;
	        
		//	alert('rejectedBatch.length::::::'+rejectedBatch.length);
			
			
			
		//	alert('strMultiBatch.length::::::'+batchLennew);
			
			for (var k=0;k< batchLennew - 1 ;k++)
							
				{
				for(var j=0;j<rejectedBatch.length;j++)
				
			{	
				
				
			//	alert('strMultiBatch[k].value.trim()::::'+strMultiBatch[k].value.trim());
				
			//	alert('rejectedBatch[j].trim()::::::'+rejectedBatch[j].trim());
				if(strMultiBatch[k].value.trim()== rejectedBatch[j].trim())
				{
					alert("[ "+strMultiBatch[k].value.trim()+" ] Batch is Rejected. Kindly enter another Batch!");	
					strMultiBatch[k].focus();
					return false;
				}
			}
				
				
			}// Rejected Batch cannot be verified
		}
		
		
		for ( var nTmpI = 0; nTmpI < strMfgDate.length - 1; nTmpI++) 
		{
			if (trimAll(strExpiryDate[nTmpI].value).length > 0) 
			{
				var nFlag = compareDate(trimAll(document.getElementsByName("strCurrentDate")[0].value),
						trimAll(strExpiryDate[nTmpI].value));
				
				//if(document.forms[0].strScheduleNo.value.split("^")[3]!='19')
					
				//{
				
				if (nFlag.mode == 2 || nFlag.mode == 1) 
				{
					alert("Expiry Date must be greater then Current Date.");					
					return false;
				}
				
				//}
				
					
			}

			if (trimAll(strMfgDate[nTmpI].value).length > 0) 
			{
				var nFlag = compareDate(trimAll(document.getElementsByName("strCurrentDate")[0].value),trimAll(strMfgDate[nTmpI].value));
				if (nFlag.mode < 2) 
				{
					alert("Manufacturer Date must be less then Current Date.");				
					return false;
				}
			}

			if (parseInt(strMultiTotal[nTmpI].value, 10) > 0)
				totalFlag = 1;

		}

		if (totalFlag == 0) 
		{
			alert("Please enter Rec. Qty.for atleast one programme !!");
			return;
		}
	    
	
		var itemName = document.forms[0].strDrugBrandId[document.forms[0].strDrugBrandId.selectedIndex].text;
		
		var cartItemIdArr = [];
		var cartPrgDtlArr = [];
		var htmlVal = "";
		var flag = true;
		var msg= document.getElementById("itemName").value;
		
		var msg1= document.getElementById("excessQty").value;
		
		var countEx = 0;
	
		
		var batchLen = document.getElementsByName("strMultiRowBatchNo").length;
		
		var strRowIndex  				= document.getElementsByName("strRowIndex");
		var strMultiRowBatchNo 		 	= document.getElementsByName("strMultiRowBatchNo");
		var strMultiRowManufacterDate 	= document.getElementsByName("strMultiRowManufacterDate");
		var strMultiRowExpireDate 		= document.getElementsByName("strMultiRowExpireDate");
		var strMultiRowUnit 			= document.getElementsByName("strUnitId")[0];
		var strTotalBalanceQty 			= document.getElementsByName("strTotalBalanceQty")[0];
		var strMultiRowTotalQty 		= document.getElementsByName("strMultiRowTotalQty");
		var prgObj                   	= document.getElementsByName("strMultiRowProgrammeDtl");		
		var strRowCartonNo 				= document.getElementsByName("strMultiRowCartonNo");
		var strCartonSize  				= document.getElementsByName("strMultiRowCartonSize");
		var strNoOfCarton  				= document.getElementsByName("strMultiRowNoOfCarton");
		var strMultiRowManuf 			= document.getElementsByName("strManufacturerValues")[0];
		var strMultiRowReceivedQty		= document.getElementsByName("strMultiRowReceivedQty1");		
		
		var itemBrandId                 = document.forms[0].strDrugBrandId.value;
	    
	    var enterQty = parseInt(0);
	    
		for ( var i = 0; i < batchLen; i++) 
		{
			
			enterQty = enterQty + parseInt(strMultiRowTotalQty[i].value,10);
			if ((strMultiRowTotalQty[i].value != "")&& (parseInt(strMultiRowTotalQty[i].value, 10) != 0)) 
			{
				countEx++;			
			}
		    if(document.forms[0].strCartonGene.value=="1")
		    {
				cartItemIdArr.push(itemBrandId +"^"+ strMultiRowBatchNo[i].value    +"^"+ strMultiRowManufacterDate[i].value 
									           +"^"+ strMultiRowExpireDate[i].value +"^"+ strMultiRowUnit.value
									           +"^"+ strTotalBalanceQty.value       +"^"+ strMultiRowTotalQty[i].value+"^0^"+strCartonSize[i].value+"^"+strNoOfCarton[i].value+"^"+strMultiRowManuf.value+"^"+ strMultiRowReceivedQty[i].value);
		    }
		    else
		    {
		    	cartItemIdArr.push(itemBrandId +"^"+ strMultiRowBatchNo[i].value    +"^"+ strMultiRowManufacterDate[i].value 
									           +"^"+ strMultiRowExpireDate[i].value +"^"+ strMultiRowUnit.value
									           +"^"+ strTotalBalanceQty.value       +"^"+ strMultiRowTotalQty[i].value+"^"+strRowCartonNo[i].value+"^"+strCartonSize[i].value+"^"+strNoOfCarton[i].value+"^"+strMultiRowManuf.value+"^"+ strMultiRowReceivedQty[i].value);
		    }					
			cartPrgDtlArr.push(prgObj[i].value);		
		}	
	
		if (itemBrandId == "0") 
		{   				
			alert(msg);
			flag=false;
			return false;
		} 
		else if (countEx == 0) 
		{
			alert(msg1);
			flag=false;
			return false;
		} 
		else 
		{
	
			for ( var i = 0; i < batchLen; i++) 
			{
				if((strMultiRowTotalQty[i].value != "") && (parseInt(strMultiRowTotalQty[i].value, 10) != 0))
				{
					$("input[name='strHiddenValue']").each(function()
					{	
						if(((itemBrandId.split("^")[0] == $(this).val().split("^")[0])||(itemBrandId.split("^")[1] == $(this).val().split("^")[1] )) && (strMultiRowBatchNo[i].value== $(this).val().split("^")[3]))
						{
							alert("This Item with batch ["+$(this).val().split("^")[3]+"] already exits in List");
							flag=false;
							return false;
						}								
					});
				}
			}	
			var listQty = parseInt(0);
			if(document.getElementsByName("strHiddenValue")!= null)
			{
				var hiddLength = document.getElementsByName("strHiddenValue").length;
				
				for ( var i = 0; i < hiddLength; i++) 
				{
					$("input[name='strHiddenValue']").each(function()
					{	
						if(((itemBrandId.split("^")[0] == $(this).val().split("^")[0])||(itemBrandId.split("^")[1] == $(this).val().split("^")[1] )))
						{					
						listQty = listQty + parseInt(document.getElementsByName("strHiddenValue")[i].value.split("^")[10]);	
						}
											
					});	
					
				}
			}	
			
			if(parseInt((enterQty + listQty),10) > parseInt(strTotalBalanceQty.value,10))
			{
				alert(" Batch Total Qty  +  Delivered Qty ["+(enterQty + listQty)+"] should not greater than Total Order Qty["+strTotalBalanceQty.value+"]");
				return false;
			}
					
		}	
	
		if(flag)
		{
			
			if(document.getElementsByName("strHiddenValue").length == 0)
				count=0;
			
			for ( var i = 0; i < batchLen; i++, count++) 
			{
			    /* Hidden Value Contains 
			     *   Item Id ^ Itembrand Id ^ Manufactere Name ^ Batch No ^ Manufactere Date 
			     * ^ Expiry Date ^ Unit Id ^ Balance Qty ^ Total Received Qty ^ Carton No ^ Carton Size ^ No of Carton ^ Mfg Id       
			     * */
				if((strMultiRowTotalQty[i].value != "")&& (parseInt(strMultiRowTotalQty[i].value, 10) != 0))
				{
					htmlVal = "<tr id=remId" + count + " ><td style='width: 5%;text-align:center;' >"+ (1+count)+"</td>";
					htmlVal +="<td  style='width: 18%;text-align:left;'   >"+ itemName + "</td>";
					htmlVal += "<td style='width: 8%;text-align:center;'  >"+ strMultiRowBatchNo[i].value        +"</td>";
					htmlVal += "<td style='width: 8%;text-align:center;'  >"+ strMultiRowExpireDate[i].value     +"</td>";
					htmlVal += "<td style='width: 8%;text-align:center;'  >"+ strMultiRowManufacterDate[i].value +"</td>";
					htmlVal += "<td style='width: 8%;text-align:center;'  >"+ strTotalBalanceQty.value        +"</td>";
					htmlVal += "<td style='width: 10%;text-align:center;' >"+ strMultiRowTotalQty[i].value       + "</td>";
					
					htmlVal += "<td style='width: 12%;text-align:center;' >"+ strCartonSize[i][strCartonSize[i].selectedIndex].text       + "</td>";
					if(document.forms[0].strCartonGene.value=="1")
		            {
					   htmlVal += "<td style='width: 10%;text-align:center;' >---</td>";	
		            }
		            else
		            {
		              
		               htmlVal += "<td style='width: 10%;text-align:center;' >"+ strRowCartonNo[i].value       + "</td>";
		            }
					htmlVal += "<td style='width: 8%;text-align:center;' >"+ strNoOfCarton[i].value       + "</td>";
					
					htmlVal += "<td style='width: 5%;text-align:center;cursor:pointer;' title='Delete Record'><img src='../../hisglobal/images/trash.gif' name="+ count + " onclick='removeCart(this);' ></td>";
					htmlVal += "<input type='hidden' name='strHiddenValue' id='strHiddenValue" + count + "'  value='"+ cartItemIdArr[i] + "'>" +
					           "<input type='hidden' name='strPrgDtl'      id='strPrgDtl" + count + "'       value='"+ cartPrgDtlArr[i] + "'>" +
							   "<input type='hidden' name='strPKey'        id='strPKey" + count + "'         value='"+ cartItemIdArr[i] + "'></tr>";
	                //alert($('#tbl-content').height());
					if ($('#tbl-content1').height() > 80)
						$("#headerTableTrans1 th:last").attr("id", "right-border");
				
					$("#tbl-content1").append(htmlVal);
				}		
			}
		}
		
		
		document.getElementById("indentItemList").innerHTML ="";	
		document.getElementById("id1").innerHTML ="";
		//document.getElementById("mfgNameId").innerHTML ="";	
		document.forms[0].strDrugBrandId.value = "0";
		document.getElementById("itemDtlDivId").style.display="none";
		document.getElementById("cartonDiv").style.display="none";
		//document.getElementById("strSearchDrug").focus();
  }
  else
  {
  	return false;
  }
}
function removeCart(obj) 
{
	$('#remId' + obj.name).remove();
	if ($('#tbl-content').height() < 100)
		$("#headerTableTrans th:last").attr("id", "");
}


function fillDetails(index,obj) 
{
	var batchNo = obj.value;
	var allBatchObj;
	var i = 0;
	var batchCount = 0;
    var totalRow = parseInt(document.getElementsByName("rowLength1")[0].value, 10);      
    if(obj.checked)
    { 
    	
			if(totalRow > 1) 
			{						
				batchCount = document.getElementById("strStaticIndex"+index).value;
				//alert("batchCount-->>"+batchCount+"< --( batchCount -1)-- >"+(batchCount-1));
				if(document.getElementsByName("strMultiRowBatchNo")[batchCount -1]!=null)
				{
		         document.getElementsByName("strMultiRowBatchNo")[batchCount].value = document.getElementsByName("strMultiRowBatchNo")[batchCount -1].value;
		         document.getElementsByName("strMultiRowExpireDate")[batchCount].value = document.getElementsByName("strMultiRowExpireDate")[batchCount -1].value;
		         document.getElementsByName("strMultiRowManufacterDate")[batchCount].value = document.getElementsByName("strMultiRowManufacterDate")[batchCount -1].value;
		         document.getElementsByName("strMultiRowCartonSize")[batchCount].value = document.getElementsByName("strMultiRowCartonSize")[batchCount -1].value;
		         document.getElementsByName("strMultiRowCartonNo")[batchCount].value = document.getElementsByName("strMultiRowCartonNo")[batchCount -1].value;
				}
			}
    	
    }
    else
    {
    	if(totalRow > 1) 
		{
	    	document.getElementById("strMultiRowBatchNo"+index).value = "";
	    	document.getElementById("strMultiRowExpireDate"+index).value = "";
	    	document.getElementById("strMultiRowManufacterDate"+index).value = "";
	    	document.getElementById("strMultiRowCartonSize"+index).value = "";
	    	document.getElementById("strMultiRowCartonNo"+index).value= "";
		}
    }	

}
// challan receive >> Carton Size Change
function resetProgRowQty1(delIndex, obj) 
{
	
	var rowTotalObj = document.getElementsByName("strMultiRowTotalQty");
	var prgSize = document.forms[0].strProgrammeSize.value;
	var conf = confirm("All value will be Reset after change No of Carton !!!");

	if (conf == true) 
	{		
		var cartonSize = obj.value;
		var allBatchObj;
		var i = 0;
		var batchCount = 0;
		   
        document.getElementById("strMultiRowNoOfCarton" + delIndex).value = obj.value;	
		for (j = 1; j <= prgSize; j++) 
		{
			document.getElementById("strMultiRowReceivedQty" + j + ""+ delIndex).value = "0";
			document.getElementById("strMultiRowReceivedQtyDiv" + j + delIndex).innerHTML = "";

		}
		document.getElementById("strMultiRowTotalQty" + delIndex).value = "0";
		document.getElementById("strMultiRowTotalQtyDiv" + delIndex).innerHTML = "0";
		 
	} 
	else 
	{
		obj.value = document.getElementById("strMultiRowNoOfCarton" + delIndex).value;
	}
	if(obj.value !='0')
	{
		var noOfCarton = document.getElementById("strMultiRowNoOfCarton" + delIndex).value;
		if(document.getElementById("strMultiRowCartonSize" + delIndex).value!='0')
		{
		    var tot = (document.getElementById("strMultiRowCartonSize" + delIndex).value.split("^")[2] * noOfCarton);
		}
		else
		{
			var tot = 0;
		} 
        document.getElementById("strMultiRowNoOfCartonDiv" + delIndex).innerHTML = "Appx.Capacity ="+tot;
        document.getElementById("strMultiRowNoOfCartonDiv" + delIndex).style.color = "red";
       
	}  	
 
}

/**
 * showOffLineBalQtyDtls
 * 
 * @param {Object}
 *            parentObj
 * @param {String}
 *            ordQty
 * @param {String}
 *            recQty
 * @param {String}
 *            itemName
 */
function showOffLineBalQtyDtls(parentObj, rowIndex, colIndex, mode) 
{
	if (mode == '1') 
	{
		
	//	alert("check111"+document.getElementById("strPopUpBalanceQtyDtl" + colIndex).value);
		var qtyArr = document
				.getElementById("strPopUpBalanceQtyDtl" + colIndex).value
				.split("^");
		document.getElementById("offLineBalQtyTitleDivId").innerHTML = document.forms[0].strDrugBrandId[document.forms[0].strDrugBrandId.selectedIndex].text
				+ " - Item Bal. Qty. Detail(s)";
		/* 0.Order Qty     --(A)
	     * 1.Received Qty  --(C)
	     * 2.Rejected Qty  --(D)
	     * 3.Shortage Qty  --(E)
	     * 4.Balance Qty				    
	     * 5.REPL_ORDER_QTY --{H}
	     * 6.HSTNUM_REJQTY_AFT_VERIFY --(F)
	     * 7.HSTNUM_STOP_QTY --(B)
	     * 8.HSTNUM_SUPP_RETURN_QTY --(G)
	     * */
		document.getElementById("offLineBalOrdQtyDivId").innerHTML = qtyArr[0];
		document.getElementById("offLineBalRecQtyDivId").innerHTML = qtyArr[1];
		document.getElementById("offLineBalRejQtyDivId").innerHTML = qtyArr[2];
		document.getElementById("offLineBalShortQtyDivId").innerHTML = qtyArr[3];
		document.getElementById("offLineBalRejQtyAfterVerifyDivId").innerHTML = qtyArr[6];
		document.getElementById("offLineSupplierReturnQtyDivId").innerHTML = qtyArr[8];		
		document.getElementById("offLineStopDivId").innerHTML = qtyArr[7];
		document.getElementById("offLineBalReplacementOrderQtyDivId").innerHTML = qtyArr[5];
		document.getElementById("offLineBalPoPreSampleQtyDivId").innerHTML = qtyArr[9];
		

		var intOrderQty 		   = parseInt(qtyArr[0], 10);
		var intRecQty   		   = parseInt(qtyArr[1], 10);
		var intRejQty   		   = parseInt(qtyArr[2], 10);
		var intShortQty 		   = parseInt(qtyArr[3], 10);
		var intReplacementOrderQty = parseInt(qtyArr[5], 10);
		var intStopQty             = parseInt(qtyArr[7], 10);
		var intSampleQty            = parseInt(qtyArr[9], 10);
		
		//alert("<-Order Qty-->"+intOrderQty+"<--intRecQty-->"+intRecQty+"<--intRejQty-->"+intRejQty+"<--intShortQty-->"+intShortQty+"<--intReplacementOrderQty-->"+intReplacementOrderQty+"<--intStopQty-->"+intStopQty);
        var diff                   = ( intOrderQty - intStopQty );    
		var finalBalQty =  diff  -(intRecQty - intRejQty - intShortQty - intReplacementOrderQty+ intSampleQty);
		//alert("finalBalQty-->"+finalBalQty);
		document.getElementById("offLineFianlBalQtyDivId").innerHTML = "("+intOrderQty+"-"+intStopQty+")"
				+ "-("
				+ intRecQty
				+ "-"
				+ intRejQty
				+ "-"
				+ intShortQty
				+ "-"
				+ intReplacementOrderQty
				+ "+"
				+ intSampleQty
				+ ") = " + finalBalQty;
		display_popup_menu(parentObj, "offLineBalQtyDtlsDivId", "420", "632");
	}
	else if(mode== '2')
	{
		        /*
		         *  orderQty 				= 0;
					stopQty 				= 1;
					suppliedQty 			= 2;
					rejectedQty 			= 3;	
					shortageQty 			= 4;
					rejectedQtyAfterVerify 	= 5;
					supplierReturnQty 		= 6;
					replacementOrderQty 	= 7;
				* */
				
		//alert("check2222"+document.getElementById("strPopUpBalanceQtyDtl" + colIndex).value);
		var qtyArr = document.getElementById("popUpValue" + rowIndex).value.split("^");
		document.getElementById("offLineBalQtyTitleDivId").innerHTML = document.getElementById("storeNameDiv"+rowIndex).innerHTML + " - Item Bal. Qty. Detail(s)";				
		
		document.getElementById("offLineBalOrdQtyDivId").innerHTML = qtyArr[0];
		document.getElementById("offLineStopDivId").innerHTML = qtyArr[1];
		document.getElementById("offLineBalRecQtyDivId").innerHTML = qtyArr[2];
		document.getElementById("offLineBalRejQtyDivId").innerHTML = qtyArr[3];
		document.getElementById("offLineBalShortQtyDivId").innerHTML = qtyArr[4];
		document.getElementById("offLineBalRejQtyAfterVerifyDivId").innerHTML = qtyArr[5];
		document.getElementById("offLineSupplierReturnQtyDivId").innerHTML = qtyArr[6];			
		document.getElementById("offLineBalReplacementOrderQtyDivId").innerHTML = qtyArr[7];
		
		var intOrderQty 		   = parseInt(qtyArr[0], 10);
		var intRecQty   		   = parseInt(qtyArr[2], 10);
		var intRejQty   		   = parseInt(qtyArr[3], 10);
		var intShortQty 		   = parseInt(qtyArr[4], 10);
		var intReplacementOrderQty = parseInt(qtyArr[7], 10);
		var intStopQty             = parseInt(qtyArr[1], 10);		       
        var diff                   = ( intOrderQty - intStopQty );    
		var finalBalQty            =  diff  -(intRecQty - intRejQty - intShortQty - intReplacementOrderQty);
		//alert("finalBalQty-->"+finalBalQty);
		document.getElementById("offLineFianlBalQtyDivId").innerHTML = "("+intOrderQty+"-"+intStopQty+")"
				+ "-("
				+ intRecQty
				+ "-"
				+ intRejQty
				+ "-"
				+ intShortQty
				+ "-"
				+ intReplacementOrderQty
				+ ") = " + finalBalQty;
		display_popup_menu(parentObj, "offLineBalQtyDtlsDivId", "420", "300");
	}
	else 
	{
		//alert("check3333"+document.getElementById("strPopUpBalanceQtyDtl" + colIndex).value);
		var qtyArr = document.getElementById("strPopUpBalanceQtyDtl" + colIndex).value.split("^");
		document.getElementById("offLineBalQtyTitleDivId").innerHTML = document.forms[0].strItemBrandName.value
				+ " - Item Bal. Qty. Detail(s)";
				
				        /* 5.Order Qty 
						 * ^ Rec Qty 
						 * ^ Rejected Qty 
						 * ^ Shortage Qty 
						 * ^ Balance Qty 
						 * ^ UNIT NAME 
						 * ^ REPLACEMENT_ORDER_QTY
						 * ^ REJQTY_AFT_VERIFY 
						 * ^ HSTNUM_STOP_QTY 
						 * ^ HSTNUM_SUPP_RETURN_QTY 
						 * /
		                /* 0.Order Qty     --(A)
					     * 1.Received Qty  --(C)
					     * 2.Rejected Qty  --(D)
					     * 3.Shortage Qty  --(E)
					     * 4.Balance Qty	
					     * 5.Unit Name			    
					     * 6.REPL_ORDER_QTY --{H}
					     * 7.HSTNUM_REJQTY_AFT_VERIFY --(F)
					     * 8.HSTNUM_STOP_QTY --(B)
					     * 9.HSTNUM_SUPP_RETURN_QTY --(G)
					     * */
        //20^10^0^0^10^No.^0^0^0^0
		document.getElementById("offLineBalOrdQtyDivId").innerHTML = qtyArr[0];
		document.getElementById("offLineBalRecQtyDivId").innerHTML = qtyArr[1];
		document.getElementById("offLineBalRejQtyDivId").innerHTML = qtyArr[2];
		document.getElementById("offLineBalShortQtyDivId").innerHTML = qtyArr[3];
		document.getElementById("offLineBalRejQtyAfterVerifyDivId").innerHTML = qtyArr[7];
		document.getElementById("offLineSupplierReturnQtyDivId").innerHTML = qtyArr[9];		
		document.getElementById("offLineStopDivId").innerHTML = qtyArr[8];
		document.getElementById("offLineBalReplacementOrderQtyDivId").innerHTML = qtyArr[6];
		
		var intOrderQty 		   = parseInt(qtyArr[0], 10);
		var intRecQty   		   = parseInt(qtyArr[1], 10);
		var intRejQty   		   = parseInt(qtyArr[2], 10);
		var intShortQty 		   = parseInt(qtyArr[3], 10);
		var intReplacementOrderQty = parseInt(qtyArr[6], 10);
		var intStopQty             = parseInt(qtyArr[8], 10);
		       
        var diff                   = ( intOrderQty - intStopQty );    
		var finalBalQty =  diff  -(intRecQty - intRejQty - intShortQty - intReplacementOrderQty);
		//alert("finalBalQty-->"+finalBalQty);
		document.getElementById("offLineFianlBalQtyDivId").innerHTML = "("+intOrderQty+"-"+intStopQty+")"
				+ "-("
				+ intRecQty
				+ "-"
				+ intRejQty
				+ "-"
				+ intShortQty
				+ "-"
				+ intReplacementOrderQty
				+ ") = " + finalBalQty;
		display_popup_menu(parentObj, "offLineBalQtyDtlsDivId", "420", "300");

	}

}

/*

function checkDateFormat(obj) 
{
  var chkdate       = obj.value;	 
  if(chkdate.length>0)
  {		  	  
	  if(!chkdate.match(/^([0]?[1-9]|[1|2][0-9]|[3][0|1])[.\/-]([0]?[1-9]|[1][0-2])[.\/-]([0-9]{4}|[0-9]{2})$/))
	  {
	       alert('Incorrect format Please follow [ dd-Mon-yyyy ] format ');		     
           obj.value ='';           
           setTimeout(function(){obj.focus();}, 0);
           return ;			   
	  }					  
  }
}	

function changePOType(mode)
{
	var dwhTypeId = document.forms[0].strDwhTypeId.value;
	var  poTypeId = document.forms[0].strComboPOTypeId.value.split("^")[0];
	if((dwhTypeId!='10'&& poTypeId=='22') || (dwhTypeId!='10'&& poTypeId=='28'))
	{				
		//$('#strComboPOTypeId option:first-child');
		alert("For DWH Central Purchase Or Central Purchase (Repeat) Not Allowed");
		$("#strComboPOTypeId").val($("#strComboPOTypeId option:first").val());		
		//('select#strComboPOTypeId option:first-child').attr("selected", "selected");
		return false;
	}
	else
	{
		pageResetMethod(3);
	}
	//var retVal = confirm("All values will be reset !!\n\nAre You Sure?");
	//if(retVal) 
	
}
function getDrugNameSelected(itemId, selectId)
{	
	var flag = 0;
	var sel = document.getElementById(selectId);
	
	for (i=0; i<sel.options.length; i++) {				
		if ( sel.options[i].value.split("^")[1] == itemId) 
		{
			sel.selectedIndex = i;			
			flag = 1;
			break;
		}				
	}	
	if(flag == 0)
	{
		sel.selectedIndex=0;
		document.forms[0].strSearchDrug.value = "";
	}
	else
	{
		displaySelectedDrug(selectId);	
		setItemOrderQty();		
	}	    
	 
}

function displaySelectedDrug(selectId) 
{ 
  	document.getElementById("DrugNameId").innerHTML = $("#"+selectId+" option:selected").text();
}
 
   
    function IsValidDate(myDate) 
	{
	       var filter = /^([012]?\d|3[01])-([Jj][Aa][Nn]|[Ff][Ee][bB]|[Mm][Aa][Rr]|[Aa][Pp][Rr]|[Mm][Aa][Yy]|[Jj][Uu][Nn]|[Jj][u]l|[aA][Uu][gG]|[Ss][eE][pP]|[oO][Cc][Tt]|[Nn][oO][Vv]|[Dd][Ee][Cc])-(19|20)\d\d$/
	    return filter.test(myDate);
	}
	
	function checkDateFormat(obj) 
	{
	  if(document.forms[0].strComboPOTypeId.value.split("^")[1]=='2')
	  {
	  
	    if(trimAll(obj.value).length > 0)
		{		
		    var isValid = IsValidDate(obj.value);
		    if (isValid) 
		    {
		      
		    }
		    else 
		    {
		        alert('Incorrect format Please follow [dd-Mon-yyyy] format');
		        obj.value ='';
		        return false;
		    }
		}
	  }
	}

function checkDecimalValue(obj)
{	
	 var rate=obj.value;
	 var checkRate=obj.value.split(".");

	//alert(checkRate.length);
	
	if(checkRate.length > 2)
	{
		alert("Default Rate should be in format 000000000.0000");
		obj.value = "";
		return false;
	}
		
	if(checkRate[1].length > 4 )
	{
		alert("Please Enter the digits after decimal places Less than Equal to 4 digits !");
		obj.value = checkRate[0]+"."+checkRate[1].substr(0,4);
		return false;
	}
	
	
}

//as clicked on circleto hide/open the circle
function openCircleDiv(imgObj,index)
{
	if (imgObj.title == "Hide Circle Detail(s)") 
	{
		// Change Image Attribute
		imgObj.src = "/DWH_PHD/hisglobal/images/Pl_Green_Sqr.png";
		imgObj.title = "Open Circle Detail(s)";
		document.getElementById("divCircleId" + index).style.display='none';
						
	}
	else
	{  
		imgObj.src = "/DWH_PHD/hisglobal/images/Mi_Green_Sqr.png";
		imgObj.title = "Hide Circle Detail(s)";
		document.getElementById("divCircleId" + index).style.display='table-row-group';
	}	
}
*/
//called from pop up window (close)
function hideProgrammePopUp(divId,index)
{
	  document.getElementById("programme"+index).innerHTML="";
      hide_popup_menu("programme"+index);
}

//component check box is checked/un-checked
function checkComponentValue(chkObj,index)
{
	if(chkObj.checked)
	{
		document.getElementById("strDComponentId" + index).disabled = false;
		document.getElementById("strDComponentValue" + index).disabled = false;
	}
	else
	{
		document.getElementById("strDComponentId" + index).disabled = true;
		document.getElementById("strDComponentValue" + index).disabled = true;
	}
}

function hideApprovalDiv()
{
	if(document.forms[0].strPOHiddenValue.value.split("^")[7]=='21')
	{
		 document.getElementById("LPApprovalDiv").style.display="none";
	}
}
function cancelToDesk(){
	document.forms[0].hmode.value = "CANCELTOAPPROVALDESK";
	document.forms[0].submit();
}
function resetCombo()
{
   var itemParaObj1 = document.getElementById("divPOItemDtl");
   itemParaObj1.innerHTML ="<select id='strPOItemID' name='strPOItemID' class='comboNormal'><option value='0'>Select Value</option></select>";
}
function pageResetMethod(mode)
{
	if(mode=='1')
	{
		  
		   document.forms[0].reset();
		   document.forms[0].strIndentPeriodValue.disabled = false;
           //document.forms[0].strItemCat.disabled = false;
           document.forms[0].strComboPOTypeId.disabled = false;
           document.forms[0].strSupplierId.disabled = false;
           document.forms[0].strPOItemID.disabled = false; 
           document.forms[0].strSupplierName.disabled = false;
           document.getElementById("supplierName").style.display="none";
           //document.forms[0].strDDeliveryDays.disabled = true;
           document.forms[0].strSearchDrug.disabled = false;
           
           //document.getElementsByName("strItemCat")[0].value='0';	
           var itemParaObj1 = document.getElementById("divPOItemDtl");
		   itemParaObj1.innerHTML ="<select id='strPOItemID' name='strPOItemID' class='comboNormal'><option value='0'>Select Value</option></select>";
		   //var itemParaObj2 = document.getElementById("divPOTypeId");
		   //itemParaObj2.innerHTML ="<select name='strComboPOTypeId' class='comboNormal'><option value='0'>Select Value</option></select>";
		   loadAutocompleteItems();
           document.getElementById("poRateDivId").style.display="none";
           objVal = document.getElementById("generateDynamicDiv");
           objVal.innerHTML=""; 
           
           document.getElementById("contractedDeliveryDaysId").innerHTML = "";
           document.getElementById("specificationDivId").innerHTML ="";          
          
           document.getElementById("poRefDateDiv").style.display="none";
           document.getElementById("poRefDateCalDiv").style.display="block";           
           document.getElementById("poRefDateDiv").innerHTML = "";
           
           document.getElementById("totalPOCost").innerHTML = "0.00";
	       document.forms[0].strTotalPOCost.value = "0.00";
	       document.getElementById("imageDiv").style.display="block";		 
	       var itemParaObj = document.getElementById("divComponentDetails");		
		   itemParaObj.innerHTML = "";
		   
		   document.forms[0].strItemRate.disabled = false;
	        document.forms[0].strItemRateTax.disabled = false;
	        document.getElementsByName("strItemRateUnitId")[0].disabled = false;
	        document.forms[0].strItemMake.disabled = false;
	        
	        document.getElementById("errMsg").innerHTML = "";
	        document.getElementById("warningMsg").innerHTML = "";
	        document.getElementById("normalMsg").innerHTML = "";
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
	       //document.forms[0].strDDeliveryDays.disabled = true;
	       
	       document.getElementsByName("strItemRateUnitId")[0].disabled = false;
		   document.forms[0].reset();
           document.forms[0].strPOItemID.disabled = false; 
           document.getElementById("poRateDivId").style.display="none";
           objVal = document.getElementById("generateDynamicDiv");
           objVal.innerHTML=""; 
           
           document.getElementById("contractedDeliveryDaysId").innerHTML = "";
           
           document.getElementById("imageDiv").style.display="block";	
            document.forms[0].strGoFlag.value='0';	   
            document.forms[0].strItemRate.disabled = false;
	        document.forms[0].strItemRateTax.disabled = false;
	        document.getElementsByName("strItemRateUnitId")[0].disabled = false;
	        document.forms[0].strItemMake.disabled = false;
	        
	        document.getElementById("errMsg").innerHTML = "";
	        document.getElementById("warningMsg").innerHTML = "";
	        document.getElementById("normalMsg").innerHTML = "";
            
	}     
	
	//CALLED FROM PO REFERENCE DATE ON GENERATION PAGE
	if(mode=='3')
	{
		
		document.getElementById("errMsg").innerHTML = "";
	    document.getElementById("warningMsg").innerHTML = "";
	    document.getElementById("normalMsg").innerHTML = "";
	        			
		document.getElementById("itemOrderQty").innerHTML = "";
		var suppParaObj1 = document.getElementById("divSupplier");
	    suppParaObj1.innerHTML ="<select name='strSupplierId' class='comboMax'><option value='0'>Select Value</option></select>";
	    
	    document.getElementById("specificationDivId").innerHTML = "";
	    var itemParaObj1 = document.getElementById("divPOItemDtl");
		itemParaObj1.innerHTML ="<select id='strPOItemID' name='strPOItemID' class='comboMax'><option value='0'>Select Value</option></select>";
		(document.getElementById("supplierName")).style.display="none";	
		document.getElementById("contractedDeliveryDaysId").innerHTML = "";
		
		if(document.forms[0].strComboPOTypeId.value.split("^")[1]=='2')
		{
			document.getElementById("divPurchaseRefrenceNoTextId").innerHTML="<input type='text' name='strPoRefrenceNoText' value=''  maxlength='200' onkeypress='return validateData(event,20);'   size='40'/>";
			
			document.getElementById("divPurchaseRefrenceNoId").style.display="none";
			document.forms[0].strDDeliveryDays.disabled=false;
			document.forms[0].strDDeliveryDays2.disabled=true;
			document.forms[0].strDDeliveryDays3.disabled=true;
			document.forms[0].strDDeliveryDays4.disabled=true;
			
		}
		else
		{
			//document.getElementById("divPurchaseRefrenceNoTextId").innerHTML="";
			document.getElementById("divPurchaseRefrenceNoTextId").innerHTML="<input type='text' name='strPoRefrenceNoText' value=''  maxlength='200' onkeypress='return validateData(event,20);'   size='40'/>";
			document.getElementById("divPurchaseRefrenceNoTextId").style.display="block";
			document.getElementById("divPurchaseRefrenceNoId").style.display="none";
			//document.forms[0].strDDeliveryDays.disabled=true;
			document.forms[0].strDDeliveryDays2.disabled=false;
			document.forms[0].strDDeliveryDays3.disabled=false;
			document.forms[0].strDDeliveryDays4.disabled=false;
		}
	
		if((document.forms[0].strPORefrenceDate.value).length > 0)
		{
				  
		    var finDate = (document.forms[0].strIndentPeriodValue.value).split("-");
		    var stDate  = '01-Apr-' + finDate[0].trim();
		    var endDate = '31-Mar-' + finDate[1].trim();
		   
		    var hisValidator = new HISValidator("PODeskGenerateTransBean");
		    hisValidator.addValidation("strPORefrenceDate", "dtgtet="+stDate,  "PO Refrence Date Must be greater than Financial Start Date." );
		    hisValidator.addValidation("strPORefrenceDate", "dtltet="+endDate, "PO Refrence Date Must be Less than Financial End Date." );
		    var retVal = hisValidator.validate();
			hisValidator.clearAllValidations();
			
			if(retVal)
			{
			    var hmode = "GETPOITEMLIST";
				var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strPOTypeId="+document.forms[0].strComboPOTypeId.value+
				"&strItemCat=10&strPOStoreID="+document.forms[0].strStoreId.value+"&stDate="+stDate+"&endDate="+endDate;
								
				ajaxFunction(url,"5");
			}
			else
				document.forms[0].strPORefrenceDate.value = "";
		}
	}
	
	
}

//called from clear button
function clearForm()
{
	var retVal = confirm("All values will be reset !!\n\nAre You Sure?");
	if(retVal) 
	{
		document.forms[0].hmode.value = "DELIVERYDETAIL";
	    document.forms[0].submit();
	}
}
//called from clear button
function resetForm(mode)
{
	var retVal = confirm("All values will be reset !!\n\nAre You Sure?");
	if(retVal) 
	{
		 if(mode=='1')
		 {
		    document.forms[0].hmode.value = "ACCEPTANCE";
		 }		
	    document.forms[0].submit();
	}
}

//called from cancel button
function cancelToGenerateDesk(mode)
{
	
	document.forms[0].hmode.value = "CANCELTOSUPPLIERDESK";
	document.forms[0].submit();
	
}

function cancelToApprovalDesk(mode)
{
  document.forms[0].hmode.value = "CANCELTOPOAPPROVALDESK";
  document.forms[0].submit();	
}
/*
//called from save button
function POValidate(mode)
{
	
	var totalPrgQty1 = document.forms[0].strTotalSchIQty.value;
	var totalPrgQty2 = document.forms[0].strTotalSchIIQty.value;
	var totalPrgQty3 = document.forms[0].strTotalSchIIIQty.value;
	var totalPrgQty4 = document.forms[0].strTotalSchIVQty.value;
	
	var authTypeId ="";
	var totalOrderQty = document.forms[0].strTotalQrderQty.value;
	if(mode=='1')
	{
		
		 authTypeId = document.forms[0].strComboPOTypeId.value.split("^")[1];	
	}
	else
	{
		 authTypeId = document.forms[0].strPOAuthTypeId.value;
	}
	
	var hisValidator = new HISValidator("PODeskGenerateTransBean");
	
	hisValidator.addValidation("strItemRate","req", "Please enter Item Rate" );
	hisValidator.addValidation("strItemRateUnitId", "dontselect=0", "Please Select Rate Unit" );	
	hisValidator.addValidation("strTotalQrderQty", "req", "Please enter order qty for atleast one consignee !!" );
	hisValidator.addValidation("strPoRefrenceNoText","req", "Please enter PO reference");
	
	hisValidator.addValidation("strDPurchaseSource", "dontselect=0", "Please select Mode of Purchase " );
	
	if(mode=='3')
	{
		hisValidator.addValidation("strVerifiedBy", "dontselect=0", "Please select Approved By" );
		hisValidator.addValidation("strVerifiedDate", "req", "Approved Date is Mandatory" );
		
	}
	else
	{
		hisValidator.addValidation("strVerifiedBy", "dontselect=0", "Please select Verify By" );
	    hisValidator.addValidation("strVerifiedDate", "req", "Verified Date is Mandatory" );
	    
	}  
	
	if(document.forms[0].strDTenderDate.value.length==11 && document.forms[0].strDQuotationDate.value.length==11)
	{
		hisValidator.addValidation("strDQuotationDate", "dtlt="+document.forms[0].strCurrentDate.value, "Quotation Date Must be Less than Current Date." );
	}
		
	if(document.forms[0].strDQuotationDate.value.length==11)
		hisValidator.addValidation("strDQuotationDate", "dtlt="+document.forms[0].strCurrentDate.value, "Quotation Date Must be Less than Current Date." );
	
	if(document.forms[0].strNextPoDate.value.length==11)
	{
		hisValidator.addValidation("strNextPoDate", "dtgt="+document.forms[0].strCurrentDate.value, "Next PO Date Must be greater than Current Date." );
	}
	
	if(document.forms[0].strPurchaseCommitteMeetingDate.value.length ==11)
		hisValidator.addValidation("strPurchaseCommitteMeetingDate", "dtlt="+document.forms[0].strPORefrenceDate.value, "Committe Meeting Date Must be Less than PO Date." );
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	
	if(retVal)
	{
		if(document.forms[0].strItemRate.value=='0')
		{
			alert("Item Rate must be greater than Zero !!");
			return false;
		}
		
		if(document.forms[0].strTotalQrderQty.value=='0')
		{
			alert("Please enter order qty for atleast one consignee !!");
			return false;
		}
				
		//alert("document.forms[0].strTotalQrderQty.value = " + document.forms[0].strTotalQrderQty.value);
		//alert("totalContractedQty = " + totalContractedQty);
		if (parseInt(totalContractedQty) > 0)
		{
			if (parseInt(totalOrderQty) > parseInt(totalContractedQty))
			{
				alert("Contracted Qty. is greater than Total Order Quantity");
			}
		}
				
		if(totalPrgQty4 > 0)
		{
		 	if(totalPrgQty3 == 0)
		 	{
		 		alert("Please Enter Schedule III before IV.");
		 		return false
		 	}	 			 	
		}		 
		if(totalPrgQty3 > 0)
		{
		 	if(totalPrgQty2 == 0)
		 	{
		 		alert("Please Enter Schedule II before III.");
		 		return false;
		 	}		 			 			 	
		 }
		 if(totalPrgQty2 > 0)
		 {
		 	if(totalPrgQty1 == 0)
		 	{
		 		alert("Please Enter Schedule I before II.");
		 		return false;
		 	}			 		 			 	
		}
				
		if(document.forms[0].strDDeliveryDays.value=='0' && document.forms[0].strDDeliveryDays2.value=='0' && document.forms[0].strDDeliveryDays3.value=='0' && document.forms[0].strDDeliveryDays4.value=='0')
		{
			alert("Delivery Day should be greater than zero !!");
			return false;
		}
		
			alert("You Are Going To Save \n PO No. :  " + document.forms[0].strPoRefrenceNoText.value 
				+"\n PO Reference Date : " + document.forms[0].strPORefrenceDate.value 
				+" With PO Value : " + document.forms[0].strTotalPOCost.value);
		//}
		
		
				
		retVal = confirm("Are You Sure?");
		if(retVal)
		{
			//enable the disbaled field
			document.forms[0].strComboPOTypeId.disabled = false;
			document.forms[0].strIndentPeriodValue.disabled = false;	
			document.forms[0].strItemRate.disabled = false;
			document.forms[0].strItemRateTax.disabled = false;
			document.forms[0].strItemMake.disabled = false;
			document.getElementsByName("strItemRateUnitId")[0].disabled = false;
			document.forms[0].strSupplierId.disabled = false;			
			
			//if other supplier is selected
			if(document.forms[0].strSupplierId.value == "1")
				document.forms[0].strSupplierName.disabled = false;
			else
				document.forms[0].strSupplierName.value = "";
					
		   	document.forms[0].strPOItemID.disabled = false; 
		   	document.forms[0].strDDeliveryDays.disabled = false;
		   	
		   
		   	
		   	if(mode == 1)
		   	{
		   		  document.forms[0].strPOFinancialDtl.value = document.forms[0].strIndentPeriodValue[document.forms[0].strIndentPeriodValue.selectedIndex].text;
		   		  document.forms[0].hmode.value="INSERTNEWPO";
		   	}	  							
		   	else
		   	{	
		   		if(mode == 3)
		   		{	  
		   			 document.forms[0].strPOItemID.disabled = false; 		
		   		     document.forms[0].hmode.value="POAPPROVAL";
		   		}
		   		else
		   		{
		   			 document.forms[0].strPOItemID.disabled = false;
		   			 document.forms[0].hmode.value="UPDATEPO";
		   		} 		   		
		   		
		   	}	
		   			
			document.forms[0].submit();
		}
	}
}


//called from rate, tax, rate unit
function resetDiv(mode)
{
	var obj1 = document.getElementsByName("strQrderQty");
  	var obj2 = document.getElementsByName("strOrdeCost");
  	
  	if(mode=='1')
  	{
  		var rateBaseVal = 0.0;
  		var rateWithTax = 0.0;
  		var finalRate = 0.0;
  		
  		var rate = trimAll(document.forms[0].strItemRate.value);
	    var tax = trimAll(document.forms[0].strItemRateTax.value);
	    var rateUnit  = trimAll(document.forms[0].strItemRateUnitId.value);
	    
	    if(rate=="" || rate.length <=0) rate = "0";
	    if(tax=="" || tax.length <=0) tax = "0";
	    if(rateUnit != "0") rateBaseVal =  parseFloat(rateUnit.split('^')[1],10);
	    
	    if(rateBaseVal > 0) finalRate = parseFloat(rate/rateBaseVal,10);
	    
	    rateWithTax = roundValue(finalRate + (finalRate * parseFloat(tax,10))/100,4);
	    
	    document.forms[0].strItemTotalRate.value = rateWithTax;
	    //in case of local purchase, there will be single item
	    calStoreWiseCost(document.getElementById("strQrderQty0").value,"0");
		calculateTotalQty();	
		calPOCost();
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
    
}
*/
//called within go function. To set the rate value
function setValueItem(mode)
{
	var poArr;
	
	//generate
	if(mode=='1')
	{
		
		/*suupId(0)^rate(1)^rateUnitId(2)^rate with tax(3)^delivery days(4)^imported flag(5)^tenderno(6)^quotation no(7)^tender date(8)^
		 * quotation date(9)^neg meeting date(10)^tax(11)^supp contracted qty(12)^ Rate Contract Flg (13) */
		 document.forms[0].strSupplierId.disabled = false; 		
		if(document.forms[0].strSupplierId.value.split("^")[13] == "1")  // Rate Contract
		{
			var suppValueArr = (document.forms[0].strSupplierId.value).split("^");
			
			document.forms[0].strDDeliveryDays.value = suppValueArr[4];
			document.forms[0].strItemRate.value = suppValueArr[1];
	        document.forms[0].strItemRateTax.value = suppValueArr[11];
	        document.forms[0].strItemTotalRate.value = suppValueArr[3];
	        
	        var rateUnitArr = suppValueArr[2].split("@");
	        document.getElementsByName("strItemRateUnitId")[0].value = rateUnitArr[0] + "^" + rateUnitArr[1] + "^" + rateUnitArr[2];
		    document.forms[0].strDTenderNo.value =  suppValueArr[6];
	        document.forms[0].strDTenderDate.value =  suppValueArr[8];
	        document.forms[0].strDQuotationNo.value = suppValueArr[7];
	        document.forms[0].strDQuotationDate.value = suppValueArr[9];
	        
	        if(suppValueArr[12] == "0")
	        	document.getElementById("contractedDeliveryDaysId").innerHTML = "-";
	        else	
	        	document.getElementById("contractedDeliveryDaysId").innerHTML = suppValueArr[12];
	        	totalContractedQty = suppValueArr[12];
	        	        
	       
	      	
	      	document.forms[0].strItemRate.disabled = true;
	        document.forms[0].strItemRateTax.disabled = true;
	        document.getElementsByName("strItemRateUnitId")[0].disabled = true;
	        document.forms[0].strItemMake.disabled = true;
	        //document.forms[0].strDDeliveryDays.disabled = true;	  	        
	       
	        document.forms[0].strSupplierId.disabled = true; 
	        
	        
		}
		else
		{
			
			document.getElementById("contractedDeliveryDaysId").innerHTML = "-";
			document.forms[0].strDDeliveryDays.disabled = false;
			document.forms[0].strSupplierName.disabled = true;		
			document.forms[0].strDTenderNo.value = "0";
	        document.forms[0].strDTenderDate.value = "";
	        document.forms[0].strDQuotationNo.value = "0";
	        document.forms[0].strDQuotationDate.value = "";
	        document.forms[0].strDTenderNo.readOnly=false;
            document.forms[0].strDTenderDate.readOnly=false;
			
		}
        
        document.forms[0].strComboPOTypeId.disabled = true;
        document.forms[0].strSupplierId.disabled = true;
        document.forms[0].strPOItemID.disabled = true;
        document.forms[0].strIndentPeriodValue.disabled = true;
        document.forms[0].strSearchDrug.disabled = true; 
        
        getComponentDetails("1");
	}      
	
	//modify
	if(mode=='2')
	{
		      //alert("PO Item ID:::"+document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value);
		      //    0             1            2        3                       4                5        6              7                                                 8                     9              10
	          // ItemBrandID @ Item Id @ Supplier Id @ Rate @ Rate Unit ^ Rate Base value ^ 0 @ Tax @ Rate With Tax @ Delivery Day(s) @ Imported Type[1-Imported,0-Indian] ^ Contract Qty @ default unit @ specification
		     
	         // document.getElementById("contractedDeliveryDaysId").innerHTML = (document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('^')[11]; 	          
	          
	          document.getElementsByName("strItemRateUnitId")[0].value = (document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('@')[4];
	          
	          // This Value Get from DataBase
	          //document.forms[0].strDDeliveryDays.value = (document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('@')[7];
	          document.forms[0].strItemRate.value = (document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('@')[3];
              document.forms[0].strItemRateTax.value = (document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('@')[5];
              
              
              document.getElementsByName("strItemManufacturerId")[0].value = (document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('@')[2];
              
              document.forms[0].strItemTotalRate.value = parseFloat((document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('@')[6])/parseInt( ((document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('@')[4]).split('^')[1]);
              // View Mode
              if(document.forms[0].strViewMode.value == "0")
              {
	              if(document.forms[0].strSupplierName.value == "0")
	              {
	              		          
			          document.forms[0].strItemRate.disabled = false;
			          document.forms[0].strItemRateTax.disabled = false;
			          document.forms[0].strItemMake.disabled = false;
			          document.getElementsByName("strItemRateUnitId")[0].disabled = false;
			          document.forms[0].strDDeliveryDays.disabled = false;
	              }
	              else
	              {
	              	  document.forms[0].strItemRate.disabled = true;
			          document.forms[0].strItemRateTax.disabled = true;
			          document.forms[0].strItemMake.disabled = true;
			          document.getElementsByName("strItemRateUnitId")[0].disabled = true;
			          document.forms[0].strDDeliveryDays.disabled = false;
	              }
              }
              else
              {
              	      document.forms[0].strItemRate.disabled = true;
			          document.forms[0].strItemRateTax.disabled = true;
			          document.forms[0].strItemMake.disabled = true;
			          document.getElementsByName("strItemRateUnitId")[0].disabled = true;
			          document.forms[0].strDDeliveryDays.disabled = false;
              	
              }  
	          document.getElementById("specificationDivId").innerHTML = (document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('@')[10];
	          document.getElementById("itemOrderQty").innerHTML = "Default Pack Size [ "+(document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('@')[9]+"  ]";
	            
	         
	            poArr = (document.forms[0].strPOHiddenValue.value).split("^");
	                        
	            document.getElementsByName("strPoRefrenceNo")[0].value =	 poArr[12];          
	            document.getElementsByName("strDPurchaseSource")[0].value =poArr[10];
	            if(poArr[21] != null && poArr[21] != "null" && poArr[21].length > 0)
	            {
	             	document.forms[0].strNextPoDate.value=poArr[21];
                } 
	            document.forms[0].strDTenderNo.value = poArr[14];
	            if(poArr[15] != null && poArr[15] != "null" && poArr[15].length > 0)
	            {
	            	document.forms[0].strDTenderDate.value = poArr[15];
				}
	            document.forms[0].strDQuotationNo.value = poArr[16];
	            
	            if(poArr[17] != null && poArr[17] != "null" && poArr[17].length > 0)
	            	document.forms[0].strDQuotationDate.value = poArr[17];
	            
	            if(poArr[22] != null && poArr[22] != "null" && poArr[22].length > 0)	
	            	document.forms[0].strPurchaseCommitteMeetingDate.value = poArr[22];
	            
	            if(((document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('@')[8]).split("^")[1] == "0")
	            	 document.getElementById("contractedDeliveryDaysId").innerHTML = "-";             
	            else
	            	 document.getElementById("contractedDeliveryDaysId").innerHTML = ((document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('@')[8]).split("^")[1];	
	            	 totalContractedQty = ((document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value).split('@')[8]).split("^")[1];

	            
	            document.getElementById("poRateDivId").style.display="block";
	            document.getElementById("divPurchaseDetails").style.display="block";
	            document.forms[0].strPOItemID.disabled = true;
	            
	            /*
	             * If Local Purchase Then Only One Schedule Will be filled
	             * */         
	            if(document.forms[0].strPOAuthTypeId.value=='2')
				{
					
					document.forms[0].strDDeliveryDays.disabled=false;
					document.forms[0].strDDeliveryDays2.disabled=true;
					document.forms[0].strDDeliveryDays3.disabled=true;
					document.forms[0].strDDeliveryDays4.disabled=true;
					
				}
				else
				{
					//document.forms[0].strDDeliveryDays.disabled=true;
					document.forms[0].strDDeliveryDays2.disabled=false;
					document.forms[0].strDDeliveryDays3.disabled=false;
					document.forms[0].strDDeliveryDays4.disabled=false;
				}        
	                     
	                        
	            getComponentDetails("2");
	}
	//View / Supplier Interface
	if(mode=='3')
	{
		    //10100524@10000524@1013379@70@630106^1^0@0@70@1@0^0@Bottle@Abbott Healthcare Pvt. Ltd.@ Rate Unit Name
	          var divPOTypeId = document.getElementById("rateDivID");	           
              divPOTypeId.innerHTML =(document.forms[0].strPOItemID.value).split('@')[3]+" "+(document.forms[0].strPOItemID.value).split('@')[11];
	          
	                  	                
              document.getElementById("strItemRateTax").innerHTML = (document.forms[0].strPOItemID.value).split('@')[5];       
      
              document.getElementsByName("strItemManufacturerId")[0].value = (document.forms[0].strPOItemID.value).split('@')[2];           
              document.getElementById("strItemTotalRate").innerHTML = parseFloat((document.forms[0].strPOItemID.value).split('@')[6])/parseInt( ((document.forms[0].strPOItemID.value).split('@')[4]).split('^')[1]);
	          document.getElementById("itemOrderQty").innerHTML = ""+(document.forms[0].strPOItemID.value).split('@')[9]+" ";
	            
	          poArr = (document.forms[0].strPOHiddenValue.value).split("^");
	                        
	          
	            document.getElementById("divPurchaseRefrenceNoId").innerHTML = poArr[12];   
	            //document.getElementsByName("strDPurchaseSource")[0].value =poArr[10];
	            if(poArr[21] != null && poArr[21] != "null" && poArr[21].length > 0)
	            {	             	
	             	 document.getElementById("strNextPoDate").innerHTML = poArr[21];
                } 	 
                if(poArr[14] != null && poArr[14] != "0" && poArr[14].length > 0)
	            {	             	
	             	document.getElementById("strDTenderNo").innerHTML = poArr[14];
                } 
                else
                {
                	document.getElementById("strDTenderNo").innerHTML = "----";
                }       
	            
	            if(poArr[15] != null && poArr[15] != "0" && poArr[15].length > 0)
	            {	             	
	             	document.getElementById("strDTenderDate").innerHTML = poArr[15];
                } 
                else
                {
                	document.getElementById("strDTenderDate").innerHTML = "----";
                } 
                
                if(poArr[16] != null && poArr[16] != "0" && poArr[16].length > 0)
	            {	             	
	             	document.getElementById("strDQuotationNo").innerHTML = poArr[16];
                } 
                else
                {
                	document.getElementById("strDQuotationNo").innerHTML = "----";
                } 
	            	            
	            if(poArr[17] != null && poArr[17] != "null" && poArr[17].length > 0)
	            {	            	
	            	document.getElementById("strDQuotationDate").innerHTML = poArr[17];
	            }
	            else
	            {
	            	document.getElementById("strDQuotationDate").innerHTML = "----";
	            }	
	            
	            if(poArr[22] != null && poArr[22] != "null" && poArr[22].length > 0)	
	            {	            	
	            	document.getElementById("strPurchaseCommitteMeetingDate").innerHTML = poArr[22];
	            }
	            else
	            {
	            	document.getElementById("strPurchaseCommitteMeetingDate").innerHTML = "----";
	            }	
	            
	            if(((document.forms[0].strPOItemID.value).split('@')[8]).split("^")[1] == "0")
	            	 document.getElementById("contractedDeliveryDaysId").innerHTML = "-";             
	            else
	            	 document.getElementById("contractedDeliveryDaysId").innerHTML = ((document.forms[0].strPOItemID.value).split('@')[8]).split("^")[1];	
	            	 totalContractedQty = ((document.forms[0].strPOItemID.value).split('@')[8]).split("^")[1];

	            
	            document.getElementById("poRateDivId").style.display="block";
	            document.getElementById("divPurchaseDetails").style.display="block";
	            document.forms[0].strPOItemID.disabled = true;       
	                        
	            getComponentDetails("3");
	}
	   
}

//to calculate total order qty
function calculateTotalQty()
{
    var   totQty = 0;
    var   totItemLen = document.getElementsByName("strQrderQty").length;
	var   itemQty = document.getElementsByName("strQrderQty");
		
	for(var i = 0;i<totItemLen;i++)
	{
	   if(itemQty[i].value.length > 0)
	   		totQty = totQty +  parseInt(itemQty[i].value,10);
	}
	
	document.getElementById("totalOrderQtyDiv").innerHTML = "<b>" + totQty + "</b>";
	document.forms[0].strTotalQrderQty.value = totQty;
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



function getPOTypeValues()
{
	document.forms[0].strPOTypeId.value    = document.forms[0].strComboPOTypeId.value.split("^")[0];
	document.forms[0].strPOGrantType.value = document.forms[0].strComboPOTypeId.value.split("^")[1];
	
	if(document.forms[0].strComboPOTypeId.value!="0")
	{		
		var        hmode = "GETSUPPLIERVALUES"; 
		var          url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strContractType="+document.forms[0].strComboPOTypeId.value.split("^")[0]+"&strItemCat=10";		
		
		
		ajaxFunction(url,"1");
	}
	else
	{
		document.getElementById("divSupplier").innerHTML="<select name='strSupplierId'><option value='0'>Select Value</option></select>";
	}
}

function getPOTypeComboValues()
{	
	if(document.forms[0].strComboPOTypeId.value.split("^")[0]!='21')
	{
	 var hmode = "GETPOTYPEVALUES"; 
	 var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strItemCat=10&strStoreId="+document.forms[0].strStoreId.value;
	 ajaxFunction(url,"6");
	}
	else
	{
		getNameFromDrugBrandMst();
	}
}

//for component Detail(s)
function getComponentDetails(mode)
{
	
			var hmode = "GETMODIFYCOMPONENT";
		    var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+
		    "&strPOTypeId="+document.forms[0].strComboPOTypeId.value+"&strItemCat=10"+"&strMode=3"+
		    "&strPONo="+document.forms[0].strPOHiddenValue.value.split("^")[11]
		    +"&strPOStoreId="+document.forms[0].strStoreId.value;	
		    
	   	    ajaxFunction(url,"7");
	
}
function getModifyComponentDetails()
{
	var hmode = "GETCOMPONENTDETAILS";
	var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strPOTypeId="+document.forms[0].strComboPOTypeId.value+"&strItemCat=10";
	ajaxFunction(url,"4");
}

function setRateContractValues()
{
	if((document.forms[0].strComboPOTypeId.value).split("^")[1] == '2')
	{
		if(document.forms[0].strSupplierId.value == "1")
			(document.getElementById("supplierName")).style.display="block";		
		else
			(document.getElementById("supplierName")).style.display="none";	
	}
	else
	{
		(document.getElementById("supplierName")).style.display="none";
	}	
	
}


var setScrollTable = function()
{	    
		
	    $('#mask').css('display', 'block');
		$('#dvLoading').css('display', 'block');			    
		
	    var divHeight = 250;
		var initialHeight = 716;
		var heightPer = (divHeight * 100) / initialHeight;
		var newHeight = parseInt((window.innerHeight * heightPer) / 100, 10);
 		//alert(newHeight);
 		
 		setTimeout(function (){
            
            $('#indentItemList').headerFixed({
		    tableHeight        : newHeight,
		    wrapperDivId       : 'wrapper',
		    mainTableRptId	   : 'mainTableRptId',
		    tableHeaderId      : 'tableHeaderId'			    		    
            
		});

         }, 800); // how long do you want the delay to be? 
				 	  	  
	  	var tblObj = document.getElementById("mstTable");
		tblObj.width = document.getElementsByName("mstTableWidthVal")[0].value + "%";		
		
		$('#mask').css('display', 'none');
		$('#dvLoading').css('display', 'none');	
		
				
		var   totQty1 = 0;
		var   totQty2 = 0;
		var   totQty3 = 0;
		var   totQty4 = 0;
		var   totQty5 = 0;
		var   totQty6 = 0;
		var   totQty7 = 0;
		var   totQty8 = 0;
	    var   totItemLen = document.getElementsByName("strRowSum").length;
		var   itemQty = document.getElementsByName("strRowSum");
	   	    		
		for(var i = 0;i<totItemLen;i++)
		{
		  
		   if(itemQty[i].value.split(",")[0].trim().length > 0)
		   {
		   		totQty1 = totQty1 +  parseInt(itemQty[i].value.split(",")[0].trim(),10);
		   }	
		   if(itemQty[i].value.split(",")[1].trim().length > 0)
		   {
		   		totQty2 = totQty2 +  parseInt(itemQty[i].value.split(",")[1].trim(),10);
		   }	
		   if(itemQty[i].value.split(",")[2].trim().length > 0)
		   {
		   		totQty3 = totQty3 +  parseInt(itemQty[i].value.split(",")[2].trim(),10);
		   }	
		   if(itemQty[i].value.split(",")[3].trim().length > 0)
		   {
		   		totQty4 = totQty4 +  parseInt(itemQty[i].value.split(",")[3].trim(),10);
		   }
		   if(itemQty[i].value.split(",")[4].trim().length > 0)
		   {
		   		totQty5 = totQty5 +  parseInt(itemQty[i].value.split(",")[4].trim(),10);
		   }
		   if(itemQty[i].value.split(",")[5].trim().length > 0)
		   {
		   		totQty6 = totQty6 +  parseInt(itemQty[i].value.split(",")[5].trim(),10);
		   }
		   if(itemQty[i].value.split(",")[6].trim().length > 0)
		   {
		   		totQty7 = totQty7 +  parseInt(itemQty[i].value.split(",")[6].trim(),10);
		   }
		   if(itemQty[i].value.split(",")[7].trim().length > 0)
		   {
		   		totQty8 = totQty8 +  parseInt(itemQty[i].value.split(",")[7].trim(),10);
		   }
		}
				
	  var previousTotal =   "<table width='100%' style='border:none;margin:auto;'><tbody><tr align='right'>" +
                            "<td width='25%' style='border-left:0px;border-bottom:0px;border-right:1px solid black;cursor:pointer;text-align:right;' title='Sch I Total Order Qty.'>"+totQty1+"</td>" +
           	 		        "<td width='25%' style='border-left:0px;border-bottom:0px;border-right:1px solid black;cursor:pointer;text-align:right;' title='Sch II Total Order Qty.'>"+totQty2+"</td>" +
           	 		        "<td width='25%' style='border-left:0px;border-bottom:0px;border-right:1px solid black;cursor:pointer;text-align:right;' title='Sch III Total Order Qty.'>"+totQty3+"</td>" +
           	 		        "<td width='25%' style='border-left:0px;border-bottom:0px;border-right:1px solid black;cursor:pointer;text-align:right;' title='Sch IV Total Order Qty.'>"+totQty4+"</td>" +
           	 		        "<td width='25%' style='border-left:0px;border-bottom:0px;border-right:1px solid black;cursor:pointer;text-align:right;' title='Sch V Total Order Qty.'>"+totQty5+"</td>" +
           	 		        "<td width='25%' style='border-left:0px;border-bottom:0px;border-right:1px solid black;cursor:pointer;text-align:right;' title='Sch VI Total Order Qty.'>"+totQty6+"</td>" +
           	 		        "<td width='25%' style='border-left:0px;border-bottom:0px;border-right:1px solid black;cursor:pointer;text-align:right;' title='Sch VII Total Order Qty.'>"+totQty7+"</td>" +
           	 		        "<td width='25%' style='border-left:0px;border-bottom:0px;border-right:1px solid black;cursor:pointer;text-align:right;' title='Sch VIII Total Order Qty.'>"+totQty8+"</td></tr></tbody></table>";		
				
		document.getElementById("grandTotal1").innerHTML= totQty1;
		document.getElementById("grandTotal2").innerHTML= totQty2;
		document.getElementById("grandTotal3").innerHTML= totQty3;
		document.getElementById("grandTotal4").innerHTML= totQty4;
		document.getElementById("grandTotal5").innerHTML= totQty5;
		document.getElementById("grandTotal6").innerHTML= totQty6;
		document.getElementById("grandTotal7").innerHTML= totQty7;
		document.getElementById("grandTotal8").innerHTML= totQty8;
		
	  
	
};




//on click of go button
function putDaynamicDiv(mode,viewMode)
{
	 
	// Call In Case of Supplier Interface Desk
	if(mode=='4')
	{
		   
			    /** ******************************************************************************************************/
				//   (0) PO_DATE ^ (1)SUPP NAME ^ (2)PO TYPE ^ (3)PO NET AMOUNT ^(4) Supplier ID
				// ^ (5) PO Type Id ^(6) Currency Id ^(7)Currency Value ^(8) Item Catg No
				// ^ (9) Catg Name ^ (10)Purchase Source ID ^ (11)Po Number ^ (12)PO Prefix ^(13) Tax
				// ^ (14)Tender Number ^ (15)Tender Date ^ (16)Qutation No ^ (17)Qutation Date ^(18) Verify Date
				// ^ (19)Verify BY ^ (20) Financial Period(2013-2014) ^ (21) Next PO Date ^ (22) Purchase Commite date 
				// ^ (23)Negotiation Meeting Date ^ (24)Remarks ^ (25) Verified By Name ^(26)Verify Date ^ (27) Total Amendment 
				// ^ (28)Rate Contracted Flg ^(29)PO Type Authantication ID^(30) POREF NO 
				// ^ (31)PO Prefix ^ (32) Store Name{PO Creater} ^ (33) Purchae Source Name ^ (34) Rate Contract Id
				/********************************************************************************************************/
				//   10100524@10000524@1013379@70@630106^1^0@0@70@1@0^0@Bottle@Abbott Healthcare Pvt. Ltd.@ Rate Unit Name
				/********************************************************************************************************/
	         
	            var divPOTypeId = document.getElementById("rateDivID");	           
              divPOTypeId.innerHTML =(document.forms[0].strPOItemID.value).split('@')[2]+" "+(document.forms[0].strPOItemID.value).split('@')[8];
	          
	                    	                
              document.getElementById("strItemRateTax").innerHTML = (document.forms[0].strPOItemID.value).split('@')[5];           
              //document.getElementsByName("strItemManufacturerId")[0].value = (document.forms[0].strPOItemID.value).split('@')[2];  
              document.getElementById("strItemRateAddTax").innerHTML = (document.forms[0].strPOItemID.value).split('@')[9];  
              document.getElementById("strItemTotalRate").innerHTML = roundValue((document.forms[0].strPOItemID.value).split('@')[6],2) +" / "+ (document.forms[0].strPOItemID.value).split('@')[8] ;
	          document.getElementById("itemOrderQty").innerHTML = ""+(document.forms[0].strPOItemID.value).split('@')[7]+" ";



	           poArr = (document.forms[0].strPOHiddenValue.value).split("^");
	          
	           document.getElementById("totalPOCost").innerHTML =  poArr[3];
	           document.forms[0].strTotalPOCost.value = poArr[3];
	                        
	          
	            document.getElementById("divPurchaseRefrenceNoId").innerHTML =      poArr[12]+" ("+poArr[11]+" )";  
	            
	             
	            document.getElementById("contractedDeliveryDaysId").innerHTML = poArr[40];
	            document.getElementById("divPurchaseSource").innerHTML =      poArr[32];   
	            
	           //document.getElementsByName("strDPurchaseSource")[0].value =poArr[10];
	            if(poArr[21] != null && poArr[21] != "null" && poArr[21].length > 0)
	            {	             	
	             	 document.getElementById("strNextPoDate").innerHTML = poArr[21];
                } 
                else
                {
                	document.getElementById("strNextPoDate").innerHTML = "----";
                }	 
                
                if(poArr[14] != null && poArr[14] != "0" && poArr[14].length > 0)
	            {	             	
	             	document.getElementById("strDTenderNo").innerHTML = poArr[14];
                } 
                else
                {
                	document.getElementById("strDTenderNo").innerHTML = "----";
                }       
	            
	            if(poArr[15] != null && poArr[15] != "0" && poArr[15].length > 0)
	            {	             	
	             	document.getElementById("strDTenderDate").innerHTML = poArr[15];
                } 
                else
                {
                	document.getElementById("strDTenderDate").innerHTML = "----";
                } 
                
                if(poArr[16] != null && poArr[16] != "0" && poArr[16].length > 0)
	            {	             	
	             	document.getElementById("strDQuotationNo").innerHTML = poArr[16];
                } 
                else
                {
                	document.getElementById("strDQuotationNo").innerHTML = "----";
                } 
	            	            
	            if(poArr[17] != null && poArr[17] != "null" && poArr[17].length > 0)
	            {	            	
	            	document.getElementById("strDQuotationDate").innerHTML = poArr[17];
	            }
	            else
	            {
	            	document.getElementById("strDQuotationDate").innerHTML = "----";
	            }	
	            
	            if(poArr[22] != null && poArr[22] != "null" && poArr[22].length > 0)	
	            {	            	
	            	document.getElementById("strPurchaseCommitteMeetingDate").innerHTML = poArr[22];
	            }
	            else
	            {
	            	document.getElementById("strPurchaseCommitteMeetingDate").innerHTML = "----";
	            }	
	            
	           // if(((document.forms[0].strPOItemID.value).split('@')[8]).split("^")[1] == "0")
	            	// document.getElementById("contractedDeliveryDaysId").innerHTML = "-";             
	          //  else
	           // 	 document.getElementById("contractedDeliveryDaysId").innerHTML = ((document.forms[0].strPOItemID.value).split('@')[8]).split("^")[1];	
	           // 	 totalContractedQty = ((document.forms[0].strPOItemID.value).split('@')[8]).split("^")[1];

	            
	            document.getElementById("poRateDivId").style.display="block";
	            document.getElementById("divPurchaseDetails").style.display="block";
	         
	                        
	            getComponentDetails("3");
			
	       
		
	}
	if(mode=='5')
	{
		   if(document.forms[0].strPOItemID.value != '0')
	       {
			   /** ******************************************************************************************************/
				//   (0) PO_DATE ^ (1)SUPP NAME ^ (2)PO TYPE ^ (3)PO NET AMOUNT ^(4) Supplier ID
				// ^ (5) PO Type Id ^(6) Currency Id ^(7)Currency Value ^(8) Item Catg No
				// ^ (9) Catg Name ^ (10)Purchase Source ID ^ (11)Po Number ^ (12)PO Prefix ^(13) Tax
				// ^ (14)Tender Number ^ (15)Tender Date ^ (16)Qutation No ^ (17)Qutation Date ^(18) Verify Date
				// ^ (19)Verify BY ^ (20) Financial Period(2013-2014) ^ (21) Next PO Date ^ (22) Purchase Commite date 
				// ^ (23)Negotiation Meeting Date ^ (24)Remarks ^ (25) Verified By Name ^(26)Verify Date ^ (27) Total Amendment 
				// ^ (28)Rate Contracted Flg ^(29)PO Type Authantication ID^(30) POREF NO 
				// ^ (31)PO Prefix ^ (32) Store Name{PO Creater} ^ (33) Purchae Source Name ^ (34) Rate Contract Id
				/********************************************************************************************************/
				//   10101065@10000647@1.0000@630001@1.000@10.00@1.1000000000000000@No@No
				/*
				HSTNUM_ITEMBRAND_ID || '@' || HSTNUM_ITEM_ID || '@' || 
			    HSTNUM_RATE || '@' || HSTNUM_RATE_UNITID || '@' ||
			    MMS_MST.getUnitBaseValue(HSTNUM_RATE_UNITID,GNUM_HOSPITAL_CODE) || '@' || 
			    NVL(HSTNUM_ITEM_TAX,0) || '@' ||
			    (HSTNUM_RATE * (100 + NVL(HSTNUM_ITEM_TAX,0)))/100 ||'@'||    
			    MMS_MST.GETUNITNAME(A.GNUM_HOSPITAL_CODE,A.HSTNUM_DEFAULT_UNITID) || '@' ||
			    MMS_MST.GETUNITNAME(GNUM_HOSPITAL_CODE,HSTNUM_RATE_UNITID) AS ITEM_ID
				*/
				/********************************************************************************************************/
	           
	          var divPOTypeId = document.getElementById("rateDivID");	           
              divPOTypeId.innerHTML =(document.forms[0].strPOItemID.value).split('@')[2]+" "+(document.forms[0].strPOItemID.value).split('@')[8];
	          
	                    	                
              document.getElementById("strItemRateTax").innerHTML = (document.forms[0].strPOItemID.value).split('@')[5];           
              //document.getElementsByName("strItemManufacturerId")[0].value = (document.forms[0].strPOItemID.value).split('@')[2];  
             
              document.getElementById("strItemTotalRate").innerHTML = roundValue((document.forms[0].strPOItemID.value).split('@')[6],2) +" / "+ (document.forms[0].strPOItemID.value).split('@')[8] ;
	          document.getElementById("itemOrderQty").innerHTML = ""+(document.forms[0].strPOItemID.value).split('@')[7]+" ";
	          
	         
	            
	           poArr = (document.forms[0].strPOHiddenValue.value).split("^");
	          
	           document.getElementById("totalPOCost").innerHTML =  poArr[3];
	           document.forms[0].strTotalPOCost.value = poArr[3];
	                        	            
	            
	            if(((document.forms[0].strPOItemID.value).split('@')[8]).split("^")[1] == "0")
	            	 document.getElementById("contractedDeliveryDaysId").innerHTML = "-";             
	            else
	            	 document.getElementById("contractedDeliveryDaysId").innerHTML = ((document.forms[0].strPOItemID.value).split('@')[8]).split("^")[1];	
	            	 totalContractedQty = ((document.forms[0].strPOItemID.value).split('@')[8]).split("^")[1];

	            
	            document.getElementById("poRateDivId").style.display="block";
	            
	          
	           
	            getLocationWiseProgrammeDtls(viewMode);
	         
	       }               
	       else
		   {
				alert("Please Select Item Name!!");
				return false;
	       }    
			
	       
		
	}
	
	
	
}
function getLocationWiseProgrammeDtls(viewMode) 
{	 		
	
        /** ******************************************************************************************************/
		//   (0) PO_DATE ^ (1)SUPP NAME ^ (2)PO TYPE ^ (3)PO NET AMOUNT ^(4) Supplier ID
		// ^ (5) PO Type Id ^(6) Currency Id ^(7)Currency Value ^(8) Item Catg No
		// ^ (9) Catg Name ^ (10)Purchase Source ID ^ (11)Po Number ^ (12)PO Prefix ^(13) Tax
		// ^ (14)Tender Number ^ (15)Tender Date ^ (16)Qutation No ^ (17)Qutation Date ^(18) Verify Date
		// ^ (19)Verify BY ^ (20) Financial Period(2013-2014) ^ (21) Next PO Date ^ (22) Purchase Commite date 
		// ^ (23)Negotiation Meeting Date ^ (24)Remarks ^ (25) Verified By Name ^(26)Verify Date ^ (27) Total Amendment 
		// ^ (28)Rate Contracted Flg ^(29)PO Type Authantication ID^(30) POREF NO 
		// ^ (31)PO Prefix ^ (32) Store Name{PO Creater} ^ (33) Purchae Source Name ^ (34) Rate Contract Id
		/********************************************************************************************************/
		//   10100524@10000524@1013379@70@630106^1^0@0@70@1@0^0@Bottle@Abbott Healthcare Pvt. Ltd.@ Rate Unit Name
		/********************************************************************************************************/
	     var itemStockObj = document.getElementById("indentItemList");      
		itemStockObj.innerHTML = "";	      
		
		 var mode = "LocationWiseProgrammeDtls";			 
		 var strPOHiddenValue = document.getElementsByName("strPOHiddenValue")[0].value;	
		 var strPOItemId      = document.forms[0].strPOItemID.value;	  
		 var url = "SupplierDeskInterfaceTransCNT.cnt?hmode="+mode+"&strPOHiddenValue="+strPOHiddenValue+
		 "&strPOItemId="+(strPOItemId.split("@")[0]+"@"+strPOItemId.split("@")[1])+"&strStoreId="+document.forms[0].strStoreId.value+"&strViewMode="+viewMode;
		 ajaxFunction(url, "17");
	
		
}	


function checkInvoice()
{
	
	//alert("hemant");
     var flag = 0;
    var previousDtl = document.forms[0].strPrevInvoiceExists.value;
    var strSupplierInvoiceNo = document.forms[0].strSupplierInvoiceNo.value;
	

		//alert('previousDtl::::::::::'+previousDtl);
	//	alert('strSupplierInvoiceNo::::::'+strSupplierInvoiceNo);
		

		
			if(!previousDtl=="0") 
	{
				var len = previousDtl.split('^').length;
				//alert(len);
				for (i = 0 ; i < len ;i++)
					{
					{						
						if(strSupplierInvoiceNo == previousDtl.split("^")[i])
						{
							alert("Combination of this Invoive No, Po No. and Warehouse Name already exists!!");
							document.forms[0].strSupplierInvoiceNo.value ="";
							return false;
						}	
											
					}
					}

	}	
}
	 
	 



function getScheduleNoCmb(obj) 

{	 
	document.forms[0].strSupplierInvoiceNo.value = "";
	
	if( (document.getElementsByName("strReplacementDirectBatchFlag")[0].checked || 
			document.getElementsByName("strReplacementDirectBatchFlag")[1].checked || 
			document.getElementsByName("strReplacementDirectBatchFlag")[2].checked ))
		{
	if(obj.value != '0')
	{
		/** ******************************************************************************* */
			//   (0) PO_DATE ^ (1)SUPP NAME ^ (2)PO TYPE ^ (3)PO NET AMOUNT ^(4) Supplier ID
			// ^ (5) PO Type Id ^(6) Currency Id ^(7)Currency Value ^(8) Item Catg No
			// ^ (9) Catg Name ^ (10)Purchase Source ID ^ (11)Po Number ^ (12)PO Prefix ^(13) Tax
			// ^ (14)Tender Number ^ (15)Tender Date ^ (16)Qutation No ^ (17)Qutation Date ^(18) Verify Date
			// ^ (19)Verify BY ^ (20) Financial Period(2013-2014) ^ (21) Next PO Date ^ (22) Purchase Commite date 
			// ^ (23)Negotiation Meeting Date ^ (24)Remarks ^ (25) Verified By Name ^(26)Verify Date ^ (27) Total Amendment 
			// ^ (28)Rate Contracted Flg ^(29)PO Type Authantication ID^(30) POREF NO 
			// ^ (31)PO Prefix ^ (32) Store Name{PO Creater} ^ (33) Purchae Source Name ^ (34) Rate Contract Id
			/** ******************************************************************************* */
			
		 var mode = "SCHEDULECOMBO";			 
		 var strPOHiddenValue = document.getElementsByName("strPOHiddenValue")[0].value.split("^");		  
		 var url = "SupplierDeskInterfaceTransCNT.cnt?hmode="+mode+"&strPoNo="+strPOHiddenValue[11]+
		 "&strPoStoreId="+document.forms[0].strPOStoreId.value+
		 "&strDeliveryStorId="+obj.value.split("^")[0]+"&strPoTypeId="+strPOHiddenValue[5]+"&strReplacementDirectBatchFlag="+document.forms[0].strReplacementDirectBatchFlag.value;
		
		 ajaxFunction(url, "1");
	}
	else
	{
		document.getElementById("schedulCmbId").innerHTML = "<select name='strScheduleNo' class='comboNormal' onChange='getDrugNameCombo();'><option value='0'>Select</option></select>";
			
	}	
		}

		else 
		{
		alert("Select Batch Type First!!!!!");
		document.getElementById("strDeliveryStoreId").value = "0";
		}
}	
function getDrugNameCombo(obj) 
{	 		
	var strReplacementDirectBatchFlag = document.forms[0].strReplacementDirectBatchFlag.value
 	if( document.getElementsByName("strReplacementDirectBatchFlag")[0].checked || 
			document.getElementsByName("strReplacementDirectBatchFlag")[1].checked )
		{
			document.getElementById("RejectedBatchList").style.display="block";
		}
	document.getElementsByName("strReplacementDirectBatchFlag")[0].disabled = false;
	document.getElementsByName("strReplacementDirectBatchFlag")[1].disabled = false;
	document.getElementsByName("strReplacementDirectBatchFlag")[2].disabled = false;
	if(obj.value != '0')
	{
		/** ******************************************************************************* */
			//   (0) PO_DATE ^ (1)SUPP NAME ^ (2)PO TYPE ^ (3)PO NET AMOUNT ^(4) Supplier ID
			// ^ (5) PO Type Id ^(6) Currency Id ^(7)Currency Value ^(8) Item Catg No
			// ^ (9) Catg Name ^ (10)Purchase Source ID ^ (11)Po Number ^ (12)PO Prefix ^(13) Tax
			// ^ (14)Tender Number ^ (15)Tender Date ^ (16)Qutation No ^ (17)Qutation Date ^(18) Verify Date
			// ^ (19)Verify BY ^ (20) Financial Period(2013-2014) ^ (21) Next PO Date ^ (22) Purchase Commite date 
			// ^ (23)Negotiation Meeting Date ^ (24)Remarks ^ (25) Verified By Name ^(26)Verify Date ^ (27) Total Amendment 
			// ^ (28)Rate Contracted Flg ^(29)PO Type Authantication ID^(30) POREF NO 
			// ^ (31)PO Prefix ^ (32) Store Name{PO Creater} ^ (33) Purchae Source Name ^ (34) Rate Contract Id
			/** ******************************************************************************* */
			
		 var mode = "DRUGCOMBO";			 
		 var strPOHiddenValue = document.getElementsByName("strPOHiddenValue")[0].value.split("^");		  
		 var url = "SupplierDeskInterfaceTransCNT.cnt?hmode="+mode+"&strPoNo="+strPOHiddenValue[11]+
		 "&strPoStoreId="+document.forms[0].strPOStoreId.value+
		 "&strDeliveryStorId="+document.forms[0].strDeliveryStoreId.value+"&strPoTypeId="+strPOHiddenValue[5]+"&strShcheduleNo="+obj.value.split("^")[0]+
		 "&strReplacementDirectBatchFlag="+strReplacementDirectBatchFlag;
		 
		 document.getElementById("deliveryDateId").innerHTML =obj.value.split("^")[1];
		 ajaxFunction(url, "2");
	}
	else
	{
		document.getElementById("drugComboDivId").innerHTML = "<select name='strDrugBrandId' class='comboMax' onChange='getDrugNameCombo();'><option value='0'>Select</option></select>";
		document.getElementById("deliveryDateId").innerHTML ="";
			
	}	
}	

function getItemDetails(obj) 
{
		if (document.forms[0].strDrugBrandId.value != "0") 
		{
			
			//alert('check::::'+document.getElementsByName("strPOHiddenValue")[0].value);
			 var strPOHiddenValue = document.getElementsByName("strPOHiddenValue")[0].value.split("^");		
			 
			 
			// alert('check::212::'+document.getElementsByName("strChk")[0].value);
			 
			 
			// alert('check::22::'+document.getElementsByName("strChk")[0].value.split("@")[6]);
			 
			 
			var strPoPreFlag = document.getElementsByName("strChk")[0].value.split("@")[6];
			
			var mode = "GETITEMDTLHLP";
			var url = "SupplierDeskInterfaceTransCNT.cnt?hmode=" + mode + "&strPoNo="
					+ strPOHiddenValue[11] + "&strPoStoreId="
					+ document.forms[0].strPOStoreId.value + "&strReceiveDate=0&strDeliveryStorId="
					+ document.forms[0].strDeliveryStoreId.value + "&strPoTypeId="
					+ strPOHiddenValue[5] + "&strScheduleNo="
					+ document.forms[0].strScheduleNo.value.split("^")[0]
					+ "&strItemBrandId="
					+ document.forms[0].strDrugBrandId.value.split("^")[1]
					+ "&strItemId="+document.forms[0].strDrugBrandId.value.split("^")[0]
					+ "&strPoPreFlag="+document.forms[0].strScheduleNo.value.split("^")[2]
					+ "&strReplacementDirectBatchFlag="+ document.forms[0].strReplacementDirectBatchFlag.value
					+"&strBatchExdateFlag="+document.forms[0].strBatchExdateFlag.value;

			document.forms[0].strScheduleNo.disabled = true;
			document.forms[0].strDeliveryStoreId.disabled = true;
			//document.getElementById("mfgNameId").innerHTML = document.forms[0].strDrugBrandId.value.split("^")[2];
         
			ajaxFunction(url, "10");
		} 
		else 
		{
	        document.forms[0].strScheduleNo.disabled = false;
			document.forms[0].strDeliveryStoreId.disabled = false;
			var retMsg = confirm("Batch Detail(s) will be reset !! \n\nAre You Sure?");

			if (retMsg) 
			{
				var objVal = document.getElementById("indentItemList");
				objVal.innerHTML = "";

				var tblObj = document.getElementById("mstTable");
				tblObj.width = "95%";

				var objVal = document.getElementById("challanmultirow");
				objVal.innerHTML = "";
				document.forms[0].strProgrammeSize.value = "0";
				// var divPOTypeId = document.getElementById("unitComboId");
				// divPOTypeId.innerHTML = "<select name='strUnitCombo'
				// class='comboNormal' ><option value='0'>Select
				// Value</option></select>";

				document.getElementById("strRemarksDivId").style.display = "none";
				document.getElementById("manualItemDtlsDivId").style.display = "none";
				document.getElementById("scannedDtlsDivId").style.display = "none";
				// document.getElementById("mfgNameId").innerHTML = "";

				resetMultiRow("1");
			}

		}
	

}
function openPopUp(index) // Partial Receipt Pop-Up 
{	   
	         // HSTNUM_PO_NO||''^''||HSTNUM_SCHEDULE_NO||''^''|| HSTNUM_STORE_ID||''^''|| HSTNUM_DELIVERY_NO ||''^''|| HSTNUM_PO_STORE_ID
	         
	   		    var url = "SupplierDeskInterfaceTransCNT.cnt?hmode=VIEWDELIVERYDTLS&strPKey="+ document.getElementById("strCheckHidValue"+index).value+"&strConsignee="+document.getElementById("strConsignee"+index).value;
				ajaxFunction(url, "15");   
	
} 
function deleteRecord(mode,index) // Partial Receipt Pop-Up 
{
	if(mode=="1")
	{
	     var res = prompt("Please Enter Remarks For Deletion!","");
         if(!res=="")
         {
	           var conf = confirm("You Are Going To Delete  [ "  + document.getElementById("strConsignee"+index).value +"  ] Records" );
	           if(confirm(" Are You Sure ?"))
			   {
	                        // HSTNUM_PO_NO||''^''||HSTNUM_SCHEDULE_NO||''^''|| HSTNUM_STORE_ID||''^''|| HSTNUM_DELIVERY_NO ||''^''|| HSTNUM_PO_STORE_ID
	   				 var url = "SupplierDeskInterfaceTransCNT.cnt?hmode=DELETEDETAILS&strPKey="+ document.getElementById("strCheckHidValue"+index).value+"&strDeleteRemarks="+ res;
					 ajaxFunction(url, "16");  
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
	            alert("Please Enter remarks for Deletion");
	           } 
          }   
	}
	else
	{
		alert("Activity Not Allowed!!");
		return false;
	}

} 


function getAjaxResponse(res,mode)
{
	if(res.split("####")[0] == "ERROR")
	{
		document.getElementById("errMsg").innerHTML=res.split("####")[1];
	} 
	else 
	if(mode == '1')
	{
		var itemParaObj = document.getElementById("schedulCmbId");
		itemParaObj.innerHTML = "<select name='strScheduleNo' class='comboNormal' onChange='getDrugNameCombo(this);'>"+res.split("#")[0]+"</select>";
		//itemParaObj.innerHTML = "<select name='strPrevInvoiceExists' class='comboNormal' onChange='getDrugNameCombo(this);'>"+res.split("#")[1]+"</select>";
	
	//	alert(res.split("#")[1]);
		document.getElementById("strPrevInvoiceExists").value  =  res.split("#")[1];
		
		document.getElementsByName("strReplacementDirectBatchFlag")[0].disabled = true;
		document.getElementsByName("strReplacementDirectBatchFlag")[1].disabled = true;
		document.getElementsByName("strReplacementDirectBatchFlag")[2].disabled = true;
	} 
	else 
	if(mode == '2')
	{		
		var itemParaObj = document.getElementById("drugComboDivId");
		itemParaObj.innerHTML = "<select name='strDrugBrandId' class='comboMax' onChange='getItemDetails(this);'>"+res.split("#")[0]+"</select>";
		
		var itemParaObj1 = document.getElementById("leftbatchNoComboDivId");
		itemParaObj1.innerHTML = "<select name='strLeftBatchNos' id='strLeftBatchNos' size='6' multiple	size='6' multiple style='width: 280px'>"+res.split("#")[1]+"</select>";
		
		document.getElementsByName("strReplacementDirectBatchFlag")[0].disabled = true;
		document.getElementsByName("strReplacementDirectBatchFlag")[1].disabled = true;
		document.getElementsByName("strReplacementDirectBatchFlag")[2].disabled = true;
		
	} 
	else 
	if(mode == '3')
	{		
		
		var itemParaObj = document.getElementById("divRequestItemDetails");
		itemParaObj.innerHTML = res;
		
		//getComponentDetails();
	} 
	else if(mode == '4')
	{	   
		var itemParaObj = document.getElementById("divComponentDetails");		
		itemParaObj.innerHTML = res;	
		
		
	} 
	else if(mode == '5')
	{		
		
		var itemParaObj = document.getElementById("divPOItemDtl");
		itemParaObj.innerHTML ="<select id='strPOItemID' name='strPOItemID' class='comboMax' onChange='setItemOrderQty();'>"+res+"</select>";
		loadAutocompleteItems();
				
	}
	
	else if(mode == '6')
	{
		var divPOTypeId = document.getElementById("generateDynamicDiv");
	       divPOTypeId.style.display="none";
	        divPOTypeId.innerHTML ="";
		var divPOTypeId = document.getElementById("divPOTypeId");
		divPOTypeId.innerHTML = "<select name='strComboPOTypeId' class='comboMax' onChange='getNameFromDrugBrandMst();'>"+res+"</select>";
		
		//getPOItemList();
	}
	else if(mode == '7')
	{	   
		var itemParaObj = document.getElementById("divComponentDetails");		
		itemParaObj.innerHTML = res;	
		if(document.forms[0].strViewMode.value=='1')
		{
			var compLeng        = document.getElementsByName("strDComponentValue");
			var strChkComponent = document.getElementsByName("strChkComponent")
			for(var i=0;i<compLeng.length;i++)
			{
				compLeng[i].disabled = true;
				strChkComponent[i].disabled = true;
			}
		}
		
		

            setScrollTable();

		
		
	} 
	//response against go button
	else if(mode == '8')
	{			
	      document.getElementById('showbar').style.visibility = 'hidden';
	      document.getElementById('showbar').style.display = 'none';
          progress_stop();
          
	      var divPOTypeId1 = document.getElementById("generateDynamicDiv");
	      divPOTypeId1.style.display="block";
	      divPOTypeId1.innerHTML = res.split('$$$$')[0]; 
	      
	      var divPOTypeId = document.getElementById("poRateDivId");
          divPOTypeId.style.display="block";
          
          document.getElementById("imageDiv").style.display="none"; 
          
          document.getElementById("poRefDateDiv").innerHTML = document.getElementById("strPORefrenceDate").value;
          document.getElementById("poRefDateDiv").style.display="block";
          document.getElementById("poRefDateCalDiv").style.display="none";    
          
          var divPOTypeId = document.getElementById("rateDivID");
	      divPOTypeId.innerHTML ="<select name='strItemRateUnitId' onChange='resetDiv(1);' class='comboNormal'>"+res.split("$$$$")[1]+"</select>";
	      setValueItem(1);     
	}
	
	else 
	if (mode == '10') 
	{

       
		var mainTemp = res.split("$$@@$$");
        // mainTemp[0] ---> [ Multi Row Header  $$$$  Mst Table Width $$$$ MultiRow Content $$$$ 1 ] $$$$  Unit Combo 
		var temp1 = mainTemp[0].split("$$$$");
		var objVal = document.getElementById("indentItemList");
		objVal.innerHTML = temp1[0];

		var tblObj = document.getElementById("mstTable");
		tblObj.width = temp1[1] + "%";

		var objVal = document.getElementById("challanmultirow");
		objVal.innerHTML = temp1[2];
		document.forms[0].strProgrammeSize.value = temp1[3];
		
		document.getElementById("itemDtlDivId").style.display="block";
		
		var objVal = document.getElementById("rejectedBatchDivId");
		objVal.innerHTML = mainTemp[1];
		
		
		
		var divPOTypeId = document.getElementById("unitDivId");
		//alert(temp1[4]);
		divPOTypeId.innerHTML = "<select name='strUnitId' class='comboNormal' style='display:none' onChange='onChangeUnit(this);'>"	+ temp1[4] + "</select></td>"+"<td class='LABEL' >"+ temp1[4].split("</option>")[0]+"</td>";
		  //j
		  // document.forms[0].strManufacturerValues.disabled = true ;
		document.forms[0].strUnitId.disabled = true ;
		document.getElementById("cartonDiv").style.display="block";
		
	

 		
	}
	else if(mode == '12')
	{			
		  
	      document.getElementById('showbar').style.visibility = 'hidden';
	      document.getElementById('showbar').style.display = 'none';
          progress_stop();
          
	      var divPOTypeId1 = document.getElementById("generateDynamicDiv");
	          divPOTypeId1.style.display="block";
	          divPOTypeId1.innerHTML = res.split('$$$$')[0]; 
	      
	      var divPOTypeId = document.getElementById("poRateDivId");
	          divPOTypeId.style.display="block";
          
          document.getElementById("imageDiv").style.display="none";         
          
          var divPOTypeId = document.getElementById("rateDivID");
	      divPOTypeId.innerHTML ="<select name='strItemRateUnitId' onChange='resetDiv(1);' class='comboNormal'>"+res.split("$$$$")[2]+"</select>";
	      document.getElementById("totalPOCost").innerHTML = res.split("$$$$")[1];
	      document.forms[0].strTotalPOCost.value = res.split("$$$$")[1];
	      setValueItem(3);     
	}
	else if(mode == '13')
	{			
	       
	       document.getElementById('showbar').style.visibility = 'hidden';
	       document.getElementById('showbar').style.display = 'none';
	       progress_stop();
	      	      	     
		      //10100001#10000001#1010016#90#6301^1^0#10#99
		      //var divPOTypeId = document.getElementById("poRateDivId");
	          //divPOTypeId.style.display="block";		      
		      var divPOTypeId1 = document.getElementById("generateDynamicDiv");
		      divPOTypeId1.style.display="block";
		      divPOTypeId1.innerHTML = res.split('^^^')[0]; 
		      var divPOTypeId = document.getElementById("poRateDivId");
	          divPOTypeId.style.display="block";
	          document.getElementById("imageDiv").style.display="none";
	          
	          
	          
	          
	          
		      document.forms[0].strItemRate.disabled = false;
		      document.forms[0].strItemRate.value = document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].value.split("^")[2];
			  document.forms[0].strItemRateTax.disabled = false;
			  document.forms[0].strItemRate.readonly = false;
			  document.forms[0].strItemRateTax.readonly = false;
			  document.forms[0].strItemRateTax.value = document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].value.split("^")[4];
			  document.forms[0].strItemMake.readonly = false;
			  document.forms[0].strItemMake.disabled = false;
			  document.forms[0].strItemTotalRate.value = document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].value.split("^")[6];
			  
	         
	}
	else if(mode == '14')
	{					    
		//alert(res);
		 var itemParaObj = document.getElementById("divSupplier");
		 itemParaObj.innerHTML ="<select name='strSupplierId' class='comboMax'>"+res+"</select>";
		
	}
	else if(mode == '15')
	{				
         var itemStockObj = document.getElementById("issueDtlsDivId");      
		 itemStockObj.innerHTML = res;				
		 display_popup('toPopup');	 
		 
		 
	}
	else if(mode == '16')
	{			
	
        var itemStockObj = document.getElementById("phyStockVerifiedItemDtls");      
		itemStockObj.innerHTML = res;				
		itemStockObj.style.display="block";	
		var divHeight=200;
		var initialHeight=716;
		var heightPer = (divHeight*100)/initialHeight; 
		var newHeight = parseInt((window.innerHeight * heightPer)/100,10);	
	    fixedHeaderTableTransCustomize("phyStockVerifiedItemDtls",newHeight, "wrapper1","tableHeaderId1");
		 
	}
	else if(mode == '17')
	{			
	
        var itemStockObj = document.getElementById("indentItemList");      
		itemStockObj.innerHTML = res;				
		setScrollTable();
		 
	}
	else if(mode == '18')
	{			
	
        var itemStockObj = document.getElementById("previousDeliveryDtls");      
		itemStockObj.innerHTML = res;				
		var divHeight=200;
		var initialHeight=516;
		var heightPer = (divHeight*100)/initialHeight; 
		var newHeight = parseInt((window.innerHeight * heightPer)/100,10);	
	    fixedHeaderTableTransCustomize("previousDeliveryDtls",121, "wrapper1","tableHeaderId1");
		 
	}
	
	if (mode == "19") 
	{

		var resDtls = res.split('#');

		if (resDtls[0] == 0) {
			alert("No Carton Details where Added");
			return false;

		}
		
         document.forms[0].strBarCodeString.value = res;
		 barCode(1);

	}
	
	
}

//hemant  var generateBarcode = function(cartonNo,batchNo,gtinNo,expDate,quantity) {

var generateBarcode = function(cartonNo) {	
	//alert('cartonNo:::::'+cartonNo);
	
	var value = cartonNo;
	var btype = "code128";
	// var btype = "datamatrix";
	var renderer = "css";

	var settings = {
		output : renderer,
		bgColor : '#FFFFFF',
		color : '#000000',
		barWidth : '2',
		barHeight : '50',
		moduleSize : '5',
		addQuietZone : '1',
		fontSize : '30'
	};

	
	//hemant $("#barcodeTarget" + cartonNo).html("").show().barcode('01'+gtinNo+'17'+expDate+'10'+batchNo, btype,settings);
	
	
	$("#barcodeTarget" + cartonNo).html("").show().barcode(value, btype,settings);
};

function PrintBarCode(index)
{
	
	var mode = "GETBARCODEDTLS";
	url = "SupplierDeskInterfaceTransCNT.cnt?hmode=" + mode + "&strPKey=" + document.getElementsByName("strCheckHidValue")[index].value;
	
	ajaxFunction(url, "19");
	
	 
	 
}

function generateVoucherPdf() 
{
		
	//document.forms[0].strLotNoNew.value = strIssueNo;
	generatePdfScrollVoucher("issueDtlsDivId", "mainTableId", "mainTableRptId2", "voucherDivId");
		
}

function barCode(mode) 
{

	document.getElementById("errMsg").innerHTML = "";
	document.getElementById("warningMsg").innerHTML = "";
 

    var barcodeDtls =  document.forms[0].strBarCodeString.value.split("#");
   // alert(document.forms[0].strBarCodeString.value);
  
    
    
   var genCartonNo = barcodeDtls[2];
	var genBatchNos = barcodeDtls[0];
	var genCartonSize = barcodeDtls[1];
    
	
	/*  hemant
	var genBatchNos = barcodeDtls[0];
	var genCartonSize = barcodeDtls[1];
	var genCartonNo = barcodeDtls[2];
	var genGtinNo =  barcodeDtls[3];
	var genExpiryDate = barcodeDtls[4];
	var genQuantity = barcodeDtls[5];*/
	 
    if(document.forms[0].strBarCodeString.value!='0')
	{
		if (genCartonNo.length > 0 && genCartonNo != 0) 
		{
	
			var genCartons = genCartonNo.split(',');
			var genBatch = genBatchNos.split(',');
			var genSize = genCartonSize.split(',');
			/* hemant

var genGtinNo = genGtinNo.split(',');
			var genExpiryDate = genExpiryDate.split(',');
			var genQuantity = genQuantity.split(',');*/
	        if(mode=='1')
	        {
					var voucherHtml = "<table border='0' width='650' align='center'>"
							+ " <tr> <td align='right'> "
							+ " <div id='printImg' class='hidecontrol' align='right'> "
							+ " <img style='cursor: pointer; ' title='Print Page'  src='../../hisglobal/images/printer_symbol.gif' onClick='printData();' /> "
							+ " <img style='cursor: pointer; ' title='Close'  src='../../hisglobal/images/cancel.png' onClick='closeBarCodePopup(1);' /> "
							+ "  </div> </td> </tr> <table> <div id='barCodeDetailsDivId'>"
							+ " <table border='0' width='700' align='center'> ";
			
					for ( var i = 0; i < genCartons.length; i++) {
			
						voucherHtml = voucherHtml + "  <tr> <td align='center'> "
								+ " <div >Batch No. : <b>" + genBatch[i]
								+ "</b>    |    Carton Size : <b>"
								+ genSize[i] + "</b>  </div> " + "<div id='barcodeTarget"
								+ genCartons[i] + "' class='barcodeTarget'></div>"
								+ " </td> </tr> ";
					}
			
					voucherHtml = voucherHtml + "  <tr><td align='center'></td></tr><tr><td align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>******</b></font></td></tr><table></div> ";
	        }
	        else
	        {

	        	    var voucherHtml = "<table border='0' width='650' align='center'>"
							+ " <tr> <td align='right'> "
							+ " <div id='printImg' class='hidecontrol' align='right'> "
							+ " <img style='cursor: pointer; ' title='Print Page'  src='../../hisglobal/images/printer_symbol.gif' onClick='printData();' /> "
							+ " <img style='cursor: pointer; ' title='Close'  src='../../hisglobal/images/cancel.png' onClick='closeBarCodePopup(2);' /> "
							+ " </div> </td> </tr>"
							+ " <tr><td align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif' ><b>Re-Print Bar Code for Challan No [ "+document.forms[0].strFormChk.value.split("@")[1]+" ]</b></font></td>"
			                + " </tr>"						 
							+ " <table> <div id='barCodeDetailsDivId'>"
							+ " <table border='0' width='700' align='center'> ";					
			       
					for ( var i = 0; i < genCartons.length; i++) 
					{
			
						voucherHtml = voucherHtml + "  <tr> <td align='center'> "
								+ " <div >Batch No. : <b>" + genBatch[i]
								+ "</b>    |    Carton Size : <b>"
								+ genSize[i] + "</b>  </div> " + "<div id='barcodeTarget"
								+ genCartons[i] + "' class='barcodeTarget'></div>"
								+ " </td> </tr> ";
					}				
					voucherHtml = voucherHtml + "  <tr><td align='center'></td></tr><tr><td align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>******</b></font></td></tr><table></div> ";
	        }
	  
	        document.forms[0].strBarCodeString.value = "0";
	       
	  
			document.getElementById("barcodeContent").innerHTML = voucherHtml;
	
			for ( var i = 0; i < genCartons.length; i++) {
	
				
				generateBarcode(genCartons[i]);
				
				// hemant  generateBarcode(genCartons[i],genBatch[i],genGtinNo[i],genExpiryDate[i],genQuantity[i]);
			}
	
			document.getElementById("barCodePopup").style.width = '1600px';
			document.getElementById("barcodeContent").style.width = '1500px';
			//document.getElementById("barcodeContent").style.height = '401px';
			//document.getElementById("barcodeContent").style.overflow = 'auto';
	
			$('#mask').css('display', 'block');
			$('#mask').fadeIn();
			display_popup_menu(document.getElementsByTagName("body")[0],
					"barCodePopup", "1", "1");
	
		}
		else
		{
			 var voucherHtml = "<table border='0' width='650' align='center'>"
							+ " <tr> <td align='right'> "
							+ " <div id='printImg' class='hidecontrol' align='right'> "							
							+ " <img style='cursor: pointer; ' title='Close'  src='../../hisglobal/images/cancel.png' onClick='closeBarCodePopup(2);' /> "
							+ " </div> </td> </tr>"
							+ " <tr><td align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif' ><b>( Bar Code Not Avaliable)</b></font></td>"
			                + " </tr>"						 
							+ " </table> ";				
			
					
					
	       
	  
			document.getElementById("barcodeContent").innerHTML = voucherHtml;
				
	
			document.getElementById("barCodePopup").style.width = '700px';
			document.getElementById("barcodeContent").style.width = '700px';
			document.getElementById("barcodeContent").style.height = '400px';
			document.getElementById("barcodeContent").style.overflow = 'auto';
	
			$('#mask').css('display', 'block');
			$('#mask').fadeIn();
			display_popup_menu(document.getElementsByTagName("body")[0],
					"barCodePopup", "400", "150");
		}
  }
  else
  {
  	 if(mode=='2')
  	 {
  	     var voucherHtml = "<table border='0' width='650' align='center'>"
							+ " <tr> <td align='right'> "
							+ " <div id='printImg' class='hidecontrol' align='right'> "							
							+ " <img style='cursor: pointer; ' title='Close'  src='../../hisglobal/images/cancel.png' onClick='closeBarCodePopup(2);' /> "
							+ " </div> </td> </tr>"
							+ " <tr><td align='center'><font size='3' face='Verdana, Arial, Helvetica, sans-serif' ><b>( Bar Code Not Avaliable)</b></font></td>"
			                + " </tr>"						 
							+ " </table> ";				
			
					
					
	       
	  
			document.getElementById("barcodeContent").innerHTML = voucherHtml;
				
	
			document.getElementById("barCodePopup").style.width = '700px';
			document.getElementById("barcodeContent").style.width = '700px';
			document.getElementById("barcodeContent").style.height = '400px';
			document.getElementById("barcodeContent").style.overflow = 'auto';
	
			$('#mask').css('display', 'block');
			$('#mask').fadeIn();
			display_popup_menu(document.getElementsByTagName("body")[0],
					"barCodePopup", "400", "150");
  	 }
  }

};

var resetBarcodeContent = function() {

	document.getElementById('barcodeContent').setAttribute("style", "");

};

var closeBarCodePopup = function(mode) 
{
	hideRackDetails('barCodePopup');

	$('#mask').css('display', 'none');
	$('#mask').fadeOut();

};

var hideRackDetails = function(id) {

	hide_popup_menu(id);
	$('#mask').css('display', 'none');
	$('#mask').fadeOut();

};

function cartonGene(val) 
{
	    var totRow = 0;
	    
	    for ( var j = 0; j < document.getElementsByName("strMultiRowCartonNo").length; j++) 
	    {	
			
			document.getElementsByName("strMultiRowCartonSize")[j].disabled=false;		
			
	    }	

	
		totRow = parseInt(document.getElementsByName("rowLength1")[0].value, 10);
		//alert("totRow-->>"+totRow);
		if (totRow > 0) 
		{	
			var retMsg = confirm("Batch Detail(s) will be reset !! \n\nAre You Sure?");
			if (retMsg) 
			{
				if (val == '1') 
				{			
					document.getElementsByName("strCartonGene")[0].value="1";
				} 
				else 
				{
					document.getElementsByName("strCartonGene")[0].value="2";
				}
				for ( var j = 0; j < document.getElementsByName("strMultiRowCartonNo").length; j++) 
			    {	
					
					document.getElementsByName("strMultiRowNoOfCarton")[j].disabled=false;	
					document.getElementsByName("strMultiRowCartonNo")[j].disabled=false;			
					
			    }
		        document.forms[0].noOfRows.value="";
				resetMultiRow("1");
			}
			else
			{
				return false;
			} 	
		}
		else
		{
			if (val == '1') 
			{			
				document.getElementsByName("strCartonGene")[0].value="1";
			} 
			else 
			{
				document.getElementsByName("strCartonGene")[0].value="2";
				for ( var j = 0; j < document.getElementsByName("strMultiRowCartonNo").length; j++) 
			    {	
					
					document.getElementsByName("strMultiRowNoOfCarton")[j].disabled=true;	
					document.getElementsByName("strMultiRowCartonNo")[j].disabled=false;				
					
			    }
			}						
			document.forms[0].noOfRows.value="";			
		}
}
function onChangeUnit(obj)
{
	    var totRow = 0;	   
		totRow = parseInt(document.getElementsByName("rowLength1")[0].value, 10);
		
		if (totRow > 0) 
		{	
            var retMsg = confirm("All Batch Detail(s) will be reset !! \n\nAre You Sure?");
			if (retMsg) 
			{
				 document.forms[0].noOfRows.value="";
				resetMultiRow("1");
				
			}
			
			
		}
		
		
}

function showDeliveryDtls(parentObj, index)
{
	
		/** ******************************************************************************* */
			//   (0) PO_DATE ^ (1)SUPP NAME ^ (2)PO TYPE ^ (3)PO NET AMOUNT ^(4) Supplier ID
			// ^ (5) PO Type Id ^(6) Currency Id ^(7)Currency Value ^(8) Item Catg No
			// ^ (9) Catg Name ^ (10)Purchase Source ID ^ (11)Po Number ^ (12)PO Prefix ^(13) Tax
			// ^ (14)Tender Number ^ (15)Tender Date ^ (16)Qutation No ^ (17)Qutation Date ^(18) Verify Date
			// ^ (19)Verify BY ^ (20) Financial Period(2013-2014) ^ (21) Next PO Date ^ (22) Purchase Commite date 
			// ^ (23)Negotiation Meeting Date ^ (24)Remarks ^ (25) Verified By Name ^(26)Verify Date ^ (27) Total Amendment 
			// ^ (28)Rate Contracted Flg ^(29)PO Type Authantication ID^(30) POREF NO 
			// ^ (31)PO Prefix ^ (32) Store Name{PO Creater} ^ (33) Purchae Source Name ^ (34) Rate Contract Id
			/** ******************************************************************************* */
			
		 var mode = "PREVDELIVERYDETAILS";			 
		 var strPOHiddenValue = document.getElementsByName("strPOHiddenValue")[0].value.split("^");		  
		 var url = "SupplierDeskInterfaceTransCNT.cnt?hmode="+mode+"&strPoNo="+strPOHiddenValue[11]+
		 "&strPoStoreId="+document.getElementsByName("strChk")[0].value.split("@")[1]+
		 "&strDeliveryStorId="+document.getElementById("strDelLocationId"+index).value+"&strPoTypeId="+strPOHiddenValue[5];
		
		 ajaxFunction(url, "18");
	
	     document.getElementById("divDeliveryDetails").style.display="block";
	     
}

/*
 * Global Variable Used to Set Object value of Pop-Up
 * */

var parentPopup="";
function openProgrammePoPUp(obj ,i)
{		
	
	var index = parseInt(i);
	parentPopup = obj;
	var hiddenValue = document.getElementById("strPODetailsHidValue"+i).value.split("^")[0]+"^"+document.getElementById("strPODetailsHidValue"+i).value.split("^")[8];
	var hmode = "GETPROGRAMMEDTL";
	//var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strPODetailsHidValue="+hiddenValue+"&count="+index;
	var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strPODetailsHidValue="+hiddenValue+"&count="+index+
	"&strSupplierId="+(document.forms[0].strSupplierId.value).split("^")[0]+"&strPOItemID="+document.forms[0].strPOItemID.value.split("^")[0]+"^"+document.forms[0].strPOItemID.value.split("^")[1]+
	"&strComboPOTypeId="+document.forms[0].strComboPOTypeId.value+
	"&strIndentPeriodValue="+document.forms[0].strIndentPeriodValue[document.forms[0].strIndentPeriodValue.selectedIndex].text+
	"&strPopUpValue="+document.getElementById("strProgrammeId"+i).value;	
	ajaxFunction(url,"10");
	
}

function openScheduleProgrammePoPUp(obj ,i)
{		
	
	var index = parseInt(i);
	parentPopup = obj;
	var hiddenValue = document.getElementById("strPODetailsHidValue"+i).value.split("^")[0]+"^"+document.getElementById("strPODetailsHidValue"+i).value.split("^")[8];
	var createHiddenValue = document.forms[0].strPONo.value+"^"+document.getElementsByName("combo")[0].value+"^"+document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value.split("@")[0];
	
	//alert("createHiddenValue = " + createHiddenValue);
	//alert("hiddenValue = " + hiddenValue);
	
	var hmode = "GETSCHEDULEPROGRAMMEDTL";
	var url = "PODeskGenerateTransCNT.cnt?hmode=" + hmode +
			  "&strPODetailsHidValue=" + hiddenValue +
			  "&count=" + index +
			  "&POHiddenVal="+createHiddenValue+
			  "&strIndentPeriodValue="+document.forms[0].strIndentPeriodValue.value+
			  "&strPopUpValue="+document.getElementById("strProgrammeId"+i).value;	
	ajaxFunction(url,"10");	
}

function openViewScheduleProgrammePoPUp(obj ,i)
{		
	
	var index = parseInt(i);
	parentPopup = obj;
	var hiddenValue = document.getElementById("strPODetailsHidValue"+i).value.split("^")[0]+"^"+document.getElementById("strPODetailsHidValue"+i).value.split("^")[8];
	var createHiddenValue = document.forms[0].strPONo.value+"^"+document.getElementsByName("combo")[0].value+"^"+document.forms[0].strPOItemID[document.forms[0].strPOItemID.selectedIndex].value.split("@")[0];
	var hmode = "GETVIEWSCHEDULEPROGRAMMEDTL";
	var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strPODetailsHidValue="+hiddenValue+"&count="+index+"&POHiddenVal="+createHiddenValue+"&strIndentPeriodValue="+document.forms[0].strIndentPeriodValue.value+"&strPopUpValue="+document.getElementById("strProgrammeId"+i).value;	
	ajaxFunction(url,"10");	
}
//called from popup (schedule qty)
function validateSchQty(rowIndex,colIndex)
{
	var prgQtyObj;
	var prgQtyObj1;
	var i = 0;
	
	if(parseInt(colIndex,10) < 4)
	{
		prqQtyObj1 = document.getElementById("strProgrammeQrderQty" + rowIndex + "-" + (colIndex));	
		
		if(prqQtyObj1.value.trim().length <= 0 || parseInt(prqQtyObj1.value,10) == 0)
		{
			for(i=parseInt(colIndex,10);i<=4;i++)
			    
				document.getElementById("strProgrammeQrderQty" + rowIndex + "-" + (i)).value = "0";
		}
	}
	
	/*if(parseInt(colIndex,10) > 1)
	{
		prqQtyObj1 = document.getElementById("strProgrammeQrderQty" + rowIndex + "-" + (colIndex));
		if(prqQtyObj1.value.trim().length > 0 && parseInt(prqQtyObj1.value,10) > 0)
		{		
			prgQtyObj = document.getElementById("strProgrammeQrderQty" + rowIndex + "-" + (colIndex-1));
			if(prgQtyObj.value.trim().length <= 0 || parseInt(prgQtyObj.value,10) <= 0)
			{
				alert("Please enter the previous schedule qty !!");
				prgQtyObj.focus();
				prqQtyObj1.value = "0";			
				return false;	
			}
		}
	}*/
}
//called from popup window (save in case of modify)
function totalProgramQtyModify(index)
{
	var  totQty = 0;
    var prgQty1 = 0;
    var prgQty2 = 0;
    var prgQty3 = 0;
    var prgQty4 = 0;

    var prgTotQty1 = 0;
    var prgTotQty2 = 0;
    var prgTotQty3 = 0;
    var prgTotQty4 = 0;
    
	var j = 0;
    var  totItemLen = document.getElementsByName("strProgrammeQrderQty").length;
    
	var  itemQty = document.getElementsByName("strProgrammeQrderQty");
	var  programmeId = document.getElementsByName("strProgrammeIdValue"); 
	var  programList ;
	var   schIQtyPrev = 0;
 	var   schIIQtyPrev = 0;
 	var   schIIIQtyPrev = 0;
 	var   schIVQtyPrev = 0;
	
	for(var i = 0;i<totItemLen/4;i++)
	{
		if((itemQty[4 * i].value).trim().length > 0)
			totQty = totQty +  parseFloat(itemQty[4 * i].value);
		
		if((itemQty[4 * i + 1].value).trim().length > 0)
			totQty = totQty +  parseFloat(itemQty[4 * i + 1].value);
			
		if((itemQty[4 * i + 2].value).trim().length > 0)
			totQty = totQty +  parseFloat(itemQty[4 * i + 2].value);
			
		if((itemQty[4 * i + 3].value).trim().length > 0)
			totQty = totQty +  parseFloat(itemQty[4 * i + 3].value);
		
		j = 4 * parseInt(i,10);
		prgQty1 = itemQty[j].value;
		if(prgQty1.trim().length <= 0) 	prgQty1 = 0;
		
		j = 4 * parseInt(i,10) + 1;
		prgQty2 = itemQty[j].value;
		if(prgQty2.trim().length <= 0) 	prgQty2 = 0;
		
		j = 4 * parseInt(i,10) + 2;
		prgQty3 = itemQty[j].value;
		if(prgQty3.trim().length <= 0) 	prgQty3 = 0;
		
		j = 4 * parseInt(i,10) + 3;
		prgQty4 = itemQty[j].value;
		if(prgQty4.trim().length <= 0) 	prgQty4 = 0;
		
		prgTotQty1 = parseInt(prgTotQty1) + parseInt(prgQty1);
		prgTotQty2 = parseInt(prgTotQty2) + parseInt(prgQty2);
		prgTotQty3 = parseInt(prgTotQty3) + parseInt(prgQty3);
		prgTotQty4 = parseInt(prgTotQty4) + parseInt(prgQty4);
		
		if(i == '0')		
			programList = programmeId[i].value + "@" + prgQty1 + "@" + prgQty2 + "@" + prgQty3 + "@" + prgQty4;	
		else
			programList = programList + "$" + programmeId[i].value + "@" + prgQty1 + "@" + prgQty2 + "@" + prgQty3 + "@" + prgQty4;
	}
	//alert("programList = " + programList);
    document.getElementById("strQrderQty"+index).value = totQty;
	document.getElementById("strProgrammeId"+index).value = programList;
	
	//alert("strPrevProgOrderQty = " + document.getElementById("strPrevProgOrderQty").value);
	//alert("length = " + document.getElementById("strPrevProgOrderQty").value.split("^").length);
	if (document.getElementById("strPrevProgOrderQty").value.split("^").length > 0)
	{
		schIQtyPrev = document.getElementById("strPrevProgOrderQty").value.split("^")[0];
		schIIQtyPrev = document.getElementById("strPrevProgOrderQty").value.split("^")[1];
		schIIIQtyPrev = document.getElementById("strPrevProgOrderQty").value.split("^")[2];
		schIVQtyPrev = document.getElementById("strPrevProgOrderQty").value.split("^")[3];
	}
	//alert("schIQtyPrev = " + schIQtyPrev + "\nschIIQtyPrev = " + schIIQtyPrev + "\nschIIIQtyPrev = " + schIIIQtyPrev + "\nschIVQtyPrev = " + schIVQtyPrev);
	totQty1 = parseInt(prgTotQty1) - parseInt(schIQtyPrev);
    totQty2 = parseInt(prgTotQty2) - parseInt(schIIQtyPrev);
    totQty3 = parseInt(prgTotQty3) - parseInt(schIIIQtyPrev);
    totQty4 = parseInt(prgTotQty4) - parseInt(schIVQtyPrev);
		
	//alert("totQty1 = " + totQty1 + "\ntotQty2 = " + totQty2 + "\ntotQty3 = " + totQty3 + "\ntotQty4 = " + totQty4);
	
	var newSch1Qty = document.getElementById("strTotalSchIQty").value;
 	var newSch2Qty = document.getElementById("strTotalSchIIQty").value;
 	var newSch3Qty = document.getElementById("strTotalSchIIIQty").value;
 	var newSch4Qty = document.getElementById("strTotalSchIVQty").value;
 	
 	newSch1Qty = parseInt(newSch1Qty) + parseInt(totQty1);
	newSch2Qty = parseInt(newSch2Qty) + parseInt(totQty2);
	newSch3Qty = parseInt(newSch3Qty) + parseInt(totQty3);
	newSch4Qty = parseInt(newSch4Qty) + parseInt(totQty4);
	
	//alert("newSch1Qty = " + newSch1Qty + "\nnewSch2Qty = " + newSch2Qty + "\nnewSch3Qty = " + newSch3Qty + "\nnewSch4Qty = " + newSch4Qty);
	var totalOrderQty = newSch1Qty + newSch2Qty + newSch3Qty + newSch4Qty
	
	document.getElementById("totalSchQtyIDiv").innerHTML = "<b>" + newSch1Qty + "</b>";
	document.forms[0].strTotalSchIQty.value = newSch1Qty;
	
	document.getElementById("totalSchQtyIIDiv").innerHTML = "<b>" + newSch2Qty + "</b>";
	document.forms[0].strTotalSchIIQty.value = newSch2Qty;
	
	document.getElementById("totalSchQtyIIIDiv").innerHTML = "<b>" + newSch3Qty + "</b>";
	document.forms[0].strTotalSchIIIQty.value = newSch3Qty;
	
	document.getElementById("totalSchQtyIVDiv").innerHTML = "<b>" + newSch4Qty + "</b>";
	document.forms[0].strTotalSchIVQty.value = newSch4Qty;
	
	document.getElementById("totalOrderQtyDiv").innerHTML = "<b>" + totalOrderQty + "</b>";
	document.forms[0].strTotalQrderQty.value = totalOrderQty;
	
	calStoreWiseCost(totQty,index);	
	calPOCost();
	
	document.getElementById("programme"+index).innerHTML="";
	hide_popup_menu("programme"+index);
}

//called from popup window (save in case of generate)
function totalProgramQty(index)
{
    var  totQty = 0;
    var prgQty1 = 0;
    var prgQty2 = 0;
    var prgQty3 = 0;
    var prgQty4 = 0;
    
    var j = 0;
    var  totItemLen = document.getElementsByName("strProgrammeQrderQty").length;
    
	var  itemQty = document.getElementsByName("strProgrammeQrderQty");
	var  programmeId = document.getElementsByName("strProgrammeIdValue"); 
	var  programList ;
		
	for(var i = 0;i<totItemLen/4;i++)
	{
		if((itemQty[4 * i].value).trim().length > 0)
			totQty = totQty +  parseFloat(itemQty[4 * i].value);
		
		if((itemQty[4 * i + 1].value).trim().length > 0)
			totQty = totQty +  parseFloat(itemQty[4 * i + 1].value);
			
		if((itemQty[4 * i + 2].value).trim().length > 0)
			totQty = totQty +  parseFloat(itemQty[4 * i + 2].value);
			
		if((itemQty[4 * i + 3].value).trim().length > 0)
			totQty = totQty +  parseFloat(itemQty[4 * i + 3].value);
		
		j = 4 * parseInt(i,10);
		prgQty1 = itemQty[j].value;
		if(prgQty1.trim().length <= 0) 	prgQty1 = 0;
		
		j = 4 * parseInt(i,10) + 1;
		prgQty2 = itemQty[j].value;
		if(prgQty2.trim().length <= 0) 	prgQty2 = 0;
		
		j = 4 * parseInt(i,10) + 2;
		prgQty3 = itemQty[j].value;
		if(prgQty3.trim().length <= 0) 	prgQty3 = 0;
		
		j = 4 * parseInt(i,10) + 3;
		prgQty4 = itemQty[j].value;
		if(prgQty4.trim().length <= 0) 	prgQty4 = 0;
		
		if(i == '0')		
			programList = programmeId[i].value + "@" + prgQty1 + "@" + prgQty2 + "@" + prgQty3 + "@" + prgQty4;	
		else
			programList = programList + "$" + programmeId[i].value + "@" + prgQty1 + "@" + prgQty2 + "@" + prgQty3 + "@" + prgQty4;
	}
	document.getElementById("strQrderQty"+index).value=totQty;
	document.getElementById("strProgrammeId"+index).value=programList;
	
	calStoreWiseCost(totQty,index);
	calculatePerScheduleTotalQty();
	calculateTotalQty();	
	calPOCost();
	
	//hide popup window
	document.getElementById("programme"+index).innerHTML="";
	hide_popup_menu("programme"+index);
}

function calculatePerScheduleTotalQty()
{
	var   totQtyI = 0;
	var   schIQty = 0;
	
	var   totQtyII = 0;
	var   schIIQty = 0;
	
	var   totQtyIII = 0;
	var   schIIIQty = 0;
	
	var   totQtyIV = 0;
	var   schIVQty = 0;
	
    var   totItemLen = document.getElementsByName("strProgrammeId").length;
	var   itemQty = document.getElementsByName("strProgrammeId");
	
	for(var i = 0; i < totItemLen; i++)
	{
		if(itemQty[i].value.length > 0)
		{
			if (itemQty[i].value.search("$") == -1)
			{
				//Schedule I
				if (itemQty[i].value.split("@")[1] > 0)
				{
					schIQty = parseInt(itemQty[i].value.split("@")[1]);
				}
				else
				{
					schIQty = 0;
				}
		   		totQtyI = totQtyI +  parseInt(schIQty,10);
		   		
		   		//Schedule II
				if (itemQty[i].value.split("@")[2] > 0)
				{
					schIIQty = parseInt(itemQty[i].value.split("@")[2]);
				}
				else
				{
					schIIQty = 0;
				}
				totQtyII = totQtyII +  parseInt(schIIQty,10);
				
				//Schedule III
				if (itemQty[i].value.split("@")[3] > 0)
				{
					schIIIQty = parseInt(itemQty[i].value.split("@")[3]);
				}
				else
				{
					schIIIQty = 0;
				}
				totQtyIII = totQtyIII +  parseInt(schIIIQty,10);
				
				//Schedule IV
				if (itemQty[i].value.split("@")[4] > 0)
				{
					schIVQty = parseInt(itemQty[i].value.split("@")[4]);
				}
				else
				{
					schIVQty = 0;
				}
				totQtyIV = totQtyIV +  parseInt(schIVQty,10);
			}
			else
			{
				var noOfPrograms = itemQty[i].value.split("$").length;
				for (var j = 0; j < noOfPrograms; j++)
				{
					//Schedule I
					if (itemQty[i].value.split("$")[j].split("@")[1] > 0)
					{
						schIQty = parseInt(itemQty[i].value.split("$")[j].split("@")[1]);
					}
					else
					{
						schIQty = 0;
					}
			   		totQtyI = totQtyI +  parseInt(schIQty,10);
			   		
			   		//Schedule II
					if (itemQty[i].value.split("$")[j].split("@")[2] > 0)
					{
						schIIQty = parseInt(itemQty[i].value.split("$")[j].split("@")[2]);
					}
					else
					{
						schIIQty = 0;
					}
					totQtyII = totQtyII +  parseInt(schIIQty,10);
					
					//Schedule III
					if (itemQty[i].value.split("$")[j].split("@")[3] > 0)
					{
						schIIIQty = parseInt(itemQty[i].value.split("$")[j].split("@")[3]);
					}
					else
					{
						schIIIQty = 0;
					}
					totQtyIII = totQtyIII +  parseInt(schIIIQty,10);
					
					//Schedule IV
					if (itemQty[i].value.split("$")[j].split("@")[4] > 0)
					{
						schIVQty = parseInt(itemQty[i].value.split("$")[j].split("@")[4]);
					}
					else
					{
						schIVQty = 0;
					}
					totQtyIV = totQtyIV +  parseInt(schIVQty,10);
				}
			}
		}
	}
	
	document.getElementById("totalSchQtyIDiv").innerHTML = "<b>" + totQtyI + "</b>";
	document.forms[0].strTotalSchIQty.value = totQtyI;
	
	document.getElementById("totalSchQtyIIDiv").innerHTML = "<b>" + totQtyII + "</b>";
	document.forms[0].strTotalSchIIQty.value = totQtyII;
	
	document.getElementById("totalSchQtyIIIDiv").innerHTML = "<b>" + totQtyIII + "</b>";
	document.forms[0].strTotalSchIIIQty.value = totQtyIII;
	
	document.getElementById("totalSchQtyIVDiv").innerHTML = "<b>" + totQtyIV + "</b>";
	document.forms[0].strTotalSchIVQty.value = totQtyIV;
}

function calStoreWiseCost(orderQty,index)
{
	//calculate cost
	var rate = document.forms[0].strItemTotalRate.value;
	if(rate == "") rate = "0";
	rate = parseFloat(rate,10);
	
	var nOrderQty = 0;
	if(orderQty == "" || orderQty.length <= 0)
		nOrderQty = 0;
	else
		nOrderQty = parseFloat(orderQty,10);
			 
	var cost = roundValue(rate * parseInt(nOrderQty,10),2);
	document.getElementById("strOrdeCost" + index).value = cost;
	document.getElementById("orderCostDiv" + index).innerHTML = cost;
}

//calculate po cost
function calPOCost()
{
	var poCost = 0.00;
	var itemCost = "0";
	
	var totItemLen = document.getElementsByName("strOrdeCost").length;
	var itemWiseCost = document.getElementsByName("strOrdeCost");
	
	for(var i=0;i<totItemLen;i++)
	{
		itemCost = itemWiseCost[i].value;
		if(itemCost == "") itemCost = "0";
		
		poCost = poCost +  parseFloat(itemCost,10);
	}
	
	document.getElementById("totalPOCost").innerHTML = roundValue(poCost,2);
	document.forms[0].strTotalPOCost.value = roundValue(poCost,2);
}

function hidePopUp(index)
{
	//alert(index);
	//document.getElementById("strQrderQty"+index).value='0';
	hide_popup_menu("programme"+index);
	
}
/*
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
         
         var objVal5 = document.getElementById("25");
        
        
         
          objVal5.innerHTML = myArray[4]; 
        
                    
        var objVal6 = document.getElementById("26");
        
        
         
          objVal6.innerHTML = myArray[6]; 
        
        
        var objVal7 = document.getElementById("27");
        
        
         
          objVal7.innerHTML = myArray[7];  
        
        
        
        var objVal8 = document.getElementById("28");
        
         objVal8.innerHTML = parseInt(myArray[6])+parseInt(myArray[7]);  
         
         var objVal9 = document.getElementById("29");
        
        
         
          objVal9.innerHTML = myArray[8]; 
        
                    
        var objVal10 = document.getElementById("30");
        
        
         
          objVal10.innerHTML = myArray[10]; 
       
        
        var objVal11 = document.getElementById("31");
        
        
         
          objVal11.innerHTML = myArray[11];  
        
        
        
        var objVal12 = document.getElementById("32");
        
         objVal12.innerHTML = parseInt(myArray[10])+parseInt(myArray[11]); 
         
         
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
*/
function hideItemDetails(divId)
{
      hide_popup_menu(divId);
}


function setVlue(index)
{
	document.getElementById("ajaxFlg"+index).value='1';
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
    
 // Function for Numeric(13,4)
function numericWithFourDecimalPlaces(fld, milSep, decSep, e)
{
	//alert("hhhhhhhhhh");
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
		len=13;
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
	if (len == 3) fld.value = ''+ decSep + aux;
	if (len == 4) fld.value = ''+ decSep + aux;
	if (len > 4) {
	aux2 = '';
	for (j = 0, i = len - 5; i >= 0; i--) {
	if (j == 5) {
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
	fld.value += decSep + aux.substr(len - 4, len);
	}
	
	
	return false;
}	 	    
    
function FuncTick(obj)
{
  if(obj.value == '1')
  {
  	document.getElementById("remarks").innerHTML="Remarks";
  	document.forms[0].strApprovalFlag.value="1";  
    document.forms[0].strApproved.checked = true;
    document.forms[0].strRejected.checked = false;
  }
  else
  {
  	 document.getElementById("remarks").innerHTML="<font color='red'>*</font>Remarks";
  	 document.forms[0].strApprovalFlag.value="2";  
     document.forms[0].strRejected.checked = true;
     document.forms[0].strApproved.checked = false;
  }
  
}


//called from save button
function SaveAcceptance()
{	
	/** ******************************************************************************* */
			//   (0) PO_DATE ^ (1)SUPP NAME ^ (2)PO TYPE ^ (3)PO NET AMOUNT ^(4) Supplier ID
			// ^ (5) PO Type Id ^(6) Currency Id ^(7)Currency Value ^(8) Item Catg No
			// ^ (9) Catg Name ^ (10)Purchase Source ID ^ (11)Po Number ^ (12)PO Prefix ^(13) Tax
			// ^ (14)Tender Number ^ (15)Tender Date ^ (16)Qutation No ^ (17)Qutation Date ^(18) Verify Date
			// ^ (19)Verify BY ^ (20) Financial Period(2013-2014) ^ (21) Next PO Date ^ (22) Purchase Commite date 
			// ^ (23)Negotiation Meeting Date ^ (24)Remarks ^ (25) Verified By Name ^(26)Verify Date ^ (27) Total Amendment 
			// ^ (28)Rate Contracted Flg ^(29)PO Type Authantication ID^(30) POREF NO 
			// ^ (31)PO Prefix ^ (32) Store Name{PO Creater} ^ (33) Purchae Source Name ^ (34) Rate Contract Id
	/** ******************************************************************************* */
    var strPOHiddenValue = document.getElementsByName("strPOHiddenValue")[0].value.split("^");	
	if(document.forms[0].strApprovalFlag.value=="2")
	{
	
		var hisValidator = new HISValidator("supplierDeskTransBean");
		hisValidator.addValidation("strRemarks", "req", "Remarks is a Mandatory Field");
		hisValidator.addValidation("strRemarks", "maxlen=100",	"Remarks cannot contains more than 100 Characters");
		
		var retVal = hisValidator.validate();
		hisValidator.clearAllValidations();		
		if(retVal)
		{
						
			alert("You Are Going To Reject \n PO No. :  " + strPOHiddenValue[12]+"("+strPOHiddenValue[11]+")" 
			  	  +"\n PO Reference Date : " + strPOHiddenValue[0] 
				  +" With PO Value : " + strPOHiddenValue[3]+" For Financial Period :"+strPOHiddenValue[20]);
			retVal = confirm("Are You Sure?");
			if(retVal)
			{		   		  
			   	document.forms[0].hmode.value="INSERTACCEPTANCE";		   			   			
				document.forms[0].submit();
			}
			else
			{
				return false;
			}
		}
	}
	else
	{
		    var retVal;
		    alert("You Are Going To Accept \n PO No. :  " + strPOHiddenValue[12]+"("+strPOHiddenValue[11]+")" 
			  	  +"\n PO Reference Date : " + strPOHiddenValue[0] 
				  +" With PO Value : " + strPOHiddenValue[3]+" For Financial Period :"+strPOHiddenValue[20]);
			retVal = confirm("Are You Sure?");
			if(retVal)
			{		   		  
			   	document.forms[0].hmode.value="INSERTACCEPTANCE";		   			   			
				document.forms[0].submit();
			}
			else
			{
				return false;
			}
	}
}

//called from save button
function SaveDelivery()
{	
	
	document.getElementsByName("strReplacementDirectBatchFlag")[0].disabled = false;
	document.getElementsByName("strReplacementDirectBatchFlag")[1].disabled = false;
	document.getElementsByName("strReplacementDirectBatchFlag")[2].disabled = false;
	/** ******************************************************************************* */
			//   (0) PO_DATE ^ (1)SUPP NAME ^ (2)PO TYPE ^ (3)PO NET AMOUNT ^(4) Supplier ID
			// ^ (5) PO Type Id ^(6) Currency Id ^(7)Currency Value ^(8) Item Catg No
			// ^ (9) Catg Name ^ (10)Purchase Source ID ^ (11)Po Number ^ (12)PO Prefix ^(13) Tax
			// ^ (14)Tender Number ^ (15)Tender Date ^ (16)Qutation No ^ (17)Qutation Date ^(18) Verify Date
			// ^ (19)Verify BY ^ (20) Financial Period(2013-2014) ^ (21) Next PO Date ^ (22) Purchase Commite date 
			// ^ (23)Negotiation Meeting Date ^ (24)Remarks ^ (25) Verified By Name ^(26)Verify Date ^ (27) Total Amendment 
			// ^ (28)Rate Contracted Flg ^(29)PO Type Authantication ID^(30) POREF NO 
			// ^ (31)PO Prefix ^ (32) Store Name{PO Creater} ^ (33) Purchae Source Name ^ (34) Rate Contract Id
	/** ******************************************************************************* */
	
	
    var hisValidator = new HISValidator("supplierDeskTransBean");
  
  		  hisValidator.addValidation("strSupplierReceiptDate",      "req",	"Invoice Date is a Mandatory Field");
  		  
  		  
  		  var strSupplierReceiptDate = document.forms[0].strSupplierReceiptDate.value;
  		  var res = strSupplierReceiptDate.split("-");
  		  var invoicedate = new Date(strSupplierReceiptDate);
  		  //alert("strSupplierReceiptDate---->"+strSupplierReceiptDate);
  		  var month = invoicedate.getMonth();
  		  //alert("month----->"+month);
  		  var invoicedate = new Date(res[2],month,res[0]);
  		  //alert("invoicedate----------->"+invoicedate);
  		  var crrDate = new Date();
  		  //alert("crrDate--------->"+crrDate);
  		  var crrmonth = crrDate.getMonth();
  		  //alert("crrmonth--------->"+crrmonth);
  		
  		if(document.forms[0].strScheduleNo.value.split("^")[3]!='19')
  		{
  		  
  		  
  		  if(crrmonth > 2)
  			  {
	  		  var year =  parseInt(crrDate.getFullYear());
	  		  var year1 = year;
	  		  year1++;
	  		  var fromdate = new Date(year,2,31); 
	  		  var todate = new Date(year1,3,01); 
	  		  //alert("fromdate-----"+fromdate);
	  		  //alert("todate-------->"+todate);
	  		  
	  		  
	  		  
	  		  if(invoicedate <= fromdate|| invoicedate >= todate)
	  			  {
	  			  alert("Invoice date should be between financial year April-"+year+" -- "+"March-"+year1+" !!!!");
	  			  return false;
	  			  }
  			  }
  		  else
  			  {
  	  		  var year =  parseInt(crrDate.getFullYear());
  	  		  var year1 = year;
  	  		  year1--;
  	  		  var fromdate = new Date(year1,2,31); 
  	  		  var todate = new Date(year,3,01); 
	  		  //alert("fromdate-----"+fromdate);
	  		  //alert("todate-------->"+todate);
  	  		  if(invoicedate <= fromdate|| invoicedate >= todate)
  	  			  {
  	  			  alert("Invoice date should be between financial year April-"+year1+" -- "+"March-"+year+" !!!!");
  	  			  return false;
  	  			  }
  			  }
  		  
  		}
  		  
       // hisValidator.addValidation("strSupplierReceiptDate", "dtgtet="+ document.forms[0].strCurrentDate.value,"Invoice Date should be Greater than or Equal to Current Date");
		hisValidator.addValidation("strExpectedDeliveryDays", "req",	"Expected. Delivery Days is a Mandatory Field");
		//hisValidator.addValidation("strSupplierReceiptNo",    "req",	"Supplier Receipt No is a Mandatory Field");
		hisValidator.addValidation("strSupplierInvoiceNo",    "req",	"Invoice No is a Mandatory Field");
		hisValidator.addValidation("strLorryNo",              "req",	"Lorry No is a Mandatory Field");		
		hisValidator.addValidation("strTransporterName",      "req",	"Transporter Name is a Mandatory Field");
		hisValidator.addValidation("strRemarks", "maxlen=100",	"Remarks cannot contains more than 100 Characters");
		//hisValidator.addValidation("strSupplierReceiptDate",      "req",	"Invoice Date is a Mandatory Field");
		hisValidator.addValidation("strDateOfDelivery",      "req",	"Likely Date of Delivery is a Mandatory Field");
		//hisValidator.addValidation("strDateOfDispatch",      "req",	"Date of Dispatch is a Mandatory Field");
		hisValidator.addValidation("strDateOfDispatch",      "req",	"Date Of Dispatch is a Mandatory Field");
		hisValidator.addValidation("strDateOfDispatch",      "dtgtet="+ document.forms[0].strSupplierReceiptDate.value,"Dispatch Date should be Greater than or Equal to Invoice Date");
				
		if(document.forms[0].strDateOfDelivery.value!='' && document.forms[0].strDateOfDelivery.value.length>0)
		{
			if(document.forms[0].strSupplierReceiptDate.value!='' && document.forms[0].strSupplierReceiptDate.value.length>0){
				hisValidator.addValidation("strDateOfDelivery", "dtgtet="+ document.forms[0].strSupplierReceiptDate.value,"Likely Date Of Delivery should be Greater than or Equal to Invoice Date");
			}	
			
			hisValidator.addValidation("strDateOfDispatch", "dtltet="+ document.forms[0].strDateOfDelivery.value,"Date Of Dispatch should be Lesser than or Equal to Likely Date Of Delivery");
			
		}
		//for reject and direct return batch 
	//	alert(document.forms[0].strReplacementDirectBatchFlag.value);
		if(document.forms[0].strReplacementDirectBatchFlag.value=="1" || document.forms[0].strReplacementDirectBatchFlag.value=="2")
		{
		
		var len1 = parseInt(document.forms[0].strRightBatchNos.length);
		//alert(len1);
		if(len1>0)
		{
			var strBatchNo = "0"; 
			for(var k=0; k<len1; k++)
			{
				if(k==0)
				{
					strBatchNo = document.forms[0].strRightBatchNos[k].value.split("^")[0];
					
				}
				else	
				{
					strBatchNo	=	strBatchNo +","+ document.forms[0].strRightBatchNos[k].value.split("^")[0];
				}		
			}
		}
		else
			{
			alert("Shift atleast one Batch from Rejected/Direct Batch Section !!!!");
			return false;
			}
		
	}
		if(document.forms[0].strReplacementDirectBatchFlag.value=="1" || document.forms[0].strReplacementDirectBatchFlag.value=="2")
		{
			document.forms[0].strBatchNo.value	= strBatchNo;
		}
		
		var retVal = hisValidator.validate();
		hisValidator.clearAllValidations();		
		if(retVal)
		{    
			    var strPOHiddenValue = document.getElementsByName("strPOHiddenValue")[0].value.split("^");	
				document.forms[0].strScheduleNo.disabled=false;
				document.forms[0].strDeliveryStoreId.disabled = false;
				 document.forms[0].strManufacturerValues.disabled = false ;
                   document.forms[0].strUnitId.disabled = false ;
				
				
				
				var batchLength = document.getElementsByName("strHiddenValue").length;
				
				if(batchLength==0)
				{
					alert("Save Not Allowed!!!");
					return false;
				}
				
				var retVal;
			    alert("You Are Going To Delivery [ "+batchLength+" ] No of Batch for  \n PO No. :  " + strPOHiddenValue[12]+"("+strPOHiddenValue[11]+")" 
				  	  +"\n PO Reference Date : " + strPOHiddenValue[0] 
					  +" With PO Value : " + strPOHiddenValue[3]+" For Financial Period :"+strPOHiddenValue[20]);
				retVal = confirm("Are You Sure?");
				if(retVal)
				{		   		  
				   	document.forms[0].hmode.value="INSERTDELIVERY";		   			   			
					document.forms[0].submit();
				}
		}
		else
		{
			return false;
		}
	
}
function callFunc()
{
	var divHeight=200;
		var initialHeight=716;
		var heightPer = (divHeight*100)/initialHeight; 
		var newHeight = parseInt((window.innerHeight * heightPer)/100,10);	
	fixedHeaderTableTransCustomize("phyStockVerifiedItemDtls",newHeight, "wrapper1","tableHeaderId1");
	 document.getElementById("phyStockVerifiedItemDtls").style.display='block';
	 barCode(1);
	 
}



function fixedHeaderTableTransCustomize(tableContainerDiv, tableHeight, wrapperDivId, tableHeaderId)
 { 	
 	
 	document.getElementById(tableContainerDiv).style.display = 'none';
 	var newTableHtml=""; 
 	var mainDivRptObj = "";	
 	
 
 	mainDivRptObj = document.getElementById("wrapper1");
 	
 //	alert(document.getElementById("wrapper").innerHTML);	 	
	
	newTableHtml = '<div id="content" style="width:100%;border-bottom: 1px solid #BBBBBB;">';
	newTableHtml+= '<div id="boundary">'; 
	newTableHtml+= '<table id="headerTableTrans" cellpadding="3" cellspacing="0" border="0" style="width:100%;text-align:left;table-layout:fixed;border-collapse:collapse;">';
	newTableHtml+= '<thead style="display:table-header-group;"><tr>';
	
	newTableHtml += document.getElementById("tableHeaderId1").innerHTML;		
	  
	newTableHtml+='</tr></thead></table></div>';
	
	if(tableHeight == "0")
		newTableHtml+= '<div id="boxHeaderNoScroll">';
	else
	{
		if(tableHeight)
			newTableHtml+= '<div id="boxHeaderFixed" style="height:'+tableHeight+'px">';
		else
			newTableHtml+= '<div id="boxHeaderFixed2">';
	}
		
		
	newTableHtml+= '<table id="tbl-content" cellpadding="3" cellspacing="0" border="0" style="width:100%;table-layout:fixed;background:#fff;border-collapse:collapse;">';
	newTableHtml+= document.getElementById('mainTableRptId1').innerHTML;
	newTableHtml+= '</table></div></div></div>';	
	mainDivRptObj.innerHTML = newTableHtml;
			
	if(tableHeaderId)
		document.getElementById(tableHeaderId).style.display="none";
	else
		document.getElementById("tableHeaderId").style.display="none";
		
	document.getElementById(tableContainerDiv).style.display = 'block';	
	if(tableHeight)
	{
		if(tableHeight != "0")
		{
			if(wrapperDivId)
			{
				if($("#"+wrapperDivId+" #tbl-content").height() > tableHeight)
					$( "#"+wrapperDivId+" #headerTableTrans th:last" ).attr("id", "right-border");	
			}
			else
			{
				if($("#tbl-content").height() > tableHeight)
					$( "#headerTableTrans th:last" ).attr("id", "right-border");	
			}
				
		}
	}
	else
	{
		if(tableHeight != "0")
		{
			if($('#tbl-content').height() > 180)
				$( "#wrapper #headerTableTrans th:last" ).attr("id", "right-border");
		}		
	}				
	 
 }


function printData() 
{

	newwin = window.open('', 'printwin',
			'left=100,top=100,width=700,height=700,scrollbars=yes');
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
newwin.document.write((document.getElementsByTagName("body" )[0]).innerHTML);
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}



 function printData1()
{
	/*
	 * document.getElementById("id1").style.display="none"; window.print();
	 * document.getElementById("id1").style.display="block";
	 */
	
	
newwin=window.open('','printwin','left=100,top=100,width=700,height=700,scrollbars=yes');
newwin.document.write('<HTML><HEAD>');
newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
// newwin.document.write('<style type="text/css"> .hidecontrol { display: none;
// } </style>\n')
newwin.document.write('\n');
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
newwin.document.write('<BODY>\n');
newwin.document.write((document.getElementsByTagName("body" )[0]).innerHTML);
newwin.document.write('</BODY>\n');
newwin.document.write('<script>\n');
newwin.document.write('document.getElementById("id1").style.display="none"\n');
newwin.document.write('document.getElementById("id2").style.display="none"\n');
newwin.document.write('print_win();\n');
newwin.document.write('</script>\n');
newwin.document.write('</HTML>\n');

newwin.document.close();
	
	
	
}
 
	function LeftBatchListTransfer()
	{
		//alert("drug");
		//shiftToRight("strLeftDrugIds","strRightDrugIds",1);
		shiftToRightLimit("strLeftBatchNos","strRightBatchNos",1,50);
	}
	
	function RightBatchListTransfer()
	{

		shiftToLeft("strLeftBatchNos","strRightBatchNos",1);

	}
	function cancelToList()
	{
		document.forms[0].hmode.value = "LISTDATA";
		 document.forms[0].submit();
		
		}
	
	function generatePdfCommon1(dataDivId) {
		
		 
		var printImg = document.getElementById("printImg").innerHTML;
		document.getElementById("printImg").innerHTML = "";
		var dataDivObj = "";

		if (document.getElementById(dataDivId) != null) {
			dataDivObj = document.getElementById(dataDivId);
		} else {
			alert("No data to convert in pdf format!");
		}

		 
		if (dataDivObj.innerHTML != "") {

			 
			document.forms[0].strHtmlCode.value = innerXHTML(dataDivObj);
			document.forms[0].hmode.value = "generatePdf1";
			 
			document.forms[0].submit();
			document.getElementById("printImg").innerHTML = printImg;
			document.forms[0].strHtmlCode.value = "";

		} else {
			alert("No data to convert in pdf format!");
		}
	}
	
	function printDataNew(mode) 
	{

		newwin = window.open('', 'printwin',
				'left=100,top=100,width=1200,height=700,scrollbars=yes');
		newwin.document.write('<HTML><HEAD>');
		if(mode=='1')
		{
		  newwin.document.write(document.getElementById('challanStatusDtlDivId').innerHTML);
		}
		else
		{
		  newwin.document.write(document.getElementById('IssueItempopup').innerHTML);	
		}
		

		//newwin.document.write(document.getElementById("trackPurchaseOrderDivId").innerHTML);
		newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n');
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
		
		
		
//		if(mode=='2')
//		{
//		  newwin.document.write(document.getElementById('poChallanDtlsDivId').innerHTML);
//		}
//		if(mode=='3')
//		{
//		  newwin.document.write(document.getElementById('poChallanItemDtlsDivId').innerHTML);
//		}
//		if(mode=='4')
//		{
//		  newwin.document.write(document.getElementById('suppliedPOPrintDtlsDivId').innerHTML);
//		}
		newwin.document.write('</BODY>\n');
		newwin.document.write('</HTML>\n');
		newwin.document.close();

	}
		