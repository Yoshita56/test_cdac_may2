<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset="utf-8">
<title>Component Master Add Page</title>
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
<script language="javaScript">
function validate1(){   
     
      var hisValidator = new HISValidator("componentBean");
 
            hisValidator.addValidation("strComponentName", "req", "Component Name is a Mandatory Field", "maxlen=100", "Store Type Name should have less than or equal to 100 Characters");
          //   hisValidator.addValidation("strEffectiveFrom", "date","Effective From is a mandatory field");
          //   hisValidator.addValidation("strEffectiveFrom", "dtgtet=${componentBean.strCtDate}" , "Effective Date should be Greater than or Equal to Current Date");         
            hisValidator.addValidation("strEffectiveFrom", "date","Effective From is a mandatory field");
       		hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks should have less than or equal to 100 Characters");
			
			       
            var retVal = hisValidator.validate(); 

          if(retVal)
          {
                 	   document.forms[0].hmode.value = "UPDATE";
                       document.forms[0].submit();
           }
           else
           {
             return false;
           }
    }

</script>


</head>

<body>
<html:form name="componentBean" action="/masters/ComponentMstCNT"
	type="mms.masters.controller.fb.ComponentMstFB">

	<div class="errMsg"><bean:write name="componentBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="componentBean"
		property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="componentBean" property="strMsg" /></div>
	<tag:tab tabLabel="Component Master"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="2">Component Master&gt;&gt;Modify</td>
		</tr>

		<tr>
			<td class="LABEL"><font color="red">*</font>Component Name</td>
			<td width="50%" class="CONTROL"><input type="text"
				name="strComponentName"  maxlength="100"
				value="${componentBean.strComponentName}"
				onkeypress="return validateData(event,18);"></td>
		</tr>

		<tr>
			<td class="LABEL" width="50%"><font color="red">*</font>Effective
			From</td>
			<td class="CONTROL"><bean:write name="componentBean" property="strEffectiveFrom"></bean:write></td>
		</tr>

		<tr>
			<td class="LABEL">
			<div align="right">Remarks</div>
			</td>
			<td class="CONTROL">
			<div align="left"><textarea name="strRemarks" rows="2"><bean:write
				name="componentBean" property="strRemarks" /></textarea></div>
			</td>
		</tr>

		<tr>
			<td width="45%" class="LABEL">Record Status</td>
			<td width="45%" class="CONTROL"><html:radio name="componentBean"
				property="strIsValid" value="1">Active</html:radio> <html:radio
				name="componentBean" property="strIsValid" value="2">Inactive</html:radio>

			</td>
		</tr>



		<tr class="FOOTER">
			<td colspan="2"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>

	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>

			<td align="right"><!-- <img src="../../hisglobal/images/btn-sv.png"
			style="cursor: pointer; "
				title="Save Record" onClick="return validate1();" /> -->
				<a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
				</td>
			<td align="left"><!-- <img
				src="../../hisglobal/images/btn-ccl.png"
				style="cursor: pointer; "
				title="Cancel Process" onClick="cancel('LIST');"> -->
				<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
				</td>
				
		</tr>
	</table>

	<input type="hidden" name="chk" value="${componentBean.chk[0] }">
	<input type="hidden" name="comboValue"
		value="${componentBean.strComponentName}">
	<input type="hidden" name="hmode">
	<input type="hidden" name="strEffectiveFrom"
				value="${componentBean.strEffectiveFrom}">


	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>

