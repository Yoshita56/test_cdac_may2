function FuncTick(obj)
{
  if(obj.value == '1')
  {
  	document.getElementById("remarks").innerHTML="Remarks";
  	document.forms[0].strApprovalFlag.value="1";  
    document.forms[0].strApproved.checked = true;
    document.forms[0].strRejected.checked = false;
  }
  else
  {
  	 document.getElementById("remarks").innerHTML="<font color='red'>*</font>Remarks";
  	 document.forms[0].strApprovalFlag.value="2";  
     document.forms[0].strRejected.checked = true;
     document.forms[0].strApproved.checked = false;
  }
  
}

function setApprovedQty()
{
	var approvedQty = document.getElementsByName("strInsSancQty");
	var  hlpSancQty = document.getElementsByName("strHLPSanctionQty");
	if(document.getElementsByName("strRejected")[0].checked)
	{
		for(var i=0;i<approvedQty.length;i++)
		{
			approvedQty[i].value="0";
		}
		
	}
	if(document.getElementsByName("strApproved")[0].checked)
	{
		
		for(var i=0;i<approvedQty.length;i++)
		{			
			
			 approvedQty[i].value = hlpSancQty[i].value;
						
		}
	}
}
function cancelToDesk()
{
  var mode="CANCEL1";
 
  document.forms[0].hmode.value=mode;
  document.forms[0].submit();
}
function initPage1()
{  
	document.forms[0].strRemarks.value="";
}
function calculateHeight()
{		
var tableHeight=100;
if($('#id1').height() > tableHeight)
{
	$("#mainTableDrugFinder").css({"table-layout":"fixed"});
	$("#mainTableDrugFinder th:last" ).attr("id", "right-border");	
	$("#id1").css({"height": "80px","overflow":"auto"});	
}	
}

