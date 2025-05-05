<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<!--  Developer : Santosh Chauhan
	  Version	: 1.0	 
	  Date 		: 28-Jun-2013
	  Module 	: Mms
	  Process	: Return/Condemnation Order
-->

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=UTF-8">
<title>Replacement Condemnation Order</title>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/mms.js"></script>

<script language="Javascript" src="../js/dwh_main_returnAndCondemnationRegister_trans.js"></script>

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
function setvalues() {
	document.forms[0].strActionsId.value='1';
	document.getElementById("suppid1").style.display='';
	document.getElementById("suppid2").style.display='';
}
function getdata() {
	if(document.forms[0].strActionsId.value=='2')
		{
			document.getElementById("suppid1").style.display='none';
			document.getElementById("suppid2").style.display='none';
		}
		else
		{
			document.getElementById("suppid1").style.display='';
			document.getElementById("suppid2").style.display='';
		}
}
</script>

</head>

<body onload="setvalues(),getReport();">
<html:form name="replacementCondemnationRegisterBean" action="/transactions/ReturnAndCondemnationRegisterTransCNT" type="mms.transactions.controller.fb.ReturnAndCondemnationRegisterTransFB" enctype="">
	
<div class="errMsg" id="errMsg"><bean:write name="replacementCondemnationRegisterBean" property="strErr" /></div>
<div class="warningMsg" id="warningMsg"><bean:write name="replacementCondemnationRegisterBean" property="strWarning" /></div>
<div class="normalMsg" id="normalMsg"><bean:write name="replacementCondemnationRegisterBean" property="strMsg" /></div>
	
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
		<tr class="FOOTER">
			<td colspan="4">
				<div id="radionbtn1">
					<html:radio property="strActionsId" name="replacementCondemnationRegisterBean" value="2" onclick="getdata()" >Condemnation</html:radio>
					<html:radio property="strActionsId" name="replacementCondemnationRegisterBean" value="1" onclick="getdata();" >Return</html:radio> 
					<!-- <input type="radio" name="strActionsId" value="2" onclick="getdata()"> Condemnation
					<input type="radio" name="strActionsId" value="1" onclick="getdata()"> Return -->
				</div>
			</td>
		</tr>		
	</table>
		
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="LABEL" colspan="1" width="25%">Store Name</td>
			<td class="CONTROL" colspan="1" width="25%">
				<select name="strStoreId"  class="CONTROL" onchange="getCatcmb();">
				 	<bean:write name="replacementCondemnationRegisterBean" property="strStoreName" filter="false"></bean:write> 
				</select>
			</td>
			
			<td width="10%" colspan="0" class="LABEL"><font color="red">*</font>Category Name</td>
			<td width="20%" colspan="0" class="CONTROL">
				<div id="catcmbdiv">
					<select name="strcatno"  class="comboMax" onChange="getsuppliername();">
					    <bean:write name="replacementCondemnationRegisterBean" property="strCatName" filter="false"></bean:write>
					    <option title="select value" value="0">select value</option>
				    </select>
				</div>
			</td>
			
			<td id="suppid1"  width="10%" colspan="0" class="LABEL"><font color="red">*</font>Supplier Name</td>
			<td id="suppid2" width="20%" colspan="0" class="CONTROL">
				<div id="supplierdiv">
					<select name="strsupplierno"  class="comboMax" onChange="">
					    <bean:write name="replacementCondemnationRegisterBean" property="strSupplierName" filter="false"></bean:write>
					    <option title="select value" value="0">select value</option>
				    </select>
				</div>
			</td>
			
			<td class="CONTROL" colspan="2" width="25%">	
				<div id="imageDiv">
					<html:img src="../../hisglobal/images/Go.png" align="left" style="cursor:pointer" title="Click to see Details" onclick="getReturnOrCondemnDrugListHlp();" />
				</div>			
			</td>
		</tr>	
	</table>	
		
	<div id ="nosqDrugDtlsDivId"></div>	
	
	<div style="display: none;" id="actionDtlsDivId">		
		<table align="center" cellspacing="1px" cellpadding="1px" border="0" class="TABLEWIDTH">
			<tbody>
				<tr>
					<td width="25%" class="TITLE" colspan="4">
						<div style="display: block;" id="">Action Detail(s)</div>
					</td>
				</tr>
				<tr>
					<td width="50%" colspan="2" class="LABEL">
						<div align="right"><font size="2" color="red">*</font>Action </div>
					</td>
					<td width="50%" colspan="2" class="CONTROL">				
						<div id="actionsDivId">
							<select name="strActionId" class="comboMax" onchange="onChangeAction();" >
									<option value="1" title="Return">Return</option>
									<option value="2" title="Condemnation">Condemnation</option>
					    	</select>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
		
	<div style="display: none;" id="returnDtlsDivId">	
	    <table align="center" cellspacing="1px" cellpadding="1px" border="0" class="TABLEWIDTH">
			<tbody>
				<tr>
					<td width="25%" class="TITLE" colspan="4">
						Return/Condemnation Details
					</td>
				</tr>
				<tr>
					<td width="25%" colspan="1" class="LABEL">Return Date</td>
					<td width="25%" colspan="1" class="CONTROL"><dateTag:date name="strReturnDate" value ="${replacementCondemnationRegisterBean.strCtDate}"></dateTag:date></td>
					<td width="25%" colspan="1" class="LABEL">Return To</td>
					<td width="25%" colspan="1" class="CONTROL"><input type="text" name="strReturnTo" ></td>
				</tr>
	
				<tr>
					<td width="25%" colspan="1" class="LABEL">Remarks</td>
					<td width="25%" colspan="1" class="CONTROL" ><textarea name="strRemarks" onkeyup="" ></textarea></td>
						
					<td width="25%" colspan="1" class="LABEL"></td>
					<td width="25%" colspan="1" class="CONTROL"></td>
				</tr>
			</tbody>
		 </table>
	</div>
	
	<div style="display: none;" id="condemnationDtlsDivId">	
	    <table align="center" cellspacing="1px" cellpadding="1px" border="0" class="TABLEWIDTH">
			<tbody>
				<tr>
					<td width="25%" class="TITLE" colspan="4">
						Return/Condemnation Details
					</td>
				</tr>
				<tr>
					<td width="25%" colspan="1" class="LABEL">Condemnation Date</td>
					<td width="25%" colspan="1" class="CONTROL"><dateTag:date name="strCondemnationDate" value ="${replacementCondemnationRegisterBean.strCtDate}"></dateTag:date></td>
					<td width="25%" colspan="1" class="LABEL">Issue to CTF/Condemnation Type</td>
					<td width="25%" colspan="1" class="CONTROL">
						<select name="strCondemnationType" >
							<bean:write name="replacementCondemnationRegisterBean" property="strCondemnationTypeCmbOptions" filter="false" />
						</select>
					</td>
				</tr>
	
				<tr>
					<td width="25%" colspan="1" class="LABEL"><div id="mandDivId" style="display: none;"><font size="2" color="red">*</font></div>Remarks</td>
					<td width="25%" colspan="1" class="CONTROL" ><textarea name="strCondemnationRemarks" onkeyup="')" ></textarea></td>
						
					<td width="25%" colspan="1" class="LABEL"></td>
					<td width="25%" colspan="1" class="CONTROL"></td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
		<tr class="FOOTER">
			<td colspan="4" width="25%"><font size="2" color="red">*</font>
			Mandatory Fields</td>
		</tr>
	</table>

	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
		<tr>	
			<td align="center">
			<br>
			<!-- 	<img src="../../hisglobal/images/btn-sv.png" style="cursor: pointer; " title="Save Record" onClick="return validate1();" /> 
				<img style="cursor: pointer; " title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="clearPage('unspecified');">
				<img src="../../hisglobal/images/btn-ccl.png" style="cursor: pointer; " title="Cancel Process" onClick="cancelFunc();">
				-->
				<a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
				<a href="#" class="button"	onclick="clearPage('unspecified')"><span class="clear">Clear</span></a> 
				<a href="#" class="button" onclick="cancelFunc();"><span class="cancel">Cancel</span></a>
			</td>
		</tr>
		
		<tr>
			<td><font size="2" color="BLUE">
			* In case of Return, minimum of Current Available & Return/Condemnation Qty will be Returned.
			<br>
			* In case of Condemnation, Current Available Qty will be Returned.
			</font>
			</td>
		</tr>
	</table>
	
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strCtDate" value="${replacementCondemnationRegisterBean.strCtDate}" />
	<input type="hidden" name="strTempAction" value="" />
	<input type="hidden" name="strVoucherFlag" value="${replacementCondemnationRegisterBean.strVoucherFlag}" />
	<input type="hidden" name="strHiddenItemDtl" value="${replacementCondemnationRegisterBean.strHiddenItemDtl}" />
	<input type="hidden" name="strTmpStoreId" value="${replacementCondemnationRegisterBean.strTmpStoreId}" />
	<input type="hidden" name="strTmpItemcatId" value="${replacementCondemnationRegisterBean.strTmpItemcatId}" />
	<input type="hidden" name="strTmpitembrandId" value="${replacementCondemnationRegisterBean.strTmpitembrandId}" />
	<input type="hidden" name="strTmpSupplierId" value="${replacementCondemnationRegisterBean.strTmpStoreId}" />
	<input type="hidden" name="strsaveflag" value="${replacementCondemnationRegisterBean.strsaveflag}" />
	
	<div id="blanket" style="display:none;"></div>
	<div class="popUpDiv" id="popUpDiv1" style="display:none;">
	   <table bgcolor="white">
	     <tr>
	      <td>
	         <div id="voucherDivId" style="display:block;"></div>
	      </td>
	     </tr>
	  </table>
	</div>	
	
<cmbPers:cmbPers />
</html:form>

<tag:autoIndex></tag:autoIndex>

</body>
</html>

