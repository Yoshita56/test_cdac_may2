// For Bill Approval transaction


/*

function rasieBySuppAmt(obj,event)
{
	var retVal=validateData(event,5);
	alert(retVal);
	var raiseAmtDivId=document.getElementById("strRaiseBySuppTotAmt");
	if(retVal && obj.value!="")
	{
	  var cost=roundValue(parseFloat(document.forms[0].strBillRaisebySuppAmt.value)+parseFloat(document.forms[0].strMiscllRaisebySuppAmt.value),2);
	  raiseAmtDivId.innerHTML="<font color='red'>"+cost+"</font>";
	}
	
}


function sancAmt(obj,event)
{
	var retVal=validateData(event,5);
	alert(retVal);
	var sancAmtDivId=document.getElementById("strSancTotAmt");
	
	if(retVal && obj.value!="")
	{
	  var cost=roundValue(parseFloat(document.forms[0].strBillSancAmt.value)+parseFloat(document.forms[0].strMiscllSancAmt.value),2);
	  sancAmtDivId.innerHTML="<font color='red'>"+cost+"</font>";
	}
}
*/
/*
 * Global variables Declaration Here
 */
var strLatePenelty=0.0;
var strRejectedPenelty=0.0;
var totalPeneltyImposed=0;
var scheduleNos="";
var flag=false;
var peneltyFlag=false;
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
        var objVal = document.getElementById("scheduleNoSelectHLPDivId");
        objVal.innerHTML =res;
        //document.getElementById("otherDetailsDIV").style.display="block";
      
        totalPeneltyImposed=manipulateValue(strLatePenelty,strRejectedPenelty,0);
        objVal =document.getElementById("peneltyDivId");
        var strPenaltyDtl="<a style='color: blue;cursor: pointer; ' onClick='getPeneltyDtl();'>"+totalPeneltyImposed+"</a>";
        objVal.innerHTML=""+strPenaltyDtl;
        calculateNetCost();
        
     }
     if(mode=="2"){
     		document.getElementById("peneltyItemListDtl").innerHTML =res;
     		document.getElementById("peneltyListDtlId").style.display="block";
     }
}
/*
 * THIS FUNCTION IS USED TO DISPLAY lIST oF ITEMS ON WHICH PENELTY 
 */
function showPeneltyItemDtl(){
	if(!flag){
			document.getElementById("itemDtl").style.display="block";
			flag=true;
	}else{
		document.getElementById("itemDtl").style.display="none";
		flag=false;
	}
}
function closePeneltyItemDtl(){
	hide_popup_menu('peneltyListDtlId');
	
}
/*
 * This function is used to fetch penelty Item details
 */
function getPeneltyDtl(){
	
	var strPoStoreId=document.forms[0].strStoreId.value;
	var mode="PENELTYDTL";
	var poNo=document.forms[0].strPONo.value;
	var url="BillApprovalTransCNT.cnt?hmode="+mode+"&scheduleNos="+scheduleNos+"&poStoreId="+strPoStoreId
	 +"&poNo="+poNo+"&latePenelty="+strLatePenelty+"&rejectedPenelty="+strRejectedPenelty;
    ajaxFunction(url,"2");
}
function calculateNetCost()
{
	    var retVal=true;
	    var totItemCost      = document.forms[0].strTotalItemCost.value;
        var overalltaxPercent= document.forms[0].strOverallPOTax.value;
        var balanceAdvance=document.forms[0].strBalanceAdvance.value;
        document.forms[0].strNetPenalty.value=totalPeneltyImposed;
        var netpenalty=/*totalPeneltyImposed;*/document.forms[0].strNetPenalty.value;
        var netCost=0;
        var waiveOffamt=0;
        var advanceAdjust=document.forms[0].strAdvanceAdjusted.value;
        if(advanceAdjust=="")
          advanceAdjust="0";
        var tax=parseFloat(overalltaxPercent)*parseFloat(totItemCost)/100;
        if(parseFloat(advanceAdjust)>parseFloat(balanceAdvance))
        {
        	alert("Adjusted Advance cannot be greater than Balance Advance");
        	document.forms[0].strAdvanceAdjusted.value="0";
        	retVal=false;
        }
          if(parseFloat(netpenalty)==0)
         {
         	document.forms[0].strWaiveOffChk.checked=false;
         	document.forms[0].strWaiveOffChk.disabled=true;
         }
        if(retVal && parseFloat(netpenalty)>0)
        {
        	
          	waiveOffamt=document.forms[0].strWaiveOffAmt.value;
          	if(waiveOffamt=="")
          	  waiveOffamt="0";
          	if(parseFloat(waiveOffamt)>parseFloat(netpenalty))
          	{
          		alert("Waive Off Amount cannot be greater than Net Penalty");
          		document.forms[0].strWaiveOffAmt.value="0";
          		retVal=false;
          	}
          	
        }
        if(retVal)
        {
           netCost=parseFloat(totItemCost)+parseFloat(tax)-parseFloat(netpenalty)+parseFloat(waiveOffamt)-parseFloat(advanceAdjust);
           netCost=roundValue(parseFloat(netCost),2);
           var objOverallTax=document.getElementById("overallTaxDIV");
           var objNetCost=document.getElementById("netCostDIV");
           tax=roundValue(tax, 2); 
           netCost=roundValue(netCost, 2); 
           objOverallTax.innerHTML=tax;
           objNetCost.innerHTML=netCost;
           document.forms[0].strNetItemCost.value=netCost;
        }   
}

