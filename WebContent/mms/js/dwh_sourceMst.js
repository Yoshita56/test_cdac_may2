function validate1()
{	
	    var hisValidator = new HISValidator("sourceBean");	
		
		hisValidator.addValidation("strSourceName","req", "Source Name is a Mandatory Field" );
 	    hisValidator.addValidation("strEffectiveFrom", "date","Effective From is a mandatory field");
 	    hisValidator.addValidation("strEffectiveFrom", "dtgtet="+document.forms[0].strCtDate.value,"Effective From should not be less than Current Date");
        hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
         
         
         
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
	    var hisValidator = new HISValidator("sourceBean");	
		
		hisValidator.addValidation("strSourceName","req", "Source Name is a Mandatory Field" );
 	    hisValidator.addValidation("strEffectiveFrom", "date","Effective From is a mandatory field");
 	    //hisValidator.addValidation("strEffectiveFrom", "dtgtet="+document.forms[0].strCtDate.value,"Effective From should be greater than or equal to Current Date");     
        hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
         
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