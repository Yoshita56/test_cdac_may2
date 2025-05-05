/******* JS Functions for Discharge , Transfer & Leave **********/

function enter(e)
{
  if(e.keyCode=="13")
  {
	document.forms[0].hmode.value="GO";
	document.forms[0].submit();
  }	
}
function goFunc(frmName)        //  for CR No. field validation
{
		var hisValidator = new HISValidator(frmName); 
		var typ=hisValidator.type;
	 	hisValidator.addValidation("strCrNo", "req", "Cr No. is a Mandatory Field" );
	    hisValidator.addValidation("strCrNo", "minlen=13", "Cr No. must be 13 Digits" );
        var retVal = hisValidator.validate(); 
	    document.forms[0].strTempVal.value=document.forms[0].strCrNo.value;
	    if(retVal){
				document.forms[0].hmode.value="GO";
				document.forms[0].submit();
		}else{
		    return false;
		}
}
	
function cancel()
{
 document.forms[0].hmode.value="CANCEL";
 //document.getElementById("patdtltld").style.display="none";
// document.getElementById("disBnR").style.display="none";
 document.forms[0].strCrNo.value="";
 document.forms[0].submit();
}

function cancel_dtl_sub()
{
  if(document.forms[0].strCancelRmk.value=="")
  {
    alert("Cancellation Remarks is Mandatory");
    return false;
  }
  else
  {
    return true;
  }
}

function getAjaxResponse(res,mode)
{
   if(mode=="1")
   {
  //  alert("resUnit=="+res);
    var objVal = document.getElementById("unitId");
    objVal.innerHTML = "<select style='cursor:pointer;cursor:hand' name = 'strUnit' class='browser-default custom-select' onChange='funconsultant(),funward();'>" + res + "</select>";
    document.forms[0].strWardType.selectedIndex=0;
    document.forms[0].strWard.selectedIndex=0;
    document.forms[0].strRoomType.selectedIndex=0;
    document.forms[0].strRoom.selectedIndex=0;
    var l=document.forms[0].strUnit.length;
    if(l=="2")
     document.forms[0].strUnit.selectedIndex=l-1;
   }
   if(mode=="2")
   {
  //  alert("resUnit=="+res);
    var objVal = document.getElementById("wardId");
    if(document.forms[0].name=="patientLeaveBean")
      objVal.innerHTML = "<select style='cursor:pointer;cursor:hand' name = 'strWard' class='browser-default custom-select' onChange='funroomLJ();' >" + res + "</select>";
    else
      objVal.innerHTML = "<select style='cursor:pointer;cursor:hand' name = 'strWard' class='browser-default custom-select' onChange='funroom();' >" + res + "</select>";
    var l=document.forms[0].strWard.length;
    if(l=="2")
     document.forms[0].strWard.selectedIndex=l-1;
   }
   if(mode=="3")
   {
   // alert("res=="+res);
    var objVal = document.getElementById("roomId");
   // if(document.forms[0].strCmbRed.value=="1")
       objVal.innerHTML = "<select style='cursor:pointer;cursor:hand' name = 'strRoom' class='browser-default custom-select' onChange='funbed();'>" + res + "</select>";
  //  else
    {
      // objVal.innerHTML = "<select style='cursor:pointer;cursor:hand' name = 'strRoom' class='browser-default custom-select' onChange='funbed();'>" + res + "</select>";
      // document.forms[0].strCmbRed.value="0";
    }
    var l=document.forms[0].strRoom.length;
    if(l=="2")
     document.forms[0].strRoom.selectedIndex=l-1;
   }
   if(mode=="4")
   {
 //   alert("res=="+res);
    var objVal = document.getElementById("bedId");
    
    objVal.innerHTML = "<select style='cursor:pointer;cursor:hand' name = 'strBed' title='Click to view Bed Status' class='browser-default custom-select' >" + res + "</select>";
    var l=document.forms[0].strBed.length;
    if(l=="2")
     document.forms[0].strBed.selectedIndex=l-1;
  }
  if(mode=="5")
   {
  //  alert("res=="+res);
    var objVal = document.getElementById("consultantId");
    objVal.innerHTML = "<select style='cursor:pointer;cursor:hand' name='strConsultantCode' class='comboMax' dir='' title='' onChange=''>"+res+"</select>";
    var l=document.forms[0].strConsultantCode.length;
    if(l=="2")
     document.forms[0].strConsultantCode.selectedIndex=l-1;
  }
 		 if(mode=="111")
 		 {
		     var objVal = document.getElementById("id1");
		     objVal.innerHTML = res; 
		    // objVal.style.display="block";
         }
        if(mode == '222'){
			var objEle = document.getElementById("menu1");
			objEle.innerHTML = res;
			objEle.style.display="none";
			display_popup_menu(pWindow,"menu1","365","");
		}
}   