function calculateNetBillCost()
{
	    var retVal         		= true;
	    var PONetCost      		= document.forms[0].strPONetCost.value;   
	    var SupplyNetCost  		= document.forms[0].strSupplyNetCost.value;
        var billAmtAfterPayment = document.forms[0].strBillAmtAfterPayment.value;
	    var netCost=0;
        var waiveOffamt=document.forms[0].strWaiveOffAmt.value;
      	
        if(waiveOffamt=="")
      	  waiveOffamt="0";
        
      	if(parseFloat(waiveOffamt)>parseFloat(PONetCost))
      	{
      		alert("Waive Off Amount ["+waiveOffamt+"] cannot be greater than Remaning Amt [ "+billAmtAfterPayment+" ] ");
      		document.forms[0].strWaiveOffAmt.value="0";      		
      		retVal=false;
      	}      	
      	
      	if(retVal && parseInt(waiveOffamt) > 0)
      	{
      		netCost = roundValue(parseFloat(billAmtAfterPayment),2) - roundValue(parseFloat(waiveOffamt),2) ;
      	}
      	else
      	{
      		netCost = roundValue(parseFloat(billAmtAfterPayment),2);
      	}
               
                    
        document.forms[0].strBillAmount.value=roundValue(parseFloat(netCost),2);
          
}



function goFunc()
{
	var hisValidator = new HISValidator("billApprovalTransBean");
    hisValidator.addValidation("strPONoCmb","dontselect=0","Please select PO No" );
    var retVal = hisValidator.validate();
	if(retVal)
	{
		document.getElementById("onGOClickDtlsDivId").style.display="block";
	 	document.forms[0].hmode.value="GET_PO_DETAILS";
	 	document.forms[0].submit();
	}
	 else
	{
		return false;
	}
}

function initPage()
{
	if(document.forms[0].strPONo.value!="")
	{
		document.getElementById("onGOClickDtlsDivId").style.display="block";
		if(document.forms[0].strPOPrefix.value!="")
		   document.getElementById("poNoWithPrefixDIV").innerHTML="<font color='blue'>"+document.forms[0].strPOPrefix.value+"/"+document.forms[0].strPONo.value+"</font>";
		else
		   document.getElementById("poNoWithPrefixDIV").innerHTML="<font color='blue'>"+document.forms[0].strPONo.value+"</font>";
	    if(document.forms[0].strAgentNameShow.value=="1")
	       document.getElementById("agentNameDivId").style.display="block";
	    else
	       document.getElementById("agentNameDivId").style.display="none";     
	}
	else
	{
		document.getElementById("onGOClickDtlsDivId").style.display="none";
	}
 
}
var compileStat=true;
function scheduleCheckCompile()
{
	if(compileStat)
	{
	  var obj=document.getElementsByName("strScheduleChk");
	  var obj1=document.getElementsByName("strPeneltyLateSchduleWise");
	  var obj2=document.getElementsByName("strPenltyRejejectedSchduleWise");
	  var checkedStat=false;
	  var count=0;	
	  for(var i=0;i<obj.length ;i++)
	  {
		if(obj[i].checked)
		{
			checkedStat=true;	
			count=count+1;
			strLatePenelty=manipulateValue(strLatePenelty,parseFloat(obj1[i].value),0);
			strRejectedPenelty=manipulateValue(strRejectedPenelty,parseFloat(obj2[i].value),0);
			if(count==1)
			{
				
				scheduleNos=obj[i].value;
			} 
			else
			{
				scheduleNos=scheduleNos+"^"+obj[i].value;
			}
		}
	  }
	  if(checkedStat==true)
	  {
		for(var i=0;i<obj.length;i++)
	    {
	    	obj[i].disabled=true;
	    }
	    document.forms[0].compile.disabled=true;
	    compileStat=false;
		var mode ="ScheduleItemDtls";
		var po_StoreId=document.forms[0].strPOStoreId.value;
		var poNo=document.forms[0].strPONo.value;
        var url="BillApprovalTransCNT.cnt?hmode="+mode+"&scheduleNoList="+scheduleNos+"&poStoreId="+po_StoreId+"&poNo="+poNo;
        ajaxFunction(url,"1");
	  }
	  else
	  { 
		alert("Please Select a Schedule!!");
	  }
	}
	else
	{
		alert("Complile Disabled.Press Clear To Compile Again.");
	} 
}


