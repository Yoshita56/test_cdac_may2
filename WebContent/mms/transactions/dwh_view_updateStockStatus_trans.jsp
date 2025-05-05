<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>



<html>
<head>
<meta charset=UTF-8">
<title>Update Stock Status</title>

<!-- CSS -->
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>
<link href="../css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">

<!-- JS -->
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>

<script language="JavaScript" src="../js/dwh_main_updateStockStatus_trans.js"></script>

<style type="text/css">

.prescriptionTile {
	margin: 1.5% 0;
	border-bottom: 1px solid #d7d7d7;
	padding-bottom: 10px;
	padding: 1% 2% 0.5% 2%;
	background-color: #fff;
	transition: 0.5s;
	box-shadow: 0 0.5px 10px 2px #b0acac;
	border-radius: .25rem;
	color: rgba(0, 0, 0, 1);
}
.legend2 {
	position: absolute;
	top: -2.5em;
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
body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 14px;
	line-height: 1.42857143;
	color: rgba(0, 0, 0, 1);
	font-weight: 501;
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
		text-align:center;
	}
</style>
</head>
<body >
<html:form name="updateStockStatusTransFB" action="/transactions/UpdateStockStatusTransCNT" type="mms.transactions.controller.fb.UpdateStockStatusTransFB">
	
	<div id="errMsg"     class="errMsg"    style="font-size:16px;"><bean:write name="updateStockStatusTransFB" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg" style="font-size:16px;"><bean:write name="updateStockStatusTransFB" property="strWarningMsg" /></div>
	<div id="normalMsg"  class="normalMsg"  style="font-size:16px;"><bean:write name="updateStockStatusTransFB" property="strNormalMsg" /></div>
	
	<div class='popup' id='drugDtlId' style="display: none">
		<table width='400' border="0" cellspacing="1" cellpadding="1">
			<tr class="HEADER">
				<td colspan='3'>Details</td>
	
				<th align='right'><img style='cursor: pointer; '
					src='../../hisglobal/images/popUp_cancel.JPG' title='Click to Close Pop-Up' onClick="hideDrugDetails('drugDtlId');">
				</th>
			</tr>
		</table>

		<table width='400' border="0" cellspacing="1" cellpadding="1">
			<tr>
				<td colspan="1" class='multiLabel'>Approved By</td>
				<td colspan="1" class='multiLabel'>Reason</td>
				<td colspan="1" class='multiLabel'>Whether updated in all DWH</td>
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
		</table>
	</div>
	
	
