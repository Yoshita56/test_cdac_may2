/* Java Script for Return From Patient and Staff */

/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 24/April/2009
 * Mod Date : 11/Jun/2009
 * 
 */

// For CrNo Length
function goFunc()  
{
	var hisValidator = new HISValidator("returnFromTransBean");

	hisValidator.addValidation("strStoreId" , "dontselect=0" , "Select Drug Warehouse Name");
	hisValidator.addValidation("strItemCategoryNo" , "dontselect=0" , "Select Drug Category");
	hisValidator.addValidation("strIssueNumber", "req", "Issue No. is a Mandatory Field" );
	//hisValidator.addValidation("strCrNo", "minlen="+document.forms[0].strCrNo.maxLength,"CR No. must be "+document.forms[0].strCrNo.maxLength+" Digits" );
	
	var retVal = hisValidator.validate(); 
	hisValidator.clearAllValidations();
	
	document.forms[0].storeName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	document.forms[0].itemCatName.value = document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].text;
	document.forms[0].crNo.value = document.forms[0].strCrNo.value;
	
	document.forms[0].strId.value = document.forms[0].strStoreId.value;
	document.forms[0].itemCategory.value = document.forms[0].strItemCategoryNo.value;
	
	
	
	if(retVal){
	        
			document.forms[0].hmode.value = "validateIssueNumber";
			document.forms[0].submit();
			
		
		}else{
		return false;
	}
}


    /**
	   * initGoFunc
	   * @param {Event} eve 
	   */
function initGoFunc(eve)
{
   var flag=validateData(eve,5);
	if(flag)
	{
			if(eve.keyCode==13)
			{
				goFunc();
				
			}
	}
	else
	{
			return false;
	}
}

//------------If Enter Key Press--------------//
function goFuncOnEnter(e)
{
   if(e.keyCode == 13)
   {
	 goFunc();
	}
	else
	{
	 return false;
	}
}  

// function for Patient Demographic Detail to block or hide
function ftn11()
{     
   if(document.forms[0].button1.value != 1 )
   {
    document.getElementById("patientDetailsDivId").style.display="block";
    document.getElementById("minus1").style.display="block";
    document.getElementById("plus1").style.display="none";
    document.forms[0].button1.value = 1;
   }
   else
   {
    document.getElementById("minus1").style.display="none";
    document.getElementById("plus1").style.display="block";
    document.getElementById("patientDetailsDivId").style.display="none";
    document.forms[0].button1.value = 0;
   } 
  
}

// Item Category associate with Store Name
function itemCategoryCombo()
{
	if(document.forms[0].strStoreId.value!='0'){
   var mode ="ITEMCATEGORY"; 
   var url="ReturnFromTransCNT.cnt?hmode=ITEMCATEGORY&storeid="+document.forms[0].strStoreId.value
                                  +"&modeVal="+document.forms[0].strMode.value;
   ajaxFunction(url,"1");
   }else{
        objVal= document.getElementById("itemCategoryId");
		  objVal.innerHTML = "<select name ='strItemCategoryNo' id='strItemCategoryNo'><option value='0'>Select Value</option></select>";
   }
} 

function IssueDetails()
{ 
 	var mode ="ISSUEDETAILS";
 	
 	if( (document.forms[0].strIssueNo) && (document.getElementsByName("strIssueNo")[0].value!="" ))
 	{
 		var url="ReturnFromTransCNT.cnt?hmode=ISSUEDETAILS&issueNo="+document.forms[0].strIssueNo.value;	
 	}
    else if( (document.forms[0].strIssueNumber) && (document.getElementsByName("strIssueNumber")[0].value!="") ) 
    {
    	
    	
    	var url="ReturnFromTransCNT.cnt?hmode=ISSUEDETAILS&issueNo="+document.getElementsByName("strIssueNumber")[0].value;	
    	
    }
 	
//    var url="ReturnFromTransCNT.cnt?hmode=ISSUEDETAILS&issueNo="+document.forms[0].strIssueNo.value;
    ajaxFunction(url,"2");
    
}

