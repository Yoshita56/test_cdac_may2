function setFlag(obj)
{ 	
	if(obj.checked)
	{
		document.getElementById("errMsg").innerHTML="";
		document.getElementById("normalMsg").innerHTML="";
		document.forms[0].strBeforeSaveFlg.value='0'; 
		document.forms[0].strModifyFlag.value="1";
		obj.checked = true;
		document.forms[0].strDrugWareHouseName.value='0';
		document.forms[0].strPoNo.disabled=false;
        document.forms[0].strSupplierId.disabled=false;
	    document.forms[0].strDrugWareHouseName.disabled=false;
	    document.forms[0].strItemId.disabled=false;		    
	    var objVal = document.getElementById("supplierCmb");
        objVal.innerHTML = "<select name ='strSupplierId' class='comboMax'> <option value='0'>Select Value</option></select>";
	    var objVal = document.getElementById("poNoComboDivId");
        objVal.innerHTML = "<select name ='strPoNo' class='comboMax'><option value='0'>Select Value</option></select>";
        var objVal = document.getElementById("itemComboDivId");
        objVal.innerHTML = "<select name ='strItemId' class='comboMax'><option value='0'>Select Value</option></select>";
        var objVal = document.getElementById("challanDetails");
        objVal.innerHTML =  "";
        document.getElementById("showQtyDivId").style.display='none';	
        var objVal = document.getElementById("id1");
        objVal.innerHTML =  "";  
        document.getElementById("showQtyDivId").style.display='none';	
		document.getElementById("showQtyDivId1").style.display='none';	  
	}
	else
	{
		document.forms[0].strModifyFlag.value="0";
		obj.checked = false;
		document.getElementById("errMsg").innerHTML="";
		document.getElementById("normalMsg").innerHTML="";
		document.forms[0].strDrugWareHouseName.value='0';
		document.forms[0].strBeforeSaveFlg.value='0'; 
		document.forms[0].strPoNo.disabled=false;
        document.forms[0].strSupplierId.disabled=false;
	    document.forms[0].strDrugWareHouseName.disabled=false;
	    document.forms[0].strItemId.disabled=false;		    
	    var objVal = document.getElementById("supplierCmb");
        objVal.innerHTML = "<select name ='strSupplierId' class='comboMax'> <option value='0'>Select Value</option></select>";
	    var objVal = document.getElementById("poNoComboDivId");
        objVal.innerHTML = "<select name ='strPoNo' class='comboMax'><option value='0'>Select Value</option></select>";
        var objVal = document.getElementById("itemComboDivId");
        objVal.innerHTML = "<select name ='strItemId' class='comboMax'><option value='0'>Select Value</option></select>";
        var objVal = document.getElementById("challanDetails");
        objVal.innerHTML =  "";
        document.getElementById("showQtyDivId").style.display='none';	
        var objVal = document.getElementById("id1");
        objVal.innerHTML =  "";
        document.getElementById("showQtyDivId").style.display='none';	
		document.getElementById("showQtyDivId1").style.display='none';	
	}
    	
}

function calQty()
{
	var obj1 = document.getElementsByName("strMultiRowReceivedQty");	
	var       totQty = 0;
    var   totItemLen = document.getElementsByName("strMultiRowReceivedQty").length;
	var      itemQty = document.getElementsByName("strMultiRowReceivedQty");	
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
	document.forms[0].strNewAcceptedQty.value = totQty;
		
}
function getChallanDetails()
{		
	document.getElementById("id1").innerHTML="";
	var pono = document.forms[0].strPoNo.value;	
	var dwhId=	document.forms[0].strDrugWareHouseName.value;	
	var challanNo = document.forms[0].strChallanNo.value;	
	  var hisValidator = new HISValidator("challanModificationTransFB");
         
         
      hisValidator.addValidation("strDrugWareHouseName",		"dontselect=0","Please Select DDW Name");
      hisValidator.addValidation("strPoNo",             		"dontselect=0","Please Select PO No");
      hisValidator.addValidation("strChallanNo",        		"dontselect=0","Please Select Challan No");
      hisValidator.addValidation("strSupplierId",       		"dontselect=0","Please Select Supplier Name");    
      var retVal = hisValidator.validate(); 
      hisValidator.clearAllValidations();
      if(retVal)
      {
		var url="ChallanModificationTransCNT.cnt?hmode=CHALLANDTL&dwhId="+dwhId+"&pono="+pono+"&SupplierId="+document.forms[0].strSupplierId.value+"&ModifyFlg="+document.forms[0].strModifyFlag.value+"&challanNo="+challanNo;
	   	ajaxFunction(url,"5");
      }
	 
	
}

