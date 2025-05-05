<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>



<html>
<head>
<meta charset=UTF-8">
<title>Drug Inventory</title>

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css"
	rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css"
	rel="stylesheet" type="text/css">

<link
	href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css"
	rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css"
	rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet"
	type="text/css">
	
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/swAl/swal.js"></script>
<script type="text/javascript"
	src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datatable/js/dataTables.bootstrap4.js"></script>
<script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>


<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet"
	type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet"
	type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="JavaScript" src="../../hisglobal/js/util.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>

<script language="JavaScript" src="../js/giftedItemDetailsNEW.js"></script>

<script language="JavaScript" src="../js/item_OtherDtls_utilNEW.js"></script>
	
<style>
.gj-textbox-md
{
border:1px solid #ced4da;
padding: 0.375rem 0.75rem;
font-weight: 400;
border-radius: 0.25rem;
border-bottom: 1px solid #ced4da;
display: block;
font-family: Helvetica,Arial,sans-serif;
font-size: 14px;
line-height: 16px;
padding: 8px inherit;
margin: 0;
width: 100%;
background: 0 0;
text-align: left;
}

.gj-datepicker-md [role="right-icon"] {
position: absolute;
right: 7px;
top: 7px;
font-size: 24px;
}
.gj-picker-md, ul.gj-list-md li {
    font-family: Roboto, Helvetica, Arial, sans-serif;
    font-size: 16px;
    font-weight: 400;
    letter-spacing: .04em;
    line-height: 0;
}
.gj-picker-md.datepicker [role="header"] [role="year"] {
    font-size: 17px;
    padding-bottom: 16px;
    cursor: pointer;
}
.gj-picker-md.datepicker [role="header"] [role="date"] {
    font-size: 22px;
    cursor: pointer;
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

<body>
<html:form name="giftedItemDetailsTransBean"
	action="/transactions/GiftedItemDetailsTransCNTNEW"
	type="mms.transactions.controller.fb.GiftedItemDetailsTransFB">

<div class="viewport" id="nonPrintable">

							<div class="errMsg" id="errMsg"><bean:write
		name="giftedItemDetailsTransBean" property="strErrMsg" /></div>
	<div class="warningMsg" id="warningMsg"><bean:write
		name="giftedItemDetailsTransBean" property="strWarningMsg" /></div>
	<div class="normalMsg" id="normalMsg"><bean:write
		name="giftedItemDetailsTransBean" property="strNormalMsg" /></div>

			<div class="container-fluid">
						<div class="prescriptionTile">	

							<div class="row rowFlex reFlex">
								<div class="legend2" id='nonPrintableLegend2'>
								
									<button type="button"
										class="float-right btn btn-danger cancelbtn mt-1"
										onclick="cancelViewPage();" style="border-radius:50%; padding:11px 11px;">
										<i class="fas fa-times fa-lg " title="Cancel"></i>
									</button>
									
									<button type="button" class="float-right btn btn-secondary my-1" onclick="pageResetMethod();" style="border-radius:50%; background: royalblue;padding:11px 9px;">
									<i class="fas fa-broom" title="Clear"></i>
									<!-- <img src="/HIS/hisglobal/images/clear3.png" title="Clear"
										style="width: 23px; color: #fff;"> -->
									</button>
									
									<button type="button" id="submitId" onclick='validate1("DRUG");'
										class="float-right btn btn-success mt-1 btn-circle"
										tabindex='2'
										name=""
										style="background-color: #5cb85c; border-radius:50%; padding:11px 11px;">
										<i class="fa fa-download iround" title="Save"></i>
									</button>	
							
								</div>
							</div>

							<div class="row rowFlex reFlex mt-2" >
									<div class="col-sm-5" style="font-weight: 600;font-size:large">
										<i class="fas fa-hand-holding-usd fa-lg"></i><span class="subHeaders">&nbsp;Gifted Drug Details
										</span>
									</div>
							</div>
 
<div class="row rowFlex reFlex my-1">
	<div class="col-md-2 ">Store Name</div>
	<div class="col-md-2" style="font-weight:10;color:rgba(75, 75, 75, 0.7);word-wrap:break-word;"><bean:write
				name="giftedItemDetailsTransBean" property="strStoreName"
				filter="false" /></div>
				
	<div class="col-md-2">Category Name</div>
	<div class="col-md-2" style="font-weight:10;color:rgba(75, 75, 75, 0.7);word-wrap:break-word;"><bean:write
				name="giftedItemDetailsTransBean" property="strItemCategoryName"
				filter="false" /></div>
				
	<div class="col-md-2">Gifted By</div>
	<div class="col-md-2" style="font-weight:10;color:rgba(75, 75, 75, 0.7);word-wrap:break-word;"><bean:write
				name="giftedItemDetailsTransBean" property="strGiftedBy"
				filter="false" /></div>
</div>

<div class="row rowFlex reFlex my-1">
	<div class="col-md-2 ">Address</div>
	<div class="col-md-2" style="font-weight:10;color:rgba(75, 75, 75, 0.7);word-wrap:break-word;"><bean:write
				name="giftedItemDetailsTransBean" property="strAddress"
				filter="false" /></div>
	<div class="col-md-2">Remarks</div>
	<div class="col-md-6" style="font-weight:10;color:rgba(75, 75, 75, 0.7);word-wrap:break-word;"><bean:write
				name="giftedItemDetailsTransBean" property="strRemarks"
				filter="false" /></div>
</div>
<hr>

<div class="container">
<div class="row rowFlex reFlex my-1">
	<div class="col-md-2 ">Group Name</div>
	<div class="col-md-2"><select name="strGroupId"
				onchange="getSubGroupListDtls(this);" class="browser-default custom-select">
				<bean:write name="giftedItemDetailsTransBean"
					property="strGroupCombo" filter="false" />
			</select></div>
	<div class="col-md-2">Sub Group Name</div>
	<div class="col-md-2"><div id="subGroupComboDivID"><select name="strSubGroupId"
				class="browser-default custom-select" onChange="ajaxItemName('ITEMNAME');">
				<option value="0">All</option>
			</select></div></div>
	<div class="col-md-2"><font color="red">*</font>Generic	Item Name</div>
	<div class="col-md-2"><div id="ItemNameId"><select name="strItemId"
				class='browser-default custom-select' onChange="ajaxItemBrandName('ITEMBRANDNAME')">
				<option value="0">Select Value</option>
			</select></div></div>
</div>
		
<div class="row rowFlex reFlex my-1">
	<div class="col-md-2 "><font color="red">*</font>Item Name</div>
	<div class="col-md-2"><div id="ItemBrandId"><select name="strItemBrandId" class='browser-default custom-select'>
				<option value="0">Select Value</option>
			</select></div></div>
			
	<div class="col-md-2"><font color="red">*</font>Stock Status</div>
	<div class="col-md-2"><div id="stockStatusComboDivId">
				<select name="strStockStatus" class="browser-default custom-select">
					<bean:write name="giftedItemDetailsTransBean" property="strStockStatusValues" filter="false" />
				</select>
			</div></div>
			
	<div class="col-md-2"><div id="manfNotMandatoryDivId" style="display: none;">Manufacture</div>
			<div id="manfMandatoryDivId" style="display: block;"><font color="red">*</font>Manufacture</div></div>
	<div class="col-md-2"><div id="manufDivId"><select class="browser-default custom-select"
				name="strManufactureId">
				<option value='0'>Select Value</option>
			</select></div></div>
</div>

<div class="row rowFlex reFlex my-1">
	<div class="col-md-2 "><div id="batchNoDivId">Batch No.</div>
			<input type="hidden" name="isBatchReq" value="0"></div>
	<div class="col-md-2"><input type="text"
				name="strBatchNo" maxlength="30" class="form-control"
				onkeypress="return validateData(event,17);" /></div>
	<div class="col-md-2"><div id="expiryDateDivId">Expiry Date</div>
			<input type="hidden" name="isExpirtReq" value="0"></div>
	<div class="col-md-2"><input  name="strExpiryDate"
											class="datepicker form-control"
											value="${giftedItemDetailsTransBean.strCtDate}"
											style="color: rgba(113, 111, 111, 0.87);">
											</div>
	<div class="col-md-2">Manufacture Date</div>
	<div class="col-md-2"><input  name="strManufactureDate"
											class="datepicker form-control"
											value="${giftedItemDetailsTransBean.strCtDate}"
											style="color: rgba(113, 111, 111, 0.87);"></div>
</div>


<div class="row rowFlex reFlex my-1">
	<div class="col-md-2 "><font color="red">*</font>Gifted Quantity</div>
	<div class="col-md-2"><input type="text"
				name="strInHandQuantity" maxlength="8" class="form-control"
				onkeypress="return validateData(event,5);" value="1" /></div>
	<div class="col-md-2"><font color="red">*</font>Gifted Quantity Unit</div>
	<div class="col-md-2"><div id="freeItemUnit"><input type="text" value="No." disabled="disabled" name="strInHandQuantityUnitID"
				class='form-control' value="6301">
				
			</div>
											</div>
	<div class="col-md-2">Rack No</div>
	<div class="col-md-2"><input type="text"
				name="strRackNumber"  class="form-control"
				
				onkeypress="return validateData(event,3);" /></div>
</div>

<div class="row rowFlex reFlex my-1">
	<div class="col-md-2 "><font color="red">*</font>PO No.</div>
	<div class="col-md-2"><input type="text"
				name="strPONumber"  class="form-control"
				onkeypress="return validateData(event,3);" /></div>
	<div class="col-md-2"><div id="specNotMandatoryDivId" style="display: none;">Specification</div>
	<div id="specMandatoryDivId" style="display: block;"><font color="red">*</font>Specification</div></div>
	<div class="col-md-6"><textarea class="form-control" rows="2" cols="40" name="strItemSpecification" style="height:38px;" ></textarea></div>
</div>

</div>
<br>	
<div class="row rowFlex reFlex my-1">
				<div class="col-md-12"><i class="fas fa-tags" style="size:4x;"></i>&nbsp;Rate Details</div>
</div>
<hr>	

<div class="container">
<div class="row rowFlex reFlex my-1">
	<div class="col-md-2 ">Currency Code</div>
	<div class="col-md-2"><select name="strCurrencyCode"
				class="browser-default custom-select" onchange="isCurrencyMandatory(this);">
				<bean:write name="giftedItemDetailsTransBean"
					property="strCurrencyCodeValues" filter="false" />
			</select></div>
			
	<div class="col-md-2"><div id="currencyDivId">Currency Value</div>
			<input type="hidden" name="isCurrencyReq" value="0"></div>
			
	<div class="col-md-2"><input type="text"
				name="strCurrencyValue" maxlength="8" class="form-control" value="1"
				disabled="disabled" onkeypress="return validateData(event,7);" />
											</div>
	<div class="col-md-2"><font color="red">*</font>Purchase Rate/Unit</div>
	<div class="col-md-2"><input type="text"
				name="strRate" maxlength="12" class="form-control"
				onkeypress="return(numericWithTwoDecimalPlaces(this,',','.',event))" onBlur="calcIssueRate();" /></div>
</div>
		
	
<div class="row rowFlex reFlex my-1">
	<div class="col-md-2"><font color="red">*</font>Unit
			Name</div>
	<div class="col-md-2"><div id="UnitRateID"><input type="text" value="No." disabled="disabled" name="strUnitRateID"
				class='form-control' value="6301">
				</div></div>
	<div class="col-md-2"><font color="red">*</font>Cost To Patient</div>
	<div class="col-md-2"><input type="text"
				name="strSalePrice" maxlength="14" class="form-control"
				onkeypress="return validateData(event,7);" />
											</div>
	<div class="col-md-2"><font color="red">*</font>Unit
			Name</div>
	<div class="col-md-2"><div id="UnitRateID1"><input type="text" value="No." disabled="disabled" name="strUnitSaleID"
				class='form-control' value="6301">
				</div></div>
</div>


<div class="row rowFlex reFlex my-1">
	<div class="col-md-2 "><font color="red">*</font>Received
			Date</div>
	<div class="col-md-2"><input disabled="disabled" name="strReceivedDate"
											class="form-control datepicker"
											value="${giftedItemDetailsTransBean.strCtDate}"
											style="color: rgba(113, 111, 111, 0.87);"></div>
	<div class="col-md-2"><font color="red">*</font>Supplied
			By</div>
	<div class="col-md-2"><select name="strSuppliedBy"
				class="browser-default custom-select">
				<bean:write name="giftedItemDetailsTransBean"
					property="strSuppliedByValues" filter="false" />
			</select>
	</div>
</div>
</div>

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

<div class="row rowFlex reFlex">
			<div class="col-md-4 px-3">
			<div id="freeItemDtlsDivIdPlusId" align="left"
				style="display: block;"><i class="fas fa-plus-circle" onClick="showView('freeItemDtlsDivId');" style="cursor: pointer; "></i>&nbsp;Free Items</div>
			<div id="freeItemDtlsDivIdMinusId" style="display: none;"
				align="left"><i class="fas fa-minus-circle" onClick="hideView('freeItemDtlsDivId');" style="cursor: pointer; "></i>&nbsp;Free Items</div>
			</div>
</div>
	<!-- <table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr>
			<td colspan="4" class="TITLE" width="25%">
			<div id="freeItemDtlsDivIdPlusId" align="left"
				style="display: block;color:blue;"><img
				src="../../hisglobal/images/plus.gif"
				
				style="cursor: pointer; " /> Free Items</div>
			<div id="freeItemDtlsDivIdMinusId" style="display: none;color:blue;"
				align="left"><img src="../../hisglobal/images/minus.gif"
				
				style="cursor: pointer; " /> Free Items</div>
			</td>
		</tr>
	</table> -->



	<div id="freeItemDtlsDivId" style="display: none">
	
	<!-- <div class="row" style="border-bottom:1px solid #ced4da;">
		<div class="col-md-3 px-4"></div>
		<div class="col-md-3"></div>
		<div class="col-md-3"></div>
		<div class="col-md-2"></div>
		<div class="col-md-1"></div>
	</div> -->
	<table class="table">
		<tr style="border-bottom:1px solid #ced4da;border-top:1px solid #ced4da; background-color:#ced4da; font-weight:bold;">
			<td  scope="col" style="font-weight:350 !important ;font-size: 16px !important;">Item Name</td>
			<td  scope="col" style="font-weight:350 !important ;font-size: 16px !important;">Batch No.</td>
			<td  scope="col" style="font-weight:350 !important ;font-size: 16px !important;">Expiry Date</td>
			<td  scope="col" style="font-weight:350 !important ;font-size: 16px !important;">Qty.</td>
			<td >
			<button type="button" class="float-right btn btn-outline-info mt-1" title="Add" onclick="addFreeItems();" style="padding: .175rem .35rem; line-height: 0.8">
				<i class="fas fa-plus-square"></i>
			</button></td>
		</tr>
	</table>
	
 <div id="id1"></div>
</div>
	<!-- <table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr>
			<td colspan="4" class="TITLE" width="25%"></td>
		</tr>

		<tr> -->
<!-- 
			<td align="center">
			<img style="cursor: pointer; " src="../../hisglobal/images/btn-add.png" onClick="addFreeItems();" />
			<a href="#" class="button"	><span class="add">Add</span></a> 
			</td>
		</tr> -->

<!-- 	</table>

	</div>
 -->
<hr>
<div class="row">
	<div class="col-md-12" align="right"><font size="2" color="red">*</font>
			Fields Mandatory</div>
</div>
	
	<!-- <table class="TABLEWIDTH" align="center" border="0" cellpadding="1px"
		cellspacing="1px">
		<tr>

			<td align="center"><img style="cursor: pointer; "
				src="../../hisglobal/images/btn-sv.png" TITLE='Click Here To Save Data' onClick="validate1('DRUG');" />
			<img style="cursor: pointer; "
				src="../../hisglobal/images/btn-clr.png" TITLE='Click Here To Clear Content'
				onClick="pageResetMethod();" /> <img
				style="cursor: pointer; " TITLE='Click Here To Come Back on Main Page'
				src="../../hisglobal/images/btn-ccl.png"
				 onClick="cancelViewPage();" />
				 
				 <br>
				 	
				 </td>
		</tr>
	</table>
 -->
	<input type="hidden" name="strStoreId"
		value="${giftedItemDetailsTransBean.strStoreId}" />
	
	<input type="hidden" name="strItemCategoryNo"
		value="${giftedItemDetailsTransBean.strItemCategoryNo}" />

	<input type="hidden" name="strGiftedBy"
			value="${giftedItemDetailsTransBean.strGiftedBy}" />
	
	<input type="hidden" name="strAddress"
			value="${giftedItemDetailsTransBean.strAddress}" />
	
	<input type="hidden" name="strRemarks"
			value="${giftedItemDetailsTransBean.strRemarks}" />


	<input type="hidden" name="strCtDate"
		value="${giftedItemDetailsTransBean.strCtDate}">

	<input type="hidden" name="strDefaultCurrencyCode"
		value="${giftedItemDetailsTransBean.strDefaultCurrencyCode}">

<input type="hidden" name="strRegFlag" value="" />
<input type="hidden"  name="strConfigIssueRate"  value="${giftedItemDetailsTransBean.strConfigIssueRate}">
<input type="hidden"  name="strIssueRateConfigFlg"  value="${giftedItemDetailsTransBean.strIssueRateConfigFlg}">

	<input type="hidden" name="hmode" />



	<div id="blanket" style="display: none;"></div>
	<div class="popUpDiv" id="otherDtlspopUpDiv" style="display: none;">
	<table bgcolor="white">
		<tr>
			<td>
			<div id="itemsOtherDtlsDivId" style="display: block;"></div>
			</td>
		</tr>
	</table>
	</div>

	<cmbPers:cmbPers />
	</div>
	</div>
	</div>
	</div>
	</div>
</html:form>

<jsp:include page="drugInventory_multirow_mmstransNEW.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>  


</body>
</html>








