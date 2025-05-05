<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<!--  Developer : Santosh Chauhan
	  Version	: 1.0	 
	  Date 		: 28-Jun-2013
	  Module 	: Mms
	  Process	: Replacement Condemnation Order
-->

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<meta charset=UTF-8">
<head>

<style type="text/css">

            .pg-normal 
            {
                color: blue;
                font-weight: normal;
                text-decoration: none;
                cursor: pointer;
                
                
            }
            .pg-selected 
            {
                color: red;
                font-weight: bold;
                text-decoration: underline;
                cursor: pointer;
                
            }
            .pg-qualified 
            {
                color: green;
                font-weight: bold;
                text-decoration: underline;
                cursor: pointer;
                
            }
            .multiRPTControl11 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 10px;
	font-style: normal;
	font-weight: normal;
	color: #000000;
	background-color: #E0EBEB;
	height: 12px;
	text-align:left;
}

.textbox1 {
	width: 90px;
}
            </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Replacement Condemnation Order</title>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">

<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script language="Javascript" src="../js/replacementCondemnationOrder_mmstrans.js"></script>

<script src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script type="text/javascript">
function getOtherRemarks(){

	if(document.forms[0].strVerifiedBy.value == '1'){
		document.getElementById('OtherRemarkId').style.display = "none";
		}else{
			document.getElementById('OtherRemarkId').style.display = "none";
			}
}

</script>

<script language="javascript">
		var progressEnd = 12; // set to number of progress <span>'s.
		var progressColor =  '#1B82E6'; // set to progress bar color
		var progressInterval = 100; // set to time between updates (milli-seconds)
		
		var progressAt = progressEnd;
		var progressTimer;
		function progress_clear()
		{
			for (var i = 1; i <= progressEnd; i++) document.getElementById('progress'+i).style.backgroundColor = 'transparent';
			progressAt = 0;
		}
		function progress_update() 
		{
		    
			document.getElementById('showbar').style.visibility = 'visible';
			//document.getElementById('showbarMsg').style.visibility = 'visible';
			progressAt++;
			if (progressAt > progressEnd) 
			    progress_clear();
			else 
			    document.getElementById('progress'+progressAt).style.backgroundColor = progressColor;
			
			progressTimer = setTimeout('progress_update()',progressInterval);
		}
		function progress_stop() 
		{
			clearTimeout(progressTimer);
			progress_clear();
			document.getElementById('showbar').style.visibility = 'hidden';
			//document.getElementById('showbarMsg').style.visibility = 'hidden';
		}
		//progress_update(); // start progress bar

</script>

