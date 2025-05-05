<%@ page language="java" contentType="text/html;"	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>


<html>
<head>
<meta charset=UTF-8">
<title>Return Process</title>

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css"
	rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css"
	rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet"
	type="text/css">
<link
	href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css"
	rel="stylesheet" type="text/css">
	
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript"
	src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>

<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script language="Javascript" src="../js/issue_BarCode.js"></script>
<script type="text/javascript">

</script>
<style type="text/css">
.table th, .table td {
    padding: 0.15rem;
}
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
	}
	.thead-dark th{
		background:none !important;
		border: none !important;	
		text-align: center;
		padding:0.25rem;
	}
</style>
   
</head>

<body onload="IssueDetails();">


<html:form name="issueBarCodeBean" action="/transactions/IssueToPatientBarCodeTransCNT" type="mms.transactions.controller.fb.IssueToPatientBarCodeTransFB">


	<div class="errMsg"     id="errMsg"     style="font-size:18px;"><bean:write name="issueBarCodeBean" property="strErrMsg" /></div>
	<div class="warningMsg" id="warningMsg" style="font-size:18px;"><bean:write name="issueBarCodeBean" property="strWarningMsg" /></div>
	<div class="normalMsg"  id="normalMsg"  style="font-size:18px;"><bean:write name="issueBarCodeBean" property="strNormalMsg" /></div>	

<div class="container-fluid">
	<div class="prescriptionTile">

		<div class="row " id="saveId">
			<div class="legend2" id='nonPrintableLegend2'>
									
			<button type="button" class="float-right btn btn-danger mt-1 btn-circle" style="border-radius:50%; padding:10px 12px;" onclick="cancelToMainPage(1);">
				<i class="fas fa-times  iround" title="Cancel"></i>
			</button>
											
			<button type="button" id="savebutton" class="float-right btn btn-success mt-1 btn-circle savebtn" name="patientAdmissionModiTransBean" tabindex='2'style="border-radius:50%; padding:10px 11px;" onclick='return repeatRequest();'>
				<i class="fa fa-download fa-beat iround" title="Save Repeat Drug List"></i>
			</button>
			</div>
		</div>
		
			<div class="row ">
				<div class="col-sm-5" style="font-weight:600; font-size:18px;">
					<p class="subHeaders">
						<i class="fas fa-file-alt iround"></i>
						&nbsp;List of Drugs Issued To Patient&gt;&gt;
					</p>
				</div>
			</div>

<div class="container">
	<div class="row ">
		<div class="col-md-2 ">Store Name</div>
		<div class="col-md-2" style=""><b><bean:write name="issueBarCodeBean" property="storeName" filter="false" /></b></div>
		<div class="col-md-2">Item Category</div>
		<div class="col-md-2" style=""><b><bean:write name="issueBarCodeBean" property="itemCatName" filter="false" /></b></div>
		<div class="col-md-2">CR No.</div>
		<div class="col-md-2" style=""><b><bean:write name="issueBarCodeBean" property="crNo" filter="false" /></b></div>
	</div>
<br>

<div id="allDivId" style="display: block;">
	<div class="row ">
		<div class="col-md-4 ">
		<input type='hidden' name='button1' value="0">
		<div id="plus1"  style="display:none;"><i class="fas fa-plus-circle" onClick="ftn11();"></i>&nbsp;<b>Patient Demographic Detail</b></div>
		<div id="minus1" style="display:block;"><i class="fas fa-minus-circle" onClick="ftn11();"></i>&nbsp;<b>Patient Demographic Detail</b></div>
		</div>
	</div>
</div>
 
<div id = "patientDetailsDivId" style="display:block;">
  <table class="table" align="center" cellspacing ="1px">
  <tr>
      <bean:write name="issueBarCodeBean" property="strPatientDetail" filter="false" />
  </tr>
 </table>
</div>
 
 
	<br>
		<div class="row">
			<div class="col-md-12"><i class="fas fa-clipboard-check" style="font-size:20px;"></i>&nbsp;<label style="font-size:16px;">Issue Detail(s)</label></div>
		</div>
		
	    <div id="id1" style="display: none;">
			<div class="row ">
				<div class="col-md-12 "><i class="fas fa-clipboard-check" style="font-size:20px;"></i>&nbsp;<label style="font-size:16px;">Issue Item/Drug Detail(s)</label></div>
			</div>
		</div>
	
	    <div id="itemDetailsNewDivId" style="display: block;"></div>
	    
	         
	    
	    <bean:write name="issueBarCodeBean" property="strPrevIssueDrugList" filter="false" />
          
	<br>
    	<div class="row " >
			<div class="col-md-2 ">Recommended By</div>
			<div class="col-md-2"><select name="strRecommendedBy" class='browser-default custom-select'>
				<bean:write name="issueBarCodeBean" property="strRecommendNameCombo" filter="false" />
				</select></div>
			<div class="col-md-2">Recommend Date</div>
			<div class="col-md-2"><input  name="strRecommendDate"
											class="form-control datepicker"
											value="${issueBarCodeBean.strCtDate}"
											style="color: rgba(113, 111, 111, 0.87);"></div>
			<div class="col-md-2">Remarks</div>
			<div class="col-md-2"><textarea class="form-control" name="strRemarks" rows="2" style="height:38px"></textarea></div>
		</div>
		</div>
	<hr>
	
	<div class="row" style="padding-top: 10px;"><div class="col-md-12" align="right"><font size="smaller" color="red">*</font>Mandatory Fields</div></div>

	<input type="hidden" name="hmode" />
	<input type="hidden" name="hospCode" 				value="${issueBarCodeBean.strHospitalCode}" />
	<input type="hidden" name="storeName" 				value="${issueBarCodeBean.storeName}" />
	<input type="hidden" name="itemCatName" 			value="${issueBarCodeBean.itemCatName}" />
	<input type="hidden" name="crNo" 					value="${issueBarCodeBean.crNo}" />
	<input type="hidden" name="strCrNo" 				value="${issueBarCodeBean.crNo}" />
	<input type="hidden" name="strId" 					value="${issueBarCodeBean.strId}" />
	<input type="hidden" name="itemCategory" 			value="${issueBarCodeBean.itemCategory}" />	
	<input type="hidden" name="mode" 					value="${issueBarCodeBean.strMode}" />
	<input type="hidden" name="strMode"   				value="${issueBarCodeBean.strMode}">	
	
</div>
</div>
	

</html:form>
<tag:autoIndex></tag:autoIndex>
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
</body>
</html>