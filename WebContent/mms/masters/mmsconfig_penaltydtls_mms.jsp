<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>

<html>
<head>
<meta charset="utf-8">
<title>Store Setup</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<script type="text/javascript">

	
	function validate1(){	
	
		retVal = false;
		var hisValidator = new HISValidator("mmsConfigBean");
		hisValidator.addValidation("strPenRejBreak","req","Penalty in case of Rejected/Breakage is a Mandatory Field");
		if(document.getElementsByName("strPenRejBreak")[0].value>100){
			alert("Penalty in case of Rejected/Breakage cannot be greater than 100");
			document.getElementsByName("strPenRejBreak")[0].value="";
			document.getElementsByName("strPenRejBreak")[0].focus();
			return false;
		}
		hisValidator.addValidation("strToDays", "req","To Days is a Mandatory Field");
		hisValidator.addValidation("strToDays", "numltet=366","To Days should be lesser than or equal to 366 Days");
		hisValidator.addValidation("strPenalty", "req","Penalty is a Mandatory Field");
		hisValidator.addValidation("strPenalty", "amount=5,2","Penalty should be in Valid Format 00.00 or 000");
		hisValidator.addValidation("strPenalty", "numltet=100","Penalty should be lesser than or equal to 100%");

		retVal = hisValidator.validate(); 
		hisValidator.clearAllValidations();
		if(retVal){

		var toDaysObj = document.getElementsByName("strToDays");
		var penaltyObj = document.getElementsByName("strPenalty");
		
				for(var i = 0; i< toDaysObj.length - 1 ; i++ ){
					
						toDaysObj[i].disabled = false;
						penaltyObj[i].disabled = false;
					
				}
			
		

			document.forms[0].selectedTab.value = "SAVEPENALTYDTLS";
			document.forms[0].submit();

		}else{
		
		return false;
		}
		
	}

function addLogic(){
			
			
			if(document.multirow.rowIndex1.value == 0){
			
				addRows(new Array('strFromDays','strToDays','strPenalty'), new Array('t','t','t'), '1', '1', 'R');
				
				var newFromDays = document.getElementById("strFromDays1-"+document.multirow.rowIndex1.value)
			
				newFromDays.value = 1;
				
				document.getElementById("strFromDaysDivId1-"+document.multirow.rowIndex1.value).innerHTML = "1";
				
				return false;
			
			}
			
			var fromDaysObj = document.getElementsByName("strFromDays");
	
			var toDaysObj = document.getElementsByName("strToDays");
			
			var penaltyObj = document.getElementsByName("strPenalty");

			var fromDays = fromDaysObj[fromDaysObj.length - 2];
			var toDays = toDaysObj[toDaysObj.length - 2];
			
			var penalty = penaltyObj[penaltyObj.length - 2];
		
			if(toDays.value.length == 0 ){
				
					alert("To Days Value is a Mandatory Field");
					toDays.focus();
					return false;		
			}
			if(parseInt(toDays.value) == 0 || parseInt(toDays.value) > 366 ){
			
				alert("To Days should be Greater than 0 and Less than 366 Days ");
					toDays.focus();
					return false;	
			
			}
			
			if(parseInt(fromDays.value) > parseInt(toDays.value)){
				
				alert("To Days should be Greater than From Days ");
					toDays.focus();
					return false;	
			}

			if(penalty.value.length == 0 ){
				
					alert("Penalty is a Mandatory Field");
					penalty.focus();
					return false;		
			}
		
		toDays.disabled = true;
		penalty.disabled = true;
		
		
		addRows(new Array('strFromDays','strToDays','strPenalty'), new Array('t','t','t'), '1', '1', 'R');
	
						
		var newFromDays = document.getElementById("strFromDays1-"+document.multirow.rowIndex1.value)
		
		newFromDays.value = parseInt(toDays.value) + 1;
		
		document.getElementById("strFromDaysDivId1-"+document.multirow.rowIndex1.value).innerHTML = parseInt(toDays.value) + 1;
		
		
}	

