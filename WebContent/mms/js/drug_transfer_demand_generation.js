function checkDuplicateRequest(){
	if(document.forms[0].strStoreId.value !="" && document.forms[0].strItemBrandId.value !="0"){
		var storeId = document.forms[0].strStoreId.value; 
		var itemBrandId = document.forms[0].strItemBrandId.value.split("^")[0];
		var url = "TransferDemandReqTransCNT.cnt?hmode=checkDuplicateRequest"
			+ "&storeId="+ storeId + "&itemBrandId=" + itemBrandId;
		ajaxFunction(url, "1");
	}else{
		alert("Please Select Item");
		return false;
	}	
}

var count = 0;
function toCart() {
	var itemName = $("#strItemBrandId option:selected").text();
	var cartItemId = document.forms[0].strItemBrandId.value;
	var cartAvlQty = document.forms[0].strItemBrandId.value.split("^")[2];
	var cartIndentQty = document.forms[0].strDemandedQty.value;

	cartItemId += "^" + cartIndentQty;
	var len = document.getElementsByName("strHiddenValue").length;
	if (document.forms[0].strItemBrandId.value == "0") {
		alert("Please Select Item");
		return false;
	} else if (document.forms[0].strDemandedQty.value == ""
			|| parseInt(document.forms[0].strDemandedQty.value, 10) == 0) {
		alert("Demanded Quantity cannot be blank or zero!!");
		return false;
	} else if (len == 1) {
		if (document.getElementsByName("strHiddenValue")[0].value.split("^")[0] == cartItemId.split("^")[0]) {
			alert("This Item already exits");
			return false;
		}
	}

	else {

		for ( var i = 0; i < len; i++) {
			if (document.getElementsByName("strHiddenValue")[i].value.split("^")[0] == cartItemId.split("^")[0]) {
				alert("This Item already exits");
				return false;
			}
		}
	}
	var htmlVal = "<tr id=remId" + count + " ><td style='width:40%;' >"+ itemName + "</td>";
	htmlVal += "<td style='width: 20%;text-align:right;' >" + cartAvlQty+ "</td>";
	htmlVal += "<td style='width: 20%;text-align:right;' >" + cartIndentQty+ "</td>";
	htmlVal += "<td style='width: 20%;text-align:center;' ><img src='../../hisglobal/images/trash.gif' name="+ count + " onclick='removeCart(this);' ></td>";
	htmlVal += "<input type='hidden' name='strHiddenValue' value='" + cartItemId+ "'></tr>";

	if ($('#tbl-content').height() > 80)
		$("#headerTableTrans th:last").attr("id", "right-border");

	$('#tbl-content').append(htmlVal);

	count++;
	document.getElementById("strSearchDrug").value="";
	document.getElementById("strDemandedQty").value="";
	document.forms[0].strItemBrandId.value = "0";
	document.getElementById("DrugNameId").innerHTML="";
	document.getElementById("avlaibleQtyId").innerHTML="";
	document.getElementById("strSearchDrug").focus();
	
}
function removeCart(obj) {
	$('#remId' + obj.name).remove();
	if ($('#tbl-content').height() < 100)
		$("#headerTableTrans th:last").attr("id", "");
}

function GetIndex(index, endVal) // Pagenation One
{

	for ( var page = 1; page <= endVal; page++) // For Loop To Put Normal CSS in
												// All No
	{
		document.getElementById('pg' + page).className = 'pg-normal';
	}
	var oldPageAnchor = document.getElementById('pg' + index); // Apply CSS
	oldPageAnchor.className = 'pg-selected';

	for ( var i = 1; i <= endVal; i++) {
		document.getElementById("DivId" + i).style.display = "none";
	}
	document.getElementById("DivId" + index).style.display = "table-row-group";

}
function GetIndex1(index, endVal) // Pagenation One
{

	for ( var page = 1; page <= endVal; page++) // For Loop To Put Normal CSS in
												// All No
	{
		document.getElementById('pg1' + page).className = 'pg-normal';
	}
	var oldPageAnchor = document.getElementById('pg1' + index); // Apply CSS
	oldPageAnchor.className = 'pg-selected';

	for ( var i = 1; i <= endVal; i++) {
		document.getElementById("DivId1" + i).style.display = "none";
	}
	document.getElementById("DivId1" + index).style.display = "table-row-group";

}

