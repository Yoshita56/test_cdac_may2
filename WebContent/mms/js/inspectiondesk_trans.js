// call on change of status combo

function onStatusChange()
{
/*
alert(document.getElementsByName("combo")[0].value);
alert(document.getElementsByName("combo")[1].value);
var cmb1 = document.getElementsByName("combo")[0].value;
var cmb2 = document.getElementsByName("combo")[1].value
if(cmb1=="0")
{
	
}*/
 			
 			 var obj = document.getElementById("comboid1").value;
    alert("obj"+obj);
    if(obj=='1')
	{
		enableButton("Intimation");
 			disableButton("Issue");
 			disableButton("View");
 			disableButton("Cancel")
		
	}
	else
	{
	    	disableButton("Intimation");
 			disableButton("Issue");
 			disableButton("View");
 			disableButton("Cancel")
	}

}


/**
 * inspectionDeskButtonStatus
 * @param {Object} form1 
 */
 function inspectionDeskButtonStatus(these) {
 	
 		
 		var checkCount=0;
		var check=document.getElementsByName("chk");
		
		for(i=0;i<check.length;i++){
		
			if(check[i].checked==true)
			checkCount++;
		}
 		
 	
 	if(checkCount == 1){ 	 		
 		if(document.forms[0].combo[1].value == "1"){
 			
 			disableButton("Intimation");
 			enableButton("Issue");
 			disableButton("View");
 			disableButton("Cancel");
			 			
 		}
 		else if(document.forms[0].combo[1].value == "2"){
 			
 			disableButton("Intimation");
 			disableButton("Issue");
 			enableButton("View");
 			disableButton("Cancel");
			 			
 		}
 		else{
 			disableButton("Intimation");
 			disableButton("Issue");
 			disableButton("View");
 			disableButton("Cancel");
 		}
 		 		
 	}else{
 		enableButton("Intimation");
 		disableButton("Issue");
 		disableButton("View");
 		disableButton("Cancel");
 	}
 }

// call on Intimation button 

 function callIntimationCnt(form1,mode){
	cmbVal="";
	with(form1){
		if(mode=="INTIMATION" && document.forms[0].combo[0].value=="0" ){
			alert("Please Select A Store");
			return;
		}
		
		if( mode == "INTIMATION" && document.forms[0].combo[0].value!="0" ){
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			comboValue.value = combo[0].value+"^"+cmbVal;
			add(mode);
		}
		}
    }
    
// call on Issue button 
    
 function callIssueCnt(form1,mode){
	cmbVal="";
	alert("callIssueCnt");
	with(form1){
		if(mode=="ISSUE" && document.forms[0].combo[0].value=="0" ){
			alert("Please Select A Store");
			return;
		}
		if( mode == "ISSUE" && document.forms[0].combo[0].value!="0" ){
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			comboValue.value = combo[0].value+"^"+cmbVal;
			add(mode);
		}
		}
    }
    
// call on View button 
    
 function callViewCnt(form1,mode){
	cmbVal="";
	with(form1){
		if(mode=="VIEW" && document.forms[0].combo[0].value=="0" ){
			alert("Please Select A Store");
			return;
		}
		if( mode == "VIEW" && document.forms[0].combo[0].value!="0" ){
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			comboValue.value = cmbVal;
			add(mode);
		}
		}
    }
    
// call on cancel button 
function cancelPage(){
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
}
