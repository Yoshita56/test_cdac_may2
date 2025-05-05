<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>

<!-- 
/**
 * Developer : Kapil Khurana 
 * Version : 1.0 
 * Date : 07/April/2010
 * 
 */
-->
<html>
<head>
<meta charset=UTF-8">
<title>Installation Detail</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<script language="JavaScript" src="../js/installationTrans_mms.js">

	

</script>
</head>
<body onload="">
<html:form action="/transactions/InstallationTransCNT.cnt" name="installationTransBean" 
type="mms.transactions.controller.fb.InstallationTransFB" method="post" enctype="multipart/form-data">

	<center><div class="errMsg" id="errMsg"><bean:write name="installationTransBean" property="strErrorMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="installationTransBean" property="strWarningMsg" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="installationTransBean" property="strNormalMsg" /></div>
		
	<tag:tab tabLabel="Installation Detail" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab></center>
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
		<td colspan="4"></td>
	</tr>
	<tr class="TITLE" >
		<td align="right"><input name="strView" type="checkbox" value="1"
				onclick="diplayView();">View</td>
				
	</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">  
		<tr>
			<td colspan="1" width="25%" class="LABEL"><font color="red">*</font>Store Name</td>
			<td colspan="1" width="25%" class="CONTROL">
				<select name="strStoreId" class='comboNormal' onchange="getItemCatCmb();">
						<bean:write name="installationTransBean" property="strStoreValues" filter="false" />
						<option value="0">Select Value</option>
				</select>
			</td>
			<td colspan="1" width="25%" class="LABEL"><font color="red">*</font>Item Category</td>
			<td colspan="1" width="25%" class="CONTROL">
				<div id="itemCategoryId">
				<select name="strItemCatNo" class='comboNormal' onChange="getGroupCmb();">
					<bean:write name="installationTransBean" property="strCategoryValues" filter="false" />	
					
				</select></div>
			</td>
		</tr>
		
		<tr>
			<td colspan="1" width="25%" class="LABEL"><font color="red">*</font>Group Name</td>
			<td colspan="1" width="25%" class="CONTROL">
				<div id="groupId">
				<select name="strGroupId" class='comboNormal' onchange="getSubGroupCmb();">
					<bean:write name="installationTransBean" property="strGroupNameValues" filter="false" />
				</select></div>
			</td>
			<td colspan="1" width="25%" class="LABEL">Sub Group Name</td>
			<td colspan="1" width="25%" class="CONTROL">
				<div id="subGroupId">
				<select name="strSubGroupId" class='comboNormal' onChange="getGenItemCmb();">
						<option value="0">Select Value</option>
				</select></div>
			</td>
		</tr>
		
		<tr>
			<td colspan="1" width="25%" class="LABEL"><font color="red">*</font>Generic Item Name</td>
			<td colspan="1" width="25%" class="CONTROL">
				<div id="genItemId">
				<select name="strGenericItemId" class='comboNormal' onchange="getItemCmb();">
						<option value="0">Select Value</option>
				</select></div>
			</td>
			<td colspan="1" width="25%" class="LABEL"><font color="red">*</font>Item Name</td>
			<td colspan="1" width="25%" class="CONTROL">
				<div id="itemId">
				<select name="strItemBrandId" class='comboNormal' onChange="getBatchSerialNoCmb();">
						<option value="0">Select Value</option>
				</select></div>
			</td>
		</tr>
	</table>
	
	
	<div id="strBatchDivId" style="display: none;">
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">	
			<tr>
				<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Batch No.</td>
				<td width="50%" colspan="2" class="CONTROL" colspan="3">
					<div id="batchNoId"><select name="strBatchNo" class='comboNormal'>
							<option value="0">Select Value</option>
					</select></div>
				</td>
			</tr>
		</table>
	</div>
	
	<div id="strItemDivId" style="display: none;">
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">	
			<tr>
				<td width="50%" colspan="2" class="LABEL"><font color="red">*</font>Item Serial No.</td>
				<td width="50%" colspan="2" class="CONTROL" >
					<div id="itemSlNoId"><select name="strItemSlNo" class='comboNormal'>
							<option value="0">Select Value</option>
					</select></div>
				</td>
			</tr>
		</table>
	</div>
		
	<div id="stockPositionDivId" style="display: none;">
	
	
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			
			<tr class="HEADER">
				<td colspan="4">Stock Position</td>
			</tr>
			<tr>	
			    <td class="LABEL" colspan="1">Avl Qty</td>
			    <td class ="CONTROL" colspan="3">
			    <div id="avlQtyDivId"></div>
			</tr>
		    <tr>	    
			    <td class="LABEL" colspan="1">Last PO No</td>
			    <td colspan="1" class ="CONTROL">
			    <div id="poNoDivId"></div>  
			    <td class="LABEL" colspan="1">Last PO Date</td>
			    <td colspan="1" class ="CONTROL">
			    <div id="poDateDivId"></div>        
	  	   </tr>
		   <tr>
				<td class="LABEL" colspan="1">Supplied By</td>
			    <td class ="CONTROL" colspan="3">
			   <div id="suppliedByDivId"></div>
		   </tr>
			
	 	</table>
	
	
	
	
	<div id="installationDtlsDivId" style="display: none;">
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4">Installation Details</td>
			</tr>
			<tr>
				<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>Installation Start Date</td>
				<td width="25%" colspan="1" class ="CONTROL">
					<dateTag:date name="strInstallationStartDate" value="${installationTransBean.strCtDate}"/>
				</td>
				<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>Installation End Date</td>
				<td width="25%" colspan="1" class ="CONTROL">
					<dateTag:date name="strInstallationEndDate" value="${installationTransBean.strCtDate}"/>
				</td>
			</tr>
			
			<tr>
				<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>Installation By</td>
				<td width="25%" colspan="1" class ="CONTROL">
					<input class="txtFldMax" type="text" name="strInstallationBy" >
				</td>
				<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>Installator Contact No.</td>
				<td width="25%" colspan="1" class ="CONTROL">
					<input class="txtFldMax" type="text" name="strInstallatorContactNo" >
				</td>
			</tr>
			
			<tr>
				<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>Installation Status</td>
				<td width="25%" colspan="1" class ="CONTROL">
					<select name="strInstallationStatus" class='comboNormal'>
							<option value="0">Select Value</option>
							<option value="1">Success</option>
							<option value="2">Failure</option>
					</select>
				</td>
				<td class="LABEL" colspan="1" width="25%"><font color="red">*</font>Report By</td>
				<td width="25%" colspan="1" class ="CONTROL">
					<div id="reportById">
					<select name="strReportBy" class='comboNormal'>
							<option value="0">Select Value</option>
					</select></div>
				</td>
			</tr>
			
			<tr>
	         	<td class="LABEL" colspan="2" width="50%" >Remarks</td>
				<td class="CONTROL" colspan="2" width="50%" >
	        		<textarea name="strRemarks" rows="2"></textarea>
             	</td>
         	</tr>
		</table>
	 </div>

</div>


	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">	
	
	    <tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	
		<tr>
			<td colspan="4" align="center">
			<img style="cursor: pointer; " title="Save Record" src="../../hisglobal/images/btn-sv.png" onclick="return validate1();" /> 
			<img style="cursor: pointer; " title="Clear Content"  src="../../hisglobal/images/btn-clr.png" onClick="getClear();" />
            <img style="cursor: pointer; " title="Cancel Process" src="../../hisglobal/images/btn-ccl.png" onClick="cancel();" /></td>
		</tr>
		
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" name="strPONo" value="${installationTransBean.strPONo}"/>
<input type="hidden" name="strPODate" value="${installationTransBean.strPODate}"/>
<input type="hidden" name="strSupplierId" value="${installationTransBean.strSupplierId}"/>
<input type="hidden" name="strIsConsumable" value="${installationTransBean.strIsConsumable}"/>
<input type="hidden" name="strInhandQty" value="${installationTransBean.strInhandQty}"/>
<input type="hidden" name="strCtDate" value="${installationTransBean.strCtDate}"/>
<input type="hidden" name="displayFlag" value="${installationTransBean.displayFlag}"/>
</html:form>
<tag:autoIndex></tag:autoIndex>   
</body>
</html>