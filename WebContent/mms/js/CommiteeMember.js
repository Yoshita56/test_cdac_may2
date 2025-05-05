

function getReqType()
{ 
	 var url;
	 var mode = 'REQUESTTYPECOMBO';   
	
	 url="CommitteeMemberDetailMstCNT.cnt?hmode=REQUESTTYPECOMBO&CategoryNo="+document.forms[0].strCatNo.value;     
	 
	 ajaxFunction(url,"3");
}

function getEmpUserIdCmb(obj)
{ 
	document.forms[0].strMemberPhoneNo.value=obj.value.split("#")[2];
	document.forms[0].strMemberEMail.value=obj.value.split("#")[1];
	 var url;
	 var mode = 'EMPUSERIDCOMBO';   
	
	 url="CommitteeMemberDetailMstCNT.cnt?hmode="+mode+"&EmpNo="+document.forms[0].strEmpNumberCombo.value.split("#")[0];     
	 
	 ajaxFunction(url,"5");
}

function getCommType()
{ 
	 var url;
	 var mode = 'COMMTYPECOMBO';   
	
	 url="CommitteeMemberDetailMstCNT.cnt?hmode=COMMTYPECOMBO&ReqTypeId="+document.forms[0].strReqTypeId.value+"&CategoryNo="+document.forms[0].strCatNo.value;      
	 
	 ajaxFunction(url,"4");
}



function chkBox(obj,i)
{
 
}
function RadioButton(obj)
{
   var obj = document.forms[0].strCase;
   obj[0].checked = true;
}
function initPage()
{
	document.forms[0].hmode.value = "ADD";
	document.forms[0].submit();  
  
}
/**
 * Save Method for Commitee Member Details
*/
function validateInsert()
{
   
    var obj    = document.getElementsByName("strCheckBox"); 
    for(var i = 0 ; i < obj.length ; i++)
	{
	   if(obj[i].checked)
	   {
	        document.getElementById("strCheckBox"+i).value = 0+"$$"+document.forms[0].strCommitteType.value;
           	obj[i].checked = true;
	   }
	   else
	   {
	       document.getElementById("strCheckBox"+i).value = 1+"$$"+document.getElementById("flag"+i).value;
	       obj[i].checked = true;
          
	   }
	}
	if(document.forms[0].strPrevVal)
	{
	  if(document.forms[0].strPrevVal.value !="")
	  {  
	   var hisValidator = new HISValidator("committeeMemberDtlBean");
       hisValidator.clearAllValidations();
        //hisValidator.addValidation("strCatNo", "dontselect=0","Please Select Drug Category");
         hisValidator.addValidation("strReqTypeId", "dontselect=0","Please Select Request Type");
       hisValidator.addValidation("strCommitteType", "dontselect=0","Please Select Committee Type");
       var retVal = hisValidator.validate();     
 	   if(retVal)
	   {
				document.forms[0].hmode.value = "SAVE";
				document.forms[0].submit();
	   }
	   else
	   {
		   for(var i = 0 ; i < obj.length ; i++)
	       {
	             if(obj[i].checked)
	              {
	                 obj[i].checked = false;
	              }
	       }
		   retVal = false;
	   }
	 }
	 else
	 {
	   alert("Save Not allowed Please Add Some Value !!!!");
	   retVal = false;
	 }  	
	  		
	  		}  
 }


