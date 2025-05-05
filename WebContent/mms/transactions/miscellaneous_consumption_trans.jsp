<%@ page language="java" contentType="text/html;"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="date"%>
<%@taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/hisTab.tld" prefix="tag"%>
<%@ taglib uri="/WEB-INF/comboPersistence.tld" prefix="cmbPers"%>

<head>
<meta charset=UTF-8">
<title>Miscellaneous Consumption</title>
<!-- <link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
<script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../mms/js/mms.js"></script>
<script language="Javascript" src="../../mms/js/miscellaneous_consumption_transNEW.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script> -->

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">

<link href="../css/transaction.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/calendar-tas.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">	
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<script language="JavaScript" src="../../masterutil/js/master.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/multirow.js"></script>
<script language="Javascript" src="../../mms/js/mms.js"></script>
<script language="Javascript" src="../js/searchItems_util.js"></script>

<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/swal/swal.js"></script>
<!-- <script type="text/javascript"
	src="../../hisglobal/bootstrap4.0_newgui/js/jquery-3.3.1.min.js"></script> -->
<script type="text/javascript" src="../../hisglobal/jquery/3.6.0.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/jquery.datatables.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datatable/js/datatables.bootstrap4.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>

<script language="Javascript" src="../../mms/js/miscellaneous_consumption_transNEW.js"></script>

<style type="text/css">
body {
	font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
	font-size: 14px;
	line-height: 1.42857143;
	color: rgba(0, 0, 0, 1);
	font-weight: 501;
} 
.container{
	max-width:1395px;
} 
.form-control {
	color: rgba(0, 0, 0, 1);
}
.prescriptionTile {
	margin: 0.5% 0;
	border-bottom: 1px solid #d7d7d7;
	padding-bottom: 10px;
	padding: 1% 2% 0.5% 2%;
	background-color: #fff;
	transition: 0.5s;
	box-shadow: 0 0.5px 10px 2px #b0acac;
	border-radius: .25rem;
	color: rgba(0, 0, 0, 1);
}
.subHeaders {
	font-weight: 500 !important;
	font-family: "Helvetica Neue", "Helvetica";
	font-size: 19px !important;
	padding-bottom: 0px !important;
	color: rgba(0, 0, 0, 1);
}
.row {
	padding-bottom: 5px;
}
.legend2 {
	position: absolute;
	top: -2.1em;
	right: 15px;
	line-height: 1.2em;
}
.cancelbtn {
	padding: .175rem .35rem;
	line-height: 0.8;
	background-color: #d9534f;
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
	text-align:center;
}
</style>
</head>
<body >
<html:form name="miscellaneousConsumptionBean" action="transactions/MiscellaneousConsumptionTransCNT" type="mms.transactions.controller.fb.MiscellaneousConsumptionTransFB">
<center>
	<div id="errMsg" class="errMsg" style="font-size:16px"><bean:write name="miscellaneousConsumptionBean" property="strErrMsg" /></div>
	<div id="warningMsg" class="warningMsg" style="font-size:16px"><bean:write name="miscellaneousConsumptionBean" property="strWarningMsg" /></div>
	<div id="normalMsg" class="normalMsg" style="font-size:16px"><bean:write name="miscellaneousConsumptionBean" property="strNormalMsg" /></div>
</center>
	
<%-- <tag:tab tabLabel="Miscellaneous Consumption" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab> --%>

