<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset="utf-8">
<title>Insert Title Here</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>


<script type="text/javascript"><!--
	var flag=false;
	function view1(id1,id2,id3)
	{
		document.getElementById(id1).style.display="none";
		document.getElementById(id2).style.display="block";
		document.getElementById(id3).style.display="block";
	}
	function view2(id1,id2,id3)
	{
		document.getElementById(id1).style.display="block";
		document.getElementById(id2).style.display="none";
		document.getElementById(id3).style.display="none";
	}
	
	function setConsentReq()
	{ 
		if(document.forms[0].strConsentReq.checked==true)
		{
		// alert("consent 1");
			document.forms[0].strConsentReq.value="1";
		}
		else
		{
		// alert(" consent 0");
			document.forms[0].strConsentReq.value="0";
		}
	}
	function setBatchNo()
	{
		if(document.forms[0].strBatchNo.checked)
		{
			document.forms[0].strBatchNo.value="1";
		}
		else
		{
			document.forms[0].strBatchNo.value="0";
		}
	}
	function setExpiryDate()
	{
		if(document.forms[0].strExpiryDate.checked)
		{
			document.forms[0].strExpiryDate.value="1";
		}
		else
		{
			document.forms[0].strExpiryDate.value="0";
		}
		
	}
	function setIsItemNarcotic()
	{
		if(document.forms[0].strIsItemNarcotic.checked)
		{
			document.forms[0].strIsItemNarcotic.value="1";
		}
		else
		{
			document.forms[0].strIsItemNarcotic.value="0";
		}
	}
	
	function validate()
	{
		     var hisValidator = new HISValidator("genericdrugBean");
		    hisValidator.addValidation("strDrugName", "req", "Drug Name is a Mandatory Field" );
		    
		    /*
	    		The following code is commented due to change request from Ajay Sir(Dec 2010).
				Generic Drug Code Should not be mandatory. 
	    	*/
		    /*
		    if(document.forms[0].strCPACode != null){
        	
     	   		hisValidator.addValidation("strCPACode", "req","Drug Code is a Mandatory Field");
     
    		 }
		    */
		     
		    
           hisValidator.addValidation("strPurchaseLeadTime", "req", "Purchase Lead Time is a Mandatory Field" );
            hisValidator.addValidation("strStockMaintain", "dontselect=0","Please Select Inventory Unit"); 
         hisValidator.addValidation("strShelfLife", "req", "Shelf Life Time is a Mandatory Field" );
            hisValidator.addValidation("strEffectiveFrom", "date","Effective Date is a mandatory field");
            
            if(document.getElementById("pregnancySafeFlag").checked!=1) {
         hisValidator.addValidation("strTrimester", "dontselect='NOT_SELECTED'","Please Select a Trimester.");
         hisValidator.addValidation("strEffectsOnFoetus", "req", "Effects on Foetus is a Mandatory Field" );
         hisValidator.addValidation("strEffectsOnFoetus", "maxlen=250", "Effects on Foetus cannot exceeds 250 characters." );
        }
        
        hisValidator.addValidation("strRemarks", "maxlen=100", "Remarks cannot exceeds 100 characters." );
            
            
            var retVal = hisValidator.validate();
            hisValidator.clearAllValidations();
      
            if(retVal)
		    {
		   		// alert("strConsentReq-"+document.forms[0].strConsentReq.value);
		   		document.forms[0].hmode.value="UPDATE";
		   		document.forms[0].submit();
		   }
	}

	function getDetails()
	{
	
		if(document.forms[0].strBatchNo.value==1)
		{
			document.forms[0].strBatchNo.checked=true;
		}
		if(document.forms[0].strExpiryDate.value==1)
		{
			document.forms[0].strExpiryDate.checked=true;
		}
		
		if(document.forms[0].strIsItemNarcotic.value==1)
		{
			document.forms[0].strIsItemNarcotic.checked=true;
		}
		if(document.forms[0].strConsentReq.value==1)
		{
			document.forms[0].strConsentReq.checked=true;
		}
		
	}
	function displayPregnancySafetyDetail(pregnancySafeFlagElement) {
	    //var pregnancySafetyDetail = document.getElementById("pregnancySafetyDetail");
	    var pregnancySafetyDetailTd1 = document.getElementById("pregnancySafetyDetailTd1");
	    var pregnancySafetyDetailTd2 = document.getElementById("pregnancySafetyDetailTd2");
	    var pregnancySafetyDetailTd3 = document.getElementById("pregnancySafetyDetailTd3");
	    var pregnancySafetyDetailTd4 = document.getElementById("pregnancySafetyDetailTd4");
		if(pregnancySafeFlagElement.checked==1) {
			//alert("Checked");
			//pregnancySafetyDetail.style.display="none";
			pregnancySafetyDetailTd1.style.display="none";
			pregnancySafetyDetailTd2.style.display="none";
			pregnancySafetyDetailTd3.style.display="none";
			pregnancySafetyDetailTd4.style.display="none";
		}else{
			//alert("Unchecked");
			//pregnancySafetyDetail.style.display="block";
			pregnancySafetyDetailTd1.style.display="block";
			pregnancySafetyDetailTd2.style.display="block";
			pregnancySafetyDetailTd3.style.display="block";
			pregnancySafetyDetailTd4.style.display="block";
		}
		//pregnancySafetyDetail.style.display="none";
	}
	function displayOnloadPregnancySafetyDetail() {
	    var pregnancySafeFlag = document.getElementById("pregnancySafeFlag");
		displayPregnancySafetyDetail(pregnancySafeFlag);
	}
