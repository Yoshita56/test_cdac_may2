<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=utf-8>
<title>Circular Master</title>
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
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="javaScript">

function validate1(){   
     
            var hisValidator = new HISValidator("circularTypeBean");
            //hisValidator.addValidation("strInvoiceTypeName", "req", "Invoice Type Name is a Mandatory Field" );
            //hisValidator.addValidation("strInvoiceTypeName", "maxlen=50", "Invoice Type Name should have less than or equal to 50 Characters" );
            //hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
		alert(document.forms[0].strCircularFileUploadx.value);
            var retVal = hisValidator.validate(); 

          if(true){
              alert('1');
                 	   document.forms[0].hmode.value = "SAVE";
                       document.forms[0].submit();
          }else{
             return false;
          }
}


</script>
</head>
<body onLoad="document.forms[0].strInvoiceTypeName.focus();">
<html:form name="circularTypeBean" action="/masters/CircularMstCNT"
	type="mms.masters.controller.fb.CircularMstFB" enctype="multipart/form-data">
<center>
	<div class="errMsg"><bean:write name="circularTypeBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="circularTypeBean"
		property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="circularTypeBean" property="strMsg" /></div>


	<tag:tab tabLabel="Circular Master"
		selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"	cellspacing="1px">
		<tr class="HEADER">
			<td colspan="2">Circular Master&gt;&gt; Add</td>
		</tr>

		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Circular Name</td>
			<td width="50%" class="CONTROL"><input type="text"
				class="txtFldMax" name="strCircularName" value="" maxlength="50">
			</td>
		</tr>
		
		<tr>
			<td width="50%" class="LABEL"><font color="red">*</font>Subject</td>
			<td width="50%" class="CONTROL"><input type="text"
				class="txtFldMax" name="strCircularSubject" value="" maxlength="50">
			</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">Link</td>
			<td width="50%" class="CONTROL"><input type="text" value="https//:"
				class="txtFldMax" name="strCircularLink" value="" maxlength="50">
			</td>
		</tr>
			
		<tr>
			<td class="LABEL" width="50%"><font color="red">*</font>Date</td>
			<td class="CONTROL"><dateTag:date name="strCircularDate"
				value="${circularTypeBean.strCtDate}"></dateTag:date></td>
		</tr>
		
		<tr>
			<td class="LABEL" width="50%"><font color="red">*</font>File Upload</td>
			<td class="CONTROL">
			
			<html:file property="strCircularFileUploadx"></html:file>
			</td>
		</tr>
		
		
		<tr class="FOOTER">
			<td colspan="2"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>

			<td align="center"><!-- <img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" onClick="validate1();" />
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-clr.png"
				onClick="document.forms[0].reset();" /> <img
				style="cursor: pointer; "
				src="../../hisglobal/images/btn-ccl.png"
				onClick="cancel('LIST');" /> -->
				
				<br>					 
<a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
				</td>
		</tr>
	</table>
	<input type="hidden" name="strCtDate"
		value="${circularTypeBean.strCtDate}"> 
	<input type="hidden" name="hmode" />


	<cmbPers:cmbPers />

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>