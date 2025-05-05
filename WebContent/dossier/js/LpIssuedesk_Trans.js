function chkUserDefinedFunc(these){
	var checkCount=0;
	var checkValue="";
	var status;
	var status1;
	var temp;
	var flag=false;
	var check=document.getElementsByName("chk");
	status=document.getElementsByName("combo")[2].value;
	status1=document.getElementsByName("combo")[1].value;
	for(i=0;i<check.length;i++){
		if(check[i].checked==true){
			checkCount++;
			//alert(check[i].value);
			temp=check[i].value;
			approved=temp.split("@");
		}			
	}
	if(checkCount==0){
			disableButton("Issue");
			disableButton("Return");
			disableButton("View");
			
	}
	
	
	if(checkCount==1 && (status==1||status==3))
	{
		if(status1 == 98 && (status==1))
		enableButton("Issue");
		if(status1 == 99 && (status==1))
		enableButton("Return");
	}
	else if(checkCount==1 && status == 4)
	{
		//enableButton("Return");
		enableButton("View");
		
	}
	else
	{
		disableButton("Issue");
		disableButton("Return");
		disableButton("View");
		disableButton("Print Utility Certificate");
	}
	
}

function issueDeskButtonStatus()
{
	
}

function validateIssue()
{

	var cmbVal="";
	if(document.forms[0].combo[0].value=="0")
	{
		alert("Please Select Store")
	}
	else
	{
			cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
			 document.forms[0].comboValue.value = cmbVal;
			document.forms[0].hmode.value="ISSUE";
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
			cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
			//alert(cmbVal);
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
		alert("Please Select Store.");
	}
	else
	{
		if(document.forms[0].combo[1].value=="98"){
			if(document.forms[0].combo[2].value=="4"){
				cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
			    document.forms[0].comboValue.value = cmbVal;
				document.forms[0].hmode.value="ISSUEVIEW";
				document.forms[0].submit();
			}
		}
		else if(document.forms[0].combo[1].value=="99"){
				
			if(document.forms[0].combo[2].value=="4"){
				cmbVal = document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
			    document.forms[0].comboValue.value = cmbVal;
				document.forms[0].hmode.value="RETURNVIEW";
				document.forms[0].submit();
			}
		}
		else{
			alert("Please Select Request Type.");
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
			disableButton("Issue");
			disableButton("Return");
			disableButton("View");
			disableButton("Print Utility Certificate");
			if(document.getElementsByName("combo")[1].value == '32')
			{
				enableButton("Issue");
			}
}

function userDefinedOnLoadFunc(){
			disableButton("Issue");
			disableButton("Return");
			disableButton("View");
			disableButton("Print Utility Certificate");
}
function cancelPage()
{
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
	
}
