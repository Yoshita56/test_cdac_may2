<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<html>
<head>
<meta charset="utf-8">
<title>Generic Drug</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

	
	<link rel="stylesheet" href="../../hisglobal/bootstrap/css/bootstrap.min.css">  
<link href="../../hisglobal/DataTables/css/dataTables.bootstrap4.min.css" rel="stylesheet">
	
<script src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script language="JavaScript" src="../../hisglobal/js/DataTables.js"></script>
<script src="../../hisglobal/DataTables/js/dataTables.bootstrap.min.js"></script> 
<script type="text/javascript" src="../../hisglobal/DataTables/js/dataTables.buttons.min.js"></script>

<script type="text/javascript" src="../../hisglobal/DataTables/js/pdfmake.min.js"></script>
<script type="text/javascript" src="../../hisglobal/DataTables/js/vfs_fonts.js"></script>
<script type="text/javascript" src="../../hisglobal/DataTables/js/buttons.html5.min.js"></script>
<link
	href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css"
	rel="stylesheet">	
	
	

<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript"
	src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationBootstrap.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>

<script type="text/javascript">
	
	
	function closeView()
	{
		window.close();
	}
</script>
<style>
.card {
	margin: 1% 0;
	border-bottom: 1px solid #d7d7d7;
	padding-bottom: 10px;
	padding: 1% 2% 1.5% 2%;
	background-color: #fff;
	transition: 0.5s;
	box-shadow: 0 0.5px 10px 2px #b0acac;
	color: gray;
}

.card:hover {
	box-shadow: 0 2px 10px 2px #847d7d;
}
.subHeaders {
	font-weight: 500 !important;
	/*color: rgba(33, 32, 32, 0.7);

    font-family: "Helvetica Neue", "Helvetica";*/
	font-size: 19px !important;
	padding-bottom: 0px !important;
}
body {
    
    color: gray;
}
.addtoolbar a{
	margin: 0 1px;
}
html{
	overflow-x: hidden;
}
#mainDataTableId_length{
	/* text-align: left; */
}
#mainDataTableId_info{
	/* text-align: left; */
	color: #0237c0;
}
.buttonsCls{
	margin-right: 1px;
}
#mainDataTableId_wrapper{
	font-size: 12px;
}
#mainDataTableId{
	font-size: 12px;
}
.TDCOMBOHEADER select[name="combo"]{
	max-width: 220px;
}
.TDCOMBOHEADER b{
	font-weight: normal;
	text-transform: uppercase;
	font-size:13px;
}
.dt-buttons{
	float: left;
	padding-left: 10px;
}
.MASTERNAME{
	text-transform:uppercase;
}
.legendNew {
    position: absolute;
    right: 100px;
    line-height: 1.2em;
    top: -2.5em;
    
}
</style>
</head>
<body onload="">
<html:form action="/masters/GenericDrugMstBSCNT" name="genericdrugBean"
	type="mms.masters.controller.fb.GenericDrugMstFB">


	<center>
	<div class="errMsg" id="errMsgId"><bean:write
		name="genericdrugBean" property="strErrMssgstring" /></div>
	<div class="warningMsg" id="warningMsgId"><bean:write
		name="genericdrugBean" property="strWarnMssgstring" /></div>
	<div class="normalMsg" id="normalMsgId"><bean:write
		name="genericdrugBean" property="strNormMssgstring" /></div>
	<%-- <tag:tab tabLabel="Generic Drug Master" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">

	</tag:tab> --%></center>



   <div class="row">
				<div class="col-sm-9" align="left">
							<p class="subHeaders" style="margin-bottom: 0;">
								<i class="fas fa-university" style="font-size: 26px;">&nbsp;</i>Generic Drug Master&nbsp;&nbsp;<i class="fas fa-angle-double-right"></i>&nbsp;View			
							</p>
				       </div>
							<div class="col-sm-3" align="right" style="margin-top: -30px;"></div>
							</div>
						
	<hr>
	<div class="row">
	<div class="col-sm-3">
	<label>Group Name:</label>
	</div>
	<div class="col-sm-2">
	<bean:write name="genericdrugBean"
				property="strGroupNameValue" filter="false" />
	</div>
	<div class="col-sm-3" align="right">
	<label>Sub Group Name</label>
	</div>
	<div class="col-sm-4">
	<bean:write
				name="genericdrugBean" property="strSubGroupNameValue"
				filter="false" />
	</div>
	</div>
	
	<div class="row">
	<div class="col-sm-3">
	<label>Consumable Type</label>
	</div>
	<div class="col-sm-3">
	<bean:write
				name="genericdrugBean" property="strDrugName" filter="false" />
	</div>
	<div class="col-sm-3">
	<label>Generic Drug Name</label>
	</div>
	<div class="col-sm-3">
	<bean:write
				name="genericdrugBean" property="strDrugName" filter="false" />
	</div>
	
	</div>
	
	<div class="row">
	<div class="col-sm-3">
	<label>Consent Required</label>
	</div>
	<div class="col-sm-3">
	<bean:write
				name="genericdrugBean" property="strConsentReq" filter="false" />
	</div>
	<div class="col-sm-4">
	<label>Whether Drug is Narcotic Drug</label>
	</div>
	<div class="col-sm-2">
	<bean:write
				name="genericdrugBean" property="strIsItemNarcotic" filter="false" />
	</div>
	
	</div>
		
		
	<div class="row">
	
	<div class="col-sm-3">
	<label>Trimester</label>
	</div>
	<div class="col-sm-3">
	<bean:write
				name="genericdrugBean" property="strTrimester" filter="false" />
	</div>
	<div class="col-sm-4">
	<label>Whether safe during pregnancy</label>
	</div>
	<div class="col-sm-2">
	<bean:write
				name="genericdrugBean" property="strPregnancySafeFlag" filter="false" />
	</div>
	
	</div>	
		
		<div class="row">
		<div class="col-sm-3">
	<label>Effects on foetus:</label>
	</div>
	<div class="col-sm-2">
	<bean:write
				name="genericdrugBean" property="strEffectsOnFoetus" filter="false" />
	</div>
	<div class="col-sm-7"></div>
		</div>
		
		<br>
		
