function disPrevReminderDtl()
{     
  
   		document.getElementById("prevReminderDivId").style.display="block";
   		document.getElementById("minus2").style.display="block";
  		document.getElementById("plus2").style.display="none";
   		
   
}

function onRadio(obj){

		document.forms[0].reset();
		//document.getElementById("podetailsDivId").innerHTML="";
		//document.getElementById("prevReminderDivId").innerHTML="";
		
		
		document.getElementById("podetailsDivId").style.display="none";
		document.getElementById("prevReminderDivId").style.display="none";
		document.getElementById("revRemDetButton").style.display="none";
		
	//document.getElementById("scheduleDivId").innerHTML="<select name='strScheduleNo' class='comboNormal'><option value='0'>Select Value</option></select>";
		
		obj.checked=true;

}

function disPrevReminderDtl1()
{  
 
   		document.getElementById("prevReminderDivId").style.display="none";
   		document.getElementById("minus2").style.display="none";
  		document.getElementById("plus2").style.display="block";
  		
}


function getPONo(){ 

		var url ="ReminderDetailsTransCNT.cnt?hmode=PONOCMB&storeId="+document.forms[0].strStoreId.value;
 		ajaxFunction(url,"1");
		
}

function getScheduleNo(){ 

		var url ="ReminderDetailsTransCNT.cnt?hmode=SCHEDULENO&poNo="+document.forms[0].strPONo.value;
 		ajaxFunction(url,"2");
		
}

function getPODetails(){

		var url ="ReminderDetailsTransCNT.cnt?hmode=PODETAILS&poNo="+document.forms[0].strPONo.value;
 		ajaxFunction(url,"3");
	
}

function getPrevReminderDtl(){

		var url ="ReminderDetailsTransCNT.cnt?hmode=PREVREMINDERDTL&storeId="+document.forms[0].strStoreId.value+"&scheduleNo="+document.forms[0].strScheduleNo.value+"&strPONo="+document.forms[0].strPONo.value;
 		ajaxFunction(url,"4");
	
}


function getAjaxResponse(res,mode){
		
	if(mode=="1"){ 
		if(res=="")
		{
			document.getElementById("poNoDivId").innerHTML="<select name ='strPONo' class='comboNormal' ><option value='0'>Select Value</option></select>";
			document.getElementById("scheduleDivId").innerHTML="<select name ='strScheduleNo' class='comboNormal' ><option value='0'>Select Value</option></select>";
		}
		else
		{
			var objVal= document.getElementById("poNoDivId");
			objVal.innerHTML = "<select name ='strPONo' class='comboNormal' onchange='getScheduleNo();' >"+res+"</select>";		
		}
	}	
	
	if(mode=="2"){ 
	
	if(res=="")
		{
			document.getElementById("scheduleDivId").innerHTML="<select name ='strScheduleNo' class='comboNormal' ><option value='0'>Select Value</option></select>";
		}else{
	
			var objVal= document.getElementById("scheduleDivId");
			objVal.innerHTML = "<select name ='strScheduleNo' class='comboNormal' onchange='resetDiv();'>"+res+"</select>";	
			getPODetails();
		}
		openDisplay();
}


	if(mode=="3"){ 
	
			var objVal= document.getElementById("podetailsDivId");
			
			objVal.innerHTML = res;
		//	document.getElementById('revRemDetButton').style.display="block";
			
		}
		
	if(mode=="4"){ 
			
				var objVal= document.getElementById("prevReminderDivId");
			
				objVal.innerHTML = res;	
					
		}			
						
}

function openDisplay(){

	if(document.forms[0].strPONo.value!='0' ){
		document.getElementById("revRemDetButton").style.display="block";
		document.getElementById("podetailsDivId").style.display="block";
		document.getElementById("prevReminderDivId").style.display="block";
		
	}else{
	
		document.getElementById("revRemDetButton").style.display="none";
		document.getElementById("podetailsDivId").style.display="none";
		document.getElementById("prevReminderDivId").style.display="none";
	
	}

}

function onStoreCombo(){

	if(document.forms[0].strStoreId.value == '0' ){
	
		//document.getElementById("podetailsDivId").innerHTML = "";
		//document.getElementById("prevReminderDivId").innerHTML = "";	
		document.getElementById("podetailsDivId").style.display="none";
		document.getElementById("prevReminderDivId").style.display="none";
		document.getElementById("revRemDetButton").style.display="none";
		document.getElementById("scheduleDivId").innerHTML="<select name ='strScheduleNo' class='comboNormal' ><option value='0'>Select Value</option></select>";
	
	
	}
}

function validate1(){

	var hisValidator = new HISValidator("reminderDetailBean");

	hisValidator.addValidation("strStoreId", "dontselect=0","Select Drug Warehouse Name from Drug Warehouse Combo ");
	hisValidator.addValidation("strPONo", "dontselect=0","Select PO NO from Item Category Combo");
		
	var retVal = hisValidator.validate(); 
	hisValidator.clearAllValidations();
	
		
			
			if(retVal){
			
			
			document.forms[0].hmode.value = "INSERT";
			document.forms[0].target= "_blank";
			document.forms[0].submit();
			resetValue();
		
		}else{
		return false;
	}
		
}
	
function clearRem()
{
	var url;
	var mode = "INITVAL";
	document.forms[0].hmode.value=mode;
	document.forms[0].target= "_self";
	document.forms[0].submit();
}


function cancelRem()
{
		document.forms[0].hmode.value = "CANCELPAGE";
		document.forms[0].target= "_self";
  	    document.forms[0].submit();
}

function resetDiv(){

document.getElementById('prevReminderDivId').innerHTML="";
document.getElementById('prevReminderDivId').style.display = "none";
document.getElementById("plus2").style.display = "block";
document.getElementById("minus2").style.display = "none";


}



function resetValue(){

		document.getElementById('podetailsDivId').style.display = "none";
		document.getElementById('revRemDetButton').style.display = "none";
		document.getElementById('prevReminderDivId').style.display = "none";
	    document.getElementById("poNoDivId").innerHTML="<select name ='strPONo' class='comboNormal' ><option value='0'>Select Value</option></select>";
		document.getElementById("scheduleDivId").innerHTML="<select name ='strScheduleNo' class='comboNormal' ><option value='0'>Select Value</option></select>";
		document.forms[0].strStoreId.value="0";
}

