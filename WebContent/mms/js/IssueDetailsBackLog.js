
function view1(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="none";
	
	document.getElementById(obj2).style.display="block";
	
	document.getElementById(obj3).style.display="block";
}
function view2(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="block";
	
	document.getElementById(obj2).style.display="none";
	
	document.getElementById(obj3).style.display="none";
}

function cancelPage()
{
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].submit();
}

function clearMsg()
{
	document.getElementsByName("strStoreName")[0].value="0";
	document.getElementsByName("strIndentingStoreID")[0].value="0";
	document.getElementById("IssueNumberComboId").innerHTML="<select name='strVoucherNo' class='comboMax' ><option value='0'>Select Value</option></select>";  
	
	document.getElementById("showVoucherDiv1").style.display = "none";
	document.getElementById("id1").innerHTML="";  
	document.getElementById("voucherDrugDivId").innerHTML="";  	
	document.forms[0].strStoreName.disabled = false;
	document.forms[0].strIndentingStoreID.disabled = false;
	document.forms[0].strVoucherNo.disabled = false;
	
}

function validate1()
{
	      var hisValidator = new HISValidator("issueBackLogDtl");  
	      document.forms[0].strStoreName.disabled = false;
		  document.forms[0].strIndentingStoreID.disabled = false;
		  document.forms[0].strVoucherNo.disabled = false;
		  document.forms[0].strIndentNumber.disabled = false;
		  
          hisValidator.addValidation("strStoreName","dontselect=0","Please Select DDW Name");
          hisValidator.addValidation("strIndentingStoreID","dontselect=0","Please Select Indenting Store");
		  hisValidator.addValidation("strVoucherNo","req", "Voucher Number is a Mandatory Field" );	
		  hisValidator.addValidation("strVoucherDate","req", "Voucher Date is a Mandatory Field" );		  
          hisValidator.addValidation("strIndentNumber","req", "Indent Number is a Mandatory Field" );
          if(document.forms[0].strIndentNumber.value=='0')
          {
          	alert("Indent Number Should be Greater than Zero!!!");
          	return false;
          }
          hisValidator.addValidation("strVoucherIndentDate","req", "Indent Date is a Mandatory Field" ); 
          hisValidator.addValidation("strVoucherDate", "dtltet="+document.forms[0].strModDate.value, "Voucher Date Must be Less then and Equal "+document.forms[0].strModDate.value+" Date." ); 
          hisValidator.addValidation("strVoucherIndentDate",  "dtltet="+document.forms[0].strVoucherDate.value, "Indent Date Must be Less then Voucher Date." );                    
 		  var retVal = hisValidator.validate(); 

          if(retVal)
          {
                   var drugName ;
			       var batchName ;   
			       var count; 
                   var drugID    = document.getElementsByName("strDrugId");         
	               var batchNo   = document.getElementsByName("strBatchNo");    
	               var issueQty  = document.getElementsByName("strIssueQty");  	 	
      	 	             	 	          	 	               
		           var len = drugID.length;
		           var flag = true;
		           
		           //alert("Batch No Length:::"+batchNo.length);
			       var count = 0,j=0;		
			         
			                 for(var i=0;i<len-1;i++)
						     {
						        //alert("Batch No value:::::"+batchNo[i].value);
 		                        if(drugID[i].value==0 || batchNo[i].value==0 || issueQty[i].value=='')
							    {		
							              count++;
							    }
								    if(count > 0)
								    {
								             alert("Please Select Drung Name , Batch & Issue Qty!!!");
								             flag = false;
									         return false;
								    }
							  }  	
							    
							    if(flag)
							    {
							       for(var i=0;i<len-1;i++)
							       {
							              drugName = drugID[i].value.split("^")[0];
							              batchName = batchNo[i].value;
								                     
								           for(var j=i+1;j<len-1;j++)
								           {					                	
								                if(drugName == drugID[j].value.split("^")[0] && batchName == batchNo[j].value)
								                {
								                   alert("Same Drug Batch Already exist in Vourcher!!!");
								                   flag = false;
								                   return false;
								                   break;
								                   
								                }  
								           }
							          	          	
							       }
							    }
							    if(flag)
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
           }
          else
          {
             return false;
          }
}



