
function validate(){

	var hisValidator = new HISValidator("listOfInstitutionsRptFB");

		
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

if(retVal)
{

		  
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

	

function cancelPage()
{
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}
