<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<html>
<head>
<meta charset=UTF-8">
<title>Drug Inventory Modify</title>
<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">


<link href="../../mms/css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/transactionutil/js/master.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="Javascript" src="../../hisglobal/js/time.js"></script>
<script language="JavaScript" src="../js/drug_inventory_programme.js"></script>
<script language="JavaScript" src="../js/item_OtherDtls_util.js"></script>
<script type="text/javascript">
$(function() {    
	
	var itemList = [];
	$('#strMultiRowItemId option').each(function() {
	    itemList.push({ "value" :this.textContent , "data" : this.value.split("^")[0] });
	});
	//alert(document.getElementById("strItemBrandId").value);
	getDrugNameSelectedModify(document.getElementById("strItemBrandId").value);
	
	
		
  });
  
</script>

</head>

<body onload="OnLoadFunction()" class="background" >
<html:form name="drugInventoryProgramTransBean"  styleClass="formbg" action="/transactions/DrugInventoryWithProgramTransCNT"
	type="mms.transactions.controller.fb.DrugInventoryWithProgramTransFB">


	<div class="errMsg" id="errMsg"><bean:write
		name="drugInventoryProgramTransBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="drugInventoryProgramTransBean" property="strWarning" /></div>

	<div class="normalMsg" id="normalMsg"><bean:write
		name="drugInventoryProgramTransBean" property="strMsg" /></div>	
	
	<table width='100%' align="center" border="0" cellpadding="1px"	cellspacing="0">
		<tr class="HEADER" class='all-four-rounded-corners'>
			<td colspan="4">Drug Inventory  &gt;&gt;Modify</td>
		</tr>

		<tr>			
			<td colspan="4" class="CONTROL" style="color:red;"><div align="center"><b><blink></blink></b></div></td>
		</tr>
		
		<tr>
			<td colspan="4" class="LABEL" style='text-align:left;'>Store : <bean:write	name="drugInventoryProgramTransBean" property="strStoreName" filter="false" /></td>
			
		</tr>		
	</table>	
	
    <table width='100%' align='center' border='0' cellpadding='1px'	cellspacing='0'>
		<!-- <tr class='multiCLRLabel'>
		<td  width="15%" class="LABEL" style='text-align:left;'>Programme Name :</td>
		<td colspan="2" class="LABEL" style="text-align:left;">		
		     <bean:write name="drugInventoryProgramTransBean" property="strProgrammeName" filter="false" />		     
		 </td>
		</tr> -->
		<tr class='multiCLRLabel'>
		<td  width="15%" class="LABEL" style='text-align:left;'>Selected Drug Name :</td>
		<td colspan="2" class="LABEL" style="text-align:left;">		
		     <div id='itemDivId'></div>		     
		 </td>
		</tr>
		<tr class='multiCLRLabel' style="display:none;">
		<td  width="100%" colspan="3" class="TITLE" style='text-align:left;'>Drug Name ::<div id="itemBrandDivId" style="display: none;"><select name="strMultiRowItemId" id="strMultiRowItemId" class="comboTooMax" ><bean:write name="drugInventoryProgramTransBean" property="strItemBrandCombo" filter="false" /></select> </div><input type="text" id="strSearchDrug" name="strSearchDrug" size="120%"/> </td>
		</tr>
		<tr style="display:none;">
			<td width="15%" class="TITLE" style="text-align: right;">Selected Drug Name:- </td>
			<td width="65%" class="TITLE" style="color:white;text-align:left;background-color: #71afe0;"><div id="DrugNameId" style="font-weight:bold"></div></td>
			<td class="LABEL"><font color="red">*</font> No of Batch :: <input type='text' class='txtFldMin' name='strNoOfMultiRow' id='strNoOfMultiRow'  value ='' maxlength='2' onkeypress='if(event.keyCode==13) return getMultiRow(this);'></td>
		</tr>
				
	</table>
					
	
	
	
	
	<div style="width:100%;overflow: auto;">
		 <table width='100%' align="center" border="0" cellspacing ="0" id='mstTable'>
		  <tr>
		     <td align='center'> 	     
		       <table width='150%' align='center' border='0' cellpadding='1px'	cellspacing='0'>					
					<logic:equal  value="14" name="drugInventoryProgramTransBean" property="strStoreTypeFlag">
					<tr>
					  <th class='multiPOLabelNew' colspan="1"><div id="SerailNo"> SNo</div></th>					  
					  <th class='multiPOLabelNew' colspan="2"><div id="mandBatchId"><font color='red'>*</font>Batch</div></th>
					  <th class='multiPOLabelNew' colspan="1"><font color='red'>*</font>Stock Qty</th>
					  <th class='multiPOLabelNew' colspan="2"><font color='red'>*</font>Rate/Unit</th>
					  <th class='multiPOLabelNew' colspan="1"><div id="mandMfgId"><font color='red'>*</font>Mfg Date.</div></th>
					  <th class='multiPOLabelNew' colspan="1"><div id="mandExpId"><font color='red'>*</font>Exp Date.</div></th>					  
					  <th class='multiPOLabelNew' colspan="2"><font color='red'>*</font>Mfg Name</th>					  
					  <th class='multiPOLabelNew' colspan="1">PO No.</th>
					  <th class='multiPOLabelNew' colspan="1">Tender No.</th>
					  <th class='multiPOLabelNew' colspan="1">#</th>
					</tr>
					<tr>					
						<td WIDTH='1%'   class='multiRPTLabel'></td>
						
						<td WIDTH='7%'   class='multiRPTLabel'></td>
						<td WIDTH='7%'   class='multiRPTLabel'></td>
						
						<td WIDTH='7%'   class='multiRPTLabel'><font color='red'>*</font>Active</td>						
						<td WIDTH='7%'   class='multiRPTLabel'><font color='red'>*</font>Quarantine</td>						
						<!-- <td WIDTH='5%'   class='multiRPTLabel'><font color='red'>*</font>In-Active</td> -->
						
						
						<td WIDTH='6%'   class='multiRPTLabel'><font color='red'>*</font>Rate</td>
						<td WIDTH='9%'   class='multiRPTLabel'><font color='red'>*</font>Unit</td>
						
						<td WIDTH='10%'   class='multiRPTLabel'></td>
						<td WIDTH='10%'   class='multiRPTLabel'></td>
						
	                    <td WIDTH='9%'   class='multiRPTLabel'></td> 
	                    <td WIDTH='9%'   class='multiRPTLabel'></td> 
	                    
	                    <td WIDTH='5%'   class='multiRPTLabel'></td>   
	                    <td WIDTH='6%'   class='multiRPTLabel'></td>                                
	                    <td WIDTH='2%'   class='multiRPTLabel'></td>
                    </tr> 
					</logic:equal>	
									
					<logic:notEqual value="14" name="drugInventoryProgramTransBean" property="strStoreTypeFlag">
					<tr>
					 	 <th class='multiPOLabelNew' colspan="1"><div id="SerailNo"> SNo</div></th>					  
					  <th class='multiPOLabelNew' colspan="2"><div id="mandBatchId"><font color='red'>*</font>Batch</div></th>
					  <th class='multiPOLabelNew' colspan="1"><font color='red'>*</font>Stock Qty</th>
					  <th class='multiPOLabelNew' colspan="2"><font color='red'>*</font>Rate/Unit</th>
					  <th class='multiPOLabelNew' colspan="1"><div id="mandMfgId"><font color='red'>*</font>Mfg Date.</div></th>
					  <th class='multiPOLabelNew' colspan="1"><div id="mandExpId"><font color='red'>*</font>Exp Date.</div></th>					  
					  <th class='multiPOLabelNew' colspan="2"><font color='red'>*</font>Mfg Name</th>					  
					  <th class='multiPOLabelNew' colspan="1">PO No.</th>
					  <th class='multiPOLabelNew' colspan="1">Tender No.</th>
					  <th class='multiPOLabelNew' colspan="1">#</th>
					</tr>
					<tr>					
						<td WIDTH='1%'   class='multiRPTLabel'></td>
						
						<td WIDTH='11%'  class='multiRPTLabel'></td>
						<td WIDTH='11%'  class='multiRPTLabel'></td>
						
						<td WIDTH='8%'   class='multiRPTLabel'><font color='red'>*</font>Active</td>											
						<!-- <td WIDTH='7%'   class='multiRPTLabel'><font color='red'>*</font>In-Active</td> -->
						
						<td WIDTH='5%'   class='multiRPTLabel'><font color='red'>*</font>Rate</td>
						<td WIDTH='5%'   class='multiRPTLabel'><font color='red'>*</font>Unit</td>
						
						<td WIDTH='10%'   class='multiRPTLabel'></td>
						<td WIDTH='10%'   class='multiRPTLabel'></td>
						
	                    <td WIDTH='9%'   class='multiRPTLabel'></td> 
	                    <td WIDTH='9%'   class='multiRPTLabel'></td>
	                     
	                    <td WIDTH='5%'   class='multiRPTLabel'></td>   
	                    <td WIDTH='5%'   class='multiRPTLabel'></td>                                
	                    <td WIDTH='4%'   class='multiRPTLabel'></td>
                    </tr> 
					</logic:notEqual>
					
        </table>
	          <div id="id1"></div>
		 </td></tr>
		 </table>
	</div>	 
	
	
