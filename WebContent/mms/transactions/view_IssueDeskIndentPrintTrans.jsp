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
/* .multiControlRed {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	font-style: normal;
	font-weight: normal;
	color: #000000;
	background-color: #F5786B;
	height: 16px;
	text-align:center;
} */
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
    
.table td {
  padding: 0.1rem !important;
}

</style>
<script type="text/javascript">
function getReport()
{

	   var issueNo    = "0";
	   var storeId    = document.forms[0].strStoreId.value;
	  
	   var IndentNo   = document.forms[0].strLpRequestNo.value;
	   var IndentDate = document.forms[0].strRequestDate.value;
	   var CrNo       = document.forms[0].strCrNo.value;
	   var raisingStoreId = document.forms[0].strRaisingStoreId.value;
		if(IndentNo!="0" && IndentNo != "" )
		{
			var hmode = "ISSUEDTLSINIT";
			var url = "IssueDeskPrintTransCNT.cnt?hmode=" + hmode + "&strMode=1&strStoreId=" + storeId + 
					"&strIssueNo=" + issueNo+"&strIndentNo="+IndentNo+"&strIndentDate="+IndentDate+"&crNo="+CrNo+"&strRaisingStoreId="+raisingStoreId;
			
			ajaxFunction2(url, "1", "getIssueDtlsAjaxResponse");
		}
	
}

function getIssueDtlsAjaxResponse(res, mode) {

	//STOCKDTLSINIT
	if (mode == '1') 
	{

		var itemStockObj = document.getElementById("issueDtlsDivId");

		itemStockObj.innerHTML = res;

		popup('popUpDiv', '80', '60');

	}

}

function printDataOne() 
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
	newwin.document.write(document.getElementById('issueDtlsDivId').innerHTML);		
	newwin.document.write('</BODY>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();


}
function hideIssuePopupOne() 
{
	document.getElementById("issueDtlsDivId").innerHTML = "";
	hide_popup('popUpDiv');	

}


function openDiv()
{
	if(document.getElementsByName("strRaisingReqTypeId")[0].value=="13" || document.getElementsByName("strRaisingReqTypeId")[0].value=="12"){
		document.getElementById("patientDtlId").style.display="block";
	}
}
function view1(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="none";
	document.getElementById(obj2).style.display="block";
	document.getElementById(obj3).style.display="block";
}
function view2(obj1,obj2,obj3)
{
	document.getElementById(obj1).style.display="block";
	document.getElementById(obj2).style.display="none";
	document.getElementById(obj3).style.display="none";
}

function openSpecification(obj,index)
{
	    var strItemDetail = document.getElementById("strItemDtl"+index).value;    
        var itemParamValue= document.getElementById("strItemParamValue"+index).value;    
        var myArray = strItemDetail.split("@");
        document.getElementById("popUpItemId").innerHTML="Balance Qty. Details";
        var myArray2=itemParamValue.split("@");      
        var objVal1 = document.getElementById("1");
       
        if(myArray[0]!='null' || myArray[0]!='')
        {
          objVal1.innerHTML = myArray2[0]+" "+myArray[1];
        }
        else
        {
          objVal1.innerHTML = "  ----";
        }  
              
        var objVal2 = document.getElementById("2");
        
        if(myArray[1]!='null')
        {
          objVal2.innerHTML = myArray[2]+" "+myArray[1];; 
        }
        else
        {
          objVal2.innerHTML = "  ----";
        }  
        display_popup_menu(obj,'itemDtlId','300','');
        	
	
}
function cancelToDesk()
{
	document.forms[0].hmode.value="RETURNTOMAINDESK";
	document.forms[0].submit();
}
function closeItemPopUp(divId)
{
 	hide_popup_menu(divId);
}

