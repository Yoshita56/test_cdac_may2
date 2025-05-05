function cancelDrugProfile(){
	document.forms[0].hmode.value = "CANCELTODESK";
	document.forms[0].submit();
}

function closeDrugProfile(){
	cancelDrugProfile();
	document.getElementById("dosageDATAID").innerHTML = "";
	document.getElementById("saftyDATAID").innerHTML = "";
	hideDosageData();
	hideSaftyData();
	popup('popUpDivId','50','30');
}
function getSubGroupCombo(){
	document.getElementById("strItemID").innerHTML="<select name='strItemID' onchange='hideAllDetails()' class='comboNormal'><option value='0'>Select Value</option></select>";
	document.getElementById("dosageDATAID").innerHTML = "";
	document.getElementById("saftyDATAID").innerHTML = "";
	document.getElementById("brandDATAID").innerHTML = "";
	hideSaftyData();
	hideBrandData();
	hideDosageData();
	var hmode = "getStrSubGroupComboValues"; 
	var url = "DrugProfileCNT.cnt?hmode="+hmode+"&strGroupID="+document.forms[0].strGroupID.value+"&strSubGroupID="+document.forms[0].combo[1].value;
	ajaxFunction(url,"2");
}
function getDrugCombo(){
	document.getElementById("dosageDATAID").innerHTML = "";
	document.getElementById("saftyDATAID").innerHTML = "";
	document.getElementById("brandDATAID").innerHTML = "";
	hideSaftyData();
	hideBrandData();
	hideDosageData();
	var hmode = "getStrDrugComboValues"; 
	var url = "DrugProfileCNT.cnt?hmode="+hmode+"&strGroupID="+document.forms[0].strGroupID.value+"&strSubGroupID="+document.forms[0].strSubGroupID.value+"&strItemID="+document.forms[0].strChkVal.value;;
	ajaxFunction(url,"3");
}

function getDosageData(){
	hideSaftyData();
	hideBrandData();
		document.getElementById("dosagePlusID").style.display = "none";
		document.getElementById("dosageMinusID").style.display = "block";
		document.getElementById("dosageDATAID").style.display = "block";
		var hmode = "dosageData"; 
		var url = "DrugProfileCNT.cnt?hmode="+hmode+"&strGroupID="+document.forms[0].strGroupID.value+"&strSubGroupID="+document.forms[0].strSubGroupID.value+"&strItemID="+document.forms[0].strItemID.value;
		ajaxFunction(url,"4");
	
}

function hideDosageData(){
	document.getElementById("dosagePlusID").style.display = "block";
	document.getElementById("dosageMinusID").style.display = "none";
	document.getElementById("dosageDATAID").style.display = "none";
}


function getSaftyData(){
	hideDosageData();
	hideBrandData()
		document.getElementById("saftyPlusID").style.display = "none";
		document.getElementById("saftyMinusID").style.display = "block";
		document.getElementById("saftyDATAID").style.display = "block";
		var hmode = "saftyData"; 
		var url = "DrugProfileCNT.cnt?hmode="+hmode+"&strGroupID="+document.forms[0].strGroupID.value+"&strSubGroupID="+document.forms[0].strSubGroupID.value+"&strItemID="+document.forms[0].strItemID.value;
		ajaxFunction(url,"5");
	
}

function hideSaftyData(){
	document.getElementById("saftyPlusID").style.display = "block";
	document.getElementById("saftyMinusID").style.display = "none";
	document.getElementById("saftyDATAID").style.display = "none";
}

function getBrandData(){
	hideDosageData();
	hideSaftyData();
	document.getElementById("brandPlusID").style.display = "none";
	document.getElementById("brandMinusID").style.display = "block";
	document.getElementById("brandDATAID").style.display = "block";
	var hmode = "brandData";
	var url = "DrugProfileCNT.cnt?hmode="+hmode+"&strGroupID="+document.forms[0].strGroupID.value+"&strSubGroupID="+document.forms[0].strSubGroupID.value+"&strItemID="+document.forms[0].strItemID.value;
	ajaxFunction(url,"6");
}

function hideBrandData(){
	document.getElementById("brandPlusID").style.display = "block";
	document.getElementById("brandMinusID").style.display = "none";
	document.getElementById("brandDATAID").style.display = "none";
}


function showPopup(){		
	var itemParaObj = document.getElementById("itemParameterDtlDivId");
	if(itemParaObj.innerHTML == ""){
		var hmode = "drugProfilePopup"; 
		var url = "DrugProfileCNT.cnt?hmode="+hmode+"&strGroupID="+document.forms[0].combo[1].value;
		ajaxFunction(url,"1");
	}else{
		popup('popUpDivId','50','30');
	}
}

function hideAllDetails(){
	function hideAllDetails(){
	document.getElementById("dosageDATAID").innerHTML = "";
	document.getElementById("saftyDATAID").innerHTML = "";
	document.getElementById("brandDATAID").innerHTML = "";
	hideDosageData();
	hideSaftyData();
	hideBrandData();
}
}

function getAjaxResponse(res,mode){
	
	if(mode == '1'){
		var itemParaObj = document.getElementById("itemParameterDtlDivId");
		itemParaObj.innerHTML = res;
		popup('popUpDivId','40','70');
		getSubGroupCombo();
	}
	if(mode == '2'){
		var itemParaObj = document.getElementById("strSubGroupID");
		itemParaObj.innerHTML = res;
		getDrugCombo();
	}
	if(mode == '3'){
		var itemParaObj = document.getElementById("strItemID");
		itemParaObj.innerHTML = res;
	}
	if(mode == '4'){
		var itemParaObj = document.getElementById("dosageDATAID");
		if(document.forms[0].strGroupID.value=='0' || document.forms[0].strItemID.value=='0')
			itemParaObj.innerHTML = "<table align='center'width='700' cellpadding='1px' cellspacing='1px'><tr><td class='multiControl'><font color='red'>No Record Found</font></td></tr></table>";
		else if(res!="")
			itemParaObj.innerHTML = res;
	}
	if(mode == '5'){
		var itemParaObj = document.getElementById("saftyDATAID");
		itemParaObj.innerHTML = res;
	}
	if(mode == '6'){
		var itemParaObj = document.getElementById("brandDATAID");
		itemParaObj.innerHTML = res;
	}
}
	 