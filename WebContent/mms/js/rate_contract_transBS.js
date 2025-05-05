
// called from UTL PAGE to view or terminate
function chkUserDefinedFunc(these){
	var checkCount=0;
	var check=document.getElementsByName("chk");
	for(i=0;i<check.length;i++){
		if(check[i].checked==true)
			checkCount++;
	}
	if(checkCount==1 )
		{
		if(document.forms[0].combo[3].value=="1" && document.forms[0].combo[1].value!="0" && document.forms[0].combo[2].value!="0")
		{
		enableButton("Renew");
		enableButton("View");
		enableButton("Cancel");
		enableButton("RC EXTN");
		enableButton("MODIFY");
		}
		else if(document.forms[0].combo[3].value=="3" && document.forms[0].combo[1].value!="0" && document.forms[0].combo[2].value!="0")
		{
			enableButton("Renew");
			disableButton("View");
			disableButton("Cancel");
			disableButton("RC EXTN");
			disableButton("MODIFY");
		}
		else{
			//enableButton("View");
			//disableButton("Renew");
		//	enableButton("Renew");
		//	enableButton("RC EXTN");
			disableButton("Cancel");
		}
		
		
		}
	else
		{
		disableButton("Renew");
		disableButton("View");
		disableButton("Cancel");
		disableButton("RC EXTN");
		disableButton("MODIFY");
		
		}
}


function validateAddRateContract(form1,mode){
	cmbVal1="";
	cmbVal2="";
	cmbVal3="";
	with(form1){
		if(mode=="ADD")
		{
		
		//	alert("document.forms[0].combo[0].value ->"+document.forms[0].combo[0].value+" document.forms[0].combo[1].value-> "+document.forms[0].combo[1].value+" document.forms[0].combo[2].value->"+document.forms[0].combo[2].value);
			if(document.forms[0].combo[0].value=="0" ){
				alert("Please Select Item Cateogry");
				return;
			}
			else if(document.forms[0].combo[1].value=="0" ){
				alert("Please Select Supplier Name");
				return;
			}
			else if(document.forms[0].combo[2].value=="0" ){
				alert("Please Select Contract Type");
				return;
			}
			else{
				cmbVal1 =combo[0].options[combo[0].selectedIndex].text;
				cmbVal2 =combo[1].options[combo[1].selectedIndex].text;
				cmbVal3 =combo[2].options[combo[2].selectedIndex].text;
			comboValue.value = cmbVal1 +"^"+cmbVal2 +"^"+cmbVal3;
			add(mode);
			}
			
		}
		
	}
}




function validateRenew(form1,mode){
	cmbVal1="";
	cmbVal2="";
	cmbVal3="";
	with(form1){
		if(mode=="RENEW")
		{
				cmbVal1 =combo[0].options[combo[0].selectedIndex].text;
				cmbVal2 =combo[1].options[combo[1].selectedIndex].text;
				cmbVal3 =combo[2].options[combo[2].selectedIndex].text;
			comboValue.value = cmbVal1 +"^"+cmbVal2 +"^"+cmbVal3;
			add(mode);
			}
			
		}
		
	}
	
	

function validateCancelRateContract(form1,mode){
	cmbVal1="";
	cmbVal2="";
	cmbVal3="";
	with(form1){
		if(mode=="CANCEL")
		{
		var checkCount=0;
		var check=document.getElementsByName("chk");
		for(i=0;i<check.length;i++){
			if(check[i].checked==true)
			checkCount++;
		}
			if(checkCount!=0) 
   	 	  {
   	    	 res=prompt("ENTER REMARKS FOR CANCELATION!","");
        	 if(!res=="")
         	{
           	var conf = confirm("If Contract has been Renewed \n	Then All Contact will be cancelled \n Are you sure to cancel the Contract!!!");
           	if(conf == true)
           	{
             var chkObj = document.getElementsByName("chk");  
             for(var i=0; i<check.length; i++) 
   	 	     {
   	 	       if(chkObj[i].checked)
   	 		   {
   	 		       chkObj[i].value = chkObj[i].value+"@"+res;
   	 		   }		
   	 		 }
   	 		 add("CANCELRECORD");
           }
           else
           {
             return false;
           }
           
          }
		}
		
	}
}
}


function validateViewRateContract(form1,mode){
	cmbVal1="";
	cmbVal2="";
	cmbVal3="";
	with(form1){
		if(mode=="VIEW")
		{
				cmbVal1 =combo[0].options[combo[0].selectedIndex].text;
				cmbVal2 =combo[1].options[combo[1].selectedIndex].text;
				cmbVal3 =combo[2].options[combo[2].selectedIndex].text;
			comboValue.value = cmbVal1 +"^"+cmbVal2 +"^"+cmbVal3;
			add(mode);
			}
			
		}
		
	}
	
