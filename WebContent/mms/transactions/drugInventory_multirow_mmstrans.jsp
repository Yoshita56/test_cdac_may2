<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<form name="multirow">
<div id="rowAdded1" style="display:none">

<table class="TABLEWIDTH" align="center" border="0" cellpadding="1px" cellspacing="1px">
<tr>
<td class="multiControl" width="20%"><input type="hidden" name="strItemOtherDtls" id="strItemOtherDtls#delIndex#" value=""><div id="itemOtherNameDivId#delIndex#"></div>
</td>
<td class="multiControl" width="20%"><div id="itemOtherBatchNoDivId#delIndex#"></div>
</td>
<td class="multiControl" width="20%"><div id="itemOtherExpiryDateDivId#delIndex#"></div>
</td>
<td class="multiControl" width="20%"><div id="itemOtherQtyDivId#delIndex#"></div>
</td>
<td class="multiControl" width="5%"><img src="../../hisglobal/images/minus.gif"
				onClick="deleteRow('#delIndex#','1','0');"
				style="cursor: pointer; " />
</td>
</tr>
</table>

</div>
<input type="hidden" name="rowIndex1" value="0"> 
<input type="hidden" name="rowLength1" value="0">

</form>