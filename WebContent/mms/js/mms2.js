// method to set combo value on add page AND to alert if combo is not selected before add  (by Anshul)
// ALERT MASSEGE WILL SHOW ACCORDING TO PASSING MODE
// MODE=1 FOR STORE NAME COMBO
// MODE=2 FOR SUPPLIER NAME COMBO
// MODE=3 FOR STORE TYPE NAME COMBO


function callComboAdd(form1, mode) {
	// alert("callStoreCombo func is calling");
	var cmbVal = "";
	var cmbVal2 = "";

	with (form1) {

		if (combo[0].value == "0" || combo[1].value == "0") {
			if (mode == '1'){
				//alert("Please Select Drug Warehouse Name");
				alert("Please Select Store Name");
			}

			else if (mode == '2')
				alert("Please Select Supplier Name");

			else if (mode == '3') {
				//alert("Please Select Drug Category");
				alert("Please Select Category");
			}

			else if (mode == '4' && combo[0].value == "0") {
				//alert("Please Select Drug Warehouse Name");
				alert("Please Select Store Name");
			} else if (mode == '4' && combo[1].value == "0") {
				//alert("Please Select Drug Category");
				alert("Please Select Category");
			} else if (mode == '5' && combo[0].value == "0") {
				//alert("Please Select Drug Category");
				alert("Please Select Category");
			} else if (mode == '5' && combo[1].value == "0") {
				//alert("Please Select Drug Name");
				alert("Please Select Name");
			} else if (mode == '6' && combo[0].value == "0") {
				//alert("Please Select Drug Category ");
				alert("Please Select Category ");
			} else if (mode == '6' && combo[1].value == "0") {
				alert("Please Select Group Name");
			} else if (mode == '7' && combo[0].value == "0") {
				//alert("Please Select Drug Category.");
				alert("Please Select Category.");
				document.forms[0].combo[0].focus();
				return;
			}else if (mode == '7' && combo[1].value == "0") {
				alert("Please Select Supplier Name");
				document.forms[0].combo[1].focus();
				return;
			}
			else if (mode == '8' && combo[0].value == "0") {
				alert("Please Select PO Type Name");
			} else if (mode == '8' && combo[1].value == "0") {
				//alert("Please Select Drug Category");
				alert("Please Select Category.");
			}
			/*
			 * else if(mode=='9' && combo[0].value == "0") { alert("Please
			 * Select Drug Category "); }
			 */

			else if (mode == '10' && combo[0].value == "0") {
				//alert("Please Select Drug Category Name");
				alert("Please Select Category Name");
			} else if (mode == '11' && combo[0].value == "0") {
				//alert("Please Select Drug Warehouse Name");
				alert("Please Select Store Name");
			} else if (mode == '11' && combo[1].value == "0") {
				alert("Please Select Request Type");
			}

			document.forms[0].combo[0].focus();
			return;
		} else {
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			cmbVal2 = combo[1].options[combo[1].selectedIndex].text;
			if (cmbVal2 == 'Active' || cmbVal2 == 'Inactive')
				comboValue.value = cmbVal;
			else
				comboValue.value = cmbVal + "^" + cmbVal2;
			add("ADD");

		}
	}

}
// method to set combo value on add page MODIFY to alert if combo is not
// selected before MODIFY (by Anshul)
// ALERT MASSEGE WILL SHOW ACCORDING TO PASSING MODE
// MODE=1 FOR STORE NAME COMBO
// MODE=2 FOR SUPPLIER NAME COMBO
// MODE=3 FOR STORE TYPE NAME COMBO

function callComboModify(form1, mode) {

	var cmbVal = "";
	with (form1) {

		if (combo[0].value == "0" || combo[1].value == "0") {
			if (mode == '1'){
				//alert("Please Select Drug Warehouse Name");
				alert("Please Select Store Name");
			}

			else if (mode == '2')
				alert("Please Select Supplier Name");

			else if (mode == '3') {
				//alert("Please Select Drug Warehouse Type Name");
				alert("Please Select Store Type Name");
			} else if (mode == '4' && combo[0].value == "0") {
				//alert("Please Select Drug Warehouse Name");
				alert("Please Select Store Name");
			} else if (mode == '4' && combo[1].value == "0") {
				//alert("Please Select Drug Category");
				alert("Please Select Category");
			} else if (mode == '5' && combo[0].value == "0") {
				//alert("Please Select Drug Category");
				alert("Please Select Category");
			} else if (mode == '5' && combo[1].value == "0") {
				//alert("Please Select Drug Name");
				alert("Please Select Name");
			} else if (mode == '6' && combo[0].value == "0") {
				//alert("Please Select Drug Category");
				alert("Please Select Category");
			} else if (mode == '6' && combo[1].value == "0") {
				alert("Please Select Group Name");
			} else if (mode == '7' && combo[0].value == "0") {
				alert("Please Select Supplier Name");
			}

			else if (mode == '8' && combo[0].value == "0") {
				alert("Please Select PO Type Name");
				document.forms[0].combo[0].focus();
			} else if (mode == '8' && combo[1].value == "0") {
				//alert("Please Select Drug Category");
				alert("Please Select Category");
				document.forms[0].combo[1].focus();
			} else if (mode == '9' && combo[0].value == "0") {
				//alert("Please Select Drug Category Name");
				alert("Please Select Category Name");
			} else if (mode == '9' && combo[1].value == "0") {
				alert("Please Select Request Type ");
			} else if (mode == '10' && combo[0].value == "0") {
				//alert("Please Select Drug Category Name");
				alert("Please Select Category Name");
			} else if (mode == '11' && combo[0].value == "0") {
				//alert("Please Select Drug Warehouse Name");
				alert("Please Select Store Name");
			} else if (mode == '11' && combo[1].value == "0") {
				alert("Please Select Request Type");
			}

			// document.forms[0].combo[0].focus();
			return;
		} else {
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			cmbVal2 = combo[1].options[combo[1].selectedIndex].text;
			if (cmbVal2 == 'Active' || cmbVal2 == 'Inactive')
				comboValue.value = cmbVal;
			else
				comboValue.value = cmbVal + "^" + cmbVal2;
			edit("MODIFY");
		}
	}
}

// method to copy one store Drug records into another (used in store Drug master
// by Anshul)
function callBatchUpdate(form1) {

	var cmbVal = "";
	with (form1) {

		if (combo[0].value == "0") {
			alert("Please Select Store Name");
			document.forms[0].combo[0].focus();
			return;
		} else {
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			comboValue.value = cmbVal;
			document.forms[0].hmode.value = "BATCHUPDATE";
			document.forms[0].submit();
		}
	}
}

function callMe(form1) {
	// alert("callme func is calling");
	var cmbVal = "";
	with (form1) {

		if (combo[0].value == "0") {
			alert("Please Select Store Type Name");
			return;
		} else {
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			comboValue.value = cmbVal;

			// cmbVal2 = combo[1].options[combo[1].selectedIndex].text;
			// comboValue2.value = cmbVal;

			add("ADD");

		}
	}

}

