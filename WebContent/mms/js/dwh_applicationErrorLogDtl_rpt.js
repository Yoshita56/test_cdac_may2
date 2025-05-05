
function validate()
{

		var hisValidator = new HISValidator("applicationErrorLogDetailRptFB");


		hisValidator.addValidation("strFromDate", "date","From Date is a mandatory field");
		hisValidator.addValidation("strToDate", "date","To Date is a mandatory field");
		hisValidator.addValidation("strToDate","dtltet="+document.forms[0].strCurrentDate.value,"Please Select To Date Less Than or Equal To Current Date");
		hisValidator.addValidation("strToDate","dtgtet="+document.forms[0].strFromDate.value,"Please Select To Date Greater Than Or Equal To From Date");
		
	
	
	var retVal = hisValidator.validate();
	hisValidator.clearAllValidations();
	
	
	if(retVal)
	{
		document.forms[0].hmode.value = "SHOWRPT";
		
		if(document.forms[0].strReportFormat[document.forms[0].strReportFormat.selectedIndex].value == "html")
		{
			document.forms[0].target = "_self";
		}
		else
		{
			document.forms[0].target = "_blank";
		}
			document.forms[0].submit();
		}
		else
		{
			return false;
		}
	}

function onLoadPage()
{
	
}

function onClearPage()
{
	//document.forms[0].strFromDate.value = document.forms[0].strCurrentDate.value ;
	//document.forms[0].strToDate.value = document.forms[0].strCurrentDate.value ;
	document.forms[0].hmode.value="init";
	document.forms[0].target = "_self";
	document.forms[0].submit();
}

function cancelPage()
{
	document.forms[0].hmode.value="CANCEL";
	document.forms[0].target = "_self";
	document.forms[0].submit();
}

