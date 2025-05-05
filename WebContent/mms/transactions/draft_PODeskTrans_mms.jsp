<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
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
<script language="Javascript" src="../../mms/js/POGenerateJS.js"></script>

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
			
			<td width="25%" class="LABEL">Po Date</td>
			<td width="25%" class="CONTROL">
			<html:hidden
				name="PODeskGenerateTransBean" property="strpoDateId"></html:hidden><bean:write
				name="PODeskGenerateTransBean" property="strPODate"
				filter="false"></bean:write>
			</td>
		</tr>
	</table>

	
	<div id="divDraftPODTL">
	<bean:write name="PODeskGenerateTransBean" property="strDraftPoDetails" filter="false"></bean:write>
	</div>
		
	

	<div id="divSaveCancelId" style="display: none">
	
<br>
<div align="center" id="svbtn">	
				<logic:equal value="21" property='tmpPoType' name='PODeskGenerateTransBean' >				 
					 	<a href="#" class="button" id="submitId" onclick=' return validateDraft();'><span class="savedraftpo">Save Draft</span></a></logic:equal>
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
	<input type="hidden" name="strPoNo"     value="${PODeskGenerateTransBean.strPoNo}">
	
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>