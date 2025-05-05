function getAjaxResponse(res,mode)
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
       var objVal = document.getElementById("itemCategoryDivId");
       objVal.innerHTML = " <select name ='strItemCategoryId' class='browser-default custom-select' onchange='getDrugCombo();' >" + res+ "</select>" ;
    }  
    
    if(mode=="2")
    {
     //  alert("--Res--"+res);	
       var objVal = document.getElementById("strDrugDivId");
       objVal.innerHTML = " <select name ='strDrugId' class='browser-default custom-select'   onchange='clearCurrentStockData();'>" + res.split("$")[0]+ "</select>" ;
       
       var objVal2 = document.getElementById("stockStatusComboDivId");
       objVal2.innerHTML = "<select name='strNewStockStatus' class='browser-default custom-select' onChange='checkStatus();'>"+ res.split("$")[1] +"</select>";
    }
    
    if(mode=="3")
    {
       var objVal = document.getElementById("strCurrentStockDtlDivId");
       objVal.innerHTML =  res;
       
       getStockStatusList();
    }
    
    if(mode=="4")
    {
    	document.getElementById("stockDtlsDivId").style.display='';
    	
       var objVal = document.getElementById("stockStatusComboDivId");
       objVal.innerHTML = "<select name='strNewStockStatus' class='browser-default custom-select' onChange='checkStatus()'>"+ res +"</select>";
       getApprovedByCombo();
    }
    
     if(mode=="5")
    {
    	document.getElementById("unitNameComboDivId").style.display='';
    	
       var objVal = document.getElementById("unitNameComboDivId");
       objVal.innerHTML = "<select name='strUnitId' class='browser-default custom-select' onchange='checkAvailableQty();' >"+ res +"</select>"
       
       
    }
    
     if(mode=="6")
    {
    	document.getElementById("approvedByComboDivId").style.display='';
    	
       var objVal = document.getElementById("approvedByComboDivId");
       objVal.innerHTML = "<select name='strApprovedBy' class='browser-default custom-select' onchange='checkValCombo();' >"+ res +"</select>"
             
    }
    
    if(mode=="7")
    {
    		document.getElementById("viewCurrentStockDtlDivId").style.display='';
	       var objVal = document.getElementById("viewCurrentStockDtlDivId");
    	   objVal.innerHTML =  res ;
    	   
    	 
    }
}

function getItemCategory() 
{
	if(document.forms[0].strStoreId.value!='0')
    {
		var url = "UpdateStockStatusTransCNT.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
		//alert(url);		
		ajaxFunction(url, "1");
    }
    else
    {
    	 var objVal = document.getElementById("itemCategoryDivId");
         objVal.innerHTML = " <select name ='strItemCategoryId' class='browser-default custom-select' onchange='getDrugCombo();' ><option value='0'>Select Value</option></select>" ;
    }
//		document.getElementById("itemCategoryDivId").innerHTML = "<select name ='strItemCategoryId' class='comboNormal' ><option value='0'>Select Value</option></select>";
}

function getDrugCombo()
{
	var mode = "GETDRUGNAMECOMBO";
	
        var url ="UpdateStockStatusTransCNT.cnt?hmode="+mode
        +"&storeId="+document.forms[0].strStoreId.value
        +"&groupCode="+document.forms[0].strGroupId.value
        +"&categoryCode="+document.forms[0].strItemCategoryId.value;
        
        //alert("document.forms[0].strItemCategoryId.value"+document.forms[0].strItemCategoryId.value);
 		ajaxFunction(url,"2");
}


function getCurrentStockDetails()
{
	   var hisValidator = new HISValidator("updateStockStatusTransFB");
         
          hisValidator.addValidation("strStoreId","dontselect=0","Please Select Drug Warehouse Name");
          hisValidator.addValidation("strItemCategoryId","dontselect=0","Please Select Drug Category");		
          
         // hisValidator.addValidation("strGroupId","dontselect=0","Please Select Group");		
          hisValidator.addValidation("strDrugId","dontselect=0","Please Select Drug Name");

          document.forms[0].strStoreId.disabled = true;
          document.forms[0].strGroupId.disabled = true;
          document.forms[0].strDrugId.disabled = true;
          document.forms[0].strItemCategoryId.disabled = true;
            
 		 var retVal = hisValidator.validate(); 

          if(retVal)
          {
 				   	var mode = "GETCURRSTOCKDTLS";
	
					 var url ="UpdateStockStatusTransCNT.cnt?hmode="+mode
				        +"&storeId="+document.forms[0].strStoreId.value
				        +"&groupCode="+document.forms[0].strGroupId.value
				        +"&categoryCode="+document.forms[0].strItemCategoryId.value
				        +"&itemBrandId="+document.forms[0].strDrugId.value;
				        
				        //alert("document.forms[0].strItemCategoryId.value"+document.forms[0].strItemCategoryId.value);
				        
				 		ajaxFunction(url,"3");
          }
          else
          {
             return false;
          }
	
	

}

