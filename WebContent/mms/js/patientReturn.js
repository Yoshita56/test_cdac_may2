var printflag = true;
var retValue = true;

function goFunc() 
{
		var hisValidator = new HISValidator("patientReturnBean");
		
		hisValidator.addValidation("strStoreId", "dontselect=0","Select Store Name Combo ");
		hisValidator.addValidation("strItemCatId", "dontselect=0","Select Category Combo ");		
		hisValidator.addValidation("strCrNo", "req", "CR No. is a Mandatory Field" );

		var retVal = hisValidator.validate();
		hisValidator.clearAllValidations();
		
		document.forms[0].storeName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
		document.forms[0].storeHidId.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value;

		document.forms[0].itemCatName.value = document.forms[0].strItemCatId[document.forms[0].strItemCatId.selectedIndex].text;
		document.forms[0].itemCatHidId.value = document.forms[0].strItemCatId[document.forms[0].strItemCatId.selectedIndex].value;

		document.forms[0].crNoHid.value = document.forms[0].strCrNo.value;

		if (retVal) 
		{
				document.forms[0].hmode.value = "GO";	
			    document.forms[0].submit();
		} 
		else 
		{
			return false;
		}
}	

function validateListSave()
{
	var saveObj = document.getElementById("btnComboId");
	
	if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	{
		saveObj.style.display = "none"; 
		
			 var hisValidator = new HISValidator("patientReturnBean");
		     //hisValidator.addValidation("strIssueNo","dontselect=0","Select Issue No" );
	         hisValidator.addValidation("strReturnQty","req","Return Quantity is a Mandatory Field" );
		     
		          var retVal = hisValidator.validate();
		          if(retVal)
		          {          	        
						    var reqQty         = document.getElementsByName("strReturnQty");
						    var reqQtyUnit     = document.getElementsByName("strReturnQtyUnitId");
						    var count = 0;				   
						    												
							 for(var i=0; i<reqQty.length; i++)
							 {						 
								 	if(reqQty[i].value=='0' || reqQty[i].value == 0)
								 	{
								 		count++;
								 	}												 	
							 }									  
																	
							if(count == (reqQty.length))
							{
								alert("Please Enter At Least One Quantity Greater than Zero!!!");
								saveObj.style.display = '';
								return false;
							}
						  var conf = confirm("Going To Save Return Request For [ "+(parseInt(reqQty.length)-parseInt(count))+" ] Items Out of [ "+parseInt(reqQty.length)+" ] !!");
				          if(conf == true)
				          {
				               var conf1 = confirm("Are you sure !!!");
				               if(conf1 == true)
				               {	              
								 for(var i=0;i<reqQty.length;i++)
								 {						 
									 	reqQtyUnit[i].disabled=false; 						 	
								 }
								  document.getElementsByName("strRecommendDate")[0].disabled = false;
					              document.forms[0].hmode.value="INSERT_LIST";
					              console.log("hmode---->"+document.forms[0].hmode.value);
						       	  document.forms[0].submit();
				               }
				              else
				               {
				               	 saveObj.style.display = '';
				                 return false;
				               }
				           }
				          else
				           {
				           		 saveObj.style.display = '';
				                 return false;
				           } 
		          }
		          else
		           {
		           		 saveObj.style.display = '';
		                 return false;
		           }
	  }
	  else
	  {
	  	    saveObj.style.display = '';
			return false;
	  }           
}

function getReport()
{

var issueNo =  document.forms[0].strReturnNo.value;
var storeId =  document.forms[0].storeHidId.value; //10201249
var strCrNo =  document.forms[0].crNoHid.value;
//var IndentDate=document.forms[0].strRequestDate.value

//return false;
	if(issueNo!="0" && issueNo!= "" )
	{
		//alert("getIssueDtls call");
		getIssueDtls('6', storeId, issueNo,strCrNo,"0");
	}
	document.forms[0].strReturnNo.value ="0";
}
function getIssueDtls(strMode, strStoreId, strIssueNo,strIndentNo,strIndentDate,ucReq) {
	gblMode = strMode;
	gblStoreId = strStoreId;
	gblIssueNo = strIssueNo;
	
	if(!isNaN(strIndentNo)){
		 if(strIndentNo.length>0){
	  	gblIndentNo=strIndentNo;
	  	gblIndentDate=strIndentDate;
	  }else{
	  		gblIndentNo="0";
	  		gblIndentDate="0";
	  }
	}else{
		    gblIndentNo="0";
	  		gblIndentDate="0";
	}
    var itemStockObj = document.getElementById("issueDtlsDivId");

	if (itemStockObj.innerHTML == "") {

		var hmode = "ISSUEDTLSINITNEW";
		
		var url = "PatientReturnTransCNT.cnt?hmode=" + hmode + "&strMode=" + strMode
		+ "&strStoreId=" + strStoreId + "&strIssueNo=" + strIssueNo+"&crNo="+gblIndentNo+
		  "&strIndentDate="+gblIndentDate+
		  "&strUCReq="+ucReq;
//		alert('url11-->'+url);	
		ajaxFunction2(url, "1", "getIssueDtlsAjaxResponse");

	} else {
		// set for 1024 * 760 screen don't change this
		popup('popUpDiv', '80', '60');
	}

}
			
function getIssueDtlsAjaxResponse(res, mode) {
	//STOCKDTLSINIT
	if (mode == '1') {
		var itemStockObj = document.getElementById("issueDtlsDivId");
		itemStockObj.innerHTML = res;
		popup('popUpDiv', '80', '60');
	}
}

 
function hideIssuePopup(){
	
	document.getElementById("issueDtlsDivId").innerHTML = "";
	
	hide_popup('popUpDiv');
	
}

function generateIssueReportFunc(obj, i) 
{
	indexglobal = i;
	parentPopup = obj;
	var issueNo     = document.getElementById('strHlpReturnNo' + i).value;
	var storeId     = document.getElementById('strHlpStoreId' + i).value;
	var IndentNo    = document.getElementById('strHlpCrNo' + i).value;
	var IndentDate  = "0";
	
	if (issueNo != "0") {
		getIssueDtls('2', storeId, issueNo, IndentNo, IndentDate);
	}

}
function printData() {
    document.getElementById("printImg").style.display = "none"; 
    
    const contentToPrint = document.getElementById("issueDtlsDivId").cloneNode(true);
    const newWin = window.open('', '', 'width=700,height=700,scrollbars=yes');
    newWin.document.write('<html><head>');
    
    newWin.document.write('<style type="text/css">');
	    newWin.document.write('body, .invoice-table {');
	    newWin.document.write('  font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;');
	    newWin.document.write('  font-size: 11px;'); // Adjust font size for readability
	    newWin.document.write('  margin: 0;'); // Remove margins
	    newWin.document.write('  padding: 0;'); // Remove padding
	    newWin.document.write('  line-height: 1;'); // Remove line spacing 
	    newWin.document.write('  box-sizing: border-box;'); // Ensure full utilization of page width/height
	    newWin.document.write('}');

	    // A4 page layout styling
	    newWin.document.write('@media print {');
	    newWin.document.write('  @page {');
	    newWin.document.write('    size: A4 portrait;'); // Ensure A4 landscape
	    newWin.document.write('    margin: 6mm 5mm;'); 
	    newWin.document.write('  }');
	    newWin.document.write('  body {');
	    newWin.document.write('    margin: 0;'); 
	    newWin.document.write('    padding: 0;');
	    newWin.document.write('  }');
	    
	    newWin.document.write('  .invoice-table-header-dtls {');
	    newWin.document.write('    margin: 0 auto;');
	    newWin.document.write('    font-size: 12px;');
	    newWin.document.write('  }');
	    
	    newWin.document.write('  .invoice-table {');
	    newWin.document.write('    width: 100%;');
	    newWin.document.write('    table-layout: auto;'); 
	    newWin.document.write('    border-collapse: collapse;');
	    newWin.document.write('    border: 1px solid black;');
	    newWin.document.write('    page-break-inside: auto;'); 
	    newWin.document.write('  }');
	    
	    newWin.document.write('  .invoice-table th, .invoice-table td {');
	    newWin.document.write('    padding: 7px;'); 
	    newWin.document.write('    text-align: center;');
	    newWin.document.write('    word-wrap: break-word;'); 
	    newWin.document.write('    border: 1px solid black;');
	    newWin.document.write('    font-size: 11px;'); 
	    newWin.document.write('  }');
	    
	    newWin.document.write('  .invoice-table tr {');
	    newWin.document.write('    page-break-inside: avoid;'); 
	    newWin.document.write('  }');
    newWin.document.write('</style>');
    
    newWin.document.write('</head><body>');
    newWin.document.write(contentToPrint.outerHTML);
    newWin.document.write('</body></html>');
    newWin.document.close();
    
    newWin.onload = function () {
        newWin.print();
        newWin.close();
        document.getElementById("printImg").style.display = "block"; 
    };
}
/*
function printData() 
{

	newwin = window.open('', 'printwin',
			'left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } @media screen and (orientation: portrait) {  #toolbar { width: 100%; }} </style>\n')
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

}*/
function quantityUnitValue(index)
{
	if(document.getElementById('strReturnQtyUnitId'+index).value!='0')
	{
	
		var balQty     = document.getElementById('strBalQty'+index).value;
		var returnQty  = document.getElementById('strReturnQty'+index).value;
		var returnUnit = document.getElementById('strReturnQtyUnitId'+index).value;
		
		var temp = returnUnit.split('^');
		
		var returnValue = parseFloat(returnQty) * parseFloat(temp[1]);
		
		if(returnValue>parseFloat(balQty))
		{
			
			alert("Return Quantity must be less than Balance Quantity");
			document.getElementById('strReturnQty'+index).value = "";
			//document.getElementById('strReturnQtyUnitId'+index).value = "0"
			document.getElementById('strTotalCost'+index).value = "0.00";
			document.getElementById('strNetCost').value = "0.00";		
			return false;
		}
		else
		{
					
			var qty        = document.getElementById('strReturnQty'+index).value;
			var unit       = document.getElementById('strReturnQtyUnitId'+index).value;				
			var unitBase   = unit.split('^');
			if(qty.length>0)
			{
			    
			    var costValue1 = parseFloat(qty) * parseFloat(unitBase[1]);
			}		
			else
			{
				var costValue1 = '0';
			}	
			var rateIndex  = document.getElementById('strRate'+index).value;
			var rateValues = rateIndex.split('@');			
			var costValue2 = parseFloat(rateValues[0]) / parseFloat(rateValues[2]);
			var cost       = costValue1 * costValue2;
			    cost       = roundValue(cost, 2);
			
			document.getElementById('strTotalCostDivId'+index).innerHTML = cost;
			document.getElementById('strTotalCost'+index).value = cost;
			
			
			var netCost = 0;
			var totalCost = document.getElementsByName('strTotalCost');
			var length = totalCost.length;
			
			for(var i=0;i<length;i++)
			{
				var costVal = totalCost[i].value;
				netCost = netCost + parseFloat(costVal);
				
			}
			
			netCost = roundValue(netCost,2);
			document.getElementById('strNetCostDivId').innerHTML = netCost;
			document.getElementById('strNetCost').value = netCost;	
				//alert("netCost-->"+document.getElementById('strNetCost').value);
		}
	}
	checkUnitQty(index);	
}


function checkUnitQty(index) {

		var returnQty = document.getElementById('strReturnQty'+index).value;
		var returnUnit = document.getElementById('strReturnQtyUnitId'+index).value;
		
		var temp = returnUnit.split('^');
		
		var returnValue = parseFloat(returnQty) * parseFloat(temp[1]);

			if (returnQty.indexOf('.') > -1 && temp[0] != '0') {

			alert("Qty must be an Integer ");
			document.getElementById('strReturnQty'+index).value = "";
			//document.getElementById('strReturnQtyUnitId'+index).value = "0"
			return false;
			}
			

}



