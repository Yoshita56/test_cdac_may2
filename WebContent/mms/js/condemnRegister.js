
//************************Validation for Condemnation Desk**************************************//


/**
 * This function is invoked from desk to check whether combo is selected or not on list page.
 */

function validateCondemn()
{
	document.forms[0].comboValue.value=document.forms[0].combo[0][document.forms[0].combo[0].selectedIndex].text+"^"+document.forms[0].combo[1][document.forms[0].combo[1].selectedIndex].text;
	if(document.forms[0].combo[0].value==0){	
		alert('Please Select Store');
		return false;	
	}
	else if(document.forms[0].combo[1].value==0){
		alert('Please Select Item Category');
		return false;	
	}
	else{	
		
		//alert(document.forms[0].combo[1].value);
		document.forms[0].hmode.value="CONDEMN";
		document.forms[0].submit();
	}
}

/**
 * This function is used to perform validation during checking of check box on main list page on desk
 */

function chkUserDefinedFunc(these){
	
	var checkCount=0;
	var check=document.getElementsByName("chk");
	for(i=0;i<check.length;i++){
		if(check[i].checked==true){
			checkCount++;
		}			
	}
	try{    if(checkCount==1){
		       if(document.forms[0].combo[0].value!=0 && document.forms[0].combo[1].value!=0 && document.forms[0].combo[2].value==0){
				enableButton("Condemn");
				enableButton("View");
				}else {
				
					disableButton("Condemn");
					enableButton("View");
				}
			} 
			else
				{
					disableButton("Condemn");
					disableButton("View");
				}
	}catch(Err){
		alert(Err);
	}
}

/**
 * This function is used to forward control from desk to view page
 */
function viewCondemn()
{
	
	document.forms[0].comboValue.value=document.forms[0].combo[0][document.forms[0].combo[0].selectedIndex].text+"^"+document.forms[0].combo[1][document.forms[0].combo[1].selectedIndex].text;
	if(document.forms[0].combo[2].value=="0"){
		document.forms[0].hmode.value="VIEWREQ";
		document.forms[0].submit();
		
	}else{
		document.forms[0].hmode.value="VIEW";
		document.forms[0].submit();
	}
	
	
	
	
}
function cancelToDesk()
{
	document.forms[0].hmode.value="CANCEL";
		document.forms[0].submit();
}
//*************************************************************************************************//

