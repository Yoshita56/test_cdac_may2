 function getAjaxResponse(res, mode) 
 {
		var err = document.getElementById("errMsg");
		var temp = res.split("####");
		if(temp[0] == "ERROR")
		{
			err.innerHTML = temp[1];
			return;
		}
		var objVal;
		if (mode == "1") 
		{	//   alert(res);   
			document.forms[0].strStoreId.disabled = true;
			document.forms[0].strcatno.disabled = true;
			document.forms[0].strsupplierno.disabled = true;
			objVal = document.getElementById("nosqDrugDtlsDivId");			
			objVal.innerHTML = res;
			 document.getElementById("nosqDrugDtlsDivId").style.display='block';			
			 
			 			
		}		
		 if(mode=="2")
	    {
	     	
	     	 var objVal2 = document.getElementById("voucherDivId");
	     	 objVal2.innerHTML = res;
	     	 popup('popUpDiv1', '130', '200');
	     	 document.forms[0].strVoucherFlag.value ="0";
	     	
	    }
		 if(mode=="3")
		    {
			 var objVal = document.getElementById("catcmbdiv");
			 objVal.innerHTML = "<select name = 'strcatno' class='comboMax' onchange='getsuppliername()' >" + res + "</select>";
		    }
		 if(mode=="4")
		    {
		 var objVal = document.getElementById("supplierdiv");
			objVal.innerHTML = "<select name = 'strsupplierno' class='comboMax' onchange='' >" + res + "</select>";
		    }
  } 
	  
function clearPage(mode) {
	document.forms[0].hmode.value = mode;
	document.forms[0].submit();
}

  
function cancelPage() {
	document.forms[0].hmode.value = "CANCELPAGE";
	document.forms[0].submit();
}

function getReturnOrCondemnDrugListHlp()
{
	document.getElementById("radionbtn1").style.display='none';
	var hisValidator = new HISValidator("replacementCondemnationRegisterBean");               
    hisValidator.addValidation("strStoreId", "dontselect=0","Please Select a Store Name !!");
    hisValidator.addValidation("strcatno", "dontselect=0","Please Select Item Category !!");
    if( document.forms[0].strActionsId.value == '1')
    {
    hisValidator.addValidation("strsupplierno", "dontselect=0","Please Select Supplier Name !!"); 
    
    }
    var retVal = hisValidator.validate();
    hisValidator.clearAllValidations(); 
    if (retVal) 
    {
    	var mode="getReturnOrCondemnDrugListHlp";
        var url="ReturnAndCondemnationRegisterTransCNT.cnt?hmode="+mode
        +"&storeId="+document.forms[0].strStoreId.value+"&strActionsId="+document.forms[0].strActionsId.value+"&strcatno="+document.forms[0].strcatno.value+"&strsupplierno="+document.forms[0].strsupplierno.value;                  
        ajaxFunction(url,"1");        
    }
  
}

function onCheckRadioButton(strHiddenVal,index)
{		
   var passValue = document.getElementById("strNosqDrugs"+index).value;
  
  document.forms[0].strHiddenItemDtl.value  = passValue;
  //alert(document.forms[0].strHiddenItemDtl.value);
   var strTemp;   
   document.forms[0].strTempAction.value= passValue.split('^')[7];
   
  
   if(passValue!=null && passValue!="")
   {
   	    
   	    
   	    strTemp = passValue.split('^')[4];
   	    
   }
   
   document.getElementById("actionDtlsDivId").style.display="block";      	
   
   
			
	if(document.forms[0].strTempAction.value=='1')
	{
	document.getElementById("actionsDivId").innerHTML =	"<select name='strActionId' class='comboMax' onchange='onChangeAction();' >"+
												"<option value='1' title='Return'>Return</option>"+
												"<option value='2' title='Condemnation'>Condemnation</option>"+
												"</select>";				
	}
	else
	{
		document.getElementById("actionsDivId").innerHTML = "<select name='strActionId' class='comboMax' onchange='onChangeAction();' >" +
												 "<option value='2' title='Condemnation'>Condemnation</option>"+
												 "</select>";
	}
   
   document.getElementById("actionDtlsDivId").style.display='';
   
  	onChangeAction();
}

function onChangeAction()
{
	
	var strTempAction =  document.forms[0].strTempAction.value;
	if(strTempAction=='1' && document.getElementsByName("strActionId")[0].value=='2')
	{
		document.getElementById("mandDivId").style.display='block';
	}
	
	
		if(document.getElementsByName("strActionId")[0].value=='1')
		{
			document.getElementById("returnDtlsDivId").style.display='';
			document.getElementById("condemnationDtlsDivId").style.display='none';
		}   			      	
   		else
   		{	
   			document.getElementById("returnDtlsDivId").style.display='none';
   			document.getElementById("condemnationDtlsDivId").style.display='';
   		}	     
}	  	  

