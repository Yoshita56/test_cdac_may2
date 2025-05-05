// Java Script for Item Locator Transaction:

/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 18/June/2009
 * 
 */
 
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
          document.getElementById('pg'+page).className = 'pg-normal';
        }
	    var oldPageAnchor = document.getElementById('pg'+index);   // Apply CSS
        oldPageAnchor.className = 'pg-selected';
                  
          for(var i = 1; i <= endVal ; i++)
		  {
			  document.getElementById("DivId2"+i).style.display="none";
		  }
		  document.getElementById("DivId2"+index).style.display="block";
			 
} 
 
function groupCombo()
{	
   var mode ="GROUPNAME"; 
   var itemCatNo = document.forms[0].strItemCategoryNo.value;
   
   var url="ItemLocationTransCNT.cnt?hmode=GROUPNAME&itemCatNo="+itemCatNo;
   ajaxFunction(url,"1");
   
} 

function subGroupCombo()
{
   var mode ="SUBGROUPNAME";  
   var url="ItemLocationTransCNT.cnt?hmode=SUBGROUPNAME&groupId="+document.forms[0].strGroupId.value;
   ajaxFunction(url,"2");
   
//   genItemCombo();
   
} 

function genItemCombo()
{
	 objVal= document.getElementById("StockDtlDivId");
		      objVal.innerHTML =  "" ;
	var mode ="GENITEMNAME";  
   var url="ItemLocationTransCNT.cnt?hmode=GENITEMNAME&itemCatNo="+document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].value+
   				"&groupId="+document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value+
   				"&subgrpid=0";
   //alert("genItemCombo():::"+url);
   ajaxFunction(url,"3");
   
   
} 

function itemCombo()
{
	 
    var mode ="ITEMNAME";  
   
  	var url="ItemLocationTransCNT.cnt?hmode="+mode+
									"&itemCatNo="+document.forms[0].strItemCategoryNo.value+
									"&storeId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value;
  //alert("itemCombo():::"+url);
 
   ajaxFunction(url,"4");
} 

function batchItemNoCombo()
{
	objVal= document.getElementById("StockDtlDivId");
		      objVal.innerHTML =  "" ;
	var	tempVal='0^0^0'; // tempVal[1]=IsBatch Flag ,  tempVal[2]=IsSlNo Flag
	var genItemId = document.forms[0].strGenItemId.value;
	
		if(document.forms[0].strGenItemId.value=='0')
		{
			if(document.forms[0].strItemCategoryNo.value=='10')
			{
				tempVal = 	'0^1^0';
				genItemId = 	'0^1^0';
				
			}
			else
			{
				tempVal = 	'0^1^1';
				genItemId = 	'0^1^1';
			}	
				tempVal = tempVal.split('^');
			
		}
		else
		{
			 tempVal = document.forms[0].strGenItemId.value.split('^');
		}
			

	if(tempVal[1] == '0' && tempVal[2] == '0'){
	
		  document.getElementById('strBatchDivId').style.display = "none";
		  document.getElementById('strBatchItemDivId').style.display = "none";
		  
		  return false;
		
	}


   var mode ="BATCHITEMNO";  
   var url="ItemLocationTransCNT.cnt?hmode=BATCHITEMNO&itemCatNo="+document.forms[0].strItemCategoryNo.value
   									+"&genitemId="+genItemId
   									+"&itemId="+document.forms[0].strItemId.value;
   ajaxFunction(url,"5");
}

function stockDetails()
{
	//alert(document.forms[0].strMultiRowItemId.value);
	//alert(document.forms[0].strItemCategoryNo.value);
	//alert(document.forms[0].strStoreId.value);
	
   var mode ="STOCKDTL"; 
   var url="ItemLocationTransCNT.cnt?hmode=STOCKDTL&itemCatNo="+document.forms[0].strItemCategoryNo.value+
   									"&itemId="+document.forms[0].strMultiRowItemId.value+
   									"&storeid="+document.forms[0].strStoreId.value;
   									
   								   									
   ajaxFunction(url,"6");
}

/*function empStockDtls()
{
   var mode ="EMPSTOCKDTL";  
   var url="ItemLocationTransCNT.cnt?hmode=EMPSTOCKDTL&genitemId="+document.forms[0].strGenItemId.value+
   									"&itemId="+document.forms[0].strItemId.value+
   									"&batchno="+document.forms[0].strBatchNo.value+
   									"&itemslno="+document.forms[0].strItemSlNo.value;
   ajaxFunction(url,"7");
}*/

