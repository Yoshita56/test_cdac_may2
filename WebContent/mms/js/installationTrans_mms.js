

function getItemCatCmb()
{

	   var url="InstallationTransCNT.cnt?hmode=ITEMCATEGORY&storeid="+document.forms[0].strStoreId.value;
	   ajaxFunction(url,"1");
	   //getGroupCmb();
  
} 
function getGroupCmb()
{
	if(document.forms[0].strItemCatNo.value!=0){
	   var url="InstallationTransCNT.cnt?hmode=GROUPNAME&itemCatNo="+document.forms[0].strItemCatNo.value;
	   ajaxFunction(url,"2");
	   }
   
} 
+
function getSubGroupCmb()
{
   var url="InstallationTransCNT.cnt?hmode=SUBGROUPNAME&groupId="+document.forms[0].strGroupId.value;
   ajaxFunction(url,"3");
} 

function getGenItemCmb()
{
   var url="InstallationTransCNT.cnt?hmode=GENITEMNAME&itemCatNo="+document.forms[0].strItemCatNo[document.forms[0].strItemCatNo.selectedIndex].value+
   				"&groupId="+document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value+
   				"&subgrpid="+document.forms[0].strSubGroupId[document.forms[0].strSubGroupId.selectedIndex].value;
   ajaxFunction(url,"4");
} 

function getItemCmb()
{
   var url="InstallationTransCNT.cnt?hmode=ITEMNAME&storeid="+document.forms[0].strStoreId.value+
   				"&itemCatNo="+document.forms[0].strItemCatNo[document.forms[0].strItemCatNo.selectedIndex].value+
   				"&groupId="+document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value+
   				"&subgrpid="+document.forms[0].strSubGroupId[document.forms[0].strSubGroupId.selectedIndex].value+
   				"&genitemid="+document.forms[0].strGenericItemId[document.forms[0].strGenericItemId.selectedIndex].value;
   ajaxFunction(url,"5");
} 

