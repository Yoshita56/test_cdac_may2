<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<html>
<head>
<meta charset=UTF-8">
<title>Third Party Issued Items</title>

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
<script language="JavaScript" src="../js/thirdPartyIssueSancTrans.js"></script>
<script language="JavaScript" src="../js/searchItems_util.js"></script>
<script language="JavaScript" src="../js/issueDetails_util.js"></script>
<script type="text/javascript">
</script>

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
		padding: 0.25rem;
	}
}
</style>
</head>
<!-- onLoad="openIssueReport();" -->
<body onLoad="openIssueReport();">

<html:form name="thirdPartyIssueSancBean" action="/transactions/ThirdPartyIssueSancTransBSCNT" type="mms.transactions.controller.fb.ThirdPartyIssueSancTransFB">

	<div id="errMsg" class="errMsg" style="font-size:18px"><bean:write name="thirdPartyIssueSancBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg" style="font-size:18px"><bean:write name="thirdPartyIssueSancBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg" style="font-size:18px"><bean:write name="thirdPartyIssueSancBean" property="strNormalMsg" /></div>
<%-- 	<tag:tab tabLabel="Third Party Issue" selectedTab="FIRST" align="center" width="TABLEWIDTH"> </tag:tab>
 --%>
 
 
<div class="container-fluid">
  <div class="prescriptionTile">	
  <fieldset>
	<legend class='legendHeader' id='nonPrintableLegend'>Third Party Issue</legend>
		<div class="row" >
			
			<div class="legend2" id="saveId">
				<!-- <button id="cancelButton" type="button" class="btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="cancel1();">
				<div class="popupToast"><i class="fa fa-ban iround"  title="Cancel"></i><span class="popuptextToast">Cancel</span></div>
				</button> -->	
				<button type="button" id="cancelButton" class="float-right btn btn-danger cancelbtn mt-1" style="border-radius:50%; padding:10px 12px;" onclick="cancel1();">
					<i class="fas fa-times" title="Cancel"></i>
				</button>
				
		<!-- 		<button type="button" class=" btn btn-secondary btn-circle" onclick="clearDtl('requestPage');" style="background: #b9b9b9; border-color:#b9b9b9;margin-top: 0.25rem !important;">
				<img  src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 23px; color: #fff;">
				</button>	 -->
				<button type="button" class="float-right btn btn-secondary mt-1" onclick="clearDtl('requestPage');" style="border-radius:50%; background: royalblue;padding:10px 9px;">
					<i class="fas fa-broom" title="Clear"></i>
					<!-- <img src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 22px; color: #fff;"> -->
				</button>	
				
			   <!--  <button  type="button" id="savebutton" class="btn btn-outline-success mt-1 btn-circle savebtn"  tabindex='2' id="submitId" onclick=' return validate1();'   data-toggle="" data-target="#previewModal" >					
					<div class="popupToast"><i class="fa fa-save iround"  title="Save"></i> <span class="popuptextToast">Save</span></div>
				</button>		
				 -->
				<button type="button" id="savebutton" class="float-right btn btn-success mt-1" tabindex="2" onclick="return validate1();" id="submitId" style="border-radius:50%; padding:10px 11px; background-color: #5cb85c;" >
					<i class="fas fa-download iround" title="save"></i>
				</button> 	
 			</div>
 			
 		</div>
		<div class="container">
			<div class='row'>
				<div class='col-sm-2'>
					<label>Store Name</label>
				</div>
				<div class='col-sm-4' style='font-weight: 400;' align="left">
					<bean:write name="thirdPartyIssueSancBean" property="strStoreName" filter="false" />
				</div>
				<div class='col-sm-2'>
					<label>Req Date &amp; Time</label>
				</div>
				<div class='col-sm-4' style='font-weight: 400;' align="left">
					<bean:write name="thirdPartyIssueSancBean" property="strCurrentDate" filter="false" />
				</div>
			</div>
			
			<div class='row'>
				<div class='col-sm-2'>
					<label>Third Party Name</label>
				</div>
				<div class='col-sm-4' style='font-weight: 400;' align="left">
					<bean:write name="thirdPartyIssueSancBean" property="strInstituteValues" filter="false"/>
				</div>
				<div class='col-sm-2'>
					<label>Item Category</label>
				</div>
				<div class='col-sm-4' style='font-weight: 400;' align="left">
					<bean:write name="thirdPartyIssueSancBean" property="strItemCatValues" filter="false"/>
				</div>
			</div>
			
			<div class='row'>
				<div class='col-sm-2' >
					<label>Group Name</label>
				</div>
				<div class='col-sm-4' style='font-weight: 400;' align="left">
					<bean:write name="thirdPartyIssueSancBean" property="strGroupName" filter="false"/>
				</div>
				<div class='col-sm-6' ></div>
			</div>
		
			<%-- <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
			    <tr class="HEADER">
					<td colspan="4"></td>
				</tr>
				<tr>
					<td width="25%" colspan="1" class="LABEL">
						Store Name
					</td>
					<td width="25%" colspan="1" class="CONTROL">
						<bean:write name="thirdPartyIssueSancBean" property="strStoreName" filter="false" />
					</td>
					<td width="25%" colspan="1" class="LABEL">Issue Date &amp; Time</td>
					<td width="25%" colspan="1" class="CONTROL">
					   <font color="blue"><bean:write name="thirdPartyIssueSancBean" property="strCurrentDate" filter="false" /></font>
					</td>
				</tr>
				<tr>
					<td width="50%" colspan="2" class="LABEL"><font size="1" color="red">*</font>
					Third Party Name
					</td>
					<td width="50%" colspan="2" class="CONTROL">
					  <bean:write name="thirdPartyIssueSancBean" property="strInstituteValues" filter="false"/>
					</td>
					
				</tr>
				
				<tr>
					<td width="50%" colspan="2" class="LABEL"><font size="1" color="red">*</font>
					Item Category
					</td>
					<td width="50%" colspan="2" class="CONTROL">
					  <bean:write name="thirdPartyIssueSancBean" property="strItemCatValues" filter="false"/>
					</td>
					
				</tr>
				</table> --%>
				<div class='row'>
					<div class='col-sm-4'>
						<label class='subHeaders mb-0 mt-3' style="font-weight: 600;font-size:18px;">
							Item/Drug Details
						</label>
					</div>
				</div>
			
			<%-- <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
				
				<tr class="TITLE">
					<td colspan="4"><div id='' style='color:blue;'>Item/Drug Details</div>
					</td>
					</tr>
					
					<tr>
					<td width="50%" class="LABEL" ><font size="1" color="red">*</font>
					Group Name
					</td>
					<td width="50%" class="CONTROL" >
					  <bean:write name="thirdPartyIssueSancBean" property="strGroupName" filter="false"/>
					</td>
					
				</tr>
				</table> --%>
			<table class="table">
			  <thead class="thead-dark" align="center">
			  	<tr>
					<th  width="25%" style="font-weight:350 !important ;font-size: 16px !important;">Item/Drug Name 
					</th>
					<th  width="15%" style="font-weight:350 !important ;font-size: 16px !important;">Batch/Sl No.
					</th>
					<th  width="15%"  style="font-weight:350 !important ;font-size: 16px !important;">Expiry Date
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
				<bean:write name="thirdPartyIssueSancBean" property="strItemDtls" filter="false"/>
			</div>
			<br>
			
			<div class='row'>
				<div class='col-sm-2' >
					<label>Received By</label>
				</div>
				<div class='col-sm-4'>
					<input type="text" name="strReceiveBy" class="form-control">
				</div>
				<div class='col-sm-2'>
					<label>Remarks</label>
				</div>
				<div class='col-sm-4'>
					<textarea class='form-control' name="strRemarks" rows="2" style="height:38px;"></textarea>
				</div>
			</div>
		</div>
			<!-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
			 <tr>
					<td colspan="2" width="50%" class="LABEL">Received By</td>
					<td colspan="2" width="50%" class="CONTROL">
			  		<input type="text" name="strReceiveBy" class="txtFldMax">
    	 			</td>
			  </tr>
		      <tr>
					<td colspan="2" width="50%" class="LABEL">Remarks</td>
					<td colspan="2" width="50%" class="CONTROL">
			  		<textarea name="strRemarks" rows="2"></textarea>
    	 			</td>
			  </tr>
		      <tr class="FOOTER">
			        <td colspan="4"><font size="2" color="red">*</font>Mandatory Fields</td>
		      </tr>
	        </table> -->
	<!-- 	<table border="0" class="TABLEWIDTH" align="center">
			<tr>
	
				<td align="center">
				<img style="cursor: pointer; "
					src="../../hisglobal/images/btn-sv.png" onClick="return validate1();" title='Click Here To Save Data'/>
					<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" onClick="clearDtl('requestPage');" >
				<img  style="cursor: pointer; " src="../../hisglobal/images/back_tab.png" onClick="cancel1();" title='Click Here Go Back To Main Desk'>
			</td>
			</tr>
		</table>-->
		<!-- 	<br>
		    <div align="center" id=" ">					 
							 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
								<a href="#" class="button"	onclick="clearDtl('requestPage');"><span class="clear">Clear</span></a> 
								<a href="#" class="button" onclick="cancel1();"><span class="cancel">Cancel</span></a>
							</div>  -->
							
							
		<input type="hidden" name="hmode"/>
		<input type="hidden" name="mode" value="${thirdPartyIssueSancBean.mode}"/>
		<input type="hidden" name="strChk" value="${thirdPartyIssueSancBean.strChk}"/>
		<input type="hidden" name="strCurrentDate" value="${thirdPartyIssueSancBean.strCurrentDate}"/>
		<input type="hidden" name="strStoreId" value="${thirdPartyIssueSancBean.strStoreId}" />
		<input type="hidden" name="strReqNo" value="${thirdPartyIssueSancBean.strReqNo}" />
		<input type="hidden" name="strItemCatNo" value="${thirdPartyIssueSancBean.strItemCatNo}" />
		<input type="hidden" name="strStoreTypeId" value="${thirdPartyIssueSancBean.strStoreTypeId}" />
		<input type="hidden" name="comboValue" value="${thirdPartyIssueSancBean.strStoreName}">
		
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
 --%>

</body>
</html>