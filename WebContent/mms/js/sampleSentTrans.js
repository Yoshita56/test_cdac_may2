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

function calUnitBaseCost(selected_obj)
{
               var issueQty      = (document.getElementById("strSampleIssueQty").value)*(selected_obj.value.split("^")[1]);
		       var temp          = document.getElementById("strHiddenBatchDtl").value.split("^");
		       var avlQtyBaseVal = temp[0];
		    
		    
			    if (parseFloat(avlQtyBaseVal) < issueQty) 
			    {
				  alert("Sample Issue Quantity should not be Greater than Inhand Quantity");
				  document.getElementById("strSampleIssueQty").value = "0";
				  document.getElementsByName("strSampleUnitId").value = "0";
				 				 
				   return false;
			    }
			            
           
           
}

function calculateCostOnChange() 
{
    var bkgQtyQtyUnit   = document.getElementById("strSampleUnitId").value;
    var bkgQtyObj       = document.getElementById("strSampleIssueQty").value;
    var qty_base_value  = document.getElementById("strSampleUnitId").value.split("^")[1];
    if ((typeof(document.getElementById("strSampleIssueQty"))!="undefined" && bkgQtyObj!='0'&& bkgQtyObj!='00'&& bkgQtyObj!='000'&& bkgQtyObj!='')&&(typeof(document.getElementById("strSampleUnitId"))!="undefined" && qty_base_value!='0' && document.getElementById("strSampleUnitId").value!='0')) 
	{
	    var bkgQty         =bkgQtyObj*qty_base_value;
	    var temp          = document.getElementById("strHiddenBatchDtl").value.split("^");
		var avlQtyBaseVal = temp[0];		
		
		if (parseFloat(avlQtyBaseVal) < bkgQty) 
		{
			alert("Sample Issue Quantity should not be Greater than Inhand Quantity");
			document.getElementById("strSampleIssueQty").value ='';
			
			return false;
		}

	} 
	else 
	{
		    if(bkgQtyObj=='0'|| bkgQtyObj=='00'|| bkgQtyObj=='000'|| bkgQtyObj=='')
			{
			 alert("Please Enter Issue Quantity");
			 document.getElementById("strSampleIssueQty").value ='';
			 return false;
			}
			else
			{
				
			      alert("Please Select Quantity Unit ");
			      return false;
				 
			}

	}

}

 var setColor = "red"; 
 var defaultColor = "blue"; 

/**
 * changeViewMode
 * @param {Object} chkObj 
 */
 function changeViewMode1(chkObj) 
 { 	 	 	
 	if(chkObj.checked)
 	{
 	   document.getElementById("batchNoDivId").innerHTML ="<select name='strBatchNo' class='comboNormal'><option title='Select Value' value='0'>Select Value</option></select>";
 	   document.forms[0].strResendFlag.value='1';
 	   document.forms[0].strSampleIssueQty.value='';
 	   document.forms[0].strLabId.value='0';
 	   document.forms[0].strCTRNumber.value='';
 	   document.forms[0].strSampleCodeNumber.value='';
 	   document.forms[0].strRemarks.value='';
 	   getQcDrugList();      
 	}
 	
 	else
 	{ 	
 	   document.getElementById("batchNoDivId").innerHTML ="<select name='strBatchNo' class='comboNormal'><option title='Select Value' value='0'>Select Value</option></select>";
 	   document.forms[0].strResendFlag.value='0';
 	   document.forms[0].strSampleIssueQty.value='';
 	   document.forms[0].strLabId.value='0';
 	   document.forms[0].strCTRNumber.value='';
 	   document.forms[0].strSampleCodeNumber.value='';
 	   document.forms[0].strRemarks.value='';
 	   getQcDrugList();      
	
 	}
 		
 	
 }
 
 function changeViewMode2(chkObj) 
 { 		
 	 	
 		document.forms[0].strResendFlag.value='0';
 		document.forms[0].hmode.value="VIEWPAGE";
		document.forms[0].submit();
	
 	
 		
 	
 }
 
 
  function InitialProcess()
 {
 
    document.getElementById("plus").style.display="none";
	document.getElementById("minus").style.display="block";
	document.getElementById("demographicInfo").style.display="block"; 
 
 } 
 
  /**
 *  function to show Received details on click of +sign
 */
