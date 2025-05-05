<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>PO Register</title>

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css"
	rel="stylesheet">
<link href=".../../css/newlayout.css" rel="stylesheet" type="text/css">
<link
	href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css"
	rel="stylesheet" type="text/css">

<script type="text/javascript"
	src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
	
	
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
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

		var hisValidator = new HISValidator("purchaseOrderDtlRpt");

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
	     if( dd2> 90)
		     {
		     alert("Date difference couldn't be more than 90 days");
		    retVal= false;
		     }
	
	hisValidator.clearAllValidations();
	
	
	if(retVal)
	{
		document.forms[0].hmode.value = "SHOWRPT";
		
		if(document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html")
		{
			document.forms[0].target = "_self";
		}
		else
		{
			document.forms[0].target = "_blank";
		}
			document.forms[0].submit();
		}
		else
		{
			return false;
		}
	}

	function onLoadPage()
	{
		document.getElementsByName("strWhetherItemShown")[0].checked = true;
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
<body onload="onLoadPage();">
<html:form action="/reports/PurchaseOrderDtlRptCNT" method="post">
	
<div class="errMsg" id="errMsg"><bean:write name="purchaseOrderDtlRpt" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="purchaseOrderDtlRpt" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="purchaseOrderDtlRpt" property="strWarningMsg"/></div>




<br>
		<div class="container">
			<div class="row">
				<div class="prescriptionTile col-sm-12" align="center">


					<div class="row rowFlex reFlex">
						<div class="col-sm-6" style="text-align: initial;">
							<p class="subHeaders">

								<i class="fas fa-file-alt iround"
									style="font-size: 20px; color: #28a745" title="Cancel"></i>
								&nbsp; Purchase Order Detail
							</p>
							<!-- <button  type="button" class="btn btn-outline-success mt-1  savebtn" onclick="cancelFunc();">
		                                        <i class="fas fa-file-alt iround"  title="Cancel"></i>
	                                      </button> -->
						</div>
						
						<div class="col-sm-6">
							<div class="legend2" id='nonPrintableLegend2'>
								<button type="button"
									class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn"
									onclick="cancelFunc();">
									<i class="fas fa-ban iround" title="Cancel"></i>
								</button>
								<button type="button" class=" btn btn-secondary btn-circle"
									onclick="onClearPage();"
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
							<label><font color="red">*</font>Supplier Combo</label>
						</div>
						<div class="col-sm-3">
							<select name="strSupplierId"
								class="browser-default custom-select">
								<bean:write name="purchaseOrderDtlRpt" property="strSupplierCmb"
									filter="false" />
							</select>
						</div>
						<div class="col-sm-5" align="right">
							<label><font color="red">*</font>Whether Item has to show</label>
						</div>
						<div class="col-sm-1" align="left" >
											<input type="checkbox" name="strWhetherItemShown" value="1" />
						</div>
					</div>

                 <div class="row">
						<div class="col-sm-3">
							<label><font color="red">*</font>From Date</label>
						</div>
						<div class="col-sm-3">
							<input class="form-control" name="strFromDate" id='datepicker'>
						</div>
						<div class="col-sm-3">
							<label><font color="red">*</font>To Date</label>
						</div>
						<div class="col-sm-3">
							<input class="form-control" name="strToDate" id='datepicker1'>
						</div>
					</div>
                  
                    <div class="row">
						<div class="col-sm-3">
							<label>PO Status</label>
						</div>
						<div class="col-sm-3">
							<select name="strPoStatus" class="browser-default custom-select">
								<option value="1">Active</option>
								<option value="2">Corrigendum</option>
								<option value="3">Cancelled/Rejected</option>
							</select>
						</div>
						<div class="col-sm-3">
							<label>PO Type</label>
						</div>
						<div class="col-sm-3">
							<input type="radio" name = "strPOType" value = "1" checked/>Bulk PO
							<input type="radio" name = "strPOType" value = "2" />Local PO
						</div>
					</div>
					
					
                  <div class="row">
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
					
					
	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
		
		
		
		<tr style="display:none;">
			<td width="50%" class="LABEL" colspan="2"><font color="red">*</font>Hospital name</td>
			<td width="50%" class="CONTROL" colspan="2">
			<select name="strHospitalCode" class="comboNormal">
			<bean:write name="purchaseOrderDtlRpt" property="strHospNameValues" filter="false"/>
			</select>
			</td>			
		</tr>	
		<tr style="display: none;">
			<td width="50%" colspan="2" class="LABEL">Footer Required</td>
			<td width="50%" colspan="2" class="CONTROL">
				<html:checkbox property="strIsFooter" name="purchaseOrderDtlRpt" value="1"></html:checkbox>
			</td>
		</tr>
	
	</table>
	<hr>
					<div class="row">
						<div class="col-sm-12" align="right" >
							<font color='red'>*</font>Mandatory Field
						</div>
					</div>
	<!-- <table border="0" class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>

			<td align="center">
			<img style="cursor: pointer" src="../../hisglobal/images/btn-generate.png" onClick="return validate();" />
			<img style="cursor: pointer" src="../../hisglobal/images/btn-clr.png" onClick="onClearPage();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" onClick="cancelFunc();" >
			</td>
			
		</tr>
	</table>-->
	<!-- <br>
<div align="center" id="">					 
					 	<a href="#" class="button" id="" onclick=' return validate();'><span class="generate">Generate</span></a>
						<a href="#" class="button"	onclick="onClearPage"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancelFunc();"><span class="cancel">Cancel</span></a>
				</div> -->
	
<input type="hidden" name="hmode"/>
<input type="hidden" name="strCurrentDate" value="${purchaseOrderDtlRpt.strCurrentDate}"/>
<input type="hidden" name="strStoreName" value="${purchaseOrderDtlRpt.strStoreName}" />
</div>
</div>
</div>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>