function printData_O() 
{
	document.getElementById("printImg").style.display="none"; 
    const contentToPrint = document.getElementById("issueDtlsDivId").cloneNode(true);
    const newWin = window.open('', '', 'width=700,height=700,scrollbars=yes');
    newWin.document.write('<html><head>');
    newWin.document.write('<style type="text/css">');
    newWin.document.write('.hidecontrol { display: none; }');
    newWin.document.write('@media print {');
//    newWin.document.write('  #toolbar { display: none; }');
//    newWin.document.write('  body { margin: 0; padding: 0; }');
//    newWin.document.write('  @page { margin: 4mm 3mm; size: A4 portrait; }');
//    newWin.document.write('  table { table-layout: fixed; width: 100%; }');
    newWin.document.write('  table {border-collapse: collapse; }');
//    newWin.document.write('  table td { word-wrap: break-word; font-size: 12px; }');

    // Define page break rules for the repeat-table class
//     newWin.document.write('.repeat-table { page-break-before: always; }');

    newWin.document.write('}');
    newWin.document.write('</style>');
    
    newWin.document.write('</head><body>');
    newWin.document.write(contentToPrint.outerHTML);
    newWin.document.write('</body></html>');
    newWin.document.close();
    newWin.onload = function () {
        newWin.print();
        newWin.close();
        document.getElementById("printImg").style.display="block"; 
    };
}

function cancelToViewPage()
{
	document.forms[0].hmode.value = "VIEWPAGE";
	document.forms[0].submit();
}

function transferToViewPage() {
	document.forms[0].hmode.value = "VIEWPAGE";
	document.forms[0].submit();
}

function getViewItemDtl() {
	
	if (document.getElementsByName("strStoreId")[0].value == "0") 
	{
		//alert("Please Select Store From Combo");
	} 
	else if (document.getElementsByName("strCrNo")[0].value == "0" || document.getElementsByName("strCrNo")[0].value == "" || document.getElementsByName("strCrNo")[0].value == "3791325") 
	{
		//alert("Please Enter CR No");
	} 
	else 
	{
		var storeId = document.forms[0].strStoreId.value;
		var mode = "GOVIEWPAGE";
		var url = "PatientReturnTransCNT.cnt?hmode=" + mode + "&storeId="
				+ storeId + "&crNo="+document.forms[0].strCrNo.value+"&fromDate="
				+ document.forms[0].strFromDate.value + "&ToDate="
				+ document.forms[0].strToDate.value;
		//alert(url);
		ajaxFunction(url, "44");
	}

}

function hideIssuePopup(){
	
	document.getElementById("issueDtlsDivId").innerHTML = "";
	
	hide_popup('popUpDiv');
	
}

function generateIssueReportFunc(obj, i) 
{
	indexglobal = i;
	parentPopup = obj;
	var returnNo    = document.getElementById('strHlpReturnNo' + i).value;
	var storeId     = document.getElementById('strHlpStoreId' + i).value;
	var crNo   = document.getElementById('strHlpCrNo' + i).value;
	var IndentDate  = "0";
	var ucRq = "0";
	if (returnNo != "0") {
		getIssueDtls('2', storeId,  returnNo ,  crNo, IndentDate, ucRq);
	}

}

function getIssueDtls(strMode, strStoreId,  returnNo , crNo,strIndentDate,ucReq) {
	gblMode = strMode;
	gblStoreId = strStoreId;
	gblReturnNo =  returnNo;
	
	if(!isNaN(crNo)){
		 if( crNo.length>0){
	  	 gblcrNo= crNo;
	  	 gblIndentDate=strIndentDate;
	  }else{
	  		 gblcrNo="0";
	  		gblIndentDate="0";
	  }
	}else{
		     gblcrNo="0";
	  		gblIndentDate="0";
	}
    var itemStockObj = document.getElementById("issueDtlsDivId");

	if (itemStockObj.innerHTML == "") {

		var hmode = "ISSUEDTLSINITNEW";
		
		var url = "PatientReturnTransCNT.cnt?hmode=" + hmode 
			+"&strMode=" + strMode
			+"&strStoreId=" + strStoreId 
			+"&strIssueNo=" +  returnNo
			+"&crNo="+ gblcrNo
			+"&strIndentDate="+gblIndentDate
			+"&strUCReq="+ucReq;
			alert(url);	
		ajaxFunction2(url, "1", "getIssueDtlsAjaxResponse");

	} else {
		// set for 1024 * 760 screen don't change this
		popup('popUpDiv', '80', '60');
	}

}
			
function getIssueDtlsAjaxResponse(res, mode) {

	if (mode == '1') {

		var itemStockObj = document.getElementById("issueDtlsDivId");

		itemStockObj.innerHTML = res;
//		$("#issueDtlModal").modal("show");


		popup('popUpDiv', '80', '60');

	}

}

function getItemCatCmb()
{ 
	if(document.forms[0].strStoreId.value!='0'){
		var url ="PatientReturnTransCNT.cnt?hmode=ITEMCATEGORY&storeid="+document.forms[0].strStoreId.value
		 			+"&modeVal="+document.forms[0].strMode.value;
//		alert(url);
		ajaxFunction(url,"24");
	}else{
	    objVal= document.getElementById("itemCatDivId");
		objVal.innerHTML = "<select name ='strItemCatId' id='strItemCatId' class='custom-select'><option value='0'>Select Value</option></select>";
	}
}
//function for Patient Demographic Detail to block or hide
function ftn11()
{     
   if(document.forms[0].button1.value != 1 )
   {
    document.getElementById("patientDetailsDivId").style.display="block";
    document.getElementById("minus1").style.display="block";
    document.getElementById("plus1").style.display="none";
    document.forms[0].button1.value = 1;
   }
   else
   {
    document.getElementById("minus1").style.display="none";
    document.getElementById("plus1").style.display="block";
    document.getElementById("patientDetailsDivId").style.display="none";
    document.forms[0].button1.value = 0;
   } 
  
}
/*function IssueDetails()
{ 
 
 	var hospCode  = document.forms[0].hospCode.value;
 	var crNo      = document.forms[0].crNo.value;
 	
 	//if(parseInt(hospCode)==37913)
 	//{
 		
 		var url  = "PatientReturnTransCNT.cnt?hmode=ISSUEDETAILS_ALL_LIST&issueNo=1&strId="+document.forms[0].strId.value+"&crNo="+crNo;
 		
 		ajaxFunction(url,"3");
 		
 	}	
 	else
 	{	
        var url  = "ReturnFromTransCNTNEW.cnt?hmode=ISSUEDETAILS&issueNo="+document.forms[0].strIssueNo.value+"&strId="+document.forms[0].strId.value+"&crNo="+crNo;
        ajaxFunction(url,"2");
 	}
    //alert(url);
    
    
    
}
*/

/*function IssueDetails()
{ 
 	//var hospCode  = document.forms[0].hospCode.value;
 	//var crNo      = document.forms[0].crNo.value;
	//var url  = "ReturnFromTransCNTNEW.cnt?hmode=ISSUEDETAILS_ALL_LIST&issueNo=1&strId="+document.forms[0].strId.value+"&crNo="+crNo;
	document.forms[0].hmode.value = "RETURN_ITEM_LIST";	
    document.forms[0].submit();
	//ajaxFunction(url,"3");
}*/

/*
function getPatientAccStatus() 
{
		var hisValidator = new HISValidator("patientReturnBean");
		
		hisValidator.addValidation("strStoreId", "dontselect=0","Select Store Name Combo ");
		hisValidator.addValidation("strItemCatId", "dontselect=0","Select Category Combo ");		
		hisValidator.addValidation("strCrNo", "req", "CR No. is a Mandatory Field" );

		var retVal = hisValidator.validate();
		hisValidator.clearAllValidations();
		
		document.forms[0].storeName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
		document.forms[0].storeHidId.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value;

		document.forms[0].itemCatName.value = document.forms[0].strItemCatId[document.forms[0].strItemCatId.selectedIndex].text;
		document.forms[0].itemCatHidId.value = document.forms[0].strItemCatId[document.forms[0].strItemCatId.selectedIndex].value;

		document.forms[0].crNoHid.value = document.forms[0].strCrNo.value;

		if (retVal) 
		{
				document.forms[0].hmode.value = "RETURN_ITEM_LIST";	
				//alert("hmode"+document.forms[0].hmode.value);
			    document.forms[0].submit();
		} 
		else 
		{
			return false;
		}
}	*/







function initGoFunc(eve)
{
   var flag=validateData(eve,5);
	if(flag)
	{
			if(eve.keyCode==13)
			{
				goFunc();
				
			}
	}
	else
	{
			return false;
	}
}



function toViewPage() {
	//if (document.getElementsByName("strViewChk")[0].checked) {
		document.forms[0].hmode.value = "VIEWPAGE";
		document.forms[0].submit();
	//}
}

function backToPage() {
	//if (document.getElementsByName("strViewChk")[0].checked) {
		document.forms[0].hmode.value = "INITVAL";
		document.forms[0].submit();
	//}
}

function QtyValidation(index) 
{
	if (document.getElementById("strIssueQty" + index).value != "") 
	{
		var issueQty    = document.getElementById("strIssueQty" + index).value;		
		var remainQty   = document.getElementById("remainQty" + index).value;

		if (parseInt(remainQty) < parseInt(issueQty, 10)) 
		{
			alert("Administer Quantity [" +issueQty+ "] cannot be greater than Remain Quantity [ " + remainQty	+ " ] ");
			document.getElementById("strIssueQty" + index).value = remainQty;
			
			return false;
		} 
	}
	else
	{
		var issueQty    = document.getElementById("strIssueQty" + index).value;		
		
		if(document.forms[0].strMultiRowBatch[document.forms[0].strMultiRowBatch.selectedIndex].value != '0')
		{	
		  // BrandId ^ Batch No ^ In Hand Qty ^ Sale Price ^ Exp Date	
		    var avlQt = (document.forms[0].strMultiRowBatch[document.forms[0].strMultiRowBatch.selectedIndex].value).split("^")[2];
		    var batch = (document.forms[0].strMultiRowBatch[document.forms[0].strMultiRowBatch.selectedIndex].value).split("^")[1];
		  
		    if (parseInt(avlQt) < parseInt(issueQty, 10)) 
			{
				alert("Administer Quantity [" +issueQty+ "] cannot be greater than Avaliable Stock [ " + avlQt	+ " ] \n  For Selected Batch [ "+batch+" ] " );
				document.getElementById("strIssueQty" + index).value = remainQty;
				
				return false;
			} 
		
		
		}  
		
		
	}
	
}
/*function getIssuePopUp_Org(these, index) 
{

	var url = "PatientReturnTransCNT.cnt?hmode=ISSUEDTLPOPUP&strId="
			+ document.getElementById("strIssueSoreID" + index).value
			+ "&issueNo=" + document.getElementById("strIssueNo" + index).value+ "&strCrNo=" + document.getElementById("strCrNo" + index).value;
	// alert(url);
	ajaxFunction(url, "3");

}*/


function saveDirectIssue()
{	               	
	      		 	 			       	 					
	                  //console.log("---------SAVE_DIRECT-----------"); 
	 				  var count = parseInt(0);	
	 				  var total = parseInt("0");
	 				  var naDrugList ="";
	 				  	
	 				  var issueQty       = document.getElementsByName("strIssueQty");
	 				  
	 				  //console.log("No of Drug to Issue"+issueQty.length);
	 				  //alert("Length-->>"+issueQty.length);
		 				 if(parseInt(issueQty.length)==0)
					     {	
					    	 alert("No Drugs Avaliable for Issue. No Action Allowed !!");
					    	 document.forms[0].hmode.value = "INITVAL";
	 		            	 document.forms[0].submit();
							 return false;
					    	  
					     }	 				   			
	 					 for(var i=0;i<issueQty.length;i++)
 						 {
	 						 //console.log("Total Batch Count --"+i+"-- "+document.getElementsByName("strTotalBatch")[i].value);
	 						 
	 					    if(document.getElementsByName("strTotalBatch")[i].value=="0")
	 					    {
	 					    	count = count+1;	 					    	
	 					    	//break;	
	 					    }
 						 } 	
	 					 
	 					  //console.log("count-->>"+count);	
	 				     // alert("count-->>"+count);	 
	 				     if(parseInt(count)>=1)
	 				     {	
	 				    	 if(parseInt(issueQty.length) == parseInt(count))
	 				    	 {
	 				    		 /*
	 				    		 for(var i=0;i<issueQty.length;i++)
		 						 {
			 					    if(document.getElementsByName("strTotalBatch")[i].value=="0")
			 					    {
			 					    	document.getElementById('td1'+i).style.backgroundColor='#FF10F0';
			 					    }
		 					     } 	
	 				    		 */
	 				    	     alert("No Batch Avaliable for ["+count+"] Drug's  \n Save Not Allowed !!");	 						
	 						     count = 0;
	 						     return false;
	 				    	 } 
	 				      }
	 				   	  	   
		 				  if(issueQty.length>0)
		 				  {			
		 					 for(var i=0;i<issueQty.length;i++)
	 						 {
		 					    document.getElementsByName("strIssueQty")[i].disabled=false;		  
	 						 }
		 				  }	 			 				 			          
	 		              var conf1 = confirm("You are going to save Data.");
	 		              if(conf1 == true)
	 		              {	 
	 		            	  var conf2 = confirm("Are you sure?");
		 		              if(conf2 == true)
		 		              { 
		 		            	 
		 		            	  document.getElementById("savebutton").style.display="none";
		 		            	  document.forms[0].hmode.value = "NEW_OPD_ISSUE_INSERT";
		 		            	  document.forms[0].submit();
		 		              }
	 		              }
		 	
}


