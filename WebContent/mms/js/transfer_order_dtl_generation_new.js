
var count = 0;
function toCart() {
	var itemName = $("#strItemBrandId option:selected").text();
	var cartItemIdArr = [];
	var cartItemIdArr1 = [];
	var htmlVal = "";
	var flag = true;
	var msg = document.getElementById("itemName").value;

	var msg1 = document.getElementById("excessQty").value;

	var countEx = 0;
	var batchLen = document.getElementsByName("strExcessQty").length;
	var excessQtyObj = document.getElementsByName("strExcessQty");
	var batchObj = document.getElementsByName("strBatchHiddenValue");
	var itemBrandId = document.forms[0].strItemBrandId.value;
	/*
	 * 1.Drug Name 2.Batch No 3.Avl. Qty. 4.Expiry Date 5.Unit Name
	 * 6.Manufactrer Name 7.In Hand Qty Unit Id 8.Avl Excess Qty 10. Primary Key
	 */
	for ( var i = 0; i < batchLen; i++) {
		if ((excessQtyObj[i].value != "")
				&& (parseInt(excessQtyObj[i].value, 10) != 0)) {
			countEx++;
		}
		cartItemIdArr.push(itemBrandId + "^" + batchObj[i].value.split("^")[2]
				+ "^" + excessQtyObj[i].value + "^"
				+ batchObj[i].value.split("^")[7] + "^"
				+ batchObj[i].value.split("^")[4] + "^"
				+ batchObj[i].value.split("^")[3]);
		cartItemIdArr1.push(batchObj[i].value.split("^")[7] + "^"
				+ batchObj[i].value.split("^")[8] + "^"
				+ batchObj[i].value.split("^")[9] + "^"
				+ batchObj[i].value.split("^")[10] + "^"
				+ batchObj[i].value.split("^")[11]);
	}

	if (itemBrandId == "0") {

		alert(msg);
		flag = false;
		return false;
	} else if (countEx == 0) {
		alert(msg1);
		flag = false;
		return false;
	} else {

		for ( var i = 0; i < batchLen; i++) {
			if ((excessQtyObj[i].value != "")
					&& (parseInt(excessQtyObj[i].value, 10) != 0)) {
				$("input[name='strHiddenValue']").each(
						function() {
							if ((itemBrandId.split("^")[0] == $(this).val()
									.split("^")[0])
									&& (batchObj[i].value.split("^")[2] == $(
											this).val().split("^")[5])) {
								alert("This Item with batch ["
										+ $(this).val().split("^")[5]
										+ "] already exits");
								flag = false;
								return false;
							}
						});
			}
		}
	}

	if (flag) {

		if (document.getElementsByName("strHiddenValue").length == 0)
			count = 0;

		for ( var i = 0; i < batchLen; i++, count++) {
			/*
			 * 1.Drug Name 2.Batch No 3.Avl. Qty. 4.Expiry Date 5.Unit Name
			 * 6.Manufactrer Name 7.In Hand Qty Unit Id 8.Avl Excess Qty 10.
			 * Primary Key
			 */
			if ((excessQtyObj[i].value != "")
					&& (parseInt(excessQtyObj[i].value, 10) != 0)) {
				htmlVal = "<tr id=remId" + count + " ><td style='width:35%;' >"
						+ itemName + "</td>";
				htmlVal += "<td style='width: 15%;text-align:left;'   >"
						+ batchObj[i].value.split("^")[1] + "</td>";
				htmlVal += "<td style='width: 10%;text-align:right;'  >"
						+ batchObj[i].value.split("^")[2] + ""
						+ batchObj[i].value.split("^")[4] + "</td>";
				htmlVal += "<td style='width: 10%;text-align:center;' >"
						+ batchObj[i].value.split("^")[3] + "</td>";
				htmlVal += "<td style='width: 10%;text-align:center;' >"
						+ batchObj[i].value.split("^")[5] + "</td>";
				htmlVal += "<td style='width: 10%;text-align:right;'  >"
						+ excessQtyObj[i].value + "</td>";
				htmlVal += "<td style='width: 10%;text-align:center;' ><img src='../../hisglobal/images/trash.gif' name="
						+ count + " onclick='removeCart(this);' ></td>";
				htmlVal += "<input type='hidden' name='strHiddenValue'   value='"
						+ cartItemIdArr[i]
						+ "'>"
						+ "<input type='hidden' name='strPKey'          value='"
						+ cartItemIdArr1[i] + "'></tr>";

				if ($('#tbl-content').height() > 80)
					$("#headerTableTrans th:last").attr("id", "right-border");

				$("#tbl-content").append(htmlVal);
			}
		}
	}

	document.getElementById("DrugNameId").innerHTML = "";
	document.getElementById("strSearchDrug").value = "";
	document.getElementsByName("strGroupId")[0].value = "0";
	document.getElementsByName("strSubGroupCode")[0].value = "0";
	document.getElementById("batchDtl").innerHTML = "";

	document.getElementById("avlaibleQtyName").style.display = "none";
	document.getElementById("avlaibleQtyId").innerHTML = "";

	document.getElementById("strSearchDrug").focus();
}
function removeCart(obj) {
	$('#remId' + obj.name).remove();
	if ($('#tbl-content').height() < 100)
		$("#headerTableTrans th:last").attr("id", "");
}

