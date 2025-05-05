<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<title>SMS (Mobile) Setup</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../mms/js/main_SmsMobileSetupMst_mms.js"></script>


</head>
<body>
<html:form action="/masters/SmsMobileSetupMstCNT.cnt"  name="smsMobileSetupMstFB" type="mms.masters.controller.fb.LabMstFB" method="post">

    <div class="errMsg" id="errMsg" ><bean:write name="smsMobileSetupMstFB" property="strErrMsg"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="smsMobileSetupMstFB" property="strWarningMsg"/></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="smsMobileSetupMstFB" property="strNormalMsg"/></div>
<tag:tab tabLabel="SMS (Mobile) Setup"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">   
	   <tr class="HEADER" >
			<td colspan="4">SMS (Mobile) Setup&gt;&gt;</td>
			
		</tr>
	</table>
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
			<td width="25%" class="LABEL" colspan="1"><font color="red">*</font>Process Name</td>
			<td width="75%" class="CONTROL" align="left" colspan="3">
			<html:select name="smsMobileSetupMstFB" property="strReqTypeId" onchange="getMobileNos();"  >
			   <bean:write name="smsMobileSetupMstFB" property="strProcessName" filter="false" />
			 </html:select>  
			</td>
			
		
		
		<tr>
			<td width="25%" class="LABEL" colspan="1">Mobile No</td>
			<td width="75%" class="CONTROL" align="left" colspan="3" >
			<div id="strPhoneNoDivId">
				<textarea name="strPhoneNo" rows="4" cols="50" onkeypress="return validateDataWithSpecialChars(event,5,',');">
				
					<bean:write name="smsMobileSetupMstFB" property="strPhoneNo" filter="false" />
				</textarea>
			</div>					
			</td>
			

		</tr>
		
		</table>
		
	    <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	        <tr class="FOOTER">
				 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
			</tr>
		</table>
	
	<div id="id1"></div>
	
	<table  class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	 <tr>

			<td align="center">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" onClick=" return validate1();" onkeypress="if(event.keyCode==13) validate1();"/> 
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset();" onkeypress="if(event.keyCode==13) document.forms[0].reset();"/>
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" onClick="cancel('LIST');" onkeypress="if(event.keyCode==13) cancel('LIST');"/>
			
			</td>
		</tr>
	</table>	
	
	<input type="hidden" name="hmode"/>
	
    <cmbPers:cmbPers />
</html:form>

<tag:autoIndex></tag:autoIndex>
</body>
</html>