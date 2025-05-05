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
<title>Local Purchase Print</title>

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
<!-- <script language="Javascript" src="../js/localpurchase_mmstrans.js"></script> -->
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

	function cancelPage(mode) {
		document.forms[0].hmode.value = mode;
		document.forms[0].submit();
	}
	</script>
	
<style>
.prescriptionTile {
	margin: 0.5% 0;
	border-bottom: 1px solid #d7d7d7;
	padding-bottom: 10px;
	padding: 1% 2% 0.5% 2%;
	background-color: #fff;
	transition: 0.5s;
	box-shadow: 0 0.5px 10px 2px #b0acac;
	border-radius: .25rem;
	color: rgba(0, 0, 0, 1);
}
</style>
</head>

<body>
<html:form name="localPurchaseNewTransBean" action="/transactions/LocalPurchaseNewTransCNT"
	type="mms.transactions.controller.fb.LocalPurchaseNewTransFB" enctype="multipart/form-data">
	
	<div class="errMsg" id="errMsg"><bean:write
		name="localPurchaseNewTransBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="localPurchaseNewTransBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="localPurchaseNewTransBean" property="strMsg" /></div>
	
	
<div class="container-fluid">
    	<div class="prescriptionTile" align="center">	
    	
   	<div id="saveId" style="display : block"> 
	   	<div id="printid1" class="hidecontrol" align="right">
			<img style="cursor: pointer; margin-right: 0px" title="Print Page" src="../../hisglobal/images/printer_symbol.gif"  
			onclick="printDataOne('1')"> 
			
			 <img style="cursor: pointer; " title="Cancel Process" src="../../hisglobal/images/stop.png" 
			onclick="cancelPage('CANCELTODESK')"> 
		</div> 
	</div>
	<!-- <a href="#"  onclick="printDataOne('1')">Print</a> -->
	
	<div id = "printDtlsDivId"><bean:write name="localPurchaseNewTransBean"
		property="strPrintDtls" filter="false" /></div>
		
	<input type="hidden" name="hmode" />
	
<cmbPers:cmbPers />
</div>
</div>
</html:form>

<tag:autoIndex></tag:autoIndex>

</body>
</html>

