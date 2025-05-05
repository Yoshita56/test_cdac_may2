var parent = "";

/**
 * @author Pankaj Kumar Creation Date:- 10-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
 
function onRadio(obj)
{
	if(obj.value =='0')
	{
	    document.forms[0].strIndianImportedFlg.value='0';
	    document.forms[0].strDDeliveryDate.value=document.forms[0].strIndianDeleivryDate.value;
	} 
	else
	{
		document.forms[0].strIndianImportedFlg.value='1';
		document.forms[0].strDDeliveryDate.value=document.forms[0].strImportedDeleivryDate.value;
	}
	

} 


 
function getPOTypeValues(){
	if(document.forms[0].strItemCat.value!="0" && document.forms[0].strPOTypeId.value!="0"){		
		var hmode = "GETSUPPLIERVALUES"; 
		var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strContractType="+getContractType()+"&strItemCat="+document.forms[0].strItemCat.value;
		ajaxFunction(url,"1");
	}else{
		document.getElementById("divSupplier").innerHTML="<select name='strSupplierId'><option value='0'>Select Value</option></select>";
	}
}

function getPOTypeComboValues(){	
	var hmode = "GETPOTYPEVALUES"; 
	var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strItemCat="+document.forms[0].strItemCat.value+"&strStoreId="+document.forms[0].strStoreId.value;
	//alert("URL"+url);
	ajaxFunction(url,"6");
}

function copyPotypeFromCombo(){
	document.forms[0].strPOTypeId.value=document.forms[0].strPOTypeId.value.split("^")[0];
	try{
		document.forms[0].strPOGrantType.value=document.forms[0].strPOTypeId.value.split("^")[1];
	}catch(_Err){
		
	}
}

function getOtherDetails(){
	if(document.forms[0].strPOTypeId.value!=24)
		hideDiv("divFullOtherDetails");
	else
		showDiv("divFullOtherDetails");
}

function getRequestDetails(){
	if(document.forms[0].strItemCat.value!="0" && document.forms[0].strPOTypeId.value!="0"){			
		var hmode = "REQUESTDETAILS";
		var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strPOTypeId="+document.forms[0].strPOTypeId.value+"&strItemCat="+document.forms[0].strItemCat.value+"&strStoreId="+document.forms[0].strStoreId.value+"&strPOGrantType="+document.forms[0].strPOTypeId.value.split("^")[1];
		
		ajaxFunction(url,"2");
	}else{
		document.getElementById("divRequestDetails").innerHTML="";
	}
}

function getAgentName(){
	var hmode = "GETAGENTNAMEVALUES";
	var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strItemCat="+document.forms[0].strItemCat.value;
	ajaxFunction(url,"5");
}

function getComponentDetails(){
	var hmode = "GETCOMPONENTDETAILS";
	var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strPOTypeId="+document.forms[0].strPOTypeId.value+"&strItemCat="+document.forms[0].strItemCat.value;
	ajaxFunction(url,"4");
}

function getContractType(){
	//alert("document.forms[0].strPOTypeId.split()[0].value"+document.forms[0].strPOTypeId.value.split("^")[0]);
	if(document.forms[0].strPOTypeId.value.split("^")[0]==22)
		return 10;
	if(document.forms[0].strPOTypeId.value.split("^")[0]==87)   //return type for BS -Priyesh
		return 12;
	if(document.forms[0].strPOTypeId.value.split("^")[0]==21 ||document.forms[0].strPOTypeId.value.split("^")[0]==25 ||document.forms[0].strPOTypeId.value.split("^")[0]==26 ||document.forms[0].strPOTypeId.value.split("^")[0]==27 || document.forms[0].strPOTypeId.value.split("^")[0]==23)
		return 11;
	else
		return 0;
}

function showComboInPopup(_index){
	try{
		document.getElementsByName("strDRateUnitId")[_index].style.visibility = "visible";
		document.getElementsByName("strDManufacturerId")[_index].style.visibility = "visible";
	}catch(e){
		alert(e);
	}	
}

function getAjaxResponse(_res,_mode){
	if(_res.split("####")[0] == "ERROR"){
		document.getElementById("errMsg").innerHTML=_res.split("####")[1];
	} else if(_mode == '1'){
		var itemParaObj = document.getElementById("divSupplier");
		itemParaObj.innerHTML = "<select name='strSupplierId' class='comboMax'>"+_res+"</select>";
		getRequestDetails();
	} else if(_mode == '2'){
		showDiv('divPlusMinusRequestDtl')
		var itemParaObj = document.getElementById("divRequestDetails");
		itemParaObj.innerHTML = _res;
		disCheckAll();
	} 
	else if(_mode == '3')
	{
		var itemParaObj = document.getElementById("divRequestItemDetails");
		itemParaObj.innerHTML = _res;
		getComponentDetails();
		OnLoadCheck();
	}
	 else if(_mode == '4'){
		//var itemParaObj = document.getElementById("divComponentDetails");
		//itemParaObj.innerHTML = _res;
		hideRequestItem();
	} else if(_mode == '5'){
		var itemParaObj1 = document.getElementById("divAgentName");
		var itemParaObj2 = document.getElementById("divCAName");
		itemParaObj1.innerHTML = "<select name='strDAgentName'>"+_res+"</select>";
		itemParaObj2.innerHTML = "<select name='strDCAName'>"+_res+"</select>";
		getPOTypeValues();
	} else if(_mode == '6'){
		var divPOTypeId = document.getElementById("divPOTypeId");
		divPOTypeId.innerHTML = "<select name='strComboPOTypeId' class='comboMax'  onchange='copyPotypeFromCombo(),getOtherDetails(),getPOTypeValues(),showCloseButton();'>"+_res+"</select>";
		getAgentName();
	}else if(_mode == '7'){
		var divPOTypeId = document.getElementById("divReqItemDtlId");
		divPOTypeId.innerHTML = _res;
		//alert(parent);
		display_popup_menu(parent,'divReqItemDtlId','','');
		//getAgentName();
	}
	else if(_mode == '8'){
		var divThisId = _res.split("#")[0];
		var tableObj=document.getElementById(divThisId);
		var numRows=tableObj.rows.length;
		var tabRow1;		
		var tdata=new Array();	
		tdata.length=9;
		var i;		
		var indx=numRows;	
		tabRow1=tableObj.insertRow(indx);
		tabRow1.id="tr" +(indx-1) + "";
		tabRow1.innerHTML =  _res.split("#")[1];
		
	}
	 else if(_mode == '9'){
			var itemParaObj = document.getElementById("divSuppWiseCompilation");
			itemParaObj.innerHTML = _res;
			document.getElementById('divRequestItemDetails').style.display='none';
			hideRequestItem();
		} 
	
	 else if(_mode == '90'){
			var itemParaObj = document.getElementById("divIndentNoDetail");
			itemParaObj.innerHTML = _res;
			display_popup_menu(parent,'divIndentNoDetail','300','150');
			//document.getElementById('divRequestItemDetails').style.display='none';
			//hideRequestItem();
		} 
}

function setINRCurrency(_these){
	if(_these.value==document.forms[0].strINRCurrencyId.value){
		document.forms[0].strDCurrencyValue.value=1;
		document.forms[0].strDCurrencyValue.readOnly= true;
	}else{
		document.forms[0].strDCurrencyValue.value="";
		document.forms[0].strDCurrencyValue.readOnly= false;
	}
}

function hideCloseButton(){
	try{
		document.getElementById('divHeader').deleteRow(0);
		var row = document.getElementById('divHeader').insertRow(0);
		var col = row.insertCell(0);
		row.className = "HEADER";
		col.setAttribute("colspan","4");
		col.innerHTML = "Generate PO &gt;&gt;";
		document.getElementById('divCompile').deleteRow(0);
	}catch(e){
		alert(e);
	}
}

function showCloseButton(){
	try{
		document.getElementById('divHeader').deleteRow(0);
		var row = document.getElementById('divHeader').insertRow(0);
		var col1 = row.insertCell(0);
		row.className = "HEADER";
		col1.setAttribute("colspan","3");
		col1.setAttribute("width","95%");
		col1.innerHTML = "Generate PO &gt;&gt;";
		var col = row.insertCell(1);
		col.setAttribute("width","5%");
		col.setAttribute("align","right");
		col.innerHTML = "<img style='cursor: pointer;' src='../../hisglobal/images/popUp_cancel.JPG' onclick='cancelToDesk()'>";
	}catch(e){
		alert(e);
	}
}

function showComplieButton(){
	if(!document.getElementById('divDynCompile'))
		try{
			var row = document.getElementById('divCompile').insertRow(0);
			var col = row.insertCell(0);
			col.setAttribute("width","100%");
			col.setAttribute("align","center");
			col.setAttribute("class","CONTROL");
			//col.innerHTML = "<center><div id='divDynCompile'><img src='../../hisglobal/images/Compile.png' style='cursor: pointer;' onClick='getRequestItemDetails(this);'></div></center>";
			col.innerHTML = "<center><div id='divDynCompile'>	<a href='#' class='button' id='' onclick='getRequestItemDetails(this);'><span class='compile'>Compile</span></a></div> </center>";
		}catch(e){
			alert(e);
		}
}

function howToShowCompileButton(){
	var objCheck = document.getElementsByName("strCheckBox");
	var fFlag = false;
	for(var nTmpI=0; nTmpI<objCheck.length; nTmpI++){
		if(objCheck[nTmpI].checked){
			fFlag = true;
		}
	}
	if(fFlag){
		showComplieButton();
	}else{
		 document.getElementById('divCompile').deleteRow(0);
	}
}

function hideRequestItem(_these){
	var strCheckBox=document.getElementsByName("strCheckBox");
	var fFlag="true";
	for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++){
		if(_these){
			if(strCheckBox[nTmpI].checked==true){
				var strTmpId=strCheckBox[nTmpI].value.split("^")[0]+"PlusID";
				if(strTmpId==_these.parentNode.id){
					showDiv(strCheckBox[nTmpI].value.split("^")[0]);
					showDiv(strCheckBox[nTmpI].value.split("^")[0]+"MinusID");
					hideDiv(strCheckBox[nTmpI].value.split("^")[0]+"PlusID");
				} else {
					hideDiv(strCheckBox[nTmpI].value.split("^")[0]);
					hideDiv(strCheckBox[nTmpI].value.split("^")[0]+"MinusID");
					showDiv(strCheckBox[nTmpI].value.split("^")[0]+"PlusID");
				}
			}
		} else {
			if(strCheckBox[nTmpI].checked==true){
				if(fFlag){
					showDiv(strCheckBox[nTmpI].value.split("^")[0]);
					showDiv(strCheckBox[nTmpI].value.split("^")[0]+"MinusID");
					hideDiv(strCheckBox[nTmpI].value.split("^")[0]+"PlusID");
					fFlag=false;
				} else {
					hideDiv(strCheckBox[nTmpI].value.split("^")[0]);
					hideDiv(strCheckBox[nTmpI].value.split("^")[0]+"MinusID");
					showDiv(strCheckBox[nTmpI].value.split("^")[0]+"PlusID");
				}
			}
		}
	}
}

function checkWarranty(_index){
	if(document.getElementsByName("strWarrantyRequired")[_index].checked==true)
		document.getElementsByName("strDWarrantyRequired")[_index].value="1";
	else
		document.getElementsByName("strDWarrantyRequired")[_index].value="0";
}

function checkInstallation(_index){
	if(document.getElementsByName("strInstallationRequired")[_index].checked==true)
		document.getElementsByName("strDInstallationRequired")[_index].value="1";
	else
		document.getElementsByName("strDInstallationRequired")[_index].value="0";
}
function showTax(obj, i)
{
  if(obj.value=='2')
  {
     document.getElementById("strDTax"+i).disabled=false;
  }   
  else
  {
     document.getElementById("strDTax"+i).disabled=true;
     document.getElementById("strDTax"+i).value='0';
  }   
	
}
function enableTaxType(i)
{	
     document.getElementById("strDTax"+i).disabled=false;  
}
function checkItem(obj)
{
	//alert("tdstrDSuppId"+document.getElementsByName("strDitemBrandId")[_index].value+_index);
	if(obj.checked==true)
	{
		/*document.getElementsByName("strTmpReqNo")[_index].disabled=false;
		document.getElementsByName("strTmpRaisingStore")[_index].disabled=false;
		document.getElementsByName("strDOrderQty")[_index].disabled=false;
		document.getElementsByName("strDOrderQtyUnitId")[_index].disabled=false;		
		document.getElementsByName("strDitemId")[_index].disabled=false;
		document.getElementsByName("strDitemBrandId")[_index].disabled=false;
		document.getElementsByName("strDGroupId")[_index].disabled=false;
		document.getElementsByName("strDSubGroupId")[_index].disabled=false;
		document.getElementsByName("strDSanctionQty")[_index].disabled=false;
		document.getElementsByName("strDSanctionQtyUnit")[_index].disabled=false;
		document.getElementsByName("strDRate")[_index].disabled=false;
		document.getElementsByName("strDRateUnitId")[_index].disabled=false;
		//document.getElementsByName("strDTax")[_index].disabled=false;
		document.getElementsByName("strDManufacturerId")[_index].disabled=false;
		document.getElementsByName("strDWarrantyRequired")[_index].disabled=false;
		document.getElementsByName("strDInstallationRequired")[_index].disabled=false;
		document.getElementsByName("strWarrantyRequired")[_index].disabled=false;
		document.getElementsByName("strInstallationRequired")[_index].disabled=false;
		document.getElementsByName("strMake")[_index].disabled=false;
		document.getElementsByName("strTaxType")[_index].disabled=false;
		document.getElementsByName("strDSuppId")[_index].disabled=false;*/
		var splitId=obj.id.substr(3,8);
	//	alert(splitId);
		var tableObj=document.getElementById("divId"+""+splitId);
		var numRows=tableObj.rows.length;
	//	alert(numRows);
		for(var j=0;j<numRows;j++)
		{
			var idCmbSup="CMBSUP"+splitId+""+j;
			var idQty="QTY"+splitId+""+j;
			var idCmbUnit="CMBUNIT"+splitId+""+j;
			//var idCmbSup="CMBSUP"+splitId;
			//CHK'+"+wb.getString(2)+"+"+nTmpI+
			document.getElementById(idCmbSup).disabled=false;
			document.getElementById(idQty).disabled=false;
			document.getElementById(idCmbUnit).disabled=false;
		}
		//document.getElementById("tdstrDSuppId"+document.getElementsByName("strDitemBrandId")[_index].value+_index).className="disabled";
	}
	else 
	{
		/*document.getElementsByName("strTmpReqNo")[_index].disabled=true;
		document.getElementsByName("strTmpRaisingStore")[_index].disabled=true;
		document.getElementsByName("strDOrderQty")[_index].disabled=true;
		document.getElementsByName("strDOrderQtyUnitId")[_index].disabled=true;	
		document.getElementsByName("strDitemId")[_index].disabled=true;
		document.getElementsByName("strDitemBrandId")[_index].disabled=true;
		document.getElementsByName("strDGroupId")[_index].disabled=true;
		document.getElementsByName("strDSubGroupId")[_index].disabled=true;
		document.getElementsByName("strDSanctionQty")[_index].disabled=true;
		document.getElementsByName("strDSanctionQtyUnit")[_index].disabled=true;
		document.getElementsByName("strDRate")[_index].disabled=true;
		document.getElementsByName("strDRateUnitId")[_index].disabled=true;
		document.getElementsByName("strDTax")[_index].disabled=true;
		document.getElementsByName("strDManufacturerId")[_index].disabled=true;
		document.getElementsByName("strDWarrantyRequired")[_index].disabled=true;
		document.getElementsByName("strDInstallationRequired")[_index].disabled=true;
		document.getElementsByName("strWarrantyRequired")[_index].disabled=true;
		document.getElementsByName("strInstallationRequired")[_index].disabled=true;
		document.getElementsByName("strMake")[_index].disabled=true;
		document.getElementsByName("strTaxType")[_index].disabled=true;
		document.getElementsByName("strDSuppId")[_index].disabled=true;*/
		/*var splitId=obj.id.substr(3);
		//alert(splitId);
		var idCmbSup="CMBSUP"+splitId;
		var idQty="QTY"+splitId;
		var idCmbUnit="CMBUNIT"+splitId;
		//var idCmbSup="CMBSUP"+splitId;
		//CHK'+"+wb.getString(2)+"+"+nTmpI+
		document.getElementById(idCmbSup).disabled=true;
		document.getElementById(idQty).disabled=true;
		document.getElementById(idCmbUnit).disabled=true;*/
		var splitId=obj.id.substr(3,8);
		//alert(splitId);
		var tableObj=document.getElementById("divId"+""+splitId);
		var numRows=tableObj.rows.length;
	//	alert(numRows);
		for(var j=0;j<numRows;j++)
		{
			var idCmbSup="CMBSUP"+splitId+""+j;
			var idQty="QTY"+splitId+""+j;
			var idCmbUnit="CMBUNIT"+splitId+""+j;
			//var idCmbSup="CMBSUP"+splitId;
			//CHK'+"+wb.getString(2)+"+"+nTmpI+
			document.getElementById(idCmbSup).disabled=true;
			document.getElementById(idQty).disabled=true;
			document.getElementById(idCmbUnit).disabled=true;
		}
	}
}

