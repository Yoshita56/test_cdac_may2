<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Breakage/Lost Detail</title>

<style type="text/css">
		.prescriptionTile {
				margin: 20px;
				border-bottom: 1px solid #d7d7d7;
				padding-bottom: 10px;
				padding: 1% 2% 0.5% 2%;
				background-color: #fff;
				transition: 0.5s;
				box-shadow: 0.5px 0.5px 10px 2px #b0acac;
				border-radius: .35rem;
				color: #666;
				color: rgba(75, 75, 75, 0.9);
				color: rgb(21, 21, 21);
		}
		.legend2 {
			  position: absolute;
			  top: 0.5em;
			  right: 44px;
			  line-height: 1.2em;
		}
</style>

<!-- CSS -->
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<!-- JS -->
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="Javascript" src="../../hisglobal/js/time.js"></script>

<!-- EXT JS -->
<script language="Javascript" src="/INVMGM/mms/js/dwh_breakageAndLostDrugDetails_rpt.js"></script>

<!-- JQuery -->
<script src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script src="/INVMGM/hisglobal/js/jquery.autocomplete.min.js"></script> 

<!-- BS Library  -->
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css"> 
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">

<!-- JS Library  -->
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>


</head>

<body onload="onLoadPage();">

<html:form action="/reports/BreakageAndLostDrugDetailsRptCNT" type="mms.reports.controller.fb.BreakageAndLostDrugDetailsRptFB" name="breakageAndLostDrugDetailsRptFB" method="post">
	
<div class="errMsg" id="errMsg" style='font-size: 16px;'><bean:write name="breakageAndLostDrugDetailsRptFB" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg" style='font-size: 16px;'><bean:write name="breakageAndLostDrugDetailsRptFB" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg" style='font-size: 16px;'><bean:write name="breakageAndLostDrugDetailsRptFB" property="strWarningMsg"/></div>

<div class="container-fluid">
	<div class="prescriptionTile">
		
	<div class='legendHeader' style='font-size: 16px;font-weight: bold;'>
	<i aria-hidden="true" class="fa fa-clipboard"></i> &nbsp;Breakage/Lost Detail</div>
		
	<div class="row ">
			<div class="legend2" id='nonPrintableLegend2'>
				<button type="button" title="Cancel" id="cancelButton" class="float-right btn btn-danger mt-1 btn-icon "style="border-radius:50%; padding:12px 13px" onClick="cancelFunc();">	
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-times" title="Cancel"></i>
					</div>
				</button>
				
				<button type="button" title="Clear" class="float-right btn btn-secondary mt-1 btn-icon " style="background-color: #2196f3; border-radius:50%; padding:12px 9px" onClick="document.forms[0].reset();">	
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-broom" title="Clear"></i>
					</div>
				</button>		
				
				<button  type="button" title="Generate" id="generatebutton" class="float-right btn btn-success mt-1 btn-icon"  style="border-radius:50%; padding:12px 11px;" tabindex='2' onClick="return getInventoryDtls();"  data-toggle="" data-target="#previewModal" >
					<div class="popupToast" style="color: #fff;"> 
						<i class="fas fa-download" title="Generate"></i>
					</div>
				</button>
 			</div>  
	</div>
		
	<div class="container">	
		<div class="row" style="margin: 1% 12%">
				<div class="col-sm-2"><label>Store Name<font color="red">*</font></label></div>
				<div class="col-sm-4">
					<select name="strStoreId" class='custom-select' onchange="getItemCatCmb();"> 
						<bean:write name="breakageAndLostDrugDetailsRptFB" property="strStoreValues" filter="false" />
					</select>
				</div>
				
			
				<div class="col-sm-2 "><label>Category<font color="red">*</font></label></div>
				<div class="col-sm-4" id="itemCatDivId">
					<select name="strItemCatNo"  class="custom-select" onChange="">
						<option value="0">Select Value</option>
						<option value="10">Drug</option>
				    </select>		
				</div> 
			</div>
	
		<div class="row " style="margin: 1% 12%">
			<div class="col-sm-2"><label>From Date<font color="red">*</font> </label></div>
			<div class="col-sm-4">
				<input name="strFromDate" id="datepicker1" class="form-control datepicker1" value="${breakageAndLostDrugDetailsRptFB.strCurrentDate}" />
	<%-- 			<dateTag:date name="strFromDate" value="${breakageAndLostDrugDetailsRptFB.strCurrentDate}" />
	 --%>	</div>
		
		
			<div class="col-sm-2"><label>To Date<font color="red">*</font> </label></div>
			<div class="col-sm-4">
				<input name="strToDate" id="datepicker2" class="form-control datepicker2" value="${breakageAndLostDrugDetailsRptFB.strCurrentDate}" />
	<%-- 			<dateTag:date name="strToDate" value="${breakageAndLostDrugDetailsRptFB.strCurrentDate}" />
	--%>	</div>
		</div>	
	</div>
		<%-- <div class="col-sm-2 "><label>Footer Required<font color="red">*</font></label></div>
		<div class="col-sm-2 ">
		<html:checkbox property="strIsFooter" name="breakageAndLostDrugDetailsRptFB" value="1"></html:checkbox>
		</div>
	
		<div class="col-sm-2"><label>User Remarks<font color="red">*</font></label></div>
		<div class="col-sm-2">
			<textarea name="strUserRemarks" class="form-control" rows="1"  style="height:38px;" onkeyup="maxLengthRemarks(this,'500')" ></textarea>
		</div> --%>

<hr>
		
		<div class="row text-right">
	    	<div class="col-sm-12">
	    		<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>Fields Mandatory
	    	</div>
		</div>

		<input type="hidden" name="hmode"/>
		<input type="hidden" name="strEndFinancialYearTemp" value="${breakageAndLostDrugDetailsRptFB.strEndFinancialYearTemp}"/>
		<input type="hidden" name="strCurrentDate" value="${breakageAndLostDrugDetailsRptFB.strCurrentDate}"/>
		<input type="hidden" name="strStoreName" value=""/>
		<input type="hidden" name="strItemCategoryName" value=""/>
	
	<div align="center" id="breakageRpt"></div>
	
	</div>
</div>

</html:form>

 <script type="text/javascript">
    $('#datepicker1').datepicker({modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
    $('#datepicker2').datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
    var today=new Date();
    var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
    var mmm=arr[today.getMonth()];
    var hrs=today.getHours();
    var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
    $('#datepicker1').val(dd);
    $('#datepicker2').val(dd);
</script>

<tag:autoIndex></tag:autoIndex>
</body>
</html>