/*function getIssuePopUp(these, index) 
{
             		
			document.forms[0].strStoreId.value = document.getElementById("strIssueSoreID" + index).value;
	        document.forms[0].strIssueNum.value = document.getElementById("strIssueNo" + index).value;
	        document.forms[0].strCrNo.value    = document.getElementById("strCrNo" + index).value;
	        	       	      
			document.forms[0].hmode.value = "ISSUEDTLPOPUP";		
			//alert("Org Index----"+document.getElementById("strIssueNo" + index).value);
			//alert("For Index--"+index+"--"+document.forms[0].strIssueNum.value);			 
			document.forms[0].submit();

}*/


/* == issue no issue date == */
/*function getPrevIssueDtl_OffLine() {
	var strFromStoreId = document.getElementsByName('strStoreId')[0].value;
	if (strFromStoreId != 0) {
		var url = "PatientReturnTransCNT.cnt?hmode=PREVISSUEDTL"
				+"&strId="
				+document.forms[0].strStoreId.value 
				+"&fromDate="
				+ document.forms[0].strFromDate.value 
				+"&ToDate="
				+ document.forms[0].strToDate.value
				+"&crNo="
				+ document.getElementById('strCrNo').value;
				//+document.forms[0].strItemCat.value
				//&itemCategory=99
	//	alert(url);
		ajaxFunction(url, "20");
	} else {
		alert("Please Select Store");
	}
}*/

//view2 page on GO click >> to show "Issued Details List" (issue no & issue date ) 
/*function getPrevIssueDtl_OffLine() {
	var strFromStoreId = document.getElementsByName('strStoreId')[0].value;
	var strFromStoreName = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	var strAdmnMode = document.forms[0].strAdministrationMode[document.forms[0].strAdministrationMode.selectedIndex].value;
	var strAdmnType = document.forms[0].strAdministrationType[document.forms[0].strAdministrationType.selectedIndex].value;
	console.log(strFromStoreName);
	var strCrNocheck = document.getElementById('strCrNo').value;
	if (strFromStoreId == 0 ) {
		  alert("Please Select Store Name");	
	}
	else if (strCrNocheck =="" || strCrNocheck == "37913" || strCrNocheck == undefined){
		 alert("Please Enter PIN");
	}
	
	else {	
			var url = "PatientReturnTransCNT.cnt?hmode=PREVISSUEDTL"
				+"&strId="
				+document.forms[0].strStoreId.value
				+"&storeName="
				+strFromStoreName
				+"&fromDate="
				+ document.forms[0].strFromDate.value 
				+"&ToDate="
				+ document.forms[0].strToDate.value
				+"&crNo="
				+ document.getElementById('strCrNo').value
				+"&strAdmnMode="
				+ strAdmnMode
				+"&strAdmnType="
				+ strAdmnType;
			
			ajaxFunction(url, "20");
	} 
}*/

/*==IssueTransNew -ItemCategory field >> now use for view2 page ==*/
function getItemCat() {
	 	
		//alert(url);
		var temp = null;
		if (document.forms[0].strStoreId != null) {
			temp = document.forms[0].strStoreId.value;
		}
		if (temp==null || temp=="0") {
	    	var objVal = document.getElementById("itemcatDivId");
			objVal.innerHTML = "<select name = 'strItemCat' onchange='' class='browser-default custom-select'><option value='0'>Select Value</option></select>";
			return;
		}
		
		var mode = "ITEMCATCMB";

		var url = "PatientReturnTransCNT.cnt?hmode="+mode+"&storeId="
				+ document.forms[0].strStoreId.value + "&modeVal="
				+ document.forms[0].strMode.value;
		ajaxFunction(url, "1");
		
}


/* ==drug Qty rate cost == */
/*function getPreviousIssue() {

	if (document.getElementsByName("strStoreId")[0].value == "0") {
	alert("Please Select Store From Combo");
} else if (document.getElementsByName("strItemCat")[0].value == "0") {
	alert("Please Select Item Category From Combo");
} else {
	var mode = "ISSUEDTLPOPUP";
	var url = "PatientReturnTransCNT.cnt?hmode=" + mode+ "&strId="
			+ document.forms[0].strStoreId.value + "&itemCatNo="
			+ document.forms[0].strItemCat.value + "&fromDate="
			+ document.forms[0].strFromDate.value + "&ToDate="
			+ document.forms[0].strToDate.value;
	
	var url = "PatientReturnTransCNT.cnt?hmode=" + mode + "&strId="
	+ document.forms[0].strStoreId.value + "&itemCatNo="
	+ document.forms[0].strItemCat.value + "&fromDate="
	+ document.forms[0].strFromDate.value + "&ToDate="
	+ document.forms[0].strToDate.value;
	
	ajaxFunction(url, "3");
}*/

