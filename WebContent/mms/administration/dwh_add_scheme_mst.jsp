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
<title>Scheme Add Page</title>
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
<script language="Javascript" src="../../mms/js/dwh_schemeMst.js"></script>


</head>
<body>
<html:form action="/masters/SchemeMstCNT.cnt"  name="schemeBean" type="mms.masters.controller.fb.SchemeMstFB" method="post">

    <div class="errMsg" id="errMsg" ><bean:write name="schemeBean" property="strErrMsg"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="schemeBean" property="strWarningMsg"/></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="schemeBean" property="strNormalMsg"/></div>
<tag:tab tabLabel="Scheme Master"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">   
	   <tr class="HEADER">
			<td colspan="2">Scheme Master&gt;&gt;Add</td>
		</tr>
		
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Scheme Name</td>
			<td width="25%" class="CONTROL" align="left" ><input type="text"
				name="strSchemeName" value="" maxlength="100"
				onkeypress="return validateData(event,18);">
			</td></tr><tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Effective From</td>
				<td width="25%" class ="CONTROL"><date:date name="strEffectiveFrom" value="${schemeBean.strCtDate}"></date:date>
			</td>
		</tr>
		
		<tr>
			<td width="50%" class="LABEL" align="left">Remarks(If Any)</td>
			<td width="50%" class="CONTROL">
	  		<div align="left">
      				<textarea name="strRemarks" rows="2" maxlenght="100"></textarea>
  	 		</div></td>
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
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset();"/>
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" onClick="cancel('LIST');"/>
			
			</td>
		</tr>
	</table>	
	
	<input type="hidden" name="hmode"/>
	<input type="hidden" name="strCtDate" value="${schemeBean.strCtDate}"/>
	
    <cmbPers:cmbPers />
</html:form>

<tag:autoIndex></tag:autoIndex>
</body>
</html>