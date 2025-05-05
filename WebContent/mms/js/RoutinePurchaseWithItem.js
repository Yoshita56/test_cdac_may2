
function CalculateTotalItemCost(index,mode)
{	   

        var  rateObj   = document.getElementById("rateForCalc"+index).value;
        var  rate      = parseFloat("0.00"); 
             rate      = rateObj; 
		var  qtyObj    = document.getElementById("strTotalQty"+index).value;
               
			var qty    = qtyObj;	
			var total  = parseFloat("0.00");
		
			if(isNaN(rate) || rate=="") rate = "0";
			if(isNaN(qty)  || qty=="") qty = "0";
						  			  
			  total    = parseFloat(qty * rate);
			  total    = roundValue(total, 2);	
			 
  
             document.getElementById("strApproxAmt"+index).value=total;
             totalCost(mode);
}

function totalCost(mode)
{	   
       	    var costObj = document.getElementsByName("strApproxAmt");
			var total = parseFloat("0.00");
					
		   	if (costObj.length > 0) 
			{
		        
				for ( var i = 0; i <costObj.length-1; i++)
				{		        	
					total = total + parseFloat(costObj[i].value);
					
		 		}
		
			}

	    total = roundValue(total, 2);
	    if(mode=='1')
	    {
	     document.getElementById("strApproxAmtTotalDivId").innerHTML = total;
	    }	  
        document.forms[0].strApproxAmtTotal.value=total;
       
}


function CalculateItemTotal(index,mode)
{

	  	var  chmQty  = ""; 
	  	var   mcQty  = "";   
	  	var  finalchmQty  = 0;
	  	var   chmQty1= document.getElementById("strCHMOQty"+index).value;
	  	var   mcQty1= document.getElementById("strMCQty"+index).value;
		if(chmQty1 == "" || chmQty1.length <=0)
		{
			chmQty = parseInt("0");
		}
		else
		{
			chmQty    = parseInt(document.getElementById("strCHMOQty"+index).value,10);
         
		}
		if(mcQty1 == "" || mcQty1.length <=0)
		{
			mcQty = parseInt("0");			
		}	
		else
		{
			mcQty    = parseInt(document.getElementById("strMCQty"+index).value,10);
		}	
	    finalchmQty = (chmQty +	mcQty);	    
	    document.getElementById("strTotalQty"+index).value = finalchmQty;
	    CalculateTotalItemCost(index,mode);
	  
} 


function openItemDivForItem(obj)
{          
      if(obj.value.split("^")[1]!='0')
      {
	             var itemNameObj    = document.getElementsByName("itemName");
	             var  grpNameObj    = document.getElementsByName("groupName");          
	             var divIndexObj    = document.getElementsByName("divIndex");
	             var      endVal    = document.forms[0].TotalLayer.value;
	             var x,y ;
          
		          for(var i = 1; i <= itemNameObj.length ; i++)
				  {
				   
					 if( (obj.value.split("^")[1] == itemNameObj[i].value) && (obj.value.split("^")[0] == grpNameObj[i].value.split("^")[0]))
					 {
					     //alert("divIndex::::"+divIndexObj[i].value+"::TD Index::"+grpNameObj[i].value.split("^")[1]);
					     x = divIndexObj[i].value;
					     y = grpNameObj[i].value.split("^")[1];
					      
					     
					     break;
					     
					 }
				  }
		  
		          for(var i = 1; i <= endVal ; i++)
				  {
					  document.getElementById("DivId"+i).style.display="none";
				  }
				  document.getElementById("DivId"+x).style.display="block";
				 
				 document.getElementsByName("pageIndeCmb")[0].value =  x ;
				
	            
	              var   colorOne = "LIGHTGREEN";
			       					     
				  document.getElementById("tdId1"+y).style.backgroundColor = colorOne; 
				  document.getElementById("tdId2"+y).style.backgroundColor = colorOne;
				  document.getElementById("tdId3"+y).style.backgroundColor = colorOne;
				  document.getElementById("tdId4"+y).style.backgroundColor = colorOne;
				  document.getElementById("tdId5"+y).style.backgroundColor = colorOne;
				  document.getElementById("tdId6"+y).style.backgroundColor = colorOne;
				  document.getElementById("tdId7"+y).style.backgroundColor = colorOne;
				  document.getElementById("tdId8"+y).style.backgroundColor = colorOne;
				   	              
				                				        					
				        	
	              
	   }
	   else
	   {
	              x=1;
	              for(var i = 1; i <= endVal ; i++)
				  {
					  document.getElementById("DivId"+i).style.display="none";
				  }
				  document.getElementById("DivId"+x).style.display="block";
				   document.getElementsByName("pageIndeCmb")[0].value =  x ;
				 
	             
	   }
		  
}

