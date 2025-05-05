var printflag=true;
var retValue=true;
function CallCustomFunc(val)
{
	
		/* var reqQty = document.getElementsByName("strQtyText");
			 reqQty[0].focus();*/
			
}	

function getItemSelectPopup() 
{
	//alert('12');
	var strRequestType = "32";
	var strModeVal = "3";
	var strItemCategory =document.getElementsByName('stritemcat')[0].value;
	//alert(strItemCategory);
	if(strItemCategory == '0')
		{
		  alert('Please Select Item Category');
		  return false;
		}
//document.forms[0].strDoseFrqFlg.value="1";
	/*var strFromStoreId =document.getElementsByName('strToStoreName')[0].value; 
	if(strFromStoreId == '0')
	{
		  alert('Please Select Store Name');
		  return false;
		}*/
		//document.getElementsByName('strId')[0].value.split("^")[0];
 //   if(document.forms[0].strDoseFrqFlg.value=='1')
//	{
		    // Commented by Amit for GGSH
	
		//	var      strMultiRowCompArray = new Array('itemParamValue', 'itemCalcValue','itemUserValue', 'strDose', 'strFrequency', 'strDays', 'strReqQty');
		//	var  strMultiRowCompTypeArray = new Array('t', 't', 't', 's', 's', 't');
//	}
//	else
//	{
	var      strMultiRowCompArray = new Array('itemParamValue', 'itemCalcValue','itemUserValue', 'strCost', 'strRate' , 'strReqQty','strTotalCost');
		var  strMultiRowCompTypeArray = new Array('t', 't');
	//}
	var strMultiRowFetchDataArray = new Array('1', '65','5', '4','66' , '11');

	var layerIndex = "1";
	//searchItems(strModeVal, strItemCategory, strRequestType, strFromStoreId,
	//		strMultiRowCompArray, strMultiRowCompTypeArray,
	//		strMultiRowFetchDataArray, layerIndex);   
			
			
	var userFunctionName     = "CallCustomFunc";
	var strFromStoreId =document.forms[0].strStoreId.value;
	var userFunctionArgument = "test";
	var strUserInfo =""; 
	var strUnitMode = "0"; // only base unit  1 Means Only Base Unit Show 0 Means All Unit Show in Unit Combo
	//                searchItems(strModeVal, strItemCategory, strRequestType, strFromStoreId,strMultiRowCompArray,strMultiRowCompTypeArray,strMultiRowFetchDataArray, layerIndex);
	//alert(strItemCategory+"2");
	searchItemsWithUserFunction(strModeVal, strItemCategory, strRequestType, strFromStoreId,strMultiRowCompArray,strMultiRowCompTypeArray,strMultiRowFetchDataArray, layerIndex,userFunctionName, userFunctionArgument ,strUserInfo , strUnitMode);		
}

function ftnTick(mode)
{
  if(mode=='1')
  {
  	document.forms[0].strOutOfStockFlag.value='1';
  	document.forms[0].OutOfStockFlag[0].checked=false;
  	document.forms[0].OutOfStockFlag[1].checked=true;
  }
  else
  {
  	document.forms[0].strOutOfStockFlag.value='0';
  	document.forms[0].OutOfStockFlag[0].checked=true;
  	document.forms[0].OutOfStockFlag[1].checked=false;
  }
	
} 
function getMultiRow(obj)
{
	 document.getElementById("hearderId").style.display = "block";
     	var noOfRow = document.forms[0].strNoOfMultiRow.value;
     	for(var i=0; i<noOfRow;i++)
     	{     		
     		addRows(new Array('strNotInListDrugName','strNotInListDrugQty'),new Array('t','t'),'2','1','R')
     	}
 	
}
function QtyValidation(index)
{		
		//alert(index);
		if(document.getElementById("strQtyText"+index).value!="")
		{
			    var issueQty     = document.getElementById("strQtyText"+index).value;
			    var   avlQty     = document.getElementById("strAvalqty"+index).value;
			   //  alert(avlQty);
			  var cost =document.getElementById("strDefaultRateDiv"+index).innerHTML;
			   //alert(cost);
			    //var prescQty     = document.getElementById("strPrescQty"+index).value;
				if(parseInt(avlQty)<parseInt(issueQty,10))
				{
					alert("Request Quantity is greater than Available Quantity");					
					//document.getElementById("strQtyText"+index).value="";
					//return false;
				}	
				/*if(parseInt(prescQty,10)<parseInt(issueQty,10) || prescQty.length=='0' )
				{
					alert("Issue Quantity cannot be greater than Prescribe Quantity");					
					document.getElementById("strQtyText"+index).value="";
					return false;
				}	*/		
				
				var TotalCost = cost *  document.getElementById("strQtyText"+index).value;
				//alert(TotalCost);
				document.getElementById("strCost"+index).innerHTML = TotalCost.toFixed(2);
				//document.getElementById("strCost1-"+index).innerHTML= parseFloat(objVal2) * parseFloat(qty);
				//document.getElementById("strCost1-"+index).innerHTML= document.getElementById("strtotalHidden").value;
				document.getElementById("strTotalHiddenDiv"+index).value=TotalCost.toFixed(2);
				  var i=0;
				  var Total=0;
				  //alert(document.getElementsByName("strTotalHiddenDiv1").length);
					while((i<document.getElementsByName("strTotalHiddenDiv1").length) )// document.getElementsByName("strTotalCostText")[i].value!="")//!=null && document.getElementsByName("strTotalCostText")[i]!=null)
				{
						//alert(document.getElementsByName("strTotalHiddenDiv1")[i].value);
				if( document.getElementsByName("strTotalHiddenDiv1")[i].value!="")
							{
				Total=parseFloat(Total)+parseFloat(document.getElementsByName("strTotalHiddenDiv1")[i].value);
				
						}
				i++;
					}
					//alert('Total'+Total);
                    document.getElementById("strtotalDiv").innerHTML = "Rs. "+Total.toFixed(2);
                    document.getElementById("strtotalHidden").value=Total.toFixed(2);
					/*if(Total > document.getElementsByName(strLFBalanceAmount)[0].value)
						{
						 alert("Total amount is greater then LF Balance!");
						 return false;
						}*/

					
                    setTotalAmt(Total , document.getElementById("strNetCost1").value);
				
			
		}
}

