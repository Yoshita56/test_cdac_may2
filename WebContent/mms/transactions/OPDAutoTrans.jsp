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

<!-- JS -->
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/css/newlayout.css" rel="stylesheet" type="text/css">

<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>

<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>

<!-- EXT JS -->
<script language="Javascript" src="../js/OPDAutoIssueTransBs.js"></script>
<script language="Javascript" src="../js/IssueDetailsUtil.js"></script>
<script language="Javascript" src="../js/ValidationCommonn.js"></script>

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
	width:auto;
	left:150px;
}}

</style>
    
</head>
<body  onLoad="checkMsg();">

<html:form name="opdIssuePatAutoBean" action="/transactions/OPDIssueToPatAutoTransCNT" type="mms.transactions.controller.fb.OPDIssueToPatAutoTransFB">
	<fieldset>
		<legend class='legendHeader' id='nonPrintableLegend'>Drug Dispensing For OPD</legend>
		
		 <div class="legend2" id='nonPrintableLegend2'>
		 
			<button id="cancelButton" type="button" class="btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="cancelFunc();" title="Cancel">
				<div class="popupToast"><i class="fa fa-times iround"  title="Cancel"></i></div>
			</button>
				
			<button name="opdIssuePatAutoBean"  type="button" class="btn btn-primary mt-1 btn-circle" property="strViewChk" onclick="toViewPage();" title="Click Here To View Previous Issue">
				<i class="fas fa-eye iround" title="Click Here To View Previous Issue"></i>
			</button>
						
 		 </div>
 		 
<div class="alert alert-danger   alert-dismissible fade show" id="errID" style="display: none;"><bean:write name="opdIssuePatAutoBean" property="strErrMsg" /></div>
<div class="alert alert-warning  alert-dismissible fade show" id="wrnID" style="display: none;"><bean:write name="opdIssuePatAutoBean" property="strWarningMsg" /></div>
<div class="alert alert-success  alert-dismissible fade show" id="normalMsg" style="display: none;" ><bean:write name="opdIssuePatAutoBean" property="strNormalMsg" /></div>
		
		<div id="LFWise" style="display:none"> 
  		  <input type="text" name="strLFNo" value ="${opdIssuePatAutoBean.strLFNo}" js=" onkeypress='return initGoFunc(event);'"/>
   		  <input type="image" style="cursor:pointer;cursor:pointer;margin-top: 3px;" title="Issue Process" 
		    align="top" src ="../../hisglobal/images/Go.png" name="go" value="Go" 
		    onclick="return getPatientAccStatus();" onkeyup="goFuncOnEnter(event);">   		    
		</div>   

	<div class="container-fluid">
		<div class="prescriptionTile">
									 
				<div id="goBox">
					<div class="row rowFlex reFlex" style="margin:1% 2%">
						<div class="col-sm-2">
								<label>Store Name</label>
						</div>
						<div class="col-sm-3">
							<%-- <select name="strStoreId" onchange=" getItemCat();  " class="browser-default custom-select">
								<bean:write name="opdIssuePatAutoBean" property="strStoreValues" filter="false" />
							</select> --%>
							<select name="strStoreId" onchange=" " class="browser-default custom-select">
								<bean:write name="opdIssuePatAutoBean" property="strStoreValues" filter="false" />
							</select>
						</div>
																	
						<div class="col-sm-1" align="right"><font id="mandCRId" color="red">*</font><label>CR No.</label></div>
						<div class="col-sm-3">
							<div id="patientCrEdId">
								<crNo:crNo value ="${opdIssuePatAutoBean.strCrNo}" js=" onkeypress='return initGoFunc(event);'"></crNo:crNo>
							</div>													
						</div>
						<div class="col-sm-3">
							<span class="fa fa-search" style="cursor: pointer; display: none;" id="searhPatientImageId" title="Click here for Patient Search" name="searchPatient" onclick="showPatientListingWindow('4',document.forms[0].strCrNo,'setSelectedCrNo');"></span>
								<a href="#" class="btn btn-sm btn-success" onclick="getPatientAccStatus();" id='goBtnId' onkeyup="goFuncOnEnter(event);" style="font-size: 1rem;">
								GO&nbsp;<i class="fas fa-angle-double-right"></i>
								</a>
						</div>									
					</div>
				</div>
			<hr>
				<div class="row rowFlex reFlex">
						<div class="col-sm-10"></div>
						<div class="col-sm-2" align="right"><font color="red">*</font>Fields Mandatory</div>				
				</div>				
	 </div>
