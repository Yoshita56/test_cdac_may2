/** This is the validate function for Breakage Item Details jsp file
 *  i.e:- add_BreakageItemDtlTrans_mms.jsp and 
 *  transfer control to the controller 'INSERT' method.  
 */
 
 function validate1()
 {
     
	  var hisValidator = new HISValidator("requestForLpStaff");  
	  
	  hisValidator.addValidation("strToStore","dontselect=0","Please select a value from To Store Combo" );
      hisValidator.addValidation("strCrNo","req","CR NO. is a Mandatory Field" );
      hisValidator.addValidation("strProvisionDiagnosis","dontselect=0","Please select ICD10 Diagnosis Combo" );
      //hisValidator.addValidation("strGroupIdForItemSearch","dontselect=0","Please select a value from Group Name Combo" );     
	  hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	  hisValidator.addValidation("strRecmndBy","dontselect=0","Please select a value from Recomended By Combo" );
	  var retVal = hisValidator.validate(); 
	  
	  var itemParVal  = document.getElementsByName("itemParamValue");

      var unitNameCmb = document.getElementsByName("strUnitName");

      var bkgQty  = document.getElementsByName("strReqQty");

      var myArray   = new Array();

      var myArray1  = new Array();

      var bkgQtyVal="0";
      var count = parseInt("0"); 
    if(retVal)
    { 
     if(itemParVal.length > 1)
     {
      for(var x=0;x<itemParVal.length-1;x++)
      {
          hisValidator.addValidation("strReqQty","req","Required Quantity is a Mandatory Field" );
	      hisValidator.addValidation("strUnitName","dontselect=0","Please select a value from Unit Name Combo" );
	      
          var retVal1 = hisValidator.validate();
          
          if(retVal1)
          {
           myArray = itemParVal[x].value.split("^");
          //alert("unitNameCmb[x]->"+unitNameCmb[x].value);
           myArray1 = unitNameCmb[x].value.split("^");
            if(bkgQty[x].value <= 0)
            {
              bkgQty[x].value = '0';
        	  unitNameCmb[x].value = '0';
              alert("Request Qty must be Greater than Zero!!");
              retVal=false;
            }
             count = count +1;    
                       
          }
           else
	       {
		    return false;
		   } 
        }/*For Loop End*/
        if(count>0)
        {
              document.forms[0].strCrNo.disabled = false;            
              document.forms[0].hmode.value="INSERT";
	       	  document.forms[0].submit();     
	    } 
        
      }
      else
	  { 
	      alert("Please Select Item from Search Utility!!!");
		  return false;
	  }
	}
	else
	 {
		  return false;
     }     
 }

function ftnTick()
{
  if(document.forms[0].strIsNormal.value=='1')
   {
     document.forms[0].strIsNormal.checked = false;
     document.forms[0].strIsNormal.value=0;
   }
   if(document.forms[0].strIsNormal.checked == true)
   {
    document.forms[0].strIsNormal.value=1;
    if(document.forms[0].strIsUrgent.checked == true)
    {
       document.forms[0].strIsUrgent.checked = false; 
    }
   }
   else
   {
     document.forms[0].strIsNormal.value=0;
   }
   if(document.forms[0].strIsUrgent.checked == true)
   {
    document.forms[0].strIsUrgent.value=1;
    if(document.forms[0].strIsNormal.checked == true)
    {
       document.forms[0].strIsNormal.checked = false; 
    }
   }
   else
   {
      document.forms[0].strIsUrgent.value=0;
   }
  
}

function myFunc11(mode)
{  
		if(mode == '1')
		{
			var hmode = "HOSITALPDIAGNOSIS"; 
			var url = "RequestForLPPatientCNT.cnt?hmode="+hmode;
			ajaxFunction(url,"3");
		}
		else 
		if(mode == '2')
		{
			var hmode = "ICDDIAGNOSIS"; 
			var url = "RequestForLPPatientCNT.cnt?hmode="+hmode;
			ajaxFunction(url,"4");
		}
}


function cancelToDesk()
{
  var mode="CANCEL";
 
  document.forms[0].hmode.value=mode;
  document.forms[0].submit();
}

