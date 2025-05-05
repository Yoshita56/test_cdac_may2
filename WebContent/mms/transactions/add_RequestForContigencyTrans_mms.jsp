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
 * Date of Creation : 05/5/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
 -->
<html>
<head>
<meta charset=UTF-8">
<title>Request for Contigency</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
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



<script language="JavaScript" src="../js/RequestForContigency.js"></script>

<script type="text/javascript">

		
	gblIsAvailReq = "0";		
		function invokeCheckQty(mode, index, unitObject)
	    {
		
		  if(checkQty(index,'strReqQty','strUnitName'))
		  {
		    calculateCost(mode, 'strReqQty', 'strUnitName', 'strCost', index , 'strApproxAmt','0');
		  }
		 
	    }	
		
		
    
	function getItemSelectPopup()
	{
	  var GrantTypeCmb = document.forms[0].strGrantType;
 	  var ToStoreCmb   = document.forms[0].strToStore;
     //if(GrantTypeCmb.selectedIndex != 0 && ToStoreCmb.selectedIndex!=0)
      if(GrantTypeCmb.selectedIndex != 0)
       {	
	   // var data                      = (document.forms[0].strStoreName.value).split("^"); 
		var strModeVal 					= "1" ; 
		var strRequestType              = document.forms[0].strTmpReqType.value;
		var strItemCategory 			= document.forms[0].strTmpItemCatg.value; 
		var strFromStoreId 				= document.forms[0].strTmpStoreName.value;
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strReqQty','strUnitName','strCost');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t','s','t');
		var testFunction                = "CallFunc";
		var arg                         = " ";  
		
		var strMultiRowFetchDataArray 	= new Array('1','4','5','0^strUnitName^invokeCheckQty');
		
	
		    
	    var layerIndex = "1";
	
       // searchItems( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex);
	      searchItemsWithUserFunction ( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg);
	    
	   }
	   else
	   {
	   	  
	       if(GrantTypeCmb.selectedIndex == 0)
	       {
	            alert("Plz Select Grant Type !!!!");
	           GrantTypeCmb.focus();
	       }
	       else
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

<html:form action="/transactions/RequestForContigencyCNT.cnt"
	name="requestForContigency"
	type="mms.transactions.controller.fb.RequestForContigencyFB"
	method="post">

	<div class="errMsg" id="errMsg"><bean:write
		name="requestForContigency" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="requestForContigency" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="requestForContigency" property="strMsg" /></div>

	<center><tag:tab tabLabel="Request For Contigency"
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>

		<tr>
			<td width="25%" class="LABEL">Store Name:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="requestForContigency" property="strStoreName" filter="false" /></td>

			<td width="25%" class="LABEL"><font color="red">*</font>Item
			Category:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="requestForContigency" property="strItemCatg" filter="false" />

			</td>

		</tr>
		<tr>
			<td width="25%" class="LABEL">Req Date:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="requestForContigency" property="strReqDate" filter="false" />
			</td>



			<td width="25%" class="LABEL"><font color="red">*</font>Grant
			Type:</td>
			<td width="25%" class="CONTROL"><select class='comboNormal'
				name='strGrantType'>
				<bean:write name="requestForContigency" property="strGrantTypeCombo"
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

			<td width="25%" class="LABEL"><font color="red">*</font>Sub
			Store:</td>
			<td width="25%" class="CONTROL"><select class='comboNormal'
				name='strToStore'>
				<bean:write name="requestForContigency" property="strToStoreCombo"
					filter="false" />
			</select></td>

		</tr>
	</table>

	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="TITLE">
			<td colspan="6">
			<div align="right"><img style="cursor: pointer;height: 20px"
					id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png" 
					onclick='getItemSelectPopup();'></div>
			</td>
		</tr>
		
	</table>

	<div id="costDivReqId" style="display: none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px" bgcolor="black"
		cellspacing="1px">
		<tr>
			<td width="29%" class="multiLabel">Item/Drug Name</td>

			<td width="19%" class="multiLabel">Available Qty</td>
			<td width="10%" class="multiLabel">Approx Rate/Unit</td>
			<td width="12%" class="multiLabel"><font size="2" color="red">*</font>Req
			Qty</td>
			<td width="20%" class="multiLabel"><font size="2" color="red">*</font>Unit
			Name</td>
			<td width="10%" class="multiLabel">Approx Cost</td>
		</tr>

	</table>
	</div>
	<div id="costDivNotReqId" style="display: none">

	<table class="TABLEWIDTH" align="center" cellpadding="1px" bgcolor="black"
		cellspacing="1px">
		<tr>
			<td width="29%" class="multiLabel">Item/Drug Name</td>
			<td width="21%" class="multiLabel">Available Qty</td>
			<td width="15%" class="multiLabel">Approx Rate/Unit</td>
			<td width="15%" class="multiLabel"><font size="2" color="red">*</font>Req
			Qty</td>
			<td width="20%" class="multiLabel"><font size="2" color="red">*</font>Unit
			Name</td>
		</tr>
	</table>
	</div>
	<div id="id1"></div>
	<div id="totalCostId" style="display: none">
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td width="90%" class="LABEL">
			<div id="to" style="color: blue;">Total Approx Cost(Rs):</div>
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
			<td colspan="6"></td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">Justification</td>
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
				src="../../hisglobal/images/back_tab.png" onClick="cancelToDesk();" />
			</td>
		</tr>
	</table>

	<input type="hidden" name="hmode" />

	<input type="hidden" name="strStoreTypeId"
		value="${requestForLpStaff.strStoreTypeId}">
	<input type="hidden" name="strTmpStoreName"
		value="${requestForContigency.strTmpStoreName}">
	<input type="hidden" name="strTmpCrNo"
		value="${requestForContigency.strTmpCrNo}">
	<input type="hidden" name="strTmpToStore"
		value="${requestForContigency.strTmpToStore}">
	<input type="hidden" name="strTmpGrantType"
		value="${requestForContigency.strTmpGrantType}">
	<input type="hidden" name="strTmpItemCatg"
		value="${requestForContigency.strTmpItemCatg}">
	<input type="hidden" name="strTmpReqType"
		value="${requestForContigency.strTmpReqType}">
	<input type="hidden" name="strGoFlg"
		value="${requestForContigency.strGoFlg}">
	<input type="hidden" name="strPath"
		value="${requestForContigency.strPath}">
	<input type="hidden" name="strCostRequired"
		value="${requestForContigency.strCostRequired}">


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
<jsp:include page="requestForContigency_itemSearchRow.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>
</body>
</html>