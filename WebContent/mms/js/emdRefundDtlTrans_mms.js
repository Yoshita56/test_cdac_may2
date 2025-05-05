function getEmdDetails(obj){ 

		var url ="EMDRefundDtlTransCNT.cnt?hmode=EMDDetails&supplierId="+obj.value;
 		ajaxFunction(url,"1");
		
	}
	
	function getAjaxResponse(res,mode){
	if(mode=="1"){   
		var objVal= document.getElementById("getEmdDetailId");
		objVal.innerHTML =  res ;
		
	}
}

function onSaveButton(obj,index){
	
	if(obj.checked){
		if(document.forms[0].strSize.value=="1"){
			document.forms[0].strRemarks.disabled = false;
			}else{
				document.forms[0].strRemarks[index].disabled = false;
				}
			}else{
				document.forms[0].strRemarks.disabled = true;
				}
			}

function validate1(){
			
			var hisValidator = new HISValidator("EmdRefundDtlBean");
 			hisValidator.addValidation("strSupplierId","dontselect=0","Please Select Supplier Name From The Supplier Combo");
        	var retVal = hisValidator.validate(); 
        	hisValidator.clearAllValidations();
        	if(retVal){
        		var flag=checkValue();
        	
        		if(flag=="0")
        		{
        			alert("Please Select EMD Detail");
        			return false;
        		}
        	}
        	if(retVal){
        	hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	    	var retVal = hisValidator.validate(); 
	  		hisValidator.clearAllValidations();
	  		}
	   		if(retVal){  
	   		
	   			document.forms[0].hmode.value = "SAVE";
       			document.forms[0].submit();
			}else{
            	 return false;
     	 }
      }
	
function cancel()
 {
        document.getElementById("errMsg").innerHTML = "";
	 	document.forms[0].hmode.value = "CANCEL";
  	    document.forms[0].submit();
 }
function clearDtl(){

	document.forms[0].hmode.value = "unspecified";
  	document.forms[0].submit();

}

function checkValue(){

	cmbVal="";
	var chk_temp	=	document.getElementsByName("strChkValue").length;
	var chk			=	"";
	 var flag="0";
	if(!isNaN(chk_temp))
	{
		if(parseInt(chk_temp)>1)
		{
			for(var i=0;i<chk_temp;i++)
			{
				if(document.forms[0].strChkValue[i].checked==true) {
					flag="1";
				}
				else
				{
					flag="0";
				}
			}
		}
		else if(parseInt(chk_temp)==1)
		{
			if(document.forms[0].strChkValue.checked==true)
			{
				flag="1";
				
			}
			else
			{
				flag="0";
			}
		}
	}
	return flag;
}
	
