<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>


<html>
<head>
<meta charset=UTF-8">
<title>Issue Process</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">

<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="Javascript" src="../js/issue_trans_go_withoutCrNo.js"></script>

<script type="text/javascript">


function CallCustomFunc(val)
{
	
		 var reqQty = document.getElementsByName("strQtyText");
			 reqQty[0].focus();
			
}	
	
function getItemSelectPopup() 
{
	var strRequestType  = "32";
	var strModeVal      = "3";
	//var strItemCategory = document.getElementsByName('strItemCat')[0].value;
	var strItemCategory = "10";
	var strFromStoreId  = document.getElementsByName('strStoreId')[0].value.split("^")[0];
	if(strFromStoreId=="0")
	{
		alert("Select Store Name");
		return false;
	}
	if(strItemCategory=="0")
	{
		alert("Select Category");
		return false;
	}
    if(document.forms[0].strDoseFrqFlg.value=='1')
	{
		    // Commented by Amit for GGSH
			var      strMultiRowCompArray = new Array('itemParamValue', 'itemCalcValue','itemUserValue', 'strDose', 'strFrequency', 'strDays', 'strReqQty');
			var  strMultiRowCompTypeArray = new Array('t', 't', 't', 's', 's', 't', 't');
	}
	else
	{
			var      strMultiRowCompArray = new Array('itemParamValue', 'itemCalcValue','itemUserValue', 'strReqQty');
			var  strMultiRowCompTypeArray = new Array('t', 't', 't', 't');
	}
	var strMultiRowFetchDataArray = new Array('1', '11', '4');
	var layerIndex = "1";
	var userFunctionName     = "CallCustomFunc";
	var userFunctionArgument = "test";
	var strUserInfo =""; 
	var strUnitMode = "0"; // only base unit  1 Means Only Base Unit Show 0 Means All Unit Show in Unit Combo
	//                searchItems(strModeVal, strItemCategory, strRequestType, strFromStoreId,strMultiRowCompArray,strMultiRowCompTypeArray,strMultiRowFetchDataArray, layerIndex);
	searchItemsWithUserFunction(strModeVal, strItemCategory, strRequestType, strFromStoreId,strMultiRowCompArray,strMultiRowCompTypeArray,strMultiRowFetchDataArray, layerIndex,userFunctionName, userFunctionArgument ,strUserInfo , strUnitMode)
}	

</script>
<style>
        .example {
            page-break-after: always;
        }
    </style>
</head>
<body  onLoad="getReport();">


<html:form name="issueBean" action="/transactions/IssueTransCNT" type="mms.transactions.controller.fb.IssueTransFB">

	<div id="errMsg" class="errMsg">
		<bean:write name="issueBean" property="strErrMsg" />
	</div>
	
	<div id="warningMsg" class="warningMsg">
		<bean:write name="issueBean" property="strWarningMsg" />
	</div>
	<div id="normalMsg" class="normalMsg">
		<bean:write name="issueBean" property="strNormalMsg" />
	</div>


	<logic:equal value="0" name="issueBean" property="strMode">

		<tag:tab tabLabel="Issue To Patient" selectedTab="FIRST"
			align="center" width="TABLEWIDTH" onlyTabIndexing="1">
		</tag:tab>
		<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
			<tr class="HEADER">
			 <td align="right">
			 	<span>
			     	<html:checkbox property="strWithoutCrNoCheckBox" name="issueBean"  onclick="goToWithCrNoPage();"  value="1"  tabindex="1" >Without CR No.</html:checkbox>
			     <%-- 	<html:checkbox property="strCancelCheckBox"      name="issueBean"  onclick="goToCancelPage();"    value="1"   tabindex="1">Cancel Issue</html:checkbox>  --%>
			     	<html:checkbox property="strViewChk"             name="issueBean"  onclick="transferToViewPage();" title="Click Here To View Off Line Issue Item Detail"  tabindex="1">View</html:checkbox>
		     	</span>		 
		    </td>
			</tr>
		</table>

	</logic:equal>

	<logic:equal value="1" name="issueBean" property="strMode">
		<tag:tab tabLabel="Issue To Patient" selectedTab="FIRST" align="center"
			width="TABLEWIDTH">
		</tag:tab>
		<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4"></td>
				
			 <td align="right" >
			 	<span>
			     	<html:checkbox property="strWithoutCrNoCheckBox" name="issueBean" onclick="goToWithCrNoPage();" value="1"  tabindex="1" >Without CR No.</html:checkbox>
			     	<%-- 	<html:checkbox property="strCancelCheckBox"      name="issueBean"  onclick="goToCancelPage();"    value="1"  >Cancel Issue</html:checkbox>  --%>
			     	<html:checkbox name="issueBean" property="strViewChk" onclick="transferToViewPage();" title="Click Here To View Off Line Issue Item Detail"   tabindex="1">View</html:checkbox>
		     	</span>		 
		    </td>
		    
			</tr>
		</table>
	</logic:equal>


	<logic:equal value="2" name="issueBean" property="strMode">
		<tag:tab tabLabel="Issue To Patient" selectedTab="FIRST"
			align="center" width="TABLEWIDTH">
		</tag:tab>
		<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
			<tr class="HEADER">
			
				
			 <td align="right" >
			 	<span>
			     	<html:checkbox property="strWithoutCrNoCheckBox" name="issueBean" onclick="goToWithCrNoPage();" value="1"   tabindex="1">Without CR No.</html:checkbox>
