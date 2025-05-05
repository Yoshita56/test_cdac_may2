
function calCostBaseOnUnit(mode,index,selected_obj)
{
	
	
	var costArray           = new Array();
	        var rateObj             = document.getElementsByName("itemCalcValue");
	        var qtyObj              = document.getElementsByName("strTransferQty");
	        var qty_base_value      = document.getElementsByName("strUnitName");
	        var cost                = document.getElementsByName("strTransferCost");
	        var costDiv             = document.getElementsByName("strTransferCostDivId");
	        
	        var total               = parseFloat("0.00");
	        for(var nTmpI=0;nTmpI<rateObj.length-1;nTmpI++)
			{
				 if(qty_base_value[nTmpI].value!="0")
				 {		
			            if(isNaN(qtyObj[nTmpI].value)  || qtyObj[nTmpI].value=="" || isNaN(rateObj[nTmpI].value.split("^")[1]) || rateObj[nTmpI].value.split("^")[1]=="" ) 
			            {
			                qtyObj[nTmpI].value = "0";
			                rateObj[nTmpI].value.split("^")[1] = "0";
			                costArray[nTmpI] = "0";
						}
						else
						{
						   costArray[nTmpI] = roundValue(parseFloat(qtyObj[nTmpI].value * qty_base_value[nTmpI].value.split("^")[1] * rateObj[nTmpI].value.split("^")[1]), 2)
						}
						cost[nTmpI].value    = costArray[nTmpI];
						costDiv[nTmpI].value = costArray[nTmpI];
				 }
				 else
				 {
				   alert("Please Select Unit!!!");
				   cost[nTmpI].value    = "0";
				   costDiv[nTmpI].value = "0";
				   return false;
				 
				 }		
												
						
			}
			            var costObj = document.getElementsByName("strTransferCost");
						var total   = parseFloat("0.00");
						
					   	if (costObj.length > 0) 
						{
					       
							for ( var i = 0; i <costObj.length; i++)
							{		        	
									
								total = total + parseFloat(costObj[i].value);
					 		}
					
						}
			
				      total = roundValue(total, 2);
				      document.getElementById("strTotalTransferCostDivId").innerHTML = total;
			          document.forms[0].strTotalTransferCost.value=total;
		
		   /*
	             Here We Preserv Value 
	       */
	       var chkObj      = document.getElementsByName("itemUserValue");
	       var unitObj     = document.getElementsByName("strUnitName");
	       //var reqQtyObj   = document.getElementsByName("strReqQty");
	       var issueQtyObj = document.getElementsByName("strTransferQty");
	       var rateObj     = document.getElementsByName("itemCalcValue");
	       
	         /*   Calculate Cost */ 
	          
	           for(var nTmpI=0;nTmpI<chkObj.length-1;nTmpI++)
			   {		
			
	           }
	         /* Cost Calculation End  */

	       //var len = chkObj.length;   
	       var newStr = "";
	      
	       //var count2 = parseInt("0");
	       	 var flag=true;      
	       	 document.getElementById("strItemDtlWithIssueQty").value="";
	       	 
	        for(var nTmpI=0;nTmpI<chkObj.length-1;nTmpI++)
			{		
				//alert(flag);	
				if(flag)
				{	
					//           0=Item ID#1=ItemBrand Id#2=Batch No#3=Stock Status Code#4=RequestedQty(0)#5=Unit Name#6=Transfer Qty#7=Rate
					newStr = chkObj[nTmpI].value.split("^")[0]+"#"+chkObj[nTmpI].value.split("^")[1]+"#"+chkObj[nTmpI].value.split("^")[15]+"#"+chkObj[nTmpI].value.split("^")[32]+"#0#"+unitObj[nTmpI].value+"#"+issueQtyObj[nTmpI].value+"#"+rateObj[nTmpI].value.split("^")[1];
					
					flag = false;
				}
				else
				{
					        //           0=Item ID#1=ItemBrand Id#2=Batch No#3=Stock Status Code#4=RequestedQty(0)#5=Unit Name#6=Transfer Qty#7=Rate
					newStr= newStr+"$$$$"+chkObj[nTmpI].value.split("^")[0]+"#"+chkObj[nTmpI].value.split("^")[1]+"#"+chkObj[nTmpI].value.split("^")[15]+"#"+chkObj[nTmpI].value.split("^")[32]+"#0#"+unitObj[nTmpI].value+"#"+issueQtyObj[nTmpI].value+"#"+rateObj[nTmpI].value.split("^")[1];
					
				}		
			}
			//alert("After Adding this:::"+newStr);
			document.getElementById("strItemDtlWithIssueQty").value =  newStr;
	/*
    	    var issueQtyUnit  = document.getElementById("strUnitName" + index).value;
		    var issueQty      = (document.getElementById("strTransferQty" + index).value)*(issueQtyUnit.split("^")[1]);
		   	
		    var temp          = document.getElementById("itemCalcValue" + index).value.split("^");
		    var avlQtyBaseVal = temp[0];
		   
			    if (parseFloat(avlQtyBaseVal) < issueQty) 
			    {
				  alert("Transfer Quantity cannot be greater than Avalaible Quantity");
				  document.getElementById("strTransferQty" + index).value = "0";
				  document.getElementById("strUnitName" + index).value = "0";
				     
					  calculateTotalTransferCost(index);
			        
				   return false;
			    }
			    else
			    {
			    	var  temp1          = document.getElementById("itemCalcValue" + index).value.split("^");
                    var  rateObj        = temp1[1];
	            
		            var  qtyObj         = document.getElementById("strTransferQty"+index).value;
		            var  qty_base_value = selected_obj.value.split("^")[1];
		            
		            var qty    = qtyObj;	
					var rate   = rateObj;
				    
					var total  = 0;
				
					if(isNaN(rate) || rate=="") rate = "0";
					if(isNaN(qty)  || qty=="") qty = "0";
							
					total = parseFloat(qty * qty_base_value * rate);
					
					document.getElementById("strTransferCost"+index).value = total;
					document.getElementById("strTransferCostDivId"+index).innerHTML = total;
					
					
					totalCostforNewDemand();
			    	
			    }
      */
}

