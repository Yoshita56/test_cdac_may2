// For Quality Check Control Transaction:

/**
 * Developer : Amit Kumar
 * Version : 1.0 
 * Date : 04/June/2009
 * 
 */
 
 
function drugDtl(obj,index) 
{
	parentPopUp = obj;

	var strBalQtyDetail = document.getElementById("strCheckHidValue"+index).value;

	myArray = strBalQtyDetail.split("^");

/*
					 1- Item Id
					 2- Lab Sent Date
					 3- Sent Store Name
					 4- Generic Name
					 5-Brand Name
					 6- Batch
					 7-Exp Date
					 8-Transfer Qty
					 9-Store Id Sent
					 10-Item Id
					 11-Item Brand ID
					 12-Rate With Unit
					 13-Rate Base value
					 14-Consumed Qty
					 15=Consumed Qty Wit Unit
					 16-Qty Base Value
					 17-Item Sl No
					 18-Item Sl No
					 19-Catg Code
					 20- Lab Send No
					 21-Lab Name
					 22-CTR Number
					 23-Net Cost
					 24-PO No
					 25-PO Date
					 26-Mfd Date
					 27-Is Send Decode Value
	                   28-Lab No
	                   29-Manufacter By
	                   30.QC Status
	                   31. Report Date
                   */


	var objVal1 = document.getElementById("1");
	
	if (myArray[23] != 'null' || myArray[23] != '') 
	{
		objVal1.innerHTML = myArray[23];
	} 
	else 
	{
		objVal1.innerHTML = "  ----";
	}

	var objVal2 = document.getElementById("2");

	if (myArray[24] != 'null' || myArray[24] != '') 
	{
		objVal2.innerHTML = myArray[24];
	} 
	else 
	{
		objVal2.innerHTML = "  ----";
	}


    var objVal3 = document.getElementById("3");

	if (myArray[6] != 'null' || myArray[6] != '') 
	{
		objVal3.innerHTML = myArray[6];
	} 
	else 
	{
		objVal3.innerHTML = "  ----";
	}
	
	var objVal4 = document.getElementById("4");

	if (myArray[25] != 'null' || myArray[25] != '') 
	{
		objVal4.innerHTML = myArray[25];
	} 
	else 
	{
		objVal4.innerHTML = "  ----";
	}
	
	display_popup_menu(parentPopUp, 'drugDtlId', '300', '');

}
function hideDrugDetails(mode)
{
	hide_popup('drugDtlId');
} 
function hidePopup(mode)
{
		
		if(mode=='1')
		{		 
          document.getElementById("sampleSenlLabelDivId").innerHTML = "";			
		  hide_popup('popUpDiv1');
		} 
}
 
 
 
 // Item Category associate with Store Name:
function itemCategoryCombo()
{
  if(document.forms[0].strStoreId.value!='0')
  {	
   var mode ="ITEMCATEGORY"; 
   var url="QualityCheckControlTransCNT.cnt?hmode=ITEMCATEGORY&storeid="+document.forms[0].strStoreId.value;
   ajaxFunction(url,"1");
  }
  else
  {
  	      objVal= document.getElementById("itemCategoryId");
		  objVal.innerHTML = "<select name ='strItemCategoryNo' class='comboNormal' onChange='groupNameCombo()'><option value='0'>Select Value</option></select>";
  }
} 
// Group Name Associate with Store Name and Item Category:
function groupNameCombo()
{
  if(document.forms[0].strItemCategoryNo.value!='0')
  {
   var mode ="GROUPNAME"; 
   var url="QualityCheckControlTransCNT.cnt?hmode=GROUPNAME&itemCatNo="+document.forms[0].strItemCategoryNo.value;
   ajaxFunction(url,"2");
  }
  else
  {
  	      objVal= document.getElementById("groupId");
		  objVal.innerHTML = "<select name ='strGroupId' class='comboMax' onChange='subGroupNameCombo()'><option value='0'>Select Value</option></select>";
		  
		  document.getElementById('strCommitteeTypeDivId').innerHTML = "<select name='strCommitteeTypeId' id='strCommitteeTypeId' class='comboNormal' onchange='getMemberDtl(\"COMMITEEMEMBERDTL\");'><option value='0'>Select Value</option></select>"
  }
} 

