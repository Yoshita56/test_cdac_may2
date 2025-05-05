<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>   
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
    
<!DOCTYPE html>

<html>
<head>
<meta charset=UTF-8">
<title>Item Transfer Report</title>

<!-- CSS -->
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">

<!-- JS -->
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<!-- EXT JS -->
<script language="JavaScript" src="../js/ItemTransferRPT.js"></script>

<style type="text/css">
body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 14px;
	line-height: 1.42857143;
	color: rgba(0, 0, 0, 1);
	font-weight: 501;
}
.container{
	max-width:1395px;
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
<html:form action="/reports/ItemTransferRPTCNT.cnt"  name="ItemTransferRptbean" type="mms.reports.controller.fb.IndentWiseIssueRPTFB" method="post">

  	<div id="errMsg" class="errMsg"><bean:write name="ItemTransferRptbean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="ItemTransferRptbean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="ItemTransferRptbean" property="strNormalMsg" /></div>
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
								&nbsp; Item Transfer Report
							</p>
						</div>
						
						<div class="col-sm-6" id="viewCancelButtonDivId1">
							<div class="legend2" id='nonPrintableLegend2'>
								<button type="button" class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="cancelFunc();">
									<i class="fas fa-times fa-lg iround" title="Cancel"></i>
								</button>
								<button type="button" class=" btn btn-secondary btn-circle" style="background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" onclick="onClearPage();">
									<!-- <img src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 23px; color: #fff;"> -->
									<i class="fas fa-broom fa-lg iround" title="Clear"></i>
								</button>
								<button type="button" id="saveid" class="float-right btn btn-outline-success mt-1 btn-circle savebtn" tabindex='2' onclick='return getInventoryDtls();'>
									<i class="fa fa-download fa-beat iround" title="Search"></i>
								</button>
							</div>
						</div>
					</div>
			  <div class="container">
			  <div class="row">
					<div class="col-sm-3">
							<label><font color="red">*</font>Store Name</label>
					</div>
					<div class="col-sm-3">
						<select name="strStoreId" id="StoreId" class="browser-default custom-select">
							<bean:write name="ItemTransferRptbean" property="strStoreNameCombo" filter="false" />
						</select>
					</div>				
	   				<div class="col-sm-3">
				   		<label><font color="red">*</font>Item Category</label>
					</div>
					
					<div class="col-sm-3">
						<select name="strItemCategoryId" id="itemCategoryDivId" class="browser-default custom-select" onChange="itemNameCombo();">
							<bean:write name="ItemTransferRptbean" property="strItemCategoryCombo" filter="false"/>
						</select>
					</div>
    		  </div>
    		  
    		  <div class="row ">
			  		<div class="col-sm-3">
						<label><font color="red">*</font>From Date</label>
					</div>
					<div class="col-sm-3">
						<input name="strFromDate" id="strFromDate" class="form-control datepicker" value="${ItemTransferRptbean.strCurrentDate}" />
					</div>
				
	    		    <div class="col-sm-3">
				   		<label><font color="red">*</font>To Date</label>
					</div>
					<div class="col-sm-3">
						<input name="strToDate" id="strToDate" class="form-control datepicker" value="${ItemTransferRptbean.strCurrentDate}" />
					</div>
    		  </div> 
    		  </div>	
	<!-- 	<hr id='hr4' style="display: none;"><hr>
		<div class="col-sm-12" id="myDIV">
    		<label><font color="red">We keep a record here for Indent Wise Issue.</font></label>
    	</div>
    	 -->
    	<div align="center" id="AckReport"></div>
    	
    	
 		<hr id='hr4' style="display: none;"><hr>
    	<div class="col-sm-12" align="right" id="myDIV">
    		<i class="fas fa-asterisk" style="color: red; font-size: smaller;margin-top: 5px;"></i>Fields Mandatory
    	</div>


<input type="hidden" name="hmode"/>

<input type="hidden" name="hmode"/>
<input type="hidden" name="strStoreName" value=""/>
<input type="hidden" name="strSupplierName" value=""/>
<input type="hidden" name="strItemCategoryName" value=""/>
<input type="hidden" name="strItemCategoryCode" value=""/>
<input type="hidden" name="strInstituteName" value=""/>
<input type="hidden" name="strStatus" value=""/>
<input type="hidden"  name="strHtmlCode"  value="">
<input type="hidden" name="strCurrentDate" value="${ItemTransferRptbean.strCurrentDate}" />
		
		
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