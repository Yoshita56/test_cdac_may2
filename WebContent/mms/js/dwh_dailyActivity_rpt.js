function chkBoxClick(mode,obj,index)
{	  
	  	/* Value Pass in Web Row Set
		    	   1. Issue Count
		    	   2. Receive Count
	               3. DWH Name
	               4. Store ID
	               5. Sample Sent Count	             
	           	 */ 
					
	    	 
	   var hiddenVal = document.getElementById("strCheckHidValue"+index).value; 
	 
	   var StoreID    = hiddenVal.split("^")[3];  	
	   var IssueNo    = hiddenVal.split("^")[0]; 
	   
	   document.forms[0].strTmpStoreID.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value;
	   document.forms[0].strProcRelatedValue.value =  hiddenVal;
	   if(mode=='1')
	   {
	     getIssueVoucherPopUp(hiddenVal);
	   }
	   if(mode=='2')
	   {
	   	 getReciveVoucherPopUp(hiddenVal);
	   }  
	   if(mode=='3')
	   {
	   getSampleSendPopUp(hiddenVal)
	   }
	   
}
function getDailyActivityPrint()
{
	  var mode="GETACTIVITYPRINT";
	  var url="DailyActivityRptCNT.cnt?hmode="+mode+"&StoreId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value+"&StoreName="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	  ajaxFunction(url,"9");
}
function getReciveVoucherPopUp(hiddenVal)
{
	
	/* Value Pass in Web Row Set
		    	   1. Issue Count
		    	   2. Receive Count
	               3. DWH Name
	               4. Store ID
	               5. Sample Sent Count	      
	             
	           	 */ 
	if(document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value!='0')
	{
	  //System.out.println("sgrfs"+hiddenVal);
	  var mode="GETRECIVEVOUCHERDTL";
	  var url="DailyActivityRptCNT.cnt?hmode="+mode+"&StoreId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value+"&hiddenVal="+hiddenVal.replace("%","0/0");
	  //alert(url);
	  ajaxFunction(url,"7");
	}
	else
	{
		alert("Please Select DWH Name!!!!");
		return false;
	}
	
}

function getSampleSendPopUp(hiddenVal)
{
	
	/* Value Pass in Web Row Set
		    	   1. Issue Count
		    	   2. Receive Count
	               3. DWH Name
	               4. Store ID
	               5. Sample Sent Count	      
	             
	           	 */ 
	if(document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value!='0')
	{
	  //System.out.println("sgrfs"+hiddenVal);
	  var mode="GETSAMPLESENDDTL";
	  var url="DailyActivityRptCNT.cnt?hmode="+mode+"&StoreId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value+"&hiddenVal="+hiddenVal.replace("%","0/0");
	  //alert(url);
	  ajaxFunction(url,"11");
	}
	else
	{
		alert("Please Select DWH Name!!!!");
		return false;
	}
	
}

function getIssueVoucherPopUp(hiddenVal)
{
	
	/* Value Pass in Web Row Set
		    	   1. Issue Count
		    	   2. Receive Count
	               3. DWH Name
	               4. Store ID
	             
	           	 */ 
	if(document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value!='0')
	{
		 //document.getElementById("buttonDivID").style.display="none";
		 //document.getElementById("consolidatedPODetailDIV").innerHTML = "";
		 //document.getElementById("consolidatedChallanDetailDIV").innerHTML = "";
		 //document.getElementById("consolidatedReceviedDetailDIV").innerHTML = "";
		 
	  var mode="GETISSUEVOUCHERDTL";
	  var url="DailyActivityRptCNT.cnt?hmode="+mode+"&StoreId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value+"&hiddenVal="+hiddenVal.replace("%","0/0");
	 
	  ajaxFunction(url,"4");
	}
	else
	{
		alert("Please Select DWH Name!!!!");
		return false;
	}
	
}

function getInstituteIssueDtl(index)
{
	               /*
					1.ISSUE_TO(Institution Name),
					2.HSTNUM_REQ_STOREID
					3.COUNT(HSTNUM_ISSUE_NO),
					4.HSTNUM_STORE_ID,
					5.STORE_NAME
					++++++++++++++++++++++++++++++++++++++++++++
			    	6. Issue Count
			    	7. Receive Count
		            8. DWH Name
		            9. Store ID
					*/
	
	  var mode="GETINSTITUTEISSUEDTL";
	  var url="DailyActivityRptCNT.cnt?hmode="+mode+"&hiddenVal="+(document.getElementById("strIssueVoucherOneHidValue"+index).value).replace("%","0/0")+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value;
	 
	  ajaxFunction(url,"5");
	
	
}


