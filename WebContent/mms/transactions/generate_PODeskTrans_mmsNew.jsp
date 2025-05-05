<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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


<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../mms/js/PODesk.js"></script>
<script language="Javascript" src="../../mms/js/POGenerateJSBS.js"></script>

<script language="JavaScript" src="../../hisglobal/js/jquery.autocomplete.min.js"></script>
<style type="text/css">
.table th, .table td {
    padding: 0.15rem;
    text-align: left;
    padding-bottom: 6px;
}
.btn-info {
    padding: 0.2rem 0.75rem;
}
.viewbill {
    width: 40%;
}
.table th, .table td {
    text-align: left;
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
</style>
</head>
<body onload="getRequestDetails();">
<html:form action="/transactions/PODeskGenerateTransBSCNT">

	<center>
	<div id="errMsg" class="errMsg" style="font-size:18px;"><bean:write
		name="PODeskGenerateTransBean" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg" style="font-size:18px;"><bean:write
		name="PODeskGenerateTransBean" property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg" style="font-size:18px;"><bean:write
		name="PODeskGenerateTransBean" property="strMsg" /></div>
	</center>	
	
<div class="container-fluid">
	<div class="prescriptionTile">	
	<fieldset form="form1">
	  	<legend class="legendHeader" id='nonPrintableLegend'>Po Desk</legend>
  		
  		<div class="legend2" id='nonPrintableLegend2'>
			<button type="button" class="float-right btn btn-danger mt-1 btn-circle" style="border-radius:50%; padding:12px 13px;" onclick="cancelToDesk();">
				<i class="fas fa-times fa-lg iround" title="Cancel"></i>
			</button>
		</div>
		
		<div class="row rowFlex reFlex">
		  <div class="col-sm-12">
		    <p class="subHeaders"><i class="fas fa-download  iround"></i>
		    &nbsp;Generate PO</p>
		  </div>
		</div>

		<div class="row">
			<div class="col-sm-2"><label>Store Name</label></div>
			<div class="col-sm-2" style="font-weight: initial;"><html:hidden name="PODeskGenerateTransBean" property="strStoreId"></html:hidden><bean:write name="PODeskGenerateTransBean" property="strStoreName" filter="false"></bean:write></div>
			<div class="col-sm-2"><label>Item Category</label></div>
			<div class="col-sm-2" style="font-weight: initial;"><html:hidden name="PODeskGenerateTransBean" property="strItemCat"></html:hidden><bean:write name="PODeskGenerateTransBean" property="strItemCatName" filter="false"></bean:write></div>
			<div class="col-sm-2"><label>PO Type</label></div>
			<div class="col-sm-2" style="font-weight: initial;"><html:hidden name="PODeskGenerateTransBean" property="strPOTypeId"></html:hidden><bean:write name="PODeskGenerateTransBean" property="strPOType" filter="false"></bean:write></div>
		</div>
	<%--  <table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td width="25%" class="LABEL"><div style='display:none;'>Po Date</div></td>
			<td width="25%" class="CONTROL"><div style='display:none;'>
			<html:hidden name="PODeskGenerateTransBean" property="strpoDateId"></html:hidden><bean:write name="PODeskGenerateTransBean" property="strpoDate" filter="false"></bean:write></div>
			</td>
			
			
			
			<td width="25%" class="LABEL"><div style="display:none"><font color="red">*</font>Supplier(*Marked
			are Rated Supplier)</div></td>
			<td width="25%" class="CONTROL">
			<div id="divSupplier" style="display:none"><select name="strSupplierId">
				<option value="0">Select Value</option>
			</select></div>
			<div id="divSupplierLabel" style="display:none" ></div>
			</td>
		</tr>
	</table>  --%>
	<div id="divSupplier" style="display:none"><select name="strSupplierId">
				<option value="0">Select Value</option>
			</select></div>
			<div id="divSupplierLabel" style="display:none" ></div>

	<div id="divPlusMinusRequestDtl" style="display: none;">
			<div id="divRequestDetailsPlusID" style="display: none;" align="left">
			  <p class='subHeaders'><i class="fas fa-plus-circle" onclick="showDiv('divRequestDetailsMinusID'),hideDiv('divRequestDetailsPlusID'),showDiv('divRequestDetails');" style="cursor: pointer;"> </i>&nbsp;&nbsp;Indent Details</p>
			</div>
			<div id="divRequestDetailsMinusID" style="display: block;" align="left">
			   <p class='subHeaders'><i class="fas fa-minus-circle" onclick="hideDiv('divRequestDetailsMinusID'),hideDiv('divRequestDetails'),showDiv('divRequestDetailsPlusID');" style="cursor: pointer;"> </i>&nbsp;&nbsp;Indent Details</p>
			</div>
	</div>
	<div id="divRequestDetails"></div>
	
	<div id="divFullCompiledBody" style="display: none">
	<div id="divRequestItemDetails"><div id="divSuppId"></div></div>
	<div id="divSuppWiseCompilation"></div>
	<div id="divDraftPODTL">
	<bean:write name="PODeskGenerateTransBean" property="strDraftPoDetails" filter="false"></bean:write>
	</div>
	
	<div id="divPurchaseDetailsPlusID" style="display: none;" align="left">
			  <p class='subHeaders'><i class="fas fa-plus-circle" onclick="showDiv('divPurchaseDetailsMinusID'),hideDiv('divPurchaseDetailsPlusID'),showDiv('divPurchaseDetails')" style="cursor: pointer;"> </i>&nbsp;&nbsp;Purchase Details</p>
			</div>
			<div id="divPurchaseDetailsMinusID" style="display: block;" align="left">
			   <p class='subHeaders'><i class="fas fa-minus-circle" onclick="hideDiv('divPurchaseDetailsMinusID'),hideDiv('divPurchaseDetails'),showDiv('divPurchaseDetailsPlusID');" style="cursor: pointer;"> </i>&nbsp;&nbsp;Purchase Details</p>
			</div>
			
	<!-- <table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td class="TITLE" colspan="5">
			<div id="divPurchaseDetailsPlusID" style="display: none;" align="left"><img
				src="../../hisglobal/images/plus.gif"
				onclick="showDiv('divPurchaseDetailsMinusID'),hideDiv('divPurchaseDetailsPlusID'),showDiv('divPurchaseDetails');"
				style="cursor: pointer;"> Purchase Details</div>
			<div id="divPurchaseDetailsMinusID" style="display: block;"
				align="left"><img src="../../hisglobal/images/minus.gif"
				onclick="hideDiv('divPurchaseDetailsMinusID'),hideDiv('divPurchaseDetails'),showDiv('divPurchaseDetailsPlusID');"
				style="cursor: pointer;"> Purchase Details</div>
			</td>
		</tr>
	</table> -->
	<div id="divPurchaseDetails">
	     <div class="row">
			<div class="col-sm-2"><label><font color="red">*</font>Delivery Location</label></div>
			<div class="col-sm-2" id="divDeliveryLocation">
			  <select name="strDDeliveryLocation" class="browser-default custom-select">
				<bean:write name="PODeskGenerateTransBean" property="strDeliveryLocationValues" filter="false"></bean:write>
			  </select>
			</div>
			<div class="col-sm-2"><label><Font color="red">*</Font>PO Raised By</label></div>
			<div class="col-sm-2">
			  <select name="strVerifiedBy" class="browser-default custom-select">
				<bean:write name="PODeskGenerateTransBean" property="strApprovedByVals" filter="false"></bean:write>
			  </select>
			</div>
			<div class="col-sm-2"><label>Remarks</label></div>
			<div class="col-sm-2"><textarea class="form-control" onkeyup="maxLengthRemarks(this,'100')" name=strDRemarks style='height:38px;'></textarea></div>
	    </div>
	    <div class="row my-2">
	    <logic:equal value="21" property='tmpPoType' name='PODeskGenerateTransBean' >
			<div class="col-sm-2"><label>References and Comments</label></div>
			<div class="col-sm-4"><textarea class="form-control" rows='2' cols='50' onkeyup="maxLengthRemarks(this,'2000')" name=strDComments ></textarea></div>
			<div class="col-sm-2"><label>Additional Notes</label></div>
			<div class="col-sm-4"><textarea class="form-control" rows='2' cols='50' onkeyup="maxLengthRemarks(this,'2000')" name=strDNotes ></textarea></div>
			</logic:equal>
	    </div>
	    <div class="row">
			<div style='display:none;' class="col-sm-2"><label>PO Ref. No</label></div>
			<div class="col-sm-4"  style='display:none;'><input type="text"
				maxlength="50" autocomplete="off" onkeypress='return validateData(event,16);'
				name="strDPORefNo"></div>

			<div class="col-sm-2" style='display:none;'><label>PO Date</label></div>
			<div class="col-sm-4" style='display:none;'><dateTag:date
				name="strDPORefDate" value ="${PODeskGenerateTransBean.strCurrentDate}"></dateTag:date></div>
		</div>
	    
	<%-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">	
	    <tr>
			<td class="LABEL" colspan="4">
			 <div style='display:none;'>
			   <input type="radio" name="strSupplierType" value="0" checked="checked" onClick="onRadio(this)" />Indian &nbsp;&nbsp; 
               <input type="radio" name="strSupplierType" value="1" onClick="onRadio(this)" />Imported
			  </div>
			</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><div style="display:none"><font color="red">*</font>Purchase
			Source</div></td>
			<td width="25%" class="CONTROL">
			<div id="divPurchaseSource" style="display:none"><select name="strDPurchaseSource">
				<bean:write name="PODeskGenerateTransBean"
					property="strPurchaseSourceValues" filter="false"></bean:write>
			</select></div>
			</td>
			<td width="25%" class="LABEL"><div style='display:none;'><font color="red">*</font>Delivery
			Date</div></td>
			<td width="25%" class="CONTROL"><div style='display:none;'><dateTag:date
				name="strDDeliveryDate"  value ="${PODeskGenerateTransBean.strIndianDeleivryDate}"  ></dateTag:date></div></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Delivery
			Location</td>
			<td width="25%" class="CONTROL">
			<div id="divDeliveryLocation"><select
				name="strDDeliveryLocation">
				<bean:write name="PODeskGenerateTransBean"
					property="strDeliveryLocationValues" filter="false"></bean:write>
			</select></div>
			</td>
			<td width="25%" class="LABEL"><div style = "display:none;">Tax</div></td>
			<td width="25%" class="CONTROL"><div style = "display:none;"><input type="text" maxlength="5"
				onkeypress='return validateData(event,7);'
				onkeyup='notGreaterThanCent(this)' autocomplete="off" name="strDOverAllTax" value ="${PODeskGenerateTransBean.strTax}"
				class="txtFldMin">%</div></td>
		</tr>
		<!--<tr>
			<td width="25%" class="LABEL">Tender No.</td>
			<td width="25%" class="CONTROL"><input type="text"
				maxlength="50" onkeypress='return validateData(event,16);'
				name="strDTenderNo"></td>

			<td width="25%" class="LABEL">Quotation No.</td>
			<td width="25%" class="CONTROL"><input type="text"
				maxlength="50" onkeypress='return validateData(event,16);'
				name="strDQuotationNo"></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL">Tender Date</td>
			<td width="25%" class="CONTROL"><dateTag:date
				name="strDTenderDate"></dateTag:date></td>

			<td width="25%" class="LABEL">Quotation Date</td>
			<td width="25%" class="CONTROL"><dateTag:date
				name="strDQuotationDate"></dateTag:date></td>
		</tr>  -->
		<tr>
			<td width="25%" class="LABEL"><div style='display:none;'><Font color="red">*</Font>PO Ref. No</div></td>
			<td width="25%" class="CONTROL"><div style='display:none;'><input type="text"
				maxlength="50" autocomplete="off" onkeypress='return validateData(event,16);'
				name="strDPORefNo"></div></td>

			<td width="25%" class="LABEL"><div style='display:none;'><Font color="red">*</Font>PO Date</div></td>
			<td width="25%" class="CONTROL"><div style='display:none;'><dateTag:date
				name="strDPORefDate" value ="${PODeskGenerateTransBean.strCurrentDate}"></dateTag:date></div></td>
		</tr>
		<tr>
				<td width="25%" class="LABEL" ><Font color="red">*</Font>PO Raised By</td>
				<td width="25%" class="CONTROL"><select name="strVerifiedBy" class="comboMax">
				<bean:write name="PODeskGenerateTransBean"
					property="strApprovedByVals" filter="false"></bean:write>
				</select>
				</td>
				<td width="25%" class="LABEL" ><div style="display:none;"><Font color="red">*</Font>PO Verified Date</div></td>
				<td width="25%" class="CONTROL"><div style="display:none;"><dateTag:date name="strVerifiedDate" value ="${PODeskGenerateTransBean.strCurrentDate}"></dateTag:date></div></td>
			</tr>
		<tr>
			<td width="25%" class="LABEL">Remarks</td>
			<td width="75%" class="CONTROL" colspan="3"><textarea
				onkeyup="maxLengthRemarks(this,'100')" name=strDRemarks></textarea></td>
		</tr>
		<logic:equal value="21" property='tmpPoType' name='PODeskGenerateTransBean' >
		<tr>
			<td width="25%" class="LABEL">References and Comments</td>
			<td width="75%" class="CONTROL" colspan="3"><textarea rows='7' cols='100'
				onkeyup="maxLengthRemarks(this,'2000')" name=strDComments></textarea></td>
		</tr>
		
		<tr>
			<td width="25%" class="LABEL">Additional Notes</td>
			<td width="75%" class="CONTROL" colspan="3"><textarea rows='7' cols='100'
				onkeyup="maxLengthRemarks(this,'2000')" name=strDNotes></textarea></td>
		</tr>
		</logic:equal>
		
	</table> --%>
	</div>
	<div id="divFullOtherDetails" style="display:none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td class="TITLE" colspan="5">
			<div id="divOtherDetailsPlusID" style="display: none;" align="left"><img
				src="../../hisglobal/images/plus.gif"
				onclick="showDiv('divOtherDetailsMinusID'),hideDiv('divOtherDetailsPlusID'),showDiv('divOtherDetails');"
				style="cursor: pointer;"> Other Details</div>
			<div id="divOtherDetailsMinusID" style="display: block;" align="left"><img
				src="../../hisglobal/images/minus.gif"
				onclick="hideDiv('divOtherDetailsMinusID'),hideDiv('divOtherDetails'),showDiv('divOtherDetailsPlusID');"
				style="cursor: pointer;"> Other Details</div>
			</td>
		</tr>
	</table>
	<div id="divOtherDetails" style="display:none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Agent Name</td>
			<td width="25%" class="CONTROL">
			<div id="divAgentName"><select name="strDAgentName">
				<option value=0>Select Value</option>
			</select></div>
			</td>
			<td width="25%" class="LABEL"><font color="red">*</font>CA Name</td>
			<td width="25%" class="CONTROL">
			<div id="divCAName"><select name="strDCAName">
				<option value=0>Select Value</option>
			</select></div>
			</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>IAC Charges</td>
			<td width="25%" class="CONTROL"><input type="text" maxlength="2"
				onkeypress='return validateData(event,7);' class="txtFldMin" name="strDIACCharge">%</td>
			<td width="25%" class="LABEL"><font color="red">*</font>Insurance Charges</td>
			<td width="25%" class="CONTROL"><input type="text" maxlength="7"
				onkeypress='return validateData(event,7);'
				name="strDInsuranceCharge"></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Demurrages By</td>
			<td width="25%" class="CONTROL"><select name="strDDemurrageBy">
				<option value="0">Select Value</option>
				<option value="1">Supplier</option>
				<option value="2">Agent</option>
				<option value="3">Hospital</option>
			</select></td>

			<td width="25%" class="LABEL"><font color="red">*</font>Currency Name</td>
			<td width="25%" class="CONTROL">
			<div id="divCurrencyName"><select name="strDCurrencyName" onchange="setINRCurrency(this);">
				<bean:write name="PODeskGenerateTransBean" 
					property="strCurrencyValues" filter="false"></bean:write>
			</select></div>
			</td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Currency Value</td>
			<td width="75%" class="CONTROL" colspan="3"><input type=hidden
				name=strDNetAmount><input type="text" maxlength="7"
				onkeypress='return validateData(event,7);' name="strDCurrencyValue"></td>
		</tr>
	</table>
	</div>
	</div>
	</div>
	<div class="row" id='compilebtnid' style='display: none;'>
	<div class="col-sm-12" align="center"><button type="button"  class="btn btn-info" onclick='getRequestItemDetails(this);'><span class='compile'>Compile</span></button></div>
	</div>
	<!-- <table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px" id="divCompile">
	</table> -->
	<hr>
	<div class="row rowFlex reFlex" id="footerid">
        <div class="col-sm-4">
         In case of Non RC items total PO cost may vary
        </div>
        <div class="col-sm-4" id="divSaveCancelId" style="display: none">
	        <div  align="center" id="svbtn">	
					<logic:equal value="21" property='tmpPoType' name='PODeskGenerateTransBean' >				 
						 	<button type="button"  class="btn btn-info" id="submitId" onclick=' return validateDraft();'><i class="fas fa-save"></i>&nbsp;Save Draft</button></logic:equal>
					<logic:notEqual value="21" property='tmpPoType' name='PODeskGenerateTransBean' >				 
						 	<button type="button"  class="btn btn-info" id="submitId" onclick=' return validate1();'>Save</button></logic:notEqual>
			</div> 
		</div>
		<div class="col-sm-4" id='none'></div>
             <div class="col-sm-4" align="right">
       			 <i class="fa fa-asterisk" style="color: red;font-size: smaller;"></i>Fields Mandatory</div>				
        </div>
				           
	<!-- <table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr class="FOOTER">
		<td colspan="2"><div align='left'>In case of Non RC items total PO cost may vary</div></td>
			<td colspan="2"><font size="2" color="red">*</font> Mandatory
			Fields</td>
		</tr>
	</table> -->

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
	<cmbPers:cmbPers />
	</div>
	</div>
	</fieldset>
</html:form>
<%-- <tag:autoIndex></tag:autoIndex>  
 --%>
			<div class='modal ' id='tariffDtlsModal' tabindex='-1' role='dialog' aria-labelledby='tariffDtlsModalLabel' aria-hidden='true'>
				<div class='modal-dialog'  role='document'>
					<div class='modal-content animate-bottom'>
						<div class='modal-header'>
							<h4 class='modal-title'>Item Details</h4>
							<button type='button' class='close' data-dismiss='modal'>×</button>
						</div>
						<div class='modal-body' id='divIndentNoDetail'>
							
						</div>
					</div>
				</div>
			</div>
			
			<div class='modal ' id='tariffDtlsModal1' tabindex='-1' role='dialog' aria-labelledby='tariffDtlsModalLabel' aria-hidden='true'>
				<div class='modal-dialog'  role='document'>
					<div class='modal-content animate-bottom'>
						<div class='modal-header'>
							<h4 class='modal-title'>Item Details</h4>
							<button type='button' class='close' data-dismiss='modal'>×</button>
						</div>
						<div class='modal-body' id='divIndentNoDetail'>
								<div id="divReqItemDtlId" class='popup' style="display: none; left:500px; top:170px;"></div>
							
						</div>
					</div>
				</div>
			</div>
	
</body>
</html>