<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/onLineReqDiscountDtl.tld" prefix="DisDtl"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
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
<title>Annual Purchase Indent</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" 
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
<script language="JavaScript" src="../js/AnnualPurchaseIndent.js"></script>

<script type="text/javascript">

	function invokeCheckQty(mode, index, unitObject)
	{ 
	    gblIsAvailReq = "0";	
	    if( checkQty(index,'strReqQty','strUnitName'))
		 {
		       
		        // Pass '0' If User Dont Want to Compare Req Qty with Avalaible Quantity 
		 		calculateCost(mode, 'strReqQty', 'strUnitName', 'strCost', index , 'strApproxAmt','0');
		 }
			
	}	
	/*function changeUnitCmb(obj,index)
	{	   
       	alert("Ji");
       document.getElementById("strUnitName" + index).value = "0";
       	document.getElementById("strCostDivId" + index).innerHTML = "0.00";
       document.getElementById("strCost" + index).value = "0";
  
			var costObj = document.getElementsByName("strCost");
			var total = parseFloat("0.00");
		
			if (costObj.length > 1) 
			{
		
			/*	for ( var i = 0, stop = costObj.length - 1; i < stop; i++)
				 {
		
				//	total = total + parseFloat(costObj[i].value);
					
		
				}
		
			}
*/
	  //  total = roundValue(total, 2);
	    
	    /*document.getElementById("strApproxAmtDivId").innerHTML = total;
 //       document.forms[0].strApproxAmt.value=total;
alert(total);
       	
       	
	}*/
	function changeUnitCmb(obj,index)
	{	
       //	document.getElementById("strCostDivId" + index).innerHTML = "0.00";
       	document.getElementById("strCost" + index).value = "0";
 
        calculateCost('1', 'strReqQty', 'strUnitName', 'strCost', index , 'strApproxAmt','0');  	
       	
	}
	
	function CallFunc()
	{
			 var unitNameCmb = document.getElementsByName("strUnitName");
			    for(var j=0;j<unitNameCmb.length;j++)
				{
					//unitNameCmb[j].value = "0";
				}
	   
	}
	
	function getItemSelectPopup()
	{
	  var ItemTypeCmb = document.forms[0].strItemType;
 	  var ToStoreCmb   = document.forms[0].strToStore;
      	
	    var strModeVal 					= "1" ; 
		var strRequestType              = document.forms[0].strTmpReqType.value;
		var strItemCategory 			= document.forms[0].strTmpItemCatg.value; 
		var strFromStoreId 				= document.forms[0].strTmpStoreName.value;
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strReqQty','strUnitName');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t','s','t');
		var testFunction                = "CallFunc";
		var arg                         = " ";  
		
	//	var strMultiRowFetchDataArray 	= new Array('1','4','10','0^strUnitName^invokeCheckQty');
		
		var strMultiRowFetchDataArray 	= new Array('1','4','5','0^strUnitName^invokeCheckQty');
		
		    
	    var layerIndex = "1";
	
        searchItemsWithUserFunction ( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg);
	  
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

<body onload="OnLoadFunction(),costReq()";>

