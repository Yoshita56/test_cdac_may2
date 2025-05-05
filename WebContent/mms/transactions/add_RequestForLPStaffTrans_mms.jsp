<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>
<!-- 
/**
 * @author Amit Kumar
 * Date of Creation : 1/5/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
 -->
<html>
<head>
<meta charset=UTF-8">
<title>Request for LP(Patient\Staff)</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/mms.js"></script>

<script language="JavaScript" src="../js/RequestForLpStaff.js"></script>

<script type="text/javascript">

 function invokeCheckQty(mode, index, unitObject)
 {
       gblIsAvailReq = "0";			
		 if( checkQty(index,'strReqQty','strUnitName')){
		 
		 		calculateCost(mode, 'strReqQty', 'strUnitName', 'strCost', index , 'strApproxAmt','0');
		 }
		
		
		
	}	

	
	function getItemSelectPopup()
	{
	  var ToStoreCmb   = document.forms[0].strToStore;
      if(ToStoreCmb.selectedIndex!=0)
       {	
	   		var strModeVal 				= "1" ; 
		var strRequestType              = document.forms[0].strTmpReqType.value;
		var strItemCategory 			= document.forms[0].strTmpItemCatg.value; 
		var strFromStoreId 				= document.forms[0].strTmpStoreName.value;
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strReqQty','strUnitName','strCost');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t','s','t');
		var testFunction                = "CallFunc";
		var arg                         = " ";  
		
		// for mode val 3
		var strMultiRowFetchDataArray 	= new Array('1','4','5','0^strUnitName^invokeCheckQty');
	
		var layerIndex = "1";
	   	   
       // searchItems( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex);
	      searchItemsWithUserFunction ( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg);
	   }
	   else
	   {
	   	  
	       if(ToStoreCmb.selectedIndex == 0)
	       {
	             alert("Plz Select To Store Name !!!!");
	           ToStoreCmb.focus();
	       }
	       
	  return false;
	 }
	
	
	}

 function costReq(){
	if(document.getElementsByName("strCostRequired")[0].value=="1"){
		document.getElementById("costDivReqId").style.display="block";
		document.getElementById("costDivNotReqId").style.display="none";
		document.getElementById("totalCostId").style.display="block";
		
	}else{
		document.getElementById("costDivNotReqId").style.display="block";
		document.getElementById("costDivReqId").style.display="none";
		document.getElementById("totalCostId").style.display="none";
	}
}
</script>

</head>

<body onload="OnLoadFunction(),costReq();">

<html:form action="/transactions/RequestForLPStaffCNT.cnt"
	name="requestForLpStaff"
	type="mms.transactions.controller.fb.RequestForLPStaffFB" method="post">

	<div class="errMsg" id="errMsg"><bean:write
		name="requestForLpStaff" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="requestForLpStaff" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="requestForLpStaff" property="strMsg" /></div>

	<center><tag:tab tabLabel="Request For LP Transaction"
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>

		<tr>
			<td width="25%" class="LABEL">Store Name:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="requestForLpStaff" property="strStoreName" filter="false" /></td>

			<td width="25%" class="LABEL"><font color="red">*</font>Item
			Category:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="requestForLpStaff" property="strItemCatg" filter="false" /></td>


		</tr>
		<tr>
			<td width="25%" class="LABEL">Req Date:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="requestForLpStaff" property="strReqDate" filter="false" /></td>




			<td width="25%" class="LABEL"><font color="red">*</font>Sub
			Store:</td>
			<td width="25%" class="CONTROL"><select class='comboNormal'
				name='strToStore'>
				<bean:write name="requestForLpStaff" property="strToStoreCombo"
					filter="false" />
			</select></td>



		</tr>

		<tr>
			<td class="LABEL" colspan="1">Urgent:</td>
			<td class="CONTROL" colspan="1"><%--
     <b><input type='checkbox' name='strIsNormal' value="0" onClick="ftnTick()">No<input type='checkbox' name='strIsUrgent' value="0" onClick="ftnTick()">Yes</b> &nbsp;&nbsp;
     --%> <input type="radio" name="strIsNormal" value="1"
				checked="checked" />Normal &nbsp;&nbsp; <input type="radio"
				name="strIsNormal" value="0" />Urgent</td>

			<td width="25%" class="LABEL"></td>
			<td width="25%" class="CONTROL"></td>

		</tr>
		<tr class="TITLE">
			<td colspan="4">
			<div id="" style="color: blue;">Staff Details</div>
			</td>
		</tr>

	</table>
	<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
		<tr>
		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>CR No.</td>
			<td colspan="3" class="CONTROL"><crNo:crNo
				value="${requestForLpStaff.strCrNo}"
				js=" onkeypress='return goRetFunc(event);'"></crNo:crNo> <input
				type="image" style="cursor: pointer; "
				title="Issue To Patient Details" align="top"
				src="../../hisglobal/images/Go.png" name="go" value="Go"
				onclick="return goFunc();"></td>
		</tr>
	</table>
	<div id="All" style="display: none;">
	<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
		<tr>
			<td width="5%" class="TITLE" align="center"><input type='hidden'
				name='button1' value="0"> <img
				src="../../hisglobal/images/plus.gif" id="plus1"
				style="display: block; cursor: pointer" onClick="ftn11()"> <img
				src="../../hisglobal/images/minus.gif" id="minus1"
				style="display: none; cursor: pointer" onClick="ftn11()"></td>
			<td colspan="3" class="TITLE" align="left"><b>
			<div id='' style='color: blue;'>Patient Demographic Detail</div>
			</b></td>
		</tr>
	</table>

	<div id="detailsdivid1" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr>
			<bean:write name="requestForLpStaff" property="strPatientDemDtl"
				filter="false" />
		</tr>
	</table>
	</div>

	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="0px">
		<tr>
			<td colspan="3" class="TITLE" width="96%">
			<div id="" style="color: blue;">Provisional Diagnosis</div>
			</td>
			<td width="4%" class="multiLabel"><img
				src="../../hisglobal/images/plus.gif"
				style="cursor: pointer; "
				onclick="addRows(new Array('strIcdCode','strProvisionDiagnosis'),new Array('t','s'),'2','1','R');"
				style="cursor: pointer;"></td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="0px">
		<tr>
			<td colspan="2" class="TITLE">
			<div id='hospitalDiagnosisId' style='display: none; color: blue;'><html:radio
				name="requestForLpStaff" property="strDiagnosisType" value="1"
				style="cursor:pointer;cursor:pointer" onclick="changeMultiRows();">Hospital Diagnosis </html:radio>&nbsp;&nbsp;</div>
			</td>
			<td colspan="2" class="TITLE">
			<div id='icdDiagnosisId' style="display: none; color: blue;"><html:radio
				name="requestForLpStaff" property="strDiagnosisType" value="0"
				style="cursor:pointer;cursor:pointer" onclick="changeMultiRows();">ICD10 Diagnosis</html:radio></div>
			</td>
		</tr>
	</table>

	<div id="id2"></div>
	</div>


	

	<div id="costDivReqId" style="display: none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="TITLE">
			<td colspan="6">
			<div id="" align="right"><img style="cursor: pointer;height: 20px"
					id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"

					onclick='getItemSelectPopup();'></div>
			</td>
		</tr>
		<tr>
			<td width="29%" class="multiLabel">Item/Drug Name</td>
			<td width="19%" class="multiLabel">Avalaible Qty</td>
			<td width="10%" class="multiLabel">Rate/Unit</td>
			<td width="12%" class="multiLabel"><font size="2" color="red">*</font>Req
			Qty</td>

			<td width="20%" class="multiLabel"><font size="2" color="red">*</font>Unit
			</td>
			<td width="10%" class="multiLabel">Cost</td>
		</tr>

	</table>
	</div>
	<div id="costDivNotReqId" style="display: none">

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="TITLE">
			<td colspan="6">
			<div id="" style="color: blue;">Item/Drug Details</div>
			</td>
		</tr>
		<tr>
			<td width="29%" class="multiLabel">Item/Drug Name</td>
			<td width="19%" class="multiLabel">Avalaible Qty</td>
			<td width="15%" class="multiLabel">Rate/Unit</td>
			<td width="17%" class="multiLabel"><font size="2" color="red">*</font>Req
			Qty</td>

			<td width="20%" class="multiLabel"><font size="2" color="red">*</font>Unit
			</td>

		</tr>

	</table>
	</div>


	<div id="id1"></div>
	<div id="totalCostId" style="display: none">
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td width="90%" class="LABEL">
			<div id="" style="color: blue;">Total Approx Cost(Rs):</div>
			</td>
			<td width="10%" class="CONTROL" style="color: red; font-weight: bold">
			<div id='strApproxAmtDivId' align="center">0.00</div>
			<input type="hidden" name="strApproxAmt"></td>
		</tr>
	</table>
	</div>
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="TITLE">
			<td colspan="4"></td>
		</tr>
		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Recommended
			By:</td>
			<td width="50%" class="CONTROL"><select name="strRecmndBy"
				id="strRecmndBy" onChange="">
				<bean:write name="requestForLpStaff" property="strRecmndByCombo"
					filter="false" />
			</select></td>
		</tr>


		<tr>
			<td width="50%" class="LABEL">Remarks</td>
			<td class="CONTROL"><textarea name="strRemarks" cols="20"
				rows="2" id="strRemarks"></textarea></td>
		</tr>


		<tr class="FOOTER">
			<td colspan="2"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>


	<table class="TABLEWIDTH" align="center">
		<tr>
			<td align="center"><img style="cursor: pointer; "
				title="Click to Save Record"
				src="../../hisglobal/images/btn-sv.png"
				onClick=" return validate1();" /> <img
				style="cursor: pointer; " title="Click to Clear Page"
				src="../../hisglobal/images/btn-clr.png" name="clearImg"
				onclick="initPage();"> <img
				style="cursor: pointer; "
				title="Click to Return Main Menu"
				src="../../hisglobal/images/btn-ccl.png"
				onClick="cancel('CANCEL');" /></td>
		</tr>
	</table>

	<input type="hidden" name="hmode" />
	<input type="hidden" name="strConfigCatCode"
		value="${requestForLpStaff.strConfigCatCode}">
	<input type="hidden" name="strStoreTypeId"
		value="${requestForLpStaff.strStoreTypeId}">
	<input type="hidden" name="strTmpStoreName"
		value="${requestForLpStaff.strTmpStoreName}">
	<input type="hidden" name="strTmpCrNo"
		value="${requestForLpStaff.strTmpCrNo}">
	<input type="hidden" name="strComboVal"
		value="${requestForLpStaff.strComboVal}">
	<input type="hidden" name="strTmpGrantType"
		value="${requestForLpStaff.strTmpGrantType}">
	<input type="hidden" name="strTmpItemCatg"
		value="${requestForLpStaff.strTmpItemCatg}">
	<input type="hidden" name="strTmpReqType"
		value="${requestForLpStaff.strTmpReqType}">
	<input type="hidden" name="strGoFlg"
		value="${requestForLpStaff.strGoFlg}">
	<input type="hidden" name="strPath"
		value="${requestForLpStaff.strPath}">
	<input type="hidden" name="strCostRequired"
		value="${requestForLpStaff.strCostRequired}">
	<div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			<div id="searchItemsDtlsDivId" style="display: block;"></div>
			</td>
		</tr>
	</table>
	</div>


	<cmbPers:cmbPers />
</html:form>
<jsp:include page="requestforLPStaff_itemSearchRow.jsp"></jsp:include>
<jsp:include page="admissionadvice_multirow_ipdtrans.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>
</body>
</html>