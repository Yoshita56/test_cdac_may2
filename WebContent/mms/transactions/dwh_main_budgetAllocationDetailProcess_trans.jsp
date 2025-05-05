<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="combPer"%>

<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>

<!-- 
/**
 * Developer : Vivek Aggarwal
 * Version : 1.0
 * Date : 08-Aug-2011
 * Modify Date : 
*/
-->
<html>
<head>
<meta charset=UTF-8">
<title>Budget Allocation Detail Process</title>
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
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/patientListing.js"></script>
<script language="JavaScript" src="../js/dwh_main_budgetAllocationDetailProcess_trans.js"></script>
</head>
<body onload="showBudgetDetails();">
<html:form action="/transactions/BudgetAllocationDetailProcessTransCNT.cnt"  name="budgetAllocationDetailProcessTransFB" type="mms.transactions.controller.fb.BudgetAllocationDetailProcessTransFB" method="post">
    <div class="errMsg"     id="errMsg"><bean:write name="budgetAllocationDetailProcessTransFB" property="strErrMsg"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="budgetAllocationDetailProcessTransFB" property="strWarningMsg"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="budgetAllocationDetailProcessTransFB" property="strNormalMsg"/></div>
    
   
       <tag:tab tabLabel="Budget Allocation Detail Process" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>

    <div id="Staff" style="display:none">
      <tag:tab tabLabel="Budget Allocation Detail Process" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>
    </div>
	
  
 <table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
		<tr class="HEADER"> 
			 <td colspan="4"></td>
	   
		     <td align="right" >
		     	<span>
		     		<html:checkbox property="strViewCheckBox" name="budgetAllocationDetailProcessTransFB" value="1" onclick="openViewPage();">View</html:checkbox>
		     	</span>
		     </td>	    
	  </tr>
  </table>
  
<!-- View -->
  <table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px"> 
  	
 </table>	
  
<!-- Financial Year  -->
 <table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
	<tr> 
         <td width="25%" class="LABEL"><font color="red">*</font>Financial Year</td>
         <td width="25%" class="CONTROL">
	          <html:select name="budgetAllocationDetailProcessTransFB" property="strFinancialYear" styleClass="comboNormal" onchange="clearData();" >
	          	<html:option value="1"> <bean:write name="budgetAllocationDetailProcessTransFB" property="strCurrentFinancialYear" filter="false"/></html:option>
				<html:option value="2"> <bean:write name="budgetAllocationDetailProcessTransFB" property="strNextFinancialYear" filter="false"/></html:option>	          	
	          </html:select>
         </td>   
	     <td width="25%" class="LABEL"><font color="red">*</font>DDW Name</td>
             <td width="25%" class="CONTROL">
         
	          <html:select name="budgetAllocationDetailProcessTransFB" property="strDrugWareHouseName" styleClass="comboNormal" onchange="clearData();"   >
	                 <bean:write name="budgetAllocationDetailProcessTransFB" property="strDrugWareHouseNameCmb" filter="false"/>
	          </html:select>
            </td>   
           
        </tr>
 	 <tr> 
  
