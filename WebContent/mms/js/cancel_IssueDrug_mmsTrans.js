function chkBoxClick(obj,index)
{
 if(obj.checked)
 {
  document.getElementsByName("strIssueChkIndex")[index].value='1';
 }
 else
 {
  document.getElementsByName("strIssueChkIndex")[index].value='0';
 }
}

function CheckedAll(chkObj)
{
	var size   = document.getElementsByName("strItemBrandId").length;
	var retQty = document.getElementsByName("strReturnQty");
    if(chkObj.checked)
 	{
     	for(var i=0;i<size;i++)
		{			
			if(retQty[i].value==0)
			{
			    document.getElementsByName("strIssueChkIndex")[i].checked=true;
			    document.getElementsByName("strIssueChkIndex")[i].value='1';
			}
			else
			{
				document.getElementsByName("strIssueChkIndex")[i].value='0';
			}
			
		}
	 	
 	}
 	else
 	{
 		for(var i=0;i<size;i++)
		{
			document.getElementsByName("strIssueChkIndex")[i].checked=false;
			document.getElementsByName("strIssueChkIndex")[i].value='0';
			
		}
	 	
 	}
	
}
function goToCancelPage()
{
	
	var mode = "GETCANCELPAGE";
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();
}
function ftnTick(mode)
{
  if(mode=='1')
  {
  	document.forms[0].strOutOfStockFlag.value='1';
  	document.forms[0].OutOfStockFlag[0].checked=true;
  	document.forms[0].OutOfStockFlag[1].checked=false;
  }
  else
  {
  	document.forms[0].strOutOfStockFlag.value='0';
  	document.forms[0].OutOfStockFlag[1].checked=true;
  	document.forms[0].OutOfStockFlag[0].checked=false;
  }
	
} 
function getMultiRow(obj)
{
	 document.getElementById("hearderId").style.display = "block";
     	var noOfRow = document.forms[0].strNoOfMultiRow.value;
     	for(var i=0; i<noOfRow;i++)
     	{     		
     		addRows(new Array('strNotInListDrugName','strNotInListDrugQty'),new Array('t','t'),'2','1','R')
     	}
 	
}
function QtyValidation(index)
{
		if(document.getElementById("strQtyText"+index).value!="")
		{
			    var issueQty     = document.getElementById("strQtyText"+index).value;
			    var   avlQty     = document.getElementById("itemUserValue"+index).value.split("^")[7];
			    //var prescQty     = document.getElementById("strPrescQty"+index).value;
				if(parseInt(avlQty)<parseInt(issueQty,10))
				{
					alert("Issue Quantity cannot be greater than Available Quantity");					
					document.getElementById("strQtyText"+index).value="";
					return false;
				}	
				/*if(parseInt(prescQty,10)<parseInt(issueQty,10) || prescQty.length=='0' )
				{
					alert("Issue Quantity cannot be greater than Prescribe Quantity");					
					document.getElementById("strQtyText"+index).value="";
					return false;
				}	*/					
			
		}
}
function checkPresQty(index)
{
	var prescQty     = document.getElementById("strPrescQty"+index).value;
	if(parseInt(prescQty,10)=='0' ||parseInt(prescQty,10)==0 )
	{
	    alert("Prescribe Quantity cannot be equal to Zero");
	     document.getElementById("strPrescQty"+index).value="";				
		return false;
	}
}

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
function hideIssuePopupOne() 
{
	document.getElementById("issueDtlsDivId").innerHTML = "";
	hide_popup('popUpDiv');
	document.getElementById("strCrNo").focus();

}
function transferToViewPage()
{
	if (document.getElementsByName("strViewChk")[0].checked) 
	{
		document.forms[0].hmode.value = "VIEWPAGE";
		document.forms[0].submit();
	}
}

function cancelIssue() 
{
	showMenuFrame();
	document.forms[0].hmode.value = "CANCELPAGE";
	document.forms[0].submit();
}

function clearIssue() {
	document.forms[0].strIssueNum.value = "";
	document.forms[0].strId.value = "";
	var url;
	var mode = "GETCANCELPAGE";
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();
}

var gblObject = "";

function getItemDetails() {

	var url = "IssueTransCNT.cnt?hmode=ITEMDETAILS&reqNo=" + gblObject
			+ "&crNo=" + document.forms[0].crNo.value + "&strId="
			+ document.forms[0].strId.value;

	ajaxFunction(url, "7");

}

