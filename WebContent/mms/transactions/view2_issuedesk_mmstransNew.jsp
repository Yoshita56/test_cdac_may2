

<!--
Developer : Anshul Jindal
  Version : 1.0 
  Date : 11/June/2009
   Module:MMS
  Unit:Issue Desk Transaction
    -->
    
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
<script language="JavaScript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../js/issueDetails_util.js"></script>
<script language="Javascript" src="../js/issuedesk_trans.js"></script>

</head>
<body>
<html:form name="issueDeskTransBean" action="/transactions/IssueDeskTransBSCNT"
	type="mms.transactions.controller.fb.IssueDeskTransFB">
	
	<fieldset>
	<legend class='legendHeader' id='nonPrintableLegend'>Issue Desk View</legend>
	<div class="legend2" id="saveId">
		
		<button id="cancelButton" type="button" class="btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="cancel();">
		<div class="popupToast"><i class="fa fa-ban iround"  title="Cancel"></i><span class="popuptextToast">Cancel</span></div>
		</button>	
		<button  id="printbutton" type="button" class="btn btn-outline-primary mt-1 btn-circle printbtn" data-toggle="modal" data-target="" style="background-color:#2e79b4;"  id="submitId" onclick='getReport();' style="">
			<div class="popupToast"><i class="fa fa-print iround"  title="Print Last Admission Slip"></i> <span class="popuptextToast">Print</span></div>
			</button>											                 
  </div>
<center>
	<div id="errMsg" class="errMsg"><bean:write name="issueDeskTransBean"
		property="strErr" /></div>
	<div class="warningMsg"><bean:write name="issueDeskTransBean"
		property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write name="issueDeskTransBean"
		property="strNormalMsg" /></div>


<%-- 	<tag:tab tabLabel="Issue Desk"
				selectedTab="FIRST" align="center" width="TABLEWIDTH">
			</tag:tab>
			</center> --%>
			
<div class="prescriptionTile"> 	

<div class='row'>
<div class='col-sm-2'></div>
<div class='col-sm-2'>
<label>Issuing Store Name</label>
</div>
<div class='col-sm-2' style='font-weight: 400; color: blue;' align="left">
<bean:write name="issueDeskTransBean" property="strStoreName" />
</div>
</div>
<div class='row'>
<div class='subHeaders'>
Request Details
</div>
</div>
<div class='row' style='line-height: 1.0;'>
<div class='col-sm-2'></div>
<div class='col-sm-2'>
<label>Request No</label>
</div>
<div class='col-sm-2' style='font-weight: 400; color: blue;' align="left">
<bean:write name="issueDeskTransBean" property="strIndentNo" />
</div>
<div class='col-sm-2'>
<label>Request Date</label>
</div>
<div class='col-sm-2' style='font-weight: 400; color: blue;' align="left">
<bean:write name="issueDeskTransBean" property="strIndentDate" />
</div>
<div class='col-sm-2'></div>
</div>



