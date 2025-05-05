<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<form name="multirow">
<div id="rowAdded1" style="display: none">
<table width='1200' align="center" cellpadding="1px" cellspacing="1px">
  <tr>
                        <input type='hidden' name='strHiddenChallanNo'  value='0' />
						<input type='hidden' name='strHiddenChallanQty' value='0' />
						<input type='hidden' name='strHiddenPODate'     value='0' />
					    <TD WIDTH="12%" CLASS="multiRPTControl" colspan='1'><dateTag:date   name="strMultiRowChallanReceiveDate" id="strMultiRowChallanReceiveDate#delIndex#"  value=""></dateTag:date></TD>
		                <TD WIDTH="12%" CLASS="multiRPTControl" colspan='1'><input type="text" maxlength="20" class="txtFldMax" name="strMultiRowChallanNo" id="strMultiRowChallanNo#delIndex#"  value ="" maxlength="100" onkeypress="return validateData(event,17);"></TD>
						<TD WIDTH="12%" CLASS="multiRPTControl" colspan='1'><dateTag:date   name="strMultiRowInvoiceDate" id="strMultiRowInvoiceDate#delIndex#"  value=""></dateTag:date></TD>
					    <TD WIDTH="8%"  CLASS="multiRPTControl" colspan='1'><input type="text" maxlength="25" class="txtFldNormal" name="strMultiRowBatchNo" id="strMultiRowBatchNo#delIndex#" value =""  maxlength="100" onkeypress="return validateData(event,17);"></TD>
						<TD WIDTH="8%"  CLASS="multiRPTControl" colspan='1'><input type="text" class="txtFldNormal" onKeyUp='calQty();' name="strMultiRowReceivedQty" id="strMultiRowReceivedQty#delIndex#" value ="" maxlength="100" onkeypress="return validateData(event,5);"></TD>
						<TD WIDTH="10%" CLASS="multiRPTControl" colspan='1'><select name="strMultiRowWhetherTestReportSubmitted" id="strMultiRowWhetherTestReportSubmitted#delIndex#"><option value="0">Select</option><option value="1">Yes</option><option value="2">No</option></select></TD>
						<TD WIDTH="10%" CLASS="multiRPTControl" colspan='1'><select name="strMultiRowWhetherMedicinesInGoodCondition" id="strMultiRowWhetherMedicinesInGoodCondition#delIndex#" ><option value="0">Select</option><option value="1">Yes</option><option value="2">No</option></select></TD>
						<TD WIDTH="9%" CLASS="multiRPTControl" colspan='1'><select name="strMultiRowWhetherSupplyNotForSale" id="strMultiRowWhetherSupplyNotForSale#delIndex#" ><option value="0">Select</option><option value="1">Yes</option><option value="2">No</option></select></TD>
						<TD WIDTH="9%" CLASS="multiRPTControl" colspan='1'><select name="strMultiRowWhetherBrandNameNotWritten" id="strMultiRowWhetherBrandNameNotWritten#delIndex#" ><option value="0">Select</option><option value="1">Yes</option><option value="2">No</option></select></TD>
						<TD WIDTH="8%" CLASS="multiRPTControl" colspan='1'><select name="strMultiRowWhetherMRPPrint" id="strMultiRowWhetherMRPPrint#delIndex#"><option value="0">Select</option><option value="1">Yes</option><option value="2">No</option></select></TD>
						
						<td WIDTH="8%"  colspan='1' class="multiRPTControl"><img name=""
			onkeypress="onPressingEnter(this,event)"
			src="../../hisglobal/images/minus.gif" style="cursor: pointer;"
			title="Delete Row" onclick="deleteRow('#delIndex#',1,0);"></td>
	</tr>
</table>
</div>
<input type="hidden" name="rowIndex1" value="0"> <input
	type="hidden" name="rowLength1" value="0"></form>