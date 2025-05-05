<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<form name="multirow">
<logic:equal value="1" name="DossierDeskBean" property="strDoseFrqFlg">
<div id="rowAdded1" style="display:none">
<table class="TABLEWIDTH" bgcolor='#6097BC'  align="center" cellpadding="1px" cellspacing="1px" id="td#delIndex#">
 <tr>
    <td class="multiControl"  width="15%">
		<input type="hidden" name="itemParamValue" id="itemParamValue#delIndex#">
		<input type="hidden" name="itemCalcValue" id="itemCalcValue#delIndex#">
		<input type="hidden" name="itemUserValue" id="itemUserValue#delIndex#">

		<div id="itemParaId1#delIndex#">
		</div>
	</td>
	

	<td class="multiControl" width="15%">
		<div id="itemParaId11#delIndex#"></div>
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
				<bean:write name="DossierDeskBean" property="strDosageValues"
						filter="false" />
		</select></td>
		
	<td width="10%" class="multiControl">
		<select name="strFrequency" 
			id="strFrequency#delIndex#"  onchange="onQuantity('#delIndex#');">
				<bean:write name="DossierDeskBean" property="strFrequencyValues"
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


<logic:equal value="0" name="DossierDeskBean" property="strDoseFrqFlg">
<div id="rowAdded1" style="display:none">
<table class="TABLEWIDTH" bgcolor='#6097BC'  align="center" cellpadding="1px" cellspacing="1px"  id="td#delIndex#">
 <tr>
    <td class="multiControl"  width="23%" align='left'>
		<input type="hidden" name="itemParamValue" id="itemParamValue#delIndex#">
		<input type="hidden" name="itemCalcValue" id="itemCalcValue#delIndex#">
		<input type="hidden" name="itemUserValue" id="itemUserValue#delIndex#">

		<div id="itemParaId1#delIndex#">
		</div>
	</td>
	<td class="multiControl"  width="16%" style="">
			<div id="itemParaId66#delIndex#"></div>
	</td>

	<td class="multiControl" width="5%">
		<div id="itemParaId65#delIndex#"></div>
	</td>
	
	<td class="multiControl"  width="3%">
	
	 <select name="isBroughtByPatient" style="display: none;">
			<option value="0">No</option>
			<option value="1">Yes</option>
			
			</select>
			
			<div id="itemParaId11#delIndex#"></div>
	</td>
	
	
	
	<td class="multiControl"  width="8%">
			<div id="itemParaId4#delIndex#"></div>
	</td>
	
	<td class="multiControl" width="8%">
		<div id="itemParaId5#delIndex#"></div>
	</td>
			
			
	<td class="multiControl"  width="8%">
		
		<input type="hidden" name="strReqQty" id="strReqQty#delIndex#" class='txtFldMin'  >
		<div id="strQuantity#delIndex#" style="display: none">0 No.</div>
		<div id="strQuantityText#delIndex#" style="display: block">
			<input type="text" name="strQtyText1" id="strQtyText1#delIndex#" class='txtFldMin'  onblur="QtyValidation1('#delIndex#');" maxlength="5" onkeypress="return validateData(event,5);"  tabindex="1"> No.
		</div>
	
	</td>
	<td class="multiControl"  width="8%" style="">
		
		<input type="hidden" name="strTotalCost1" id="strTotalCost1#delIndex#" class='txtFldMin'  >
		<div id="strQuantityText#delIndex#" style="display: block">
			<input type="text" name="strTotalCostText1" id="strTotalCostText1#delIndex#" class='txtFldMin'  onkeyup="" maxlength="5"    readonly/>
		</div>
	
	</td>
	
	<td class="multiControl"  width="4%">
		<div id="strQuantityText#delIndex#" style="">
			<img style="cursor: pointer;height: 20px" id='strDeleteButtonDivId' tabindex='2' src="../../hisglobal/images/Minus.png" onclick="deleteRow('#delIndex#','1','0');" title="Click here to Delete Item">
		</div>
	
	</td>
  </tr>
</table>
</div>
</logic:equal>




	<input type="hidden" name="rowIndex1" value="0"> 
	<input type="hidden" name="rowLength1" value="0">


</form>