function getStockStatusList()
{
	   	var mode = "GETSTOCKSTATUSLIST";
	
					 var url ="UpdateStockStatusTransCNT.cnt?hmode="+mode
				        +"&storeId="+document.forms[0].strStoreId.value
				        +"&groupCode="+document.forms[0].strGroupId.value
				        +"&categoryCode="+document.forms[0].strItemCategoryId.value
				        +"&itemBrandId="+document.forms[0].strDrugId.value;
				        
				        //alert("document.forms[0].strItemCategoryId.value"+document.forms[0].strItemCategoryId.value);
				        
				 		ajaxFunction(url,"4");
	
}

function getUnitCombo()
{
	 	var mode = "GETUNITCOMBO";
	
					 var url ="UpdateStockStatusTransCNT.cnt?hmode="+mode
				        +"&storeId="+document.forms[0].strStoreId.value
				        +"&groupCode="+document.forms[0].strGroupId.value
				        +"&categoryCode="+document.forms[0].strItemCategoryId.value
				        +"&itemBrandId="+document.forms[0].strDrugId.value;
				        
				        //alert("document.forms[0].strItemCategoryId.value"+document.forms[0].strItemCategoryId.value);
				        
				 		ajaxFunction(url,"5");
	
	
}

function getApprovedByCombo()
{
	var mode = "GETAPPROVEDBYCOMBO";
	
					 var url ="UpdateStockStatusTransCNT.cnt?hmode="+mode
				        +"&storeId="+document.forms[0].strStoreId.value
				        +"&groupCode="+document.forms[0].strGroupId.value
				        +"&categoryCode="+document.forms[0].strItemCategoryId.value
				        +"&itemBrandId="+document.forms[0].strDrugId.value;
				        
				        //alert("document.forms[0].strItemCategoryId.value"+document.forms[0].strItemCategoryId.value);
				        
				 		ajaxFunction(url,"6");
}

/**
	  This function is used to set condition during change of name of reciever.
**/
function checkValCombo(){
	var approvedByCombo=document.forms[0].strApprovedBy[document.forms[0].strApprovedBy.selectedIndex].text;
	if(document.forms[0].strApprovedBy[document.forms[0].strApprovedBy.selectedIndex].text=='Other' ){
		
		document.getElementById("labelId").className="LABEL col-sm-3";
		document.getElementById("labelNameId").innerHTML="";
		document.getElementById("nameOtherFld").style.display="block";
		if(document.forms[0].strApprovedByOther.readOnly)
			document.forms[0].strApprovedByOther.readOnly=false;
		document.forms[0].strApprovedByOther.value="";
		document.getElementById("labelNameId").innerHTML="<font color='red'>*</font>Name of Person Who Approved";
		document.forms[0].strApprovedByOther.focus();
	
	}else if(document.forms[0].strApprovedBy.value!="0" && document.forms[0].strApprovedBy.value!="1"){
		
		document.getElementById("labelId").className="LABEL col-sm-3";
		
		document.getElementById("labelNameId").innerHTML="";
		document.getElementById("nameOtherFld").style.display="block";
		document.getElementById("labelNameId").innerHTML="Name of Person Who Approved";
		document.forms[0].strApprovedByOther.value=approvedByCombo;
		if(!document.forms[0].strApprovedByOther.readOnly)
			document.forms[0].strApprovedByOther.readOnly=true;
		
	}else{
		document.getElementById("labelId").className="CONTROL";
		document.getElementById("nameOtherFld").style.display="none";
		document.getElementById("labelNameId").innerHTML="";
	}
}



