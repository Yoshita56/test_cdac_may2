<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset="utf-8">
<title>CIMS Generic Drug Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>


<script type="text/javascript"><!--
function closeView()
{
	window.close();
}
	
</script>
</head>
<body onload="">
<html:form action="/masters/CIMSGenericDrugMstCNT" name="cimsgenericdrugBean"
	type="mms.masters.controller.fb.CIMSGenericDrugMstFB">


	<center>
	<div class="errMsg" id="errMsgId"><bean:write
		name="cimsgenericdrugBean" property="strErrMssgstring" /></div>
	<div class="warningMsg" id="warningMsgId"><bean:write
		name="cimsgenericdrugBean" property="strWarnMssgstring" /></div>
	<div class="normalMsg" id="normalMsgId"><bean:write
		name="cimsgenericdrugBean" property="strNormMssgstring" /></div>
	<tag:tab tabLabel="CIMS Generic Drug Master" selectedTab="FIRST"
		align="center" width="TABLEWIDTH" onlyTabIndexing="1">

	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4" width="25%">CIMS Generic Drug Master&gt;&gt; View</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Group Name</td>
			<td class="CONTROL"><bean:write name="cimsgenericdrugBean"
				property="strGroupNameValue" filter="false" /></td>
			<td width="25%" class="LABEL">Sub Group Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="cimsgenericdrugBean" property="strSubGroupNameValue"
				filter="false" /></td>
		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL">ATC Classification</td>
			<td width="75%" class="CONTROLCIMS" colspan="3">
				<bean:write
				name="cimsgenericdrugBean" property="strAtcClassCode"
				filter="false" />
			</td>
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">Consumable Type</td>
			<td class="CONTROL" width="25%">
				 Consumable

			</td>
			<td width="25%" class="LABEL">Generic
			Drug Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="cimsgenericdrugBean" property="strDrugName"
				filter="false" /></td>
		</tr>
	    <tr>
			<td class="LABEL" width="25%">Pregnancy Category</td>
			<td class="CONTROLCIMS" width="25%">			
				<bean:write property="strPregnancySafeFlag" name="cimsgenericdrugBean" filter="false"/>
					
			</td>
			
			<td width="25%" class="LABEL">Contraindications</td>
			<td width="25%" class="CONTROLCIMS">
				<bean:write property="strContraindictioncode" name="cimsgenericdrugBean" filter="false"/>
			</td>
		</tr>
		<tr>
			<td class="LABEL"  width="25%">Drug Inventory Unit</td>
			<td class="CONTROLCIMS"  width="25%">
				<bean:write name="cimsgenericdrugBean"
					property="strInventoryUnitName" filter="false" />
            </td>
			<td class="LABEL" colspan="1" width="25%">Special Precautions</td>
			<td class="CONTROLCIMS" width="25%">
				<bean:write	property="strsprecau" name="cimsgenericdrugBean"  filter="false"/>
			</td>
			
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">Drug Interactions & Contradictions</td>
			<td class="CONTROLCIMS" width="25%">
				
				 <bean:write	property="strDrugval" name="cimsgenericdrugBean"  filter="false"/>

			
				
			</td>
			<td width="25%" class="LABEL">Adverse Drug Reactions</td>
			<td width="25%" class="CONTROLCIMS">
				<bean:write	property="stradvdrug" name="cimsgenericdrugBean"  filter="false"/>
			</td>			
		</tr>
		<tr>
			<td width="25%" class="LABEL">Administration</td>
			<td width="25%" class="CONTROLCIMS">
				<bean:write	 property="strDrugAdmincode" name="cimsgenericdrugBean"  filter="false"/>
					
				
			</td>
			<td width="25%" class="LABEL">Storage</td>
			<td width="25%" class="CONTROLCIMS">
				<bean:write property="strStoragecode" name="cimsgenericdrugBean" filter="false"/>
					
			</td>
			
			
		</tr>
		
		<tr>
			<td class="LABEL" colspan="1" width="25%">Mechanism of Action</td>
			<td class="CONTROLCIMS" width="25%">
				<bean:write	property="strmechact" name="cimsgenericdrugBean"  filter="false"/>
			</td>
			<td class="LABEL" colspan="1" width="25%">Laboratory Interferance</td>
			<td class="CONTROLCIMS" width="25%">
				<bean:write	property="strlabintfrnce" name="cimsgenericdrugBean"  filter="false"/>
			</td>
			
		</tr>
		<tr>
			<td width="25%" class="LABEL"></td>
			<td width="25%" class="CONTROLCIMS">
				
			</td>
			<td width="25%"  class="LABEL">Administration Route</td>			
			<td width="25%" class="CONTROLCIMS">
					<bean:write property="strAdminRoute" name="cimsgenericdrugBean"  filter="false"/>				
			</td>
		</tr>	
		<tr>
			
			<td class="LABEL" colspan="1" width="25%">Dosage(Adult)</td>
			<td class="CONTROLCIMS" width="25%">
				<bean:write	property="strdosageadult" name="cimsgenericdrugBean"  filter="false"/>
			</td><td class="LABEL" colspan="1" width="25%">Dosage(Peads)</td>
			<td class="CONTROLCIMS" width="25%">
				<bean:write	property="strdosagepeads" name="cimsgenericdrugBean"  filter="false"/>
			</td>
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">Shelf Life</td>
			<td class="CONTROLCIMS" colspan="" width="25%">
			<bean:write name="cimsgenericdrugBean"
					property="strShelfLife" filter="false" /></td>
			<td class="LABEL" colspan="1" width="25%">Time Format</td>
			<td class="CONTROLCIMS" colspan="1" width="25%"><bean:write name="cimsgenericdrugBean"
					property="strShelfTimeFormat" filter="false" /></td>
		</tr>
		</table>
		
	


	
	
	<table class="TABLEWIDTH" align="center" cellspacing="1px">

		<tr>

			<td align="center" colspan="2" width="25%"><!--  <img
				src="../../hisglobal/images/btn-ccl.png" title="Cancel Process"
				onClick="closeView();" style="cursor: pointer;"> -->
				<a href="#" class="button" onclick="closeView();"><span class="cancel">Cancel</span></a>
				</td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" value="${cimsgenericdrugBean.strCurrentDate}"
		name="strCurrentDate" />
	<input type="hidden" value="${cimsgenericdrugBean.strGroupId}"
		name="strGroupId" />
	<input type="hidden" value="${cimsgenericdrugBean.strSubGroupId}"
		name="strSubGroupId" />
	<input type="hidden" value="${cimsgenericdrugBean.strChk}" name="strChk" />

	<input type="hidden" value="${cimsgenericdrugBean.strIsItemCodeRequired}"
		name="strIsItemCodeRequired" />
	<input type="hidden" name="strEffectiveFrom" value="${cimsgenericdrugBean.strEffectiveFrom}">
	<input type="hidden" name="strStockMaintainedCode" value="${cimsgenericdrugBean.strStockMaintainedCode}">

	<cmbPers:cmbPers />


</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>
