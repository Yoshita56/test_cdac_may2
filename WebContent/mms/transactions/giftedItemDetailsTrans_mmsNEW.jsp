<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>



<html>
<head>
<meta charset=UTF-8">
<title>Gifted Item Details</title>

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
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">	

<script type="text/javascript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/datepicker1.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>

<script language="JavaScript" src="../js/giftedItemDetailsNEW.js"></script>
<script language="JavaScript">



</script>
<style>
.gj-textbox-md {
	border: 1px solid #ced4da;
	padding: 0.375rem 0.75rem;
	font-weight: 400;
	border-radius: 0.25rem;
	border-bottom: 1px solid #ced4da;
	display: block;
	font-family: Helvetica, Arial, sans-serif;
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

.table .thead-dark {
	color: #000 !important;
	border: none !important;
	background: linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156))
		!important;
}

.thead-dark th {
	background: none !important;
	border: none !important;
	padding: 0.25rem;
	text-align: center;
}
</style>

</head>
<body >
<html:form name="giftedItemDetailsTransBean" action="/transactions/GiftedItemDetailsTransCNTNEW" type="mms.transactions.controller.fb.GiftedItemDetailsTransFB">

<div class="viewport" id="nonPrintable">

	<div id="errMsg" class="errMsg" style="font-size:18px;"><bean:write name="giftedItemDetailsTransBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg" style="font-size:18px;"><bean:write name="giftedItemDetailsTransBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg" style="font-size:18px;"><bean:write name="giftedItemDetailsTransBean" property="strNormalMsg" /></div>
					 
			<div class="container-fluid">
						<div class="prescriptionTile">	
							<div class="row" >
								<div class="legend2"  id='nonPrintableLegend2'>
									<button type="button" class="float-right btn btn-danger cancelbtn " style="border-radius:50%; padding:11px 13px;" onclick="cancelFunc();">
										<i class="fas fa-times" title="Cancel"></i>
									</button>
									
									<button type="button" id="printButton"
										class="float-right btn btn-success btn-circle"
										tabindex='2' id="submitId" onclick=' return validate2();'
										name="giftedItemDetailsTransBean"
										style="background-color: #5cb85c; display:none; border-radius:50%; padding:11px 11px;">
										<i class="fa fa-print iround" title="Print"></i>
									</button>
									
									<button type="button" class="float-right btn btn-primary btn-circle" name="giftedItemDetailsTransBean" property="strGiftedItemViewMode" style="border-radius:50%; padding:11px 10px;" title="Click Here To View" onclick="changeViewMode(this);">
										<i class="fas fa-eye iround" title="View"></i>
									</button>
								</div>	
							</div> 
							
							<div class="row rowFlex reFlex mt-2" >
									<div class="col-sm-5" style="font-weight: 600; font-size:large">
										<i class="fas fa-hand-holding-usd fa-lg"></i><span class="subHeaders">&nbsp;Gifted Item Details
										</span>
									</div>
							</div>
			
							<div class="row rowFlex reFlex my-1">
								<div class="col-sm-3 "><font color="red">*</font>Store Name</div>
								<div class="col-sm-3">
									<select name="strStoreId" class='browser-default custom-select' onchange="reSetViewDetails(),getItemCategorys(this);">
										<bean:write name="giftedItemDetailsTransBean" property="strStoreNameCombo" filter="false" />
									</select>
								</div>
								
								<div class="col-sm-3"><font color="red">*</font>Item Category</div>
								<div class="col-sm-3">
								  <div id="itemCategoryDivId">
									<select name="strItemCategoryId" class='browser-default custom-select' onchange="reSetViewDetails(this);">
									    <option value="0">Select Value</option>
										<bean:write name="giftedItemDetailsTransBean" property="strItemCategoryCombo" filter="false" />				
									</select>
								</div>
								</div>
							</div>
							
						 <div id="itemDetailsMode">
							   <div class="row rowFlex reFlex my-1">
							  		<div class="col-sm-3 "><font color="red">*</font>Gifted By</div>
							  		<div class="col-sm-3">
							  		    <div id="giftedById">
							  		       <input type="text" class='form-control' placeholder="Supplier" name="strGiftedBy"  value ="Supplier" maxlength="100" onkeypress="return validateData(event,4);">
							  		    </div>						  		    
							  		</div>
							  		
							  		<div class="col-sm-3">Address</div>
									<div class="col-sm-3">
									<textarea class="form-control" name="strAddress" value="-" rows="2" cols="18" style="height:38px;" ></textarea>
									</div>
							  </div> 
							
							  
	  						  <div class="row rowFlex reFlex my-1">
	  						  		<div class="col-sm-3">Remarks</div>
									<div class="col-sm-3"><textarea class="form-control" name="strRemarks" rows="2" cols="18">Gifted Item Remarks</textarea></div>
							  </div>
							     						  
	   						  <div class="row rowFlex reFlex mt-2">
							      <div class="col-sm-12" align="center">
							        <a class="btn btn-sm btn-success" href="#" onclick="return getInventoryDtls();" style="font-size:1rem;">GO <i class="fas fa-angle-double-right"></i></a>
							       </div>
							  </div>
						 </div>	 
						 
						 <div id="giftedItemViewMode" style="display: none">
						 <div class="row rowFlex reFlex my-1">
						 	<div class="col-md-3 "><font color="red">*</font>From Date</div>
						 	<div class="col-md-3"><input  name="strFromDate"
																class="form-control datepicker"
																value="${giftedItemDetailsTransBean.strCurrentDate}"
																style="color: rgba(113, 111, 111, 0.87);"></div>
						 	<div class="col-md-3"><font color="red">*</font>To Date</div>
						 	<div class="col-md-3">
					 					<input  name="strToDate" class="form-control datepicker"
																value="${giftedItemDetailsTransBean.strCurrentDate}"
																style="color: rgba(113, 111, 111, 0.87);">
							</div>
						 </div>
						 
						 <div class="row rowFlex reFlex my-1">
							 <div class="col-sm-12 mt-4" align="center">  
							 		<a class="btn btn-sm btn-success" href="#" onclick="return getGiftedViewDetails();" style="font-size:1rem;">GO <i class="fas fa-angle-double-right"></i></a>
							 </div>
						</div>
	 <!-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
         
		<tr>
			<td class="LABEL" colspan="2"></td>
			<td class="CONTROL" colspan="2"></td>
		</tr>
		<tr>
			<td class="LABEL" colspan="2"></td>
			<td class="CONTROL" width="25%" ></td>
			
			<td class="multiControl" width="25%" colspan="1">
			<img style="cursor: pointer; " title="Get Gifted Item Details" src="../../hisglobal/images/Go.png" onclick="return getGiftedViewDetails();"/>
			
			</td>
			
		</tr> -->         
         
	  <!--  <tr >
			<td style="display: none;" width="50%" class="LABEL" colspan="2">Gifted Details For Financial Year</td>
			<td style="display: none;" width="25%" class="CONTROL" colspan="1"><div id="finYearDivId"></div>
			</td>
						
	   </tr>
	  </table> -->
	  <div class="row rowFlex reFlex"></div>
	  	<div id="giftedViewDetailsDivId" style="display: none">
	  	</div>
	 </div>