function getConsultantCombo() {

	var url = "IssueTransCNT.cnt?hmode=PRESCRIPEDBY&unitCode="
			+ document.forms[0].strUnitCode.value;
	ajaxFunction(url, "6");

}

function getUnitCombo() {

	var url = "IssueTransCNT.cnt?hmode=UNITCMB&deptCode="
			+ document.forms[0].strDeptCode.value;
	ajaxFunction(url, "5");

}

function getRequestDetail(obj) {

	if (obj == null)
		return false;

	gblObject = obj.value;

	var url = "IssueTransCNT.cnt?hmode=REQUESTDTLS&reqNo=" + obj.value
			+ "&crNo=" + document.forms[0].crNo.value;

	ajaxFunction(url, "4");

}

function getPrevIssueDtl() {

	var url = "IssueTransCNT.cnt?hmode=PREVISSUEDTL&strId="
			+ document.forms[0].strId.value + "&itemCategory="
			+ document.forms[0].itemCategory.value + "&crNo="
			+ document.forms[0].crNo.value;
	ajaxFunction(url, "2");

}

function getItemCat() {

	var strStoreId = null;
	if (document.forms[0].strStoreId != null) {
		strStoreId = document.forms[0].strStoreId.value;
	}
	if (strStoreId != null && strStoreId != "0") {
		var url = "IssueTransCNT.cnt?hmode=ITEMCATCMB&storeId="
				+ document.forms[0].strStoreId.value + "&modeVal="
				+ document.forms[0].strMode.value;
		ajaxFunction(url, "1");
	} else {
		document.getElementById("itemcatDivId").innerHTML = "<select name ='strItemCat' class='comboNormal' ><option value='0'>Select Value</option></select>";
	}
}

var objGlobal = "";

function getIssuePopUp(these, index) 
{

	objGlobal = these;
	var url = "IssueTransCNT.cnt?hmode=ISSUEDTLPOPUP&strId="
			+ document.getElementById("strIssueSoreID"+index).value + "&issueNo="
			+ document.getElementById("strIssueNo" + index).value;
	ajaxFunction(url, "3");

}

