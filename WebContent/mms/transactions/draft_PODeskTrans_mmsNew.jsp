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
<title>PO Desk</title>


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
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet"
type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../mms/js/PODesk.js"></script>
<script language="Javascript" src="../../mms/js/POGenerateJS.js"></script>

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
		text-align:center;
	}
</style>

</head>
<body onload="">
<html:form action="/transactions/PODeskGenerateTransBSCNT">

<div class="container-fluid">
	<div class="prescriptionTile">	
	<fieldset>
		<legend class='legendHeader' id='nonPrintableLegend'>Generate Finalize PO</legend>
	
	<div class="legend2" id="saveId">
		<button id="cancelButton" type="button" class="float-right btn btn-danger mt-1 btn-circle" style="border-radius:50%; padding:12px 13px;" onclick="cancelToDesk();">
				<i class="fas fa-times fa-lg iround" title="Cancel"></i>
		</button>
		
		<!-- <button type="button" class=" btn btn-secondary btn-circle" onclick="clearDtl('requestPage');" style="background: #b9b9b9; border-color:#b9b9b9;margin-top: 0.25rem !important;">
		<img  src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 23px; color: #fff;">
		</button> -->	
				
	    <button  type="button" id="savebutton" class="float-right btn btn-success mt-1 btn-circle" style="border-radius:50%; padding:12px 13px;"  tabindex='2' id="submitId" onClick='save_draftpo();'   data-toggle="" data-target="#previewModal" >					
			<i class="fa fa-download iround"  title="Save"></i>
		</button>												                 
  </div> 
	<center>
	<div id="errMsg" class="errMsg" style="font-size:18px;"><bean:write
		name="PODeskGenerateTransBean" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg" style="font-size:18px;"><bean:write
		name="PODeskGenerateTransBean" property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg" style="font-size:18px;"><bean:write
		name="PODeskGenerateTransBean" property="strMsg" /></div>
	<%-- <tag:tab tabLabel="PO Desk" selectedTab="FIRST"
				align="center" width="TABLEWIDTH">
			</tag:tab> --%>
	</center>	
	
	<!-- <table class="TABLEWIDTH" align="center" cellspacing="0" id='divHeader'>
		<tr class="HEADER">
			<td colspan="3" width="95%" nowrap="nowrap">Generate PO &gt;&gt;</td>
		</tr>
	</table> -->

	<div class='row'>
		<div class='col-sm-2'></div>
		<div class='col-sm-2'>
		<label>Store Name</label>
		</div>
		<div class='col-sm-2' align="left" style='font-weight: 400; '>
		<html:hidden
					name="PODeskGenerateTransBean" property="strStoreId"></html:hidden><bean:write
					name="PODeskGenerateTransBean" property="strStoreName"
					filter="false"></bean:write>
		</div>
		<div class='col-sm-2'>
		<label>Item Category</label>
		</div>
		<div class='col-sm-2' align="left" style='font-weight: 400; '>
		<html:hidden name="PODeskGenerateTransBean" property="strItemCat"></html:hidden>
			<bean:write name="PODeskGenerateTransBean" property="strItemCatName" filter="false"></bean:write>
		</div>
		<div class='col-sm-2'></div>
	</div>
	
	<div class='row'>
		<div class='col-sm-2'></div>
		<div class='col-sm-2'>
		<label>PO Type</label>
		</div>
		<div class='col-sm-2' align="left" style='font-weight: 400; '>
		<html:hidden name="PODeskGenerateTransBean" property="strPOTypeId"></html:hidden>
			<bean:write name="PODeskGenerateTransBean" property="strPOType"	filter="false"></bean:write>
		</div>
		<div class='col-sm-2'>
		<label>PO Date</label>
		</div>
		<div class='col-sm-2' align="left" style='font-weight: 400; '>
		<html:hidden name="PODeskGenerateTransBean" property="strpoDateId"></html:hidden>
			<bean:write name="PODeskGenerateTransBean" property="strPODate" filter="false"></bean:write>
		</div>
		<div class='col-sm-2'></div>
	</div>
	
	<%-- <table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td width="25%" class="LABEL">Store Name</td>
			<td width="25%" class="CONTROL"><html:hidden
				name="PODeskGenerateTransBean" property="strStoreId"></html:hidden><bean:write
				name="PODeskGenerateTransBean" property="strStoreName"
				filter="false"></bean:write></td>
			<td width="25%" class="LABEL">Item
			Category</td>
			<td width="25%" class="CONTROL">
			<html:hidden
				name="PODeskGenerateTransBean" property="strItemCat"></html:hidden><bean:write
				name="PODeskGenerateTransBean" property="strItemCatName"
				filter="false"></bean:write>
			</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">PO Type
			</td>
			<td width="25%" class="CONTROL">
			<html:hidden
				name="PODeskGenerateTransBean" property="strPOTypeId"></html:hidden><bean:write
				name="PODeskGenerateTransBean" property="strPOType"
				filter="false"></bean:write>
			</td>
			
			<td width="25%" class="LABEL">Po Date</td>
			<td width="25%" class="CONTROL">
			<html:hidden
				name="PODeskGenerateTransBean" property="strpoDateId"></html:hidden><bean:write
				name="PODeskGenerateTransBean" property="strPODate"
				filter="false"></bean:write>
			</td>
		</tr>
	</table> --%>
	
	<div id="divDraftPODTL">
		<bean:write name="PODeskGenerateTransBean" property="strDraftPoDetailsBS" filter="false"></bean:write>
	</div> 

	<div id="divSaveCancelId" style="display: none">
		<br>
		<div align="center" id="svbtn">	
			<logic:equal value="21" property='tmpPoType' name='PODeskGenerateTransBean' >				 
				 	<a href="#" class="button" id="submitId" onclick=' return validateDraft();'><span class="savedraftpo">Save Draft</span></a></logic:equal>
			<logic:notEqual value="21" property='tmpPoType' name='PODeskGenerateTransBean' >				 
				 	<a href="#" class="button" id="submitId" onclick=' return validate1();'><span class="save">Save</span></a></logic:notEqual>
					<a href="#" class="button" onclick="cancelToDesk();"><span class="cancel">Cancel</span></a>
		</div> 
	</div>
	
	<input type="hidden" name="strCurrentDate" value="${ PODeskGenerateTransBean.strCurrentDate}" />
	<input type="hidden" name="strItemIds" />
	<input type="hidden" name="strINRCurrencyId"  value="${ PODeskGenerateTransBean.strINRCurrencyId}" />
	<input type="hidden" name="strItemBrandIds" />
	<input type="hidden" name="strIndianDeleivryDate" value="${ PODeskGenerateTransBean.strIndianDeleivryDate}"/>
	<input type="hidden" name="strImportedDeleivryDate" value="${ PODeskGenerateTransBean.strImportedDeleivryDate}"/>
	<input type="hidden" name="strStoreIds" />
	<input type="hidden" name="strRequestIds" />
	<input type="hidden" name="strIndianImportedFlg" value="0" />
	<input type="hidden" name="hmode" />
	<input type="hidden" name="strSDFFlgColor"     value="${PODeskGenerateTransBean.strSDFFlgColor}">
	<input type="hidden" name="tmpPoType"     value="${PODeskGenerateTransBean.tmpPoType}">
	<input type="hidden" name="strStoreName"     value="${PODeskGenerateTransBean.strStoreName}">
	<input type="hidden" name="strPoNo"     value="${PODeskGenerateTransBean.strPoNo}">
	
	<cmbPers:cmbPers />
		</fieldset>
	</div>
</div>
	
</html:form>
<tag:autoIndex></tag:autoIndex>  
</body>
</html>