function transferToViewPageNEW()
{
		//alert(transferToViewPageNEW);
		document.forms[0].hmode.value="VIEWPAGE";
		document.forms[0].submit();
	
}
// This function is used to call the ITEMCATEGORY cnt action which populates the value of group name combo box
function getItemCategoryCmb()
{
	var url;
	var mode = "ITEMCATEGORY";
	url="MiscellaneousConsumptionTransCNT.cnt?hmode="+mode+"&storeComboId="+document.forms[0].strStoreId.value;
				//+"&reqType="+document.forms[0].strRequestType.value; 
 	ajaxFunction(url,"1");

}

// This function is used to call the GROUPNAME cnt action which populates the value of group name combo box
function getGroupCombo()
{
	
	var url;
	var mode = "GROUPNAME";
	
	url="MiscellaneousConsumptionTransCNT.cnt?hmode="+mode+"&itemCatId="+document.forms[0].strItemCategoryId1.value; 
 	ajaxFunction(url,"2");

}

function getAjaxResponse(res,mode)
	{
	
	
	var objVal;
	if(mode=="1"){   
			alert(url);
			var err = document.getElementById("errMsg");
		 	var temp1 = res.split("####");
			         
        	 if(temp1[0] == "ERROR"){
         		err.innerHTML = temp1[1];	
        	 }
			else{
			objVal= document.getElementById("itemCatDivId");
			//objVal.innerHTML = "<select name ='strItemCategoryId1' onchange='getGroupCombo();' class='comboMax'>" +res+ "</select>";
			objVal.innerHTML = "<select name ='strItemCategoryId1' onchange='getGroupCombo();' class='browser-default custom-select'>" +res+ "</select>";
			}
	}
	if(mode=="2")
	{   
	
			var err = document.getElementById("errMsg");
		 	var temp1 = res.split("####");
			         
        	 if(temp1[0] == "ERROR")
        	 {
         		err.innerHTML = temp1[1];	
        	 }
			
		}
	}
	
//used for mandatory field validation.