function clickBatchChkBox(index)
{
		if(document.getElementById("batchCheckbox"+index).checked==true)
		{
			document.getElementById("strVerifyCountedQty"+index).disabled=false;		
			document.getElementById("strMultiExpiryDate"+index).disabled=false;
			document.getElementById("strMultiMfgDate"+index).disabled=false;
			document.getElementById("strMultiSupplierId"+index).disabled=false;
			//document.getElementById("strMultiTenderNo"+index).disabled=false;
			document.getElementById("strMultiRateUnitId"+index).disabled=false;
			document.getElementById("strHiddenValue"+index).disabled=false;
			document.getElementById("strNewItemFlg"+index).disabled=false;
			//document.getElementById("strRateWithBaseValue"+index).disabled=false;
			document.getElementById("strCatcode"+index).disabled=false;
			document.getElementById("strMultiRemarks"+index).disabled=false;
			document.getElementById("strVerifyCountedQty"+index).focus();	
			document.getElementById("strVerifyCountedQty"+index).select();	
			
				
				
		}
		else
		{	  
			 var conf = confirm("Counted Quantity(B) will be Re-Set with Avlaible Quantity(A)");
		     if(conf == true)
		     {
			      var conf1 = confirm("Are you sure !!!");
			      if(conf1 == true)
			      {
			          $("#trId"+index).removeClass("danger");					  
					  document.getElementById("strVerifyCountedQty"+index).disabled=true;		
					  document.getElementById("strVerifyCountedQty"+index).value = document.getElementById("strAvlQty"+index).value;	
					  document.getElementById("varianceCostID"+index).innerHTML = "0";				
					  document.getElementById("varianceQtyID"+index).innerHTML = "0";	
					  document.getElementById("strCatcode"+index).disabled=false;
					  document.getElementById("strVerifyCountedQty"+index).disabled=true;		
					  document.getElementById("strMultiExpiryDate"+index).disabled=true;
					  document.getElementById("strMultiMfgDate"+index).disabled=true;
					  document.getElementById("strMultiSupplierId"+index).disabled=true;
					  //document.getElementById("strMultiTenderNo"+index).disabled=true;
					  document.getElementById("strMultiRateUnitId"+index).disabled=true;
					  document.getElementById("strHiddenValue"+index).disabled=true;
					  document.getElementById("strNewItemFlg"+index).disabled=true;
					  //document.getElementById("strRateWithBaseValue"+index).disabled=true;
					  document.getElementById("strMultiRemarks"+index).disabled=true;
					  
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
}
 function calculateQtyCost(index) 
 {      	
	 		//alert("1");
	    	//var  rateObj        = document.getElementById("strRateWithBaseValue" + index).value;        
			var  varifyQtyObj   = parseInt(document.getElementById("strVerifyCountedQty"+index).value); // B
			var  avlQtyObj      = parseInt(document.getElementById("strAvlQty"+index).value);	 // A
			var  tolranceObj    = document.getElementById("strTolranceLimit"+index).value;	
      					
				
			//var rate   = rateObj;
			var rate   = 0;
		    var qtyDiff     = varifyQtyObj - avlQtyObj;
		    var tolranceQty = parseInt(0)-parseInt(tolranceObj);
		
		    var qty    = qtyDiff;
			var total = parseFloat("0.00");
		
			if(isNaN(rate) || rate=="") rate = "0";
			if(isNaN(qty)  || qty=="") qty = "0";
			if(qty=='0')		
			{
			  qty_base_value = '0';	
			  total = parseFloat(qty *  rate);
			}
			else
			{
			  total = parseFloat(qty *  rate);	
			} 
			
			document.getElementById("varianceCostID"+index).innerHTML = roundValue(total, 2);				
			document.getElementById("varianceQtyID"+index).innerHTML = parseInt(qtyDiff);	
			//alert("Variance Qty-->>"+parseInt(qtyDiff)+"<--Tolrance-->"+parseInt(tolranceQty))			
			if( (parseInt(varifyQtyObj))>0 &&(parseInt(0)-parseInt(qtyDiff)) > (parseInt(tolranceQty)) )
			{  				
				  $("#trId"+index).addClass("danger");				 
			}
			else
			{	
				 $("#trId"+index).removeClass("danger");
			} 
			
							
			
			
			
			
			
	return true;
}

function checkDecimalValue(obj)
{	
	 var rate=obj.value;
	 if(rate != "")
	 {
	 	var checkRate=obj.value.split(".");

		//alert(checkRate.length);
		
		if(checkRate.length > 2)
		{
			alert("Default Rate should be in format 000000000.0000");
			obj.value = "";
			setTimeout(function(){obj.focus();}, 0);									
			return false;
		}
		
		if(checkRate.length > 1)
		{
			if(checkRate[1].length > 4 )
			{
				alert("Please Enter the digits after decimal places Less than Equal to 4 digits !");
				obj.value = checkRate[0]+"."+checkRate[1].substr(0,4);
				return false;
			}
		}		
	 }	
}


function openDivItem(obj,index,mode)
{	
	var lengthItem=document.getElementsByName("strHiddenValue").length;
	for(var i=0;i<parseInt(lengthItem);i++)
	{
		document.getElementById("remarksId"+i).style.display="none";
	}
	if(mode=='1')
	{
		if(document.getElementById("batchCheckbox"+index).checked==true)
		{
		 display_popup_menu("","remarksId"+index,'300','250');
		}
		else
		{
			alert("Please Select checkbox!!!");
			return false;
		}
		document.getElementById("strItemRemarks"+index).disabled=false;
	}
	else
	{
		display_popup_menu("","remarksId"+index,'300','250');
		document.getElementById("strItemRemarks"+index).disabled=true;
	}
	
	
	
	
}
function closeDivItem(index)
{
	document.getElementById("remarksId"+index).style.display="none";
	document.getElementById("strItemRemarks"+index).disabled=true;
	document.getElementById("strMultiRemarks"+index).value = document.getElementById("strItemRemarks"+index).value;
}

/** This is the validate function for Breakage Item Details jsp file
 *  i.e:- add_BreakageItemDtlTrans_mms.jsp and 
 *  transfer control to the controller 'INSERT' method.  
 */
 
 function validateVerify(mode)
 {
    var saveObj = document.getElementById("verifyBtn");
	
	if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	{
	  saveObj.style.display = "none";
	  var k = 0 ;  
	  var hisValidator = new HISValidator("physicalNewStockTransBean");  
	  hisValidator.addValidation("strStoreName","dontselect=0","Please select a value from Store Name Combo" );
	  var retVal = hisValidator.validate(); 
	  hisValidator.clearAllValidations();
	  if(retVal)
	  {	 
	  	  var chkLeng = document.getElementsByName("strVerifyCountedQty").length;
          for(var l=0;l<chkLeng;l++)
          {
          	if(document.getElementsByName("strVerifyCountedQty")[l].disabled==false)
          	{
          		k++;
          	}
          }
          //alert("Total Lenght-->"+chkLeng+"<---Counted--->"+k);
          if(k=='0')
          {
          	alert("Please Select Single Drug For Physical Stock Verification !!");
          	saveObj.style.display = "block";
            return false;
          }
          
          if(mode=='1')
          {
           var conf = confirm("You Are Going To Save To be Verified Physical Stock Verification Draft Request for [ "+document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].text+" ]");
          }
          if(mode=='2')
          {
            var conf = confirm("You Are Going To Save To be Verified Physical Stock Verification Final Save Request for [ "+document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].text+" ]");
          }
          
          if(conf == true)
          {
               var conf1 = confirm("Are you sure !!!");
               if(conf1 == true)
               {
               	  if(mode=='1')// Draft Save 
               	  {				      
				      document.forms[0].strDraftFlg.value="1";
				       				       
	              }
	              else if(mode=='2')//  Final Save
               	  {				      
				      document.forms[0].strDraftFlg.value="0";				      				      
				        
	              }
	              document.forms[0].strModifyFlg.value="0";	
	              document.forms[0].strStoreNameText.value =  document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].text;            	  
               	  document.forms[0].strStoreName.disabled = false;
               	  $( "textarea[id^='strItemRemarks']" ).attr("disabled", false);               	                 	 
                  document.forms[0].hmode.value = "TOBEVERIFY";
                  document.forms[0].submit();
               }
              else
               {
                 saveObj.style.display = "block";
                 return false;
               }
           }
          else
           {
                 saveObj.style.display = "block";
                 return false;
           }
				                		
		  }
		    else
		    {
			  saveObj.style.display = "block";
			  return false;
			}
	 
	 
	  
	}
 }
 
 function validateModify(mode)
 {
    var saveObj = document.getElementById("modifyBtn");
	
	if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	{
		saveObj.style.display = "none";  
	  var k = 0;	
	  var hisValidator = new HISValidator("physicalNewStockTransBean");  
	  hisValidator.addValidation("strStoreName","dontselect=0","Please select a value from Store Name Combo" );
	  var retVal = hisValidator.validate(); 
	  hisValidator.clearAllValidations();
	  if(retVal)
	  {	 		 
	  	
	  	  var chkLeng = document.getElementsByName("strVerifyCountedQty").length;
          for(var l=0;l<chkLeng;l++)
          {
          	if(document.getElementsByName("strVerifyCountedQty")[l].disabled==false)
          	{
          		k++;
          	}
          }
          //alert("Total Lenght-->"+chkLeng+"<---Counted--->"+k);
          if(k=='0')
          {
          	alert("Please Select Single Drug For Physical Stock Verification !!");
          	saveObj.style.display = "block";
            return false;
          }
	  	
          if(mode=='1')
          {
           var conf = confirm("You Are Going To Save  Physical Stock Verification Modify Draft Request for [ "+document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].text+" ]");
          }
          if(mode=='2')
          {
            var conf = confirm("You Are Going To Save  Physical Stock Verification Draft Final Save Request for [ "+document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].text+" ]");
          }      
          
          
              
          if(conf == true)
          {
               var conf1 = confirm("Are you sure !!!");
               if(conf1 == true)
               {
               	  if(mode=='1')// Draft Save 
               	  {				      
				      document.forms[0].strDraftFlg.value="1";	 				       
	              }
	              else if(mode=='2')//  Final Save
               	  {				      
				      document.forms[0].strDraftFlg.value="0";				      				      
				        
               	  }
	              
               	  document.forms[0].strModifyFlg.value="1";
               	  document.forms[0].strStoreNameText.value =  document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].text;  
               	  document.forms[0].strStoreName.disabled = false;
                  document.forms[0].hmode.value = "MODIFY";
                  document.forms[0].submit();
               }
              else
               {
                 saveObj.style.display = "block";
                 return false;
               }
           }
          else
           {
                 saveObj.style.display = "block";
                 return false;
           }
				                		
		  }
		    else
		    {
			  saveObj.style.display = "block";
			  return false;
			}
	 
	 
	  
	}
 }
 
 function validateRequest(mode)
 {
    var saveObj = document.getElementById("saveId");
	
	if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	{
		saveObj.style.display = "none";  
	  var hisValidator = new HISValidator("physicalNewStockTransBean");  
	  hisValidator.addValidation("strStoreName","dontselect=0","Please select a value from Store Name Combo" );
	  var retVal = hisValidator.validate(); 
	  hisValidator.clearAllValidations();
	  if(retVal)
	  {	 	  			          
          if(document.forms[0].strStockUpdateFlg.value=='1')
          {
           var conf = confirm("You Are Going To Update Stock For Physical Stock No [ "+document.forms[0].strRequestDtls.value.split("$")[0]+" ] for [ "+document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].text+" ]");
          }
          if(document.forms[0].strCancelFlg.value=='1')
          {
           var conf = confirm("You Are Going To Cancel  Physical Stock No [ "+document.forms[0].strRequestDtls.value.split("$")[0]+" ] for [ "+document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].text+" ]");
          }
          
          
          if(conf == true)
          {
               var conf1 = confirm("Are you sure !!!");
               if(conf1 == true)
               {
               	  		      
				  document.forms[0].strDraftFlg.value="0";     
				  document.forms[0].strModifyFlg.value="0";          	  
               	  document.forms[0].strStoreName.disabled = false;
               	  document.forms[0].strStoreNameText.value =  document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].text;  
                  document.forms[0].hmode.value = "STOCKUPDATECANCEL";
                  document.forms[0].submit();
               }
              else
               {
                  saveObj.style.display = "block";
                  return false;
               }
           }
           else
           {
               saveObj.style.display = "block";
               return false;
           }				                		
		  }
		  else
		  {
			 saveObj.style.display = "block";
			 return false;
		  } 
	}
 }
