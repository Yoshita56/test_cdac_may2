<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Online Transfer Detail</title>
<link href="../../hisglobal/css/dwh.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"
	type="text/css">
	<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<style type="">
.circle {
	-webkit-border-radius: 8px;
	-moz-border-radius: 8px;
	border-radius: 8px;
	border: 1px solid #faad07;
	width: 15px;
	height: 15px;
	background-color: green;
}

.circle1 {
	-webkit-border-radius: 8px;
	-moz-border-radius: 8px;
	border-radius: 8px;
	border: 1px solid #faad07;
	width: 15px;
	height: 15px;
	background-color: yellow;
}

table#tbl-content1 tr:nth-child(even),table#mainTableRptId tr:nth-child(even),table#tbl-content-annualDemand tr:nth-child(even)
	{
	background-color: #eeeeee;
}

tbody#tbl-body tr:nth-child(even) {
	background-color: #eeeeee;
}

table#tbl-content1 td,table#mainTableRptId td,table#tbl-content-annualDemand td
	{
	border-bottom: solid 1px #bbb;
	border-right: solid 1px #bbb;
	border-left: solid 1px #bbb;
	word-wrap: break-word;
	font-family: Helvetica;
	font-size: 12px;
}

table#tbl-content1 th,table#tbl-content-annualDemand th {
	border-bottom: solid 1px #bbb;
	border-right: solid 1px #bbb;
	border-left: solid 1px #bbb;
	word-wrap: break-word;
	font-family: Helvetica;
	font-size: 12px;
	color: #fff;
}

table#tbl-content1 tr#bottom td,table#tbl-content-annualDemand tr#bottom td
	{
	border-bottom: none;
}
</style>

<script language="JavaScript"
	src="../../hisglobal/jquery/3.6.0.min.js"></script>
	<script src="../../hisglobal/js/jquery-barcode.js"    language="JavaScript"></script>

<script language="JavaScript"
	src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script language="Javascript"
	src="../../hisglobal/js/commonFunctions.js"></script>
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/innerxhtml.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script>
<script language="JavaScript" src="../js/ReplacementDetails_trans.js"></script>
<script language="Javascript" src="../../mms/js/SupplierInterfaceTrans.js"></script>
<script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>

