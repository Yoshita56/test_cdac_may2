<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<html>
<head>
<meta charset=UTF-8">
<title>PO Desk</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet"
type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../mms/js/PODesk.js"></script>
<script language="Javascript" src="../../mms/js/POGenerateJS.js"></script>
<script>
function printDataOne() 
{
   
	newwin = window.open('', 'printwin',
			'left=100,top=100,width=850,height=800,scrollbars=yes');
	newwin.document.write('<HTML><HEAD>');
	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	newwin.document
			.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n')
	newwin.document.write('<script>\n');
	newwin.document.write('function chkstate(){ \n');
	// newwin.document.write('if(document.readystate=="complete" ||
	// document.readystate=="undefined"){\n');
	newwin.document.write('window.close();\n');
	// newwin.document.write('}\n');
	// newwin.document.write('else{\n');
	// newwin.document.write('setTimeout("chkstate()",2000)\n');
	// newwin.document.write('}\n');
	newwin.document.write('}\n');
	newwin.document.write('function print_win(){\n');
	newwin.document.write('window.print();\n');
	newwin.document.write('chkstate();\n');
	newwin.document.write('}\n');

	newwin.document.write('<\/script>\n');
	newwin.document.write('</HEAD>\n');
	newwin.document.write('<BODY onload="print_win()">\n');
	newwin.document.write(document.getElementById('giftedViewDetailsDivId').innerHTML);
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();

}


</script>
</head>
<body onload="">
<html:form action="/reports/PurchaseItemInventoryRptCNT" method="post">

<div class="errMsg" id="errMsg"><bean:write name="purchaseItemInventoryBean" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="purchaseItemInventoryBean" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="purchaseItemInventoryBean" property="strWarningMsg"/></div>


	<%-- <tag:tab tabLabel="Purchase Item Inventory" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab> --%>

	
	<div align="center" id="giftedViewDetailsDivId">
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" >   
					<bean:write name="purchaseItemInventoryBean" property="printReportDetails" filter="false" />	
		</table>		
    </div>
	
<input type="hidden" name="hmode"/>
<input type="hidden" name="strCurrentDate" value="${purchaseItemInventoryBean.strCurrentDate}"/>
<input type="hidden" name="strStoreName" value="${purchaseItemInventoryBean.strStoreName}" />

</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>