/**

	JS Function used in committetype
**/
function genrateIssueDtlHlp()
{
	
		var hisValidator = new HISValidator("materialOutwardRegisterRptFB");

		hisValidator.addValidation("strStoreId","dontselect=-1","Please Select District Drug Warehouse Name");
		hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strFromDate", "dtltet="+document.forms[0].strCurrentDate.value,"Please Select From Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
		
		
	
	var retVal = hisValidator.validate();
	 var dd= dateDiff(document.forms[0].strFromDate.value ,document.forms[0].strToDate.value);
	// alert(dd);
	var dd2 = dd.split(' ')[0];
		     if( dd2> 30)
			     {
			     alert("Time difference couldn't be more than 30 days");
			    retVal= false;
			     }
	hisValidator.clearAllValidations();

if(retVal)
{	
		document.getElementById("showButtonID").style.display="block";
		document.getElementById("consolidatedPODetailDIV").innerHTML = ""; 
		document.getElementById("consolidatedChallanDetailDIV").innerHTML = ""; 
		var mode="GETISSUEDTL";
		var url="MaterialOutwardRegisterRptCNT.cnt?hmode="+mode+
		"&StoreId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+
		"&fromDate="+document.forms[0].strFromDate.value
		+"&toDate="+document.forms[0].strToDate.value
		+"&ToStoreId="+document.forms[0].strToStoreId[document.forms[0].strToStoreId.selectedIndex].value;
		ajaxFunction(url,"1");
}		
		
	
}

function getToStoreCmb()
{
	/*document.getElementById("showButtonID").style.display="none";
		document.getElementById("consolidatedPODetailDIV").innerHTML = ""; 
		document.getElementById("consolidatedChallanDetailDIV").innerHTML = "";*/ 
	var mode="GETTOSTORE";
	var url="MaterialOutwardRegisterRptCNT.cnt?hmode="+mode+"&StoreId="+document.forms[0].strStoreId.value;
	
	ajaxFunction(url,"3");
}	


function printMainScreen()
{
	  
	  	var hisValidator = new HISValidator("materialOutwardRegisterRptFB");

//		hisValidator.addValidation("strStartFinancialYear", "req","Start Financial Year is a mandatory field");

		hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

		if(retVal)
		{
			document.forms[0].storeId.value =  document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value;  
			document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
			  
			var mode="PRINTMAINSCREENISSUEDTLPOPUP";
			var url="MaterialOutwardRegisterRptCNT.cnt?hmode="+mode+"&StoreId="
			+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value
			+"&fromDate="+document.forms[0].strFromDate.value
			+"&toDate="+document.forms[0].strToDate.value
			+"&ToStoreId="+document.forms[0].strToStoreId[document.forms[0].strToStoreId.selectedIndex].value
			+"&fromStoreName="+ document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text  
			+"&toStoreName="+ document.forms[0].strToStoreId[document.forms[0].strToStoreId.selectedIndex].text;
			
			ajaxFunction(url,"6");
			
		}
	   else
	   {
			return false;
	   } 
	  
	
}