function totalCostforNewDemand()
{	   
       	    var costObj = document.getElementsByName("strTransferCost");
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
	    document.getElementById("strTotalTransferCostDivId").innerHTML = total;
        document.forms[0].strTotalTransferCost.value=total;
       
}
 
 function calculateTotalTransferCost(index) 
 {      
 	        var costArray           = new Array();
	        var rateObj             = document.getElementsByName("itemCalcValue");
	        var qtyObj              = document.getElementsByName("strTransferQty");
	        var qty_base_value      = document.getElementsByName("strUnitName");
	        var cost                = document.getElementsByName("strTransferCost");
	        var costDiv             = document.getElementsByName("strTransferCostDivId");
	        
	        var total               = parseFloat("0.00");
	        for(var nTmpI=0;nTmpI<rateObj.length-1;nTmpI++)
			{
				 if(qty_base_value[nTmpI].value!="0")
				 {		
			            if(isNaN(qtyObj[nTmpI].value)  || qtyObj[nTmpI].value=="" || isNaN(rateObj[nTmpI].value.split("^")[1]) || rateObj[nTmpI].value.split("^")[1]=="" ) 
			            {
			                qtyObj[nTmpI].value = "0";
			                rateObj[nTmpI].value.split("^")[1] = "0";
			                costArray[nTmpI] = "0";
						}
						else
						{
						   costArray[nTmpI] = roundValue(parseFloat(qtyObj[nTmpI].value * qty_base_value[nTmpI].value.split("^")[1] * rateObj[nTmpI].value.split("^")[1]), 2)
						}
						cost[nTmpI].value    = costArray[nTmpI];
						costDiv[nTmpI].value = costArray[nTmpI];
				 }
				 else
				 {
				   alert("Please Select Unit!!!");
				   cost[nTmpI].value    = "0";
				   costDiv[nTmpI].value = "0";
				   return false;
				 
				 }		
												
						
			}
			            var costObj = document.getElementsByName("strTransferCost");
						var total   = parseFloat("0.00");
						
					   	if (costObj.length > 0) 
						{
					       
							for ( var i = 0; i <costObj.length; i++)
							{		        	
									
								total = total + parseFloat(costObj[i].value);
					 		}
					
						}
			
				      total = roundValue(total, 2);
				      document.getElementById("strTotalTransferCostDivId").innerHTML = total;
			          document.forms[0].strTotalTransferCost.value=total;
 	 				
	return true;
 }
 
 
 function issueQtyValidation(index) 
 {
	if (document.getElementById("strUnitName" + index).value != "0"	&& document.getElementById("strTransferQty" + index).value != "") 
	{
		var issueQtyUnit  = document.getElementById("strUnitName" + index).value;
		var issueQty      = (document.getElementById("strTransferQty" + index).value)*(issueQtyUnit.split("^")[1]);
		var temp          = document.getElementById("itemCalcValue" + index).value.split("^");
		var avlQtyBaseVal = temp[0];
		if (parseFloat(avlQtyBaseVal) < issueQty) 
		{
			alert("Transfer Quantity cannot be greater than Avalaible Quantity");
			document.getElementById("strTransferQty" + index).value = "0";
			document.getElementById("strUnitName" + index).value = "0";
			 var chkObj = document.getElementsByName("strTransferQty");
	         
			  calculateTotalTransferCost(index);
	         
			return false;
		}

	} 
	else 
	{
		if(document.getElementById("strUnitName" + index).value == "0") 
		{
			alert("Please Select Unit!!!");
			document.getElementById("strTransferQty" + index).value = "0";
		}
			
		return false;

	}
		
	/*
	             Here We Preserv Value 
	       */
	       var chkObj      = document.getElementsByName("itemUserValue");
	       var unitObj     = document.getElementsByName("strUnitName");
	       //var reqQtyObj   = document.getElementsByName("strReqQty");
	       var issueQtyObj = document.getElementsByName("strTransferQty");
	       var rateObj     = document.getElementsByName("itemCalcValue");
	       var newStr = "";
	       var flag=true;      
	       document.getElementById("strItemDtlWithIssueQty").value="";
	       	 
	        for(var nTmpI=0;nTmpI<chkObj.length-1;nTmpI++)
			{		
				//alert(flag);	
				if(flag)
				{	//        0=Item ID                                 1=Item Brand ID                     2=Batch Number                         3=Stock Status Code               4=Requested     5=Unit                   6=Transfer Qty            7=Rate                    
					newStr = chkObj[nTmpI].value.split("^")[0]+"#"+chkObj[nTmpI].value.split("^")[1]+"#"+chkObj[nTmpI].value.split("^")[15]+"#"+chkObj[nTmpI].value.split("^")[32]+"#0#"+unitObj[nTmpI].value+"#"+issueQtyObj[nTmpI].value+"#"+rateObj[nTmpI].value.split("^")[1];
					//newStr = varTemp[0]+"#"+varTemp[1]+"#"+varTemp[15]+"#"+varTemp[32]+"#"+document.getElementById("strUnitName"+index).value+"#"+document.getElementById("strIssueQty"+index).value;
					flag = false;
				}
				else
				{                         //        0=Item ID                                 1=Item Brand ID                     2=Batch Number                         3=Stock Status Code               4=Requested     5=Unit                   6=Transfer Qty            7=Rate     
					newStr= newStr+"$$$$"+chkObj[nTmpI].value.split("^")[0]+"#"+chkObj[nTmpI].value.split("^")[1]+"#"+chkObj[nTmpI].value.split("^")[15]+"#"+chkObj[nTmpI].value.split("^")[32]+"#0#"+unitObj[nTmpI].value+"#"+issueQtyObj[nTmpI].value+"#"+rateObj[nTmpI].value.split("^")[1];
					//newStr= newStr+"$$$$"+varTemp[0]+"#"+varTemp[1]+"#"+varTemp[15]+"#"+varTemp[32]+"#"+document.getElementById("strUnitName"+index).value+"#"+document.getElementById("strIssueQty"+index).value;
				}		
						
										
				
			}
			//alert("After Adding this:::"+newStr);
			document.getElementById("strItemDtlWithIssueQty").value =  newStr;
	
	
	  calculateTotalTransferCost(index);
}
 
 
 function validate1()
 {
	  var hisValidator = new HISValidator("itemTransferTransBean");  
	  hisValidator.addValidation("strStoreName","dontselect=0","Please select a value from Drug Warehouse Name Combo" );
	  hisValidator.addValidation("strToStoreName","dontselect=0","Please select a value from To Drug Warehouse Name Combo" );
	  hisValidator.addValidation("strItemCatCmb","dontselect=0","Please select a value from Item Category Combo" );
	  //hisValidator.addValidation("strGroupIdForItemSearch","dontselect=0","Please select a value from Group Name Combo" );
      hisValidator.addValidation("strTransferQty","req","Transfer Qty is a Mandatory Field" );
      hisValidator.addValidation("strUnitName","dontselect=0","Please select a value from Unit Name Combo" );
      
      hisValidator.addValidation("strReceivedComboBy","dontselect=0","Please Select a Value from Received By Combo" );
	  hisValidator.addValidation("strReceiveBy", "req", "Name of the Receiver is a Mandatory Field");
      //hisValidator.addValidation("strReceiveBy","req","Received By is a Mandatory Field" );
	  hisValidator.addValidation("strRemarks","req","Remarks is a Mandatory Field" );
	  hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	  var retVal = hisValidator.validate(); 
	  hisValidator.clearAllValidations();
	  var itemUsrVal  =document.getElementsByName("itemUserValue");
	  var unitNameCmb =document.getElementsByName("strUnitName");
	  var trnsferQty  =document.getElementsByName("strTransferQty");
	  var myArray  =new Array();
	  var myArray1 =new Array();
	  var trnsQtyVal="0";
	  //alert(document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].text);
	  document.forms[0].strDwhName.value =  document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].text
	 /* for(var x=0;x<itemUsrVal.length-1;x++)
	  {
	    if(retVal)
	    {
	      myArray=itemUsrVal[x].value.split("^");
	      myArray1=unitNameCmb[x].value.split("^");
	      trnsQtyVal=parseInt(trnsferQty[x].value)* parseInt(myArray1[1]); 
	      if(trnsQtyVal>myArray[7])
	      {
	     	alert("Transfer Qty cannot be greater than Available Qty!!");
	     	retVal=false;
	      }  
	    } 
	  }*/   
		if(retVal)
		{
			
			  var conf = confirm("You Are Going To Save Records");
              if(conf == true)
              {
                   var conf1 = confirm("Are you sure !!!");
                   if(conf1 == true)
                   {
					      validateOnSubmit('2','','');
						  document.forms[0].hmode.value="INSERT";
						  document.forms[0].strStoreName.disabled=false;
					      document.forms[0].strItemCatCmb.disabled=false;
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
	 

function cancel()
{
	 	document.forms[0].hmode.value="INITIALPAGE";
		document.forms[0].submit();
}
 

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
 
 function getGroupNameCombo()
 {
   var temp = document.forms[0].strStoreName.value;
   var mode="GRPNAMECOMBO";
   var url="ItemTransferTransCNT.cnt?hmode="+mode+"&storeId="+ temp+"&itemCatId="+document.forms[0].strItemCatCmb.value;
   ajaxFunction(url,"1"); 
 }
 function getItemCatCombo(obj)
 {
   var temp=new Array();
   temp = document.forms[0].strStoreName.value.split("^");
   document.forms[0].strDwhName.value = document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].text;
   document.forms[0].strTmpStoreNo.value = document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].value;
   
     var objVal2 = document.getElementById("ItemCatCmbDIV");
     	 objVal2.innerHTML = "<select name='strItemCatCmb' class='comboMax' onChange='getGroupNameCombo();'><option value='0'>Select Value</option></select>";
     	 var objVal1 = document.getElementById("toStoreName");
         objVal1.innerHTML = "<select name='strToStoreName' class='comboMax' onChange='getReceivedByCombo();'><option value='0'>Select Value</option></select>";
   
   if(temp[0]!='0')
   {
   	var mode="ITEMCATCOMBO";
   	var url="ItemTransferTransCNT.cnt?hmode="+mode+"&storeId="+ temp[0];
   	ajaxFunction(url,"2");
   }
   	   
    
 }
 function getReceivedByCombo()
 {
   var temp = document.forms[0].strToStoreName.value;
   var mode="RECEVBYCMB";
   var url="ItemTransferTransCNT.cnt?hmode="+mode+"&storeId="+ temp+"&itemCatId="+document.forms[0].strItemCatCmb.value;
   //alert(url);
   ajaxFunction(url,"3"); 
 	
 }
 
 // function to show report after save data
function getReport()
{
	costReq();
	var transferNo    = document.forms[0].strTmpTransferNo.value;
	var storeId       = document.forms[0].strTmpStoreNo.value;
	var transferDate  = document.forms[0].strTmpTransferDate.value;    
   
    
 if(transferNo!='0')
 { 
   var mode="TRANSFERDTL";
   var url="ItemTransferTransCNT.cnt?hmode="+mode+"&transferNo="+ transferNo+"&storeId="+storeId+"&transferDate="+transferDate+"&dwhName="+document.forms[0].strStoreName[document.forms[0].strStoreName.selectedIndex].text;
   
   ajaxFunction(url,"4");
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
        var objVal1 = document.getElementById("toStoreName");
            objVal1.innerHTML = "<select name='strToStoreName' class='comboMax' onChange='getReceivedByCombo();'>" + res + "</select>";
        
     }
     if(mode=="2")
     {
     	 var objVal2 = document.getElementById("ItemCatCmbDIV");
     	 objVal2.innerHTML = "<select name='strItemCatCmb' class='comboMax' onChange='getGroupNameCombo();'>"+res+"</select>";
     	 //getGroupNameCombo(); //Aritra Change. 03-Feb-2011
     }
     if(mode=="3")
     {
     	 var objVal2 = document.getElementById("receivedByCmb");
     	 objVal2.innerHTML = "<select name='strReceivedComboBy' class='comboMax'onchange='checkValCombo();'>"+res+"</select>";
     	
     }
     if(mode=="4")
     {
     	
     	 var objVal2 = document.getElementById("transferDtlsDivId");
     	 objVal2.innerHTML = res;
     	 popup('popUpDiv1', '100', '80');
     	 document.forms[0].strTmpTransferNo.value ="0";
     	
     }
}

function hideTransferPopup(mode)
{
		
				 
          document.getElementById("transferDtlsDivId").innerHTML = "";			
		  hide_popup('popUpDiv1');
		 
		
}

function printDataForTransfer() 
{

	newwin = window.open('', 'printwin',
			'left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n')
	newwin.document.write('<script>\n');
	newwin.document.write('function chkstate(){ \n');
	// newwin.document.write('if(document.readystate=="complete" ||
	// document.readystate=="undefined"){\n');
	newwin.document.write('window.close();\n');
	// newwin.document.write('}\n');
	// newwin.document.write('else{\n');
	// newwin.document.write('setTimeout("chkstate()",2000)\n');
	// newwin.document.write('}\n');
	newwin.document.write('}\n');
	newwin.document.write('function print_win(){\n');
	newwin.document.write('window.print();\n');
	newwin.document.write('chkstate();\n');
	newwin.document.write('}\n');

	newwin.document.write('<\/script>\n');
	newwin.document.write('</HEAD>\n');
	newwin.document.write('<BODY onload="print_win()">\n');
	
	newwin.document.write(document.getElementById('transferDtlsDivId').innerHTML);
	
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}	
 
  
function unitCmbChng(mode,index,unitObject)
{
	       
		    var issueQty      = (document.getElementById("strTransferQty" + index).value)*(unitObject.value.split("^")[1]);
		   		   
		    var temp          = document.getElementById("itemCalcValue" + index).value.split("^");
		    var avlQtyBaseVal = temp[0];
		    
		    
			    if (parseFloat(avlQtyBaseVal) < issueQty) 
			    {
				  alert("Transfer Quantity cannot be greater than Avalaible Quantity");
				  document.getElementById("strTransferQty" + index).value = "0";
				 
				   return false;
			    }
			    
	
	/*
	retValCalculateCost=calculateCost(mode, "strTransferQty", unitObject.name,"strTransferCost" , index, "strTotalTransferCost" ,1);
 	if(document.getElementsByName("strTransferQty")[parseInt(index.split("-")[1])-1].value=="0")
 	{
 		retValCalculateCost=false;
 		//alert("Transfer Qty cannot be Zero");
 		document.getElementsByName("strTransferQty")[parseInt(index.split("-")[1])-1].value="";
 	}
 	
 	retValCalculateCost=true;
 	if(retValCalculateCost)
 	{
 		document.getElementById("totTrnsCostDIV").style.display="block";
 	}*/
}    