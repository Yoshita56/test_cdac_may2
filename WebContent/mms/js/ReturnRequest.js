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
     
	  var hisValidator = new HISValidator("returnRequest");
	      	  
	  hisValidator.addValidation("strToStore","dontselect=0","To Store Combo is Mandatory" );
  
      hisValidator.addValidation("strUnitName","dontselect=0","Please select a value from Unit Name Combo" );
      hisValidator.addValidation("strRemarks", "req", "Remarks is a Mandatory Field" );
	  	  
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
         		if(document.getElementsByName("strReqQty")[x].value=='')
         		{
         			alert("Request Quantity is a Mandatory Field");
         			saveObj.style.display = '';
         			document.getElementsByName("strReqQty")[x].focus();
         			return false
         		}
         		
         		if(document.getElementsByName("strUnitName")[x].value=='0')
         		{
         			alert("Request Quantity is a Mandatory Field");
         			saveObj.style.display = '';
         			document.getElementsByName("strUnitName")[x].focus();
         			return false
         		}
          hisValidator.addValidation("strRemarks", "req", "Remarks is a Mandatory Field" );
          retVal1 = true;
	      //hisValidator.addValidation("strUnitName","dontselect=0","Please select a value from Unit Name Combo" );
          //var retVal1 = hisValidator.validate(); 
          if(retVal1)
          {
           myArray = itemParVal[x].value.split("^");
           myArray1 = unitNameCmb[x].value.split("^");
           bkgQtyVal=parseInt(bkgQty[x].value)* parseInt(myArray1[1]); 
           if(bkgQty[x].value <= 0)
           {
              bkgQty[x].value = '0';
        	  unitNameCmb[x].value = '0';
              alert("All Request Qty must be Greater than Zero!!");
              saveObj.style.display = '';
              retVal=false;
              return false
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
																
													              document.forms[0].hmode.value="INSERT";
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
 	   retVal=false;
 	}
 	
 }
    else
  	{
  	    saveObj.style.display = '';
		return false;
  	}	
} 


function ftnTick(obj)
{
  if(obj.checked && obj.value=='1')
  {
  	document.forms[0].strRequestStatusFlg.value="0";
  	document.forms[0].strIsUrgent.checked=false;
  }
  else
  {
  	document.forms[0].strRequestStatusFlg.value="1";
  	document.forms[0].strIsNormal.checked=false;
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
   var url="RequestForContigencyCNT.cnt?hmode="+mode+"&modName="+document.forms[0].strDeptCombo.value;
   ajaxFunction(url,"1");
}
function getItemCategory()
{ 
   var mode="UNITVAL1";
   var url="RequestForContigencyCNT.cnt?hmode="+mode+"&modName="+document.forms[0].strStoreNameCmb.value;
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
     objVal.innerHTML = "<select name = 'strItemCategoryCmb' class='comboNormal' id='strItemCategoryCmb'>" + res + "</select>";
    }  
}

function initPage()
{
 // document.forms[0].strToStore.value        = '0';
  document.forms[0].strGrantType.value      = '0';
   document.forms[0].strGroupIdForItemSearch.value = '0';
  document.getElementById("id1").style.display="none";
  document.getElementById("errMsg").innerHTML = "";
 
}

function OnLoadFunction()
{
 // document.forms[0].strToStore.value         = document.forms[0].strTmpToStore.value;
  document.forms[0].strGrantType.value       = document.forms[0].strTmpGrantType.value;
  //document.forms[0].strItemCatg.value        = document.forms[0].strTmpItemCatg.value;
  if(document.forms[0].strGoFlg.value=='1')
  { 
   document.getElementById("All").style.display="block";
   document.getElementById("detailsdivid1").style.display="block";
   document.getElementById("minus1").style.display="block";
   document.getElementById("plus1").style.display="none";
   document.forms[0].button1.value = 1;
  } 

}
//-----------JS FUNCTIONS from JSP file-------------------------//
function goFunc()                //  for CR No. field validation
{
    
        var hisValidator = new HISValidator("returnRequest");  
	 	hisValidator.addValidation("strCrNo", "req", "CR No. is a Mandatory Field" );
		hisValidator.addValidation("strCrNo", "minlen="+document.forms[0].strCrNo.maxLength,"CR No. must be "+document.forms[0].strCrNo.maxLength+" Digits" );
		var retVal = hisValidator.validate();
		
		document.forms[0].strTmpCrNo.value            = document.forms[0].strCrNo.value;
		document.forms[0].strTmpToStore.value         = document.forms[0].strToStore.value;
		document.forms[0].strTmpGrantType.value       = document.forms[0].strGrantType.value;
		//document.forms[0].strTmpItemCatg.value        = document.forms[0].strItemCatg.value;
	    
	    document.forms[0].strCrNo.focus();
		
	    if(retVal)
	    {
	       	  	document.forms[0].hmode.value="GO";
	            document.forms[0].submit();
		}else{
		
		return false;
		}
		
}

    /**
	   * initGoFunc
	   * @param {Event} eve 
	   */
