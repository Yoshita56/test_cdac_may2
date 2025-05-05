<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Stock In Hand Record</title>

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css"
	rel="stylesheet">
<link href=".../../css/newlayout.css" rel="stylesheet" type="text/css">
<link
	href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css"
	rel="stylesheet" type="text/css">

<script type="text/javascript"
	src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
 
<link href="../css/master.css" rel="stylesheet" type="text/css">
  <link href="../../hisglobal/css/dwh.css" rel="stylesheet" type="text/css"> 
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
 
<script language="JavaScript" src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/autocompleteItemSearch.js"></script>

<!-- End additional plugins -->

<script type="text/javascript">
function cancelPrintToDesk()
{
     document.forms[0].hmode.value="unspecified";
     document.forms[0].submit();   
  
}


jQuery(document).ready(function()
{
   $("html").click(function(e){
   document.getElementById("xpos").value=e.pageX;
   document.getElementById("ypos").value=e.pageY;
   document.getElementById("xwpos").value=$(window).width();
   document.getElementById("ywpos").value=$(window).height();    
   }); 
})

	
	function generatePdfMain() 
	{	 
		
		var printImg = document.getElementById("printImg").innerHTML;	
		document.getElementById("printImg").innerHTML = "";
		var itemStockObj="";

		 
		     	   
			if(document.getElementById("indentItemListDivId") !=null)
			{
				
				itemStockObj = document.getElementById("indentItemListDivId");			
			}
			 		 	 

		//alert("itemStockObj.innerHTML: "+itemStockObj.innerHTML);

		if (itemStockObj.innerHTML != "") {

			//alert('Method Called');
			document.forms[0].strHtmlCode.value = innerXHTML(itemStockObj);
			
			document.forms[0].hmode.value = "generatePdf";
			document.forms[0].submit();
			document.getElementById("printImg").innerHTML = printImg;	

		} else {
			//document.forms[0].strIssueNo.value = '0';
			// set for 1024 * 760 screen don't change this
			alert("No data to convert in pdf format!");
		}
	}

	function generateReportExcel(e) 
	{	
		var itemObj = document.getElementById("indentItemListDivId");	
	    
		document.execCommand('Saveas'); 
	   
		if (itemObj.innerHTML != "") 
		{
			window.open('data:application/vnd.ms-excel,' + encodeURIComponent($('#indentItemListDivId').html()));
			e.preventDefault();
			
		} else {		
			alert("No data to convert in Excel format!");
		}
	}
	
	function printDataOne() 
	  {
		  var x = document.getElementById("printImg");
		  x.style.display = "none";
			
	  	newwin = window.open('', 'printwin','left=100,top=100,width=700,height=700,scrollbars=yes');
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
	  	newwin.document.write(document.getElementById('indentItemListDivId').innerHTML);
	  	newwin.document.write('</BODY>\n');
	  	newwin.document.write('</HTML>\n');
	  	newwin.document.close();
		  var x = document.getElementById("printImg");
		  x.style.display = "block";

	  }
	
	function generateXLSCommon(e, dataDivId) 
	{
		// document.forms[0].hmode.value = "getStockLedgerDtlXLS";
		// document.forms[0].submit();
		 
		var printImg = document.getElementById("printImg").innerHTML;
		document.getElementById("printImg").innerHTML = "";
		window.open('data:application/vnd.ms-excel,'
				+ encodeURIComponent($("#indentItemListDivId").html()));
		e.preventDefault();
		document.getElementById("printImg").innerHTML = printImg;

	}


	/**
	 * Prints the report.
	 * @return
	 */
	function printData() 
	{

		newwin = window.open('', 'printwin',
				'left=100,top=100,width=700,height=700,scrollbars=yes');
		newwin.document.write('<HTML><HEAD>');
		newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
		newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } @media screen and (orientation: portrait) {  #toolbar { width: 100%; }} </style>\n')
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
		newwin.document.write(document.getElementById('issueDtlsDivId').innerHTML);
		newwin.document.write('</BODY>\n');
		newwin.document.write('</HTML>\n');
		newwin.document.close();

	}

	function hideIssuePopup() 
	{	
		document.getElementById("issueDtlsDivId").innerHTML = "";
		hide_popup('popUpDiv');	
	}

	function cancelToDesk()
	{	
		document.forms[0].hmode.value="CANCEL";
		document.forms[0].submit();
	}

	function getVoucher(index) 
	{    
		//alert('1');
		
	   var strChk         = document.getElementById("strHiddenValue"+index).value;
	   
	  // alert('strChk--'+strChk);	   
	   var strReqTypeId   = strChk.split("@")[2];
	   
	  // alert('strReqTypeId--'+strReqTypeId);
		 
	   var mode="INDENTPRINT";
	   var url="LPReportsTransCNT.cnt?hmode="+mode+"&strChk="+ strChk+"&strReqTypeId="+strReqTypeId;
	   ajaxFunction(url,"1");
		 
	}


	function getAjaxResponse(res,mode)
	{
		  var err = document.getElementById("errMsg");
	      var temp = res.split("####");
	      if(temp[0] == "ERROR")
		  {
	          	err.innerHTML = temp[1];
	          	return;
	       } 
	      if(mode=="1")
	       {
	         
				var itemStockObj = document.getElementById("issueDtlsDivId");
				itemStockObj.innerHTML = res;			
				popup('popUpDiv', '220', '220');	
				
			}
	       
	}	
