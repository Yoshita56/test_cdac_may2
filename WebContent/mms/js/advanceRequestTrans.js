
function onNewGo() {

	var hisValidator = new HISValidator("advanceRequestBean");

	hisValidator.addValidation("strStoreId", "dontselect=0",
			"Select Drug Warehouse Name from Store Combo ");
	hisValidator.addValidation("strItemCat", "dontselect=0",
			"Select PO NO from Item Category Combo");
	hisValidator.addValidation("strPONo", "dontselect=0",
			"Select PO NO from PO NO Combo");

	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

	document.forms[0].storeName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	document.forms[0].itemCatName.value = document.forms[0].strItemCat[document.forms[0].strItemCat.selectedIndex].text;
	document.forms[0].poNoVal.value = document.forms[0].strPONo[document.forms[0].strPONo.selectedIndex].text;

	document.forms[0].strId.value = document.forms[0].strStoreId.value;
	document.forms[0].itemCategory.value = document.forms[0].strItemCat.value;
	document.forms[0].ponovalue.value = document.forms[0].strPONo.value;
	if (retVal) {

		document.forms[0].hmode.value = "NEW";
		document.forms[0].disFlag.value = "1";
		document.forms[0].target = "_self";
		document.forms[0].submit();

	} else {
		return false;
	}
}

function validateNew() {

	var hisValidator = new HISValidator("advanceRequestBean");

	if (document.forms[0].disFlag.value == "0") {

		hisValidator.addValidation("strStoreId", "dontselect=0",
				"Select Drug Warehouse Name from Drug Warehouse Combo ");
		hisValidator.addValidation("strItemCat", "dontselect=0",
				"Select PO NO from Item Category Combo");
		hisValidator.addValidation("strPONo", "dontselect=0",
				"Select PO NO from PO NO Combo");

	} else {

		hisValidator.addValidation("strAdvRequest", "req",
				"Request Advance Amount is mandatory");
		hisValidator
				.addValidation("strAdvRequest", "amount=11,2",
						"Enter the Request Advance Amount in correct format e.g.00000000000.00");
		hisValidator.addValidation("strBankAccName", "req",
				"Bank Account Name is mandatory");
		hisValidator.addValidation("strBankAccNo", "req",
				"Bank Account No. is mandatory");
		hisValidator.addValidation("strRemarks", "maxlen=100",
				"Remarks should have less than or equal to 100 Characters");

	}
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

	if (retVal) {

		if (document.forms[0].disFlag.value == "0") {

			alert("First click on go button to get the PO Details");
			return false;
		} else {
			resetValue();
			document.forms[0].hmode.value = "INSERTNEW";
			document.forms[0].target = "_blank";
			document.forms[0].submit();

		}
	} else {
		return false;
	}
}

function validateDuplicate() {

	var hisValidator = new HISValidator("advanceRequestBean");

	if (document.forms[0].disFlag.value == "0") {

		hisValidator.addValidation("strStoreId", "dontselect=0",
				"Select Drug Warehouse Name from Drug Warehouse Combo ");
		hisValidator.addValidation("strItemCat", "dontselect=0",
				"Select PO NO from Item Category Combo");
		hisValidator.addValidation("strPONo", "dontselect=0",
				"Select PO NO from PO NO Combo");

	}

	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

	if (retVal) {

		if (document.forms[0].disFlag.value == "0") {

			alert("First click on go button to get the PO & Request Details");
			return false;

		} else {
			resetValueDuplicate();
			document.forms[0].hmode.value = "SHOWRPT";
			document.forms[0].target = "_blank";
			document.forms[0].submit();

		}
	} else {
		return false;
	}
}

function onDuplicateGo() {

	var hisValidator = new HISValidator("advanceRequestBean");

	hisValidator.addValidation("strStoreId", "dontselect=0",
			"Select Drug Warehouse Name from Drug Warehouse Combo ");
	hisValidator.addValidation("strItemCat", "dontselect=0",
			"Select PO NO from Item Category Combo");
	hisValidator.addValidation("strPONo", "dontselect=0",
			"Select PO NO from PO NO Combo");

	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

	document.forms[0].storeName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	document.forms[0].itemCatName.value = document.forms[0].strItemCat[document.forms[0].strItemCat.selectedIndex].text;
	document.forms[0].poNoVal.value = document.forms[0].strPONo[document.forms[0].strPONo.selectedIndex].text;

	document.forms[0].strId.value = document.forms[0].strStoreId.value;
	document.forms[0].itemCategory.value = document.forms[0].strItemCat.value;
	document.forms[0].ponovalue.value = document.forms[0].strPONo.value;

	if (retVal) {

		document.forms[0].hmode.value = "DUPLICATEGO";
		document.forms[0].disFlag.value = "2";
		document.forms[0].target = "_self";
		document.forms[0].submit();

	} else {
		return false;
	}
}