function getMultiRow(obj)
{
     	var noOfRow = document.forms[0].strNoOfMultiRow.value;
     	for(var i=0; i<noOfRow;i++)
     	{     		
     		addRows(new Array('strMultiRowBatchNo','strMultiRowReceivedQty','strMultiRowRejectedQty','strMultiRowBreakageQty','strMultiRowExcessQty','strMultiRowExpireDate','strMultiRowManufacterDate','strMultiRowPerformanceDtlEntry'),new Array('t','t','t','t','t','d','d','t'),'1','1','R')
     	}
 	
}
function getSupplierCombo()
{	
	document.getElementById("errMsg").innerHTML="";
	var url="ChallanModificationTransCNT.cnt?hmode=getSupplierCmb&dwhId="+document.forms[0].strDrugWareHouseName.value+"&ModifyFlg="+document.forms[0].strModifyFlag.value;
   
    ajaxFunction(url,"6");   
}


function getPoNoCombo()
{
	
	var url="ChallanModificationTransCNT.cnt?hmode=getPoNoCmb&dwhId="+document.forms[0].strDrugWareHouseName.value+"&SupplierId="+document.forms[0].strSupplierId.value+"&ModifyFlg="+document.forms[0].strModifyFlag.value;
   
    ajaxFunction(url,"1");   
}

function getChallanNo()
{
	var    pono = document.forms[0].strPoNo.value;
	var storeId = document.forms[0].strDrugWareHouseName.value;
	
	var url="ChallanModificationTransCNT.cnt?hmode=getChallanNoCmb&dwhId="+document.forms[0].strDrugWareHouseName.value
	+"&pono="+pono
	+"&storeId="+storeId;
	
    ajaxFunction(url,"2");   
}

function getChallanCombo()
{
	var pono = document.forms[0].strPoNo.value;
	var dwhId=	document.forms[0].strDrugWareHouseName.value;	
	var supplierId = document.forms[0].strSupplierId.value;
	
	var url="ChallanModificationTransCNT.cnt?hmode=getChallanNoCmb&dwhId="+dwhId+"&pono="+pono+"&SupplierId="+document.forms[0].strSupplierId.value+"&ModifyFlg="+document.forms[0].strModifyFlag.value;
   
    ajaxFunction(url,"3");  
	
}
function drugDtl(obj,index) 
{
	var url="ChallanModificationTransCNT.cnt?hmode=SUPPLIERPERPOPUP&index="+index+"&strMultiRowPerformanceDtlEntry="+document.getElementById("strMultiRowPerformanceDtlEntry"+index).value;
    ajaxFunction(url,"7"); 
	    
}

function getAjaxResponse(res,mode)
{
      var err = document.getElementById("errMsg");
      var temp = res.split("####");
      if(temp[0] == "ERROR")
	   {
          	err.innerHTML = temp[1];
          	return;
       } 

    if(mode=="1")
    {
       var objVal = document.getElementById("poNoComboDivId");
       objVal.innerHTML = "<select name ='strPoNo' class='comboMax' onchange='getChallanCombo();' >"+ res + "</select>";
    }  
    if(mode=="2")
    {
      
    } 
   if(mode=="3")
    {
       var objVal = document.getElementById("challanComboDivId");
       objVal.innerHTML = "<select name ='strChallanNo' class='comboMax' >"+ res + "</select>";
    } 
   if(mode=="4")
    {
       var objVal = document.getElementById("supplierDetailsViewId");
       objVal.innerHTML =  res;
    }    
    if(mode=="5")
    {
       var objVal = document.getElementById("challanDetails");
       objVal.innerHTML =  res;       
       document.forms[0].strPoNo.disabled=true;
       document.forms[0].strSupplierId.disabled=true;
	   document.forms[0].strDrugWareHouseName.disabled=true;
	   document.forms[0].strChallanNo.disabled=true;	
	   document.getElementById("goImage").style.display="none";   
	  
	   document.forms[0].strChallanValue.value = document.forms[0].strChallanNo.value;
	   
	   
    } 
    if(mode=="6")
    {        
       var objVal = document.getElementById("supplierCmb");
       objVal.innerHTML = "<select name ='strSupplierId' class='comboMax' onchange='getPoNoCombo();' >"+ res + "</select>";
    } 
    if (mode == "7") 
	{
				
		objVal = document.getElementById("supplierPerformanceDtlsDivId");
		objVal.innerHTML = res;		
		popup('popUpDiv1', '260', '180');	
		
		
	}
 
   
}

