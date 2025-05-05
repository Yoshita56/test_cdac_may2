/**
 * function get called when Desk's check box is clicked.
 * 
 * @param these -
 *            check box object
 */
function chkUserDefinedFunc(these) {
	var checkCount = 0;
	var check = document.getElementsByName("chk");
	for ( var i = 0; i < check.length; i++) {
		if (check[i].checked == true) {
			checkCount++;
		}
	}

	try {

		if (document.forms[0].combo[0].value == 1) { // request type = Order

			enableButton("Generate");

			if (checkCount == 1) {

				if (document.forms[0].combo[1].value == 0) {

					enableButton("Modify");
					enableButton("Cancel");

				} else {

					disableButton("Modify");
					disableButton("Cancel");

				}

				enableButton("View");

			} else {

				disableButton("Modify");
				disableButton("Cancel");
				disableButton("View");

			}
		} else if (document.forms[0].combo[0].value == 2) { // request type =
			// Transfer

			if (checkCount == 1) {

				var approvedQty = these.value.split("$")[1];

				if (document.forms[0].combo[1].value == 0 && approvedQty == 0) {

					enableButton("Reject");
					disableButton("Force_Fully_Close");

				} else {

					enableButton("Force_Fully_Close");
					disableButton("Reject");

				}

				enableButton("View");

			} else {

				disableButton("Reject");
				disableButton("Forcefully Close");
				disableButton("View");

			}

		} else { // request type = Demand

			if (checkCount == 1) {

				if (document.forms[0].combo[1].value == 0) {

					enableButton("Reject");

				} else {

					disableButton("Reject");
				}

				enableButton("View");

			} else {

				disableButton("Reject");
				disableButton("View");
			}
		}

	} catch (Err) {
		alert(Err);
		alert("Application Error! Contact system Administrator");
	}
}

/**
 * function called when button is clicked
 * 
 * @param param -
 *            key word / hmode for a particular button.
 * @returns {Boolean}
 */
function buttonClick(param) {

	if (param == "ORDER_GENERATE") {

	} else if (param == "ORDER_MODIFY") {

	} else if (param == "ORDER_CANCEL") {

		var strRemarks = prompt("Cancel Remarks", "");

		if (strRemarks == null) {

			return false;

		} else if (strRemarks != "") {

			var check = document.getElementsByName("chk");
			var strOrderNo = "";

			for ( var i = 0; i < check.length; i++) {
				if (check[i].checked == true) {
					strOrderNo = check[i].value.split("@")[0];
				}
			}

			var cnf = confirm("You are Cancelling the Order No. : "
					+ strOrderNo + " , Are you Sure");

			if (!cnf)
				return false;

			document.forms[0].comboValue.value = strRemarks;

		} else {

			alert("Remarks is a Mandaotry Field ");
			return buttonClick(param);

		}

	} else if (param == "ORDER_VIEW") {

	} else if (param == "TRANSFER_REJECT") {

		var strRemarks = prompt("Reject Remarks", "");

		if (strRemarks == null) {

			return false;

		} else if (strRemarks != "") {

			var check = document.getElementsByName("chk");
			var strRequestNo = "";

			for ( var i = 0; i < check.length; i++) {
				if (check[i].checked == true) {
					strRequestNo = check[i].value.split("@")[1];
				}
			}

			var cnf = confirm("You are Rejecting the Request No. : "
					+ strRequestNo + " , Are you Sure");

			if (!cnf)
				return false;

			document.forms[0].comboValue.value = strRemarks;

		} else {

			alert("Remarks is a Mandaotry Field ");
			return buttonClick(param);

		}

	} else if (param == "TRANSFER_FFCLOSE") {

		var strRemarks = prompt("Forcefully Close Remarks", "");

		if (strRemarks == null) {

			return false;

		} else if (strRemarks != "") {

			var check = document.getElementsByName("chk");
			var strRequestNo = "";

			for ( var i = 0; i < check.length; i++) {
				if (check[i].checked == true) {
					strRequestNo = check[i].value.split("@")[1];
				}
			}

			var cnf = confirm("You are Forcefully Closing the Request No. : "
					+ strRequestNo + " , Are you Sure");

			if (!cnf)
				return false;

			document.forms[0].comboValue.value = strRemarks;

		} else {

			alert("Remarks is a Mandaotry Field ");
			return buttonClick(param);

		}

	} else if (param == "TRANSFER_VIEW") {

	} else if (param == "DEMAND_REJECT") {

		var strRemarks = prompt("Reject Remarks", "");

		if (strRemarks == null) {

			return false;

		} else if (strRemarks != "") {

			var check = document.getElementsByName("chk");
			var strRequestNo = "";

			for ( var i = 0; i < check.length; i++) {
				if (check[i].checked == true) {
					strRequestNo = check[i].value.split("@")[1];
				}
			}

			var cnf = confirm("You are Rejecting the Request No. : "
					+ strRequestNo + " , Are you Sure");

			if (!cnf)
				return false;

			document.forms[0].comboValue.value = strRemarks;

		} else {

			alert("Remarks is a Mandaotry Field ");
			return buttonClick(param);

		}

	} else if (param == "DEMAND_VIEW") {

	} else {

		return false;
	}

	document.forms[0].hmode.value = param;
	document.forms[0].target = "_self";
	document.forms[0].submit();

}
