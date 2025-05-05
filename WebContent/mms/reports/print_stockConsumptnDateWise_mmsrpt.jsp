 <%@ page language="java" contentType="text/html;" pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<!-- 
/**
 * @author Amit Kumar
 * Date of Creation : 05/5/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
 -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Stock In Hand Report on Given Date</title>
<link href="../../hisglobal/css/dwh.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/control.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
            
<script language="JavaScript" src="../../hisglobal/jquery/3.6.0.min.js"></script>         
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/fixedHeaderReport.js"></script>
<script language="JavaScript" src="../../hisglobal/js/commonFunctions.js"></script>
<script language="JavaScript" src="../js/mms.js"></script>
<script language='Javascript' src='../../hisglobal/js/innerxhtml.js'></script>
<script language='Javascript' src='../../mms/js/stockConsumptionDateWise_mmsrpt.js'></script>
	
		
<script type="text/javascript">
function cancelPrintToDesk()
{
     document.forms[0].hmode.value="INITIALDATA";
     document.forms[0].submit();   
  
} 

function generateReportExcel(e) 
{	
	var itemObj = document.getElementById("indentItemListDivId");	
     //alert(document.forms[0].strTableWidth.value);
    var tblObj = document.getElementById("mstHeaderTable");
	  	tblObj.width = document.forms[0].strTableWidth.value + "%";
    
	document.execCommand('Saveas'); 
    //alert(itemObj.innerHTML);
	if (itemObj.innerHTML != "") 
	{
		//window.open('data:application/vnd.ms-excel,' + $('#issueDtlsDivId').html());
		//window.open('data:application/vnd.ms-excel,' + innerXHTML(itemStockObj));
		//window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#indentItemListDivId').html()));
		
		var uri = 'data:application/vnd.ms-excel,'+ encodeURIComponent($("#" + dataDivId + "").html());

		var downloadLink = document.createElement("a");
		downloadLink.href = uri;
		
		var reportName = 'Data';
		
		if(document.title != null && document.title !="") {
			reportName = document.title;
		}
		
		downloadLink.download = reportName+".xls";
		
		document.body.appendChild(downloadLink);
		downloadLink.click();
		document.body.removeChild(downloadLink);		
		
		e.preventDefault();
	    document.forms[0].hmode.value = "GETREPORTXLS";
	    document.forms[0].submit();          
	   	    
		/*var hmode = "GETREPORTXLS";
		var url = "AnnualDemandIndentCNT.cnt?hmode=" + hmode + "&strReqNo=" + document.forms[0].strReqNo.value
		+ "&strReqTypeId=" + document.forms[0].strReqTypeId.value + "&strStoreId=" + document.forms[0].strStoreId.value
		+ "&strToStoreId=" + document.forms[0].strToStoreId.value + "&strItemCategoryNo=" + document.forms[0].strItemCategoryNo.value;
		ajaxFunction(url, "5");*/
		
	} else {
		// set for 1024 * 760 screen don't change this
		alert("No data to convert in Excel format!");
	}
}
</script>
</head>
<body class="background" onload="OnLoadFunction();">
 <!-- for page loding start-->
	<div id="mask" style="display:block;"></div>
	<div id="dvLoading" style="display:block;"></div>
<!-- for page loding end-->
<html:form action="/reports/ConsumptionDetailRptCNT_NEW" method="post" styleClass="formbg">
<div id="indentItemListDivId">
  <table width='100%' align="center" border="0" cellspacing ="1px" id='mstTable'>
       <bean:write	name="ConsumptionDetailBean" property="strIndentItemList" filter="false" />
  </table>
</div>   
<input type="hidden" name="hmode" />
<input type="hidden" name="strTableWidth"   	value="${ConsumptionDetailBean.strTableWidth}">
<input type="hidden" name="strHtmlCode" value=""/>
<cmbPers:cmbPers />
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>