<html:form action="/transactions/AnnualPurchaseIndentCNT.cnt"
	name="annualPurchaseIndent"
	type="mms.transactions.controller.fb.AnnualPurchaseIndentFB"
	method="post">

	<div class="errMsg" id="errMsg"><bean:write
		name="annualPurchaseIndent" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="annualPurchaseIndent" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="annualPurchaseIndent" property="strMsg" /></div>

	<div class='popup' id='purchaseDtl' style="display: none">
	<table width='400' border="0" cellspacing="0px">
		<tr class="HEADER">
			<th colspan='6' align='left'><div id='11' style='color: blue;'></div>
			</th>
			<th align='right'><img style='cursor: pointer; ' title='To Close Pop-Up'
				src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('purchaseDtl');"></th>
		</tr>
	</table>
	<table width='400' border="0" cellspacing="1px" bgcolor='#6097BC' cellpadding="1px">
		<tr>
			<td colspan="1" class='multiLabel'>PO NO</td>
			<td colspan="1" class='multiLabel'>PO Date</td>
			<td colspan="1" class='multiLabel'>Supplier Name</td>


		</tr>
		<tr>
			<td colspan="1" class='multiControl'>
			<div id='1'></div>
			</td>
			<td colspan="1" class='multiControl'>
			<div id='2'></div>
			</td>
			<td colspan="1" class='multiControl'>
			<div id='3'></div>
			</td>


		</tr>

		<tr>
			<td colspan="1" class='multiLabel'>Received Qty</td>
			<td colspan="1" class='multiLabel'>Rate/Unit</td>
			<td colspan="1" class='multiLabel'></td>


		</tr>
		<tr>
			<td colspan="1" class='multiControl'>
			<div id='5'></div>
			</td>
			<td colspan="1" class='multiControl'>
			<div id='7'></div>
			</td>
			<td colspan="1" class='multiControl'></td>

		</tr>


	</table>
	</div>


	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>

		<tr>
			<td width="25%" class="LABEL">Store Name:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="annualPurchaseIndent" property="strStoreName" filter="false" /></td>



			<td width="25%" class="LABEL"><font color="red">*</font>Item
			Category:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="annualPurchaseIndent" property="strItemCatg" filter="false" />

			</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Req Date:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="annualPurchaseIndent" property="strReqDate" filter="false" />
			</td>


			<td width="25%" class="LABEL"><font color="red">*</font>Receiving
			Store:</td>
			<td width="25%" class="CONTROL"><select class='comboMax'  onChange="resetValue();"
				name='strToStore'>
				<bean:write name="annualPurchaseIndent" property="strToStoreCombo"
					filter="false" />
			</select></td>

		</tr>

		<tr>

			

			<td class="LABEL" colspan="1">Urgent:</td>
			<td class="CONTROL" colspan="1"><%--
     <b><input type='checkbox' name='strIsNormal' value="0" onClick="ftnTick()">No<input type='checkbox' name='strIsUrgent' value="0" onClick="ftnTick()">Yes</b> &nbsp;&nbsp; 
     --%><input type="radio" name="strIsNormal" value="1" checked="checked" /> Normal &nbsp;&nbsp; 
         <input type="radio" name="strIsNormal" value="0" /> Urgent</td>
         <td width="25%" class="LABEL">Indent Type : </td>
         <logic:equal  name="annualPurchaseIndent" property="strTmpReqType" value="90">
			<td width="25%" class="CONTROL">Emergency/ Indent Purchase(45 Days) </td>
		</logic:equal>
		<logic:equal  name="annualPurchaseIndent" property="strTmpReqType" value="11">
			<td width="25%" class="CONTROL">Indent for LP(Dept)</td>
		</logic:equal>
		</tr>



		<tr>
			<td class="LABEL" colspan="1"><font size="2" color="red">*</font>Indent Period:</td>
			<td class="CONTROL" colspan="3"><select class='comboNormal'
				name='strIndentPeriod'>
				<bean:write name="annualPurchaseIndent"
					property="strIndentPeriodCombo" filter="false" />
			</select>&nbsp;&nbsp;<input type="text" class="txtFldMax"
				name="strIndentPeriodValue"
				onkeypress="return validateData(event,3);" maxlength=""></td>

		</tr>


	</table>

     <bean:write name="annualPurchaseIndent"	property="strNotIssueDrugList" filter="false" />

	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">

		<tr class="TITLE">
			<td colspan="6"><div align="right">
			<img style="cursor: pointer;height: 20px" id="strSearchItemButtonDivId" src="../../hisglobal/images/ItemFinder.png" onclick="getItemSelectPopup();"/>
			</div></td>
		</tr>
		<!-- 
		<tbody>
			<tr>
				
				<td class="CONTROL"></td>
			</tr>
		</tbody>
		 -->
	</table>

	<div id="costDivReqId" style="display: none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px" bgcolor='black'
		cellspacing="1px">
		<tr>
			<td width="30%" class="multiLabel">Item/Drug Name</td>

			<td width="12%" class="multiLabel">Available Qty</td>
			<td width="12%" class="multiLabel">Rate</td>
			<!-- <td width="10%" class="multiLabel">Consumption Qty(Last Year)</td>
			<td width="8%" class="multiLabel">Last Purchase Detail</td> -->
			<td width="10%" class="multiLabel"><font size="2" color="red">*</font>Req	Qty</td>
			<!-- <td width="10%" class="multiLabel"><font size="2" color="red">*</font>Rate</td> -->
			<td width="14%" class="multiLabel"><font size="2" color="red">*</font>Unit</td>
			 

		</tr>
	</table>
	</div>
	<div id="costDivNotReqId" style="display: none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px" bgcolor='black'
		cellspacing="1px">
		<tr>
			<td width="30%" class="multiLabel">Item/Drug Name</td>

			<td width="12%" class="multiLabel">Available Qty</td>
			<!-- <td width="12%" class="multiLabel">Consumption Qty(Last Year)</td>
			<td width="8%" class="multiLabel">Last Purchase Detail</td> -->
			<td width="10%" class="multiLabel"><font size="2" color="red">*</font>Req
			Qty</td>
			<td width="14%" class="multiLabel"><font size="2" color="red">*</font>Unit
			</td>


		</tr>
	</table>

	</div>



	<div id="id1"></div>
	<div id="totalCostId" style="">
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td width="85%" class="LABEL"><div style='display:none;'>Total Approx Cost(Rs):</div></td>
			<td width="15%" class="CONTROL" style="color: red; font-weight: bold">
			<div id="strApproxAmtDivId" align="center"></div>
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
			<td colspan="3" width="50%"  class="LABEL">Remarks</td>
			<td colspan="3" width="50%"  class="CONTROL"><textarea name="strRemarks" cols="20"
				rows="2" id="strRemarks"></textarea></td>
		</tr>


		<tr class="FOOTER">
			<td colspan="6"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>

