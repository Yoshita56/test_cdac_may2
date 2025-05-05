<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<form name="multirow">
<div id="rowAdded2" style="display: none">
<table class="TABLEWIDTH"  bgcolor='#DBDBDB' cellspacing="0px" class="" align="center"  id="td#delIndex#">
	
	<tr>
		
		<td width="5%" class='multiPOControl'>
		<div id="slNo#delIndex#" style='text-align:center;'>
		
		<input type="text" size="1" readonly name="strSNo2" value=""  style="border: 0px; BACKGROUND: #F5F3F3; LINE-HEIGHT: 16px; text-align: center; FONT-FAMILY: Geneva, Verdana, 'sans-serif'; HEIGHT: 20px"  >
		
		</div>
		</td>
		
		<td width="14%" style='text-align:left;' class='multiPOControl'>
			<select name="strMultiPayInvoiceNo" class="comboMax" id="strMultiPayInvoiceNo#delIndex#" onchange="getInvComboAmt(this,'#delIndex#');">
				<bean:write name="billApprovalTransBean" property="strMultiInvoiceNoCombo" filter="false"/>
			</select>
		</td>	
		
		<td width="14%" style='text-align:center;' class='multiPOControl'>
			<select name="strMultiPayInvoiceType" class='browser-default custom-select' id="strMultiPayInvoiceType#delIndex#" onchange="">
				 <option value="1">Full Payment</option>
                 <option value="2">Partial Payment</option>
			</select>
		</td>
				
		<td width="14%" style='text-align:center;' class='multiPOControl'>
			<input type="text" name="strMultiPayInvoiceAmount" value="0"   id="strMultiPayInvoiceAmount#delIndex#"                 class="txtFldMax" maxlength="100" onkeypress="return validateData(event,7);" >
		</td>
		
		<td width="14%" style='text-align:center;' 		class='multiPOControl'>
		  <input type="text" name="strMultiPayInvoiceTax"  value="0"	class="txtFldMax" id="strMultiPayInvoiceTax#delIndex#"          onkeyup="calFinalPayment(this,'#delIndex#');"    class="txtFldMax" maxlength="8" onkeypress="return validateData(event,7);" >
		</td>
		<td width="14%" style='text-align:center;' class='multiPOControl'>
		  <input type="text" name="strMultiPayInvoiceDisc" value="0"  class="txtFldMax" id="strMultiPayInvoiceDisc#delIndex#"           onkeyup="calFinalPayment(this,'#delIndex#');"    class="txtFldMax" maxlength="8" onkeypress="return validateData(event,7);">
		</td>
		
		<td width="14%" style='text-align:center;' class='multiPOControl'>
		  <input type="text" name="strMultiPayInvoiceValue" value="0"  readonly  class="txtFldMax" id="strMultiPayInvoiceValue#delIndex#" class="txtFldMax" maxlength="8" onkeypress="return validateData(event,7);">
		</td>
		
		<td width="5%" style='text-align:center;'  class='multiPOControl'>
			
			<img name=""
			onkeypress="onPressingEnter(this,event)"
			src="../../hisglobal/images/minus.gif" style="cursor: pointer;text-align:center;"
			title="Delete Row" onclick="deleteRow('#delIndex#',2,0);">
			</td>
		
	</tr>
</table>
</div>
<input type="hidden" name="rowIndex2" value="0"> 
<input type="hidden" name="rowLength2" value="0">


</form>

