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
<title>View Drug Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="/HIS/hisglobal/css/jquery.qtip.min.css" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="/HIS/hisglobal/css/jquery-ui.css">
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>

<script type="text/javascript">
	function chkItemSachet() 
	{

		if (document.getElementsByName('strIsItemSachet')[0].value == 1) {

			document.getElementsByName('strIsItemSachet')[0].checked = true;

		}

		if (document.getElementsByName('strIsQuantifiable')[0].value == 1) {

			document.getElementsByName('strIsQuantifiable')[0].checked = true;

		}

	}
	function chkDiv()
	{
			if(document.forms[0].strConfigIssueRate.value>'0')
			{
			   document.getElementById("issueRate").style.display="block";
			}
			else
			{
			   document.getElementById("issueRate").style.display="none";
			}
	
	}
</script>
<%--
	function setIsItemSachet()
	{
		
		if(document.forms[0].strIsItemSachet.checked)
		{
			document.forms[0].strIsItemSachet.value="1";
		}
		else
		{
			document.forms[0].strIsItemSachet.value="0";
		}
		
	} 
		
	function setIsQuantifiable()
	{
		if(document.forms[0].strIsQuantifiable.checked)
		{
			document.forms[0].strIsQuantifiable.value="1";
		}
		else
		{
			document.forms[0].strIsQuantifiable.value="0";
		}
	}
	
	
	function drugView()
	{
		
		   		document.forms[0].hmode.value="VIEW";
		   		document.forms[0].submit();
		  
	}
	

	function clearRecord()
	{
		
		document.forms[0].strAddress.value="";
		document.forms[0].strSupplierName.value="";
		document.forms[0].strContactPerson.value="";
		document.forms[0].strCity.value="";
		document.forms[0].strPincode.value="";
		document.forms[0].strPhoneNo1.value="";
		document.forms[0].strPhoneNo2.value="";
		document.forms[0].strEmailId1.value="";
		document.forms[0].strEmailId2.value="";
		document.forms[0].strFaxNo1.value="";
		document.forms[0].strFaxNo2.value="";
		document.forms[0].strWebsite.value="";
		document.forms[0].strOrderNo.value="";
		document.forms[0].strBlackListedRemarks.value="";
		document.forms[0].strRemarks.value="";
		document.getElementById("errMsgId").innerHTML="";
		document.getElementById("warningMsgId").innerHTML="";
		document.getElementById("normalMsgId").innerHTML="";
		document.forms[0].strSupplierName.focus();
		
	}
	--%>



</head>
<body>

