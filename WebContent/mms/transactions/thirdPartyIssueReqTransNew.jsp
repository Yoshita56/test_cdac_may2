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
<title>Third Party Issue</title>

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
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="JavaScript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../js/thirdPartyIssueReqTrans.js"></script>
<script language="JavaScript" src="../js/searchItems_utilBS.js"></script>
<script language="JavaScript" src="../js/issueDetails_util.js"></script>
<script language="JavaScript" src="../js/mms.js"></script>
<script type="text/javascript">

</script>

<style type="text/css">
	.newhr{
	    border-top: 3px solid rgb(6, 138, 255);
	    margin-right: -16px;
		margin-left: -16px;
	}
	.custom-select[multiple], .custom-select[size]:not([size="1"]) {
	    height: 220px;
	}
	.comboMin{
		display: inline-block;
		width: 100%;
		height: calc(1.5em + 0.75rem + 2px);
		padding: 0.375rem 1.75rem 0.375rem 0.75rem;
		font-size: 0.8rem;
		font-weight: 400;
		line-height: 1.5;
		color: #495057;
		vertical-align: middle;
		background: url("data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 4 5'%3e%3cpath fill='%23343a40' d='M2 0L0 2h4zm0 5L0 3h4z'/%3e%3c/svg%3e") no-repeat right 0.75rem center/8px 10px;
		background-color: rgba(0, 0, 0, 0);
		background-color: #fff;
		border: 1px solid #ced4da;
		border-radius: 0.25rem;
		-webkit-appearance: none;
		-moz-appearance: none;
		appearance: none;
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
	    text-align: center;	
	}
	
</style>

</head>
<body onLoad="openIssueReport();">
<html:form name="thirdPartyIssueReqBean" action="/transactions/ThirdPartyIssueReqTransBSCNT" type="mms.transactions.controller.fb.ThirdPartyIssueReqTransFB">
	
	<div id="errMsg" class="errMsg" style="font-size:18px"><bean:write name="thirdPartyIssueReqBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg" style="font-size:18px"><bean:write name="thirdPartyIssueReqBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg" style="font-size:18px"><bean:write name="thirdPartyIssueReqBean" property="strNormalMsg" /></div>
<%-- <tag:tab tabLabel="Third Party Issue" selectedTab="FIRST" align="center" width="TABLEWIDTH"> </tag:tab>
 --%>

<div class="container-fluid">
  <div class="prescriptionTile">
	<fieldset>
	<legend class='legendHeader' id='nonPrintableLegend'>Third Party Issue Request</legend>
	
		<div class="row" >
   			<div class="legend2" id="saveId">
				<button type="button" id="cancelButton" class="float-right btn btn-danger cancelbtn mt-1" style="border-radius:50%; padding:10px 12px;" onclick="cancel1();">
					<i class="fas fa-times" title="Cancel"></i>
				</button>
					
				<button type="button" class="float-right btn btn-secondary mt-1" onclick="clearDtl('requestPage');" style="border-radius:50%; background: royalblue;padding:10px 9px;">
					<i class="fas fa-broom" title="Clear"></i>
				</button>	
				
				<button type="button" id="savebutton" class="float-right btn btn-success mt-1" tabindex="2" onclick="return validate1();" id="submitId" style="border-radius:50%; padding:10px 12px; background-color: #5cb85c;" >
					<i class="fas fa-download iround" title="save"></i>
				</button> 										                 
 			</div>
   	    </div>
 
