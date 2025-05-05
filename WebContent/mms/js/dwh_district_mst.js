
function setFocus()
{
	document.forms[0].strCountryId.focus();
}
// For saving the data on Add Page
function validate1()
{   

     
         var hisValidator = new HISValidator("districtMstBean");
         
         hisValidator.addValidation("strCountryId","dontselect=0","Please Select Country Name");
 		 hisValidator.addValidation("strStateId","dontselect=0","Please Select State Name");
         hisValidator.addValidation("strDistrictName","req", "District Name is a Mandatory Field" );
         hisValidator.addValidation("strDistrictShortName","req", "District Short Name is a Mandatory Field" );
         hisValidator.addValidation("strRemarks", "maxlen=50", "Remarks should have less than or equal to 50 Characters" );
 		 		 
            
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


// For saving the data on Modify Page
function validate2()
{   

     
         var hisValidator = new HISValidator("districtMstBean");
         
         hisValidator.addValidation("strDistrictName","req", "District Name is a Mandatory Field" );
         hisValidator.addValidation("strDistrictShortName","req", "District Short Name is a Mandatory Field" );
         hisValidator.addValidation("strRemarks", "maxlen=50", "Remarks should have less than or equal to 50 Characters" );
 		 
            
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


function getStateCmb()
{
	var mode = "GETSTATECMB";
	
        var url ="DistrictMstCNT.cnt?hmode="+mode+"&countryCode="+document.forms[0].strCountryId.value;
 		ajaxFunction(url,"1");
}

function getAjaxResponse(res,mode)
{

      var err = document.getElementById("strErrMsg");
      var temp = res.split("####");
      if(temp[0] == "ERROR")
	   {
          	err.innerHTML = temp[1];
          	return;
       } 


   if(mode=="1")
   { 
     
		if(res=="")
		{
			document.getElementById("stateCmbDivId").innerHTML="<select name ='strStateId' class='comboNormal' ><option value='0'>Data N/A</option></select>";
		}
		else
		{
			var objVal= document.getElementById("stateCmbDivId");
			objVal.innerHTML = "<select name ='strStateId' class='comboNormal' >"+res+"</select>";		
		}
	}	
}

function clearMsg(strTmp)
{
	document.forms[0].hmode.value = strTmp;
	document.forms[0].submit();
}