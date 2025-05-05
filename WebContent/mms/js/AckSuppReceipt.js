
function userDefinedOnLoadFunc()
{
	 
}
function buttonLogicsOnRecordCheck(these)
{  

     //  alert(document.forms[0].chk.checked);
       var chkObj  = document.getElementsByName("chk");
       var count = parseInt("0");
   	   for(var i=0; i<chkObj.length; i++) 
   	   {
   	   //  alert(chkObj[i].checked);
   	  		if(chkObj[i].checked)
   	  		{
   	 		  count = count + 1;
   	 	    }	
   	 	     	 	       	 	    	
   	   }
   	   if(count > 1)
   	   {
   	     alert("Plz Select Single Record at a time!!!!!");
   	     for(var i=0; i<chkObj.length; i++) 
   	     {
   	       	chkObj[i].checked=false;
   	  	 }	 	
   	  	 disableButton("View");
	   //  disableButton("Return");
		// disableButton("Cancel"); 	    	
   	     return false;
   	   }
       else if(count == 1)
       {   
         enableButton("View");
       }
       else
    	   disableButton("View"); 
}
function chkUserDefinedFunc(these)
{
    var checkCount=0;
	var check=document.getElementsByName("chk");
	var status = document.forms[0].combo[2].value;
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
			//alert('Status-2-'+status);
	          //1^Active#2^Acknowledged#3^Rejected
	          if(status == '2')
	          {	  
	        	 
	        	  enableButton("Modify");
	        	  enableButton("View");
	        	  disableButton("Acknowledge");
	        	  disableButton("Cancel");
	          }
	          else if(status == '1')
	          {	       
           		 //alert('Status-1-'+status);
	        	  enableButton("View");
	        	  enableButton("Cancel");
	        	  enableButton("Acknowledge");
	        	  disableButton("Modify");
	        	 
	          }
	          else if(status == '3')
	          {	       
           		// alert('Status-3-'+status);
	        	  enableButton("View");
	        	  disableButton("Acknowledge");
	        	  disableButton("Cancel");
	        	  disableButton("Modify");
	          }
        	  else
        	  {
        		  //alert('Status-Else-'+status);
	        	  enableButton("Acknowledge");
	        	  disableButton("View");
	        	  disableButton("Cancel");
	        	  disableButton("Modify");
        	  }
	          
		}		
		else
		{	
			 disableButton("View");
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
        if(modeNo != 7)
		{
		
		   if(document.getElementById("comboid0").value =="0")
		   {
				alert("Please Select Store Name");
				document.getElementById("comboid0").focus();
				return;
			}
			
			if(document.getElementById("comboid1").value =="0")
			{
				alert("Please Select A Item Category");
				document.getElementById("comboid1").focus();
				return;
			}
		
			
			if(document.getElementById("comboid2").value =="0")
			{
				alert("Please Select A Indent Type");
				document.getElementById("comboid2").focus();
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
   	 		 
   	 	 // blanket popup with process icon.
    	 		//displayProgress();
   	 		 
   	 	   	  add(mode); 			
		}
		else
		{
			 //add(mode);
		}

}

function buttonLogicsOnClick1(modeNo, mode , display)
{
	var cmbVal="";
	 var checkCount=0;
        if(modeNo != 7)
		{
		
		   if(document.getElementById("comboid0").value =="0")
		   {
				alert("Please Select Store Name");
				document.getElementById("comboid0").focus();
				return;
			}
		   /*
		   if(document.getElementById("comboid1").value =="0")
		   {
				alert("Please Select Item Category Name");
				document.getElementById("comboid1").focus();
				return;
			}
			*/
    		 var chkObj = document.getElementsByName("chk");
   	 
   			 var count = parseInt("0");
   	 
   	 		 for(var i=0; i<chkObj.length; i++) 
   	 		 {
   	 			if(chkObj[i].checked)
   	 			{
   	 				count = count + 1;
   	 		    }		
   	 		
   	 		 }
   	 		 
   	 		if(count > 1)
   	   	    {
	   	   	     alert("Plz Select Single Record at a time!!!!!");
	   	   	     for(var i=0; i<chkObj.length; i++) 
	   	   	     {
	   	   	       	chkObj[i].checked=false;
	   	   	  	 }	 		   	   	      	
	   	   	     return false;
   	   	    }
   	 		
   	 	    if(count!=0 && count == '1')   	   	
			{
	   	 		 
	   	 		var status = document.forms[0].combo[2].value;
	   	 		 
	   	 		if(status != '2')
	   	 		{
		   	 		cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text+"@"+document.forms[0].combo[1].options[document.forms[0].combo[1].selectedIndex].text;
				    document.forms[0].comboValue.value = cmbVal;
		   	 	   	add(mode);
	   	 		}
	   	 		else
	   	 		{
	   	 			alert(" Record Already Acknowledged !!");
	   	 			return false;
	   	 		}
			}
	   	 	else
	   	 	{
	   	 	    alert(" Select Record For Acknowledged !!");
	 			return false;
	   	 	}
		}
		else
		{
			 //add(mode);
		}

}
function buttonLogicsOnClick2(modeNo, mode , display)
{
       if(modeNo != 7)
		{
		
		   var chkObj = document.getElementsByName("chk");
   	 
   			 var count = parseInt("0");
   	 
   	 		 for(var i=0; i<chkObj.length; i++) 
   	 		 {
   	 			if(chkObj[i].checked)
   	 			{
   	 				count = count + 1;
   	 		    }		
   	 		
   	 		 }
   	 		 
   	 	 // blanket popup with process icon.
    	 		//displayProgress();
   	 	   	  add(mode); 			
		}
		else
		{
			 //add(mode);
		}

}

function buttonLogicsOnClickCancel(modeNo, mode , display)
{	
		
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
   	 		       chkObj[i].value = chkObj[i].value+"^"+res;
   	 		   }		
   	 		 }
             
             // blanket popup with process icon.
    	 		//displayProgress();
             
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




