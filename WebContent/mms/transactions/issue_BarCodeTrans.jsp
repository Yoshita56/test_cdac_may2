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
<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script language="Javascript" src="../js/issue_BarCode.js"></script>
<script language="Javascript" src="../js/issueDetails_util.js"></script>

<script type="text/javascript">
	function setvalue()
	{	
		
	}
	
	function focusCrNo()
	{	
		var crNoField = document.getElementById("CrNOOrLf");
	    	if (crNoField) {
	        	crNoField.focus();
	    }
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
<body onLoad="checkMsg(); focusCrNo();">

<html:form name="issueBarCodeBean" action="/transactions/IssueToPatientBarCodeTransCNT" type="mms.transactions.controller.fb.IssueToPatientBarCodeTransFB">
	<fieldset>
		<legend class='legendHeader' id='nonPrintableLegend'>Bar Code Dispensing For IPD</legend>
			<div class="legend2" id='nonPrintableLegend2'>
				<button id="cancelButton" type="button" class="btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="cancelFunc();">
				<div class="popupToast"><i class="fa fa-ban iround"  title="Cancel"></i><span class="popuptextToast">Cancel</span></div>
				</button>	
				<button type="button"  class="float-right btn btn-primary mt-1 btn-circle " onclick="getViewPage();" title="Click Here To View Off Line Issue Item Detail" style="border-radius:50%; padding:6px 8px;" >
						<i class="fas fa-eye iround" title="View"></i>
				</button>
				
			    <button  type="button" id="savebutton" class="btn btn-outline-success mt-1 btn-circle savebtn"  tabindex='2' onClick="return validate1NA();"   data-toggle="" data-target="#previewModal" style="display: none;">					
					<div class="popupToast"><i class="fa fa-save iround"  title="Save"></i> <span class="popuptextToast">save</span></div>
				</button>												                 
	 		</div>
 		 
	<div class="alert alert-danger  alert-dismissible fade show" id="errID" style="display: none;"><bean:write name="issueBarCodeBean" property="strErrMsg" /></div>
	<div class="alert alert-warning  alert-dismissible fade show" id="wrnID" style="display: none;"><bean:write name="issueBarCodeBean" property="strWarningMsg" /></div>
	<div class="alert alert-success  alert-dismissible fade show" id="normalMsg" style="display: none;"><bean:write name="issueBarCodeBean" property="strNormalMsg" /></div>

	<logic:equal value="0" name="issueBarCodeBean" property="strMode" >
		<table class="TABLEWIDTH" align="center" border="0" cellspacing ="1px">
			<tr class="HEADER"> 
				 <td colspan="4">Bar Code Dispensing For IPD&gt;&gt;</td>
		<%-- Change Request		 --%>
				 <td align="right" >
				     	<!--<html:checkbox property="strWithoutCrNoCheckBox" name="issueBarCodeBean" value="1" onclick="goToWithoutCrNoPage();">Without CR No.</html:checkbox>-->
			     	  <%-- <html:checkbox property="strCancelCheckBox"      name="issueBarCodeBean" value="1" onclick="goToCancelPage();"      >Cancel Issue</html:checkbox>  --%>
			     	  <div style="display: none;">  
			     	  	<html:checkbox name="issueBarCodeBean" property="strViewChk" onclick="transferToViewPage();" title="Click Here To View Off Line Issue Drug Detail">Issue/View</html:checkbox>
			     	  </div>
			     </td>
		    </tr>
	    </table>
	</logic:equal>
			
	<div class="container-fluid">
	
	<div class="prescriptionTile">
									 
	<div id="goBox">
		<div class="row rowFlex reFlex">
			<div class="col-sm-1" align="right">
					<label><font id="mandCRId" color="red">*</font>Store</label>
			</div>
			<div class="col-sm-3">
					<!-- <input type="text" class="form-control" name="storeName" value=""
						tabindex="2" maxlength="20"> -->
						
				<select name="strStoreId" onchange="checkMsg();" class="browser-default custom-select">
					<bean:write name="issueBarCodeBean" property="strStoreValues"
						filter="false" />
				</select>
			</div>
			
		
			<div class="col-sm-2" align="right"><font id="mandCRId" color="red">*</font><label>CR No.</label></div>
				<div class="col-sm-3">
					<div id="patientCrEdId">
						<crNo:crNo value ="${issueBarCodeBean.strCrNo}" js=" onkeypress='return initGoFunc(event);'"></crNo:crNo>
					</div>													
				</div>
				<div class="col-sm-2">
					<span class="fa fa-search" style="cursor: pointer; display: none;" id="searhPatientImageId" title="Click here for Patient Search" name="searchPatient" onclick="showPatientListingWindow('4',document.forms[0].strCrNo,'setSelectedCrNo');"></span>
						<a href="#" class="btn btn-sm btn-success" onclick="getPatientAccStatus(1);" id='goBtnId' onkeyup="goFuncOnEnter(event);" style="font-size: 1rem;">
						GO&nbsp;<i class="fas fa-angle-double-right"></i>
						</a>
						
				</div>
				<div class="col-sm-1" align="left">
					<button type="button" class="btn btn-info btn-sm" tabindex="2" id='searchPopupButtonID' data-toggle="modal" data-target="#searchPopupModalID" style="float: right;" onclick="openPopupWithEventHeightWidth('/HISRegistration/registration/transactions/PatientSearch.action?mode=new',event,300,900,'strCrNo','goBtnId')">
			   		<span class="btn-label"></span><i class="fas fa-user-injured"></i>&nbsp;Search</button> 
				</div>						
				</div>
			</div>
			<hr>
			<div class="row rowFlex reFlex">
					<div class="col-sm-10"></div>
					<div class="col-sm-2" align="right"><font color="red">*</font>Fields Mandatory</div>				
			</div>				
	 </div></div>
	
	<input type="hidden" name="hmode" />
	<input type="hidden" name="storeName" 				value="${issueBarCodeBean.storeName}" />	
	<input type="hidden" name="crNo" 					value="${issueBarCodeBean.strCrNo}" />
	<input type="hidden" name="strId" 					value="${issueBarCodeBean.strId}" />	
	<input type="hidden" name="strMode"   				value="${issueBarCodeBean.strMode}">
	<input type="hidden" name="strIssueMode"   			value="${issueBarCodeBean.strIssueMode}">
	<input type="hidden" name="strIssueNum" 			value="${issueBarCodeBean.strIssueNum}" />
	<input type="hidden" name="strIssueNumber" 			value="${issueBarCodeBean.strIssueNum}" />
	<input type="hidden" name="strVisitDtl" 			value="${issueBarCodeBean.strVisitDtl}" />
	<input type="hidden" name="strDoseFrqFlg" 			value="${issueBarCodeBean.strDoseFrqFlg}" />
	<input type="hidden" name="strLFAccountNo" 			value="${issueBarCodeBean.strLFAccountNo}" />
	<input type="hidden" name="strLFAccountOpenDate" 	value="${issueBarCodeBean.strLFAccountOpenDate}" />
	<input type="hidden" name="strLFDepositedAmount" 	value="${issueBarCodeBean.strLFDepositedAmount}" />
	<input type="hidden" name="strLFBalanceAmount" 		value="${issueBarCodeBean.strLFBalanceAmount}" />
	<input type="hidden" name="strLFAccountStatus" 		value="${issueBarCodeBean.strLFAccountStatus}" />
	<input type="hidden" name="strPath" 				value="${issueBarCodeBean.strPath}" />
	<input type="hidden" name="printReq" 				value="${issueBarCodeBean.printReq}" />


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
 <div class="modal" id="printModal">
	<div class="modal-dialog modal-xl">
		<div class="modal-content">
			<div class="modal-body" id="printableSlip" >
					<logic:equal name="issueBarCodeBean"
						property="isOpenPopUp" value="1">						
							<logic:present name="issueBarCodeBean"
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
