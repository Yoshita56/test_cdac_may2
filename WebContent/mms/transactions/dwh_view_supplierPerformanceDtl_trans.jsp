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
<title>SUPPLIER PERFORMANCE DETAIL (BACKLOG)</title>
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

<script language="JavaScript" src="../js/dwh_main_supplierPerformanceDtl_trans.js"></script>

</head>
<body onload="showBudgetDetails();">
<html:form action="/transactions/SupplierPerformanceDtlTransCNT.cnt"  name="supplierPerformanceDtlTransFB" type="mms.transactions.controller.fb.SupplierPerformanceDtlTransFB" method="post">
    <div class="errMsg"     id="errMsg"><bean:write name="supplierPerformanceDtlTransFB" property="strErrMsg"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="supplierPerformanceDtlTransFB" property="strWarningMsg"/></div>
	<div class="normalMsg"  id="normalMsg"><bean:write name="supplierPerformanceDtlTransFB" property="strNormalMsg"/></div>
    
   
       <tag:tab tabLabel="SUPPLIER PERFORMANCE DETAIL(BACKLOG) &gt;&gt; View" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>

    <div id="Staff" style="display:none">
      <tag:tab tabLabel="SUPPLIER PERFORMANCE DETAIL(BACKLOG)&gt;&gt; View" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>
    </div>
	
 <table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
	  <tr class="HEADER"> 
	     <td colspan="4">
		    
	    </td>
	  </tr>
  </table>
  
  

 <table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
		<tr> 
	  
	<!-- Drug Ware House Name  -->	
		<td width="25%" class="LABEL"><font color="red">*</font>Store Name</td>
	         <td width="25%" class="CONTROL">
	         
	      <html:select name="supplierPerformanceDtlTransFB" property="strDrugWareHouseName" styleClass="comboMax" onchange="clearViewData();"   >
	             <bean:write name="supplierPerformanceDtlTransFB" property="strDrugWareHouseNameCmb" filter="false"/>
	      </html:select>
	    </td>   
         
         
	     <td width="25%" class="LABEL"><font color="red">*</font>Report Type</td>
	     <td width="25%" class="CONTROL">
	       <html:select name="supplierPerformanceDtlTransFB" property="strReportType" styleClass="comboNormal" onchange="getDateDiv();clearViewData();" >
	       	<html:option  value='1'>Pending</html:option>  
	       	<html:option  value='2'>Completed</html:option>      	
	       </html:select>
	     </td>   
	       
           
        </tr>
 	 

 
     	<tr id="completedReportDivId" style="display: none;">
			<td class="LABEL" colspan="1"><font color="red">*</font>From Date</td>
			<td class="CONTROL" colspan="1">
				<dateTag:date name="strFromDate" value="${supplierPerformanceDtlTransFB.strCtDate}" />
			</td>
		
			<td class="LABEL" colspan="1"><font color="red">*</font>To Date</td>
			<td class="CONTROL" colspan="1">
				<dateTag:date name="strToDate" value="${supplierPerformanceDtlTransFB.strCtDate}" />
			</td>
		</tr>    
	     
           <tr>
           		  <td colspan="4" class="LABEL">
	           		  <div align="center">
	           		  		<html:img src="../../hisglobal/images/Go.png" style="cursor:pointer" onclick="getSupplierPerformanceDetailsView();" />
	           		  </div>		
         		  </td>
           </tr>
  
  </table>
	   
	
			
			<div id="supplierDetailsViewId"></div>	
			
				




		
	

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
    
     <html:hidden name="supplierPerformanceDtlTransFB" property="hmode" />
     <html:hidden name="supplierPerformanceDtlTransFB" property="strStoreId" />
     
    <html:hidden name="supplierPerformanceDtlTransFB" property="strDrugWareHouseNameCmb"  />

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
