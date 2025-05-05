<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>
<!-- 
/**
 * @author Amit Kumar
 * Date of Creation : 26/05/2023
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Inventory
 */
 -->
<html>
<head>
<meta charset=UTF-8">
<title>Request for Patient</title>
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
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/dropdown.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" 
type="text/css">


<script language="Javascript" src="../js/patientListing.js"></script>

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="Javascript" src="../js/searchItems_utilBS.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/newMultiRow.js"></script>
<script language="JavaScript" src="../../hisglobal/js/dropdown.js"></script>

<script language="JavaScript" src="../js/mms.js"></script>


<script language="JavaScript" src="../../hisglobal/js/common.js"></script>

<script language="JavaScript" src="../js/ReturnRequest.js"></script>
<style type="text/css">
.newhr{
    border-top: 3px solid rgb(6, 138, 255);
    margin-right: -16px;
	margin-left: -16px;
}
/* .table th, .table td {
    padding: 0.15rem;
    text-align: center;
} */
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
<script type="text/javascript">

   function invokeCheckQty(mode, index, unitObject)
   {
			 		
		if(checkQty(index,'strReqQty','strUnitName'))
		{
		
			calculateCost(mode, 'strReqQty', 'strUnitName', '', index, '' , '1')
		
		}
	
	}	

	
	function getItemSelectPopup()
	{
	  
 	  var ToStoreCmb   = document.forms[0].strToStore.value;
     //alert(ToStoreCmb);
     if(!ToStoreCmb)
     {
         alert("Kindly select sub store name");
         return false;
     }
      if(ToStoreCmb != '0')
       {	
	
	   var strModeVal 					= "3" ; 
		var strRequestType              = document.forms[0].strTmpReqType.value;
		var strItemCategory 			= document.forms[0].strTmpItemCatg.value; 
		var strFromStoreId 				= document.forms[0].strTmpStoreName.value;
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strReqQty','strUnitName');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t','s');
		var testFunction                = "CallFunc";
		var arg                         = " ";  
		var userInfo                    = strFromStoreId; 
		var strMultiRowFetchDataArray 	= new Array('1','11','4','0^strUnitName^invokeCheckQty');
 
	    var layerIndex = "1";
         
	      searchItemsWithUserFunction ( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg,userInfo);
	  }
	   else
	   {
	   	  
	       if(ToStoreCmb.selectedIndex == 0)
	       {
	           alert("Plz Select To Store Name !!!!");
	           ToStoreCmb.focus();
	       }
	  return false;
	 }
	}


</script>

</head>

<body onload="OnLoadFunction()";>

<html:form action="/transactions/ReturnRequestTransBSCNT.cnt"
	name="returnRequest"
	type="mms.transactions.controller.fb.ReturnRequestTransFB"
	method="post">

	<div class="errMsg" id="errMsg" style="font-size:18px"><bean:write name="returnRequest"
		property="strErr" /></div>
	<div class="warningMsg" id="warningMsg" style="font-size:18px"><bean:write
		name="returnRequest" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg" style="font-size:18px"><bean:write
		name="returnRequest" property="strMsg" /></div>

<%-- <div class="alert alert-danger  alert-dismissible fade show" id="errID" style="display: none;"><bean:write name="rateContractDtlBean" property="strErr" /></div>
<div class="alert alert-success  alert-dismissible fade show" id="normalMsg" style="display: none;"><bean:write name="rateContractDtlBean" property="strMsg" /></div>
<div class="alert alert-warning  alert-dismissible fade show" id="wrnID" style="display: none;"><bean:write name="rateContractDtlBean" property="strWarning" /></div>
--%>	
<div class="container-fluid">
	<div class="prescriptionTile">	
	<fieldset>					
 		  <legend class="legendHeader" id='nonPrintableLegend'> Return Request</legend>
		 
		  <div class="legend2" id='saveId'>
			<button type="button" class="float-right btn btn-danger mt-1 btn-circle" style="border-radius:50%; padding:12px;" onclick="cancelToDesk();">
				<i class="fas fa-times fa-lg iround" title="Cancel"></i>
			</button>
			
			<button type="button" class="float-right btn btn-secondary btn-circle" style="border-radius:50%; padding:12px 11px; background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" onclick="initPage();">
				<i class="fas fa-broom iround" title="Clear"></i>
			</button>
			
			<button type="button" class="float-right btn btn-success mt-1 btn-circle savebtn" id="savebutton" name="requestForLpPatient" tabindex='2'style="border-radius:50%; padding:12px;" id="submitId" onclick='return validate1();'>
				<i class="fa fa-download fa-beat iround" title="Save"></i>
			</button>
			
		 </div>
