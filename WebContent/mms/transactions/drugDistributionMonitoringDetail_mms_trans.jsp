<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>


<html>
<head>
<meta charset=UTF-8">
<title>Drug Distribution Monitoring Detail</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../mms/js/dateDifference.js"></script>
<script language="Javascript" src="../js/drugDistributionMonitoringDetail_mms_trans.js"></script>

<script type="text/javascript">

</script>
</head>
<body >

<html:form name="drugDistributionMonitoringDetailTransFB" action="/transactions/DrugDistributionMonitoringDetailTransCNT"
	type="mms.transactions.controller.fb.DrugDistributionMonitoringDetailTransFB">

	<div id="errMsg" class="errMsg"><bean:write name="drugDistributionMonitoringDetailTransFB" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="drugDistributionMonitoringDetailTransFB" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="drugDistributionMonitoringDetailTransFB" property="strNormalMsg" /></div>	
	
	
	<tag:tab tabLabel="Drug Distribution Monitoring Detail" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab>
	<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
	<tr class="HEADER"> 
	 <td colspan="4">Drug Distribution Monitoring Detail&gt;&gt;
    </td>
    </tr>
    	
    </table>
	
	
	
	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
	
	<tr> 
    <td width="25%" class="LABEL" colspan="1">CR No.</td>
    <td colspan="1" class="CONTROL">
    	<crNo:crNo value ="${drugDistributionMonitoringDetailTransFB.strCrNo}" js=" onkeypress='return initGoFunc(event);'"></crNo:crNo>
  	</td>   
  	<td width="25%" class="LABEL" colspan="1">Patient Name </td>
    <td colspan="1" class="CONTROL">
    	<input type="text" name="strPatientName" onkeypress="return validateData(event,9);" maxlength="100">
  	</td>
  </tr>
	
		<tr>
			<td width="25%" colspan="1" class="LABEL">Department Name</td>
			<td width="25%" colspan="1" class="CONTROL">
				<select name="strDeptId" class="comboNormal" onchange="getUnitValues();">
					<bean:write name="drugDistributionMonitoringDetailTransFB" property="strDeptValues" filter="false" />
				</select>
			</td>

			<td width="25%" colspan="1" class="LABEL">Unit Name</td>
			<td width="25%" colspan="1" class="CONTROL">
				<div id="unitDivId">
					<select	name="strUnitId" class="comboNormal" >
					<bean:write name="drugDistributionMonitoringDetailTransFB" property="strUnitValues"
						filter="false" />
				</select>
				</div>
			</td>			
		</tr>
		 
		 
		 <tr>
			<td colspan="1" class="LABEL">
			<font color="red">*</font>From Date
			</td>
			<td colspan="1" class="CONTROL">
				<dateTag:date name="strFromDate"
				 value="${drugDistributionMonitoringDetailTransFB.strCurrentDate}"/>
			</td>
			
		
			<td colspan="1" class="LABEL">
			<font color="red">*</font>To Date
			</td>
			<td colspan="1" class="CONTROL">
				<dateTag:date name="strToDate"
				 value="${drugDistributionMonitoringDetailTransFB.strCurrentDate}"/>
			</td>
			
		</tr> 
		 
	</table>

<div id="patientDetailsDivId"></div>	
			

		<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
	
		<tr id=issuedAndPrescribedDetailsLabelDivId style="display: none;" >
			<td  class="LABEL"><div align="center">	Issue Date</div></td>
		 	
		 	<!--<td colspan="1" class="LABEL">	Prescription Detail</td>  -->
		 	
		 </tr>
	
		<tr>
		 
		 	 <td  class="CONTROL">
		 		<div id=issuedDetailsDivId align="center">
		 			
		 		</div>
		 		
		 	</td>
		 
		<!--<td  colspan="2" class="CONTROL">
		 		<div id=prescribedDetailsDivId style="display:none;" align="right">
		 			
		 		</div>
		 		
		 	</td>
		 	  --> 
			
		</tr>	
		</table>
		
		
		<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		
		<tr>
			<td  colspan="4" class="LABEL">
		 		<div id=issuedDrugDtlsDivId ></div>
			</td>	
		</tr>
		</table>



	
	
<table  class="TABLEWIDTH" align="center" cellspacing="0px" cellpadding="0px"> 
	 <tr class="FOOTER">
	    <td colspan="1" width='3%' align='center'>
	          <div id="pluslegendDivId" align="center" style="display:block;">
					<img src="../../hisglobal/images/plus.gif" 
						 onClick="view1('pluslegendDivId','minuslegendDivId','legendDivId');" 
						 style="cursor: pointer; "/>
				</div>
				<div id="minuslegendDivId" style="display:none;" align="center">
					<img src="../../hisglobal/images/minus.gif" 
						 onClick="view2('pluslegendDivId','minuslegendDivId','legendDivId');" 
						 style="cursor: pointer; "/>
				</div>
		 </td>
		 <td colspan="1" width='5%' align='left'>Legend</td>			 
		 <td colspan="1" width='92%'><font size="2" color="red">*</font>Mandatory Fields</td>
	  </tr>
  </table>	
  <div id="legendDivId" style="display:none">
  <table  class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" bgcolor='black'> 
	 <tr>
		<td align="center" style='background-color:lightpink;'>
	        
		</td>
		<td align="left" style='background-color:lightpink;color: black'>
	       <b>Special Drug (s)</b>
		</td>		
	 </tr>
  </table> 
  </div>	
	
	
	
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
		<td align="center">
			<img style=" cursor: pointer" src="../../hisglobal/images/btn-search.png" onclick="searchPatientDtls();" title="Click to search patient details">	
			<img style=" cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="clearIssue();" title="Click to Clear Page">
			<img style=" cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" title="Click to cancel process">	</td>

		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="crNo" value="${drugDistributionMonitoringDetailTransFB.crNo}" />
	
	<input type="hidden" name="strConfCatCode" value="${drugDistributionMonitoringDetailTransFB.strConfCatCode}" />

	
	    <input type="hidden" name="strMode"   value="${drugDistributionMonitoringDetailTransFB.strMode}">
		
		
		<input type="hidden" name="strScanFlg" value="${drugDistributionMonitoringDetailTransFB.strScanFlg}" />
		
		<input type="hidden" name="strCrChkFlg" value="${drugDistributionMonitoringDetailTransFB.strCrChkFlg}" />
		<input type="hidden" name="strCurrentDate" value="${drugDistributionMonitoringDetailTransFB.strCurrentDate}" />
		<input type="hidden" name="strScanDocFlg" value="" />
		
		<input type="hidden" name="strSDFFlgColor"     value="${drugDistributionMonitoringDetailTransFB.strSDFFlgColor}">
		
<cmbPers:cmbPers/>	

</html:form>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>
