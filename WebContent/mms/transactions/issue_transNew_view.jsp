<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>

<html>
<head>
<meta charset=UTF-8">
<title>Return from Patient</title>

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
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>

<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/mms.js"></script>
<script language="Javascript" src="../js/issue_transBS.js"></script>

<script type="text/javascript">
	function controlToMainPage()
	{	    
		document.forms[0].hmode.value="unspecified";
		document.forms[0].submit();
	}
</script>

<style>
body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 14px;
	line-height: 1.42857143;
	color: rgba(0, 0, 0, 1);
	font-weight: 501;
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
.table {
	width: 100%;
	margin-bottom: 1rem;
	color: rgba(0, 0, 0, 1);
	border-collapse: separate;
}
.table th, .table td {
	padding: 0.05rem;
	border-top: 0px solid #dee2e6;
}
.table .thead-dark {
  	color: #fff !important;
  	border: none !important;
  	background:linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;
  	align:center;
}
.thead-dark th{
	background:none !important;
	border: none !important;	
	align:center;
}
</style>


</head>
<body onLoad="checkMsg();">
<!-- RJ47 -->


<html:form name="issueBean" action="/transactions/IssueToPatientTransBSCNT" type="mms.transactions.controller.fb.IssueTransFB">

<div class="errMsg"     id="errMsg">       <bean:write name="issueBean" property="strErrMsg"/></div>
<div class="warningMsg" id="warningMsg">   <bean:write name="issueBean" property="strWarningMsg"/></div>
<div class="normalMsg"  id="normalMsg">    <bean:write name="issueBean" property="strNormalMsg"/></div>


<div class="container-fluid">
	<div class="prescriptionTile">	
		<div class="row">
			<div class="col-sm-6" style="text-align: initial;">
				<div class="col-sm-5">
					<p class="subHeaders">
							<i class="fas fa-file-alt" style="font-size: 20px; color: #28a745" ></i>
						&nbsp;IPD Issue To Patient
					</p>
				</div>
			</div>
			<div class="col-sm-6" id="">
				<div class="legend2" id='nonPrintableLegend2'>
					<button type="button" onclick="controlToMainPage();" class="float-right btn btn-danger mt-1 btn-circle cancelbtn">
						<i class="fas fa-times iround" title="Cancel"></i>
					</button>
				</div>
			</div>
		</div>
		
		<div class="container">
			<div class="row my-1" style="margin:1% 5%" >
				<div class="col-md-2 "><font color="red">*</font>Store Name:</div>
				<div class="col-md-4"> 
					<!-- <select name="strStoreName" class="browser-default custom-select"   onChange="getItemCategoryCombo();"> -->
					<select name="strStoreId" class="browser-default custom-select"   onChange="">
						<bean:write name="issueBean" property="strStoreName" filter="false"/>
			       </select>
			    </div>
			    
			    <div class="col-md-2"><font color="red">*</font>CR NO:</div>
			    <div class="col-md-4">
				    <div id="ItemCatg" >
				      <%--  <select class='browser-default custom-select' name='strItemCatgCombo'> 
				           <bean:write name="issueBean" property="strItemCatgCombo" filter="false"/>
				       </select> --%>
				       <input type="text" class="form-control" name="strCrNo" value ="${issueBean.strHospitalCode}"	onkeypress="return validateData(event,18);" maxlength="15">
					</div>
			    </div>
			</div>

			<div class="row my-1" style="margin:1% 5%">
				<div class="col-md-2 "><font color="red">*</font>From Date</div>
				<div class="col-md-4">
					<input  name="strFromDate" class="form-control datepicker" value="${issueBean.strFromDate}" style="color: rgba(113, 111, 111, 0.87);"> 
				</div>
		       	<div class="col-md-2"><font color="red">*</font>To Date</div>
		       	<div class="col-md-4">
		       		<input  name="strToDate" class="form-control datepicker" value="${issueBean.strToDate}" style="color: rgba(113, 111, 111, 0.87);">    	
		       	</div>
		   </div> 
     
		   <div class="row my-4" >
	     	  <div class=" col-sm-12" align="center"> <a class="btn btn-sm btn-success"  href="#" onclick="getViewItemDtl();" style="font-size:1rem;">GO <i class="fas fa-angle-double-right"></i></a></div>
	       </div>   
	       
	       <div class="row" id="FMid">
				<div class="col-sm-12 text-right">
			 		<i class="fas fa-asterisk" style="color: red; font-size: smaller;margin-top: 5px;"></i>Fields Mandatory
			 	</div>
			</div>		
			    
		</div>
		
	   <input type="hidden" name="hmode"/>
	   <input type="hidden" name="strIsView" value="1"/>
	   
	   <div align="center" id="breakageItemDtlId"></div> 
	   
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
<!-- RJ47 -->
</body>
</html>