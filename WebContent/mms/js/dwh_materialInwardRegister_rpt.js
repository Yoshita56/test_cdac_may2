/**

	JS Function used in committetype
**/
function setValueChk(chkObj)
{
    
    if(chkObj.value =='1')
	 {
	    document.getElementsByName("strPoType")[1].checked=false;
		document.getElementsByName("strPoType")[2].checked=false;	// Annual PO 	
     }
    else if(chkObj.value =='2')
 	{ 
	   // document.getElementsByName("strPoType")[0].checked=false;
	    //document.getElementsByName("strPoType")[2].checked=false;	// Local PO
	 	
	}
	else
	{
		document.getElementsByName("strPoType")[0].checked=false;
	    document.getElementsByName("strPoType")[1].checked=false;	// All PO
	}
}

function onRadio(obj)
{
	obj.checked=true;
	document.getElementById("consolidatedPODetailDIV").innerHTML = ""; 
	document.getElementById("consolidatedChallanDetailDIV").innerHTML = ""; 
	if(obj.value=="1")
	{
	  document.forms[0].strDateTypeFlg.value = "1";
	}  
	else
	{
	  document.forms[0].strDateTypeFlg.value = "2";
	}
}

function resetPage()
{
	objVal = document.getElementById("consolidatedPODetailDIV");
	objVal.innerHTML = ""; 
	document.getElementById("showButtonID").style.display="none";
	document.forms[0].reset();
	
}

function genratePoHlp()
{  
	var hisValidator = new HISValidator("materialInwardReisterRptFB");
			
	hisValidator.addValidation("strSupplierId", "dontselect=-1","Supplier Name is a mandatory field");
	hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
	hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
	hisValidator.addValidation("strToDate",   "date","To Date is a mandatory field");
	hisValidator.addValidation("strFromDate", "dtltet="+document.forms[0].strCurrentDate.value,"Please Select From Date Less Than or Equal To Current Date");
	hisValidator.addValidation("strToDate",   "dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
	hisValidator.addValidation("strToDate",   "dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	var retVal = hisValidator.validate();
	   var dd= dateDiff(document.forms[0].strFromDate.value ,document.forms[0].strToDate.value);
		// alert(dd);
		var dd2 = dd.split(' ')[0];
			     /*if( dd2> 30)
				     {
				     alert("Time difference couldn't be more than 30 days");
				    retVal= false;
				     }*/
			
	hisValidator.clearAllValidations();

    if(retVal)
    {    
		document.getElementById("consolidatedPODetailDIV").innerHTML = ""; 
		document.getElementById("consolidatedChallanDetailDIV").innerHTML = ""; 
		var mode="GETSCREENTWO";
		var url="MaterialInwardReisterRptCNT.cnt?hmode="+mode+"&supplierId="+document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].value+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value+"&dateFlg="+document.forms[0].strDateTypeFlg.value;
		ajaxFunction(url,"1");
    }
    	
  
}


function getSupplierDtlPopUp(index)
{
	/* Value Pass in Web Row Set
			    	    1. SUPPLIER NAME
			    	    2. PO NET AMT , 
			            3. Supplied Amount 
			            4. Supplier ID */  	  	
	
	var mode="SUPPLIERPODTLPOPUP";
	var url="MaterialInwardReisterRptCNT.cnt?hmode="+mode+"&supplierId="+document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].value+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value+"&hiddenValue="+document.getElementById("strCheckHidValue"+index).value+"&dateFlg="+document.forms[0].strDateTypeFlg.value;
	//alert(url);
	ajaxFunction(url,"3");
	
}	
function getPoChallanDtlPopUp(index)
{
	 /* Value Pass in Web Row Set
				    	   1. PO TYPE
				    	   2. PO DATE , 
			            3. PO NET AMT,
			            4. STORE ID 
			            5. PO  NO
			            6. SUPPLIED AMT 
						*/
	   "+++++++++"
	/* Value Pass in Web Row Set
			    	    1. SUPPLIER NAME
			    	    2. Supplier Address , 
			            3. PO DATE 
			            4. Supplied Amount 
			            5. PO Net Amount
			            6. Store Id
			            7. PO No
			            8. Supplier ID */  
    		
   
    var mode="GETPOCHALLANDTLPOPUP";
	var url="MaterialInwardReisterRptCNT.cnt?hmode="+mode+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value+"&hiddenValue="+document.getElementById("strPoHidValue"+index).value+"&dateFlg="+document.forms[0].strDateTypeFlg.value;
	
	ajaxFunction(url,"4");    
	
	
}