<%-- 	<html:checkbox property="strCancelCheckBox"      name="issueBean"  onclick="goToCancelPage();"    value="1"  >Cancel Issue</html:checkbox>  --%>
			     	<html:checkbox name="issueBean" property="strViewChk" onclick="transferToViewPage();" title="Click Here To View Off Line Issue Drug Detail"  tabindex="1">View</html:checkbox>
		     	</span>		 
		    </td>
		    				
			</tr>

		</table>

	</logic:equal>


	<div class='popup' id='balQtyDtlId' style="display: none">
	<table width='400' border="0" cellspacing="1" cellpadding="1">
		<tr class="HEADER">
			<td colspan='3'>Quantity Details</td>

			<th align='right'><img style='cursor: pointer; ' src='../../hisglobal/images/popUp_cancel.JPG'	onClick="hideBalQtyDetails('balQtyDtlId');"></th>
		</tr>
	</table>


	<table width='400' border="0" cellspacing="1" cellpadding="1">

		<tr>
			<td colspan="1" class='multiRPTLabel'>Req Qty</td>
			<td colspan="1" class='multiRPTLabel'>Issue Qty</td>

		</tr>
		<tr>
			<td colspan="1" class='multiPOControl'>
			<div id='1'></div>
			</td>
			<td colspan="1" class='multiPOControl'>
			<div id='2'></div>
			</td>

		</tr>
	</table>
	</div>

<!--
<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr>
			<td  colspan="1" class="LABEL" ><font color="red">*</font>DDW Name</td>
			<td  colspan="1" class="CONTROL">
				<select name="strStoreId" class="comboNormal" onchange="getItemCat();">
				
						<bean:write name="issueBean" 
						property="strStoreValues"	filter="false" />
				</select>
			</td>

			<td  colspan="1" class="LABEL"><font color="red">*</font>Category</td>
			<td  colspan="1" class="CONTROL">
				<div id="itemcatDivId">
					<select	name="strItemCat" class="comboNormal" >
					<bean:write name="issueBean" property="strItemCatCombp" filter="false" />
				</select>
				</div>
			</td>			
		</tr>
	</table>  -->
<!--
	<logic:notEqual value="1" name="issueBean" property="strIssueMode">
	
		<bean:write	name="issueBean" property="strReqValues" filter="false" />
		
	</logic:notEqual>	-->
	