function QtyValidation1(index)
{		
		//alert(index);
		if(document.getElementById("strQtyText1"+index).value!="")
		{
			    var issueQty     = document.getElementById("strQtyText1"+index).value;
			    var   avlQty     = document.getElementById("itemParaId4"+index).innerHTML;
			     //alert(avlQty);
			  var cost =document.getElementById("itemParaId5"+index).innerHTML;
			   //alert(cost);
			    //var prescQty     = document.getElementById("strPrescQty"+index).value;
				if(parseInt(avlQty)<parseInt(issueQty,10))
				{
					alert("Request Quantity is greater than Available Quantity");					
					document.getElementById("strQtyText1"+index).value="0";
					return false;
				}	
				/*if(parseInt(prescQty,10)<parseInt(issueQty,10) || prescQty.length=='0' )
				{
					alert("Issue Quantity cannot be greater than Prescribe Quantity");					
					document.getElementById("strQtyText"+index).value="";
					return false;
				}	*/		
				
				var TotalCost = cost *  document.getElementById("strQtyText1"+index).value;
				//alert(TotalCost);
				document.getElementById("strTotalCostText1"+index).value = TotalCost.toFixed(2);
				//document.getElementById("strCost1-"+index).innerHTML= parseFloat(objVal2) * parseFloat(qty);
				//document.getElementById("strCost1-"+index).innerHTML= document.getElementById("strtotalHidden").value;
				//document.getElementById("strTotalHiddenDiv"+index).value=TotalCost.toFixed(2);
				  var i=0;
				  var Total=0;
				  //alert(document.getElementsByName("strTotalHiddenDiv1").length);
					while((i<document.getElementsByName("strTotalCostText1").length) )// document.getElementsByName("strTotalCostText")[i].value!="")//!=null && document.getElementsByName("strTotalCostText")[i]!=null)
				{
						//alert(document.getElementsByName("strTotalHiddenDiv1")[i].value);
				if( document.getElementsByName("strTotalCostText1")[i].value!="")
							{
				Total=parseFloat(Total)+parseFloat(document.getElementsByName("strTotalCostText1")[i].value);
				
						}
				i++;
					}
					//alert('Total'+Total);
                    document.getElementById("strNetCost").innerHTML = "Rs. "+Total.toFixed(2);
                    document.getElementById("strNetCost1").value = Total.toFixed(2);
					/*if(Total > document.getElementsByName(strLFBalanceAmount)[0].value)
						{
						 alert("Total amount is greater then LF Balance!");
						 return false;
						}*/
                    
                    
                    setTotalAmt(document.getElementById("strtotalHidden").value , Total.toFixed(2));
				
			
		}
}
function checkPresQty(index)
{
	var prescQty     = document.getElementById("strPrescQty"+index).value;
	if(parseInt(prescQty,10)=='0' ||parseInt(prescQty,10)==0 )
	{
	    alert("Prescribe Quantity cannot be equal to Zero");
	     document.getElementById("strPrescQty"+index).value="";				
		return false;
	}
}

function printDataOne(mode) 
{
	newwin = window.open('', 'printwin',
			'left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n')
	newwin.document.write('<script>\n');
	newwin.document.write('function chkstate(){ \n');
	// newwin.document.write('if(document.readystate=="complete" ||
	// document.readystate=="undefined"){\n');
	newwin.document.write('window.close();\n');
	// newwin.document.write('}\n');
	// newwin.document.write('else{\n');
	// newwin.document.write('setTimeout("chkstate()",2000)\n');
	// newwin.document.write('}\n');
	newwin.document.write('}\n');
	newwin.document.write('function print_win(){\n');
	newwin.document.write('window.print();\n');
	newwin.document.write('chkstate();\n');
	newwin.document.write('}\n');

	newwin.document.write('<\/script>\n');
	newwin.document.write('</HEAD>\n');
	newwin.document.write('<BODY onload="print_win()">\n');
	if(mode=='1')
	{
		if(document.getElementById('issueDtlsDivId').innerHTML != "")
			newwin.document.write(document.getElementById('issueDtlsDivId').innerHTML);	
		else
			newwin.document.write(document.getElementById('transferDtlsDivId').innerHTML);	
	}
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();
	 document.getElementById("strCrNo").focus();

}
function hideIssuePopupOne() 
{
	//alert('sadasd');
	//alert(document.forms[0].strcallfromipd.value);
	/*if(document.forms[0].strcallfromipd.value == '1')
	{
		//alert('if');
		document.forms[0].hmode.value = "cancelIssuetoIpd";
		document.forms[0].submit();
	}else{*/
		
	document.getElementById("transferDtlsDivId").innerHTML = "";
	hide_popup('popUpDiv1');
	//document.getElementById("strCrNo").focus();
	//}
}
function transferToViewPage()
{
	if (document.getElementsByName("strViewChk")[0].checked) 
	{
		document.forms[0].hmode.value = "VIEWPAGE";
		document.forms[0].submit();
	}
}

