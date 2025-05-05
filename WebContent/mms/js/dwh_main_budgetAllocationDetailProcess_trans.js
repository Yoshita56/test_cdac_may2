function getBudgetDetails()		// On Click Of GO Button of main page
{
	
	if(document.getElementsByName("strDrugWareHouseName")[0].value=="0")
	{
		alert("Select Drug Warehouse");
		document.getElementsByName("strDrugWareHouseName")[0].focus();
		return false;
	}
	
	if( (document.getElementsByName("strDWHSubTypeId")[0].value=="0")	&& ((document.getElementsByName("strSubStoreId")[0].value=="0")) )
	{
		alert("Select Atleast one of the Sub-Store Type or Sub-Store or Both");
		document.getElementsByName("strSubStoreId")[0].focus();
		return false;
	}
	else
	{
		
		
		
		var strStoreId = document.getElementsByName("strDrugWareHouseName")[0].value;
		document.forms[0].strStoreId.value	= strStoreId;
		
		var strSubStoreId = document.getElementsByName("strSubStoreId")[0].value;
		
			//alert("strSubStoreId"+strSubStoreId);
			
		document.forms[0].strSubStoreId.value	= strSubStoreId;
		
		
		if (document.getElementsByName("strSubStoreId")[0].value=="0")
		{
			document.getElementById("newBudgetDetailDivId").style.display=''; 
		}
		else
		{
			document.forms[0].strGoDetailsFlag.value	= '1'; //strGoDetailsFlag means onclick of Go button
		
			document.forms[0].hmode.value = "PREVBUDGETDETAILS";	
			 
			document.forms[0].submit();
		}		
		
       	
	}
}


