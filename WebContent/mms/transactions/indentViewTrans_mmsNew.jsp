<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


<head>
<meta charset=UTF-8">
<title>Indent View</title>

<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css"   rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">


	
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>



<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../js/indentViewTrans.js"></script>
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/dropdown.js"></script>
<script language="JavaScript" src="../../hisglobal/js/newpopup.js"></script>

<style type="text/css">
  /*   .alert {
	    position: relative;
	    padding: 0.15rem 1.25rem;
	    margin-bottom: 0;
	   
	}
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
   } */
   .cancelbtn {
	padding: .175rem .35rem;
	line-height: 0.8;
	background-color: #d9534f;
	}
	.btn-circle {
		width: 37px;
		height: 34px;
		text-align: center;
		padding: 6px 0;
		font-size: 12px;
		line-height: 1.428571429;
		border-radius: 17px;
		color: white;
		float: right;
	}
	.iround {
		color: white;
		font-size: 16px;
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
  	   top: -2.3em;	   
  	   right: 44px;
	   line-height: 1.2em;
	}
	.table {
		width: 100%;
		color: rgba(0, 0, 0, 1);
		border-collapse: separate;
	}
	.table th, .table td {
		padding: 0.05rem;
	}
	.table .thead-dark {
	  	color: #fff !important;
	  	border: none !important;
	  	background:linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;
	  	align:center;
	}
	.thead-dark th{
		background:none !important;
		border: none !important;	
	  	text-align: center;
	}
</style>

<script type="text/javascript">


/**
 * Prints the report.
 * @return
 */
 
 function printData() {
	  newwin = window.open('', 'printwin', 'left=100,top=100,width=700,height=700,scrollbars=yes');
	  newwin.document.write('<HTML><HEAD>');
	  newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
	  newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } @media screen and (orientation: portrait) {  #toolbar { width: 100%; }} body { font-size: 140%; } </style>\n'); // Set the default font size to 100%
	  newwin.document.write('<script>\n');
	  newwin.document.write('function chkstate(){ \n');
	  newwin.document.write('window.close();\n');
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


// function printData() 
// {

// 	newwin = window.open('', 'printwin',
// 			'left=100,top=100,width=700,height=700,scrollbars=yes');
// 	newwin.document.write('<HTML><HEAD>');
// 	newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
// 	newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } @media screen and (orientation: portrait) {  #toolbar { width: 100%; }} </style>\n')
// 	newwin.document.write('<script>\n');
// 	newwin.document.write('function chkstate(){ \n');
// 	// newwin.document.write('if(document.readystate=="complete" ||
// 	// document.readystate=="undefined"){\n');
// 	newwin.document.write('window.close();\n');
// 	// newwin.document.write('}\n');
// 	// newwin.document.write('else{\n');
// 	// newwin.document.write('setTimeout("chkstate()",2000)\n');
// 	// newwin.document.write('}\n');
// 	newwin.document.write('}\n');
// 	newwin.document.write('function print_win(){\n');
// 	newwin.document.write('window.print();\n');
// 	newwin.document.write('chkstate();\n');
// 	newwin.document.write('}\n');

// 	newwin.document.write('<\/script>\n');
// 	newwin.document.write('</HEAD>\n');
// 	newwin.document.write('<BODY onload="print_win()">\n');
// 	newwin.document.write(document.getElementById('issueDtlsDivId').innerHTML);
// 	newwin.document.write('</BODY>\n');
// 	newwin.document.write('</HTML>\n');
// 	newwin.document.close();

// }

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

function getVoucher() 
{    
	//alert('1');
   var strChk         = document.forms[0].strChk.value;
   var strReqTypeId   = document.forms[0].strReqTypeId.value;
	 
   var mode="INDENTPRINT";
   var url="IndentViewTransBSCNT.cnt?hmode="+mode+"&strChk="+ strChk+"&strReqTypeId="+strReqTypeId;
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
			popup('popUpDiv', '60', '80');	
			
		}
       
}	

</script>

</head>
<body>
<html:form name="indentViewBean" action="/transactions/IndentViewTransBSCNT" type="mms.transactions.controller.fb.IndentViewTransFB">
	
	<div id="errMsg" class="errMsg" style="font-size:16px"><bean:write name="indentViewBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg" style="font-size:16px"><bean:write name="indentViewBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg" style="font-size:16px"><bean:write name="indentViewBean" property="strNormalMsg" /></div>

