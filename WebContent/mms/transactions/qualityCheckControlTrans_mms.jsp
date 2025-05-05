<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>

<!-- 
/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 05/June/2009
 * 
 */
-->
<html>
<meta charset=UTF-8">
<head>
<style type="text/css">

            .pg-normal 
            {
                color: blue;
                font-weight: normal;
                text-decoration: none;
                cursor: pointer;
                
                
            }
            .pg-selected 
            {
                color: red;
                font-weight: bold;
                text-decoration: underline;
                cursor: pointer;
                
            }
            .pg-qualified 
            {
                color: green;
                font-weight: bold;
                text-decoration: underline;
                cursor: pointer;
                
            }
            </style>
<title>Sample/Quality Check Control</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>

<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<script language="JavaScript" src="../js/qualityCheckControlTrans_mms.js">

	

</script>
</head>
<body onload="statusValues();">
<html:form action="/transactions/QualityCheckControlTransCNT.cnt" name="qualityCheckControlBean" 
type="mms.transactions.controller.fb.QualityCheckControlTransFB" method="post" enctype="multipart/form-data">
	<center><div class="errMsg" id="errMsg"><bean:write name="qualityCheckControlBean" property="strErrorMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="qualityCheckControlBean" property="strWarningMsg" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="qualityCheckControlBean" property="strNoramalMsg" /></div>
		
	<tag:tab tabLabel="Sample/Quality Check Control" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab></center>
	
	
	<table class="TABLEWIDTH" align="center" cellspacing="1px">   
	   	
	   		   	
		<tr class="HEADER">

			<td colspan="3" style="width: 706px"></td>
			
			<td colspan="1">		
			
			       <input type="checkbox" name="strReSendMode" value="1" onClick="changeViewMode1(this);"/>Re-Send
	               <input type="checkbox" name="strView"   value="2" onClick="changeViewMode2(this);">View
	          
			</td>
			
		</tr>
				
    </table>
    
	
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">  
	<tr>
		<td colspan="1" class="LABEL">
			<font color="red">*</font>HQ Name		
		</td>
		<td colspan="1" class="CONTROL">
			<select name="strStoreId" class='comboMax' onchange="itemCategoryCombo();">
					<bean:write name="qualityCheckControlBean" property="strStoreNameCmb"filter="false" />
					<option value="0">Select Value</option>
			</select>
		</td>
		<td colspan="1" class="LABEL">
			<font color="red">*</font>Drug Category		
		</td>
		<td colspan="1" class="CONTROL">
			<div id="itemCategoryId"><select name="strItemCategoryNo" class='comboMax' onChange="groupNameCombo();">
					<bean:write name="qualityCheckControlBean" property="strItemCatNoCmb"filter="false" />
					<option value="0">Select Value</option>
			</select></div>
		</td>
	</tr>
	
	<tr>
		<td colspan="1" class="LABEL">
			Group Name		
		</td>
		<td colspan="1" class="CONTROL">
			<div id="groupId"><select name="strGroupId" class='comboMax' onchange="subGroupNameCombo();">
					<bean:write name="qualityCheckControlBean" property="strGroupNameCmb"filter="false" />					
			</select></div>
		</td>
		<td colspan="1" class="LABEL">
			Sub Group Name		
		</td>
		<td colspan="1" class="CONTROL">
			<div id="subGroupId"><select name="strSubGroupId" class='comboMax' onChange="genItemNameCombo();">
					<bean:write name="qualityCheckControlBean" property="strSubGroupCmb"filter="false" />
					<option value="0">All</option>
			</select></div>
		</td>
	</tr>
	
	<tr>
		<td colspan="1" class="LABEL">
			Generic Drug Name		
		</td>
		<td colspan="1" class="CONTROL">
			<div id="genItemId"><select name="strGenericItemId" class='comboMax' onchange="itemNameCombo();">
					<bean:write name="qualityCheckControlBean" property="strGenItemCmb"filter="false" />
					<option value="0">All</option>
			</select></div>
		</td>
		<td colspan="1" class="LABEL">
			Drug Name		
		</td>
		<td colspan="1" class="CONTROL">
			<div id="itemId"><select name="strItemBrandId" class='comboMax' onChange="batchNoComboTwo();">
					<bean:write name="qualityCheckControlBean" property="strItemNameCmb"filter="false" />
					
			</select></div>
		</td>
	</tr>
	</table>
	
	
	<div id="strBatchDivId" style="display: none;">
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">	
	<tr>
		<td width="50%" class="LABEL"><font color="red">*</font>
			Batch No		
		</td>
		<td width="50%" class="CONTROL" colspan="3">
			<div id="batchNoId"><select name="strBatchNo" class='comboNormal'>
					<bean:write name="qualityCheckControlBean" property="strBatchNoCmb"filter="false" />
					<option value="0">Select Value</option>
			</select></div>
		</td>
	</tr>
	</table>
	</div>
	
	<div id="strBatchItemDivId" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">	
	<tr>
		<td width="50%" class="LABEL"><font color="red">*</font>
			Drug Serial No		
		</td>
		<td width="50%" class="CONTROL" >
			<div id="itemSlNoId"><select name="strItemSlNo" class='comboNormal'>
					<bean:write name="qualityCheckControlBean" property="strItemSlNoCmb"filter="false" />
					<option value="0">Select Value</option>
			</select></div>
		</td>
	</tr>
	</table>
	</div>
		
	
	<div id="qualityDivId" style="display: none;">
	
	
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr class="HEADER">
			<td colspan="4">Stock Position</td>
		</tr>
		<tr>	
		    <td class="LABEL" width="25%" colspan="1">Avl Qty</td>
		    <td class ="CONTROL" colspan="1">
		    <div id="avlQtyDivId"></div>
		    <td class="LABEL" width="25%" colspan="1">Supplied By</td>
		    <td colspan="1" class ="CONTROL">
		    <div id="mfgNameDivId"></div>    
		</tr>
		<tr>	
		    <td class="LABEL" width="25%" colspan="1">Mfg Date</td>
		    <td class ="CONTROL" colspan="1">
		    <div id="mfgDateDivId"></div>
		    <td class="LABEL" width="25%" colspan="1">Exp Date</td>
		    <td colspan="1" class ="CONTROL">
		    <div id="expDateDivId"></div>    
		</tr>
	   <tr>	    
		    <td class="LABEL" width="25%" colspan="1">Last PO No</td>
		    <td colspan="1" class ="CONTROL">
		    <div id="poNoDivId"></div>  
		    <td class="LABEL" width="25%" colspan="1">Last PO Date</td>
		    <td colspan="1" class ="CONTROL">
		    <div id="poDateDivId"></div>        
  	  </tr>
	  <tr>
			<td class="LABEL"  width="25%" colspan="1">Mfg. Name</td>
		    <td class ="CONTROL" width="75%" colspan="3">
		   <div id="suppliedByDivId"></div>
	  </tr>
	
	
	
		<tr class="HEADER">
			<td colspan="4">Quality Details</td>
		</tr>
		</table>
	<div id="qualityDetailsDivId" style="display: block;">
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Issue Quantity</td>
			<td width="25%" class ="CONTROL">
			<input type="text" class='txtFldNormal' name="strConsumedQty" id="strConsumedQty"
			value ="" maxlength="50" onkeypress="return validateData(event,7);" onkeyup="return checkUnitQty();">
			</td>
			<td class="LABEL" width="25%"><font color="red">*</font>Issue Qty Unit</td>
			<td width="25%" class ="CONTROL">
			<div id="consumedQtyDivId">
			    	<select name="strConsumedQtyUnitId" id="strConsumedQtyUnitId"  class='comboNormal' onchange="return quantityUnitValue();">
					<option value="0">Select Value</option>
					<option value="6301^1^0">No.</option>
			</select>
			</div>		
			</td>
		</tr>
		
		<tr>
			
			<td class="LABEL" width="25%"><font color="red">*</font>Sent Date</td>
			<td width="25%" class ="CONTROL"><dateTag:date name="strLabSendDate" value=""></dateTag:date></td>
			<td class="LABEL" width="25%"><font color="red">*</font>Lab Name</td>
			<td width="25%" class ="CONTROL">
			   <select name="strLabId" class='comboMax' onChange="setLabName();">
				<bean:write name="qualityCheckControlBean" property="strLabNameCombo" filter="false" />
					</select>
			</td>
		</tr>
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>CTR No.</td>
			<td width="25%" class ="CONTROL">
			   <input type="text" class='txtFldNormal' name="strCTRNumber" id="strCTRNumber"  value ="" maxlength="10" onkeypress="return validateData(event,8);">
			</td>
			<td class="LABEL" width="25%"><font color="red">*</font>Secret Code No.</td>
			<td width="25%" class ="CONTROL">
			 <input type="text" class='txtFldNormal' name="strSampleCodeNumber" id="strSampleCodeNumber"  value ="" maxlength="10" onkeypress="return validateData(event,17);" >
			</td>
		</tr>
		<tr>
		<td class="LABEL" width="25%"><font color="red">*</font>Received Date</td>
				<td class="CONTROL" width="25%"><dateTag:date name="strReceiveDate" value=""></dateTag:date>  </td>
				<td class="CONTROL" width="25%"></td>
				<td class="CONTROL" width="25%"></td>
				
		</tr>
	 </table>
	 </div>
	 <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		
         <tr>
    		<td class ="LABEL" width="25%"><font color="red">*</font>QC Status </td>
   			 <td class ="CONTROL"  width="25%">
   			<html:radio name="qualityCheckControlBean" property="strItemStatus" value="1" onclick="itemStatus2();">Approved</html:radio>
    		<html:radio name="qualityCheckControlBean" property="strItemStatus" value="2" onclick="itemStatus();">Rejected</html:radio></td>
    		
    		<td class="LABEL" width="25%">Lab In-Charge Name</td>
			<td width="25%" class ="CONTROL">
			 <input type="text" class="txtFldMax" name="strLabInchargeName" onkeypress="return validateData(event, 16);" maxlength="50">
			</td>
        </tr>
        
        </table>
       
		
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"	cellspacing="1px">
	    <tr>
				<td class="LABEL" width="25%"><font color="red">*</font>Report No</td>
				<td class="CONTROL" width="25%"> <input type="text" class="txtFldMax" name="strReportNumber" onkeypress="return validateData(event,16);" maxlength="49"></td>
				<td class="LABEL" width="25%"><font color="red">*</font>Report Date</td>
				<td class="CONTROL" width="25%"><dateTag:date name="strReportDate" value=""></dateTag:date>  </td>
		</tr>
	
	</table>
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"	cellspacing="1px">
       
        <tr>
            <td class="LABEL" width="25%"><font color="red">*</font>Remarks(Lab)</td>
			<td class="CONTROL" width="25%">
        		<textarea name="strFinalResult" rows="2"></textarea>
             </td>
			
			<td class="CONTROL" width="25%"></td>
			<td width="25%" class ="CONTROL"></td>
			
			
		</tr>
		
	</table>
	        
        <div id="rejectDivId" style="display: none;">
         <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
        <tr>
	   		<td class="LABEL" colspan="1" width="50%">Stop Distribution</td>
			<td class="CONTROL" colspan="3" width="50%"><input name="strDistributionFlag" type="checkbox"
				value="1" onclick="distributionCheck();"></td>
		</tr>
		</table>
		</div>
		<!--  
		 <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		 <tr>
		<td  class="LABEL" width="50%">
					<font color="red">*</font>Approved By  
		</td>
		<td class="CONTROL" width="50%">
		<div id="strCommitteeTypeDivId">
			<select name="strCommitteeTypeId" id="strCommitteeTypeId" class="comboMax" onchange="getMemberDtl('COMMITEEMEMBERDTL');">
				<bean:write name="qualityCheckControlBean" property="strCommitteeTypeCmb" filter="false"/>
			</select>
			</div>
		</td>
		</tr>
		<tr>
		<td  class="LABEL" width="50%">
					Committee Member Detail  
		</td>
		<td class="CONTROL" width="50%" >
			<img src="../../hisglobal/images/Patient.png" 
									onClick="openDivPopup();" style="cursor: pointer; " title="Click Here To See Member Details"/>
		</td>
		
			
				
		</tr>
		</table>
		-->
		<jsp:include page="uploadFile.jsp"></jsp:include>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
         <td class="LABEL" width="50%" >Remarks</td>
			<td class="CONTROL" width="50%" >
        		<textarea name="strRemarks" rows="2"></textarea>
             </td>
         </tr>
         </table>
	</div>
		
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">	
	
	
	<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	
	
		<tr id="saveId">
			<td colspan="4" align="center">
			<img style="cursor: pointer; " title="Save Record" src="../../hisglobal/images/btn-sv.png" onclick="return validate2();" /> 
			<img style="cursor: pointer; " title="Clear Content"  src="../../hisglobal/images/btn-clr.png" onClick="getClear();" />
            <img style="cursor: pointer; " title="Cancel Process" src="../../hisglobal/images/btn-ccl.png" onClick="cancel();" /></td>
		</tr>
	</table>