//************************Validation for Condemnation Process**************************************//
function openSpecification(obj,index)
{
	   
       
        
        var strItemDetail = document.getElementById("strItemDtl"+index).value;     
      //  alert("strItemDetail--->"+strItemDetail)   
       
        myArray = strItemDetail.split("@");
        document.getElementById("popUpItemId").innerHTML=myArray[0]+"-"+"Item Details";
       // alert("myArray--size"+myArray.length);
       
        var objVal1 = document.getElementById("1");
       
        if(myArray[0]!='null' || myArray[0]!='')
        {
          objVal1.innerHTML = myArray[1];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("2");
        
        if(myArray[1]!='null')
        {
          objVal2.innerHTML = myArray[2]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
         var objVal3 = document.getElementById("3");
        var temp=myArray[3].split("^");
        if(myArray[1]!='null')
        {
          objVal3.innerHTML = temp[0]; 
        }
        else
        {
          objVal3.innerHTML = "  ----";
        }    
          
        var objVal4 = document.getElementById("4");
       
        if(myArray[1]!='null')
        {
          objVal4.innerHTML = temp[1]; 
        }
        else
        {
          objVal4.innerHTML = "  ----";
        }
        
           objVal4 = document.getElementById("5");
       
        if(myArray[1]!='null')
        {
          objVal4.innerHTML = myArray[4]; 
        }
        else
        {
          objVal4.innerHTML = "  ----";
        }  
        
        objVal4 = document.getElementById("6");
       
        if(myArray[1]!='null')
        {
          objVal4.innerHTML = myArray[5]; 
        }
        else
        {
          objVal4.innerHTML = "  ----";
        }    
        	display_popup_menu(obj,'itemDtlId','','');
        	
	
}
function closeItemPopUp(divId)
{
 	hide_popup_menu(divId);
}
function closeSpecification(index)
{
document.getElementById("specificationId"+index).style.display="none";
}

	
function openAutionDetails()
{
	if(document.forms[0].strCondemnationTypeName.value == "Auction"){
			document.getElementById("autionDetailId").style.display= "block";
	
	} else{
			document.getElementById("autionDetailId").style.display= "none";
	}

}
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
function validate1()
{
	var hisValidator = new HISValidator("condemnRegisterTransBean"); 
	
	if(document.forms[0].strCondemnationType.value=="3"){
		hisValidator.addValidation("strTenderNo", "req", "Tender No.  is a Mandatory Field" );
		hisValidator.addValidation("strQuotationNo", "req", "Quotation No.  is a Mandatory Field" );
		hisValidator.addValidation("strBuyerName","dontselect=0","Please Select Buyer Name");
		hisValidator.addValidation("strAmountRecieved", "req", "Amount Recieved is a Mandatory Field");
		hisValidator.addValidation("strInstrumentNo", "req", "Instrument No.  is a Mandatory Field" );
		hisValidator.addValidation("strBankName", "req", "Bank Name is a Mandatory Field" );
		}
	else{
		document.forms[0].strTenderNo.value="0";
		document.forms[0].strQuotationNo.value="0";
		document.forms[0].strAmountRecieved.value="0";
		document.forms[0].strBankName.value="";
	}	
	hisValidator.addValidation("strCommitteType","dontselect=0","Please Select Committe Type");
	var retVal = hisValidator.validate(); 
	hisValidator.clearAllValidations();
	if(retVal)
	{
		 var conf = confirm("You Are Going To Save Records");
					                  if(conf == true)
					                  {
					                       var conf1 = confirm("Are you sure !!!");
					                       if(conf1 == true)
					                       {					                       	 
					                          document.forms[0].hmode.value = "INSERT";
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


function getMemberDtl(mode)
{
	var mode=mode
	var url="CondemnationRegisterTransCNT.cnt?hmode="+mode+"&committeType="+document.forms[0].strCommitteType.value+"&itemCategNo="+document.forms[0].strItemCategoryNo.value;
	ajaxFunction(url,"1");
}

function getAjaxResponse(res,mode){
				
	var err = document.getElementById("errMsg");
	var temp = res.split("####");
	if(temp[0] == "ERROR")
	{
		err.innerHTML = temp[1];
		return;
	}
	
	var objVal;
	if(mode=="1"){				
	
		document.getElementById("memberDtlInner").innerHTML=res;		
	}
	
}
/**
 * This function is used to show Member recommendation HLP
 */
function openDivPopu()
{
	  var hisValidator = new HISValidator("condemnRegisterTransBean");
	  hisValidator.addValidation("strCommitteType","dontselect=0","Please Select Committee Type" );
	   var retVal = hisValidator.validate(); 
       hisValidator.clearAllValidations();
     	 if(retVal)
     	 {
     		 popup('memberDtl' , '','');
     	 }
     	 else
     	 {
     	 	return false;
     	 }
}

/**
 * This function is used to close Popup
 */
function closePopUpDiv()
{
	hide_popup('memberDtl');
}

function cancelPage()
{
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
}
/**
 * This function is used to clear data in Member Recommendation
 */
function clearData()
{
	var size=document.getElementsByName("strMemberRecommendation").length;
	if(size>1){
		for(var i=0;i<size;i++){
			document.getElementsByName("strMemberRecommendation")[i].value="";
		}
	}
	else{
		document.getElementsByName("strMemberRecommendation")[0].value="";
	}
}
//*************************************************************************************************//