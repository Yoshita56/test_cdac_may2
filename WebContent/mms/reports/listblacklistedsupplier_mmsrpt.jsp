<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>List of Black Listed Supplier</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script type="text/javascript">

function validate(){

var hisValidator = new HISValidator("listblacklistedRpt");
	hisValidator.addValidation("strHospitalCode", "dontselect=0","Please Select Hospital Name");
	  hisValidator.addValidation("strItemCatNo", "dontselect=0","Select Item Category From Item Category Combo");
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	if(retVal){

	document.forms[0].strItemCategoryName.value    = document.forms[0].strItemCatNo[document.forms[0].strItemCatNo.selectedIndex].text;
	
		document.forms[0].hmode.value = "SHOWRPT";
		
			if(document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html")
			{
				document.forms[0].target = "_self";
			}else{
				document.forms[0].target = "_blank";
			}
		document.forms[0].submit();
		
		}else{
			return false;
		}
	}
function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}
function onLoadPage(){

	document.forms[0].strItemCatNo.value = "0";

}

</script>
</head>
<body onload="onLoadPage();">
<html:form action="/reports/ListBlackListedSupplierRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="listblacklistedRpt" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="listblacklistedRpt" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="listblacklistedRpt" property="strWarningMsg"/></div>


	<tag:tab tabLabel="List of Black Listed Supplier"
                        selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		<tr style=" display: none;">
			<td width="50%" colspan="2" class="LABEL"><font color='red'>*</font>Hospital name</td>
			<td width="50%" colspan="2" class="CONTROL">
			<select name="strHospitalCode"  class="comboNormal">
			<bean:write name="listblacklistedRpt" property="strHospNameValues" filter="false"/>
			</select>
			</td>			
		</tr>	
		
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color='red'>*</font>Category</td>
			<td width="50%" colspan="2" class="CONTROL">
				<select name="strItemCatNo" class="comboNormal" >
					<bean:write name="listblacklistedRpt" property="strItemCatValues"
						filter="false" />
					
				</select>
			</td>
		</tr>
	
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			Report Format
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<select name="strReportFormat"  onchange="">
			<option value="pdf">Pdf</option>
			<option value="html">Html</option>
			</select>
			</td>
			
		</tr> 
		
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			Footer Required
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<html:checkbox property="strIsFooter" name="listblacklistedRpt" value="1"></html:checkbox>
			</td>
			
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			User Remarks
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<input class="txtFldMax" type="text" name="strUserRemarks" >
			</td>
			
		</tr>
		<tr class="FOOTER">
			 <td colspan="4"><font color='red'>*</font>Mandatory Field </td>
		</tr>
	</table>
	<!-- <table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="return validate();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table>-->
	<br>
<div align="center" id="">					 
					 	<a href="#" class="button" id="" onclick=' return validate();'><span class="generate">Generate</span></a>
						<a href="#" class="button"	onclick="document.forms[0].reset()"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelFunc();"><span class="cancel">Cancel</span></a>
				</div>
<input type="hidden" name="hmode"/>
<input type="hidden" name="strItemCategoryName" value="${summlistindentpurchaseRpt.strItemCategoryName}" />

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>