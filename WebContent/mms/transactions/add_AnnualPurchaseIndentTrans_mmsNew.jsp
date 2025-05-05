<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<%@ taglib uri="/WEB-INF/onLineReqDiscountDtl.tld" prefix="DisDtl"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<!-- 
/**
 * @author Amit Kumar
 * Date of Creation : 1/5/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
 -->
<html>
<head>
<meta charset=UTF-8">
<title>Annual Purchase Indent</title>
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
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" 
type="text/css">
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
<script language="JavaScript" src="../js/mms.js"></script>
<script language="JavaScript" src="../js/AnnualPurchaseIndent.js"></script>

<style type="text/css">
.newhr{
   
    border-top: 3px solid rgb(6, 138, 255);
    margin-right: -16px;
margin-left: -16px;
}
.table th, .table td {
    padding: 0.15rem;
    text-align: left;
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
}
</style>

<script type="text/javascript">

	function invokeCheckQty(mode, index, unitObject)
	{ 
	    gblIsAvailReq = "0";	
	    if( checkQty(index,'strReqQty','strUnitName'))
		 {
		       
		        // Pass '0' If User Dont Want to Compare Req Qty with Avalaible Quantity 
		 		calculateCost(mode, 'strReqQty', 'strUnitName', 'strCost', index , 'strApproxAmt','0');
		 }
			
	}	
	/*function changeUnitCmb(obj,index)
	{	   
       	alert("Ji");
       document.getElementById("strUnitName" + index).value = "0";
       	document.getElementById("strCostDivId" + index).innerHTML = "0.00";
       document.getElementById("strCost" + index).value = "0";
  
			var costObj = document.getElementsByName("strCost");
			var total = parseFloat("0.00");
		
			if (costObj.length > 1) 
			{
		
			/*	for ( var i = 0, stop = costObj.length - 1; i < stop; i++)
				 {
		
				//	total = total + parseFloat(costObj[i].value);
					
		
				}
		
			}
*/
	  //  total = roundValue(total, 2);
	    
	    /*document.getElementById("strApproxAmtDivId").innerHTML = total;
 //       document.forms[0].strApproxAmt.value=total;
alert(total);
       	
       	
	}*/
	function changeUnitCmb(obj,index)
	{	
       //	document.getElementById("strCostDivId" + index).innerHTML = "0.00";
       	document.getElementById("strCost" + index).value = "0";
 
        calculateCost('1', 'strReqQty', 'strUnitName', 'strCost', index , 'strApproxAmt','0');  	
       	
	}
	
	function CallFunc()
	{
			 var unitNameCmb = document.getElementsByName("strUnitName");
			    for(var j=0;j<unitNameCmb.length;j++)
				{
					//unitNameCmb[j].value = "0";
				}
	   
	}
	
	function getItemSelectPopup()
	{
	  var ItemTypeCmb = document.forms[0].strItemType;
 	  var ToStoreCmb   = document.forms[0].strToStore;
      	
	    var strModeVal 					= "1" ; 
		var strRequestType              = document.forms[0].strTmpReqType.value;
		var strItemCategory 			= document.forms[0].strTmpItemCatg.value; 
		var strFromStoreId 				= document.forms[0].strTmpStoreName.value;
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strReqQty','strUnitName');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t','s','t');
		var testFunction                = "CallFunc";
		var arg                         = " ";  
		
	//	var strMultiRowFetchDataArray 	= new Array('1','4','10','0^strUnitName^invokeCheckQty');
		
		var strMultiRowFetchDataArray 	= new Array('1','4','5','0^strUnitName^invokeCheckQty');
		
		    
	    var layerIndex = "1";
	
        searchItemsWithUserFunction ( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg);
	  
	}
