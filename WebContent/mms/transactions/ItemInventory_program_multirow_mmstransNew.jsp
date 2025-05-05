<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<form name="multirow">
<div id="rowAdded1" style="display: none">
<logic:equal  value="14" name="itemInventoryProgramTransBean" property="strStoreTypeFlag">
<table width='150%' align="center" cellpadding="1px" cellspacing="0px" id="td#delIndex#">
  <tr>  
						<input type="hidden" name="strRowIndex" id="strRowIndex#delIndex#"  value=#delIndex# />
						<input type="hidden" name="strAvlBatchFlg" id="strAvlBatchFlg#delIndex#"> 
						<input type="hidden" name="strMultiRowCurrenDate" id="strMultiRowCurrenDate#delIndex#"  value="" />
						
						
						
					<td id="slNo#delIndex#"  >
	
				<input type="text" size="1"  name="strSNo" value=""  readonly="readonly" style="border: 0px; LINE-HEIGHT: 16px; text-align: center; FONT-FAMILY: Geneva, Verdana, 'sans-serif'; HEIGHT: 20px;width:20px;"  >
		
		        </td>
						<TD id='td1#delIndex#'>						
						 <div id="ExistingBatchId"><select name="strMultiRowExistingBatchId"  id="strMultiRowExistingBatchId#delIndex#" class="form-control form-control-sm " onchange=""><option value="0">Select Value</option></select></div>
						</TD>
						<TD id='td2#delIndex#'><input type="text" maxlength="25" class="form-control form-control-sm " name="strMultiRowFinalBatchNo" id="strMultiRowFinalBatchNo#delIndex#"    value =""  onkeypress="return validateData(event,17);" onBlur="checkBatchExistence(this,'#delIndex#');" /></TD>
						
						<TD id='td3#delIndex#'><input type="text" maxlength="8"  class="form-control form-control-sm "    name="strMultiRowActiveQty"    id="strMultiRowActiveQty#delIndex#"       value =""  onkeypress="return validateData(event,5);"  onBlur="checkQtyValidaion(1,this,'#delIndex#');"></TD>
						<TD id='td4#delIndex#'><input type="text" maxlength="8"  class="form-control form-control-sm " 	 name="strMultiRowQuarnQty"     id="strMultiRowQuarnQty#delIndex#"        value =""  onkeypress="return validateData(event,5);"  onBlur="checkQtyValidaion(2,this,'#delIndex#');"></TD>
						<!-- <TD  id='td5#delIndex#'> -->
						<input type="text" maxlength="8"  class="form-control form-control-sm " 	 name="strMultiRowInActiveQty" style="display: none;"  id="strMultiRowInActiveQty#delIndex#"     value =""  onkeypress="return validateData(event,5);"  onBlur="checkQtyValidaion(3,this,'#delIndex#');">
						<!-- </TD> -->
						<TD  id='td16#delIndex#'><input type="text" maxlength="10"  class="form-control form-control-sm " 	 name="strMultiRowPurRate"         id="strMultiRowPurRate#delIndex#"    onchange="calSalePriceNew(this,'#delIndex#');"        value =""  onkeypress="return validateData(event,7);"  ></TD>
						<TD  id='td19#delIndex#'><input type="text" maxlength="10"  class="form-control form-control-sm " 	 name="strMultiRowTax"         id="strMultiRowTax#delIndex#" onchange="calSalePrice(this,'#delIndex#');"            value =""  onkeypress="return validateData(event,7);" ></TD>
						<TD  id='td6#delIndex#'><input type="text" maxlength="10"  class="form-control form-control-sm " 	 name="strMultiRowRate"         id="strMultiRowRate#delIndex#"            value =""  onkeypress="return validateData(event,7);" disabled='disabled' ></TD>
						<TD  id='td17#delIndex#'><input type="text" maxlength="10"  class="form-control form-control-sm " 	 name="strMultiRowHandlingCharges"   onchange="calCost(this,'#delIndex#');"     id="strMultiRowHandlingCharges#delIndex#"            value =""  onkeypress="return validateData(event,7);"  ></TD>
						<TD  id='td18#delIndex#'><input type="text" maxlength="10"  class="form-control form-control-sm " 	 name="strMultiRowCosttoPat"         id="strMultiRowCosttoPat#delIndex#"            value =""  onkeypress="return validateData(event,7);"   disabled='disabled'></TD>
						<TD  id='td7#delIndex#'>						
						<div id="RateUnitId"><select name="strMultiRowRateUnitId" id="strMultiRowRateUnitId#delIndex#" class="comboMax" onchange=""><option value="0">Select Value</option></select></div>
						</TD>
						
						<!-- <TD   id='td9#delIndex#'><input    type="text" maxlength="10"  class="form-control form-control-sm " 	 name="strMultiRowMfgDate"            id="strMultiRowMfgDate#delIndex#"               value =""   onBlur="checkDateFormat(1,this,'#delIndex#');"></TD>
						<TD WIDTH="8%"  id='td8#delIndex#'><input    type="text" maxlength="10"  class="form-control form-control-sm " 	 name="strMultiRowExpiryDate"         id="strMultiRowExpiryDate#delIndex#"            value =""   onBlur="checkDateFormat(2,this,'#delIndex#');"></TD>
						 -->
						<TD   id='td9#delIndex#'><dateTag:date name="strMultiRowMfgDate"     id="strMultiRowMfgDate#delIndex#"  value=""></dateTag:date></TD>
					    <TD   id='td8#delIndex#'><dateTag:date name="strMultiRowExpiryDate" id="strMultiRowExpiryDate#delIndex#"  value=""></dateTag:date></TD>
						
						
						
						<TD   id='td11#delIndex#'><select  name="strMultiRowMfgId"     id="strMultiRowMfgId#delIndex#"         class="form-control form-control-sm "  onchange="checkMfgName(this,'#delIndex#');"><bean:write name="itemInventoryProgramTransBean" property="strManufactureCombo" filter="false" /></TD>
						<TD   id='td10#delIndex#'><input type="text" maxlength="90"  class="form-control form-control-sm "     name="strMultiRowMfgName"     id="strMultiRowMfgName#delIndex#"   onBlur="checkDuplicateMfgName(this,'#delIndex#');" disabled='disabled'  value =""  onkeypress="return validateData(event,18);"></TD>
						
						<TD   id='td12#delIndex#'><input type="text" maxlength="50"  class="form-control form-control-sm "  name="strMultiRowPONo"        id="strMultiRowPONo#delIndex#"      value =""  onkeypress="return validateData(event,17);"></TD>
						<TD   id='td13#delIndex#'><input type="text" maxlength="40"  class="form-control form-control-sm "  name="strMultiRowTenderNo"    id="strMultiRowTenderNo#delIndex#"  value =""  onkeypress="return validateData(event,17);"></TD>
						<TD   id='td14#delIndex#'><input type="text" maxlength="25"  class="form-control form-control-sm "  name="strMultiRowInvoiceNo"        id="strMultiRowInvoiceNo#delIndex#"      value =""  onkeypress="return validateData(event,17);"></TD>
						 <TD   id='td15#delIndex#'><dateTag:date name="strMultiRowInvoiceDate" id="strMultiRowInvoiceDate#delIndex#"  value=""></dateTag:date></TD>
						<td WIDTH="2%"  colspan='1' id='td14#delIndex#'><img name="" onkeypress="onPressingEnter(this,event)" src="../../hisglobal/images/minus.gif" style="cursor: pointer;" title="Delete Row" onclick="deleteRow('#delIndex#',1,0);">
			
			
	</tr>
