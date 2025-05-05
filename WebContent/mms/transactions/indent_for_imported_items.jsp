<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<!--  
 * Developer : ll Jindal
 * Version : 1.0 
 * Date : 27/April/2009
 *  Module:MMS
 * Unit:Indent for Imported Items (Used in Indent Desk)
 -->



<html>
<head>
<meta charset=UTF-8">
<title>Indent for Imported Items</title>
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
<script language="Javascript" src="../js/indent_for_imported_items.js"></script>


</head>
<body >
<html:form name="indentForImportItemsBean"
	action="transactions/IndentForImportItemsCNT"
	type="mms.transactions.controller.fb.IndentForImportItemsFB">

	<center>
	<div id="errMsg" class="errMsg"><bean:write
		name="indentForImportItemsBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="indentForImportItemsBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="indentForImportItemsBean" property="strNormalMsg" /></div>


	<tag:tab tabLabel="Indent for Imported Items" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="6"></td>
		</tr>

		<tr>
			<td class="LABEL" width="25%">Store	Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="indentForImportItemsBean" property="strStoreName"
				filter="false" /></td>
			
			<td class="LABEL" width="25%"><input type="checkbox"
				name="strIsUrgent" value="1" /></td>
			<td class="CONTROL" width="25%">Urgent</td>
			
			
			

		</tr>
		
		
		<tr>
			<td class="LABEL" width="25%">Req Date</td>
			<td width="25%" class="CONTROL"><bean:write
				name="indentForImportItemsBean" property="strReqDate" filter="false" />
			</td>
			<td class="LABEL" width="25%">Drug Category</td>
			<td width="25%" class="CONTROL"><bean:write
				name="indentForImportItemsBean" property="strItemCategory"
				filter="false" /></td>
		</tr>
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Grant
			Name</td>
			<td width="25%" class="CONTROL"><select name="strGrantTypeCode"
				class="comboNormal">
				<bean:write name="indentForImportItemsBean"
					property="strGrantTypeNameCmb" filter="false" />
			</select></td>
			<td class="LABEL" width="25%">Sub Store</td>
			<td class="CONTROL" width="25%"><select name="strToStoreCombo"
				class="comboNormal"><option value="0">Select Value</option>
				<bean:write name="indentForImportItemsBean"
					property="strToStoreCombo" filter="false" />
			</select></td>
				

		</tr>
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Group
			Name</td>
			<td width="25%" class="CONTROL"><select name="strGroupId"
				class="comboNormal" onchange="getSubgroupAndItem(this);">
				<bean:write name="indentForImportItemsBean"
					property="strGroupNameCmb" filter="false" />
			</select></td>
			<td class="LABEL" width="25%">Sub-Group Name</td>
			<td width="25%" class="CONTROL"><div id="subgroupDiv"><select name="strSubGroupId"
				class="comboNormal"><option value="0">Select Value</option>
				<bean:write name="indentForImportItemsBean"
					property="strSubGroupNameCmb" filter="false" />
			</select></div></td>
		</tr>
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Generic Name</td>
			<td width="25%" class="CONTROL"><div id="itemDiv"><select name="strItemId"
				class="comboNormal"><option value="0">Select Value</option>
				<bean:write name="indentForImportItemsBean"
					property="strItemNameCmb" filter="false" />
			</select></div></td>
			<td class="LABEL" width="25%">Drug Name</td>
			<td width="25%" class="CONTROL"><div id="brandDiv"><select name="strBrandId"
				class="comboNormal"><option value="0">Select Value</option>
				<bean:write name="indentForImportItemsBean"
					property="strBrandNameCmb" filter="false" />
			</select></div></td>
		</tr>
		
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Quantity Req</td>
			<td width="25%" class="CONTROL"><input type="text" class="txtFldNormal" name="strQunatityReq" onkeypress="return validateData(event,7);" maxlength=""></td>
			<td class="LABEL" width="25%"><font color="red">*</font>Unit Name</td>
			<td width="25%" class="CONTROL"><div id="strQtyUnitName"><select name="strQtyUnitName"
				class="comboNormal"><option value="0">Select Value</option>
				<bean:write name="indentForImportItemsBean"	property="strQtyUnitCmb" filter="false" />
			</select></div></td>
		</tr>
		
		<tr class="TITLE">
			<td colspan="4"><div id="stockId" style="color:blue">Stock Details</div></td>
		</tr>

	    <tr>
			<td class="LABEL" width="25%">Existing Stock</td>
			<td width="25%" class="CONTROL"><div id="existingStockDiv" ></div>
			</td>
			<td class="LABEL" width="25%">Quantity Consumed (Last Financial Year)</td>
			<td width="25%" class="CONTROL"><div id="consumedQtyDiv" ></div></td>
		</tr>
		<tr>
			<td class="LABEL" width="25%">Last PO NO</td>
			<td width="25%" class="CONTROL"><div id="lstPoNoDiv" ></div>
			</td>
			<td class="LABEL" width="25%">Last PO Date</td>
			<td width="25%" class="CONTROL"><div id="lstPoDateDiv" ></div></td>
		</tr>
		<tr>
			<td class="LABEL" width="25%">Last Rate/Unit</td>
			<td width="25%" class="CONTROL"><div id="lstRateUnitDiv" ></div>
			</td>
			<td class="LABEL" width="25%">Last Recev  Date</td>
			<td width="25%" class="CONTROL"><div id="lstRecevDateDiv" ></div></td>
		</tr>
		
		<tr>
			<td class="LABEL" width="25%">Lst Supplied By</td>
			<td width="25%" class="CONTROL"><div id="lstSuppliedDiv" ></div>
			</td>
			<td class="LABEL" width="25%"></td>
			<td width="25%" class="CONTROL"></td>
		</tr>
		
		<tr class="TITLE">
			<td colspan="4"></td>
		</tr>
		
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Currency
			Name</td>
			<td width="25%" class="CONTROL"><select name="strCurrencyId"
				class="comboNormal">
				<bean:write name="indentForImportItemsBean"
					property="strCurrencyNameCmb" filter="false" />
			</select></td>
			<td class="LABEL" width="25%"></td>
			<td width="25%" class="CONTROL"></td>
		</tr>
		
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Approx Rate(INR)</td>
			<td width="25%" class="CONTROL"><input type="text" class="txtFldNormal" name="strApproxRate" onkeypress="return validateData(event,7);" maxlength="14"></td>
			<td class="LABEL" width="25%"><font color="red">*</font>Unit Name</td>
			<td width="25%" class="CONTROL"><div id="ApproxRateUnitDiv"><select name="strApproxRateUnitId"
				class="comboNormal"><option value="0">Select Value</option>
				<bean:write name="indentForImportItemsBean"
					property="strApproxRateUnitCmb" filter="false" />
			</select></div></td>
		</tr>
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Supplier
			Name</td>
			<td width="25%" class="CONTROL"><select name="strSupplierId"
				class="comboNormal" onchange="getSupplierAdd(this);">
				<bean:write name="indentForImportItemsBean"
					property="strSupplierNameCmb" filter="false" />
			</select></td>
			<td class="LABEL" width="25%">Supplier Address</td>
			<td width="25%" class="CONTROL"><div id="SupplierAddDiv"></div></td>
		</tr>
		
		<tr>
			<td class="LABEL" width="25%">P/Invoice Received
			Name</td>
			<td width="25%" class="CONTROL" colspan="3"><input type="radio" name="strPInvoiceRecvd" value="1" checked="checked"/>
			Direct <input type="radio" name="strPInvoiceRecvd" value="2"/>Indian Agent
		</tr>
		
		<tr>
			
			<td class="LABEL" width="25%"><input type="checkbox"
				name="strIsLowestQuotation" value="1" checked="checked" onclick="BlockJustification();"/></td>
			<td class="CONTROL" colspan="3">Whether the quotation were invited &amp; import is being proposed on the basis of lowest quotation</td>

		</tr>
	</table>
	
	<div id="justificationDiv" style="display: none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
	<tr>
		<td width="50%" class="LABEL" ><font color="red">*</font>Justification</td>
			<td  class="CONTROL" ><textarea
				name="strQuotationJustification" cols="25" rows="2"></textarea></td>
	</tr>
	</table>
	</div>
	<logic:equal name="indentForImportItemsBean" property="strItemCategoryNo" value="18"> 
	<div id="equipmentDiv" style="display: block">
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
	<tr>
		<td width="25%" class="LABEL" ><font color="red">*</font>Period Of Warranty</td>
		<td width="25%" class="CONTROL" ><input type="text" class="txtFldMin" name="strWarrantyPeriod" maxlength="3" onkeypress="return validateData(event,5);" >Months</td>
				
		<td width="50%" class="CONTROL" colspan="2"></td>
		
	</tr>
		<tr>
			<td class="LABEL" width="25%">Installation Required
			Name</td>
			<td width="25%" class="CONTROL" colspan="3"><input type="radio" name="strIsIntallationReq" value="1"  onclick="ifInstallationReq();"/>
			Yes <input type="radio" name="strIsIntallationReq" value="0" checked="checked" onclick="ifInstallationReq();"/>No
		</tr>
	</table>
	</div>
	</logic:equal>

	<div id="AppChargesDiv" style="display:none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
	<tr>
		<td width="25%" class="LABEL" ><font color="red">*</font>Approx Charges</td>
		<td width="25%" class="CONTROL" ><input type="text" class="txtFldNormal" name="strInstalationApproxCharges"></td>
		<td width="50%" class="CONTROL" colspan="2"></td>
		
	
	</tr>
	</table>
	</div>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Purpose</td>
			<td width="25%" class="CONTROL"><select name="strPurposeId"
				class="comboNormal" onchange="ifOtherPurpose();">
				<bean:write name="indentForImportItemsBean"
					property="strPurposeCmb" filter="false" /><option value='1'>Other</option>
			</select></td>
			
			<td class="CONTROL" width="50%" colspan="2">
			<div id="otherPurposeDiv" style="display: block">
			<input type="text" class="txtFldMax" name="strOtherPurpose" disabled="disabled"></div></td>
		
		</tr>
		</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">	
	<tr>
		<td width="50%" class="LABEL" ><font color="red">*</font>Justification</td>
			<td width="50%" class="CONTROL" colspan="3"><textarea
				name="strJustification" cols="25" rows="2"></textarea></td>
	</tr>
		
		
		
		
	</table>
	
	
	
	

	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">

		<tr class="FOOTER">
			<td colspan="4"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>


		<tr>
			<td colspan="4" align="center"><img
				style="cursor: pointer; " title="Save Record"
				src="../../hisglobal/images/btn-sv.png"
				onClick=" return saveData();" /> <img
				style="cursor: pointer; " title="Clear Content"
				src="../../hisglobal/images/btn-clr.png"
				onClick="Clear();" /> <img
				style="cursor: pointer; " title="Cancel Process"
				src="../../hisglobal/images/back_tab.png" onClick="cancel();" /></td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />
	    <input type="hidden" name="strPath" value="${indentForImportItemsBean.strPath}" />
	   	<input type="hidden" name="strReqType" 	value="${indentForImportItemsBean.strReqType}" />
		<input type="hidden" name="strStoreId"
		value="${indentForImportItemsBean.strStoreId}" />
		<input type="hidden" name="strItemCategoryNo"
		value="${indentForImportItemsBean.strItemCategoryNo}" />
		<input type="hidden" name="strHiddenStockPosition" value="${indentForImportItemsBean.strHiddenStockPosition}" />
		<input type="hidden" name="strHiddenStockDtl" value="${indentForImportItemsBean.strHiddenStockDtl}" />
	<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>

