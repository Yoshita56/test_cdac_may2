function GetIndex(index,endVal)  // Pagenation  One
{
	
	    for (var page = 1; page <= endVal; page++)       // For Loop To Put Normal CSS in All No
        {
          document.getElementById('pg'+page).className = 'pg-normal';
        }
	    var oldPageAnchor = document.getElementById('pg'+index);   // Apply CSS
        oldPageAnchor.className = 'pg-selected';
        
          for(var i = 1; i <= endVal ; i++)
		  {
			  document.getElementById("DivId"+i).style.display="none";
		  }
		  document.getElementById("DivId"+index).style.display="block";
			 
}
function GetIndex1(index,endVal)  // Pagenation  One
{
	
	    for (var page = 1; page <= endVal; page++)       // For Loop To Put Normal CSS in All No
        {
          document.getElementById('pg1'+page).className = 'pg-normal';
        }
	    var oldPageAnchor = document.getElementById('pg1'+index);   // Apply CSS
        oldPageAnchor.className = 'pg-selected';
        
          for(var i = 1; i <= endVal ; i++)
		  {
			  document.getElementById("DivId1"+i).style.display="none";
		  }
		  document.getElementById("DivId1"+index).style.display="block";
			 
}
function disOldDate(_these,index)
{
	document.getElementById("divTransferDetailsId").style.display="block";
	getTransferDetails(index); 
}
function getTransferDetails(index) 
{
	var url = "TransferRequestTransCNT.cnt?hmode=TRANSFERDTL&strHiddenValue="+ document.getElementById("strHiddenValue"+index).value;
	ajaxFunction(url, "12");

}
function drugDtl(obj,index) 
{
   if(document.getElementById("strTransferNo"+index).value!='0')
   {	
	var url = "TransferRequestTransCNT.cnt?hmode=TRANSFERITEMDTL&strTransferNo="+ document.getElementById("strTransferNo"+index).value+"^"+index+"^"+document.getElementById("strTransferStoreId"+index).value;
  	ajaxFunction(url, "13");
   }
   else
   {
   	 alert("No Details Available!!");
   	 return false;
   }	

}
function hideDrugDetails(divId,index) 
{
	hide_popup_menu(divId+""+index);
}

function getAjaxResponse(res, mode) 
{
	var objVal;	
	if (mode == "2") 
	{

		objVal = document.getElementById("ItemBrandId");
		objVal.innerHTML = "<select name ='strItemBrandId' class='comboHalfMax' onChange='getUnitName();'>"	+ res + "</select>";
		
	}	
	if (mode == '9')
	{       
		objVal = document.getElementById("SubGroupNameDiv");
		objVal.innerHTML = "<select name ='strSubGroupCode' class='comboMax'   onChange = 'ajaxItemBrandName();' >"	+ res + "</select>";
        ajaxItemBrandName();  
	}
	
	if (mode == '12')
	{		
        objVal = document.getElementById("divTransferDetails");
        objVal.innerHTML = res;
	}
	if (mode == '13')
	{		
        // alert(res);
         var divObj = document.getElementById("drugDtlId"+res.split("^")[1]);
		divObj.style.display="block";
		divObj.innerHTML = res.split("^")[0];
		
		display_popup_menu(divObj, divObj, '200', '250');
		
	}
	
	
}

function showDiv(strDivId)
{
	document.getElementById(strDivId).style.display="block";
}

function hideDiv(strDivId)
{
	document.getElementById(strDivId).style.display="none";
}

