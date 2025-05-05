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


<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css"
	rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css"
	rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css"
	rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet"
	type="text/css">
<link
	href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css"
	rel="stylesheet" type="text/css">
	
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript"
	src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>



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
<script language="Javascript" src="../js/replacementCondemnationOrder_mmstransNEW.js"></script>

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
function addrow() {
	
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
    //cell2.innerHTML ='style="text-align:left";
    var cell3 = row.insertCell(-1);
    cell3.className ="multiRPTControl11";
    
    var cell4 = row.insertCell(-1);
    cell4.className ="multiRPTControl";
    var cell5 = row.insertCell(-1);
    cell5.className ="multiRPTControl";
    var cell6 = row.insertCell(-1);
    cell6.className ="multiRPTControl";
    var cell7 = row.insertCell(-1);
    cell7.className ="multiRPTControl";
    var cell8 = row.insertCell(-1);
    cell8.className ="multiRPTControl11";
    var cell9 = row.insertCell(-1);
    cell9.className ="multiRPTControl11";
    var cell10 = row.insertCell(-1);
    cell10.className ="multiRPTControl11";
    var cell11 = row.insertCell(-1);
    cell11.className ="multiRPTControl11";
    //alert(document.forms[0].strcatno.value);
   // alert(document.forms[0].strActionsId.value);
    
    if(document.forms[0].strActionsId.value=='2'  && document.forms[0].strcatno.value!='10')
        {
    cell1.innerHTML= '<input type="checkbox" class="multiRPTLabel" onclick="chkboxEnable1(this)" name="strExpiryDrugs" id='+"strExpiryDrugs"+rowId+' value='+checkboxvalue+' onclick=chkboxEnable(this);>'; 
        }
    else
        {
    cell1.innerHTML= '<input type="checkbox" class="multiRPTLabel" onclick="chkboxEnable1(this)" name="strExpiryDrugs" id='+"strExpiryDrugs"+rowId+' value='+checkboxvalue+' >';   
        }
    cell2.innerHTML = temp.split("^")[13];
    cell3.innerHTML = temp.split("^")[0];
    cell4.innerHTML = temp.split("^")[11];
    cell5.innerHTML = temp.split("^")[1];
    cell6.innerHTML = temp.split("^")[2];
    cell7.innerHTML = '<input type="hidden" id='+"hidden"+rowId+' name="totalvalue" value='+ temp.split("^")[2]+' ><input type="text" onchange="calRate(this,'+rowId+');" class="textbox1" name="condemqty" onblur="chkTotalValue(this)" value='+ temp.split("^")[2]+' id='+"condemqty"+rowId+' >';
    cell8.innerHTML = temp.split("^")[12];
    cell9.innerHTML = temp.split("^")[4];
    if(document.forms[0].strActionsId.value=='1')
    cell10.innerHTML = ' <select name="strRetActionType" onchange="getOtherTextBox(this)" id='+"strRetActionType1"+rowId+' disabled class="browser-default custom-select" ><option title="Breakage" value="1">Breakage</option><option title="Expiry" value="2">Expiry</option><option title="Other" value="5">Other</option></select> ';
    else
    cell10.innerHTML = ' <select name="strRetActionType"  id='+"strRetActionType1"+rowId+' disabled  class="browser-default custom-select" ><option title="Condaminate" value="3">Condaminate</option></select> ';    
    //document.forms[0].strItemCode.value="0";
    cell11.innerHTML = '<div  id='+"itemRemarksDivId1"+rowId+'  style="display:none"><input type="text" style="width: 95%;"   name="strItemRemarks" value="" ></div>';
    
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
function setvalues() {
	document.forms[0].strActionsId.value='1';
	document.getElementById("suppid1").style.display='';
	document.getElementById("suppid2").style.display='';
	//document.getElementById("deliveryDate").style.display='none';
	document.getElementById("verifiedby").style.display='';
	document.getElementById("Suggesteddivid").style.display='';
	document.getElementById("Committetypeid").style.display='none';
}
function getdata() {
	if(document.forms[0].strActionsId.value=='2')
		{
			document.getElementById("suppid1").style.display='none';
			document.getElementById("suppid2").style.display='none';
			//document.getElementById("deliveryDate").style.display='none';
			document.getElementById("verifiedby").style.display='none';
			document.getElementById("Suggesteddivid").style.display='none';
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
	action="/transactions/ReplacementCondemnationOrderTransCNTNEW"
	type="mms.transactions.controller.fb.ReplacementCondemnationOrderTransFB">
	
	
	<div class="viewport" id="nonPrintable">
			<div class="container-fluid">

				 
			<div class="row justify-content-center">
					<div class="col-sm-12">
						<br>
						<div class="prescriptionTile">
						<div class="row rowFlex reFlex">
						<div class="col-md-12" align="center">
						<div class="errMsg" id="errMsg"><bean:write
								name="replacementCondemnationOrderTransBean" property="strErr" /></div>
						<div class="warningMsg" id="warningMsg"><bean:write
								name="replacementCondemnationOrderTransBean" property="strWarning" /></div>
						<div class="normalMsg" id="normalMsg"><bean:write
								name="replacementCondemnationOrderTransBean" property="strMsg" /></div>
						</div></div>
							<div class="row rowFlex reFlex">
								<div class="legend2" id='nonPrintableLegend2'>
									<button type="button"
										class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn"
										onclick="cancelFunc();">
										<i class="fas fa-ban iround" title="Cancel"></i>
									</button>
									<button type="button" class=" btn btn-secondary btn-circle"
										onclick="cancelPage('unspecified');"
										style="background: #b9b9b9; border-color: #b9b9b9; margin-top: 0.25rem !important;">
										<img src="/HIS/hisglobal/images/clear3.png" title="Clear"
											style="width: 23px; color: #fff;">
									</button>
									<button type="button" id="savebutton"
										class="float-right btn btn-outline-success mt-1 btn-circle"
										tabindex='2' onclick=' return valideateInsert();'
										name="patientAdmissionModiTransBean"
										style="background-color: #5cb85c;">
										<i class="fa fa-download iround" title="Save"></i>
									</button>
								</div>
							</div>
	
	
						<div class="row rowFlex reFlex">
								<div class="col-md-12" align="center">
									<div id="radionbtn1">
									<html:radio property="strActionsId" name="replacementCondemnationOrderTransBean" value="2" onclick="getdata()" >Condemnation</html:radio>
								&nbsp;&nbsp;	<html:radio property="strActionsId" name="replacementCondemnationOrderTransBean" value="1" onclick="getdata();" >Return</html:radio> 
								</div>
								</div>
							</div>
	

	
	
	
	
		
<!-- <table align="center">
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
 -->
<%--  <table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
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
	 --%>
	
	<br>
	<div class="row rowFlex reFlex">
		<div class="col-md-1half px-4">Store Name</div>
		<div class="col-md-2"><div id="orderNoDivId">
				<select name="strStoreId"  class="browser-default custom-select" onChange="getCatcmb();">
				<option title="select value" value="0">select value</option>
				    <bean:write name="replacementCondemnationOrderTransBean" property="strStoreName" filter="false"></bean:write>
				   </select>
			</div></div>
		<div class="col-md-1half px-4"><font color="red">*</font>Category Name</div>
		<div class="col-md-2"><div id="catcmbdiv">
				<select name="strcatno"  class="browser-default custom-select" onChange="getsuppliername();">
				    <bean:write name="replacementCondemnationOrderTransBean" property="strCatName" filter="false"></bean:write>
				    <option title="select value" value="0">select value</option>
			    </select>
			</div></div>
		<div class="col-md-1half px-4" id="suppid1"><font color="red">*</font>Supplier Name</div>
		<div class="col-md-2" id="suppid2"><div id="supplierdiv">
				<select name="strsupplierno"  class="browser-default custom-select" onChange="">
				    <bean:write name="replacementCondemnationOrderTransBean" property="strSupplierName" filter="false"></bean:write>
				    <option title="select value" value="select value">select value</option>
			    </select>
			</div></div>
		<div class="col-md-1"><a class="btn btn-sm btn-success" href="#" onClick="getPendingOrderDtl();" title="Click to see Details" style="font-size:1rem;">GO <i class="fas fa-angle-double-right"></i></a></div>
	</div>
	
	
			
			

	<div id="pendingOrderHdrDiv" style="display:none;">
		<div class="row rowFlex reFlex">
				<div class="col-md-3 px-4">
				<div id="divComponentPlusID" style="display: block"><i class="fas fa-plus-circle" onclick="hideDiv1('divComponentPlusID'),showDiv1('divComponentMinusID'),showDiv1('hideOrderQDtl');"></i>&nbsp;Pending Order Detail(s)</div>
				<div id="divComponentMinusID" style="display: none"><i class="fas fa-minus-circle" onclick="hideDiv1('divComponentMinusID'),showDiv1('divComponentPlusID'),hideDiv1('hideOrderQDtl');"></i>&nbsp;Pending Order Detail(s)</div>
			
			</div>
	</div>
	<div id='hideOrderQDtl' style="display:none;">	
	<div class="row">
		<div class="col-md-12 px-4">
			
		  <div id ="pendingOrderDtlsDivId"></div>		
		  	
		</div></div> 
	</div>

	
	<div class="row">
			<div class="col-md-3 px-4" style="display:none;">
				<div id="divComponentPlusOneID" style="display: block"><i class="fas fa-plus-circle" onclick="hideDiv1('divComponentPlusOneID'),showDiv1('divComponentMinusOneID'),showDiv1('hideRejectedDtl'),getRejectedDtl();"></i>&nbsp; Rejected Drug List</div>
				<div id="divComponentMinusOneID" style="display: none"><i class="fas fa-minus-circle" onclick="hideDiv1('divComponentMinusOneID'),showDiv1('divComponentPlusOneID'),hideDiv1('hideRejectedDtl'),getRejectedDtl();"></i>&nbsp; Rejected Drug List</div>
			
			</div>
	</div>
	<div id='hideNosQDtl' style="display: none;">
		 <div class="row"><div class="col-md-12 px-4">   <div id ="nosqDrugDtlsDivId"></div></div></div>
		</div>
		
		
		<div id="Suggesteddivid">
		<div class="row">
		
			<div class="col-md-5 px-4">
				<div id="divComponentPlusFourID" style="display: block"><i class="fas fa-plus-circle" onclick="hideDiv1('divComponentPlusFourID'),showDiv1('divComponentMinusFourID'),showDiv1('hideSuggesteddtl'),getExpiryDtl();"></i>&nbsp;Suggested Drug/Item List(Non Moving Drug/Item List)</div>
				<div id="divComponentMinusFourID" style="display: none"><i class="fas fa-minus-circle" onclick="hideDiv1('divComponentMinusFourID'),showDiv1('divComponentPlusFourID'),hideDiv1('hideSuggesteddtl'),getExpiryDtl();"></i>&nbsp;Suggested Drug/Item List(Non Moving Drug/Item List)</div>
			
			</div></div>
			<div id='hideSuggesteddtl' style="display:none;">	
		  		<div class="row"><div class="col-md-12 px-4">	<div id ="suggestedDtlsDivId"></div>	</div>	</div>	 
			</div> 
			
		</div>
		
			<div class="row">
			<div class="col-md-3 px-4">
				<div id="divComponentPlusThreeID" style="display: block"><i class="fas fa-plus-circle" onclick="hideDiv1('divComponentPlusThreeID'),showDiv1('divComponentMinusThreeID'),showDiv1('hideExpiredRejectedDtl'),getExpiryDtl();"></i>&nbsp;Item to be Processed</div>
				<div id="divComponentMinusThreeID" style="display: none"><i class="fas fa-minus-circle" onclick="hideDiv1('divComponentMinusThreeID'),showDiv1('divComponentPlusThreeID'),hideDiv1('hideExpiredRejectedDtl'),getExpiryDtl();"></i>&nbsp;Item to be Processed</div>
			
			</div></div>
			<div id='hideExpiredRejectedDtl' style="display:none;">	
		  		<div class="row"><div class="col-md-12 px-4">	<div id ="expiryDtlsDivId"></div>	</div></div>		 
		</div> 
			
		<div id='hideRejectedDtl' style="display:none;">	
		  	
		  <div id ="rejectedDrugDtlsDivId"></div>	
		</div> 
		
		</div>	
		
				
		<div class="row" style="display:none;">
			<div class="col-md-3 px-4">
				<div id="divComponentPlusfourID" style="display: block"><i class="fas fa-plus-circle" onclick="hideDiv1('divComponentPlusfourID'),showDiv1('divComponentMinusfourID'),showDiv1('IndentedDrugsDtlsDivId'),getBAndSDtl();"></i>&nbsp;Indented Drug List</div>
				<div id="divComponentMinusfourID" style="display: none"><i class="fas fa-minus-circle" onclick="hideDiv1('divComponentMinusfourID'),showDiv1('divComponentPlusfourID'),hideDiv1('IndentedDrugsDtlsDivId'),getBAndSDtl();"></i>&nbsp;Indented Drug List</div>
			
			</div></div>
				
		<div id='hideIndentedDrugDtl' style="display:block;">	
		  <div id ="IndentedDrugsDtlsDivId"></div>			 
		</div>
		
		
		<br>
		<div class="row">
			<div class="col-md-12"><hr></div>
		</div>
	<div style="display: none;" id="actionDtlsDivId">
	<div class="row">
		<div class="col-md-12 px-4"><i class="fas fa-info-circle" style="font-size:16px;"></i>&nbsp;<label style="font-size:16px;">Action Detail(s)</label></div>
	</div>
	<div class="row rowFLex reFlex">
			<div class="col-md-4 px-4"></div>
			<div class="col-md-2"><font size="2" color="red">*</font> Add Item</div>
			<div class="col-md-6"><input class="form-control" type="text" id="strSearchDrug" placeholder='Enter atleast 3 characters for Item Search' name="strSearchDrug" size="100%" onkeypress="handleEnter(this,event);"/>
			<div id="itemnamediv" style="display: none;">
					<select name="strItemCode" id="strItemCode"  class="browser-default custom-select" onChange="">
					 <option title="select value" value="select value">select value</option>
				    <bean:write name="replacementCondemnationOrderTransBean" property="strItemNameValues" filter="false"></bean:write>
			    	
			    </select>
					</div>
			
			</div>
	
		<div class="row rowFlex reFlex" style="display: none;">
			<div class="col-md-2 px-4"><div id="textId"><font size="2" color="red">*</font>Replacement Qty</div></div>
			<div class="col-md-2"><input class="form-control" type="text" name="strReplacementQty" value="" maxlength="8" onkeypress="return validateData(event,7);" class="txtFldNormal"/></div>
			<div id="deliveryDate" style="display: none;" ><div class="col-md-2"><font size="2" color="red">*</font>Next Delivery Date</div>
			<div class="col-md-2"><input  name="strDeliveryDate"
											class="form-control datepicker"
											value="${replacementCondemnationOrderTransBean.strCtDate}"
											style="color: rgba(113, 111, 111, 0.87);"></div></div>
		
		</div>
				
				
	</div>				
						
				     
	<div class="row" id="verifiedby">
		<div class="col-md-2 px-4" ><Font color="red">*</Font>Verified By</div>
		<div class="col-md-2"><div id="approvedByCmb">
					<select name="strVerifiedBy" class="browser-default custom-select" onchange="">
					   <option value="0">Select Value</option>
					</select>
					</div>
					</div>
		<div class="col-md-2"><Font color="red">*</Font>Verified Date</div>
		<div class="col-md-2"><input name="strVerifiedDate"
											class="form-control datepicker"
											value="${replacementCondemnationOrderTransBean.strCtDate}"
											style="color: rgba(113, 111, 111, 0.87);"></div>
		<div class="col-md-2">Remarks(If any)</div>
		<div class="col-md-2"><textarea class="form-control" name="strRemarks" onkeyup="maxLengthRemarks(this,'100')"  ></textarea></div>
	</div>
	
	<div class="row" id="verifiedby">
		<div class="col-md-2 px-4" ></div>
		<div class="col-md-2 px-4" ><div id="OtherRemarkId" style="display: none;">
					<input type="text" id="" placeholder='' name="strOtherRemarks" size="25%" onkeypress=""/>
					</div></div>
	
	</div>
		     
	<div class="row" id="Committetypeid">
		<div class="col-md-2 px-4" ><Font color="red">*</Font>Committee Type</div>
		<div class="col-md-2 px-4" ><div id="CommitteTypeCmb">
					<select name="strCommitteType" class="broswer-default custom-select">
					   <option value="0">Select Value</option>
					</select>
					</div></div>
		<div class="col-md-2" >Remarks (If Any)</div>
		<div class="col-md-6" ><textarea class="form-control" name="strRemarks" onkeyup="maxLengthRemarks(this,'100')"  ></textarea></div>
		
	
	</div>
	</div>	
	
	
	<div class="row"><div class="col-md-12" align="right"><font size="2" color="red">*</font>
			Mandatory Fields
		</div></div>

	<br>
				
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
</div></div>
</div>
</div>
</div>

</html:form>

<tag:autoIndex></tag:autoIndex>
 <script type="text/javascript">

$('.datepicker').each(function(){
    $(this).datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
});
var today=new Date();
var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
var mmm=arr[today.getMonth()];
var hrs=today.getHours();
var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
$('.datepicker').val(dd);

</script>
</body>
</html>


