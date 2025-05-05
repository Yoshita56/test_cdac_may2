function buttonLogicsOnClickGenerate(modeNo, mode , display)
{
        cmbVal="";
		    if(document.getElementById("comboid0").value =="0")
		    {
				alert("Please Select A DDW Name");
				document.getElementById("comboid0").focus();
				return;
			}	    		
			
			cmbVal =document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
			document.forms[0].comboValue.value = cmbVal;
   	 	   	  add(mode); 
		    
		

}



function buttonLogicsOnClickModify(modeNo, mode , display)
{
        cmbVal="";
		    if(document.getElementById("comboid0").value =="0")
		    {
				alert("Please Select A DDW Name");
				document.getElementById("comboid0").focus();
				return;
			}	    		
			
			cmbVal =document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
			document.forms[0].comboValue.value = cmbVal;
			
			var chkObj = document.getElementsByName("chk");
   	 
   			 var count = parseInt("0");
   	 
   	 		 for(var i=0; i<chkObj.length; i++) 
   	 		 {
   	 			if(chkObj[i].checked)
   	 			{
   	 				count = count + 1;
   	 		    }		
   	 		
   	 		 }
   	 		 
   	 		 if(count==1)
			 {
   	 	   	  add(mode);
			 }
			 else
			 {
			 	alert("Please Select Single Record to modify!!");
			 	return false;
			 } 
		    
		

}



function buttonLogicsOnClickView(modeNo, mode , display)
{
        cmbVal="";
		    if(document.getElementById("comboid0").value =="0")
		    {
				alert("Please Select A DDW Name");
				document.getElementById("comboid0").focus();
				return;
			}	    		
			
			cmbVal =document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
			document.forms[0].comboValue.value = cmbVal;
			
			var chkObj = document.getElementsByName("chk");
   	 
   			 var count = parseInt("0");
   	 
   	 		 for(var i=0; i<chkObj.length; i++) 
   	 		 {
   	 			if(chkObj[i].checked)
   	 			{
   	 				count = count + 1;
   	 		    }		
   	 		
   	 		 }
   	 		 
   	 		 if(count==1)
			 {
   	 	   	  add(mode);
			 }
			 else
			 {
			 	alert("Please Select Single Record to modify!!");
			 	return false;
			 } 
		    
		

}

function buttonLogicsOnClickCancel(modeNo, mode , display)
{
	cmbVal="";
    if(document.getElementById("comboid0").value =="0")
    {
		alert("Please Select A DDW Name");
		document.getElementById("comboid0").focus();
		return;
	}	    	
    var chkObj = document.getElementsByName("chk");
   	 
   	var count = parseInt("0");
   	 
   	for(var i=0; i<chkObj.length; i++) 
    {
   	 	
   	 				if(chkObj[i].checked)
   	 				{
   	 			
   	 					count = count + 1;
   	 			
   	 				}		
   	 		
   	}
   	if(count!=0 && count == '1') 
   	{
   	     res=prompt("ENTER REMARKS FOR CANCELATION!","");
         if(!res=="")
         {
           var conf = confirm("Are you sure !!!");
           if(conf == true)
           {
             var chkObj = document.getElementsByName("chk");  
             for(var i=0; i<chkObj.length; i++) 
   	 	     {
   	 	       if(chkObj[i].checked)
   	 		   {
   	 		       chkObj[i].value = chkObj[i].value+"$"+res;
   	 		   }		
   	 		 }
             
             // blanket popup with process icon.
    	 		displayProgress();
             
   	 		 add(mode);
           }
           else
           {
             return false;
           }
           
          }
          else
          {
           if(res=="")
           { 
            alert("Enter remarks for rejection");
           } 
          }
      }
      else
      {
           if(res=="")
           { 
            alert("Enter remarks for rejection");
           } 
           else
           {
             if(count>1)
                   alert("Please Select Single Record at a Time!!!");
               else
                   alert("Please Select Record !!!!!");
             
           } 
          return false;
      }
   	
			
}		