function openPopup(mode){
  var s=document.forms[0].curWrdBedCode.value;
    var myArray=new Array();
    myArray=s.split("^");
    var temp=myArray[0]+"^"+document.forms[0].strRoom.value+"^"+document.forms[0].strBedType.value;
if(mode=="BEDSTATUS"){
var url=document.forms[0].cnt.value+"?hmode="+mode+"&modPopUp="+temp;
alert("url=="+url);
var featuresList = "width=500,height=300,ALIGN=CENTER,left=100,top=100,scrollbars=yes"
 myWindow = window.open(url,'popupWindow',featuresList)
}
}

function fununit()
{ 
 // alert("mode:"+mode);
 // if(mode=="UNIT")
   var mode="UNIT";
   //alert("UNIT =="+document.forms[0].strDepartment.value);
   var url=document.forms[0].cnt.value+"?hmode="+mode+"&modDept="+document.forms[0].strDepartment.value;
   ajaxFunction(url,"1");
}

function funward()
{ 
   var mode="WARD";
   var myArray1=new Array();
   myArray1=(document.forms[0].curDept_Unt_RomCode.value).split("^");
   if(typeof(document.forms[0].strDepartment)=="undefined")
     var temp=myArray1[0]+"^"+myArray1[1]+"^"+document.forms[0].strWardType.value;
   else 
     var temp=document.forms[0].strDepartment.value+"^"+document.forms[0].strUnit.value+"^"+document.forms[0].strWardType.value;
   alert("for ward->"+temp);
   var url=document.forms[0].cnt.value+"?hmode="+mode+"&modWardTpe="+temp;
   ajaxFunction(url,"2");
}

function funroom()
{ 
    var mode="ROOM";
    var myArray=new Array();
    if(document.forms[0].strTransferUnit[document.forms[0].strTransferUnit.selectedIndex].value=="2")
    {
     var s=document.forms[0].curWrdBedCode.value;
     myArray=s.split("^");
     var temp=myArray[0]+"^"+document.forms[0].strRoomType.value;
    }
    else
    {
     var objWard=document.getElementsByName("strWard");
     alert("ward val->>"+objWard[0].value);
     myArray=(objWard[0].value).split("^");
     var cr=document.forms[0].strCrNo.value;
     var admAdv=document.forms[0].curAdmAdvNo.value;
     if(myArray[1]=="1")
      alert("MS Approval is Required!!");
     alert("ward type here->"+document.forms[0].strWardType[document.forms[0].strWardType.selectedIndex].value);
     var wrdTyp=document.forms[0].strWardType[document.forms[0].strWardType.selectedIndex].value;
     var temp=myArray[0]+"^"+document.forms[0].strRoomType.value+"^"+myArray[1]+"^"+wrdTyp+"^"+cr+"^"+admAdv;
     alert("temp->"+temp);
    }
   alert("for Room->"+temp);
   var url=document.forms[0].cnt.value+"?hmode="+mode+"&modRoomType="+temp;
   ajaxFunction(url,"3");
}

function funroomLJ()
{ 
    var mode="ROOM";
    var myArray=new Array();
     var objWard=document.getElementsByName("strWard");
     alert("ward val->>"+objWard[0].value);
     myArray=(objWard[0].value).split("^");
     var cr=document.forms[0].strCrNo.value;
     var admAdv=document.forms[0].curAdmAdvNo.value;
     if(myArray[1]=="1")
      alert("MS Approval is Required!!");
     alert("ward type here->"+document.forms[0].strWardType[document.forms[0].strWardType.selectedIndex].value);
     var wrdTyp=document.forms[0].strWardType[document.forms[0].strWardType.selectedIndex].value;
     var temp=myArray[0]+"^"+document.forms[0].strRoomType.value+"^"+myArray[1]+"^"+wrdTyp+"^"+cr+"^"+admAdv;
     alert("temp->"+temp);
     alert("for Room->"+temp);
     var url=document.forms[0].cnt.value+"?hmode="+mode+"&modRoomType="+temp;
     ajaxFunction(url,"3");
}

function funbed()
{
   var mode="BED";
    var s=document.forms[0].curWrdBedCode.value;
    var myArray=new Array();
    myArray=s.split("^");
    var temp=myArray[0]+"^"+document.forms[0].strRoom.value+"^"+document.forms[0].strBedType.value;
    alert("for bed->"+temp);
   var url=document.forms[0].cnt.value+"?hmode="+mode+"&modBedType="+temp;
   ajaxFunction(url,"4");
}

function funServRoom()
{
   var mode="ServRoom";
    var temp=document.forms[0].strServArea.value;
    alert("for ServRoom->"+temp);
   var url=document.forms[0].cnt.value+"?hmode="+mode+"&modServCode="+temp;
   ajaxFunction(url,"3");
}