<%-- 	<tag:tab tabLabel="Update Stock Status" selectedTab="FIRST" align="center" width="TABLEWIDTH"> </tag:tab> --%> 
    <div class="container-fluid">
    	<div class="prescriptionTile" align="center">
        
         	<div class="row">       
			    <div class="col-sm-6" style="text-align: initial;">
					<p class="subHeaders">
						<i class="fas fa-file-alt iround"
							style="font-size: 20px; color: #28a745" title=""></i>
						&nbsp; Update Stock Status
					</p>
				</div> 
				
				<div class="col-sm-6" id="">
					<div class="legend2" id='nonPrintableLegend2'>
						<button type="button" class="float-right btn btn-danger mt-1 btn-circle cancelbtn" title="Cancel" onClick="cancelFunc()" onkeypress="if(event.keyCode==13) cancelFunc()">
							<i class="fas fa-times fa-lg iround" title="Cancel"></i>
						</button>
						<button type="button" class="float-right btn btn-secondary btn-circle" style="background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" title="Clear" name="clearImg" onclick="document.forms[0].reset(),clearMsg('INITVAL')" onkeypress="if(event.keyCode==13) document.forms[0].reset(),clearMsg('INITVAL');">
							<i class="fas fa-broom fa-lg iround" title="Clear"></i>
						</button>
					</div>
				</div>
			</div>
			       
     	<div class="container">
			<div class="row my-1" style="margin:1% 5%" >
				<div class="col-md-2 ">
					<label><font color="red">*</font>Store Name</label>
				</div>
				
				<div class="col-md-4"> 
					<select name="strStoreId" class="browser-default custom-select" onchange="getItemCategory();">
						<bean:write name="updateStockStatusTransFB" property="strDrugWareHouseNameCmb" filter="false" />
					</select>
			    </div>
			    
	   		   <div class="col-md-2">
					<label><font color="red">*</font>Item Category</label>
			   </div>
			    <div class="col-md-4">
					<div id="itemCategoryDivId">
						<select name="strItemCategoryId" class='browser-default custom-select'>
							<bean:write name="updateStockStatusTransFB" property="strItemCatgCmb" filter="false" />
						</select>
					</div>
			    </div>
			</div>

			<div class="row my-1" style="margin:1% 5%">
				<div class="col-md-2 ">From Date</div>
				<div class="col-md-4">
					<%-- <input  name="strFromDate" class="form-control datepicker" value="${updateStockStatusTransFB.strCurrentDate}" style="color: rgba(113, 111, 111, 0.87);"> --%> 
					<input name="strFromDate" id="datepicker1" class="form-control" value="${updateStockStatusTransFB.strCurrentDate}" />
				</div>
		       	<div class="col-md-2">To Date</div>
		       	<div class="col-md-4">
		       		<%-- <input  name="strToDate" class="form-control datepicker" value="${updateStockStatusTransFB.strCurrentDate}" style="color: rgba(113, 111, 111, 0.87);"> --%>    	
		       		<input name="strToDate" id="datepicker2" class="form-control" value="${updateStockStatusTransFB.strCurrentDate}" />
		       	</div>
		   </div> 
     
		   <div class="row my-4" >
	     	  <div class=" col-sm-12" align="center"><a class="btn btn-sm btn-success"  title="Get Details" href="#" onclick="return getUpdatedStockStatusViewDetails();" style="font-size:1rem;">GO <i class="fas fa-angle-double-right"></i></a></div>
	       </div>       
	 </div>         
              
              
	<%-- <table class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">   
	     <tr class="HEADER">
			<td colspan="4"></td>
		</tr>
	    <tr>
			<td width="25%" class="LABEL">
			<font color="red">*</font>Store Name
			</td>
			<td width="25%" class="CONTROL">
				<select name="strStoreId" class='comboMax' onchange="getItemCategory();">
						<bean:write name="updateStockStatusTransFB" property="strDrugWareHouseNameCmb" filter="false" />
				</select>
			</td>
			<td  width="25%" class="LABEL">
				<font color="red">*</font>Item Category
			</td>
			<td width="25%" class="CONTROL">
				<div id="itemCategoryDivId">
					<select name="strItemCategoryId" class='comboMax'>
						<bean:write name="updateStockStatusTransFB" property="strItemCatgCmb" filter="false" />
					</select>
				</div>
			</td>		
	   </tr>
	    <tr >
			<td class="LABEL" colspan="2"><font color="red">*</font>From Date</td>
			<td class="CONTROL" colspan="2"><dateTag:date name="strFromDate" value="${updateStockStatusTransFB.strCurrentDate}" /></td>
		</tr>
		<tr >
			<td class="LABEL" colspan="2"><font color="red">*</font>To Date</td>
			<td class="CONTROL" width="25%" ><dateTag:date name="strToDate" value="${updateStockStatusTransFB.strCurrentDate}" /></td>
			
			<td class="multiControl" width="25%" colspan="1">
				<img style="cursor: pointer; " title="Get Details" src="../../hisglobal/images/Go.png" onclick="return getUpdatedStockStatusViewDetails();"/>
			</td>
		</tr>     
	   </table> 
	    --%>
	   <div id="viewCurrentStockDtlDivId" ></div>	
	 
	  <div class="row" >
			<div class="col-sm-12 text-right" > <font color='red'>*</font>Mandatory Fields </div>
	  </div>
		 
	<!--  <table border="0" class="TABLEWIDTH" align="center" cellpadding="1px" cellspacing="1px">
		<tr class="FOOTER">
			<td colspan="4"><font size="2" color="red">*</font> Mandatory Fields</td>
		</tr>
	</table> -->
	
	<!-- 
	<table  class="TABLEWIDTH" align="center">
	  <tr>
		<td align="center">
              <img style="cursor:pointer;cursor:pointer" title="Click to Clear Page" src="../../hisglobal/images/btn-clr.png" name="clearImg" onclick="document.forms[0].reset(),clearMsg('INITVAL')" onkeypress="if(event.keyCode==13) document.forms[0].reset(),clearMsg('INITVAL');">
              <img style="cursor: pointer; " title="Click to Return Main Menu" src="../../hisglobal/images/btn-ccl.png" onClick="cancelPage()" onkeypress="if(event.keyCode==13) cancelPage()" />              
		</td>
	 </tr>
	</table>	 -->



		<input type="hidden" name="hmode"/>
		
		<input type="hidden" name="strStoreName" value=""/>
		<input type="hidden" name="strItemCategoryName" value=""/>
		<input type="hidden" name="strItemCategoryCode" value=""/>
		<input type="hidden" name="strCurrentDate" value="${updateStockStatusTransFB.strCurrentDate}" />
		<input type="hidden" name="strHiddenValues" value="${updateStockStatusTransFB.strHiddenValues}" />
		
		</div>
	</div>

</html:form>

 <script type="text/javascript">
    $('#datepicker1').datepicker({modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
    $('#datepicker2').datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
    var today=new Date();
    var arr=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
    var mmm=arr[today.getMonth()];
    var hrs=today.getHours();
    var dd=today.getDate()+"-"+mmm+"-"+today.getFullYear();
    $('#datepicker1').val(dd);
    $('#datepicker2').val(dd);
</script>
	<tag:autoIndex></tag:autoIndex>   
</body>
</html>