function getAjaxResponse(res, mode) {
	
	if (mode == "1") {
	/*	if (res == "") {
			document.forms[0].strItemCat.innerHTML = "<select name ='strItemCat' class='browser-default custom-select' ><option value='0'>Select Value</option></select>";
		} else {
			var objVal = document.forms[0].strItemCat;
			objVal.innerHTML = res;
			// getReqType();
		}*/
		
		var objVal = document.getElementById("itemcatDivId");
		objVal.innerHTML = "<select name = 'strItemCat' onchange='' class='browser-default custom-select'>"
				+ res + "</select>";
	}
	
	if (mode == "2") {n
		
		var objVal = document.getElementById("ItemCatg");
		objVal.innerHTML = "<select name = 'strItemCatgCombo' onchange='getIndentStoreCombo();' class='browser-default custom-select'>"
				+ res + "</select>";
				if(document.forms[0].strIsView.value=='0')
	            {
				   getPendingDemand();
	            }  
	}
	
	if (mode == "3") 
	{
		
		var objVal = document.getElementById("issueDtlsDivId");
		objVal.innerHTML = res;
		$("#issueDtlModal").modal("show");
		
		/*
		var objVal = document.getElementById("printableSlip");
		objVal.innerHTML = res;
		$("#printModal").modal("show");
		*/
		
	}

	if (mode == "4") {

		var objVal = document.getElementById("requestDivId");
		objVal.innerHTML = res;

		if (document.forms[0].strIssueMode.value != 0) {
			document.getElementById("reqDtlDivId").style.display = "none";
			document.getElementById("itemDtlOffDivId").style.display = "none";
		}

		document.getElementById("itemDtlDivId").style.display = "block";

		getItemDetails();

	}
	if (mode == "5") {
		if (res == "") {
			document.getElementById("unitDivId").innerHTML = "<select name ='strUnitCode' id='unit' class='browser-default custom-select' ><option value='0'>Select Value</option></select>";
		} else {
			var objVal = document.getElementById("unitDivId");
			// alert(res);
			objVal.innerHTML = "<select name ='strUnitCode' id='unit' class='browser-default custom-select' onchange='getConsultantCombo();' >"
					+ res + "</select>";
		}

		if (document.getElementsByName("strPatientStatus")[0].value == '2') {
			document.forms[0].strUnitCode.value = document
					.getElementsByName("strAdmissionDtlHidVal")[0].value
					.split("^")[16];
			document.getElementById("dep").disabled = true;
			document.getElementById("unit").disabled = true;
		} else if (document.forms[0].strDeptCode.value == document
				.getElementsByName("strEpisodeCode")[0].value.substr(0, 3))
			document.forms[0].strUnitCode.value = document
					.getElementsByName("strEpisodeCode")[0].value.substr(0, 5);

		getConsultantCombo();
	}

	if (mode == "6") {
		// alert('6');
		// alert(res);
		if (res == "") {
			document.getElementById("consultantDivId").innerHTML = "<select name ='strPrescribedBy' class='browser-default custom-select' ><option value='0'>Select Value</option></select>";
		} else {
			var objVal = document.getElementById("consultantDivId");
			objVal.innerHTML = "<select name ='strPrescribedBy' class='browser-default custom-select' >"
					+ res + "</select>";
		}
		getEpisodeList(document.getElementById("dep"));
	}
	if (mode == "7") {

		var objVal = document.getElementById("itemDtlDivId");
		objVal.innerHTML = res;

		getRequestDtl();

	}

	if (mode == "8") {
		var itemStockObj = document.getElementById("issueDtlsDivId");
		itemStockObj.innerHTML = res;
		document.getElementById("normalMsg").innerHTML = "Data Saved Successfully";
		document.forms[0].strStoreId.disabled = false;
		// popup('popUpDiv', '60', '80');
		// document.getElementById("strCrNo").focus();
	}

	if (mode == "9") {
		var itemStockObj = document.getElementById("transferDtlsDivId");
		// itemStockObj.innerHTML = res+"<p class='example'>.</p>"+res;
		itemStockObj.innerHTML = res;
		document.getElementById("normalMsg").innerHTML = "Data Saved Successfully";
		document.forms[0].strStoreId.disabled = false;
		// popup('popUpDiv1', '60', '80');
		// window.print();

	}
	if (mode == "11") {

		var retVal = false;

		if (document.getElementsByName("strQtyText").length <= 1) {
			alert("Please Select Item from Search Utility!!!");
			// saveObj.style.display = "";
			return false;
		}

		var hisValidator = new HISValidator("patientReturnBean");

		hisValidator.addValidation("strDeptCode", "dontselect=0",
				"Department is a Mandatory Field");

		hisValidator.addValidation("strUnitCode", "dontselect=0",
				"Unit is a Mandatory Field");

		// hisValidator.addValidation("strPrescribedBy", "dontselect=0",
		// "Prescribed By Doctor is a Mandatory Field");
		hisValidator.addValidation("strPrescribedFor", "req",
				"Prescribed for  is a Mandatory Field");
		// hisValidator.addValidation("strPrescriptionFrom", "dontselect=0",
		// "Prescription from is a Mandatory Field");

		hisValidator.addValidation("strQtyText", "req",
				"Quantity is a Mandatory Field");
		hisValidator.addValidation("strPrescriptionDate", "req",
				"Issue Date is a Mandatory Field");
		hisValidator.addValidation("strPrescriptionDate", "dtltet="
				+ document.forms[0].strCtDate.value,
				"Please Select Issue Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strPrescribedBy", "req",
				"Prescribed By is Mandatory");
		hisValidator.addValidation("strRemarks", "maxlen=100",
				"Remarks should have less than or equal to 100 Characters");

		retVal = hisValidator.validate();
		hisValidator.clearAllValidations();

		if (retVal) {
			var itemParVal = document.getElementsByName("itemParamValue");
			var itemUserValue = document.getElementsByName("itemUserValue");
			var reqQty = document.getElementsByName("strQtyText");
			var count = 0;

			if (itemParVal.length > 1) {
				for (var i = 0; i < itemParVal.length - 1; i++) {
					itemUserValue[i].disabled = false;

					if (reqQty[i].value > 0) {
						count = 1;
						break;
					}
				}
			}

			if (count == 0) {
				alert("Please enter one Quantity Greater than Zero!!!");
				// saveObj.style.display = "";
				return false;
			}

			if (itemParVal.length > 1) {
				for (var i = 0; i < itemParVal.length - 1; i++) {
					for (var j = i + 1; j < itemParVal.length - 1; j++) {
						// alert(itemUserValue[i].value);
						// alert(itemUserValue[i].value.split('^')[1]);
						// alert(itemUserValue[j].value.split('^')[1]);
						if (itemUserValue[i].value.split('^')[1] == itemUserValue[j].value
								.split('^')[1]) {
							alert('Kindly Remove Duplicate Drug '
									+ itemParVal[i].value.split('^')[0]
									+ ' From List');
							return false;
						}

					}
					// itemUserValue[i].disabled=false;
				}
			}

			// alert(document.getElementsByName("strLFAccountNo")[0].value);
			// return false;
			if (document.getElementsByName("strLFAccountNo")[0] == null
					|| document.getElementsByName("strLFAccountNo")[0] == "")
				var conf = confirm("You are going to save Data.");
			else
				var conf = confirm("Net Amount will be Deducted From your LF Account Balance.");
			if (conf == true) {
				var test = document.forms[0].strDuplicateItem.value;
				alert(test);
				if (test != '') {
					confirmBS(test);
				}

				var conf1 = confirm("Are you sure?");
				if (conf1 == true) {
					// alert(printflag);
					// alert(document.getElementsByName('strCatGrp')[0].value);
					// alert(document.forms[0].strLFAccountNo.value);

					document.getElementById("dep").disabled = false;
					document.getElementById("unit").disabled = false;
					/*
					 * hrgt_patient_dtl where hgnum_pat_status_code = 2 - > IPD
					 * Patient hrgt_patient_dtl where hgnum_pat_status_code = 3 - >
					 * OPD Patient
					 * 
					 */

					if (document.getElementsByName("strPatientStatus")[0].value != 2) {
						if ((document.getElementsByName("strLFAccountNo")[0] == null || document
								.getElementsByName("strLFAccountNo")[0] == '')) // document.getElementsByName('strCatGrp')[0].value
																				// !=
																				// '1'
																				// check
																				// removed
																				// to
																				// issue
																				// medicines
																				// to
																				// staff
																				// as
																				// car
																				// grp
																				// = 0
																				// means
																				// paid
																				// and
																				// 1
																				// means
																				// staff
							document.forms[0].hmode.value = "INSERTTEMP";
						else
							document.forms[0].hmode.value = "INSERT";
					} else {
						document.forms[0].hmode.value = "INSERTIPD";
					}
					document.forms[0].submit();
				} else {
					// saveObj.style.display = "";
					return false;
				}
			} else {
				// saveObj.style.display = "";
				return false;
			}

		} else {
			// saveObj.style.display = "";
			return false;
		}
		// }

	}
	if (mode == "12") {
		// alert(res);
		var reqType = document.forms[0].strRequestType;
		reqType.innerHTML = res;

		getUnitCombo();

	}

	if (mode == "119") {
		// alert(res);
		document.forms[0].strDuplicateItem.value = res;
		DirectIssue();

	}
	if (mode == "15") {

		var retVal = false;

		if (document.getElementsByName("strQtyText").length <= 1) {
			alert("Please Select Item from Search Utility!!!");
			return false;
		}

		var hisValidator = new HISValidator("patientReturnBean");

		hisValidator.addValidation("strDeptCode", "dontselect=0",
				"Department is a Mandatory Field");

		hisValidator.addValidation("strUnitCode", "dontselect=0",
				"Unit is a Mandatory Field");

		hisValidator.addValidation("strQtyText", "req",
				"Quantity is a Mandatory Field");
		hisValidator.addValidation("strPrescriptionDate", "req",
				"Issue Date is a Mandatory Field");
		hisValidator.addValidation("strPrescriptionDate", "dtltet="
				+ document.forms[0].strCtDate.value,
				"Please Select Issue Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strPrescribedBy", "req",
				"Prescribed By is Mandatory");
		hisValidator.addValidation("strRemarks", "maxlen=100",
				"Remarks should have less than or equal to 100 Characters");

		retVal = hisValidator.validate();
		hisValidator.clearAllValidations();

		if (retVal) {
			var itemParVal = document.getElementsByName("itemParamValue");
			var itemUserValue = document.getElementsByName("itemUserValue");
			var reqQty = document.getElementsByName("strQtyText");
			var count = 0;

			if (itemParVal.length > 1) {
				for (var i = 0; i < itemParVal.length - 1; i++) {
					itemUserValue[i].disabled = false;

					if (reqQty[i].value > 0) {
						count = 1;
						break;
					}
				}
			}

			if (count == 0) {
				alert("Please enter one Quantity Greater than Zero!!!");
				return false;
			}

			if (itemParVal.length > 1) {
				for (var i = 0; i < itemParVal.length - 1; i++) {
					for (var j = i + 1; j < itemParVal.length - 1; j++) {
						if (itemUserValue[i].value.split('^')[1] == itemUserValue[j].value
								.split('^')[1]) {
							if (reqQty[i].value > 0) {
								alert('Kindly Remove Duplicate Drug '
										+ itemParVal[i].value.split('^')[0]
										+ ' From List');
								return false;
							}
						}

					}
				}
			}

			var test = document.forms[0].strDuplicateItem.value;
			// alert(test);
			// console.log(test);
			if (test != '') {
				confirmBS(test, "", "1");
			} else {
				confirmBS("Are you sure?", "", "1");
			}
			// // confirmBS("Are you sure?","","1");

		} else
			return false;
		// }

	}
	printflag = false;

	if (mode == "16") {
		if (res != "")
			document.forms[0].strOffLineEpisode.innerHTML = res;
		else
			document.forms[0].strOffLineEpisode.innerHTML = "<option value='0'>Select Value</option>";

		getPresForm();

	}

	if (mode == "17") {
		if (res != "")
			$('select[name="strPrescriptionFrom"] option[value="' + res + '"]')
					.attr("selected", "selected");
		if (res == "0") {
			if (document.getElementsByName("strPatientStatus")[0].value == '2')
				$('select[name="strPrescriptionFrom"] option[value="2"]').attr(
						"selected", "selected");
		}

		// alert(res);
		// getReqType();
		getPresData();

	}

	if (mode == "18") {
		// alert(res.split("##")[2]);
		var reqType = document.getElementById("strPresData");
		reqType.innerHTML = res.split('##')[0];
		document.getElementsByName("rowIndex1")[0].value = res.split('##')[1];
		document.getElementsByName("rowLength1")[0].value = res.split('##')[1];
		document.forms[0].strRowCount.value = res.split('##')[1];
		document.forms[0].strDuplicateItem.value = res.split("##")[2];
		var Total = 0.00;

		for (var t = 1; t <= res.split('##')[1]; t++) {
			//console.log(document.getElementById("strQtyTreatText1-1").value);
			Total = parseFloat(Total)
					+ parseFloat(document
							.getElementById("strTotalTreatCostText1-" + t).value);
		}

		var i = 0;
		// var Total=0;
		while ((i < document.getElementsByName("strTotalCostText").length))// document.getElementsByName("strTotalCostText")[i].value!="")//!=null
																			// &&
																			// document.getElementsByName("strTotalCostText")[i]!=null)
		{
			if (document.getElementsByName("strTotalCostText")[i].value != "") {
				Total = parseFloat(Total)
						+ parseFloat(document
								.getElementsByName("strTotalCostText")[i].value);

			}
			i++;
		}

		document.getElementById("strNetCostDiv").innerHTML = "Rs. "
				+ Total.toFixed(2);
		document.getElementById("strNetCost").innerHTML = "Rs. "
				+ Total.toFixed(2);
		// console.log('Total :::::::::::' + Total);
		// document.getElementById("strNetCostDiv").innerHTML = "Rs.
		// "+Total.toFixed(2);
		// alert(res); getElementById
		// getItemCat();
		// getUnitCombo();
		// getConsultantCombo() ;

	}
	if (mode == "19") {
		if (res == "") {
			alert("No Billing Record Found For PIN [ "
					+ document.forms[0].strCrNo.value
					+ " ] \n No Issue Allowed ");
			return false;
		} else {

			/*
			 * 0 - Ac Balance 1 - Patient Catg Code 2 - ADMISSION_DATE 3 -
			 * DISCHARGE_DATE 4 - PATACCOUNT_STATUS in Text 5 -
			 * HBLNUM_PATACCOUNT_STATUS 6 - GETCATGRP 7 - HBLNUM_ACCOUNT_TYPE 8 -
			 * hblnum_finalbill_flag -- 5: final settlement,--1,2,3 (Active
			 * hold),--0 closed,4 dormat,6 cancel -- hblnum_finalbill_flag : =
			 * 91 Bed Transfer
			 */
			// alert(res);
			var accBalance = res.split('@')[0];
			var accStatusText = res.split('@')[4];
			var accStatusFlag = res.split('@')[5];

			// alert("--accStatusText--"+accStatusText+"-accStatusFlag---"+accStatusFlag);

			if (accStatusFlag == "5" || accStatusFlag == "0") {
				if (accStatusText != "0") {
					alert(" Billing Record \n For PIN [ "
							+ document.forms[0].strCrNo.value
							+ " ] has been "
							+ accStatusText
							+ "  \n   No Drug Dispensing Allowed  \n Page Going To Re-Set  !! ");
				} else {
					alert(" Billing Record \n For PIN [ "
							+ document.forms[0].strCrNo.value
							+ " ] has been Final Settelment or Closed  \n   No Drug Dispensing Allowed \n Page Going To Re-Set  !! ");
				}

				document.forms[0].strCrNo.value = "";
				document.forms[0].hmode.value = "INITVAL";
				document.forms[0].submit();
			} else {
				onGoButton();
			}

		}
	}
	if (mode == "20") {
		/*==added== to hide the last line on go click */
		var x = document.getElementById("mandatorydiv");
		x.style.display = "none";
		
		var objVal = document.getElementById("prevIssueDiv");
		
		objVal.innerHTML = res;
		if (document.getElementById("PrevIssueId").style.display == "none") {
			document.getElementById("PrevIssueId").style.display = "block";
		} else {
			document.getElementById("PrevIssueId").style.display = "none";
		}

	}
	if (mode == "21") 
	{ 
		var objVal = document.getElementById("patDtlHlp");		
		objVal.innerHTML = res;
		/*$(document).ready(function() {
			 $('#data-table').DataTable({
			        paging: false // Disable pagination
			    });
		});*/
		
		
	}
	
	if (mode == "22") 
	{ 
		var objVal = document.getElementById("administratedDtlDiv");	
		console.log(res);
		objVal.innerHTML = res;
		
	}
	if (mode == "23") 
	{ 
		var objVal = document.getElementById("patDtlHlp");	
		console.log(res);
		objVal.innerHTML = res;
/*		$(document).ready(function() {
		     $('#data-table').DataTable();
			 $('#data-table').DataTable({
			        paging: false // Disable pagination
			    });
		});*/
		
	}
	if(mode=="24"){ 
		var objVal= document.getElementById("itemCatDivId");
		//alert(res);
		objVal.innerHTML = "<select name ='strItemCatId' class='custom-select'>"+res+"</select>"; 		
	}	
	  if (mode == "44") 
	    {
			var objVal = document.getElementById("returnDtlId");
			if(res=="")
			{
				objVal.innerHTML="";
			}
			else
			{
				objVal.innerHTML = res;
			}
		}
	
}


/*
$(function() {

	var itemList = [];
	$('#strMultiRowItemId option').each(function() {
		itemList.push({
			"value" : this.textContent,
			"data" : this.value
		});
	});

	$('#strSearchDrug').autocomplete({
		lookup : itemList,
		minChars : 2,
		onSelect : function(suggestion) {
			getDrugNameSelected_off_Line(suggestion.data);
		}
	});

	$('#strSearchDrug').click(function() {
		$(this).val("");

	});
});
*/

function getDrugNameSelected_off_Line(itemId) {
	// alert("-->>"+itemId);

	var totRow = parseInt(document.getElementsByName("rowLength1")[0].value, 10);
	var indxRow = parseInt(document.getElementsByName("rowIndex1")[0].value, 10);

	var rowBatch = document.getElementsByName("itemParamValue");

	// 0.45 DEXTROSE NORMAL SALINE 500ML [ 0
	// ]^-^0^10^12.24^/^/^/^/^/^12~2907221207^Dec/2026^Dec/2021^/^/^10.0000000000000000^Active^12.24^No.^Indian
	// # 10^12.2400000000000000^0
	// #
	// 10001569^10103106^101006^0^1^0^0^10^6303^12.24^6303^6303^10212200017^2022-07-29
	// 00:00:00^1010005^12~2907221207^2026-12-20 00:00:00^2021-12-20
	// 00:00:00^0^0^0^0^0^0^0^0^0^-^0.00^0^0^0^10^12.24^6303^0^1^0^0^NA^@Abott
	// India Pvt Ltd^12.00">
	// 0.45 DEXTROSE NORMAL SALINE 500ML(12~2907221207)[ 0 ]

	var len = rowBatch.length;

	var passBatch = itemId.split("#")[0];

	for (var j = 0; j < len; j++) {

		var cBatch = rowBatch[j].value;

		if (passBatch == cBatch) {
			alert("Duplicate Drug  [" + rowBatch[j].value.split("^")[0]
					+ "]  not allowed !!");
			var searchId = 'strSearchDrug';
			document.getElementById(searchId).value = "";
			return false;
		}
	}

	addRows(new Array('strQtyText'), new Array('t', 't', 't', 't', 't', 't'),
			'1', '1', 'R');

	document.getElementById("itemParamValue1-" + (indxRow + 1)).value = itemId
			.split("#")[0];
	document.getElementById("itemCalcValue1-" + (indxRow + 1)).value = itemId
			.split("#")[1];
	document.getElementById("itemUserValue1-" + (indxRow + 1)).value = itemId
			.split("#")[2];

	document.getElementById("strBrandName1-" + (indxRow + 1)).innerHTML = (itemId
			.split("#")[0]).split("^")[0];
	document.getElementById("strBatch1-" + (indxRow + 1)).innerHTML = (itemId
			.split("#")[0]).split("^")[10];
	document.getElementById("strAvlQty1-" + (indxRow + 1)).innerHTML = (itemId
			.split("#")[1]).split("^")[0];
	document.getElementById("strRate1-" + (indxRow + 1)).innerHTML = (itemId
			.split("#")[1]).split("^")[1];

	var searchId = 'strSearchDrug';
	document.getElementById(searchId).value = "";

	document.getElementById("strQtyText1-" + (indxRow + 1)).focus();

	ReCalcualte_Amount();

}