<div class="container-fluid">
	<div class="prescriptionTile">

	<div class="row ">
		<div class="col-sm-6" style="font-weight:600; font-size:18px;">
			<p class="subHeaders mb-0">
				<i class="fas fa-file-alt" style="font-size: 20px; color: #28a745"></i>
				&nbsp;Indent Desk View
			</p>
		</div>
		<div class="col-sm-6" id="">
			<div class="legend2" id='nonPrintableLegend2'>
			
			 <button type="button" id="cancelButton" class="float-right btn btn-danger btn-circle cancelbtn mt-2" onclick="cancelToDesk();">
				<i class="fas fa-times iround" title="Cancel"></i>
			</button>
			
			<button type="button" id="printButton" class="float-right btn btn-primary  btn-circle mt-2" onclick="getVoucher();">
				<i class="fas fa-print iround" title="Print"></i>
			</button>
			
			</div>
		</div>
	</div>

	<div class='popup' id='avalaibleBudgetDtlId' style="display: none">
		<table width='400' border="0" cellspacing="1" cellpadding="1">
			<tr class="HEADER">
				<td colspan='3'>Budget Details</td>
	
				<th align='right'><img style='cursor: pointer; '
					src='../../hisglobal/images/popUp_cancel.JPG' title='Click to Close Pop-Up'
					onClick="hideBalQtyDetails('avalaibleBudgetDtlId');"></th>
			</tr>
		</table>

		<table width='400' border="0" cellspacing="1" cellpadding="1">
			<tr>
				<td colspan="1" class='multiLabel'>Budget Allocated</td>
				<td colspan="1" class='multiLabel'>Budget Consumed</td>
			</tr>
			<tr>
				<td colspan="1" class='multiControl'>
				<div id='1'></div>
				</td>
				<td colspan="1" class='multiControl'>
				<div id='2'></div>
				</td>
			</tr>
		</table>
	</div>
       
   <div class='popup' id='issueDtl' style="display:none">
	 <table width='400' border="0" cellspacing ="0px">
		<tr class="HEADER"> 
			<th colspan='6' align='left'>
				<div id='201' style='color: blue;'></div>
			</th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('issueDtl');">
			</th>
	    </tr>
	 </table>   
	 <table width='400' bgcolor='#6097BC' border="0" cellspacing ="1px" cellpadding="1px">
		<tr>
			<td colspan="1" class='multiLabel'>Issue Qty.</td>
			<td colspan="1" class='multiLabel'>ReOrder Value</td>
			<td colspan="1" class='multiLabel'>Last Indent Qty</td>
			<td colspan="1" class='multiLabel'>Last Issue Qty</td>
		</tr>
		<tr>
			<td colspan="1" class='multiControl'><div id ='1'></div></td>
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
			<th colspan='6' align='left'><div id='202' style='color: blue;'></div></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('LpPatStaff');"></th>
	    </tr>
	 </table>   
	 <table width='400' bgcolor='#6097BC' border="0" cellspacing ="1px" cellpadding="1px">
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
			<th colspan='6' align='left'><div id='203' style='color: blue;'></div></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('LpDept');"></th>
	    </tr>
	 </table>   
	 <table width='400' bgcolor='#6097BC' border="0" cellspacing ="1px" cellpadding="1px">
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
			<th colspan='6' align='left'><div id='204' style='color: blue;'></div></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('IndentCondemnation');"></th>
	    </tr>
	 </table>   
	 <table width='400' bgcolor='#6097BC' border="0" cellspacing ="1px" cellpadding="1px">
		
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
			<th colspan='6' align='left'><div id='205' style='color: blue;'></div></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('IndentForImported');"></th>
	    </tr>
	 </table>   
	 <table width='400' bgcolor='#6097BC' border="0" cellspacing ="1px" cellpadding="1px">
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
			<th colspan='6' align='left'><div id='206' style='color: blue;'></div></th>
			<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
				onClick="hideItemDetails('ReturnRequest');"></th>
	    </tr>
	 </table>   
	 <table width='400' bgcolor='#6097BC' border="0" cellspacing ="1px" cellpadding="1px">
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
				<th colspan='6' align='left'><div id='207' style='color: blue;'></div></th>
				<th align='right'>
					<img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'
					onClick="hideItemDetails('AnnualPurchase');"></th>
		    </tr>
		 </table>   
		 <table width='400' bgcolor='#6097BC' border="0" cellspacing ="1px" cellpadding="1px">
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
		
   <p class="subHeaders mb-0" align="center" style="font-weight:600; font-size:20px;">
	  <bean:write name="indentViewBean" property="strRequestName" filter="false"/>
   </p>
   <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">   
	  <bean:write name="indentViewBean" property="strIndentDetails"	filter="false" />
   </table>
		
   <logic:equal   value="1" name="indentViewBean" 	property="strBudgetRequired">
     <table class="TABLEWIDTH" align="center" cellspacing="1" cellpadding="1">
	     <logic:present name="indentViewBean" property="strAvalaibleBudget" > 
	       	<tr>
				<td class="LABEL"  colspan="1">Budget Available</td>
				<td class="CONTROL" colspan="3">
	 	      	    <a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='avlBudgetDtl(this);' TITLE='Click Here Get Budget Details' ><bean:write name="indentViewBean" property="strAvalaibleBudget" /></a>
				</td>
			</tr>	
		 </logic:present>		
     </table>   
   </logic:equal>
		
		<br>
		<div>
			<p class="subHeaders mb-0"><i class="fas fa-th-list iround" style="font-size: 16px; color: #28a745" title=""></i>&nbsp;Item Details</p>
			<div><table class="Tablewidth"><bean:write name="indentViewBean" property="strSetItemDetails"	filter="false" /></table></div>
		</div>	
			
		<br>
	
		<div>
			<p class="subHeaders mb-0"><i class="fas fa-th-list iround" style="font-size: 16px; color: #28a745" title=""></i>&nbsp;Approval Details</p>
			<div><bean:write name="indentViewBean" property="strSetApprovedDetails"	filter="false" /></div>
		</div>
		<hr>
		
        <div class="row">
	        <div class="col-sm-12 text-right"><i class="fa fa-asterisk" style="color: red;font-size: smaller;"></i>Reserved/Branded Item</div>				
        </div>
		
		<input type="hidden" name="hmode"/>
		<input type="hidden" name="strPath"               value="${indentViewBean.strPath}">
		<input type="hidden" name="strAvalaibleBudgetDtl" value="${indentViewBean.strAvalaibleBudgetDtl}">
		<input type="hidden" name="strAvalaibleBudget"    value="${indentViewBean.strAvalaibleBudget}">
		<input type="hidden" name="strRemainingBudget"    value="${indentViewBean.strRemainingBudget}">
		<input type="hidden" name="strChk"             value="${indentViewBean.strChk}">
		<input type="hidden" name="strReqTypeId"       value="${indentViewBean.strReqTypeId}">
	
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
		</fieldset>
	</div>
	</div>

</html:form>
<tag:autoIndex></tag:autoIndex>   
</body>
