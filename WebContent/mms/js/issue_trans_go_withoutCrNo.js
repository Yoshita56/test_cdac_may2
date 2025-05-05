function openViewPage(mode)
{
	if(mode==1)
	{
		document.getElementById("fromDate").style.display="none";
		document.forms[0].strFlagVal.value="1";
		document.getElementById("breakageItemDtlId").innerHTML = "";
		document.getElementById("breakageItemDtlId").style.display = "none";
	}
	else
	{
		document.getElementById("fromDate").style.display="block";
		document.forms[0].strFlagVal.value="2";
		document.getElementById("breakageItemDtlId").innerHTML = "";
		document.getElementById("breakageItemDtlId").style.display = "none";
		
	}
	
}
function radioButton()
{ 
	document.getElementsByName("strByCurrentAndDate")[0].checked=true;
	document.forms[0].strFlagVal.value="1";
	//alert(document.forms[0].crNo.value);
	if(document.forms[0].strHiddenIssueNo.value != null && document.forms[0].strHiddenIssueNo.value != "")
	{
		var hmode = "ISSUEDTLSINIT";
		var url = "MmsCNT.cnt?hmode=" + hmode + "&strMode=" + 1
				+ "&strStoreId=" + document.forms[0].storeId.value + "&strIssueNo=" + document.forms[0].strHiddenIssueNo.value+"&strIndentNo="+0+"&strIndentDate="+0+"&crNo="+document.forms[0].crNo.value;
		ajaxFunction2(url, "1", "getIssueDtlsAjaxResponse");
	}
}
function ftnTick(mode)
{
  if(mode=='1')
  {
  	document.forms[0].strOutOfStockFlag.value='1';
  	document.forms[0].OutOfStockFlag[0].checked=false;
  	document.forms[0].OutOfStockFlag[1].checked=true;
  }
  else
  {
  	document.forms[0].strOutOfStockFlag.value='0';
  	document.forms[0].OutOfStockFlag[0].checked=true;
  	document.forms[0].OutOfStockFlag[1].checked=false;
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
				/*	
				if(parseInt(prescQty,10)<parseInt(issueQty,10) || prescQty.length=='0')
				{
					alert("Issue Quantity cannot be greater than Prescribe Quantity");					
					document.getElementById("strQtyText"+index).value="";
					return false;
				}			
			*/
		}
}
function checkPresQty(index)
{
	var prescQty     = document.getElementById("strPrescQty"+index).value;
	if(parseInt(prescQty,10)=='0' ||parseInt(prescQty,10)== 0 )
	{
	    alert("Prescribe Quantity cannot be equal to Zero");
	    document.getElementById("strPrescQty"+index).value="";		
		return false;
	}
}

