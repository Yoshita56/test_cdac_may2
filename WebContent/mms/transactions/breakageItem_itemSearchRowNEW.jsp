<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<form name="multirow">
<logic:equal value="1" name="bkgItemDtlTransBean" property="strCostRequired">

<div id="rowAdded1" style="display:none">
<table class="table" align="center" cellpadding="1px" cellspacing="1px" bgcolor='' style="width:100%;">

<tr>
	
	<td class="" width="35%" >
		<input type="hidden" name="itemParamValue" id="itemParamValue#delIndex#">
		<input type="hidden" name="itemCalcValue" id="itemCalcValue#delIndex#">
		<input type="hidden" name="itemUserValue" id="itemUserValue#delIndex#">
		<div id="itemParaId1#delIndex#" style='font-weight:350 !important ;font-size: 16px !important;text-align:center'>
		</div>
	</td>

	<td class="" width="15%">
		<div id="itemParaId11#delIndex#" style='font-weight:350 !important ;font-size: 16px !important;text-align:center'>
		</div>
	</td>

	<td class=""  width="15%">
		<div id="itemParaId4#delIndex#" style='font-weight:350 !important ;font-size: 16px !important;text-align:center'>
		</div>
	</td>

	<td class=""  width="15%" style='font-weight:350 !important ;font-size: 16px !important;text-align:center'>
		<input type="text" name="strBkgQty" id="strBkgQty#delIndex#" class="form-control" maxlength ="11"  onkeyup="return calculateCostOnChange('#delIndex#');" onkeypress="validateData(event,7); ">
	</td>
	
	<td class="" width="10%" >
		<div id="itemParaId0#delIndex#" style='font-weight:350 !important ;font-size: 16px !important;text-align:center' >
		</div>
	</td>

	<td class="" width="15%">
		<div id='strCostFinalDivId#delIndex#' style="display: none;">0.00</div>
		<input disabled="disabled"  name="strCostFinal" value="0.00" id="strCostFinal#delIndex#" class="form-control" maxlength ="5" onkeypress="return validateData(event,7);">
	</td>

</tr>
</table>
</div>
</logic:equal>


<logic:equal value="0" name="bkgItemDtlTransBean" property="strCostRequired">
<div id="rowAdded1" style="display:none" class="col-md-12">

<table class="table" align="center" cellpadding="1px" cellspacing="1px" bgcolor='#CC9966'>
<tr>
<td class="" width="20%">

<input type="hidden" name="itemParamValue" id="itemParamValue#delIndex#">
<input type="hidden" name="itemCalcValue" id="itemCalcValue#delIndex#">
<input type="hidden" name="itemUserValue" id="itemUserValue#delIndex#">
<div id='strCostFinalDivId#delIndex#' style="display: none">0.00</div>
<input disabled="disabled"  name="strCostFinal" value="0.00" id="strCostFinal#delIndex#" class="form-control" maxlength ="5" onkeypress="return validateData(event,7);">
<div id="itemParaId1#delIndex#">
</div>
</td>

<td class="" width="20%">
<div id="itemParaId11#delIndex#">
</div>
</td>
<td class=""  width="20%">
<div id="itemParaId4#delIndex#">
</div>
</td>


<td class=""  width="20%">
<input type="text" name="strBkgQty" id="strBkgQty#delIndex#" class="form-control" maxlength ="11"   onkeyup="return calculateCostOnChange('#delIndex#');" onkeypress="return validateData(event,7);">

</td>
<td class="" width="20%">
<div id="itemParaId0#delIndex#" >

</div>
</td>

</tr>
</table>
</div>
</logic:equal>
<input type="hidden" name="rowIndex1" value="0"> 
<input type="hidden" name="rowLength1" value="0">


</form>