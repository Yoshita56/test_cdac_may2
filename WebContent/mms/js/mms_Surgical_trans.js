
function showMenuFrame()
{	
//alert("showMenuFrame in hisglobal");
	if(window.XMLHttpRequest) // Mozilla
	{
		parent.document.getElementById("fs2").cols = "230,*";
	//	parent.document.getElementById("f7").contentDocument.getElementById("Image").src="../hisglobal/images/arrsingle-left.png";
	}
	//if (window.ActiveXObject)
	else
	{
		parent.document.getElementById("fs2").cols = "230,*";
	//	parent.document.getElementById("f7").Document.getElementById("Image").src="../hisglobal/images/arrsingle-left.png";
	}	
}

// challan process (By Bala)


function myAjaxFunction(myurl,mode,resFunctionName)
{
	
		
	userMode = mode;
	gblResFunctionName = resFunctionName;
	// checking browser 
	if (navigator.userAgent.indexOf("Opera")>=0){
		alert("This example doesn't work in Opera"); 
		return; 
	}

	if (navigator.userAgent.indexOf("MSIE")>=0) { 
		var strName="Msxml2.XMLHTTP"
		
		if (navigator.appVersion.indexOf("MSIE 5.5")>=0){
			strName="Microsoft.XMLHTTP"
		} 

		try { 
			objXmlHttp=new ActiveXObject(strName)
			objXmlHttp.onreadystatechange=sendReqUsingMyMethodName
		} 
		catch(e){ 
			alert("Error. Scripting for ActiveX might be disabled");
			return; 
		} 
	}
	else {
		if (navigator.userAgent.indexOf("Mozilla")>=0){
			objXmlHttp=new XMLHttpRequest();
			objXmlHttp.onload=sendReqUsingMyMethodName
			objXmlHttp.onerror=sendReqUsingMyMethodName
		}
	}

	objXmlHttp.open("GET",myurl,true)
	objXmlHttp.send(null)
} 



//internal function called from ajaxFunction() function
function sendReqUsingMyMethodName(){
		
	if (objXmlHttp.readyState==4 || objXmlHttp.readyState==200) {
		var res = objXmlHttp.responseText; 
		
		eval(gblResFunctionName + '(res' + "," + userMode + ")"); // evel is a keyword - it calls the function passed in it as argument.
		
	} 
}



var gblModeVal = "";


function getStockModifyValue(chkVal, itemCatNo , cmbVal , mode){
	
		document.forms[0].comboValue.value = cmbVal;
	
	gblModeVal = mode;
	
	var mode="GETISMODIFY";
   
    var url="ItemInventoryTransCNT.cnt?hmode="+mode+"&strChkVal="+chkVal+"^"+itemCatNo;
     
       
   myAjaxFunction(url,"1" , "getMyStockModifyAjaxResponse");
}

