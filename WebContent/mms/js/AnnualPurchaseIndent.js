/** This is the validate function for Breakage Item Details jsp file
 *  i.e:- add_BreakageItemDtlTrans_mms.jsp and 
 *  transfer control to the controller 'INSERT' method.  
 */
 
function validate1()
 {
 
 	var saveObj = document.getElementById("saveId");
	
	if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	{
	saveObj.style.display = "none"; 	
     
	  var hisValidator = new HISValidator("annualPurchaseIndent");  
	  
	 // hisValidator.addValidation("strGroupIdForItemSearch","dontselect=0","Please select a value from Group Name Combo" );
	  hisValidator.addValidation("strToStore","dontselect=0","Please select a value from To Store Combo" );
	  hisValidator.addValidation("strItemType","dontselect=0","Please select a value from Item Type Combo" );
      hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	  var retVal = hisValidator.validate();
	    
	  var itemParVal  = document.getElementsByName("itemParamValue");
	  

      var unitNameCmb = document.getElementsByName("strUnitName");

      var bkgQty  = document.getElementsByName("strReqQty");

      var myArray   = new Array();

      var myArray1  = new Array();

      var bkgQtyVal="0";

      var count = parseInt("0");
      
      

	    if(retVal)
	    {  	  hisValidator.addValidation("strIndentPeriod","dontselect=0","Indent Period is a Mandatory Field" );
	    
		     if(itemParVal.length > 1)
		     {
					      for(var x=0;x<itemParVal.length-1;x++)
					      {
					         hisValidator.addValidation("strReqQty","req","Required Quantity is a Mandatory Field" );
					         hisValidator.addValidation("strUnitName","dontselect=0","Please select a value from Unit Name Combo" );
					         hisValidator.addValidation("strUnitName","req","Please select a value from Unit Name Combo" );
					         var retVal1 = hisValidator.validate(); 
					          if(retVal1)
					          {
					           myArray  = itemParVal[x].value.split("^");
					           myArray1 = unitNameCmb[x].value.split("^");
					           
					          if(bkgQty[x].value <= 0)
					          {
					              bkgQty[x].value = '0';
					        	  unitNameCmb[x].value = '0';
					              alert("Request Qty must be Greater than Zero!!");
					              retVal=false;
					          }     
					        }
					        else
						    {
						      saveObj.style.display = '';
							  return false;
							} 
					      } 
		     }
					     
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
							                         saveObj.style.display = '';
							                         return false;
							                       }
							                   }
							                  else
							                   {
							                    	 saveObj.style.display = '';
							                         return false;
							                   }
					                
					                
		             
		      
		     
		}
		else
		{
		  saveObj.style.display = '';
		  return false;
		} 
	}	  
    else
    {
          	saveObj.style.display = '';
			return false;
    }	
 }


/*
 function validate1()
 {
 
 	var saveObj = document.getElementById("saveId");
	
	if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	{
	saveObj.style.display = "none"; 	
     
	  var hisValidator = new HISValidator("annualPurchaseIndent");  
	  
	 // hisValidator.addValidation("strGroupIdForItemSearch","dontselect=0","Please select a value from Group Name Combo" );
	 // hisValidator.addValidation("strToStore","dontselect=0","Please select a value from To Store Combo" );
	  hisValidator.addValidation("strItemType","dontselect=0","Please select a value from Item Type Combo" );
      hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	  var retVal = hisValidator.validate();
	    
	  var itemParVal  = document.getElementsByName("itemParamValue");

      var unitNameCmb = document.getElementsByName("strUnitName");

      var bkgQty  = document.getElementsByName("strReqQty");

      var myArray   = new Array();

      var myArray1  = new Array();

      var bkgQtyVal="0";

      var count = parseInt("0");
      
      

	    if(retVal)
	    {  	  hisValidator.addValidation("strIndentPeriod","dontselect=0","Indent Period is a Mandatory Field" );
	    
		     if(itemParVal.length > 1)
		     {
					      for(var x=0;x<itemParVal.length-1;x++)
					      {
					         hisValidator.addValidation("strReqQty","req","Required Quantity is a Mandatory Field" );
					         hisValidator.addValidation("strUnitName","dontselect=0","Please select a value from Unit Name Combo" );
					         hisValidator.addValidation("strUnitName","req","Please select a value from Unit Name Combo" );
					         var retVal1 = hisValidator.validate(); 
					          if(retVal1)
					          {
					           myArray  = itemParVal[x].value.split("^");
					           myArray1 = unitNameCmb[x].value.split("^");
					           
					          if(bkgQty[x].value <= 0)
					          {
					              bkgQty[x].value = '0';
					        	  unitNameCmb[x].value = '0';
					              alert("Request Qty must be Greater than Zero!!");
					              retVal=false;
					          }     
					        }
					        else
						    {
						      saveObj.style.display = '';
							  return false;
							} 
					      }  
					      
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
							                         saveObj.style.display = '';
							                         return false;
							                       }
							                   }
							                  else
							                   {
							                    	 saveObj.style.display = '';
							                         return false;
							                   }
					                
					                
		             
		      
		     }
		      else
			  { 
			      alert("Please Select Item from Search Utility!!!");
			      saveObj.style.display = '';
				  return false;
			  } 
		}
		else
		{
		  saveObj.style.display = '';
		  return false;
		} 
	}	  
    else
    {
          	saveObj.style.display = '';
			return false;
    }	
 }
 */




