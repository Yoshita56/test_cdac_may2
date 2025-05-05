function validate1() {

	selectListRecords("strUserName");
	var hisValidator = new HISValidator("approvingAuthorityMstBean");
	hisValidator.addValidation("strRemarks", "maxlen=100",
			"Remarks should have less than or equal to 100 Characters");
	hisValidator.addValidation("strEffectiveDate", "date",
			"Effective Date is a mandatory field");
	// hisValidator.addValidation("strUserName", "dontselect=0","Please move
	// atleast one User Name from left to right \n And select only those User
	// which are to be added from right list");

	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

	if (retVal) {
		var count = selectListRecords("strUserName");
		if (count == 0) {
			alert("Please select a User Name which is not already added");
			return false;
		}
		document.forms[0].hmode.value = "SAVE";
		document.forms[0].submit();
	} else {
		return false;
	}
}

function LeftListTransfer() {
	var ob1 = document.forms[0].strLUserName.value;
	var ob = document.getElementById("LeftUserDivId");
	shiftToRight("strLUserName", "strUserName", 1);
}

function searchInList() {
	searchInListBox("strLUserName", document.forms[0].searchVal.value);
}

function populateList(element) {

	//alert(element.getAttribute("id") + ":" + element.value);

	var strStoreId = document.forms[0].strStoreId.value;
	var strApprovingTypeId = document.forms[0].strApprovingTypeId.value;
	var strCommitteeFlag = element.value;

	var url = "ApprovingAuthorityMstBSCNT.cnt?hmode=populateList&strStoreId="
			+ strStoreId + "&strApprovingTypeId=" + strApprovingTypeId
			+ "&strCommitteeFlag=" + strCommitteeFlag;
	
	ajaxFunction(url, "1");
}

function getAjaxResponse(res, mode) {
	
	var eleErrMsgDiv = document.getElementById("errMsg");
	var arrStrResponseMessage = res.split("####");
	
	if (arrStrResponseMessage[0] == "ERROR") {
		eleErrMsgDiv.innerHTML = arrStrResponseMessage[1];
	} else {

		if (mode == "1") { // populate Left and Right List.
			var arrStrOptions = arrStrResponseMessage[1].split("^");

			var strLeftListOptions = arrStrOptions[0];
			var strRightListOptions = arrStrOptions[1];

			var eleLeftListDiv = document.getElementById("LeftUserDivId");
			var eleRightListDiv = document.getElementById("RightUserDivId");

			eleLeftListDiv.innerHTML = "<select name='strLUserName' size='8' multiple style='width: 280px'>"
					+ strLeftListOptions + "</select>";
			eleRightListDiv.innerHTML = "<select name='strUserName'  size='8' multiple style='width: 280px'>"
					+ strRightListOptions + "</select>";
		}

	}
	return;

}