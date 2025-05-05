<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<title>Purchase Order Desk Print</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/dwh.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">

<script language="Javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script language="Javascript" src="../../hisglobal/js/innerxhtml.js"></script>
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<!-- <script language="Javascript" src="../../mms/js/PODeskPrint.js"></script> -->


<script>

function closePopup()
{

	document.forms[0].hmode.value = "CANCELTODESK";	
	//document.forms[0].target= "_blank";
	document.forms[0].submit();
}


// function printDataMain() 
// {
// 	newwin = window.open('', 'printwin',
// 			'left=100,top=100,width=700,height=700,scrollbars=yes');
// 	newwin.document.write('<HTML><HEAD>');
// 	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
// // 	newwin.document
// // 			.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n');
// 	newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } @media screen and (orientation: portrait) {  #toolbar { width: 100%; }} </style>\n');
// 	newwin.document.write('<script>\n');
// 	newwin.document.write('function chkstate(){ \n');	
// 	newwin.document.write('window.close();\n');	
// 	newwin.document.write('}\n');
// 	newwin.document.write('function print_win(){\n');
// 	newwin.document.write('window.print();\n');
// 	newwin.document.write('chkstate();\n');
// 	newwin.document.write('}\n');

// 	newwin.document.write('<\/script>\n');
// 	newwin.document.write('</HEAD>\n');
// 	newwin.document.write('<BODY onload="print_win()">\n');	
// 	newwin.document.write(document.getElementById("poReportDivId").innerHTML);	
// 	newwin.document.write('</BODY>\n');
// 	newwin.document.write('</HTML>\n');
// 	newwin.document.close();

// }



function printDataMain() {
    const contentToPrint = document.getElementById("prescriptionTile").cloneNode(true);
    const newWin = window.open('', '', 'width=700,height=700,scrollbars=yes');
    newWin.document.write('<html><head>');
    newWin.document.write('<style type="text/css">');
    newWin.document.write('.hidecontrol { display: none; }');
    newWin.document.write('@media print {');
    newWin.document.write('  #toolbar { display: none; }');
    newWin.document.write('  body { margin: 0; padding: 0; }');
    newWin.document.write('  @page { margin: 4mm 3mm; size: A4 portrait; }');
    newWin.document.write('  table { table-layout: fixed; width: 100%; }');
    newWin.document.write('  table td { word-wrap: break-word; font-size: 12px; }');
    // Define page break rules for the repeat-table class
	// NewWin.document.write('.repeat-table { page-break-before: always; }');
    newWin.document.write('}');
    newWin.document.write('</style>');
    newWin.document.write('</head><body>');
    newWin.document.write(contentToPrint.outerHTML);
    newWin.document.write('</body></html>');
    newWin.document.close();
    newWin.onload = function () {
        newWin.print();
        newWin.close();
    };
}



// function printDataMain1() {
//     var divContents = document.getElementById("poReportDivId").innerHTML;
//     var a = window.open('', '', 'height=500, width=500');
//     a.document.write('<html>');
//     a.document.write('<body > <h1>Div contents are <br>');
//     a.document.write(divContents);
//     a.document.write('</body></html>');
//     a.document.close();
//     a.print();
// } 
</script>

</head>
<body>
<html:form action="/transactions/PODeskPrintTransCNT">

	 <center>
		<div id="errMsg" class="errMsg" style="font-size:18px;">
			<bean:write name="poPrintBean" property="strErr" />
		</div>
		<div id="warningMsg" class="warningMsg" style="font-size:18px;">
			<bean:write name="poPrintBean" property="strWarning" />
		</div>
		<div id="normalMsg" class="normalMsg" style="font-size:18px;">
			<bean:write name="poPrintBean" property="strMsg" />
		</div>
	</center> 
	
	<div id='poReportDivId' >
			<bean:write name="poPrintBean" property="strPoHlp" filter="false" />
	</div>	
		
	<input type="hidden" name="hmode" value="">
	<input type="hidden" name="strHtmlCode" value="">	
	<input type="hidden" name="strChk" value="${poPrintBean.strChk}"> 
	
	<cmbPers:cmbPers />
	
</html:form>

<tag:autoIndex></tag:autoIndex>  
</body>
</html>