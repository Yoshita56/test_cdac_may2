<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<form name="multirow">

		<div id="rowAdded1" style="display:none">
		<table class="TABLEWIDTH" align="center" bgcolor='#CC9966' cellpadding="1px" cellspacing="1px" id="td#delIndex#" >
		<tr>
		<td class="multiPOControl" width="25.66%"  style="text-align:left;">
			<input type="hidden" name="itemParamValue" id="itemParamValue#delIndex#">
			<input type="hidden" name="itemCalcValue" id="itemCalcValue#delIndex#">
			<input type="hidden" name="itemUserValue" id="itemUserValue#delIndex#">
			<div id="itemParaId1#delIndex#"></div>
		</td>
		
		<td class="multiPOControl" width="18.66%" >
			<div id="itemParaId11#delIndex#"></div>
		</td>
		
		<td class="multiPOControl"  width="10%"  >
			<div id="itemParaId4#delIndex#"></div>
		</td>
		
			
		<td class="multiPOControl"  width="12%" >
			<input type="text" name="strIssueQty" id="strIssueQty#delIndex#"  class="txtFldNormal" maxlength ="8"  onkeyup="return issueQtyValidation('#delIndex#');" onkeypress="return validateData(event,7);" onblur="setDefaultValue(this);" >
		</td>
		
		<td class="multiPOControl" width="15%"  >
				<div id="itemParaId0#delIndex#" ></div>
		</td>
		</tr>
		</table>
		</div>




<input type="hidden" name="rowIndex1" value="0"> 
<input type="hidden" name="rowLength1" value="0">


</form>