function callMe2(form1) {
	// alert("callme2 func is calling");
	var cmbVal = "";
	with (form1) {

		if (combo[0].value == "0") {
			alert("Please Select Store Type Name");
			return;
		} else {
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			comboValue.value = cmbVal;

			// cmbVal2 = combo[1].options[combo[1].selectedIndex].text;
			// comboValue2.value = cmbVal;

			edit("MODIFY");

		}
	}

}

// Used in Process Letter Type Master for Add Page.

function callMe3(form1) {
	// alert("callme3 func is calling");
	var cmbVal = "";
	// alert(document.forms[0].combo.value);
	with (form1) {

		if (combo.value == "0") {
			alert("Please Select Process Name First");
			document.forms[0].combo.focus();
			return;
		} else {
			cmbVal = combo.options[combo.selectedIndex].text;
			comboValue.value = cmbVal;

			// cmbVal2 = combo[1].options[combo[1].selectedIndex].text;
			// comboValue2.value = cmbVal;

			add("ADD");

		}
	}
}

// Used in Process Letter Type Master for Modify Page.

function callMe4(form1) {
	// alert("callme func is calling");
	var cmbVal = "";
	with (form1) {

		if (combo.value == "0") {
			alert("Please Select Process Name First");
			document.forms[0].combo.focus();
			return;
		} else {
			cmbVal = combo.options[combo.selectedIndex].text;
			comboValue.value = cmbVal;

			// cmbVal2 = combo[1].options[combo[1].selectedIndex].text;
			// comboValue2.value = cmbVal;

			edit("MODIFY");

		}
	}

}

// Used in Drug Sets Master for Add Page.

/*
 * Commented by Aritra on 22nd Dec, 2010 Reason: Change request from Ajay
 * Sir.(Generic Name should not be present in List page.)
 */
/*
 * function callMe5(form1) { // alert("callme3 func is calling"); var cmbVal =
 * ""; var cmbVal1 = ""; var cmbVal2 = ""; //
 * alert(document.forms[0].combo.value);
 * 
 * with (form1) { if (combo[0].value == "0") { alert("Please Select Set Drug
 * Category"); document.forms[0].combo[0].focus(); return; } else if
 * (combo[1].value == "0") { alert("Please Select Generic Drug Name ");
 * document.forms[0].combo[1].focus(); return; } else if (combo[2].value == "0") {
 * alert("Please Select Set Name "); document.forms[0].combo[2].focus(); return; }
 * else { cmbVal = combo[0].options[combo[0].selectedIndex].text; cmbVal1 =
 * combo[1].options[combo[1].selectedIndex].text; cmbVal2 =
 * combo[2].options[combo[2].selectedIndex].text; comboValue.value = cmbVal +
 * "^" + cmbVal1 + "^" + cmbVal2;
 *  // cmbVal2 = combo[1].options[combo[1].selectedIndex].text; //
 * comboValue2.value = cmbVal;
 * 
 * add("ADD");
 *  } } }
 */
// Used in Drug Sets Master for Add Page.
function callMe5(form1) {
	// alert("callme3 func is calling");
	var cmbVal = "";
	var cmbVal1 = "";
	var cmbVal2 = "";
	// alert(document.forms[0].combo.value);

	with (form1) {
		if (combo[0].value == "0") {
			alert("Please Select Set Item Category");
			document.forms[0].combo[0].focus();
			return;
		} else if (combo[1].value == "0") {
			alert("Please Select Set Name.");
			document.forms[0].combo[1].focus();
			return;
		} /*
			 * else if (combo[2].value == "0") { alert("Please Select Set Name
			 * "); document.forms[0].combo[2].focus(); return; }
			 */else {
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			cmbVal1 = combo[1].options[combo[1].selectedIndex].text;
			// cmbVal2 = combo[2].options[combo[2].selectedIndex].text;
			comboValue.value = cmbVal + "^" + cmbVal1 + "^" + cmbVal2;

			// cmbVal2 = combo[1].options[combo[1].selectedIndex].text;
			// comboValue2.value = cmbVal;

			add("ADD");

		}
	}
}

/*
 * Commented by Aritra on 23 Dec, 2010 Reason: Change Request from Ajay Gupta
 * (Generic Name should not be present in List page.)
 */

/*
 * // Used in Drug Sets Master for Modify Page.
 * 
 * function callMe6(form1) { // alert("callme func is calling"); var cmbVal =
 * ""; var cmbVal1 = ""; var cmbVal2 = ""; with (form1) {
 * 
 * if (combo[0].value == "0") { alert("Please Select Drug Category Name First");
 * document.forms[0].combo[0].focus(); return; } else if (combo[1].value == "0") {
 * alert("Please Select Generic Drug Name"); document.forms[0].combo[1].focus();
 * return; } else if (combo[2].value == "0") { alert("Please Select Set Name ");
 * document.forms[0].combo[2].focus(); return; } else { cmbVal =
 * combo[0].options[combo[0].selectedIndex].text; cmbVal1 =
 * combo[1].options[combo[1].selectedIndex].text; cmbVal2 =
 * combo[2].options[combo[2].selectedIndex].text; comboValue.value = cmbVal +
 * "^" + cmbVal1 + "^" + cmbVal2;
 *  // cmbVal2 = combo[1].options[combo[1].selectedIndex].text; //
 * comboValue2.value = cmbVal;
 * 
 * edit("MODIFY");
 *  } }
 *  }
 */

// Used in Drug Sets Master for Modify Page.
function callMe6(form1) {
	// alert("callme func is calling");
	var cmbVal = "";
	var cmbVal1 = "";
	var cmbVal2 = "";
	with (form1) {

		if (combo[0].value == "0") {
			alert("Please Select Item Category Name First");
			document.forms[0].combo[0].focus();
			return;
		} else if (combo[1].value == "0") {
			alert("Please Select Set Name");
			document.forms[0].combo[1].focus();
			return;
		} /*
			 * else if (combo[2].value == "0") { alert("Please Select Set Name
			 * "); document.forms[0].combo[2].focus(); return; }
			 */else {
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			cmbVal1 = combo[1].options[combo[1].selectedIndex].text;
			// cmbVal2 = combo[2].options[combo[2].selectedIndex].text;
			comboValue.value = cmbVal + "^" + cmbVal1 + "^" + cmbVal2;

			// cmbVal2 = combo[1].options[combo[1].selectedIndex].text;
			// comboValue2.value = cmbVal;

			edit("MODIFY");

		}
	}

}

/**
 * called ON DELETE IN Drug PARAMETER MASTER TO SHOW AN ALERT MSG IF PARAMETER
 * IS PARENT
 */
function isParentDelete(form1) {
	with (form1) {
		if(form1.chk==null) {
			alert('No Record to Delete.');
			return;
		}
		var dataCheckFlag=false;
		for (i = 0; i < form1.chk.length; i++) {
			if (form1.chk[i].checked == true) {
				dataCheckFlag=true;
				var isParent = form1.chk[i].value.split("$");

				if (isParent[1] == '0') {

					var con = confirm("Selected Parameter is parent, so all its \n "
							+ "child parameter will also be deleted \n"
							+ "ARE YOU SURE YOU WANT TO DELETE THIS PARAMETER ?");
					if (con == true) {
						deleteRecords1("DELETE");
					} else {
						return false;
					}
				} else {
					// alert("else");
					deleteRecords("DELETE");
				}
			}

		}
		if(dataCheckFlag==false) {
			alert("No record selected to delete.");
		}
	}
}