</table>
</logic:equal>
<logic:notEqual value="14" name="itemInventoryProgramTransBean" property="strStoreTypeFlag">
<table width='100%'  align="center" class='table' cellpadding="1px" cellspacing="0px" id="td#delIndex#">

<thead >
<th width='4%'><div id="SerailNo">Sr No</div></th>
<th width='13%'><div id="mandBatchId">Batch Id</div></th>
<th width='9%'>Batch No</th>
<th width='5%'>Qty</th>
<th width='8%'>Pur Rate</th>
<th width='5%'>Tax</th>
<th width='14%'>Pur Rate with Tax</th>
<th width='14%'>Administ.Charges(%)</th>
<th width='14%'>Administ.Charges</th>
<th width='15%'>Cost.to.Patient</th>
</thead>
<tbody>
						<input type="hidden" name="strRowIndex" id="strRowIndex#delIndex#"  value=#delIndex# />
						<input type="hidden" name="strAvlBatchFlg" id="strAvlBatchFlg#delIndex#"> 
						<input type="hidden" name="strMultiRowCurrenDate" id="strMultiRowCurrenDate#delIndex#"  value="" />
						<td  width='4%' id="slNo#delIndex#" >
						
		          	   <input type="text" size="1"  name="strSNo" value=""  readonly="readonly"  style="border: 0px; LINE-HEIGHT: 16px; text-align: center; FONT-FAMILY: Geneva, Verdana, 'sans-serif'; HEIGHT: 20px;width:20px;"  >
		
		                    
		                    </td>
						
						<TD  width='13%' id='td1#delIndex#'>						
						 <div id="ExistingBatchId"><select name="strMultiRowExistingBatchId"  id="strMultiRowExistingBatchId#delIndex#" class="form-control form-control-sm " onchange=""><option value="0">Select Value</option></select></div>
						</TD>
						<TD  width='9%' id='td2#delIndex#'><input type="text" maxlength="25" class="form-control form-control-sm " name="strMultiRowFinalBatchNo" id="strMultiRowFinalBatchNo#delIndex#"    value =""  onkeypress="return validateData(event,17);" onBlur="checkBatchExistence(this,'#delIndex#');" /></TD>
						<TD  width='5%' id='td3#delIndex#'><input type="text" maxlength="8"  class="form-control form-control-sm "    name="strMultiRowActiveQty"    id="strMultiRowActiveQty#delIndex#"       value =""  onkeypress="return validateData(event,5);"  onBlur="checkQtyValidaion(1,this,'#delIndex#');">
						<input style="display:none;" type="text" maxlength="8"  class="form-control form-control-sm " 	 name="strMultiRowQuarnQty"     id="strMultiRowQuarnQty#delIndex#"        value =""  onkeypress="return validateData(event,5);"  onBlur="checkQtyValidaion(2,this,'#delIndex#');"></TD>
						<!-- <TD id='td5#delIndex#'> -->
						<input type="text" maxlength="8"  class="form-control form-control-sm " 	 name="strMultiRowInActiveQty"  id="strMultiRowInActiveQty#delIndex#" style="display: none;"     value =""  onkeypress="return validateData(event,5);"  onBlur="checkQtyValidaion(3,this,'#delIndex#');">
						<!--  </TD>-->
						<TD  width='8%' id='td16#delIndex#'><input type="text" maxlength="10"  class="form-control form-control-sm " 	 name="strMultiRowPurRate"         id="strMultiRowPurRate#delIndex#"  onchange="calSalePriceNew(this,'#delIndex#');"           value =""  onkeypress="return validateData(event,7);"  onBlur=""></TD>
						<TD  width='5%' id='td19#delIndex#'><input type="text" maxlength="10"  class="form-control form-control-sm " 	 name="strMultiRowTax"         id="strMultiRowTax#delIndex#" onchange="calSalePrice(this,'#delIndex#');"            value ="0"  onkeypress="return validateData(event,7);"  onBlur=""></TD>
						<TD  width='14%' id='td6#delIndex#'><input type="text" maxlength="10"  class="form-control form-control-sm " 	 name="strMultiRowRate"         id="strMultiRowRate#delIndex#"            value =""  onkeypress="return validateData(event,7);" disabled='disabled' onBlur=""></TD>
						<TD  width='14%' id='td17#delIndex#'><input type="text" maxlength="10"  class="form-control form-control-sm " 	 name="strMultiRowHandlingCharges"  onchange="calCost(this,'#delIndex#');"      id="strMultiRowHandlingCharges#delIndex#"            value =""  onkeypress="return validateData(event,7);"  onBlur=""></TD>
						<TD  width='14%' id='td27#delIndex#'><input type="text" maxlength="10"  class="form-control form-control-sm " 	 name="strMultiRowHandlingChargesFinal"  onchange="calCost(this,'#delIndex#');"      id="strMultiRowHandlingChargesFinal#delIndex#"            value =""  onkeypress="return validateData(event,7);"  onBlur=""></TD>
						<TD  width='15%' id='td18#delIndex#'><input type="text" maxlength="10"  class="form-control form-control-sm " 	 name="strMultiRowCosttoPat"         id="strMultiRowCosttoPat#delIndex#"            value =""  onkeypress="return validateData(event,7);"  onBlur="" disabled='disabled'></TD>
						</tbody>
				<thead>

					<th width='8%'>Unit</th>
					<th width='8%'><div id="mandMfgId">Mfg Date</th>


					<th width='8%'><div id="mandExpId">Exp Date</th>

					<th width='16%'>Supp ID</th>
					<th width='16%'>Supp Name</th>
					<th width='5%'>PO No</th>
					<th width='5%'>DC No</th>
					<th width='6%'>Invoice.No</th>
					<th width='6%'>Invoice.Date</th>
					<th width='20%'>Stock.Util.Gen</th>
					<th width='2%'>#</th>
				</thead>

				<tbody>		
						<TD  id='td7#delIndex#'>						
						<div id="RateUnitId"><select name="strMultiRowRateUnitId" id="strMultiRowRateUnitId#delIndex#" class="comboMax" onchange=""><option value="0">Select Value</option></select></div>
						</TD>
						
						<!-- <TD   id='td9#delIndex#'><input    type="text" maxlength="10"  class="form-control form-control-sm " 	 name="strMultiRowMfgDate"            id="strMultiRowMfgDate#delIndex#"               value =""   onBlur="checkDateFormat(1,this,'#delIndex#');"></TD>
						<TD WIDTH="8%"  id='td8#delIndex#'><input    type="text" maxlength="10"  class="form-control form-control-sm " 	 name="strMultiRowExpiryDate"         id="strMultiRowExpiryDate#delIndex#"            value =""   onBlur="checkDateFormat(2,this,'#delIndex#');"></TD>
						 -->
						<TD id='td9#delIndex#'>
						<input name="strMultiRowMfgDate"   class='form-control form-control-sm datepicker'  id="strMultiRowMfgDate#delIndex#"  value=""></TD>
					    <TD id='td8#delIndex#'>
					    <input name="strMultiRowExpiryDate" class='form-control form-control-sm datepicker' id="strMultiRowExpiryDate#delIndex#"  value=""></TD>
						
						
						
						<TD id='td11#delIndex#'><select  name="strMultiRowMfgId"     id="strMultiRowMfgId#delIndex#"         class="form-control form-control-sm "  onchange="checkMfgName(this,'#delIndex#');"><bean:write name="itemInventoryProgramTransBean" property="strManufactureCombo" filter="false" /></TD>
						<TD id='td10#delIndex#'><input type="text"   class="form-control form-control-sm "     name="strMultiRowMfgName"     id="strMultiRowMfgName#delIndex#"   onBlur="checkDuplicateMfgName(this,'#delIndex#');" disabled='disabled'  value =""  onkeypress="return validateData(event,18);"></TD>
						<TD   id='td12#delIndex#'><input type="text"   class="form-control form-control-sm "  name="strMultiRowPONo"        id="strMultiRowPONo#delIndex#"      value =""  onkeypress="return validateData(event,7);"></TD>
						<TD   id='td13#delIndex#'><input type="text"  class="form-control form-control-sm "  name="strMultiRowTenderNo"    id="strMultiRowTenderNo#delIndex#"  value ="0"  onkeypress="return validateData(event,17);"></TD>
						<TD   id='td14#delIndex#'><input type="text"   class="form-control form-control-sm "  name="strMultiRowInvoiceNo"        id="strMultiRowInvoiceNo#delIndex#"      value =""  onkeypress="return validateData(event,17);"></TD>
						 <TD   id='td15#delIndex#'>
						 <input name="strMultiRowInvoiceDate" class='form-control form-control-sm datepicker' id="strMultiRowInvoiceDate#delIndex#"  value=""></TD>
						<TD   id='td23#delIndex#'><select name="strMultiRowFlag" id="strMultiRowFlag#delIndex#" class="form-control form-control-sm " onchange=""><option value="1">No</option><option value="2">Yes</option></select></TD>
						<td   id='td14#delIndex#'><img name=""
			onkeypress="onPressingEnter(this,event)"
			src="../../hisglobal/images/minus.gif" style="cursor: pointer;"
			title="Delete Row" onclick="deleteRow('#delIndex#',1,0);generateSlNo();"></td>
			
	</tbody>
</table>
</logic:notEqual>

</div>
<input type="hidden" name="rowIndex1" value="0"> <input
	type="hidden" name="rowLength1" value="0"></form>