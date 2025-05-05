
function getUnitCombo()
{ 
   var mode="UNITVAL";
   var url="IssueToPatientTransCNT.cnt?hmode="+mode+"&modName="+document.forms[0].strDeptCombo.value;
   ajaxFunction(url,"1");
  
}
function getAjaxResponse(res,mode)
{
  if(mode=="1")
  {
     var objVal = document.getElementById("GrpNameId");
     objVal.innerHTML = "<select name = 'strUnitCombo'>" + res + "</select>";
  }  
}
function checkOnOffLineFlag()
{
  if(document.forms[0].strGoFlag.value=='1')
  {
   document.getElementById("All").style.display="block";
   document.getElementById("strStoreNameCmb").value = document.forms[0].strStoreNameCmbTemp.value;
   document.getElementById("strItemCategoryCmb").value = document.forms[0].strItemCategoryCmbTemp.value;
   document.getElementById("detailsdivid1").style.display="block";
   document.getElementById("minus1").style.display="block";
   document.getElementById("plus1").style.display="none";
   document.forms[0].button1.value = 1;
  }  
  if(document.forms[0].strOnOffLineflag.value=='1'&& document.forms[0].strOnOffLineflag.value!='0')
  {
    document.getElementById("onlineMode").style.display="block";
    document.getElementById("offlineMode").style.display="block";
  }
  else
  {
    document.getElementById("offlineMode").style.display="block";
    document.getElementById("onlineMode").style.display="block";
  }
}

function initPage()
{
  //document.forms[0].hmode.value="unspecified";
  document.getElementById("All").style.display="none";
  document.forms[0].strEmpNo.value="";
  //document.forms[0].submit();
}
function getItemSelectPopup()
{
	    var data                        = (document.forms[0].strStoreNameCmbTemp.value).split("^"); 
		var strModeVal 					= "2" ; 
		var strItemCategory 			= "1" ; 
		var strIssueType 				= "0";
		var strFromStoreId 				= data[0];
		var strToStoreId  				= "";
		var strStoreTypeId  			= data[1];
		var strMultiRowCompArray 		= new Array('itemParamValue','strIssuedQty','strUnitName');
		var strMultiRowCompTypeArray 	= new Array('t','t','s');
		// for mode val 1
		//var strMultiRowFetchDataArray 	= new Array('6','12','3^strUnitName');
		
		// for mode val 2
		var strMultiRowFetchDataArray 	=    new Array('17','18','3','11^strUnitName');
		
		// for mode val 3
		//var strMultiRowFetchDataArray 	= new Array('37','45','4^strUnitName');
	
		var layerIndex = "1";
	    searchItems( strModeVal , strItemCategory , strIssueType ,strFromStoreId, strToStoreId , strStoreTypeId , strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex);
	
}


//-----------JS FUNCTIONS from JSP file-------------------------//

function goFunc()                //  for CR No. field validation
{
    var StoreNameCmb = document.getElementById("strStoreNameCmb");
 	var ItemCatCmb   = document.getElementById("strItemCategoryCmb"); 
     if(StoreNameCmb.selectedIndex != 0 && ItemCatCmb.selectedIndex!=0)
     {
        var hisValidator = new HISValidator("issueToEmpTransBean");  
	 	hisValidator.addValidation("strEmpNo", "req", "Emp NO. is a Mandatory Field" );
		//hisValidator.addValidation("strEmpNo", "minlen="+document.forms[0].strEmpNo.maxLength,"CR No. must be "+document.forms[0].strEmpNo.maxLength+" Digits" );
		var retVal = hisValidator.validate(); 
		document.forms[0].strTempEmpNo.value = document.forms[0].strEmpNo.value;
	    document.forms[0].strEmpNo.focus();
	    
	    if(retVal)
	    {
	    	  	document.forms[0].hmode.value="GO";
	           	document.forms[0].submit();
		}else{
		
		return false;
		}
	}
	else
	{
	 alert("Plz Select Drug Warehouse Name & Item Category !!!!");
	 if(StoreNameCmb.selectedIndex == 0)
	 {
	    document.forms[0].strStoreNameCmb.focus();
	 }
	 else
	 {
	   document.forms[0].strItemCategoryCmb.focus();
	 }
	 return false;
	}	
}

    /**
	   * initGoFunc
	   * @param {Event} eve 
	   */
function initGoFunc(eve)
{
   var flag=validateData(eve,5);
	if(flag)
	{
			if(eve.keyCode==13)
			{
				goFunc();
				
			}
	}
	else
	{
			return false;
	}
  
  
}
//------------If Enter Key Press--------------//
function goFuncOnEnter(e)
{
   if(e.keyCode == 13)
   {
	 goFunc();
	}
	else
	{
	 return false;
	}
}  
function cancel(mode)
{
    document.forms[0].hmode.value=mode;
	document.forms[0].submit();
}

function ftn11(obj)
 {     
 if(document.forms[0].strEmpNo.value != 0)
  {  
   if(document.forms[0].button1.value != 1 )
   {
    document.getElementById("detailsdivid1").style.display="block";
    document.getElementById("minus1").style.display="block";
    document.getElementById("plus1").style.display="none";
    document.forms[0].button1.value = 1;
   }
   else
   {
    document.getElementById("minus1").style.display="none";
    document.getElementById("plus1").style.display="block";
    document.getElementById("detailsdivid1").style.display="none";
    document.forms[0].button1.value = 0;
   } 
  }
  else
  {
   alert("Plz Enter CR No First!!!!!!");
  }
}
 function ftn33(obj)
 {     
  if(document.forms[0].strEmpNo.value != 0)
  { 
   if(document.forms[0].button3.value != 1)
   {
    document.getElementById("detailsdivid2").style.display="block";
    document.getElementById("minus3").style.display="block";
    document.getElementById("plus3").style.display="none";
    document.forms[0].button3.value = 1;
   }
   else
   {
    document.getElementById("minus3").style.display="none";
    document.getElementById("plus3").style.display="block";
    document.getElementById("detailsdivid2").style.display="none";
    document.forms[0].button3.value = 0;
   } 
  }
  else
  {
   alert("Plz Enter Emp NO First!!!!!");
  }
 }
