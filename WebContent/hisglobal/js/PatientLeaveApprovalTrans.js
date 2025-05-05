function displayLeaveApprDtls()
{
  var o1=document.getElementsByName("strLeaveApproval");
  if(o1[0].checked==true)
  {
    document.getElementById("disBnRj").style.display="block";
    var o=document.getElementById("rmkMandate"); 
    o.innerHTML="Remarks:";
    o1[0].value="1";
    o1[1].value="0";
  }  
  if(o1[1].checked==true)
  {
    document.getElementById("disBnRj").style.display="block"; 
    var o=document.getElementById("rmkMandate"); 
    o.innerHTML="<font color='red'>*</font>Remarks:";
    o1[0].value="0";
    o1[1].value="1";
  }
}

function hlpOnLoad_LJ()
{     
          var cnt=document.forms[0].cnt.value;
          var frmName=document.forms[0].name;
          if(document.forms[0].strCrNo.value>0)
          {
            var o1=document.getElementById("admDtlTld");
            if((o1.innerHTML).length>9)
            {
               document.getElementById("disBnR").style.display="block";
               document.getElementById("patTldglbdiv").style.display="block";
               document.getElementById("admDtlTldglbdiv").style.display="block";
               document.getElementById("patDtlTld").style.display="block";
               document.getElementById("admDtlTld").style.display="block";
               document.getElementById("transChng").style.display="block";
               document.getElementById("leaveApproval").style.display="block";
               document.getElementById("disBnRj").style.display="block";
               document.getElementById("LeaveId").style.display="block";
		    }
		    else
		    {
		       document.forms[0].strErrMsgString.value=document.forms[0].strGlbErrMsgTLD.value;
		       document.getElementById("patTldglbdiv").style.display="none";
		       document.getElementById("admDtlTldglbdiv").style.display="none";
               document.getElementById("patDtlTld").style.display="none";
               document.getElementById("id1").style.display="none";
               document.getElementById("transChng").style.display="none";
               document.getElementById("admDtlTld").style.display="none";
               document.getElementById("disBnR").style.display="none";
               document.getElementById("leaveApproval").style.display="none";
               document.getElementById("disBnRj").style.display="none";
               document.getElementsByName("strErrMsgString")[0].value="Invalid CrNo/Data Not Found";
               document.getElementById("errMsg").style.display="block";
               if(frmName=="patientLeaveApprovalTransBean")
               {
                 document.getElementById("LeaveId").style.display="none";
               }
               document.forms[0].hmode.value="CANCEL";
               document.forms[0].strCrNo.value="";
               document.forms[0].submit();
		    }
		  }
		  else
		  {
		  }
}

function admStatus()
{
  var mode="admStatus";
  if(typeof(document.forms[0].curAdmNo)!="undefined")
  {
   var admno=document.forms[0].curAdmNo.value;
  // if(document.forms[0].strCrNo.value!="")
   {
     var url="PatientLeaveApprovalTransCNT.cnt?hmode="+mode+"&admno="+admno+"&crNo="+document.forms[0].strCrNo.value;
     ajaxFunction(url,"777");
   }
  }   
}

function save()
{
 alert("save");
 var frmName=document.forms[0].name;
 if(document.forms[0].strValidFrom.value=="" ||document.forms[0].strValidTo.value=="")
 { 
  alert("Leave From and Probable Joining Date are Mandatory fields!!!");
  return false;
 }
 var hisValidator = new HISValidator(frmName); 
 hisValidator.addValidation("strValidFrom","dtgtet="+document.forms[0].strCtDate.value,"Please Select Effective From Date Greater Than Or Equal To Current Date.");
 if(document.forms[frmName].strValidTo.value!= "")
		hisValidator.addValidation("strValidTo","dtgtet="+document.forms[0].strValidFrom.value,"Please Select Effective To Date Greater Than Or Equal To Effective From Date.");
 var retVal = hisValidator.validate();
/* if(document.forms[0].strMlc.value!="")
  alert("MLC Ptient can be discharged only through Medico-Legal Procedures!!!");
 document.forms[0].hmode.value="SAVE";
 var puk=document.forms[0].strCrNo.value;
 var myArray=new Array();
 var myArray1=new Array();
 var tr=document.forms[0].strRsn.value;
 myArray=(document.forms[0].curWrdBedCode.value).split("^");
 var owc=myArray[0];
 myArray1=(document.forms[0].curDept_Unt_RomCode.value).split("^");
 var orc=myArray1[2];
 var obc=myArray[1];
 var admNo=document.forms[0].curAdmNo.value;
 var transFlg=document.forms[0].strTransferUnit[document.forms[0].strTransferUnit.selectedIndex].value;
 alert("transFlg->"+transFlg);
 var trans_Id=document.forms[0].transId.value;
 if(transFlg=="1")
 {
   var dc=document.forms[0].strDepartment.value;
   var uc=document.forms[0].strUnit.value;
   var myArrayW=new Array();
   myArrayW=(document.forms[0].strWard.value).split("^");
   var wc=myArrayW[0];
   var rc=document.forms[0].strRoom.value;
   var bc="0";
   var ed=document.forms[0].strEntryDate.value;
   var insertStr=puk+"^"+dc+"^"+uc+"^"+wc+"^"+rc+"^"+obc+"^"+tr+"^"+ed+"^"+owc+"^"+orc+"^"+obc+"^"+admNo+"^"+trans_Id;
 }
 if(transFlg=="2")
 {
   var rc=document.forms[0].strRoom.value;
   var bc=document.forms[0].strBed.value;
   var ed="0";
   var insertStr=puk+"^"+myArray1[0]+"^"+myArray1[1]+"^"+myArray[0]+"^"+rc+"^"+bc+"^"+tr+"^"+ed+"^"+owc+"^"+orc+"^"+obc+"^"+admNo+"^"+trans_Id;
 }
 if(transFlg=="3")
 {
   var dc=document.forms[0].strDepartment.value;
   var rc=document.forms[0].strRoom.value;
   var uc=document.forms[0].strUnit.value;
   var ed="0";
   var insertStr=puk+"^"+dc+"^"+uc+"^"+myArray[0]+rc+"^"+obc+"^"+tr+"^"+ed+"^"+owc+"^"+orc+"^"+obc+"^"+admNo+"^"+trans_Id;
 }
 alert("insertStr->>"+insertStr);
 document.forms[0].strTempVal.value=insertStr;
 document.forms[0].hmode.value="SAVElj";
 document.forms[0].strCrNo.value="";
 document.forms[0].hmode.value="SAVE";
 document.forms[0].submit();*/
 if(retVal==true)
 {
   document.forms[0].hmode.value="SAVE";
   hisValidator.clearAllValidations();
   hisValidator=null;
   document.forms[0].submit();
 }
 else
 {
    return false;
 }  
}