function costReq(){
	if(document.getElementsByName("strCostRequired")[0].value=="1"){
		document.getElementById("costDivReqId").style.display="block";
		document.getElementById("costDivNotReqId").style.display="none";
		document.getElementById("totalCostId").style.display="block";
		
	}else{
		document.getElementById("costDivNotReqId").style.display="block";
		document.getElementById("costDivReqId").style.display="none";
		document.getElementById("totalCostId").style.display="none";
	}
}

</script>

</head>

<body onload="OnLoadFunction(),costReq()";>

<html:form action="/transactions/AnnualPurchaseIndentBSCNT.cnt"
	name="annualPurchaseIndent"
	type="mms.transactions.controller.fb.AnnualPurchaseIndentFB"
	method="post">

	<div class="errMsg" id="errMsg" style="font-size:16px"><bean:write
		name="annualPurchaseIndent" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg" style="font-size:16px"><bean:write
		name="annualPurchaseIndent" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg" style="font-size:16px"><bean:write
		name="annualPurchaseIndent" property="strMsg" /></div>
	
<%-- <div class="alert alert-danger  alert-dismissible fade show" id="errID" style="display: none;"><bean:write name="rateContractDtlBean" property="strErr" /></div>
<div class="alert alert-success  alert-dismissible fade show" id="normalMsg" style="display: none;"><bean:write name="rateContractDtlBean" property="strMsg" /></div>
<div class="alert alert-warning  alert-dismissible fade show" id="wrnID" style="display: none;"><bean:write name="rateContractDtlBean" property="strWarning" /></div>
--%>	
<div class="container-fluid">
	<div class="prescriptionTile">			
	  <legend style="width:auto; margin-bottom: 0px;font-size: 1.5rem;font-weight: 400;margin-left:10px;color: #666;" id='nonPrintableLegend'> Emergency/ Indent Purchase</legend>
		  
	  <div class="legend2" id='saveId'>
		<button type="button" class="float-right btn btn-danger mt-1 btn-circle" style="border-radius:50%; padding:12px;" onclick="cancelToDesk();">
			<i class="fas fa-times fa-lg iround" title="Cancel"></i>
		</button>
		<button type="button" class="float-right  btn btn-secondary btn-circle" style="border-radius:50%; padding:12px 11px; background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" onclick="initPage();">
			<i class="fas fa-broom iround" title="Clear"></i>
		</button>
		<button type="button" id="savebutton" class="float-right btn btn-success mt-1 btn-circle savebtn" name="requestForLpPatient" tabindex='2'style="border-radius:50%; padding:12px;" id="submitId" onclick='return validate1();'>
			<i class="fa fa-download fa-beat iround" title="Save"></i>
		</button>
	 </div>

	  <div class='popup' id='purchaseDtl' style="display: none">
			<table width='400' border="0" cellspacing="0px">
				<tr class="HEADER">
					<th colspan='6' align='left'><div id='11' style='color: blue;'></div>
					</th>
					<th align='right'><img style='cursor: pointer; ' title='To Close Pop-Up'
						src='../../hisglobal/images/popUp_cancel.JPG'
						onClick="hideItemDetails('purchaseDtl');"></th>
				</tr>
			</table>
			<table width='400' border="0" cellspacing="1px" bgcolor='#6097BC' cellpadding="1px">
				<tr>
					<td colspan="1" class='multiLabel'>PO NO</td>
					<td colspan="1" class='multiLabel'>PO Date</td>
					<td colspan="1" class='multiLabel'>Supplier Name</td>
				</tr>
				<tr>
					<td colspan="1" class='multiControl'>
					<div id='1'></div>
					</td>
					<td colspan="1" class='multiControl'>
					<div id='2'></div>
					</td>
					<td colspan="1" class='multiControl'>
					<div id='3'></div>
					</td>
				</tr>
				<tr>
					<td colspan="1" class='multiLabel'>Received Qty</td>
					<td colspan="1" class='multiLabel'>Rate/Unit</td>
					<td colspan="1" class='multiLabel'></td>
				</tr>
				<tr>
					<td colspan="1" class='multiControl'>
					<div id='5'></div>
					</td>
					<td colspan="1" class='multiControl'>
					<div id='7'></div>
					</td>
					<td colspan="1" class='multiControl'></td>
				</tr>
			</table>
		</div>


