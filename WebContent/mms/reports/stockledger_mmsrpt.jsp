<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<!--
 * Developer : Vivek Aggarwal
 * Version : 1.0
 * Date : 16-Mar-2012
 * Modification Date: 
 *  
-->

<html>
<head>
<title>Stock Ledger</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	


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
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../mms/js/stockledger_mmsrpt.js"></script>

</head>
<body onload="onLoadPage();">
<html:form action="/reports/StockLedgerRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="stockLedgerRpt" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="stockLedgerRpt" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="stockLedgerRpt" property="strWarningMsg"/></div>


	<tag:tab tabLabel="Stock Ledger" selectedTab="FIRST" align="center" width="TABLEWIDTH"> </tag:tab>

	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
	<tr class="HEADER">
			<td colspan="4"></td>
		</tr>
		<tr>
			<td colspan="1" width="25%" class="LABEL"><font color="red">*</font>Store Name</td>
			<td colspan="1" width="25%" class="CONTROL">
				<select name="strStoreId" class="comboNormal" onchange="getItemCatCmb1();">
					<bean:write name="stockLedgerRpt" property="strStoreValues" filter="false" />
				</select>
			</td>
			
			<td colspan="1" width="25%" class="LABEL"><font color="red">*</font>Item Category</td>
			<td colspan="1" width="25%" class="CONTROL">
				<div id="itemCatDivId">
					<select name="strItemCatNo" class="comboNormal" onchange="getItemCmb1();">
						<bean:write name="stockLedgerRpt" property="strItemCatValues" filter="false" />
					</select>
				</div>
			</td>
		</tr>
		<tr>
		
			<td colspan="1" width="25%" class="LABEL">
				<div id="drugLabelDivId">Drug Name</div>
				<div id="itemLabelDivId" style="display: none;">Item Name</div>
				
			</td>
			<td colspan="1" width="25%" class="CONTROL">
				<div id="itemDivId">
					<select	name="strItemId" class="comboNormal" onchange="enableBatchWise();">
						<bean:write name="stockLedgerRpt" property="strItemValues" filter="false" />
					</select>
			   </div>
			</td>	
			<td colspan="2" width="25%" class="LABEL"></td>
		</tr>
					
		
		
		<tr>
			<td class="LABEL" colspan="1" width="25%" ><font color="red">*</font>From Date</td>
			<td class="CONTROL" colspan="1" width="25%" >
				<dateTag:date name="strFromDate" value="${stockLedgerRpt.strCurrentDate}" />
			</td>

			<td class="LABEL" colspan="1" width="25%" ><font color="red">*</font>To Date</td>
			<td class="CONTROL" colspan="1" width="25%" ><dateTag:date name="strToDate"
				value="${stockLedgerRpt.strCurrentDate}" /></td>
		</tr>
		
		<tr>
			<td colspan="2" class="LABEL">Whether Batch Wise</td>
			<td colspan="2" class="CONTROL">
				<html:checkbox property="strWhetherBatchWise" name="stockLedgerRpt" value="1" >
				</html:checkbox>
			</td>

		</tr>
		
		<tr>
			<td class="LABEL" colspan="2"></td>
			<td colspan="2" class="CONTROL"></td>
		</tr>
			
		<tr>

			<td class="CONTROL" colspan="4">
			<div id='id' align='center'>
			<a href="#" class="button"  onClick="return validate();"><span class="generate">Generate</span></a> 
			</div>
				<!-- <div id='id' align='center'>
					<img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="return validate();" />
				</div>	 -->
			</td>
			
		</tr>
			
	
		</table>
	
	<div id="stockLedgerDetailDivId" style="display:block;"></div>
	
		
	
		<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
	
			<tr class="FOOTER">
				 <td colspan="4"><font color='red'>*</font>Mandatory Field </td>
			</tr>
		</table>
	
	<div id="showButtonID" style="display:none;"> 
		<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
			<tr>
	
				<td  colspan="4">
				<!-- <div id='id' align='center'>
					<img style="cursor: pointer" src="../../hisglobal/images/print_tab.gif" onClick="openViewPage();" />
					<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="clearPage();" >
					<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelPage();" >
				</div> -->
				
				<div align="center" id='id'>					 
							<a href="#" class="button" id="" onClick="openViewPage();"><span class="print">Print</span></a>
							<a href="#" class="button"	onclick="clearPage()"><span class="clear">Clear</span></a> 
							<a href="#" class="button" onclick="window.parent.closeTab();;"><span class="cancel">Cancel</span></a>
					</div>
					
				</td>			
			</tr>
		</table>
	</div>	
	
<input type="hidden" name="hmode"/>
<input type="hidden" name="strStoreName" value="${stockLedgerRpt.strStoreName}" />
<input type="hidden" name="strDrugName" value="${stockLedgerRpt.strDrugName}" />

<input type="hidden" name="strCurrentDate" value="${stockLedgerRpt.strCurrentDate}"/>

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>