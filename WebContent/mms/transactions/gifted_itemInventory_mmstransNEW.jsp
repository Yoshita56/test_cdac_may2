<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>



<html>
<head>
<meta charset=UTF-8">
<title>Item Inventory</title>

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css"	rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css"	rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css"	rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css"	rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css"	rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/css/newlayout.css" rel="stylesheet" 	type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
	
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
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" 
type="text/css">

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

<script language="Javascript" src="../js/itemparameterdetails_utilNEW.js"></script>

	
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
</style>


</head>

<body>
<html:form name="giftedItemDetailsTransBean"
	action="/transactions/GiftedItemDetailsTransCNTNEW"
	type="mms.transactions.controller.fb.GiftedItemDetailsTransFB">

<div class="viewport" id="nonPrintable">
			<div class="container-fluid">

				 
			<div class="row justify-content-center">
					<div class="col-sm-12">
						<br>
						<div class="prescriptionTile">
							<div class="row rowFlex reFlex">
								<div class="col-md-12" align="center">
									<div class="errMsg" id="errMsg">
										<bean:write name="giftedItemDetailsTransBean"
											property="strErrMsg" />
									</div>
									<div class="warningMsg" id="warningMsg">
										<bean:write name="giftedItemDetailsTransBean"
											property="strWarningMsg" />
									</div>
									<div class="normalMsg" id="normalMsg">
										<bean:write name="giftedItemDetailsTransBean"
											property="strNormalMsg" />
									</div>
								</div>
							</div>



							<div class="row rowFlex reFlex">
								<div class="legend2" id='nonPrintableLegend2'>
									<button type="button"
										class="float-right btn btn-outline-danger mt-1 btn-circle cancelbtn"
										onclick="cancelViewPage();">
										<i class="fas fa-times iround" title="Cancel"></i>
									</button>
									<button type="button" class=" btn btn-secondary btn-circle"
										onclick="document.forms[0].reset()"
										style="background: royalblue; border-color: #b9b9b9; margin-top: 0.25rem !important;">
										<i class="fas fa-broom iround" title="Clear"></i>
									</button>
									<button type="button" id="submitId" onclick=" validate1('ITEM');"
										class="float-right btn btn-outline-success mt-1 btn-circle"
										tabindex='2'
										name=""
										style="background-color: #5cb85c;">
										<i class="fa fa-download iround" title="Save"></i>
									</button>	
									
								</div>
							</div>

					<div class="row rowFlex reFlex">
								<div class="col-sm-5" style="font-weight: 600; font-size:large">
									<p class="subHeaders">
											<i class="fas fa-hand-holding-usd fa-lg"></i>
										&nbsp;Gifted Item Details
									</p>
					</div></div>

					<div class="row rowFlex reFlex">
						<div class="col-md-2 px-4">Store Name</div>
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

					<div class="row rowFlex reFlex">
						<div class="col-md-2 px-4">Address</div>
						<div class="col-md-2" style="font-weight:10;color:rgba(75, 75, 75, 0.7);word-wrap:break-word;"><bean:write
									name="giftedItemDetailsTransBean" property="strAddress"
									filter="false" /></div>
						<div class="col-md-2">Remarks</div>
						<div class="col-md-6" style="font-weight:10;color:rgba(75, 75, 75, 0.7);word-wrap:break-word;"><bean:write
									name="giftedItemDetailsTransBean" property="strRemarks"
									filter="false" /></div>
						
					</div>
<br>
	<div class="row rowFlex reFlex">
		<div class="col-md-2 px-4">Group Name</div>
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
		

	<div class="row rowFlex reFlex">
		<div class="col-md-2 px-4"><font color="red">*</font>Item Name</div>
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


	<div class="row rowFlex reFlex">
		<div class="col-md-2 px-4"><div id="batchNoDivId">Batch No.</div>
				<input type="hidden" name="isBatchReq" value="0"></div>
		<div class="col-md-2"><input type="text"
					name="strBatchNo" maxlength="30" class="form-control"
					onkeypress="return validateData(event,17);" /></div>
		<div class="col-md-2"><div id="expiryDateDivId">Expiry Date</div>
				<input type="hidden" name="isExpirtReq" value="0"></div>
		<div class="col-md-2"><input  name="strExpiryDate"
												class="form-control datepicker"
												value="${giftedItemDetailsTransBean.strCtDate}"
												style="color: rgba(113, 111, 111, 0.87);">
												</div>
		<div class="col-md-2">Manufacture Date</div>
		<div class="col-md-2"><input  name="strManufactureDate"
												class="form-control datepicker"
												value="${giftedItemDetailsTransBean.strCtDate}"
												style="color: rgba(113, 111, 111, 0.87);"></div>
	</div>


