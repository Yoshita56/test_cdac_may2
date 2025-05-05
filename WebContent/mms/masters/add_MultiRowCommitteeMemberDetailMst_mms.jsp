<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<form name="multirow">

<div id="rowAdded1" style="display: none">
<table class="TABLEWIDTH" border="0" align="center" cellspacing="1px">

	<tr>
		<td class="multiLabel" width="3%"><font color="red"></font>Employee</td>
		<td class="multiLabel" width="15%"><font color="red"></font>Employee
		No</td>
		<td class="multiLabel" width="15%"><font color="red"></font>Employee
		Name</td>
		<td class="multiLabel" width="6%"><font color="red"></font>Address
		Details</td>
		<td class="multiLabel" width="2%">#</td>

	</tr>
	<tr>
		<td class="multiControl" width="6%"><input type="checkbox"
			name="strIsEmployee" value="0" id="strIsEmployee#delIndex#"
			onClick="showRow('#delIndex#');showCombo('#delIndex#')"></td>
		<td class="multiControl" width="11%">
		<div id='EmpNoText#delIndex#' style='display: block'><input
			class="txtFldMax" type="text" name="strEmpNo" value=""
			id="strEmpNo#delIndex#" maxlength="13"
			onkeypress="return validateData(event,8);" disabled="disabled">
		</div>
		<div id='EmpNoCombo#delIndex#' style='display: none'><select
			name='strEmpNoCombo' id='strEmpNoCombo#delIndex#'
			onChange="getDetailsForSelectedEmpNO('#delIndex#')">
			<bean:write name="committeeMemberDtlBean"
				property="strConstituteByCombo" filter="false" />
			<option value="0">Select Value</option>
		</select></div>


		</td>
		<td class="multiControl" width="12%"><input class="txtFldMax"
			type="text" name="strEmpName" value="" id="strEmpName#delIndex#"
			maxlength="20" onkeypress="return validateData(event,4);"
			disabled="disabled"></td>
		<td class="multiControl" width="7%"><img
			src="../../hisglobal/images/viewDetails.gif"
			style="cursor: pointer; cursor: pointer"
			onClick="showRow('#delIndex#')"></td>
		<td class="multiControl" width="2%"><img
			src="../../hisglobal/images/minus.gif"
			style="cursor: pointer; cursor: pointer" name="minus"
			onClick="deleteRow('#delIndex#','1','0');"></td>
	</tr>
</table>
<input type="hidden" name="RowBlock" id="RowBlock#delIndex#" value="0" />
<div id="idAddrDtl#delIndex#" style="display: none;">
<table class="TABLEWIDTH" align="center" cellspacing="1px" border="0"
	bordercolor="black">

	<tr>
		<td class="multiLabel" width="10%"><font color="red"></font>Address</td>
		<td class="multiLabel" width="8%"><font color="red"></font>Phone
		No</td>
		<td class="multiLabel" width="8%"><font color="red"></font>Email</td>
		<td class="multiLabel" width="8%"><font color="red"></font>UserId</td>
		<td class="multiLabel" width="10%"><font color="red"></font>Level</td>
	</tr>
	<tr>
		<td class="multiControl" width="10%"><input class="txtFldMax"
			type="text" name="strEmpAddr" value="" id="strEmpAddr#delIndex#"
			maxlength="120" onkeypress="return validateData(event,3);"
			disabled="disabled"></td>
		<td class="multiControl" width="10%"><input class="txtFldNormal"
			type="text" name="strEmpPhone" value="" id="strEmpPhone#delIndex#"
			maxlength="9" onkeypress="return validateData(event,2);"
			disabled="disabled"></td>
		<td class="multiControl" width="8%"><input class="txtFldNormal"
			type="text" name="strEmpEmail" value="" id="strEmpEmail#delIndex#"
			maxlength="9" onkeypress="return validateData(event,1);"
			disabled="disabled"></td>
		<td class="multiControl" width="8%"><select name="strEmpUserId"
			class="comboNormal" id="strEmpUserId#delIndex#">
			<bean:write name="committeeMemberDtlBean" property="strUserIdCombo"
				filter="false" />
		</select></td>
		<td class="multiControl" width="10%"><input class="txtFldMin"
			type="text" name="strEmpLevel" value="" id="strEmpLevel#delIndex#"
			maxlength="4" onkeypress="return validateData(event,5);"
			onkeypress=""></td>
	</tr>
</table>
</div>
</div>
<input type="hidden" name="rowIndex1" value="0"> <input
	type="hidden" name="rowLength1" value="0">


