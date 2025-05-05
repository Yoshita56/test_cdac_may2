function printDataOne(mode) 
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
	  newwin.document.write(document.getElementById('issueDtlsDivId').innerHTML);	  
	}
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();
	 document.getElementById("strCrNo").focus();

}

function printDataForTransfer() 
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
	
	newwin.document.write(document.getElementById('transferDtlsDivId').innerHTML);
	
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}	

function hideIssuePopupOne() 
{
	document.getElementById("issueDtlsDivId").innerHTML = "";
	hide_popup('popUpDiv');
	document.getElementById("strCrNo").focus();

}


function hideTransferPopup(mode)
{
		
				 
          document.getElementById("transferDtlsDivId").innerHTML = "";			
		  hide_popup('popUpDiv');
		 
		
}

function transferToViewPage()
{
	
	document.getElementsByName("strTmpTransferNo")[0].value='0';
	
	if (document.getElementsByName("strViewChk")[0].checked) 
	{
		document.forms[0].hmode.value = "VIEWPAGE";
		document.forms[0].submit();
	}
	else
	{
		document.forms[0].hmode.value = "INITVAL";
		
		document.forms[0].submit();
	}
}

function cancelPage() {
	document.forms[0].hmode.value = "CANCELPAGE";
	document.forms[0].submit();
}

function clearPage() {

document.forms[0].strTmpTransferNo.value='0';
	var mode = "INITVAL";
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();
}

function searchTransferDetails() {

	var hisValidator = new HISValidator("onlineTransferDetailTransFB");

	hisValidator.addValidation("strStoreId", "dontselect=0", "Please Select DDW Name ");
	hisValidator.addValidation("strFromDate", "req", "Please Select From Date");
	hisValidator.addValidation("strToDate", "req", "Please Select To Date");

	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();


//	document.forms[0].strId.value = document.forms[0].strStoreId.value;
//	document.forms[0].itemCategory.value = document.forms[0].strOrderNo.value;

	if(retVal) 
	{
		
		var url = "OnlineTransferDetailTransCNT.cnt?hmode=SEARCHTRANSFERDETAILS&transferStoreId="+ document.forms[0].strStoreId.value
			+"&fromDate="+ document.forms[0].strFromDate.value+"&toDate="+ document.forms[0].strToDate.value;

		ajaxFunction(url, "2");

	}
	else 
	{
		return false;
	}

}


function getOrderNo() {

	strStoreId = document.forms[0].strStoreId.value;
	
	if (strStoreId != null && strStoreId != "0") 
	{
		var url = "OnlineTransferDetailTransCNT.cnt?hmode=getOrderNo&transferStoreId="+ document.forms[0].strStoreId.value;
		ajaxFunction(url, "1");
	}
	 else 
	{
		document.getElementById("orderNoDivId").innerHTML = "<select name ='strOrderNo' class='comboHalfMax' ><option value='0'>Select Value</option></select>";
	}
}


