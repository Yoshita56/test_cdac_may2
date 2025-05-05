    
   function testFunction(obj)
   {
    
	 alert("Event val...." + obj.value);
	   
	}
	
/////////////////////////////JS Functions for list page/////////////////////
	function test_cancelled()
	{
	
	    add("CANCELLED");
	      
	}
	
	//////for selecting a record to cancel/////
	
	
	function cancel_body_load()
	{
	 var mode="Cancel_hlp";
	   var url="DiscountApprovalTransCNT.cnt?hmode="+mode;
		     ajaxFunction(url,"3");
	}

function changeRecordStatus2(obj)
	{
		comValue = obj.value;
		
  		if(comValue == 2)
		{
		comb=1;
		document.getElementById("Approved").style.color = "blue";
		//document.getElementById("Cancelled").style.color = "gray";
		document.getElementById("buttonL1Id2").disabled=true;
		}
		else
		 document.getElementById("buttonL1Id2").disabled=false;
	}
	
	function checkColor2()
	{
	  if(document.getElementById("buttonL1Id2").disabled)
	  {
	  // alert("Record cannot be cancelled again");
	    return false;
	    }
	    else
	      {
	      var chkVal = document.forms[0].chkLength.value;
	       if(chkVal !=1 )
	       {
	        alert("Please Select One Record");
	        return false;
	       }
	       else
	         add("CANCELLED");
	      }
	      
	 }
	
//-----------JS FUNCTIONS from JSP file-------------------------//
function goFunc()                //  for CR No. field validation
{
	//alert(mode.value);
	
		var hisValidator = new HISValidator("discountApprovalTransBean");  
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
 //alert("cancel");
 document.forms[0].hmode.value="CANCEL";
 //document.getElementById("id1").style.display="none";
 //document.forms[0]=null;
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
function groupCheck(chkObj,index)
{ 
 document.getElementById("save").disabled=false;


 document.forms[0].strTempVal.value=chkObj.value;
 alert("Req No^BSId^PatAccNo-> "+chkObj.value);
var j;

    for(var i=0;i<=document.forms[0].strChk_values.length;i++)
     {
       
        document.forms[0].strPopUp_id.value=i+1;
  		if(i==index)
  		 {
  		   if(document.forms[0].strChk_values[i].checked)
  		   {
  		   
  		    var objVal = document.getElementById("id1");
  		 
  		    for(j=0;j<document.forms[0].strChk_values.length;j++)
  		    {
  		    	if(i != j)
  		     if(document.forms[0].strChk_values[j].checked)
  		     { 
  		     document.forms[0].strChk_values[j].checked=false;
             }           
      	    }
      	  
  		     objVal.style.display="block";
	         var mode="BId";
	 	     i=document.forms[0].strChk_values.length;
		     var url="DiscountApprovalTransCNT.cnt?hmode="+mode+"&modName="+document.forms[0].strTempVal.value;
		     ajaxFunction(url,"1");
		    
		    }
		   else
		   {
		  
		    var objVal = document.getElementById("id1");
		    var objVal1 = document.getElementById("menu1");
		    objVal1.innerHTML =""; 
		    objVal.innerHTML ="";
		    objVal.style.display="none";
		   } 
	   	 }
		}
		 
		
     }

function getAjaxResponse(res,mode)
{
 		 if(mode=="1" || mode=="3" )
 		 {
		     var objVal = document.getElementById("id1");
		     
		     objVal.innerHTML = res; 
		     if(mode=="3")
		       document.forms[0].strCancelRmk.focus();
         }
         else if(mode == '2'){
   
			var objEle = document.getElementById("menu1");
			objEle.innerHTML = res;
			objEle.style.display="none";
			display_popup_menu(pWindow,"menu1","365","");
			
		}
		
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
     
     
     document.forms[0].strDrt.value= document.forms[0].strDisRsn[document.forms[0].strDisRsn.selectedIndex].text;
     document.forms[0].strDrt.disabled=true;
     }
}

function butdis()
{
 document.getElementById("save").disabled=true;

 if( document.forms[0].strCrNo.value!="")
 {
 
  document.forms[0].strCrNo.readOnly=true;
 }
 
 document.forms[0].strMsgString.value="";
}

function new_dis_add(obj)
{
alert("approval id and tariff id->"+obj.value);
document.forms[0].discount.value="";
 if(obj.checked)
 {
   document.forms[0].discount.readOnly=false;
   document.forms[0].discount.focus();
 }
  else
 {
  if(document.forms[0].discount.value=="")
   document.forms[0].discount.value="0";
  document.forms[0].discount.readOnly=true;
 }
 
}

function hlpOnLoad()
{           //  alert(document.forms[0].strCrNo.value);
             if(document.forms[0].strCrNo.value>0)
             {
            //  alert("block");
              document.getElementById("id1").style.display="block";
              alert(document.forms[0].strChk[0].value);
	          var mode="BId";
	 	      //i=document.forms[0].strChk_values.length;
		      var url="DiscountApprovalTransCNT.cnt?hmode="+mode+"&modName="+document.forms[0].strChk[0].value;
		      ajaxFunction(url,"1");
		      }
		      else
		      {
		     //   alert("none");
		        document.getElementById("id1").style.display="none";
		      }
}



var pWindow ="";
function myFunc(obj)
{
 pWindow = obj;
 //   alert("hi..");
			var mode = "PopUp"; 
			 var objVal1 = document.getElementById("menu1");
		     //objVal1.style.display="block";
		     
		   
		  
		     document.forms[0].strTempVal.value=document.forms[0].approval_id.value;
		    alert( document.forms[0].strTempVal.value);
		  
	        var url="DiscountApprovalTransCNT.cnt?hmode="+mode+"&modName="+document.forms[0].strTempVal.value+"&popUpId="+document.forms[0].strPopUp_id.value;
	    	
	    	 ajaxFunction(url,"2"); 
	    	
}

/*
function CRCancel()
{
 document.forms[0].strCrNo.value="";
 document.forms[0].hmode.value="CREnter";
 document.forms[0].submit();
}*/