<div class="container">
		<div class="row my-1">
			  <div class="col-sm-2">Store Name:<font color="red">*</font></div>
			  <div class="col-sm-4"><bean:write name="returnRequest" property="strStoreName" filter="false" /></div>
			  <div class="col-sm-2">Item Category:<font color="red">*</font></div>
			  <div class="col-sm-4"><bean:write name="returnRequest" property="strItemCatg" filter="false" /></div>
		 </div>
	
	    <div class="row my-1">
			 <div class="col-sm-2"><label>Req Date:</label></div>
			 <div class="col-sm-4"><bean:write name="returnRequest"  property="strReqDate" filter="false" /></div>
			 <div class="col-sm-2">Sub Store:<font color="red">*</font></div>
			 <div class="col-sm-4"><select class='browser-default custom-select' name='strToStore'><bean:write name="returnRequest" property="strToStoreCombo"  filter="false" /> </select></div>
	    </div>
	    
        <div class="row my-1">
			 <div class="col-sm-2 "><label>Urgent:</label></div>
			 <div class="col-sm-4"><input type="radio" name="strIsNormal" value="1" checked="checked" onClick="ftnTick(this)" />Normal &nbsp;&nbsp; <input type="radio" name="strIsUrgent" value="0" onClick="ftnTick(this)" />Urgent</div>
	    </div>
</div>
<hr>
		<div class="row my-1">
			<div class="col-sm-12" align="right">
				<button type="button" class="btn btn-info" id='strSearchItemButtonDivId' data-toggle="modal" data-target="#tariffDtlsModal" onclick='getItemSelectPopup();'/><i class="fas fa-search"></i></button>
			</div>
		</div>
<hr>
	 <table class="table" >
			<thead class='thead-dark' align='center'>
				<tr>
					<th  scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Item Name</th>
					<!--<th width="20%" class="multiLabel"><font size="2" color="aqua">*</font>Rate/Unit</th>  -->
					<th  scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Batch/SLNo </th>
					<th  scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Available Qty </th>
					<th  scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</th>
					<th  scope='col' style='font-weight:350 !important ;font-size: 16px !important;'><font color='red'>*</font>Unit Name</th>
				</tr>
			</thead>
	</table>

	<div id="id1"></div>
	
    <div class="row">
	<div class="col-sm-2" align="center"><label>Remarks</label></div>
	<div class="col-sm-10"><textarea name="strRemarks" class="form-control" id="strRemarks" cols="20"  rows="2" ></textarea></div>
	</div>
<hr>
    <div class="row ">
		<div class="col-sm-10"></div>
      	<div class="col-sm-2" align="right"><i class="fa fa-asterisk" style="color: red;font-size: smaller;"></i>Fields Mandatory</div>				
		</div>


			<input type="hidden" name="hmode" />
			<input type="hidden" name="strNormal"
				value="${returnRequest.strIsNormal}">
			<input type="hidden" name="strUrgent"
				value="${returnRequest.strIsUrgent}">
			<input type="hidden" name="strTmpStoreName"
				value="${returnRequest.strTmpStoreName}">
			<input type="hidden" name="strTmpItemCatg" value="${returnRequest.strTmpItemCatg}">
			<input type="hidden" name="strTmpReqType" value="${returnRequest.strTmpReqType}">
			<input type="hidden" name="strPath" value="${returnRequest.strPath}">
			<input type="hidden" name="strRequestStatusFlg" value="0">
			
			<input type="hidden" name="strTmpToStore" value="${returnRequest.strTmpToStore}">
			<input type="hidden" name="strReOrderFlgColor" value=""/>
	
	<!-- <div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			<div id="searchItemsDtlsDivId" style="display: block;"></div>
			</td>
		</tr>
	</table>
	</div> -->
	<div class='modal' id='tariffDtlsModal' tabindex='-1' role='dialog' aria-labelledby='tariffDtlsModalLabel' aria-hidden='true'>
				<div class='modal-dialog modal-lg'  role='document' style="max-width: 1000px;">
					<div class='modal-content animate-bottom'>
						<div class='modal-body' id=''>
                             <div id="searchItemsDtlsDivId" style="display:block;"></div>
						</div>
						<div class="modal-footer" style="padding: 0.5rem; display:flex; justify-content:center">
					        <button type="button" class="btn btn-success" onkeypress='createSelectedList();'  onClick='createSelectedList();' data-dismiss="modal" style="padding: 0.175rem 0.75rem;">Ok</button>
					        <button type='button' class='btn btn-danger' data-dismiss='modal' style="padding: 0.175rem 0.75rem;">Cancel</button>
      					</div>
					</div>
				</div>
			</div>
	<cmbPers:cmbPers />
		</fieldset>
	</div>
	</div>
	
</html:form>
<jsp:include page="returnRequest_itemSearchRow.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>
<div class='modal' id='tariffDtlsModal' tabindex='-1' role='dialog' aria-labelledby='tariffDtlsModalLabel' aria-hidden='true'>

</body>
</html>