<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="combPer"%>

<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<!-- 
/**
 * Developer : Vivek Aggarwal
 * Version : 1.0
 * Date : 02-Mar-2012
 * Modify Date : 
*/
-->
<html>
<head>
<meta charset=UTF-8">
<title>SUPPLIER PERFORMANCE DETAILS (BACKLOG)</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>

<script language="Javascript" src="../../hisglobal/js/validation.js"></script>



<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../js/dwh_main_supplierPerformanceDtl_trans.js"></script>
</head>
<body onload="setDefaultValues();">
<html:form action="/transactions/SupplierPerformanceDtlTransCNT.cnt"  name="supplierPerformanceDtlTransFB" type="mms.transactions.controller.fb.SupplierPerformanceDtlTransFB" method="post">
    <div class="errMsg"     id="errMsg"><bean:write name="supplierPerformanceDtlTransFB" property="strErrMsg"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="supplierPerformanceDtlTransFB" property="strWarningMsg"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="supplierPerformanceDtlTransFB" property="strNormalMsg"/></div>
    
   
       <tag:tab tabLabel="Supplier Performance Detail (Backlog)" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>

    <div id="Staff" style="display:none">
      <tag:tab tabLabel="Supplier Performance Detail (Backlog)" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>
    </div>
	
  
 <table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
		<tr class="HEADER"> 
			 <td colspan="4"></td>
	   
		     <td align="right" >
		     	<span>
		     		<html:checkbox property="strViewCheckBox" name="supplierPerformanceDtlTransFB" value="1" onclick="openViewPage();">View</html:checkbox>
		     	</span>
		     </td>	    
	  </tr>
  </table>
  
<!-- View -->
  <table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px"> 
  	
 </table>	
  
 <table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">

<!-- Drug Ware House Name and PO NO -->
	<tr> 
          
	     <td width="25%" class="LABEL"><font color="red">*</font>Store Name</td>
             <td width="25%" class="CONTROL">
         
	          <html:select name="supplierPerformanceDtlTransFB" property="strDrugWareHouseName" styleClass="comboNormal" onchange="getPoNoCombo();"    >
	                 <bean:write name="supplierPerformanceDtlTransFB" property="strDrugWareHouseNameCmb" filter="false"/>
	          </html:select>
            </td>   
           
           
            <td width="25%" class="LABEL"><font color="red">*</font>PO No</td>
         <td width="25%" class="CONTROL">
    		<div id="poNoComboDivId">     
	          <html:select name="supplierPerformanceDtlTransFB" property="strPoNo" styleClass="comboMax" onchange="getSubStore();"   >
	                 <bean:write name="supplierPerformanceDtlTransFB" property="strPoNoCmb" filter="false"/>
	                 <option value="0">Select Value</option>
	          </html:select>
	        </div>  
         </td>   
        </tr>
 	 <tr> 
  