<div id="rowAdded2" style="display: none">
<table class="TABLEWIDTH" border="0" align="center" cellspacing="1px">

	<tr>
		<td class="multiLabel" width="3%"><font color="red"></font>Employee</td>
		<td class="multiLabel" width="15%"><font color="red"></font>Employee
		No</td>
		<td class="multiLabel" width="15%"><font color="red"></font>Employee
		Name</td>
		<td class="multiLabel" width="6%"><font color="red"></font>Address
		Details</td>
		<td class="multiLabel" width="2%">#</td>

	</tr>
	<tr>
		<td class="multiControl" width="6%"><input type="checkbox"
			name="strIsEmployeeUpdateMR" value="0"
			id="strIsEmployeeUpdateMR#delIndex#"
			onClick="showRowMR('#delIndex#');showComboMR('#delIndex#')">
		<input type="hidden" name="strIsEmployeeUpdateMRDummy"
			id="strIsEmployeeUpdateMRDummy#delIndex#" value="" /></td>

		<td class="multiControl" width="11%">
		<div id='EmpNoUpdateText#delIndex#' style='display: block'><input
			class="txtFldMax" type="text" name="strEmpNoUpdateMR" value=""
			id="strEmpNoUpdateMR#delIndex#" maxlength="13"
			onkeypress="return validateData(event,8);"></div>
		<div id='EmpNoUpdateCombo#delIndex#' style='display: none'><select
			name='strEmpNoUpdateMRCombo' id='strEmpNoUpdateMRCombo#delIndex#'
			onChange="getDetailsForSelectedEmpNOUpdate('#delIndex#')">
			<bean:write name="committeeMemberDtlBean"
				property="strConstituteByCombo" filter="false" />
			<option value="0">Select Value</option>
		</select> <input type="hidden" name="strEmpNoUpdateMRComboDummy"
			id="strEmpNoUpdateMRComboDummy#delIndex#" value="" /></div>
		</td>
		<td class="multiControl" width="12%"><input class="txtFldMax"
			type="text" name="strEmpNameUpdateMR" value=""
			id="strEmpNameUpdateMR#delIndex#" maxlength="20"
			onkeypress="return validateData(event,4);"></td>
		<td class="multiControl" width="7%"><img
			src="../../hisglobal/images/viewDetails.gif"
			style="cursor: pointer; cursor: pointer"
			onClick="showUpdateRow('#delIndex#')"></td>
		<td class="multiControl" width="2%"><img
			src="../../hisglobal/images/minus.gif"
			style="cursor: pointer; cursor: pointer" name="minus"
			onClick="deleteRow('#delIndex#','2','0');"></td>
	</tr>
</table>
<div id="idUpdateDtl#delIndex#" style="display: none;">
<table class="TABLEWIDTH" align="center" cellspacing="1px" border="0"
	bordercolor="black">

	<tr>
		<td class="multiLabel" width="10%"><font color="red"></font>Address</td>
		<td class="multiLabel" width="8%"><font color="red"></font>Phone
		No</td>
		<td class="multiLabel" width="8%"><font color="red"></font>Email</td>
		<td class="multiLabel" width="8%"><font color="red"></font>UserId</td>
		<td class="multiLabel" width="10%"><font color="red"></font>Level</td>
	</tr>
	<tr>
		<td class="multiControl" width="10%"><input class="txtFldMax"
			type="text" name="strEmpAddrUpdateMR" value=""
			id="strEmpAddrUpdateMR#delIndex#" maxlength="120"
			onkeypress="return validateData(event,3);"></td>
		<td class="multiControl" width="10%"><input class="txtFldNormal"
			type="text" name="strEmpPhoneUpdateMR" value=""
			id="strEmpPhoneUpdateMR#delIndex#" maxlength="9"
			onkeypress="return validateData(event,2);"></td>
		<td class="multiControl" width="8%"><input class="txtFldNormal"
			type="text" name="strEmpEmailUpdateMR" value=""
			id="strEmpEmailUpdateMR#delIndex#" maxlength="9"
			onkeypress="return validateData(event,1);"></td>
		<td class="multiControl" width="8%"><select
			name="strEmpUserIdUpdateMR" class="comboNormal"
			id="strEmpUserIdUpdateMR#delIndex#">
			<bean:write name="committeeMemberDtlBean" property="strUserIdCombo"
				filter="false" />
		</select></td>
		<td class="multiControl" width="10%"><input class="txtFldMin"
			type="text" name="strEmpLevelUpdateMR" value=""
			id="strEmpLevelUpdateMR#delIndex#" maxlength="4"
			onkeypress="return validateData(event,5);"></td>
	</tr>
</table>
</div>
</div>
<input type="hidden" name="rowIndex2" value="0" /> <input type="hidden"
	name="rowLength2" value="0" /></form>