function getAjaxResponse(res, mode) {

	if (mode == "1") {
		if (res == "") {
			document.getElementById("orderNoDivId").innerHTML = "<select name ='strOrderNo' class='comboHalfMax' ><option value='0'>Select Value</option></select>";
		} else {
			var objVal = document.getElementById("orderNoDivId");
			objVal.innerHTML = "<select name ='strOrderNo' class='comboHalfMax' >"
					+ res + "</select>";
		}
	}

	if (mode == "2") {

		var objVal = document.getElementById("searchTransferDtlsDivId");		
		objVal.innerHTML = res;
		document.getElementById("searchTransferDtlsDivId").style.display='';

	}

	if (mode == "3") {
		var objVal = document.getElementById("itemDtlId");
		objVal.innerHTML = res;
		document.getElementById("itemDtlId").style.display='';
		document.getElementById("remarksDtlId").style.display='block';
				
	}

	 if(mode=="4")
     {
     	
     	 var objVal2 = document.getElementById("transferDtlsDivId");
     	 objVal2.innerHTML = res;
     	 popup('popUpDiv', '100', '80');
     	
     	
     }
     
	if (mode == "5") {
		if (res == "") {
			document.getElementById("unitDivId").innerHTML = "<select name ='strUnitCode' class='comboNormal' ><option value='0'>Select Value</option></select>";
		} else {
			var objVal = document.getElementById("unitDivId");
			objVal.innerHTML = "<select name ='strUnitCode' class='comboNormal' onchange='getConsultantCombo();' >"
					+ res + "</select>";
		}
	}

	if (mode == "6") {
		if (res == "") {
			document.getElementById("consultantDivId").innerHTML = "<select name ='strPrescribedBy' class='comboNormal' ><option value='0'>Select Value</option></select>";
		} else {
			var objVal = document.getElementById("consultantDivId");
			objVal.innerHTML = "<select name ='strPrescribedBy' class='comboNormal' >"
					+ res + "</select>";
		}
	}
	if (mode == "7") {

		var objVal = document.getElementById("itemDtlDivId");
		objVal.innerHTML = res;

		getRequestDtl();

	}
	if (mode == "8") 
	{	
		var itemStockObj = document.getElementById("issueDtlsDivId");
		itemStockObj.innerHTML = res;
		document.getElementById("normalMsg").innerHTML = "Data Saved Successfully";
		popup('popUpDiv', '80', '60');	
		document.getElementById("strCrNo").focus(); 
	}
}

function hideIssueDetails(divId) {
	hide_popup_menu(divId);
}

function initGoFunc(eve) {
	var flag = validateData(eve, 5);
	if (flag) {
		if (eve.keyCode == 13) {
			onGoButton();
		}
	} else {
		return false;
	}

}

function goFuncOnEnter(e) {
	if (e.keyCode == 13) {
		onGoButton();
	} else {
		return false;
	}
}

function onGoButton() {

	var hisValidator = new HISValidator("onlineTransferDetailTransFB");

	hisValidator.addValidation("strStoreId", "dontselect=0", "Please Select DDW Name ");
	hisValidator.addValidation("strOrderNo", "dontselect=0", "Please Select Order No");

	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

	document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	document.forms[0].orderNO.value = document.forms[0].strOrderNo[document.forms[0].strOrderNo.selectedIndex].text;

//	document.forms[0].strId.value = document.forms[0].strStoreId.value;
//	document.forms[0].itemCategory.value = document.forms[0].strOrderNo.value;

	if (retVal) {
		document.forms[0].hmode.value = "INITVALGO";
		document.forms[0].submit();

	} else {
		return false;
	}
}


 // function to show report after save data
function getReport()
{
	
	//costReq();
	var transferNo    = document.forms[0].strTmpTransferNo.value;
	var storeId       = document.forms[0].strTmpStoreNo.value;
//	var transferDate  = document.forms[0].strTmpTransferDate.value;    
   
   
 if(parseInt(transferNo)!= 0)
 {
 	//  alert("transferNo"+transferNo);
   var mode="TRANSFERDTL";
   var url="OnlineTransferDetailTransCNT.cnt?hmode="+mode
   			+"&transferNo="+ transferNo+"&storeId="+storeId;
   
   ajaxFunction(url,"4");
 }  	
    	
	
}

function printVoucher()
{
	var count =0;
	var len = document.getElementsByName("transferRadioButton").length;
	
	for(var i=0;i<len;i++)
	{
		if(document.getElementsByName("transferRadioButton")[i].checked==true)
		{
			count++;	
			break;		
		}
	}	
		if(count==0)
		{
			
			alert("Please Select Atleast One of the Transfer Details");
			return false;
					 	
		}
		else
		{
					var transferNo    = document.getElementsByName("tempTransferNo")[i].value;
					//var storeId       = document.getElementsByName("strToStoreId")[i].value;
					var storeId       = document.getElementsByName("strStoreId")[0].value;
					var transferDate  = document.getElementsByName("strTransferDate")[i].value.split(" ")[0];    
					var transferDWH  = document.getElementsByName("strTransferTo")[i].value;
				 				    
				 if(transferNo!='0')
				 { 
				   var mode="TRANSFERDTL";
				   var url="OnlineTransferDetailTransCNT.cnt?hmode="+mode+"&transferNo="+ transferNo+"&storeId="+storeId
				   			+"&transferDate="+transferDate+"&dwhName="+transferDWH;
			//alert(url);	   
				   ajaxFunction(url,"4");
				 } 
		}
		
	
	
}



