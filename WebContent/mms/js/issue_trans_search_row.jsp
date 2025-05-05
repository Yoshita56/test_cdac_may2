<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>




<html>
<head>
<meta charset=UTF-8">
<title>Issue To Patient Process</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/DataTables.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>




<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../js/issue_trans.js"></script>
<script language="Javascript" src="../js/searchItems_utilBS.js"></script>
<script language="Javascript" src="../js/stockDetails_util.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script>
</head>

<body>

<form name="multirow">
<logic:equal value="1" name="issueBean" property="strDoseFrqFlg">
<div id="rowAdded1" style="display:none">
<table class="TABLEWIDTH" bgcolor='#6097BC'  align="center" cellpadding="1px" cellspacing="1px" id="td#delIndex#">
 <tr>
    <td class="multiControl"  width="15%">
		<input type="hidden" name="itemParamValue" id="itemParamValue#delIndex#">
		<input type="hidden" name="itemCalcValue" id="itemCalcValue#delIndex#">
		<input type="hidden" name="itemUserValue" id="itemUserValue#delIndex#">

		<div id="itemParaId1#delIndex#">
		</div>
	</td>
	

	<td class="multiControl" width="15%">
		<div id="itemParaId11#delIndex#"></div>
	</td>
	
	<td class="multiControl"  width="15%">
			<div id="itemParaId4#delIndex#"></div>
	</td>
	
	<td class="multiControl"  width="15%">
			<div id="itemParaId5#delIndex#"></div>
	</td>
	
	<td width="15%" class="multiControl">
		<select name="strDose"  class='comboMin'
			id="strDose#delIndex#" onchange="onQuantity('#delIndex#');" >
				<bean:write name="issueBean" property="strDosageValues"
						filter="false" />
		</select></td>
		
	<td width="10%" class="multiControl">
		<select name="strFrequency" 
			id="strFrequency#delIndex#"  onchange="onQuantity('#delIndex#');">
				<bean:write name="issueBean" property="strFrequencyValues"
						filter="false" />
		</select></td>
	
	<td class="multiControl"  width="9%">
			<input type="text" name="strDays" id="strDays#delIndex#" class='txtFldMin' onkeyup="onQuantity('#delIndex#')" onkeypress="return validateData(event,5);" >
	</td>
	
	<td class="multiControl"  width="15%">
	
		<input type="hidden" name="strReqQty" id="strReqQty#delIndex#" class='txtFldMin'  >
		<div id="strQuantity#delIndex#" >0 No.</div>
		<div id="strQuantityText#delIndex#" style="display: none">
			<input type="text" name="strQtyText" autocomplete='off' id="strQtyText#delIndex#" class='txtFldMin'  onkeyup="putQuantity('#delIndex#');"  onkeypress="return validateData(event,5);" > No.
		</div>
	
	</td>
  </tr>
</table>
</div>
</logic:equal> 


<logic:equal value="0" name="issueBean" property="strDoseFrqFlg">
<div id="rowAdded1" style="display:none">
<table class="table" bgcolor='#6097BC'  align="center" cellpadding="1px" cellspacing="1px"  id="td#delIndex#">
<tbody>
 <tr>
    <td>
		<input type="hidden" name="itemParamValue" id="itemParamValue#delIndex#">
		<input type="hidden" name="itemCalcValue" id="itemCalcValue#delIndex#">
		<input type="hidden" name="itemUserValue" id="itemUserValue#delIndex#">

		<div id="itemParaId1#delIndex#">
		</div>
	</td>
	

	<td>
		<div id="itemParaId11#delIndex#"></div>
	</td>
	
	<td>
			<div id="itemParaId4#delIndex#"></div>
	</td>
			
			<td >
			<div id="itemParaId5#delIndex#"></div>
	</td>
	<td>
		
		<input type="hidden" name="strReqQty" id="strReqQty#delIndex#" class='txtFldMin'  >
		<div id="strQuantity#delIndex#" style="display: none">0 No.</div>
		<div id="strQuantityText#delIndex#" style="display: block">
			<input type="text" name="strQtyText" id="strQtyText#delIndex#" class='txtFldMin'  onblur="QtyValidation('#delIndex#');" maxlength="5" onkeypress="return validateData(event,5);"  tabindex="1"> No.
		</div>
	
	</td>
	<td>
		
		<input type="hidden" name="strTotalCost" id="strTotalCost#delIndex#" class='txtFldMin'  >
		<div id="strQuantityText#delIndex#" style="display: block">
			<input type="text" name="strTotalCostText" id="strTotalCostText#delIndex#" class='txtFldMin'  onkeyup="" maxlength="5"    readonly/>
		</div>
	
	</td>
	
	<td >
		<div id="strQuantityText#delIndex#" style="display: block">
			<img style="cursor: pointer;height: 20px" id='strDeleteButtonDivId' tabindex='2' src="../../hisglobal/images/Minus.png" onclick="deleteRow('#delIndex#','1','0');" title="Click here to Delete Item">
		</div>
	
	</td>
  </tr>
  </tbody>
</table>
</div>
</logic:equal>




	<input type="hidden" name="rowIndex1" value="0"> 
	<input type="hidden" name="rowLength1" value="0">


</form>
</body>
</head>
</html>