function getnewaddmode(){
	
	cmbVal="";
	var combo			=	document.forms[0].combo;
	var comboValue=document.forms[0].comboValue;
	var comboValue=document.forms[0].comboValue;
	
	if(document.forms[0].combo[0].value=="0" )
	{
		alert("Please Select Store Name");
		document.forms[0].combo[0].focus();
		return;
	}
	
	
	// if(document.forms[0].combo[1].value=="0"){
	//	alert("Please Select Group Name");
	//	document.forms[0].combo[1].focus();
	//	return;
	//}
	 	cmbVal = combo[0].options[combo[0].selectedIndex].text;
		comboValue.value = cmbVal;
	//alert("new"+document.forms[0].cmbVal.value)
	//document.forms[0].comboValue.value = cmbVal; 
	
document.forms[0].hmode.value="addNew";
document.forms[0].submit();

}
function getnewmodifymode(){
	cmbVal="";
	var combo			=	document.forms[0].combo;
	var comboValue=document.forms[0].comboValue;
	
	if(document.forms[0].combo[0].value=="0" )
	{
		alert("Please Select Store Name");
		document.forms[0].combo[0].focus();
		return;
	}
	
	
	// if(document.forms[0].combo[1].value=="0"){
	//	alert("Please Select Group Name");
	//	document.forms[0].combo[1].focus();
	//	return;
	//}
	

		if(document.forms[0].combo[2].value=="0"){
			alert("Please Select Stock Status");
			document.forms[0].combo[2].focus();
			return;
		}
		
	var checkNo=document.forms[0].chkValue.value.split("$");
	//var drugName=$("#tr"+checkNo[1]+" td:nth-child(2)").text();
	var itemBrandId=(document.forms[0].chkValue.value.split("@"))[2];
	var batchSel=(document.forms[0].chkValue.value.split("@"))[3];
	cmbVal = combo[0].options[combo[0].selectedIndex].text+"^"+combo[1].options[combo[1].selectedIndex].text+"^"+combo[2].options[combo[2].selectedIndex].text;
	comboValue.value = cmbVal+"^"+"main"+"^"+itemBrandId+"^"+batchSel;
	
	//alert(comboValue);
	
	document.forms[0].hmode.value="NEWMODIFY";
	document.forms[0].submit();

}
function getnewaddmode1(){

	cmbVal="";
	var combo			=	document.forms[0].combo;
	var comboValue=document.forms[0].comboValue;
	
	if(document.forms[0].combo[0].value=="0" )
	{
		alert("Please Select Store Name");
		document.forms[0].combo[0].focus();
		return;
	}
	
	 if(document.forms[0].combo[1].value=="0"){
		alert("Please Select Item Category Name");
		document.forms[0].combo[1].focus();
		return;
	}
	 
	/* if(document.forms[0].combo[1].value.split('^')[0]!="21"){
			alert("Please Select Item Category Sg Utility Items");
			document.forms[0].combo[1].focus();
			return;
		}*/
	 
//	 if(document.forms[0].combo[2].value=="0"){
//			alert("Please Select Group Name");
//			document.forms[0].combo[1].focus();
//			return;
//		}
	 		//alert(document.forms[0].combo[1].value);
	 		//disableButton("Add");
			cmbVal = combo[0].options[combo[0].selectedIndex].text;
			comboValue.value = cmbVal;
	 		document.forms[0].hmode.value="ADDNEW";
			document.forms[0].submit();

}
function getnewmodifymode1(){
	
	cmbVal="";
	var combo			=	document.forms[0].combo;
	var comboValue=document.forms[0].comboValue;
	
	if(document.forms[0].combo[0].value=="0" )
	{
		alert("Please Select Store Name");
		document.forms[0].combo[0].focus();
		return;
	}
	
	
	 if(document.forms[0].combo[1].value=="0"){
		alert("Please Select Item Category Name");
		document.forms[0].combo[1].focus();
		return;
	}
//	 if(document.forms[0].combo[2].value=="0"){
//			alert("Please Select Group Name");
//			document.forms[0].combo[1].focus();
//			return;
//		}

		if(document.forms[0].combo[3].value=="0"){
			alert("Please Select Stock Status");
			document.forms[0].combo[2].focus();
			return;
		}
		var checkNo=document.forms[0].chkValue.value.split("$");
		//var drugName=$("#tr"+checkNo[1]+" td:nth-child(2)").text();
		var itemBrandId=(document.forms[0].chkValue.value.split("@"))[2];
		var batchSel=(document.forms[0].chkValue.value.split("@"))[3];
		cmbVal = combo[0].options[combo[0].selectedIndex].text+"^"+combo[1].options[combo[1].selectedIndex].text+"^"+combo[2].options[combo[2].selectedIndex].text;
		comboValue.value = cmbVal+"^"+"main"+"^"+itemBrandId+"^"+batchSel;
	
	document.forms[0].hmode.value="NEWMODIFY";
	document.forms[0].submit();

}

function getDrugStockModifyValue(chkVal, itemCatNo , cmbVal , mode){
	
  
	
		document.forms[0].comboValue.value = cmbVal;
	
	gblModeVal = mode;
	
	var mode="GETISMODIFY";
   
    var url="DrugInventoryTransCNT.cnt?hmode="+mode+"&strChkVal="+chkVal+"^"+itemCatNo;
        
                
   myAjaxFunction(url, "1" , "getMyStockModifyAjaxResponse");
}

  function getMyStockModifyAjaxResponse(res,mode) {
      	
              	
      	 if(mode == "1"){
     	     
     	var temp = res.split('^');
     	
     		if(parseInt(temp[0]) == 1 ){
     	
     			if(parseInt(temp[1]) == 0 && parseInt(temp[2]) == 0){
     				
     				add(gblModeVal);
     				
     			}else{
     				
     				alert("Inventory Can be Modified on Same Day and there should not be any Issue or Receive of Item's in case of Stock Ledger is On");
 					return false;
     				
     			}
     	 				
     		}else{
     			
     			add(gblModeVal);
     			
     		}
     		
     	
     }
      	
      }





