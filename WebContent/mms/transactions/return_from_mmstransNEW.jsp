<%@ page language="java" contentType="text/html;"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>

<!-- 
/**
 * Developer : Tanvi Sappal
 * Version : 1.0
 * Date : 23/Apr/2009
*/
-->
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

<link href="../css/master.css" rel="stylesheet" type="text/css">
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
<script language="Javascript" src="../js/mms.js"></script>

<script language="Javascript" src="../js/returnFrom_mmsTransNEW.js"></script>


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
.form-control {
	color: rgba(0, 0, 0, 1);
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
   top: -2.5em;
   right: 15px;
   line-height: 1.2em;
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

</style>

<script type="text/javascript">

</script>
</head>


<body onload="document.forms[0].strCrNo.focus();getReport();">

<html:form action="/transactions/ReturnFromTransCNTNEW.cnt" name="returnFromTransBean" type="mms.transactions.controller.fb.ReturnFromTransFB" method="post">

<div class="errMsg" id="errMsg" 		style="font-size:18px"><bean:write name="returnFromTransBean" property="strErr" /></div>
<div class="warningMsg" id="warningMsg" style="font-size:18px"><bean:write name="returnFromTransBean" property="strWarning" /></div>
<div class="normalMsg" id="normalMsg" 	style="font-size:18px"><bean:write name="returnFromTransBean" property="strMsg" /></div>

<div class="container-fluid">
	<div class="prescriptionTile">
		
		<div class="row" id="saveId">
			<div class="col-sm-6" style="text-align: initial;">
				<div class="col-sm-5">
					<p class="subHeaders">
							<i class="fas fa-file-alt" style="font-size: 20px; color: #28a745" ></i>
						&nbsp;Return From Patient
					</p>
				</div>
			</div>
		
			<div class="col-sm-6" id="">
				<div class="legend2" id='nonPrintableLegend2'>
					<button type="button" class="float-right btn btn-danger mt-1 btn-circle cancelbtn" onclick="cancelFunc();" title="Cancel">
						<i class="fas fa-times iround" title="Cancel"></i>
					</button>
					
					<button type="button"  class="float-right btn btn-primary mt-1 btn-circle " onclick="transferToViewPage();" title="Click Here To View Off Line Issue Item Detail" >
						<i class="fas fa-eye iround" title="View"></i>
					</button>
				</div>
			</div>	
		</div>
	
	<div class="container">
		<div class="row" style="margin:1% 1%">
			<div class="col-sm-2 "><font color="red">*</font>Store Name</div>
			<div class="col-sm-3">
				<select name="strStoreId"  onchange="itemCategoryCombo();"
						id="strStoreId" class='browser-default custom-select'>
						<!-- <option value="0">Select Value</option> -->
					<bean:write name="returnFromTransBean" property="strStoreNameCombo" filter="false" />
				</select>
			</div>
			
			<div class="col-sm-1"><font color="red">*</font>Item Category</div>
			<div class="col-sm-2">
				<div id='itemCategoryId'>
					<select name="strItemCategoryNo"
						id="strItemCategoryNo" class='browser-default custom-select'>
						<option value="10">Drug</option>
					</select>
				</div>
			</div>
			
			<div class="col-sm-1"><font color="red">*</font>CR No.</div>
			<div class="col-sm-3"><crNo:crNo value="${returnFromTransBean.strCrNo}" js=" onkeypress='return initGoFunc(event);'"></crNo:crNo></div>
		</div>
		<hr>
		<div class="row my-4"  style="margin:1% 1%">
			<div class="col" align="center"> 
				<a class="btn btn-sm btn-success" href="#" onclick="return goFunc();" onkeyup="goFuncOnEnter(event);" style="font-size:1rem;">
					GO 
					<i class="fas fa-angle-double-right"></i>
				</a>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 text-right"  id="">
		 		<i class="fas fa-asterisk" style="color: red; font-size: smaller;margin-top: 5px;"></i>Fields Mandatory
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
	
	<input type="hidden" name="hmode" />
	<input type="hidden" name="storeName" value="${returnFromTransBean.storeName}" />
	<input type="hidden" name="itemCatName" value="${returnFromTransBean.itemCatName}" />
	<input type="hidden" name="crNo" value="${returnFromTransBean.crNo}" />
	<input type="hidden" name="strId" value="${returnFromTransBean.strId}" />
	<input type="hidden" name="strConfCatCode" value="${returnFromTransBean.strConfCatCode}" />
	<input type="hidden" name="itemCategory" value="${returnFromTransBean.itemCategory}" />
	<input type="hidden" name="strMode"   value="${returnFromTransBean.strMode}">
	<input type="hidden" name="strIssueMode"   value="${returnFromTransBean.strIssueMode}">
	<input type="hidden" name="strReturnDrugValidity"   value="${returnFromTransBean.strReturnDrugValidity}">
	<input type="hidden" name="strReturnNo" value="${returnFromTransBean.strReturnNo}"/>

	
	</div>
</div>
</html:form>
<tag:autoIndex></tag:autoIndex>

<!-- <script type="text/javascript">

$('.datepicker').each(function(){
    $(this).datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
});
var today=new Date();
var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
var mmm=arr[today.getMonth()];
var hrs=today.getHours();
var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
$('.datepicker').val(dd);

</script> -->
</body>
</html>

