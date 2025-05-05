
function validate1()
{	
	var hisValidator = new HISValidator("smsMobileSetupMstFB");	
	
	
	    hisValidator.addValidation("strReqTypeId", "req","Process Name is a mandatory field");
	    //hisValidator.addValidation("strPhoneNo","req", "Phone No is a Mandatory Field" );
	    hisValidator.addValidation("strPhoneNo", "maxlen=1500", "Mobile No. should have less than or equal to 1500 Characters" );
	    
         
	    var retVal = hisValidator.validate(); 
	 	hisValidator.clearAllValidations();	    
		if(retVal)
		{		      
				document.forms[0].hmode.value = "SAVE";
				document.forms[0].submit();
		
		}
		else
		{
		  return false;
		}
		
}

function clearMsg(strTmp)
{
	document.forms[0].hmode.value = strTmp;
	document.forms[0].submit();
}


function getMobileNos()
{
	var mode = "GETMOBILENOS";
	
       
        
        //alert("document.forms[0].strItemCategoryId.value"+document.forms[0].strItemCategoryId.value);
        
        document.forms[0].hmode.value = "GETMOBILENOS"
 		document.forms[0].submit();
	
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
       var objVal = document.getElementById("strPhoneNoDivId");
       objVal.innerHTML = res ;
    }  
    
}