<nav>
                   <div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
					<div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
						<a class="nav-item nav-link" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">
						<button type="button" class="btn btn-info btn-sm btnbg" >
							Drug Managed By</button>
						</a>
						
						<a class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">
						<button type="button" class="btn btn-info btn-sm btnbg" >
							Purchase/Inventory</button>
						</a>
						</div>
						</div>
				</nav>
				<div class="tab-content py-3 px-3 px-sm-0" id="nav-tabContent">
					<div class="tab-pane fade" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
					<br>
						<div class="row">
	<div class="col-sm-3" align="right">
	<label>Batch No.</label>
	</div>
	<div class="col-sm-3">
	<bean:write
				name="genericdrugBean" property="strBatchNo" filter="false" />
	</div>
	<div class="col-sm-3" align="right">
	<label>Expiry Date</label>
	</div>
	<div class="col-sm-3">
	<bean:write
				name="genericdrugBean" property="strExpiryDate" filter="false" />
	</div>
	</div>
						
						
						</div>
					<div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
					<br>
					<div class="row">
	<div class="col-sm-2">
	<label>Purchase Lead Time</label>
	</div>
	<div class="col-sm-2">
	<bean:write
				name="genericdrugBean" property="strPurchaseLeadTime" filter="false" />
	</div>
	<div class="col-sm-2">
	<label>Time Format</label>
	</div>
	<div class="col-sm-2">
	<bean:write
				name="genericdrugBean" property="strTimeFormat" filter="false" />
	</div>
	<div class="col-sm-2">
	<label>Inventory Unit</label>
	</div>
	<div class="col-sm-2">
	<bean:write
				name="genericdrugBean" property="strStockMaintain" filter="false" />
	</div>
	</div>
	
	<div class="row">
	<div class="col-sm-2">
	<label>Shelf Life</label>
	</div>
	<div class="col-sm-2">
	<bean:write
				name="genericdrugBean" property="strShelfLife" filter="false" />
	</div>
	<div class="col-sm-2">
	<label>Time Format</label>
	</div>
	<div class="col-sm-2">
	<bean:write
				name="genericdrugBean" property="strShelfTimeFormat" filter="false" />
	</div>
	<div class="col-sm-2">
	<label>Effective From</label>
	</div>
	<div class="col-sm-2">
	<bean:write
				name="genericdrugBean" property="strEffectiveFrom" filter="false" />
	</div>
	</div>
	
	
	<div class="row">
	<div class="col-sm-2">
	<label>Record Status</label>
	</div>
	<div class="col-sm-2">
	<bean:write name="genericdrugBean"
				property="strIsValid" filter="false" />
	</div>
	<div class="col-sm-2">
	<label>Remark</label>
	</div>
	<div class="col-sm-6">
	<bean:write name="genericdrugBean" property="strRemarks"
				filter="false" />
	</div>
	</div>
					
					</div>
					
				</div>
		<hr>