function getAjaxResponse(res,mode)
{
	var objVal;
	if(mode=="1")
	{	
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
        {
          objVal= document.getElementById("itemCategoryId");
		  objVal.innerHTML = "<select name ='strItemCategoryNo' id='strItemCategoryNo'>" + res + "</select>";
        }
    }
    
    if(mode=="2")
	{
		var err = document.getElementById("errMsg");
				
		var temp1 = res.split("####");
			         
        if(temp1[0] == "ERROR")
        {
         	err.innerHTML = temp1[1];	
        }else
        {
        
			var Temp = res.split("@@@");
			var temp = Temp[0].split("^"); 
					
			document.getElementById("issueDivId").style.display="block";
			//var temp = res.split("^");
			document.getElementById("issueDtDivId").innerHTML = "<input type='hidden' name='strIssueDate' value='"+temp[0]+"'/>"+temp[0];
			document.getElementById("deptNameDivId").innerHTML = "<input type='hidden' name='strDepartmentUnitName' value='"+temp[1]+"'/>"+temp[1];
			document.getElementById("consultantNameDivId").innerHTML = temp[2];
			
			document.getElementById("id1").style.display="block";
			document.getElementById("itemDetailsNewDivId").innerHTML = Temp[1];
		//	alert(document.getElementById("itemDetailsNewDivId").innerHTML );
			clear();
			
			if(document.forms[0].strReturnQtyUnitId)
			{
				var returnQtyObj = document.getElementsByName("strReturnQtyUnitId");
				
				for(var i=0;i<returnQtyObj.length;i++)
				{
					//alert("hello 1:::");
//					returnQtyObj[i].options[returnQtyObj[i].selectedIndex].text=;
				}
			}
		}
		
	}
}
function clear()
{
	if(document.forms[0].strIssueNo)
	{
		if(document.forms[0].strIssueNo.value == '0')
		document.getElementById("issueDivId").style.display="none";
	}
	if(document.forms[0].strIssueNumber)
	{
		if(document.forms[0].strIssueNumber.value=='0')
		{
			document.getElementById("issueDivId").style.display="none";
		}	 
	}

}
	
	
// On bodyLaod function
/*function checkOnOffLineFlag()
{
   
   document.forms[0].strStoreId.value = document.forms[0].strStoreID.value;
     
   if(document.forms[0].strCatgName.value =='')
   {
       document.getElementById("itemCategoryId").style.display = "block";
   }
   else
   {
    	document.getElementById("itemCategoryId").style.display = "none";
   		var  label = document.getElementById("itemCatId");
        label.style.display ="block";
        label.innerHTML =  document.forms[0].strCatgName.value;
   }
     
    if(document.forms[0].strCrNo.value!='')
       {
       		document.getElementById("All").style.display="block";
       		document.getElementById("detailsdivid1").style.display="block";
       		document.getElementById("minus1").style.display="block";
            document.getElementById("plus1").style.display="none";
            document.getElementById('strStoreId').disabled=true;
       }
    if(document.forms[0].strMode.value=='1')
    {
      document.getElementById("Staff").style.display="block";
      document.getElementById("Patient").style.display="none";
      document.getElementById("Staff1").style.display="block";
      document.getElementById("Patient1").style.display="none";
      
    }
   
    else
    {
     document.getElementById("Patient").style.display="block";
     document.getElementById("Staff").style.display="none";
     document.getElementById("Patient1").style.display="block";
     document.getElementById("Staff1").style.display="none";
    }
}  */
/*function initPage()
{
  document.getElementById("All").style.display="none";
  document.getElementById("strStoreId").value='0';
  document.getElementById('strStoreId').disabled=false;
  document.getElementById("strItemCategoryNo").value='0';
  document.getElementById("itemCategoryId").style.display = "block";
  document.getElementById("itemCatId").style.display = "none";
  document.forms[0].strCrNo.value="";
  document.getElementById("errMsg").innerHTML = "";
}*/
function clearIssue()
{
	var url;
	var mode = "unspecified";
	document.forms[0].hmode.value=mode;
	document.forms[0].strCrNo.value="";
	document.forms[0].submit();
}

     
// called on select a checkbox
/*function ClickCheckBox(obj,i)
{
	if(document.getElementById('strReturnQty'+i).disabled==true)
	{
		document.getElementById('strReturnQty'+i).disabled=false;
		document.getElementById('strReturnQtyUnitId'+i).disabled=false;
	}
	else
	{
		document.getElementById('strReturnQty'+i).disabled=true;
		document.getElementById('strReturnQtyUnitId'+i).disabled=true;
		document.getElementById('strReturnQty'+i).value = "";
		document.getElementById('strReturnQtyUnitId'+i).value = "0";
	}
}*/