<div class="container-fluid pt-2">
    		<div class="prescriptionTile" align="center">
    				<div class="row ">
						<div class="col-sm-6" style="text-align: initial;">
							<p class="subHeaders">
								<i class="fas fa-file-alt iround"
									style="font-size: 20px; color: #28a745" title="Cancel"></i>
								&nbsp; Miscellaneous Consumption 
							</p>
						</div>
						<div class="col-sm-6" id="">
							<div class="legend2" id='nonPrintableLegend2'>
								<button type="button" class="float-right btn btn-danger mt-1 btn-circle cancelbtn" onclick="cancelFunc();">
									<i class="fas fa-times iround" title="Cancel"></i>
								</button>
								
								<button type="button" class=" btn btn-secondary btn-circle" style="background: #2196f3; border-color: #b9b9b9; margin-top: 0.25rem !important;" onclick="cancel();">
									<!-- <img src="/HIS/hisglobal/images/clear3.png" title="Clear" style="width: 23px; color: #fff;"> -->
									<i class="fas fa-broom  iround" title="Clear"></i>
								</button>
								
								<button type="button" id="submitId" class="float-right btn btn-success mt-1 btn-circle savebtn" tabindex='2' onclick='return validate1();'>
									<i class="fa fa-download iround" title="Save"></i>
								</button>
							</div>
						</div>
					</div>	
			   <div class="container">
					  <div class="row pt-4">
							<div class="col-sm-2 text-left">
									<label><font color="red">*</font>Store Name</label>
							</div> 
							
							<div class="col-sm-3">
								<select name="strStoreId" id="" class="browser-default custom-select" onchange="getItemCategoryCmb();">
									<bean:write name="miscellaneousConsumptionBean" property="strStoreNameValues" filter="false" />
								</select>
								
								<%-- <html:select name="miscellaneousConsumptionBean" styleClass="comboMax" property="strStoreId" onchange="getItemCategoryCmb();">
		       						<bean:write name="miscellaneousConsumptionBean" property="strStoreNameValues" filter="false"/>
       		  					</html:select> --%>
							</div>	
			
							<!-- <div class="col-sm-2"></div>	 -->
									
			   				<div class="col-sm-2 text-left">
						   		<label><font color="red">*</font>Item Category</label>
							</div>
							
							<div class="col-sm-3">
								 <div id="itemCatDivId">      
	   								<select name="strItemCategoryId1" class="browser-default custom-select">
			          				 	<bean:write name="miscellaneousConsumptionBean" property="strItemCategoryValues" filter="false"/> 
			          				 	<!-- <option value="0">Select Value</option>  -->
	   								</select>
	      						 </div>
	      						 
	      						 <%-- <div id="itemCatDivId">      
				       				<select name="strItemCategoryId1" class="comboNormal">
				       					<bean:write name="miscellaneousConsumptionBean" property="strItemCategoryValues" filter="false"/>
				       				</select>
				       			</div> --%>
							</div>
							
							 <div class="col-sm-2" style="display: flex; justify-content: flex-end; text-align: center;">
							    <button type="button" id="strSearchItemButtonDivId" class="btn btn-success btn-sm" onclick="getItemSelectPopup();" title="Click to Search Items">
							        <i class="fas fa-search" title="Click to Search Items">&nbsp;<span>Item Finder</span></i>
							    </button>
						 	</div>
					</div>			
	
	<table class='table text-uppercase' align='center'>
	   <tr align="center">
		   	<thead class='thead-dark'>
			   <th  style='font-weight:350 !important ;font-size: 16px !important; width:35%;'>Item/Drug Name</th>
			   <th  style='font-weight:350 !important ;font-size: 16px !important; width:20%;'>Batch/Serial No.</th>
			   <th  style='font-weight:350 !important ;font-size: 16px !important; width:15%;'>Avl Qty</th>
			   <th  style='font-weight:350 !important ;font-size: 16px !important; width:15%;'><font color="red">*</font>Consumption Qty</th>
			   <th  style='font-weight:350 !important ;font-size: 16px !important; width:15%;'><font color="red">*</font>Consumption Unit</th>
		    </thead>
	   </tr>
	</table>
	<div id="id1"></div>


	<div class="row">
		<div class="col-sm-1">
			<label>Remarks</label>
		</div>
		<div class="col-sm-11">
			<textarea name="strRemarks" class="form-control" rows="2" style=""></textarea>
		</div>
   </div>
</div>
   	
	<hr>
		<div class="col-sm-12 text-right"  id="">
			<i class="fas fa-asterisk" style="color: red; font-size: smaller;margin-top: 5px;"></i>Mandatory Fields
		</div>
	<br>

	<input type="hidden" name="hmode"/>
	<input type="hidden" name="strStoreName" value=""/>
	<input type="hidden" name="strReOrderFlgColor"	value="${miscellaneousConsumptionBean.strReOrderFlgColor}">
	<input type="hidden" name="strItemDtlWithIssueQty" id="strItemDtlWithIssueQty" value="0"/>

<cmbPers:cmbPers />

	<div id="blanket" style="display:none;"></div>
	<div class="popUpDiv" id="popUpDiv" style="display:none;">
		<table bgcolor="white">
			<tr>
				<td>
					<div id="searchItemsDtlsDivId" style="display:block;"></div>
				</td>
			</tr>
		</table>
	</div>
</div>
</div>
</html:form>

<jsp:include page="miscellaneous_consumption_item_search_rowNEW.jsp"></jsp:include>

<tag:autoIndex></tag:autoIndex>   

</body>
