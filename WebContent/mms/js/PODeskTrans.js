function buttonLogicsOnClick(form, mode , display)
{
  with(form)
  {
            var cmbVal =document.getElementById("comboid0").options[document.getElementById("comboid0").selectedIndex].text;
			comboValue.value = cmbVal;
  	        if(document.getElementById("comboid0").value =="0")
		    {
				alert("Please Select A Store Name");
				document.getElementById("comboid0").focus();
				return;
			}
			
			if(document.getElementById("comboid1").value =="0")
			{
				alert("Please Select A Status");
				document.getElementById("comboid1").focus();
				return;
			}
			if(mode=="ADD" && document.getElementById("comboid1").value !="1")
			{
				alert("Please Select Active Status");
				document.getElementById("comboid1").focus();
				return;
			}
									
   		    add(mode);
	}			
		
}	

    function buttonLogicsOnChangeCombos()
	{
	   if(document.getElementById("comboid1").value =="1")
	   {
		 	   enableButton("Add");
			   disableButton("Modify");
			   enableButton("Schedule");
			   disableButton("Delete");
			   disableButton("Acknowledge");
	    	   disableButton("View");
	    }
	    else
	    {
	           disableButton("Add");
			   disableButton("Modify");
			   disableButton("Schedule");
			   disableButton("Delete");
			   disableButton("Acknowledge");
	    	   enableButton("View");
	    
	    }	   
	}
	function buttonLogicsOnRecordCheck()
    {  
   	 
   	 var chkObj = document.getElementsByName("chk");
   	 
   	 var count = parseInt("0");
   	 
   	 	for(var i=0; i<chkObj.length; i++) {
   	 	
   	 		if(chkObj[i].checked){
   	 			
   	 			count = count + 1;
   	 			
   	 		}		
   	 		
   	 	}
   	 
   	 if(count != 1){
   	 	
   	 	buttonLogicsOnChangeCombos();
   	 	return false;
   	 }
   	    	 
	            enableButton("Add");
			    enableButton("Modify");
			    enableButton("Delete");
			    enableButton("Acknowledge");
	    	    enableButton("View");
	
}
	
	
	