<div class="row rowFlex reFlex">
	<div class="col-md-2 px-4"><font color="red">*</font>Gifted Quantity</div>
	<div class="col-md-2"><input type="text"
				name="strInHandQuantity" maxlength="8" class="form-control"
				onkeypress="return validateData(event,5);" value="1" /></div>
	<div class="col-md-2"><font color="red">*</font>Gifted Quantity Unit</div>
	<div class="col-md-2"><div id="freeItemUnit"><input type="text" value="No." disabled="disabled" name="strInHandQuantityUnitID"
				class='form-control'>
				</div>
											</div>
	<!-- <div class="col-md-2">Rack No</div>
	<div class="col-md-2"><input type="text"
				name="strRackNumber"  class="form-control"
				
				onkeypress="return validateData(event,3);" /></div> -->
</div>

<div class="row rowFlex reFlex">
	<div class="col-md-2 px-4">PO No.</div>
	<div class="col-md-2"><input type="text"
				name="strPONumber"  class="form-control"
				
				onkeypress="return validateData(event,3);" /></div>
	<div class="col-md-2"><div id="specNotMandatoryDivId" style="display: none;">Specification</div>
			<div id="specMandatoryDivId" style="display: block;"><font color="red">*</font>Specification</div></div>
	<div class="col-md-6"><textarea class="form-control" rows="2" cols="40" name="strItemSpecification"></textarea></div>
	
</div>

<br>	
<div class="row rowFlex reFlex">
				<div class="col-md-12"><i class="fas fa-tags" style="size:4x;"></i>&nbsp;Rate Details</div>
</div>


<div class="row rowFlex reFlex">
	<div class="col-md-2 px-4">Currency Code</div>
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
	
	
<div class="row rowFlex reFlex">
	<div class="col-md-2 px-4"><font color="red">*</font>Unit
			Name</div>
	<div class="col-md-2"><div id="UnitRateID"><input type="text" value="No." disabled="disabled" name="strUnitRateID"
				class='form-control'>
				</div></div>
	<div class="col-md-2"><font color="red">*</font>Sale
			Price/Unit (INR)</div>
	<div class="col-md-2"><input type="text"
				name="strSalePrice" maxlength="14" class="form-control"
				onkeypress="return validateData(event,7);" />
											</div>
	<div class="col-md-2"><font color="red">*</font>Unit
			Name</div>
	<div class="col-md-2"><div id="UnitRateID1"><input type="text" value="No." disabled="disabled" name="strUnitSaleID"
				class='form-control'>
				</div>
	</div>
</div>


<div class="row rowFlex reFlex">
	<div class="col-md-2 px-4"><font color="red">*</font>Received
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



<div id="id3" style="display: none">	

	<logic:equal name="giftedItemDetailsTransBean"	property="strWarrantyFlag" value="1">

	<div class="row rowFlex reFlex">
				<div class="col-md-4 px-4"><html:checkbox
					property="strIsWarrantyDetails" name="giftedItemDetailsTransBean"
					value="1"
					onclick="showOrHideDetails(this,'warrantyItemDtlsDivId');">&nbsp;Whether Warranty Details Required</html:checkbox></div>
			</div>


		<div id="warrantyItemDtlsDivId" style="display: none">
		<div class="row rowFlex reFlex">
				<div class="col-md-2 px-4"><font color="red">*</font>Warranty Date</div>
				<div class="col-md-2"><input  name=strWarrantyDate
											class="form-control datepicker"
											value="${receiveFromThirdPartyTransBean.strWarrantyDate}"
											style="color: rgba(113, 111, 111, 0.87);"></div>
				<div class="col-md-2"><font color="red">*</font>Warranty Upto</div>
				<div class="col-md-2"><input type="text"
					name="strWarrantyUpTo" class="form-control" maxlength="3"
					onkeypress="return validateData(event, 5);"></div>
					<div class="col-md-2"><font color="red">*</font>Unit</div>
				<div class="col-md-2"><select
					name="strWarrantyUpToUnit" class="browser-default custom-select">
					<option value="0">Select Value</option>
					<option value="1">Day(s)</option>
					<option value="2">Month(s)</option>
					<option value="3">Year(s)</option>
				</select></div>
				
			</div>
			<div class="row rowFlex reFlex">
			<div class="col-md-2 px-4"><font color="red">*</font>Manufacture</div>
				<div class="col-md-2"><div id="warrantyManufDivId"><select
					name="strWarantyManufacturer" class="browser-default custom-select">
					<option value='0'>Select Value</select></div></div>
				
				<div class="col-md-2">Remarks</div>
				<div class="col-md-6"><textarea class="form-control" rows="2" cols="25"
					name="strWarrantyRemarks"></textarea></div>
				
			</div>
	</div>
	</logic:equal>
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

