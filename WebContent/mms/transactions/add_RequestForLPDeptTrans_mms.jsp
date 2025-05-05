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
 * Date of Creation : 31/4/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
 -->
<html>
<head>
<meta charset=UTF-8">
<title></title>
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


<script language="JavaScript" src="../js/RequestForLpDept.js"></script>

<script type="text/javascript">

	    function invokeCheckQty(mode, index, unitObject)
	    {
	    gblIsAvailReq = "0";	
		  if(checkQty(index,'strReqQty','strUnitName'))
		  {
		    calculateCost(mode, 'strReqQty', 'strUnitName', '', index , '','0');
		  }
		 
	    }	
	
	
	function getItemSelectPopup()
	{
	   var ToStoreCmb   = document.forms[0].strToStore;
       if(ToStoreCmb.value ==0)
       {		
	    var strModeVal 					= "1" ; 
		var strRequestType              = document.forms[0].strTmpReqType.value;
		var strItemCategory 			= document.forms[0].strTmpItemCatg.value; 
		var strFromStoreId 				= document.forms[0].strTmpStoreName.value;
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strReqQty','strUnitName');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t','s');
		var testFunction                = "CallFunc";
		var arg                         = " ";  
		
		var strMultiRowFetchDataArray 	= new Array('1','4','0^strUnitName^invokeCheckQty');
		    
	    var layerIndex = "1";
	
        searchItemsWithUserFunction ( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg);
	   }
	  /*  else
	   {
	   	   if(ToStoreCmb.selectedIndex == 0)
	       {
	           alert("Plz Select To Store Name !!!!");
	           ToStoreCmb.focus();
	       }
	    return false;
	 } */
	}
	
  
</script>

</head>

<body onload="OnLoadFunction();">

<html:form action="/transactions/RequestForLPDeptCNT.cnt"
	name="requestForLpDept"
	type="mms.transactions.controller.fb.RequestForLPDeptFB" method="post">

	<div class="errMsg" id="errMsg"><bean:write
		name="requestForLpDept" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="requestForLpDept" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="requestForLpDept" property="strMsg" /></div>

	<center><tag:tab tabLabel="Request For LP Transaction"
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>

	<div class='popup' id='procurmentDtl' style="display: none">
	<!--<table width='400' border="0" cellspacing="0px">
		<tr class="HEADER">
			<th colspan='6' align='left'>
			<div id='' style='color: blue;'>Procurement Status</div>
			</th>
			<th align='right'><img style='cursor: pointer; '
				src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('procurmentDtl');"></th>
		</tr>
	</table>
	<table width='400' border="0" cellspacing="1px" cellpadding="1px">
		<tr>
			<td colspan="1" class='multiLabel'>Date On Which Stock is Nil</td>
			<td colspan="1" class='multiLabel'>Date on Which Supply Order was placed</td>



		</tr>
		<tr>
			<td colspan="1" class='multiControl'>
			<div id='1'></div>
			</td>
			<td colspan="1" class='multiControl'>
			<div id='2'></div>
			</td>


		</tr>

		<tr>
			<td colspan="1" class='multiLabel'>Supply Status</td>
			<td colspan="1" class='multiLabel'>Supply Status</td>


		</tr>
		<tr>
			<td colspan="1" class='multiControl'>
			<div id='3'></div>
			</td>
			<td colspan="1" class='multiControl'>
			<div id='4'></div>
			</td>

		</tr>


	</table>  -->
	</div>







	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>

		<tr>
			<td width="25%" class="LABEL">Store Name:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="requestForLpDept" property="strStoreName" filter="false" /></td>

			<td width="25%" class="LABEL"><font color="red">*</font>Item
			Category:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="requestForLpDept" property="strItemCatg" filter="false" /></td>


		</tr>
		<tr>
			<td width="25%" class="LABEL">Req Date:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="requestForLpDept" property="strReqDate" filter="false" /></td>

			<td width="25%" class="LABEL"><font color="red">*</font>Sub
			Store:</td>
			<td width="25%" class="CONTROL"><select class='comboNormal'
				name='strToStore'>
				<bean:write name="requestForLpDept" property="strToStoreCombo"
					filter="false" />
			</select></td>


		</tr>

		<tr>
			<td class="LABEL" colspan="1">Urgent Status:</td>
			<td class="CONTROL" colspan="1"><%--
			<b><input type='checkbox'
				name='strIsNormal' value="0" onClick="ftnTick()">No<input
				type='checkbox' name='strIsUrgent' value="0" onClick="ftnTick()">Yes</b>
			&nbsp;&nbsp;
			--%><input type="radio" name="strIsNormal" value="1"
				checked="checked" />Normal &nbsp;&nbsp; <input type="radio"
				name="strIsNormal" value="0" />Urgent</td>

			<td width="25%" class="LABEL"></td>
			<td width="25%" class="CONTROL"></td>

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

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td width="21%" class="multiLabel">Item/Drug Name</td>
			<td width="12%" class="multiLabel">Avl Qty</td>
			<!--  <td width="23%" class="multiLabel">Last Rec. Qty &amp; Date</td>
			<td width="13%" class="multiLabel">Procurment Status</td>-->
			<td width="11%" class="multiLabel"><font size="2" color="red">*</font>Req
			Qty</td>
			<td width="20%" class="multiLabel"><font size="2" color="red">*</font>Unit
			</td>
		</tr>
	</table>

	<div id="id1"></div>
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="TITLE">
			<td colspan="6"></td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
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
				src="../../hisglobal/images/back_tab.png" onClick="cancelToDesk();" />
			</td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strStoreTypeId"
		value="${requestForLpDept.strStoreTypeId}">
	<input type="hidden" name="strTmpStoreName"
		value="${requestForLpDept.strTmpStoreName}">
	<input type="hidden" name="strTmpToStore"
		value="${requestForLpDept.strTmpToStore}">
	<input type="hidden" name="strTmpItemCatg"
		value="${requestForLpDept.strTmpItemCatg}">
	<input type="hidden" name="strTmpReqType"
		value="${requestForLpDept.strTmpReqType}">
	<input type="hidden" name="strGoFlg"
		value="${requestForLpDept.strGoFlg}">
	<input type="hidden" name="strPath" value="${requestForLpDept.strPath}">
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
<jsp:include page="requestforLPDept_itemSearchRow.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>
</body>
</html>