<form name="multirow">

<div id="rowAdded1" style="display:none">
<table class="TABLEWIDTH" bgcolor='#CC9966' align="center" cellpadding="1px" cellspacing="1px" >
<tr>
<td class="multiPOControl" width="45%" style="text-align:left;">
<input type="hidden" name="itemParamValue" id="itemParamValue#delIndex#">
<input type="hidden" name="itemCalcValue" id="itemCalcValue#delIndex#">
<input type="hidden" name="itemUserValue" id="itemUserValue#delIndex#">


<div id="itemParaId1#delIndex#">
</div>
</td>
<td class="multiPOControl" width="15%">

<div id="itemParaId3#delIndex#">
</div>
<td class="multiPOControl"  width="15%">
<input type="text" class="txtFldMin" name="strTransferQty" id="strTransferQty#delIndex#"  maxlength="7" onkeyup="return calCostBaseOnUnit('#delIndex#');" onkeypress="return validateData(event,5);" style="width:100px">
</td>
<td class="multiPOControl"  width="15%">
 <input type="text" class="txtFldMax" name="strTransferCostDivId" disabled id="strTransferCostDivId#delIndex#" value="0.00" >
 <input type="hidden" name="strTransferCost" id="strTransferCost#delIndex#" value="0.00" >
</td>

</tr>
</table>
</div>
<input type="hidden" name="rowIndex1" value="0"> 
<input type="hidden" name="rowLength1" value="0">


</form>