function ClearPage()
{
    document.forms[0].reset();
    document.getElementById("ExistingBatchId").innerHTML = "<select class='comboNormal' name='strExistingBatchId' onChange='enableNewBatch();'><option value='0'>Select Value</option></select>";
	
}





function savedata() 
{
	       //alert("save data entered");
	       var hisValidator = new HISValidator("HelpDeskTransBean");
	        hisValidator.addValidation("strpriority", "dontselect=0","Please Select Priority");
	        hisValidator.addValidation("strprobsub", "req", "Please Enter the Problem Subject");
	        hisValidator.addValidation("strprobdesc", "req", "Please Enter the Problem Discription");
	        hisValidator.addValidation("strsubmitby", "req", "Please Enter the Submitted By");
	        
	        
	        hisValidator.addValidation("strprobdesc","maxlen=100", "Issue Discription should have less than or equal to 100 Characters" );
	        
		    var retVal = hisValidator.validate();
		    hisValidator.clearAllValidations();
           
	if (retVal) 
	{
		
			document.forms[0].hmode.value = "INSERT";
			document.forms[0].submit();
			//alert("save data finished ret val entered");
	} 
	else 
	{
		return false;
	}
		  
	} 


function cancel() {
	document.forms[0].hmode.value = "RETURNTODESK";
	document.forms[0].submit();
}




 
	 /**
	  * showView
	  * @param {String} divId 
	  */
	  function showView(divId) {
	  	
	  	document.getElementById(divId+"PlusId").style.display = "none";
	  	document.getElementById(divId+"MinusId").style.display = "block";
	  	
	  	document.getElementById(divId).style.display = "block";
	  	
	  }
	 	 
	 	 
	 /**
	  * hideView
	  * @param {String} divId 
	  */
	  function hideView(divId) {
	  	
	  	document.getElementById(divId+"PlusId").style.display = "block";
	  	document.getElementById(divId+"MinusId").style.display = "none";
	  	
	  	document.getElementById(divId).style.display = "none";
	  	
	  }	 
	 	 



function onLoadFunction()
{
	
	if(document.forms[0].combo[1].value=='0')
	{
		 document.getElementById("GroupNameCmbDiv").style.display = "block";
	  	 document.getElementById("GroupNameDiv").style.display = "none";
	}
	else
	{
		 document.getElementById("GroupNameDiv").style.display = "block";
		 document.getElementById("GroupNameCmbDiv").style.display = "none";
	  	
	}
}

function initGoFunc(eve)
{
    var flag=validateData(eve,5);
	if(flag)
	{
			if(eve.keyCode==13)
			{
				goFunc();
			}
	}
	else
	{
		return false;
	}
  
  
}
 







