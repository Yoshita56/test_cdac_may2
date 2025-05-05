/** This is the validate function for Breakage Item Details jsp file
 *  i.e:- add_BreakageItemDtlTrans_mms.jsp and 
 *  transfer control to the controller 'INSERT' method.  
 */
 
  function validate1()
 {
	 // alert(document.getElementsByName("strPtType")[0].value);
	  //alert(document.getElementsByName("strPatientDtlHidVal")[0].value.split("^")[11]);
	// alert(document.getElementsByName("strBSReqNo")[0].value);
	 // return false;
	  
	 // alert(document.forms[0].strToStoreCombo.value);
	  if(document.forms[0].strToStoreCombo.value == 0)
	  {
		  alert("please select to store name");
		  document.forms[0].strToStoreCombo.disabled=false;
		  document.forms[0].strToStoreCombo.focus();
		  return false;
	  }
	  
	 /* alert(document.getElementsByName("strAdmissionDtlHidVal")[0].value.split("^")[9]);
	  alert(document.getElementsByName("strBillPaidCat")[0].value);
	  if(document.getElementsByName("strAdmissionDtlHidVal")[0].value.split("^")[9] == document.getElementsByName("strBillPaidCat")[0].value)
		  alert("Patient is of paying category!!!");
	 // return false;
	 */
	  if(document.getElementsByName("strPtType")[0].value != "1" )
	  {
		  if(document.getElementsByName("strPatientDtlHidVal")[0].value.split("^")[11] == '1' )
	  
		{
			  alert("Can't raise an indent for a dead patient");
			  return false;
		}	  
		
		  if( document.getElementsByName("strBillInt")[0].value == 1 && document.forms[0].patType.value == "1")
		{
			  if(document.getElementsByName("strPatAccountNo")[0].value == "null" || document.getElementsByName("strPatAccountNo")[0].value == "")
				{
					
				  alert("Either Patient's billing account doesn't exist or patient has gone for final settlement.Can't raise an indent");
					return false;
				}
		}
		  var hisValidator = new HISValidator("requestForLpPatient");  
	      //hisValidator.addValidation("strGrantType","dontselect=0","Please select a value from Indent Type Combo" );
		//  hisValidator.addValidation("strToStoreCombo","dontselect=0","Please select a value from To Store Combo" );
	      hisValidator.addValidation("strCrNo","req","CR NO. is a Mandatory Field" );
	      //hisValidator.addValidation("strProvisionDiagnosis","dontselect=0","Please select ICD10 Diagnosis Combo" );
	      //hisValidator.addValidation("strGroupIdForItemSearch","dontselect=0","Please select a value from Group Name Combo" );      
	      hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
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
	    	  document.getElementsByName("strReqQty")[x].removeAttribute("disabled");
	    	  if(itemParVal[x].value != "-")
	    	  {
		          hisValidator.addValidation("strReqQty","req","Required Quantity is a Mandatory Field" );
			     // hisValidator.addValidation("strUnitName","dontselect=0","Please select a value from Unit Name Combo" );
			     // hisValidator.addValidation("strRecmndBy","dontselect=0","Please select a value from Recomended By Combo" );
		          var retVal1 = hisValidator.validate(); 
		          if(retVal1)
		          {
		            myArray = itemParVal[x].value.split("^");
		        //    myArray1 = unitNameCmb[x].value.split("^");
		            if(bkgQty[x].value <= 0){
		              bkgQty[x].value = '0';
		        	  unitNameCmb[x].value = ' ';
		        	  document.getElementsByName("strReqQty")[x].value='';
		              alert("Request Qty must be Greater than Zero!!");
		              retVal=false;
		          }     
		          count = count +1;    
		         }
		         else
			     {
				  return false;
				 } 
	    	  }
	      }/*For Loop End*/
	       if(count>0)
	        {
	              
	    	      if(document.getElementsByName("strBillInt")[0].value == "1" && document.forms[0].patType.value == "1")
	    	      {
		    	      var  length = document.getElementsByName("itemParamValue").length;
		    	      var  totalCost=0;
		    	      
		    	      for(var i=0 ;i< length-1; i++)
		    	      {
		    	    	  
		    	    	  //document.getElementsByName("strReqQty")[i].disabled='false';
		    	    	  document.getElementsByName("strReqQty")[i].removeAttribute("disabled");
		    	    	 // alert(document.getElementsByName("strReqQty")[i].value);
		    	    	//  return false;
		    	    	  if(document.getElementsByName("itemParamValue")[i].value != "-")
		    	    	  {
		    	    	    var itemparam=document.getElementsByName("itemParamValue")[i].value.split("^")[4];
		    	    	    var reqqty=document.getElementsByName("strReqQty")[i].value;
		    	    	    totalCost= totalCost + (itemparam*reqqty);
		    	    	  }
		    	      }
		    	      totalCost=Math.round(totalCost * 100) / 100;
		    	      
		    	      var accBal=document.forms[0].strBillingHiddenValue.value;
		    	  	  var r=parseInt(((accBal.split('^')[1]))-totalCost.toFixed(2));
		    	  	  var creditAmt=parseInt(accBal.split('^')[2]) ;
		    	  	  var creditflag=parseInt(accBal.split('^')[3]) ;

		    	  	  //alert(accBal);
		    	  	  //alert(totalCost);
		    	  	  //alert(r);
		    	  	  //alert(creditAmt);
		    	  	if(creditflag>0)
			    	  {
			    	  		//alert(parseInt(r+creditAmt));
			    	  		if(parseInt(r-creditAmt) < 0)
			    	  		{
			    	  				alert('Patient Account Balance Going To Be Insufficient.Please Deposit Part Payment!!');
			    	  				return false;
			    	  		}
			    	  		else
			    	  		{
			    	  			 if(retVal)
					    	     {
			    	  				  document.forms[0].strCrNo.disabled = false;
	   		    					  document.getElementById("strToStoreCombo").disabled=false;
	   					              document.forms[0].hmode.value="INSERT";
	   						       	  document.forms[0].submit();
					    	    	  
					    	     }	
			   		        }
			    	  }
			    	  else
			    	  {
			    		  if(retVal)
				    	     {
		    	  				  document.forms[0].strCrNo.disabled = false;
		    					  document.getElementById("strToStoreCombo").disabled=false;
					              document.forms[0].hmode.value="INSERT";
						       	  document.forms[0].submit();
				    	    	  
				    	     }	
			    	  }
	    	      }
	    	      else
	    	      {
	    	    	   var conf1 = confirm("Are you sure !!!");
		               if(conf1 == true)
		               {
		                        
								  document.forms[0].strCrNo.disabled = false;
								  document.getElementById("strToStoreCombo").disabled=false;
					              document.forms[0].hmode.value="INSERT";
						       	  document.forms[0].submit();
		               }
		              else
		               {
		                 return false;
		               }
	    	    	
	    	    }
	    	    	  
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
	  else
		  {
		  	alert("Can't raise an indent for a NOT ADMITTED/DEAD/GONE FOR BILL SETTLEMENT patient");
		  	return false;
		  	
		  }
}

//-----------JS FUNCTIONS from JSP file-------------------------//



function cancelToDesk()
{
  var mode="CANCEL";
  document.forms[0].hmode.value=mode;
  document.forms[0].submit();
}

function multiRowFunc()
{
  //alert("Inside multiRwFunc 1");
		if(document.forms[0].strDiagnosisType[0].checked == true)
		{
		    //alert("Inside multiRwFunc 11");
			myFunc('1');	
		}
		else
		{
		   //alert("Inside multiRwFunc 12");
			myFunc('2');
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
    
		if(mode == '1')
		{
			var objEle = document.getElementById("diagnosisCombo");
			objEle.innerHTML = "<select name='strProvisionDiagnosis' id='strProvisionDiagnosis#delIndex#' class='comboNormal'>"+res+"</select>";
			addRows(new Array('strIcdCode','strProvisionDiagnosis'),new Array('t','s'),'2','1','R');
		}
		else if(mode == '2')
		{		  		
				document.getElementById("dropdown1").innerHTML = res;
				//document.getElementById("dropdown1").style.display="";
			 	searchSelWithCode(tempCode, gblParentObj.name+""+gblIndex ,'1',gblParentObj);
		}

    if(mode == '3')
    {
			var objEle = document.getElementById("diagnosisCombo");
			objEle.innerHTML = "<select class='comboBig' name='strProvisionDiagnosis' id='strProvisionDiagnosis#delIndex#'  onChange='showValues(this,\"#delIndex#\");'>"+res+"</select>";
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
	// alert("initPage");
 if(document.forms[0].strCrNo.disabled)
  {
   document.forms[0].strCrNo.disabled = false;
   document.getElementById("strToStoreCombo").disabled=false;
  }
 if(document.getElementById("strToStoreCombo").disabled)
 {
	 document.getElementById("strToStoreCombo").disabled=false;
 }// else
 // {
 //  document.forms[0].strCrNo.disabled = true;
 // } 
  document.forms[0].strCrNo.value = "";
 // document.forms[0].strToStoreCombo.value        = '0';
  document.forms[0].strGrantType.value      = '0';
  //document.forms[0].strGroupIdForItemSearch.value = '0';
  document.getElementById("id1").style.display="none";
  document.getElementById("errMsg").innerHTML = "";
  var id = document.getElementById("strApproxAmtDivId");
  id.innerHTML ="0.00";
  document.forms[0].strApproxAmt.value = '0';
  document.getElementById("detailsdivid1").style.display="none";
  document.getElementById("diagdivid").style.display="none";
  document.getElementById("treatmentdtlsdivid").style.display="none";
  document.forms[0].strIsUtilityIndent.value="0";
  
 }


function OnLoadFunction()
{ 
   //alert("OnLoadFunction"+document.forms[0].strGoFlg.value);
  var mode=1;
 // document.forms[0].strItemCatg.value        = document.forms[0].strTmpItemCatg.value;
  if(document.forms[0].strGoFlg.value=='1')
  { 
	//  alert("OnLoadFunction"+document.forms[0].strGoFlg.value);
	  var obj = document.forms[0].strComboData.value;
     var tmp = obj.split("^");
     document.forms[0].strToStoreCombo.value    = tmp[0];
     document.forms[0].strGrantType.value       = tmp[1];
        document.forms[0].strCrNo.disabled = true; 
        document.getElementById("strToStoreCombo").disabled=true;
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
       
            
      
 	 // if( document.getElementsByName("strBillInt")[0].value == 1 && document.getElementsByName("patType").value == "1")
       
       if(document.getElementsByName("strBillInt")[0].value == "1" && document.forms[0].patType.value == "1")
       {
    	   if(document.getElementsByName("strPatAccountNo")[0].value == "null" || document.getElementsByName("strPatAccountNo")[0].value == "")
		   {
			alert("Either Patient's billing account doesn't exist or patient has gone for final settlement.Can't raise an indent");
			document.forms[0].strCrNo.disabled = false;
			document.getElementById("strToStoreCombo").disabled=false;
			document.forms[0].strCrNo.value = "";
			return false;
			
		   } 
    	   if(document.getElementsByName("strBalanceAmount")[0].value == "null" || document.getElementsByName("strBalanceAmount")[0].value == "" || parseFloat(document.getElementsByName("strBalanceAmount")[0].value) <= 0)
    	   {
    		if(!confirm("Total Account Balance: "+parseFloat(document.getElementsByName("strBalanceAmount")[0].value)+ "\nPatient Account Balance is Insufficient.\nDo you still want to raise an indent? "))
    		{
    			initPage();
    			return false;
    		}
    	   } 
       }
       
       
    	//alert("blocked");
      document.getElementById("All").style.display="block";
      document.getElementById("detailsdivid1").style.display="block";
      
      document.getElementById("diagdivid").style.display="block";
      document.getElementById("treatmentdtlsdivid").style.display="block";
      
     // document.getElementById("minus1").style.display="block";
     // document.getElementById("plus1").style.display="none";
      
      
  
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



function goFunc()                //  for CR No. field validation
{
	
       
        var hisValidator = new HISValidator("requestForLpPatient"); 
       
	 	hisValidator.addValidation("strCrNo", "req", "CR No. is a Mandatory Field" );
		hisValidator.addValidation("strCrNo", "minlen="+document.forms[0].strCrNo.maxLength,"CR No. must be "+document.forms[0].strCrNo.maxLength+" Digits" );
		var retVal = hisValidator.validate();
		
		document.forms[0].strPath.value               = document.forms[0].strPath.value;
		document.forms[0].strTmpCrNo.value            = document.forms[0].strCrNo.value;
		document.forms[0].strComboData.value          = document.forms[0].strToStoreCombo.value+"^"+document.forms[0].strGrantType.value;
		
		//document.forms[0].strTmpItemCatg.value      = document.forms[0].strItemCatg.value;
	   
	 //   document.forms[0].strCrNo.focus();
		
		
		
		
	    if(retVal)
	    {
	           
	       	  	document.forms[0].hmode.value="GO";
	            document.forms[0].submit();
		}else{
		
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
	//alert("ftn11");
	if(document.forms[0].button1.value != 1 )
   {
    //document.getElementById("detailsdivid1").style.display="block";
    document.getElementById("diagdivid").style.display="block";
    document.getElementById("treatmentdtlsdivid").style.display="block";
   // document.getElementById("minus1").style.display="block";
   // document.getElementById("plus1").style.display="none";
    document.forms[0].button1.value = 1;
   }
   else
   {
    //document.getElementById("minus1").style.display="none";
   // document.getElementById("plus1").style.display="block";
    //document.getElementById("detailsdivid1").style.display="none";
    document.getElementById("diagdivid").style.display="none";
    document.getElementById("treatmentdtlsdivid").style.display="none";
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