function getBatchSerialNoCmb()
{
   document.forms[0].strIsConsumable.value = document.forms[0].strItemBrandId.value.split('^')[1];
   var url="InstallationTransCNT.cnt?hmode=BATCHSLNO&storeid="+document.forms[0].strStoreId.value+
   							"&itemCatNo="+document.forms[0].strItemCatNo[document.forms[0].strItemCatNo.selectedIndex].value
   									+"&genitemId="+document.forms[0].strGenericItemId[document.forms[0].strGenericItemId.selectedIndex].value
   									+"&itemId="+document.forms[0].strItemBrandId.value;
								
   ajaxFunction(url,"6");
  
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
        
        	if(document.forms[0].strStoreId.value != 0){
        	
        		 objVal= document.getElementById("itemCategoryId");
			  	 objVal.innerHTML = "<select name ='strItemCatNo' class='comboNormal' onChange='getGroupCmb();'>" + res + "</select>";
        	
        	}else{
        	
			  	document.getElementById("itemCategoryId").innerHTML = "<select name ='strItemCatNo' onChange='getGroupCmb();'><option value = '0'>Select Value</option></select>";
		  	    document.getElementById("groupId").innerHTML = "<select name ='strGroupId' onChange='getSubGroupCmb();'><option value = '0'>Select Value</option></select>";
			    document.getElementById("subGroupId").innerHTML = "<select name ='strSubGroupId' onChange='getGenItemCmb();'><option value = '0'>Select Value</option></select>";
				document.getElementById("genItemId").innerHTML = "<select name ='strGenericItemId' onChange='getItemCmb();'><option value = '0'>Select Value</option></select>";
			    document.getElementById("itemId").innerHTML = "<select name ='strItemBrandId' onChange='getBatchSerialNoCmb();'><option value = '0'>Select Value</option></select>";  
                document.getElementById("stockPositionDivId").style.display="none";
        		document.getElementById("strBatchDivId").style.display="none";
        		document.getElementById("strItemDivId").style.display="none";
        	}
        getGroupCmb();
        
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
        	if(document.forms[0].strItemCatNo.value != 0){
        	
	        	 objVal= document.getElementById("groupId");
			  	 objVal.innerHTML = "<select name ='strGroupId' onChange='getSubGroupCmb();'>" + res + "</select>";
		  	 
		  	 }else{
        	
		  	    document.getElementById("groupId").innerHTML = "<select name ='strGroupId' onChange='getSubGroupCmb();'><option value = '0'>Select Value</option></select>";
			    document.getElementById("subGroupId").innerHTML = "<select name ='strSubGroupId' onChange='getGenItemCmb();'><option value = '0'>Select Value</option></select>";
				document.getElementById("genItemId").innerHTML = "<select name ='strGenericItemId' onChange='getItemCmb();'><option value = '0'>Select Value</option></select>";
			    document.getElementById("itemId").innerHTML = "<select name ='strItemBrandId' onChange='getBatchSerialNoCmb();'><option value = '0'>Select Value</option></select>";  
                document.getElementById("stockPositionDivId").style.display="none";
        		document.getElementById("strBatchDivId").style.display="none";
        		document.getElementById("strItemDivId").style.display="none";
        	}
        
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
        
        	if(document.forms[0].strGroupId.value != 0){
        
        		objVal= document.getElementById("subGroupId");
			    objVal.innerHTML = "<select name ='strSubGroupId' class='comboNormal' onChange='getGenItemCmb();'>" + res + "</select>";
			    getGenItemCmb();
			    
		   } else{
       	
		    document.getElementById("subGroupId").innerHTML = "<select name ='strSubGroupId' onChange='getGenItemCmb();'><option value = '0'>Select Value</option></select>";
			document.getElementById("genItemId").innerHTML = "<select name ='strGenericItemId' onChange='getItemCmb();'><option value = '0'>Select Value</option></select>";
		    document.getElementById("itemId").innerHTML = "<select name ='strItemBrandId' onChange='getBatchSerialNoCmb();'><option value = '0'>Select Value</option></select>";  
            document.getElementById("stockPositionDivId").style.display="none";
       		document.getElementById("strBatchDivId").style.display="none";
        	document.getElementById("strItemDivId").style.display="none";
       	  }
        }
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
		  objVal.innerHTML = "<select name ='strGenericItemId' class='comboNormal' onChange='getItemCmb();'>" + res + "</select>";
        }
        
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
		  objVal.innerHTML = "<select name ='strItemBrandId' class='comboNormal' onChange='getBatchSerialNoCmb();'>" + res + "</select>";  
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
       }else
        {
        	var itemBrandId = document.forms[0].strItemBrandId.value;
        	document.forms[0].strIsConsumable.value = itemBrandId.split('^')[1];
        
		 	 if(document.forms[0].strItemCatNo.value=='10'){
       
	       		 if(tempVal[1] == '0'){
		          
		          	 document.getElementById('strBatchDivId').style.display = "none";
				     document.getElementById('strItemDivId').style.display = "none";
		          
		          }else{      
			         document.getElementById('strBatchDivId').style.display = "block";
			         document.getElementById('strItemDivId').style.display = "none";
			         objVal= document.getElementById("batchNoId");
					 objVal.innerHTML = "<select name ='strBatchNo' class='comboNormal' onChange='stockPosition(this)'>" + res + "</select>";
					 document.getElementById("stockPositionDivId").style.display="none";
			      }
			   
		  }else{
		  
		  	   var temp = res.split('@');
		  
			   if(tempVal[1] == '0'){
			   	
			   		document.getElementById('strBatchDivId').style.display = "none";
			   		
			   }else{
			   			
			   		document.getElementById('strBatchDivId').style.display = "block";
			  	 	objVal= document.getElementById("batchNoId");
			   		objVal.innerHTML = "<select name ='strBatchNo' class='comboNormal' onchange='stockPosition(this);'>" + temp[0] + "</select>";
			   		document.getElementById("stockPositionDivId").style.display="none";
			   		
			   	
			   }
		  
		 
		 if(tempVal[2] == '0'){
		   	
		   		 document.getElementById('strItemDivId').style.display = "none";
		   		
		   }else{
		   		 document.getElementById('strItemDivId').style.display = "block";
		  	 	 objVal= document.getElementById("itemSlNoId");
		    	 objVal.innerHTML = "<select name ='strItemSlNo' class='comboNormal' onChange='stockPosition(this)'>" + temp[1] + "</select>";
		    	 document.getElementById("stockPositionDivId").style.display="none";
		   }
		 
		  
		  }
		 	 
		 	 
		 	if(document.forms[0].strIsConsumable.value =='1'){
				document.getElementById("installationDtlsDivId").style.display="block";
			}else{
				document.getElementById("installationDtlsDivId").style.display="none";
			}
        }
    }
}



