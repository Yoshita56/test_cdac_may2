<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>


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
<script language="Javascript" src="../../mms/js/POCancelJS.js"></script>

</head>
<body>
<html:form action="/transactions/PODeskCancelTransBSCNT">

	<center>
	<div id="errMsg" class="errMsg"><bean:write
		name="PODeskCancelTransBean" property="strErr" /></div>
	<div id="warningMsg" class="warningMsg"><bean:write
		name="PODeskCancelTransBean" property="strWarning" /></div>
	<div id="normalMsg" class="normalMsg"><bean:write
		name="PODeskCancelTransBean" property="strMsg" /></div>

	</center>
	<fieldset form="form1">
	
  <legend style="width:auto; margin-bottom: 0px;font-size: 1.5rem;font-weight: 400;margin-left:10px;color: #666;" id='nonPrintableLegend'> PO Desk</legend>
  <div class="legend2" id='nonPrintableLegend2'>
			<button type="button" class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="cancelToDesk();">
				<i class="fas fa-ban iround" title="Cancel"></i>
			</button>
			<button type="button" id="savebutton" class="float-right btn btn-outline-success mt-1 btn-circle" tabindex='2'  onclick='return validate1()' name="requestForLpPatient" style="background-color: #5cb85c;">
				<i class="fa fa-save iround" title="Save"></i>
			</button>
		</div>
		<div class="prescriptionTile">
		  <div class="row rowFlex reFlex">
	        <div class="col-sm-4">
	           <p class="subHeaders"><button type="button" class="btn btn-outline-success  btn-circle1"><i class="fas fa-ban  iround"></i></button>&nbsp;Cancel PO</p>
	        </div>
	        <div class="col-sm-8" align="right">
	            <input type="radio" onclick="showDiv('divPOCancelDtl'),hideDiv('divPOModifyDtl'),disableRadio()" name="strDPOCancelOrModify" value=1 checked="checked"> Cancel&nbsp;&nbsp;&nbsp;&nbsp;
	            <input type="radio" onclick="showDiv('divPOModifyDtl'),hideDiv('divPOCancelDtl'),enableRadio()" name="strDPOCancelOrModify" value=2> Modify
			</div>
	      </div>
	
