<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset=UTF-8">
<title>Dispatch Details</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/dispatch_details_trans.js"></script>


</head>
<body onload="AdvanceHideandDisplayBlock();">
<html:form name="dispatchDetailsBean"
	action="/transactions/DispatchDetailsTransCNT"
	type="mms.transactions.controller.fb.DispatchDetailsTransFB">

	<center>
	<div id="errMsg" class="errMsg"><bean:write
		name="dispatchDetailsBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="dispatchDetailsBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="dispatchDetailsBean" property="strNormalMsg" /></div>

	</center>

	<tag:tab tabLabel="Dispatch Details" selectedTab="FIRST" align="center"
		width="TABLEWIDTH"></tag:tab>


	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER" style="border-collapse: collapse">
			<td colspan="3"></td>
			<td colspan="1" width="5%" align="right"><input type="checkbox"
				name="strDispatchViewRadio" value="1" onclick="diplayView();">

			View!</td>
		</tr>

		<tr>
			<td class="LABEL" colspan="4"><html:radio
				property="strAdvanceBillRadio" value="1" onclick="disPlay();">Advance</html:radio>
			<html:radio property="strAdvanceBillRadio" value="2"
				onclick="disPlay();">Bill</html:radio></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Store
			Name:</td>
			<td width="25%" class="CONTROL">
			<div align="left" id="StoreNameId" style="display: block;"><select
				name="strStoreId" class="comboNormal" onChange="getItemCategory();">
				<bean:write name="dispatchDetailsBean"
					property="strStoreNameCmbValues" filter="false" />
			</select></div>
			<div align="left" id="StoreNamedivId" style="display: none;">
			<bean:write name="dispatchDetailsBean" property="strStoreName"
				filter="false" /></div>
			</td>
			<td width="25%" class="LABEL"><font color="red">*</font>Item
			Category:</td>

			<td width="25%" class="CONTROL">
			<div align="left" id="ItemCategoryId" style="display: block;">
			<select name="strItemCatId" class='comboNormal' id="strItemId"
				onChange="getPONO();">
				<bean:write name="dispatchDetailsBean"
					property="strItemCategoryCmbValues" filter="false" />
			</select></div>
			<div align="left" id="ItemCategorydivId" style="display: none;">
			<bean:write name="dispatchDetailsBean" property="strItemCategory"
				filter="false" /></div>

			</td>

		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>PO
			No</td>
			<td width="25%" colspan="2" class="CONTROL">


			<div align="left" id="PONOId" style="display: block;"><bean:write
				name="dispatchDetailsBean" property="poPrefix" filter="false" /> <select
				name="strPONO" class="comboNormal" id="strPONOId">
				<option value="0">Select Value</option>
			</select></div>
			<div align="left" id="PONOdivId" style="display: none;"><bean:write
				name="dispatchDetailsBean" property="poPrefix" filter="false" /> <bean:write
				name="dispatchDetailsBean" property="PONOName" filter="false" /></div>
			</td>
			<td width="50%" colspan="1" class="CONTROL">
			<div align="left" id="imageDivId" style="display: block;"><input
				type="image" style="cursor: pointer; "
				title="PO Details" align="top"
				src="../../hisglobal/images/Go.png" name="go" value="Go"
				onclick="return goFuncADV();" onkeyup="goFuncOnEnterAdv(event);">
			</div>
			</td>

		</tr>
	</table>
	<div id="PONODetailsDivId" style="display: none">

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td colspan="4" class="TITLE"><div id="" style="color:blue;">PO Details</div></td>
		</tr>
		<tr>
			<td class="LABEL" width="25%" colspan="1">PO Date</td>
			<td width="25%" class="CONTROL" colspan="1"><bean:write
				name="dispatchDetailsBean" property="strPODate" filter="false" /></td>
			<td class="LABEL" width="25%" colspan="1">Supplier Name</td>
			<td width="25%" class="CONTROL" colspan="1"><bean:write
				name="dispatchDetailsBean" property="strSupplierName" filter="false" />
			</td>
		</tr>
		<tr>
			<td class="LABEL" width="25%" colspan="1">PO Type</td>
			<td width="25%" class="CONTROL" colspan="1"><bean:write
				name="dispatchDetailsBean" property="strPOType" filter="false" /></td>
			<td class="LABEL" width="25%" colspan="1">Currency Code</td>
			<td width="25%" class="CONTROL" colspan="1"><bean:write
				name="dispatchDetailsBean" property="strCurrencyCode" filter="false" />
			</td>
		</tr>
	</table>
	</div>


	<div id="currVarAdvDivId" style="display: none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr >
			<td colspan="4" class="TITLE"><div id="" style="color:blue;">Currency Exchange Variance</div></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="1">Currency Value(PO)</td>
			<td class="CONTROL" colspan="3"><bean:write
				name="dispatchDetailsBean" property="strCurrValuePO" filter="false" />
			</td>
		</tr>
		<tr>
			<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Currency
			Value</td>
			<td class="CONTROL" width="25%" colspan="1"><input type="text"
				class="txtFldMin" name="strCurrValue" maxlength="11"
				onkeyup="getExcVar();"></td>

			<td class="LABEL" width="25%" colspan="1">Exchange Variance</td>

			<td class="CONTROL" width="25%" colspan="1">
			<div id="excVarDivId"></div>
			</td>

		</tr>
	</table>
	</div>




	<div id="RequestDetailsDivId" style="display: none">

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td colspan="5" class="TITLE"><div id="" style="color:blue;">Request Details</div></td>
		</tr>
		<tr>
			<td width="10%" class="multiLabel">#</td>
			<td width="45%" class="multiLabel">Req No</td>
			<td width="20%" class="multiLabel">Req Date</td>
			<td width="25%" class="multiLabel">Advance Requested</td>
		</tr>



		<bean:write name="dispatchDetailsBean" property="strRequestDetails"
			filter="false" />
	</table>
	</div>

	<div id="InstrumentDetailsDivId" style="display: none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td colspan="4" class="TITLE"><div id="" style="color:blue;">Instrument Details</div></td>
		</tr>

		<tr>
			<td class="LABEL" colspan="1"><font color="red">*</font>Instrument
			Type</td>
			<td class="CONTROL" colspan="1" align="center"><html:select
				name="dispatchDetailsBean" property="strInstrType">
				<html:option value="0">Select Value</html:option>
				<html:option value="1">Cheque</html:option>
				<html:option value="2">DD</html:option>
			</html:select></td>
			<td class="LABEL" colspan="1"><font color="red">*</font>Instrument
			Received Date</td>
			<td class="CONTROL" colspan="1"><dateTag:date
				name="strInstrReceivedDate" value="${dispatchDetailsBean.strCtDate}"></dateTag:date></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="1"><font color="red">*</font>Instrument
			No</td>
			<td class="CONTROL" colspan="1"><input type="text"
				class="txtFldMax" name="strInstrNo" onkeypress="return validateData(event,5);" value="" maxlength="10"></td>
			<td class="LABEL" colspan="1"><font color="red">*</font>Instrument
			Date</td>
			<td class="CONTROL" colspan="1"><dateTag:date
				name="strInstrDate" value="${dispatchDetailsBean.strCtDate}"></dateTag:date></td>

		</tr>
		<tr>
			<td class="LABEL" colspan="1"><font color="red">*</font>Drawee
			Bank</td>
			<td class="CONTROL" colspan="1"><input type="text"
				class="txtFldMax" name="strDraweeBank" value=""
				onkeypress="return validateData(event,9);" maxlength="100">
			</td>

			<td class="LABEL" colspan="1"><font color="red">*</font>Instrument
			Validity (In Months)</td>
			<td class="CONTROL" colspan="1"><input type="text"
				class="txtFldMin" name="strInstrValidity" value="" maxlength="2"
				onkeypress="return validateData(event,5);"></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="1"><font color="red">*</font>Instrument
			Amount</td>
			<td class="CONTROL" colspan="1"><input type="text" 
				class="txtFldMax" name="strInstrAmt" value="" maxlength="14"
				onkeypress="return validateData(event,7);" ></td>



			<td class="LABEL" colspan="1"><font color="red">*</font>Dispatch
			Mode</td>
			<td class="CONTROL" colspan="1"><html:select
				name="dispatchDetailsBean" property="strDispatchMode">
				<bean:write name="dispatchDetailsBean"
					property="strDispatchModeNameValues" filter="false" />
			</html:select></td>
		</tr>
		<tr>

			<td class="LABEL" width="25%" colspan="2">Remarks</td>
			<td width="25%" class="CONTROL" colspan="2"><textarea
				name="strRemarks" cols="16" rows="2"></textarea></td>
		</tr>
		
	</table>
	</div>
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="FOOTER">
			<td colspan="4"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>

	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>

			<td align="center"><img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png"
				onClick="return validate1();" /> <img
				style="cursor: pointer; "
				src="../../hisglobal/images/btn-clr.png" onClick="clearAdvance();">
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-ccl.png" onClick="cancel();">
			</td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="chkSelected" />
	<input type="hidden" name="strSupplierId"
		value="${dispatchDetailsBean.strSupplierId}" />
	<input type="hidden" name="strCurrencyId"
		value="${dispatchDetailsBean.strCurrencyId}" />
	<input type="hidden" name="strCurrValuePO"
		value="${dispatchDetailsBean.strCurrValuePO}" />
	<input type="hidden" name="strPODate"
		value="${dispatchDetailsBean.strPODate}" />
	<input type="hidden" name="strPOType"
		value="${dispatchDetailsBean.strPOType}" />
	<input type="hidden" name="strCurrencyCode"
		value="${dispatchDetailsBean.strCurrencyCode}" />
	<input type="hidden" name="hideStoreId"
		value="${dispatchDetailsBean.hideStoreId}" />
	<input type="hidden" name="hideItemCatId"
		value="${dispatchDetailsBean.hideItemCatId}" />
	<input type="hidden" name="hidePONO"
		value="${dispatchDetailsBean.hidePONO}" />
	<input type="hidden" name="modevalue" value="2" />
	<input type="hidden" name="strStoreName"
		value="${dispatchDetailsBean.strStoreName}" />
	<input type="hidden" name="strItemCategory"
		value="${dispatchDetailsBean.strItemCategory}" />
	<input type="hidden" name="PONOName"
		value="${dispatchDetailsBean.PONOName}" />
	<input type="hidden" name="displayFlag"
		value="${dispatchDetailsBean.displayFlag}" />
	<input type="hidden" name="strDefCurrId"
		value="${dispatchDetailsBean.strDefCurrId}" />
	<input type="hidden" name="strExchangeVar"
		value="${dispatchDetailsBean.strExchangeVar}" />
	<input type="hidden" name="poPrefix"
		value="${dispatchDetailsBean.poPrefix}" />

	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>