</script>
</head>
<body onload="getDetails();displayOnloadPregnancySafetyDetail();">
<html:form action="/masters/GenericDrugMstCNT" name="genericdrugBean"
	type="mms.masters.controller.fb.GenericDrugMstFB">


	<center>
	<div class="errMsg" id="errMsgId"><bean:write
		name="genericdrugBean" property="strErrMssgstring" /></div>
	<div class="warningMsg" id="warningMsgId"><bean:write
		name="genericdrugBean" property="strWarnMssgstring" /></div>
	<div class="normalMsg" id="normalMsgId"><bean:write
		name="genericdrugBean" property="strNormMssgstring" /></div>
	<tag:tab tabLabel="Generic Drug Master" selectedTab="FIRST"
		align="center" width="TABLEWIDTH" onlyTabIndexing="1">

	</tag:tab></center>

	<table class="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4" width="25%">Generic Drug Master&gt;&gt; Modify</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Group Name</td>
			<td class="CONTROL"><bean:write name="genericdrugBean"
				property="strGroupNameValue" filter="false" /></td>
			<td width="25%" class="LABEL">Sub Group Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="genericdrugBean" property="strSubGroupNameValue"
				filter="false" /></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">Consumable Type</td>
			<td class="CONTROL" width="25%"><html:select
				property="strConsumableType" name="genericdrugBean">
				<html:option value="1"> Consumable</html:option>

			</html:select></td>
			<td width="25%" class="LABEL"><font color="red">*</font>Generic
			Drug Name</td>
			<td width="25%" class="CONTROL"><input type="text"
				name="strDrugName" maxlength="100" class="txtFldMax" onkeyup="lTrim(this);"
				onkeypress="return validateDataWithSpecialChars(event,18,'%.:;+-/*,');"
				value="${genericdrugBean.strDrugName}" /></td>
		</tr>
	</table>
	<%--
			The following code is commented due to change request from Ajay Sir(Dec 2010).
			There should not be any binding with system table's Item Code Required Property. 
		--%>
	<%--
		
		<logic:equal value="1" name="genericdrugBean" property="strIsItemCodeRequired" >
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
			<td width="25%" colspan="2" class="LABEL"><font color="red">*</font>Generic Drug Code</td>
			<td width="25%" class="CONTROL" colspan="2"><input type="text"
				name="strCPACode" maxlength="6" class="txtFldNormal"
				onkeypress="return validateData(event,9);" value="${genericdrugBean.strCPACode}" /></td>
		</tr>
		</table>
		</logic:equal>
		 
		--%>

	<table class="TABLEWIDTH" align="center" cellspacing="1px"	cellpadding="1px" style="display: none;">
		<%--
		Generic Drug Code cannot be modified. Because, if a generic drug code is
		GO1, an drug code of this generic drug should start with GO1, followed
		by a '.'.Example: G01.D123. If we change G01 to L12 or whatever else, 
		it will not be reflected in drug code. 
		 --%>
		<tr>
			<td width="25%" colspan="2" class="LABEL">Generic Drug Code</td>
			<td width="25%" class="CONTROL" colspan="2"><input type="text"
				name="strCPACode" maxlength="6" class="txtFldNormal" onkeyup="lTrim(this);"
				onkeypress="return validateData(event,9);"
				value="${genericdrugBean.strCPACode}" readonly="readonly" /></td>
		</tr>
	</table>


	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<tr>
			<td class="LABEL" colspan="1" width="25%">Consent Required</td>
			<td class="CONTROL" colspan="1" width="25%"><input
				type="checkbox" name="strConsentReq"
				value="${genericdrugBean.strConsentReq}" onclick="setConsentReq();">

			</td>
			<td class="LABEL" colspan="1" width="25%">Whether Drug is
			Narcotic Drug</td>
			<td class="CONTROL" colspan="" width="25%"><input
				type="checkbox" name="strIsItemNarcotic"
				value="${genericdrugBean.strIsItemNarcotic}"
				onclick="setIsItemNarcotic();"></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="1" rowspan="2" width="25%"
				style="vertical-align: top"><div style='display:none;'>Whether safe during pregnancy</div></td>
			<td class="CONTROL" colspan="1" rowspan="2"
				style="vertical-align: top"><div style='display:none;'><html:checkbox
				property="strPregnancySafeFlag"
				onclick="displayPregnancySafetyDetail(this);" name="genericdrugBean"
				styleId="pregnancySafeFlag"></html:checkbox></div></td>
			<td class="LABEL" style="text-align: right; vertical-align: top">
			<div class="LABEL" style="text-align: right; vertical-align: top"
				id="pregnancySafetyDetailTd1"><font color="red">*</font>Trimester</div>
			</td>
			<td class="CONTROL" style="text-align: left; vertical-align: top">
			<div class="CONTROL" style="text-align: left; vertical-align: top"
				id="pregnancySafetyDetailTd2"><html:select
				property="strTrimester" name="genericdrugBean">
				<html:option value="NOT_SELECTED"><-- Trimester --></html:option>
				<html:option value="0">All</html:option>
				<html:option value="1">First</html:option>
				<html:option value="2">Second</html:option>
				<html:option value="3">Third</html:option>
			</html:select></div>
			</td>
		</tr>
		<tr>
			<td class="LABEL" style="text-align: right; vertical-align: top">
			<div class="LABEL" style="text-align: right; vertical-align: top"
				id="pregnancySafetyDetailTd3"><font color="red">*</font>Effects
			on foetus</div>
			</td>
			<td class="CONTROL" style="text-align: left; vertical-align: top">
			<div class="CONTROL" style="text-align: left; vertical-align: top"
				id="pregnancySafetyDetailTd4"><html:textarea onkeyup="lTrim(this);"
				property="strEffectsOnFoetus" name="genericdrugBean"></html:textarea></div>

			</td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellspacing="1px" style="display: none;">
		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="itemManagePlusId" align="left" style="display: none;">
			<img src="../../hisglobal/images/plus.gif"
				onClick="view1('itemManagePlusId','itemManageMinusId','itemManageDtlId');"
				style="cursor: pointer;" /> Drug Managed By</div>
			<div id="itemManageMinusId" style="display: block;" align="left">
			<img src="../../hisglobal/images/minus.gif"
				onClick="view2('itemManagePlusId','itemManageMinusId','itemManageDtlId');"
				style="cursor: pointer;" /> Drug Managed By</div>
			</td>
		</tr>
	</table>
	<div id="itemManageDtlId" style="display: block">
	<table class="TABLEWIDTH" align="center" cellspacing="1px"	cellpadding="0px" style="display: none;">
		<tr>
			<td class="LABEL" colspan="1" width="25%">Batch No.</td>
			<td class="CONTROL" colspan="" width="25%">
			<input type="checkbox" name="strBatchNo" value="${genericdrugBean.strBatchNo}" onclick="setBatchNo();">
			</td>
			<td class="LABEL" width="25%">Expiry Date</td>
			<td class="CONTROL" width="25%">
			<input type="checkbox"	name="strExpiryDate" value="${genericdrugBean.strExpiryDate}" onclick="setExpiryDate();"></td>

		</tr>

	</table>

	</div>
	<table class="TABLEWIDTH" align="center" cellspacing="1px"	cellpadding="0px">
		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="purchasePlusId" align="left" style="display: none;">
			<img src="../../hisglobal/images/plus.gif"	onClick="view1('purchasePlusId','purchaseMinusId','purchaseId');"	style="cursor: pointer;" /> Purchase/Inventory</div>
			<div id="purchaseMinusId" style="display: block;" align="left">
			<img src="../../hisglobal/images/minus.gif"	onClick="view2('purchasePlusId','purchaseMinusId','purchaseId');" style="cursor: pointer;" /> Purchase/Inventory
			</div>
			</td>
		</tr>
	</table>
	<div id="purchaseId" style="display: block">
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="0px">
		<tr>
			<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>Purchase
			Lead Time</td>
			<td class="CONTROL" colspan="" width="25%"><input type="text"
				name="strPurchaseLeadTime" maxlength="3" class="txtFldMin"
				onkeypress="return validateData(event,5);"
				value="${genericdrugBean.strPurchaseLeadTime}" /></td>
			<td class="LABEL" colspan="1" width="25%">Time Format</td>
			<td class="CONTROL" colspan="1" width="25%"><html:select
				property="strTimeFormat" name="genericdrugBean">
				<html:option value="1"> Day</html:option>
				<html:option value="2"> Month</html:option>
			</html:select></td>

		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>Drug
			Inventory Unit</td>
			<td class="CONTROL" colspan="" width="25%">&nbsp; <bean:write
				name="genericdrugBean" property="strInventoryUnitName"
				filter="false" /></td>
			<td class="LABEL" colspan="3" width="25%"></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>Shelf
			Life</td>
			<td class="CONTROL" colspan="" width="25%"><input type="text"
				name="strShelfLife" maxlength="3" class="txtFldMin"
				onkeypress="return validateData(event,5);"
				value="${genericdrugBean.strShelfLife}" /></td>
			<td class="LABEL" colspan="1" width="25%">Time Format</td>
			<td class="CONTROL" colspan="1" width="25%"><html:select
				property="strShelfTimeFormat" name="genericdrugBean">
				<html:option value="1"> Day</html:option>
				<html:option value="2"> Month</html:option>
				<html:option value="3"> Year</html:option>
			</html:select></td>
		</tr>

	</table>
	</div>


	<table cellspacing="1px" class="TABLEWIDTH" align="center">
		<tr>
			<td class="LABEL" width="25%">Remarks</td>
			<td class="CONTROL" width="25%" colspan=""><textarea rows="2" onkeyup="lTrim(this);"
				cols="20" name="strRemarks"><bean:write
				name="genericdrugBean" property="strRemarks" filter="false" /></textarea></td>
			
			<td class="LABEL" width="25%" style="display : none;"><font color="red">*</font>Effective
			From</td>
			<td class="CONTROL" width="25%" style="display : none;"><bean:write name="genericdrugBean" property="strEffectiveFrom"/>
			</td>
		</tr>
		<tr>
			<td class="LABEL">Record Status</td>
			<td class="CONTROL"><html:radio name="genericdrugBean"
				property="strIsValid" value="1">Active</html:radio> <html:radio
				name="genericdrugBean" property="strIsValid" value="2">Inactive</html:radio>
			</td>
			<td class="LABEL" colspan="2"></td>
		</tr>
	</table>
	<table cellspacing="1px" class="TABLEWIDTH" align="center">
		<tr class="FOOTER">
			<td colspan="4" width="25%"><font size="2" color="red">*</font>
			Mandatory Fields</td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellspacing="1px">

		<tr>
	<br>
			<td align="center" colspan="2" width="25%">
			<!-- <img
				src="../../hisglobal/images/btn-sv.png" title="Save Record"
				onClick="validate();" style="cursor: pointer;" /> <img
				src="../../hisglobal/images/btn-ccl.png" title="Cancel Process"
				onClick="cancel('LIST');" style="cursor: pointer;">-->
					<a href="#" class="button" id="" onclick='validate();'><span class="save">Save</span></a>
					<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
				</td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" value="${genericdrugBean.strCurrentDate}"
		name="strCurrentDate" />
	<input type="hidden" value="${genericdrugBean.strGroupId}"
		name="strGroupId" />
	<input type="hidden" value="${genericdrugBean.strSubGroupId}"
		name="strSubGroupId" />
	<input type="hidden" value="${genericdrugBean.strChk}" name="strChk" />

	<input type="hidden" value="${genericdrugBean.strIsItemCodeRequired}"
		name="strIsItemCodeRequired" />
	<input type="hidden" name="strEffectiveFrom" value="${genericdrugBean.strEffectiveFrom}">
	<input type="hidden" name="strStockMaintainedCode" value="${genericdrugBean.strStockMaintainedCode}">

	<cmbPers:cmbPers />


</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>