function waiveOffdtl(obj)
{
	if(obj.checked)
	{
		document.getElementById("waiveOffDtlDIV").style.display="block";
	}
	else
	{
		document.getElementById("waiveOffDtlDIV").style.display="none";
	}
	
}

function validate1()
{
	var retVal=true;
 	if(document.forms[0].strWaiveOffApprovedDate.value=="")
 	{
 	  alert("Please select  Approved Date");
 	  retVal=false;
 	}
	 else
		 {
	 	  retVal=true;   
	 }
 	/*
	 if(retVal)
	 {
	 	if(document.forms[0].strPaymentDate.value=="")
	 	{
	 	  alert("Please select Supplier Bill Date");
	 	  retVal=false;
	 	}
	 	else
	 	  retVal=true;   
	 }
	 */
	 if(retVal)
	 {
	   var hisValidator = new HISValidator("billApprovalTransBean");	   
	   
	   hisValidator.addValidation("strWaiveOffApprovedBy", "dontselect=0",	"Please select Approved By");
       hisValidator.addValidation("strUTRNo","req","Please enter  UTR No" );
       hisValidator.addValidation("strBillAmount","req","Please enter  Bill/Invoice Amount" );
      // hisValidator.addValidation("strPaymentDate","dtltet="+document.forms[0].strCurrentDate.value,"Please select Supplier Bill Date Less Than Equal To Current Date" );
      // hisValidator.addValidation("strPaymentDate","dtltet="+document.forms[0].strWaiveOffApprovedDate.value,"Approval Date Should be Less Than Equal To Bill Date" );
       hisValidator.addValidation("strRemarks","req","Please enter Remarks");
       
       
       hisValidator.addValidation("strBillAmount","numltet="+document.forms[0].strPONetCost.value,"Bill Amt should be Less Than Equal To Net Cost" );
       
       retVal = hisValidator.validate(); 
       hisValidator.clearAllValidations();
	 }  
     if(retVal)
     {
     	
			           
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
        return false;
	 }	
}