function deleteLogic(){

	deleteLastRow('1','1');
	
	var toDaysObj = document.getElementsByName("strToDays");
	var penaltyObj = document.getElementsByName("strPenalty");
	
	
	var toDays = toDaysObj[toDaysObj.length - 2];
	var penalty = penaltyObj[penaltyObj.length - 2];
		
	toDays.disabled = false;
	penalty.disabled = false;
	
}

 function getAjaxResponse(res, mode) {


	var err = document.getElementById("errMsg");
	var temp = res.split("####");
	if(temp[0] == "ERROR")
	{
		err.innerHTML = temp[1];
		return;
	}
	var objVal;
	if (mode == "1") {
		var temp=res.split("^");
		objVal = document.getElementById("id1");
		objVal.innerHTML =temp[0];
		document.getElementById("penalityListId").style.display="block";
		document.getElementsByName("strIndexVal")[0].value=temp[1];
		
		setMultiRowIndex();
	}
}
	  
	function setMultiRowIndex(){
	
		var multiRowIndex = document.getElementsByName("strIndexVal")[0].value;
		document.multirow.rowIndex1.value = multiRowIndex;
		document.multirow.rowLength1.value = multiRowIndex;
		
	}
	
	
function clearPage(mode){

	document.forms[0].selectedTab.value = mode ;
	document.forms[0].submit();
}
function getPenalityDetail(){

		var hmode="PENELTYDTL";
		var url = "MmsConfigMstCNT.cnt?selectedTab="+hmode+"&purchaseType="+document.forms[0].strPurchaseType.value;
		ajaxFunction(url,1);
}

</script>

</head>
<body >
<html:form action="/masters/MmsConfigMstCNT" method="post" name="mmsConfigBean" type="mms.masters.controller.fb.MmsConfigMstFB" >
	
<center>
	<div id="errMsg" class="errMsg"><bean:write name="mmsConfigBean" property="strErrMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="mmsConfigBean" property="strNormalMsg" /></div>
	
	              
              <tag:tab tabList="${mmsConfigBean.lhm}" selectedTab="mmspenaltydtls" align="center" width="TABLEWIDTH"></tag:tab>
              
</center>
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="2">Store Setup&gt;&gt; Penalty</td>
		</tr>
		
		</table>
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
		<tr>
		<td class="LABEL" width="50%" ><font color="red">*</font>Penalty in case of Rejected/Breakage</td>
		<td class="CONTROL"  width="50%"><input class="txtFldSmall" type="text" name="strPenRejBreak" maxlength="3" onkeypress="return validateData(event,5);" value="${mmsConfigBean.strPenRejBreak }">%(of the item cost)</td>
		</tr>
		<tr>
			<td class="LABEL" width="50%"><font color="red">*</font>Purchase Type</td>
			<td class="CONTROL" width="50%">
				<select name="strPurchaseType" class="comboNormal" onChange="getPenalityDetail();"><bean:write name="mmsConfigBean" property="strPurchaseTypeComboVals" filter="false"/></select>
			</td>
		</tr>
	
		</table>
		<div id="penalityListId" style="display: none">
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">  
		<tr class="TITLE">
		<td width="95%" colspan="2">Penalty Details
		</td>
		<td class="TITLE" width="5%">
		<center> <img src="../../hisglobal/images/plus.gif" 
									onClick="addLogic();" style="cursor: pointer; "/><img
			src="../../hisglobal/images/minus.gif"
			onClick="deleteLogic();" style="cursor: pointer; " onmouseover=""></center>
		</td>
		</tr>
			<tr>
			<td class="multiLabel" width="30%">From Day(s)
			</td>
			<td class="multiLabel" width="30%">To Day(s)
			</td>
			<td class="multiLabel" width="30%"> Penalty (%)
			</td>
		</tr>
		</table>
		</div>
		<div id="id1"></div>
		
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table>
<!-- 	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" />
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" onClick="clearPage('mmspenaltydtls')" >
			<img  style="cursor: pointer; " src="../../hisglobal/images/btn-ccl.png" onClick="clearPage('CANCEL');" >
			</td>
		</tr>
	</table>-->
	<br>
	<div align="center" id=" ">					 
					 	<a href="#" class="button" id=" " onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="clearPage('mmspenaltydtls')"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="clearPage('CANCEL');"><span class="cancel">Cancel</span></a>
				</div>
<input 	type="hidden" name="selectedTab">
<input 	type="hidden" name="strIndexVal">

</html:form>

<jsp:include page="mmsconfig_multirow_mms.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>
</body>
</html>