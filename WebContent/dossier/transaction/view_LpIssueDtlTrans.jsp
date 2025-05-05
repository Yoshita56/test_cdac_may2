<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/INVMGM/mms/css/transaction.css" rel="stylesheet" type="text/css">
<link href="/INVMGM/mms/css/master.css" rel="stylesheet" type="text/css">
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
<script language="JavaScript" src="../js/lpIssue.js"></script>
<script language="JavaScript" src="../js/lpIssue_Print.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script type="text/javascript">


</script>
<title>LP Issue</title>
    <style>
        .example {
            page-break-after: always;
        }
    </style>
</head>
<body> <!--  onload="getReport1();openDiv();getReport();" -->
<html:form action="/transaction/LPIssueDeskTransCNT"  name="lpIssueDeskTransBean" type="dossier.transaction.controller.fb.LPIssueDeskTransFB" method="post">

    <div class="errMsg"  id="errMsg"><bean:write name="lpIssueDeskTransBean" property="strErr"/></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="lpIssueDeskTransBean" property="strWarning"/></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="lpIssueDeskTransBean" property="strMsg"/></div>


<center>
<tag:tab tabLabel="Dossier Issue Desk View" selectedTab="FIRST" align="center" width="TABLEWIDTH">
	</tag:tab>
</center>
<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">

		<tr class="HEADER">
			<td colspan="4">Dossie Issue Desk &gt;&gt; View</td>
		</tr>
</table>
<div style=''><table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>
	<tr>
		<td class='LABEL' width='25%'>Store Name</td>
		<td class='CONTROL' width='25%'>
			<bean:write property="strStoreName" name="lpIssueDeskTransBean" filter="false"/>
		</td>
		<td class='LABEL' width='25%'>Cr No</td>
		<td class='CONTROL' width='25%'>
			<bean:write property="strCrNo" name="lpIssueDeskTransBean" filter="false"/>
		</td>
	</tr>
	<tr>
		<td class="LABEL" width="25%">Request No</td>
		<td colspan="3" class="CONTROL" width="75%"><bean:write property="strLpRequestNo" name="lpIssueDeskTransBean" filter="false"/> </td>
	</tr>
	
</table></div>

<div style="display:none;">
	<bean:write property="strRequestDtl" name="lpIssueDeskTransBean" filter="false"/>
</div>

<div id="patientDtlId">