function prevFunction() 
{
          var currentPage = document.forms[0].pageIndeCmb.value;
          var endVal = document.forms[0].TotalLayer.value;
          var  index = parseInt(currentPage);
               index = index -1;
          
	          if (currentPage > 1)
	          {
	              for(var i = 1; i <= endVal ; i++)
				  {
					  document.getElementById("DivId"+i).style.display="none";
				  }
				   document.getElementById("DivId"+index).style.display="block";
	                  document.getElementsByName("pageIndeCmb")[0].value =  index ;
	            
	            
	          } 
	          else
	          {
	            alert("No More Record Left!!!!");
	          } 
	          
	       
	       
             
}
function nextFunction() 
{
         var currentPage = document.forms[0].pageIndeCmb.value;
         var   totalPage = document.forms[0].TotalLayer.value;
        
           var  index = parseInt(currentPage);
               index = index +1;
 
         if(totalPage > index)
         {	          
	             for(var i = 1; i <= totalPage ; i++)
				  {
					  document.getElementById("DivId"+i).style.display="none";
				  }
				  document.getElementById("DivId"+index).style.display="block";
				   document.getElementsByName("pageIndeCmb")[0].value =  index ;
				 
	           
	      }
	      
	      else
	      {
	        if(totalPage == index)
	        {
	              for(var i = 1; i <= totalPage ; i++)
				  {
					  document.getElementById("DivId"+i).style.display="none";
				  }
				  document.getElementById("DivId"+index).style.display="block";	
				   document.getElementsByName("pageIndeCmb")[0].value =  index ;			  
	     	     
	        }
	        else
	        {
	         alert("No More Record Left!!!!");
	        }   
	      }   
        
         
}       

function GetIndex(index,endVal)  // Pagenation  One
{
	
	
	    for (var page = 1; page <= endVal; page++)       // For Loop To Put Normal CSS in All No
        {
          document.getElementById('pg'+page).className = 'pg-normal';
        }
	    var oldPageAnchor = document.getElementById('pg'+index);   // Apply CSS
        oldPageAnchor.className = 'pg-selected';
        
          for(var i = 1; i <= endVal ; i++)
		  {
			  document.getElementById("DivId"+i).style.display="none";
		  }
		  document.getElementById("DivId"+index).style.display="block";
		
			 
}