function checkUpdateMode(obj)
{
  
   var passValue = obj.value;
   document.forms[0].strPrevHiddenChallanValue.value = 	passValue;  
   document.forms[0].strBatchNo.value=passValue.split("$")[1]; 
   document.forms[0].strAcceptedQuantity.value=passValue.split("$")[2];
   document.forms[0].strRejectedQuantity.value=passValue.split("$")[4];
   document.forms[0].strBreakageQuantity.value=passValue.split("$")[3];
   document.forms[0].strExcessQty.value=passValue.split("$")[5];
   document.forms[0].strManufactureDate.value=passValue.split("$")[6];
   document.forms[0].strExpiryDate.value=passValue.split("$")[7];
      
  
   
   document.getElementById("orderQty").innerHTML      = (passValue.split("$")[9]).split("^")[0] +" "+passValue.split("$")[8];
   document.getElementById("acceptedQty").innerHTML   = (passValue.split("$")[9]).split("^")[1]+" "+passValue.split("$")[8];
   document.getElementById("rejectedQty").innerHTML   = (passValue.split("$")[9]).split("^")[2]+" "+passValue.split("$")[8]; 
   document.getElementById("currentAvlQty").innerHTML =  passValue.split("$")[12]+" "+passValue.split("$")[8];    
   
   document.getElementsByName("strWhetherMedicinesWithTestReport")[0].value  = (passValue.split("$")[10]).split("^")[0];
   document.getElementsByName("strWhetherMedicinesInGoodCondition")[0].value = (passValue.split("$")[10]).split("^")[1];
   document.getElementsByName("strWhetherSupplyNotForSale")[0].value         = (passValue.split("$")[10]).split("^")[2];
   document.getElementsByName("strWhetherBrandNameNotWritten")[0].value      = (passValue.split("$")[10]).split("^")[3];
   document.getElementsByName("strWhetherMRPPrint")[0].value                 = (passValue.split("$")[10]).split("^")[4];
   
   document.getElementById("modifyDtl").style.display="block";
    document.forms[0].strBeforeSaveFlg.value='1'; 
}
function save(index)
{

    var        testReport = document.getElementsByName("strDivMultiRowWhetherTestReportSubmitted")[0].value;
    var medicenInGoodCond = document.getElementsByName("strDivMultiRowWhetherMedicinesInGoodCondition")[0].value;
    var     supplyForSale = document.getElementsByName("strDivMultiRowWhetherSupplyNotForSale")[0].value;
    var      brandWritten = document.getElementsByName("strDivMultiRowWhetherBrandNameNotWritten")[0].value;
    var          mrpPrint = document.getElementsByName("strDivMultiRowWhetherMRPPrint")[0].value;
    
    var        testReportVar;
    var        medicenInGoodCondVar;
    var        supplyForSaleVar;
    var        brandWrittenVar;
    var        mrpPrintVar; 
    
    if(parseInt(testReport)==1)
    {
    	testReportVar = "Y";
    }
    else
    {
    	testReportVar = "N";
    }
    if(parseInt(medicenInGoodCond)==1)
    {
    	medicenInGoodCondVar = "Y";
    }
    else
    {
    	medicenInGoodCondVar = "N";
    }
    if(parseInt(supplyForSale)==1)
    {
    	supplyForSaleVar = "Y";
    }
    else
    {
    	supplyForSaleVar = "N";
    }
    if(parseInt(brandWritten)==1)
    {
    	brandWrittenVar = "Y";
    }
    else
    {
    	brandWrittenVar = "N";
    }
    if(parseInt(mrpPrint)==1)
    {
    	mrpPrintVar = "Y";
    }
    else
    {
    	mrpPrintVar = "N";
    }
    
    document.getElementById("orignalDtl"+index).innerHTML=testReportVar+","+medicenInGoodCondVar+","+supplyForSaleVar+","+brandWrittenVar+","+mrpPrintVar;
    document.getElementById("strMultiRowPerformanceDtlEntry"+index).value=testReport+"^"+medicenInGoodCond+"^"+supplyForSale+"^"+brandWritten+"^"+mrpPrint;
    
  	hidePopup_ajex(1);
}
function hideDrugDetails(divId) 
{
	hide_popup_menu(divId);
}


