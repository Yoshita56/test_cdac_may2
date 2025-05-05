function cancelPage(){
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
}

function getCmbValView(){
	
	
	if(document.forms[0].strComboVal.value == '0'){
		document.getElementById('ackDtlDivId').style.display="none";
	}else if(document.forms[0].strComboVal.value == '1'){
		document.getElementById('ackDtlDivId').style.display="block";
	}
}



function chkUserDefinedFunc(these){
	
	var checkCount=0;
	var check=document.getElementsByName("chk");
	for(i=0;i<check.length;i++){
		if(check[i].checked==true){
			checkCount++;
		}			
	}
	try{    
		if(checkCount==1){
		       if(document.forms[0].combo[0].value!=0){
				//enableButton("Acknowledge");
				enableButton("View");
				}else if(document.forms[0].combo[0].value!=0 && document.forms[0].combo[1].value == 1){
				
					disableButton("Acknowledge");
					enableButton("View");
					enableButton("Close/Reopen Issue");
				}
			} 
			else
				{
					enableButton("Raise Issue");
					disableButton("View");
					disableButton("Print");
					disableButton("Print");
				}
	}catch(Err){
		alert(Err);
	}
}

/**

function chkStatusFunc(){

	if(document.forms[0].combo[1].value == "0"){
			
					enableButton("Acknowledge");
					enableButton("View");
				
			}
			
			
	}else if(document.forms[0].combo[1].value == "1"){
			
					disableButton("Acknowledge");	
					enableButton("View");
				
		}
	}
*/

function callPage1(form1,mode){
	
	cmbVal="";
	
	if(document.forms[0].combo[0].value == "0"){
		alert("Please Select Drug Warehouse Name from Drug Warehouse Combo");
	}else{
	with(form1){
	if( mode == "ACKNOWLEDGE" && document.forms[0].combo[0].value!="0" ){
			cmbVal =combo[0].options[combo[0].selectedIndex].text;
			comboValue.value = cmbVal;
	document.forms[0].hmode.value="ACKNOWLEDGE";
	document.forms[0].submit();
			}
		}
	}
}

function viewAcknowledge(){
		
	document.forms[0].hmode.value="VIEW";
	document.forms[0].submit();
			
}



function cancelToDesk()
{
	document.forms[0].hmode.value="RETURNTODESK";
	document.forms[0].submit();
}

function validate2(){


	var hisValidator = new HISValidator("acknowledgeTransBean");
	hisValidator.addValidation("strRemarks", "req", "Remarks is mandatory" );
	hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
				
	var retVal = hisValidator.validate(); 
	hisValidator.clearAllValidations();
	
	if(retVal){
		
		document.forms[0].hmode.value = "INSERT";
		document.forms[0].submit();
		
	}		
	else
	{
		return false;
	}
}

function changeCombo(obj){
	
	if(obj[0].value == '0' || obj[1].value == '0'){
		
			disableButton("Acknowledge");
			disableButton("View");
	}
}
function printData(){
	document.forms[0].hmode.value = "PRINT";
	document.forms[0].submit();
}

// function to show report after save data

function getReport()
{


var strAckStatus = document.forms[0].strAckStatus.value;
var strStoreId =  document.forms[0].strStoreId.value;
var strTransNo =  document.forms[0].strTransNo.value;

	if(strAckStatus!="0")
	{
		getIssueDtls('4', strStoreId, strTransNo);
	}
	document.forms[0].strAckStatus.value ="0";
}

function downloadfile(index)
{

/* Value Pass in Web Row Set
				    	   1. TransNo
				    	   2. StoreId 
			           
						*/
     // alert(index);
     //  document.forms[0].hmode.value = "DOWNLOAD";
	//document.forms[0].submit();
	
	if(index!=null)
	{
	 var mode="DOWNLOAD";
	var url="HelpDeskCNT.cnt?hmode="+mode+"&hiddenValue="+document.getElementById("strHidVal"+index).value;
	//alert(url);
	//ajaxFunction(url,"1");  
	url = (url.replace(/%/g, '@$@$'));
	window.open(url, "popupWindow",	"width=1000,height=500,top=150,left=50,scrollbars=yes"); 
	}
	else
	{
	alert("File not Uploaded");
	}
}



