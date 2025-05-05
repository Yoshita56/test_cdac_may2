<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<form name="multirow">
	<div id="rowAdded1" style="display:none">
	
	<table class="table" align="center" border="0" cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="" width="20%">
				<input type="hidden" name="strItemOtherDtls" id="strItemOtherDtls#delIndex#" value="">
				<div id="itemOtherNameDivId#delIndex#"></div>
			</td>
			<td class="" width="20%">
				<div id="itemOtherBatchNoDivId#delIndex#"></div>
			</td>
			<td class="" width="20%">
				<div id="itemOtherExpiryDateDivId#delIndex#"></div>
			</td>
			<td class="" width="20%">
				<div id="itemOtherQtyDivId#delIndex#"></div>
			</td>
			<td class="" width="5%">
				<button type="button" class="float-right btn btn-outline-info mt-1" title="Delete" onClick="deleteRow('#delIndex#','1','0');" style="padding: .175rem .35rem; line-height: 0.8">
					<i class="fas fa-minus-square"></i>
				</button>
			</td>
		</tr>
	</table>
	
	</div>
	<input type="hidden" name="rowIndex1" value="0"> 
	<input type="hidden" name="rowLength1" value="0">
	
	<div id="rowAdded2" style="display:none">
	
	<table class="table" align="center" border="0" cellpadding="1px" cellspacing="1px">
		<tr>
			<td class="" width="15%">
				<input type="hidden" name="strItemPartDtls" id="strItemPartDtls#delIndex#" value=""><div id="itemOtherTypeDivId#delIndex#"></div>
			</td>
			<td class="" width="15%">
				<div id="itemOtherNameDivId#delIndex#"></div>
			</td>
			<td class="" width="15%">
				<div id="itemOtherBatchNoDivId#delIndex#"></div>
			</td>
			<td class="" width="15%">
				<div id="itemOtherManufacturerDivId#delIndex#"></div>
			</td>
			<td class="" width="15%">
				<div id="itemOtherExpiryDateDivId#delIndex#"></div>
			</td>
			<td class="" width="20%">
				<div id="itemOtherQtyDivId#delIndex#"></div>
			</td>
			<td class="" width="5%">
				<button type="button"
					class="float-right btn btn-outline-info mt-1" title="Delete"
					onClick="deleteRow('#delIndex#','1','0');" style="padding: .175rem .35rem; line-height: 0.8">
					<i class="fas fa-minus-square"></i>
				</button>
			</td>
		</tr>
	</table>
	</div>
	
	<input type="hidden" name="rowIndex2" value="0"> 
	<input type="hidden" name="rowLength2" value="0">
</form>