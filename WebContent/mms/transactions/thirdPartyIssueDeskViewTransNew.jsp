<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
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
<title>Third Party Issue Items</title>

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

<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">		
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/newpopup.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/thirdPartyIssueDesk.js"></script>
<script language="JavaScript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../js/issueDetails_util.js"></script>
<script type="text/javascript">
</script>


<style type="text/css">
  .Approved {
		font-family: Verdana, Arial, Helvetica, sans-serif;
		font-size: 12px;
		font-style: normal;
		font-weight: normal;
		color: #151AFB;
		background-color: #D3D5C9;
		height: 16px;
		text-align:center;
    }
    
   .NotApproved {
		font-family: Verdana, Arial, Helvetica, sans-serif;
		font-size: 12px;
		font-style: normal;
		font-weight: normal;
		color: #000000;
		background-color: #F1ECE2;
		height: 16px;
		text-align:center;
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
		padding: 0.25rem;
		text-align:center;
	}
</style>


</head>
<body >
<html:form name="thirdPartyIssueDeskBean" action="/transactions/ThirdPartyIssueDeskBSCNT" type="mms.transactions.controller.fb.ThirdPartyIssueDeskFB">

	<div id="errMsg" class="errMsg" style="font-size:18px"><bean:write name="thirdPartyIssueDeskBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg" style="font-size:18px"><bean:write name="thirdPartyIssueDeskBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg" style="font-size:18px"><bean:write name="thirdPartyIssueDeskBean" property="strNormalMsg" /></div>
<%-- 	<tag:tab tabLabel="Third Party Issue Detail View" selectedTab="FIRST" align="center" width="TABLEWIDTH"> </tag:tab>
 --%>
 
<div class="container-fluid">
  <div class="prescriptionTile">
  <fieldset>
	<legend class='legendHeader' id='nonPrintableLegend'>Third Party Issue</legend>
	
	<div class="legend2" id="saveId">
		
		<button type="button" id="cancelButton" class="float-right btn btn-danger cancelbtn mt-1" style="border-radius:50%; padding:10px 12px;" onclick="cancelView();">
			<i class="fas fa-times" title="Cancel"></i>
		</button>
				
		
		<button  id="printbutton" type="button" class="float-right btn btn-primary printbtn mt-1" style="background-color:royalblue;border-radius:50%; padding:10px 12px;"  id="submitId" onclick='openIssueReport();' >
			<i class="fa fa-print iround"  title="Print Last Voucher"></i>
		</button>
  	</div>

<div class="container">
	<div class='row'>
		<div class='col-sm-2'>
			<label>Store Name</label>
		</div>
		<div class='col-sm-4' style='font-weight: 400; '>
			<bean:write name="thirdPartyIssueDeskBean" property="strStoreName" filter="false" />
		</div>
		<div class='col-sm-2'>
			<label>Third Party Name</label>
		</div>
		<div class='col-sm-4' style='font-weight: 400; '>
			<bean:write name="thirdPartyIssueDeskBean" property="strInstituteValues" filter="false"/>
		</div>
	</div>
	
	<div class='row'>
		<div class='col-sm-2'>
			<label>Item Category</label>
		</div>
		<div class='col-sm-4' style='font-weight: 400; '>
			 <bean:write name="thirdPartyIssueDeskBean" property="strItemCatValues" filter="false"/>
		</div>
		<div class='col-sm-2'>
		<label>Group Name</label>
		</div>
		<div class='col-sm-4' style='font-weight: 400; '>
			 <bean:write name="thirdPartyIssueDeskBean" property="strGroupName" filter="false"/>
		</div>
	</div>
