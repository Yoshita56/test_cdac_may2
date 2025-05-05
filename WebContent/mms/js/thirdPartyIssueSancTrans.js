
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
		enableButton("View");
	else
		disableButton("View");	
	if(checkCount==1)
		enableButton("Issue");
	else
		disableButton("Issue");
}


function callPage1(form1,mode){
	
	cmbVal="";
	
	if((document.forms[0].combo[0].value == "0")){
		alert("Please Select Drug Warehouse Name from Drug Warehouse Combo");
	}else{
	with(form1){
	if( mode == "REQUEST" && document.forms[0].combo[0].value!="0" ){
			cmbVal =combo[0].options[combo[0].selectedIndex].text;
			comboValue.value = cmbVal;
	
	document.forms[0].hmode.value="REQUEST";
	document.forms[0].submit();
			}
		}
	}
}


function getGroupCombo(obj){ 

 		var url ="ThirdPartyIssueSancTransCNT.cnt?hmode=GROUPCMB&itemCatNo="+obj.value;
 		ajaxFunction(url,"1");
		
	}
	
function getAjaxResponse(res,mode){

	if(mode=="1"){   
			var objVal= document.getElementById("groupDivId");
			objVal.innerHTML = "<select name ='strGroupIdForItemSearch' class='comboNormal'>" + res + "</select>";
		}
	}	

	function getItemSelectPopup(){
	
	   // alert("itCat->"+document.forms[0].strItemCatNo.value);
	   // alert("strFromStoreId->"+document.forms[0].strStoreId.value);
	   // alert("strStoreTypeId->"+document.forms[0].strStoreTypeId.value);
		var strModeVal 					= "2"; 
		var strItemCategory 			= document.forms[0].strItemCatNo.value; 
		var strIssuedType 				= "";
		var strFromStoreId 				= document.forms[0].strStoreId.value;
		var strToStoreId  				= "";
		var strStoreTypeId  			= document.forms[0].strStoreTypeId.value;
		var strMultiRowCompArray 		= new Array('itemParamValue','strUnitName','strQty');
		var strMultiRowCompTypeArray 	= new Array('t','s','t');
		// for mode val 1
		// var strMultiRowFetchDataArray= new Array('6','12','3^strUnitName');
		// for mode val 2
		var strMultiRowFetchDataArray 	= new Array('17','18','3','5','7','11^strUnitName');
		// for mode val 3
		// var strMultiRowFetchDataArray= new Array('37','45','4^strUnitName');
		var layerIndex = "1";
	
	    searchItems( strModeVal , strItemCategory , strIssuedType ,strFromStoreId, strToStoreId , strStoreTypeId , strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex);
	
	}
	
	
	function cancel1(){
	
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
	}

function compareQty(){
	
	var quantity = parseInt(document.getElementById("strQty").value);
	var availableQty = parseInt(document.getElementById("stockParamAvailableQtyDivId").value);
	
	if(availableQty > quantity){
	
			alert("Quantity cannot be greater than Available Quantity");
			
			}
		}

function clearDtl(mode){

	document.forms[0].mode.value=mode;
	document.forms[0].hmode.value="CLEAR";
	document.forms[0].submit();

}
function validate1(){

    var issueStatus=document.forms[0].issueStatus.value;    
    if(parseInt(issueStatus)>0)
    {
      retVal=false;
      alert("Invalid DATA::Sanction Qty Greater than Available Qty.");
    }  
    else
      retVal=true;  
	
	if(retVal)
	{
			      var conf = confirm("You Are Going To Save Records");
		          if(conf == true)
		          {
		               var conf1 = confirm("Are you sure !!!");
		               if(conf1 == true)
		               {	              
								   
					                document.forms[0].hmode.value="INSERT";
						            document.forms[0].submit();
		               }
		              else
		               {
		                 return false;
		               }
		           }
		          else
		           {
		                 return false;
		           } 
	}
	else
	{
	  return retVal;
	}
}

function openIssueReport()
{
	// alert("mode->"+document.forms[0].mode.value);
	 if(document.forms[0].mode.value=="1")
	 {
	    getIssueDtls('3', document.forms[0].strStoreId.value, document.forms[0].strReqNo.value) ;
	 }
}