<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Miscellaneous Consumption Report</title>

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css"
	rel="stylesheet">
<link href=".../../css/newlayout.css" rel="stylesheet" type="text/css">
<link
	href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css"
	rel="stylesheet" type="text/css">

<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<style type="text/css">
body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 14px;
	line-height: 1.42857143;
	/* color: rgba(75, 75, 75, 0.7); */
	color: rgba(0, 0, 0, 1);
	font-weight: 501;
}

.table th, .table td {
	padding: 0.05rem;
}

.form-control {
	color: rgba(0, 0, 0, 1);
}

.table {
	width: 100%;
	margin-bottom: 1rem;
	color: rgba(0, 0, 0, 1);
}

.prescriptionTile {
	margin: 0.5% 0;
	border-bottom: 1px solid #d7d7d7;
	padding-bottom: 10px;
	padding: 1% 2% 0.5% 2%;
	background-color: #fff;
	transition: 0.5s;
	box-shadow: 0 0.5px 10px 2px #b0acac;
	border-radius: .25rem;
	color: rgba(0, 0, 0, 1);
}

.subHeaders {
	font-weight: 500 !important;
	font-family: "Helvetica Neue", "Helvetica";
	font-size: 19px !important;
	padding-bottom: 0px !important;
	color: rgba(0, 0, 0, 1);
}

.row {
	padding-bottom: 5px;
}

.legend2 {
	position: absolute;
	top: -2.5em;
	right: 44px;
	line-height: 1.2em;
}

.cancelbtn {
	padding: .175rem .35rem;
	line-height: 0.8;
	background-color: #d9534f;
}

.btn-circle {
	width: 37px;
	height: 34px;
	text-align: center;
	padding: 6px 0;
	font-size: 12px;
	line-height: 1.428571429;
	border-radius: 17px;
	color: white;
	float: right;
}

.iround {
	color: white;
	font-size: 16px;
}

.btn-outline-success {
	color: #28a745;
	border-color: #28a745;
	background-color: #28a745;
}
</style>
<script type="text/javascript">

function getAjaxResponse(res,mode){
	
	if(mode=="1"){ 
		var objVal= document.getElementById("itemCatDivId");
		objVal.innerHTML = "<select name ='strItemCatNo' class='custom-select' onChange=' ' >"+res+"</select>";		
	}	

	if(mode=="2"){ 
		var objVal= document.getElementById("reqDivId");
		objVal.innerHTML = "<select name ='strReqTypeId' class='custom-select'>"+res+"</select>";		
	}
// R47J 
	if(mode=="3"){ 
		var objVal= document.getElementById("MiscRpt");
		objVal.style.display = "block";
		//alert(res);
		objVal.innerHTML = res;
		
	}
	if(mode=="4"){	
       	  var objVal= document.getElementById("groupId");
		  objVal.innerHTML = "<select name ='strGroupId' class='custom-select'>" + res + "</select>";
    }
}
function groupNameCombo(){
   var mode ="GROUPNAME";  
   var url="MiscItemListingRptCNT_NEW.cnt?hmode=GROUPNAME&strCategoryId="+document.forms[0].strItemCatId.value;
   ajaxFunction(url,"4");
}

//R47J 
 function validate(){
		var hisValidator = new HISValidator("MiscItemListingRPT");

	    hisValidator.addValidation("strStoreId", "dontselect=-1","Select Store From Store Combo");
		hisValidator.addValidation("strItemCatId", "dontselect=-1","Select Item Category From Item Category Combo");
		var retVal = hisValidator.validate();
		// alert(document.forms[0].strIsMisc.checked);
		hisValidator.clearAllValidations();
		
		if(retVal){
			
			var hmode = "SHOWRPT"; 
			var url = "MiscItemListingCNT_NEW.cnt?hmode="+hmode+
			
			"&strStoreId="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].value+
			"&storeName="+document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text+
			
			"&strCategoryId="+document.forms[0].strItemCatId[document.forms[0].strItemCatId.selectedIndex].value+
			"&strCategoryName="+document.forms[0].strItemCatId[document.forms[0].strItemCatId.selectedIndex].text+
			"&strGroupId="+document.forms[0].strGroupId[document.forms[0].strGroupId.selectedIndex].value+

			"&strFromDate="+document.forms[0].strFromDate.value+
			"&strToDate="+document.forms[0].strToDate.value+
			
			"&strReportFormat="+document.forms[0].strReportFormat.text;
			
			ajaxFunction(url,"3");
	  	} else {
			return false;
		} 
 } 

