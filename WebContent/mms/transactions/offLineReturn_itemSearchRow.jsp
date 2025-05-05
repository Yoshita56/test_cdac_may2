<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<form name="multirow">
<logic:equal value="0" name="offlineReturnBean" property="strBudgetFlg">
		<div id="rowAdded1" style="display:none">
		<table class="TABLEWIDTH" align="center" bgcolor='#CC9966' cellpadding="1px" cellspacing="1px"  id="td#delIndex#">
		<tr>
		<td class="multiPOControl" width="22.90%" style="text-align:left;">
			<input type="hidden" name="itemParamValue" id="itemParamValue#delIndex#">
			<input type="hidden" name="itemCalcValue" id="itemCalcValue#delIndex#">
			<input type="hidden" name="itemUserValue" id="itemUserValue#delIndex#">
			<div id="itemParaId1#delIndex#"></div>
		</td>
		
		<td class="multiPOControl" width="18.66%">
			<div id="itemParaId11#delIndex#"></div>
		</td>
		
		<td class="multiPOControl"  width="10%">
		    <div id="itemParaId4#delIndex#"></div>			
		</td>
		
		
		<td class="multiPOControl"  width="11%">
		     <div id="itemParaId19#delIndex#"></div>
			
		</td>
		
		
		<td class="multiPOControl"  width="10%">
		     <input type="text" name="strReqQty" id="strReqQty#delIndex#" class="txtFldNormal" maxlength ="7"  onkeyup="return reqQtyValidation('#delIndex#','strReqQty');" onkeypress="return validateData(event,7);">
			
		</td>
		
		<td class="multiPOControl" width="15%">
				<input type="text" name="strReturnQty" id="strReturnQty#delIndex#" class="txtFldNormal" maxlength ="7"  onkeyup="return returnQtyValidation('#delIndex#');" onkeypress="return validateData(event,7);">
		</td>
		</tr>
		</table>
		</div>

</logic:equal>


<logic:equal value="1" name="offlineReturnBean" property="strBudgetFlg">
  		<div id="rowAdded1" style="display:none">
		<table class="TABLEWIDTH" align="center" bgcolor='#CC9966' cellpadding="1px" cellspacing="1px" id="td#delIndex#">
		<tr>
		<td class="multiPOControl" width="23.25%" style="text-align:left;">
			<input type="hidden" name="itemParamValue" id="itemParamValue#delIndex#">
			<input type="hidden" name="itemCalcValue" id="itemCalcValue#delIndex#">
			<input type="hidden" name="itemUserValue" id="itemUserValue#delIndex#">
			<div id="itemParaId1#delIndex#"></div>
		</td>
		
		<td class="multiPOControl" width="10%">
			<div id="itemParaId11#delIndex#"></div>
		</td>
		
		<td class="multiPOControl"  width="9%">
		      <div id="itemParaId4#delIndex#"></div>
			
		</td>
		
		
		<td class="multiPOControl"  width="6%">
		     <div id="itemParaId19#delIndex#"></div>
			
		</td>
		
		
		<td class="multiPOControl"  width="12%">
		     <input type="text" name="strReqQty" value="0" id="strReqQty#delIndex#" class="txtFldMin" maxlength ="7"  onkeyup="return reqQtyValidation('#delIndex#','strReqQty');" onkeypress="return validateData(event,7);">
			
		</td>
		
		<td class="multiPOControl" width="11%">
				<input type="text" name="strReturnQty"  value="0" id="strReturnQty#delIndex#" class="txtFldMin" maxlength ="7"  onblur="return returnQtyValidation('#delIndex#');" onkeypress="return validateData(event,7);">
		</td>
		
		<td class="multiPOControl"  width="8%" >
			<input type="text" name="strCost"   id="strCost#delIndex#" class="txtFldNormal" maxlength ="10"  value="0.00"  disabled="disabled">
		</td>
		
		</tr>
		</table>
		</div>

</logic:equal>

<input type="hidden" name="rowIndex1" value="0"> 
<input type="hidden" name="rowLength1" value="0">


</form>