function checkValCombo(obj)
{
		var recievedByName=document.forms[0].strVoucherNo[document.forms[0].strVoucherNo.selectedIndex].text;
		if(document.forms[0].strVoucherNo[document.forms[0].strVoucherNo.selectedIndex].text=='New Voucher Number')
		{
			
			document.getElementById("labelId").className="LABEL";
			document.getElementById("labelNameId").innerHTML="";
			document.getElementById("nameOtherFld").style.display="block";
			if(document.forms[0].strNewVoucherNumber.readOnly)
				document.forms[0].strNewVoucherNumber.readOnly=false;
			document.forms[0].strNewVoucherNumber.value="";
			document.getElementById("labelNameId").innerHTML="<font color='red'>*</font>New Voucher No:";
			document.forms[0].strNewVoucherNumber.focus();
			
		
		}
		else 
		if(document.forms[0].strVoucherNo.value!="0" && document.forms[0].strVoucherNo.value!="1")
		{
			
			document.getElementById("labelId").className="LABEL";			
			document.getElementById("labelNameId").innerHTML="";
			document.getElementById("nameOtherFld").style.display="block";
			document.getElementById("labelNameId").innerHTML="New Voucher No:";
			document.forms[0].strNewVoucherNumber.value=recievedByName;
			if(!document.forms[0].strNewVoucherNumber.readOnly)
				document.forms[0].strNewVoucherNumber.readOnly=true;
			document.getElementsByName("strNewVoucherNumber")[0].focus();			
			
			
		}else{
			document.getElementById("labelId").className="CONTROL";
			document.getElementById("nameOtherFld").style.display="none";
			document.getElementById("labelNameId").innerHTML="";
			
		}
		
		
}

function getIndentStoreCombo() 
{

	if(document.forms[0].strStoreName.value=="0")
    {
   		alert("Please select DDW Name");
   		var objVal1 = document.getElementById("IndentingStore");
   	 	objVal1.innerHTML = "<select name = 'strIndentingStoreID' class='comboNormal'><option value='0'>Select Value</option></select>";
   	 	
   		document.forms[0].strStoreName.focus();
   		return false;
    }
	else
	{		
		var objValue = document.forms[0].strStoreName;
		var temp1 = objValue.options[objValue.selectedIndex].value;
		var mode = "IndentStoreCombo";
		var url = "IssueDtlBackLogCNT.cnt?hmode=" + mode + "&modName="+ temp1 + "^0";
		ajaxFunction(url, "1");
		
	}

}

function getVoucherCombo() 
{

	if (document.getElementsByName("strStoreName")[0].value == "0") 
	{
		alert("Please Select DDW Name!!");
	} 
	else 
	if (document.getElementsByName("strIndentingStoreID")[0].value == "0") 
	{
		alert("Please Select Indenting Store From Combo!!");
	} 
	else 
	{
		var temp = document.forms[0].strStoreName.value;
		var mode = "GETVOUCHERCOMBO";
		var url = "IssueDtlBackLogCNT.cnt?hmode=" + mode + "&storeId="
				+ temp + "&itemCatNo="+10+"&fromDate="
				+ document.forms[0].strCurrentDate.value + "&ToDate="
				+ document.forms[0].strCurrentDate.value+  "&IndentingStore="
				+ document.getElementsByName("strIndentingStoreID")[0].value;
		
		
		ajaxFunction(url, "2");
	}

}

