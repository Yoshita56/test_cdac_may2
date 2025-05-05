
function getDetails(obj){
	if(obj.value == '1' || obj.value == '2')
	{
	document.getElementById("inCaseChequeDD").style.display = "block";
	}else{
	document.getElementById("inCaseChequeDD").style.display = "none";
	}
}

function validate1(){   
     
            var hisValidator = new HISValidator("EmdReceivingDtlBean");
            
        	 var  payModeObj = document.forms[0].strPaymentMode[document.forms[0].strPaymentMode.selectedIndex];
            
                hisValidator.addValidation("strSupplierName","dontselect=0","Please Select Supplier Name From The Supplier Combo");
	            hisValidator.addValidation("strTenderNo", "req", "Tender No is a Mandatory Field" );
	            hisValidator.addValidation("strQuotationNo", "req", "Quotation No is a Mandatory Field");
	            hisValidator.addValidation("strReceiptDate", "date","Date of Receipt is a mandatory field");
	            hisValidator.addValidation("strEmdAmount", "req", "EMD Amount is a Mandatory Field");
	            hisValidator.addValidation("strEmdAmount", "amount=9,2", "EMD Amount should be in format (0000000.00)");
	            hisValidator.addValidation("strEmdAmountType","dontselect=0","Please Select EMD Amount Type From The EMD Amount Type Combo");
            	hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
            
            if(payModeObj.value != "3"){
	           
	           	hisValidator.addValidation("strChequeDDNo", "req", "Cheque/DD No is a Mandatory Field" );
                hisValidator.addValidation("strPayableAt", "req", "Payable At is a Mandatory Field" );
                hisValidator.addValidation("strDraweeBankName", "req", "Drawee Bank Name is a Mandatory Field" );
           		hisValidator.addValidation("strChequeDDDate", "date","Cheque/DD Date is a mandatory field");
           		hisValidator.addValidation("strChequeValidity", "date","Cheque Validity is a mandatory field");
           		hisValidator.addValidation("strChequeValidity","dtgtet="+document.forms[0].strChequeDDDate.value,"Please Select Check Validity Greater Than or Equal To Cheque/DD Date");
           }
           
 		    var retVal = hisValidator.validate(); 
			
			hisValidator.clearAllValidations();
			
          if(retVal){
                 	   document.forms[0].hmode.value = "SAVE";
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
 
 function clearDtl(){
 	
 	
 	document.forms[0].hmode.value = "unspecified";
  	document.forms[0].submit();
 
 }