<!-- Drug Ware House Name  -->
  <tr> 
         <td width="25%" class="LABEL"><font color="red">*</font>Sub-Store Type</td>
         <td width="25%" class="CONTROL">
         
	          <html:select name="budgetAllocationDetailProcessTransFB" property="strDWHSubTypeId" styleClass="comboNormal" onchange="getSubStore();"   >
	                 <bean:write name="budgetAllocationDetailProcessTransFB" property="strDWHSubTypeCmb" filter="false"/>
	          </html:select>
         </td>   
         
	     <td width="25%" class="LABEL"><font color="red">*</font>Sub-Store</td>
         <td width="25%" class="CONTROL">
         
	         <div id="subStoreDivId">
	         <logic:equal name="budgetAllocationDetailProcessTransFB" property="strGoDetailsFlag" value="0">
		         <html:select styleClass="comboMax" name="budgetAllocationDetailProcessTransFB" property="strSubStoreId"  >		
		       		<option value='0'>Select Value</option>
					<bean:write name="budgetAllocationDetailProcessTransFB" property="strSubStoreCmb" filter="false"/>
				 </html:select>
			</logic:equal>	 

			
			<logic:equal name="budgetAllocationDetailProcessTransFB" property="strGoDetailsFlag" value="1">
		         <html:select styleClass="comboMax" name="budgetAllocationDetailProcessTransFB" property="strSubStoreId" onchange="clearBudgetFields();">		       		
					<bean:write name="budgetAllocationDetailProcessTransFB" property="strSubStoreCmb" filter="false"/>
				 </html:select>
			</logic:equal>	 
			
		     </div>
         </td>   
           
   </tr>
   <tr> 
         
         <td colspan="4" class="CONTROL">
         	<div align="center">
         		<html:img src="../../hisglobal/images/Go.png" style="cursor:pointer" onclick="getBudgetDetails();" />
         	</div>
         </td>
	    
	      
           
   </tr>
   
     <tr id="newBudgetDetailDivId" style="display: none;"> 
		  <td width="25%" class="LABEL" colspan="1"><font size="2" color="red">*</font>Current Year New Budget Allocated</td>
		  	<td width="25%" class="CONTROL" colspan="1">
		  		<html:text name="budgetAllocationDetailProcessTransFB" property="strNewAllocatedBudget" onkeypress="return(numericWithTwoDecimalPlaces(this,',','.',event));" ></html:text>
		  	</td>
		   <td width="50%" class="CONTROL" colspan="2">	</td>	
		  	
	</tr>	
   
   	
  
<!-- Previous Year Remaining Budget & Last Allocated Budget   -->
		<logic:equal value="PREVBUDGETDETAILS" name="budgetAllocationDetailProcessTransFB" property="hmode">
		
			<tr class="HEADER" id="prevBudgetDtlsDivId"> 
				<td colspan="4">Last Budget Detail</td>
	   		</tr>
		
		<tr id="budgetDetailsId1" > 
	         <td width="25%" class="LABEL">Previous Year Un-Utilized Budget(A)</td>
	         <td width="25%" class="CONTROL"><bean:write property="strPreviousYearRemainingBudget" name="budgetAllocationDetailProcessTransFB" filter="false" /></td>   
	         <html:hidden name="budgetAllocationDetailProcessTransFB" property="strPreviousYearRemainingBudget" />
	         
	         <td width="25%" class="LABEL">Current Year Budget Allocated(B)</td>
	         <td width="25%" class="CONTROL"><bean:write property="strLastAllocatedBudget" name="budgetAllocationDetailProcessTransFB" filter="false" /></td>
	         <html:hidden name="budgetAllocationDetailProcessTransFB" property="strLastAllocatedBudget" />	          
        </tr>
        
        <tr id="budgetDetailsId4" > 
	         <td width="25%" class="LABEL">Current Year Total Budget(A+B)</td>
	         <td width="25%" class="CONTROL"><bean:write property="strCurrentYearTotalBudget" name="budgetAllocationDetailProcessTransFB" filter="false" /></td>   
	         <html:hidden name="budgetAllocationDetailProcessTransFB" property="strCurrentYearTotalBudget" />
	         
	         <td width="25%" class="LABEL">Current Year Utilized Budget(C)</td>
	         <td width="25%" class="CONTROL"><bean:write property="strCurrentYearUtilizedBudget" name="budgetAllocationDetailProcessTransFB" filter="false" /></td>
	         <html:hidden name="budgetAllocationDetailProcessTransFB" property="strCurrentYearUtilizedBudget" />	          
        </tr>
        
 	 </logic:equal>
	
