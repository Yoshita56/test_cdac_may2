<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
    
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
    
<!DOCTYPE html>

<html>
<head>
<meta charset=UTF-8">
<title>Local Purchase Report</title>

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<style type="text/css">
body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 14px;
	line-height: 1.42857143;
	color: rgba(75, 75, 75, 0.7);
	font-weight: 501;
}

.table th, .table td {
	padding: 0.05rem;
}

.form-control {
	color: rgba(75, 75, 75, 0.7);
}

.table {
	width: 100%;
	margin-bottom: 1rem;
	color: rgba(75, 75, 75, 0.7);
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
	color: rgba(75, 75, 75, 0.7);
}

.subHeaders {
	font-weight: 500 !important;
	font-family: "Helvetica Neue", "Helvetica";
	font-size: 19px !important;
	padding-bottom: 0px !important;
	color: rgba(75, 75, 75, 0.7);
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

function validate()
{

	//alert("1");

		var hisValidator = new HISValidator("localPurchaseRptBean");

		//hisValidator.addValidation("strHospitalCode", "dontselect=0","Please Select Hospital Name");
		hisValidator.addValidation("strSupplierId", "dontselect=-1","Supplier Name is a mandatory field");
		hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
	     var retVal = hisValidator.validate();
	     var dd= dateDiff(document.forms[0].strFromDate.value ,document.forms[0].strToDate.value);
// alert(dd);
         var dd2 = dd.split(' ')[0];
	     if( dd2> 180)
		     {
		     alert("Date difference couldn't be more than 180 Days");
		    retVal= false;
		     }
	
	hisValidator.clearAllValidations();
	
	
	if(retVal)
	{
		document.forms[0].strSupplierName.value = document.forms[0].strSupplierId[document.forms[0].strSupplierId.selectedIndex].text;
		
		document.forms[0].hmode.value = "SHOWRPT";
		
		
		document.forms[0].submit();
		
		
	}
}

function onLoadPage()
{
	
}

function onClearPage()
{
	document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value ;
	document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value ;
}

function cancelPage()
{
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();
}

</script>
</head>

<body class="background" onload="onLoadPage();">
<div id="mask"></div>
<div id="dvLoading"></div>
<html:form action="/reports/LPReportsTransCNT" method="post" styleClass="formbg">
	<div class="errMsg" id="errMsg">
	
	<bean:write name="localPurchaseRptBean"
		property="strErrMsg" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="localPurchaseRptBean" property="strNormalMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="localPurchaseRptBean" property="strWarningMsg" /></div>
	
	<br>
		<div class="container" style="max-width: 1290px">
			<div class="row">
				<div class="prescriptionTile col-sm-12" align="center">
					<div class="row rowFlex reFlex">
						
						<div class="col-sm-6" style="text-align: initial;">
							<p class="subHeaders">
								<i class="fas fa-file-alt iround" style="font-size: 20px; color: #28a745" title="Cancel"></i>
								&nbsp; Local Purchase Order Report
							</p>
						</div>
						
						<div class="col-sm-6">
							<div class="legend2" id='nonPrintableLegend2'>
								<button type="button"
									class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn"
									onclick="window.parent.closeTab();">
									<i class="fas fa-ban iround" title="Cancel"></i>
								</button>
								
								<button type="button" class=" btn btn-secondary btn-circle"
									onclick="onClickClear();"
									style="background: #b9b9b9; border-color: #b9b9b9; margin-top: 0.25rem !important;">
									<img src="/HIS/hisglobal/images/clear3.png" title="Clear"
										style="width: 23px; color: #fff;">
								</button>

								<button type="button" id="saveid"
									class="float-right btn btn-outline-success mt-1 btn-circle savebtn"
									tabindex='2' onclick='return validate();'>
									<i class="fas fa-download iround" title="Save"></i>
								</button>
						   </div>
						</div>
					</div>

					<div class="row">
						<div class="col-sm-3">
							<label><font color="red">*</font>Supplier Name</label>
						</div>
						<div class="col-sm-3">
							
								<select name="strSupplierId" class="browser-default custom-select">
										<bean:write name="localPurchaseRptBean" property="strSupplierCmb" filter="false" />
								</select>
							
						</div>
						<div class="col-sm-3" >
							<label><font color="red">*</font>Po Status</label>
						</div>
						<div class="col-sm-3" align="left" >
							<select name="strPoStatus" class="browser-default custom-select">
								<option value="1">Active</option>					
							</select>
						</div>
					</div>
															
					<div class="row">
						<div class="col-sm-3">
							<label><font color="red">*</font>From Date </label>
						</div>
						<div class="col-sm-3">
														
							<input name="strFromDate" class="form-control datepicker" value="${localPurchaseRptBean.strCurrentDate}" />
							
						</div>
						<div class="col-sm-3" >
							<label><font color="red">*</font>To Date</label>
						</div>
						<div class="col-sm-3" align="left" >							
							<input name="strToDate" class="form-control datepicker" value="${localPurchaseRptBean.strCurrentDate}" />
						</div>
					</div>
					
					<hr>
					
					<div class="row">
						<div class="col-sm-12" align="right" >
							<font color='red'>*</font>Fields Mandatory 
						</div>
					</div>
	
					<input type="hidden" name="hmode"/>
					<input type="hidden" name="strCurrentDate" value="${localPurchaseRptBean.strCurrentDate}"/>
					<input type="hidden" name="strSupplierName" value="${localPurchaseRptBean.strSupplierName}" />
					
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