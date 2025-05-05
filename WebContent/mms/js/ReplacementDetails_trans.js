var gblPendingDispDivFlag ="0";
  


function transferToViewPage()
{
	
	if (document.getElementsByName("strViewChk")[0].checked) 
	{
		document.forms[0].hmode.value = "VIEWPAGE";
		document.forms[0].submit();
	}
	else
	{
		document.forms[0].hmode.value = "INITVAL";		
		document.forms[0].submit();
	}
}

function cancelPage() {
	document.forms[0].hmode.value = "CANCELPAGE";
	showMenuFrame();
	document.forms[0].submit();
}

function clearPage() 
{
	var mode = "INITVAL";
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();
}

function searchTransferDetails() {

	var hisValidator = new HISValidator("excessStockDetailTransFB");

	hisValidator.addValidation("strStoreId", "dontselect=0", "Please Select Store Name ");
	hisValidator.addValidation("strFromDate", "req", "Please Select From Date");
	hisValidator.addValidation("strToDate", "req", "Please Select To Date");

	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();


//	document.forms[0].strId.value = document.forms[0].strStoreId.value;
//	document.forms[0].itemCategory.value = document.forms[0].strOrderNo.value;

	if(retVal) 
	{
		
		var url = "ReplacementOrderTransCNT.cnt?hmode=SEARCHTRANSFERDETAILS&transferStoreId="+ document.forms[0].strStoreId.value
			+"&fromDate="+ document.forms[0].strFromDate.value+"&toDate="+ document.forms[0].strToDate.value;

		ajaxFunction(url, "2");

	}
	else 
	{
		return false;
	}

}
function clickBatchChkBox(index)
{
		if(document.getElementById("batchCheckbox"+index).checked==true)
		{
			document.getElementById("strPKey"+index).disabled=false;	
			document.getElementById("strExcessQty"+index).disabled=false;	
			document.getElementById("strOldStockStatus"+index).disabled=false;		
					
		}
		else
		{
			document.getElementById("strPKey"+index).disabled=true;		
			document.getElementById("strExcessQty"+index).disabled=true;
			document.getElementById("strOldStockStatus"+index).disabled=true;	
				
		}	
}
function validate()
{
	var hisValidator = new HISValidator("replacementOrderTransFB");
	hisValidator.addValidation("strStoreId",            "dontselect=0", "Please Select Store Name ");
	hisValidator.addValidation("strReplacementType",    "dontselect=0", "Please Select Replacement Type");
	
	hisValidator.addValidation("strSupplierId",        "dontselect=0", "Please Select Supplier ");
	hisValidator.addValidation("strPONo",              "dontselect=0", "Please Select PO Number");
	
	hisValidator.addValidation("strApprovedBy",          "dontselect=0", "Please Select Verifiy By ");
	hisValidator.addValidation("strApprovalDate",        "req","Verify Date is a Mandatory Field");
    hisValidator.addValidation("strEmployeeName", "dontselect=0", "Please Select Created By Name"); 	
	   
	if( document.forms[0].strApprovalDate.value != '' && document.forms[0].strApprovalDate.value!='' )
	{
		hisValidator.addValidation("strApprovalDate", "dtltet="+document.forms[0].strCrtDate.value,"Verify Date should be Less than or equal to Current Date");
	}		
	if(document.forms[0].strReplacementType.value =="3")
	{
	  hisValidator.addValidation("strAprovedRemarks", "req", "Approved Remarks is a mandatory field");
	  hisValidator.addValidation("strAprovedRemarks","maxlen=100", "Approved Remarks should have less than or equal to 100 Characters" );
	}
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

	if(retVal) 
	{	    
		var replacementTypeName = document.forms[0].strReplacementType[document.forms[0].strReplacementType.selectedIndex].text;	
		var supplierName        = document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].text;	
		var disPoNo             = document.forms[0].strPONo[document.forms[0].strPONo.selectedIndex].text;	
		var disPoNo2            = document.forms[0].strPONo[document.forms[0].strPONo.selectedIndex].value.split("^");
		                          // PO Prefix ^ Generated PO No ^ PO Generation Date ^ PO Type e.g Cenetral Purchase 
		
		if(confirm("You Are Going To Generate Replacement Order No with [ "+replacementTypeName+" ] Replacement Type \n\n associated with Supplier "+supplierName+"  \n\n & "+disPoNo2[3]+" PO No :: "+disPoNo+" / "+ disPoNo2[2]+" "))
		{
		   		
					if(confirm("Are You Sure ?"))
					{						
						document.forms[0].hmode.value = "INSERT";
						document.forms[0].savedPONo.value = document.forms[0].strPONo[document.forms[0].strPONo.selectedIndex].value.split("^")[1];	
						//alert(document.forms[0].savedPONo.value);
						document.forms[0].strSaveFlag.value = 1;
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


function showOrHideStockDetails(thisImg,mode)
{		  
 	if (thisImg == null) 
 	{
		alert("Cannot find this image object.");
	}
	if (thisImg.title == "Show") 
	{
		// Change Image Attribute
		thisImg.src = "../../hisglobal/images/plus.gif";
		thisImg.title = "Hide";
		document.getElementById("dispPendingOrderDtls").style.display="none";
						
	}
	else
	{  
		thisImg.src = "../../hisglobal/images/minus.gif";
		thisImg.title = "Show";	
		
		if(parseInt(gblPendingDispDivFlag)>0)
		{
			//alert("NA");
			document.getElementById("dispPendingOrderDtls").style.display="block";
		}
		else
		{
			//alert("FN");
			gblPendingDispDivFlag="1";	   
			getPendingOrderDtl(1);
				 
			
		}
			
			
        
	} 	 
  	   		
 } 
function getPendingOrderDtl(mode) 
{
	strStoreId = document.forms[0].strStoreId.value;
	
	if (strStoreId != null && strStoreId != "0") 
	{
		if(mode =='1')
		{
		     document.getElementById("errMsg").innerHTML="";
			 document.getElementById("warningMsg").innerHTML="";
			 document.getElementById("normalMsg").innerHTML="";
		
		     if(document.forms[0].strStoreId.value.split("^")[1]=='1')
			 {
			   document.getElementById("errMsg").innerHTML="Physical Stock Verification for [ "+document.forms[0].strStoreId.options[document.forms[0].strStoreId.selectedIndex].text+" ] is Under Process , No Activity will be allowed till Verification Process is completed";
		       var objVal = document.getElementById("dispPendingOrderDtls");		
		       objVal.innerHTML = "";  
			 }				 	    
		     var url = "ReplacementOrderTransCNT.cnt?hmode=getGlobalProcedure&strReplacementType="+ document.forms[0].strReplacementType.value+"&poStrId="+ document.forms[0].strStoreId.value+"&mode=1&poNo=0&replaceOrderNo=0&suppId=0&brandId=0&batchNo=0";
		     ajaxFunction(url, "1"); 
		    
		}
		
	}
	 else 
	{
		alert("Please Select Store Name!!!");
		return false;
	}
}
function resetHLP()
{
		var objVal = document.getElementById("dispPendingOrderDtls");			
			objVal.innerHTML =  "" ;
			 document.getElementById("errMsg").innerHTML="";
			 document.getElementById("warningMsg").innerHTML="";
			 document.getElementById("normalMsg").innerHTML="";
		document.getElementById("poTypeDiv").innerHTML = "----";
		document.getElementById("poDateDiv").innerHTML = "----";
		document.getElementById("imgStockDetails").src = "../../hisglobal/images/plus.gif";
		document.getElementById("imgStockDetails").title = "Hide";
		document.getElementById("dispPendingOrderDtls").innerHTML="";
		document.getElementById("dispPendingOrderDtls").style.display="none";
		document.getElementById("poDrugBatchDivId").style.display="none";
		gblPendingDispDivFlag="0";	   
		setActionType();
} 
function getSupplierCombo()
{
		var url = "ReplacementOrderTransCNT.cnt?hmode=getGlobalProcedure&strReplacementType="+ document.forms[0].strReplacementType.value+"&poStrId="+ document.forms[0].strStoreId.value+"&mode=3&poNo=0&replaceOrderNo=0&suppId=0&brandId=0&batchNo=0";
		ajaxFunction(url, "4");  // Get Supplier Combo
	    
}
function getPONoCombo()
{
	    if (document.forms[0].strSupplierId.value != "0") 
	    {
			var url = "ReplacementOrderTransCNT.cnt?hmode=getGlobalProcedure&strReplacementType="+ document.forms[0].strReplacementType.value+"&poStrId="+ document.forms[0].strStoreId.value+"&mode=4&poNo=0&replaceOrderNo=0&suppId="+document.forms[0].strSupplierId.value+"&brandId=0&batchNo=0";
			
			ajaxFunction(url, "5");  // Get PO Combo
	    }
	    else
	    {
	    	alert("Please Select Supplier Name!!!");
		    return false;
	    }
	    
}
function stockUpdate(mode,index)
{
	 	if(mode=='0')
	 	{
	 		alert("Activity Not Allowed!!!");
	 		return false;
	 	}
	 	var strRepOrderNo = document.getElementById("strPKey"+index).value.split("^")[2];
	    // HSTNUM_PO_STORE_ID || ''^'' || HSTNUM_PO_NO || ''^'' || HSTNUM_REPLACE_ORDER_NO
 	    var       strPKey = document.getElementById("strPKey"+index).value; 	    
 	    var    strRepType = document.getElementById("strRepType"+index).value;
 	    
 	    var res=prompt(" You are going Cancel Pending Receipt Detail(s) with "+strRepType+" Action Type and Order No :: "+strRepOrderNo+" Please enter Remarks for Cancelation!","");
		if(res!="")
		{
			flag=confirm("Are you sure to cancel");
			if(flag)
			{
				 var url = "ReplacementOrderTransCNT.cnt?hmode=getGlobalProcedure&strReplacementType="+ document.forms[0].strReplacementType.value+"&poStrId="+ document.forms[0].strStoreId.value+"&mode=100&poNo=0&replaceOrderNo=0" +
	                       "&suppId="+document.forms[0].strSupplierId.value+"&brandId=0&batchNo=0" +
	                       "&strPKey="+strPKey+"&strCancelRemarks="+res+"&verifyBy="+document.forms[0].strApprovedBy.value+
	                       "&verifyDate="+document.forms[0].strApprovalDate.value;
	                       ajaxFunction(url, "6");  // Record Cancel	
			}
		}
		else
		{
			return false;
		}   
    
}


function setActionType()
{
	var   strStoreId     = document.forms[0].strStoreId.value;
	if(document.forms[0].strReplacementType.value =="3")
	{
		document.getElementById("mandatoryDiv").innerHTML="<font color='red'>*</font>Remarks";
	}
	else
	{
		document.getElementById("mandatoryDiv").innerHTML="Remarks";
	}
	if (strStoreId != "0") 
	{
	    
            var replacementTypeName = document.forms[0].strReplacementType[document.forms[0].strReplacementType.selectedIndex].text;	
		    document.getElementById("replacementType").innerHTML = replacementTypeName;
		    
			var url = "ReplacementOrderTransCNT.cnt?hmode=getGlobalProcedure&strReplacementType="+ document.forms[0].strReplacementType.value+"&poStrId="+ document.forms[0].strStoreId.value+"&mode=88&poNo=0&replaceOrderNo=0&suppId=0&brandId=0&batchNo=0";
			ajaxFunction(url, "3");  // Get Supplier Combo			    
					
		
    }
    
    else
    {
    	alert("Please Select Store Name!!!");
	    return false;
    }

	   
}

function openPopUp(obj,index) // Partial Receipt Pop-Up 
{
	     var repOrderNo = document.getElementById("strPKey"+index).value.split("^")[2];
	    // HSTNUM_PO_STORE_ID || ''^'' || HSTNUM_PO_NO || ''^'' || HSTNUM_REPLACE_ORDER_NO
	    var       poNo = document.getElementById("strPKey"+index).value.split("^")[1];
	    var url = "ReplacementOrderTransCNT.cnt?hmode=getGlobalProcedure&strReplacementType="+ document.forms[0].strReplacementType.value+"&poStrId="+ document.forms[0].strStoreId.value+"&mode=2&poNo="+poNo+"&replaceOrderNo="+repOrderNo+"&suppId=0&brandId=0&batchNo=0" +
	    		  "&supplierName="+document.getElementById("strSupplierName"+index).value+"&strPONumber="+document.getElementById("strPONumber"+index).value+"&strRepType="+document.getElementById("strRepType"+index).value;
		ajaxFunction(url, "7");  
	
} 
function getPODrugList() // Get PO Item Name
{
	var   strStoreId     = document.forms[0].strStoreId.value;
	var   supplierId     = document.forms[0].strSupplierId.value; 
	var         poNo     = document.forms[0].strPONo.value;
	var     replType     = document.forms[0].strReplacementType.value; 
	
  // DISTINCT NVL(HSTSTR_PO_REF_NO,''-'') || ''^'' || HSTNUM_PO_NO || ''^'' || TO_CHAR(HSTDT_PO_DATE,''DD-Mon-YYYY'') || ''^'' || 
  // DECODE(SUBSTR(HSTNUM_PO_NO,3,2),''21'',''Local Purchase'',''Central Purchase'') AS PO_NO
	if (poNo != "0" && strStoreId != "0") 
	{			
		if(replType == "3")  // Get Item List + Item Name 
		{			  
			  document.getElementById("poDrugBatchDivId").style.display="block";	
			  document.getElementById("poTypeDiv").innerHTML = poNo.split("^")[3];
			  document.getElementById("poDateDiv").innerHTML = poNo.split("^")[2];
			   document.getElementById("poProgName").innerHTML =poNo.split("^")[4];
		  document.getElementById("poFSName").innerHTML = poNo.split("^")[5];
			  var url = "ReplacementOrderTransCNT.cnt?hmode=getGlobalProcedure&strReplacementType="+ document.forms[0].strReplacementType.value+
			  "&poStrId="+ document.forms[0].strStoreId.value+"&mode=99&poNo="+poNo.split("^")[1]+"&replaceOrderNo=0&suppId="+supplierId+"&brandId=0&batchNo=0";
			 
			  ajaxFunction(url, "8");
		}
		else
		{			
			 document.getElementById("poDrugBatchDivId").style.display="none";
			 document.getElementById("poTypeDiv").innerHTML = poNo.split("^")[3];
		     document.getElementById("poDateDiv").innerHTML = poNo.split("^")[2];
		      document.getElementById("poProgName").innerHTML =poNo.split("^")[4];
		  document.getElementById("poFSName").innerHTML = poNo.split("^")[5];
		     var url = "ReplacementOrderTransCNT.cnt?hmode=getGlobalProcedure&strReplacementType="+ document.forms[0].strReplacementType.value+
		     "&poStrId="+ document.forms[0].strStoreId.value+"&mode=7&poNo="+poNo.split("^")[1]+"&replaceOrderNo=0&suppId="+supplierId+"&brandId=0&batchNo=0";
		     
		     ajaxFunction(url, "10");	
		} 			
		
	}
	 else 
	{
		if (poNo=="0")
		{
			alert("Please Select PO No!!!");
			return false;
		}
		else
		{
			alert("Please Select Store Name!!!");
			return false;
		}
		 document.getElementById("errMsg").innerHTML="";
			 document.getElementById("warningMsg").innerHTML="";
			 document.getElementById("normalMsg").innerHTML="";
		document.getElementById("poTypeDiv").innerHTML = "----";
		document.getElementById("poDateDiv").innerHTML = "----";
		document.getElementById("poProgName").innerHTML = "----";
		document.getElementById("poFSName").innerHTML = "----";
		document.getElementById("imgStockDetails").src = "../../hisglobal/images/plus.gif";
		document.getElementById("imgStockDetails").title = "Hide";
		document.getElementById("dispPendingOrderDtls").innerHTML="";
		document.getElementById("dispPendingOrderDtls").style.display="none";
		document.getElementById("poDrugBatchDivId").style.display="none";
	}
}
function getPODrugBatchList() // Get PO Item Batch Combo  Based on Item Name
{
	var   strStoreId     = document.forms[0].strStoreId.value;
	var   supplierId     = document.forms[0].strSupplierId.value; 
	var         poNo     = document.forms[0].strPONo.value;
	
  // DISTINCT NVL(HSTSTR_PO_REF_NO,''-'') || ''^'' || HSTNUM_PO_NO || ''^'' || TO_CHAR(HSTDT_PO_DATE,''DD-Mon-YYYY'') || ''^'' || 
  // DECODE(SUBSTR(HSTNUM_PO_NO,3,2),''21'',''Local Purchase'',''Central Purchase'') AS PO_NO
	if (poNo != "0" && strStoreId != "0") 
	{		
		  document.getElementById("poTypeDiv").innerHTML = poNo.split("^")[3];
		  document.getElementById("poDateDiv").innerHTML = poNo.split("^")[2];
		   document.getElementById("poProgName").innerHTML =poNo.split("^")[4];
		  document.getElementById("poFSName").innerHTML = poNo.split("^")[5];
		  var url = "ReplacementOrderTransCNT.cnt?hmode=getGlobalProcedure&strReplacementType="+ document.forms[0].strReplacementType.value+
		  "&poStrId="+ document.forms[0].strStoreId.value+"&mode=6&poNo="+poNo.split("^")[1]+"&replaceOrderNo=0&suppId="+supplierId+"&brandId="+document.forms[0].strItemBrandId.value+"&batchNo=0";
		  //alert(url);
		  ajaxFunction(url, "9");			
		
	}
	 else 
	{
		if (poNo=="0")
		{
			alert("Please Select PO No!!!");
			return false;
		}
		else
		{
			alert("Please Select Store Name!!!");
			return false;
		}
		 document.getElementById("errMsg").innerHTML="";
			 document.getElementById("warningMsg").innerHTML="";
			 document.getElementById("normalMsg").innerHTML="";
		document.getElementById("poTypeDiv").innerHTML = "----";
		document.getElementById("poDateDiv").innerHTML = "----";
		document.getElementById("poProgName").innerHTML = "----";
		document.getElementById("poFSName").innerHTML = "----";
		document.getElementById("imgStockDetails").src = "../../hisglobal/images/plus.gif";
		document.getElementById("imgStockDetails").title = "Hide";
		document.getElementById("dispPendingOrderDtls").innerHTML="";
		document.getElementById("dispPendingOrderDtls").style.display="none";
		document.getElementById("poDrugBatchDivId").style.display="none";
	}
}
function getPODrugScheduleList() // Get PO Item List Item Batch Wise
{
	var   strStoreId     = document.forms[0].strStoreId.value;
	var   supplierId     = document.forms[0].strSupplierId.value; 
	var         poNo     = document.forms[0].strPONo.value;
	
  // DISTINCT NVL(HSTSTR_PO_REF_NO,''-'') || ''^'' || HSTNUM_PO_NO || ''^'' || TO_CHAR(HSTDT_PO_DATE,''DD-Mon-YYYY'') || ''^'' || 
  // DECODE(SUBSTR(HSTNUM_PO_NO,3,2),''21'',''Local Purchase'',''Central Purchase'')||'^'|| Prog Name ||'^'|| Funding Src Name AS PO_NO
	if (poNo != "0" && strStoreId != "0") 
	{		
		  document.getElementById("poTypeDiv").innerHTML = poNo.split("^")[3];
		  document.getElementById("poDateDiv").innerHTML = poNo.split("^")[2];
		  document.getElementById("poProgName").innerHTML =poNo.split("^")[4];
		  document.getElementById("poFSName").innerHTML = poNo.split("^")[5];
		  var url = "ReplacementOrderTransCNT.cnt?hmode=getGlobalProcedure&strReplacementType="+ document.forms[0].strReplacementType.value+
		  "&poStrId="+ document.forms[0].strStoreId.value+"&mode=7&poNo="+poNo.split("^")[1]+"&replaceOrderNo=0&suppId="+supplierId+"&brandId="+document.forms[0].strItemBrandId.value+"&batchNo="+document.forms[0].strBatchNo.value;
		  
		  ajaxFunction(url, "10");			
		
	}
	 else 
	{
		if (poNo=="0")
		{
			alert("Please Select PO No!!!");
			return false;
		}
		else
		{
			alert("Please Select Store Name!!!");
			return false;
		}
		document.getElementById("poTypeDiv").innerHTML = "----";
		document.getElementById("poDateDiv").innerHTML = "----";
		document.getElementById("poProgName").innerHTML = "----";
		document.getElementById("poFSName").innerHTML = "----";
		document.getElementById("imgStockDetails").src = "../../hisglobal/images/plus.gif";
		document.getElementById("imgStockDetails").title = "Hide";
		document.getElementById("dispPendingOrderDtls").innerHTML="";
		document.getElementById("dispPendingOrderDtls").style.display="none";
		document.getElementById("poDrugBatchDivId").style.display="none";
	}
}


function getAjaxResponse(res, mode) 
{
	if (mode == "1")
	 {
		    //alert(res);
			var objVal = document.getElementById("dispPendingOrderDtls");			
			objVal.innerHTML =  res.split("$$")[0] ;
	      
	      
	        var divHeight=200;
			var initialHeight=716;
			var heightPer = (divHeight*100)/initialHeight; 
			var newHeight = parseInt((window.innerHeight * heightPer)/100,10);			     
		     fixedHeaderTableTrans("dispPendingOrderDtls",newHeight);
		  
	}

	if (mode == "2") {

		var objVal = document.getElementById("excessStockItemDtls");		
		objVal.innerHTML = res;
		
		var divHeight=200;
		var initialHeight=716;
		var heightPer = (divHeight*100)/initialHeight; 
		var newHeight = parseInt((window.innerHeight * heightPer)/100,10);	
		  
		fixedHeaderTableTransCustomize("excessStockItemDtls",newHeight, "wrapper1","tableHeaderId1");
		 

	}
	
	if (mode == "3") // Get Supplier Combo And Reset All Value
	{
		gblPendingDispDivFlag="0";	   
		
		 document.getElementById("errMsg").innerHTML="";
			 document.getElementById("warningMsg").innerHTML="";
			 document.getElementById("normalMsg").innerHTML="";
		document.getElementById("poTypeDiv").innerHTML = "----";
		document.getElementById("poDateDiv").innerHTML = "----";
		document.getElementById("poProgName").innerHTML = "----";
		document.getElementById("poFSName").innerHTML = "----";
		document.getElementById("imgStockDetails").src = "../../hisglobal/images/plus.gif";
		document.getElementById("imgStockDetails").title = "Hide";
		document.getElementById("dispPendingOrderDtls").innerHTML="";
		document.getElementById("dispPendingOrderDtls").style.display="none";
		document.getElementById("poDrugBatchDivId").style.display="none";
		
		var itemStockObj = document.getElementById("dispPODtls");      
		itemStockObj.innerHTML = "";
     	itemStockObj.style.display="none";
        
        
       	var objVal = document.getElementById("supplierCombo");
        objVal.innerHTML = "<select name = 'strSupplierId' class='comboMax' onchange='getPONoCombo();' >" + res.split("$$")[0] + "</select>";
        
        var objVal = document.getElementById("poCombo");
        objVal.innerHTML = "<select name = 'strPONo' class='comboMax' onchange='getPODrugList();'>" + res.split("$$")[1] + "</select>";
       

	 }
	 if(mode=="4") // Supplier Combo
     {
        var objVal = document.getElementById("supplierCombo");
        objVal.innerHTML = "<select name = 'strSupplierId' class='comboMax' onchange='getPONoCombo();' >" + res + "</select>";
       
     }
     if(mode=="5") // PO No Combo
     {
     	
        var objVal = document.getElementById("poCombo");
        objVal.innerHTML = "<select name = 'strPONo' class='comboMax' onchange='getPODrugList();'>" + res + "</select>";
        
        var itemStockObj = document.getElementById("dispPODtls");      
		itemStockObj.innerHTML = "";
		document.getElementById("poDrugBatchDivId").style.display="none";
       
     }
     if(mode=="6") // Record Cancel
     {				          
      
	   document.getElementById("msgDIV").innerHTML="";	   
	   document.getElementById("msgDIV").innerHTML=res;
	   //document.forms[0].normalMsg.value=res;
	   document.getElementById("normalMsg").style.display="block";
	   getPendingOrderDtl(1);
     }
     if(mode=="7") // Open Pop-Up
     {
         var itemStockObj = document.getElementById("issueDtlsDivId");      
		 itemStockObj.innerHTML = res;				
		 display_popup('toPopup');	
		 //scrollableVoucher("toPopup", "mainTableRptId2" ,"voucherDivId",350);	
       
     }
     if(mode=="8") // PO Item List + PO Item Name Combo 
     {	     	
     	var itemStockObj = document.getElementById("dispPODtls");      
		itemStockObj.innerHTML = res.split("$$")[0];
     	itemStockObj.style.display="block";
     	
     	var divHeight=200;
		var initialHeight=716;
		var heightPer = (divHeight*100)/initialHeight; 
		var newHeight = parseInt((window.innerHeight * heightPer)/100,10);	
		
     	fixedHeaderTableTransCustomize("dispPODtls",newHeight, "wrapper1","tableHeaderId1");
     	
		var objVal = document.getElementById("drugCombo");
        objVal.innerHTML = "<select name = 'strItemBrandId' class='comboMax' onchange='getPODrugBatchList();'>" + res.split("$$")[1] + "</select>";  
       
     }
     if(mode=="9") // PO Item Batch List
     {	
		var itemStockObj = document.getElementById("dispPODtls");      
		itemStockObj.innerHTML = res.split("$$")[0];
		itemStockObj.style.display="block";
		
		var divHeight=200;
		var initialHeight=716;
		var heightPer = (divHeight*100)/initialHeight; 
		var newHeight = parseInt((window.innerHeight * heightPer)/100,10);	
		
     	fixedHeaderTableTransCustomize("dispPODtls",newHeight, "wrapper1","tableHeaderId1");
		
		var objVal = document.getElementById("drugBatchCombo");
        objVal.innerHTML = "<select name = 'strBatchNo'     class='comboNormal' onchange='getPODrugScheduleList();'>" + res.split("$$")[1] + "</select>";   	   
       
     }
     if(mode=="10") // PO Item Batch List based on Batch Selection
     {	
		var itemStockObj = document.getElementById("dispPODtls");      
		itemStockObj.innerHTML = res;
		itemStockObj.style.display="block";
		
		var divHeight=200;
		var initialHeight=716;
		var heightPer = (divHeight*100)/initialHeight; 
		var newHeight = parseInt((window.innerHeight * heightPer)/100,10);	
		
     	fixedHeaderTableTransCustomize("dispPODtls",newHeight, "wrapper1","tableHeaderId1");
		
     }
     
     if (mode == "11")
	 {
			var objVal = document.getElementById("viewreplacementOrderDtls");			
			objVal.innerHTML =  res.split("$$")[0] ;
	      
	      
	        var divHeight=200;
			var initialHeight=716;
			var heightPer = (divHeight*100)/initialHeight; 
			var newHeight = parseInt((window.innerHeight * heightPer)/100,10);			     
		     fixedHeaderTableTrans("viewreplacementOrderDtls",newHeight);
		  
	}
     
     if(mode== "12")	
		{			
			var itemStockObj = document.getElementById("issueDtlsDivId");	
			
		//	alert(res);
			itemStockObj.innerHTML = res;
			
						
			
			
			display_popup('toPopup');	
			//scrollableVoucher("toPopup", "mainTableRptId2" ,"voucherDivId",350);
		}
     
     if(mode== "13")	
		{			
			var itemStockObj = document.getElementById("issueDtlsDivId");	
			
		//	alert(res);
			itemStockObj.innerHTML = res;
			
						
			
			document.forms[0].strSaveFlag.value ="0";
			display_popup('toPopup');	
			//scrollableVoucher("toPopup", "mainTableRptId2" ,"voucherDivId",350);
		}
	
}

function viewOnLoad()
{
    	var divHeight=200;
		var initialHeight=716;
		var heightPer = (divHeight*100)/initialHeight; 
		var newHeight = parseInt((window.innerHeight * heightPer)/100,10);		
	    fixedHeaderTableTrans("viewExcessStockDtlsDivId",newHeight);
	    
}
function fixedHeaderTableTransCustomize(tableContainerDiv, tableHeight, wrapperDivId, tableHeaderId)
 { 	
 	
 	document.getElementById(tableContainerDiv).style.display = 'none';
 	var newTableHtml=""; 
 	var mainDivRptObj = "";	
 	
 
 	mainDivRptObj = document.getElementById("wrapper1");
 	
 //	alert(document.getElementById("wrapper").innerHTML);	 	
	
	newTableHtml = '<div id="content" style="width:100%;border-bottom: 1px solid #BBBBBB;">';
	newTableHtml+= '<div id="boundary">'; 
	newTableHtml+= '<table id="headerTableTrans" cellpadding="3" cellspacing="0" border="0" style="width:100%;text-align:left;table-layout:fixed;border-collapse:collapse;">';
	newTableHtml+= '<thead style="display:table-header-group;"><tr>';
	
	newTableHtml += document.getElementById("tableHeaderId1").innerHTML;		
	  
	newTableHtml+='</tr></thead></table></div>';
	
	if(tableHeight == "0")
		newTableHtml+= '<div id="boxHeaderNoScroll">';
	else
	{
		if(tableHeight)
			newTableHtml+= '<div id="boxHeaderFixed" style="height:'+tableHeight+'px">';
		else
			newTableHtml+= '<div id="boxHeaderFixed2">';
	}
		
		
	newTableHtml+= '<table id="tbl-content" cellpadding="3" cellspacing="0" border="0" style="width:100%;table-layout:fixed;background:#fff;border-collapse:collapse;">';
	newTableHtml+= document.getElementById('mainTableRptId1').innerHTML;
	newTableHtml+= '</table></div></div></div>';	
	mainDivRptObj.innerHTML = newTableHtml;
			
	if(tableHeaderId)
		document.getElementById(tableHeaderId).style.display="none";
	else
		document.getElementById("tableHeaderId").style.display="none";
		
	document.getElementById(tableContainerDiv).style.display = 'block';	
	if(tableHeight)
	{
		if(tableHeight != "0")
		{
			if(wrapperDivId)
			{
				if($("#"+wrapperDivId+" #tbl-content").height() > tableHeight)
					$( "#"+wrapperDivId+" #headerTableTrans th:last" ).attr("id", "right-border");	
			}
			else
			{
				if($("#tbl-content").height() > tableHeight)
					$( "#headerTableTrans th:last" ).attr("id", "right-border");	
			}
				
		}
	}
	else
	{
		if(tableHeight != "0")
		{
			if($('#tbl-content').height() > 180)
				$( "#wrapper #headerTableTrans th:last" ).attr("id", "right-border");
		}		
	}				
	 
 }

function hideIssueDetails(divId) {
	hide_popup_menu(divId);
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

	var hisValidator = new HISValidator("excessStockDetailTransFB");

	hisValidator.addValidation("strStoreId", "dontselect=0", "Please Select Store Name ");
	hisValidator.addValidation("strOrderNo", "dontselect=0", "Please Select Transfer Request No.");

	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

	document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	document.forms[0].orderNO.value = document.forms[0].strOrderNo[document.forms[0].strOrderNo.selectedIndex].text;

//	document.forms[0].strId.value = document.forms[0].strStoreId.value;
//	document.forms[0].itemCategory.value = document.forms[0].strOrderNo.value;

	if (retVal) {
		document.forms[0].hmode.value = "INITVALGO";
		document.forms[0].submit();

	} else {
		return false;
	}
}


 // function to show report after save data
/*function getReport()
{
	
	//costReq();
	var transferNo    = document.forms[0].strTmpTransferNo.value;
	var storeId       = document.forms[0].strTmpStoreNo.value;
//	var transferDate  = document.forms[0].strTmpTransferDate.value;    
   
 //alert("Transfer No-->>"+transferNo);
 if(parseInt(transferNo)!= 0)
 {
   //alert("transferNo"+transferNo);
   var mode="transferDtl";
 
   var url="ReplacementOrderTransCNT.cnt?hmode="+mode
   			+"&transferNo="+ transferNo+"&storeId="+storeId;
   
   ajaxFunction(url,"4");
 }  	
    	
	
}*/

function getReport()
{
	
	//alert("po "+document.forms[0].savedPONo.value);
		//var invoiceid    = document.forms[0].strInvNo.value;		
		var saveFlag    = document.forms[0].strSaveFlag.value;
		var pono = document.forms[0].savedPONo.value;
	//	alert("save "+saveFlag);
		//var pono = document.forms[0].strGenPoNo.value.split("^", 1);;
	//	alert(invoiceid+"<---->"+saveFlg);	

		if(pono!="0" && saveFlag=="1")
		{
			var mode = "GETVOUCHERAFTERSAVE";
	          var url = "ReplacementOrderTransCNT.cnt?hmode="+mode+"&saveFlag="+saveFlag+"&pono="+pono;
	      //   alert(url);
	         ajaxFunction(url,"13");
		}
		else
		{
			return false;
		}
}

function printVoucher()
{
	var count =0;
	var len = document.getElementsByName("transferRadioButton").length;
	
	for(var i=0;i<len;i++)
	{
		if(document.getElementsByName("transferRadioButton")[i].checked==true)
		{
			count++;	
			break;		
		}
	}	
		if(count==0)
		{
			
			alert("Please Select Atleast One of the Transfer Details");
			return false;
					 	
		}
		else
		{
					var transferNo    = document.getElementsByName("tempTransferNo")[i].value;
					//var storeId       = document.getElementsByName("strToStoreId")[i].value;
					var storeId       = document.getElementsByName("strStoreId")[0].value;
					var transferDate  = document.getElementsByName("strTransferDate")[i].value.split(" ")[0];    
					var transferDWH  = document.getElementsByName("strTransferTo")[i].value;
				 				    
				 if(transferNo!='0')
				 { 
				   var mode="transferDtl";
				   var url="ReplacementOrderTransCNT.cnt?hmode="+mode+"&transferNo="+ transferNo+"&storeId="+storeId
				   			+"&transferDate="+transferDate+"&dwhName="+transferDWH;
			//alert(url);	   
				   ajaxFunction(url,"4");
				 } 
		}
		
	
	
}




function totalCost()
{	   
       	    var qtyObj    = document.getElementsByName("strTransferQty");
       	    var costObj   = document.getElementsByName("strCost");
       	    var totalQty  = parseInt("0");
			var totalCost = parseFloat("0.00");
			
			if (costObj.length > 0) 
			{
		       
				for ( var i = 0; i <costObj.length; i++)
				{		
					if(qtyObj[i].value.length!='')
					{
					  totalQty  = totalQty + parseInt(qtyObj[i].value);
					}	
					if(costObj[i].value.length!='')
					{					 
					  totalCost = totalCost + parseFloat(costObj[i].value);	
					}	
		 		}
		
			}

	    totalCost = roundValue(totalCost, 2);	    
	    document.getElementsByName("strTotalTransferredQty")[0].value = totalQty;
	    document.getElementsByName("strTotalTransferredCost")[0].value = totalCost;

}	 

function checkAvailQtyTwo(index) 
{      
	        var orderQty    = document.getElementById("strBalanceQty"+index).value;
	        var rateObj 	= document.getElementById("strRatePerUnit"+index).value;
	        var qtyObj  	= document.getElementById("strTransferQty"+index).value;		
		    var avlQtyObj   = document.getElementById("strAvailableQty"+index).value;    					
			var qty    	    = parseFloat(qtyObj);	
			var rate        = parseFloat(rateObj);
			
			if(parseInt(qtyObj,10)>parseInt(avlQtyObj,10))
		    {
		    	alert("Transfer Qty. [ "+qtyObj+" ] Can't be greater than Availabe Qty [ "+avlQtyObj+" ]");
		    	document.getElementById("strTransferQty"+index).value='';
		    	document.getElementById("strTransferQty"+index).focus();
		    }
			
			
			
		    if(parseInt(qtyObj,10)>parseInt(orderQty,10))
		    {
		    	alert("Transfer Qty. [ "+qtyObj+" ] Can't be greater than Balance Qty [ "+orderQty+" ]");
		    	document.getElementById("strTransferQty"+index).value='';
		    	document.getElementById("strTransferQty"+index).focus();
		    }
		    else
		    {
				var total = parseFloat("0.00");
					
				if(isNaN(rate) || rate=="") rate = "0";
				if(isNaN(qty)  || qty=="") qty = "0";
			    if(qty=='0')		
				{
				  
				  total = parseFloat(qty * rate);
				}
				else
				{
				  total = parseFloat(qty * rate);
				} 			
				
				total = roundValue(total, 2)
	            document.getElementById("strCost"+index).value=total;
		    }								
			
			totalCost();
	return true;
}





function  clickTransferDetailsRadioButton()
{
	strId		=	document.getElementsByName("strStoreId")[0].value;	
	
		len = document.getElementsByName("transferRadioButton").length;
	
	for(var i=0;i<len;i++)
	{
		if(document.getElementsByName("transferRadioButton")[i].checked==true)
		{
			transferNo	=	document.getElementsByName("tempTransferNo")[i].value;
			document.getElementsByName("strTransferNo")[0].value = transferNo;
			document.getElementsByName("strTmpTransNo")[0].value = transferNo;
			document.getElementsByName("strTmpStoreNo")[0].value = strId;
			
			//transferNo	=	document.getElementsByName("strTransferNo")[i].value;
			//strId		=	document.getElementsByName("strToStoreId")[i].value;	
			
		}
	}


		var url = "ReplacementOrderTransCNT.cnt?hmode=ITEMDETAILS&transferNo="+ transferNo+"&strId="+ strId;
					
//alert(url);					
		ajaxFunction(url, "3");
	
}

function clickBackButton()
{	
	document.forms[0].hmode.value = "INITVAL";
		document.forms[0].submit();
}

function clearViewPage()
{
	document.forms[0].hmode.value = "VIEWPAGE";
		document.forms[0].submit();
}


function clearDivId()
{
	document.getElementById("searchTransferDtlsDivId").innerHTML='';
	document.getElementById("itemDtlId").innerHTML='';
	document.getElementById("remarksDtlId").style.display='none';
	
}


function cancelTransferRequest()
{
	var count = 0;
	var ackFlg = 0 ;		
				for(var i=0;i<document.getElementsByName("transferRadioButton").length;i++)
				{
					if(document.getElementsByName("transferRadioButton")[i].checked==true)
					{
						if(parseInt(document.getElementsByName("strAckNo")[i].value)>0)
						{
							ackFlg = 1;
						}
						
						document.getElementsByName("strTransferNo")[0]=document.getElementsByName("tempTransferNo")[i];
						
						count++;
						break;			
					}
				}
				
				if(ackFlg==1)
				{
					alert("Fully/Partial Acknowledge In Process /n So No Permission to Delete this Record!!");
					return false;		
				}
				
				if(count==0)
				{
					alert("Please Select Atleast One of the Transfer Detais and then Delete that Record");
					return false;		
				}
	
	var hisValidator = new HISValidator("excessStockDetailTransFB");

	hisValidator.addValidation("strRemarks", "req", "Remarks is a mandatory field");
	hisValidator.addValidation("strRemarks","maxlen=100", "Remarks should have less than or equal to 100 Characters" );

	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();

	if (retVal) 
	{
				
				
					if(confirm("Are You sure you Want to Delete this Record?"))
					{
						document.forms[0].hmode.value = "cancelDrugTransferDtl";
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
		
	//Yash
	function getViewItemDtl() {
		var hisValidator = new HISValidator("replacementOrderTransFB");

		hisValidator.addValidation("strStoreId", "dontselect=0",
				"Please Select Store Name");
		hisValidator.addValidation("strReplacementType", "dontselect=0",
				"Please Select Category ");
		hisValidator.addValidation("strFromDate", "date",
				"From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date",
				"To Date is a mandatory field");
		hisValidator.addValidation("strFromDate", "dtltet="
				+ document.forms[0].strToDate.value,
				"Please Select From Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate", "dtgtet="
				+ document.forms[0].strFromDate.value,
				"Please Select To Date Greater Than Or Equal To From Date");

		var retVal = hisValidator.validate();
		hisValidator.clearAllValidations();
		if (retVal) {

			document.forms[0].strStoreId.disabled = true; 
			document.forms[0].strReplacementType.disabled = true;
			//document.getElementById("strFromDate1").style.display = 'none';
			//document.getElementById("strToDate1").style.display = 'none';

			var temp = document.forms[0].strStoreId.value;
			var temp1 = document.forms[0].strReplacementType.value;
			var mode = "GOVIEWPAGE";
			var url = "ReplacementOrderTransCNT.cnt?hmode=" + mode + "&storeId="
					+ temp + "&ReplacementType=" + temp1
					+ "&fromDate=" + document.forms[0].strFromDate.value
					+ "&ToDate=" + document.forms[0].strToDate.value;
			ajaxFunction(url, "11");
		}

	}
	
	
	var getReportViewNew =function(id,voucherDtlsNewObj)
{ 
	//replacementOrderNo+"^"+poNo+"^"+batchNo+"^"+deliveryLoc+"^"+challanNo;
	var voucherDtlsNew = voucherDtlsNewObj.split('^');	

	var replOrderNo = voucherDtlsNew[0].split('/')[1];
	var pono    = voucherDtlsNew[1];
	var batchNo   = voucherDtlsNew[2];
	var delLoc = voucherDtlsNew[3];
	
		
	var mode = "GETVOUCHER";
    var url = "ReplacementOrderTransCNT.cnt?hmode="+mode+"&orderNo="+replOrderNo+"&poNo="+pono+"&batchNo="+batchNo+"&delLoc="+delLoc;
   //alert(url);
   ajaxFunction(url,"12");
		
};

function generateVoucherPdf(strInvNo) 
{
	document.forms[0].replOrderNo.value = strInvNo;
	generatePdfScrollVoucher("issueDtlsDivId", "mainTableId", "mainTableRptId2", "voucherDivId");
		
}