function getPoChallanDtl(index)
{
	               /*
					1.Supplier Name,
					2.Supplier Id,
					3.PO With Ref No,
					4.PO Date,
					5.PO No
					6.Supplied Value
					7.Received Count
					++++++++++++++++++++++++++++++++++++++++++++
			    	8. Issue Count
			    	9. Receive Count
		            10. DWH Name
		            11. Store ID
		            12.Sample Sent Count
					*/
	
	
      //alert("In 2 strReceiveVoucherOneHidValue"+document.getElementById("strReceiveVoucherOneHidValue"+index).value);
	
	  var mode="GETCHALLANDTL";
	  var url="DailyActivityRptCNT.cnt?hmode="+mode+"&hiddenVal="+(document.getElementById("strReceiveVoucherOneHidValue"+index).value).replace("%","0/0")+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value;
	 //alert(url);
	  ajaxFunction(url,"8");
	
	
}

function getSampleSendItemBatchDtl(index)
{
	              /*
				1.Store Id,
				2.Drug Name,
				3.Drug Brand ID,
				4.Issued Count,
				5.Issued Qty
				
				++++++++++++++++++++++++++++++++++++++++++++
		    	6. Issue Count
		    	7. Receive Count
	            8. DWH Name
	            9. Store ID
	            10.Sample Sent Count
				*/
	
	
      //alert("In 2 strReceiveVoucherOneHidValue"+document.getElementById("strReceiveVoucherOneHidValue"+index).value);
	//alert("Entered");
	  var mode="GETSAMPLESENDITEMBATCHDTL";
	  var url="DailyActivityRptCNT.cnt?hmode="+mode+"&hiddenVal="+(document.getElementById("strSampleSendDtlOneHidValue"+index).value).replace("%","0/0")+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value;
	  ajaxFunction(url,"12");
	
	
}

function getChallanItemsDtl(index)
{
                  /*
					1.Recipt No(Challan)
					2.Challan No
					3.Challan Date
					4.Received Date
					5.No Packet
					6.Supplied Value(SUM)
					+++++++++++++++++++++++++++  
					7.Supplier Name,
					8.Supplier Id,
					9.PO With Ref No,
					10.PO Date,
					11.PO No
					12.Supplied Value
					13.Received Count
					++++++++++++++++++++++++++++++++++++++++++++
			    	14. Issue Count
			    	15. Receive Count
		            16. DWH Name
		            17. Store ID
		            18.Sample Sent Count
					*/		
	// alert(document.getElementById("strReceiveVoucherTwoHidValue"+index).value);             	
	  var mode="GETCHALLANITEMSDTL";
	  var url="DailyActivityRptCNT.cnt?hmode="+mode+"&hiddenVal="+(document.getElementById("strReceiveVoucherTwoHidValue"+index).value).replace("%","0/0")+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value;
	 
	  ajaxFunction(url,"10");
	
	
}



function getIssueNoDetails(index)
{
	              /*
					1. HSTNUM_ISSUE_NO,
					2.ISSUE_DATE,
					3.INDENT_NO,
					4.ISSUED_VALUE,
					5.STORE_ID,
					6.STORE_NAME,
					7.HSTNUM_REQ_STOREID,
					8.REQ_STORE

					+++++++++++++++Hidden Value+++++++++++++++++++++++++++++ 
					9.ISSUE_TO(Institution Name),
					10.HSTNUM_REQ_STOREID
					11.COUNT(HSTNUM_ISSUE_NO),
					12.HSTNUM_STORE_ID,
					13.STORE_NAME
					++++++++++++++++++++++++++++++++++++++++++++
			    	14. Issue Count
			    	15. Receive Count
		            16. DWH Name
		            17. Store ID
					*/
			
	  var mode="GETISSUENODTL";
	  var url="DailyActivityRptCNT.cnt?hmode="+mode+"&hiddenVal="+(document.getElementById("strInstituteIssueHidValue"+index).value).replace("%","0/0")+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value;
	  ajaxFunction(url,"6");
	
	
}
function ClearDiv()
{
	document.getElementById("buttonDivID").style.display="none";
   document.getElementById("consolidatedPODetailDIV").innerHTML = "";
		 document.getElementById("consolidatedChallanDetailDIV").innerHTML = "";
		 document.getElementById("consolidatedReceviedDetailDIV").innerHTML = "";
}
function clearPage()
{
   document.getElementById("buttonDivID").style.display="none";
   document.getElementById("consolidatedPODetailDIV").innerHTML = "";
		 document.getElementById("consolidatedChallanDetailDIV").innerHTML = "";
		 document.getElementById("consolidatedReceviedDetailDIV").innerHTML = "";
	document.forms[0].reset();
}

	