function disOldDatePrint(_these, index) {
	getTransferDetails(index, '2');
}

function disOldDate(_these, index) {
	document.getElementById("divTransferDetailsId").style.display = "block";
	getTransferDetails(index, "1");
}

function getTransferDetails(index, printFlag) 
{
	var url = "TransferDemandReqTransCNT.cnt?hmode=transferDtl"
			+ "&strHiddenValue="
			+ document.getElementById("strHiddenValue" + index).value
			+ "&printFlag=" + printFlag;
    //alert(url);
	if (printFlag == '1')
		ajaxFunction(url, "12");
	else
		ajaxFunction(url, "15");

}

function drugDtl(obj, index, mode) {
	if (document.getElementById("strTransferNo" + index).value != '0') {
		var url = "TransferDemandReqTransCNT.cnt?hmode=transferItemDtl"
				+ "&strTransferNo="
				+ document.getElementById("strTransferNo" + index).value + "^"
				+ index + "^"
				+ document.getElementById("strTransferStoreId" + index).value
				+ "&mode=" + mode;
		if (mode == '2')
			ajaxFunction(url, "16");
		else
			ajaxFunction(url, "13");
	} else {
		alert("No Detail(s) Available!!");
		return false;
	}
}

function hideDrugDetails(divId, index) {
	hide_popup_menu(divId + "" + index);
}

function getAjaxResponse(res, mode) {
	var objVal;
	
	if (mode == "1") {
		if(parseInt(res, 10) > 0){
			alert("Sortage Request for this item already exist.");
			return false;
		}else{
			toCart();
		}
	}
	
	if (mode == "2") {
		objVal = document.getElementById("ItemBrandId");
		objVal.innerHTML = "<select id='strItemBrandId' name ='strItemBrandId' class='comboHalfMax' onChange='getUnitName();'>"
				+ res + "</select>";
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

	}
	if (mode == '9') {
		document.getElementById("normalMsg").innerHTML = "";
		objVal = document.getElementById("SubGroupNameDiv");
		objVal.innerHTML = "<select name ='strSubGroupCode' class='comboMax'   onChange = 'ajaxItemBrandName();' >"
				+ res + "</select>";
		ajaxItemBrandName();
	}
	if (mode == '12') {
		document.getElementById("normalMsg").innerHTML = "";
		objVal = document.getElementById("divTransferDetails");
		objVal.innerHTML = res;
	}
	if (mode == '13') {
		document.getElementById("normalMsg").innerHTML = "";
		var divObj = document.getElementById("drugDtlId" + res.split("^")[1]);
		divObj.style.display = "block";
		divObj.innerHTML = res.split("^")[0];
		display_popup_menu(divObj, divObj, '250', '250');
	}

	if (mode == '16') {
		document.getElementById("normalMsg").innerHTML = "";
		var divObj = document.getElementById("drugDtlPrintId"
				+ res.split("^")[1]);
		divObj.style.display = "block";
		divObj.innerHTML = res.split("^")[0];
		display_popup_menu(divObj, divObj, '250', '250');
	}

	if (mode == '14') {
		document.getElementById("normalMsg").innerHTML = "";
		objVal = document.getElementById("transferPrintDtlsDivId");
		objVal.innerHTML = res;
		popup('popUpDiv4', '100', '80');
	}

	if (mode == '15') {
		document.getElementById("normalMsg").innerHTML = "";
		document.getElementById("transferPrintDtlsDivIdTwo").innerHTML == "";
		document.getElementById("transferPrintDtlsDivIdTwo").style.display = "block";
		document.getElementById("transferPrintDtlsDivIdTwo").innerHTML = res;

	}
}