function displayPopupDtls(obj, reqQty, orderQty) {

	document.getElementById("reqQtyDivId").innerHTML = reqQty;
	document.getElementById("ordQtyDivId").innerHTML = orderQty;
	display_popup_menu(obj, 'itemDtlId', '', '');
}

function displayPopupDtlsModify(obj, reqQty, orderQty, currOrderQty) {

	document.getElementById("reqQtyDivId").innerHTML = reqQty;
	document.getElementById("ordQtyDivId").innerHTML = orderQty;
	document.getElementById("curOrdQtyDivId").innerHTML = currOrderQty;
	document.getElementById("balQtyDivId").innerHTML = parseInt(reqQty)
			- parseInt(orderQty) + parseInt(currOrderQty);
	display_popup_menu(obj, 'itemDtlId', '500', '');
}

function closeItemPopUp(divId) {
	hide_popup_menu(divId);
}

function cancel(mode) {

	document.forms[0].hmode.value = mode;
	document.forms[0].submit();
}

var getItemDetails = function(obj) {

	if (obj.value != 0) {

		var rStoreId = document.forms[0].strRequestingStoreId[document.forms[0].strRequestingStoreId.selectedIndex].value;

		if (rStoreId == 0) {

			obj.selectedIndex = 0;

			alert("Please Select Requesting Store");
			document.forms[0].strRequestingStoreId.focus();
			return;
		}

		if (rStoreId == obj.value) {

			alert("Requesting Store and Transferring Store should not be Same, Please Select a Different Transferring Store ");
			obj.selectedIndex = 0;
			obj.focus();
			return;

		}

		var mode = "GET_ITEM_DTLS";
		var url = "TransferOrderDetailTransCNT.cnt?hmode=" + mode
				+ "&strStoreId=" + obj.value;
		ajaxFunction(url, "3");

	} else {

		document.getElementById("mainArea").style.display = "none";

	}

};

function getDemandRequestDetails(obj) {

	var mode = "GET_DEMAND_REQ_DTL";
	var url = "TransferOrderDetailTransCNT.cnt?hmode=" + mode + "&strStoreId="
			+ obj.value + "&strParentStoreId="
			+ document.forms[0].strTmpStoreId.value;
	ajaxFunction(url, "1");
	// alert(url);

}

function getTransferingDetails(obj) {

	var mode = "GET_TRANS_DTL";
	var url = "TransferOrderDetailTransCNT.cnt?hmode=" + mode
			+ "&strItemBrandId=" + obj.value.split('^')[1] + "&strStoreId="
			+ obj.value.split('^')[0];

	document.forms[0].strReqQtyTemp.value = obj.value.split('^')[2];

	ajaxFunction(url, "2");

}

function enableTransferQty(obj, index) {

	if (obj.checked) {

		document.getElementById("strPrimaryKey" + index).disabled = false;
		document.getElementById("strTransferOrderQty" + index).disabled = false;
		document.getElementById("strTransferOrderQty" + index).select();
		document.getElementById("strTransferOrderQty" + index).focus();
	} else {

		document.getElementById("strTransferOrderQty" + index).value = 0;
		document.getElementById("strTransferOrderQty" + index).disabled = true;
		document.getElementById("strPrimaryKey" + index).disabled = true;
		calculateTransferTotalOrder();

	}

}