<%-- Patient Details	--%>

		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">

             <tr>
			<td  width="25%" class="LABEL" ><font color="red">*</font>DDC Name</td>
			<td  width="25%" class="CONTROL">
				<select name="strStoreId" class="comboMax"  disabled="disabled"   tabindex="1">				
						<bean:write name="issueBean" property="strStoreValues"	filter="false" />
				</select>
			</td>

			<td width="25%" class="LABEL"><font color="red">*</font>Issue Date</td>
				<td width="25%" class="CONTROL">
				    <date:date name="strDrugIssueDate" value="${issueBean.strCtDate}" ></date:date>
				</td>		
		</tr>		
		<tr>
				<td class="TITLE" colspan="4">Patient Detail(s)</td>
		</tr>		
     
        
		<tr>
			<td colspan="1" class="LABEL"><font color="red">*</font>Patient Name :</td>
			
			<td class="CONTROL" colspan="3">
				<input type="text" name="strFirstName" value=""  class="txtFldMax"  maxlength="30" onkeypress="return validateData(event,4);" tabindex="1">
			</td>
			
		</tr>
	
			<tr>
				<td class="LABEL" colspan="1"><font color="red">*</font>Patient's Age :</td>
				<td class="CONTROL" colspan="1">
					<input type="text" name="strPatientAge" class="txtFldMin" value="${issueBean.strPatientAge}" maxlength="3" onkeypress="return validateData(event,5);" tabindex="1">
				
					<select	name="strPatientAgeUnit" class="comboMin" tabindex="1">
						<option value="1">Year(s)</option>
						<option value="2">Month(s)</option>
						<option value="3">Day(s)</option>
					</select>
				</td>
				
				
				<td class="LABEL" colspan="1"><font color="red">*</font>Gender :</td>
			
				<td class="CONTROL" colspan="1">
				<select	name="strPatientGenderCode" class="comboNormal"  tabindex="1" >
						
					<bean:write name="issueBean" property="strPatientGenderCodeCmbValues" filter="false" />
					</select>
					
				</td>
				
				
			</tr>

			
			<tr>			
			    <td width="25%" class="LABEL"><font color="red">*</font> Prescribed By (Dr.) :</td>
				<td width="25%" class="CONTROL">
				<input type="text"
					class="txtFldMax" name="strPrescribedBy"  maxlength="59" onkeypress="return validateData(event,4);" tabindex="1">
				</td>
				<td class="LABEL" colspan="1"><font color="red">*</font>Registration No :</td>
				<td class="CONTROL" colspan="1">
					<input type="text" name="strPatientId" class="txtFldMax" value="${issueBean.strPatientId}" maxlength="13" onkeypress="return validateData(event,5);"  tabindex="1">
				</td>
			 </tr>
		
		
		
		</table>				

<%-- Patient Details End --%>

	
		<div id="reqDtlDivId" style="display:none;"></div>
	    <div id="requestDivId"></div>



	<logic:notEqual value="1" name="issueBean" property="strIssueMode">

		<div id="itemDtlDivId" style="display: block"></div>

	</logic:notEqual>


	
		<div id="itemDtlOffDivId" style="display: block">
		<table class="TABLEWIDTH" align="center" cellspacing="1px"
			cellpadding="1px">
			<tr>
				<td class='TITLE' colspan='5'><div align="right"><img style="cursor: pointer;height: 20px"
					id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"   tabindex="1"
					onclick='getItemSelectPopup();' name="searchName"
					title="Click here to Search Item"></div></td>
			</tr>
			
			
		</table>
		
		
		 <logic:equal value="1" name="issueBean" property="strDoseFrqFlg">
		<table cellspacing="1px" class="TABLEWIDTH" align="center"
			cellpadding="0px" cellpadding="1px">

			<tr>
				<td class="multiRPTLabel" width="30%">Drug Name</td>
				<td class="multiRPTLabel" width="12%">Batch No</td>
				<td class="multiRPTLabel" width="12%">Avl Qty</td>
				<td class="multiRPTLabel" width="15%"><font color="red">*</font>Dosage</td>
				<td class="multiRPTLabel" width="10%"><font color="red">*</font>Frequency</td>
				<td class="multiRPTLabel" width="9%"><font color="red">*</font>Days</td>
				<td class="multiRPTLabel" width="12%"><font color="red">*</font>Quantity</td>
			</tr>
		</table>
       </logic:equal>
      <logic:equal value="0" name="issueBean" property="strDoseFrqFlg">
	       <table cellspacing="1px" class="TABLEWIDTH" align="center" bgcolor='black'	cellpadding="0px" cellpadding="1px">
				<tr>
					<td class="multiRPTLabel" width="40%">Drug Name</td>
					<td class="multiRPTLabel" width="30%">Batch No</td>
					<td class="multiRPTLabel" width="15%">Avl Qty</td>
					<td class="multiRPTLabel" width="15%"><font color="red">*</font>Quantity</td>
				</tr>
			</table>
       </logic:equal> 

		<div id="id1"></div>
		
          
		
		<table cellspacing="1px" class="TABLEWIDTH" align="center"
			cellpadding="1px">
			
			<tr class="TITLE">
				<td colspan="5"></td>
			</tr>
		</table>
		</div>
	

	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		
		<tr>
				<td class="LABEL" colspan="2">All Medicine written by Doctor have been given :</td>
