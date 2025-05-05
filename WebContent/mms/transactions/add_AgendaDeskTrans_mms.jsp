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
<title>Compilation Desk</title>
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
<script language="Javascript" src="../../mms/js/agendaDesk.js"></script>
<script language="Javascript" src="../../mms/js/agendaAddJS.js"></script>

</head>
<body>
<html:form action="/transactions/AgendaDeskAddTransCNT">

	<center>
	<div id="errMsg" class="errMsg"><bean:write
		name="agendaDeskAddTransBean" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="agendaDeskAddTransBean" property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="agendaDeskAddTransBean" property="strMsg" /></div>

	
	<tag:tab tabLabel="Compilation Desk"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>

</center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4">Compilation &gt;&gt;</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">From Substore</td>
			<td width="25%" class="CONTROL"><html:hidden
				name="agendaDeskAddTransBean" property="strStoreId"></html:hidden><bean:write
				name="agendaDeskAddTransBean" property="strStoreName" filter="false"></bean:write></td>
			<td width="25%" class="LABEL">Item Category</td>
			<td width="25%" class="CONTROL"><html:hidden
				name="agendaDeskAddTransBean" property="strItemCat"></html:hidden><bean:write
				name="agendaDeskAddTransBean" property="strItemCatName"
				filter="false"></bean:write></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>To Substore</td>
			<td width="25%" class="CONTROL">
			<div id="divToStore"><select name="strToStore" class="comboMax">
				<bean:write name="agendaDeskAddTransBean"
					property="strToStoreValues" filter="false"></bean:write>
			</select></div>
			<div id="divToStoreLabel"></div>
			</td>

			<td class="CONTROL" colspan="2"></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Compilation Type
			</td>
			<td width="25%" class="CONTROL">
			<div id="divToStore"><select name="strAgendaType" class="comboMax" style='width: 250px'>
			<option value="1">LP Compilation(Patient Wise)</option>
			<option value="2">LP Compilation</option>	
			</select></div>
			</td>
			<td width="25%" class="LABEL"></td>
			<td width="25%" class="CONTROL"></td>
		</tr>
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
		<!--  <td width="25%" class="LABEL"><font color="red">*</font>Agenda	Period</td>
			<td width="25%" class="CONTROL">

		<div id="divAgendaPeriod">
			   <select class='comboNormal' name='strAgendaPeriod'> 
		              <bean:write name="agendaDeskAddTransBean" property="strAgendaPeriod" filter="false"/>  
	           </select>&nbsp;&nbsp;-->
		    <!--  </div>-->	   
			<!--  <div id="divAgendaPeriodLabel"></div> -->
			<!--  </td>-->
			<td class="CONTROL" width="25%">
			<div id="agendaPeroidText">
				<!--  <input type="text" class="txtFldMax" name="strAgendaPeriodValue" onkeypress="return validateData(event,3);" maxlength=""></div> -->
			</div>	
			</td >
			<td width="25%"  class="CONTROL">
			<br>
			<div id="goButton"><!-- <img src="../../hisglobal/images/Go.png" onclick="getIndentDetails(this);" style="cursor: pointer;"> -->
			<a href="#" class="button" id="go" onclick="getIndentDetails(this);"><span class=" "></span></a>
		</div>
			</td>
		</tr>
		</table>
		<div style="display: none">
		<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
		<td width="25%" class="LABEL"><font color="red">*</font>Grant
			Type</td>
			<td width="25%" class="CONTROL">
			<div id="divGrantType"><select name="strGrantTypeId">
				<bean:write name="agendaDeskAddTransBean"
					property="strGrantTypeValues" filter="false"></bean:write>
			</select></div>
			<div id="divGrantTypeLabel"></div>
			</td>
			<td width="25%" class="CONTROL" colspan="2"></td>
			</tr>
			</table>
			</div>
	<div id="requestDtlsId" style="display: none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
			cellspacing="1px">
		<tr>
			<td colspan="4" class="TITLE" width="100%">
			<div id="indentPlusID" style="display: block;color:white;" align="left"><img
				src="../../hisglobal/images/plus.gif" onclick="showIndentData();"
				style="cursor: pointer;"> Request Details</div>
			<div id="indentMinusID" style="display: none;color:white;" align="left"><img
				src="../../hisglobal/images/minus.gif" onclick="hideIndentData();"
				style="cursor: pointer;"> Request Details</div>
			</td>
		</tr>
	</table>
	</div>
	<div id="indentDetails"><bean:write name="agendaDeskAddTransBean"
		property="strIndentDetails"></bean:write></div>
	<div id="itemFullDetailsId" style="display: none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td class="TITLE" colspan="5">
			<div id="itemPlusID" style="display: block;color:white;" align="left"><img
				src="../../hisglobal/images/plus.gif" onclick="showItemData();"
				style="cursor: pointer;"> Item Details</div>
			<div id="itemMinusID" style="display: none;color:white;" align="left"><img
				src="../../hisglobal/images/minus.gif" onclick="hideItemData();"
				style="cursor: pointer;"> Item Details</div>
			</td>
		</tr>
	</table>
	<div id="itemDtlsId" style="display: none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px" bgcolor='black'
		cellspacing="1px" id="itemDtlsTableId">
		<tr>
			<td width="20%" id='df' class="multiLabel">Item Name</td>
			<td width="20%" class="multiLabel">Brand Name</td>
			<td width="20%" class="multiLabel">Compiled Qty</td>
			<td width="20%" class="multiLabel">Last Purchase Rate</td>
			<td width="20%" class="multiLabel">Last Received Qty</td>
		</tr>
	</table>
	<div id="itemDetId"></div>
	</div>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="TITLE">
			<td colspan="2"></td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">Remarks</td>
			<td width="50%" class="CONTROL"><html:textarea
				property="strRemarks" onkeyup="maxLengthRemarks(this,100)"
				name="agendaDeskAddTransBean"></html:textarea></td>
		</tr>
	</table>
	</div>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="FOOTER">
			<td colspan="4"><font size="2" color="red">*</font>Mandatory Fields  ['*'] Reserved/Branded Item</td>
		</tr>
	</table>
	<div id="saveCancelId" style="display: none">
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>
			<td align="center"><img
				src="../../hisglobal/images/btn-sv.png"
				style="cursor: pointer; " title="Save Record"
				onClick="return validate1();" /> <img
				src="../../hisglobal/images/btn-ccl.png"
				style="cursor: pointer; " title="Cancel Process"
				onClick="cancelToDesk();"></td>
		</tr>
	</table>
	</div>
	<!-- <div id="compileId">
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>
			<td align="center">
			<center><img src="../../hisglobal/images/Compile.png"
				style="cursor: pointer; " title="Save Record"
				onClick="compileIndent();"><img
				src="../../hisglobal/images/back_tab.png"
				style="cursor: pointer; " title="Cancel Process"
				onClick="cancelToDesk();"></center>
			</td>
		</tr>
	</table> -->
	<br>
	</div>
	<div align="center" id="compileId">					 
					 	<a href="#" class="button" id=" " onclick='compileIndent();'><span class="compile">Compile</span></a>
						<a href="#" class="button"	onclick="cancelToDesk();"><span class="back">Back</span></a> 
					</div> 
	<input type="hidden" name="strItemIds" />
	<input type="hidden" name="strItemBrandIds" />
	<input type="hidden" name="strStoreIds" />
	<input type="hidden" name="strRequestIds" />
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strSDFFlgColor"     value="${agendaDeskAddTransBean.strSDFFlgColor}">
	
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex> 
</body>
</html>