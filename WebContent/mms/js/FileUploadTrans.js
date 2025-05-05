
function loadAutocompleteItems()
{
		
	$( "#strSearchDrug" ).keypress(function( event ) {
	if ( event.which == 13 ) {
		event.preventDefault();		
	}	
	});
	
	$('#strSearchDrug').val("");
	displaySelectedDrug("strDrugName");
	
	var itemList = [];			
	$('#strDrugName option').each(function() {
	    itemList.push({ "value" :this.textContent , "data" : this.value });
	});

	$('#strSearchDrug').autocomplete({
	   lookup: itemList,
	   minChars:3,
	   onSelect: function (suggestion) {        
	     getDrugNameSelected(suggestion.data, "strDrugName");
	     getDrugNameSelectedInLeftBox(suggestion.data, "strLeftItemIds");	     
	   }	    
	 });
	 
	 $('#strSearchDrug').click(function(){	 
	 	$(this).val("");
	 });		
}
 
function getDrugNameSelectedInLeftBox(itemId, selectId)
{	
	var flag = 0;
	var sel = document.getElementById(selectId);
	
	for (var i=0; i<sel.options.length; i++) {				
		if ( sel.options[i].value == itemId) 
		{
			sel.selectedIndex = i;			
			flag = 1;
			break;
		}				
	}	
	if(flag == 0)
	{
		sel.selectedIndex=0;
		document.forms[0].strSearchDrug.value = "";
	}	 
	else
	{
		showSelection(sel);
	}   
}

/*
function displayDrugName(rowIndex)
{
	var drugObj = document.getElementById("divItemName");
	
	var itemName = (document.getElementsByName("itemName")[rowIndex-1]).value;
	drugObj.innerHTML = "<font color='red' size='2'><strong>" + itemName + "</strong></font>";
}

function OnLoadFunction()
{
	 var tblObj = document.getElementById("mstTable");
	  	    tblObj.width = document.forms[0].strTableWidth.value + "%";
	 hideMenuFrame();
	 //totalCost(1);
  
}
*/

/** This is the validate function for Indent Item List jsp file
 *  transfer control to the controller 'INSERT' method.  ]
 * mode = 1 called from generate
 * mode = 2 >> called from modify
 */
 
function cancelPrintToDesk()
{
     document.forms[0].hmode.value="CANCEL";
     document.forms[0].submit();   
  
}

