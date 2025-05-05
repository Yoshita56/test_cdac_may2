
            /******************************************************************************************
			 *                                Process Name : Supplier Return                          *
			 ******************************************************************************************
			 * File Name       : supplier_return_req.js                                               *
			 * Module Name     : MMS                                                                  *
			 * Developer       : Deepak Tiwari                                                        * 
			 * Version         : 1.0                                                                  * 
			 * Assigned Date   : 1-May-2009                                                           *                                               
			 * Completion Date : 3-May-2009                                                           *
			 * Assigned By     : Ajay Kr. Gupta                                                       *
			 * Changes Made on : 20-May-2009 , 27-May-2009 , 30-May-2009                              *
			 * Hand over date  : 30-May-2009                                                          *
			 ******************************************************************************************
			 *                    Copyright 2009 CDAC Noida, Inc. All rights reserved.                *
			 ******************************************************************************************/
 function validate1()
 {
     
	  var hisValidator = new HISValidator("supplierReturnReqBean");  
	  hisValidator.addValidation("strItemCatCmb","dontselect=0","Please select a value from Item Category Combo" );
	  hisValidator.addValidation("strGroupIdForItemSearch","dontselect=0","Please select a value from Group Name Combo" );
      hisValidator.addValidation("strReturnQty","req","Transfer Qty is a Mandatory Field" );
      hisValidator.addValidation("strUnitName","dontselect=0","Please select a value from Unit Name Combo" );
	  hisValidator.addValidation("strRemarks","req","Remarks is a Mandatory Field" );
	  hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	  var retVal = hisValidator.validate(); 
	  var itemUsrVal  =document.getElementsByName("itemUserValue");
	  var unitNameCmb =document.getElementsByName("strUnitName");
	  var returnQty   =document.getElementsByName("strReturnQty");
	  var myArray     =new Array();
	  var myArray1    =new Array();
	  var returnQtyVal="0";
	  for(var x=0;x<itemUsrVal.length-1;x++)
	  {
	    if(retVal)
	    {
	      myArray=itemUsrVal[x].value.split("^");
	      myArray1=unitNameCmb[x].value.split("^");
	      returnQtyVal=parseInt(returnQty[x].value)* parseInt(myArray1[1]); 
	      if(returnQtyVal>myArray[7])
	      {
	     	alert("Return Qty cannot be greater than Available Qty!!");
	     	retVal=false;
	      }  
	    } 
	  }   
		if(retVal)
		{
			      var conf = confirm("You Are Going To Save Records");
		          if(conf == true)
		          {
		               var conf1 = confirm("Are you sure !!!");
		               if(conf1 == true)
		               {	              
								    validateOnSubmit('2','','');
					                document.forms[0].hmode.value="INSERT";
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
	 



function cancelPage()
{
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
}

function cancel1()
{
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
}
function cancelView()
{
	document.forms[0].hmode.value="LIST";
	document.forms[0].submit();
}
function clearDtl()
{
	document.forms[0].hmode.value="CLEAR";
	document.forms[0].submit();
}

 function validateQtyFor_decNcost(mode,index,strReturnQty,strUnitName,costName,totalCostName)
 {
 	var retValCheckQty=checkQty(index,strReturnQty,strUnitName);
 	var retValCalculateCost;
 	if(retValCheckQty)
 	{
 		retValCalculateCost=calculateCost(mode, strReturnQty, strUnitName, costName, index, totalCostName ,0);
 		retValCalculateCost=true;
 		if(retValCalculateCost)
 		{
 			//document.getElementById("totReturnCostDIV").style.display="block";
 		}
 		else
 		  return false;
 	}
 	else
 	 return false;
 }
  
function unitCmbChng(mode,index,unitObject)
{
	retValCalculateCost=calculateCost(mode, "strReturnQty", unitObject.name,"strReturnCost" , index, "strTotalReturnCost" ,0);
 	retValCalculateCost=true;
 	if(retValCalculateCost)
 	{
 		//document.getElementById("totReturnCostDIV").style.display="block";
 	}
}    