function subGroupNameCombo()
{
   var mode ="SUBGROUPNAME";  
   var url="QualityCheckControlTransCNT.cnt?hmode=SUBGROUPNAME&groupId="+document.forms[0].strGroupId.value;
   ajaxFunction(url,"3");
} 

function genItemNameCombo()
{
   var mode ="GENITEMNAME";  
   var url="QualityCheckControlTransCNT.cnt?hmode=GENITEMNAME&itemCatNo="+document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].value+
   				"&groupId="+document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value+
   				"&subgrpid="+document.forms[0].strSubGroupId[document.forms[0].strSubGroupId.selectedIndex].value;
   ajaxFunction(url,"4");
} 

function itemNameCombo()
{
   var mode ="ITEMNAME";  
   var url="QualityCheckControlTransCNT.cnt?hmode=ITEMNAME&storeid="+document.forms[0].strStoreId.value+
   				"&itemCatNo="+document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].value+
   				"&groupId="+document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value+
   				"&subgrpid="+document.forms[0].strSubGroupId[document.forms[0].strSubGroupId.selectedIndex].value+
   				"&genitemid="+document.forms[0].strGenericItemId[document.forms[0].strGenericItemId.selectedIndex].value;
   ajaxFunction(url,"5");
} 

function batchNoCombo()
{
   var mode ="BATCHNO";  
   document.forms[0].strIsConsumable.value = document.forms[0].strItemBrandId.value.split('^')[1];
   var url="QualityCheckControlTransCNT.cnt?hmode=BATCHNO&storeid="+document.forms[0].strStoreId.value+
   							"&itemCatNo="+document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].value
   									+"&genitemId="+document.forms[0].strGenericItemId[document.forms[0].strGenericItemId.selectedIndex].value
   									+"&itemId="+document.forms[0].strItemBrandId.value;
				
   ajaxFunction(url,"6");
  
} 

function batchNoComboTwo()
{
 
   var hmode ="BATCHNOTWO";  
   var url = "QualityCheckControlTransCNT.cnt?hmode="+hmode+"&strDrugBrandId="+document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value+"&storeId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+"&resenFlg="+document.forms[0].strResendFlag.value;
	//alert(url);					
   ajaxFunction(url,"6");
 
  
} 


function getMemberDtl(mode)
{
 if(document.forms[0].strCommitteeTypeId.value!='0')
 {
	var mode=mode;
	var url="QualityCheckControlTransCNT.cnt?hmode="+mode+"&committeType="+document.forms[0].strCommitteeTypeId.value+"&itemCategNo="+document.forms[0].strItemCategoryNo.value;
	ajaxFunction(url,"7");
 }	
}

function itemCategory(){
   var mode ="VIEWITEM"; 
   var url="QualityCheckControlTransCNT.cnt?hmode=VIEWITEM&storeid="+document.forms[0].strStoreId.value;
   ajaxFunction(url,"8");
}
function unitNameCombo(itemId)
{
	
   var mode ="UNITNAME";  
   var url="QualityCheckControlTransCNT.cnt?hmode="+mode+"&itemId="+itemId;
   ajaxFunction(url,"9");
  
  
} 
function getQcDrugList() 
{
			var hmode = "GETQCDRUGLIST"; 
			var url = "QualityCheckControlTransCNT.cnt?hmode="+hmode+"&storeId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+"&resenFlg="+document.forms[0].strResendFlag.value;
			ajaxFunction(url,"10");
	
}

function resetScreen(mode)
{
	              
		        
			     //document.getElementById("qualityDetailsDivId").style.display = "none";
			     if(mode =='1')
			     {
			        document.forms[0].strSubGroupId.value='0'; 
		            document.forms[0].strGenericItemId.value='0';
		            document.forms[0].strGroupId.value='0';
      			    document.getElementById('strBatchDivId').style.display = "none";
			        document.getElementById('strBatchItemDivId').style.display = "none";
			        document.getElementById("qualityDivId").style.display = "none";	
			        getQcDrugList();
			     }  
	
	            if(mode =='2')
			     {
			        //document.forms[0].strSubGroupId.value='0'; 
		            document.forms[0].strGenericItemId.value='0';
		            document.forms[0].strItemBrandId.value='0';
      			    document.getElementById('strBatchDivId').style.display = "none";
			        document.getElementById('strBatchItemDivId').style.display = "none";
			        document.getElementById("qualityDivId").style.display = "none";	
			        getQcDrugList();
			     }  
}


