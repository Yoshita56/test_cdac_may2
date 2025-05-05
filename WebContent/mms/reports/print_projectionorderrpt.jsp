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
 
<script language="JavaScript" src="../../hisglobal/jquery/3.6.0.min.js"></script>

<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/autocompleteItemSearch.js"></script>

<!-- End additional plugins -->

<script type="text/javascript">
function cancelPrintToDesk()
{
     document.forms[0].hmode.value="unspecified";
     document.forms[0].submit();   
  
}

</script>
<script type="text/javascript">
jQuery(document).ready(function()
{
   $("html").click(function(e){
   document.getElementById("xpos").value=e.pageX;
   document.getElementById("ypos").value=e.pageY;
   document.getElementById("xwpos").value=$(window).width();
   document.getElementById("ywpos").value=$(window).height();    
   }); 
})

var districtArray;
var dwhTypeArray;
	$(document).ready(
			function() {
			
			    var districtId=$('#strDistrictIdString').val();
			    var dwhTypeId=$('#strDwhTypeIdString').val();
			    districtArray=districtId.split(',');
			    dwhTypeArray=dwhTypeId.split(',');
			    
			    var storeType=$('#strStoreTypeString').val();
			    var storeTypeValue=$('#strStoreTypeValue').val();			     
			    
				var s1 = $.parseJSON('['+storeTypeValue+']');				
				var ticks= storeType.split(',');				  
				
				var plot1 = $.jqplot('chart1', [ s1 ], {					
					
					// The "seriesDefaults" option is an options object that will
					// be applied to all series in the chart.
					seriesDefaults : {
						renderer : $.jqplot.BarRenderer,
						rendererOptions : {
							highlightMouseOver: true,
							fillToZero : true,							
							barWidth: 25
						},
						pointLabels: {show: true, stackedValue: true}
					},
					series:[
			             {pointLabels:{
			               show: true,
			               location:'s',
			               ypadding : 5,
			               edgeTolerance : -100,
			             }}],
					axes : {
						// Use a category axis on the x axis and use our custom ticks.
						xaxis : {
						tickRenderer: $.jqplot.CanvasAxisTickRenderer ,
				        tickOptions: {
				            angle: -90,
				            labelPosition: 'auto',				            
				            fontSize: '10pt',
				            fontFamily: 'Verdana',
				            textColor : 'black',
				            fontWeight : 'bolder'
				        },						     
							renderer : $.jqplot.CategoryAxisRenderer,
							ticks : ticks
						},
						// Pad the y axis just a little so bars can get close to, but
						// not touch, the grid boundaries.  1.2 is the default padding.
						yaxis : {
							pad : 0,
							label: '<------ Number of Items ------>',
							labelRenderer: $.jqplot.CanvasAxisLabelRenderer,
							 labelOptions: {
                                fontFamily: 'Verdana',
                                fontSize: '10pt',
                                textColor : 'black',
                                fontWeight : 'bolder'
                              }, 
							tickOptions : {
								formatString : ''
							}
						}
					  },
					grid: {
						        drawGridLines: true,        // wether to draw lines across the grid or not.
						        gridLineColor: '#cccccc',   // CSS color spec of the grid lines.
						        background: '#e6f6fd',      // CSS color spec for background color of grid.
						        borderColor: '#999999',     // CSS color spec for border around grid.
						        borderWidth: 2.0,           // pixel width of border around grid.
						        shadow: true,               // draw a shadow for grid.
						        shadowAngle: 45,            // angle of the shadow.  Clockwise from x axis.
						        shadowOffset: 1.5,          // offset from the line of the shadow.
						        shadowWidth: 3,             // width of the stroke for the shadow.
						        shadowDepth: 3
						}
				});

				$('#chart1').bind(
						'jqplotDataClick',
						function(ev, seriesIndex, pointIndex, data) {
							getItemDtlPopUp(districtArray[pointIndex],dwhTypeArray[pointIndex]);
						});

				 var circleType=$('#strCircleTypeString').val();
			     var circleTypeValue=$('#strCircleTypeValue').val();		    
				 var s2 = $.parseJSON('['+circleTypeValue+']');				
				 var ticks2= circleType.split(',');				
				

				var plot2 = $.jqplot('chart2', [ s2 ], {
					// The "seriesDefaults" option is an options object that will
					// be applied to all series in the chart.
					seriesDefaults : {
						renderer : $.jqplot.BarRenderer,
						rendererOptions : {
							highlightMouseOver: false,
							fillToZero : true,							
							barWidth: 25
						},
						pointLabels: {show: true, stackedValue: true}
					},
					series:[
			             {pointLabels:{
			               show: true,
			               location:'s',
			               ypadding : 5,
			               edgeTolerance : -100,
			             }}],
					axes : {
						// Use a category axis on the x axis and use our custom ticks.
						xaxis : {
						tickRenderer: $.jqplot.CanvasAxisTickRenderer ,
				        tickOptions: {
				            angle: -30,
				            labelPosition: 'auto',				            
				            fontSize: '10pt',
				            fontFamily: 'Verdana',
				            textColor : 'black',
				            fontWeight : 'bolder'
				        },						     
							renderer : $.jqplot.CategoryAxisRenderer,
							ticks : ticks2
						},
						// Pad the y axis just a little so bars can get close to, but
						// not touch, the grid boundaries.  1.2 is the default padding.
						yaxis : {
							pad : 0,
							label: '<------ Number of Items ------>',
							labelRenderer: $.jqplot.CanvasAxisLabelRenderer,
							 labelOptions: {
                                fontFamily: 'Verdana',
                                fontSize: '10pt',
                                textColor : 'black',
                                fontWeight : 'bolder'
                              },
							tickOptions : {
								formatString : ''
							}
						}
					  },
					grid: {
						        drawGridLines: true,        // wether to draw lines across the grid or not.
						        gridLineColor: '#cccccc',   // CSS color spec of the grid lines.
						        background: '#e6f6fd',      // CSS color spec for background color of grid.
						        borderColor: '#999999',     // CSS color spec for border around grid.
						        borderWidth: 2.0,           // pixel width of border around grid.
						        shadow: true,               // draw a shadow for grid.
						        shadowAngle: 45,            // angle of the shadow.  Clockwise from x axis.
						        shadowOffset: 1.5,          // offset from the line of the shadow.
						        shadowWidth: 3,             // width of the stroke for the shadow.
						        shadowDepth: 3
						}
				});

				$('#chart2').bind(
						'jqplotDataClick',
						function(ev, seriesIndex, pointIndex, data) {							
						});
			});
	
	
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
	
	function cancelPage(){
		document.forms[0].hmode.value="CANCEL";
		document.forms[0].target = "_self";
		document.forms[0].submit();

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

<html:form action="/reports/ProjectionOrderRptCNT" method="post" styleClass="formbg">

	<div class="errMsg" id="errMsg" style="font-size:18px;" ><bean:write name="projectionorderRPT" property="strErrMsg" /></div>
	<div class="normalMsg" id="normalMsg" style="font-size:18px;" ><bean:write name="projectionorderRPT" property="strNormalMsg" /></div>
	<div class="warningMsg" id="warningMsg" style="font-size:18px;" ><bean:write name="projectionorderRPT" property="strWarningMsg" /></div>
	
	<!-- CONCERN DATA FRM DB -->
	<div id="indentItemListDivId" class="prescriptionTile">
		<table width="100%" align="center" border="0" cellspacing ="1px" id='mstTable'>
			 <bean:write name="projectionorderRPT" property="strViewItemDtls" filter="false" />				 	 
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
	<input type="hidden" name="strTableWidth" id="strTableWidth" value="${projectionorderRPT.strTableWidth}">
	
	<div class="popUpDiv" id="popUpDiv1" style="display: none;position:absolute;">
		<table bgcolor="white">
			<tr>
				<td>
					<div id="supplierPoDtlsDivId" style="display: block;"></div>
				</td>
			</tr>
		</table>
	</div>
	
	<div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="popUpDiv4" style="display: none;">
		<table bgcolor="white">
			<tr>
				<td>
					<div id="suppliedPOPrintDtlsDivId" style="display: block;"></div>
				</td>
			</tr>
		</table>
	</div>
	
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>


