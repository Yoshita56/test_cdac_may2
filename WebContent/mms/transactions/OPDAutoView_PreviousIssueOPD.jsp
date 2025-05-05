<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>

<html>
<head>
<meta charset=UTF-8">
<!-- RJ47 -->
<title>Insert Title Here</title>

<!-- CSS -->
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">

<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<!-- JS -->	
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/mms.js"></script>

<!-- EXT JS -->	
	<script language="Javascript" src="../js/OPDAutoIssueTransBs.js"></script>



<script type="text/javascript">
	function controlToMainPage()
	{	    
		document.forms[0].hmode.value="unspecified";
		document.forms[0].submit();
	}
	function resetBtn()
	{	    
		document.forms[0].hmode.value="VIEWPAGE";
		document.forms[0].submit();
	}
	function printDiv() {
		
        var divContents = document.getElementById("issueDtlsDivId").innerHTML;
        var a = window.open('', 'printwin','text-align=center,top=100,width=800,height=800,scrollbars=yes ');
        a.document.write('<html>');
		
      		if(document.forms[0].strHospitalCode.value == '37913'){
          a.document.write('<img src="/INVMGM/hisglobal/images/aiims_header_37913.png" style="text-align:center; margin:auto"/><br><br>');
	  }else if(document.forms[0].strHospitalCode.value == '22914'){
		  a.document.write('<img src="/INVMGM/hisglobal/images/aiims_header_22914.png"  style="text-align:center; margin:auto" /><br><br>');
	  }else if(document.forms[0].strHospitalCode.value === "10911"){
		  a.document.write('<img src="/INVMGM/hisglobal/images/aiims_header_10911.png" style="text-align:center; margin:auto" /><br><br>');
	  }else if(document.forms[0].strHospitalCode.value === "27916"){
		  a.document.write('<img src="/INVMGM/hisglobal/images/aiims_header_27916.png"  style="text-align:center; margin:auto" /><br><br>');
	  }else if(document.forms[0].strHospitalCode.value === "99912"){
		  a.document.write('<img src="/INVMGM/hisglobal/images/aiims_header_99912.png"  style="text-align:center; margin:auto" /><br><br>');
	  }else if(document.forms[0].strHospitalCode.value === "93915"){
		  a.document.write('<img src="/INVMGM/hisglobal/images/aiims_header_93915.png"  style="text-align:center; margin:auto" /><br><br>');
	  }else if(document.forms[0].strHospitalCode.value === "99918"){
		  a.document.write('<img src="/INVMGM/hisglobal/images/aiims_header_99918.png"  style="text-align:center; margin:auto" /><br><br>');
	  }else {
		  a.document.write("");
	  }
        a.document.write(divContents);
        a.document.close();
        a.print();
    }
</script>

<style>
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
.table .thead-dark {
  	color: #000 !important;
  	border: none !important;
  	background:linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;
  	text-align :center !important;	
}
.thead-dark th{
	background:none !important;
	border: none !important;
	text-align :center !important;	
	padding: 0.45rem !important;
}
</style>

