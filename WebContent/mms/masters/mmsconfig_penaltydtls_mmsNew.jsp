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
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
<!-- <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">

<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script> -->
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

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
	
/* function addLogic(){
			
			
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
		
		
}	 */

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
		var url = "MmsConfigMstBSCNT.cnt?selectedTab="+hmode+"&purchaseType="+document.forms[0].strPurchaseType.value;
		ajaxFunction(url,1);
}

</script>
<style type="text/css">
.legendvs{
    position: absolute;
    right: 100px;
    line-height: 1.2em;
    top: 0.8em;
}
</style>
</head>
<body >
<html:form action="/masters/MmsConfigMstBSCNT" method="post" name="mmsConfigBean" type="mms.masters.controller.fb.MmsConfigMstFB" >
 
 <fieldset form="form1"><br>
<div class="prescriptionTile">
<div class="row rowFlex reFlex" >

<div class="legendvs">
<button  type="button" class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="cancelFunc();">
<i class="fas fa-ban iround"  title="Cancel"></i>
</button>
<button type="button" class=" btn btn-secondary btn-circle" onclick="clearPage('mmsgeneraldtls');" style="background: #b9b9b9; border-color:#b9b9b9;margin-top: 0.25rem !important;">
<img  src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 23px; color: #fff;">
</button>
<button  type="button" id="submitId" onclick=' return validate1();' class="float-right btn btn-outline-success mt-1 btn-circle" tabindex='2' style="background-color: #5cb85c;">					
<i class="fa fa-save iround"  title="Save" ></i>
</button> 							                 
  </div> 
</div>
<div class="row" align="left">
<p class="subHeaders" style="margin-bottom: 0;">
<i class="fas fa-university" style="font-size: 26px;">&nbsp;</i>
Store Setup
<i class="fas fa-angle-double-right"></i>
&nbsp;
Penalty
</p>
</div>	
<hr>
<tag:tabNew tabList="${mmsConfigBean.lhm}" selectedTab="mmspenaltydtls" align="center" width="TABLEWIDTH"></tag:tabNew> 
<div class="row">
<div class="col-sm-4">

	     
        

</div>
<div class="col-sm-4">
<div id="errMsg" class="errMsg"><bean:write name="mmsConfigBean" property="strErrMsg" /></div>
<div id="normalMsg" class=" normalMsg"><bean:write name="mmsConfigBean" property="strNormalMsg" /></div> 
</div>
</div>	
<div class="row">
<div class="col-sm-2">
</div>
<div class="col-sm-3">

<label>
<font color="red">*</font>Penalty in case of Rejected/Breakage
</label>

</div>
<div class="col-sm-2">
<input class="form-control" type="text" name="strPenRejBreak" maxlength="3" onkeypress="return validateData(event,5);" 
 placeholder="%(of the item cost)">
</div>
<div class="col-sm-2">

<label>
<font color="red">*</font>Purchase Type
</label>
</div>
<div class="col-sm-2">
<select name="strPurchaseType" class="form-control" onChange="getPenalityDetail();">
<bean:write name="mmsConfigBean" property="strPurchaseTypeComboVals" filter="false"/>
</select>
</div>
<div class="col-sm-1">
</div>
</div>
<div id="penalityListId" style="display: none">
<div class="row" align="left">
<div class="col-sm-11">
<p class="subHeaders" style="margin-bottom: 0;">
Penalty Details
</div>
<div class="input-group col-sm-1" align="right">
		   <span class="input-group-btn">
             <!-- <button type="button" title="minus" class="float-right btn mt-1 btn-circle cancelbtn" onClick="deleteLogic();" 
              style="" onmouseover="">
                <span class="fa fa-minus iround"></span>
              </button>
              <button type="button" title="plus" class="float-right btn mt-1 btn-circle cancelbtn" 
              onClick="addLogic();" style="color: green;">
                  <span class="fa fa-plus iround"></span>
              </button> --> 
                <button type="button"  class="float-right btn mt-1 btn-circle1 cancelbtn" tabindex='2' style="background-color: #5cb85c;" onclick="deleteLogic();">
               <i class="fas fa-minus iround" title="delete"></i> </button>
              <button type="button"  class="float-right btn btn-outline-success mt-1 btn-circle1" tabindex='2' style="background-color: #5cb85c;" onclick="addLogic();">
               <i class="fas fa-plus iround" title="add"></i> </button>
            
          </span>
      <!--   <img src="../../hisglobal/images/plus.gif" onClick="addLogic();" style="cursor: pointer; "/>
		<img src="../../hisglobal/images/minus.gif"	onClick="deleteLogic();" style="cursor: pointer; " onmouseover=""> -->
          
      </div>
