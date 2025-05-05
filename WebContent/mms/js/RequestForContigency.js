/** This is the validate function for Breakage Item Details jsp file
 *  i.e:- add_BreakageItemDtlTrans_mms.jsp and 
 *  transfer control to the controller 'INSERT' method.  
 */
 
 function validate1()
 {
     
	  var hisValidator = new HISValidator("requestForContigency");  
	  hisValidator.addValidation("strGroupIdForItemSearch","dontselect=0","Please select a value from Group Name Combo" );
	  hisValidator.addValidation("strGrantType","dontselect=0","Please select a value from Grant Type Combo" );
	  hisValidator.addValidation("strToStore","dontselect=0","Please select a value from To Store Combo" );
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
	      alert("Please Select Item from Search Utility!!!");
		  return false;
	  } 
	}
	else
	{
	  return false;
	}   
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


function CallFunc()
{
  var sum = 0;
  var x = document.getElementsByName("itemUserValue");
  for(var i = 0 ; i < x.length-1; i ++)
  {
    var temp = x[i].value.split("^");
    var finalExpAmt = parseInt(temp[10]);
    var sum1  = parseInt(sum);
    sum = manipulateValue(sum1,finalExpAmt,0);
  }
 var id = document.getElementById("ApproxAmtDivId");
 id.innerHTML =parseInt(sum);
 
}
function cancelToDesk()
{
  var mode="CANCEL";
 
  document.forms[0].hmode.value=mode;
  document.forms[0].submit();
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
     objVal.innerHTML = "<select name = 'strItemCategoryCmb' id='strItemCategoryCmb' class='comboNormal'>" + res + "</select>";
    }  
}

function initPage()
{
  document.forms[0].strToStore.value        = '0';
  document.forms[0].strGrantType.value      = '0';
  document.forms[0].strGroupIdForItemSearch.value = '0';
  document.getElementById("id1").style.display="none";
  document.getElementById("errMsg").innerHTML = "";
  var id = document.getElementById("ApproxAmtDivId");
  id.innerHTML ="0.00";
  //document.forms[0].hmode.value="unspecified";
  //document.forms[0].submit();
}

function OnLoadFunction()
{
  //document.forms[0].strToStore.value         = document.forms[0].strTmpToStore.value;
  //document.forms[0].strGrantType.value       = document.forms[0].strTmpGrantType.value;
}
//-----------JS FUNCTIONS from JSP file-------------------------//
function goFunc()                //  for CR No. field validation
{
    
        var hisValidator = new HISValidator("requestForContigency");  
	 	hisValidator.addValidation("strCrNo", "req", "CR No. is a Mandatory Field" );
		hisValidator.addValidation("strCrNo", "minlen="+document.forms[0].strCrNo.maxLength,"CR No. must be "+document.forms[0].strCrNo.maxLength+" Digits" );
		var retVal = hisValidator.validate();
		
		document.forms[0].strTmpCrNo.value            = document.forms[0].strCrNo.value;
		document.forms[0].strTmpToStore.value         = document.forms[0].strToStore.value;
		document.forms[0].strTmpGrantType.value       = document.forms[0].strGrantType.value;
		document.forms[0].strTmpItemCatg.value        = document.forms[0].strItemCatg.value;
	    
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
