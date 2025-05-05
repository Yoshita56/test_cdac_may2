<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>

<form name="multirow">
 <div id="rowAdded1" style="display:none">
 <table class="TABLEWIDTH" align="center">	
	<tr>
		<td  class="multiControl" width="90%"><input type="text" name="strSparePartsName"    id="strSparePartsName#delIndex#" class="txtFldMax" onkeypress="return validateData(event,4);" /></td>
		<td  class="multiControl" width="10%">
		
		<img src ="../../hisglobal/images/minus.gif"  
			 style ="cursor:pointer;cursor:pointer"  
			 title ="Remove Tariff"
			 onClick ="deleteRow('#delIndex#','1','0');"></td>
	</tr>
</table>
</div>
<input type="hidden" name="rowIndex1" value="0"> 
<input type="hidden" name="rowLength1" value="0">
</form>