function cancelIssue()
{
	//showMenuFrame();
	document.forms[0].hmode.value = "CANCELTODESK";
	document.forms[0].submit();
	//window.parent.closeTab();
}

function clearIssue() {
	/*document.forms[0].strIssueNum.value = "";
	document.forms[0].strId.value = "";
//	document.formas[0].strLFNo.value="";
	var url;
	printflag= false;
	var mode = "unspecified";
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();*/
	
	   document.forms[0].reset();
}

var gblObject = "";

function getItemDetails() {

	var url = "IssueTransCNT.cnt?" +
			"=ITEMDETAILS&reqNo=" + gblObject
			+ "&crNo=" + document.forms[0].crNo.value + "&strId="
			+ document.forms[0].strId.value;

	ajaxFunction(url, "7");

}

function getConsultantCombo() {

	var url = "IssueTransCNT.cnt?hmode=PRESCRIPEDBY&unitCode="
			+ document.forms[0].strUnitCode.value;
	ajaxFunction(url, "6");

}

function getUnitCombo() {

	var url = "/INVMGM/mms/transactions/IssueTransCNT.cnt?hmode=UNITCMB&deptCode="
			+ document.forms[0].strDeptCode.value;
	ajaxFunction(url,"5");

}

function getRequestDetail(obj) {

	if (obj == null)
		return false;

	gblObject = obj.value;

	
	var url = "DossierRequisitionCNT.cnt?hmode=GETDOSSIERITEMDTLS&dossiercode="
		+ document.forms[0].strDossiercat.value;

	ajaxFunction(url, "4");

}

function getPrevIssueDtl() {

	var url = "IssueTransCNT.cnt?hmode=PREVISSUEDTL&strId="
			+ document.forms[0].strId.value + "&itemCategory="
			+ document.forms[0].itemCategory.value + "&crNo="
			+ document.forms[0].crNo.value;
	ajaxFunction(url, "2");

}

function getItemCat() {

	var strStoreId = null;
	if (document.forms[0].strStoreId != null) {
		strStoreId = document.forms[0].strStoreId.value;
	}
	if (strStoreId != null && strStoreId != "0") {
		var url = "IssueTransCNT.cnt?hmode=ITEMCATCMB&storeId="
				+ document.forms[0].strStoreId.value + "&modeVal="
				+ document.forms[0].strMode.value;
		ajaxFunction(url, "1");
	} else {
		document.getElementById("itemcatDivId").innerHTML = "<select name ='strItemCat' class='comboNormal' ><option value='0'>Select Value</option></select>";
	}
}

function getItemCatCombo() {

	var strStoreId = null;
	if (document.forms[0].strId != null) {
		strStoreId = document.forms[0].strId.value;
	}
	if (strStoreId != null && strStoreId != "0") {
		var url = "/INVMGM/mms/transactions/IssueTransCNT.cnt?hmode=ITEMCATCMB&storeId="
				+ document.forms[0].strId.value + "&modeVal=5";
		//alert(url);
				ajaxFunction(url, "12");
		
	} else {
		document.getElementById("itemcatDivId").innerHTML = "<select name ='strItemCat' class='comboNormal' ><option value='0'>Select Value</option></select>";
	}
}

var objGlobal = "";

function getIssuePopUp(these, index) 
{

	objGlobal = these;
	var url = "IssueTransCNT.cnt?hmode=ISSUEDTLPOPUP&strId="
			+ document.getElementById("strIssueSoreID"+index).value + "&issueNo="
			+ document.getElementById("strIssueNo" + index).value;
	//alert(url);
	ajaxFunction(url, "3");

}

