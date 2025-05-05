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
						
						
						
					<td WIDTH="1%" id="slNo#delIndex#"  CLASS="multiRPTControl" >
	
				<input type="text" size="1"  name="strSNo" value=""  readonly="readonly" style="border: 0px; LINE-HEIGHT: 16px; text-align: center; FONT-FAMILY: Geneva, Verdana, 'sans-serif'; HEIGHT: 20px;width:20px;"  >
		
		        </td>
						<TD WIDTH="7%" CLASS="multiRPTControl" id='td1#delIndex#'>						
						 <div id="ExistingBatchId"><select name="strMultiRowExistingBatchId"  id="strMultiRowExistingBatchId#delIndex#" class="comboNormal" onchange=""><option value="0">Select Value</option></select></div>
						</TD>
						<TD WIDTH="7%" CLASS="multiRPTControl" id='td2#delIndex#'><input type="text" maxlength="25" class="txtFldMax" name="strMultiRowFinalBatchNo" id="strMultiRowFinalBatchNo#delIndex#"    value =""  onkeypress="return validateData(event,17);" onBlur="checkBatchExistence(this,'#delIndex#');" /></TD>
						
						<TD WIDTH="7%" CLASS="multiRPTControl" id='td3#delIndex#'><input type="text" maxlength="8"  class="txtFldMin"    name="strMultiRowActiveQty"    id="strMultiRowActiveQty#delIndex#"       value =""  onkeypress="return validateData(event,5);"  onBlur="checkQtyValidaion(1,this,'#delIndex#');"></TD>
						<TD WIDTH="7%" CLASS="multiRPTControl" id='td4#delIndex#'><input type="text" maxlength="8"  class="txtFldMin" 	 name="strMultiRowQuarnQty"     id="strMultiRowQuarnQty#delIndex#"        value =""  onkeypress="return validateData(event,5);"  onBlur="checkQtyValidaion(2,this,'#delIndex#');"></TD>
						<!-- <TD WIDTH="5%" CLASS="multiRPTControl" id='td5#delIndex#'> -->
						<input type="text" maxlength="8"  class="txtFldMin" 	 name="strMultiRowInActiveQty" style="display: none;"  id="strMultiRowInActiveQty#delIndex#"     value =""  onkeypress="return validateData(event,5);"  onBlur="checkQtyValidaion(3,this,'#delIndex#');">
						<!-- </TD> -->
						<TD WIDTH="5%" CLASS="multiRPTControl" id='td16#delIndex#'><input type="text" maxlength="10"  class="txtFldMin" 	 name="strMultiRowPurRate"         id="strMultiRowPurRate#delIndex#"    onchange="calSalePriceNew(this,'#delIndex#');"        value =""  onkeypress="return validateData(event,7);"  ></TD>
						<TD WIDTH="5%" CLASS="multiRPTControl" id='td19#delIndex#'><input type="text" maxlength="10"  class="txtFldMin" 	 name="strMultiRowTax"         id="strMultiRowTax#delIndex#" onchange="calSalePrice(this,'#delIndex#');"            value =""  onkeypress="return validateData(event,7);" ></TD>
						<TD WIDTH="5%" CLASS="multiRPTControl" id='td6#delIndex#'><input type="text" maxlength="10"  class="txtFldMin" 	 name="strMultiRowRate"         id="strMultiRowRate#delIndex#"            value =""  onkeypress="return validateData(event,7);" disabled='disabled' ></TD>
						<TD WIDTH="5%" CLASS="multiRPTControl" id='td17#delIndex#'><input type="text" maxlength="10"  class="txtFldNormal" 	 name="strMultiRowHandlingCharges"   onchange="calCost(this,'#delIndex#');"     id="strMultiRowHandlingCharges#delIndex#"            value =""  onkeypress="return validateData(event,7);"  ></TD>
						<TD WIDTH="5%" CLASS="multiRPTControl" id='td18#delIndex#'><input type="text" maxlength="10"  class="txtFldNormal" 	 name="strMultiRowCosttoPat"         id="strMultiRowCosttoPat#delIndex#"            value =""  onkeypress="return validateData(event,7);"   disabled='disabled'></TD>
						<TD WIDTH="5%" CLASS="multiRPTControl" id='td7#delIndex#'>						
						<div id="RateUnitId"><select name="strMultiRowRateUnitId" id="strMultiRowRateUnitId#delIndex#" class="comboMax" onchange=""><option value="0">Select Value</option></select></div>
						</TD>
						
						<!-- <TD WIDTH="9%" CLASS="multiRPTControl"  id='td9#delIndex#'><input    type="text" maxlength="10"  class="txtFldNormal" 	 name="strMultiRowMfgDate"            id="strMultiRowMfgDate#delIndex#"               value =""   onBlur="checkDateFormat(1,this,'#delIndex#');"></TD>
						<TD WIDTH="8%" CLASS="multiRPTControl"  id='td8#delIndex#'><input    type="text" maxlength="10"  class="txtFldNormal" 	 name="strMultiRowExpiryDate"         id="strMultiRowExpiryDate#delIndex#"            value =""   onBlur="checkDateFormat(2,this,'#delIndex#');"></TD>
						 -->
						<TD WIDTH="10%"  CLASS="multiRPTControl" id='td9#delIndex#'><dateTag:date name="strMultiRowMfgDate"     id="strMultiRowMfgDate#delIndex#"  value=""></dateTag:date></TD>
					    <TD WIDTH="10%"  CLASS="multiRPTControl" id='td8#delIndex#'><dateTag:date name="strMultiRowExpiryDate" id="strMultiRowExpiryDate#delIndex#"  value=""></dateTag:date></TD>
						
						
						
						<TD WIDTH="9%" CLASS="multiRPTControl"  id='td11#delIndex#'><select  name="strMultiRowMfgId"     id="strMultiRowMfgId#delIndex#"         class="comboNormal"  onchange="checkMfgName(this,'#delIndex#');"><bean:write name="itemInventoryProgramTransBean" property="strManufactureCombo" filter="false" /></TD>
						<TD WIDTH="9%" CLASS="multiRPTControl"  id='td10#delIndex#'><input type="text" maxlength="90"  class="txtFldMax"     name="strMultiRowMfgName"     id="strMultiRowMfgName#delIndex#"   onBlur="checkDuplicateMfgName(this,'#delIndex#');" disabled='disabled'  value =""  onkeypress="return validateData(event,18);"></TD>
						
						<TD WIDTH="5%" CLASS="multiRPTControl"  id='td12#delIndex#'><input type="text" maxlength="50"  class="txtFldNormal"  name="strMultiRowPONo"        id="strMultiRowPONo#delIndex#"      value =""  onkeypress="return validateData(event,17);"></TD>
						<TD WIDTH="6%" CLASS="multiRPTControl"  id='td13#delIndex#'><input type="text" maxlength="40"  class="txtFldNormal"  name="strMultiRowTenderNo"    id="strMultiRowTenderNo#delIndex#"  value =""  onkeypress="return validateData(event,17);"></TD>
						<TD WIDTH="5%" CLASS="multiRPTControl"  id='td14#delIndex#'><input type="text" maxlength="25"  class="txtFldNormal"  name="strMultiRowInvoiceNo"        id="strMultiRowInvoiceNo#delIndex#"      value =""  onkeypress="return validateData(event,17);"></TD>
						 <TD WIDTH="10%"  CLASS="multiRPTControl" id='td15#delIndex#'><dateTag:date name="strMultiRowInvoiceDate" id="strMultiRowInvoiceDate#delIndex#"  value=""></dateTag:date></TD>
						<td WIDTH="2%"  colspan='1' class="multiRPTControl" id='td14#delIndex#'><img name="" onkeypress="onPressingEnter(this,event)" src="../../hisglobal/images/minus.gif" style="cursor: pointer;" title="Delete Row" onclick="deleteRow('#delIndex#',1,0);">
			
			
	</tr>
