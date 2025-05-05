<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<html>
<head>
<meta charset="utf-8">
<title>Item Parameter Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
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
     
      var hisValidator = new HISValidator("itemParameterBean");
           
        hisValidator.addValidation("strItemParamName","req","Parameter Name a Mandatory Field" );
        hisValidator.addValidation("strItemParamName","maxlen=50","Parameter Name should not contain greater than 100 characters" );
        hisValidator.addValidation("strParamType","req","Parameter Type is a Mandatory Field ");
       
                  
            hisValidator.addValidation("strParamLength","req","Parameter Length is a Mandatory Field" );
       
          hisValidator.addValidation("strParamLength","maxlen=3","Parameter Length should not contain greater than 3 characters" );
       	
	 hisValidator.addValidation("strEffectiveFrom","req","Effective Date is a mandatory field");
			//hisValidator.addValidation("strEffectiveFrom", "dtgtet=${itemParameterBean.strCtDate}" , "Effective Date should be Greater than or Equal to Current Date");         
           
  var retVal = hisValidator.validate(); 
      
          if(retVal){
                       document.forms[0].hmode.value = "UPDATE";
                       document.forms[0].submit();
            }else{

           return false;
}	
}


	
	
</script>
</head>

<body>
<html:form name="itemParameterBean"
	action="/masters/ItemParameterMstCNT"
	type="mms.masters.controller.fb.ItemParameterMstFB">
	<div class="errMsg"><bean:write name="itemParameterBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="itemParameterBean"
		property="strWarning" /></div>
	<div class="normalMsg"><bean:write name="itemParameterBean"
		property="strMsg" /></div>

	<tag:tab tabLabel="Item Parameter Master" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab>

	<table class="TABLEWIDTH" border="0" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="2">Item Parameter Master&gt;&gt;Modify</td>
		</tr>


		<tr>
			<td class="LABEL" width="50%">Item Category Name</td>
			<td width="50%" class="CONTROL"><bean:write
				name="itemParameterBean" property="comboValue" /></td>
		</tr>

		<tr>
			<td class="LABEL"><font color="red">*</font> Parameter Name</td>
			<td width="50%" class="CONTROL"><input type="text"
				class="txtFldBig" name="strItemParamName"
				value="${itemParameterBean.strItemParamName}"
				onkeypress="return validateData(event,18);"></td>
		</tr>
		<tr>
			<td class="LABEL"><font color="red">*</font>Parameter Type</td>

			<td width="50%" class="CONTROL"><html:select
				name="itemParameterBean" property="strParamType">
				<html:option value="0">Select Value</html:option>
				<html:option value="1">Numeric Only </html:option>
				<html:option value="2">Character Only</html:option>
				<html:option value="3">Alpha Numeric Only</html:option>

			</html:select></td>

		</tr>
		<tr>
			<td class="LABEL"><font color="red">*</font>Parameter Length</td>
			<td width="50%" class="CONTROL"><input type="text"
				class="txtFldBig" name="strParamLength"
				value="${itemParameterBean.strParamLength}"
				onkeypress="return validateData(event,5);"></td>
		</tr>

		<tr>
			<td class="LABEL">Remarks</td>
			<td width="50%" class="CONTROL"><textarea name="strRemarks"
				rows="1"><bean:write name="itemParameterBean"
				property="strRemarks" /></textarea></td>
		</tr>

		<tr>

			<td class="LABEL">Effective From</td>
			<td class="CONTROL"><bean:write name="itemParameterBean" property="strEffectiveFrom" /></td>
		</tr>
		<tr>
			<td class="LABEL">Record Status</td>
			<td class="CONTROL"><html:radio name="itemParameterBean"
				property="strIsValid" value="1" />Active <html:radio
				name="itemParameterBean" property="strIsValid" value="2" />Inactive
			</td>
		</tr>



		<tr class="FOOTER">
			<td colspan="2"><font color="red">* </font> Mandatory Field</td>
		</tr>
	</table>
	<div align="center"><!-- <img style="cursor: pointer;"
		src="../../hisglobal/images/btn-sv.png" title="Save Record"
		onClick=" return validate1();" /> <img style="cursor: pointer;"
		src="../../hisglobal/images/btn-ccl.png" title="Cancel Process"
		onClick="cancel('LIST');" /> -->
		<br>
		<a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
		<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
		
		</div>
	<input type="hidden" name="hmode" value="" />
	<input type="hidden" name="strCtDate"
		value="${itemParameterBean.strCtDate}" />
	<input type="hidden" name="chk" value="${itemParameterBean.chk[0]}">
	<input type="hidden" name="comboValue"
		value="${itemParameterBean.comboValue}" />
	<input type="hidden" name="strStoreTypeId"
		value="${itemParameterBean.combo[0]}" />
	<input type="hidden" name="strCategroyNo"
		value="${itemParameterBean.strCategroyNo}" />
	<input type="hidden" name="strEffectiveFrom"
		value="${itemParameterBean.strEffectiveFrom}" />
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>