function getAjaxResponse(res, mode) {

	if (mode == "1") {
		if (res == "") {
			document.getElementById("itemcatDivId").innerHTML = "<select name ='strItemCat' class='comboNormal' ><option value='0'>Select Value</option></select>";
		} else {
			var objVal = document.getElementById("itemcatDivId");
			objVal.innerHTML = "<select name ='strItemCat' class='comboNormal' >"
					+ res + "</select>";
		}
	}

	if (mode == "2") {

		var objVal = document.getElementById("issueDtlDivId");

		objVal.innerHTML = res;

	}

	if (mode == "3") {
	//	alert(res);
		var objVal = document.getElementById("issueDtlsDivId");
	objVal.innerHTML = res;
		//alert(document.getElementById("issueDtlsDivId").innerHTML);
		//display_popup_menu(objGlobal, "issueDtlsDivId", '60', '80');
		popup('popUpDiv1' , '250','250');
	}

	if (mode == "4") {

		var objVal = document.getElementById("requestDivId");
		objVal.innerHTML = res;

		if (document.forms[0].strIssueMode.value != 0) {
			document.getElementById("reqDtlDivId").style.display = "none";
			document.getElementById("itemDtlOffDivId").style.display = "none";
		}

		document.getElementById("itemDtlDivId").style.display = "block";

		getItemDetails();

	}
	if (mode == "5") {
		if (res == "") {
			document.getElementById("unitDivId").innerHTML = "<select name ='strUnitCode' id='unit' class='comboNormal' ><option value='0'>Select Value</option></select>";
		} else {
			var objVal = document.getElementById("unitDivId");
			//alert(res);
			objVal.innerHTML = "<select name ='strUnitCode' id='unit' class='comboNormal' onchange='getConsultantCombo();' >"
					+ res + "</select>";
			getItemCatCombo();
		}
		
		if(document.getElementsByName("strPatientStatus")[0].value == '2')
		{
			document.forms[0].strUnitCode.value=document.getElementsByName("strAdmissionDtlHidVal")[0].value.split("^")[16];
			document.getElementById("dep").disabled = true;
			document.getElementById("unit").disabled = true;
		}
		else
			if(document.forms[0].strDeptCode.value == document.getElementsByName("strEpisodeCode")[0].value.substr(0,3))
				document.forms[0].strUnitCode.value = document.getElementsByName("strEpisodeCode")[0].value.substr(0,5);
		
	}

	if (mode == "6") {
		if (res == "") {
			document.getElementById("consultantDivId").innerHTML = "<select name ='strPrescribedBy' class='comboNormal' ><option value='0'>Select Value</option></select>";
		} else {
			var objVal = document.getElementById("consultantDivId");
			objVal.innerHTML = "<select name ='strPrescribedBy' class='comboNormal' >"
					+ res + "</select>";
		}
	}
	if (mode == "7") {

		var objVal = document.getElementById("itemDtlDivId");
		objVal.innerHTML = res;

		getRequestDtl();

	}
	
	
	if (mode == "8") 
	{	
		var itemStockObj = document.getElementById("issueDtlsDivId");
		itemStockObj.innerHTML = res;
		document.getElementById("normalMsg").innerHTML = "Data Saved Successfully";
		document.forms[0].strStoreId.disabled=false;
		//popup('popUpDiv', '60', '80');	
		//document.getElementById("strCrNo").focus(); 
	}
	
	if (mode == "9") 
	{	//alert('res'+res);
		var itemStockObj = document.getElementById("transferDtlsDivId");
		itemStockObj.innerHTML = res;
		document.getElementById("normalMsg").innerHTML = "Data Saved Successfully";
		//document.forms[0].strStoreId.disabled=false;
		popup('popUpDiv1', '60', '80');	
		
	}
	if (mode == "12") {
		if (res == "") {
			//alert('1');
			document.getElementById("itemcatDivId").innerHTML = "<select name ='stritemcat' class='comboNormal' ><option value='0'>Select Value</option></select>";
		} else {
			//alert(res);
			var objVal = document.getElementById("itemcatDivId");
			objVal.innerHTML = "<select name ='stritemcat' class='comboNormal' >"
					+ res + "</select>";
		}
	}

	if(mode=="11")
	{
		var itemTmp="";
		var itemParVal     = document.getElementsByName("itemParamValue");
		 	if(itemParVal.length>1)
			{												
				 for(var i=0;i<itemParVal.length-1;i++)
				 {
					 for(var j=0;j<res.split(",").length;j++)
					 {						 
						 if(itemParVal[i].value.split("^")[22] == res.split(",")[j])
							 itemTmp += itemParVal[i].value.split("^")[0]  + ", ";
					 }
				 }
			}
		 	if(itemTmp != "")
			{
				alert("Kindly remove " + itemTmp + " from list as for given items billing can't be processed");
				return false;
			}
		 	else
		 	{
		 		 var retVal = false;
		 		
		 		//	var saveObj = document.getElementById("saveId");
		 		
		 			//if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
		 		//	{
		 			//	saveObj.style.display = "none"; 
		 		
		 				if (document.getElementsByName("strQtyText").length <= 1) 
		 				{
		 					alert("Please Select Item from Search Utility!!!");
		 				//	saveObj.style.display = ""; 
		 					return false;
		 				}
		 				
		 				var hisValidator = new HISValidator("issueBean");
		 				
		 				hisValidator.addValidation("strDeptCode", "dontselect=0",	 "Department is a Mandatory Field");
		 				
		 				hisValidator.addValidation("strUnitCode", "dontselect=0",	 "Unit is a Mandatory Field");

		 				//hisValidator.addValidation("strPrescribedBy", "dontselect=0",	 "Prescribed By Doctor is a Mandatory Field");
		 				//hisValidator.addValidation("strPrescribedFor", "req",	 "Prescribed for  is a Mandatory Field");
		 				//hisValidator.addValidation("strPrescriptionFrom", "dontselect=0",	 "Prescription from  is a Mandatory Field");

		 				
		 				
		 				hisValidator.addValidation("strQtyText", "req",	 "Quantity is a Mandatory Field");
		 				hisValidator.addValidation("strPrescriptionDate", "req","Issue Date is a Mandatory Field");
		 		        hisValidator.addValidation("strPrescriptionDate", "dtltet="	+ document.forms[0].strCtDate.value,"Please Select Issue Date Less Than or Equal To Current Date");
		 				hisValidator.addValidation("strPrescribedBy", "req","Prescribed By is Mandatory");
		 				hisValidator.addValidation("strRemarks", "maxlen=100","Remarks should have less than or equal to 100 Characters");
		 				
		 				retVal = hisValidator.validate();
		 				hisValidator.clearAllValidations();
		 					
		 				if (retVal) 
		 				{
		 			        var itemParVal     = document.getElementsByName("itemParamValue");
		 				    var itemUserValue  = document.getElementsByName("itemUserValue");
		 				    var reqQty         = document.getElementsByName("strQtyText");
		 				    var count = 0;
		 				    
		 				   
		 				    
		 				    if(itemParVal.length>1)
		 					{												
		 						 for(var i=0;i<itemParVal.length-1;i++)
		 						 {
		 						 	itemUserValue[i].disabled=false;
		 						 
		 						 	if(reqQty[i].value > 0)
		 						 	{
		 						 		count = 1;
		 						 		break;
		 						 	}												 	
		 						 }									  
		 					}	
		 															
		 					if(count  == 0)
		 					{
		 						alert("Please enter one Quantity Greater than Zero!!!");
		 						//saveObj.style.display = "";
		 						return false;
		 					}
		 					 if(itemParVal.length>1)
			 					{												
			 						 for(var i=0;i<itemParVal.length-1;i++)
			 						 {
			 							for(var j=i+1;j<itemParVal.length-1;j++)
				 						 {
			 								//alert(itemUserValue[i].value);
			 								//alert(itemUserValue[i].value.split('^')[1]);
			 								//alert(itemUserValue[j].value.split('^')[1]);
				 							if(itemUserValue[i].value.split('^')[1] == itemUserValue[j].value.split('^')[1])
				 								{
				 									alert('Kindly Remove Duplicate Drug '+itemParVal[i].value.split('^')[0]+' From List');
				 									return false;
				 								}
				 						 	
				 						 }	
			 						 	//itemUserValue[i].disabled=false;
			 						 }									  
			 					}	
		 					//alert(document.getElementsByName("strLFAccountNo")[0].value);
		 					//return false;
		 			          if(document.getElementsByName("strLFAccountNo")[0]==null || document.getElementsByName("strLFAccountNo")[0]=="")
		 			        	 var conf = confirm("You are going to save Data.");
		 			          else
		 		              var conf = confirm("Net Amount will be Deducted From your LF Account Balance.");
		 		              if(conf == true)
		 		              {
		 		                   var conf1 = confirm("Are you sure?");
		 		                   if(conf1 == true)
		 		                   { 
		 		                 //  alert(printflag);
		 		                	  // alert(document.getElementsByName('strCatGrp')[0].value);
		 		                	  // alert(document.forms[0].strLFAccountNo.value);
		 		                	   
		 		                	 document.getElementById("dep").disabled = false;
		 		         			document.getElementById("unit").disabled = false;
		 		         			
		 		                	   if(document.getElementsByName("strPatientStatus")[0].value != 2)
		 		                	   {
		 		                		   if( (document.getElementsByName("strLFAccountNo")[0]==null || document.getElementsByName("strLFAccountNo")[0] == '') )	//document.getElementsByName('strCatGrp')[0].value != '1'  check removed to issue medicines to staff as car grp = 0 means paid and 1 means staff
		 		                			   document.forms[0].hmode.value = "INSERTTEMP";
		 		                		   else
		 		                			   document.forms[0].hmode.value = "INSERT";
		 		                	   }
		 		                	   else
		 		                	   {
		 		                		  if(document.forms[0].strcallfromipd.value == '3')
		 		                			  {
		 		                			 document.forms[0].hmode.value = "INSERTIPDFROMBILL";
		 		                			  }else{
		 		                		  document.forms[0].hmode.value = "INSERTIPD";
		 		                			  }
		 		                	   }
		 		                		   document.forms[0].submit();
		 		                   }
		 		                  else
		 		                   {
		 		               //    	saveObj.style.display = "";
		 		                     return false;
		 		                   }
		 		               }
		 		              else
		 		               {
		 		             //  	saveObj.style.display = "";
		 		                     return false;
		 		               }    
		 		
		 				} else {
		 				//	saveObj.style.display = "";
		 					return false;
		 				}
		 	}
		 	
	}
	printflag = false;
}

