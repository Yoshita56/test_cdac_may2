
function checkDecimalValue(obj)
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
		
	if(checkRate[1].length > 4 )
	{
		alert("Please Enter the digits after decimal places Less than Equal to 4 digits !");
		obj.value = checkRate[0]+"."+checkRate[1].substr(0,4);
		return false;
	}	
}

function showFirstBatchRow(){
	
	document.getElementById("strNoOfMultiRow").value=1;
	getMultiRow(document.getElementById("strNoOfMultiRow"));	
	
}

function showFirstBatchRowModify(){
	
	document.getElementById("strNoOfMultiRow").value=1;
	getMultiRow(document.getElementById("strNoOfMultiRow"));	
	getStockDetailsModify("1-1",document.getElementById("strMultiRowExistingBatchId#delIndex#"));
}

function getMultiRow(obj)
{
	
	
	var totRow = 0;
	
	if(document.getElementById("strMultiRowItemId").value!='0')
	{
		if(parseInt(obj.value,10) > 0)
		{
			totRow = parseInt(document.getElementsByName("rowLength1")[0].value,10);
			totRow = totRow + parseInt(obj.value,10);
				
			//batch no is non-mandatory
			if(document.forms[0].strBatchMandFlg.value == "0")
			{
				if(totRow > 1)
				{
					alert("Batch No is not mandatory for the selected item !!\n\nOnly one row is allowed");
					obj.value = "";
					obj.focus();
					return;
				}
			}
			else
			{
				if(totRow > 20)
				{
					alert("Maximum limit is 20 Batch(s)");
					obj.value = "";
					obj.focus();
					return;
				}		
			}
			
			for(var i=0; i<obj.value;i++)
		 	{   
				addRows(new Array( 'strMultiRowExistingBatchId','strMultiRowFinalBatchNo','strMultiRowActiveQty','strMultiRowQuarnQty','strMultiRowInActiveQty','strMultiRowRate','strMultiRowRateUnitId','strMultiRowExpiryDate', 'strMultiRowMfgDate','strMultiRowMfgId','strMultiRowMfgName','strMultiRowPONo','strMultiRowTenderNo','strMultiRowInvoiceNo','strMultiRowInvoiceDate'),new Array('s','t','t','t','t','t','s' ,'d','d','s','t','t','t','t','d'),'1','1','R');
		 	 generateSlNo();
		 	}
			 	for(var j=0; j<document.getElementsByName("strMultiRowExistingBatchId").length;j++)
			 	{
			 		//alert('in for loop'+document.getElementById("strMultiRowItemId").value.split("^")[11]+'^'+document.getElementById("strMultiRowItemId").value.split("^")[12]+'^'+document.getElementById("strMultiRowItemId").value.split("^")[13]);
			 		document.getElementsByName("strMultiRowRate")[j].value = document.getElementById("strMultiRowItemId").value.split("^")[14].split("#")[0];			 		
			 		document.getElementsByName("strMultiRowMfgId")[j].value = document.getElementById("strMultiRowItemId").value.split("^")[4].split("#")[1];//document.getElementById("strMultiRowItemId").value.split("^")[10];
			 	// document.getElementsByName("strMultiRowRateUnitId")[j].value  = document.getElementById("strMultiRowItemId").value.split("^")[1];//document.getElementById("strMultiRowItemId").value.split("^")[11]+'^'+document.getElementById("strMultiRowItemId").value.split("^")[12]+'^'+document.getElementById("strMultiRowItemId").value.split("^")[13];
			 	 document.getElementsByName("strMultiRowMfgName")[j].value = document.getElementsByName("strMultiRowMfgId")[j].options[document.getElementsByName("strMultiRowMfgId")[j].selectedIndex].text;
			 		//document.getElementsByName("strMultiRowRateUnitId")[j].options[document.getElementsByName("strMultiRowRateUnitId")[j].selectedIndex].text
			 	}
		 	
		 	obj.value = "";
		}
		else
		{
			alert("Please select No of batch value");
			obj.focus();
		}
			
	}
	else if(document.getElementById("strMultiRowItemId").value =='0')
		{
			alert("Please select Drug Name !!");
			obj.focus();
		}
		else if(document.getElementById("strProgrammeId").value =='0')
		{
			alert("Please select Programme Name!!");
			obj.focus();
		}
}

function checkQty(obj,index)
{	
     if(parseInt(document.getElementById("strMultiRowActiveQty"+index).value.trim().length)== 0 && parseInt(document.getElementById("strMultiRowQuarnQty"+index).value.trim().length)== 0 && parseInt(document.getElementById("strMultiRowInActiveQty"+index).value.trim().length)== 0)
     {
     	alert("Please Enter either Active Quantity Or Quarentine Quantity Or In-Active Quantity!!!");
     	document.getElementById("strMultiRowActiveQty"+index).focus();
     	obj.value='';
     	return false;
     }
}


function checkQtyValidaion(mode,obj,index)
{
	if(obj.value.length>0)
	{
     if(mode=='1')
     {
     	//document.getElementsByName("strMultiRowActiveQty")[0].disabled = false; 
     	document.getElementById("strMultiRowQuarnQty"+index).disabled = true; 
     	document.getElementById("strMultiRowInActiveQty"+index).disabled = true;     						
     	document.getElementById("strMultiRowRate"+index).focus();
     }
     if(mode=='2')
     {
     	document.getElementById("strMultiRowActiveQty"+index).disabled = true; 
     	//document.getElementsByName("strMultiRowQuarnQty")[0].disabled = false; 
     	document.getElementById("strMultiRowInActiveQty"+index).disabled = true; 
     	document.getElementById("strMultiRowRate"+index).focus();
     }
     if(mode=='3')
     {
     	document.getElementById("strMultiRowActiveQty"+index).disabled = true; 
     	document.getElementById("strMultiRowQuarnQty"+index).disabled = true; 
     	//document.getElementsByName("strMultiRowInActiveQty")[0].disabled = false; 
     	document.getElementById("strMultiRowRate"+index).focus();
     }
	}
	else
	{
		document.getElementById("strMultiRowActiveQty"+index).disabled = false; 
     	document.getElementById("strMultiRowQuarnQty"+index).disabled = false; 
     	document.getElementById("strMultiRowInActiveQty"+index).disabled = false; 
     	if(mode=='1')
        {
     	document.getElementById("strMultiRowActiveQty"+index).focus();
        }
        if(mode=='2')
        {
     	document.getElementById("strMultiRowQuarnQty"+index).focus();
        }
        if(mode=='3')
        {
     	document.getElementById("strMultiRowInActiveQty"+index).focus();
        }
        
	}
    
    
	
}
function OnLoadFunction()
{
	 hideMenuFrame();
	if(document.forms[0].strIsDataSaveFlg.value==1){
		alert(document.forms[0].strSavedDrugName.value +"  with Batch number/numbers "+document.forms[0].strSavedBatchName.value+" are added sucessfully.");
		document.forms[0].strIsDataSaveFlg.value=0;
	} 
	  
}


