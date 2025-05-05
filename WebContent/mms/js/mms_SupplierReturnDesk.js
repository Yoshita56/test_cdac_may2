function cancelPage(){
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
}

function chkUserDefinedFunc(these){
	
	var checkCount=0;
	var indx;
	var check=document.getElementsByName("chk");
	for(i=0;i<check.length;i++)
	{
		if(check[i].checked==true)
		{
			checkCount++;
			indx=i;
		}	
	}
	
	if((checkCount==1) && (document.forms[0].combo[1].value == "1"))
	{
		enableButton("View");
		var myArray =new Array();
		myArray=(check[indx].value).split("@");
	/*	if(myArray[5]=="0")
		  enableButton("Cancel");
		else
		  disableButton("Cancel");  */
		enableButton("Modify");
		//disableButton("Request");	
		disableButton("Return");	
	}
    else if((checkCount==1) && (document.forms[0].combo[1].value == "2"))
	{
		enableButton("View");	
		disableButton("Return");
		//disableButton("Request");
		disableButton("Modify");	
		//disableButton("Cancel");	
	}
	else if((checkCount==1) && (document.forms[0].combo[1].value == "3"))
	{
		enableButton("View");
		//disableButton("Request");	
		disableButton("Modify");	
		enableButton("Return");	
		//disableButton("Cancel");	
	}
	else if((checkCount==1) && (document.forms[0].combo[1].value == "4"))
	{
		enableButton("View");
		//disableButton("Request");
		disableButton("Modify");	
		disableButton("Return");	
		//disableButton("Cancel");	
	}
	else if((checkCount==1) && (document.forms[0].combo[1].value == "5"))
	{
		enableButton("View");
		//disableButton("Request");
		disableButton("Modify");		
		disableButton("Return");	
		//disableButton("Cancel");	
	}
	else
	{
		//enableButton("Request");
		disableButton("View");	
		disableButton("Return");
		disableButton("Modify");		
		//disableButton("Cancel");	
	}
}

function comboEvent()
{
        //enableButton("Request");
		disableButton("View");	
		disableButton("Return");
		disableButton("Modify");		
		//disableButton("Cancel");	
}
function callPage1(form1,mode){
	
	cmbVal="";
	var retVal=false;
	if(document.forms[0].combo[0].value != "0")
	{
		retVal=true;
	}
	else
	{
		alert("Please Select Drug Warehouse Name from Store Combo");
		retVal=false;
	}
	if(retVal==true)
	{
	   with(form1)
	   {
	     /*   if( mode == "REQUEST")
	        {
			  cmbVal =combo[0].options[combo[0].selectedIndex].text;
			   comboValue.value = cmbVal;
	            document.forms[0].hmode.value="REQUEST";
	             document.forms[0].submit();
			}
			if( mode == "CANCEL_REQUEST")
	        {
			  cmbVal =combo[0].options[combo[0].selectedIndex].text;
			   comboValue.value = cmbVal;
			    res=prompt("ENTER REMARKS FOR REQUEST CANCELLATION","");
                 if(res!="")
                 {
                    with(form1)
                    {
                        var check=document.getElementsByName("chk");
                        var indexStr;
                        var checkCount=0;
	                    for(i = 0;i < check.length;i++)
	                    {
	                        if(check[i].checked==true)
	                        {
		                        checkCount++;
		                        indexStr=i;
	                        }	
	                    }
                        check[indexStr].value=check[indexStr].value.concat("#"+res);
                    }
                    alert("Reject Value->"+check[indexStr].value);
                    sts = confirm("Are you sure");
                    if(sts==true)
                    {
                        document.forms[0].hmode.value="CANCEL_REQUEST";
	                    document.forms[0].submit();
                    }
                 }
                 else
                 {
                     alert("No Remark entered, enter Remark & then continue");
                 }
			}*/
			if( mode == "MODIFY")
	        {
			  cmbVal =combo[0].options[combo[0].selectedIndex].text;
			   comboValue.value = cmbVal;
	            document.forms[0].hmode.value="MODIFY";
	             document.forms[0].submit();
			}
			if( mode == "RETURN")
	        {
			  cmbVal =combo[0].options[combo[0].selectedIndex].text;
			   comboValue.value = cmbVal;
	            document.forms[0].hmode.value="RETURN";
	             document.forms[0].submit();
			}
			if( mode == "VIEW")
	        {
			  cmbVal =combo[0].options[combo[0].selectedIndex].text;
			   comboValue.value = cmbVal;
	            document.forms[0].hmode.value="VIEW";
	             document.forms[0].submit();
			}
	   }
	}
}