function buttonLogicsOnClickReturn(modeNo, mode , display)
{
	   if(modeNo != 7)
		{
		   if(document.getElementById("comboid0").value =="0")
		   {
				alert("Please Select Store");
				document.getElementById("comboid0").focus();
				return;
			}
			
			if(document.getElementById("comboid1").value =="0")
			{
				alert("Please Select A Item Category");
				document.getElementById("comboid1").focus();
				return;
			}
			
			if(document.getElementById("comboid2").value =="0")
			{
				alert("Please Select A Indent Type");
				document.getElementById("comboid2").focus();
				return;
			}
			
//			if(document.getElementById("comboid3").value !="0")
//			{
//				alert("Please Select Status");
//				document.getElementById("comboid3").focus();
//				return;
//			}
    		 var chkObj = document.getElementsByName("chk");
   	 
   			 var count = parseInt("0");
   	 
   	 		 for(var i=0; i<chkObj.length; i++) 
   	 		 {
   	 	
   	 				if(chkObj[i].checked)
   	 				{
   	 			
   	 					count = count + 1;
   	 			
   	 				}		
   	 		
   	 			}
   	 		
   	 	 if(count > 1)
   		 {
   	 		alert("Please Select A Single Record");
   	 		return false;
   		  }
   		  else
   		  {
   			  
   			 // blanket popup with process icon.
     	 		//displayProgress();
     	 		
   		     add(mode);
   		  }
   		 
   	    }
   	    else
   	    {
   	     return false;
   	    }
   	    
  } 	    

function buttonLogicsOnClickPrint(modeNo, mode , display)
{
  var retVal = false;
 
	    if(modeNo == 5)
		{
		   if(document.getElementById("comboid0").value =="0")
		   {
				alert("Please Select Store");
				document.getElementById("comboid0").focus();
				disableButton("Print");
				return;
			}
			
    		 retVal = true;
   		     
   		}
   		
   		if(retVal)
   		{
   		  enableButton("Print");
   		  document.forms[0].target = "_self";
   		  add(mode);
   		document.forms[0].target = "_self";
   		}
   		else
   	    {
   	     return false;
   	    }
} 	 


function buttonLogicsOnClickModify(modeNo, mode , display)
{
  var retVal = false;
 
	    if(modeNo == 6)
		{
		   if(document.getElementById("comboid0").value =="0")
		   {
				alert("Please Select Ack By !!");
				document.getElementById("comboid0").focus();
				disableButton("Modify");
				return;
			}
			
    		 retVal = true;
   		     
   		}
   		
   		if(retVal)
   		{
   		  enableButton("Modify");
   		  document.forms[0].target = "_self";
   		  add(mode);
   		  document.forms[0].target = "_self";
   		}
   		else
   	    {
   	     return false;
   	    }
} 	    