</script>

<style type="text/css">
.note {
	font-size: 0.8em;
}

.jqplot-yaxis-tick {
	white-space: nowrap;
}
.jqplot-point-label {
    color : white;       
}
.jqplot-event-canvas
{
cursor:pointer;
}

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
</style>

</head>
<body class="background" >
<!-- for page loding start-->
	<div id="mask" style="display:none;"></div>
	<div id="dvLoading" style="display:none;"></div>
<!-- for page loding end-->	

<html:form action="/reports/LPReportsTransCNT" method="post" styleClass="formbg">

	<div class="errMsg" id="errMsg"><bean:write name="localPurchaseRptBean" property="strErrMsg" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="localPurchaseRptBean" property="strNormalMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="localPurchaseRptBean" property="strWarningMsg" /></div>
	
	<!-- CONCERN DATA FRM DB -->
	<div id="indentItemListDivId" class="prescriptionTile">
		<table width="100%" align="center" border="0" cellspacing ="1px" id='mstTable'>
			 <bean:write name="localPurchaseRptBean" property="strViewItemDtls" filter="false" />				 	 
	    </table>
	</div> 
	
	<br /><br />
	 
 	<div align="left">
		<div id='info1'></div>
		<div id="chart1"   style="width: 100%; height: 350px;"></div>
		<br>
			<%-- <h3>${pendingIndentStatusRecordRpt.strCircleReportHeader}</h3> --%>
		<div id='info2'></div>
		<div id="chart2"   style="width: 100%; height: 350px;"></div> 	
	</div>

	<input type="hidden" name="hmode" />
	<div id="blanket" style="display: none;"></div>
	<input type="hidden" id="xpos" value=""/>
	<input type="hidden" id="ypos" value=""/>
	<input type="hidden" id="xwpos" value=""/>
	<input type="hidden" id="ywpos" value=""/>
	<input type="hidden" name="strHtmlCode" value="" />
	<input type="hidden" name="strChk"             value="">
	<input type="hidden" name="strTableWidth" id="strTableWidth" value="${localPurchaseRptBean.strTableWidth}">
	
	<div id="blanket" style="display: none;"></div>
     <div class="popUpDiv" id="popUpDiv" style="display: none;">
		<table bgcolor="white">
			<tr>
				<td>
							
					<div id="issueDtlsDivId" style="display: block;"></div>
			
				</td>
			</tr>
	    </table>
	 </div>
	
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>