function save()
{
 alert("save");
 var frmName=document.forms[0].name;
 alert("frm->"+frmName);
 /*
 var hisValidator = new HISValidator(frmName); 
 hisValidator.addValidation("strValidFrom","dtgtet="+document.forms[0].strCtDate.value,"Please Select Effective From Date Greater Than Or Equal To Current Date.");
 alert(document.forms[frmName].strValidFrom.value);
 alert(document.forms[frmName].strValidTo.value);
 alert("ctdate->"+document.forms[frmName].strCtDate.value);
 if(document.forms[frmName].strValidTo.value!= "")
		hisValidator.addValidation("strValidTo","dtgtet="+document.forms[0].strValidFrom.value,"Please Select Effective To Date Greater Than Or Equal To Effective From Date.");
 var retVal = hisValidator.validate();
 hisValidator.clearAllValidations();
 hisValidator=null;
 alert("retVal->"+retVal);*/
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
 document.forms[0].hmode.value="SAVE";
 document.forms[0].submit();
}