function getBudgetDetails()		// On Click Of GO Button of main page
{
	
	if(document.getElementsByName("strDrugWareHouseName")[0].value=="0")
	{
		alert("Select Drug Warehouse");
		document.getElementsByName("strDrugWareHouseName")[0].focus();
		return false;
	}
	else
	{
		var strStoreId = document.getElementsByName("strDrugWareHouseName")[0].value;
		document.forms[0].strStoreId.value	= strStoreId;
		document.forms[0].hmode.value = "PREVBUDGETDETAILS";
		 
		document.forms[0].submit();
       	
	}
}


function showBudgetDetails()
{
	
		if(document.forms[0].hmode.value == "PREVBUDGETDETAILS")
		{
		document.getElementById("budgetDetailsId1").style.display="";
		document.getElementById("budgetDetailsId2").style.display="";
		document.getElementById("budgetDetailsId3").style.display="";	
		}
}

// Function for Numeric(11,2)
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
		if ((fld.value.charAt(i) != '0') && (fld.value.charAt(i) != decSep)) break;
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
function chkBoxFunc(obj)
{
    if(obj.checked)	
    {
    	 document.forms[0].strChkValue.value = "1";
    	 document.getElementById("showQtyDiv").style.display="none";

    }
    else
    {
    	document.forms[0].strChkValue.value = "0";
    	document.getElementById("showQtyDiv").style.display="block";

    }
}

function cancelPage()
{
	document.forms[0].hmode.value = "CANCELPAGE";
	document.forms[0].submit();
}


function clearMsg(strTmp)
{
	document.forms[0].strStoreId.disabled = false;
          document.forms[0].strGroupId.disabled = false;
          document.forms[0].strDrugId.disabled = false;
          document.forms[0].strItemCategoryId.disabled = false;
	document.getElementsByName("strStoreId")[0].value="0"
	document.forms[0].hmode.value = strTmp;
	document.forms[0].submit();
}


//To open View Page
function openViewPage()
{
	document.forms[0].hmode.value = "GETVIEWPAGE";
	document.forms[0].submit();
	
	/*viewData(document.forms[0]);
	document.getElementsByName("strViewMode")[0].checked=false;*/
}

/*function viewData(form1) //View Page
{

	var chkObj = document.getElementsByName("strViewMode")[0];
	
	

	if (chkObj.checked != true) 
	{
		
		return false;
	}
	
	else
		{
			//url = 'UpdateStockStatusTransCNT.cnt?hmode=GETVIEWPAGE';
			//window.open(url,"self.location", "popupWindow",	"width=610,height=450,top=250,left=350,scrollbars=yes");
			
			document.forms[0].hmode.value = "GETVIEWPAGE";
			document.forms[0].submit();
		}
	
}*/



function getUpdatedStockStatusViewDetails()		//View Page
{
	
	var hisValidator = new HISValidator("updateStockStatusTransFB");

	hisValidator.addValidation("strStoreId", "dontselect=0","Please Select a Drug Warehouse Name");
	hisValidator.addValidation("strItemCategoryId", "dontselect=0","Please Select a Drug Category");
	hisValidator.addValidation("strFromDate", "req","From Date is a Mandatory Field");
	hisValidator.addValidation("strToDate", "req","To Date is a Mandatory Field");
 	
 	var retVal = hisValidator.validate();
	
	
	var diffdate = dateDiff1(document.forms[0].strFromDate.value,document.forms[0].strToDate.value); 
  
     if(parseInt(diffdate)>365)
     {
        alert("Difference Between From Date and To Date Should not be greater than 365 days");
		return false;
	 }
	
	if (retVal) 
	{
  	
  	        var hmode = "GETUPDATEEDSTOCKVIEWDTLS"; 
			var   url = "UpdateStockStatusTransCNT.cnt?hmode="+hmode
						+"&storeId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+
						"&strCategoryId="+document.forms[0].strItemCategoryId[document.forms[0].strItemCategoryId.selectedIndex].value
						+"&startDate="+document.forms[0].strFromDate.value
						+"&endDate="+document.forms[0].strToDate.value;		
				
 		ajaxFunction(url,"7");
  	
  	} else {
		return false;
	}  	
}