function genrateDWHList()
{

var hisValidator = new HISValidator("dailyActivityRptFB");

//		hisValidator.addValidation("strStartFinancialYear", "req","Start Financial Year is a mandatory field");
	
		hisValidator.addValidation("strStoreId", "dontselect=0","Please Select District Drug Warehouse Name");

		hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

		
if(retVal)
{	
	
	if(document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value!='0')
	{
		 document.getElementById("buttonDivID").style.display="block";
		 document.getElementById("consolidatedPODetailDIV").innerHTML = "";
		 document.getElementById("consolidatedChallanDetailDIV").innerHTML = "";
		 document.getElementById("consolidatedReceviedDetailDIV").innerHTML = "";
		 
	  var mode="GETISSUEDTL";
	  var url="DailyActivityRptCNT.cnt?hmode="+mode+"&StoreId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value;
	  ajaxFunction(url,"1");
	}
	else
	{
		alert("Please Select DWH Name!!!!");
		return false;
	}
}	
	else
	{
		return false;
	}
	
}
	
function genratePoChallanHlp(StoreId,IssueNo)
{
	var mode="GETISSUEDITEMDTL";
	var url="DailyActivityRptCNT.cnt?hmode="+mode+"&StoreId="+StoreId+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value;
	
	ajaxFunction(url,"2");
}
		
	
function genrateReceivedHlp(StoreId)
{
	StoreId = document.forms[0].strProcRelatedValue.value.split("^")[3];
	var mode="GETISSUEANDRECEIVEDTL";
	var url="DailyActivityRptCNT.cnt?hmode="+mode+"&StoreId="+StoreId+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value;
	
	ajaxFunction(url,"3");
}		

function getAjaxResponse(res, mode) 
{

	var objVal;
	if (mode == "1") 
	{

		objVal = document.getElementById("consolidatedPODetailDIV");
		objVal.innerHTML = res; 
	}
	if (mode == "2") {

		objVal = document.getElementById("consolidatedChallanDetailDIV");
		objVal.innerHTML = res;
		genrateReceivedHlp(document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value);
		
	}
	if (mode == "3") 
	{
		objVal = document.getElementById("consolidatedReceviedDetailDIV");
		objVal.innerHTML = res;
		document.getElementById("buttonDivID").style.display="block";		
	}
	
	if (mode == "4") 
	{		
	    
       	objVal = document.getElementById("IssueVoucherDtlPopUpOneDivId");
		objVal.innerHTML = res;
		popup('popUpDiv1', '100', '80');
	}
	
	if (mode == "5") 
	{	
	   
       	objVal = document.getElementById("InstituteIssueDtlsDivId");
		objVal.innerHTML = res;
		 hidePopup_ajex(1);
		popup('popUpDiv2', '100', '80');			
	}
	
	if (mode == "6") 
	{	
	    
       	objVal = document.getElementById("IssueNumberDtlsDivId");
		objVal.innerHTML = res;
		hidePopup_ajex(2);
		popup('popUpDiv3', '100', '80');
		
	}
	
	if (mode == "7") 
	{		
	   
       	objVal = document.getElementById("recieveVoucherDetails");
		objVal.innerHTML = res;		
		popup('popUpDiv4', '100', '80');
		
	}
	
	if (mode == "8") 
	{	
	    //alert(res);
	   
       	objVal = document.getElementById("poChallanDetails");
		objVal.innerHTML = res;
		 hidePopup_ajex(4);
		popup('popUpDiv5', '100', '80');		
	}
	
	if (mode == "9") 
	{	
	   // hidePopup_ajex(5);
       	objVal = document.getElementById("activityPrint");
		objVal.innerHTML = res;
		popup('popUpDiv6', '100', '80');
		
	}	
	if (mode == "10") 
	{
	  
       	objVal = document.getElementById("challanItemsDetails");
		objVal.innerHTML = res;
		hidePopup_ajex(5);
		popup('popUpDiv10', '100', '80');		
	}
	
	if (mode == "11") 
	{		
	   
       	objVal = document.getElementById("samplesenddtl");
		objVal.innerHTML = res;		
		popup('popUpDiv11', '100', '80');
		
	}
	
	if (mode == "12") 
	{	
	    //alert(res);
	   
       	objVal = document.getElementById("samplesenditembatchdtl");
		objVal.innerHTML = res;
		 hidePopup_ajex(11);
		popup('popUpDiv12', '100', '80');		
	}
	
	
}

