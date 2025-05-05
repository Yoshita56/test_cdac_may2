/**

	JS Function used in committetype
**/
function genrateUnitList()
{
var hisValidator = new HISValidator("debtorRegisterRptFB");

		hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

if(retVal)
{	
	
		   if(document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value!='0')
		   {	
		   	    document.getElementById("showButtonID").style.display="none";
				document.getElementById("consolidatedPODetailDIV").innerHTML = ""; 
				document.getElementById("consolidatedChallanDetailDIV").innerHTML = ""; 
				var mode="GETUNITLIST";
				var url="DebtorRegisterRptCNT.cnt?hmode="+mode+"&StoreId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value;
				ajaxFunction(url,"1");
		   }
		   else
		   {
		   	alert("Please Select Store Name!!!");
		   	return false;
		   }
}		   
else
{
   	return false;
}		   
		   	
}
	
function genratePoChallanHlp(StoreId,IssueNo)
{
	var mode="GETDEBETORDTL";
	var url="DebtorRegisterRptCNT.cnt?hmode="+mode+"&StoreId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+"&fromDate="+document.forms[0].strFromDate.value+"&toDate="+document.forms[0].strToDate.value+"&IssueNo="+IssueNo;
	
	ajaxFunction(url,"2");
}
		

function getAjaxResponse(res, mode) 
{

	var objVal;
	if (mode == "1") 
	{

		objVal = document.getElementById("consolidatedPODetailDIV");
		objVal.innerHTML = res; 
	}
	if (mode == "2") {

		objVal = document.getElementById("consolidatedChallanDetailDIV");
		objVal.innerHTML = res;
		document.getElementById("showButtonID").style.display="block";
		
	}
}

function GetIndex(index,endVal)  // Pagenation  One
{
	
	    for (var page = 1; page <= endVal; page++)       // For Loop To Put Normal CSS in All No
        {
          document.getElementById('pg'+page).className = 'pg-normal';
        }
	    var oldPageAnchor = document.getElementById('pg'+index);   // Apply CSS
        oldPageAnchor.className = 'pg-selected';
        
          for(var i = 1; i <= endVal ; i++)
		  {
			  document.getElementById("DivId"+i).style.display="none";
		  }
		  document.getElementById("DivId"+index).style.display="block";
			 
}
/**
 * 
 */
function chkBoxClick(obj,index)
{	  
	  	 /* Value Pass in Web Row Set
			    	   1. Issue no
			    	   2. Issue Date
		               3. Unit Name
		               4. Indent No
		               5. Indent Date
		               6. Total Value 
		               7. Store ID
		           	 */    	 
	    	 
	   var hiddenVal = document.getElementById("strCheckHidValue"+index).value; 
	   
	   var StoreID    = hiddenVal.split("^")[6];  	
	   var IssueNo    = hiddenVal.split("^")[0]; 
	   // Set Selected Record Value For Show Report Method
       document.forms[0].strProcRelatedValue.value = hiddenVal;
	   
	   genratePoChallanHlp(StoreID,IssueNo);
	         
       	 
       	
      
	
}




function view1(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="none";
	document.getElementById(obj2).style.display="block";
	document.getElementById(obj3).style.display="block";
	document.getElementById("existingDemandId").style.display="block";
	document.getElementById("newDemandId").style.display="none";
}
function view2(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="block";
	document.getElementById(obj2).style.display="none";
	document.getElementById(obj3).style.display="none";
	document.getElementById("existingDemandId").style.display="none";
	document.getElementById("newDemandId").style.display="block";
}


function validate(){

	var hisValidator = new HISValidator("debtorRegisterRptFB");

//		hisValidator.addValidation("strStartFinancialYear", "req","Start Financial Year is a mandatory field");

		hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

if(retVal)
{
	document.forms[0].strStoreId.value =  document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value;  
	document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;

	//document.forms[0].strEndFinancialYear.disabled=false;
	
	//document.forms[0].strEndFinancialYearTemp.value = document.forms[0].strEndFinancialYear.value;
		
	//document.forms[0].strEndFinancialYear.disabled=true;
	
	
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
	 else{
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