<div class="container">
   <logic:equal value="1" name="thirdPartyIssueReqBean" property="strThirdPartyFlag">		
	<div class='row'>
		<div class='col-sm-2'>
		<label>Store Name</label>
		</div>
		<div class='col-sm-4' style='font-weight: 400;' align="left">
		<bean:write name="thirdPartyIssueReqBean" property="strStoreName" filter="false" />
		</div>
		<div class='col-sm-2'>
		<label>Req Date &amp; Time</label>
		</div>
		<div class='col-sm-4' style='font-weight: 400; ' align="left">
		<bean:write name="thirdPartyIssueReqBean" property="strCurrentDate" filter="false" />
		</div>
	</div>
			<%-- <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
			<!-- <tr class="HEADER">
					<td colspan="4"></td>
				</tr> -->
				<tr>
					<td width="25%" colspan="1" class="LABEL">
						Store Name
					</td>
					<td width="25%" colspan="1" class="CONTROL">
						<bean:write name="thirdPartyIssueReqBean" property="strStoreName" filter="false" />
					</td>
				
					<td width="25%" colspan="1" class="LABEL">Req Date &amp; Time</td>
					<td width="25%" colspan="1" class="CONTROL">
					  <font color="blue"><bean:write name="thirdPartyIssueReqBean" property="strCurrentDate" filter="false" /></font>
					</td>
				</tr>
		    </table> --%>
    </logic:equal>
    
   <logic:equal value="2" name="thirdPartyIssueReqBean" property="strThirdPartyFlag">	
		<div class='row'>
		<div class='col-sm-2'>
			<label>Store Name</label>
		</div>
		<div class='col-sm-4' style='font-weight: 400; ' align="left">
			<bean:write name="thirdPartyIssueReqBean" property="strStoreName" filter="false" />
		</div>
		<div class='col-sm-2'>
			<label>Req Date &amp; Time</label>
		</div>
		<div class='col-sm-4' style='font-weight: 400; ' align="left">
			<dateTag:date name="strThirdPartyIssueDate" value="${thirdPartyIssueReqBean.strCurrentDate}"></dateTag:date>
		</div>
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
					<bean:write name="thirdPartyIssueReqBean" property="strStoreName" filter="false" />
				</td>
						
				 <td class="LABEL" width="25%"><font color="red">*</font>Req Date</td>
				 <td class="CONTROL" width="25%"> <dateTag:date name="strThirdPartyIssueDate" value="${thirdPartyIssueReqBean.strCurrentDate}"></dateTag:date> </td>
			</tr>
	    </table>	 --%>			
	  </logic:equal>
    
		<div class='row'>
			<div class='col-sm-2'>
				<label>Third Party Name</label>
			</div>
			<div class='col-sm-4'>
				<select name="strInstituteCode" class='form-control'>
					<bean:write name="thirdPartyIssueReqBean" property="strInstituteValues" filter="false"/>
				</select>
			</div>
			<div class='col-sm-2'>
				<label>Item Category</label>
			</div>
			<div class='col-sm-4' style='font-weight: 400; ' align="left">
				<bean:write name="thirdPartyIssueReqBean" property="strItemCatValues" filter="false"/>
			</div>
		</div>
