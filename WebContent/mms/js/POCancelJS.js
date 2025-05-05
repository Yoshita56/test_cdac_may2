/**
 * @author Pankaj Kumar Creation Date:- 10-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
function getPOItemDetails(){
	var hmode = "POITEMDETAILS"; 
	var url = "PODeskCancelTransCNT.cnt?hmode="+hmode+"&strPONo="+document.forms[0].strPONo.value +"&strDNoOfCancel="+document.forms[0].strDNoOfCancel.value;
	ajaxFunction(url,"1");
}

function getAjaxResponse(res,mode){
	if(res.split("####")[0] == "ERROR"){
		document.getElementById("errMsg").innerHTML=res.split("####")[1];
	} else if(mode == '1'){
		var itemParaObj = document.getElementById("divPOItemDetails");
		itemParaObj.innerHTML = res;
		hideAllOtherCancel();
	}
}

function disOldDate(_these)
{
	var strOldDeliveryDate = document.getElementsByName("strDOldDeliveryDate");
	var strDeliveryLocation = document.getElementsByName("strDeliveryLocation");
	for(var nTmpI = 0; nTmpI < strOldDeliveryDate.length; nTmpI++)
	
		 strOldDeliveryDate[nTmpI].disabled = true;
		strDeliveryLocation[nTmpI].disabled = true;
	
	if(_these.checked)
	{
		var index=getIndex(_these);
		strOldDeliveryDate[index].disabled  = false;
		strDeliveryLocation[nTmpI].disabled = false;
	}
	
}

function showDiv(strDivId){
	document.getElementById(strDivId).style.display="block";
}

function disableRadio(){
	try{
		var objRadio = document.getElementsByName("strDScheduleNo");
		for(var nTmpI = 0; nTmpI < objRadio.length; nTmpI++){
			objRadio[nTmpI].checked = false;
			objRadio[nTmpI].disabled = true;
		}
	}catch(_err){
		
	}
}

function enableRadio(){
	try{
		var objRadio = document.getElementsByName("strDScheduleNo");
		for(var nTmpI = 0; nTmpI < objRadio.length; nTmpI++){
			if(nTmpI==0){
				objRadio[nTmpI].checked = true;
				document.getElementsByName("strDOldDeliveryDate")[nTmpI].disabled = false;
			}
			objRadio[nTmpI].disabled = false;
		}
	}catch(_err){
		
	}
}

function hideDiv(strDivId){
	document.getElementById(strDivId).style.display="none";
}

function checkData(these){
	var index=getIndex(these);
	if(these.checked){
		document.getElementsByName("strDCanceldQty")[index].disabled=false;
		document.getElementsByName("strDCanceldQtyUnit")[index].disabled=false;
	}else{
		document.getElementsByName("strDCanceldQty")[index].disabled=true;
		document.getElementsByName("strDCanceldQtyUnit")[index].disabled=true;
	}
}

function getIndex(_these){
	var nTmpI;
	var strSelectedObjName=document.getElementsByName(_these.name)
	for(nTmpI=0;nTmpI<strSelectedObjName.length;nTmpI++)
		if(_these==strSelectedObjName[nTmpI])
			break;
	return nTmpI;
}

function hideAllOtherCancel(these){
	var strCancel = document.getElementsByName("strDCancelNo");
	var strDivId= "";
	for(var nTmpI=0;nTmpI<strCancel.length; nTmpI++){
		strDivId = "divCancel"+strCancel[nTmpI].value;
		if(these){
			if(these.parentNode.id==strDivId+"PlusID"){
				showDiv(strDivId+"MinusID");
				showDiv(strDivId);
				hideDiv(strDivId+"PlusID");
			} else{
				hideDiv(strDivId+"MinusID");
				hideDiv(strDivId);
				showDiv(strDivId+"PlusID");
			}
		} else {
			if(strCancel[nTmpI].value==1){
				showDiv(strDivId+"MinusID");
				showDiv(strDivId);
				hideDiv(strDivId+"PlusID");
			} else{
				hideDiv(strDivId+"MinusID");
				hideDiv(strDivId);
				showDiv(strDivId+"PlusID");
			}
		}
				
	}
}

function checkAll(these){
	var strCancel = document.getElementsByName("strDCancelNo");
	var index= getIndex(these)+1;
	try{
		if(document.getElementsByName("strCheckAll")[index-1].checked==true){
			var strCheckBox=document.getElementsByName("strCheckBox");
			for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++){
				if(strCancel[nTmpI].value==index){
					strCheckBox[nTmpI].checked=true;
					document.getElementsByName("strDCanceldQty")[nTmpI].disabled=false;
					document.getElementsByName("strDCanceldQtyUnit")[nTmpI].disabled=false;
				}
			}
		}else{
			var strCheckBox=document.getElementsByName("strCheckBox");
			for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++){
				if(strCancel[nTmpI].value==index){
					strCheckBox[nTmpI].checked=false;
					document.getElementsByName("strDCanceldQty")[nTmpI].disabled=true;
					document.getElementsByName("strDCanceldQtyUnit")[nTmpI].disabled=true;
				}
			}
		}
	}catch(_Err){
	}
}

function validate1()
{
	var retVal
	if(document.forms[0].strDPOCancelOrModify[1].checked)
	{
		var hisValidator = new HISValidator(document.forms[0].name);

		hisValidator.addValidation("strDDeliveryDate", "req", "Please select Delivery Date" );
		hisValidator.addValidation("strDApprovedBy", "dontselect=0", "Please select Approved By" );
		hisValidator.addValidation("strDApprovedDate", "req", "Please select Approval Date" );
		hisValidator.addValidation("strDRemarks", "req", "Please Enter Remarks" );
		
		retVal = hisValidator.validate();
	} 
	else 
	{
		var hisValidator = new HISValidator(document.forms[0].name);
		hisValidator.addValidation("strDCancelBy", "dontselect=0", "Please select Cancel By" );
	    hisValidator.addValidation("strDCancelRemarks", "req", "Please Enter Cancel Remarks" );
		retVal = hisValidator.validate();
	}
	if(retVal)
	{
		
		             		  		  var conf = confirm("You Are Going To Save Records");
					                  if(conf == true)
					                  {
					                       var conf1 = confirm("Are you sure !!!");
					                       if(conf1 == true)
					                       {
					                          document.forms[0].hmode.value = "INSERT";
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
}