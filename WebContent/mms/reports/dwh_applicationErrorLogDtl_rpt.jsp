<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Application Error Log Detail</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<!-- <script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script> -->
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
	
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../js/dwh_applicationErrorLogDtl_rpt.js"></script>
<script language="Javascript" src="../../hisglobal/js/time.js" /></script>

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

</head>
<body onload="onLoadPage();checkMsg();">
<html:form action="/reports/ApplicationErrorLogDetailRptCNT" method="post">
	
<div class="alert alert-danger alert-dismissible fade show" id="errMsg"  style="display:none;"><bean:write name="applicationErrorLogDetailRptFB" property="strErrMsg"/></div>
<div class="alert alert-success alert-dismissible fade show" id="normalMsg" style="display:none;"><bean:write name="applicationErrorLogDetailRptFB" property="strNormalMsg"/></div>
<div class="alert alert-warning alert-dismissible fade show"  id="warningMsg" style="display:none;"><bean:write name="applicationErrorLogDetailRptFB" property="strWarningMsg"/></div>			  	
		

<div class="container-fluid">
	<div class="prescriptionTile">		
	
	<div class="row">
		<p class="subHeaders"  style="font-size: 20px">
				<i class="fas fa-file-alt iround" style="font-size: 20px; color: #28a745" title=""></i>
				&nbsp;Application Error Logs
		</p>
	</div>
		
	<div class="row ">
			<div class="legend2" id='nonPrintableLegend2'>
				<button type="button" title="Cancel" class="float-right btn btn-danger mt-1 btn-icon "style="border-radius:50%; padding:12px 13px" onClick="cancelFunc();">	
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-times" title="Cancel"></i>
					</div>
				</button>
				
				<button type="button" title="Clear" class="float-right btn btn-secondary mt-1 btn-icon " style="background-color: #2196f3; border-radius:50%; padding:12px 9px" onClick="onClearPage();">	
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-broom" title="Clear"></i>
					</div>
				</button>		
				
				<button  type="button" title="Generate" id="generateId" class="float-right btn btn-success mt-1 btn-icon"  style="border-radius:50%; padding:12px 11px;" tabindex='2' onClick="return validate();"  data-toggle="" data-target="#previewModal" >
					<div class="popupToast" style="color: #fff;">
						<i class="fas fa-download" title="Generate"></i>
					</div>
				</button>
 			</div>  
	</div>
		