// To cancel the Page:
 function cancel()
 {
    document.getElementById("errMsg").innerHTML = "";
    document.forms[0].hmode.value = "CANCEL";
    document.forms[0].submit();
 }
 
 function quantityUnitValue(index)
{
	if(document.getElementById('strReturnQtyUnitId'+index).value!='0'){
	
		var balQty = document.getElementById('strBalQty'+index).value;
		var returnQty = document.getElementById('strReturnQty'+index).value;
		var returnUnit = document.getElementById('strReturnQtyUnitId'+index).value;
		
		var temp = returnUnit.split('^');
		
		var returnValue = parseFloat(returnQty) * parseFloat(temp[1]);
		if(returnValue>parseFloat(balQty))
		{
			
			alert("Return Quantity must be less than Balance Quantity");
			document.getElementById('strReturnQty'+index).value = "";
			document.getElementById('strReturnQtyUnitId'+index).value = "0"
			document.getElementById('strTotalCost'+index).value = "0.00";
			document.getElementById('strNetCost').value = "0.00";		
			return false;
		}else{
					
			var qty = document.getElementById('strReturnQty'+index).value;
			var unit = document.getElementById('strReturnQtyUnitId'+index).value;	
			
			var unitBase = unit.split('^');
			var costValue1 = parseFloat(qty) * parseFloat(unitBase[1]);
			
		
			var rateIndex = document.getElementById('strRate'+index).value;
			var rateValues = rateIndex.split('@');
			
			var costValue2 = parseFloat(rateValues[0]) / parseFloat(rateValues[2]);
			
			
			var cost = costValue1 * costValue2;
			
			cost = roundValue(cost, 2);
			
			document.getElementById('strTotalCostDivId'+index).innerHTML = cost;
			document.getElementById('strTotalCost'+index).value = cost;
			
			
			var netCost = 0;
			var totalCost = document.getElementsByName('strTotalCost');
			var length = totalCost.length;
			
			for(var i=0;i<length;i++)
			{
				var costVal = totalCost[i].value;
				netCost = netCost + parseFloat(costVal);
				
			}
			
			netCost = roundValue(netCost,2);
			document.getElementById('strNetCostDivId').innerHTML = netCost;
			document.getElementById('strNetCost').value = netCost;	
				//alert("netCost-->"+document.getElementById('strNetCost').value);
		}
	}
	checkUnitQty(index);	
}


function checkUnitQty(index) {

		var returnQty = document.getElementById('strReturnQty'+index).value;
		var returnUnit = document.getElementById('strReturnQtyUnitId'+index).value;
		
		var temp = returnUnit.split('^');
		
		var returnValue = parseFloat(returnQty) * parseFloat(temp[1]);

			if (returnQty.indexOf('.') > -1 && temp[0] != '0') {

			alert("Qty must be an Integer ");
			document.getElementById('strReturnQty'+index).value = "";
			document.getElementById('strReturnQtyUnitId'+index).value = "0"
			return false;
			}
			

}