function getPoChallanItemDtlPopUp(index)
{
	/* Value Pass in Web Row Set
			    	   1. Chaalna No
			    	   2. Challan Date , 
		               3. Store Name(Location),
		               4. Value 
		               5. Stor ID(Location)
	                "+++++++++"
			    	   1. PO TYPE
			    	   2. PO DATE , 
		            3. PO NET AMT,
		            4. STORE ID 
		            5. PO  NO
		            6. SUPPLIED AMT 
	                "+++++++++"
		    	    1. SUPPLIER NAME
		    	    2. Supplier Address , 
		            3. PO DATE 
		            4. Supplied Amount 
		            5. PO Net Amount
		            6. Store Id
		            7. PO No
		            8. Supplier ID */  	
			            
	
    	
    var mode="GETCHALLANITEMDTLPOPUP";
	var url="MaterialInwardReisterRptCNT.cnt?hmode="+mode+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value+"&hiddenValue="+document.getElementById("strChalllanHidValue"+index).value;
	
	ajaxFunction(url,"5");    
	
	
}

function genratePoChallanHlp(StoreId,PoNumber)
{
	var mode="GETCHALLANDTL";
	var url="MaterialInwardReisterRptCNT.cnt?hmode="+mode+"&StoreId="+StoreId+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value+"&PoNumber="+PoNumber;
	
	ajaxFunction(url,"2");
}		

function getScreenTwoPrint()
{
	
    var mode="GETPRINTSCREENTWO";
	var url="MaterialInwardReisterRptCNT.cnt?hmode="+mode+"&supplierId="+document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].value+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value+"&supplierName="+document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].text+"&dateFlg="+document.forms[0].strDateTypeFlg.value;
	ajaxFunction(url,"6");
	
}

function getAjaxResponse(res, mode) 
{

	var objVal;
	if (mode == "1") 
	{

		objVal = document.getElementById("consolidatedPODetailDIV");
		objVal.innerHTML = res; 
		 document.getElementById("showButtonID").style.display="block";
	}
	if (mode == "2")
	{

		objVal = document.getElementById("consolidatedChallanDetailDIV");
		objVal.innerHTML = res;
		document.getElementById("showButtonID").style.display="block";
		
	}
	if (mode == "3") 
	{
		
       	objVal = document.getElementById("supplierPoDtlsDivId");
		objVal.innerHTML = res;
		popup('popUpDiv1', '100', '80');
		
		
		
	}
	
	if (mode == "4") 
	{
		
		
		objVal = document.getElementById("poChallanDtlsDivId");
		objVal.innerHTML = res;
		hidePopup_ajex(1);
		popup('popUpDiv2', '100', '80');
		
		
		
	}
	if (mode == "5") 
	{		
       
		
		
		objVal = document.getElementById("poChallanItemDtlsDivId");
		objVal.innerHTML = res;
		hidePopup_ajex(2);
		popup('popUpDiv3', '100', '80');
		
		
		
	}
	if (mode == "6") 
	{				
		
		objVal = document.getElementById("suppliedPOPrintDtlsDivId");
		objVal.innerHTML = res;
		popup('popUpDiv4', '100', '80');
		
		
	}
	
}



function hidePopup_ajex(mode)
{
		
		if(mode=='1')
		{		 
          //document.getElementById("supplierPoDtlsDivId").innerHTML = "";			
		  hide_popup('popUpDiv1');
		} 
		if(mode=='2')
		{
		  	
		  //document.getElementById("poChallanDtlsDivId").innerHTML = "";
		  hide_popup('popUpDiv2');
		} 
		if(mode=='3')
		{		  
		  //document.getElementById("poChallanItemDtlsDivId").innerHTML = "";
		  hide_popup('popUpDiv3');
		}
		if(mode=='4')
		{
		  document.getElementById("suppliedPOPrintDtlsDivId").innerHTML = "";
		  hide_popup('popUpDiv4');
		}
}
	