function enableTransferQtyModify(obj, index) {

	if (obj.checked) {

		document.getElementById("strPrimaryKey" + index).disabled = false;
		document.getElementById("strPrimaryKey1" + index).disabled = false;
		document.getElementById("strTransferOrderQty" + index).disabled = false;
		document.getElementById("strTransferOrderQty" + index).select();
		document.getElementById("strTransferOrderQty" + index).focus();
	} else {

		document.getElementById("strTransferOrderQty" + index).value = 0;
		document.getElementById("strTransferOrderQty" + index).disabled = true;
		document.getElementById("strPrimaryKey" + index).disabled = true;
		document.getElementById("strPrimaryKey1" + index).disabled = true;
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

		alert("Ordered Qty. cannot be greater than Bal. Qty.");
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
		balanceBaseVal = document.getElementById("currItemBalQty" + index).value;

	if (parseFloat(orderQty) > parseFloat(balanceBaseVal)) {
		alert("Ordered Qty. cannot be greater than Bal. Qty.");
		document.getElementById("strTransferOrderQty" + index).value = "0";
		document.getElementById("strTransferOrderQty" + index).focus;

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
		var divHeight = 150;
		var initialHeight = 716;
		var heightPer = (divHeight * 100) / initialHeight;
		var newHeight = parseInt((window.innerHeight * heightPer) / 100, 10);
		fixedHeaderTableTrans("transferApproval", newHeight);

	}
	if (mode == "2") {
		document.getElementById("transferingDtlsDivId").innerHTML = res;
		document.getElementById("transferingDtlsDivId").style.display = "block";
		var divHeight = 100;
		var initialHeight = 716;
		var heightPer = (divHeight * 100) / initialHeight;
		var newHeight = parseInt((window.innerHeight * heightPer) / 100, 10);
		fixedHeaderTableTrans("transferingDtlsDivId", newHeight, "wrapper1",
				"tableHeaderId1");
	}

	if (mode == "3") {

		temp = res.split("#^#");

		document.getElementById("GroupNameDiv").innerHTML = "<select name='strGroupId' class='comboMax' onChange='getSubGrpAndGenericItem(this);'>"
				+ temp[0] + "</select>";
		document.getElementById("ItemBrandId").innerHTML = "<select id='strItemBrandId'	name='strItemBrandId' class='comboHalfMax' onChange='getUnitName();'>"
				+ temp[1] + "</select>";

		itemSet();

		document.getElementById("mainArea").style.display = "block";

		itemSet();

	}

	if (mode == '4') {
		document.getElementById("normalMsg").innerHTML = "";
		objVal = document.getElementById("SubGroupNameDiv");
		objVal.innerHTML = "<select name ='strSubGroupCode' class='comboMax'   onChange = 'ajaxItemBrandName();' >"
				+ res + "</select>";
		ajaxItemBrandName();
	}

	if (mode == "5") {
		objVal = document.getElementById("ItemBrandId");
		objVal.innerHTML = "<select id='strItemBrandId' name ='strItemBrandId' class='comboHalfMax' onChange='getUnitName();'>"
				+ res + "</select>";

		itemSet();

	}

	if (mode == "6") {
		objVal = document.getElementById("batchDtl");
		objVal.innerHTML = res;
	}

}

var itemSet = function() {

	$('#strSearchDrug').val("");
	var itemList = [];
	$('#strItemBrandId option').each(function() {
		itemList.push({
			"value" : this.textContent,
			"data" : this.value.split("^")[0]
		});
	});

	$('#strSearchDrug').autocomplete({
		lookup : itemList,
		minChars : 3,
		onSelect : function(suggestion) {
			getDrugNameSelected(suggestion.data);
		}
	});

	$('#strSearchDrug').click(function() {
		$(this).val("");
	});

};

function getSubGrpAndGenericItem() {
	document.getElementById("DrugNameId").innerHTML = "";
	document.getElementById("avlaibleQtyName").style.display = "none";
	document.getElementById("avlaibleQtyId").innerHTML = "";
	objVal = document.getElementById("ItemBrandId");
	objVal.innerHTML = "<select id='strItemBrandId' name ='strItemBrandId' class='comboHalfMax'><option value='0'>Select Value</option></select>";

	objVal = document.getElementById("SubGroupNameDiv");
	objVal.innerHTML = "<select name ='strSubGroupCode' class='comboMax'   onChange = 'ajaxItemBrandName();' ><option value='0'>All</option></select>";

	var url = "TransferOrderDetailTransCNT.cnt?hmode=subGrpNameCmbDtl&GroupId="
			+ document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value
			+ "&storeId="
			+ document.forms[0].strTransferingStoreId[document.forms[0].strTransferingStoreId.selectedIndex].value;

	ajaxFunction(url, "4");
}

function ajaxItemBrandName() {
	var url = "TransferOrderDetailTransCNT.cnt?hmode=itemBrandNameDtl&storeId="
			+ document.forms[0].strTransferingStoreId[document.forms[0].strTransferingStoreId.selectedIndex].value
			+ "&strSubGroupId="
			+ document.forms[0].strSubGroupCode.value
			+ "&strGroupId="
			+ document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value;

	ajaxFunction(url, "5");
}

function getUnitName() {
	if (document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value != '0') {
		document.getElementById("DrugNameId").innerHTML = document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].text;

		document.getElementById("avlaibleQtyName").style.display = "block";

		document.getElementById("avlaibleQtyId").innerHTML = ""
				+ document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value
						.split("^")[2];

		document.getElementById("DrugNameId").innerHTML = document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].text;
		var url = "TransferOrderDetailTransCNT.cnt?hmode=getBatchDetails&storeId="
				+ document.forms[0].strTransferingStoreId[document.forms[0].strTransferingStoreId.selectedIndex].value
				+ "&strGroupId="
				+ document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value
				+ "&strItemBrandId="
				+ document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value;

		ajaxFunction(url, "6");

	} else {
		document.getElementById("DrugNameId").innerHTML = "";
		document.getElementById("avlaibleQtyName").style.display = "none";
		document.getElementById("avlaibleQtyId").innerHTML = "";

		objVal = document.getElementById("batchDtl");
		objVal.innerHTML = "";
		alert("No Detail(s) Available!!");
		return false;

	}

}