</div>
<table class="table" >  
	  <thead>
		<tr>
		
		
			<th>From Day(s) </th>
			<th>To Day(s )</th>
			<th> Penalty (%) </th>
			<th>
		<!-- <center> <img src="../../hisglobal/images/plus.gif" 
									onClick="addLogic();" style="cursor: pointer; "/><img
			src="../../hisglobal/images/minus.gif"
			onClick="deleteLogic();" style="cursor: pointer; " onmouseover=""></center> -->
		</th>
		</tr>
		
		</thead>
		<tbody id="id1">
		</tbody>
		</table>
</div>
<hr>
<div class="row">
<div class='col-sm-9'>
</div>
<div class='col-sm-3' align="right">
<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>
<label>&nbsp;Mandatory Fields</label>
</div>
</div>
<!-- <div class="row">
<div class="col-sm-2"></div>
<div class="col-sm-2 ">
<label>From Day(s)</label>
</div>
<div class="col-sm-4">
<label>To Day(s)</label>
</div>
<div class="col-sm-4">
<label>Penalty (%)</label>
</div>
</div> -->

	<!-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="2">Store Setup&gt;&gt; Penalty</td>
		</tr>
		
		</table> -->
		<%-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
		<tr>
		<td class="LABEL" width="50%" ><font color="red">*</font>Penalty in case of Rejected/Breakage</td>
		<td class="CONTROL"  width="50%">
		<input class="txtFldSmall" type="text" name="strPenRejBreak" maxlength="3" onkeypress="return validateData(event,5);" value="${mmsConfigBean.strPenRejBreak }">%(of the item cost)</td>
		</tr>
		<tr>
			<td class="LABEL" width="50%"><font color="red">*</font>Purchase Type</td>
			<td class="CONTROL" width="50%">
				<select name="strPurchaseType" class="comboNormal" onChange="getPenalityDetail();"><bean:write name="mmsConfigBean" property="strPurchaseTypeComboVals" filter="false"/></select>
			</td>
		</tr>
	
		</table> --%>
		<!-- <div id="penalityListId" style="display: none">
		
		<table class="table" >  
	  <thead>
		<tr>
			<th>From Day(s) </th>
			<th>To Day(s )</th>
			<th> Penalty (%) </th>
			<th>
		<center> <img src="../../hisglobal/images/plus.gif" 
									onClick="addLogic();" style="cursor: pointer; "/><img
			src="../../hisglobal/images/minus.gif"
			onClick="deleteLogic();" style="cursor: pointer; " onmouseover=""></center>
		</th>
		</tr>
		</thead>
		<tbody id="id1">
		</tbody>
		</table>
		
		
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
		</div> -->
		
		
		<!-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
		<tr class="FOOTER">
			 <td colspan="2"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table> -->
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
					 	<!-- <a href="#" class="button" id=" " onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="clearPage('mmspenaltydtls')"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="clearPage('CANCEL');"><span class="cancel">Cancel</span></a> -->
				</div>
<input 	type="hidden" name="selectedTab">
<input 	type="hidden" name="strIndexVal">

</div>
</fieldset>
</html:form>
<jsp:include page="mmsconfig_multirow_mms.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>
</body>
</html>