//			   ITEM_NAME	1
//			   BATCH_NO		2
//			   EXPIRY_DATE  3
//			   STOCK_STATUS	4
//			   HSTNUM_INHAND_QTY With Unit	5 
//			   SUPPLIED_BY	6
//		       HSTNUM_STOCK_STATUS_CODE 7			
//			   HSTNUM_GROUP_ID	8
//			   HSTNUM_SUBGROUP_ID	9
//			   HSTDT_EXPIRY_DATE	10
//	           HSTDT_MANUF_DATE	11
//	           HSTNUM_SUPPLIER_ID	12
//	           HSTNUM_RATE	13 
//	           HSTNUM_RATE_UNITID 14
//	           HSTNUM_SALEPRICE	15
//	           HSTNUM_SALEPRICE_UNITID	16
//	           HSTNUM_PO_NO	17
//	           HSTDT_PO_DATE	18
//			   HSTNUM_SUPPLIED_BY	19
//			   HSTDT_RECIEVED_DATE	20
//			   HSTNUM_CURRENCY_ID	21
//			   HSTNUM_FREEITEM_FLAG	22 
//      	   HSTNUM_CURRENT_VALUE	23	
//       	   HSTNUM_INVOICE_NO	24
//       	   HSTNUM_INVOICE_DATE	25
//       	   HSTSTR_SPECIFICATION	26
//			   HSTNUM_INHAND_QTY_UNITID 27
//			   HSTNUM_ITEM_ID		28
//             HSTNUM_BLOCKED_QTY with Unit   29
//             Expiry With Format   30
//             HSTNUM_BLOCKED_QTY   31
//             HSTNUM_INHAND_QTY 	32
//             HSTNUM_STOCK_STATUS_CODE 33	
function setHiddenValues(obj,index)
{
	 document.forms[0].strChkValue.value = "1";
	 document.getElementById("showQtyDiv").style.display="none";
	 document.forms[0].strWhetherUpdateNewStatusInAllDWH.checked=true;
	
	document.forms[0].strIndex.value = index;
  	if(obj.value.split("^")[30]>0)
	{
		alert("Stock Status Can't be Updated b'coz Quantity has been blocked by other process");
		obj.checked = false;
		document.getElementById("strQtyId").value = "";
		document.forms[0].strHiddenValues.value = "0";
		return false;
	}
	else
	{
		document.getElementById("strQtyId").value = obj.value.split("^")[31];
		document.forms[0].strHiddenValues.value = obj.value;
	}
}	

function checkStatus()
{
  var  objValue = document.forms[0].strHiddenValues;		
 if(objValue.value!='0')	
 {
	  var NewStkSts = document.forms[0].strNewStockStatus[document.forms[0].strNewStockStatus.selectedIndex].value; 
	  if(NewStkSts == objValue.value.split("^")[32]) 	
	  {
	  	alert("New Stock Status can't be equal to the Existing Stock Status!!!");
	  	document.forms[0].strNewStockStatus.value = '0';
	  	return false;
	  }
 }
 else
 {
 	  alert("Please Select Record to Update Status!!");
 	  //document.getElementsByName("strNewStockStatus")[0].value="0";
 	 
 	  return false;
 }
}

