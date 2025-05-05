
// call on purpose change
function ifOtherPurpose()
{
	/*if(document.forms[0].strPurposeId.value=="1")
	{
		document.getElementById("otherPurposeDiv").style.display="block";
	}
	else{
		document.getElementById("otherPurposeDiv").style.display="none";
	}*/
	if(document.forms[0].strPurposeId.value=="1")
	{
		document.forms[0].strOtherPurpose.value="";
		document.forms[0].strOtherPurpose.disabled=false;
		document.forms[0].strOtherPurpose.focus();
		
	}
	else{
		document.forms[0].strOtherPurpose.value=document.forms[0].strPurposeId[document.forms[0].strPurposeId.selectedIndex].text;
		document.forms[0].strOtherPurpose.disabled=true;
	}
	
}

// call on click installation required if yes then display charges

function ifInstallationReq()
{
	alert("ifInstallationReq");
	var install = document.getElementsByName("strIsIntallationReq");
	
	if(install[0].checked==true)
	{
	alert("if yes");
		document.getElementById("AppChargesDiv").style.display="block";
	}
	else{
		alert("no");
		document.getElementById("AppChargesDiv").style.display="none";
	}

	/*if(document.forms[0].strIsIntallationReq.value=="0")
	{
		document.getElementById("AppChargesDiv").style.display="none";
	}
	else{
		document.getElementById("AppChargesDiv").style.display="block";
	}*/


}

// call on click whether the quotatoin...to display justification if uncheck 
function BlockJustification()
{
	if(document.forms[0].strIsLowestQuotation.checked==false)
	{
		document.getElementById("justificationDiv").style.display="block";
	}
	else{
		document.forms[0].strQuotationJustification.value="";
		document.getElementById("justificationDiv").style.display="none";
	}

}


// call on change of group to get subgroup and item combo values through AJAX

function getSubgroupAndItem(obj)
{
	document.getElementById("errMsg").innerHTML = "";
   var mode ="SUBGROUPANDITEM";
   var subgroupId = document.forms[0].strSubGroupId.value;
   var groupId =obj.value;
   var storeId = document.forms[0].strStoreId.value;
   var catNo = document.forms[0].strItemCategoryNo.value;
   if(groupId!='0')
   {
	   var url="IndentForImportItemsCNT.cnt?hmode="+mode+"&groupId="+groupId+"&storeId="+storeId+"&catNo="+catNo+"&subgroupId="+subgroupId;
	   ajaxFunction(url,"1");
	   
   }
   else
   {     
        document.getElementById("subgroupDiv").innerHTML = 
		"<select name='strSubGroupId' class='comboNormal' onchange='getItemName(this);' ><option value='0'>Select Value</option></select>"; 
	
		
		document.getElementById("itemDiv").innerHTML = 
		"<select name='strItemId' class='comboNormal' onchange='getBrandName(this);' ><option value='0'>Select Value</option></select>";
		
		document.getElementById("brandDiv").innerHTML = 
		"<select name='strBrandId' class='comboNormal'  onchange='getStockDtls();' ><option value='0'>Select Value</option></select>"; 
		document.getElementById("strQtyUnitName").innerHTML = "<select name='strQtyUnitName' class='comboNormal' ><option value='0'>Select Value</option></select>";
		
		document.forms[0].strQunatityReq.value = '0';		
		
        document.getElementById("existingStockDiv").innerHTML = "";
		document.getElementById("consumedQtyDiv").innerHTML = ""; 
		document.getElementById("lstPoNoDiv").innerHTML = ""; 
		document.getElementById("lstPoDateDiv").innerHTML = "";
		document.getElementById("lstRateUnitDiv").innerHTML = ""; 
		document.getElementById("lstRecevDateDiv").innerHTML = ""; 
		document.getElementById("lstSuppliedDiv").innerHTML = ""; 
   } 
   

}


// call on change of sub-group to get item combo values through AJAX

function getItemName(obj)
{
	document.getElementById("errMsg").innerHTML = "";
   var mode ="ITEMNAME";
   var subgroupId = obj.value;
   var groupId = document.forms[0].strGroupId.value;
   var storeId = document.forms[0].strStoreId.value;
   var catNo = document.forms[0].strItemCategoryNo.value;
   var url="IndentForImportItemsCNT.cnt?hmode="+mode+"&groupId="+groupId+"&storeId="+storeId+"&catNo="+catNo+"&subgroupId="+subgroupId;
   ajaxFunction(url,"2");
    

}