function validateIssue() 
{
	validateTariff();
		
}

function validateTariff()
{
	var itemTmp="";
	var itemParVal     = document.getElementsByName("itemParamValue");
	 if(itemParVal.length>1)
		{												
			 for(var i=0;i<itemParVal.length-1;i++)
			 {
				 if(i==0)
					 itemTmp = itemParVal[i].value.split("^")[22];
				 else
					 itemTmp+= ","+itemParVal[i].value.split("^")[22];
			 }
		}
	 
	 var url = "IssueTransCNT.cnt?hmode=TARIFFCHK&itemTmp="+ itemTmp;
	ajaxFunction(url, "11");
	 
}
function validateTariff2()
{
	retValue=false;
	 
}
function hideIssueDetails(divId) {
	//hide_popup_menu(divId);
	 hide_popup(divId);
}

function initGoFunc(eve) {
	var flag = validateData(eve, 5);
	if (flag) {
		if (eve.keyCode == 13) {
			onGoButton();
		}
	} else {
		return false;
	}

}

function goFuncOnEnter(e) {
	if (e.keyCode == 13) {
		onGoButton();
	} else {
		return false;
	}
}

function onGoButton() {

	var hisValidator = new HISValidator("DossierRequisitionBean");

	hisValidator.addValidation("strStoreId", "dontselect=0",
			"Select Drug Warehouse Name from Drug Warehouse Combo ");
	hisValidator.addValidation("strItemCat", "dontselect=0",
			"Select Item Category from Item Category Combo");
	if (document.getElementsByName('strCRorLFwise')[0].checked)
	{	
		hisValidator.addValidation("strCrNo", "req","Please enter CR No. ");
		document.forms[0].strStoreId.disabled=true;
		//return false;
	}
	else if (document.getElementsByName('strCRorLFwise')[1].checked)
	{		
		hisValidator.addValidation("strLFNo", "req","Please enter LF No. ");
		document.forms[0].strStoreId.disabled=true;
		//return false;
	}	
	else
		document.forms[0].strStoreId.disabled=false;
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

    
    document.forms[0].strItemCat.disabled=false;
	document.forms[0].storeName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	document.forms[0].itemCatName.value = document.forms[0].strItemCat[document.forms[0].strItemCat.selectedIndex].text;
	document.forms[0].crNo.value = document.forms[0].strCrNo.value;

	document.forms[0].strId.value = document.forms[0].strStoreId.value.split("^")[0];
	document.forms[0].itemCategory.value = document.forms[0].strItemCat.value;

	if (retVal) 
	{
		document.forms[0].strStoreId.disabled=false;
		document.forms[0].hmode.value = "issuetopatientcount";
		document.forms[0].submit();

	} else {
		return false;
	}
}