function hideItemDetails(divId)
{
      hide_popup_menu(divId);
}
var parentPopUp = "";

function getAnnualPurchaseDetails(obj,index)
{    
        parentPopUp = obj;
     // alert(document.getElementById("itemUserValue"+index).value);
        var strUserValue   =  document.getElementById("itemUserValue"+index).value.split("^");
        var strUserValue1  =  document.getElementById("itemParamValue"+index).value.split("^");
        
        var itemName =  strUserValue1[0];
        var poNo    =  strUserValue[12];
        var poDate  =  strUserValue[13];
        var supplierName  =  strUserValue1[5];    
        var recvQty   =  strUserValue1[6];
        var recvDate  =  strUserValue[17];
        var rateUnit  =  strUserValue1[4];
        var currencyName =  strUserValue[28];
       
       var objVal11 = document.getElementById("11");
       
       objVal11.innerHTML = itemName +"-PO Details";
         
       
        var objVal1 = document.getElementById("1");
        
          // objVal1.innerHTML = "-------";
           objVal1.innerHTML = poNo;
            
              
        var objVal2 = document.getElementById("2");
        
        
         // objVal2.innerHTML = "  ----";
         objVal2.innerHTML = poDate;
        
        var objVal3 = document.getElementById("3");
        
         // objVal3.innerHTML = "  ----";
         objVal3.innerHTML = supplierName;
                                   
        var objVal5 = document.getElementById("5");
                
         // objVal5.innerHTML = "  ----";
         objVal5.innerHTML =recvQty;
        
      
        
        var objVal7 = document.getElementById("7");
                
          // objVal7.innerHTML = "------";
          objVal7.innerHTML = rateUnit;
          
                           
			display_popup_menu(parentPopUp,'purchaseDtl','300','');
		
		
	}

function ftnTick()
{
  if(document.forms[0].strIsNormal.value=='1')
   {
     document.forms[0].strIsNormal.checked = false;
     document.forms[0].strIsNormal.value=0;
   }
   if(document.forms[0].strIsNormal.checked == true)
   {
    document.forms[0].strIsNormal.value=1;
    if(document.forms[0].strIsUrgent.checked == true)
    {
       document.forms[0].strIsUrgent.checked = false; 
    }
   }
   else
   {
     document.forms[0].strIsNormal.value=0;
   }
   if(document.forms[0].strIsUrgent.checked == true)
   {
    document.forms[0].strIsUrgent.value=1;
    if(document.forms[0].strIsNormal.checked == true)
    {
       document.forms[0].strIsNormal.checked = false; 
    }
   }
   else
   {
      document.forms[0].strIsUrgent.value=0;
   }
}

function resetValue()
{
  document.forms[0].strIndentPeriod.value         = '0';
  document.forms[0].strIndentPeriodValue.value ="";
  document.getElementById("id1").innerHTML ="";
  document.getElementById("errMsg").innerHTML = "";
  document.forms[0].strApproxAmt.value              = '0.00';
  document.getElementById("strApproxAmtDivId").innerHTML ="0.00";
	
}
function cancelToDesk()
{
  var mode="CANCEL";
 
  document.forms[0].hmode.value=mode;
  document.forms[0].submit();
}

function AjaxFunc()
{
 alert("Inside Ajax Func!!!!");
}
function getUnitCombo()
{ 
   var mode="UNITVAL";
   var url="IssueToPatientTransCNT.cnt?hmode="+mode+"&modName="+document.forms[0].strDeptCombo.value;
   ajaxFunction(url,"1");
}
function getItemCategory()
{ 
   var mode="UNITVAL1";
   var url="IssueToPatientTransCNT.cnt?hmode="+mode+"&modName="+document.forms[0].strStoreNameCmb.value;
   ajaxFunction(url,"2");
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
       var objVal = document.getElementById("GrpNameId");
       objVal.innerHTML = "<select name = 'strUnitCombo' class='comboNormal'>" + res + "</select>";
    }  
    if(mode=="2")
    {
     var objVal = document.getElementById("ItemNameId");
     objVal.innerHTML = "<select name = 'strItemCategoryCmb' id='strItemCategoryCmb' class='comboNormal'>" + res + "</select>";
    }  
}

function initPage()
{
	
 // document.forms[0].strToStore.value              = '0';
  document.forms[0].strIndentPeriod.value         = '0';
 document.forms[0].strIndentPeriodValue.value ="";
  document.getElementById("id1").innerHTML ="";
  document.getElementById("errMsg").innerHTML = "";
  document.forms[0].strApproxAmt.value              = '0.00';
  document.getElementById("strApproxAmtDivId").innerHTML ="0.00";
  clearItemDiv();
} 
function clearItemDiv()
{
 var itemParaObj = document.getElementById("id1");
      itemParaObj.innerHTML = ""; 	
}
function OnLoadFunction()
{
	
}
function cancel(mode)
{
    document.forms[0].hmode.value=mode;
	document.forms[0].submit();
}