<div class="container">
	<div class="row my-1">
	  <div class="col-sm-2 ">Store Name:<font color="red">*</font></div>
	  <div class="col-sm-4"><bean:write name="annualPurchaseIndent" property="strStoreName" filter="false" /></div>
	  <div class="col-sm-2">Item Category:<font color="red">*</font></div>
	  <div class="col-sm-4"><bean:write name="annualPurchaseIndent" property="strItemCatg" filter="false" /></div>
	 </div>

    <div class="row my-1 ">
	 <div class="col-sm-2 "><label>Req Date:</label></div>
	 <div class="col-sm-4"><bean:write name="annualPurchaseIndent" property="strReqDate" filter="false" /></div>
	 <div class="col-sm-2">Receiving Store:<font color="red">*</font></div>
	 <div class="col-sm-4">
	 	<select class='browser-default custom-select'  onChange="resetValue();" name='strToStore'> 
	 		<bean:write name="annualPurchaseIndent" property="strToStoreCombo" filter="false" />
		</select>
	</div>
    </div>

   <div class="row my-1 ">
		<div class="col-sm-2 ">Urgent:</div>
		<div class="col-sm-4"><input type="radio" name="strIsNormal" value="1" checked="checked" /> Normal &nbsp;&nbsp;<input type="radio" name="strIsNormal" value="0" /> Urgent</div>
		<div class="col-sm-2"><label>Indent Type :</label></div>
		<logic:equal  name="annualPurchaseIndent" property="strTmpReqType" value="90">
		 	<div class="col-sm-4"><label>Emergency/ Indent Purchase(45 Days) </label></div>
		</logic:equal>
		<logic:equal  name="annualPurchaseIndent" property="strTmpReqType" value="11">
			<td width="25%" class="CONTROL"></td>
			<div class="col-sm-4"><label>Indent for LP(Dept)</label></div>
		</logic:equal>
   </div>

   	<div class="row my-1 ">
		 <div class="col-sm-2 "><label>Indent Period:<font size="2" color="red">*</font></label></div>
		 <div class="col-sm-4"><select class='browser-default custom-select'  name='strIndentPeriod'> <bean:write name="annualPurchaseIndent" property="strIndentPeriodCombo" filter="false" /></select></div>
		 <div class="col-sm-2">
		 	<input type="text" class="form-control" name="strIndentPeriodValue" onkeypress="return validateData(event,3);" maxlength="">
	 	</div>
		 <div class="col-sm-6"></div>
    </div>
</div>
<hr>
    <div class="row my-1">
	<div class="col" align="right">
		<button type="button" class="btn btn-info" id='strSearchItemButtonDivId' data-toggle="modal" data-target="#tariffDtlsModal" onclick='getItemSelectPopup();'/><i class="fas fa-search"></i></button>
	</div>
	</div>
