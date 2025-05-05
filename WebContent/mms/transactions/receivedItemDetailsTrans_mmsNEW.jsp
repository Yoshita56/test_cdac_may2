<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>

<html>
<head>
<meta charset=UTF-8">
<title>Gifted Item Details</title>

<!-- added 20 April 2020 -->
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css"
	rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap-theme.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/datatable/css/dataTables.bootstrap.css"
	rel="stylesheet" />
<link
	href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css"
	rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/swAl/swal.css"
	rel="stylesheet">
<link href="../../ipd/css/newlayout.css" rel="stylesheet"
	type="text/css">
<link
	href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css"
	rel="stylesheet" type="text/css">
	
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
<!-- end -->

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

<script  type="text/javascript" src="../../hisglobal/js/popup.js"></script>
<script  type="text/javascript" src="../../hisglobal/js/newpopup.js"></script>
<!-- EXT JS -->
<script language="JavaScript" src="../js/receivedItemDetailsNEW.js"></script>

<style type="text/css">
	body {
		font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
		font-size: 14px;
		line-height: 1.42857143;
		color: rgba(0, 0, 0, 1);
		font-weight: 501;
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
		top: -2.1em;
		right: 44px;
		line-height: 1.2em;
	}
	.subHeaders {
		font-weight: 500 !important;
		font-family: "Helvetica Neue", "Helvetica";
		font-size: 19px !important;
		padding-bottom: 0px !important;
		color: rgba(0, 0, 0, 1);
	}
	.btn-circle {
		width: 37px;
		height: 34px;
		text-align: center;
		padding: 6px 0;
		font-size: 12px;
		line-height: 1.428571429;
		border-radius: 17px;
		color: white;
		float: right;
	}
	.iround {
		color: white;
		font-size: 16px;
	}
	.table {
	width: 100%;
	margin-bottom: 1rem;
	color: rgba(0, 0, 0, 1);
	border-collapse: separate;
	}
	.table th, .table td {
		padding: 0.05rem;
		border-top: 0px solid #dee2e6;
	}
	.table .thead-dark {
	  	color: #fff !important;
	  	border: none !important;
	  	background:linear-gradient(to right, rgb(73, 178, 243), rgb(2, 98, 156)) !important;
	  	align:center;
	}
	.thead-dark th{
		background:none !important;
		border: none !important;	
		align:center;
	}
	.highlight-icon {
	  color: #1400ff; 
	}
	
	.highlight-icon:hover {
	  color: #f00; 
	}
</style>

<script type="text/javascript">

function controlToMainPage()
{	    
	document.forms[0].hmode.value="unspecified";
	document.forms[0].submit();
}

</script>


</head>
<body >
<html:form name="receiveFromThirdPartyTransBean" action="/transactions/ReceiveFromThirdPartyTransCNTNEW" type="mms.transactions.controller.fb.ReceiveFromThirdPartyTransFB">
				 
	<div id="errMsg" class="errMsg" style="font-size:16px;text-align:center;" ><bean:write name="receiveFromThirdPartyTransBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg" style="font-size:16px; text-align:center;" ><bean:write name="receiveFromThirdPartyTransBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg" style="font-size:16px; text-align:center;" ><bean:write name="receiveFromThirdPartyTransBean" property="strNormalMsg" /></div>

<div class="container-fluid">
	<div class="prescriptionTile">
	   	<div class="row ">
			<div class="col-sm-6" style="text-align: initial;">
				<p class="subHeaders">
					<i class="fas fa-file-alt iround"
						style="font-size: 20px; color: #28a745" title=""></i>
					&nbsp;Received From Third Party Details
				</p>
			</div>
					
			<div class="col-sm-6" id="">
				<div class="legend2" id='nonPrintableLegend2'>
					<button id="cancelforreceivepage" style="display:block;" type="button" class="float-right btn btn-danger mt-1 btn-circle cancelbtn" onclick="cancelFunc();">
						<i class="fas fa-times iround" title="Cancel"></i>
					</button>
										
					<button id="cancelforeyepage" style="display:none;" type="button" class="float-right btn btn-danger mt-1 btn-circle cancelbtn" onclick="controlToMainPage();">
						<i class="fas fa-times iround" title="Cancel"></i>
					</button>
					
					<button id='pbtn' type="button" class="float-right btn btn-primary mt-1 btn-circle printbtn" 
			 			property="strReceivedItemViewMode" name="receiveFromThirdPartyTransBean" title="View" 
			 			value="3" onclick="changeViewMode(this);">
						<i class="fas fa-eye iround"  title="View"></i>
					</button>
				</div>
			</div>
		</div>
	