function onCheckCategory() {

	var patientDtlHidVal = document.forms[0].strPatientDtlHidVal.value;
	var temp = patientDtlHidVal.split('^');

	if (document.forms[0].strMode.value == '0') {

		if (document.forms[0].strConfCatCode.value == temp[3]) {
			document.getElementById("allDivId").style.display = "none";
			alert("Go to Staff Counter....");
			document.forms[0].hmode.value = "INITVAL";
			document.forms[0].submit();
			return false;

		}

	} else if (document.forms[0].strMode.value == '1') {

		if (document.forms[0].strConfCatCode.value != temp[3]) {
			document.getElementById("allDivId").style.display = "none";
			alert("Go to Patient Counter....");
			document.forms[0].hmode.value = "INITVAL";
			document.forms[0].submit();
			return false;

		}
	}
	onCheckInBoth();

}

function onCheckInBoth() {
	
//	if(document.getElementsByName('strVisitType')[0].value != '2' && document.getElementsByName('strVisitType')[0].value != '3' && document.getElementsByName('strCatGrp')[0].value != '1' && (document.getElementsByName("strLFAccountNo")[0] == null || document.getElementsByName("strLFAccountNo")[0] == ''))
	/*if(document.getElementsByName("strPatientStatus")[0].value == '2')
	{
		alert("Medicines can only be issued to OPD/EMG Patients Only");
		controlToIssueToPatientPage();
	}*/

	if (document.forms[0].strIssueMode.value == '2') {

		//document.getElementsByName('strRadioOnlineReqVal')[0].checked == false;
		document.getElementById("requestDivId").style.display = "none";
		document.getElementById("itemDtlDivId").style.display = "none";

	} else if (document.forms[0].strIssueMode.value == '0') {

		//document.getElementsByName('strRadioOnlineReqVal')[0].checked = true;
		//getRequestDetail(document.getElementsByName('strRadioOnlineReqVal')[0]);
	}
}

function getPatDtl() {

	document.getElementById("patientDetailsDivId").style.display = "block";
	document.getElementById("minus1").style.display = "block";
	document.getElementById("plus1").style.display = "none";
}
function getPatDtl1() {

	document.getElementById("patientDetailsDivId").style.display = "none";
	document.getElementById("minus1").style.display = "none";
	document.getElementById("plus1").style.display = "block";
}
// added by shefali on 26-aug-2014 for pateint treatment in issue to pateint
function getPatTrtDtl() {

	document.getElementById("patientTreatmentDetailsDivId").style.display = "block";
	document.getElementById("minus3").style.display = "block";
	document.getElementById("plus3").style.display = "none";
}
function getPatTrtDtl1() {

	document.getElementById("patientTreatmentDetailsDivId").style.display = "none";
	document.getElementById("minus3").style.display = "none";
	document.getElementById("plus3").style.display = "block";
}
//added by shalini on 030feb-2016 for pateint diagnosis details in issue to pateint
function getPatDiagDtl() {

	document.getElementById("patientDiagDetailsDivId").style.display = "block";
	document.getElementById("minus4").style.display = "block";
	document.getElementById("plus4").style.display = "none";
}
function getPatDiagDtl1() {

	document.getElementById("patientDiagDetailsDivId").style.display = "none";
	document.getElementById("minus4").style.display = "none";
	document.getElementById("plus4").style.display = "block";
}

function disPreviousIssueDtl() {

	document.getElementById("issueDtlDivId").style.display = "block";
	document.getElementById("minus2").style.display = "block";
	document.getElementById("plus2").style.display = "none";

}
function disPreviousIssueDtl1() {

	document.getElementById("issueDtlDivId").style.display = "none";
	document.getElementById("minus2").style.display = "none";
	document.getElementById("plus2").style.display = "block";

}

function getRequestDtl() {

	document.getElementById("requestDivId").style.display = "block";
	document.getElementById("itemDetailDivId").style.display = "block";
	// document.getElementById("itemDtlOffDivId").style.display="none";
	// document.getElementById("reqDtlDivId").style.display="none";

}

