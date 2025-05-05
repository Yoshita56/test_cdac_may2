<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<form name="multirow">
<logic:equal value="0"
	name="requestForRoutinePurchase" property="strCostRequired">
	<div id="rowAdded1" style="display: none">
	<table class="TABLEWIDTH" bgcolor='#CC9966' align="center"
		cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="multiControl" width="35%"><input type="hidden"
				name="itemParamValue" id="itemParamValue#delIndex#"> <input
				type="hidden" name="itemCalcValue" id="itemCalcValue#delIndex#">
			<input type="hidden" name="itemUserValue"
				id="itemUserValue#delIndex#">
			<div id='strCostDivId#delIndex#' style="display: none;">0.00</div>
			<input type="hidden" name="strCost" value="0.00"
				id="strCost#delIndex#">


			<div id="itemParaId1#delIndex#"></div>
			</td>

			<td class="multiControl" width="12%">
			<div id="itemParaId4#delIndex#"></div>
			</td>

			<td class="multiControl" width="12%">
			<div id="itemParaId10#delIndex#"></div>
			</td>

			<td class="multiControl" width="8%"><img
				src='../../hisglobal/images/viewDetails.gif'
				title='To Get Last Purchase Details'
				style='cursor: pointer; cursor: pointer;'
				onClick="getAnnualPurchaseDetails(this,'#delIndex#');"></td>


			<td class="multiControl" width="10%"><input type="text"
				name="strReqQty" id="strReqQty#delIndex#" class="txtFldNormal"
				maxlength="9" onkeypress="return validateData(event,7);" onkeyup="changeUnitCmb(this,'#delIndex#');"></td>


			<td class="multiControl" width="14%">
			<div id="itemParaId0#delIndex#"></div>
			</td>

		</tr>
	</table>
	</div>
</logic:equal> <logic:equal value="1" name="requestForRoutinePurchase"
	property="strCostRequired">
	<div id="rowAdded1" style="display: none">
	<table class="TABLEWIDTH" bgcolor='#CC9966' align="center"
		cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="multiControl" width="30%"><input type="hidden"
				name="itemParamValue" id="itemParamValue#delIndex#"> <input
				type="hidden" name="itemCalcValue" id="itemCalcValue#delIndex#">
			<input type="hidden" name="itemUserValue"
				id="itemUserValue#delIndex#">



			<div id="itemParaId1#delIndex#"></div>
			</td>

			<td class="multiControl" width="8%">
			<div id="itemParaId4#delIndex#"></div>
			</td>

			<td class="multiControl" width="10%">
			<div id="itemParaId10#delIndex#"></div>
			</td>

			<td class="multiControl" width="8%"><img
				src='../../hisglobal/images/viewDetails.gif'
				title='To Get Last Purchase Details'
				style='cursor: pointer; cursor: pointer;'
				onClick="getAnnualPurchaseDetails(this,'#delIndex#');"></td>


			<td class="multiControl" width="10%"><input type="text"
				name="strReqQty" id="strReqQty#delIndex#" class="txtFldNormal"
				maxlength="9" onkeypress="return validateData(event,7);" onkeyup="changeUnitCmb(this,'#delIndex#');"></td>


			<td class="multiControl" width="12%">
			<div id="itemParaId0#delIndex#"></div>
			</td>
			<td class="multiControl" width="13%">
			
			<input type="text" name="strCostDivId"  disabled='disabled' id="strCostDivId#delIndex#" class="txtFldNormal" maxlength ="10"   value="0.00" >
			<input type="hidden" name="strCost" value="0.00" id="strCost#delIndex#"></td>
		</tr>
	</table>
	</div>

</logic:equal> <input type="hidden" name="rowIndex1" value="0"> <input
	type="hidden" name="rowLength1" value="0"></form>