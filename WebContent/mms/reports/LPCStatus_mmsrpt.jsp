<%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<!DOCTYPE html>

<html>
<head>
<meta charset=UTF-8">
<title>LPC Status Report</title>

<!-- CSS -->
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css"
	rel="stylesheet">
<link
	href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">

<!-- JS -->
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<!-- <script language="JavaScript" src="../js/LocalPurchaseMRN.js"></script> -->

<!-- EXT JS -->
<!-- <script language="JavaScript" src="../js/DrugWisePatientCount.js"></script> -->


<script>
function printDataOne() {
	var x = document.getElementById("printImg");
	  x.style.display = "none";
		
	newwin = window.open('', 'printwin','left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n');
	newwin.document.write('<script>\n');
	newwin.document.write('function chkstate(){ \n');
	newwin.document.write('window.close();\n');
	newwin.document.write('}\n');
	newwin.document.write('function print_win(){\n');
	newwin.document.write('window.print();\n');
	newwin.document.write('chkstate();\n');
	newwin.document.write('}\n');

	newwin.document.write('<\/script>\n');
	newwin.document.write('</HEAD>\n');
	newwin.document.write('<BODY onload="print_win()">\n');
	newwin.document.write(document.getElementById('AckReport').innerHTML);
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();
  	var x = document.getElementById("printImg");
  	x.style.display = "block";
}
function cancelPage(){
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();

}
function onClearPage()
{
	document.forms[0].reset();
	var objVal = document.getElementById("AckReport");
	objVal.style.display = "none";
	document.getElementsByName("strCategoryId")[0].disabled = false;
	var x = document.getElementById("myDIV");
	var y = document.getElementById("myDIV1");
	x.style.display = "block";
	y.style.display = "block";
}

function getInventoryDtls() 
{
	 
   	    var hisValidator = new HISValidator("LPCStatusRptbean");
		 
		hisValidator.addValidation("strCate", "dontselect=0", "Please Select Store Name" );
		if(document.forms[0].strCategoryId[document.forms[0].strCategoryId.selectedIndex].value==0){
			alert("Please select category");
			return false;
		}
		var retVal = hisValidator.validate();
		
		if (retVal) {
			
			//document.forms[0].strStoreName.value = document.forms[0].strStoreId[document.forms[0].strStoreId.selectedIndex].text;
			document.forms[0].strCategoryName.value = document.forms[0].strCategoryId[document.forms[0].strCategoryId.selectedIndex].text;
			
			var hmode = "GOVIEWPAGE"; 
			var url = "LPCStatusRptCNT.cnt?hmode="+hmode+	
			"&strCategoryId="+document.forms[0].strCategoryId[document.forms[0].strCategoryId.selectedIndex].value+
			"&strCategoryName="+document.forms[0].strCategoryName.value;
			
			//alert(url);		
			
			ajaxFunction(url,"1");
		
	  	} else {
			return false;
		} 
  }
  
function getAjaxResponse(res,mode)
{
	var objVal;
	if (mode == "1") {
		objVal = document.getElementById("AckReport");
		objVal.style.display = "block";
		var x = document.getElementById("myDIV");
		var y = document.getElementById("myDIV1");
		x.style.display = "none";
		y.style.display = "none";
		//document.getElementById("viewCancelButtonDivId1").style.display = "block";
		objVal.innerHTML = res;
		document.getElementById("strCategoryId").disabled = true;
	}
}

</script>


<style type="text/css">
body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 14px;
	line-height: 1.42857143;
	color: rgba(0, 0, 0, 1);
	font-weight: 501;
}

