
// function to show report after save data


function getReport()
{


var issueNo = document.forms[0].strIssueNum.value;
var strId =  document.forms[0].strId.value;


	if(issueNo!="0")
	{
		getIssueDtls('1', strId, issueNo);
	}
	document.forms[0].strIssueNum.value ="0";
}


function cancelIssue()
 {
       	document.forms[0].hmode.value = "CANCELPAGE";
  	    document.forms[0].submit();
 }	
 
function clearIssue()
{
	var url;
	var mode = "INITVAL";
	document.forms[0].hmode.value=mode;
	document.forms[0].submit();
}




 
function getItemCat(){ 

		if(document.forms[0].strStoreId!=null) {
			if(document.forms[0].strStoreId.value=="" || document.forms[0].strStoreId.value=="0") {
				document.getElementById("itemcatDivId").innerHTML="<select name ='strItemCat' class='comboNormal' ><option value='0'>Select Value</option></select>";
				return;
			}
		} else {
			document.getElementById("itemcatDivId").innerHTML="<select name ='strItemCat' class='comboNormal' ><option value='0'>Select Value</option></select>";
			return;
		}
		//alert(document.forms[0].strStoreId.value);
		var url ="IssueEmployeeTransCNT.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
 		ajaxFunction(url,"1");
		
		
}

function getPrevIssueDtl(){
		var url ="IssueEmployeeTransCNT.cnt?hmode=PREVISSUEDTL&strId="+document.forms[0].strId.value+"&itemCategory="+document.forms[0].itemCategory.value+"&empNo="+document.forms[0].empNo.value;
 		ajaxFunction(url,"2");
	
}


var objGlobal = "";

function getIssuePopUp(these , index){ 

		objGlobal = these;
		
		var url ="IssueEmployeeTransCNT.cnt?hmode=ISSUEDTLPOPUP&strId="+document.forms[0].strId.value+"&issueNo="+document.getElementById("strIssueNo"+index).value;
 		ajaxFunction(url,"3");
		
}

function getAjaxResponse(res,mode){
	
	if(mode=="1"){ 
		if(res=="")
		{
			document.getElementById("itemcatDivId").innerHTML="<select name ='strItemCat' class='comboNormal' ><option value='0'>Select Value</option></select>";
		}
		else
		{
			var objVal= document.getElementById("itemcatDivId");
			objVal.innerHTML = "<select name ='strItemCat' class='comboNormal' >"+res+"</select>";		
		}
	}	
	
	if(mode=="2"){ 
			
				var objVal= document.getElementById("issueDivId");
			
				objVal.innerHTML = res;	
					
		}
		
	if(mode=="3"){ 
			var objVal= document.getElementById("issueDtlId");
			objVal.innerHTML = res;
			display_popup_menu(objGlobal,"issueDtlId",'','');       
		}	
		
	
}

function hideIssueDetails(divId)
{
      hide_popup_menu(divId);
}


function initGoFunc(eve)
{
    var flag=validateData(eve,5);
	if(flag)
	{
			if(eve.keyCode==13)
			{
				onGoButton();
			}
	}
	else
	{
		return false;
	}
  
  
}

function goFuncOnEnter(e)
{
   if(e.keyCode == 13)
   {
	 onGoButton();
	}
	else
	{
	 return false;
	}
} 


function onGoButton(){


	var hisValidator = new HISValidator(document.forms[0].name);

	hisValidator.addValidation("strStoreId", "dontselect=0","Select Drug Warehouse Name from Drug Warehouse Combo ");
	hisValidator.addValidation("strItemCat", "dontselect=0","Select Item Category from Item Category Combo");
	hisValidator.addValidation("strEmployeeNo", "req","Select Employee No.");
	
	var retVal = hisValidator.validate(); 
	hisValidator.clearAllValidations();
	
	document.forms[0].storeName.value    = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	document.forms[0].itemCatName.value    = document.forms[0].strItemCat[document.forms[0].strItemCat.selectedIndex].text;
	document.forms[0].empNo.value = document.forms[0].strEmployeeNo.value;
	
	document.forms[0].strId.value = document.forms[0].strStoreId.value;
	document.forms[0].itemCategory.value = document.forms[0].strItemCat.value;
	
	if(retVal){
			document.forms[0].hmode.value = "INITVALGO";
			document.forms[0].submit();
		
		}else{
		return false;
	}
}


