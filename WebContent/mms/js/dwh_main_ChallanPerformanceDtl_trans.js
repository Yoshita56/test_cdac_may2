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
        objVal.innerHTML = "<select name ='strSupplierId' class='comboTooMax'> <option value='0'>Select Value</option></select>";
	    var objVal = document.getElementById("poNoComboDivId");
        objVal.innerHTML = "<select name ='strPoNo' class='comboTooMax'><option value='0'>Select Value</option></select>";
        var objVal = document.getElementById("itemComboDivId");
        objVal.innerHTML = "<select name ='strItemId' class='comboTooMax'><option value='0'>Select Value</option></select>";
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
        objVal.innerHTML = "<select name ='strSupplierId' class='comboTooMax'> <option value='0'>Select Value</option></select>";
	    var objVal = document.getElementById("poNoComboDivId");
        objVal.innerHTML = "<select name ='strPoNo' class='comboTooMax'><option value='0'>Select Value</option></select>";
        var objVal = document.getElementById("itemComboDivId");
        objVal.innerHTML = "<select name ='strItemId' class='comboTooMax'><option value='0'>Select Value</option></select>";
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
	var url="ChallanPerformanceCNT.cnt?hmode=CHALLANDTL&dwhId="+dwhId+"&pono="+pono+"&SupplierId="+document.forms[0].strSupplierId.value+"&ModifyFlg="+document.forms[0].strModifyFlag.value+"&ItemBrandID="+(document.forms[0].strItemId.value).split("^")[0];
   	ajaxFunction(url,"5");   
	
}

function getMultiRow(obj)
{
     	var noOfRow = document.forms[0].strNoOfMultiRow.value;
     	for(var i=0; i<noOfRow;i++)
     	{     		
     		addRows(new Array('strMultiRowChallanReceiveDate','strMultiRowChallanNo','strMultiRowInvoiceDate','strMultiRowBatchNo','strMultiRowReceivedQty','strMultiRowWhetherTestReportSubmitted','strMultiRowWhetherMedicinesInGoodCondition','strMultiRowWhetherSupplyNotForSale', 'strMultiRowWhetherBrandNameNotWritten','strMultiRowWhetherMRPPrint'),new Array('d','t','d','t','t','s','s','s','s','s'),'1','1','R')
     	}
 	
}
function getSupplierCombo()
{	
	document.getElementById("errMsg").innerHTML="";
	var url="ChallanPerformanceCNT.cnt?hmode=getSupplierCmb&dwhId="+document.forms[0].strDrugWareHouseName.value+"&ModifyFlg="+document.forms[0].strModifyFlag.value;
    
    ajaxFunction(url,"6");   
}


function getPoNoCombo()
{
	
	var url="ChallanPerformanceCNT.cnt?hmode=getPoNoCmb&dwhId="+document.forms[0].strDrugWareHouseName.value+"&SupplierId="+document.forms[0].strSupplierId.value+"&ModifyFlg="+document.forms[0].strModifyFlag.value;
   
    ajaxFunction(url,"1");   
}

function getChallanNo()
{
	var pono = document.forms[0].strPoNo.value.split("^")[0];
	var storeId = document.forms[0].strPoNo.value.split("^")[1];
	
	var url="ChallanPerformanceCNT.cnt?hmode=getChallanNoCmb&dwhId="+document.forms[0].strDrugWareHouseName.value
	+"&pono="+pono
	+"&storeId="+storeId;
	
    ajaxFunction(url,"2");   
}

