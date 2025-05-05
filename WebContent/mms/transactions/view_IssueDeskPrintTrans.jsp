<%@ page language="java" contentType="text/html;"	%>
  <%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<script language="JavaScript" src="../js/BreakageItemDtlTrans.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="JavaScript" src="../js/lpIssue_Print.js"></script>

<!-- added -->
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css"	rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
	
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

<style type="text/css">
    .alert {
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
	padding:0.25rem;
	text-align:center;	
	}
</style>

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
	document.forms[0].hmode.value="LIST";
	document.forms[0].submit();
}

function getVoucher() 
{    
	//alert('1');
   var strChk         = document.forms[0].strChk.value;
   var strReqTypeId   = document.forms[0].strRequestTypeId.value;
	 
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
<title>Issue Desk</title>
</head>
<body onload="">
<html:form action="/transactions/IssueDeskPrintTransCNT"  name="issueDeskPrintTransBean" type="mms.transactions.controller.fb.IssueDeskPrintTransFB" method="post">
<div class="container-fluid">
 	<div class="prescriptionTile">	
	 <div id="errMsg"     class="errMsg"     style="font-size:18px;"><bean:write name="issueDeskPrintTransBean" property="strErr" /></div>
     <div id="warningMsg" class="warningMsg" style="font-size:18px;"><bean:write name="issueDeskPrintTransBean" property="strWarning" /></div>
     <div id="normalMsg"  class="normalMsg"  style="font-size:18px;"><bean:write name="issueDeskPrintTransBean" property="strMsg" /></div>
	
	 <div class="legend2" id='nonPrintableLegend2'>
		<button type="button" class="float-right btn btn-danger mt-1 btn-circle cancelbtn"
			onclick="cancelToDesk();" style="border-radius:50%;  padding:10px 11px" title="Cancel">
			<i class="fas fa-times iround" title="Cancel"></i>
		</button>
		<button type="button" class="float-right btn btn-secondary btn-circle"
			onclick="getVoucher();"
			style="border-radius:50%; padding:10px 10px; background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" title="Print">
			<i class="fas fa-print iround" title="Print"></i>
		</button>
    </div>
   
	
		<fieldset>
		<legend class="legendHeader" id="nonPrintableLegend">Indent Desk</legend>
		
	
		
		 <p class="subHeaders" align="center" style="font-weight:600; font-size:20px;">
		 	<bean:write name="issueDeskPrintTransBean" property="strRequestName" filter="false"/>
		 </p>

		
	
			
			<bean:write property="strIndentDetails"     name="issueDeskPrintTransBean" filter="false" />
			<bean:write property="strSetItemDetails" name="issueDeskPrintTransBean" filter="false" />
		
			
		
			<div id="blanket" style="display:none;"></div>
			<div class="popUpDiv" id="popUpDiv" style="display:none;">
				<table bgcolor="white">
					<tr>
						<td>
							 <div id="issueDtlsDivId" style="display:block;"></div>
						</td>
					</tr>
				</table>	
			</div>
	
			<input type="hidden" name="hmode"/>
		 	<input type="hidden" name="strRequestTypeId" value="${issueDeskPrintTransBean.strRequestTypeId}"/>
	    	<input type="hidden" name="strStoreId"       value="${issueDeskPrintTransBean.strStoreId}"/>
	    	<input type="hidden" name="strChk"           value="${issueDeskPrintTransBean.strChk}"/>
	     	
	      
			<cmbPers:cmbPers/>
		</fieldset>
	</div>
</div>
</html:form>

<tag:autoIndex></tag:autoIndex>

</body>
</html>