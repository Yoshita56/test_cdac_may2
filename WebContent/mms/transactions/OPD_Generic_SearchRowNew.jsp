<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<form name="multirow">
<div id="rowAdded1" style="display:none">
<table class="table" border="1px">
 <tr>
    <td   width="35%" >
		 <input type="hidden" name="itemParamValue" id="itemParamValue#delIndex#">
		 <div align="left" id="strBrandName#delIndex#" style='font-size: 0.8rem; color: #495057;text-align:left;'></div>
	</td>
	
	<td   style='width:15%;'>
		<div align="center" id="strBrandBatch#delIndex#" ></div>
	</td>
	
	<td   style='width:10%; text-align:center;'>
	    <div align="center" id="strAvlQty#delIndex#"></div>	
	</td>
	<td   style='width:15%; '>
			 <div align="center" id="strBrandRate#delIndex#"></div>		
	</td>
	<td   width="10%">
		
		<div align="center">
			<input type="number" name="strQtyText" id="strQtyText#delIndex#" style='display:inline!important;' class='form-control'  onblur="QtyValidation('#delIndex#');" min='1' maxlength="15" onkeypress="return validateData(event,5);"  tabindex="2"> 
		</div>
	</td>
	<td   width="10%">
		
			<input type="text" name="strTotalCostText" id="strTotalCostText#delIndex#" style='display:inline!important' class='form-control'  onkeyup="" maxlength="5"    readonly/>
		
	</td>
	
	<td   width="5%">		
			<img style="cursor: pointer;height: 20px" id='strDeleteButtonDivId' tabindex='2' src="../../hisglobal/images/Minus.png" onclick="QtyValidationBeforeDelete('#delIndex#');deleteRow('#delIndex#',1,0);" title="Click here to Delete Item">
	</td>
  </tr>
</table>
</div>
<input type="hidden" name="rowIndex1" value="0"> 
<input type="hidden" name="rowLength1" value="0">


</form>
