function validate1()
{	
	
	    var hisValidator = new HISValidator("countryBean");	
		
		hisValidator.addValidation("strCountryName","req", "Country Name is a Mandatory Field" );
		hisValidator.addValidation("strCountryShortName","req", "Country Short Name is a Mandatory Field" );
		hisValidator.addValidation("strNationality","req", "Nationality is a Mandatory Field" ); 
         
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
	    var hisValidator = new HISValidator("countryBean");	
		
		hisValidator.addValidation("strCountryName","req", "Country Name is a Mandatory Field" );
		hisValidator.addValidation("strCountryShortName","req", "Country Short Name is a Mandatory Field" );
		hisValidator.addValidation("strNationality","req", "Nationality is a Mandatory Field" ); 
       	hisValidator.addValidation("strIsValid","req", "IsValid is a Mandatory Field" ); 

         
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