</script>
<title>Issue Desk</title>
</head>
<body onload="openDiv();">
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
			onclick="getReport();"
			style="border-radius:50%; padding:10px 10px; background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" title="Print">
			<i class="fas fa-print iround" title="Print"></i>
		</button>
    </div>
   
	<%-- 	<center>
		<tag:tab tabLabel="Issue Desk" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab>
		</center> --%>
		<fieldset>
		<legend class="legendHeader" id="nonPrintableLegend">Issue Desk</legend>
		
		<!-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
				<tr class="HEADER">
					<td colspan="4">Request >> View</td>
				</tr>
		</table> -->
		
		<div class="legendHeader" id="" style="font-weight:600;font-size: 18px;">Request >> View</div>

		<div class="container">
			<div class="row" align="left">
				<div class="col-sm-3">Store Name</div>
				<div class="col-sm-3">
					<bean:write property="strStoreName" name="issueDeskPrintTransBean" filter="false"/>
				</div>
				<div class="col-sm-3">CR No.</div>
				<div class="col-sm-3">
					<bean:write property="strCrNo" name="issueDeskPrintTransBean" filter="false"/>
				</div>
			</div>
				
			<div class="row" align="left">
				<div class="col-sm-3">Issue No.</div>
				<div class="col-sm-3">
					<bean:write property="strIssueNo" name="issueDeskPrintTransBean" filter="false"/>
				</div>
				<div class="col-sm-3">Indent No.</div>
				<div class="col-sm-3">
					<bean:write property="strLpRequestNo" name="issueDeskPrintTransBean" filter="false"/>
				</div>
			</div>	
		</div>
		<%-- <table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>
			<tr>
				<td class='LABEL' width='25%'>Store Name</td>
				<td class='CONTROL' width='25%'>
					<bean:write property="strStoreName" name="issueDeskPrintTransBean" filter="false"/>
				</td>
				<td class='LABEL' width='25%'>CR No.</td>
				<td class='CONTROL' width='25%'>
					<bean:write property="strCrNo" name="issueDeskPrintTransBean" filter="false"/>
				</td>
			</tr>
			<tr>
				<td class='LABEL' width='25%'>Issue No.</td>
				<td class='CONTROL' width='25%'>
					<bean:write property="strIssueNo" name="issueDeskPrintTransBean" filter="false"/>
				</td>
				<td class='LABEL' width='25%'>Indent No.</td>
				<td class='CONTROL' width='25%'>
					<bean:write property="strLpRequestNo" name="issueDeskPrintTransBean" filter="false"/>
				</td>
			</tr>
		</table> --%>
			
		<div id="patientDtlId" style="display: none;">
			<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
				<tr>
					<td  colspan="4" class="TITLE">
						<div id="plusPatientDetailId" align="left" style="display:none;color:white;">
							<img src="../../hisglobal/images/plus.gif" onClick="view1('plusPatientDetailId','minusPatientDetailId','patientAdmissionDtlId');" style="cursor: pointer; "/>
							Patient Detail
						</div>
						<div id="minusPatientDetailId" style="display:block;color:white;" align="left">
							<img src="../../hisglobal/images/minus.gif" onClick="view2('plusPatientDetailId','minusPatientDetailId','patientAdmissionDtlId');" style="cursor: pointer; "/>
							Patient Details
						</div>
					</td>
				</tr>
			</table>
		</div>	
		
		<div id="patientAdmissionDtlId" style="display:block">
			<bean:write property="strPatientDtl" name="issueDeskPrintTransBean" filter="false"/>
		</div>
		<br>
		<!-- <table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
			 <tr>
			  <td  colspan="4" class="TITLE"> -->
				<!-- <div id="plusRequestItemDtlId"  style="display:none;color:white;" align="left">
						Item/Drug Detail
			   </div> -->
			   <div class="legendHeader" id="plusRequestItemDtlId" align="left" style="font-weight:600;font-size: 18px;display:none;">Item/Drug Detail</div>
			   
				<!-- <div id="minusRequestItemDtlId" style="display:block;color:white;" align="left">
						Item/Drug Detail
			   </div> -->
			   <div class="legendHeader" id="minusRequestItemDtlId" align="left" style="font-weight:600;font-size: 18px;display:block;">Item/Drug Detail</div>
<!-- 			 </td>
			</tr>
		</table> -->
	
		 <div id="strRequestItemDtlId" style="display: block">
			<bean:write property="strRequestDtl" name="issueDeskPrintTransBean" filter="false" />
			<bean:write property="strIndentItemDetails" name="issueDeskPrintTransBean" filter="false" />
		</div>
			
		  <!-- <table CLASS ="TABLEWIDTH" align="center" cellspacing="1px">
				<tr class="FOOTER"> 
		    	 <td colspan="2" ></td>
		  		</tr>
			    <tr> 
					 <td align="center">		
					    <br>
					    <a href="#" class="button" id="" onclick=' getReport();'><span class="print">Print</span></a>
					    <a href="#" class="button"	onclick="cancelToDesk()"><span class="cancel">Cancel</span></a> 
					 </td>
			    </tr>
	       </table> -->

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
	    	<input type="hidden" name="strStoreId" value="${issueDeskPrintTransBean.strStoreId}"/>
	     	<input type="hidden" name="strRequestDate" value="${issueDeskPrintTransBean.strRequestDate}"/>
	     	<input type="hidden" name="strCrNo" value="${issueDeskPrintTransBean.strCrNo}"/>
	     	<input type="hidden" name="strEmpNo" value="${issueDeskPrintTransBean.strEmpNo}"/>
	     	<input type="hidden" name="strLpRequestNo" value="${issueDeskPrintTransBean.strLpRequestNo}"/>
	     	<input type="hidden" name="strItemCategNo" value="${issueDeskPrintTransBean.strItemCategNo}"/>
	      	<input type="hidden" name="strRaisingReqTypeId" value="${issueDeskPrintTransBean.strRaisingReqTypeId}"/>
	     	<input type="hidden" name="strRaisingStoreId" value="${issueDeskPrintTransBean.strRaisingStoreId}"/>
	      	<input type="hidden" name="strIssueNo" value="${issueDeskPrintTransBean.strIssueNo}"/>
	      
			<cmbPers:cmbPers/>
		</fieldset>
	</div>
</div>
</html:form>

<tag:autoIndex></tag:autoIndex>

</body>
</html>