function getRequestItemDetails(){
	var hisValidator = new HISValidator(document.forms[0].name);
          
	//hisValidator.addValidation("strItemCat", "dontselect=0", "Please select Item Category" );
	//hisValidator.addValidation("strComboPOTypeId", "dontselect=0", "Please select PO Type" );
	//hisValidator.addValidation("strSupplierId", "dontselect=0", "Please select Supplier" );
	
	var retVal = hisValidator.validate();
	var strCheckBox=document.getElementsByName("strCheckBox");
	var strFlag = true;
	for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++)
		if(strCheckBox[nTmpI].checked==true)
			strFlag = false;

	
	if(retVal && strFlag){
		//alert("document.forms[0].strPOTypeId.value"+document.forms[0].strPOTypeId.value);
		if(document.forms[0].strPOTypeId.value!="22")
			alert("Please Select at least One Request");
		else
			alert("Please Select at least One Agenda");
		retVal = false;
	}
			
	
	if(retVal){
		showDiv('divFullCompiledBody');
		//showDiv('divSaveCancelId');
		//hideDiv("divItemCat");
		//hideDiv("divPOTypeId");
		//hideDiv("divSupplier");
		hideCloseButton();
		//document.getElementById("divItemCatLabel").innerHTML=document.forms[0].strItemCat.options[document.forms[0].strItemCat.selectedIndex].text;
		//document.getElementById("divPOTypeIdLabel").innerHTML=document.forms[0].strComboPOTypeId.options[document.forms[0].strComboPOTypeId.selectedIndex].text;
		//document.getElementById("divSupplierLabel").innerHTML=document.forms[0].strSupplierId.options[document.forms[0].strSupplierId.selectedIndex].text;
		
	
		var strCheckBox=document.getElementsByName("strCheckBox");
		for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++)
			strCheckBox[nTmpI].disabled="true";
		document.forms[0].strCheckAll.disabled="true";
		
		hideDiv('divRequestDetailsMinusID');
		hideDiv('divRequestDetails');
		hideDiv('divIndentNoDetail');
		showDiv('divRequestDetailsPlusID');
		
		
		var strReqts = document.getElementsByName("strCheckBox");
		var strRequestIds="";
		var strReqIdnDate="";
		var strCheckData="";
		var fFlag=true;
		for(var nTmpI=0; nTmpI<strReqts.length; nTmpI++)
			if(strReqts[nTmpI].checked==true)
				if(fFlag){
					fFlag=false;
					var strTmpReq = strReqts[nTmpI].value.split("^");
					strReqIdnDate=strTmpReq[0]+"/"+strTmpReq[2];
					strCheckData=strReqts[nTmpI].value;
					strRequestIds=strTmpReq[0];
				}else{
					var strTmpReq = strReqts[nTmpI].value.split("^"); 
					strReqIdnDate+="^"+strTmpReq[0]+"/"+strTmpReq[2];
					strCheckData+="~"+strReqts[nTmpI].value;
					strRequestIds+="^"+strTmpReq[0];
				}
		var hmode = "GETREQUESTITEMDETAILS";
		var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&strPOTypeId="+document.forms[0].strPOTypeId.value+"&strItemCat="+document.forms[0].strItemCat.value+"&strSupplierId="+document.forms[0].strSupplierId.value+"&strContractType="+getContractType()+"&strRequestIds="+strRequestIds+"&strCurrentDate="+document.forms[0].strCurrentDate.value+"&strReqIdnDate="+strReqIdnDate+"&strCheckData="+strCheckData;
		//alert(url);
		ajaxFunction(url,"3");	
	}
}

