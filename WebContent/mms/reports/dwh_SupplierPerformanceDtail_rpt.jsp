<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Supplier Performance Detail Report</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
	
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

<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script language="Javascript" src="../../hisglobal/js/time.js"></script>

<script language="Javascript" src="../../mms/js/dwh_supplierPerformanceDtail_rpt.js"></script>

</head>
<body onLoad="hideMenuFrame();">
<html:form action="/reports/SupplierPerformanceDtailRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="SupplierPerformanceDtailRptFB" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="SupplierPerformanceDtailRptFB" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="SupplierPerformanceDtailRptFB" property="strWarningMsg"/></div>


	<table width='1150' align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4"><strong>SUPPLIER PERFORMANCE DETAIL REPORT</strong></td>
			
	</tr>
	</table>
			
	<table width='1150' align="center" cellspacing="1px" cellpadding="1px" > 	
	
		<tr>
			<td width="25%" colspan="1" class="LABEL"><font color="red">*</font>Supplier Name</td>
			<td width="25%" colspan="1" class="CONTROL">
			<div id="strStoreDivId" >
				<select name="strSupplierId" class="comboMax" onChange="getPOCombo();">
					<bean:write name="SupplierPerformanceDtailRptFB" property="strManufactureCombo" filter="false"/>
				</select>
			</div>				
			</td>
			<td width="25%" colspan="1" class="LABEL">PO No</td>
			<td width="25%" colspan="1" class="CONTROL">
			<div id="strPODivId" >
				<select name="strPoNumber" class="comboNormal" >
					<option value="0">All</option>
				</select>
			</div>				
			</td>
		</tr>		
		
		<tr>
			<td width="25%" colspan="1" class="LABEL">Group Name</td>
			<td width="25%" colspan="1" class="CONTROL">
			<div id="strGroupDivId" >
				<select name="strGroupId" class="comboNormal" onchange="getDrugCmb();">
					<bean:write name="SupplierPerformanceDtailRptFB" property="strGroupCombo" filter="false"/>
				</select>
			</div>				
			</td>
		
			<td width="25%" colspan="1" class="LABEL">Drug Name</td>
			<td width="25%" colspan="1" class="CONTROL">
			<div id="strDrugDivId" >
				<select name="strDrugId" class="comboNormal" >
					<bean:write name="SupplierPerformanceDtailRptFB" property="strDrugCombo" filter="false"/>
				</select>
			</div>				
			</td>
		</tr>
	
		
		
     </table>
	<table border="0" width='1150' align="center" cellspacing="1px" cellpadding="1px">

 
         <tr>
			<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>From Date</td>
			<td class="CONTROL" width="25%" colspan="1"><dateTag:date name="strFromDate" value="${SupplierPerformanceDtailRptFB.strCurrentDate}" /></td>
			<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>To Date</td>
			<td class="CONTROL" width="25%" colspan="1"><dateTag:date name="strToDate" value="${SupplierPerformanceDtailRptFB.strCurrentDate}" /></td>
		</tr>
		<tr>
		  
		  <td class="CONTROL" colspan="4"><div id='id' align='center'>
		  <img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="genrateSuppPerformanceDtlsHlp();" />
		  <img style="cursor: pointer" src="../../hisglobal/images/print_tab.gif" onClick="getSuppPerformanceDtlPrint();"/>
		  </div></td>
		</tr>		
	</table>
	
	
	<div id="suppPerformanceDtlsHlpDivId" style="display:block;"></div>
	
	<%-- Pop up Main Screen --%>
<div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDivMain" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
           <div id="suppPerformanceDtlsDivIdMain" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>

<table border="0" width='1150' align="center" cellspacing="1px" cellpadding="1px">
	
	<tr class="FOOTER">
			 <td colspan="4"><font color='red'>*</font>Mandatory Field </td>
		</tr>
		</table>
<div id="showButtonID" style="display:none;"> 
	<table border="0" width='1150' align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="resetPage();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table>
</div>

<!-- <div id="blanket" style="display:none;"></div> -->
<!--    <div class="popUpDiv" id="popUpDiv2" style="display:none;"> -->
<!--    <table bgcolor="white"> -->
<!--      <tr> -->
<!--       <td> -->
<!--            <div id="supplierPerformanceDtlsPopUpDivId" style="display:block;"></div> -->
           
<!--        </td> -->
<!--      </tr> -->
<!--     </table> -->
<!--   </div> -->
	
<div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="popUpDiv1" style="display: none;">

		<table bgcolor="white" width='200'>
			<tr>
				<td>

					<div
						style="padding: 20px, position:absolute; text-align: center; font-family: Arial; text-decoration: none; font-weight: normal; font-size: 13px; color: #00224A; background-color: #ffffff; border-width: 1px; border-color: #828EA2; border-style: solid;">
						<img src="/DWH/hisglobal/images/loading.gif" width=16 height=16><br>
						<br> <font size="2" weight="bold">Fetching Details. Please Wait!</font>
					</div>

				</td>
			</tr>
		</table>

	
	
	
	<input type="hidden" name="hmode"></input>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>