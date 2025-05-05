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
<script language="Javascript"
	src="../../mms/js/SupplierInterfaceTrans.js"></script>
<script language="Javascript"
	src="../../hisglobal/js/commonFunctions.js"></script>

</head>
<body class="background" onLoad='putDaynamicDiv(4,1);'>
	<div id="mask" style="display: block;"></div>
	<div id="dvLoading" style="display: block;"></div>
	<html:form styleClass="formbg"
		action="/transactions/SupplierDeskInterfaceTransCNT">
		<center>
			<div id="errMsg" class="errMsg">
				<bean:write name="supplierDeskTransBean" property="strErr" />
			</div>
			<div id="warningMsg" class="warningMsg">
				<bean:write name="supplierDeskTransBean" property="strWarning" />
			</div>
			<div id="normalMsg" class="normalMsg">
				<bean:write name="supplierDeskTransBean" property="strMsg" />
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
						<td width="50%" class="LABEL" style="text-align: right;">Ordered Qty.=</td>
						<td width="50%" class="CONTROL" style="text-align: left;">
							<div id='offLineBalOrdQtyDivId'></div>
						</td>
					</tr>
					<tr>
						<td width="50%" class="LABEL" style="text-align: right;">Stop Qty pop =</td>
						<td width="50%" class="CONTROL" style="text-align: left;">
							<div id='offLineStopDivId'></div>
						</td>
					</tr>
					<tr>
						<td width="50%" class="LABEL" style="text-align: right;">Supply Qty till Date =</td>
						<td width="50%" class="CONTROL" style="text-align: left;">
							<div id='offLineBalRecQtyDivId'></div>
						</td>
					</tr>
					<tr>
						<td width="50%" class="LABEL" style="text-align: right;">Rejected Qty till Date =</td>
						<td width="50%" class="CONTROL" style="text-align: left;">
							<div id='offLineBalRejQtyDivId'></div>
						</td>
					</tr>
					<tr>
						<td width="50%" class="LABEL" style="text-align: right;">Shortage Qty till Date =</td>
						<td width="50%" class="CONTROL" style="text-align: left;">
							<div id='offLineBalShortQtyDivId'></div>
						</td>
					</tr>
					<tr>
						<td width="50%" class="LABEL" style="text-align: right;">Rej Qty After Verify =</td>
						<td width="50%" class="CONTROL" style="text-align: left;">
							<div id='offLineBalRejQtyAfterVerifyDivId'></div>
						</td>
					</tr>
					<tr>
						<td width="50%" class="LABEL" style="text-align: right;">Supplier Return Qty =</td>
						<td width="50%" class="CONTROL" style="text-align: left;">
							<div id='offLineSupplierReturnQtyDivId'></div>
						</td>
					</tr>
					<tr>
						<td width="50%" class="LABEL" style="text-align: right;">Replacement Order Qty =</td>
						<td width="50%" class="CONTROL" style="text-align: left;">
							<div id='offLineBalReplacementOrderQtyDivId'></div>
						</td>
					</tr>

					<tr>

						<td colspan="4" bgcolor="black"></td>
					</tr>
					<tr>
						<td width="50%" class="LABEL" style="text-align: right;">Balanced Qty Challan =</td>
						<td width="50%" class="CONTROL" style="text-align: left;">
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

		</center>
		<table class='NEWTABLEWIDTH' align="center" cellspacing="0"
			id='divHeader'>
			<tr class="HEADER">
				<td colspan="4" width="95%" nowrap="nowrap">Supplier Acceptance View</td>
			</tr>
		</table>

		<table class='NEWTABLEWIDTH' align="center" cellpadding="1px"
			cellspacing="1px">

			<tr>
				<td width="25%" class="LABEL">Supplier Name:</td>
				<td class="CONTROL"><bean:write name="supplierDeskTransBean"
						property="strSupplierName" filter="false"></bean:write> <html:hidden
						name="supplierDeskTransBean" property="strSupplierId"></html:hidden>
					<html:hidden name="supplierDeskTransBean"
						property="strSupplierName"></html:hidden></td>


				<td width="25%" class="LABEL">Po_type :</td>
				<td class="CONTROL"><bean:write name="supplierDeskTransBean"
						property="strComboPOTypeValue" filter="false"></bean:write> <html:hidden
						name="supplierDeskTransBean" property="strComboPOTypeId"></html:hidden>


				</td>



			</tr>

			<tr>
				<td class="LABEL" width="25%" colspan="1">Po generation period:</td>
				<td class="CONTROL" width="25%" colspan="1"><bean:write
						name="supplierDeskTransBean" property="strPOFinancialYear"
						filter="false"></bean:write> <html:hidden
						name="supplierDeskTransBean" property="strIndentPeriodValue"></html:hidden>



				</td>

				<td width="25%" class="LABEL">Purchase order date:</td>
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
				<td class="CONTROL" width="25%" colspan="3"><bean:write
						name="supplierDeskTransBean" property="strPONo" filter="false"></bean:write>
				</td>


			</tr>

			<tr>
				<td colspan='4'>

					<table width='100%' align="center" cellpadding="1px"
						cellspacing="1px">
						<tr>
							<td class="LABEL" width='25%'>Drug/item name(s) :</td>
							<td width='25%' class="CONTROL"><select name="strPOItemID"
								id="strPOItemID" class="comboMax"
								onchange="putDaynamicDiv(5,1);">
									<bean:write name="supplierDeskTransBean"
										property="strPOItemCmb" filter="false"></bean:write>
							</select></td>

							<td width='25%' class="LABEL">Default Pack Size:</td>
							<td width='25%' class="CONTROL"><div id="itemOrderQty"></div></td>

						</tr>

					</table>
				</td>
			</tr>

			<div id="imageDiv" align="left"></div>


		</table>



		<div id="poRateDivId" style="display: none;">
			<table class='NEWTABLEWIDTH' align="center" cellpadding="1px"
				cellspacing="1px">

				<tr>
					<td width="25%" class="LABEL">Manufacturer:</td>
					<td width="25%" class="CONTROL"><input type="hidden"
						name="strItemManufacturerId"
						value="${supplierDeskTransBean.strManufacturerValues}" /> <bean:write
							name="supplierDeskTransBean" property="strManufacturerValues"
							filter="false"></bean:write></td>
					<td width="25%" class="LABEL">Make:</td>
					<td width="25%" class="CONTROL">
						<div id="itemMakeDiv">
							<input type="hidden" name="strItemMake" value="1" /> Indian
						</div>
					</td>
				</tr>
				<tr>
					<td width='25%' colspan="1" class="LABEL">Programme Name:</td>
					<td width='25%' colspan="1" class="CONTROL">
					   <bean:write	name="supplierDeskTransBean" property="strPrgName" filter="false"></bean:write>

					</td>
					<td width='25%' colspan="1" class="LABEL">Funding Source:</td>
					<td width='25%' colspan="1" class="CONTROL">
						<bean:write
				name="supplierDeskTransBean" property="strFSName" filter="false"></bean:write>

					</td>
			</tr>
				
				<tr>
					<td width="25%" class="LABEL">Rate/unit:</td>
					<td width="25%" class="CONTROL">
						<div id="rateDivID"></div>
					</td>
					<td width="25%" class="LABEL">Tax:</td>
					<td width="25%" class="CONTROL"><div id="strItemRateTax"></div></td>
				</tr>
				<tr>
				
				<td width="25%" class="LABEL">Excise Tax(%):</td>
					<td width="25%" class="CONTROL"><div id="strItemRateAddTax"></div></td>
					
					<td width="25%" class="LABEL">Total rate(one_unit):</td>
					<td width="25%" colspan="3" class="CONTROL">
						<div id="strItemTotalRate"></div>
					</td>
				</tr>
			</table>
		</div>
		<div id="generateDynamicDiv"></div>


		<div style="width: 100%; overflow: auto;">
			<table width='100%' align="center" border="0" cellspacing="1px"
				id='mstTable'>
				<tr>
					<td align='center'>
						<div id="indentItemList">

							<bean:write name="supplierDeskTransBean"
								property="strIndentItemList" filter="false" />

						</div>
					</td>
				</tr>
			</table>
		</div>


		<div id="divDeliveryDetails" style="display: none;">
			<div class="line" style="width: 101%; margin-left: 0%;">
				<table class='NEWTABLEWIDTH' align="center" cellspacing="1px"
					cellpadding="1px">
					<tr>
						<td width="95%">Delivery details:</td>
					</tr>
				</table>
			</div>
			<div id="previousDeliveryDtls"></div>
		</div>

		<div id="divPurchaseDetails" style="display: none;">
			<div class="line" style="width: 101%; margin-left: 0%;">
				<table class='NEWTABLEWIDTH' align="center" cellspacing="1px"
					cellpadding="1px">
					<tr>
						<td width="95%">Purchase detail(s):</td>
					</tr>
				</table>
			</div>
		</div>
		<table class='NEWTABLEWIDTH' align="center" cellpadding="1px"
			cellspacing="1px">
			<tr>
				<td width="25%" class="LABEL">Po reference:</td>
				<td width="25%" class="CONTROL">
					<div id="divPurchaseRefrenceNoId">
						<bean:write name="supplierDeskTransBean"
							property="strPoRefrenceNoCmb" filter="false"></bean:write>
					</div>

				</td>
				<td width="25%" class="LABEL">Supplier contracted quantity:</td>
				<td width="25%" class="CONTROL"><div
						id="contractedDeliveryDaysId"></div></td>

			</tr>
				<tr>
					<td width="25%" class="LABEL">Purchase_source:</td>
					<td width="25%" class="CONTROL">
						<div id="divPurchaseSource">


							<bean:write name="supplierDeskTransBean"
								property="strPurchaseSourceValues" filter="false"></bean:write>

						</div>
					</td>

					<td width="25%" class="LABEL">Delivery day(s):</td>

					<td width="25%" class="CONTROL"><bean:write
							name="supplierDeskTransBean" property="strDDeliveryDays"
							filter="false"></bean:write>
					</td>
				</tr>
		</table>

		<table class='NEWTABLEWIDTH' align="center" cellpadding="1px"
			cellspacing="1px">
			<tr>
				<td width="25%" class="LABEL"><div id="tenderLevel">
						Tender no
						:
					</div></td>
				<td width="25%" class="CONTROL">
					<div id="strDTenderNo"></div>
				</td>

				<td width="25%" class="LABEL"><div id="tenderDateLevel">
						Tender date
						:
					</div></td>
				<td width="25%" class="CONTROL">
					<div id="strDTenderDate"></div>

				</td>


			</tr>
			<tr>
				<td width="25%" class="LABEL"><div id="quotationLevel">
						Quotation no
						:
					</div></td>
				<td width="25%" class="CONTROL">

					<div id="strDQuotationNo"></div>

				</td>

				<td width="25%" class="LABEL"><div id="quotationDateLevel">
						Quotation date:
					</div></td>
				<td width="25%" class="CONTROL">
					<div id="strDQuotationDate"></div>
				</td>
			</tr>
			<tr>
				<td colspan="1" class="LABEL">Reference:</td>
				<td colspan="3" class="LABEL"><div
						id="divMultiPurchaseRefrenceNoTextId" align="left">
						<div id="strPoMultiRefrenceNo"></div>
					</div></td>

			</tr>


			<tr>
				<td width="25%" class="LABEL">Next po date:</td>
				<td width="25%" class="CONTROL">
					<div id="strNextPoDate"></div>
				</td>
				<td width="25%" class="LABEL">Purchase committee meeting date:</td>
				<td width="25%" class="CONTROL">
					<div id="strPurchaseCommitteMeetingDate"></div>

				</td>
			</tr>
			<tr>
				<td width="25%" class="LABEL">Verified by:</td>
				<td width="25%" class="CONTROL"><bean:write
						name="supplierDeskTransBean" property="strApprovedByVals"
						filter="false"></bean:write></td>
				<td width="25%" class="LABEL">Verified_date:</td>
				<td width="25%" class="CONTROL"><bean:write
						name="supplierDeskTransBean" property="strVerifiedDate"
						filter="false"></bean:write></td>
			</tr>

			<tr>
				<td width="25%" class="LABEL">Remarks:</td>
				<td width="25%" class="CONTROL"><bean:write
						name="supplierDeskTransBean" property="strDRemarks" /></td>
				<td width="25%" class="LABEL">Total PO cost(rs.):</td>
				<td width="25%" class="CONTROL"><div id="totalPOCost"
						style="color: red; font-weight: bold">0.00</div> <input
					type="hidden" name="strTotalPOCost"></td>

			</tr>
		</table>


		<div class="line" style="width: 101%; margin-left: 0%;">
			<table class='NEWTABLEWIDTH' align="center" cellpadding="1px"
				cellspacing="1px">
				<tr>
					<td colspan="5">
						<div id="divComponentPlusID" style="display: none;" align="left">
							<img src="../../hisglobal/images/plus.gif"
								onclick="hideDiv1('divComponentPlusID'),showDiv1('divComponentMinusID'),showDiv1('divComponentDetails');"
								style="cursor: pointer;">
							Component details
						</div>
						<div id="divComponentMinusID" style="display: block;" align="left">
							<img src="../../hisglobal/images/minus.gif"
								onclick="hideDiv1('divComponentMinusID'),showDiv1('divComponentPlusID'),hideDiv1('divComponentDetails');"
								style="cursor: pointer;">
							Component details
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div id="divComponentDetails" style="display: block;"></div>


		<table class='NEWTABLEWIDTH' align="center" cellpadding="1px"
			cellspacing="1px">
			<tr class="FOOTER">
				<td colspan="4"></td>
			</tr>
		</table>

		<div class="control_button" id="divSaveCancelId"
			style="display: block">
			<table border="0" class="NEWTABLEWIDTH" align="center"
				cellspacing="1px" cellpadding="1px">
				<tr>
					<td align="center">
						<div style="margin-left: 20%">
							<a href="#" class="button" onClick="cancelToGenerateDesk('2');"
								title="Cancel Process"><span class="cancel">Cancel</span></a>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div class="legends" style="width: 95%;">
			<ul>
				<li><b> Supplier Bal Qty Dtls</b></li>
			</ul>
		</div>

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
		<input type="hidden" name="strSchedule" />
		<input type="hidden" name="strApprovalFlag" value="1">
		<input type="hidden" name="strReApprovalFlag" value="0">
		<input type="hidden" name="strStoreId"
			value="${supplierDeskTransBean.strStoreId}" />
		<input type="hidden" name="strViewMode"
			value="${supplierDeskTransBean.strViewMode}" />
		<input type="hidden" name="strReOrderFlgColor"
			value="${supplierDeskTransBean.strReOrderFlgColor}" />
		<input type="hidden" name="strPOHiddenValue"
			value="${supplierDeskTransBean.strPOHiddenValue}" />
		<input type="hidden" name="strPOAuthTypeId"
			value="${supplierDeskTransBean.strPOAuthTypeId}" />
		<input type="hidden" name="strChk"
			value="${supplierDeskTransBean.strChk}" />

		<input type="hidden" name="hmode" />
			<input type="hidden" name="strHtmlCode" />

		<div class="loader"></div>
		<div id="backgroundPopup"></div>
		<div id='toPopup' >
			<div class='closePopup'></div>
			
			
			<span class='ecs_tooltip'>Press Esc to close <span
				class='arrow'></span></span>
			<div id='popup_content'>
				<div id="issueDtlsDivId" style="display: block;"></div>
			</div>
		</div>
		
		
		
		
		

		<cmbPers:cmbPers />
	</html:form>

</body>
</html>