function getCombo(obj)
{
	for(var i = 0 ; i < obj.length ; i++)
	{
	  if(obj[i].checked)
	  {
			obj = obj[i];
			break;
	  }
		
	}
	if(obj.value == 1)
	{
	document.getElementById("Member").style.display = "none";
	document.getElementById("Emp").style.display = "block";
	document.getElementById("Emp1").style.display = "block";
	document.getElementById("Member1").style.display = "none";
	document.forms[0].strMemberName.value ="";
    document.forms[0].strMemberPhoneNo.value ="";
    document.forms[0].strMemberEMail.value="";	
	}
	 else 
	 if(obj.value == 2)
	 {
	
	  document.getElementById("Member").style.display = "block";
	  document.getElementById("Emp").style.display = "none";
	  document.getElementById("Emp1").style.display = "none";
	  document.getElementById("Member1").style.display = "block";
	  document.forms[0].strMemberName.value ="";
      document.forms[0].strMemberPhoneNo.value ="";
      document.forms[0].strMemberEMail.value="";
	
	 }
	
}
function getInitialPageInf()
{ 
   var mode="InitialAdd";
   var url="CommitteeMemberDetailMstCNT.cnt?hmode="+mode;
  
}
function showEmpUserIdCmb()
{
        if(document.getElementsByName("strIsChairPerson")[0].checked)
	   	{			
	   		      var lobj = document.getElementsByName("userIdFlg");
 	              var    j = 0;
 	             
			 	  if(lobj.length > 0)		
				  {
				  	for(var i = 0 ; i < lobj.length ; i++)
	                {
						if(lobj[i].value=="1")
						{
						  j++;
						}
	                }
				  }
				  if(j>"0")
				  {
						alert("Chair-Person Already Exists in Comittee \n Only Allow to Add Normal Member!!!");
						document.getElementsByName("strIsChairPerson")[0].checked = false;
						document.getElementById("chairPerson").style.display="none";
						return false;
				  }
				  else
				  {
				  	     document.getElementById("chairPerson").style.display="block";
				  }
	   	}
	   	else
	   	{
	   		document.getElementById("chairPerson").style.display="none";
	   	}
	   	
}

