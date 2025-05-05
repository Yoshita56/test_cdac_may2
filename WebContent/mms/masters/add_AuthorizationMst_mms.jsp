<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<html>
<head>
<meta charset=utf-8>
<title>Authorization Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<style type="text/css">
@import url(../../hisglobal/css/calendar-tas.css);
</style>

<script type="text/javascript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript">

function validate1(){   
     
      var hisValidator = new HISValidator("authorizationBean");
           
        hisValidator.addValidation("strUserId","dontselect=0","Please select User Name" );
        //hisValidator.addValidation("strUserNameCombo","dontselect=0","Please select User Name Combo" );
        hisValidator.addValidation("strAuthorizationTypeId","dontselect=0","Please select Authorization Type" );
        hisValidator.addValidation("strAuthorizationLevel","dontselect=0","Please select Authorization Level");
        hisValidator.addValidation("strCostForm","req","Cost From is a Mandatory Field");
        hisValidator.addValidation("strCost","numgt=document.forms[0].strCostForm.value","Cost To should be greater than Cost From");
        hisValidator.addValidation("strEffectiveFrom","date","Effective Date is a mandatory field");
	    //hisValidator.addValidation("strEffectiveFrom", "dtgtet=${authorizationBean.strCtDate}" , "Effective Date should be Greater than or Equal to Current Date");         
           
  var retVal = hisValidator.validate(); 
      
          if(retVal){
                       document.forms[0].hmode.value = "SAVE";
                       document.forms[0].submit();
            }else{

           return false;
}	
}

function parentDisable(chkObj){
	
	if(chkObj.checked == true){
		document.getElementById("parentParamDivId").style.display = "block";
	}else{
		document.getElementById("parentParamDivId").style.display = "none";
	}
}


	
	
</script>
</head>

<body onLoad="document.forms[0].strUserNameCombo.focus()">
<html:form name="authorizationBean"
	action="/masters/AuthorizationMstCNT"
	type="mms.masters.controller.fb.AuthorizationMstFB">
	<div class="errMsg"><bean:write name="authorizationBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="authorizationBean"
		property="strWarning" /></div>
	<div class="normalMsg"><bean:write name="authorizationBean"
		property="strMsg" /></div>

	<tag:tab tabLabel="Add Authorization" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab>

	<table class="TABLEWIDTH" border="0" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="2">Authorization Master&gt;&gt;Add</td>
		</tr>
		<tr>
			<td class="LABEL">Store Name</td>
			<td width="50%" class="CONTROL"><bean:write
				name="authorizationBean" property="strStoreTypeCombo" filter="false" />
			</td>
		</tr>
		<tr>
			<td class="LABEL"><font color="red">*</font>User Name</td>
			<td width="50%" class="CONTROL"><html:select
				styleClass="comboNormal" name="authorizationBean"
				property="strUserId">
				<bean:write name="authorizationBean" property="strUserNameCombo"
					filter="false" />
				<html:option value="0">Select Value</html:option>
			</html:select></td>
		</tr>
		<tr>
			<td class="LABEL"><font color="red">*</font>Authorization Type</td>

			<td width="50%" class="CONTROL"><html:select
				styleClass="comboNormal" name="authorizationBean"
				property="strAuthorizationTypeId">
				<html:option value="0">Select Value</html:option>
				<html:option value="10">Indent Verification</html:option>
				<html:option value="11">Issue Verification </html:option>
				<html:option value="12">Return Verification</html:option>
				<html:option value="13">Return Approval</html:option>
				<html:option value="14">Local Purchase</html:option>
				<html:option value="15">Invoice Verification</html:option>

			</html:select></td>

		</tr>

		<tr>
			<td class="LABEL"><font color="red">*</font>Authorization Level</td>

			<td width="50%" class="CONTROL"><html:select
				styleClass="comboNormal" name="authorizationBean"
				property="strAuthorizationLevel">
				<html:option value="0">Select Value</html:option>
				<html:option value="1">1</html:option>
				<html:option value="2">2</html:option>
				<html:option value="3">3</html:option>
				<html:option value="4">4</html:option>
				<html:option value="5">5</html:option>
				<html:option value="6">6</html:option>
				<html:option value="7">7</html:option>
				<html:option value="8">8</html:option>
				<html:option value="9">9</html:option>


			</html:select></td>

		</tr>

		<tr>
			<td class="LABEL"><font color="red">*</font>Cost Form</td>
			<td class="CONTROL"><input type="text" name="strCostForm"
				class="txtFldBig" maxlength="14"
				onkeypress="return validateData(event,7);"></td>
		</tr>


		<tr>
			<td class="LABEL">Cost To</td>
			<td class="CONTROL"><input type="text" name="strCost"
				class="txtFldBig" maxlength="14"
				onkeypress="return validateData(event,7);"></td>
		</tr>

		<tr>
			<td class="LABEL"><font color="red">*</font> Effective From</td>
			<td class="CONTROL"><date:date name="strEffectiveFrom"
				value="${authorizationBean.strCtDate}"></date:date></td>
		</tr>
		<tr class="FOOTER">
			<td colspan="2"><font color="red">* </font> Mandatory Field</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center"><img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" title="Save Record"
				onClick=" return validate1();" /> <img
				style="cursor: pointer; " title="Clear Content"
				src="../../hisglobal/images/btn-clr.png"
				onClick="document.forms[0].reset();" /> <img
				style="cursor: pointer; " title="Cancel Process"
				src="../../hisglobal/images/btn-ccl.png"
				onClick="cancel('LIST');" /></td>
		</tr>
	</table>

	<input type="hidden" name="strStoreTypeId"
		value="${authorizationBean.combo[0]}" />
	<input type="hidden" name="comboValue"
		value="${authorizationBean.strStoreTypeCombo}" />
	<input type="hidden" name="strCtDate"
		value="${authorizationBean.strCtDate}" />
	<input type="hidden" name="hmode" value="" />

	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>

