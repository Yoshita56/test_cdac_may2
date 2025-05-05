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
 * Date of Creation : 05/05/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
 -->
<html>
<head>
<meta charset=UTF-8">
<title>Return Request1</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
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

<script language="JavaScript" src="../js/ReturnRequest.js"></script>

<script type="text/javascript">

   function invokeCheckQty(mode, index, unitObject)
   {
			 		
		if(checkQty(index,'strReqQty','strUnitName'))
		{
		
			calculateCost(mode, 'strReqQty', 'strUnitName', '', index, '' , '1')
		
		}
	
	}	

	
	function getItemSelectPopup()
	{
	  
 	  var ToStoreCmb   = document.forms[0].strToStore.value;
     //alert(ToStoreCmb);
     if(!ToStoreCmb)
     {
         alert("Kindly select sub store name");
         return false;
     }
      if(ToStoreCmb != '0')
       {	
	
	   var strModeVal 					= "3" ; 
		var strRequestType              = document.forms[0].strTmpReqType.value;
		var strItemCategory 			= document.forms[0].strTmpItemCatg.value; 
		var strFromStoreId 				= document.forms[0].strTmpStoreName.value;
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strReqQty','strUnitName');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t','s');
		var testFunction                = "CallFunc";
		var arg                         = " ";  
		var userInfo                    = strFromStoreId; 
		var strMultiRowFetchDataArray 	= new Array('1','11','4','0^strUnitName^invokeCheckQty');
 
	    var layerIndex = "1";
         
	      searchItemsWithUserFunction ( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg,userInfo);
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


</script>

</head>

<body onload="OnLoadFunction()";>

<html:form action="/transactions/ReturnRequestTransCNT.cnt"
	name="returnRequest"
	type="mms.transactions.controller.fb.ReturnRequestTransFB"
	method="post">

	<div class="errMsg" id="errMsg"><bean:write name="returnRequest"
		property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="returnRequest" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="returnRequest" property="strMsg" /></div>

	<center><tag:tab tabLabel="Return Request" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>

		<tr>
			<td width="25%" class="LABEL">Store Name:</td>
			<td width="25%" class="CONTROL"><bean:write name="returnRequest"
				property="strStoreName" filter="false" /></td>

			<td width="25%" class="LABEL"><font color="red">*</font>Item
			Category:</td>
			<td width="25%" class="CONTROL"><bean:write name="returnRequest"
				property="strItemCatg" filter="false" /></td>

		</tr>
		<tr>
			<td width="25%" class="LABEL">Req Date:</td>
			<td width="25%" class="CONTROL"><bean:write name="returnRequest"
				property="strReqDate" filter="false" /></td>



			<td width="25%" class="LABEL"><font color="red">*</font>Sub
			Store:</td>
			<td width="25%" class="CONTROL"><select class='comboNormal'
				name='strToStore'>
				<bean:write name="returnRequest" property="strToStoreCombo"
					filter="false" />
			</select></td>
		</tr>

		<tr>

			<td class="LABEL" colspan="1">Urgent:</td>
			<td class="CONTROL" colspan="1"><%--
     <b><input type='checkbox' name='strIsNormal' value="0" onClick="ftnTick()">No<input type='checkbox' name='strIsUrgent' value="0" onClick="ftnTick()">Yes</b> &nbsp;&nbsp;
     --%> <input type="radio" name="strIsNormal" value="1"
				checked="checked" onClick="ftnTick(this)" />Normal &nbsp;&nbsp; <input type="radio"
				name="strIsUrgent" value="0" onClick="ftnTick(this)" />Urgent</td>

			<td width="25%" class="LABEL"></td>
			<td width="25%" class="CONTROL"></td>

		</tr>
	</table>



	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="TITLE">
			<td colspan="3">
			<div id="" align="right"><img style="cursor: pointer;height: 20px"
					id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"
					onclick='getItemSelectPopup();'></div>
			</td>
		</tr>
		<tbody>
			
		</tbody>
	</table>

	<table class="TABLEWIDTH" align="center" bgcolor="black" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td width="24%" class="multiLabel">Item Name</td>
            <td width="14%" class="multiLabel">Batch/SLNo</td>
			<td width="20%" class="multiLabel">Available Qty</td>
			<td width="20%" class="multiLabel"><font size="2" color="red">*</font>Req Qty</td>
			<td width="20%" class="multiLabel"><font size="2" color="red">*</font>Unit Name</td>

		</tr>

	</table>

	<div id="id1"></div>

	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">

		<tr class="TITLE">
			<td colspan="2"></td>
		</tr>
		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Remarks</td>
			<td class="CONTROL"><textarea name="strRemarks" cols="20"
				rows="2" id="strRemarks"></textarea></td>
		</tr>


		<tr class="FOOTER">
			<td colspan="2"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>


	<table class="TABLEWIDTH" align="center">
		<tr id="saveId">
			<td align="center">
				<img style="cursor: pointer; " title="Click to Save Record" src="../../hisglobal/images/btn-sv.png" onClick=" return validate1();" /> 
				<img style="cursor: pointer; " title="Click to Clear Page"  src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="initPage();"> 
				<img style="cursor: pointer; " title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="cancelToDesk();" />
			</td>
		</tr>
	</table>

	<input type="hidden" name="hmode" />
	<input type="hidden" name="strNormal"
		value="${returnRequest.strIsNormal}">
	<input type="hidden" name="strUrgent"
		value="${returnRequest.strIsUrgent}">
	<input type="hidden" name="strTmpStoreName"
		value="${returnRequest.strTmpStoreName}">
	<input type="hidden" name="strTmpItemCatg" value="${returnRequest.strTmpItemCatg}">
	<input type="hidden" name="strTmpReqType" value="${returnRequest.strTmpReqType}">
	<input type="hidden" name="strPath" value="${returnRequest.strPath}">
	<input type="hidden" name="strRequestStatusFlg" value="0">
	
	<input type="hidden" name="strTmpToStore" value="${returnRequest.strTmpToStore}">
      	  <input type="hidden" name="strReOrderFlgColor" value=""/>
	
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
<jsp:include page="returnRequest_itemSearchRow.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>
</body>
</html>