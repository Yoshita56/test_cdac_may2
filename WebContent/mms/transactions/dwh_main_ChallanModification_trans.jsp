<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="combPer"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<html>
<head>
<meta charset=UTF-8">
<title>CHALLAN MODIFY</title>

<link href="../css/tarnsaction.css" rel="stylesheet" type="text/css">
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	

<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../js/dwh_main_ChallanModification_trans.js"></script>
</head>
<body onLoad="hideMenuFrame();">
<html:form action="/transactions/ChallanModificationTransCNT.cnt"  name="challanModificationTransFB" type="mms.transactions.controller.fb.ChallanModificationTransFB" method="post">
    <div class="errMsg"     id="errMsg"><bean:write name="challanModificationTransFB" property="strErrMsg"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="challanModificationTransFB" property="strWarningMsg"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="challanModificationTransFB" property="strNormalMsg"/></div>
     
     <tag:tab tabLabel="Challan Modification" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>
   
 <table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">

<tr class="HEADER"> 
			 <td colspan="4">Challan Modification</td>		      
	  </tr>
<!-- Drug Ware House Name and PO NO -->
	<tr> 
          
	     <td width="25%"   class="LABEL"><font color="red">*</font>Store Name</td>
             <td width="25%"  class="CONTROL">
         
	          <html:select name="challanModificationTransFB" property="strDrugWareHouseName" styleClass="comboMax" onchange="getSupplierCombo();">
	                 <bean:write name="challanModificationTransFB" property="strDrugWareHouseNameCmb" filter="false"/>
	          </html:select>
            </td>   
            <td width="25%"   class="LABEL"><font color="red">*</font>Supplier Name</td>
             <td width="25%"  class="CONTROL">
         
	          <div id="supplierCmb">   
		          <html:select name="challanModificationTransFB" property="strSupplierId" styleClass="comboMax"  onchange="getPoNoCombo();">
		                 <option value="0">Select Value</option>
		           </html:select>
	          </div> 
            </td>   
      </tr>    
       <tr>     
          <td width="25%"  class="LABEL"><font color="red">*</font>PO No</td>
         <td width="25%"  class="CONTROL">    		 
         <div id="poNoComboDivId">     
	          <html:select name="challanModificationTransFB" property="strPoNo" styleClass="comboMax" >
	                 <bean:write name="challanModificationTransFB" property="strPoNoCmb" filter="false"/>
	                 <option value="0">Select Value</option>
	          </html:select>
	        </div>    
	        
         </td>  
         <td width="25%"  class="LABEL"><font color="red">*</font>Challan No.</td>
         <td width="25%"  class="CONTROL">
    		<div id="challanComboDivId">     
	          <html:select name="challanModificationTransFB" property="strChallanNo" styleClass="comboMax"   >
	                 <bean:write name="challanModificationTransFB" property="strChallanNoCmb" filter="false"/>
	                 <option value="0">Select Value</option>
	          </html:select>
	        </div>  
         </td> 
          
      </tr>       
      <tr>                 
	    
         <td  colspan='4' class="CONTROL">  
          <div id="goImage" align="center"><img style="cursor: pointer;text-align:center;"  title="Get Item Challan Details" src="../../hisglobal/images/Go.png" onclick="getChallanDetails();"/></div>
         </td>
   </tr>
   </table>    
      	
	<div id="challanDetails"></div>
	<div id="id1"></div>
	<div id="modifyDtl" style="display:none;">
    <table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
    
       <tr class="TITLE">
			 <td colspan="4"> Modify Drug Detail (s)</td>
		</tr>
		
		<tr>
			<td class="LABEL" width="25%">Order Qty.</td>
		    <td class="CONTROL" width="25%"><div id="orderQty"></div></td>
			
			<td class="LABEL" width="25%">Total Accepted Qty.</td>
		    <td class="CONTROL" width="25%"><div id="acceptedQty"></div></td>
			
		</tr>
		<tr>
			<td class="LABEL" width="25%">Total Rejected Qty.</td>
		    <td class="CONTROL" width="25%"><div id="rejectedQty"></div></td>
		    			
			<td class="LABEL" width="25%">Current Avl Qty.</td>
		    <td class="CONTROL" width="25%"><div id="currentAvlQty"></div></td>
		    
			
		</tr>
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Batch No</td>
		    <td class="CONTROL" width="25%"><input type="text"
				name="strBatchNo" maxlength="20" class="txtFldMax"
				onkeypress="return validateData(event,17);" /></td>
		    			
			<td class="LABEL" colspan="2"></td>
		    
		    
			
		</tr>
			
        <tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Accepted Qty.</td>
		    <td class="CONTROL" width="25%"><input type="text"
				name="strAcceptedQuantity" maxlength="11" class="txtFldNormal"
				onkeypress="return validateData(event,5);"  onBlur="CalculateDrugCost();"  /></td>
			
			<td class="LABEL" width="25%">Rejected Qty.</td>
		    <td class="CONTROL" width="25%"><input type="text" value="0"
				name="strRejectedQuantity" maxlength="11" class="txtFldNormal"
				onkeypress="return validateData(event,5);" /></td>
			
		</tr>
				
				
		
		<tr>
			<td class="LABEL" width="25%">Breakage Qty.</td>
		<td class="CONTROL" width="25%"><input type="text" value="0"
				name="strBreakageQuantity" maxlength="11" class="txtFldNormal"
				onkeypress="return validateData(event,5);" /></td>
			
			<td class="LABEL" width="25%">Excess Qty.</td>
		<td class="CONTROL" width="25%"><input type="text" value="0"
				name="strExcessQty" maxlength="11" class="txtFldNormal"
				onkeypress="return validateData(event,5);" /></td>
			
		</tr>
		
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Manuf Date</td>
		    <td class="CONTROL" width="25%"><dateTag:date name="strManufactureDate" value=""></dateTag:date></td>
			
			<td class="LABEL" width="25%"><font color="red">*</font>Expiry Date</td>
		    <td class="CONTROL" width="25%"><dateTag:date name="strExpiryDate" value=""></dateTag:date></td>
			
		</tr>
		<tr class="TITLE">
			 <td colspan="4"> Supplier Performance Detail (s)</td>
		</tr>
     <tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Whether Test Report Submitted</td>
		    <td class="CONTROL" width="25%"><select name='strWhetherMedicinesWithTestReport' ><option value='1' selected='selected'>Yes</option><option value='0'>No</option></select></td>
			
			<td class="LABEL" width="25%"><font color="red">*</font>Whether Medicines/Packaging are in good condition</td>
		    <td class="CONTROL" width="25%"><select name='strWhetherMedicinesInGoodCondition' ><option value='1' selected='selected'>Yes</option><option value='0'>No</option></select></td>
			
		</tr>
		
		
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Whether Rajsthan Govt. Supply Not for Sale & Logogram printed</td>
		    <td class="CONTROL" width="25%"><select name='strWhetherSupplyNotForSale' ><option value='1' selected='selected'>Yes</option><option value='0'>No</option></select></td>
			
			<td class="LABEL" width="25%"><font color="red">*</font>Brand Name Not Written</td>
		    <td class="CONTROL" width="25%"><select name='strWhetherBrandNameNotWritten' ><option value='1' selected='selected'>Yes</option><option value='0'>No</option></select></td>
			
		</tr>
		
		<tr>
			<td class="LABEL" width="25%"><font color="red">*</font>Price(MRP) not printed/Visible</td>
		    <td class="CONTROL" width="25%"><select name='strWhetherMRPPrint' ><option value='1' selected='selected'>Yes</option><option value='0'>No</option></select></td>
			
			<td class="CONTROL" colspan="2"></td>
			
		</tr>
    
        <tr>
				<td class='LABEL' colspan='2'>
				<font color='red'>*</font>Remarks</td>
				<td class='CONTROL'  colspan='2'>
				<textarea name='strRemarks'></textarea>
				</td>
	</tr>
	</table>	
	</div>
	<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
	 <tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>	
	<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
	  <tr>
			<td align="center">
	                <img style="cursor:pointer;cursor:pointer" title="Click to Save Record" src="../../hisglobal/images/Verify.gif"  onClick=" return validate2();" onkeypress="if(event.keyCode==13) validate2();"/>
	                <img style="cursor:pointer;cursor:pointer" title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="document.forms[0].reset(),clearMsg('INITVAL')" onkeypress="if(event.keyCode==13) document.forms[0].reset(),clearMsg('INITVAL');">
	                <img style="cursor: pointer; " title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="hideMenuFrame();cancelPage();" onkeypress="if(event.keyCode==13) hideMenuFrame();cancelPage()" />
			</td>
		</tr>
	</table>	
    
     <html:hidden name="challanModificationTransFB" property="hmode" />
     <html:hidden name="challanModificationTransFB" property="strStoreId" />
     <html:hidden name="challanModificationTransFB" property="strSubStoreCmb" />
     
      <html:hidden name="challanModificationTransFB" property="strCtDate" value="${challanModificationTransFB.strCtDate}"/>
    
    <html:hidden name="challanModificationTransFB" property="strGoDetailsFlag" value="0" />
    <html:hidden name="challanModificationTransFB" property="strModifyFlag" value="${challanModificationTransFB.strModifyFlag}" />
    
	<html:hidden name="challanModificationTransFB" property="strOrderedQty"  value="${challanModificationTransFB.strOrderedQty}" />
   <html:hidden name="challanModificationTransFB" property="strResetOrderedQty"  value="${challanModificationTransFB.strResetOrderedQty}" />
   
   <input type="hidden" name="strPrevHiddenChallanValue" value="" />
   <input type="hidden" name="strChallanValue" value="" />
   
   <input type="hidden" name="strBeforeSaveFlg" value="0">
  
     
   <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv1" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
           <div id="supplierPerformanceDtlsDivId" style="display:block;"></div>
           
       </td>
     </tr>
    </table>
   </div>
</html:form>

	<tag:autoIndex></tag:autoIndex>   

<combPer:cmbPers />
</body>
</html>
