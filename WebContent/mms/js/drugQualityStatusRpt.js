function getItemBrandList(strCombo) 
{
 		 
 		if(strCombo.value!='-1')
	    {
			var hmode = "GETDRUGLIST"; 
			var url = "DrugQualityStatusRptCNT.cnt?hmode="+hmode+"&groupId="+strCombo.value;
 			ajaxFunction(url,"1");
	    }
	    else
	    {
	    	alert("Please Select Group Name!!!");
	    	document.getElementById("itemBrandDivId").innerHTML="<select name='strItemBrandId' class='comboNormal'>"+
				 "<option title='Select Value' value='-1'>Select Value</option></select>";
		    return false;
	    }	
}
function getAjaxResponse(res, mode) 
{

	var objVal;
	if (mode == "1") 
	{

		objVal = document.getElementById("itemBrandDivId");
		objVal.innerHTML = "<select name ='strItemBrandId' class='comboMax' >"+ res + "</select>";
		
	}
}

function validate1(){

	//alert("inside validate1()");
	var hisValidator = new HISValidator("drugQualityStatusRpt");
    hisValidator.addValidation("strGroupId", "dontselect=-1","Please Select Group Name");
	document.forms[0].strItemBrandName.value = document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].text;
	  
	hisValidator.addValidation("strItemBrandId", "dontselect=-1","Please Select Drug Name");
	document.forms[0].strItemBrandName.value = document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].text;
	
	
		hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	
	
	if(document.forms[0].strIsFooter.checked==true)
	{
		document.forms[0].strIsFooter.value=1;
	}
		
		
			
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	
	
	if(retVal)
	{

var diffdate = dateDiff1(document.forms[0].strFromDate.value,document.forms[0].strToDate.value); 
 	//alert(diffdate);
 	 if(parseInt(diffdate)>365)
 	 {
 		alert("Difference Between From Date and To Date Should not be greater than 365 days");
 		return false;
 	 }

		document.forms[0].hmode.value = "SHOWRPT";
		
			if(document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html")
			{
				document.forms[0].target = "_self";
			}else{
				document.forms[0].target = "_blank";
			}
			document.forms[0].submit();
		}
	else
	{
		return false;
	}
}
	
function clearViewPage()
{
	document.forms[0].reset();
	//document.getElementById("itemBrandDivId").innerHTML="<select name='strItemBrandId' class='comboNormal'>"+	 "<option title='Select Value' value='0'>All</option></select>";
}

function cancelPage()
{
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}