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
<title>Lab Modify Page</title>
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
<script language="Javascript" src="../../mms/js/dwh_labMst.js"></script>


</head>
<body>
<html:form action="/masters/LabMstCNT.cnt"  name="labMstBean" type="mms.masters.controller.fb.LabMstFB" method="post">

    <div class="errMsg" id="errMsg" ><bean:write name="labMstBean" property="strErrMsg"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="labMstBean" property="strWarningMsg"/></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="labMstBean" property="strNormalMsg"/></div>
<tag:tab tabLabel="Lab Master"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">   
	   <tr class="HEADER">
			<td colspan="2">Lab Master&gt;&gt;Modify</td>
			
		</tr>
	</table>
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">  
		<tr>
			<td width="25%" class="LABEL" colspan="1"><font color="red">*</font>Lab Name</td>
			<td width="25%" class="CONTROL" align="left" colspan="1"><input type="text"
				name="strLabName" value="${labMstBean.strLabName}" maxlength="250" 
				onkeypress="return validateData(event,18);">
			</td>
			<td width="25%" class="LABEL" colspan="1"><font color="red">*</font>Lab No</td>
			<td width="25%" class="CONTROL" align="left" colspan="1"><input type="text"
				name="strLabUserNo" value="${labMstBean.strLabUserNo}" maxlength="25"
				onkeypress="return validateData(event,18);">
			</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL" align="left" colspan="1" colspan="1">Address</td>
			<td width="25%" class="CONTROL" colspan="1" colspan="1">
	  		<div align="left">
      				<textarea name="strAddress" rows="2"><bean:write name="labMstBean" property="strAddress"/></textarea>
  	 		</div></td>
  	 		<td width="25%" class="LABEL" align="left" colspan="2"></td>
		</tr>
		
		<tr>
			<td width="25%" class="LABEL" colspan="1">Phone No</td>
			<td width="25%" class="CONTROL" align="left" colspan="1"><input type="text"
				name="strPhoneNo" value="${labMstBean.strPhoneNo}" maxlength="11"
				onkeypress="return validateData(event,2);">
			</td>
			
			<td width="25%" class="LABEL">Fax No</td>
			<td width="25%" class="CONTROL" align="left" ><input type="text"
				name="strFaxNo" value="${labMstBean.strFaxNo}" maxlength="11"
				onkeypress="return validateData(event,2);">
			</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Lab Type</td>
			<td class="CONTROL" colspan="1">
			<div id="LabTypeDivId" align="left"><select class='comboNormal' name="strLabType" >
				<option value="1">Internal</option>
			</select></div>
			</td>
			<td width="25%" class="LABEL" colspan="1"></td>
			<td width="25%" class="CONTROL" colspan="1"></td>
		</tr>
		
		<tr>
			<td width="25%" class="LABEL">Record Status</td>
			<td width="25" class="CONTROL" colspan="1" align="right">
				<html:radio name="labMstBean"
				property="strIsValid" value="1">Active</html:radio>
				<html:radio name="labMstBean"
				property="strIsValid" value="2">In-Active</html:radio>
			</td>
			<td width="25%" class="CONTROL" colspan="2"></td>
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
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-sv.png" onClick=" return validate2();" onkeypress="if(event.keyCode==13) validate2();"/> 
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset();" onkeypress="if(event.keyCode==13) document.forms[0].reset();"/>
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" onClick="cancel('LIST');" onkeypress="if(event.keyCode==13) cancel('LIST');"/>
			
			</td>
		</tr>
	</table>	
	
	<input type="hidden" name="hmode"/>
	<input type="hidden" name="strCtDate" value="${labMstBean.strCtDate}"/>
	<input type="hidden" name="chk" value="${labMstBean.strChk }">
	<input type="hidden" name="strLabNo" value="${labMstBean.strLabNo}"/>
	
    <cmbPers:cmbPers />
</html:form>

<tag:autoIndex></tag:autoIndex>
</body>
</html>