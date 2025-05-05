
/**
 * Developer : Anshul Jindal 
 * Version : 1.0 
 * Date : 15/Apr/2009
 * 
 */
 
// call on click a check box of an item
 
 function ClickCheckBox(obj,index)
 {
 
	 var items = document.getElementsByName("strItemDetailsChk");
 	alert("items length"+items.length);
 	var length = items.length;
 	var count = 0;
 	var retVal = true;
 	for(var i=0 ; i<length ; i++)
 	{
 		if(document.getElementById("strItemDetailsChk"+i).checked==true)
 		{
 				count++;
 					alert("count"+count);
 		}
 		
 	}
 	if(count>1)
 				{
 					alert("count>1");
 					alert("Please Select Only One Item");
 					document.getElementById("strItemDetailsChk"+index).checked = false;
 					retVal = false;
 					
 					
 				}
 		if(count==1)
 				{
 				alert("count==1");
 					if(document.getElementById("strReportDtl"+index).value=="")
 					{
 					//document.getElementById("strStatus"+index).innerHTML = "Report Pending";
 					document.forms[0].strInspectionReport.value="";
 					document.forms[0].strInspectionStatus.value = "1";
 					document.forms[0].strReturnQty.value = "";
 	 				document.forms[0].strReturnUnitId.value = "0";
 					}
 					else
 					{
 					alert("index"+index)
 					var ReportDtl  = document.getElementById("strReportDtl"+index).value ;
 					alert("ReportDtl"+ReportDtl);
 					temp = ReportDtl.split("^");
 	
 	 				document.forms[0].strInspectionReport.value=temp[5];
 					document.forms[0].strInspectionStatus.value = temp[6];
 					document.forms[0].strReturnQty.value = temp[7];
 	 				document.forms[0].strReturnUnitId.value = temp[8];
 	 				}
 	 				document.getElementById("reportDetailsDivId").style.display="block";
 				
 				}
 				
 	if(count==0)
 	{
 	document.forms[0].strInspectionReport.value="";
 					document.forms[0].strInspectionStatus.value = "1";
 					document.forms[0].strReturnQty.value = "";
 	 				document.forms[0].strReturnUnitId.value = "0";
 	 				document.getElementById("reportDetailsDivId").style.display="block";
 	}
 
 // for  qty unit combo based on selected item 
 var mode ="UNITCOMBO";
   var unitId =document.getElementById("strIssueQtyUnitId"+index).value;
   var url="InspectionReportTransCNT.cnt?hmode="+mode+"&unitId="+unitId;
   ajaxFunction(url,"2");
 	return retVal;
 	
 }
 
 function getReqNo(storeObj)
 {
 var mode ="REQCOMBO";
   var storeId =storeObj.value;
   var url="InspectionReportTransCNT.cnt?hmode="+mode+"&storeId="+storeId;
   ajaxFunction(url,"3");
 
 		
 }
// CALL ON OK BUTTON IN REPORT DETAILS

function okReport()
{

	var hisValidator = new HISValidator("inspectionReportBean"); 
  	
  	hisValidator.addValidation("strInspectionReport","req","Please Write a Report");
  	hisValidator.addValidation("strInspectionReport", "maxlen=250", "Report cannot be greater than 250 Characters" );
  	hisValidator.addValidation("strInspectionStatus","dontselect=0","Please select a Status");
  	hisValidator.addValidation("strReturnQty","req","Please Enter Return Quantity");
  	hisValidator.addValidation("strReturnQty","amount=7,2","Return Quantity format is 00000.00");
  	hisValidator.addValidation("strReturnUnitId","dontselect=0","Please select a Unit");
  	
   var retVal = hisValidator.validate();
  	hisValidator.clearAllValidations();
  	
   	if(retVal)
   	{

 	var items = document.getElementsByName("strItemDetailsChk");
 	alert("items length"+items.length);
 	var length = items.length;
 
 	var Report = document.forms[0].strInspectionReport.value;
 	var ReportStatus = document.forms[0].strInspectionStatus.value;
 	var ReturnQty = document.forms[0].strReturnQty.value;
 	var ReturnQtyUnit = document.forms[0].strReturnUnitId.value;
 
 	var ReportDtl = Report+"^"+ReportStatus+"^"+ ReturnQty+"^"+ ReturnQtyUnit;
 	
 	alert("ReportDtl-"+ReportDtl);
 	
 	for(var i=0 ; i<length ; i++)
 	{
 		if(document.getElementById("strItemDetailsChk"+i).checked==true)
 		{
 		var hiddenValues = document.getElementById("strItemDetailsChk"+i).value;
 		
 			document.getElementById("strReportDtl"+i).value =hiddenValues+"^"+ReportDtl;
 			document.getElementById("strStatus"+i).innerHTML = "Done";
 			document.getElementById("strItemDetailsChk"+i).checked=false; 
 		 
 		}
	 }
	
	 document.getElementById("reportDetailsDivId").style.display="none";
	
 
 }else{
 return false;
 
 }

}


