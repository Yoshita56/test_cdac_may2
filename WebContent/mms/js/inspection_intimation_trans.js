
/**
 * Developer : Anshul Jindal 
 * Version : 1.0 
 * Date : 10/Apr/2009
 * 
 */
// CALL ON CHANGE OF ORDER COMBO TO GET ORDER DETAILS BY AJAX

function OrderDetails(ordernoObj)
{
alert("OrderDetails"+ ordernoObj.value);
 var mode ="ORDERDETAILS";
   var orderNo =ordernoObj.value;
   var url="InspectionIntimationTransCNT.cnt?hmode="+mode+"&orderNo="+orderNo;
   ajaxFunction(url,"1");
} 

// call on plus/minus button of receipt no.
function showPlusMinus(obj,index)
 {    
 alert("index-"+index); 
   if(document.forms[0].button1.value != 1)
   {
    document.getElementById("itemDetailsdivid"+index).style.display="block";
    document.getElementById("minus1"+index).style.display="block";
    document.getElementById("plus1"+index).style.display="none";
    document.forms[0].button1.value = 1;
   }
   else
   {
    document.getElementById("minus1"+index).style.display="none";
    document.getElementById("plus1"+index).style.display="block";
    document.getElementById("itemDetailsdivid"+index).style.display="none";
    document.forms[0].button1.value = 0;
   } 
}

// call on plus to show item details
function getItemDetails(obj,index)
{ 
  alert("getItemDetails");
   var mode ="RECEIPTITEMDETAILS";
   var receiptNo ="1111";// document.getElementsByName('strReceiptNo'+index).value;
   var url="InspectionIntimationTransCNT.cnt?hmode="+mode+"&rcptNo="+receiptNo+"&index="+index;
   ajaxFunction(url,"2");
}



function getAjaxResponse(res,mode)
{
	var objVal1;
	if(mode=="1")
	{
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
				else{
				alert("res-"+res);
				var temp1 = res.split("@");
				var temp = temp1[0].split("^");
				document.getElementById("orderDateDivId").innerHTML = temp[0];
				document.getElementById("supplierNameDivId").innerHTML = temp[1];
				document.getElementById("itemCatDivId").innerHTML = temp[2];
				
				document.getElementById("receiptDivId").innerHTML = temp1[1];
				}
		
	}
	
	if(mode=="2")
	{
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
				else{
				alert("res-"+res);
				var temp = res.split("@");
				document.getElementById("itemDetailsdivid"+temp[1]).innerHTML = temp[0];
				}
		
	}
		
}
 
 // call on save button 
 function saveIntimation()
 {
 
 	var hisValidator = new HISValidator("inspectionIntimationBean"); 
  	
   	hisValidator.addValidation("strOrderNo","dontselect=0","Please select an Order No.");
  	hisValidator.addValidation("strCommittee","dontselect=0","Please select a Committee Name");
   var retVal = hisValidator.validate();
  	hisValidator.clearAllValidations();
  	
   	if(retVal)
   	{
   	var flag = false;
   	var CheckBox = document.getElementsByName("strItemDetailsChk");
   	alert("chk len-"+CheckBox.length);
   	if(CheckBox.length==0)
   	{
   	alert("Please select an item for any Receipt No.");
   	return false;
   	}
   	else
   	{
   	
   		for(i=0;i<CheckBox.length;i++)
   		{
   			if(CheckBox[i].checked==true)
   			{
   			 flag = true;
   			 break;
   			}
   			
   		}
   		if(flag==false)
   		{
   		alert("Please select an item for any Receipt No.");
   		return false;
   		}
   	}
   	
   	}
   	
   
   	 
  	
  	if(retVal){
  		  	 
  	 		document.forms[0].hmode.value = "SAVE";
				document.forms[0].submit();
  	 		
  	 		}
  	 		
  	else{
  		return false;
  		}
  		
 }
 
 
 function cancel()
 {
 document.forms[0].hmode.value = "CANCEL";
				document.forms[0].submit();
 }