</div>
		<%-- <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
		<tr>
			<td width="25%" colspan="1" class="LABEL">
				Store Name
			</td>
			<td width="25%" colspan="1" class="CONTROL">
				<bean:write name="thirdPartyIssueDeskBean" property="strStoreName" filter="false" />
			</td>
		
			<td width="25%" colspan="1" class="LABEL">
			    Third Party Name
			</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <bean:write name="thirdPartyIssueDeskBean" property="strInstituteValues" filter="false"/>
			</td>
		</tr>
		<tr>
			<td width="25%" colspan="1" class="LABEL">
			    Item Category
			</td>
			<td width="25%" colspan="1" class="CONTROL">
			  <bean:write name="thirdPartyIssueDeskBean" property="strItemCatValues" filter="false"/>
			</td>
			<td width="25%" colspan="1"  class="LABEL" >
			    Group Name
			</td>
			<td width="25%" colspan="1"  class="CONTROL" >
			  <bean:write name="thirdPartyIssueDeskBean" property="strGroupName" filter="false"/>
			</td>
		</tr>
		</table> --%>
		<div class='row'>
			<div class='col-sm-4'>
			<label class='subHeaders mb-0 mt-3' style="font-weight: 600;font-size: 18px;">
			Item/Drug Details
			</label>
			</div>
		</div>

		<table class="table">
		  <thead class="thead-dark" align="center">
		  	<tr>
				<th  width="25%" style="font-weight:350 !important ;font-size: 16px !important;">Item/Drug Name 
				</th>
				<th  width="15%" style="font-weight:350 !important ;font-size: 16px !important;">Batch/Sl No.
				</th>
				<th  width="15%" style="font-weight:350 !important ;font-size: 16px !important;">Expiry Date
				</th>
				<th  width="15%" style="font-weight:350 !important ;font-size: 16px !important;">Available Qty
				</th>
				<th  width="10%" style="font-weight:350 !important ;font-size: 16px !important;">Req.Qty
				</th>
				<th  width="10%" style="font-weight:350 !important ;font-size: 16px !important;">Sanct.Qty
				</th>
				<th  width="10%" style="font-weight:350 !important ;font-size: 16px !important;">Issue Qty
				</th>
		 	</tr>
		  </thead>
		</table>
	
		<div id="id1">
			<bean:write name="thirdPartyIssueDeskBean" property="strItemDtls" filter="false"/>
		</div>
		<br>
		 <logic:equal value="1" name="thirdPartyIssueDeskBean" property="strThirdPartyFlag">
		
		<div class='row'>
			<div class='col-sm-4'>
				<label class='subHeaders mb-0 mt-3' style="font-weight: 600;font-size: 18px;">
				Approval Details
				</label>
			</div>
		</div>		
				<!-- <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
					<tr class="TITLE">
						<td colspan="4">Approval Details</td>
					</tr>
				</table> -->
				
		<div id="id2">
			<bean:write name="thirdPartyIssueDeskBean" property="strApprovalDtls" filter="false"/>
		</div>
		 </logic:equal>	
	
		<div class='row'>
			<div class='col-sm-2 text-center'>
				<label>Remarks</label>
			</div>
			<div class='col-sm-10'>
				<textarea name="strRemarks" class='form-control' rows="2" readonly><bean:write name="thirdPartyIssueDeskBean" property="strRemarks" filter="false"/></textarea>
			</div>
		</div>	
			<%-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr>
					<td colspan="2" width="50%" class="LABEL">Remarks</td>
					<td colspan="2" width="50%" class="CONTROL">
			  		<textarea name="strRemarks" rows="2" readonly><bean:write name="thirdPartyIssueDeskBean" property="strRemarks" filter="false"/></textarea>
    	 			</td>
			  </tr>
			
		<tr class="FOOTER">
			 <td colspan="4">  </td>
		</tr>
	</table> --%>
	<!-- 
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>
		<td align="center">
		     <img style="cursor: pointer" src="../../hisglobal/images/print_tab.gif" onClick="openIssueReport();" />
			<img  style="cursor: pointer; " src="../../hisglobal/images/back_tab.png" onClick="cancelView();" title='Click Here To Come Back On Desk' >
		</td>
		</tr>
	</table>-->
	<br>
	<!-- <div align="center" id=" ">					 
					 	<a href="#" class="button" id="submitId" onclick='openIssueReport();'><span class="print">Print</span></a>
						<a href="#" class="button" onclick="cancelView();"><span class="cancel">Cancel</span></a>
					</div> --> 
					
		<input type="hidden" name="hmode"/>
		<input type="hidden" name="mode"/>
		<input type="hidden" name="strCurrentDate" value="${thirdPartyIssueDeskBean.strCurrentDate}"/>
		<input type="hidden" name="strStoreId" value="${thirdPartyIssueDeskBean.strStoreId}" />
		<input type="hidden" name="strStoreTypeId" value="${thirdPartyIssueDeskBean.strStoreTypeId}" />
		<input type="hidden" name="comboValue" value="${thirdPartyIssueDeskBean.strStoreName}">
		<input type="hidden" name="strIssueNo" value="${thirdPartyIssueDeskBean.strReqNo}"/>
		
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
		
<cmbPers:cmbPers />
</fieldset>
</div>
</div>
</html:form>
<%-- <tag:autoIndex></tag:autoIndex>
 --%></body>
</html>