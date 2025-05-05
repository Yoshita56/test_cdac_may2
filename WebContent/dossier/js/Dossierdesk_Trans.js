function chkUserDefinedFunc(these){
	//alert('1');
	var checkCount=0;
	var checkValue="";
	var status;
	var temp;
	var flag=false;
	var check=document.getElementsByName("chk");
	status=document.getElementsByName("combo")[1].value;
	for(i=0;i<check.length;i++){
		if(check[i].checked==true){
			checkCount++;
			//alert(check[i].value);
			temp=check[i].value;
			approved=temp.split("@");
		}			
	}
	if(checkCount==0){
			enableButton("Generate");
			disableButton("Modify");
			disableButton("View");
			disableButton("Cancel");
			
	}
	
	
	if(checkCount==1 && (status==2||status==3))
	{
		enableButton("Modify");
		enableButton("View");
		enableButton("Dossier Settlement");
		
		
	}else if (checkCount==1 && status==1){
		enableButton("Cancel");
		enableButton("View");
		disableButton("Dossier Settlement");
	}
	/*else if(checkCount==1 && status == 4)
	{
		disableButton("Modify");
		disableButton("View");
		
	}
	else
	{
		enableButton("Generate");
		disableButton("Modify");
		disableButton("View");
		disableButton("Print Utility Certificate");
	}*/
	
}

function issueDeskButtonStatus()
{
	
}

function validateIssue()
{
	
	//alert('123');
	var cmbVal="";
	if(document.forms[0].combo[0].value=="0")
	{
		alert("Please Select Service Type");
	}
	else
	{
			cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
			 document.forms[0].comboValue.value = cmbVal;
			document.forms[0].hmode.value="GENERATE";
			document.forms[0].submit();
	}
 
}

function callDossierSettlement()
{
	
	//alert('123');
	var cmbVal="";
	if(document.forms[0].combo[0].value=="0")
	{
		alert("Please Select Service Type");
	}
	else
	{
			cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
			 document.forms[0].comboValue.value = cmbVal;
			document.forms[0].hmode.value="SETTLEMENT";
			document.forms[0].submit();
	}
 
}
function validateReturn(){
	var cmbVal="";
	if(document.forms[0].combo[0].value=="0")
	{
		alert("Please Select Store")
	}
	else
	{
			//alert('1');
			cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
			 document.forms[0].comboValue.value = cmbVal;
			document.forms[0].hmode.value="RETURN";
			document.forms[0].submit();
	}
}


function callViewCnt()
{
	var cmbVal="";
	if(document.forms[0].combo[0].value=="0")
	{
		alert("Please Select Service Type");
	}
	else
	{
			
			if(document.forms[0].combo[1].value=="1"){
				cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
			    document.forms[0].comboValue.value = cmbVal;
				document.forms[0].hmode.value="ISSUEVIEW";
				document.forms[0].submit();
			}else{
				
				cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
			    document.forms[0].comboValue.value = cmbVal;
				document.forms[0].hmode.value="RETURNVIEW";
				document.forms[0].submit();
			}
			
	}
}
/*
function callPrintCnt()
{
	var cmbVal="";
	if(document.forms[0].combo[0].value=="0")
	{
		alert("Please Select Store");
	}
	else
	{
		var i;
		var check=document.getElementsByName("chk");
		status=document.getElementsByName("combo")[2].value;
		for(i=0;i<check.length;i++)
		{
			if(check[i].checked==true)
			{
				if(check[i].value.split("@")[4] == '10' || document.getElementsByName("combo")[1].value !='35')
				{
						alert("Utility Certificate can only be generated for special items which are issued to IPD patients only");
						return false;
				}
				else
				{
			   		  document.forms[0].target = "_blank";
			   		  add('PRINT');
			   		document.forms[0].target = "_self";
				}
			}			
		}
	}
			
	/*		if(document.forms[0].combo[2].value=="1"){
				cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
			    document.forms[0].comboValue.value = cmbVal;
				document.forms[0].hmode.value="ISSUEVIEW";
				document.forms[0].submit();
			}else{
				
				cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
			    document.forms[0].comboValue.value = cmbVal;
				document.forms[0].hmode.value="RETURNVIEW";
				document.forms[0].submit();
			}
			
	}*/
//}
/**
 * This function is used to perform validation during change of combo.
 */
function changeCombo(){
	enableButton("Generate");
			//disableButton("Return");
			disableButton("View");
			disableButton("Cancel");
			disableButton("Print Utility Certificate");
			//alert(document.getElementsByName("combo")[1].value);
			if(document.getElementsByName("combo")[1].value == '1')
			{
				enableButton("Generate");
				disableButton("View");
				disableButton("Modify");
				disableButton("Cancel");
				disableButton("Dossier Settlement");
			}else{
				disableButton("Generate");
				disableButton("Modify");
				disableButton("Cancel");
				disableButton("View");
				enableButton("Dossier Settlement");
			}
			
}

function userDefinedOnLoadFunc(){
	enableButton("Generate");
			disableButton("Modify");
			disableButton("View");
			disableButton("Cancel");
			disableButton("Print Utility Certificate");
			disableButton("Dossier Settlement");
}
function cancelPage()
{
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
	
}
function CancelDossier(){
	
	if(document.forms[0].combo[0].value=="0")
	{
		alert("Please Select Service Type");
	}
	var res = prompt("ENTER REMARKS FOR CANCELATION!","");
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
        
    	document.forms[0].hmode.value="CANCELDOSSIER";
    	document.forms[0].submit();
        // blanket popup with process icon.
	 		//displayProgress();
        
	 		 //add(mode);
      }
      else
      {
        return false;
      }
      
     }
	
	
}