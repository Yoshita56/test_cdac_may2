/** This is the validate function for Breakage Item Details jsp file
 *  i.e:- add_BreakageItemDtlTrans_mms.jsp and 
 *  transfer control to the controller 'INSERT' method.  
 */
 
 function validate1()
 {
     
	  var hisValidator = new HISValidator("indentReturnBean");  
	  hisValidator.addValidation("strRemarks", "req", "Remarks is a Mandatory Field" );
	  hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	  var retVal = hisValidator.validate(); 
	  
      if(retVal)
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
	    else
	    {
		  return false;
		}
 }

function cancelToDesk()
{
  var mode="CANCEL";
 
  document.forms[0].hmode.value=mode;
  document.forms[0].submit();
}
function hideItemDetails(divId)
{
      hide_popup_menu(divId);
}
function callingPoPUp(parent,i,strHiddenValue,reqTypeId)
{
  
    Return(parent,i,strHiddenValue);
}


function Return(parent,i,strHiddenValue)
{
   myArray = strHiddenValue.split("^");
            
        //strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strItemId+"^"+strItemBrandId+
        //"^"+strStockStatusCode+"^"+strAvlQtyUnit+"^"+strSancQtyUnit;
        var objVal1 = document.getElementById("14");
        if(myArray[0]!='null' ||myArray[0]!='')
        {
         
          objVal1.innerHTML = myArray[0];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("15");
        
        if(myArray[1]!='null')
        {
         
          objVal2.innerHTML = myArray[1]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        
        var objVal3 = document.getElementById("16");
        
        if(myArray[2]!='null')
        {
         
          objVal3.innerHTML = myArray[2]; 
        }
        else
        {
          objVal3.innerHTML = "  ----";
        }  
        
        
        display_popup_menu(parent,'Return','200','');

}



