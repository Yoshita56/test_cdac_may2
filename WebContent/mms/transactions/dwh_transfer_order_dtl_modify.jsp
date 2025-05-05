<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset=UTF-8">
<script type="text/javascript">
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Item/Drug Transfer Order Generation</title>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">


<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>

<script language="Javascript"
	src="../js/transfer_order_dtl_generation.js"></script>

</head>

<body>
	<html:form name="TransferApprovalTransBean"
		action="/transactions/TransferApprovalTransCNT"
		type="mms.transactions.controller.fb.TransferApprovalTransFB">


		<div class="errMsg" id="errMsg">
			<bean:write name="TransferApprovalTransBean" property="strErr" />
		</div>
		<div class="warningMsg" id="warningMsg">
			<bean:write name="TransferApprovalTransBean" property="strWarning" />
		</div>
		<div class="normalMsg" id="normalMsg">
			<bean:write name="TransferApprovalTransBean" property="strMsg" />
		</div>

		<center>
			<tag:tab tabLabel="Item/Drug Transfer" selectedTab="FIRST" align="center"
				width="TABLEWIDTH">
			</tag:tab>
		</center>

		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
			cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4">Item/Drug Transfer &gt;&gt; Order &gt;&gt;
					Generation</td>
			</tr>

			<tr>
				<td width="25%" class="LABEL">HQ Name</td>
				<td width="25%" class="CONTROL">RMSC Supply Management Branch</td>
				<td width="25%" class="LABEL">Order No.</td>
				<td width="25%" class="CONTROL"><bean:write
						name="TransferApprovalTransBean" property="strOrderNo"
						filter="false" /></td>

			</tr>
			<tr>
				<td width="25%" class="LABEL">Order Date</td>
				<td width="25%" class="CONTROL"><bean:write
						name="TransferApprovalTransBean" property="strOrderDate"
						filter="false" /></td>
				<td width="25%" class="LABEL">Order Qty.</td>
				<td width="25%" class="CONTROL"><bean:write
						name="TransferApprovalTransBean" property="strOrderQty"
						filter="false" /></td>

			</tr>
			<tr>
				<td width="25%" class="LABEL">Demand No.</td>
				<td width="25%" class="CONTROL"><bean:write
						name="TransferApprovalTransBean" property="strDemandNo"
						filter="false" /></td>
				<td width="25%" class="LABEL">Demand Date</td>
				<td width="25%" class="CONTROL"><bean:write
						name="TransferApprovalTransBean" property="strDemandDate"
						filter="false" /></td>

			</tr>

			<tr>
				<td width="25%" class="LABEL">Demanding Store</td>
				<td width="25%" class="CONTROL"><bean:write
						name="TransferApprovalTransBean" property="strDemandingDDW"
						filter="false" /></td>

				<td width="25%" class="LABEL">Demand Qty.</td>
				<td width="25%" class="CONTROL"><bean:write
						name="TransferApprovalTransBean" property="strDemandQty"
						filter="false" /></td>

			</tr>

			<tr>
				<td width="25%" class="LABEL">Ordered Qty.</td>
				<td width="25%" class="CONTROL"><bean:write
						name="TransferApprovalTransBean" property="strOrderedQty"
						filter="false" /></td>
				<td width="25%" class="LABEL">Balance Qty.</td>
				<td width="25%" class="CONTROL"><bean:write
						name="TransferApprovalTransBean" property="strBalanceQty"
						filter="false" /></td>

			</tr>

			<tr>
				<td width="25%" class="LABEL">Item/Drug Name</td>
				<td width="75%" class="CONTROL" colspan="3"><bean:write
						name="TransferApprovalTransBean" property="strDrugName"
						filter="false" /></td>
			</tr>

		</table>

		<div id="transferingDtlsDivId">
			<bean:write name="TransferApprovalTransBean"
				property="strTransferingDetails" filter="false" />
		</div>

		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
			cellspacing="1px">
			<tr>
				<td width="50%" class="LABEL" valign="middle" colspan="2">Remarks(if
					Any)</td>
				<td width="50%" class="CONTROL" colspan="2"><textarea
						name="strRemarks" cols="25" rows="2"
						onkeypress="return validateData(event,9);"></textarea></td>
			</tr>
		</table>

		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
			cellspacing="1px">

			<tr class="FOOTER">
				<td colspan="4" width="25%"><font size="2" color="red">*</font>
					Mandatory Fields</td>
			</tr>
		</table>

		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
			cellspacing="1px">
			<tr>

				<td align="center"><img style="cursor: pointer;"
					src="../../hisglobal/images/btn-sv.png"
					onClick="validate_orderModify();" title="Click to Save Record" />
					<img style="cursor: pointer;"
					src="../../hisglobal/images/btn-clr.png"
					onClick="document.forms[0].reset();" title="Click to Clear Page" />
					<img style="cursor: pointer;"
					src="../../hisglobal/images/back_tab.png" onClick="cancel('LIST');"
					title="Click to Return On Desk" /></td>
			</tr>



		</table>

		<input type="hidden" name="hmode" />
		<input type='hidden' name="strOrderNo"
			value="${TransferApprovalTransBean.strOrderNo }">
		<input type='hidden' name="strDemandNo"
			value="${TransferApprovalTransBean.strDemandNo }">

		<input type='hidden' name="strItemBrandId"
			value="${TransferApprovalTransBean.strItemBrandId }">
		<input type='hidden' name="strTransStoreId"
			value="${TransferApprovalTransBean.strTransStoreId }">
		<input type='hidden' name="strTransRequestNo"
			value="${TransferApprovalTransBean.strTransRequestNo }">
		<input type='hidden' name="strBalanceQtyBaseValue"
			value="${TransferApprovalTransBean.strBalanceQtyBaseValue }">
			<input type='hidden' name="strStoreId"
			value="${TransferApprovalTransBean.strStoreId }">

		<div class='popup' id='itemDtlId' style="display: none">
			<table width='300' border="0" cellspacing="0px" cellpadding="0px">
				<tr class="HEADER">
					<th align='left'><div id="popUpItemId" style='color: blue;'>Balance
							Qty. Details</div></th>
					<th align='right'><img
						style='cursor: pointer; cursor: pointer'
						src='../../hisglobal/images/popUp_cancel.JPG'
						onClick="closeItemPopUp('itemDtlId');"
						title="Click Here To Close Popup"></th>
				</tr>
			</table>


			<table width='300' border="0" cellspacing="1px" cellpadding="1px">
				<tr>
					<td colspan="1" class='multiLabel'>Required Qty.</td>
					<td colspan="1" class='multiControl'><div id='reqQtyDivId'></div></td>
				</tr>
				<tr>
					<td colspan="1" class='multiLabel'>Ordered Qty.</td>
					<td colspan="1" class='multiControl'><div id='ordQtyDivId'></div></td>
				</tr>
				<tr class="FOOTER">
					<td colspan="2"></td>
				</tr>
			</table>
		</div>


		<cmbPers:cmbPers />
	</html:form>
	<tag:autoIndex></tag:autoIndex>
</body>
</html>
