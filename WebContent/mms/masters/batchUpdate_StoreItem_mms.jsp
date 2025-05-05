<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<meta charset=utf-8>
<title>Store Item Master</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>

</head>
<body >
<html:form name="StoreItemBean" action="/masters/StoreItemMstCNT"
	type="mms.masters.controller.fb.StoreItemMstFB">

	<div class="errMsg"><bean:write name="StoreItemBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="StoreItemBean"
		property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="StoreItemBean"
		property="strMsg" /></div>
	

<tag:tab tabLabel="Store Item Master" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab>
	
	
	

	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="2">Store Item Master&gt;&gt; Batch Update</td>
		</tr>
		<tr>
			<td class="LABEL">Drug Warehouse Name</td>
			<td width="50%" class="CONTROL"><bean:write
				name="StoreItemBean" property="strStoreName" filter="false" />

			</td>

		</tr>
		<tr>
				<td class="LABEL"><font color="red">*</font>From Store</td>
			<td width="50%" class="CONTROL"><html:select name="StoreItemBean"
				property="strFromStoreId" >
				<bean:write name="StoreItemBean" property="strStoreCombo"
					filter="false" />
			</html:select></td>
		</tr>
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
		<td class="LABEL" width="25%"><font color="red">*</font>Forecast</td>
		<td class="CONTROL" width="25%"><input type="text"	class="txtFldNormal" name="strForeCast" maxlength="3" value="" onkeypress="return validateData(event,7);">
			<b>% </b></td>
			<td class="CONTROL" width="25%"><select
				name="strMoreOrLess1" class="comboMin">
				<option value="1">More</option>
				<option value="2">Less</option>
			</select>  <b>    of </b></td>
			<td  class="LABEL" width="25%"><div align="left"><bean:write
				name="StoreItemBean" property="strStoreName" filter="false" /></div>

			</td>
		</tr>
		
		<tr>
		<td class="LABEL"><font color="red">*</font>Reserved Qty</td>
		<td class="CONTROL"><input type="text" class="txtFldNormal"	name="strReservedQty" maxlength="3" value="" onkeypress="return validateData(event,7);">
			<b>% </b></td>
			<td class="CONTROL"><select
				name="strMoreOrLess2" class="comboMin">
				<option value="1">More</option>
				<option value="2">Less</option>
			</select>  <b>    of </b></td>
			<td  class="LABEL"><div align="left"><bean:write
				name="StoreItemBean" property="strStoreName" filter="false" /></div>

			</td>
		</tr>
		<!--  <tr>
		<td class="LABEL"><font color="red">*</font>MinQty</td>
		<td class="CONTROL"><input type="text"	class="txtFldNormal" name="strForeCast" maxlength="3" value="" onkeypress="return validateData(event,7);">
			<b>% </b></td>
			<td class="CONTROL"><select
				name="strMoreOrLess3" class="comboMin">
				<option value="1">More</option>
				<option value="2">Less</option>
			</select>  <b>    of </b></td>
			<td  class="LABEL"><div align="left"><bean:write
				name="StoreItemBean" property="strStoreName" filter="false" /></div>

			</td>
		</tr>-->
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td width="25%" class="LABEL">
			Is Issueable
			</td>
			<td width="25%" class="CONTROL">
			<input name="strIssueableFlag" type="checkbox" value="1"  >
			
			</td>
			<td width="25%" class="LABEL">
			Is Returnable
			</td>
			<td width="25%" class="CONTROL">
			<input name="strIsReturnable" type="checkbox" value="1"  >
			
			</td>
			</tr>
			
		<tr>
			<td class="LABEL" width="50%" colspan="2">
			<div align="right"><font
				color="red">*</font>Effective From</div>
			</td>
			<td class="CONTROL" colspan="2"><dateTag:date name="strEffectiveFrom"
				value="${StoreItemBean.strCtDate}"></dateTag:date></td>
		</tr>


		<tr>
			<td width="50%" class="LABEL" valign="top" colspan="2">Remarks if Any</td>
			<td width="50%" class="CONTROL" colspan="2"><textarea name="strRemarks"
				cols="25" rows="2"></textarea></td>
		</tr>
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<!-- <table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer; "
src="../../hisglobal/images/btn-sv.png"
onClick=" return validate1();" /> <img
style="cursor: pointer; "
src="../../hisglobal/images/btn-clr.png"
onClick="document.forms[0].reset();" />
<img style="cursor: pointer; "
src="../../hisglobal/images/btn-ccl.png" onClick="cancel('LIST');" />
			
			</td>
		</tr>
	</table>-->
<br>
<div align="center" id="saveId">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="document.forms[0].reset();"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancel('LIST');"><span class="cancel">Cancel</span></a>
				</div>
<input type="hidden" name="hmode"/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>