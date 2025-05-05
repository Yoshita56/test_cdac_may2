// This function is used to call the ITEMCATEGORY cnt action which populates the value of group name combo box
function getItemCategoryCmb()
{
	var url;
	var mode = "ITEMCATEGORY";
	url="MiscellaneousConsumptionTransCNT.cnt?hmode="+mode+"&storeComboId="+document.forms[0].strStoreId.value;
				//+"&reqType="+document.forms[0].strRequestType.value; 
 	ajaxFunction(url,"1");

}

// This function is used to call the GROUPNAME cnt action which populates the value of group name combo box
function getGroupCombo()
{
	
	var url;
	var mode = "GROUPNAME";
	
	url="MiscellaneousConsumptionTransCNT.cnt?hmode="+mode+"&itemCatId="+document.forms[0].strItemCategoryId1.value; 
 	ajaxFunction(url,"2");

}

function getAjaxResponse(res,mode)
	{
	
	
	var objVal;
	if(mode=="1"){   
	
			var err = document.getElementById("errMsg");
		 	var temp1 = res.split("####");
			         
        	 if(temp1[0] == "ERROR"){
         		err.innerHTML = temp1[1];	
        	 }
			else{
			objVal= document.getElementById("itemCatDivId");
			objVal.innerHTML = "<select name ='strItemCategoryId1' onchange='getGroupCombo();' class='comboMax'>" +res+ "</select>";
			}
	}
	if(mode=="2")
	{   
	
			var err = document.getElementById("errMsg");
		 	var temp1 = res.split("####");
			         
        	 if(temp1[0] == "ERROR")
        	 {
         		err.innerHTML = temp1[1];	
        	 }
			
		}
	}
	
//used for mandatory field validation.

