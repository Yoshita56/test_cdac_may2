
function cancelPage(){
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
}

function chkUserDefinedFunc(these){
	
	var checkCount=0;
	var check=document.getElementsByName("chk");
	for(i=0;i<check.length;i++){
		if(check[i].checked==true)
			checkCount++;
	}
	if((checkCount==1) && (document.forms[0].combo[2].value == "1"))
	{
		enableButton("View");
		enableButton("Cancel");
		disableButton("Request");	
		disableButton("Issue");	
	}
    else if((checkCount==1) && (document.forms[0].combo[2].value == "2"))
	{
		disableButton("Issue");
		disableButton("Request");	
		disableButton("Cancel");	
		enableButton("View");	
	}
	else if((checkCount==1) && (document.forms[0].combo[2].value == "3"))
	{
		enableButton("View");
		disableButton("Request");	
		enableButton("Issue");	
		disableButton("Cancel");	
	}
	else if((checkCount==1) && (document.forms[0].combo[2].value == "4"))
	{
		enableButton("View");
		disableButton("Request");	
		disableButton("Issue");	
		disableButton("Cancel");	
	}
	else if((checkCount==1) && (document.forms[0].combo[2].value == "5"))
	{
		enableButton("View");
		disableButton("Request");	
		disableButton("Issue");	
		disableButton("Cancel");	
	}
	else
	{
		enableButton("Request");
		disableButton("View");	
		disableButton("Issue");	
		disableButton("Cancel");	
	}
}

function comboEvent()
{
    enableButton("Request");
    disableButton("Issue");
    disableButton("View");
}
function callPage1(form1,mode){
	
	cmbVal="";
	var retVal=false;
	if(document.forms[0].combo[0].value != "0")
	{
		if(document.forms[0].combo[1].value == "0")
		{
			alert("Please Select Item Category Value from Combo");
			retVal=false;
		}
		else
		{
			retVal=true;
		}
	}
	else
	{
		alert("Please Select Drug Warehouse Name from Drug Warehouse Combo");
		retVal=false;
	}
	if(retVal==true)
	{
	   with(form1)
	   {
	        if( mode == "REQUEST")
	        {
			  cmbVal =combo[0].options[combo[0].selectedIndex].text;
			   comboValue.value = cmbVal;
	            document.forms[0].hmode.value="REQUEST";
	             document.forms[0].submit();
			}
			if( mode == "CANCEL_REQUEST")
	        {
			  cmbVal =combo[0].options[combo[0].selectedIndex].text;
			   comboValue.value = cmbVal;
			    res=prompt("ENTER REMARKS FOR REQUEST CANCELLATION","");
                 if(res!="")
                 {
                    with(form1)
                    {
                       var check=document.getElementsByName("chk");
                       var indexStr;
                       var checkCount=0;
	                   for(i = 0;i < check.length;i++)
	                   {
	                      if(check[i].checked==true)
	                      {
		                     checkCount++;
		                     indexStr=i;
	                      }	
	                   }
                       check[indexStr].value=check[indexStr].value.concat("#"+res);
                    }
                    //alert("Reject Value->"+check[indexStr].value);
                    sts = confirm("Are you sure");
                    if(sts==true)
                    {
                       document.forms[0].hmode.value="CANCEL_REQUEST";
	                   document.forms[0].submit();
                    }
                 }
                 else
                 {
                   alert("No Remark entered, enter Remark & then continue");
                 }
			}
			if( mode == "ISSUE")
	        {
			  cmbVal =combo[0].options[combo[0].selectedIndex].text;
			   comboValue.value = cmbVal;
	            document.forms[0].hmode.value="ISSUE";
	             document.forms[0].submit();
			}
			if( mode == "VIEW")
	        {
			  cmbVal =combo[0].options[combo[0].selectedIndex].text;
			   comboValue.value = cmbVal;
	            document.forms[0].hmode.value="VIEW";
	             document.forms[0].submit();
			}
	   }
	}
}


function getGroupCombo(obj){ 

 		var url ="ThirdPartyIssueReqTransCNT.cnt?hmode=GROUPCMB&itemCatNo="+obj.value;
 		ajaxFunction(url,"1");
		
	}
	
function getAjaxResponse(res,mode){

	if(mode=="1"){   
			var objVal= document.getElementById("groupDivId");
			objVal.innerHTML = "<select name ='strGroupIdForItemSearch' class='comboNormal'>" + res + "</select>";
		}
	}	

