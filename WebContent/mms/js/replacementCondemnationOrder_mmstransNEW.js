var parentPopup;
function getMultiRow(obj)
{
     	var noOfRow = document.forms[0].strNoOfMultiRow.value;
     	for(var i=0; i<noOfRow;i++)
     	{     		
     		addRows(new Array('strMultiRowBatchNo','strMultiRowReceiveQty','strMultiRowUnit'),new Array('t','t','s'),'1','1','R');     		
     	}
     	//document.getElementById("compileId").style.display="block"; 
}
function cancelMultiRow(index)
{
	document.forms[0].strNoOfMultiRow.value='';
	document.getElementById("id1").innerHTML ="";
	
}
function hideGroup(index)
{	
	if(document.getElementById("buttonVal"+index).value=='0')
	{
		document.getElementById("minusButtodId").style.display="block";
	    document.getElementById("plusButtodId").style.display="none";
	    document.getElementById("buttonVal"+index).value='1';
	    document.getElementById("receivedDrugDtl"+index).style.display="block";
	   
	}	
	else
	{		
		document.getElementById("receivedDrugDtl"+index).style.display="none";
		document.getElementById("minusButtodId").style.display="none";
	    document.getElementById("plusButtodId").style.display="block";
	    document.getElementById("buttonVal"+index).value='0';
	   
	    
	}
}

function getOtherTextBox(obj){
	
	alert(obj.id);
	alert(document.getElementById(obj.id).value);
	 var str = obj.id ;
	  var res = str.substr(16, 20);
	  alert(res);
	if(document.getElementById(obj.id).value == '5' || document.getElementById(obj.id).value == 5){
		alert('if');
		document.getElementById("itemRemarksDivId"+res).style.display="block";
	}else{
		alert('else');
		document.getElementById("itemRemarksDivId"+res).style.display="none";
	}
} 
function getOtherTextBox1(obj){
	
	//alert(obj.id);
	//alert(document.getElementById(obj.id).value);
	 var str = obj.id ;
	  var res = str.substr(16, 20);
	//  alert(res);
	if(document.getElementById(obj.id).value == '5' || document.getElementById(obj.id).value == 5){
		alert('if');
		document.getElementById("itemRemarksDivId"+res).style.display="block";
	}else{
		alert('else');
		document.getElementById("itemRemarksDivId"+res).style.display="none";
	}
}
function showDiv1(_strDivId)
{
	document.getElementById(_strDivId).style.display="block";
}

function hideDiv1(_strDivId)
{
	document.getElementById(_strDivId).style.display="none";
}
function resetDiv()
{
		objVal = document.getElementById("pendingOrderDtlsDivId");
	    objVal.innerHTML = "";
	    objVal = document.getElementById("nosqDrugDtlsDivId");
	    objVal.innerHTML = "";    
	    
	    document.getElementById("pendingOrderHdrDiv").style.display="none";
}
function getCatcmb()
{
	//alert('1');
	var mode="GETCATCMB";
    var url="ReplacementCondemnationOrderTransCNTNEW.cnt?hmode="+mode
     +"&storeId="+document.forms[0].strStoreId.value;
    ajaxFunction(url,"10");
}

function getsuppliername()
{
	//alert(document.forms[0].strcatno.value);
	var mode="GETSUPPLIERCMB";
    var url="ReplacementCondemnationOrderTransCNTNEW.cnt?hmode="+mode
     +"&storeId="+document.forms[0].strStoreId.value+"&catcode="+document.forms[0].strcatno.value;
    ajaxFunction(url,"11");
}