function saveMemberDtl()
{  
	var     element_memberDiv = document.getElementById('Member1');
	var     element_empDiv    = document.getElementById('Emp1');
	var  str_memberDivDisplay = element_memberDiv.style.display;
	var dropDown_committeType = document.getElementById("strCommitteType");
	
	if(dropDown_committeType.value=="0") 
	{
		alert("Select Committe Type.");
		return;
	}
	
	
    var hisValidator = new HISValidator("committeeMemberDtlBean");
    hisValidator.clearAllValidations();
    hisValidator.addValidation("strMemberEMail", "email","Plz Enter Valid Email ID");
     if(str_memberDivDisplay=='block')
     {
		// Non Emp Type
		hisValidator.addValidation("strMemberName", "req","Member name is mandatory.");
	 }
	 else 
	 {
		// Emp Type
		hisValidator.addValidation("strEmpNumberCombo", "dontselect=0","Please Select Employee.");
		if(document.getElementsByName("strIsChairPerson")[0].checked)
	   	{
		  hisValidator.addValidation("strEmpUserId", "dontselect=0","Please Select Chair Person User ID.");
	   	}  
	  }
     var retVal = hisValidator.validate();     
 	if(retVal)
	{  
	     var tempValD;
	     var mode ;
	     var empNo ;
	     var empUserId;
	     var empUserIdName;
	   
	     var commettieNo  ;
	     var obj = document.forms[0].strCase;
		    /*
		    if(obj[0].checked)
			{     				
		
						   
                       tempValD = document.forms[0].strEmpNumberCombo[document.forms[0].strEmpNumberCombo.selectedIndex].text;
					commettieNo = "0";
					  empUserId = "00000";
					      empNo = document.forms[0].strEmpNumberCombo.value+"^"+"0"+"^"+empUserId;
		                      
		     }
			 else
			 {
			 	      empUserId = "00000";
			              empNo = "0"+"^"+"0"+"^"+empUserId;
			        commettieNo = "0";
			           tempValD = document.forms[0].strMemberName.value;
		     }
		 */
		 
		    if(obj[0].checked)
			{      
				
				    if(!document.getElementsByName("strIsChairPerson")[0].checked)
	   	            {
						   
		                         tempValD = document.forms[0].strEmpNumberCombo[document.forms[0].strEmpNumberCombo.selectedIndex].text;
					          commettieNo = "0";
					            empUserId = "00000";
					                empNo = document.forms[0].strEmpNumberCombo.value.split("#")[0]+"^"+"0"+"^"+empUserId;
		                       
						
					}
					else
					{
						  
							    tempValD = document.forms[0].strEmpNumberCombo[document.forms[0].strEmpNumberCombo.selectedIndex].text;
					         commettieNo = "0";
					           empUserId = document.forms[0].strEmpUserId.value;
							       empNo = document.forms[0].strEmpNumberCombo.value.split("#")[0]+"^"+"1"+"^"+empUserId;
						    
					}
						
				  
		     }
			 else
			 {
			 	     // alert("3");
			 	      empUserId = "00000";
			              empNo = "0"+"^"+"0"+"^"+empUserId;
			        commettieNo = "0";
			           tempValD = document.forms[0].strMemberName.value;
		     }
		 
		  
	      var tempVal = tempValD +"^"+ document.forms[0].strMemberPhoneNo.value +"^"+document.forms[0].strMemberEMail.value+"^"+commettieNo+"^"+empNo;
	     
	     if(document.forms[0].strPrevVal)
	     {
			   if(document.forms[0].strPrevVal.value !="")
			   {
			   	  
			   	  document.getElementsByName("strIsChairPerson")[0].checked = false;
			   	  document.getElementById("chairPerson").style.display="none";
			      var temp =document.forms[0].strPrevVal.value+"@@"+tempVal;
			      
			      mode="UNITVAL2";
			      var url="CommitteeMemberDetailMstCNT.cnt?hmode="+mode+"&hlp="+temp;
			      ajaxFunction(url,"2");
			   }
			   else
			   {
			   	//alert("5");
			   	/*In Case To Add First Memeber in Committee*/
			   	 document.getElementsByName("strIsChairPerson")[0].checked = false;
			   	 document.getElementById("chairPerson").style.display="none";
			     var temp = "^^^"+"@@"+tempVal;
			     
			     mode="UNITVAL3";
			     
			     var url="CommitteeMemberDetailMstCNT.cnt?hmode="+mode+"&hlp="+temp;
			     ajaxFunction(url,"2");
			   }  
	   }
   
  }
  else
  {
    
  } 
  
}
function getCommittePurpose()
{
	var l_strCatNo = document.getElementById("strCatNo").value.trim();
	
	/*
	 The following code is commented by Aritra on 11th Jan, 2011
	 Reason: Change Request from Ajay Sir: "There should be provision to add members for a committee type without item category."
	 */
	/*
	if(l_strCatNo=="0") {
		alert("Select Item Category.");
		return;
	}
	*/
   var mode="UNITVAL1";
   var url="CommitteeMemberDetailMstCNT.cnt?hmode="+mode+"&modName="+document.forms[0].strCommitteType.value+"&catCode="+document.forms[0].strCatNo.value;
   ajaxFunction(url,"1");
      
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
       var objVal4 = document.getElementById("detailsdivid");
      
       // var objVal1 = document.getElementById("itemCat");
      //  var objVal2 = document.getElementById("processName");
        var objVal3 = document.getElementById("Purpose");
        
        
        
        var temp  = res.split("@@@");
       // var temp1 = temp[0].split("^");
     //   objVal1.innerHTML =temp1[0];
      //  objVal2.innerHTML =temp1[1];
        objVal3.innerHTML =temp[0];
        
        objVal4.innerHTML =temp[1];
        
     }
     if(mode=="2")
     {
        var temp = res.split("^");
        var objVal1 = document.getElementById("detailsdivid");
        objVal1.innerHTML =res;
        document.forms[0].strMemberName.value ="";
        document.forms[0].strMemberPhoneNo.value ="";
        document.forms[0].strMemberEMail.value="";
        document.forms[0].strEmpNumberCombo.value="0";
     }
     
     if(mode=="3")
     {
        objVal= document.getElementById("ReqTypeDiv");
				objVal.innerHTML = "<select name ='strReqTypeId' class='comboNormal' onchange='getCommType();' >" + res + "</select>";
     }
     
     if(mode=="4")
     {
       objVal= document.getElementById("CommitteTypeDiv");
				objVal.innerHTML = "<select name ='strCommitteType' class='comboNormal' onChange='getCommittePurpose();' >" + res + "</select>";
     }
     
     
     if(mode=="5")
     {
       objVal= document.getElementById("empUserIdCmb");
				objVal.innerHTML = "<select name ='strEmpUserId' class='comboNormal' onChange='' >" + res + "</select>";
				
     }
     
     
}
     


