
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

	JS Function used in committetype
**/
function getPOCombo()
{
        var mode = "GETPOCOMBO";
	
        var url ="SupplierPerformanceDtailRptCNT.cnt?hmode="+mode+"&supplierId="+document.forms[0].strSupplierId.value;
 		ajaxFunction(url,"5");

}
function getDrugCmb()
{
	var mode = "GETDRUGNAMECOMBO";
	
        var url ="SupplierPerformanceDtailRptCNT.cnt?hmode="+mode+"&groupCode="+document.forms[0].strGroupId.value;
 		ajaxFunction(url,"1");
}

function genrateSuppPerformanceDtlsHlp()
{
  	
       
	//document.getElementById("consolidatedPODetailDIV").innerHTML = ""; 
	//document.getElementById("consolidatedChallanDetailDIV").innerHTML = ""; 
	var mode="GETSUPPLIERPERFORMANCEDTL";
	var suppId=document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].value;
	var suppName=document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].text;
	var grpId =document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value;
	var poNumber = document.forms[0].strPoNumber[document.forms[0].strPoNumber.selectedIndex].value;
	var drugName=document.forms[0].strDrugId[document.forms[0].strDrugId.selectedIndex].text;
	
	if(suppId == 0)
		alert("Supplier Name is Mandatory !!");
	else
	{
		if(drugName=='All')
		{
		   var drugId='0^0';
		}
		else
		{
		  var drugId=document.forms[0].strDrugId[document.forms[0].strDrugId.selectedIndex].value;
		}
			
		var url="SupplierPerformanceDtailRptCNT.cnt?hmode="+mode+"&supplierId="+suppId+"&groupCode="+grpId+"&drugCode="+drugId.split("^")[1]+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value+"&suppName="+suppName+"&drugName="+drugName+"&poNumber="+poNumber;
		//alert("url :"+url);
		
		ajaxFunction(url,"2");
	}
  
}
/*
function getSuppPerformanceDtlPrint()
{
    var mode="GETSUPPPERFORMANCEDTLPRINT";
    var suppId=document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].value;
	var suppName=document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].text;
	var grpId =document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value;
	var drugId=document.forms[0].strDrugId[document.forms[0].strDrugId.selectedIndex].value;
	var drugName=document.forms[0].strDrugId[document.forms[0].strDrugId.selectedIndex].text;
    var strCheckHidValue=document.forms[0].strCheckHidValue.value;
	var url="SupplierPerformanceDtailRptCNT.cnt?hmode="+mode+"&supplierId="+suppId+"&groupCode="+grpId+"&drugCode="+drugId+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value+"&suppName="+suppName+"&drugName="+drugName+"&strCheckHidValue="+strCheckHidValue;
	alert("url :"+url);
	ajaxFunction(url,"4");
	
}
*/


// used in drug mst

function getZoneWiseBudgetDtlPrint() 
{	
	var heg_width = "width=700,height=400,left=200,top=200,scrollbars=yes";		
	var mode="GETZONEWISEBUDGETDTLPRINT";
    //var suppId=document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].value;
	//var suppName=document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].text;
	//var poNumber = document.forms[0].strPoNumber[document.forms[0].strPoNumber.selectedIndex].value;

   // var strCheckHidValue='0';
    //var retFlag = "0";
    
    //alert("Supplier ID:::"+suppId+"::Supp Name::"+suppName+"::Grp ID::"+grpId+"::drug ID::"+drugId.split("^")[1]+"::drug Name::"+drugName+"::strCheckHidValue::"+strCheckHidValue);
	
    //var chkValObj = document.getElementById("rptTypeId");
    
   // if(chkValObj.checked)
    	//retFlag = "1";
  //  else
    	//retFlag = "0";
    
    //alert(retFlag);
    
    var fromdate = document.getElementsByName("strStartFinancialYear")[0].value;
    var todate = document.getElementsByName("strEndFinancialYear")[0].value;
    //alert(fromdate);
    //alert(todate);
	var myPopup = window.open("Dwh_ZoneWiseBudgetRptCNT.cnt?hmode="+mode+ "&fromDate="+document.getElementsByName("strStartFinancialYear")[0].value+"&toDate="+document.getElementsByName("strEndFinancialYear")[0].value, 'popupWindow', heg_width);

}
function hideOpenDiv()
{
   objVal = document.getElementById("suppPerformanceDtlsHlpDivId");
	  objVal.innerHTML = ""; 
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

   if(mode=="1")
   {
	  // alert("res"+res);
      var objVal = document.getElementById("strDrugDivId");
      objVal.innerHTML = "<select name = 'strDrugId' class='comboMax' onChange='hideOpenDiv();'>" + res + "</select>";
      
      objVal = document.getElementById("suppPerformanceDtlsHlpDivId");
	  objVal.innerHTML = ""; 
      
      
   }  
	if (mode == "2") 
	{
		objVal = document.getElementById("suppPerformanceDtlsHlpDivId");
		objVal.innerHTML = res; 
		document.getElementById("showButtonID").style.display="block";
	}
	
	if (mode == "3") 
	{		
		objVal = document.getElementById("supplierPerformanceDtlsPopUpDivId");
		objVal.innerHTML = res;
		popup('popUpDiv1', '100', '80');		
	}
	if (mode == "4") 
	{				
		
		objVal = document.getElementById("suppPerformanceDtlsDivIdMain");
		objVal.innerHTML = res;
		popup('popUpDivMain', '100', '80');
		
		
	}
	
	 if(mode=="5")
   {
	  // alert("res"+res);
      var objVal = document.getElementById("strPODivId");
      objVal.innerHTML = "<select name = 'strPoNumber' class='comboMax' onChange='hideOpenDiv();'>" + res + "</select>";
      
      objVal = document.getElementById("suppPerformanceDtlsHlpDivId");
	  objVal.innerHTML = ""; 
      
      
   } 
}   