function getPendingOrderDtl()
{
	
	document.getElementById("radionbtn1").style.display='none';
	var mode =document.forms[0].strActionsId.value;
	//alert(mode);
	document.getElementById("errMsg").innerHTML="";
    var hisValidator = new HISValidator("replacementCondemnationOrderTransBean");               
    hisValidator.addValidation("strStoreId", "dontselect=0","Please Select a Store Name !!");
    hisValidator.addValidation("strcatno", "dontselect=0","Please Select Item Category !!");
    if( document.forms[0].strActionsId.value == '1')
    {
    hisValidator.addValidation("strsupplierno", "dontselect=0","Please Select Supplier Name !!"); 
    
    }
    var retVal = hisValidator.validate();
    hisValidator.clearAllValidations();   
    objVal = document.getElementById("pendingOrderDtlsDivId");
	objVal.innerHTML = "";   
    if (retVal) 
    {	    	
    	if(mode=='2') // condenmination
    	{
	    	var mode="GETPENDINGORDERDTL";
	        var url="ReplacementCondemnationOrderTransCNTNEW.cnt?hmode="+mode
	         +"&storeId="+document.forms[0].strStoreId.value+"&actionId="+document.forms[0].strActionsId.value+"&catcode="+document.forms[0].strcatno.value+"&suppliercode="+document.forms[0].strsupplierno.value;                
	        ajaxFunction(url,"4");
    	}
    	
    	/*if(mode=='2') // Means Replacement
    	{
	    	var mode="GETPENDINGORDERDTL";
	        var url="ReplacementCondemnationOrderTransCNT.cnt?hmode="+mode
	         +"&storeId="+document.forms[0].strStoreId.value+"&actionId=1";                
	        ajaxFunction(url,"4");
    	}*/
    	
    	if(mode=='1') // Means Condemnation
    	{
	    	var mode="GETPENDINGORDERDTL";
	        var url="ReplacementCondemnationOrderTransCNTNEW.cnt?hmode="+mode
	         +"&storeId="+document.forms[0].strStoreId.value+"&actionId="+document.forms[0].strActionsId.value+"&catcode="+document.forms[0].strcatno.value+"&suppliercode="+document.forms[0].strsupplierno.value;                
	        ajaxFunction(url,"4");
    	}
    	             	
      
    }                 
  
}
	var gblParentObj = "";	
	
	function getNOSQDrugListHLP()
	{
	    var hisValidator = new HISValidator("replacementCondemnationOrderTransBean");               
	    hisValidator.addValidation("strStoreId", "dontselect=0","Please Select a HQ !!");
	    var retVal = hisValidator.validate();
	    hisValidator.clearAllValidations();
	   
	    if (retVal) 
	    {
	    	var mode="GETNOSQDRUGLISTHLP";
	        var url="ReplacementCondemnationOrderTransCNTNEW.cnt?hmode="+mode
	        +"&storeId="+document.forms[0].strStoreId.value;                  
	        ajaxFunction(url,"1");        
	    }
	  
	}	
	function getExpiryDtl()
	{
	
		document.forms[0].strStoreId.disabled = false;
		document.forms[0].strcatno.disabled = false;
		document.forms[0].strsupplierno.disabled = false;
		document.forms[0].strActionsId.disabled = false;
		
	  if(document.forms[0].strExpiryRejectedFlg.value=='0')
	  {	
		var hisValidator = new HISValidator("replacementCondemnationOrderTransBean");               
	    hisValidator.addValidation("strStoreId", "dontselect=0","Please Select a HQ !!");
	    var retVal = hisValidator.validate();
	    hisValidator.clearAllValidations();
	   
	    if (retVal) 
	    {
	    	var mode="GETEXPIRYREJECTED";
	        var url="ReplacementCondemnationOrderTransCNTNEW.cnt?hmode="+mode
	        +"&storeId="+document.forms[0].strStoreId.value+"&storeId="+document.forms[0].strStoreId.value+"&catcode="+document.forms[0].strcatno.value+"&suppliercode="+document.forms[0].strsupplierno.value+"&strActionsId="+document.forms[0].strActionsId.value;                  
	        ajaxFunction(url,"5");        
	    }
	  } 
	}	
	
	function getRejectedDtl()
	{
	
	  if(document.forms[0].strRejectedFlg.value=='0')
	  {	
		var hisValidator = new HISValidator("replacementCondemnationOrderTransBean");               
	    hisValidator.addValidation("strStoreId", "dontselect=0","Please Select a HQ !!");
	    var retVal = hisValidator.validate();
	    hisValidator.clearAllValidations();
	   
	    if (retVal) 
	    {
	    	var mode="GETEXPIRYREJECTED";
	        var url="ReplacementCondemnationOrderTransCNTNEW.cnt?hmode="+mode
	        +"&storeId="+document.forms[0].strStoreId.value;                  
	        ajaxFunction(url,"6");        
	    }
	  } 
	}	

	
	
	function getBAndSDtl()
	{ //alert("JII");
		if(document.forms[0].strIndentedDrugFlg.value=='0')
		  {	
			var hisValidator = new HISValidator("replacementCondemnationOrderTransBean");               
		    hisValidator.addValidation("strStoreId", "dontselect=0","Please Select a store !!");
		    var retVal = hisValidator.validate();
		    hisValidator.clearAllValidations();
		   
		    if (retVal) 
		    {
		    	var mode="GETREGULARINDENTDRUGLIST";
		        var url="ReplacementCondemnationOrderTransCNTNEW.cnt?hmode="+mode
		        +"&storeId="+document.forms[0].strStoreId.value;                  
		        ajaxFunction(url,"7");        
		    }
		  } 
		
	}
	 function getAjaxResponse(res, mode) 
	 {
			var err = document.getElementById("errMsg");
			var temp = res.split("####");
			if(temp[0] == "ERROR")
			{
				err.innerHTML = temp[1];
				return;
			}
			var objVal;
			if (mode == "1") 
			{	       						       
				objVal = document.getElementById("nosqDrugDtlsDivId");
				objVal.innerHTML = res;
				document.getElementById("pendingOrderHdrDiv").style.display="block";
				document.getElementById("actionDtlsDivId").style.display="block";
			}
				
			if(mode=="2")
			{
				var index = res.split("$$")[1];	
				var response = res.split("$$")[0];										
				document.getElementById("strStockPopUpDtls"+index).innerHTML = response;
				document.getElementById("strStockPopUpDtls"+index).style.display = "block";
				//var pos = findPos();
				
				//popup('strStockPopUpDtls', '150', pos[1]);
				
				display_popup_menu(parentPopup, "strStockPopUpDtls"+index, '650', '');						
			
			}
	
			if(mode=="3")
			{
				document.getElementById('showbar').style.visibility = 'hidden';
	   			progress_stop();				
				//alert(res);			
				document.getElementById("replacementOrderScheduleDtlDivId").innerHTML=res;	
				document.getElementById("replacementOrderScheduleDtlDivId").style.display='';			
				document.forms[0].strGoFlag.value='1';
														
			}
			if (mode == "4") 
			{
			
				objVal = document.getElementById("pendingOrderDtlsDivId");
				objVal.innerHTML = res.split("$")[0];
				document.forms[0].strStoreId.disabled = true;
				document.forms[0].strcatno.disabled = true;
				document.forms[0].strsupplierno.disabled = true;
				//document.forms[0].strActionsId.disabled = true;
				if(res.split("$")[1]=='1')
				{
				  document.forms[0].strReplacementRadio.checked = true;
				  document.forms[0].strCondemRadio.checked = false;
				}  
				if(res.split("$")[1]=='2')
				{
				  document.forms[0].strCondemRadio.checked = true;
				  document.forms[0].strReplacementRadio.checked = false;
				} 
				objVal = document.getElementById("approvedByCmb");
				objVal.innerHTML = "<select name='strVerifiedBy' onchange='getOtherRemarks()' class='browser-default custom-select'>"+res.split("$")[2]+"</select>";	
				
				objVal = document.getElementById("itemnamediv");
				objVal.innerHTML = "<select name='strItemCode' id='strItemCode' class='browser-default custom-select'>"+res.split("$")[3]+"</select>";
				//alert(res.split("$")[4]);
				objVal = document.getElementById("CommitteTypeCmb");
				objVal.innerHTML = "<select name='strCommitteType' class='browser-default custom-select'>"+res.split("$")[4]+"</select>";
				getNOSQDrugListHLP();
				abc();
			}		
			if (mode == "5") 
			{
				document.forms[0].strStoreId.disabled = true;
				document.forms[0].strcatno.disabled = true;
				document.forms[0].strsupplierno.disabled = true;
				//document.forms[0].strActionsId.disabled = true;
				//alert(res.split("$")[0]);
				objVal = document.getElementById("expiryDtlsDivId");
				objVal.innerHTML = res.split("$")[0];
				//alert(res.split("$")[1]);
				objVal = document.getElementById("suggestedDtlsDivId");
				objVal.innerHTML = res.split("$")[1];
				document.forms[0].strExpiryRejectedFlg.value = "1";
				
				
											
			}	
			
			if (mode == "6") 
			{			
				objVal = document.getElementById("rejectedDrugDtlsDivId");
				objVal.innerHTML = res.split("$")[1];				
				document.forms[0].strRejectedFlg.value = "1";											
			}		
			if (mode == "7") 
			{
			  // alert(res);
				objVal = document.getElementById("IndentedDrugsDtlsDivId");
				objVal.innerHTML = res;//.split("$")[0];	
				alert(objVal.innerHTML);
				document.getElementById("IndentedDrugsDtlsDivId").innerHTML=res;
				document.forms[0].strIndentedDrugFlg.value = "1";
											
			}	
			if (mode == "10") 
			{
			   //alert(res);
				var objVal = document.getElementById("catcmbdiv");
				objVal.innerHTML = "<select name = 'strcatno' class='browser-default custom-select' onchange='getsuppliername()' >" + res + "</select>";
											
			}
			if (mode == "11") 
			{
			   //alert(res);
				var objVal = document.getElementById("supplierdiv");
				objVal.innerHTML = "<select name = 'strsupplierno' class='browser-default custom-select' onchange='' >" + res + "</select>";
											
			}	
	  } 
		  
	function cancelPage(mode) 
	{
		showMenuFrame();
		document.forms[0].hmode.value = mode;
		document.forms[0].submit();
	}


 /**
  * showView
  * @param {String} divId 
  */
  function showView(divId) 
  {
  	
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


function showDeliveryDateDetails(mode,obj,index)
{		
  var nOSQDrugObj   = document.getElementsByName("strNosqDrugs");
  var expiryDrugObj = document.getElementsByName("strExpiryDrugs");
  var rejDrugObj    = document.getElementsByName("strRejectedDrugs");
   /*
        orderType = 1 >> NOSQ
                  = 2 >> Rejected
                  = 3 >> Expired   
  */
  if(mode=='1')   // NOSQ Drugs
  {
  	   document.forms[0].strActionMode.value="1";
  	   var nOSQInhand  = document.getElementById("strNosqDrugs"+index).value.split("^")[6];
  	   document.forms[0].strGlbReplacementQty.value = 	nOSQInhand;  	  	   
  	   document.forms[0].strReplacementQty.disabled= true;
  	   document.forms[0].strReplacementQty.value = 	nOSQInhand;
  	   document.getElementById("deliveryDate").style.display="none";
  	   
  	   document.forms[0].strActionHiddenValue.value=obj.value;
  	   
  	   for(var i=0;i<expiryDrugObj.length;i++)
  	   {
  	   	  expiryDrugObj[i].checked = false;
  	   }
  	   for(var j=0;j<rejDrugObj.length;j++)
  	   {
  	   	  rejDrugObj[j].checked = false;
  	   }
  	   
  	  
  	   
  }	
  if(mode=='2')  // Expiry Drugs
  {
  	   document.forms[0].strActionMode.value="3";
  	   var exPiryInhand  = document.getElementById("strExpiryDrugs"+index).value.split("^")[6];
  	   document.forms[0].strGlbReplacementQty.value = 	exPiryInhand;
  	   document.forms[0].strReplacementQty.value = 	exPiryInhand;
  	   document.forms[0].strReplacementQty.disabled= true;
  	   document.forms[0].strActionHiddenValue.value=obj.value;
  	   if(document.forms[0].strActionsId.value=='1')
  	   {
  	     document.getElementById("deliveryDate").style.display="none";
  	   }   
  	   
  	   for(var i=0;i<nOSQDrugObj.length;i++)
  	   {
  	   	  nOSQDrugObj[i].checked = false;
  	   }
  	   for(var j=0;j<rejDrugObj.length;j++)
  	   {
  	   	  rejDrugObj[j].checked = false;
  	   }
  }
  if(mode=='3') // Rejected Drugs
  {
  	   document.forms[0].strActionMode.value="2";
  	   var rejectedInhand  = document.getElementById("strRejectedDrugs"+index).value.split("^")[6];
  	   document.forms[0].strGlbReplacementQty.value = 	rejectedInhand;
  	   document.forms[0].strReplacementQty.value = 	rejectedInhand;
  	   document.forms[0].strReplacementQty.disabled= true;
  	   document.forms[0].strActionHiddenValue.value=obj.value;
  	   
  	   if(document.forms[0].strActionsId.value=='1')
  	   {
  	     document.getElementById("deliveryDate").style.display="block";
  	   } 
  	   
  	   for(var i=0;i<nOSQDrugObj.length;i++)
  	   {
  	   	  nOSQDrugObj[i].checked = false;
  	   }
  	   for(var j=0;j<expiryDrugObj.length;j++)
  	   {
  	   	  expiryDrugObj[j].checked = false;
  	   }
  }
  if(mode=='4')  // regular indent Drugs
  {
  	   document.forms[0].strActionMode.value="3";
  	   var exPiryInhand  = document.getElementById("strIndentedDrugs"+index).value.split("^")[6];
  	  // alert(exPiryInhand);
  	   document.forms[0].strGlbReplacementQty.value = 	exPiryInhand;
  	   document.forms[0].strReplacementQty.value = 	exPiryInhand;
  	   document.forms[0].strReplacementQty.disabled= true;
  	   document.forms[0].strActionHiddenValue.value=obj.value;
  	   if(document.forms[0].strActionsId.value=='1')
  	   {
  	     document.getElementById("deliveryDate").style.display="block";
  	   }   
  	   
  /*	   for(var i=0;i<nOSQDrugObj.length;i++)
  	   {
  	   	  nOSQDrugObj[i].checked = false;
  	   }
  	   for(var j=0;j<rejDrugObj.length;j++)
  	   {
  	   	  rejDrugObj[j].checked = false;
  	   }*/
  }
}

function setCmbValue(obj)
{
	//alert("Action Mode:::"+document.forms[0].strActionMode.value+"::Action Type:::"+obj.value);
     	if((document.forms[0].strActionMode.value=='2'||document.forms[0].strActionMode.value=='3') && (obj.value=='1'))
  	    {
  	        document.getElementById("deliveryDate").style.display="block";  	        
  	    } 
  	    else
  	    {  	    	
  	    	 document.getElementById("deliveryDate").style.display="none";  	    	  	    	
  	    }
  	    
  	    
  	    if(obj.value=='1')
  	    {  	        
  	        document.getElementById("textId").innerHTML ="<font size='2' color='red'>*</font>Replacement Qty";
  	    } 
  	    else
  	    {
  	        document.getElementById("textId").innerHTML ="<font size='2' color='red'>*</font>Condemnation Qty";
  	    }
}
function displayAvailableStockPopupDtls(obj, itemBrandId, batchNo,index) {

    var len= document.getElementsByName("strNosqDrugs").length;
    //alert("len: "+len);
    for(var i=0; i<len; i++)
    {
    	document.getElementById("strStockPopUpDtls"+i).style.display = "none";	
    }
	
	parentPopup = obj;	
	//alert("index: "+index);

    var mode = "GETAVAILABLESTOCKDTL";
    var url = "ReplacementCondemnationOrderTransCNTNEW.cnt?hmode=" + mode + "&strStoreId="
			+ document.forms[0].strStoreId.value + "&strItemBrandId=" +itemBrandId + "&strBatchNo=" +batchNo+"&index="+index;
    //alert(url);    
    ajaxFunction(url, "2");  
    
}



function getOrderScheduleDtl()
{
	//alert("getOrderScheduleDtl");
    var hisValidator = new HISValidator("replacementCondemnationOrderTransBean");               
    hisValidator.addValidation("strStoreId", "dontselect=0","Please Select a Store !!");
    var retVal = hisValidator.validate();
    hisValidator.clearAllValidations();
       
    if (retVal) 
    {
    	var obj = document.getElementsByName("strNosqDrugs");
    	var count = 0, strHiddenItemDtl;
    	for(var i=0; i< obj.length; i++)
        {
        	//alert("in for loop");
        	if(obj[i].checked == true)
        	{
        		count= count+1;
        		strHiddenItemDtl = document.getElementById("strNosqDrugs"+i+"").value;	
        		//alert("strHiddenItemDtl: "+strHiddenItemDtl);
        	}	
        }
        if(count>0)
        {
        	var mode="GETORDERSCHEDULEDTL";
	        var url="ReplacementCondemnationOrderTransCNTNEW.cnt?hmode="+mode
	        +"&strHiddenItemDtl="+strHiddenItemDtl;                  
	        ajaxFunction(url,"3");   
        	
        }	   	
    	     
    }
    else
    {
    	progress_stop();
	    return false;    	
    }                    
  
}

function setReplacedQty(obj,indx)
{  
  
   var passValue = document.getElementById("strPODetailsHidValue"+indx.split('-')[0]).value;
  
    
   if(obj.value != 0 &&  obj.value !="")
   {
   		document.getElementById("strPODetailsHidValue"+indx.split('-')[0]).value = passValue+"@"+obj.value+"^"+indx.split('-')[1];  
   		alert("passValue after adding replaced qty: "+passValue); 		
   }
   else
   {
   		document.getElementById("strPODetailsHidValue"+indx.split('-')[0]).value = passValue;
   }    
}

function valideateInsert()
{
	document.forms[0].strStoreId.disabled = false;
	document.forms[0].strcatno.disabled = false;
	document.forms[0].strsupplierno.disabled = false;
	document.forms[0].strActionsId.disabled = false;
	var checkbox = document.getElementsByName('strExpiryDrugs');
	var ln = 0;
	for(var i=0; i< checkbox.length; i++) {
	    if(checkbox[i].checked)
	        ln++;
	}
	if(ln<=0)
	{
	alert('Please Select Drug/Item From List');
	return false;
	}
	if(ln>1)
	{	
		for(var i=0; i< checkbox.length; i++) {
			
			for(var j=i+1; j< checkbox.length; j++) {
				//alert(checkbox[i].value.split('^')[0]);
				//alert(checkbox[j].value);
			if(checkbox[i].checked  && checkbox[j].checked)
			{
				if(checkbox[i].value.split('^')[1]==checkbox[j].value.split('^')[1] && checkbox[i].value.split('^')[2]==checkbox[j].value.split('^')[2])
				{
					alert('Duplicate Item Present In Expired Drug List') ;
					return false;
				}
			}
			}
			
		     
		}
	}
	var act=document.forms[0].strActionsId.value;
	
	//alert(ln);
	//alert(document.forms[0].strActionHiddenValue.value);
	//return false;
	//if(document.forms[0].strActionHiddenValue.value != "0" && document.forms[0].strActionHiddenValue.value != NULL)
	//{
		var hisValidator = new HISValidator("replacementCondemnationOrderTransBean");
	
	hisValidator.addValidation("strStoreId", "dontselect=0", "Please Select Store Name" );
	hisValidator.addValidation("strcatno","dontselect=0", "Please Select Category Name");
		
	  
	if((document.forms[0].strActionMode.value=='2' ||document.forms[0].strActionMode.value=='3') && (document.forms[0].strActionsId.value=='1'))
	{
		//hisValidator.addValidation("strDeliveryDate",  "req", "Next Delivery Date is Mandatory" ); 
		//hisValidator.addValidation("strDeliveryDate",  "dtgt="+document.forms[0].strCtDate.value, "Next Delivery Date Must be greater than Current Date." );
		hisValidator.addValidation("strVerifiedBy",    "dontselect=0", "Please Select Verify By" );
		hisValidator.addValidation("strVerifiedDate",  "req", "Verify Date is Mandatory" ); 
		hisValidator.addValidation("strsupplierno","dontselect=0", "Please Select Supplier Name");
	}
	if(parseInt(act)==2)
	{
		hisValidator.addValidation("strCommitteType","dontselect=0", "Please Select Committe Type");	
	}
	//hisValidator.addValidation("strRemarks", "req", "Please Enter Remarks" ); 
	hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	if(retVal)
	{
	   
	   		
	        	if(	confirm("You Are Going To Save Data"))				
				{
					if(confirm(" do you want to save ?"))
					{
						
						 document.getElementsByName("strReplacementQty")[0].disabled=false;
						 document.forms[0].strStoreId.disabled=false;			   
						 document.forms[0].hmode.value="INSERT";
						 document.forms[0].submit();						
					}	
					
				}
				else
				{
					return false;
				}		       	
	        
					   
	}
	//}
	else
	{
		//alert("Item details not found,Please select an item");
		return false;
	}

}

function pageResetMethod(mode)
{
	if(mode=='1')
	{
		  
		   document.forms[0].reset();		  
	         
	}
	if(mode=='2')
	{	
						
		var len = document.getElementsByName("strReplacedQty").length;
		
		for(var j=0;j<len;j++)
		{
			document.getElementsByName("strReplacedQty")[j].disabled=false;
		}
			
		document.forms[0].strQtySchHidValue.value = '0'; 
		document.forms[0].reset(); 
	}     
	if(mode=='3')
	{			           
	    document.forms[0].reset();     
	} 
}

function validateQty(obj,index)
{     
   var accQty  = parseInt(document.getElementById("strAcceptedQty"+index).value);
   var avlQty = parseInt(document.getElementById("strAvlQty"+index).value);
   var qtySchHidVal = document.getElementById("strQtySchHidValue"+index.split('-')[0]).value;
   //alert("qtySchHidVal: "+qtySchHidVal);
  // alert("index: "+index);
   
   var replacedQty =  parseInt(obj.value);
   
   //alert("accQty: "+accQty);
   //alert("avlQty: "+avlQty);
   //alert("replacedQty: "+replacedQty);
       
   if(replacedQty <= accQty)
   {  
   var strStoreIndex =  index.split('-')[0];
   //alert(strStoreIndex);
  
   		//if(replacedQty >= avlQty)
   		//{
   			if(obj.value!="0" && obj.value!="")
   			{	
		   			var maxSch =  document.getElementById("strPODetailsHidValue"+index.split('-')[0]).value.split("$")[8];
		   			//alert("maxSch "+maxSch);	
		   			var strTemp='';
		   			for(var i=1; i<= parseInt(maxSch); i++)
		   			{
		   				//alert("strReplacedQty "+document.getElementById("strReplacedQty"+strStoreIndex+"-"+i).value);
		   				if(i=='1')
		   				{
		   					if(document.getElementById("strReplacedQty"+strStoreIndex+"-"+i))
		   						strTemp = strTemp + document.getElementById("strReplacedQty"+strStoreIndex+"-"+i).value+"^"+i;
		   				}		   				 	
		   				 else
		   				 {
		   				 	if(document.getElementById("strReplacedQty"+strStoreIndex+"-"+i))
		   				 	strTemp = strTemp +"#"+ document.getElementById("strReplacedQty"+strStoreIndex+"-"+i).value+"^"+i;
		   				 }
		   				  	
	   			     }	
				    //alert("strTemp"+strTemp);
				    document.getElementById("strQtySchHidValue"+index.split('-')[0]).value = strTemp;
				        		
		   				
		   			//alert("qtySchHidVal : "+document.getElementById("strQtySchHidValue"+index.split('-')[0]).value);
		   				//obj.disabled = true;
	   			
   				
   			}   			
   			return true;
   		/*}
   		else
   		{
   			alert("Replaced Qty can not be less than Available Qty");
   			obj.value = "0";
   			return false;
   		}*/
   }
   else
   {
   		alert("Replaced Qty can not be greater than Accepted Qty");
   		obj.value = "0";
   		return false;
   }    
}

function showPendingOrderDtls(divId){  
	document.getElementById(divId).style.display='block';
	document.getElementById(divId+'MinusId').style.display='block'; 
	document.getElementById(divId+'PlusId').style.display='none';	
}

function hidePendingOrderDtls(divId){
	document.getElementById(divId).style.display='none';
	document.getElementById(divId+'MinusId').style.display='none';
	document.getElementById(divId+'PlusId').style.display='block'; 
} 
function getDrugNameSelected(itemId)
{
	var flag = 0;
	var sel = document.forms[0].strItemCode;	
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

function calRate(obj,i)
{
	var expiryDrugObj = document.getElementsByName("strExpiryDrugs");
	 //for(var i=0;i<expiryDrugObj.length;i++)
	  // {
	   	 // expiryDrugObj[i].checked = false;
		 //alert(expiryDrugObj[i].value);
		 
		 expiryDrugObj[i].value = expiryDrugObj[i].value +"^"+obj.value;
		// alert(expiryDrugObj[i].value);
	  // }
}
	  	  