function initPrint(eve) 
{
	var flag = validateData(eve, 5);
	if (flag) {
		if (eve.keyCode == 13) 
		{
			printDataOne(1);
		}
	} else {
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
	 

}	

function controlToMainPage()
{	    
	
		document.forms[0].hmode.value="INITVALWITHOUTCRNO";
		//document.forms[0].reset();
		document.forms[0].submit();
}



function cancelIssue() 
{
	showMenuFrame();
	document.forms[0].hmode.value = "CANCELPAGE";
	document.forms[0].submit();
}
function hideIssuePopupOne() 
{
	document.getElementById("issueDtlsDivId").innerHTML = "";
	hide_popup('popUpDiv');
	document.getElementsByName("strFirstName")[0].focus();

}

function clearIssue(mode) 
{
  if(mode==1)
  {	
	document.forms[0].strIssueNum.value = "";
	document.forms[0].strId.value = "";
	document.forms[0].strPatientAge.value="";
	document.getElementsByName("strPatientId")[0].value='';
	//document.getElementsByName("strPatientFatherName")[0].value='';
	document.getElementsByName("strPatientAge")[0].value='';
	document.getElementsByName("strPatientAgeUnit")[0].value='1';	
	document.getElementById("id1").innerHTML="";
	document.getElementById("errMsg").innerHTML="";
	document.getElementById("warningMsg").innerHTML="";
	document.getElementById("normalMsg").innerHTML="";	
	document.getElementsByName("strFirstName")[0].focus();
  }
  else
  {
  	document.getElementsByName("PrintPage")[0].focus();
  }

}

var gblObject = "";

function getItemDetails() {

	var url = "IssueTransCNT.cnt?hmode=ITEMDETAILS&reqNo=" + gblObject
			+ "&crNo=" + document.forms[0].crNo.value + "&strId="
			+ document.forms[0].strId.value;

	ajaxFunction(url, "7");

}

function getViewItemDtl() 
{
	    //document.getElementById("breakageItemDtlId").innerHTML = "";
		//document.getElementById("breakageItemDtlId").style.display = "none";
	    /*var hisValidator = new HISValidator("issueBean");
	    
	    
	    hisValidator.addValidation("strStoreId", "dontselect=0","Please Select Store Name");
        hisValidator.addValidation("strItemCat", "dontselect=0","Please Select Category ");
        if(document.forms[0].strFlagVal.value=='2')
        {
	    hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate",   "date","To Date is a mandatory field");
		hisValidator.addValidation("strFromDate", "dtltet="+document.forms[0].strCtDate.value,"Please Select From Date Less Than or Equal To "+document.forms[0].strCtDate.value);
		hisValidator.addValidation("strToDate",   "dtltet="+document.forms[0].strCtDate.value,"Please Select To Date Less Than or Equal To "+document.forms[0].strCtDate.value);
		hisValidator.addValidation("strToDate",   "dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
        }*/        
		//var retVal = hisValidator.validate();
		//hisValidator.clearAllValidations();	
	    if(true)
	    {    
	    	
	    	var diffdate = dateDiff1(document.forms[0].strFromDate.value,document.forms[0].strToDate.value); 
	 	//alert(diffdate);
	 	 if(parseInt(diffdate)>600)
	 	 {
	 		alert("Difference Between From Date and To Date Should not be greater than 600 days");
	 		return false;
	 	 }
	    	
			var temp = document.forms[0].strStoreId.value;
			var mode = "GOVIEWPAGE";
			var url = "IssueTransCNT.cnt?hmode=" + mode + "&storeId="
					+ temp + "&itemCatNo="
					+ document.forms[0].itemCategory.value + "&fromDate="
					+ document.forms[0].strFromDate.value + "&ToDate="
					+ document.forms[0].strToDate.value+"&strFlagVal="+document.forms[0].strFlagVal.value+"&crNo="+document.forms[0].crNo.value;
			document.getElementById("loadingId").innerHTML = "<strong><font size='2' color='red'>Loading....</font></strong>";		
			ajaxFunction(url, "9");
	    }
	

}

function getIssueDtlsAjaxResponse(res, mode) {

	//STOCKDTLSINIT
	if (mode == '1') {

		var itemStockObj = document.getElementById("issueDtlsDivId");

		//itemStockObj.innerHTML = res+"<p class='example'>.</p>"+res;
		itemStockObj.innerHTML = res;

		popup('popUpDiv', '80', '60');

	}

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

function getItemCat() 
{
	document.getElementById("errMsg").innerHTML="";
	document.getElementById("warningMsg").innerHTML="";
	document.getElementById("normalMsg").innerHTML="";
	
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
	//document.getElementsByName("strFirstName")[0].focus();
}

var objGlobal = "";

function getIssuePopUp(these, index) {

	objGlobal = these;

	var url = "IssueTransCNT.cnt?hmode=ISSUEDTLPOPUP&strId="
			+ document.forms[0].strId.value + "&issueNo="
			+ document.getElementById("strIssueNo" + index).value;
	ajaxFunction(url, "3");

}

function getAjaxResponse(res, mode) {

	if (mode == "1")
	{
		//document.getElementsByName("strFirstName")[0].focus();
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
	if (mode == "7") 
	{

		var objVal = document.getElementById("itemDtlDivId");
		objVal.innerHTML = res;

		getRequestDtl();

	}
	if (mode == "8") 
	{		   
	    if(res!='')
	    {
		    document.forms[0].strPatientAge.value='';
		    //document.forms[0].strPatientFatherName.value='';
		    document.forms[0].strPatientId.value='';	    
			var itemStockObj = document.getElementById("issueDtlsDivId");
			//itemStockObj.innerHTML = res+"<p class='example'>.</p>"+res;
			
			itemStockObj.innerHTML = res;
			
			document.getElementsByName("PrintPage")[0].focus();
			popup('popUpDiv', '80', '60');	
			clearIssue(2);
	    } 
	}
	if (mode == "9") 
	{

		var     storeName = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
		var itemCategName = document.forms[0].strItemCat[document.forms[0].strItemCat.selectedIndex].text;

		document.getElementById("breakageItemDtlId").innerHTML = res;
		//document.getElementById("breakageItemDtlId").style.display = "block";
		document.getElementById("loadingId").innerHTML = "";
		//document.getElementById('issueminusdiv').style.display='block';
		//document.getElementById('issueplusdiv').style.display='none';
		validateIssue('0');
		
	}
	if (mode == "10") 
	{		        
		var itemStockObj = document.getElementById("issueDtlsDivId");
		//itemStockObj.innerHTML = res+"<p class='example'>.</p>"+res;
		
		itemStockObj.innerHTML = res;
		popup('popUpDiv', '80', '60');	
		
	}
	
	if (mode == "11") 
	{		        
		var itemStockObj = document.getElementById("issueItemDtlsDivId");
		itemStockObj.innerHTML = res;	
		//document.getElementById("issueItemDtlsDivId").style.display = '';
		
	}
	
	if (mode == "12") 
	{		        
		document.getElementById("issueItemDtlsDivId").style.display = '';
		
	}
}

function transferToViewPage()
{
	if (document.getElementsByName("strViewChk")[0].checked) 
	{
		document.forms[0].hmode.value = "VIEWPAGE";
		document.forms[0].submit();
	}
}

function generateIssueReportFunc(obj, i) 
{
	indexglobal      = i;
	parentPopup      = obj;
	var issueNo      = document.getElementById('strHlpIssueNo' + i).value;
	var storeId      = document.forms[0].strStoreId.value;
	
	if (issueNo != "0") 
	{
		    var strMode = "1";
			var hmode = "ISSUEDTLSINITONE";
		    var url = "IssueTransCNT.cnt?hmode=" +hmode+ "&strMode=" +strMode+ "&strStoreId=" +storeId+ "&strIssueNo=" + issueNo;
		    ajaxFunction(url, "10");
	}

}

function getReport()
{
	alert('12');
	var issueNo      = document.forms[0].strHlpIssueNo.value;
	var strId        = document.forms[0].storeId.value;
    var crNo         = document.forms[0].crNo.value;	
	
	//document.forms[0].strIssueNum.value = "0";
	//document.forms[0].issueingStoreId.value = "0";
	//document.forms[0].crNo.value = "";
	//strVoucherHLP
	if (issueNo != "" && strId != "" && issueNo != "0"  && strId != "0") 
	{	 
		
		var strMode = "1";
		var hmode = "ISSUEDTLSINIT";
	    var url = "IssueTransCNT.cnt?hmode=" +hmode+ "&strMode=" +strMode+ "&strStoreId=" +strId+ "&strIssueNo=" + issueNo;
	    ajaxFunction(url, "8");
	    
	       // document.forms[0].strPatientAge.value='';
		    //document.forms[0].strPatientId.value='';	    
			var itemStockObj = document.getElementById("issueDtlsDivId");
			//itemStockObj.innerHTML = document.forms[0].strVoucherHLP.value;
			//document.getElementsByName("PrintPage")[0].focus();
			popup('popUpDiv', '80', '60');	
			//clearIssue(2); 
	}
	else
	{
		document.forms[0].strPatientAge.value="";
		document.getElementsByName("strPatientId")[0].value='';
		document.getElementsByName("strPatientAgeUnit")[0].value='1';	
		document.getElementById("id1").innerHTML="";	
	}
	
	document.getElementsByName("strFirstName")[0].focus();
	hideMenuFrame();
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

	hisValidator.addValidation("strStoreId", "dontselect=0",
			"Select Drug Warehouse Name from Drug Warehouse Combo ");
	hisValidator.addValidation("strItemCat", "dontselect=0",
			"Select Item Category from Item Category Combo");

	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

	document.forms[0].storeName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	document.forms[0].itemCatName.value = document.forms[0].strItemCat[document.forms[0].strItemCat.selectedIndex].text;
	document.forms[0].crNo.value = document.forms[0].strCrNo.value;

	document.forms[0].strId.value = document.forms[0].strStoreId.value;
	document.forms[0].itemCategory.value = document.forms[0].strItemCat.value;

	if (retVal) {
		document.forms[0].hmode.value = "INITVALGO";
		document.forms[0].submit();

	} else {
		return false;
	}
}

function onCheckCategory() {

	var patientDtlHidVal = document.forms[0].strPatientDtlHidVal.value;
	var temp = patientDtlHidVal.split('^');

	if (document.forms[0].strMode.value == '0')
	{

		if (document.forms[0].strConfCatCode.value == temp[3]) 
		{
			document.getElementById("allDivId").style.display = "none";
			alert("Go to Staff Counter....");
			document.forms[0].hmode.value = "INITVALWITHOUTCRNO";
			document.forms[0].submit();
			return false;

		}

	}
	
	 else if (document.forms[0].strMode.value == '1') {

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

function goFuncOnEnterTwo(e) 
{
	  
	
	if (e.keyCode == 13) 
	{
		validateIssue();
	} 
	else 
	{
		return false;
	}
}
//var gblhisValidator = null

function validateIssue() 
{
	var saveObj = document.getElementById("saveId");
	
	if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	{
		saveObj.style.display = "none"; 
		
		var hisValidator = new HISValidator("issueBean");
		hisValidator.clearAllValidations();
		hisValidator.addValidation("strStoreId", "dontselect=0","Please Select Store Name");
      //  hisValidator.addValidation("strItemCat", "dontselect=0","Please Select Category ");
 		//
	    hisValidator.addValidation("strFirstName","req", "Please enter the Patient's Name" );
        hisValidator.addValidation("strPatientAge","req", "Please Enter the Patient's Age");
        hisValidator.addValidation("strPatientAgeUnit", "dontselect=0","Please Select  Age Unit");
        hisValidator.addValidation("strPatientGenderCode", "dontselect=0","Please Select Gender ");
       // hisValidator.addValidation("strPatientFatherName","req", "Please enter the Patient's Father's Name" );
        hisValidator.addValidation("strPrescribedBy","req", "Please enter the Prescribed By" );   
        hisValidator.addValidation("strPatientId","req", "Please Enter the Registration No.");
       // hisValidator.addValidation("strPatientType", "dontselect=0","Please Select  Patient Type");	
       // hisValidator.addValidation("strPatientAddress","maxlen=200", "Address should have less than or equal to 250 Characters" );
        hisValidator.addValidation("strDrugIssueDate", "req","Issue Date is a Mandatory Field");
        hisValidator.addValidation("strDrugIssueDate", "dtltet="	+ document.forms[0].strCtDate.value,"Please Select Issue Date Less Than or Equal To Current Date");
        /*
		if(document.getElementsByName("strPrescriptionDate").value!="")
		{
			hisValidator.addValidation("strPrescriptionDate", "dtltet="	+ document.forms[0].strCtDate.value,"Please Select Prescription Date Less Than or Equal To Current Date");
			hisValidator.addValidation("strDrugIssueDate",    "dtgtet="+document.forms[0].strPrescriptionDate.value,"Please Select Issue Date Greater Than Or Equal To Prescription Date");
		}*/
		retVal1 = hisValidator.validate();
		hisValidator.clearAllValidations();
		
		if (retVal1) 
		{
			var itemParVal     = document.getElementsByName("itemParamValue");
		    var itemUserValue  = document.getElementsByName("itemUserValue");
		    var reqQty         = document.getElementsByName("strQtyText");
		    var count = 0;
		    
			if (document.getElementsByName("strQtyText").length <= 1) 
			{
				alert("Please Select Item from Search Utility!!!");
				saveObj.style.display = "block";
				return false;
			}
			
			//hisValidator.clearAllValidations();
			if(document.forms[0].strDose)
			{
				hisValidator.addValidation("strDose", "dontselect=0",	"Please select a value from Dose Combo");
			    hisValidator.addValidation("strFrequency", "dontselect=0",	"Please select a value from Frequency Combo");
			    hisValidator.addValidation("strDays", "req","Days is a Mandatory Field");			
			}
			
		  	//hisValidator.addValidation("strPrescQty", "req",	"Prescribe Quantity is a Mandatory Field");
		  	hisValidator.addValidation("strQtyText", "req",	"Quantity is a Mandatory Field");
		  	//hisValidator.addValidation("strReceiveBy", "req","Receive By is Mandatory");
		  	hisValidator.addValidation("strRemarks", "maxlen=100",	"Remarks should have less than or equal to 100 Characters");

		  	retVal = hisValidator.validate();
		  	hisValidator.clearAllValidations();
			
			if (retVal) 
			{
				if(itemParVal.length>1)
				{												
					 for(var i=0;i<itemParVal.length-1;i++)
					 {
					 	itemUserValue[i].disabled=false;
					 	   itemParVal[i].disabled=false;
					 	if(reqQty[i].value=='0' || reqQty[i].value == 0)
					 	{
					 		count++;
					 	}												 	
					 }									  
				}
															
				if(count == (itemParVal.length-1))
				{
					alert("Please enter one Quantity Greater than Zero!!!");
					saveObj.style.display = "block";
					return false;
				}
				else
				{
					/*
					for(var i=0;i<itemParVal.length-1;i++)
					 {
					 	itemUserValue[i].disabled=false;
					 										 	
					 }
					 */	
					 document.forms[0].storeName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
					 document.forms[0].strStoreId.disabled = false;
					 document.forms[0].hmode.value = "INSERTWithoutCrNo";
					 document.forms[0].submit();
				}
			} 
			else
			{
				saveObj.style.display = "block";
				return false;
			}
          }
          else
		  {
		  		saveObj.style.display = "block";
				return false;
		  }
	}
}

function chkVisitDtl() {
	if (document.forms[0].strVisitDtl.value == '0') {
		alert("Patient has not visited on this Prescription Date, \n So medicine cannot issued");
		return false;

	} else {

		getReport();

	}
}

// function to show report after save data





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
		document.getElementById('strReqQty' + i).value = document
				.getElementById('strQtyText' + i).value;
	}

}

function getReceivedBy()
{
	
	document.forms[0].strReceiveBy.value=document.forms[0].strPatientName.value;
}

function goToCancelPage()
{
	
	var mode = "GETCANCELPAGE";
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();
}

function goToWithCrNoPage()
{
	
	var mode = "INITVAL";
	document.forms[0].strIssueNum.value = "0";
//	document.forms[0].reset();
	document.forms[0].hmode.value = mode;
	
	document.forms[0].submit();
}

function validateIssue(i)
{
	//hideIssueDiv();
//	document.getElementById("minusdiv"+i).style.display = '';
	//document.getElementById("plusdiv"+i).style.display = 'none';
	var issueNo      = document.getElementById('strHlpIssueNo' + i).value;
	var storeId      = document.forms[0].strStoreId.value;
	document.forms[0].strHiddenIssueNo.value=issueNo;
	if (issueNo != "0") 
	{
			var hmode = "ISSUEDTLSBILLED";
		    var url = "IssueTransCNT.cnt?hmode=" +hmode+ "&strStoreId=" +storeId+ "&strIssueNo=" + issueNo;
		    ajaxFunction(url, "11");
	}
}

function deleteIssue(i)
{
	 var confi = confirm("Are you sure want to remove?");
	 if(confi == true)
     {
			document.getElementById("plusdiv"+i).style.display = 'none';
			document.getElementById("roww"+i).style.display = 'none';
			var issueNo      = document.getElementById('strHlpIssueNo' + i).value;
			var storeId      = document.forms[0].strStoreId.value;
			if (issueNo != "0") 
			{
					var hmode = "DELETEISSUEDETAILS";
				    var url = "IssueTransCNT.cnt?hmode=" +hmode+ "&strStoreId=" +storeId+ "&strIssueNo=" + issueNo;
				    ajaxFunction(url, "12");
			}
     }
}
function hideDiv()
{
	document.getElementById("minusdiv").style.display = 'none';
	for( var k=0;k < document.getElementsByName("plus").length;k++ )
		document.getElementById("plusdiv"+k).style.display = 'block';
	document.getElementById("issueItemDtlsDivId").style.display='none';
	document.getElementById("breakageItemDtlId").style.display='block';
}

function hideIssueDiv()
{
	document.getElementById('issueminusdiv').style.display='none';
	
	document.getElementById("breakageItemDtlId").style.display='none';
	document.getElementById("issueItemDtlsDivId").style.display='block'; 
	document.getElementById('issueplusdiv').style.display='block';
	
}
function showIssueDiv()
{
	document.getElementById('issueminusdiv').style.display='block';
	document.getElementById('issueplusdiv').style.display='none';
	document.getElementById("breakageItemDtlId").style.display='block';
	for( var k=0;k < document.getElementsByName("plus").length;k++ )
		document.getElementById("plusdiv"+k).style.display = 'block';
	document.getElementById("issueItemDtlsDivId").style.display='none';
}
function save()
{
	document.forms[0].strStoreId.disabled=false;
	document.forms[0].strItemCat.disabled=false;
	var mode = "SAVE";
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();
}