<script>
var rowId=500;
function addrow() 
{
	
	//alert(document.forms[0].strSearchDrug.value);
	if(document.forms[0].strSearchDrug.value == '')
		{
			return false;
		}
	//alert(document.forms[0].strItemCode.value);
	var temp=document.forms[0].strItemCode[document.forms[0].strItemCode.selectedIndex].value;
	//alert(temp);
	//alert(temp.split("^").length);
	//var len=temp.split("^").length;
	/*if( len = '1');
	{
		alert('Please Select Item');
		return false;
	}*/
	var checkboxvalue=temp.split("^")[5]+'^'+temp.split("^")[6]+'^'+temp.split("^")[7]+'^'+temp.split("^")[8]+'^'+temp.split("^")[9]+'^'+temp.split("^")[10]+'^'+temp.split("^")[2];
	//alert(checkboxvalue);
	var table = document.getElementById("myTable");
    var row = table.insertRow(-1);
    var cell1 = row.insertCell(-1);
    cell1.className ="multiRPTLabel";
    var cell2 = row.insertCell(-1);
    cell2.className ="multiRPTControl11";
    var cell3 = row.insertCell(-1);
    cell3.className ="multiRPTControl11";
    //cell2.innerHTML ='style="text-align:left";
    var cell4 = row.insertCell(-1);
    cell4.className ="multiRPTControl11";
    
    var cell5 = row.insertCell(-1);
    cell5.className ="multiRPTControl";
    var cell6 = row.insertCell(-1);
    cell6.className ="multiRPTControl";
    var cell7 = row.insertCell(-1);
    cell7.className ="multiRPTControl";
    var cell8 = row.insertCell(-1);
    cell8.className ="multiRPTControl";
    var cell9 = row.insertCell(-1);
    cell9.className ="multiRPTControl11";
    var cell10 = row.insertCell(-1);
    cell10.className ="multiRPTControl11";
    var cell11 = row.insertCell(-1);
    cell11.className ="multiRPTControl11";
    var cell12 = row.insertCell(-1);
    cell12.className ="multiRPTControl11";
    //alert(document.forms[0].strcatno.value);
   // alert(document.forms[0].strActionsId.value);
   // alert(temp);
    if(document.forms[0].strActionsId.value=='2'  && document.forms[0].strcatno.value!='10')
        {
    cell1.innerHTML= '<input type="checkbox" class="multiRPTLabel" onclick="chkboxEnable1(this)" name="strExpiryDrugs" id='+"strExpiryDrugs"+rowId+' value='+checkboxvalue+' onclick=chkboxEnable(this);>'; 
        }
    else
        {
    cell1.innerHTML= '<input type="checkbox" class="multiRPTLabel" onclick="chkboxEnable1(this)" name="strExpiryDrugs" id='+"strExpiryDrugs"+rowId+' value='+checkboxvalue+' >';   
        }
    cell2.innerHTML = temp.split("^")[13];
    cell3.innerHTML = temp.split("^")[14];
    cell4.innerHTML = temp.split("^")[0];
    cell5.innerHTML = temp.split("^")[11];
    cell6.innerHTML = temp.split("^")[1];
    cell7.innerHTML = temp.split("^")[2];
    cell8.innerHTML = '<input type="hidden" id='+"hidden"+rowId+' name="totalvalue" value='+ temp.split("^")[2]+' ><input type="text" onchange="calRate(this,'+rowId+');" class="textbox1" name="condemqty" onblur="chkTotalValue(this)" value='+ temp.split("^")[2]+' id='+"condemqty"+rowId+' >';
    cell9.innerHTML = temp.split("^")[12];
    cell10.innerHTML = temp.split("^")[4];
    if(document.forms[0].strActionsId.value=='1')
    cell11.innerHTML = ' <select name="strRetActionType" onchange="getOtherTextBox(this)" id='+"strRetActionType1"+rowId+' disabled class="comboMin" ><option title="Breakage" value="1">Breakage</option><option title="Expiry" value="2">Expiry</option><option title="Other" value="5">Other</option></select> ';
    else
    cell11.innerHTML = ' <select name="strRetActionType"  id='+"strRetActionType1"+rowId+' disabled  class="comboMin" ><option title="Condaminate" value="3">Condaminate</option></select> ';    
    //document.forms[0].strItemCode.value="0";
    cell12.innerHTML = '<div  id='+"itemRemarksDivId1"+rowId+'  style="display:none"><input type="text" style="width: 95%;"   name="strItemRemarks" value="" ></div>';
    
    document.forms[0].strSearchDrug.value="";
    //document.forms[0].strItemCode.value="";
    
    rowId++;
    
}
function deleterow(obj) {
	alert();
	 alert("Row index is: " + obj.rowIndex);
	alert(obj.value);
    document.getElementById("myTable").deleteRow(-+''+obj.value);
}
function myFunction(x) {
    alert("Row index is: " + x.rowIndex);
}

function abc(){
	$(function() {    
		
		var itemList = [];
		$('#strItemCode option').each(function() {
		    itemList.push({ "value" :this.textContent , "data" : this.value });
		});
		$('strSearchDrug').keyup(function(e){
			if(e.keyCode == 13)
		    {
		    	$(this).trigger("enterKey");
		        getDrugNameSelected(suggestion.data);
		       // addrow();
		    }
		});
		//alert(itemList.length);
		$('#strSearchDrug').autocomplete({
			   lookup: itemList,
			   minChars:3,
			   onSelect: function (suggestion) { 
				   //alert(suggestion.data);
				   document.forms[0].strItemCode.value=suggestion.data;
				   addrow();
				   //setSpecDtls(suggestion.data);
			     //getDrugNameSelected(suggestion.data);	    
			   }	    
			 });
			 
			 $('#strSearchDrug').click(function(){	 
			 	$(this).val("");
			 	//alert('abc');
			 	//closeAllDrugProfile();
			 });	

			 $("#strSearchDrug").focus();
		
	  });
	}

