<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<form name="multirow">
<div id="rowAdded1" style="display:none">
<table class="TABLEWIDTH" align="center"  cellspacing="1px">
<tr >
		
		<td width="23.75%" class="multiLabel"  bordercolor="black">
			Brand Name
		</td>
		<td width="23.75%" class="multiLabel" bordercolor="black">
			Manufacturer
		</td>
		<td width="23.75%" class="multiLabel" bordercolor="black">
			Rate
		</td>
		<td width="23.75%" class="multiLabel" bordercolor="black">
			Unit Name
		</td>
		<td width="5%" class="multiControl"><img
			src="../../hisglobal/images/minus.gif"
			onClick="deleteRow('#delIndex#','1','0');" style="cursor: pointer; " onmouseover=""></td>
		
		
		
	</tr>
	<tr>
		
		<td width="23.75%" class="multiControl">
		<input type='hidden' name='checkRow'>
		<input type="text" name="strBrandName" id="strBrandName#delIndex#"  class="txtFldMax" maxlength="100">
		</td>
		<td width="23.75%" class="multiControl">
			<select name="strBrandedManufacturer" class="comboNormal" id="strBrandedManufacturer#delIndex#">
					<bean:write name="itemBean" property="strManufacturerValues" filter="false"/>
			</select>
		</td>
		<td width="23.75%" class="multiControl">
		<input type="text" name="strBrandedRate" class="txtFldMin" id="strBrandedRate#delIndex#" class="txtFldMax" maxlength="11" onkeypress="return validateData(event,7);" >
		</td>
		<td width="23.75%" class="multiControl">
			<select name="strBrandedUnit" class="comboNormal" id="strBrandedUnit#delIndex#">
				<bean:write name="itemBean" property="strUnitValues" filter="false"/>
			</select>
		</td>
			<td width="5%" class="multiControl"></td>
		
			
			
		
	</tr>
	
</table>
<div id="idSubdtl#delIndex#" style="display:block;">
<table class="TABLEWIDTH" align="center"  cellspacing="1px" >
	
	
<tr>
		
		<td width="23.75%" class="multiLabel">
			Approved By
		</td>
		
		<td width="23.75%" class="multiLabel">
			Issue Type
		</td>
		<td width="23.75%" class="multiLabel">
			Item Make
		</td>
		<td width="23.75%" class="multiLabel" colspan="">
			
		</td>
		<td width="5%" class="multiLabel">
		</td>
		
	</tr>	
	<tr>
	<td width="23.75%" class="multiControl">
		<select name="strBrandedApprovedBy"  id="strBrandedApprovedBy#delIndex#" class="comboNormal">
					<option value="0"> Hospital</option>
					<option value="1">CPA</option>
					<option value="2">Hospital/CPA</option>
				</select>
		</td>
		<td width="23.75%"  class="multiControl">
			<select name="strBrandedIssueType" id="strBrandedIssueType#delIndex#"  class="comboNormal">
					<option value="0">Only To Patient</option>
					<option value="1">Only To Staff</option>
					<option value="2">Patient/Staff</option>
				</select>
		</td>
		
		<td width="23.75%" class="multiControl">
			<select name="strBrandedItemMaker" class="comboNormal" id="strBrandedItemMaker#delIndex#">
					<option value="0">Indian</option>
					<option value="1">Foreigner</option>
					
				</select>
		</td>
		<td width="23.75%" class="multiControl" class="multiControl">
		
		</td>
		<td width="5%" class="multiControl">
		</td>
		
	</tr>
	<tr>
		<td colspan="5" bgcolor="orange"></td>
	</tr>
</table>
</div>

</div>
<input type="hidden" name="rowIndex1" value="1"> 
<input type="hidden" name="rowLength1" value="1">



</form>