<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<html>
<head>
<title>Stock On Hand Record</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script type="text/javascript">

function validate(){


	var hisValidator = new HISValidator("stockOnHandRpt");
	
	if(document.getElementsByName("whetherConsolidatedStockForAllInstitutseOfDistrictDrugWarehouse")[0].checked==true)
	{
			hisValidator.addValidation("strDistrictStoreId", "dontselect=-1","Select District Drug Warehouse Name ");
		
	}
	else
	{
		hisValidator.addValidation("strStoreId", "dontselect=-1","Select Drug Warehouse / Sub-Store Name ");
	}
	
	
	
	hisValidator.addValidation("strItemCatNo", "dontselect=0","Select Item Category from Item Category Combo ");
	
	if(document.forms[0].strCurrentStock.checked == false){
			hisValidator.addValidation("strDate", "date","To Date is a mandatory field");
			hisValidator.addValidation("strDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select Date Less Than or Equal To Current Date");
	}			
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	
		if(retVal){
			
			if(document.getElementsByName("whetherConsolidatedStockForAllInstitutseOfDistrictDrugWarehouse")[0].checked==true)
			{
				document.forms[0].strStoreName.value = document.forms[0].strDistrictStoreId[document.forms[0].strDistrictStoreId.selectedIndex].text;
			}
			else
			{
				document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
			}
			
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


	if(document.getElementsByName("whetherConsolidatedStockForAllInstitutseOfDistrictDrugWarehouse")[0].checked==true)
	{
			
			
			if(document.forms[0].strDistrictStoreId.value!=0)
			{
				var url ="StockOnHandRptCNT.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strDistrictStoreId.value;
		 		ajaxFunction(url,"1");
		 		
		 	}
		 	else
		 	{
				document.forms[0].strItemCatNo.value="0";
				document.forms[0].strGroupId.value="0";
			}
		
	}
	else
	{
		if(document.forms[0].strStoreId.value!=0)
		{
			var url ="StockOnHandRptCNT.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
	 		ajaxFunction(url,"1");
	 		
	 	}
	 	else
	 	{
			document.forms[0].strItemCatNo.value="0";
			document.forms[0].strGroupId.value="0";
		}
	}
	
		
}	

function getGroupCmb(){ 

	if(document.forms[0].strItemCatNo.value!=0)
	{
		var url ="StockOnHandRptCNT.cnt?hmode=GROUPCMB&itemcat="+document.forms[0].strItemCatNo.value;
 		ajaxFunction(url,"2");
 	}
 	else
 	{
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
			objVal.innerHTML = "<select name ='strGroupId' class='comboNormal' >"+res+"</select>";		
		
	}	
}	
	
function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}

function onBodyDisplay(){

	if(document.forms[0].strCurrentStock1.value == "1"){
	
		document.forms[0].strCurrentStock1.checked = true;
		document.forms[0].strCurrentStock.value = 1;
	}
	
	document.forms[0].strStoreId.value = "0";
	document.forms[0].strItemCatNo.value="0";
	document.forms[0].strGroupId.value="0";
}

function onDateDisplay(){

	if(document.getElementsByName("strCurrentStock1")[0].checked == true){
	
	document.getElementById("dateDivId").style.display = "none";
		document.forms[0].strCurrentStock.value = 1;
		 
		
	}else{
	document.getElementById("dateDivId").style.display = "block";
		document.forms[0].strCurrentStock.value = 0;
		
	 
	}
		
}

function onClickClear(){

		document.forms[0].strStoreId.value = "0";
		document.forms[0].strItemCatNo.value = "0";	
	if(document.forms[0].strCurrentStock1.checked == false){
		document.getElementById("dateDivId").style.display = "none";
		document.forms[0].strCurrentStock1.checked = true;
		document.forms[0].strCurrentStock.checked = 1;
		document.forms[0].strDate.value = document.forms[0].strCurrentDate.value;
	}
}

function onClickBatch(){

		if(document.forms[0].strBatchNo.checked){
		
			document.forms[0].strBatchNo.value = "1";
		
		}else if(document.forms[0].strBatchNo.checked == false){
		
			document.forms[0].strBatchNo.value = "0";
		
		}

}

function setDistrictDrugWarehouseCombo()
{
	if(document.getElementsByName("whetherConsolidatedStockForAllInstitutseOfDistrictDrugWarehouse")[0].checked==true)
	{
		document.getElementById("drugWarehouseDivId").style.display='none';
		
		document.getElementById("districtDrugWarehouseDivId").style.display='';
		
		
		
	}
	else
	{
		document.getElementById("drugWarehouseDivId").style.display='';
		
		document.getElementById("districtDrugWarehouseDivId").style.display='none';
		
	}
	
}


