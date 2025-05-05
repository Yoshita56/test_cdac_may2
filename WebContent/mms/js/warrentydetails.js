function getCombos(mode)
	{ 

	 var url;
	 
	 if(mode=="GROUPNAME"){
		 url="WarrentyDetailsTransCNT.cnt?hmode="+mode+"&itemCategoryId="+document.forms[0].strItemCategoryID.value; 
	 ajaxFunction(url,"1");
	}
	
	else if(mode=="SUBGROUPNAME"){
	
	url="WarrentyDetailsTransCNT.cnt?hmode="+mode+"&groupId="+document.forms[0].strGroupID.value;

	ajaxFunction(url,"2");
	}else if(mode=="ITEMNAME"){
	
	url="WarrentyDetailsTransCNT.cnt?hmode="+mode+"&groupId="+document.forms[0].strGroupID.value+"&subGroupId="+document.forms[0].strSubGroupID.value;

	ajaxFunction(url,"3");
	}else if(mode=="BRANDNAME"){
	
	url="WarrentyDetailsTransCNT.cnt?hmode="+mode+"&itemId="+document.forms[0].strItemID.value;

	ajaxFunction(url,"4");
	}
	}
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
			objVal= document.getElementById("GroupId");
			objVal.innerHTML = "<select name ='strGroupID' class='comboNormal' onchange ='getCombos(\"SUBGROUPNAME\");'>" + res + "</select>";
			}
	}
	else if(mode=="2"){
				var err = document.getElementById("errMsg");
	 			var temp1 = res.split("####");
         
         
       			  if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
      				   }
				else{
				var objVal = document.getElementById("SubGroupId");
				objVal.innerHTML = "<select name='strSubGroupID' class='comboNormal' onchange ='getCombos(\"ITEMNAME\");'>" + res + "</select>";
				
				getCombos("ITEMNAME");
				// var objVal = document.getElementById("ItemId");
				// objVal.innerHTML = "<select name='strItemID' onchange ='getCombos(\"BRANDNAME\");' >" + res + "</select>";
				}
	}
	
	else if(mode=="3"){
				var err = document.getElementById("errMsg");
	 			var temp1 = res.split("####");
         
         
       			  if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
      				   }
				else{
				var objVal = document.getElementById("ItemId");
				objVal.innerHTML = "<select name='strItemID' class='comboNormal' onchange ='getCombos(\"BRANDNAME\");' >" + res + "</select>";
				}
	}else if(mode=="4"){
				var err = document.getElementById("errMsg");
	 			var temp1 = res.split("####");
         
         
       			  if(temp1[0] == "ERROR"){
         			err.innerHTML = temp1[1];	
      				   }
				else{
				var objVal = document.getElementById("BrandId");
				objVal.innerHTML = "<select name='strBrandID'  class='comboNormal'>" + res + "</select>";
				}
	}
	}
	function validate1(){   
     
            var hisValidator = new HISValidator("warrentyDetailsBean");
          
            hisValidator.addValidation("strTenderNo", "req", "Tender No is a mandatory Field" );
            hisValidator.addValidation("strQuotationNo", "req", "Quotation No is a mandatory Field" );
            hisValidator.addValidation("strPoNo", "req", "PO No is a mandatory Field" );
            hisValidator.addValidation("strBatchSlNo", "req", "Batch Serial No is a mandatory Field" );
            hisValidator.addValidation("strManufacturerID", "dontselect=0", "Please select a Supplier Manufacturer Name" );
            hisValidator.addValidation("strItemCategoryID", "dontselect=0", "Please select an Item Category Name" );
            hisValidator.addValidation("strGroupID", "dontselect=0", "Please select a Group Name" );
            hisValidator.addValidation("strItemID", "dontselect=0", "Please select an Item Name" );
            hisValidator.addValidation("strBrandID", "dontselect=0", "Please select a Brand Name" );
            
            hisValidator.addValidation("strWarrentyStartDate", "date","Warrenty Strat Date Date is a mandatory field");
            hisValidator.addValidation("strWarrentyStartDate", "dtltet="+document.forms[0].strCtDate.value, "Warrenty Start date must be less than or equal to Current date " );
            
            hisValidator.addValidation("strWarrentyUpto", "req", "Warrenty Upto is a mandatory Field" );
            hisValidator.addValidation("strWarrentyUpto", "numgt=0", "Warrenty Upto must be greater than 0 " );
            if(document.forms[0].strWarrentyUnit.value=="1"){
            hisValidator.addValidation("strWarrentyUpto", "numltet=364", "Warrenty Upto must be less than or equal to 364 Days" );
            }else if(document.forms[0].strWarrentyUnit.value=="2"){
            hisValidator.addValidation("strWarrentyUpto", "numltet=11", "Warrenty Upto must be less than or equal to 11 Months" );
            }else if(document.forms[0].strWarrentyUnit.value=="3"){
            hisValidator.addValidation("strWarrentyUpto", "numltet=99", "Warrenty Upto must be less than or equal to 99 Years" );
            }
            
		    hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );

            var retVal = hisValidator.validate(); 

          if(retVal){
          
                       document.forms[0].hmode.value = "SAVE";
                       document.forms[0].submit();
          }else{
         hisValidator.clearAllValidations();
             return false;
          }
}
function cancelProcess(){
 document.forms[0].hmode.value = "CANCEL";
 document.forms[0].submit();
}