<td class="CONTROL" colspan="2"><input type="radio" name="OutOfStockFlag" value="0" onClick="ftnTick(0)" checked  tabindex="1">Yes<input type="radio" name="OutOfStockFlag" value="1" onClick="ftnTick(1)" tabindex="1">No</td>
	    </tr>
		<tr>
			<td class="LABEL" colspan="2">Remarks(If Any)</td>
			<td class="CONTROL" colspan="2"><textarea  name="strRemarks"	cols="25" rows="2" onkeypress="return validateData(event,9);"  tabindex="1"></textarea></td>
		</tr>
	</table>
 
	<table class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr class="FOOTER">
		    <td width="50%" align="left">[ ALT + F1 ] for Short Cut Key Help</td>  
			<td width="50%" ><font color="red">*</font> Mandatory Fields</td>
		</tr>		 
	</table>
	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1"
		cellspacing="1">
		<tr>
			<td align="center">
			<div id="saveId">
				<img style=" cursor: pointer"  tabindex="1" src="../../hisglobal/images/btn-sv.png"
				onclick="return validateIssue();" onkeypress="goFuncOnEnterTwo(event);"/>&nbsp; 
				<img   tabindex="1" style=" cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="clearIssue(1);">&nbsp;
				<img style=" cursor: pointer"    tabindex="1" src="../../hisglobal/images/back_tab.png" onClick="cancelIssue();">
			</div>
			</td>
			
		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strUpdateFlag" value="" />	
	<input type="hidden" name="storeName" value="${issueBean.storeName}" />
	<input type="hidden" name="strOutOfStockFlag" value="${issueBean.strOutOfStockFlag}" />
	<input type="hidden" name="itemCatName" value="${issueBean.itemCatName}" />
	<input type="hidden" name="crNo" value="${issueBean.crNo}" />
	<input type="hidden" name="strId" value="${issueBean.strId}" />
	<input type="hidden" name="itemCategory" value="${issueBean.itemCategory}" />
	<input type="hidden" name="strConfCatCode" value="${issueBean.strConfCatCode}" />
	<input type="hidden" name="strIssueNo" value="${issueBean.strIssueNo}" />
	<input type="hidden" name="strIssueDtl" value="${issueBean.strIssueDtl}" />
	<input type="hidden" name="disFlag" value="${issueBean.disFlag}" />
	<input type="hidden" name="mode" value="${issueBean.strMode}" />
	<input type="hidden" name="strMode" value="${issueBean.strMode}">
	<input type="hidden" name="strIssueMode" value="${issueBean.strIssueMode}">
	<input type="hidden" name="strCtDate" value="${issueBean.strCtDate}" />
	<input type="hidden" name="strVisitDtl" value="${issueBean.strVisitDtl}" />
	<input type="hidden" name="strIssueNum" value="${issueBean.strIssueNum}" />
	<input type="hidden" name="isUpdateOpdDrugReq" value="" />
	<input type="hidden" name="strGlobalval" value="" />
	<input type="hidden" name="strDoseFrqFlg" value="${issueBean.strDoseFrqFlg}" />
	<input type="hidden" name="issueingStoreId" value="${issueBean.strIssuingStoreId}" />
	<input type="hidden" name="prescribedBy" value="${issueBean.strPrescribedBy}" />
	<input type="hidden" name="strReOrderFlgColor" value="${issueBean.strReOrderFlgColor}" />
	<input type="hidden" name="strVoucherHLP" value="${issueBean.strVocherHLPString}" />
	

	<cmbPers:cmbPers />
	<div id="blanket" style="display: none;"></div>

	<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			   <div id="searchItemsDtlsDivId" style="display: block;"></div>
			   <div id="issueDtlsDivId"       style="display: block;"></div>
			   
			</td>
		</tr>
	</table>
	</div>


</html:form>
<jsp:include page="issue_trans_search_row.jsp"></jsp:include>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>