// For saving the data on Add Page
function validate1(mode)
{   

     
         var hisValidator = new HISValidator("updateStockStatusTransFB");
         
          hisValidator.addValidation("strStoreId","dontselect=0","Please Select Drug Warehouse Name");
          hisValidator.addValidation("strItemCategoryId","dontselect=0","Please Select Drug Warehouse Name");		
          //hisValidator.addValidation("strGroupId","dontselect=0","Please Select Drug Warehouse Name");
          hisValidator.addValidation("strDrugId","dontselect=0","Please Select Drug Warehouse Name");          
          hisValidator.addValidation("strQty","req", "Quantity is a Mandatory Field" );
          hisValidator.addValidation("strNewStockStatus","dontselect=0","Please Select New Stock Status");  
          hisValidator.addValidation("strApprovedBy","dontselect=0","Please Select Approved by");
                  
          hisValidator.addValidation("strRemarks","req", "Remarks is a Mandatory Field" );          
          hisValidator.addValidation("strRemarks", "maxlen=250", "Reason To Update Status should have less than or equal to 250 Characters" );
           
 		  var retVal = hisValidator.validate(); 

          if(retVal)
          {
          	         var  objValue = document.forms[0].strHiddenValues;		
					 if(objValue.value!='0')	
					 {
          	          if(document.forms[0].strChkValue.value!='0')
          	          { 
          	             if(confirm("You Are Going To Update New Status ["+document.forms[0].strNewStockStatus[document.forms[0].strNewStockStatus.selectedIndex].text +"] In All DWH for Drug  " + objValue.value.split("^")[0] + "  with  Batch  "+objValue.value.split("^")[1]))
						 {
							if(confirm(" Are You Sure You Want to Save ?"))
							{
							
								document.forms[0].strStoreId.disabled = false;
					            document.forms[0].strGroupId.disabled = false;
					            document.forms[0].strDrugId.disabled = false;
					            document.forms[0].strItemCategoryId.disabled = false;
		 					    document.forms[0].hmode.value = "SAVE";                 	   
		                        document.forms[0].submit();	
							}	
							
						}
						else
						{
								return false;
						}					   
          	          }
          	          else
          	          {
	          	          	if(confirm("You Are Going To Update New Status ["+document.forms[0].strNewStockStatus[document.forms[0].strNewStockStatus.selectedIndex].text +"] \n  In  DWH  "+ document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text +"  for Drug  " + objValue.value.split("^")[0] + "  with  Batch  "+objValue.value.split("^")[1]))
							 {
								if(confirm(" Are You Sure You Want to Save ?"))
								{
								
									document.forms[0].strStoreId.disabled = false;
						            document.forms[0].strGroupId.disabled = false;
						            document.forms[0].strDrugId.disabled = false;
						            document.forms[0].strItemCategoryId.disabled = false;
			 					    document.forms[0].hmode.value = "SAVE";                 	   
			                        document.forms[0].submit();	
								}	
								
							}
							else
							{
									return false;
							}		
	          	          	
	          	          }
          	           
          	           
					 }
					 else
					 {
					 	alert("Please Select One Record to Update!!!");
					 	return false;
					 }  
          }
          else
          {
             return false;
          }
}


function getDrugNameViewPopUp(obj,value) 
{
	parentPopUp = obj;
	myArray = value.split("^");


	var objVal1 = document.getElementById("1");
	
	if (myArray[0] != 'null' || myArray[0] != '') 
	{
		objVal1.innerHTML = myArray[0];
	} 
	else 
	{
		objVal1.innerHTML = "  ----";
	}

	var objVal2 = document.getElementById("2");

	if (myArray[1] != 'null' || myArray[1] != '') 
	{
		objVal2.innerHTML = myArray[1];
	} 
	else 
	{
		objVal2.innerHTML = "  ----";
	}


    var objVal3 = document.getElementById("3");

	if (myArray[2] != 'null' || myArray[2] != '') 
	{
		objVal3.innerHTML = myArray[2];
	} 
	else 
	{
		objVal3.innerHTML = "  ----";
	}
	
	
	display_popup_menu(parentPopUp, 'drugDtlId', '300', '');

}
//added this by 47 frm popup.js
function display_popup_menu(parent,divId,leftPos,topPos)
{

gblParent = parent;

	//get the named menu
	var menu_element = document.getElementById(divId);
	
	//alert(menu_element.style.display);
	
	if(menu_element.style.display == "block"){
		
	//	alert("inside block");
		
		hide_popup_menu(divId);
	}
		menu_element = document.getElementById(divId);
	
	
	//menu_element.offsetParent = parent;
	
	//override the 'display:none;' style attribute
	menu_element.style.display = "block";
	//get the placement of the element that invoked the menu...
	var placement = findPos(parent);
	//...and put the menu there
	
	if(leftPos == ""){
		menu_element.style.left = placement[0] + "px";
	}else{
		menu_element.style.left = leftPos + "px";
	}
	
	
	if(topPos == ""){
		menu_element.style.top = placement[1] + "px";
	}else{
		menu_element.style.top = topPos + "px";
	}
	hidden = false;
	hidePageCombo(menu_element);
	menu_element.focus();
}

//added this by 47 frm popup.js
function hide_popup_menu(divId)
{
	//get the named menu
	var menu_element = document.getElementById(divId);
	//hide it with a style attribute
	menu_element.style.display = "none";
	hidden = true;
	//hidePageCombo(menu_element);
	showPageCombo();
}

function hideDrugDetails(mode)
{
	
	hide_popup_menu('drugDtlId');
} 



