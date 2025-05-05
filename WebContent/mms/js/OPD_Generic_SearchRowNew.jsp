<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<style>
   input[type="number"] {
    -moz-appearance: none;
}
</style>

<form name="multirow">

<div id="rowAdded2" style="display:none">
<table class="TABLEWIDTH" bgcolor='#6097BC'  align="center" cellpadding="1px" cellspacing="1px" id="td#delIndex#"  border="1px">
 <tr>
    <td class="multiControl"  width="15%">
		<input type="hidden" name="itemParamValue" id="itemParamValue#delIndex#">
		<input type="hidden" name="itemCalcValue" id="itemCalcValue#delIndex#">
		<input type="hidden" name="itemUserValue" id="itemUserValue#delIndex#">

		<div id="itemParaId1#delIndex#">
		</div>
	</td>
	

	<td class="multiControl" width="15%">
		<div id="itemParaId11#delIndex#" align='left'></div>
	</td>
	
	<td class="multiControl"  width="15%">
			<div id="itemParaId4#delIndex#"></div>
	</td>
	
	<td class="multiControl"  width="15%">
			<div id="itemParaId5#delIndex#"></div>
	</td>
	
	<td width="15%" class="multiControl">
		<select name="strDose"  class='comboMin'
			id="strDose#delIndex#" onchange="onQuantity('#delIndex#');" >
				<bean:write name="issuePatBean" property="strDosageValues"
						filter="false" />
		</select></td>
		
	<td width="10%" class="multiControl">
		<select name="strFrequency" 
			id="strFrequency#delIndex#"  onchange="onQuantity('#delIndex#');">
				<bean:write name="issuePatBean" property="strFrequencyValues"
						filter="false" />
		</select></td>
	
	<td class="multiControl"  width="9%">
			<input type="text" name="strDays" id="strDays#delIndex#" class='txtFldMin' onkeyup="onQuantity('#delIndex#')" onkeypress="return validateData(event,5);" >
	</td>
	
	<td class="multiControl"  width="15%">
	
		<input type="hidden" name="strReqQty" id="strReqQty#delIndex#" class='txtFldMin'  >
		<div id="strQuantity#delIndex#" >0 No.</div>
		<div id="strQuantityText#delIndex#" style="display: none">
			<input type="text" name="strQtyText" autocomplete='off' id="strQtyText#delIndex#" class='txtFldMin'  onkeyup="putQuantity('#delIndex#');"  onkeypress="return validateData(event,5);" > No.
		</div>
	
	</td>
  </tr>
</table>
</div>

	<input type="hidden" name="rowIndex2" value="0"> 
	<input type="hidden" name="rowLength2" value="0">
</form>