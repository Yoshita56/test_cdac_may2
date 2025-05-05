
var parentPopUp="";
var indentDtlPopupId="";
function getIndentDetails(){
	var hisValidator = new HISValidator(document.forms[0].name);
          
	hisValidator.addValidation("strToStore", "dontselect=0", "Please select a To Store Name" );
	hisValidator.addValidation("strAgendaPeriod", "dontselect=0", "Agenda Period is a mandatory Field" );
	//hisValidator.addValidation("strGrantTypeId", "dontselect=0", "Please select a Grant Type" );
	
	var retVal = hisValidator.validate(); 
	
	if(retVal){
		document.getElementById("divToStore").style.display = "none";
		//document.getElementById("divAgendaPeriod").style.display = "none";
		document.getElementById("divGrantType").style.display = "none";
		document.getElementById("agendaPeroidText").style.display = "none";
		document.getElementById("divToStoreLabel").innerHTML=document.forms[0].strToStore.options[document.forms[0].strToStore.selectedIndex].text;
		//document.getElementById("divAgendaPeriodLabel").innerHTML=document.forms[0].strAgendaPeriod.options[document.forms[0].strAgendaPeriod.selectedIndex].text+"/"+document.forms[0].strAgendaPeriodValue.value;
		document.getElementById("divGrantTypeLabel").innerHTML=document.forms[0].strGrantTypeId.options[document.forms[0].strGrantTypeId.selectedIndex].text;
				
		document.getElementById("goButton").style.display = "none";
		document.getElementById("indentDetails").innerHTML = "";
		var hmode = "INDENTDETAILS"; 
		var url = "AgendaDeskAddTransCNT.cnt?hmode="+hmode+"&strStoreId="+document.forms[0].strStoreId.value+"&strItemCat="+document.forms[0].strItemCat.value+"&strAgendaType="+document.forms[0].strAgendaType.value;
		ajaxFunction(url,"1");
	}
}

function getToStoreValues(){
	if(document.forms[0].strItemCat.value!="0"){
		var hmode = "GETTOSTOREVALUES"; 
		var url = "AgendaDeskAddTransCNT.cnt?hmode="+hmode+"&strStoreId="+document.getElementsByName("combo")[0].value+"&strItemCat="+document.forms[0].strItemCat.value;
		ajaxFunction(url,"2");
	}else{
		var itemParaObj = document.getElementById("toStore");
		itemParaObj.innerHTML ="<select name='strToStore' onchange='getIndentDetails();'><option value='0'>Select Value</option></select>";
		document.getElementById("indentDetails").innerHTML="<table class='TABLEWIDTH' align='center' "+
															"cellpadding='1px' cellspacing='1px' id='itemDtlsTableId'> "+
															"<tr> <td width='20%' id='df' class='CONTROL'><center><font color='red'>No Record Found.</font></center></td></tr></table>";
		hideIndentData();
	}
}

function getIndentDtlPopup(these,indentNo){
	parentPopUp=these;
	var index=getIndex(these);
	indentDtlPopupId="indent"+these.id;
	var hmode = "INDENTPOPUPDETAILS"; 
	var url = "AgendaDeskAddTransCNT.cnt?hmode="+hmode+"&strIndentNo="+indentNo+"&strPopupId="+indentDtlPopupId+"&strStoreId="+document.getElementsByName("strDRaisingStore")[index].value;
	ajaxFunction(url,"3");
}

function getIndex(_these){
	var nTmpI;
	var strSelectedObjName=document.getElementsByName(_these.name)
	for(nTmpI=0;nTmpI<strSelectedObjName.length;nTmpI++)
		if(_these==strSelectedObjName[nTmpI])
			break;
	return nTmpI;
}

function disableOtherCat(){
	var strCheckBox=document.getElementsByName("strCheckBox");
	for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++){
		if(document.getElementsByName("strCatCode"+nTmpI)[0].value!=document.forms[0].strItemCat.value){
			strCheckBox[nTmpI].disabled=true;
		}else{
			strCheckBox[nTmpI].disabled=false;
		}
	}
	checkAll();
}

function checkData(){
}

function checkAll(){
	try{
		if(document.forms[0].strCheckAll.checked==true){
			var strCheckBox=document.getElementsByName("strCheckBox");
			for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++){
					strCheckBox[nTmpI].checked=true;
			}
		}else{
			var strCheckBox=document.getElementsByName("strCheckBox");
			for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++){
				strCheckBox[nTmpI].checked=false;
			}
		}
	}catch(_Err){
	}
}

