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
   
   var url="ItemConfigurationTransCNT.cnt?hmode=GROUPNAME&itemCatNo="+itemCatNo;
   ajaxFunction(url,"1");
   
} 

function subGroupCombo()
{
   var mode ="SUBGROUPNAME";  
   var url="ItemConfigurationTransCNT.cnt?hmode=SUBGROUPNAME&groupId="+document.forms[0].strGroupId.value;
   ajaxFunction(url,"2");
   
//   genItemCombo();
   
} 

function genItemCombo()
{
	 objVal= document.getElementById("StockDtlDivId");
		      objVal.innerHTML =  "" ;
	var mode ="GENITEMNAME";  
   var url="ItemConfigurationTransCNT.cnt?hmode=GENITEMNAME&itemCatNo="+document.forms[0].strItemCategoryNo[document.forms[0].strItemCategoryNo.selectedIndex].value+
   				"&groupId="+document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value+
   				"&subgrpid=0";
   //alert("genItemCombo():::"+url);
   ajaxFunction(url,"3");
   
   
} 

function itemCombo(sel)
{
	document.getElementById("label1").innerHTML=sel.options[sel.selectedIndex].text;
	
 
    var mode ="ITEMNAME";  
   
  	var url="ItemConfigurationTransCNT.cnt?hmode="+mode+
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
   var url="ItemConfigurationTransCNT.cnt?hmode=BATCHITEMNO&itemCatNo="+document.forms[0].strItemCategoryNo.value
   									+"&genitemId="+genItemId
   									+"&itemId="+document.forms[0].strItemId.value;
   ajaxFunction(url,"5");
}

function stockDetails()
{
   var mode ="STOCKDTL"; 
   var url="ItemConfigurationTransCNT.cnt?hmode=STOCKDTL&itemCatNo="+document.forms[0].strItemCategoryNo.value+
   									"&itemId="+document.forms[0].strMultiRowItemId.value+
   									"&storeid="+document.forms[0].strStoreId.value;
   									
   								   									
   ajaxFunction(url,"6");
}