function ClearPage() {
	document.forms[0].reset();

	document.getElementById("transferingDtlsDivId").innerHTML = "";
	document.getElementById("transferingDtlsDivId").style.display = "none";

}

function validate_orderGenerate() {

	
	var rStoreId = document.forms[0].strRequestingStoreId[document.forms[0].strRequestingStoreId.selectedIndex].value;

	if (rStoreId == 0) {
		 
		alert("Please Select Requesting Store");
		document.forms[0].strRequestingStoreId.focus();
		return;
	}
	
	
	var rStoreId = document.forms[0].strTransferingStoreId[document.forms[0].strTransferingStoreId.selectedIndex].value;

	if (rStoreId == 0) {

		alert("Please Select Transfering Store");
		document.forms[0].strTransferingStoreId.focus();
		return;
	}
	 

	var strHidden = document.getElementsByName("strHiddenValue");

	if (strHidden.length <= 0) {

		alert("Add Atleast One Drug ");
		return;

	}

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

}

function validate_orderModify() {

	var hisValidator = new HISValidator("TransferOrderDetailTransBean");
	hisValidator.addValidation("strTotalOrderQty", "numgt=0",
			"Total Ordered Qty. should be Greater than 0.");
	hisValidator.addValidation("strTotalOrderQty", "numltet="
			+ document.forms[0].strBalQty.value,
			"Total Ordered Qty. cannot be Greater than Demanding Store Bal. Qty. "
					+ document.forms[0].strBalQty.value);

	var retVal = hisValidator.validate();

	hisValidator.clearAllValidations();
	if (retVal) {
		var conf = confirm("You Are Going To Save!!!");
		if (conf == true) {
			document.forms[0].hmode.value = "ORDER_MODIFY_INSERT";
			document.forms[0].submit();

		} else {
			return false;
		}
	} else {
		return false;
	}

}
