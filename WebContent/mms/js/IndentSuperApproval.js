/** This is the validate function for Breakage Item Details jsp file
 *  i.e:- add_BreakageItemDtlTrans_mms.jsp and 
 *  transfer control to the controller 'INSERT' method.  
 */
 
function validate1()
{
	
   setApprovedQty();
  if(document.forms[0].strReqTypeId.value!='47')
  {
  	var saveObj = document.getElementById("saveId");
	
	if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	{
		saveObj.style.display = "none"; 
		
	  var hisValidator = new HISValidator("indentSuperApprovalTransBean"); 
      var ReqTypeId = document.forms[0].strReqTypeId.value; 
      retVal= setRemarks();
      if(retVal){
		  hisValidator.addValidation("strRemarks","req","Remarks is Mandatory" );
		  saveObj.style.display = "block";
		  hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
		  var retVal = hisValidator.validate(); 
		  
		  var itemParVal  = document.getElementsByName("strInsertHiddenValue");
	      var unitNameCmb = document.getElementsByName("strInsUnitCombo");
	      var reqQty      = document.getElementsByName("strInsSancQty");
	     // var AvlQty      = document.getElementsByName("strInHandQty");
	      var count = parseInt("0");
	       
	      if(retVal)
	      {  
	        for(var x=0;x<itemParVal.length;x++)
	        {
	          
	          hisValidator.addValidation("strInsSancQty","req","Required Quantity is a Mandatory Field" );
	          if(document.getElementsByName("strApproved")[0].checked)
		      	hisValidator.addValidation("strInsUnitCombo","dontselect=0","Please select a value from Unit Name Combo" );
		      var retVal1 = hisValidator.validate(); 
	          if(retVal1)
	          {
	                   count = count +1;
	                         
	          } 
	          else
		       {
		          count = 0;
		          saveObj.style.display = '';
			      return false;
	           }  
	           
	        }
	        if(count >0)
	        {
	            if(ReqTypeId == 17)
	            {  
	              var chkObj  = document.getElementsByName("strIssueFrmReservStock");
	              
	              for(var i=0; i<chkObj.length; i++) 
	              {
	                 if(chkObj[i].checked)
	                 {
	   	               chkObj[i].value = 1;
	   	               chkObj[i].checked = true;
	   	              
	   	             }
	   	             else
	   	             {
	   	               chkObj[i].value = 0;
	   	               chkObj[i].checked = true;
	   	             
	                 } 
	              }
	            }
	          
	              var conf = confirm("You Are Going To Save Records");
                  if(conf == true)
                  {
                       var conf1 = confirm("Are you sure !!!");
                       if(conf1 == true)
                       {
 						    document.forms[0].hmode.value = "INSERT";
						    document.forms[0].submit();
                       }
                      else
                       {
                       	saveObj.style.display = '';
                         return false;
                       }
                   }
                  else
                   {
                   		saveObj.style.display = '';
                         return false;
                   }    
	          
	            
	            
	          
	       
	            
	        
	      }
	      else
		  {
		  	saveObj.style.display = '';
			  return false;
	      } 
	   } 
     } 
	}
    else
  	{
  	    saveObj.style.display = '';
		return false;
  	}
  }
  else
  {
   
   var saveObj = document.getElementById("saveId");
	
	if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	{
		saveObj.style.display = "none"; 
		
      var hisValidator = new HISValidator("indentSuperApprovalTransBean"); 
      
      
      
      	 hisValidator.addValidation("strRemarks","req","Remarks is Mandatory" );
	  	hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	 	 hisValidator.addValidation("strReturnTypeCmb","dontselect=0","Please select a value from Return Type Combo" );
	 	 hisValidator.addValidation("strDeliveryDate","req","Deleivery Date is a Mandatory Field" );
	 	 var retVal = hisValidator.validate(); 
	 	 if(retVal)
     	 {  
          	 document.forms[0].hmode.value="INSERT";
	      	 document.forms[0].submit();
             
     	 }
     	 else
     	 {
     	 	saveObj.style.display = '';
		  	return false;
      	} 
  	}
  	else
	{
  	    saveObj.style.display = '';
		return false;
  	} 
  }
  
} 