.container {
	max-width: 1395px;
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

p {
	margin-top: 0;
	margin-bottom: 0rem;
}
</style>


</head>
<body>
	<html:form action="/reports/LPCStatusRptCNT"
		name="LPCStatusRptbean"
		type="mms.reports.controller.fb.LPCStatusRptFB" method="post">

		<div id="errMsg" class="errMsg">
			<bean:write name="LPCStatusRptbean" property="strErrMsg" />
		</div>
		<div id="warningMsg" class="warningMsg">
			<bean:write name="LPCStatusRptbean" property="strWarningMsg" />
		</div>
		<div id="normalMsg" class="normalMsg">
			<bean:write name="LPCStatusRptbean" property="strNormalMsg" />
		</div>
		<br>
		<br>
		<div class="container-fluid">
			<div class="">
				<div class="prescriptionTile col-sm-12" align="center">
					<div class="row ">
						<div class="col-sm-6" style="text-align: initial;">
							<p class="subHeaders">

								<i class="fas fa-file-alt iround"
									style="font-size: 20px; color: #28a745" title="Cancel"></i>
								&nbsp; LPC Status Report 
							</p>
						</div>

						<div class="col-sm-6" id="viewCancelButtonDivId1">
							<div class="legend2" id='nonPrintableLegend2'>
								<button type="button"
									class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn"
									onclick="cancelFunc();">
									<i class="fas fa-times fa-lg iround" title="Cancel"></i>
								</button>
								
								<button type="button" class=" btn btn-secondary btn-circle"
									style="background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;"
									onclick="onClearPage();">
									<i class="fas fa-broom fa-lg iround" title="Clear"></i>
								</button>
								<!-- 
								<button type="button" id="saveid"
									class="float-right btn btn-outline-success mt-1 btn-circle savebtn"
									tabindex='2' onclick='return getInventoryDtls();'>
									<i class="fa fa-download fa-beat iround" title="Search"></i>
								</button>
								 -->
							</div>
						</div>
					</div>
					<div class="container">
						<div class="row">
							<div class="col-sm-2"></div>
							<div class="col-sm-3 float-right">
								<label class="float-right"><font color="red">*</font>Category</label>
							</div>
							<div class="col-sm-3">
									<select name="strCategoryId"  id="strCategoryId" class="browser-default custom-select">
										<option value="0">Select</option>
										<option value="10">Drug</option>
										<option value="11">Other Then Drug</option>
									</select>
							</div>
							<div class="col-sm-3">
								<button type="button" id="saveid"
									class="float-center btn btn-outline-success float-left"
									tabindex='2' onclick='return getInventoryDtls();'>
									<font color="white">GO</font>
								</button>
							</div>
							
						</div>
						
						

					</div>
					<hr id='hr4' style="display: none;">
					<hr>
					<div class="col-sm-12" id="myDIV">
						<label><font color="red">We keep a record here for
								LPC Status.</font></label>
					</div>

					<div align="center" id="AckReport"></div>


					<hr id='hr4' style="display: none;">
					<hr>
					<div class="col-sm-12" align="right" id="myDIV1">
						<i class="fas fa-asterisk"
							style="color: red; font-size: smaller; margin-top: 5px;"></i>Fields
						Mandatory
					</div>


					<input type="hidden" name="hmode" /> 
					<!-- <input type="hidden" name="strStoreName" value="" />
					<input type="hidden" name="strSupplierName" value="" /> 
					<input type="hidden" name="strItemCategoryName" value="" /> 
					<input type="hidden" name="strItemCategoryCode" value="" /> 
					<input type="hidden" name="strInstituteName" value="" /> 
					<input type="hidden" name="strStatus" value="" /> 
					<input type="hidden" name="strHtmlCode" value="">  -->
					<input type="hidden" name="strCategoryName" value="" />
					<input type="hidden" name="strCurrentDate" value="${LPCStatusRptbean.strCurrentDate}" />


				</div>
			</div>
		</div>
	</html:form>
	<script type="text/javascript">
	
	$('.datepicker').each(function()
	{
	    $(this).datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
	});
	var today=new Date();
	var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
	var mmm=arr[today.getMonth()];
	var hrs=today.getHours();
	var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
	$('.datepicker').val(dd);
	
</script>
	<tag:autoIndex></tag:autoIndex>
</body>
</html>