function hidePopup_ajex(mode)
{
		
		if(mode=='1')
		{		 
          //document.getElementById("IssueVoucherDtlPopUpOneDivId").innerHTML = "";			
		  hide_popup('popUpDiv1');
		} 
		if(mode=='2')
		{
		  	
		  //document.getElementById("InstituteIssueDtlsDivId").innerHTML = "";
		  hide_popup('popUpDiv2');
		 
		  		
		} 
		if(mode=='3')
		{		  
		  //document.getElementById("IssueNumberDtlsDivId").innerHTML = "";
		  hide_popup('popUpDiv3');
		  //popup('popUpDiv2', '100', '80');
		  
		}
		if(mode=='4')
		{
		  //document.getElementById("recieveVoucherDetails").innerHTML = "";
		  hide_popup('popUpDiv4');
		  //popup('popUpDiv3', '100', '80');
		  
		}
		if(mode=='5')
		{
		 // document.getElementById("poChallanDetails").innerHTML = "";
		  hide_popup('popUpDiv5');
		  
		  
		}
		
		if(mode=='6')
		{
		 // document.getElementById("activityPrint").innerHTML = "";
		  hide_popup('popUpDiv6');
		  //popup('popUpDiv5', '100', '80');
		  
		}
		
		if(mode=='10')
		{
		 // document.getElementById("challanItemsDetails").innerHTML = "";
		  hide_popup('popUpDiv10');
		  //popup('popUpDiv6', '100', '80');
		  
		}
		if(mode=='11')
		{
		  
		  hide_popup('popUpDiv11');
		  
		  
		}
}


     function hidePopup(mode)
{
		
		if(mode=='1')
		{		 
          //document.getElementById("IssueVoucherDtlPopUpOneDivId").innerHTML = "";			
		  hide_popup('popUpDiv1');
		} 
		if(mode=='2')
		{
		  	
		  //document.getElementById("InstituteIssueDtlsDivId").innerHTML = "";
		  hide_popup('popUpDiv2');
		   popup('popUpDiv1', '100', '80');
		  		
		} 
		if(mode=='3')
		{		  
		  //document.getElementById("IssueNumberDtlsDivId").innerHTML = "";
		  hide_popup('popUpDiv3');
		   popup('popUpDiv2', '100', '80');
		  
		}
		if(mode=='4')
		{
		  //document.getElementById("recieveVoucherDetails").innerHTML = "";
		  hide_popup('popUpDiv4');
		   //popup('popUpDiv3', '100', '80');
		  
		}
		if(mode=='5')
		{
		 // document.getElementById("poChallanDetails").innerHTML = "";
		  hide_popup('popUpDiv5');
		   popup('popUpDiv4', '100', '80');
		  
		  
		}
		
		if(mode=='6')
		{
		 // document.getElementById("activityPrint").innerHTML = "";
		  hide_popup('popUpDiv6');
		   popup('popUpDiv5', '100', '80');
		  
		}
		
		if(mode=='10')
		{
		 // document.getElementById("challanItemsDetails").innerHTML = "";
		  hide_popup('popUpDiv10');
		   popup('popUpDiv5', '100', '80');
		  
		}
		
	  if(mode=='11')
		{
		  //document.getElementById("samplesenddtl").innerHTML = "";
		  hide_popup('popUpDiv11');
		  }
		 
      if(mode=='12')
		{
		  //document.getElementById("samplesenddtl").innerHTML = "";
		  hide_popup('popUpDiv12');
		  popup('popUpDiv11', '100', '80');
		  
		  
		}
}

