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
<title>Annual Indent</title>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">

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
</style>

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>

<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/mms.js"></script>
<script language="JavaScript" src="../js/RoutinePurchaseWithItem.js"></script>

</head>
<body onload="OnLoadFunction();">

<html:form action="/transactions/RoutinePurchaseCNT.cnt"  name="requestForRoutinePurchase"  type="mms.transactions.controller.fb.RoutinePurchaseFB" method="post">

	<div class="errMsg" id="errMsg">
	     <bean:write 	name="requestForRoutinePurchase" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg">
	     <bean:write	name="requestForRoutinePurchase" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg">
	     <bean:write    name="requestForRoutinePurchase" property="strMsg" /></div>

	<center>
	   <tag:tab tabLabel="Annual Indent"  selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>
	</center>

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
	<table width='400' border="0" cellspacing="1px" bgcolor='#CC9966' cellpadding="1px">
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
				name="requestForRoutinePurchase" property="strStoreName" filter="false" /></td>

			<td width="25%" class="LABEL"><font color="red">*</font>Item
			Category:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="requestForRoutinePurchase" property="strItemCatg" filter="false" />

			</td>

		</tr>
		<tr>
			<td width="25%" class="LABEL">Req Date:</td>
			<td width="25%" class="CONTROL"><bean:write
				name="requestForRoutinePurchase" property="strReqDate" filter="false" />
			</td>



			<td width="25%" class="LABEL"><font color="red">*</font>Receiving
			Store:</td>
			<td width="25%" class="CONTROL"><select class='comboMax'
				name='strToStore'>
				<bean:write name="requestForRoutinePurchase" property="strToStoreCombo"
					filter="false" />
			</select></td>
		</tr>

		<tr>

			<td class="LABEL" colspan="1">Urgent:</td>
			<td class="CONTROL" colspan="1">
			
			   <input type="radio" name="strIsNormal" value="1"  checked="checked" />Normal &nbsp;&nbsp; <input type="radio" name="strIsNormal" value="0" />Urgent</td>

			<td width="25%" class="CONTROL"></td>
			<td width="25%" class="CONTROL"></td>

		</tr>
		<tr>
			<td class="LABEL" colspan="1">Indent Period:</td>
			<td class="CONTROL" colspan="3"><select class='comboNormal'
				name='strIndentPeriod'>
				<bean:write name="requestForRoutinePurchase"
					property="strIndentPeriodCombo" filter="false" />
			</select>&nbsp;&nbsp;
			
			  <html:select name="requestForRoutinePurchase" property="strIndentPeriodValue" styleClass="comboNormal" >
	          	<html:option value="1"> <bean:write name="requestForRoutinePurchase" property="strCurrentFinancialYear" filter="false"/></html:option>
				<html:option value="2"> <bean:write name="requestForRoutinePurchase" property="strNextFinancialYear" filter="false"/></html:option>	          	
	          </html:select>			   
				
				</td>

		</tr>
		
	</table>
	<bean:write		name="requestForRoutinePurchase" property="strIndentItemList" filter="false" />

	
	

	
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="TITLE">
			<td colspan="6"></td>
		</tr>
		<tr>
			<td colspan="3" class="LABEL">Remarks(If Any)</td>
			<td class="CONTROL" colspan="3"><textarea name="strRemarks" cols="20"
				rows="2" id="strRemarks"></textarea></td>
		</tr>


		<tr class="FOOTER">
			<td colspan="6"><font size="2" color="red">*</font> Mandatory
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
		value="${requestForRoutinePurchase.strTmpStoreName}">
	<input type="hidden" name="strTmpCrNo"
		value="${requestForRoutinePurchase.strTmpCrNo}">
	<input type="hidden" name="strTmpToStore"
		value="${requestForRoutinePurchase.strTmpToStore}">
	<input type="hidden" name="strTmpGrantType"
		value="${requestForRoutinePurchase.strTmpGrantType}">
	<input type="hidden" name="strTmpItemCatg"
		value="${requestForRoutinePurchase.strTmpItemCatg}">
	<input type="hidden" name="strTmpReqType"
		value="${requestForRoutinePurchase.strTmpReqType}">
	<input type="hidden" name="strGoFlg"
		value="${requestForRoutinePurchase.strGoFlg}">
	<input type="hidden" name="strPath"
		value="${requestForRoutinePurchase.strPath}">
	<input type="hidden" name="strCostRequired"
		value="${requestForRoutinePurchase.strCostRequired}">
		<input type="hidden" name="strItemDtlWithIssueQty" id="strItemDtlWithIssueQty" value="0"/>
		<input type="hidden" name="strFinancialYearPeriod" id="strFinancialYearPeriod" value="0"/>


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

<tag:autoIndex></tag:autoIndex>
</body>
</html>