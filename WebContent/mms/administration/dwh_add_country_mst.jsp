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
<title>Country Add Page</title>
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
<script language="Javascript" src="../../mms/js/dwh_countryMst.js"></script>


</head>
<body>
<html:form action="/masters/CountryMstCNT.cnt"  name="countryBean" type="mms.masters.controller.fb.CountryMstFB" method="post">

    <div class="errMsg" id="errMsg" ><bean:write name="countryBean" property="strErrMsg"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="countryBean" property="strWarningMsg"/></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="countryBean" property="strNormalMsg"/></div>
<tag:tab tabLabel="Country Master"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">   
	   <tr class="HEADER">
			<td colspan="2">Country Master&gt;&gt;Add</td>
		</tr>
		
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Country Name</td>
			<td width="25%" class="CONTROL" align="left" ><input type="text"
				name="strCountryName" value="" maxlength="30"
				onkeypress="return validateData(event,11);">
			</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Country Short Name</td>
			<td width="25%" class="CONTROL" align="left" ><input type="text"
				name="strCountryShortName" value="" maxlength="3"
				onkeypress="return validateData(event,12);">
			</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Nationality</td>
			<td width="25%" class="CONTROL" align="left" ><input type="text"
				name="strNationality" value="" maxlength="30"
				onkeypress="return validateData(event,11);">
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
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" onClick=" return validate1();"/> 
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset(),clearMsg('ADD');"/>
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" onClick="cancel('LIST');"/>
			
			</td>
		</tr>
	</table>	
	
	<input type="hidden" name="hmode"/>
	
    <cmbPers:cmbPers />
</html:form>

<tag:autoIndex></tag:autoIndex>
</body>
</html>