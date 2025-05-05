
/** This is the validate function for Off Line Issue Item Details jsp file
 *  i.e:- add_OfflineIssueItemDtlTrans_mms.jsp and 
 *  transfer control to the controller 'INSERT' method.  
 */
 
 var parentPopup="";
var indexglobal="";
 
 function validate1()
 {
	  var hisValidator = new HISValidator("offlineReturnBean");  
	  hisValidator.addValidation("strStoreName","dontselect=0","Please select a value from Drug Warehouse Name Combo" );
	  hisValidator.addValidation("strItemCatgCombo","dontselect=0","Please select a value from Item Category Combo" );
	  hisValidator.addValidation("strIndentingStoreID","dontselect=0","Please select a value from Indent Drug Warehouse Name Combo" );
	  hisValidator.addValidation("strIndentType","dontselect=0","Please select a value from Indent Type Combo" );
	  //hisValidator.addValidation("strIndentPeriodValue","req","Indent No is a Mandatory Field" );
	  hisValidator.addValidation("strIndentNo","req","Indent No is a Mandatory Field" );
	  //hisValidator.addValidation("strToStoreCombo","dontselect=0","Please select a value from To Store Combo" );
	  //hisValidator.addValidation("strAprovedRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	  hisValidator.addValidation("strReceivedBy","req","Received By is a Mandatory Field" );
	  	 
      var retVal = hisValidator.validate(); 
	  hisValidator.clearAllValidations();
	  
	  var itemParVal  = document.getElementsByName("itemParamValue");
	  
	  if(retVal)
	  {
	  	 if(document.getElementsByName("itemParamValue").length=="1")
		 {
     							alert("Please Search Item Details");     							
     							return false;
      	 }
      	 else
      	 {
      	 	hisValidator.addValidation("strUnitName","dontselect=0","Please select a value from Unit Name Combo" );
            var retVal1 = hisValidator.validate(); 
            if(retVal1)
            {
      	 	
      	 	    
          		  		
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
            else
            {
            	return false;
            }	  	
          	   	 	
       	 }
	  }       
 }

function reqQtyValidation(index)
{	
	     
	     document.getElementById("strReturnQty"+index).value = "0";
		if(document.getElementById("strReturnQty"+index).value!="" && document.getElementById("strReqQty"+index).value!="")
		{	
						
				var reqQty = document.getElementById("strReqQty"+index).value;
				var temp   = document.getElementById("itemCalcValue"+index).value.split("^");
				var avlQtyBaseVal = temp[0];
					
					/*if(parseFloat(avlQtyBaseVal)<reqQty)
					{
						alert("Request Quantity cannot be greater than Avalaible Quantity!!");
						//document.getElementById('strUnitName'+index).value = "0";
						document.getElementById('strReqQty'+index).value = "0";
						document.getElementById("strReturnQty"+index).value ="0";
						calculateTotalCost(index);
						return false;
					}*/
			
		}
		else
		{
			alert("Please Enter Qty!!!");
    		document.getElementById("strReqQty"+index).value = "0";
    		document.getElementById("strReturnQty"+index).value ="0";
    		calculateTotalCost(index);
			return false;
			
		}
    	calculateTotalCost(index);
}

// function called on enter issue qty to check the validation of issue qty

function returnQtyValidation(index) 
{
	
		var returnQty      = document.getElementById("strReturnQty" + index).value;
		
		var reqQty        = document.getElementById("strReqQty" + index).value;
		var temp          = document.getElementById("itemCalcValue" + index).value.split("^");
		var avlQtyBaseVal = temp[0];

		if (parseFloat(reqQty) < returnQty)
		{
			alert("Return Quantity cannot be greater than Requested Quantity");
			document.getElementById("strReturnQty" + index).value = "0";
			calculateTotalCost(index);
			return false;
		}
		/*if (parseFloat(avlQtyBaseVal) < returnQty) 
		{
			alert("Return Quantity cannot be greater than Avalaible Quantity");
			document.getElementById("strReturnQty" + index).value = "0";
			calculateTotalCost(index);
			return false;
		}*/


          /*
	             Here We Preserv Value 
	       */
	       var chkObj      = document.getElementsByName("itemUserValue");
	       //var unitObj     = document.getElementsByName("strUnitName");
	       var reqQtyObj   = document.getElementsByName("strReqQty");
	       var issueQtyObj = document.getElementsByName("strReturnQty");
	       var rateObj     = document.getElementsByName("itemCalcValue");
	       

	       //var len = chkObj.length;   
	       var newStr = "";
	      
	       //var count2 = parseInt("0");
	       	 var flag=true;      
	       	 document.getElementById("strItemDtlWithIssueQty").value="";
	       	 
	        for(var nTmpI=0;nTmpI<chkObj.length-1;nTmpI++)
			{		
				//alert(flag);	
				if(flag)        
				{	     //              0=Item Id                        1=Item Brand Id                      2=Batch No                                   3= Stock Status Code         4=Request Qty          5=Unit      6=Return Qty               7=Rate
					newStr = chkObj[nTmpI].value.split("^")[0]+"#"+chkObj[nTmpI].value.split("^")[1]+"#"+chkObj[nTmpI].value.split("^")[15]+"#"+chkObj[nTmpI].value.split("^")[32]+"#"+reqQtyObj[nTmpI].value+"#0^0^0#"+issueQtyObj[nTmpI].value+"#"+rateObj[nTmpI].value.split("^")[1];
					//newStr = varTemp[0]+"#"+varTemp[1]+"#"+varTemp[15]+"#"+varTemp[32]+"#"+document.getElementById("strUnitName"+index).value+"#"+document.getElementById("strIssueQty"+index).value;
					flag = false;
				}
				else
				{
					                      //              0=Item Id                        1=Item Brand Id                      2=Batch No                                   3= Stock Status Code         4=Request Qty          5=Unit      6=Return Qty               7=Rate
					newStr= newStr+"$$$$"+chkObj[nTmpI].value.split("^")[0]+"#"+chkObj[nTmpI].value.split("^")[1]+"#"+chkObj[nTmpI].value.split("^")[15]+"#"+chkObj[nTmpI].value.split("^")[32]+"#"+reqQtyObj[nTmpI].value+"#0^0^0#"+issueQtyObj[nTmpI].value+"#"+rateObj[nTmpI].value.split("^")[1];
					//newStr= newStr+"$$$$"+varTemp[0]+"#"+varTemp[1]+"#"+varTemp[15]+"#"+varTemp[32]+"#"+document.getElementById("strUnitName"+index).value+"#"+document.getElementById("strIssueQty"+index).value;
				}		
						
										
				
			}
			//alert("After Adding this:::"+newStr);
			document.getElementById("strItemDtlWithIssueQty").value =  newStr;
	
	
	calculateTotalCost(index);
}


function calculateTotalCost(index) 
{      
	        var costArray           = new Array();
	        var rateObj             = document.getElementsByName("itemCalcValue");
	        var qtyObj              = document.getElementsByName("strReturnQty");
	       
	        var cost                = document.getElementsByName("strCost");
	        	        
	        var total               = parseFloat("0.00");
	        for(var nTmpI=0;nTmpI<rateObj.length-1;nTmpI++)
			{
				 		
			            if(isNaN(qtyObj[nTmpI].value)  || qtyObj[nTmpI].value=="" || isNaN(rateObj[nTmpI].value.split("^")[1]) || rateObj[nTmpI].value.split("^")[1]=="" ) 
			            {
			                qtyObj[nTmpI].value = "0";
			                rateObj[nTmpI].value.split("^")[1] = "0";
			                costArray[nTmpI] = "0";
			            }
						else
						{
						   costArray[nTmpI] = roundValue(parseFloat(qtyObj[nTmpI].value * rateObj[nTmpI].value.split("^")[1]), 2)
						}
						cost[nTmpI].value    = costArray[nTmpI];
			}
		                var costObj = document.getElementsByName("strCost");
						var total   = parseFloat("0.00");
						
					   	if (costObj.length > 0) 
						{
					       
							for ( var i = 0; i <costObj.length; i++)
							{		        	
									
								total = total + parseFloat(costObj[i].value);
					 		}
					
						}				    
			          total = roundValue(total, 2);
	                  document.getElementById("strNewDemandApproxAmtDivId").value = total;
                      document.forms[0].strNewDemandFinalApproxAmt.value=total;	           
	
    return true;
}
function totalCostforNewDemand()
{	   
       	    var costObj = document.getElementsByName("strCost");
			var total = parseFloat("0.00");
			//alert(costObj.length);
		   	if (costObj.length > 0) 
			{
		       
				for ( var i = 0; i <costObj.length; i++)
				{		        	
						
					total = total + parseFloat(costObj[i].value);
		 		}
		
			}

	    total = roundValue(total, 2);
	    document.getElementById("strNewDemandApproxAmtDivId").value = total;
        document.forms[0].strNewDemandFinalApproxAmt.value=total;
        //alert("strNewDemandFinalApproxAmt :"+document.forms[0].strNewDemandFinalApproxAmt.value);
       
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
  	    document.forms[0].submit();
 }
 
 
 function getItemCategoryCombo2()
 {
	  var temp = null;
	  document.getElementById("errMsg").innerHTML = "";
	 
	 if(document.forms[0].strStoreName!=null) 
	 {
		 temp=document.forms[0].strStoreName.value;
	 }
     if(temp==null || temp=="" || temp=="0")
     {
    	 var objVal = document.getElementById("ItemCatg");
         objVal.innerHTML = "<select name = 'strItemCatgCombo' tabindex='1' onchange='getIndentStoreCombo();' class='comboNormal'><option value='0'>Select Value</option></select>";
    	 return;
     }
     var mode="ItemCatgoryCombo";
     var url="OfflineReturnTransCNT.cnt?hmode="+mode+"&modName="+temp;
   
     ajaxFunction(url,"2"); 
     var objVal1 = document.getElementById("IndentingStore");
   	 objVal1.innerHTML = "<select name = 'strIndentingStoreID' tabindex='1' class='comboNormal'><option value='0'>Select Value</option></select>";
     document.getElementById("id1").innerHTML="";
     document.forms[0].strIndentNo.value="";
 }
 
 function getItemCategoryCombo()
 {
	  var temp = null;
	  document.getElementById("errMsg").innerHTML = "";
	 if(mode=="1")
	 {
	  document.getElementById("strNewDemandApproxAmtDivId").value = "0.00";
	  document.forms[0].strNewDemandFinalApproxAmt.value="0.00";
	 }
	 if(document.forms[0].strStoreName!=null) 
	 {
		 temp=document.forms[0].strStoreName.value;
	 }
     if(temp==null || temp=="" || temp=="0")
     {
    	 var objVal = document.getElementById("ItemCatg");
         objVal.innerHTML = "<select name = 'strItemCatgCombo' tabindex='1' onchange='getIndentStoreCombo();' class='comboNormal'><option value='0'>Select Value</option></select>";
    	 return;
     }
     var mode="ItemCatgoryCombo";
     var url="OfflineReturnTransCNT.cnt?hmode="+mode+"&modName="+temp;
   
     ajaxFunction(url,"2"); 
     var objVal1 = document.getElementById("IndentingStore");
   	 objVal1.innerHTML = "<select name = 'strIndentingStoreID' tabindex='1' class='comboNormal'><option value='0'>Select Value</option></select>";
     document.getElementById("id1").innerHTML="";
     document.forms[0].strIndentNo.value="";
 }
 function getIndentStoreCombo()
 {
   document.getElementById("id1").innerHTML="";
   document.forms[0].strIndentNo.value="";
   if(document.forms[0].strItemCatgCombo.value=="0")
   {
   		alert("Please select drug category.");
   		var objVal1 = document.getElementById("IndentingStore");
   	 	objVal1.innerHTML = "<select name = 'strIndentingStoreID' tabindex='1' class='comboNormal'><option value='0'>Select Value</option></select>";
   	 	document.getElementById("id1").innerHTML="";
   		document.forms[0].strIndentNo.value="";
   		document.forms[0].strItemCatgCombo.focus();
   		return false;
   }
   if(document.forms[0].strIsView.value=='0')
   {
   	   var objVal1 = document.getElementById("IndentingStore");
       objVal1.innerHTML = "<select name = 'strIndentingStoreID' tabindex='1' class='comboNormal'><option value='0'>Select Value</option></select>";
	   var temp = document.forms[0].strItemCatgCombo.value;
	   var objValue = document.forms[0].strStoreName;
	   var temp1 = objValue.options[objValue.selectedIndex].value;
	   var mode = "IndentStoreCombo";
	   var url  = "OfflineReturnTransCNT.cnt?hmode="+mode+"&modName="+temp1+"^"+temp;
	   ajaxFunction(url,"1");
   } 
   document.getElementById("id1").innerHTML="";
   document.forms[0].strIndentNo.value="";
 }
 function getApprovedVerifyCombo()
 {
 	   var objValue = document.forms[0].strStoreName;
	   var temp = objValue.options[objValue.selectedIndex].value;
	   
	   var objValue1 = document.forms[0].strIndentingStoreID;
	   var temp1     = objValue1.options[objValue1.selectedIndex].value;
	   
	   var mode="ApprovedVerifyCombo";
	   var url="OfflineReturnTransCNT.cnt?hmode="+mode+"&modName="+temp+"^"+temp1;
	   ajaxFunction(url,"6");
 	
 	
 }
 
    function getApprovedByCombo() 
	{
		var temp =null;
		if(document.forms[0].strStoreName!=null) 
		{
			temp = document.forms[0].strStoreName.value;
		}
		if(temp==null || temp=="" || temp=="0") 
		{
			var objVal = document.getElementById("ApprovedBy");
			objVal.innerHTML = "<select name = 'strApprovedBy' tabindex='1'  class='comboNormal'><option value='0'>Select Value</option></select>";
			return;
		}
		var mode = "ApprovedByCombo";
		var url = "OfflineReturnTransCNT.cnt?hmode="+mode+"&modName="+temp;
		ajaxFunction(url, "7");
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
        var objVal1 = document.getElementById("IndentingStore");
        objVal1.innerHTML = "<select name = 'strIndentingStoreID' tabindex='1' class='comboNormal' onchange='getApprovedVerifyCombo();'>" + res + "</select>";
     }
     if(mode=="2")
     {
        var objVal = document.getElementById("ItemCatg");
        objVal.innerHTML = "<select name = 'strItemCatgCombo' tabindex='1' class='comboNormal' onchange='getIndentStoreCombo();' class='comboNormal'>" + res + "</select>";
        getApprovedByCombo();
     }
     
      if(mode=="3")
     {
        var objVal = document.getElementById("ItemCatgViewId");
        objVal.innerHTML = "<select name = 'strItemCatgCombo' class='comboNormal' onchange='getGroupNameCombo();'>" + res + "</select>"+
        " <img src='../../hisglobal/images/Go.png'"+
				"onClick='getViewItemDtl();' align='top' style='cursor: pointer; ' title='Click Here To View Breakage Item Details'>";
     }
      if(mode=="4"){
      	
      				var storeName=document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].text;
      				var itemCategName=document.forms[0].strItemCatgCombo[document.forms[0].strItemCatgCombo.selectedIndex].text;
      				
			      	document.getElementById("breakageItemDtlId").innerHTML=res;
			      	document.getElementById("breakageItemDtlId").style.display="block";
			       	/*document.getElementById("ItemCatgViewId").style.display="none";
			      	document.getElementById("storeComboNameID").style.display="none";
			      	document.getElementById("storeComboID").innerHTML=storeName;
			      	document.getElementById("itemCategViewNameID").innerHTML=itemCategName;
			     	document.getElementById("storeComboNameID").style.display="block";
			      	document.getElementById("itemCategViewNameID").style.display="block";*/
	 }
	 if(mode=="5")
	 {
	 	    
           	temp=res.split("@");
	 		i=temp[2];
	 		document.getElementById("IssueItempopup").innerHTML  = temp[0];
	 		document.getElementById("IssueItempopup").style.display="block";
			display_popup_menu(parentPopup,'IssueItempopup','',''); 
     
	  }
	  if(mode=="6")
	  {	 	               
	 		document.getElementById("VerifiedBy").innerHTML  = "<select name = 'strVerifiedBy' tabindex='1' class='comboNormal'>" + res + "</select>";;
     
	  }
	  if(mode=="7")
	  {	  	    
	 	    document.getElementById("ApprovedBy").innerHTML  = "<select name = 'strApprovedBy' tabindex='1' class='comboNormal' >" + res + "</select>";
     
	  }
	
	 
     
}
function getItemCategoryComboViewPage()
 {
  
   var temp = document.forms[0].strStoreName.value.split("^");
   var mode="ItemCatgoryCombo";
   var url="OfflineIssueIndentTransCNT.cnt?hmode="+mode+"&modName="+temp[0];
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
	}
	else if(document.getElementsByName("strItemCatgCombo")[0].value=="0")
	{
		alert("Please Select Item Category From Combo");
	}
	else{
		var temp = document.forms[0].strStoreName.value;
	    var mode="GOVIEWPAGE";
	    var url="OfflineReturnTransCNT.cnt?hmode="+mode+"&storeId="+temp+"&itemCatNo="+document.forms[0].strItemCatgCombo.value+"&fromDate="+document.forms[0].strFromDate.value+"&ToDate="+document.forms[0].strToDate.value;
	    ajaxFunction(url,"4"); 	
	}
	
}
function showPopUp(obj,i)
{	
	    indexglobal=i;
		parentPopup=obj;

		 var mode = "GETPOPUP";
		 var url = "OfflineReturnTransCNT.cnt?hmode="+mode+"&hiddenVal="+document.getElementById('strHlpIssueNo'+i).value+"&index="+i+"&storeId="+document.forms[0].strStoreName.value+"&itemCatNo="+document.forms[0].strItemCatgCombo.value+"&fromDate="+document.forms[0].strFromDate.value+"&ToDate="+document.forms[0].strToDate.value;
		 //alert("url-"+url);
		 ajaxFunction(url,"5");


}