<!--
	<table class="TABLEWIDTH" align="center">
	  <tr id="saveId">
		<td align="center">
			<img style="cursor: pointer; " title="Click to Save Record" src="../../hisglobal/images/btn-sv.png" onClick=" return validate1();" /> 
			<img style="cursor: pointer; " title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="initPage();"> 
			<img style="cursor: pointer; " title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="cancelToDesk();" />
		</td>
	  </tr>
	</table>-->
	<br>
	<div align="center" id="saveId">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="initPage();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelToDesk();"><span class="cancel">Cancel</span></a>
					</div> 

	<input type="hidden" name="hmode" />
	<input type="hidden" name="strStoreTypeId"
		value="${annualPurchaseIndent.strStoreTypeId}">
	<input type="hidden" name="strTmpStoreName"
		value="${annualPurchaseIndent.strTmpStoreName}">
	<input type="hidden" name="strTmpToStore"
		value="${annualPurchaseIndent.strTmpToStore}">
	<input type="hidden" name="strTmpItemCatg"
		value="${annualPurchaseIndent.strTmpItemCatg}">
	<input type="hidden" name="strTmpReqType"
		value="${annualPurchaseIndent.strTmpReqType}">
	<input type="hidden" name="strGoFlg"
		value="${annualPurchaseIndent.strGoFlg}">
	<input type="hidden" name="strPath"
		value="${annualPurchaseIndent.strPath}">
	<input type="hidden" name="strCostRequired"
		value="${annualPurchaseIndent.strCostRequired}">
		
		<input type="hidden" name="search" value='<%=request.getParameter("search") %>' />

      <input type="hidden" name="blockNo" value='<%=request.getParameter("blockNo") %>' />

      <input type="hidden" name="prevNext" value='<%=request.getParameter("prevNext") %>' />

      <input type="hidden" name="rowNum" value='<%=request.getParameter("rowNum") %>'/>

      <input type="hidden" name="divisionId" value='<%=request.getParameter("divisionId") %>' />
		

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
<jsp:include page="requestforAnnualPurchaseIndent_itemSearchRow.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>
</body>
</html>