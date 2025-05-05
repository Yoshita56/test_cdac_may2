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
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css"
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


<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../js/advanceRequestTrans.js"></script>
<script language="Javascript" src="../js/duplicateIssueOPDVouher_mmsTransNEW.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script language="Javascript" src="../js/mms.js"></script>
<script type="text/javascript">

</script>
</head>

<body onload="onCheckCategory();">
<html:form action="/transactions/DuplicateIssueToPatientVoucherCNTNEW.cnt" name="duplicateIssueToPatientVoucherTransBean" type="mms.transactions.controller.fb.DuplicateIssueToPatientVoucherTransFB" method="post">
	
	
	
	<div class="viewport" id="nonPrintable">
			<div class="container-fluid">

				 
			<div class="row justify-content-center">
					<div class="col-sm-12">
						<br>
						<div class="prescriptionTile">
						<div class="row rowFlex reFlex">
						<div class="col-md-12" align="center">
				       	<div class="errMsg" id="errMsg"><bean:write name="duplicateIssueToPatientVoucherTransBean" property="strErr" /></div>
						<div class="warningMsg" id="warningMsg"><bean:write name="duplicateIssueToPatientVoucherTransBean" property="strWarning" /></div>
						<div class="normalMsg" id="normalMsg"><bean:write name="duplicateIssueToPatientVoucherTransBean" property="strMsg" /></div>

						</div></div>
							<div class="row rowFlex reFlex" id="saveId">
								<div class="legend2" id='nonPrintableLegend2'>
									<button type="button"
										class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn"
										onclick="cancel();">
										<i class="fas fa-ban iround" title="Cancel"></i>
									</button>
									<!-- <button  name="offlineIssueIndentBean" property="strViewChk" onclick="transferToViewPage();" title="Click Here To View Off Line Issue Item Detail" type="button" class="btn btn-outline-primary mt-1 btn-circle printbtn">
											<i class="fas fa-eye iround"  title="View"></i>
									</button> -->
									<!-- <button type="button" class=" btn btn-secondary btn-circle"
										onclick="clearIssue()"
										style="background: #b9b9b9; border-color: #b9b9b9; margin-top: 0.25rem !important;">
										<img src="/HIS/hisglobal/images/clear3.png" title="Clear"
											style="width: 23px; color: #fff;">
									</button>
									<button type="button" id="savebutton"
										class="float-right btn btn-outline-success mt-1 btn-circle"
										tabindex='2' id="submitId" onclick=' return validate1();'
										name="patientAdmissionModiTransBean"
										style="background-color: #5cb85c;">
										<i class="fa fa-download iround" title="Save"></i>
									</button> -->
 
								</div>
							</div>
	
	<!-- <div class="row rowFlex reFlex">
								<div class="col-sm-5">
									<p class="subHeaders">
										<button type="button"
											class="btn btn-outline-success  btn-circle1">
											<i class="fas fa-file-alt iround" title="Cancel"></i>
										</button>
										&nbsp;Duplicate Issue Voucher&gt;&gt;Patient(OPD)
									</p>
							
								</div>
							</div> -->

	
<div class="row rowFlex reFlex">
<div class="col-md-2 px-4"><font color="red">*</font>Store Name</div>
			<div class="col-md-2" style="font-weight:10;color:rgba(75, 75, 75, 0.7);word-wrap:break-word;"><bean:write name="duplicateIssueToPatientVoucherTransBean" property="storeName" filter="false" /></div>
			<div class="col-md-2"><font color="red">*</font>Item Category</div>
			<div class="col-md-2" style="font-weight:10;color:rgba(75, 75, 75, 0.7);word-wrap:break-word;"><bean:write name="duplicateIssueToPatientVoucherTransBean" property="itemCatName" filter="false" /></div>
			<div class="col-md-2"><font color="red">*</font>CR No.</div>
			<div class="col-md-2" style="font-weight:10;color:rgba(75, 75, 75, 0.7);word-wrap:break-word;"><bean:write name="duplicateIssueToPatientVoucherTransBean" property="crNo" filter="false" /> </div>
			</div>
	
<br>
<div id="allDivId" style="display: block;">
<div class="row rowFlex reFlex">
				<div class="col-md-4">
				<input type='hidden' name='button1' value="0">
				<div id="plus1" style="display: none"><i class="fas fa-plus-circle" onClick="ftn11();"></i>&nbsp;<b>Patient Demographic Detail</b></div>
				<div id="minus1" style="display: block"><i class="fas fa-minus-circle" onClick="ftn11();"></i>&nbsp;<b>Patient Demographic Detail</b></div>
			
			</div></div>
</div>
 
 <div id = "patientDetailsDivId" style="display:block;">
  <table class="table" align="center" cellspacing ="1px">
  <tr>
      <bean:write name="duplicateIssueToPatientVoucherTransBean" property="strPatientDetail" filter="false" />
  </tr>
 </table>
 </div>
<br>

<div class="row rowFlex reFlex">
			<div class="col-md-2 px-4"><font color="red">*</font>Issue No</div>
			<div class="col-md-2" style="font-weight:10;color:rgba(75, 75, 75, 0.7);word-wrap:break-word;"><select name="strIssueNo" class='browser-default custom-select' onchange="getReport();">
				<bean:write name="duplicateIssueToPatientVoucherTransBean" property="strIssueNoCombo" filter="false" />
				</select></div>
			<div class="col-md-2"></div>
			
</div>

 
	
	<div class="row"><div class="col-md-12" align="right"><font color="red">*</font> Mandatory Fields</div></div>


	
		<br>
	

	
	
	<input type="hidden" name="hmode" />
	<input type="hidden" name="storeName" value="${duplicateIssueToPatientVoucherTransBean.storeName}" />
	<input type="hidden" name="strStoreId" value="${duplicateIssueToPatientVoucherTransBean.strStoreId}" />
	<input type="hidden" name="itemCatName" value="${duplicateIssueToPatientVoucherTransBean.itemCatName}" />
	<input type="hidden" name="crNo" value="${duplicateIssueToPatientVoucherTransBean.crNo}" />
	<input type="hidden" name="strCrNo" value="${duplicateIssueToPatientVoucherTransBean.crNo}" />
	<input type="hidden" name="strId" value="${duplicateIssueToPatientVoucherTransBean.strId}" />
	<input type="hidden" name="itemCategory" value="${duplicateIssueToPatientVoucherTransBean.itemCategory}" />
	<input type="hidden" name="strConfCatCode" value="${duplicateIssueToPatientVoucherTransBean.strConfCatCode}" />
	<input type="hidden" name="mode" value="${duplicateIssueToPatientVoucherTransBean.strMode}" />
	<input type="hidden" name="strMode"   value="${duplicateIssueToPatientVoucherTransBean.strMode}">
	<input type="hidden" name="strIssueMode"   value="${duplicateIssueToPatientVoucherTransBean.strIssueMode}">
	<input type="hidden" name="strReturnDrugValidity"   value="${duplicateIssueToPatientVoucherTransBean.strReturnDrugValidity}">
	<%-- <input type="hidden" name="strIssueNo"   value="${duplicateIssueToPatientVoucherTransBean.strIssueNo}"> --%>
	
	
</div>
</div>
</div>
</div>
</div>

	<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="popUpDiv" style="display:none;">

<table bgcolor="white">

<tr>

<td>

 <div id="issueDtlsDivId" style="display:block;"></div>

</td>

</tr>

</table>
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