/*
 * this function called when delete button is pressed in ITEM PARAMETER master.
 * it will not show alert msg since it is already displayed
 * 
 * 
 */
function deleteRecords1() {
	var combo1;
	var prevNext = null;
	var totalChk = 0;
	var primarykey = "";
	var search = "";
	var str = "";
	var str = "";

	var mode = "DELETE";
	var len = document.forms[0].chk.length;
	var no_of_combo = document.forms[0].no_of_combo.value;

	if (document.forms[0].combo != null)
		combo1 = document.forms[0].combo;

	// call in this file
	if (checkForDelete() == false)
		return;

	var divisionId = document.forms[0].divisionId.value;
	var rec_per_page = document.forms[0].record_per_page.value;
	var prevDivIndex = divisionId.substring(1, divisionId.length);
	var min_rec_len = parseInt(rec_per_page) * (parseInt(prevDivIndex) - 1);
	var max_rec_len = parseInt(rec_per_page) * parseInt(prevDivIndex);

	if (!isNaN(document.forms[0].chk.length)) {
		for ( var i = min_rec_len; i < max_rec_len
				&& i < document.forms[0].chk.length; i++) {
			if (document.forms[0].chk[i].checked == true) {
				totalChk += 1;
				primarykey += document.forms[0].chk[i].value;
				primarykey += "@"; // concatenating all chk value with @
				// symbols to a single variable to for easy
				// manipulations like deleting the records
				// and update
			}
		}
	} else
		primarykey = document.forms[0].chk.value;

	// var retValue=confirm("Are You Sure Want To Delete Record(s)");
	// if(retValue==false) return;

	if (prevNext == null)
		prevNext = '1';

	if (no_of_combo > 1) {
		for (i = 0; i < combo1.length; i++)
			str += "&combo=" + combo1[i].value;
	} else if (no_of_combo == 1)
		str += "&combo=" + combo1.value;

	var minrow = document.forms[0].minrow.value;
	var max_rownum = document.forms[0].max_rownum.value;
	var blockNo = document.forms[0].blockNo.value;
	var divisionId = document.forms[0].divisionId.value;
	var search = "";
	var searchColumn = null;
	var rowNum = minrow;
	var params = "ItemParameterMstCNT.cnt?hmode=" + mode + str + "&divisionId="
			+ divisionId + "&chk=" + primarykey + "&prevNext" + prevNext
			+ "&rowNum=0&minrow=" + minrow + "&blockNo=" + blockNo
			+ "&max_rownum=" + max_rownum + "&search=" + search
			+ "&searchColumn=" + searchColumn;

	xmlHttp.open("GET", params, true);
	document.getElementById("message").style.display = 'block';
	document.getElementById('start').innerHTML = '<table align=center bgcolor="RED"><tr><td> <FONT size=3 color=\"white\">Wait Deleting Records...</FONT></td></tr></table>';

	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200 || xmlHttp.status == 'complete') {
				var response = xmlHttp.responseText;

				var responseData = new Array();
				responseData = response.split("####");
				document.getElementById('message').innerHTML = responseData[6];
				document.forms[0].record_per_page.value = responseData[0];
				document.forms[0].no_of_combo.value = responseData[1];
				document.forms[0].actual_page_block.value = responseData[2];
				document.forms[0].totalpage.value = responseData[3];
				document.forms[0].divisionId.value = responseData[7];
				document.getElementById("start").innerHTML = responseData[4];
				document.getElementById("searchid").innerHTML = responseData[5];
				document.getElementById("footer").style.display = 'block';
				document.getElementById("a1").style.display = 'none';

				var curr_block = responseData[7];

				if (document.getElementById("bb" + curr_block) != null) {
					document.getElementById(curr_block).style.display = 'block';
					document.forms[0].divisionId.value = curr_block;
					changeDiv(curr_block);
					document.forms[0].divisionId.value = curr_block;
					document.getElementById("bb" + curr_block).style.color = 'red';
				} else if (document.getElementById("bba1") != null) {
					document.getElementById("a1").style.display = 'block';
					document.forms[0].divisionId.value = "a1";
					document.getElementById("bba1").style.color = 'red';
				}

			}
		}
	};

	xmlHttp.send(params);
}

function addSupplierMst() {
	if (document.forms[0].combo[0].value == "0") {
		alert("Please Select Item Category Name");
		document.forms[0].combo[0].focus();
	} else {
		document.forms[0].hmode.value = "ADD";
		document.forms[0].submit();
	}
}

function modifySupplierMst() {
	if (document.forms[0].combo[0].value == "0") {
		alert("Please Select Drug Category Name");
		document.forms[0].combo[0].focus();
	} else {
		document.forms[0].hmode.value = "MODIFY";
		document.forms[0].submit();
	}
}

function supplierView() {

	document.getElementById('message').style.display = 'none';
	if (checkForView() == false)
		return false;
	var chk_temp = document.forms[0].chk.length;
	var temp_cnt = document.forms[0].cnt_page.value;
	var temp1 = temp_cnt.split(".");
	var cnt_page = temp1[0];
	var chk = "";

	var mode = "VIEW";

	if (!isNaN(chk_temp)) {
		for ( var i = 0; i < chk_temp; i++) {
			if (document.forms[0].chk[i].checked == true)
				chk = document.forms[0].chk[i].value;
		}
	} else
		chk = document.forms[0].chk.value;

	// var widthvalue=document.forms[0].view_row_length.value * 60;
	// var heg_width="width=700,height="+widthvalue;
	// var heg_width="width=700,height=350,left=200,top=200";
	// var myPopup =
	// window.open("CNTWardMst.cnt?hmode="+mode+"&chk="+chk,'popupWindow',heg_width);

	var heg_width = "width=500,height=500,left=200,top=200";

	var myPopup = window.open(createFHashAjaxQuery("SupplierMstCNT.cnt?hmode=" + mode + "&chk="+ chk), 'popupWindow', heg_width);// +"&cnt_page="+cnt_page+"&masterName="+document.forms[0].masterName.value,'popupWindow',heg_width,
	// 'scrollbars=yes,ALIGN=CENETER,left=100,top=100');

}

function addDrugMst() 
{
	var cmbVal = "";
	
	if (document.forms[0].combo[0].value == "0") 
	{
		alert("Please Select Group Name");
		document.forms[0].combo[0].focus();
		return;
	} 
	else 
	{
		if (document.forms[0].combo[1].value == "0") 
			cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text+"^"+"----";
		else
			cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text+"^"+document.forms[0].combo[1].options[document.forms[0].combo[1].selectedIndex].text;
		document.forms[0].comboValue.value = cmbVal;
		document.forms[0].hmode.value = "ADD";
		document.forms[0].submit();
	}

}
function addItemMst() {
	var cmbVal = "";

	if (document.forms[0].combo[0].value == "0") {
		alert("Please Select Drug Category");
		document.forms[0].combo[0].focus();
		return;
	} else if (document.forms[0].combo[1].value == "0") {
		alert("Please Select Group Name");
		document.forms[0].combo[1].focus();
		return;
	} else {
		cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
		cmbVal1 = document.forms[0].combo[1].options[document.forms[0].combo[1].selectedIndex].text;
		var cmbVal2 = document.forms[0].combo[2].options[document.forms[0].combo[2].selectedIndex].text;

		if (document.forms[0].combo[2].value == "0") {
			// cmbVal2=" ";
			document.forms[0].comboValue.value = cmbVal + "^" + cmbVal1;
		} else {
			document.forms[0].comboValue.value = cmbVal + "^" + cmbVal1 + "^"
					+ cmbVal2;
		}

		document.forms[0].hmode.value = "ADD";
		document.forms[0].submit();
	}

}