function checkData(_these){
	howToShowCompileButton();
	if(_these.checked && (document.forms[0].strPOTypeId.value==25||document.forms[0].strPOTypeId.value==26||document.forms[0].strPOTypeId.value==27)){
		var strCheckBox = document.getElementsByName("strCheckBox");
		var nTmpTotalCheckedBox=0;
		for(var nTmpI=0;nTmpI<strCheckBox.length; nTmpI++){
			if(strCheckBox[nTmpI].checked)
				nTmpTotalCheckedBox++;
		}
		if(nTmpTotalCheckedBox>1){
			_these.checked=false;
			alert("Can not Select more than one request for select PO Type.");
			return;
		}
	}
		
	if(_these.checked){
		var index = getIndex(_these);
		document.getElementsByName("strDRequestNo")[index].disabled=false;
		document.getElementsByName("strDRaisingStore")[index].disabled=false;
		document.getElementsByName("strDRequestDate")[index].disabled=false;
		document.getElementsByName("strDCRNo")[index].disabled=false;
		document.getElementsByName("strDRequestType")[index].disabled=false;
		document.getElementsByName("strDRequestPeriod")[index].disabled=false;
	}else{
		var index = getIndex(_these);
		document.getElementsByName("strDRequestNo")[index].disabled=true;
		document.getElementsByName("strDRaisingStore")[index].disabled=true;
		document.getElementsByName("strDRequestDate")[index].disabled=true;
		document.getElementsByName("strDCRNo")[index].disabled=true;
		document.getElementsByName("strDRequestType")[index].disabled=true;
		document.getElementsByName("strDRequestPeriod")[index].disabled=true;
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

function showDiv(_strDivId){
	//alert(_strDivId);
	document.getElementById(_strDivId).style.display="block";
}

function hideDiv(_strDivId){
	//alert(_strDivId);
	document.getElementById(_strDivId).style.display="none";
}

function checkAll(){
	try{
		if(document.forms[0].strCheckAll.checked==true){
			var strCheckBox=document.getElementsByName("strCheckBox");
			for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++){
				strCheckBox[nTmpI].checked=true;
				document.getElementsByName("strDRequestNo")[nTmpI].disabled=false;
				document.getElementsByName("strDRaisingStore")[nTmpI].disabled=false;
				document.getElementsByName("strDRequestDate")[nTmpI].disabled=false;
				document.getElementsByName("strDCRNo")[nTmpI].disabled=false;
				document.getElementsByName("strDRequestType")[nTmpI].disabled=false;
				document.getElementsByName("strDRequestPeriod")[nTmpI].disabled=false;
			}
		}else{
			var strCheckBox=document.getElementsByName("strCheckBox");
			for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++){
				strCheckBox[nTmpI].checked=false;
				document.getElementsByName("strDRequestNo")[nTmpI].disabled=true;
				document.getElementsByName("strDRaisingStore")[nTmpI].disabled=true;
				document.getElementsByName("strDRequestDate")[nTmpI].disabled=true;
				document.getElementsByName("strDCRNo")[nTmpI].disabled=true;
				document.getElementsByName("strDRequestType")[nTmpI].disabled=true;
				document.getElementsByName("strDRequestPeriod")[nTmpI].disabled=true;
			}
		}
	}catch(_Err){
	}
	howToShowCompileButton();
}