function getVoucherDetail()
{
   if(document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].value!='0' && document.forms[0].strIndentingStoreID[document.forms[0].strIndentingStoreID.selectedIndex].value!='0')
   {

    if(document.forms[0].strVoucherNo[document.forms[0].strVoucherNo.selectedIndex].value!='0')
    {
    	document.forms[0].strStoreName.disabled = true;
	    document.forms[0].strIndentingStoreID.disabled = true;
	    document.forms[0].strVoucherNo.disabled = true;
	    
	    document.getElementById("showVoucherDiv1").style.display = "none";
	    document.getElementById("id1").innerHTML="";  
	    document.getElementById("voucherDrugDivId").innerHTML="";  	
	    
    	document.forms[0].strIssueValue.value = document.forms[0].strVoucherNo[document.forms[0].strVoucherNo.selectedIndex].value;
    	
		var mode = "VoucherDetails";
		var url = "IssueDtlBackLogCNT.cnt?hmode=" + mode + "&voucherNo="+ document.forms[0].strVoucherNo[document.forms[0].strVoucherNo.selectedIndex].value+"&strStoreId="+document.forms[0].strStoreName.value;
		ajaxFunction(url, "3");
    }
    else
    { 
    	if(document.forms[0].strVoucherNo[document.forms[0].strVoucherNo.selectedIndex].text=='New Voucher Number')
    	{
    	    document.forms[0].strIssueValue.value = document.forms[0].strVoucherNo[document.forms[0].strVoucherNo.selectedIndex].value;
	    	var mode = "VoucherDetails";
			var url = "IssueDtlBackLogCNT.cnt?hmode=" + mode + "&voucherNo="+0+"&strStoreId="+document.forms[0].strStoreName.value;
			ajaxFunction(url, "3");
    	}
    	else
    	{
    		alert("Please Select Voucher Number!!");
    		return false;
    	}
    }
  }
  else
  {
     if(document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].value=='0')
     {
       alert("Please Select DDW Name!!!");
       return false;
     }
     else
     {
        alert("Please Select Indenting Store Name!!!");
       return false;
     }
  
  }	
} 
function getBatchCombo(obj,index)
{
  if(obj.value!='0')
  {
 		var mode = "GETBATCHCOMBO";
		var url = "IssueDtlBackLogCNT.cnt?hmode=" + mode + "&strDrugID="+ obj.value+"&index="+index;
		ajaxFunction(url, "11");
  }
  else
  {
  
        var objVal1 = document.getElementById("batchID"+index);
		objVal1.innerHTML = "<select name = 'strBatchNo' id='strBatchNo"+index+"' class='comboMax'><option value='0'>Select Value</option></select>";
  
  }
 
    
}
function getMultiRow()
{
	var noOfRow = document.forms[0].strNoOfMultiRow.value;
   	for(var i=0; i<noOfRow;i++)
   	{     		
  		addRows(new Array('strDrugId','strBatchNo','strIssueQty'),new Array('s','s','t'),'1','1','R')
   	}
}

