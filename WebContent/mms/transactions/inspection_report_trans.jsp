<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<!--  
 * Developer : Anshul Jindal
 * Version : 1.0 
 * Date : 10/April/2009
 *  Module:MMS
 * Unit:Bill Approval   
 -->



<html>
<head>
<meta charset=UTF-8">
<title>Inspection Report</title>
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
<script language="Javascript" src="../js/inspection_report_trans.js"></script>


</head>
<body>
<html:form name="inspectionReportBean"
	action="transactions/InspectionReportTransCNT"
	type="mms.transactions.controller.fb.InspectionReportTransFB">

	<center>
	<div id="errMsg" class="errMsg"><bean:write
		name="inspectionReportBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="inspectionReportBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="inspectionReportBean" property="strNormalMsg" /></div>


	<tag:tab tabLabel="Inspection Report" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="6"></td>
		</tr>

		<tr>
			<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>Store Name</td>
			<td width="25%" class="CONTROL" colspan="3"><select name="strStoreId"
				class="comboNormal" onchange="getReqNo(this);">
				<bean:write name="inspectionReportBean" property="strStoreCmb"
					filter="false" />
			</select></td>

		</tr>
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Request
			No.</td>
			<td width="25%" class="CONTROL"><div id="reqComboDiv"><select name="strReqNo"
				class="comboNormal" onchange="OrderDetails(this);">
				<option value="0">Select Value</option>
			</select></div></td>

			<td class="LABEL" width="25%">Request
			Date</td>
			<td width="25%" class="CONTROL">
			<div id="ReqDateDivId"></div>
			</td>
		</tr>
		<tr>
			<td class="LABEL" width="25%">PO 
			No.</td>
			<td width="25%" class="CONTROL">
			<div id="orderNoDivId"></div>
			</td>

			<td class="LABEL" width="25%">PO 
			Date</td>
			<td width="25%" class="CONTROL">
			<div id="orderDateDivId"></div>
			</td>
		</tr>

		<tr>
			<td class="LABEL" width="25%">Supplier
			Name</td>
			<td width="25%" class="CONTROL">
			<div id="supplierNameDivId"></div>
			</td>

			<td class="LABEL" width="25%">Item
			Category</td>
			<td width="25%" class="CONTROL">
			<div id="itemCatDivId"></div>
			</td>
		</tr>

		<tr>
			<td class="LABEL" width="25%">Committee
			Name</td>
			<td width="25%" class="CONTROL" colspan="3">
			<div id="committeeNameDivId"></div>
			</td>

		</tr>

	</table>

	
	<div id="itemDetailsDivId"></div>
<div id="reportDetailsDivId" style="display: none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		
		<tr>

			<td width="50%" class="TITLE" valign="top" colspan="4">Inspection Report Details</td>
			
		</tr>

		<tr>

			<td width="50%" class="LABEL" valign="top" colspan="2"><font color="red">*</font>Inspection Report</td>
			<td width="50%" class="CONTROL" colspan="2"><textarea
				name="strInspectionReport" cols="25" rows="2"></textarea></td>
		</tr>

		<tr>
			<td class="LABEL" colspan="2"><font color="red">*</font>Status</td>
			<td class="CONTROL" colspan="2"><select name="strInspectionStatus"
				class="comboNormal" onchange="">
				<option value="1">Approved</option>
				<option value="2">Rejected</option>
			</select></td>

		</tr>
		<tr>
			<td class="LABEL" colspan="2"><font color="red">*</font>Return Qty</td>
			
			<td class="CONTROL">
			<input type="text" class="txtFldMin" name="strReturnQty" maxlength="8" onkeypress="return validateData(event,7);"/></td>
			<td class="CONTROL">
			<div id="unitDivId">
			<select name="strReturnUnitId"
				class="comboNormal" onchange="">
				<option value="0">Select Value</option>
			</select></div></td>

		</tr>
		<tr>
			<td colspan="4" align="center" class="multiControl">
				<img
				style="cursor: pointer; " title="Save Record"
				src="../../hisglobal/images/btn-ok.png"
				onClick=" return okReport();" /> <img
				style="cursor: pointer; " title="Cancel Report"
				src="../../hisglobal/images/btn-ccl.png" onClick="cancelReport();" /></td>
		</tr>
		
	</table>
	</div>
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
				onClick=" return saveReport();" /> <img
				style="cursor: pointer; " title="Clear Content"
				src="../../hisglobal/images/btn-clr.png"
				onClick="document.forms[0].reset();" /> <img
				style="cursor: pointer; " title="Cancel Process"
				src="../../hisglobal/images/btn-ccl.png" onClick="cancel();" /></td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strPath"
		value="${inspectionReportBean.strPath}" />
	<input type="hidden" name="strComboValue"
		value="${inspectionReportBean.strComboValue}" />
		<input type="hidden" name="strSelectedChkIndex"
		value="" />

</html:form>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>