function onLoadNewPage() {

	if (document.getElementsByName('strChkAdvanceReq')[0].checked) {

		document.getElementsByName("strChkAdvanceReq")[0].value = "1";

	}

	if (document.forms[0].disFlag.value == "1") {

		document.getElementsByName('strChkAdvanceReq')[0].checked = true;

		document.getElementById('storeId').style.display = "none";
		document.getElementById('storeValId').style.display = "block";
		document.getElementById('itemcatDivId').style.display = "none";
		document.getElementById('catValId').style.display = "block";
		document.getElementById('ponoDivId').style.display = "none";
		document.getElementById('ponoValId').style.display = "block";
		document.getElementById('goDivId').style.display = "none";
		document.getElementById('inCasePODtl').style.display = "block";
		document.getElementById('poDetailNewDivId').style.display = "block";
		document.getElementById('newreqdtlsDiv').style.display = "block";
	} else {

		document.getElementsByName('strChkAdvanceReq')[0].checked = true;

	}

	/*
	 * if(document.getElementsByName("strHasInsert")[0].value=="1"){ alert("1");
	 * document.getElementById('poDetailNewDivId').style.display = "none";
	 * document.getElementById('newreqdtlsDiv').style.display = "none";
	 * document.getElementById('inCasePODtl').style.display = "none";
	 * document.getElementById('storeId').style.display = "block";
	 * document.getElementById('storeValId').style.display = "none";
	 * document.getElementById('itemcatDivId').style.display = "block";
	 * document.getElementById('catValId').style.display = "none";
	 * document.getElementById('ponoDivId').style.display = "block";
	 * document.getElementById('ponoValId').style.display = "none";
	 * document.getElementById('goDivId').style.display = "block";
	 * 
	 *  }
	 */
}

function resetValue() {
	document.getElementById('poDetailNewDivId').style.display = "none";
	document.getElementById('newreqdtlsDiv').style.display = "none";
	document.getElementById('inCasePODtl').style.display = "none";
	document.getElementById('storeId').style.display = "block";
	document.getElementById('storeValId').style.display = "none";
	document.getElementById('itemcatDivId').style.display = "block";
	document.getElementById('catValId').style.display = "none";
	document.getElementById('ponoDivId').style.display = "block";
	document.getElementById('ponoValId').style.display = "none";
	document.getElementById('goDivId').style.display = "block";

}

function resetValueDuplicate() {
	document.getElementById('poDetailDupDivId').style.display = "none";
	document.getElementById('reqdtlsDiv').style.display = "none";
	document.getElementById('storeId').style.display = "block";
	document.getElementById('storeValId').style.display = "none";
	document.getElementById('itemcatDivId').style.display = "block";
	document.getElementById('catValId').style.display = "none";
	document.getElementById('ponoDivId').style.display = "block";
	document.getElementById('ponoValId').style.display = "none";
	document.getElementById('goDivId').style.display = "block";
	document.getElementById('bankdtlsDiv').style.display = "none";
	disPlay();
}

function onLoadDupPage() {

	if (document.getElementsByName('strChkAdvanceReq')[1].checked) {

		document.getElementsByName("strChkAdvanceReq")[1].value = "2";

	}

	if (document.forms[0].disFlag.value == "2") {
		document.getElementsByName('strChkAdvanceReq')[1].checked = true;
		document.getElementById('storeId').style.display = "none";
		document.getElementById('storeValId').style.display = "block";
		document.getElementById('itemcatDivId').style.display = "none";
		document.getElementById('catValId').style.display = "block";
		document.getElementById('ponoDivId').style.display = "none";
		document.getElementById('ponoValId').style.display = "block";
		document.getElementById('reqdtlsDiv').style.display = "block";
		document.getElementById('goDivId').style.display = "none";
		document.getElementById('poDetailDupDivId').style.display = "block";
		document.getElementById('bankdtlsDiv').style.display = "block";
		document.getElementsByName('strRadioVal')[0].checked = true;

	} else {
		document.getElementsByName('strChkAdvanceReq')[1].checked = true;

	}

}

function getItemCat(obj) {

	if (obj != null && obj.value != "" && obj.value != "0") {
		var url = "AdvanceRequestTransCNT.cnt?hmode=ITEMCATCMB&storeId="
				+ obj.value;
		ajaxFunction(url, "1");
	} else {
		document.getElementById("itemcatDivId").innerHTML = "<select name ='strItemCat' class='comboNormal' ><option value='0'>Select Value</option></select>";
		document.getElementById("ponoDivId").innerHTML = "<select name ='strPONo' class='comboNormal' ><option value='0'>Select Value</option></select>";
	}

}
function getPONoVal() {

	var flag = "";
	if (document.getElementsByName('strChkAdvanceReq')[0].checked) {
		flag = "1";
	} else if (document.getElementsByName('strChkAdvanceReq')[1].checked) {
		flag = "2";
	}
	var url = "AdvanceRequestTransCNT.cnt?hmode=PONOCMB&itemcatId="
			+ document.forms[0].strItemCat.value + "&storeId="
			+ document.forms[0].strStoreId.value + "&chkId=" + flag;

	ajaxFunction(url, "2");

}