function validateNew()
{
	
	var retVal=true;
	var saveObj = document.getElementById("saveId");
	if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	{
			saveObj.style.display = "none"; 
		 	if(document.forms[0].strWaiveOffApprovedDate.value=="")
		 	{
		 	  alert("Please select  Approved Date");
		 	  saveObj.style.display = "";
		 	  retVal=false;
		 	}
			 else
			 {
			 	  retVal=true;   
			 	 saveObj.style.display = "";
			 } 	
			 if(retVal)
			 {
			   var hisValidator = new HISValidator("billApprovalTransBean");	   
			   
			   hisValidator.addValidation("strWaiveOffApprovedBy", "dontselect=0",	"Please select Approved By");
		       //hisValidator.addValidation("strUTRNo","req","Please enter  UTR No" );
		      // hisValidator.addValidation("strBillAmount","req","Please enter  Bill/Invoice Amount" );
		      // hisValidator.addValidation("strPaymentDate","dtltet="+document.forms[0].strCurrentDate.value,"Please select Supplier Bill Date Less Than Equal To Current Date" );
		      // hisValidator.addValidation("strPaymentDate","dtltet="+document.forms[0].strWaiveOffApprovedDate.value,"Approval Date Should be Less Than Equal To Bill Date" );
		       hisValidator.addValidation("strRemarks","req","Please enter Remarks");       
		       //hisValidator.addValidation("strBillAmount","numltet="+document.forms[0].strPONetCost.value,"Bill Amt should be Less Than Equal To Net Cost" );
		       
		       retVal = hisValidator.validate(); 
		       hisValidator.clearAllValidations();
			 }  
		     if(retVal)
		     {     	
		    	 
		    	    var itemParVal     = document.getElementsByName("strMultiInvoiceAmount");		 
				    var count = 0;
				    var flength = 0;
				    
				    flength = parseInt(itemParVal.length) - parseInt(1);
				    
				    if(itemParVal.length>1)
					{												
						 for(var i=0;i<itemParVal.length-1;i++)
						 {
						 	
						 	if(itemParVal[i].value > 0)
						 	{
						 		count = 1;
						 		break;
						 	}												 	
						 }									  
					}	
															
					if(count  != 0)
					{
																	
						 for(var i=0;i<itemParVal.length-1;i++)
						 {
							for(var j=i+1;j<itemParVal.length-1;j++)
							 {						
								    if(itemParVal[i].value == itemParVal[j].value)
									{
										alert('Kindly Remove Duplicate Invoice '+itemParVal[i].value+' From List');
										saveObj.style.display = ""; 
										return false;
									}
							 	
							 }	
						 	//itemUserValue[i].disabled=false;
						 }									  
					}
					           
			      var conf = confirm("You Are Going To Save ["+ flength +"] Invoice Records");
		          if(conf == true)
		          {
		               var conf1 = confirm("Are you sure !!!");
		               if(conf1 == true)
		               {
		                  document.forms[0].hmode.value = "INSERT_NEW";
		                  document.forms[0].submit();
		               }
		              else
		               {
		            	  saveObj.style.display = "";
		                 return false;
		               }
		           }
		          else
		           {
		        	  saveObj.style.display = "";
		                 return false;
		           }
		        	
		     }
		     else
		     {
		    	 saveObj.style.display = "";
		        return false;
			 }
	}
	else
	{
		saveObj.style.display = "";
	}
}
function calCost(index)
{
	
	
	document.getElementById("showTotalDiv").style.display="";
	
	 var        FinalTotal      = 0;
	 var        invAmtTotal     = 0;
	 var        invTaxTotal     = 0;
	 var        invDisclTotal   = 0;
	 
	 var   itemParVal      = document.getElementsByName("strMultiInvoiceNo");	
	 if(itemParVal.length>1)
	 {												
			 for(var i=0;i<itemParVal.length-1;i++)
			 {
				 
				 invAmtTotal=parseFloat(invAmtTotal)+parseFloat(document.getElementsByName("strMultiInvoiceAmount")[i].value);
				 
				 invTaxTotal=parseFloat(invTaxTotal)+parseFloat(document.getElementsByName("strMultiInvoiceTax")[i].value);
				 
				 invDisclTotal=parseFloat(invDisclTotal)+parseFloat(document.getElementsByName("strMultiInvoiceDisc")[i].value);
				 
				 FinalTotal=parseFloat(FinalTotal)+parseFloat(document.getElementsByName("strMultiInvoiceValue")[i].value);
				 
			 }									  
	 }
	 
	 var   TotRegFinalInvAmt          = document.getElementById("strTotRegFinalInvAmt").value;
	 var   TotSuppliedAmt             = document.getElementById("strPONetCost").value;
	       TotSuppliedAmt             = Math.round(TotSuppliedAmt * 100) / 100;
	 
	
	 var   TotCalAmt                  = (parseFloat(TotRegFinalInvAmt)+parseFloat(FinalTotal));
	 
	       TotCalAmt                  = Math.round(TotCalAmt * 100) / 100;
	 
	 console.log("TotRegFinalInvAmt---"+TotRegFinalInvAmt+"--Float--"+parseFloat(TotRegFinalInvAmt));
	 console.log("TotSuppliedAmt---"+TotSuppliedAmt+"--Float--"+parseFloat(TotSuppliedAmt));
	 console.log("FinalTotal---"+FinalTotal+"--Float--"+parseFloat(FinalTotal));
	 console.log("TotCalAmt---"+parseFloat(TotRegFinalInvAmt)+"+"+parseFloat(FinalTotal)+"="+Math.round(TotCalAmt * 100) / 100);
	 
		 
	 if(TotCalAmt > TotSuppliedAmt)
	 {				  		 
			 alert("Total Registered + Enter Invoice Amount "+TotCalAmt+" Rs. Must be Less than or Equal to Supplied Amount "+TotSuppliedAmt+" Rs.");
			
			 document.getElementById("strInvoiceNetValue").value = "0";     
		     document.getElementById("invoiceNetCostDIV").innerHTML = "";
		     
		     
		     document.getElementById("strGSTNetValue").value = "0";     
		     document.getElementById("invoiceNetGSTDIV").innerHTML = "";
		     
		     document.getElementById("strDiscNetValue").value = "0";         
		     document.getElementById("invoiceNetDiscDIV").innerHTML = "";
		     
		     document.getElementById("strFinalInvoiceNetValue").value = "0";    
		     document.getElementById("invoiceFinalNetCostDIV").innerHTML = "";
		     
			//console.log("--Length--"+itemParVal.length);
			if(itemParVal.length>1)
			{												
					 for(var i=0;i<itemParVal.length;i++)
					 {						 
						// document.getElementsByName("strMultiInvoiceAmount")[i].value="0";  
						 document.getElementsByName("strMultiInvoiceTax")[i].value="0";
						 document.getElementsByName("strMultiInvoiceDisc")[i].value="0";
						 document.getElementsByName("strMultiInvoiceValue")[i].value="0";						 
					 }									  
			 }
			
			 
			
			
			return false;
	 }	
	 else
	 {	 
	     document.getElementById("strInvoiceNetValue").value = invAmtTotal.toFixed(2);     
	     document.getElementById("invoiceNetCostDIV").innerHTML = invAmtTotal.toFixed(2) +" Rs.";
	     
	     
	     document.getElementById("strGSTNetValue").value = invTaxTotal.toFixed(2);     
	     document.getElementById("invoiceNetGSTDIV").innerHTML = invTaxTotal.toFixed(2) +" Rs.";
	     
	     document.getElementById("strDiscNetValue").value = invDisclTotal.toFixed(2);     
	     document.getElementById("invoiceNetDiscDIV").innerHTML = invDisclTotal.toFixed(2) +" Rs.";
	     
	     document.getElementById("strFinalInvoiceNetValue").value = FinalTotal.toFixed(2);     
	     document.getElementById("invoiceFinalNetCostDIV").innerHTML = FinalTotal.toFixed(2) +" Rs.";
	 }
       
     
  }