/**
 * validateChallan
 * @param {Object} form1 
 * @param {String} mode
 */
 function validateChallan(form1 , mode) {
 	
 	cmbVal="";
	with(form1){
		if(mode=="RECEIVECHL" && document.forms[0].combo[0].value=="0" ){
			alert("Please Select Drug Warehouse Name");
			document.forms[0].combo[0].focus();
			return;
		}
		if(mode=="RECEIVECHL" && document.forms[0].combo[1].value=="0"){
			alert("Please Select P.O. No.");
			document.forms[0].combo[1].focus();
			return;
		}
		
		
		if( mode == "RECEIVECHL" && document.forms[0].combo[0].value!="0" && document.forms[0].combo[1].value!="0"){
			cmbVal = combo[0].options[combo[0].selectedIndex].text + "^"+combo[1].options[combo[1].selectedIndex].text;
			comboValue.value = cmbVal;
			add(mode);
		}
				
			
		if(mode=="VERIFYCHL" && document.forms[0].combo[0].value=="0" ){
			alert("Please Select Drug Warehouse Name");
			document.forms[0].combo[0].focus();
			return;
		}
		if(mode=="VERIFYCHL" && document.forms[0].combo[1].value=="0"){
			alert("Please Select P.O. No.");
			document.forms[0].combo[1].focus();
			return;
		}
		
		
		if( mode == "VERIFYCHL" && document.forms[0].combo[0].value!="0" && document.forms[0].combo[1].value!="0"){
				cmbVal = combo[0].options[combo[0].selectedIndex].text + "^"+combo[1].options[combo[1].selectedIndex].text;
			comboValue.value = cmbVal;
			add(mode);
		}		
			
	
		if(mode=="CANCELCHL" && document.forms[0].combo[0].value=="0" ){
			alert("Please Select Drug Warehouse Name");
			document.forms[0].combo[0].focus();
			return;
		}
		if(mode=="CANCELCHL" && document.forms[0].combo[1].value=="0"){
			alert("Please Select P.O. No.");
			document.forms[0].combo[1].focus();
			return;
		}
		
		
		if( mode == "CANCELCHL" && document.forms[0].combo[0].value!="0" && document.forms[0].combo[1].value!="0"){
			
			var checkVal = "";
			
			
		var check=document.getElementsByName("chk");
			for(i=0;i<check.length;i++){
				if(check[i].checked==true)
					checkVal = check[i].value;
					
			}
						
			var temp = checkVal.split('@');
			
			if(parseFloat(temp[5]) <= 0 ){
				
				var remarks = prompt("Please Enter the Cancel Remarks " , "");
				
				if(!remarks==""){
						var conf = confirm("Are you sure !!!");
					if(conf == true){
			
						document.forms[0].comboValue.value = remarks;
													
						add(mode);
			
					}else{
					
						return false;	
					}
					
					
				}else{
					
					if(remarks==""){ 
						alert("Enter remarks for rejection");
					} 
				}
				
					
				}else{
				
				alert("Item(s) have been Verified, Cannot be Cancelled");
				return false;
			}
			
		}
		
		if(mode=="VIEWCHL" && document.forms[0].combo[0].value=="0" ){
			alert("Please Select Store Name");
			document.forms[0].combo[0].focus();
			return;
		}
		if(mode=="VIEWCHL" && document.forms[0].combo[1].value=="0"){
			alert("Please Select P.O. No.");
			document.forms[0].combo[1].focus();
			return;
		}
		
		
		if( mode == "VIEWCHL" && document.forms[0].combo[0].value!="0" && document.forms[0].combo[2].value!="0"){
			cmbVal = combo[0].options[combo[0].selectedIndex].text + "^"+combo[2].options[combo[2].selectedIndex].text;
			comboValue.value = cmbVal;
			add(mode);
		}		
		
	}
 }
  
 function validateNewChallan(form1 , mode) {
	 	
	 	cmbVal="";
		with(form1){
			if(mode=="RECEIVECHL" && document.forms[0].combo[0].value=="0" ){
				alert("Please Select Drug Warehouse Name");
				document.forms[0].combo[0].focus();
				return;
			}
			if(mode=="RECEIVECHL" && document.forms[0].combo[1].value=="0"){
				alert("Please Select P.O. No.");
				document.forms[0].combo[1].focus();
				return;
			}
			
			
			if( mode == "RECEIVECHL" && document.forms[0].combo[0].value!="0" && document.forms[0].combo[1].value!="0"){
				cmbVal = combo[0].options[combo[0].selectedIndex].text + "^"+combo[1].options[combo[1].selectedIndex].text;
				comboValue.value = cmbVal;
				add(mode);
			}
					
				
			if(mode=="VERIFYCHL" && document.forms[0].combo[0].value=="0" ){
				alert("Please Select Drug Warehouse Name");
				document.forms[0].combo[0].focus();
				return;
			}
			if(mode=="VERIFYCHL" && document.forms[0].combo[1].value=="0"){
				alert("Please Select P.O. No.");
				document.forms[0].combo[1].focus();
				return;
			}
			
			
			if( mode == "VERIFYCHL" && document.forms[0].combo[0].value!="0" && document.forms[0].combo[1].value!="0"){
					cmbVal = combo[0].options[combo[0].selectedIndex].text + "^"+combo[1].options[combo[1].selectedIndex].text;
				comboValue.value = cmbVal;
				add(mode);
			}		
				
		
			if(mode=="CANCELCHL" && document.forms[0].combo[0].value=="0" ){
				alert("Please Select Drug Warehouse Name");
				document.forms[0].combo[0].focus();
				return;
			}
			if(mode=="CANCELCHL" && document.forms[0].combo[1].value=="0"){
				alert("Please Select P.O. No.");
				document.forms[0].combo[1].focus();
				return;
			}
			
			
			if( mode == "CANCELCHL" && document.forms[0].combo[0].value!="0" && document.forms[0].combo[1].value!="0"){
				
				var checkVal = "";
				
				
			var check=document.getElementsByName("chk");
				for(i=0;i<check.length;i++){
					if(check[i].checked==true)
						checkVal = check[i].value;
						
				}
							
				var temp = checkVal.split('@');
				
				if(parseFloat(temp[5]) <= 0 ){
					
					var remarks = prompt("Please Enter the Cancel Remarks " , "");
					
					if(!remarks==""){
							var conf = confirm("Are you sure !!!");
						if(conf == true){
				
							document.forms[0].comboValue.value = remarks;
														
							add(mode);
				
						}else{
						
							return false;	
						}
						
						
					}else{
						
						if(remarks==""){ 
							alert("Enter remarks for rejection");
						} 
					}
					
						
					}else{
					
					alert("Item(s) have been Verified, Cannot be Cancelled");
					return false;
				}
				
			}
			if(mode=="VIEWCHL" && document.forms[0].combo[0].value=="0" ){
				alert("Please Select Store Name");
				document.forms[0].combo[0].focus();
				return;
			}
			if(mode=="VIEWCHL" && document.forms[0].combo[1].value=="0"){
				alert("Please Select P.O. No.");
				document.forms[0].combo[1].focus();
				return;
			}
			
			
			if( mode == "VIEWCHL" && document.forms[0].combo[0].value!="0" && document.forms[0].combo[3].value!="0"){
				cmbVal = combo[0].options[combo[0].selectedIndex].text + "^"+combo[3].options[combo[3].selectedIndex].text;
				comboValue.value = cmbVal;
				add(mode);
			}		
			
		}
	 }