</div>
	<%--   <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">    
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font size="1" color="red">*</font>
			Third Party Name
			</td>
			<!--
			<td width="50%" colspan="2" class="CONTROL">
			<select name="strInstituteCode"  onchange="checkValCombo();">
			<bean:write name="thirdPartyIssueReqBean" property="strInstituteValues" filter="false"/>
			</select>
			 -->
			 <td width="50%" colspan="2" class="CONTROL">
					<select name="strInstituteCode">
					      <bean:write name="thirdPartyIssueReqBean" property="strInstituteValues" filter="false"/>
					</select>
			</td>
		</tr>
		
	<!-- 
		<tr>
             <td width ="25%%" class ="LABEL" valign="middle" ><font  color="red">*</font>Third Party Name</td>
             <td width ="25%" class ="CONTROL">
    
	            <select name="strInstituteCode"  onchange="checkValCombo();">
				     <bean:write name="thirdPartyIssueReqBean" property="strInstituteValues" filter="false"/>
				</select>
            </td>
            <td class="CONTROL" width="25%" id='labelId'>
            	<div id='labelNameId'></div>
		    </td>
		    <td class="CONTROL" width="25%">
		            	<div id="nameOtherFld" style="display: none">
		            		<input type='text' name='strThirdPartyName' value='' onkeypress='return validateData(event,16);' maxlength='50'>
		            	</div>
		    </td>
          </tr>
           -->	
		
		<tr>
			<td width="50%" colspan="2" class="LABEL"><font size="1" color="red">*</font>
			Item Category
			</td>
			<td width="50%" colspan="2" class="CONTROL">
			<bean:write name="thirdPartyIssueReqBean" property="strItemCatValues" filter="false"/>
			</td>
		</tr>
		</table> --%>
		<hr>
		<div class='row'>
			<div class='col-sm-12' align="right">
				<button type="button" class="btn btn-success btn-sm" id="strSearchItemButtonDivId" data-toggle="modal" data-target="#tariffDtlsModal" onclick="getItemSelectPopup();"><i class="fas fa-search"></i>&nbsp;Item Finder</button>
	<!-- 		<img style="cursor: pointer;height: 20px" id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png"	onclick='getItemSelectPopup();'>
	 -->	</div>
		</div>
		<hr>
		

	<!-- <table class="TABLEWIDTH" align="center" cellpadding="1" cellspacing="1">   
		<tr class="TITLE">
			<td colspan="4"><div align="right"><img style="cursor: pointer;height: 20px" id='strSearchItemButtonDivId' src="../../hisglobal/images/ItemFinder.png" onclick='getItemSelectPopup();'>
			</div>
			</td>
			</tr>
		</table> -->
		
	  <logic:equal value="2" name="thirdPartyIssueReqBean" property="strThirdPartyFlag">		
		<table class="table">
		  <thead class="thead-dark" align="center">
		  	<tr>
				<th  scope="col" width='30%' style="font-weight:350 !important ;font-size: 16px !important;">Item/Drug Name 
				</th>
				<th  scope="col" width='15%' style="font-weight:350 !important ;font-size: 16px !important;">Batch/Serial No.
				</th>
				<th  scope="col" width='10%' style="font-weight:350 !important ;font-size: 16px !important;">Expiry Dt
				</th>
				<th  scope="col" width='15%' style="font-weight:350 !important ;font-size: 16px !important;">Available Qty
				</th>
				<th  scope="col" width='15%' style="font-weight:350 !important ;font-size: 16px !important;"><font size="1" color="red">*</font>Issue Qty
				</th>
				<th  scope="col" width='15%' style="font-weight:350 !important ;font-size: 16px !important;"><font size="1" color="red">*</font>Unit Name
				</th>
		 	</tr>
		  </thead>
		</table>
	  </logic:equal> 
		
	  <logic:equal value="1" name="thirdPartyIssueReqBean" property="strThirdPartyFlag">		
		<table class="table">
		  <thead class="thead-dark" align="center">
		  	<tr>
				<th  scope="col" width='30%' style="font-weight:350 !important ;font-size: 16px !important;">Item/Drug Name 
				</th>
				<th  scope="col" width='15%' style="font-weight:350 !important ;font-size: 16px !important;">Batch/Serial No.
				</th>
				<th  scope="col" width='10%' style="font-weight:350 !important ;font-size: 16px !important;">Expiry Dt
				</th>
				<th  scope="col" width='15%' style="font-weight:350 !important ;font-size: 16px !important;">Available Qty
				</th>
				<th  scope="col" width='15%' style="font-weight:350 !important ;font-size: 16px !important;"><font size="1" color="red">*</font>Req. Qty
				</th>
				<th  scope="col" width='15%' style="font-weight:350 !important ;font-size: 16px !important;"><font size="1" color="red">*</font>Unit Name
				</th>
			</thead>
		</table>
	 </logic:equal>  	 	
			
	<div id="id1"></div>
			
	<logic:equal name="thirdPartyIssueReqBean" property="strThirdPartyFlag" value="2" >	
	 <!--  <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		   <tr>
				<td colspan="2" width="50%" class="LABEL"><font size="2" color="red">*</font>Received By</td>
				<td colspan="2" width="50%" class="CONTROL">
		  		<input type="text" name="strReceiveBy" maxlength="100" class="txtFldMax">
   	 			</td>
		   </tr>
	  </table> -->
	  
	 <div class='row'>
		 <div class='col-sm-2'>
		  	<label>Received By</label>
		 </div>
	     <div class='col-sm-4'>
		    <input type="text" name="strReceiveBy" maxlength="100" class="form-control">
		 </div>
	 </div>	
	</logic:equal> 
		<br> <br>
	<div class='row'>
		<div class='col-sm-1'>
			<label>Remarks</label>
		</div>
		<div class='col-sm-11'>
			<textarea name="strRemarks" class='form-control' rows="2" style=""></textarea>
		</div>
	</div>
		<!--  <table border="0" class="TABLEWIDTH" align="center">
		  <tr class="FOOTER">
			 <td colspan="4"></td>
		  </tr>
		 		 <tr>
					<td colspan="2" width="50%" class="LABEL"><font size="2" color="red">*</font>Remarks</td>
					<td colspan="2" width="50%" class="CONTROL">
			  		<textarea name="strRemarks" rows="2"></textarea>
    	 			</td>
			  </tr>
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table> -->
	<!-- 
	<table border="0" class="TABLEWIDTH" align="center">
		<tr>
			<td align="center">
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" Title='Click here to save data' onClick="return validate1();" />
				<img style="cursor: pointer; " src="../../hisglobal/images/btn-clr.png" Title='Click here to clear content' onClick="clearDtl('requestPage');" >
			<img  style="cursor: pointer; " src="../../hisglobal/images/back_tab.png" Title='Click here to come back on desk' onClick="cancel1();" >
		</td>
		</tr>
	</table>-->
	<!-- <br>
    <div align="center" id=" ">					 
					 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a>
						<a href="#" class="button"	onclick="clearDtl('requestPage');"><span class="clear">Clear</span></a> 
						<a href="#" class="button" onclick="cancel1();"><span class="cancel">Cancel</span></a>
					</div>  -->
					
		<input type="hidden" name="hmode"/>
		<input type="hidden" name="mode"/>
		<input type="hidden" name="strCurrentDate" value="${thirdPartyIssueReqBean.strCurrentDate}"/>
		<input type="hidden" name="strItemCatNo" value="${thirdPartyIssueReqBean.strItemCatNo}"/>
		<input type="hidden" name="strStoreId" value="${thirdPartyIssueReqBean.strStoreId}" />
		<input type="hidden" name="strReqNo" value="${thirdPartyIssueReqBean.strReqNo}" />
		<input type="hidden" name="strStoreTypeId" value="${thirdPartyIssueReqBean.strStoreTypeId}" />
		<input type="hidden" name="comboValue" value="${thirdPartyIssueReqBean.comboValue}">
		<input type="hidden" name="strReOrderFlgColor" value="${thirdPartyIssueReqBean.strReOrderFlgColor}"/>
		<input type="hidden" name="strThirdPartyFlag" value="${thirdPartyIssueReqBean.strThirdPartyFlag}" >
		<input type="hidden" name="strItemDtlWithIssueQty" id="strItemDtlWithIssueQty" value="0"/>