<!-- <div class="row rowFlex reFlex">
							<div class="col-sm-9"></div>
							<div class="col-sm-3" align="right">
							<button type="button" class="btn btn-danger"  data-dismiss="modal"	style="cursor: pointer;">Cancel</button>
							</div>
						</div>				
	 -->
            



	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px" style="display:none;">
		<tr class="HEADER">
			<td colspan="4" width="25%">Generic Drug Master&gt;&gt; view</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Group Name</td>
			<td class="CONTROL"><bean:write name="genericdrugBean"
				property="strGroupNameValue" filter="false" /></td>
			<td width="25%" class="LABEL">Sub Group Name</td>
			<td width="25%" class="CONTROL"><bean:write
				name="genericdrugBean" property="strSubGroupNameValue"
				filter="false" /></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">Consumable Type</td>
			<td class="CONTROL" width="25%"><bean:write
				name="genericdrugBean" property="strConsumableType"
				filter="false" /></td>
			<td width="25%" class="LABEL">Generic Drug Name</td>
			<td width="25%" class="CONTROL" colspan="3"><bean:write
				name="genericdrugBean" property="strDrugName" filter="false" /></td>
		</tr>

		<tr>
			<td class="LABEL" colspan="1" width="25%">Consent Required</td>
			<td class="CONTROL" colspan="1" width="25%"><bean:write
				name="genericdrugBean" property="strConsentReq" filter="false" /></td>
			<td class="LABEL" colspan="1" width="25%">Whether Drug is
			Narcotic Drug</td>
			<td class="CONTROL" colspan="" width="25%"><bean:write
				name="genericdrugBean" property="strIsItemNarcotic" filter="false" />

			</td>
		</tr>
		<tr style="border: 1px solid black">
			<td class="LABEL" rowspan="2" width="25%" style="vertical-align: top">Whether safe during
			pregnancy</td>
			<td class="CONTROL" rowspan="2"  width="25%"   style="vertical-align: top;"><bean:write
				name="genericdrugBean" property="strPregnancySafeFlag" filter="false" />
			
			</td>
			<td class="LABEL"  width="25%"  style="text-align: left; vertical-align: top">Trimester</td>
			<td class="CONTROL"  width="25%"  style="text-align: left; vertical-align: top">
					<bean:write
				name="genericdrugBean" property="strTrimester" filter="false" /></td>
		</tr>
		<tr style="border: 1px solid black">
			<td class="LABEL" width="25%" style="text-align: left; vertical-align: top">Effects
					on foetus:</td>
					<td class="CONTROL" width="25%" style="text-align: left; vertical-align: top">
					<bean:write
				name="genericdrugBean" property="strEffectsOnFoetus" filter="false" />
					</td>
		</tr>
	</table>
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px" style="display:none;">
		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="itemManagePlusId" align="left" style="display: none;">
			<img src="../../hisglobal/images/plus.gif" onClick=""
				style="cursor: pointer; " /> Drug Managed By</div>
			<div id="itemManageMinusId" style="display: block;" align="left">

			Drug Managed By</div>
			</td>
		</tr>
	</table>
	
	
	<div id="itemManageDtlId" style="display: block">
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px" style="display:none;">
		<tr>
			<td class="LABEL" colspan="1" width="25%">Batch No.</td>
			<td class="CONTROL" colspan="" width="25%"><bean:write
				name="genericdrugBean" property="strBatchNo" filter="false" /></td>
			<td class="LABEL" width="25%">Expiry Date</td>
			<td class="CONTROL" width="25%"><bean:write
				name="genericdrugBean" property="strExpiryDate" filter="false" /></td>

		</tr>

	</table>

	</div>
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px" style="display:none;">
		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="purchasePlusId" align="left" style="display: none;"><img
				src="../../hisglobal/images/plus.gif"
				onClick="view1('purchasePlusId','purchaseMinusId','purchaseId');"
				style="cursor: pointer; " /> Purchase/Inventory</div>
			<div id="purchaseMinusId" style="display: block;" align="left">

			Purchase/Inventory</div>
			</td>
		</tr>
	</table>
	
	
	
	
	
	<div id="purchaseId" style="display: block;">
	<table class="TABLEWIDTH" align="center" cellspacing="1px"
		cellpadding="1px" style="display:none;">
		<tr>
			<td class="LABEL" colspan="1" width="25%">Purchase Lead Time</td>
			<td class="CONTROL" colspan="" width="25%"><bean:write
				name="genericdrugBean" property="strPurchaseLeadTime" filter="false" />


			</td>
			<td class="LABEL" colspan="1" width="25%">Time Format</td>
			<td class="CONTROL" colspan="1" width="25%"><bean:write
				name="genericdrugBean" property="strTimeFormat" filter="false" /> <%-- 
				** Inactivated on 28th May 2010, by Aritra
				** Reason: Time formatt not properly shown.
				<html:select property="strTimeFormat" name="genericdrugBean"  styleClass="comboNormal" disabled='true'>
					<html:option value="1"> Day</html:option>
					<html:option value="2"> Month</html:option>
				</html:select>
				--%></td>

		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">Inventory Unit</td>
			<td class="CONTROL" colspan="" width="25%"><bean:write
				name="genericdrugBean" property="strStockMaintain" filter="false" />

			</td>
			<td class="LABEL" colspan="3" width="25%"></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="1" width="25%">Shelf Life</td>
			<td class="CONTROL" colspan="" width="25%"><bean:write
				name="genericdrugBean" property="strShelfLife" filter="false" /></td>
			<td class="LABEL" colspan="1" width="25%">Time Format</td>
			<td class="CONTROL" colspan="1" width="25%">
			<%--
				** Added on 28th May 2010, by Aritra
				** Reason: To show Time formatt properly.
				 
			--%>
			<bean:write
				name="genericdrugBean" property="strShelfTimeFormat" filter="false" />
			<%-- 
				** Inactivated on 28th May 2010, by Aritra
				** Reason: Time formatt not properly shown.
				
				<html:select property="strShelfTimeFormat"  styleClass="comboNormal" name="genericdrugBean"  disabled='true'>
					<html:option value="1"> Day</html:option>
					<html:option value="2"> Month</html:option>
					<html:option value="3">Year</html:option>
				</html:select>
				--%></td>
		</tr>

	</table>

	</div>
	<table cellspacing="1px" class="TABLEWIDTH" align="center"
		cellpadding="1px" style="display:none;">
		<tr>
			<td class="LABEL" width="25%">Remarks</td>
			<td class="CONTROL" width="75%" colspan="3"><bean:write name="genericdrugBean" property="strRemarks"
				filter="false" /></td>

		</tr>
		<tr>

			<td class="LABEL" width="25%">Effective From</td>
			<td class="CONTROL" width="25%" colspan=""><bean:write
				name="genericdrugBean" property="strEffectiveFrom" filter="false" />
			</td>
			<td class="LABEL">Record Status</td>
			<td class="CONTROL"><bean:write name="genericdrugBean"
				property="strIsValid" filter="false" /></td>

		</tr>
	</table>
	
	<table cellspacing="1px" class="TABLEWIDTH" align="center"
		cellpadding="1px" style="display:none;">
		<tr class="FOOTER">
			<td colspan="4" width="25%">&nbsp;</td>
		</tr>
	</table>
	
	
	<table class="TABLEWIDTH" align="center" cellspacing="1px" style="display:none;">

		<tr>

			<td align="center" colspan="2" width="25%"><!-- <img
				src="../../hisglobal/images/btn-ccl.png" title="Cancel View"
				onClick="closeView();" style="cursor: pointer; "> -->
				<a href="#" class="button" onclick="closeView();"><span class="cancel">Cancel</span></a>
			</td>
		</tr>
	</table>
	<input type="hidden" name="hmode" />
	<input type="hidden" value="${genericdrugBean.strCurrentDate}"
		name="strCurrentDate" />
	<input type="hidden" value="${genericdrugBean.strChk}" name="strChk" />


	<cmbPers:cmbPers />

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>