function validateApproval()
{
      var hisValidator = new HISValidator("physicalNewStockTransBean"); 
     
	  hisValidator.addValidation("strRemarks","req","Remrks is Mandatory" );
	  hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	 // hisValidator.addValidation("strReturnTypeCmb","dontselect=0","Please select a value from Return Type Combo" );
	  var retVal = hisValidator.validate(); 
	  if(retVal)
      {  
      	   if(document.forms[0].strApprovalFlag.value=='1')
      	   {
             var conf = confirm("You Are Going To Approve Physical Stock No [ "+ document.forms[0].strChk.value.split("@")[4]+" ]" );
      	   }
      	   else
      	   {
      	   	 var conf = confirm("You Are Going To Re-Approve Physical Stock No [ "+ document.forms[0].strChk.value.split("@")[4]+" ]" );
      	   }
           if(confirm(" Are You Sure ?"))
		   {
				document.forms[0].hmode.value = "INSERTFORAPPROVAL";
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
function validateMultiRow()
 {
          var onVal  = document.getElementById("strDrugId").value.split("^");
	      var isExpDateReq = onVal[11];
	      var isBatchReq   = onVal[10];
		  var hisValidator = new HISValidator("physicalNewStockTransBean");  
		  var strPONo = document.forms[0].strPONo.value;
		  hisValidator.addValidation("strGroupId","dontselect=0","Please select a Group Name Combo" );
		  // hisValidator.addValidation("strProgId","dontselect=0","Please select Program Name" );  
		  hisValidator.addValidation("strDrugId","dontselect=0","Please select Drug/Item Name" );  
		  if(isBatchReq=='1')
		  { 
		  	document.getElementById("batchId").innerHTML="<font color='red'>*</font>Batch No";   
		    hisValidator.addValidation("strBatchNo","req","Batch is a Mandatory Field" );
		    
		  }
		  else
		  {
		  	document.getElementById("batchId").innerHTML="Batch No";
		  }  
		  hisValidator.addValidation("strSupplierId","dontselect=0","Please select Supplier Name" );
		  var  QtyLength  = document.forms[0].strCountedQty.value.length;        
		
      			//alert('QtyLength'+QtyLength);		
			if(parseInt(QtyLength)>8)
			{
				alert("Maximum length of Counted Qty value can not be greater than 8");
				document.forms[0].strCountedQty.value.value="0";
			}
                       
		  if (document.forms[0].strMfgDate.value.length > 0)
		  {			  	    
				hisValidator.addValidation("strMfgDate", "dtltet="+ document.forms[0].strCurrentDate.value,"Mfg. date should be Less than or Equal to Current Date");
		  }
		  if(isExpDateReq=='1')
		  {
			  if (document.forms[0].strExpiryDate.value.length > 0)
			  {
			  	    document.getElementById("batchId").innerHTML="<font color='red'>*</font>Batch No"; 
			  	    document.getElementById("expiryId").innerHTML="<font color='red'>*</font>Expiry Date";			  	   
					hisValidator.addValidation("strExpiryDate", "dtgt="+ document.forms[0].strCurrentDate.value,"Exp. Date should be Greater than to Current Date");
			  }
			  else
			  {
			  	    document.getElementById("expiryId").innerHTML="Expiry Date";
			  }
		  }
		  //alert(document.forms[0].strRateUnit.value);
		  if(document.forms[0].strRateUnit.value == '')
			  { 
			  alert('Please select Unit Name')
			  return false;
			  }
		  hisValidator.addValidation("strRate","req","Rate is a Mandatory Field" );				  		 
		  hisValidator.addValidation("strRateUnit","dontselect=0","Please select Unit Name" );
		  
		  hisValidator.addValidation("strStatus","dontselect=0","Please select Status" );
		  hisValidator.addValidation("strCountedQty","req","Counted Qty is a Mandatory Field" );			  
		  hisValidator.addValidation("strDrugRemarks", "req","Remarks is a Mandatory Field" );	  
		  hisValidator.addValidation("strDrugRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );			  
		  var retVal = hisValidator.validate(); 
		  hisValidator.clearAllValidations();
		
	      if(retVal)
	      {	 
	      	   /*
                   HSTNUM_STORE_ID, HSTNUM_ITEM_ID , HSTNUM_ITEMBRAND_ID, HSTSTR_BATCH_NO , HSTNUM_STOCK_STATUS_CODE
                */	 
	      	  /*
	      	   * Drug Combo Value new
                 10000264^630001^0^0^0^10100263^101093^67.0000^630113^6Nos./Pkt.^1^1
	      	   */
	    	  //alert("leangth"+document.forms[0].strPONo.value.length)
	      	   if(document.forms[0].strPONo.value.length == 0)
	      	   {
	      	  			strPONo="0";
	      	   //alert("strProgId"+document.forms[0].strProgId.value);
	      	   }
	      	   
	      	 
	      	  var onVal  = document.getElementById("strDrugId").value.split("^");  
	      	  var pkKey1 = document.forms[0].strStoreName.value.split("^")[0]+"^"+onVal[0]+"^"+onVal[5]+"^"+document.forms[0].strBatchNo.value+"^"+document.forms[0].strStatus.value+"^"+strPONo+"^"+0;
	      	  var pkKey2 = document.forms[0].strRate.value+"^"+document.forms[0].strRateUnit.value+"^"+document.forms[0].strSupplierId.value+"^"+document.forms[0].strStatus.value+"^"+document.forms[0].strTenderNo.value
	      	               +"^"+document.forms[0].strDrugRemarks.value+"^"+document.forms[0].strCountedQty.value
	      	               +"^"+document.forms[0].strExpiryDate.value+"^"+document.forms[0].strMfgDate.value;
	      	  //alert("pkkey"+pkKey1);
	          var index ;
	          if(parseInt(document.getElementsByName("strRowIndex").length-1)==0)
			  {
			  	///alert("hii"+document.forms[0].strProgId[document.forms[0].strProgId.selectedIndex].text);
	        	  	addRows(new Array('strMultiRowDrugName','strMultiRowBatchNo','strMultiRowStockStatus','strMultiRowExpDate','strMultiRowCountedQty','strMultiRowRateWithUnit','strMultiRowRemarks'),new Array('t','t','t','t','t','t','t' ),'1','1','R');
			        index = document.getElementsByName("strRowIndex")[0].value;

			 		document.getElementById("strMultiRowPKKey1"+index).value = pkKey1;
				 	document.getElementById("strMultiRowPKKey2"+index).value = pkKey2;
				 	document.getElementById("strMultiRowDrugName"+index).innerHTML = document.forms[0].strDrugId[document.forms[0].strDrugId.selectedIndex].text;
				 	//document.getElementById("strMultiRowProgramName"+index).innerHTML = document.forms[0].strProgId[document.forms[0].strProgId.selectedIndex].text;
				 	document.getElementById("strMultiRowStockStatus"+index).innerHTML = document.forms[0].strStatus[document.forms[0].strStatus.selectedIndex].text;
				 	document.getElementById("strMultiRowRateWithUnit"+index).innerHTML = document.forms[0].strRate.value+"/"+document.forms[0].strRateUnit[document.forms[0].strRateUnit.selectedIndex].text;
				 	document.getElementById("strMultiRowBatchNo"+index).innerHTML = document.forms[0].strBatchNo.value;
				 	document.getElementById("strMultiRowExpDate"+index).innerHTML = document.forms[0].strExpiryDate.value;			
				 	document.getElementById("strMultiRowCountedQty"+index).innerHTML = document.forms[0].strCountedQty.value;				 	
				 	document.getElementById("strMultiRowRemarks"+index).innerHTML = document.forms[0].strDrugRemarks.value;
			  	
			  }   
			  else
			  {		
			  	    addRows(new Array('strMultiRowDrugName','strMultiRowBatchNo','strMultiRowStockStatus','strMultiRowExpDate','strMultiRowCountedQty','strMultiRowRateWithUnit','strMultiRowRemarks'),new Array('t','t','t','t','t','t','t' ),'1','1','R');
				  	for(var j=0; j<document.getElementsByName("strRowIndex").length-1;j++)
				 	{	
				 		index = 	document.getElementsByName("strRowIndex")[j].value;	 				  	        
				 	} 
				 	for(var j=0; j<document.getElementsByName("strRowIndex").length-1;j++)
				 	{			
				 		if(pkKey1 == document.getElementsByName("strMultiRowPKKey1")[j].value)
			  	        {				  	        				  	        	 		 
			  	        	alert("Drug Already Exists!!!");
			  	        	deleteRow(index, 1, 0);
			  	        	return false;
			  	        }
			  	        
				 	} 					 	
				 	document.getElementById("strMultiRowPKKey1"+index).value = pkKey1;
				 	document.getElementById("strMultiRowPKKey2"+index).value = pkKey2;
				 	document.getElementById("strMultiRowDrugName"+index).innerHTML = document.forms[0].strDrugId[document.forms[0].strDrugId.selectedIndex].text;
				 	//document.getElementById("strMultiRowProgramName"+index).innerHTML = document.forms[0].strProgId[document.forms[0].strProgId.selectedIndex].text;
				 	document.getElementById("strMultiRowStockStatus"+index).innerHTML = document.forms[0].strStatus[document.forms[0].strStatus.selectedIndex].text;
				 	document.getElementById("strMultiRowRateWithUnit"+index).innerHTML = document.forms[0].strRate.value+"/"+document.forms[0].strRateUnit[document.forms[0].strRateUnit.selectedIndex].text;
				 	document.getElementById("strMultiRowBatchNo"+index).innerHTML = document.forms[0].strBatchNo.value;
				 	document.getElementById("strMultiRowExpDate"+index).innerHTML = document.forms[0].strExpiryDate.value;
				 	document.getElementById("strMultiRowCountedQty"+index).innerHTML = document.forms[0].strCountedQty.value;				 	
				 	document.getElementById("strMultiRowRemarks"+index).innerHTML = document.forms[0].strDrugRemarks.value;
			  	
			  }
			  // Re-Set Value	
			  // document.forms[0].strProgId.value="0";	
			   document.forms[0].strGroupId.value="0";	  
			  document.forms[0].strDrugId.value="0";
			  document.forms[0].strBatchNo.value="";
			  document.forms[0].strSupplierId.value="0";
			  document.forms[0].strMfgDate.value=document.forms[0].strCurrentDate.value;
			  document.forms[0].strExpiryDate.value=document.forms[0].strCurrentDate.value;
			  document.forms[0].strRate.value="0";
			  document.forms[0].strRateUnit.value="";
			  document.forms[0].strStatus.value="0";
			  document.forms[0].strCountedQty.value="";
			  document.forms[0].strDrugRemarks.value="";  
			  document.forms[0].strTenderNo.value="";
			  document.forms[0].strPONo.value="";
			 		                		
		  }
		  
		  
	      else
	      {				 
		    return false;
		  }
	  
	
 }
function cancel()
{
      
	 	document.forms[0].hmode.value="INITIALPAGE";
	 	document.forms[0].submit();
}
 
/**
 * 
 */
function initPage()
{
  document.forms[0].hmode.value="FIRSTDATA";
  document.forms[0].submit();
}

 function cancel()
 { 
 	    document.getElementById("errMsg").innerHTML = "";
	 	document.forms[0].hmode.value = "CANCEL";
	 	showMenuFrame();
  	    document.forms[0].submit();
 }
 
 function getUnitName()
 { 	  
		  var onVal = document.forms[0].strDrugId[document.forms[0].strDrugId.selectedIndex].value.split("^");
		  /* 1.Brand Id
		   * 2.Grp Id
		   * 3.Item Id
		   * 4.Inventory Id
		   * 5.Sub Grp Id
		   * 6.New Item Flg
		   * 7.Store Item Bound
		   * 8.Rate
		   * 9.Rate Unit
		   * 10. Rate Unit Name
		   * */
		  // alert('rate'+onVal[7]);
		  // alert('unit'+onVal[9])
		   document.forms[0].strRate.value = onVal[7];				 
		   document.forms[0].strRateUnit[document.forms[0].strRateUnit.selectedIndex].text =  onVal[9];
		  // document.forms[0].strRateUnit[document.forms[0].strRateUnit.selectedIndex].value =  onVal[8]+"^"+onVal[10]+"^"+onVal[11];	
		   
  	
 }
 function getPendingBReqDtls()
 {  
 	document.getElementById("id1").innerHTML="";
 	
	   var mode="getPendingBReqDtls";
	   var url="BreakageItemDtlTransCNT.cnt?hmode="+mode+"&storeId="+document.forms[0].strStoreName.value+
	   			"&itemCatNo="+document.forms[0].strItemCatgCombo.value;
	   			
	   ajaxFunction(url,"6"); 
 }
 
 function formSubmit()
 {
 	document.forms[0].hmode.value	=	'FIRSTDATA';
 	document.forms[0].submit();	
 }
 
 /**
  * This function is working as Global function to 
  * Hide or Show the Stock Details
  */
 function showOrHideStockDetails(thisImg)
 {
 	
 	//alert(thisImg.title);
 	if (thisImg == null) 
 	{
		alert("Cannot find this image object.");
	}
	if (thisImg.title == "Show") 
	{
		// Change Image Attribute
		thisImg.src = "../../hisglobal/images/plus.gif";
		thisImg.title = "Hide";
		document.getElementById("newBatchDetails").style.display='none';
						
	}
	else
	{  
		thisImg.src = "../../hisglobal/images/minus.gif";
		thisImg.title = "Show";
		getNewDrugDetails();
		
		
		
	}	
	
 }
 

 
 function getNewDrugDetails()
 {  	
   if(document.getElementById("newBatchDetails").innerHTML.length>25)
   {
   	   document.getElementById("newBatchDetails").style.display='block';
   }
   else
   { 
	   //alert("itemcat"+document.forms[0].strCategorycode.value);
	   var temp = document.forms[0].strPhyDetails.value;
	   var mode="NEWDRUGDTLS";
	   var url="PhysicalNewStockVerfTransCNT.cnt?hmode="+mode+"&modName="+temp+"&storeId="+document.forms[0].strStoreName.value+"&catId="+document.forms[0].strCategorycode.value;
	    $('#mask').css('display','block');
	    $('#dvLoading').css('display','block');
	   ajaxFunction(url,"1");
   } 
 }
 
 function getCatName()
 {
	//alert("1");
   //var temp = document.forms[0].strPhyDetails.value;
   var mode="GETCATCOMBO";
  // alert("storeid"+document.forms[0].strStoreName.value);
   var objVal = document.forms[0].strStoreName.value;
   var storeid=objVal.split("^")[0];
	//alert("soteris"+objVal.split("^")[0]);
   var url="PhysicalNewStockVerfTransCNT.cnt?hmode="+mode+"&storeId="+storeid;
   ajaxFunction(url,"8"); 
 }  
 
 function getDrugName()
 {
   var temp = document.forms[0].strPhyDetails.value;
   var mode="GETGROUPDRUG";
   var url="PhysicalNewStockVerfTransCNT.cnt?hmode="+mode+"&modName="+temp+"&storeId="+document.forms[0].strStoreName.value+"&strGroupId="+document.forms[0].strGroupId.value+"&itemCatNo="+document.forms[0].strCategorycode.value;
   ajaxFunction(url,"2"); 
 } 
 function updateRecord(mode,index)
 {
 	
 	if(mode=='0')
 	{
 		alert("Activity Not Allowed!!!");
 		return false;
 	}
   changeReqColor(index);
   
   document.getElementById("viewBtn").style.display='none';
   document.getElementById("modifyBtn").style.display='block';
   document.getElementById("saveBtn").style.display='none';	        
   document.getElementById("verifyBtn").style.display='none';    
   //106915001$28-Apr-2015$Stock Updation In-Process$40$1
   if($("#strPhyHlpReqDtls"+index+"").val().split("$")[3] == "40"){
   	    $("span.draftsave").closest( "a" ).remove();
   }
  
   document.forms[0].strModifyFlg.value="1";
   document.forms[0].strVerifiedPageFlg.value="0";
   document.forms[0].strCancelFlg.value="0";
   document.forms[0].strRequestDtls.value=document.getElementById("strPhyHlpReqDtls"+index).value;
   var temp   = document.forms[0].strPhyDetails.value;
   var reqDtl = document.getElementById("strPhyHlpReqDtls"+index).value;
   var mode="UPDATERECORD";
   var url="PhysicalNewStockVerfTransCNT.cnt?hmode="+mode+"&modName="+temp+"&storeId="+document.forms[0].strStoreName.value+"&catId="+document.forms[0].strCategorycode.value+"&reqDtl="+reqDtl;
   $('#mask').css('display','block');
   $('#dvLoading').css('display','block');
   ajaxFunction(url,"3"); 
 } 
 function cancelRecord(mode,index)
 {
 	if(mode=='0')
 	{
 		alert("Activity Not Allowed!!!");
 		return false;
 	}
    changeReqColor(index);			     
   document.forms[0].strCancelFlg.value="1";	      
   document.forms[0].strVerifiedPageFlg.value="0";
   
   document.getElementById("viewBtn").style.display='none';
   document.getElementById("modifyBtn").style.display='none';
   document.getElementById("saveBtn").style.display='block';	        
   document.getElementById("verifyBtn").style.display='none';       
    
   document.getElementById("newBatchDetails").innerHTML="";	
   document.forms[0].strRequestDtls.value=document.getElementById("strPhyHlpReqDtls"+index).value;
   var temp = document.forms[0].strPhyDetails.value;
   var reqDtl = document.getElementById("strPhyHlpReqDtls"+index).value;
   var mode="STOCKUPDATE";
   //alert("catcode"+document.forms[0].strCatcode.value);
   var url="PhysicalNewStockVerfTransCNT.cnt?hmode="+mode+"&modName="+temp+"&storeId="+document.forms[0].strStoreName.value+"&catId="+document.forms[0].strCategorycode.value+"&reqDtl="+reqDtl;
   ajaxFunction(url,"5"); 
   $('#mask').css('display','block');
   $('#dvLoading').css('display','block');
  // ajaxFunction(url,"5"); 
	      
   
 } 
 function stockUpdate(mode,index)
 {
 	if(mode=='0')
 	{
 		alert("Activity Not Allowed!!!");
 		return false;
 	}
 	changeReqColor(index);
 	
 	document.getElementById("viewBtn").style.display='none';
    document.getElementById("modifyBtn").style.display='none';
    document.getElementById("saveBtn").style.display='block';	        
    document.getElementById("verifyBtn").style.display='none';    
    
	document.forms[0].strVerifiedPageFlg.value="0";
	document.forms[0].strStockUpdateFlg.value="1";
	document.forms[0].strCancelFlg.value="0";	           	 
    document.forms[0].strRequestDtls.value=document.getElementById("strPhyHlpReqDtls"+index).value;   
    document.getElementById("newBatchDetails").innerHTML="";	
    var temp = document.forms[0].strPhyDetails.value;
    var reqDtl = document.getElementById("strPhyHlpReqDtls"+index).value;
    var mode="STOCKUPDATE";
    var url="PhysicalNewStockVerfTransCNT.cnt?hmode="+mode+"&modName="+temp+"&storeId="+document.forms[0].strStoreName.value+"&catId="+document.forms[0].strCategorycode.value+"&reqDtl="+reqDtl;
    $('#mask').css('display','block');
    $('#dvLoading').css('display','block');
    ajaxFunction(url,"5"); 
 } 
 
 function viewStock(mode,index)
 { 	
 	changeReqColor(index);
    document.getElementById("viewBtn").style.display='block';
    document.getElementById("modifyBtn").style.display='none';
    document.getElementById("saveBtn").style.display='none';	        
    document.getElementById("verifyBtn").style.display='none';     
       
   document.getElementById("newBatchDetails").innerHTML="";	
   var temp = document.forms[0].strPhyDetails.value;
   var reqDtl = document.getElementById("strPhyHlpReqDtls"+index).value;
   var mode="STOCKUPDATE";
   var url="PhysicalNewStockVerfTransCNT.cnt?hmode="+mode+"&modName="+temp+"&storeId="+document.forms[0].strStoreName.value+"&catId="+document.forms[0].strCategorycode.value+"&reqDtl="+reqDtl;
   $('#mask').css('display','block');
   $('#dvLoading').css('display','block');
   ajaxFunction(url,"5"); 
 } 
 function changeReqColor(index)
 { 	
 	$("div#phyRequestDtls table tr[id^='trId']").removeClass("warning");  
 	$("#trId"+index).addClass("warning");
 }
 
 function getVerifiedItemHLP()
 {
	 	if(document.forms[0].strCategorycode.value ==0)
	 		{
	 		alert("Please Select Category Name");
	 		return false;
	 		}
 	    document.forms[0].strStoreName.disabled=true;
	 	document.getElementById("normalMsg").innerHTML="";	 	
	 	var objVal = document.forms[0].strStoreName.value;
	 	//alert(objVal);
	 	document.getElementById("fyId").innerHTML=objVal.split("^")[3];
		document.getElementById("lastVerifyDateId").innerHTML=objVal.split("^")[1];		
	 	if(objVal.split("^")[4]=='0')
	 	{
	 		//alert('0');
	 	 	document.getElementById("viewBtn").style.display='none';
	        document.getElementById("modifyBtn").style.display='none';
	        document.getElementById("saveBtn").style.display='none';	        
	        document.getElementById("verifyBtn").style.display='block';     
	 	}	 
	 	//alert("itemcat no"+document.forms[0].strCategorycode.value);
		if(objVal.split("^")[4]=='1')
	    {
	    	// alert("1");
	    	  var objVal = document.getElementById("phyStockVerifiedItemDtls");       
	          objVal.innerHTML = "" ;
	          document.getElementById("multiRowHeader").style.display='none';	         
		      var temp = document.forms[0].strPhyDetails.value;
			  var mode="REQUESTDETAILS";
			  var url="PhysicalNewStockVerfTransCNT.cnt?hmode="+mode+"&modName="+temp+"&storeId="+document.forms[0].strStoreName.value+"&catId="+document.forms[0].strCategorycode.value;	 			    
			  ajaxFunction(url,"6"); 
	        
	    } 	    
	    else
	    {
	    	//alert("2");
	    	document.getElementById("phyRequestDtls").style.display='none';
	    	//alert("hii");
	    	//alert(document.forms[0].strPhyDetails.value);
		    var temp = document.forms[0].strPhyDetails.value;
		    var mode="VERIFIEDITEMHLP";
		    //alert("hello");
		    var url="PhysicalNewStockVerfTransCNT.cnt?hmode="+mode+"&modName="+temp+"&storeId="+document.forms[0].strStoreName.value+"&catId="+document.forms[0].strCategorycode.value;	   
		    $('#mask').css('display','block');
		    $('#dvLoading').css('display','block');	   
		    ajaxFunction(url,"3"); 
	    }	
 }	
 
 function getPhyDetails()
 {
	 var objVal = document.forms[0].strStoreName.value;
	 document.getElementById("fyId").innerHTML=objVal.split("^")[3];
     document.getElementById("lastVerifyDateId").innerHTML=objVal.split("^")[1];
     document.getElementById("phyRequestDtls").style.display='none';
     var objVal = document.getElementById("phyStockVerifiedItemDtls");       
     objVal.innerHTML = "" ;
     document.getElementById("multiRowHeader").style.display='none';
     document.getElementById("fin").style.display='';
 }
 
function ajaxDeleteRow(index)
{
	if(document.getElementById("strMultiNewItemFlg"+index).value=='0')
	{	
		 var conf = confirm("Drug will be permanently deleted");
		 if(conf == true)
		 {
		     var conf1 = confirm("Are you sure !!!");
		     if(conf1 == true)
		     {	  		  
			  var temp   = document.forms[0].strPhyDetails.value;
	          var reqDtl = document.forms[0].strRequestDtls.value;
	          var pKey   = document.getElementById("strMultiRowPKKey1"+index).value;
	          var mode="DELETEITEM";
//	          alert("cat code"+document.forms[0].strCategorycode.value)
//	          alert("temp"+temp);
//	          alert("document.forms[0].strStoreName.value"+document.forms[0].strStoreName.value);
//	          alert("reqDtl"+reqDtl);
//	          alert("index"+index);
//	          alert("pKey"+pKey);
	          var url="PhysicalNewStockVerfTransCNT.cnt?hmode="+mode+
	                  "&modName="+temp+
	                  "&storeId="+document.forms[0].strStoreName.value+
	                  "&reqDtl="+reqDtl+
	                  "&index="+index+
	                  "&pKey="+pKey+
	                  "&catId="+document.forms[0].strCategorycode.value;
	                  
			  ajaxFunction(url,"7"); 
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
      deleteRow(index, 1, 0);
	}  
}
 
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
 	    document.forms[0].firstClickFlg.value="1"; 	     	
        var objVal1 = document.getElementById("newBatchDetails");
        objVal1.innerHTML =  res;	            
        document.getElementById("multiRowHeader").style.display='block';
        $('#mask').css('display','none');
        $('#dvLoading').css('display','none');        
       
     }
     if(mode=="2")
     {
    	 //alert("res"+res);
    	 //document.getElementsByName("strDrugId")[0].value=0;
        var objVal = document.getElementById("drugComboDivID");
        objVal.innerHTML = "<select name = 'strDrugId' id='strDrugId' class='comboMax' onChange='getUnitName(this);'>" + res + "</select>";
       
     }
     
     if(mode=="3")
     {
    	 
     	  temp = res.split("$");
     	 
     	  var objVal = document.getElementById("phyStockVerifiedItemDtls");
          objVal.innerHTML =temp[0];
		  objVal.style.display = 'block';	  
		  var divPOTypeId = document.getElementById("id1");
		  divPOTypeId.innerHTML=temp[1];
		  divPOTypeId.style.display = 'block';
		  
		  document.getElementsByName("rowIndex1")[0].value= parseInt(temp[2]);
		  document.getElementsByName("rowLength1")[0].value=parseInt(temp[2]);	
     	
         
	      var divHeight=400;
		  var initialHeight=716;
		  var heightPer = (divHeight*100)/initialHeight; 
		  var newHeight = parseInt((window.innerHeight * heightPer)/100,10);	
			
	      //fixedHeaderTableTransCustomize("phyStockVerifiedItemDtls",newHeight, "wrapper1","tableHeaderId1");
	        
	        
		  document.getElementById("multiRowHeader").style.display='block';
		  $('#mask').css('display','none');
		  $('#dvLoading').css('display','none');
		    
		  document.getElementById("withOutImage").style.display='none';
		  document.getElementById("withImage").style.display='block';     
			
		  document.getElementById("imgStockDetails").src = "../../hisglobal/images/minus.gif";
		  document.getElementById("imgStockDetails").title = "Show";
		
		  getNewDrugDetails();
		 	
	     
     }
     if(mode=="4")
     {
     	 temp = res.split("$");
     	 
     	  var objVal = document.getElementById("phyStockVerifiedItemDtls");
          objVal.innerHTML =temp[0];
			  
		  var divPOTypeId = document.getElementById("id1");
		  divPOTypeId.innerHTML=temp[1];
		  
		  document.getElementsByName("rowIndex1")[0].value= parseInt(temp[2]);
		  document.getElementsByName("rowLength1")[0].value=parseInt(temp[2]);	
     	
       
        var divHeight=400;
		var initialHeight=716;
		var heightPer = (divHeight*100)/initialHeight; 
		var newHeight = parseInt((window.innerHeight * heightPer)/100,10);	
		
        fixedHeaderTableTransCustomize("phyStockVerifiedItemDtls",newHeight, "wrapper1","tableHeaderId1");
        $('#mask').css('display','none');
	    $('#dvLoading').css('display','none');
	     document.getElementById("multiRowHeader").style.display='block';
	     
	     
		
		 document.getElementById("imgStockDetails").src = "../../hisglobal/images/minus.gif";
		 document.getElementById("imgStockDetails").title = "Show";
		 getNewDrugDetails();
		 	
	     
     }
     if(mode=="5")
     {
     	temp = res.split("$");
     	 
     	var objVal = document.getElementById("phyStockVerifiedItemDtls");
        objVal.innerHTML =temp[0];
        objVal.style.display = 'block';
			  
		var divPOTypeId = document.getElementById("id1");
		divPOTypeId.innerHTML=temp[1];
		  
		document.getElementsByName("rowIndex1")[0].value= parseInt(temp[2]);
		document.getElementsByName("rowLength1")[0].value=parseInt(temp[2]);	
        
	    document.getElementById("multiRowHeader").style.display='block';
	    $('#mask').css('display','none');
	    $('#dvLoading').css('display','none');
		document.getElementById("withOutImage").style.display='block';
		document.getElementById("withImage").style.display='none';     
	
		
     }
     if(mode=="6")
     {     	    	
	    	
	        var objVal1 = document.getElementById("phyRequestDtls");
	        objVal1.innerHTML =  res;	           
	         document.getElementById("phyRequestDtls").style.display='block';
       
     }
     if(mode=="7")
     {     	
     	   var tmp = res.split("$$");
	       deleteRow(tmp[1], 1, 0);
       
     }
     if(mode=="8")
     {     	
     	   //alert("res"+res);
     	   	var objVal= document.getElementById("catCmbDivIdOne");
			objVal.innerHTML = "<select name ='strCategorycode' class='comboMax'>"+res+"</select>";		
       
     }
      
     
    
}

function costReq()
{	
    hideMenuFrame();
        
    
    var objVal = document.forms[0].strStoreName.value;      
  //  document.getElementById("fyId").innerHTML=objVal.split("^")[3];
  //  document.getElementById("lastVerifyDateId").innerHTML=objVal.split("^")[1];
   	  	 
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
 
 //////////////////////////////////////////////////////////////////////////////////////////////////////////

function calculateVariance()
{
	        var varianceTotal=0.00;
	      	var varianceCostTotal=0.00;
	      	var rate;
	      	var varianceCostLength;
			var strStockDtlsChk = document.getElementsByName("strDrugDtls");
			/*
			 * Header Row:
			 * 1 HSTNUM_ITEMBRAND_ID 
			 * 2 HSTSTR_BATCH_NO 
			 * 3 HSTNUM_COUNTED_QTY
			 * 4 HSTNUM_DRUG_NAME
			 * 5 HSTDT_MANUF_DATE
			 * 6 HSTDT_EXPIRY_DATE
			 * 7 GNUM_HOSPITAL_CODE
			 * 8 GNUM_ISVALID
			 * 9 HSTNUM_STORE_ID
			 * 10 HSTNUM_SUPPLIER_ID
			 * 11 HSTSTR_SUPPLIER_NAME
			 * 12 HSTNUM_RATE
			 * 13 HSTNUM_RATE_UNITID
			 * 14 HSTSTR_UNIT_NAME
			 */
			 var tolerancelimit = document.forms[0].strTolranceLimit.value;
			for(var i=0;i<strStockDtlsChk.length;i++)
		    {
			    
				var tempArray1    = strStockDtlsChk[i].value.split("^");
				var avalQty       = parseFloat(document.getElementsByName("strTAvlQty")[i].value);
				    rate          = strStockDtlsChk[i].value.split('^')[11];				
				var countedQty    = parseFloat(document.getElementsByName("strTCountQty")[i].value);
				variance          = manipulateValue(parseFloat(countedQty),parseFloat(avalQty),1);  // 0 Add 1 Sub
				//alert("avalQty:::"+avalQty);
				//alert("rate:::"+rate);
				//alert("Varaince:::"+variance);
				document.getElementsByName("strTVariance")[i].value = variance;		
				document.getElementById("varianceDiv"+i).innerHTML=	variance;	
				varianceCost      = parseFloat(variance)*parseFloat(rate);				
				document.getElementsByName("strTVarianceCost")[i].value = varianceCost;
				document.getElementById("varianceCostDiv"+i).innerHTML=	varianceCost;	
				varianceTotal     = roundValue(manipulateValue(varianceTotal,parseFloat(variance),0),2);
				varianceCostTotal = roundValue(manipulateValue(varianceCostTotal,parseFloat(varianceCost),0),2);			
		   }	   
		  
		gblCost =0.00;
   		gblCost1=0.00;
   		gblCost2=0.00;
   		
   		varianceCostLength = document.getElementsByName("strTVarianceCost").length;
   		for(var i=0;i<varianceCostLength;i++)
   		{			
			gblCost1=roundValue(manipulateValue(gblCost1,parseFloat(document.getElementsByName("strTVarianceCost")[i].value),0),2);// 0 Add 1 Sub
		}
		
		if(document.forms[0].strVarianceCost)
		{
		  varianceCostLength2 = document.getElementsByName("strVarianceCost").length;
		  //alert("Item Param Length:::"+varianceCostLength2);
		}
		else
		{
		  varianceCostLength2 =  '0';
		  //gblCost2=0.00;	
		}
		for(var i=0;i<varianceCostLength2-1;i++)
   		{			
			  gblCost2=roundValue(manipulateValue(gblCost2,parseFloat(document.getElementsByName("strVarianceCost")[i].value),0),2);// 0 Add 1 Sub
		}
		
		//		alert("Toal Cost of Item Finder::"+parseFloat(gblCost1));
		//alert("Toal Cost of HLP::"+parseFloat(gblCost2));
		gblCost = manipulateValue(parseFloat(gblCost1),parseFloat(gblCost2),0);	// 0 Add 1 Sub	
   		document.getElementById("strVarianceNetCostDivId").innerHTML=gblCost;
   	 	document.getElementsByName("strVarianceNetCost")[0].value=gblCost;	
		
   		document.getElementById("strVarianceNetCostDivId").innerHTML=gblCost;
   	 	document.getElementsByName("strVarianceNetCost")[0].value=gblCost;	
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
function getItemCategoryComboViewPage()
 {
  
   var temp = document.forms[0].strStoreName.value.split("^");
   var mode="ItemCatgoryCombo";
   var url="BreakageItemDtlTransCNT.cnt?hmode="+mode+"&modName="+temp[0];
   ajaxFunction(url,"3"); 
 }

function transferToViewPage()
{
	if(document.getElementsByName("strViewChk")[0].checked){
		document.forms[0].hmode.value="VIEWPAGE";
		document.forms[0].submit();
	}
}

function getViewItemDtl()
{
	
 	if(document.getElementsByName("strStoreName")[0].value=="0"){
		alert("Please Select Store From Combo");
		return false;
	}
	if(document.getElementsByName("strItemCatgCombo")[0].value=="0"){
		alert("Please Select Category");
		document.getElementById("strItemCatgCombo").focus();
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
	
	else{
		var temp = document.forms[0].strStoreName.value.split("^")[0];
	    var mode="GOVIEWPAGE";
	    var url="BreakageItemDtlTransCNT.cnt?hmode="+mode+
	    "&storeId="+temp+
	    "&itemCatNo="+document.forms[0].strItemCatgCombo.value+
	    "&startDate="+document.forms[0].strFromDate.value+
	    "&endDate="+document.forms[0].strToDate.value+
	    "&status="+document.forms[0].strStatus.value;
	    		
	    ajaxFunction(url,"4"); 	
	    document.getElementsByName("strStoreName")[0].disabled=true;
        document.getElementsByName("strItemCatgCombo")[0].disabled=true;
        document.getElementsByName("strStatus")[0].disabled=true;
        document.getElementsByName("strFromDate")[0].disabled=true;
        document.getElementsByName("strToDate")[0].disabled=true;
        document.getElementById("imgstrFromDate1").style.display='none';
        document.getElementById("imgstrToDate1").style.display='none';
	}
	
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

function clearReport()
{
	document.forms[0].hmode.value="VIEWPAGE";
	document.forms[0].submit();
}
 


function generateIssueReportPdf(strIssueNo) 
{
	document.forms[0].strIssueNo.value = strIssueNo;
	generatePdfScrollVoucher("issueDtlsDivId", "mainTableId", "mainTableRptId2", "voucherDivId");	
}

function checklength(index) 
 {      		   //alert('index'+index);
	    	var  QtyLength  = document.getElementById("strVerifyCountedQty" + index).value.length;        
		
      			//alert('QtyLength'+QtyLength);		
			if(parseInt(QtyLength)>8)
			{
				alert("Maximum length of Counted Qty value can not be greater than 8");
				document.getElementById("strVerifyCountedQty" + index).value="0";
				return false;
			}
			else
			{
				return true;
			}
}

/**
 * checkBatchExistence
 * @param {type}  
 */
 function checkBatchExistence() {
 	if(document.getElementById("strBatchNo").value==0)
 	{	
			alert("Batch No. cannot be 0. Enter a valid Batch No.");
			document.getElementById("strBatchNo").value="";
			return false;		
 	}
 }