function chkUserDefinedChallanProcessFunc(these)
{
	
	var checkCount=0;
	var check=document.getElementsByName("chk");
	for(i=0;i<check.length;i++){
		if(check[i].checked==true)
			checkCount++;
	}
	if(checkCount==1)
	{
	
		if(document.forms[0].combo[1].value == '1')
		{
			enableButton("Cancel");	
			enableButton("Verify");
			enableButton("View&Print");
		}
		
		
		
	}
	else
	{
		
		disableButton("Cancel");
		disableButton("Verify");
		disableButton("View&Print");
	}
		
	if(document.forms[0].combo[2].value != '0')	
		enableButton("Receive");	
	else
		disableButton("Receive");
		
}



function chkUserDefinedRevisedChallanProcessFunc(these)
{
	
	var checkCount=0;
	var check=document.getElementsByName("chk");
	for(i=0;i<check.length;i++){
		if(check[i].checked==true)
			checkCount++;
	}
	if(checkCount==1 && document.forms[0].combo[0].value != '0' && document.forms[0].combo[1].value != '0' && document.forms[0].combo[3].value != '0')
	{
			enableButton("View");
			enableButton("Print");	
	}
	else
	{
		
		disableButton("View");
		disableButton("Print");
	}
		
	if(document.forms[0].combo[3].value == '1' && document.forms[0].combo[0].value != '0' && document.forms[0].combo[1].value != '0' && document.forms[0].combo[2].value != '0')	
		enableButton("Receive");	
	else
		disableButton("Receive");
		
}