function hidePopup(mode)
{
		
		if(mode=='1')
		{		 
          document.getElementById("suppPerformanceDtlsDivIdMain").innerHTML = "";			
		  hide_popup('popUpDivMain');
		} 
		if(mode=='2')
		{		  
		  hide_popup('popUpDiv1');
		} 

}
function displayProgress()
{	
	popup("popUpDiv1" , "200" , "550");
	return false;
}
function initPage1()
{	
	document.forms[0].hmode.value = 'unspecified';
	document.forms[0].submit();
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
	
    if(mode=="5")
    {
       //window.open(URL,name,specs,replace)
       window.open('data:application/vnd.ms-excel,'+ encodeURIComponent(res));
    }
    
    if(mode=="6")
	{ 		           
		var objVal= document.getElementById("leftItemDivId");				
		objVal.innerHTML = "<select id='strLeftItemIds' name='strLeftItemIds' size='6' multiple style='width: 280px' onChange='showSelection(this);'>"+res+"</select>";
		document.getElementById("drugNameDivId").innerHTML = "<select id='strDrugName' name='strDrugName' class='comboMax' >"+res+"</select>";
		loadAutocompleteItems();	
	}	
	
    if(mode=="7")
    {
    	if(res!='NA')
    	{
    		var objVal = document.getElementById("requestDtlDivId");
	      	objVal.innerHTML = res;  
	      	var divHeight=150;
			var initialHeight=716;
			var heightPer = (divHeight*100)/initialHeight; 
		 	var newHeight = parseInt((window.innerHeight * heightPer)/100,10);	
	      	 
	      	fixedHeaderTableTrans("requestDtlDivId", newHeight);	
    	}    	
    	else{
    		document.getElementById("requestDtlDivId").innerHTML	= '';
    	}
    	   getDemandTypeCombo();
    }	    
    if(mode=="8")
	{ 		           
		var objVal= document.getElementById("leftProgDivId");				
		objVal.innerHTML = "<select id='strLeftProgIds' name='strLeftProgIds' size='6' multiple style='width: 280px' onChange='showSelectionProg(this);'>"+res+"</select>";
		document.getElementById("progNameDivId").innerHTML = "<select id='strProgName' name='strProgName' class='comboMax' >"+res+"</select>";
		loadAutocompleteProgs();	
	}
	if(mode=="9")
	{
		var objVal= document.getElementById("strReqTypeDivId");				
		objVal.innerHTML = "<select name='strReqType' class='comboNormal' tabindex='1' onChange='onchangeDemandType(this);'>"+res+"</select>";	
	}		
	if(mode=="10")
	{
		// Delete 
		
		document.getElementById("saveDeleteDivId").style.display = '';
		document.getElementById("saveExtendDivId").style.display = 'none';
		document.getElementById("saveMainFormDivId").style.display = 'none';
		
		document.getElementById("newReqDtlDiv").innerHTML='';
		document.getElementById("newReqDtlDiv").innerHTML = res;
	}
	if(mode=="11")
	{
		//Extend
		document.getElementById("saveDeleteDivId").style.display = 'none';
		document.getElementById("saveExtendDivId").style.display = '';
		document.getElementById("saveMainFormDivId").style.display = 'none';
		
		document.getElementById("newReqDtlDiv").innerHTML='';
		document.getElementById("newReqDtlDiv").innerHTML = res;
	}
	if(mode=="12")
	{
		// View
		document.getElementById("saveDeleteDivId").style.display = 'none';
		document.getElementById("saveExtendDivId").style.display = 'none';
		document.getElementById("saveMainFormDivId").style.display = 'none';
		
		document.getElementById("newReqDtlDiv").innerHTML='';
		document.getElementById("newReqDtlDiv").innerHTML = res;
	}
	if(mode=="13")
	{ 		           
			var objVal= document.getElementById("QuaterlyProgDivId");	
			//alert("res --->"+res);
			objVal.innerHTML = "<select id='strRightProgIds' class='comboMax combojqrycls' name='strRightProgIds' style='width: 280px' onChange='showSelectionProg(this);'>"+res+"</select>";
			document.getElementById("progNameDivId").innerHTML = "<select id='strProgName' name='strProgName' class='comboMax' >"+res+"</select>";
			$(document).ready(function() {
				 
				 $(".combojqrycls").select2({  placeholder: 'Select Value'  }); 

				 
			});
			loadAutocompleteProgs();	
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
	showMenuFrame();
    document.forms[0].hmode.value=mode;
    document.forms[0].target = "_self";
	document.forms[0].submit();
}

function getDemandTypeCombo()
{
	var url = "ProjectedDemandRequestTransCNT.cnt?hmode=DEMANDTYPE&strIndentPeriodValue="+document.forms[0].strIndentPeriodValue.value;
	ajaxFunction(url, "9");
}

function getLeftComboItems(alpha) {		
	document.getElementsByName("strAlphabet")[0].value = alpha;
	var strDrugclass = document.forms[0].strDrugClassCode.value;
	
	document.getElementById(document.forms[0].strSearchIndex.value).style.color="#a80080";
	document.getElementById(document.forms[0].strSearchIndex.value).style.fontSize = "11px";
	
	document.getElementById(alpha + "Id").style.color="red";
	document.getElementById(alpha + "Id").style.fontSize = "16px";
			
	document.forms[0].strSearchIndex.value = alpha + "Id";
	document.getElementById("txtFromLeftMultiSelectComboItem").innerHTML="";	

	var url = "ProjectedDemandRequestTransCNT.cnt?hmode=DRUGNAME&strAlphabet="+ alpha+"&drugClass="+strDrugclass;
	ajaxFunction(url, "6");
}

function showSelection(obj)
{	 
	 var selectedItems="" ;
	 for (var i = 0; i < obj.options.length; i++)
	 {
	 	if (obj.options[ i ].selected) 
	 	{	 		
 				selectedItems	= obj.options[ i ].text; 			
	 	}
	 } 
	 
	 document.getElementById("txtFromLeftMultiSelectComboItem").style.display='';
	 document.getElementById("txtFromLeftMultiSelectComboItem").innerHTML = selectedItems; 	 
}

function transferToRight()
{	
	{
		shiftToRight("strLeftItemIds","strRightItemIds",1);
		$('#strDrugName').html($('#strLeftItemIds').html()); 
		loadAutocompleteItems(); 
	}			
}

function transferToLeft()
{		
	shiftToLeft("strLeftItemIds","strRightItemIds",1);
	$('#strDrugName').html($('#strLeftItemIds').html()); 
	loadAutocompleteItems(); 		
}

function getItemConstraint(obj)
{
	if(document.forms[0].strIsItemFlag.value=='0')
	{
		
		document.forms[0].strIsItemFlag.value='1';
		if(obj.checked == false)
		{
			
			document.getElementById("strRightItemIds").innerHTML = "";
			document.getElementById("itemMultiSelectId").style.display = 'none';
			
							
		}
		else
		{
			
			getLeftComboItems("@");
			document.getElementById("strRightItemIds").innerHTML = "";
			document.getElementById("itemMultiSelectId").style.display = '';
		}
	}
	else
	{
		if(obj.checked == false)
		{
			document.getElementById("itemMultiSelectId").style.display = 'none';
		}
		else
		{
			document.getElementById("itemMultiSelectId").style.display = '';
		}	
	}
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

function getExistingReqDtl()
{
	document.getElementById("requestDtlDivId").innerHTML = "";
			
	if(document.forms[0].strIndentPeriodValue.value !="0")
	{
		var url = "ProjectedDemandRequestTransCNT.cnt?hmode=GETEXISTINGREQDTL&strIndentPeriodValue="+ document.forms[0].strIndentPeriodValue.value;
		ajaxFunction(url, "7");
	}
}

function getLastDateSubmission()
{
	if(document.forms[0].strWhetherDateConstraint.checked == true)
		document.getElementById("lastDateSubmissionDivId").style.display = '';
	else
		document.getElementById("lastDateSubmissionDivId").style.display = 'none';
}
////////////Prog Multi Select Combo

function getLeftComboProgs() {		
	document.getElementById("txtFromLeftMultiSelectComboProg").innerHTML="";	

	var url = "ProjectedDemandRequestTransCNT.cnt?hmode=PROGNAME";
	
	if(document.forms[0].strReqType.value.split("^")[0]=='83')
	{
		ajaxFunction(url, "8");
	}
	else
	{
		ajaxFunction(url, "13");
	}	
	
}


function transferToRightProg()
{	
	{
		shiftToRight("strLeftProgIds","strRightProgIds",1);
		$('#strProgName').html($('#strLeftProgIds').html()); 
		loadAutocompleteProgs(); 
	}			
}

function transferToLeftProg()
{		
	shiftToLeft("strLeftProgIds","strRightProgIds",1);
	$('#strProgName').html($('#strLeftProgIds').html()); 
	loadAutocompleteProgs(); 		
}

function getProgConstraint(obj)
{
	if(document.forms[0].strReqType.value.split("^")[0]=='82')
	{
		getLeftComboProgs();
		document.getElementById("quaterlyProgMultiSelectId").style.display = '';
		document.getElementById("progMultiSelectId").style.display = 'none';
		if(obj.checked == false)
		{
			document.getElementById("quaterlyProgMultiSelectId").style.display = 'none';
		}
	}
	
	if(document.forms[0].strReqType.value.split("^")[0]=='83')
	{	
		if(document.forms[0].strIsProgFlag.value=='0')
		{
			document.forms[0].strIsProgFlag.value='1';
			if(obj.checked == false)
			{
				document.getElementById("strRightProgIds").innerHTML = "";
				document.getElementById("progMultiSelectId").style.display = 'none';
				document.getElementById("quaterlyProgMultiSelectId").style.display = 'none';
			}
			else
			{
				getLeftComboProgs();
				document.getElementById("strRightProgIds").innerHTML = "";
				document.getElementById("progMultiSelectId").style.display = '';
				document.getElementById("quaterlyProgMultiSelectId").style.display = 'none';
			}	
		}
		else
		{
			if(obj.checked == false)
			{
				document.getElementById("progMultiSelectId").style.display = 'none';
				document.getElementById("quaterlyProgMultiSelectId").style.display = 'none';
			}
			else
			{
				document.getElementById("progMultiSelectId").style.display = '';
			}	
		}
	}	
	
	
}

function loadAutocompleteProgs()
{
		
	$( "#strSearchProg" ).keypress(function( event ) {
	if ( event.which == 13 ) {
		event.preventDefault();		
	}	
	});
	
	$('#strSearchProg').val("");
	displaySelectedProg("strProgName");
	
	var progList = [];			
	$('#strProgName option').each(function() {
	    progList.push({ "value" :this.textContent , "data" : this.value });
	});

	$('#strSearchProg').autocomplete({
	   lookup: progList,
	   minChars:3,
	   onSelect: function (suggestion) {        
	     getProgNameSelected(suggestion.data, "strProgName");
	     getProgNameSelectedInLeftBox(suggestion.data, "strLeftProgIds");	     
	   }	    
	 });
	 
	 $('#strSearchProg').click(function(){	 
	 	$(this).val("");
	 });		
}
 
function getProgNameSelectedInLeftBox(progId, selectId)
{	
	var flag = 0;
	var sel = document.getElementById(selectId);
	
	for (var i=0; i<sel.options.length; i++) {				
		if ( sel.options[i].value == progId) 
		{
			sel.selectedIndex = i;			
			flag = 1;
			break;
		}				
	}	
	if(flag == 0)
	{
		sel.selectedIndex=0;
		document.forms[0].strSearchProg.value = "";
	}	 
	else
	{
		showSelection(sel);
	}   
}

function getProgNameSelected(progId, selectId)
{	
	var flag = 0;
	var sel = document.getElementById(selectId);
	
	for (var i=0; i<sel.options.length; i++) {				
		if ( sel.options[i].value == progId) 
		{
			sel.selectedIndex = i;			
			flag = 1;
			break;
		}				
	}	
	if(flag == 0)
	{
		sel.selectedIndex=0;
		document.forms[0].strSearchProg.value = "";
	}
	else
	{
		displaySelectedProg(selectId);		
	}	    
	 
}

function displaySelectedProg(selectId) 
{ 
  	document.getElementById("ProgNameId").innerHTML = $("#"+selectId+" option:selected").text();
} 

function getProgNameSelectedInLeftBox(progId, selectId)
{	
	var flag = 0;
	var sel = document.getElementById(selectId);
	
	for (var i=0; i<sel.options.length; i++) {				
		if ( sel.options[i].value == progId) 
		{
			sel.selectedIndex = i;			
			flag = 1;
			break;
		}				
	}	
	if(flag == 0)
	{
		sel.selectedIndex=0;
		document.forms[0].strSearchProg.value = "";
	}	 
	else
	{
		showSelection(sel);
	}   
}

function showSelectionProg(obj)
{	 
	 var selectedProgs="" ;
	 for (var i = 0; i < obj.options.length; i++)
	 {
	 	if (obj.options[ i ].selected) 
	 	{	 		
 				selectedProgs	= obj.options[ i ].text; 			
	 	}
	 } 
	 if(document.forms[0].strReqType.value.split("^")[0]=='82')
	 {
		 document.getElementById("QuaterlytxtFromLeftMultiSelectComboProg").style.display='';
		 document.getElementById("QuaterlytxtFromLeftMultiSelectComboProg").innerHTML = selectedProgs;
	 }
	 else
	 {	 
		 document.getElementById("txtFromLeftMultiSelectComboProg").style.display='';
		 document.getElementById("txtFromLeftMultiSelectComboProg").innerHTML = selectedProgs;
	 }
}

function onchangeDemandType()
{
	var sel = document.forms[0].strReqType;
	
	
	
	var today = new Date();
	var month = today.getMonth()+1;
	
	if(month==1 || month==2 || month==3 )
	{
		document.getElementById("strDeamandQuater").value = 1;
	}
	else if(month==4 || month==5 || month==6 )
	{
		document.getElementById("strDeamandQuater").value = 2;
	}
	else if(month==7 || month==8 || month==9 )
	{
		document.getElementById("strDeamandQuater").value = 3;
	}
	else if(month==10 || month==11 || month==12 )
	{
		document.getElementById("strDeamandQuater").value = 4;
	}
	
	
	//alert(month);
	
	/*
            Demand Type Combo
            INDENT_TYPE_ID^TOTAL COUNT^ACTIVE COUNT

            If Indent Type Id = 83 and Total Count > 0 then do not allow to raise notification
            If Indent Type Id != 83 and Active Count > 0 then do not allow to raise notification 
      */
	document.getElementsByName("strWhetherProgConstraint")[0].checked = false;
	document.getElementById("quaterlyProgMultiSelectId").style.display = 'none';
	
	
	if(document.forms[0].strReqType.value!='0')
	{
		if(document.forms[0].strReqType.value.split("^")[0]=='83' && parseInt(document.forms[0].strReqType.value.split("^")[1])>0)
		{
			alert("Notification already raised for Annual Demand.\nNo further Annual Demand Notification allowed.");
			document.forms[0].strReqType.value='0';	
			return false;
		}
		
		if(document.forms[0].strReqType.value.split("^")[0]!='83' && parseInt(document.forms[0].strReqType.value.split("^")[2])>0)
		{
			alert("For Supplementary Demand, there could be only one Active Notification.");
			document.forms[0].strReqType.value='0';
			return false;
		}	
		
		if(document.forms[0].strReqType.value.split("^")[0]!='83')
		{					
				if(sel.options[1].value.split("^")[0]=='83' && parseInt(sel.options[1].value.split("^")[2])>0) 
			    {			
					alert("Annual Demand Notification raised for Financial Year" +document.forms[0].strIndentPeriodValue.value+" is Active.\nNo Supplementary Demand Notification can be raised until Annual Demand Notification is Closed or Last Submission Date for Annual Demand Notification has expired.");
					document.forms[0].strReqType.value='0';
					return false;
			    }		
		}
		
		if(document.forms[0].strReqType.value.split("^")[0]=='83')
		{
			if(sel.options[1].value.split("^")[0]!='83' && parseInt(sel.options[1].value.split("^")[1])>0)
			{ 
				alert("As Supplementary Demand Notification has been Raised for the Financial Year "+document.forms[0].strIndentPeriodValue.value+",\nNo Annual Demand Notification can be Generated!");
				document.forms[0].strReqType.value='0';
				return false;
			}		
		}			
		
		if(document.forms[0].strReqType.value.split("^")[0]=='83')
		{	
			
			document.getElementsByName("strWhetherDateConstraint")[0].checked = true;
			getLastDateSubmission();
			document.getElementsByName("strWhetherDateConstraint")[0].disabled = true;
		}
		else
		{
			document.getElementsByName("strWhetherDateConstraint")[0].checked = false;
			getLastDateSubmission();
			document.getElementsByName("strWhetherDateConstraint")[0].disabled = false;
		}
	}	
	
	if(document.forms[0].strReqType.value.split("^")[0]=='82')
		{
			document.getElementsByName("strWhetherProgConstraint")[0].checked = true;
			getLeftComboProgs();
			document.getElementById("quaterlyProgMultiSelectId").style.display = '';
			document.getElementById("lastDateSubmissionDivId").style.display = '';
			document.getElementById("progMultiSelectId").style.display = 'none';
		}
}

function deleteRequestDetails(index)
{
   var len = document.getElementsByName("styleColorDivId").length;   
   for(var i = 0;i<len;i++)
   {
   		document.getElementsByName("styleColorDivId")[i].style.backgroundColor = ""; 
   }
   
   document.getElementsByName("styleColorDivId")[index].style.backgroundColor = "#FFFF99";
   
	//reqNameLabel
	var url = "ProjectedDemandRequestTransCNT.cnt?hmode=deleteDetails&strIndentPeriodValue="+document.forms[0].strIndentPeriodValue.value+
				"&notificationNo="+document.getElementsByName("strHiddenValue")[index].value;
	
	document.forms[0].strIndentPeriodValue.disabled=true;
	ajaxFunction(url, "10");
}


function extendRequestDetails(index)
{
   var len = document.getElementsByName("styleColorDivId").length;   
   for(var i = 0;i<len;i++)
   {
   		document.getElementsByName("styleColorDivId")[i].style.backgroundColor = ""; 
   }
   document.getElementsByName("styleColorDivId")[index].style.backgroundColor = "#FFFF99";
   
	var url = "ProjectedDemandRequestTransCNT.cnt?hmode=extendDetails&strIndentPeriodValue="+document.forms[0].strIndentPeriodValue.value+
				"&notificationNo="+document.getElementsByName("strHiddenValue")[index].value;
	
	document.forms[0].strIndentPeriodValue.disabled=true;
	ajaxFunction(url, "11");
}

function viewRequestDetails(index)
{
   var len = document.getElementsByName("styleColorDivId").length;   
   for(var i = 0;i<len;i++)
   {
   		document.getElementsByName("styleColorDivId")[i].style.backgroundColor = ""; 
   }
   document.getElementsByName("styleColorDivId")[index].style.backgroundColor = "#FFFF99";
   
	var url = "ProjectedDemandRequestTransCNT.cnt?hmode=viewDetails&strIndentPeriodValue="+document.forms[0].strIndentPeriodValue.value+
				"&notificationNo="+document.getElementsByName("strHiddenValue")[index].value;
	
	document.forms[0].strIndentPeriodValue.disabled=true;
	ajaxFunction(url, "12");
}


 function validate1()
 {	
	 
	 var msgAlert = true;
     var saveObj = document.getElementById("saveId");
    


	 
     //alert(filename);
     if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	 {
	 	  saveObj.style.display = ''; 
		  var hisValidator = new HISValidator("fileUploadBean");  
		  hisValidator.addValidation("strLocation",  "req","Attachment is Mandatory");
		  
		  
		  var retVal = hisValidator.validate();
		  hisValidator.clearAllValidations();
		  
		  
		  			if(retVal && msgAlert){

		  				
		  				var filename = document.forms[0].strLocation.value;
		  			     //RE for checking file extension, Allowed extensions are .xls and .xlsx only for Excel file.
		  			     var re = /(\.xls|\.xlsx)$/i;
		  			     if(!re.exec(filename))
		  			     {
		  			    	 alert("File extension not supported.\nKindly upload only Excel file");
		  			    	 return false;
		  			     }
		  				var conf = confirm("You are going to Upload Excel");
				          if(conf == true)
				          {
				               var conf1 = confirm("Are you sure !!!");
				               if(conf1 == true)
				               {
								       //document.forms[0].strIndentPeriodValue.disabled=false;
									   //document.forms[0].strReqType.disabled=false;
									   document.forms[0].hmode.value="SAVE";
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
	 else
	 {
	  	    saveObj.style.display = '';
			return false;
	 } 
}


 function validateDelete()
 {
     var saveObj = document.getElementById("saveId");
     if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	 {
	 	  saveObj.style.display = "none"; 
		  var hisValidator = new HISValidator("projectedDemandBean");  
		  
		  hisValidator.addValidation("strIndentPeriodValue","dontselect=0","Please select Financial Year" );
		  hisValidator.addValidation("strRemarks", "req", "Remarks is mandatory" );
		  hisValidator.addValidation("strRemarks", "maxlen=250", "Remarks should have less than or equal to 250 Characters" );
		  
		  var retVal = hisValidator.validate();
		  hisValidator.clearAllValidations();
		  
				  	if(retVal){
				  		
				  		  var conf = confirm("You Are Going To Delete Record");
				          if(conf == true)
				          {
				               var conf1 = confirm("Are you sure !!!");
				               if(conf1 == true)
				               {
								       document.forms[0].strIndentPeriodValue.disabled=false;
									   document.forms[0].hmode.value="DELETE";
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
	 else
	 {
	  	    saveObj.style.display = '';
			return false;
	 } 
}

function validateExtend()
 {
     var saveObj = document.getElementById("saveId");
     if(saveObj.style.display == "" || saveObj.style.display == "block" || saveObj.style.display == "Block" || saveObj.style.display == "BLOCK")
	 {
	 	  saveObj.style.display = "none"; 
		  var hisValidator = new HISValidator("projectedDemandBean");  
		  
		  hisValidator.addValidation("strIndentPeriodValue","dontselect=0","Please select Financial Year" );
		  var lastSubmissionDate=document.getElementById("strSubmissionLastDate").value;
		  
		  var extendLastDate = "31-"+"03-"+document.forms[0].strIndentPeriodValue.value.split("- ")[1];
		  hisValidator.addValidation("strExtendLastDate","date","Extend Last Date of Submission is a Mandatory Field.");
		  hisValidator.addValidation("strExtendLastDate","dtgt="+document.forms[0].strCtDate.value,"Extend Last Date of Submission Field Should be Greater Than Current Date");
		  hisValidator.addValidation("strExtendLastDate","dtltet="+extendLastDate,"Extend Last Date of Submission Field Should be Less Than or Equal to Financial Year End Date");
		  hisValidator.addValidation("strExtendLastDate","dtgt="+lastSubmissionDate,"Extend Last Date of Submission  Should be Greater Than Previous Last Date of Submission  ");
          hisValidator.addValidation("strRemarks", "req", "Remarks is mandatory" );
		  hisValidator.addValidation("strRemarks", "maxlen=250", "Remarks should have less than or equal to 100 Characters" );
		  
		  var retVal = hisValidator.validate();
		  hisValidator.clearAllValidations();
		  
		  			if(retVal){
				  		
				  		  var conf = confirm("You Are Going To Save Record");
				          if(conf == true)
				          {
				               var conf1 = confirm("Are you sure !!!");
				               if(conf1 == true)
				               {
								       document.forms[0].strIndentPeriodValue.disabled=false;
									   document.forms[0].hmode.value="EXTEND";
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
	 else
	 {
	  	    saveObj.style.display = '';
			return false;
	 } 
}

function cancelPage()
{
	document.forms[0].hmode.value = "CANCELPAGE";
	document.forms[0].submit();
}

function saveBudget()
{
	var DcsBudgetAmount = document.forms[0].strDcsBudget.value;
	var warningMsgVal = document.getElementById("warningMsg").innerHTML;
	//var totalLocalCost = document.forms[0].strTotalLocalHiddenCost.value;  //total local budget cost entered in excel 
	var totalCentralCost = document.forms[0].strTotalCentralHiddenCost.value;  //total central budget cost entered in excel
	//var totalRealizedCost =totalLocalCost + totalCentralCost;
	var totalRealizedCost =totalCentralCost;
	var avaliablebudget = document.forms[0].strAvalHiddenBudget.value;	//total available realized budget
	var avaliableLocalBudget = document.forms[0].strAvailableLocalBudget.value; //total available local budget
	var avaliableCentralBudget = document.forms[0].strAvailableCentralBudget.value;//total available central budget
	var saveObj = document.getElementById("saveId");
	
	//alert("DcsBudgetAmount-->"+DcsBudgetAmount+"<--avaliableLocalBudget-->"+avaliableLocalBudget);
	
	if (parseInt(DcsBudgetAmount)!=parseInt(avaliableLocalBudget))
		{
		alert("DCS Budget Should Be Equal to Local Budget");
		return false ;
		}
	//alert("warningMsgVal-->"+warningMsgVal.length);
	if(warningMsgVal.length > 7)
	{
		alert("Save not Allowed due to invalid file");
		return false;
	}
	
	//alert("totalCentralCost--"+totalCentralCost);
	//alert("avaliableCentralBudget--"+avaliableCentralBudget);
	
	 //if((parseFloat(totalLocalCost) > parseFloat(avaliableLocalBudget)) || (parseFloat(totalCentralCost) > parseFloat(avaliableCentralBudget)))
	if((parseFloat(totalCentralCost) > parseFloat(avaliableCentralBudget)))
	 {
		/* if((parseFloat(totalLocalCost) > parseFloat(avaliableLocalBudget)) && (parseFloat(totalCentralCost) > parseFloat(avaliableCentralBudget)))
			{
			alert("Total Local Budget Cost for all Stores is [ "+ parseFloat(totalLocalCost)  +" Rs.] > Avaliable Budget ["+parseFloat(avaliableLocalBudget)+" Rs. ]" +
					" And Total Central Budget Cost for all Stores is [ "+ parseFloat(totalCentralCost)  +" Rs.] > Avaliable Budget ["+parseFloat(avaliableCentralBudget)+" Rs. ]\nKindly Upload Excel With Less or Equal Budget to Available Budget");
			return false;
		 	}
		 	else if(parseFloat(totalLocalCost) > parseFloat(avaliableLocalBudget))
			{
			 	alert("Total Local Budget Cost for all Store is  [ "+ parseFloat(totalLocalCost)  +" Rs.] > Avaliable Budget ["+parseFloat(avaliableLocalBudget)+" Rs. ]\nKindly Upload Excel With Less or Equal Budget to Available Budget");
			 	return false;
			}
		 else*/ 
			 if (parseFloat(totalCentralCost) > parseFloat(avaliableCentralBudget))
			 {
			 	alert("Total Central Budget Cost for all Stores is [ "+ parseFloat(totalCentralCost)  +" Rs.] > Avaliable Budget ["+parseFloat(avaliableCentralBudget)+" Rs. ]\nKindly Upload Excel With Less or Equal Budget to Available Budget");
			 	return false;
			 }
		 else
			 {
			 	alert("Total Budget Cost for all Stores is [ "+ parseFloat(totalRealizedCost)  +" Rs.] > Avaliable Budget ["+parseFloat(avaliablebudget)+" Rs. ]\nKindly Upload Excel With Less or Equal Budget to Available Budget");
			 	return false;
			 }
	 }	
	else
		{
	
		var conf = confirm("You Are Going To Save Budget Details");
	         if(conf == true)
	         {
	              var conf1 = confirm("Are you sure !!!");
	              if(conf1 == true)
	              {
	            	//var len = document.getElementsByName("setStrHtmlCodeHidden").length; 
	            	//alert(document.getElementsByName("setStrHtmlCodeHidden")[len-1].value);
					document.forms[0].hmode.value = "SaveBudgetDtl";
					//alert(document.forms[0].hmode.value);
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

