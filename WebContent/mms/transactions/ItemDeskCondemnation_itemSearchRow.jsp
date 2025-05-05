<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<form name="multirow">
<logic:equal value="0" name="indentCondemnationTransADDBean" property="strCostRequired">
<div id="rowAdded1" style="display:none">
<table class="TABLEWIDTH" align="center" bgcolor="#CC9966"  cellpadding="1px" cellspacing="1px" >
<tr>
<td class="multiControl" width="22%">

<input type="hidden" name="itemParamValue" id="itemParamValue#delIndex#">
<input type="hidden" name="itemCalcValue" id="itemCalcValue#delIndex#">
<input type="hidden" name="itemUserValue" id="itemUserValue#delIndex#">
<div id='strCostDivId#delIndex#'  style="display:none;">0.00</div>
<input type="hidden"  name="strCost" value="0.00" id="strCost#delIndex#">

<div id="itemParaId1#delIndex#">
</div>
</td>

<td class="multiControl" width="19%">
<div id="itemParaId4#delIndex#">
</div>
</td>

<td class="multiControl" width="19%">
<div id="itemParaId18#delIndex#">
</div>
</td>

<td class="multiControl"  width="20%">
<input type="text" name="strCondemnationQty" id="strCondemnationQty#delIndex#" class="txtFldMin" maxlength ="5"  onkeyup="return checkQty('#delIndex#','strCondemnationQty','strUnitName');" onkeypress="return validateData(event,7);">
</td>

<td class="multiControl"  width="20%">
<div id="itemParaId0#delIndex#" >
</div>
</td>



</tr>
</table>
</div>
</logic:equal>
<logic:equal value="1" name="indentCondemnationTransADDBean" property="strCostRequired">
<div id="rowAdded1" style="display:none">
<table class="TABLEWIDTH" align="center"  bgcolor="#CC9966"  cellpadding="1px" cellspacing="1px" >
<tr>
<td class="multiControl" width="22%">

<input type="hidden" name="itemParamValue" id="itemParamValue#delIndex#">
<input type="hidden" name="itemCalcValue" id="itemCalcValue#delIndex#">
<input type="hidden" name="itemUserValue" id="itemUserValue#delIndex#">

<div id="itemParaId1#delIndex#">
</div>
</td>

<td class="multiControl" width="14%">
<div id="itemParaId4#delIndex#">
</div>
</td>

<td class="multiControl" width="14%">
<div id="itemParaId18#delIndex#">
</div>
</td>

<td class="multiControl"  width="20%">
<input type="text" name="strCondemnationQty" id="strCondemnationQty#delIndex#" class="txtFldMin" maxlength ="5"  onkeyup="return checkQty('#delIndex#','strCondemnationQty','strUnitName');" onkeypress="return validateData(event,7);">
</td>

<td class="multiControl"  width="20%">
<div id="itemParaId0#delIndex#" >
</div>
</td>
<td class="multiControl"  width="10%">
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