</table>
</logic:equal>
<logic:notEqual value="14" name="itemInventoryProgramTransBean" property="strStoreTypeFlag">
<table width='150%' align="center" cellpadding="1px" cellspacing="0px" id="td#delIndex#">
  <tr>  
						<input type="hidden" name="strRowIndex" id="strRowIndex#delIndex#"  value=#delIndex# />
						<input type="hidden" name="strAvlBatchFlg" id="strAvlBatchFlg#delIndex#"> 
						<input type="hidden" name="strMultiRowCurrenDate" id="strMultiRowCurrenDate#delIndex#"  value="" />
						<td  WIDTH="1%" id="slNo#delIndex#" CLASS="multiRPTControl" >
						
		          	   <input type="text" size="1"  name="strSNo" value=""  readonly="readonly"  style="border: 0px; LINE-HEIGHT: 16px; text-align: center; FONT-FAMILY: Geneva, Verdana, 'sans-serif'; HEIGHT: 20px;width:20px;"  >
		
		                    
		                    </td>
						
						<TD WIDTH="5%" CLASS="multiRPTControl" id='td1#delIndex#'>						
						 <div id="ExistingBatchId"><select name="strMultiRowExistingBatchId"  id="strMultiRowExistingBatchId#delIndex#" class="comboNormal" onchange=""><option value="0">Select Value</option></select></div>
						</TD>
						<TD WIDTH="6%" CLASS="multiRPTControl" id='td2#delIndex#'><input type="text" maxlength="25" class="txtFldMax" name="strMultiRowFinalBatchNo" id="strMultiRowFinalBatchNo#delIndex#"    value =""  onkeypress="return validateData(event,17);" onBlur="checkBatchExistence(this,'#delIndex#');" /></TD>
						<TD WIDTH="4%" CLASS="multiRPTControl" id='td3#delIndex#'><input type="text" maxlength="8"  class="txtFldMin"    name="strMultiRowActiveQty"    id="strMultiRowActiveQty#delIndex#"       value =""  onkeypress="return validateData(event,5);"  onBlur="checkQtyValidaion(1,this,'#delIndex#');">
						<input style="display:none;" type="text" maxlength="8"  class="txtFldMin" 	 name="strMultiRowQuarnQty"     id="strMultiRowQuarnQty#delIndex#"        value =""  onkeypress="return validateData(event,5);"  onBlur="checkQtyValidaion(2,this,'#delIndex#');"></TD>
						<!-- <TD WIDTH="7%" CLASS="multiRPTControl" id='td5#delIndex#'> -->
						<input type="text" maxlength="8"  class="txtFldMin" 	 name="strMultiRowInActiveQty"  id="strMultiRowInActiveQty#delIndex#" style="display: none;"     value =""  onkeypress="return validateData(event,5);"  onBlur="checkQtyValidaion(3,this,'#delIndex#');">
						<!--  </TD>-->
						<TD WIDTH="5%" CLASS="multiRPTControl" id='td16#delIndex#'><input type="text" maxlength="10"  class="txtFldMin" 	 name="strMultiRowPurRate"         id="strMultiRowPurRate#delIndex#"  onchange="calSalePriceNew(this,'#delIndex#');"           value =""  onkeypress="return validateData(event,7);"  onBlur=""></TD>
						<TD WIDTH="5%" CLASS="multiRPTControl" id='td19#delIndex#'><input type="text" maxlength="10"  class="txtFldMin" 	 name="strMultiRowTax"         id="strMultiRowTax#delIndex#" onchange="calSalePrice(this,'#delIndex#');"            value ="0"  onkeypress="return validateData(event,7);"  onBlur=""></TD>
						<TD WIDTH="5%" CLASS="multiRPTControl" id='td6#delIndex#'><input type="text" maxlength="10"  class="txtFldMin" 	 name="strMultiRowRate"         id="strMultiRowRate#delIndex#"            value =""  onkeypress="return validateData(event,7);" disabled='disabled' onBlur=""></TD>
						<TD WIDTH="5%" CLASS="multiRPTControl" id='td17#delIndex#'><input type="text" maxlength="10"  class="txtFldNormal" 	 name="strMultiRowHandlingCharges"  onchange="calCost(this,'#delIndex#');"      id="strMultiRowHandlingCharges#delIndex#"            value =""  onkeypress="return validateData(event,7);"  onBlur=""></TD>
						<TD WIDTH="5%" CLASS="multiRPTControl" id='td27#delIndex#'><input type="text" maxlength="10"  class="txtFldNormal" 	 name="strMultiRowHandlingChargesFinal"  onchange="calCost(this,'#delIndex#');"      id="strMultiRowHandlingChargesFinal#delIndex#"            value =""  onkeypress="return validateData(event,7);"  onBlur=""></TD>
						<TD WIDTH="5%" CLASS="multiRPTControl" id='td18#delIndex#'><input type="text" maxlength="10"  class="txtFldNormal" 	 name="strMultiRowCosttoPat"         id="strMultiRowCosttoPat#delIndex#"            value =""  onkeypress="return validateData(event,7);"  onBlur="" disabled='disabled'></TD>
						<TD WIDTH="5%" CLASS="multiRPTControl" id='td7#delIndex#'>						
						<div id="RateUnitId"><select name="strMultiRowRateUnitId" id="strMultiRowRateUnitId#delIndex#" class="comboMax" onchange=""><option value="0">Select Value</option></select></div>
						</TD>
						
						<!-- <TD WIDTH="9%" CLASS="multiRPTControl"  id='td9#delIndex#'><input    type="text" maxlength="10"  class="txtFldNormal" 	 name="strMultiRowMfgDate"            id="strMultiRowMfgDate#delIndex#"               value =""   onBlur="checkDateFormat(1,this,'#delIndex#');"></TD>
						<TD WIDTH="8%" CLASS="multiRPTControl"  id='td8#delIndex#'><input    type="text" maxlength="10"  class="txtFldNormal" 	 name="strMultiRowExpiryDate"         id="strMultiRowExpiryDate#delIndex#"            value =""   onBlur="checkDateFormat(2,this,'#delIndex#');"></TD>
						 -->
						<TD WIDTH="7%"  CLASS="multiRPTControl" id='td9#delIndex#'><dateTag:date name="strMultiRowMfgDate"     id="strMultiRowMfgDate#delIndex#"  value=""></dateTag:date></TD>
					    <TD WIDTH="7%"  CLASS="multiRPTControl" id='td8#delIndex#'><dateTag:date name="strMultiRowExpiryDate" id="strMultiRowExpiryDate#delIndex#"  value=""></dateTag:date></TD>
						
						
						
						<TD WIDTH="7%" CLASS="multiRPTControl"  id='td11#delIndex#'><select  name="strMultiRowMfgId"     id="strMultiRowMfgId#delIndex#"         class="comboNormal"  onchange="checkMfgName(this,'#delIndex#');"><bean:write name="itemInventoryProgramTransBean" property="strManufactureCombo" filter="false" /></TD>
						<TD WIDTH="7%" CLASS="multiRPTControl"  id='td10#delIndex#'><input type="text" maxlength="90"  class="txtFldMax"     name="strMultiRowMfgName"     id="strMultiRowMfgName#delIndex#"   onBlur="checkDuplicateMfgName(this,'#delIndex#');" disabled='disabled'  value =""  onkeypress="return validateData(event,18);"></TD>
						<TD WIDTH="5%" CLASS="multiRPTControl"  id='td12#delIndex#'><input type="text" maxlength="50"  class="txtFldNormal"  name="strMultiRowPONo"        id="strMultiRowPONo#delIndex#"      value =""  onkeypress="return validateData(event,7);"></TD>
						<TD WIDTH="5%" CLASS="multiRPTControl"  id='td13#delIndex#'><input type="text" maxlength="40"  class="txtFldNormal"  name="strMultiRowTenderNo"    id="strMultiRowTenderNo#delIndex#"  value ="0"  onkeypress="return validateData(event,17);"></TD>
						<TD WIDTH="5%" CLASS="multiRPTControl"  id='td14#delIndex#'><input type="text" maxlength="25"  class="txtFldNormal"  name="strMultiRowInvoiceNo"        id="strMultiRowInvoiceNo#delIndex#"      value =""  onkeypress="return validateData(event,17);"></TD>
						 <TD WIDTH="5%"  CLASS="multiRPTControl" id='td15#delIndex#'><dateTag:date name="strMultiRowInvoiceDate" id="strMultiRowInvoiceDate#delIndex#"  value=""></dateTag:date></TD>
						<TD WIDTH="5%"  CLASS="multiRPTControl" id='td23#delIndex#'><select name="strMultiRowFlag" id="strMultiRowFlag#delIndex#" class="comboMin" onchange=""><option value="1">No</option><option value="2">Yes</option></select></TD>
						<td WIDTH="2%"  colspan='1' class="multiRPTControl" id='td14#delIndex#'><img name=""
			onkeypress="onPressingEnter(this,event)"
			src="../../hisglobal/images/minus.gif" style="cursor: pointer;"
			title="Delete Row" onclick="deleteRow('#delIndex#',1,0);generateSlNo();"></td>
			
	</tr>
</table>
</logic:notEqual>

</div>
<input type="hidden" name="rowIndex1" value="0"> <input
	type="hidden" name="rowLength1" value="0"></form>