<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>
<%@ taglib uri="/WEB-INF/patientDtl.tld" prefix="pDtl"%>
<!-- RJ47 -->

<html>
<head>
	<meta charset=UTF-8">
	<title>OP Injection Administration</title>
	<link href="../../hisglobal/css/autocomplete.css" rel="stylesheet"	type="text/css">
	<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
	<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css" rel="stylesheet" />
	<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
	<link href="../../hisglobal/css/newlayout.css" rel="stylesheet" type="text/css">
	<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css" rel="stylesheet">
	
	<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet">
	<link href="../css/master.css" rel="stylesheet" type="text/css">
	<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
	
	<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
	<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
	
	<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script> 
	<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
	<script language="Javascript" src="../../hisglobal/js/util.js"></script>
	<script language="Javascript" src="../js/mms.js"></script>
	<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
	<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
	<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
	<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
	
		
	<script language="Javascript" src="../js/searchItems_util.js"></script>
	<script language="Javascript" src="../js/stockDetails_util.js"></script>
	<script language="Javascript" src="../js/issueDetails_util.js"></script>
	
	<script language="Javascript" src="../js/InjAdminTrans.js"></script>
    <script language="Javascript" src="../js/IssueDetailsUtil.js"></script>
<!--     <script language="Javascript" src="../js/opd_issue_auto_trans.js"></script> -->
    	
	<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
	<script language="Javascript" src="../js/ValidationCommonn.js"></script>
	
	<link rel="stylesheet" href="../../hisglobal/DataTables/css/jquery.dataTables.min.css">
	<script src="../../hisglobal/DataTables/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">


	$(document).ready(function() {
	    $('#data-table').DataTable();
	});
	
	
	function setRowIndex()
	{
		alert(document.forms[0].strRowCount.value);
		document.getElementsByName("rowIndex1")[0].value=document.forms[0].strRowCount.value;
		document.getElementsByName("rowLength1")[0].value=document.forms[0].strRowCount.value;
		//document.forms[0].rowIndex1.value=document.forms[0].strRowCount.value;
		//document.forms[0].rowLength1.value=document.forms[0].strRowCount.value;
		//alert()
	}

	function controlToIssueToPatientPage()
	{	    
		//cancelIssue();
		//alert(document.getElementsByName("strId")[0].value);
			document.forms[0].hmode.value="INITVAL";
			document.forms[0].submit();
	}
	function getLfDetails()
	{
		document.getElementById('lfDiv').style.display='block';
	}
	
	function closeLfDetails()
	{
		document.getElementById('lfDiv').style.display='none';
	}
	
	function handleModalClick(event){
	  var modal = document.getElementById("myModal");
	  console.log("modal close on click outside");
	  if (event.target == modal) {
	    modal.style.display = "none";
	  }
	}
	function handleAdministratedBtn(index){
		var modal = document.getElementById("myModal");
		var btn = document.getElementById("administratedBtn");
		
		var itemParamValue = document.getElementById("itemParamValue"+index).value;
		console.log(itemParamValue)
		var url = "InjAdministrationTransCNT.cnt?hmode=getInjAdministratedDtl_Ajax"
						+"&strId="+document.getElementById('strId').value
						+"&storeName="+document.getElementById('storeName').value
						+"&strSearchStr="+ document.getElementById('strSearchStr').value
						+"&checkFlg="+ document.getElementById('checkFlg').value
            			+"&itemParamValue="+ itemParamValue;            	  
            			
        ajaxFunction(url,"22");
        
		modal.style.display = "block";
	}
	function closeModal(){
		var modal = document.getElementById("myModal");
		var btn = document.getElementById("administratedBtn");
	
		modal.style.display = "none";
	}
	</script>
	
	<style>
        .example {
            page-break-after: always;
        }
        .activePrev{
        font-size:3rem;
        color:bisque;
        }
        
        .modal-body1 {
    					overflow:auto;
					}
		.autocomplete-suggestions{
		
		background-color: cornsilk;
		}
		.table .thead-dark {
		  /* 	color: #000 !important;
		  	border: none !important; */
		  	background:linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;
		  	text-align :center !important;	
		}
		.thead-dark th{
			background:none !important; 
			border: none !important;
			text-align :center !important;	
			padding: 0.25rem !important;
		}
		.modal {
		  display: none;
		  position: fixed; 
		  z-index: 1; 
		  left: 0;
		  top: 0;
		  width: 100%; 
		  height: 100%; 
		  overflow: auto; 
		  background-color: rgb(0,0,0); 
		  background-color: rgba(0,0,0,0.4); 
		}
		
		.modal-content {
		  background-color: #fefefe;
		  margin: auto;
		  padding: 12px 30px;
		  border: 1px solid #888;
		  width: 90%;
		  margin-top:42px;
		}
		
		.closeModal::after {
		  content:'x';
		  position: absolute;
		  right: -8px;
		  top: -9px;
		  height: 18px;
		  width: 18px;
		  background-color: red;
		  border-radius: 9px;
		  display: flex;
		  justify-content: center;
		  color: white;
		  onclick:"closeModal()"
		}
		
		.closeModal {
		  
		}
		
		.closeModal:hover,
		.closeModal:focus {
		  color: #000;
		  text-decoration: none;
		  cursor: pointer;
		}
    </style>
    
