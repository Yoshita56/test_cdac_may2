function getItemDrugList() 
{
	clearItemDiv();
		
	var strItemCategory = document.forms[0].strItemCategory.value ;
    var strRequestType 	= document.forms[0].strIndentTypeId.value;
    var strFromStoreId 	= document.forms[0].strStoreId.value;
    var strToStoreId 	= document.forms[0].strToStoreCombo[document.forms[0].strToStoreCombo.selectedIndex].value;
    
	var mode = "GET_ITEM_DRUG_LIST";
	var url = "IndentTransADDBSCNT.cnt?hmode=" + mode + "&strItemCategory="+ strItemCategory+ "&strRequestType="+ strRequestType+ "&strFromStoreId="+ strFromStoreId+ "&strToStoreId="+ strToStoreId;
	//alert(url);
	ajaxFunction(url, "1");
}
function getAjaxResponse(res, mode) 
{
	var err = document.getElementById("errMsg");
	var temp = res.split("####");
	if (temp[0] == "ERROR") 
	{
		err.innerHTML = temp[1];
		return;
	}
	if (mode == "1") 
	{
		
		var objVal1 = document.getElementById("drugComboId");
		objVal1.innerHTML = "<select name='strMultiRowItemId'     id='strMultiRowItemId' class='form-control form-control-sm' >"
				+ res + "</select>";	
		
		mostrarOdonto();
								
		document.forms[0].strItemCatNo.value  = document.forms[0].strItemCategory.value ;
		
				
	}	
}
function mostrarOdonto() 
{
    $.renderList();
};

$.renderList = function() 
{
	var itemList = [];
	$('#strMultiRowItemId option').each(function() {
		itemList.push({
			"value" : this.textContent,
			"data" : this.value
		});
	});

	$('#strSearchDrug').autocomplete({
		lookup : itemList,
		minChars : 2,
		formatResult: function(suggestion, currentValue) 
		{
			//alert(suggestion.value.toLowerCase());
	        var color = suggestion.value.toLowerCase().includes('[avl]') ? 'green' : 'red';
	        return '<span style="color:' + color + ';"><b>' + suggestion.value + '</b></span>';
	    },
		onSelect : function(suggestion) 
		{
			document.getElementById("strItemCategory").disabled=true;
			document.getElementById("strToStoreCombo").disabled=true;
			getDrugNameSelected_off_Line(suggestion.data);
		}
	});

	$('#strSearchDrug').click(function() {
		$(this).val("");

	});
	 //console.log("I am calling form jquery");
	 //console.log(itemList);
	 
};
/**
 * This Method is Used for Show Sucessfully Indent Creation Msg
 */
function getConfirmation()
{
	var indentNo = document.forms[0].indentNo.value;
	
	if(indentNo!="0")
	{
		var Obj = document.getElementById("indentCreateDivId");            
		Obj.innerHTML = "<table width='500' align='center' cellpadding='1px' cellspacing='1px'>" +
		                "<tr><td align='right'><img style='cursor: pointer; ' title='Close Pop-Up'  src='../../hisglobal/images/stop.png' onClick='hideIssuePopup();cancel();' /> </div></td></tr>"+  
				        "<tr><td colspan='8' align='center'><br/><H3><strong><FONT COLOR='#CC0033' SIZE='6'>!!  Indent Sucessfully Created  !!</FONT></strong></H3><br/><br/></td></tr></table>";

		popup('popUpDiv', '240', '280');
	}
	document.forms[0].indentNo.value ="0";
}

function hideIssuePopup()
{
		document.getElementById("indentCreateDivId").innerHTML = "";
		hide_popup('popUpDiv');
}


/** This is the validate function for Breakage Item Details jsp file
 *  i.e:- add_BreakageItemDtlTrans_mms.jsp and 
 *  transfer control to the controller 'INSERT' method.  
 */
 
