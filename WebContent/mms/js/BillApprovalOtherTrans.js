// called on go button after entering po no.
function goFunc()
{
	//alert("goFunc");
	var hisValidator = new HISValidator("billApprovalOtherTransBean");
    hisValidator.addValidation("strPONo","dontselect=0","Please select PO No." );
    var retVal = hisValidator.validate();
      hisValidator.clearAllValidations();
	if(retVal)
	{
		document.getElementById("PODetailsDIV").style.display="block";
	 	document.forms[0].hmode.value="GO";
	 	document.forms[0].submit();
	 	document.forms[0].strPONo.disabled=true; 
	}
	 else
	{
		return false;
	}
}


// to clear page

function clearFunc()
{
	document.forms[0].strPONoH.value="0";
	document.forms[0].strPONo.value="0";
	document.forms[0].hmode.value="init";
	 	document.forms[0].submit();

}

// to cancel page and return to list page

function cancel()
{
	document.forms[0].hmode.value="CANCEL";
	 	document.forms[0].submit();
}