function checkAllItem(){
	try{
		if(document.forms[0].strCheckAllItem.checked==true){
			var strCheckBox=document.getElementsByName("strCheckBoxItem");
			for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++){
				strCheckBox[nTmpI].checked=true;
				document.getElementsByName("strDApproxRate")[nTmpI].disabled=false;
				document.getElementsByName("strDApproxRateUnit")[nTmpI].disabled=false;
			}
		}else{
			var strCheckBox=document.getElementsByName("strCheckBoxItem");
			for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++){
				strCheckBox[nTmpI].checked=false;
				document.getElementsByName("strDApproxRate")[nTmpI].disabled=true;
				document.getElementsByName("strDApproxRateUnit")[nTmpI].disabled=true;
			}
		}
	}catch(_Err){
	}
}

function getAjaxResponse(res,mode){
	if(res.split("####")[0] == "ERROR"){
		document.getElementById("errMsg").innerHTML=res.split("####")[1];
	} else if(mode == '1'){
		var itemParaObj = document.getElementById("indentDetails");
		itemParaObj.innerHTML = res;
		document.getElementById("requestDtlsId").style.display="block";
		showIndentData();
	} else if(mode == '2'){
		var itemParaObj = document.getElementById("toStore");
		itemParaObj.innerHTML ="<select name='strToStore' onchange='getIndentDetails();'>"+res+"</select>";
		disableOtherCat();
		document.getElementById("indentDetails").innerHTML="<table class='TABLEWIDTH' align='center' "+
															"cellpadding='1px' cellspacing='1px' id='itemDtlsTableId'> "+
															"<tr> <td width='20%' id='df' class='CONTROL'><center><font color='red'>No Record Found.</font></center></td></tr></table>";;
		hideIndentData();
	} else if(mode == '3'){
		var itemParaObj = document.getElementById("divPopup");
		itemParaObj.innerHTML=res;
		display_popup_menu(parentPopUp,"divPopup",'250','');		
	} else if(mode == '4'){
		var itemParaObj = document.getElementById("itemDtlsId");
		itemParaObj.innerHTML=res;
		showItemData();
		
		OnLoadCheck();
	}
}

function showItemData(){
	document.getElementById("itemMinusID").style.display="block";
	document.getElementById("itemPlusID").style.display="none";
	document.getElementById("itemDtlsId").style.display="block";
}

function hideItemData(){
	document.getElementById("itemMinusID").style.display="none";
	document.getElementById("itemPlusID").style.display="block";
	document.getElementById("itemDtlsId").style.display="none";
}

function showIndentData(){
	document.getElementById("indentMinusID").style.display="block";
	document.getElementById("indentPlusID").style.display="none";
	document.getElementById("indentDetails").style.display="block";
}

function hideIndentData(){
	document.getElementById("indentMinusID").style.display="none";
	document.getElementById("indentPlusID").style.display="block";
	document.getElementById("indentDetails").style.display="none";
}

function compileIndent(){
	try{
		var strChkData="";
		var strStoreId="";
		var strCheckBox=document.getElementsByName("strCheckBox");
		var strStoreIds=document.getElementsByName("strDRaisingStore");
		var flag=true;
		for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++)
				if(strCheckBox[nTmpI].checked)
					flag=false;
					
		if(flag)
			alert("Select at least one Request!");
		else {
			document.forms[0].strCheckAll.disabled="true";
			document.getElementById("itemFullDetailsId").style.display="block";
			document.getElementById("compileId").style.display="none";
			document.getElementById("saveCancelId").style.display="block";
			
			var nCount=0;
			
			flag=true;
			for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++){
				if(strCheckBox[nTmpI].checked){
					if(flag){
						strStoreId=strStoreIds[nTmpI].value;
						strChkData=strCheckBox[nTmpI].value;
						flag=false;
					} else{
						strStoreId+=","+strStoreIds[nTmpI].value;
						strChkData+=","+strCheckBox[nTmpI].value;
					}
					strCheckBox[nTmpI].disabled="true";
				} else {
					strCheckBox[nTmpI].disabled="true";
				}
			}
			var hmode = "INDENTITEMDETAILS"; 
			var url = "AgendaDeskAddTransCNT.cnt?hmode="+hmode+"&strIndentNo="+strChkData+"&strStoreIds="+strStoreId;
			ajaxFunction(url,"4");
		}
	}catch(_Err){
		alert("Select at least one Request!");
	}
}

