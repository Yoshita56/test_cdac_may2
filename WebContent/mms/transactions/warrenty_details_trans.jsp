<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<meta charset=UTF-8">
<title>Warrenty Details</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="javaScript" src="../../mms/js/warrentydetails.js">
</script>
</head>
<body >
<html:form name="warrentyDetailsBean" action="/transactions/WarrentyDetailsTransCNT" type="mms.transactions.controller.fb.WarrentyDetailsTransFB">

	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="warrentyDetailsBean" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="warrentyDetailsBean" property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="warrentyDetailsBean" property="strMsg" /></div>
	
</center>
<html:hidden name="warrentyDetailsBean" property="strCtDate"/>
	<tag:tab tabLabel="Warrenty Details"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>

	<table class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="4">Warranty Details &gt;&gt;</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">
				<font color="red">*</font>Tender No
				</td>
			<td width="25%" class="CONTROL">
				<html:text name="warrentyDetailsBean" property="strTenderNo" maxlength="25" onkeypress="return validateData(event,8);" >       		
		       	</html:text>
			</td>
		
			<td width="25%" class="LABEL">
				<font color="red">*</font>Quotation No
			</td>
			<td width="25%" class="CONTROL">
				<html:text name="warrentyDetailsBean" property="strQuotationNo" maxlength="25" onkeypress="return validateData(event,8);" >       		
		       	</html:text>
			</td>
				
		</tr>
		<tr>
			<td width="25%" class="LABEL">
			<font color="red">*</font>	Po No
			</td>
			<td width="25%" class="CONTROL" >
				<html:text name="warrentyDetailsBean" property="strPoNo" maxlength="10" onkeypress="return validateData(event,5);" >       		
		       	</html:text>
			</td>
			<td width="25%" class="LABEL">
				<font color="red">*</font>Batch Serial No
			</td>
			<td width="25%" class="CONTROL" >
				<html:text name="warrentyDetailsBean" property="strBatchSlNo" maxlength="20" onkeypress="return validateData(event,8);" >       		
		       	</html:text>
			</td>	
		</tr>
		<tr>
			<td width="25%" class="LABEL">
				<font color="red">*</font>Supplier Manufacturer Name
			</td>
			<td width="25%" class="CONTROL">
				<html:select name="warrentyDetailsBean" property="strManufacturerID" >
	       		<bean:write name="warrentyDetailsBean" property="strManufacturerNameComboValues" filter="false"/>
	       		</html:select>
			</td>
				
		
			<td width="25%" class="LABEL">
				<font color="red">*</font>Drug Category
			</td>
			<td width="25%" class="CONTROL">
				<html:select name="warrentyDetailsBean" property="strItemCategoryID" onchange="getCombos('GROUPNAME');">
	       		<bean:write name="warrentyDetailsBean" property="strItemCategoryComboValues" filter="false"/>
	       		</html:select>
			</td>
		</tr>
		<tr>	
		
			<td width="25%" class="LABEL">
				<font color="red">*</font>Group name
			</td>
			<td width="25%" class="CONTROL">
			<div id="GroupId"><select name="strGroupID"
				onchange="getCombos('SUBGROUPNAME');">
				<option value="0">Select Value</option>
			</select></div>
				
			</td>
				
		
			<td width="25%" class="LABEL">
				Sub Group Name
			</td>
			<td width="25%" class="CONTROL">
			<div id="SubGroupId"><select name="strSubGroupID"
				onchange="getCombos('ITEMNAME');">
				<option value="0">Select Value</option>
			</select></div>
				
			</td>
		</tr>
		<tr>	
		
			<td width="25%" class="LABEL">
				<font color="red">*</font>Drug Name
			</td>
			<td width="25%" class="CONTROL">
			<div id="ItemId"><select name="strItemID"
				onchange="getCombos('BRANDNAME');">
				<option value="0">Select Value</option>
			</select></div>
				
			</td>
				
		
			<td width="25%" class="LABEL">
				<font color="red">*</font>Brand Name
			</td>
			<td width="25%" class="CONTROL">
			<div id="BrandId"><select name="strBrandID"
				>
				<option value="0">Select Value</option>
			</select></div>
				
			</td>
		</tr>
		<tr>		
		
			<td width="25%" class="LABEL">
				<font color="red">*</font>Warrenty Start Date
			</td>
			<td width="25%" class="CONTROL">
			<dateTag:date name="strWarrentyStartDate" value ="${warrentyDetailsBean.strCtDate}"></dateTag:date>
				
				
			</td>
				
		
			<td width="25%" class="LABEL">
				<font color="red">*</font>Warrenty UpTo
			</td>
			<td width="25%" class="CONTROL">
				<html:text name="warrentyDetailsBean" property="strWarrentyUpto" maxlength="3" size="4" onkeypress="return validateData(event,5);" >       		
		       	</html:text>
		       	<html:select name="warrentyDetailsBean" property="strWarrentyUnit" >
	       		<option value="1">Day</option>
	       		<option value="2">Month</option>
	       		<option value="3">Year</option>
	       		</html:select>
			</td>
		</tr>
		<tr>		
		
			<td width="25%" class="LABEL" >
			Remarks
			</td>
			<td width="25%" class="CONTROL">
			<html:textarea name="warrentyDetailsBean" property="strRemarks" cols="25" rows="2">
       		
       	  </html:textarea>
			</td>
			<td colspan="2" class="CONTROL" >
			<td>
		</tr>
		
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img 
				src="../../hisglobal/images/btn-sv.png" style="cursor:pointer;cursor:pointer;" title="Save Record" onClick="return validate1();" />
				<img src="../../hisglobal/images/btn-clr.png" style="cursor:pointer;cursor:pointer;" title="Clear Record" onClick="document.forms[0].reset();" >
			<img src="../../hisglobal/images/btn-ccl.png" style="cursor:pointer;cursor:pointer;" title="Cancel process" onClick="return cancelProcess();" >
			</td>
		</tr>
	</table>
<input type="hidden" name="hmode"/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>