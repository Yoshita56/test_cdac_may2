
function validate(){

	var hisValidator = new HISValidator("drugWarehouseWiseSupplierDeliveryDetailRptFB");

//		hisValidator.addValidation("strStartFinancialYear", "req","Start Financial Year is a mandatory field");
		hisValidator.addValidation("strStoreId","dontselect=-1","Please Select District Drug Warehouse Name");
		hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

if(retVal)
{
	document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;

	//document.forms[0].strEndFinancialYear.disabled=false;
	
	//document.forms[0].strEndFinancialYearTemp.value = document.forms[0].strEndFinancialYear.value;
		
	//document.forms[0].strEndFinancialYear.disabled=true;
	
	
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


function onClickBatch(){

		if(document.forms[0].strBatchNo.checked){
		
			document.forms[0].strBatchNo.value = "1";
		
		}else if(document.forms[0].strBatchNo.checked == false){
		
			document.forms[0].strBatchNo.value = "0";
		
		}
}


