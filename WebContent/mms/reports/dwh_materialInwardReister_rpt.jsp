<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
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
            div.ex
			{
			width:190px;
			padding:8px;
			border:2px solid gray;
			margin:0px;
			}
            
            </style>
<title>Material Inward Register Report</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="Javascript" src="../../hisglobal/js/time.js"></script>

<script language="Javascript" src="../../mms/js/dwh_materialInwardRegister_rpt.js"></script>


</head>
<body onload="onLoadPage();">
<html:form action="/reports/MaterialInwardReisterRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="materialInwardReisterRptFB" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="materialInwardReisterRptFB" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="materialInwardReisterRptFB" property="strWarningMsg"/></div>


	<tag:tab tabLabel="Material Inward Register Report" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4"></td>
			
	</tr>
	</table>
			
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" > 	
	
	<tr>
			<td class="LABEL" colspan="4">
				<!-- <input type="radio" name="strPoType" value="1" onclick="setValueChk(this);">Annual PO --> 
				<input type="radio" name="strPoType" value="2" onclick="setValueChk(this);" checked="checked">Local PO 
				<!-- <input type="radio" name="strPoType" value="0" onclick="setValueChk(this);">All PO -->
				</td>
		</tr>
	
		<tr>
			<td class="LABEL" colspan="4"><html:radio
				property="strDateType" value="1" onclick="onRadio(this);">PO Date Wise</html:radio>
			<html:radio property="strDateType" value="2"
				onclick="onRadio(this);">Challan Date Wise</html:radio></td>
		</tr>
	
	
		
		<tr>
			<td width="50%" colspan="2" class="LABEL">Supplier Name</td>
			<td width="50%" colspan="2" class="CONTROL">
			<div id="strStoreDivId" >
				<select name="strSupplierId" class="comboMax" >
					<bean:write name="materialInwardReisterRptFB" property="strManufactureCombo" filter="false"/>
				</select>
			</div>				
			</td>
		</tr>		
		
	
		
		
    

 
         <tr>
			<td class="LABEL" colspan="2"><font color="red">*</font>From Date</td>
			<td class="CONTROL" colspan="2"><dateTag:date name="strFromDate" value="${materialInwardReisterRptFB.strCurrentDate}" /></td>
			</tr>
			<tr>
			<td class="LABEL" colspan="2"><font color="red">*</font>To Date</td>
			<td class="CONTROL" colspan="2"><dateTag:date name="strToDate" value="${materialInwardReisterRptFB.strCurrentDate}" /></td>
		</tr>
	
		  
		  <!--  <td class="CONTROL" colspan=" "><div id='id' align='center'>< <img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="genratePoHlp();" /> -->
		  <!-- <a href="#" class="button" id="" onclick='genratePoHlp();'><span class="generate">Generate</span></a> -->
		  
		 <!--  </div></td> -->
			
		

		
		
		
		
	</table>
	
	
	
	<div id="consolidatedPODetailDIV"></div>
	
	
	<div id="consolidatedChallanDetailDIV"></div>
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px">
		<tr>
			<td width="50%" colspan="2" class="LABEL">Report Format</td>
			<td width="50%" colspan="1" class="CONTROL"><select
				name="strReportFormat" onchange="">
				<option value="html">Html</option>
				<option value="pdf">Pdf</option>
				<option value="xls">Excel</option>
			</select></td>

		</tr>

		<tr>
			<td width="50%" colspan="2" class="LABEL">Footer Required</td>
			<td width="50%" colspan="1" class="CONTROL"><html:checkbox
				property="strIsFooter" name="materialInwardReisterRptFB" value="1"></html:checkbox>
			</td>

		</tr>
		<tr>
			<td width="50%" colspan="2" class="LABEL">User Remarks</td>
			<td width="50%" colspan="1" class="CONTROL"><input
				class="txtFldMax" type="text" name="strUserRemarks"></td>

		</tr>
		
	</table>
	
	
	 
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
	
	<tr class="FOOTER">
			 <td colspan="4"><font color='red'>*</font>Mandatory Field </td>
		</tr>
		</table>
<!-- <div id="showButtonID" style="display:none;"> 
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/print_tab.gif" onClick="getScreenTwoPrint();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="resetPage();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table>
</div>-->
<br>
<div align="center" id=" " >					 
					 	<a href="#" class="button" id="" onclick='validate1();'><span class="generate">Generate</span></a>
						<a href="#" class="button"	onclick="resetPage()"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelFunc();"><span class="cancel">Cancel</span></a>
				</div>
	
	
<input type="hidden" name="hmode"/>
<input type="hidden" name="strEndFinancialYearTemp" value="${materialInwardReisterRptFB.strEndFinancialYearTemp}"/>
<input type="hidden" name="strCurrentDate" value="${materialInwardReisterRptFB.strCurrentDate}"/>

<input type="hidden" name="strSupplierName" value="${materialInwardReisterRptFB.strSupplierName}"/>
<input type="hidden" name="strProcRelatedValue" />
<input type="hidden" name="strDateTypeFlg"  value="1"/>

<input type="hidden" name="strDiv1" value="0" />
<input type="hidden" name="strDiv2" value="0" />
<input type="hidden" name="strDiv3" value="0" />
<input type="hidden" name="strCurrDiv" value="0" />

<div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv1" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
           <div id="supplierPoDtlsDivId" style="display:block;"></div>
           
       </td>
     </tr>
    </table>
   </div>
   
   
   <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv2" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         
           <div id="poChallanDtlsDivId" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>
   
    <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv3" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         
           <div id="poChallanItemDtlsDivId" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>
  <div id="blanket" style="display:none;"></div>
   <div class="popUpDiv" id="popUpDiv4" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         
           <div id="suppliedPOPrintDtlsDivId" style="display:block;"></div>
       </td>
     </tr>
    </table>
   </div>


</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>