function ModifyItemMst() {
	var cmbVal = "";
	if (document.forms[0].combo[0].value == "0") {
		alert("Please Select Drug Category");
		document.forms[0].combo[0].focus();
		return;
	} else if (document.forms[0].combo[1].value == "0") {
		alert("Please Select Group Name");
		document.forms[0].combo[1].focus();
		return;
	} else {
		var j = 0;
		if (typeof document.forms[0].chk.length != "undefined") {
			for ( var i = 0; i < document.forms[0].chk.length; i++)
				if (document.forms[0].chk[i].checked)
					j++;
		} else if (document.forms[0].chk.checked)
			j++;

		if (j == 0)
			alert("Please Select an Drug");
		if (j == 1) {
			cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
			cmbVal1 = document.forms[0].combo[1].options[document.forms[0].combo[1].selectedIndex].text;
			var cmbVal2 = document.forms[0].combo[2].options[document.forms[0].combo[2].selectedIndex].text;
			if (document.forms[0].combo[1].value == "0") {
				// cmbVal2=" ";
				document.forms[0].comboValue.value = cmbVal + "^" + cmbVal1;
			} else {
				document.forms[0].comboValue.value = cmbVal + "^" + cmbVal1
						+ "^" + cmbVal2;
			}
			document.forms[0].hmode.value = "MODIFY";
			document.forms[0].submit();
		} else if (j > 1)
			alert("Please Select Only One Drug");
	}
}

function ModifyDrugMst() {
	var cmbVal = "";
	if (document.forms[0].combo[0].value == "0") {
		alert("Please Select Group Name");
		document.forms[0].combo[0].focus();
		return;
	} else {
		var j = 0;
		if (typeof document.forms[0].chk.length != "undefined") {
			for ( var i = 0; i < document.forms[0].chk.length; i++)
				if (document.forms[0].chk[i].checked)
					j++;
		} else if (document.forms[0].chk.checked)
			j++;

		if (j == 0)
			alert("Please Select an Drug");
		if (j == 1) {
			cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
			var cmbVal2 = document.forms[0].combo[1].options[document.forms[0].combo[1].selectedIndex].text;
			if (document.forms[0].combo[1].value == "0") {
				// cmbVal2=" ";
				document.forms[0].comboValue.value = cmbVal;
			} else {
				document.forms[0].comboValue.value = cmbVal + "^" + cmbVal2;
			}
			document.forms[0].hmode.value = "MODIFY";
			document.forms[0].submit();
		} else if (j > 1)
			alert("Please Select Only One Drug");
	}
}

// used in drug mst

function drugView() {
	document.getElementById('message').style.display = 'none';
	if (checkForView() == false)
		return false;
	var chk_temp = document.forms[0].chk.length;
	var temp_cnt = document.forms[0].cnt_page.value;
	var temp1 = temp_cnt.split(".");
	var cnt_page = temp1[0];
	var chk = "";

	var mode = "VIEW";

	if (!isNaN(chk_temp)) {
		for ( var i = 0; i < chk_temp; i++) {
			if (document.forms[0].chk[i].checked == true)
				chk = document.forms[0].chk[i].value;
		}
	} else
		chk = document.forms[0].chk.value;

	// var widthvalue=document.forms[0].view_row_length.value * 60;
	// var heg_width="width=700,height="+widthvalue;
	// var heg_width="width=700,height=350,left=200,top=200";
	// var myPopup =
	// window.open("CNTWardMst.cnt?hmode="+mode+"&chk="+chk,'popupWindow',heg_width);

	var heg_width = "width=700,height=400,left=200,top=200";

	var cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
	// alert(cmbVal);
	var cmbVal2 = document.forms[0].combo[1].options[document.forms[0].combo[1].selectedIndex].text;

	// var cmbVal3 =
	// document.forms[0].combo[2].options[document.forms[0].combo[2].selectedIndex].text;
	var cmbVal3 = "";
	var comboValue = cmbVal + "^" + cmbVal2 + "^" + cmbVal3;
	var myPopup = window.open(createFHashAjaxQuery("DrugMstCNT.cnt?hmode=" + mode + "&chk=" + chk
			+ "&comboValue=" + comboValue + "&cmbVal1=" + cmbVal + "&cmbVal2="
			+ cmbVal2), 'popupWindow', heg_width);// +"&cnt_page="+cnt_page+"&masterName="+document.forms[0].masterName.value,'popupWindow',heg_width,
	// 'scrollbars=yes,ALIGN=CENETER,left=100,top=100');

}

// used in Generic drug mst
function genericDrugView() {
	document.getElementById('message').style.display = 'none';
	if (checkForView() == false)
		return false;
	var chk_temp = document.forms[0].chk.length;
	var temp_cnt = document.forms[0].cnt_page.value;
	var temp1 = temp_cnt.split(".");
	var cnt_page = temp1[0];
	var chk = "";

	var mode = "VIEW";

	if (!isNaN(chk_temp)) {
		for ( var i = 0; i < chk_temp; i++) {
			if (document.forms[0].chk[i].checked == true)
				chk = document.forms[0].chk[i].value;
		}
	} else
		chk = document.forms[0].chk.value;

	// var widthvalue=document.forms[0].view_row_length.value * 60;
	// var heg_width="width=700,height="+widthvalue;
	// var heg_width="width=700,height=350,left=200,top=200";
	// var myPopup =
	// window.open("CNTWardMst.cnt?hmode="+mode+"&chk="+chk,'popupWindow',heg_width);

	var heg_width = "width=700,height=400,left=200,top=200";
	var cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
	var cmbVal2 = document.forms[0].combo[1].options[document.forms[0].combo[1].selectedIndex].text;

	var myPopup = window.open("GenericDrugMstCNT.cnt?hmode=" + mode + "&chk="
			+ chk + "&cmbVal1=" + cmbVal + "&cmbVal2=" + cmbVal2,
			'popupWindow', heg_width);// +"&cnt_page="+cnt_page+"&masterName="+document.forms[0].masterName.value,'popupWindow',heg_width,
	// 'scrollbars=yes,ALIGN=CENETER,left=100,top=100');

}

