
function getAjaxResponse(res, mode) 
{

	var objVal;
	if (mode == "1") 
	{

		//objVal = document.getElementById("itemBrandDivId");
		//objVal.innerHTML = "<select name ='strItemBrandId' class='comboMax' >"+ res + "</select>";
		
	}
}

function validate1(){

	//alert("inside validate1()");
	var hisValidator = new HISValidator("pendingSampleDetailRptFB");
//    hisValidator.addValidation("strLabId", "dontselect=0","Please Select Lab Name");
	document.forms[0].strLabName.value = document.forms[0].strLabId[document.forms[0].strLabId.selectedIndex].text;
	  
	if(document.forms[0].strIsFooter.checked==true){
		document.forms[0].strIsFooter.value=1;
	}
		
			
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	
		
	if(retVal){


		document.forms[0].hmode.value = "SHOWRPT";
		
			if(document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html")
			{
				document.forms[0].target = "_self";
			}else{
				document.forms[0].target = "_blank";
			}
		document.forms[0].submit();
		}else{
			return false;
		}
}
	
function clearViewPage()
{
	document.forms[0].reset();
	
}

function cancelPage()
{
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}