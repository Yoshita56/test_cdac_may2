
 
 
//This function is used for validation of blank field.
 function validate1() {
   	var hisValidator = new HISValidator("dispatchDetailsBean"); 
  	var chkSelected="";
  	var chk=document.getElementsByName("strCheckBoxValue");
  	var i=0;
  	var chkflag=0;
  	if(document.forms[0].displayFlag.value=="0" || document.forms[0].displayFlag.value=="3" ||document.forms[0].displayFlag.value=="4"){
  		hisValidator.addValidation("strStoreId","dontselect=0","Please select a Drug Warehouse Name");
        hisValidator.addValidation("strItemCatId","dontselect=0","Please select a Item Category");
       	hisValidator.addValidation("strPONO","dontselect=0","Please select a PO No");
	 	
  	  	
     }else{
     
     	if(document.forms[0].strDefCurrId.value != document.forms[0].strCurrencyId.value){
     	
     		hisValidator.addValidation("strCurrValue", "req", "Currency Value is a mandatory field." );
     	
     	}
     
      	hisValidator.addValidation("strInstrType","dontselect=0","Please select a Instrument Type.");
      	hisValidator.addValidation("strInstrReceivedDate", "date","Instrument Received Date is a mandatory field");
      	hisValidator.addValidation("strInstrNo", "req", "Instrument No is a mandatory field." );
      	hisValidator.addValidation("strInstrDate", "date","Instrument Date is a mandatory field");
      	hisValidator.addValidation("strDraweeBank", "req", "Drawee Bank is a mandatory field." );
      	hisValidator.addValidation("strInstrValidity", "req", "Instrument validity  is a mandatory field." );
      	hisValidator.addValidation("strInstrAmt", "req", "Instrument Amount is a mandatory field." );
      	hisValidator.addValidation("strDispatchMode","dontselect=0","Please select a Dispatch Mode.");
        hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should not be greater than 100 characters" );
     }	 		

   var retVal = hisValidator.validate();
  	hisValidator.clearAllValidations();
  	
  	if(retVal){
  	
  	
	  	for(i=0;i<chk.length;i++)
	  	{
		  	if(chk[i].checked==true){
			  	chkSelected=chkSelected+chk[i].value+',';
			  	chkflag=1;
	  		}
	  	
	  	}
	  	if(chkflag == 0)
	  	{
		  	if( document.forms[0].displayFlag.value=="0" || document.forms[0].displayFlag.value=="3" ||document.forms[0].displayFlag.value=="4"){
			  	 	alert("Please Click on The Go button");
			  	 	return false;
			 }else {
			 alert("Please Select atleast one Request No");
			 
			  	 	return false;
			 }
			 
		 }else{
  	
		  	document.forms[0].chkSelected.value=chkSelected;
		  
		  	var flag=checkQtyValue(document.forms[0].strInstrAmt);
		  
		  	if(flag)
		  	{
		  		    var conf = confirm("You Are Going To Save Records");
					                  if(conf == true)
					                  {
					                       var conf1 = confirm("Are you sure !!!");
					                       if(conf1 == true)
					                       {					                       	 
					                          document.forms[0].hmode.value = "SAVEADVANCE";
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
  	}else{
  	return false;
  	}
 }
 
 
  	
  	function validate2() {
  	
   	var hisValidator = new HISValidator("dispatchDetailsBean"); 
  	var chkSelected="";
  	var chk=document.getElementsByName("strCheckBoxValue");
  	var i=0;
  	var chkflag=0;
  	if(document.forms[0].displayFlag.value=="0" || document.forms[0].displayFlag.value=="3" ||document.forms[0].displayFlag.value=="4"){
  		hisValidator.addValidation("strStoreId","dontselect=0","Please select a Drug Warehouse Name");
        hisValidator.addValidation("strItemCatId","dontselect=0","Please select a Item Category");
       	hisValidator.addValidation("strPONO","dontselect=0","Please select a PO No");
	 	
  	  	
     }else{
     
		     if(document.forms[0].strDefCurrId.value != document.forms[0].strCurrencyId.value){
		     	
		     		hisValidator.addValidation("strCurrValue", "req", "Currency Value is a mandatory field." );
		     	
		     	}
     
     
      	hisValidator.addValidation("strInstrType","dontselect=0","Please select a Instrument Type");
      	hisValidator.addValidation("strInstrReceivedDate", "date","Instrument Received Date is a mandatory field");
      	hisValidator.addValidation("strInstrNo", "req", "Instrument No is a mandatory field" );
      	hisValidator.addValidation("strInstrDate", "date","Instrument Date is a mandatory field");
      	hisValidator.addValidation("strDraweeBank", "req", "Drawee Bank is a mandatory field" );
      	hisValidator.addValidation("strInstrValidity", "req", "Instrument validity is a mandatory field" );
      	hisValidator.addValidation("strInstrAmt", "req", "Instrument Amount is a mandatory field" );
      	hisValidator.addValidation("strDispatchMode","dontselect=0","Please select a Dispatch Mode");
        hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
     }	 		
	 var retVal = hisValidator.validate();
  	hisValidator.clearAllValidations();
  	
  	if(retVal){
  	
	  	for(i=0;i<chk.length;i++)
	  	{
		  	if(chk[i].checked==true){
			  	chkSelected=chkSelected+chk[i].value+',';
			  	chkflag=1;
		  	}
	  	}
	  	if(chkflag == 0)
	  	{
		  	if( document.forms[0].displayFlag.value=="0" || document.forms[0].displayFlag.value=="3" ||document.forms[0].displayFlag.value=="4"){
			  	 	alert("Please Click on The Go button");
			  	 	return false;
			 }else {
			 alert("Please Select atleast one Bill No");
			 
			  	 	return false;
			 }
		 }else{
  	
	  	document.forms[0].chkSelected.value=chkSelected;
	  	
	  	var flag=checkQtyValue(document.forms[0].strInstrAmt);
		  	if(flag){
					document.forms[0].hmode.value="SAVEBILL";
					document.forms[0].submit();
				} else{
						return false;
				}
 		}
  	}else{
  	return false;
  	}
  	}
  

//This function is used to hide the bill no when advance radio button is selected .
function disPlay()
{  
/* if(document.forms[0].displayFlag.value=="1" ||document.forms[0].displayFlag.value=="2"){
 	input_box=confirm("Data has not been Saved.Are You sure, You want to change the mode?");
	if (input_box==true)
	{
	if(document.getElementsByName('strAdvanceBillRadio')[0].checked)
   {
  
 	 document.forms[0].hmode.value="ADVANCEMODE";
 	  document.forms[0].displayFlag.value="0";
		document.forms[0].submit(); 
    
    }else if(document.getElementsByName('strAdvanceBillRadio')[1].checked){
    
   
    document.forms[0].hmode.value="BILLMODE";
     document.forms[0].displayFlag.value="0";
		document.forms[0].submit(); 
   		
    }
	}else{
	return false;
	}
 }else{*/

  if(document.getElementsByName('strAdvanceBillRadio')[0].checked)
   {
  
 	 document.forms[0].hmode.value="ADVANCEMODE";
 	  document.forms[0].displayFlag.value="0";
		document.forms[0].submit(); 
    
    }else if(document.getElementsByName('strAdvanceBillRadio')[1].checked){
    
   
    document.forms[0].hmode.value="BILLMODE";
    document.forms[0].displayFlag.value="0";
	document.forms[0].submit(); 
   		
    }
   
   }
   
//  }
 

 
function diplayView(){
	 if(document.getElementsByName('strDispatchViewRadio')[0].checked){
    
   
     	document.forms[0].hmode.value="VIEWMODE";
 	  	document.forms[0].displayFlag.value="0";
		document.forms[0].submit(); 
    
    	}else {
    	
    	document.forms[0].hmode.value="ADVANCEMODE";
 	    document.forms[0].displayFlag.value="0";
		document.forms[0].submit(); 
    	
    	}
    	
	}  
  
  
  function getPONODetails()
{
	
	var url;
	var mode = "PONODETAILS";
	url="DispatchDetailsTransCNT.cnt?hmode="+mode+"&poNO="+document.forms[0].strPONO.value; 
 	ajaxFunction(url,"1");

}

  function getItemCategory()
{ 

  if(document.forms[0].strStoreId.value!="0"){
   		var mode="ITEMCATEGORYCOMBO";
   		var url="DispatchDetailsTransCNT.cnt?hmode="+mode+"&storeId="+document.forms[0].strStoreId.value;
   		ajaxFunction(url,"2");
   	}
   	else{
   		document.getElementById("ItemCategoryId").innerHTML="<select name ='strItemCatId' class='comboNormal' ><option value='0'>Select Value</option></select>";
   		 document.getElementById("PONOId").innerHTML="<select name ='strPONO' class='comboNormal' ><option value='0'>Select Value</option></select>";
   	}
}
 function getPONO()
{ 
if(document.forms[0].strItemCatId.value!="0")
{
   var mode="PONOCOMBO";
   var url="DispatchDetailsTransCNT.cnt?hmode="+mode+"&itemCatId="+document.forms[0].strItemCatId.value+"&modeValue="+document.forms[0].modevalue.value+"&storeId="+document.forms[0].strStoreId.value;
 
   ajaxFunction(url,"3");
   
   }
   else
   {
   document.getElementById("PONOId").innerHTML="<select name ='strPONO' class='comboNormal' ><option value='0'>Select Value</option></select>";
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
			objVal= document.getElementById("PONODetailsDivId");
			objVal.innerHTML = res ; 
			}
		
	}
	if(mode=="2")
    {
	   	
	   
		     var objVal = document.getElementById("ItemCategoryId");
		     objVal.innerHTML = "<select name = 'strItemCatId' id='strItemId' class='comboNormal' onChange='getPONO();'>" + res + "</select>";
		     
	} 
	
	
	
    if(mode=="3")
    {
    	    //alert(res);
    		var temp=res.split("@");
		    var objVal = document.getElementById("PONOId");
		    objVal.innerHTML = temp[1]+"<select name ='strPONO' id='strPONOId' class='comboNormal' onChange='getPONODetails();'>"+temp[0]+"</select>";
		    
     		
     		}
     	
	}
  //This method is used to disappear the Dispatch Details jsp page
  function cancel()
 {
      document.getElementById("errMsg").innerHTML = "";
   document.forms[0].hmode.value = "CANCEL";
     document.forms[0].submit();
 }
 
 
 //This function is used to clear all fields of jsp page.
 function clearAdvance()
{
	
	var url;
	var mode = "ADVANCEMODE";
	document.forms[0].hmode.value=mode;
	document.forms[0].displayFlag.value="0";
	document.forms[0].submit();
 	

}

function clearBill()
{
	
	var url;
	var mode = "BILLMODE";
	document.forms[0].hmode.value=mode;
	document.forms[0].displayFlag.value="0";
	document.forms[0].submit();
 	

}



function goFuncView()               
{
        var hisValidator = new HISValidator("dispatchDetailsBean");  
        hisValidator.addValidation("strStoreId","dontselect=0","Please select a Drug Warehouse Name");
	 	
		var retVal = hisValidator.validate(); 
		
	    if(retVal)
	    {
	
	    		document.forms[0].strStoreName.value=document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
			    document.forms[0].hideStoreId.value=document.forms[0].strStoreId.value;
			    document.forms[0].displayFlag.value="5";
		         	
	        	document.forms[0].hmode.value="VIEWMODE";
				document.forms[0].submit();
	           	
		}else{
		
		return false;
		}
	
	
}


function goFuncADV()               
{
        var hisValidator = new HISValidator("dispatchDetailsBean");  
        hisValidator.addValidation("strStoreId","dontselect=0","Please select a Drug Warehouse Name");
        hisValidator.addValidation("strItemCatId","dontselect=0","Please select a Item Category");
       	hisValidator.addValidation("strPONO","dontselect=0","Please select a PO No");
	 	
		var retVal = hisValidator.validate(); 
		
	    if(retVal)
	    {
	
	    		document.forms[0].strStoreName.value=document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
			    document.forms[0].strItemCategory.value=document.forms[0].strItemCatId[document.forms[0].strItemCatId.selectedIndex].text;
			    document.forms[0].PONOName.value=document.forms[0].strPONO[document.forms[0].strPONO.selectedIndex].text;
			    document.forms[0].hideStoreId.value=document.forms[0].strStoreId.value;
			    document.forms[0].hideItemCatId.value=document.forms[0].strItemCatId.value;
			    document.forms[0].hidePONO.value=document.forms[0].strPONO.value;
			    
		         	
	        	document.forms[0].hmode.value="ADVANCEMODE";
	        	document.forms[0].displayFlag.value="1";
				document.forms[0].submit();
	           	
		}else{
		
		return false;
		}
	
	
}

function goFuncBill()               
{

   
        var hisValidator = new HISValidator("dispatchDetailsBean");  
        hisValidator.addValidation("strStoreId","dontselect=0","Please select a Drug Warehouse Name");
        hisValidator.addValidation("strItemCatId","dontselect=0","Please select a Item Category");
        hisValidator.addValidation("strPONO","dontselect=0","Please select a PO No");
	 	
		var retVal = hisValidator.validate(); 
		
	    if(retVal)
	    {
	    
	    		document.forms[0].strStoreName.value=document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
			    document.forms[0].strItemCategory.value=document.forms[0].strItemCatId[document.forms[0].strItemCatId.selectedIndex].text;
			    document.forms[0].PONOName.value=document.forms[0].strPONO[document.forms[0].strPONO.selectedIndex].text;
			    document.forms[0].hideStoreId.value=document.forms[0].strStoreId.value;
			    document.forms[0].hideItemCatId.value=document.forms[0].strItemCatId.value;
			    document.forms[0].hidePONO.value=document.forms[0].strPONO.value;
	     		
	       	  	
	           	document.forms[0].hmode.value="BILLMODE";
	           	document.forms[0].displayFlag.value="2";
				document.forms[0].submit();
	            
		}else{
		
		return false;
		
	}
}

function goFuncOnView(e)
{
   if(e.keyCode == 13)
   {
	 goFuncView();
	}
	else
	{
	 return false;
	}
} 

function goFuncOnEnterBill(e)
{
   if(e.keyCode == 13)
   {
	 goFuncBill();
	}
	else
	{
	 return false;
	}
} 

function goFuncOnEnterAdv(e)
{
   if(e.keyCode == 13)
   {
	 goFuncADV();
	}
	else
	{
	 return false;
	}
}  

function AdvanceHideandDisplayBlock()
{
   if(document.forms[0].displayFlag.value=="1")
   {
   	if(document.forms[0].strDefCurrId.value != document.forms[0].strCurrencyId.value){
	    		
	 	document.getElementById('currVarAdvDivId').style.display = "block";
	    		
	  }else{
	    		
	  	document.getElementById('currVarAdvDivId').style.display = "none";
	    		
	  }   
	  	  	
  			document.getElementsByName('strAdvanceBillRadio')[0].checked=true;
   			document.getElementById("StoreNameId").style.display= "none";
	       	document.getElementById("StoreNamedivId").style.display= "block";
	       	document.getElementById("ItemCategoryId").style.display= "none";
	       	document.getElementById("ItemCategorydivId").style.display= "block";
	        document.getElementById("PONOId").style.display= "none";
	       	document.getElementById("PONOdivId").style.display= "block";
	       	document.getElementById("PONODetailsDivId").style.display= "block";
	        document.getElementById("PONODetailsDivId").style.display= "block";
	        document.getElementById("RequestDetailsDivId").style.display= "block";
	        document.getElementById("InstrumentDetailsDivId").style.display= "block";
	        document.getElementById("imageDivId").style.display= "none";
	        document.forms[0].strInstrType.value="0";
	        
   }else if(document.forms[0].displayFlag.value=="3")
   {
   		   document.getElementsByName('strAdvanceBillRadio')[0].checked=true;
    	   document.getElementById("StoreNameId").style.display= "block";
	       document.getElementById("StoreNamedivId").style.display= "none";
	       document.getElementById("ItemCategoryId").style.display= "block";
	       document.getElementById("ItemCategorydivId").style.display= "none";
	       document.getElementById("PONOId").style.display= "block";
	       document.getElementById("PONOdivId").style.display= "none";
	       document.getElementById("PONODetailsDivId").style.display= "none";
	       document.getElementById("RequestDetailsDivId").style.display= "none";
	       document.getElementById("InstrumentDetailsDivId").style.display= "none";
	       document.forms[0].strInstrType.value="0";
	       document.getElementById("imageDivId").style.display= "block";
	           	
   }else{
    document.getElementsByName('strAdvanceBillRadio')[0].checked=true;
    document.forms[0].strInstrType.value="0";
   }
} 

function getExcVar(){

	var currValPo = document.forms[0].strCurrValuePO.value;
	    	
	    	var currVal = document.forms[0].strCurrValue.value;
	    	
	    var strExchangeVar =  manipulateValue(currValPo,currVal, 1); 	
	    if(isNaN(strExchangeVar)){
	    	document.getElementById('excVarDivId').innerHTML = "" ; 
	    }else{
	   		document.getElementById('excVarDivId').innerHTML = strExchangeVar ; 
	    }
}

function BillHideandDisplayBlock()
{


   if(document.forms[0].displayFlag.value == "2")
   {
   
  		 if(document.forms[0].strDefCurrId.value != document.forms[0].strCurrencyId.value){
	    		
	    			document.getElementById('currVarBillDivId').style.display = "block";
	    		
	    		}else{
	    		
	    			document.getElementById('currVarBillDivId').style.display = "none";
	    		
	    		}   
	    		
	    	
	    		
    	   document.getElementsByName('strAdvanceBillRadio')[1].checked=true;
  		   document.getElementById("StoreNameId").style.display= "none";
	       document.getElementById("StoreNamedivId").style.display= "block";
	       document.getElementById("ItemCategoryId").style.display= "none";
	       document.getElementById("ItemCategorydivId").style.display= "block";
	       document.getElementById("PONOId").style.display= "none";
	       document.getElementById("PONOdivId").style.display= "block";
	       document.getElementById("PONODetailsDivId").style.display= "block";
	       document.getElementById("BillDetailsDivId").style.display= "block";
	       document.getElementById("InstrumentDetailsDivId").style.display= "block";
	       document.getElementById("imageDivId").style.display= "none";
	       
	       document.forms[0].strInstrType.value="0";
	           	
   }else if(document.forms[0].displayFlag.value=="4")
   {		
   		   document.getElementsByName('strAdvanceBillRadio')[1].checked=true;
    	   document.getElementById("StoreNameId").style.display= "block";
	       document.getElementById("StoreNamedivId").style.display= "none";
	       document.getElementById("ItemCategoryId").style.display= "block";
	       document.getElementById("ItemCategorydivId").style.display= "none";
	       document.getElementById("PONOId").style.display= "block";
	       document.getElementById("PONOdivId").style.display= "none";
	       document.getElementById("PONODetailsDivId").style.display= "none";
	       document.getElementById("BillDetailsDivId").style.display= "none";
	       document.getElementById("InstrumentDetailsDivId").style.display= "none";
	       document.forms[0].strInstrType.value="0";
	       document.getElementById("imageDivId").style.display= "block";
	           	
   }else{
        document.getElementsByName('strAdvanceBillRadio')[1].checked=true;
        document.forms[0].strInstrType.value="0";
   }
} 


function ViewHideandBlock(){

	if(document.forms[0].displayFlag.value=="5")
   		{
   		   
		   document.getElementById("StoreNameId").style.display= "none";
	       document.getElementById("StoreNamedivId").style.display= "block";
	       document.getElementById("DispatchDetailsDivId").style.display= "block";
	       document.getElementById("imageDivId").style.display= "none";
	       document.getElementById("DivId1").style.display= "block";
	       document.getElementsByName('strDispatchViewRadio')[0].disabled=true;

		}else {
		
		   document.getElementById("StoreNameId").style.display= "block";
	       document.getElementById("StoreNamedivId").style.display= "none";
	       document.getElementById("DispatchDetailsDivId").style.display= "none";
	       document.getElementById("imageDivId").style.display= "block";
	     		
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


function checkQtyValue(obj){

var tempVal = "";

if(obj.value.length <= 0){

tempVal = parseFloat("0");

}else{
tempVal = parseFloat(obj.value);
}



var advReqAmt = parseFloat("0.00");
var checkValue = document.getElementsByName("strCheckBoxValue");

for(var i = 0; i< checkValue.length; i++){

	if(checkValue[i].checked){
		//alert(document.getElementsByName("strAdvReqAmt")[i].value);
		advReqAmt = parseFloat(advReqAmt) + parseFloat(document.getElementsByName("strAdvReqAmt")[i].value);
	
	}
	
	}
 

if(tempVal > advReqAmt){
	
		alert("Instrument amount should not be greater than the amount \n for those requests which are checked");
		document.getElementsByName("strInstrAmt")[0].value = "";
		document.getElementsByName("strInstrAmt")[0].focus();
		return false;
	
	}
	return true;

}