function hidePopup_ajex(mode)
{	
		if(mode=='1')
		{		 
          //document.getElementById("supplierPoDtlsDivId").innerHTML = "";			
		  hide_popup('popUpDiv1');
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
	 	 
	 	
//To open View Page
function openViewPage()
{
	viewData(document.forms[0]);
	document.getElementsByName("strViewCheckBox")[0].checked=false;
}

function viewData(form1) //View Page
{

	var chkObj = document.getElementsByName("strViewCheckBox")[0];
	
	

	if (chkObj.checked != true) 
	{
		
		return false;
	}
	
	else
		{
			url = 'ChallanModificationTransCNT.cnt?hmode=GETVIEWPAGE';
			window.open(url, "popupWindow",	"width=1000,height=600,top=250,left=150,scrollbars=yes");
		}
	
}

function getDateDiv()
{
	if(document.getElementsByName("strReportType")[0].value=='2')
	{
		document.getElementById("completedReportDivId").style.display='';
	}
	else
	{
		document.getElementById("completedReportDivId").style.display='none';
	}
	
}


function getSupplierPerformanceDetailsView()		//View Page
{
	if(document.getElementsByName("strDrugWareHouseName")[0].value=="0")
	{
		alert("Select DDW Name");
		document.getElementsByName("strDrugWareHouseName")[0].focus();
		return false;
	}
	
	if(document.getElementsByName("strReportType")[0].value=='2')
	{
		if(document.getElementsByName("strFromDate")[0].value=='')
		{
			alert("Select From Date");
			document.getElementsByName("strFromDate")[0].focus();
			return false;
		}
		
		if(document.getElementsByName("strToDate")[0].value=='')
		{
			alert("Select To Date");
			document.getElementsByName("strToDate")[0].focus();
			return false;
		}
	}
		
		if(document.getElementsByName("strReportType")[0].value=='1')
		{
			var url="ChallanModificationTransCNT.cnt?hmode=getSupplierPerformancePendingDtlView&dwhId="+document.forms[0].strDrugWareHouseName.value;
   		 	
		}
		else
		{
			var url="ChallanModificationTransCNT.cnt?hmode=getSupplierPerformanceCompletedDtlView&dwhId="
			+document.forms[0].strDrugWareHouseName.value
			+"&fromDate="+document.forms[0].strFromDate.value
			+"&toDate="+document.forms[0].strToDate.value;
			
   		 	
		}		
		ajaxFunction(url,"4");   
	
}


function showReportNoAndDate()
{
	if(document.getElementsByName("strWhetherMedicinesWithTestReport")[0].checked==true)
	{
		document.getElementById("showReportId").style.display='';
	}
	
	if(document.getElementsByName("strWhetherMedicinesWithTestReport")[1].checked==true)
	{
		document.getElementById("showReportId").style.display='none';
	}
}

function setDefaultValues()
{

	document.getElementsByName("strWhetherTestReportSubmitted")[0].checked=true;
	document.getElementsByName("strWhetherMedicinesInGoodCondition")[0].checked=true;
	document.getElementsByName("strWhetherSupplyNotForSale")[0].checked=true;
	document.getElementsByName("strWhetherBrandNameNotWritten")[0].checked=true;
	document.getElementsByName("strWhetherMRPPrint")[0].checked=true;
	
		
}


function validate2()
{
	  if(document.forms[0].strBeforeSaveFlg.value=='1')
	  {
	  	
	  	document.forms[0].strPoNo.disabled=false;
        document.forms[0].strSupplierId.disabled=false;
	    document.forms[0].strDrugWareHouseName.disabled=false;
	    document.forms[0].strChallanNo.disabled=false;	
	    
	     var hisValidator = new HISValidator("challanModificationTransFB");
         
         
          hisValidator.addValidation("strDrugWareHouseName",		"dontselect=0","Please Select DDW Name");
          hisValidator.addValidation("strPoNo",             		"dontselect=0","Please Select PO No");
          hisValidator.addValidation("strChallanNo",        		"dontselect=0","Please Select Challan No");
          hisValidator.addValidation("strSupplierId",       		"dontselect=0","Please Select Supplier Name");    
          		
          hisValidator.addValidation("strSupplierChallanNo","req",   "Challan/Invoice No. is a Mandatory Field" );
          if(document.forms[0].strSupplierChallanNo.value=='0')
          {
          	alert("Challan/Invoice No should not be zero!!!");
          	return false;
          }
          hisValidator.addValidation("strSupplierChallanDate", "req","Invoice Date is a Mandatory Field");
          hisValidator.addValidation("strChallanReceiveDate", "req", "Received Date is a Mandatory Field");          
          hisValidator.addValidation("strBatchNo","req",             "Batch No is a Mandatory Field" );
          hisValidator.addValidation("strAcceptedQuantity","req",    "Accepted Qty is a Mandatory Field" );          
          hisValidator.addValidation("strManufactureDate", "req",    "Manufactrer Date is a Mandatory Field");
          hisValidator.addValidation("strExpiryDate", "req",         "Expiry Date is a Mandatory Field");
          hisValidator.addValidation("strRemarks", "req",            "Remarks is a Mandatory Field" );
          hisValidator.addValidation("strRemarks", "maxlen=250",     "Remarks should have less than or equal to 250 Characters" );
          
  		  var retVal = hisValidator.validate(); 
          hisValidator.clearAllValidations();
          if(retVal)
          {
          		               
	                    var poDate              = (document.forms[0].strChallanDetails.value).split("^")[1];               
		           
          		   	    hisValidator.addValidation("strChallanReceiveDate",     "dtltet="+document.forms[0].strCtDate.value, "Received Date Must be Less then or Equal to Current Date." );
          		   	    hisValidator.addValidation("strChallanReceiveDate",     "dtgtet="+poDate,"Received Date should be Greater than or Equal to  PO Date");
          		   	    hisValidator.addValidation("strSupplierChallanDate",    "dtgtet="+poDate,"Invoice Date should be Greater than or Equal to PO Date");
          		   	    hisValidator.addValidation("strChallanReceiveDate",     "dtgtet="+document.forms[0].strSupplierChallanDate.value,"Received Date should be Greater than or Equal to Invoice Date");
          		   	    hisValidator.addValidation("strChallanReceiveDate",     "dtltet="+document.forms[0].strCtDate.value, "Received Date Must be Less then or Equal to Current Date." );
          		   	    
          		   	    hisValidator.addValidation("strManufactureDate", "dtltet="+document.forms[0].strCtDate.value,"Manufacture Date should be Less then or Equal to Current Date");
          		   	   // hisValidator.addValidation("strExpiryDate", "dtgtet="+document.forms[0].strCtDate.value,"Expiry Date should be Greater than or Equal to Current Date"); 		
					    hisValidator.addValidation("strExpiryDate", "dtgt="+document.forms[0].strManufactureDate.value,"Expiry Date should be Greater than Manufacture Date"); 		

          		   	   
 			            var retVal1 = hisValidator.validate(); 
			            hisValidator.clearAllValidations();
			            if(retVal1)
			            {  			            	
							  
							   var challanNo = document.forms[0].strChallanValue.value.split("^")[0];
							   var passValue = document.forms[0].strPrevHiddenChallanValue.value;  
							  
							   var oldAcceptedQty = passValue.split("$")[2];
							   var currentAvlQty  = passValue.split("$")[12];
							  
							   if(parseInt(oldAcceptedQty)>parseInt(currentAvlQty))
							   {
							   	    alert("Current Avl. Quantity [ "+currentAvlQty+" No.] should be Greater than or Equal to Old Accepted Quantity ["+oldAcceptedQty+" No.]");
							   		return false;
							   }
							   
							   var passValue2 = document.forms[0].strChallanDetails.value;  
							   
							   var totalOrderQty     =  parseInt((passValue.split("$")[9]).split("^")[0]);
							   var totalAcceptedQty  =  parseInt((passValue.split("$")[9]).split("^")[1]);
							   var totalRejectedQty  =  parseInt((passValue.split("$")[9]).split("^")[2]); 
							   
							   var newAccepQty       =  parseInt(document.forms[0].strAcceptedQuantity.value);
							   if((document.forms[0].strRejectedQuantity.value).length>0)
							   {
							    var newRejectedQty    =  parseInt(document.forms[0].strRejectedQuantity.value);
							   }
							   else
							   {
							   	var newRejectedQty    =  parseInt("0");
							   } 
							   		   	
							   	var totVerfVal = newAccepQty + newRejectedQty + totalAcceptedQty + totalRejectedQty;  	
							    	
							   	if(totVerfVal > totalOrderQty)
							   	{
							   		
							   		alert("Sum of New Accepted ,New Rejected ,Total Accepted and Total Rejected Qty should not be Greater than Order Quantity "+totalOrderQty+" No.");
							   		return false;
							   	}
							   	
								
										           
									  var conf = confirm("You Are Going To Save Challan No.[ "+challanNo+"  ] Detail(s)!!!");
					                  if(conf == true)
					                  {
					                       var conf1 = confirm("Are you sure !!!");
					                       if(conf1 == true)
					                       {
					                          document.forms[0].hmode.value = "SAVECHALLANDTL";
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
          		  	
	      }
          else
          {
             return false;
          }
	  }
	  else
	  {
	  	alert("Please Verify at least Single Drug!!");
	  	return false;
	  }
}



function validate1()
{
	     var hisValidator = new HISValidator("challanModificationTransFB");
         
         
          hisValidator.addValidation("strDrugWareHouseName","dontselect=0","Please Select Drug Warehouse Name");
           hisValidator.addValidation("strPoNo","dontselect=0","Please Select PO No");
            hisValidator.addValidation("strChallanNo","dontselect=0","Please Select Challan No");
             hisValidator.addValidation("strItemId","dontselect=0","Please Select Drug Name");		
          
          hisValidator.addValidation("strAcceptedQty","req", "Accepted Qty is a Mandatory Field" );
          
          
          
	   //       hisValidator.addValidation("strReportNumber","req", "Report Number is a Mandatory Field" );
	  //        hisValidator.addValidation("strReportDate","req", "Report Date is a Mandatory Field" );
	         
          
     //     hisValidator.addValidation("strReportDate","dtltet="+document.forms[0].strCtDate.value, "Report Date should be less than equal to Current date" );
          
          hisValidator.addValidation("strPageNo","req", "Page No. of Stock Register where entry has been made is a Mandatory Field" );
                    
         
 
          
            
 		 var retVal = hisValidator.validate(); 

          if(retVal)
          {
          		if(document.getElementsByName("strAcceptedQty")[0].value == 0)
          		{
          			alert("Please Enter Accepted Qty Greater than 0 ");
          			document.getElementsByName("strAcceptedQty")[0].focus();
           			return false;
          		}
          
          		if(document.getElementsByName("strPageNo")[0].value==0)
           		{
           		alert("Please Enter Page No. greater than 0 ");
           		document.getElementsByName("strPageNo")[0].focus();
           		return false;
           		}       
				          							           
							          var conf = confirm("You Are Going To Save Records");
					                  if(conf == true)
					                  {
					                       var conf1 = confirm("Are you sure !!!");
					                       if(conf1 == true)
					                       {
					                          document.forms[0].hmode.value = "SAVE";
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


function cancelPage()
{
	document.forms[0].hmode.value = "CANCELPAGE";
	document.forms[0].submit();
}


function clearMsg(strTmp)
{
	document.getElementsByName("strStoreId")[0].value="0";
	document.getElementsByName("strModifyFlag")[0].value="0";
	document.forms[0].strBeforeSaveFlg.value="0"; 
	document.forms[0].hmode.value = strTmp;
	document.forms[0].submit();
}

function showQtyDivId()
{
	if(document.getElementsByName("strItemId")[0].value!=0)
	{
		document.getElementById("showQtyDivId").style.display='';	
		document.getElementById("showQtyDivId1").style.display='';	
		
		document.getElementsByName("strOrderQty")[0].value= document.forms[0].strItemId.value.split("^")[1];
		//document.getElementById("strOrderedQtyDivId").innerHTML= document.forms[0].strItemId.value.split("^")[1];
		
		document.getElementsByName("strAcceptedQty")[0].value= document.forms[0].strItemId.value.split("^")[2];
		document.getElementsByName("strNewAcceptedQty")[0].value	= document.forms[0].strItemId.value.split("^")[2];
	}
	else
	{
		document.getElementById("showQtyDivId").style.display='none';	
		document.getElementById("showQtyDivId1").style.display='none';	
	}	
	
}



function chkAcceptedQtyLessThanOrderedQty()
{
	if(document.getElementsByName("strAcceptedQty")[0].value > document.getElementsByName("strOrderedQty")[0].value)
	{
		alert("Accepted Qty Should be less than equal to the Ordered Qty");
		document.getElementsByName("strAcceptedQty")[0].value	=	document.getElementsByName("strResetOrderedQty")[0].value;
		return false;
	}
}