function closePopup(mode)
{
		
		if(mode=='1')
		{		 
          document.getElementById("IssueVoucherDtlPopUpOneDivId").innerHTML = "";			
		  hide_popup('popUpDiv1');
		} 
		if(mode=='2')
		{
		  	
		  document.getElementById("InstituteIssueDtlsDivId").innerHTML = "";
		  hide_popup('popUpDiv2');
		  		
		} 
		if(mode=='3')
		{		  
		  document.getElementById("IssueNumberDtlsDivId").innerHTML = "";
		  hide_popup('popUpDiv3');
		  
		}
		if(mode=='4')
		{
		  document.getElementById("recieveVoucherDetails").innerHTML = "";
		  hide_popup('popUpDiv4');
		  
		}
		if(mode=='5')
		{
		  document.getElementById("poChallanDetails").innerHTML = "";
		   //hide_popup('popUpDiv4');
		  hide_popup('popUpDiv5');
		  
		}
		
		if(mode=='6')
		{
		  document.getElementById("activityPrint").innerHTML = "";
		  //hide_popup('popUpDiv4');
		  //hide_popup('popUpDiv5');
		  hide_popup('popUpDiv6');
		  
		}
		
		if(mode=='10')
		{
		document.getElementById("recieveVoucherDetails").innerHTML = "";
		document.getElementById("poChallanDetails").innerHTML = "";
		  document.getElementById("challanItemsDetails").innerHTML = "";
		  //hide_popup('popUpDiv4');
		  //hide_popup('popUpDiv5');
		  hide_popup('popUpDiv10');
		  
		}
		
		if(mode=='11')
		{
		  document.getElementById("samplesenddtl").innerHTML = "";
		  hide_popup('popUpDiv11');
		  
		}
		
		if(mode=='12')
		{
		  document.getElementById("samplesenditembatchdtl").innerHTML = "";
		  hide_popup('popUpDiv12');
		  
		}
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
	  //newwin.document.write(document.getElementById('supplierPoDtlsDivId').innerHTML);
	  newwin.document.write(document.getElementById('IssueVoucherDtlPopUpOneDivId').innerHTML);
	}
	if(mode=='2')
	{
	  newwin.document.write(document.getElementById('InstituteIssueDtlsDivId').innerHTML);
	}
	if(mode=='3')
	{
	  newwin.document.write(document.getElementById('IssueNumberDtlsDivId').innerHTML);
	}	
	if(mode=='4')
	{
	  newwin.document.write(document.getElementById('recieveVoucherDetails').innerHTML);		  
	}	
	if(mode=='5')
	{
	  newwin.document.write(document.getElementById('poChallanDetails').innerHTML);
	}	
	if(mode=='6')
	{
	  newwin.document.write(document.getElementById('activityPrint').innerHTML);
	}
	if(mode=='10')
	{
	  newwin.document.write(document.getElementById('challanItemsDetails').innerHTML);
	}	
	if(mode=='11')
	{
	  newwin.document.write(document.getElementById('samplesenddtl').innerHTML);
	}	
	if(mode=='12')
	{
	  newwin.document.write(document.getElementById('samplesenditembatchdtl').innerHTML);
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



function validate(){

	var hisValidator = new HISValidator("dailyActivityRptFB");

//		hisValidator.addValidation("strStartFinancialYear", "req","Start Financial Year is a mandatory field");
	
		hisValidator.addValidation("strStoreId", "dontselect=0","Please Select District Drug Warehouse Name");

		hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

		
if(retVal)
{
	var diffdate = dateDiff(document.forms[0].strFromDate.value,document.forms[0].strToDate.value); 
//	alert(diffdate);
	 if(parseInt(diffdate)>365)
	 {
		alert("Difference Between From Date and To Date Should not be greater than 365 days");
		return false;
	 }	
	
	document.forms[0].strStoreId.value =  document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value;  
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