function goRetFunc(obj)

{
     var flag=validateData(obj,5);
     if(flag)
     {

                  if(obj.keyCode==13)

                  {

                        var flag1=goFunc();

                        if(flag1)

                        {

                              document.forms[0].hmode.value="GO";

                              document.forms[0].submit();

                        }

                        else

                        {

                              return false;

                        }

                        

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
function cancel(mode)
{
    document.forms[0].hmode.value=mode;
	document.forms[0].submit();
}
function ftn11(obj)
{     
   if(document.forms[0].button1.value != 1 )
   {
    document.getElementById("detailsdivid1").style.display="block";
    document.getElementById("minus1").style.display="block";
    document.getElementById("plus1").style.display="none";
    document.forms[0].button1.value = 1;
   }
   else
   {
    document.getElementById("minus1").style.display="none";
    document.getElementById("plus1").style.display="block";
    document.getElementById("detailsdivid1").style.display="none";
    document.forms[0].button1.value = 0;
   } 
}
function ftn33(obj)
{     
   if(document.forms[0].button3.value != 1)
   {
    document.getElementById("detailsdivid2").style.display="block";
    document.getElementById("minus3").style.display="block";
    document.getElementById("plus3").style.display="none";
    document.forms[0].button3.value = 1;
   }
   else
   {
    document.getElementById("minus3").style.display="none";
    document.getElementById("plus3").style.display="block";
    document.getElementById("detailsdivid2").style.display="none";
    document.forms[0].button3.value = 0;
   } 
}

function CallFunc()
{
}


function issueQtyValidation(index) 
{
	if (document.getElementById("strUnitName" + index).value != "0"	&& document.getElementById("strReqQty" + index).value != "") 
	{
		var issueQty      = document.getElementById("strReqQty" + index).value;
		var issueQtyUnit  = document.getElementById("strUnitName" + index).value;
		var reqQty        = document.getElementById("strReqQty" + index).value;
		var temp          = document.getElementById("itemCalcValue" + index).value.split("^");
		var avlQtyBaseVal = temp[0];

		if (parseFloat(reqQty) < issueQty)
		{
			alert("Issue Quantity cannot be greater than Requested Quantity");
			document.getElementById("strReqQty" + index).value = "0";
			calculateTotalCost(index);
			return false;
		}
		if (parseFloat(avlQtyBaseVal) < issueQty) 
		{
			alert("Issue Quantity cannot be greater than Avalaible Quantity");
			document.getElementById("strReqQty" + index).value = "0";
			calculateTotalCost(index);
			return false;
		}

	} 
	else 
	{
		if(document.getElementById("strUnitName" + index).value == "0") 
		{
			alert("Please Select Unit!!!");
		}
			
		return false;

	}
	calculateTotalCost(index);
}



function calculateTotalCost(index) 
{      
	  
	    var rateObj = (document.getElementById("itemParamValue"+index).value.split("#")[1]).split("^")[1];
		var qtyObj  = document.getElementById("strReqQty"+index).value;
       					
			var qty    = qtyObj;	
			var rate   = rateObj;
		
			var total  = 0;
		
			if(isNaN(rate) || rate=="") rate = "0";
			if(isNaN(qty)  || qty=="") qty = "0";
			
			total = rate*qty;
			document.getElementById("strCost"+index).value = total;
			
//			totalCostforNewDemand();
			
	return true;
}

function totalCostforNewDemand()
{	   
       	    var costObj = document.getElementsByName("strCost");
			var total = parseFloat("0.00");
			//alert(costObj.length);
		   	if (costObj.length > 0) 
			{
		       
				for ( var i = 0; i <costObj.length; i++)
				{		        	
						
					total = total + parseFloat(costObj[i].value);
		 		}
		
			}

	    total = roundValue(total, 2);
//	    document.getElementById("strNewDemandApproxAmtDivId").value = total;
 //       document.forms[0].strNewDemandFinalApproxAmt.value=total;
       
}