function openItemName(obj,index)
{

        var strItemDetail = document.getElementById("strItem"+index).value;     
       	       
        myArray = strItemDetail.split("@");
       
        document.getElementById("popUpItemId").innerHTML="Item Details";
              
        var objVal1 = document.getElementById("1");
       
        if(myArray[0]!='null' || myArray[0]!='')
        {
          objVal1.innerHTML = myArray[0];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("2");
        
        if(myArray[1]!='null' || myArray[1]!='')
        {
          objVal2.innerHTML = myArray[1]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        
        var objVal3 = document.getElementById("3");
        
        if(myArray[2]!='null' || myArray[2]!='')
        {
          objVal3.innerHTML = myArray[2];; 
        }
        else
        {
          objVal3.innerHTML = "  ----";
        }  
        
        display_popup_menu(obj,'itemDtlId','','');
        	
	
}


function openBalQty(obj,index)
{
	    var strBalQty = document.getElementById("balQty"+index).value;     
       	       
        myArray = strBalQty.split("@");
       
        document.getElementById("popUpBalId").innerHTML="Balance Qty Details";
              
        var objVal1 = document.getElementById("4");
       
        if(myArray[0]!='null' || myArray[0]!='')
        {
          objVal1.innerHTML = myArray[0];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("5");
        
        if(myArray[1]!='null' || myArray[1]!='')
        {
          objVal2.innerHTML = myArray[1]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        
               
        display_popup_menu(obj,'balQtyId','300','');


} 
function closeItemPopUp(divId)
{
 	hide_popup_menu(divId);
}

function validate1()
{
	 var hisValidator = new HISValidator("returnFromTransBean");
	 hisValidator.addValidation("strIssueNo","dontselect=0","Select Issue No" );
   //  hisValidator.addValidation("strRecommendedBy","dontselect=0","Select Recommended By" );
     hisValidator.addValidation("strReturnQtyUnitId","dontselect=0","Select Unit Id" );
     hisValidator.addValidation("strReturnQty","req","Return Quantity is a Mandatory Field" );
    // hisValidator.addValidation("strRecommendDate", "date","Recommend Date is a mandatory field");
	 //hisValidator.addValidation("strRecommendDate", "dtgtet=${returnFromTransBean.strCtDate}" , "Recommend Date should be Equal to Current Date");
     
  var retVal = hisValidator.validate();
          if(retVal)
          {
          	      var conf = confirm("You Are Going To Save Records");
		          if(conf == true)
		          {
		               var conf1 = confirm("Are you sure !!!");
		               if(conf1 == true)
		               {	              
								
					              document.forms[0].hmode.value="INSERTWithoutCrNo";
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
          else
          {
           		return false;
          }		
}

function onCheckCategory(){

	
	var patientDtlHidVal = document.forms[0].strPatientDtlHidVal.value;
	var temp = patientDtlHidVal.split('^');
	
	
	if(document.forms[0].strMode.value == '0'){
	
			if(document.forms[0].strConfCatCode.value == temp[3]){
				document.getElementById("allDivId").style.display="none";
				alert("Go to Staff Counter....");
				document.forms[0].hmode.value = "unspecified";
				document.forms[0].submit();
				return false;
			
			}
			
	}else if(document.forms[0].strMode.value == '1'){
	
			if(document.forms[0].strConfCatCode.value != temp[3]){
			document.getElementById("allDivId").style.display="none";
				alert("Go to Patient Counter....");
				document.forms[0].hmode.value = "unspecified";
				document.forms[0].submit();
				return false;
			
			}
		}
	
}

 
			
function searchFunc()  
{
	var hisValidator = new HISValidator("returnFromTransBean");

	hisValidator.addValidation("strStoreId" , "dontselect=0" , "Select Drug Warehouse Name");
	hisValidator.addValidation("strItemCategoryNo" , "dontselect=0" , "Select Drug Category");
//	hisValidator.addValidation("strIssueNumber", "req", "Issue No. is a Mandatory Field" );
	//hisValidator.addValidation("strCrNo", "minlen="+document.forms[0].strCrNo.maxLength,"CR No. must be "+document.forms[0].strCrNo.maxLength+" Digits" );
	
	var retVal = hisValidator.validate(); 
	hisValidator.clearAllValidations();
	
	
	
	
	document.forms[0].storeName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	document.forms[0].itemCatName.value = document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].text;
//	document.forms[0].crNo.value = document.forms[0].strCrNo.value;
	
	document.forms[0].strId.value = document.forms[0].strStoreId.value;
	document.forms[0].itemCategory.value = document.forms[0].strItemCategoryNo.value;
	
//	
	
	
	
	if(retVal)
	{
			document.forms[0].hmode.value = "SEARCH";
			document.forms[0].submit();
	}
	else
	{
		return false;
	}
}	
		
function searchFuncOnEnter(e)
{
   if(e.keyCode == 13)
   {
	 searchFunc();
	}
	else
	{
	 return false;
	}
}  


// function for Patient Demographic Detail to block or hide
function ftn11()
{     
   if(document.forms[0].button1.value != 1 )
   {
    document.getElementById("patientDetailsDivId").style.display="block";
    document.getElementById("minus1").style.display="block";
    document.getElementById("plus1").style.display="none";
    document.forms[0].button1.value = 1;
   }
   else
   {
    document.getElementById("minus1").style.display="none";
    document.getElementById("plus1").style.display="block";
    document.getElementById("patientDetailsDivId").style.display="none";
    document.forms[0].button1.value = 0;
   } 
  
}


function onLoadFuncWithoutCrNo()
{
		if(document.getElementsByName("flagWithoutCrNo")[0].value=="0")
		{
			
		}
		else if(document.getElementsByName("flagWithoutCrNo")[0].value=="1")
		{
			IssueDetails();
			document.getElementById("setSaveClearCancelButtonsId").style.display="";
			document.getElementById("removeCancelButtonId").style.display="none";
			
		}
		
}