function showinfo(){
	document.getElementById("plus").style.display="none";
	document.getElementById("minus").style.display="block";
	document.getElementById("demographicInfo").style.display="block";
}

/**
 *  function to hide Received details on click of -sign 
 */
function hideinfo(){
	document.getElementById("plus").style.display="block";
	document.getElementById("minus").style.display="none";
	document.getElementById("demographicInfo").style.display="none";
}
function cancel()
{
	 	document.forms[0].hmode.value="INITSAMPLESENT";
		document.forms[0].submit();
}

function CheckedAll(chkObj)
{
	var size=document.getElementsByName("chkFlg").length;
    if(chkObj.checked)
 	{
     	for(var i=0;i<size;i++)
		{
			document.getElementsByName("chkFlg")[i].checked=true;
			document.getElementsByName("chkFlg")[i].value='1';
		}
	 	
 	}
 	else
 	{
 		for(var i=0;i<size;i++)
		{
			document.getElementsByName("chkFlg")[i].checked=false;
			document.getElementsByName("chkFlg")[i].value='0';
		}
	 	
 	}
	
}

function drugDtl(obj,index) 
{
	parentPopUp = obj;

	var strBalQtyDetail = document.getElementById("strCheckHidValue"+index).value;

	myArray = strBalQtyDetail.split("^");

/*
					 1- Item Id
					 2- Lab Sent Date
					 3- Sent Store Name
					 4- Generic Name
					 5-Brand Name
					 6- Batch
					 7-Exp Date
					 8-Transfer Qty
					 9-Store Id Sent
					 10-Item Id
					 11-Item Brand ID
					 12-Rate With Unit
					 13-Rate Base value
					 14-Consumed Qty
					 15=Consumed Qty Wit Unit
					 16-Qty Base Value
					 17-Item Sl No
					 18-Item Sl No
					 19-Catg Code
					 20- Lab Send No
					 21-Lab Name
					 22-CTR Number
					 23-Net Cost
					 24-PO No
					 25-PO Date
					 26-Mfd Date
					 27-Is Send Decode Value */


	var objVal1 = document.getElementById("1");
	
	if (myArray[23] != 'null' || myArray[23] != '') 
	{
		objVal1.innerHTML = myArray[23];
	} 
	else 
	{
		objVal1.innerHTML = "  ----";
	}

	var objVal2 = document.getElementById("2");

	if (myArray[24] != 'null' || myArray[24] != '') 
	{
		objVal2.innerHTML = myArray[24];
	} 
	else 
	{
		objVal2.innerHTML = "  ----";
	}


    var objVal3 = document.getElementById("3");

	if (myArray[6] != 'null' || myArray[6] != '') 
	{
		objVal3.innerHTML = myArray[6];
	} 
	else 
	{
		objVal3.innerHTML = "  ----";
	}
	
	var objVal4 = document.getElementById("4");

	if (myArray[25] != 'null' || myArray[25] != '') 
	{
		objVal4.innerHTML = myArray[25];
	} 
	else 
	{
		objVal4.innerHTML = "  ----";
	}
	
	var objVal5 = document.getElementById("5");

	if (myArray[26] != 'null' || myArray[26] != '') 
	{
		objVal5.innerHTML = myArray[26];
	} 
	else 
	{
		objVal5.innerHTML = "  ----";
	}
     
     

	display_popup_menu(parentPopUp, 'drugDtlId', '300', '');

}



