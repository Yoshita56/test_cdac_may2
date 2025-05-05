function addStateMst(mode)
{
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();

}

// For saving the data on Add Page
function validate1(mode)
{   

     
             var hisValidator = new HISValidator("stateMstBean");
             
	          hisValidator.addValidation("strStateName","req", "State Name is a Mandatory Field" );
 	          hisValidator.addValidation("strStateShortName","req", "State Short Name is a Mandatory Field" );
 
            
 		 var retVal = hisValidator.validate(); 

          if(retVal)
          {
     			if(mode.toString()=="Add")
     			{
     					   document.forms[0].hmode.value = "SAVE";	
     			}
                
                if(mode.toString()=="Modify")
                {
     					   document.forms[0].hmode.value = "UPDATE";	
     			}
                 	   
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

function addStateMst(mode)
{
	
	
	var strCountryCombo = document.getElementsByName("combo")[0].value;
	
	
          if(strCountryCombo.toString()=="0")
          {
    			alert("Please Select Country");
    			document.getElementsByName("combo")[0].focus;
    			return false;	
          }
	      else
	      {
	      	
	 			document.forms[0].hmode.value = mode;
				document.forms[0].submit();
	         
	      }

}
