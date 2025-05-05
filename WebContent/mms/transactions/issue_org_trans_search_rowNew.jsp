<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<style>
   input[type="number"] {
    -moz-appearance: none;
}
</style>

<form name="multirow">
<logic:equal value="1" name="issueOrgBean" property="strDoseFrqFlg">
<div id="rowAdded1" style="display:none">
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
				<bean:write name="issueOrgBean" property="strDosageValues"
						filter="false" />
		</select></td>
		
	<td width="10%" class="multiControl">
		<select name="strFrequency" 
			id="strFrequency#delIndex#"  onchange="onQuantity('#delIndex#');">
				<bean:write name="issueOrgBean" property="strFrequencyValues"
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
</logic:equal> 


<logic:equal value="0" name="issueOrgBean" property="strDoseFrqFlg">
<div id="rowAdded1" style="display:none">
<table class="table" border="1px">
 <tr>
    <td   width="32%" >
		<input type="hidden" name="itemParamValue" id="itemParamValue#delIndex#">
		<input type="hidden" name="itemCalcValue" id="itemCalcValue#delIndex#">
		<input type="hidden" name="itemUserValue" id="itemUserValue#delIndex#">
		<div align="left" id="itemParaId1#delIndex#">
		</div>
	</td>
	
	<td   style='width:15%;'>
		<div align="left" id="itemParaId11#delIndex#"></div>
	</td>
	
	<td   style='width:10%; text-align:center;'>
			<div align="center" id="itemParaId4#delIndex#"></div>
	</td>
	<td   style='width:15%; '>
			<div align="center" id="itemParaId5#delIndex#"></div>
	</td>
	<td   width="10%">
		<input type="hidden" name="strReqQty" id="strReqQty#delIndex#" class=''  >
		<div id="strQuantity#delIndex#" style="display: none; ">0 No.</div>
		<div id="strQuantityText#delIndex#" style="display: block">
			<input type="number" name="strQtyText" id="strQtyText#delIndex#" style='display:inline!important;' class='form-control'  onblur="QtyValidation('#delIndex#');" min='1' maxlength="15" onkeypress="return validateData(event,5);"  tabindex="2"> 
		</div>
	</td>
	<td   width="8%">
		<input type="hidden" name="strTotalCost" id="strTotalCost#delIndex#" class='txtFldMin'  >
		<div id="strQuantityText#delIndex#" style="display: block">
			<input type="text" name="strTotalCostText" id="strTotalCostText#delIndex#" style='display:inline!important' class='form-control'  onkeyup="" maxlength="5"    readonly/>
		</div>
	
	</td>
	
	<td   width="10%">
		<div id="strQuantityText#delIndex#" style="display: block">
			<img style="cursor: pointer;height: 20px" id='strDeleteButtonDivId' tabindex='2' src="../../hisglobal/images/Minus.png" onclick="QtyValidationBeforeDelete('#delIndex#')" title="Click here to Delete Item">
		</div>
	</td>
  </tr>
</table>
</div>
</logic:equal>

	<input type="hidden" name="rowIndex1" value="0"> 
	<input type="hidden" name="rowLength1" value="0">


</form>