<div><div class="legends">
<font size="2" color="red">*</font> Mandatory Fields<br>
<font size="2" color="red">NOTE:- KINDLY CHECK THE STORE NAME BEFORE ENTERING ANY STOCK</font> 
</div>  
<div class="control_button"><table  class="TABLEWIDTH" align="center">
	<tr id="saveId">
	<td align="center"><div >
				<a href="#" style="cursor: pointer;" title="Click to Save Record" class="button" onClick="validateMultiRowModify();"><span class="save">Save</span></a>
				<a href="#" style="cursor: pointer;" title="Click to Clear Page" class="button" onClick="ClearPage();"><span class="clear">Clear</span></a>
				<a href="#" style="cursor: pointer;" title="Click to Return On Desk" class="button" onClick="cancel('CANCELPAGE');"><span class="cancel">Cancel</span></a>				 
				</div></td>
	</tr>	  
</table></div>
</div>	
	

	<input type="hidden" name="strStoreId"	value="${drugInventoryProgramTransBean.combo[0]}" />
	<input type="hidden" name="strStoreName" value="${drugInventoryProgramTransBean.strStoreName}" />
	<input type="hidden" name="strGroupId"	value="${drugInventoryProgramTransBean.combo[1]}" />
	<input type="hidden" name="strGroupName" value="${drugInventoryProgramTransBean.strGroupName}" />		
	<input type="hidden" name="strCtDate" value="${drugInventoryProgramTransBean.strCtDate}">
	<input type="hidden" name="strDefaultCurrencyCode"	value="${drugInventoryProgramTransBean.strDefaultCurrencyCode}">
	<input type="hidden" name="strRegFlag" value="" />
	<input type="hidden" name="strSalePrice" value="" />
	<input type="hidden"  name="strDrugTotCost" id="strDrugTotCost">
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strExistingBatchFlg" />
    <input type="hidden"  name="strExistingBatchDetails">
	<input type="hidden"  name="strConfigIssueRate" value="${drugInventoryProgramTransBean.strConfigIssueRate}">
	<input type="hidden"  name="strIssueRateConfigFlg" value="${drugInventoryProgramTransBean.strIssueRateConfigFlg}">
	<input type="hidden"  name="strBatchExistInStockFlg">
	<input type="hidden"  name="strBatchExistSuppBatchInStockFlg">
	<input type="hidden"  name="strQcTypeFlg"  value="">
	<input type="hidden"  name="strBatchMandFlg"  value="1">
	<input type="hidden"  name="strExpMandFlg"  value="1">
	<input type="hidden"  name="strMfgMandFlg"  value="1">
	<input type="hidden"  name="strIsDataSaveFlg"  value="${drugInventoryProgramTransBean.strIsDataSaveFlg}">
	<input type="hidden"  name="strSavedDrugName"  value="${drugInventoryProgramTransBean.strSavedDrugName}">
	<input type="hidden"  name="strSavedBatchName"  value="${drugInventoryProgramTransBean.strSavedBatchName}">
	<input type="hidden"  name="strSelDrugName"  value="">
	<input type="hidden" name="strProgrammeId" id="strProgrammeId"	value="${drugInventoryProgramTransBean.combo[2]}" />
	<input type="hidden" name="strItemBrandId" id="strItemBrandId"	value="${drugInventoryProgramTransBean.strItemBrandId}" />
	<input type="hidden" name="strSelBatch" id="strSelBatch"	value="${drugInventoryProgramTransBean.strSelBatch}" />
	<input type="hidden" name="strPath" value="${drugInventoryProgramTransBean.strPath}">
	
		
   <div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="popUpDiv" style="display: none;">
		<table bgcolor="white" width='200'>
			<tr>
				<td>
					<div style="padding: 20px, position:absolute; text-align: center; font-family: Arial; text-decoration: none; 
					font-weight: normal; font-size: 13px; color: #00224A; background-color: #ffffff; border-width: 1px; border-color: #828EA2; border-style: solid;">
						<img src="/DWH_ANDHRA/hisglobal/images/loading.gif" width="16" height="16"><br>
						<br> <font size="2" weight="bold">Fetching Details. Please Wait!</font>
					</div>
				</td>
			</tr>
	</table>
	</div>
	<cmbPers:cmbPers />
</html:form>
<jsp:include page="drugInventory_program_multirow_mmstrans.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>
</body>
</html>
