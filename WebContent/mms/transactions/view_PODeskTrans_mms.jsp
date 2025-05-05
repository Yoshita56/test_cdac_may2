<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


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
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../mms/js/PODesk.js"></script>
<script language="Javascript" src="../../mms/js/POViewJS.js"></script>

</head>
<body>
<html:form action="/transactions/PODeskViewTransCNT">

	<center>
	<div id="errMsg" class="errMsg"><bean:write
		name="PODeskViewTransBean" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="PODeskViewTransBean" property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="PODeskViewTransBean" property="strMsg" /></div>

   <tag:tab tabLabel="PO DESK VIEW" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>
   
	</center>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4">View PO &gt;&gt;</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Store Name</td>
			<td width="75%" colspan="3" class="CONTROL"><html:hidden
				name="PODeskViewTransBean" property="strStoreId"></html:hidden><bean:write
				name="PODeskViewTransBean" property="strStoreName" filter="false"></bean:write></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">PO No.</td>
			<td width="25%" class="CONTROL"><html:hidden
				name="PODeskViewTransBean" property="strPONo"></html:hidden><bean:write
				name="PODeskViewTransBean" property="strPONo" filter="false"></bean:write></td>
			<td width="25%" class="LABEL">PO Date</td>
			<td width="25%" class="CONTROL"><html:hidden
				name="PODeskViewTransBean" property="strPODate"></html:hidden><bean:write
				name="PODeskViewTransBean" property="strPODate" filter="false"></bean:write>
			</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">PO Type</td>
			<td width="25%" class="CONTROL"><html:hidden
				name="PODeskViewTransBean" property="strPOTypeId"></html:hidden><bean:write
				name="PODeskViewTransBean" property="strPOType" filter="false"></bean:write>
			</td>

			<td width="25%" class="LABEL">Item Category</td>
			<td width="25%" class="CONTROL"><html:hidden
				name="PODeskViewTransBean" property="strItemCat"></html:hidden><bean:write
				name="PODeskViewTransBean" property="strItemCatName"
				filter="false"></bean:write></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Supplier Name</td>
			<td width="75%" colspan="3" class="CONTROL"><html:hidden
				name="PODeskViewTransBean" property="strSupplierId"></html:hidden><bean:write
				name="PODeskViewTransBean" property="strSupplierName"
				filter="false"></bean:write></td>
		</tr>
		<bean:write name="PODeskViewTransBean"
			property="strForeignPODetails" filter="false"></bean:write>
	</table>


	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td class="TITLE" colspan="5">
			<div id="divPORequestDetailsPlusID" style="display: none;"
				align="left"><img src="../../hisglobal/images/plus.gif"
				onclick="showDiv('divPORequestDetailsMinusID'),hideDiv('divPORequestDetailsPlusID'),showDiv('divPORequestDetails');"
				style="cursor: pointer;"> Request Details</div>
			<div id="divPORequestDetailsMinusID" style="display: block;"
				align="left"><img src="../../hisglobal/images/minus.gif"
				onclick="hideDiv('divPORequestDetailsMinusID'),hideDiv('divPORequestDetails'),showDiv('divPORequestDetailsPlusID');"
				style="cursor: pointer;"> Request Details</div>
			</td>
		</tr>
	</table>
	<div id=divPORequestDetails><bean:write
		name="PODeskViewTransBean" property="strRequestDetails"
		filter="false"></bean:write></div>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td class="TITLE" colspan="5">
			<div id="divPOItemPlusID" style="display: none;" align="left"><img
				src="../../hisglobal/images/plus.gif"
				onclick="showDiv('divPOItemMinusID'),hideDiv('divPOItemPlusID'),showDiv('divPOItem');"
				style="cursor: pointer;"> Item Details</div>
			<div id="divPOItemMinusID" style="display: block;" align="left"><img
				src="../../hisglobal/images/minus.gif"
				onclick="hideDiv('divPOItemMinusID'),hideDiv('divPOItem'),showDiv('divPOItemPlusID');"
				style="cursor: pointer;"> Item Details</div>
			</td>
		</tr>
	</table>

	<div id="divPOItem"><bean:write
		name="PODeskViewTransBean" property="strItemDetails"
		filter="false"></bean:write>
	</div>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="FOOTER">
			<td colspan="4"><font size="2" color="red">*</font> Mandatory
			Fields </td>
		</tr>
	</table>

	<!-- <table border="0" class="TABLEWIDTH" align="center">
		<tr>
			<td align="center"><img
				src="../../hisglobal/images/back_tab.png"
				style="cursor: pointer; " title="Cancel Process"
				onClick="cancelToDesk();"></td>
		</tr>
	</table>-->
	<br>
<div align="center" id=" ">					 
					 <a href="#" class="button" onclick="cancelToDesk();"><span class="cancel">Cancel</span></a>
					</div> 
	<input type="hidden" name="strItemIds" />
	<input type="hidden" name="strItemBrandIds" />
	<input type="hidden" name="strStoreIds" />
	<input type="hidden" name="strRequestIds" />
	<input type="hidden" name="hmode" />
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>