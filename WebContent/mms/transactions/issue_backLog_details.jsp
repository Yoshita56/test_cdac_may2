<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<form name="multirow">
<div id="rowAdded1" style="display: none">
<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
  <tr>
                        <input type="hidden" name="strOldBatchNo" value="0" />
						<input type="hidden" name="strOldIssueQty" value="0" />
						<input type="hidden" name="strUnitId" value="0" />
						<TD WIDTH="40%" CLASS="multiControl" colspan='1'><select class="combo1Max" name="strDrugId" id="strDrugId#delIndex#" onChange="getBatchCombo(this,'#delIndex#');"><bean:write name="issueBackLogDtl" property="strDrugNameCombo" filter="false"/></select></TD>
						<TD WIDTH="20%" CLASS="multiControl" colspan='1'><div id="batchID#delIndex#"><select class="comboMax" name="strBatchNo" id="strBatchNo#delIndex#" ><option value="0">Select Value</option></select></div></TD>
						<TD WIDTH="15%" CLASS="multiControl" colspan='1'><input type="text"  name="strIssueQty" id="strIssueQty#delIndex#"  maxlength ="100" onkeypress="return validateData(event,5);"></TD>
						<TD WIDTH="15%" CLASS="multiControl" colspan='1'><div id="unitID#delIndex#">No.</div></TD>
						
						<td WIDTH="5%"  colspan='1' class="multiControl"><img name=""
			onkeypress="onPressingEnter(this,event)"
			src="../../hisglobal/images/minus.gif" style="cursor: pointer;"
			title="Delete Row" onclick="deleteRow('#delIndex#',1,0);"></td>
	</tr>
</table>
</div>
<input type="hidden" name="rowIndex1" value="0"> <input
	type="hidden" name="rowLength1" value="0"></form>