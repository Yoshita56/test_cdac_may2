/**
 * @author Pankaj Kumar Creation Date:- 10-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
function getPOItemDetails(){
	var hmode = "POITEMDETAILS";
	var url = "PODeskScheduleTransCNT.cnt?hmode="+hmode+"&strPONo="+document.forms[0].strPONo.value +"&strDNoOfSchedule="+document.forms[0].strDNoOfSchedule.value+"&strStoreId="+document.forms[0].strStoreId.value+"&strPODeliveryDate="+document.forms[0].strPODeliveryDate.value;
	
	ajaxFunction(url,"1");
}

function getAjaxResponse(res,mode){
	if(res.split("####")[0] == "ERROR"){
		document.getElementById("errMsg").innerHTML=res.split("####")[1];
	} else if(mode == '1'){
		var itemParaObj = document.getElementById("divPOItemDetails");
		itemParaObj.innerHTML = res;
		hideAllOtherSchedule();
		
		
	}
}

function showDiv(strDivId){
	document.getElementById(strDivId).style.display="block";
}

function hideDiv(strDivId){
	document.getElementById(strDivId).style.display="none";
}

function checkData(these){
	var index=getIndex(these);
	if(these.checked){
		document.getElementsByName("strDScheduledQty")[index].disabled=false;
		document.getElementsByName("strDScheduledQtyUnit")[index].disabled=false;
		document.getElementsByName("strDGroupId")[index].disabled=false;
		document.getElementsByName("strDSubGroupId")[index].disabled=false;
		document.getElementsByName("strDItemBrandId")[index].disabled=false;
		document.getElementsByName("strDItemId")[index].disabled=false;
		document.getElementsByName("strDOrderQty")[index].disabled=false;
		document.getElementsByName("strDOrderQtyUnitId")[index].disabled=false;
		document.getElementsByName("strDRate")[index].disabled=false;
		document.getElementsByName("strDRateUnitId")[index].disabled=false;
		document.getElementsByName("strDItemTax")[index].disabled=false;
		document.getElementsByName("strDManufacturerId")[index].disabled=false;
		document.getElementsByName("strDRemarks")[index].disabled=false;
		document.getElementsByName("strDWarrentyReq")[index].disabled=false;
		document.getElementsByName("strDInstallationReq")[index].disabled=false;
		document.getElementsByName("strDScheduleNo")[index].disabled=false;
	}else{
		document.getElementsByName("strDScheduledQty")[index].disabled=true;
		document.getElementsByName("strDScheduledQtyUnit")[index].disabled=true;
		document.getElementsByName("strDGroupId")[index].disabled=true;
		document.getElementsByName("strDSubGroupId")[index].disabled=true;
		document.getElementsByName("strDItemBrandId")[index].disabled=true;
		document.getElementsByName("strDItemId")[index].disabled=true;
		document.getElementsByName("strDOrderQty")[index].disabled=true;
		document.getElementsByName("strDOrderQtyUnitId")[index].disabled=true;
		document.getElementsByName("strDRate")[index].disabled=true;
		document.getElementsByName("strDRateUnitId")[index].disabled=true;
		document.getElementsByName("strDItemTax")[index].disabled=true;
		document.getElementsByName("strDManufacturerId")[index].disabled=true;
		document.getElementsByName("strDRemarks")[index].disabled=true;
		document.getElementsByName("strDWarrentyReq")[index].disabled=true;
		document.getElementsByName("strDInstallationReq")[index].disabled=true;
		document.getElementsByName("strDScheduleNo")[index].disabled=true;
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

function hideAllOtherSchedule(these){
	var strSchedule = document.getElementsByName("strDScheduleNo");
	var strDivId= "";
	for(var nTmpI=0;nTmpI<strSchedule.length; nTmpI++){
		strDivId = "divSchedule"+strSchedule[nTmpI].value;
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
			if(strSchedule[nTmpI].value==1){
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
	var strSchedule = document.getElementsByName("strDScheduleNo");
	var index= getIndex(these)+1;
	try{
		if(document.getElementsByName("strCheckAll")[index-1].checked==true){
			var strCheckBox=document.getElementsByName("strCheckBox");
			for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++){
				if(strSchedule[nTmpI].value==index){
					strCheckBox[nTmpI].checked=true;
					document.getElementsByName("strDScheduledQty")[nTmpI].disabled=false;
					document.getElementsByName("strDScheduledQtyUnit")[nTmpI].disabled=false;
					document.getElementsByName("strDGroupId")[nTmpI].disabled=false;
					document.getElementsByName("strDSubGroupId")[nTmpI].disabled=false;
					document.getElementsByName("strDItemBrandId")[nTmpI].disabled=false;
					document.getElementsByName("strDItemId")[nTmpI].disabled=false;
					document.getElementsByName("strDOrderQty")[nTmpI].disabled=false;
					document.getElementsByName("strDOrderQtyUnitId")[nTmpI].disabled=false;
					document.getElementsByName("strDRate")[nTmpI].disabled=false;
					document.getElementsByName("strDRateUnitId")[nTmpI].disabled=false;
					document.getElementsByName("strDItemTax")[nTmpI].disabled=false;
					document.getElementsByName("strDManufacturerId")[nTmpI].disabled=false;
					document.getElementsByName("strDRemarks")[nTmpI].disabled=false;
					document.getElementsByName("strDWarrentyReq")[nTmpI].disabled=false;
					document.getElementsByName("strDInstallationReq")[nTmpI].disabled=false;
					document.getElementsByName("strDScheduleNo")[nTmpI].disabled=false;
				}
			}
		}else{
			var strCheckBox=document.getElementsByName("strCheckBox");
			for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++){
				if(strSchedule[nTmpI].value==index){
					strCheckBox[nTmpI].checked=false;
					document.getElementsByName("strDScheduledQty")[nTmpI].disabled=true;
					document.getElementsByName("strDScheduledQtyUnit")[nTmpI].disabled=true;
					document.getElementsByName("strDGroupId")[nTmpI].disabled=true;
					document.getElementsByName("strDSubGroupId")[nTmpI].disabled=true;
					document.getElementsByName("strDItemBrandId")[nTmpI].disabled=true;
					document.getElementsByName("strDItemId")[nTmpI].disabled=true;
					document.getElementsByName("strDOrderQty")[nTmpI].disabled=true;
					document.getElementsByName("strDOrderQtyUnitId")[nTmpI].disabled=true;
					document.getElementsByName("strDRate")[nTmpI].disabled=true;
					document.getElementsByName("strDRateUnitId")[nTmpI].disabled=true;
					document.getElementsByName("strDItemTax")[nTmpI].disabled=true;
					document.getElementsByName("strDManufacturerId")[nTmpI].disabled=true;
					document.getElementsByName("strDRemarks")[nTmpI].disabled=true;
					document.getElementsByName("strDWarrentyReq")[nTmpI].disabled=true;
					document.getElementsByName("strDInstallationReq")[nTmpI].disabled=true;
					document.getElementsByName("strDScheduleNo")[nTmpI].disabled=true;
				}
			}
		}
	}catch(_Err){
	}
}

function checkTotal(){
	var nTotalQty = 0;
	for(var nTmpJ=0; document.getElementsByName("strDScheduleNo")[nTmpJ].value==1;nTmpJ++){
		var strCheckBox = document.getElementsByName("strCheckBox");
		nTotalQty = 0;
		for(var nTmpI=0; nTmpI<strCheckBox.length; nTmpI++){
			if(strCheckBox[nTmpI].checked){
				if(document.forms[0].strDItemId[nTmpI].value==document.forms[0].strDItemId[nTmpJ].value && document.forms[0].strDItemBrandId[nTmpI].value==document.forms[0].strDItemBrandId[nTmpJ].value){
					nTotalQty += (document.forms[0].strDScheduledQty[nTmpI].value*document.forms[0].strDScheduledQtyUnit[nTmpI].value.split("^")[1]);
				}
			}
		}
		if(nTotalQty!=(document.forms[0].strDOrderQty[nTmpJ].value*document.forms[0].strBaseValue[nTmpJ].value)){
			alert("PO is not Properly Scheduled for "+document.forms[0].strItemName[nTmpJ].value+"!");
			return false;
		}
	}
	return true;
}

function validateAllScheduleChecked(){
	var strCheckBox=document.getElementsByName("strCheckBox");
	var strDScheduleNo=document.getElementsByName("strDScheduleNo");
	var nNoOfSchedule=document.forms[0].strDNoOfSchedule.value;
	var nTotalItem = 0;
	var nNonCheckedItem = 0;
	for(var nTmpI = 1;nTmpI<=nNoOfSchedule; nTmpI++){
		nTotalItem = 0;
		nNonCheckedItem = 0;
		for(var nTmpJ = 0;nTmpJ<strCheckBox.length; nTmpJ++){
			if(strDScheduleNo[nTmpJ].value==nTmpI){
				nTotalItem++;
				if(!strCheckBox[nTmpJ].checked)
					nNonCheckedItem++;
			}
		}
		if(nTotalItem==nNonCheckedItem){
			alert("In All Schedule minimum one item must be Selected.");
			return false;
		}
	}
	return true;
}

function validate1()
{
	var fFlag = true;
	var strCurrDate = document.forms[0].strCurrentDate.value;
	if(checkTotal()&&validateAllScheduleChecked())
	{
		var strCheckBox=document.getElementsByName("strCheckBox");
		for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++)
			if(strCheckBox[nTmpI].checked)
			{
				var index = document.getElementsByName("strDScheduleNo")[nTmpI].value;
				//document.getElementsByName("strDDeliveryDate")[index-1].value=document.getElementsByName("strDDeliveryDate"+index)[0].value;
			}

		var strDDeliveryDate = document.getElementsByName("strDDeliveryDate");
		var strDDeliveryLocation = document.getElementsByName("strDeliveryLocation");
		for(var nTmpI=0;nTmpI<strDDeliveryDate.length; nTmpI++)
		{
			var nFlag = compareDate(strDDeliveryDate[nTmpI].value,strCurrDate); 
//			if(nFlag == 2)
//			{
//				alert("Delivery Date must be greater then Current Date.");
//				return;
//			}
//			if(strDDeliveryDate[nTmpI].value=="")
//			{
//				alert("Please Enter Delivery Date for All Schedule.");
//				fFlag = false;
//				break;
//			}
			if(strDDeliveryLocation[nTmpI].value=="0")
			{
				alert("Please Select Delivery Location for All Schedule.");
				fFlag = false;
				break;
			}
		}
		if(fFlag){
			for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++)
				if(strCheckBox[nTmpI].checked){
					strCheckBox[nTmpI].disabled=false;
				}else{
					strCheckBox[nTmpI].disabled=true;
				}
				
//			
			if(setDeliveryDate()==false)
			{
				return false;
				
			}
			else 
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
	}
}

function notGreaterThanCent(_these){
	var nNum = _these.value;
	if(nNum>99)
		_these.value = _these.value.substr(0,2);
}

function maxLengthRemarks(_these,_length){
	var nLength = _these.value.length;
	if(nLength>_length)
		_these.value = _these.value.substr(0,_length);
}

function checkOrderQty(_these)
{
	try
	{
		var index = getIndex(_these);
		
		
		var nOrderQty = document.getElementsByName("strDScheduledQty")[index].value;
		var nOrderQtyCmbUnit = document.getElementsByName("strDScheduledQtyUnit")[index].value;
		var strTmpBalQty  = document.getElementsByName("strDOrderQty")[index].value;
		var strTmpBaseValue  = document.getElementsByName("strBaseValue")[index].value;
		var nOrderQtyDecFlag = nOrderQtyCmbUnit.split("^")[2]==0?true:false;
		var nOrderQtyBaseValue = nOrderQtyCmbUnit.split("^")[1];
		
		if(nOrderQtyDecFlag){
			if(nOrderQty.indexOf(".")>-1)
				document.getElementsByName("strDScheduledQty")[index].value=nOrderQty.split(".")[0];
		}
		
		if(nOrderQty*nOrderQtyBaseValue>strTmpBalQty*strTmpBaseValue){
			alert("Schedule Qty. cann't be greater than Order Qty.");
			document.getElementsByName("strDScheduledQty")[index].value="";
			document.getElementsByName("strDScheduledQtyUnit")[index].value="0";
		}
	}catch(_err){
		alert(_err);
	}
}




function setDeliveryDate()
{

		for(var i=0;i<document.getElementsByName("strDDeliveryDays").length;i++)
		{
			if( (document.getElementsByName("strDDeliveryDays")[i].value<7) || (document.getElementsByName("strDDeliveryDays")[i].value>60) )
			{
				alert("Please Select Delivery Days between 7 and 60");
				document.getElementsByName("strDDeliveryDays")[i].value='45';
					return false;
			}
			
			var poRefDate 	= convertStrToDate(document.forms[0].strPODate.value , 'dd-Mon-yyyy');
	
			var deliveryDate	= addToDate(poRefDate,(document.getElementsByName("strDDeliveryDays")[i].value - 1),'D'); 
			
			document.getElementsByName("strDDeliveryDate")[i].value=convertDateToStr(deliveryDate, 'dd-Mon-yyyy');
		}
		
		
		//document.forms[0].strDDeliveryDays.value='45';
		//alert("document.forms[0].strDDeliveryDate.value"+document.forms[0].strDDeliveryDate.value);
	
	
	
	
	
}