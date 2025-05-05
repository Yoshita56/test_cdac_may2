<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<%-- <logic:equal value="0" name="DossierItemMasterBean" property="strDoseFrqFlg"> --%>
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
	
	<td class="multiControl" width="8%" style="display:none;">
		<div id="itemParaId22#delIndex#"></div>
		<input type="hidden" id="strIsMisc#delIndex#" style="width:80px;" name="strIsMisc" class="IsMiscItem" />
	</td>
	
	<td class="multiControl" width="8%" style="display:none;">
		<div id="itemParaId23#delIndex#"></div>
		<input type="hidden" id="strIsReturnable#delIndex#" style="width:80px;" name="strIsReturnableArr" class="IsReturnableItem" />
	</td>

	<td class="multiControl" width="8%">
		<div id="itemParaId18#delIndex#"></div>
	</td>
	
	<td class="multiControl" width="8%" style="display:none;">
		<div id="itemParaId24#delIndex#"></div>
		<input type="hidden" id="strIsRC#delIndex#" style="width:80px;" name="strIsRC" class="IsRCItem" />
	</td>
	
	<td class="multiControl" width="8%">
		<div id="itemParaId21#delIndex#"></div>
	</td>
	
	<td class="multiControl"  width="8%" id="isBroughtByPatientRow">
			<select name="isBroughtByPatient" onchange="changeDefRateValueOld(this);">
			<option value="0">No</option>
			<option value="1">Yes</option>
			</select>
	</td>
	
	<!-- <td class="multiControl"  width="8%">
			<input type="hidden" name="strItemCategoryCode" id="itemParaId4#delIndex#" class='txtFldMin'>
			<div id="itemParaId4#delIndex#"></div>
	</td> -->
	<td class="multiControl"  width="8%">
		<div id="itemParaId3#delIndex#"></div>
		<input type="text" id="strDefRateText#delIndex#" style="width:80px;text-align:right;" name="strDefRateText" class='txtFldMin itemParaId0' maxlength="7" onkeyup="updateDivValue(this);calCost(this);" onkeypress="return validateData(event,7);"  tabindex="1" />
	</td>
	<td class="multiControl"  width="8%">
		
		<input type="hidden" name="strReqQty" id="strReqQty#delIndex#" class='txtFldMin'>
		<div id="strQuantity#delIndex#" style="display: none">0</div>
		<div id="strQuantityText#delIndex#" style="display: block">
			<input type="text" name="strQtyText" id="strQtyText#delIndex#" class='txtFldMin'  style="text-align:right;" onkeyup="QtyValidation('#delIndex#');calCost(this);" maxlength="5" onkeypress="return validateData(event,5);"  tabindex="1">
		</div>
	
	</td>
	
	<td class="multiControl"  width="8%">
		
		<input type="hidden" name="strTotalCost" id="strTotalCost#delIndex#" class='txtFldMin'  >
		<div id="strQuantityText#delIndex#" style="display: block">
			<input type="text" style="width:80px;text-align:right;" name="strTotalCostText" id="strTotalCostText#delIndex#" class='txtFldMin'  onkeyup="" maxlength="7" readonly/>
		</div>
	
	</td>
	
	<td class="multiControl" width="8%">
		<textarea rows="2" cols="5" name="strRemarksText" style="width: 91px; height: 17px;"></textarea>
	</td>
	
	<td class="multiControl"  width="4%">
		<div id="strQuantityText#delIndex#" style="display: block">
			<img style="cursor: pointer;height: 20px" id='strDeleteButtonDivId' src="../../hisglobal/images/Minus.png" onclick="deleteRowOld('#delIndex#','1','0',this);" title="Click here to Delete Item">
		</div>
	
	</td>
  </tr>
</table>
</div>

<%-- </logic:equal> --%>

	<input type="hidden" name="rowIndex1" value="0"> 
	<input type="hidden" name="rowLength1" value="0">
	