function validate1(){
	var fChecked = true;
	var strCheckBoxItem=document.getElementsByName("strCheckBoxItem");
	for(var nTmpI=0;nTmpI<strCheckBoxItem.length;nTmpI++){
		if(strCheckBoxItem[nTmpI].checked){
			fChecked = false;
			if(document.getElementsByName("strDApproxRate")[nTmpI].value==""){
				document.getElementsByName("strDApproxRate")[nTmpI].value="0";
				
				return true;
			}
			
		}
	}
	if(fChecked){
		alert("At least one Item must be selected.");
		return;
	}
	var nTmpJ=true;
	var strCheckBox=document.getElementsByName("strCheckBox");
	for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++)
			if(strCheckBox[nTmpI].checked){
				strCheckBox[nTmpI].disabled=false;
			}else{
				strCheckBox[nTmpI].disabled=true;
				document.getElementsByName("strDReqestNo")[nTmpI].disabled=true;
				document.getElementsByName("strDReqestDate")[nTmpI].disabled=true;
				document.getElementsByName("strDReqestPeriod")[nTmpI].disabled=true;
				document.getElementsByName("strDRaisingStore")[nTmpI].disabled=true;
			}
	nTmpJ = true;
	for(var nTmpI=0;nTmpI<strCheckBoxItem.length;nTmpI++){
		if(strCheckBoxItem[nTmpI].checked){
			strCheckBoxItem[nTmpI].disabled=false;
		}else{
			strCheckBoxItem[nTmpI].disabled=true;
			document.getElementsByName("strDitemId")[nTmpI].disabled=true;
			document.getElementsByName("strDitemBrandId")[nTmpI].disabled=true;
			document.getElementsByName("strDGroupId")[nTmpI].disabled=true;
			document.getElementsByName("strDSubGroupId")[nTmpI].disabled=true;
			document.getElementsByName("strDCompiledQty")[nTmpI].disabled=true;
			document.getElementsByName("strDCompiledQtyUnit")[nTmpI].disabled=true;
			document.getElementsByName("strDLstPoNo")[nTmpI].disabled=true;
			document.getElementsByName("strDLstPoDate")[nTmpI].disabled=true;
			document.getElementsByName("strDLstSupplierId")[nTmpI].disabled=true;
			document.getElementsByName("strDLstRecQty")[nTmpI].disabled=true;
			document.getElementsByName("strDLstRecQtyUnit")[nTmpI].disabled=true;
			document.getElementsByName("strDLstRecDate")[nTmpI].disabled=true;
			document.getElementsByName("strDLstPurRate")[nTmpI].disabled=true;
			document.getElementsByName("strDLstPurRateUnit")[nTmpI].disabled=true;
			document.getElementsByName("strDApproxRate")[nTmpI].disabled=true;
			document.getElementsByName("strDApproxRateUnit")[nTmpI].disabled=true;
		}
	}
	document.forms[0].hmode.value="INSERT";
	document.forms[0].submit();
}

function notGreaterThan(_these,_maxNum){
	var nNum = _these.value;
	if(nNum>_maxNum)
		_these.value = _these.value.substr(0,String(_maxNum).length);
}

function checkDataItem(_these){
	var index = getIndex(_these);
	if(_these.checked){
		document.getElementsByName("strDApproxRate")[index].disabled=false;
		document.getElementsByName("strDApproxRateUnit")[index].disabled=false;
	}else{
		document.getElementsByName("strDApproxRate")[index].disabled=true;
		document.getElementsByName("strDApproxRateUnit")[index].disabled=true;
	}
}

function maxLengthRemarks(_these,_length){
	var nLength = _these.value.length;
	if(nLength>_length)
		_these.value = _these.value.substr(0,_length);
}

function OnLoadCheck()
{	
   /*Color Change for SDF Durg
    * */
              
              var sdfFlg   = document.getElementsByName("strSDFFlag");
              var colorOne = document.forms[0].strSDFFlgColor.value;
              
					          	  for(var i = 0; i < sdfFlg.length ; i++)
								  {										
								  	//alert("sdfFlg[i]"+sdfFlg[i].value);
								  								  
								   if(sdfFlg[i].value=='Yes')
								   {
							       	  document.getElementById("tdId1"+i).style.backgroundColor = colorOne; 
									  document.getElementById("tdId2"+i).style.backgroundColor = colorOne;
									  document.getElementById("tdId3"+i).style.backgroundColor = colorOne;
									  document.getElementById("tdId4"+i).style.backgroundColor = colorOne;
									  document.getElementById("tdId5"+i).style.backgroundColor = colorOne;
									  document.getElementById("tdId6"+i).style.backgroundColor = colorOne;
									 // document.getElementById("tdId7"+i).style.backgroundColor = colorOne;
									 // document.getElementById("tdId8"+i).style.backgroundColor = colorOne;
								   }
								  }
					          
  
    	 	
 
}
function view1(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="none";
	
	document.getElementById(obj2).style.display="block";
	
	document.getElementById(obj3).style.display="block";
}
function view2(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="block";
	
	document.getElementById(obj2).style.display="none";
	
	document.getElementById(obj3).style.display="none";
}