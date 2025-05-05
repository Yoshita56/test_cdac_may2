<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>

<!-- 
/**
 * Developer : Tanvi Sappal
 * Version : 1.0
 * Date : 17/June/2009
*/
-->
<html>
<head><meta charset=UTF-8">
<title>Return Process</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/returnFromEmployee_mmsTrans.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script type="text/javascript">

</script>
</head>


<body>
<html:form action="/transactions/ReturnFromEmployeeTransCNT.cnt" name="returnFromEmployeeBean" type="mms.transactions.controller.fb.ReturnFromEmployeeTransFB" method="post">
	<div class="errMsg" id="errMsg"><bean:write name="returnFromEmployeeBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="returnFromEmployeeBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="returnFromEmployeeBean" property="strMsg" /></div>

	
	<tag:tab tabLabel="Return From Employee" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab>
	<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
	<tr class="HEADER"> 
	 <td colspan="4">
    </td>
    </tr>
    </table>
	
	
	

		<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr>

			<td width="25%" class="LABEL"><font color="red">*</font>Store Name</td>
			<td width="25%" class="CONTROL"><select name="strStoreId" 
					id="strStoreId" class='comboNormal' onchange="itemCategoryCombo();">
				<bean:write name="returnFromEmployeeBean" property="strStoreNameCombo" filter="false" />
				<!--<option value="0">Select Value</option>-->
			</select></td>

			<td width="25%" class="LABEL"><font color="red">*</font>Item Category</td>
			<td width="25%" class="CONTROL">
				<div id="itemCategoryId" style="display:block;"><select name="strItemCategoryNo"
					id="strItemCategoryNo" class='comboNormal'>
				<bean:write name="returnFromEmployeeBean" property="strItemCategoryCombo" filter="false" />
				<!--<option value="0">Select Value</option>-->
			</select></div>	</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Employee No.</td>
			<td colspan="3" class="CONTROL">
				<input type="text" name="strEmpNo" maxlength="14" style="text-transform: uppercase" onkeyup="goFuncOnEnter(event);"> 
			<input type="image" style="cursor: pointer; " title="Return Process" align="top"
				src="../../hisglobal/images/Go.png" name="go" value="Go"
				onclick="return goFunc();" onkeyup="goFuncOnEnter(event);"></td>
		</tr>		
	</table>

	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">


		<tr class="FOOTER">
			<td colspan="2"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center">
		<tr>
			<td align="center">
			<img style="cursor: pointer; " title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="cancel();" />
			</td>
		</tr>
	</table>

	<input type="hidden" name="hmode" />
	<input type="hidden" name="storeName" value="${returnFromEmployeeBean.storeName}" />
	<input type="hidden" name="itemCatName" value="${returnFromEmployeeBean.itemCatName}" />
	<input type="hidden" name="empNo" value="${returnFromEmployeeBean.empNo}" />
	<input type="hidden" name="strId" value="${returnFromEmployeeBean.strId}" />
	<input type="hidden" name="strConfCatCode" value="${returnFromEmployeeBean.strConfCatCode}" />
	<input type="hidden" name="itemCategory" value="${returnFromEmployeeBean.itemCategory}" />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>

