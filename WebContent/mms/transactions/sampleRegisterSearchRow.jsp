<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<form name="multirow">
<div id="rowAdded1" style="display:none">
<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" >
<tr>
<td class="multiControl" width="15%">
<input type="hidden" name="itemParamValue" id="itemParamValue#delIndex#">
<input type="hidden" name="itemCalcValue" id="itemCalcValue#delIndex#">
<input type="hidden" name="itemUserValue" id="itemUserValue#delIndex#">

<div id="itemParaId1#delIndex#">
</div>
</td>
<td class="multiControl"  width="20%">
<date:date name="strExpDate" id="strExpDate#delIndex#" ></date:date>
</td>

<td class="multiControl"  width="30%">
<input type="text" name="strBatchSlNo" id="strBatchSlNo#delIndex#" class='txtFldMax' onkeypress="return validateData(event,9);"  maxlength="20" value="0">
</td>
<td class="multiControl"  width="15%">
<input type="text" name="strQty" id="strQty#delIndex#" class='txtFldMin' onkeyup="" onkeypress="return validateData(event,7);"  maxlength="8">
</td>
<td class="multiControl"  width="20%">
<div id="itemParaId0#delIndex#">
</div>
</td>

</tr>
</table>
</div>
<input type="hidden" name="rowIndex1" value="0"> 
<input type="hidden" name="rowLength1" value="0">
</form>