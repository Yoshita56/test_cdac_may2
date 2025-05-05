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
<title>Item Parameter Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
	<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
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
        hisValidator.addValidation("strParamType","dontselect=0","Please select Parameter Type ");
        hisValidator.addValidation("strParamLength","req","Parameter Length is a Mandatory Field" );
        hisValidator.addValidation("strParamLength","maxlen=3","Parameter Length should not contain greater than 3 characters" );
        if(document.forms[0].strIsChild.checked == true)
       	{
       	
       	hisValidator.addValidation("strParentParamId","dontselect=0","Please select Parent Parameter Name" );
       	}
        hisValidator.addValidation("strEffectiveFrom","date","Effective Date is a mandatory field");
		//hisValidator.addValidation("strEffectiveFrom", "dtgtet=${itemParameterBean.strCtDate}" , "Effective Date should be Greater than or Equal to Current Date");         
           
  var retVal = hisValidator.validate(); 
      		hisValidator.clearAllValidations();
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

<body onload="document.forms[0].strItemParamName.focus()">
<html:form name="itemParameterBean"
	action="/masters/ItemParameterMstCNT"
	type="mms.masters.controller.fb.ItemParameterMstFB">
	<div class="errMsg"><bean:write name="itemParameterBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="itemParameterBean"
		property="strWarning" /></div>
	<div class="normalMsg"><bean:write name="itemParameterBean"
		property="strMsg" /></div>

	<tag:tab tabLabel="Add Item Parameter"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
               </tag:tab>
	<table class="TABLEWIDTH" border="0" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="HEADER">
			<td colspan="2">Item Parameter Master&gt;&gt;Add</td>
		</tr>
		<tr>
			<td class="LABEL" width="50%">Item Category Name</td>
			<td width="50%" class="CONTROL"><bean:write
				name="itemParameterBean" property="comboValue" /></td>
		</tr>
		<tr>
			<td class="LABEL"><font color="red">*</font> Parameter Name</td>
			<td class="CONTROL"><input type="text" class="txtFldBig"  name="strItemParamName" 
			onkeypress="return validateData(event,18);" maxlength="100"></td>
		</tr>
		<tr>
			<td class="LABEL"><font color="red">*</font>Parameter Type</td>

			<td width="50%" class="CONTROL"><html:select styleClass="comboNormal"
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
				name="strParamLength" class='txtFldBig' maxlength="3"
				onkeypress="return validateData(event,5);"></td>
		</tr>
		<tr>
			<td class="LABEL">Is Child</td>
			<td class="CONTROL"><input name="strIsChild" type="checkbox"
				checked="checked" value="checkbox" onclick="parentDisable(this);"></td>

		</tr>
	</table>
	<div id="parentParamDivId">
	<table class="TABLEWIDTH" border="0" align="center" cellpadding="1px"
		cellspacing="1px">

		<tr>
			<td class="LABEL"><font color="red">*</font>Parent Parameter
			Name</td>
			<td width="50%" class="CONTROL"><html:select
				name="itemParameterBean" property="strParentParamId">
				<bean:write name="itemParameterBean" property="strparentNameCombo"
					filter="false" />
			</html:select></td>
		</tr>

	</table>
	</div>
	<table class="TABLEWIDTH" border="0" align="center" cellpadding="1px"
		cellspacing="1px">

		<tr>
			<td class="LABEL">Remarks</td>
			<td width="50%" class="CONTROL"><textarea name="strRemarks"
				rows="2"></textarea></td>
		</tr>

		<tr>
			<td class="LABEL"><font color="red">*</font> Effective From</td>
			<td class="CONTROL"><date:date name="strEffectiveFrom" value="${itemParameterBean.strCtDate}"></date:date></td>
		</tr>
		<tr class="FOOTER">
			<td colspan="2"><font color="red">* </font> Mandatory Field</td>
		</tr>
	</table>
	<div align="center"><!-- <img style="cursor: pointer; "
		src="../../hisglobal/images/btn-sv.png" title="Save Record"
		onClick=" return validate1();" /> <img
		style="cursor: pointer; "
		src="../../hisglobal/images/btn-clr.png" title="Reset Content"
		onClick="document.forms[0].reset();" /> <img
		style="cursor: pointer; "
		src="../../hisglobal/images/btn-ccl.png" title="Cancel Process" onClick="cancel('LIST');" /> -->
		<br>					 
<a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
	</div>
	<input type="hidden" name="hmode" value="" />
	<input type="hidden" name="strStoreTypeId"
		value="${itemParameterBean.combo[0]}" />
	<input type="hidden" name="strCategroyNo"
		value="${itemParameterBean.strCategroyNo}" />
	<input type="hidden" name="strHospitalCode"
		value="${itemParameterBean.strHospitalCode}" />
	<input type="hidden" name="comboValue"
		value="${itemParameterBean.comboValue}" />
		<input type="hidden" name="strCtDate"
		value="${itemParameterBean.strCtDate}" />
	<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>

