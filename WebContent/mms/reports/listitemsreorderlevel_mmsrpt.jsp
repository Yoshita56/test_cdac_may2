<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>List of Items Reaching Reorder Level</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script type="text/javascript">

function validate(){

	var hisValidator = new HISValidator("listItemsReorderLevelRpt");

if(document.getElementsByName("strStoreId")[0].value=="")
{
	alert("Select Drug Warehouse  Name ");
	document.getElementsByName("strStoreId")[0].focus();
	return false;
} 

	    hisValidator.addValidation("strStoreId", "dontselect=0","Select Drug Warehouse  Name ");
		hisValidator.addValidation("strItemCatNo", "dontselect=0","Select Item Category ");
		
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	if(retVal){

	
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
function getItemCatCmb(){ 

		if(document.forms[0].strStoreId.value!=0){
			var url ="ListItemsReorderLevelRptCNT.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
	 		ajaxFunction(url,"1");
	 	}else{
		document.forms[0].strItemCatNo.value="0";
	}
}

function getAjaxResponse(res,mode){
	
	if(mode=="1"){ 
		
		
			var objVal= document.getElementById("itemCatDivId");
			objVal.innerHTML = "<select name ='strItemCatNo' class='comboNormal'>"+res+"</select>";		
		
	}	
		
}
function onLoadPage(){

	document.forms[0].strStoreId.value="0";
	document.forms[0].strItemCatNo.value="0";

}		
</script>
</head>
<body onload="onLoadPage();">
<html:form action="/reports/ListItemsReorderLevelRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="listItemsReorderLevelRpt" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="listItemsReorderLevelRpt" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="listItemsReorderLevelRpt" property="strWarningMsg"/></div>


	<tag:tab tabLabel="List of Items Reaching Reorder Level"
                        selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4">List of Items Reaching Reorder Level</td>
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Drug Warehouse Name</td>
			<td width="50%" colspan="2" class="CONTROL">
				<select name="strStoreId" class="comboNormal" onchange="getItemCatCmb();">
					<bean:write name="listItemsReorderLevelRpt" property="strStoreValues" filter="false" />
				</select>
			</td>
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Category</td>
				<td width="50%" colspan="2" class="CONTROL">
					<div id="itemCatDivId">
						<select	name="strItemCatNo" class="comboNormal">
					<bean:write name="listItemsReorderLevelRpt" property="strItemCategoryCombo" filter="false" />
				</select>
				</div>
			</td>			
		</tr>
		
		
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			Report Format
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<select name="strReportFormat"  onchange="">
			<option value="html">Html</option>
			<option value="pdf">Pdf</option></select>
			</td>
			
		</tr> 
		
		<tr>
			<td width="50%" colspan="2" class="LABEL">
			Footer Required
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<html:checkbox property="strIsFooter" name="listItemsReorderLevelRpt" value="1"></html:checkbox>
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
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="return validate();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" name="strStoreName" value="${listItemsReorderLevelRpt.strStoreName}" />

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>