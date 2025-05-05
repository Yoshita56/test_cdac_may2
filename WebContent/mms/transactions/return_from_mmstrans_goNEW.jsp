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
<script language="Javascript" src="../js/advanceRequestTrans.js"></script>
<script language="Javascript" src="../js/returnFrom_mmsTransNEW.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script language="Javascript" src="../js/mms.js"></script>

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

<html:form action="/transactions/ReturnFromTransCNTNEW.cnt" name="returnFromTransBean" type="mms.transactions.controller.fb.ReturnFromTransFB" method="post">
	<div class="errMsg" id="errMsg" style="font-size:18px;"><bean:write name="returnFromTransBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg" style="font-size:18px;"><bean:write name="returnFromTransBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg" style="font-size:18px;"><bean:write name="returnFromTransBean" property="strMsg" /></div>	

<div class="container-fluid">
	<div class="prescriptionTile">

		<div class="row " id="saveId">
			<div class="legend2" id='nonPrintableLegend2'>
									
			<button type="button" class="float-right btn btn-danger mt-1 btn-circle" style="border-radius:50%; padding:10px 12px;" onclick="cancel();">
				<i class="fas fa-times  iround" title="Cancel"></i>
			</button>
			
		<!-- <button  name="offlineIssueIndentBean" property="strViewChk" onclick="transferToViewPage();" title="Click Here To View Off Line Issue Item Detail" type="button" class="btn btn-outline-primary mt-1 btn-circle printbtn">
				<i class="fas fa-eye iround"  title="View"></i>
			</button> -->
		
			<button type="button" class="float-right btn btn-secondary btn-circle" style="border-radius:50%; padding:10px 9px; background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" onclick="clearIssue();">
				<!-- <img src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 23px; color: #fff;"> -->
				<i class="fas fa-broom  iround" title="Clear"></i>
			</button>
										
			<button type="button" id="savebutton" class="float-right btn btn-success mt-1 btn-circle savebtn" name="patientAdmissionModiTransBean" tabindex='2'style="border-radius:50%; padding:10px 11px;" onclick='return validate1();'>
				<i class="fa fa-download fa-beat iround" title="Save"></i>
			</button>
			</div>
		</div>
		<!-- 					
			<button type="button" id="savebutton" class="float-right btn btn-success mt-1 btn-circle savebtn" name="requestForLpPatient" id="submitId" tabindex='2'style="border-radius:50%; padding:12px;" onclick='return freezeChallan();'>
				<i class="fa fa-download fa-beat iround" title="Save"></i>
			</button>
	 -->
			<div class="row ">
				<div class="col-sm-5" style="font-weight:600; font-size:18px;">
					<p class="subHeaders">
						<i class="fas fa-file-alt iround"></i>
						&nbsp;Return From Patient&gt;&gt;
					</p>
				</div>
			</div>

<div class="container">
	<div class="row ">
		<div class="col-md-2 "><font color="red">*</font>Store Name</div>
		<div class="col-md-2" style=""><bean:write name="returnFromTransBean" property="storeName" filter="false" /></div>
		<div class="col-md-2"><font color="red">*</font>Item Category</div>
		<div class="col-md-2" style=""><bean:write name="returnFromTransBean" property="itemCatName" filter="false" /></div>
		<div class="col-md-2"><font color="red">*</font>CR No.</div>
		<div class="col-md-2" style=""><bean:write name="returnFromTransBean" property="crNo" filter="false" /> </div>
	</div>
<br>

<div id="allDivId" style="display: block;">
	<div class="row ">
		<div class="col-md-4 ">
		<input type='hidden' name='button1' value="0">
		<div id="plus1" style="display: block"><i class="fas fa-plus-circle" onClick="ftn11();"></i>&nbsp;<b>Patient Demographic Detail</b></div>
		<div id="minus1" style="display: none"><i class="fas fa-minus-circle" onClick="ftn11();"></i>&nbsp;<b>Patient Demographic Detail</b></div>
		</div>
	</div>
</div>
 
<div id = "patientDetailsDivId" style="display:none;">
  <table class="table" align="center" cellspacing ="1px">
  <tr>
      <bean:write name="returnFromTransBean" property="strPatientDetail" filter="false" />
  </tr>
 </table>
</div>
 
