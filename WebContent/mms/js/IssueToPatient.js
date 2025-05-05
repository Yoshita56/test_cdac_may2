function AjaxFunc()
{
 alert("Inside Ajax Func!!!!");
}
function getUnitCombo()
{ 
   var mode="UNITVAL";
   var url="IssueToPatientTransCNT.cnt?hmode="+mode+"&modName="+document.forms[0].strDeptCombo.value;
   ajaxFunction(url,"1");
}
function getItemCategory()
{ 
   var mode="UNITVAL1";
   var url="IssueToPatientTransCNT.cnt?hmode="+mode+"&modName="+document.forms[0].strStoreNameCmb.value;
   ajaxFunction(url,"2");
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
       var objVal = document.getElementById("GrpNameId");
       objVal.innerHTML = "<select name = 'strUnitCombo'>" + res + "</select>";
    }  
    if(mode=="2")
    {
     var objVal = document.getElementById("ItemNameId");
     objVal.innerHTML = "<select name = 'strItemCategoryCmb' id='strItemCategoryCmb'>" + res + "</select>";
    }  
}
/*
  This function is call on when page is  Load
  here we decided that which mode is operated 
  Mode 0 - > Patient
  Mode 1 - > Staff
  Mode 2 - > Both Patient\Staff 
*/
function checkOnOffLineFlag()
{
   document.getElementById("strStoreNameCmb").disabled  = false;
   
   if(document.getElementById("errMsg").innerHTML != null)
   {
     document.getElementById("All").style.display="none";   
     document.forms[0].strCrNo.value="";     
   }
   
   
   if(document.forms[0].strMode.value!='2')
   {
    /* Here We Check Mode 1 for Staff & 0 For Patient */
    if(document.forms[0].strMode.value=='1')
    {
      document.getElementById("Staff").style.display="block";
      document.getElementById("Patient").style.display="none";
      document.getElementById("Staff1").style.display="block";
      document.getElementById("Patient1").style.display="none";
    }
    else
    {
     document.getElementById("Patient").style.display="block";
     document.getElementById("Staff").style.display="none";
     document.getElementById("Patient1").style.display="block";
     document.getElementById("Staff1").style.display="none";
    }
    if(document.forms[0].strGoFlag.value=='1')
    {
      /*Here We Change Item Category Value and disabled Store Name Combo*/
     document.getElementById("strStoreNameCmb").disabled  = true;  
     document.getElementById("strItemCategoryCmb").style.display ="none";
     document.getElementById("ItemNameIdName").style.display ="block";
     document.getElementById("ItemNameIdName").innerHTML = document.forms[0].itemCatName.value ;    
         
         
     document.getElementById("All").style.display="block";
     document.getElementById("strStoreNameCmb").value = document.forms[0].strStoreNameCmbTemp.value;
     document.getElementById("strItemCategoryCmb").value = document.forms[0].strItemCategoryCmbTemp.value;
     document.forms[0].strCrNo.value = document.forms[0].strTempCrNo.value;
     document.getElementById("detailsdivid1").style.display="block";
     document.getElementById("minus1").style.display="block";
     document.getElementById("plus1").style.display="none";
     document.forms[0].button1.value = 1;
     if(document.forms[0].strCatgoryCode.value == document.forms[0].strCatCode.value)
     {
       document.getElementById("errMsg").innerHTML = "Go To Staff Counter!!!!";
       document.forms[0].strCrNo.value="";
       document.getElementById("All").style.display="none";
       document.getElementById("strStoreNameCmb").value='0';
       document.getElementById("strItemCategoryCmb").value='0';
       if(document.forms[0].strTmpMode.value=='1')
       {
        document.getElementById("Staff").style.display="block";
        document.getElementById("Patient").style.display="none";
        document.getElementById("Staff1").style.display="block";
        document.getElementById("Patient1").style.display="none";
       }
    }
    else
    {
      if(document.forms[0].strTmpMode.value=='1')
      {
        document.getElementById("Staff").style.display="block";
        document.getElementById("Patient").style.display="none";
        document.getElementById("Staff1").style.display="block";
        document.getElementById("Patient1").style.display="none";
      }
    }
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
  else
  {
     document.getElementById("Patient").style.display="block";
     document.getElementById("Patient1").style.display="block";
     alert("No Restriction For MODE 2!!!!");
  }
  document.getElementById("offlineMode").style.display="block";
  
}

function initPage()
{
  //document.forms[0].hmode.value="unspecified";
  document.getElementById("All").style.display="none";
  document.getElementById("strStoreNameCmb").value='0';
  document.getElementById("strItemCategoryCmb").value='0';
  document.forms[0].strCrNo.value="";
  document.getElementById("errMsg").innerHTML = "";
  document.getElementById("strStoreNameCmb").disabled  = false; 
  document.getElementById("strItemCategoryCmb").style.display ="block";
  document.getElementById("ItemNameIdName").style.display ="none";
  //document.forms[0].submit();
}
function getItemSelectPopup()
{
  var strDummyIssueType ; 
        if(document.forms[0].strCatgoryCode.value!='11')
        {
          strDummyIssueType = document.forms[0].strCatgoryCode.value;
        }
        else
        {
          strDummyIssueType = "0";
        }
       // alert("Dummy Issue type-->>>"+strDummyIssueType);
	    var data                        = (document.forms[0].strStoreNameCmbTemp.value).split("^"); 
		var strModeVal 					= "3" ; 
		var strItemCategory 			= "1" ; 
		var strIssueType 				= strDummyIssueType;
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
        var hisValidator = new HISValidator("issueToPatTransBean");  
	 	hisValidator.addValidation("strCrNo", "req", "CR No. is a Mandatory Field" );
		hisValidator.addValidation("strCrNo", "minlen="+document.forms[0].strCrNo.maxLength,"CR No. must be "+document.forms[0].strCrNo.maxLength+" Digits" );
		var retVal = hisValidator.validate(); 
		document.forms[0].strTempCrNo.value    = document.forms[0].strCrNo.value;
		document.forms[0].strTmpMode.value     = document.forms[0].strMode.value;
	   
	    document.forms[0].itemCatName.value    = document.forms[0].strItemCategoryCmb[document.forms[0].strItemCategoryCmb.selectedIndex].text;
	   
	    document.forms[0].strCrNo.focus();
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
function ftn33(obj)
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
