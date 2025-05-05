function validate1(){   
     
            var hisValidator = new HISValidator("gatePassDetailsBean");
          
            hisValidator.addValidation("strStoreId", "dontselect=0", "Please select a Drug Warehouse Name" );
            hisValidator.addValidation("strGatepassTypeCode", "dontselect=0", "Please select a Gate Pass Type" );
            hisValidator.addValidation("strValidity", "req", "Validity is a mandatory Field" );
            hisValidator.addValidation("strValidity", "numgtet=0", "Validity must be greater than or equal to 0 hours/minutes" );
            if(document.forms[0].strValidityUnit.value=="1"){
            hisValidator.addValidation("strValidity", "numltet=23", "Validity must be less than or equal to 23 hours" );
            }else if(document.forms[0].strValidityUnit.value=="2"){
            hisValidator.addValidation("strValidity", "numltet=59", "Validity must be less than or equal to 59 minutes" );
            }
            hisValidator.addValidation("strIssueBy", "dontselect=0", "Please select a value for Issue By" );
            
            hisValidator.addValidation("strIssuedTo", "req", "Issue To is a mandatory Field" );
		    hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );

            var retVal = hisValidator.validate(); 

          if(retVal){
          
                       document.forms[0].hmode.value = "SAVE";
                       document.forms[0].submit();
          }else{
         hisValidator.clearAllValidations();
             return false;
          }
}
function cancelProcess(){
 document.forms[0].hmode.value = "CANCEL";
 document.forms[0].submit();
}