// CALL ON CANCEL BUTTON IN REPORT DETAILS

function cancelReport()
{
	var items = document.getElementsByName("strItemDetailsChk");
 	alert("items length"+items.length);
 	var length = items.length;
 	
 	for(var i=0 ; i<length ; i++)
 	{
 		if(document.getElementById("strItemDetailsChk"+i).checked==true)
 		{
 		document.getElementById("strReportDtl"+i).value ="";
 		document.getElementById("strStatus"+i).innerHTML = "Report Pending";
 		document.getElementById("strItemDetailsChk"+i).checked=false; 
 		}
	 }
	
	document.forms[0].strInspectionReport.value ="";
 	 document.forms[0].strInspectionStatus.value ="1";
 	 document.forms[0].strReturnQty.value ="";
 	 document.forms[0].strReturnUnitId.value ="0";
	 document.getElementById("reportDetailsDivId").style.display="none";
 	
	 
}

 
// CALL ON CHANGE OF ORDER COMBO TO GET ORDER DETAILS BY AJAX

function OrderDetails(reqNoObj)
{
alert("OrderDetails"+ reqNoObj.value);
 var mode ="ORDERDETAILS";
   var reqNo =reqNoObj.value;
   var url="InspectionReportTransCNT.cnt?hmode="+mode+"&reqNo="+reqNo;
   ajaxFunction(url,"1");
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
				document.getElementById("ReqDateDivId").innerHTML = temp[0];
				document.getElementById("orderNoDivId").innerHTML = temp[1];
				document.getElementById("orderDateDivId").innerHTML = temp[2];
				document.getElementById("supplierNameDivId").innerHTML = temp[3];
				document.getElementById("itemCatDivId").innerHTML = temp[4];
				document.getElementById("committeeNameDivId").innerHTML = temp[5];
				
					document.getElementById("itemDetailsDivId").innerHTML = temp1[1];
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
				document.getElementById("unitDivId").innerHTML = "<select name='strReturnUnitId'class='comboNormal'>"+res+"</select>";
				 
				
				}
		
	}
	if(mode=="3")
	{
				var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
				else{
				alert("res-"+res);
				document.getElementById("reqComboDiv").innerHTML = "<select name='strReqNo'	class='comboNormal' onchange='OrderDetails(this);'><option value='0'>Select Value</option>"+res+"</select>";
				 
				
				}
		
	}
	
	
}
	
 // call on save button 
 function saveReport()
 {
 
 	var hisValidator = new HISValidator("indentForImportItemsBean"); 
  	
   	hisValidator.addValidation("strReqNo","dontselect=0","Please select an Req. No.");
  	 var retVal = hisValidator.validate();
  	hisValidator.clearAllValidations();
  	
   	if(retVal)
   	{
   	var flag = false;
   	var CheckBox = document.getElementsByName("strReportDtl");
   	alert("chk len-"+CheckBox.length);
   	if(CheckBox.length==0)
   	{
   	alert("There Is No Item To ADD A Report");
   	return false;
   	}
   	else
   	{
   	var strSelectedChkIndex="";
   		for(i=0;i<CheckBox.length;i++)
   		{
   			if(CheckBox[i].value!="")
   			{
   			 flag = true;
   			 break;
   			}
   			
   		}
   		if(flag==false)
   		{
   		alert("Please Select An Item To ADD A Report");
   		return false;
   		}
   		
   		for(i=0;i<CheckBox.length;i++)
   		{
   		alert("CheckBox[i].value"+CheckBox[i].value);
   			if(CheckBox[i].value!="")
   			{
   			strSelectedChkIndex=strSelectedChkIndex+"^"+i;
   			alert("strSelectedChkIndex-"+strSelectedChkIndex);
   			}
   			
   		}
   		alert("strSelectedChkIndex-"+strSelectedChkIndex);
   		document.forms[0].strSelectedChkIndex.value = strSelectedChkIndex;
   		
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
		

 