function getAjaxResponse(res, mode) {

	if (mode == "1") {
		if (res == "") {
			document.getElementById("itemcatDivId").innerHTML = "<select name ='strItemCat' class='comboNormal' ><option value='0'>Select Value</option></select>";
		} else {
			var objVal = document.getElementById("itemcatDivId");
			objVal.innerHTML = "<select name ='strItemCat' class='comboNormal' >"
					+ res + "</select>";
		}
	}

	if (mode == "2") {

		var objVal = document.getElementById("issueDtlDivId");

		objVal.innerHTML = res;

	}

	if (mode == "3") {
		var objVal = document.getElementById("issueDtlId");
		objVal.innerHTML = res;
		display_popup_menu(objGlobal, "issueDtlId", '', '');
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

	var hisValidator = new HISValidator("issueBean");
	hisValidator.addValidation("strStoreId", "dontselect=0","Select Drug Warehouse Name from Drug Warehouse Combo ");
	hisValidator.addValidation("strItemCat", "dontselect=0","Select Item Category from Item Category Combo");
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	document.forms[0].storeName.value    = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	document.forms[0].itemCatName.value  = document.forms[0].strItemCat[document.forms[0].strItemCat.selectedIndex].text;
	
	document.forms[0].strId.value        = document.forms[0].strStoreId.value;
	document.forms[0].itemCategory.value = document.forms[0].strItemCat.value;

	if (retVal) 
	{
		document.forms[0].strIssueNo.value   = document.forms[0].strIssueNo.value+"^"+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+"^"+document.forms[0].strItemCat[document.forms[0].strItemCat.selectedIndex].value;
		document.forms[0].hmode.value = "INITCANCELGO";
		document.forms[0].submit();

	} 
	else 
	{
		return false;
	}
}
function onCheckInBoth() {

	if (document.forms[0].strIssueMode.value == '2') {

		document.getElementsByName('strRadioOnlineReqVal')[0].checked == false;
		document.getElementById("requestDivId").style.display = "none";
		document.getElementById("itemDtlDivId").style.display = "none";

	} else if (document.forms[0].strIssueMode.value == '0') {

		document.getElementsByName('strRadioOnlineReqVal')[0].checked = true;
		getRequestDetail(document.getElementsByName('strRadioOnlineReqVal')[0]);
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

	display_popup_menu(parentPopUp, 'balQtyDtlId', '300', '');

}

function hideBalQtyDetails(divId) {
	hide_popup_menu(divId);
}

function getItemSelectPopup() 
{
	var strRequestType = "32";
	var strModeVal = "3";
	var strItemCategory =document.getElementsByName('itemCategory')[0].value;
	

	var strFromStoreId = document.getElementsByName('strId')[0].value;

    if(document.forms[0].strDoseFrqFlg.value=='1')
	{
		    // Commented by Amit for GGSH
			var      strMultiRowCompArray = new Array('itemParamValue', 'itemCalcValue','itemUserValue', 'strDose', 'strFrequency', 'strDays', 'strReqQty');
			var  strMultiRowCompTypeArray = new Array('t', 't', 't', 's', 's', 't', 't');
	}
	else
	{
			var      strMultiRowCompArray = new Array('itemParamValue', 'itemCalcValue','itemUserValue', 'strReqQty');
			var  strMultiRowCompTypeArray = new Array('t', 't', 't', 't');
	}
	var strMultiRowFetchDataArray = new Array('1', '11', '4');

	var layerIndex = "1";
	searchItems(strModeVal, strItemCategory, strRequestType, strFromStoreId,
			strMultiRowCompArray, strMultiRowCompTypeArray,
			strMultiRowFetchDataArray, layerIndex);
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

var gblhisValidator = null

function validateIssue() 
{

	        var retVal = true;
			var hisValidator = new HISValidator("issueBean");
			hisValidator.addValidation("strRemarks","req","Remarks is Mandatory" );			
			hisValidator.addValidation("strRemarks", "maxlen=100","Remarks should have less than or equal to 100 Characters");
			retVal = hisValidator.validate();
			hisValidator.clearAllValidations();
			var count = parseInt("0");
			if (retVal) 
			{
				    var size   = document.getElementsByName("strItemBrandId").length;
				    var obj    = document.getElementsByName("strIssueChkIndex");		    
			     	for(var i=0;i<size;i++)
					{			
						  document.getElementsByName("strIssueChkIndex")[i].disabled=false;
						  if(obj[i].checked)
					      {
					         
				           	  obj[i].checked = true;
				           	  obj[i].value = '1';
				           	  count = count +1;
				           
					      }
					      else
					      {
					          obj[i].value = '0';
					         obj[i].checked = true;
					       	
				  	      }
						
					}
				    if(count>0)
	                {
				
	                      var conf = confirm("You Are Going To Save Records");
		                  if(conf == true)
		                  {
		                       var conf1 = confirm("Are you sure !!!");
		                       if(conf1 == true)
		                       {
		 						    document.forms[0].hmode.value = "INSERTCANCEL";
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
	                	alert("Please Select One Drug to Cancel!!");
	                	var retQty = document.getElementsByName("strReturnQty");
	                	    for(var i=0;i<size;i++)
							{			
								      obj[i].value = '0';
								      if(retQty[i].value=='1')
								      {
								      	document.getElementsByName("strIssueChkIndex")[i].disabled=true;
								      }
							           obj[i].checked = false;
								     
							}
	                	return false;
	                }    
				
	
			}
			else 
			{
				return false;
			}

	

}

function chkVisitDtl() {
	if (document.forms[0].strVisitDtl.value == '0') {
		alert("Patient has not visited on this Prescription Date, \n So medicine cannot issued");
		return false;

	} else {

//		getReport();

	}
}

// function to show report after save data

function hideIssuePopup() {
	document.getElementById("issueDtlsDivId").innerHTML = "";
	hide_popup('popUpDiv');

}

function getReport() 
{   	
    var issueNo      = document.forms[0].strIssueNum.value;
	var strId        = document.forms[0].strId.value;
 	if (issueNo != "") 
	{	  
		if (issueNo != "0") 
		{		   
		    var strMode = "1";
			var hmode = "ISSUEDTLSINIT";
		    var url = "IssueTransCNT.cnt?hmode=" +hmode+ "&strMode=" +strMode+ "&strStoreId=" +strId+ "&strIssueNo=" + issueNo;
		    ajaxFunction(url, "8");
		}
	}
	document.forms[0].strIssueNum.value = "0";	
	document.forms[0].strIssueNo.focus();
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
		document.getElementById('strQuantity' + i).style.display = "none";
		totQty = dosageVal;
		document.getElementById('strReqQty' + i).value = document.getElementById('strQtyText' + i).value;
	}

}

function goToWithoutCrNoPage()
{    
    document.forms[0].strIssueNum.value = "";
	document.forms[0].crNo.value = "";	
	var mode = "INITVALWITHOUTCRNO";
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();
}




