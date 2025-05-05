
<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Drug Transfer Order Generation</title>

<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/dwh.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet"
	type="text/css">


<script language="JavaScript"
	src="../../hisglobal/js/jquery-3.3.1.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/jquery-ui.min.js"></script>
<script language="JavaScript"
	src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/base64.js"></script>

<script language="Javascript"
	src="../../hisglobal/js/commonFunctions.js"></script>
<script language="Javascript"
	src="../js/transfer_order_dtl_generation_new.js"></script>
<style type="">
.circle {
	-webkit-border-radius: 8px;
	-moz-border-radius: 8px;
	border-radius: 8px;
	border: 1px solid #faad07;
	width: 15px;
	height: 15px;
	background-color: #faad07;
}
</style>
</head>
<script>
	$(function() {
		var divHeight = 100;
		var initialHeight = 716;
		var heightPer = (divHeight * 100) / initialHeight;
		var newHeight = parseInt((window.innerHeight * heightPer) / 100, 10);

		fixedHeaderTableTrans("wrapper", newHeight);
	});

	function getDrugNameSelected(itemId) {
		var flag = 0;
		var sel = document.forms[0].strItemBrandId;

		for ( var i = 0; i < sel.options.length; i++) {
			if (sel.options[i].value.split("^")[0] == itemId) {
				sel.selectedIndex = i;
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			sel.selectedIndex = 0;
			document.forms[0].strSearchDrug.value = "";
		} else {
			getUnitName();
		}

	}
	/***end***/

	$(function() {

		var itemList = [];
		$('#strItemBrandId option').each(function() {
			itemList.push({
				"value" : this.textContent,
				"data" : this.value.split("^")[0]
			});
		});

		$('#strSearchDrug').autocomplete({
			lookup : itemList,
			minChars : 3,
			onSelect : function(suggestion) {
				getDrugNameSelected(suggestion.data);
			}
		});

		$('#strSearchDrug').click(function() {
			$(this).val("");
		});
	});
</script>
<body class="background" onload="">
	<html:form name="TransferOrderDetailTransBean"
		action="/transactions/TransferOrderDetailTransCNT"
		type="mms.transactions.controller.fb.TransferOrderDetailTransFB"
		styleClass="formbg">
<input type='hidden' name='IMCS_TOKEN' value='<%=request.getSession().getAttribute("IMCS_TOKEN").toString().trim() %>'/>	


		<div class="errMsg" id="errMsg">
			<bean:write name="TransferOrderDetailTransBean" property="strErr" />
		</div>
		<div class="warningMsg" id="warningMsg">
			<bean:write name="TransferOrderDetailTransBean" property="strWarning" />
		</div>
		<div class="normalMsg" id="normalMsg">
			<bean:write name="TransferOrderDetailTransBean" property="strMsg" />
		</div>


		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
			cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4"><bean:message
						key="label.common.Transfer_order_generation" /></td>
			</tr>

			<tr>
				<td width="25%" class="LABEL"><bean:message
						key="label.common.Store_Name" /></td>
				<td width="25%" class="CONTROL"><bean:write
						name="TransferOrderDetailTransBean" property="strStoreName"
						filter="false" /></td>
				<td width="25%" class="LABEL"><bean:message
						key="label.common.Order_date" /></td>
				<td width="25%" class="CONTROL"><bean:write
						name="TransferOrderDetailTransBean" property="strCtDate"
						filter="false" /></td>

			</tr>

			<tr>
				<td width="25%" class="LABEL"><font color="red">*</font>
				<bean:message key="label.common.Requesting_store" /></td>
				<td width="25%" class="CONTROL"><select
					name='strRequestingStoreId' class="ComboNormal"><bean:write
							name="TransferOrderDetailTransBean" property="strStoreNameList"
							filter="false"></bean:write></select></td>
				<td width="25%" class="LABEL"><font color="red">*</font>
				<bean:message key="label.common.Transfering_store" /></td>
				<td width="25%" class="CONTROL"><select
					name='strTransferingStoreId' class="ComboNormal"
					onchange="getItemDetails(this);"><bean:write
							name="TransferOrderDetailTransBean" property="strStoreNameList"
							filter="false"></bean:write></select></td>

			</tr>

		</table>

		<div id='mainArea' style="display: none;">

			<div class="line">
				<table class="TABLEWIDTH" align="center" border="0"
					cellpadding="0px" cellspacing="0px">
					<tr>
						<td colspan="4"><bean:message
								key="label.common.Added_Order_Drug_Detail" /></td>
					</tr>
				</table>
			</div>

			<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
			cellspacing="1px">
			<tr>
				<td colspan="4" align="center">
					<table cellspacing="0" cellpadding="3" border="0"
						id="headerTableTrans"
						style="width: 100%; table-layout: fixed; border-collapse: collapse;">
						<tr>
							<th style="width: 35%;"><bean:message key="label.common.Drug_Name"/></th>
							<th style="width: 15%;"><bean:message key="label.common.Batch_No."/></th>
							<th style="width: 10%;"><bean:message key="label.common.Available_qty"/></th>
							<th style="width: 10%;"><bean:message key="label.common.Expiry_Date"/></th>
							<th style="width: 10%;"><bean:message key="label.common.Mfg_date"/></th>
							<th style="width: 10%;"><bean:message key="label.common.Excess_qty"/></th>
							<th style="width: 10%;"><bean:message key="label.common.Action"/></th>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<div style="height: 100px; overflow: auto;">
						<table cellspacing="0" cellpadding="3" border="0" id="tbl-content"
							style="width: 100%; table-layout: fixed; background: #fff; border-collapse: collapse;">

						</table>
					</div>
				</td>
			</tr>
		</table>

			<div class='line'>
				<table class="TABLEWIDTH" align="center" border="0"
					cellpadding="1px" cellspacing="1px">
					<tr>
						<td colspan="4"><bean:message
								key="label.common.New_Order_Detail" /></td>
					</tr>
				</table>
			</div>

			<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
				cellspacing="1px">
				<tr>
					<td class="LABEL" width="25%"><bean:message
							key="label.common.Group_Name" /></td>
					<td class="CONTROL" width="25%">
						<div id="GroupNameDiv">
							<select name="strGroupId" class='comboMax'
								onChange="getSubGrpAndGenericItem(this);">
								<bean:write name="TransferOrderDetailTransBean"
									property="strGroupNameCombo" filter="false"></bean:write>
							</select>
						</div>
					</td>
					<td class="LABEL" width="25%"><bean:message
							key="label.common.Sub_Group_Name" /></td>
					<td class="CONTROL" width="25%">
						<div id="SubGroupNameDiv">
							<select name="strSubGroupCode" class='comboMax'
								onchange="ajaxItemBrandName();">
								<bean:write name="TransferOrderDetailTransBean"
									property="strSubGroupCombo" filter="false"></bean:write>
							</select>
						</div>
					</td>
				</tr>

				<tr style="display: none">
					<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>
					<bean:message key="label.common.Item_Name" /></td>
					<td class="CONTROL" width="60%" colspan="2">
						<div id="ItemBrandId">
							<select id="strItemBrandId" name="strItemBrandId"
								class='comboHalfMax' onChange='getUnitName();'>
								<bean:write name="TransferOrderDetailTransBean"
									property="strItemNameCombo" filter="false"></bean:write>
							</select>
						</div>
					</td>

					<td class="CONTROL" width="15%"></td>
				</tr>
				<tr>
					<td class="LABEL" width="25%" colspan="1"><font color="red">*</font>
					<bean:message key="label.common.Item_Name" /></td>
					<td class="CONTROL" width="75%" colspan="3"><input type="text"
						id="strSearchDrug" name="strSearchDrug" size="90%" /></td>
				</tr>

				<tr>
					<td class="LABEL" width="25%" colspan="1"><bean:message
							key="label.common.Selected_item_name" /></td>
					<td class="CONTROL" width="75%" colspan="3">
						<div id="DrugNameId" style="color: blue; font-weight: bold"></div>
					</td>
				</tr>
				<tr>
					<td class="LABEL" width="25%" colspan="1"><div
							id="avlaibleQtyName"
							style="color: brown; font-weight: bold; display: none;">
							<bean:message key="label.common.Available_qty" />
						</div></td>
					<td class="CONTROL" colspan="3"><div id="avlaibleQtyId"
							style="color: brown; font-weight: bold"></div></td>
				</tr>
			</table>

			<div id="batchDtl"></div>

			<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
				cellspacing="1px">
				<tr>
					<td class="CONTROL" colspan="4" style="text-align: center;">
						<div style="margin-left: 50%;">
							<a href="#" class="button" title="Click Here To Add Item"
								onClick="toCart();"><span class="add"><bean:message
										key="label.common.Add" /></span></a>
						</div>
					</td>
				</tr>

			</table>

			<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
				cellspacing="1px">
				<tr>
					<td width="50%" class="LABEL" valign="middle" colspan="2"><bean:message
							key="label.common.Remarks(if_any)" /></td>
					<td width="50%" class="CONTROL" colspan="2"><textarea
							name="strRemarks" cols="25" rows="2"
							onkeypress="return validateData(event,9);"></textarea></td>
				</tr>
			</table>

		</div>

		<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
			cellspacing="1px">
			<tr class="FOOTER">
				<td colspan="4" width="25%"></td>
			</tr>
		</table>



		<div class="control_button">
			<table class="TABLEWIDTH" align="center">
				<tr>
					<td align="center"><div>
							<a href="#" class="button" title="Click to Save Record"
								onClick="validate_orderGenerate();"><span class="save"><bean:message
										key="label.common.Save" /></span></a> <a href="#" class="button"
								title="Click to Clear Page" onclick="ClearPage();"><span
								class="clear"><bean:message key="label.common.Clear" /></span></a>
							<a href="#" class="button" title="Click to Return On Desk"
								onClick="cancel('LIST');"><span class="back"><bean:message
										key="label.common.Back" /></span></a>
						</div></td>
				</tr>
			</table>
		</div>


		<div class="legends" style="width: 95%;">
			<ul>
				<li style='float: none;'><bean:message
						key="label.common.The_records_in_blue_color_doesn't_contain_any_transfer_detail(s)" /></li>
				<li style='float: none;'><div class="circle"
						style="float: left; margin-right: 5px;"></div> <bean:message
						key="label.common.No_available_quantity" /></li>
			</ul>
		</div>

		<input type="hidden" name="hmode" />
		<input type="hidden" name="strReqQtyTemp" value='0' />
		<input type="hidden" name="strTmpStoreId"
			value="${TransferOrderDetailTransBean.strTmpStoreId}">
		<input type="hidden" name="strStoreName"
			value="${TransferOrderDetailTransBean.strStoreName}">
		<input type="hidden" name="orderDate"
			value="${TransferOrderDetailTransBean.strCtDate}">

		<input id="itemName" value="Please Select Item" type="hidden">
		<input id="excessQty"
			value="Please Enter Excess Quantity for at least one batch"
			type="hidden">

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
					<td colspan="1" class='multiLabel'>Excess Qty.</td>
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