/** 
 *  transfer control to the controller 'INSERT' method.  
 */
 
function validate2()
{
      var hisValidator = new HISValidator("indentSuperApprovalTransBean"); 
     
	  hisValidator.addValidation("strRemarks","req","Remrks is Mandatory" );
	  hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	 // hisValidator.addValidation("strReturnTypeCmb","dontselect=0","Please select a value from Return Type Combo" );
	  var retVal = hisValidator.validate(); 
	  if(retVal)
      {  
            var conf = confirm("You Are Going To Save Records" );
							                       if(confirm(" Are You Sure ?"))
												   {
														document.forms[0].hmode.value = "INSERT";
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

/****************** Calling Ajax Function ********************/
function getReport1() 
{    
	//alert('1');
   var strChk         = document.forms[0].strChk.value;
   var strReqTypeId   = document.forms[0].strReqTypeId.value;
	 
   var mode="APPROVALPRINT";
   var url="IndentSuperApprovalTransCNT.cnt?hmode="+mode+"&strChk="+ strChk+"&strReqTypeId="+strReqTypeId;
   ajaxFunction(url,"2");
	 
}

function callingAjaxPoPUp(parent,i,strRasingReceving,strHiddenValue)
{
   var mode ="BLOCKEDITEMDTL";
   var url="IndentSuperApprovalTransCNT.cnt?hmode="+mode+"&param="+strHiddenValue+"&RasingReceving="+strRasingReceving;
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
            var objVal= document.getElementById("issueDtlId");
			objVal.innerHTML = res;
			CalculateBlockedQty();
			display_popup_menu(parent,"issueDtlId",'240','220');   
       }
       if(mode=="11")
     {
        var objVal1 = document.getElementById("paginationNonDisId");
        objVal1.innerHTML = res;
     }
     
	  if(mode=="13")
     {			
			
		document.getElementById("batchWiseId").innerHTML=res;
		display_popup_menu(obj,'batchWiseId','300','');
		
	 }
	 if (mode == "2") 
	 {	//alert('res'+res);
			var itemStockObj = document.getElementById("issueDtlsDivId");
			itemStockObj.innerHTML = res;
			
			popup('popUpDiv', '60', '80');	
			
	 }
       
       
}	

/*************************************************************/
/*
function ChangeDiv()
{
  if(document.forms[0].strReturnTypeCmb.value==1)
  {
     document.getElementById("DeliveryDate").style.display="block";
  }
  else
  {
     document.getElementById("DeliveryDate").style.display="none";
  }
  
}
*/
function CalculateBlockedQty()
{
    var objDisUnit=document.getElementsByName("strBlockedQtyAdd");
	var s=0;
	for(var j=0;j<objDisUnit.length;j++)
	{
		s=parseFloat(s)+parseFloat(objDisUnit[j].value);
	}
	if(s=='0')
	{
	  document.getElementById("BlockQtyDiv").innerHTML = "----";
	}
	else
	{
	  document.getElementById("BlockQtyDiv").innerHTML = s;
	}
}
  
function OnLoadCheck()
{
  //CalculateBlockedQty();
 // alert("Req ID-->>"+document.forms[0].strReqTypeId.value+"<--Level Type--->"+document.forms[0].strLevelType.value);
  if(document.forms[0].strReqTypeId.value == '16')
  {
   
     if(document.forms[0].strLevelType.value == '2')
     {
       document.getElementById("Raising").style.display="none";
       document.getElementById("Receving").style.display="block";
       document.getElementById("CommitteTypeComboDiv").style.display="block";
     }
     else
     {
       document.getElementById("Raising").style.display="block";
       document.getElementById("Receving").style.display="none";
       document.getElementById("CommitteTypeComboDiv").style.display="none";
     }
    var chkObj  = document.getElementsByName("strIssueFrmReservStock");
    for(var i=0; i<chkObj.length; i++) 
    {
      if(chkObj[i].value == 1)
      {
   	    chkObj[i].checked = true;
   	  }
   	  else
   	  {
   	    chkObj[i].checked = false;
      } 
    }
  }
  else
  {
    if(document.forms[0].strReqTypeId.value == '47')
    {
     
     document.getElementById("Request47").style.display="block";
             
     if(document.forms[0].strReturnFlag.value=='1' || document.forms[0].strReturnFlag.value=='2')
     {
        document.getElementById("ReturnTypeComboDiv").innerHTML = "<select name='strReturnTypeCmb' class='comboNormal' onchange='ChangeDiv();' ><option value='0'>Select Value</option><option value='1'>Replacement</option><option value='2'>Return</option></select>";
     }
     else
     {
        document.getElementById("ReturnTypeComboDiv").innerHTML ="<select name='strReturnTypeCmb' class='comboNormal' onchange='ChangeDiv();' ><option value='0'>Select Value</option><option value='2'>Return</option></select>"; 
     }
     document.forms[0].strReturnTypeCmb.value=document.forms[0].strReturnFlag.value;     
    }
    
  }   	 	
 
}
function FuncTick(obj)
{
  if(obj.value == '1')
  {
    document.forms[0].strApproved.checked = true;
    document.forms[0].strRejected.checked = false;
  }
  else
  {
     document.forms[0].strRejected.checked = true;
     document.forms[0].strApproved.checked = false;
  }
  
}
function callingPoPUpReceiveThirdParty(paretnt,i,strExpDate,strItemMake,strRateUnit)
{
        var objVal1 = document.getElementById("100");
        
        if(strExpDate!='null')
        {
         
          objVal1.innerHTML = strExpDate; 
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
        var objVal2 = document.getElementById("101");
        
        if(strItemMake!='null')
        {
         
          objVal2.innerHTML = strItemMake; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        
        var objVal2 = document.getElementById("102");
        
        if(strRateUnit!='null')
        {
         
          objVal2.innerHTML = strRateUnit; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
             
        display_popup_menu(parent,'ReceiveFrmThirdParty','200','');
}
function callingPoPUp(parent,i,strHiddenValue,reqTypeId)
{
  if(reqTypeId == 17)
  {
    issueDtlPoPUp(parent,i,strHiddenValue);
  }
  
  if(reqTypeId == 65)
  {
    issueToThirdPartyPoPUp(parent,i,strHiddenValue);
  }
  
  if(reqTypeId == 61)
  {
    AgendaPoPUp(parent,i,strHiddenValue);
  }
  
  
  if(reqTypeId == 47)
  {
    ReturnPoPUp(parent,i,strHiddenValue);
  }
  
  if(reqTypeId == 18)
  {
    ReturnRequest(parent,i,strHiddenValue);
  }
  
  if(reqTypeId == 11 || reqTypeId == 83 || reqTypeId == 82 || reqTypeId == 81 || reqTypeId == 80 || reqTypeId == 84 || reqTypeId == 85)
  {
    AnnualPopUp(parent,i,strHiddenValue);
  }
  if(reqTypeId == 12 || reqTypeId == 13)
  {
    LpPatientStaff(parent,i,strHiddenValue);
  }
  if(reqTypeId == 14 || reqTypeId == 10 )
  {
    LpDept(parent,i,strHiddenValue);
  }
  if(reqTypeId == 16)
  {
    IndentCondemnation(parent,i,strHiddenValue);
  }
  if(reqTypeId == 19)
  {
    IndentCondemnation(parent,i,strHiddenValue);
  }
  if(reqTypeId == 15)
  {
    IndentForImported(parent,i,strHiddenValue);
  }
}
function ReturnPoPUp(parent,i,strHiddenValue)
{
        myArray = strHiddenValue.split("^");
       
        var objVal1 = document.getElementById("35");
        if(myArray[0]!='null' ||myArray[0]!='')
        {
         
          objVal1.innerHTML = myArray[0];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("36");
        
        if(myArray[1]!='null')
        {
         
          objVal2.innerHTML = myArray[1]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        var objVal3 = document.getElementById("37");
        
        if(myArray[2]!= 'null')
        {
         
          objVal3.innerHTML = myArray[2];  
        }
        else
        {
          objVal3.innerHTML = "----";
        } 
   display_popup_menu(parent,'Return','210','');

}
function AgendaPoPUp(parent,i,strHiddenValue)
{    
        myArray = strHiddenValue.split("^");
       
        var objVal1 = document.getElementById("30");
        if(myArray[0]!='null' ||myArray[0]!='')
        {
         
          objVal1.innerHTML = myArray[0];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("31");
        
        if(myArray[1]!='null')
        {
         
          objVal2.innerHTML = myArray[1]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        var objVal3 = document.getElementById("32");
        
        if(myArray[2]!= 'null')
        {
         
          objVal3.innerHTML = myArray[2];  
        }
        else
        {
          objVal3.innerHTML = "----";
        } 
        
        
        var objVal4 = document.getElementById("33");
        
        if(myArray[3]!= 'null')
        {
          
          objVal4.innerHTML = myArray[3];  
        }
        else
        {
          objVal4.innerHTML = "----";
        } 
        
        var objVal5 = document.getElementById("34");
        
        if(myArray[4]!= 'null')
        {
          
          objVal5.innerHTML = myArray[4];  
        }
        else
        {
          objVal4.innerHTML = "----";
        } 
        
               
        display_popup_menu(parent,'Agenda','210','');
	}





function issueToThirdPartyPoPUp(parent,i,strHiddenValue)
{    
        myArray = strHiddenValue.split("^");
       //strHiddenValue   = strRate +"^"+strExpDate+"^"+strBatchNo+"^"+strItemId+"^"+strItemBrandId;
        var objVal1 = document.getElementById("28");
        
        if(myArray[0]!='null')
        {
         
          objVal1.innerHTML = myArray[0]; 
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
        var objVal2 = document.getElementById("29");
        
        if(myArray[1]!='null')
        {
         
          objVal2.innerHTML = myArray[1]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
             
        display_popup_menu(parent,'issueToThirdParty','200','');
}





function issueDtlPoPUp(parent,i,strHiddenValue)
{    
        myArray = strHiddenValue.split("^");
                   
        var objVal2 = document.getElementById("2");
        
        if(myArray[1]!='null')
        {
         
          objVal2.innerHTML = myArray[1]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        var objVal3 = document.getElementById("3");
        
        if(myArray[2]!= 'null')
        {
         
          objVal3.innerHTML = myArray[2];  
        }
        else
        {
          objVal3.innerHTML = "----";
        } 
        
        
        var objVal4 = document.getElementById("4");
        
        if(myArray[3]!= 'null')
        {
          
          objVal4.innerHTML = myArray[3];  
        }
        else
        {
          objVal4.innerHTML = "----";
        } 
        display_popup_menu(parent,'issueDtl','200','');
	}

function cancelToDesk()
{
  var mode="CANCEL";
 
  document.forms[0].hmode.value=mode;
  document.forms[0].submit();
}
function hideItemDetails(divId)
{
      hide_popup_menu(divId);
}

function ftn11(obj)
{     
   if(document.forms[0].button1.value != 1 )
   {
    document.getElementById("LastApprovalDtl").style.display="block";
    document.getElementById("minus1").style.display="block";
    document.getElementById("plus1").style.display="none";
    document.forms[0].button1.value = 1;
   }
   else
   {
    document.getElementById("minus1").style.display="none";
    document.getElementById("plus1").style.display="block";
    document.getElementById("LastApprovalDtl").style.display="none";
    document.forms[0].button1.value = 0;
   } 
}
function ftn22(obj)
{     
   if(document.forms[0].button1.value != 1 )
   {
    document.getElementById("NonDiscrepancyRpt").style.display="block";
    document.getElementById("minus2").style.display="block";
    document.getElementById("plus2").style.display="none";
    document.forms[0].button1.value = 1;
   }
   else
   {
    document.getElementById("minus2").style.display="none";
    document.getElementById("plus2").style.display="block";
    document.getElementById("NonDiscrepancyRpt").style.display="none";
    document.forms[0].button1.value = 0;
   } 
}
function ftn33(obj)
{     
   if(document.forms[0].button1.value != 1 )
   {
    document.getElementById("DiscrepancyRpt").style.display="block";
    document.getElementById("minus3").style.display="block";
    document.getElementById("plus3").style.display="none";
    document.forms[0].button1.value = 1;
   }
   else
   {
    document.getElementById("minus3").style.display="none";
    document.getElementById("plus3").style.display="block";
    document.getElementById("DiscrepancyRpt").style.display="none";
    document.forms[0].button1.value = 0;
   } 
}

function chkUserDefinedFunc(these)
{
    var checkCount=0;
	var check=document.getElementsByName("chk");
	for(i=0;i<check.length;i++)
	{
		if(check[i].checked==true)
		{
			checkCount++;
		}			
	}
	try
	{   
		if(checkCount=='1')
		{			
		    if(document.getElementById("comboid1").value =="0")
		    {
		       enableButton("Approval");
		       enableButton("View"); 
		       disableButton("Certificate");
		    }
		    else
		    {
		       	if(document.getElementById("comboid1").value =="1")
			    {
			         disableButton("Approval");
					 enableButton("View"); 
			         disableButton("Certificate");
			  	}	
			  	else
				{
				       disableButton("Approval");
				       enableButton("View"); 
				       disableButton("Certificate");
				}
		       	
		    }
		    if(checkCount=='1' &&  document.getElementsByName("combo")[0].value=="19")
			{
					
					enableButton("Certificate");
			}
			else
			{
				disableButton("Certificate");
			}
		     
		} 
		else
		{
					
					   disableButton("Approval");
				       disableButton("View"); 
				       disableButton("Certificate");
		}
		
		
	}
	catch(Err)
	{
		alert(Err);
	}
}

function buttonLogicsOnClick1(modeNo, mode , display)
{
 if(modeNo != 7)
  {
		     var chkObj = document.getElementsByName("chk");
   	 
   			 var count = parseInt("0");
   	 
   	 		 for(var i=0; i<chkObj.length; i++) 
   	 		 {
   	 			if(chkObj[i].checked)
   	 			{
   	 				count = count + 1;
   	 		    }		
   	 		
   	 		 }
   	 	   	  add(mode); 			
	}
	else
	{
			 //add(mode);
    }
}

function buttonLogicsOnClick2(modeNo, mode , display)
{
 if(modeNo != 7)
 {
		   
						
    		 var chkObj = document.getElementsByName("chk");
   	 
   			 var count = parseInt("0");
   	 
   	 		 for(var i=0; i<chkObj.length; i++) 
   	 		 {
   	 			if(chkObj[i].checked)
   	 			{
   	 				count = count + 1;
   	 		    }		
   	 		
   	 		 }
   	 	   	  add(mode); 			
  }
  else
  {
			 //add(mode);
  }
}

function IndentForImported(parent,i,strHiddenValue)
{
 // strLstPoNo+"^"+
 // strLstPODate+"^"+
 // strLstRecDate+"^"+
 // strLstSupplBy+"^"+
 // strGrpName+"^"+
 // strSubGrpName;
        myArray = strHiddenValue.split("^");
         
        var objVal1 = document.getElementById("24");
        if(myArray[0]!='null' ||myArray[0]!='')
        {
         
          objVal1.innerHTML = myArray[0];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("25");
        
        if(myArray[1]!='null')
        {
         
          objVal2.innerHTML = myArray[1]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        var objVal3 = document.getElementById("26");
        
        if(myArray[2]!= 'null')
        {
         
          objVal3.innerHTML = myArray[2];  
        }
        else
        {
          objVal3.innerHTML = "----";
        } 
        
        
        var objVal4 = document.getElementById("27");
        
        if(myArray[3]!= 'null')
        {
          
          objVal4.innerHTML = myArray[3];  
        }
        else
        {
          objVal4.innerHTML = "----";
        } 


 display_popup_menu(parent,'IndentForImported','200','');
}

function ReturnRequest(parent,i,strHiddenValue)
{
        myArray = strHiddenValue.split("^");
  //   strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strGrpName+"^"+strSubGrpName+"^"+strExpDate;
         
        var objVal1 = document.getElementById("21");
        if(myArray[0]!='null' ||myArray[0]!='')
        {
         
          objVal1.innerHTML = myArray[0];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("22");
        
        if(myArray[1]!='null')
        {
         
          objVal2.innerHTML = myArray[1]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        var objVal3 = document.getElementById("23");
        
        if(myArray[5]!= 'null'|| myArray[5]!='')
        {
         
          objVal3.innerHTML = myArray[5];  
        }
        else
        {
          objVal3.innerHTML = "----";
        } 
        display_popup_menu(parent,'ReturnRequest','200','');
}




function IndentCondemnation(parent,i,strHiddenValue)
{
     myArray = strHiddenValue.split("^");
    //strLstPoNo+"^"+strLstPODate+"^"+strLstRecDate+"^"+strExpDate+"^"+strLstSupplBy+"^"+strGrpName+"^"+strSubGrpName;       
     
       
        var objVal1 = document.getElementById("17");
        if(myArray[0]!='null' ||myArray[0]!='')
        {
         
          objVal1.innerHTML = myArray[0];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("18");
        
        if(myArray[1]!='null')
        {
         
          objVal2.innerHTML = myArray[1]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        var objVal3 = document.getElementById("19");
        
        if(myArray[3]!= 'null')
        {
         
          objVal3.innerHTML = myArray[3];  
        }
        else
        {
          objVal3.innerHTML = "----";
        } 
        
        
        var objVal4 = document.getElementById("20");
        
        if(myArray[4]!= 'null')
        {
          
          objVal4.innerHTML = myArray[4];  
        }
        else
        {
          objVal4.innerHTML = "----";
        } 
        display_popup_menu(parent,'IndentCondemnation','200','');



}
function LpDept(parent,i,strHiddenValue)
{
   myArray = strHiddenValue.split("^");
            
        //strIssueQty+"^"+strLstRecevQty+"^"+strLstRecevDate+"^"+strLstRetQtyUnitId;
        var objVal1 = document.getElementById("14");
        if(myArray[0]!='null' ||myArray[0]!='')
        {
         
          objVal1.innerHTML = myArray[0];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("15");
        
        if(myArray[1]!='null')
        {
         
          objVal2.innerHTML = myArray[1]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        
        var objVal3 = document.getElementById("16");
        
        if(myArray[2]!='null')
        {
         
          objVal3.innerHTML = myArray[2]; 
        }
        else
        {
          objVal3.innerHTML = "  ----";
        }  
        
        
        display_popup_menu(parent,'LpDept','200','');

}


function LpPatientStaff(parent,i,strHiddenValue)
{
   myArray = strHiddenValue.split("^");
            
        
        var objVal1 = document.getElementById("12");
        if(myArray[0]!='null' ||myArray[0]!='')
        {
         
          objVal1.innerHTML = myArray[0];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("13");
        
        if(myArray[1]!='null')
        {
         
          objVal2.innerHTML = myArray[1]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        
        display_popup_menu(parent,'LpPatStaff','200','');

}


function AnnualPopUp(parent,i,strHiddenValue)
{    
        myArray = strHiddenValue.split("^");
//0strLstPoNo+"^"+1strLstPODate+"^"+2strLstRecDate+"^"+3strLstSupplBy+"^"+4strLstYerConsump+"^"+5strReOrderLevel+"^"+6strLstRecQty;        
                  
        
        
        var objVal1 = document.getElementById("5");
        if(myArray[5]!='null' ||myArray[5]!='')
        {
         
          objVal1.innerHTML = myArray[5];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("6");
        
        if(myArray[4]!='null')
        {
         
          objVal2.innerHTML = myArray[4]; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        var objVal3 = document.getElementById("7");
        
        if(myArray[4]!= 'null')
        {
         
          objVal3.innerHTML = myArray[0];  
        }
        else
        {
          objVal3.innerHTML = "----";
        } 
        
        
        var objVal4 = document.getElementById("8");
        
        if(myArray[1]!= 'null')
        {
          
          objVal4.innerHTML = myArray[1];  
        }
        else
        {
          objVal4.innerHTML = "----";
        } 
        
        var objVal5 = document.getElementById("9");
        
        if(myArray[6]!= 'null')
        {
          
          objVal5.innerHTML = myArray[6];  
        }
        else
        {
          objVal4.innerHTML = "----";
        } 
        
        var objVal6 = document.getElementById("10");
        
        if(myArray[2]!= 'null')
        {
          
          objVal6.innerHTML = myArray[2];  
        }
        else
        {
          objVal6.innerHTML = "----";
        } 
        
        var objVal7 = document.getElementById("11");
        
        if(myArray[3]!= 'null')
        {
          
          objVal7.innerHTML = myArray[3];  
        }
        else
        {
          objVal7.innerHTML = "----";
        } 
        
        
        display_popup_menu(parent,'AnnualPurchase','210','');
	}


function buttonLogicsOnChangeCombos()
	{
	   
	   
	   
	   
	}
	
	//////////////////////////////////////GLOBAL HLP ANU///////////////////////////////////////////////////////////

function GetIndex(index,endVal){
   
       for(var i = 1; i <= endVal ; i++)
	  {
	 
	    document.getElementById("DivId"+i).style.display="none";
	  }
		
		  document.getElementById("DivId"+index).style.display="block";
		 
}
function fetchDiscrepancyReport(){
	
  
   if(document.forms[0].strGroupId.value!="0"){
	   var mode="NONDISCREPANCYREPORT"
	   var url="IndentSuperApprovalTransCNT.cnt?hmode="+mode+"&storeId="+document.forms[0].strStoreId.value+"&stockNo="+document.forms[0].strStockNo.value+
	   "&groupId="+document.forms[0].strGroupId.value;
	   ajaxFunction(url,"11"); 
	}else{
		alert('Please Select Group Combo');
		document.forms[0].strGroupId.focus();
	}
	

}
var obj=""
 function openBatchwiseDtl(objStr,objVal,index)
 {
 var strId="";
 var strStockNo="";
 var strItemId="";
 var strItemBrandId="";
 var myArray=document.getElementById(objStr+index).value.split("@");
 var mode="BATCHWISEDTL";
 strId=myArray[0];
 strStockNo=myArray[1];
 strItemId=myArray[2];
 strItemBrandId=myArray[3];
 obj=objVal;
 
  var url="IndentSuperApprovalTransCNT.cnt?hmode="+mode+"&strId="+strId+"&stockNo="+strStockNo+"&itemId="+strItemId+"&itemBrandId="+strItemBrandId;
  ajaxFunction(url,"13");

 
 }

function openSpecification(obj1,obj,index)
{
	   
       
        
        var strItemDetail = document.getElementById(obj1+index).value;     
      
       
        myArray = strItemDetail.split("@");
        
        document.getElementById("popUpItemId").innerHTML="Item Details-"+myArray[0];
        //alert("myArray--size"+myArray.length);
       
        var objVal1 = document.getElementById("1");
       
        if(myArray[0]!='null' || myArray[0]!='')
        {
          objVal1.innerHTML = myArray[1];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("2");
        
        if(myArray[1]!='null')
        {
          objVal2.innerHTML = myArray[2];
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        
          objVal2 = document.getElementById("3");
        
        if(myArray[1]!='null')
        {
          objVal2.innerHTML = myArray[3];
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        display_popup_menu(obj,'itemDtlId','300','');
        	
	
}

function closeItemPopUp(divId)
{
 	hide_popup_menu(divId);
}



 function view1(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="none";
	document.getElementById(obj2).style.display="block";
	document.getElementById(obj3).style.display="block";
}
function view2(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="block";
	document.getElementById(obj2).style.display="none";
	document.getElementById(obj3).style.display="none";
}

 
 function openDivPopu()
{
		if(document.getElementsByName("strCommitteeTypeId")[0].value=="0")
   	 	{
   	 		alert("Please Select Committee Type")
   	 	}
 	 	else{
  			 popup('memberDtl' , '130','250');
  		}
}
function closePopUpDiv()
{
	hide_popup('memberDtl');
}
function clearData()
{
	var size=document.getElementsByName("strMemberRecommendation").length;
	if(size>1){
		for(var i=0;i<size;i++){
			document.getElementsByName("strMemberRecommendation")[i].value="";
		}
	}
	else{
		document.getElementsByName("strMemberRecommendation")[0].value="";
	}
	hide_popup('memberDtl');
}

function openDivItem(obj,index)
{	
	var lengthItem=document.getElementsByName("strMultiRow")[0].value;
	for(var i=0;i<parseInt(lengthItem);i++)
	{
		document.getElementById("remarksId"+i).style.display="none";
	}
	display_popup_menu(obj,"remarksId"+index,'200','');
}
function closeDivItem(index){
	document.getElementById("remarksId"+index).style.display="none";
	//flag=false;
}
/*
 * This function is used to check whether requested Qty equal to Sanction Qty
 */
function setRemarks(){
	
	var saveObj = document.getElementById("saveId");
	
	var objReqQtyVal=document.getElementsByName("strReqQty");
	var objSancQtyVal=document.getElementsByName("strInsSancQty");
	var objUnitCombo=document.getElementsByName("strInsUnitCombo");
	var temp1,temp2;
	var rejectMode = document.forms[0].strRejected.checked;
	if(rejectMode) {
		var manualRemarksEntryMode = "UNKNOWN";
		var remarksText=null;
		for(var i=0;i<objReqQtyVal.length;i++){
			//alert("i="+i+" Remarks="+document.getElementsByName("strItemRemarks")[i].value);
			if(document.getElementsByName("strItemRemarks")[i].value==''){
			   if(manualRemarksEntryMode == "UNKNOWN") {
			   		remarksText = prompt("Common remarks for all items to be rejected.");
					if(remarksText == null) {
						manualRemarksEntryMode='ON';
						alert("Please enter rejection remarks for each item.");
						saveObj.style.display = "block";
						return false;
					} else {
						manualRemarksEntryMode='OFF';
						
					}
			   }
			   if(manualRemarksEntryMode=='OFF') {
			   		if(remarksText==null) {
			   			saveObj.style.display = "block";
			   			alert("Null value!!!");
			   		}
			   		//alert("i="+i+" remarksText="+remarksText);
			   		document.getElementsByName("strItemRemarks")[i].value=remarksText;
			   }		
			}			
		}
	} else {
	
		for(var i=0;i<objReqQtyVal.length;i++){
			var temp;
			temp=objUnitCombo[i].value.split("^");
			temp1=parseFloat(objReqQtyVal[i].value);
			temp2=parseFloat(objSancQtyVal[i].value*temp[1]);
			if(temp1!=temp2){
				/*if(document.getElementsByName("strItemRemarks")[i].value==''){
					display_popup_menu(objUnitCombo,"remarksId"+i,'400','220');
					document.getElementById("remarksLabelId"+i).innerHTML="<font color='red'>*</font>Remarks";
					document.getElementsByName("strItemRemarks")[i].focus();
					alert("Remarks for this Item is Mandatory Field");
					saveObj.style.display = "block";
					saveObj.setAttribute("align", "center");
					return false;
				}*/
				if(!confirm("Approved qty "+document.getElementsByName("strInsSancQty")[i].value+" is not same as Requested Qty "+temp1+" , Are you sure want to continue ?"))
				{
						document.getElementsByName("strInsSancQty")[i].focus();
						saveObj.style.display = "block";
						saveObj.setAttribute("align", "center");
						return false;
				}
				else
					 return true;
			
			}else{
				continue;
			}
		}
	}
	return true;
}

function setApprovedQty(){
	var approvedQty=document.getElementsByName("strInsSancQty");
	var approvedQtyUnit=document.getElementsByName("strInsUnitCombo");
	if(document.getElementsByName("strRejected")[0].checked){
		for(var i=0;i<approvedQty.length;i++){
			approvedQty[i].value="0";
			//approvedQtyUnit[i].value="0";
		}
		
	}
}

function certificateOpen(){
	
	document.forms[0].hmode.value="CERTIFICATE";
	document.forms[0].submit();
}

	/////////////////////////////////////GLOBAL HLP EMD ////////////////////////////////////////////