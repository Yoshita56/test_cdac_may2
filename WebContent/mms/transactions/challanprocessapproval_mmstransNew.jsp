<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=UTF-8">
<title>Challan Detail >> Approval</title>

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css"   rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
	
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validationBootstrap.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/mms.js"></script>

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
	
	.table .thead-dark {
	  	color: #000 !important;
	  	border: none !important;
	  	background:linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;
	}
	.thead-dark th{
		background:none !important;
		border: none !important;	
	}
</style>

<script language="Javascript" src="../js/challanprocess_freeze_mmstransBS.js"></script>
</head>

<body onload="checkMsg();">
<html:form name="challanProcessApprovalBean" action="/transactions/ChallanProcessApprovalTransBSCNT" type="mms.transactions.controller.fb.ChallanProcessApprovalTransFB">

	
	<%-- <div class="errMsg" id="errMsg"><bean:write name="challanProcessApprovalBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="challanProcessApprovalBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="challanProcessApprovalBean" property="strMsg" /></div> --%>

	<div class="errMsg" id="errMsg" style="font-size:18px"><bean:write name="challanProcessApprovalBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg" style="font-size:18px"><bean:write name="challanProcessApprovalBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg" style="font-size:18px"><bean:write name="challanProcessApprovalBean" property="strMsg" /></div>

<div class="container-fluid">
	<div class="prescriptionTile">
	  	<div style="width:auto; margin-bottom: 0px;font-size: 1.5rem;font-weight: 400;margin-left:10px;color: #666;" id='nonPrintableLegend'>Challan Approval</div>
	 
		<div class="legend2" id='saveId'>
			<button type="button" class="float-right btn btn-danger mt-1 btn-circle" style="border-radius:50%; padding:12px;" onclick="cancelPage('LIST');">
				<i class="fas fa-times fa-lg iround" title="Cancel"></i>
			</button>
		
			<button type="button" id="savebutton" class="float-right btn btn-success mt-1 btn-circle savebtn" name="requestForLpPatient" id="submitId" tabindex='2'style="border-radius:50%; padding:12px;" onclick='return freezeChallan();'>
				<i class="fa fa-download fa-beat iround" title="Save"></i>
			</button>			
		</div>
	 
		<div class="row rowFlex reFlex">
		  <div class="col-sm-12">
		    <p class="subHeaders">
			    <i class="fas fa-file-invoice-dollar iround"></i>
			    &nbsp;Challan Detail >> Approval Process
		    </p>
		  </div>
		</div>
	
		<bean:write name="challanProcessApprovalBean" property="strChallanHlpDtl" filter="false" />
		
		<bean:write name="challanProcessApprovalBean" property="strVerifiedItemHlpDtl" filter="false" />
				
		<br>
		<div class="row">
			<div class="col-sm-2" ><label><font size="2" color="red">*</font>Remarks</label></div>
			<div class="col-sm-10"><textarea name="strRemarks" class="form-control" cols="20" rows="2" id="strRemarks"></textarea></div>
		</div>
	
		<hr>
		<div class="row rowFlex reFlex">
			<div class="col-sm-12" align="right"><i class="fa fa-asterisk" style="color: red;font-size: smaller;"></i>Fields Mandatory</div>				
		</div>
	
		<input type="hidden" name="strPrevHiddenChallanValue" value="" />
		<input type="hidden" name="strPoDate" value="${challanProcessApprovalBean.strPoDate}" />
		<input type="hidden" name="strPoStoreId" value="${challanProcessApprovalBean.strPoStoreId}" />
		<input type="hidden" name="strSupplierInterfaceFlag" value="${challanProcessApprovalBean.strSupplierInterfaceFlag} }" />
		<input type="hidden" name="hmode" />

	<cmbPers:cmbPers />
	</div>
</div>

</html:form>

</body>
</html>