function validate1() {

   	var hisValidator = new HISValidator("miscellaneousConsumptionBean"); 
  	
   	hisValidator.addValidation("strStoreId","dontselect=0","Please select a Drug Warehouse Name");
   	hisValidator.addValidation("strItemCategoryId1","dontselect=0","Please select an Item Category");  
   //	hisValidator.addValidation("strIndentNo", "req", "CR No is a mandatory field" );
	//hisValidator.addValidation("strIndentNo","maxlen=14", "CR No should be less than equals to 14 Characters");
   	//hisValidator.addValidation("strPatientName", "req", "Patient Name is a mandatory field" );
   	//hisValidator.addValidation("strGroupIdForItemSearch","dontselect=0","Please select a Group Name");
	hisValidator.addValidation("strRemarks", "req", "Remarks is a mandatory field" );
   	hisValidator.addValidation("strRemarks","maxlen=290", "Remarks should be equals to 300 Characters");
   	
   	var retVal = hisValidator.validate();
   	   	 
   	    if(retVal)
     	 {
     	 	if(document.getElementsByName("itemParamValue").length=="1")
     		{
     			alert("Please Search Item Details");
     			return false;
     		}
     		else
     		{
     			retVal=true;
     		}
     	 }
     	if(retVal)
     	{
     		 hisValidator.addValidation("strConsumptionQty", "req", "Consumption Quantity is a mandatory field" );
    		 hisValidator.addValidation("strConsumptionQty", "amount=7,2", "Consumption Quantity should be in 00000.00 format" );
   			 hisValidator.addValidation("strUnitName","dontselect=0","Please select a Consumption Unit");
     	 	 var retVal = hisValidator.validate(); 
          	 hisValidator.clearAllValidations();
         }   	
         if(retVal)
         {
  		
	  		var itemUsrVal   = document.getElementsByName("itemCalcValue");
			var unitNameCmb = document.getElementsByName("strUnitName");
		    var consumQty  = document.getElementsByName("strConsumptionQty");
		    var myArray   = new Array();
		    var myArray1  = new Array();
		    var consumQtyVal="0";
		    var count = 0;
		    for(var x=0;x<itemUsrVal.length-1;x++)
		    {
		    	myArray=itemUsrVal[x].value;
		    	if(parseFloat(myArray.split("^")[0]) < parseFloat(consumQty[x].value))
		    	{
		    		alert("Consumption Quantity cannot be greater than Avalaible Quantity");
		    		consumQty[x].value = "";
		    		return false;
		    	}
	             if(consumQty[x].value=="" || consumQty[x].value=="0")
	             {
	               count++;
	             }  
	        } 
	        if(count == (itemUsrVal.length-1))
	        {
	        	alert("Consumption Quantity is a mandatory field!!!");
	        	consumQty[0].focus();
	        	return false;
	        }
	        
	       
	       
	              var conf = confirm("You Are Going To Save Records");
	              if(conf == true)
	              {
	                   var conf1 = confirm("Are you sure !!!");
	                   if(conf1 == true)
	                   {
	                   	      document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;					     
							  document.forms[0].hmode.value="SAVE";						  
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
  	else{
  		return false;
  		}
    }
  
/**
 * checkAvailQty - Qty validation.
 * 
 * @param {String}
 *            unitName
 * @param {String}
 *            qtyName
 */
function checkQtyMiscValidation(index, qtyName, unitName)
{

	var unitObj = document.getElementById(unitName + "" + index);
	var qtyObj  = document.getElementById(qtyName + "" + index);
	var unitVal = unitObj.value.split('^')[1];	
	var temp          = document.getElementById("itemCalcValue" + index).value.split("^");
	var avlQtyBaseVal = temp[0];
	
	if (parseInt(avlQtyBaseVal) < (parseInt(qtyObj.value,10)*unitVal)) 
    {
	  alert("Consumption Quantity cannot be greater than Avalaible Quantity");
	  document.getElementById("strConsumptionQty" + index).value = "";
	 
	   return false;
    }

	return true;
}  
  
function invokeCheckQty(mode, index, unitObject)
{	
	        
	        var issueQty      = (parseFloat(document.getElementById("strConsumptionQty" + index).value),10)*(unitObject.value.split("^")[1]);
		   	var temp          = document.getElementById("itemCalcValue" + index).value.split("^");
		    var avlQtyBaseVal = temp[0];
		    
		    
			    if (parseFloat(avlQtyBaseVal) < issueQty) 
			    {
				  alert("Consumption Quantity cannot be greater than Avalaible Quantity");
				  document.getElementById("strConsumptionQty" + index).value = "0";
				 
				   return false;
			    }
	
}	

/*function chkQtyDetl(index,unitObject)
{
	var strTemp = document.getElementById("itemParamValue"+index).value.split("#");
	var strInsertValue = strTemp[2].split("^");	
	if(parseInt(unitObject.value)>parseInt(strInsertValue[7])){
		alert("Consumption Qty cannot be greater than Available Qty");
		unitObject.value="";
	}else{
		checkQty(index,'strConsumptionQty','strUnitName');
	}
		
}*/

  
  function getItemSelectPopup(){
  
	  //alert(strModeVal);
  		setItemDtlWithIssueQty();
  		
  		var strModeVal 		= "3" ; 
		var strItemCategory = document.forms[0].strItemCategoryId1.value; 
		var strRequestType 	= "54";
		var strFromStoreId 	= document.forms[0].strStoreId.value;
		var strMultiRowCompArray  = new Array('itemParamValue', 'itemCalcValue','itemUserValue', 'strConsumptionQty','strUnitName');
		
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t','s');
		
		
		// for mode val 3
		var strMultiRowFetchDataArray 	= new Array('1','11','4','0^strUnitName^invokeCheckQty');
	
		var layerIndex = "1";
		var testFunction                = "";
		//var testFunction                = "CallFunc";
		var arg                         = " ";  
		
		var userInfo = "0";
		var unitMode = "0";  // only base unit  1 Means Only Base Unit Show 0 Means All Unit Show in Unit Combo
		
		//searchItemsWithUserFunction_ALLCatg( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg , userInfo , unitMode );
		searchItemsWithUserFunction( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg , userInfo , unitMode );

}


function setItemDtlWithIssueQty()
{
	
		var itemWithIssueQty = document.getElementById("strItemDtlWithIssueQty");
		var  itemUserVal    = document.getElementsByName("itemUserValue");
	    var issueQty    = document.getElementsByName("strConsumptionQty");
  		//var reqQty      = document.getElementsByName("strReqQty");
  		var unitNameCmb = document.getElementsByName("strUnitName");
  		//var costObj     = document.getElementsByName("strCost");
		  
				
			if(itemUserVal.length > 1)
			{
				
				var tempIssueDtls ; 
				
				for(var i = 0 ; i < itemUserVal.length - 1 ; i++)
				{

															
					if(i == 0 )
					{
						
						tempIssueDtls = itemUserVal[i].value+"@@@@"+issueQty[i].value+"@@@@"+unitNameCmb[i].value	
						
					}
					else
					{
					
						tempIssueDtls = tempIssueDtls+"$$$$"+itemUserVal[i].value+"@@@@"+issueQty[i].value+"@@@@"+unitNameCmb[i].value
					
					}
				
				}
				
				itemWithIssueQty.value = tempIssueDtls;
				
				
			}else{
				itemWithIssueQty.value = "";
					
			}
				
		
	
	}
  
  //Used to cancel the Miscellaneous Consumption page.
function cancel()
 {
     document.getElementById("errMsg").innerHTML = "";
     document.forms[0].hmode.value = "CANCEL";
     document.forms[0].submit();
 }
 
 function Clear()
{
	
	var url;
	var mode = "unspecified";
	document.forms[0].hmode.value=mode;
	document.forms[0].submit();
 	

}
 
 function getReport()
 {	
		
 var issueNo  =  document.forms[0].strConsumptionNo.value;
 var storeId  =  document.forms[0].strConsmpStoreId.value;
 var strCrNo  =  document.forms[0].strConsumptionPuk.value;
  
 	if(issueNo!="0" && issueNo != "" )
 	{
 		getIssueDtls('6', storeId, issueNo,strCrNo,"0");
 	}
 	document.forms[0].strConsumptionNo.value ="0";
 }
  
 
 function getIssueDtls(strMode, strStoreId, strIssueNo,strCrNo,strIndentDate,ucReq) 
 {
 
     var itemStockObj = document.getElementById("issueDtlsDivId");

 	if (itemStockObj.innerHTML == "") {

 		var hmode = "ISSUEDTLSINITNEW";		
 		var url = "MiscellaneousConsumptionTransCNT.cnt?hmode=" + hmode + "&strMode=" + strMode
 		+ "&strStoreId=" + strStoreId + "&strIssueNo=" + strIssueNo+"&strCrNo="+strCrNo+
 		  "&strIndentDate="+strIndentDate+
 		  "&strUCReq="+ucReq;
 		//alert(url);	
 		ajaxFunction2(url, "1", "getIssueDtlsAjaxResponse");

 	} else {
 		// set for 1024 * 760 screen don't change this
 		popup('popUpDiv', '80', '60');
 	}

 }
 			
 function getIssueDtlsAjaxResponse(res, mode) {

 	//STOCKDTLSINIT
 	if (mode == '1') {

 		var itemStockObj = document.getElementById("issueDtlsDivId");

 		itemStockObj.innerHTML = res;

 		popup('popUpDiv1', '80', '60');
 		
 		printData_O();

 	}

 }

 function hideIssuePopup(){
	 	
	 	document.getElementById("issueDtlsDivId").innerHTML = "";
	 	
	 	hide_popup('popUpDiv1');
	 	
	 }
 function printData_O() 
 {
	document.getElementById("printImg").style.display="none"; 
 	newwin = window.open('', 'printwin',
 			'left=100,top=100,width=700,height=700,scrollbars=yes');
 	newwin.document.write('<HTML><HEAD>');
 	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
 	newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } @media screen and (orientation: portrait) {  #toolbar { width: 100%; }} </style>\n')
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
 	newwin.document.write(document.getElementById('issueDtlsDivId').innerHTML);
 	newwin.document.write('</BODY>\n');
 	newwin.document.write('</HTML>\n');
 	newwin.document.close();
 	document.getElementById("printImg").style.display="block"; 

 }


 
 