function getAjaxResponse(res,mode)
{
	
	var objVal;
	if(mode=="1")
	{	
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
        {
          objVal= document.getElementById("itemCategoryId");
		  objVal.innerHTML = "<select name ='strItemCategoryNo' class='comboNormal' onChange='groupNameCombo()'>" + res + "</select>";
		  groupNameCombo();
        }
        resetScreen(1);
    }
    
   	if(mode=="2")
	{	
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
        {
       	  var temp = res.split('^');
       	  objVal= document.getElementById("groupId");
		  objVal.innerHTML = "<select name ='strGroupId' class='comboMax' onChange='subGroupNameCombo()'>" + temp[0] + "</select>";
		  
		  document.getElementById('strCommitteeTypeDivId').innerHTML = "<select name='strCommitteeTypeId' id='strCommitteeTypeId' class='comboNormal' onchange='getMemberDtl(\"COMMITEEMEMBERDTL\");'>"+temp[1];+"</select>"
		  resetScreen(1);
        }
    }
    
    if(mode=="3")
	{	
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
        {
          objVal= document.getElementById("subGroupId");
		  objVal.innerHTML = "<select name ='strSubGroupId' class='comboMax' onChange='genItemNameCombo()'>" + res + "</select>";
        }
        resetScreen(2);
        genItemNameCombo();
       
        
    }
    
    if(mode=="4")
	{	
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
       {
          objVal= document.getElementById("genItemId");
		  objVal.innerHTML = "<select name ='strGenericItemId' class='comboMax' onChange='itemNameCombo()'>" + res + "</select>";
        }
        
        //itemNameCombo();
       
    }
 
    if(mode=="5")
	{	
       var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
        {
          objVal= document.getElementById("itemId");
		  objVal.innerHTML = "<select name ='strItemBrandId' class='comboMax' onChange='batchNoCombo();'>" + res + "</select>";  
        }
        
    }
    
    if(mode=="6")
	{	
	
	   var tempVal = document.forms[0].strGenericItemId.value.split('^');
	   
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   
	   
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }
       else
       {
        	
        	//document.forms[0].strIsConsumable.value = document.forms[0].strItemBrandId.value.split('^')[1];
        
		 	 if(document.forms[0].strItemCategoryNo.value=='10')
		 	 {
       /*
       		 if(tempVal[1] == '0')
       		 {
	          
	          	 document.getElementById('strBatchDivId').style.display = "none";
			     document.getElementById('strBatchItemDivId').style.display = "none";
	          
	          }
	          else
	          {   
	          */
	             
			          document.getElementById('strBatchDivId').style.display = "block";
			          document.getElementById('strBatchItemDivId').style.display = "none";
			          objVal= document.getElementById("batchNoId");
					  objVal.innerHTML = "<select name ='strBatchNo' class='comboNormal' onChange='stockPosition(this)'>" + res + "</select>";
					  document.getElementById("qualityDivId").style.display="none";
			   //}
			   
		  }
		  else
		  {
		  
		 // alert("res-"+res);
		  		var temp = res.split('@');
		  
		   if(tempVal[1] == '0'){
		   	
		   		 document.getElementById('strBatchDivId').style.display = "none";
		   		
		   }else{
		   			
		   		 document.getElementById('strBatchDivId').style.display = "block";
		  	 	objVal= document.getElementById("batchNoId");
		   	
		   			objVal.innerHTML = "<select name ='strBatchNo' class='comboNormal' onchange='stockPosition(this);'>" + temp[0] + "</select>";
		   			document.getElementById("qualityDivId").style.display="none";
		   		
		   	
		   }
		  
		 
		 if(tempVal[2] == '0'){
		   	
		   		 document.getElementById('strBatchItemDivId').style.display = "none";
		   		
		   }else{
		   			//alert(" temp[1]-"+ temp[1]);
		   		  document.getElementById('strBatchItemDivId').style.display = "block";
		  	 	 objVal= document.getElementById("itemSlNoId");
		    	objVal.innerHTML = "<select name ='strItemSlNo' class='comboNormal' onChange='stockPosition(this)'>" + temp[1] + "</select>";
		    	document.getElementById("qualityDivId").style.display="none";
		   }
		 
		  
		  }
		 	 
		 	 
		 	// if(document.forms[0].strIsConsumable.value =='1'){
		document.getElementById("qualityDetailsDivId").style.display="block";
		//}else{
		//document.getElementById("qualityDetailsDivId").style.display="none";
		//}
		 
	
        }
        
          // unitNameCombo(document.forms[0].strItemBrandId.value);	
        
    }
    if(mode=="7")
    {
   		var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
        {
			var objVal;
			document.getElementById("memberDtlInner").innerHTML=res;	
		}
	}
	if(mode=="8")
	{	
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
        {
          objVal= document.getElementById("ItemCatNameId");
		  objVal.innerHTML = "<select name ='strItemCategoryNo' class='comboNormal'>" + res + "</select>";
        }
    }
    if(mode=="9"){	
	
	
	
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
        {
		  document.getElementById('consumedQtyDivId').innerHTML = "<select name='strConsumedQtyUnitId' class='comboNormal' onchange='return quantityUnitValue();'>"+res+"</select>" ;
        }
    }
    if (mode == "10") 
	{

		objVal = document.getElementById("itemId");
		 objVal.innerHTML = "<select name ='strItemBrandId' class='comboMax' onChange='batchNoComboTwo();'>" + res + "</select>";  
			
	}
    
    
}
function setLabName()
{ 
		 document.forms[0].strLabName.value =  document.forms[0].strLabId[document.forms[0].strLabId.selectedIndex].text;
	
}

