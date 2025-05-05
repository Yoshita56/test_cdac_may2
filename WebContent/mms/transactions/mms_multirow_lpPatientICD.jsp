<form name="multirow">

<div id="rowAdded2" style="display: none">
<table class="TABLEWIDTH" align="center" cellpadding="1px"
	cellspacing="1px">
	<tr>
		<td class="multiControl" width="30%"><input type=text
			title="Please Enter Disease Code" class="txtFldMin" onmouseover="Tip(this.value,SHADOW,true)" onmouseout="UnTip()"
			onkeypress="return setSelectValue1('strProvisionDiagnosis#delIndex#',1,event,'setIcdCodes^tariffFullNameDiv','#delIndex#');"
			onkeyup="getIcdCodeValues1('1', this , event, '#delIndex#');"
			id='strProvisionDiagnosis#delIndex#' name='strProvisionDiagnosis'>(Disease
		Code)</td>
		<td class="multiControl" width="70%" align="left"><div align="left">
		&nbsp;<input type=text class="txtFldBig"
			name='strIcdCode' id='strIcdCode#delIndex#' style='width: 490px'  onmouseover="Tip(this.value,SHADOW,true)" onmouseout="UnTip()"
			onkeypress="return setSelectValue1('strIcdCode#delIndex#','1',event,'setIcdCodes^tariffFullNameDiv','#delIndex#');"
			onkeyup="getIcdCodeValues1(2,this,event ,'#delIndex#');"
			title='Enter Disease Code'><INPUT TYPE='HIDDEN'
			NAME='strICD10CodeHidden' id='strICD10CodeHidden#delIndex#'></div></td>
		<td class="multiControl"><img name="icd10IdplusForDelete"
			onkeypress="onPressingEnter(this,event)"
			src="/DWH/hisglobal/images/minus.gif" style="cursor: pointer;"
			title="Delete Row" onclick="deleteRow('#delIndex#',2,0);"></td>
	</tr>

</table>
</div>
<input type="hidden" name="rowIndex2" value="0"> <input
	type="hidden" name="rowLength2" value="0"></form>
	

 