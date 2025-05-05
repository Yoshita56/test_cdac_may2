<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<form name="multirow">

<logic:equal value="0"   name="annualPurchaseIndent" property="strCostRequired">   
   <div id="rowAdded1" style="display: none">
	<table class="table" bgcolor='#126ea8'   align="center" cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="" width="45%" style='text-align:left;'>
			
				<input type="hidden"  name="itemParamValue" id="itemParamValue#delIndex#"> 
				<input type="hidden"  name="itemCalcValue"  id="itemCalcValue#delIndex#">
				<input type="hidden"  name="itemUserValue"	id="itemUserValue#delIndex#">
				
				<div id='strCostDivId#delIndex#' style="display: none;">0.00</div>
				
				<input type="hidden" name="strCost" value="0.00" id="strCost#delIndex#">
	
				<div id="itemParaId1#delIndex#"></div>
			
			</td>

			<td class="" width="15%" style='text-align:center;'>
			   <div id="itemParaId4#delIndex#" ></div>
			</td>		


			<td class="" width="15%" style='text-align:center;'>
			    <input type="text"
				name="strReqQty" id="strReqQty#delIndex#" class="" autocomplete='off' 
				maxlength="11" onkeypress="return validateData(event,5);" onkeyup="changeUnitCmb(this,'#delIndex#');" style='text-align:center;'></td>


			<td class="" width="15%" style='text-align:center;'>
			<div id="itemParaId0#delIndex#"></div>
			</td>

		</tr>
	</table>
	</div>
</logic:equal> 

<logic:equal value="1" name="annualPurchaseIndent"   property="strCostRequired">
	<div id="rowAdded1" style="display: none">
	<table class="table"  align="center"  	cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="" width="40%" style='text-align:left;'>
			   <input type="hidden"	name="itemParamValue" id="itemParamValue#delIndex#"> 
			   <input type="hidden" name="itemCalcValue"  id="itemCalcValue#delIndex#">
			   <input type="hidden" name="itemUserValue"  id="itemUserValue#delIndex#">


			<div id="itemParaId1#delIndex#"></div>
			</td>			

			 <td class="" width="15%" style='text-align:center;'>
			<div id="itemParaId4#delIndex#" ></div>
			</td>
			
			 <td class="" width="15%" style='text-align:center;'>
			<div id="itemParaId5#delIndex#"></div>
			</td>


			<td class="" width="15%" style='text-align:center;'>
			    <input type="text" autocomplete='off' 
				name="strReqQty" id="strReqQty#delIndex#" class=""
				maxlength="11" onblur="changeUnitCmb(this,'#delIndex#');" onkeypress="return validateData(event,5);"></td>


			<td class="" width="15%" style='text-align:center;'>
			<div id="itemParaId0#delIndex#" ></div>
			</td>
		</tr>
	</table>
	</div>

</logic:equal> 

<input type="hidden" name="rowIndex1" value="0"> 
<input type="hidden" name="rowLength1" value="0">

</form>