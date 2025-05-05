<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=UTF-8">
<title>Physical Stock Verification</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/newpopup.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="JavaScript" src="../js/discrepancyGlobal.js"></script>

<script language="Javascript" src="../js/stockDetails_util.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>

<script language="JavaScript" src="../js/phyStockVerification_trans.js"></script>

</head>
<body>
<html:form name="physicalStockVerificationBean"
	action="/transactions/PhyStockVerificationTransCNT"
	type="mms.transactions.controller.fb.PhyStockVerificationTransFB">

	<center>
	<div id="errMsg" class="errMsg"><bean:write
		name="physicalStockVerificationBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="physicalStockVerificationBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="physicalStockVerificationBean" property="strNormalMsg" /></div>

	</center>

	<tag:tab tabLabel="Physical Stock Verification" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab>

<jsp:include page="discrepancyReportglobal.jsp"></jsp:include>

	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		<tr>
			<td colspan="2" class="LABEL" width="50%">Financial Start Date</td>
			<td class="CONTROL" colspan="2" width="50%"><bean:write
				name="physicalStockVerificationBean"
				property="strFinancialStartDate" filter="false" /></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Store Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="physicalStockVerificationBean" property="strStoreName"
				filter="false" /></td>

			<td width="25%" class="LABEL">Category Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="physicalStockVerificationBean" property="strCategoryName"
				filter="false" /></td>

		</tr>
		<tr>
			<td colspan="2" width="50%" class="LABEL">Last Verified Date</td>
			<td width="50%" colspan="2" class="CONTROL"><bean:write
				name="physicalStockVerificationBean" property="strLastVerifiedDate"
				filter="false" /></td>

		</tr>
	</table>

	<logic:equal name="physicalStockVerificationBean"
		property="strPrevCountedFlag" value="1">

		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
			cellspacing="1px">

			<tr>
				<td colspan="4" class="TITLE" width="25%">
				<div id="countedDtlsDivIdPlusId" align="left"
					style="display: block;"><img
					src="../../hisglobal/images/plus.gif"
					onClick="showView('countedDtlsDivId');"
					style="cursor: pointer; " /> Counted Details</div>
				<div id="countedDtlsDivIdMinusId" style="display: none;"
					align="left"><img src="../../hisglobal/images/minus.gif"
					onClick="hideView('countedDtlsDivId');"
					style="cursor: pointer; " /> Counted Details</div>
				</td>
			</tr>
		</table>

		<div id="countedDtlsDivId" style="display: none">

		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
			cellspacing="1px">
			<tr>
				<td width="50%" colspan="2" class="LABEL"><font size="1"
					color="red">*</font>Group Name</td>
				<td width="50%" colspan="2" class="CONTROL"><select
					name="strGroupId" onchange="getCountedItemDtl(this)">
					<bean:write name="physicalStockVerificationBean"
						property="strGroupList" filter="false" />
				</select></td>
			</tr>
		</table>

		<div id="countedItemDetails"></div>

<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="TITLE" >
		<td colspan="3">
		</td>
		</tr>
		</table>
		</div>

	</logic:equal>



	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="TITLE">
			<td colspan="6">To Be Counted Details</td>
		</tr>


		<tr>			
			<td class="CONTROL" width="100%" colspan="6"><div align="right"><img 
				id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"
 style="cursor: pointer;height: 20px"
				onclick='getItemSelectPopup();'></div></td>
		</tr>
	</table>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px" bgcolor='black'>
		<tr>
			<td class="multiLabel" width='25%'>Item</td>
			<td class="multiLabel" width='10%'>Avl. Qty.</td>
			<td class="multiLabel" width='10%'>Tolerance Limit</td>
			<td class="multiLabel" width='10%'>Counted Qty.</td>
			<td class="multiLabel" width='10%'>Variance</td>
			<td class="multiLabel" width='10%'>Variance Cost</td>
			<td class="multiLabel" width='5%'>#</td>
		</tr>
	</table>
	<div id="id1"></div>
<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="TITLE" >
		<td colspan="3">
		</td>
		</tr>
		<tr>
		<td width="76%" class="LABEL">Net Variance Cost
		</td>
		<td width="24%" style="font-weight: bold;color: red;" class="multiControl"><input type="hidden" name="strVarianceNetCost" ><div id="strVarianceNetCostDivId">0.00</div>
		</td>
		</tr>
		</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">


		<tr class="FOOTER">
			<td colspan="4">['*'] Reserved/Branded Item   <font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>

		<tr>

			<td align="center" colspan="4"><img
				style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png"
				onClick="return validate1();" /> <img
				style="cursor: pointer; "
				src="../../hisglobal/images/back_tab.png" onClick="controlToMainPage();">
			</td>
		</tr>
	</table>

	<input type="hidden" name="hmode"  />

	<input type="hidden" name="strStoreId"
		value="${physicalStockVerificationBean.strStoreId }" />
	<input type="hidden" name="strItemCategoryId"
		value="${physicalStockVerificationBean.strItemCategoryId }" />
	<input type="hidden" name="strPhysicalStockNo"
		value="${physicalStockVerificationBean.strPhysicalStockNo }" />
	<input type="hidden" name="strPrevCountedFlag"
		value="${physicalStockVerificationBean.strPrevCountedFlag }" />
	<input type="hidden" name="strCountedQtyBatchWise"
		value="" />
	

	<cmbPers:cmbPers />

	<div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>

			<div id="stockDtlsDivId" style="display: block;"></div>

			<div id="searchItemsDtlsDivId" style="display: block;"></div>

			</td>
		</tr>
	</table>
	</div>


</html:form>

<jsp:include page="physicalStockVerify_itemSearchRow.jsp"></jsp:include>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>