//used in CIMS Generic drug mst
function cimsgenericDrugView() {
	document.getElementById('message').style.display = 'none';
	if (checkForView() == false)
		return false;
	var chk_temp = document.forms[0].chk.length;
	var temp_cnt = document.forms[0].cnt_page.value;
	var temp1 = temp_cnt.split(".");
	var cnt_page = temp1[0];
	var chk = "";

	var mode = "VIEW";

	if (!isNaN(chk_temp)) {
		for ( var i = 0; i < chk_temp; i++) {
			if (document.forms[0].chk[i].checked == true)
				chk = document.forms[0].chk[i].value;
		}
	} else
		chk = document.forms[0].chk.value;

	// var widthvalue=document.forms[0].view_row_length.value * 60;
	// var heg_width="width=700,height="+widthvalue;
	// var heg_width="width=700,height=350,left=200,top=200";
	// var myPopup =
	// window.open("CNTWardMst.cnt?hmode="+mode+"&chk="+chk,'popupWindow',heg_width);

	var heg_width = "width=700,height=400,left=200,top=200";
	var cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
	var cmbVal2 = document.forms[0].combo[1].options[document.forms[0].combo[1].selectedIndex].text;

	var myPopup = window.open("CIMSGenericDrugMstCNT.cnt?hmode=" + mode + "&chk="
			+ chk + "&cmbVal1=" + cmbVal + "&cmbVal2=" + cmbVal2,
			'popupWindow', heg_width);// +"&cnt_page="+cnt_page+"&masterName="+document.forms[0].masterName.value,'popupWindow',heg_width,
	// 'scrollbars=yes,ALIGN=CENETER,left=100,top=100');

}
// used in Generic item mst

function genericItemView() {
	document.getElementById('message').style.display = 'none';
	if (checkForView() == false)
		return false;
	var chk_temp = document.forms[0].chk.length;
	var temp_cnt = document.forms[0].cnt_page.value;
	var temp1 = temp_cnt.split(".");
	var cnt_page = temp1[0];
	var chk = "";

	var mode = "VIEW";

	if (!isNaN(chk_temp)) {
		for ( var i = 0; i < chk_temp; i++) {
			if (document.forms[0].chk[i].checked == true)
				chk = document.forms[0].chk[i].value;
		}
	} else
		chk = document.forms[0].chk.value;

	// var widthvalue=document.forms[0].view_row_length.value * 60;
	// var heg_width="width=700,height="+widthvalue;
	// var heg_width="width=700,height=350,left=200,top=200";
	// var myPopup =
	// window.open("CNTWardMst.cnt?hmode="+mode+"&chk="+chk,'popupWindow',heg_width);

	var heg_width = "width=700,height=450,left=200,top=200";
	var cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
	var cmbVal2 = document.forms[0].combo[1].options[document.forms[0].combo[1].selectedIndex].text;

	var myPopup = window.open("GenericItemMstCNT.cnt?hmode=" + mode + "&chk="
			+ chk + "&cmbVal1=" + cmbVal + "&cmbVal2=" + cmbVal2,
			'popupWindow', heg_width);// +"&cnt_page="+cnt_page+"&masterName="+document.forms[0].masterName.value,'popupWindow',heg_width,
	// 'scrollbars=yes,ALIGN=CENETER,left=100,top=100');

}

// ///////////////function to display view page of drug safety alert master

function showView(form1) {

	var chkObj = document.getElementsByName("chk");

	var len = chkObj.length;

	var countChk = 0;

	for ( var i = 0; i < len; i++)
		if (chkObj[i].checked)
			countChk = countChk + 1;

	if (countChk != 1) {
		alert("Please Select One Record");
		return false;
	}

	for ( var i = 0; i < len; i++) {

		if (chkObj[i].checked) {
			url = 'DrugSafetyAlertMstCNT.cnt?hmode=viewPage' + '&chk='
					+ chkObj[i].value;
			window.open(url, "popupWindow",
					"width=610,height=450,scrollbars=yes");
		}
	}

}

function showViewDrugDose(form1) {

	var chkObj = document.getElementsByName("chk");

	var len = chkObj.length;

	var countChk = 0;

	for ( var i = 0; i < len; i++)
		if (chkObj[i].checked)
			countChk = countChk + 1;

	if (countChk != 1) {
		alert("Please Select One Record");
		return false;
	}

	for ( var i = 0; i < len; i++) {

		if (chkObj[i].checked) {
			url = 'DrugDosageIndicationMstCNT.cnt?hmode=viewPage' + '&chk='
					+ chkObj[i].value;
			window.open(url, "popupWindow",
					"width=610,height=450,scrollbars=yes");
		}
	}

}

// used in indent Authorization Master by baisakhi
function indentAuthorizationComboAdd(form1) {

	var cmbVal = "";
	var cmbVal2 = "";
	var cmbVal3 = "";
	var cmbVal4 = "";

	with (form1) {

		if (combo[0].value == "0") {
			alert("Please Select Store Name");
			document.forms[0].combo[0].focus();
			return;
		} else if (combo[1].value == "0") {
			alert("Please Select Item Category Name");
			document.forms[0].combo[1].focus();
			return;
		} else if (combo[2].value == "0") {
			alert("Please Select Authorization For");
			document.forms[0].combo[2].focus();
			return;
		} else if (combo[3].value == "0") {
			alert("Please Select Type");
			document.forms[0].combo[3].focus();
			return;
		}

		else {
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			cmbVal2 = combo[1].options[combo[1].selectedIndex].text;
			cmbVal3 = combo[2].options[combo[2].selectedIndex].text;
			cmbVal4 = combo[3].options[combo[3].selectedIndex].text;

			comboValue.value = cmbVal + "^" + cmbVal2 + "^" + cmbVal3 + "^"
					+ cmbVal4;
			add("ADD");

		}
	}

}

// used in indent Authorization Master by baisakhi
function indentAuthorizationComboModify(form1) {

	var cmbVal = "";
	var cmbVal2 = "";
	var cmbVal3 = "";
	var cmbVal4 = "";

	with (form1) {

		if (combo[0].value == "0") {
			alert("Please Select Store Name");
			document.forms[0].combo[0].focus();
			return;
		} else if (combo[1].value == "0") {
			alert("Please Select Item Category Name");
			document.forms[0].combo[1].focus();
			return;
		} else if (combo[2].value == "0") {
			alert("Please Select Authorization For");
			document.forms[0].combo[2].focus();
			return;
		} else if (combo[3].value == "0") {
			alert("Please Select Type");
			document.forms[0].combo[3].focus();
			return;
		}

		else {
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			cmbVal2 = combo[1].options[combo[1].selectedIndex].text;
			cmbVal3 = combo[2].options[combo[2].selectedIndex].text;
			cmbVal4 = combo[3].options[combo[3].selectedIndex].text;

			comboValue.value = cmbVal + "^" + cmbVal2 + "^" + cmbVal3 + "^"
					+ cmbVal4;
			add("MODIFY");

		}
	}
}

function callComboAppAuthAdd(form1, mode) {

	var cmbVal = "";
	var cmbVal1 = "";
	var cmbVal2 = "";

	with (form1) {

		if (combo[0].value == "0") {
			alert("Please Select Approving Type");
			document.forms[0].combo[0].focus();
			return;
		} else if (combo[1].value == "0" && combo[0].value == "1") {
			alert("Please Select Store Name");
			document.forms[0].combo[1].focus();
			return;
		} else {

			cmbVal = combo[0].options[combo[0].selectedIndex].text;

			if (combo[1].value == "0") {
				cmbVal1 = " ";
			} else {
				cmbVal1 = combo[1].options[combo[1].selectedIndex].text;
			}
			comboValue.value = cmbVal + "^" + cmbVal1;
			add("ADD");
		}
	}
}

