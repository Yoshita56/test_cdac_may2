<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<html>
<head>
<meta charset="utf-8">
<title>Generic Item Master View Page</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../js/itemparameterdetails_util.js"></script>
<script type="text/javascript">
	var flag=false;
	
	
	function closeView()
	{
		window.close();
	}
	function checkForPopup(these){
		showPopup(these , '3' , document.forms[0].strCatNo.value , document.forms[0].strItemID.value);
		
	}
	function showParamButton(){
	
		if(document.forms[0].strParamFlag.value=="Yes") 
			document.getElementById("modifyParamShow").style.display="block";
	}
	
</script>
</head>
<body onload="showParamButton();">
<html:form action="/masters/GenericItemMstCNT" name="genericitemBean" type="mms.masters.controller.fb.GenericItemMstFB">
	

	<center>
	<div class="errMsg" id="errMsgId"><bean:write name="genericitemBean" property="strErrMssgstring"/></div>
	<div class="warningMsg" id="warningMsgId"><bean:write name="genericitemBean" property="strWarnMssgstring"/></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="genericitemBean" property="strNormMssgstring"/></div>
	<tag:tab tabLabel="Generic Item Master" selectedTab="FIRST" align="center" width="TABLEWIDTH">
		
	</tag:tab>
	</center>

	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
		<td colspan="4" width="25%">Generic Item Master&gt;&gt; view</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">
			Group Name
			</td>
			<td class="CONTROL">
				<bean:write name="genericitemBean" property="strGroupNameValue" filter="false"/>
			</td>
			<td width="25%" class="LABEL">
				Sub Group Name
			</td>
			<td width="25%" class="CONTROL">
				<bean:write name="genericitemBean" property="strSubGroupNameValue" filter="false"/>
			</td>
		</tr>
		<tr>
			
			<td width="25%" class="LABEL">
			Generic Item Name
			</td>
			<td width="25%" class="CONTROL" colspan="">
				<bean:write name="genericitemBean" property="strItemName" filter="false"/>
				
			</td>
			<td width="25%" class="LABEL">
			Item Category
			</td>
			<td class="CONTROL" width="25%">
				<bean:write name="genericitemBean" property="strCatValues" filter="false"/>
			</td>
		</tr>
		<tr>
		<td class="LABEL" colspan="1" width="25%">
			Consumable Type
			</td>
			<td class="CONTROL" colspan="3" width="">
				<bean:write name="genericitemBean" property="strConsumableType" filter="false"/>
				
				
			</td>
		</tr>
		<logic:equal value="0" name="genericitemBean" property="strConsumableFlag" >
		<tr>
		<td class="LABEL" >
			Is Asset
			</td>
			<td class="CONTROL">
				<bean:write name="genericitemBean" property="strAssetsReq"/>
				
				
			</td>
			<td class="LABEL" >
			Depriciation Cost
			</td>
			<td class="CONTROL">
				<bean:write name="genericitemBean" property="strDepreciationcost"/>&nbsp;%
				
				
			</td>
		</tr>
		</logic:equal>
					
	</table>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">		
				<tr>
				  <td  colspan="4" class="TITLE" width="25%">
				<div id="itemManagePlusId" align="left" style="display:none;">
					Item Managed By
					</div>
					<div id="itemManageMinusId" style="display:block;" align="left">
						
								Item Managed By
					</div>
					</td>
				</tr>
	</table>
	<div id="itemManageDtlId" style="display: block">
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
			<td class="LABEL" colspan="1" width="25%">
				Batch No.
			</td>
			<td class="CONTROL" colspan="" width="25%">
				<bean:write name="genericitemBean" property="strBatchNo" filter="false"/>
			</td>
			<td class="LABEL" width="25%">
				Expiry Date
			</td>
			<td class="CONTROL" width="25%">
				<bean:write name="genericitemBean" property="strExpiryDate" filter="false"/>
			</td>
			
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">
				Serial No. Required
			</td>
			<td class="CONTROL" colspan="3" width="25%">
				<bean:write property="strSerialNo" name="genericitemBean" filter="false"/>
				
			</td>
			
			
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">
				Whether Item Has Specific Parameter
			</td>
			<td class="CONTROL" colspan="1" width="25%">
				<div id="strParam"><bean:write property="strParam" name="genericitemBean" filter="false"/></div>
				
			</td>
			
			<td class="CONTROL" colspan="2" width="50%">
			<div id="modifyParamShow" style="display:none">
			<img src="../../hisglobal/images/show_parameter_values.GIF" onclick="checkForPopup(this)" style="cursor: pointer; ">
			</div>				
			</td>
		</tr>
	</table>
	
	</div>
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">		
				<tr>
				  <td  colspan="4" class="TITLE" width="25%">
				<div id="purchasePlusId" align="left" style="display:none;">
					<img src="../../hisglobal/images/plus.gif" 
									onClick="view1('purchasePlusId','purchaseMinusId','purchaseId');" style="cursor: pointer; "/>
						Purchase/Inventory
					</div>
					<div id="purchaseMinusId" style="display:block;" align="left">
						
								Purchase/Inventory
					</div>
					</td>
				</tr>
	</table>
	<div id="purchaseId" style="display:block;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
			<td class="LABEL" colspan="1" width="25%">
				Purchase Lead Time
			</td>
			<td class="CONTROL" colspan="" width="25%">
				
				<bean:write name="genericitemBean" property="strPurchaseLeadTime" filter="false"/>
				
				
			</td>
			<td class="LABEL" colspan="1" width="25%">Time Format</td>
			<td class="CONTROL" colspan="1" width="25%">
				<bean:write name="genericitemBean" property="strTimeFormat" filter="false"/>
				
			</td>
			
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">
				Inventory Unit
			</td>
			<td class="CONTROL" colspan="" width="25%">
				
					<bean:write name="genericitemBean" property="strStockMaintain" filter="false"/>
				
			</td>
			<td class="LABEL" colspan="2" >
				
			</td>
			</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">
				Shelf Life
			</td>
			<td class="CONTROL" colspan="" width="25%">
				<bean:write name="genericitemBean" property="strShelfLife" filter="false"/>
				
			</td>
			<td class="LABEL" colspan="1" width="25%">Time Format</td>
			<td class="CONTROL" colspan="1" width="25%">
				<bean:write name="genericitemBean" property="strShelfTimeFormat" filter="false"/>
				
			</td>
		</tr>
		
	</table>
	</div>
	