function getReqTypeCmb(){ 
	if(document.forms[0].strStoreId.value!=0 && document.forms[0].strItemCatNo.value!=0 ){
		var url ="ItemListingRPTCNT_NEW.cnt?hmode=REQTYPECMB&storeId="+document.forms[0].strStoreId.value+"&catId="+document.forms[0].strItemCatNo.value;
 		ajaxFunction(url,"2");
 	}else{
	document.forms[0].strItemCatNo.value="0";
}
}

	
function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}

function onLoadpage(){
	
	document.forms[0].strItemCatId.value = "0";
	document.forms[0].strStoreId.value = "0";
	document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value;
    document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value;

}
//R47J 
function printDataOne(mode) 
{
	
	var x = document.getElementById("printImg");
	x.style.display = "none";
	
	newwin = window.open('', 'printwin',
			'left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n')
	newwin.document.write('<script>\n');
	newwin.document.write('function chkstate(){ \n');
	// newwin.document.write('if(document.readystate=="complete" ||
	// document.readystate=="undefined"){\n');
	newwin.document.write('window.close();\n');
	// newwin.document.write('}\n');
	// newwin.document.write('else{\n');
	// newwin.document.write('setTimeout("chkstate()",2000)\n');
	// newwin.document.write('}\n');
	newwin.document.write('}\n');
	newwin.document.write('function print_win(){\n');
	newwin.document.write('window.print();\n');
	newwin.document.write('chkstate();\n');
	newwin.document.write('}\n');

	newwin.document.write('<\/script>\n');
	newwin.document.write('</HEAD>\n');
	newwin.document.write('<BODY onload="print_win()">\n');
	if(mode=='1')
	{
	  newwin.document.write(document.getElementById('MiscRpt').innerHTML);	  
	}
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();
	 //document.getElementById("strCrNo").focus();

}
function getItemCatCmb(){ 

	if(document.forms[0].strStoreId.value!=0){
		var url ="MiscItemListingCNT_NEW.cnt?hmode=ITEMCATCMB&storeId="+document.forms[0].strStoreId.value;
 		ajaxFunction(url,"1");
 	}else{
	document.forms[0].strItemCatNo.value="0";
	 	/* objVal= document.getElementById("itemCatDivId");
		objVal.innerHTML = "<select name ='strItemCatId' id='strItemCatId' class='custom-select'><option value='0'>Select Value</option></select>"; */
}
}
function groupNameCombo()
{
   var mode ="GROUPNAME";  
   var url="MiscItemListingCNT_NEW.cnt?hmode=GROUPNAME&strCategoryId="+document.forms[0].strItemCatId.value;
   ajaxFunction(url,"4");
} 
</script>