function getAjaxResponse(res, mode) {

	if (mode == "1") {
		if (res == "") {
			document.getElementById("itemcatDivId").innerHTML = "<select name ='strItemCat' class='comboNormal' ><option value='0'>Select Value</option></select>";
			document.getElementById("ponoDivId").innerHTML = "<select name ='strPONo' class='comboNormal' ><option value='0'>Select Value</option></select>";
		} else {
			var objVal = document.getElementById("itemcatDivId");
			objVal.innerHTML = "<select name ='strItemCat' class='comboNormal' onchange='getPONoVal();'>"
					+ res + "</select>";
			getPONoVal();
		}

	}
	if (mode == "2") {

		var temp = res.split("@");
		var objVal = document.getElementById("ponoDivId");
		objVal.innerHTML = temp[1]
				+ "<select name ='strPONo' class='comboNormal'>" + temp[0]
				+ "</select>";
	}
}

function cancelAdv() {
	document.forms[0].hmode.value = "CANCELPAGE";
	document.forms[0].target = "_self";
	document.forms[0].submit();
}

function chkRadio() {

	if (document.getElementsByName('strCheckValue')[0].value) {

		document.forms[0].hmode.value = "NEW";
		document.forms[0].disFlag.value = "0";
		document.forms[0].target = "_self";
		document.forms[0].submit();

	} else if (document.getElementsByName('strCheckValue')[1].value) {

		document.forms[0].hmode.value = "DUPLICATE";
		document.forms[0].disFlag.value = "0";
		document.forms[0].target = "_self";
		document.forms[0].submit();

	}
}

function clearNew() {

	var url;
	var mode = "NEW";
	document.forms[0].hmode.value = mode;
	document.forms[0].disFlag.value = "0";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}

function clearDuplicate() {

	var url;
	var mode = "DUPLICATE";
	document.forms[0].hmode.value = mode;
	document.forms[0].disFlag.value = "0";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}

function disPlay() {
	// alert(document.forms[0].disFlag.value);

	/*
	 * if((document.forms[0].disFlag.value ==
	 * "1")||(document.forms[0].disFlag.value == "2")) {
	 * 
	 * var conf = confirm("Are You Sure \n to change the mode");
	 * 
	 * if(conf == true) {
	 * 
	 * if(document.getElementsByName('strChkAdvanceReq')[0].checked){
	 * 
	 * 
	 * document.forms[0].hmode.value = "NEW"; document.forms[0].disFlag.value =
	 * "1"; document.forms[0].target= "_self"; document.forms[0].submit();
	 * 
	 * }else if(document.getElementsByName('strChkAdvanceReq')[1].checked){
	 * 
	 * document.forms[0].hmode.value = "DUPLICATE";
	 * document.forms[0].disFlag.value = "2"; document.forms[0].target= "_self";
	 * document.forms[0].submit(); } } else {
	 * 
	 * return false;
	 *  } } else {
	 */

	if (document.getElementsByName('strChkAdvanceReq')[0].checked) {

		document.forms[0].hmode.value = "NEW";
		document.forms[0].disFlag.value = "0";
		document.forms[0].target = "_self";
		document.forms[0].submit();

	} else if (document.getElementsByName('strChkAdvanceReq')[1].checked) {

		document.forms[0].hmode.value = "DUPLICATE";
		document.forms[0].disFlag.value = "0";
		document.forms[0].target = "_self";
		document.forms[0].submit();

	}
}
// }

function checkReqQty(obj) {

	var advTaken = parseFloat(document.forms[0].strAdvTaken.value);
	var reqAdvAmt = parseFloat(document.forms[0].strRequestedAdvAmt.value);
	var netAmt = parseFloat(document.forms[0].strPOAmt.value);

	var result = parseFloat(netAmt - (reqAdvAmt + advTaken));
	if (parseFloat(obj.value) > result) {

		alert("Request Advance Amt should not be greater than \n (PO Net Amount - (Advance Amount + Requested Advance Amount))");
		document.getElementsByName("strAdvRequest")[0].value = "";

	}
	if (parseFloat(obj.value) == "0") {

		alert("Requested Advance Amt Should be greater than zero.");
		document.getElementsByName("strAdvRequest")[0].value = "";

	}
}