function funconsultant()
{
   var mode="ConsltntID";
   var temp=document.forms[0].strCrNo.value+"^"+document.forms[0].strDepartment.value+"^"+document.forms[0].strUnit.value;
   alert("temp->>"+temp);
   var url=document.forms[0].cnt.value+"?hmode="+mode+"&modConsltntID="+temp;
   ajaxFunction(url,"5");
}

function groupCombo(){

  var l =document.forms[0].strDisRsn.length-1;
  if(document.forms[0].strDisRsn.selectedIndex ==l)
  {
    document.forms[0].strDrt.value = "";
    document.forms[0].strDrt.disabled=false;
  }
  else
  {
    document.forms[0].strDrt.value=document.forms[0].strDisRsn[document.forms[0].strDisRsn.selectedIndex].text;
    document.forms[0].strDrt.disabled=true;
  }
}

function butdis()
{
 if( document.forms[0].strCrNo.value!="")
 {
  document.forms[0].strCrNo.readOnly=true;
 }
 if((document.forms[0].name=="patientMoveTransBean") || (document.forms[0].name=="patientDischargeBean"))
   document.forms[0].strTransferUnit.selectedIndex=0;
 document.forms[0].strErrMsgString.value="";
 document.forms[0].strNormalMsgString.value="";
}

function CNTIni()
{
  var frmName=document.forms[0].name;
  var cnt;
  if(frmName=="patientDischargeBean")
     cnt="PatientFinalDischargeCNT.cnt";
  if(frmName=="patientLeaveBean")
     cnt="PatientLeaveCNT.cnt";  
  if(frmName=="patientMoveTransBean")
     cnt="PatientTransferTransCNT.cnt"; 
     if(frmName=="patientLeaveApprovalTransBean")
     cnt="PatientLeaveApprovalTransCNT.cnt"; 
     if(frmName=="patientLeaveRequestTransBean")
     cnt="PatientLeaveRequestTransCNT.cnt"; 
     if(frmName=="patientLeaveJoinRecordTransBean")
     cnt="PatientLeaveJoinRecordTransCNT.cnt"; 
  document.forms[0].cnt.value=cnt;   
}

function hlpOnLoad()
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
               document.getElementById("id1").style.display="block";
               document.getElementById("transChng").style.display="block";
               var currDtUtWrRmBd=document.forms[0].curDtUtWrRmBd.value;
	           var mode="transOf";
		       var url=cnt+"?hmode="+mode+"&modName="+1+"&currDtl="+currDtUtWrRmBd;
		       ajaxFunction(url,"111");
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
               document.getElementsByName("strErrMsgString")[0].value="Invalid CrNo/Data Not Found";
               document.getElementById("errMsg").style.display="block";
               document.forms[0].hmode.value="CANCEL";
               document.forms[0].strCrNo.value="";
               document.forms[0].submit();
		    }
		  }
		  else
		  {
		  }
}

function transferOf(obj)
{
  if(document.forms[0].strCrNo.value>0)
  {
   if(document.getElementById("id1").style.display=="block")
   {
     if(confirm("Proceed without saving current data?"))
     {
       var currDtUtWrRmBd=document.forms[0].curDtUtWrRmBd.value;
       var mode="transOf";
       var url=document.forms[0].cnt.value+"?hmode="+mode+"&modName="+obj[obj.selectedIndex].value+"&currDtl="+currDtUtWrRmBd;
       ajaxFunction(url,"111");
       return true;
     }
     else
       return false;      
   }
   else
   {
     alert("Press GO to submit!!!");
     document.forms[0].strTransferUnit.value="1";
   } 
  }
  else
  {
   alert("Enter CR No. first!!!");
   document.forms[0].strTransferUnit.value="1";
   return false;
  }  
}

function hideDetails()
{
 document.getElementById("minusonLineId").style.display="none";
 document.getElementById("plusonLineId").style.display="block";
 document.getElementById("patDtlTld").style.display="none";
}
function showDetails()
{
 document.getElementById("plusonLineId").style.display="none";
 document.getElementById("minusonLineId").style.display="block";
 document.getElementById("patDtlTld").style.display="block";
}
function hideDetails1()
{
 document.getElementById("minusonLineId1").style.display="none";
 document.getElementById("plusonLineId1").style.display="block";
 document.getElementById("admDtlTld").style.display="none";
}
function showDetails1()
{
 document.getElementById("plusonLineId1").style.display="none";
 document.getElementById("minusonLineId1").style.display="block";
 document.getElementById("admDtlTld").style.display="block";
}
function hideDetails2()
{
 document.getElementById("minusonLineId2").style.display="none";
 document.getElementById("plusonLineId2").style.display="block";
 document.getElementById("LeaveId").style.display="none";
 document.getElementById("disBnR").style.display="none";
}
function showDetails2()
{
 document.getElementById("plusonLineId2").style.display="none";
 document.getElementById("minusonLineId2").style.display="block";
 document.getElementById("LeaveId").style.display="block";
 document.getElementById("disBnR").style.display="block";
}

