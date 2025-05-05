<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=UTF-8">
<title>Issue To Patient Report</title>

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../js/mms.js"></script>

<script type="text/javascript">

	function printDataOne(mode) 
	{
		newwin = window.open('', 'printwin',
				'left=100,top=100,width=700,height=700,scrollbars=yes');
		newwin.document.write('<HTML><HEAD>');
		newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
		newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n')
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
		if(mode=='1')
		{
		  newwin.document.write(document.getElementById('printDtlsDivId').innerHTML);	  
		}
		newwin.document.write('</BODY>\n');
		newwin.document.write('</HTML>\n');
		newwin.document.close();

	}

	function cancelPage(mode) 
	{
		document.forms[0].hmode.value="unspecified";		
		document.forms[0].submit();
	}
	</script>
</head>

<body>

<html:form action="/reports/PendingIndentStatusRecordRptCNT" method="post">
	
<center>
<div class="errMsg" id="errMsg"><bean:write name="pendingIndentStatusRecordRpt" property="strErrMsg"/></div>
<div class="normalMsg" id="normalMsg"><bean:write name="pendingIndentStatusRecordRpt" property="strNormalMsg"/></div>
<div class="warningMsg" id="warningMsg"><bean:write name="pendingIndentStatusRecordRpt" property="strWarningMsg"/></div>

</center>	

	
	<div id="saveId" style="display : block"> <div id="printid1" class="hidecontrol" align="right">
	<img style="cursor: pointer; margin-right: 0px" title="Print Page"     src="../../hisglobal/images/printer_symbol.gif" onclick="printDataOne('1')"> 
	<img style="cursor: pointer; "                  title="Cancel Process" src="../../hisglobal/images/stop.png" 	       onclick="cancelPage('CANCELTODESK')"> </div> 
	</div>
	
	<div id = "printDtlsDivId"><bean:write name="pendingIndentStatusRecordRpt"	property="strPartialIssueDtls" filter="false" /></div>
	
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strStoreName" />
	<input type="hidden" name="strCategoryName" />		
	
	
<cmbPers:cmbPers />
</html:form>

</body>
</html>

