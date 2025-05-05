<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>


<html>
<head>
<meta charset=UTF-8">
<title>Issue Indent</title>
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/newpopup.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../mms/js/IndentApproval.js"></script>

<!-- added -->
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css"
	rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css"
	rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css"
	rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet"
	type="text/css">
<link
	href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css"
	rel="stylesheet" type="text/css">
	
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript"
	src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>



<script type="text/javascript">

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
	document.forms[0].hmode.value="CANCELTODESK";
	document.forms[0].submit();
}

</script>
<style type="text/css">
  .Approved 
   {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-style: normal;
	font-weight: normal;
	color: #151AFB;
	background-color: #D3D5C9;
	height: 16px;
	text-align:center;
    }
   .NotApproved 
   {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-style: normal;
	font-weight: normal;
	color: #000000;
	background-color: #F1ECE2;
	height: 16px;
	text-align:center;
    }
   .pg-normal {
       color: blue;
       font-weight: normal;
       text-decoration: none;
       cursor: pointer;
   }
   .pg-selected 
   {
       color: red;
       font-weight: bold;
       text-decoration: underline;
       cursor: pointer;
   }
   .class3
   { 
     A:link {text-decoration: none}
     A:visited {text-decoration: none}
     A:active {text-decoration: none}
     A:hover {font-size:30; font-weight:bold; color: red;}
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
	.legend2 {
	   position: absolute;
	   top: 0.5em;
	   right: 44px;
	   line-height: 1.2em;
	}
	.table .thead-dark {
	  	color: #000 !important;
	  	border: none !important;
	  	background:linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;
	}
	.thead-dark th{
		background:none !important;
		border: none !important;
		padding: 0.25rem !important;
	    text-align: center;	
	 }
</style>


	
</head>
<body>
<html:form name="indentApprovalTransBean" action="/transactions/IndentApprovalDeskCNT" type="mms.transactions.controller.fb.IndentApprovalDeskFB">

<div class="container-fluid">
 <div class="prescriptionTile">	

		<center>
			<div id="errMsg" class="errMsg" style="font-size: 18px;">
				<bean:write name="indentApprovalTransBean" property="strErrMsg" />
			</div>
			<div id="warningMsg" class="warningMsg" style="font-size: 18px;">
				<bean:write name="indentApprovalTransBean" property="strWarning" />
			</div>
			<div id="normalMsg" class="normalMsg" style="font-size: 18px;">
				<bean:write name="indentApprovalTransBean" property="strMsg" />
			</div>
		</center>

<%-- 	<tag:tab tabLabel="After Approval View" selectedTab="FIRST"
		align="center" width="TABLEWIDTH">
	</tag:tab> --%>
	<div class="legendHeader " id="nonPrintableLegend" style="font-weight:600;font-size: 22px;">After Approval View</div>
	
	<div class="legend2" id='nonPrintableLegend2'>
		<button type="button" 
			class="float-right btn btn-danger mt-1 btn-circle cancelbtn"
			onclick="cancelToDesk();" style="border-radius:50%;  padding:10px 12px" title="Cancel">
			<i class="fas fa-times iround" title="Cancel"></i>
		</button>
		<button type="button" class="float-right btn btn-secondary btn-circle"
			onclick="getReport1();"
			style="border-radius:50%; padding:10px 11px; background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" title="Print">
			<i class="fas fa-print iround" title="Print"></i>
		</button>
  </div>
	
	
	<div class='popup' id='Return' style="display:none">
	<table width='400' border="0" cellspacing ="0px">
		<tr class="HEADER"> 
			<th colspan='6' align='left'></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('Return');"></th>
	    </tr>
	 </table>   
	 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">
				
		<tr>
		   <td width='25%' class='multiLabel'>Rate/Unit</td>
		   <td width='25%' class='multiControl'><div id ='35'></div></td>
		   <td width='25%' class='multiLabel'>Manufacture Date</td>
		   <td width='25%' class='multiControl'><div id ='36'></div></td>	
		 </tr>  
		 <tr>
		   <td width='25%' class='multiLabel'>Exp Date</td>
		   <td width='25%' class='multiControl'><div id ='37'></div></td>
		   <td width='25%' class='multiLabel'></td>
		   <td width='25%' class='multiControl'></td>	
		 </tr>  
		 <tr class="FOOTER">
			<td colspan="4"></td>
		</tr>
      </table>
	</div>
	
	<div class='popup' id='ReceiveFrmThirdParty' style="display:none">
	<table width='400' border="0" cellspacing ="0px">
		<tr class="HEADER"> 
			<th colspan='3' align='left'></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('ReceiveFrmThirdParty');"></th>
	    </tr>
	 </table>   
	 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">
		<tr>
			
			<td colspan="1" class='multiLabel'>Exp Date</td>
			<td colspan="1" class='multiLabel'>Drug Make</td>
			<td colspan="1" class='multiLabel'>Rate/Unit</td>
			
		</tr>
		<tr>
			
			<td colspan="1" class='multiControl'><div id ='100'></div></td>
			<td colspan="1" class='multiControl'><div id ='101'></div></td>
			<td colspan="1" class='multiControl'><div id ='102'></div></td>
		</tr>
		<tr class="FOOTER">
			<td colspan="3"></td>
		</tr>
        </table>
	</div>           
	
    
     <div class='popup' id='ReceiveFrmThirdParty' style="display:none">
	<table width='400' border="0" cellspacing ="0px">
		<tr class="HEADER"> 
			<th colspan='3' align='left'></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('ReceiveFrmThirdParty');"></th>
	    </tr>
	 </table>   
	 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">
		<tr>
			
			<td colspan="1" class='multiLabel'>Exp Date</td>
			<td colspan="1" class='multiLabel'>Drug Make</td>
			<td colspan="1" class='multiLabel'>Rate/Unit</td>
			
		</tr>
		<tr>
			
			<td colspan="1" class='multiControl'><div id ='100'></div></td>
			<td colspan="1" class='multiControl'><div id ='101'></div></td>
			<td colspan="1" class='multiControl'><div id ='102'></div></td>
		</tr>
		<tr class="FOOTER">
			<td colspan="3"></td>
		</tr>
        </table>
	</div>   
    
              
     <div class='popup' id='Agenda' style="display:none">
	<table width='400' border="0" cellspacing ="0px">
		<tr class="HEADER"> 
			<th colspan='6' align='left'></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('Agenda');"></th>
	    </tr>
	 </table>   
	 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">
				
		<tr>
		   <td width='25%' class='multiLabel'>Last PO No</td>
		   <td width='25%' class='multiControl'><div id ='30'></div></td>
		   <td width='25%' class='multiLabel'>Last Po Date</td>
		   <td width='25%' class='multiControl'><div id ='31'></div></td>	
		 </tr>  
		 <tr>
		   <td width='25%' class='multiLabel'>Last Rec Qty</td>
		   <td width='25%' class='multiControl'><div id ='32'></div></td>
		   <td width='25%' class='multiLabel'>Last Rec Date</td>
		   <td width='25%' class='multiControl'><div id ='33'></div></td>	
		 </tr>  
		 <tr>
		   <td width='25%' class='multiLabel'>Last Supplied By</td>
		   <td colspan="3" class='multiControl'><div id ='34'></div></td>
		 </tr>  
		 <tr class="FOOTER">
			<td colspan="4"></td>
		</tr>
      </table>
	</div>
          
              
              
              
              
     <div class='popup' id='issueToThirdParty' style="display:none">
	<table width='400' border="0" cellspacing ="0px">
		<tr class="HEADER"> 
			<th colspan='6' align='left'></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('issueToThirdParty');"></th>
	    </tr>
	 </table>   
	 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">
		<tr>
			
			<td colspan="1" class='multiLabel'>Rate/Unit</td>
			<td colspan="1" class='multiLabel'>Expiry Date</td>
						
		</tr>
		<tr>
			<td colspan="1" class='multiControl'><div id ='28'></div></td>
			<td colspan="1" class='multiControl'><div id ='29'></div></td>
			
		</tr>
		<tr class="FOOTER">
			<td colspan="4"></td>
		</tr>
        </table>
	</div>  
                 
              
               
   <div class='popup' id='issueDtl' style="display:none">
	<table width='400' border="0" cellspacing ="0px">
		<tr class="HEADER"> 
			<th colspan='6' align='left'></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('issueDtl');"></th>
	    </tr>
	 </table>   
	 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">
		<tr>
			
			<td colspan="1" class='multiLabel'>ReOrder Value</td>
			<td colspan="1" class='multiLabel'>Last Indent Qty</td>
			<td colspan="1" class='multiLabel'>Last Issue Qty</td>
			
		</tr>
		<tr>
			
			<td colspan="1" class='multiControl'><div id ='2'></div></td>
			<td colspan="1" class='multiControl'><div id ='3'></div></td>
			<td colspan="1" class='multiControl'><div id ='4'></div></td>
		</tr>
		<tr class="FOOTER">
			<td colspan="4"></td>
		</tr>
        </table>
	</div>  
   
    <div class='popup' id='LpPatStaff' style="display:none">
	<table width='400' border="0" cellspacing ="0px">
		<tr class="HEADER"> 
			<th colspan='6' align='left'></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('LpPatStaff');"></th>
	    </tr>
	 </table>   
	 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">
		<tr>
			<td colspan="1" class='multiLabel'>Issue Qty.</td>
			<td colspan="1" class='multiLabel'>Return Qty</td>
					
		</tr>
		<tr>
			<td colspan="1" class='multiControl'><div id ='12'></div></td>
			<td colspan="1" class='multiControl'><div id ='13'></div></td>
		  </tr>
		  <tr class="FOOTER">
			<td colspan="2"></td>
		</tr>
        </table>
	</div>  
   
   <div class='popup' id='LpDept' style="display:none">
	<table width='400' border="0" cellspacing ="0px">
		<tr class="HEADER"> 
			<th colspan='6' align='left'></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('LpDept');"></th>
	    </tr>
	 </table>   
	 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">
		<tr>
			<td colspan="1" class='multiLabel'>Issue Qty.</td>
			<td colspan="1" class='multiLabel'>Last Rec Qty</td>
			<td colspan="1" class='multiLabel'>Last Rec date</td>
					
		</tr>
		<tr>
			<td colspan="1" class='multiControl'><div id ='14'></div></td>
			<td colspan="1" class='multiControl'><div id ='15'></div></td>
			<td colspan="1" class='multiControl'><div id ='16'></div></td>
		  </tr>
		 <tr class="FOOTER">
			<td colspan="3"></td>
		</tr>
        </table>
	</div>  
   
   
   <div class='popup' id='IndentCondemnation' style="display:none">
	<table width='400' border="0" cellspacing ="0px">
		<tr class="HEADER"> 
			<th colspan='6' align='left'></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('IndentCondemnation');"></th>
	    </tr>
	 </table>   
	 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">
		
		<tr>
		   <td width='25%' class='multiLabel'>Last PO No</td>
		   <td width='25%' class='multiControl'><div id ='17'></div></td>
		   <td width='25%' class='multiLabel'>Last PO Date</td>
		   <td width='25%' class='multiControl'><div id ='18'></div></td>
		</tr>
		<tr>
		   <td width='25%' class='multiLabel'>Exp Date</td>
		   <td width='25%' class='multiControl'><div id ='19'></div></td>
		   <td width='25%' class='multiLabel'>Last Supply By</td>
		   <td width='25%' class='multiControl'><div id ='20'></div></td>	
		 </tr> 
		 <tr class="FOOTER">
			<td colspan="4"></td>
		</tr>
	 </table>
	</div>
	
	<div class='popup' id='IndentForImported' style="display:none">
	<table width='400' border="0" cellspacing ="0px">
		<tr class="HEADER"> 
			<th colspan='6' align='left'></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('IndentForImported');"></th>
	    </tr>
	 </table>   
	 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">
		
		<tr>
		   <td width='25%' class='multiLabel'>Last PO No</td>
		   <td width='25%' class='multiControl'><div id ='24'></div></td>
		   <td width='25%' class='multiLabel'>Last PO Date</td>
		   <td width='25%' class='multiControl'><div id ='25'></div></td>
		</tr>
		<tr>
		   <td width='25%' class='multiLabel'>Lst Recev Date</td>
		   <td width='25%' class='multiControl'><div id ='26'></div></td>
		   <td width='25%' class='multiLabel'>Manufact By</td>
		   <td width='25%' class='multiControl'><div id ='27'></div></td>	
		 </tr>  
		 <tr class="FOOTER">
			<td colspan="4"></td>
		</tr>
	 </table>
	</div>
	
	
   
    <div class='popup' id='ReturnRequest' style="display:none">
	<table width='400' border="0" cellspacing ="0px">
		<tr class="HEADER"> 
			<th colspan='6' align='left'></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('ReturnRequest');"></th>
	    </tr>
	 </table>   
	 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">
		
		<tr>
		   <td width='25%' class='multiLabel'>Last PO No</td>
		   <td width='25%' class='multiControl'><div id ='21'></div></td>
		   <td width='25%' class='multiLabel'>Last PO Date</td>
		   <td width='25%' class='multiControl'><div id ='22'></div></td>
		</tr>
		<tr>
		   <td width='25%' class='multiLabel'>Exp Date</td>
		   <td width='25%' class='multiControl'><div id ='23'></div></td>
		   <td width='25%' colspan='2' class='multiLabel'></td>
		   
		 </tr>  
		<tr class="FOOTER">
			<td colspan="4"></td>
		</tr>
	 </table>
	</div>
   
   
   
   
   
   
   <div class='popup' id='AnnualPurchase' style="display:none">
	<table width='400' border="0" cellspacing ="0px">
		<tr class="HEADER"> 
			<th colspan='6' align='left'></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('AnnualPurchase');"></th>
	    </tr>
	 </table>   
	 <table width='400' border="0" cellspacing ="1px" cellpadding="1px">
		
		<tr>
		   <td width='25%' class='multiLabel'>Re-OrderLevel</td>
		   <td width='25%' class='multiControl'><div id ='5'></div></td>
		   <td width='25%' class='multiLabel'>Last Year Consumption</td>
		   <td width='25%' class='multiControl'><div id ='6'></div></td>
		</tr>
		<tr>
		   <td width='25%' class='multiLabel'>Last PO No</td>
		   <td width='25%' class='multiControl'><div id ='7'></div></td>
		   <td width='25%' class='multiLabel'>Last Po Date</td>
		   <td width='25%' class='multiControl'><div id ='8'></div></td>	
		 </tr>  
		 <tr>
		   <td width='25%' class='multiLabel'>Last Rec Qty</td>
		   <td width='25%' class='multiControl'><div id ='9'></div></td>
		   <td width='25%' class='multiLabel'>Last Rec Date</td>
		   <td width='25%' class='multiControl'><div id ='10'></div></td>	
		 </tr>  
		 <tr>
		   <td width='25%' class='multiLabel'>Last Supplied By</td>
		   <td colspan="3" class='multiControl'><div id ='11'></div></td>
		 </tr>  
		 <tr class="FOOTER">
			<td colspan="4"></td>
		</tr>
      </table>
	</div>
 
           
         <!-- -----------------------------START----------------------------- -->  

<!-- 	     <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
		 <tr class="HEADER">
			<td colspan="4"></td>
		 </tr>
		 </table> -->
		 <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
		      <bean:write name="indentApprovalTransBean" property="strIndentDetails"	filter="false" />
		</table>
		
		
	<!-- 	<table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
		<tr class="TITLE">
			<td colspan="4"><div id="" style="color:white;">Drug Details</div></td>
		</tr>
		</table> -->
		<div class="legendHeader" id="" style="font-weight:600;font-size: 18px;">Drug Details</div>
		<table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1"> 
		<bean:write name="indentApprovalTransBean" property="strSetItemDetails"	filter="false" />
		</table>
			
		<!-- <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
		<tr class="TITLE">
			<td colspan="5"><div id="" style="color:white;">Approval Details</div></td>
		</tr>
		</table> -->
		 <div class="legendHeader" id="" style="font-weight:600;font-size: 18px;">Approval Details</div>
		
	     <bean:write name="indentApprovalTransBean" property="strSetApprovedDetails" filter="false" />
	   
	     <bean:write name="indentApprovalTransBean" property="strSetPreTechApprovedDetails"	filter="false" />
	
	
<!-- 	<table border="0" class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
		<tr class="FOOTER">
               <td width="TABLEWIDTH" colspan="2" ></td>
        </tr>
		<tr>
			<td align="center">
					<br>
			    <a href="#" class="button" id="" onclick=" getReport1();" tabindex="1"><span class="print">Print</span></a> 
				<a href="#" class="button"	onclick="cancelToDesk();"><span class="back">Back</span></a> 
			</td>
		</tr>
	</table> -->
	
	<input type="hidden" name="hmode"/>
	<input type="hidden" name="strPath"       value="${indentApprovalTransBean.strPath}">
	<input type="hidden" name="strMultiRow"   value="${indentApprovalTransBean.strMultiRow}">
	<input type="hidden" name="strChk"        value="${indentApprovalTransBean.strChk}">
	<input type="hidden" name="strReqTypeId"  value="${indentApprovalTransBean.strReqTypeId}">

	<cmbPers:cmbPers/>
	
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
	 
	</div>
</div>
	 
	</html:form>
		<tag:autoIndex></tag:autoIndex>   
</body>
