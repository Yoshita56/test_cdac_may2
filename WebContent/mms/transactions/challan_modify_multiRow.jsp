<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<form name="multirow">
<div id="rowAdded1" style="display: none">
<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
  <tr>
                        <input type="hidden" name="strHiddenChallanNo"  value='0' />
						<input type="hidden" name="strHiddenChallanQty" value='0' />
						<input type="hidden" name="strHiddenPODate"     value='0' />
					    
					    <TD WIDTH="12%"  CLASS="multiRPTControl" colspan='1'><input type="text" maxlength="25" class="txtFldNormal"      name="strMultiRowBatchNo"        id="strMultiRowBatchNo#delIndex#"      value =""  maxlength="100" onkeypress="return validateData(event,17);"></TD>
					    <TD WIDTH="11%"  CLASS="multiRPTControl" colspan='1'><input type="text" class="txtFldNormal" onKeyUp='calQty();' name="strMultiRowReceivedQty"    id="strMultiRowReceivedQty#delIndex#"  value =""  maxlength="100" onkeypress="return validateData(event,5);"></TD>
		                <TD WIDTH="11%"  CLASS="multiRPTControl" colspan='1'><input type="text" maxlength="20" class="txtFldNormal"      name="strMultiRowRejectedQty"    id="strMultiRowRejectedQty#delIndex#"  value ="" maxlength="100" onkeypress="return validateData(event,17);"></TD>
		                <TD WIDTH="11%"  CLASS="multiRPTControl" colspan='1'><input type="text" maxlength="20" class="txtFldNormal"      name="strMultiRowBreakageQty"    id="strMultiRowBreakageQty#delIndex#"  value ="" maxlength="100" onkeypress="return validateData(event,17);"></TD>
		                <TD WIDTH="11%"  CLASS="multiRPTControl" colspan='1'><input type="text" maxlength="20" class="txtFldNormal"      name="strMultiRowExcessQty"      id="strMultiRowExcessQty#delIndex#"  value ="" maxlength="100" onkeypress="return validateData(event,17);"></TD>
					    <TD WIDTH="14%"  CLASS="multiRPTControl" colspan='1'><dateTag:date                                               name="strMultiRowExpireDate"     id="strMultiRowExpireDate#delIndex#"  value=""></dateTag:date></TD>
					    <TD WIDTH="14%"  CLASS="multiRPTControl" colspan='1'><dateTag:date                                               name="strMultiRowManufacterDate" id="strMultiRowManufacterDate#delIndex#"  value=""></dateTag:date></TD>
						<TD WIDTH="13%"  CLASS='multiRPTControl' colspan='1'><a STYLE='cursor:pointer;cursor:hand;color:blue' title='Click Here to enter Performance Detail(s)' name="strDrugName" id="strDrugName#delIndex#" onClick='drugDtl(this,"#delIndex#");'><b><font size='2'><div id="orignalDtl#delIndex#">Y,Y,Y,Y,Y</div></font></b></a><input type="hidden" name="strMultiRowPerformanceDtlEntry" id="strMultiRowPerformanceDtlEntry#delIndex#" value="0^0^0^0^0" /></TD>
						
						<TD WIDTH="8%"  colspan='1' class="multiRPTControl"><img name=""
			                            onkeypress="onPressingEnter(this,event)"
			                            src="../../hisglobal/images/minus.gif" style="cursor: pointer;"
			                            title="Delete Row" onclick="deleteRow('#delIndex#',1,0);"></td>
	</tr>
</table>
</div>
<input type="hidden" name="rowIndex1" value="0"> <input
	type="hidden" name="rowLength1" value="0"></form>