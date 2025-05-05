<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers" %>


<html>
<head>
<meta charset=UTF-8">
<title>Rate Contract Details</title>

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

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
	
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../js/rate_contract_transBS.js"></script>
<script language="Javascript" src="../js/searchItems_utilBS.js"></script>

<style type="text/css">
.newhr{
    border-top: 3px solid rgb(6, 138, 255);
    margin-right: -16px;
	margin-left: -16px;
}
.custom-select[multiple], .custom-select[size]:not([size="1"]) {
    height: 220px;
}
 .legend3 {
  position: absolute;
  top: 0em;
  right: 40px;
  
  line-height:1.2em;   
}
.btn-info {
    padding: 0.2rem 0.5rem;
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
<script language="javaScript">

function getItemSelectPopup()
{
		var strModeVal 					= "2" ; 
		var strItemCategory 			= document.forms[0].strItemCategoryNo.value ;
		var strSupplierId   			= document.forms[0].strSupplierId.value ;  
		var strContractTypeId   		= document.forms[0].strContractTypeID.value ; 
		//alert("strItemCategory"+strItemCategory);
		//alert("strSupplierId"+strSupplierId);
		//alert("strContractTypeId"+strContractTypeId);
		var strRequestType				= "67";
		var strFromStoreId 				= "0";
		var strToStoreId  				= "0";
		
		var strMultiRowCompArray 		= new Array('itemParamValue','itemCalcValue','itemUserValue','strTenderItemNo','strRate','strUnitName','strRateContQty','strSecurityAmtPercent','strSecurityAmt');
		var strMultiRowCompTypeArray 	= new Array('t','t','t','t','t','s','t','t','t');
		// for mode val 2
		var strMultiRowFetchDataArray 	= new Array('1','0^strUnitName^invokeCheckQty');
		
		var testFunction                = "setQtyDetails";
		var arg                         = " ";  
		
		var userInfo = "0";
		var unitMode = "1";  // only base unit  1 Means Only Base Unit Show 0 Means All Unit Show in Unit Combo
		
		var layerIndex = "1";		
		var strUserInfo = strSupplierId+'@'+strContractTypeId; 	 //    Orignal Vale
	    //alert('1');
	    //searchItemsWithUserFunction ( strModeVal , strItemCategory , strRequestType, strFromStoreId, strMultiRowCompArray , strMultiRowCompTypeArray , strMultiRowFetchDataArray , layerIndex, testFunction,arg , userInfo , unitMode );
	    searchItems(strModeVal, strItemCategory, strRequestType, strFromStoreId, strMultiRowCompArray, strMultiRowCompTypeArray,strMultiRowFetchDataArray, layerIndex,strUserInfo);
}






</script>

</head>
<body onLoad="checkMsg();">  <!-- document.forms[0].strContractFromDate.focus(); -->
<html:form name="rateContractDtlBean" action="/transactions/RateContractDtlTransBSCNT" type="mms.transactions.controller.fb.RateContractDtlTransFB">
<fieldset form="form1">
		<div class="alert alert-danger  alert-dismissible fade show" id="errID" style="display: none;"><bean:write name="rateContractDtlBean" property="strErr" /></div>
		<div class="alert alert-success  alert-dismissible fade show" id="normalMsg" style="display: none;"><bean:write name="rateContractDtlBean" property="strMsg" /></div>
		<div class="alert alert-warning  alert-dismissible fade show" id="wrnID" style="display: none;"><bean:write name="rateContractDtlBean" property="strWarning" /></div>

<div class="container-fluid">
	<div class="prescriptionTile">
		<div class='legendHeader my-2' id='nonPrintableLegend' style="font-weight:600;font-size: 18px;" >Rate Contract Details</div>				
	  		<div class="legend2" id='nonPrintableLegend2'>
				<button type="button" 
					class="float-right btn btn-danger mt-1 btn-circle cancelbtn"
					onclick="cancel();" style="border-radius:50%;  padding:10px 12px" title="Cancel">
					<i class="fas fa-times iround" title="Cancel"></i>
				</button>
				<button type="button" class="float-right btn btn-secondary btn-circle"
					onclick="initPage();"
					style="border-radius:50%; padding:10px 9px; background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" title="Clear">
					<i class="fas fa-broom iround" title="Clear"></i>
				</button>
				<button type="button" id="savebutton"
					class="float-right btn btn-success mt-1 btn-circle"
					tabindex='2' onClick="return validate1();"
					name="requestForLpPatient"
					style="border-radius:50%;  padding:10px 11px">
					<i class="fa fa-download iround" title="Save"></i>
				</button>
			</div>
	
	<%-- <div class="row ">
	<div class="col-md-12" align="center">
      	<div class="errMsg" id="errMsg"><bean:write name="rateContractDtlBean" property="strErr" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write name="rateContractDtlBean" property="strWarning" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write name="rateContractDtlBean" property="strMsg" /></div>
	</div>
	</div> --%>
	
		
   <div class="row ">
	  <div class="col-sm-12">
	    <p class="subHeaders"><i class="fas fa-file-contract"  style="font-size: 18px;"></i>
	    &nbsp;Rate Contract >> ADD</p>
	  </div>
  </div>
	
	<div class="row my-1 my-1">
		<div class="col-sm-2"><label>Supplier Name</label></div>
		<div class="col-sm-2" style="font-weight: normal; "><bean:write name="rateContractDtlBean" property="strSupplierName" filter="false" /></div>
		<div class="col-sm-2"><label>Contract Type</label></div>
		<div class="col-sm-2" style="font-weight: normal; "><bean:write name="rateContractDtlBean" property="strContractType" filter="false" /></div>
		<div class="col-sm-2"><label>Item Category</label></div>
		<div class="col-sm-2" style="font-weight: normal; "><bean:write name="rateContractDtlBean" property="strItemCategoryName" filter="false" /></div>
	</div>
	<div class="row my-1">
		<div class="col-sm-8"><p class='subHeaders'><i class="fas fa-file-contract" style="font-size: 18px;"></i>&nbsp;&nbsp;Contract details</p></div>
		<div class="col-sm-2"><label>Contract Date</label></div>
		<div class="col-sm-2" style="font-weight: normal; "><bean:write name="rateContractDtlBean" property ="strCtDate" filter="false"/></div>
	</div>
<div class="container">
	<div class="row my-1">
		<div class="col-sm-3"><label><font  color="red">*</font>Delivery Day(s)</label></div>
		<div class="col-sm-3"><input type="text" class="form-control" name="strDeliveryDays" maxlength="3" value="${rateContractDtlBean.strDeliveryDays}" onkeypress="return validateData(event,5);"></div>
		<div class="col-sm-3"><label><font  color="red">*</font>Tender No.</label></div>
		<div class="col-sm-3"><input type="text" autocomplete='off' class="form-control" name="strTenderNo" maxlength="50" value="" onkeypress=""></div>
	</div>
	
	<div class="row my-1">
	<div class="col-sm-3"><label><font  color="red">*</font>Contract From</div>
	<div class="col-sm-3"><input class="form-control datepicker" name="strContractFromDate" value ="${rateContractDtlBean.strCtDate}"></div>
	<div class="col-sm-3"><label><font color="red">*</font>Contract To</label></div>
	<div class="col-sm-3"><input class="form-control datepicker" name="strContractToDate" value ="${rateContractDtlBean.strNtDate}"></div>
	</div>
	<div class="row my-1">
	<div class="col-sm-3"><label><font  color="red">*</font>Tender Date:</div>
	<div class="col-sm-3"><input class="form-control datepicker" name="strTenderDate"  id="strTenderDate"></div>
	<div class="col-sm-3"><label><font color="red">*</font>Quotation Date</label></div>
	<div class="col-sm-3"><input class="form-control datepicker" name="strQuotationDate" id="strQuotationDate"></div>
	</div>
	
	
	<div class="row my-1">
		<div class="col-sm-3"><label>Quotation No.</div>
		<div class="col-sm-3"><input type="text" autocomplete='off' class="form-control" name="strQuotationNo" maxlength="50" value="" onkeypress=""></div>
		<div class="col-sm-3"><label>Tax Type:</label></div>
		<div class="col-sm-3"><select name="strTaxType" class="browser-default custom-select"><option value="1">GST</option> </select>
		</div>
	</div>
</div>	
		<hr>
		<div class="row my-1">
		<div class="col-sm-12" align="right">
			<button type="button" class="btn btn-info" id='strSearchItemButtonDivId' data-toggle="modal" data-target="#tariffDtlsModal" onclick='getItemSelectPopup();'/><i class="fas fa-search"></i>&nbsp;ITEM FINDER</button>
		</div>
		</div>
		<hr>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th width="20%"  style="font-weight:350 !important ;font-size: 16px !important;">Item/Drug Name</th>
					<th width= "8%"  style="font-weight:350 !important ;font-size: 16px !important;">RC/Tender S.No.</th>
					<th width= "8%"  style="font-weight:350 !important ;font-size: 16px !important;"><font color="red">*</font>Rate/Unit</th>
					<th width= "8%"  style="font-weight:350 !important ;font-size: 16px !important;"><font color="red">*</font>Rate Unit</th>
					<th width= "8%"  style="font-weight:350 !important ;font-size: 16px !important;">Qty.</th>
					<th width= "8%"  style="font-weight:350 !important ;font-size: 16px !important;"><font color="red">*</font>Tax	</th>
					<th width= "8%"  style="font-weight:350 !important ;font-size: 16px !important;">Security Amt	</th>
					<th width= "5%"  style="font-weight:350 !important ;font-size: 16px !important; display: none !important;">Security Amt</th>
					<th width= "3%"  style="font-weight:350 !important ;font-size: 16px !important;"> Imported</th>
					<th width= "10%" style="font-weight:350 !important ;font-size: 16px !important;"><font color="red">*</font>Shelf Life</th>
					<th width= "10%" style="font-weight:350 !important ;font-size: 16px !important;"><font color="red">*</font>Level</th>
					<th width= "10%" style="font-weight:350 !important ;font-size: 16px !important;"><font color="red">*</font>Pack Size</th>
				</tr>
			</thead>
		</table>
		<div id="id1"></div>
<br>
	<div class="row my-1">
		<div class="col-sm-2"><label>Remarks</label></div>
		<div class="col-sm-10"><textarea  class="form-control" name="strRemarks" cols="25" rows="2" onkeypress="return validateData(event,9);"></textarea></div>
	</div>
<hr>
	<div class="row ">
        <div class="col-sm-10"></div>
        <div class="col-sm-2" align="right"><i class="fa fa-asterisk" style="color: red;font-size: smaller;"></i>Fields Mandatory</div>				
   </div>
<!-- 	<table border="0" class="TABLEWIDTH" align="center">
		<tr>

			<td align="center">
			<img style="cursor: pointer; "
src="../../hisglobal/images/btn-sv.png"
onClick=" return validate1();" title="Save Record"/> <img
style="cursor: pointer; " title="Clear Content"
src="../../hisglobal/images/btn-clr.png"
onClick="clearPage();" />
<img style="cursor: pointer; " title="Click Here Go Back To Main Desk" 
src="../../hisglobal/images/back_tab.png" onClick="cancel();" />
			
			</td>
		</tr>
	</table>-->
	
<input type="hidden" name="hmode"/>
<input type="hidden" name="ctDate" value="${rateContractDtlBean.strCtDate}"/>
<input type="hidden" name="strSupplierId" value="${rateContractDtlBean.strSupplierId}"/>
<input type="hidden" name="strSupplierName" value="${rateContractDtlBean.strSupplierName}"/>
<input type="hidden" name="strContractTypeID" value="${rateContractDtlBean.strContractTypeID}"/>
<input type="hidden" name="strContractType" value="${rateContractDtlBean.strContractType}"/>
<input type="hidden" name="strItemCategoryNo" value="${rateContractDtlBean.strItemCategoryNo}"/>
<input type="hidden" name="strItemCategoryName" value="${rateContractDtlBean.strItemCategoryName}"/>
<input type="hidden" name="strReOrderFlgColor" value="${rateContractDtlBean.strReOrderFlgColor}"/>

<!-- <div id="blanket" style="display:none;"></div> -->

<div class='modal' id='tariffDtlsModal' tabindex='-1' role='dialog' aria-labelledby='tariffDtlsModalLabel' aria-hidden='true'>
	<div class='modal-dialog modal-lg'  role='document' style="max-width: 1000px;">
		<div class='modal-content animate-bottom'>
			<div class='modal-body' id=''>
               <div id="searchItemsDtlsDivId" style="display:block;"></div>
			</div>
		<div class="modal-footer" style="padding: 0.5rem; display:flex;justify-content:center;">
	        <button type="button" class="btn btn-success" onkeypress='createSelectedList();'  onClick='createSelectedList();' data-dismiss="modal" style="padding: 0.175rem 0.75rem;">Ok</button>
	        <button type='button' class='btn btn-danger' data-dismiss='modal' style="padding: 0.175rem 0.75rem;">Cancel</button>
        </div>
		</div>
	</div>
</div>
			
<div class='modal' id='tariffDtlsModal1' tabindex='-1' role='dialog' aria-labelledby='tariffDtlsModalLabel' aria-hidden='true'>
	<div class='modal-dialog modal-lg'  role='document' style="max-width: 1000px;">
		<div class='modal-content animate-bottom'>
			<div class='modal-header'>
				<h4 class='modal-title'>Item Search For </h4>
				<button type='button' class='close' data-dismiss='modal'>×</button>
			</div>
			<div class='modal-body' id=''></div>
		</div>
	</div>
</div>

<cmbPers:cmbPers/>
</div>
</div>
</fieldset>

</html:form>
<jsp:include page="rate_contract_item_search_rowNew.jsp"></jsp:include>
<script type="text/javascript">
	
	$('.datepicker').each(function(){
	    $(this).datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
	});
	var today=new Date();
	var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
	var mmm=arr[today.getMonth()];
	var hrs=today.getHours();
	var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
	$('.datepicker').val(dd);
	</script>
</body>
</html>