function showDiv(strDivId) {
	document.getElementById(strDivId).style.display = "block";
}

function hideDiv(strDivId) {
	document.getElementById(strDivId).style.display = "none";
}

function ClearPage() {
	document.forms[0].reset();
	document.getElementById("DrugNameId").innerHTML = "";
	document.getElementById("unitNameId").innerHTML = "";
	document.getElementById("avlaibleQtyId").innerHTML = "";
	document.getElementById("errMsg").innerHTML = "";
	document.getElementById("warningMsg").innerHTML = "";
	document.getElementById("normalMsg").innerHTML = "";
}

function validateUpdate() {
	var hisValidator = new HISValidator("transferDemandReqTrans");
	
	hisValidator.addValidation("strReqDate", "dtltet="+document.forms[0].strCtDate.value,"Requested  Date should be Less than or equal to Current Date");
	hisValidator.addValidation("strDemandedQty", "req", "Demanded Quantity.  is a Mandatory Field");
	hisValidator.addValidation("strDemandedQty", "numgt=0", "Demanded Quantity  Must be greater than Zero");
	hisValidator.addValidation("strReqStatus", "dontselect=0", "Please Select a Status");
	hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	
	if(document.forms[0].strOnlineAppStatus.value == "0"){
		hisValidator.addValidation("strApprovedDate", "req","Approval Date is a Mandatory Field");
		hisValidator.addValidation("strApprovedDate", "dtltet="+document.forms[0].strReqDate.value,"Approval Date should be Less Than or Equal To Requested  Date");
		hisValidator.addValidation("strApprovedById", "dontselect=0","Approved By is a Mandatory Field");
		if(document.forms[0].strApprovedById.value=='1')
		{
			hisValidator.addValidation("strApprovedBy", "req","Name of the Approving Authority is a Mandatory Field");
		}	 				  	
	}
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	if (retVal) {
		var conf = confirm("You Are Going To Modify!!!");
		if (conf == true) {
			var conf1 = confirm("Are you sure !!!");
			if (conf1 == true) {
				document.forms[0].hmode.value = "updateRecord";
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

function validateSave() {

	var hisValidator = new HISValidator("transferDemandReqTrans");
	
	hisValidator.addValidation("strReqDate", "dtltet="+document.forms[0].strCtDate.value,"Requested  Date should be Less than or equal to Current Date");	
	hisValidator.addValidation("strReqStatus", "dontselect=0", "Please Select a Status");
	hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	
	if(document.forms[0].strOnlineAppStatus.value == "0"){
		hisValidator.addValidation("strApprovedById", "dontselect=0","Approved By is a Mandatory Field");
		if(document.forms[0].strApprovedById.value=='1')
		{
			hisValidator.addValidation("strApprovedBy", "req","Name of the Approving Authority is a Mandatory Field");
		}	 
		hisValidator.addValidation("strApprovedDate", "req","Approval Date is a Mandatory Field");
		hisValidator.addValidation("strApprovedDate", "dtltet="+document.forms[0].strReqDate.value,"Approval Date should be Less Than or Equal To Requested  Date");
		//alert(document.forms[0].strReqDate.value);
	}
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	if (retVal) {
		if( document.getElementsByName("strHiddenValue").length > 0 ) {
			var conf = confirm("You Are Going To Save!!!");
			if (conf == true) {
				var conf1 = confirm("Are you sure !!!");
				if (conf1 == true) {
					document.forms[0].hmode.value = "insertRecord";
					document.forms[0].submit();
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			alert("Please add at least one drug to save");
			return false;
		}

	} else {
		return false;
	}
}

function cancel(mode) {
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();
}

/**
 * showView
 * 
 * @param {String}
 *            divId
 */
function showView(divId) {
	document.getElementById(divId + "PlusId").style.display = "none";
	document.getElementById(divId + "MinusId").style.display = "block";
	document.getElementById(divId).style.display = "block";
}

/**
 * hideView
 * 
 * @param {String}
 *            divId
 */
function hideView(divId) {
	document.getElementById(divId + "PlusId").style.display = "block";
	document.getElementById(divId + "MinusId").style.display = "none";
	document.getElementById(divId).style.display = "none";
}

function getSubGrpAndGenericItem() {
	document.getElementById("DrugNameId").innerHTML = "";
	document.getElementById("unitNameId").innerHTML = "";
	document.getElementById("avlaibleQtyId").innerHTML = "";
	objVal = document.getElementById("ItemBrandId");
	objVal.innerHTML = "<select id='strItemBrandId' name ='strItemBrandId' class='comboHalfMax'><option value='0'>Select Value</option></select>";

	objVal = document.getElementById("SubGroupNameDiv");
	objVal.innerHTML = "<select name ='strSubGroupCode' class='comboMax'   onChange = 'ajaxItemBrandName();' >Select Value</select>";

	var url = "TransferDemandReqTransCNT.cnt?hmode=subGrpNameCmb&GroupId="
			+ document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value
			+ "&storeId=" + document.forms[0].strStoreId.value;
	ajaxFunction(url, "9");
}

function ajaxItemBrandName() {
	var url = "TransferDemandReqTransCNT.cnt?hmode=itemBrandName&storeId="
			+ document.forms[0].strStoreId.value
			+ "&strSubGroupId="
			+ document.forms[0].strSubGroupCode.value
			+ "&strGroupId="
			+ document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value;

	ajaxFunction(url, "2");
}

function getScreenTwoPrint() {
	var url = "TransferDemandReqTransCNT.cnt?hmode=getPrintScreenTwo"
			+ "&storeId=" + document.forms[0].strStoreId.value + "&strChk="
			+ document.forms[0].strChk.value + "&strStoreName="
			+ document.forms[0].strStoreName.value+ "&strOrderView="
			+ document.forms[0].strOrderView.value;
	ajaxFunction(url, "14");
}

function getUnitName() {
	if (document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value != '0') {
		document.getElementById("DrugNameId").innerHTML = document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].text;
		document.getElementById("unitNameId").innerHTML = document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value
				.split("^")[1];
		document.getElementById("avlaibleQtyId").innerHTML = "Avl. Qty.. ="
				+ document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value
						.split("^")[2]
				+ "  "
				+ document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value
						.split("^")[1];
	} else {
		document.getElementById("DrugNameId").innerHTML = "";
		document.getElementById("unitNameId").innerHTML = "";
		document.getElementById("avlaibleQtyId").innerHTML = "";
	}
}

function closePopup(mode) {
	if (mode == '1') {
		document.getElementById("transferPrintDtlsDivId").innerHTML = "";
		hide_popup('popUpDiv4');
	}
}

function hidePopup(mode) {		
		hide_popup('popUpDiv4');	
}

function printData(mode) {
	newwin = window.open('', 'printwin',
			'left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document
			.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n');
	newwin.document.write('<script>\n');
	newwin.document.write('function chkstate(){ \n');
	newwin.document.write('window.close();\n');
	newwin.document.write('}\n');
	newwin.document.write('function print_win(){\n');
	newwin.document.write('window.print();\n');
	newwin.document.write('chkstate();\n');
	newwin.document.write('}\n');
	newwin.document.write('<\/script>\n');
	newwin.document.write('</HEAD>\n');
	newwin.document.write('<BODY onload="print_win()">\n');

	if (mode == '1') {
		newwin.document
				.write(document.getElementById('transferPrintDtlsDivId').innerHTML);
	}
	if (mode == '2') {
		newwin.document
				.write(document.getElementById('transferPrintDtlsDiv').innerHTML);
	}

	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();
}