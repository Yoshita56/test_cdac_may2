<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<script language="JavaScript" src="../../masterutil/js/master.js"></script>

<form name="multirow">
	
	<div id="rowAdded1" style="display: none">
		
		<logic:equal value="14" name="drugInventoryProgramTransBean" property="strStoreTypeFlag">
			<table id="td#delIndex#" width='180%' class='table' align="center" cellpadding="1px" cellspacing="0px">
				<thead> 
					<th><div id="SerailNo">Sr.No</div></th>
					<th><div id="mandBatchId">Batch</div></th>
					<th>Stock Qty</th>
					<th>Pack Size</th>
					<th>Pur.Rate/Pack Size</th>
					<th>Pur.Rate/Unit</th>
					<th>No of Packs</th>
					<th>Qty</th>
					<th>Unit</th>
					<th>GST(%)</th>
					<th>Pur Rate/Unit(Incl Tax)</th>
					<th>Administrative Charges(%)</th>
					<th>Administrative Charges</th>
					<th>Cost to Patient</th>
					<th><div id="mandMfgId">Mfg. Date</div></th>
					<th><div id="mandExpId">Exp Date</div></th>
					<th>Supp. Name</th>
					<th>PO-No</th>
					<th>DC-No</th>
					<th>Invoice No</th>
					<th>Invoice Date</th>
					<th>Stock Util-Gen</th>
					<th>#</th>
				</thead>

				<tbody>
					<input type="hidden" name="strRowIndex" 		  id="strRowIndex#delIndex#" value=#delIndex# />
					<input type="hidden" name="strAvlBatchFlg"        id="strAvlBatchFlg#delIndex#">
					<input type="hidden" name="strMultiRowCurrenDate" id="strMultiRowCurrenDate#delIndex#" value="" />

					<td id="slNo#delIndex#">
						<input type="text" size="1" name="strSNo" value="" readonly="readonly"
							style="border: 0px; LINE-HEIGHT: 16px; text-align: center; FONT-FAMILY: Geneva, Verdana, 'sans-serif'; HEIGHT: 20px; width: 20px;">   
					</td>

					<td id='td1#delIndex#'>
						<div id="ExistingBatchId">
							<select name="strMultiRowExistingBatchId"
								id="strMultiRowExistingBatchId#delIndex#"
								class="form-control form-control-sm1" onchange="">
								<option value="0">Select Value</option>
							</select>
						</div>
					</td>

					<td id='td2#delIndex#'>
						<input type="text" maxlength="25"
							class="form-control form-control-sm"
							name="strMultiRowFinalBatchNo"
							id="strMultiRowFinalBatchNo#delIndex#" value=""
							onkeypress="return validateData(event,17);"
							onBlur="checkBatchExistence(this,'#delIndex#');"/>
					</td>

					<td id='td3#delIndex#'>
						<input type="text" maxlength="8"
							class="form-control form-control-sm" name="strMultiRowActiveQty"
							id="strMultiRowActiveQty#delIndex#" value=""
							onkeypress="return validateData(event,5);"
							onBlur="checkQtyValidaion(1,this,'#delIndex#');">
					</td>

					<td id='td4#delIndex#'>
						<input type="text" maxlength="8"
							class="form-control form-control-sm" name="strMultiRowQuarnQty"
							id="strMultiRowQuarnQty#delIndex#" value=""
							onkeypress="return validateData(event,5);"
							onBlur="checkQtyValidaion(2,this,'#delIndex#');"></td>
				
					<!--  <td   id='td5#delIndex#'>
						<input type="text" maxlength="8"
							class="form-control form-control-sm" style="display: none;"
							name="strMultiRowInActiveQty"
							id="strMultiRowInActiveQty#delIndex#" value=""
							onkeypress="return validateData(event,5);"
							onBlur="checkQtyValidaion(3,this,'#delIndex#');">
					 </td> -->
				
					<td id='td16#delIndex#'>
						<input type="text" maxlength="10"
							class="form-control form-control-sm " name="strMultiRowPurRate"
							id="strMultiPurRowRate#delIndex#" value=""
							onkeypress="return validateData(event,7);"
							onBlur="checkDecimalValue(this);">
					</td>
					
					<td id='td19#delIndex#'>
						<input type="text" maxlength="10"
							class="form-control form-control-sm" name="strMultiRowTax"
							id="strMultiRowTax#delIndex#"
							onchange="calSalePrice(this,'#delIndex#');" value=""
							onkeypress="return validateData(event,7);"
							onBlur="checkDecimalValue(this);">
					</td>
					
					<td id='td6#delIndex#'>
						<input type="text" maxlength="10"
							class="form-control form-control-sm " name="strMultiRowRate"
							id="strMultiRowRate#delIndex#" disabled='disabled' value=""
							onkeypress="return validateData(event,7);"
							onBlur="checkDecimalValue(this);">
					</td>
					
					<td id='td17#delIndex#'>
						<input type="text" maxlength="10"
							class="form-control form-control-sm "
							name="strMultiRowHandlingCharges"
							id="strMultiRowHandlingCharges#delIndex#" value=""
							onkeypress="return validateData(event,7);"
							onchange="calCost(this,'#delIndex#');" />
					</td>
					
					<td id='td18#delIndex#'>
						<input type="text" maxlength="10"
							class="form-control form-control-sm " name="strMultiRowCosttoPat"
							id="strMultiRowCosttoPat#delIndex#" value=""
							onkeypress="return validateData(event,7);"
							onBlur="checkDecimalValue(this);" disabled='disabled'>
					</td>
					
					<td id='td7#delIndex#'>
						<div id="RateUnitId">
							<select name="strMultiRowRateUnitId"
								id="strMultiRowRateUnitId#delIndex#"
								class="form-control form-control-sm" onchange="">
								<option value="0">Select Value</option>
							</select>
						</div>
					</td>

					<!-- <td WIDTH="9%"   id='td9#delIndex#'><input    type="text" maxlength="10"  class="form-control form-control-sm " 	 name="strMultiRowMfgDate"            id="strMultiRowMfgDate#delIndex#"               value =""   onBlur="checkDateFormat(1,this,'#delIndex#');"></td>
							<td WIDTH="8%"   id='td8#delIndex#'><input    type="text" maxlength="10"  class="form-control form-control-sm " 	 name="strMultiRowExpiryDate"         id="strMultiRowExpiryDate#delIndex#"            value =""   onBlur="checkDateFormat(2,this,'#delIndex#');"></td>
					-->
					<td id='td9#delIndex#'>
						<input name="strMultiRowMfgDate"
							class='form-control form-control-sm datepicker'
							id="strMultiRowMfgDate#delIndex#" value="">
					</td>
					
					<td id='td8#delIndex#'>
						<dateTag:date name="strMultiRowExpiryDate" id="strMultiRowExpiryDate#delIndex#" value=""> </dateTag:date>
					</td>

					<td id='td11#delIndex#'>
						<select name="strMultiRowMfgId"
							id="strMultiRowMfgId#delIndex#"
							class="form-control form-control-sm"
							onchange="checkMfgName(this,'#delIndex#');">
							<bean:write name="drugInventoryProgramTransBean" property="strManufactureCombo" filter="false" />
					</td>

					<td id='td10#delIndex#'>
						<input type="text" maxlength="90"
							class="form-control form-control-sm" name="strMultiRowMfgName"
							id="strMultiRowMfgName#delIndex#"
							onBlur="checkDuplicateMfgName(this,'#delIndex#');"
							disabled='disabled' value=""
							onkeypress="return validateData(event,18);">
					</td>

					<td id='td12#delIndex#'>
						<input type="text" maxlength="25"
							class="form-control form-control-sm " name="strMultiRowPONo"
							id="strMultiRowPONo#delIndex#" value=""
							onkeypress="return validateData(event,17);">
					</td>

					<td id='td13#delIndex#'>
						<input type="text" maxlength="40"
							class="form-control form-control-sm " name="strMultiRowTenderNo"
							id="strMultiRowTenderNo#delIndex#" value="0"
							onkeypress="return validateData(event,17);">
					</td>

					<td id='td14#delIndex#'>
						<input type="text" maxlength="25"
							class="form-control form-control-sm " name="strMultiRowInvoiceNo"
							id="strMultiRowInvoiceNo#delIndex#" value=""
							onkeypress="return validateData(event,17);">
					</td>

					<td id='td15#delIndex#'>
						<dateTag:date name="strMultiRowInvoiceDate" id="strMultiRowInvoiceDate#delIndex#" value=""></dateTag:date>
					</td>
					
					<td colspan='1' id='td14#delIndex#'>
						<img name="" onkeypress="onPressingEnter(this,event)"
						src="../../hisglobal/images/minus.gif" style="cursor: pointer;"
						title="Delete Row" onclick="deleteRow('#delIndex#',1,0);">
				</tbody>
			</table>
		</logic:equal>

		<logic:notEqual value="14" name="drugInventoryProgramTransBean" property="strStoreTypeFlag">
			<table width='auto' class='table' align="center" cellpadding="1px" cellspacing="0px" id="td#delIndex#">
				<thead align="left">
					<th width='2%'><div id="SerailNo">Sr.No</div></th>
					<th width='20%'><div id="mandBatchId">Batch Id</div></th>
					<th width='20%'>Batch No</th>
					<th width='3%'>Pack Size</th>
					<th width='5%'>Pur.Rate/Pack Size</th>
					<th width='5%'>Pur.Rate/Unit</th>
					<th width='3%'>No of Packs</th>
					<th width='5%'>Qty</th>
					<th width='8%'>Unit</th>
					<th width='5%'>GST(%)</th>
					<th width='7%'>Pur.Rate/Unit(Tax)</th>
					<th width='5%'>Administ.Char(%)</th>
				</thead>
				<tbody>
				
				<input type="hidden" name="strRowIndex"    id="strRowIndex#delIndex#" value=#delIndex# />
				<input type="hidden" name="strAvlBatchFlg" id="strAvlBatchFlg#delIndex#">
				<input type="hidden" name="strMultiRowCurrenDate" id="strMultiRowCurrenDate#delIndex#" value="" />

					<td width='2%' id="slNo#delIndex#">
						<input type="text" size="1"
							name="strSNo" value="" readonly="readonly"
							style="border: 0px; LINE-HEIGHT: 16px; text-align: center; FONT-FAMILY: Geneva, Verdana, 'sans-serif'; HEIGHT: 20px; width: 20px;">
					</td>

					<td width='20%' id='td1#delIndex#'>
						<div id="ExistingBatchId">
							<select name="strMultiRowExistingBatchId"
								id="strMultiRowExistingBatchId#delIndex#"
								class="form-control form-control-sm" onchange="">
								<option value="0">Select Value</option></select>
						</div>
					</td>

					<td width='20%' id='td2#delIndex#'>
						<input type="text"
							maxlength="25" class="form-control form-control-sm "
							name="strMultiRowFinalBatchNo"
							id="strMultiRowFinalBatchNo#delIndex#" value=""
							onkeypress="return validateData(event,17);"
							onBlur="checkBatchExistence(this,'#delIndex#');" />
					</td>

					<td width='3%' id='td20#delIndex#'>
						<input type='text'
							name="strMultiRowPackSizeId" id="strMultiRowPackSizeId#delIndex#"
							maxlength='3' onChange="calPurRate1(this,'#delIndex#')"
							class="form-control form-control-sm " value=""
							onkeypress="return validateData(event,5);">
					</td>

					<td width='5%' id='td16#delIndex#'>
						<input type="text"
							maxlength="10" class="form-control form-control-sm "
							name="strMultiRowPurRatePerPack"
							id="strMultiPurRowRatePerPack#delIndex#"
							onChange="calPurRate(this,'#delIndex#')" value=""
							onkeypress="return validateData(event,7);"
							onBlur="checkDecimalValue(this);">
					</td>

					<td width='5%' id='td23#delIndex#'>
						<input type="text"
							maxlength="10" class="form-control form-control-sm "
							name="strMultiRowPurRate" id="strMultiPurRowRate#delIndex#"
							onkeypress="return validateData(event,7);" disabled>
					</td>

					<td width='3%' id='td21#delIndex#'>
						<input type="text"
							maxlength="7" class="form-control form-control-sm"
							name="strMultiRowPackets" id="strMultiRowPackets#delIndex#"
							value="" onkeypress="return validateData(event,5);"
							onchange="calQty(this,'#delIndex#');"
							onBlur="checkQtyValidaion(1,this,'#delIndex#');calQty(this,'#delIndex#');">
							
					<td width='5%' id='td3#delIndex#'>
						<input type="text"
							maxlength="10" class="form-control form-control-sm"
							name="strMultiRowActiveQty" id="strMultiRowActiveQty#delIndex#"
							value="" onkeypress="return validateData(event,5);"
							onBlur="checkQtyValidaion(1,this,'#delIndex#');">
					</td>
					
					<td width='8%' id='td7#delIndex#'>
						<div id="RateUnitId">
							<select name="strMultiRowRateUnitId"
								id="strMultiRowRateUnitId#delIndex#"
								class="form-control form-control-sm" onchange="">
								<option value="0">Select Value</option></select>
						</div>
					</td>
					
					<td width='5%' id='td19#delIndex#'>
						<input type="text"
							maxlength="10" class="form-control form-control-sm"
							name="strMultiRowTax" id="strMultiRowTax#delIndex#"
							onchange="calSalePrice(this,'#delIndex#');" value=""
							onkeypress="return validateData(event,7);"
							onBlur="checkDecimalValue(this);">
					</td>
					
					<td width='7%' id='td6#delIndex#'>
						<input type="text"
							maxlength="10" class="form-control form-control-sm "
							name="strMultiRowRate" id="strMultiRowRate#delIndex#"
							disabled='disabled' value=""
							onkeypress="return validateData(event,7);"
							onBlur="checkDecimalValue(this);">
					</td>
					
					<td width='5%' id='td17#delIndex#'>
						<input type="text"
							maxlength="10" class="form-control form-control-sm "
							name="strMultiRowHandlingCharges"
							onchange="calCost(this,'#delIndex#');"
							id="strMultiRowHandlingCharges#delIndex#" value=""
							onkeypress="return validateData(event,7);">
					</td>
				</tbody>
				
				<thead align="left">
					<th width='4%'>Admini-Char</th>
					<th width='5%'>Cost to Pat</th>
					<th width='12%'><div id="mandMfgId">Mfg. Date</div></th>
					<th width='12%'><div id="mandExpId">Exp Date</div></th>
					<th width='20%'>Supplier.ID</th>
					<th width='20%'>Supplier.Name</th>
					<th width='20%'>PO-No</th>

					<th width='10%'>DC-No</th>
					<th width='12%'>Invoice No</th>
					<th width='10%'>Invoice Date</th>
					<th width='5%'>Stock-Util-Gen</th>
					<th width='2%'>#</th>
				</thead>

				<tbody>
					<td width='4%' id='td22#delIndex#'>
						<input type="text"
							maxlength="10" class="form-control form-control-sm "
							name="strMultiRowHandlingChargesFinal"
							id="strMultiRowHandlingChargesFinal#delIndex#"
							onkeypress="return validateData(event,7);" disabled='disabled'>
					</td>
					<td width='5%' id='td18#delIndex#'>
						<input type="text"
							maxlength="10" class="form-control form-control-sm "
							name="strMultiRowCosttoPat" id="strMultiRowCosttoPat#delIndex#"
							value="" onkeypress="return validateData(event,7);"
							disabled='disabled'>
					</td>
					
					<td width='12%' id='td9#delIndex#'>
						<input name="strMultiRowMfgDate"
						class='form-control form-control-sm datepicker'
						id="strMultiRowMfgDate#delIndex#" value="">
					</td>
					
					<td width='12%' id='td8#delIndex#'>
						<input name="strMultiRowExpiryDate"
						class='form-control form-control-sm datepicker'
						id="strMultiRowExpiryDate#delIndex#" value="">
					</td>

					<td width='20%' id='td11#delIndex#'>
					<select
						name="strMultiRowMfgId" id="strMultiRowMfgId#delIndex#"
						class="form-control form-control-sm"
						onchange="checkMfgName(this,'#delIndex#');"><bean:write
								name="drugInventoryProgramTransBean"
								property="strManufactureCombo" filter="false" /></td>

					<td width='20%' id='td10#delIndex#'><input type="text"
						maxlength="90" class="form-control form-control-sm"
						name="strMultiRowMfgName" id="strMultiRowMfgName#delIndex#"
						onBlur="checkDuplicateMfgName(this,'#delIndex#');"
						disabled='disabled' value=""
						onkeypress="return validateData(event,18);"></td>

					<td width='20%' id='td12#delIndex#'><input type="text"
						maxlength="25" class="form-control form-control-sm "
						name="strMultiRowPONo" id="strMultiRowPONo#delIndex#" value=""
						onkeypress="return validateData(event,7);"></td>

					<td width='10%' id='td13#delIndex#'><input type="text"
						maxlength="40" class="form-control form-control-sm "
						name="strMultiRowTenderNo" id="strMultiRowTenderNo#delIndex#"
						value="0" onkeypress="return validateData(event,17);"></td>

					<td width='12%' id='td14#delIndex#'><input type="text"
						maxlength="25" class="form-control form-control-sm "
						name="strMultiRowInvoiceNo" id="strMultiRowInvoiceNo#delIndex#"
						value="" onkeypress="return validateData(event,17);"></td>
					<td width='10%' id='td15#delIndex#'><input
						name="strMultiRowInvoiceDate"
						class='form-control form-control-sm datepicker'
						id="strMultiRowInvoiceDate#delIndex#" value=""></td>
					<td width='5%' id='td23#delIndex#'><select
						name="strMultiRowFlag" id="strMultiRowFlag#delIndex#"
						class="form-control form-control-sm" onchange=""><option
								value="1">No</option>
							<option value="2">Yes</option></select></td>
					<td width='2%' id='td14#delIndex#'><img name=""
						onkeypress="onPressingEnter(this,event)"
						src="../../hisglobal/images/minus.gif" style="cursor: pointer;"
						title="Delete Row"
						onclick="deleteRow('#delIndex#',1,0);generateSlNo();"></td>

				</tbody>
			</table>
		</logic:notEqual>

	</div>
	<input type="hidden" name="rowIndex1" value="0"> 
	<input type="hidden" name="rowLength1" value="0">
</form>