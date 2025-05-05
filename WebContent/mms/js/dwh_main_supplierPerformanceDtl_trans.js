
function getPoNoCombo()
{
	
	var url="SupplierPerformanceDtlTransCNT.cnt?hmode=getPoNoCmb&dwhId="+document.forms[0].strDrugWareHouseName.value;
   		 ajaxFunction(url,"1");   
}

function getChallanNo()
{
	var pono = document.forms[0].strPoNo.value.split("^")[0];
	var storeId = document.forms[0].strPoNo.value.split("^")[1];
	
	var url="SupplierPerformanceDtlTransCNT.cnt?hmode=getChallanNoCmb&dwhId="+document.forms[0].strDrugWareHouseName.value
	+"&pono="+pono
	+"&storeId="+storeId;
	
    ajaxFunction(url,"2");   
}

function getItemName()
{
	var pono = document.forms[0].strPoNo.value.split("^")[0];
	var storeId = document.forms[0].strPoNo.value.split("^")[1];
	var dwhId=	document.forms[0].strDrugWareHouseName.value;
	var challanNo = document.forms[0].strChallanNo.value;
	
	var url="SupplierPerformanceDtlTransCNT.cnt?hmode=getItemNameCmb&challanNo="+document.forms[0].strChallanNo.value
	+"&dwhId="+dwhId
	+"&pono="+pono
	+"&storeId="+storeId;
	
    ajaxFunction(url,"3");  
	
}


function getBatchCmb()
{
	var pono = document.forms[0].strPoNo.value.split("^")[0];
	var storeId = document.forms[0].strPoNo.value.split("^")[1];
	var dwhId=	document.forms[0].strDrugWareHouseName.value;
	var challanNo = document.forms[0].strChallanNo.value;
	
	var url="SupplierPerformanceDtlTransCNT.cnt?hmode=getBatchCmb&challanNo="+document.forms[0].strChallanNo.value
	+"&dwhId="+dwhId
	+"&pono="+pono                  
	+"&storeId="+storeId+"&itemBrandID="+document.forms[0].strItemId.value.split("#")[0];
	
    ajaxFunction(url,"5");  
	
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
       objVal.innerHTML = "<select name ='strPoNo' class='comboMax' onchange='getChallanNo();' >"+ res + "</select>";
    }  
    if(mode=="2")
    {
       var objVal = document.getElementById("challanNoComboDivId");
       objVal.innerHTML = "<select name ='strChallanNo' class='comboMax' onchange='getItemName();' >"+ res + "</select>";
    } 
   if(mode=="3")
    {
       var objVal = document.getElementById("itemComboDivId");
       objVal.innerHTML = "<select name ='strItemId' class='comboMax' onchange='getBatchCmb();' >"+ res + "</select>";
    } 
   if(mode=="4")
    {
       var objVal = document.getElementById("supplierDetailsViewId");
       objVal.innerHTML =  res;
    } 
    if(mode=="5")
    {
       var objVal = document.getElementById("batchComboDivId");
       objVal.innerHTML = "<select name ='strBatchNo' class='comboMax' >"+ res + "</select>";
       showQtyDivId();
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
			url = 'SupplierPerformanceDtlTransCNT.cnt?hmode=GETVIEWPAGE';
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
			var url="SupplierPerformanceDtlTransCNT.cnt?hmode=getSupplierPerformancePendingDtlView&dwhId="+document.forms[0].strDrugWareHouseName.value;
   		 	
		}
		else
		{
			var url="SupplierPerformanceDtlTransCNT.cnt?hmode=getSupplierPerformanceCompletedDtlView&dwhId="
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


function validate1()
{
	     var hisValidator = new HISValidator("supplierPerformanceDtlTransFB");
         
         
          hisValidator.addValidation("strDrugWareHouseName","dontselect=0","Please Select Drug Warehouse Name");
           hisValidator.addValidation("strPoNo","dontselect=0","Please Select PO No");
            hisValidator.addValidation("strChallanNo","dontselect=0","Please Select Challan No");
             hisValidator.addValidation("strItemId","dontselect=0","Please Select Drug Name");		
          hisValidator.addValidation("strBatchNo","dontselect=0","Please Select Batch");	
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
	document.getElementsByName("strStoreId")[0].value="0"
	document.forms[0].hmode.value = strTmp;
	document.forms[0].submit();
}

function showQtyDivId()
{
	if(document.getElementsByName("strItemId")[0].value!=0)
	{
		document.getElementById("showQtyDivId").style.display='';	
		
		document.getElementsByName("strOrderedQty")[0].value= document.forms[0].strItemId.value.split("#")[1];
		document.getElementById("strOrderedQtyDivId").innerHTML= document.forms[0].strItemId.value.split("#")[1];
		
		document.getElementsByName("strAcceptedQty")[0].value= document.forms[0].strItemId.value.split("#")[2];
		document.getElementsByName("strResetOrderedQty")[0].value	= document.forms[0].strItemId.value.split("#")[2];
	}
	else
	{
		document.getElementById("showQtyDivId").style.display='none';	
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