function getItemName()
{
	var pono = document.forms[0].strPoNo.value;
	var dwhId=	document.forms[0].strDrugWareHouseName.value;	
	
	var url="ChallanPerformanceCNT.cnt?hmode=getItemNameCmb&dwhId="+dwhId+"&pono="+pono+"&SupplierId="+document.forms[0].strSupplierId.value+"&ModifyFlg="+document.forms[0].strModifyFlag.value;
    ajaxFunction(url,"3");  
	
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
       objVal.innerHTML = "<select name ='strPoNo' class='comboTooMax' onchange='getItemName();' >"+ res + "</select>";
    }  
    if(mode=="2")
    {
      
    } 
   if(mode=="3")
    {
       var objVal = document.getElementById("itemComboDivId");
       objVal.innerHTML = "<select name ='strItemId' class='comboTooMax' >"+ res + "</select>";
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
       showQtyDivId();
       document.forms[0].strPoNo.disabled=true;
       document.forms[0].strSupplierId.disabled=true;
	   document.forms[0].strDrugWareHouseName.disabled=true;
	   //document.forms[0].strChallanNo.disabled=true;
	   document.forms[0].strItemId.disabled=true;	
	   document.forms[0].strBeforeSaveFlg.value='1'; 
    } 
    if(mode=="6")
    {    
       var objVal = document.getElementById("supplierCmb");
       objVal.innerHTML = "<select name ='strSupplierId' class='comboTooMax' onchange='getPoNoCombo();' >"+ res + "</select>";
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
			url = 'ChallanPerformanceCNT.cnt?hmode=GETVIEWPAGE';
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
			var url="ChallanPerformanceCNT.cnt?hmode=getSupplierPerformancePendingDtlView&dwhId="+document.forms[0].strDrugWareHouseName.value;
   		 	
		}
		else
		{
			var url="ChallanPerformanceCNT.cnt?hmode=getSupplierPerformanceCompletedDtlView&dwhId="
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
	    document.forms[0].strItemId.disabled=false;	
	     var hisValidator = new HISValidator("challanPerformanceFB");
         
         
          hisValidator.addValidation("strDrugWareHouseName","dontselect=0","Please Select Drug Warehouse Name");
           hisValidator.addValidation("strPoNo","dontselect=0","Please Select PO No");
            hisValidator.addValidation("strChallanNo","dontselect=0","Please Select Challan No");
             hisValidator.addValidation("strItemId","dontselect=0","Please Select Drug Name");		
          
         // hisValidator.addValidation("strAcceptedQty","req", "Accepted Qty is a Mandatory Field" );
          //hisValidator.addValidation("strNewAcceptedQty","req", "New Accepted Qty is a Mandatory Field" );
          
          
  		 var retVal = hisValidator.validate(); 

          if(retVal)
          {
          		   var ChallanReceiveDate  = document.getElementsByName("strMultiRowChallanReceiveDate");         
	               var challanNo           = document.getElementsByName("strMultiRowChallanNo");    
	               var InvoiceDate         = document.getElementsByName("strMultiRowInvoiceDate");  	 	
      	 	       var batchNo             = document.getElementsByName("strMultiRowBatchNo");   
      	 	       var recevQty            = document.getElementsByName("strMultiRowReceivedQty"); 
      	 	               
		           var len = recevQty.length;
		           
			       var count = 0,j=0;		
			            
			       for(var i=0;i<len-1;i++)
			       {
			           	if(ChallanReceiveDate.value!="" && InvoiceDate.value!="" && challanNo[i].value!="" && batchNo[i].value!="" && recevQty[i].value!=""  && challanNo[i].value!="0" && batchNo[i].value!="0")
			          	{
			          		count++;		          		        	
			          	}		          	
			       }
			       
			       if(count == (len-1))
          		   {	
          		   	    hisValidator.addValidation("strMultiRowChallanReceiveDate", "dtltet="+document.forms[0].strCtDate.value, "Received Date Must be Less then Current Date." );
          		   	   	hisValidator.addValidation("strMultiRowWhetherTestReportSubmitted","dontselect=0","Please select a value from Whether Test Report Submitted Combo" );
		          		hisValidator.addValidation("strMultiRowWhetherMedicinesInGoodCondition","dontselect=0","Please select a value from Whether Medicines/Packaging are in good condition Combo" );
		          		hisValidator.addValidation("strMultiRowWhetherSupplyNotForSale","dontselect=0","Please select a value from Whether Rajsthan Govt. Supply Not for Sale & Logogram printed Combo" );
		          		hisValidator.addValidation("strMultiRowWhetherBrandNameNotWritten","dontselect=0","Please select a value from Brand Name Not Written Combo" );
		          		hisValidator.addValidation("strMultiRowWhetherMRPPrint","dontselect=0","Please select a value from Price(MRP) not printed/Visible Combo" );
			            var retVal1 = hisValidator.validate(); 
			            
			            if(retVal1)
			            {  
			            	
			            	var strDDeliveryDate = document.getElementsByName("strMultiRowChallanReceiveDate");
					    	var InvoiceDate      = document.getElementsByName("strMultiRowInvoiceDate"); 
					    	var poDate           = document.getElementsByName("strHiddenPODate");
					    	for(var nTmpI=0;nTmpI<strDDeliveryDate.length-1; nTmpI++)
							{
								poDate[nTmpI].value = document.getElementsByName("strHiddenPODate")[0].value;
							}
					    	
							for(var nTmpI=0;nTmpI<strDDeliveryDate.length-1; nTmpI++)
							{
								var nFlag = compareDate(trimAll(InvoiceDate[nTmpI].value),trimAll(strDDeliveryDate[nTmpI].value)); 
								
								if(nFlag.mode == 2)
								{
									alert("Received Date must be greater then Invoice Date.");
									return;
								}
								
								var nFlag = compareDate(trimAll(poDate[nTmpI].value),trimAll(InvoiceDate[nTmpI].value)); 
								
								if(nFlag.mode == 2)
								{
									alert("Invoice Date must be greater then PO Date.");
									return;
								}
							}
										           
									  var conf = confirm("You Are Going To Save Records");
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
          		  		alert("Please Enter Received Date , Invoice No , Invoice Date , Batch No & Item Received Qty!!!!");
          		  		ChallanReceiveDate[0].focus();
          			    retVal = false;
          		  	}
	      }
          else
          {
             return false;
          }
	  }
	  else
	  {
	  	alert("Please Enter Challan Details!!");
	  	return false;
	  }
}



function validate1()
{
	     var hisValidator = new HISValidator("ChallanPerformanceFB");
         
         
          hisValidator.addValidation("strDrugWareHouseName","dontselect=0","Please Select Drug Warehouse Name");
           hisValidator.addValidation("strPoNo","dontselect=0","Please Select PO No");
            hisValidator.addValidation("strChallanNo","dontselect=0","Please Select Challan No");
             hisValidator.addValidation("strItemId","dontselect=0","Please Select Drug Name");		
          
          hisValidator.addValidation("strAcceptedQty","req", "Accepted Qty is a Mandatory Field" );
          
          
          
	   //       hisValidator.addValidation("strReportNumber","req", "Report Number is a Mandatory Field" );
	  //        hisValidator.addValidation("strReportDate","req", "Report Date is a Mandatory Field" );
	         
          
     //     hisValidator.addValidation("strReportDate","dtltet="+document.forms[0].strCtDate.value, "Report Date should be less than equal to Current date" );
          
          hisValidator.addValidation("strPageNo","req", "Page No. of Stock Register where entry has been made is a Mandatory Field" );
                    
          hisValidator.addValidation("strRemarks", "maxlen=250", "Remarks should have less than or equal to 250 Characters" );
 
          
            
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