function ClearPage()
{
    document.forms[0].reset(); 
    document.getElementById("DrugNameId").innerHTML="";
	document.getElementById("unitNameId").innerHTML="";	
	document.getElementById("avlaibleQtyId").innerHTML="";
    document.getElementById("strAvlQtyInStore").value = "0";
	document.getElementById("errMsg").innerHTML="";
	document.getElementById("warningMsg").innerHTML="";
	document.getElementById("normalMsg").innerHTML="";	
}
function validateUpdate()
{
	var hisValidator = new HISValidator("transferReqTrans");
	
	hisValidator.addValidation("strDemandedQty", "req","Demanded Quantity.  is a Mandatory Field");		
	hisValidator.addValidation("strApprovedDate", "req","Approval Date is a Mandatory Field");
	hisValidator.addValidation("strApprovedDate", "dtltet="+document.forms[0].strCtDate.value,"Approval Date should be Less Than or Equal To Current Date");
	if(document.forms[0].strApprovalFlg.value=='1')
	{
		hisValidator.addValidation("strApprovedBy", "req","Approval By is a Mandatory Field");
	}	   	
    var retVal = hisValidator.validate();	
	hisValidator.clearAllValidations();
	if (retVal) 
	{	
			  var conf = confirm("You Are Going To Modify!!!");
              if(conf == true)
              {
                   var conf1 = confirm("Are you sure !!!");
                   if(conf1 == true)
                   {
                   	      document.forms[0].hmode.value = "UPDATE";
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
		return false;
	}
}
function validate1()
{
//alert("document.forms[0].strCtDate"+document.forms[0].strCtDate.value);
	var hisValidator = new HISValidator("transferReqTrans");

	hisValidator.addValidation("strItemBrandId", "dontselect=0","Please Select a Drug Name");
	hisValidator.addValidation("strDemandedQty", "req","Demanded Quantity.  is a Mandatory Field");		
	hisValidator.addValidation("strApprovedDate", "req","Approval Date is a Mandatory Field");
	hisValidator.addValidation("strApprovedDate", "dtltet="+document.forms[0].strCtDate.value,"Approval Date should be Less Than or Equal To Current Date");
	if(document.forms[0].strApprovalFlg.value=='1')
	{
		hisValidator.addValidation("strApprovedBy", "req","Approval By is a Mandatory Field");
	}	   	
    var retVal = hisValidator.validate();	
	hisValidator.clearAllValidations();
	if (retVal) 
	{	
			 var conf = confirm("You Are Going To Save!!!");
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
	else 
	{
		return false;
	}
}

function cancel(mode) 
{
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();
}




 
	 /**
	  * showView
	  * @param {String} divId 
	  */
	  function showView(divId) {
	  	
	  	document.getElementById(divId+"PlusId").style.display = "none";
	  	document.getElementById(divId+"MinusId").style.display = "block";
	  	
	  	document.getElementById(divId).style.display = "block";
	  	
	  }
	 	 
	 	 
	 /**
	  * hideView
	  * @param {String} divId 
	  */
	  function hideView(divId) {
	  	
	  	document.getElementById(divId+"PlusId").style.display = "block";
	  	document.getElementById(divId+"MinusId").style.display = "none";
	  	
	  	document.getElementById(divId).style.display = "none";
	  	
	  }	 
	 	 


function getSubGrpAndGenericItem()
{
	document.getElementById("DrugNameId").innerHTML="";
	document.getElementById("unitNameId").innerHTML="";
	document.getElementById("avlaibleQtyId").innerHTML="";
    document.getElementById("strAvlQtyInStore").value = "0";
	objVal = document.getElementById("ItemBrandId");
	objVal.innerHTML = "<select name ='strItemBrandId' class='comboHalfMax'><option value='0'>Select Value</option></select>";
	
	objVal = document.getElementById("SubGroupNameDiv");
	objVal.innerHTML = "<select name ='strSubGroupCode' class='comboMax'   onChange = 'ajaxItemBrandName();' >Select Value</select>";

	  
	   var mode = "SUBGRPNAMECMB";
	   var url = "TransferRequestTransCNT.cnt?hmode=SUBGRPNAMECMB&GroupId="+ document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value + "&storeId="+ document.forms[0].strStoreId.value;
       ajaxFunction(url, "9");
	   
	
}

function ajaxItemBrandName() 
{
	var mode = "ITEMBRANDNAME";
	
	
	var url = "TransferRequestTransCNT.cnt?hmode=ITEMBRANDNAME&storeId="
			+ document.forms[0].strStoreId.value+"&strSubGroupId="
			+ document.forms[0].strSubGroupCode.value +"&strGroupId="
			+ document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value;
		
	ajaxFunction(url, "2");
	
	

}

function getUnitName() 
{
  // Item Brand Id ^ Item Id ^ Avlaible Qty ^ Unit Name 	
  if(document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value!='0')
  {	
   document.getElementById("DrugNameId").innerHTML=document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].text;
   document.getElementById("unitNameId").innerHTML=document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value.split("^")[3];
   document.getElementById("avlaibleQtyId").innerHTML="Avl Qty. ="+document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value.split("^")[2]+"  "+document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value.split("^")[3];
   document.getElementById("strAvlQtyInStore").value = document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value.split("^")[2];
   
  }
  else
  {
  	document.getElementById("DrugNameId").innerHTML="";
  	document.getElementById("unitNameId").innerHTML="";
  	document.getElementById("avlaibleQtyId").innerHTML="";
    document.getElementById("strAvlQtyInStore").value = "0";
  }
  
}
function compareWithAvlQty(obj)
{
  	
	var avlQty = parseInt(document.getElementById("strAvlQtyInStore").value);
	var reqQty = parseInt(obj.value);
	if(avlQty > 0)
	{	
		if(reqQty>avlQty)
		{
			alert("Requested Quantity Could not be Greater than Available Quantity !!!");
			obj.value = "";
			return false;
		}
	}
	else
	{
		alert("Drug Quantity Not Available !!!");
		obj.value = "";
		return false;
	}	
}

      
        