function pageResetMethod()
{
	resetSampleDtlDiv();
	document.forms[0].reset();
	document.getElementById("itemCategoryDivId").innerHTML ="<select name='strItemCategoryId' class='comboNormal'>" +
		 			                                                   "<option title='Select Value' value='0'>Select Value</option></select>";
 		
 	document.getElementById("drugNameDivId").innerHTML ="<select name='strDrugBrandId' class='comboNormal'>" +
		 			                                                   "<option title='Select Value' value='0'>Select Value</option></select>";
    document.getElementById("batchNoDivId").innerHTML ="<select name='strBatchNo' class='comboNormal'>" +
		 			                                                   "<option title='Select Value' value='0'>Select Value</option></select>";
	//document.forms[0].strSalePrice.disabled = false;
	document.forms[0].strResendFlag.value='0';
	document.forms[0].strReSendMode.checked=false;
	document.forms[0].strViewMode.checked=false;
	document.getElementById("batchName").innerHTML = "Sample Details For Batch No : ";
	
}
  
 
 
 /**
  * cancelViewPage 
  */
  function cancelViewPage() {
  	
  	document.forms[0].hmode.value = "INITPAGE";
  	document.forms[0].submit();
  	
  } 
 
 

 
 
 /**
  * getInventoryDtls 
  */
  function validate1() 
  {
   	var hisValidator = new HISValidator("sampleSentTransBean");
	hisValidator.addValidation("strStoreId", "dontselect=0","Please Select a Store");
	hisValidator.addValidation("strItemCategoryId", "dontselect=0","Please Select a Category");
	hisValidator.addValidation("strDrugBrandId", "dontselect=0","Please Select a Drug");
	hisValidator.addValidation("strBatchNo", "dontselect=0","Please Select a Batch");
	hisValidator.addValidation("strSampleIssueQty", "req","Sample Issue Quantity is a Mandatory Field");
  	
 	hisValidator.addValidation("strSampleUnitId", "dontselect=0","Please Select an Unit");
 	hisValidator.addValidation("strLabId", "dontselect=0","Please Select an Lab Name");
 	//hisValidator.addValidation("strCTRNumber", "req","CTR Number is a Mandatory Field");
	hisValidator.addValidation("strSampleCodeNumber", "req","Sample Code is a Mandatory Field");
	hisValidator.addValidation("strRemarks", "req","Remarks is a Mandatory Field");
    hisValidator.addValidation("strRemarks", "maxlen=250","Remarks cannot be greater than 250 Characters");
		
 	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	
	if (retVal) 
	{
  	  if(document.forms[0].strSampleIssueQty.value!='0')
  	  {
  	  	          var conf = confirm("You Are Going To Save Records");
		          if(conf == true)
		          {
		               var conf1 = confirm("Are you sure !!!");
		               if(conf1 == true)
		               {	              
								    
					                document.forms[0].hmode.value="INSERT";
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
  	  	alert("Please Enter Sample Issue Quantity");
  	  	return false;
  	  }
  	    
  		
  	
	}else{
		
		return false;
	}
  	
  }
 
 
/**
 * getItemCategorys
 * @param {Object} strCombo 
 */
function getItemCategorys(strCombo) 
{
		if(document.forms[0].strPageMode.value=='ADD')
 		resetSampleDtlDiv();
 		 
 		if(strCombo.value!='0')
	    {
			var hmode = "GETITEMCATLIST"; 
			var url = "SampleSentTransCNT.cnt?hmode="+hmode+"&storeId="+strCombo.value;
 			ajaxFunction(url,"1");
	    }
	    else
	    {
	    	document.getElementById("itemCategoryDivId").innerHTML ="<select name='strItemCategoryId' class='comboNormal'>" +
		 			                                                   "<option title='Select Value' value='0'>Select Value</option></select>";
 		
 		     document.getElementById("drugNameDivId").innerHTML ="<select name='strDrugBrandId' class='comboNormal'>" +
		 			                                                   "<option title='Select Value' value='0'>Select Value</option></select>";
		    alert("Please Select HQ Name!!!");
		    return false;
	    }	
}
function setLabName()
{ 
	if(document.forms[0].strBatchNo[document.forms[0].strBatchNo.selectedIndex].value!='0')
	{
	 document.forms[0].strStoreName.value =  document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	 document.forms[0].strItemCategoryName.value =  document.forms[0].strItemCategoryId[document.forms[0].strItemCategoryId.selectedIndex].text;
	 document.forms[0].strItemCategoryCode.value =  document.forms[0].strItemCategoryId[document.forms[0].strItemCategoryId.selectedIndex].value;
	 document.forms[0].strLabName.value =  document.forms[0].strLabId[document.forms[0].strLabId.selectedIndex].text;
	 document.forms[0].strItemBrandId.value =  document.forms[0].strDrugBrandId[document.forms[0].strDrugBrandId.selectedIndex].value;
	 document.forms[0].strDrugName.value = document.forms[0].strDrugBrandId[document.forms[0].strDrugBrandId.selectedIndex].text;
	}
	else
	{
		alert("Please Select Batch No.");
		return false;
	}
}

function getQcDrugList() 
{
	
	if(document.forms[0].strPageMode.value=='ADD')
	resetSampleDtlDiv();
	
			var hmode = "GETQCDRUGLIST"; 
			var url = "SampleSentTransCNT.cnt?hmode="+hmode+"&storeId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+"&resenFlg="+document.forms[0].strResendFlag.value;
			ajaxFunction(url,"2");
	
}

function getDrugBatchList() 
{
    resetSampleDtlDiv(); 
	if(document.forms[0].strDrugBrandId[document.forms[0].strDrugBrandId.selectedIndex].value!='0')
	{
			var hmode = "GETQCDRUGBATCHLIST"; 
			var url = "SampleSentTransCNT.cnt?hmode="+hmode+"&strDrugBrandId="+document.forms[0].strDrugBrandId[document.forms[0].strDrugBrandId.selectedIndex].value+"&storeId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+"&resenFlg="+document.forms[0].strResendFlag.value;
			ajaxFunction(url,"3");
	}
	else
	{
		document.getElementById("batchNoDivId").innerHTML ="<select name='strBatchNo' class='comboNormal'>" +
		 			                                                   "<option title='Select Value' value='0'>Select Value</option></select>";
		   
		    return false;
	}		
	
}

function getDrugBatchDetails() 
{
	if(document.forms[0].strBatchNo[document.forms[0].strBatchNo.selectedIndex].value!='0')
	{
			var hmode = "GETQCDRUGBATCHDTL"; 
			var url = "SampleSentTransCNT.cnt?hmode="+hmode+"&strBatchNo="+document.forms[0].strBatchNo[document.forms[0].strBatchNo.selectedIndex].value+"&strDrugBrandId="+document.forms[0].strDrugBrandId[document.forms[0].strDrugBrandId.selectedIndex].value+"&storeId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+"&resenFlg="+document.forms[0].strResendFlag.value;
			//alert(url);
			ajaxFunction(url,"4");
	}
	else
	{
		document.getElementById("batchNoDivId").innerHTML ="<select name='strBatchNo' class='comboNormal'>" +
		 			                                                   "<option title='Select Value' value='0'>Select Value</option></select>";
		    alert("Please Select Batch!!!");
		    return false;
	}		
	
}

function getUnitCmb(itemId) 
{
	if(document.forms[0].strDrugBrandId[document.forms[0].strDrugBrandId.selectedIndex].value!='0')
	{
			var hmode = "GETUNITCMB"; 
			var url = "SampleSentTransCNT.cnt?hmode="+hmode+"&strDrugBrandId="+document.forms[0].strDrugBrandId[document.forms[0].strDrugBrandId.selectedIndex].value+"&storeId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+"&itemId="+itemId;
			ajaxFunction(url,"5");
	}
	else
	{
		document.getElementById("batchNoDivId").innerHTML ="<select name='strBatchNo' class='comboNormal'>" +
		 			                                                   "<option title='Select Value' value='0'>Select Value</option></select>";
		    alert("Please Select Drug Name!!!");
		    return false;
	}		
	
}
function printSampleSentLabel()
{	
	var  labSendNo  = document.forms[0].strLabSendNo.value
	var  ctrNo      = document.forms[0].strPCTRNo.value
	var  batchNo    = document.forms[0].strPBatchNo.value
	var  manuFacDate= document.forms[0].strPManufDate.value
	var  expDate    = document.forms[0].strPExpDate.value
	var  manuBy     = document.forms[0].strPManufBy.value
	var  drugName   = document.forms[0].strDrugName.value
	if(labSendNo!='0')
	{
      var mode="PRINTSAMPLESENTLABEL";
	  var url="SampleSentTransCNT.cnt?hmode="+mode+"&labSendNo="+labSendNo+"&ctrNo="+ctrNo+"&batchNo="+batchNo+"&manuFacDate="+manuFacDate+"&expDate="+expDate+"&manuBy="+manuBy+"&drugName="+drugName+"&strHiddenBatchDtl="+document.forms[0].strHiddenBatchDtl.value+"&labCode="+document.forms[0].strLabCode.value;
	  ajaxFunction(url,"6");
	} 
	
}
function resetSampleDtlDiv()
{
        objVal1 = document.getElementById("avQtyDivId");
		objVal2 = document.getElementById("mfgNameDivId");
		objVal3 = document.getElementById("mfgDateDivId");
		objVal4 = document.getElementById("expDateDivId");
		objVal5 = document.getElementById("poNoDateDivId");
		objVal6 = document.getElementById("SupplierNameDivId");
		objVal7 = document.getElementById("batchName");
		
		objVal1.innerHTML ="";
		objVal2.innerHTML ="";
		objVal3.innerHTML ="";
		objVal4.innerHTML ="";
		objVal5.innerHTML ="";
		objVal6.innerHTML ="";	
		objVal7.innerHTML = "Sample Details For Batch No : ";

}
function printSampleSentLabelView()
{	
	
	var size=document.getElementsByName("chkFlg").length;
	var strSampleSentHiddenDtlVal="0^0^0^0^0^0^0^0";
    for(var i=0;i<size;i++)
	{
			if(document.getElementsByName("chkFlg")[i].value=='1')
			{
			  strSampleSentHiddenDtlVal = strSampleSentHiddenDtlVal +"$$$$"+document.getElementById("strPrintLabelValue"+i).value.replace("%", " 0/0");
			} 
			
	}	
		//alert(strHiddenDtl);
	
	  var mode="PRINTSAMPLESENTLABELVIEW";
	  var url="SampleSentTransCNT.cnt?hmode="+mode+"&strSampleSentPrintHiddenDtl="+strSampleSentHiddenDtlVal;
	  //alert(url);
	  ajaxFunction(url,"8");
}
function genrateSampleSentHlp()
{	
   if(document.getElementsByName("strStoreId")[0].value=="0")
   {
		alert("Please Select Store From Combo");
		return false;
	}
	if(document.getElementsByName("strItemCategoryId")[0].value=="0")
	{
		alert("Please Select Item Category From Combo");
		return false;
	}
	
	
	
	if(document.getElementsByName("strFromDate")[0].value=="")
	{
		alert("From Date is a mandatory field");
		return false;
	}
	
	if(document.getElementsByName("strToDate")[0].value=="")
	{
		alert("To Date is a mandatory field");
		return false;
	}
	
	
	var diffdate = dateDiff1(document.forms[0].strFromDate.value,document.forms[0].strToDate.value); 
	//alert(diffdate);
	 if(parseInt(diffdate)>365)
	 {
		alert("Difference Between From Date and To Date Should not be greater than 365 days");
		return false;
	 }
	
	else
	{
		var mode="VIEWSAMPLESENT";
		var url="SampleSentTransCNT.cnt?hmode="+mode
		+"&storeId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value
		+"&fromDate="+document.forms[0].strFromDate.value
		+"&toDate="+document.forms[0].strToDate.value
		+"&labId="+document.forms[0].strLabId.value;
		
		ajaxFunction(url,"7");
	}
}

function getAjaxResponse(res, mode) 
{

	var objVal;
	if (mode == "1") 
	{

		objVal = document.getElementById("itemCategoryDivId");
		objVal.innerHTML = "<select name ='strItemCategoryId' class='comboNormal' >"+ res + "</select>";
		getQcDrugList();
	}
	if (mode == "2") 
	{

		objVal = document.getElementById("drugNameDivId");
		objVal.innerHTML = "<select name ='strDrugBrandId' class='comboMax' onChange='getDrugBatchList();'>"+ res + "</select>";
			
	}
	if (mode == "3") 
	{

		objVal = document.getElementById("batchNoDivId");
		objVal.innerHTML = "<select name ='strBatchNo' class='comboMax' onChange='getDrugBatchDetails();'>"+ res + "</select>";
		
	}
	if (mode == "4") 
	{
        document.forms[0].strHiddenBatchDtl.value = res+"^"+document.forms[0].strBatchNo[document.forms[0].strBatchNo.selectedIndex].value+"^"+document.forms[0].strDrugBrandId[document.forms[0].strDrugBrandId.selectedIndex].value+"^"+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value;
        document.getElementById("batchName").innerHTML = "Sample Details For Batch No : "+document.forms[0].strBatchNo[document.forms[0].strBatchNo.selectedIndex].value;
		/*
		  NVL(A.HSTNUM_INHAND_QTY,'''')||''^''||Mms_Mst.GET_SUPP_DTL(1,A.GNUM_HOSPITAL_CODE,HSTNUM_SUPPLIER_ID)||''^''||
          NVL(TO_CHAR(A.HSTDT_MANUF_DATE,''DD-Mon-YYYY''),'''')||''^''||NVL(TO_CHAR(A.HSTDT_EXPIRY_DATE,''DD-Mon-YYYY''),'''')||''^''||
          NVL(A.HSTNUM_PO_NO,'''')||''/''||NVL(TO_CHAR(A.HSTDT_PO_DATE,''DD-Mon-YYYY''),'''')||''^''||
          Mms_Mst.GET_SUPP_DTL(1,A.GNUM_HOSPITAL_CODE,A.HSTNUM_SUPPLIED_BY) ||''^''||A.HSTNUM_ITEM_ID
          ||''^''||HSTNUM_STOCK_STATUS_CODE||''^''||HSTNUM_INHAND_QTY||''^''|| HSTNUM_INHAND_QTY_UNITID  ||''^''|| HSTNUM_RATE  ||''^''||
          HSTNUM_RATE_UNITID  ||''^''|| HSTDT_MANUF_DATE   ||''^''|| HSTDT_EXPIRY_DATE    ||''^''||
          HSTNUM_SUPPLIER_ID  ||''^''|| HSTNUM_SUPPLIED_BY   ||''^''|| HSTNUM_PO_NO    ||''^''|| HSTDT_PO_DATE 
		 */
		objVal1 = document.getElementById("avQtyDivId");
		objVal2 = document.getElementById("mfgNameDivId");
		objVal3 = document.getElementById("mfgDateDivId");
		objVal4 = document.getElementById("expDateDivId");
		objVal5 = document.getElementById("poNoDateDivId");
		objVal6 = document.getElementById("SupplierNameDivId");
		
		objVal1.innerHTML =res.split("^")[0];
		objVal2.innerHTML =res.split("^")[1];
		objVal3.innerHTML =res.split("^")[2];
		objVal4.innerHTML =res.split("^")[3];
		objVal5.innerHTML =res.split("^")[4];
		objVal6.innerHTML =res.split("^")[5];
			getUnitCmb(res.split("^")[6]);
		
			
	}
    if (mode == "5") 
	{

		objVal = document.getElementById("unitDivId");
		objVal.innerHTML = "<select name ='strSampleUnitId' id ='strSampleUnitId' class='comboNormal'  onChange='calUnitBaseCost(this)'>"+ res + "</select>";
			
	}
	if (mode == "6") 
	{				
		
		objVal = document.getElementById("sampleSenlLabelDivId");
		objVal.innerHTML = res;
		popup('popUpDiv1', '100', '80');
		
		
	}
	if (mode == "7") 
	{

		objVal = document.getElementById("sampleSentViewHlpDivId");
		objVal.innerHTML = res;
		document.getElementById("showButtonID").style.display = "block";
		
			
	}
	if (mode == "8") 
	{				
		
		objVal = document.getElementById("sampleSenlLabelDivId");
		objVal.innerHTML = res;
		popup('popUpDiv1', '100', '80');
		
		
	}
	

}

function CheckedFlg(obj,index)
{

  if(obj.checked)
  {	 
	document.getElementById("chkFlg"+index).value='1';
  }
  else
  {
  	document.getElementById("chkFlg"+index).value='0';
  }
}

function clearViewPage()
{
	objVal = document.getElementById("sampleSentViewHlpDivId");
	objVal.innerHTML = "";
	document.getElementById("showButtonID").style.display = "none";
	document.forms[0].reset();
}
function hidePopup(mode)
{
		
		if(mode=='1')
		{		 
          document.getElementById("sampleSenlLabelDivId").innerHTML = "";			
		  hide_popup('popUpDiv1');
		} 
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
	 	 



function printData(mode) 
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
	  newwin.document.write(document.getElementById('sampleSenlLabelDivId').innerHTML);
	}
	
	
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

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

function getIssueRateUnitCombo()
{
	          
		document.forms[0].strUnitSaleID.value=document.forms[0].strUnitRateID.value;
} 