</div>	
		<div id="patientAdmissionDtlId" style="">
			<bean:write property="strPatientDtl" name="lpIssueDeskTransBean" filter="false"/>
		</div>
		
	<!-- <div style='display:none'>	<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px">
		<tr>
			<td  colspan="4" class="TITLE">
			<div id="plusRequestItemDtlId" align="left" style="display:block;color:white;">
					<img src="../../hisglobal/images/plus.gif" 
									onClick="view1('plusRequestItemDtlId','minusRequestItemDtlId','strRequestItemDtlId');" style="cursor: pointer; "/>
						Requested Item Detail
						
					</div>
					<div id="minusRequestItemDtlId" style="display:none;color:white;" align="left">
						<img src="../../hisglobal/images/minus.gif" 
								onClick="view2('plusRequestItemDtlId','minusRequestItemDtlId','strRequestItemDtlId');" style="cursor: pointer; "/>
							Requested Item Detail
					</div>
				</td>
		</tr>
	</table></div> -->
	
	

	
		<div id="strRequestItemDtlId" style="display: none">
			<bean:write property="strRequestItemDtl" name="lpIssueDeskTransBean" filter="false" />
		</div>
		
		<table class="TABLEWIDTH" align="center" cellspacing="1px" cellpadding="1px" style="display: none;">
			<tr>
				<td  colspan="4" class="TITLE">
				<div id="plusDiagId" align="left" style="display:block;color:white;">
						<img src="../../hisglobal/images/plus.gif" 
										onClick="view1('plusDiagId','minusDiagId','strDiagId');" style="cursor: pointer; "/>
							Diagnosis Detail
							
						</div>
						<div id="minusDiagId" style="display:none;color:white;" align="left">
							<img src="../../hisglobal/images/minus.gif" 
									onClick="view2('plusDiagId','minusDiagId','strDiagId');" style="cursor: pointer; "/>
								Diagnosis Detail
						</div>
					</td>
			</tr>
		</table>
	
	

	
		<%-- <div id="strDiagId" style="display: none">
		<bean:write property="strDiagDtl" name="lpIssueDeskTransBean" filter="false" />
		</div> --%>
		
		<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			<tr class="HEADER">
				<td colspan="4">Issue Item Details</td>
			</tr>
		</table>
	
		<div id="issueItemDtlId" style="display: block">
		<bean:write property="strIssueItemId" name="lpIssueDeskTransBean" filter="false" />
		
		<input type="hidden" value="0.00" name="strApproxAmtDivId" id="strApproxAmtDivId" >
			<input type="hidden" name="strFinalApproxAmt">
		</div>
		
		<logic:equal value="0" property='strBSReqNo' name='lpIssueDeskTransBean' ><table class="TABLEWIDTH" align="center" cellspacing="1px">
	 	<tr>
	 		<td class="LABEL" width="50%"><font color='red'>*</font>Raise LP Indent</td>
	 		<td class="CONTROL" width="50%">
	 			<input type="radio" name="strBSIndent" onchange='chkradio(this);' value="1"  />Yes &nbsp;&nbsp;
	 			 <input type="radio" name="strBSIndent" onchange='chkradio(this);' value="0" />No
	 		</td>
	 		
	 	</tr>
	 	
	 </table></logic:equal>
	 <div style='display:none;'>  <table class="TABLEWIDTH" align="center" cellspacing="1px">
		  <tr>
	 		<td class="LABEL" width="50%">Utility Certificate Required</td>
	 		<td class="CONTROL" width="50%">
	 		<html:radio property="strUCReq" name="lpIssueDeskTransBean" value="1">Yes&nbsp;&nbsp;&nbsp;&nbsp;</html:radio>
	 		<html:radio property="strUCReq"  name="lpIssueDeskTransBean" value="0">No</html:radio>
	 			
	 		</td>
	 		
	 	</tr>
	</table> 	</div>
		  <!-- <table class="TABLEWIDTH" align="center" cellspacing="1px">
	 	<tr>
	 		<td class="LABEL" width="50%">Received by</td>
	 		<td class="CONTROL" width="50%">
	 			<input name="strReceivedby" autocomplete='off' value="" class="txtFldMax" onkeypress="return validateData(event,4);" >
	 		</td>
	 		
	 	</tr>
	 	<tr>
	 		<td class="LABEL">
	 			Remarks
	 		</td>
	 		<td class="CONTROL">
	 			<textarea maxlength = 100 name="strRemarks"></textarea>
	 		</td>
	 	</tr>
	 	
	 </table> -->
	 
		<table CLASS ="TABLEWIDTH" align="center" cellspacing="1px">
		<tr class="FOOTER"> 
    	<td  ><div align='left'><font size='2' color="yellow"></font></div></td>
    	<td ><font size="2" color="red">*</font> Mandatory Fields  </td>
  		</tr>
	     <tr> 
		<!-- <td align="center">
		<img src="../../hisglobal/images/btn-sv.png"   onClick="SAVE();" style="cursor: pointer;" title="Click Here To Save"/>
		<img src="../../hisglobal/images/btn-clr.png"
				onClick="document.forms[0].reset();" style="cursor: pointer;" title="Click here to reset the data">
		<img src="../../hisglobal/images/back_tab.png" onClick ="cancelToDesk();" style="cursor: pointer;" title="Click Here To Cancel"/>
	   </td> -->
	   
	   <td colspan='2' align="center">
	   <br>
			<a href="#" class="button" id="" onclick=" getReport1();" tabindex="1"><span class="print">Print</span></a> 
			<a href="#" class="button" onclick="cancelToDesk();"><span class="cancel">Cancel</span></a>
	   </td>
	  </tr>
	  
	<!-- <tr >
			<td align='left'><font color="Blue" size="2" >Integration with e-Aushadhi : <logic:equal name="lpIssueDeskTransBean" property="strSCMIntegration" value="1">Yes</logic:equal><logic:notEqual name="lpIssueDeskTransBean" property="strSCMIntegration" value="1">No</logic:notEqual></font></td>
			
		</tr>  --> 