<!-- Challan No and Item No. -->
  <tr> 
  <td width="25%" class="LABEL"><font color="red">*</font>Challan No</td>
         <td width="25%" class="CONTROL">
    		<div id="challanNoComboDivId">     
	          <html:select name="supplierPerformanceDtlTransFB" property="strChallanNo" styleClass="comboNormal" onchange="getItemName();"   >
	                 <bean:write name="supplierPerformanceDtlTransFB" property="strChallanNoCmb" filter="false"/>
	                 <option value="0">Select Value</option>
	          </html:select>
	        </div>  
         </td>   
        
         
	     <td width="25%" class="LABEL"><font color="red">*</font>Item Name</td>
         <td width="25%" class="CONTROL">
    		<div id="itemComboDivId">     
	          <html:select name="supplierPerformanceDtlTransFB" property="strItemId" styleClass="comboNormal"   >
	                 <bean:write name="supplierPerformanceDtlTransFB" property="strItemNameCmb" filter="false"/>
	                 <option value="0">Select Value</option>
	          </html:select>
	        </div>  
         </td>   
           
   </tr>
   
    <tr> 
 
               
	     <td width="25%" class="LABEL"><font color="red">*</font>Batch Name</td>
         <td width="25%" class="CONTROL">
    		<div id="batchComboDivId">     
	          <html:select name="supplierPerformanceDtlTransFB" property="strBatchNo" styleClass="comboNormal">	                
	                 <option value="0">Select Value</option>
	          </html:select>
	        </div>  
         </td>   
         
         
         <td width="50%" class="CONTROL" colspan="2"></td>   
           
   </tr>
   
   <tr id="showQtyDivId" style="display: none;">
	   	 <td width="25%" class="LABEL">Ordered Qty</td>
	   	 
         <td width="25%" class="CONTROL">
         	<div id="strOrderedQtyDivId">	
        		<bean:write name="supplierPerformanceDtlTransFB" property="strOrderedQty" filter="false" /> 
        	</div> 
         </td>
         
         <td width="25%" class="LABEL">Accepted Qty</td>
	   	 
         <td width="25%" class="CONTROL">	
        	 <input type="text" name="strAcceptedQty" maxlength="9" onkeypress="return validateData(event,5);" onblur="chkAcceptedQtyLessThanOrderedQty();"/>
         </td>
         
   </tr>
  </table> 
   
   <table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">

		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="supplierItemDtlsDivIdPlusId" align="left" style="display:none;">
				<img src="../../hisglobal/images/plus.gif" onClick="showView('supplierItemDtlsDivId');" style="cursor: pointer; " />
				 Supplier Performance Detail (Backlog)</div>
			<div id="supplierItemDtlsDivIdMinusId" style="display:block;" align="left"><img src="../../hisglobal/images/minus.gif"
				onClick="hideView('supplierItemDtlsDivId');" style="cursor: pointer; " /> Supplier Performance Detail</div>
			</td>
		</tr>
	</table>
	
	<div id="supplierItemDtlsDivId" style="display:block;">
	<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
	        <tr style="display: none;">
				<td class="LABEL" width="50%"><div align="left">1.	Whether Medicines supplied with test report</div></td>
				<td class="CONTROL" width="50%">
					<input type="radio" name="strWhetherMedicinesWithTestReport" value="1"  onClick="showReportNoAndDate(); " />Yes
					<input type="radio" name="strWhetherMedicinesWithTestReport" value="0" onClick="showReportNoAndDate();" />No
				</td>
			</tr>
			
			
				
			<tr id="showReportId" style="display:none;">
				<td class="LABEL" width="50%"><div align="left">1. Test Report No. and Date of Medicines Supplied<font color="red">*</font></div></td>
				<td class="CONTROL" width="50%">
					 <input type="text" class="txtFldMax" name="strReportNumber" onkeypress="return validateData(event,16);" maxlength="25">/					 
					 <dateTag:date name="strReportDate" value="${supplierPerformanceDtlTransFB.strCtDate}" />
				</td>
			</tr>
	            
            
			<tr>
				<td class="LABEL" width="50%"><div align="left">1.	Whether Test Report Submitted</div></td>
				<td class="CONTROL" width="50%">
					<input type="radio" name="strWhetherTestReportSubmitted" value="1"  />Yes
					<input type="radio" name="strWhetherTestReportSubmitted" value="0"  />No</td>
				
			</tr>	
			
			<tr>
				<td class="LABEL" width="50%"><div align="left">2.	Whether Medicines/Packaging are in good condition</div></td>
				<td class="CONTROL" width="50%">
					<input type="radio" name="strWhetherMedicinesInGoodCondition" value="1"  />Yes
					<input type="radio" name="strWhetherMedicinesInGoodCondition" value="0"  />No</td>
				
			</tr>		
			<tr>		
				<td class="LABEL" width="50%"><div align="left">3.	Whether Rajsthan Govt. Supply Not for Sale & Logogram printed</div></td>
				<td class="CONTROL" width="50%">
					<input type="radio" name="strWhetherSupplyNotForSale" value="1"  />Yes
					<input type="radio" name="strWhetherSupplyNotForSale" value="0"  />No</td>
				
			</tr>
			
			<tr>
				<td class="LABEL" width="50%"><div align="left">4.	Brand Name Not Written</div></td>
				<td class="CONTROL" width="50%">
					<input type="radio" name="strWhetherBrandNameNotWritten" value="1"  />Yes
					<input type="radio" name="strWhetherBrandNameNotWritten" value="0"  />No
				</td>
			</tr>
				
			<tr>	
				<td class="LABEL" width="50%"><div align="left">5.	Price(MRP) not printed/Visible</div></td>
				<td class="CONTROL" width="50%">
				<input type="radio" name="strWhetherMRPPrint" value="1"  />Yes
					<input type="radio" name=strWhetherMRPPrint value="0" />No
				</td>
			</tr>
			
			<tr>
				<td class="LABEL" width="50%"><div align="left">6.	Page No. of Stock Register where entry has been made<font color="red">*</font></div></td>
				<td class="CONTROL" width="50%">
					<input type="text" name="strPageNo" maxlength="5" onkeypress="return validateData(event,5);"/>
				</td>
				
			</tr>
			
			
			<tr>
				<td class="LABEL" width="25%"><div align="left">7.	Remarks(if any)</div></td>
				<td class="CONTROL" colspan="2">
					<textarea rows="2" cols="25" name="strRemarks"></textarea>
				</td>
				
				<td class="LABEL" width="50%"> </td>
				
			</tr>
			
		</table>
		</div>
 
 

		
	

	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1"> 
	 <tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>	
	<table  class="TABLEWIDTH" align="center">
	  <tr>
			<td align="center">
	                <img style="cursor:pointer;cursor:pointer" title="Click to Save Record" src="../../hisglobal/images/btn-sv.png"  onClick=" return validate1();" onkeypress="if(event.keyCode==13) validate1();"/>
	                <img style="cursor:pointer;cursor:pointer" title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="document.forms[0].reset(),clearMsg('INITVAL')" onkeypress="if(event.keyCode==13) document.forms[0].reset(),clearMsg('INITVAL');">
	                <img style="cursor: pointer; " title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="cancelPage()" onkeypress="if(event.keyCode==13) cancelPage()" />
			</td>
		</tr>
	</table>	
    
     <html:hidden name="supplierPerformanceDtlTransFB" property="hmode" />
     <html:hidden name="supplierPerformanceDtlTransFB" property="strStoreId" />
     
    <html:hidden name="supplierPerformanceDtlTransFB" property="strDrugWareHouseNameCmb"  />
   
   
     <html:hidden name="supplierPerformanceDtlTransFB" property="strSubStoreCmb" />
     
      <html:hidden name="supplierPerformanceDtlTransFB" property="strCtDate" value="${supplierPerformanceDtlTransFB.strCtDate}"/>
    
    <html:hidden name="supplierPerformanceDtlTransFB" property="strGoDetailsFlag" value="0" />
    
	<html:hidden name="supplierPerformanceDtlTransFB" property="strOrderedQty"  value="${supplierPerformanceDtlTransFB.strOrderedQty}" />
   <html:hidden name="supplierPerformanceDtlTransFB" property="strResetOrderedQty"  value="${supplierPerformanceDtlTransFB.strResetOrderedQty}" />
     
</html:form>
	<tag:autoIndex></tag:autoIndex>   

<combPer:cmbPers />
</body>
</html>
