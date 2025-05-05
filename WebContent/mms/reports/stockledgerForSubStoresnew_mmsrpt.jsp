 <%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%> 
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
<title>Stock Ledger For Substore</title>
<link href="../../hisglobal/css/dwh.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">

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
            .multiRPTControl1 {
			    background-color: #D8D8D8;
			    color: #000000;
			    font-family: Verdana,Arial,Helvetica,sans-serif;
			    font-size: 10px;
			    font-style: normal;
			    font-weight: normal;
			    height: 12px;
			    text-align: center;
			}
			
</style>
<script language="JavaScript" src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script language="Javascript" src="../../hisglobal/js/autocompleteItemSearch.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../mms/js/stockledgerForSubStores_mmsrpt.js"></script>

</head>
<body onload="onLoadPage();hideMenuFrame();" class="background">
<html:form action="/reports/StockLedgerForSubStoresRptNewCNT" method="post" styleClass="formbg">
	
<div class="errMsg" id="errMsg"><bean:write name="stockLedgerForSubStoresRptNew" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="stockLedgerForSubStoresRptNew" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="stockLedgerForSubStoresRptNew" property="strWarningMsg"/></div>

	
	<!--<table width='95%' align="center" cellspacing="1px" cellpadding="1px" > 
	<tr class="HEADER">
			<td colspan="4" class='all-four-rounded-corners'>
			<div id="itemManagePlusId" align="left" style="display: none;">
			<img src="../../hisglobal/images/plus.gif" onClick="view1('itemManagePlusId','itemManageMinusId','itemManageDtlId1','itemManageDtlId2');"
				style="cursor: pointer; " />Stock Ledger for Sub-store 
				<div id="storeDtlsDivId"></div>
			</div>
			<div id="itemManageMinusId" style="display: block;" align="left">
			<img src="../../hisglobal/images/minus.gif" onClick="view2('itemManagePlusId','itemManageMinusId','itemManageDtlId1','itemManageDtlId2');"
				style="cursor: pointer; " />Stock Ledger for Sub-store</div>
			</td>
		</tr>
	</table>  -->
	
	<table width='95%' align="center" cellspacing="1px" cellpadding="1px" > 
	<tr class="HEADER">
			<td colspan="4" class='all-four-rounded-corners'>
			<div id="itemManagePlusId" align="left" style="display: none;">	Stock Ledger 
				<div id="storeDtlsDivId"></div>
			</div>
			<div id="itemManageMinusId" style="display: block;" align="left"> Stock Ledger</div>
			</td>
		</tr>
	</table>
	
	<div id="itemManageDtlId1" style="display: block">
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >		
		<tr>
			<td colspan="1" width="25%" class="LABEL"><font color="red">*</font>Store Name</td>
			<td colspan="3" width="75%" class="CONTROL">
			<div id="storeDivId" style="display: block;">
				<select name="strStoreId" class="comboNormal" >
					<bean:write name="stockLedgerForSubStoresRptNew" property="strStoreValues" filter="false" />
				</select>
			</div>	
			<div id="storeNameDivId" style="display: none;"></div>
			</td>
		</tr>
		
		<tr>
			<td width="25%" colspan="1" class="LABEL">Group Name</td>
			<td width="75%" colspan="3" class="CONTROL">
				<div id="groupDivId">
					<select name="strGroupId"  class="comboNormal" onchange='getItemCmb();'>
						<bean:write name="stockLedgerForSubStoresRptNew" property="strGroupCombo"	filter="false" />
					</select>					
				</div>
				
			</td>		
		</tr>
		<!--<tr>
			<td colspan="1" width="25%" class="LABEL">Drug Type</td>
			<td colspan="3" width="75%" class="CONTROL">
				<select name="strItemType" class="comboNormal" onchange="getDrugName();">
						<bean:write name="stockLedgerForSubStoresRptNew" property="strItemTypeValues" filter="false" />
				</select>
				
			</td>			
		</tr>  -->
		
			
		<!-- <tr>
			<td colspan="1" width="25%" class="LABEL">Item name</td>
			<td colspan="3" width="25%" class="CONTROL">
				<div id="itemDivId" style="display: none;">
					<select	id="strItemId" name="strItemId" class="comboNormal" >
						<bean:write name="stockLedgerForSubStoresRptNew" property="strItemValues" filter="false" />
					</select>
				</div>
				<input type="text" id="strSearchDrug" name="strSearchDrug" size="100%"/>
				<div id="itemNameDivId" style="display: none;"></div>
			</td>
			
		</tr> -->
		<tr>
			<td class="CONTROL" colspan="4">
				<div id="DrugNameId" style="display:none; color:blue;font-weight:bold"></div>
			</td>
		</tr>		
	</table>
	</div>	
	
	<div id="itemManageDtlId2" style="display: block">	
	
		<div class="line">
			<table class='NEWTABLEWIDTH' align="center" cellspacing="1px" cellpadding="1px">
				<tr><td  width="95%">Item name</td></tr>
			</table>		            	
		</div>	
		<table class="TABLEWIDTH" align="center"  cellpadding="1px" cellspacing="1px">	
		<!-- <tr>
		<td class="LABEL" width="25%" colspan="1">Section Name</td>
			<td class="CONTROL" width="75%" colspan="5">
			<select	name="strSectionId" style= "width:15%;" onchange="getDrugName();">
					<bean:write name="stockLedgerForSubStoresRptNew" property="strSectionName" filter="false" />
			</select>
		  </td></tr>	
		 --><tr>
		<td class="LABEL" width="25%" colspan="1"></td>
  			<td class="CONTROL" colspan="1" width="25%">  			 
				<div id="LeftItemIds" align="left">
					<select id="strLeftItemIds" name="strLeftItemIds" size="6" multiple style="width: 280px" onChange='showSelection(this);' >
						<bean:write name="stockLedgerForSubStoresRptNew" property="strLeftItemList" filter="false"/>
					</select>
				</div>				
			</td>
			<td width="10%" class="CONTROL" colspan="1" align="left">			
			<div style='display:inline;'>
					<img src="../../hisglobal/images/forward3.gif" width="30" height="21" onclick ="LeftListTransfer();">
				<center>
			<img src="../../hisglobal/images/forwardward.gif" width="30" height="21" style="display: none;"
				align="middle" onClick="shiftAllToRight('strLeftItemIds','strRightItemIds',1);"/></center>
			<br/>
					
			<img src="../../hisglobal/images/backward.gif" width="30" height="21" style="display: none;"
				onClick="shiftAllToLeft('strLeftItemIds','strRightItemIds',1);">
		
				<img src="../../hisglobal/images/back3.gif" width="30" height="21" 
					onclick="transferToLeft();"/>
					</div>
					
			</td>			
			<td class="CONTROL" colspan="3">
			<div id="RightItemIds" align="left" style='display:inline;'>
					<select id="strRightItemIds" name="strRightItemIds" size="6" multiple style="width: 280px">
						<bean:write name="stockLedgerForSubStoresRptNew" property="strRightItemList" filter="false"/>
					</select>
				</div>
			</td>		
		</tr>		
		</table>
		
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
	<tr>	<td class="LABEL" width="25%"></td>
			<td class="CONTROL"  width="75%"><div id="txtFromLeftMutltiSelectCombo" style="display:none;  color:blue;font-weight:bold "></div></td></tr>
		</table>
		<div class="line"><table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
		<tr>
			<td colspan="4">Other Detail(s)</td>
		</tr>		
		</table>
	</div>
		
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">		
		
		<tr>
			<td colspan="2" width="50%" class="LABEL">Batch No. Wise</td>
			<td colspan="2" width="50%" class="CONTROL">
				<html:checkbox property="strWhetherBatchWise" name="stockLedgerForSubStoresRptNew" value="1" >
				</html:checkbox>
			</td>

		</tr>
		
		<tr>
			<td class="LABEL" colspan="1" width="25%" ><font color="red">*</font>From Date(Entry)</td>
			<td class="CONTROL" colspan="1" width="25%" >
				<dateTag:date name="strFromDate" value="${stockLedgerForSubStoresRptNew.strCurrentDate}" />
			</td>

			<td class="LABEL" colspan="1" width="25%" ><font color="red">*</font>To Date(Entry)</td>
			<td class="CONTROL" colspan="1" width="25%" >
				<dateTag:date name="strToDate" value="${stockLedgerForSubStoresRptNew.strCurrentDate}" />
			</td>
		</tr>		
			
		<tr id='generateId'>
			<td class="CONTROL" colspan="4">
				<div id='id' style="text-align:center;margin-left:45%">
				<a href="#" class="button" title="Print" onClick="return validate();"><span class="generate">Generate</span></a>					
				</div>	
			</td>			
		</tr>
		
		</table>
