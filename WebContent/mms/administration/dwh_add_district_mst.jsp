<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<!-- 
/**
 * @author Adil Wasi  
 * Creation Date:- 27-July-2011 
 * Modifying Date:- 
 * Used For:- 
 * Team Lead By:-  
 * Module:- DWH(HIS Project)
 * 
 */
 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>District Master Add Page</title>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../mms/js/dwh_district_mst.js"></script>

</head>

<body onLoad="setFocus();">
<html:form name="districtMstBean" action="/masters/DistrictMstCNT"
	type="mms.masters.controller.fb.StateMstFB">

	<div id="strErrMsg" class="errMsg"><bean:write name="districtMstBean"
		property="strErrMsg" /></div>
	<div class="warningMsg"><bean:write name="districtMstBean"
		property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="districtMstBean"
		property="strNormalMsg" /></div>

	<tag:tab tabLabel="District Master" selectedTab="FIRST" align="center"
		width="TABLEWIDTH" onlyTabIndexing="1">
	</tag:tab>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="2">District Master&gt;&gt;Add</td>
		</tr>

		<tr>
			<td class="LABEL"><font color="red">*</font>Country Name</td>

			<td class="CONTROL" colspan="2">
			<div id="LeftUserDivId" align="left"><select class='comboNormal' name="strCountryId" tabindex="1" onChange="getStateCmb();">
				<bean:write name="districtMstBean" property="strCountryCombo"
					filter="false" />
			</select></div>
			</td>
		</tr>


		<tr>
			<td class="LABEL"><font color="red">*</font>State Name</td>

			<td class="CONTROL" colspan="2">
			<div id="stateCmbDivId" align="left">
			<select	class='comboNormal' name="strStateId" tabindex="1">
				<option value="0">Select Value</option>
				<bean:write name="districtMstBean" property="strStateCombo"
					filter="false" />
			</select></div>
			</td>
		</tr>

		<tr>
			<td class="LABEL"><font color="red">*</font>District Name</td>
			<td width="50%" class="CONTROL">
			<input type="text" name="strDistrictName" value="" maxlength="25" tabindex="1" onkeypress="return validateData(event,18);"></td>
		</tr>

		<tr>
			<td class="LABEL"><font color="red">*</font>District Short Name</td>
			<td width="50%" class="CONTROL">
				<input type="text" name="strDistrictShortName" tabindex="1" value="" maxlength="5"
				onkeypress="return validateData(event,18);"></td>
		</tr>

		<tr>
			<td class="LABEL" width="50%"><font color="red">*</font>Effective
			From Date</td>
			<td class="CONTROL"><dateTag:date name="strEffectiveFrom"
				value="${districtMstBean.strCtDate}"></dateTag:date></td>
		</tr>
		
		<tr>
			<td class="LABEL" width="50%"><font color="red">*</font>Effective
			To Date</td>
			<td class="CONTROL"><dateTag:date name="strEffectiveTo"
				value="${districtMstBean.strCtDate}"></dateTag:date></td>
		</tr>

		<tr>
			<td class="LABEL" >
			<div align="right">Remarks</div>
			</td>
			<td class="CONTROL">
			<div align="left"><textarea name="strRemarks" rows="2" tabindex="1"></textarea>
			</div>
			</td>
		</tr>



		<tr class="FOOTER">
			<td colspan="2"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>

	<table CLASS="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td align="center">
			  <img src="../../hisglobal/images/btn-sv.png"  style="cursor: pointer;" title="Save Record" tabindex="1" onClick="return validate1();" onkeypress="if(event.keyCode==13) validate1();"/>
			  <img src="../../hisglobal/images/btn-clr.png"	style="cursor: pointer;" title="Reset Content" tabindex="1" onClick="document.forms[0].reset(),clearMsg('ADD');" onkeypress="if(event.keyCode==13) document.forms[0].reset(),clearMsg('ADD');" /> 
			  <img src="../../hisglobal/images/btn-ccl.png" style="cursor: pointer;" title="Cancel Process" tabindex="1" onClick="cancel('LIST');" onkeypress="if(event.keyCode==13) cancel('LIST');"/></td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />
	


	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>