function validateRateContractModify(form1,mode){
	cmbVal1="";
	cmbVal2="";
	cmbVal3="";
	with(form1){
		if(mode=="MODIFY")
		{
				cmbVal1 =combo[0].options[combo[0].selectedIndex].text;
				cmbVal2 =combo[1].options[combo[1].selectedIndex].text;
				cmbVal3 =combo[2].options[combo[2].selectedIndex].text;
			comboValue.value = cmbVal1 +"^"+cmbVal2 +"^"+cmbVal3;
			add(mode);
			}
			
		}
		
	}



function GroupCombo()
{
	
	var url;
	 var mode = 'GROUPNAME';   
	 url="RateContractDtlTransBSCNT.cnt?hmode=GROUPNAME&ItemCategoryNo="+document.forms[0].strItemCategoryNo.value;     
	 
	 ajaxFunction(url,"1 ");
}
// getAjaxResponse used from searchItems_util.js
// not used 
function getAjaxResponse(res,mode)
{
		var objVal;
	   if(mode=="1"){   
	   		var err = document.getElementById("errMsg");
		 		var temp1 = res.split("####");
			         
        		 if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
        			 }
				else{
				objVal= document.getElementById("GroupDivId"); 
				objVal.innerHTML = "<select name ='strGroupIdForItemSearch' onchange='resetList();' >" + res + "</select>"; 
				}
		 }
		
}
	


function cancelPage()
{
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
	
}
    
// call on cancel button 
function cancel(){
	document.forms[0].hmode.value="RETLISTPAGE"; 
	document.forms[0].submit();
}
function clearPage()
{
   document.getElementById("id1").innerHTML = "";
   document.forms[0].reset();
   
}

// for item details , called on item search button

function getItemSelectPopup()
{
		var strModeVal 					= "2" ; 
		var strItemCategory 			= document.forms[0].strItemCategoryNo.value ;
		var strSupplierId   			= document.forms[0].strSupplierId.value ;  
		var strContractTypeId   		= document.forms[0].strContractTypeID.value ; 
		//alert("strItemCategory"+strItemCategory);
		//alert("strSupplierId"+strSupplierId);
		//alert("strContractTypeId"+strContractTypeId);
		var strRequestType				= "67";
		var strFromStoreId 				= "0";
		var strToStoreId  				= "0";
		
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strTenderItemNo','strRate','strUnitName','strRateContQty','strSecurityAmtPercent','strSecurityAmt');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t','t','s','t','t','t');
		// for mode val 2
		var strMultiRowFetchDataArray 	= new Array('1','0^strUnitName^invokeCheckQty');
		
		var testFunction                = "setQtyDetails";
		var arg                         = " ";  
		
		var userInfo = "0";
		var unitMode = "1";  // only base unit  1 Means Only Base Unit Show 0 Means All Unit Show in Unit Combo
		
		var layerIndex = "1";		
		var strUserInfo = strSupplierId+'^'+strContractTypeId; 	 //    Orignal Vale
	    
	    //searchItemsWithUserFunction ( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg , userInfo , unitMode );
	    searchItems(strModeVal, strItemCategory, strRequestType, strFromStoreId, strMultiRowCompArray, strMultiRowCompTypeArray,strMultiRowFetchDataArray, layerIndex,strUserInfo);
}


function notGreaterThanCent(_these)
{
	var nNum = _these.value;
	if(nNum>99)
		_these.value = _these.value.substr(0,2);		
		
}

function invokeCheckQty(mode, index, unitObject)
{		
		CalculateSecurityAmt(index);						 
} 
function CalculateSecurityAmt(index)
{
	  	var  rate  = "";    
	  	var  qty   = "";
	  	var  finalRate  = 0.00;
	  	var  cost  = 0.00;
	  	var  rate_unit_base_value = "";
        
        rate    = trimAll(document.getElementById("strRate"+index).value);
        qty     = trimAll(document.getElementById("strRateContQty"+index).value);
       
		if(rate == "" || rate.length <=0)
		{
			rate = "0";
		}
		if(qty == "" || qty.length <=0)
		{
			qty = "0";
		}		
		if(document.getElementById("strUnitName"+index).value!="0")
        {
          rate_unit_base_value = document.getElementById("strUnitName"+index).value.split("^")[1];
          cost = parseFloat((qty  * rate)/rate_unit_base_value);
		}
		else
		{
		   cost = parseFloat(qty  * rate);
		}
		var  amtPerecentage = "";
		var  amtPerecentage = trimAll(document.getElementById("strSecurityAmtPercent"+index).value);
			   
	    if(amtPerecentage != "" && amtPerecentage.length > 0)
	    {
	    	finalRate = ( cost * parseFloat(amtPerecentage))/100;
	    }
	    else
	    {
	        finalRate  = 0;
	    }
	    
	    document.getElementById("strSecurityAmt"+index).value = roundValue(finalRate, 2);	    
} 
	