function viewServerLog()
{
	var retVal = true;
	if(retVal)
	{
		document.forms[0].hmode.value="SHOWSERVERLOG";
		document.forms[0].target = "_blank";
		document.forms[0].submit();
	}
}
function viewhisPath()
{
	var retVal = true;
	document.forms[0].hmode.value="VIEWHISPATH";
	
	//alert(document.forms[0].strServerLogs.value);
	if(document.forms[0].strServerLogs.value=="1")//standalone.xml
		document.forms[0].hmode.value="VIEWSTANDALONE";
	if(document.forms[0].strServerLogs.value=="2")//Deployed WAR
		document.forms[0].hmode.value="VIEWWAR";
	if(document.forms[0].strServerLogs.value=="3")//hisPath.xml
		document.forms[0].hmode.value="VIEWHISPATH";
	if(document.forms[0].strServerLogs.value=="4")//HMIS JAR
		document.forms[0].hmode.value="VIEWJAR";
	if(document.forms[0].strServerLogs.value=="5")//HMIS Module.xml
		document.forms[0].hmode.value="VIEWMODULE";
	if(document.forms[0].strServerLogs.value=="6")//Hosp Mst Trigger
		document.forms[0].hmode.value="VIEWTRIGGER";
	//if(document.forms[0].strServerLogs.value=="8")//FTP Directory
	if(retVal)
	{
		document.forms[0].target = "_blank";
		document.forms[0].submit();
	}		
}
function showConfig(obj)
{
	document.getElementById("errorLog").style.display="none";
	document.getElementById("serverLog").style.display="none";
	document.getElementById("rptbutton").style.display="none";	
	document.getElementById("hr1").style.display="";	
	
	document.getElementById("hr4").style.display="none";
	
	/*if(obj.checked && obj.value=="0")
	{
		document.getElementById("SysConfig").style.display="";
		document.getElementById("hmisConfigBtn").style.display="none";
		document.getElementById("hmisConfig").style.display="none";
		document.getElementById("ftpConfig").style.display="none";
		document.getElementById("hr2").style.display="";
	}
	if(obj.checked && obj.value=="1")
	{
		document.getElementById("SysConfig").style.display="none";
		document.getElementById("hmisConfigBtn").style.display="";
		document.getElementById("hmisConfig").style.display="";
		document.getElementById("ftpConfig").style.display="none";
		document.getElementById("hr2").style.display="none";
		document.getElementById("viewIdhisPath").style.display="none";		
	}
	if(obj.checked && obj.value=="2")
	{
		document.getElementById("SysConfig").style.display="none";
		document.getElementById("hmisConfigBtn").style.display="none";
		document.getElementById("hmisConfig").style.display="none";
		document.getElementById("ftpConfig").style.display="";
		document.getElementById("hr2").style.display="none";
		document.getElementById("viewIdhisPath").style.display="none";
	}*/
	
	if(obj=="0")
	{
		document.getElementById("SysConfig").style.display="";
		document.getElementById("hmisConfigBtn").style.display="none";
		document.getElementById("hmisConfig").style.display="none";
		document.getElementById("ftpConfig").style.display="none";
		document.getElementById("hr2").style.display="";
		document.getElementById("serverSettings").className="btn btn-info active";
		document.getElementById("hmisSettings").className="btn btn-warning";
		document.getElementById("ftpSettings").className="btn btn-info";
		document.getElementById("dbConfig").style.display="none";
	}
	if(obj=="1")
	{
		document.getElementById("SysConfig").style.display="none";
		document.getElementById("hmisConfigBtn").style.display="";
		document.getElementById("hmisConfig").style.display="";
		document.getElementById("ftpConfig").style.display="none";
		document.getElementById("hr2").style.display="none";
		document.getElementById("viewIdhisPath").style.display="none";	
		document.getElementById("hmisSettings").className="btn btn-warning active";
		document.getElementById("serverSettings").className="btn btn-info";
		document.getElementById("ftpSettings").className="btn btn-info";
		document.getElementById("dbConfig").style.display="none";
	}
	if(obj=="2")
	{
		document.getElementById("SysConfig").style.display="none";
		document.getElementById("hmisConfigBtn").style.display="none";
		document.getElementById("hmisConfig").style.display="none";
		document.getElementById("ftpConfig").style.display="";
		document.getElementById("hr2").style.display="none";
		document.getElementById("viewIdhisPath").style.display="none";
		document.getElementById("ftpSettings").className="btn btn-info active";
		document.getElementById("hmisSettings").className="btn btn-warning";
		document.getElementById("serverSettings").className="btn btn-info";
		document.getElementById("dbConfig").style.display="none";
	}
	if(obj=="3")
	{
		
		document.getElementById("SysConfig").style.display="none";
		document.getElementById("hmisConfigBtn").style.display="none";
		document.getElementById("hmisConfig").style.display="none";
		document.getElementById("ftpConfig").style.display="none";
		document.getElementById("hr2").style.display="none";
		document.getElementById("viewIdhisPath").style.display="none";
		document.getElementById("ftpSettings").className="btn btn-info";
		document.getElementById("hmisSettings").className="btn btn-warning";
		document.getElementById("serverSettings").className="btn btn-info";
		document.getElementById("dbSettings").className="btn btn-secondary active";
		
		var hmode = "GETDBDATA";
		var url = "ApplicationErrorLogDetailRptCNT.cnt?hmode="+hmode;
		ajaxFunction(url,"1");
	}
	
}
function showServerLogType(obj)
{
	if(obj.checked && obj.value=="0")//App Server Log
	{
		document.getElementById("serverLog").style.display="";
		document.getElementById("errorLog").style.display="none";
		document.getElementById("generateId").style.display="none";
		document.getElementById("viewId").style.display="";
		document.getElementById("viewIdhisPath").style.display="none";
		//document.getElementsByName("strServerLogs")[0].checked=false;
		//document.getElementsByName("strServerLogs")[2].checked=false;
		document.getElementById("testFTPId").style.display="none";
		document.getElementById("rptbutton").style.display="none";
	}
	else if(obj.checked && obj.value=="1")//Standalone.xml
	{
		document.getElementById("serverLog").style.display="none";
		document.getElementById("errorLog").style.display="none";
		document.getElementById("generateId").style.display="none";
		document.getElementById("viewId").style.display="none";
		document.getElementById("hmisConfigBtn").style.display="";
		//document.getElementById("hr3").style.display="";
		document.getElementById("viewIdhisPath").style.display="";
		//document.getElementsByName("strServerLogs")[1].checked=false;
		//document.getElementsByName("strServerLogs")[2].checked=false;
		document.getElementById("testFTPId").style.display="none";
		document.getElementById("rptbutton").style.display="none";
	}	
	else if(obj.checked && obj.value=="2")//Deployed WAR
	{
		document.getElementById("serverLog").style.display="none";
		document.getElementById("errorLog").style.display="none";
		document.getElementById("generateId").style.display="none";
		document.getElementById("viewId").style.display="none";
		document.getElementById("hmisConfigBtn").style.display="";
		//document.getElementById("hr3").style.display="";
		document.getElementById("viewIdhisPath").style.display="";
		//document.getElementsByName("strServerLogs")[0].checked=false;
		//document.getElementsByName("strServerLogs")[1].checked=false;
		document.getElementById("testFTPId").style.display="none";
		document.getElementById("rptbutton").style.display="none";
	}
	else if(obj.checked && obj.value=="3" || obj.checked && obj.value=="4" || obj.checked && obj.value=="5" || obj.checked && obj.value=="6")// 3-hisPath, 4-HMIS JAR,5-HMIS Module.xml,6-HospMstTrigger
	{
		document.getElementById("serverLog").style.display="none";
		document.getElementById("errorLog").style.display="none";
		document.getElementById("generateId").style.display="none";
		document.getElementById("viewId").style.display="none";
		document.getElementById("hmisConfigBtn").style.display="";
		document.getElementById("hr3").style.display="";
		document.getElementById("viewIdhisPath").style.display="";
		//document.getElementsByName("strServerLogs")[0].checked=false;
		//document.getElementsByName("strServerLogs")[1].checked=false;
		document.getElementById("testFTPId").style.display="none";
		document.getElementById("rptbutton").style.display="none";
	}
	else if(obj.checked && obj.value=="7")//7-Test FTP,8-FTP Directory
	{
		document.getElementById("serverLog").style.display="none";
		document.getElementById("errorLog").style.display="none";
		document.getElementById("generateId").style.display="none";
		document.getElementById("viewId").style.display="none";
		document.getElementById("hmisConfigBtn").style.display="";
		document.getElementById("hr3").style.display="none";
		document.getElementById("viewIdhisPath").style.display="none";
		//document.getElementsByName("strServerLogs")[0].checked=false;
		//document.getElementsByName("strServerLogs")[1].checked=false;
		document.getElementById("testFTPId").style.display="";
		document.getElementById("viewFTPId").style.display="none";
		document.getElementById("rptbutton").style.display="none";
	}
	else if(obj.checked && obj.value=="8")//7-Test FTP,8-FTP Directory
	{
		document.getElementById("serverLog").style.display="none";
		document.getElementById("errorLog").style.display="none";
		document.getElementById("generateId").style.display="none";
		document.getElementById("viewId").style.display="none";
		document.getElementById("hmisConfigBtn").style.display="";
		document.getElementById("hr3").style.display="none";
		document.getElementById("viewIdhisPath").style.display="none";
		//document.getElementsByName("strServerLogs")[0].checked=false;
		//document.getElementsByName("strServerLogs")[1].checked=false;
		document.getElementById("testFTPId").style.display="none";
		document.getElementById("viewFTPId").style.display="";
		document.getElementById("rptbutton").style.display="none";
	}
	else
	{
		document.getElementById("serverLog").style.display="none";
		document.getElementById("errorLog").style.display="";
		document.getElementById("generateId").style.display="";
		document.getElementById("viewId").style.display="none";
		document.getElementById("viewIdhisPath").style.display="none";
		document.getElementById("testFTPId").style.display="";
		document.getElementById("rptbutton").style.display="";
	}
	
}

