function chkUserDefinedFunc(these){
	var checkCount=0;
	var check=document.getElementsByName("chk");
	for(i=0;i<check.length;i++){
		if(check[i].checked==true){
			checkCount++;
		}			
	}
	try{
		if(document.forms[0].combo[0].value!=0 && document.forms[0].combo[1].value!=0 && document.forms[0].combo[2].value!=0){
			if(checkCount==1){
				enableButton("Generate");
				disableButton("Finalize PO");
				if(document.forms[0].combo[3].value==1 || document.forms[0].combo[3].value==3){
					enableButton("Cancel");
					enableButton("Print");
					//if(document.forms[0].combo[2].value.substr(0,2)  =='22')
					//	enableButton("Schedule");
					//else
					//	disableButton("Schedule");
					enableButton("View");
					if(document.forms[0].combo[2].value.substr(0,2)  =='21')
						{
						if(document.forms[0].combo[3].value==1)
							enableButton("Finalize PO");
						else
							disableButton("Finalize PO");
						enableButton("Reminder");
					//	enableButton("POModify");
						}
						
				} else if(document.forms[0].combo[3].value==2){
					disableButton("Cancel");
					//disableButton("Schedule");
					enableButton("View");
					enableButton("Print");
					disableButton("Finalize PO");
					disableButton("Reminder");
				} else if(document.forms[0].combo[3].value==3){
					disableButton("Cancel");
					disableButton("Finalize PO");
					
					//if(document.forms[0].combo[2].value.substr(0,2)  !='21')
					//	disableButton("Schedule");
					//else
					//	enableButton("Schedule");
					
					enableButton("View");
					if(document.forms[0].combo[2].value.substr(0,2)  =='21')
					{
						var check=document.getElementsByName("chk");
						
						for(var i=0;i<check.length;i++){
							if(check[i].checked){
								//alert(check[i].value);
								if(check[i].value.split("@")[6].split("$")[0] != 0)
									enableButton("Print");
								else
									disableButton("Print");
							}
						}
					}
					else
						enableButton("Print");
					
					enableButton("Reminder");
				}
			}else{
				enableButton("Generate");
				disableButton("Cancel");
				disableButton("Print");
				//disableButton("Schedule");
				disableButton("View");
				disableButton("Reminder");
				disableButton("Finalize PO");
			}
		} 
	}catch(Err){
		alert("Application Error! Contact system Administrator");
	}
}
 
function userDefinedOnLoadFunc(){
	document.forms[0].comboValue.value=document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
	if(document.forms[0].combo[0].value!=0 && document.forms[0].combo[1].value!=0 && document.forms[0].combo[2].value!=0)
		enableButton("Generate");
	else
		disableButton("Generate");
	//disableButton("Schedule");
	disableButton("Cancel");
	disableButton("View");
	disableButton("Print");
	disableButton("Reminder");
	disableButton("Finalize PO");
}

function buttonClick(param){
	
	if(param == 'FINALIZEPO')
	{
		if(document.forms[0].combo[2].value.substr(0,2)  =='21')
		{
			var check=document.getElementsByName("chk");
			for(var i=0;i<check.length;i++){
				if(check[i].checked){
					if(check[i].value.split("@")[6].split("$")[0] == 1)
					{
						document.forms[0].hmode.value=param;
						document.forms[0].target= "_self";
						document.forms[0].submit();
					}	
					else
					{
						alert("Finance Approval required before PO finalization");
						return false;
					}
				}
			}
		}
		
	}
	if(param == 'POMODIFY')
	{
		//alert(document.forms[0].combo[2].value.substr(0,2));
		if(document.forms[0].combo[2].value.substr(0,2)  =='21')
		{
			var check=document.getElementsByName("chk");
			for(var i=0;i<check.length;i++){
				if(check[i].checked){
					//if(check[i].value.split("@")[6].split("$")[0] == 1)
					if(true)
					{
						document.forms[0].hmode.value=param;
						document.forms[0].target= "_self";
						document.forms[0].submit();
					}	
					else
					{
						alert("Finance Approval required before PO finalization");
						return false;
					}
				}
			}
		}
		
	}
	
	if(param!="SCHEDULE"){
		document.forms[0].hmode.value=param;
		document.forms[0].target= "_self";
		document.forms[0].submit();
	}else{
		var check=document.getElementsByName("chk");
		for(i=0;i<check.length;i++){
			if(check[i].checked){
				if(check[i].value.split("@")[5].split("$")[0]>1){
					alert("This PO is already Scheduled no further Scheduling is allowed.");
				}else{
					document.forms[0].hmode.value=param;
					document.forms[0].target= "_self";
					document.forms[0].submit();
				}
			}			
		}
	}
}

function cancelPage(){
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].target= "_self";
	document.forms[0].submit();
}

function cancelToDesk(){
	document.forms[0].hmode.value = "CANCELTODESK";
	document.forms[0].submit();
}

function getReportPage(){

			document.forms[0].hmode.value = "PRINT";
			document.forms[0].target= "_self";
			document.forms[0].submit();


}