// Inspection Desk Issue Transaction:

function validate1()
{
	 var hisValidator = new HISValidator("inspectionDeskIssueBean");
           
       // hisValidator.addValidation("strIssueQty","numlt="+document.forms[0].strReceiptQty.value,"Issue Quantity should be less than Receipt Quantity" );
        hisValidator.addValidation("strIssuedUnitId","dontselect=0","Please select Unit Id" );
           
  var retVal = hisValidator.validate(); 
      
          if(retVal){
                       document.forms[0].hmode.value = "INSERT";
                       document.forms[0].submit();
            }else{
           		return false;
			}	
}


 function cancel()
 {
 document.forms[0].hmode.value = "CANCEL";
				document.forms[0].submit();
 }