function ReCalcualte_Amount() 
{
	var j = 0;
	var i = 0;
	var Total = 0;

	while ((j < document.getElementsByName("itemParamValue").length)) 
	{

		if (document.getElementsByName("strQtyText")[j].value != "") 
		{
			// hstnum_itembrand_id ^ HSTSTR_BATCH_NO ^ ROUND(HSTNUM_INHAND_QTY)
			// ^ ROUND(NVL(HSTNUM_RATE,0),2) ^ TO_CHAR(HSTDT_EXPIRY_DATE
			var qtyObj = document.getElementsByName("strQtyText")[j].value;
			var rateObj = document.getElementsByName("itemCalcValue")[j].value
					.split("^")[1];

			var total = parseFloat("0.00");
			var qty = parseFloat("0.00");
			var rate = parseFloat("0.00");

			qty = qtyObj;
			rate = rateObj;

			if (isNaN(rate) || rate == "")
				rate = "0";
			if (isNaN(qty) || qty == "")
				qty = "0";
			if (qty == '0') {
				total = parseFloat("0.00");
			} else {
				total = parseFloat(qty * rate);
			}
			document.getElementsByName("strTotalCostText")[j].value = roundValue(total, 2);
		}
		j++;
	}

	while ((i < document.getElementsByName("strTotalCostText").length))// document.getElementsByName("strTotalCostText")[i].value!="")//!=null
																		// &&
																		// document.getElementsByName("strTotalCostText")[i]!=null)
	{
		if (document.getElementsByName("strTotalCostText")[i].value != "") 
		{
			Total = parseFloat(Total)+ parseFloat(document.getElementsByName("strTotalCostText")[i].value);

		}
		i++;
	}
	/*
	 * document.getElementById("strNetCostDiv").innerHTML = "Rs.
	 * "+Total.toFixed(2); document.getElementsByName("strNetCost")[0].value=
	 * Total; document.getElementsByName("strPayDtl")[0].value= Total;
	 */
	document.getElementById("strNetCostDiv").innerHTML = "Rs. "
			+ roundValue(Total, 2);// Total.toFixed(2);
	document.getElementsByName("strNetCost")[0].value = roundValue(Total, 2); // Total.toFixed(2);
	document.getElementsByName("strPayDtl")[0].value = roundValue(Total, 2);// Total.toFixed(2);

}
function QtyValidationBeforeDelete_offline(index) {

	deleteRow(index, '1', '0');

	var i = 0;
	var Total = 0;

	while ((i < document.getElementsByName("strTotalCostText").length))// document.getElementsByName("strTotalCostText")[i].value!="")//!=null
																		// &&
																		// document.getElementsByName("strTotalCostText")[i]!=null)
	{
		if (document.getElementsByName("strTotalCostText")[i].value != "") {
			Total = parseFloat(Total)
					+ parseFloat(document.getElementsByName("strTotalCostText")[i].value);

		}
		i++;
	}

	document.getElementById("strNetCostDiv").innerHTML = "Rs. "
			+ Total.toFixed(2);
	document.getElementsByName("strNetCost")[0].value = Total;

	document.getElementsByName("strPayDtl")[0].value = Total;

}

function DirectIssue_Off() {
	//alert("DirectIssue_Off")
	var itemTmp = "";
	var itemParVal = document.getElementsByName("itemParamValue");
	if (itemParVal.length > 1) {
		for (var i = 0; i < itemParVal.length - 1; i++) {
			if (i == 0)
				itemTmp = itemParVal[i].value.split("^")[22];
			else
				itemTmp += "," + itemParVal[i].value.split("^")[22];
		}
	}

	var hisValidator = new HISValidator("patientReturnBean");

	hisValidator.addValidation("strQtyText", "req","Quantity is a Mandatory Field");
	retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

	if (retVal) {
		var itemParVal = document.getElementsByName("itemParamValue");
		var itemUserValue = document.getElementsByName("itemUserValue");
		var reqQty = document.getElementsByName("strQtyText");
		var count = 0;
		if (itemParVal.length > 1) {
			for (var i = 0; i < itemParVal.length - 1; i++) {
				itemUserValue[i].disabled = false;

				if (reqQty[i].value > 0) {
					count = 1;
					break;
				}
			}
		}

		if (count == 0) {
			alert("Please enter one Quantity Greater than Zero!!!");
			return false;
		}

		if (itemParVal.length > 1) {
			for (var i = 0; i < itemParVal.length - 1; i++) {
				for (var j = i + 1; j < itemParVal.length - 1; j++) {
					if (itemUserValue[i].value.split('^')[1] == itemUserValue[j].value
							.split('^')[1]) {
						if (reqQty[i].value > 0) {
							alert('Kindly Remove Duplicate Drug '
									+ itemParVal[i].value.split('^')[0]
									+ ' From List');
							return false;
						}
					}

				}
			}
		}

		document.forms[0].hmode.value = "DIRECTISSUE_OFFLINE";
		document.forms[0].submit();

	} else {
		return false;
	}

}

function QtyValidationBeforeDelete(index) {

	deleteRow(index, '1', '0');

	var i = 0;
	var Total = 0;

	while ((i < document.getElementsByName("strTotalCostText").length))// document.getElementsByName("strTotalCostText")[i].value!="")//!=null
																		// &&
																		// document.getElementsByName("strTotalCostText")[i]!=null)
	{
		if (document.getElementsByName("strTotalCostText")[i].value != "") {
			Total = parseFloat(Total)
					+ parseFloat(document.getElementsByName("strTotalCostText")[i].value);

		}
		i++;
	}

	document.getElementById("strNetCostDiv").innerHTML = "Rs. "
			+ Total.toFixed(2);
	document.getElementsByName("strNetCost")[0].value = Total;

	document.getElementsByName("strPayDtl")[0].value = Total;

}

function amtCalcWhenDel(gblIndex, rowIndex, typeIndex) {
	deleteRow(gblIndex, '1', '0');
}

function CallCustomFunc(val) {

	var reqQty = document.getElementsByName("strQtyText");
	reqQty[0].focus();

}

function getItemSelectPopup() {
	var strFromStoreId = document.getElementsByName('strStoreId')[0].value;
	var strItemCategory = document.getElementsByName('strItemCat')[0].value;
	if (strFromStoreId != 0 && strItemCategory != 0) {
		var strRequestType = "32";
		var strModeVal = "8";

		var strMultiRowCompArray = new Array('itemParamValue', 'itemCalcValue',
				'itemUserValue', 'strCost', 'strReqQty', 'strTotalCost');
		var strMultiRowCompTypeArray = new Array('t', 't');
		var strMultiRowFetchDataArray = new Array('1', '11', '4', '5');

		var layerIndex = "1";

		var userFunctionName = "CallCustomFunc";
		var userFunctionArgument = "test";
		var strUserInfo = "";
		var strUnitMode = "0"; // only base unit 1 Means Only Base Unit Show 0
								// Means All Unit Show in Unit Combo
		searchItemsWithUserFunction(strModeVal, strItemCategory,
				strRequestType, strFromStoreId, strMultiRowCompArray,
				strMultiRowCompTypeArray, strMultiRowFetchDataArray,
				layerIndex, userFunctionName, userFunctionArgument,
				strUserInfo, strUnitMode);

	} else {
		alert("Please Select Store and Category");
	}
}

function ftnTick(mode) {
	if (mode == '1') {
		document.forms[0].strOutOfStockFlag.value = '1';
		document.forms[0].OutOfStockFlag[0].checked = false;
		document.forms[0].OutOfStockFlag[1].checked = true;
	} else {
		document.forms[0].strOutOfStockFlag.value = '0';
		document.forms[0].OutOfStockFlag[0].checked = true;
		document.forms[0].OutOfStockFlag[1].checked = false;
	}

}
function getMultiRow(obj) {
	document.getElementById("hearderId").style.display = "block";
	var noOfRow = document.forms[0].strNoOfMultiRow.value;
	for (var i = 0; i < noOfRow; i++) {
		addRows(new Array('strNotInListDrugName', 'strNotInListDrugQty'),
				new Array('t', 't'), '2', '1', 'R')
	}

}

function checkPresQty(index) {
	var prescQty = document.getElementById("strPrescQty" + index).value;
	if (parseInt(prescQty, 10) == '0' || parseInt(prescQty, 10) == 0) {
		alert("Prescribe Quantity cannot be equal to Zero");
		document.getElementById("strPrescQty" + index).value = "";
		return false;
	}
}