<div class="row">
			<div class="col-sm-2"><label>Store Name</label></div>
			<div class="col-sm-2" style="font-weight: initial;"><html:hidden name="PODeskCancelTransBean" property="strStoreId"></html:hidden><bean:write name="PODeskCancelTransBean" property="strStoreName" filter="false"></bean:write></div>
			<div class="col-sm-2"><label>PO No.</label></div>
			<div class="col-sm-2" style="font-weight: initial;"><html:hidden name="PODeskCancelTransBean" property="strPONo"></html:hidden><bean:write name="PODeskCancelTransBean" property="strPONo" filter="false"></bean:write></div>
			<div class="col-sm-2"><label>PO Date</label></div>
			<div class="col-sm-2" style="color: #46b8da;"><html:hidden name="PODeskCancelTransBean" property="strPODate"></html:hidden><bean:write name="PODeskCancelTransBean" property="strPODate" filter="false"></bean:write></div>
	  </div>
	  <div class="row">
		<div class="col-sm-2"><label>PO Type</label></div>
		<div class="col-sm-2" style="font-weight: initial;"><html:hidden name="PODeskCancelTransBean" property="strPOTypeId"></html:hidden><bean:write name="PODeskCancelTransBean" property="strPOType" filter="false"></bean:write></div>
		<div class="col-sm-2"><label>Item Category</label></div>
		<div class="col-sm-2" style="font-weight: initial;"><html:hidden name="PODeskCancelTransBean" property="strItemCat"></html:hidden><bean:write name="PODeskCancelTransBean" property="strItemCatName" filter="false"></bean:write></div>
		<div class="col-sm-2"><label>Supplier Name</label></div>
		<div class="col-sm-2" style="font-weight: initial;"><html:hidden name="PODeskCancelTransBean" property="strSupplierId"></html:hidden><bean:write name="PODeskCancelTransBean" property="strSupplierName" filter="false"></bean:write></div>
	  </div>
	
	

			<div id="divPOScheduleDetailsPlusID" style="display: none;" align="left">
			  <p class='subHeaders'><i class="fas fa-plus-circle" onclick="showDiv('divPOScheduleDetailsMinusID'),hideDiv('divPOScheduleDetailsPlusID'),showDiv('divPOScheduleDetails');" style="cursor: pointer;"> </i>&nbsp;&nbsp;Schedule Details</p>
			</div>
			<div id="divPOScheduleDetailsMinusID" style="display: block;" align="left">
			   <p class='subHeaders'><i class="fas fa-minus-circle" onclick="hideDiv('divPOScheduleDetailsMinusID'),hideDiv('divPOScheduleDetails'),showDiv('divPOScheduleDetailsPlusID');" style="cursor: pointer;"> </i>&nbsp;&nbsp;Schedule Details</p>
			</div>

	
	<div id=divPOScheduleDetails><bean:write
		name="PODeskCancelTransBean" property="strScheduleDetails"
		filter="false"></bean:write></div>

	<div id="divPOCancelDtl">
	<div id="divPOCancelPlusID" style="display: block;" align="left">
			  <p class='subHeaders'><i class="fas fa-plus-circle" onclick="showDiv('divPOCancelMinusID'),hideDiv('divPOCancelPlusID'),showDiv('divPOCancel');" style="cursor: pointer;"> </i>&nbsp;&nbsp;Cancel Details</p>
			</div>
			<div id="divPOCancelMinusID" style="display: none;" align="left">
			   <p class='subHeaders'><i class="fas fa-minus-circle" onclick="hideDiv('divPOCancelMinusID'),hideDiv('divPOCancel'),showDiv('divPOCancelPlusID');" style="cursor: pointer;"> </i>&nbsp;&nbsp;Cancel Details</p>
			</div>


	<div id="divPOCancel" style="display: none;">
		<div class="row">
	<div class="col-sm-2"><label><font color="red">*</font>Cancel By</label></div>
	<div class="col-sm-2"><select name="strDCancelBy" class="browser-default custom-select"> <bean:write name="PODeskCancelTransBean" property="strCancelByValues" filter="false"></bean:write></select></div>
	<div class="col-sm-2"><label><font color="red">*</font>Cancel Remarks</label></div>
	<div class="col-sm-6"><textarea class="form-control" name="strDCancelRemarks"></textarea></div>
	</div>
	
	</div>
	</div>

	<div id="divPOModifyDtl" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td class="TITLE" colspan="5">
			<div id="divPOModifyPlusID" style="display: block;color:blue;" align="left"><img
				src="../../hisglobal/images/plus.gif"
				onclick="showDiv('divPOModifyMinusID'),hideDiv('divPOModifyPlusID'),showDiv('divPOModify');"
				style="cursor: pointer;"> Modify Details</div>
			<div id="divPOModifyMinusID" style="display: none;color:blue;" align="left"><img
				src="../../hisglobal/images/minus.gif"
				onclick="hideDiv('divPOModifyMinusID'),hideDiv('divPOModify'),showDiv('divPOModifyPlusID');"
				style="cursor: pointer;"> Modify Details</div>
			</td>
		</tr>
	</table>

	<div id="divPOModify1" style="display: none;">
	<table class="TABLEWIDTH" align="center" cellpadding="1px"
		cellspacing="1px">
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Delivery Date</td>
			<td width="75%" colspan="3" class="CONTROL"><dateTag:date
				name="strDDeliveryDate"></dateTag:date></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Approved By</td>
			<td width="25%" class="CONTROL"><select name="strDApprovedBy"">
				<bean:write name="PODeskCancelTransBean"
					property="strApprovedByValues" filter="false"></bean:write>
			</select></td>
			<td width="25%" class="LABEL"><font color="red">*</font>Approved Date</td>
			<td width="25%" class="CONTROL"><dateTag:date
				name="strDApprovedDate" value="${ PODeskCancelTransBean.strSysdate}"></dateTag:date></td>
		</tr>
		<tr>
			<td width="25%" class="LABEL"><font color="red">*</font>Remarks</td>
			<td width="75%" colspan="3" class="CONTROL"><textarea
				name="strDRemarks"></textarea></td>
		</tr>
	</table>
	</div>
	</div>

	<hr>
	              <div class="row rowFlex reFlex">       
					<div class="col-sm-8"> </div>
					<div class="col-sm-4" align="right">  <i class="fa fa-asterisk" style="color: red;font-size: smaller;"></i>Fields Mandatory </div>				 
				  </div>

<!-- 	<table border="0" class="TABLEWIDTH" align="center">
		<tr>
			<td align="center"><img
				src="../../hisglobal/images/btn-sv.png"
				style="cursor: pointer; " title="Save Record"
				onClick="return validate1();" /> <img
				src="../../hisglobal/images/btn-ccl.png"
				style="cursor: pointer; " title="Cancel Process"
				onClick="cancelToDesk();"></td>
		</tr>
	</table>-->
	
					
	<input type="hidden" name="strItemIds" />
	<input type="hidden" name="strItemBrandIds" />
	<input type="hidden" name="strStoreIds" />
	<input type="hidden" name="strRequestIds" />
	<input type="hidden" name="hmode" />
	<cmbPers:cmbPers />
	</div>
	</fieldset>
</html:form>
<%-- <tag:autoIndex></tag:autoIndex>  
 --%></body>
</html>