<!-- 			<div class="row rowFlex reFlex">
				<div class="col-sm-3">
					<p class="subHeaders">
						<button type="button" class="btn btn-outline-success  btn-circle1"><i class="fas fa-file-alt iround" title="Cancel"></i></button>&nbsp;Application Error Logs
					</p>									
				</div>
			</div>				

			<div class="row rowFlex reFlex">
						<div class="legend2" id='nonPrintableLegend2'>
							<button type="button"
								class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="cancelFunc();">
								<i class="fas fa-ban iround" title="Cancel"></i>
							</button>
							<button type="button" class=" btn btn-secondary btn-circle" onclick="onClearPage();" style="background: #b9b9b9; border-color: #b9b9b9; margin-top: 0.25rem !important;">
								<img src="/HIS/hisglobal/images/clear3.png" title="Clear"
									style="width: 23px; color: #fff;">
							</button>
							<button type="button" id="generateId" class="float-right btn btn-outline-default mt-1 btn-circle" tabindex='2' onClick="return validate();" style="background-color: #5cb85c;">
								<i class="fa fa-download iround" title="Generate"></i>
							</button>
						</div>
			</div> -->
				
		<hr id='hr1' style="display: none;">
			<div class="row rowFlex reFlex" id='SysConfig' style="display: none;"></div>
		<hr id='hr2' style="display: none;">
			<div class="row rowFlex reFlex" id='hmisConfig' style="display: none;"></div>
		<hr id='hr3' style="display: none;">
			<div class="row rowFlex reFlex" id='hmisConfigBtn' style="display: none;">		
				<div class="col-sm-12" align="center">
					<button type="button" class="btn btn-primary btn-sm" id="viewIdhisPath" onclick='return viewhisPath();' style="display: none;">View</button>
				</div>			
			</div>
			
			<div class="row rowFlex reFlex" id='ftpConfig' style="display: none;">
				<div class="col-sm-2" align="right">
					<button type="button" class="btn btn-primary btn-sm" id="testFTPId" onclick=' return testFTP();' style="display: none;">Test FTP</button>
				</div>			
				<div class="col-sm-2" align="right">
					<button type="button" class="btn btn-primary btn-sm" id="viewFTPId" onclick=' return viewFTP();' style="display: none;">View FTP Files</button>
				</div>
			</div>			
			
			<div class="row rowFlex reFlex" id="serverLog" style="display: none;">
				<div class="col-sm-2"><label>Application Server<font color="red">*</font></label></div>
				<div class="col-sm-3">
					<select name="strServerType" class='browser-default custom-select'>
						<option value="wildfly">Wildfly 16.0</option>					
						<option value="jboss">JBoss 6.1</option>
						<option value="tomcat7">Tomcat 7.0</option>
						<option value="tomcat8">Tomcat 8.0</option>
					</select>
				</div>				
				<div class="col-sm-2"><label>Log Type<font color="red">*</font></label></div>
				<div class="col-sm-3" >
					<select name="strServerLogType" class='browser-default custom-select'>
						<option value="server">server.log</option>
						<option value="boot">boot.log</option>					
					</select>
				</div>
				<div class="col-sm-2"><button type="button" class="btn btn-primary btn-sm" id="viewId" onclick='return viewServerLog();' style="display: none;">View Log</button></div>
			</div>
	<div class="container">			
			<div id="errorLog">
				<div class="row rowFlex reFlex" >
					<div class="col-sm-2"><label>Module<font color="red">*</font></label></div>
					<div class="col-sm-3"><select name="strModuleName" class='browser-default custom-select'><bean:write name="applicationErrorLogDetailRptFB" property="strModuleList" filter="false"/></select></div>
					<div class="col-sm-1"></div>
					<div class="col-sm-2"><label>Error ID<font color="red">*</font></label></div>
					<div class="col-sm-3" >
						<input type="text" name="strErrorId" class="form-control" maxlength="15" onkeypress="return validateData(event,5);">
					</div>
					<div class="col-sm-1"></div>
				</div>
				<div class="row mt-2">
					<div class="col-sm-2"><label>Whether Consolidated</label></div>
					<div class="col-sm-3 p-2"><input type="checkbox" name="strWhetherConsolidated" value="1" /></div>
				<%-- <div class="col-sm-2"><label>Footer Required</label></div>
				<div class="col-sm-2"><html:checkbox property="strIsFooter" name="applicationErrorLogDetailRptFB" value="1"></html:checkbox></div>
				 --%>
				 	<div class="col-sm-1"></div>
				 	<div class="col-sm-2"><label>User Remarks</label></div>
					<div class="col-sm-3"><input class="form-control" type="text" name="strUserRemarks"></div>
					<div class="col-sm-1"></div>
				</div>
				<div class="row rowFlex reFlex mt-2">
					<div class="col-sm-2"><label>From Date<font color="red">*</font> </label></div>
					<div class="col-sm-3"><input name="strFromDate" class="form-control datepicker" value="${applicationErrorLogDetailRptFB.strCurrentDate}" /></div>
					<div class="col-sm-1"> </div>		
					<div class="col-sm-2"><label>To Date<font color="red">*</font> </label></div>
					<div class="col-sm-3"><input name="strToDate" class="form-control datepicker" value="${applicationErrorLogDetailRptFB.strCurrentDate}" /></div>
					<div class="col-sm-1"> </div>		
				</div>
			</div>	
	</div>
<hr>			
			<div class="row text-right">
		    	<div class="col-sm-12">
		    		<i class="fas fa-asterisk" style="color: red; font-size: smaller;"></i>Fields Mandatory
		    	</div>
			</div>							
	
	   		<div class="row rowFlex reFlex">
	    	<!-- <div class="col-sm-2" align="right"><i class="fas fa-asterisk" style="color: red; font-size: smaller;margin-top: 25px;"></i>Fields Mandatory</div> -->
			
			
			<div class="col-sm-12" align="right" id='rptbutton'>
				<img src="/HBIMS/hisglobal/images/html-png.png" id="htmlId" class="changeImg changeImgGray" alt="Html Report" onclick="selectFunction(1)" tabindex="0" selected="selected" style="cursor:pointer; width: 40px; color: #fff;" title="Html">&nbsp;&nbsp;&nbsp;
				<img src="/HBIMS/hisglobal/images/pdf-png.png" title="Pdf" id="pdfId" class="changeImg" alt="Acrobat Reader" onclick="selectFunction(0)" tabindex="0" style="cursor:pointer;width: 30px; color: #fff;"> &nbsp;&nbsp;&nbsp;
				<img src="/HBIMS/hisglobal/images/excel-png.png" title="Excel" id="excelId" class="changeImg" alt="Excel Report" onclick="selectFunction(2)" tabindex="0" style="cursor:pointer;width: 45px; color: #fff;"> 
				<select name="strReportFormat" id="reportTypeId" class="form-control validatebox-text" style="display: none;">
					<option value="pdf">Acrobat Reader</option>
					<option value="html" selected="selected">HTML</option>
					<option value="excel">Excel</option>
				</select>
			</div>
			</div>

<input type="hidden" name="hmode"/>
<input type="hidden" name="strCurrentDate" value="${applicationErrorLogDetailRptFB.strCurrentDate}"/>

	</div>
</div>
</html:form>


<script type="text/javascript">
	
	$('.datepicker').each(function()
	{
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