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
<title>Compilation View</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" 
type="text/css">
<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/agenda_view_trans.js"></script>
<script language="Javascript" src="../../mms/js/agendaDesk.js"></script>
</head>
<body>
<html:form name="agendaViewBean"
	action="/transactions/AgendaViewTransCNT" type="mms.transactions.controller.fb.AgendaViewTransFB">

	<center>
	<div id="errMsg" class="errMsg"><bean:write name="agendaViewBean"
		property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="agendaViewBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="agendaViewBean" property="strNormalMsg" /></div>

	
	<tag:tab tabLabel="Compilation View"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
			</center>

	<div class='popup' id='indentDtlId' style="display: none">
	<table width='400' border="0" cellspacing="1" cellpadding="1">
		<tr class="HEADER">

			<th align='right'><img style='cursor: pointer; '
				src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideIndentDetails('indentDtlId');"></th>
		</tr>
	</table>


	<table width='400' border="0" cellspacing="1" cellpadding="1">
		<tr>
			<td colspan="1" class='multiLabel'>Item Name</td>
			<td colspan="1" class='multiLabel'>Brand Name</td>
			<td colspan="1" class='multiLabel'>Required Qty</td>
			<td colspan="1" class='multiLabel'>Available Qty</td>

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
			<td colspan="1" class='multiControl'>
			<div id='4'></div>
			</td>

		</tr>
	</table>
	</div>

	<div class='popup' id='compiledItemId' style="display: none">
	<table width='400' border="0" cellspacing="1" cellpadding="1">
		<tr class="HEADER">
			<th align='right'><img style='cursor: pointer; '
				src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideCompiledItemDetails('compiledItemId');"></th>
		</tr>
	</table>


	<table width='400' border="0" cellspacing="1" cellpadding="1">
		<tr>
			<td colspan="1" class='multiLabel'>Last Purchase Rate</td>
			<td colspan="1" class='multiLabel'>Last Receiving Qty</td>
			<td colspan="1" class='multiLabel'>Last Year Consumption</td>

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
	</table>
	</div>


	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4">Compilation View&gt;&gt;</td>
		</tr>
		<tr>
			<td width="25%" class='LABEL'>Store</td>
			<td width="25%" class='CONTROL'><bean:write name="agendaViewBean" property="strStoreName"></bean:write></td>
			<td width="25%" class='LABEL'>Category Type</td>
			<td width="25%" class='CONTROL'><bean:write name="agendaViewBean" property="strItemCategory"></bean:write></td>
		</tr>
		<tr>
			<td width="25%" class='LABEL'>Compilation No.</td>
			<td width="25%" class='CONTROL'><bean:write name="agendaViewBean" property="strAgendaNo"></bean:write></td>
			<td width="25%" class='LABEL'>Compilation Date</td>
			<td width="25%" class='CONTROL'><bean:write name="agendaViewBean" property="strAgendaDate"></bean:write></td>
		</tr>
		<tr>
			<td width="25%" class='LABEL'>Sub Store</td>
			<td width="25%" class='CONTROL' colspan="3"><bean:write name="agendaViewBean" property="strToStoreName"></bean:write></td>
		</tr>
	</table>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td colspan="5" class="TITLE"><div id='' style="color: white;">Indent Details</div></td>
		</tr>
	</table>	
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1" bgcolor="#6097BC">
		<tr>
			<td class="multiLabel" width="21%" colspan="1">Request No.</td>
			<td class="multiLabel" width="21%" colspan="1">Request Date</td>
			<td class="multiLabel" width="21%" colspan="1">Raising Store</td>
		</tr>

	
	<bean:write name="agendaViewBean" property="strIndentDetails"
		filter="false" /></table>


	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td colspan="6" class="TITLE"><div id='' style="color: white;">Compiled Item Details</div></td>
		</tr>
    </table>
    <table class="TABLEWIDTH" align="center" cellpadding="1"  cellspacing="1" bgcolor="#6097BC">
		<tr>
			<td class="multiLabel" width="32%" colspan="1">Item Name</td>
			<td class="multiLabel" width="16%" colspan="1">Approx Rate/Unit</td>
			<td class="multiLabel" width="16%" colspan="1">Compiled Qty</td>
			<td class="multiLabel" width="16%" colspan="1">Sanction Qty</td>
			<td class="multiLabel" width="20%" colspan="1">Processed Qty</td>
		</tr>
	
	<bean:write name="agendaViewBean" property="strCompiledItemDetails"
		filter="false" /></table>
	<bean:write name="agendaViewBean" property="strApprovalDetails"
		filter="false" />

	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td class="LABEL" width="50%" colspan="1">Remarks</td>
			<td width="50%" class="CONTROL" colspan="3"><bean:write
				name="agendaViewBean" property="strRemarks" filter="false" /></td>
		</tr>

		<tr class="FOOTER">
			<td colspan="4" width="25%">['*'] Reserved/Branded Item</td>
		</tr>

	</table>

	<!--  <table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>

			<td align="center"><img style="cursor: pointer; "
				src="../../hisglobal/images/back_tab.png"
				onClick="cancelToDesk();" title="Cancel Process"></td>
		</tr>
	</table>-->
		<div align="center" id=" ">					 
					 	<a href="#" class="button" id=" " onclick='compileIndent();'><span class="compile">Compile</span></a>
						<a href="#" class="button"	onclick="cancelToDesk();"><span class="back">Back</span></a> 
					</div> 
	<input type="hidden" name="hmode" />
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>