// call on change of item to get brand name combo values through AJAX

function getBrandName(obj)
{
   var mode ="BRANDNAME";
   var itemId =obj.value;
   var groupId = document.forms[0].strGroupId.value;
   var subgroupId = document.forms[0].strSubGroupId.value;
   var itemId  = document.forms[0].strItemId.value;
   var storeId = document.forms[0].strStoreId.value;
   var catNo   = document.forms[0].strItemCategoryNo.value;
   
   var url="IndentForImportItemsCNT.cnt?hmode="+mode+"&itemId="+itemId+"&storeId="+storeId+"&catNo="+catNo+"&groupId="+groupId+"&subgroupId="+subgroupId;
   ajaxFunction(url,"3");
   
  

}


// call on change of item to get stock details values through AJAX

function getStockDtls()
{
   document.getElementById("errMsg").innerHTML = "";
   var mode ="STOCKDTLS";
   var groupId = document.forms[0].strGroupId.value;
   var itemId  = document.forms[0].strItemId.value;
   var storeId = document.forms[0].strStoreId.value;
   var catNo   = document.forms[0].strItemCategoryNo.value;
   var brandId = document.forms[0].strBrandId.value;
   if(brandId!='0')
   {
	   var url="IndentForImportItemsCNT.cnt?hmode="+mode+"&itemId="+itemId+"&storeId="+storeId+"&catNo="+catNo+"&brandId="+brandId;
	   ajaxFunction(url,"5");
   }
   else
   {
   	    //document.getElementById("errMsg").innerHTML = "";
        document.getElementById("existingStockDiv").innerHTML = "";
		document.getElementById("consumedQtyDiv").innerHTML = ""; 
		document.getElementById("lstPoNoDiv").innerHTML = ""; 
		document.getElementById("lstPoDateDiv").innerHTML = "";
		document.getElementById("lstRateUnitDiv").innerHTML = ""; 
		document.getElementById("lstRecevDateDiv").innerHTML = ""; 
		document.getElementById("lstSuppliedDiv").innerHTML = ""; 
   }
  

}


// call on change of supplier to display his/her address through AJAX

function getSupplierAdd(obj)
{
	var mode ="SUPPLIERADDRESS";
   var supplierId =obj.value;
   var url="IndentForImportItemsCNT.cnt?hmode="+mode+"&supplierId="+supplierId;
   ajaxFunction(url,"4");

}


