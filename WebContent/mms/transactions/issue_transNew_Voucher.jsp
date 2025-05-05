<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>

<html>
<head>
<meta>
<title>Issue Process</title>

<!-- CSS -->
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/css/newlayout.css" rel="stylesheet" type="text/css">

<!-- JS -->
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<!-- <script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
 --><script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>

<script language="Javascript" src="../js/issue_transBS.js"></script>

<script language="Javascript" src="../js/issueDetails_util.js"></script>
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>

<script type="text/javascript">
	
	
	function printDiv() 
	{
        var divContents = document.getElementById("issueDtlsDivId").innerHTML;      
        var a = window.open('', 'printwin','text-align=center,top=100,width=800,height=800,scrollbars=yes ');
	        a.document.write('<html>');
	        a.document.write(divContents);
	        a.document.write('</html>');
	        a.document.close();
	        a.print();
        
    }
</script>

<style>
.example {
	page-break-after: always;
}

@media print {
	body * {
		visibility: hidden;
	}
	#printSection {
		visibility: visible;
		width: auto;
		left: 150px;
	}
}
</style>
    
</head>
<body  onLoad="getReport2();printData_O();">

<html:form name="issueBean" action="/transactions/IssueToPatientTransBSCNT" type="mms.transactions.controller.fb.IssueTransFB">
	<fieldset>
		<legend class='legendHeader' id='nonPrintableLegend'>Drug Dispensing For IPD</legend>
			 <div class="legend2" id='nonPrintableLegend2'>
				
			<button  type="button" class="btn btn-outline-primary mt-1 btn-circle printbtn" onClick="cancelToMainPage(3);">
				<div class="popupToast"><i class="fas fa-arrow-left iround" title="Back To Issue"></i><span class="popuptextToast">Back</span></div>
			</button>
			</div>
			 		 
	<div class="alert alert-danger  alert-dismissible fade show" id="errID" style="display: none;"><bean:write name="issueBean" property="strErrMsg" /></div>
	<div class="alert alert-warning  alert-dismissible fade show" id="wrnID" style="display: none;"><bean:write name="issueBean" property="strWarningMsg" /></div>
	<div class="alert alert-success  alert-dismissible fade show" id="normalMsg" style="display: none;"><bean:write name="issueBean" property="strNormalMsg" /></div>

		
	<div class="container-fluid">
	
	<div class="prescriptionTile" id="issueDtlsDivId">									 
		<div id="goBox">
			    <div class="row rowFlex reFlex">
						<div class="col-sm-12" >						       
								  <bean:write name="issueBean" property="strAfterSaveVoucher" 	filter="false" /> 	
								
						</div>
									
				</div>
		</div>
				
	 </div>
	 </div>
	
	<input type="hidden" name="hmode" />
	<input type="hidden" name="storeName" 		value="${issueBean.storeName}" />
	<input type="hidden" name="itemCatName" 	value="${issueBean.itemCatName}" />
	<input type="hidden" name="crNo" 			value="${issueBean.strCrNo}" />
	<input type="hidden" name="strId" 			value="${issueBean.strId}" />
	<input type="hidden" name="strMode"   		value="${issueBean.strMode}">
	<input type="hidden" name="strIssueMode"   	value="${issueBean.strIssueMode}">
	<input type="hidden" name="strIssueNum" 	value="${issueBean.strIssueNum}" />
	<input type="hidden" name="strIssueNumber" 	value="${issueBean.strIssueNumber}" />
	


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
 <div class="modal" id="printModal">
	<div class="modal-dialog modal-xl">
		<div class="modal-content">
			<div class="modal-body" id="printableSlip" >
					<logic:equal name="issueBean"
						property="isOpenPopUp" value="1">						
							<logic:present name="issueBean"
								property="strPrintBill">
								<jsp:include page="/mms/transactions/billing_receipt_printing_popupNew.jsp"></jsp:include>
							</logic:present>						
					</logic:equal>		
			</div>
		</div>
	</div>
</div>
<div class='modal' id='searchPopupModalID'><div class='modal-dialog modal-lg' style='max-width:90vw; max-height: 65vh;'><div class='modal-content'><div class='modal-header' style='height:11vh;'><h3 class='modal-title text-left'>Patient Search</h3><button type='button' class='close' data-dismiss='modal' style='margin-top:-36px;'>×</button></div><div class='modal-body' style='width:90vw; height: 65vh;'><iframe src='' style='width: 100%; height: 100%; border: none;'></iframe></div></div></div></div>
</fieldset>
</html:form>
</body>
</html>
