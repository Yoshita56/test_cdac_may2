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


<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../js/acknowledgeDesk_trans.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script> 

</head>
<body onload="getCmbValView();">
<html:form name="acknowledgeTransBean" action="/transactions/AcknowledgeTransBSCNT"
	type="mms.transactions.controller.fb.AcknowledgeTransFB">
	<fieldset>
	<legend class='legendHeader' id='nonPrintableLegend'>Acknowledge Desk</legend>
	<div class="legend2" id="saveId">
		
		<button id="cancelButton" type="button" class="btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="cancelToDesk();">
		<div class="popupToast"><i class="fa fa-ban iround"  title="Cancel"></i><span class="popuptextToast">Cancel</span></div>
		</button>	
		<button  id="printbutton" type="button" class="btn btn-outline-primary mt-1 btn-circle printbtn" data-toggle="modal" data-target="" style="background-color:#2e79b4;" id=" " onclick=' return getPrintReport2();'>
			<div class="popupToast"><i class="fa fa-print iround"  title="Print Last Voucher"></i> <span class="popuptextToast">Print</span></div>
		</button>										                 
  </div> 
<center>
	<div id="errMsg" class="errMsg"><bean:write name="acknowledgeTransBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write name="acknowledgeTransBean" property="strWarningMsg"/></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="acknowledgeTransBean" property="strNormalMsg"/></div>
	
</center>
<div class="prescriptionTile">
		<%-- <tag:tab tabLabel="Acknowledge Desk"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
              </tag:tab>
	 --%>
	<!-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	<tr class="HEADER">
			<td colspan="4"></td>
	</tr>
		
   </table> -->
 
	<bean:write name="acknowledgeTransBean" property="strAcknowledgeDetailsBS" filter="false"/>
	<bean:write name="acknowledgeTransBean" property="strItemDetailsBS" filter="false"/>
	
	
	
	<div id="ackDtlDivId" style="display: none;">
		<bean:write name="acknowledgeTransBean" property="strAckDtlsBS" filter="false"/>
	</div>
	
	
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
 </logic:equal>	 
 
 <logic:equal  value="1" name="acknowledgeTransBean" property="strComboVal">		
	<!--  <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">
  		
  		<tr class="FOOTER">
			 <td colspan="4"></td>
		</tr>
		
		<tr>
			<td align="center" colspan="4">
			
			<img style="cursor: pointer" src="../../hisglobal/images/print_tab.gif" title="Click to Return On Desk" onClick="getPrintReport2();" >
			<img style="cursor: pointer" src="../../hisglobal/images/btn-ccl.png" title="Click to Return On Desk" onClick="cancelToDesk();" >
			</td>
		</tr>
	</table> -->
	<!-- <br> -->
	<!-- <div align="center" id=" ">					 
					 	<a href="#" class="button" id=" " onclick=' return getPrintReport2();'><span class="print">Print</span></a>
						<a href="#" class="button" onclick="cancelToDesk();"><span class="cancel">Cancel</span></a>
					</div> -->
 </logic:equal>	 
	
	
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
   </div>
   </fieldset>
</html:form>
<%-- <tag:autoIndex></tag:autoIndex>
 --%></body>
</html>