function getAjaxResponse(res,mode)
{
	var objVal1;
	var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
    if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
    else{    
    
   // to display supplier address
   if(mode=="1")
	{
	
		var temp = res.split("##");
		
		document.getElementById("subgroupDiv").innerHTML = 
		"<select name='strSubGroupId' class='comboNormal' onchange='getItemName(this);' >"+temp[0]+"</select>"; 
	
		
		document.getElementById("itemDiv").innerHTML = 
		"<select name='strItemId' class='comboNormal' onchange='getBrandName(this);' >"+temp[1]+"</select>"; 
	}
	
	if(mode=="2")
	{
		document.getElementById("itemDiv").innerHTML = 
		"<select name='strItemId' class='comboNormal' onchange='getBrandName(this);' >"+res+"</select>"; 
	
	}
		 
	if(mode=="3")
	{
	    
		document.getElementById("brandDiv").innerHTML = 
		"<select name='strBrandId' class='comboNormal'  onchange='getStockDtls();' >"+res+"</select>"; 
	}
	
	
  	 
	if(mode=="4")
	{
		document.getElementById("SupplierAddDiv").innerHTML = res; 
	}
	
	if(mode=="5")
	{
	    
	    var temp = res.split("#");
	    
		document.getElementById("existingStockDiv").innerHTML = temp[0];
		document.getElementById("consumedQtyDiv").innerHTML = temp[1]; 
		
		if(temp[2]=='0' || temp[2]==''|| temp[2]=='/')
		{
		  document.getElementById("lstPoNoDiv").innerHTML = "N/A";
		}
		else
		{
		  document.getElementById("lstPoNoDiv").innerHTML = temp[2];
		} 
		
		if(temp[3]=='0' || temp[3]==''|| temp[3]=='/')
		{
		  document.getElementById("lstPoDateDiv").innerHTML = "N/A";
		}
		else
		{
		  document.getElementById("lstPoDateDiv").innerHTML = temp[3];
		} 
				
		if(temp[4]=='0' || temp[4]==''|| temp[4]=='/' || temp[4]=='0//')
		{
		  document.getElementById("lstRateUnitDiv").innerHTML = "N/A"; 
		}
		else
		{
		  document.getElementById("lstRateUnitDiv").innerHTML = temp[4];  
		} 
			
		if(temp[5]=='0' || temp[5]==''|| temp[5]=='/')
		{
		  document.getElementById("lstRecevDateDiv").innerHTML = "N/A"; 
		}
		else
		{
		  document.getElementById("lstRecevDateDiv").innerHTML = temp[5];
		} 
		
		if(temp[6]=='0' || temp[6]==''|| temp[6]=='/')
		{
		  document.getElementById("lstSuppliedDiv").innerHTML =  "N/A"; 
		}
		else
		{
		  document.getElementById("lstSuppliedDiv").innerHTML = temp[6];
		} 
		
		
		document.getElementById("ApproxRateUnitDiv").innerHTML = "<select name='strApproxRateUnitId' class='comboNormal' >"+temp[7]+"</select>";  
		document.getElementById("strQtyUnitName").innerHTML = "<select name='strQtyUnitName' class='comboNormal' >"+temp[7]+"</select>";
		document.forms[0].strHiddenStockDtl.value = temp[8];
		document.forms[0].strHiddenStockPosition.value = temp[9];
	}
	
  }
}


//call on save
function saveData()
{
    var hisValidator = new HISValidator("indentForImportItemsBean"); 
  	document.forms[0].strOtherPurpose.disabled=false;
   	hisValidator.addValidation("strGrantTypeCode","dontselect=0","Please Select a Grant Name");
   //	hisValidator.addValidation("strGroupId","dontselect=0","Please Select a Group Name");
   	hisValidator.addValidation("strItemId","dontselect=0","Please Select a Item Name");
   	hisValidator.addValidation("strCurrencyId","dontselect=0","Please Select a Currency Name");
   	hisValidator.addValidation("strApproxRate","req","Approx Rate is a mandatory field");
  	hisValidator.addValidation("strApproxRateUnitId","dontselect=0","Please Select a Unit Name");
   	hisValidator.addValidation("strSupplierId","dontselect=0","Please Select a Supplier");
   	if(document.getElementById('justificationDiv').style.display=="block")
   	{
   		hisValidator.addValidation("strQuotationJustification","req","Justification is a mandatory field");
   	}
   		
   		if(document.forms[0].strItemCategoryNo.value=="3") // for equipment category
   	{
   		hisValidator.addValidation("strWarrantyPeriod","req","Period of Warranty is a mandatory field");
   		var install = document.getElementsByName("strIsIntallationReq");
	
		if(install[0].checked==true)
		{
		hisValidator.addValidation("strInstalationApproxCharges","req","Approx Charges is a mandatory field");
		}
   	}
   		hisValidator.addValidation("strPurposeId","dontselect=0","Please Select a Purpose");
   		hisValidator.addValidation("strOtherPurpose","req","Please write a purpose");
   		hisValidator.addValidation("strJustification","req","Justification is a mandatory field");
  
   		
  		var retVal = hisValidator.validate();
  		hisValidator.clearAllValidations();
  	
   	if(retVal)
   	{
                  var conf = confirm("You Are Going To Save Records");
                  if(conf == true)
                  {
                       var conf1 = confirm("Are you sure !!!");
                       if(conf1 == true)
                       {
 						    document.forms[0].hmode.value = "SAVE";
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
	return retVal;
}


function Clear()
{
  document.getElementById("errMsg").innerHTML = "";
  document.forms[0].reset();
} 


// call on cancel

function cancel()
{
	document.forms[0].hmode.value = "CANCEL";
	document.forms[0].submit();
}