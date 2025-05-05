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
<title>Acknowledge Desk</title>
<!-- CSS -->
<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<!-- JS -->
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<!-- EXT JS -->
<script language="Javascript" src="../js/acknowledgeDesk_trans.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script> 

<!-- ADDED -->
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
	
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/swal/swal.js"></script>
<script type="text/javascript"
	src="../../hisglobal/jquery/3.6.0.min.js"></script>
	
	<script language="JavaScript" src="../../hisglobal/js/DataTables.js"></script>
	
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datatable/js/datatables.bootstrap4.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>


<style type="text/css">
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

</head>
<body onload="getCmbValView();">
<html:form name="acknowledgeTransBean" action="/transactions/AcknowledgeTransCNT" type="mms.transactions.controller.fb.AcknowledgeTransFB">

<div class="container-fluid">
	<div class="prescriptionTile">	
		<div class='legendHeader my-2' id='nonPrintableLegend' style="font-weight:600;font-size: 18px;" >Acknowledge Desk</div>
		
		<center>
			<div id="errMsg" class="errMsg"><bean:write name="acknowledgeTransBean" property="strErrMsg" /></div>
			<div id="warningMsg" class="warningMsg"><bean:write name="acknowledgeTransBean" property="strWarningMsg"/></div>
			<div id="normalMsg" class="normalMsg"><bean:write name="acknowledgeTransBean" property="strNormalMsg"/></div>
		</center>

 		<logic:equal  value="0" name="acknowledgeTransBean" property="strComboVal">		
<!--  <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
 		<tr class="FOOTER">
		 <td colspan="4"></td>
	</tr>
	<tr>
		<td align="center" colspan="4">
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" title="Click to Return On Desk" onClick="cancelToDesk();" >
			<br>
			<a href="#" class="button" onclick="cancelToDesk();"><span class="cancel">Cancel</span></a>
		</td>
	</tr>
</table> -->
			<div class="legend2" id='nonPrintableLegend2'>
				<button type="button" 
					class="float-right btn btn-danger mt-1 btn-circle cancelbtn"
					onclick="cancelToDesk();" style="border-radius:50%;  padding:10px 12px" title="Cancel">
					<i class="fas fa-times iround" title="Cancel"></i>
				</button>
			</div>
		</logic:equal>	 
 
		<logic:equal  value="1" name="acknowledgeTransBean" property="strComboVal">		
			<div class="legend2" id='nonPrintableLegend2'>
				<button type="button" 
					class="float-right btn btn-danger mt-1 btn-circle cancelbtn"
					onclick="cancelToDesk();" style="border-radius:50%;  padding:11px 12px" title="Cancel">
					<i class="fas fa-times iround" title="Cancel"></i>
				</button>
				
				<button type="button" 
					id="printButton" style="border-radius:50%; padding:11px 11px;" 
					onclick="getPrintReport2();" class="float-right btn btn-primary printbtn mt-1">
					<i title="Print" class="fas fa-print"></i>
				</button>
			</div>
		</logic:equal>	

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
   
	   <div class="popUpDiv" id="popUpDiv1" style="display:none;">
		   <table bgcolor="white">
		     <tr>
		      <td>
		         <div id="transferDtlsDivId" style="display:block;"></div>
		      </td>
		     </tr>
		    </table>
	   </div>
 
	   <div><bean:write name="acknowledgeTransBean" property="strAcknowledgeDetails" filter="false"/></div>

	   <div class="legendHeader my-2" id="" style="font-weight:600;font-size: 16px;">Acknowledge Detail(s)</div>
		<div id="ackDtlDivId" style="display: none;">
			<bean:write name="acknowledgeTransBean" property="strAckDtls" filter="false"/>
		</div>
	   <div>
	   
	   <div class="legendHeader my-2" id="" style="font-weight:600;font-size: 16px;">Drug Detail(s)</div>
			<bean:write name="acknowledgeTransBean" property="strItemDetails" filter="false"/>
 	   </div>
 	
	  <input type="hidden" name="hmode"/>
	  <input type="hidden" name="strPath"          value="${acknowledgeTransBean.strPath}">
	  <input type="hidden" name="strComboVal"      value="${acknowledgeTransBean.strComboVal}">
	  <input type="hidden" name="strTransNo"       value="${acknowledgeTransBean.strTransNo}">
	  <input type="hidden" name="strStoreId"       value="${acknowledgeTransBean.strStoreId}">
	  <input type="hidden" name="strRequestTypeId" value="${acknowledgeTransBean.strReqTypeId}">
	  <input type="hidden" name="strAckStatus" value="1">  
	  <input type="hidden" name="strReturnStatus" value="1">
	  <input type="hidden" name="strReqTypeId" value="${acknowledgeTransBean.strReqTypeId}">
  
	 <cmbPers:cmbPers/>

   
	</div>
</div>
</html:form>
<tag:autoIndex></tag:autoIndex>
</body>
</html>