function QtyValidation(index)
{
	var   dTaxAmt         = 0;				
    var   dDicsountAmt    = 0;
    var   dInvoiceAmt     = 0;
    var   invAmt          = document.getElementById("strMultiInvoiceAmount"+index).value;
    var   suppliedAmt     = document.getElementById("strPONetCost").value;
    
    var   taxAmt          = document.getElementById("strMultiInvoiceTax"+index).value;
    var   discAmt         = document.getElementById("strMultiInvoiceDisc"+index).value;
   
    
   
	  	
		if(document.getElementById("strMultiInvoiceAmount"+index).value!="")
		{			    	     			     
				 var itemParVal     = document.getElementsByName("strMultiInvoiceNo");		 
				 var count = 0;
				 var Total = 0;   
			     if(itemParVal.length>1)
				 {												
				 	 for(var i=0;i<itemParVal.length-1;i++)
					 {					 	
					 	if(parseInt(document.getElementsByName("strMultiInvoiceAmount")[i].value) > 0)
					 	{
					 		Total=parseFloat(Total)+parseFloat(document.getElementsByName("strMultiInvoiceAmount")[i].value);
					 	}												 	
					 }									  
				 }
			     
			     if(parseFloat(Total)>parseFloat(suppliedAmt,10))
				 {
						alert("Enter Invoice Amount Rs. ["+parseFloat(Total)+"]  will Not be Greater than Supplied Amount Rs. ["+parseFloat(suppliedAmt)+"] ");					
						document.getElementById("strMultiInvoiceAmount"+index).value="";
						return false;
				 }
			     
	  	 }		
		
		 if(document.getElementById("strMultiInvoiceAmount"+index).value!="")
	     {
			 dInvoiceAmt = document.getElementById("strMultiInvoiceAmount"+index).value;
	     }
	     else
	     {
	    	 document.getElementById("strMultiInvoiceAmount"+index).value = 0;
	    	 dInvoiceAmt = 0;	
	     }
		
		 if(document.getElementById("strMultiInvoiceTax"+index).value!="")
	     {
	    	 dTaxAmt = document.getElementById("strMultiInvoiceTax"+index).value;
	     }
	     else
	     {
	    	 dTaxAmt          = 0;	
	    	 document.getElementById("strMultiInvoiceTax"+index).value = 0;
	     }
	     
		
		 
	     if(document.getElementById("strMultiInvoiceDisc"+index).value!="")
	     {
	    	 dDicsountAmt     = document.getElementById("strMultiInvoiceDisc"+index).value;
	     }
	     else
	     {
	    	 dDicsountAmt    = 0;	
	    	 document.getElementById("strMultiInvoiceDisc"+index).value = 0;
	     }
	     
	     //alert("Disc----"+document.getElementById("strMultiInvoiceDisc"+index).value+"--dDicsountAmt--"+dDicsountAmt);
	     	     	     
	     document.getElementById("strMultiInvoiceValue"+index).value = ((parseFloat(dInvoiceAmt)+parseFloat(dTaxAmt))-parseFloat(dDicsountAmt)).toFixed(2);
	     
	     	    
}
function generateSlNo(mode)
{
	
	if(mode == 1)
	{	
		var   TotRegFinalInvAmt          = document.getElementById("strTotRegFinalInvAmt").value;
		var   TotSuppliedAmt             = document.getElementById("strPONetCost").value;
		      TotSuppliedAmt             = Math.round(TotSuppliedAmt * 100) / 100;
		 
		
		 var   TotCalAmt                  = parseFloat(TotRegFinalInvAmt);
		 
		       TotCalAmt                  = Math.round(TotCalAmt * 100) / 100;
		 		 		 
		 if(TotCalAmt == TotSuppliedAmt)
		 {		
			 alert("Total Supplied Amount "+TotSuppliedAmt+" Rs. Equla to Total Invoice Amount "+TotCalAmt+" No Entry Allowed !! ");
			 return false;
		 }
		 else
		 {
			 addRows(new Array('strMultiInvoiceNo','strMultiInvoiceDate','strMultiInvoiceAmount','strMultiInvoiceTax','strMultiInvoiceDisc','strMultiInvoiceValue'),new Array('t','d','t','t','t','t'),'1','1','R');
			 
			 var depNamelength= document.getElementsByName("strMultiInvoiceNo").length - 1;
		     
		    // alert("depNamelength: "+depNamelength);
		     
		     for(var i=0;i<depNamelength;i++)
		     {
		     	document.getElementsByName("strSNo")[i].value=i+1;
		     	
		     }
		 }   
	}	 
	if(mode == 2)
	{	
			 var depNamelength= document.getElementsByName("strMultiPayInvoiceNo").length - 1;
		     
		    // alert("depNamelength: "+depNamelength);
		     
		     for(var i=0;i<depNamelength;i++)
		     {
		     	document.getElementsByName("strSNo2")[i].value=i+1;
		     	
		     }
		 
	}	 
}