</head>
<body>
<html:form name="opdIssuePatAutoBean" action="/transactions/OPDIssueToPatAutoTransCNT" type="mms.transactions.controller.fb.OPDIssueToPatAutoTransFB">

	<div class="alert alert-danger  alert-dismissible fade show" id="errID" style="display: none;"><bean:write name="opdIssuePatAutoBean" property="strErrMsg" /></div>
	<div class="alert alert-warning  alert-dismissible fade show" id="wrnID" style="display: none;"><bean:write name="opdIssuePatAutoBean" property="strWarningMsg" /></div>
	<div class="alert alert-success  alert-dismissible fade show" id="normalMsg" style="display: none;"><bean:write name="opdIssuePatAutoBean" property="strNormalMsg" /></div>			

	<div class="legend2" id='nonPrintableLegend2'>
		<button type="button" title="Cancel" id="cancelButton" class="float-right btn btn-danger mt-1 btn-circle btn-icon" style="border-radius:50%; padding:10px 12px" onclick="controlToMainPage();">	
			<div class="popupToast" style="color: #fff;">
				<i class="fas fa-times" title="Cancel"></i>
			</div>
		</button>
		<!-- new btn added 23-08-23 reset-->
		<button type="button" title="Reset" class="float-right btn btn-success mt-1 btn-circle btn-icon" style="border-radius:50%; padding:10px 10px" onclick="resetBtn();">
			<div class="popupToast">
				<i class="fas fa-redo" title="Reset"></i>
			</div>
		</button>
		
	</div>	
	
	<div class="container-fluid">
		<div class="prescriptionTile">
				
			<div class="legendHeader" id='nonPrintableLegend' style="font-size: 18px;font-weight: 600;">
				<i aria-hidden="true" class="fa fa-clipboard"></i> &nbsp;Previous Issued Details</div>
						
			<div class="container">					 
				<div class="row" style="margin:1% 12%">
					<div class="col-sm-2">
						<label><font color="red">*</font>Store Name</label>
					</div>
					<div class="col-sm-4">
						<!-- <select name="strStoreId" onChange="getItemCat();" class="browser-default custom-select"> -->
						<select name="strStoreId" onChange="" class="browser-default custom-select">
							<bean:write name="opdIssuePatAutoBean" property="strStoreValues" filter="false" />
						</select>
					</div>	
					<!-- now changed 22-08-23 -->
					<div class="col-sm-2">
							<label><font color="red">*</font>CR No</label>
					</div>
					<div class="col-sm-4">
							<%-- <crNo:crNo value ="${opdIssuePatAutoBean.strCrNo}" js=" onkeypress='return initGoFunc(event);'"></crNo:crNo> --%>
							<crNo:crNo value ="${opdIssuePatAutoBean.strCrNo}" js=" onkeypress='');'"></crNo:crNo>
					</div>
				</div>
								
				<div class="row my-1" style="margin:1% 12%">
					<div class="col-sm-2 "><font color="red">*</font>From Date</div>
					<div class="col-sm-4">
						<input  name="strFromDate" class="form-control datepicker" value="${offlineIssueIndentBean.strFromDate}" style="color: rgba(113, 111, 111, 0.87);"> 
					</div>
					
				    <div class="col-sm-2"><font color="red">*</font>To Date</div>
				    <div class="col-sm-4">
				       	<input  name="strToDate" class="form-control datepicker" value="${offlineIssueIndentBean.strToDate}" style="color: rgba(113, 111, 111, 0.87);">    	
				    </div>
  				</div> 
  			</div>
  			
 				<hr>
			
			<div class="row my-2" style="margin:1% 12%">
   	 		 	<div class=" col-sm-12" align="center"> 
   	 		 		<a class="btn btn-sm btn-success"  href="#" onclick="getPrevIssueDtl_OffLine();" style="font-size:1rem;">GO <i class="fas fa-angle-double-right"></i></a>
   	 		 	</div>
     		</div>   

			<div class="row">
				<div class="col-sm-12" align="right" id="mandatorydiv">
  						<i class="fas fa-asterisk" style="color: red; font-size: smaller;margin-top: 5px;"></i>Fields Mandatory
  				</div>
			</div>
			
			<div id="PrevIssueId" style="display: none">
		   	   	<div id='prevIssueDiv'></div>			
			</div>
		</div>
								
		<input type="hidden" name="hmode"/>
		<input type="hidden" name="strMode"         value="${opdIssuePatAutoBean.strMode}"/>
		<input type="hidden" name="strCrNo"         value="${opdIssuePatAutoBean.strCrNo}" />
		<input type="hidden" name="strHospitalCode" value="${opdIssuePatAutoBean.strHospitalCode}"/>				
		<input type="hidden" name="strIssueNum"     value="0" />		
			
		</div>	
	  				
		<div class="modal fade bd-example-modal-lg" id="issueDtlModal">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header" style="font-size:21px;">Previous Issued Details
						<button type="button" class="btn btn-primary" onclick="printDiv()">Print</button>
					</div>
					
					<div class="modal-body">
						<div id="issueDtlsDivId"></div>
						<!-- <hr> -->
						
						<!-- <div class="modal-body1" id="issueDtlsDivId" style="display: block;height:10rem;"></div> -->
					</div>
				</div>
			</div>
		</div>  
		  			
		
</html:form>

<script type="text/javascript">

$('.datepicker').each(function(){
    $(this).datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
});
var today=new Date();
var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
var mmm=arr[today.getMonth()];
var hrs=today.getHours();
var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
$('.datepicker').val(dd);

</script>

<%--<div class="col-sm-2">
					<label><font color="red">*</font>Item Category</label>
			</div>
			<div class="col-sm-4">											
				<div id="itemcatDivId" >
				     <select name="strItemCat" class="browser-default custom-select" onchange="" >
						<bean:write name="opdIssuePatAutoBean" property="strCatValues"  filter="false" />
					</select>
   				</div> 
			</div> --%>

<!-- <div class="" id="PrevIssueId" style="display: none">
				<div class="row newrow2"></div>
		   	   	<div id='prevIssueDiv'></div>			
			    <div class="row newrow2"></div>	
			</div> -->
</body>
</html>
<!-- RJ47 --> 