</table>

<div id="blanket" style="display:none;"></div>
<div class="popUpDiv" id="popUpDiv" style="display:none;">

<table bgcolor="white">

<tr>

<td>

 <div id="issueDtlsDivId" style="display:block;"></div>
 <div id="stockDtlsDivId" style="display:block;"></div>
 <!--<div id="divBrandDtlId" class='popup' style="display: none; left:500px; top:170px;"></div>-->

</td>

</tr>

</table>

</div>
		<input type="hidden" name="hmode"/>
		 <input type="hidden" name="strRequestTypeId" value="${lpIssueDeskTransBean.strRequestTypeId}"/>
	    <input type="hidden" name="strStoreId" value="${lpIssueDeskTransBean.strStoreId}"/>
	     <input type="hidden" name="strRequestDate" value="${lpIssueDeskTransBean.strRequestDate}"/>
	     <input type="hidden" name="strCrNo" value="${lpIssueDeskTransBean.strCrNo}"/>
	     <input type="hidden" name="strEmpNo" value="${lpIssueDeskTransBean.strEmpNo}"/>
	     <input type="hidden" name="strLpRequestNo" value="${lpIssueDeskTransBean.strLpRequestNo}"/>
	     <input type="hidden" name="strItemCategNo" value="${lpIssueDeskTransBean.strItemCategNo}"/>
	      <input type="hidden" name="strRaisingReqTypeId" value="${lpIssueDeskTransBean.strRaisingReqTypeId}"/>
	     <input type="hidden" name="strRaisingStoreId" value="${lpIssueDeskTransBean.strRaisingStoreId}"/>
	     <input type="hidden" name="strPoNo" value="${lpIssueDeskTransBean.strPoNo}"/>
	     <input type="hidden" name="strPoStoreId" value="${lpIssueDeskTransBean.strPoStoreId}"/>
	      <input type="hidden" name="chk" value="${lpIssueDeskTransBean.strChk}"/>
	      <input type="hidden" name="strIssueNo" value="${lpIssueDeskTransBean.strIssueNo}"/>
	       <input type="hidden" name="strStoreName" value="${lpIssueDeskTransBean.strStoreName}"/>
	       <input type="hidden" name="strBudgetFlg" value ="${lpIssueDeskTransBean.strBudgetFlg}"/>
	        <input type="hidden" name="strUrgentFlg" value ="${lpIssueDeskTransBean.strUrgentFlg}"/>
	        <input type="hidden" name="strBSReqNo" value ="${lpIssueDeskTransBean.strBSReqNo}"/>
	        <input type="hidden" name="strBillPaidCat" value ="${lpIssueDeskTransBean.strBillPaidCat}"/>
	           <input type="hidden" name="strBillingHiddenValue" value ="${lpIssueDeskTransBean.strBillingHiddenValue}"/>
	           <input type="hidden" name="printReq" value ="${lpIssueDeskTransBean.printReq}"/>
	           <input type="hidden" name="strPatientType" value ="${lpIssueDeskTransBean.strPatientType}"/>
	            <input type="hidden" name="strDossierShortName" value ="${lpIssueDeskTransBean.strDossierShortName}"/>
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
	<div class="popUpDiv" id="popUpDiv1" style="display:none;">
   <table bgcolor="white">
     <tr>
      <td>
         <div id="transferDtlsDivId" style="display:block;"></div>
      </td>
     </tr>
    </table>
   </div>
   
</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>