<div id="id2" style="display: none">	

	<logic:equal name="giftedItemDetailsTransBean"
		property="strInstallFlag" value="1">

			<div class="row rowFlex reFlex">
				<div class="col-md-4 px-4"><html:checkbox
					property="strIsInstallDetails" name="giftedItemDetailsTransBean"
					value="1" onclick="showOrHideDetails(this,'installItemDtlsDivId');">&nbsp;Whether Install Details Required</html:checkbox></div>
			</div>
		
			<div id="installItemDtlsDivId" style="display: none">	
			<div class="row rowFlex reFlex">
				<div class="col-md-2 px-4"><font color="red">*</font>Installation Start Date</div>
				<div class="col-md-2"><input  name="strInstallStartDate"
											class="form-control datepicker"
											value="${receiveFromThirdPartyTransBean.strInstallStartDate}"
											style="color: rgba(113, 111, 111, 0.87);"></div>
				<div class="col-md-2"><font color="red">*</font>Installation End Date</div>
				<div class="col-md-2"><input  name="strInstallEndDate"
											class="form-control datepicker"
											value="${receiveFromThirdPartyTransBean.strInstallEndDate}"
											style="color: rgba(113, 111, 111, 0.87);"></div>
				<div class="col-md-2"><font color="red">*</font>Installation Status</div>
				<div class="col-md-2"><select name="strInstallStatus"
					class="browser-default custom-select">
					<option value='0'>Select Value</option>
					<option value='1'>Success</option>
					<option value='2'>Failure</option>
				</select></div>
			</div>
			<div class="row rowFlex reFlex">
				<div class="col-md-2 px-4"><font color="red">*</font>Installed By</div>
				<div class="col-md-2"><input type="text"
					class="form-control" name="strInstallBy"
					onkeypress="return validateData(event, 4);" maxlength="100"></div>
				<div class="col-md-2"><font color="red">*</font>Installer Contact No.</div>
				<div class="col-md-2"><input type="text"
					name="strInstallerContactNo"
					onkeypress="return validateData(event, 2);" class="form-control"
					maxlength="10"></div>
				<div class="col-md-2">Remarks</div>
				<div class="col-md-2"><textarea class="form-control" rows="2" cols="25"
					name="strInstallRemarks"></textarea></div>
			</div>
			
		</div>
	</logic:equal>