function onStoreChange()
{
		document.getElementById("returnDtlsDivId").style.display='none';
   		document.getElementById("condemnationDtlsDivId").style.display='none';
   		
   		document.getElementById("nosqDrugDtlsDivId").style.display="none"; 
   		
   		document.getElementById("actionDtlsDivId").style.display="none";
   		
   		document.getElementById("mandDivId").style.display='none';
   		
}




function validate1()
{
	var checkbox = document.getElementsByName('strNosqDrugs');
	var ln = 0;
	for(var i=0; i< checkbox.length; i++) {
	    if(checkbox[i].checked)
	       {ln++;}
	}
	if(ln<=0)
		{
		alert('Please Select Drug/Item From Order Details');
		return false;
		}
	var count=0;
	document.forms[0].strStoreId.disabled = false;
	document.forms[0].strcatno.disabled = false;
	document.forms[0].strsupplierno.disabled = false;
	var hisValidator = new HISValidator("replacementCondemnationRegisterBean");
	hisValidator.addValidation("strStoreId", "dontselect=0","Please Select a Store Name !!");
    hisValidator.addValidation("strcatno", "dontselect=0","Please Select Item Category !!");
    if( document.forms[0].strActionsId.value == '1')
    {
    hisValidator.addValidation("strsupplierno", "dontselect=0","Please Select Supplier Name !!"); 
    
    }
    var retVal = hisValidator.validate();
    hisValidator.clearAllValidations(); 
	if(retVal)
	{
		if(true)
	        {
	        	if(	confirm("You Are Going To Save Data"))				
				{
					if(confirm(" Are You Sure You Want to Save ?"))
					{						   
						document.forms[0].hmode.value="INSERT";
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
	        	alert("Please Select Atleast One Order Detail")	;
	        	return false;
	        }	 
	}     	        
	
}

function getReport()
{	  
	//alert( document.forms[0].strVoucherFlag.value);
	//alert( document.forms[0].strsaveflag.value);
	
	 var voucherFlag    = document.forms[0].strsaveflag.value;
	

//alert(voucherFlag);
	 if(parseInt(voucherFlag)==1)
	 { 
		 var storeId       = document.forms[0].strTmpStoreId.value;
		 var itemcatno       = document.forms[0].strTmpItemcatId.value;
		 var itembrandid       = document.forms[0].strTmpitembrandId.value;
		 var supplierid       = document.forms[0].strTmpSupplierId.value;
	   var mode="VOUCHERPRINT";
	   var url="ReturnAndCondemnationRegisterTransCNT.cnt?hmode="+mode+
	   "&storeId="+storeId+"&itemcatno="+itemcatno+"&itembrandid="+itembrandid+"&supplierid="+supplierid;
	   
	   ajaxFunction(url,"2");
	 }  		
}


function hideTransferPopup(mode)
{
         document.getElementById("voucherDivId").innerHTML = "";			
		  hide_popup('popUpDiv1');
}

function printDataForTransfer() 
{

	newwin = window.open('', 'printwin',
			'left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n')
	newwin.document.write('<script>\n');
	newwin.document.write('function chkstate(){ \n');
	// newwin.document.write('if(document.readystate=="complete" ||
	// document.readystate=="undefined"){\n');
	newwin.document.write('window.close();\n');
	// newwin.document.write('}\n');
	// newwin.document.write('else{\n');
	// newwin.document.write('setTimeout("chkstate()",2000)\n');
	// newwin.document.write('}\n');
	newwin.document.write('}\n');
	newwin.document.write('function print_win(){\n');
	newwin.document.write('window.print();\n');
	newwin.document.write('chkstate();\n');
	newwin.document.write('}\n');

	newwin.document.write('<\/script>\n');
	newwin.document.write('</HEAD>\n');
	newwin.document.write('<BODY onload="print_win()">\n');
	
	newwin.document.write(document.getElementById('voucherDivId').innerHTML);
	
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}	

function getCatcmb()
{
	//alert('1');
	var mode="GETCATCMB";
    var url="ReturnAndCondemnationRegisterTransCNT.cnt?hmode="+mode
     +"&storeId="+document.forms[0].strStoreId.value;
    ajaxFunction(url,"3");
}
function getsuppliername()
{
	//alert(document.forms[0].strcatno.value);
	var mode="GETSUPPLIERCMB";
    var url="ReturnAndCondemnationRegisterTransCNT.cnt?hmode="+mode
     +"&storeId="+document.forms[0].strStoreId.value+"&catcode="+document.forms[0].strcatno.value;
    ajaxFunction(url,"4");
}