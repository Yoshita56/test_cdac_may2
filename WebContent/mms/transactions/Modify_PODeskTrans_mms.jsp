<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<html>
<head>
<meta charset=UTF-8">
<title>PO Desk</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet"
type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../mms/js/PODesk.js"></script>
<script language="Javascript" src="../../mms/js/POModifyJS.js"></script>
<script language="JavaScript" src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>

</head>
<body onload="">
<html:form action="/transactions/PODeskGenerateTransCNT">

	<center>
	<div id="errMsg" class="errMsg"><bean:write
		name="PODeskGenerateTransBean" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="PODeskGenerateTransBean" property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="PODeskGenerateTransBean" property="strMsg" /></div>

	
	<tag:tab tabLabel="PO Desk" selectedTab="FIRST"
				align="center" width="TABLEWIDTH">
			</tag:tab>
			
	</center>		
	<table class="TABLEWIDTH" align="center" cellspacing="0" id='divHeader'>
		<tr class="HEADER">
			<td colspan="3" width="95%" nowrap="nowrap">Generate PO &gt;&gt;</td>
			<td width="5%" align="right"><img style='cursor: pointer;' src='../../hisglobal/images/popUp_cancel.JPG' onclick='cancelToDesk()'></td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td width="25%" class="LABEL">Store Name</td>
			<td width="25%" class="CONTROL"><html:hidden
				name="PODeskGenerateTransBean" property="strStoreId"></html:hidden><bean:write
				name="PODeskGenerateTransBean" property="strStoreName"
				filter="false"></bean:write></td>
			<td width="25%" class="LABEL">Item
			Category</td>
			<td width="25%" class="CONTROL">
			<html:hidden
				name="PODeskGenerateTransBean" property="strItemCat"></html:hidden><bean:write
				name="PODeskGenerateTransBean" property="strItemCatName"
				filter="false"></bean:write>
			</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">PO Type
			</td>
			<td width="25%" class="CONTROL">
			<html:hidden
				name="PODeskGenerateTransBean" property="strPOTypeId"></html:hidden><bean:write
				name="PODeskGenerateTransBean" property="strPOType"
				filter="false"></bean:write>
			</td>
			
			<td width="25%" class="LABEL"><div style='display:none;'>Po Date</div></td>
			<td width="25%" class="CONTROL"><div style='display:none;'>
			<html:hidden
				name="PODeskGenerateTransBean" property="strpoDateId"></html:hidden><bean:write
				name="PODeskGenerateTransBean" property="strpoDate"
				filter="false"></bean:write></div>
			</td>
			
			
			
			<td width="25%" class="LABEL"><div style="display:none"><font color="red">*</font>Supplier(*Marked
			are Rated Supplier)</div></td>
			<td width="25%" class="CONTROL">
			<div id="divSupplier" style="display:none"><select name="strSupplierId">
				<option value="0">Select Value</option>
			</select></div>
			<div id="divSupplierLabel" style="display:none" ></div>
			</td>
		</tr>
	</table>

	<div id="divPlusMinusRequestDtl" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td class="TITLE" colspan="5">
			<div id="divRequestDetailsPlusID" style="display: none;" align="left"><img
				src="../../hisglobal/images/plus.gif"
				onclick="showDiv('divRequestDetailsMinusID'),hideDiv('divRequestDetailsPlusID'),showDiv('divRequestDetails');"
				style="cursor: pointer;"> Indent Details</div>
			<div id="divRequestDetailsMinusID" style="display: block;"
				align="left"><img src="../../hisglobal/images/minus.gif"
				onclick="hideDiv('divRequestDetailsMinusID'),hideDiv('divRequestDetails'),showDiv('divRequestDetailsPlusID');"
				style="cursor: pointer;"> Indent Details</div>
			</td>
		</tr>
	</table>
	</div>
	<div id="divRequestDetails"></div>
	<div id="divIndentNoDetail" class='popup' style="display: none; left:500px; top:250px;"></div>
	<div id="divFullCompiledBody" style="display: block">
	<div id="divRequestItemDetails">
	<bean:write
				name="PODeskGenerateTransBean" property="strReqModifyItemDtls"
				filter="false"></bean:write>
	<div id="divSuppId"></div></div>
	<div id="divReqItemDtlId" class='popup' style="display: none; left:500px; top:170px;"></div>
	<div id="divSuppWiseCompilation"></div>
	<div id="divDraftPODTL">
	<bean:write name="PODeskGenerateTransBean" property="strDraftPoDetails" filter="false"></bean:write>
	</div>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td class="TITLE" colspan="5">
			<div id="divPurchaseDetailsPlusID" style="display: none;" align="left"><img
				src="../../hisglobal/images/plus.gif"
				onclick="showDiv('divPurchaseDetailsMinusID'),hideDiv('divPurchaseDetailsPlusID'),showDiv('divPurchaseDetails');"
				style="cursor: pointer;"> Purchase Details</div>
			<div id="divPurchaseDetailsMinusID" style="display: block;"
				align="left"><img src="../../hisglobal/images/minus.gif"
				onclick="hideDiv('divPurchaseDetailsMinusID'),hideDiv('divPurchaseDetails'),showDiv('divPurchaseDetailsPlusID');"
				style="cursor: pointer;"> Purchase Details</div>
			</td>
		</tr>
	</table>
	<div id="divPurchaseDetails">
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	    <tr>
			<td class="LABEL" colspan="4">
			 <div style='display:none;'>
			   <input type="radio" name="strSupplierType" value="0" checked="checked" onClick="onRadio(this)" />Indian &nbsp;&nbsp; 
               <input type="radio" name="strSupplierType" value="1" onClick="onRadio(this)" />Imported
			  </div>
			</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><div style="display:none"><font color="red">*</font>Purchase
			Source</div></td>
			<td width="25%" class="CONTROL">
			<div id="divPurchaseSource" style="display:none"><select name="strDPurchaseSource">
				<bean:write name="PODeskGenerateTransBean"
					property="strPurchaseSourceValues" filter="false"></bean:write>
			</select></div>
			</td>
			<td width="25%" class="LABEL"><div style='display:none;'><font color="red">*</font>Delivery
			Date</div></td>
			<td width="25%" class="CONTROL"><div style='display:none;'><dateTag:date
				name="strDDeliveryDate"  value ="${PODeskGenerateTransBean.strIndianDeleivryDate}"  ></dateTag:date></div></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Delivery
			Location</td>
			<td width="25%" class="CONTROL">
			<div id="divDeliveryLocation"><select
				name="strDDeliveryLocation">
				<bean:write name="PODeskGenerateTransBean"
					property="strDeliveryLocationValues" filter="false"></bean:write>
			</select></div>
			</td>
			<td width="25%" class="LABEL"><div style = "display:none;">Tax</div></td>
			<td width="25%" class="CONTROL"><div style = "display:none;"><input type="text" maxlength="5"
				onkeypress='return validateData(event,7);'
				onkeyup='notGreaterThanCent(this)' autocomplete="off" name="strDOverAllTax" value ="${PODeskGenerateTransBean.strTax}"
				class="txtFldMin">%</div></td>
		</tr>
		<!--<tr>
			<td width="25%" class="LABEL">Tender No.</td>
			<td width="25%" class="CONTROL"><input type="text"
				maxlength="50" onkeypress='return validateData(event,16);'
				name="strDTenderNo"></td>

			<td width="25%" class="LABEL">Quotation No.</td>
			<td width="25%" class="CONTROL"><input type="text"
				maxlength="50" onkeypress='return validateData(event,16);'
				name="strDQuotationNo"></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Tender Date</td>
			<td width="25%" class="CONTROL"><dateTag:date
				name="strDTenderDate"></dateTag:date></td>

			<td width="25%" class="LABEL">Quotation Date</td>
			<td width="25%" class="CONTROL"><dateTag:date
				name="strDQuotationDate"></dateTag:date></td>
		</tr>  -->
		<tr>
			<td width="25%" class="LABEL"><div style='display:none;'><Font color="red">*</Font>PO Ref. No</div></td>
			<td width="25%" class="CONTROL"><div style='display:none;'><input type="text"
				maxlength="50" autocomplete="off" onkeypress='return validateData(event,16);'
				name="strDPORefNo"></div></td>

			<td width="25%" class="LABEL"><div style='display:none;'><Font color="red">*</Font>PO Date</div></td>
			<td width="25%" class="CONTROL"><div style='display:none;'><dateTag:date
				name="strDPORefDate" value ="${PODeskGenerateTransBean.strCurrentDate}"></dateTag:date></div></td>
		</tr>
		<tr>
				<td width="25%" class="LABEL" ><Font color="red">*</Font>PO Raised By</td>
				<td width="25%" class="CONTROL"><select name="strVerifiedBy" class="comboMax">
				<bean:write name="PODeskGenerateTransBean"
					property="strApprovedByVals" filter="false"></bean:write>
				</select>
				</td>
				<td width="25%" class="LABEL" ><div style="display:none;"><Font color="red">*</Font>PO Verified Date</div></td>
				<td width="25%" class="CONTROL"><div style="display:none;"><dateTag:date name="strVerifiedDate" value ="${PODeskGenerateTransBean.strCurrentDate}"></dateTag:date></div></td>
			</tr>
		<tr>
			<td width="25%" class="LABEL">Remarks</td>
			<td width="75%" class="CONTROL" colspan="3"><textarea
				onkeyup="maxLengthRemarks(this,'100')" name=strDRemarks></textarea></td>
		</tr>
		<logic:equal value="21" property='tmpPoType' name='PODeskGenerateTransBean' >
		<tr>
			<td width="25%" class="LABEL">References and Comments</td>
			<td width="75%" class="CONTROL" colspan="3"><textarea rows='7' cols='100'
				onkeyup="maxLengthRemarks(this,'2000')" name=strDComments></textarea></td>
		</tr>
		
		<tr>
			<td width="25%" class="LABEL">Additional Notes</td>
			<td width="75%" class="CONTROL" colspan="3"><textarea rows='7' cols='100'
				onkeyup="maxLengthRemarks(this,'2000')" name=strDNotes></textarea></td>
		</tr>
		</logic:equal>
		
	</table>
	</div>
	<div id="divFullOtherDetails" style="display:none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td class="TITLE" colspan="5">
			<div id="divOtherDetailsPlusID" style="display: none;" align="left"><img
				src="../../hisglobal/images/plus.gif"
				onclick="showDiv('divOtherDetailsMinusID'),hideDiv('divOtherDetailsPlusID'),showDiv('divOtherDetails');"
				style="cursor: pointer;"> Other Details</div>
			<div id="divOtherDetailsMinusID" style="display: block;" align="left"><img
				src="../../hisglobal/images/minus.gif"
				onclick="hideDiv('divOtherDetailsMinusID'),hideDiv('divOtherDetails'),showDiv('divOtherDetailsPlusID');"
				style="cursor: pointer;"> Other Details</div>
			</td>
		</tr>
	</table>
	<div id="divOtherDetails" style="display:none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Agent Name</td>
			<td width="25%" class="CONTROL">
			<div id="divAgentName"><select name="strDAgentName">
				<option value=0>Select Value</option>
			</select></div>
			</td>
			<td width="25%" class="LABEL"><font color="red">*</font>CA Name</td>
			<td width="25%" class="CONTROL">
			<div id="divCAName"><select name="strDCAName">
				<option value=0>Select Value</option>
			</select></div>
			</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>IAC Charges</td>
			<td width="25%" class="CONTROL"><input type="text" maxlength="2"
				onkeypress='return validateData(event,7);' class="txtFldMin" name="strDIACCharge">%</td>
			<td width="25%" class="LABEL"><font color="red">*</font>Insurance Charges</td>
			<td width="25%" class="CONTROL"><input type="text" maxlength="7"
				onkeypress='return validateData(event,7);'
				name="strDInsuranceCharge"></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Demurrages By</td>
			<td width="25%" class="CONTROL"><select name="strDDemurrageBy">
				<option value="0">Select Value</option>
				<option value="1">Supplier</option>
				<option value="2">Agent</option>
				<option value="3">Hospital</option>
			</select></td>

			<td width="25%" class="LABEL"><font color="red">*</font>Currency Name</td>
			<td width="25%" class="CONTROL">
			<div id="divCurrencyName"><select name="strDCurrencyName" onchange="setINRCurrency(this);">
				<bean:write name="PODeskGenerateTransBean" 
					property="strCurrencyValues" filter="false"></bean:write>
			</select></div>
			</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Currency Value</td>
			<td width="75%" class="CONTROL" colspan="3"><input type=hidden
				name=strDNetAmount><input type="text" maxlength="7"
				onkeypress='return validateData(event,7);' name="strDCurrencyValue"></td>
		</tr>
	</table>
	</div>
	</div>
	
	</div>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px" id="divCompile">
	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="FOOTER">
		<td colspan="2"><div align='left'>In case of Non RC items total PO cost may vary</div></td>
			<td colspan="2"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>
	

	<div id="divSaveCancelId" style="display: none">
	<!-- 
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>
			<td align="center"><div id ='svbtn' style = 'display:none'><img
				src="../../hisglobal/images/btn-sv.png"
				style="cursor: pointer; " title="Save Record"
				onClick="return validate1();" /> <img
				src="../../hisglobal/images/btn-ccl.png"
				style="cursor: pointer; " title="Cancel Process"
				onClick="cancelToDesk();"></div></td>
		</tr>
	</table> -->