function balQtyDtl(obj, i) {

	parentPopUp = obj;

	var strBalQtyDetail = document.getElementById("strBalQtyDtl" + i).value;

	myArray = strBalQtyDetail.split("^");

	var objVal1 = document.getElementById("1");

	if (myArray[0] != 'null' || myArray[0] != '') {
		objVal1.innerHTML = myArray[0];
	} else {
		objVal1.innerHTML = "  ----";
	}

	var objVal2 = document.getElementById("2");

	if (myArray[1] != 'null') {
		objVal2.innerHTML = myArray[1];
	} else {
		objVal2.innerHTML = "  ----";
	}

	display_popup_menu(parentPopUp, 'balQtyDtlId', '300', '');

}

function hideBalQtyDetails(divId) {
	hide_popup_menu(divId);
}


function getItemStockDtl(i) {

	var storeId = document.forms[0].strId.value;
	var itemCat = document.forms[0].itemCategory.value;
	var strIssueQty = document.getElementsByName('strIssueQty')[i].value;

	var hidVal = document.getElementById('strHidValue' + i).value;
	var temp = hidVal.split('^');
	var balQtyBaseVal = temp[0];
	var genItemId = temp[1];
	var itemBrandId = temp[2];

	var strIssueQtyUnitId = document.getElementsByName('strIssueUnitId')[i].value;

	var strIssueUnitName = document.getElementsByName('strIssueUnitId')[i][document
			.getElementsByName('strIssueUnitId')[i].selectedIndex].text;

	var temp2 = strIssueQtyUnitId.split("^");
	var strIssueQtyUnitBaseVal = parseInt(temp2[1]);

	if (strIssueQty == "") {

		alert("Please Select Issue Qty");
		document.getElementsByName('strIssueQty')[i].focus();
		return false;

	}
	if (document.getElementsByName('strIssueUnitId')[i].value == '0') {

		alert("Please Select Unit Name");
		document.getElementsByName('strIssueUnitId')[i].focus();
		return false;

	}

	getStockDtls('1', '', genItemId, itemBrandId, strIssueQty,
			strIssueQtyUnitBaseVal, storeId, itemCat, '1', strIssueUnitName,
			'strHidDivId' + i);

}

function invokeCheckQty(mode, index, unitObject) {

	if (checkQty(index, 'strReqQty', 'strUnitName')) {

		calculateCost(mode, 'strReqQty', 'strUnitName', 'strCostFinal', index,
				'strApproxAmt', '1')

	}

}

function goFuncOnEnterTwo(e) 
{
	  
	
	if (e.keyCode == 13) 
	{
		validateIssue();
	} 
	else 
	{
		return false;
	}
}

var gblhisValidator = null


function chkVisitDtl() {
	
	if(document.getElementsByName("strPatientStatus")[0].value == '2')
	{
		document.forms[0].strDeptCode.value = document.getElementsByName("strAdmissionDtlHidVal")[0].value.split("^")[5];
	}
	else
		document.forms[0].strDeptCode.value = document.getElementsByName("strEpisodeCode")[0].value.substr(0,3);
	getUnitCombo();
	
	
	if (document.forms[0].strVisitDtl.value == '0') {
		alert("Patient has not visited on this Prescription Date, \n So medicine cannot issued");
		return false;

	} else {
		
		

//		getReport();

	}
}

// function to show report after save data

function hideIssuePopup() {
	document.getElementById("issueDtlsDivId").innerHTML = "";
	hide_popup('popUpDiv');

}
function goToCancelPage()
{
	
	var mode = "GETCANCELPAGE";
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();
}
function getReport() 
{    
	document.getElementById("strCrNo").focus();
	
    var issueNo      = document.forms[0].strIssueNum.value;
	var strId        = document.forms[0].strId.value;
	//alert("Issue No:::"+issueNo+"::Store ID::"+strId);
 	if (issueNo != "") 
	{	  
		if (issueNo != "0") 
		{		   
		    var strMode = "1";
			var hmode = "ISSUEDTLSINIT";
		    var url = "IssueTransCNT.cnt?hmode=" +hmode+ "&strMode=" +strMode+ "&strStoreId=" +strId+ "&strIssueNo=" + issueNo;
		    ajaxFunction(url, "8");
		}
	}
	document.forms[0].strIssueNum.value = "0";	
	document.forms[0].strCrNo.focus();
}

function onQuantity(i) {

	var totQty;
	var frequency = document.getElementById('strFrequency' + i).value;
	var itemparam = document.getElementById('itemParamValue' + i).value;
	var temp = itemparam.split('#');
	var temp1 = temp[1].split('^');
	var dosage = document.getElementById('strDose' + i).value;
	var frequencyVal = frequency.split('^')[1];
	var dosageVal = dosage.split('^')[1];
	var days = document.getElementById('strDays' + i).value;
	if (dosage.split('^')[2] == 1) {
		document.getElementById('strQuantity' + i).innerHTML = "0 No.";
		document.getElementById('strQuantityText' + i).style.display = "none";
		document.getElementById('strQuantity' + i).style.display = "block";
		totQty = frequencyVal * dosageVal * days;

		if (isNaN(totQty)) {
			totQty = 0;
		}
		/*
		 * if(parseInt(totQty)>parseInt(temp1[1])){ alert("Quantity is Greater
		 * than Available Quantity"); return false; }
		 */
		document.getElementById('strReqQty' + i).value = totQty;
		document.getElementById('strQuantity' + i).innerHTML = totQty + " No.";
		document.getElementById('strQtyText' + i).value = document
				.getElementById('strReqQty' + i).value;
	} else {
		document.getElementById('strQtyText' + i).value = "";
		document.getElementById('strQuantity' + i).innerHTML = "0 No.";
		document.getElementById('strQuantityText' + i).style.display = "block";
		document.getElementById('strQuantity' + i).style.display = "none";
		totQty = dosageVal;
		document.getElementById('strReqQty' + i).value = document.getElementById('strQtyText' + i).value;
	}

}