<br>
		<div class="row">
			<div class="col-md-12"><i class="fas fa-clipboard-check" style="font-size:20px;"></i>&nbsp;<label style="font-size:16px;">Issue Detail(s)</label></div>
		</div>
		
		<div class="row ">
			<div class="col-md-2 "><font color="red">*</font>Issue No</div>
			<div class="col-md-4" style="">
				<select name="strIssueNo" class='browser-default custom-select' onchange="IssueDetails();">				   
					<bean:write name="returnFromTransBean" property="strIssueNoCombo" filter="false" />
				</select>
			</div>
			<div class="col-md-6">
				<div class="row " id="issueDivId" style="display: none;">
					<div class="col-md-3 ">Issue Date</div>
					<div class="col-md-3 "><div id="issueDtDivId"></div></div>
	            </div>
			</div>
		</div>

	    <div id="id1" style="display: none;">
			<div class="row ">
				<div class="col-md-12 "><i class="fas fa-clipboard-check" style="font-size:20px;"></i>&nbsp;<label style="font-size:16px;">Issue Item/Drug Detail(s)</label></div>
			</div>
		</div>
	
	    <div id="itemDetailsNewDivId" style="display: block;"></div>
     
        <div class='popup' id='itemDtlId' style="display:none">
		
		<div class="row ">
			<div class="col-md-2 "><div id="popUpItemId"></div></div>
			<div class="col-md-2"><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
					onClick="closeItemPopUp('itemDtlId');" title="Click Here To Close Popup">
			</div>
		</div>
	
		<div class="row ">
			<div class="col-md-2 ">Rate/Unit</div>
			<div class="col-md-2"><div id ='1'></div></div>
			<div class="col-md-2">Manufacturer Date</div>
			<div class="col-md-2"><div id ='2'></div></div>
			<div class="col-md-2">Consumeable</div>
			<div class="col-md-2"><div id ='3'></div></div>
		</div>
	</div>
     
     <div class='popup' id='balQtyId' style="display:none">
		<div class="row ">
			<div class="col-md-2 "><div id="popUpBalId"></div></div>
			<div class="col-md-2"><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
					onClick="closeItemPopUp('balQtyId');" title="Click Here To Close Popup">
			</div>
		</div>
	
		<div class="row ">
			<div class="col-md-2 ">Issued Qty</div>
			<div class="col-md-2"><div id ='4'></div></div>
			<div class="col-md-2">Returned Qty</div>
			<div class="col-md-2"><div id ='5'></div></div>
		</div>
		</div>
<br>
    	<div class="row " >
			<div class="col-md-2 ">Recommended By</div>
			<div class="col-md-2"><select name="strRecommendedBy" class='browser-default custom-select'>
				<bean:write name="returnFromTransBean" property="strRecommendNameCombo" filter="false" />
				</select></div>
			<div class="col-md-2">Recommend Date</div>
			<div class="col-md-2"><input  name="strRecommendDate"
											class="form-control datepicker"
											value="${returnFromTransBean.strCtDate}"
											style="color: rgba(113, 111, 111, 0.87);"></div>
			<div class="col-md-2">Remarks</div>
			<div class="col-md-2"><textarea class="form-control" name="strRemarks" rows="2" style="height:38px"></textarea></div>
		</div>
	</div>
<hr>
	
	<div class="row" style="padding-top: 10px;"><div class="col-md-12" align="right"><font size="smaller" color="red">*</font>Mandatory Fields</div></div>

	<input type="hidden" name="hmode" />
	<input type="hidden" name="hospCode" 				value="${returnFromTransBean.strHospitalCode}" />
	<input type="hidden" name="storeName" 				value="${returnFromTransBean.storeName}" />
	<input type="hidden" name="itemCatName" 			value="${returnFromTransBean.itemCatName}" />
	<input type="hidden" name="crNo" 					value="${returnFromTransBean.crNo}" />
	<input type="hidden" name="strCrNo" 				value="${returnFromTransBean.crNo}" />
	<input type="hidden" name="strId" 					value="${returnFromTransBean.strId}" />
	<input type="hidden" name="itemCategory" 			value="${returnFromTransBean.itemCategory}" />
	<input type="hidden" name="strConfCatCode" 			value="${returnFromTransBean.strConfCatCode}" />
	<input type="hidden" name="mode" 					value="${returnFromTransBean.strMode}" />
	<input type="hidden" name="strMode"   				value="${returnFromTransBean.strMode}">
	<input type="hidden" name="strIssueMode"   			value="${returnFromTransBean.strIssueMode}">
	<input type="hidden" name="strReturnDrugValidity"   value="${returnFromTransBean.strReturnDrugValidity}">
	
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