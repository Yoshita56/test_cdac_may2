<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<form name="multirow">
<div id="rowAdded1" style="display: none">
<table class="TABLEWIDTH" align="center" cellspacing="1px">
	<tr>
		<td colspan="1"  class="LABEL" width="14.28%">
			<font color="red">*</font>Employee Name
			</td>
			<td colspan="1"  class="CONTROL" width="15.28%">
			<div id="EmployeeId#delIndex#"><select name="strEmpId" class='comboMin' id="strEmpId#delIndex#"
			>
					<bean:write name="indentAuthorizationBean" property="strEmployeeNameValues" filter="false"/></select></div></td>
			
			<td colspan="1"  class="LABEL" width="16.28%"><font color="red">*</font>Level</td>
			<td colspan="1"  class="CONTROL" width="17.28%">
			<div id="Level#delIndex#"><select name="strLevel" class='comboMin' id='strLevel#delIndex#'
			>
					
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					
					</select></div></td>
			
	</tr>	
	
			
</table>
</div>
<input type="hidden" name="rowIndex1" value="0">
 <input	type="hidden" name="rowLength1" value="0">
</form>
				