// function to show report after save data
function getReport()
{
	
	var issueNo    = document.forms[0].strTmpReturnNo.value;
	var storeId    = document.forms[0].strTmpStoreNo.value;
	var IndentNo   = document.forms[0].strTmpIndentNo.value;
	var IndentDate = document.forms[0].strTmpIndentDate.value;
    
	if(issueNo!="0")
	{
		getIssueDtls('5', storeId, issueNo,IndentNo,IndentDate);
	}
	document.forms[0].strIssueNo.value ="0";
}

function generateIssueReportFunc(obj,i)
{
	  indexglobal=i;
	  parentPopup=obj;
	  //var issueNo    = document.getElementById('strHlpIssueNo'+i).value;
	  var issueNo    = document.getElementById('strHlpReturnNo'+i).value;
	  var storeId    = document.getElementById('strReturnStoreId'+i).value;
	  var IndentNo   = "0";
	  var IndentDate = document.getElementById('strHlpIndentDate'+i).value
	 // alert("IssueNo::"+issueNo+"::Store ID::"+storeId+"::Indent No::"+IndentNo+"::Indent date::"+IndentDate);
	if(issueNo!="0")
	{
		getIssueDtls('5', storeId, issueNo,IndentNo,IndentDate);
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
 
 
 
 
    