function getItemSelectPopup(){
	
	    alert("itCat->"+document.forms[0].strItemCatNo.value);
	    alert("strFromStoreId->"+document.forms[0].strStoreId.value);
	    alert("strStoreTypeId->"+document.forms[0].strStoreTypeId.value);
		var strModeVal 					= "2"; 
		var strItemCategory 			= document.forms[0].strItemCatNo.value; 
		var strIssueType 				= "";
		var strFromStoreId 				= document.forms[0].strStoreId.value;
		var strToStoreId  				= "";
		var strStoreTypeId  			= document.forms[0].strStoreTypeId.value;
		var strMultiRowCompArray 		= new Array('itemParamValue','strUnitName','strQty');
		var strMultiRowCompTypeArray 	= new Array('t','s','t');
		// for mode val 1
		// var strMultiRowFetchDataArray= new Array('6','12','3^strUnitName');
		// for mode val 2
		var strMultiRowFetchDataArray 	= new Array('17','18','3','5','7','11^strUnitName');
		// for mode val 3
		// var strMultiRowFetchDataArray= new Array('37','45','4^strUnitName');
		var layerIndex = "1";
	
	    searchItems( strModeVal , strItemCategory , strIssueType ,strFromStoreId, strToStoreId , strStoreTypeId , strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex);
	
	}
	
	function cancel1(){
	
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
	}

function compareQty(){
	
	var quantity = parseInt(document.getElementById("strQty").value);
	var availableQty = parseInt(document.getElementById("stockParamAvailableQtyDivId").value);
	
	if(availableQty > quantity){
	
			alert("Quantity cannot be greater than Available Quantity");
			
			}
		}

function clearDtl(mode){

	document.forms[0].mode.value=mode;
	document.forms[0].hmode.value="CLEAR";
	document.forms[0].submit();

}

function openIssueReport()
{
	// alert("mode->"+document.forms[0].mode.value);
	 if(document.forms[0].strReqNo.value!="0")
	 {
	    getIssueDtls('3', document.forms[0].strStoreId.value, document.forms[0].strReqNo.value) ;
	 }
}


function checkValCombo()
{
	var recievedByName=document.forms[0].strInstituteCode[document.forms[0].strInstituteCode.selectedIndex].text;
	if(document.forms[0].strInstituteCode[document.forms[0].strInstituteCode.selectedIndex].text=='Other' )
	{
		
		document.getElementById("labelId").className="LABEL";
		document.getElementById("labelNameId").innerHTML="";
		document.getElementById("nameOtherFld").style.display="block";
		if(document.forms[0].strReceivedBy.readOnly)
			document.forms[0].strReceivedBy.readOnly=false;
		document.forms[0].strReceivedBy.value="";
		document.getElementById("labelNameId").innerHTML="<font color='red'>*</font>Other Third Party Name";
		document.forms[0].strReceivedBy.focus();
	
	}else if(document.forms[0].strInstituteCode.value!="0" && document.forms[0].strInstituteCode.value!="1"){
		
		document.getElementById("labelId").className="LABEL";
		
		document.getElementById("labelNameId").innerHTML="";
		document.getElementById("nameOtherFld").style.display="block";
		document.getElementById("labelNameId").innerHTML="Other Third Party Name";
		document.forms[0].strReceivedBy.value=recievedByName;
		if(!document.forms[0].strReceivedBy.readOnly)
			document.forms[0].strReceivedBy.readOnly=true;
		document.getElementsByName("strRemarks")[0].focus();
		
		
	}else{
		document.getElementById("labelId").className="CONTROL";
		document.getElementById("nameOtherFld").style.display="none";
		document.getElementById("labelNameId").innerHTML="";
	}
}