function validate1()
{      
	document.getElementById("strToStoreCombo").disabled=false;
	var saveObj = document.getElementById("saveId");
	//alert(document.forms[0].strIndentPeriod.value)
	if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	{
		saveObj.style.display = "none"; 
		
	//if(document.forms[0].strIndentPeriod.value == '0')
	//{
	//	alert("Please Select Indent Period!!!")
	//	return false;
	//}strIndentPeriod
	  var hisValidator = new HISValidator("indentTransADDBean");  
	 // hisValidator.addValidation("strIndentPeriod","dontselect=0","Indent Period is a Mandatory Field" );
	//  hisValidator.addValidation("strToStoreCombo","dontselect=0","Please select a value from To Store Combo" );
	  //hisValidator.addValidation("strGroupIdForItemSearch","dontselect=0","Please select a value from Group Name Combo" );
	  hisValidator.addValidation("strRemarks","req","Remarks is a Mandatory Field" );
	  hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	  var retVal = hisValidator.validate(); 
	  var itemParVal  = document.getElementsByName("itemParamValue");
      var unitNameCmb = document.getElementsByName("strUnitName");
      var reqQty  = document.getElementsByName("strReqQty");
      var myArray   = new Array();
      var myArray1  = new Array();
      var reqQtyVal="0";
      var count = parseInt("0");
      var avlBudget = parseFloat(document.forms[0].strAvalaibleBudget.value);
      //var orderCost = parseFloat(document.forms[0].strApproxAmt.value);
     if(retVal)
     {  	
    	 
    	 if(document.forms[0].strIndentPeriod.value == '0')
    	{
    		 alert("Indent Period is a Mandatory Field");
    		 saveObj.style.display = ""; 
    		 return false;
    	}
     
       if(itemParVal.length > 1)
       {
       for(var x=0;x<itemParVal.length-1;x++)
       {
          hisValidator.addValidation("strReqQty","req","Required Quantity is a Mandatory Field" );
	   
          var retVal1 = hisValidator.validate(); 
          if(retVal1)
          {
            myArray = itemParVal[x].value.split("^");
            myArray1 = unitNameCmb[x].value.split("^");
            count = count +1;
                     
          } 
          else
	       {
	       	 saveObj.style.display = '';
		      return false;
           }  
           
        }
        if(count>0)
        {
        								
                  var conf = confirm("You Are Going To Save Records");
                  if(conf == true)
                  {
                       var conf1 = confirm("Are you sure !!!");
                       if(conf1 == true)
                       {
                    	   
                    	    document.forms[0].strItemCatNo.disabled = false;
 						    document.forms[0].hmode.value = "INSERT";
						    document.forms[0].submit();
                       }
                      else
                       {
                       	 saveObj.style.display = '';
                         return false;
                          
                       }
                   }
                  else
                   {
                   	 saveObj.style.display = '';
                         return false;								                          
                   }    
        							                   
        }
        
        
       }
       else
	  { 
	      alert("Please Select Item from Search Utility!!!");
	       saveObj.style.display = '';
		  return false;
	  }
        
     }
     else
	 {
	 	 saveObj.style.display = '';
		  return false;
     } 
      
	}
	else
  	{
  	    saveObj.style.display = '';
		return false;
  	}   
      
	  
}

function initPage()
{
	
	
	document.getElementById("errMsg").innerHTML = "";
    document.forms[0].hmode.value="FIRSTDATA";
	document.forms[0].submit();
  
}

function initPage_ORG()
{
 // document.forms[0].strToStoreCombo.value = '0';
 document.getElementById("strToStoreCombo").disabled=false;
  document.forms[0].strIndentPeriod.value = '0';
  document.forms[0].strIndentPeriodValue.value ="";  
  document.getElementById("errMsg").innerHTML = "";
  document.forms[0].strRemarks.value =""; 
  
  document.getElementById("id1").style.display = "none";
  clearItemDiv();
  
}


function cancel()
{
	document.getElementById("errMsg").innerHTML = "";
    document.forms[0].hmode.value="CANCEL";
	document.forms[0].submit();
}
function ftnTick()
{
  if(document.forms[0].isNormal.value=='1')
   {
     document.forms[0].isNormal.checked = false;
     document.forms[0].isNormal.value=0;
   }
   if(document.forms[0].isNormal.checked == true)
   {
    document.forms[0].isNormal.value=1;
    if(document.forms[0].isUrgent.checked == true)
    {
       document.forms[0].isUrgent.checked = false; 
    }
   }
   else
   {
     document.forms[0].isNormal.value=0;
   }
   if(document.forms[0].isUrgent.checked == true)
   {
    document.forms[0].isUrgent.value=1;
    if(document.forms[0].isNormal.checked == true)
    {
       document.forms[0].isNormal.checked = false; 
    }
   }
   else
   {
      document.forms[0].isUrgent.value=0;
   }
}


function avlBudgetDtl(obj) 
{

	parentPopUp = obj;

	var strBalQtyDetail = document.forms[0].strAvalaibleBudgetDtl.value;

	myArray = strBalQtyDetail.split("$$");

	var objVal1 = document.getElementById("1");

	if (myArray[0] != 'null' || myArray[0] != '') 
	{
		objVal1.innerHTML = myArray[0];
	} 
	else 
	{
		objVal1.innerHTML = "  ----";
	}

	var objVal2 = document.getElementById("2");

	if (myArray[1] != 'null') 
	{
		objVal2.innerHTML = myArray[1];
	} 
	else 
	{
		objVal2.innerHTML = "  ----";
	}

	display_popup_menu(parentPopUp, 'avalaibleBudgetDtlId', '300', '');

}