function callComboAppAuthModify(form1, mode) {

	var cmbVal = "";
	var cmbVal1 = "";
	var cmbVal2 = "";

	with (form1) {
		if (combo[0].value == "0") {
			alert("Please Select Approving Type");
			document.forms[0].combo[0].focus();
			return;
		} else if (combo[1].value == "0" && combo[0].value == "1") {
			alert("Please Select Store Name");
			document.forms[0].combo[1].focus();
			return;
		} else {

			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			if (combo[1].value == "0") {
				cmbVal1 = " ";
			} else {
				cmbVal1 = combo[1].options[combo[1].selectedIndex].text;
			}

			comboValue.value = cmbVal + "^" + cmbVal1;
			edit("MODIFY");
		}
	}
}

// used in store request type master
function callComboStoreReq(form1, mode) {

	var cmbVal = "";
	var cmbVal1 = "";
	var cmbVal2 = "";
	var cmbVal3 = "";
	with (form1) {

		if (combo[0].value == "0" && combo[1].value == "0") {
			if (mode == '1') {
				alert("Please Select Store Name");

				document.forms[0].combo[0].focus();
				return;
			}
		} else if (combo[1].value == "0") {

			alert("Please Select Item Category");

			document.forms[0].combo[1].focus();
			return;

		} else {
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			cmbVal2 = combo[1].options[combo[1].selectedIndex].text;

			if (cmbVal3 == 'Active' || cmbVal3 == 'Inactive')
				comboValue.value = cmbVal;
			else
				comboValue.value = cmbVal + "^" + cmbVal2;
			add("ADD");

		}
	}
}

function callComboStoreReqModify(form1, mode) {

	var cmbVal = "";
	var cmbVal1 = "";
	var cmbVal2 = "";
	var cmbVal3 = "";
	with (form1) {

		if (combo[0].value == "0" && combo[1].value == "0") {
			if (mode == '1') {
				alert("Please Select Store Name");
				document.forms[0].combo[0].focus();
				return;
			}
		} else if (combo[1].value == "0") {

			alert("Please Select Drug Category");
			document.forms[0].combo[1].focus();
			return;

		} else {
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			cmbVal2 = combo[1].options[combo[1].selectedIndex].text;

			if (cmbVal3 == 'Active' || cmbVal3 == 'Inactive')
				comboValue.value = cmbVal;
			else
				comboValue.value = cmbVal + "^" + cmbVal2;
			edit("MODIFY");

		}
	}
}

function callAddMode(form1, mode) {
	var cmbVal = "";
	var cmbVal2 = "";
	var cmbVal3 = "";
	var cmbVal4 = "";
	
	console.log("-----Check.callAddMode------");
	cmbVal = combo[0].options[combo[0].selectedIndex].text;
	cmbVal2 = combo[1].options[combo[1].selectedIndex].text;
	cmbVal3 = combo[2].options[combo[2].selectedIndex].text;

	if (cmbVal4 == 'Active' || cmbVal4 == 'Inactive')
		comboValue.value = cmbVal;
	else
		comboValue.value = cmbVal + "^" + cmbVal2 + "^" + cmbVal3;
	add("ADD");

}

function callModifyMode(form1, mode) {
	var cmbVal = "";
	var cmbVal2 = "";
	var cmbVal3 = "";
	var cmbVal4 = "";

	with (form1) {

		if (combo[0].value == "0" || combo[1].value == "0") {
			if (mode == '1') {
				if (combo[0].value == "0") {
					alert("Please Select Store Name");
					return false;
				} else if (combo[1].value == "0") {
					alert("Please Select Item Category");
					return false;
				} else if (combo[2].value == "0") {
					alert("Please Select Request Type");
					return false;
				}

				document.forms[0].combo[0].focus();
				return;
			}
		} else {
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			cmbVal2 = combo[1].options[combo[1].selectedIndex].text;
			cmbVal3 = combo[2].options[combo[2].selectedIndex].text;

			if (cmbVal4 == 'Active' || cmbVal4 == 'Inactive')
				comboValue.value = cmbVal;
			else
				comboValue.value = cmbVal + "^" + cmbVal2 + "^" + cmbVal3;
			edit("MODIFY");

		}
	}
}

function callDrugAddMode(form1, mode) {
	var cmbVal = "";
	var cmbVal2 = "";
	var cmbVal3 = "";

	with (form1) {

		if (combo[0].value == "0" || combo[1].value == "0") {
			if (mode == '1') {
				if (mode == '1' && combo[0].value == "0") {
					alert("Please Select Group Name");
					return false;
				} /*else if (mode == '1' && combo[1].value == "0") {
					// alert("Please Select Generic Drug Name");
					// change by amit kumar ateria
					alert("Please Select Sub Group Name");
					return false;

				}*/

				document.forms[0].combo[0].focus();
				return;
			}
		} else {
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			cmbVal2 = combo[1].options[combo[1].selectedIndex].text;

			if (cmbVal3 == 'Active' || cmbVal3 == 'Inactive')
				comboValue.value = cmbVal;
			else
				comboValue.value = cmbVal + "^" + cmbVal2;
			add("ADD");

		}
	}
}

function callDrugModifyMode(form1, mode) {
	var cmbVal = "";
	var cmbVal2 = "";
	var cmbVal3 = "";

	with (form1) {

		if (combo[0].value == "0" ) {
			if (mode == '1') {
				if (mode == '1' && combo[0].value == "0") {
					alert("Please Select Group Name");
					return false;
				} /*else if (mode == '1' && combo[1].value == "0") {
					alert("Please Select Generic Drug Name");
					return false;

				}*/

				document.forms[0].combo[0].focus();
				return;
			}
		} else {
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			cmbVal2 = combo[1].options[combo[1].selectedIndex].text;
			// cmbVal3 = combo[2].options[combo[2].selectedIndex].text;

			comboValue.value = cmbVal + "^" + cmbVal2;
			edit("MODIFY");

		}
	}
}

// used in Item Brand Master by Tanvi
function itemBrandMstComboAdd(form1) {

	var cmbVal = "";
	var cmbVal2 = "";

	with (form1) {

		if (combo[0].value == "0") {
			alert("Please Select Drug Category Name");
			document.forms[0].combo[0].focus();
			return;
		} else if (combo[1].value == "0") {
			alert("Please Select Group Name");
			document.forms[0].combo[1].focus();
			return;
		}

		else {
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			cmbVal2 = combo[1].options[combo[1].selectedIndex].text;

			comboValue.value = cmbVal + "^" + cmbVal2;
			add("ADD");

		}
	}

}

// used in Item Brand Master by Tanvi
function itemBrandMstComboModify(form1) {

	var cmbVal = "";
	var cmbVal2 = "";

	with (form1) {

		if (combo[0].value == "0") {
			alert("Please Select Item Category Name");
			document.forms[0].combo[0].focus();
			return;
		} else if (combo[1].value == "0") {
			alert("Please Select Group Name");
			document.forms[0].combo[1].focus();
			return;
		} else {
			
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			cmbVal2 = combo[1].options[combo[1].selectedIndex].text;

			comboValue.value = cmbVal + "^" + cmbVal2;
			//add("MODIFY");
			edit("MODIFY");

		}
	}
}