function testFTP()
{
	document.forms[0].hmode.value="CHECKFTPCONNECTION";	
	document.forms[0].target = "_self";
	document.forms[0].submit();
}
function selectFunction(a) {
    var printStr = document.getElementById("reportTypeId").options[0].value
 	document.getElementById("reportTypeId").selectedIndex = a;
 	 if(a == 0){
 		$("#pdfId").addClass("changeImgGray");
 		$("#htmlId").removeClass("changeImgGray");
 		$("#excelId").removeClass("changeImgGray");
 	}
 	else if(a == 1) {
 		$("#htmlId").addClass("changeImgGray");
 		$("#pdfId").removeClass("changeImgGray");
 		$("#excelId").removeClass("changeImgGray");
    }
 	else {
 		$("#excelId").addClass("changeImgGray");
 		$("#pdfId").removeClass("changeImgGray");
 		$("#htmlId").removeClass("changeImgGray");
    } 
}
function viewFTP()
{
	document.forms[0].hmode.value="VIEWFTPFILES";	
	document.forms[0].target = "_blank";
	document.forms[0].submit();
}
function checkMsg() 
{
	console.log("A");
	var err=document.getElementById("errMsg");
	var nor=document.getElementById("normalMsg");
	var warn=document.getElementById("warningMsg");
	if (err.innerHTML != "") {
		
		err.innerHTML="<i class='fas fa-exclamation-triangle'></i>"+"&nbsp;&nbsp;&nbsp;"+err.innerHTML+"<button type='button' class='close' data-dismiss='alert'>&times;</button>";
		err.style.display = "";
		
	}
	console.log("B");
	if (nor.innerHTML != "") {
		nor.innerHTML="<i class='far fa-check-circle'></i>"+"&nbsp;&nbsp;&nbsp;<strong>Success!</strong>&nbsp;&nbsp;"+nor.innerHTML+"<button type='button' class='close' data-dismiss='alert'>&times;</button>";
		nor.style.display = "";
	}
	if (warn.innerHTML != "") {
		warn.innerHTML="<i class='fas fa-bell'></i>"+"&nbsp;&nbsp;&nbsp;<strong>Warning!</strong>&nbsp;&nbsp;"+warn.innerHTML+"<button type='button' class='close' data-dismiss='alert'>&times;</button>";
		warn.style.display = "";
	}

}

function getAjaxResponse(res , mode) 
{
	if(mode == '1')
	{
		var objEle = document.getElementById("dbConfig");
		objEle.innerHTML=res;
		document.getElementById("dbConfig").style.display="";
	}			
}