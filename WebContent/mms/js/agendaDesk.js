function chkUserDefinedFunc(these){
	var checkCount=0;
	var check=document.getElementsByName("chk");
	for(i=0;i<check.length;i++){
		if(check[i].checked==true){
			checkCount++;
		}			
	}
				
	try{
		if(document.forms[0].combo[2].value==0){
			if(checkCount==1){
				if(document.forms[0].combo[0].value!=0 && document.forms[0].combo[1].value!=0)
				{
					enableButton("Add");
				enableButton("Cancel");
				enableButton("View");
				}
			} else {
				if(document.forms[0].combo[0].value!=0 && document.forms[0].combo[1].value!=0)
					enableButton("Add");
				disableButton("Cancel");
				disableButton("View");
			}
		} else {
			if(checkCount==1){
				if(document.forms[0].combo[0].value!=0 && document.forms[0].combo[1].value!=0)
					enableButton("Add");
				disableButton("Cancel");
				enableButton("View");
			}
		}
	}catch(Err){
		alert("Application Error! Contact system Administrator");
	}
}
 
function userDefinedOnLoadFunc(){
	document.forms[0].comboValue.value=document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text+"#"+document.forms[0].combo[1].options[document.forms[0].combo[1].selectedIndex].text+"#"+document.forms[0].combo[2].options[document.forms[0].combo[2].selectedIndex].text;
	if(document.forms[0].combo[0].value!=0 && document.forms[0].combo[1].value!=0)
		enableButton("Add");
	disableButton("Cancel");
	disableButton("View");
}

function buttonClick(param){
	if(param=="ADD"){
		
		var strId=document.forms[0].combo[0].value;
		var itemCategory=document.forms[0].combo[1].value;
		if(strId=="0"){
				alert("Please Select Store Name");
				document.forms[0].combo[0].focus();
				return false;
		}else if(itemCategory=="0"){
				alert("Please Select Item Category");
				document.forms[0].combo[1].focus();
				return false;
		}else{
			document.forms[0].hmode.value=param;
			document.forms[0].submit();	
		}
		
	}
	else if(param=="CANCEL"){
		var strRemarks=prompt("Cancel Remarks","");
		var strConfirmFlag = false;
		if(strRemarks!=null)
			strConfirmFlag = confirm("Are you sure to Cancel Agenda!");
		if(strConfirmFlag){
			var check=document.getElementsByName("chk");
			var strStoreId="";
			var strAgendaNo="";
			for(i=0;i<check.length;i++){
				if(check[i].checked==true){
					strStoreId = check[i].value.split("@")[0];
					strAgendaNo = check[i].value.split("@")[1];
				}			
			}
			document.forms[0].hmode.value=param+"1"; 
			document.forms[0].comboValue.value=strStoreId+"#"+strRemarks+"#"+strAgendaNo;
			document.forms[0].submit();
		}
	}else{
		document.forms[0].hmode.value=param;
		document.forms[0].submit();
	}
	
}

function cancelPage(){
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
}

function cancelToDesk(){
	document.forms[0].hmode.value = "CANCELTODESK";
	document.forms[0].submit();
}