<html:form action="/masters/DrugMstCNT" name="drugBean"
	type="mms.masters.controller.fb.DrugMstFB">

	<center>
	<div class="errMsg" id="errMsg"><bean:write name="drugBean"
		property="strErrMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="drugBean" property="strWarningMsg" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="drugBean"
		property="strNormalMsg" /></div>

	<tag:tab tabLabel="Drug Master" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">

	</tag:tab></center>
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<tr class="HEADER">
			<td colspan="4">Drug Master &gt;&gt; Modify</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Category</td>
			<td width="25%" class="CONTROL">Drug Category</td>


			<td width="25%" class="LABEL">Group Name</td>
			<td width="25%" class="CONTROL"><bean:write name="drugBean"
				property="strGroupName" filter="false" /></td>

		</tr>

		<tr>
			<td width="25%" class="LABEL">Generic Drug Name</td>
			<td width="25%" class="CONTROL"><bean:write name="drugBean"
				property="strGenericItemName" filter="false" /></td>


			<td width="25%" class="LABEL">Drug Code</td>
			<td width="25%" class="CONTROL"><bean:write name="drugBean"
				property="strCPACode" filter="false" /></td>

		</tr>
		<tr>
			<td colspan="1" width="25%" class="LABEL">Record Status</td>
			<td colspan="3" width="75%" class="CONTROL"><bean:write
				name="drugBean" property="strDrugType" filter="false" /></td>
		</tr>
		<tr>
			<td colspan="1" width="25%" class="LABEL">Drug Type</td>
			<td colspan="1" width="25%" class="CONTROL"><bean:write
				name="drugBean" property="strItemType" filter="false" /></td>
			<td colspan="1" width="25%" class="LABEL">Drug Name</td>
			<td colspan="1" width="25%" class="CONTROL"><bean:write
				name="drugBean" property="strDrugName" filter="false" /></td>
		</tr>
		<tr>
			<td colspan="1" width="25%" class="LABEL">Manufacturer</td>
			<td colspan="3" width="25%" class="CONTROL"><bean:write
				name="drugBean" property="strManufacturer" filter="false" /></td>
		</tr>

		<tr>
			<td colspan="1" width="25%" class="LABEL">Default Rate</td>
			<td colspan="1" width="25%" class="CONTROL"><bean:write
				name="drugBean" property="strDefaultRate" filter="false" /></td>
			<td colspan="1" width="25%" class="LABEL">Rate/Unit</td>
			<td colspan="1" width="25%" class="CONTROL"><bean:write
				name="drugBean" property="strUnit" filter="false" /></td>
		</tr>


	</table>




	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="0px">


		<tr>
			<td colspan="4" class="TITLE" width="25%">Drug Parameter</td>
		</tr>


		<tr>
			<td class="LABEL" colspan="1" width="25%">Approved Type</td>
			<td class="CONTROL" colspan="1" width="25%"><bean:write
				name="drugBean" property="strApprovedTypeName" filter="false" /></td>
				
			<td class="LABEL" colspan="1" width="25%">Drug Make</td>
			<td class="CONTROL" width="25%" colspan="1">
				<bean:write name="drugBean" property="strItemMake" filter="false" />
			</td>	
			
			<td class="LABEL" colspan="1" width="25%" style="display:none;">Issue Type</td>
			<td class="CONTROL" colspan="1" width="25%"  style="display:none;">
			<bean:write name="drugBean" property="strIssueType" filter="false" /></td>
		</tr>
		<tr style="display:none;">
			<td class="LABEL" colspan="1" width="25%" style="display:none;">Drug Make</td>
			<td class="CONTROL" width="25%" colspan="1" >
				<bean:write name="drugBean" property="strItemMake" filter="false" />
			</td>
			
			<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>QC Type</td>
			<td class="CONTROL" width="25%" colspan="1">
				<bean:write name="drugBean" property="strQCType" filter="false" /> 
			
			</td>

		</tr>
		<tr style="display:none;">
			<td class="LABEL" colspan="1" width="25%">Whether Drug is Sachet</td>
			<td class="CONTROL" colspan="1" width="25%"><bean:write
				name="drugBean" property="strIsItemSachet" filter="false" /></td>
			<td class="LABEL" colspan="1" width="25%">Whether Drug is Quantifiable</td>
			<td class="CONTROL" colspan="1" width="25%"><bean:write
				name="drugBean" property="strIsQuantifiable" filter="false" /></td>
		</tr>

	</table>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="0px">
			<tr>
			   <td class="LABEL" width="25%" colspan="1">Issue Rate</td>
			    <td class="CONTROL" width="75%" colspan="3">
			   <bean:write	name="drugBean" property="strConfigIssueRate" filter="false" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>% of Purchase Rate</b>
			  
			 </td>  	
			</tr>		
			
			<tr>
					<td class="LABEL" width="25%" colspan="1" >Market Price</td>
				    <td class="CONTROL" width="75%" colspan="3" >			  
				    	<bean:write	name="drugBean" property="strMktRate" filter="false" /><b>	/</b><bean:write name="drugBean" property="strMktRateUnitId" filter="false" />			    					  
				 	</td>  
			</tr>	
	</table>

	
	<table cellspacing="1px" cellpadding="1px" class="TABLEWIDTH"
		align="center">
		<tr>
			<td class="LABEL" colspan="1" width="25%">Specification</td>
			<td class="CONTROL" width="25%" colspan="3"><bean:write
				name="drugBean" property="strSpecification" filter="false" /></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">EDL/Life Saving Drugs	</td>
			<td class="CONTROL" width="25%" colspan="3"><bean:write
				name="drugBean" property="strEdlCat" filter="false" /></td>
		</tr>
		<tr style="display :none;">
			<td class="LABEL" colspan="2" width="25%">Effective From</td>
			<td class="CONTROL" width="25%" colspan="2"><bean:write
				name="drugBean" property="strEffectiveFrom" filter="false" /></td>
		</tr>

		<tr>
			<td colspan="2" width="45%" class="LABEL">Record Status</td>
			<td colspan="2" width="45%" class="CONTROL"><logic:equal
				name="drugBean" property="strIsValid" value="1">Active</logic:equal>
			<logic:equal name="drugBean" property="strIsValid" value="2">In Active</logic:equal>

			</td>
		</tr>

	</table>
	<table cellspacing="1px" cellpadding="1px" class="TABLEWIDTH"
		align="center">
		<tr class="FOOTER">
			<td colspan="4" width="25%"><font size="2" color="red"></font></td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">

		<tr>

			<td align="center" colspan="2" width="25%"><img
				src="../../hisglobal/images/close_tab.png" onClick="window.close();"
				style="cursor: pointer;" title="Cancel Process"></td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" value="${drugBean.strCurrentDate}"
		name="strCurrentDate" />
	<input type="hidden" value="${drugBean.strGroupId}" name="strGroupId" />
	<input type="hidden" value="${drugBean.strTempCmbValue}"
		name="comboValue" />
	<input type="hidden" value="${drugBean.strGenericItemId}"
		name="strGenericItemId" />
	<input type="hidden" value="${drugBean.strDrugName}" name="strDrugName" />
	<input type="hidden" value="${drugBean.strGroupName}"
		name="strGroupName" />
	<input type="hidden" value="${drugBean.strGenericItemName}"
		name="strGenericItemName" />
	<input type="hidden" value="${drugBean.strChk}" name="chk" />
	<cmbPers:cmbPers />

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>