function clearCurrentStockData()
{
		document.getElementById("strCurrentStockDtlDivId").innerHTML="";
		
			//getUnitCombo();
}

function clearData()
{
		document.getElementById("budgetDetailsId1").style.display="none";
		document.getElementById("budgetDetailsId2").style.display="none";
		document.getElementById("budgetDetailsId3").style.display="none";
}





function setDefaultValue(elementQty) 
{
	if(elementQty.value=="") 
	{
		elementQty.value="0";
	}
}


function checkAvailableQty()
{
	var currStockDtl = document.getElementsByName("strCurrStockDtl");
	
	var index;
	
	for(var i = 0; i< currStockDtl.length; i++)
	{
		if(currStockDtl[i].checked == true)
		{
			index = i;
			break;
		}
		 	
	}
	
	
			var    strUnitObj = document.getElementsByName("strUnitId")[0].value;
		
			 
			var                   temp = strUnitObj.split("^");
			var  strQtyUnitBaseVal = parseFloat(temp[1]);
			
//			alert("strUnitObj"+strUnitObj);
			
//			alert("temp"+temp);
//			alert("strQtyUnitBaseVal"+strQtyUnitBaseVal);
	
			
			if(document.getElementsByName("strQty")[0].value*strQtyUnitBaseVal  > currStockDtl[index].value.split("^")[4] )
			{
				alert("Quantity Should be less than equal to the Available Quantity");
				 document.getElementsByName("strQty")[0].value="0";
				 document.getElementsByName("strUnitId")[0].value="0";
				return false;
			}
	
		
}

function get_MonthInt(str)
{
	var month = "0";
	
	switch(str.toUpperCase())
	{
		case "JAN":
			month = "1";
			break;
		case "FEB":
			month = "2";
			break;
		case "MAR":
			month = "3";
			break;
		case "APR":
			month = "4";
			break;
		case "MAY":
			month = "5";
			break;
		case "JUN":
			month = "6";
			break;
		case "JUL":
			month = "7";
			break;
		case "AUG":
			month = "8";
			break;
		case "SEP":
			month = "9";
			break;
		case "OCT":
			month = "10";
			break;
		case "NOV":
			month = "11";
			break;
		case "DEC":
			month = "12";
			break;
	}
	return month;
}
function Days_InMonth(mon, year) 
{
	var retVal;
	
	retVal = 31;
	if (mon == 4 || mon == 6 || mon == 9 || mon == 11) {retVal = 30;}
	if (mon == 2) {retVal = days_InFebruary(year);}
   	return retVal;
}

