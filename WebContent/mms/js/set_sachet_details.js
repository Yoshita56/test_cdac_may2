 /**
 * Developer : Anshul Jindal
 * Version : 1.0 
 * Date : 5/May/2009, 29-may-09
 *  Module:MMS
 * Unit:Set/Sachet Details
 *
 */
/**
 * Developer : Pramod Kumar Mehta 
 * Version : 1.0 
 * Date : 28/Jan/2009
 *  Module:MMS
 * Unit:Set/Sachet Details
 *
 */

 

function getItemMandatoryDtls() {
document.forms[0].strPreparedQty.focus();
   if (document.forms[0].strSetSachetId.value != '0') {
         var mode = "GETITEMMANDATORYDTLS";
         var setId = document.forms[0].strSetSachetId.value;
         var temp = setId.split("^");
         var ItemId = temp[0];
        var url = "MmsCNT.cnt?hmode=" + mode + "&itemId="+ ItemId;
        ajaxFunction(url, "6");

      } else {
		     document.forms[0].isExpirtReq.value = "0";
		    document.getElementById("expiryDateDivId").innerHTML = "Expiry Date";
	      }
}

 
 
// called on cllick go button
function goFunc()
{
	var hisValidator = new HISValidator("setSachetDetailsBean"); 
	hisValidator.addValidation("strStoreId","dontselect=0","Please select a Drug Warehouse Name");
   	hisValidator.addValidation("strSetCategoryNo","dontselect=0","Please select a Item Category");
   	hisValidator.addValidation("strGroupId","dontselect=0","Please select a Group Name");
   	hisValidator.addValidation("strSetSachetId","dontselect=0","Please select a Set/Sachet Name");
    hisValidator.addValidation("strPreparedQty", "req", "Prepared Quantity is a mandatory field" );
	hisValidator.addValidation("strPreparedQty",  "amount=7,2","Prepared Qty can be in decimal format(00000.00)");
  	var retVal = hisValidator.validate();
  	hisValidator.clearAllValidations();
  	
 
  	
  		if(retVal){
			getItemDetails();
		}
		return retVal;
		
}

// called on enter go button
function goFuncOnEnter()
{
 if(e.keyCode == 13)
   {
	 return goFunc();
	}
	else
	{
	 return false;
	}
}
// This function is used to call the GROUPNAME cnt action which populates the value of group name combo box
function getGruopCombo()
{
	if(document.forms[0].strSetCategoryNo.value!="0")
	{
		var url;
		var mode = "GROUPNAME";
		url="SetSachetDetailsTransCNT.cnt?hmode="+mode+"&storeComboId="+document.forms[0].strStoreId.value+"&CategoryNo="+document.forms[0].strSetCategoryNo.value;  
	 	ajaxFunction(url,"1");
 	}
 	

}

// This function is used to call the CATEGORY cnt action which populates the value of category combo box

function getCategoryCombo()
{
	//alert("getCategoryCombo calling "+document.forms[0].strStoreId.value);
	if(document.forms[0].strStoreId.value!='0')
 	{
 		var url;
		var mode = "CATEGORYNAME";
		url="SetSachetDetailsTransCNT.cnt?hmode="+mode+"&storeComboId="+document.forms[0].strStoreId.value;
	 	ajaxFunction(url,"2");
 	}

}
// This function is used to call the SUBGROUPNAME cnt action which populates the value of sub group name combo box
function getSubGruopCombo()
{
	if(document.forms[0].strGroupId.value!="0")
	{
		var url;
		var mode = "SUBGROUPNAME";
		url="SetSachetDetailsTransCNT.cnt?hmode="+mode+"&GroupComboId="+document.forms[0].strGroupId.value; 
	 	ajaxFunction(url,"3");
 	//alert("subgrp");
 	}
 	

}
// This function is used to call the SACHETNAME cnt action which populates the value of Set/Sachet  name combo box
function getSetSachetNameCombo()
{
	 //alert("getSetSachetNameCombo");
	 if(document.forms[0].strGroupId.value!="0")
	 {
		var url;
		var mode = "SACHETNAME";
		url="SetSachetDetailsTransCNT.cnt?hmode="+mode+"&CategoryNo="+document.forms[0].strSetCategoryNo.value+"&GroupComboId="+document.forms[0].strGroupId.value+"&SubGroupId="+document.forms[0].strSubGroupId.value; 
	 	ajaxFunction(url,"4");
	 }
 	

}