function hidePopup(mode)
{
		
		if(mode=='1')
		{		 
          //document.getElementById("supplierPoDtlsDivId").innerHTML = "";			
		  hide_popup('popUpDiv1');
		} 
		if(mode=='2')
		{
		  	
		  //document.getElementById("poChallanDtlsDivId").innerHTML = "";
		  hide_popup('popUpDiv2');
		  popup('popUpDiv1', '100', '80');
		} 
		if(mode=='3')
		{		  
		  //document.getElementById("poChallanItemDtlsDivId").innerHTML = "";
		  hide_popup('popUpDiv3');
		  popup('popUpDiv2', '100', '80');
		}
		if(mode=='4')
		{
		  document.getElementById("suppliedPOPrintDtlsDivId").innerHTML = "";
		  hide_popup('popUpDiv4');
		}
}	

function closePopup(mode)
{
		
		if(mode=='1')
		{		 
          document.getElementById("supplierPoDtlsDivId").innerHTML = "";			
		  hide_popup('popUpDiv1');
		} 
		if(mode=='2')
		{
		  	
		  document.getElementById("poChallanDtlsDivId").innerHTML = "";
		  hide_popup('popUpDiv2');
		  //popup('popUpDiv1', '100', '80');
		} 
		if(mode=='3')
		{		  
		  document.getElementById("poChallanItemDtlsDivId").innerHTML = "";
		  hide_popup('popUpDiv3');
		  //popup('popUpDiv2', '100', '80');
		}
		if(mode=='4')
		{
		  document.getElementById("suppliedPOPrintDtlsDivId").innerHTML = "";
		  hide_popup('popUpDiv4');
		}
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
	if(mode=='1')
	{
	  newwin.document.write(document.getElementById('supplierPoDtlsDivId').innerHTML);
	}
	if(mode=='2')
	{
	  newwin.document.write(document.getElementById('poChallanDtlsDivId').innerHTML);
	}
	if(mode=='3')
	{
	  newwin.document.write(document.getElementById('poChallanItemDtlsDivId').innerHTML);
	}
	if(mode=='4')
	{
	  newwin.document.write(document.getElementById('suppliedPOPrintDtlsDivId').innerHTML);
	}
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

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
 * 
 */
function chkBoxClick(obj,index)
{	  
	  	  /* Value Pass in Web Row Set
			    	   1. SUPPLIER NAME
			    	   2. PO With PREFIX , 
		               3. CATG NAME,
		               4. PO TYPE 
		               5. QU NO
		               6. QU DATE 
		               7. TENDER NO 
		               8. TENDER DATE 
		               9. SUPPLIER ADD 
		               10.PO DATE
		               11.TAX
		               12.AMT  
		               13.Store Id
		               14. PO No
			    	 */    	
	    	 
	   var hiddenVal = document.getElementById("strCheckHidValue"+index).value; 
	   
	   var StoreID = hiddenVal.split("^")[12];  	
	   var PoNo    = hiddenVal.split("^")[13]; 
	   
	   // Set Selected Record Value For Show Report Method
       document.forms[0].strProcRelatedValue.value = hiddenVal;
	   
	   genratePoChallanHlp(StoreID,PoNo);
	         
       	 
       	
      
	
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


function validate(){

	var hisValidator = new HISValidator("materialInwardReisterRptFB");

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

	

function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();
	
	l

}

function setEndFinancialYear()
{
	document.forms[0].strEndFinancialYear.value=parseInt(document.forms[0].strStartFinancialYear.value)+parseInt("1"); 
}


function onClickBatch(){

		if(document.forms[0].strBatchNo.checked){
		
			document.forms[0].strBatchNo.value = "1";
		
		}else if(document.forms[0].strBatchNo.checked == false){
		
			document.forms[0].strBatchNo.value = "0";
		
		}
		
}
function onLoadPage()
{	
	document.getElementsByName("strPoType")[0].checked=true;
	document.getElementsByName("strPoType")[1].checked=false;
	document.getElementsByName("strPoType")[2].checked=false;	
}
function validate1()
{
	
	document.forms[0].hmode.value = "SHOWRPT";
	
	if(document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html")
	{
		document.forms[0].target = "_self";
	}else{
		document.forms[0].target = "_blank";
	}
	document.forms[0].submit();
	}



