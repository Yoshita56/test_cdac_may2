<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<meta charset=UTF-8">
<title>Gate Pass Details</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../mms/js/gatepassdetails.js"></script>
</head>
<body >
<html:form name="gatePassDetailsBean" action="/transactions/GatePassDetailsTransCNT" type="mms.transactions.controller.fb.GatePassDetailsTransFB">
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="gatePassDetailsBean" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="gatePassDetailsBean" property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="gatePassDetailsBean" property="strMsg" /></div>
	
</center>
<tag:tab tabLabel="Gate Pass Details"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="2">Gate Pass Details&gt;&gt;</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Store Name
			</td>
			<td width="50%" class="CONTROL">
			<html:select name="gatePassDetailsBean" property="strStoreId" >
       		<bean:write name="gatePassDetailsBean" property="strStoreNameCombo" filter="false"/>
       		</html:select>
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			Gate Pass Date
			</td>
			<td width="50%" class="CONTROL">
			
       		<bean:write name="gatePassDetailsBean" property="strCtDate" filter="false"/>
       		
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Gate Pass Type
			</td>
			<td width="50%" class="CONTROL">
			<html:select name="gatePassDetailsBean" property="strGatepassTypeCode" >
       		<bean:write name="gatePassDetailsBean" property="strGatePassTypeCombo" filter="false"/>
       		</html:select>
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Validity
			</td>
			<td width="50%" class="CONTROL">
			<html:text name="gatePassDetailsBean" property="strValidity" size="4" maxlength="2" onkeypress="return validateData(event,5);" >
       		
       		</html:text>
			
			<html:select name="gatePassDetailsBean" property="strValidityUnit" >
       		<option value="1">hours</option>
       		<option value="2">minutes</option>
       		</html:select>
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Issue By
			</td>
			<td width="50%" class="CONTROL">
			<html:select name="gatePassDetailsBean" property="strIssueBy" >
       		<bean:write name="gatePassDetailsBean" property="strIssueByCombo" filter="false"/>
       		</html:select>
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">
			<font color="red">*</font>Issue To
			</td>
			<td width="50%" class="CONTROL">
			<html:text name="gatePassDetailsBean" property="strIssuedTo" maxlength="50" onkeypress="return validateData(event,9);" >       		
       		</html:text>
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL" >
			Remarks
			</td>
			<td width="50%" class="CONTROL">
			<html:textarea name="gatePassDetailsBean" property="strRemarks" cols="25" rows="2">
       		
       	  </html:textarea>
			</td>
		</tr>
		
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img 
				src="../../hisglobal/images/btn-sv.png"  style="cursor:pointer;cursor:pointer;" title="Save Record" onClick="return validate1();" />
				<img src="../../hisglobal/images/btn-clr.png"  style="cursor:pointer;cursor:pointer;" title="Reset Content" onClick="document.forms[0].reset();" >
			<img src="../../hisglobal/images/btn-ccl.png" style="cursor:pointer;cursor:pointer;" title="Cancel Process" onClick="return cancelProcess()" >
			</td>
		</tr>
	</table>
<input type="hidden" name="hmode"/>
</html:form>
<tag:autoIndex></tag:autoIndex> 
</body>
</html>