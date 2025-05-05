<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<form name="multirow">
<div id="rowAdded1" style="display: none">

   <table class="TABLEWIDTH"  bgcolor='#DBDBDB' cellspacing="0px" class="" align="center"  id="td#delIndex#">
			
	<tr>
		<td width="5%" class='multiPOControl' >
		<div id="slNo#delIndex#" style='text-align:center;'>
		
		<input type="text" size="1" readonly name="strSNo" value=""  style="border: 0px; BACKGROUND: #F5F3F3; LINE-HEIGHT: 16px; text-align: center; FONT-FAMILY: Geneva, Verdana, 'sans-serif'; HEIGHT: 20px"  >
		
		</div>
		</td>
		<td width="14%" style='text-align:center;' class='multiPOControl'>
			<input type="text" name="strMultiInvoiceNo" id="strMultiInvoiceNo#delIndex#"  class="txtFldMax" maxlength="100" onkeypress="return validateData(event,18);" >
		</td>
		<td width="14%"style='text-align:right;' class='multiPOControl'>
		   	<dateTag:date name="strMultiInvoiceDate"     id="strMultiInvoiceDate#delIndex#"  value="${billApprovalTransBean.strCurrentDate}"></dateTag:date>
		</td>
		
		
		<td width="14%" style='text-align:right;' 		class='multiPOControl'>
		  <input type="text" name="strMultiInvoiceAmount" 	class="txtFldMax" id="strMultiInvoiceAmount#delIndex#"   onkeyup="QtyValidation('#delIndex#');calCost(this,'#delIndex#');"   class="txtFldNormal" maxlength="10" onkeypress="return validateData(event,7);" >
		</td>	
		
		<td width="14%" style='text-align:center;' class='multiPOControl'>			
			<input type="text" name="strMultiInvoiceTax" id="strMultiInvoiceTax#delIndex#"  class="txtFldMin"        onkeyup="QtyValidation('#delIndex#');calCost(this,'#delIndex#');"  maxlength="100" onkeypress="return validateData(event,7);" >
		</td>	
		
		<td width="14%" style='text-align:right;' 		class='multiPOControl'>
		  <input type="text" name="strMultiInvoiceDisc" 	class="txtFldMax" id="strMultiInvoiceDisc#delIndex#"      onkeyup="QtyValidation('#delIndex#');calCost(this,'#delIndex#');"    class="txtFldNormal" maxlength="10" onkeypress="return validateData(event,7);" >
		</td>
		<td width="14%" style='text-align:right;' class='multiPOControl'>
		  <input type="text" name="strMultiInvoiceValue" class="txtFldMax" id="strMultiInvoiceValue#delIndex#"       class="txtFldNormal" maxlength="10" onkeypress="return validateData(event,7);" readonly>
		</td>
			<td width="5%" style='text-align:center;' class='multiPOControl'>
			
			<img name=""
			onkeypress="onPressingEnter(this,event)"
			src="../../hisglobal/images/minus.gif" style="cursor: pointer;text-align:center;"
			title="Delete Row" onclick="deleteRow('#delIndex#',1,0);generateSlNo_D(1);">
			</td>
		
	</tr>
  </table>
</div>
<input type="hidden" name="rowIndex1" value="0"> 
<input type="hidden" name="rowLength1" value="0">

</form>