function stockPosition(obj)
{
	
	/*
			 1.Batch No
			 2. 0
			 3.Inhand Qty With Unit
			 4.PO NO
			 5.PO Date
			 6.Mfd Date
			 7. MfgSupplier Id
			 8.In Hand Qty
			 9.Inhand Qty Unit
			 10.Supplier Name
			 11.Manuf Date
			 12.Exp Date
			 13.Item Id
			 14.Item Brand Id 
			 15.Stock Status
			 16.Rate
			 17.Rate Unit Id
			 18.Supplier ID
			 19.Group ID
			 20.Sub Grp ID
			 21.Sale Price
			 22.Sale Price Unit
			 23.Receive Date
			 24.Currency Id
			 25.Current Value
			 26.Specification
			 27.Bill Date
			 28.Bill No
			 
			 * */
	
	if(obj.value == '0')
	{
	document.getElementById("qualityDivId").style.display="none";
	
	return false;
	}
	    document.forms[0].strBatchDtl.value=obj.value;
		var temp = obj.value.split('^');
	
			document.getElementById("avlQtyDivId").innerHTML = temp[2];
			document.getElementsByName('strInhandQty')[0].value = temp[2];
			
			if(temp[3]=="")
			{
				document.getElementById("poNoDivId").innerHTML = "--"
			}
			else{
				document.getElementById("poNoDivId").innerHTML = temp[3];
				}
		
			document.getElementsByName('strPONo')[0].value = temp[3];
			
			if(temp[4]=="")
			{
				document.getElementById("poDateDivId").innerHTML = "--"
			}else{
				document.getElementById("poDateDivId").innerHTML = temp[4];
			}
			document.getElementsByName('strPODate')[0].value = temp[4];
			
			if(temp[5]=="")
			{
				document.getElementById("suppliedByDivId").innerHTML = "--"
			}else{
				document.getElementById("suppliedByDivId").innerHTML = temp[5];
			}
			document.getElementsByName('strSupplierId')[0].value = temp[5];
			
			
			if(temp[9]=="")
			{
				document.getElementById("mfgNameDivId").innerHTML = "--"
			}else{
				document.getElementById("mfgNameDivId").innerHTML = temp[9];
			}
			
			
			if(temp[10]=="")
			{
				document.getElementById("mfgDateDivId").innerHTML = "--"
			}else{
				document.getElementById("mfgDateDivId").innerHTML = temp[10];
			}
			
			
			if(temp[11]=="")
			{
				document.getElementById("expDateDivId").innerHTML = "--"
			}else{
				document.getElementById("expDateDivId").innerHTML = temp[11];
			}
			
					
	//if(document.forms[0].strIsConsumable.value =='1'){
		document.getElementById("qualityDetailsDivId").style.display="block";
	//}else{
	//	document.getElementById("qualityDetailsDivId").style.display="none";
	//}
	document.getElementById("qualityDivId").style.display="block";
	
	 unitNameCombo(temp[12]);  // Pass Item Id
}




