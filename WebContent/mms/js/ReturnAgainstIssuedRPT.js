function getAjaxResponse(res,mode)
 {
	if (mode == "1") {
    	var Temp = res.split("$");
		
		document.getElementById("issuedDtlId").innerHTML = Temp[0];
		document.getElementById("issuedDtlId").style.display = "block";
		
		document.getElementById("returnDtlId").innerHTML = Temp[1];
		document.getElementById("returnDtlId").style.display = "block";

	}
	if (mode == "21") {
		var itemStockObj = document.getElementById("voucherDivId");
		itemStockObj.innerHTML = res;
		popup('popUpDiv', '80', '60');
	}
 }

function getReturnAndIssueDtl() {
	
	var x = document.getElementById("FMid");
	x.style.display = "none";
        /*
		if (document.getElementsByName("strStoreName")[0].value == "0") 
		{
			alert("Please Select Store From Combo");
		} 
		else
		*/ 
		if (document.getElementsByName("strCrNo")[0].value == "0" || document.getElementsByName("strCrNo")[0].value == "") 
		{
			alert("Please Enter CR No");
		} 
		else 
		{
			
			var temp = document.forms[0].strStoreName.value;
			var mode = "GETISSUERETURNDTLS";
			var url = "ReturnAgainstIssuedRPTCNT.cnt?hmode=" + mode
					+"&StoreName=" + document.getElementsByName("strStoreName")[0].value 
					+ "&CrNo="+document.forms[0].strCrNo.value
					+"&FromDate="+document.forms[0].strFromDate.value 
					+ "&ToDate="+document.forms[0].strToDate.value;
			ajaxFunction(url, "1");
			
			document.getElementById("StoreId").disabled =true;
			document.forms[0].strCrNo.disabled =true;
			document.forms[0].strFromDate.disabled =true;
			document.forms[0].strToDate.disabled =true;
		}

}

//return voucher 
function generateReturnFunc(obj, i) 
{
	indexglobal = i;
	parentPopup = obj;
	var returnNo     = document.getElementById('strHlpReturnNo'+ i).value;
	var storeId      = document.getElementById('strHlpReturnStoreId'+ i).value;
	var crNo   		 = document.getElementById('strHlpCrNo'+ i).value;
	var returnDate   = document.getElementById('strHlpReturnDate'+ i).value;
		
	//alert("Store Id-"+i+"-"+storeId);
	
	if (returnNo != "0") {
		getReturnDtls('2', storeId, returnNo, crNo, returnDate);
	}
}
//return voucher 
function getReturnDtls(strMode, strStoreId, strReturnNo,strCrNo,strReturnDate,ucReq) {
	
	gblMode = strMode;
	gblStoreId = strStoreId;
	gblReturnNo = strReturnNo;
	
	if(!isNaN(strReturnNo)){
		
		if(strReturnNo.length>0){
			gblReturnNo=strReturnNo;
			gblReturnDate=strReturnDate;
		}else{
			  gblReturnNo="0";
			  gblReturnDate="0";
		}
	}else{
		  gblReturnNo="0";
		  gblReturnDate="0";
	}

    var itemStockObj = document.getElementById("voucherDivId");

	if (itemStockObj.innerHTML == "") {

		var hmode = "RETURNDTLSVOUCHER";
		
		var url = "ReturnAgainstIssuedRPTCNT.cnt?hmode=" + hmode + "&strMode=" + strMode
		+ "&strStoreId=" + strStoreId + "&strReturnNo=" + strReturnNo+ "&crNo="+strCrNo+
		  "&strReturnDate="+strReturnDate+
		  "&strUCReq="+ucReq;
		//alert(url);
		ajaxFunction2(url, "1", "getReturnVoucherAjaxResponse");

	} else {
		// set for 1024 * 760 screen don't change this
		popup('popUpDiv', '80', '60');
	}
}
//return voucher 
function getReturnVoucherAjaxResponse(res, mode) {

	//STOCKDTLSINIT
	if (mode == '1') {

		var itemStockObj = document.getElementById("voucherDivId");

		itemStockObj.innerHTML = res;

		popup('popUpDiv', '80', '60');

	}

}

function hideIssuePopup(){
	
	document.getElementById("voucherDivId").innerHTML = "";
	
	hide_popup('popUpDiv');
	
}

function printData_O() 
{
	document.getElementById("printImg").style.display="none"; 
    const contentToPrint = document.getElementById("voucherDivId").cloneNode(true);
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

//issue voucher 
function generateIssueFunc(these, index) 
{	
	var strStoreId = document.getElementById("strHlpStoreId"+index).value;
	var strIssueNo = document.getElementById("strHlpIssueNo"+index).value; 
	var strCrNo    = document.getElementById("strHlpCrNo"+index).value;
	
	var url = "ReturnAgainstIssuedRPTCNT.cnt?hmode=ISSUEDTLSVOUCHER&strId="
				+ strStoreId + "&strIssueNo="
				+ strIssueNo+ "&strCrNo="
				+ strCrNo+"&viewMode=1";
	ajaxFunction(url, "21");

}

 