function calculateNetAmount(){
	var nOrderQty = document.getElementsByName("strDOrderQty");
	var nOrderQtyUnit = document.getElementsByName("strDOrderQtyUnitId");
	var nRate = document.getElementsByName("strDRate");
	var nRateUnitId = document.getElementsByName("strDRateUnitId");
	var nTax = document.getElementsByName("strDTax");
	var nNetAmount = 0;
	for(var nTmpI=0; nTmpI<nOrderQty.length; nTmpI++)
	{
		if(!nOrderQty[nTmpI].disabled)
		{
			if(nTax[nTmpI].value!='0' || nTax[nTmpI].value.length > 0)
			{
			    var nMultplyTax = (1+(nTax[nTmpI].value/100));
			}
			else
			{
				var nMultplyTax = 1;
			}
			nNetAmount +=(((nOrderQty[nTmpI].value*(nOrderQtyUnit[nTmpI].value.split("^")[1])*nRate[nTmpI].value)/(nRateUnitId[nTmpI].value.split("^")[1]))*nMultplyTax);
		}
	}
	document.forms[0].strDNetAmount.value=nNetAmount*(1+(document.forms[0].strDOverAllTax.value/100));
}

function validate1()
{	
	//alert(document.getElementsByName("strHiddenValue").length);
	//return false;
	if(confirm("Are you sure want to save data ???"))
	{
		if(confirm("Are you sure ???"))
		{
			var hisValidator = new HISValidator(document.forms[0].name);
          
			//hisValidator.addValidation("strDPurchaseSource", "dontselect=0", "Please Enter Purchase Source." );
			hisValidator.addValidation("strDDeliveryLocation", "dontselect=0", "Please select Delivery Location." );
			hisValidator.addValidation("strDDeliveryDate", "req", "Please enter Delivery Date." );	
			//hisValidator.addValidation("strDPORefNo", "req", "Please enter PO Ref. No." );
			hisValidator.addValidation("strVerifiedBy", "dontselect=0", "Please Select PO Raised By." );
			hisValidator.addValidation("strDDeliveryDate", "dtgtet="+document.forms[0].strCurrentDate.value, "Delivery Date Must be greater or equals to then Current Date." );
			
			var retVal = hisValidator.validate();
			hisValidator.clearAllValidations();
			if(!retVal){
				return;
			}
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

function validateDraft()
{	
	//alert(document.getElementsByName("strHiddenValue").length);
	//return false;
	if(confirm("Are you sure want to save data ???"))
	{
		if(confirm("Are you sure ???"))
		{
			var hisValidator = new HISValidator(document.forms[0].name);
          
			//hisValidator.addValidation("strDPurchaseSource", "dontselect=0", "Please Enter Purchase Source." );
			hisValidator.addValidation("strDDeliveryLocation", "dontselect=0", "Please select Delivery Location." );
			hisValidator.addValidation("strDDeliveryDate", "req", "Please enter Delivery Date." );	
			//hisValidator.addValidation("strDPORefNo", "req", "Please enter PO Ref. No." );
			hisValidator.addValidation("strVerifiedBy", "dontselect=0", "Please Select PO Raised By." );
			hisValidator.addValidation("strDDeliveryDate", "dtgtet="+document.forms[0].strCurrentDate.value, "Delivery Date Must be greater or equals to then Current Date." );
			
			var retVal = hisValidator.validate();
			hisValidator.clearAllValidations();
			if(!retVal){
				return;
			}
				document.forms[0].hmode.value="INSERTMODIFYDRAFT";
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

function disCheckAll(){
	if(document.getElementsByName("strPOTypeId")[0].value==25||document.getElementsByName("strPOTypeId")[0].value==26||document.getElementsByName("strPOTypeId")[0].value==27){
		var objCheckAll = document.getElementsByName("strCheckAll");
		for(var nTmpI=0; nTmpI<objCheckAll.length; nTmpI++){
			objCheckAll[nTmpI].disabled=true;
		}
	}
}

function checkOrderQty(_these){
	var e = document.getElementById(_these.id);
	for(var i = 0;i<document.getElementsByName("strCheckBoxItem").length;i++)
	{
		if(document.getElementsByName("strCheckBoxItem")[i].checked)
		{
			for(var j=0;j<(document.getElementsByName("strDSuppId").length-1);j++)
			{
				if(document.getElementsByName("strCheckBoxItem")[i].id.substr(3,8) == _these.id.substr(6,8))
				{
					if(document.getElementsByName("strDSuppId")[j].value == document.getElementById(_these.id).value && j != _these.id.substr(14,1))
					{
						//alert(e.options[e.selectedIndex].text+" has already been selected,Kindly select another supplier");
						//document.getElementById(_these.id).value = "0@0";
					}
				}
			}
		}
	}
	document.getElementById(_these.id).style.backgroundColor = "";
	var e = document.getElementById(_these.id);
	var strUser = e.options[e.selectedIndex].value;
	var tmp= "RATE"+""+_these.id.substr(6);
	document.getElementById(tmp).value=strUser.split("@")[1];
	var totRate =Math.round(( strUser.split("@")[1] * document.getElementById("QTY"+""+_these.id.substr(6)).value)*100)/100;
	document.getElementById("TRATE"+""+_these.id.substr(6)).value=totRate;
	document.getElementById("SLIFE"+""+_these.id.substr(6)).value=strUser.split("@")[2];
	document.getElementById("TAX"+""+_these.id.substr(6)).value=strUser.split("@")[3];
	document.getElementById("TAX"+""+_these.id.substr(6)).disabled = false;
	if(strUser.split("@")[1] == "0")
		document.getElementById(tmp).disabled = false;
	if((strUser.split("@")[2] == "0"))
		document.getElementById("SLIFE"+""+_these.id.substr(6)).disabled=false;
}

function getTotRate(_these)
{
	var totRate =Math.round(( document.getElementById("RATE"+""+_these.id.substr(4)).value * document.getElementById("QTY"+""+_these.id.substr(4)).value)*100)/100;
	document.getElementById("TRATE"+""+_these.id.substr(4)).value=totRate;
}

function calcTotalRate(_these){
	
	//var e = document.getElementById(_these.id).value;
	var tq=0;
	var tableObj=document.getElementById("divId"+_these.id.substr(3,8));
	var numRows=tableObj.rows.length;
		for (var v = 0;v<numRows;v++)
			{
				tq = parseInt(tq) + parseInt(document.getElementById(_these.id.substr(0,11)+""+v).value);
			}
	if(parseInt(tq) > parseInt(document.getElementById("BQTY"+""+_these.id.substr(3,8)).value))
	{
		alert("Total order Qty can't be greater than Total Req. Qty.");
		document.getElementById(_these.id).value = "";
	}
	if(document.getElementById("RATE"+""+_these.id.substr(3)).value == "")
		alert("Kindly select supplier");
		
	document.getElementById("TRATE"+""+_these.id.substr(3)).value =Math.round((document.getElementById("RATE"+""+_these.id.substr(3)).value * document.getElementById(_these.id).value)*100)/100;
		
}
/*
function calcTotalRate(_these){
	
	//var e = document.getElementById(_these.id).value;
	var tq=0;
	var tableObj=document.getElementById("divId"+_these.id.substr(3,8));
	var numRows=tableObj.rows.length;
		for (var v = 0;v<numRows;v++)
			{
				tq = parseInt(tq) + parseInt(document.getElementById(_these.id.substr(0,11)+""+v).value);
			}
	if(parseInt(tq) > parseInt(document.getElementById("BQTY"+""+_these.id.substr(3,8)).value))
	{
		alert("Total order Qty can't be greater than Total Req. Qty.");
		document.getElementById(_these.id).value = "";
	}
	if(document.getElementById("RATE"+""+_these.id.substr(3)).value == "")
		alert("Please select supplier or check whether Rate Contract exists for the item ");
		
	document.getElementById("TRATE"+""+_these.id.substr(3)).value =Math.round((document.getElementById("RATE"+""+_these.id.substr(3)).value * document.getElementById(_these.id).value)*100)/100;
		
}
*/
function calcRatenAll(_these){
	
	//var e = document.getElementById(_these.id).value;
	var tq=0;
	var tableObj=document.getElementById("divId"+_these.id.substr(3,8));
	var numRows=tableObj.rows.length;
		for (var v = 0;v<numRows;v++)
			{
				tq = parseInt(tq) + parseInt(document.getElementById(_these.id.substr(0,11)+""+v).value);
			}
	if(parseInt(tq) > parseInt(document.getElementById("BQTY"+""+_these.id.substr(3,8)).value))
	{
		alert("Total order Qty can't be greater than Total Req. Qty. i.e. "+parseInt(document.getElementById("BQTY"+""+_these.id.substr(3,8)).value));
		document.getElementById(_these.id).value = "";
	}
	if(document.getElementById("RATE"+""+_these.id.substr(3)).value == "")
		alert("Kindly select supplier ");
		
	document.getElementById("TRATE"+""+_these.id.substr(3)).value =Math.round((document.getElementById("RATE"+""+_these.id.substr(3)).value * document.getElementById(_these.id).value)*100)/100 + ((document.getElementById("TAX"+""+_these.id.substr(3)).value * document.getElementById("RATE"+""+_these.id.substr(3)).value * document.getElementById(_these.id).value)/100);
		
}

function OnLoadCheck()
{	
   /*Color Change for SDF Durg
    * */
              
              var sdfFlg   = document.getElementsByName("strSDFFlag");
              var colorOne = document.forms[0].strSDFFlgColor.value;
              
					          	  for(var i = 0; i < sdfFlg.length ; i++)
								  {																	  
								   if(sdfFlg[i].value=='Yes')
								   {
							       	  document.getElementById("tdId1"+i).style.backgroundColor = colorOne; 
									  document.getElementById("tdId2"+i).style.backgroundColor = colorOne;
									  document.getElementById("tdId3"+i).style.backgroundColor = colorOne;
									  document.getElementById("tdId4"+i).style.backgroundColor = colorOne;
									  document.getElementById("tdId5"+i).style.backgroundColor = colorOne;
									  document.getElementById("tdId6"+i).style.backgroundColor = colorOne;
									  document.getElementById("tdId7"+i).style.backgroundColor = colorOne;
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

function numericWithTwoDecimalPlaces(fld, milSep, decSep, e)
{
	var sep = 0;
	var key = '';
	var milSep="";
	var i = j = 0;
	var len = len2 = 0;
	var strCheck = '0123456789';
	var aux = aux2 = '';
	var whichCode = (window.Event) ? e.which : e.keyCode;
	//if (whichCode == 13) return true;  // Enter
	if (whichCode == 0)	return true; //tab-index
	//alert(whichCode);
	if (whichCode == 8) return true;  // Back-Space 
	key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		//len = fld.value.length;
		len=11;
		for(i = 0; i < len; i++)
		if ((fld.value.charAt(i) != decSep)) break;
		aux = '';
	for(; i < len; i++)
	if (strCheck.indexOf(fld.value.charAt(i))!=-1) aux += fld.value.charAt(i);
	aux += key;
	len = aux.length;
	if (len == 0) fld.value = '';
	if (len == 1) fld.value = ''+ decSep + '' + aux;
	if (len == 2) fld.value = ''+ decSep + aux;
	if (len > 2) {
	aux2 = '';
	for (j = 0, i = len - 3; i >= 0; i--) {
	if (j == 3) {
	aux2 += milSep;
	j = 0;
	}
	aux2 += aux.charAt(i);
	j++;
	}
	fld.value = " ";
	len2 = aux2.length;
	for (i = len2 - 1; i >= 0; i--)
	fld.value += aux2.charAt(i);
	fld.value += decSep + aux.substr(len - 2, len);
	}
	return false;
}	 

function checkDecimalValue()
{
	
	 var rate=document.forms[0].strDRate.value;
	 var checkRate=document.forms[0].strDRate.value.split(".");
	 if(checkRate.length > 2)
	{
		alert("Plese Enter the Correct Value");
		document.forms[0].strDRate.value = "";
		return false;
	}
		
	if(checkRate[1].length > 4 )
	{
		alert("Please Enter the digits after decimal places Less than Equal to 4 digits !");
		document.forms[0].strDRate.value = checkRate[0]+"."+checkRate[1].substr(0,4);
		return false;
	}
	
	
}
function numericWithFourDecimalPlaces(fld, milSep, decSep, e)
{
	//alert("hhhhhhhhhh");
	var sep = 0;
	var key = '';
	var milSep="";
	var i = j = 0;
	var len = len2 = 0;
	var strCheck = '0123456789';
	var aux = aux2 = '';
	var whichCode = (window.Event) ? e.which : e.keyCode;
	//if (whichCode == 13) return true;  // Enter
	if (whichCode == 0)	return true; //tab-index
	//alert(whichCode);
	if (whichCode == 8) return true;  // Back-Space 
	key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		//len = fld.value.length;
		len=13;
		for(i = 0; i < len; i++)
		if ((fld.value.charAt(i) != decSep)) break;
		aux = '';
	for(; i < len; i++)
	if (strCheck.indexOf(fld.value.charAt(i))!=-1) aux += fld.value.charAt(i);
	aux += key;
	len = aux.length;
	
	if (len == 0) fld.value = '';
	if (len == 1) fld.value = ''+ decSep + '' + aux;
	if (len == 2) fld.value = ''+ decSep + aux;
	if (len == 3) fld.value = ''+ decSep + aux;
	if (len == 4) fld.value = ''+ decSep + aux;
	if (len > 4) {
	aux2 = '';
	for (j = 0, i = len - 5; i >= 0; i--) {
	if (j == 5) {
	aux2 += milSep;
	j = 0;
	}
	aux2 += aux.charAt(i);
	j++;
	}
	fld.value = " ";
	len2 = aux2.length;
	for (i = len2 - 1; i >= 0; i--)
	fld.value += aux2.charAt(i);
	fld.value += decSep + aux.substr(len - 4, len);
	}
	
	
	return false;
}

function get_item_details(obj,i)
{
	parent=obj;
	var hmode = "GETITEMDETAILS";
	var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&ItemID="+document.getElementsByName("strDitemId")[i].value+"&strItemBrandID="+document.getElementsByName("strDitemBrandId")[i].value+"&strRaisingStore="+document.getElementsByName("strTmpRaisingStore")[i].value+"&strReqIds="+document.getElementsByName("strCheckBoxItem")[i].value+"&poTypeId="+document.getElementsByName("strPOTypeId")[0].value;
	ajaxFunction(url,"7");
       
}
function addSuppiler(obj,i)
{
	
	document.getElementById(obj.id).style.display='none';
	document.getElementById("addSupp"+i).style.display='';
	var tq=0;
	var tableObj=document.getElementById("divId"+obj.id.substr(3,8));
	var numRows=tableObj.rows.length;
		for (var v = 0;v<numRows;v++)
		{
			if(document.getElementById("QTY"+""+obj.id.substr(3,8)+""+v).value == "")
	    	{
	    		alert("Please Enter Order Quantity");
	    		document.getElementById("QTY"+""+obj.id.substr(3,8)+""+v).focus();
	    		return false;
	    	}
			else
				tq = parseInt(tq) + parseInt(document.getElementById("QTY"+""+obj.id.substr(3,8)+""+v).value);
		}
    
    if(parseInt(document.getElementById("BQTY"+""+obj.id.substr(3,8)).value) == parseInt(tq))
    {
    	alert("No more order Qty left");
    	document.getElementById(obj.id).style.display='';
    	return false;
    }
	var t = document.getElementById("CMBSUP"+""+obj.id.substr(3)).options.length ;
	if(numRows == t)
		{
		alert("No Supplier left");
		document.getElementById(obj.id).style.display='';
    	return false;
		}
	
		if(document.getElementById("CMBSUP"+""+obj.id.substr(3)).value == 0)
		{
				alert('Please select supplier first');
				 return false;
		}
	var hmode = "ADDSUPPLIER";
	var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&Index="+(numRows-1)+"&ItemID="+document.getElementsByName("strDitemId")[i].value+"&strItemBrandID="+obj.id.substr(3,8)+"&strRaisingStore="+document.getElementsByName("strTmpRaisingStore")[i].value+"&strReqIds="+document.getElementsByName("strCheckBoxItem")[i].value+"&itemCat="+document.getElementsByName("strItemCat")[0].value+"&contractType="+12+"&suppId="+document.getElementsByName("strDSuppId")[i].value+"&unitId="+document.getElementsByName("strDOrderQtyUnitId")[i].value+"&divThisId=divId"+obj.id.substr(3,8);
	ajaxFunction(url,"8");
       
}

function compile_supp_wise()
{
	
	var strCheckBox=document.getElementsByName("strCheckBoxItem");
	var strFlag = true;
	for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++)
		if(strCheckBox[nTmpI].checked==true)
			strFlag = false;

	
	if(strFlag){
		alert("Please select atleast one item to proceed");
		return false;
	}
	
	var chklen=0;supp = [],item=[],brand=[],tqty=[], qty = [],rate=[],trate=[],qtyunit=[],tax=[],dgrp=[];
	
	for(var i = 0;i<document.getElementsByName("strCheckBoxItem").length;i++)
	{
		if(document.getElementsByName("strCheckBoxItem")[i].checked)
		{
			chklen++;
			item[i]=document.getElementsByName("strDitemId")[i].value;
			brand[i]=document.getElementsByName("strDitemBrandId")[i].value;
			tqty[i]=document.getElementsByName("strTmpBalQty")[i].value;
			dgrp[i]=document.getElementsByName("strDGroupId")[i].value;
			var j = 0;
			var totQty = 0;
			while(j<document.getElementsByName("strDSuppId").length)
			{
				if(document.getElementsByName("strCheckBoxItem")[i].id.substr(3,8) == document.getElementsByName("strDSuppId")[j].id.substr(6,8))
				{
					if(document.getElementsByName("strDSuppId")[j].value == '0@0')
					{
						alert("Kindly select Supplier");
						document.getElementsByName("strDSuppId")[j].style.backgroundColor = "#AFEEEE";//to change color of supplier combo if suppliet not selected
						return false;
					}
					else
					{
						supp[j] = document.getElementsByName("strDSuppId")[j].value.split("@")[0]+"^"+item[i]+"^"+brand[i]+"^"+tqty[i];
						rate[j] = document.getElementsByName("strDRateUnit")[j].value+"^"+item[i]+"^"+brand[i];
						trate[j] =document.getElementsByName("strDTotalRate")[j].value+"^"+item[i]+"^"+brand[i];
						tax[j] = (document.getElementsByName("strDTax")[j].value == null || document.getElementsByName("strDTax")[j].value == '' ? "0.00" : document.getElementsByName("strDTax")[j].value ) +"^"+item[i]+"^"+brand[i];
						
					}
					
					if(document.getElementsByName("strDOrderQty")[j].value == '')
					{
						alert("Please enter Qty");
						document.getElementsByName("strDOrderQty")[j].focus();
						return false;
					}
					else
					{
						qty[j] = document.getElementsByName("strDOrderQty")[j].value+"^"+item[i]+"^"+brand[i];
						qtyunit[j] = document.getElementsByName("strDOrderQtyUnitId")[j].value.split("^")[0]+"^"+item[i]+"^"+brand[i];
						totQty = parseInt(totQty) + parseInt(document.getElementsByName("strDOrderQty")[j].value);
					}
					
				}	
				j++;
			}
			//alert(document.getElementById("tdstrDitemBrandId"+""+document.getElementsByName("strCheckBoxItem")[i].id.substr(3,8)+""+"0"));
			//alert(document.getElementById("tdstrDitemBrandId"+""+document.getElementsByName("strCheckBoxItem")[i].id.substr(3,8)+""+"0").innerHTML);
			//alert(parseInt(document.getElementById("BQTY"+""+document.getElementsByName("strCheckBoxItem")[i].id.substr(3,8)).value));
			if(totQty != parseInt(document.getElementById("BQTY"+""+document.getElementsByName("strCheckBoxItem")[i].id.substr(3,8)).value))
			{
				alert("Total Requested Qty and Total Ordered Qty for '"+ document.getElementById("tdstrDitemBrandId"+""+document.getElementsByName("strCheckBoxItem")[i].id.substr(3,8)+""+i).innerHTML +"' should be same");
				return false;
			}
		}
		else
		{
			item[i]="0";
			brand[i]="0"
			tqty[i]="0";
		}
	}
	//if(chklen > 45)
	//{
		//alert("Only 45 items can be processed at a time");
		//return false;
	//}
	document.getElementById("compile_btn").style.display="none";
	document.getElementById("svbtn").style.display="block";
	
	//document.getElementById("divRequestItemDetails").style.display="none";
	var nodes = document.getElementById("divRequestItemDetails").getElementsByTagName('*');
    for(var i = 0; i < nodes.length; i++){
        nodes[i].disabled = true;
    }
    document.getElementById("divSaveCancelId").style.display="";
	var hmode = "SUPPLIERWISECOMPILATION";
	
	//JSONObject jsonObj = new JSONObject(formBean.getStrcheckvalue()[i].toString());
	//String adharid=jsonObj.getString("crno");
	//alert(document.getElementsByName("strpoDate")[0].value);
	var objData;
	//if(document.forms[0].tmpPoType.value == "21")
		//objData = { ItemID: item , strItemBrandID: brand , strRaisingStore: document.getElementsByName("strStoreId")[0].value , itemCat: document.getElementsByName("strItemCat")[0].value , poType: document.getElementsByName("strPOTypeId")[0].value , suppId: supp , unitId: qtyunit , tqty:tqty , rate:rate,  trate: trate , qty: qty , tax:tax, fromDate:document.getElementsByName("strFromDate")[0].value , toDate: document.getElementsByName("strToDate")[0].value}; 
		//objData = { ItemID: "0" , strItemBrandID: "0"};
//	else
		objData = { ItemID: item , strItemBrandID: brand , strRaisingStore: document.getElementsByName("strStoreId")[0].value , itemCat: document.getElementsByName("strItemCat")[0].value , poType: document.getElementsByName("strPOTypeId")[0].value , suppId: supp , unitId: qtyunit , tqty:tqty , rate:rate,  trate: trate , qty: qty , tax:tax,poDate: document.getElementsByName("strpoDate")[0].value,grp: dgrp};
   
	
	sendData(objData);
	//var jsonText1 =  JSON.stringify(objData); 
//	var json_upload = "json_name=" + JSON.stringify({name:"John Rambo", time:"2pm"});
	//localStorage.setItem('jsoncache', JSON.stringify(objData));
	//myJSONObject = JSON.parse(localStorage['jsoncache']);
	
	
	//if(document.forms[0].tmpPoType.value == "21")
	//	var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&ItemID="+item+"&strItemBrandID="+brand+"&strRaisingStore="+document.getElementsByName("strStoreId")[0].value+"&itemCat="+document.getElementsByName("strItemCat")[0].value+"&poType="+document.getElementsByName("strPOTypeId")[0].value+"&suppId="+supp+"&unitId="+qtyunit+"&tqty="+tqty+"&rate="+rate+"&trate="+trate+"&qty="+qty+"&tax="+tax+"&fromDate="+document.getElementsByName("strFromDate")[0].value+"&toDate="+document.getElementsByName("strToDate")[0].value;
	//else
	//	var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode;//+"&jsnObj="+jsonText1;
	//	ajaxFunctionJSON(url,"9",json_upload);
		
		
	
}

function sendData(objData) {
	$.ajax({
	        url:createFHashAjaxQuery( "PODeskGenerateTransCNT.cnt?hmode=SUPPLIERWISECOMPILATION"),
	        type: 'POST',
	        data: { json: JSON.stringify(objData)},
	        success: function(data){
	        	//alert(data);
	            $("#divSuppWiseCompilation").html(data);
	            document.getElementById('divRequestItemDetails').style.display='none';
	        	hideRequestItem();
	            //alert(data);
	        },
	        error:function(error){
	        	//alert(error);
	            console.log("error",error);
	        },
	    });
	 // alert(res);
	 // var itemParaObj = document.getElementById("divSuppWiseCompilation");
//		itemParaObj.innerHTML = res;
//		document.getElementById('divRequestItemDetails').style.display='none';
//		hideRequestItem();
	}

var objXmlHttp = null;
var userMode = "";

/**
* ajaxFunction is the global function to retrieve data using ajax.
* param 1. myurl - url to be given by the user.
* param 2. mode - there will be hardcoded function i.e. getAjaxResponse(res,mode). This function will be defined by 
the developer. Mode specifies unique value provided by user at the time of calling ajaxfunction().
* This function will recieve the final response(to be defined at user end).
*/

function ajaxFunctionJSON(myurl,mode,myVar)
{

	//adt_create_loading_msg();//loading_msg
	userMode = mode;
	myurl = createFHashAjaxQuery(myurl);
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
			objXmlHttp.onreadystatechange=sendReq
		} 
		catch(e){ 
			alert("Error. Scripting for ActiveX might be disabled");
			return; 
		} 
	}
	else {
		if (navigator.userAgent.indexOf("Mozilla")>=0){
			objXmlHttp=new XMLHttpRequest();
			  objXmlHttp.onload=sendReq
			  objXmlHttp.onerror=sendReq
		}
	}

	//objXmlHttp.open("GET",myurl,true);
	objXmlHttp.open("POST", myurl);
	objXmlHttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	alert(myVar);
	objXmlHttp.send(myVar);

	//objXmlHttp.send(null)
} 

//internal function called from ajaxFunction() function
function sendReq()
{
    //for(var i=0;i<=500000;i=i+1);
    if (objXmlHttp.readyState==4 || objXmlHttp.readyState==200) 
    {
		var res = objXmlHttp.responseText; 
		eval("getAjaxResponse" + '(res' + "," + userMode + ")"); // evel is a keyword - it calls the function passed in it as argument.
	     document.getElementById("normalMsg").style.display="none";//hiding normal msg
	     try
	     {
	     	//autoTabIndexing();
	     }
	     catch(_Err)
	     {
	     	//alert("Application Error[TabIndex not Included] Please Contact System Administrator");
	     }
	     //alert(eventElementObj.name);
	     try
	     {
	     	eventElementObj.focus();
	     }
	     catch(_Err)
	     {	     	
	     }
	}
}


function save_draftpo()
{	
	//alert(document.getElementsByName("strDitemBrandId").length);
	var brandid=[],qty=[],j=0;
	if(confirm("Are you sure want to save data ???"))
	{
		if(confirm("Are you sure ???"))
		{
			for(var i=0;i<document.getElementsByName("strDitemBrandId").length;i++)
			{
				if(document.getElementsByName("strDOrderQty")[i].value > 0 )
				{
					brandid[j]=document.getElementsByName("strDitemBrandId")[i].value;
					qty[j]=document.getElementsByName("strDOrderQty")[i].value;
					j++;
					
					
				}
				document.getElementsByName("strHiddenValue")[i].disabled=false;
				document.getElementsByName("strDitemBrandId")[i].disabled=false;
			}
				document.forms[0].hmode.value="FINALSAVE";
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
function getIndentDetails(indentNo,storeId)
{
	var hmode = "INDENTNODETAIL";
	var url = "PODeskGenerateTransCNT.cnt?hmode="+hmode+"&indentNo="+indentNo+"&strRaisingStore="+storeId;
	ajaxFunction(url,"90");
}
function selectAll()
{
	for(var i=0;i<document.getElementsByName("strCheckBoxItem").length;i++)
	{
		document.getElementsByName("strCheckBoxItem")[i].checked=true;
		checkItem(document.getElementsByName("strCheckBoxItem")[i]);
	}
}