function deleteRow(r) {
    var i = r.parentNode.parentNode.rowIndex;
    document.getElementById("myTable").deleteRow(i);
}
function setvalues() 
{
	document.forms[0].strActionsId.value='1';
	document.getElementById("suppid1").style.display='';
	document.getElementById("suppid2").style.display='';
	//document.getElementById("deliveryDate").style.display='none';
	document.getElementById("verifiedby").style.display='';
	document.getElementById("Suggesteddivid").style.display='';
	document.getElementById("Committetypeid").style.display='none';
}
function getdata() 
{
	/*
	    Action Type - 2 - Condemnation
	                  1 - Return
	*/
	    if(document.forms[0].strActionsId.value=='2')
		{
			document.getElementById("suppid1").style.display='none';
			document.getElementById("suppid2").style.display='none';
			//document.getElementById("deliveryDate").style.display='none';
			document.getElementById("verifiedby").style.display='none';
			//document.getElementById("Suggesteddivid").style.display='none';
			document.getElementById("Committetypeid").style.display='';
		}
		else
		{
			document.getElementById("suppid1").style.display='';
			document.getElementById("suppid2").style.display='';
			//document.getElementById("deliveryDate").style.display='';
			document.getElementById("verifiedby").style.display='';
			document.getElementById("Suggesteddivid").style.display='';
			document.getElementById("Committetypeid").style.display='none';
		}
}
function chkboxEnable(obj)
{
	//alert(obj.id);
	//alert(obj.id.substr(14,10));
	//alert(obj.checked);
	if(obj.checked)
	{
		var splitId=obj.id.substr(14,10);
		var txtid="condemqty"+splitId;
		//alert("3");
		var txtid1="strRetActionType"+splitId;
		//document.getElementById(txtid).disabled=false;
		document.getElementById(txtid1).disabled=false;
	}
	else
		{
		var splitId=obj.id.substr(14,10);
		var txtid1="strRetActionType"+splitId;
		//document.getElementById(txtid).disabled=true;
		document.getElementById(txtid1).disabled=true;
		}
}
function chkboxEnable1(obj)
{
	//alert(obj.id);
	//alert(obj.id.substr(14,10));
	//alert(obj.checked);
	if(obj.checked)
	{
		var splitId=obj.id.substr(14,10);
		//var txtid="condemqty"+splitId;
		var txtid1="strRetActionType1"+splitId;
		//document.getElementById(txtid).disabled=false;
		document.getElementById(txtid1).disabled=false;
	}
	else
		{
		var splitId=obj.id.substr(14,10);
		var txtid1="strRetActionType1"+splitId;
		//document.getElementById(txtid).disabled=true;
		document.getElementById(txtid1).disabled=true;
		}
}
function chkboxEnable2(obj)
{
	//alert(obj.id);
	//alert(obj.id.substr(14,10));
	//alert(obj.checked);
	if(obj.checked)
	{
		var splitId=obj.id.substr(14,10);
		var txtid="condemqty"+splitId;
		var txtid1="strRetActionTypeId"+splitId;
		document.getElementById(txtid).disabled=false;
		document.getElementById(txtid1).disabled=false;
	}
	else
		{
		var splitId=obj.id.substr(14,10);
		var txtid="condemqty"+splitId;
		var txtid1="strRetActionTypeId"+splitId;
		document.getElementById(txtid).disabled=true;
		document.getElementById(txtid1).disabled=true;
		}
}
function chkTotalValue(obj)
{
	//alert(obj.id);
	var splitId=obj.id.substr(9,15);
	var hidden="hidden"+splitId;
	var enterqty=document.getElementById(obj.id).value;
	var hiddenqty=document.getElementById(hidden).value;
	//alert(enterqty);
	//alert(hiddenqty);
	if(parseInt(enterqty) > parseInt(hiddenqty))
	{
		alert("Condemnation Qty Should Be Less Or Equal Than Total Qty");
		document.getElementById(obj.id).focus();
		document.getElementById(obj.id).value=hiddenqty;
		return false;
	}
	
}
function cancelorder(obj)
{
	document.forms[0].strStoreId.disabled = false;
	document.forms[0].strcatno.disabled = false;
	document.forms[0].strsupplierno.disabled = false;
	document.forms[0].strActionsId.disabled = false;
	if(confirm(" Do You Want to Cancel the Order ?"))
	{
	 document.forms[0].strOrderHiddenValue.value=obj;
	 document.forms[0].hmode.value="CANCELORDER";
	 document.forms[0].submit();
	}else
		{
		return false;
		}		
}
</script>