</head>
<!-- <body onload="checkMsg();chkVisitDtl();"> -->
<body onload="checkMsg();">

<html:form name="injAdminTransBean" action="/transactions/InjAdministrationTransCNT" type="mms.transactions.controller.fb.InjAdministrationTransFB">

	<fieldset>
		
		<legend class='legendHeader' id='nonPrintableLegend' style='color:black;'>Inj. Administration(Details)</legend>
		
		<div class="legend2" id='nonPrintableLegend2'>
		
			<button  type="button" class="btn btn-outline-primary mt-1 btn-circle printbtn" onClick="Backbtn();">
				<div class="popupToast"><i class="fas fa-arrow-left iround" title="Back"></i><span class="popuptextToast">Back</span></div>
			</button>
			<!--
			<button  type="button" id="savebutton" class="btn btn-outline-success mt-1 btn-circle savebtn"  tabindex='2' onClick="getNAList();"   data-toggle="" data-target="#previewModal" style="font-weight: bold;">					
			   <div class="popupToast"><i class="fa"  title="NA"></i>N.A. <span class="popuptextToast">N.A.</span></div>
		    </button>	 
		 	 
		    <button  type="button" id="savebutton" class="btn btn-outline-success mt-1 btn-circle savebtn"  tabindex='2' onClick="return saveDirectIssue();"   data-toggle="" data-target="#previewModal" >					
				<div class="popupToast"><i class="fa fa-save iround"  title="Save"></i> <span class="popuptextToast">Save</span></div>
			</button>	
			-->		
	  	</div>  
  
  		<div class="container-fluid">		
			<div class="viewport" id="nonPrintable">
				<div class="alert alert-danger  alert-dismissible fade show"  id="errID" style="display: none;"><bean:write name="injAdminTransBean" property="strErrMsg" /></div>
				<div class="alert alert-warning  alert-dismissible fade show" id="wrnID" style="display: none;"><bean:write name="injAdminTransBean" property="strWarningMsg" /></div>
				<div class="alert alert-success  alert-dismissible fade show" id="normalMsg" style="display: none;"><bean:write name="injAdminTransBean" property="strNormalMsg" /></div>			
			</div>
			
			<pDtl:patDtlNew crNo="${injAdminTransBean.crNo}" address="false"></pDtl:patDtlNew>
			
			<div id="strAdmDtl">
				<bean:write name="injAdminTransBean" property="strAdmDtl" filter="false" />
			</div>
			
			<div class="prescriptionTile">
			
				<div class="row rowFlex reFlex">
					<div class="col-sm-6" style="display: none;">
						<label>Store</label>
					</div>
					<div class="col-sm-6"  style="display: none;">						
						<select name="strStoreId" onchange="   " class="browser-default custom-select">
							<bean:write name="injAdminTransBean" property="strStoreValues" filter="false" />
						</select>
					</div>
				</div>	
				<div class="row my-1">
					<div class="col-md-2" style="font-weight: 400; font-size: 0.9rem; color:black;text-align:right;">Store Name : </div>
					<div class="col-md-2" style="font-weight: 400; font-size: 0.9rem; color:black;text-align:left;">
						<label style=""><b><bean:write	name="injAdminTransBean" property="strStoreName" filter="false" /></b> </label>
					</div>			
					<div class="col-md-2" style="font-weight: 400; font-size: 0.9rem; color:black;text-align:right;">
						Search Type : 
					</div>		
					<div class="col-md-2" style="font-weight: 400; font-size: 0.9rem; color:black;text-align:left;">
						<lable><b id="headerName" ></b></lable>
					</div>
					<div class="col-md-4" align="right"><a onclick="refreshPage()"><img height="28px" width="28px" alt="" src="../../hisglobal/images/reload.png" style="cursor: pointer;" title="Refresh"></a></div>
				</div>		
							
				<div id="patDtlHlp" align="center">
				<bean:write name="injAdminTransBean" property="strIpdIssueDrugHLP" filter="false" />
				</div>
				
				<hr>
				<div id="myModal" class="modal">

				  <div class="modal-content">
				  	
				  	<span class="closeModal" onclick="closeModal()"></span>
				    
				    <div id="administratedDtlDiv">
				    </div>
				    
				  </div>
				</div>
				<div style="display:flex;justify-content:space-around; width:fit-content; margin-left:auto; padding: 12px 8px; gap:16px;">
					<div style="display: flex;justify-content: center;align-items: center; gap: 12px;">
						<div><img height='24px' width='24px' src='../../hisglobal/images/letter-a.png'  title='Administered'/> </div>
						<div><p style="margin:auto;font-weight: 400; font-size: 0.8rem; color: black;">Administered [ Injection administered to patient. ]</p></div>
					</div>
					<div style="display: flex;justify-content: center;align-items: center; gap: 12px;">
						<div><img height='24px' width='24px' src='../../hisglobal/images/letter-p.png'  title='Pending'/> </div>
						<div><p style="margin:auto;font-weight: 400; font-size: 0.8rem; color: black;">Pending [ Injection administration is pending. ]</p></div>
					</div>
					<div style="display: flex;justify-content: center;align-items: center; gap: 12px;">
						<div style="color: #d15959; display: flex; padding: 4px;justify-content: center; border-radius: 4px; font-size: 14px; font-weight: bold;">N/A</div>
						<div><p style="margin:auto;font-weight: 400; font-size: 0.8rem; color: black;">Not Available [ Injection is not available in store. ]</p></div>
					</div>
				</div>
			</div>
			
		</div>	
		
		
		
		<logic:equal value="0" name="injAdminTransBean" property="strMode">
			
			<table class="TABLEWIDTH" align="center" border="0" cellspacing="1px">
				<tr class="HEADER">
					<td colspan="4">Drug Dispensing&gt;&gt;</td>
				</tr>
			</table>
		</logic:equal>
	
		 
    	 <div id="allDivId" style="display: block;"></div> 

		<div style="display: none;">
			<div id="patientDetailsDivId" style="display: none;">
				<table class="TABLEWIDTH" align="center" cellspacing="1px">
					<tr>
						<bean:write name="injAdminTransBean" property="strPatientDetails" filter="false" />
					</tr>
				</table>
				
				<div id="patientDiagDetailsDivId" style="display: block;">
					<table class="TABLEWIDTH" align="center" cellspacing="1px">
						<tr>
							<bean:write name="injAdminTransBean" property="strPatientDiagDetails" filter="false" />
						</tr>
					</table>
				</div>
			</div>
		</div>
		
	<input type="hidden" name="hmode" />	
	<input type="hidden" name="strUpdateFlag" 			        value="" />	
	<input type="hidden" name="storeName" id="storeName"        value="${injAdminTransBean.storeName}" />
	<input type="hidden" name="itemCatName"				        value="${injAdminTransBean.itemCatName}" />
	<input type="hidden" name="strCrNo" 				        value="${injAdminTransBean.strCrNo}" />		
	<input type="hidden" name="crNo" 					        value="${injAdminTransBean.crNo}" />
	<input type="hidden" name="strId" 	 id="strId"		        value="${injAdminTransBean.strId}" />
	<input type="hidden" name="strIssueNo" 				        value="${injAdminTransBean.strIssueNo}" />
	<input type="hidden" name="strIssueDtl"				        value="${injAdminTransBean.strIssueDtl}" />
	<input type="hidden" name="mode" 					        value="${injAdminTransBean.strMode}" />
	<input type="hidden" name="strMode" 				        value="${injAdminTransBean.strMode}">	
	<input type="hidden" name="strIssueNum" 			        value="${injAdminTransBean.strIssueNum}" />	
	<input type="hidden" name="checkFlg" id="checkFlg"			value="${injAdminTransBean.checkFlg}"  />
	<input type="hidden" name="strSearchStr" id="strSearchStr"  value="${injAdminTransBean.strSearchStr}"  />
	
	
	
		<div id="blanket" style="display: none;"></div>
		<div class="popUpDiv" id="popUpDiv" style="display: none;">
			<table bgcolor="white">
				<tr>
					<td>
						<div id="searchItemsDtlsDivId" style="display: block;"></div>
						<div id="stockDtlsDivId" style="display: block;"></div>
						<div id="NAItemDtlsDivId"      style="display: block;"></div>
					</td>
				</tr>
			</table>
		</div>
	   
	   	<!-- ==APPLIED THIS ONE== -->
		 <div class="modal fade bd-example-modal-lg" id="issueDtlModal">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">Previous Issue
						<button type="button" class="btn btn-primary" onclick="printDiv()">Print</button>
					</div>
					<div class="modal-body">
						<div id="issueDtlDivId"></div>
						<hr>
						<div class="modal-body1" id="issueDtlsDivId" style="display: block;height:10rem;"></div>
					</div>
				</div>
			</div>
		</div>  		
				
	</fieldset>
</html:form>
<script>
console.log("working properly");
if(document.getElementById('checkFlg').value==1){
	document.getElementById('headerName').innerHTML="PIN Wise";
}
else if(document.getElementById('checkFlg').value==2){
	document.getElementById('headerName').innerHTML="Date Wise";
	console.log("Date Wise Search");
}
</script>
</body>
</html>