function validate1(){

	var hisValidator = new HISValidator("thirdPartyIssueReqBean");
	hisValidator.addValidation("strInstituteCode", "dontselect=0","Please Select Third Party Name");
	if(document.forms[0].strThirdPartyFlag.value=="2")
	{
	     hisValidator.addValidation("strThirdPartyIssueDate", "req", "Issue Date is a Mandatory Field");
	}
	//hisValidator.addValidation("strGroupIdForItemSearch", "dontselect=0","Please Select Group Name");
    hisValidator.addValidation("strQty", "req","Please Enter Required Qty");
    if(document.forms[0].strThirdPartyFlag.value=="2")
	{
    hisValidator.addValidation("strReceiveBy", "req","Please Enter Receive By");
    }
    hisValidator.addValidation("strRemarks", "req","Please Enter Remarks");
    hisValidator.addValidation("strRemarks", "maxlen=100",     "Remarks should have less than or equal to 100 Characters" );
    hisValidator.addValidation("strUnitName", "dontselect=0","Please Select Unit Name");
    var retVal = hisValidator.validate();
    var itemUsrVal  =document.getElementsByName("itemUserValue");
	var unitNameCmb =document.getElementsByName("strUnitName");
	var issueQty  =document.getElementsByName("strQty");
	var myArray  =new Array();
	var myArray1 =new Array();
	var issueQtyVal="0";
	var trnsQtyVal="0";
	/*
	  for(var x=0;x<itemUsrVal.length-1;x++)
	  {
	    if(retVal)
	    {
	      myArray=itemUsrVal[x].value.split("^");
	      myArray1=unitNameCmb[x].value.split("^");
	      issueQtyVal=parseInt(issueQty[x].value)* parseInt(myArray1[1]); 
	      if(issueQtyVal>myArray[7])
	      {
	     	alert("Request Qty cannot be greater than Available Qty!!");
	     	retVal=false;
	      }  
	    } 
	  } */  
     
    hisValidator.clearAllValidations();	
    
	if(retVal)
	{
	
	  validateOnSubmit('2','','');
	  if(document.forms[0].strThirdPartyFlag.value=="2")
	  {
		  
		          var conf = confirm("You Are Going To Save Records");
		          if(conf == true)
		          {
		               var conf1 = confirm("Are you sure !!!");
		               if(conf1 == true)
		               {	              
								   
					                document.forms[0].hmode.value="INSERTWITHNEWMODE";
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
	     
	      
	              var conf = confirm("You Are Going To Save Records");
		          if(conf == true)
		          {
		               var conf1 = confirm("Are you sure !!!");
		               if(conf1 == true)
		               {	              
								   
					                document.forms[0].hmode.value="INSERT";
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
function getItemSelectPopup()
{
	    setItemDtlWithIssueQty();
	    var strFromStoreId              = document.forms[0].strStoreId.value; 
		var strModeVal 					= "3" ; 
		var strItemCategory 			= document.forms[0].strItemCatNo.value ; 
		var strIssueType 				= "0";
		var strRequestType              = "65";
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strUnitName','strQty');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t','s','s');
		var strMultiRowFetchDataArray 	= new Array('1','11','12','4','0^strUnitName^unitCmbChng');
		var layerIndex                  = "1";
	    var testFunction                = "";
		var arg                         = " ";  		
		var userInfo = "0";
		var unitMode = "1";  // only base unit  1 Means Only Base Unit Show 0 Means All Unit Show in Unit Combo
	    //searchItems(strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex);
	    searchItemsWithUserFunction( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg , userInfo , unitMode );

}


function setItemDtlWithIssueQty()
{
	
		var itemWithIssueQty = document.getElementById("strItemDtlWithIssueQty");
		var  itemUserVal    = document.getElementsByName("itemUserValue");
	    var issueQty    = document.getElementsByName("strQty");  		
  		var unitNameCmb = document.getElementsByName("strUnitName");		  
				
			if(itemUserVal.length > 1)
			{
				
				var tempIssueDtls ; 
				
				for(var i = 0 ; i < itemUserVal.length - 1 ; i++)
				{
															
					if(i == 0 )
					{						
						tempIssueDtls = itemUserVal[i].value+"@@@@"+unitNameCmb[i].value+"@@@@"+issueQty[i].value	
					}
					else
					{					
						tempIssueDtls = tempIssueDtls+"$$$$"+itemUserVal[i].value+"@@@@"+unitNameCmb[i].value+"@@@@"+issueQty[i].value
					}
				
				}
				
				itemWithIssueQty.value = tempIssueDtls;
				
				
			}else{
				itemWithIssueQty.value = "";
					
			}
				
		
	
	}

function validateQtyFor_decNcost(obj,mode,index,strTransferQty,strUnitName,costName,totalCostName)
 {
 	var retValCheckQty=true;//=checkQty(index,strTransferQty,strUnitName);
 	if(obj.value=="0")
 	{
 		retValCheckQty=false;
 		alert("Req. Qty cannot be Zero");
 		obj.value="";
 	}
 	var retValCalculateCost;
 	if(retValCheckQty)
 	{
 		retValCalculateCost=calculateCost(mode, strTransferQty, strUnitName, costName, index, totalCostName ,1);
 		if(!retValCalculateCost)
 		{
 			return false;
 		}
 	}
 	else
 	 return false;
 }
  
function unitCmbChng(mode,index,unitObject)
{
	retValCalculateCost=calculateCost(mode, "strQty", unitObject.name,"",index,"",1);
 	if(document.getElementsByName("strQty")[parseInt(index.split("-")[1])-1].value=="0")
 	{
 		retValCalculateCost=false;
 		document.getElementsByName("strQty")[parseInt(index.split("-")[1])-1].value="";
 	}
 	/*retValCalculateCost=true;
 	if(retValCalculateCost)
 	{
 		document.getElementById("totTrnsCostDIV").style.display="block";
 	}*/
 	return retValCalculateCost;
}    