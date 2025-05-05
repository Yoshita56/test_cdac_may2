
function validate()
{

	    var hisValidator = new HISValidator("budgetDetailRptFB");
        hisValidator.addValidation("strStoreId","dontselect=0","Please select a Drug Warehouse Name" );
		hisValidator.addValidation("strIndentPeriodValue", "dontselect=0","Select Financial Year From Financial Year Combo");
	    var retVal = hisValidator.validate();
	    hisValidator.clearAllValidations();

		if(retVal)
		{
		    var  comboVal = document.forms[0].strIndentPeriodValue[document.forms[0].strIndentPeriodValue.selectedIndex].text;
            document.forms[0].strStartFinancialYear.value = comboVal.split("-")[0];
            document.forms[0].strEndFinancialYear.value = comboVal.split("-")[1];
                      
			document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
			document.forms[0].strDwhStoreName.value = document.forms[0].strDrugWarehouseTypeId[document.forms[0].strDrugWarehouseTypeId.selectedIndex].text;
		

			document.forms[0].hmode.value = "SHOWRPT";
			if(document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html")
			{
					document.forms[0].target = "_self";
			}
			else
			{
					document.forms[0].target = "_blank";
			}
			document.forms[0].submit();
		}
		else
		{
			return false;
		}
	}

	

function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();
	
	l

}

function setEndFinancialYear()
{
	document.forms[0].strEndFinancialYear.value=parseInt(document.forms[0].strStartFinancialYear.value)+parseInt("1"); 
}