<cmbPers:cmbPers />
	<!-- <div id="blanket" style="display:none;"></div> -->
	<!-- <div class="popUpDiv" id="popUpDiv" style="display:none;">
	<table bgcolor="white">
		<tr>
		<td>
			<div id="searchItemsDtlsDivId" style="display:block;"></div>
			<div id="issueDtlsDivId" style="display:block;"></div>
		</td>
		</tr>
	</table>
	</div> -->
	</fieldset>
</div>
</div>
		<div class='modal' id='tariffDtlsModal' tabindex='-1' role='dialog' aria-labelledby='tariffDtlsModalLabel' aria-hidden='true'>
			<div class='modal-dialog modal-lg'  role='document' style="max-width: 1000px;">
				<div class='modal-content animate-bottom'>
		
				<div class='modal-body' id=''>
					<div id="searchItemsDtlsDivId" style="display:block;"></div>
				</div>
				<div class="modal-footer" style="padding: 0.5rem;display:flex; justify-content:center">
					 <button type="button" class="btn btn-success" onkeypress='createSelectedList();'  onClick='createSelectedList();' data-dismiss="modal" style="padding: 0.175rem 0.75rem;">Ok</button>
					 <button type='button' class='btn btn-danger' data-dismiss='modal' style="padding: 0.175rem 0.75rem;">Cancel</button>
				</div>
				</div>
			</div>
		</div>
		
</html:form>
<jsp:include page="thirdPartyIssueReqSearchRowNew.jsp"></jsp:include>
<%-- <tag:autoIndex></tag:autoIndex>
 --%></body>
</html>