function showBudgetDetails()
{
	
		if(document.forms[0].hmode.value == "PREVBUDGETDETAILS")
		{
		document.getElementById("budgetDetailsId1").style.display="";
		document.getElementById("budgetDetailsId2").style.display="";
		document.getElementById("budgetDetailsId3").style.display="";	
		}
		
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
		if ((fld.value.charAt(i) != '0') && (fld.value.charAt(i) != decSep)) break;
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



// For saving the data on Add Page
function validate1(mode)
{   

     
         var hisValidator = new HISValidator("budgetAllocationDetailProcessTransFB");
         
          hisValidator.addValidation("strFinancialYear","dontselect=0","Please Select Financial Year");
          hisValidator.addValidation("strDrugWareHouseName","dontselect=0","Please Select Drug Warehouse Name");		
         // hisValidator.addValidation("strSubStoreId","dontselect=0","Please Select Sub Store");
          
	      if(document.forms[0].strSubStoreId.value=='0')
	      {
	      	hisValidator.addValidation("strNewAllocatedBudget","req", "Current Year New Budget Allocated is a Mandatory Field" );
	      }
    	                
         else
         {
         	hisValidator.addValidation("strModifiedAllocatedBudget","req", "Current Year New Budget Allocated is a Mandatory Field" );
         	
         	
         }
     	     
          
          
          //hisValidator.addValidation("strNewAllocatedBudget","numgt="+document.forms[0].strLastAllocatedBudget.value, "New Allocated Budget Should be greater than Last Allocated Budget" );
          
          
          
         /*
           
           if(document.forms[0].strLastAllocatedBudget.value>0)
          {
          	hisValidator.addValidation("strRemarks","req", "Remarks is a Mandatory Field" );
          }
          */
          
          if(document.forms[0].strSubStoreId.value!='0')
          {
          	hisValidator.addValidation("strRemarks","req", "Remarks is a Mandatory Field" );
          	hisValidator.addValidation("strRemarks", "maxlen=250", "Remarks should have less than or equal to 250 Characters" );
          }
          
          
 
            
 		 var retVal = hisValidator.validate(); 

          if(retVal)
          {
          		if(document.forms[0].strSubStoreId.value=='0')
          		{
          			var subStoreType = document.forms[0].strDWHSubTypeId[document.forms[0].strDWHSubTypeId.selectedIndex].text
          			if(confirm("You are going to Save the Budget For All the "+ subStoreType + " for the Selected DDW Name."))
          			{
	          			if (confirm("Are You sure you want to save ?") )
	          			{
	          				document.forms[0].hmode.value = "SAVE";                 	   
	                        document.forms[0].submit();
	          			}
          			}	
          			else
			        {
			            return false;
			        }
          		}
          		else
          		{
          			if(checkCurrentYrTotalBudgetAvailable()==false)
          			{
          				return false;
          			};
          			
          			var subStoreId = document.forms[0].strSubStoreId[document.forms[0].strSubStoreId.selectedIndex].text
          			if(confirm("You are going to Save the Budget For Sub-Store : "+ subStoreId + " for the Selected DDW Name."))
          			{
          				if (confirm("Are You sure you want to save ?") )
	          			{
	          				document.forms[0].hmode.value = "SAVE";                 	   
	                        document.forms[0].submit();
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


function cancelPage()
{
	document.forms[0].hmode.value = "CANCELPAGE";
	document.forms[0].submit();
}


function clearMsg(strTmp)
{
	document.getElementsByName("strStoreId")[0].value="0"
	document.forms[0].hmode.value = strTmp;
	document.forms[0].submit();
}


//To open View Page
function openViewPage()
{
	viewData(document.forms[0]);
	document.getElementsByName("strViewCheckBox")[0].checked=false;
}

function viewData(form1) //View Page
{

	var chkObj = document.getElementsByName("strViewCheckBox")[0];
	
	

	if (chkObj.checked != true) 
	{
		
		return false;
	}
	
	else
		{
			url = 'BudgetAllocationDetailProcessTransCNT.cnt?hmode=GETVIEWPAGE';
			window.open(url, "popupWindow",	"width=800,height=450,top=250,left=350,scrollbars=yes");
		}
	
}



function getBudgetDetailsView()		//View Page
{
	
	if(document.getElementsByName("strFinancialYear")[0].value=="0")
	{
		alert("Select Financial Year");
		document.getElementsByName("strFinancialYear")[0].focus();
		return false;
	}
	
	if(document.getElementsByName("strDrugWareHouseName")[0].value=="0")
	{
		alert("Select Drug Warehouse");
		document.getElementsByName("strDrugWareHouseName")[0].focus();
		return false;
		
	}
		var storeId			=	document.forms[0].strDrugWareHouseName.value;// ddwId
		var dwhSubTypeId	=	document.forms[0].strDWHSubTypeId.value;
		var subStoreId		=	document.forms[0].strSubStoreId.value;
		
				
		var url="BudgetAllocationDetailProcessTransCNT.cnt?hmode=BUDGETDETAILSVIEW&storeId="+storeId+"&financialYear="+document.forms[0].strFinancialYear.value
					+"&dwhSubTypeId="+dwhSubTypeId
					+"&subStoreId="+subStoreId;
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
    	
       var objVal = document.getElementById("budgetDetailsViewId");
       objVal.innerHTML = res;
       
	    document.getElementById("budgetDetailsViewId").style.display='';
    }  
    if(mode=="2")
    {
       var objVal = document.getElementById("subStoreDivId");
       objVal.innerHTML = "<select name ='strSubStoreId' class='comboMax' onchange='clearBudgetFields();' >"+ res + "</select>";
				
				
		if(document.getElementById("budgetDetailsId1")!=null)
	    document.getElementById("budgetDetailsId1").style.display="none";
	    
	    if(document.getElementById("budgetDetailsId2")!=null)
		document.getElementById("budgetDetailsId2").style.display="none";
		
		if(document.getElementById("budgetDetailsId3")!=null)
		document.getElementById("budgetDetailsId3").style.display="none";	
		
			if(document.getElementById("budgetDetailsId4")!=null)
	    document.getElementById("budgetDetailsId4").style.display="none";	
	    
	    if(document.getElementById("budgetDetailsId5")!=null)
	    document.getElementById("budgetDetailsId5").style.display="none";	
    } 
   
}


function clearViewData()
{
		document.getElementById("budgetDetailsViewId").innerHTML="";
		
		if(document.forms[0].strRemarks)
		document.forms[0].strRemarks.value="";
			
}

function clearData()
{
	
	if(document.getElementById("budgetDetailsViewId")!=null)
	    document.getElementById("budgetDetailsViewId").style.display="none";
	
	if(document.getElementById("prevBudgetDtlsDivId")!=null)
	    document.getElementById("prevBudgetDtlsDivId").style.display="none";
	
	if(document.getElementById("newBudgetDetailDivId")!=null)
	    document.getElementById("newBudgetDetailDivId").style.display="none";
	    
		if(document.getElementById("budgetDetailsId1")!=null)
	    document.getElementById("budgetDetailsId1").style.display="none";
	    
	    if(document.getElementById("budgetDetailsId2")!=null)
		document.getElementById("budgetDetailsId2").style.display="none";
		
		if(document.getElementById("budgetDetailsId3")!=null)
		document.getElementById("budgetDetailsId3").style.display="none";		
	
	document.getElementsByName("strDWHSubTypeId")[0].value = '0';
	document.getElementsByName("strSubStoreId")[0].value = '0';
	
	if(document.forms[0].strModifiedAllocatedBudget)
	document.getElementsByName("strModifiedAllocatedBudget")[0].value='';
	
	if(document.forms[0].strNewAllocatedBudget)
	    document.getElementsByName("strNewAllocatedBudget")[0].value='';
			  
		if(document.getElementsByName("strDrugWareHouseName")[0].value!="0" )
		{
			//alert("Select Drug Warehouse");
			
			
			
			//document.getElementsByName("strDrugWareHouseName")[0].focus();
			//return false;
			getSubStore();  
			
		}		
		
}

function getSubStore()
{
	clearBudgetFields();
	
	var url="BudgetAllocationDetailProcessTransCNT.cnt?hmode=DWHSUBTYPECMB&storeId="+document.forms[0].strDrugWareHouseName.value+"&dwhSubTypeId="+document.forms[0].strDWHSubTypeId.value;
   		 ajaxFunction(url,"2");   
}


function clearBudgetFields()
{
	if(document.getElementById("budgetDetailsViewId")!=null)
	    document.getElementById("budgetDetailsViewId").style.display="none";
	
	
	if(document.getElementById("newBudgetDetailDivId")!=null)
	    document.getElementById("newBudgetDetailDivId").style.display="none";
	    
	    if(document.getElementById("prevBudgetDtlsDivId")!=null)
	    document.getElementById("prevBudgetDtlsDivId").style.display="none";
	    
	    if(document.getElementById("modifiedBudgetDtlsDivId")!=null)
	    document.getElementById("modifiedBudgetDtlsDivId").style.display="none";
	
	if(document.getElementById("budgetDetailsId1")!=null)
	    document.getElementById("budgetDetailsId1").style.display="none";
	    
	    if(document.getElementById("budgetDetailsId2")!=null)
		document.getElementById("budgetDetailsId2").style.display="none";
		
		if(document.getElementById("budgetDetailsId3")!=null)
		document.getElementById("budgetDetailsId3").style.display="none";
		
		if(document.getElementById("budgetDetailsId4")!=null)
	    document.getElementById("budgetDetailsId4").style.display="none";	
	    
	    if(document.getElementById("budgetDetailsId5")!=null)
	    document.getElementById("budgetDetailsId5").style.display="none";
	    
	    
	    if(document.forms[0].strModifiedAllocatedBudget)
	    document.getElementsByName("strModifiedAllocatedBudget")[0].value='';
	    
	    if(document.forms[0].strNewAllocatedBudget)
	    document.getElementsByName("strNewAllocatedBudget")[0].value='';
	
}

function checkCurrentYrTotalBudgetAvailable()
{
	//alert("hello");
	
	
	
	var modifiedAllocatedBudget 		= parseFloat(document.getElementsByName("strModifiedAllocatedBudget")[0].value);
	var previousYearRemainingBudget  = parseFloat(document.getElementsByName("strPreviousYearRemainingBudget")[0].value);
	var currentYearUtilizedBudget  = parseFloat(document.getElementsByName("strCurrentYearUtilizedBudget")[0].value);
	
	if(isNaN(modifiedAllocatedBudget+ previousYearRemainingBudget))
	{
		alert("Enter Current Year New Budget Allocated Properly in the Number format only");
		document.getElementsByName("strModifiedAllocatedBudget")[0].value = '';
		document.getElementById("currentYrTotalBudgetAvailableDivId").innerHTML = '';
		return false;
	}
	else
	{
		document.getElementById("currentYrTotalBudgetAvailableDivId").innerHTML= modifiedAllocatedBudget+ previousYearRemainingBudget;	
	}
		
	
	
	
	if(	isNaN(modifiedAllocatedBudget+ previousYearRemainingBudget-currentYearUtilizedBudget) )
	{
		alert("Enter Current Year New Budget Allocated Properly in the Number format only");
		document.getElementsByName("strModifiedAllocatedBudget")[0].value = '';
		document.getElementById("currentYrTotalUnutilizedBudgetAvailableDivId").innerHTML = '';
		return false;
	}
	else
	{
		if(	(modifiedAllocatedBudget+ previousYearRemainingBudget-currentYearUtilizedBudget)< 0 )
		{
			alert("Enter Current Year New Budget Allocated Properly such that A+D-C is Greater Than Equal to 0");
			
			return false;
		}
		else
		{
			document.getElementById("currentYrTotalUnutilizedBudgetAvailableDivId").innerHTML= modifiedAllocatedBudget+ previousYearRemainingBudget-currentYearUtilizedBudget;
		}
	}
	
	
}	


function getCurrentYrTotalBudgetAvailable()
{
	
	
	if(document.getElementsByName("strModifiedAllocatedBudget")[0].value != '')
	{
		if( parseInt(document.getElementsByName("strModifiedAllocatedBudget")[0].value)<0 ) 
		{
			alert("Enter Current Year New Budget Allocated(D) in Number Format and Greater than 0");
			document.getElementsByName("strModifiedAllocatedBudget")[0].focus();
			return false;
		}
		else
		{
				var modifiedAllocatedBudget 		= parseFloat(document.getElementsByName("strModifiedAllocatedBudget")[0].value);
			var previousYearRemainingBudget  = parseFloat(document.getElementsByName("strPreviousYearRemainingBudget")[0].value);
			var currentYearUtilizedBudget  = parseFloat(document.getElementsByName("strCurrentYearUtilizedBudget")[0].value);
			
			if(isNaN(modifiedAllocatedBudget+ previousYearRemainingBudget))
			{
				alert("Enter Current Year New Budget Allocated Properly in the Number format only");
				document.getElementsByName("strModifiedAllocatedBudget")[0].value = '';
				document.getElementById("currentYrTotalBudgetAvailableDivId").innerHTML = '';
				return false;
			}
			else
			{
				document.getElementById("currentYrTotalBudgetAvailableDivId").innerHTML= modifiedAllocatedBudget+ previousYearRemainingBudget;	
			}
				
			
			
			
			if(	isNaN(modifiedAllocatedBudget+ previousYearRemainingBudget-currentYearUtilizedBudget) )
			{
				alert("Enter Current Year New Budget Allocated Properly in the Number format only");
				document.getElementsByName("strModifiedAllocatedBudget")[0].value = '';
				document.getElementById("currentYrTotalUnutilizedBudgetAvailableDivId").innerHTML = '';
				return false;
			}
			else
			{
				document.getElementById("currentYrTotalUnutilizedBudgetAvailableDivId").innerHTML= modifiedAllocatedBudget+ previousYearRemainingBudget-currentYearUtilizedBudget;		
			}
		}
		
	}
}


function isNumber(event) {
	var nkey;
	
	if (window.event)
	{
		nkey = window.event.keyCode;
		
	}
	else
	{
		nkey = event.which;	
	}
		
		
		if( (nkey==null) || (nkey==0) || (nkey==8) || (nkey==9) || (nkey==13) || (nkey==27) ||  (nkey>47 && nkey<58) )
		{
			//alert(nkey);
			
			getCurrentYrTotalBudgetAvailable();
			
			return !isNaN(parseFloat(nkey)) && isFinite(nkey);	
		}
		else
		{
			//alert("Not Valid"+nkey);
			//var tempStr = document.getElementsByName("strModifiedAllocatedBudget")[0].value;			
			//document.getElementsByName("strModifiedAllocatedBudget")[0].value = tempStr;
				
			
			return false;	
		}		
		
  
}