// used in Item mst

function itemView() {
	document.getElementById('message').style.display = 'none';
	if (checkForView() == false)
		return false;
	var chk_temp = document.forms[0].chk.length;
	var temp_cnt = document.forms[0].cnt_page.value;
	var temp1 = temp_cnt.split(".");
	var cnt_page = temp1[0];
	var chk = "";

	var mode = "VIEW";

	if (!isNaN(chk_temp)) {
		for ( var i = 0; i < chk_temp; i++) {
			if (document.forms[0].chk[i].checked == true)
				chk = document.forms[0].chk[i].value;
		}
	} else
		chk = document.forms[0].chk.value;

	// var widthvalue=document.forms[0].view_row_length.value * 60;
	// var heg_width="width=700,height="+widthvalue;
	// var heg_width="width=700,height=350,left=200,top=200";
	// var myPopup =
	// window.open("CNTWardMst.cnt?hmode="+mode+"&chk="+chk,'popupWindow',heg_width);

	var heg_width = "width=700,height=500,left=200,top=200";

	var cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
	var cmbVal2 = document.forms[0].combo[1].options[document.forms[0].combo[1].selectedIndex].text;
	var cmbVal3 = document.forms[0].combo[2].options[document.forms[0].combo[2].selectedIndex].text;
	// var cmbVal4 =
	// document.forms[0].combo[3].options[document.forms[0].combo[3].selectedIndex].text;
	var cmbVal4 = "";
	var comboValue = cmbVal + "^" + cmbVal2 + "^" + cmbVal3 + "^" + cmbVal4;
	var myPopup = window.open("ItemMstCNT.cnt?hmode=" + mode + "&chk=" + chk
			+ "&comboValue=" + comboValue + "&cmbVal1=" + cmbVal + "&cmbVal2="
			+ cmbVal2 + "&cmbVal3=" + cmbVal3, 'popupWindow', heg_width);// +"&cnt_page="+cnt_page+"&masterName="+document.forms[0].masterName.value,'popupWindow',heg_width,
	// 'scrollbars=yes,ALIGN=CENETER,left=100,top=100');

}

/**
 * checkAvailQty - Qty validation.
 * 
 * @param {String}
 *            unitName
 * @param {String}
 *            qtyName
 */
function checkQty(index, qtyName, unitName) {

	var unitObj = document.getElementById(unitName + "" + index);
	var qtyObj = document.getElementById(qtyName + "" + index);

	var qtyDeceimal = qtyObj.value;

	var unitVal = unitObj.value.split('^')[2];

	if (qtyDeceimal.indexOf('.') > -1 && unitVal == '0') {

		alert("Qty must be an Integer ");
		qtyObj.value = '';

		return false;
	}

	calculateCost(gblMode, qtyName, unitName, gblCostName, index,
			gblTotalCostName, gblIsAvailReq);

	return true;
}

/**
 * checkAvailQty - Qty validation.
 * 
 * @param {String}
 *            index
 * @param {String}
 *            unitName
 * @param {String}
 *            qtyName
 * @param {String}
 *            avlQtyInBaseValue
 * 
 */
function checkQtyWithoutUtility(index, qtyName, unitName, avlQtyInBaseValue,
		message) {

	var unitObj = document.getElementById(unitName + "" + index);
	var qtyObj = document.getElementById(qtyName + "" + index);

	var qtyDeceimal = qtyObj.value;

	var unitVal = unitObj.value.split('^')[2];

	if (qtyDeceimal.indexOf('.') > -1 && unitVal == '0') {

		alert("Qty must be an Integer ");
		qtyObj.value = '';

		return false;
	}

	var qtyObjVal = qtyObj.value;
	var unitObjVal = unitObj.value;
	var qty = parseFloat("0");
	var qtyBaseVal = parseInt("0");

	if (avlQtyInBaseValue.length <= 0) {

		avlQtyInBaseValue = "0";
	}

	var inHandQtyInBaseVal = parseFloat(avlQtyInBaseValue);

	if (unitObjVal.length > 1) {
		qtyBaseVal = parseInt(unitObjVal.split('^')[1]);
	}

	if (qtyObjVal.length > 0) {
		qty = parseInt(qtyObjVal);
	}

	var reqQtyInBaseVal = qty * qtyBaseVal;

	if (reqQtyInBaseVal > inHandQtyInBaseVal) {

		if (message.length > 0) {

			alert(message);

		} else {

			alert("Required Quantity should not be Greater than Available Quantity");
		}

		document.getElementById(qtyName + "" + index).value = "";
		document.getElementById(unitName + "" + index).selectedIndex = 0;

		return false;
	}

	return true;
}

/**
 * checkQty
 * 
 * @param {String}
 *            unitName
 * @param {String}
 *            qtyName
 */
function checkQtyOnSubmit(unitName, qtyName) {

	var paramVal = document.getElementsByName("itemParamValue");

	if (paramVal.length > 1) {

		var unitObj = document.getElementsByName(unitName);
		var qtyObj = document.getElementsByName(qtyName);

		for ( var i = 0, stop = paramVal.length - 1; i < stop; i++) {

			var isQtyDeceimal = paramVal[i].split('^')[paramVal[i].length - 1];

			var unitVal = unitObj[i].value;

			if (unitVal.indexOf('.') > -1 && isQtyDeceimal == '0') {

				alert(qtyName + " must be an Integer ");
				return false;
			}

		}

	}

	return true;
}

var gblMode = "";
var gblCostName = "";
var gblIndex = "";
var gblTotalCostName = "";
var gblIsAvailReq = "1";
/**
 * calculateCost
 * 
 * the function by default consider costName is hidden Field and Corresponding
 * Div with the id 'costName+DivId#delIndex#' and Similarly total Cost Name and
 * its div id.
 * 
 * @param {String}
 *            mode - Item Search Mode.
 * @param {String}
 *            qtyName - Quantity Text Name.
 * @param {String}
 *            unitName - Unit Combo Name.
 * @param {String}
 *            costName - cost Hidden Name
 * @param {String}
 *            index - row Index
 * @param {String}
 *            totalCostName - Total Cost Hidden Name
 * @param {String}
 *            isAvailReq - is Available Qty. validation is required 0 - not
 *            required, 1 - required
 */
