function validate1()
{	
	    var hisValidator = new HISValidator("labMstBean");	
		
		
 	    hisValidator.addValidation("strLabName", "req","Lab Name is a mandatory field");
 	    hisValidator.addValidation("strLabUserNo","req", "Lab No is a Mandatory Field" );
 	    hisValidator.addValidation("strLabType","dontselect=0","Please Select Lab Type");
 	    //hisValidator.addValidation("strPhoneNo","req", "Phone No is a Mandatory Field" );
 	     
         
         
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

function validate2()
{	
	var hisValidator = new HISValidator("labMstBean");	
	
	
	    hisValidator.addValidation("strLabName", "req","Lab Name is a mandatory field");
	    hisValidator.addValidation("strLabUserNo","req", "Lab No is a Mandatory Field" );
	    hisValidator.addValidation("strLabType","dontselect=0","Please Select Lab Type");
	    //hisValidator.addValidation("strPhoneNo","req", "Phone No is a Mandatory Field" );
         
	    var retVal = hisValidator.validate(); 
	 	hisValidator.clearAllValidations();	    
		if(retVal)
		{		      
				document.forms[0].hmode.value = "UPDATE";
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