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
<script language="Javascript" src="../../mms/js/POCancelJS.js"></script>

</head>
<body>
<html:form action="/transactions/PODeskCancelTransCNT">

	<center>
	<div id="errMsg" class="errMsg"><bean:write
		name="PODeskCancelTransBean" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="PODeskCancelTransBean" property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="PODeskCancelTransBean" property="strMsg" /></div>

	</center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td width="100%"><tag:tab tabLabel="PO Desk" selectedTab="FIRST"
				align="left" width="100%">
			</tag:tab></td>
		</tr>
	</table>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="3">Cancel PO &gt;&gt;</td>
			<td>
			<div align="right"><input type="radio"
				onclick="showDiv('divPOCancelDtl'),hideDiv('divPOModifyDtl'),disableRadio()"
				name="strDPOCancelOrModify" value=1 checked="checked">
			Cancel&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio"
				onclick="showDiv('divPOModifyDtl'),hideDiv('divPOCancelDtl'),enableRadio()"
				name="strDPOCancelOrModify" value=2> Modify</div>
			</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Store Name</td>
			<td width="75%" colspan="3" class="CONTROL"><html:hidden
				name="PODeskCancelTransBean" property="strStoreId"></html:hidden><bean:write
				name="PODeskCancelTransBean" property="strStoreName" filter="false"></bean:write></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">PO No.</td>
			<td width="25%" class="CONTROL"><html:hidden
				name="PODeskCancelTransBean" property="strPONo"></html:hidden><bean:write
				name="PODeskCancelTransBean" property="strPONo" filter="false"></bean:write></td>
			<td width="25%" class="LABEL">PO Date</td>
			<td width="25%" class="CONTROL"><html:hidden
				name="PODeskCancelTransBean" property="strPODate"></html:hidden><bean:write
				name="PODeskCancelTransBean" property="strPODate" filter="false"></bean:write>
			</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">PO Type</td>
			<td width="25%" class="CONTROL"><html:hidden
				name="PODeskCancelTransBean" property="strPOTypeId"></html:hidden><bean:write
				name="PODeskCancelTransBean" property="strPOType" filter="false"></bean:write>
			</td>

			<td width="25%" class="LABEL">Item Category</td>
			<td width="25%" class="CONTROL"><html:hidden
				name="PODeskCancelTransBean" property="strItemCat"></html:hidden><bean:write
				name="PODeskCancelTransBean" property="strItemCatName"
				filter="false"></bean:write></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Supplier Name</td>
			<td width="75%" colspan="3" class="CONTROL"><html:hidden
				name="PODeskCancelTransBean" property="strSupplierId"></html:hidden><bean:write
				name="PODeskCancelTransBean" property="strSupplierName"
				filter="false"></bean:write></td>
		</tr>
		<bean:write name="PODeskCancelTransBean"
			property="strForeignPODetails" filter="false"></bean:write>
	</table>


	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td class="TITLE" colspan="5">
			<div id="divPOScheduleDetailsPlusID" style="display: none;color:blue;"
				align="left"><img src="../../hisglobal/images/plus.gif"
				onclick="showDiv('divPOScheduleDetailsMinusID'),hideDiv('divPOScheduleDetailsPlusID'),showDiv('divPOScheduleDetails');"
				style="cursor: pointer;"> Schedule Details</div>
			<div id="divPOScheduleDetailsMinusID" style="display: block;color:blue;"
				align="left"><img src="../../hisglobal/images/minus.gif"
				onclick="hideDiv('divPOScheduleDetailsMinusID'),hideDiv('divPOScheduleDetails'),showDiv('divPOScheduleDetailsPlusID');"
				style="cursor: pointer;"> Schedule Details</div>
			</td>
		</tr>
	</table>
	<div id=divPOScheduleDetails><bean:write
		name="PODeskCancelTransBean" property="strScheduleDetails"
		filter="false"></bean:write></div>

	<div id="divPOCancelDtl">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td class="TITLE" colspan="5">
			<div id="divPOCancelPlusID" style="display: block;color:blue;" align="left"><img
				src="../../hisglobal/images/plus.gif"
				onclick="showDiv('divPOCancelMinusID'),hideDiv('divPOCancelPlusID'),showDiv('divPOCancel');"
				style="cursor: pointer;"> Cancel Details</div>
			<div id="divPOCancelMinusID" style="display: none;color:blue;" align="left"><img
				src="../../hisglobal/images/minus.gif"
				onclick="hideDiv('divPOCancelMinusID'),hideDiv('divPOCancel'),showDiv('divPOCancelPlusID');"
				style="cursor: pointer;"> Cancel Details</div>
			</td>
		</tr>
	</table>

	<div id="divPOCancel" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Cancel By</td>
			<td width="75%" colspan="3" class="CONTROL"><select
				name="strDCancelBy">
				<bean:write name="PODeskCancelTransBean"
					property="strCancelByValues" filter="false"></bean:write>
			</select></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Cancel Remarks</td>
			<td width="75%" colspan="3" class="CONTROL"><textarea
				name="strDCancelRemarks"></textarea></td>
		</tr>
	</table>
	</div>
	</div>

	<div id="divPOModifyDtl" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td class="TITLE" colspan="5">
			<div id="divPOModifyPlusID" style="display: block;color:blue;" align="left"><img
				src="../../hisglobal/images/plus.gif"
				onclick="showDiv('divPOModifyMinusID'),hideDiv('divPOModifyPlusID'),showDiv('divPOModify');"
				style="cursor: pointer;"> Modify Details</div>
			<div id="divPOModifyMinusID" style="display: none;color:blue;" align="left"><img
				src="../../hisglobal/images/minus.gif"
				onclick="hideDiv('divPOModifyMinusID'),hideDiv('divPOModify'),showDiv('divPOModifyPlusID');"
				style="cursor: pointer;"> Modify Details</div>
			</td>
		</tr>
	</table>

	<div id="divPOModify1" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Delivery Date</td>
			<td width="75%" colspan="3" class="CONTROL"><dateTag:date
				name="strDDeliveryDate"></dateTag:date></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Approved By</td>
			<td width="25%" class="CONTROL"><select name="strDApprovedBy"">
				<bean:write name="PODeskCancelTransBean"
					property="strApprovedByValues" filter="false"></bean:write>
			</select></td>
			<td width="25%" class="LABEL"><font color="red">*</font>Approved Date</td>
			<td width="25%" class="CONTROL"><dateTag:date
				name="strDApprovedDate" value="${ PODeskCancelTransBean.strSysdate}"></dateTag:date></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Remarks</td>
			<td width="75%" colspan="3" class="CONTROL"><textarea
				name="strDRemarks"></textarea></td>
		</tr>
	</table>
	</div>
	</div>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="FOOTER">
			<td colspan="4"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>

<!-- 	<table border="0" class="TABLEWIDTH" align="center">
		<tr>
			<td align="center"><img
				src="../../hisglobal/images/btn-sv.png"
				style="cursor: pointer; " title="Save Record"
				onClick="return validate1();" /> <img
				src="../../hisglobal/images/btn-ccl.png"
				style="cursor: pointer; " title="Cancel Process"
				onClick="cancelToDesk();"></td>
		</tr>
	</table>-->
	<br>
<div align="center" id=" ">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
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