<input type="hidden" name="hmode"/>

<input type="hidden" name="strCurrentDate" value="${qualityCheckControlBean.strCurrentDate}"/>
<input type="hidden" name="strHidDistributionFlag" value="${qualityCheckControlBean.strDistributionFlag}"/>
<input type="hidden" name="strIsConsumable" value="${qualityCheckControlBean.strIsConsumable}"/>
<input type="hidden" name="strPONo" value="${qualityCheckControlBean.strPONo}"/>
<input type="hidden" name="strPODate" value="${qualityCheckControlBean.strPODate}"/>
<input type="hidden" name="strSupplierId" value="${qualityCheckControlBean.strSupplierId}"/>
<input type="hidden" name="strBatchDtl" id="strBatchDtl" />
<input type="hidden" name="strResendFlag" value="0"/>
<input type="hidden" name="strInhandQty" value="${qualityCheckControlBean.strInhandQty}"/>
<input type="hidden" name="hideItemCatId" value="${qualityCheckControlBean.hideItemCatId}"/>
	<input type="hidden" name="displayFlag" value="${qualityCheckControlBean.displayFlag}"/>
	<input type="hidden" name="strItemCategoryName" value="${qualityCheckControlBean.strItemCategoryName}"/>
<input type="hidden" name="strLabName" value=""/>
<input type="hidden" name="strStoreName" value=""/>

<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="memberDtl" style="display:none;">
<table bgcolor="white">
<tr>
<td>
<div id="memberDtlInner" style="display:block;"></div>
</td>
</tr>
</table>
</div>
</html:form>


			<tag:autoIndex></tag:autoIndex>   

</body>
</html>