</script>
</head>
<body onload="onBodyDisplay();">
<html:form action="/reports/StockOnHandRptCNT" method="post">

	<div class="errMsg" id="errMsg"><bean:write name="stockOnHandRpt"
		property="strErrMsg" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="stockOnHandRpt" property="strNormalMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="stockOnHandRpt" property="strWarningMsg" /></div>


	<tag:tab tabLabel="Stock On Hand Record" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
	
		

	<tr  style="display: none;">
		
	<%-- Change Request --%>
			<td colspan="2" class="LABEL" width="50%" align="right">
				<input type="checkbox" name="whetherConsolidatedStockForAllInstitutseOfDistrictDrugWarehouse" value="1"  onclick="setDistrictDrugWarehouseCombo();" />
			</td>
		
		
			<td colspan="2" class="CONTROL" width="50%" align="right">
				Whether Consolidated Stock For All Institutes Of District Drug Warehouse
			</td>			
	</tr>

	<tr>
		
			<td colspan="2" class="LABEL" width="50%" align="right"></td>
			<td colspan="2" class="CONTROL" width="50%" align="right"></td>	
				
					
	</tr>
	<%-- Change Request End --%>
		
		<%-- District Drug warehouse Name	 --%>	
			
		<tr id="districtDrugWarehouseDivId" style="display: none;">
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>District Drug Warehouse Name</td>
			<td width="50%" colspan="2" class="CONTROL">
			<div id="strStoreDivId" >
				<select name="strDistrictStoreId" class="comboNormal" onchange="getItemCatCmb();">
				
					<bean:write name="stockOnHandRpt" property="strDistrictStoreValues" filter="false"/>
				</select>
			</div>				
			</td>
		</tr>		
				
				
		<tr	id="drugWarehouseDivId">
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Store Name</td>
			<td width="50%" colspan="2" class="CONTROL"><select
				name="strStoreId" class="comboNormal" onchange="getItemCatCmb();">
				
				<bean:write name="stockOnHandRpt" property="strStoreValues"
					filter="false" />
					
			</select></td>
		</tr>
		
		
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Item Category</td>
			<td width="50%" colspan="2" class="CONTROL">
			<div id="itemCatDivId"><select name="strItemCatNo" class="comboNormal" onchange="getGroupCmb();">
				<option value="0">SelectValue</option>
				<option value="10">Drug</option>
			</select></div>
			</td>
			</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">Group Name</td>
			<td width="50%" colspan="2" class="CONTROL">
			<div id="groupDivId"><select name="strGroupId"
				class="comboNormal">
				<option value="0">All</option>
			</select></div>
			</td>
			</tr>
			<tr style="display: none;">
			<td width="50%" colspan="2" class="LABEL" >Status</td>
			<td width="50%" colspan="2" class="CONTROL">
			<div id="StatusDivId" >
				<select name="strStatusId" class="comboNormal" >
					<option title="All" selected="selected" value="1">All</option>
					<option title="Active" value="2">Active(Ready For Issue)</option>
					<option title="Quarantine" value="3">Quarantine</option>
					<option title="InActive" value="4">InActive(NOSQ)</option>
				</select>
			</div>				
			</td>
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">Batch No.</td>
			<td width="50%" colspan="2" class="CONTROL"><html:checkbox
				property="strBatchNo" name="stockOnHandRpt" value="1"
				onclick="onClickBatch();">
			</html:checkbox></td>

		</tr>
	</table>

	<div id="dateDivId" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<tr>
			<td class="LABEL" width="50%" colspan="2"><font color="red">*</font>Date</td>
			<td class="CONTROL" width="50%" colspan="2"><dateTag:date
				name="strDate" value="${stockOnHandRpt.strCurrentDate}" /></td>
		</tr>
	</table>
	</div>

	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<tr>
			<td width="50%" colspan="2" class="LABEL">Report Format</td>
			<td width="50%" colspan="2" class="CONTROL"><select
				name="strReportFormat" onchange="">
								<option value="html">Html</option>
								<option value="pdf">Pdf</option>
								<option value="xls">Excel</option></select>
				
				
			</select></td>

		</tr>

		<tr>
			<td width="50%" colspan="2" class="LABEL">Footer Required</td>
			<td width="50%" colspan="2" class="CONTROL"><html:checkbox
				property="strIsFooter" name="stockOnHandRpt" value="1"></html:checkbox>
			</td>

		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">User Remarks</td>
			<td width="50%" colspan="2" class="CONTROL"><input
				class="txtFldMax" type="text" name="strUserRemarks"></td>

		</tr>
		<tr class="FOOTER">
			<td colspan="4"><font color='red'>*</font>Mandatory Field</td>
		</tr>
	</table>
<!--	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<tr>

			<td align="center"><img style=" cursor: pointer"
				src="../../hisglobal/images/btn-generate.png"
				onClick="return validate();" /> <img
				style=" cursor: pointer"
				src="../../hisglobal/images/btn-clr.png" onClick="onClickClear();">
			<img style=" cursor: pointer"
				src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();">
			</td>

		</tr>
	</table>-->
	<br>
<div align="center" id="">					 
					 	<a href="#" class="button" id="" onclick=' return validate();'><span class="generate">Generate</span></a>
						<a href="#" class="button"	onclick="onClickClear();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelFunc();"><span class="cancel">Cancel</span></a>
				</div>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strStoreName" value="${stockOnHandRpt.strStoreName}" />
	<input type="hidden" name="strCurrentDate" value="${stockOnHandRpt.strCurrentDate}" />
	<input type="hidden" name="strCurrentStock" value="${stockOnHandRpt.strCurrentStock}" />



</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>
