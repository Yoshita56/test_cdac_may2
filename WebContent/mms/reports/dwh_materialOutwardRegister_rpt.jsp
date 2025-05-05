<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Outward Register Report</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="Javascript" src="../../hisglobal/js/time.js"></script>

<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>

<script language="Javascript" src="../../mms/js/dwh_materialOutwardRegister_rpt.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript"> 

</script>

</head>
<body >
<html:form action="/reports/MaterialOutwardRegisterRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="materialOutwardRegisterRptFB" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="materialOutwardRegisterRptFB" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="materialOutwardRegisterRptFB" property="strWarningMsg"/></div>


	<tag:tab tabLabel="Outward Register Report" selectedTab="FIRST" align="center" width="TABLEWIDTH">
                  </tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4"></td>
			
	</tr>
	</table>
			
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" > 	
	
	
	
	
	
<%-- Drug warehouse Name	 --%>		
		<tr>
			<td width="50%" colspan="2" class="LABEL">Store Name</td>
			<td width="50%" colspan="2" class="CONTROL">
			<div id="strStoreDivId" >
				<select name="strStoreId" class="comboNormal" onChange="getToStoreCmb();">
					<bean:write name="materialOutwardRegisterRptFB" property="strStoreValues" filter="false"/>
				</select>
			</div>				
			</td>
		</tr>
<!-- To Store 		-->
		<tr>
			<td width="50%" colspan="2" class="LABEL">To Store</td>
			<td width="50%" colspan="2" class="CONTROL">
			<div id="strToStoreDivId" >
				<select name="strToStoreId" class="comboNormal" >
					<option value="0">All</option>
				</select>
			</div>				
			</td>
		</tr>
		


 
         <tr>
			<td class="LABEL" colspan="2"><font color="red">*</font>From Date</td>
			<td class="CONTROL" colspan="2"><dateTag:date name="strFromDate" value="${materialOutwardRegisterRptFB.strCurrentDate}" /></td>
			</tr>
			<tr>
			<td class="LABEL" colspan="2"><font color="red">*</font>To Date</td>
			<td class="CONTROL" colspan="2"><dateTag:date name="strToDate" value="${materialOutwardRegisterRptFB.strCurrentDate}" /></td>
		</tr>
		<!-- <tr>
		  
		  <td class="CONTROL" colspan="4"><div id='id' align='center'><!--<img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="genrateIssueDtlHlp();" />-->
		 <!--  <a href="#" class="button" id="" onclick='genrateIssueDtlHlp();'><span class="generate">Generate</span></a>
		  </div></td>
		</tr>		
		 -->

		<tr >
			<td width="50%" colspan="2" class="LABEL">Report Format</td>
			<td width="50%" colspan="2" class="CONTROL">
				<select name="strReportFormat"  onchange="">
					<option value="html">Html</option>
					<option value="pdf" >Pdf</option>
					<option value="xls" >Excel</option>
				</select>
			</td>
			
		</tr> 
		
		<tr >
			<td width="50%" colspan="2" class="LABEL">Footer Required</td>
			<td width="50%" colspan="2" class="CONTROL">
				<html:checkbox property="strIsFooter" name="materialOutwardRegisterRptFB" value="1"></html:checkbox>
			</td>
			
		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">User Remarks</td>
			<td width="50%" colspan="2" class="CONTROL">
				<input class="txtFldMax" type="text" name="strUserRemarks" >
			</td>
			
		</tr>
		
	</table>
	
	
	
	<div id="consolidatedPODetailDIV"></div>
	
	
	<div id="consolidatedChallanDetailDIV"></div>
	 
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
	
	<tr class="FOOTER">
			 <td colspan="4"><font color='red'>*</font>Mandatory Field </td>
		</tr>
		</table>
<!-- <div id="showButtonID" style="display:none;"> 
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/print_tab.gif" onClick="return printMainScreen();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="document.forms[0].reset();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table>
</div>-->
<br>
<div align="center" id="showButtonID">					 
					 	<a href="#" class="button" id="" onclick='return validate2();'><span class="generate">Generate</span></a>
						<a href="#" class="button"	onclick="resetPage()"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelFunc();"><span class="cancel">Cancel</span></a>
				</div>
	
<input type="hidden" name="hmode"/>
<input type="hidden" name="strEndFinancialYearTemp" value="${materialOutwardRegisterRptFB.strEndFinancialYearTemp}"/>
<input type="hidden" name="strCurrentDate" value="${materialOutwardRegisterRptFB.strCurrentDate}"/>

<input type="hidden" name="strStoreName" value="${materialOutwardRegisterRptFB.strStoreName}"/>
<input type="hidden" name="strProcRelatedValue" />
<input type="hidden" name="storeId" />


<%-- Pop up Main Screen --%>
<div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDivMain" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
           <div id="issueDtlsDivIdMain" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>


<%-- Pop up 1 --%>
<div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv1" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
           <div id="issueDtlsDivId" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>
   
   
<%-- Pop up 2 --%>
<div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv2" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
           <div id="issueDtlsDivId2" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>   

<%-- Pop up 2 --%>
<div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv3" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
           <div id="issueDtlsDivId3" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>   
   
   
   <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv4" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
           <div id="issueDtlsDivId4" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>   

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>