<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<!--  Developer : Santosh Chauhan
	  Version	: 1.0	 
	  Date 		: 27-Feb-2013
	  Module 	: Mms
	  Process	: Challan Process View
-->

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=UTF-8">

<title>Challan View</title>

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
<script language="Javascript" src="../js/challanprocessapproval_mmstrans.js"></script>

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
	padding: 0.25rem;
	text-align: center;
		
}
</style>
</head>

<body>
<html:form name="challanProcessApprovalBean" action="/transactions/ChallanProcessApprovalTransBSCNT"
	type="mms.transactions.controller.fb.ChallanProcessApprovalTransFB" enctype="multipart/form-data">
	
	<div class="errMsg" id="errMsg" style="font-size:18px;"><bean:write name="challanProcessApprovalBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg" style="font-size:18px;"><bean:write name="challanProcessApprovalBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg" style="font-size:18px;"><bean:write name="challanProcessApprovalBean" property="strMsg" /></div>

<div class="container-fluid">
	<div class="prescriptionTile">	
	<fieldset>
	  	<legend class="legendHeader" id='nonPrintableLegend'>Challan Approval</legend>
	  	
		<div class="legend2" >
			<button type="button" class="float-right btn btn-danger mt-1 btn-circle" style="border-radius:50%; padding:12px;" onclick="cancelPage('LIST');">
				<i class="fas fa-times fa-lg iround" title="Cancel"></i>
			</button>
		</div>
				 
		<div class="row rowFlex reFlex">
		  <div class="col-sm-12">
		    <p class="subHeaders"><i class="fas fa-file-invoice-dollar iround"></i>
		    &nbsp;Challan Detail >> View</p>
		  </div>
		</div>
	
		<div class="row">
			<div class="col-sm-2" ><label>Store Name</label></div>
			<div class="col-sm-2" style="font-weight: initial;"><bean:write name="challanProcessApprovalBean" property="strStoreName"/> </div>
			<div class="col-sm-2" ><label>P.O. No</label></div>
			<div class="col-sm-2" style="font-weight: initial;"><bean:write name="challanProcessApprovalBean" property="strPoNoDisplay"/></div>
			<div class="col-sm-2" ><label>Supplier Name</label></div>
			<div class="col-sm-2" style="font-weight: initial;"><bean:write name="challanProcessApprovalBean" property="strSupplierName"/></div>
			</div>

		<bean:write name="challanProcessApprovalBean" property="strChallanHlpDtl" filter="false" />
		
		<div id ="receivedItemDtlsDivId"></div>	
		
		<div id="verifiedItemDtlsDivId"></div>	

		<div id="blanket" style="display:none;"></div>
			<div class="popUpDiv" id="popUpDiv" style="display:none;">
			<table bgcolor="white">
				<tr>
					<td>
					 <div id="printDtlsDivId" style="display:block;"></div>
					</td>
				</tr>
			</table>
		</div>	
<hr>

		<div class="row rowFlex reFlex">
			<div class="col-sm-7"></div>
			<div class="col-sm-5" align="right"><i class="fa fa-asterisk" style="color: red;font-size: smaller;"></i>Fields Mandatory</div>				
		</div>

		<input type="hidden" name="strPrevHiddenChallanValue" value="" />
		<input type="hidden" name="strPoNo" value="${challanProcessApprovalBean.strPoNo}" />
		<input type="hidden" name="strPoNoDisplay" value="${challanProcessApprovalBean.strPoNoDisplay}" />
		<input type="hidden"  name="strStoreName"  value="${challanProcessApprovalBean.strStoreName}">
		<input type="hidden"  name="strSupplierName"  value="${challanProcessApprovalBean.strSupplierName}">	
		<input type="hidden" name="hmode" />
		<input type="hidden" value="${challanProcessApprovalBean.combo[0]}" name="combo" tabindex="1"/>	
		<input type="hidden" value="${challanProcessApprovalBean.combo[1]}" name="combo" tabindex="1"/>	
		<input type="hidden" value="${challanProcessApprovalBean.combo[2]}" name="combo" tabindex="1"/>	
	
		<cmbPers:cmbPers />
		</fieldset>
	</div>
</div>

</html:form>
</body>
</html>

