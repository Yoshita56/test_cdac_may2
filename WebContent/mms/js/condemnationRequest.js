
/** This is the validate function for Breakage Item Details jsp file
 *  i.e:- add_BreakageItemDtlTrans_mms.jsp and 
 *  transfer control to the controller 'INSERT' method.  
 */
 
 function validate1()
 {
     
	  var hisValidator = new HISValidator("requestCondemnationTransADDBean"); 
	   
	  hisValidator.addValidation("strToStoreCombo","dontselect=0","Please select To Store Combo" );
	 // hisValidator.addValidation("strGroupIdForItemSearch","dontselect=0","Please select a value from Group Name Combo" );
	  hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	  var retVal = hisValidator.validate(); 
	  
	  var itemParVal  = document.getElementsByName("itemParamValue");

      var unitNameCmb = document.getElementsByName("strUnitName");

      var bkgQty  = document.getElementsByName("strCondemnationQty");

      var myArray   = new Array();

      var myArray1  = new Array();

      var bkgQtyVal="0";
    var count = parseInt("0");
     if(retVal)
     { 
      if(itemParVal.length > 1)
      {
        for(var x=0;x<itemParVal.length-1;x++)
        {
          hisValidator.addValidation("strCondemnationQty","req","Condemnation Quantity is a Mandatory Field" );
	      hisValidator.addValidation("strUnitName","dontselect=0","Please select a value from Unit Name Combo" );
          var retVal1 = hisValidator.validate(); 
          if(retVal1)
          {
           myArray = itemParVal[x].value.split("^");
           myArray1 = unitNameCmb[x].value.split("^");
           bkgQtyVal=parseInt(bkgQty[x].value)* parseInt(myArray1[1]); 
           if(bkgQtyVal>myArray[3])
           {
        	 bkgQty[x].value = '0';
        	 unitNameCmb[x].value = '0';
             alert("Condemnation Qty cannot be greater than InHand Qty!!");
             retVal=false;
            }
            else
            {
                 count = count +1;
            } 
           }
           else
           {
              count = 0; 
              retVal=false;
           }
          
         }
         if(count > 0)
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
 	}
 	else
 	{
 	   retVal=false;
 	}
 }

function initPage()
{
 
  document.forms[0].strToStoreCombo.value = '0';
  document.forms[0].strGroupIdForItemSearch.value = '0';
  document.getElementById("errMsg").innerHTML = "";
  document.getElementById("normalMsg").innerHTML = "";
  document.getElementById("id1").style.display = "none";
}


function cancelToDesk()
{
  var mode="CANCEL";
  document.forms[0].hmode.value=mode;
  document.forms[0].submit();
}