/**

	JS Function used in committetype
**/



function resetPage()
{
	objVal = document.getElementById("consolidatedPODetailDIV");
	objVal.innerHTML = ""; 
	document.getElementById("showButtonID").style.display="none";
	document.forms[0].reset();
	
}

function genrateHelpDeskHlp()
{  
	var hisValidator = new HISValidator("HelpDeskRptFB");
	hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
	hisValidator.addValidation("strToDate",   "date","To Date is a mandatory field");
	hisValidator.addValidation("strFromDate", "dtltet="+document.forms[0].strCurrentDate.value,"Please Select From Date Less Than or Equal To Current Date");
	hisValidator.addValidation("strToDate",   "dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
	hisValidator.addValidation("strToDate",   "dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

    if(retVal)
    {    
		document.getElementById("consolidatedPODetailDIV").innerHTML = ""; 
		//document.getElementById("consolidatedChallanDetailDIV").innerHTML = ""; 
		var mode="GETSCREENTWO";
		var url="HelpDeskRptCNT.cnt?hmode="+mode+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value+"&StrId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+"&DeptId="+document.forms[0].strDeptId[document.forms[0].strDeptId.selectedIndex].value+"&MenuId="+document.forms[0].strMenuId[document.forms[0].strMenuId.selectedIndex].value+"&StatusId="+document.forms[0].strStatus[document.forms[0].strStatus.selectedIndex].value+"&dateFlg="+document.forms[0].strDateTypeFlg.value;
		ajaxFunction(url,"1");
    
   // document.forms[0].hmode.value="GETSCREENTWO";
   // document.forms[0].submit;
  // document.forms[0].hmode.value="GETSCREENTWO";
	//document.forms[0].target = "_self";
	//document.forms[0].submit();
    }
    	
  
}








function getScreenTwoPrint()
{
    var mode="GETPRINTSCREENTWO";
	var url="HelpDeskRptCNT.cnt?hmode="+mode+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value+"&StrId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+"&DeptId="+document.forms[0].strDeptId[document.forms[0].strDeptId.selectedIndex].value+"&MenuId="+document.forms[0].strMenuId[document.forms[0].strMenuId.selectedIndex].value+"&StatusId="+document.forms[0].strStatus[document.forms[0].strStatus.selectedIndex].value+"&dateFlg="+document.forms[0].strDateTypeFlg.value;
	ajaxFunction(url,"2");
	
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
	
	

}








function onLoadPage(){
	
	//System.out.println("entered in OnpageLoad()")
	//alert("Entered");

	document.forms[0].strStoreId.value = "0";
	document.forms[0].strDeptId.value="0";
	document.forms[0].strStatus.value="0";
	document.getElementById("MenuDiv").style.display="none";
	//document.forms[0].strDueDate.value = document.forms[0].strCurrentDate.value;
	//document.getElementById("MenuDiv").style.display="none";
	// document.getElementsByName("strDDWWise")[0].checked=false;
	 
	 
	// document.getElementsByName("strExpiryDays")[0].checked=true;
	// document.getElementsByName("strExpiryDate")[0].checked=false;
	 
	

}

function getMenuCmb()
{
    
    var deptid = document.getElementsByName("strDeptId")[0].value
     if(deptid =='1003')
 	 {
 	 	 //alert(deptid);
	    //document.getElementsByName("strDDWWise")[0].checked=false;
		//document.getElementById("DDWDiv").style.display="none";
		//document.getElementById("DeptDiv").style.display="block";
		document.getElementById("MenuDiv").style.display="block";
		
		
		//document.getElementsByName("strUserRemarks")[0].value="";
		//document.getElementsByName("strItemCatNo")[0].value="0";
		//document.getElementsByName("strStoreId")[0].value="0";
		//document.forms[0].strDueDate.value = document.forms[0].strCurrentDate.value;
		//document.getElementsByName("strExpNonExpiryFlag")[0].value="10";
	 	
		
	}
	else
	{
		document.getElementById("MenuDiv").style.display="none";
	}
	
}


function downloadfile(index)
{


      //alert(index);
     //  document.forms[0].hmode.value = "DOWNLOAD";
	//document.forms[0].submit();
	
	if(index!=null)
	{
	 var mode="DOWNLOAD";
	var url="HelpDeskRptCNT.cnt?hmode="+mode+"&hiddenValue="+document.getElementById("strCheckHidValue"+index).value;
	//alert(url);
	//ajaxFunction(url,"1"); 
	 url = (url.replace(/%/g, '@$@$'));
	window.open(url, "popupWindow",	"width=1000,height=500,top=150,left=50,scrollbars=yes"); 
	}
	else
	{
	alert("File not Uploaded");
	}
}

function showIssueDescDtls(parentObj,ProbDesc,IssueNo,DDWName) {
	 	
	 	
	 	document.getElementById("issuedesctitleDivId").innerHTML = "DDW/Issue No : "+DDWName+"/"+IssueNo;
	 	document.getElementById("issuedescDivId").innerHTML = ProbDesc;
	 	
	 	display_popup_menu(parentObj, "issueDtlsDivId" , "","");
	 	
	 }
	 
 function showStatusDescDtls(parentObj,StatusFlg,IssueNo,DDWName,Solution,SolutionDate,Remarks) {
	 	
	 	if(StatusFlg == 1)
	 	{
	 	document.getElementById("StatusdesctitleDivId").innerHTML = "DDW/Issue No : "+DDWName+"/"+IssueNo;
	 	document.getElementById("StatusOpendescDivId").innerHTML = "Solution is in Under Processing We will Resolve as soon as possible";
	 	display_popup_menu(parentObj, "StatusOpenDtlsDivId" , "","");
	 	}
	 	
	 	if(StatusFlg == 2)
	 	{
	 	document.getElementById("StatusdesctitleDivId").innerHTML = "DDW/Issue No : "+DDWName+"/"+IssueNo;
	 	document.getElementById("StatusSoldescDivId").innerHTML = Solution ;
	 	document.getElementById("StatusSolDatedescDivId").innerHTML = SolutionDate ;
	 	display_popup_menu(parentObj, "StatusResolvedDtlsDivId" , "","");
	 	}
	 	
	 	if(StatusFlg == 4)
	 	{
	 	document.getElementById("StatusdesctitleDivId").innerHTML = "DDW/Issue No : "+DDWName+"/"+IssueNo;
	 	document.getElementById("StatusRemarksdescDivId").innerHTML = Remarks;
	 	document.getElementById("StatusRejectedDateDivId").innerHTML = SolutionDate ;
	 	display_popup_menu(parentObj, "StatusRejectedDtlsDivId" , "","");
	 	}
	 	
	 	
	 	//document.getElementById("issuedesctitleDivId").innerHTML = "DDW/Issue No : "+DDWName+"/"+IssueNo;
	 	//document.getElementById("issuedescDivId").innerHTML = ProbDesc;
	 	
	 	//display_popup_menu(parentObj, "issueDtlsDivId" , "","");
	 	
	 }



