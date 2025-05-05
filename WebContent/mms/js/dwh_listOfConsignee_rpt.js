/**

	JS Function used in listOfConsignee
**/



function generatePoDetailHlp()
{
  	
    //alert("hello");  
	//document.getElementById("consolidatedPODetailDIV").innerHTML = ""; 
	//document.getElementById("consolidatedChallanDetailDIV").innerHTML = "";

		var hisValidator = new HISValidator("listOfConsigneeRptFB");
		
		//		hisValidator.addValidation("strStartFinancialYear", "req","Start Financial Year is a mandatory field");
		hisValidator.addValidation("strSupplierId","dontselect=-1","Please Select Supplier Name");
		hisValidator.addValidation("strOrderFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strOrderToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strOrderToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strOrderToDate","dtgtet="+document.forms[0].strOrderFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

	if(retVal)
	{
		
	  
	var mode="GETPODETAIL";
	var suppId=document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].value;
	var suppName=document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].text;
	
	var url="ListOfConsigneeRptCNT.cnt?hmode="+mode+"&supplierId="+suppId+"&fromDate="+document.forms[0].strOrderFromDate.value+"&toDate="+document.forms[0].strOrderToDate.value+"&suppName="+suppName;
	//alert("url :"+url);
	
	ajaxFunction(url,"1");
  
  	}	
}

function getPDFReport(){
	
	
	var obj= document.getElementsByName("strSuppChkIndex");
	var strSecCheckHidValue;
	var strSupplierName=document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].text;
	var count=0,j=0;
	
	if(obj.length>=1)
	{
			for(i=0; i<obj.length; i++)
			{
				if(obj[i].checked==true)
				{
					count++;
					strSecCheckHidValue=document.getElementById("strCheckHidValue"+i).value;
					j=i;
				}
			}
			//alert("count :"+count);
			if(count==0){
				alert("Please select atleast one record");
				return false;
			}
	
	}
	
	document.forms[0].strSecCheckHidValue.value = strSecCheckHidValue;
	
	document.forms[0].hmode.value = "GETPDFRPT";
		
		document.forms[0].submit();
	
	
}

function genrateConsigneeDetailHlpPrint()
{
	
	//alert("inside genrateConsigneeDetailHlpPrint() of js")
	var obj= document.getElementsByName("strSuppChkIndex");
	var strSecCheckHidValue;
	var strSupplierName=document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].text;
	var count=0,j=0;
	var mode="GETCONSIGNEEDTLPRINT";
	//alert("obj.length :"+obj.length);
	if(obj.length>=1)
	{
			for(i=0; i<obj.length; i++)
			{
				if(obj[i].checked==true)
				{
					count++;
					strSecCheckHidValue=document.getElementById("strCheckHidValue"+i).value;
					j=i;
				}
			}
			//alert("count :"+count);
			if(count==0){
				alert("Please select atleast one record");
				return false;
			}
			var url="ListOfConsigneeRptCNT.cnt?hmode="+mode+"&strSecCheckHidValue="+strSecCheckHidValue+"&strSupplierName="+strSupplierName;
			ajaxFunction(url,"2");
			obj[j].checked=false;		
	}else{
		alert("There is no record to display");
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

	   if(mode=="1")
	   {
		  // alert("res"+res);
		   objVal = document.getElementById("PODetailsHlpDivId");
			objVal.innerHTML = res; 
			document.getElementById("showButtonID").style.display="block";
			document.getElementById("showMandatoryBefore").style.display="none";
			
	   }  
	
		
		if (mode == "2") 
		{				
			
			objVal = document.getElementById("ConsigneeDetailHlpPopUpPrintDivId");
			objVal.innerHTML = res;
			popup('popUpDivMain', '100', '80');
			
			
		}
	
}   
	

	
	




function hidePopup(mode)
{
		
		if(mode=='1')
		{		 
          document.getElementById("ConsigneeDetailHlpPopUpPrintDivId").innerHTML = "";			
		  hide_popup('popUpDivMain');
		} 
//		if(mode=='2')
//		{
//		  	
//		  document.getElementById("poChallanDtlsDivId").innerHTML = "";
//		  hide_popup('popUpDiv2');
//		} 

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
	  newwin.document.write(document.getElementById('ConsigneeDetailHlpPopUpPrintDivId').innerHTML);
	}
//	if(mode=='2')
//	{
//	  newwin.document.write(document.getElementById('poChallanDtlsDivId').innerHTML);
//	}

	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}	




function validate(){

	var hisValidator = new HISValidator("listOfConsigneeRptFB");

//		hisValidator.addValidation("strStartFinancialYear", "req","Start Financial Year is a mandatory field");
		hisValidator.addValidation("strSupplierId","dontselect=-1","Please Select Supplier Name");
		hisValidator.addValidation("strOrderFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strOrderToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strOrderToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strOrderToDate","dtgtet="+document.forms[0].strOrderFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	
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

function resetPODetailsHlpDivId()
{
	objVal = document.getElementById("PODetailsHlpDivId");
	objVal.innerHTML = ""; 
	document.getElementById("showButtonID").style.display="none";
	document.getElementById("showMandatoryBefore").style.display="block";
	
	
	
}
function resetPage()
{
	objVal = document.getElementById("PODetailsHlpDivId");
	objVal.innerHTML = ""; 
	document.getElementById("showButtonID").style.display="none";
	document.getElementById("showMandatoryBefore").style.display="block";
	document.forms[0].reset();
	
}	

function cancelPage(){
	//alert("inside cancelPage");
	document.getElementsByName("hmode")[0].value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();
	

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