<!-- New Allocated Budget -->
	<logic:equal value="PREVBUDGETDETAILS" name="budgetAllocationDetailProcessTransFB" property="hmode">
	
	<tr class="HEADER" id="modifiedBudgetDtlsDivId"> 
				<td colspan="4">Modified Budget Detail</td>
	   		</tr>
	
	  <tr id="budgetDetailsId2" > 
		  <td width="25%" class="LABEL"><font size="2" color="red">*</font>Current Year New Budget Allocated(D)</td>
		  	<td width="25%" class="CONTROL">
		  		<html:text name="budgetAllocationDetailProcessTransFB" property="strModifiedAllocatedBudget" maxlength="8" onblur="return isNumber(event);" onkeypress="return(numericWithTwoDecimalPlaces(this,',','.',event));"></html:text>
		  	</td>
		  
		  <td width="25%" class="LABEL"><font size="2" color="red">*</font>Current Year Total Budget Available (A+D)</td>
		  <td width="25%" class="CONTROL">
		  		<div id="currentYrTotalBudgetAvailableDivId">
					<bean:write name="budgetAllocationDetailProcessTransFB" property="strPreviousYearRemainingBudget" filter="false"/>
				</div>			  		
		  </td> 	
	  </tr>
	  	
	  <tr id="budgetDetailsId5">  
	  
	   		<td width="25%" class="LABEL"><font size="2" color="red">*</font>Current Year Un-Utilized Available Budget (A+D-C)</td>
		  	<td width="25%" class="CONTROL">
				<div id="currentYrTotalUnutilizedBudgetAvailableDivId">
					<bean:write name="budgetAllocationDetailProcessTransFB" property="strCurrentYrTotalUnutilizedBudgetAvailable" filter="false"/>
				</div>	
		  	</td>
		  	<td colspan="2" class="CONTROL"></td>
		  	
	  </tr>
	  
	  </logic:equal>
<!-- Remarks -->
	 <logic:equal value="PREVBUDGETDETAILS" name="budgetAllocationDetailProcessTransFB" property="hmode">
	 	 <tr id="budgetDetailsId3" > 
	 	 	
	 	<logic:greaterThan name="budgetAllocationDetailProcessTransFB" property="strLastAllocatedBudget" value="0">
	 		  	<td width="25%" class="LABEL"><font size="2" color="red">*</font>Remarks</td>
	 	 </logic:greaterThan>	
	 	 
	 	 <logic:lessEqual name="budgetAllocationDetailProcessTransFB" property="strLastAllocatedBudget" value="0">
	  		<td width="25%" class="LABEL"><font size="2" color="red">*</font>Remarks</td>
	  	</logic:lessEqual>
	  	
	  	<td width="25%" class="CONTROL">  		
	  		<html:textarea name="budgetAllocationDetailProcessTransFB" property="strRemarks" onkeypress="return validateData(event,18);"></html:textarea>
	  	</td>
	  	
	  	<td width="25%" class="LABEL"></td>
	         <td width="25%" class="CONTROL"></td> 
	  </tr>
  		</logic:equal>
  </table>

		
	

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
    
     <html:hidden name="budgetAllocationDetailProcessTransFB" property="hmode" />
     <html:hidden name="budgetAllocationDetailProcessTransFB" property="strStoreId" />
     
    <html:hidden name="budgetAllocationDetailProcessTransFB" property="strDrugWareHouseNameCmb"  />
    <html:hidden name="budgetAllocationDetailProcessTransFB" property="strCurrentFinancialYear" />
    <html:hidden name="budgetAllocationDetailProcessTransFB" property="strNextFinancialYear" />
     <html:hidden name="budgetAllocationDetailProcessTransFB" property="strSubStoreCmb" />
    
    <html:hidden name="budgetAllocationDetailProcessTransFB" property="strGoDetailsFlag" value="0" />
    

    <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         <div id="searchItemsDtlsDivId" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>
     
</html:form>
	<tag:autoIndex></tag:autoIndex>   

<combPer:cmbPers />
</body>
</html>
