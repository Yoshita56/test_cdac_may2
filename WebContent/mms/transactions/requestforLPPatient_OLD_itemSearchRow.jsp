<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<form name="multirow">
<logic:equal value="0" name="requestForLpPatient" property="strCostRequired">
	<div id="rowAdded1" style="display:none">
		<table class="TABLEWIDTH" width="100%" align="center" cellpadding="1px" cellspacing="1px" >
				<tr>
				<td class="multiControl" width="45%">
				
				<input type="hidden" name="itemParamValue" id="itemParamValue#delIndex#">
				<input type="hidden" name="itemCalcValue" id="itemCalcValue#delIndex#">
				<input type="hidden" name="itemUserValue" id="itemUserValue#delIndex#">
				<div id='strCostDivId#delIndex#' style="display:none;">0.00</div>
				<input type="hidden"  name="strCost" value="0.00" id="strCost#delIndex#">
				
				<div id="itemParaId1#delIndex#" style="font-weight:350 !important ;font-size: 16px !important;text-align:left">
				</div>
				</td>
				
								
				<td class="multiControl"  width="18%" style="font-weight:350 !important ;font-size: 16px !important;text-align:center">
				   <input type="text" name="strReqQty" id="strReqQty#delIndex#" autocomplete='off' class="form-control" maxlength ="5" onkeyup="return checkQty('#delIndex#','strReqQty','strUnitName');" onkeypress="return validateData(event,7);">
				   
				</td>
				
				
				<td class="multiControl" width="17%" >
				<div id="itemParaId0#delIndex#" style="font-weight:350 !important ;font-size: 16px !important;text-align:center">
				</div>
				</td>
				
				</tr>
		</table>
	</div>
</logic:equal>
<logic:equal value="1" name="requestForLpPatient" property="strCostRequired">
	<div id="rowAdded1" style="display:none">
	
		<table class="TABLEWIDTH" width="100%" align="center" cellpadding="1px" cellspacing="1px" >
			<tr>
			<td class="" width="23%">
			
			<input type="hidden" name="itemParamValue" id="itemParamValue#delIndex#">
			<input type="hidden" name="itemCalcValue" id="itemCalcValue#delIndex#">
			<input type="hidden" name="itemUserValue" id="itemUserValue#delIndex#">
			
			
			<div id="itemParaId1#delIndex#">
			</div>
			</td>
			
			<td class="multiControl" width="20%">
			<div id="itemParaId5#delIndex#">
			</div>
			</td>
			
			<td class="multiControl"  width="20%">
			   <input type="text" name="strReqQty" id="strReqQty#delIndex#" class="form-control" maxlength ="5" onkeyup="return checkQty('#delIndex#','strReqQty','strUnitName');" onkeypress="return validateData(event,7);">
			   
			</td>
			
			
			<td class="multiControl" width="20%">
			<div id="itemParaId0#delIndex#">
			</div>
			</td>
			
			<td class="multiControl" width="15%">
			<div id='strCostDivId#delIndex#'>0.00</div>
			<input type="hidden"  name="strCost" value="0.00" id="strCost#delIndex#">
			</td>
			</tr>
		</table>
	</div>
</logic:equal>
<input type="hidden" name="rowIndex1" value="0"> 
<input type="hidden" name="rowLength1" value="0">


</form> 