<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset=UTF-8">
<title>Advance Request</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/advanceRequestTrans.js"></script>
<script type="text/javascript">

</script>
</head>
<body onload="onLoadNewPage();">


<html:form name="advanceRequestBean" action="/transactions/AdvanceRequestTransCNT"
	type="mms.transactions.controller.fb.AdvanceRequestTransFB">

	<div id="errMsg" class="errMsg"><bean:write name="advanceRequestBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="advanceRequestBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="advanceRequestBean" property="strNormalMsg" /></div>

	<tag:tab tabLabel="Advance Request" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab>

	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="4"><html:radio
				property="strChkAdvanceReq" value="1" onclick="disPlay();">New</html:radio>
			<html:radio property="strChkAdvanceReq" value="2" onclick="disPlay();">Duplicate</html:radio></td>
		</tr>
	</table>

	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Store Name</td>
			<td width="25%" colspan="1" class="CONTROL">
			<div id="storeId" style="display: block">
				<select name="strStoreId" class="comboNormal" onchange="getItemCat(this);">
					<option value="0">SelectValue</option>
					<bean:write name="advanceRequestBean" property="strStoreValues"
						filter="false" />
				</select></div>
			<div id="storeValId" style="display: none"><bean:write
				name="advanceRequestBean" property="storeName" filter="false" /></div>
			</td>

			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Item Category</td>
			<td width="25%" colspan="1" class="CONTROL">
				<div id="itemcatDivId" style="display: block">
					<select	name="strItemCat" class="comboNormal" onchange="getPONoVal();">
					<bean:write
				name="advanceRequestBean" property="strItemCatCombo" filter="false" />
				</select></div>
			<div id="catValId" style="display: none"><bean:write
				name="advanceRequestBean" property="itemCatName" filter="false" /></div>
			</td>

		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>PO No</td>
			<td width="25%" colspan="2" class="CONTROL">
				<div id="ponoDivId" style="display: block">
				
				<bean:write name="advanceRequestBean" property="poPrefix" filter="false" />
				
					<select	name="strPONo" class="comboNormal">
					<option value="0">Select Value</option>
				</select></div>
			<div id="ponoValId" style="display: none">
			<bean:write name="advanceRequestBean" property="poNoVal" filter="false" /></div>

			</td>

			<td width="50%" colspan="1" class="CONTROL">
				<div id="goDivId"><img style=" cursor: pointer"
					src="../../hisglobal/images/Go.png" title='Click Here For PO Details' align="top"
					onclick="onNewGo();"></div>
			</td>
		</tr>
	</table>




<div id="poDetailNewDivId" style="display: none">
	<bean:write name="advanceRequestBean" property="strPODetailsVal" filter="false" />
</div>
<div id="newreqdtlsDiv" style="display: none;">
	<bean:write name="advanceRequestBean" property="strReqDetailsVal" filter="false"/>
</div>

<div id="inCasePODtl" style="display:none">

	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">

		<tr>
			
				<td colspan="4" class="TITLE"></td>
			
		</tr>
		<tr>	
			<td class="LABEL" colspan="2" width="50%"><font color="red">*</font>
			Request Advance Amt</td>
			<td class="CONTROL" width="50%" colspan="2"><input type="text"
				class="txtFldNormal" name="strAdvRequest"
				onkeypress="return validateData(event,7);" onkeyup="checkReqQty(this);" maxlength="14">INR</td>

		</tr>
		
		<tr>

			<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>
			Bank Acc. Name</td>
			<td class="CONTROL" width="25%" colspan="1"><input type="text"
				class="txtFldNormal" name="strBankAccName" maxlength="100"
				onkeypress="return validateData(event,4);" ></td>
				
			<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>
			Bank Acc. No.</td>
			<td class="CONTROL" width="25%" colspan="1"><input type="text"
				class="txtFldNormal" name="strBankAccNo" maxlength="25"
				onkeypress="return validateData(event,9);" ></td>

		</tr>
		

		<tr>

			<td class="LABEL" colspan="2" width="50%">Remarks</td>
			<td class="CONTROL" width="50%" colspan="2"><textarea rows="2"
				cols="20" name="strRemarks"></textarea></td>

		</tr>
		</table>
		</div>

<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr class="FOOTER">
			<td colspan="4"><font color="red">*</font> Mandatory Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>

			<td align="center"><img style=" cursor: pointer"
				src="../../hisglobal/images/btn-sv.png" title='Save Data'
				onclick="return validateNew();" /> <img
				style=" cursor: pointer"
				src="../../hisglobal/images/btn-clr.png" title='Clear Contents' onClick="clearNew();">
			<img style=" cursor: pointer"
				src="../../hisglobal/images/btn-ccl.png" title='Cancel Process' onClick="cancelAdv();">
			</td>

		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="storeName" value="${advanceRequestBean.storeName}" />
	<input type="hidden" name="itemCatName" value="${advanceRequestBean.itemCatName}" />
	<input type="hidden" name="poNoVal" value="${advanceRequestBean.poNoVal}" />
	<input type="hidden" name="strId" value="${advanceRequestBean.strId}" />
	<input type="hidden" name="itemCategory" value="${advanceRequestBean.itemCategory}" />
	<input type="hidden" name="ponovalue" value="${advanceRequestBean.ponovalue}" />
	<input type="hidden" name="disFlag" value="${advanceRequestBean.disFlag}" />
	<input type="hidden" name="poPrefix" value="${advanceRequestBean.poPrefix}" />
	

</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>