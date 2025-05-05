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
function buttonClick(param) 
{

	if (param == "ORDER_GENERATE") {

	} else if (param == "ORDER_MODIFY") {

	} else 
	if (param == "ORDER_CANCEL") 
	{
		if(document.getElementById("comboid0").value.split("^")[3]=="1")
		{
	       alert("Physical Stock Verification for [ "+document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text+" ] is Under Process \n No Activity will allowed till Verification Process is completed");
	       return false;      	
		}

		var strRemarks = prompt("Cancel Remarks", "");

		if (strRemarks == null) 
		{

			return false;

		} else if (strRemarks != "") 
		{

            
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

		} 
		else 
		{

			alert("Remarks is a Mandaotry Field ");
			return buttonClick(param);

		}

	} 
	else if (param == "ORDER_VIEW") 
	{

	} else if (param == "TRANSFER_REJECT") {
		
		//99903012@10921300007@1@998$0$99901159|0|Pusad - Belura$2
        //HSTNUM_STORE_ID||'@'||HSTNUM_REQUEST_NO||'@'||HSTNUM_SLNO||'@'||GNUM_HOSPITAL_CODE||'$'||APP_QTY||'$' || STR_DTL(HSTNUM_PARENT_STORE_ID||'|'||HSTNUM_IS_DWH || '|' || HSTSTR_STORE_NAME )
            
        var comboStoreId = "0";
        var dwhFlag = "0";
        var dwhTypeId = "0";
        var comobStoreName = "";
        var strChkDwhFlag = "0";
        var strChkParentStrId ="0";
        
        if(document.forms[0].combo[0].value != "0")
        {
        	comboStoreId = document.forms[0].combo[0].value.split("^")[0];
        	dwhFlag = document.forms[0].combo[0].value.split("^")[1];
        	dwhTypeId = document.forms[0].combo[0].value.split("^")[2];
        	comobStoreName = document.forms[0].combo[0][document.forms[0].combo[0].selectedIndex].text;
        	/*alert("comboStoreId: "+comboStoreId);
        	alert("comobStoreName: "+comobStoreName);
        	alert("dwhFlag: "+dwhFlag);
        	alert("dwhTypeId: "+dwhTypeId);*/        	
        }
            

		var strRemarks = prompt("Reject Remarks", "");

		if (strRemarks == null) {
			
			return false;

		} else if (strRemarks != "") {

			var check = document.getElementsByName("chk");
			var strRequestNo = "";

			for ( var i = 0; i < check.length; i++) {
				if (check[i].checked == true) {
					strRequestNo = check[i].value.split("@")[1];
					strStoreId = check[i].value.split("@")[0]; 
					storeName = check[i].value.split("$")[2].split("|")[2];
					strChkDwhFlag =  check[i].value.split("$")[2].split("|")[1];
					strChkParentStrId = check[i].value.split("$")[2].split("|")[0];
					
					/*alert("strRequestNo: "+strRequestNo);
		        	alert("strStoreId: "+strStoreId);
		        	alert("storeName: "+storeName);
		        	alert("strChkDwhFlag: "+strChkDwhFlag); 
		        	alert("strChkParentStrId: "+strChkParentStrId);*/ 
        	
        			//if store in combo is HQ or DDW
					if(dwhTypeId == "10" || dwhFlag=="1")
					{
						if(dwhTypeId == "10") //if store in combo is HQ
						{
							if(strChkDwhFlag !="1" ) // if store in checked record is not DDW
							{
								alert("Selected Request: "+strRequestNo+" for store: "+storeName+" can not be rejected \n" +
									"because "+comobStoreName+" doesn't have privillege.");
								check[i].checked = false;
						    	return false;
							}
						}
						else
						{
							if(dwhFlag=="1") //if combo store is DDW
							{
								if(strChkParentStrId != comboStoreId) //if store in checked record is not child of Combo Store	
								{
									alert("Selected Request: "+strRequestNo+" for store: "+storeName+" can not be rejected \n" +
									"because "+comobStoreName+" doesn't have privillege.");
									check[i].checked = false;
						   			return false;
								}
							}							
						}
					}
					else //SUBSTORE
					{
						
						if(comboStoreId != strStoreId) //if combo store is substore and store in checked record is not the combo store
						{
							alert("Selected Request: "+strRequestNo+" for store: "+storeName+" can not be rejected \n" +
									"because "+comobStoreName+" doesn't have privillege.");
							check[i].checked = false;
						    return false;
						}						
					}
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
  
    if(document.getElementById("comboid0").value.split("^")[3]=="1")
	{
       alert("Physical Stock Verification for [ "+document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text+" ] is Under Process \n No Activity will allowed till Verification Process is completed");
       return false;      	
	}

	document.forms[0].hmode.value = param;
	document.forms[0].target = "_self";
	document.forms[0].submit();

}
function buttonClickView(param) 
{

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
		
		//99903012@10921300007@1@998$0$99901159|0|Pusad - Belura$2
        //HSTNUM_STORE_ID||'@'||HSTNUM_REQUEST_NO||'@'||HSTNUM_SLNO||'@'||GNUM_HOSPITAL_CODE||'$'||APP_QTY||'$' || STR_DTL(HSTNUM_PARENT_STORE_ID||'|'||HSTNUM_IS_DWH || '|' || HSTSTR_STORE_NAME )
            
        var comboStoreId = "0";
        var dwhFlag = "0";
        var dwhTypeId = "0";
        var comobStoreName = "";
        var strChkDwhFlag = "0";
        var strChkParentStrId ="0";
        
        if(document.forms[0].combo[0].value != "0")
        {
        	comboStoreId = document.forms[0].combo[0].value.split("^")[0];
        	dwhFlag = document.forms[0].combo[0].value.split("^")[1];
        	dwhTypeId = document.forms[0].combo[0].value.split("^")[2];
        	comobStoreName = document.forms[0].combo[0][document.forms[0].combo[0].selectedIndex].text;
        	/*alert("comboStoreId: "+comboStoreId);
        	alert("comobStoreName: "+comobStoreName);
        	alert("dwhFlag: "+dwhFlag);
        	alert("dwhTypeId: "+dwhTypeId);*/        	
        }
            

		var strRemarks = prompt("Reject Remarks", "");

		if (strRemarks == null) {
			
			return false;

		} else if (strRemarks != "") {

			var check = document.getElementsByName("chk");
			var strRequestNo = "";

			for ( var i = 0; i < check.length; i++) {
				if (check[i].checked == true) {
					strRequestNo = check[i].value.split("@")[1];
					strStoreId = check[i].value.split("@")[0]; 
					storeName = check[i].value.split("$")[2].split("|")[2];
					strChkDwhFlag =  check[i].value.split("$")[2].split("|")[1];
					strChkParentStrId = check[i].value.split("$")[2].split("|")[0];
					
					/*alert("strRequestNo: "+strRequestNo);
		        	alert("strStoreId: "+strStoreId);
		        	alert("storeName: "+storeName);
		        	alert("strChkDwhFlag: "+strChkDwhFlag); 
		        	alert("strChkParentStrId: "+strChkParentStrId);*/ 
        	
        			//if store in combo is HQ or DDW
					if(dwhTypeId == "10" || dwhFlag=="1")
					{
						if(dwhTypeId == "10") //if store in combo is HQ
						{
							if(strChkDwhFlag !="1" ) // if store in checked record is not DDW
							{
								alert("Selected Request: "+strRequestNo+" for store: "+storeName+" can not be rejected \n" +
									"because "+comobStoreName+" doesn't have privillege.");
								check[i].checked = false;
						    	return false;
							}
						}
						else
						{
							if(dwhFlag=="1") //if combo store is DDW
							{
								if(strChkParentStrId != comboStoreId) //if store in checked record is not child of Combo Store	
								{
									alert("Selected Request: "+strRequestNo+" for store: "+storeName+" can not be rejected \n" +
									"because "+comobStoreName+" doesn't have privillege.");
									check[i].checked = false;
						   			return false;
								}
							}							
						}
					}
					else //SUBSTORE
					{
						
						if(comboStoreId != strStoreId) //if combo store is substore and store in checked record is not the combo store
						{
							alert("Selected Request: "+strRequestNo+" for store: "+storeName+" can not be rejected \n" +
									"because "+comobStoreName+" doesn't have privillege.");
							check[i].checked = false;
						    return false;
						}						
					}
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