function printDataOne(mode) {
	newwin = window.open('', 'printwin',
			'left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document
			.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n')
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
	// newwin.document.write('window.print();\n');
	newwin.document.write('chkstate();\n');
	newwin.document.write('}\n');

	newwin.document.write('<\/script>\n');
	newwin.document.write('</HEAD>\n');
	newwin.document.write('<BODY onload="print_win()">\n');
	if (mode == '1') {
		if (document.getElementById('issueDtlsDivId').innerHTML != "")
			newwin.document
					.write(document.getElementById('issueDtlsDivId').innerHTML);
		else
			newwin.document
					.write(document.getElementById('transferDtlsDivId').innerHTML);
	}
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();
	document.getElementById("strCrNo").focus();

}
function hideIssuePopupOne() {
	document.getElementById("transferDtlsDivId").innerHTML = "";
	hide_popup('popUpDiv1');
	// document.getElementById("strCrNo").focus();

}

function cancelIssue() {
	// showMenuFrame();
	document.forms[0].hmode.value = "RETURNTOMAINDESK";
	document.forms[0].submit();
	// window.parent.closeTab();
}

function clearIssue() {

	document.forms[0].reset();
}

var gblObject = "";

/*function getItemDetails() {

	var url = "PatientReturnTransCNT.cnt?hmode=ITEMDETAILS&reqNo=" + gblObject
			+ "&crNo=" + document.forms[0].crNo.value + "&strId="
			+ document.forms[0].strId.value;

	ajaxFunction(url, "7");

}
*/
/*function getConsultantCombo() {

	var url = "PatientReturnTransCNT.cnt?hmode=PRESCRIPEDBY&unitCode="
			+ document.forms[0].strUnitCode.value;
	ajaxFunction(url, "6");

}*/

/*function getUnitCombo() {

	var url = "PatientReturnTransCNT.cnt?hmode=UNITCMB&deptCode="
			+ document.forms[0].strDeptCode.value;
	ajaxFunction(url, "5");

}*/

/*function getRequestDetail(obj) {

	if (obj == null)
		return false;

	gblObject = obj.value;

	var url = "PatientReturnTransCNT.cnt?hmode=REQUESTDTLS&reqNo=" + obj.value
			+ "&crNo=" + document.forms[0].crNo.value;

	ajaxFunction(url, "4");

}*/



function getPrevIssueDtl() {

	var strFromStoreId = document.getElementsByName('strStoreId')[0].value;
	var strItemCategory = document.getElementsByName('strItemCat')[0].value;
	if (strFromStoreId != 0 && strItemCategory != 0) {
		var url = "IssueToPatientTransBSCNT.cnt?hmode=PREVISSUEDTL&strId="
				+ document.forms[0].strStoreId.value + "&itemCategory="
				+ document.forms[0].strItemCat.value + "&crNo="
				+ document.forms[0].crNo.value;
		ajaxFunction(url, "2");
	} else {
		alert("Please Select Store and Category");
	}

}



var objGlobal = "";

function validateIssue() {
	validateTariff();

}

/*function validateTariff() {
	var itemTmp = "";
	var itemParVal = document.getElementsByName("itemParamValue");
	if (itemParVal.length > 1) {
		for (var i = 0; i < itemParVal.length - 1; i++) {
			if (i == 0)
				itemTmp = itemParVal[i].value.split("^")[22];
			else
				itemTmp += "," + itemParVal[i].value.split("^")[22];
		}
	}

	var url = "PatientReturnTransCNT.cnt?hmode=TARIFFCHK&itemTmp=" + itemTmp;
	ajaxFunction(url, "11");
}*/

function validateTariff2() {
	retValue = false;

}
function hideIssueDetails(divId) {
	// hide_popup_menu(divId);
	hide_popup(divId);
}

function initGoFunc(eve) {
	var flag = validateData(eve, 5);
	if (flag) {
		if (eve.keyCode == 13) {
			// onGoButton();
			getPatientAccStatus();
		}
	} else {
		return false;
	}

}

function setCaretPositionToEnd(input) 
{
    // Check if input is supported
    if (input.setSelectionRange) 
    {
        // Set caret position to the end
        input.setSelectionRange(input.value.length, input.value.length);
    } else 
    	if (input.createTextRange) 
    {
        // For older browsers
        var range = input.createTextRange();
        range.collapse(false);
        range.select();
    }
}
function radioChecked(obj)
{
//	document.forms[0].strStoreId.disabled = true;
	
	if(obj.value==1)
	{
		 document.getElementsByName("checkFlg")[0].value=obj.value;
		 
		 document.getElementById("typeId1").style.display="block";
		 document.getElementById("typeId2").style.display="none";
		 
		 document.forms[0].strCrNo.focus();		 
		 if (document.forms[0].strCrNo.setSelectionRange) 
		    {
		        // Set caret position to the end
			 document.forms[0].strCrNo.setSelectionRange(document.forms[0].strCrNo.value.length, document.forms[0].strCrNo.value.length);
		    } else 
		    	if (document.forms[0].strCrNo.createTextRange) 
		    {
		        // For older browsers
		        var range = document.forms[0].strCrNo.createTextRange();
		        range.collapse(false);
		        range.select();
		    }
	}
	else
	{
		 document.getElementsByName("checkFlg")[0].value=obj.value;
		 document.getElementById("typeId1").style.display="none";
		 document.getElementById("typeId2").style.display="block";
		
	}
}
function checkMsg() 
{
	//alert("inside");
	
	// document.getElementById("savebutton").style.display="block";

	//alert("err.innerHTML---"+document.getElementById("errID").innerHTML);	
	var err = document.getElementById("errID");
	var nor = document.getElementById("normalMsg");
	var warn = document.getElementById("wrnID");	
	
	if (err.innerHTML != "") {

		err.innerHTML = "<i class='fas fa-exclamation-triangle'></i>"
				+ "&nbsp;&nbsp;&nbsp;"
				+ err.innerHTML
				+ "<button type='button' class='close' data-dismiss='alert'>&times;</button>";
		err.style.display = "";

	}	
	if(document.getElementById("normalMsg").innerHTML !== "") 
	{
       // alert("inside");
        document.getElementById("normalMsg").style.display = "block";
    }
	if (nor.innerHTML !== "") 
	{
		/*alert("inside");
		document.getElementById("normalMsg").style.display ="block";*/
		nor.innerHTML = "<i class='far fa-check-circle'></i>"
				+ "&nbsp;&nbsp;&nbsp;<strong>Success!</strong>&nbsp;&nbsp;"
				+ nor.innerHTML
				+ "<button type='button' class='close' data-dismiss='alert'>&times;</button>";
		nor.style.display = "";
	}
	if (warn.innerHTML != "") 
	{
		warn.innerHTML = "<i class='fas fa-bell'></i>"
				+ "&nbsp;&nbsp;&nbsp;<strong>Warning!</strong>&nbsp;&nbsp;"
				+ warn.innerHTML
				+ "<button type='button' class='close' data-dismiss='alert'>&times;</button>";
		warn.style.display = "";
	}
	document.forms[0].strCrNo.focus();
	 
	 if (document.forms[0].strCrNo.setSelectionRange) 
	    {
	        // Set caret position to the end
		 document.forms[0].strCrNo.setSelectionRange(document.forms[0].strCrNo.value.length, document.forms[0].strCrNo.value.length);
	    } else 
	    	if (document.forms[0].strCrNo.createTextRange) 
	    {
	        // For older browsers
	        var range = document.forms[0].strCrNo.createTextRange();
	        range.collapse(false);
	        range.select();
	    }

}

function goFuncOnEnter(e) {
	if (e.keyCode == 13) {
		// onGoButton();
		getPatientAccStatus();
	} else {
		return false;
	}
}



function onGoButton() 
{
	
	document.getElementById('printableSlip').innerHTML = "";
	document.forms[0].storeName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	document.forms[0].crNo.value = document.forms[0].strCrNo.value;

	document.forms[0].strId.value = document.forms[0].strStoreId.value.split("^")[0];
	

	var hisValidator = new HISValidator("patientReturnBean");
	hisValidator.addValidation("strStoreId", "dontselect=0","Select Store Name Combo ");
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

	document.forms[0].crNo.value = document.forms[0].strCrNo.value;
	
	if (retVal) 
	{

		
			document.forms[0].hmode.value = "INJ_ADMINISTRATION";		
		    document.forms[0].submit();

	} 
	else 
	{
		return false;
	}
}

function onCheckCategory() {

	var patientDtlHidVal = document.forms[0].strPatientDtlHidVal.value;
	var temp = patientDtlHidVal.split('^');

	if (document.forms[0].strMode.value == '0') {

		if (document.forms[0].strConfCatCode.value == temp[3]) {
			document.getElementById("allDivId").style.display = "none";
			alert("Go to Staff Counter....");
			document.forms[0].hmode.value = "INITVAL";
			document.forms[0].submit();
			return false;

		}

	} else if (document.forms[0].strMode.value == '1') {

		if (document.forms[0].strConfCatCode.value != temp[3]) {
			document.getElementById("allDivId").style.display = "none";
			alert("Go to Patient Counter....");
			document.forms[0].hmode.value = "INITVAL";
			document.forms[0].submit();
			return false;

		}
	}
	onCheckInBoth();

}

function onCheckInBoth() {

	if (document.forms[0].strIssueMode.value == '2') {

		// document.getElementsByName('strRadioOnlineReqVal')[0].checked ==
		// false;
		document.getElementById("requestDivId").style.display = "none";
		document.getElementById("itemDtlDivId").style.display = "none";

	} else if (document.forms[0].strIssueMode.value == '0') {

		// document.getElementsByName('strRadioOnlineReqVal')[0].checked = true;
		// getRequestDetail(document.getElementsByName('strRadioOnlineReqVal')[0]);
	}
}

function getPatDtl() {

	document.getElementById("patientDetailsDivId").style.display = "block";
	document.getElementById("minus1").style.display = "block";
	document.getElementById("plus1").style.display = "none";
}
function getPatDtl1() {

	document.getElementById("patientDetailsDivId").style.display = "none";
	document.getElementById("minus1").style.display = "none";
	document.getElementById("plus1").style.display = "block";
}
// added by shefali on 26-aug-2014 for pateint treatment in issue to pateint
function getPatTrtDtl() {

	document.getElementById("patientTreatmentDetailsDivId").style.display = "block";
	document.getElementById("minus3").style.display = "block";
	document.getElementById("plus3").style.display = "none";
}
function getPatTrtDtl1() {

	document.getElementById("patientTreatmentDetailsDivId").style.display = "none";
	document.getElementById("minus3").style.display = "none";
	document.getElementById("plus3").style.display = "block";
}
// added by shalini on 030feb-2016 for pateint diagnosis details in issue to
// pateint
function getPatDiagDtl() {

	document.getElementById("patientDiagDetailsDivId").style.display = "block";
	document.getElementById("minus4").style.display = "block";
	document.getElementById("plus4").style.display = "none";
}
function getPatDiagDtl1() {

	document.getElementById("patientDiagDetailsDivId").style.display = "none";
	document.getElementById("minus4").style.display = "none";
	document.getElementById("plus4").style.display = "block";
}

function disPreviousIssueDtl() {

	document.getElementById("issueDtlDivId").style.display = "block";
	document.getElementById("minus2").style.display = "block";
	document.getElementById("plus2").style.display = "none";

}
function disPreviousIssueDtl1() {

	document.getElementById("issueDtlDivId").style.display = "none";
	document.getElementById("minus2").style.display = "none";
	document.getElementById("plus2").style.display = "block";

}

function getRequestDtl() {

	document.getElementById("requestDivId").style.display = "block";
	document.getElementById("itemDetailDivId").style.display = "block";
	// document.getElementById("itemDtlOffDivId").style.display="none";
	// document.getElementById("reqDtlDivId").style.display="none";

}

function balQtyDtl(obj, i) {

	parentPopUp = obj;

	var strBalQtyDetail = document.getElementById("strBalQtyDtl" + i).value;

	myArray = strBalQtyDetail.split("^");

	var objVal1 = document.getElementById("1");

	if (myArray[0] != 'null' || myArray[0] != '') {
		objVal1.innerHTML = myArray[0];
	} else {
		objVal1.innerHTML = "  ----";
	}

	var objVal2 = document.getElementById("2");

	if (myArray[1] != 'null') {
		objVal2.innerHTML = myArray[1];
	} else {
		objVal2.innerHTML = "  ----";
	}

	//display_popup_menu(parentPopUp, 'balQtyDtlId', '300', '');

}

function hideBalQtyDetails(divId) {
	hide_popup_menu(divId);
}

function getItemStockDtl(i) {

	var storeId = document.forms[0].strId.value;
	var itemCat = document.forms[0].itemCategory.value;
	var strIssueQty = document.getElementsByName('strIssueQty')[i].value;

	var hidVal = document.getElementById('strHidValue' + i).value;
	var temp = hidVal.split('^');
	var balQtyBaseVal = temp[0];
	var genItemId = temp[1];
	var itemBrandId = temp[2];

	var strIssueQtyUnitId = document.getElementsByName('strIssueUnitId')[i].value;

	var strIssueUnitName = document.getElementsByName('strIssueUnitId')[i][document
			.getElementsByName('strIssueUnitId')[i].selectedIndex].text;

	var temp2 = strIssueQtyUnitId.split("^");
	var strIssueQtyUnitBaseVal = parseInt(temp2[1]);

	if (strIssueQty == "") {

		alert("Please Select Issue Qty");
		document.getElementsByName('strIssueQty')[i].focus();
		return false;

	}
	if (document.getElementsByName('strIssueUnitId')[i].value == '0') {

		alert("Please Select Unit Name");
		document.getElementsByName('strIssueUnitId')[i].focus();
		return false;

	}

	getStockDtls('1', '', genItemId, itemBrandId, strIssueQty,
			strIssueQtyUnitBaseVal, storeId, itemCat, '1', strIssueUnitName,
			'strHidDivId' + i);

}

function invokeCheckQty(mode, index, unitObject) {

	if (checkQty(index, 'strReqQty', 'strUnitName')) {

		calculateCost(mode, 'strReqQty', 'strUnitName', 'strCostFinal', index,
				'strApproxAmt', '1')

	}

}

function goFuncOnEnterTwo(e) {

	if (e.keyCode == 13) {
		validateIssue();
	} else {
		return false;
	}
}

var gblhisValidator = null

function chkVisitDtl() {

	if (document.getElementsByName("strPatientStatus")[0].value == '2') {
		document.forms[0].strDeptCode.value = document
				.getElementsByName("strAdmissionDtlHidVal")[0].value.split("^")[5];
	} else
		document.forms[0].strDeptCode.value = document
				.getElementsByName("strEpisodeCode")[0].value.substr(0, 3);
	getReqType();

	if (document.forms[0].strVisitDtl.value == '0') {
		alert("Patient has not visited on this Prescription Date, \n So medicine cannot issued");
		return false;

	} else {

		// getReport();

	}
}

// function to show report after save data

function hideIssuePopup() {
	document.getElementById("issueDtlsDivId").innerHTML = "";
	hide_popup('popUpDiv');

}
function goToCancelPage() {

	var mode = "GETCANCELPAGE";
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();
}

function onQuantity(i) {

	var totQty;
	var frequency = document.getElementById('strFrequency' + i).value;
	var itemparam = document.getElementById('itemParamValue' + i).value;
	var temp = itemparam.split('#');
	var temp1 = temp[1].split('^');
	var dosage = document.getElementById('strDose' + i).value;
	var frequencyVal = frequency.split('^')[1];
	var dosageVal = dosage.split('^')[1];
	var days = document.getElementById('strDays' + i).value;
	if (dosage.split('^')[2] == 1) {
		document.getElementById('strQuantity' + i).innerHTML = "0 No.";
		document.getElementById('strQuantityText' + i).style.display = "none";

		document.getElementById('strQuantityTreatText' + i).style.display = "none";
		document.getElementById('strQuantity' + i).style.display = "block";
		totQty = frequencyVal * dosageVal * days;

		if (isNaN(totQty)) {
			totQty = 0;
		}
		/*
		 * if(parseInt(totQty)>parseInt(temp1[1])){ alert("Quantity is Greater
		 * than Available Quantity"); return false; }
		 */
		document.getElementById('strReqQty' + i).value = totQty;
		document.getElementById('strQuantity' + i).innerHTML = totQty + " No.";
		document.getElementById('strQtyText' + i).value = document
				.getElementById('strReqQty' + i).value;
	} else {
		document.getElementById('strQtyText' + i).value = "";
		document.getElementById('strQuantity' + i).innerHTML = "0 No.";
		document.getElementById('strQuantityText' + i).style.display = "block";
		document.getElementById('strQuantityTreatText' + i).style.display = "block";
		document.getElementById('strQuantity' + i).style.display = "none";
		totQty = dosageVal;
		document.getElementById('strReqQty' + i).value = document
				.getElementById('strQtyText' + i).value;
	}

}

function goToWithoutCrNoPage() {
	document.forms[0].strIssueNum.value = "";
	document.forms[0].crNo.value = "";
	var mode = "INITVALWITHOUTCRNO";
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();
}

function IsCrOrLFWise(val) {
	if (val == '1') {
		document.getElementById("CrNOOrLf").innerHTML = "<font color=\"red\">*</font>PIN.";
		document.getElementById("CRWise").style.display = 'block';
		document.getElementById("LFWise").style.display = 'none';

	}
	if (val == '2') {
		document.getElementById("CrNOOrLf").innerHTML = "<font color=\"red\">*</font>LF No.";
		// alert(document.getElementById("CRWise").innerHTML);
		document.getElementById("CRWise").style.display = 'none';
		document.getElementById("LFWise").style.display = 'block';

	}

}
function getPrintReport() {
	// alert("Req
	// type:::"+document.getElementsByName("strRequestTypeId")[0].value);
	if (printflag == true)
		getReport();

}
// function to show report after save data
/*function getReport() {
	var transferNo = document.forms[0].strIssueNum.value;
	var storeId = document.forms[0].strStoreId.value;

	// alert("transferNo"+transferNo);
	// alert("storeId"+storeId);
	if (parseInt(transferNo) != 0 && document.forms[0].printReq.value == 1) {
		var mode = "ISSUEDTLSINITONE";
		var url = "PatientReturnTransCNT.cnt?hmode=" + mode + "&strIssueNo="
				+ transferNo + "&strStoreId=" + storeId + "&strMode=1";
		ajaxFunction(url, "9");
	}
}*/

/*function getReport2() {
	var transferNo = document.forms[0].strIssueNum.value;
	var storeId = document.forms[0].strId.value;
	// alert(transferNo);
	if (parseInt(transferNo) != 0) {
		var mode = "ISSUEDTLPOPUP";
		var url = "PatientReturnTransCNT.cnt?hmode=" + mode + "&issueNo="
				+ transferNo + "&storeId=" + storeId;
		ajaxFunction(url, "8");
	}

}
*/
/*
 * function getAjaxResponse(res,mode) { var err =
 * document.getElementById("errMsg"); var temp = res.split("####"); if(temp[0] ==
 * "ERROR") { err.innerHTML = temp[1]; return; }
 * 
 * if(mode=="1") {
 * 
 * var objVal2 = document.getElementById("issueDtlsDivId"); objVal2.innerHTML =
 * res; popup('popUpDiv1', '130', '200'); document.forms[0].strIssueNum.value
 * ="0";
 *  } }
 */



function getReqType() {
	// alert('11');
	var url = "PatientReturnTransCNT.cnt?hmode=GETREQTYPE&storeId="
			+ document.forms[0].strStoreId.value + "&itemCatId="
			+ document.forms[0].strItemCat.value + "&patStatus="
			+ document.forms[0].strPatStatus.value;
	// alert(url);
	ajaxFunction(url, "12");
}

function getPresData() {
	var url = "PatientReturnTransCNT.cnt?hmode=GETPRESCDATA&storeId="
			+ document.forms[0].strStoreId.value + "&strCrNum="
			+ document.forms[0].strCrNo.value + "&deptID="
			+ document.forms[0].strDeptCode.value + "&strDeptUnit="
			+ document.forms[0].strUnitCode.value + "&episodeDtl="
			+ document.forms[0].strOffLineEpisode.value;
	// alert(url);
	ajaxFunction(url, "18");
}

/*
 * $(document).ready(function(){ //alert('1'); var today=new Date(); var
 * dt=today.getDate(); var mth=today.getMonth(); mth=mth+1; if(dt<10)
 * dt="0"+dt; if(mth<10) mth="0"+mth;
 * 
 * $('#datepicker1').datepicker({ modal: true,footer: true,format:
 * 'dd-mm-yyyy'}); //$('#datepicker').datepicker({ uiLibrary:
 * 'bootstrap4',modal: true,footer: true,format: 'dd-mm-yyyy'});
 * //$('#datepicker').val(dt+"-"+mth+"-"+today.getFullYear()); });
 */

$(document).ready(function() {
	$('.datepicker1').each(function() {
		$(this).datepicker({
			modal : true,
			header : true,
			footer : true,
			format : 'dd-mmm-yyyy'
		});
	});
	/*
	 * var today=new Date(); var
	 * arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
	 * var mmm=arr[today.getMonth()]; var hrs=today.getHours(); var
	 * dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
	 * $('.datepicker1').val(dd);
	 */

});

function DirectIssue() {
	var itemTmp = "";
	var itemParVal = document.getElementsByName("itemParamValue");
	if (itemParVal.length > 1) {
		for (var i = 0; i < itemParVal.length - 1; i++) {
			if (i == 0)
				itemTmp = itemParVal[i].value.split("^")[22];
			else
				itemTmp += "," + itemParVal[i].value.split("^")[22];
		}
	}

	document.getElementById("dep").disabled = false;
	document.getElementById("unit").disabled = false;

	var url = "PatientReturnTransCNT.cnt?hmode=TARIFFCHK&itemTmp=" + itemTmp;
	ajaxFunction(url, "15");

}

function checkEpidoseData() {

	var itemTmp = "";
	var itemParVal = document.getElementsByName("itemParamValue");
	var strQtyTextval = document.getElementsByName("strQtyText");
	var reqQty = document.getElementsByName("strQtyText");
	if (itemParVal.length > 1) {
		for (var i = 0; i < itemParVal.length - 1; i++) {

			if (parseInt(reqQty[i].value) > 0) {

				itemTmp += itemParVal[i].value.split("^")[22] + ",";

			}
		}
	}

	var itemTmp1 = itemTmp.substring(0, itemTmp.length - 1);

	var url = "PatientReturnTransCNT.cnt?hmode=ALREADYISSUEDRUG&itemTmp="
			+ itemTmp1 + "&strCrNum=" + document.forms[0].crNo.value
			+ "&episodeDtl=0";
	ajaxFunction(url, "119");

}

function Backbtn() {
	// var url = "PatientReturnTransCNT.cnt?hmode=TARIFFCHK&itemTmp="+ itemTmp;

	document.forms[0].hmode.value = "unspecified";
	document.forms[0].submit();

}

function getEpisodeList(obj) {

	var hmode = "EPISODEDTLS";
	var url = "PatientReturnTransCNT.cnt?hmode=" + hmode + "&crNo="
			+ document.forms[0].crNo.value + "&deptCode=" + obj.value
			+ "&unit=" + document.forms[0].strUnitCode.value;
	ajaxFunction(url, "16");

}
/*function getReport() {
	document.getElementById("strCrNo").focus();

	var issueNo = document.forms[0].strIssueNum.value;
	var strId = document.forms[0].storeHidId.value;
	 alert("Issue No:::"+issueNo+"::Store ID::"+strId);
	if (issueNo != "") {
		if (issueNo != "0") {
			var strMode = "1";
			var hmode = "ISSUEDTLSINIT";
			var url = "PatientReturnTransCNT.cnt?hmode=" + hmode + "&strMode="
					+ strMode + "&strStoreId=" + strId + "&strIssueNo="
					+ issueNo;
			ajaxFunction(url, "8");
		}
	}
	document.forms[0].strIssueNum.value = "0";
	document.forms[0].strCrNo.focus();
}*/

function getPresForm() {
	var hmode = "PRESFORMDTLS";
	var url = "PatientReturnTransCNT.cnt?hmode=" + hmode + "&crNo="
			+ document.forms[0].crNo.value + "&episodeCode="
			+ document.forms[0].strOffLineEpisode.value;
	ajaxFunction(url, "17");

}

$().ready(function() {
	$("#strPayMode").on("change", function() {

		document.forms[0].strPayDtl.value = "";

		var paymode = $(this).val().split("#")[0];

		if (paymode == "2" || paymode == "3") {
			$("#payDtlCDDModal").modal("show");
		}

		if (paymode == "4" || paymode == "5") {
			$("#payModeModal").modal("show");
		}
		if (paymode == "7") {
			$("#payDtlWalletMenu").modal("show");
		}

	});
});

function validateCreditDebit() {

	var hisValidator = new HISValidator("patientReturnBean");

	hisValidator.addValidation("strPayBankName", "req",
			"Bank Name is a Mandatory Field");
	hisValidator.addValidation("strCardNo", "req",
			"Card No. is a Mandatory Field");
	hisValidator.addValidation("strCardNo", "minlen=4",
			"Card No. must be 4 Digits");
	hisValidator.addValidation("strAuthNo", "req",
			"Transaction  No. is a Mandatory Field");
	hisValidator.addValidation("strAuthDate", "req",
			"Transaction  Date is a Mandatory Field");
	hisValidator.addValidation("strAuthDate", "date",
			"Please Enter a Valid Transaction  Date");
	hisValidator.addValidation("strCardType", "dontselect=0",
			"Please Select a Card Type");

	var retVal = hisValidator.validate();

	var orgDate = replaceAll(document.forms[0].strAuthDate.value, '-', ' ');
	orgDate = new Date(orgDate);
	var currdate = new Date();

	if (orgDate > currdate) {
		alert("Transaction Date Can't be greater than current date");
		return false;
	}

	var validityOrgDate = new Date(orgDate.getTime());
	var validityBwdFrmNow = new Date(currdate.getTime()
			- (1 * 24 * 60 * 60 * 1000));
	if (validityOrgDate <= validityBwdFrmNow) {
		alert("Transaction Date Can't be less than current date");
		return false;
	}

	hisValidator.clearAllValidations();
	if (retVal) {

		var resultVal = document.forms[0].strPayBankName.value
				+ ","
				+ document.forms[0].strCardNo.value
				+ ","
				+ document.forms[0].strAuthNo.value
				+ ","
				+ document.forms[0].strAuthDate.value
				+ ","
				+ document.forms[0].strCardType[document.forms[0].strCardType.selectedIndex].text;

		document.forms[0].strPayDtl.value = resultVal;

		$("#payModeModal").modal("hide");

		/*
		 * gblPayDtls.value = resultVal; gblPayEdit.disabled = false;
		 * 
		 * hide_popup('payDtlCDMenu');
		 * 
		 * //alert(gblAmount.value) gblAmount.focus();
		 */
	} else {

		return false;
	}

}

function validateCheckDD() {

	var hisValidator = new HISValidator("patientReturnBean");

	hisValidator.addValidation("strPayCDDBankName", "req",
			"Bank Name is a Mandatory Field");
	hisValidator.addValidation("strChequeDDNo", "req",
			"Cheque / DD No. is a Mandatory Field");
	hisValidator.addValidation("strChequeDDDate", "req",
			"Cheque / DD Date is a Mandatory Field");
	hisValidator.addValidation("strChequeDDDate", "date",
			"Please enter a valid Cheque / DD Date");
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

	var orgDate = replaceAll(document.forms[0].strChequeDDDate.value, '-', ' ');
	orgDate = new Date(orgDate);
	var currdate = new Date();

	var validityOrgDate = new Date(orgDate.getTime());
	var validityFwdFrmNow = new Date(currdate.getTime()
			+ (90 * 24 * 60 * 60 * 1000));
	var validityBwdFrmNow = new Date(currdate.getTime()
			- (90 * 24 * 60 * 60 * 1000));

	if (validityOrgDate > validityFwdFrmNow) {
		alert("Issue Date can not be greater than 3 months");
		return false;
	}

	if (validityBwdFrmNow > validityOrgDate) {
		alert("Issue Date can not be less than 3 months");
		return false;
	}

	/*
	 * if(orgDate>currdate){ alert("Issue Date Can't be greater than current
	 * date"); return false; }
	 */

	if (retVal) {

		var resultVal = document.forms[0].strPayCDDBankName.value + ","
				+ document.forms[0].strChequeDDNo.value + ","
				+ document.forms[0].strChequeDDDate.value;

		document.forms[0].strPayDtl.value = resultVal;
		/*
		 * gblPayDtls.value = resultVal; gblPayEdit.disabled = false;
		 */

		$("#payDtlCDDModal").modal("hide");

	} else {

		return false;
	}

}
function modalSlipPrint() {
	var printableSlip = document.getElementById("printableSlip")

	if (printableSlip.innerHTML != "") {
		printableSlip.style.display = "";
		printElement(printableSlip);
	}

}
function printElement1(elem) {
	var domClone = elem.cloneNode(true);

	var $printSection = document.getElementById("printSection");

	if (!$printSection) {
		var $printSection = document.createElement("div");
		$printSection.id = "printSection";
		document.body.appendChild($printSection);
	}

	$printSection.innerHTML = "";
	$printSection.appendChild(domClone);
	$("#printModal").modal("show");

	window.print();

}


function printElement(elem)  
{
    const contentToPrint = document.getElementById("printableSlip").cloneNode(true);
    const newWin = window.open('', '', 'width=700,height=700,scrollbars=yes');
    newWin.document.write('<html><head>');
    newWin.document.write('<style type="text/css">');
    newWin.document.write('.hidecontrol { display: none; }');
    newWin.document.write('@media print {');
    newWin.document.write('  #toolbar { display: none; }');
    newWin.document.write('  body { margin: 0; padding: 0; }');
    newWin.document.write('  @page { margin: 2mm 1mm; size: A4 portrait; }');
    newWin.document.write('  table { table-layout: fixed; width: 100%; }');
    newWin.document.write('  table td { word-wrap: break-word; font-size: 12px; }');

    // Define page break rules for the repeat-table class
//     newWin.document.write('.repeat-table { page-break-before: always; }');

    newWin.document.write('}');
    newWin.document.write('</style>');
    
    newWin.document.write('</head><body>');
    newWin.document.write(contentToPrint.outerHTML);
    newWin.document.write('</body></html>');
    newWin.document.close();
    newWin.onload = function () {
        newWin.print();
        newWin.close();
    };
}
/*
 * window.onafterprint = function(){
 * 
 * $("#printModal").modal('hide');
 * 
 *  }
 */
function nxtChunk(val) {
	let id = "", curid = "";
	$("#chunks .row").each(function() {

		// console.log($(this).css("display"));

		if ($(this).css("display") != "none") {
			curid = $(this).prop("id").split("-")[0];
			if (val == "nxt")
				id = Math.abs(curid) + 1;
			else
				id = Math.abs(curid) - 1;
			// console.log(id);
		}

	});
	if ($("#" + id + "-chunk").prop("id") != undefined) {
		$("#" + curid + "-chunk").css("display", "none");
		$("#" + id + "-chunk").css("display", "");
	}
}

function confirmTrue(obj, val) {

	if (val == "1") {
		document.forms[0].hmode.value = "INSERTDIRECTISSUE";
		document.forms[0].submit();
	}

}

function callIssuePop(these) {
	$(these).closest("div").find("a").trigger("click");
}




function getBrandDtls(obj,index)
{	
	var batchCount=document.getElementById("batchCount"+index).value
	if(batchCount!=1)
	{
		var batchDtl= (document.getElementById("strMultiRowBatch"+index).value).split("^");
		if(batchDtl[0]=="0")
		{
			document.getElementById("strMultiRowBatchTable"+index).style.display = "none";
			document.getElementById("selectedBatchDetails"+index).value= "";
			document.getElementById("batchExpDtlId"+index).innerHTML="";
		}
		else
		{
			document.getElementById("selectedBatchDetails"+index).value = obj.value;
			
			
			var issueQty = document.getElementById("strIssueQty"+index).value;
			var selectedBatchDetails  = document.getElementById("selectedBatchDetails"+index).value;	
			var batchNo      = selectedBatchDetails.split("^")[1];
			var batchAvlQty  = selectedBatchDetails.split("^")[2];
			var batchExp     = selectedBatchDetails.split("^")[4];
			// BrandId ^ Batch No ^ In Hand Qty ^ Sale Price ^ Exp Date
			
			var batchText = batchNo +"<br>["+batchExp+"]"; 
	        document.getElementById("strMultiRowBatchTable"+index).style.display = "block";		
			document.getElementById("strMultiRowBatchAvlQtyVal"+index).innerHTML=batchAvlQty;
			document.getElementById("batchExpDtlId"+index).innerHTML=batchText;
			
			
			if(parseInt(batchAvlQty)< parseInt(issueQty))
			{			
				document.getElementById("strIssueQty"+index).value = batchAvlQty;
				document.getElementById("strIssueQty"+index).focus();		
			}
			
			
		}
	}
	
}

function handlePendingBtn(index)
{

	var issueQty = document.getElementById("strIssueQty"+index).value;
	var patientNameAge = document.getElementById("patientNameAge"+index).value;
	var crNo  = document.getElementById("itemParamValue"+index).value.split("^")[2];
	var itemParamValue  = document.getElementById("itemParamValue"+index).value;
	var selectedBatchDetails  = document.getElementById("selectedBatchDetails"+index).value;	
	var batchNo      = selectedBatchDetails.split("^")[1];
	var batchAvlQty  = selectedBatchDetails.split("^")[2];
	var admType = document.getElementById("administerType"+index).value;
	// BrandId ^ Batch No ^ In Hand Qty ^ Sale Price ^ Exp Date
	var checkFlg     = document.forms[0].checkFlg.value;
	var strSearchStr = document.forms[0].strSearchStr.value;
	var administerMode = document.getElementById("administerMode"+index).value;
	var administerType = document.getElementById("administerType"+index).value;
	var strDoses       = document.getElementById("strDoses"+index).innerText;
	
	if(strDoses.trim().length==0){
		var admnModeText =  document.getElementById("administerMode"+index).options[document.getElementById("administerMode"+index).selectedIndex].text;
		var admnTypeText = "";
		if(administerType=="10"){
			admnTypeText = "Whole";
		}
		else if(administerType=="11"){
			admnTypeText = "Partial";
		}
		strDoses = admnModeText + "^" + admnTypeText;	
	}
	console.log("issue qty -" + issueQty );
	if(selectedBatchDetails=="")
	{
		alert("Please select a Batch.Before Administered");
	}
//	else if(issueQty<=0)
//	{
//		alert("Administrated quantity must be greater than 0");
//	}
	else if(parseInt(batchAvlQty)< parseInt(issueQty))
	{
		alert("Administrated quantity must be greater than 0");
		document.getElementById("strIssueQty"+index).value = batchAvlQty;
		document.getElementById("strIssueQty"+index).focus();
		return false;
	}
	else
	{
		var injName = document.getElementById("injName"+index).innerText;
		var dosage =  document.getElementById("strDoses"+index).innerText;
		var patientName =  document.getElementById("patName"+index).innerText.split("(")[0];
		var conf1 = confirm("Do you want to administer "+injName+" - "+dosage+" to "+patientName+"? ");
          if(conf1 == true)
          {	 
        	  //var conf2 = confirm("Are you sure?");
              //if(conf2 == true)
              //{             	 
            	  var url = "PatientReturnTransCNT.cnt?hmode=saveInjAdministratedDtl_Ajax"
            			+"&strId="+document.getElementById('strId').value  
            			+"&admType="+ admType
            			+"&issueQty="+"1"     //issueQty
            			+"&selectedBatchDetails="+ selectedBatchDetails
            			+"&itemParamValue="+ itemParamValue+"&checkFlg="+checkFlg+"&strSearchStr="+strSearchStr
            			+"&administerMode="+ administerMode+"&administerType="+ administerType
            			+"&strDoses="+ strDoses;            	  
            		
            		ajaxFunction(url,"21");
              //}
          }
	}
	
}


function closeModalForPending(){
	console.log("btn working");
	var modal = document.getElementById("modalForPending");

	modal.style.display = "none";
}

/*function printData() 
{
	    const contentToPrint = document.getElementById("administratedDtlDiv");
	    const newWin = window.open('', '', 'width=700,height=700,scrollbars=yes');
	    newWin.document.write('<html><head>');
	    newWin.document.write('<style type="text/css">');
//	    newWin.document.write('.hidecontrol { display: none; }');
	    newWin.document.write('@media print {');
//	    newWin.document.write('  #toolbar { display: none; }');
	    newWin.document.write('  body { margin: 0; padding: 0; }');
	    newWin.document.write('  @page { margin: 4mm 3mm; size: A4 portrait; }');
	    newWin.document.write('  table { table-layout: fixed; width: 100%; }');
	    newWin.document.write('  table td { word-wrap: break-word; font-size: 12px; }');

	    // Define page break rules for the repeat-table class
//	     newWin.document.write('.repeat-table { page-break-before: always; }');

	    newWin.document.write('}');
	    newWin.document.write('</style>');
	    
//	    console.log(contentToPrint);
	    
	    newWin.document.write('</head><body>');
	    newWin.document.write(contentToPrint.outerHTML);
	    newWin.document.write('</body></html>');
	    newWin.document.close();
	    newWin.onload = function () {
	        newWin.print();

	    }
}*/

function printData12(mode){
	document.getElementById("printImg").style.display="none"; 
	let contentToPrint 
	let title="Administrated_Detail";
	if(mode==1){
		contentToPrint = document.getElementById("administratedDtlDiv").cloneNode(true);
	}
	else if(mode==2){
		contentToPrint = document.getElementById("prevIssueDiv").cloneNode(true);
		title="PrevInj_Issue_Details";
	}
	
    const newWin = window.open('', '', 'width=700,height=700,scrollbars=yes');
    newWin.document.write('<html><head>');
    newWin.document.write('<title>'+title+'</title>');
    newWin.document.write('<style type="text/css">');
//    newWin.document.write('.hidecontrol { display: none; }');
    newWin.document.write('@media print {');
//    newWin.document.write('  #toolbar { display: none; }');
//    newWin.document.write('  body { margin: 0; padding: 0; }');
//    newWin.document.write('  @page { margin: 4mm 3mm; size: A4 portrait; }');
    newWin.document.write('  table {border-collapse: collapse; }');
    newWin.document.write('}');
    newWin.document.write('</style>');
    
    newWin.document.write('</head><body>');
    newWin.document.write(contentToPrint.outerHTML);
    newWin.document.write('</body></html>');
    newWin.document.close();
    newWin.onload = function () {
        newWin.print();
        newWin.close();
    };
    document.getElementById("printImg").style.display="block"; 
}

function changeAdmType(obj,index)
{
	document.getElementById("administerType"+index).value=obj.value;
	if(obj.value == '11')
	{		
		document.getElementById("strIssueQty"+index).value = "0";
		document.getElementById("strDoses"+index).style.display="block";
	}	
	else
	{
		document.getElementById("strIssueQty"+index).value = "1";
		document.getElementById("strDoses"+index).style.display="none";
	}
	
	console.log(document.getElementById("strIssueQty"+index).value);
}

function refreshPage(){
	
	var checkFlg = document.getElementById("checkFlg").value;
	var storeId = document.getElementById("strId").value;
	var strSearchStr = document.forms[0].strSearchStr.value;
	console.log(checkFlg+"  + " +storeId+"  + " +strSearchStr);
	var url = "PatientReturnTransCNT.cnt?hmode=reloadAdministrationDtl_Ajax&checkFlg="+checkFlg+"&strSearchStr="+strSearchStr+"&storeId="+storeId;           	  
	
	ajaxFunction(url,"23");
	
}
