<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<!-- RJ47 -->

<html>
<head>
<title>Issue Track Report</title>

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
</style>

<!-- CSS -->
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<!-- JS -->
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="Javascript" src="../../hisglobal/js/time.js"></script>

<!-- EXT JS -->
<script language="Javascript" src="/INVMGM/mms/js/issueTrack.js"></script>

<!-- JQuery -->
<script src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script src="/INVMGM/hisglobal/js/jquery.autocomplete.min.js"></script> 

<!-- BS Library  -->
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css"> 
<link href="/INVMGM/hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">

<!-- JS Library  -->
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/INVMGM/hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
<script language="JavaScript" src="../../hisglobal/js/newpopup.js"></script>

</head>

<body onload="onLoadPage();">

<html:form action="/reports/IssueTrackRptCNT" type="mms.reports.controller.fb.IssueTrackRptFB" name="IssueTrackRptBean" method="post">
	
<div class="errMsg" id="errMsg" style='font-size: 16px;'><bean:write name="IssueTrackRptBean" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg" style='font-size: 16px;'><bean:write name="IssueTrackRptBean" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg" style='font-size: 16px;'><bean:write name="IssueTrackRptBean" property="strWarningMsg"/></div>

<div class="container-fluid">
	<div class="prescriptionTile">
		
	<div class='legendHeader' style='font-size: 18px;font-weight: bold;'>
		<i aria-hidden="true" class="fa fa-clipboard"></i> &nbsp;Issue Tracking Details Report</div>
		
		<div class="row ">
			<div class="legend2" id='nonPrintableLegend2'>
				<button type="button" title="Cancel" id="cancelButton" class="float-right btn btn-danger mt-1 btn-circle btn-icon" style="border-radius:50%; padding:10px 12px" onclick="cancelFunc();">	
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-times" title="Cancel"></i>
					</div>
				</button>
				
				<!-- <button type="button" title="Clear" class="float-right btn btn-secondary mt-1 btn-icon " style="background-color: #2196f3; border-radius:50%; padding:10px 8px" onClick="document.forms[0].reset();">	
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-broom" title="Clear"></i>
					</div>
				</button>		 
				
				<button type="button" title="Reset" class="float-right btn btn-success mt-1 btn-circle btn-icon" style="border-radius:50%; padding:10px 10px" onclick="document.forms[0].reset();">
					<div class="popupToast">
						<i class="fas fa-redo" title="Reset"></i>
					</div>
				</button>  -->
 			</div>  
		</div>
		
		<div class="container">	
			<div class="row" style="margin: 1% 12%">
					<div class="col-sm-2"><label>Store Name<font color="red">*</font></label></div>
					<div class="col-sm-10">
						<select name="strStoreId" class='custom-select' onchange=""> 
							<bean:write name="IssueTrackRptBean" property="strStoreValues" filter="false" />
						</select>
					</div>
			</div>
		
			<div class="row " style="margin: 1% 12%">
				<div class="col-sm-2"><label>From Date<font color="red">*</font> </label></div>
				<div class="col-sm-4">
					<input name="strFromDate" id="datepicker1" class="form-control datepicker1" value="${IssueTrackRptBean.strCurrentDate}" />
		 		</div>
			
			
				<div class="col-sm-2"><label>To Date<font color="red">*</font> </label></div>
				<div class="col-sm-4">
					<input name="strToDate" id="datepicker2" class="form-control datepicker2" value="${IssueTrackRptBean.strCurrentDate}" />
				</div>
			</div>	
		</div>
		
		<hr>
		
		<div class="row my-2" style="margin:1% 12%">
  	 		 	<div class=" col-sm-12" align="center"> 
  	 		 		<a class="btn btn-sm btn-success"  href="#" onclick="getIssueTrackDtlRpt();" style="font-size:1rem;">GO <i class="fas fa-angle-double-right"></i></a>
  	 		 	</div>
    		</div>   

		<div class="row text-right">
			<div class="col-sm-12" id="mandatorydiv">
 					<i class="fas fa-asterisk" style="color: red; font-size: smaller;margin-top: 5px;"></i>Fields Mandatory
 				</div>
		</div>
		
		<input type="hidden" name="hmode"/>
		<input type="hidden" name="strEndFinancialYearTemp" value="${IssueTrackRptBean.strEndFinancialYearTemp}"/>
		<input type="hidden" name="strCurrentDate" value="${IssueTrackRptBean.strCurrentDate}"/>
		<input type="hidden" name="strStoreName" value=""/>
	
		<div align="center" id="issueTrackRpt" style='display:none;'></div>
		
		<div id='footerid' style='display:none;'>
			<br>
			<div align='center'>[<font><span style='color:#f3bdbd;'><i class='fas fa-certificate' ></i></span>&nbsp;Below 40%</font>] [<font><span style='color:#ffd382;'><i class='fas fa-certificate' ></i></span>&nbsp;40% to 70%</font>] [<font><span style='color:#91c091;'><i class='fas fa-certificate' ></i></span>&nbsp;70% to 100%</font>]</div>
			<br>
			<div class='footer' align="center">This is System Generated Report. No Signature is Required.</div>
		</div>
		
		<div class="modal fade bd-example-modal-lg" id="issueDtlModal">
			<div class="modal-dialog modal-lg">
				<div class="modal-content"> 
					 <!-- <div class="modal-header" style="background-image: linear-gradient(to right,#49B2F3, #02629C);"> -->
						<div class="modal-header">
		    				<h4 class="modal-title text-left" style="color: white;">Issue Track Details</h4>
		         			 <div align="right" >
								<button type="button" class="btn btn-primary" onclick="printDataOne(2)"><i class="fas fa-print" title="Print"></i></button>
								<!-- <button type="button" class="btn btn-primary" onclick="goBack()"><i class="fas f-back" title="Print"></i></button> -->
								<button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fas fa-times" title="Cancel"></i></button>
								<!-- <button type="button" class="close" data-dismiss="modal">&times;</button> -->
								<!-- <button type="button" class="close" data-dismiss="modal" style="visibility: hidden;"> × </button> -->
							</div>
	       			 	</div>
						<div class="modal-body">
							<div id="issueDtl" class="table-responsive"></div>
							
							
		       				</div>
						</div>
				</div>
			</div>
			
		</div> 
      

	</div>
</div>

</html:form>

 <script type="text/javascript">
    $('#datepicker1').datepicker({modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
    $('#datepicker2').datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
    var today=new Date();
    var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
    var mmm=arr[today.getMonth()];
    var hrs=today.getHours();
    var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
    $('#datepicker1').val(dd);
    $('#datepicker2').val(dd);
</script>

<!--  <div id="blanket" style="display:none;"></div>
 <br>
 <div class="popUpDiv" id="popUpDiv" style="display:none;">
	<table bgcolor="white">
	     <tr>
	      <td>
	           <div id="issueDtlsDivId" style="display:block;"></div>
	       </td>
	     </tr>
	  </table>
</div> -->

<tag:autoIndex></tag:autoIndex>
<!-- RJ47 -->
</body>
</html>