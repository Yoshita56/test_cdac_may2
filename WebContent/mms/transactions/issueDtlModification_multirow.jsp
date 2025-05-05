<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<form name="multirow">
<div id="rowAdded1" style="display: none">
<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
  <tr>
				    <input type="hidden" name="strOldBatchNo" value="0" />
					<input type="hidden" name="strOldIssueQty" value="0" />
					<input type="hidden" name="strUnitId" value="0" />
					<TD WIDTH="35%" CLASS="multiRowControl" colspan='1'>
						<select class="combo1Max" name="strDrugId" id="strDrugId#delIndex#" onChange="getBatchCombo(this,'#delIndex#');">
							<bean:write name="issueDtlModificationTransFB" property="strDrugNameCombo" filter="false"/>
						</select>
					</TD>
					<TD WIDTH="20%" CLASS="multiRowControl" colspan='1'><div id="batchID#delIndex#">
						<select class="comboMax" name="strBatchNo" id="strBatchNo#delIndex#" onchange="getAvlQty('#delIndex#');">
						<option value="0">Select Value</option>
						</select></div>
					</TD>
					<TD WIDTH="18%" CLASS="multiControl" colspan='1'><input type="hidden" name="strAvlQty" value=""><div id="strAvlQty#delIndex#">0.0</div></TD>
					<TD WIDTH="10%" CLASS="multiControl" colspan='1'><input type="text" size="10"  name="strIssueQty" id="strIssueQty#delIndex#"  maxlength ="100" onkeypress="return validateData(event,5);"  onblur="checkAvailQtyTwo('#delIndex#');" ></TD>
					<TD WIDTH="12%" CLASS="multiControl" colspan='1'><div id="costDivId#delIndex#"  ></div><input type="hidden"  name="strCost"  id="strCost#delIndex#" ></TD>
				<%-- <TD WIDTH="8%" CLASS="multiControl" colspan='1'><div id="unitID#delIndex#">No.</div></TD> --%>	
				<div id="unitID#delIndex#" style="display: none;">No.</div>
					
					<input type="hidden" name="strRatePerUnit" id="strRatePerUnit#delIndex#"  />
					
					
					<td WIDTH="5%"  colspan='1' class="multiControl"><img name=""
			onkeypress="onPressingEnter(this,event)"
			src="../../hisglobal/images/minus.gif" style="cursor: pointer;"
			title="Delete Row" onclick="deleteRow('#delIndex#',1,0);"></td>
	</tr>
</table>
</div>
<input type="hidden" name="rowIndex1" value="0" />
<input type="hidden" name="rowLength1" value="0" />
</form>