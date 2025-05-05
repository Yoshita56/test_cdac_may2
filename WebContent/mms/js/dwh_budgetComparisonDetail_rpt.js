
function validate(){

	var hisValidator = new HISValidator("budgetComparisonDetailRptFB");

	if(document.forms[0].strUserLevel.value=="6")
	hisValidator.addValidation("strDrugWarehouseTypeId","dontselect=0","Please select Institute Type" );


 hisValidator.addValidation("strStoreId","dontselect=-1","Please select a Drug Warehouse Name" );

		hisValidator.addValidation("strStartFinancialYear", "req","Start Financial Year is a mandatory field");
		hisValidator.addValidation("strEndFinancialYear", "req","End Financial Year is a mandatory field");
	
		var strStartFinancialYear =document.getElementsByName("strStartFinancialYear")[0].value.split("");
		var strEndFinancialYear =document.getElementsByName("strEndFinancialYear")[0].value.split("");
		
//	alert("strStartFinancialYear.length"+strStartFinancialYear.length);
//	alert("strEndFinancialYear.length"+strEndFinancialYear.length);
	
		if(strStartFinancialYear.length!=4 || strEndFinancialYear.length!=4)
		{
			alert("Start Financial Year and End Financial Year should be of 4 digit length");
			return false;
		}
		
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

if(retVal)
{

	document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;

	if(parseInt(document.forms[0].strStartFinancialYear.value)>= parseInt(document.forms[0].strEndFinancialYear.value))
	{
		alert("Start Financial Year should be less than the End Financial Year");
		return false;
	}

	  
//	 document.forms[0].strEndFinancialYear.disabled=false;
	
	document.forms[0].strEndFinancialYearTemp.value = document.forms[0].strEndFinancialYear.value;
		
//	document.forms[0].strEndFinancialYear.disabled=true;
	

	
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

function setEndFinancialYear()
{
	document.forms[0].strEndFinancialYear.value=parseInt(document.forms[0].strStartFinancialYear.value)+parseInt("1"); 
}


function getDrugWarehouseName()
{

	var url="BudgetComparisonDetailRptCNT.cnt?hmode=STORECMB&dwhTypeId="+document.forms[0].strDrugWarehouseTypeId.value;
 	ajaxFunction(url,"1");   
	
}




function getAjaxResponse(res,mode)
{
      var err = document.getElementById("errMsg");
      var temp = res.split("####");
      if(temp[0] == "ERROR")
	   {
          	err.innerHTML = temp[1];
          	return;
       } 

    if(mode=="1")
    {
       var objVal = document.getElementById("strStoreDivId");
       
       objVal.innerHTML = "<select name = 'strStoreId'>" + res + "</select>";
    }    
}



function onLoadPage()
{

	document.forms[0].strDrugWarehouseTypeId.value = "0";
	document.forms[0].strStoreId.value = "0";

}