</div> <!-- Ending <div id=itemManageDtlId2 -->
	
	<div id="stockLedgerDetailDivId" style="display:block;"></div>
	
	<table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
	
			<tr class="FOOTER">
				 <td colspan="4" class='all-four-rounded-corners'></td>
			</tr>
	</table>	
	
	<div id="showButtonID" style="display:none;">
	<div><div class="legends"><font size="2" color="red">*</font> Mandatory Field(s)</div>
	<div class="control_button">
	<table  class="TABLEWIDTH" align="center">
	<tr>
	<td align="center"><div>
				<a href="#" class="button" onClick="openViewPage();"><span class="print">Print</span></a>
				<a href="#" class="button" onClick="clearPage();"><span class="clear">Clear</span></a>
<%-- 				<a href="#" class="button" onClick="cancelPage();"><span class="cancel"><bean:message key="label.common.Cancel" /></span></a>				  --%>
				</div></td>
	</tr>	  
	</table>
	</div></div>			
	</div>	
		
	
<input type="hidden" name="hmode"/>
<input type="hidden" name="strCurrentDate" value="${stockLedgerForSubStoresRptNew.strCurrentDate}"/>
<input type="hidden" name="strStoreName" value="${stockLedgerForSubStoresRptNew.strStoreName}" />
<input type="hidden" name="strItemBrandId" value="0" />
<input name="strItemCatNo" value="10" type="hidden">
<input type="hidden" name="selPageIndex" value="1"/>

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>