function itemStatus()
{
	/*
	if(document.forms[0].strItemStatus[1].checked);
	{
		document.getElementById("rejectDivId").style.display="block";
	}
	* */
}

function itemStatus2(){
	if(document.forms[0].strItemStatus[0].checked);
	{
		document.getElementById("rejectDivId").style.display="none";
	}
} 

function statusValues()
{
	document.forms[0].strItemStatus[0].checked = true;
	
	if(document.forms[0].strHidDistributionFlag.value == 1){
			document.forms[0].strDistributionFlag.checked = true;
		}
}

function openDivPopup()
{
		if(document.getElementsByName("strCommitteeTypeId")[0].value=="0")
   	 	{
   	 		alert("Please Select Approved By")
   	 	}
 	 	else{
  			 popup('memberDtl' , '130','250');
  		}
}
function closePopUpDiv()
{
	hide_popup('memberDtl');
}
function clearData()
{
	var size=document.getElementsByName("strMemberRecommendation").length;
	if(size>1){
		for(var i=0;i<size;i++){
			document.getElementsByName("strMemberRecommendation")[i].value="";
		}
	}
	else{
		document.getElementsByName("strMemberRecommendation")[0].value="";
	}
	
}

function goFuncView()               
{
  	
	 	if(document.getElementsByName("strStoreId")[0].value=="0")
	   {
			alert("Please Select Store From Combo");
			return false;
		}
		if(document.getElementsByName("strItemCategoryNo")[0].value=="0")
		{
			alert("Please Select Item Category From Combo");
			return false;
		}
		
		if(document.getElementsByName("strFromDate")[0].value=="")
		{
			alert("From Date is a mandatory field");
			return false;
		}
		
		if(document.getElementsByName("strToDate")[0].value=="")
		{
			alert("To Date is a mandatory field");
			return false;
		}
	
	
	var diffdate = dateDiff1(document.forms[0].strFromDate.value,document.forms[0].strToDate.value); 
	//alert(diffdate);
	 if(parseInt(diffdate)>365)
	 {
		alert("Difference Between From Date and To Date Should not be greater than 365 days");
		return false;
	 }
	
	else
	{
	 	        document.forms[0].strHidStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	    		document.forms[0].strItemCategoryName.value=document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].text;
			    document.forms[0].hideItemCatId.value=document.forms[0].strItemCategoryNo.value;
			    document.forms[0].displayFlag.value="1";
		         	
	        	document.forms[0].hmode.value="VIEWITEMGO";
				document.forms[0].submit();
	           	
		}
	
	
}

function ViewHideandBlock(){
    document.getElementsByName('strView')[0].checked = true;
	if(document.forms[0].displayFlag.value=="1")
   		{
   		   document.getElementById("StoreDivId").style.display= "none";
   		   document.getElementById("StoreNameDivId").style.display= "block";
		   document.getElementById("ItemCatNameId").style.display= "none";
	       document.getElementById("ItemCatNamedivId").style.display= "block";
	       document.getElementById("qualityDivId").style.display= "block";
	       document.getElementById("imageDivId").style.display= "none";
	       document.getElementsByName('strView')[0].disabled=true;

		}else {
		   document.getElementById("StoreDivId").style.display= "block";
   		   document.getElementById("StoreNameDivId").style.display= "none";
		   document.getElementById("ItemCatNameId").style.display= "block";
	       document.getElementById("ItemCatNamedivId").style.display= "none";
	       document.getElementById("qualityDivId").style.display= "none";
	       document.getElementById("imageDivId").style.display= "block";
	     		
		}
	}	