// This function is used to call the ITEMDETAILS cnt action which display the value of item details
function getItemDetails()
{
	
	var url;
	var mode = "ITEMVIEWDETAILS";
	  var strPreparedQty = document.forms[0].strPreparedQty.value; 
	   var setComboId = document.forms[0].strSetSachetId.value; 
         var temp = setComboId.split("^");
        
         var genItemId = temp[0];
          var setId = temp[1];
     
         // alert("setId-"+setId);
	url="SetSachetDetailsTransCNT.cnt?hmode="+mode+"&setId="+setId+"&strPreparedQty="+strPreparedQty+"&storeComboId="+document.forms[0].strStoreId.value;   
	// alert("url-"+url);
 	ajaxFunction(url,"5");

}

//This method is used to populate all combo box value and all item details using ajax function without submitting the page.


function getAjaxResponse(res,mode)
	{
	
	
	var objVal;
	// alert(res+"mode==="+mode);
	if(mode=="1"){   
	
			var err = document.getElementById("errMsg");
		 	var temp1 = res.split("####");
			         
        	 if(temp1[0] == "ERROR"){
         		err.innerHTML = temp1[1];	
        	 }
			else{
			//alert("res-"+res);
			objVal= document.getElementById("groupDivId");
			objVal.innerHTML = "<select name ='strGroupId' onChange='getSubGruopCombo();' class='comboNormal'>" +res+ "</select>";
			}		
			
	}
	
	if(mode=="2"){   
	
			var err = document.getElementById("errMsg");
		 	var temp1 = res.split("####");
			         
        	 if(temp1[0] == "ERROR"){
         		err.innerHTML = temp1[1];	
        	 }
			else{
			
			objVal= document.getElementById("CategoryDivId");
			objVal.innerHTML = "<select name ='strSetCategoryNo' onChange='getGruopCombo();' class='comboNormal'>" +res+ "</select>";
			}
			objVal= document.getElementById("groupDivId");
			objVal.innerHTML = "<select name ='strGroupId' onChange='getSubGruopCombo();' class='comboNormal'><option value='0'>Select Value</option></select>";
			getGruopCombo();
	}
	if(mode=="3"){   
	//alert("subgrp mode 3");
	
			var err = document.getElementById("errMsg");
		 	var temp1 = res.split("####");
			         
        	 if(temp1[0] == "ERROR"){
         		err.innerHTML = temp1[1];	
        	 }
			else{
			
			objVal= document.getElementById("subGroupDivId");
			objVal.innerHTML = "<select name ='strSubGroupId' onChange='getSetSachetNameCombo();' class='comboNormal'>" +res+ "</select>";
			}
			getSetSachetNameCombo();
	}
	if(mode=="4"){   
	
			var err = document.getElementById("errMsg");
		 	var temp1 = res.split("####");
			         
        	 if(temp1[0] == "ERROR"){
         		err.innerHTML = temp1[1];	
        	 }
			else{
			//alert("res-"+res);
			objVal= document.getElementById("SetSachetDivId");
			objVal.innerHTML = "<select name ='strSetSachetId' onChange='getItemMandatoryDtls();' class='comboNormal'>" +res+ "</select>"; 
			}
	}
	
	if(mode=="5"){   
	
	var temp;
		
			var err = document.getElementById("errMsg");
		 	var temp1 = res.split("####");
			         
        	 if(temp1[0] == "ERROR"){
         		err.innerHTML = temp1[1];	
        	 }
			else{
			
			temp = res.split("@@");
			var objDiv= document.getElementById("ItemDetailsDivId"); 
			objDiv.innerHTML = temp[0] ;  
			}
		document.forms[0].strStoreId.disabled='disabled';
  		document.forms[0].strSetCategoryNo.disabled='disabled';
  		document.forms[0].strGroupId.disabled='disabled';
  		document.forms[0].strSubGroupId.disabled='disabled';
  		document.forms[0].strSetSachetId.disabled='disabled';
  		document.forms[0].strPreparedQty.readOnly=true; 
  		
  		// alert("temp[1]-"+temp[1]);
  		if(temp[1]=='1') 
  		{
  		document.getElementById("redbuttonDiv").style.display="block";
  		}
			
	}
	 if (mode == "6") {
		    var temp = res.split('^');
			  document.forms[0].isExpirtReq.value = temp[2];

 		   if (temp[2] == '1') {
					   document.getElementById("expiryDateDivId").innerHTML = "<font color='red'>*</font>Expiry Date";
			  } else {

 			        document.getElementById("expiryDateDivId").innerHTML = "Expiry Date";

            }

      }

	}
	
	
	
	/** This Validate  method is used to check the blank field.
  * validate1
  * called on save button to validate mandatory fields and to save data
  */
  function validate1() {
  // alert("strSetCategoryNo-"+document.forms[0].strSetCategoryNo.value); 
  document.forms[0].strStoreId.disabled=false;
  		document.forms[0].strSetCategoryNo.disabled=false;
  		document.forms[0].strGroupId.disabled=false;
  		document.forms[0].strSubGroupId.disabled=false;
  		document.forms[0].strSetSachetId.disabled=false;
  		document.forms[0].strPreparedQty.readOnly=false; 
  
   	var hisValidator = new HISValidator("setSachetDetailsBean"); 
  	
   	hisValidator.addValidation("strStoreId","dontselect=0","Please select a Drug Warehouse Name");
   	hisValidator.addValidation("strSetCategoryNo","dontselect=0","Please select a Item Category");
   	hisValidator.addValidation("strGroupId","dontselect=0","Please select a Group Name");
   	hisValidator.addValidation("strSetSachetId","dontselect=0","Please select a Set/Sachet Name");
    hisValidator.addValidation("strPreparedQty", "req", "Prepared Quantity is a mandatory field" );
	hisValidator.addValidation("strPreparedQty",  "amount=7,2","Prepared Qty can be in decimal format(00000.00)");
	if(document.forms[0].isExpirtReq.value != '0')
	{
  	hisValidator.addValidation("strExpiryDate", "req", "Expiry date is a mandatory field" );
  	}
  
   	hisValidator.addValidation("strRemarks", "maxlength=100", "Remarks should not be greater than 100 characters" );

   
  	var retVal = hisValidator.validate();
  	hisValidator.clearAllValidations();
  
  if(retVal){
  
  	if(!document.forms[0].isAnyRedRow)
  	{
  		alert("Please Enter GO Button");
  		retVal = false;
  	}
  	
  	if(document.forms[0].noRecordFlag)
  	{
  		alert("No Items available to make a set");
  		retVal = false;
  	}
  
  }
  		if(retVal){
  			var redRow = document.getElementsByName("isAnyRedRow");
  			for(i=0;i<redRow.length;i++)
  			{
  			// alert("redRow[i].valuee-"+redRow[i].value);
  			if(redRow[i].value=='1')
  			{
  				alert("This Set cannot be made because Available quantity of items is less than Required Quantity ");
  				retVal = false;
  				break;
  			}
  			}
  		}
  	
  	if(retVal){
  		  	 
  	 			addData();
  	 		
  	 		}
  	 		
  	else{
  		return false; 
  		}
  		
  }
  
  
 /**This method is used to call SAVE cnt action which will insert the set sachet details and item details in database.
  * insertData 
  * called on save button to insert data into database
  * @param {type}  
  */
  function addData() {
  	document.forms[0].hmode.value = "SAVE"; 
				document.forms[0].submit();
  }   
  
    
/**This method is used to cancel the set/sachet details page.
 * initPage()
 * @param {type}  
 */
 
 function cancel()
 {
        document.getElementById("errMsg").innerHTML = "";
   document.forms[0].hmode.value = "CANCEL";
       document.forms[0].submit();
 }
   /**This method is used to Clear the set/sachet details page.
 *  
 */
	function Clear()
{
	// alert("getGruopCombo calling ");
	var url;
	var mode = "unspecified";
	document.forms[0].hmode.value=mode;
	document.forms[0].submit();
 	

}