</head>
<body class="background" onLoad='callFunc();'>

		
		<html:form name="supplierDeskTransBean"
		action="/transactions/SupplierDeskInterfaceTransCNT"
		type="mms.transactions.controller.fb.SupplierDeskInterfaceTransFB"
		enctype="multipart/form-data" styleClass="formbgnew">
		
		<center>

			<div class="popup" id="itemDtlsDivId" style="display: none">
				<table width='550' cellpadding="0" cellspacing="0">
					<tr class='HEADER'>
						<td colspan='4' align="left">
							<div id='itemDtlsTitleDivId'></div>
						</td>
						<td align="right"><img src="../../hisglobal/images/stop.png"
							style="cursor: pointer" align="middle"
							onclick="hide_popup_menu('itemDtlsDivId');"></td>
					</tr>
				</table>
				<table width='550' cellpadding="1px" cellspacing="1px">
					<tr>
						<td colspan="2" class="multiRPTLabel">Manufacture </td>
						<td colspan="2" class="multiPOControl">
							<div id='itemManufDivId'></div>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="multiRPTLabel">Rate/unit </td>
						<td colspan="2" class="multiPOControl">
							<div id='itemRateDivId'></div>
						</td>
					</tr>
				</table>
				<table width='550' cellpadding="0" cellspacing="0">
					<tr class="FOOTER">
						<td></td>
					</tr>
				</table>
			</div>

			<div class="popup" id="offLineBalQtyDtlsDivId" style="display: none">
				<table width='550' cellpadding="0" cellspacing="0">
					<tr class='HEADER'>
						<td colspan='4' align="left">
							<div id='offLineBalQtyTitleDivId'></div>
						</td>
						<td align="right"><img src="../../hisglobal/images/stop.png"
							style="cursor: pointer" align="middle"
							onclick="hide_popup_menu('offLineBalQtyDtlsDivId');"></td>
					</tr>
				</table>
				<table width='550' cellpadding="1px" cellspacing="1px">
					<tr>
						<td colspan="1" class="LABEL" style="text-align: right;">Ordered qty.=</td>
						<td colspan="3" class="CONTROL" style="text-align: left;">
							<div id='offLineBalOrdQtyDivId'></div>
						</td>
					</tr>
					<tr>
						<td colspan="1" class="LABEL" style="text-align: right;">Stop Qty pop=</td>
						<td colspan="3" class="CONTROL" style="text-align: left;">
							<div id='offLineStopDivId'></div>
						</td>
					</tr>
					<tr>
						<td colspan="1" class="LABEL" style="text-align: right;">Received Qty till Date=</td>
						<td colspan="3" class="CONTROL" style="text-align: left;">
							<div id='offLineBalRecQtyDivId'></div>
						</td>
					</tr>
					<tr>
						<td colspan="1" class="LABEL" style="text-align: right;">Rejected Qty till Date=</td>
						<td colspan="3" class="CONTROL" style="text-align: left;">
							<div id='offLineBalRejQtyDivId'></div>
						</td>
					</tr>
					<tr>
						<td colspan="1" class="LABEL" style="text-align: right;">Shortage Qty till Date=</td>
						<td colspan="3" class="CONTROL" style="text-align: left;">
							<div id='offLineBalShortQtyDivId'></div>
						</td>
					</tr>
					<tr>
						<td colspan="1" class="LABEL" style="text-align: right;">Rej Qty After Verify=</td>
						<td colspan="3" class="CONTROL" style="text-align: left;">
							<div id='offLineBalRejQtyAfterVerifyDivId'></div>
						</td>
					</tr>
					<tr>
						<td colspan="1" class="LABEL" style="text-align: right;">Supplier Return Qty=</td>
						<td colspan="3" class="CONTROL" style="text-align: left;">
							<div id='offLineSupplierReturnQtyDivId'></div>
						</td>
					</tr>
					<tr>
						<td colspan="1" class="LABEL" style="text-align: right;">Replacement Order Qty=</td>
						<td colspan="3" class="CONTROL" style="text-align: left;">
							<div id='offLineBalReplacementOrderQtyDivId'></div>
						</td>
					</tr>


								<tr>
						<td colspan="1" class="LABEL" style="text-align: right;">PO Pre Sample Qty=</td>
						<td colspan="3" class="CONTROL" style="text-align: left;">
							<div id='offLineBalPoPreSampleQtyDivId'></div>
						</td>
					</tr>
					
					<tr>

						<td colspan="4" bgcolor="black"></td>
					</tr>
					<tr>
						<td colspan="1" class="LABEL" style="text-align: right;">Balanced Qty Challan=</td>
						<td colspan="3" class="CONTROL" style="text-align: left;">
							<div id='offLineFianlBalQtyDivId'></div>
						</td>
					</tr>

				</table>
				<table width='550' cellpadding="0" cellspacing="0">
					<tr class="FOOTER">
						<td></td>
					</tr>
				</table>
			</div>


			<div class="popup" id="balanceQtyDivId" style="display: none">
				<table width='500' cellpadding="0" cellspacing="0">
					<tr class='HEADER'>
						<td colspan='4' align="left">
							<div id='itemDtlsTitleDivId'></div>
						</td>
						<td align="right"><img src="../../hisglobal/images/stop.png"
							style="cursor: pointer" align="middle"
							onclick="hide_popup_menu('itemDtlsDivId');"></td>
					</tr>
				</table>
				<table width='500' cellpadding="1px" cellspacing="1px">
					<tr>
						<td width="200%" class="multiRPTLabel">Manufacture</td>
						<td width="200%" class="multiPOControl">
							<div id='itemManufDivId'></div>
						</td>
					</tr>
					<tr>
						<td width="200%" class="multiRPTLabel">Rate/unit </td>
						<td width="200%" class="multiPOControl">
							<div id='itemRateDivId'></div>
						</td>
					</tr>
				</table>
				<table width='500' cellpadding="0" cellspacing="0">
					<tr class="FOOTER">
						<td></td>
					</tr>
				</table>
			</div>

			<div id="errMsg" class="errMsg">
				<bean:write name="supplierDeskTransBean" property="strErr" />
			</div>
			<div id="warningMsg" class="warningMsg">
				<bean:write name="supplierDeskTransBean" property="strWarning" />
			</div>
			<div id="normalMsg" class="normalMsg">
				<bean:write name="supplierDeskTransBean" property="strMsg" />
			</div>

		</center>
		<table width='100%' align="center" cellspacing="0" id='divHeader'>
			<tr class="HEADER">
				<td colspan="4" width="100%" nowrap="nowrap">Supplier Delivery</td>
			</tr>
		</table>

		<table width='100%' align="center" cellpadding="1px" cellspacing="1px">

			<tr>
				<td width="25%" class="LABEL">Supplier Name :</td>
				<td class="CONTROL"><bean:write name="supplierDeskTransBean"
						property="strSupplierName" filter="false"></bean:write> <html:hidden
						name="supplierDeskTransBean" property="strSupplierId"></html:hidden>
					<html:hidden name="supplierDeskTransBean"
						property="strSupplierName"></html:hidden></td>


				<td width="25%" class="LABEL">Po type :</td>
				<td class="CONTROL"><bean:write name="supplierDeskTransBean"
						property="strComboPOTypeValue" filter="false"></bean:write> <html:hidden
						name="supplierDeskTransBean" property="strComboPOTypeId"></html:hidden>


				</td>



			</tr>

			<tr>
				<td class="LABEL" width="25%" colspan="1"> Po generation period :</td>
				<td class="CONTROL" width="25%" colspan="1"><bean:write
						name="supplierDeskTransBean" property="strPOFinancialYear"
						filter="false"></bean:write> <html:hidden
						name="supplierDeskTransBean" property="strIndentPeriodValue"></html:hidden>



				</td>

				<td width="25%" class="LABEL">Purchase order date :</td>
				<td class="CONTROL">
					<div id='poRefDateDiv'></div>
					<div id='poRefDateCalDiv'>
						<bean:write name="supplierDeskTransBean"
							property="strPORefrenceDate" filter="false"></bean:write>
					</div>

				</td>


			</tr>

			<tr>
				<td class="LABEL" width="25%" colspan="1">Po no System Generated:</td>
				<td class="CONTROL" width="25%" colspan="1"><bean:write
						name="supplierDeskTransBean" property="strPONoWithPreFix"
						filter="false"></bean:write> </td>
						
						<td width='25%' colspan="1" class="LABEL">Drug/item_name(s) :</td>
					<td width='25%' colspan="1" class="CONTROL">
						<bean:write
				name="supplierDeskTransBean" property="strItemNameNew" filter="false"></bean:write>

					</td>


			</tr>
			<tr>
					<td width='25%' colspan="1" class="LABEL">Programme Name :</td>
					<td width='25%' colspan="1" class="CONTROL">
					   <bean:write	name="supplierDeskTransBean" property="strPrgName" filter="false"></bean:write>

					</td>
					<td width='25%' colspan="1" class="LABEL">Funding Source :</td>
					<td width='25%' colspan="1" class="CONTROL">
						<bean:write
				name="supplierDeskTransBean" property="strFSName" filter="false"></bean:write>

					</td>
			</tr>

		</table>

		<div id="phyStockVerifiedItemDtls" style="display: none;">
			<bean:write name="supplierDeskTransBean"
				property="strPreviousDeliveryDtls" filter="false" />
		</div>
		<br>
		<div class="line" style="width: 101%; margin-left: 0%;">
			<table class='NEWTABLEWIDTH' align="center" cellspacing="1px"
				cellpadding="1px">
				<tr>
					<td width="100%">Drug Warehouse Wise Supplier Delivery Detail </td>
				</tr>
			</table>
		</div>



		<table class='TABLEWIDTH' align='right' border='0' cellpadding='1px' cellspacing='0px'>	
			<tr> 
				<td width='25%' colspan='1' align='left' class='LABEL'><span style='float:left'><font color='red'>*</font>Batch Type :
				&nbsp;<input type='radio' name='strReplacementDirectBatchFlag' id='strReplacementDirectBatchFlag' value='1'>
				Replacement 
				&nbsp;<input type='radio' name='strReplacementDirectBatchFlag' id='strReplacementDirectBatchFlag' value='2'>
				Surveillance
				&nbsp;<input type='radio' name='strReplacementDirectBatchFlag' id='strReplacementDirectBatchFlag' value='0'>
				Fresh Supply </span></td>
			</tr>
			</table>
		<table width='100%' align="center" cellpadding="1px" cellspacing="1px">
			<tr>

				<td class="LABEL" width="25%">Consignee Warehouse :</td>
				<td class="CONTROL" width="25%"><select id="strDeliveryStoreId"
					name="strDeliveryStoreId" class="comboNormal"
					onchange="getScheduleNoCmb(this);">
						<bean:write name="supplierDeskTransBean"
							property="strConsigneeStoreCombo" filter="false" />
				</select></td>

				<td class="LABEL" width="25%">Tranche no Status :</td>
				<td class="CONTROL" width="25%">
					<div id="schedulCmbId">
						<select name="strScheduleNo" class="comboNormal"
							onchange="getDrugNameCombo();">
							<option value="0">Select Value</option>
						</select>
					</div>
				</td>

			</tr>

			<tr>
				<td class="LABEL"><font color="red">*</font>
				Expected delivery days :</td>
				<td width="25%" class="CONTROL"><input type="text" size="25"
					name="strExpectedDeliveryDays" maxlength="3" class="txtFldNormal"
					onkeypress="return validateData(event,5);"></td>

				<td class="LABEL">Delivery_date :</td>
				<td width="25%" class="CONTROL">
					<div id="deliveryDateId">---</div>
				</td>

			</tr>			
			<tr>


				<td class="LABEL" width="25%">
				Supplier Receipt No1:</td>
				<td class="CONTROL" width="25%"><input type="text" size="25"
					name="strSupplierReceiptNo" maxlength="20" class="txtFldMax"
					onkeypress="return validateData(event,20);"></td>
					
				<td class="LABEL" width="25%"><font color="red">*</font>
				Invoice no :</td>
				<td class="CONTROL" width="25%"><input type="text" size="25"
					name="strSupplierInvoiceNo" maxlength="40" class="txtFldMaxNew"
					onkeypress="return validateData(event,20);" onblur="checkInvoice();"></td>
					

				
			</tr>

			<tr>
			    <td class="LABEL"><font color="red">*</font>
				Supplier/invoice_date :</td>
				<td width="25%" class="CONTROL">
					<div id='supplierRecDate'></div>
					<div id='recpCalender'>
						<dateTag:date name="strSupplierReceiptDate" value=""></dateTag:date>
					</div>
				</td>
				<td width="25%" class="LABEL"><font color="red">*</font>
				Delivery Mode :</td>
				<td width="25%" class="CONTROL"><select class="comboNormal"
					onchange="checkValComboTwo(this);" name="strDeliveryMode">
						<bean:write name="supplierDeskTransBean"
							property="strDeliveryModeValues" filter="false" />
				</select></td>
				

			</tr>

			<tr>
			  
				<td width="25%" class="LABEL"><font color="red">*</font>
				Transporter name :</td>
				<td width="25%" class="CONTROL" colspan="1"><input type="text"
					class="txtFldMax" name="strTransporterName"></td>
				<td width="25%" class="LABEL"><font color="red">*</font>
				LR No :</td>
				<td width="25%" class="CONTROL"><input type="text"
					class="txtFldMax" name="strLorryNo"></td>
			</tr>
			
			<tr>
				<td width="25%" class="LABEL">Driver_Name :
				</td>
				<td width="25%" class="CONTROL" colspan="1">
					<input type="text" maxlength="100" class="txtFldMax"
					onkeypress="return validateData(event,4);" name="strDriverName" >
				</td>
				<td width="25%" class="LABEL">Driver_Mobile_No :
				</td>
				<td width="25%" class="CONTROL">
					<input type="text" maxlength="10" class="txtFldMax"
					onkeypress="return validateData(event,5);" name="strDriverMobileNo">
				</td>
			</tr>
			<tr>
				<td width="25%" class="LABEL"><font color="red">*</font>
					Likely_Date_Of_Delivery :
				</td>
				<td width="25%" class="CONTROL" colspan="1">
					<dateTag:date name="strDateOfDelivery" value=""></dateTag:date>
				</td>
				<td width="25%" class="LABEL"><font color="red">*</font>
				Likely_Date_Of_Dispatch :
				</td>
				<td width="25%" class="CONTROL">
				<dateTag:date name="strDateOfDispatch" value=""></dateTag:date>
				</td>
			</tr>
		</table>
		
		<div id="RejectedBatchList" style="display:none;">
		<div class='line'><table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing='0px'> 
				<tr> 
				<td colspan='4' width='25%'>Rejected Batch</td> 
				</tr> 
				</table></div>
				
				<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>
				<tr> 
				<td class='CONTROL' colspan='2'><div id='leftbatchNoComboDivId' align='right'>
				<select id='strLeftBatchNos'
				 name='strLeftBatchNos' size='6' multiple	size='6' multiple style='width: 280px'>
				<bean:write name='supplierDeskTransBean' property='strLefttBatchList' filter='false' />
				</select>
					</div>
				</td>
				<td width='6%' class='CONTROL' colspan='2'><center><img src='../../hisglobal/images/forward3.gif' width='30'
					height='21' onclick='LeftBatchListTransfer();'></center>	
				<br /> 
				<center> <img src='../../hisglobal/images/back3.gif' width='30' height='21'	onclick='RightBatchListTransfer();' /> </center> 
				</td> 
				<td colspan='2' class='CONTROL'> <div id='rightbatchNoComboDivId' align='left'>
				<select id='strRightBatchNos' name='strRightBatchNos' size='6' multiple style='width: 280px'>
				<bean:write name='supplierDeskTransBean' property='strRightBatchList' filter='false' />
				</select></div>
				</td>
				</tr>
				</table>
				
				</div>

		<div class="line" style="width: 101%; margin-left: 0%;">
			<table class='NEWTABLEWIDTH' align="center" cellspacing="1px"
				cellpadding="1px">
				<tr>
					<td width="100%">Packing_Item_List</td>
				</tr>
			</table>
		</div>

		<table width="100%" align="center" border="0" cellpadding="1px"
			cellspacing="1px">
			<tr>
				<td colspan="4" align="center">
					<table cellspacing="0" cellpadding="3" border="0"
						id="headerTableTrans1"
						style="width: 100%; table-layout: fixed; border-collapse: collapse;">
						<tr>

							<th style="width: 5%;">S.No. </th>
							<th style="width: 18%;">Drug_Name</th>
							<th style="width: 8%;">Batch_No.</th>
							<th style="width: 8%;">Expiry_Date</th>
							<th style="width: 8%;">Mfg_date</th>
							<th style="width: 8%;">Balance_qty</th>
							<th style="width: 10%;">Delivered_Qty</th>
							<th style="width: 12%;">Carton_Size</th>
							<th style="width: 10%;">Cartan_No.</th>
							<th style="width: 8%;">No_of_carton</th>
							<th style="width: 5%;">Action</th>
									
									
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<div style="height: 100px; overflow: auto;">
						<table cellspacing="0" cellpadding="3" border="0"
							id="tbl-content1"
							style="width: 100%; table-layout: fixed; background: #fff; border-collapse: collapse;">
						</table>
					</div>
				</td>
			</tr>
		</table>


		<div class="line" style="width: 100%; margin-left: 0%;">
			<table class='NEWTABLEWIDTH' align="center" cellspacing="1px"
				cellpadding="1px">
				<tr>
					<td width="95%">Delivery_Drug_Details</td>
				</tr>
			</table>
		</div>

		<table width="100%" align="center" border="0" cellpadding="1px"
			cellspacing="1px">
			<tr>
				<td class="LABEL" width="25%">DrugName :</td>
				<td class="CONTROL" width="25%">
					<div id="drugComboDivId">
						<select id="strDrugBrandId" name="strDrugBrandId" class="comboMax"
							onchange="getConsigneeCmb(this);">
							<option value="0">Select Value</option>
						</select>
					</div>
				</td>
				<td class="LABEL">Manufacturer_Name :</td>
				<td width="25%" class="CONTROL">
					
					<select  class="comboNormal" 
					 name="strManufacturerValues" id ="strManufacturerValues"  disabled="true">
						<bean:write name="supplierDeskTransBean"
							property="strManufacturerValues" filter="false" />
				</select>
				</td>

			</tr>
			<tr>
				<td class="LABEL" colspan="1">Rejected_Batch :</td>
				<td class="CONTROL" colspan="1">
					<div id="rejectedBatchDivId"></div>
				</td>
				<td width='25%' class='LABEL'>Unit :</td>
				<td class='CONTROL' width='25%'>
				<div id='unitDivId'>
					<select name='strUnitId' style='display:none' class='comboNormal' id ='strUnitId'>
					   <option value='0'>Select Value</option>
					</select>
				</div> 
				 </td> 

			</tr>

		</table>
		<div id="cartonDiv" style="display:none;">
		<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing='0px' id='mstTable2'> 
				 <tr>				
					 <td class="LABEL" width='100%' style='text-align:right;'>
					  <input type="radio" name="cartonReq"
										value="1" checked="checked" onclick="cartonGene(1);">Auto Generate
										<!-- &nbsp;&nbsp; <input type="radio" name="cartonReq" value="2"
										onclick="cartonGene(2);">Manual -->
					 </td>
				 </tr>
				 				
		</table>
		</div>

		<div id="itemDtlDivId" style="width: 100%; overflow: auto;">
			<table width='100%' align='center' border='0' cellspacing='1px'
				id='mstTable'>
				<tr>
					<td align='center'>
						<div id="indentItemList"></div>
						<div id="id1"></div>
						<div id="footerDivId"></div>
					</td>
				</tr>
			</table>
		</div>

		<table width="100%" align="center" border="0" cellpadding="1px"
			cellspacing="1px">
			<tr>
				<td class="CONTROL" width="100%" style="text-align: center;">
					<div style="margin-left: 45%;">
						<a href="#" class="button" title="Click Here To Add Item"
							onClick="toCart();"><span class="add">Add </span></a>
					</div>
				</td>
			</tr>
		</table>




       
		<table width="100%" align="center" border="0" cellpadding="1px"
			cellspacing="1px">

			<tr>
				<td width="25%" class="LABEL">Remarks</td>
				<td class="CONTROL" colspan="3"><textarea name="strRemarks"
						cols="50" rows="2" id="strRemarks"></textarea></td>
			</tr>
		</table>