function cancelPage()
 {
     
	      document.forms[0].hmode.value = "CANCEL";
	      document.forms[0].submit();
  	  
 }

/////////////////function to display view page of tariff master
function showView(form1)
{
	with(form1)
		{ 
		    
			
			var countChk =0;
			   url = 'DrugSafetyAlertMstCNT.cnt?hmode=viewPage'+'&chk='+form1.chk.value;
				window.open(url,"popupWindow","width=610,height=450,scrollbars=yes");
			
				
		}
}






function callMe(form1)
{
	//alert("callme func is calling");
	var cmbVal = "";
	with(form1)
	{
	
	   add("ADD");
			 
	}
	
}
	
	function callMe2(form1)
{
	// alert("callme2 func is calling");
	var cmbVal = "";
	with(form1)
	{
	 edit("MODIFY");
			 
			
		
	}
	
}
function validate11()
{	
			  var retVal = validate11();   
		      if(retVal)
		      {
				document.forms[0].hmode.value = "SAVE";
				document.forms[0].submit();
			  }
			  else
			  {
			   alert("Your r Wrong");
			  }	
		   
}
function validate1()
 {
       var hisValidator = new HISValidator("committeeMemberDtlBean");  
 	   var retValue = false;
 	   hisValidator.clearAllValidations;
 	   hisValidator.addValidation("strCommitteType", "dontselect=0","Committe Type is a mandatory field");
 	   hisValidator.addValidation("strConstituteBy", "dontselect=0","Constitute By is a mandatory field");
 	   alert("Inside Validate 1");
       var retVal = hisValidator.validate();
       
       if(retVal)
       {  
         var retVal1 = validateAdd();           
          
 	     if(retVal1)
		      {
				document.forms[0].hmode.value = "SAVE";
				document.forms[0].submit();
			  }
			  else
			  {
			   alert("Your r Wrong");
			  }	
	  }		  
 }
 