function showValues(obj,delIndex)
{
  //document.strIcdCode2-1
  document.getElementById("strIcdCode"+delIndex).value = obj.options[obj.selectedIndex].value;
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

      if(mode == '3')
       {
			var objEle = document.getElementById("diagnosisCombo");
			objEle.innerHTML = "<select class='comboBig' name='strProvisionDiagnosis' id='strProvisionDiagnosis#delIndex#' onChange='showValues(this,\"#delIndex#\");'>"+res+"</select>";
			addRows(new Array('strIcdCode','strProvisionDiagnosis'),new Array('t','s'),'2','1','R');
			
	  }
	  if(mode == '4')
	  {
			var objEle = document.getElementById("diagnosisCombo");
			objEle.innerHTML = "<select class='comboBig' name='strProvisionDiagnosis' id='strProvisionDiagnosis#delIndex#' onChange='showValues(this,\"#delIndex#\");'>"+res+"</select>";
			addRows(new Array('strIcdCode','strProvisionDiagnosis'),new Array('t','s'),'2','1','R');
			
	  }
}

function initPage()
{
  document.forms[0].strToStore.value         = "0";
  if(document.forms[0].strCrNo.disabled)
  {
   document.forms[0].strCrNo.disabled = false;
  }
  else
  {
   document.forms[0].strCrNo.disabled = true;
  } 
 // document.forms[0].strItemCatg.value        = "0";
  document.forms[0].strCrNo.value="";
  document.getElementById("All").style.display="none";
  document.getElementById("errMsg").innerHTML = "";
  document.forms[0].strGoFlg.value = '0';
}

function OnLoadFunction()
{
  var mode=1;
 
  //document.forms[0].strItemCatg.value        = document.forms[0].strTmpItemCatg.value;
  if(document.forms[0].strGoFlg.value=='1')
  { 
    document.forms[0].strToStore.value         = document.forms[0].strComboVal.value;
    document.forms[0].strCrNo.disabled = true; 
    if(mode==1)
		{
		    
			document.getElementById('icdDiagnosisId').style.display="block";
			document.getElementsByName("strDiagnosisType")[1].checked=true;
		}
		else
		{
		    document.getElementById('icdDiagnosisId').style.display="block";
			document.getElementById('hospitalDiagnosisId').style.display="block";
		}
       
       if(document.forms[0].strDiagnosisType[0].checked == true)
		{
		    
			myFunc11('1');	
		}
		else
		{
		   
			myFunc11('2');
		}
		
	   if(document.forms[0].strCatgoryCode.value != document.forms[0].strConfigCatCode.value)
       {
         document.forms[0].strCrNo.value="";
         document.getElementById("All").style.display="none";
         document.getElementById("detailsdivid1").style.display="none";
         document.forms[0].strToStore.value        = '0';
         document.forms[0].strGroupIdForItemSearch.value = '0';
         document.getElementById("id1").style.display="none";
         document.getElementById("errMsg").innerHTML = "";
         var id = document.getElementById("strApproxAmtDivId");
         id.innerHTML ="0.00";
         document.forms[0].strGoFlg.value=='1';
         document.getElementById("errMsg").innerHTML = "Please Entered CR No for Staff !!!!";
         return false;
         
       }
		
   document.getElementById("All").style.display="block";
   document.getElementById("detailsdivid1").style.display="block";
   document.getElementById("minus1").style.display="block";
   document.getElementById("plus1").style.display="none";
   document.forms[0].button1.value = 1;
  } 

}
//-----------JS FUNCTIONS from JSP file-------------------------//
function goFunc()                //  for CR No. field validation
{
        var hisValidator = new HISValidator("requestForLpStaff");  
	 	hisValidator.addValidation("strCrNo", "req", "CR No. is a Mandatory Field" );
		hisValidator.addValidation("strCrNo", "minlen="+document.forms[0].strCrNo.maxLength,"CR No. must be "+document.forms[0].strCrNo.maxLength+" Digits" );
		var retVal = hisValidator.validate();
	    document.forms[0].strTmpCrNo.value            = document.forms[0].strCrNo.value;
		document.forms[0].strComboVal.value         = document.forms[0].strToStore.value;
	   // document.forms[0].strCrNo.focus();
		
	    if(retVal)
	    {
	           
	       	  	document.forms[0].hmode.value="GO";
	            document.forms[0].submit();
		}
		else
		{
		   return false;
		}
		
}

    /**
	   * initGoFunc
	   * @param {Event} eve 
	   */
function goRetFunc(obj)

{
     var flag=validateData(obj,5);
     if(flag)
     {

                  if(obj.keyCode==13)

                  {

                        var flag1=goFunc();

                        if(!flag1)

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

//------------If Enter Key Press--------------//

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

function setCode(objVal,index)
{
	if(objVal.value.toUpperCase()!=""){
		document.getElementById("strProvisionDiagnosis"+index).value=objVal.value.toUpperCase();
		
		if(document.getElementById("strProvisionDiagnosis"+index).value=="")
			document.getElementById("strProvisionDiagnosis"+index).value="0";
			}
	else
	{
		document.getElementById("strProvisionDiagnosis"+index).value="0";
	}
}