function getAjaxResponse1(res,mode)
{
	var objVal,objVal1;
	if(mode=="1")
	{	
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
        {
        	
       	  objVal= document.getElementById("groupId");
		  objVal.innerHTML = "<select name ='strGroupId' class='comboMax' onChange='subGroupCombo();'>" + res + "</select>";
		  //itemCombo(); 
		  subGroupCombo();
        }
       
       
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
        	
          objVal= document.getElementById("subGroupId");
		  objVal.innerHTML = "<select name ='strSubGroupId' class='comboMax' onChange='genItemCombo()'>" + res + "</select>";
		    // genItemCombo();
		    genItemCombo();
		     
        }
     
      // resetScreen();
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
        	objVal= document.getElementById("genItemId");
		    objVal.innerHTML = "<select name ='strGenItemId' class='comboMax' onChange='itemCombo();'>" + res + "</select>";
		   
        }
        itemCombo();
       // resetScreen();
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
          objVal= document.getElementById("itemId");
		  objVal.innerHTML = "<select name ='strItemId' class='comboMax' onchange='batchItemNoCombo();' >" + res + "</select>";
		}
		
		//resetScreen();
		
    }
    
    if(mode=="5")
	{	
		var	tempVal='0^0^0'; // tempVal[1]=IsBatch Flag ,  tempVal[2]=IsSlNo Flag
		var genItemId = document.forms[0].strGenItemId.value;
	
		if(document.forms[0].strGenItemId.value=='0')
		{
			if(document.forms[0].strItemCategoryNo.value=='10')
			{
				tempVal = 	'0^1^0';
				genItemId = 	'0^1^0';
				
			}
			else
			{
				tempVal = 	'0^1^1';
				genItemId = 	'0^1^1';
			}	
				tempVal = tempVal.split('^');
			
		}
		else
		{
			 tempVal = document.forms[0].strGenItemId.value.split('^');
		}
			
	
	//var tempVal = document.forms[0].strGenItemId.value.split('^');

		
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
       {
          if(document.forms[0].strItemCategoryNo.value=='10'){
       
       		   
	          if(tempVal[1] == '0'){
	          
	          	 document.getElementById('strBatchDivId').style.display = "none";
			     document.getElementById('strBatchItemDivId').style.display = "none";
	          
	          }else{      
			          document.getElementById('strBatchDivId').style.display = "block";
			          document.getElementById('strBatchItemDivId').style.display = "none";
			          objVal= document.getElementById("batchNoId");
					  objVal.innerHTML = "<select name ='strBatchNo' class='comboMax' onchange='resetStockDtlScreen();'>" + res + "</select>";
			      }
		  }else{
		  
		  		var temp = res.split('^');
		  
		   if(tempVal[1] == '0'){
		   	
		   		 document.getElementById('strBatchDivId').style.display = "none";
		   		
		   }else{
		   
		   		 document.getElementById('strBatchDivId').style.display = "block";
		  	 	objVal= document.getElementById("batchNoId");
		   		objVal.innerHTML = "<select name ='strBatchNo' class='comboMax' onchange='resetStockDtlScreen();'>" + temp[0] + "</select>";
		   }
		  
		 
		 if(tempVal[2] == '0'){
		   	
		   		 document.getElementById('strBatchItemDivId').style.display = "none";
		   		
		   }else{
		   
		   		  document.getElementById('strBatchItemDivId').style.display = "block";
		  	 	 objVal= document.getElementById("itemSlNoId");
		    	objVal.innerHTML = "<select name ='strItemSlNo' class='comboMax' onchange='resetStockDtlScreen();'>" + temp[1] + "</select>";
		   }
		 
		  
		  }
		}
    }
    
    if(mode=="6")
	{	
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
       {
              objVal= document.getElementById("StockDtlDivId");
		      objVal.innerHTML =  res ;
			  objVal.style.display = "block";
		 
		  
		}
		
	}
    
    
    /*if(mode=="7")
	{	
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
       {
          objVal= document.getElementById("EmpStockDtlDivId");
		  objVal.innerHTML =  res ;
		}
    }*/
    
    
    if(mode=="8")
	{	
	   var err = document.getElementById("errMsg");
	   var temp1 = res.split("####");
	   if(temp1[0] == "ERROR")
	   {
         err.innerHTML = temp1[1];	
       }else
       {
          objVal= document.getElementById("itemCategoryDivId");
		  objVal.innerHTML = objVal.innerHTML = "<select name ='strItemCategoryNo' class='comboMax' onChange='groupCombo();'>" + res + "</select>";
		  
		  resetScreen('1');
		}
		
		if(document.forms[0].strItemCategoryNo.value!='0' && document.forms[0].strItemCategoryNo.value!='' )
		{	
			//alert("Hey");
			groupCombo();
		}	
		
    }   
}


	function resetScreen(mode){
	
		
       			 
				if(mode=='1')  // On change of Store Name combo
				{
					
					/*
					objVal1= document.getElementById("groupId");
					objVal1.innerHTML = "<select name ='strGroupId' class='comboMax' onChange='subGroupCombo();'>Select Value</select>";
					
					objVal2= document.getElementById("subGroupId");
					objVal2.innerHTML = "<select name ='strSubGroupId' class='comboMax' onChange='genItemCombo()'>Select Value</select>";
					
					objVal3= document.getElementById("genItemId");
					objVal3.innerHTML = "<select name ='strGenItemId' class='comboMax' onChange='itemCombo();'>Select Value</select>";
					
					objVal4= document.getElementById("itemId");
					objVal4.innerHTML = "<select name ='strItemId' class='comboMax' onchange='batchItemNoCombo();' >All</select>";
					
					objVal5= document.getElementById("batchNoId");
					objVal5.innerHTML = "<select name ='strBatchNo' class='comboMax' onchange='resetStockDtlScreen();'>Select Value</select>";	    
					*/	
					
					
					document.forms[0].strItemCategoryNo.value='0';
					document.forms[0].strGenItemId.value='0';
		   			document.forms[0].strGroupId.value='0';
		   			document.forms[0].strSubGroupId.value='0';
		   			document.forms[0].strItemId.value='0';
		   			
		   			document.getElementById('strBatchDivId').style.display = "none";
			     document.getElementById('strBatchItemDivId').style.display = "none";
			     document.getElementById("StockDtlDivId").style.display = "none";
				
				}	
	
	}



	function resetStockDtlScreen(){
			     document.getElementById("StockDtlDivId").style.display = "none";
	
	}
	
	// To cancel the Page:
 function cancel()
 {
    document.getElementById("errMsg").innerHTML = "";
    document.forms[0].hmode.value = "CANCEL";
    document.forms[0].submit();
 }
 
 function validate1()
 {
 	if(document.forms[0].strMultiRowItemId.value=='0')
 	{
 		alert("Please Select Drug/Item from search")
 		document.getElementById("strSearchDrug").focus();
 		return false;
 	}
 	else
 		stockDetails();
 
 }
 
 function openAvlQty(obj,index)
{

        var strAvlQty = document.getElementById('strAvlQty'+index).value;     
       	       
        myArray = strAvlQty.split("@");
       
        document.getElementById("popUpAvlQtyId").innerHTML="Quantity Details";
              
        var objVal1 = document.getElementById("1");
       
        if(myArray[0]!='null' || myArray[0]!='')
        {
          objVal1.innerHTML = myArray[0];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("2");
        
        if(myArray[1]!='null' || myArray[1]!='')
        {
          objVal2.innerHTML = myArray[1]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        
        display_popup_menu(obj,'avlQtyId','825','230');
}
 
function closeAvlQtyPopUp(divId)
{
 	hide_popup_menu(divId);
}

function itemCategoryCombo()
{
	   
	   
     var url="ItemLocationTransCNT.cnt?hmode=ITEMCAT&storeId="+document.forms[0].strStoreId.value;
      ajaxFunction(url,"8");
}


function getStoreList()
{
	   document.forms[0].hmode.value="STORELIST";
	   document.forms[0].submit();
}


function getDrugNameSelected(itemId)
{
	var flag = 0;
	var sel = document.forms[0].strMultiRowItemId;	
	var totRowLength = 0;// parseInt(document.getElementsByName("rowLength1")[0].value,10);
	
	if(totRowLength > 0)
	{
		var retValue = confirm("All values will be reset\n\nAreYou Sure?");
		if(retValue) 
			resetMultiRow("1");
		else
		{
			document.forms[0].strSearchDrug.value = "";
			return;
		}	
	}
	  		
	for (var i=0; i<sel.options.length; i++) {				
		if ( sel.options[i].value.split("^")[0] == itemId.split("^")[0]) 
		{
			sel.selectedIndex = i;			
			flag = 1;
			break;
		}				
	}	
	if(flag == 0)
	{
		sel.selectedIndex=0;
		document.forms[0].strSearchDrug.value = "";
	}
	//else	    
		//getGenericDrugDetails(itemId);
}