function clickBatchChkBox(index)
{
//	len = document.getElementsByName("batchCheckbox").length;
	
	
		if(document.getElementsByName("batchCheckbox")[index].checked==true)
		{
			document.getElementsByName("strTransferQty")[index].disabled=false;		
			document.getElementsByName("checkboxFlag")[index].value='1';
		}
		else
		{
			document.getElementsByName("strTransferQty")[index].disabled=true;
			document.getElementsByName("strTransferQty")[index].value='';
			document.getElementsByName("strCost")[index].value='';			
			document.getElementsByName("checkboxFlag")[index]='0';
		}
		
		
		
		
		
		totalCost();
		
		
	
		
}

function totalCost()
{	   
       	    var qtyObj  = document.getElementsByName("strTransferQty");
       	    var costObj = document.getElementsByName("strCost");
       	    
       	    
       	    
       	    var totalQty  = parseInt("0");
			var totalCost = parseFloat("0.00");
			
			//alert(costObj.length);
		   	if (costObj.length > 0) 
			{
		       
				for ( var i = 0; i <costObj.length; i++)
				{		
					if(qtyObj[i].value.length!='')
					{
					totalQty  = totalQty + parseInt(qtyObj[i].value);
					totalCost = totalCost + parseFloat(costObj[i].value);	
					}	
		 		}
		
			}

//alert("totalQty"+totalQty);
//alert("totalCost"+totalCost);

	    totalCost = roundValue(totalCost, 2);
	    
	    
	    document.getElementsByName("strTotalTransferredQty")[0].value = totalQty;
	    document.getElementsByName("strTotalTransferredCost")[0].value = totalCost;
	    
//	    document.getElementById("totalTransferredCostDivId").innerHTML.fontcolor('red');
//	    document.getElementById("totalTransferredQtyDivId").innerHTML.fontcolor('red');
	    
	    
        //document.forms[0].strNewDemandFinalApproxAmt.value=total;
        //alert("strNewDemandFinalApproxAmt :"+document.forms[0].strNewDemandFinalApproxAmt.value);
       
}	 

function checkAvailQtyTwo(index) 
{      
	  
	    var rateObj = document.getElementsByName("strRatePerUnit")[index].value;
	    var qtyObj  = document.getElementsByName("strTransferQty")[index].value;
		
		var avlQtyObj  = document.getElementsByName("strAvailableQty")[index].value;
		
		
       					
			var qty    = parseFloat(qtyObj);	
			var rate   = parseFloat(rateObj);
		
		//alert("index"+index);
	    //alert("qty"+qty);
	    //alert("rate"+rate);
		
			var total = parseFloat("0.00");
				
					if(isNaN(rate) || rate=="") rate = "0";
					if(isNaN(qty)  || qty=="") qty = "0";
				    if(qty=='0')		
					{
					  
					  total = parseFloat(qty * rate);
					}
					else
					{
					  total = parseFloat(qty * rate);
					} 			
					
					total = roundValue(total, 2)
		document.getElementsByName("strCost")[index].value=total;
															
		//	document.getElementById(costDiv.substring(0,12)+""+index).value = roundValue(total, 2);
			
		//	document.getElementById("strCost"+index).value = roundValue(total, 2);
			
				totalCost();
	return true;
}


