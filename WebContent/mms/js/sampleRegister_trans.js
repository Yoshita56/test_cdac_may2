/**



**/



function validateRecieve(form1,mode)
{

cmbVal="";

	with(form1){
	if(document.forms[0].combo[0].value=="0")
	{
		alert("Please Select Drug Warehouse Name")
	}
	else if(document.forms[0].combo[1].value=="0")
	{
		alert("Please Select Item Category");
	}
	else if(document.forms[0].combo[2].value!="0")
	{
		alert("Sample status must be recieved");
	}
	else
	{
			cmbVal = combo[0].options[combo[0].selectedIndex].text+"^"+combo[1].options[combo[1].selectedIndex].text;
			comboValue.value = cmbVal;
			
			document.forms[0].hmode.value=mode
			//alert(comboValue.value);
			//alert(document.forms[0].hmode.value);
			document.forms[0].submit();
	}
  }
}
/**



**/
function validateReturn(form1,mode)
{
	var chkVal="";
	var mode="RETURN";
	chkVal=document.getElementsByName("chk")[0].value;
	
	var temp=chkVal.split("@");
	
	
	
	
		
	with(form1){
	
		if(document.forms[0].combo[0].value=="0")
		{
			alert("Please Select Drug Warehouse Name");
			return false;
		}
		else
		{
			cmbVal = combo[0].options[combo[0].selectedIndex].text+"^"+combo[1].options[combo[1].selectedIndex].text;
			comboValue.value = cmbVal;
			document.forms[0].hmode.value=mode
			//alert(document.forms[0].hmode.value);
			document.forms[0].submit();
		}
	}
	

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
			//alert(check[i].value);
			temp=check[i].value;
			approved=temp.split("@");
		}			
	}
	if(checkCount==0){
			disableButton("Return");
			disableButton("Verify");
			disableButton("Dispose");
	}
	//alert(approved[4]);
	 if( approved[4]==1 ||  approved[4]==2)
	 {
	 	//alert("chkeck1");
	 	flag =true;
	 }
	 if(checkCount==1 && approved[4]==0 && document.getElementsByName("combo")[2].value==0){
		enableButton("Return");
		enableButton("Verify");
		enableButton("Dispose");
	}
	if(checkCount==1 && flag && document.getElementsByName("combo")[2].value==0){
		enableButton("Return");
		//enableButton("Verify");
		enableButton("Dispose");
	}
}


function chkCombo()
{
	
}
function validateVerify(form1,mode)
{
	var chkVal="";
	with(form1){
	
		if(document.forms[0].combo[0].value=="0")
		{
			alert("Please Select Drug Warehouse Name");
			return false;
		}
		else
		{
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			comboValue.value = cmbVal;
			document.forms[0].hmode.value=mode
			//alert(document.forms[0].hmode.value);
			document.forms[0].submit();
		}
	}
	
}
function validateCondemn(form1,mode)
{
	var chkVal="";
	with(form1){
	
		if(document.forms[0].combo[0].value=="0")
		{
			alert("Please Select Drug Warehouse Name");
			return false;
		}
		else
		{
			cmbVal = combo[0].options[combo[0].selectedIndex].text+"^"+combo[1].options[combo[1].selectedIndex].text;
			comboValue.value = cmbVal;
			document.forms[0].hmode.value=mode
			//alert(document.forms[0].hmode.value);
			document.forms[0].submit();
		}
	}
	
	
}
function cancelPage()
{
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
	
}