function goToWithoutCrNoPage()
{    
    document.forms[0].strIssueNum.value = "";
	document.forms[0].crNo.value = "";	
	var mode = "INITVALWITHOUTCRNO";
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();
}


function IsCrOrLFWise(val)
{
	if(val == '1')
		{
		document.getElementById("CrNOOrLf").innerHTML="<font color=\"red\">*</font>CR No.";
		document.getElementById("CRWise").style.display ='block'; 
		document.getElementById("LFWise").style.display ='none';
		
			
		}
	if(val == '2')
	{
			document.getElementById("CrNOOrLf").innerHTML="<font color=\"red\">*</font>LF No.";
	//alert(document.getElementById("CRWise").innerHTML);
	document.getElementById("CRWise").style.display ='none'; 
	document.getElementById("LFWise").style.display ='block';
	
		}

}
function getPrintReport()
{
	//alert("Req type:::"+document.getElementsByName("strRequestTypeId")[0].value);
         if(printflag == true)
    	  getReport();
	    
    	
	
}
// function to show report after save data
function getReport()
{
	 var transferNo    = document.forms[0].strIssueNum.value;
	                        
	 var storeId       = document.forms[0].strId.value;
	 
	 //alert("transferNo"+transferNo);
	 alert("storeId"+storeId);
	 if(parseInt(transferNo)!=0 && document.forms[0].printReq.value == 1)
	 { 
	   var mode="ISSUEDTLSINITONE";
	   var url="DossierRequisitionCNT.cnt?hmode="+mode+"&strIssueNo="+ transferNo+"&strStoreId="+storeId+"&strMode=1";
	   ajaxFunction(url,"9");
	 }
}


function getReport2()
{
	 var transferNo    = document.forms[0].strIssueNum.value;
	 var storeId       = document.forms[0].strId.value;
	 //alert(transferNo);
	 if(parseInt(transferNo)!=0)
	 { 
	   var mode="ISSUEDTLPOPUP";
	   var url="IssueTransCNT.cnt?hmode="+mode+"&issueNo="+ transferNo+"&storeId="+storeId;
	   ajaxFunction(url,"8");
	 }
    	
	
}
/*function getAjaxResponse(res,mode)
{
      var err = document.getElementById("errMsg");
      var temp = res.split("####");
      if(temp[0] == "ERROR")
	  {
          	err.innerHTML = temp[1];
          	return;
      } 
     
     if(mode=="1")
     {
     	
     	 var objVal2 = document.getElementById("issueDtlsDivId");
     	 objVal2.innerHTML = res;
     	 popup('popUpDiv1', '130', '200');
     	 document.forms[0].strIssueNum.value ="0";
     	
     }
}*/


function setNewRate(e ,index)
{
	//alert(e.value);
	//alert(e.id);
	//var objVal2 = document.getElementById("strHiddenRate1-"+index).value;
	var objVal2 ='0.00';
	
	if(e.value == '1')
		{
		 objVal2 = '0.00';
		}else{
		 objVal2 = document.getElementById("strHiddenRate1-"+index).value;	
		}
	//alert(objVal2);
	document.getElementById("strDefaultRateDiv1-"+index).innerHTML= objVal2;
	var qty=document.getElementById("strQtyText1-"+index).value;
	document.getElementById("strCost1-"+index).innerHTML= parseFloat(objVal2) * parseFloat(qty);
	//document.getElementById("strCost1-"+index).innerHTML= document.getElementById("strtotalHidden").value;
	document.getElementById("strTotalHiddenDiv1-"+index).value=parseFloat(objVal2) * parseFloat(qty);
	
	var len=document.getElementsByName("strTotalHiddenDiv1").length;
	//alert(len);
	var temp=0.00;
	for(var i= 1 ; i <= len ;i++)
		{
		temp=temp+parseFloat(document.getElementById("strTotalHiddenDiv1-"+i).value);
		}
	//alert(temp);
	document.getElementById("strtotalDiv").innerHTML="Rs. "+temp.toFixed(2);
	document.getElementById("strtotalDiv").value=temp.toFixed(2);
	setTotalAmt(document.getElementById("strtotalDiv").value , document.getElementById("strNetCost1").value);
	//temp=0.00;
	 //objVal2.innerHTML = res; strQtyText1-  strCost1-1
	
}

function setTotalAmt(dossierCost , addtionalCost)
{
	/*alert('1');
	alert(dossierCost);
	alert(addtionalCost);
	alert(dossierCost+addtionalCost);*/
	document.getElementById("strTotalAmtDiv").innerHTML= (parseFloat(dossierCost) + parseFloat(addtionalCost)).toFixed(2);
}


