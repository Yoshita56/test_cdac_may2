function validateQty(obj, index) {	
	var avlQty = parseInt(document.getElementById("strAvailQty" + index).value, 10);
	var reqQty = parseInt(document.getElementById("strReqQty" + index).value, 10);
	var sancQty = parseInt(obj.value, 10);	
	if (avlQty > 0) {		
		if(sancQty > avlQty){
			alert("Approved Quantity can not be Greater than  Avl. Qty. [ "+ avlQty + " ] of  store!");
			obj.value = reqQty;					   
			return false;
		}
	} else {
		alert("Drug Quantity Not Available !!!");
		obj.value = "";
		return false;
	}
}

function FuncTick(obj)
{
  if(obj.value == '1')
  {
  	document.getElementById("remarks").innerHTML="Remarks";
  	document.forms[0].strApprovalFlag.value="1";  
    document.forms[0].strApproved.checked = true;
    document.forms[0].strRejected.checked = false;
  }
  else
  {
  	 document.getElementById("remarks").innerHTML="<font color='red'>*</font>Remarks";
  	 document.forms[0].strApprovalFlag.value="2";  
     document.forms[0].strRejected.checked = true;
     document.forms[0].strApproved.checked = false;
  }
  
}

function OnLoadCheck()
{ 
   
      if(document.forms[0].strApprovalFlag.value=='2')
      {
      	 document.forms[0].strApproved.checked = false;
         document.forms[0].strRejected.checked = true;
      } 
      else
      {
      	
        document.forms[0].strApproved.checked = true;
        document.forms[0].strRejected.checked = false;
      }
  
}

function setApprovedQty()
{
	var approvedQty = document.getElementsByName("strInsSancQty");
	var  hlpSancQty = document.getElementsByName("strReqQty");
	if(document.getElementsByName("strRejected")[0].checked)
	{
		for(var i=0;i<approvedQty.length;i++)
		{
			approvedQty[i].value="0";
		}
		
	}
	if(document.getElementsByName("strApproved")[0].checked)
	{
		
		for(var i=0;i<approvedQty.length;i++)
		{			
			
			 approvedQty[i].value = hlpSancQty[i].value;
						
		}
	}
}
function getAjaxResponse(res, mode) {
			
		
}

function clearPage() {
	document.forms[0].reset();
	document.getElementById("errMsg").innerHTML = "";
	document.getElementById("warningMsg").innerHTML = "";
	document.getElementById("normalMsg").innerHTML = "";
}


function validateSave() {
	
	var hisValidator = new HISValidator("transferExcessApprovalTransBean");	
	var strAppFlag = document.forms[0].strApprovalFlag.value;
        if(strAppFlag==2){
        hisValidator.addValidation("strRemarks","req","Remarks is Mandatory" );
        } 
	hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );	
	var sancQtyObj = document.getElementsByName("strInsSancQty");
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	var countChk = 0;
	if (retVal) {
		for ( var x = 0; x < sancQtyObj.length; x++) {

			if (parseInt(sancQtyObj[x].value) > 0) {
				countChk = countChk + 1;
			} 
		}
		
		if(countChk > 0 && strAppFlag==1){
		var conf = confirm("You Are Going To Save!!!");
		if (conf == true) {
			var conf1 = confirm("Are you sure !!!");
			if (conf1 == true) {
				document.forms[0].hmode.value = "insertRecord";
				document.forms[0].submit();
			} else {
				return false;
			}
		} else {
			return false;
		}		
		}
		else if(countChk == 0 &&  strAppFlag==2){
		var conf = confirm("You Are Going To Save!!!");
		if (conf == true) {
			var conf1 = confirm("Are you sure !!!");
			if (conf1 == true) {
				document.forms[0].hmode.value = "insertRecord";
				document.forms[0].submit();
			} else {
				return false;
			}
		} else {
			return false;
		}		
		}
		else{
		alert("Please enter Sanc. Qty for at least one record !!!!");
			return false;
		}
		
	} else {
		return false;
	}
}

function cancel() {
	document.forms[0].hmode.value = 'cancelToList';	
	document.forms[0].submit();
}

function validate1()
{
  if(document.forms[0].strReqTypeId.value!='92')
  {
	    var hisValidator = new HISValidator("transferExcessApprovalTransBean"); 
        var ReqTypeId = document.forms[0].strReqTypeId.value;
        var strAppFlag = document.forms[0].strApprovalFlag.value;
        if(strAppFlag==2){
        hisValidator.addValidation("strRemarks","req","Remarks is Mandatory" );
        }     
	    hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	    var retVal = hisValidator.validate();		  
	    var itemParVal  = document.getElementsByName("strInsertHiddenValue");
        var reqQty      = document.getElementsByName("strInsSancQty");	    
        var count = parseInt("0");
	    if(retVal)
	      {  
	        for(var x=0;x<itemParVal.length;x++)
	        {
	        	
        	      if( (document.getElementsByName("strInsSancQty")[x].value!=0))
		          {
		          	 count = count +1;
		          }
	        }
	        if(count >0)
	        {
	              var conf = confirm("You Are Going To Save Records");
                  if(conf == true)
                  {
                       var conf1 = confirm("Are you sure !!!");
                       if(conf1 == true)
                       {
 						    document.forms[0].hmode.value = "insertRecord";
						    document.forms[0].submit();
                       }
                      else
                       {
                       	saveObj.style.display = '';
                         return false;
                       }
                   }
                  else
                   {
                   		saveObj.style.display = '';
                         return false;
                   }    
	  
	      }
	      else
		  {		  	
            if(strAppFlag==2){
            var conf = confirm("You Are Going To Save Records");
                  if(conf == true)
                  {
                       var conf1 = confirm("Are you sure !!!");
                       if(conf1 == true)
                       {
 						    document.forms[0].hmode.value = "insertRecord";
						    document.forms[0].submit();
                       }
                      else
                       {
                       	saveObj.style.display = '';
                         return false;
                       }
                   }
                  else
                   {
                   		saveObj.style.display = '';
                         return false;
                   } 
            }
            else
            {
            alert("Approved Quantity is a Mandatory Field");		          	 
		  	saveObj.style.display = '';
			return false;
            }            
	      } 
	   } 
	   else {
		return false;
	}    
  }
}