<hr>	
	<div id="costDivReqId" style="display: none">
	 <table class="table" >
		<thead class='thead-dark' align='center'>
			<tr>
				<th  width="40%" scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Drug/Item Name</th>				
				<th  width="15%" scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Available Qty</th>
				<th  width="15%" scope='col' style='font-weight:350 !important ;font-size: 16px !important;'>Rate</th>
				<th  width="15%" scope='col' style='font-weight:350 !important ;font-size: 16px !important;'><font color='red'>*</font>Req Qty </th>
				<th  width="15%" scope='col' style='font-weight:350 !important ;font-size: 16px !important;'><font color='red'>*</font>Unit </th>
			</tr>
		</thead>
	</table>
	</div>
	
	<div id="costDivNotReqId" style="display: none">
	<table class="TABLEWIDTH" align="center" cellpadding="1px" bgcolor='black'
		cellspacing="1px">
		<tr>
			<td width="30%" class="multiLabel">Item/Drug Name</td>

			<td width="12%" class="multiLabel">Available Qty</td>
			<!-- <td width="12%" class="multiLabel">Consumption Qty(Last Year)</td>
			<td width="8%" class="multiLabel">Last Purchase Detail</td> -->
			<td width="10%" class="multiLabel"><font size="2" color="red">*</font>Req
			Qty</td>
			<td width="14%" class="multiLabel"><font size="2" color="red">*</font>Unit
			</td>
		</tr>
	</table>
	</div>

	<div id="id1"></div>
	
	<div id="totalCostId" style="">
			<div id="strApproxAmtDivId" align="center"></div>
			<input type="hidden" name="strApproxAmt">
	</div>
	
	<div class="row my-1">
	<div class="col-sm-2" align="center"><label>Remarks</label></div>
	<div class="col-sm-10"><textarea name="strRemarks" class="form-control" id="strRemarks" cols="20"  rows="2" >LP Purchase Request</textarea></div>
	</div>
<hr>
	<div class="row ">
	    <div class="col-sm-10"></div>
	    <div class="col-sm-2" align="right"><i class="fa fa-asterisk" style="color: red;font-size: smaller;"></i>Fields Mandatory</div>				
    </div>

	<input type="hidden" name="hmode" />
	<input type="hidden" name="strStoreTypeId"
		value="${annualPurchaseIndent.strStoreTypeId}">
	<input type="hidden" name="strTmpStoreName"
		value="${annualPurchaseIndent.strTmpStoreName}">
	<input type="hidden" name="strTmpToStore"
		value="${annualPurchaseIndent.strTmpToStore}">
	<input type="hidden" name="strTmpItemCatg"
		value="${annualPurchaseIndent.strTmpItemCatg}">
	<input type="hidden" name="strTmpReqType"
		value="${annualPurchaseIndent.strTmpReqType}">
	<input type="hidden" name="strGoFlg"
		value="${annualPurchaseIndent.strGoFlg}">
	<input type="hidden" name="strPath"
		value="${annualPurchaseIndent.strPath}">
	<input type="hidden" name="strCostRequired"
		value="${annualPurchaseIndent.strCostRequired}">
		
	<input type="hidden" name="search" value='<%=request.getParameter("search") %>' />

    <input type="hidden" name="blockNo" value='<%=request.getParameter("blockNo") %>' />

    <input type="hidden" name="prevNext" value='<%=request.getParameter("prevNext") %>' />

    <input type="hidden" name="rowNum" value='<%=request.getParameter("rowNum") %>'/>

    <input type="hidden" name="divisionId" value='<%=request.getParameter("divisionId") %>' />

	<!-- <div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			<div id="searchItemsDtlsDivId" style="display: block;"></div>
			</td>
		</tr>
	</table>
	</div>
 -->
 
<div class='modal' id='tariffDtlsModal' tabindex='-1' role='dialog' aria-labelledby='tariffDtlsModalLabel' aria-hidden='true'>
	<div class='modal-dialog modal-lg'  role='document' style="max-width: 1000px;">
		<div class='modal-content animate-bottom'>
			<div class='modal-body' id=''>
                          <div id="searchItemsDtlsDivId" style="display:block;"></div>
			</div>
			<div class="modal-footer" style="padding: 0.5rem;">
		        <button type="button" class="btn btn-success" onkeypress='createSelectedList();'  onClick='createSelectedList();' data-dismiss="modal" style="padding: 0.175rem 0.75rem;">Ok</button>
		        <button type='button' class='btn btn-danger' data-dismiss='modal' style="padding: 0.175rem 0.75rem;">Cancel</button>
		    </div>
		</div>
	</div>
</div>

	<cmbPers:cmbPers />
	</div>
	</div>
</html:form>
<jsp:include page="requestforAnnualPurchaseIndent_itemSearchRow.jsp"></jsp:include>



			
</body>
</html>