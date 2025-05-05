

function validate1(){

	//alert("inside validate1()");
	var hisValidator = new HISValidator("sampleIssueDetailRptBean");
    hisValidator.addValidation("strStoreId", "dontselect=-1","Please Select Store Name");
	document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	 //alert("strStoreName :"+document.forms[0].strStoreName.value); 
	
	
		hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	
	
	if(document.forms[0].strIsFooter.checked==true){
		document.forms[0].strIsFooter.value=1;
	}
		
			
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	
	var diffdate = dateDiff1(document.forms[0].strFromDate.value,document.forms[0].strToDate.value); 
 	//alert(diffdate);
 	 if(parseInt(diffdate)>365)
 	 {
 		alert("Difference Between From Date and To Date Should not be greater than 365 days");
 		return false;
 	 }
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