function changeViewMode1(chkObj) 
{ 	 	 	
 	if(chkObj.checked)
 	{
 	   document.forms[0].strResendFlag.value='1';
 	   getClear();
 	     	objVal= document.getElementById("itemId");
	objVal.innerHTML = "<select name ='strItemBrandId' class='comboNormal' ><option value='0'>Select Value</option></select>";
	
  	
  	objVal= document.getElementById("batchNoId");
	objVal.innerHTML = "<select name ='strBatchNo' class='comboNormal'><option value='0'>Select Value</option></select>";

       
 	}
 	
 	else
 	{
 	
 		 document.forms[0].strResendFlag.value='0';
 		 getClear();
 		 objVal= document.getElementById("itemId");
	objVal.innerHTML = "<select name ='strItemBrandId' class='comboNormal' ><option value='0'>Select Value</option></select>";
	
  	
  	objVal= document.getElementById("batchNoId");
	objVal.innerHTML = "<select name ='strBatchNo' class='comboNormal'><option value='0'>Select Value</option></select>";
 		 
	
 	}
 		
 	
}
function changeViewMode2(chkObj) 
{ 	 	 	
 	
 	
 		document.forms[0].strResendFlag.value='0';
 		document.forms[0].hmode.value="VIEW";
 		document.forms[0].displayFlag.value="0";
		document.forms[0].submit();
	
 	
 		
 	
}

function clearViewPage()
{	
	document.forms[0].reset();
}


function diplayView(){


	 if(document.getElementsByName('strView')[0].checked){
	 //alert("displayview---->"+document.getElementsByName('strView')[0].value);
    
   
     	document.forms[0].hmode.value="VIEW";
 	  	document.forms[0].displayFlag.value="0";
		document.forms[0].submit(); 
    
    	}else {
    	
    	document.forms[0].hmode.value="unspecified";
 	    document.forms[0].displayFlag.value="0";
		document.forms[0].submit(); 
    	
    	}
    	
	}  
function clearView()
{
	
	var url;
	var mode = "unspecified";
	document.forms[0].hmode.value=mode;
	document.forms[0].displayFlag.value="0";
	document.forms[0].submit();
 	

}
	
		
function GetIndex(index,endVal)
{
   // alert("index--.>"+index+"<-Total Recrd-->"+endVal);
          for(var i = 1; i <= endVal ; i++)
		  {
		  //  alert(i+"<---i-->"+document.getElementById("DivId"+i).style.display);
		    document.getElementById("DivId"+i).style.display="none";
		  }
		 // alert("before-->>"+document.getElementById("DivId"+index).style.display);
		  document.getElementById("DivId"+index).style.display="block";
		 // alert("before-->>"+index+"<div>"+document.getElementById("DivId"+index).style.display);
			 
}

function goFuncOnView(e)
{
   if(e.keyCode == 13)
   {
	 goFuncView();
	}
	else
	{
	 return false;
	}
} 