</head>
<body onload="onLoadpage();">
	<html:form action="/reports/MiscItemListingCNT_NEW" method="post">

		<div class="errMsg" id="errMsg">
			<bean:write name="MiscItemListingRPT" property="strErrMsg" />
		</div>
		<div class="normalMsg" id="normalMsg">
			<bean:write name="MiscItemListingRPT" property="strNormalMsg" />
		</div>
		<div class="warningMsg" id="warningMsg">
			<bean:write name="MiscItemListingRPT" property="strWarningMsg" />
		</div>

		<!--<tag:tab tabLabel="Issue To Patient Report" selectedTab="FIRST" align="center" width="TABLEWIDTH"> </tag:tab>-->
		<br>
		<div class="container-fluid">
			<div class="prescriptionTile">
				<div class="row rowFlex reFlex">
					<div class="col-sm-6" style="text-align: initial;">
						<p class="subHeaders">

							<i class="fas fa-file-alt iround"
								style="font-size: 20px; color: #28a745" title="Cancel"></i>
							&nbsp; Miscellaneous Consumption Report
						</p>
					</div>

					<div class="col-sm-6">
						<div class="legend2" id='nonPrintableLegend2'>
							<button type="button"
								class="float-right btn btn-danger mt-1 btn-circle cancelbtn"
								onclick="cancelFunc();">
								<i class="fas fa-times iround" title="Cancel"></i>
							</button>
							<button type="button" class=" btn btn-secondary btn-circle"
								onclick="document.forms[0].reset();"
								style="background: royalblue; border-color: #b9b9b9; margin-top: 0.25rem !important;">
								<i class="fas fa-broom iround" title="Clear"></i>
							</button>

							<button type="button" id="saveid"
								class="float-right btn btn-success mt-1 btn-circle savebtn"
								tabindex='2' onclick='return validate();'>
								<i class="fas fa-download iround" title="Save"></i>
							</button>
						</div>
					</div>
				</div>

				<div class="container">
					<div class="row mx-5">
						<div class="col-sm-3">
							<label><font color="red">*</font>Store Name</label>
						</div>
						<div class="col-sm-3">
							<div id="storeDivId">
								<select name="strStoreId" class="browser-default custom-select" onchange="">
									<bean:write name="MiscItemListingRPT" property="strStoreCmb"
										filter="false" />
								</select>
							</div>
						</div>
						<div class="col-sm-3">
							<label><font color="red">*</font>Category</label>
						</div>
						<div class="col-sm-3">
							<div id="itemCatDivId">
								<select name="strItemCatId"
									class="browser-default custom-select"
									onchange="groupNameCombo();">
									<bean:write name="MiscItemListingRPT"
										property="strItemCategCmb" filter="false" />
								</select>
							</div>
						</div>
					</div>

					<div class="row mx-5">
						<div class="col-sm-3">
							<label>Group Name<font color="red">*</font></label>
						</div>
						<div class="col-sm-3" id="groupId">
							<select name="strGroupId" class='browser-default custom-select'>
								<option value="0">All</option>
							</select>
						</div>
						<div class="col-sm-6"></div>
					</div>

					<div class="row mx-5">
						<div class="col-sm-3">
							<label><font color="red">*</font>From Date</label>
						</div>
						<div class="col-sm-3">
							<input class="form-control " name="strFromDate" id='datepicker1'>
						</div>
						<div class="col-sm-3">
							<label><font color="red">*</font>To Date</label>
						</div>
						<div class="col-sm-3">
							<input class="form-control " name="strToDate" id='datepicker2'>
						</div>
					</div>

					<div class="row mx-5">
						<div class="col-sm-3">
							<label>Report Format</label>
						</div>
						<div class="col-sm-3">
							<select name="strReportFormat" onchange=""
								class="browser-default custom-select">
								<option value="html">Html</option>
								<option value="pdf">Pdf</option>
								<option value="xls">Excel</option>
							</select>
						</div>
						<div class="col-sm-3">
							<label>User Remarks</label>
						</div>
						<div class="col-sm-3">
							<input class="form-control" type="text" name="strUserRemarks">
						</div>
					</div>
				</div>

				<table class="TABLEWIDTH" align="center" cellspacing="1px"
					cellpadding="1px">
					<tr style="display: none;">
						<td width="50%" colspan="2" class="LABEL">Footer Required</td>
						<td width="50%" colspan="2" class="CONTROL"><html:checkbox
								property="strIsFooter" name="MiscItemListingRPT" value="1"></html:checkbox>
						</td>
					</tr>
				</table>
				<hr>
				<div class="row">
					<div class="col-sm-12" align="right">
						<font color='red'>*</font>Fields Mandatory
					</div>
				</div>

				<input type="hidden" name="hmode" /> <input type="hidden"
					name="strCurrentDate" value="${MiscItemListingRPT.strCurrentDate}" />

				<!-- R47J -->
				<div align="center" id="MiscRpt"></div>
			</div>
		</div>

	</html:form>
	<tag:autoIndex></tag:autoIndex>

	<script type="text/javascript">
	$('#datepicker1').datepicker({uiLibrary: 'bootstrap4',modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
	$('#datepicker2').datepicker({uiLibrary: 'bootstrap4',modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
	var today=new Date();
	var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
	var mmm=arr[today.getMonth()];
	var hrs=today.getHours();
	var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
	$('#datepicker1').val(dd);
	$('#datepicker2').val(dd);
	</script>
</body>
</html>