<table cellpadding="1px" cellspacing="1px" class="TABLEWIDTH" align="center">
	<tr>
		<td class="LABEL" width="25%"> 
		
			Remarks
		</td>
		<td class="CONTROL"  width="75%" colspan="3">
		<bean:write name="genericitemBean" property="strRemarks" filter="false"/>
			</td>
		
			
		</tr>
			<tr> 
			<td class="LABEL" width="25%"> 
			Effective From
		</td>
		<td class="CONTROL"  width="25%" colspan="">
				<bean:write name="genericitemBean" property="strEffectiveFrom" filter="false"/>
		</td>
    <td class="LABEL">Record Status</td>
    <td  class="CONTROL" > 
    	<bean:write name="genericitemBean" property="strIsValid" filter="false"/>
       
    </td>
    
  </tr>
	</table>
	<table cellpadding="1px" cellspacing="1px" class="TABLEWIDTH" align="center">
		<tr class="FOOTER">
		<td colspan="4" width="25%"></td>
		</tr>
	</table>
	<table  class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	
		<tr>

			<td align="center" colspan="2" width="25%">
			
			<!--	<img src="../../hisglobal/images/btn-ccl.png" onClick ="closeView();" style="cursor: pointer; " title="Cancel View">-->
				<br>
				<a href="#" class="button" onclick="closeView();"><span class="cancel">Cancel</span></a>
			</td>
		</tr>
	</table>
<input type="hidden" name="hmode"/>
<input type="hidden" value="${genericitemBean.strCurrentDate}" name="strCurrentDate"/>
<input type="hidden" value="${genericitemBean.strGroupId}" name="strGroupId"/>
<input type="hidden" value="${genericitemBean.strSubGroupId}" name="strSubGroupId"/>
<input type="hidden" value="${genericitemBean.strChk}" name="strChk"/>
<input type="hidden" value="${genericitemBean.strParam}" name="strParamFlag"/>
<input type="hidden" value="${genericitemBean.strCatNo}" name="strCatNo"/>
<input type="hidden" value="${genericitemBean.strItemID}" name="strItemID"/>



<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="popUpDivId" style="display:none;">
<table bgcolor="white">
<tr>
<td>
<div id="itemParameterDtlDivId" style="display:block;"></div>
</td>
</tr>
</table>
</div>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>