function validate2()
{
	var saveObj = document.getElementById("saveId");
	
	if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	{
		saveObj.style.display = "none"; 
		
		//alert("document.forms[0].strItemSlNo.value-"+document.forms[0].strItemSlNo.value);
		var hisValidator = new HISValidator("qualityCheckControlBean");
		  hisValidator.addValidation("strStoreId","dontselect=0","Please select Drug Warehouse Name");
		  hisValidator.addValidation("strItemCategoryNo","dontselect=0","Please select Item Category");
		  
		  hisValidator.addValidation("strItemBrandId","dontselect=0","Please select Item Name");
		  
		  if(document.getElementById('strBatchDivId').style.display=="block")
		  {
		   hisValidator.addValidation("strBatchNo","dontselect=0","Please select Batch No.");
		  }
		  
		  if(document.getElementById('strBatchItemDivId').style.display=="block")
		  {
		  	hisValidator.addValidation("strItemSlNo","dontselect=0","Please select Item Serial No.");
		  }
		  //if(document.forms[0].strIsConsumable.value=="1")
		  //{
		  	hisValidator.addValidation("strConsumedQty","req","Consumed Quantity is Mandatory Field ");
		  	hisValidator.addValidation("strConsumedQty","amount=7,2","Quantity should be in 00000.00 format");
		  	hisValidator.addValidation("strConsumedQtyUnitId","dontselect=0","Please select Unit Id");
		 // }
		 
		 
		  hisValidator.addValidation("strLabSendDate", "req","Sent Date is a Mandatory Field");
		  
		  hisValidator.addValidation("strFinalResult", "req", "Result is Mandatory Field" );
		  hisValidator.addValidation("strFinalResult", "maxlen=250", "Result should be equals to 250 Characters" );
		  hisValidator.addValidation("strReportNumber", "req","Report Number is a Mandatory Field");
	      hisValidator.addValidation("strReportDate", "req","Report Date is a Mandatory Field");
	      
		  hisValidator.addValidation("strLabId","dontselect=0","Please select Lab Name");
		  hisValidator.addValidation("strCTRNumber", "req", "CTR Number is Mandatory Field" );
		  hisValidator.addValidation("strSampleCodeNumber", "req", "Secret Code No is Mandatory Field" );
		    
		  hisValidator.addValidation("strReceiveDate", "req","Received Date is a Mandatory Field");   
		  		
		  hisValidator.addValidation("strReportNumber", "req","Report Number is a Mandatory Field");
	      
	      hisValidator.addValidation("strReportDate", "dtltet="+document.forms[0].strCurrentDate.value,"Report Date should be Less than or Equal to Current Date"); 
		  //hisValidator.addValidation("strReportDate", "dtltet="+document.forms[0].strReceiveDate.value,"Report Date should be Less than or Equal to Received Date"); 		
		    
		    if(document.forms[0].strReportDate.value!='' && document.forms[0].strReceiveDate.value!='' && document.forms[0].strLabSendDate.value!='')
		    {
		    	
				hisValidator.addValidation("strLabSendDate", "dtlt="+document.forms[0].strReportDate.value,"Sent Date should be Less than Report Date"); 		
	    	  	hisValidator.addValidation("strReceiveDate", "dtgtet="+document.forms[0].strReportDate.value,"Received Date should be Greater than or Equal to Report Date");	    	
		    }
		  	  
		  	  if(document.forms[0].strReceiveDate.value!='')
		  	  {
					hisValidator.addValidation("strReceiveDate", "dtltet="+document.forms[0].strCurrentDate.value,"Received Date should be Less than or Equal to Current Date");	  	  	
		  	  }
		 	 
	
		    
		  hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should be equals to 100 Characters" );
		 
		  retVal = hisValidator.validate();
		  hisValidator.clearAllValidations();
		  
		  if(retVal)
		  {
		  	
		  	
		  	                              var conf = confirm("You Are Going To Save Records");
						                  if(conf == true)
						                  {
						                       var conf1 = confirm("Are you sure !!!");
						                       if(conf1 == true)
						                       {
						                          document.forms[0].strStoreName.value =  document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
											         document.forms[0].strLabName.value   =  document.forms[0].strLabId[document.forms[0].strLabId.selectedIndex].text;
											  		
												
													document.forms[0].hmode.value = "INSERT";
													document.forms[0].submit();
						                       }
						                      else
						                       {
						                         saveObj.style.display = '';
						                         return false;
						                       }
						                   }
						                  else
						                   {	
						                   	 	saveObj.style.display = '';
						                        return false;
						                   }
		         
			}
			else
			{
			   saveObj.style.display = '';	
	           return false;
	        
	        }
	}
	else
	{
	    saveObj.style.display = '';
		return false;
	}         

}