function getAjaxResponse(res,mode)
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
	  // callPendingDayEndDetailsTable();
       
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
	  // callPendingDayEndDetailsTable();
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
      //  callPendingDayEndDetailsTable();
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
          //alert(objVal+"1");
		  objVal.innerHTML = "<select name ='strItemId' class='comboMax' onchange='batchItemNoCombo();' >" + res + "</select>";
		}
		
		//resetScreen();
	 //  callPendingDayEndDetailsTable();
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
	  // callPendingDayEndDetailsTable();
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
	  // callPendingDayEndDetailsTable();
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
          objVal= document.getElementById("itemCategoryDivId");
		  objVal.innerHTML = objVal.innerHTML = "<select name ='strItemCategoryNo' class='comboMax' onChange='groupCombo();'>" + res + "</select>";
		  
		  resetScreen('1');
		}
		
		if(document.forms[0].strItemCategoryNo.value!='0' && document.forms[0].strItemCategoryNo.value!='' )
		{	
			//alert("Hey");
			groupCombo();
		}	
	//	 callPendingDayEndDetailsTable();
    }   
}


	function resetScreen(mode){
	
		
       			 
				if(mode=='1')  // On change of Store Name combo
				{
					
									
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
 
  function displaySelectedDrug() 
 {
 	if(document.forms[0].strMultiRowItemId[document.forms[0].strMultiRowItemId.selectedIndex].value!='0')
   {	
 	 	document.getElementById("label2").innerHTML=document.forms[0].strMultiRowItemId[document.forms[0].strMultiRowItemId.selectedIndex].text;
    	if(document.getElementById("itemDivId")!=null)
    		document.getElementById("itemDivId").innerHTML = document.forms[0].strMultiRowItemId[document.forms[0].strMultiRowItemId.selectedIndex].text;
   }
   else
   {
   	document.getElementById("DrugNameId").innerHTML="";
   	if(document.getElementById("itemDivId")!=null)
   		document.getElementById("itemDivId").innerHTML = "";
   }  
 } 
  
 
 
 function validate1()
 {
 	if(document.forms[0].strMultiRowItemId.value=='0')
 	{
 		alert("You r going to search all Drugs/Items !!")
 		//document.getElementById("strSearchDrug").focus();
 		//return false;
 	} 	
 	
	 document.getElementById("row1").style.visibility = "visible"; 
	 document.getElementById("btnExport").style.visibility = "visible";
	 document.getElementById("itemsDetailsId").style.visibility = "visible";
	 
	 var mode ="STOCKDTL"; 
	   var url="ItemConfigurationTransCNT.cnt?hmode=STOCKDTL&itemCatNo="+document.forms[0].strItemCategoryNo.value+
	   									"&itemId="+document.forms[0].strMultiRowItemId.value+
	   									"&storeid="+document.forms[0].strStoreId.value;
	   									
	   								   									
	   ajaxFunction(url,"6");
 }
 function selectAllChkBox(obj)
 {
	 
    var size=document.getElementsByName("strChkBox").length;
	var count=0;
	
	if(obj.checked)
	{	
		for(var i=0;i<size;i++)
		{
	 	  document.getElementsByName("strChkBox")[i].checked = true;
	 	  document.getElementsByName("strChkFlg")[i].value   = document.getElementById("strChkBox"+i).value; 
		}
	}
	else
	{
		for(var i=0;i<size;i++)
		{
	 	  document.getElementsByName("strChkBox")[i].checked = false;
	 	  document.getElementsByName("strChkFlg")[i].value   = "0"; 
		}
	}
 }
 
 function chkboxEnable(obj,i)
 {
	//alert("i--"+i+"----"+obj.value); 
 	if(obj.checked)
 	{
 		document.getElementsByName("strChkFlg")[i].value   = document.getElementById("strChkBox"+i).value; 
 	}
 	else
 	{
 		document.getElementsByName("strChkFlg")[i].value   ="0";
 	}
 	
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
	   
	   
     var url="ItemConfigurationTransCNT.cnt?hmode=ITEMCAT&storeId="+document.forms[0].strStoreId.value;
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
	 displaySelectedDrug();
}

function saveRecord()
{
	var count = 0;
	var strChkFlg = document.getElementsByName("strChkFlg");	
	
	for(var i=0;i<strChkFlg.length;i++)
	{				
		if(strChkFlg[i].value!="" && strChkFlg[i].value!="0" && parseInt(strChkFlg[i].value,10)!=0)
      	{
      		count++;		          		
      	}	
	}
	if(count==0)
    {
  			alert("Please Select At Least One Record");  			
  			return false;
    }
	
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
function exportToExcel(tableID, filename = '') 
{
    var downloadurl;
    var dataFileType = 'application/vnd.ms-excel';
    var divSelect = document.getElementById('printDiv');
    var divSelect2 = document.getElementById('totalDiv');
    var tableSelect = document.getElementById(tableID);
    var divData = divSelect.outerHTML;
    var divData2 = divSelect2.outerHTML;
    var sysdate = document.getElementById('sysdate').outerHTML;
    var tableHTMLData = tableSelect.outerHTML.replace(/ /g, '%20');

    // Specify file name
    filename = filename ? filename + '.xls' : 'export_excel_data.xls';

    // Create download link element
    downloadurl = document.createElement("a");

    document.body.appendChild(downloadurl);

    if (navigator.msSaveOrOpenBlob) {
        var blob2 = new Blob(['\ufeff', divData + ' ' + sysdate + ' ' + tableHTMLData + ' ' + divData2], {
            type: dataFileType
        });
        navigator.msSaveOrOpenBlob(blob2, filename);
    } else {
        // Create a link to the file
        downloadurl.href = 'data:' + dataFileType + ',' + encodeURIComponent(divData + ' ' + sysdate + ' ' + tableHTMLData + ' ' + divData2);

        // Setting the file name
        downloadurl.download = filename;

        // Triggering the download
        downloadurl.click();
    }
}






