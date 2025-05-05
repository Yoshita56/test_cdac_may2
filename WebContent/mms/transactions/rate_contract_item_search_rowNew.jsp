<form name="multirow">

<div id="rowAdded1" style="display:none">
<table class="table"   id="td#delIndex#">
<tr>
<td style='width: 20%; align:left'>
<input type="hidden" name="itemParamValue" id="itemParamValue#delIndex#">
<input type="hidden" name="itemCalcValue" id="itemCalcValue#delIndex#">
<input type="hidden" name="itemUserValue" id="itemUserValue#delIndex#">


<div id="itemParaId1#delIndex#">
</div>
</td>
<td style="width: 8%;">

<input type="text" class="form-control" autocomplete='off' name="strTenderItemNo" value='0' id="strTenderItemNo#delIndex#"  maxlength="100" onkeypress="return validateData(event,9);" onkeyup='CalculateSecurityAmt("#delIndex#");'>
</td>

<td style="width: 8%">
<input type="text" class="form-control" autocomplete='off' name="strRate" id="strRate#delIndex#"  maxlength="12" onkeypress="return validateData(event,7);" onkeyup='CalculateSecurityAmt("#delIndex#");'>
</td>

<td style="width: 8%">
<div id="itemParaId0#delIndex#">
</div>
</td>

<td style="width: 8%">
<input type="text" class="form-control" autocomplete='off' name="strRateContQty" id="strRateContQty#delIndex#" onkeyup='CalculateSecurityAmt("#delIndex#");'  maxlength="12" onkeypress="return validateData(event,5);" >
</td>

<td style="width: 8%">
<input type="text" class="form-control"  autocomplete='off' placeholder="(%)" name="strItemTax" id="strItemTax#delIndex#"  maxlength="2" onkeypress='return validateData(event,7);' onkeyup=''>
</td>

<td style="width: 8%">
<input type="text" class="form-control"  autocomplete='off' placeholder="(%)" name="strSecurityAmtPercent" id="strSecurityAmtPercent#delIndex#"  maxlength="5" onkeypress='return validateData(event,7);' onkeyup='notGreaterThanCent(this);CalculateSecurityAmt("#delIndex#");'>
</td>


<td style="width: 5%;display:none;" >
<input type="text" class="form-control" autocomplete='off' name="strSecurityAmt" id="strSecurityAmt#delIndex#" readonly maxlength="12" onkeypress="return validateData(event,5);" >
</td>



<td style="width: 3%;text-align: center;padding-top: 12px;" >
<input type="checkBox" name="strImportedType" value='0' id="strImportedType#delIndex#" onClick='ImportedTypeChk(this,"#delIndex#");'>
</td>

<td style="width: 10%">
<input type="text" class="form-control" autocomplete='off' placeholder="(In Days)" name="strShelfLife" id="strShelfLife#delIndex#"  maxlength="4" onkeypress="return validateData(event,5);" >
</td>

<td style="width: 10%">
  <select name='strLevel' id="strLevel#delIndex#" class='browser-default custom-select'>
         <option value='L1'>L1</option>
         <option value='L2'>L2</option>
         <option value='L3'>L3</option>
         <option value='L4'>L4</option>
         <option value='L5'>L5</option>
         <option value='L6'>L6</option>
         <option value='L7'>L7</option>
         <option value='L8'>L8</option>
         <option value='L9'>L9</option>
         
  </select>
</td>
<td  style="width: 10%">
<input type="text" class="form-control" autocomplete='off' name="strPackSize" id="strPackSize#delIndex#"  maxlength="10" onkeypress="return validateData(event,9);" >
</td>




</tr>
</table>
</div>
<input type="hidden" name="rowIndex1" value="0"> 
<input type="hidden" name="rowLength1" value="0">


</form>