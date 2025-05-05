<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<form name="multirow">
<div id="rowAdded2" style="display:none">
<table class="TABLEWIDTH" align="center"  cellspacing="1px">
	<tr>
		<td width="40%" class="multiControl">
			<div align="right"><input type="text"  name="strIcdCode" onkeyup="setCode(this,'#delIndex#')" id="strIcdCode#delIndex#" maxlength="25"  title="Enter ICD10 Code"  >(ICD10 Code)</div>
		</td>	
		<td width="54%" class="multiControl">
		<div id="diagnosisCombo" ></div>
		</td>
		<td width="6%" class="multiControl">
		<img src="../../hisglobal/images/minus.gif" style="cursor:pointer;pointer:hand"  style="cursor:pointer;pointer:hand"
			 onClick="deleteRow('#delIndex#','2','0');"></td>
	</tr>
</table>
</div>
<input type="hidden" name="rowIndex2" value="0"> 
<input type="hidden" name="rowLength2" value="0">
	
	</form>