</div>
	<input type="hidden" name="hmode" />
	<input type="hidden" name="storeName" 				value="${opdIssuePatAutoBean.storeName}" />
	<input type="hidden" name="itemCatName" 			value="${opdIssuePatAutoBean.itemCatName}" />
	<input type="hidden" name="crNo" 					value="${opdIssuePatAutoBean.strCrNo}" />
	<input type="hidden" name="strId" 					value="${opdIssuePatAutoBean.strId}" />
	<input type="hidden" name="strConfCatCode" 			value="${opdIssuePatAutoBean.strConfCatCode}" />
	<input type="hidden" name="itemCategory" 			value="${opdIssuePatAutoBean.itemCategory}" />	
	<input type="hidden" name="strMode"   				value="${opdIssuePatAutoBean.strMode}">
	<input type="hidden" name="strIssueMode"   			value="${opdIssuePatAutoBean.strIssueMode}">
	<input type="hidden" name="strIssueNum" 			value="${opdIssuePatAutoBean.strIssueNum}" />
	<input type="hidden" name="strIssueNumber" 			value="${opdIssuePatAutoBean.strIssueNum}" />
	<input type="hidden" name="strVisitDtl" 			value="${opdIssuePatAutoBean.strVisitDtl}" />
	<input type="hidden" name="strDoseFrqFlg" 			value="${opdIssuePatAutoBean.strDoseFrqFlg}" />
	<input type="hidden" name="strReOrderFlgColor" 		value="${opdIssuePatAutoBean.strReOrderFlgColor}" />	
	<input type="hidden" name="strLFAccountNo" 			value="${opdIssuePatAutoBean.strLFAccountNo}" />
	<input type="hidden" name="strLFAccountOpenDate" 	value="${opdIssuePatAutoBean.strLFAccountOpenDate}" />
	<input type="hidden" name="strLFDepositedAmount" 	value="${opdIssuePatAutoBean.strLFDepositedAmount}" />
	<input type="hidden" name="strLFBalanceAmount" 		value="${opdIssuePatAutoBean.strLFBalanceAmount}" />
	<input type="hidden" name="strLFAccountStatus" 		value="${opdIssuePatAutoBean.strLFAccountStatus}" />
	<input type="hidden" name="strPath" 				value="${opdIssuePatAutoBean.strPath}" />
	<input type="hidden" name="printReq" 				value="${opdIssuePatAutoBean.printReq}" />
	<input type="hidden" name="strOfflineOPDFlag" 		value="${opdIssuePatAutoBean.strOfflineOPDFlag}" />
	<input type="hidden" name="strInvalidCrFlag" 		value="${opdIssuePatAutoBean.strInvalidCrFlag}" />


<div id="blanket" style="display: none;"></div>

<!-- <div class="popUpDiv" id="popUpDiv" style="display: none;">
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
</div> -->

<div class="modal" id="printModal">
	<div class="modal-dialog modal-xl">
		<div class="modal-content">
			<div class="modal-body" id="printableSlip" >
				<logic:equal name="opdIssuePatAutoBean"
					property="isOpenPopUp" value="1">						
						<logic:present name="opdIssuePatAutoBean"
							property="strPrintBill">
							<jsp:include page="/mms/transactions/billing_receipt_printing_popupNew.jsp"></jsp:include>
						</logic:present>						
				</logic:equal>		
			</div>
		</div>
	</div>
</div>
<!-- 
<div class='modal' id='searchPopupModalID'>
	<div class='modal-dialog modal-lg' style='max-width:90vw; max-height: 65vh;'>
		<div class='modal-content'>
			<div class='modal-header' style='height:11vh;'>
				<h3 class='modal-title text-left'>Patient Search</h3>
				<button type='button' class='close' data-dismiss='modal' style='margin-top:-36px;'>×</button>
			</div>
			<div class='modal-body' style='width:90vw; height: 65vh;'>
			<iframe src='' style='width: 100%; height: 100%; border: none;'></iframe>
			</div>
		</div>
	</div>
</div> -->

</fieldset>
</html:form>
</body>
</html>