function validate1() {

   	var hisValidator = new HISValidator("miscellaneousConsumptionBean"); 
  	
   	hisValidator.addValidation("strStoreId","dontselect=0","Please select a Drug Warehouse Name");
   	hisValidator.addValidation("strItemCategoryId1","dontselect=0","Please select an Item Category");
   	//hisValidator.addValidation("strGroupIdForItemSearch","dontselect=0","Please select a Group Name");
   	hisValidator.addValidation("strRemarks","maxlen=100", "Remarks should be equals to 100 Characters");
   	
   	var retVal = hisValidator.validate();
   	
   	 
   	 
   	/* if(retVal)
      {
	   	var itemUsrVal   = document.getElementsByName("itemParamValue");
		var unitNameCmb = document.getElementsByName("strUnitName");
	    var consumQty  = document.getElementsByName("strConsumptionQty");
	    var myArray   = new Array();
	    var myArray1  = new Array();
	    var consumQtyVal="0";
	    for(var x=0;x<itemUsrVal.length-1;x++)
	    {
      //alert("itemParVal"+x+"->"+itemParVal[x].value);
     
           myArray = itemUsrVal[x].value.split("^");
          //alert("unitNameCmb[x]->"+unitNameCmb[x].value);
           myArray1 = unitNameCmb[x].value.split("^");
           consumQtyVal=parseInt(consumQty[x].value)* parseInt(myArray1[1]); 
           if(consumQtyVal>myArray[4])
           {
           		alert("Consumption Qty cannot be greater than Avl Qty!!");
           		retVal=false;
        	 	consumQty[x].value = '0';
        	 	unitNameCmb[x].value = '0';
           } 
       } 
    }*/
   	 if(retVal)
     	 {
     	 	if(document.getElementsByName("itemParamValue").length=="1")
     		{
     			alert("Please Search Item Details");
     			return false;
     		}
     		else
     		{
     			retVal=true;
     		}
     	 }
     	if(retVal)
     	{
     		 hisValidator.addValidation("strConsumptionQty", "req", "Consumption Quantity is a mandatory field" );
    		 hisValidator.addValidation("strConsumptionQty", "amount=7,2", "Consumption Quantity should be in 00000.00 format" );
   			 hisValidator.addValidation("strUnitName","dontselect=0","Please select a Consumption Unit");
     	 	 var retVal = hisValidator.validate(); 
          	 hisValidator.clearAllValidations();
         }   	
         if(retVal)
         {
  		
	  		var itemUsrVal   = document.getElementsByName("itemCalcValue");
			var unitNameCmb = document.getElementsByName("strUnitName");
		    var consumQty  = document.getElementsByName("strConsumptionQty");
		    var myArray   = new Array();
		    var myArray1  = new Array();
		    var consumQtyVal="0";
		    var count = 0;
		    for(var x=0;x<itemUsrVal.length-1;x++)
		    {
		    	myArray=itemUsrVal[x].value;
		    	if(parseFloat(myArray.split("^")[0]) < parseFloat(consumQty[x].value))
		    	{
		    		alert("Consumption Quantity cannot be greater than Avalaible Quantity");
		    		consumQty[x].value = "";
		    		return false;
		    	}
	             if(consumQty[x].value=="" || consumQty[x].value=="0")
	             {
	               count++;
	             }  
	        } 
	        if(count == (itemUsrVal.length-1))
	        {
	        	alert("Consumption Quantity is a mandatory field!!!");
	        	consumQty[0].focus();
	        	return false;
	        }
	        
	       
	       
	              var conf = confirm("You Are Going To Save Records");
	              if(conf == true)
	              {
	                   var conf1 = confirm("Are you sure !!!");
	                   if(conf1 == true)
	                   {
	                   	      document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;					     
							  document.forms[0].hmode.value="SAVE";						  
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
  	else{
  		return false;
  		}
    }
  
/**
 * checkAvailQty - Qty validation.
 * 
 * @param {String}
 *            unitName
 * @param {String}
 *            qtyName
 */
function checkQtyMiscValidation(index, qtyName, unitName)
{

	var unitObj = document.getElementById(unitName + "" + index);
	var qtyObj  = document.getElementById(qtyName + "" + index);
	var unitVal = unitObj.value.split('^')[1];	
	var temp          = document.getElementById("itemCalcValue" + index).value.split("^");
	var avlQtyBaseVal = temp[0];
	
	if (parseInt(avlQtyBaseVal) < (parseInt(qtyObj.value,10)*unitVal)) 
    {
	  alert("Consumption Quantity cannot be greater than Avalaible Quantity");
	  document.getElementById("strConsumptionQty" + index).value = "";
	 
	   return false;
    }

	return true;
}  
  
function invokeCheckQty(mode, index, unitObject)
{	
	        
	        var issueQty      = (parseFloat(document.getElementById("strConsumptionQty" + index).value),10)*(unitObject.value.split("^")[1]);
		   	var temp          = document.getElementById("itemCalcValue" + index).value.split("^");
		    var avlQtyBaseVal = temp[0];
		    
		    
			    if (parseFloat(avlQtyBaseVal) < issueQty) 
			    {
				  alert("Consumption Quantity cannot be greater than Avalaible Quantity");
				  document.getElementById("strConsumptionQty" + index).value = "0";
				 
				   return false;
			    }
	
}	

/*function chkQtyDetl(index,unitObject)
{
	var strTemp = document.getElementById("itemParamValue"+index).value.split("#");
	var strInsertValue = strTemp[2].split("^");	
	if(parseInt(unitObject.value)>parseInt(strInsertValue[7])){
		alert("Consumption Qty cannot be greater than Available Qty");
		unitObject.value="";
	}else{
		checkQty(index,'strConsumptionQty','strUnitName');
	}
		
}*/

  
  function getItemSelectPopup(){
  
	  //alert(strModeVal);
  		setItemDtlWithIssueQty();
  		
  		var strModeVal 		= "7" ; 
		var strItemCategory = document.getElementsByName("strItemCategoryId1")[0].value ; 
		var strRequestType 	= "54";
		var strFromStoreId 	= document.forms[0].strStoreId.value;
		var strMultiRowCompArray  = new Array('itemParamValue', 'itemCalcValue','itemUserValue', 'strConsumptionQty','strUnitName');
		
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t','s');
		
		// for mode val 1
		//var strMultiRowFetchDataArray 	= new Array('6','12','3^strUnitName');
		
		// for mode val 2
		//var strMultiRowFetchDataArray 	= new Array('1','11','4','0^strUnitName');
		//var isQuantified 				= "1";
		
		// for mode val 3
		var strMultiRowFetchDataArray 	= new Array('1','11','4','0^strUnitName^invokeCheckQty');
	
		var layerIndex = "1";
		var testFunction                = "";
		//var testFunction                = "CallFunc";
		var arg                         = " ";  
		
		var userInfo = "0";
		var unitMode = "0";  // only base unit  1 Means Only Base Unit Show 0 Means All Unit Show in Unit Combo
		
		searchItemsWithUserFunction( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg , userInfo , unitMode );

}


function setItemDtlWithIssueQty()
{
	
		var itemWithIssueQty = document.getElementById("strItemDtlWithIssueQty");
		var  itemUserVal    = document.getElementsByName("itemUserValue");
	    var issueQty    = document.getElementsByName("strConsumptionQty");
  		//var reqQty      = document.getElementsByName("strReqQty");
  		var unitNameCmb = document.getElementsByName("strUnitName");
  		//var costObj     = document.getElementsByName("strCost");
		  
				
			if(itemUserVal.length > 1)
			{
				
				var tempIssueDtls ; 
				
				for(var i = 0 ; i < itemUserVal.length - 1 ; i++)
				{

															
					if(i == 0 )
					{
						
						tempIssueDtls = itemUserVal[i].value+"@@@@"+issueQty[i].value+"@@@@"+unitNameCmb[i].value	
						
					}
					else
					{
					
						tempIssueDtls = tempIssueDtls+"$$$$"+itemUserVal[i].value+"@@@@"+issueQty[i].value+"@@@@"+unitNameCmb[i].value
					
					}
				
				}
				
				itemWithIssueQty.value = tempIssueDtls;
				
				
			}else{
				itemWithIssueQty.value = "";
					
			}
				
		
	
	}
  
  //Used to cancel the Miscellaneous Consumption page.
function cancel()
 {
     document.getElementById("errMsg").innerHTML = "";
     document.forms[0].hmode.value = "CANCEL";
     document.forms[0].submit();
 }
 
 function Clear()
{
	
	var url;
	var mode = "unspecified";
	document.forms[0].hmode.value=mode;
	document.forms[0].submit();
 	

}