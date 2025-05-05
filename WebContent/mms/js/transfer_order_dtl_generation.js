function displayPopupDtls(obj, reqQty, orderQty) {

	document.getElementById("reqQtyDivId").innerHTML = reqQty;
	document.getElementById("ordQtyDivId").innerHTML = orderQty;

	display_popup_menu(obj, 'itemDtlId', '', '');
}

function closeItemPopUp(divId) {
	hide_popup_menu(divId);
}

function cancel(mode) {
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();
}

function getDemandRequestDetails(obj) {

	var mode = "GET_DEMAND_REQ_DTL";
	var url = "TransferApprovalTransCNT.cnt?hmode=" + mode + "&strStoreId="
			+ obj.value;
	ajaxFunction(url, "1");

}

function getTransferingDetails(obj) {

	var mode = "GET_TRANS_DTL";
	var url = "TransferApprovalTransCNT.cnt?hmode=" + mode + "&strItemBrandId="
			+ obj.value.split('^')[1];

	document.forms[0].strReqQtyTemp.value = obj.value.split('^')[2];

	ajaxFunction(url, "2");

}

function enableTransferQty(obj, index) {

	if (obj.checked) {

		document.getElementById("strTransferOrderQty" + index).disabled = false;
		document.getElementById("strTransferOrderQty" + index).select();
		document.getElementById("strTransferOrderQty" + index).focus();
	} else {

		document.getElementById("strTransferOrderQty" + index).value = 0;
		document.getElementById("strTransferOrderQty" + index).disabled = true;

		calculateTransferTotalOrder();

	}

}

function checkTransferTotalOrder(obj, index) {

	var orderQty = "0";
	var balanceBaseVal = "0";
	if (obj.value != null && obj.value != "") {

		orderQty = obj.value;
	}

	if (document.getElementById("strTransferingDtlsCheckId" + index) != null)
		balanceBaseVal = document.getElementById("strTransferingDtlsCheckId"
				+ index).value.split('^')[2];

	if (parseFloat(orderQty) > parseFloat(balanceBaseVal)) {

		alert("Order Qty. cannot be greater than Balance Qty.");
		document.getElementById("strTransferOrderQty" + index).value = "0";
		document.getElementById("strTransferOrderQty" + index).select();

	}

	calculateTransferTotalOrder();

}



function checkTransferTotalOrderModify(obj, index) {

	var orderQty = "0";
	var balanceBaseVal = "0";
	if (obj.value != null && obj.value != "") {

		orderQty = obj.value;
	}

	if (document.getElementById("strTransferingDtlsCheckId" + index) != null)
		balanceBaseVal = document.getElementById("strTransferingDtlsCheckId"
				+ index).value.split('^')[2];

	if (parseFloat(orderQty) > parseFloat(balanceBaseVal)) {

		alert("Order Qty. cannot be greater than Balance Qty.");
		document.getElementById("strTransferOrderQty" + index).value = "0";
		document.getElementById("strTransferOrderQty" + index).select();

	}

	calculateTransferTotalOrder();

}


function calculateTransferTotalOrder() {

	var strOrderTotal = parseFloat("0");

	var orderQtyObj = document.getElementsByName("strTransferOrderQty");

	if (orderQtyObj.length > 0) {

		for ( var i = 0; i < orderQtyObj.length; i++) {

			if (orderQtyObj[i].value != "" && orderQtyObj[i].value.length > 0) {

				strOrderTotal = strOrderTotal
						+ parseFloat(orderQtyObj[i].value);

			}

		}

	}

	
	document.forms[0].strTotalOrderQty.value = strOrderTotal;
	document.getElementById("strTotalOrderQtyDivId").innerHTML = strOrderTotal;

}

function GetIndex(index, endVal) {

	for ( var i = 1; i <= endVal; i++) {

		document.getElementById("DivId" + i).style.display = "none";
	}

	document.getElementById("DivId" + index).style.display = "block";

}

function getAjaxResponse(res, mode) {

	var err = document.getElementById("errMsg");
	var temp = res.split("####");
	if (temp[0] == "ERROR") {
		err.innerHTML = temp[1];
		return;
	}
	if (mode == "1") {
		document.getElementById("demandRequestDtlsDivId").innerHTML = res;
		document.getElementById("transferingDtlsDivId").style.display = "none";

	}
	if (mode == "2") {
		document.getElementById("transferingDtlsDivId").innerHTML = res;
		document.getElementById("transferingDtlsDivId").style.display = "block";

	}
}

function ClearPage() {
	document.forms[0].reset();
	
	document.getElementById("transferingDtlsDivId").innerHTML = "";
	document.getElementById("transferingDtlsDivId").style.display = "none";

}

 
function validate_orderGenerate() {

	if(document.getElementsByName("strDemandRequest") != null){
		
		var flag = false;
		var orderDemandRadio = document.getElementsByName("strDemandRequest");
				
		for ( var i = 0; i < orderDemandRadio.length; i++) {
				
			if(orderDemandRadio[i].checked){
				flag = true;
				break;
			}
			
		}
		
		if(! flag){
			alert("Please select a Demand Request Detail");
			return false;
		}
		
	}
	
	var hisValidator = new HISValidator("TransferApprovalTransBean");

	hisValidator.addValidation("strTotalOrderQty", "numgt=0",
	"Total Order Qty. should be Greater than 0.");
	hisValidator.addValidation("strTotalOrderQty", "numltet="+document.forms[0].strReqQtyTemp.value,
			"Total Order Qty. cannot be Greater than Demanding Qty. "+document.forms[0].strReqQtyTemp.value);

	var retVal = hisValidator.validate();
 	
	hisValidator.clearAllValidations();
	if (retVal) {
		var conf = confirm("You Are Going To Save!!!");
		if (conf == true) {
			var conf1 = confirm("Separate Order will be generated for each Transfer !!!");
			if (conf1 == true) {
				document.forms[0].hmode.value = "ORDER_GENERATE_INSERT";
				document.forms[0].submit();
			} else {
				return false;
			}
		} else {
			return false;
		}
	} else {
		return false;
	}

}



function validate_orderModify() {


	var hisValidator = new HISValidator("TransferApprovalTransBean");

	hisValidator.addValidation("strTotalOrderQty", "numgt=0",
	"Total Order Qty. should be Greater than 0.");
	hisValidator.addValidation("strTotalOrderQty", "numltet="+document.forms[0].strBalanceQtyBaseValue.value,
			"Total Order Qty. cannot be Greater than Demanding Qty. "+document.forms[0].strBalanceQtyBaseValue.value);

	var retVal = hisValidator.validate();
 	
	hisValidator.clearAllValidations();
	if (retVal) {
		var conf = confirm("You Are Going To Save!!!");
		if (conf == true) {
			var conf1 = confirm("Separate Order will be generated for each Transfer !!!");
			if (conf1 == true) {
				document.forms[0].hmode.value = "ORDER_MODIFY_INSERT";
				document.forms[0].submit();
			} else {
				return false;
			}
		} else {
			return false;
		}
	} else {
		return false;
	}

}