<br>
<div align="center" id="svbtn">	
				<logic:equal value="21" property='tmpPoType' name='PODeskGenerateTransBean' >				 
					 	<a href="#" class="largebutton" id="submitId" onclick=' return validateDraft();'><span class="save">Save Draft</span></a></logic:equal>
				<logic:notEqual value="21" property='tmpPoType' name='PODeskGenerateTransBean' >				 
					 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a></logic:notEqual>
						<a href="#" class="button" onclick="cancelToDesk();"><span class="cancel">Cancel</span></a>
					</div> 
	</div>
	<input type="hidden" name="strCurrentDate" value="${ PODeskGenerateTransBean.strCurrentDate}" />
	<input type="hidden" name="strItemIds" />
	<input type="hidden" name="strINRCurrencyId"  value="${ PODeskGenerateTransBean.strINRCurrencyId}" />
	<input type="hidden" name="strItemBrandIds" />
	<input type="hidden" name="strIndianDeleivryDate" value="${ PODeskGenerateTransBean.strIndianDeleivryDate}"/>
	<input type="hidden" name="strImportedDeleivryDate" value="${ PODeskGenerateTransBean.strImportedDeleivryDate}"/>
	<input type="hidden" name="strStoreIds" />
	<input type="hidden" name="strRequestIds" />
	<input type="hidden" name="strIndianImportedFlg" value="0" />
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strSDFFlgColor"     value="${PODeskGenerateTransBean.strSDFFlgColor}">
	<input type="hidden" name="tmpPoType"     value="${PODeskGenerateTransBean.tmpPoType}">
	<input type="hidden" name="strStoreName"     value="${PODeskGenerateTransBean.strStoreName}">
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>