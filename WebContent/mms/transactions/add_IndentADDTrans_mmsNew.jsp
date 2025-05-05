<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>
<!-- 
/**
 * @author Amit Kumar
 * Date of Creation : 31/3/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
 -->
<html>
<head>
<meta charset=UTF-8">
<title>Indent For Issue</title>
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

<script language="JavaScript" src="../js/IndentTransADD.js"></script>
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
	text-align: center;	
	padding: 0.25rem;
	
}
</style>
<script type="text/javascript">

	function clearItemDiv()
	{
	 var itemParaObj = document.getElementById("id1");
          itemParaObj.innerHTML = ""; 	
	}
	
	function getItemSelectPopup()
	{
		
	     setItemDtlWithIssueQty();
	     var issueStore = document.forms[0].strToStoreCombo.value;
	     if(issueStore!=0)
	        {
		    var strModeVal 		= "1" ; 
	        var strItemCategory = document.forms[0].strItemCatNo.value ;
	        var strRequestType 	= document.forms[0].strIndentTypeId.value;
	        var strFromStoreId 	= document.forms[0].strStoreId.value;
	        var strUserInfo 	= document.forms[0].strToStoreCombo.value;
			// alert('strUserInfo'+strUserInfo);
		    var strMultiRowCompArray     = new Array('itemParamValue','itemCalcValue','itemUserValue','strReqQty','strUnitName','strCost');
	
	        var strMultiRowCompTypeArray = new Array('t','t','t','t','s');
	
	            // for mode val 1
	             
	     //   var strMultiRowFetchDataArray  = new Array('1','4','8','9','0^strUnitName^invokeCheckQty');
	        var strMultiRowFetchDataArray  = new Array('1','66','4','0^strUnitName^invokeCheckQty');
	
			var layerIndex = "1";
			document.getElementById("strToStoreCombo").disabled=true;
			searchItems( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex , strUserInfo);
		    //searchItems( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex);
		 }
		 else
		 {
		   alert("Please Select Issuing Store Name");
		   return false;
		 }
			  
			    
	}		

    function invokeCheckQty(mode, index, unitObject)
	{ 
		       
		        // Pass '0' If User Dont Want to Compare Req Qty with Avalaible Quantity 
		        
		 		calculateCost(mode, 'strReqQty', 'strUnitName', 'strCost', index , 'strApproxAmt','0');
		 
			
	}	
	
	function changeUnitCmb(obj,index)
	{	    
       	document.getElementById("strCostDivId" + index).innerHTML = "0.00";
       	document.getElementById("strCost" + index).value = "0";
 
        calculateCost('1', 'strReqQty', 'strUnitName', 'strCost', index , 'strApproxAmt','0');  	
       	
	}
	
	
function setItemDtlWithIssueQty(){
	
		var itemWithIssueQty = document.getElementById("strItemDtlWithIssueQty");
		var  itemUserVal    = document.getElementsByName("itemUserValue");
	    //var issueQty    = document.getElementsByName("strIssueQty");
  		var reqQty      = document.getElementsByName("strReqQty");
  		var unitNameCmb = document.getElementsByName("strUnitName");
  		//var costObj     = document.getElementsByName("strCost");
		  
				
			if(itemUserVal.length > 1)
			{
				
				var tempIssueDtls ; 
				
				for(var i = 0 ; i < itemUserVal.length - 1 ; i++)
				{

															
					if(i == 0 )
					{
						
						tempIssueDtls = itemUserVal[i].value+"@@@@"+reqQty[i].value+"@@@@"+unitNameCmb[i].value;	
						
					}
					else
					{
					
						tempIssueDtls = tempIssueDtls+"$$$$"+itemUserVal[i].value+"@@@@"+reqQty[i].value+"@@@@"+unitNameCmb[i].value;
					
					}
				
				}
				
				itemWithIssueQty.value = tempIssueDtls;
				
				
			}else{
				itemWithIssueQty.value = "";
					
			}
				
		
	
	}


function hideBalQtyDetails(divId) {
	hide_popup_menu(divId);
}

</script>

</head>

<body>

<html:form action="/transactions/IndentTransADDBSCNT.cnt"
	name="indentTransADDBean"
	type="mms.transactions.controller.fb.IndentTransADDFB" method="post">

	<div class="errMsg" id="errMsg" style="font-size:16px"><bean:write
		name="indentTransADDBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg" style="font-size:16px"><bean:write
		name="indentTransADDBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg" style="font-size:16px"><bean:write
		name="indentTransADDBean" property="strMsg" /></div>

<%-- Change Request --%>

<%-- <div class="alert alert-danger  alert-dismissible fade show" id="errID" style="display: none;"><bean:write name="rateContractDtlBean" property="strErr" /></div>
	<div class="alert alert-success  alert-dismissible fade show" id="normalMsg" style="display: none;"><bean:write name="rateContractDtlBean" property="strMsg" /></div>
	<div class="alert alert-warning  alert-dismissible fade show" id="wrnID" style="display: none;"><bean:write name="rateContractDtlBean" property="strWarning" /></div>
--%>	
<div class="container-fluid">
	<div class="prescriptionTile">	
	<fieldset>					
		<legend class="legendHeader" id='nonPrintableLegend'>Indent For Issue</legend>

		<div class="legend2" id='saveId'>
			<button type="button" class="float-right btn btn-danger mt-1 btn-circle" style="border-radius:50%; padding:12px;" onclick="cancel('CANCEL');">
				<i class="fas fa-times fa-lg iround" title="Cancel"></i>
			</button>
			<button type="button" class="float-right  btn btn-secondary btn-circle" style="border-radius:50%; padding:12px 11px; background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" onclick="initPage();">
				<i class="fas fa-broom iround" title="Clear"></i>
			</button>
			<button type="button" id="savebutton" class="float-right btn btn-success mt-1 btn-circle savebtn" name="requestForLpPatient" tabindex='2'style="border-radius:50%; padding:12px;" id="submitId" onclick='return validate1();'>
				<i class="fa fa-download fa-beat iround" title="Save"></i>
			</button>
		</div>
	
		<div class='popup' id='avalaibleBudgetDtlId' style="display: none">
			<table width='400' border="0" cellspacing="1" cellpadding="1">
				<tr class="HEADER">
					<td colspan='3'>Budget Details</td>
		
					<th align='right'><img style='cursor: pointer; '
				src='../../hisglobal/images/popUp_cancel.JPG' title='Click to Close Pop-Up'
				onClick="hideBalQtyDetails('avalaibleBudgetDtlId');"></th>
				</tr>
			</table>
		
		
			<table width='400' border="0" cellspacing="1" cellpadding="1">
				<tr>
					<td colspan="1" class='multiLabel'>Budget Allocated</td>
					<td colspan="1" class='multiLabel'>Budget Consumed</td>
				</tr>
				<tr>
					<td colspan="1" class='multiControl'>
						<div id='1'></div>
					</td>
					<td colspan="1" class='multiControl'>
						<div id='2'></div>
					</td>
				</tr>
			</table>
		</div>
<%-- Change Request End --%>
	<div class="container">
	   <div class="row my-1">
		  <div class="col-sm-2">Store Name:<font color="red">*</font></div>
		  <div class="col-sm-4"><bean:write name="indentTransADDBean" property="strStoreNameFunc" filter="false" /></div>
		  <div class="col-sm-2">Indent Date:</div>
		  <div class="col-sm-4"><bean:write name="indentTransADDBean" property="strIndentDate" filter="false" /></div>
	   </div>

	   <div class="row my-1">
		 <div class="col-sm-2 "><label>Indent Type:</label></div>
		 <div class="col-sm-4"><bean:write name="indentTransADDBean" property="strIndentTypeFunc" filter="false" /></div>
		 <div class="col-sm-2">Item Category:</div>
		 <div class="col-sm-4"><bean:write name="indentTransADDBean" property="strItemCategoryFunc" filter="false" /></div>
	   </div>
	
	    <div class="row my-1">
		 <div class="col-sm-2 "><label>Indent Status:<font color="red">*</font></label></div>
		 <div class="col-sm-4"><input type="radio" name=isNormal value="1" checked="checked" />Normal&nbsp;&nbsp;<input type="radio" name="isNormal" value="0" />External/Urgent</div>
		 <div class="col-sm-2">Issuing Store:<font color="red">*</font></div>
		 <div class="col-sm-4"><select class='browser-default custom-select' id="strToStoreCombo" name='strToStoreCombo' onChange="clearItemDiv();"> <bean:write name="indentTransADDBean" property="strToStoreCombo" filter="false" /></select></div>
	    </div>
	    
	    <div class="row my-1">
		 <div class="col-sm-2 "><label>Indent Period:<font color="red" size="2" >*</font></label></div>
		 <div class="col-sm-2"><select class='browser-default custom-select' name='strIndentPeriod'> <bean:write name="indentTransADDBean" property="strIndentPeriodCombo" filter="false" /></select></div>
		 <div class="col-sm-8"></div>
	    </div>
	   </div>
	    
	<%--
	  <table class="TABLEWIDTH" align="center" cellspacing="1px">
 	  	 <logic:present name="indentTransADDBean" property="strAvalaibleBudget" >
			<tr>
				<td class="LABEL"  colspan="1">Budget Available</td>
				<td class="CONTROL" colspan="3">
	       	    	<a STYLE='cursor:pointer;cursor:pointer;color:blue'  onClick='avlBudgetDtl(this);' TITLE='Click Here Get Budget Details' ><bean:write name="indentTransADDBean" property="strAvalaibleBudget" /></a>
				</td>
			</tr>			
		</logic:present>
	  </table> 
		<hr>
		--%>
	<div class="row">
		<div class="col" align="right">
			<button type="button" class="btn btn-info" id='strSearchItemButtonDivId' data-toggle="modal" data-target="#tariffDtlsModal" onclick='getItemSelectPopup();'/><i class="fas fa-search"></i></button>
		</div>
	</div>
<hr>
	 <table class="table" >
		<thead class='thead-dark' align='center'>
			<tr>
				<th  scope='col'width="40%" style='font-weight:350 !important ;font-size: 16px !important;'>Drug/Item Name</th>
				<!--<th width="20%" class="multiLabel"><font size="2" color="aqua">*</font>Rate/Unit</th>  -->
				<th  scope='col' width="15%" style='font-weight:350 !important ;font-size: 16px !important;'>Item Type</th>
				<th  scope='col' width="15%" style='font-weight:350 !important ;font-size: 16px !important;'>Available Qty</th>
				<th  scope='col' width="15%" style='font-weight:350 !important ;font-size: 16px !important;'>Req Qty</th>
				<th  scope='col' width="15%" style='font-weight:350 !important ;font-size: 16px !important;'><font color='red'>*</font>Unit</th>
			</tr>
		</thead>
	</table>
	
	<div id="id1" style='display:none;'></div>
	<div id="strApproxAmtDivId" style='display:none;' align="center">0.00</div>
		
	<div class="row">
		<div class="col-sm-2" align='center'><label>Remarks<font color="red" size="2" >*</font></label></div>
		<div class="col-sm-10"><textarea name="strRemarks" class="form-control" cols="20"  rows="2" id="strRemarks"  value="Indent Generation"></textarea></div>
	</div>
	
	

<hr>
	<div class="row rowFlex reFlex">
					        <div class="col-sm-10"></div>
					              <div class="col-sm-2" align="right"><i class="fa fa-asterisk" style="color: red;font-size: smaller;"></i>Fields Mandatory</div>				
				           </div>

					
	<input type="hidden" name="hmode" />

	<!-- <div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="popUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			     <div id="searchItemsDtlsDivId" style="display: block;"></div>
			     <div id="indentCreateDivId" style="display:block;"></div>
			</td>
		</tr>
	</table>
	</div> -->

	<input type="hidden" name="strStoreName"  value="${indentTransADDBean.strStoreName}">
	<input type="hidden" name="strReOrderFlgColor"  value="LIGHTPINK">
	<input type="hidden" name="strStoreId"
		value="${indentTransADDBean.strStoreId}">
	<input type="hidden" name="strStoreTypeId"
		value="${indentTransADDBean.strStoreTypeId}">
	<input type="hidden" name="strItemCatNo"
		value="${indentTransADDBean.strItemCatNo}">
	<input type="hidden" name="strIndentTypeId"
		value="${indentTransADDBean.strIndentTypeId}">
	<input type="hidden" name="strPath"
		value="${indentTransADDBean.strPath}">
	<input type="hidden" name="strCostRequired"
		value="${indentTransADDBean.strCostRequired}">
	<input type="hidden" name="indentNo" value="${indentTransADDBean.strIndentNo}">
	<input type="hidden" name="strAvalaibleBudgetDtl" value="${indentTransADDBean.strAvalaibleBudgetDtl}">
	<input type="hidden" name="strAvalaibleBudget" value="${indentTransADDBean.strAvalaibleBudget}">
	<input type="hidden" name="strRemainingBudget" value="${indentTransADDBean.strRemainingBudget}">
	<input type="hidden" name="search" value='<%=request.getParameter("search") %>' />
    <input type="hidden" name="blockNo" value='<%=request.getParameter("blockNo") %>' />
    <input type="hidden" name="prevNext" value='<%=request.getParameter("prevNext") %>' />
    <input type="hidden" name="rowNum" value='<%=request.getParameter("rowNum") %>'/>
    <input type="hidden" name="divisionId" value='<%=request.getParameter("divisionId") %>' />
    <input type="hidden" name="strItemDtlWithIssueQty" id="strItemDtlWithIssueQty" value="0"/>
		
	<div class='modal' id='tariffDtlsModal' tabindex='-1' role='dialog' aria-labelledby='tariffDtlsModalLabel' aria-hidden='true'>
		<div class='modal-dialog modal-lg'  role='document' style="max-width: 1000px;">
			<div class='modal-content animate-bottom'>
				<div class='modal-body' id=''>
                   <div id="searchItemsDtlsDivId" style="display:block;"></div>
				</div>
				<div class="modal-footer" style="padding: 0.5rem;display:flex; justify-content:center; ">
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
<jsp:include page="insertItemAdd_itemSearchRow.jsp"></jsp:include>



</body>
</html>