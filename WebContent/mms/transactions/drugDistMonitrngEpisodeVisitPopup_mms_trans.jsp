<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset=UTF-8">
<title>Drug Distribution Monitoring Detail</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/drugDistributionMonitoringDetail_mms_trans.js"></script>

<script type="text/javascript">
   function cancelPopup(index) 
   {
	   window.opener.document.getElementsByName("strEpisodeCode")[index].value=document.forms[0].strVisitNo.value.split("^")[2];
	   getScanDocPopup(document.forms[0].strVisitNo.value.split("^")[2]);
	   window.close();
   }
   function defaultVisit()
   {
   		var index=document.forms[0].index.value;
   		window.opener.document.getElementsByName("strEpisodeCode")[index].value=document.forms[0].strVisitNo.value.split("^")[2];
   }
</script>
</head>
<body onload="defaultVisit();">

<html:form name="drugDistributionMonitoringDetailTransFB" action="/transactions/DrugDistributionMonitoringDetailTransCNT"
	type="mms.transactions.controller.fb.DrugDistributionMonitoringDetailTransFB">

	<div id="errMsg" class="errMsg"><bean:write name="drugDistributionMonitoringDetailTransFB" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="drugDistributionMonitoringDetailTransFB" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="drugDistributionMonitoringDetailTransFB" property="strNormalMsg" /></div>	
	
	
	<tag:tab tabLabel="Drug Distribution Monitoring Detail" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab>
	<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
	<tr class="HEADER"> 
	 <td colspan="4">Patient Visit&gt;&gt;
    </td>
    </tr>
    	
    </table>
	
	
	
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr>
			<td width="25%" colspan="2" class="LABEL"><font size="2" color="red">*</font>Visit No</td>
			<td width="25%" colspan="2" class="CONTROL">
				<select name="strVisitNo" class="comboNormal">
					<bean:write name="drugDistributionMonitoringDetailTransFB" property="strVisitValues" filter="false" />
				</select>
			</td>
		</tr>
	</table>

	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="FOOTER">
			<td colspan="4" ><font size="2" color="red">*</font>Mandatory Fields</td>
		</tr>
		<tr>
			<td align="center" colspan="4">
				<bean:define name="drugDistributionMonitoringDetailTransFB" property="index" id="indexId" ></bean:define>
				<img style=" cursor: pointer" src="../../hisglobal/images/btn-ok.png" onClick="cancelPopup('<%=indexId %>');" title="Click to finalize your Visit">	
			</td>
		</tr>
	</table>
	<!--<input type="hidden" name="hmode" />-->
	<html:hidden name="drugDistributionMonitoringDetailTransFB" property="index"/>
	<html:hidden name="drugDistributionMonitoringDetailTransFB" property="strScanDocFlg"/>
	<html:hidden name="drugDistributionMonitoringDetailTransFB" property="strCrNo"/>
	
<cmbPers:cmbPers/>	

</html:form>
	
</body>
</html>