function ClearPage()
{
	
	              var conf = confirm("You are going to reset the data");
		          if(conf == true)
		          {
		               var conf1 = confirm("Are you sure !!!");
		               if(conf1 == true)
		               {	              
		               	          document.forms[0].reset();
		               	          document.getElementById("strMultiRowItemId").disabled =false;
		               	          document.getElementById("strSearchDrug").disabled =false;
                                  document.getElementById("id1").innerHTML = "";
                                  document.getElementById("DrugNameId").innerHTML="";
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
	var actQty = 0;
	var quarQty = 0;
	var inActQty = 0;
	var qtyFlag = 0;
	var batchCount = 0;
	var delFlag = 0;
	
  var activeQty           = document.getElementsByName("strMultiRowActiveQty");   
  var quarntineQty        = document.getElementsByName("strMultiRowQuarnQty"); 
  var inActiveQty         = document.getElementsByName("strMultiRowInActiveQty");    
  var existingBatch       = document.getElementsByName("strMultiRowExistingBatchId");  
  var finalBatch          = document.getElementsByName("strMultiRowFinalBatchNo"); 
  var strRowIndex         = document.getElementsByName("strRowIndex");          	
  var len                 = existingBatch.length;
  if(len == 1)
		alert("Please select at least one batch !!");
	else
	{	
		if(document.forms[0].strBatchMandFlg.value=='1')
		{	       
	       var count = 0;		
	            
	       for(var i=0;i<len-1;i++)
	       {
	    	   if(parseFloat(document.getElementsByName("strMultiRowRate")[i].value) <= 0.00)
	    		{
	    		   alert("Enter rate greater than 0");
	    		   document.getElementsByName("strMultiRowRate")[i].focus();
	    		   document.getElementsByName("strMultiRowRate")[i].value="";
	    		   return false;
	    		}
	       		delFlag = 0;
	       		
	       		if(i != len-2)
	       		{		       	           	
		       	    if(finalBatch[i].value.length == 0)
		       	    { 
		       	    	deleteRow(strRowIndex[i].value,1,0);
		       	    	delFlag = 1;
		       	    }
		       	    else
		       	    	batchCount++;		
	       		}
	       		else
	       		{
	       			if(batchCount > 0) 
	       			{
	       				if(finalBatch[i].value.length == 0)
	       				{ 
	       					deleteRow(strRowIndex[i].value,1,0);
	       					delFlag = 1;
	       				}
	       			}
	       		}	
               	
               	if(delFlag == 0)
               	{    		       		   
		       		if(activeQty[i].value.length == 0)
		       			actQty = 0;
		       		else
		       			actQty = parseInt(activeQty[i].value,10);	
		       			
		       		if(quarntineQty[i].value.length == 0)
		       			quarQty = 0;
		       		else
		       			quarQty = parseInt(quarntineQty[i].value,10);	
		       			
		       		if(inActiveQty[i].value.length == 0)
		       			inActQty = 0;
		       		else
		       			inActQty = parseInt(inActiveQty[i].value,10);			
		       		
		       		if(actQty == 0 && quarQty == 0 && inActQty == 0)	 
		       			qtyFlag = 1;
               	}
	       		
	            count++;         	
	       } 
	       
		   if(count == (len-1))
		   {
		   		if(qtyFlag == 0)        
					validateMultiRowII();
				else
				{
					alert("Please enter Qty");
					activeQty[lastIndex].focus();
				}	
		   }
		}
		else
		{
			if(activeQty[0].value.length == 0)
	   			actQty = 0;
	   		else
	   			actQty = parseInt(activeQty[0].value,10);	
	   			
	   		if(quarntineQty[0].value.length == 0)
	   			quarQty = 0;
	   		else
	   			quarQty = parseInt(quarntineQty[0].value,10);	
	   			
	   		if(inActiveQty[0].value.length == 0)
	   			inActQty = 0;
	   		else
	   			inActQty = parseInt(inActiveQty[0].value,10);			
	   		
	   		if(actQty == 0 && quarQty == 0 && inActQty == 0)
	   			qtyFlag = 1;
	   			
			if(qtyFlag == 0)        
				validateMultiRowII();
			else
			{
				alert("Please enter Qty");
				activeQty[0].focus();
			}	
		}
	}
   	
}
function validateMultiRowII()
{	
   var flag = 0;
   var batchNo = "";
   var cmpBatchNo = "";
   
   var saveObj = document.getElementById("saveId");

	if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	{	
		
      
       //var itemId  			   = document.getElementsByName("strMultiRowItemId");         
       var existingBatch       = document.getElementsByName("strMultiRowExistingBatchId");    
       var finalBatch          = document.getElementsByName("strMultiRowFinalBatchNo");  	 	
       var activeQty           = document.getElementsByName("strMultiRowActiveQty");   
       var quarntineQty        = document.getElementsByName("strMultiRowQuarnQty"); 
       var inActiveQty         = document.getElementsByName("strMultiRowInActiveQty");    
       var mfgName             = document.getElementsByName("strMultiRowMfgName");  	 	
       var len = existingBatch.length;
       
       for(var j=0;j<len-1;j++)
   		{
   			batchNo = finalBatch[j].value.toUpperCase();
   			
   			for(var k=j+1;k<len-1;k++)
   			{
   				cmpBatchNo = finalBatch[k].value.toUpperCase();
   				if(cmpBatchNo == batchNo)
   				{
   					alert("Duplicate Batch not allowed !!");
   					finalBatch[k].focus();
   					saveObj.style.display = '';
   					return false;
   				}		
   			}	
   		}
       		
       var hisValidator = new HISValidator("itemInventoryProgramSurgicalTransBean");
       
   	   hisValidator.addValidation("strMultiRowItemId","dontselect=0","Please select a value from Drug name Combo" );
  	   hisValidator.addValidation("strMultiRowRateUnitId","dontselect=0","Please select Rate Unit Combo" );
  	 hisValidator.addValidation("strMultiRowRateUnitId","req","Please select Rate Unit Combo" );
  	   hisValidator.addValidation("strMultiRowMfgId","dontselect=0","Please select Manufacturer Name" );
  	 hisValidator.addValidation("strMultiRowMfgId","req","Please select Manufacturer Name" );
  	   hisValidator.addValidation("strMultiRowRate","req","Please select Rate" );
  	   
  	   if(document.forms[0].strBatchMandFlg.value=='1')
  	   		hisValidator.addValidation("strMultiRowFinalBatchNo","req","Please enter Batch" );
  	   
  	   if(document.forms[0].strExpMandFlg.value=='1')
  	   		hisValidator.addValidation("strMultiRowExpiryDate","req","Please enter Expiry Date" );
  	   	
  	  // if(document.forms[0].strMfgMandFlg.value=='1')
  	   		//hisValidator.addValidation("strMultiRowMfgDate","req","Please enter Mfg Date" );
  	   		
  	   //hisValidator.addValidation("strMultiRowMfgName","req","Please enter Manufacturer Name" );  	
  	   		
       var retVal1 = hisValidator.validate();        
       if(retVal1)
       {
       	  
    	   var strMfgDate           = document.getElementsByName("strMultiRowMfgDate");
	       var strExpiryDate        = document.getElementsByName("strMultiRowExpiryDate");  
	       for(var nTmpI=0;nTmpI<strMfgDate.length-1; nTmpI++)
			{
       		/*if(trimAll(strExpiryDate[nTmpI].value).length > 0) 
				{
					var nFlag = compareDate(trimAll(document.getElementsByName("strCtDate")[0].value),trimAll(strExpiryDate[nTmpI].value)); 				
					if(nFlag.mode == 2 || nFlag.mode == 1)
					{
						alert("Expiry Date must be greater then Current Date.");
						return false;
					}
				}*/
				
				if(trimAll(strMfgDate[nTmpI].value).length > 0) 
				{
					var nFlag = compareDate(trimAll(document.getElementsByName("strCtDate")[0].value),trimAll(strMfgDate[nTmpI].value)); 				
					if(nFlag.mode < 2)
					{
						alert("Manufacturer Date must be less then Current Date.");
						return false;
					}
				}			
				
			}
	       
    	   
    	   var conf = confirm("You Are Going To Save Records");
          if(conf == true)
          {
          	   var conf1 = confirm("Are you sure !!!");
               if(conf1 == true)
               {   			
            	   saveObj.style.display = "none"; 
            	   for(var i=0;i<len-1;i++)
			       {	
		       	 	 finalBatch[i].disabled   = false;												           								           	
		           	 activeQty[i].disabled    = false;
		           	 quarntineQty[i].disabled = false;
		           	 inActiveQty[i].disabled  = false;
		           	 mfgName[i].disabled      = false;
		           	 
		           	 if(trimAll(finalBatch[i].value).length == 0) 
		             	finalBatch[i].value='NA';
		             
		             /*if(mfgDate[i].value.length>0)		               
					 	mfgDate[i].value = convertDate_ddmonyyyy(mfgDate[i].value);
					
					 if(expDate[i].value.length>0)					    
						expDate[i].value = convertDate_ddmonyyyy(expDate[i].value);*/
						
					 if(activeQty[i].value.length == 0)
					 	activeQty[i].value = "0";
					 
					 if(quarntineQty[i].value.length == 0)
					 	quarntineQty[i].value = "0";
					 	
					 if(inActiveQty[i].value.length == 0)
					 	inActiveQty[i].value = "0";		
					 			 	
					 		
			       }
               	   document.forms[0].strSelDrugName.value = document.getElementById("DrugNameId").innerHTML;		       
			       flag = 1;
			       document.forms[0].strMultiRowItemId.disabled = false;
		           document.forms[0].hmode.value = "INSERT";	                                               
                   document.forms[0].submit();
               }
          }
       }
       
       if(flag == 0)
	   {
	   		saveObj.style.display = '';
	        return false;	
	   }
	}
   
}


function validateMultiRowModify()
{
	var actQty = 0;
	var quarQty = 0;
	var inActQty = 0;
	var qtyFlag = 0;
	var batchCount = 0;
	var delFlag = 0;
	
  var activeQty           = document.getElementsByName("strMultiRowActiveQty");   
  var quarntineQty        = document.getElementsByName("strMultiRowQuarnQty"); 
  var inActiveQty         = document.getElementsByName("strMultiRowInActiveQty");    
  var existingBatch       = document.getElementsByName("strMultiRowExistingBatchId");  
  var finalBatch          = document.getElementsByName("strMultiRowFinalBatchNo"); 
  var strRowIndex         = document.getElementsByName("strRowIndex");          	
  var len                 = existingBatch.length;
  if(len == 1)
		alert("Please select at least one batch !!");
	else
	{	
		if(document.forms[0].strBatchMandFlg.value=='1')
		{	       
	       var count = 0; 
	       for(var i=0;i<len-1;i++)
	       {
	       		delFlag = 0;
	       		
	       		if(i != len-2)
	       		{		       	           	
		       	    if(finalBatch[i].value.length == 0)
		       	    { 
		       	    	deleteRow(strRowIndex[i].value,1,0);
		       	    	delFlag = 1;
		       	    }
		       	    else
		       	    	batchCount++;		
	       		}
	       		else
	       		{
	       			if(batchCount > 0) 
	       			{
	       				if(finalBatch[i].value.length == 0)
	       				{ 
	       					deleteRow(strRowIndex[i].value,1,0);
	       					delFlag = 1;
	       				}
	       			}
	       		}	
               	
               	if(delFlag == 0)
               	{    		       		   
		       		if(activeQty[i].value != "")
		       			actQty = parseInt(activeQty[i].value,10);
		       			       			
		       		if(quarntineQty[i].value != "")
		       			quarQty = parseInt(quarntineQty[i].value,10);		       		
		       			
		       		if(inActiveQty[i].value != "")
		       			inActQty = parseInt(inActiveQty[i].value,10);	
		       				
		       		
		       		if(activeQty[i].value == "" && quarntineQty[i].value == "" && inActiveQty[i].value == ""){
		       			alert("All quantity can not be blank");
		       			return false;
		       		}
		       		if((actQty =="0" && quarQty =="" && inActQty=="")||(actQty =="" && quarQty =="0" && inActQty=="")||(actQty =="" && quarQty =="" && inActQty=="0")){
		       			qtyFlag = 1;
		       		}	 
		       			
               	}
	       		
	            count++;         	
	       } 
	       
		   if(count == (len-1))
		   {
		   		if(qtyFlag == 0)        
		   			validateMultiRowIIModify();
				else
				{					
					if(confirm("You are going to save 0 quantity. It may affect other transactions. Are you sure?"))
					{
						validateMultiRowIIModify();	
					}else{
						activeQty[lastIndex].focus();
						return false;					
					}				
				}	
		   }
		}
		else
		{
			if(activeQty[0].value != "")
	   			actQty = parseInt(activeQty[0].value,10);  			
	   			
	   		if(quarntineQty[0].value != "")
	   			quarQty = parseInt(quarntineQty[0].value,10);	   			
	   			
	   		if(inActiveQty[0].value != "")
	   			inActQty = parseInt(inActiveQty[0].value,10);   				
	   		
	   		if(activeQty[0].value == "" && quarntineQty[0].value == "" && inActiveQty[0].value == ""){
       			alert("All quantity can not be blank");
       			return false;
       		}
       		if((actQty ==0 && quarQty =="" && inActQty=="")||(actQty =="" && quarQty ==0 && inActQty=="")||(actQty =="" && quarQty =="" && inActQty==0)){
       			qtyFlag = 1;
       		}	
	   			
			if(qtyFlag == 0)        
				validateMultiRowIIModify();
			else
			{
				if(confirm("You are going to save 0 quantity. It may affect other transactions. Are you sure?"))
				{
					validateMultiRowIIModify();	
				}else{
					activeQty[0].focus();
					return false;					
				}				
			}	
		}
	}
   	
}
function validateMultiRowIIModify()
{	
   var flag = 0;
   var batchNo = "";
   var cmpBatchNo = "";
   
   var saveObj = document.getElementById("saveId");

	if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	{	
		
      
       //var itemId  			   = document.getElementsByName("strMultiRowItemId");         
       var existingBatch       = document.getElementsByName("strMultiRowExistingBatchId");    
       var finalBatch          = document.getElementsByName("strMultiRowFinalBatchNo");  	 	
       var activeQty           = document.getElementsByName("strMultiRowActiveQty");   
       var quarntineQty        = document.getElementsByName("strMultiRowQuarnQty"); 
       var inActiveQty         = document.getElementsByName("strMultiRowInActiveQty");    
       var mfgName             = document.getElementsByName("strMultiRowMfgName");  	 	
       var len = existingBatch.length;
       
       for(var j=0;j<len-1;j++)
   		{
   			batchNo = finalBatch[j].value.toUpperCase();
   			
   			for(var k=j+1;k<len-1;k++)
   			{
   				cmpBatchNo = finalBatch[k].value.toUpperCase();
   				if(cmpBatchNo == batchNo)
   				{
   					alert("Duplicate Batch not allowed !!");
   					finalBatch[k].focus();
   					saveObj.style.display = '';
   					return false;
   				}		
   			}	
   		}
       		
       var hisValidator = new HISValidator("itemInventoryProgramSurgicalTransBean");
       
   	   hisValidator.addValidation("strMultiRowItemId","dontselect=0","Please select a value from Drug name Combo" );
  	   hisValidator.addValidation("strMultiRowRateUnitId","dontselect=0","Please select Rate Unit Combo" );
  	   hisValidator.addValidation("strMultiRowMfgId","dontselect=0","Please select Manufacturer Name" );
  	   hisValidator.addValidation("strMultiRowRate","req","Please select Rate" );
  	   
  	   if(document.forms[0].strBatchMandFlg.value=='1')
  	   		hisValidator.addValidation("strMultiRowFinalBatchNo","req","Please enter Batch" );
  	   
  	   if(document.forms[0].strExpMandFlg.value=='1')
  	   		hisValidator.addValidation("strMultiRowExpiryDate","req","Please enter Expiry Date" );
  	   	
  	   //if(document.forms[0].strMfgMandFlg.value=='1')
  	   //		hisValidator.addValidation("strMultiRowMfgDate","req","Please enter Mfg Date" );
  	   		
  	   hisValidator.addValidation("strMultiRowMfgName","req","Please enter Manufacturer Name" );  	
  	   		
       var retVal1 = hisValidator.validate();        
       if(retVal1)
       {
       	  
    	   var strMfgDate           = document.getElementsByName("strMultiRowMfgDate");
	       var strExpiryDate        = document.getElementsByName("strMultiRowExpiryDate");  
	       for(var nTmpI=0;nTmpI<strMfgDate.length-1; nTmpI++)
			{
       		if(trimAll(strExpiryDate[nTmpI].value).length > 0) 
				{
					var nFlag = compareDate(trimAll(document.getElementsByName("strCtDate")[0].value),trimAll(strExpiryDate[nTmpI].value)); 				
					if(nFlag.mode == 2 || nFlag.mode == 1)
					{
						alert("Expiry Date must be greater then Current Date.");
						return false;
					}
				}
				
				if(trimAll(strMfgDate[nTmpI].value).length > 0) 
				{
					var nFlag = compareDate(trimAll(document.getElementsByName("strCtDate")[0].value),trimAll(strMfgDate[nTmpI].value)); 				
					if(nFlag.mode < 2)
					{
						alert("Manufacturer Date must be less then Current Date.");
						return false;
					}
				}			
				
			}
	       
    	   
    	   var conf = confirm("You Are Going To Save Records");
          if(conf == true)
          {
          	   var conf1 = confirm("Are you sure !!!");
               if(conf1 == true)
               {   			
            	   saveObj.style.display = "none"; 
            	   for(var i=0;i<len-1;i++)
			       {	
		       	 	 finalBatch[i].disabled   = false;												           								           	
		           	 activeQty[i].disabled    = false;
		           	 quarntineQty[i].disabled = false;
		           	 inActiveQty[i].disabled  = false;
		           	 mfgName[i].disabled      = false;
		           	 
		           	 if(trimAll(finalBatch[i].value).length == 0) 
		             	finalBatch[i].value='NA';    			 	
					 		
			       }
               	   document.forms[0].strSelDrugName.value = document.getElementById("DrugNameId").innerHTML;		       
			       flag = 1;
			       document.forms[0].strMultiRowItemId.disabled = false;			      
		           document.forms[0].hmode.value = "UPDATE";	                                               
                   document.forms[0].submit();
               }
          }
       }
       
       if(flag == 0)
	   {
	   		saveObj.style.display = '';
	        return false;	
	   }
	}
   
}




/*
 * Convert dd.mm.yyyy || dd/mm/yyyy  into dd-mon-yyyy
 * */
function convertDate_ddmonyyyy(dtValue)
{
   var val1  = trimAll(dtValue).split(".").join("-");
   var val2  = val1.split("/").join("-");
   var date  = val2.split("-")[0];
   var month = val2.split("-")[1];
   
   if(date.length=='1')
   {
   	 date = "0"+date;
   }
   
   var convMonth="" ;
   month = parseInt(month);
   
   if(month=='1')
   {
   	 convMonth = "JAN";
   }
   if(month=='2')
   { 
   	 convMonth = "FEB";		  	   	
   }
   if(month=='3')
   {
   	 convMonth = "MAR";
   }
   if(month=='4')
   { 
   	 convMonth = "APR";		  	   	
   }
   if(month=='5')
   {
   	 convMonth = "MAY";
   }
   if(month=='6')
   { 
   	 convMonth = "JUN";		  	   	
   }
   
   if(month=='7')
   { 
   	 convMonth = "JUL";		  	   	
   }
   if(month=='8')
   {
   	 convMonth = "AUG";
   }
   if(month=='9')
   { 
   	 convMonth = "SEP";		  	   	
   }
   
   if(month=='10')
   { 
   	 convMonth = "OCT";		  	   	
   }
   if(month=='11')
   {
   	 convMonth = "NOV";
   }
   if(month=='12')
   { 
   	 convMonth = "DEC";		  	   	
   }
   
   var year  = val2.split("-")[2];
   if(year.length=='2')
   {
   	  year = "20"+year;
   }
   
   //var finalDate = date+"-"+convMonth+"-"+year;
   return date+"-"+convMonth+"-"+year;
}

function checkDateFormat(mode,obj,index) 
{
		  var chkdate       = obj.value;	
		  if(chkdate.length>0)
		  {
		  	  
					  if(!chkdate.match(/^([0]?[1-9]|[1|2][0-9]|[3][0|1])[.\/-]([0]?[1-9]|[1][0-2])[.\/-]([0-9]{4}|[0-9]{2})$/))
					  {
					       alert('Incorrect format Please follow [  dd-mm-yyyy  OR  dd.mm.yyyy  OR   dd/mm/yyyy   ] format ');		     
			               obj.value ='';
			               setTimeout(function(){obj.focus();}, 0);
				           return ;			   
					  }
					  else
					  {					  	  
					  	   var finalDate = convertDate_ddmonyyyy(obj.value);
					  	   var ctDate    = document.forms[0].strCtDate.value;
					  	  
					  	   if(mode=='1')
					  	   { 	  	     
					  	        var nFlag = compareDate(trimAll(finalDate),trimAll(ctDate)); 			  	       								
								if(nFlag.mode == 2)
								{
									alert("Manufacter Date must be Less then Current Date.");
									obj.value ='';
			                        setTimeout(function(){obj.focus();}, 0);
									return ;
								}
								else
								{						
					  	            document.getElementById("strMultiRowExpiryDate"+index).focus();
								}          
					  	      
					  	      
					  	   }
					  	   else
					  	   {					  	   			  	   				  	   	    
					  	        var nFlag = compareDate(trimAll(finalDate),trimAll(ctDate)); 			  	        							
								if(nFlag.mode == 0)
								{
									alert("Expiry Date must be Greater then Current Date.");
									obj.value ='';
									setTimeout(function(){obj.focus();}, 0);
			                        return ;
								}
								else
								{						
					  	            document.getElementById("strMultiRowMfgId"+index).focus();
								} 					  	   	 	  	   	  
					  	   	  
					  	   }  
					  	   
					  }
		  	 	
		  	  
		  }
}		

function cancel(mode) 
{
          var conf = confirm("All the values will be reset");
          if(conf == true)
          {
               var conf1 = confirm("Are you sure !!!");
               if(conf1 == true)
               {	              
               	         document.forms[0].hmode.value = mode;
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
function ajaxExistingBatchName() 
{
	

	  if(document.getElementById("strMultiRowItemId").value.split("^")[0]!='0')
	  {
		  	document.forms[0].strBatchMandFlg.value = document.getElementById("strMultiRowItemId").value.split("^")[8];
		    document.forms[0].strExpMandFlg.value = document.getElementById("strMultiRowItemId").value.split("^")[9];
		    var mode = "EXISTINGBATCH";	
			var url = "ItemInventoryWithProgramTransCNT.cnt?hmode="+mode+"&strItemBrandId="+ document.getElementById("strMultiRowItemId").value.split("^")[0] +"&strProgrammeId="+"00"+ "&storeId="+ document.forms[0].strStoreId.value+"&catId="+document.forms[0].strCatId.value.split("^")[0]+"&index=1-1";
		    ajaxFunction(url, "1");
	  }
}


function ajaxExistingBatchNameModify() 
{
	

	  if(document.getElementById("strMultiRowItemId").value.split("^")[0]!='0')
	  {
		  //alert("2"+ document.forms[0].strStoreId.value);
		  //alert("store id"+ document.forms[0].strStoreId.value);
			//document.forms[0].strProgrammeId.value=document.getElementById("strProgrammeId").value;  
	  		document.forms[0].strBatchMandFlg.value = document.getElementById("strMultiRowItemId").value.split("^")[8];
		    document.forms[0].strExpMandFlg.value = document.getElementById("strMultiRowItemId").value.split("^")[9];
			var mode = "EXISTINGBATCHMODIFY";	
			//var url = "ItemInventoryWithProgramTransCNT.cnt?hmode="+mode+"&strItemBrandId="+ document.getElementById("strMultiRowItemId").value.split("^")[0] +"&strProgrammeId="+document.getElementById("strProgrammeId").value + "&storeId="+ document.forms[0].strStoreId.value+ "&index=1-1"+"&batchSel="+ document.forms[0].strSelBatch.value;
			var url = "ItemInventoryWithProgramTransCNT.cnt?hmode="+mode+"&strItemBrandId="+ document.getElementById("strMultiRowItemId").value.split("^")[0]+"&storeId="+ document.forms[0].strStoreId.value+ "&index=1-1"+"&batchSel="+ document.forms[0].strSelBatch.value;
		    ajaxFunction(url, "4");
	  }
}

function getManufecture(mode) 
{
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();
}
function getRateUnitCmb()
{
	
	if(document.getElementById("strMultiRowItemId").value.split("^")[0]!='0')
    {	
	  var mode = "RATEUNIT";
	  var url = "ItemInventoryWithProgramTransCNT.cnt?hmode="+mode+"&strItemBrandId="+ document.getElementById("strMultiRowItemId").value+ "&storeId="+ document.forms[0].strStoreId.value+ "&index=1-1";
      ajaxFunction(url, "2");
   }	
}

function getRateUnitCmbModify()
{
	
	if(document.getElementById("strMultiRowItemId").value.split("^")[0]!='0')
    {	
	  var mode = "RATEUNIT";
	  var url = "ItemInventoryWithProgramTransCNT.cnt?hmode="+mode+"&strItemBrandId="+ document.getElementById("strMultiRowItemId").value+ "&storeId="+ document.forms[0].strStoreId.value+ "&index=1-1";
      ajaxFunction(url, "5");
   }	
}

function batchExistForSupplier()
{
	   var strRowIndex  = document.getElementsByName("strRowIndex"); 
       var itemParVal   = document.getElementsByName("strMultiRowFinalBatchNo");	  
       var finalBatch   = document.getElementsByName("strMultiRowFinalBatchNo");
       var supplierId   = document.getElementsByName("strMultiRowSupplierId"); 
       var itemBrandId  = document.getElementById("strMultiRowItemId").value.split("^")[0];
        
	   for(var x=0;x<itemParVal.length-1;x++)
	   {	 
	   	     finalBatch[x].disabled = false;
	   	    // alert("Value:::"+finalBatch[x].value+"::Length::"+finalBatch[x].value.length);
	   	      
	   	     if(finalBatch[x].value.length>0) 
	   	     {
	   	
		   	    	       	   
		   	     if(x=='0')
		   	     {			   	      		       	      				       	    
		           getPrevExistBatchForSupplier(itemBrandId,finalBatch[x].value,supplierId[x].value,x);  //Passed Item Brand Id + Batch + Supplier + Index
		   	     } 
		   	     finalBatch[x].disabled = true;
	   	     }
	   	     else
	   	     {
	   	     	//alert("Inside Delete Row:::"+strRowIndex[x].value);
	   	     	deleteRow(strRowIndex[x].value,1,0);
	   	     }    
	        
	   }	
	
}
function getPrevExistBatchForSupplier(itemBrandId,batchNo,supplierId,index) 
{

	var url = "ItemInventoryWithProgramTransCNT.cnt?hmode=EXISTINGSUPPBATCHINSTCOK&storeId="
			+ document.forms[0].strStoreId.value + "&supplierId="+ supplierId+ "&batchNo="+ batchNo+ "&strItemBrandId="+ itemBrandId+"&Index="+index;
	
	ajaxFunction(url, "3");

}

function getAjaxResponse(res, mode) 
{
	if (mode == '1')
	
	{		
		
        var tmp = res.split("$");
       
        document.getElementById("ExistingBatchId").innerHTML = "<select  name='strMultiRowExistingBatchId' class='comboNormal'  id='strMultiRowExistingBatchId#delIndex#' onChange='getStockDetails(\"#delIndex#\",this);'>"+ tmp[0] + "</select>";
        
        if(document.forms[0].strBatchMandFlg.value == '1')
        {
        	document.getElementById("mandBatchId").innerHTML="<font color='red'>*</font>Batch/Serial No.";
        }
        else
        {
        	document.getElementById("mandBatchId").innerHTML="<font color='red'>*</font>Batch/Serial No.";
        }
        if(document.forms[0].strExpMandFlg.value == '1')
        {
        	document.getElementById("mandExpId").innerHTML="<font color='red'>*</font>Exp Date.";
        }
        else
        {
        	document.getElementById("mandExpId").innerHTML="Exp Date.";
        }
   
        
        getRateUnitCmb();       
	}
	
	if (mode == '2')
	{	
		
        var tmp = res.split("$");  
        // alert('------------------------->'+tmp[0])	;      
		document.getElementById("RateUnitId").innerHTML = "<select name='strMultiRowRateUnitId' class='comboMin' id='strMultiRowRateUnitId#delIndex#' >"+ tmp[0] + "</select>";
		showFirstBatchRow();
	}
	if (mode == "3") 
	{
		var finalBatch   = document.getElementsByName("strMultiRowFinalBatchNo");
        var supplierId   = document.getElementsByName("strMultiRowSupplierId"); 
        var itemBrandId  = document.getElementById("strMultiRowItemId").value.split("^")[0];
		//alert("Response:::"+res);
		                                 //         0          1         2  
        var temp = res.split("^");   // Last Issue Qty ^ Index ^ (MAX#MIN) DOSAGE        
		
		var    noOfRow  = document.getElementsByName("strAvlBatchFlg");		
		var x = parseInt(temp[1])+1;		
		if(temp[0]!='0')
		  noOfRow[temp[1]].value='1';                               
		else
		  noOfRow[temp[1]].value='0';		
			
		for(var index=0; index<noOfRow.length-1; index++) 
		{					
				
			//if(noOfRow[index].value=='1')
        	//{
        		document.getElementById("td11-"+(index + 1)).style.backgroundColor = "LIGHTBLUE";
        		document.getElementById("td21-"+(index + 1)).style.backgroundColor = "LIGHTBLUE";
        		document.getElementById("td31-"+(index + 1)).style.backgroundColor = "LIGHTBLUE";
        		document.getElementById("td41-"+(index + 1)).style.backgroundColor = "LIGHTBLUE";
        		document.getElementById("td51-"+(index + 1)).style.backgroundColor = "LIGHTBLUE";	
        		document.getElementById("td61-"+(index + 1)).style.backgroundColor = "LIGHTBLUE";
        		document.getElementById("td71-"+(index + 1)).style.backgroundColor = "LIGHTBLUE";
        		document.getElementById("td81-"+(index + 1)).style.backgroundColor = "LIGHTBLUE";
        		document.getElementById("td91-"+(index + 1)).style.backgroundColor = "LIGHTBLUE";
        		document.getElementById("td101-"+(index + 1)).style.backgroundColor = "LIGHTBLUE";	
        		document.getElementById("td111-"+(index + 1)).style.backgroundColor = "LIGHTBLUE";	
        		document.getElementById("td121-"+(index + 1)).style.backgroundColor = "LIGHTBLUE";	
        		document.getElementById("td131-"+(index + 1)).style.backgroundColor = "LIGHTBLUE";           
        	//}      	
        	
		}
		if(x!=noOfRow.length-1)
		{
		  getPrevExistBatchForSupplier(itemBrandId,finalBatch[x].value,supplierId[x].value,x);  //Passed Item Brand Id + Batch + Supplier + Index
		}
		else
		{
			               var conf = confirm("You Are Going to Save");
		                   if(conf == true)
		                   {
				               var conf1 = confirm("Are you sure !!!");
		                       if(conf1 == true)
		                       {					                        
		                         validateIssue();
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
	
	if (mode == '4')
	{		
		//alert('in mode -------------->4');
        var tmp = res.split("$");
       
        document.getElementById("ExistingBatchId").innerHTML = "<select  name='strMultiRowExistingBatchId' class='comboNormal'  id='strMultiRowExistingBatchId#delIndex#' onChange='getStockDetailsModify(\"#delIndex#\",this);'>"+ tmp[0] + "</select>";
        
        if(document.forms[0].strBatchMandFlg.value == '1')
        {
        	document.getElementById("mandBatchId").innerHTML="<font color='red'>*</font>Batch/Serial No.";
        }
        else
        {
        	document.getElementById("mandBatchId").innerHTML="<font color='red'>*</font>Batch/Serial No.";
        }
        if(document.forms[0].strExpMandFlg.value == '1')
        {
        	document.getElementById("mandExpId").innerHTML="<font color='red'>*</font>Exp Date.";
        }
        else
        {
        	document.getElementById("mandExpId").innerHTML="Exp Date.";
        }
   //alert(document.getElementById("strMultiRowExistingBatchId#delIndex#").value);
        
        getRateUnitCmbModify();
        
	}
	
	if (mode == '5')
	{		
	
        var tmp = res.split("$");        
        	// alert('tmp[0]------------------>'+tmp[0]);
       	document.getElementById("RateUnitId").innerHTML = "<select name='strMultiRowRateUnitId' class='combomin' id='strMultiRowRateUnitId#delIndex#' >"+ tmp[0] + "</select>";
        document.getElementsByName("strMultiRowRateUnitId").value  = document.getElementById("strMultiRowItemId").value.split("^")[11]+'^'+document.getElementById("strMultiRowItemId").value.split("^")[12]+'^'+document.getElementById("strMultiRowItemId").value.split("^")[13];	
		showFirstBatchRowModify();
	}
	
}
function checkDuplicateMfgName(obj,index)
{
    
	var sel  = document.getElementById("strMultiRowMfgId"+index);
	var str  = document.getElementById("strMultiRowMfgName"+index).value.toUpperCase();
	var flag = true;

	if(parseInt(document.getElementById("strMultiRowMfgName"+index).value.trim().length)>0)
	{
		for (var i=0; i<sel.options.length; i++) 
		{
	      if ( sel.options[i].text.toUpperCase() == str.toUpperCase()) 
	      {
				//sel.selectedIndex = i;
				alert("New Manufacter (  "+ str +"  ) Name is already exists in List!!!");
				document.getElementById("strMultiRowMfgName"+index).value ="";
				flag = false;
				break;
		  }
		}
		
		return flag;
	}

}
function checkMfgName(obj,index)
{
	var sel  = document.getElementById("strMultiRowMfgName"+index);
    if(obj.value!='1')
    {
    	sel.value =obj.options[obj.selectedIndex].text;
    	sel.disabled = true;
    }
    else
    {
       sel.value ="";
       sel.disabled = false;	
       sel.focus();
    }
	
}

function checkBatchExistence(obj,index)
{
    
	var sel  = document.getElementById("strMultiRowExistingBatchId"+index);
	var str  = document.getElementById("strMultiRowFinalBatchNo"+index).value.toUpperCase();
	if(parseInt(document.getElementById("strMultiRowFinalBatchNo"+index).value.trim().length)>0)
	{
		for (var i=0; i<sel.options.length; i++) 
		{
	      if ( sel.options[i].text.toUpperCase() == str.toUpperCase()) 
	      {
				//sel.selectedIndex = i;
				alert("New Batch/Serial No ["+ str +"] Value is already entered for this drug Please enter another Batch!!!");
				document.getElementById("strMultiRowFinalBatchNo"+index).value ="";
				break;
		  }
		}
		
		if(str==0){
			alert("Batch No. cannot be 0. Enter a valid Batch No.");
			document.getElementById("strMultiRowFinalBatchNo"+index).value="";
			return false;
		}		
		
	}
	
	
}
/*
 * Convert  date dd-mon-yyyy into dd.mm.yyyy || dd/mm/yyyy
 * */
function convertDate_ddmmyyyy(dtValue)
{
  
   var val1  = trimAll(dtValue).split("-").join(".");
   var val2  = val1.split("-").join(".");
   var date  = val2.split(".")[0];
   var month = val2.split(".")[1];
    
   var convMonth="" ;   
   
   if(month=='JAN'||month=='Jan')
   {
   	 convMonth = "01";
   }
   if(month=='Feb')
   { 
   	 convMonth = "02";		  	   	
   }
   if(month=='Mar')
   {
   	 convMonth = "03";
   }
   if(month=='Apr')
   { 
   	 convMonth = "04";		  	   	
   }
   if(month=='May')
   {
   	 convMonth = "05";
   }
   if(month=='Jun')
   { 
   	 convMonth = "06";		  	   	
   }
   
   if(month=='Jul')
   { 
   	 convMonth = "07";		  	   	
   }
   if(month=='Aug')
   {
   	 convMonth = "08";
   }
   if(month=='Sep')
   { 
   	 convMonth = "09";		  	   	
   }
   
   if(month=='Oct')
   { 
   	 convMonth = "10";		  	   	
   }
   if(month=='Nov')
   {
   	 convMonth = "11";
   }
   if(month=='Dec')
   { 
   	 convMonth = "12";		  	   	
   }
   
   var year  = val2.split(".")[2];   
   return date+"."+convMonth+"."+year;
}


function getStockDetails(index,obj)
{  
	 
  //   0        1            2            3          4             	  5              6         7  
  // Batch ^ Active Qty ^ Quarntine ^ In-Active ^ Expiry Date ^ Manufactrer Date ^ Rate ^ Rate Unit ^
  //  8         9           10             11
  // PO No ^ Tender No  ^ Supplier ID ^ Manufacter Id	
  if(obj.value!='0')
  {  
	  document.getElementById("strMultiRowFinalBatchNo"+index).value=obj.value.split("#")[0];
	  document.getElementById("strMultiRowActiveQty"+index).value=obj.value.split("#")[1];
	  document.getElementById("strMultiRowQuarnQty"+index).value=obj.value.split("#")[2];
	  document.getElementById("strMultiRowInActiveQty"+index).value=obj.value.split("#")[3];
	  if(obj.value.split("#")[4].length>0)
	  {
	    //document.getElementById("strMultiRowExpiryDate"+index).value=convertDate_ddmmyyyy(obj.value.split("#")[4]);
		  document.getElementById("strMultiRowExpiryDate"+index).value=obj.value.split("#")[4];
	  } 
	  if(obj.value.split("#")[5].length>0)
	  {
	    //document.getElementById("strMultiRowMfgDate"+index).value=convertDate_ddmmyyyy(obj.value.split("#")[5]);
	    document.getElementById("strMultiRowMfgDate"+index).value=obj.value.split("#")[5];
	  }
	 
	  document.getElementById("strMultiRowRate"+index).value=obj.value.split("#")[14];
	  document.getElementById("strMultiRowRateUnitId"+index).value=obj.value.split("#")[7];
	  document.getElementById("strMultiRowPONo"+index).value=obj.value.split("#")[8];
	  document.getElementById("strMultiRowTenderNo"+index).value=obj.value.split("#")[9];	  
	  //document.getElementById("strMultiRowSupplierId"+index).value=obj.value.split("#")[10];
	  document.getElementById("strMultiRowMfgId"+index).value=obj.value.split("#")[11];	 
	  document.getElementById("strMultiRowMfgName"+index).value =document.getElementById("strMultiRowMfgId"+index).options[document.getElementById("strMultiRowMfgId"+index).selectedIndex].text; 
	  document.getElementById("strMultiRowFinalBatchNo"+index).disabled = true;
	  if(obj.value.split("#")[1]>'0')
	  {	  	     
     	document.getElementById("strMultiRowQuarnQty"+index).disabled = true; 
     	document.getElementById("strMultiRowInActiveQty"+index).disabled = true;	     
	  }
	  else
	  {
	  	
	  	if(obj.value.split("#")[2]>'0')
	    {			     
		     	document.getElementById("strMultiRowActiveQty"+index).disabled = true; 
		     	document.getElementById("strMultiRowInActiveQty"+index).disabled = true;		     	
	    }
		else
	    {
	     	document.getElementById("strMultiRowActiveQty"+index).disabled = true; 
	     	document.getElementById("strMultiRowQuarnQty"+index).disabled = true;	     	    	
	    }
	  }
	  document.getElementById("strMultiRowTenderNo"+index).value=obj.value.split("#")[17];
	  document.getElementById("strMultiRowInvoiceNo"+index).value=obj.value.split("#")[15];
	  document.getElementById("strMultiRowInvoiceDate"+index).value=obj.value.split("#")[16];
  }
  else
  {
  	  document.getElementById("strMultiRowFinalBatchNo"+index).disabled = false;
  	  document.getElementById("strMultiRowFinalBatchNo"+index).value="";
	  document.getElementById("strMultiRowActiveQty"+index).value="";
	  document.getElementById("strMultiRowQuarnQty"+index).value="";
	  document.getElementById("strMultiRowInActiveQty"+index).value="";
	  document.getElementById("strMultiRowExpiryDate"+index).value="";
	  document.getElementById("strMultiRowMfgDate"+index).value="";	  
	  document.getElementById("strMultiRowRate"+index).value="";
	//  document.getElementById("strMultiRowRateUnitId"+index).value="";
	  document.getElementById("strMultiRowPONo"+index).value="";
	  document.getElementById("strMultiRowTenderNo"+index).value=""; 
	  //document.getElementById("strMultiRowSupplierId"+index).value="0";
	  document.getElementById("strMultiRowMfgName"+index).value ="";
	  document.getElementById("strMultiRowMfgId"+index).value="0";
	  document.getElementById("strMultiRowActiveQty"+index).disabled = false; 
	  document.getElementById("strMultiRowQuarnQty"+index).disabled = false; 
      document.getElementById("strMultiRowInActiveQty"+index).disabled = false;
	  document.getElementById("strMultiRowInvoiceNo"+index).value="";
	  document.getElementById("strMultiRowInvoiceDate"+index).value="";
  }
  
  document.getElementById("strMultiRowRate"+index).focus();
}

function getStockDetailsModify(index,obj)
{  
	 
  //   0        1            2            3          4             	  5              6         7  
  // Batch ^ Active Qty ^ Quarntine ^ In-Active ^ Expiry Date ^ Manufactrer Date ^ Rate ^ Rate Unit ^
  //  8         9           10             11
  // PO No ^ Tender No  ^ Supplier ID ^ Manufacter Id	
  if(obj.value!='0')
  {  
	  document.getElementById("strMultiRowFinalBatchNo"+index).value=obj.value.split("#")[0];
	  document.getElementById("strMultiRowActiveQty"+index).value=obj.value.split("#")[1];
	  document.getElementById("strMultiRowQuarnQty"+index).value=obj.value.split("#")[2];
	  document.getElementById("strMultiRowInActiveQty"+index).value=obj.value.split("#")[3];
	  if(obj.value.split("#")[4].length>0)
	  {
	    //document.getElementById("strMultiRowExpiryDate"+index).value=convertDate_ddmmyyyy(obj.value.split("#")[4]);
		  document.getElementById("strMultiRowExpiryDate"+index).value=obj.value.split("#")[4];
	  } 
	  if(obj.value.split("#")[5].length>0)
	  {
	    //document.getElementById("strMultiRowMfgDate"+index).value=convertDate_ddmmyyyy(obj.value.split("#")[5]);
	    document.getElementById("strMultiRowMfgDate"+index).value=obj.value.split("#")[5];
	  }
	  	 
	  document.getElementById("strMultiRowRate"+index).value=obj.value.split("#")[6];
	  document.getElementById("strMultiRowRateUnitId"+index).value=obj.value.split("#")[7];
	  document.getElementById("strMultiRowPONo"+index).value=obj.value.split("#")[8];
	  document.getElementById("strMultiRowTenderNo"+index).value=obj.value.split("#")[9];	  
	  //document.getElementById("strMultiRowSupplierId"+index).value=obj.value.split("#")[10];
	  document.getElementById("strMultiRowMfgId"+index).value=obj.value.split("#")[11];	 
	  document.getElementById("strMultiRowMfgName"+index).value =document.getElementById("strMultiRowMfgId"+index).options[document.getElementById("strMultiRowMfgId"+index).selectedIndex].text; 
	  //document.getElementById("strMultiRowFinalBatchNo"+index).disabled = true;
	  if(obj.value.split("#")[1]>'0')
	  {	  	     
     	document.getElementById("strMultiRowQuarnQty"+index).disabled = true; 
     	document.getElementById("strMultiRowInActiveQty"+index).disabled = true;
     	document.getElementById("strMultiRowQuarnQty"+index).value = ""; 
     	document.getElementById("strMultiRowInActiveQty"+index).value = "";  
		     
	  }
	  else
	  {
	  	
	  	if(obj.value.split("#")[2]>'0')
	    {			     
		     	document.getElementById("strMultiRowActiveQty"+index).disabled = true; 
		     	document.getElementById("strMultiRowInActiveQty"+index).disabled = true; 
		     	document.getElementById("strMultiRowActiveQty"+index).value = ""; 
		     	document.getElementById("strMultiRowInActiveQty"+index).value = ""; 
	    }
		else
	    {
	     	document.getElementById("strMultiRowActiveQty"+index).disabled = true; 
	     	document.getElementById("strMultiRowQuarnQty"+index).disabled = true;
	     	document.getElementById("strMultiRowActiveQty"+index).value = ""; 
	     	document.getElementById("strMultiRowQuarnQty"+index).value = "";	     	
	    }
	  }
  }
  else
  {
  	  document.getElementById("strMultiRowFinalBatchNo"+index).disabled = false;
  	  document.getElementById("strMultiRowFinalBatchNo"+index).value="";
	  document.getElementById("strMultiRowActiveQty"+index).value="";
	  document.getElementById("strMultiRowQuarnQty"+index).value="";
	  document.getElementById("strMultiRowInActiveQty"+index).value="";
	  document.getElementById("strMultiRowExpiryDate"+index).value="";
	  document.getElementById("strMultiRowMfgDate"+index).value="";	  
	  document.getElementById("strMultiRowRate"+index).value="";
	  document.getElementById("strMultiRowRateUnitId"+index).value="";
	  document.getElementById("strMultiRowPONo"+index).value="";
	  document.getElementById("strMultiRowTenderNo"+index).value=""; 
	  //document.getElementById("strMultiRowSupplierId"+index).value="0";
	  document.getElementById("strMultiRowMfgName"+index).value ="";
	  document.getElementById("strMultiRowMfgId"+index).value="0";
	  document.getElementById("strMultiRowActiveQty"+index).disabled = false; 
	  document.getElementById("strMultiRowQuarnQty"+index).disabled = false; 
      document.getElementById("strMultiRowInActiveQty"+index).disabled = false;
  }
  document.getElementById("strMultiRowRate"+index).focus();
}


function CalculateDrugCost()
{
		           /**
			 		 * Calculate Total Cost of Item
			 		 */
			 		 
			 		 var  rateObj              = document.forms[0].strSalePrice.value;	   
			 		 var  rate_unit_base_value = document.forms[0].strUnitRateID.value.split("^")[1];
					 var  qtyObj               = document.forms[0].strActiveQty.value;
					 var  qty_unit_base_value  = document.forms[0].strUnitRateID.value.split("^")[1];	
					 //alert("qty:::"+qtyObj+"::Rate:::"+rateObj+"::rate_unit_base_value:::"+rate_unit_base_value+"::qty_unit_base_value::"+qty_unit_base_value);	
       				 if(document.forms[0].strUnitRateID.value!='0')  
       				 {  				
						 
						 var total = parseFloat("0.00");
						 var qty = parseFloat("0.00");
						 var rate = parseFloat("0.00");
						 
						  qty    = qtyObj;	
						  rate   = rateObj;
								 
					
						 if(isNaN(rate) || rate=="") rate = "0";
						 if(isNaN(qty)  || qty=="") qty = "0";
						 if(qty=='0')		
						 {
						  qty_unit_base_value  = '0';	
						  rate_unit_base_value = '0'; 
						  total = parseFloat(qty * qty_unit_base_value * rate);
						 }
						 else
						 {
						   total = parseFloat(qty * qty_unit_base_value * (rate /rate_unit_base_value));
						 } 
						 document.getElementById("strDrugTotCost").value = roundValue(total,2);
						//alert("IInd Case::::"+roundValue(total,2));
       				 }       				 
			 		//NVL(HSTNUM_PURCHASE_RATE,''0'')/Mms_Mst.getUnitBaseValue(HSTNUM_RATE_UNITID,GNUM_HOSPITAL_CODE))*NVL( (HSTNUM_RECIEVED_QTY - HSTNUM_RETURNED_QTY)
			 		/**
			 		 * Total Cost Calculation End
			 		 */
}
function enableNewBatch()
{
	 
		if(document.forms[0].strExistingBatchId.value=='0')
        {
        	document.forms[0].strExistingBatchFlg.value = '0';
        	document.forms[0].strBatchNo.value = '';
        	document.forms[0].strBatchNo.disabled = false;
        	document.forms[0].strStockStatus.disabled = false;
        	
        	document.getElementById("manufactDateTextDiv").style.display = "block";
			document.getElementById("manufactDateFieldDiv").innerHTML = "";
			
			document.getElementById("expDateTextDiv").style.display = "block";
			document.getElementById("expDateFieldDiv").innerHTML ="";
			
			document.forms[0].strInHandQuantity.value = "0.00";		
		
		    document.forms[0].strRate.value = "0.00";
		    document.forms[0].strSalePrice.value = "0.00";
		    document.forms[0].strRate.disabled = false;
			
			document.getElementById("freeItemUnit").style.display = "block";
			document.getElementById("freeItemUnitField").innerHTML ="";
			
			document.getElementById("rackNoTextDiv").style.display = "block";
			document.getElementById("rackNoFieldDiv").innerHTML ="";
			
			document.forms[0].strCurrencyCode.disabled = false;
			
			document.getElementById("UnitRateID").style.display= "block";
			document.getElementById("UnitRateFieldID").innerHTML ="";
			
			document.getElementById("UnitRateID1").style.display = "block";
			document.getElementById("UnitRateFieldID1").innerHTML ="";
			
			document.getElementById("poTextDiv").style.display= "block";
			document.getElementById("poFieldDiv").innerHTML ="";
			
			document.getElementById("poDateTextDiv").style.display = "block";
			document.getElementById("poDateFieldDiv").innerHTML ="";
			
			
			document.getElementById("billTextDiv").style.display = "block";
			document.getElementById("billFieldDiv").innerHTML ="";
	
			document.getElementById("billDateTextDiv").style.display = "block";
			document.getElementById("billDateFieldDiv").innerHTML ="";
			
			document.getElementById("receiveDateTextDiv").style.display = "block";
			document.getElementById("receiveDateFieldDiv").innerHTML ="";
			
			document.getElementById("supplyByTextDiv").style.display = "block";
			document.getElementById("supplyByFieldDiv").innerHTML = "";
        }
        else
        {
        	document.forms[0].strBatchNo.disabled = true;
        	document.forms[0].strBatchNo.value = document.forms[0].strExistingBatchId[document.forms[0].strExistingBatchId.selectedIndex].text;
        	ajaxExistingBatchDtl(); 
        	
        }
	
}
function ajaxExistingBatchDtl() 
{
	var mode = "EXISTINGBATCHDTL";
	var url = "ItemInventoryWithProgramTransCNT.cnt?hmode="+mode+"&strItemBrandId="+ document.forms[0].strItemBrandId.value + "&storeId="+ document.forms[0].strStoreId.value+ "&strItemId="+ document.forms[0].strItemId.value+ "&strExistingBatchId="+ document.forms[0].strExistingBatchId.value;
	ajaxFunction(url, "8");
}




	/**
	 * addFreeItems
	  
	 */
	 function addFreeItems() {
	 	
	 		var mode 		= "1";
	 		var isBatchReq  = document.forms[0].isBatchReq.value;
	 		var isExpDtReq  = document.forms[0].isExpirtReq.value;
	 	
	 	getItemOtherDetailsView(mode, isBatchReq , isExpDtReq , '1' , "itemInventoryProgramSurgicalTransBean");
	 	
	 }
	 
	 
	 function calcIssueRate()
	 {

	 	if(document.forms[0].strItemBrandId[document.forms[0].strItemBrandId.selectedIndex].value!='0')
	 	{
			 	var purchaseRate = document.forms[0].strRate.value;
			 	var confgIsseRateVal = document.forms[0].strConfigIssueRate.value;
			 	//alert(confgIsseRateVal);
			 	
			 	
			 	if(document.forms[0].strIssueRateConfigFlg.value=='1')
			 	{
			 		var result1 = (Math.abs(purchaseRate) * confgIsseRateVal) / Math.pow(10, 2);
			 	    var cost = roundValue(result1,2);
			 	
			 	    document.forms[0].strSalePrice.value = cost;
			 	   	document.forms[0].strSalePrice.disabled = "true";
			 	   //	alert(cost);
			 		CalculateDrugCost();
			 					 					 		
			 	}
			 	else
			 	{
			 		//alert(purchaseRate);
			 		document.forms[0].strSalePrice.value = purchaseRate;
			 		document.forms[0].strSalePrice.disabled = "false";
			 		CalculateDrugCost();
			 	}
	 	}
	 	else
	 	{
	 		alert("Please Select Drug/Item Name First!!!");
	 		return false;
	 	}
	 	
	 }
	
	
	function calcIssueRateOne()
	 {

	 	
			 	var     purchaseRate = document.forms[0].strRate.value;
			 	var confgIsseRateVal = document.forms[0].strConfigIssueRate.value;
			 	
			 	if(document.forms[0].strIssueRateConfigFlg.value=='1')
			 	{
			 		var result1 = (Math.abs(purchaseRate) * confgIsseRateVal) / Math.pow(10, 2);
			 	    var cost = roundValue(result1,2);
			 	    document.forms[0].strSalePrice.value = cost;
			 		document.forms[0].strSalePrice.disabled = "true";
			 	}
			 	else
			 	{
			 		document.forms[0].strSalePrice.value = purchaseRate;
			 		document.forms[0].strSalePrice.disabled = "false";
			 	}
	 	
	 	
	 }

	 function calcIssueRateTwo()
	 {
	 	        
	 	        document.forms[0].strUnitSaleID.disabled = true;
 	
			 	var     purchaseRate = document.forms[0].strRateOnLoad.value;
			 	if(document.forms[0].strIssueRateConfigFlg.value=='1')
			 	{
			 		document.forms[0].strSalePrice.disabled = "true";
			 	}
			 	else
			 	{
			 		document.forms[0].strSalePrice.value = purchaseRate;
			 		document.forms[0].strSalePrice.disabled = "false";
			 	}
	 	
	 	
	 }
	 
	 

// Function for Numeric(11,2)
function numericWithTwoDecimalPlaces(fld, milSep, decSep, e)
{
	var key = '';
	var milSep="";
	var i = j = 0;
	var len = len2 = 0;
	var strCheck = '0123456789';
	var aux = aux2 = '';
	var whichCode = (window.Event) ? e.which : e.keyCode;
	//if (whichCode == 13) return true;  // Enter
	if (whichCode == 0)	return true; //tab-index
	//alert(whichCode);
	if (whichCode == 8) return true;  // Back-Space 
	key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		//len = fld.value.length;
		len=11;
		for(i = 0; i < len; i++)
		if ((fld.value.charAt(i) != decSep)) break;
		aux = '';
	for(; i < len; i++)
	if (strCheck.indexOf(fld.value.charAt(i))!=-1) aux += fld.value.charAt(i);
	aux += key;
	len = aux.length;
	if (len == 0) fld.value = '';
	if (len == 1) fld.value = ''+ decSep + '' + aux;
	if (len == 2) fld.value = ''+ decSep + aux;
	if (len > 2) {
	aux2 = '';
	for (j = 0, i = len - 3; i >= 0; i--) {
	if (j == 3) {
	aux2 += milSep;
	j = 0;
	}
	aux2 += aux.charAt(i);
	j++;
	}
	fld.value = " ";
	len2 = aux2.length;
	for (i = len2 - 1; i >= 0; i--)
	fld.value += aux2.charAt(i);
	fld.value += decSep + aux.substr(len - 2, len);
	}
	return false;
}	


// Function for Numeric(13,4)
function numericWithFourDecimalPlaces(fld, milSep, decSep, e)
{
	var key = '';
	var milSep="";
	var i = j = 0;
	var len = len2 = 0;
	var strCheck = '0123456789';
	var aux = aux2 = '';
	var whichCode = (window.Event) ? e.which : e.keyCode;
	//if (whichCode == 13) return true;  // Enter
	if (whichCode == 0)	return true; //tab-index
	//alert(whichCode);
	if (whichCode == 8) return true;  // Back-Space 
	key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		//len = fld.value.length;
		len=13;
		for(i = 0; i < len; i++)
		if ((fld.value.charAt(i) != decSep)) break;
		aux = '';
	for(; i < len; i++)
	if (strCheck.indexOf(fld.value.charAt(i))!=-1) aux += fld.value.charAt(i);
	aux += key;
	len = aux.length;
	
	if (len == 0) fld.value = '';
	if (len == 1) fld.value = ''+ decSep + '' + aux;
	if (len == 2) fld.value = ''+ decSep + aux;
	if (len == 3) fld.value = ''+ decSep + aux;
	if (len == 4) fld.value = ''+ decSep + aux;
	if (len > 4) {
	aux2 = '';
	for (j = 0, i = len - 5; i >= 0; i--) {
	if (j == 5) {
	aux2 += milSep;
	j = 0;
	}
	aux2 += aux.charAt(i);
	j++;
	}
	fld.value = " ";
	len2 = aux2.length;
	for (i = len2 - 1; i >= 0; i--)
	fld.value += aux2.charAt(i);
	fld.value += decSep + aux.substr(len - 4, len);
	}
	
	
	return false;
}	 	 



 	 

function getIssueRateUnitCombo()
{
	          
		document.forms[0].strUnitSaleID.value=document.forms[0].strUnitRateID.value;
		/**
			 		 * Calculate Total Cost of Item
			 		 */
			 		 
			 		 var  rateObj              = document.forms[0].strRate.value;	   
			 		 var  rate_unit_base_value = document.forms[0].strUnitRateID.value.split("^")[1];
					 var  qtyObj               = document.forms[0].strInHandQuantity.value;
					 var  qty_unit_base_value  = document.forms[0].strInHandQuantityUnitID.value.split("^")[1];	
					 //alert("qty:::"+qtyObj+"::Rate:::"+rateObj+"::rate_unit_base_value:::"+rate_unit_base_value+"::qty_unit_base_value::"+qty_unit_base_value);	
       				 if(rate_unit_base_value!='0' && qty_unit_base_value!='0')  
       				 {  				
						 
						 var total = parseFloat("0.00");
						 var qty = parseFloat("0.00");
						 var rate = parseFloat("0.00");
						 
						  qty    = qtyObj;	
						  rate   = rateObj;
								 
					
						 if(isNaN(rate) || rate=="") rate = "0";
						 if(isNaN(qty)  || qty=="") qty = "0";
						 if(qty=='0')		
						 {
						  qty_unit_base_value  = '0';	
						  rate_unit_base_value = '0'; 
						  total = parseFloat(qty * qty_unit_base_value * rate);
						 }
						 else
						 {
						   total = parseFloat(qty * qty_unit_base_value * (rate /rate_unit_base_value));
						 } 
						 document.getElementById("strDrugTotCost").value =  roundValue(total,2);
						 //alert(roundValue(total,2));
       				 }
       				 else
       				 {
       				 	alert("Please Select In-Hand Quantity\Purchase Rate Unit");
       				 	return false;
       				 }
			 		//NVL(HSTNUM_PURCHASE_RATE,''0'')/Mms_Mst.getUnitBaseValue(HSTNUM_RATE_UNITID,GNUM_HOSPITAL_CODE))*NVL( (HSTNUM_RECIEVED_QTY - HSTNUM_RETURNED_QTY)
			 		/**
			 		 * Total Cost Calculation End
			 		 */
}

function clearFormFields()
{

		document.forms[0].strBatchNo.value = '';
        document.forms[0].strActiveQty.value = '';
        document.forms[0].strQuarantineQty.value = '0';
        document.forms[0].strInActiveQty.value = '0';
        document.forms[0].strExpiryDate.value = '';
        document.forms[0].strManufactureDate.value = '';
}

function getDrugNameSelected(itemId)
{
	var flag = 0;
	var sel = document.forms[0].strMultiRowItemId;	
	var totRowLength = parseInt(document.getElementsByName("rowLength1")[0].value,10);
	
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
		if ( sel.options[i].value.split("^")[0] == itemId) 
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
	else
	{
		displaySelectedDrug();
		ajaxExistingBatchName();
	}	    
	 
}

function getDrugNameSelectedModify(itemId)
{
	//alert("hi"+itemId);
	var flag = 0;
	var sel = document.forms[0].strMultiRowItemId;	
	var totRowLength = parseInt(document.getElementsByName("rowLength1")[0].value,10);
	//alert("hi"+totRowLength+"::"+sel);
	
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
		if ( sel.options[i].value.split("^")[0] == itemId) 
		{
			sel.selectedIndex = i;			
			flag = 1;
			break;
		}				
	}	
	//alert("hi"+flag);
	if(flag == 0)
	{
		sel.selectedIndex=0;
		document.forms[0].strSearchDrug.value = "";
	}
	else
	{
		displaySelectedDrug();
		ajaxExistingBatchNameModify();
		 //showFirstBatchRow();
	}	    
	 
}
function generateSlNo()
{
	 var depNamelength= document.getElementsByName("strMultiRowExistingBatchId").length - 1;
     
    // alert("depNamelength: "+depNamelength);
     
     for(var i=0;i<depNamelength;i++)
     {
     	document.getElementsByName("strSNo")[i].value=i+1;
     	
     }
}



function displaySelectedDrug() 
{
	if(document.forms[0].strMultiRowItemId[document.forms[0].strMultiRowItemId.selectedIndex].value!='0')
  {	
	 	document.getElementById("DrugNameId").innerHTML=document.forms[0].strMultiRowItemId[document.forms[0].strMultiRowItemId.selectedIndex].text;
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
        
        