// used in Drug Inventory and Item Inventory (By Anshul)
function validateAddInventory(form1,mode){
	
 	
	cmbVal="";
	with(form1)
	{
		if(mode=="ADD" && document.forms[0].combo[0].value=="0" )
		{
			alert("Please Select Drug Warehouse Name");
			document.forms[0].combo[0].focus();
			return;
		}
		
		
		 if(mode=="ADD" && document.forms[0].combo[1].value=="0"){
			alert("Please Select Group Name");
			document.forms[0].combo[1].focus();
			return;
		}
		
		
		/*
		if(mode=="ADD" && document.forms[0].combo[2].value=="0"){
			alert("Please Select Stock Status");
			document.forms[0].combo[2].focus();
			return;
		} */	//Commented By Vivek Aggarwal on  22-Mar-2012
		
		
		/*
		if( mode == "ADD" && document.forms[0].combo[0].value!="0" && document.forms[0].combo[1].value!="0"){
			cmbVal = combo[0].options[combo[0].selectedIndex].text+"^"+combo[1].options[combo[1].selectedIndex].text;
			comboValue.value = cmbVal;
			add(mode);
		}*/
		
		if( mode == "ADD"  && document.forms[0].combo[0].value!="0"){
			cmbVal = combo[0].options[combo[0].selectedIndex].text+"^"+combo[1].options[combo[1].selectedIndex].text;
			comboValue.value = cmbVal;
			add(mode);
		}
		
		if(mode=="MODIFY" && document.forms[0].combo[0].value=="0" ){
				alert("Please Select Drug Warehouse Name");
				document.forms[0].combo[0].focus();
			return;
		}
		/*
		if(mode=="MODIFY" && document.forms[0].combo[1].value=="0"){
			alert("Please Select Group Name");
			document.forms[0].combo[1].focus();
			return;
		}*/
		
		if(mode=="MODIFY" && document.forms[0].combo[2].value=="0"){
			alert("Please Select Stock Status");
			document.forms[0].combo[2].focus();
			return;
		}
		
		if( mode == "MODIFY" && document.forms[0].combo[0].value!="0")
		{
			cmbVal = combo[0].options[combo[0].selectedIndex].text+"^"+combo[1].options[combo[1].selectedIndex].text;
		    var itemCatNo = "1";
			var chkVal = "";
				
				
				var check=document.getElementsByName("chk");
				for(i=0;i<check.length;i++){
					if(check[i].checked==true)
						chkVal = check[i].value;
				}
								
			getDrugStockModifyValue(chkVal, itemCatNo , cmbVal , mode);
			 
			 
		}
	}
}


