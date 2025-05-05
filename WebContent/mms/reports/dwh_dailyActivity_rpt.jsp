<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Daily Activity Report</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	


<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="Javascript" src="../../hisglobal/js/time.js"></script>

<script language="Javascript" src="../../mms/js/dwh_dailyActivity_rpt.js"></script>


</head>
<body >
<html:form action="/reports/DailyActivityRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="dailyActivityRptFB" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="dailyActivityRptFB" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="dailyActivityRptFB" property="strWarningMsg"/></div>


	<tag:tab tabLabel="Daily Activity Report" selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4"></td>
			
	</tr>
	</table>
			
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" > 	
	
		<tr>
			<td width="50%" colspan="2" class="LABEL">District Drug Warehouse Name</td>
			<td width="50%" colspan="2" class="CONTROL">
			<div id="strStoreDivId" >
				<select name="strStoreId" class="comboNormal" onChange="ClearDiv();">
					<bean:write name="dailyActivityRptFB" property="strStoreValues" filter="false"/>
				</select>
			</div>				
			</td>
		</tr>
		
		
	
		
		
     </table>
     	
	
     
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">

 
         <tr>
			<td class="LABEL" colspan="1"><font color="red">*</font>From Date</td>
			<td class="CONTROL" colspan="1"><dateTag:date name="strFromDate" value="${dailyActivityRptFB.strCurrentDate}" /></td>
			<td class="LABEL" colspan="1"><font color="red">*</font>To Date</td>
			<td class="CONTROL" colspan="1"><dateTag:date name="strToDate" value="${dailyActivityRptFB.strCurrentDate}" /></td>
		</tr>
		<tr>
		  
		  <td class="CONTROL" colspan="4"><div id='id' align='center'><img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="genrateDWHList();" /></div></td>
		</tr>		
		
      
		
		
		
		
	</table>
	<div id="consolidatedPODetailDIV"></div>
	
	
	<div id="consolidatedChallanDetailDIV"></div>
	
	<div id="consolidatedReceviedDetailDIV"></div>
	
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
	
	<tr class="FOOTER">
			 <td colspan="4"><font color='red'>*</font>Mandatory Field </td>
		</tr>
		</table>
 <div id ="buttonDivID" style="display:none;">
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/print_tab.gif" onClick="getDailyActivityPrint();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="clearPage();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	
	</table>
	</div>
				<input type="hidden" name="hmode"/>
				<input type="hidden" name="strEndFinancialYearTemp" value="${dailyActivityRptFB.strEndFinancialYearTemp}"/>
				<input type="hidden" name="strCurrentDate" value="${dailyActivityRptFB.strCurrentDate}"/>
				
				<input type="hidden" name="strStoreName" value="${dailyActivityRptFB.strStoreName}"/>
				<input type="hidden" name="strTmpStoreID">
				<input type="hidden" name="strProcRelatedValue">


<div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv1" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
           <div id="IssueVoucherDtlPopUpOneDivId" style="display:block;"></div>
           
       </td>
     </tr>
    </table>
   </div>
   
   
   <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv2" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         
           <div id="InstituteIssueDtlsDivId" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>
   
    <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv3" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         
           <div id="IssueNumberDtlsDivId" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>
  <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv4" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         
           <div id="recieveVoucherDetails" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>
   
   <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv11" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         
           <div id="samplesenddtl" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>
   
    <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv12" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         
           <div id="samplesenditembatchdtl" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>
   
   
   <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv5" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         
           <div id="poChallanDetails" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>
   
    <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv10" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         
           <div id="challanItemsDetails" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>
   


<div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv6" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>         
           <div id="activityPrint" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>
   
   
  


</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>