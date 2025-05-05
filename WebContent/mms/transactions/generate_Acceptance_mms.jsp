
<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>

<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>PO Desk</title>
<link href="../../hisglobal/css/dwh.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">


<script language="JavaScript"
	src="../../hisglobal/jquery/3.6.0.min.js"></script>


<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script type="text/javascript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript"
	src="../../mms/js/SupplierInterfaceTrans.js"></script>
<script language="Javascript"
	src="../../hisglobal/js/utilityFunctions.js"></script>
<script language="Javascript"
	src="../../hisglobal/js/commonFunctions.js"></script>

</head>
<body class="background" onLoad='putDaynamicDiv(4,0);'>
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

		</center>
		<table class='NEWTABLEWIDTH' align="center" cellspacing="0"
			id='divHeader'>
			<tr class="HEADER">
				<td colspan="4" width="95%" nowrap="nowrap">Supplier Acceptance form</td>
			</tr>
		</table>

		<table class='NEWTABLEWIDTH' align="center" cellpadding="1px"
			cellspacing="1px">

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
				<td class="LABEL" width="25%" colspan="1">Po generation period :</td>
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
				<td class="LABEL" width="25%" colspan="1">Po no System Generated :</td>
				<td class="CONTROL" width="25%" colspan="3"><bean:write
						name="supplierDeskTransBean" property="strPONo" filter="false"></bean:write>
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

			<tr>
				<td colspan='4'>

					<table width='100%' align="center" cellpadding="1px"
						cellspacing="1px">
						<tr>
							<td class="LABEL" width='25%'>Drug/item name(s) :</td>
							<td width='25%' class="CONTROL"><select name="strPOItemID"
								id="strPOItemID" class="comboMax"
								onchange="putDaynamicDiv(5,0);">
									<bean:write name="supplierDeskTransBean"
										property="strPOItemCmb" filter="false"></bean:write>
							</select></td>

							<td width='25%' class="LABEL">Default Pack Size :</td>
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
					<td width="25%" class="LABEL">Rate/unit :</td>
					<td width="25%" class="CONTROL">
						<div id="rateDivID"></div>
					</td>
					<td width="25%" class="LABEL">Tax :</td>
					<td width="25%" class="CONTROL"><div id="strItemRateTax"></div></td>
				</tr>
				<tr>
				<td width="25%" class="LABEL">Excise Tax(%) :</td>
					<td width="25%" class="CONTROL"><div id="strItemRateAddTax"></div></td>
					<td width="25%" class="LABEL">Total rate(one unit) :</td>
					<td width="25%" colspan="1" class="CONTROL">
						<div id="strItemTotalRate"></div>
					</td>
					<td width="25%" class="LABEL"></td>
				<td width="25%" class="CONTROL"><input type="hidden"
					name="strItemManufacturerId"
					value="${supplierDeskTransBean.strManufacturerValues}" /> 
					<div id="mfgNameId">
					<bean:write
						name="supplierDeskTransBean" property="strManufacturerValues"
						filter="false"></bean:write>
						</div>
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



		<div id="divPurchaseDetails" style="display: none;">

			<div class="line" style="width: 101%; margin-left: 0%;">
				<table class='NEWTABLEWIDTH' align="center" cellspacing="1px"
					cellpadding="1px">
					<tr>
						<td width="95%">Purchase detail(s) :</td>
					</tr>
				</table>
			</div>
			<table class='NEWTABLEWIDTH' align="center" cellpadding="1px"
				cellspacing="1px">
				<tr>
					<td width="25%" class="LABEL">Po reference :</td>
					<td width="25%" class="CONTROL">
						<div id="divPurchaseRefrenceNoId">
							<bean:write name="supplierDeskTransBean"
								property="strPoRefrenceNoCmb" filter="false"></bean:write>
						</div>

					</td>
					<td width="25%" class="LABEL">Supplier contracted quantity :</td>
					<td width="25%" class="CONTROL"><div
							id="contractedDeliveryDaysId"><bean:write
							name="supplierDeskTransBean" property="strRateContQty"
							filter="false"></bean:write></div></td>

				</tr>
				<tr>
					<td width="25%" class="LABEL">Purchase source :</td>
					<td width="25%" class="CONTROL">
						<div id="divPurchaseSource">


							<bean:write name="supplierDeskTransBean"
								property="strPurchaseSourceValues" filter="false"></bean:write>

						</div>
					</td>

					<td width="25%" class="LABEL">Delivery day(s)</td>

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
							Tender no :
						</div></td>
					<td width="25%" class="CONTROL">
						<div id="strDTenderNo"></div>
					</td>

					<td width="25%" class="LABEL"><div id="tenderDateLevel">
							Tender date	:
						</div></td>
					<td width="25%" class="CONTROL">
						<div id="strDTenderDate"></div>

					</td>


				</tr>
				</table>
				<div id="" style="display:none;">
				<table class='NEWTABLEWIDTH' align="center" cellpadding="1px"	cellspacing="1px">
				<tr>
					<td width="25%" class="LABEL"><div id="quotationLevel">
							Quotation no :
						</div></td>
					<td width="25%" class="CONTROL">

						<div id="strDQuotationNo"></div>

					</td>

					<td width="25%" class="LABEL"><div id="quotationDateLevel">
							Quotation_date :
						</div></td>
					<td width="25%" class="CONTROL">
						<div id="strDQuotationDate"></div>
					</td>
				</tr>
				<tr>
					<td colspan="1" class="LABEL">Reference :</td>
					<td colspan="3" class="LABEL"><div
							id="divMultiPurchaseRefrenceNoTextId" align="left">
							<div id="strPoMultiRefrenceNo"></div>
						</div></td>

				</tr>
				
				</table>
				</div>
				<table class='NEWTABLEWIDTH' align="center" cellpadding="1px"	cellspacing="1px">
				

				<tr>
					<td width="25%" class="LABEL">Next po date :</td>
					<td width="25%" class="CONTROL">
						<div id="strNextPoDate"></div>
					</td>
					<td width="25%" class="LABEL">Purchase committee meeting date :</td>
					<td width="25%" class="CONTROL">
						<div id="strPurchaseCommitteMeetingDate"></div>

					</td>
				</tr>
				<tr>
					<td width="25%" class="LABEL">Approved by :</td>
					<td width="25%" class="CONTROL"><bean:write
							name="supplierDeskTransBean" property="strApprovedByVals"
							filter="false"></bean:write></td>
					<td width="25%" class="LABEL">Approved date :</td>
					<td width="25%" class="CONTROL"><bean:write
							name="supplierDeskTransBean" property="strVerifiedDate"
							filter="false"></bean:write></td>
				</tr>

				<tr>
					<td width="25%" class="LABEL">remarks :</td>
					<td width="25%" class="CONTROL"><bean:write
							name="supplierDeskTransBean" property="strDRemarks" /></td>
					<td width="25%" class="LABEL">Total po cost(rs.) :</td>
					<td width="25%" class="CONTROL"><div id="totalPOCost"
							style="color: red; font-weight: bold">0.00</div> <input
						type="hidden" name="strTotalPOCost"></td>

				</tr>
			</table>
		</div>

		<div class="line" style="width: 101%; margin-left: 0%;">
			<table class='NEWTABLEWIDTH' align="center" cellpadding="1px"
				cellspacing="1px">
				<tr>
					<td colspan="5">
						<div id="divComponentPlusID" style="display: none;" align="left">
							<img src="../../hisglobal/images/plus.gif"
								onclick="hideDiv1('divComponentPlusID'),showDiv1('divComponentMinusID'),showDiv1('divComponentDetails');"
								style="cursor: pointer;">
							Component_details
						</div>
						<div id="divComponentMinusID" style="display: block;" align="left">
							<img src="../../hisglobal/images/minus.gif"
								onclick="hideDiv1('divComponentMinusID'),showDiv1('divComponentPlusID'),hideDiv1('divComponentDetails');"
								style="cursor: pointer;">Component_details
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div id="divComponentDetails" style="display: block;"></div>


		<div class="line" style="width: 101%; margin-left: 0%;">
			<table class='NEWTABLEWIDTH' align="center" cellspacing="1px"
				cellpadding="1px">
				<tr>
					<td width="95%">Acceptance detail(s)</td>
				</tr>
			</table>
		</div>
		<table class='NEWTABLEWIDTH' align="center" cellspacing="0px"
			cellpadding="1">
			<tr>
				<td class='LABEL' width='25%'><font color="red">*</font>
				Acceptance status :</td>
				<td width='25%' class='CONTROL' colspan='3'><input type='radio'
					name='strApproved' value='1' checked='checked'
					onClick='FuncTick(this),setApprovedQty();' />Acceptance <input type='radio'
					name='strRejected' value='2'
					onClick="FuncTick(this),setApprovedQty();" />Rejected </td>
			</tr>
		</table>

		<table class='NEWTABLEWIDTH' align='center' cellspacing='0px'
			cellpadding='1'>
			<tr>
				<td width='50%' class='LABEL'><div id='remarks'>
						remarks
					</div></td>
				<td width='50%' class='CONTROL' colspan='3'><textarea
						name='strRemarks' cols='25' rows='2'></textarea></td>
			</tr>
		</table>


		<table class='NEWTABLEWIDTH' align="center" cellpadding="1px"
			cellspacing="1px">
			<tr class="FOOTER">
				<td colspan="4"></td>
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
								<a href="#" class="button" onClick="return SaveAcceptance();"
									title="Save Record"><span class="save">Save</span></a> <a href="#" class="button"
									onClick="resetForm(1);" title="Click to Clear Page"><span
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
				<li><font color='red'>*</font>Mandatory_Field(s)</li>
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
		<cmbPers:cmbPers />
	</html:form>

</body>
</html>