function validate1(){
	//alert("document.forms[0].strItemSlNo.value-"+document.forms[0].strItemSlNo.value);
	var hisValidator = new HISValidator("qualityCheckControlBean");
	  hisValidator.addValidation("strStoreId","dontselect=0","Please select Drug Warehouse Name");
	  hisValidator.addValidation("strItemCategoryNo","dontselect=0","Please select Item Category");
	  hisValidator.addValidation("strGroupId","dontselect=0","Please select Group Name");
	  hisValidator.addValidation("strGenericItemId", "dontselect=0", "Please select Generic Item Name" );
	  hisValidator.addValidation("strItemBrandId","dontselect=0","Please select Item Name");
	  
	  if(document.getElementById('strBatchDivId').style.display=="block"){
	   hisValidator.addValidation("strBatchNo","dontselect=0","Please select Batch No.");
	  }
	  
	  if(document.getElementById('strBatchItemDivId').style.display=="block"){
	  	hisValidator.addValidation("strItemSlNo","dontselect=0","Please select Item Serial No.");
	  }
	  if(document.forms[0].strIsConsumable.value=="1"){
	  	hisValidator.addValidation("strConsumedQty","req","Consumed Quantity is Mandatory Field ");
	  	hisValidator.addValidation("strConsumedQty","amount=7,2","Quantity should be in 00000.00 format");
	  	hisValidator.addValidation("strConsumedQtyUnitId","dontselect=0","Please select Unit Id");
	  }
	  hisValidator.addValidation("strFinalResult", "req", "Result is Mandatory Field" );
	  hisValidator.addValidation("strFinalResult", "maxlen=250", "Result should be equals to 250 Characters" );
	  hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should be equals to 100 Characters" );
	  //if(document.forms[0].strItemStatus.value=="2"){
	  		hisValidator.addValidation("strCommitteeTypeId","dontselect=0","Please select Approved By");
	  //}
	  retVal = hisValidator.validate();
	  if(retVal){
	  
	  		var avlQty = document.forms[0].strInhandQty.value;
		var consumedQty = document.forms[0].strConsumedQty.value;
		var consumedUnit = document.forms[0].strConsumedQtyUnitId.value;
		
		var temp1 = avlQty.split(" ");
		
		var temp = consumedUnit.split('^');
		
		var consumedValue = parseFloat(consumedQty) * parseFloat(temp[1]);
		
		if(consumedValue>parseFloat(avlQty))
		{
			
			alert("Consumed Quantity must be less than Avl Quantity");
			document.forms[0].strConsumedQty.value = "";
			document.forms[0].strConsumedQtyUnitId.value = "0"
		
		}
		
			                          var conf = confirm("You Are Going To Save Records");
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
		}else{

           return false;
           }

}

function getClear()
{
    
    document.getElementById("strBatchDivId").style.display="none";
	document.getElementById("qualityDivId").style.display="none";
  	document.forms[0].strStoreId.value='0';
  	document.forms[0].strItemCategoryNo.value='0';
  	document.forms[0].strGroupId.value='0';
  	document.forms[0].strSubGroupId.value='0';
  	document.forms[0].strGenericItemId.value='0';
  	document.forms[0].strItemBrandId.value='0';
  	document.forms[0].strBatchNo.value='0';
  	document.getElementById("errMsg").innerHTML = "";

}

// To cancel the Page:
 function cancel()
 {
    document.getElementById("errMsg").innerHTML = "";
    document.forms[0].hmode.value = "CANCEL";
    document.forms[0].submit();
 }

function distributionCheck(){
	
	//alert(document.getElementsByName('strDistributionFlag')[0].checked);
	if(document.getElementsByName('strDistributionFlag')[0].checked)
	{
		document.forms[0].strDistributionFlag.value = "1";
	}else{
		//alert("Hello");
		document.forms[0].strDistributionFlag.value = "0";
	}

	//alert(document.forms[0].strDistributionFlag.value);
}

function quantityUnitValue()
{
	if(document.forms[0].strConsumedQtyUnitId.value != 0){
		var avlQty = document.forms[0].strInhandQty.value;
		var consumedQty = document.forms[0].strConsumedQty.value;
		var consumedUnit = document.forms[0].strConsumedQtyUnitId.value;
		
		var temp1 = avlQty.split(" ");
		
		var temp = consumedUnit.split('^');
		
		var consumedValue = parseFloat(consumedQty) * parseFloat(temp[1]);
		
		if(consumedValue>parseFloat(avlQty))
		{
			
			alert("Consumed Quantity must be less than Avl Quantity");
			document.forms[0].strConsumedQty.value = "";
			document.forms[0].strConsumedQtyUnitId.selectedIndex = 0;	
		
		}
		
	}
	

}

function checkUnitQty() 
{
		       var unit = document.forms[0].strConsumedQtyUnitId;
			   var issueQty      = (document.getElementById("strConsumedQty").value)*(unit.value.split("^")[1]);
		       var temp          = document.getElementById("strBatchDtl").value.split("^");
		       var avlQtyBaseVal = temp[7];
		    
		    
			    if (parseFloat(avlQtyBaseVal) < issueQty) 
			    {
				  alert("Consumed Quantity should not be Greater than Inhand Quantity");
				  document.getElementById("strConsumedQty").value = "0";
				  document.getElementsByName("strConsumedQtyUnitId").value = "0";
				 				 
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