function chkUserDefinedFunc(these)
{
    var checkCount=0;
	var check=document.getElementsByName("chk");
	for(i=0;i<check.length;i++)
	{
		if(check[i].checked==true)
		{
			checkCount++;
		}			
	}
	try
	{    
		
		if(checkCount==1)
		{	    
		   enableButton("View");	 
          var status  = document.getElementById("comboid1").value;                
	           if(status == "0")
	           {
	             enableButton("Generate");
	             enableButton("Modify");
	             disableButton("Acknowledge");
	             enableButton("Cancel");
	            
	             return;
	           }
	           else
	           {  
	              if(status =="45")
		          {
				     enableButton("Generate");
		             disableButton("Modify");
		             enableButton("Acknowledge");
		             disableButton("Cancel");
		            
				    return;
		          }
	          
	              return;
	            }  
           
		} 
		else
		{
		         enableButton("Generate");
	             disableButton("Modify");
	             disableButton("Acknowledge");
	             disableButton("Cancel");		        
		}
		
	}
	catch(Err)
	{
		alert(Err);
	}
}


function buttonLogicsOnClickModify(modeNo, mode , display)
{
        
		    if(document.getElementById("comboid0").value =="0")
		    {
				alert("Please Select A DDW Name");
				document.getElementById("comboid0").focus();
				return;
			}			
			
				
    		 var chkObj = document.getElementsByName("chk");
   	 
   			 var count = parseInt("0");
   	 
   	 		 for(var i=0; i<chkObj.length; i++) 
   	 		 {
   	 			if(chkObj[i].checked)
   	 			{
   	 				count = count + 1;
   	 		    }		
   	 		
   	 		 }
    	 		
    	 	if(count==1)
		    {	 
   	 	   	  add(mode); 
		    }
		    else
		    {
		    	alert("Please Select Only one Record !!!");
		    	return false;
		    }			
		
		

}


function cancelPage(){
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
}

function getCmbValView(){
	
	
	if(document.forms[0].strComboVal.value == '0'){
		document.getElementById('ackDtlDivId').style.display="none";
	}else if(document.forms[0].strComboVal.value == '1'){
		document.getElementById('ackDtlDivId').style.display="block";
	}
}
function callPage1(form1,mode){
	
	cmbVal="";
	
	if(document.forms[0].combo[0].value == "0"){
		alert("Please Select Drug Warehouse Name from Drug Warehouse Combo");
	}else{
	with(form1){
	if( mode == "ACKNOWLEDGE" && document.forms[0].combo[0].value!="0" ){
			cmbVal =combo[0].options[combo[0].selectedIndex].text;
			comboValue.value = cmbVal;
	document.forms[0].hmode.value="ACKNOWLEDGE";
	document.forms[0].submit();
			}
		}
	}
}

function viewAcknowledge(){
		
	document.forms[0].hmode.value="VIEW";
	document.forms[0].submit();
			
}



function cancelToDesk()
{
	document.forms[0].hmode.value="RETURNTODESK";
	document.forms[0].submit();
}

function validate2(){


	var hisValidator = new HISValidator("acknowledgeTransBean");
	hisValidator.addValidation("strRemarks", "req", "Remarks is mandatory" );
	hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
				
	var retVal = hisValidator.validate(); 
	hisValidator.clearAllValidations();
	
	if(retVal)
	{
		             
		               var conf = confirm("You Are Going To Acknowledge Records");
					                  if(conf == true)
					                  {
					                       var conf1 = confirm("Are you sure !!!");
					                       if(conf1 == true)
					                       {
					                          document.forms[0].hmode.value = "INSERT";
                                              document.forms[0].submit();
					                       }
					                      else
					                       {
					                         return false;
					                       }
					                   }
					                  else
					                   {
					                         return false;
					                   }
			                
	}		
	else
	{
		return false;
	}
}

function changeCombo(obj){
	
	if(obj[0].value == '0' || obj[1].value == '0'){
		
			disableButton("Acknowledge");
			disableButton("View");
	}
}
function printData(){
	document.forms[0].hmode.value = "PRINT";
	document.forms[0].submit();
}

// function to show report after save data

function getReport()
{


var strAckStatus = document.forms[0].strAckStatus.value;
var strStoreId =  document.forms[0].strStoreId.value;
var strTransNo =  document.forms[0].strTransNo.value;

	if(strAckStatus!="0")
	{
		getIssueDtls('4', strStoreId, strTransNo);
	}
	document.forms[0].strAckStatus.value ="0";
}