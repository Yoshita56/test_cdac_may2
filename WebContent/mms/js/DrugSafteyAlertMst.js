function cancel()
 {
       // document.getElementById("errMsg").innerHTML = "";
	 	document.forms[0].hmode.value = "CANCEL";
  	    document.forms[0].submit();
 }


function validate1()
{	
	    var hisValidator = new HISValidator("drugSaftyAlertBean");	
		hisValidator.clearAllValidations();
		hisValidator.addValidation("strGroupName", "dontselect=0","Group Name is a mandatory field");
 	    hisValidator.addValidation("strDrugName", "dontselect=0","Drug Name is a mandatory field");
 	  //  hisValidator.addValidation("strEffectiveFrom", "dtgtet=${drugSaftyAlertBean.strCtDate}" , "Effective From should be Greater than or Equal to Current Date");        
        hisValidator.addValidation("strRemarks", "maxlen=50", "Remarks should have less than or equal to 50 Characters" );
         
	    var retVal = hisValidator.validate(); 
			    
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

function validateUpdate()
{
  
        document.forms[0].hmode.value = "UPDATE";
				document.forms[0].submit();
}



function getSubGroupCombo()
{ 
 
   var mode="UNITVAL1";
   var url="DrugSafetyAlertMstCNT.cnt?hmode="+mode+"&GroupId="+document.forms[0].strGroupName.value;
   ajaxFunction(url,"1");
  
}

function getDrugCombo()
{ 
  
   var mode="UNITVAL2";
   
   var url="DrugSafetyAlertMstCNT.cnt?hmode="+mode+"&GroupId="+document.forms[0].strGroupName.value+"&SubGroupId="+document.forms[0].strSubGroupName.value;
   //alert(url);
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
       //alert("Res is:::"+res);
       
        var objVal = document.getElementById("strSubGroupName");
        objVal.innerHTML = "<select name = 'strSubGroupName' class='comboNormal' onChange=\"getDrugCombo();\">" + res + "</select>";
		getDrugCombo();
      
       
     }
   if(mode=="2")
   {
       
        var objVal = document.getElementById("strDrugName");
        objVal.innerHTML = "<select class='comboNormal' name = 'strDrugName'\">" + res + "</select>";

     }
     
}




function getNetAmt()
{
	//alert("Inside::GetNetAmt");
}
	
function getSumOfAmount()
{
	//alert("Get Sum Of Amt");
}