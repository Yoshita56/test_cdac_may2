<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>PO Register</title>
<!-- <link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet" type="text/css">-->

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

function validate()
{
		var finCombo= document.forms[0].strFinYearId[document.forms[0].strFinYearId.selectedIndex].value;
		var hisValidator = new HISValidator("purchaseOrderDtlRPT");

		hisValidator.addValidation("strDistrictStoreId", "dontselect=-1","Store Name is a mandatory field");
		hisValidator.addValidation("strSupplierId", "dontselect=-1","Supplier Name is a mandatory field");
		
		if(finCombo==0)
		{	
			hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
			hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
			hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
			hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
		}
	
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	
	
	if(retVal)
	{
		
		if(document.forms[0].strDistrictStoreId)
		document.forms[0].strStoreName.value = document.forms[0].strDistrictStoreId[document.forms[0].strDistrictStoreId.selectedIndex].text;
		//document.forms[0].strProgName.value = document.forms[0].strProgId[document.forms[0].strProgId.selectedIndex].text;
		document.forms[0].strSuppPOStatusName.value = document.forms[0].strSuppPOStatus[document.forms[0].strSuppPOStatus.selectedIndex].text;
		//document.forms[0].strClassificationName.value = document.forms[0].strItemCatNo[document.forms[0].strItemCatNo.selectedIndex].text;
		document.forms[0].strCircleName.value = document.forms[0].strItemCatNo[document.forms[0].strItemCatNo.selectedIndex].text;
		document.forms[0].hmode.value = "SHOWRPT";
		
		if(document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html")
		{
			document.forms[0].target = "_self";
		}
		else
		{
			document.forms[0].target = "_blank";
		}
			document.forms[0].submit();
	}
	else
	{
		return false;
	}
}

function onLoadPage()
{
	document.getElementsByName("strWhetherItemShown")[0].checked = true;
	document.getElementsByName("strPoType")[0].checked=true;
	document.getElementsByName("strPoType")[1].checked=false;
	document.getElementsByName("strPoType")[2].checked=false;	 	 	
	
	
	// var userLevel = document.forms[0].strUserLevel.value
      
}

function resetPage()
{
	document.forms[0].reset();
	
}	

function cancelPage()
{
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();
	

}


function setValueChk(chkObj)
{
    
    if(chkObj.value =='1')
	 {
	    document.getElementsByName("strPoType")[1].checked=false;
	document.getElementsByName("strPoType")[2].checked=false;	// Annual PO 	
     }
   else if(chkObj.value =='2')
 	{ 
	   // document.getElementsByName("strPoType")[0].checked=false;
	   // document.getElementsByName("strPoType")[2].checked=false;	// Local PO
	 	
	}
	else
	{
		document.getElementsByName("strPoType")[0].checked=false;
	    document.getElementsByName("strPoType")[1].checked=false;	// All PO
	}
}







function getItemCmb(){

	
	var url ="PurchaseOrderDtlRptCNT_NEW.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strDistrictStoreId.value;
	ajaxFunction(url,"1");	

}
function getSupplierName(){

	
	var url ="PurchaseOrderDtlRptCNT_NEW.cnt?hmode=SUPPLIERCMB&storeId="+document.forms[0].strDistrictStoreId.value+"&catId="+document.forms[0].strItemCatNo.value;
	ajaxFunction(url,"2");	

}

function hideDateDetails()
{
	var finCombo= document.forms[0].strFinYearId[document.forms[0].strFinYearId.selectedIndex].value;

	if(finCombo==0)
		{
		document.getElementById("dateRow").style.display="";
		document.getElementById("dateRow1").style.display="";	
		}
	else
		{
		document.getElementById("dateRow").style.display="none";
		document.getElementById("dateRow1").style.display="none";
		}
}



function getAjaxResponse(res,mode){
	
	if(mode=="1"){ 	     
			var objVal= document.getElementById("strItemCatDivId");
			objVal.innerHTML = "<select name ='strItemCatNo' class='comboMax' onChange='getSupplierName();' >"+res+"</select>";		
	}
	if(mode=="2"){ 	     
		var objVal= document.getElementById("strSupplierDivId");
		objVal.innerHTML = "<select name ='strSupplierId' class='comboMax'>"+res+"</select>";		
}			
}	


</script>
</head>
<body class="background" onload="onLoadPage();">
<html:form action="/reports/PurchaseOrderDtlRptCNT_NEW" method="post" styleClass="formbg">

	<div class="errMsg" id="errMsg"><bean:write
		name="purchaseOrderDtlRPT" property="strErrMsg" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="purchaseOrderDtlRPT" property="strNormalMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="purchaseOrderDtlRPT" property="strWarningMsg" /></div>

	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">

		<tr class="HEADER">
			<td colspan="4" class='all-four-rounded-corners'>PO Register
			<div style="float:right;"><input type="checkbox"
				name="strWhetherItemShown" value="1" checked="checked" />
			Whether Item Has To Show
			</div>
			</td>
		</tr>

		<tr>
			<td class="LABEL" colspan="4">
				<!-- <input type="radio" name="strPoType" value="1" onclick="setValueChk(this);" checked="checked">Annual PO --> 
				<input type="radio" name="strPoType" value="2"  onclick="setValueChk(this);" checked="checked">Local PO
				<!-- <input type="radio" name="strPoType" value="0"  onclick="setValueChk(this);">All PO -->
				</td>
		</tr>

		
			
		<tr id="districtDrugWarehouseDivId" >
			<td width="25%" class="LABEL"><font color="red">*</font>Store Name</td>
			<td width="25%" class="CONTROL">
			<div id="strStoreDivId" >
				<select name="strDistrictStoreId" class="comboMax" onChange="getItemCmb();">
					<bean:write name="purchaseOrderDtlRPT" property="strDistrictStoreValues" filter="false"/>
				</select>
			</div>				
			</td>
			</tr>
	
	<tr id="itemcatDivId" >
			<td width="25%" class="LABEL"><font color="red">*</font>Item Category</td>
			<td width="25%" class="CONTROL">
			<div id="strItemCatDivId" >
				<select name="strItemCatNo" class="comboMax" onchange="getSupplierName();">
					<bean:write name="purchaseOrderDtlRPT" property="strItemCatCMB" filter="false"/>
					<option value="0">All</option>
				</select>
			</div>				
			</td>
			</tr>		
			
			<tr>
			<td class="LABEL"  width="25%"><font color="red">*</font>Supplier Name</td>
			<td class="CONTROL"  width="25%">
			<div id="strSupplierDivId" >
			<select name="strSupplierId" class="comboMax" > 
				<bean:write name="purchaseOrderDtlRPT" property="strSupplierCmb" filter="false" />
				<option value="0">All</option>
			</select>
			</div>
			</td>
		</tr>
		
		<tr>
			<td class="LABEL" width="25%" ><font color="red">*</font>
			PO Status</td>
			<td class="CONTROL" width="25%" ><select class="comboMax" name="strPoStatus">
				<option value="1">Active</option>
				<option value="3">Cancelled/Rejected</option>
			</select></td>
			</tr>
			<tr>
			<td width="25%"  class="LABEL">Financial Year</td>
			<td width="25%" class="CONTROL">			
				<select name="strFinYearId" class="comboMax" id="strFinYear" onChange="hideDateDetails();"><!-- onChange="hideDateDetails();" -->
					<bean:write name="purchaseOrderDtlRPT" property="strFinYearCombo" filter="false"/>
				</select>
						
			</td> 
		</tr>
		
		<tr>
			<%-- <td width="25%" colspan="1" class="LABEL"><bean:message key="label.common.Programme_Name"/></td>
			<td width="25%" colspan="1" class="CONTROL" >
				<div id="progDivId">
				<select name="strProgId" class="comboMax" onchange="getProgDrugList();">
					<bean:write name="purchaseOrderDtlRPT" property="strProgNameId" filter="false" />
				</select>
				</div>
			</td> --%>
			
			<td width="25%"  class="LABEL">Supplier PO Status</td>
			<td width="25%"  class="CONTROL">			
			<select name="strSuppPOStatus" class="comboNormal" id="strSuppPOStatus" onchange="getPOCmbSuppPOStatus();">
				<option value="3">All</option>
				<option value="1">Pending</option>
				<option value="0">Accepted</option>
				<option value="2">Rejected</option>
			</select>
					
		</td>
		</tr>
		
		<tr>		
		<%-- <td width="25%" colspan="1" class="LABEL"><font color="red">*</font><bean:message key="label.common.Drug_classification"/></td>
			<td width="25%" colspan="1" class="CONTROL">
				<div id="itemCatDivId">
					<select	name="strItemCatNo" class="comboMax">
					<bean:write name="purchaseOrderDtlRPT" property="strCatVal" filter="false" />
			</select>
			</div>
		</td> --%>	
		</tr>
		

		<tr id="dateRow">
			<td class="LABEL" width="25%"><font color="red">*</font>From
			Date</td>
			<td class="CONTROL" width="25%" ><dateTag:date name="strFromDate"
				value="${purchaseOrderDtlRPT.strCurrentDate}" /></td>
				</tr>
			<tr id="dateRow1">
			<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>To Date</td>
			<td class="CONTROL" width="25%" colspan="1"><dateTag:date name="strToDate"
				value="${purchaseOrderDtlRPT.strCurrentDate}" /></td>
		</tr>
		
		
		

<!-- <tr><td colspan="4">
<div class="line" style="width:100%;margin-left:0%"><table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
		<tr>
			<td >Report Options</td>
		</tr>		
		</table>
	</div>
</td></tr> -->

		<tr>
			<td width="50%"  class="LABEL">Report Format</td>
			<td width="50%"  class="CONTROL"><select
				name="strReportFormat" onchange="">
				<option value="html">Html</option>
				<option value="pdf">Pdf</option>
				<option value="xls">Excel</option>
			</select></td>
		</tr>

		<tr>
			<td width="50%"  class="LABEL">Footer Required</td>
			<td width="50%"  class="CONTROL"><html:checkbox
				property="strIsFooter" name="purchaseOrderDtlRPT" value="1"></html:checkbox>
			</td>
		</tr>

		<tr>
			<td width="50%"  class="LABEL">User Remarks</td>
			<td width="50%"  class="CONTROL"><input
				class="txtFldMax" type="text" name="strUserRemarks"></td>
		</tr>

		<tr class="FOOTER">
			<td colspan="4" class='all-four-rounded-corners'><font size="2" color="red">*</font> Mandatory Fields</td>
		</tr>
	</table>
	
	<div><div class="legends"></div>
	<div class="control_button">
	<table  class="TABLEWIDTH" align="center">
	<tr>
	<br>
	<td align="center"><div>
				<a href="#" class="button" onClick="return validate();"><span class="generate">Generate</span></a>
				<a href="#" class="button" onClick="resetPage();"><span class="clear">Clear</span></a>
				<a href="#" class="button" onClick="cancelPage();"><span class="cancel">Cancel</span></a>				 
				</div></td>
	</tr>	  
	</table>
	</div></div>
	
	

	<input type="hidden" name="hmode" />	
	<input type="hidden" name="strCurrentDate" value="${purchaseOrderDtlRPT.strCurrentDate}" />
	<input type="hidden" name="strCircleName" value="${purchaseOrderDtlRPT.strCircleName}"/>
	<input type="hidden" name="strDistrictName" value="${purchaseOrderDtlRPT.strDistrictName}"/>
	<input type="hidden" name="strStoreName" value="${purchaseOrderDtlRPT.strStoreName}"/>
	<input type="hidden" name="strProgName"/>
	<input type="hidden" name="strIsDdwFlag" value="${purchaseOrderDtlRPT.strIsDdwFlag}" />
	<input type="hidden" name="strSuppPOStatusName" value="" />
	<input type="hidden" name="strClassificationName" value="" />
	

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>