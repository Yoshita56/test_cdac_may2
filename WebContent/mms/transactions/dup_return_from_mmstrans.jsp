<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>

<!-- 
/**
 * Developer : Tanvi Sappal
 * Version : 1.0
 * Date : 23/Apr/2009
*/
-->
<html>
<head>
<title>Duplicate Return Voucher</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/dupreturnFrom_mmsTrans.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script type="text/javascript">

</script>
</head>


<body onload="document.forms[0].strCrNo.focus();itemCategoryCombo();">
<html:form action="/transactions/DupReturnFromTransCNT.cnt" name="dupreturnFromTransBean" type="mms.transactions.controller.fb.DupReturnFromTransFB" method="post">
	<div class="errMsg" id="errMsg"><bean:write name="dupreturnFromTransBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="dupreturnFromTransBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="dupreturnFromTransBean" property="strMsg" /></div>

	
	<logic:equal value="0" name="dupreturnFromTransBean" property="strMode" >
	<tag:tab tabLabel="Return From Patient" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab>
	<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
	<tr class="HEADER"> 
	 <td colspan="4">Duplicate Return Voucher&gt;&gt;
    </td>
    </tr>
    </table>
    </logic:equal>
    
    <logic:equal value="1" name="dupreturnFromTransBean" property="strMode" >
	<tag:tab tabLabel="Return From Staff" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab>
	<table class="TABLEWIDTH" align="center" border="1" cellspacing ="1px">
	<tr class="HEADER"> 
	 <td colspan="4">Duplicate Return Voucher&gt;&gt;
    </td>
    </tr>
    </table>
    </logic:equal>
    
    <logic:equal value="2" name="dupreturnFromTransBean" property="strMode" >
	<tag:tab tabLabel="Duplicate Return Voucher" selectedTab="FIRST" align="center"
		width="TABLEWIDTH">
	</tag:tab>
	<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
	<tr class="HEADER"> 
	 <td colspan="4">Duplicate Return Voucher&gt;&gt;
    </td>
    </tr>
    </table>
    </logic:equal>


		<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr>

			<td width="25%" class="LABEL"><font color="red">*</font>Store Name</td>
			<td width="25%" class="CONTROL"><select name="strStoreId" onchange="itemCategoryCombo()" 
					id="strStoreId" class='comboMax'>
				<bean:write name="dupreturnFromTransBean" property="strStoreNameCombo" filter="false" />
				<option value="0">Select Value</option>
			</select></td>

			<td width="25%" class="LABEL"><font color="red">*</font>Item Category</td>
			<td width="25%" class="CONTROL">
				<select name="strItemCategoryNo"
					id="strItemCategoryNo" class='comboMax'>
				<option value="0">Select Value</option>
			</select></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>CR No.</td>
			<td colspan="1" class="CONTROL">
			<crNo:crNo value="${dupreturnFromTransBean.strCrNo}" js=" onkeypress='return initGoFunc(event);'"></crNo:crNo></td><td colspan='2' class='CONTROL'>
			<!-- <input type="image" style="cursor: pointer; " title="Return Process" align="top"
				src="../../hisglobal/images/GO_Green.png" name="go" value="Go" onclick="return goFunc();" onkeyup="goFuncOnEnter(event);"> -->
			<div align='left'><a  href="#" class="button" id="go" onclick="return goFunc();" onkeyup="goFuncOnEnter(event);"></a></div>
				</td>
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
			<br>
			<!-- <img style="cursor: pointer; " title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="cancel();" /> -->
			<a href="#" class="button" onclick="window.parent.closeTab();"><span class="cancel">Cancel</span></a>
			</td>
		</tr>
	</table>
	
<!-- 	<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="popUpDiv" style="display:none;">

<table bgcolor="white">

<tr>

<td>

 <div id="issueDtlsDivId" style="display:block;"></div>

</td>

</tr>

</table>

</div> -->

	<input type="hidden" name="hmode" />
	<input type="hidden" name="storeName" value="${dupreturnFromTransBean.storeName}" />
	<input type="hidden" name="itemCatName" value="${dupreturnFromTransBean.itemCatName}" />
	<input type="hidden" name="crNo" value="${dupreturnFromTransBean.crNo}" />
	<input type="hidden" name="strId" value="${dupreturnFromTransBean.strId}" />
	<input type="hidden" name="strConfCatCode" value="${dupreturnFromTransBean.strConfCatCode}" />
	<input type="hidden" name="itemCategory" value="${dupreturnFromTransBean.itemCategory}" />
	<input type="hidden" name="strMode"   value="${dupreturnFromTransBean.strMode}">
	<input type="hidden" name="strIssueMode"   value="${dupreturnFromTransBean.strIssueMode}">
	<input type="hidden" name="strReturnDrugValidity"   value="${dupreturnFromTransBean.strReturnDrugValidity}">
	<input type="hidden" name="strReturnNo" value="${dupreturnFromTransBean.strReturnNo}"/>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>

