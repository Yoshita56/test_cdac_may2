<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset="utf-8">
<title>Unit Master Modify Page</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>

<script type="text/javascript">

function validate1(){	
	
		var hisValidator = new HISValidator("unitBean");
		hisValidator.addValidation("strUnitName", "req", "Unit Name is a Mandatory Field" );
		hisValidator.addValidation("strEffectiveDate", "req","Effective From is a Madatory Field");
		hisValidator.addValidation("strUnitName", "maxlen=25", "Remarks should have less than or equal to 25 Characters" );
		
			if(document.unitBean.strRemarks.value != ""){
				hisValidator.addValidation("strRemarks", "maxlen=50", "Remarks should have less than or equal to 50 Characters" );
			}
		
		var retVal = hisValidator.validate(); 
		
		if(retVal){
				document.forms[0].hmode.value = "UPDATE";
				document.forms[0].submit();
		}else{
		
				return false;
		}
	}
	
function isDecimalShow()
{
if(document.forms[0].strIsBaseUnit.value=="Yes")
{
	document.getElementById("isDecimalId").style.display="block";
	if(document.forms[0].decimalFlag.value=="1")
	{
		document.forms[0].strIsDecimal.checked=true ;
	}
}
else{
	document.getElementById("isDecimalId").style.display="none";
}

document.forms[0].strUnitName.focus();
}

</script>

</head>
<body onLoad="isDecimalShow();">
<html:form action="/masters/CNTUnitMst.cnt"
	type="mms.masters.vo.VOUnitMst" name="unitBean">
	
	<div class="errMsg"><bean:write name="unitBean" property="strErr"/></div>
	<div class="warningMsg"><bean:write name="unitBean" property="strWarning"/></div>
	<div class="normalMsg" id='normalMsg'><bean:write name="unitBean" property="strMsg"/></div>
	<tag:tab tabLabel="Modify Unit" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab>
	
<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
  <tr class="HEADER"> 
    <td colspan="2">Unit Master&gt;&gt; Modify</td>
  </tr>
  <tr> 
    <td width="50%" class="LABEL"> Module Name</td>
    <td width="50%" class="CONTROL"><bean:write name="unitBean" property="strModuleVal"/></td>
  </tr>
  <tr> 
    <td class="LABEL"><font color="red">*</font>Unit Name</td>
    <td class="CONTROL"> <input name="strUnitName" type="text" id="unitName" maxlength="25" value="${unitBean.strUnitName}" onkeypress="return validateData(event,17);">  </td>
  </tr>
  <tr> 
    <td class="LABEL">Whether Base Unit</td>
    <td class="CONTROL"> <bean:write property="strIsBaseUnit" name="unitBean" />
     </td>
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
    <td class="LABEL" width="50%">Base Unit</td>
    <td class="CONTROL" width="50%"><bean:write name="unitBean" property="strBaseUnit"/></td>
  </tr>
  <tr> 
    <td class="LABEL"> Effective From </td>
    <td class="CONTROL"> <bean:write name="unitBean" property="strEffectiveDate"/> </td>
  </tr>
  <tr> 
    <td class="LABEL"> Remarks</td>
    <td class="CONTROL"> <textarea name="strRemarks" cols="20" rows="2"
				id="remarks"><bean:write name="unitBean"  property="strRemarks"/></textarea> </td>
  </tr>
   <tr> 
    <td class="LABEL">Record Status</td>
    <td  class="CONTROL" >
        <html:radio name="unitBean" property="strValid" value="1" />Active
<html:radio name="unitBean" property="strValid" value="2" />Inactive
</td>
  </tr>
  <tr class="FOOTER"> 
    <td colspan="2" align="right"><font size="2" color="red">*</font> Mandatory Fields  </td>
  </tr>
</table>
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="right">
			<br>
		<!-- 	<img style="cursor:pointer;cursor:hand"   title="Save Record" src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" > -->
			
				<a href="#" class="button" id="" onclick=' return validate1();'><span class="save">Save</span></a>
				
	</td>
			<td align="left">

			<!--  <img style="cursor:pointer;cursor:hand" title="Cancel the Process" src="../../hisglobal/images/btn-ccl.png" onClick="cancel('LIST');" > -->
				<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>

			</td>
		</tr>
	</table>
	<input type="hidden" name="chk" value="${unitBean.chk[0]}" >
<input type="hidden" name="hmode"/>
<input type="hidden" name="strIsBaseUnit" value="${unitBean.strIsBaseUnit}"/>
<input type="hidden" name="decimalFlag" value="${unitBean.strIsDecimal}"/>
<input type="hidden" name="strEffectiveDate" id="effDateId"
				 value="${unitBean.strEffectiveDate}"/>
<cmbPers:cmbPers/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>