<hr>
		<div class="row">
			<div class="col-md-12" align="right"><font size="2" color="red">*</font>Fields Mandatory </div>
		</div> 
		 <!-- <table border="0" class="TABLEWIDTH" align="center" cellpadding="1px"
         cellspacing="1px">
                
		<tr class="FOOTER">
			 <td colspan="4"><font size="2" color="red">*</font> Mandatory Fields  </td>
		</tr>
	</table> -->
	
	<!-- <div id="viewCancelButtonDivId" style="display: none">
	<table  class="TABLEWIDTH" align="center">
	  <tr>
			<td align="center">
	                <img style="cursor:pointer;" title="Click to Return Main Screen" src="../../hisglobal/images/btn-ccl.png" onClick="cancelViewPage();" />
	                <a href="#" class="button" onclick="cancelViewPage();"><span class="cancel">Cancel</span></a>
			</td>
		</tr>
	</table>	
	</div> -->
				<input type="hidden" name="hmode"/>
				<input type="hidden" name="strStoreName" value="${giftedItemDetailsTransBean.strStoreName}"/>
				<input type="hidden" name="strItemCategoryName" value="${giftedItemDetailsTransBean.strItemCategoryName}"/>
				<input type="hidden" name="strCurrentDate" value="${giftedItemDetailsTransBean.strCurrentDate}" />
				<input type="hidden" name=strHiddenValue value="" />

				<div id="blanket" style="display:none;"></div>
				
				<div class="popUpDiv" id="popUpDiv1" style="display:none;">
				   <table bgcolor="white">
				     <tr>
				      <td>
				         <div id="voucherDivId" style="display:block;padding:15px;"></div>
				      </td>
				     </tr>
				    </table>
				</div>
				
			</div>
		</div>
	</div>
</html:form>
<tag:autoIndex></tag:autoIndex>  

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