function genratePoChallanHlp(StoreId,checkHidValue)
{
	var itemStockObj = document.getElementById("issueDtlsDivId");
	var mode="GETISSUEDTLPOPUP1";
	var url="MaterialOutwardRegisterRptCNT.cnt?hmode="+mode+"&StoreId="+StoreId	
	+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value+"&ToStoreId="
	+document.forms[0].strToStoreId.value;
	ajaxFunction(url,"2");
 	
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
			    	   1. Dwh Name
			    	   2. Net Cost
		               3. Store Id
		           	 */     	 	
					
	    	 
	   var hiddenVal = document.getElementById("strCheckHidValue"+index).value; 
	   
	   var StoreID    =	hiddenVal.split("^")[2]; 
       // Set Selected Record Value For Show Report Method
       document.forms[0].strProcRelatedValue.value = hiddenVal;
	   
	   genratePoChallanHlp(StoreID,hiddenVal);
	         
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

	var hisValidator = new HISValidator("materialOutwardRegisterRptFB");

//		hisValidator.addValidation("strStartFinancialYear", "req","Start Financial Year is a mandatory field");
		hisValidator.addValidation("strStoreId","dontselect=-1","Please Select District Drug Warehouse Name");
		hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

if(retVal)
{
	document.forms[0].storeId.value =  document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value;  
	document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;

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

function validate2()
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
function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();
	
	

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



	

/**
 * Pop up 2
 */
function getPopUp2(obj,index)
{	  
	  	 /* Value Pass in Web Row Set
			    		   1. NAME_OF_INST
				    	   2. TOTAL_VALUE
			               3. HSTNUM_STORE_ID
			               4. DWH_NAME
			               5. HSTNUM_REQ_STOREID
			             
		           	 */    	 	
					
					
	    	 
	   var hiddenVal = document.getElementById("strChkHidValue2"+index).value; 
	   
	   var StoreID    = hiddenVal.split("^")[2];  	
	   var toStoreID    = hiddenVal.split("^")[4]; 

	   // Set Selected Record Value For Show Report Method
       document.forms[0].strProcRelatedValue.value = hiddenVal;
	   
	   genratePopUp2Hlp(StoreID,hiddenVal);
	         
}



function genratePopUp2Hlp(StoreId,checkHidValue)
{
	var mode="GETISSUEDTLPOPUP2";
	//hideIssuePopup();	
	var url="MaterialOutwardRegisterRptCNT.cnt?hmode="+mode+"&StoreId="+StoreId
	
	+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value
	+"&ToStoreId="+checkHidValue.split("^")[4];
	
	ajaxFunction(url,"4");
 	
 	
	
}

function getAjaxResponse(res, mode) 
{

	var objVal;
	if (mode == "1") 
	{
		objVal = document.getElementById("consolidatedPODetailDIV");
		objVal.innerHTML = res; 
	}
	if (mode == "2") 
	{
	   
		objVal = document.getElementById("issueDtlsDivId");
		objVal.innerHTML = res;		
		popup('popUpDiv1', '80', '60');
		
	}
	if (mode == "3") 
	{
		objVal = document.getElementById("strToStoreDivId");
		objVal.innerHTML = "<select name ='strToStoreId' class='comboNormal' onchange='' >" + res + "</select>";
		
		
	}	
	if (mode == "4")
	{
   
		objVal = document.getElementById("issueDtlsDivId2");
		objVal.innerHTML = res;		
		hide_Ajax_IssuePopup();
		popup('popUpDiv2', '80', '60');
		
	}
	
	if (mode == "5") 
	{
	   
	   
		objVal = document.getElementById("issueDtlsDivId3");
		objVal.innerHTML = res;		
		 hide_Ajax_IssuePopup2();
		popup('popUpDiv3', '80', '60');
		
	}
	if (mode == "6") 
	{
	    //alert("Pop Up 4");
		objVal = document.getElementById("issueDtlsDivId4");
		objVal.innerHTML = res;		
		popup('popUpDiv4', '80', '60');
		
	}
	
	
}

function hide_Ajax_IssuePopup()
{
	   
		//document.getElementById("issueDtlsDivId").innerHTML = "";		
		hide_popup('popUpDiv1');
		
}
function hide_Ajax_IssuePopupMain()
{
	
		//document.getElementById("issueDtlsDivIdMain").innerHTML = "";		
		hide_popup('popUpDivMain');
		
}
function hide_Ajax_IssuePopup3()
{
	
		//document.getElementById("issueDtlsDivId3").innerHTML = "";		
		hide_popup('popUpDiv3');
		
}

function hide_Ajax_IssuePopup2()
{
	
		//document.getElementById("issueDtlsDivId2").innerHTML = "";		
		hide_popup('popUpDiv2');
		
}

function hide_Ajax_IssuePopupTwo()
{
	
		//document.getElementById("issueDtlsDivId4").innerHTML = "";		
		hide_popup('popUpDiv4');
		
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
		  document.getElementById("issueDtlsDivId4").innerHTML = "";
		  hide_popup('popUpDiv4');
		}
}	


function closePopup(mode)
{
		
		if(mode=='1')
		{		 
          document.getElementById("issueDtlsDivId").innerHTML = "";		
		  hide_popup('popUpDiv1');
		} 
		if(mode=='2')
		{
		  	
		  document.getElementById("issueDtlsDivId2").innerHTML = "";
		  hide_popup('popUpDiv2');
		} 
		if(mode=='3')
		{		  
		  document.getElementById("issueDtlsDivId3").innerHTML = "";
		  hide_popup('popUpDiv3');
		  //popup('popUpDiv2', '100', '80');
		}
		if(mode=='4')
		{
		  document.getElementById("issueDtlsDivId4").innerHTML = "";
		  hide_popup('popUpDiv4');
		}
}	




function hideIssuePopup()
{
	   
		//document.getElementById("issueDtlsDivId").innerHTML = "";		
		hide_popup('popUpDiv1');
		
}
function hideIssuePopupMain()
{
	
		//document.getElementById("issueDtlsDivIdMain").innerHTML = "";		
		hide_popup('popUpDivMain');
		
}
function hideIssuePopup3()
{
	
		//document.getElementById("issueDtlsDivId3").innerHTML = "";		
		hide_popup('popUpDiv3');
		
}

function hideIssuePopup2()
{
	
		//document.getElementById("issueDtlsDivId2").innerHTML = "";		
		hide_popup('popUpDiv2');
		
}

function hideIssuePopupTwo()
{
	
		//document.getElementById("issueDtlsDivId4").innerHTML = "";
		
		hide_popup('popUpDiv4');
		
}	



// Pop up 3



/**
 * 
 */
function getPopUp3(obj,index)
{	  
	  	 /* Value Pass in Web Row Set
			    	 1. Issue no
				    	   2. Issue Date
			               3. Indent No
			               4. Indent Date
			               5. Name of Institution
			               6. Total Value 
			               7. DWH Name
			               8. Store Id
			               9. Requesting Store Id	
			               10.RECIEVED_BY 
		           	 */    	 	    	 
	   var hiddenVal = document.getElementById("strCheckHidValue33"+index).value; 
	  
	   var StoreID    = hiddenVal.split("^")[7];  	
	   var IssueNo    = obj.value; 
	   
       document.forms[0].strProcRelatedValue.value = hiddenVal;
	   
	   genratePopUp3Hlp(StoreID,IssueNo,hiddenVal);
	         
}



function genratePopUp3Hlp(StoreId,IssueNo,checkHidValue)
{
	var mode="GETISSUEDITEMDTLPOPUP3";
	//hideIssuePopup2();
	var url="MaterialOutwardRegisterRptCNT.cnt?hmode="+mode+"&StoreId="+StoreId+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value
	+"&issueNo="+checkHidValue.split("^")[0]+"&hiddenValue="+checkHidValue;	
	
	ajaxFunction(url,"5");
}





/**
 * Prints the report.
 * @return
 */
function printData() {

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
	newwin.document.write(document.getElementById('issueDtlsDivId').innerHTML);
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}	
/**
 * Prints the report.
 * @return
 */
function printData2() {

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
	newwin.document.write(document.getElementById('issueDtlsDivId2').innerHTML);
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}	


/**
 * Prints the report.
 * @return
 */
function printData3() {

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
	newwin.document.write(document.getElementById('issueDtlsDivId3').innerHTML);
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}	

	
	
	
	function printDataMain4() {

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
	newwin.document.write(document.getElementById('issueDtlsDivId4').innerHTML);
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}	
	

/**
 * Prints the report.
 * @return
 */
function printDataMain() {

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
	newwin.document.write(document.getElementById('issueDtlsDivIdMain').innerHTML);
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}	
	





function printData4() {

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
	newwin.document.write(document.getElementById('issueDtlsDivId3').innerHTML);
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}	