function validate1()
{
	//alert("batch Length:"+document.getElementsByName("batchCheckbox").length);
	
	var transferredQty = parseInt(document.getElementsByName("strTotalTransferredQty")[0].value);
	
	if(isNaN(transferredQty))
	transferredQty = parseInt("0");
	
	if(transferredQty==0)
	{
		alert("Please Select Atleast One of the Batch Detais and Enter the Transfer Qty");
		document.getElementsByName("strTransferQty")[0].focus();
		return false;		
	}
	else
	{
		//for(var i=0;i<document.getElementsByName("batchCheckbox").length;i++)
		
		if(transferredQty>parseInt(document.getElementsByName("strOrderQtyBase")[0].value) )
		{
			alert("Total Transfer Qty Should Not Be Greater Than Ordered Qty "+document.getElementsByName("strOrderQtyBase")[0].value);
			return false;	
			
		}
		
		for(var i=0;i<document.getElementsByName("strTransferQty").length;i++)
		{
			
				if(document.getElementsByName("batchCheckbox")[i].checked==true)
				{
					if(parseInt(document.getElementsByName("strTransferQty")[i].value)>parseInt(document.getElementsByName("strAvlQtyBase")[i].value))
					{
						alert("Transfer Qty Should Not Be Greater Than Available Qty");
						document.getElementsByName("strTransferQty")[i].focus();
						return false;	
					}
					
				}			
		}
		
		
		
		if(confirm("You Are Going To Save Record(s) !"))
		{
				if(confirm("Are You Sure ?"))
				{
					for(var i=0;i<document.getElementsByName("strTransferQty").length;i++)
					{
						document.getElementsByName("strTransferQty")[i].disabled=false;
						//document.getElementsByName("strTransferQty")[i].readonly=false;
					}
					
					document.forms[0].hmode.value = "INSERT";
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


function  clickTransferDetailsRadioButton()
{
	strId		=	document.getElementsByName("strStoreId")[0].value;	
	
		len = document.getElementsByName("transferRadioButton").length;
	
	for(var i=0;i<len;i++)
	{
		if(document.getElementsByName("transferRadioButton")[i].checked==true)
		{
			transferNo	=	document.getElementsByName("tempTransferNo")[i].value;
			document.getElementsByName("strTransferNo")[0].value = transferNo;
			//transferNo	=	document.getElementsByName("strTransferNo")[i].value;
			//strId		=	document.getElementsByName("strToStoreId")[i].value;	
			
		}
	}


		var url = "OnlineTransferDetailTransCNT.cnt?hmode=ITEMDETAILS&transferNo="+ transferNo+"&strId="+ strId;
					
//alert(url);					
		ajaxFunction(url, "3");
	
}

function clickBackButton()
{	
	document.getElementsByName("strViewChk")[0].checked =false;

	transferToViewPage();
}

function clearViewPage()
{
	document.getElementsByName("strViewChk")[0].checked =true;
	
	transferToViewPage() 
}


function clearDivId()
{
	document.getElementById("searchTransferDtlsDivId").innerHTML='';
	document.getElementById("itemDtlId").innerHTML='';
	document.getElementById("remarksDtlId").style.display='none';
	
}


function cancelTransferRequest()
{
	var count = 0;
			
				for(var i=0;i<document.getElementsByName("transferRadioButton").length;i++)
				{
					if(document.getElementsByName("transferRadioButton")[i].checked==true)
					{
						document.getElementsByName("strTransferNo")[0]=document.getElementsByName("tempTransferNo")[i];
						
						count++;
						break;			
					}
				}
				
				if(count==0)
				{
					alert("Please Select Atleast One of the Transfer Detais and then Delete that Record");
					return false;		
				}
	
	var hisValidator = new HISValidator("onlineTransferDetailTransFB");

	hisValidator.addValidation("strRemarks", "req", "Remarks is a mandatory field");
	hisValidator.addValidation("strRemarks","maxlen=100", "Remarks should have less than or equal to 100 Characters" );

	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

	if (retVal) 
	{
				
				
					if(confirm("Are You sure you Want to Delete this Record?"))
					{
						document.forms[0].hmode.value = "cancelDrugTransferDtl";
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