function generateSlNo_D(mode)
{ 
	if(mode == 1)
	{
		 var depNamelength= document.getElementsByName("strMultiInvoiceNo").length - 1;  
	   
	     
	     for(var i=0;i<depNamelength;i++)
	     {
	     	document.getElementsByName("strSNo")[i].value=i+1;
	     	
	     }
	}    
	  
}
function calFinalPayment(obj,index)
{
	var   dPayTaxAmt         = 0;				
    var   dPayDicsountAmt    = 0;
    var   dPayInvoiceAmt     = 0;
    var   dPayInvoiceValue   = 0;
    
    
    
    if(document.getElementById("strMultiPayInvoiceAmount"+index).value!="")
    {
    	dPayInvoiceAmt = document.getElementById("strMultiPayInvoiceAmount"+index).value;
    }
    
    
    if(document.getElementById("strMultiPayInvoiceTax"+index).value!="")
    {
    	dPayTaxAmt = document.getElementById("strMultiPayInvoiceTax"+index).value;
    }
    else
    {
   	    document.getElementById("strMultiPayInvoiceTax"+index).value = 0;
   	    dPayTaxAmt = 0;	
    }
    
    if(document.getElementById("strMultiPayInvoiceDisc"+index).value!="")
    {
    	dPayDicsountAmt = document.getElementById("strMultiPayInvoiceDisc"+index).value;
    }
    else
    {
   	    document.getElementById("strMultiPayInvoiceDisc"+index).value = 0;
   	    dPayDicsountAmt = 0;	
    }
    
    if(document.getElementById("strMultiPayInvoiceValue"+index).value!="")
    {
    	dPayInvoiceValue = document.getElementById("strMultiPayInvoiceValue"+index).value;
    }
    
    
    document.getElementById("strMultiPayInvoiceValue"+index).value = ((parseFloat(dPayInvoiceAmt)+parseFloat(dPayTaxAmt))-parseFloat(dPayDicsountAmt)).toFixed(2);
    
    
    
    
}
function getInvComboAmt(obj,index)
{
	
	    console.log("--Invoice--"+obj.value.split("^")[0]+"--Index--"+index);
	 
	    var dependentLength = document.getElementsByName("strMultiPayInvoiceNo").length - 1;
	
		if(dependentLength>1)
		{
			    var relation_ship=document.getElementsByName("strMultiPayInvoiceNo");					
			    
			   
				for(var j=0;j<dependentLength;j++)
				{
					if(obj!=relation_ship[j])
					{
						
						console.log("--Obj-"+j+"---"+obj.value+"--Row--"+relation_ship[j].value);					
						if(obj.value==relation_ship[j].value)
						{
							
							alert("Cannot Select Invoice No [ "+obj.value.split("^")[0]+" ] Again");	
							obj.value='0';
							document.getElementById("strMultiPayInvoiceAmount"+index).value= 0;
							document.getElementById("strMultiPayInvoiceValue"+index).value= 0;
							document.getElementById("strMultiPayInvoiceTax"+index).value = 0;
							document.getElementById("strMultiPayInvoiceDisc"+index).value = 0;
							
						}
						else
						{
							document.getElementById("strMultiPayInvoiceAmount"+index).value= obj.value.split("^")[1];
							document.getElementById("strMultiPayInvoiceValue"+index).value= obj.value.split("^")[1];
						}
					}
				}
			    
		}
		else
		{		
			document.getElementById("strMultiPayInvoiceAmount"+index).value= obj.value.split("^")[1];
			document.getElementById("strMultiPayInvoiceValue"+index).value= obj.value.split("^")[1];
			
		}
			
}

