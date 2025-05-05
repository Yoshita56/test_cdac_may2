<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>

<html>
<head>
<meta charset=UTF-8">
<title>Insert Title Here</title>

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
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/mms.js"></script>
<script language="JavaScript" src="../js/OffLineIssueItemDtlNEW.js"></script>
<script language="Javascript" src="../js/issueDetails_utilNEW.js"></script> 

<script type="text/javascript">
	function controlToMainPage()
	{	    
		document.forms[0].hmode.value="unspecified";
		document.forms[0].submit();
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
}
.thead-dark th{
	background:none !important;
	border: none !important;	
}
	

</style>

</head>
<body>
<html:form action="/transactions/OfflineIssueIndentTransCNTNEW.cnt"  name="offlineIssueIndentBean" type="mms.transactions.controller.fb.OfflineIssueIndentTransFB" method="post">

<div class="errMsg"     id="errMsg"><bean:write name="offlineIssueIndentBean" property="strErr"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="offlineIssueIndentBean" property="strWarning"/></div>
<div class="normalMsg"  id="normalMsg"><bean:write name="offlineIssueIndentBean" property="strMsg"/></div>

<!-- <div class="viewport" id="nonPrintable"> -->
<div class="container-fluid">
	<div class="prescriptionTile">
				<div class="row">
					<div class="legend2" id='nonPrintableLegend2'>
						<button type="button" onclick="cancelFunc();" class="float-right btn btn-danger mt-1 btn-circle cancelbtn" style="border-radius:50%; padding:10px 11px;">
							<i class="fas fa-times iround" title="Cancel"></i>
						</button>
					</div>
				</div>

				<div class="row">
					<div class="col">
						<p class="h5 font-weight-normal mb-3">
								<i class="fas fa-file-alt iround" style="font-size: 20px; color: #28a745" title=""></i>
								&nbsp; Issue Register(Off-Line) View
							</p>
					</div>
				</div>
			<div class="container">
				<div class="row my-1" style="margin:1% 5%" >
					<div class="col-md-2 ">Store Name:<font color="red">*</font></div>
					<div class="col-md-4"> 
						<select name="strStoreName" class="browser-default custom-select"   onChange="getItemCategoryCombo();">
							<bean:write name="offlineIssueIndentBean" property="strStoreName" filter="false"/>
				       </select>
				    </div>
				    
				    <div class="col-md-2">Item Category:<font color="red">*</font></div>
				    <div class="col-md-4">
					    <div id="ItemCatg" >
					       <select class='browser-default custom-select' name='strItemCatgCombo'> 
					           <bean:write name="offlineIssueIndentBean" property="strItemCatgCombo" filter="false"/>
					       </select>
						</div>
				    </div>
				</div>

				<div class="row my-1" style="margin:1% 5%">
					<div class="col-md-2 ">From Date</div>
					<div class="col-md-4">
						<input  name="strFromDate" class="form-control datepicker" value="${offlineIssueIndentBean.strFromDate}" style="color: rgba(113, 111, 111, 0.87);"> 
					</div>
			       	<div class="col-md-2">To Date</div>
			       	<div class="col-md-4">
			       		<input  name="strToDate" class="form-control datepicker" value="${offlineIssueIndentBean.strToDate}" style="color: rgba(113, 111, 111, 0.87);">    	
			       	</div>
			   </div> 
      
			   <div class="row my-4" >
		     	  <div class=" col-sm-12" align="center"> <a class="btn btn-sm btn-success"  href="#" onclick="getViewItemDtl();" style="font-size:1rem;">GO <i class="fas fa-angle-double-right"></i></a></div>
		       </div>       
			</div>
	       <div align="center" id="breakageItemDtlId"></div> 
		   <input type="hidden" name="hmode"/>
		   <input type="hidden" name="strIsView" value="1"/>
 
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
</body>
</html>