function openItemDiv(obj)
{   
   var endVal = document.forms[0].TotalLayer.value;
          for(var i = 1; i <= endVal ; i++)
		  {
			  document.getElementById("DivId"+i).style.display="none";
		  }
		  document.getElementById("DivId"+obj.value).style.display="block"; 
}
/** This is the validate function for Indent Item List jsp file
 *  transfer control to the controller 'INSERT' method.  
 */
 
 function validate1()
 {
     
	  var hisValidator = new HISValidator("requestForRoutinePurchase");  
	 
	  hisValidator.addValidation("strIndentPeriod","dontselect=0","Please select a value from Indent Period Combo" );
	  hisValidator.addValidation("strToStore","dontselect=0","Please select a value from To Store Combo" );
	  hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	  var retVal = hisValidator.validate(); 	 
      var countChk = 0;	 	
      var chkObj = document.getElementsByName("strTotalQty");  
    if(retVal)
    {  
      
        for(var x=0;x<chkObj.length;x++)
        {             
        
              if(chkObj[i].length<=0)
              {
         		  countChk = countChk + 1;
         	  }       
        }        
        if (countChk == chkObj.length) 
		{
				alert("Please Select At Least One Drug for Indent !!!!");
				return false;
		}
		else
		{
		  
		  	if(document.forms[0].strApproxAmtTotal.value.length >13)
      		{
      			alert("Maximum Value allowed for Total Demand Amount is  9999999999.99");
      			return false;	
      		}
      		
              var conf = confirm("You Are Going To Save Records");
	          if(conf == true)
	          {
	               var conf1 = confirm("Are you sure !!!");
	               if(conf1 == true)
	               {	              
							  document.forms[0].strFinancialYearPeriod.value  = document.forms[0].strIndentPeriodValue[document.forms[0].strIndentPeriodValue.selectedIndex].text
				              document.forms[0].hmode.value="INSERT";
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
		
    }       
    else
	{
	  return false;
	}   
 
}

/** This is the validate function for Indent Item List jsp file
 *  transfer control to the controller 'INSERT' method.  
 */
 
 function validateModify()
 {
     
	  var hisValidator = new HISValidator("requestForRoutinePurchase");  
	  hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters" );
	  var retVal = hisValidator.validate(); 	 
      var countChk = 0;	 	
      var chkObj = document.getElementsByName("strTotalQty");  
    if(retVal)
    {  
       /*
        for(var x=0;x<chkObj.length;x++)
        {
              if(chkObj[i].value!=0)
              {
                alert("Inside Test");
              }
        
              if(chkObj[i].value=='0' || chkObj[i].value=='' || chkObj[i].value==' ')
              {
         		  countChk = countChk + 1;
         	  }       
        }
        alert("Length:::::"+chkObj.length+":::Blank Item Count:::"+countChk);
        if (countChk == itemParVal.length) 
		{
				alert("Please Select At Least One Drug for Indent !!!!");
				return false;
		}
		else
		{
		  	if(document.forms[0].strApproxAmtTotal.value.length >13)
      		{
      			alert("Maximum Value allowed for Total Demand Amount is  9999999999.99");
      			return false;	
      		}
      		     
                document.forms[0].hmode.value="INSERT";
	            document.forms[0].submit();
		}*/
            if(document.forms[0].strApproxAmtTotal.value.length >13)
      		{
      			alert("Maximum Value allowed for Total Demand Amount is  9999999999.99");
      			return false;	
      		}
      		
      		
      		       var conf = confirm("You Are Going To Save Records");
		          if(conf == true)
		          {
		               var conf1 = confirm("Are you sure !!!");
		               if(conf1 == true)
		               {	              
								    //document.forms[0].strFinancialYearPeriod.value  = document.forms[0].strIndentPeriodValue[document.forms[0].strIndentPeriodValue.selectedIndex].text
					                document.forms[0].hmode.value="MODIFYINDENT";
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



function hideItemDetails(divId)
{
      hide_popup_menu(divId);
}
var parentPopUp = ""; 
 
function getAnnualPurchaseDetails(obj,index)
{    
        parentPopUp = obj;
     // alert(document.getElementById("itemUserValue"+index).value);
        var strUserValue   =  document.getElementById("itemUserValue"+index).value.split("^");
        var strUserValue1  =  document.getElementById("itemParamValue"+index).value.split("^");
        
        var itemName =  strUserValue1[0];
        var poNo    =  strUserValue[12];
        var poDate  =  strUserValue[13];
        var supplierName  =  strUserValue1[5];    
        var recvQty   =  strUserValue1[6];
        var recvDate  =  strUserValue[17];
        var rateUnit  =  strUserValue1[4];
        var currencyName =  strUserValue[28];
       
       var objVal11 = document.getElementById("11");
       
       objVal11.innerHTML = itemName +"-PO Details";
         
       
        var objVal1 = document.getElementById("1");
        
          // objVal1.innerHTML = "-------";
           objVal1.innerHTML = poNo;
            
              
        var objVal2 = document.getElementById("2");
        
        
         // objVal2.innerHTML = "  ----";
         objVal2.innerHTML = poDate;
        
        var objVal3 = document.getElementById("3");
        
         // objVal3.innerHTML = "  ----";
         objVal3.innerHTML = supplierName;
                                   
        var objVal5 = document.getElementById("5");
                
         // objVal5.innerHTML = "  ----";
         objVal5.innerHTML =recvQty;
        
      
        
        var objVal7 = document.getElementById("7");
                
          // objVal7.innerHTML = "------";
          objVal7.innerHTML = rateUnit;
          
                           
			display_popup_menu(parentPopUp,'purchaseDtl','300','');
		
		
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


function CallFunc()
{
  var sum = 0;
  var x = document.getElementsByName("itemUserValue");
  for(var i = 0 ; i < x.length-1; i ++)
  {
    var temp = x[i].value.split("^");
    var finalExpAmt = parseInt(temp[10]);
    var sum1  = parseInt(sum);
    sum = manipulateValue(sum1,finalExpAmt,0);
  }
 var id = document.getElementById("ApproxAmtDivId");
 id.innerHTML =parseInt(sum);
 
}
function cancelToDesk()
{
  var mode="CANCEL";
 
  document.forms[0].hmode.value=mode;
  document.forms[0].submit();
}

function getUnitCombo()
{ 
   var mode="UNITVAL";
   var url="RequestForContigencyCNT.cnt?hmode="+mode+"&modName="+document.forms[0].strDeptCombo.value;
   ajaxFunction(url,"1");
}
function getItemCategory()
{ 
   var mode="UNITVAL1";
   var url="RequestForContigencyCNT.cnt?hmode="+mode+"&modName="+document.forms[0].strStoreNameCmb.value;
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
       objVal.innerHTML = "<select name = 'strUnitCombo' class='comboNormal'>" + res + "</select>";
    }  
    if(mode=="2")
    {
     var objVal = document.getElementById("ItemNameId");
     objVal.innerHTML = "<select name = 'strItemCategoryCmb' id='strItemCategoryCmb' class='comboNormal'>" + res + "</select>";
    }  
}

function initPage()
{
  document.forms[0].strToStore.value        = '0';
  document.forms[0].strGrantType.value      = '0';
  document.forms[0].strGroupIdForItemSearch.value = '0';
  document.getElementById("id1").style.display="none";
  document.getElementById("errMsg").innerHTML = "";
  var id = document.getElementById("ApproxAmtDivId");
  id.innerHTML ="0.00";
  //document.forms[0].hmode.value="unspecified";
  //document.forms[0].submit();
}

function OnLoadFunction()
{
  //document.forms[0].strToStore.value         = document.forms[0].strTmpToStore.value;
  //document.forms[0].strGrantType.value       = document.forms[0].strTmpGrantType.value;
}
//-----------JS FUNCTIONS from JSP file-------------------------//
function goFunc()                //  for CR No. field validation
{
    
        var hisValidator = new HISValidator("requestForContigency");  
	 	hisValidator.addValidation("strCrNo", "req", "CR No. is a Mandatory Field" );
		hisValidator.addValidation("strCrNo", "minlen="+document.forms[0].strCrNo.maxLength,"CR No. must be "+document.forms[0].strCrNo.maxLength+" Digits" );
		var retVal = hisValidator.validate();
		
		document.forms[0].strTmpCrNo.value            = document.forms[0].strCrNo.value;
		document.forms[0].strTmpToStore.value         = document.forms[0].strToStore.value;
		document.forms[0].strTmpGrantType.value       = document.forms[0].strGrantType.value;
		document.forms[0].strTmpItemCatg.value        = document.forms[0].strItemCatg.value;
	    
	    document.forms[0].strCrNo.focus();
		
	    if(retVal)
	    {
	       	  	document.forms[0].hmode.value="GO";
	            document.forms[0].submit();
		}else{
		
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

                        if(flag1)

                        {

                              document.forms[0].hmode.value="GO";

                              document.forms[0].submit();

                        }

                        else

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

