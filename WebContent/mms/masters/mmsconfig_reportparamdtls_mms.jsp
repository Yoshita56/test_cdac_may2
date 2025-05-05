<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>

<html>
<head>
<meta charset="utf-8">
<title>Store Setup</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>

<script type="text/javascript">

	
	function validate1(){	
	
		retVal = false;
		var hisValidator = new HISValidator("mmsConfigBean");
	
		hisValidator.addValidation("strCategoryA", "req","Category A is a Mandatory Field");
	 	hisValidator.addValidation("strCategoryB1", "req","Category B is a Mandatory Field");
	 	hisValidator.addValidation("strCategoryB2", "req","Category B is a Mandatory Field");
		hisValidator.addValidation("strCategoryC", "req","Category C is a Mandatory Field");
		
		hisValidator.addValidation("strCategoryF", "req","Category F / X is a Mandatory Field");
	 	hisValidator.addValidation("strCategoryN1", "req","Category N / Y is a Mandatory Field");
	 	hisValidator.addValidation("strCategoryN2", "req","Category N / Y is a Mandatory Field");
		hisValidator.addValidation("strCategoryS", "req","Category S / Z is a Mandatory Field");
		
		retVal = hisValidator.validate(); 
		hisValidator.clearAllValidations();
		if(retVal){
		
		document.forms[0].strCategoryB2.disabled = false;
		document.forms[0].strCategoryC.disabled = false;
		document.forms[0].strCategoryN1.disabled = false;
		document.forms[0].strCategoryS.disabled = false;

			document.forms[0].selectedTab.value = "SAVEREPORTPARAMDTLS";
			document.forms[0].submit();

		}else{
		
		return false;
		}
		
	}
 
 	function setB2Value(obj){
 	
 		document.forms[0].strCategoryB2.value = obj.value;
 		
 	}
 
 
 	function setCValue(obj){
 	
 		document.forms[0].strCategoryC.value = obj.value;
 	
 	}
 
 
 function setN1Value(obj){
 	
 		document.forms[0].strCategoryN1.value = obj.value;
 		
 	}
 
 
 	function setSValue(obj){
 	
 		document.forms[0].strCategoryS.value = obj.value;
 	
 	}
 
 
function clearPage(mode){

	document.forms[0].selectedTab.value = mode ;
	document.forms[0].submit();
}

</script>

</head>
<body onload="setMultiRowIndex();">
<html:form action="/masters/MmsConfigMstCNT" method="post" name="mmsConfigBean" type="mms.masters.controller.fb.MmsConfigMstFB" >
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="mmsConfigBean" property="strErrMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="mmsConfigBean" property="strNormalMsg" /></div>
	
	              
              <tag:tab tabList="${mmsConfigBean.lhm}" selectedTab="mmsreportParamdtls" align="center" width="TABLEWIDTH"></tag:tab>
              
</center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="2">Store Setup &gt;&gt; Report Parameters</td>
		</tr>
		<tr class="TITLE" >
		<td colspan="2">ABC Analysis
		</td>
		</tr>
		 
		
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="multiLabel" width="25%">Category
			</td>
			<td class="multiLabel" width="25%">Consumption Value
			</td>
		</tr>
		<tr>
			<td class="multiLabel" width="25%"><font color="red">*</font>A
			</td>
			<td class="multiControl" width="75%">Greater Than <input type="text" class="txtFldMin" name="strCategoryA"  value="${mmsConfigBean.strCategoryA}" maxlength="5" onkeypress="return validateData(event,5);" onkeyup="setB2Value(this);">
			</td>
		</tr>
		<tr>
			<td class="multiLabel" width="25%"><font color="red">*</font>B
			</td>
			<td class="multiControl" width="75%">Greater Than <input type="text" class="txtFldMin" name="strCategoryB1" maxlength="5" onkeypress="return validateData(event,5);" onkeyup="setCValue(this);" value="${mmsConfigBean.strCategoryB1}"> and Less / Equal To <input type="text" class="txtFldMin" name="strCategoryB2" disabled="disabled" maxlength="5" onkeypress="return validateData(event,5);" value="${mmsConfigBean.strCategoryB2}"> 
			</td>
		</tr>
		<tr>
			<td class="multiLabel" width="25%"><font color="red">*</font>C
			</td>
			<td class="multiControl" width="75%">Less / Equal To <input type="text" class="txtFldMin" name="strCategoryC" maxlength="5" onkeypress="return validateData(event,5);"  disabled="disabled" value="${mmsConfigBean.strCategoryC}">
			</td>
		</tr>
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr class="TITLE" >
		<td colspan="2">FSN / XYZ Analysis
		</td>
		</tr>
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="multiLabel" width="25%">Category
			</td>
			<td class="multiLabel" width="25%">Consumption Value
			</td>
		</tr>
		<tr>
			<td class="multiLabel" width="25%"><font color="red">*</font>F / X
			</td>
			<td class="multiControl" width="75%">Greater Than <input type="text" class="txtFldMin" name="strCategoryF" maxlength="5" onkeypress="return validateData(event,5);" onkeyup="setN1Value(this);"  value="${mmsConfigBean.strCategoryF}"> day(s)
			</td>
		</tr>
		<tr>
			<td class="multiLabel" width="25%"><font color="red">*</font>N / Y
			</td>
			<td class="multiControl" width="75%">Greater Than <input type="text" class="txtFldMin" name="strCategoryN1" maxlength="5" onkeypress="return validateData(event,5);" disabled="disabled" value="${mmsConfigBean.strCategoryN1}"> and Less / Equal To <input type="text" class="txtFldMin" name="strCategoryN2" maxlength="5" onkeypress="return validateData(event,5);" onkeyup="setSValue(this);" value="${mmsConfigBean.strCategoryN2}"> day(s)
			</td>
		</tr>
		<tr>
			<td class="multiLabel" width="25%"><font color="red">*</font>S / Z
			</td>
			<td class="multiControl" width="75%">Less / Equal To <input type="text" class="txtFldMin" maxlength="5" onkeypress="return validateData(event,5);" name="strCategoryS" disabled="disabled" value="${mmsConfigBean.strCategoryS}"> day(s)
			</td>
		</tr>
				 
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
<!--	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" />
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" onClick="clearPage('mmsreportParamdtls')" >
			<img  style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
		</tr>
	</table>-->
	<br>
	<div align="center" id=" ">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="clearPage('mmsreportParamdtls');"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelFunc();"><span class="cancel">Cancel</span></a>
				</div>
<input 	type="hidden" name="selectedTab">

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>