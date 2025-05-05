// Using for Bill Approval Desk Transaction


// call on cancel button 
function cancelPage(){
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
}


// called from UTL PAGE to view or terminate
function chkUserDefinedFunc(these){
	var checkCount=0;
	var flag=false;
	var check=document.getElementsByName("chk");

	for(i=0;i<check.length;i++)
	{
		if(check[i].checked==true)
			checkCount++;
	}
    //alert("checkCount->"+checkCount);
	if(checkCount==1 )
	{
		if(document.forms[0].combo[2].value=="1")
		{
		 // enableButton ("Verify");
		//  enableButton ("Cancel");
		  enableButton ("View");
		  enableButton ("Print");
		}
		else
		{
		 // enableButton ("Verify");
		 // disableButton("Cancel");
		  enableButton ("View");
		  enableButton ("Print");
		}  
		flag=true
	}
	else
	{
		//disableButton ("Verify");
		//disableButton ("Cancel");
		disableButton ("View");
		disableButton ("Print");
	}
}

function comboChangeStatus(obj)
{
   //disableButton("Verify");
   //disableButton("Cancel");
  // disableButton("View");
   /* var obj = document.getElementById("comboid1").value;
    var checkCount=0;
	var check=document.getElementsByName("chk");

	for(i=0;i<check.length;i++){
		if(check[i].checked==true)
			checkCount++;
	}
    if(obj=='1' )
	{
		enableButton ("Verify");
		disableButton("Cancel");
		enableButton("View");
		
	}
	else
	{
	    disableButton("Verify");
		disableButton("Cancel");
		disableButton("View");
	}*/

}
 

function validateBillApproval(form1,mode)
{
	cmbVal1="";
	//cmbVal2="";
	var retVal=true;
	with(form1)
	{
		
		if(document.forms[0].combo[0].value=="0")
		{
			alert("Please Select Store!!");
			retVal=false;
		}
		else
		{
			if(document.forms[0].combo[1].value=="0")
			{
				alert("Please select Supplier!!");
			    retVal=false;
			}
			if(document.forms[0].combo[2].value=="0")
			{
				alert("Please select Bill Type !!");
			    retVal=false;
			}
		}
		if( mode == "BILL" && retVal)
		{
			cmbVal1 =combo[0].options[combo[0].selectedIndex].text;
			cmbVal2 =combo[1].options[combo[1].selectedIndex].text;
			cmbVal3 =combo[2].options[combo[2].selectedIndex].text;
			comboValue.value = cmbVal1+"^"+cmbVal2+"^"+cmbVal3;
			document.forms[0].hmode.value="BILL";
			document.forms[0].submit();
		}
		
		if( mode == "VIEW" && retVal)
		{
			cmbVal1 =combo[0].options[combo[0].selectedIndex].text;
			cmbVal2 =combo[1].options[combo[1].selectedIndex].text;
			cmbVal3 =combo[2].options[combo[2].selectedIndex].text;
			comboValue.value = cmbVal1+"^"+cmbVal2+"^"+cmbVal3;
			document.forms[0].hmode.value="VIEW";
			document.forms[0].submit();
		}
		if( mode == "PRINT" && retVal)
		{
			cmbVal1 =combo[0].options[combo[0].selectedIndex].text;
			cmbVal2 =combo[1].options[combo[1].selectedIndex].text;
			cmbVal3 =combo[2].options[combo[2].selectedIndex].text;
			comboValue.value = cmbVal1+"^"+cmbVal2+"^"+cmbVal3;
			document.forms[0].hmode.value="PRINT";
			document.forms[0].submit();
		}
	}
}
