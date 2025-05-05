function viewReceiptDtls(i){

	document.getElementById("receiptDtlsId"+i).style.display = "block";
	document.getElementById("minusId"+i).style.display = "block";
	document.getElementById("plusId"+i).style.display = "none";
	
}

function cancel(){
	alert(document.forms[0].strPath.value);
	document.forms[0].hmode.value = "CANCEL";
	document.forms[0].submit();
}



function hideReceiptDtls(i){

	document.getElementById("receiptDtlsId"+i).style.display = "none";
	document.getElementById("minusId"+i).style.display = "none";
	document.getElementById("plusId"+i).style.display = "block";

}

function ajaxFunReceiptDtls(receiptNo,i)
{ 
   var mode ="RECEIPTDETAILS";
  
   var url="BillApprovalViewTransCNT.cnt?hmode="+mode+"&rcptNo="+receiptNo+'^'+i;
   ajaxFunction(url,"1");
}

function getAjaxResponse(res,mode)
{

var objVal1;
	
	
	if(mode=="1")
	{
	
		var temp = res.split('@');
	alert(temp[1]);
		var objVal1=document.getElementById("receiptDtlsId"+temp[1]);
		
		objVal1.innerHTML=temp[0];
		
		
	}
		
}