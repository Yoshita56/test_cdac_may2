<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Physical Stock Verification Sheet</title>
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
	var hisValidator = new HISValidator("phyStockVerificationRpt");
		hisValidator.addValidation("strStoreId", "dontselect=0","Select Store Name from Store Combo ");
		hisValidator.addValidation("strItemCatNo", "dontselect=0","Select Item Category from Item Category Combo ");
		hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
		
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	
		if(retVal){
			document.forms[0].strStoreName.value    = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
	
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
function getItemCatCmb(){ 

		if(document.forms[0].strStoreId.value!=0){
			var url ="PhyStockVerificationSheetRptCNT.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
	 		ajaxFunction(url,"1");
	 	}else{
		document.forms[0].strItemCatNo.value="0";
		document.forms[0].strGroupId.value="0";
		document.forms[0].strItemId.value="0";
	}
}	

function getGroupCmb(){ 

	if(document.forms[0].strItemCatNo.value!=0){
		var url ="PhyStockVerificationSheetRptCNT.cnt?hmode=GROUPCMB&itemCatId="+document.forms[0].strItemCatNo.value;
 		ajaxFunction(url,"2");
 		}else{
		document.forms[0].strGroupId.value="0";
		document.forms[0].strItemId.value="0";
	}
}	

function getItemCmb(){ 

	if(document.forms[0].strGroupId.value!=0){
		var url ="PhyStockVerificationSheetRptCNT.cnt?hmode=ITEMCMB&groupId="+document.forms[0].strGroupId.value+"&storeId="+document.forms[0].strStoreId.value+"&itemCatId="+document.forms[0].strItemCatNo.value;
 		ajaxFunction(url,"3");
 		}else{
		document.forms[0].strGroupId.value="0";
	}
}

function getAjaxResponse(res,mode){
	
	if(mode=="1"){ 
		
		
			var objVal= document.getElementById("itemCatDivId");
			objVal.innerHTML = "<select name ='strItemCatNo' class='comboNormal' onchange='getGroupCmb();'>"+res+"</select>";		
		
	}	
	
	if(mode=="2"){ 
		
			var objVal= document.getElementById("groupDivId");
			objVal.innerHTML = "<select name ='strGroupId' class='comboNormal' onchange='getItemCmb();'>"+res+"</select>";		
	}	
	if(mode=="3"){ 
		
		
			var objVal= document.getElementById("itemDivId");
			objVal.innerHTML = "<select name ='strItemId' class='comboNormal' >"+res+"</select>";		
		
	}
}
	
function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}

function clearPage(){
		document.forms[0].strItemCatNo.value="0";
		document.forms[0].strGroupId.value="0";
		document.forms[0].strItemId.value="0";
		document.forms[0].strStoreId.value="0";
		document.forms[0].strFromDate.value=document.forms[0].strCurrentDate.value;
		document.forms[0].strToDate.value=document.forms[0].strCurrentDate.value;

}

function onLoadPage(){
		
		document.forms[0].strStoreId.value="0";
		document.forms[0].strFromDate.value=document.forms[0].strCurrentDate.value;
		document.forms[0].strToDate.value=document.forms[0].strCurrentDate.value;

}

</script>
</head>
<body onload="onLoadPage();">
<html:form action="/reports/PhyStockVerificationSheetRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="phyStockVerificationRpt" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="phyStockVerificationRpt" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="phyStockVerificationRpt" property="strWarningMsg"/></div>


	<tag:tab tabLabel="Physical Stock Verification Sheet"
                        selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Drug Warehouse Name</td>
			<td width="50%" colspan="2" class="CONTROL">
				<select name="strStoreId" class="comboNormal" onchange="getItemCatCmb();">
					<bean:write name="phyStockVerificationRpt" property="strStoreValues" filter="false" />
				</select>
			</td>
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Category</td>
				<td width="50%" colspan="2" class="CONTROL">
					<div id="itemCatDivId">
						<select	name="strItemCatNo" class="comboNormal" onchange="getGroupCmb();">
					<bean:write name="phyStockVerificationRpt" property="strItemCategCmb" filter="false" />
				</select>
				</div>
			</td>			
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">Group Name</td>
				<td width="50%" colspan="2" class="CONTROL">
					<div id="groupDivId">
						<select	name="strGroupId" class="comboNormal" onchange="getItemCmb();">
					<option value="0">All</option>
				</select>
				</div>
			</td>			
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">Item Name</td>
				<td width="50%" colspan="2" class="CONTROL">
					<div id="itemDivId">
						<select	name="strItemId" class="comboNormal" >
					<option value="0">All</option>
				</select>
			   </div>
			</td>			
		</tr>		
		<tr>
			<td class="LABEL" colspan="2"><font color="red">*</font>From Date</td>
			<td class="CONTROL" colspan="2"><dateTag:date name="strFromDate"
				value="${phyStockVerificationRpt.strCurrentDate}" /></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="2"><font color="red">*</font>To Date</td>
			<td class="CONTROL" colspan="2"><dateTag:date name="strToDate"
				value="${phyStockVerificationRpt.strCurrentDate}" /></td>
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
			<html:checkbox property="strIsFooter" name="phyStockVerificationRpt" value="1"></html:checkbox>
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
			 <td colspan="4"> <font color='red'>*</font>Mandatory Field</td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="return validate();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="clearPage();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" name="strStoreName" value="${phyStockVerificationRpt.strStoreName}" />
<input type="hidden" name="strCurrentDate" value="${phyStockVerificationRpt.strCurrentDate}"/>

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>