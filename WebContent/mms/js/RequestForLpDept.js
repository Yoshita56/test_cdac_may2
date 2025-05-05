
/** This is the validate function for Breakage Item Details jsp file
 *  i.e:- add_BreakageItemDtlTrans_mms.jsp and 
 *  transfer control to the controller 'INSERT' method.  
 */
 
 function validate1()
 {
     
	  var hisValidator = new HISValidator("requestForLpDept");  
	  hisValidator.addValidation("strToStore","dontselect=0","Please select a value from To Store Combo" );
	 // hisValidator.addValidation("strGroupIdForItemSearch","dontselect=0","Please select a value from Group Name Combo" );
	  hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	  var retVal = hisValidator.validate(); 
	  
	  var itemParVal  = document.getElementsByName("itemParamValue");

      var unitNameCmb = document.getElementsByName("strUnitName");

      var bkgQty  = document.getElementsByName("strReqQty");

      var myArray   = new Array();

      var myArray1  = new Array();

      var bkgQtyVal="0";
    if(retVal)
    {  
     if(itemParVal.length > 1)
     {
      for(var x=0;x<itemParVal.length-1;x++)
      {
          hisValidator.addValidation("strReqQty","req","Required Quantity is a Mandatory Field" );
	      hisValidator.addValidation("strUnitName","dontselect=0","Please select a value from Unit Name Combo" );
          var retVal1 = hisValidator.validate(); 
          if(retVal1)
          {
           myArray = itemParVal[x].value.split("^");
           myArray1 = unitNameCmb[x].value.split("^");
           if(bkgQty[x].value <= 0){
              bkgQty[x].value = '0';
        	  unitNameCmb[x].value = '0';
              alert("Request Qty must be Greater than Zero!!");
              retVal=false;
          }     
        }
        else
        {
           retVal=false;
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
                 return false;
               }
           }
          else
           {
                 return false;
           }	
      
    }  /*End of  Length*/
    else
	{ 
	      alert("Please Select Item from Search Utility!!!");
		  return false;
	}
	
   }
   else
   {
      retVal=false;
   } 	
     
 }


function hideItemDetails(divId)
{
      hide_popup_menu(divId);
}
var parentPopUp = "";

function getProcurmentDetails(obj,i)
{ 
	//alert("Index is-->>"+i);
/*	
	var itemParVal  = document.getElementsByName("itemParamValue");
	alert("itemParVal.length-->>"+itemParVal.length);
	for(var x=0;x<itemParVal.length-1;x++)
    {
		alert("itemParVal-->>"+x+"-->>"+itemParVal[i].value);
    }
	var myArray   = new Array();
    myArray = itemParVal[i+1].value.split("^");
*/         
        parentPopUp = obj;
    
       // var strApprovedDetail = document.getElementById("strApprovedDtl"+i).value;        
       
       
        var objVal1 = document.getElementById("1");
        
          objVal1.innerHTML = "-------";
            
              
        var objVal2 = document.getElementById("2");
        
        
          objVal2.innerHTML = "  ----";
        
        var objVal3 = document.getElementById("3");
        
          objVal3.innerHTML = "  ----";
        
        var objVal4 = document.getElementById("4");
        
          objVal4.innerHTML = "-------";
                     
        display_popup_menu(parentPopUp,'procurmentDtl','300','');
		
		
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
  document.forms[0].strToStore.value        = '0';
  //document.forms[0].strItemCatg.value       = '0';
 // document.forms[0].strGroupIdForItemSearch.value = '0';
  document.getElementById("errMsg").innerHTML = "";
  document.getElementById("id1").style.display = "none";
}

function OnLoadFunction()
{

}
function CallFunc()
{
}
function cancel(mode)
{
    document.forms[0].hmode.value=mode;
	document.forms[0].submit();
}