function hidePopup(mode)
{
		
		if(mode=='1')
		{		 
          document.getElementById("suppPerformanceDtlsDivIdMain").innerHTML = "";			
		  hide_popup('popUpDivMain');
		} 
//		if(mode=='2')
//		{
//		  	
//		  document.getElementById("poChallanDtlsDivId").innerHTML = "";
//		  hide_popup('popUpDiv2');
//		} 
//		if(mode=='3')
//		{		  
//		  document.getElementById("poChallanItemDtlsDivId").innerHTML = "";
//		  hide_popup('popUpDiv3');
//		}
//		if(mode=='4')
//		{
//		  document.getElementById("suppliedPOPrintDtlsDivId").innerHTML = "";
//		  hide_popup('popUpDiv4');
//		}
}
//	
//	
//

function printThis()
{
	var divObj = document.getElementById("saveId");
	
	divObj.style.display="none";
	window.print();
	divObj.style.display="block";
}

/**
 * Prints the report.
 * @return
 */
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
	
	/*
	if(mode=='1')
	{
	  newwin.document.write(document.getElementById('suppPerformanceDtlsDivIdMain').innerHTML);
	}*/
//	if(mode=='2')
//	{
//	  newwin.document.write(document.getElementById('poChallanDtlsDivId').innerHTML);
//	}
//	if(mode=='3')
//	{
//	  newwin.document.write(document.getElementById('poChallanItemDtlsDivId').innerHTML);
//	}
//	if(mode=='4')
//	{
//	  newwin.document.write(document.getElementById('suppliedPOPrintDtlsDivId').innerHTML);
//	}
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}	

//
//
//
//function GetIndex(index,endVal)  // Pagenation  One
//{
//	
//	    for (var page = 1; page <= endVal; page++)       // For Loop To Put Normal CSS in All No
//        {
//          document.getElementById('pg'+page).className = 'pg-normal';
//        }
//	    var oldPageAnchor = document.getElementById('pg'+index);   // Apply CSS
//        oldPageAnchor.className = 'pg-selected';
//        
//          for(var i = 1; i <= endVal ; i++)
//		  {
//			  document.getElementById("DivId"+i).style.display="none";
//		  }
//		  document.getElementById("DivId"+index).style.display="block";
//			 
//}
///**
// * 
// */
//function chkBoxClick(obj,index)
//{	  
//	  	  /* Value Pass in Web Row Set
//			    	   1. SUPPLIER NAME
//			    	   2. PO With PREFIX , 
//		               3. CATG NAME,
//		               4. PO TYPE 
//		               5. QU NO
//		               6. QU DATE 
//		               7. TENDER NO 
//		               8. TENDER DATE 
//		               9. SUPPLIER ADD 
//		               10.PO DATE
//		               11.TAX
//		               12.AMT  
//		               13.Store Id
//		               14. PO No
//			    	 */    	
//	    	 
//	   var hiddenVal = document.getElementById("strCheckHidValue"+index).value; 
//	   
//	   var StoreID = hiddenVal.split("^")[12];  	
//	   var PoNo    = hiddenVal.split("^")[13]; 
//	   
//	   // Set Selected Record Value For Show Report Method
//       document.forms[0].strProcRelatedValue.value = hiddenVal;
//	   
//	   genratePoChallanHlp(StoreID,PoNo);
//	         
//       	 
//       	
//      
//	
//}
//
//
//
//
//function view1(obj1,obj2,obj3)
//{
//	document.getElementById(obj1).style.display="none";
//	document.getElementById(obj2).style.display="block";
//	document.getElementById(obj3).style.display="block";
//	document.getElementById("existingDemandId").style.display="block";
//	document.getElementById("newDemandId").style.display="none";
//}
//function view2(obj1,obj2,obj3)
//{
//	document.getElementById(obj1).style.display="block";
//	document.getElementById(obj2).style.display="none";
//	document.getElementById(obj3).style.display="none";
//	document.getElementById("existingDemandId").style.display="none";
//	document.getElementById("newDemandId").style.display="block";
//}


function validate(){

	var hisValidator = new HISValidator("SupplierPerformanceDtailRptFB");

//		hisValidator.addValidation("strStartFinancialYear", "req","Start Financial Year is a mandatory field");

		hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

	if(retVal)
	{
		document.forms[0].strSupplierId.value =  document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].value;  
		document.forms[0].strSupplierName.value = document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].text;
	
		//document.forms[0].strEndFinancialYear.disabled=false;
		
		//document.forms[0].strEndFinancialYearTemp.value = document.forms[0].strEndFinancialYear.value;
			
		//document.forms[0].strEndFinancialYear.disabled=true;
	
	
		document.forms[0].hmode.value = "SHOWRPT";
		
			
				if(document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html")
				{
					document.forms[0].target = "_self";
				}
				else
				{
					document.forms[0].target = "_blank";
				}
		
		document.forms[0].submit();
	}
	 else{
			return false;
		}
}

function resetPage()
{
	objVal = document.getElementById("suppPerformanceDtlsHlpDivId");
	objVal.innerHTML = ""; 
	document.getElementById("showButtonID").style.display="none";
	document.forms[0].reset();
	
}	

function cancelPage(){
	//alert("inside cancel");
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();
	

}

function setEndFinancialYear()
{
	document.forms[0].strEndFinancialYear.value=parseInt(document.forms[0].strStartFinancialYear.value)+parseInt("1"); 
}