function stockPosition(obj)
{
	if(obj.value == '0'){
		document.getElementById("stockPositionDivId").style.display="none";
		return false;
	}
		var temp = obj.value.split('^');
	
			document.getElementById("avlQtyDivId").innerHTML = temp[2];
			document.getElementsByName('strInhandQty')[0].value = temp[2];
			
			if(temp[3]=="")
			{
				document.getElementById("poNoDivId").innerHTML = "---"
			}
			else{
				document.getElementById("poNoDivId").innerHTML = temp[3];
				}
		
			document.getElementsByName('strPONo')[0].value = temp[3];
			
			if(temp[4]=="")
			{
				document.getElementById("poDateDivId").innerHTML = "---"
			}else{
				document.getElementById("poDateDivId").innerHTML = temp[4];
			}
			document.getElementsByName('strPODate')[0].value = temp[4];
			
			if(temp[5]=="")
			{
				document.getElementById("suppliedByDivId").innerHTML = "---"
			}else{
				document.getElementById("suppliedByDivId").innerHTML = temp[5];
			}
			document.getElementsByName('strSupplierId')[0].value = temp[5];
			
					
	if(document.forms[0].strIsConsumable.value =='1'){
		document.getElementById("installationDtlsDivId").style.display="block";
	}else{
		document.getElementById("installationDtlsDivId").style.display="none";
	}
	
	document.getElementById("stockPositionDivId").style.display="block";
}




// To cancel the Page:
 function cancel()
 {
    document.getElementById("errMsg").innerHTML = "";
    document.forms[0].hmode.value = "CANCEL";
    document.forms[0].submit();
 }


function goFuncView()               
{
        var hisValidator = new HISValidator("installationTransBean");  
         hisValidator.addValidation("strStoreId","dontselect=0","Please select Drug Warehouse Name");
        hisValidator.addValidation("strItemCatNo","dontselect=0","Please select an Item Category");
	 	
		var retVal = hisValidator.validate();
		 
		
	    if(retVal)
	    {
	            document.forms[0].strHidStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	    		document.forms[0].strItemCategoryName.value=document.forms[0].strItemCatNo[document.forms[0].strItemCatNo.selectedIndex].text;
			    //document.forms[0].hideItemCatId.value=document.forms[0].strItemCatNo.value;
			    document.forms[0].displayFlag.value="1";
		         	
	        	document.forms[0].hmode.value="VIEWITEMGO";
				document.forms[0].submit();
	           	
		}else{
		
		return false;
		}
	
	
}


function ViewHideandBlock(){
    document.getElementsByName('strView')[0].checked = true;
	if(document.forms[0].displayFlag.value=="1")
   		{
   		   document.getElementById("StoreDivId").style.display= "none";
   		   document.getElementById("StoreNameDivId").style.display= "block";
		   document.getElementById("itemCategoryId").style.display= "none";
	       document.getElementById("ItemCatNamedivId").style.display= "block";
	       document.getElementById("installationDivId").style.display= "block";
	       document.getElementById("imageDivId").style.display= "none";
	       document.getElementsByName('strView')[0].disabled=true;

		}else {
		   document.getElementById("StoreDivId").style.display= "block";
   		   document.getElementById("StoreNameDivId").style.display= "none";
		   document.getElementById("itemCategoryId").style.display= "block";
	       document.getElementById("ItemCatNamedivId").style.display= "none";
	       document.getElementById("installationDivId").style.display= "none";
	       document.getElementById("imageDivId").style.display= "block";
	     		
		}
	}	
	
	
	
function diplayView(){
 
	 /*if(document.getElementsByName('strView')[0].checked)
	 {
   
     	document.forms[0].hmode.value="VIEW";
 	  	document.forms[0].displayFlag.value="0";
		document.forms[0].submit(); 
    
    	}else {
    	
    	document.forms[0].hmode.value="unspecified";
 	    document.forms[0].displayFlag.value="0";
		document.forms[0].submit(); 
    	
    	}*/
    	
    	//alert("document.forms[0].displayFlag.value---"+document.forms[0].displayFlag.value);
    	
    	if(document.forms[0].strView.checked==true)
    	{
			document.forms[0].hmode.value = "VIEW";
            document.forms[0].submit();
        }
        else if(document.forms[0].strView.checked==false)
        {
     		document.forms[0].hmode.value="unspecified";
		    document.forms[0].submit(); 
        }
	}
	
	
	
	
	
	
	
	