function validate1()
{   
	                    
             var hisValidator = new HISValidator("rateContractDtlBean"); 
             var retVal=false;
             var retVal1=false;
             
             hisValidator.addValidation("strDeliveryDays",     "req", "Delivery Day(s) is a Mandatory Field" );
             if(parseInt(document.forms[0].strDeliveryDays.value)==0)
             {
             	alert("Please Enter Delivery Day(s) Greater than Zero!!!");
             	return false;
             }
             hisValidator.addValidation("strContractFromDate", "req", "Contract From Date is a Mandatory Field" );
             hisValidator.addValidation("strContractToDate",   "req", "Contract To Date is a Mandatory Field" );
             //hisValidator.addValidation("strContractFromDate", "dtgtet="+document.forms[0].ctDate.value+"", "Contract From Date should be greater than or Equal to Current Date");
             hisValidator.addValidation("strContractToDate",   "dtgtet="+document.forms[0].strContractFromDate.value+"", "Contract To Date should be greater than or Equal to Contract From Date");
			 hisValidator.addValidation("strTenderNo",         "req", "Tender Number is a Mandatory Field" ); 			 
			 hisValidator.addValidation("strTenderDate",       "req", "Tender Date is a Mandatory Field" );
             hisValidator.addValidation("strTenderDate",       "dtltet="+document.forms[0].strContractFromDate.value+"", "Tender Date should be Less than or Equal to Contract From Date");
             //hisValidator.addValidation("strTax",              "req", "Tax is a Mandatory Field" ); 
             hisValidator.addValidation("strRemarks",          "maxlen=100", "Remarks should have less than or equal to 100 Characters" ); 
             retVal = hisValidator.validate(); 
            
             var itemDtls = document.getElementsByName("strRate");
     	     var itemDtlsLength = itemDtls.length;
	       	 if(retVal)
	      	 {
			      		if(itemDtlsLength==1)
			      		{
				      		 alert("Please search an Drug by Click on Search Button");  
				      		 return false;
			      		}  
			      		else
			      		{
				           	 hisValidator.addValidation("strRate", "req", "Rate is a Mandatory Field" );  
				             hisValidator.addValidation("strRate", "amount=11,2", "Rate should be in format 000000000.00" );
				           	 hisValidator.addValidation("strUnitName", "dontselect=0", "Please select a unit" );  					           	 			           	 				           	 
				           	 //hisValidator.addValidation("strRateContQty", "req", "Quantity is a Mandatory Field" );
				           	 //hisValidator.addValidation("strSecurityAmtPercent", "req", "Security Amount(%) is a Mandatory Field" );				           	 				           	 
				           	 //hisValidator.addValidation("strSecurityAmt", "req", "Rate is a Mandatory Field" );  
				             //hisValidator.addValidation("strSecurityAmt", "amount=11,2", "Security Amount should be in format 000000000.00" );
				           	hisValidator.addValidation("strItemTax", "req", "Tax is a Mandatory Field" );  
				           	 if(document.getElementsByName("strItemCategoryNo")[0].value == 10)
				           	 hisValidator.addValidation("strShelfLife", "req", "Shelf Life is a Mandatory Field" );
				           	 
				           	 
				           	var itemDtls = document.getElementsByName("strRate");
				            var itemDtlsLength = itemDtls.length;
				            for(var i=0;i<itemDtlsLength;i++)
				            {
				        	     	if(document.getElementsByName("strImportedType")[i].checked == true)
				        	     	{
				        	     		document.getElementsByName("strImportedType")[i].value="1";
				        	     	}
				        	     	else
				        	     	{
				        	     		document.getElementsByName("strImportedType")[i].value="0";
				        	     	}
				        	     	
				        	     	//alert(document.getElementsByName("strRCChk")[i].value);
				        	}
				            /*for(var i=0;i<itemDtlsLength;i++)
				            {
					            if(document.getElementsByName("strRCChk")[i].checked == true)
			        	     	{
			        	     		document.getElementsByName("strRCChk")[i].value="1";
			        	     	}
			        	     	else
			        	     	{
			        	     		document.getElementsByName("strRCChk")[i].value="0";
			        	     	}
			        	     	alert("i+ "+document.getElementsByName("strRCChk")[i].value);
				            }*/
				           	
				            retVal1 = hisValidator.validate(); 
			            } 
	         }
	         if(retVal1)
	         {
	          				var conf = confirm("You Are Going To Save Records" );
							                       if(confirm(" Are You Sure ?"))
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
	
function RCChk(obj,index)
{
	
	if(obj.checked)
    {
    	obj.value="1";
    }
    else
    {
    	obj.value="0";
    }
}
function ImportedTypeChk(obj,index)
{
	var itemDtls = document.getElementsByName("strRate");
    var itemDtlsLength = itemDtls.length;
    
    for(var i=0;i<itemDtlsLength;i++)
    {
	     	if(document.getElementsByName("strImportedType")[i].checked == true)
	     	{
	     		document.getElementsByName("strImportedType")[i].value="1";
	     	}
	     	else
	     	{
	     		document.getElementsByName("strImportedType")[i].value="0";
	     	}	
	}
	
}



function validateRateContractExtnUpdate()
{   
	                    
             var hisValidator = new HISValidator("rateContractDtlBean");
			
			 hisValidator.addValidation("strLettrNo", "req", "Letter No. is a Mandatory Field" );
			 hisValidator.addValidation("strLetterDate", "req", "Letter Date is a Mandatory Field" );			 
			 hisValidator.addValidation("strLetterDate", "dtltet="+document.forms[0].ctDate.value+"", "Letter Date should be Less than or Equal to Current Date");
             
             hisValidator.addValidation("strNewContractToDate",   "req", "Contract To Date is a Mandatory Field" );
             //hisValidator.addValidation("strContractFromDate", "dtgtet="+document.forms[0].ctDate.value+"", "Contract From Date should be greater than or Equal to Current Date");
             hisValidator.addValidation("strNewContractToDate",   "dtgtet="+document.forms[0].ctDate.value+"", "Contract To Date should be greater than or Equal to Current Date");
             hisValidator.addValidation("strNewContractToDate",   "dtgtet="+document.forms[0].strContractToDate.value+"", "Contract To Date should be greater than or Equal to Previous Contract To Date ["+ document.forms[0].strNewContractToDate.value +" ]");
             hisValidator.addValidation("strRemarks", "req", "Remarks is a Mandatory Field." );
             hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" ); 
             
             retVal = hisValidator.validate(); 
            
            if(retVal)
	         {		           
      			   var conf = confirm("You Are Going To Save Records" );
                   if(conf)
                   {
	                   if(confirm(" Are You Sure ?"))
					   {				   	    
							 document.forms[0].hmode.value = "insertRateContractExtension";
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




function validateRateContractExtn(form1,mode){
	cmbVal1="";
	cmbVal2="";
	cmbVal3="";
	with(form1){
		if(document.forms[0].combo[0].value=="0" ){
			alert("Please Select Item Cateogry");
			return;
		}
		else if(document.forms[0].combo[1].value=="0" ){
			alert("Please Select Supplier Name");
			return;
		}
		else if(document.forms[0].combo[2].value=="0" ){
			alert("Please Select Contract Type");
			return;
		}
		else{
		if(mode=="RCEXTN")
		{
				cmbVal1 =combo[0].options[combo[0].selectedIndex].text;
				cmbVal2 =combo[1].options[combo[1].selectedIndex].text;
				cmbVal3 =combo[2].options[combo[2].selectedIndex].text;
			comboValue.value = cmbVal1 +"^"+cmbVal2 +"^"+cmbVal3;
			add(mode);
			}
			
		}
	}
}	


function checkMsg() {
	var err=document.getElementById("errID");
	var nor=document.getElementById("normalMsg");
	var warn=document.getElementById("wrnID");
	
	if (err.innerHTML != "") {
		
		err.innerHTML="<i class='fas fa-exclamation-triangle'></i>"+"&nbsp;&nbsp;&nbsp;<strong>Error!</strong>&nbsp;&nbsp;"+err.innerHTML+"<button type='button' class='close' data-dismiss='alert'>&times;</button>";
		err.style.display = "";
		
	}
	if (nor.innerHTML != "") {
		nor.innerHTML="<i class='far fa-check-circle'></i>"+"&nbsp;&nbsp;&nbsp;<strong>Success!</strong>&nbsp;&nbsp;"+nor.innerHTML+"<button type='button' class='close' data-dismiss='alert'>&times;</button>";
		nor.style.display = "";
	}
	if (warn.innerHTML != "") {
		warn.innerHTML="<i class='fas fa-bell'></i>"+"&nbsp;&nbsp;&nbsp;<strong>Warning!</strong>&nbsp;&nbsp;"+warn.innerHTML+"<button type='button' class='close' data-dismiss='alert'>&times;</button>";
		warn.style.display = "";
	}
	

}