function cancelPage()
{
	document.forms[0].hmode.value="CANCELPAGE";
	document.forms[0].submit();
}
function cancelView()
{
	document.forms[0].hmode.value="LIST";
	document.forms[0].submit();
}
function clearDtl()
{
	document.forms[0].hmode.value="CLEAR";
	document.forms[0].submit();
}


// Function for Numeric(11,2)
function numericWithTwoDecimalPlaces(fld, milSep, decSep, e)
{
	var sep = 0;
	var key = '';
	var milSep="";
	var i = j = 0;
	var len = len2 = 0;
	var strCheck = '0123456789';
	var aux = aux2 = '';
	var whichCode = (window.Event) ? e.which : e.keyCode;
	//if (whichCode == 13) return true;  // Enter
	if (whichCode == 0)	return true; //tab-index
	//alert(whichCode);
	if (whichCode == 8) return true;  // Back-Space 
	key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		//len = fld.value.length;
		len=11;
		for(i = 0; i < len; i++)
		if ((fld.value.charAt(i) != decSep)) break;
		aux = '';
	for(; i < len; i++)
	if (strCheck.indexOf(fld.value.charAt(i))!=-1) aux += fld.value.charAt(i);
	aux += key;
	len = aux.length;
	if (len == 0) fld.value = '';
	if (len == 1) fld.value = ''+ decSep + '' + aux;
	if (len == 2) fld.value = ''+ decSep + aux;
	if (len > 2) {
	aux2 = '';
	for (j = 0, i = len - 3; i >= 0; i--) {
	if (j == 3) {
	aux2 += milSep;
	j = 0;
	}
	aux2 += aux.charAt(i);
	j++;
	}
	fld.value = " ";
	len2 = aux2.length;
	for (i = len2 - 1; i >= 0; i--)
	fld.value += aux2.charAt(i);
	fld.value += decSep + aux.substr(len - 2, len);
	}
	return false;
}