function openIssueReport()
{	
	 
	 if(document.forms[0].strIssueNo.value!="0")
	 {
	    
	   
	        var itemStockObj = document.getElementById("issueDtlsDivId");

	    	if (itemStockObj.innerHTML == "") 
	    	{

	    		var hmode = "ISSUEDTLSINIT";
	    		var url = "ThirdPartyIssueDeskBSCNT.cnt?hmode=ISSUEDTLSINIT&strMode=3&strStoreId=" + document.forms[0].strStoreId.value + "&strIssueNo=" + document.forms[0].strIssueNo.value+"&strIndentNo=0&strIndentDate=SYSDATE";
	    		
	    		ajaxFunction(url,"2");

	    	} 
	    	else 
	    	{
	    		// set for 1024 * 760 screen don't change this
	    		popup('popUpDiv', '80', '60');
	    	}

	    }
	 
}


function getGroupCombo(obj){ 

 		var url ="ThirdPartyIssueTransCNT.cnt?hmode=GROUPCMB&itemCatNo="+obj.value;
 		ajaxFunction(url,"1");
		
	}
	
function getAjaxResponse(res,mode)
{

	if(mode=="1"){   
			var objVal= document.getElementById("groupDivId");
			objVal.innerHTML = "<select name ='strGroupIdForItemSearch' class='comboNormal'>" + res + "</select>";
		}
	
	//STOCKDTLSINIT
	if (mode == '2') {

		var itemStockObj = document.getElementById("issueDtlsDivId");

		//itemStockObj.innerHTML = res+"<p class='example'>.</p>"+res;;
		itemStockObj.innerHTML = res;

		popup('popUpDiv', '80', '60');

	}
	
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
		enableButton("Cancel");	
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
		enableButton("View");	
		disableButton("Issue");	
		disableButton("Cancel");	
	}
}

function comboEvent()
{
    enableButton("Request");
    enableButton("Issue");
    enableButton("View");
    disableButton("Cancel");
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
			  cmbVal =combo[0].options[combo[0].selectedIndex].text+"^"+combo[1].options[combo[1].selectedIndex].text;
			   comboValue.value = cmbVal;
	            document.forms[0].hmode.value="REQUEST";
	             document.forms[0].submit();
			}
			if( mode == "CANCEL_REQUEST")
	        {
			  cmbVal =combo[0].options[combo[0].selectedIndex].text+"^"+combo[1].options[combo[1].selectedIndex].text;
			   comboValue.value = cmbVal;
			    res=prompt("ENTER REMARKS FOR REQUEST CANCELLATION","");
			      var blnkStr="";
			      for(var i=0;i<res.length;i++)
			      {
			     	blnkStr=blnkStr+" ";
			      }
                 if(res!="" && blnkStr!=res)
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
			  cmbVal =combo[0].options[combo[0].selectedIndex].text+"^"+combo[1].options[combo[1].selectedIndex].text;
			   comboValue.value = cmbVal;
	            document.forms[0].hmode.value="ISSUE";
	             document.forms[0].submit();
			}
			if( mode == "VIEW")
	        {
			  cmbVal =combo[0].options[combo[0].selectedIndex].text+"^"+combo[1].options[combo[1].selectedIndex].text;
			   comboValue.value = cmbVal;
	            document.forms[0].hmode.value="VIEW";
	             document.forms[0].submit();
			}
	   }
	}
}

	

	/*function getItemSelectPopup(){
	
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
	
	}*/
	function getItemSelectPopup()
	{
	    var strFromStoreId              = document.forms[0].strStoreId.value; 
		var strModeVal 					= "3" ; 
		var strItemCategory 			= document.forms[0].strItemCatNo.value ; 
		var strIssueType 				= "0";
		var strRequestType              = "65";
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strUnitName','strQty');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','s','s','t');
		var strMultiRowFetchDataArray 	= new Array('1','11','4','0^strUnitName');
		var layerIndex                  = "1";
	   searchItems( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex);
	}
	

function cancelPage()
{
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
}

function cancel1()
{
	
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
}
function cancelView()
{
	
	document.forms[0].hmode.value="LIST";
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
function validate1(){

	var hisValidator = new HISValidator("thirdPartyIssueBean");
	hisValidator.addValidation("strInstituteCode", "dontselect=0","Please Select Third Party Name");
	hisValidator.addValidation("strItemCatNo", "dontselect=0","Please Select Item Category Name");
	hisValidator.addValidation("strGroupIdForItemSearch", "dontselect=0","Please Select Group Name");
    hisValidator.addValidation("strQty", "req","Please Enter Issue Qty");
    hisValidator.addValidation("strUnitName", "dontselect=0","Please Select Unit Name");
    var retVal = hisValidator.validate();
    var itemUsrVal  =document.getElementsByName("itemUserValue");
	var unitNameCmb =document.getElementsByName("strUnitName");
	var issueQty  =document.getElementsByName("strQty");
	var myArray  =new Array();
	var myArray1 =new Array();
	var issueQtyVal="0";
	var trnsQtyVal="0";
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
	  }   
     
    hisValidator.clearAllValidations();	
    
	if(retVal)
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
		
	
	}else{
	return false;
	}
}