function validateUpdate()
{
    var retValue = false;
         if(document.getElementsByName("strEmpNoUpdateMR")!='null')
         {
         
         //  var retValue1 = checkMultirow("strEmpNameUpdateMR","No Duplicate EmpName Required!!!");
         //  alert("retValue1--->"+retValue1);
           
           var chkEmpNoCombo    = document.getElementsByName("strEmpNoUpdateMRCombo");
           var chkEmpNoUpdate   = document.getElementsByName("strEmpNoUpdateMR");
         // alert("Length::::"+chkEmpNoUpdate.length);
 	       if(chkEmpNoUpdate.length > 1)
 	       {
 	        var strIsEmployee    = document.getElementsByName("strIsEmployeeUpdateMR"); 
 	        var chkEmpNameUpdate = document.getElementsByName("strEmpNameUpdateMR");
            var chkEmpAddr       = document.getElementsByName("strEmpAddrUpdateMR");
 	        var chkEmpPhone      = document.getElementsByName("strEmpPhoneUpdateMR");
 	        var chkEmpEmail      = document.getElementsByName("strEmpEmailUpdateMR");
 	      	for(var i = 0 ; i < chkEmpNoUpdate.length; i ++)
 	     	{
 	     	//alert("Combo Value::::"+chkEmpNameUpdate[i].value);
 	     	        strIsEmployee[i].disabled = false;
 	     	        chkEmpNoUpdate[i].disabled = false;
 	     	        chkEmpNameUpdate[i].disabled = false;
 	     	        chkEmpAddr[i].disabled = false;
 	     	        chkEmpPhone[i].disabled = false;
 	     	        chkEmpEmail[i].disabled = false;
 	     	         	     	       
 	     	         if(strIsEmployee[i].value == '1')
 	     	         {
 	     	          // alert("When Employee..!!!!");
 	     	          if(chkEmpNoCombo[i].value == 'null' || chkEmpNoCombo[i].value == '0' || chkEmpNoCombo[i].value == '' )
 	     			  {
 	     			    alert("Plz Enter Value in Emp No!!!"); 
 	     			     return false;
 	     			  }
 	     			  else
 	     			  {
 	     			    if(chkEmpNoCombo[i].value == chkEmpNoCombo[i+1].value || chkEmpNameUpdate[i].value == chkEmpNameUpdate[i+1].value)
 	     			    {
 	     			     alert("Duplicate Value Not Allowed!!!!!!");
 	     			     return false;
 	     			    }
 	     			    else
 	     			    {
 	     			      //alert("Sab Thik hai!!!");
 	     			      return true;
 	     			    } 
 	     			  } 	     	        
 	     	           
 	     	        }      
 	     	        else
 	     	        {
 	     	         if(chkEmpNoUpdate[i].value == 'null' || chkEmpNoUpdate[i].value == '0' || chkEmpNoUpdate[i].value == '' )
 	     	   		 {
 	     			  alert("Plz Enter Value in Emp No!!!"); 
 	     			  return false;
 	     			 }
 	     			 else
 	     			 {
 	     			    if(chkEmpNoUpdate[i].value == chkEmpNoUpdate[i+1].value || chkEmpNameUpdate[i].value == chkEmpNameUpdate[i+1].value)
 	     			    {
 	     			     alert("Duplicate Value Not Allowed!!!!!!");
 	     			     return false;
 	     			    }
 	     			    else
 	     			    {
 	     			     //alert("Sab Thik hai!!!");
 	     			     return true;
 	     			    } 
 	     			  }
 	     		    }
 	     		    
 	        }
 	      }
 	      else
 	      {
 	        var strIsEmployee    = document.getElementsByName("strIsEmployeeUpdate"); 
 	        var chkEmpNameUpdate = document.getElementsByName("strEmpNameUpdate");
            var chkEmpAddr       = document.getElementsByName("strEmpAddrUpdate");
 	        var chkEmpPhone      = document.getElementsByName("strEmpPhoneUpdate");
 	        var chkEmpEmail      = document.getElementsByName("strEmpEmailUpdate");
 	        for(var i = 0 ; i < chkEmpNameUpdate.length; i ++)
 	     	{
 	                if(chkEmpNameUpdate[i].value == 'null' ||  chkEmpNameUpdate[i].value == '' )
 	     			  {
 	     			     alert("Plz Enter Emp Name!!!"); 
 	     			     return false;
 	     			  }
 	     			  else
 	     			  {
 	     			    return true;
 	     			  }
 	        }
 	      }
 	     }  
 }


/*
Description: This function undone the changes made by getCommittePurpose().
Author: Aritra
Date: 15th June, 2010
*/
function resetCommittePurpose() {
    var element_errMsg = document.getElementById("errMsg");
	var element_detailsDiv = document.getElementById("detailsdivid");
	var element_purpose = document.getElementById("Purpose");
	var dropDown_committeType= document.getElementById("strCommitteType");
	
	element_errMsg.innerHTML="";
	element_detailsDiv.innerHTML="";
	element_purpose.innerHTML="----";
	dropDown_committeType.value="0";
}