function validateAddItemInventory(form1,mode){
	cmbVal="";
	with(form1){
		if(mode=="ADD" && document.forms[0].combo[0].value=="0" ){
			alert("Please Select Drug Warehouse Name");
			document.forms[0].combo[0].focus();
			return;
		}
		if(mode=="ADD" && document.forms[0].combo[1].value=="0"){
			alert("Please Select Item Category");
			document.forms[0].combo[1].focus();
			return;
		}
		if(mode=="ADD" && document.forms[0].combo[2].value=="0"){
			alert("Please Select Group Name");
			document.forms[0].combo[2].focus();
			return;
		}
		
		if(mode=="ADD" && document.forms[0].combo[3].value=="0"){
			alert("Please Select Stock Status");
			document.forms[0].combo[3].focus();
			return;
		}
		
		if( mode == "ADD" && document.forms[0].combo[0].value!="0" && document.forms[0].combo[1].value!="0"){
			cmbVal = combo[0].options[combo[0].selectedIndex].text+"^"+combo[1].options[combo[1].selectedIndex].text+"^"+combo[2].options[combo[2].selectedIndex].text;
			comboValue.value = cmbVal;
			add(mode);
		}
		if(mode=="MODIFY" && document.forms[0].combo[0].value=="0" ){
				alert("Please Select Drug Warehouse Name");
			return;
		}
		
		if(mode=="MODIFY" && document.forms[0].combo[1].value=="0"){
			alert("Please Select Item Category");
			document.forms[0].combo[1].focus();
			return;
		}
		
		if(mode=="MODIFY" && document.forms[0].combo[2].value=="0"){
			alert("Please Select Group Name");
			return;
		}
		
		
		if(mode=="MODIFY" && document.forms[0].combo[3].value=="0"){
			alert("Please Select Stock Status");
			return;
		}
		
		/*
		if(mode == "MODIFY") {
			var arrCheckbox = document.getElementsByName("chk");
			var countCheckedRow = 0;
			var i=0;
			for(i=0;i<arrCheckbox.length;++i) {
				if(arrCheckbox[i].checked) {
					++countCheckedRow;
				}
			}
			if(i==0) {
				
				alert("Please Select a row to modify.");
				return;
				
			} else if(i>1) {
				alert("Only one can be modified at a time.");
				return;
			}
		}
		*/
		
		if( mode == "MODIFY" && document.forms[0].combo[0].value!="0" && document.forms[0].combo[1].value!="0"){
			cmbVal = combo[0].options[combo[0].selectedIndex].text+"^"+combo[1].options[combo[1].selectedIndex].text+"^"+combo[2].options[combo[2].selectedIndex].text;
			
			
			var itemCatNo = document.forms[0].combo[1].value;
			var chkVal = "";
				
				
				var check=document.getElementsByName("chk");
				for(i=0;i<check.length;i++){
					if(check[i].checked==true)
						chkVal = check[i].value;
				}
								
			getStockModifyValue(chkVal, itemCatNo , cmbVal , mode);
				
				
		}
	}
}



// used in Rate contract transaction (By Anshul)
function validateAddRateContract(form1,mode){
	cmbVal="";
	with(form1){
		if(mode=="ADD" && document.forms[0].combo.value=="0" ){
			alert("Please Select Supplier Name");
			return;
		}
		if( mode == "ADD" && document.forms[0].combo.value!="0" ){
			cmbVal =combo.options[combo.selectedIndex].text;
			comboValue.value = cmbVal;
			add(mode);
		}
		
		if(mode=="VIEW" && document.forms[0].combo.value=="0" ){
			alert("please select combo value");
			return;
		}
		if( mode == "VIEW" && document.forms[0].combo.value!="0" ){
			cmbVal =combo.options[combo.selectedIndex].text;
			comboValue.value = cmbVal;
			document.forms[0].hmode.value="VIEW";
			document.forms[0].submit();
		}
		
		if(mode=="TERMINATE" && document.forms[0].combo.value=="0" ){
			alert("please select combo value");
			return;
		}
		if( mode == "TERMINATE" && document.forms[0].combo.value!="0" ){
			cmbVal =combo.options[combo.selectedIndex].text;
			comboValue.value = cmbVal;
			document.forms[0].hmode.value="TERMINATE";
			document.forms[0].submit();
		}
	}
}
function cancelPage(){
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
}

function chkUserDefinedFunc(these){

	var checkCount=0;
	var check=document.getElementsByName("chk");
	for(i=0;i<check.length;i++){
		if(check[i].checked==true)
			checkCount++;
	}
	if(checkCount==1)
		{
		enableButton("Modify");
		enableButton("Modify_New");
		}
		
	else
		{
		disableButton("Modify");
		disableButton("Modify_New");	
		}
		
}
/*
function userDefinedOnLoadFunc(){
	document.forms[0].comboValue.value=document.forms[0].combo[0].options[document.forms[0].combo[0].selectedIndex].text;
	if(document.forms[0].combo[0].value!=0)
		enableButton("Generate");
	else
		disableButton("Generate");
	disableButton("Schedule");
	disableButton("Cancel");
	disableButton("View");
	disableButton("Print");
	disableButton("Reminder");
}*/

/**
 * getDrugProfilePopup
 		 
 */
 function getDrugProfilePopup() {
 	
 	document.forms[0].hmode.value="POPUP";
	document.forms[0].submit();
 	
 }
/*Addex by Anshul for checking combo 2
*/function buttonLogicsOnClick1(modeNo, mode , display)
{
	
			
}