<!-- 	<div class="row">
		<div class="legend2" id='nonPrintableLegend2'>
			
			<button type="button" title="Cancel"
				class="float-right btn btn-danger mt-1 btn-circle cancelbtn"
				onclick="cancelFunc();" style="border-radius:50%; padding:12px 12px;">
				<i class="fas fa-times" title="Cancel"></i>
			</button>
		
			 <button id='pbtn' type="button" title="View" class="float-right btn btn-primary mt-1 btn-circle printbtn" 
			 		property="strReceivedItemViewMode" name="receiveFromThirdPartyTransBean"
			 		value="3" onclick="changeViewMode(this);" style="border-radius:50%; padding:12px;">
					<i class="fas fa-eye"  title="View"></i>
			</button>
			
		</div>
	</div>
	
	<div class="row">
		<div class="col">
			<p class="h5 font-weight-normal mb-3">
					<i class="fas fa-file-alt iround" style="font-size: 20px; color: #28a745" title=""></i>
				&nbsp;Received From Third Party Details
				</p>
		</div>
	</div>
	 -->
	<div class="row" style="display:none;"> 
			<div class="col-md-4"></div>
			<div align="right" class="col-md-1 custom-control custom-radio"> 
	        	<input type="radio" id='customRadio' class="custom-control-input" name="strReceivedItemApprovedMode" value="4" checked="checked" onClick="changeViewMode(this);"/>
	        	<label class="custom-control-label" for="customRadio">NEW</label>
			</div>
			<div align="right" class="col-md-2 custom-control custom-radio">
				<input type="radio"id='customRadio1' class="custom-control-input" name="strReceivedItemStockUpdateMode" value="2" onClick="changeViewMode(this);"/>
				<label class="custom-control-label" for="customRadio">UPDATE STOCK</label>
			</div>
			<div align="right" class="col-md-1 custom-control custom-radio">
				<input type="radio" id='customRadio2' class="custom-control-input" name="strReceivedItemViewMode" value="3"  onClick="changeViewMode(this);"/>
				<label class="custom-control-label" for="customRadio">VIEW</label>
			</div>
	</div>
   <%--            
	<table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	     <tr class="HEADER">
			<td colspan="3">Received From Third Party Details</td>
			 <td colspan="1" align="right" >
		     	<span>
		     		<html:checkbox property="strReceivedItemViewMode" name="receiveFromThirdPartyTransBean" value="3" onclick="">View</html:checkbox>
		     	</span>
		     </td>	
		 </tr>
		
		 <tr style="display: none;">
	  		 <td colspan="4" class="TITLE">
	   
	    <div align="right" > 
	        <input type="radio"  name="strReceivedItemApprovedMode" value="4" checked="checked" onClick="changeViewMode(this);"/>
			NEW <input type="radio" name="strReceivedItemStockUpdateMode" value="2" onClick="changeViewMode(this);"/>UPDATE STOCK
			<input type="radio" name="strReceivedItemViewMode" value="3"  onClick="changeViewMode(this);"/>VIEW
	    </div>
	    
	   </td>
	   </tr>
	 --%> 
	   
	 <div class="row" style="margin:1% 5%">
		 <div class="col-md-2"><font color="red">*</font>Store Name</div>
		 <div class="col-md-4">
			<select name="strStoreId" class='browser-default custom-select' onchange="reSetViewDetails(),getItemCategorys(this);">
				<bean:write name="receiveFromThirdPartyTransBean" property="strStoreNameCombo" filter="false" />
			</select> 
		 </div>
		
		 <div class="col-md-2"><font color="red">*</font>Item Category</div>
		 <div class="col-md-4">
		 <div id="itemCategoryDivId">
			<select name="strItemCategoryId" class='browser-default custom-select'>
				<bean:write name="receiveFromThirdPartyTransBean" property="strItemCategoryCombo" filter="false" />
			</select>
		</div>
		</div>
	</div>
	 
	 <div id="itemDetailsMode" style="display: block;">
		<div class="row" style="margin:1% 5%" >
	 		<div class="col-md-2">
	 		<font color="red">*</font>Third Party Name
	 		</div>
	 		<div class="col-md-4">
				<select class="browser-default custom-select" name="strInstituteId">
					<bean:write name="receiveFromThirdPartyTransBean" property="strInstituteValues" filter="false"/>
				</select>
			</div>
			<div class="col-md-2">
	   			<label>Remarks</label>
			</div>
			
			<div class="col-md-4">
        		<textarea class="form-control" name="strRemarks" style="height:38px">Received From Third Party</textarea>
             </div>	
 		</div>
 		<div class="row" style="margin:1.5% 5%" >
    		<div class="col" align="center">
    			<a class="btn btn-sm btn-success" href="#" onclick="return getInventoryDtls();" style="font-size:1rem;">
    			GO <i class="fas fa-angle-double-right"></i>
    			</a>
   			</div>
	    </div>
    </div>
	 <!--   </tr>
	   <tr>
	   <td colspan="4" class="" align="center">
	   <img style="cursor: pointer; " title="Get Gifted Item Details" src="../../hisglobal/images/Go.png" onclick="return getInventoryDtls();"/>
	   <a href="#" class="button" id="go"	onclick=""></a> 
	   </td>
	   </tr>
	  </table>
	  </div> 
	  -->
	 <div id="giftedItemViewMode" style="display: none">
		 
		 <div class="row " style="margin:1% 5%">
			<div class="col-md-2"><font color="red">*</font>From Date</div>
			<div class="col-md-4"><input  name="strFromDate" class="form-control datepicker" value="${receiveFromThirdPartyTransBean.strCurrentDate}" style="color: rgba(113, 111, 111, 0.87);">
			</div>
			<div class="col-md-2"><font color="red">*</font>To Date</div>
			<div class="col-md-4"><input  name="strToDate" class="form-control datepicker" value="${receiveFromThirdPartyTransBean.strCurrentDate}" style="color: rgba(113, 111, 111, 0.87);">
			</div>
		</div>
		
		 <div class="row my-4">
			<div class="col" align="center"> 
				<a class="btn btn-sm btn-success" href="#" onclick="return getReceivedViewDetails();" style="font-size:1rem;">
				GO <i class="fas fa-angle-double-right"></i>
				</a>
			</div>	
		 </div>
		
		 <div class="row " style="display: none;">
			<div class="col-md-6">Gifted Details For Financial Year</div>
			<div class="col-md-6"><div id="finYearDivId"></div></div>
		 </div>
		 
	  	 <div id="giftedViewDetailsDivId" style="display: none"></div>
	  	 
	 </div>
	 
<hr>		 
	 <div class="row">       
		 <div class="col-md-12" align="right"><font size="2" color="red">*</font> Mandatory Fields </div>
	 </div>

<br>
<input type="hidden" name="hmode"/>
<input type="hidden" name="strStoreName" value=""/>
<input type="hidden" name="strItemCategoryName" value=""/>
<input type="hidden" name="strItemCategoryCode" value=""/>
<input type="hidden" name="strInstituteName" value=""/>
<input type="hidden" name="strStatus" value=""/>
<input type="hidden"  name="strConfigIssueRate"  value="">
<input type="hidden" name="strCurrentDate" value="${receiveFromThirdPartyTransBean.strCurrentDate}" />

 <div id="blanket" style="display:none;"></div>
	<div class="popUpDiv" id="popUpDiv" style="display:none; top: 80px; left: 40px; right:40px; ">
		 <table bgcolor="white">
		   <tr>
		     <td>
		        <div id="voucherDivId" style="display:block;"></div>
		     </td>
		  </tr>
		 </table>
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