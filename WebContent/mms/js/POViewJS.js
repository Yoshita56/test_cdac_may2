/**
 * @author Pankaj Kumar Creation Date:- 10-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
function getPOItemDetails(){
	var hmode = "POITEMDETAILS"; 
	var url = "PODeskViewTransCNT.cnt?hmode="+hmode+"&strPONo="+document.forms[0].strPONo.value +"&strDNoOfView="+document.forms[0].strDNoOfView.value;
	ajaxFunction(url,"1");
}

function getAjaxResponse(res,mode){
	if(res.split("####")[0] == "ERROR"){
		document.getElementById("errMsg").innerHTML=res.split("####")[1];
	} else if(mode == '1'){
		var itemParaObj = document.getElementById("divPOItemDetails");
		itemParaObj.innerHTML = res;
		hideAllOtherView();
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
		document.getElementsByName("strDViewdQty")[index].disabled=false;
		document.getElementsByName("strDViewdQtyUnit")[index].disabled=false;
	}else{
		document.getElementsByName("strDViewdQty")[index].disabled=true;
		document.getElementsByName("strDViewdQtyUnit")[index].disabled=true;
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

function hideAllOtherView(these){
	var strView = document.getElementsByName("strDViewNo");
	var strDivId= "";
	for(var nTmpI=0;nTmpI<strView.length; nTmpI++){
		strDivId = "divView"+strView[nTmpI].value;
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
			if(strView[nTmpI].value==1){
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
	var strView = document.getElementsByName("strDViewNo");
	var index= getIndex(these)+1;
	try{
		if(document.getElementsByName("strCheckAll")[index-1].checked==true){
			var strCheckBox=document.getElementsByName("strCheckBox");
			for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++){
				if(strView[nTmpI].value==index){
					strCheckBox[nTmpI].checked=true;
					document.getElementsByName("strDViewdQty")[nTmpI].disabled=false;
					document.getElementsByName("strDViewdQtyUnit")[nTmpI].disabled=false;
				}
			}
		}else{
			var strCheckBox=document.getElementsByName("strCheckBox");
			for(var nTmpI=0;nTmpI<strCheckBox.length;nTmpI++){
				if(strView[nTmpI].value==index){
					strCheckBox[nTmpI].checked=false;
					document.getElementsByName("strDViewdQty")[nTmpI].disabled=true;
					document.getElementsByName("strDViewdQtyUnit")[nTmpI].disabled=true;
				}
			}
		}
	}catch(_Err){
	}
}