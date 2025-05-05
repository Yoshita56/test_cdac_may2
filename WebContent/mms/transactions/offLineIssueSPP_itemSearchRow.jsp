<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<!-- <style type="text/css">
.table .thead-dark {
			  	color: #000 !important;
			  	border: none !important;
			  	background:linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;
			}
			.thead-dark th{
				background:none !important;
				border: none !important;	
			}
</style> -->


<form name="multirow">
       <div id="rowAdded1" style="display:none">
			<table class="table table-striped" id="td#delIndex#">
				<tr>
					<td scope='col' style='font-weight:350 !important ;font-size: 16px !important; width:18%;'>
						<input type="hidden" name="itemParamValue" id="itemParamValue#delIndex#">
						<input type="hidden" name="itemCalcValue" id="itemCalcValue#delIndex#">
						<input type="hidden" name="itemUserValue" id="itemUserValue#delIndex#">
						<div id="itemParaId1#delIndex#"></div>
					</td>
					
					<td scope='col' align="center" style='font-weight:350 !important ;font-size: 16px !important;width:12%;' >
						<div id="itemParaId11#delIndex#"></div>
					</td>
					
					<td scope='col' align="center" style='font-weight:350 !important ;font-size: 16px !important; width:5%;'  >
						<div id="itemParaId4#delIndex#"></div>
					</td>
					
					<td scope='col' align="center" style='font-weight:350 !important ;font-size: 16px !important;width:10%;' >
						<input type="text" name="strReqStoreAvlQty" id="strReqStoreAvlQty#delIndex#" class="txtFldMin" maxlength ="8"   onkeypress="return validateData(event,7);" onblur="setDefaultValue(this);">
					</td>
					
					<td scope='col' align="center" style='font-weight:350 !important ;font-size: 16px !important; width:10%;' >
						<input type="text" name="strReqQty" id="strReqQty#delIndex#" class="txtFldMin" maxlength ="8"  onkeyup="return reqQtyValidation('#delIndex#');" onkeypress="return validateData(event,5);" onblur="setDefaultValue(this);">
					</td>
					
					
					<td scope='col' align="center" style='font-weight:350 !important ;font-size: 16px !important; width:10%;' >
						<input type="text" name="strIssueQty" id="strIssueQty#delIndex#"  class="txtFldMin" maxlength ="8"  onblur="return issueQtyValidation('#delIndex#');" onkeypress="return validateData(event,5);" onblur="setDefaultValue(this);" >
					</td>
					
					<td scope='col' align="center" style='font-weight:350 !important ;font-size: 16px !important; width:10%;'  >
							<div id="itemParaId0#delIndex#" ></div>
					</td>
					
					<td scope='col' align="center" style='font-weight:350 !important ;font-size: 16px !important; width:10%;'>
						<input type="text" name="strCost"  disabled='disabled' id="strCost#delIndex#" class="txtFldNormal" maxlength ="10"  onkeypress="return validateData(event,7);" value="0.00" onblur="setDefaultValue(this);" >
					</td>
				</tr>
			</table>
		</div>


<input type="hidden" name="rowIndex1" value="0"> 
<input type="hidden" name="rowLength1" value="0">


</form>
