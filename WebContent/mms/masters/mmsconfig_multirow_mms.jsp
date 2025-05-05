<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>

<form name="multirow">
 <div id="rowAdded1" style="display:none">
 <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">	
	<tr>
		<td  class="multiControl" width="30%"><input type="hidden" name="strFromDays"   id="strFromDays#delIndex#" value=""  /><div id="strFromDaysDivId#delIndex#"></div></td>
		<td  class="multiControl" width="30%"><input type="text" name="strToDays"    id="strToDays#delIndex#" class="txtFldMin" maxlength="3" onkeypress="return validateData(event,5);" /></td>
		<td  class="multiControl" width="30%"><input type="text" name="strPenalty"    id="strPenalty#delIndex#" class="txtFldMin" maxlength="5" onkeypress="return validateData(event,7);" /></td>
		
</table>
</div>
<input type="hidden" name="rowIndex1" value="0"> 
<input type="hidden" name="rowLength1" value="0">
</form>