<jsp:include page="uploadFile.jsp"></jsp:include>
		<table width="100%" align="center" border="0" cellpadding="1px"
			cellspacing="1px">

			<tr class="FOOTER">
				<td colspan="4" width="25%"></td>
			</tr>
		</table>

		<div>
			<div id="divSaveCancelId" style="display: block"
				class="control_button">
				<table border="0" class="TABLEWIDTH" align="center"
					cellspacing="1px" cellpadding="1px">
					<tr>
						<td align="center">
							<div>
								<a href="#" class="button" onClick="return SaveDelivery();"
									title="Save Record"><span class="save">Save</span></a> <a href="#" class="button"
									onClick="clearForm();" title="Click to Clear Page"><span
									class="clear">Clear</span></a>
								<a href="#" class="button" onClick="cancelToGenerateDesk('2');"
									title="Cancel Process"><span class="cancel">Cancel</span></a>
							</div>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<div class="legends" style="width: 95%;">
			<ul>
				<li><font color='red'>*</font>
				Mandatory_Field(s)</li>
			</ul>
		</div>

		<input type="hidden" id="itemName"
			value="Please_Select_Item" />
		<input type="hidden" id="excessQty"
			value="Please_enter_Batch" />

		<input type="hidden" name="strCurrentDate"
			value="${ supplierDeskTransBean.strCurrentDate}" />
		<input type="hidden" name="strItemBrandIds" />
		<input type="hidden" name="strPOFinancialDtl" />
		<input type="hidden" name="strPONo"
			value="${ supplierDeskTransBean.strPONo}" />
		<input type="hidden" name="strINRCurrencyId"
			value="${ supplierDeskTransBean.strINRCurrencyId}" />
		<input type="hidden" name="strItemBrandIds" />
		<input type="hidden" name="strStoreIds" />
		<input type="hidden" name="strRequestIds" />
		<input type="hidden" name="strIsForeignFlg" />
		<input type="hidden" name="strCalDeliveryDate" />
		<input type="hidden" name="strDatePikerFlag" />
		<input type="hidden" name="strPOItemID"
			value="${supplierDeskTransBean.strPOItemID}" />
		<input type="hidden" name="strSchedule" />
		<input type="hidden" name="strApprovalFlag" value="1">
		<input type="hidden" name="strReApprovalFlag" value="0">
		<input type="hidden" name="strPOStoreId"
			value="${supplierDeskTransBean.strPOStoreId}" />
		<input type="hidden" name="strViewMode"
			value="${supplierDeskTransBean.strViewMode}" />
		<input type="hidden" name="strReOrderFlgColor"
			value="${supplierDeskTransBean.strReOrderFlgColor}" />
		<input type="hidden" name="strPOHiddenValue"
			value="${supplierDeskTransBean.strPOHiddenValue}" />
		<input type="hidden" name="strPOAuthTypeId"
			value="${supplierDeskTransBean.strPOAuthTypeId}" />
		<input type="hidden" name="strProgrammeSize" value="0" />
		<input type="hidden" name="strBatchNo" id="strBatchNo"/>
		<input type="hidden" name="strChk"
			value="${supplierDeskTransBean.strChk}" />
			
			<input type="hidden" name="strFSId"
			value="${supplierDeskTransBean.strFSId}">
		<input type="hidden" name="strPrgId"
			value="${supplierDeskTransBean.strPrgId}">

		<input type="hidden" name="hmode" />
			<input type="hidden" name="strCartonGene" value='1'>
			
			<input type="hidden" name="strBarCodeString"
			value="${supplierDeskTransBean.strBarCodeString}">
			
			<input type="hidden" name="strBatchExdateFlag"
			value="${supplierDeskTransBean.strBatchExdateFlag}">
			
			<input type="hidden" name="strPrevInvoiceExists" id = "strPrevInvoiceExists" 	value="" > 
			<div id="pdiFlagDivId">
			<input type="hidden" name="strNewPdiFlag"
			value="${supplierDeskTransBean.strNewPdiFlag}">
			</div>
			<input type="hidden" name="strNewTranche"
			value="${supplierDeskTransBean.strNewTranche}">
			
			
			


		<div class="loader"></div>
		<div id="backgroundPopup"></div>
		<div id='toPopup' style="width: 80%;">
			<div class='closePopup'></div>
			<span class='ecs_tooltip'>Press Esc to close <span
				class='arrow'></span></span>
			<div id='popup_content'>
				<div id="issueDtlsDivId" style="display: block;"></div>
			</div>
		</div>
		<cmbPers:cmbPers />
	</html:form>
	<div id='challanmultirow'></div>
		<div class="popup" id="barCodePopup" style="display: none; width: 750px;">

	<div id="barcodeContent" style=" width: 700px;" >
	</div>
	<!--<div id="barcodeContent" style="height: 300px;overflow: auto; width: 700px;" >
	</div>-->

</div>
<div id="mask"></div>
</body>
</html>