function getAjaxResponse(res, mode) 
{
	var err = document.getElementById("errMsg");
	var temp = res.split("####");
	if (temp[0] == "ERROR") {
		err.innerHTML = temp[1];
		return;
	}
	if (mode == "1") 
	{
		var objVal1 = document.getElementById("IndentingStore");
		objVal1.innerHTML = "<select name = 'strIndentingStoreID' onchange='getVoucherCombo();' class='comboMax'>"
				+ res + "</select>";
	}
	if (mode == "2") 
	{		
		var objVal = document.getElementById("IssueNumberComboId");
		objVal.innerHTML = "<select  name = 'strVoucherNo'  id='strVoucherNo' class='combo1Max'>"+ res + "<option value='0'>New Voucher Number</option></select>";
				
				
	}

	if (mode == "3") 
	{
	  // alert(res);	
	   var temp1 = res.split("@@@@"); 	
	   if(temp1[0].split("^")[0]!='')
	   {
	     document.getElementById("strVoucherDate").value=temp1[0].split("^")[0];
	   } 
	   else
	   {
	   	 document.getElementById("strVoucherDate").value="";
	   }
	   if(temp1[0].split("^")[1]!='')
	   { 
	     document.getElementById("strIndentNumber").value=temp1[0].split("^")[1];
	   }
	   else
	   {
	   	 document.getElementById("strIndentNumber").value="";
	   }
	   if(temp1[0].split("^")[2]!='')
	   {
	     document.getElementById("strVoucherIndentDate").value=temp1[0].split("^")[2];
	   }
	   else
	   {
	   	 document.getElementById("strVoucherIndentDate").value="";
	   }
	   document.getElementById("showVoucherDiv1").style.display = "block";
	  
	   document.getElementById("voucherDrugDivId").innerHTML=temp1[1];
	    
	   
	}
	if (mode == "4") {

		var storeName = document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].text;
		var itemCategName = document.forms[0].strItemCatgCombo[document.forms[0].strItemCatgCombo.selectedIndex].text;

		document.getElementById("breakageItemDtlId").innerHTML = res;
		document.getElementById("breakageItemDtlId").style.display = "block";
		/*
		 * document.getElementById("ItemCatgViewId").style.display="none";
		 * document.getElementById("storeComboNameID").style.display="none";
		 * document.getElementById("storeComboID").innerHTML=storeName;
		 * document.getElementById("itemCategViewNameID").innerHTML=itemCategName;
		 * document.getElementById("storeComboNameID").style.display="block";
		 * document.getElementById("itemCategViewNameID").style.display="block";
		 */
	}
	if (mode == "5") {

		temp = res.split("@");
		i = temp[2];
		document.getElementById("IssueItempopup").innerHTML = temp[0];
		document.getElementById("IssueItempopup").style.display = "block";
		display_popup_menu(parentPopup, 'IssueItempopup', '', '');

	}
	if (mode == "6")
	{

		
		//document.getElementById("ApprovedBy").innerHTML = "<select name = 'strApprovedBy' class='comboNormal' >"
				//+ temp[0] + "</select>";
		
		document.getElementById("VerifiedBy").innerHTML = "<select name = 'strVerifiedBy' class='comboMax'>"
				+ res + "</select>";
		document.getElementById("ReceivedBy").innerHTML = "<select name = 'strReceivedBy' class='comboMax'>"
				+ res + "</select>";
				getIndentStoreBudgetDetails(); 
		

	}
	if (mode == "7") 
	{
		var objVal = document.getElementById("ApprovedBy");
		objVal.innerHTML = "<select name = 'strApprovedBy'  class='comboMax'>"+ res + "</select>";
	}
	if (mode == "8") 
	{
		
		temp = res.split("##");
		var objVal = document.getElementById("budgetIDTwo");
		objVal.innerHTML = "<a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='avlBudgetDtl(this);' TITLE='Click Here Get Budget Details' >"+ temp[0] + "</a>";
		document.forms[0].strAvalaibleBudgetDtl.value=temp[1];
		document.forms[0].strAvalaibleBudget.value=temp[0];
		getPendingDemand();
	
	}
	if (mode == "9") 
	{
		getApprovedByCombo();
		//var objVal = document.getElementById("pendingDemandDivID");
		//objVal.innerHTML =  res;
	}
	
	if (mode == "10") 
	{
		
		temp = res.split("$$$$$$");
		
		document.getElementById("itemHeader").style.display="block";
		var objVal = document.getElementById("pendingIndentItemDetailsID");
		objVal.innerHTML =  temp[1];
		var objVal = document.getElementById("pendingIndentDetailsID");
		objVal.innerHTML =  temp[0];
	}
	
	if (mode == "11") 
	{
	   
	    temp = res.split("@@@");
		var objVal1 = document.getElementById("batchID"+temp[1]);
		objVal1.innerHTML = "<select name = 'strBatchNo' id='strBatchNo"+temp[1]+"' class='comboMax'>"
				+ temp[0] + "</select>";
		var objVal2 = document.getElementById("unitID"+temp[1]);	
		objVal2.innerHTML =	temp[2];
				
	}
	
	
	
	
	
}