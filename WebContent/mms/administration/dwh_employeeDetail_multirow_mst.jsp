<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<form name="multirow">
<div id="rowAdded1" style="display: none">
<table class="TABLEWIDTH" bgcolor='#CC9966' align="center" cellpadding="1px"
	cellspacing="1px">
	
	<tr>
		
		<td width="23.75%" class="multiControl">
		<div id="slNo#delIndex#" align="center">
		
		<input type="text" size="1"  name="strSNo" value=""  style="border: 0px; BACKGROUND: #F5F3F3; LINE-HEIGHT: 16px; text-align: center; FONT-FAMILY: Geneva, Verdana, 'sans-serif'; HEIGHT: 20px"  >
		
		</div>
		</td>
		<td width="23.75%" class="multiControl">
			<input type="text" name="strDependentName" id="strDependentName#delIndex#"  class="txtFldMax" maxlength="100" onkeypress="return validateData(event,4);" >
		</td>
		<td width="23.75%" class="multiControl">
		<input type="text" name="strAge" class="txtFldMin" id="strAge#delIndex#" class="txtFldMax" maxlength="2" onkeypress="return validateData(event,7);" >
		</td>
		<td width="23.75%" class="multiControl">
			<select name="strRelationshipId" class="comboNormal" id="strRelationshipId#delIndex#" onchange="getRelationshipCombo(this);">
				<bean:write name="employeeDetailMstBean" property="strRelationship" filter="false"/>
			</select>
		</td>
			<td width="5%" class="multiControl">
			
			<img name=""
			onkeypress="onPressingEnter(this,event)"
			src="../../hisglobal/images/minus.gif" style="cursor: pointer;"
			title="Delete Row" onclick="deleteRow('#delIndex#',1,0);generateSlNo();">
			</td>
		
			
			
		
	</tr>
</table>
</div>
<input type="hidden" name="rowIndex1" value="0"> 
<input type="hidden" name="rowLength1" value="0">


</form>


