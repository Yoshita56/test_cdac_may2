<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<form name="multirow">
<div id="rowAdded1" style="display:none">
<table class="table"  align="center" cellpadding="1px" cellspacing="1px"  id="td#delIndex#">
 <tr>
    <td   width="35%" style='text-align:left'><b>
		
		<input type="hidden" name="itemParamValue" id="itemParamValue#delIndex#">
		<input type="hidden" name="itemCalcValue"  id="itemCalcValue#delIndex#">
		<input type="hidden" name="itemUserValue"  id="itemUserValue#delIndex#">		
		 <div align="left"   id="strBrandName#delIndex#" style='font-size: 0.8rem; color: black;text-align:left;'></div> <!--  Name -->
		</div>
		</b>
	</td>	
			
	
	<td  class="" width="15%" align="">
			
			 <div align="center"   id="strBatch#delIndex#" style='font-size: 0.8rem; color: black;text-align:center;'></div>  <!--  Batch -->
	</td>	
	<td  class="" width="10%" align="">
			
			 <div align="center"   id="strAvlQty#delIndex#" style='font-size: 0.8rem; color: black;text-align:center;'></div>   <!--  Avl Qty -->
	</td>
	
	<td  class="" width="15%" align="">
			
			 <div align="center"   id="strRate#delIndex#" style='font-size: 0.8rem; color: black;text-align:center;'></div>   <!--  Rate/Unit -->
	</td>
			
	<td  class="" width="10%" align="center">
			<input type="number" name="strQtyText"  id="strQtyText#delIndex#"  style='display:inline!important;' class='form-control'  onblur="QtyValidation_OffLine('#delIndex#');"   min='1' maxlength="3" onkeypress="return validateData(event,5);"  tabindex="2"> 
	</td>
	
	<td  class="" width="10%" align="">
			<input type="text" name="strTotalCostText" id="strTotalCostText#delIndex#" style='display:inline!important' class='form-control'  onkeyup="" maxlength="5"    readonly/>
	</td>	
		
	<td  align="" width="5%">
		<div class="col-sm-2  py-2" id="strQuantityText#delIndex#" style="text-align:center;">
			<img style="cursor: pointer;height: 20px" id='strDeleteButtonDivId' tabindex='2' src="../../hisglobal/images/Minus.png" onclick="QtyValidationBeforeDelete_offline('#delIndex#');deleteRow('#delIndex#',1,0);"  title="Click here to Delete Item">
		</div>
	
	</td>
  </tr>
</table>
</div>

	<input type="hidden" name="rowIndex1" value="0"> 
	<input type="hidden" name="rowLength1" value="0">


</form>