<div class='row' style='line-height: 1.0;'>
<div class='col-sm-2'></div>
<div class='col-sm-2'>
<label>Category</label>
</div>
<div class='col-sm-2' style='font-weight: 400; color: blue;' align="left">
<bean:write name="issueDeskTransBean" property="strItemCategory" />
</div>
<div class='col-sm-2'>
<label>Request Date</label>
</div>
<div class='col-sm-2' style='font-weight: 400; color: blue;' align="left">
<bean:write name="issueDeskTransBean" property="strRaisingStoreName" />
</div>
<div class='col-sm-2'></div>
</div>
<div class='row'>
<div class='subHeaders'>
Details
</div>
</div>

	<%-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" border="0">

		<tr class="HEADER">
		
			<td colspan="4"></td>
		</tr>

			<tr>
				<td class="LABEL" width="50%" colspan="2">Issuing Store Name11</td>
				<td width="50%" class="CONTROL" colspan="2"><bean:write name="issueDeskTransBean" property="strStoreName" /></td>
	
			</tr>
			
			<tr>
				<td  colspan="4" class="TITLE" width="25%">
					<div id="PlusDivId" align="left" style="display:none;">
						<img src="../../hisglobal/images/plus.gif" 
										onClick="clickPlus();" style="cursor: pointer; "/>
							Request Details
						</div>
						<div id="MinusDivId" style="display:block;" align="left">
							<img src="../../hisglobal/images/minus.gif" 
									onClick="clickMinus();" style="cursor: pointer; "/>
									Request Details
						</div>
				</td>
			</tr>		
		</table> --%>
		
		<%-- <div id="ReqDtlsDiv">
			<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" border="0">
				
				<tr>
						<td width="25%" class="LABEL">Request No.</td>
						<td width="25%" class="CONTROL"><bean:write name="issueDeskTransBean" property="strIndentNo" /></td>
							<td width="25%" class="LABEL">Request Date</td>
						<td width="25%" class="CONTROL"><bean:write name="issueDeskTransBean" property="strIndentDate" /></td>
					</tr>
					<tr>
							<td width="25%" class="LABEL"> Category</td>
						<td width="25%" class="CONTROL"><bean:write name="issueDeskTransBean" property="strItemCategory" /></td>
							<td class="LABEL" width="25%">Raising Store</td>
					<td width="25%" class="CONTROL"><bean:write name="issueDeskTransBean" property="strRaisingStoreName" /></td>
				
			</table>
		</div> --%>
		<!-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" border="0">
		
		<tr class="TITLE">
			<td colspan="4"><div id='' > Details</div></td>
		</tr>
		</table> -->
		<table class="table" align="center" cellpadding="1px" cellspacing="1px" border="0">
		<thead>
		
			<th width='40%' align="left">Name</th>
			<th width='15%' align="left">Batch/Sl No.</th>
			<th width='15%'align="right">Sanc Qty.</th>
			<th width='15%' align="right">Issued Qty</th>
			<th width='15%' align="left">Remarks</th>
	
		</tr>
		</table>
		<div id="itemDtlsDiv"><bean:write name="issueDeskTransBean" property="strIssuedItemDtls" filter="false"></bean:write></div>
		<br>
		<div class='row'>
		<div class='col-sm-2'></div>
		<div class='col-sm-2'>
		<label>Received By</label>
		</div>
		<div class='col-sm-2' style='font-weight: 400; color: blue;' align="left">
		<bean:write name="issueDeskTransBean" property="strReceivedBy" />
		</div>
		<div class='col-sm-2'>
		<label>Remarks</label>
		</div>
		<div class='col-sm-2' style='font-weight: 400; color: blue;' align="left">
		<bean:write name="issueDeskTransBean" property="strRemarks" />	
		</div>
		</div>
		<%-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px" border="0">
		<tr >
    <td width ="50%" class ="LABEL" valign="middle" colspan="2">Received By</td>
    <td width ="50%" class ="CONTROL" colspan="2"><bean:write name="issueDeskTransBean" property="strReceivedBy" /></td>
  </tr>
			<tr >
    <td width ="50%" class ="LABEL" valign="middle" colspan="2">Remarks</td>
    <td width ="50%" class ="CONTROL" colspan="2"><bean:write name="issueDeskTransBean" property="strRemarks" /></td>
  </tr>
		<tr class="FOOTER">
			 <td colspan="4"> </td>
		</tr>
	</table> --%>
	<!-- 
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			
<img style="cursor: pointer" src="../../hisglobal/images/print_tab.gif" onClick="getReport();" />
<img style="cursor: pointer; " title="Click Here Go Back To Main Desk " 
src="../../hisglobal/images/back_tab.png" onClick="cancel();" />
			
			</td>
		</tr>
	</table> -->
	<!-- <br>
	<div align="center" id="saveId">					 
					 	<a href="#" class="button" id="submitId" onclick='getReport();'><span class="print">Print</span></a>
						<a href="#" class="button" onclick="cancel();"><span class="cancel">Cancel</span></a>
					</div>  -->
	
	
<div id="blanket" style="display:none;"></div>
	<div class="popUpDiv" id="popUpDiv" style="display:none;">
	
	<table bgcolor="white">
	
	<tr>
	
	<td>
	
	<div id="stockDtlsDivId" style="display:block;"></div>
	<div id="itemOtherDtlsDiv" style="display:block;" class="popup" ></div>
	 <div id="issueDtlsDivId" style="display:block;"></div>
	
	</td>
	
	</tr>
	
	</table>

</div>	
<input type="hidden" name="hmode"/>
 <input type="hidden" name="strErr" value=""/>

<cmbPers:cmbPers/>
</div>
</fieldset>

</html:form>

<div class="popup" id="popup" style="display: none"></div>
<%-- <tag:autoIndex></tag:autoIndex> --%>
</body>
</html>