function calculateCost(mode, qtyName, unitName, costName, index, totalCostName,
		isAvailReq) {

	gblMode = mode;
	gblCostName = costName;
	gblIndex = index;
	gblTotalCostName = totalCostName;
	gblIsAvailReq = isAvailReq;

	var qtyObjVal = document.getElementById(qtyName + "" + index).value;
	var unitObjVal = document.getElementById(unitName + "" + index).value;

	var qty = parseFloat("0");
	var qtyBaseVal = parseInt("0");
	var rateInBaseVal = parseFloat("0");

	var inHandQtyInBaseVal = parseFloat("0");

	var cost = parseFloat("0");

	var paramVal = document.getElementById("itemParamValue" + index).value;

	if (unitObjVal.length > 1) {
		qtyBaseVal = parseInt(unitObjVal.split('^')[1]);
	}

	if (qtyObjVal.length > 0) {
		qty = parseInt(qtyObjVal,10);
	}

	if (mode == '1') {

		var tempVal1 = paramVal.split('#');

		var tempVal = tempVal1[1].split('^');

		inHandQtyInBaseVal = parseFloat(tempVal[0]);
		rateInBaseVal = parseFloat(tempVal[1]);

	} else if (mode == '2') {

		var tempVal1 = paramVal.split('#');

		var tempVal = tempVal1[1].split('^');

		inHandQtyInBaseVal = parseFloat(tempVal[0]);
		rateInBaseVal = parseFloat(tempVal[1]);

	} else if (mode == '3') {

		var tempVal1 = paramVal.split('#');

		var tempVal = tempVal1[1].split('^');

		inHandQtyInBaseVal = parseFloat(tempVal[0]);
		rateInBaseVal = parseFloat(tempVal[1]);

	}

	cost = ((qty * qtyBaseVal) * rateInBaseVal);
   
	var reqQtyInBaseVal = qty * qtyBaseVal;

	if (isAvailReq == '1')
		if (reqQtyInBaseVal > inHandQtyInBaseVal) {

			alert("Required Quantity should not be Greater than Available Quantity");
			document.getElementById(qtyName + "" + index).value = "";
			document.getElementById(unitName + "" + index).selectedIndex = 0;

			if (costName.length > 0) {
				document.getElementById(costName + "" + index).value = "0";
				document.getElementById(costName + "DivId" + index).innerHTML = "0.00";

				if (totalCostName.length > 0)

					calculateTotalCost(costName, totalCostName);

			}

			return false;
		}

	if (costName.length > 0) {

		cost = roundValue(cost, 2);

		document.getElementById(costName + "" + index).value = cost;

		document.getElementById(costName + "DivId" + index).innerHTML = cost;

		if (totalCostName.length > 0)

			calculateTotalCost(costName, totalCostName);

	}
}

/**
 * calculateTotalCost
 * 
 * @param {String}
 *            costName
 * @param {String}
 *            totalCostName
 */
function calculateTotalCost(costName, totalCostName) {

	var costObj = document.getElementsByName(costName);
	var total = parseFloat("0.00");

	if (costObj.length > 1) {

		for ( var i = 0, stop = costObj.length - 1; i < stop; i++) {

			total = total + parseFloat(costObj[i].value);

		}

	}

	total = roundValue(total, 2);

	document.getElementsByName(totalCostName)[0].value = total;
	document.getElementById(totalCostName + "DivId").innerHTML = total;

	return false;

}

/**
 * validateOnSubmit - must be call before save the searched item details
 * 
 * @param {String}
 *            mode - Search Util Mode
 * @param {String}
 *            costName - name of the Cost Hidden Field
 * @param {String}
 *            totalCostName - Name of the Total Cost Hidden Field
 */
function validateOnSubmit(mode, costName, totalCostName) {

	if (mode != '2') {
		var paramVal = document.getElementsByName("itemParamValue")[0];
		var tempVal = paramVal.split('#')[2].split('^');

		var costLimit = parseFloat(tempVal[28]);
		var costLimitUnit = parseInt(tempVal[29]);

		if (costLimitUnit == 1) {

			var costObj = document.getElementsByName(costName);

			if (costObj.length > 1)
				for ( var i = 0, stop = costObj.length - 1; i < stop; i++) {

					costVal = parseFloat(costObj[i].value);

					if (costVal > costLimit) {

						alert("Cost Cannot be Grater than Cost Limit "
								+ costLimit);
						return false;
					}
				}

		} else if (costLimitUnit == 2) {

			var totalCostObj = document.getElementsByName(totalCostName);

			if (totalCostObj.length > 0) {

				var totalCostVal = parseFloat(totalCostObj.value);

				if (totalCostVal > costLimit) {

					alert("Total Cost Cannot be Grater than Cost Limit "
							+ costLimit);
					return false;

				}

			}

		}

		enableUserValues();

	} else {

		enableUserValues();

	}

	return true;

}

/**
 * enableUserValues - enables the user value which are by default desabled.
 */
function enableUserValues() {

	var userValObj = document.getElementsByName('itemUserValue');

	if (userValObj.length > 1)
		for ( var i = 0, stop = userValObj.length - 1; i < stop; i++) {

			userValObj[i].disabled = false;
		}

}

// function for Contradicted Drugs Master View Page
function contradicView() {
	document.getElementById('message').style.display = 'none';

	if (checkForView() == false)
		return false;

	var chk_temp = document.forms[0].chk.length;
	var temp_cnt = document.forms[0].cnt_page.value;
	var temp1 = temp_cnt.split(".");
	var cnt_page = temp1[0];
	var chk = "";
	var mode = "VIEW";
	if (!isNaN(chk_temp)) {
		for ( var i = 0; i < chk_temp; i++) {
			if (document.forms[0].chk[i].checked == true)
				chk = document.forms[0].chk[i].value;
		}
	} else
		chk = document.forms[0].chk.value;

	var heg_width = "width=500,height=500,left=200,top=200";
	var myPopup = window.open("DrugContradictionMstCNT.cnt?hmode=" + mode
			+ "&chk=" + chk, 'popupWindow', heg_width);

}


/////////////////function to display selected combo value on next page
function callMe(form1)
{
	
	var cmbVal = "";
	with(form1)
	{
	
		if(combo[0].value == "0")
		{
		
			//alert("Please Select Package Name");
			
			 alert("Please Select Module Name");
			return;
		}
		else
		{
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			comboValue.value = cmbVal;
			
			
		//	cmbVal2 = combo[1].options[combo[1].selectedIndex].text;
		//	comboValue2.value = cmbVal;
			
			 add("ADD");
			 
			
		}	
	}
}
	
/////////////////////////////////////////////////////////////////////////////////////////////
	function callMePack1(form1)
{
	//alert("callme func is calling");
	var cmbVal = "";
	with(form1)
	{
	
		if(combo[0].value == "0")
		{
			alert("Please Select Package Name");
			return;
		}
		else
		{
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			comboValue.value = cmbVal;
			
			
		//	cmbVal2 = combo[1].options[combo[1].selectedIndex].text;
		//	comboValue2.value = cmbVal;
			
			 add("ADD");
			 
			
		}	
	}	
}
	
function showViewStore(form1) 
{

	var chkObj = document.getElementsByName("chk");
	
	var len = chkObj.length;

	var countChk = 0;

	for ( var i = 0; i < len; i++)
		if (chkObj[i].checked)
			countChk = countChk + 1;

	if (countChk != 1) 
	{
		alert("Please Select One Record!!!");
		return false;
	}
	

	for ( var i = 0; i < len; i++) 
	{

		if (chkObj[i].checked) 
		{
			url = 'StoreMstCNT.cnt?hmode=VIEW' + '&chk=' + chkObj[i].value;
			window.open(url, "popupWindow",
					"width=610,height=450,scrollbars=yes");
		}
	}

}


function deleteRecordscheck()
{
	
		document.forms[0].hmode.value="DELRecord";
		document.forms[0].submit();
}