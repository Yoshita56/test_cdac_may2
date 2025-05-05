<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>


<html>
<head>
<title>Server Trace & Configuration</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
<link href="../../ipd/css/style.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
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

.card {
    margin-bottom: 1.875rem;
    border: none;
    border-radius: 0;
    box-shadow: 0;
}
.card {
    position: relative;
    display: -webkit-box;
    display: -webkit-flex;
    display: -ms-flexbox;
    display: flex;
    -webkit-box-orient: vertical;
    -webkit-box-direction: normal;
    -webkit-flex-direction: column;
    -ms-flex-direction: column;
    flex-direction: column;
    min-width: 0;
    background-clip: border-box;
    border: 1px solid rgba(0,0,0,.06);
    border-radius: .25rem;
}
.card:hover 
{
 box-shadow: 0;
} 
.card, .card-footer, .card-header {
    background-color: #FFF;
}
.card-body {
    -webkit-box-flex: 1;
    -webkit-flex: 1 1 auto;
    -ms-flex: 1 1 auto;
    flex: 1 1 auto;
    min-height: 1px;
    padding: 1.5rem;
}
.d-flex {
    display: -webkit-box !important;
    display: -webkit-flex !important;
    display: -ms-flexbox !important;
    display: flex !important;
}
.media {
    display: flex;
    -webkit-box-align: start;
    -webkit-align-items: flex-start;
    -ms-flex-align: start;
    align-items: flex-start;
}
.text-left {
    text-align: left !important;
}
.media-body {
    -webkit-box-flex: 1;
    -webkit-flex: 1;
    -ms-flex: 1;
    flex: 1;
}
</style>
</head>
<body onload="onLoadPage();checkMsg();">
<html:form action="/reports/ApplicationErrorLogDetailRptCNT" method="post">					
	
<div class="container-fluid">
<br>	
<div class="prescriptionTile">
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
</div>

						
<div class="alert alert-danger alert-dismissible fade show" id="errMsg"  style="display:none;"><bean:write name="applicationErrorLogDetailRptFB" property="strErrMsg"/></div>
<div class="alert alert-success alert-dismissible fade show" id="normalMsg" style="display:none;"><bean:write name="applicationErrorLogDetailRptFB" property="strNormalMsg"/></div>
<div class="alert alert-warning alert-dismissible fade show"  id="warningMsg" style="display:none;"><bean:write name="applicationErrorLogDetailRptFB" property="strWarningMsg"/></div>			  	
		
		<div class="row rowFlex reFlex">
			<div class="col-sm-3">
				<p class="subHeaders">
					<button type="button" class="btn btn-outline-success  btn-circle1"><i class="fas fa-server iround" title="Cancel"></i></button>&nbsp;Server Trace & Configuration
				</p>									
			</div>
			
			<div class="col-sm-3" align="right">				
				<a href="#" class="btn btn-info" onclick="showConfig('0');" id='serverSettings'><span class="fas fa-cog"></span> Server Configuration</a>
			</div>
			<div class="col-sm-2" align="right">
				<a href="#" class="btn btn-warning" onclick="showConfig('1');" id='hmisSettings'><span class="fas fa-user-cog"></span> HMIS Configuration</a>
			</div>								
			<div class="col-sm-2" align="right">
				<a href="#" class="btn btn-info" onclick="showConfig('2');" id='ftpSettings'><span class="fas fa-folder-plus"></span> FTP Configuration</a>
			</div>
			<div class="col-sm-2" align="right">
				<a href="#" class="btn btn-secondary" onclick="showConfig('3');" id='dbSettings'><span class="fas fa-database"></span> DB Configuration</a>
			</div>
		</div>
		<hr id='hr1' style="display: none;">
		<div class="row rowFlex reFlex" id='SysConfig' style="display: none;">
			<div class="col-sm-3" align="right"><span></span></div>
			<div class="col-sm-3" align="right">
				<span>Application Server Logs &nbsp;<input type="radio" name=strServerLogs value="0" onchange="showServerLogType(this);"/></span>
			</div>
			<div class="col-sm-3" align="right">
				<span>View Server Configuration-standalone.xml &nbsp;<input type="radio" name=strServerLogs value="1" onchange="showServerLogType(this);"/></span>
			</div>
			<div class="col-sm-3" align="right">
				<span>Deployed WAR Listing &nbsp;<input type="radio" name=strServerLogs value="2" onchange="showServerLogType(this);"/></span>
			</div>			
		</div>
		<hr id='hr2' style="display: none;">
		<div class="row rowFlex reFlex" id='hmisConfig' style="display: none;">
			<div class="col-sm-3" align="right"><span></span></div>
			<div class="col-sm-3" align="right">
				<span>View System Settings-hisPath.xml &nbsp;<input type="radio" name=strServerLogs value="3" onchange="showServerLogType(this);"/></span>
			</div>
			<div class="col-sm-3" align="right">
				<span>HMIS JAR Files &nbsp;<input type="radio" name=strServerLogs value="4" onchange="showServerLogType(this);"/></span>
			</div>								
			<div class="col-sm-3" align="right">
				<span>HMIS Module.xml  &nbsp;<input type="radio" name=strServerLogs value="5" onchange="showServerLogType(this);"/></span>
			</div>			
		</div>
		<hr id='hr3' style="display: none;">
		<div class="row rowFlex reFlex" id='hmisConfigBtn' style="display: none;">		
			<div class="col-sm-12" align="center">
				<button type="button" class="btn btn-primary btn-sm" id="viewIdhisPath" onclick='return viewhisPath();' style="display: none;">View</button>
			</div>			
		</div>
		<div class="row rowFlex reFlex" id='ftpConfig' style="display: none;">
			<div class="col-sm-1">
				<span>Test FTP  &nbsp;<input type="radio" name=strServerLogs value="7" onchange="showServerLogType(this);"/></span>
			</div>
			<div class="col-sm-2">
				<span>FTP Directory & Files &nbsp;<input type="radio" name=strServerLogs value="8" onchange="showServerLogType(this);"/></span>
			</div>
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
	<div id="errorLog">
		<hr>
		
	</div>								
	<div id="dbConfig" style="display: none;"></div>
	<hr id='hr4' style="display: none;">
    <div class="row rowFlex reFlex" style="display: none;">
    	<div class="col-sm-2" align="left"><i class="fas fa-asterisk" style="color: red; font-size: smaller;margin-top: 25px;"></i>Fields Mandatory</div>
		<div class="col-sm-10" align="right" id='rptbutton'>
		<img src="/HBIMS/hisglobal/images/html-png.png" id="htmlId" class="changeImg changeImgGray" alt="Html Report" onclick="selectFunction(1)" tabindex="0" selected="selected" style="display:none;pointer; width: 40px; color: #fff;" title="Html">&nbsp;&nbsp;&nbsp;
		<img src="/HBIMS/hisglobal/images/pdf-png.png" title="Pdf" id="pdfId" class="changeImg" alt="Acrobat Reader" onclick="selectFunction(0)" tabindex="0" style="display:none;cursor:pointer;width: 30px; color: #fff;"> &nbsp;&nbsp;&nbsp;
		<img src="/HBIMS/hisglobal/images/excel-png.png" title="Excel" id="excelId" class="changeImg" alt="Excel Report" onclick="selectFunction(2)" tabindex="0" style="display:none;cursor:pointer;width: 45px; color: #fff;"> 
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