</div>	
	<div id="id1" style="display: none">	
		<div class="row rowFlex reFlex">
				<div class="col-md-4 px-3">
				<div id="freeItemDtlsDivIdPlusId" align="left"
					style="display: block;"><i class="fas fa-plus-circle" onClick="showView('freeItemDtlsDivId');" style="cursor: pointer; "></i>&nbsp;Free Items</div>
				<div id="freeItemDtlsDivIdMinusId" style="display: none;"
					align="left"><i class="fas fa-minus-circle" onClick="hideView('freeItemDtlsDivId');" style="cursor: pointer; "></i>&nbsp;Free Items</div>
			</div>
			<div class="col-md-4">
				<div id="partItemDtlsDivIdPlusId" align="left"
					style="display: block;"><i class="fas fa-plus-circle" onClick="showView('partItemDtlsDivId');" style="cursor: pointer; "></i>&nbsp; Part Items</div>
				<div id="partItemDtlsDivIdMinusId" style="display: none;"
					align="left"><i class="fas fa-minus-circle" onClick="hideView('partItemDtlsDivId');" style="cursor: pointer; "></i>&nbsp; Part Items</div>
			</div>
			
			<div class="col-md-4">
			<div id="paramItemDtlsDivIdPlusId" align="left"
					style="display: block;"><i class="fas fa-plus-circle" onClick="showView('paramItemDtlsDivId');" style="cursor: pointer; "></i>&nbsp;Parameter Details</div>
				<div id="paramItemDtlsDivIdMinusId" style="display: none;"
					align="left"><i class="fas fa-minus-circle" onClick="hideView('paramItemDtlsDivId');" style="cursor: pointer; "></i>&nbsp;Parameter Details</div>
			</div>
			
		</div>
	</div>
	
	<div id="freeItemDtlsDivId" style="display: none">

	<table class="table table-striped text-uppercase" align="center" border="0" cellpadding="1px"
		cellspacing="1px" style="font-weight:bold;">
		<tr>

			<td class="" width="25%">Item Name</td>
			<td class="" width="25%">Batch No.</td>
			<td class="" width="25%">Expiry Date</td>
			<td class="" width="10%">Qty.</td>
			<td class="" width="5%">&nbsp;&nbsp;</td>
			<td align="center">
			<button type="button"
										class="float-right btn btn-outline-info mt-1" title="Add"
										onclick="addFreeItems();" style="padding: .175rem .35rem; line-height: 0.8">
										<i class="fas fa-plus-square"></i>
									</button>
			<!-- <a href="#" 	><span class="add">Add</span></a>  -->
			</td>
		</tr>
	</table>
	<div id="id1"></div>


	</div>

	<div id="partItemDtlsDivId" style="display: none">

	<table class="table table-striped text-uppercase" align="center" border="0" cellpadding="1px"
		cellspacing="1px" style="font-weight:bold">
		<tr>

			<td class="" width="20%">Item Name</td>
			<td class="" width="20%">Batch No.</td>
			<td class="" width="20%">Manufacturer</td>
			<td class="" width="15%">Expiry Date</td>
			<td class="" width="20%">Qty.</td>
			<td class="" width="5%">&nbsp;&nbsp;</td>
			<td align="center">
			<button type="button"
										class="float-right btn btn-outline-info mt-1" title="Add"
										onclick="addPartItems();" style="padding: .175rem .35rem; line-height: 0.8">
										<i class="fas fa-plus-square"></i>
									</button>
			<!-- <a href="#" 	><span class="add">Add</span></a>  -->
			</td>
		</tr>
	</table>
	<div id="id2"></div>

	</div>


	<div id="paramItemDtlsDivId" style="display: none">

	<table class="table table-striped text-uppercase" align="center" border="0" cellpadding="1px"
		cellspacing="1px">

		<tr>
			<td colspan="4" class="" width="25%"></td>
		</tr>

		<tr>

			<td align="center">
								<button type="button"
										class="float-right btn btn-outline-info mt-1" title="Add"
										onclick="checkForPopup(this,document.forms[0].strItemCategoryNo.value , '1')" style="padding: .175rem .35rem; line-height: 0.8">
										<i class="fas fa-plus-square"></i>
									</button>
			
			<!-- <a href="#" class="button"	onclick="checkForPopup(this,document.forms[0].strItemCategoryNo.value , '1')"><span class="add">Add</span></a>
			 --><!-- <img
				src="../../hisglobal/images/Add.png"
				onclick="checkForPopup(this,document.forms[0].strItemCategoryNo.value , '1')"
				style="cursor: pointer; "> --></td>
		</tr>

	</table>

	</div>

	
<div class="row rowFlex reFlex">
	<div class="col-md-12" align="right"><font size="2" color="red">*</font>
			Mandatory Fields</div>
</div>

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

	<div class="popUpDiv" id="popUpDivId" style="display: none;" >
	<table bgcolor="white">
		<tr>
			<td>
			<div id="itemParameterDtlDivId" style="display: block;"></div>
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

<jsp:include page="itemInventory_multirow_mmstransNEW.jsp"></jsp:include>
<tag:autoIndex></tag:autoIndex>  


</body>
</html>








