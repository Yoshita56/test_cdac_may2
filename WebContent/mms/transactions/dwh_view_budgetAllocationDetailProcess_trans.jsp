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
<title>Budget Allocation Detail Process View</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../mms/css/transaction.css" rel="stylesheet" type="text/css">

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
    
   
       <tag:tab tabLabel="Budget Allocation Detail Process View" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>

    <div id="Staff" style="display:none">
      <tag:tab tabLabel="Budget Allocation Detail Process View" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>
    </div>
	
 <table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
	  <tr class="HEADER"> 
	     <td colspan="4">
		    
	    </td>
	  </tr>
  </table>
  
  
<!-- Financial Year  -->
 <table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
	
   
   
<!--   -->
	
        	
	<tr> 
    	 <td width="25%" class="LABEL"><font color="red">*</font>Financial Year</td>
         <td width="25%" class="CONTROL">
	          <html:select name="budgetAllocationDetailProcessTransFB" property="strFinancialYear" styleClass="comboNormal" onchange="clearViewData();" >
	          	 <bean:write name="budgetAllocationDetailProcessTransFB" property="strFinancialYearCombo" filter="false"/>	          	
	          </html:select>
         </td>   
               
	     <td width="25%" class="LABEL"><font color="red">*</font>Store Name</td>
             <td width="25%" class="CONTROL">
         
	          <html:select name="budgetAllocationDetailProcessTransFB" property="strDrugWareHouseName" styleClass="comboNormal" onchange="clearData();"   >
	                 <bean:write name="budgetAllocationDetailProcessTransFB" property="strDrugWareHouseNameCmb" filter="false"/>
	          </html:select>
            </td>   
           
        </tr>
 	 <tr> 
  
<!-- Drug Ware House Name  -->
  <tr> 
         <td width="25%" class="LABEL">Sub-Store Type</td>
         <td width="25%" class="CONTROL">
         
	          <html:select name="budgetAllocationDetailProcessTransFB" property="strDWHSubTypeId" styleClass="comboNormal" onchange="getSubStore();"   >
	                 <bean:write name="budgetAllocationDetailProcessTransFB" property="strDWHSubTypeCmb" filter="false"/>
	          </html:select>
         </td>   
         
	     <td width="25%" class="LABEL">Sub-Store</td>
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
         		<html:img src="../../hisglobal/images/Go.png" style="cursor:pointer" onclick="getBudgetDetailsView();" />
         	</div>
         </td>
	    
	      
           
   </tr>	


<!--   -->
   
  </table>
	   
	
			
			<div id="budgetDetailsViewId"></div>	
			
				




		
	

	<table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1"> 
	 <tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>	
	<table  class="TABLEWIDTH" align="center">
	  <tr>
			<td align="center">
	                <img style="cursor: pointer; " title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="window.close();" onkeypress="if(event.keyCode==13) window.close();" />
			</td>
		</tr>
	</table>	
    
     <html:hidden name="budgetAllocationDetailProcessTransFB" property="hmode" />
     <html:hidden name="budgetAllocationDetailProcessTransFB" property="strStoreId" />
     
    <html:hidden name="budgetAllocationDetailProcessTransFB" property="strDrugWareHouseNameCmb"  />
    <html:hidden name="budgetAllocationDetailProcessTransFB" property="strCurrentFinancialYear" />
    <html:hidden name="budgetAllocationDetailProcessTransFB" property="strNextFinancialYear" />
	<html:hidden name="budgetAllocationDetailProcessTransFB" property="strGoDetailsFlag" value="1" />

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