//this is internal function that returns day in feb month for specified year
function days_InFebruary (year)
{
	return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
}
function get_Seperator(dtStr)
{
	var seprator = "";
	if (dtStr.indexOf("-") > -1)
		seprator = "-";
	else
	{
		if (dtStr.indexOf("/") > -1)
			seprator = "/";
		else
		{
			if (dtStr.indexOf(".") > -1)
				seprator = ".";
		}
	}	//endif
	return seprator;
}
function parse_Date(dtStr,seprator)
{
	var pos1,pos2,tempLen=0;
	var tempStr = "";
	var intDay = 0,intMon = 0,intYear = 0;
	var retValue = false;
	pos1 = dtStr.indexOf(seprator);
	pos2 = dtStr.indexOf(seprator,pos1+1);
	if(pos1 > 0 && pos2 > (pos1 + 1))
	{
		//day
		tempStr = dtStr.substring(0,pos1);
		tempLen = tempStr.length;
		if(tempLen > 0 && tempLen <=2)
		{
			intDay = parseInt(tempStr,'10');
			//month
			tempStr = dtStr.substring(pos1+1,pos2);
			tempLen = tempStr.length;
			if(tempLen > 0 && tempLen <= 3)
			{
				//format given as dd/mmm/yyyy
				if(tempLen == 3) tempStr = get_MonthInt(tempStr);	
				intMon = parseInt(tempStr,'10');
				if(intMon > 0) 
				{
					//year
					tempStr = dtStr.substring(pos2+1);
					tempLen = tempStr.length;
					if(tempLen == 4)
					{
						intYear = parseInt(tempStr,'10');
						if (intYear >= 1900 && intYear <= 9900)
						{
							if (intMon >= 1 && intMon <= 12)
							{
								if (intDay > 0 && intDay <= Days_InMonth(intMon, intYear))
									retValue = true;
							}
						}
					}
				}
			}
		}
	}
	
	return {cancelKey :retValue,day:intDay,month:intMon,year:intYear};
}
function compare_Date(frDate,toDate)
{
	var seprator1 = "", seprator2 = "";
	var retValue = false;
	var dtMode = 0;
	var retValues1,retValues2;
	if (frDate != "" && frDate != null && toDate != "" && toDate != null)
	{
		seprator1 = get_Seperator(frDate);		//function that returns seperator
		seprator2 = get_Seperator(toDate);		//function that returns seperator
		if (seprator1 != "" && frDate.length >= 8)
		{
			retValues1 = parse_Date(frDate,seprator1);
			if (seprator2 != "" && toDate.length >= 8 && retValues1.cancelKey == true)
			{
				retValues2 = parse_Date(toDate,seprator2);
				if(retValues2.cancelKey == true)
				{
					if(retValues1.year == retValues2.year)
					{
						if(retValues1.month == retValues2.month)
						{
							if(retValues1.day == retValues2.day)
								dtMode = 1;
							else
							{
								if(retValues1.day > retValues2.day)
									dtMode = 2;
								else
									dtMode = 0;
							}
						}
						else
						{
							if(retValues1.month > retValues2.month)
								dtMode = 2;
							else
								dtMode = 0;	
						}
					}
					else
					{
						if(retValues1.year > retValues2.year)
							dtMode = 2;
						else
							dtMode = 0;		
					}
					
					retValue = true;
				}
			}
		}
	}
	
	return {cancelKey :retValue,mode:dtMode};
} //end compareDate() function
function dateDiff1(date_1,date_2) 
{
	if(date_1==date_2)
	{
	//alert("same day");
	//var o=document.getElementById("daysOnLeave");
	//o.innerHTML="<font color='blue' weight='strong'>same day</font>";
	//document.forms[0].strDaysOnLeave.value=1;
	return 0;
	}
	var retVal=compare_Date(date_1,date_2);
	//alert("retVal.mode->"+retVal.mode);
	if(retVal.mode!=0)
	{
		alert("From Date should be less than To Date");
		return;
	}		
	if(retVal.mode==0)
	{
		var ret=parse_Date(date_1,"-");
		var ret1=parse_Date(date_2,"-");
		var dt1=ret.month+"-"+ret.day+"-"+ret.year;
		var dt2=ret1.month+"-"+ret1.day+"-"+ret1.year;
		date1 = new Date();
		date2 = new Date();
		diff  = new Date();
		//alert("Valid From/in format DD-MM-YYYY->"+dt1);
		//alert("Valid To/in format DD-MM-YYYY->"+dt2);
		{ // Validates first date 
		var myDate1=new Array();
		myDate1=dt1.split("-");
		date1temp = new Date(myDate1[2],myDate1[0],myDate1[1]);
		date1.setTime(date1temp.getTime());
		}
		{ // Validates second date 
		var myDate2=new Array();
		myDate2=dt2.split("-");
		date2temp = new Date(myDate2[2],myDate2[0],myDate2[1]);
		//alert("date2temp.getTime()->"+date2temp.getTime());
		date2.setTime(date2temp.getTime());
		}
		// sets difference date to difference of first date and second date
		//alert("date1.getTime()->"+date1.getTime());
		diff.setTime(Math.abs(date1.getTime() - date2.getTime()));
		timediff = diff.getTime();
		//alert("timediff->"+timediff);
		weeks = Math.floor(timediff / (1000 * 60 * 60 * 24 * 7));
		timediff -= weeks * (1000 * 60 * 60 * 24 * 7);
		days = Math.floor(timediff / (1000 * 60 * 60 * 24)); 
		timediff -= days * (1000 * 60 * 60 * 24);
		days=parseInt(weeks)*7+days;
		//var diff = /*weeks + " weeks, " +*/ days + " days " ;
		diff=days;
		//alert("date diff->"+diff);
		//var o=document.getElementById("daysOnLeave");
		//o.innerHTML="<font color='blue' weight='strong'>"+diff+"</font>";
		//document.forms[0].strDaysOnLeave.value=diff;
		return diff;
	}
}	 
	 
	 
	 