</head>

<body onload="hideMenuFrame();setvalues()">
<html:form name="replacementCondemnationOrderTransBean"
	action="/transactions/ReplacementCondemnationOrderTransCNT"
	type="mms.transactions.controller.fb.ReplacementCondemnationOrderTransFB" >
	
	<div class="errMsg" id="errMsg"><bean:write
		name="replacementCondemnationOrderTransBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="replacementCondemnationOrderTransBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="replacementCondemnationOrderTransBean" property="strMsg" /></div>
		
<table align="center">
<tr><td>
<div id="showbar" style="font-size:8pt;padding:2px;border:solid black 1px;visibility:hidden">
<span id="progress1">&nbsp; &nbsp;</span>
<span id="progress2">&nbsp; &nbsp;</span>
<span id="progress3">&nbsp; &nbsp;</span>
<span id="progress4">&nbsp; &nbsp;</span>
<span id="progress5">&nbsp; &nbsp;</span>
<span id="progress6">&nbsp; &nbsp;</span>
<span id="progress7">&nbsp; &nbsp;</span>
<span id="progress8">&nbsp; &nbsp;</span>
<span id="progress9">&nbsp; &nbsp;</span>
<span id="progress10">&nbsp; &nbsp;</span>
<span id="progress11">&nbsp; &nbsp;</span>
<span id="progress12">&nbsp; &nbsp;</span>
</div>
</td></tr>
</table>		
<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr class=FOOTER>
			<td colspan="4">
			<div id="radionbtn1">
			<html:radio property="strActionsId"  name="replacementCondemnationOrderTransBean" value="2" onclick="getdata()" >Condemnation</html:radio>
			<html:radio property="strActionsId" name="replacementCondemnationOrderTransBean" value="1" onclick="getdata();" >Return</html:radio> 
     		</div>
			</td>
		</tr>		
	</table>
	
	
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		
		<tr>
			<td width="10%" colspan="0" class="LABEL"><font color="red">*</font>Store Name</td>
			<td width="20%" colspan="0" class="CONTROL">
			<div id="orderNoDivId">
				<select name="strStoreId"  class="comboMax" onChange="getCatcmb();">
				<option title="select value" value="0">select value</option>
				    <bean:write name="replacementCondemnationOrderTransBean" property="strStoreName" filter="false"></bean:write>
				   </select>
			</div>
			
			</td>
			
			
			<td width="10%" colspan="0" class="LABEL"><font color="red">*</font>Category Name</td>
			<td width="20%" colspan="0" class="CONTROL">
			<div id="catcmbdiv">
				<select name="strcatno"  class="comboMax" onChange="getsuppliername();">
				    <bean:write name="replacementCondemnationOrderTransBean" property="strCatName" filter="false"></bean:write>
				    <option title="select value" value="0">select value</option>
			    </select>
			</div>
			
			</td>
			
			
			<td id="suppid1"  width="10%" colspan="0" class="LABEL"><font color="red">*</font>Supplier Name</td>
			<td id="suppid2" width="20%" colspan="0" class="CONTROL">
			<div id="supplierdiv">
				<select name="strsupplierno"  class="comboMax" onChange="">
				    <bean:write name="replacementCondemnationOrderTransBean" property="strSupplierName" filter="false"></bean:write>
				    <option title="select value" value="select value">select value</option>
			    </select>
			</div>
			
			</td>
			
			

			<td width="20%" class="CONTROL"><div align="left">
			  <img style="cursor: pointer" src="../../hisglobal/images/Go.png" title="Click to see Details" onClick="getPendingOrderDtl();"> 
		     </div>
			</td>
		</tr>		
		
			
	</table>
	<div id="pendingOrderHdrDiv" style="display:none;">
		<table class="TABLEWIDTH" align="center" cellpadding="1px"
			cellspacing="1px">
			<tr>
				<td class="TITLE" colspan="5">
				<div id="divComponentPlusID"  align="left"><img
					src="../../hisglobal/images/plus.gif"
					onclick="hideDiv1('divComponentPlusID'),showDiv1('divComponentMinusID'),showDiv1('hideOrderQDtl');"
					style="cursor: pointer;"> Pending Order Detail(s)</div>
				<div id="divComponentMinusID" style="display:none;" align="left"><img
					src="../../hisglobal/images/minus.gif"
					onclick="hideDiv1('divComponentMinusID'),showDiv1('divComponentPlusID'),hideDiv1('hideOrderQDtl');"
					style="cursor: pointer;"> Pending Order Detail(s)</div>
				</td>
			</tr>
		</table>	
		<div id='hideOrderQDtl' style="display:none;">	
		  <div id ="pendingOrderDtlsDivId"></div>		
		  	
		</div>  
		
		<!-- <table class="TABLEWIDTH" align="center" cellpadding="1px"
			cellspacing="1px">
			<tr style="display: none;">
				<td class="TITLE" colspan="5">
				<div id="divComponentPlusTwoID" style="display:none;" align="left"><img
					src="../../hisglobal/images/plus.gif"
					onclick="hideDiv1('divComponentPlusTwoID'),showDiv1('divComponentMinusTwoID'),showDiv1('hideNosQDtl');"
					style="cursor: pointer;"> NOSQ Drug List(s)</div>
				<div id="divComponentMinusTwoID"  align="left"><img
					src="../../hisglobal/images/minus.gif"
					onclick="hideDiv1('divComponentMinusTwoID'),showDiv1('divComponentPlusTwoID'),hideDiv1('hideNosQDtl');"
					style="cursor: pointer;"> NOSQ Drug List(s)</div>
				</td>
			</tr>
		</table>	 -->
		<div id='hideNosQDtl' style="display: none;">
		    <div id ="nosqDrugDtlsDivId"></div>
		</div>
		
		
		<table class="TABLEWIDTH" align="center" cellpadding="1px"	cellspacing="1px" style="display:none;">
			<tr>
				<td class="TITLE" colspan="5">
				<div id="divComponentPlusOneID"  align="left"><img
					src="../../hisglobal/images/plus.gif"
					onclick="hideDiv1('divComponentPlusOneID'),showDiv1('divComponentMinusOneID'),showDiv1('hideRejectedDtl'),getRejectedDtl();"
					style="cursor: pointer;"> Rejected Drug List</div>
				<div id="divComponentMinusOneID" style="display:none;" align="left"><img
					src="../../hisglobal/images/minus.gif"
					onclick="hideDiv1('divComponentMinusOneID'),showDiv1('divComponentPlusOneID'),hideDiv1('hideRejectedDtl'),getRejectedDtl();"
					style="cursor: pointer;"> Rejected Drug List</div>
				</td>
			</tr>
		</table>	
		<div id='hideRejectedDtl' style="display:none;">	
		  	
		  <div id ="rejectedDrugDtlsDivId"></div>	
		</div> 
		
		
	
	<div id="Suggesteddivid">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
			cellspacing="1px">
			<tr>
				<td class="TITLE" colspan="5">
				<div id="divComponentPlusFourID"  align="left">
				<img src="../../hisglobal/images/plus.gif"
					onclick="hideDiv1('divComponentPlusFourID'),showDiv1('divComponentMinusFourID'),showDiv1('hideSuggesteddtl'),getExpiryDtl();"
					style="cursor: pointer;"> Suggested Drug/Item List(Non Moving Drug/Item List)</div>
				<div id="divComponentMinusFourID" style="display:none;" align="left">
				<img src="../../hisglobal/images/minus.gif"
					onclick="hideDiv1('divComponentMinusFourID'),showDiv1('divComponentPlusFourID'),hideDiv1('hideSuggesteddtl'),getExpiryDtl();"
					style="cursor: pointer;">Suggested Drug/Item List(Non Moving Drug/Item List)</div>
				</td>
			</tr>
		</table>
	<div id='hideSuggesteddtl' style="display:none;">	
		  <div id ="suggestedDtlsDivId"></div>			 
		</div> 
	</div>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px"	cellspacing="1px" style="display:none;">
			<tr>
				<td class="TITLE" colspan="5">
				<div id="divComponentPlusThreeID"  align="left"><img
					src="../../hisglobal/images/plus.gif"
					onclick="hideDiv1('divComponentPlusThreeID'),showDiv1('divComponentMinusThreeID'),showDiv1('hideExpiredRejectedDtl'),getExpiryDtl();"
					style="cursor: pointer;">Item to be Processed</div>
				<div id="divComponentMinusThreeID" style="display:none;" align="left"><img
					src="../../hisglobal/images/minus.gif"
					onclick="hideDiv1('divComponentMinusThreeID'),showDiv1('divComponentPlusThreeID'),hideDiv1('hideExpiredRejectedDtl'),getExpiryDtl();"
					style="cursor: pointer;">Item to be Processed</div>
				</td>
			</tr>
		</table>
		<div id='hideExpiredRejectedDtl' style="display:none;">	
		  <div id ="expiryDtlsDivId"></div>			 
		</div> 
	
	
	</div>
	
	
	
	
		<table class="TABLEWIDTH" align="center" cellpadding="1px"
			cellspacing="1px" style="display:none;">
			<tr>
				<td class="TITLE" colspan="5">
				<div id="divComponentPlusfourID"  align="left"><img
					src="../../hisglobal/images/plus.gif"
					onclick="hideDiv1('divComponentPlusfourID'),showDiv1('divComponentMinusfourID'),showDiv1('IndentedDrugsDtlsDivId'),getBAndSDtl();"
					style="cursor: pointer;"> Indented Drug List</div>
				<div id="divComponentMinusfourID" style="display:none;" align="left"><img
					src="../../hisglobal/images/minus.gif"
					onclick="hideDiv1('divComponentMinusfourID'),showDiv1('divComponentPlusfourID'),hideDiv1('IndentedDrugsDtlsDivId'),getBAndSDtl();"
					style="cursor: pointer;"> Indented Drug List</div>
				</td>
			</tr>
		</table>	
		<div id='hideIndentedDrugDtl' style="display:block;">	
		  <div id ="IndentedDrugsDtlsDivId"></div>			 
		</div>
	<div style="display: none;" id="actionDtlsDivId">		
		<table align="center" cellspacing="1px" cellpadding="1px" border="0"
			class="TABLEWIDTH">
			
				<tr>
					<td width="25%" class="TITLE" colspan="5">
					<div style="display: block;" id="">Action Detail(s)</div>
					</td>
				</tr>
								
				<tr style="display: none;">
					<td width="50%" colspan="2" class="LABEL">
					<div align="right"><font size="2" color="red">*</font> Add Item</div>
					</td>
					<td width="50%" colspan="2" class="CONTROL">
					<input type="text" id="strSearchDrug" placeholder='Enter atleast 3 characters for Item Search' name="strSearchDrug" size="100%" onkeypress="handleEnter(this,event);"/>
					<div id="itemnamediv" style="display: none;">
					<select name="strItemCode" id="strItemCode"  class="comboMax" onChange="">
					 <option title="select value" value="select value">select value</option>
				         <bean:write name="replacementCondemnationOrderTransBean" property="strItemNameValues" filter="false"></bean:write>			    	
			         </select>
					</div>
					</td>
				
				</tr>
										
				<tr style="display: none;">
					<td width="50%" colspan="2" class="LABEL">
					<div id="textId"><font size="2" color="red">*</font>Replacement Qty</div>
					</td>
					<td width="50%" colspan="2" class="CONTROL">
					  <input type="text" name="strReplacementQty" value="" maxlength="8" onkeypress="return validateData(event,7);" class="txtFldNormal"/>
					</td>
					
	
				</tr>
				</table>
				<div id="deliveryDate" style="display: none;" >
					<table align="center" cellspacing="1px" cellpadding="1px" border="0"  class="TABLEWIDTH">
					<tr>
						<td width="50%" colspan="2" class="LABEL">
						<div align="right"><font size="2" color="red">*</font>Next Delivery Date</div>
						</td>
						<td width="50%" colspan="2" class="CONTROL">
						     <dateTag:date name="strDeliveryDate" value="${replacementCondemnationOrderTransBean.strCtDate}"></dateTag:date>
						</td>
						
		
					</tr>
					</table>
		     </div>
	    <table align="center" cellspacing="1px" cellpadding="1px" border="0"
			class="TABLEWIDTH">
						
				<tr id="verifiedby">
					<td width="25%" class="LABEL" ><Font color="red">*</Font>Verified By</td>
					<td width="25%" class="CONTROL">
					<div id="approvedByCmb">
					<select name="strVerifiedBy" class="comboMax" onchange="">
					   <option value="0">Select Value</option>
					</select>
					</div>
					</td>
					<td width="25%" class="LABEL" ><Font color="red">*</Font>Verified Date</td>
					<td width="25%" class="CONTROL"><dateTag:date name="strVerifiedDate" value="${replacementCondemnationOrderTransBean.strCtDate}"></dateTag:date></td>
					
				</tr>
				
				<tr id="verifiedby">
					<td width="25%" class="LABEL" ></td>
					<td width="25%" class="CONTROL">
					<div id="OtherRemarkId" style="display: none;">
					<input type="text" id="" placeholder='' name="strOtherRemarks" size="25%" onkeypress=""/>
					</div>
					</td>
					<td width="25%" class="LABEL" ></td>
					<td width="25%" class="CONTROL"></td>
					
				</tr>
	
				<tr id="Committetypeid">
				<td width="50%" colspan="2" class="LABEL"><Font color="red">*</Font>Committe Type</td>
				<td width="50%" colspan="2" class="CONTROL" >
				
				
				<div id="CommitteTypeCmb">
					<select name="strCommitteType" class="comboMax">
					   <option value="0">Select Value</option>
					</select>
					</div>
					
				</td>
				</tr>
	
	
				<tr>
				<td width="50%" colspan="2" class="LABEL">Remarks(If any)</td>
				<td width="50%" colspan="2" class="CONTROL" ><textarea name="strRemarks" onkeyup="maxLengthRemarks(this,'100')" ></textarea></td>
				</tr>
			
		 </table>
	
	</div>	
	
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr class="FOOTER">
			<td colspan="4" width="25%"><font size="2" color="red">*</font>
			Mandatory Fields</td>
		</tr>
	</table>

	<!-- <table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr>	
				<td align="center"><img
				src="../../hisglobal/images/btn-sv.png"
				style="cursor: pointer; " title="Save Record"
				onClick="return valideateInsert();" /> 
				<img
				style="cursor: pointer; " title="Click to Clear Page"
				src="../../hisglobal/images/btn-clr.png" name="clearImg"
				onclick="cancelPage('unspecified');">
				<img
				src="../../hisglobal/images/btn-ccl.png"
				style="cursor: pointer; " title="Cancel Process"
				onClick="cancelFunc();"></td>
		</tr>
	</table> -->
	<br>
<div align="center" id="">					 
							<a href="#" class="button" id="" onclick=' return valideateInsert();'><span class="save">Save</span></a>
							<a href="#" class="button"	onclick="cancelPage('unspecified');"><span class="clear">Clear</span></a> 
							<a href="#" class="button" onclick="cancelFunc();"><span class="cancel">Cancel</span></a>
					</div>
				
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strCtDate"            value="${replacementCondemnationOrderTransBean.strCtDate}" />
	<input type="hidden" name="strGoFlag"            value="0" />
	<input type="hidden" name="strExpiryRejectedFlg" value="0" />
	<input type="hidden" name="strIndentedDrugFlg" value="0" />
	<input type="hidden" name="strRejectedFlg"       value="0" />
	<input type="hidden" name="strGlbReplacementQty" value="0" />
	<input type="hidden" name="strActionMode"        value="0"/>
	<input type="hidden" name="strActionHiddenValue" value="0"/>
	<input type="hidden" name="strOrderHiddenValue" value="0"/>
	<!-- <input type="hidden" name="strActionsId" value="0"/>
	 -->
	
<cmbPers:cmbPers />
</html:form>

<tag:autoIndex></tag:autoIndex>

</body>
</html>