function getPatDtl() {
    
  		document.getElementById("patientDetailsDivId").style.display="block";
  		document.getElementById("minus1").style.display="block";
  		document.getElementById("plus1").style.display="none";
} 
function getPatDtl1() {
   
   		document.getElementById("patientDetailsDivId").style.display="none";
  		document.getElementById("minus1").style.display="none";
  		document.getElementById("plus1").style.display="block";
}
   
function disPrevIssueDtl()
{     
  
   		document.getElementById("issueDivId").style.display="block";
   		document.getElementById("minus2").style.display="block";
  		document.getElementById("plus2").style.display="none";
   		
   
}
function disPrevIssueDtl1(){  
 
   		document.getElementById("issueDivId").style.display="none";
   		document.getElementById("minus2").style.display="none";
  		document.getElementById("plus2").style.display="block";
  		
} 

function getItemSelectPopup(){

		var strModeVal 					= "3" ; 
		var strItemCategory 			= document.forms[0].itemCategory.value; 
	
		var strFromStoreId 				= document.forms[0].strId.value;
		var strRequestType				= "34";
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strReqQty','strUnitName','strCostFinal');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t','s','t');
		
		var strMultiRowFetchDataArray 	= new Array('1','11','4','0^strUnitName^invokeCheckQty');
		
		var layerIndex = "1";
		searchItems( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex);
}

function invokeCheckQty(mode, index, unitObject){
		
		if(checkQty(index,'strReqQty','strUnitName')){
		
			calculateCost(mode, 'strReqQty', 'strUnitName', 'strCostFinal', index, 'strApproxAmt' , '1')
		
		}
						 
} 


function validateIssue()
{

 	var hisValidator = new HISValidator(document.forms[0].name);

	hisValidator.addValidation("strPrescribedBy", "dontselect=0","Select Approved By Combo ");
	hisValidator.addValidation("strPrescriptionDate","date","Please Select Prescription Date" );
 	hisValidator.addValidation("strPrescriptionDate","dtltet="+document.forms[0].strCtDate.value,"Please Select Prescription Date Less Than or Equal To Current Date");
	//hisValidator.addValidation("strGroupIdForItemSearch", "dontselect=0","Select Group Combo ");
	
	
	var retVal = hisValidator.validate(); 
	hisValidator.clearAllValidations();
	
	
	  var itemParVal  = document.getElementsByName("itemParamValue");

      var unitNameCmb = document.getElementsByName("strUnitName");

      var bkgQty  = document.getElementsByName("strReqQty");
      
      var myArray   = new Array();

      var myArray1  = new Array();

      var bkgQtyVal="0";
      
      var count = 0;
     if(retVal)
    {  
       if(itemParVal.length > 1)
       {
       for(var x=0;x<itemParVal.length-1;x++)
       {
          hisValidator.addValidation("strReqQty","req","Required Quantity is a Mandatory Field" );
	      hisValidator.addValidation("strUnitName","dontselect=0","Please select a value from Unit Name Combo");
	      hisValidator.addValidation("strReceiveBy", "req","Select Recieve By ");
          var retVal1 = hisValidator.validate(); 
          hisValidator.clearAllValidations();
          if(retVal1)
          {
	            myArray = itemParVal[x].value.split("^");
	            myArray1 = unitNameCmb[x].value.split("^");
	            count = count +1;
			}else {
		      return false;
          }
      }
        if(count>0)
        {
                                                  var conf = confirm("You Are Going To Save Records");
								                  if(conf == true)
								                  {
								                       var conf1 = confirm("Are you sure !!!");
								                       if(conf1 == true)
								                       {
								 						    document.forms[0].hmode.value = "INSERT";
														    document.forms[0].submit();
								                       }
								                      else
								                       {
								                         return false;
								                       }
								                   }
								                  else
								                   {
								                         return false;
								                   }    
        }
       
    }
       else
	  { 
	      alert("Please Select Item from Search Utility!!!");
		  return false;
	  }	            
		}else{
			return false;
		}
	}
 

   