<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<html>
<head>
<meta charset=utf-8>
<title>Unit Master Add Page</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>

<script type="text/javascript">

	function myFunc(){
		var mode = "BASEUNITVAL";
		var url = "CNTUnitMst.cnt?hmode="+mode+"&modName="+document.forms[0].strModuleVal.value;
		ajaxFunction(url,"1");
	}


	function getAjaxResponse(res,mode){
	
		var objEle = document.getElementById("baseUnitId");
		objEle.innerHTML = "<select name='strBaseUnit' id='baseUnit'>"+res+"</select>";
	}

	function setDefault(){
	document.forms[0].strModuleVal.selectedIndex = 0;
	} 

	function unitDisable(){
	
	isDecimalShow();
	
	if(document.forms[0].strIsBaseUnit.checked){
	
		document.forms[0].strIsBaseUnit.value="1";
		document.forms[0].strBaseUnit.selectedIndex = 0;
		document.forms[0].strBaseUnit.disabled = true;
	
	}else{
		document.forms[0].strIsBaseUnit.value="0";
		document.forms[0].strBaseUnit.disabled = false;
	}
}

	function validate1(){	
						
		var hisValidator = new HISValidator("unitBean");	
		
	// 	hisValidator.addValidation("strModuleVal", "dontselect=0","Please select a value from Module Name Combo");
		hisValidator.addValidation("strUnitName", "req", "Unit Name is a Mandatory Field" );
		hisValidator.addValidation("strUnitName", "maxlen=25", "Remarks should have less than or equal to 25 Characters" );
			
			if(document.forms[0].strIsBaseUnit.checked == false){
				hisValidator.addValidation("strBaseUnit", "dontselect=0","Please select a value from Base Unit Combo");
			}
		
		hisValidator.addValidation("strEffectiveDate", "req","Effective From is a Mandatory Field");
		hisValidator.addValidation("strEffectiveDate", "dtgtet=${unitBean.strCtDate}" , "Effective From Date should be Greater than or Equal to Current Date");
		
			if(document.unitBean.strRemarks.value != ""){
				hisValidator.addValidation("strRemarks", "maxlen=50", "Remarks should have less than or equal to 50 Characters" );
			}
	
		var retVal = hisValidator.validate(); 
		hisValidator.clearAllValidations();
	
		if(retVal){
				document.forms[0].hmode.value = "INSERT";
				document.forms[0].submit();
		}else{
		
		return false;
		}
	}
	
	

		
function isDecimalShow()
{
// alert("isDecimalShow"); 
if(document.forms[0].strIsBaseUnit.checked == true ) 
{
	document.getElementById("isDecimalId").style.display="block";
}
else{
	document.getElementById("isDecimalId").style.display="none";
}

}

</script>

</head>
<body onLoad="document.forms[0].strUnitName.focus(),setDefault();">

<html:form action="/masters/CNTUnitMst.cnt"
	type="mms.masters.vo.VOUnitMst" name="unitBean">

	<div class="errMsg"><bean:write name="unitBean" property="strErr"/></div>
	<div class="warningMsg"><bean:write name="unitBean" property="strWarning"/></div>
	<div class="normalMsg" id='normalMsg'><bean:write name="unitBean" property="strMsg"/></div>
	
	<tag:tab tabLabel="Add Unit" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab>

	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr class="HEADER"> 
			<td colspan="2">Unit Master&gt;&gt; Add</td>
		</tr>
		<tr>
			<td width="50%" class="LABEL">Module Name</td>
			<td width="50%" class ="CONTROL">
    		<bean:write name="unitBean" property="strModuleName" filter="false"/>
             </td>
			
		</tr>
		<tr>
			<td class="LABEL"><font color="red">*</font>Unit Name</td>
			<td class="CONTROL"><input name="strUnitName" type="text"  onkeypress="return validateData(event,17);"
				id="unitName" maxlength="25"></td>
		</tr>
		<tr>
			<td class="LABEL">Whether Base Unit</td>
			<td class="CONTROL"><input name="strIsBaseUnit" type="checkbox"
				id="isBaseUnit" value="0" onclick="unitDisable()"></td>
		</tr>
		</table>
		<div id="isDecimalId" style="display: none">
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="LABEL" width="50%">Whether Unit Value could be in Decimal</td>
			<td class="CONTROL" width="50%"><input name="strIsDecimal" type="checkbox"
				id="IsDecimal" value="1" ></td>
		</tr>
		</table>
		</div>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="LABEL" width="50%"><font color="red">*</font>Base Unit</td>
			<td class="CONTROL"  width="50%">
			<div id="baseUnitId"><select name="strBaseUnit" id="baseUnit" >
    <bean:write name="unitBean" property="strUnitComboValues" filter="false"/></select> </div>
			</td>
		</tr>
		<tr>
			<td class="LABEL"><font color="red">*</font>Effective From</td>
			<td class="CONTROL"><dateTag:date name="strEffectiveDate" id="effDateId" value="${unitBean.strCtDate}"/></td>
		</tr>
		<tr>
			<td class="LABEL">Remarks</td>
			<td class="CONTROL"><textarea name="strRemarks" cols="20" rows="2"
				id="remarks"></textarea></td>
		</tr>
		<tr class="FOOTER">
			<td colspan="2" ><font size="2" color="red">*</font>
			Mandatory Fields</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>
      <td align="center">
      <!-- <img style="cursor:pointer;cursor:hand" title="Save Record" src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" >
      <img style="cursor:pointer;cursor:hand" title="Reset Content" src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset(),document.forms[0].strUnitName.focus();" />
	<img style="cursor:pointer;cursor:hand" title="Cancel Process" src="../../hisglobal/images/btn-ccl.png" onClick="cancel('LIST');" />
	 -->
	<br>					 
<a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
<a href="#" class="button"	onclick="document.forms[0].reset(),document.forms[0].strUnitName.focus();"><span class="clear">Clear</span></a> 
<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>

			</td>
</tr>
	</table>
	<input type="hidden" name="hmode" />
	<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>