function validateLots()
{
	document.forms[0].comboValue.value=document.forms[0].combo[0][document.forms[0].combo[0].selectedIndex].text+"^"+document.forms[0].combo[1][document.forms[0].combo[1].selectedIndex].text;
	if(document.forms[0].combo[0].value==0){	
		alert('Please Select Store');
		return false;	
	}
	else if(document.forms[0].combo[1].value==0){
		alert('Please Select Item Category');
		return false;	
	}
	else{	
		
		document.forms[0].hmode.value="LOTS";
		document.forms[0].submit();
	}
}

function validateCancel()
{
	var flag=false;
	var res=prompt("ENTER REMARKS FOR CANCELATION!","");
	if(res!="")
	{
		flag=confirm("Are you sure to cancel");
		if(flag)
		{
			document.forms[0].comboValue.value=res;
			document.forms[0].hmode.value="CANCELLOTS";
			document.forms[0].submit();
		}
	}
}

function validateView()
{
	document.forms[0].comboValue.value=document.forms[0].combo[0][document.forms[0].combo[0].selectedIndex].text+"^"+document.forms[0].combo[1][document.forms[0].combo[1].selectedIndex].text;
	document.forms[0].hmode.value="LOTSVIEW";
	document.forms[0].submit();
}


function chkUserDefinedFunc(these){
	var checkCount=0;
	var checkValue="";
	var approved;
	var temp;
	var flag=false;
	var check=document.getElementsByName("chk");
	for(i=0;i<check.length;i++){
		if(check[i].checked==true){
			checkCount++;
			temp=check[i].value;
			approved=temp.split("@");
		}			
	}
	if(checkCount==0){
			disableButton("Cancel");
			disableButton("View");
	}
	if(checkCount==1 && document.getElementsByName("combo")[0].value!="0" && document.getElementsByName("combo")[1].value!="0" && document.getElementsByName("combo")[2].value=="0")
	{
		enableButton("Cancel");
	}
	if(checkCount==1 && document.getElementsByName("combo")[0].value!="0" && document.getElementsByName("combo")[1].value!="0")
	{
		enableButton("View");
	}
}

function cancelPage()
{
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
}
